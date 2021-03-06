package server;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class ClientHandler {

    public static int TIME_OUT_TIME=5000;

    DataInputStream in;
    DataOutputStream out;
    Server server;
    Socket socket;

    private String nickname;
    private String login;

    public String getNickname() {
        return nickname;
    }

    public ClientHandler(Server server, Socket socket) {


        try {
            this.server = server;
            this.socket = socket;
            in = new DataInputStream(socket.getInputStream());
            out = new DataOutputStream(socket.getOutputStream());
            System.out.println("Client connected" + socket.getRemoteSocketAddress());

            new Thread(() -> {
                try {
                    socket.setSoTimeout(TIME_OUT_TIME);
                    //цикл аутентификации
                    while (true) {
                        String str = in.readUTF();

                        if (str.startsWith("/reg ")) {
                            String[] token = str.split("\\s");
                            if (token.length < 4) {
                                continue;
                            }
                            boolean b = server.getAuthService().registration(
                                    token[1], token[2], token[3]);
                            if(b) {
                                sendMsg("/regok");
                            } else {
                                sendMsg("/regno");
                            }
                        }

                        if (str.startsWith("/auth ")) {
                            String[] token = str.split("\\s");
                            if (token.length < 3) {
                                continue;
                            }
                            String newNick = server.getAuthService().
                                    getNicknameByLoginAndPassword(token[1], token[2]);
                            if (newNick != null) {
                                login = token[1];
                                if (!server.isLoginAuthenticated(login)) {
                                    nickname = newNick;
                                    sendMsg("/authok " + newNick);
                                    server.subscribe(this);
                                    System.out.println("Прошли подключение");
                                    socket.setSoTimeout(0);
                                    System.out.println("Обнулили ожидание");
                                    break;
                                } else {
                                    sendMsg("С этими логином уже вошли в чат");
                                }
                            } else {
                                sendMsg("Неверная пара логин/пароль");
                            }
                        }
                    }

                    //цикл работы
                    while (true) {
                        String str = in.readUTF();

                        if (str.equals("/end")) {
                            System.out.println("Выходим");
                            out.writeUTF("/end");
                            sendMsg("/end");
                            break;
                        }

                        if (str.startsWith("/w ")) {
                            System.out.println("Зашли");
                            String[] receiver = str.split(" ", 3);
                            if (receiver.length > 2) {
                                System.out.println(str);
                                System.out.println("Кому шлем: " + receiver[1]);
                                server.sendMsgToReceiver(this, receiver[1], receiver[2].trim());
                                continue;
                            }
                        }
                        server.broadcastMsg(this, str);
                    }
                }
                catch (SocketTimeoutException e) {
                    System.out.println("Время ожидания подключения истекло");
                    sendMsg("/end");
                }
                catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    server.unsubscribe(this);
                    System.out.println("Client disconnected" + socket.getRemoteSocketAddress());
                    try {
                        socket.close();
                        in.close();
                        out.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }).start();

        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void sendMsg(String msg) {
        try {
            out.writeUTF(msg);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public String getLogin() {
        return login;
    }
}

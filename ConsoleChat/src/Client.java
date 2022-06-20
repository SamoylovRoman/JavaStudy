import java.io.IOException;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

public class Client {

    public static void main(String[] args) {
        Socket socket = null;
        final int PORT = 8189;
        final String IP_ADDRESS = "localhost";

        try {
            socket = new Socket(IP_ADDRESS, PORT);
            System.out.println("Client connected himself");

            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner inputString = new Scanner(System.in);

            //daemon-поток для приема сообщений от сервера по socket
            Thread daemonThread = new Thread(() -> {
                while (true) {
                    String str = in.nextLine();
                    System.out.println("From server: " + str);
                }
            });
            daemonThread.setDaemon(true);


            //обычный поток для приема сообщений из консоли
            Thread controlThread = new Thread(() -> {
                while (true) {
                    String str = inputString.nextLine();

                    if (str.equals("/end")) {
                        System.out.println("Выходим!");
                        break;
                    }

                    out.println(str);
                }
            });

            daemonThread.start();
            controlThread.start();

            try {
                controlThread.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

        }

    }
}

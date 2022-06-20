import java.io.IOException;
import java.io.PrintWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class Server {

    public static void main(String[] args) {
        ServerSocket server = null;
        Socket socket = null;
        final int PORT = 8189;


        try {
            server = new ServerSocket(PORT);
            System.out.println("Server started");

            socket = server.accept();
            System.out.println("Client connected");

            Scanner in = new Scanner(socket.getInputStream());
            PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
            Scanner inputString = new Scanner(System.in);

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

            //daemon-поток для приема сообщений от клиента по socket
            Thread daemonThread = new Thread(() -> {
                while (true) {
                    String str = in.nextLine();
                    System.out.println("From Client: " + str);
                }
            });
            daemonThread.setDaemon(true);

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

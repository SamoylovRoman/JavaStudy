public class Main {
    static final Object monitor = new Object();
    static volatile char currentChar = 'A';
    static final int count = 5;

    public static void main(String[] args) {

        new Thread(() -> {
            for (int i = 0; i < count; i++) {
                synchronized (monitor){
                    while (currentChar!='A'){
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("A");
                    currentChar='B';
                    monitor.notifyAll();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < count; i++) {
                synchronized (monitor){
                    while (currentChar!='B'){
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("B");
                    currentChar='C';
                    monitor.notifyAll();
                }
            }
        }).start();

        new Thread(() -> {
            for (int i = 0; i < count; i++) {
                synchronized (monitor){
                    while (currentChar!='C'){
                        try {
                            monitor.wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    System.out.print("C");
                    currentChar='A';
                    monitor.notifyAll();
                }
            }
        }).start();

    }
}

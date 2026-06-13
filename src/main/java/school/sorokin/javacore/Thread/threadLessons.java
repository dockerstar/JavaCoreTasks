package school.sorokin.javacore.Thread;

public class threadLessons {
    public static Integer count = 1000_000;
    public static void main(String[] args) {
        Thread thread1 = new Thread(()-> {
            for (int i = 0; i<count;i++) {
                System.out.print("x");
            }
        });

        Thread thread2 = new Thread(()-> {
            for (int i = 0; i<count;i++) {
                System.out.print("O");
            }
        });

        thread1.start();
        thread2.start();
    }
}

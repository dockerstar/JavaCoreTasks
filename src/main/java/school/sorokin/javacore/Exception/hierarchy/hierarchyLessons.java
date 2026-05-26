package school.sorokin.javacore.Exception.hierarchy;

public class hierarchyLessons {
    public static void main(String[] args) {
        try {
            runExample(2);
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Обращение к неверному элементу " + e.getClass().getSimpleName());
        } catch (ArithmeticException e) {
            System.out.println("Делить на ноль нельзя " + e.getClass().getSimpleName());
        }  catch (RuntimeException e) {
            System.out.println(e.getMessage());
        }
    }
    public static void runExample(int mode) {
        switch (mode) {
            case 1 -> {
                int b = 10/0;
                System.out.println(b);
            }
            case 2 -> {
                int[] arr = {1,2};
                System.out.println(arr[2]);
            }
            case 3 -> throw new RuntimeException("Исключение");
        }
    }
}

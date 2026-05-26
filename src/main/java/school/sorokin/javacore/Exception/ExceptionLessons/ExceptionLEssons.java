package school.sorokin.javacore.Exception.ExceptionLessons;

public class ExceptionLEssons {
    public static void main(String[] args) {
       try {
           int a = 4;
           int b = 0;
           System.out.println(a / b);
           int[] arr = {1 ,2 ,3};
           System.out.println(arr[3]);
       } catch (ArithmeticException e) {
           System.out.println("Деление на ноль нельзя " + e.getMessage());
       } catch (ArrayIndexOutOfBoundsException e) {
           System.out.println("Ты обратился к несущетсвующему элементу в массиве " + e.getMessage());
       } finally {
           System.out.println("Код в любом случае выполнится");
       }

    }
}

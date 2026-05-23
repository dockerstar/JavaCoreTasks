package school.sorokin.javacore.basics;

public class ArrayLessons {
    public static void main(String[] args) {
        int[] arrayInt = {1,5,4,6};
        for (int arr:arrayInt) {
            System.out.println(arr);
        }
        arrayInt[0] = 200;
        for (int arr:arrayInt) {
            System.out.println(arr);
        }
    }
}

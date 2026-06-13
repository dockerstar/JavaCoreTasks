package school.sorokin.javacore.Reflection.Annotation;

public class Example {
    private String def = "def";

    @MyAnnotation()
    public void print() {
        System.out.println("print");
    }

    @Action(description = "ddd")
    public void scan() {
        System.out.println("start scan");
    }

    @Override
    public String toString() {
        return "Example{" +
                "def='" + def + '\'' +
                '}';
    }
}

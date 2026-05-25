package school.sorokin.javacore.SOLID.Noti;

public class PushNoti implements SendMessage{
    @Override
    public void send() {
        System.out.println("Push sending");
    }
}

package school.sorokin.javacore.SOLID.Noti;

public class SMSNoti implements SendMessage{
    @Override
    public void send() {
        System.out.println("SMS sending");
    }
}

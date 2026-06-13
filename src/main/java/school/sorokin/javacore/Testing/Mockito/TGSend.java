package school.sorokin.javacore.Testing.Mockito;

public class TGSend implements NotificationService{
    @Override
    public String send() {
        return "TG";
    }
}

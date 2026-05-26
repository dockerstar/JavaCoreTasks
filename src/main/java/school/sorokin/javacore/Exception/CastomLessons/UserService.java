package school.sorokin.javacore.Exception.CastomLessons;

public class UserService {
    public void register(String username, int age) {
        if (username==null) throw new UserValidationException("Имя не должно быть пустым");
        if (age<18) throw new UserValidationException("Возраст должен быть больше либо равен 18");
    }
}

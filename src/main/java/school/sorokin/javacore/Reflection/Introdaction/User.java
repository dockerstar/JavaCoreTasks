package school.sorokin.javacore.Reflection.Introdaction;

import java.time.LocalDate;

public class User {
    private String name;
    private LocalDate birthday;
    private String password;

    public User(String name, LocalDate birthday, String password) {
        this.name = name;
        this.birthday = birthday;
        this.password=password;
    }

    private User() {
        this.name = "default";
        this.birthday = LocalDate.now();
        this.password="12345678";
    }
    public String getName() {
        return name;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", birthday=" + birthday +
                ", password='" + password + '\'' +
                '}';
    }

    public LocalDate getBirthday() {
        return birthday;
    }

    private void secretPass(String newPass) {
        this.password=newPass;
    }

}

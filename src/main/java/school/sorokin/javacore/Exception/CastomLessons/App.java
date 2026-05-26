package school.sorokin.javacore.Exception.CastomLessons;

import java.util.logging.Level;
import java.util.logging.Logger;

public class App {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger(App.class.getName());
        UserService userService = new UserService();
        try {
            userService.register(null , 116);
        } catch (UserValidationException e) {
            logger.log(Level.WARNING, e.getMessage());
        }
    }
}

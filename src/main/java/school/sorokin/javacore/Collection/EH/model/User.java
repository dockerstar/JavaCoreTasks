package school.sorokin.javacore.Collection.EH.model;

import java.util.Objects;

public class User {
    private int id;
    private String name;

    public User(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object obj) {
        if(this==obj) return true;
        if (obj==null || getClass()!=obj.getClass()) return false;
        User user = (User) obj;
        return id==user.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

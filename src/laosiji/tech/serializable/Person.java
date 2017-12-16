package laosiji.tech.serializable;

import java.io.Serializable;

public class Person implements Serializable {
    private int age;
    private String name;
    private int sexy;

    public int getSexy() {
        return sexy;
    }

    public void setSexy(int sexy) {
        this.sexy = sexy;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

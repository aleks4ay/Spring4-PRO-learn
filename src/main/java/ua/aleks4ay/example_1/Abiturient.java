package ua.aleks4ay.example_1;

public class Abiturient {
    private String login;
    private String name;
    private int age;

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Abiturient{" +
                "login='" + login + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

package ua.aleks4ay.example_5;

class UserInfo {
    private String name;
    private String password;

    UserInfo(String name, String password) {
        this.name = name;
        this.password = password;
    }

    String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }
}

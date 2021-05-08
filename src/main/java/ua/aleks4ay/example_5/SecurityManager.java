package ua.aleks4ay.example_5;

class SecurityManager{
    private static ThreadLocal<UserInfo> threadLocal = new ThreadLocal<>();

    void login(String name, String password) {
        threadLocal.set(new UserInfo(name, password));
    }

    void logout() {
        threadLocal.set(null);
    }

    UserInfo getLoggetOnUser() {
        return threadLocal.get();
    }
}

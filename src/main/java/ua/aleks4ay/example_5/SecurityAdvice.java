package ua.aleks4ay.example_5;

import org.springframework.aop.MethodBeforeAdvice;

import java.lang.reflect.Method;

class SecurityAdvice implements MethodBeforeAdvice{
    private SecurityManager securityManager;

    SecurityAdvice() {
        this.securityManager = new SecurityManager();
    }

    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        UserInfo user = securityManager.getLoggetOnUser();
        if (user == null) {
            System.out.println("No user authenticated");
            throw new SecurityException("You must login before attempting to invoke the method: " + method.getName());
        } else if (user.getName().equalsIgnoreCase("alex")) {
            System.out.println("Logged in user is alex - ОКАУ!");
        } else {
            System.out.println("Logged in user is: " + user.getName() + " - NOT GOOD!");
            throw new SecurityException("User "+user.getName()+" is not allowed access to method: " + method.getName());
        }
    }
}

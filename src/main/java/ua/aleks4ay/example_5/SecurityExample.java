package ua.aleks4ay.example_5;

import org.springframework.aop.framework.ProxyFactory;

public class SecurityExample {
    public static void main(String[] args) {
        SecurityManager manager = new SecurityManager();
        SecureMessage message = getSecureMessage();
        manager.login("alex", "1234");
        message.writeSecureMessage();
        manager.logout();
        try {
            manager.login ( "invalidUser", "pwd");
            message.writeSecureMessage();
        } catch(SecurityException ex) {
            System.out.println("Exception Caught: " + ex.getMessage());
        } finally {
            manager.logout();
        }

        try {
            message.writeSecureMessage();
        } catch(SecurityException ех) {
            System. out. println ( "Exception Caught: " + ех. getMessage ());
        }
    }

    private static SecureMessage getSecureMessage() {
        SecureMessage message = new SecureMessage();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new SecurityAdvice());
        proxyFactory.setTarget(message);
        return (SecureMessage) proxyFactory.getProxy();
    }
}

package ua.aleks4ay.example_4;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

class MessageDecorator implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation methodInvocation) throws Throwable {
        System.out.print("Hello ");
        Object method = methodInvocation.proceed();
        System.out.println("!");
        return method;
    }
}

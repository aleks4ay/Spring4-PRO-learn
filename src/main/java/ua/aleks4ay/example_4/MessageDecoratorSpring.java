package ua.aleks4ay.example_4;

import org.springframework.aop.MethodBeforeAdvice;
import java.lang.reflect.Method;

class MessageDecoratorSpring implements MethodBeforeAdvice {
    @Override
    public void before(Method method, Object[] objects, Object o) throws Throwable {
        System.out.println("Before method: '" + method.getName() + "'");
        System.out.print("Hello ");
    }
}

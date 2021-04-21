package ua.aleks4ay.example_1;

import org.springframework.beans.factory.support.MethodReplacer;
import java.lang.reflect.Method;

public class FormatMessageReplacer implements MethodReplacer {
    @Override
    public Object reimplement(Object o, Method method, Object[] args) throws Throwable {
        if (isFormatMessageMethod(method)) {
            String msg = (String) args[0];
            return "<h2>" + msg + "</h2>";
        } else {
            return new IllegalArgumentException("UnaЫe to reimplement method " + method.getName());
        }
    }

    private boolean isFormatMessageMethod(Method method) {
        return method.getParameterTypes().length == 1
                && "formatMessage".equals(method.getName())
                && method.getReturnType() == String.class
                && method.getParameterTypes()[0] == String.class;
    }
}
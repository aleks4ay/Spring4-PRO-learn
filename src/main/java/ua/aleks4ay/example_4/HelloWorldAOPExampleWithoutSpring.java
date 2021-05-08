package ua.aleks4ay.example_4;

import org.springframework.aop.framework.ProxyFactory;

public class HelloWorldAOPExampleWithoutSpring {

    public static void main(String[] args) {
        MessageWriter messageWriter = new MessageWriter();
        ProxyFactory proxyFactory = new ProxyFactory();
        proxyFactory.addAdvice(new MessageDecorator());
        proxyFactory.setTarget(messageWriter);
        MessageWriter messageWriterProxy = (MessageWriter) proxyFactory.getProxy();

        System.out.println("without proxy: ");
        messageWriter.writeMessage();
        System.out.println("\nfrom proxy: ");
        messageWriterProxy.writeMessage();
    }
}

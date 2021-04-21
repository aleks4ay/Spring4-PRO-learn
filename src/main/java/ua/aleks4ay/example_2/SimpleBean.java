package ua.aleks4ay.example_2;


import org.springframework.beans.factory.BeanCreationException;
import org.springframework.context.support.GenericXmlApplicationContext;

public class SimpleBean {
    private static final String DEFAULT_NAМE ="Luke Skywalker";
    private String name;
    private int age = Integer.MIN_VALUE;

    public static void main(String[] args) {
        GenericXmlApplicationContext ctx = new GenericXmlApplicationContext();
        ctx.load("classpath:WEB-INF/spring/app2-context.xml");
        ctx.refresh();
        SimpleBean simpleBeanl = getBean("simpleBeanl", ctx);
        SimpleBean simpleBean2 = getBean("simpleBean2", ctx);
        SimpleBean simpleBeanЗ = getBean("simpleBeanЗ", ctx);
    }

    public static String getDefaultNaмe() {
        return DEFAULT_NAМE;
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

    public void init() {
        System.out.println("Initializing bean");
        if (name == null) {
            System.out.println("Using default name");
            name = DEFAULT_NAМE;
        }
        if (age == Integer.MIN_VALUE) {
            throw new IllegalArgumentException("Уоu must set the age property of any beans of type " + SimpleBean.class);
        }
    }

    private static SimpleBean getBean(String name, GenericXmlApplicationContext context) {
        try {
            SimpleBean simpleBean = (SimpleBean) context.getBean(name);
            System.out.println(simpleBean);
            return simpleBean;
        } catch (BeanCreationException ex) {
            System.out.println("An error occured in bean configuration: " + ex.getMessage());
            return null;
        }
    }

    @Override
    public String toString() {
        return "SimpleBean{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
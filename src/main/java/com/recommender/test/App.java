package com.recommender.test;

/**
 * Created by swara on 16/01/2017.
 */
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class App {
    public static void main(String[] args) {

        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);


        //shut down the Spring context.
        ((ConfigurableApplicationContext)context).close();

    }
}

package ua.kpi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ua.kpi.controller.ApplicationController;


@SpringBootApplication
public class SpringApplicationMain implements CommandLineRunner {

    @Autowired
    private ApplicationController applicationController;

    public static void main(String[] args) {
        SpringApplication.run(SpringApplicationMain.class, args);
    }

    @Override
    public void run(String... args) {
        applicationController.processActionControl();
    }

}

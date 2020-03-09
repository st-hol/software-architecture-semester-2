package ua.kpi.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import ua.kpi.ui.util.ApplicationView;
import ua.kpi.ui.util.InputProvider;

import java.util.Scanner;

@Configuration
public class ApplicationConfig {

    @Bean
    public Scanner scanner() {
        return new Scanner(System.in);
    }

    @Bean
    public ApplicationView applicationView() {
        return new ApplicationView();
    }

    @Bean
    public InputProvider inputProvider(Scanner scanner) {
        return new InputProvider(scanner);
    }


}

package com.todoapp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.todoapp.model.User;
import com.todoapp.repository.UserRepository;
import org.apache.logging.log4j.LogManager;
import org.springframework.context.annotation.ComponentScan;

@ComponentScan(basePackages = {"com.todoapp"})
@SpringBootApplication
public class TodoApplication implements CommandLineRunner {

    private static org.apache.logging.log4j.Logger LOGGER = LogManager.getLogger(TodoApplication.class);

    @Autowired
    private UserRepository userRepository;

    public static void main(String[] args) {
        LOGGER.info("STARTING THE APPLICATION");
        SpringApplication.run(TodoApplication.class, args);
        LOGGER.info("APPLICATION STARTED");
    }

    @Override
    public void run(String... args) throws Exception {
        createSampleDataForUser("Software Developer", "Zeynep", "Coskun", "coskunzeynep@gmail.com");
        createSampleDataForUser("Team Leader", "XX", "YY", "xxxxyyyyy@gmail.com");
        createSampleDataForUser("System Architect", "qq", "rr", "qrrrrrrr@gmail.com");
        createSampleDataForUser("Project Manager", "Work", "DoComplete", "wdwwwwwwwwww@gmail.com");
    }

    public void createSampleDataForUser(String title, String name, String surname, String email) {

        User myuser = new User();
        myuser.setTitle(title);
        myuser.setFirstName(name);
        myuser.setLastName(surname);
        myuser.setEmail(email);
        userRepository.save(myuser);

    }
}

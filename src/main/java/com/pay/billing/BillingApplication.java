package com.pay.billing;

import com.pay.billing.domain.dto.RoleDTO;
import com.pay.billing.domain.model.User;
import com.pay.billing.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.Arrays;

@SpringBootApplication
public class BillingApplication implements CommandLineRunner {

    public static void main(String[] args) {
        SpringApplication.run(BillingApplication.class, args);
    }

    @Bean
    public ModelMapper modelMapper() {
        return new ModelMapper();
    }

    @Autowired
    UserService userService;

    @Override
    public void run(String... params) throws Exception {
        User admin = new User();
        admin.setUsername("admin");
        admin.setPassword("admin");
        admin.setEmail("admin@email.com");
        admin.setRoleDTOS(new ArrayList<RoleDTO>(Arrays.asList(RoleDTO.ROLE_ADMIN)));

        userService.signup(admin);
    }
}

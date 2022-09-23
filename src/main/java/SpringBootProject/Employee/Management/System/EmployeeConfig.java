package SpringBootProject.Employee.Management.System;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDate;
import java.util.Arrays;

@Configuration
public class EmployeeConfig {

    @Bean
    CommandLineRunner commandLineRunner(EmployeeRepository employeeRepository){
        return args -> {
            Employee syed = new Employee(
                    "Syed Azril",
                    "syed.muhayyat@gmail.com",
                    3000,
                    "014-3498103",
                    "Simpang Ampat, Perlis",
                    LocalDate.of(2022, 10, 27)
                    );

            Employee sam = new Employee(
                    "Sammy Holland",
                    "sam.holand@gmail.com",
                    3500,
                    "019-3998109",
                    "Brooklyn, New York",
                    LocalDate.of(2020, 10, 1)
            );
            employeeRepository.saveAll(Arrays.asList(syed,sam));

        };
    }
}

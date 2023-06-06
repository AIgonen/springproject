package com.bpw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@SpringBootApplication
//@ComponentScan(basePackages = "com.bpw")
//@EnableAutoConfiguration
@RestController
@RequestMapping("api/v1/customers")
public class Main {

    private final CustomerRepository customerRepository;

    public Main(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public static void main(String[] args) {SpringApplication.run(Main.class, args);}

    @GetMapping
    public List<Customer> getCustomer() {
        return customerRepository.findAll();
    }
    // @GetMapping("/greet")
    // public GreetResponse greet() {
    //     return new GreetResponse(
    //             "Hello",
    //             List.of("Java", "Golang", "C#"),
    //             new Person("Alex", 30, 50000)
    //     );
    // }
    // record Person(String name, int age, double savings) {
    //
    // }
    // record GreetResponse (String greet, List<String> languages, Person person) {
    //
    // }
}

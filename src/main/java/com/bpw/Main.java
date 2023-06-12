package com.bpw;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.web.bind.annotation.*;

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

    record NewCustomerRequest(String name, String email, int age) {

    }
    @PostMapping
    public void addCustomer(@RequestBody NewCustomerRequest request) {
        Customer customer = new Customer();
        customer.setName(request.name());
        customer.setEmail(request.email());
        customer.setAge(request.age());
        customerRepository.save(customer);
    }

    @DeleteMapping("{customerId}")
    public void deleteCustomer(@PathVariable("customerId") Integer id) {
        customerRepository.deleteById(id);
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

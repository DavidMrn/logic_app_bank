package com.logsoluprobl.appbank.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.logsoluprobl.appbank.exception.DomainException;
import com.logsoluprobl.appbank.model.Customer;
import com.logsoluprobl.appbank.service.BankService;

@RestController // Indica a Java que esta clase es la que va a mostrar la ruta.
@RequestMapping("/api/bank") // Dice a Java que la app buscará una ruta en especifico.

public class BankController {

    private final BankService bankService;

    public BankController(BankService bankService){
        this.bankService = bankService;
    }

    // DTO(Data Transfer Object) Para Crear Cuentas.

    public static class AccountCreationRequest {
        public String type;
        public String account;
        public String parameter;       
    } 

    // Ruta para clientes 
    @PostMapping("/customers")
    public ResponseEntity<Customer> createCustomer(@RequestBody Customer customer){
        try {
            Customer createdCustomer = bankService
            .createCustomer(customer.getId(), customer.getName(), customer.getEmail());

            return ResponseEntity.status(HttpStatus.CREATED)
            .body(createdCustomer);

        } catch (DomainException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }


    @GetMapping("/customers")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        List<Customer> customers = bankService.getAllCustomers();

        return ResponseEntity.ok(customers);
    }


    @GetMapping("/customers/{customerId}")
    public ResponseEntity<Customer> findCustomerById (@PathVariable String customerId){
        Customer customer = bankService.findCustomerById(customerId);
        return customer != null ? ResponseEntity.ok(customer): ResponseEntity.notFound().build();
    }


}

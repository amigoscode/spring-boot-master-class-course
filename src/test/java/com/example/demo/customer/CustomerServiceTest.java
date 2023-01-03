package com.example.demo.customer;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class CustomerServiceTest {

    @Autowired
    private CustomerRepository customerRepository;
    private  CustomerService underTest;

    @BeforeEach
    void setUp() {
        underTest = new CustomerService(customerRepository);
    }

    @AfterEach
    void tearDown() {
        customerRepository.deleteAll();
    }

    @Test
    void getCustomers() {
        Customer jammy = new Customer(1L,
                "jammy", "jammy@gmail.com","sup");
        Customer sammy = new Customer(2L,
                "sammy ", "sammy@gmail.com","sup");

        customerRepository.saveAll(Arrays.asList(jammy, sammy));

        List<Customer> customers = underTest.getCustomers();

        assertEquals(2, customers.size());
    }

    @Test
    void getCustomer() {
        //given
        Customer jammy = new Customer(1L,
                "jammy", "jammy@gmail.com","sup");

        customerRepository.save(jammy);

        //when
        Customer actual = underTest.getCustomer(1L);

        //then
        assertEquals(1L, actual.getId());
        assertEquals("jammy", actual.getName());
//        assertEquals("sup", actual.getPassword());
        assertEquals("jammy@gmail.com", actual.getEmail());

    }
}
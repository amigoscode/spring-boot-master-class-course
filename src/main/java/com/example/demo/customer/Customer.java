package com.example.demo.customer;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;

@Entity
@Table
public class Customer {

        @Id
        private  Long id;

        @NotBlank(message = "name must not be empty")
        private String name;

        @NotBlank(message = "email must not be empty")
        @Email(message = "must have email")
        private String email;

        private String password;

        Customer(Long id, String name, String email, String password) {
            this.id = id;
            this.name = name;
            this.email = email;
            this.password = password;
        }

    public Customer() {

    }

    public Long getId() {
            return id;
        }


        public String getName() {
            return name;
        }

        public String getEmail() {
            return email;
        }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }
}

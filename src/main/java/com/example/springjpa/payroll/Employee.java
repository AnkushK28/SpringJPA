package com.example.springjpa.payroll;
import lombok.Data;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Objects;
        import javax.persistence.Entity;
        import javax.persistence.GeneratedValue;
        import javax.persistence.Id;
 @Entity
 @Data
public class Employee
{

         @Id
         @GeneratedValue
        private Long Id;
        private String Name;
        private String Role;
        private String Address;

    }







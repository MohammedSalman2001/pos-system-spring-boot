package com.possystem.possystemapi.repo;


import com.possystem.possystemapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface CustomerRepo extends JpaRepository<Customer,String> {

}

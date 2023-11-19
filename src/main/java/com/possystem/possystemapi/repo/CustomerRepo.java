package com.possystem.possystemapi.repo;


import com.possystem.possystemapi.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

@EnableJpaRepositories
@Repository
public interface CustomerRepo extends JpaRepository<Customer,String> {

    public boolean existsByNic(String nic);

    @Modifying
    @Query(nativeQuery = true, value = "UPDATE  customer SET name=?,address=?,salary=? WHERE nic=?")
    public void updateCustomer(String name,String address,double salary,String nic);
}

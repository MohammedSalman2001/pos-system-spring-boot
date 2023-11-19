package com.possystem.possystemapi.repo;


import com.possystem.possystemapi.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ItemRepo extends JpaRepository<Item,String> {


}

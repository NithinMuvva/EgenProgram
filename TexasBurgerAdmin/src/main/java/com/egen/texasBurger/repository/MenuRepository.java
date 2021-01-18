package com.egen.texasBurger.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import com.egen.texasBurger.model.Menu;

@Repository
public interface MenuRepository extends MongoRepository<Menu, String> {
	Optional<Menu> findByMid(String mid);
    List<Menu> findByMtype(String mtype);
    Menu findByItem(String Item);
}

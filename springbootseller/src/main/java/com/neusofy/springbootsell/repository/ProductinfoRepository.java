package com.neusofy.springbootsell.repository;

import com.neusofy.springbootsell.dataobject.Productinfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductinfoRepository extends JpaRepository<Productinfo,String> {
}

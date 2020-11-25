package com.neusoft.springbootsell.repository;

import com.neusoft.springbootsell.dataobject.Productinfo;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductinfoRepository extends JpaRepository<Productinfo,String> {
}

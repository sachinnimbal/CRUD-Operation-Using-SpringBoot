package com.crud.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.crud.entity.Crud;

@Repository
public interface CrudRepository extends JpaRepository<Crud, Integer> {

}
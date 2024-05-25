package com.crud.service;

import java.util.List;

import com.crud.entity.Crud;

public interface CrudService {

	void addData(Crud crud);

	List<Crud> getAllData();

	void updateData(Crud crud);

	void deleteData(int id);

	Crud getDataById(int id);

}

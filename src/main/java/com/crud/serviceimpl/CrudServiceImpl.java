package com.crud.serviceimpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.crud.entity.Crud;
import com.crud.repository.CrudRepository;
import com.crud.service.CrudService;

@Service
public class CrudServiceImpl implements CrudService {

	@Autowired
	CrudRepository crudRepository;

	@Override
	public void addData(Crud crud) {
		crudRepository.save(crud);
	}

	@Override
	public List<Crud> getAllData() {
		return crudRepository.findAll();
	}

	@Override
	public void updateData(Crud crud) {
		if (crudRepository.existsById(crud.getId())) {
			crudRepository.save(crud);
		}
	}

	@Override
	public void deleteData(int id) {
		crudRepository.deleteById(id);
	}

	@Override
	public Crud getDataById(int id) {
		return crudRepository.findById(id).orElse(null);
	}

}

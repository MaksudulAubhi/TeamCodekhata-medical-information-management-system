package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Employee;
import com.example.demo.model.Ward;
import com.example.demo.repository.WardRepository;

@Service
public class WardeServiceImplementation implements WardService {
	
	@Autowired
	private WardRepository wardRepository;

	@Override
	public void saveWard(Ward ward) {
		wardRepository.save(ward);

	}

	@Override
	public List<Ward> getAllWards() {
		List<Ward> wardList=new ArrayList<Ward>();
		wardRepository.findAll().forEach(e->wardList.add(e));
		return wardList;
	}

	@Override
	public boolean deleteWard(int id) {
		try {
			wardRepository.deleteById(id);
			return true;
		}catch(Exception ex){
			return false;
		}
	}

}

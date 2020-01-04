package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Financial;

import com.example.demo.repository.FinancialRepository;

@Service

public class FinancialServiceImplementation implements FinancialService {
	@Autowired
	private FinancialRepository financialRepository;
	
	@Override
	public void saveReport(Financial financial) {
		financialRepository.save(financial);

	}

	@Override
	public List<Financial> getAllReport() {
		List<Financial>billingList=new ArrayList<Financial>();
		financialRepository.findAll().forEach(e-> billingList.add(e));
		return billingList;
	}

	@Override
	public boolean deleteReport(int id) {
		try {
			financialRepository.deleteById(id);
			return true;
		}catch(Exception ex){
			return false;
		}
	}

}

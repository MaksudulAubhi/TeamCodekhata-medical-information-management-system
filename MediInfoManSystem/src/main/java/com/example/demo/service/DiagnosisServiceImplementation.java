package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Diagnosis;
import com.example.demo.repository.DiagnosisRepository;

@Service
public class DiagnosisServiceImplementation implements DiagnosisService {
    
	@Autowired
	private DiagnosisRepository diagnosisRepository;
	
	
	@Override
	public void saveDiagnosis(Diagnosis diagnosis) {
		diagnosisRepository.save(diagnosis);

	}

	@Override
	public List<Diagnosis> getAllDiagnosis() {
		List<Diagnosis>diagnosisReportList=new ArrayList<Diagnosis>();
		diagnosisRepository.findAll().forEach(e->diagnosisReportList.add(e));
		return diagnosisReportList;
	}

	@Override
	public boolean deletediagnosis(int id) {
		try {
			diagnosisRepository.deleteById(id);
			return true;
		}catch(Exception ex){
			return false;
		}
	}

}

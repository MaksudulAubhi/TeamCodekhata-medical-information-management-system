package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import com.example.demo.model.Prescription;
import com.example.demo.repository.PrescriptionRepository;

@Service
public class PrescriptionServiceImplementation implements PrescriptionService {
	@Autowired
	private PrescriptionRepository prescriptionRepository;
	
	
	@Override
	public void savePrescription(Prescription prescription) {
		prescriptionRepository.save(prescription);
	}
	
	@Override
	public List<Prescription>getAllPrescriptin() {
		List<Prescription>prescriptionList=new ArrayList<Prescription>();
		prescriptionRepository.findAll().forEach(e->prescriptionList.add(e));
		return prescriptionList;
	}
	
	@Override
	public boolean deletePrescription(int id) {
		try {
			prescriptionRepository.deleteById(id);
			return true;
		}catch(Exception ex){
			return false;
		}
	}
	
	

}

package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.PatientBilling;
import com.example.demo.repository.BillingRepository;

@Service
public class BillingServiceImplementation implements BillingService {
	@Autowired
	private BillingRepository patientBillingRepository;
	
	@Override
	public void saveBilling(PatientBilling patientBilling) {
		patientBillingRepository.save(patientBilling);

	}

	@Override
	public List<PatientBilling> getAllBilling() {
		List<PatientBilling>billingList=new ArrayList<PatientBilling>();
		patientBillingRepository.findAll().forEach(e-> billingList.add(e));
		return billingList;
	}

	@Override
	public boolean deleteBilling(int id) {
		try {
			patientBillingRepository.deleteById(id);
			return true;
		}catch(Exception ex){
			return false;
		}
	}

}

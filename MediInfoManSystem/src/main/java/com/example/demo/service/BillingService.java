package com.example.demo.service;

import java.util.List;

import com.example.demo.model.PatientBilling;


public interface BillingService {
	public void saveBilling(PatientBilling patientBilling);
	public List getAllBilling();
	public boolean deleteBilling(int id);
}

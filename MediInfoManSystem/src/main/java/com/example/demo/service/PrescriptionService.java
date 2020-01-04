package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Prescription;

public interface PrescriptionService {
	public void savePrescription(Prescription prescription);
	public List getAllPrescriptin();
	public boolean deletePrescription(int id);

}

package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Pharmacy;


public interface PharmacyService {
	public void saveMedicine(Pharmacy pharmacy);
	public List getAllMedicine();
	public boolean deleteTransport(int id);
}

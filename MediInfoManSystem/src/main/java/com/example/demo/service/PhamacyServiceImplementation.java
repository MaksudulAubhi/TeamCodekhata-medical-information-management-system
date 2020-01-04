package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Pharmacy;
import com.example.demo.model.Transport;
import com.example.demo.repository.PharmacyRepository;
import com.example.demo.repository.TransportRepository;

@Service
public class PhamacyServiceImplementation implements PharmacyService {
	@Autowired
	private PharmacyRepository pharmacyRepository;
	@Override
	public void saveMedicine(Pharmacy pharmacy) {
		pharmacyRepository.save(pharmacy);

	}

	@Override
	public List<Pharmacy> getAllMedicine() {
		List<Pharmacy>medicineList=new ArrayList<Pharmacy>();
		pharmacyRepository.findAll().forEach(e-> medicineList.add(e));
		return medicineList;
	}

	@Override
	public boolean deleteTransport(int id) {
		try {
			pharmacyRepository.deleteById(id);
			return true;
		}catch(Exception ex){
			return false;
		}
	}

}

package com.example.demo.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.model.Transport;
import com.example.demo.repository.TransportRepository;
@Service
public class TransportServiceImplementation implements TransportService {
	@Autowired
	private TransportRepository transportRepository;
	
	@Override
	public void saveTransport(Transport transport) {
		transportRepository.save(transport);

	}

	@Override
	public List<Transport> getAllTransport() {
		List<Transport>transportList=new ArrayList<Transport>();
		transportRepository.findAll().forEach(e-> transportList.add(e));
		return transportList;
	}

	@Override
	public boolean deleteTransport(int id) {
		try {
			transportRepository.deleteById(id);
			return true;
		}catch(Exception ex){
			return false;
		}
	}

}

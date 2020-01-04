package com.example.demo.service;

import java.util.List;


import com.example.demo.model.Transport;

public interface TransportService {
	public void saveTransport(Transport transport);
	public List getAllTransport();
	public boolean deleteTransport(int id);
}

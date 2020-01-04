package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Financial;


public interface FinancialService {
	public void saveReport(Financial financial);
	public List getAllReport();
	public boolean deleteReport(int id);
}

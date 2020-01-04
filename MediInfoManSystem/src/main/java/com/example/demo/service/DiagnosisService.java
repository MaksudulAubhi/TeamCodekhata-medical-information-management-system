package com.example.demo.service;

import java.util.List;

import com.example.demo.model.Diagnosis;


public interface DiagnosisService {
	public void saveDiagnosis(Diagnosis diagnosis);
	public List getAllDiagnosis();
	public boolean deletediagnosis(int id);
}

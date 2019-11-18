package com.example.demo.service;

import java.util.List;


import com.example.demo.model.Ward;

public interface WardService {
	public void saveWard(Ward ward);

	public List getAllWards();
	public boolean deleteWard(int id);
}

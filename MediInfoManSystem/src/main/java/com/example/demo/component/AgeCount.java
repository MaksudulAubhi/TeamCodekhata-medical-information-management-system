package com.example.demo.component;

import java.time.LocalDate;

import java.time.temporal.ChronoUnit;



 // user age count 
public class AgeCount {
	public String ageCount(int birthyear,int birthmonth, int birthdate) {
		LocalDate now = LocalDate.now();
        LocalDate birthDate = LocalDate.of(birthyear,birthmonth,birthdate);  
        long age= ChronoUnit.YEARS.between(birthDate,now);
		return String.valueOf(age);
		
	}

	
}

package com.ruda.input;

import java.util.Scanner;

import com.ruda.salgrade.SalgradeDTO;

public class SalgradeInput {
	
	private Scanner sc;
	
	public SalgradeInput() {
		sc = new Scanner(System.in);
	}

	public int gradeInput() {
		System.out.println("등급을 입력하세요");
		int grade = 0;
		
		grade = sc.nextInt();
		return grade;
	}
	
	public SalgradeDTO insert() {
	SalgradeDTO salgradeDTO = new SalgradeDTO();
	System.out.println("Grade 입력");
	salgradeDTO.setGrade(sc.nextInt());
	System.out.println("Losal 입력");
	salgradeDTO.setLosal(sc.nextInt());
	System.out.println("Hisal 입력");
	salgradeDTO.setHisal(sc.nextInt());
	
	return salgradeDTO;
	}
	
}

package com.ruda.view;

import java.util.ArrayList;

import com.ruda.salgrade.SalgradeDTO;

public class SalgradeView {
	
	//전체 조회
	public void view(ArrayList<SalgradeDTO> ar) {
		for(SalgradeDTO salgradeDTO : ar) {
			this.view(salgradeDTO);
			}
	}
	
	
	
	//str문 출력
	public void view(String str) {
		System.out.println(str);
	}
	
	//grade 받아서 조회
	public void view(SalgradeDTO salgradeDTO) {
		System.out.println("============================");
		System.out.println("GRADE : "+salgradeDTO.getGrade());
		System.out.println("LOSAL : "+ salgradeDTO.getLosal());
		System.out.println("HISAL : "+ salgradeDTO.getHisal());

	}
}

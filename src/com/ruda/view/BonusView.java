package com.ruda.view;

import java.util.ArrayList;

import com.ruda.bonus.BonusDTO;

public class BonusView {

	public void view(String str) {
		System.out.println(str);
	}
	
	
	
	public void selectList(ArrayList<BonusDTO> ar) {
		for(BonusDTO bonusDTO : ar) {
			this.SelectOne(bonusDTO);
		}
	}

	public void SelectOne(BonusDTO bonusDTO) {
		System.out.println("========================");
		System.out.println("ENAME : " + bonusDTO.getEname());
		System.out.println("JOB : " + bonusDTO.getJob());
		System.out.println("SAL : " + bonusDTO.getSal());
		System.out.println("COMM : " + bonusDTO.getComm());
	}


}

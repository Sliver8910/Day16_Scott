package com.ruda.view;

import java.util.ArrayList;

import com.ruda.dept.DeptDTO;

public class DeptView {
	public void view(ArrayList<DeptDTO> ar) {
		for(DeptDTO deptDTO : ar) {
			this.view(deptDTO);
		}
		
	}
	
	
	
	public void view(String str) {
		System.out.println(str);
		
	}

	
	public void view(DeptDTO deptDTO) {
		System.out.println("========================================================");
		System.out.println("DEPTNO : "+deptDTO.getDepno());
		System.out.println("DNAME : "+deptDTO.getDname());
		System.out.println("LOC : "+deptDTO.getLoc());
		
		
	}
}

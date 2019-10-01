package com.ruda.view;

import java.util.ArrayList;

import com.ruda.emp.EmpDTO;

public class EmpView {
	//모든사원정보 출력하는 view 메서드
	public void view(ArrayList<Object> ar) {

		for(int i=1;i<ar.size() ;i++) {
			System.out.println("=========================================");
			System.out.println("EMPNO : " +ar.get(i));
			System.out.println("ENAME : "+ ar.get(i+1));
			System.out.println("JOB : "+ar.get(i+2));
			System.out.println("MGR : "+ar.get(i+3));
			System.out.println("HIREDATE : "+ar.get(i+4));
			System.out.println("SAL : "+ar.get(i+5));
			System.out.println("COMM : "+ar.get(i+6));
			System.out.println("DEPTNO : "+ar.get(i+7));
			i=i+8;
		}
	}
	
	public void view(String str) {
		System.out.println(str);
		
	}

	public void view(EmpDTO empDTO) {
		System.out.println("EMPNO : " +empDTO.getEmpno());
		System.out.println("ENAME : "+empDTO.getEname());
		System.out.println("JOB : "+empDTO.getJob());
		System.out.println("MGR : "+empDTO.getMgr());
		System.out.println("HIREDATE : "+empDTO.getHiredate());
		System.out.println("SAL : "+empDTO.getSal());
		System.out.println("COMM : "+empDTO.getComm());
		System.out.println("DEPTNO : "+empDTO.getDeptno());
		
		
	}

}

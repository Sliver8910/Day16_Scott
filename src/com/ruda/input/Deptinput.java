package com.ruda.input;

import java.util.Scanner;

import com.ruda.dept.DeptDTO;

public class Deptinput {
	
	private Scanner sc;
	
	public Deptinput() {
		sc = new Scanner(System.in);
	}
	
	public int deptnoInput() {
		System.out.println("부서번호를 입력하세요");
		int deptno = 0;

		deptno = sc.nextInt();
		return deptno;
	}
	
	public DeptDTO insert() {
		DeptDTO deptDTO = new DeptDTO();
		System.out.println("부서번호 입력");
		deptDTO.setDepno(sc.nextInt());
		System.out.println("부서이름 입력");
		deptDTO.setDname(sc.next());
		System.out.println("지역 입력");
		deptDTO.setLoc(sc.next());
	
		return deptDTO;
	}

}

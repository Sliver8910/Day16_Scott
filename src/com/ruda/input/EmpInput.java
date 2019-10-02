package com.ruda.input;

import java.util.Scanner;

import com.ruda.emp.EmpDTO;

public class EmpInput {

	private Scanner sc;

	public EmpInput() {
		sc = new Scanner(System.in);
	}
	//empnoinput
	//사원번호를 입력하세요

	public int empnoInput() {
		System.out.println("사원번호를 입력하세요");
		int empno = 0;

		empno = sc.nextInt();
		return empno;
	}
	
	public EmpDTO insert() {
		EmpDTO empDTO = new EmpDTO();
		System.out.println("사원번호 입력");
		empDTO.setEmpno(sc.nextInt());
		System.out.println("사원이름 입력");
		empDTO.setEname(sc.next());
		System.out.println("JOB 입력");
		empDTO.setJob(sc.next());
		System.out.println("MGR 입력");
		empDTO.setMgr(sc.nextInt());
		System.out.println("SAL 입력");
		empDTO.setSal(sc.nextInt());
		System.out.println("COMM 입력");
		empDTO.setComm(sc.nextInt());
		System.out.println("부서번호 입력");
		empDTO.setDeptno(sc.nextInt());
		return empDTO;

	}
}

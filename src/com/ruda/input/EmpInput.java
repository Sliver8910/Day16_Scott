package com.ruda.input;

import java.util.Scanner;

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


}

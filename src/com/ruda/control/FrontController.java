package com.ruda.control;

import java.util.Scanner;

public class FrontController {
	
	private Scanner sc;
	private Empcontroller empcontroller;
	private Deptcontroller deptcontroller;
	private BonusController bonusController;
	private SalgradeController salgradeController;
	
	public FrontController() {
		sc= new Scanner(System.in);
		empcontroller = new Empcontroller();
		deptcontroller = new Deptcontroller();
		bonusController = new BonusController();
		salgradeController = new SalgradeController();
	}
	
	public void start() {
		boolean check = true;
		int select =0;
		
		while(check) {
			System.out.println("1. 사원관리");
			System.out.println("2. 부서관리");
			System.out.println("3. Salgrade 관리");
			System.out.println("4. 보너스 관리");
			System.out.println("5. 종      료");
			select = sc.nextInt();
			
			switch (select) {
			case 1:
				empcontroller.start();
				break;
				
			case 2:
				deptcontroller.start();
				break;
				
			case 3:
				salgradeController.start();
				break;
				
			case 4:
				bonusController.start();
				break;

			default:
				System.out.println("프로그램 종료");
				check = !check;
				break;
			}
		}
		
		
		
	}

}

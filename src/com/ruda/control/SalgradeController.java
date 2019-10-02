package com.ruda.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.ruda.input.SalgradeInput;
import com.ruda.salgrade.SalgradeDAO;
import com.ruda.salgrade.SalgradeDTO;
import com.ruda.view.SalgradeView;

public class SalgradeController {

	private Scanner sc;

	public SalgradeController() {
		sc = new Scanner(System.in);
	}

	public void start() {



		SalgradeDTO salgradeDTO = new SalgradeDTO();
		SalgradeDAO salgradeDAO = new SalgradeDAO();
		SalgradeInput salgradeInput = new SalgradeInput();
		SalgradeView salgradeView = new SalgradeView();
		ArrayList<SalgradeDTO> ar = new ArrayList<SalgradeDTO>();
		boolean check = true;
		while(check) {
			System.out.println("1. 전체정보출력");	
			System.out.println("2. 등  급  검  색");
			System.out.println("3. 등  급  추  가");
			System.out.println("4. 등  급  삭  제");
			System.out.println("5. 종            료");
			int select = sc.nextInt();
			switch (select) {
			case 1 :
				ar = salgradeDAO.getSelectList();
				salgradeView.view(ar);
				break;

			case 2 :
				int grade = salgradeInput.gradeInput();
				salgradeDTO = salgradeDAO.getSelectOne(grade);
				salgradeView.view(salgradeDTO);
				break;

			case 3 :
				salgradeDTO = salgradeInput.insert();
				select = salgradeDAO.salInsert(salgradeDTO);
				String s = "Insert Fail";
				if(select>0) {
					s = "Insert Seccess";
				}
				salgradeView.view(s);
				break;

			case 4 :
				grade = salgradeInput.gradeInput();
				select = salgradeDAO.salDelete(grade);
				String a="보너스제거실패";
				if(select>0) {
					a="보너스제거성공";
				}
				salgradeView.view(a);
				break;

			default:
				System.out.println("프로그램을 종료합니다.");
				check = !check;
				break;
			}
		}
	}


}

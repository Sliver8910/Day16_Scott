package com.ruda.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.ruda.dept.DeptDAO;
import com.ruda.dept.DeptDTO;
import com.ruda.input.Deptinput;
import com.ruda.view.DeptView;

public class Deptcontroller {
	
	public void start() {
		Scanner sc = new Scanner(System.in);
		DeptDAO deptDAO = new DeptDAO();
		DeptView deptView = new DeptView();
		ArrayList<DeptDTO> ar = deptDAO.getSelectList();
		Deptinput deptinput = new Deptinput();
		
		boolean check = true;
		while(check) {
			System.out.println("1. 부서전체정보 출력");
			System.out.println("2. 부서검색출력");
			System.out.println("3. 부서정보 추가");
			System.out.println("4. 종료");
			int select = sc.nextInt();
			switch (select) {
			case 1:
				if(ar.size() !=0) {
					deptView.view(ar);
				}else {
					deptView.view("값이 없습니다");
				}
				break;
				
			case 2:
				
				int deptno = deptinput.deptnoInput();
				DeptDTO deptDTO = deptDAO.getSelectOne(deptno);
				if(deptDTO !=null) {
					deptView.view(deptDTO);
				}else {
					deptView.view("없는 부서 입니다");
				}
				break;
				
			case 3:
				deptDTO = deptinput.insert();
				deptDAO.deptInsert(deptDTO);
				
				break;

			default:
				System.out.println("시스템을 종료합니다");
				check = !check;
				break;
			}
			
		}
		
	}

}

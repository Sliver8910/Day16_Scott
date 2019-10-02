package com.ruda.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.ruda.emp.EmpDAO;
import com.ruda.emp.EmpDTO;
import com.ruda.input.EmpInput;
import com.ruda.view.EmpView;

public class Empcontroller {
	//start메서드 실행
	//1. 사원전체정보 출력
	//2. 사원검색출력
	//3. 종료
	//com.iu.dept.DeptDTO
	//com.iu.dept.DeptDAO
	//com.iu.view.DeptView
	//com.iu.input.Deptinput
	//com.iu.control.Deptcontroller

	public void start() {
		Scanner sc = new Scanner(System.in);
		EmpDAO empDAO = new EmpDAO();
		EmpView empView = new EmpView();
		EmpInput empInput= new EmpInput();
		ArrayList<Object> ar = empDAO.getSelectList();
		boolean check = true;
		while(check) {

			System.out.println("1. 사원전체정보 출력");
			System.out.println("2. 사원검색출력");
			System.out.println("3. 사원정보 추가");
			System.out.println("4. 종료");
			int select = sc.nextInt();
			switch (select) {


			case 1:
				if(ar.size() !=0) {
					empView.view(ar);
				}else {
					empView.view("값이 없습니다");
				}
				break;

			case 2:
				
				int empno = empInput.empnoInput();
				EmpDTO empDTO = empDAO.getSelectOne(empno);
				if(empDTO != null) {
					empView.view(empDTO);
				}else {
					empView.view("없는 사원 입니다");
				}

				break;
				
			case 3:
				empDTO = empInput.insert();
				empDAO.insert(empDTO);
				
				break;

			default:
				System.out.println("시스템을 종료합니다");
				check = !check;
				break;
			}
		}


	}



}

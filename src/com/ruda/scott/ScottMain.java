package com.ruda.scott;

import java.util.ArrayList;

import com.ruda.emp.EmpDAO;
import com.ruda.emp.EmpDTO;
import com.ruda.view.EmpView;

public class ScottMain {

	public static void main(String[] args) {
		
		EmpDAO empDAO = new EmpDAO();
		EmpView empView = new EmpView();
		EmpDTO empDTO = empDAO.getSelectOne(7566);
		if(empDTO != null) {
			empView.view(empDTO);
		}else {
			empView.view("없는 사원 입니다");
		}
		ArrayList<Object> ar = empDAO.getSelectList();
		empView.view(ar);
		

	}

}

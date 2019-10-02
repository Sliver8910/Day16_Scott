package com.ruda.control;

import java.util.ArrayList;
import java.util.Scanner;

import com.ruda.bonus.BonusDAO;
import com.ruda.bonus.BonusDTO;
import com.ruda.input.BonusInput;
import com.ruda.view.BonusView;

public class BonusController {
	
	public void start() {
		
		Scanner sc = new Scanner(System.in);
		BonusDAO bonusDAO = new BonusDAO();
		BonusView bonusView = new BonusView();
		BonusInput bonusInput = new BonusInput();
		ArrayList<BonusDTO> ar = bonusDAO.getBonusList();
		
		boolean check = true;
		while(check) {
			System.out.println("1. 보너스전체정보 출력");
			System.out.println("2. 보너스 검색출력");
			System.out.println("3. 보너스 정보 추가");
			System.out.println("4. 보너스 정보 삭제");
			System.out.println("5. 종료");
			int select = sc.nextInt();
			
			switch (select) {
			case 1:
				if(ar.size() !=0) {
					bonusView.
				}
				
				break;
			case 2:
				String ename = bonusInput.bonusenameInput();
				BonusDTO bonusDTO = bonusDAO.getBonusOne(ename);
				if(bonusDTO !=null) {
					
				}else {
					bonusView.view("정보없음");
				}
				
				break;
				
			case 3:
				bonusDTO = bonusInput.;
				select = bonusDAO.bonusInsert(bonusDTO);
				String s = "보너스정보추가실패";
				if(select>0) {
					s="보너스정보추가성공";
				}
				bonusView.view(s);
				
				break;
				
			case 4:
				ename = 
				break;
				
			default:
				System.out.println("종료");
				check =!check;
				break;
			}
			
			
			
			
			
			
			
		}
		
		
	}

}

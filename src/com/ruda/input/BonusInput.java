package com.ruda.input;

import java.util.Scanner;

import com.ruda.bonus.BonusDTO;

public class BonusInput {
	
private Scanner sc;
	
	public BonusInput() {
		sc = new Scanner(System.in);
	}
	
	public BonusDTO selectOne() {
		BonusDTO bonusDTO = new BonusDTO();
		System.out.println("사원이름를 입력하세요");
		bonusDTO.setEname(sc.next());
		return bonusDTO;
	}
	
	public BonusDTO boInsert() {
		BonusDTO bonusDTO = new BonusDTO();
		System.out.println("추가할 사원이름을 입력하세요");
		bonusDTO.setEname(sc.next());
		System.out.println("추가할 사원직급을 입력하세요");
		bonusDTO.setJob(sc.next());
		System.out.println("추가할 급여를 입력하세요");
		bonusDTO.setSal(sc.nextInt());
		System.out.println("추가할 커밋을 입력하세요");
		bonusDTO.setComm(sc.nextInt());
		
		return bonusDTO;
	}

}

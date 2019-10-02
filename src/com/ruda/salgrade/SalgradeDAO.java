package com.ruda.salgrade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ruda.util.DBConnector;

public class SalgradeDAO {
	
	//grade를 받아서 해당 grade의 hisal losal 조회
	//메서드 getSalgradeOne
	
	public void getSalgradeOne() {
		SalgradeDTO salgradeDTO = null;
		PreparedStatement st = null;
		Connection con  = null;
		ResultSet rs = null;
		
		try {
			con = DBConnector.getConnect();
			String sql = "";
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
	
	
	
	//전체 salgrade 조회 메서드 getSalgradeList
	
	public ArrayList<SalgradeDTO> getSalgradeList() {
		
		SalgradeDTO salgradeDTO = null;
		PreparedStatement st = null;
		Connection con  = null;
		ResultSet rs = null;
		ArrayList<SalgradeDTO> ar = new ArrayList<SalgradeDTO>();
		
		try {
			con = DBConnector.getConnect();
			String sql = "select * from salgrade";
			st= con.prepareStatement(sql);
			rs= st.executeQuery();
			
			while(rs.next()) {
				salgradeDTO = new SalgradeDTO();
				salgradeDTO.setGrade(rs.getInt("grade"));
				salgradeDTO.setHisal(rs.getInt("hisal"));
				salgradeDTO.setLosal(rs.getInt("losal"));
				ar.add(salgradeDTO);
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
		
		return ar;
	}
	
	

}

package com.ruda.salgrade;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ruda.util.DBConnector;

public class SalgradeDAO {

	//삭제
	public int salDelete(int grade) {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;

		try {
			con = DBConnector.getConnect();
			String sql = "delete salgrade where grade=?";
			st = con.prepareStatement(sql);

			st.setInt(1, grade);

			result = st.executeUpdate();

			if(result>0) {
				System.out.println("입력성공");
			}else {
				System.out.println("입력실패");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				st.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return result;
	}
	//삽입
	public int salInsert(SalgradeDTO salgradeDTO) {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;

		try {
			con = DBConnector.getConnect();
			String sql = "insert into salgrade values(?,?,?)";
			st = con.prepareStatement(sql);

			st.setInt(1, salgradeDTO.getGrade());
			st.setInt(2, salgradeDTO.getLosal());
			st.setInt(3, salgradeDTO.getHisal());

			result = st.executeUpdate();

			if(result>0) {
				System.out.println("입력성공");
			}else {
				System.out.println("입력실패");
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return result;
	}
	//전체조회
	public ArrayList<SalgradeDTO> getSelectList() {
		SalgradeDTO salgradeDTO = null;
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<SalgradeDTO> ar = new ArrayList<SalgradeDTO>();

		try {
			con = DBConnector.getConnect();
			String sql = "select * from salgrade";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();

			while(rs.next()) {
				salgradeDTO = new SalgradeDTO();
				salgradeDTO.setGrade(rs.getInt("grade"));
				salgradeDTO.setLosal(rs.getInt("losal"));
				salgradeDTO.setHisal(rs.getInt("hisal"));
				ar.add(salgradeDTO);
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
		return ar;


	}
	DBConnector dc = new DBConnector();
	Connection con = null;
	PreparedStatement st = null;
	ResultSet rs = null;
	//한사람 조회
	public SalgradeDTO getSelectOne(int grade) {
		SalgradeDTO salgradeDTO = null;

		try {
			con = DBConnector.getConnect();
			String sql = "select grade, losal, hisal from salgrade where grade=?";

			st = con.prepareStatement(sql);
			st.setInt(1, grade);
			rs = st.executeQuery();

			if(rs.next()) {
				salgradeDTO = new SalgradeDTO();
				salgradeDTO.setGrade(rs.getInt("grade"));
				salgradeDTO.setLosal(rs.getInt("losal"));
				salgradeDTO.setHisal(rs.getInt("hisal"));
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return salgradeDTO;
	}
}

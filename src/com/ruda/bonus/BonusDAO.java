package com.ruda.bonus;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ruda.util.DBConnector;

public class BonusDAO {

	//새로운 사람 인서트
	public int bonusInsert(BonusDTO bonusDTO) {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;

		try {
			con = DBConnector.getConnect();
			String sql ="insert into bonus(ename, job, sal, comm) "
					+"values(?, ?, ?, ?)";
			st= con.prepareStatement(sql);
			st.setString(1, bonusDTO.getEname());
			st.setString(2, bonusDTO.getJob());
			st.setInt(3, bonusDTO.getSal());
			st.setInt(4, bonusDTO.getComm());

			result = st.executeUpdate();


		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {

			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}

	//딜리트
	public int delete(String ename) {
		Connection con = null;
		PreparedStatement st = null;
		int result = 0;

		try {
			con = DBConnector.getConnect();
			String sql = "delete bonus where ename=?";
			st = con.prepareStatement(sql);
			st.setString(1, ename);
			result = st.executeUpdate();

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return result;
	}


	//전체조회 getBonusList
	public ArrayList<BonusDTO> getBonusList (){
		BonusDTO bonusDTO = null;
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		ArrayList<BonusDTO> ar = new ArrayList<BonusDTO>();

		try {
			con = DBConnector.getConnect();
			String sql = "select * from bonus";
			st= con.prepareStatement(sql);
			rs= st.executeQuery();

			while(rs.next()) {
				bonusDTO = new BonusDTO();
				bonusDTO.setEname(rs.getString("ename"));
				bonusDTO.setJob(rs.getString("job"));
				bonusDTO.setSal(rs.getInt("sal"));
				bonusDTO.setComm(rs.getInt("comm"));
				ar.add(bonusDTO);
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



	//부분조회 getBonusOne
	public BonusDTO getBonusOne (String ename) {
		BonusDTO bonusDTO = null;
		Connection con = null;
		PreparedStatement st = null;
		ResultSet rs = null;

		try {
			con = DBConnector.getConnect();
			String sql = "select * from bonus where ename =?";
			st = con.prepareStatement(sql);
			st.setString(1, ename);
			rs = st.executeQuery();

			if(rs.next()) {
				bonusDTO = new BonusDTO();
				bonusDTO.setEname(rs.getString("ename"));
				bonusDTO.setJob(rs.getString("job"));
				bonusDTO.setSal(rs.getInt("sal"));
				bonusDTO.setComm(rs.getInt("comm"));
			}

		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			try {
				rs.close();
				st.close();
				con.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return bonusDTO;
	}

}

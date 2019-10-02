package com.ruda.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ruda.util.DBConnector;

public class DeptDAO {
	
	//새로운 부서 추가
	public int deptInsert(DeptDTO deptDTO) {
		
		Connection con = null;
		PreparedStatement st = null;
		int result =0;
		
		try {
			con = DBConnector.getConnect();
			String sql = "insert into dept(deptno, dname, loc) "
					+"values(?, ?, ?)";
			st = con.prepareStatement(sql);
			st.setInt(1, deptDTO.getDepno());
			st.setString(2, deptDTO.getDname());
			st.setString(3, deptDTO.getLoc());
			
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
	
	
	
	//getSelectList
	//전체부서정보
	public ArrayList<DeptDTO> getSelectList() {
		DeptDTO dt = null;
		PreparedStatement st = null;
		Connection con  = null;
		ResultSet rs = null;
		ArrayList<DeptDTO> ar = new ArrayList<DeptDTO>();

		try {
			con = DBConnector.getConnect();
			String sql = "select * from dept order by deptno";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();

			while(rs.next()) {
				dt = new DeptDTO();
				dt.setDepno(rs.getInt("deptno"));
				dt.setDname(rs.getString("dname"));
				dt.setLoc(rs.getString("loc"));
				ar.add(dt);
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


	//getSelectOne
	//부서번호 검색

	public DeptDTO getSelectOne(int deptno) {

		DeptDTO dt = null;

		PreparedStatement st = null;
		Connection con  = null;
		ResultSet rs = null;

		try {
			con = DBConnector.getConnect();
			String sql = "select * from dept where deptno=?";
			st = con.prepareStatement(sql);
			st.setInt(1, deptno);
			rs = st.executeQuery();

			if(rs.next()) {
				dt = new DeptDTO();
				dt.setDepno(rs.getInt("deptno"));
				dt.setDname(rs.getString("dname"));
				dt.setLoc(rs.getString("loc"));
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

		return dt;
	}

}

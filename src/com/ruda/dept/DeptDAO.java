package com.ruda.dept;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ruda.util.DBConnector;

public class DeptDAO {
	//getSelectList
	//전체부서정보
	
	
	
	//getSelectOne
	//부서번호 검색
	
	public void getSelectOne(int deptno) {
		
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
		
		
	}

}

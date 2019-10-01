package com.ruda.emp;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.ruda.util.DBConnector;

public class EmpDAO {
	
	//getSelectList
	//전체사원정보 - 최신입사일순
	public ArrayList<Object> getSelectList() {
		PreparedStatement st = null;
		Connection con  = null;
		ResultSet rs = null;
		ArrayList<Object> ar = new ArrayList<Object>();
		
		try {
			con = DBConnector.getConnect();
			String sql = "select * from emp order by hiredate desc";
			st = con.prepareStatement(sql);
			rs = st.executeQuery();
			while(rs.next()) {
				
				ar.add(rs.getInt("empno"));
				ar.add(rs.getInt("empno"));
				ar.add(rs.getString("ename"));
				ar.add(rs.getString("job"));
				ar.add(rs.getInt("mgr"));
				ar.add(rs.getDate("hiredate"));
				ar.add(rs.getInt("sal"));
				ar.add(rs.getInt("comm"));
				ar.add(rs.getInt("deptno"));
				
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
	//매개변수 사원번호
	
	public EmpDTO getSelectOne(int empno) {

		EmpDTO et =null;
		PreparedStatement st = null;
		Connection con  = null;
		ResultSet rs = null;
		try {
			con = DBConnector.getConnect();
			String sql = "select * from emp where empno=?";
			st = con.prepareStatement(sql);		
			st.setInt(1, empno);
			rs= st.executeQuery();
			
			if(rs.next()) {
				et = new EmpDTO();
				et.setEmpno(rs.getInt("empno"));
				et.setEname(rs.getString("ename"));
				et.setJob(rs.getString("job"));
				et.setMgr(rs.getInt("mgr"));
				et.setHiredate(rs.getDate("hiredate"));
				et.setSal(rs.getInt("sal"));
				et.setComm(rs.getInt("comm"));
				et.setDeptno(rs.getInt("deptno"));
						
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
		
		return et;
	}
}

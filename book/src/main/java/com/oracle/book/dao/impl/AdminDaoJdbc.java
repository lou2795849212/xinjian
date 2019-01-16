package com.oracle.book.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import com.oracle.book.dao.AdminDao;
import com.oracle.book.entity.Admin;
import com.oracle.book.util.DBUtil;
import com.oracle.book.util.MD5Util;

public class AdminDaoJdbc implements AdminDao {

	@Override
	public boolean find(Admin admin) {
		

		Connection con=null;
		PreparedStatement pt=null;
		ResultSet rs=null;
		
		try {
			con=DBUtil.getCon();
			String sql="select pwd from t_admin where name=? ";
			pt=con.prepareStatement(sql);
			pt.setString(1, admin.getName());
			rs=pt.executeQuery();
			if(rs.next()) {
               String dbPwd=rs.getString(1);
               return MD5Util.validPasswd(admin.getPwd(), dbPwd);

			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeFll(rs, pt, con);
		}
		return false;
	}

}

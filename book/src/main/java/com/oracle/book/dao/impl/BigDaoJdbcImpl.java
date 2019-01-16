package com.oracle.book.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.oracle.book.dao.BigAddDao;
import com.oracle.book.entity.BigType;
import com.oracle.book.util.DBUtil;

public class BigDaoJdbcImpl implements BigAddDao {

	@Override
	public boolean save(String name) {
		Connection con=null;
		PreparedStatement pt=null;
		
		
		        try {
					con=DBUtil.getCon();
					String sql="insert into t_big_type(name)values(?)";
					pt=con.prepareStatement(sql);
					pt.setString(1, name);
					int ret=pt.executeUpdate();
					if(ret>0) {
						return true;
					}
				} catch (Exception e) {
					e.printStackTrace();
				} finally {
					DBUtil.closeFll(pt, con);
				}
		return false;
	}

	@Override
	public List<BigType> findAll() {
		Connection con=null;
		PreparedStatement pt=null;
		ResultSet rs=null;
		
		try {
			con=DBUtil.getCon();
			String sql="select * from t_big_type";
			pt=con.prepareStatement(sql);
			rs=pt.executeQuery();
			List<BigType> ls=new ArrayList<>();
			while(rs.next()) {
				BigType b=new BigType();
				b.setId(rs.getInt("id"));
				b.setName(rs.getString("name"));
				ls.add(b);
			}
			return ls;
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeFll(rs, pt, con);
		}
		return null;
	}

}

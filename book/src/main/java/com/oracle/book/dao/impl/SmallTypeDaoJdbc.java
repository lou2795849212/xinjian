package com.oracle.book.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.oracle.book.dao.SmallTypeDao;
import com.oracle.book.entity.SmallType;
import com.oracle.book.util.DBUtil;

public class SmallTypeDaoJdbc implements SmallTypeDao {

	@Override
	public boolean save(SmallType smallType) {
		
		Connection con=null;
		PreparedStatement pt=null;
		
		
		        try {
					con=DBUtil.getCon();
					String sql="insert into t_small_type(name,bid)values(?,?)";
					pt=con.prepareStatement(sql);
					pt.setString(1, smallType.getName());
					pt.setInt(2, smallType.getBid());
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
	public List<SmallType> find(int bid) {
		
		Connection con=null;
		PreparedStatement pt=null;
		ResultSet rs=null;
		
		try {
			con=DBUtil.getCon();
			String sql="select * from t_small_type where bid="+bid;
			pt=con.prepareStatement(sql);
			rs=pt.executeQuery();
			List<SmallType> ls=new ArrayList<>();
			while(rs.next()) {
				SmallType b=new SmallType();
				b.setId(rs.getInt("id"));
				b.setName(rs.getString("name"));
				b.setBid(rs.getInt("bid"));
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

	@Override
	public int findBySid(int sid) {
		Connection con=null;
		PreparedStatement pt=null;
		ResultSet rs=null;
		
		try {
			con=DBUtil.getCon();
			String sql="select bid from t_small_type where id="+sid;
			pt=con.prepareStatement(sql);
			rs=pt.executeQuery();
			if(rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBUtil.closeFll(rs, pt, con);
		}
		
		
		return 0;
	}

}

package com.oracle.book.dao.impl;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.oracle.book.dao.BookAddDao;
import com.oracle.book.entity.Book;
import com.oracle.book.util.DBUtil;
import com.oracle.book.util.PageYeShu;

public class BookAddDaoImpl implements BookAddDao {

	@Override
	public boolean save(Book book) {
		Connection con = null;
		PreparedStatement pt = null;

		try {
			con = DBUtil.getCon();
			String sql = "insert into t_book(name,author,price,cbs,cbDate,descri,photo,sid)values(?,?,?,?,?,?,?,?)";
			pt = con.prepareStatement(sql);
			pt.setString(1, book.getName());
			pt.setString(2, book.getAuthor());
			pt.setDouble(3, book.getPrice());
			pt.setString(4, book.getCbs());
			pt.setDate(5, new Date(book.getCbDate().getTime()));
			pt.setString(6, book.getDescri());
			pt.setString(7, book.getPhoto());
			pt.setInt(8, book.getSid());
			int ret = pt.executeUpdate();
			if (ret > 0) {
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
	public List<Book> findAll(int currentPage, String name, int sid) {

		Connection con = null;
		PreparedStatement pt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getCon();
			String sql = "select * from t_book where 1=1 ";

			if (name != null && !name.equals("")) {
				sql += " and name like '%" + name + "%' ";
			}
			if (sid != -1) {
				sql += " and sid=" + sid;
			}
			sql += " order by id desc limit " + ((currentPage - 1) * PageYeShu.PAGE_SIZ + 1 - 1) + ","
					+ PageYeShu.PAGE_SIZ;
			pt = con.prepareStatement(sql);
			rs = pt.executeQuery();
			List<Book> ls = new ArrayList<>();
			while (rs.next()) {
				Book b = new Book();
				b.setId(rs.getInt("id"));
				b.setName(rs.getString("name"));
				b.setAuthor(rs.getString("author"));
				b.setPrice(rs.getDouble("price"));
				b.setCbs(rs.getString("cbs"));
				b.setCbDate(rs.getDate("cbDate"));
				b.setDescri(rs.getString("descri"));
				b.setPhoto(rs.getString("photo"));
				b.setSid(rs.getInt("sid"));
				ls.add(b);
			}
			return ls;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeFll(rs, pt, con);
		}
		return null;
	}

	@Override
	public int total(String name, int sid) {

		Connection con = null;
		PreparedStatement pt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getCon();
			String sql = "select count(*) from t_book where 1=1 ";
			if (name != null && !name.equals("")) {
				sql += " and name like '%" + name + "%'";
			}
			if (sid != -1) {
				sql += " and sid=" + sid;
			}
			pt = con.prepareStatement(sql);
			rs = pt.executeQuery();
			if (rs.next()) {
				return rs.getInt(1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeFll(rs, pt, con);
		}
		return 0;
	}

	@Override
	public int delById(int id) {
		Connection con = null;
		PreparedStatement pt = null;

		try {
			con = DBUtil.getCon();
			String sql = "delete from t_book where id=" + id;
			pt = con.prepareStatement(sql);

			int ret = pt.executeUpdate();
			return ret;

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeFll(pt, con);
		}

		return 0;
	}

	@Override
	public Book findById(int id) {

		Connection con = null;
		PreparedStatement pt = null;
		ResultSet rs = null;

		try {
			con = DBUtil.getCon();
			String sql = "select * from t_book where id=" + id;
			pt = con.prepareStatement(sql);
			rs = pt.executeQuery();
			while (rs.next()) {
				Book b = new Book();
				b.setId(rs.getInt("id"));
				b.setName(rs.getString("name"));
				b.setAuthor(rs.getString("author"));
				b.setPrice(rs.getDouble("price"));
				b.setCbs(rs.getString("cbs"));
				b.setCbDate(rs.getDate("cbDate"));
				b.setDescri(rs.getString("descri"));
				b.setPhoto(rs.getString("photo"));
				b.setSid(rs.getInt("sid"));
				return b;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeFll(rs, pt, con);
		}
		return null;
	}

	@Override
	public boolean update(Book book) {
		Connection con = null;
		PreparedStatement pt = null;

		try {
			con = DBUtil.getCon();
			if (book.getPhoto() == null) {
				String sql = "update t_book set name=?,author=?,price=?,cbs=?,cbDate=?,descri=?,sid=? where id=?";
				pt = con.prepareStatement(sql);
				pt = con.prepareStatement(sql);
				pt.setString(1, book.getName());
				pt.setString(2, book.getAuthor());
				pt.setDouble(3, book.getPrice());
				pt.setString(4, book.getCbs());
				pt.setDate(5, new Date(book.getCbDate().getTime()));
				pt.setString(6, book.getDescri());
				pt.setInt(7, book.getSid());
				pt.setInt(8, book.getId());
			} else {
				String sql = "update t_book set name=?,author=?,price=?,cbs=?,cbDate=?,descri=?,photo=?,sid=? where id=?";
				pt = con.prepareStatement(sql);
				pt.setString(1, book.getName());
				pt.setString(2, book.getAuthor());
				pt.setDouble(3, book.getPrice());
				pt.setString(4, book.getCbs());
				pt.setDate(5, new Date(book.getCbDate().getTime()));
				pt.setString(6, book.getDescri());
				pt.setString(7, book.getPhoto());
				pt.setInt(8, book.getSid());
				pt.setInt(9, book.getId());
			}

			int ret = pt.executeUpdate();
			if (ret > 0) {
				return true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBUtil.closeFll(pt, con);
		}

		return false;
	}
}
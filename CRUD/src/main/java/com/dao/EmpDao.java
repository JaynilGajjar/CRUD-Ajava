package com.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.bean.Emp;
import com.util.EmpUtil;

public class EmpDao {

	public static void insertEmp(Emp e)
	{
		try {
			Connection conn=EmpUtil.createConnection();
			String sql="insert into emp(fname,lname,email,mobile,address) values(?,?,?,?,?)";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, e.getFname());
			pst.setString(2, e.getLname());
			pst.setString(3, e.getEmail());
			pst.setString(4, e.getMobile());
			pst.setString(5, e.getAddress());
			pst.executeUpdate();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	public static List<Emp> getAllEmp()
	{
		List<Emp> list=new ArrayList<Emp>();
		try {
			Connection conn=EmpUtil.createConnection();
			String sql="select * from emp";
			PreparedStatement pst=conn.prepareStatement(sql);
			ResultSet rs=pst.executeQuery();
			while(rs.next())
			{
				Emp e=new Emp();
				e.setId(rs.getInt("id"));
				e.setFname(rs.getString("fname"));
				e.setLname(rs.getString("lname"));
				e.setEmail(rs.getString("email"));
				e.setMobile(rs.getString("mobile"));
				e.setAddress(rs.getString("Address"));
				list.add(e);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public static Emp getEmp(int id)
	{
		Emp e=null;
		try {
			Connection conn=EmpUtil.createConnection();
			String sql="select * from emp where id=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			ResultSet rs=pst.executeQuery();
			if(rs.next())
			{
				e=new Emp();
				e.setId(rs.getInt("id"));
				e.setFname(rs.getString("fname"));
				e.setLname(rs.getString("lname"));
				e.setEmail(rs.getString("email"));
				e.setMobile(rs.getString("mobile"));
				e.setAddress(rs.getString("Address"));
			}
		} catch (Exception ex) {
			ex.printStackTrace();
		}
		return e;
	}
	public static void updateEmp(Emp e)
	{
		try {
			Connection conn=EmpUtil.createConnection();
			String sql="update emp set fname=?,lname=?,email=?,mobile=?,address=? where id=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setString(1, e.getFname());
			pst.setString(2, e.getLname());
			pst.setString(3, e.getEmail());
			pst.setString(4, e.getMobile());
			pst.setString(5, e.getAddress());
			pst.setInt(6, e.getId());
			pst.executeUpdate();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
	public static void deleteEmp(int id)
	{
		try {
			Connection conn=EmpUtil.createConnection();
			String sql="delete from emp where id=?";
			PreparedStatement pst=conn.prepareStatement(sql);
			pst.setInt(1, id);
			pst.executeUpdate();
		} catch (Exception e2) {
			e2.printStackTrace();
		}
	}
}

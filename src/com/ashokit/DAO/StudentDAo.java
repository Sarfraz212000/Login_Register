package com.ashokit.DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;

import com.ashokit.DTO.StudentDTO;
import com.ashokit.util.connectionfactory;

public class StudentDAo {
	
	private static final String SQL="insert into student(fname,lname,email,password,gender) values(?,?,?,?,?)";
	
	public boolean insertdata(StudentDTO dto)
	{
		try {
			Connection con = connectionfactory.getConneton();
			PreparedStatement pstm = con.prepareStatement(SQL);
			pstm.setString(1, dto.getFname());
			pstm.setString(2, dto.getLname());
			pstm.setString(3, dto.getEmail());
			pstm.setString(4, dto.getPassword());
			pstm.setString(5, dto.getGender());
			
			int count = pstm.executeUpdate();
			if (count>0) 
			{
				return true;
				
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}

}

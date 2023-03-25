package com.ashokit.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ashokit.DAO.StudentDAo;
import com.ashokit.DTO.StudentDTO;
@WebServlet("insert")
public class studentServlet extends HttpServlet
{
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		PrintWriter pw= resp.getWriter();
		String Fname = req.getParameter("fname");
		String Lname = req.getParameter("lname");
		String Email = req.getParameter("email");
		String Pass = req.getParameter("password");
		String Gender = req.getParameter("gender");
		
		StudentDTO dto= new StudentDTO();
		dto.setFname(Fname);
		dto.setLname(Lname);
		dto.setEmail(Email);
		dto.setPassword(Pass);
		dto.setGender(Gender);
		
		
		StudentDAo dao= new StudentDAo();
		boolean save = dao.insertdata(dto);
		
		if(save)
		{
			pw.append("data insert sucessfully..........................");
			RequestDispatcher rd= req.getRequestDispatcher("index.jsp");
			rd.forward(req, resp);
			
		}
		
	}

}

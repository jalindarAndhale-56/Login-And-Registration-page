package WebProject;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/reValidate")
public class registerValidate extends HttpServlet {
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
				
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sonu","root","root");
			
			String Uname=request.getParameter("username");
			String Email=request.getParameter("EmailID");
			String password=request.getParameter("password");

			PreparedStatement pst=con.prepareStatement(" select * from register where uname=? and password=? and email_ID=?");
			pst.setString(1, Uname);
			pst.setString(2, password);
			pst.setString(3, Email);
			
			
			ResultSet rs=pst.executeQuery();
			
			if(rs.next())
			{
				RequestDispatcher rd=request.getRequestDispatcher("validate.jsp");
				rd.include(request, response);
			}else {
				RequestDispatcher rd=request.getRequestDispatcher("Reerror.jsp");
				rd.include(request, response);
			}

		} catch (ClassNotFoundException | SQLException e) {
			
		}
	}

}

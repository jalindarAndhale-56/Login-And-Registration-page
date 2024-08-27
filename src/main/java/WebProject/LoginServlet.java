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
import javax.websocket.SendResult;


@WebServlet("/LogServlet")
public class LoginServlet extends HttpServlet {
	
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw=response.getWriter();
				
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/sonu","root","root");
			
			String n=request.getParameter("username");
			String p=request.getParameter("password");
			
			PreparedStatement pst=con.prepareStatement(" select * from validation where Uname=? and password=?");
			pst.setString(1, n);
			pst.setString(2, p);
			
			ResultSet rs=pst.executeQuery();
			
			if(rs.next())
			{
				RequestDispatcher rd=request.getRequestDispatcher("Welcome.jsp");
				rd.include(request, response);
			}else {
				RequestDispatcher rd=request.getRequestDispatcher("error.jsp");
				rd.forward(request, response);
			}

		} catch (ClassNotFoundException | SQLException e) {
			
		}
		
	}

}

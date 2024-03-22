import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.*;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Approve extends HttpServlet {
	private static final long serialVersionUID = 1L;
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		//out.print("hi");            

		try{
			response.setContentType("text/html;charset=UTF-8");
			
                       
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/demo";
            String username="root";
            String password="dhyana";
            Connection con=DriverManager.getConnection(url, username, password);
            String q="select * from empleave";
            Statement stmt=con.createStatement();
            ResultSet rs = stmt.executeQuery(q);

            
            
            out.println("<table BORDER=1 CELLPADDING=0 CELLSPACING=0 WIDTH=100%>"
	                    +"<tr><th>reqid</th><th>empid</th><th>NAME</th><th>start</th><th>end</th><th>reason</th><th>type</th><th>contact</th></tr>");
	            while(rs.next())
        {
	            	  out.println("<tr><td><center>"+rs.getString(1)+"</center></td>"
	            	  + "<td><center>"+rs.getString(2)+"</center></td>"
	            	  +"<td><center>"+rs.getString(3)+"</center></td>"
	            	  +"<td><center>"+rs.getString(4)+"</center></td>"
	            	  +"<td><center>"+rs.getString(5)+"</center></td>"
	            	  +"<td><center>"+rs.getString(6)+"</center></td>"
	            	  +"<td><center>"+rs.getString(7)+"</center></td>"
	            	  +"<td><center>"+rs.getString(8)+"</center></td></tr>");
	            	 // out.println("<br>");
	}
         
                    out.println("<form method='get' action='Validate'>"
                            + "Enter id<input type='text' name='id'>"
                            +"<br>"
                            +"<br>"
                            +"Status:"
                            +"<br>"
                            +"Accept<input type='radio' name='status' value='accept'>"
                            +"Reject<input type='radio' name='status' value='reject'>"
                            +"<br>"
                            +"<br>"
                            +"<input type='submit' value='submit'>"
                            + "</form>");
	
	}
                catch(SQLException e)
        {
            out.print(e);
        } 
         catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
            e.printStackTrace();
		}
                
        }
}

	
	



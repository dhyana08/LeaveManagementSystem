import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Entry extends HttpServlet {
	private static final long serialVersionUID = 1L;
        @Override
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		//out.print("hi");            

		try{
			response.setContentType("text/html;charset=UTF-8");
			String id=request.getParameter("empid");
			String name=request.getParameter("empname");
			String start=request.getParameter("start");
			String end=request.getParameter("end");
			String reason=request.getParameter("reason");
                        String type=request.getParameter("type");
			String contact=request.getParameter("contact");
                       
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/demo";
            String username="root";
            String password="dhyana";
            Connection con=DriverManager.getConnection(url, username, password);
            String q="insert into empleave (id,name,start,end,reason,type,contact) values(?,?,?,?,?,?,?)";
            PreparedStatement ps=con.prepareStatement(q);
            ps.setString(1, id);
            ps.setString(2, name);
            ps.setString(3, start);
            ps.setString(4, end);
            ps.setString(5, reason);
            ps.setString(6, type);
            ps.setString(7, contact);
            int  i=ps.executeUpdate();
         out.println(i+"sucessfully Inserted");
         out.println("<br>");
         out.println("<br>");
         out.println("Wait for validation");
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

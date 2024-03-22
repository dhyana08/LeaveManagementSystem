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

/**
 * Servlet implementation class Approve
 */
public class Validate extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Validate() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		PrintWriter out = response.getWriter();
		//out.print("hi");
		try{
			response.setContentType("text/html;charset=UTF-8");
			String reqid=request.getParameter("id");
			String status=request.getParameter("status");
            Class.forName("com.mysql.jdbc.Driver");
            String url="jdbc:mysql://localhost:3306/demo";
            String username="root";
            String password="dhyana";
            Connection con=DriverManager.getConnection(url, username, password);
            String q="update empleave set status=? where reqid=?";
            PreparedStatement ps=con.prepareStatement(q);
       ps.setString(1, status);
       ps.setString(2, reqid);
//            ps.setString(2, reqid);
//            ps.setString(3, stdate);
//            ps.setString(4, enddate);
//            ps.setString(5, reason);
//            ps.setString(6, type);
//            ps.setString(7, contact);
            int  i=ps.executeUpdate();
         out.println(i+"succcess");
		}
	catch(SQLException e)
        {
            out.print(e);
        } 
        catch (ClassNotFoundException e) 
                {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
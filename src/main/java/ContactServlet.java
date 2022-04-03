import java.io.*;
import java.sql.*;
import java.util.Objects;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/ContactServlet")
public class ContactServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    public ContactServlet() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    	response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        
        String names = request.getParameter("name");
        String emails = request.getParameter("email");
        String messages = request.getParameter("textfield");

        String dbname = "testdb";
        String usernames = "ee417";
        String password = "ee417";
        String url = "jdbc:mysql://ee417.crxkzf89o3fh.eu-west-1.rds.amazonaws.com:3306/testdb";
        
        if(Objects.equals(names, "") || Objects.equals(emails, "") || Objects.equals(messages, ""))
        {
            out.println("<p style='text-align: center;'> Can't leave inputs blank </p>");
            RequestDispatcher rd = request.getRequestDispatcher("contact.jsp");
            rd.include(request,response);
        }
        else {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,usernames,password);
            Statement stmt=con.createStatement();
            String sqlstatement = "insert into contacttableGroupE (first_name, email, message) values ('" + names + "', '" + emails + "', '" + messages + "')";
            stmt.executeUpdate(sqlstatement);
            System.out.println("uploaded contact info");
            con.close();
            response.sendRedirect("home.jsp?name=" + names);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        }

    }

}

import java.io.*;
import java.sql.*;
import java.util.Objects;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoanServlet")
public class LoanServlet extends HttpServlet{
    private static final long serialVersionUID = 1L;
    public LoanServlet(){ super();}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    	response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String accno = request.getParameter("Account_No1");
        String firstname = request.getParameter("name1");
        String amount = request.getParameter("amount");


        String dbname = "testdb";
        String usernames = "ee417";
        String password = "ee417";
        String url = "jdbc:mysql://ee417.crxkzf89o3fh.eu-west-1.rds.amazonaws.com:3306/testdb";

        if(Objects.equals(accno, "") || Objects.equals(firstname, "") || Objects.equals(amount, ""))
        {
            out.println("<p style='text-align: center; color:red'> Can't leave inputs blank </p>");
            RequestDispatcher rd = request.getRequestDispatcher("services.jsp");
            rd.include(request,response);
        }
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,usernames,password);
            Statement stmt=con.createStatement();
            String sqlstatement = "insert into loansGroupE (accountno, first_name, amount) values ('" + accno + "', '" + firstname + "', '"+ amount+ "')";
            stmt.executeUpdate(sqlstatement);
            System.out.println("uploaded contact info");
            con.close();
            response.sendRedirect("home.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}

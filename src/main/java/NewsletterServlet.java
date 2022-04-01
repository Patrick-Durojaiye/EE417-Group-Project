import java.io.*;
import java.sql.*;
import java.util.Objects;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/NewsletterServlet")
public class NewsletterServlet extends HttpServlet{

    private static final long serialVersionUID = 1L;

    public NewsletterServlet() {
        super();
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        System.out.println("in post news");
        String emails = request.getParameter("emailft");

        String dbname = "testdb";
        String usernames = "ee417";
        String password = "ee417";
        String url = "jdbc:mysql://ee417.crxkzf89o3fh.eu-west-1.rds.amazonaws.com:3306/testdb";

        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,usernames,password);
            Statement stmt=con.createStatement();
            String sqlstatement = "insert into newsletterGroupE (email) values ('" + emails + "')";
            stmt.executeUpdate(sqlstatement);
            System.out.println("uploaded contact info");
            con.close();
            response.sendRedirect("signup.jsp");
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}

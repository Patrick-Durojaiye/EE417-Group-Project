import java.io.*;
import java.sql.*;
import java.util.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpSession;

@WebServlet("/UpdateUserServlet")
public class UpdateUserServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;
    public UpdateUserServlet(){ super();}

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.getWriter().append("Served at: ").append(request.getContextPath());
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

        HttpSession session = request.getSession(true);
        String username = request.getParameter("name");
        String accountnumber = request.getParameter("accountnumber");
        String userpass = request.getParameter("newpass");


        String dbname = "testdb";
        String usernames = "ee417";
        String password = "ee417";
        String url = "jdbc:mysql://ee417.crxkzf89o3fh.eu-west-1.rds.amazonaws.com:3306/testdb";
        System.out.println("Inside post function");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,usernames,password);
            Statement stmt=con.createStatement();

            // updates users login information from update query
            String sqlstatement = "update usersGroupE set user_password=+ '" + userpass + "' where first_name=+'" + username + "' and accountno='" + accountnumber + "'";
            stmt.executeUpdate(sqlstatement);
            System.out.println("uploaded contact info");
            con.close();
            response.sendRedirect("admin.jsp");
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

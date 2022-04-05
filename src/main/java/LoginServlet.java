import java.io.*;
import java.sql.*;
import java.util.Objects;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/LoginServlet")
public class LoginServlet extends HttpServlet {

    public static final long serialVersionUID = 1L;

    public LoginServlet() { super(); }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {
        String username = request.getParameter("name");
        System.out.println("username is: " + username);
        HttpSession session = request.getSession(true);
        session.setAttribute("User", username);


        String firstname = request.getParameter("name");
        String email = request.getParameter("email");
        String userpasswords = request.getParameter("password");
        String dbname = "testdb";
        String usernames = "ee417";
        String password = "ee417";
        String url = "jdbc:mysql://ee417.crxkzf89o3fh.eu-west-1.rds.amazonaws.com:3306/testdb";
        System.out.println("Inside post function");

        if(Objects.equals(firstname, "") || Objects.equals(email, "") || Objects.equals(userpasswords, ""))
        {
            out.print("<p style='text-align: center; color:red'> Can't leave inputs blank </p>");
            RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
            rd.include(request,response);
        }
        
        ResultSet rs = null;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con= DriverManager.getConnection(url,usernames,password);
            Statement stmt=con.createStatement();

            // select query to get user information
            String sqlstatement = "select first_name, email, user_password, isAdmin from usersGroupE where first_name='" + firstname + "' and email='"+ email + "' and user_password='" + userpasswords + "'";
            rs = stmt.executeQuery(sqlstatement);
            System.out.println("rs: " + rs);
            System.out.println("uploaded contact info");

            if(!rs.isBeforeFirst())
            {

                out.print("<p style='text-align: center;'> User doesn't exist </p>");
                RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
                rd.include(request,response);

            }
            
            while (rs.next())
            {
                String first_name = rs.getString("first_name");
                String emails = rs.getString("email");
                String userpass = rs.getString("user_password");
                String adminbool = rs.getString("isAdmin");
                System.out.println(first_name + " " + emails + " " + userpass + " " + adminbool);

                // if login inputs matchs data from database it logs a user in
                if((Objects.equals(first_name, firstname)) && (Objects.equals(emails, email)) && (Objects.equals(userpasswords, userpass)) && (Objects.equals(adminbool, "0")))
                {
                    System.out.println("hello");
                    response.sendRedirect("home.jsp?name=" + username);
                    System.out.println("Logged in");
                }

                // if admin logging in then redirects to admin page
                else if((Objects.equals(first_name, firstname)) && (Objects.equals(emails, email)) && (Objects.equals(userpasswords, userpass)) && (Objects.equals(adminbool, "1")))
                {
                    response.sendRedirect("admin.jsp");
                }
            }
            con.close();
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

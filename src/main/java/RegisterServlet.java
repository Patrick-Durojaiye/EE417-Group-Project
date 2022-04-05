import java.io.*;
import java.sql.*;
import java.util.Objects;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/RegisterServlet")
public class RegisterServlet extends HttpServlet{

    public static final long serialVersionUID = 1L;

    public RegisterServlet() { super(); }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException
    {

    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {

    	response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        String names = request.getParameter("name");
        String emails = request.getParameter("email");
        String date_of_birth = request.getParameter("date_of_birth");
        String passwords= request.getParameter("password");
        System.out.println("Date of birth: " + date_of_birth);
        String username = request.getParameter("name");

        if (Objects.equals(names, "") || Objects.equals(emails, "") || Objects.equals(passwords, "")) {
            out.print("<p style='text-align: center; color:red'> Can't leave inputs blank </p>");
            RequestDispatcher rd = request.getRequestDispatcher("signup.jsp");
            rd.include(request, response);
        }
        
        else {
        ResultSet rs = null;


        String dbname = "testdb";
        String usernames = "ee417";
        String password = "ee417";
        String url = "jdbc:mysql://ee417.crxkzf89o3fh.eu-west-1.rds.amazonaws.com:3306/testdb";
        System.out.println("in if statement");
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection con=DriverManager.getConnection(url,usernames,password);
            Statement stmt=con.createStatement();
            int min = 1;
            int max = 10000;
            int accno = (int)(Math.random()*(max-min+1)+min);
            String sqlstatement2 = "select first_name from usersGroupE where email='" + emails + "'";
            

            boolean checker = false;
            rs = stmt.executeQuery(sqlstatement2);
               while (rs.next()) {
                   checker=true;
               }
               if(checker==false){
                   String sqlstatement = "insert into usersGroupE (first_name, email, date_of_birth, user_password, accountno, balance, isAdmin) values ('" + names + "', '" + emails + "', '" + date_of_birth + "', '" + passwords + "', '" + accno + "', '" + 1000 +"', '" + 0 + "')";
                   stmt.executeUpdate(sqlstatement);
                    HttpSession session = request.getSession(true);
                   session.setAttribute("User", names);
                   Cookie name = new Cookie("name", request.getParameter("name"));
                   response.addCookie(name);
               // Set expiry date after 24 Hrs for both the cookies.
               name.setMaxAge(60 * 60 * 24);
                   con.close();
               response.sendRedirect("home.jsp?name=" + username);
               System.out.println("Logged in");
                   }
                   else{
                       response.sendRedirect("index.jsp");
                   }
                   
            
        }
         catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


        }

    }
}
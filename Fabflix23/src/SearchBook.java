import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import java.sql.*;
import java.util.*;

public class SearchBook extends HttpServlet {
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

public void doPost(HttpServletRequest request, HttpServletResponse response)
throws ServletException,IOException{
response.setContentType("text/html"); 
HttpSession session = request.getSession(true);
List booklist=new ArrayList();
Connection con = null;

String url = "jdbc:mysql:///moviedb";
String db = "searchbook";
String driver = "com.mysql.jdbc.Driver";
String user = "root";
String pass = "root";

String isbncode="";
String genre="";
isbncode=request.getParameter("isbncode");
genre=request.getParameter("bookcategories");
String sqlqueary="SELECT * FROM movies WHERE title LIKE '%%' ";
if(isbncode!=null && !(isbncode.equals(""))){
sqlqueary+=" and isbn_code='"+isbncode+"'";
}
if(genre!=null && !(genre.equals("-1"))){
sqlqueary+=" and category='"+genre+"'";
}

try{
Class.forName(driver);
con = DriverManager.getConnection(url, user, pass);
try{
Statement st = con.createStatement();
ResultSet rs = st.executeQuery(sqlqueary);
while (rs.next()) {
List book=new ArrayList();
book.add(rs.getInt(1));
book.add(rs.getInt(2));
book.add(rs.getString(3));
book.add(rs.getString(4));
booklist.add(book);
}
}catch (SQLException s){
System.out.println("SQL statement is not executed!");
}
}
catch (Exception e){
e.printStackTrace();
}
request.setAttribute("booklist",booklist); 
RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/searchbook.jsp");
dispatcher.forward(request, response); 
}

}
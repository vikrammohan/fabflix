

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List; 

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SingleMovieDAO {
	


	public HashMap<Integer,SingleMoviePage> list(){
        HashMap<Integer,SingleMoviePage> moviepages = new HashMap<Integer,SingleMoviePage>();
		
	  
		 // Incorporate mySQL driver
	
	
        try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			Connection connection = DriverManager.getConnection("jdbc:mysql:///moviedb","root", "root");
			
			Statement select = connection.createStatement();
            Statement select2 = connection.createStatement();
            Statement select3 = connection.createStatement();
            ResultSet result = select.executeQuery("Select id, title, year, director from movies");
            //ResultSet result2 = select.executeQuery("Select title, year, director from movies");



            // print table's contents, field by field
            while (result.next())
            {
                int id = result.getInt("id");
                SingleMoviePage s = new SingleMoviePage();
                s.setId(id);
                s.setMovieName(result.getString("title"));
                s.setYear(result.getString("year"));
                s.setDirector(result.getString("director"));
                ResultSet result2 = select2.executeQuery("Select star_id from stars_in_movies where movie_id = " + id);
                while (result2.next()){
                    int starid = result2.getInt("star_id");
                    s.setStarId(starid);
                    ResultSet result3 = select3.executeQuery("Select first_name, last_name from stars where id = " + starid);
                    if(result3.next()) {
                        String name = result3.getString("first_name") + " " + result3.getString("last_name");
                        s.setStarList(name);
                    }
                }
                moviepages.put(id, s);
			        //out.print();
			}
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return moviepages;
		
	
	
		
	}
	
	
	
		
	
}
	


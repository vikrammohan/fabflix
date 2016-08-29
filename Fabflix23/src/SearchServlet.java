

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		   try {
				Class.forName("com.mysql.jdbc.Driver").newInstance();

				Connection connection = DriverManager.getConnection("jdbc:mysql:///moviedb","root", "root");
				
				Statement select = connection.createStatement();
	            Statement select2 = connection.createStatement();
	            Statement select3 = connection.createStatement();
	            ResultSet result = select.executeQuery("Select id, title from movies");
	            //ResultSet result2 = select.executeQuery("Select title, year, director from movies");


	            
	            // print table's contents, field by field
	            while (result.next())
	            {
	                int id = result.getInt("id");
	                SingleStarPage s = new SingleStarPage();
	                s.setId(id);
	                s.setFirstName(result.getString("first_name"));
	                s.setLastName(result.getString("last_name"));
	                s.setPhotoURL(result.getString("photo_url"));
	                s.setDob(result.getString("dob"));
	                ResultSet result2 = select2.executeQuery("Select movie_id from stars_in_movies where star_id = " + id);
	                while (result2.next()){
	                    int movieid = result2.getInt("movie_id");
	                    s.setMoviekey(movieid);
	                    ResultSet result3 = select3.executeQuery("Select title from movies where id = " + movieid);
	                    if(result3.next()) {
	                        String name = result3.getString("title");
	                        s.setMovies(name);
	                    }
	                }
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
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class SingleStarDAO {
	public HashMap<Integer,SingleStarPage> list(){
        HashMap<Integer,SingleStarPage> starpages = new HashMap<Integer,SingleStarPage>();
		
	  
		 // Incorporate mySQL driver
	
	
        try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();

			Connection connection = DriverManager.getConnection("jdbc:mysql:///moviedb","root", "root");
			
			Statement select = connection.createStatement();
            Statement select2 = connection.createStatement();
            Statement select3 = connection.createStatement();
            ResultSet result = select.executeQuery("Select id, first_name, last_name, photo_url, dob from stars");
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
                starpages.put(id, s);
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
		return starpages;
		
	
	
		
	}
	

}

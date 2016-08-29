<%@ page import="java.sql.*" %>
<% Class.forName("com.mysql.jdbc.Driver"); %>

<HTML>
    <HEAD>
        <TITLE>Browsing Movies</TITLE>
    </HEAD>

    <BODY>
        <H1>Navigating in a Database Table </H1>
        <FORM NAME="form1" ACTION="BrowsingByMovieGenre.jsp" METHOD="POST">

        <% 
            int current = 1;
            if(request.getParameter("hidden") != null) {
                current = Integer.parseInt(request.getParameter("hidden"));
            }
            int currentX = 10;
            if(request.getParameter("X") != null) {
                currentX = Integer.parseInt(request.getParameter("X"));
            }
            Connection connection = DriverManager.getConnection(
            		"jdbc:mysql:///moviedb", "root", "root");

            Statement statement = connection.createStatement();
            
            String id = request.getParameter("name");

            ResultSet resultset = 
                statement.executeQuery("select movie_id from movies NATURAL JOIN genres_in_movies NATURAL JOIN genres where genres.name = '" + id + "'");
           // String name = resultset

            if(current < 1){
                current = 1;
            }

            resultset.last();
            int rows = resultset.getRow();
            if(current <= rows){
                resultset.absolute(current);
            }    
        %>

            <TABLE BORDER="1">
                <TR>
                    <TH>ID</TH>
                  
                </TR>
<%
int i=0;
while(resultset.next() && i<currentX) {
  i++;
%>
                <TR>
                    <TD> <%= resultset.getString(1) %> </TD>
                  
                </TR>
<%
}
%>
            </TABLE>
            <BR>
            <INPUT TYPE="HIDDEN" NAME="hidden" VALUE="<%= current %>">
             <INPUT TYPE="TEXT" NAME="X" VALUE="<%=currentX%>">
            <INPUT TYPE="BUTTON" VALUE="Next Record" ONCLICK="moveNext()">
            <INPUT TYPE="BUTTON" VALUE="Previous Record" ONCLICK="movePrevious()">
        </FORM>

        <SCRIPT>
            <!--
            function moveNext()
            {
                var counter = 0
                counter = parseInt(document.form1.hidden.value) + parseInt(document.form1.X.value)
                document.form1.hidden.value = counter
                form1.submit()
            }    
            function movePrevious()
            {
                var counter = 0
                counter = parseInt(document.form1.hidden.value) - parseInt(document.form1.X.value)
                document.form1.hidden.value = counter
                form1.submit()
            }    
            // --> 
        </SCRIPT>
    </BODY>
</HTML>
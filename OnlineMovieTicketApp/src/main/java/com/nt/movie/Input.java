package com.nt.movie;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/userinput")
public class Input extends HttpServlet {
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
        // read form fields
        String movieName = request.getParameter("movieName");
        String genere = request.getParameter("genere");
        String duration = request.getParameter("duration");
        String director = request.getParameter("director");
         
        System.out.println("movie: " + movieName);
        System.out.println("genere: " + genere);
 
        // do some processing here...
        try
        {
          // create a database connection
          String myDriver = "oracle.jdbc.driver.OracleDriver";
          String myUrl = "jdbc:oracle:thin:@localhost:1521:ORCL";
          Class.forName(myDriver);
          Connection conn = DriverManager.getConnection(myUrl, "hyd", "nit");
          // the  insert statement
          String query = " insert into moviedatabase01(id,Title,genere,duration,director) values(id_seq7.nextval,?, ?, ?, ?)";

          // create the insert preparedvstatement
          PreparedStatement preparedStmt = conn.prepareStatement(query);
          preparedStmt.setString (1, movieName);
          preparedStmt.setString (2, genere);
          preparedStmt.setInt(3, Integer.parseInt(duration));
          preparedStmt.setString(4, director);

          // execute the preparedstatement
          preparedStmt.execute();
          
          conn.close();
          response.sendRedirect("option.jsp");
        }
        catch (Exception e)
        {
        	e.printStackTrace();			/*
			 * System.err.println("Got an exception!"); System.err.println(e.getMessage());
			 */
        }
			
			//stmt.executeUpdate("insert into moviedatabase " + "values('"+ movieName +"','"+ genere + "',"+ duration +",'"+ director + "')");

			
        // get response writer
//        PrintWriter writer = response.getWriter();
//         
//        // build HTML code
//        String htmlRespone = "<html>";
//        htmlRespone += "<h2>Your username is: " + movieName + "<br/>";      
//        htmlRespone += "Your password is: " + genere + "</h2>";    
//        htmlRespone += "</html>";
//         
//        // return response
//        writer.println(htmlRespone);
         
    }
 
}

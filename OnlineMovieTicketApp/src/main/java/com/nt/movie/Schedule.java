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

@WebServlet("/schedule")
public class Schedule extends HttpServlet {
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
        // read form fields
        String movieId = request.getParameter("movieId");
        String screen = request.getParameter("screen");
        String slot = request.getParameter("slot");
         
        System.out.println("movie: " + movieId);
        System.out.println("genere: " + screen+" "+slot);
 
        // do some processing here...
        try
        {
          // create a  database connection
          String myDriver = "oracle.jdbc.driver.OracleDriver";
          String myUrl = "jdbc:oracle:thin:@localhost:1521:ORCL";
          Class.forName(myDriver);
          Connection conn = DriverManager.getConnection(myUrl, "hyd", "nit");
          // the insert statement
          String query = " insert into shows01 (id,MId, screen, slot, booked)values(id_seq8.nextval,?, ?, ?, ?)";

          // create the insert preparedstatement
          PreparedStatement preparedStmt = conn.prepareStatement(query);
          preparedStmt.setInt(1, Integer.parseInt(movieId));
          preparedStmt.setInt(2, Integer.parseInt(screen));
          preparedStmt.setInt(3, Integer.parseInt(slot));
          preparedStmt.setInt(4, 0);

          // execute the preparedstatement
          preparedStmt.execute();
          
          conn.close();
          response.sendRedirect("option.jsp");
        }
        catch (Exception e)
        {
        	e.printStackTrace();
			/*
			 * System.err.println("Got an exception!"); System.err.println(e.getMessage());
			 */
        }
      
    }
 
}

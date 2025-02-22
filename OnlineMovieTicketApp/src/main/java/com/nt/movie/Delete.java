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

@WebServlet("/delete")
public class Delete extends HttpServlet {
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
        // read form fields
        String movieName = request.getParameter("movieName");
         
        System.out.println("movie: " + movieName);
 
        // do some processing here...
        try
        {
          // create a mysql database connection
          String myDriver = "oracle.jdbc.driver.OracleDriver";
          String myUrl = "jdbc:oracle:thin:@localhost:1521:ORCL";
          Class.forName(myDriver);
          Connection conn = DriverManager.getConnection(myUrl, "hyd", "nit");
          // the mysql insert statement
          String query = " delete from moviedatabase01 where title = ?";

          // create the mysql insert preparedvstatement
          PreparedStatement preparedStmt = conn.prepareStatement(query);
          preparedStmt.setString (1, movieName);
          // execute the preparedstatement
          preparedStmt.execute();
          
          conn.close();
          response.sendRedirect("options.jsp");
        }
        catch (Exception e)
        {
          System.err.println("Got an exception!");
          System.err.println(e.getMessage());
        }
            
//            //stmt.executeUpdate("insert into moviedatabase " + "values('"+ movieName +"','"+ genere + "',"+ duration +",'"+ director + "')");
//
//            
//        // get response writer
//        PrintWriter writer = response.getWriter();
//         
//       
//        // build HTML code
//        String htmlRespone = "<html>";
//        htmlRespone += "<h2>Movie " + movieName + " Deleted<br/>";    
//        htmlRespone += "</html>";
//         
//        // return response
//        writer.println(htmlRespone);
         
    }
 
}

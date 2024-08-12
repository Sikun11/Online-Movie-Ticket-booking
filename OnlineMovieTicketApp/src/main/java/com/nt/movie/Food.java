package com.nt.movie;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/food")
public class Food extends HttpServlet {
 
    protected void doPost(HttpServletRequest request,
            HttpServletResponse response) throws ServletException, IOException {
         
        // read form fields
    	int foodcost=0;
        String foodId = request.getParameter("id");
        if(foodId.equals("food1")){
        	foodcost=100;
        }
        else if(foodId.equals("food2")){
        	foodcost=150;
        }
        else if(foodId.equals("food3")){
        	foodcost=200;
        }
        // do some processing here...
        try
        {
        	int total= foodcost+Book.cost;
        	PrintWriter writer = response.getWriter();
            String htmlRespone = "<html style=\\\"background: linear-gradient(to bottom, red, yellow);\\\">";   
            htmlRespone += "<center><div style='border:1px solid black; border-radius:3px; width:400px;'><h2>BILL</h2><hr><br/><h3>Tickets: " + Book.cost + "</h3><h3>Food Combo: " + foodcost + "</h3><hr><h3>Total: " + total + "</h3><br></div></center>"; 
//            htmlRespone += "<h2>Bill</h2><br/>";
//            htmlRespone += "<h2>Tickets: "+ book.cost +"</h2><br/>";
//            htmlRespone += "<h2>Food: "+ foodcost +"</h2><br/>";
//            htmlRespone += "<h2>Total: "+ total +"</h2><br/>";
            htmlRespone+="</html>";
            writer.println(htmlRespone);
            htmlRespone="<br><center><br><a href='user.jsp'><button>Back</button></a></center>";
            writer.println(htmlRespone);
         }
        catch (Exception e)
        {
          System.err.println("Got an exception!");
          System.err.println(e.getMessage());
        }
      
    }
 
}

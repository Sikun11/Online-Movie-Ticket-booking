package com.nt.movie;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/book")
public class Book extends HttpServlet {
	static int cost = 0;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// read form fields
		String showId = request.getParameter("id");
		String num = request.getParameter("num");
		String clss = request.getParameter("class");

		System.out.println(clss);
//        System.out.println("movie: " + movieId);
//        System.out.println("genere: " + screen+" "+slot);

		// do some processing here...
		try {
			// create a mysql database connection
			String myDriver = "oracle.jdbc.driver.OracleDriver";
			String myUrl = "jdbc:oracle:thin:@localhost:1521:ORCL";
			Class.forName(myDriver);
			Connection conn = DriverManager.getConnection(myUrl, "hyd", "nit");
			// the mysql insert statement
			Statement stmt = null;
			stmt = conn.createStatement();
			String query = " select mid, screen, slot, booked from shows01 where id=" + showId;
			System.out.println(showId);
			ResultSet rs = null, rs2 = null;
			int screen = 0, slot = 0, booked = 0, mid = 0;
			rs = stmt.executeQuery(query);
			PrintWriter writer = response.getWriter();
			String htmlRespone = "<html style=\"background: linear-gradient(to bottom, red, yellow);\">";

			if (rs == null) {
				htmlRespone += "<h2>Wrong Entry</h2><br/>";
			}
			while (rs.next()) {
				screen = rs.getInt("screen");
				slot = rs.getInt("slot");
				booked = rs.getInt("booked");
				mid = rs.getInt("mid");
			}

			query = " select * from moviedatabase01 where id=" + mid;
			rs = stmt.executeQuery(query);
			String name = null, genere = null, director = null;
			int duration = 0;
			while (rs.next()) {
				name = rs.getString("title");
				genere = rs.getString("genere");
				duration = rs.getInt("duration");
				director = rs.getString("director");

			}
			String htmlResponse2;
			// return response

			if (clss.equals("silver")) {
				cost = 100;
			} else if (clss.equals("gold")) {
				cost = 150;
			} else if (clss.equals("platinum")) {
				cost = 200;
			}

			int number = Integer.parseInt(num);
			cost *= number;
			System.out.println(cost);
			switch (screen) {
			case 1:
				if (slot == 1) {
					showS1T1 m = new showS1T1(name, genere, duration, director);
					m.booked = booked;
					if (!m.bookNew(number)) {
						htmlRespone += "<center><h2>Show Full</h2><br/></center>";
					} else {
						htmlRespone += "<center><div style='border:1px solid black; border-radius:3px; width:400px;'><h2>Tickets Booked</h2><hr><br/><h3>Please pay Rs."
								+ cost + "</h3><br><hr><p>order: " + number + " x " + clss + " tickets<br>Movie: "
								+ name + "- (" + duration + " minutes)</p><h2>Screen: " + screen + "</h2><br><h2>Slot: "
								+ slot + "</h2></div></center>";
						query = " update shows01 set booked=" + m.booked + " where id=" + showId;
						System.out.println(query);
						PreparedStatement preparedStmt = conn.prepareStatement(query);
						preparedStmt.execute();
					}
				} else if (slot == 2) {
					showS1T2 m = new showS1T2(name, genere, duration, director);
					m.booked = booked;
					if (!m.bookNew(number)) {
						htmlRespone += "<center><h2>Show Full</h2><br/></center>";
					} else {
						htmlRespone += "<center><div style='border:1px solid black; border-radius:3px; width:400px;'><h2>Tickets Booked</h2><hr><br/><h3>Please pay Rs."
								+ cost + "</h3><br><hr><p>order: " + number + " x " + clss + " tickets<br>Movie: "
								+ name + "- (" + duration + " minutes)</p><h2>Screen: " + screen + "</h2><br><h2>Slot: "
								+ slot + "</h2></div></center>";
						query = " update shows01 set booked=" + m.booked + " where id=" + showId;
						System.out.println(query);
						PreparedStatement preparedStmt = conn.prepareStatement(query);
						preparedStmt.execute();
					}
				} else {
					showS1T3 m = new showS1T3(name, genere, duration, director);
					m.booked = booked;
					if (!m.bookNew(number)) {
						htmlRespone += "<center><h2>Show Full</h2><br/></center>";
					} else {
						htmlRespone += "<center><div style='border:1px solid black; border-radius:3px; width:400px;'><h2>Tickets Booked</h2><hr><br/><h3>Please pay Rs."
								+ cost + "</h3><br><hr><p>order: " + number + " x " + clss + " tickets<br>Movie: "
								+ name + "- (" + duration + " minutes)</p><h2>Screen: " + screen + "</h2><br><h2>Slot: "
								+ slot + "</h2></div></center>";
						query = " update shows01 set booked=" + m.booked + " where id=" + showId;
						System.out.println(query);
						PreparedStatement preparedStmt = conn.prepareStatement(query);
						preparedStmt.execute();
					}
				}
				break;

			case 2:
				if (slot == 1) {
					showS2T1 m = new showS2T1(name, genere, duration, director);
					m.booked = booked;
					if (!m.bookNew(number)) {
						htmlRespone += "<center><h2>Show Full</h2><br/></center>";
					} else {
						htmlRespone += "<center><div style='border:1px solid black; border-radius:3px; width:400px;'><h2>Tickets Booked</h2><hr><br/><h3>Please pay Rs."
								+ cost + "</h3><br><hr><p>order: " + number + " x " + clss + " tickets<br>Movie: "
								+ name + "- (" + duration + " minutes)</p><h2>Screen: " + screen + "</h2><br><h2>Slot: "
								+ slot + "</h2></div></center>";
						query = " update shows01 set booked=" + m.booked + " where id=" + showId;
						System.out.println(query);
						PreparedStatement preparedStmt = conn.prepareStatement(query);
						preparedStmt.execute();
					}
				} else if (slot == 2) {
					showS2T2 m = new showS2T2(name, genere, duration, director);
					m.booked = booked;
					if (!m.bookNew(number)) {
						htmlRespone += "<center><h2>Show Full</h2><br/></center>";
					} else {
						htmlRespone += "<center><div style='border:1px solid black; border-radius:3px; width:400px;'><h2>Tickets Booked</h2><hr><br/><h3>Please pay Rs."
								+ cost + "</h3><br><hr><p>order: " + number + " x " + clss + " tickets<br>Movie: "
								+ name + "- (" + duration + " minutes)</p><h2>Screen: " + screen + "</h2><br><h2>Slot: "
								+ slot + "</h2></div></center>";
						query = " update shows01 set booked=" + m.booked + " where id=" + showId;
						System.out.println(query);
						PreparedStatement preparedStmt = conn.prepareStatement(query);
						preparedStmt.execute();
					}
				} else {
					showS2T3 m = new showS2T3(name, genere, duration, director);
					m.booked = booked;
					if (!m.bookNew(number)) {
						htmlRespone += "<center><h2>Show Full</h2><br/></center>";
					} else {
						htmlRespone += "<center><div style='border:1px solid black; border-radius:3px; width:400px;'><h2>Tickets Booked</h2><hr><br/><h3>Please pay Rs."
								+ cost + "</h3><br><hr><p>order: " + number + " x " + clss + " tickets<br>Movie: "
								+ name + "- (" + duration + " minutes)</p><h2>Screen: " + screen + "</h2><br><h2>Slot: "
								+ slot + "</h2></div></center>";
						query = " update shows01 set booked=" + m.booked + " where id=" + showId;
						System.out.println(query);
						PreparedStatement preparedStmt = conn.prepareStatement(query);
						preparedStmt.execute();
					}
				}
				break;

			case 3:
				if (slot == 1) {
					showS3T1 m = new showS3T1(name, genere, duration, director);
					m.booked = booked;
					if (!m.bookNew(number)) {
						htmlRespone += "<center><h2>Show Full</h2><br/></center>";
					} else {
						htmlRespone += "<center><div style='border:1px solid black; border-radius:3px; width:400px;'><h2>Tickets Booked</h2><hr><br/><h3>Please pay Rs."
								+ cost + "</h3><br><hr><p>order: " + number + " x " + clss + " tickets<br>Movie: "
								+ name + "- (" + duration + " minutes)</p><h2>Screen: " + screen + "</h2><br><h2>Slot: "
								+ slot + "</h2></div></center>";
						query = " update shows01 set booked=" + m.booked + " where id=" + showId;
						System.out.println(query);
						PreparedStatement preparedStmt = conn.prepareStatement(query);
						preparedStmt.execute();
					}
				} else if (slot == 2) {
					showS3T2 m = new showS3T2(name, genere, duration, director);
					m.booked = booked;
					if (!m.bookNew(number)) {
						htmlRespone += "<center><h2>Show Full</h2><br/></center>";
					} else {
						htmlRespone += "<center><div style='border:1px solid black; border-radius:3px; width:400px;'><h2>Tickets Booked</h2><hr><br/><h3>Please pay Rs."
								+ cost + "</h3><br><hr><p>order: " + number + " x " + clss + " tickets<br>Movie: "
								+ name + "- (" + duration + " minutes)</p><h2>Screen: " + screen + "</h2><br><h2>Slot: "
								+ slot + "</h2></div></center>";
						query = " update shows01 set booked=" + m.booked + " where id=" + showId;
						System.out.println(query);
						PreparedStatement preparedStmt = conn.prepareStatement(query);
						preparedStmt.execute();
					}
				} else {
					showS3T3 m = new showS3T3(name, genere, duration, director);
					m.booked = booked;
					if (!m.bookNew(number)) {
						htmlRespone += "<center><h2>Show Full</h2><br/></center>";
					} else {
						htmlRespone += "<center><div style='border:1px solid black; border-radius:3px; width:400px;'><h2>Tickets Booked</h2><hr><br/><h3>Please pay Rs."
								+ cost + "</h3><br><hr><p>order: " + number + " x " + clss + " tickets<br>Movie: "
								+ name + "- (" + duration + " minutes)</p><h2>Screen: " + screen + "</h2><br><h2>Slot: "
								+ slot + "</h2></div></center>";
						query = " update shows01 set booked=" + m.booked + " where id=" + showId;
						System.out.println(query);
						PreparedStatement preparedStmt = conn.prepareStatement(query);
						preparedStmt.execute();
					}
				}
				break;

			default:
				htmlRespone += "<center><h2>Wrong Input</h2><br/></center>";

			}

			conn.close();
			htmlRespone += "</html>";
			writer.println(htmlRespone);
			htmlRespone = "<br><center><a href='food.jsp' style='font-size:30px;'>Order Meal</a><br><br><a href='user.jsp'><button>Back</button></a></center>";
			writer.println(htmlRespone);
			// response.sendRedirect("options.jsp");
		} catch (Exception e) {
			
	 System.err.println("Got an exception!"); System.err.println(e.getMessage());
			 
			
		}
	}
}

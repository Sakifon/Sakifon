package servlets.cours;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.connection;

@WebServlet(name = "addCours", value = "/addCours")
public class Add extends HttpServlet {

        @Override
        public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
            try (Connection conn = new connection().getConnection()) {
                PreparedStatement stmt = conn.prepareStatement("INSERT INTO cours (nom, description, date_debut, date_fin) VALUES (?, ?, ?, ?)");
                stmt.setString(1, request.getParameter("nom"));
                stmt.setString(2, request.getParameter("description"));
                stmt.setDate(3, java.sql.Date.valueOf(request.getParameter("date_debut")));
                stmt.setDate(4, java.sql.Date.valueOf(request.getParameter("date_fin")));
                stmt.executeUpdate();
                response.sendRedirect("/listCours");
            } catch (SQLException e) {
                throw new ServletException("SQL error", e);
            }
        }
}
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

@WebServlet(name = "CoursUpdate", value = "/CoursUpdate")
public class CoursUpdate extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));
        String nom = request.getParameter("nom");
        String description = request.getParameter("description");
        String dateDebut = request.getParameter("date_debut");
        String dateFin = request.getParameter("date_fin");
        System.out.println("id: " + id);
        System.out.println("nom: " + nom);
        System.out.println("description: " + description);
        System.out.println("dateDebut: " + dateDebut);
        System.out.println("dateFin: " + dateFin);

        try (Connection conn = new connection().getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("UPDATE cours SET nom = ?, description = ?, date_debut = ?, date_fin = ? WHERE id = ?");
            stmt.setString(1, nom);
            stmt.setString(2, description);
            stmt.setString(3, dateDebut);
            stmt.setString(4, dateFin);
            stmt.setInt(5, id);

            stmt.executeUpdate();
            response.sendRedirect("/listCours");
        } catch (SQLException e) {
            throw new ServletException("SQL error", e);
        }
    }
}
package servlets.cours;

import connection.connection;

import utils.Cours;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "CoursEdit", value = "/CoursEdit")
public class CoursEdit extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        int id = Integer.parseInt(request.getParameter("id"));

        try (Connection conn = new connection().getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM cours WHERE id = ?");
            stmt.setInt(1, id);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                Cours cours = new Cours();
                cours.setId(rs.getInt("id"));
                cours.setNom(rs.getString("nom"));
                cours.setDescription(rs.getString("description"));
                cours.setDateDebut(rs.getDate("date_debut"));
                cours.setDateFin(rs.getDate("date_fin"));

                request.setAttribute("cours", cours);
                request.getRequestDispatcher("/cours/edit.jsp").forward(request, response);
            } else {
                response.sendRedirect("/listCours");
            }
        } catch (SQLException e) {
            throw new ServletException("SQL error", e);
        }
    }
}
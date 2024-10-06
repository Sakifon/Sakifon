package servlets.cours;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import connection.connection;
import utils.Cours;

@WebServlet(name = "listCours", value = "/listCours")
public class CoursList extends HttpServlet {

    @Override
    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        try (Connection conn = new connection().getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT * FROM cours");

            ResultSet rs = stmt.executeQuery();
            List<Cours> coursList = new ArrayList<>();
            while(rs.next()){
                Cours cours = new Cours();
                cours.setId(rs.getInt("id"));
                cours.setNom(rs.getString("nom"));
                cours.setDescription(rs.getString("description"));
                cours.setDateDebut(rs.getDate("date_debut"));
                cours.setDateFin(rs.getDate("date_fin"));
                coursList.add(cours);
            }

            request.setAttribute("cours", coursList);
            request.getRequestDispatcher("/cours/index.jsp").forward(request, response);

        } catch (SQLException e) {
            throw new ServletException("SQL error", e);
        }
    }
}
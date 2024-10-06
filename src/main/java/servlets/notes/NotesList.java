package servlets.notes;

import connection.connection;

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

import utils.Note ;

@WebServlet(name = "NotesList", urlPatterns = {"/notes"})
public class NotesList extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        List<Note> notes = new ArrayList<>();
        Connection connection = new connection().getConnection();
        try {
            String role = (String) request.getSession().getAttribute("role");
            Integer userId = null;

            if (role.equals("student")) {
                userId = (Integer) request.getSession().getAttribute("id");
            }
            String query = "SELECT notes.*, user.first_name,user.last_name, cours.nom AS cours_name FROM notes INNER JOIN user ON notes.user_id = user.id INNER JOIN cours ON notes.course_id = cours.id";
            if (role.equals("student")) {
                query += " WHERE user.id = ?";
            }
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            if (role.equals("student")) {
                preparedStatement.setInt(1, userId);
            }
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                Note note = new Note();
                note.setUsername(resultSet.getString("first_name") + " " + resultSet.getString("last_name"));
                note.setCours_name(resultSet.getString("cours_name"));
                note.setNote1(resultSet.getInt("note1"));
                note.setNote2(resultSet.getInt("note2"));
                note.setNote3(resultSet.getInt("note3"));
                note.setNote4(resultSet.getInt("note4"));
                System.out.println(note);
                notes.add(note);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        request.setAttribute("notes", notes);
        request.getRequestDispatcher("/notes/index.jsp").forward(request, response);
    }
}
package servlets.notes;

import connection.connection;

import utils.Note;

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

@WebServlet(name = "NoteSearchByCourse", urlPatterns = {"/searchNotesByCourse"})
public class NoteSearchByCourse extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String courseIdStr = request.getParameter("cours_id");
        if (courseIdStr == null) {
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "Course ID must be provided");
            return;
        }
        int courseId = Integer.parseInt(courseIdStr);
        List<Note> notes = new ArrayList<>();
        try (Connection conn = new connection().getConnection()) {
            PreparedStatement stmt = conn.prepareStatement(
                    "SELECT notes.*, user.first_name,user.last_name, cours.nom AS cours_name FROM notes " +
                            "INNER JOIN user ON notes.user_id = user.id " +
                            "INNER JOIN cours ON notes.course_id = cours.id " +
                            "WHERE cours.id = ?"
            );
            stmt.setInt(1, courseId);
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Note note = new Note();
                note.setUsername(rs.getString("first_name") + " " + rs.getString("last_name"));
                note.setCours_name(rs.getString("cours_name"));
                note.setNote1(rs.getInt("note1"));
                note.setNote2(rs.getInt("note2"));
                note.setNote3(rs.getInt("note3"));
                note.setNote4(rs.getInt("note4"));
                notes.add(note);
            }
        } catch (SQLException e) {
            throw new ServletException("Error fetching notes", e);
        }
        request.setAttribute("notes", notes);
        request.getRequestDispatcher("/notes/searchResults.jsp").forward(request, response);
    }
}


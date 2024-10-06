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

import utils.User;
import utils.Cours;

@WebServlet(name = "AddNoteServlet", value = "/addNote")
public class NoteCreate extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<User> students = new ArrayList<>();
        List<Cours> courses = new ArrayList<>();

        // Fetch list of students
        try (Connection conn = new connection().getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT id,first_name, last_name FROM user WHERE role = 'student'");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                User student = new User();
                student.setId(rs.getInt("id"));
                student.setFirstName(rs.getString("first_name"));
                student.setLastName(rs.getString("last_name"));

                // Add student to the list
                students.add(student);
            }
        } catch (SQLException e) {
            throw new ServletException("Error fetching students", e);
        }

        // Fetch list of courses
        try (Connection conn = new connection().getConnection()) {
            PreparedStatement stmt = conn.prepareStatement("SELECT id,nom FROM cours");
            ResultSet rs = stmt.executeQuery();
            while (rs.next()) {
                Cours course = new Cours();
                course.setId(rs.getInt("id"));
                course.setNom(rs.getString("nom"));
                // Add course to the list
                courses.add(course);
            }
        } catch (SQLException e) {
            throw new ServletException("Error fetching courses", e);
        }

        // Set attributes for JSP
        request.setAttribute("etudiants", students);
        request.setAttribute("cours", courses);

        // Forward to the JSP page
        request.getRequestDispatcher("notes/create.jsp").forward(request, response);
    }



}
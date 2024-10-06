package servlets.notes;

import connection.connection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;



@WebServlet(name = "StoreNoteServlet", urlPatterns = {"/storeNote"})
public class Add extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String userIdStr = request.getParameter("user_id");
        String courseIdStr = request.getParameter("cours_id");
        String note1Str = request.getParameter("note1");
        String note2Str = request.getParameter("note2");
        String note3Str = request.getParameter("note3");
        String note4Str = request.getParameter("note4");

        // Check if any of the parameters are null or empty and handle it
        if (userIdStr == null || courseIdStr == null || note1Str == null || note2Str == null || note3Str == null || note4Str == null) {
            // Handle the error here, for example, you can send an error response
            response.sendError(HttpServletResponse.SC_BAD_REQUEST, "All parameters must be provided");
            return;
        }
        // Retrieve data from the form
        int userId = Integer.parseInt(userIdStr);
        int courseId = Integer.parseInt(courseIdStr);
        int note1 = Integer.parseInt(note1Str);
        int note2 = Integer.parseInt(note2Str);
        int note3 = Integer.parseInt(note3Str);
        int note4 = Integer.parseInt(note4Str);

        // Store the data in the database
        Connection connection = new connection().getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(
                    "INSERT INTO notes (user_id, course_id, note1, note2, note3, note4) VALUES (?, ?, ?, ?, ?, ?)"
            );
            preparedStatement.setInt(1, userId);
            preparedStatement.setInt(2, courseId);
            preparedStatement.setInt(3, note1);
            preparedStatement.setInt(4, note2);
            preparedStatement.setInt(5, note3);
            preparedStatement.setInt(6, note4);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            throw new ServletException("Error storing note", e);
        }

        // Redirect to the notes list servlet to display updated data
        response.sendRedirect(request.getContextPath() + "/notes");
    }
}
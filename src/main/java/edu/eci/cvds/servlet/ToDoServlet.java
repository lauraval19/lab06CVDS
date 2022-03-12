/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.eci.cvds.servlet;

import java.io.IOException;
import java.util.Optional;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import edu.eci.cvds.servlet.model.Todo;
import java.io.FileNotFoundException;
import java.io.Writer;
import java.net.MalformedURLException;
import java.util.ArrayList;

/**
 *
 * @author laura.alvarado-g
 */
@WebServlet(
        urlPatterns = "/servletJsonPlaceHolder"
)
public class ToDoServlet extends HttpServlet {

    static final long serialVersionUID = 35L;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer responseWriter = resp.getWriter();
        ArrayList<Todo> listaxhacer = new ArrayList();
        try {
            Optional<String> optId = Optional.ofNullable(req.getParameter("id"));
            String id = optId.isPresent() && !optId.get().isEmpty() ? optId.get() : "";
            Todo todo = Service.getTodo(Integer.parseInt(id));
            listaxhacer.add(todo);
            resp.setStatus(HttpServletResponse.SC_OK);
            responseWriter.write(Service.todosToHTMLTable(listaxhacer));

        } catch (NumberFormatException nex) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } catch (MalformedURLException mex) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch (FileNotFoundException fex) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        } catch (Exception ex) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        responseWriter.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Writer responseWriter = resp.getWriter();
        ArrayList<Todo> listaxhacer = new ArrayList();
        try {
            Optional<String> optId = Optional.ofNullable(req.getParameter("id"));
            String id = optId.isPresent() && !optId.get().isEmpty() ? optId.get() : "";
            Todo todo = Service.getTodo(Integer.parseInt(id));
            listaxhacer.add(todo);
            resp.setStatus(HttpServletResponse.SC_OK);
            responseWriter.write(Service.todosToHTMLTable(listaxhacer));

        } catch (NumberFormatException nex) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        } catch (MalformedURLException mex) {
            resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
        } catch (FileNotFoundException fex) {
            resp.setStatus(HttpServletResponse.SC_NOT_FOUND);
        } catch (Exception ex) {
            resp.setStatus(HttpServletResponse.SC_BAD_REQUEST);
        }
        responseWriter.flush();
    }
}

package ru.job4j.servlets.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class UsersServlet extends HttpServlet {
    List<String> userList = new CopyOnWriteArrayList<>();
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter writer = new PrintWriter(resp.getOutputStream());
        StringBuilder sb = new StringBuilder("<table>");
        for (String login : this.userList) {
            sb.append("<tr><td>" + login + "</td></tr>");
        }
        sb.append("</table>");
        writer.append("<!DOCTYPE html>"
                + "<html lang=\"en\">"
                + "<head>"
                + "    <meta charset=\"UTF-8\">"
                + "    <title>UsersServlet</title>"
                + "</head>"
                + "<body>"
                + "<form action=' " + req.getContextPath() + "/users' method='post'>"
                + "Name : <input type='text' name='login'/>"
                + "<input type= 'submit'>"
                + "</form>"
                + "<br/>"
                + sb.toString()
                + "</body>"
                + "</html>");
        writer.flush();
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        req.getParameter("login");
        doGet(req, resp);
    }
}

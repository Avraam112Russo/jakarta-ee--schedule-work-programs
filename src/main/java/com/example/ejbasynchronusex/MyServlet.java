package com.example.ejbasynchronusex;

import jakarta.ejb.EJB;
import jakarta.inject.Inject;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;


public class MyServlet extends HttpServlet {

    @EJB
    private ProgramWorkSchedule programWorkSchedule;
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        programWorkSchedule.example();
        resp.getWriter().write("success");
    }
}

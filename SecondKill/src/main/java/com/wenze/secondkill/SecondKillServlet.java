package com.wenze.secondkill;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Random;

//@WebServlet(name = "secondKill", value = "/secondKill")
public class SecondKillServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String userid = new Random().nextInt(50000) +"" ;
        String prodid =request.getParameter("prodid");

//        boolean isSuccess=SecondKillRedis.doSecKill(userid,prodid);
        boolean isSuccess= SecondKillRedisByScript.doSecKill(userid,prodid);
        response.getWriter().print(isSuccess);
    }
}
package com.example.demoTirs;

import Domain.Bruger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "LoginServlet", value = "/LoginServlet")
public class LoginServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
//login eksisterende bruger
        String password = request.getParameter("password");
        String inputNavn = request.getParameter("navn");

        HttpSession session = request.getSession();
        String sessionId = session.getId();
        ServletContext context = request.getServletContext();
        List<Bruger> brugereContext = (List<Bruger>) context.getAttribute("brugereContext");

        if (brugereContext == null) {
            String loginBesked = "der var ikke nogen brugere med det brugernavn, eller password var forkert";
            request.setAttribute("loginBesked", loginBesked);
            return;
        }
        //      loginproces
        for (Bruger bruger : brugereContext
        ) {
            if (bruger.getNavn().equals(inputNavn) && bruger.getPassword().equals(password)) {
//    brugeren logges ind
                String loginBesked = "Du er nu logget ind som: " + bruger.getNavn();
                request.setAttribute("loginBesked", loginBesked);

                session.setAttribute("sessionId", sessionId);
                session.setAttribute("Brugernavn", inputNavn);

                request.getRequestDispatcher("/WEB-INF/Bruger.jsp").forward(request, response);


            } else {
                String loginBesked = "der var ikke nogen brugere med det brugernavn, eller password var forkert";
                request.setAttribute("loginBesked", loginBesked);
            }

        }
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");
//opret bruger
        String pass1 = request.getParameter("nytpassword");
        String pass2 = request.getParameter("nytpassword2");
        String inputNavn = request.getParameter("nytbrugernavn");

        if (pass1.isEmpty() || pass2.isEmpty() || inputNavn.isEmpty()) {
            String fejlbesked = "ingen felter må være tomme";
            request.setAttribute("messageNyBruger", fejlbesked);
        }

        ServletContext context = request.getServletContext();
        List<Bruger> brugereContext = (List<Bruger>) context.getAttribute("brugereContext");

        if (brugereContext == null) {
            brugereContext = new ArrayList<>();
        }
//        hvis brugernavnet ikke allerede findes i listen i context-scope skal brugeren oprettes
        if (!brugereContext.contains(inputNavn)) {
            if (pass1.equals(pass2)) {
                Bruger nyBruger = new Bruger(inputNavn, pass1);
                brugereContext.add(nyBruger);
                context.setAttribute("brugereContext", brugereContext);
                String messageNyBruger = "ny bruger med brugernavn " + nyBruger.getNavn() + " oprettet.";
                request.setAttribute("messageNyBruger", messageNyBruger);
                request.getRequestDispatcher("index.jsp").forward(request, response);

            } else {
                String besked = "de to passwords var ikke ens - prøv igen";
                request.setAttribute("messageNyBruger", besked);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        } else {
            String besked = "der var allerede en bruger med det navn. Prøv at logge på.";
            request.setAttribute("messageNyBruger", besked);
            request.getRequestDispatcher("index.jsp").forward(request, response);

        }


    }


    public void destroy() {
    }
}
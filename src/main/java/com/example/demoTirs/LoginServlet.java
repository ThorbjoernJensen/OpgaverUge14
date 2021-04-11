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


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>" + "du ramte min servlet via min get" + "</h1>");
        out.println("</body></html>");


        out.write("<a href=\"hello-servlet\">Hello Servlet</a>\n");

        out.write("</body>\n");
        out.write("</html>");

    }


    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

        String pass1 = request.getParameter("password");
        String pass2 = request.getParameter("password2");
        String inputNavn = request.getParameter("navn");

        PrintWriter out = response.getWriter();
        HttpSession session = request.getSession();
        String sessionId = session.getId();

        ServletContext context = request.getServletContext();

        List<Bruger> brugereContext = (List<Bruger>) context.getAttribute("brugereContext");

        if (brugereContext == null) {
            brugereContext = new ArrayList<>();
        }

//        hvis brugernavnet ikke allerede findes i listen i context-scope
        if (!brugereContext.contains(inputNavn)) {
//            out.write("vi nåede ind til at brugeren ikke allerede findes");
            if (pass1.equals(pass2)) {
                Bruger nyBruger = new Bruger(inputNavn, pass1);
                brugereContext.add(nyBruger);
                context.setAttribute("brugereContext", brugereContext);
                String messageNyBruger = "ny bruger med brugernavn " + nyBruger.getNavn() + " oprettet.";
                request.setAttribute("messageNyBruger", messageNyBruger);
//                out.write("vi nåede ind til at de to passwords er ens");
//                request.getRequestDispatcher("/WEB-INF/Bruger.jsp").forward(request, response);

//            ny bruger oprettet / besked burde måske være valideret.
            } else {
                String besked = "de to passwords var ikke ens - prøv igen";
                request.setAttribute("msg", besked);
                request.getRequestDispatcher("index.jsp").forward(request, response);
            }
        }

//      loginproces
        for (Bruger bruger : brugereContext
        ) {
            if (bruger.getNavn().equals(inputNavn) && bruger.getPassword().equals(pass1)) {
//    brugeren logges ind
                String loginBesked = "Du er nu logget ind som: " + bruger.getNavn();
                request.setAttribute("loginBesked", loginBesked);

                session.setAttribute("sessionId", sessionId);
                session.setAttribute("Brugernavn", inputNavn);

                request.getRequestDispatcher("/WEB-INF/Bruger.jsp").forward(request, response);

            }

        }


    }


//              out.println("<html><body>");
//              out.println("<h1>" + "hej" + inputNavn  + " dine passwords er ikke ens !" +  "</h1>");
//
//              out.println("</body></html>");


//        out.write("</body>\n");
//        out.write("</html>");


    public void destroy() {
    }
}
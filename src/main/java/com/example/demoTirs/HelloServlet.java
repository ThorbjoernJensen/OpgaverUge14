package com.example.demoTirs;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class HelloServlet extends HttpServlet {


    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<html><body>");
        out.println("<h1>"  +"du ramte min servlet via min get" + "</h1>");
        out.println("</body></html>");


        out.write("<a href=\"hello-servlet\">Hello Servlet</a>\n");

        out.write("</body>\n");
        out.write("</html>");

    }



    public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
        response.setContentType("text/html");

          String pass1 = request.getParameter("password");
          String pass2 = request.getParameter("password2");
          String inputNavn =  request.getParameter("navn");

              PrintWriter out = response.getWriter();

          if (pass1.equals(pass2)) {

//              out.println("<html><body>");
//              out.println("<h1>" + "Velkomme" + inputNavn  + " du er nu logget ind" +  "</h1>");
//              out.println("<h1>" +  "dit password er  " + pass1 +  "</h1>");
//              out.println("<h1>" + "dit password er  " + pass2 +  "</h1>");
//              out.println("</body></html>");


              request.setAttribute("brugernavn",inputNavn);

              HttpSession session = request.getSession();
              String sessionId = session.getId();
              request.setAttribute("sessionId",sessionId);



              request.getRequestDispatcher("/WEB-INF/Bruger.jsp").forward(request,response);


          }

          else {

              String besked ="de to passwords var ikke ens - prøv igen";
              request.setAttribute("msg",besked);
              request.getRequestDispatcher("index.jsp").forward(request, response);


//              out.println("<html><body>");
//              out.println("<h1>" + "hej" + inputNavn  + " dine passwords er ikke ens !" +  "</h1>");
//
//              out.println("</body></html>");

          }










//        out.write("</body>\n");
//        out.write("</html>");

    }



    public void destroy() {
    }
}
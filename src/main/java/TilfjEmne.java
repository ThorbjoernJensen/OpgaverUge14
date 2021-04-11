import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.PrimitiveIterator;

@WebServlet(name = "TilføjEmne", value = "/TilføjEmne")
public class TilfjEmne extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.getRequestDispatcher("WEB-INF/Oversigt.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();
//        out.println("du har ramt println fra emne-sevlett");
        out.write("du har ramt tilføj emne-sevlett");
        String nytEmne = request.getParameter("emne");
        out.write("\n\n");
        out.write("du skal til at tilføje: " + nytEmne);

        HttpSession session = request.getSession();

        ServletContext context = request.getServletContext();

        List<String> emneListeContext = (List<String>) context.getAttribute("emneListeContext");
        if (emneListeContext == null) {
            emneListeContext = new ArrayList<>();

        }
        if (emneListeContext.contains(nytEmne)){
            String messageDublicate= "elementet findes allerede i listen";
            request.setAttribute("messageDublicate", messageDublicate);
        request.getRequestDispatcher("WEB-INF/Bruger.jsp").forward(request, response);
        }

        emneListeContext.add(nytEmne);
        int emneListeLængde = emneListeContext.size();
        context.setAttribute("emneListeContext", emneListeContext);
        context.setAttribute("emneListeContextLængde", emneListeLængde);


        List<String> emneListe = (List<String>) session.getAttribute("emneListe");
        if (emneListe == null) {
            emneListe = new ArrayList<>();

        }
        emneListe.add(nytEmne);
        int listeLængde = emneListe.size();
        session.setAttribute("emneListe", emneListe);
        session.setAttribute("emneListeLængde", listeLængde);

        request.getRequestDispatcher("WEB-INF/Bruger.jsp").forward(request, response);


    }
}

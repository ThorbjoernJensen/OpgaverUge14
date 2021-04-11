import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

@WebServlet(name = "FjernEmne", value = "/FjernEmne")
public class FjernEmne extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter out = response.getWriter();

        out.write("du har ramt fjern-emne-sevlett");

        String fjernEmne = request.getParameter("fjernemne");
        out.write("\n\n");
        out.write("du skal til at fjerne: " + fjernEmne + "\n");

        HttpSession session = request.getSession();

        ServletContext context = request.getServletContext();

        List<String> emneListeContext = (List<String>) context.getAttribute("emneListeContext");
        if (emneListeContext == null) {
            out.write("der er ingen elementer at fjerne");
        }
        out.write("Her er en oversigt over alle elementer i listen: \n");
        for (String element : emneListeContext) {
            out.write(element);
            out.write("\n");
        }

        boolean removeSucces;
        removeSucces = emneListeContext.remove(fjernEmne);
        if (removeSucces==true){
            String deleteMessage= fjernEmne + " blev fjernet fra listen";
            request.setAttribute("removeSucces", deleteMessage);
        }
        int emneListeLængde = emneListeContext.size();
        context.setAttribute("emneListeContext", emneListeContext);
        context.setAttribute("emneListeContextLængde", emneListeLængde);

        out.write("Her er en oversigt over alle elementer i listen efter sletning: \n");
        for (String element : emneListeContext) {
            out.write(element);
            out.write("\n");
        }


        List<String> emneListe = (List<String>) session.getAttribute("emneListe");
        if (emneListe == null) {
            out.write("der er ingen elementer at fjerne");
        }
        emneListe.remove(fjernEmne);
        int listeLængde = emneListe.size();
        session.setAttribute("emneListe", emneListe);
        session.setAttribute("emneListeLængde", listeLængde);

        request.getRequestDispatcher("WEB-INF/Bruger.jsp").forward(request, response);


    }
}

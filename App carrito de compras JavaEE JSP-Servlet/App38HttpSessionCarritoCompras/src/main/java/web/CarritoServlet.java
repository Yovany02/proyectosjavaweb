package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;

@WebServlet("/CarritoServlet")
public class CarritoServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Definimos el tipo de formato a procesar
        response.setContentType("text/html;charset=UTF-8");

        // Creamos o recuperamos el objeto http session
        HttpSession sesion = request.getSession();

        // Recuperar la lista de articulos agregados previamente si existen
        List<String> articulos = (List<String>) sesion.getAttribute("articulos");

        // Verificamos si la lista de articulos existe
        if (articulos == null) {
            // Inicializamos la lista de articulos
            articulos = new ArrayList<>();
            sesion.setAttribute("articulos", articulos);
        }

        // Procesamos el nuevo articulo
        String articuloNuevo = request.getParameter("articulo");

        // Revisamos y agregamos el articulo nuevo
        if (articuloNuevo != null && !articuloNuevo.trim().equals("")) {
            articulos.add(articuloNuevo);
        }
        
        // Usar try with resourses para que en automático cierre el flujo (opcional)
        try ( // Imprimimos la lista de articulos
                PrintWriter out = response.getWriter()) {
            out.print("<h1>Lista de articulos</h1>");
            out.print("<br>");
            // Iteramos todos los articulos
            for (String articulo : articulos) {
                out.print("<li>" + articulo + "</li>");
            }
            // Agregamos un link para regresar al inicio
            out.print("<br>");
            out.print("<a href='/App38HttpSessionCarritoCompras'> Regresar al inicio</a>");
        }
    }

}

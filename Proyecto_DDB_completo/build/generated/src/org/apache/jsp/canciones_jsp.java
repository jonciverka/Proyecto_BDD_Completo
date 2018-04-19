package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import db.dao.ListaReproduccionDAO;
import db.dao.ArtistaDAO;
import java.util.List;
import db.dao.*;
import db.entity.*;

public final class canciones_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("   <head>\r\n");
      out.write("\t<title></title>\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"./css/bootstrap.min.css\" integrity=\"sha384-Gn5384xqQ1aoWXA+058RXPxPg6fy4IWvTNh0E263XmFcJlSAwiGgFAW/dAiS6JXm\" crossorigin=\"anonymous\">\r\n");
      out.write("\t<script src=\"https://code.jquery.com/jquery-3.2.1.slim.min.js\" integrity=\"sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("\t<script src=\"https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js\" integrity=\"sha384-ApNbgh9B+Y1QKtv3Rn7W3mgPxhU9K/ScQsAP7hUibX39j7fakFPskvXusvfa0b4Q\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("\t<script src=\"./js/bootstrap.min.js\" integrity=\"sha384-JZR6Spejh4U02d8jOt6vLEHfe/JQGiRRSQQxSfFWpi1MquVdAyjUar5+76PVCmYl\" crossorigin=\"anonymous\"></script>\r\n");
      out.write("\t<link rel=\"stylesheet\" type=\"text/css\" href=\"./css/styles.css\">\r\n");
      out.write("    </head>\r\n");
      out.write("    <body>\r\n");
      out.write("        \r\n");
      out.write("        ");

            Usuario u = (Usuario) session.getAttribute("usuario");
            Administrador a = (Administrador) session.getAttribute("admin");
            List<DatosPago> datosPago = null;
            DatosPagoDAO dtDAO = new DatosPagoDAO();
            datosPago = dtDAO.getDatosPagos();
        
      out.write("\r\n");
      out.write("        <div class=\"container-fluid\">\r\n");
      out.write("\t\t<div class=\"row \">\r\n");
      out.write("\t\t\t<div class=\"col-md-2 colo2\"></div>\r\n");
      out.write("\t\t\t<div class=\"col-md-2 colo margen-tabLeft\" >\t\t\t\t\r\n");
      out.write("\t\t\t\t\t<nav class=\"nav flex-column \">\r\n");
      out.write("\t\t\t\t\t  <a class=\"nav-link text-color-gris active\" href=\"canciones.jsp\"><b>Inicio</b></a>\r\n");
      out.write("\t\t\t\t\t  <a class=\"nav-link text-color-gris\" href=\"playlist.jsp\"><b>Tu musica</b></a>\t\r\n");
      out.write("                                          ");
       if(datosPago.size()==0){
                                                    out.println("<a class='nav-link text-color-gris' href='premium.jsp'><b>HAZTE PREIUM</b></a>");
                                                    }   
                                                int  v = 0;
                                                 for(int p=0; p<datosPago.size(); p++){
                                                 if(datosPago.get(p).getIdUsuario()==u.getIdUsuario()){                                                     
                                                     v=1;                                                    
                                                 }                                                
                                                } 
                                                if(v==0){
                                                    out.println("<a class='nav-link text-color-gris' href='premium.jsp'><b>HAZTE PREIUM</b></a>");
                                                }                                            
                                            
      out.write("\t\r\n");
      out.write("\t\t\t\t\t  <li class=\"nav-link text-color-gris\" >");
out.println(u.getNombre());
      out.write("</li>\t\r\n");
      out.write("\t\t\t\t\t  <a class=\"nav-link text-color-gris\" href=\"login.html\"><b>Cerrar sesion</b></a>\t\t \r\n");
      out.write("\t\t\t\t\t</nav>\t\t\t    \r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</div>\t\t\t\t\r\n");
      out.write("\t\t\t<div class=\"col-md-10 color-cafe-fondo\">\r\n");
      out.write("\t\t\t\t<ul class=\"nav justify-content-center margen\">\r\n");
      out.write("\t\t\t\t  \r\n");
      out.write("\t\t\t\t  <li class=\"nav-item\">\r\n");
      out.write("\t\t\t\t     <a class=\"nav-link text-color-gris active\" href=\"canciones.jsp\">CANCIONES.</a>\r\n");
      out.write("\t\t\t\t  </li>                                  \r\n");
      out.write("                                  <li class=\"nav-item\">\r\n");
      out.write("                                      <a class=\"nav-link text-color-gris\" href=\"albumes.jsp\">LAS PLAYLIST DE TODOS.</a>\r\n");
      out.write("\t\t\t\t  </li>\r\n");
      out.write("\t\t\t\t</ul>\r\n");
      out.write("\t\t\t\t<H1><b><center class=\"color-blanco margen\">Canciones</center></b> </H1>\t\r\n");
      out.write("\t\t\t\t<div class=\"row\">\r\n");
      out.write("\t\t\t\t\t<div class=\"col-md-12\">\r\n");
      out.write("\t\t\t\t\t\t<ul id=\"playlist\" class=\"list-group list-group-flush tranaparente\">\r\n");
      out.write("\t\t        \t\t\t");

                                                CancionDAO cDAO = new CancionDAO();
                                                List<Cancion> canciones = cDAO.getCanciones();

                                                for (int i = 0; i < canciones.size(); i++) {
                                                    out.println("<li class=\"list-group-item tranaparente \">\n"
                                                            + "     <a href=\"Canciones/"+canciones.get(i).getIdCancion()+".mp3\"><span class=\"text-color-gris\">" + canciones.get(i).getNombre() + "</span></a>\n"
                                                             + "     <a class=\"btn btn-success float-right  \" data-toggle=\"collapse\" href=\"#collapseExample"+i+"\" role=\"button\" aria-expanded\false\" aria-controls=\"collapseExample\">\n"
                                                                + "         Agregar a Lista.\n"
                                                                 + "       </a>  \n"
                                                                    + " </li>"
                                                       );
                                                            out.println("<div class=\"float-right\">\n"
                                                                        + "<div class=\"chico float-right\">\n"
                                                                        + "<div class=\"collapse\" id=\"collapseExample"+i+"\" class=\"chico float-right\">\n"
                                                                        + "    <div class=\"card card-body\">\n"
                                                                        + "      <form action=\"upload?op=6\" method=\"post\">\n"
                                                                        + "<select name=\"lista\" class=\"form-control\" id=\"sel1\">\n"

                                                            );
                                                                        
                                                                        ListaReproduccionDAO lDAO1 = new ListaReproduccionDAO(); 
                                                                        List <ListaReproduccion>  listaReproduccion1 = lDAO1.buscarLista(u.getIdUsuario());
                                                                        for(int o=0; o<listaReproduccion1.size(); o++){
                                                                            if(listaReproduccion1.size()==0){
                                                                                
                                                                            }else{
                                                                               out.println("<option value='" + listaReproduccion1.get(o).getIdLista() + "'>" + listaReproduccion1.get(o).getNombre() + "</option>");
                                                                            }
                                                                        }                                                     
                                                                        out.println("</select>\n"                                                             
                                                                                   + "<input type=\"hidden\" class=\"form-control\" name=\"id\" placeholder=\"Nombre\" value=\""+canciones.get(i).getIdCancion()+"\">"
                                                                                   + "        <center style=\"padding-top: 30px\">\n"
                                                                                   + "            <button type=\"submit\" class=\"btn btn-success btn-lg btn-block\" ><b>AGREGAR.</b></button>\n"
                                                                                   + "        </center>\n"
                                                                                   + "       </form>\n"
                                                                                            +"</div>\n"
                                                                                   +"</div>\n"
                                                                                   + "  </div>\n"
                                                                                   + "  </div>"
                                  );
                                                }
                                            
      out.write("\r\n");
      out.write("\t\t        \t\t</ul>\r\n");
      out.write("    \t\t\t\t</div>\r\n");
      out.write("\t\t\t\t</div>\t\t\r\n");
      out.write("\t\t\t\r\n");
      out.write("\t\t\t</div>\r\n");
      out.write("\t\t</div>\r\n");
      out.write("\t\t<FOOTER>\r\n");
      out.write("\t\t\t<nav class=\"navbar fixed-bottom navbar-light footer\">\r\n");
      out.write("\t\t\t\t<div class=\"center\">\r\n");
      out.write("\t\t\t  <audio src=\"\" controls id=\"audioPlayer\">\r\n");
      out.write("        \t\t\tSorry, your browser doesn't support html5!\r\n");
      out.write("    \t\t\t</audio>    \r\n");
      out.write("    \t\t\t</div>\t\t\t\r\n");
      out.write("\t\t\t</nav>\t\r\n");
      out.write("\t\t</FOOTER>\r\n");
      out.write("\t</div>\r\n");
      out.write("                                    \r\n");
      out.write("\t<script src=\"https://code.jquery.com/jquery-2.2.0.js\"></script>\r\n");
      out.write("    <script src=\"./js/audioPlayer.js\"></script>\r\n");
      out.write("    <script>\r\n");
      out.write("        audioPlayer();\r\n");
      out.write("    </script>\r\n");
      out.write("    </body>\r\n");
      out.write("</html>\r\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}

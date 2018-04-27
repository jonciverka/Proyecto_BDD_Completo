<%@page import="java.util.List"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="db.dao.*"%>
<%@page import="db.entity.*"%>
<!DOCTYPE html>
<html>
  <head>
        <title></title>
        <link rel="stylesheet" href="./css/bootstrap.min.css"  >        
	 
        <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.12.9/umd/popper.min.js"></script>
        <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.9.1/jquery.min.js"></script>
        <script src="./js/bootstrap.min.js" ></script>
        <script src="./js/bootbox.min.js"></script>
        <link rel="stylesheet" type="text/css" href="./css/styles.css">
    </head>
    <body>
         <%
            Usuario u = (Usuario) session.getAttribute("usuario");
            Administrador a = (Administrador) session.getAttribute("admin");
            List<DatosPago> datosPago = null;
            DatosPagoDAO dtDAO = new DatosPagoDAO();
            datosPago = dtDAO.getDatosPagos();
        %>
	<div class="container-fluid">
		<div class="row ">
			<div class="col-md-2 colo2"></div>
			<div class="col-md-2 colo margen-tabLeft" >				
					<nav class="nav flex-column ">
					  <a class="nav-link text-color-gris " href="canciones.jsp"><b>Inicio</b></a>
					  <a class="nav-link text-color-gris active" href="playlist.jsp"><b>Tu musica</b></a>	
                                          <%       if(datosPago.size()==0){
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
                                            %>	
					  <li class="nav-link text-color-gris" ><%out.println(u.getNombre());%></li>	
					  <a class="nav-link text-color-gris" href="login.html"><b>Cerrar sesion</b></a>		 
					</nav>		    
			
			</div>				
			<div class="col-md-10 color-verde-fondo">
				<ul class="nav justify-content-center margen">
				  <li class="nav-item">
				    <a class="nav-link text-color-gris active " href="playlist.jsp">PLAYLISTS</a>
				  </li>
				  <li class="nav-item">
				    <a class="nav-link text-color-gris " href="Artistas.jsp">ARTISTAS</a>
				  </li>
				  <li class="nav-item">
				     <a class="btn btn-success" data-toggle="collapse" href="#collapseExamples" role="button" aria-expanded="false" aria-controls="collapseExample">
                                        NUEVA PLAYLIST.
                                      </a>                                      
				  </li>
                                  <div class="collapse" id="collapseExamples">
                                    <div class="card card-body">
                                      <form action="upload?op=5" method="post">	     		
                                        <div class="form-group tam ">
                                            <input type="hidden" class="form-control" name="id" placeholder="Nombre" value='<%out.println(u.getIdUsuario());%>'>    
                                            <input type="text" class="form-control" name="nombre" placeholder="Nombre">    
                                        </div>
                                        <center style="padding-top: 30px">
                                            <button type="submit" class="btn btn-success btn-lg btn-block" ><b>AGREGAR.</b></button>
                                        </center>
                                       </form>
                                  </div>
                                  </div>
                                      
				</ul>
				<H1><b><center class="color-blanco margen">Generos</center></b> </H1>
                             
			<div class="row ">
                            <% 
                                ListaReproduccionDAO lDAO1 = new ListaReproduccionDAO();
                                List < ListaReproduccion> ListaReproducciones1 = lDAO1.buscarLista(u.getIdUsuario());                                
                                
                                CancionListaDAO ClDAO = new CancionListaDAO();
                                
                                
                                CancionDAO Ca = new CancionDAO();
                                
                                for(int i = 0; i<ListaReproducciones1.size(); i++){
                                    List < CancionLista > l = ClDAO.buscarLista(ListaReproducciones1.get(i).getIdLista());
                                    
                                    if(i<6){                                       
                                        out.println("<div class=\"col-md-2\">"
                                                + "<a href=\"#collapseExample"+i+"\" data-toggle=\"collapse\">"
                                                + "<img src=\"src/Untitled-1.png\" class=\"img-fluid\" alt=\"Responsive image sombra \">"
                                                + "</a>"
                                                + "<p class=\"color-blanco text-center texto-discos\">"+ListaReproducciones1.get(i).getNombre()+""
                                                + "</p>"
                                                + "</div>"
                                        +"<div class=\"collapse\" id=\"collapseExample"+i+"\"> \n"
                                        +"<div class=\"card card-body\"> \n"); 
                                       for(int o=0; o<l.size(); o++){
                                       List <Cancion> cn = Ca.buscarCancion(l.get(o).getIdCancion());  
                                       out.println("<ul id=\"playlist\" class=\"list-group list-group-flush tranaparente\"> ");
                                       
                                       for(int t=0; t<cn.size();t++){
                                          out.println("<li class=\"list-group-item tranaparente \">\n");
                                            out.println("<a href=\"Canciones/"+cn.get(t).getIdCancion()+".mp3\"><span onclick='inc(" + cn.get(i).getIdCancion() + ")'>" + cn.get(t).getNombre() + "</span></a>\n");
                                             out.println("</li>"); 
                                               }
                                        
                                       } 
                                       out.println("</ul>");
                                        out.println("  </div> \n"
                                                +"  </div> \n"                                        
                                        );                                        
                                    }else if(i>=6){
                                        if(i<12){
                                          out.println("<div class=\"col-md-2\"><img src=\"src/Untitled-1.png\" class=\"img-fluid\" alt=\"Responsive image sombra \"><p class=\"color-blanco text-center texto-discos\">"+ListaReproducciones1.get(i).getNombre()+"</p></div>");  
                                        }                                        
                                    
                                }
                                }
                            %>
				
			</div>
			</div>
		</div>
                             <script>
                                function inc(id) {
                                    $.get("Reproducciones?id=" + id, function (data, status) {
                                        //alert("Data: " + data + "\nStatus: " + status);
                                        if(data==='1'){
                                                bootbox.confirm({
                                                message: "Felicidades!!! Has ganado un premio de parte de Spotiti. ¿Desea Reclamarlo?",
                                                buttons: {
                                                    confirm: {
                                                        label: 'Si',
                                                        className: 'btn-success'
                                                    },
                                                    cancel: {
                                                        label: 'No',
                                                        className: 'btn-danger'
                                                    }
                                                },
                                                callback: function (result) {
                                                    console.log('This was logged in the callback: ' + result);
                                                }
                                            });
                                        }
                                    });
                                    
                                    
                                }
                               
                       
                            </script>
		<FOOTER>
			<nav class="navbar fixed-bottom navbar-light footer">
				<div class="center">
			  <audio src="" controls id="audioPlayer">
        			Sorry, your browser doesn't support html5!
    			</audio>    
    			</div>			
			</nav>	
		</FOOTER>
	</div>
	<script src="https://code.jquery.com/jquery-2.2.0.js"></script>
    <script src="./js/audioPlayer.js"></script>
    <script>
        audioPlayer();
    </script>
    </body>
</html>

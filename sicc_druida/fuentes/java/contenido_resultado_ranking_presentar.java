
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_resultado_ranking_presentar  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_resultado_ranking_presentar" );
      ((Element)v.get(0)).setAttribute("cod","0529" );
      ((Element)v.get(0)).setAttribute("titulo","Presentar resultado de ranking" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","resultado_ranking_presentar" );
      ((Element)v.get(0)).setAttribute("onload","onLoad();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Elemento padre:4 / Elemento actual: 5   */
      v.add(doc.createTextNode("\r   \r  \r   var codigo;\r  \r     function onLoad(){\r        configurarMenuSecundario('Formulario');\r        fMostrarMensajeError();\r     }\r\r   function close(){\r      this.close();\r   }\r   \r\r   function obtenerOid(){\r      var nivel_pulsado = arbolM('name0','?');\r      codigo = arbolM('name0','C?',nivel_pulsado); \r      return true;\r   }\r\r   \r   function verDesglose(){\r   \r      if(codigo == undefined || codigo ==\"\") {\r          GestionarMensaje('4');\r          \r      } else {\r      \r          var nivelAgrupacion = get('Formulario.nivelAgrupacion');\r          var cteGeneral      = get('Formulario.agrupacionGeneral');\r          var cteSGV          = get('Formulario.agrupacionSGV');\r          var cteRegion       = get('Formulario.agrupacionRegion');\r          var cteZona         = get('Formulario.agrupacionZona');\r          var cteSeccion      = get('Formulario.agrupacionSeccion');\r          var cteTerritorio   = get('Formulario.agrupacionTerritorio');\r                   \r          for(var k=0;k<ListaArbol.datos.longitud;k++) {\r          \r             if (ListaArbol.datos.ij(k,0) == codigo){ 	\r                         \r                var a;\r                     \r                if((nivelAgrupacion == cteGeneral) || (nivelAgrupacion == cteSGV)){\r                   a = crearObjetoSGV(k);\r                }\r                \r                if(nivelAgrupacion == cteRegion){\r                   a = crearObjetoRegion(k);\r                }\r                \r                if(nivelAgrupacion == cteZona){\r                   a = crearObjetoZona(k);\r                }\r                \r                if(nivelAgrupacion == cteSeccion){\r                   a = crearObjetoSeccion(k);\r                }\r                        \r                mostrarModalSICC('LPMantenimientoRanking','verDesglose', a);            \r             }\r          } \r      } \r  }\r\r\r   function crearObjetoSGV(k){\r      \r      var a = new Object();\r      a.accion         = \"verDesglose\";\r      a.nivelAgrupacion = get('Formulario.nivelAgrupacion');\r      a.sgv            = ListaArbol.datos.ij(k,2);\r      a.gerente        = ListaArbol.datos.ij(k,4);\r      a.impVentas      = ListaArbol.datos.ij(k,6);\r      a.actiIni        = ListaArbol.datos.ij(k,7);\r      a.actiFinal      = ListaArbol.datos.ij(k,8);\r      a.nPedidos       = ListaArbol.datos.ij(k,9);\r      a.actividad      = ListaArbol.datos.ij(k,10);\r      a.constancia     = ListaArbol.datos.ij(k,11);\r      a.ingresos       = ListaArbol.datos.ij(k,12);\r      a.reingresos     = ListaArbol.datos.ij(k,13);\r      a.egresos        = ListaArbol.datos.ij(k,14);\r      a.entregadas     = ListaArbol.datos.ij(k,15);\r      a.recibidas      = ListaArbol.datos.ij(k,16);\r      a.capitalizacion = ListaArbol.datos.ij(k,17);\r      a.ppu            = ListaArbol.datos.ij(k,18);\r      a.pvp            = ListaArbol.datos.ij(k,19);\r      a.pup            = ListaArbol.datos.ij(k,20);\r      a.pop            = ListaArbol.datos.ij(k,21);\r      a.retencion      = ListaArbol.datos.ij(k,22);\r      a.cobranza       = ListaArbol.datos.ij(k,23);\r      a.rotacion       = ListaArbol.datos.ij(k,24);\r      \r      return a;\r   }\r   \r\r   function crearObjetoRegion(k){\r      var a = new Object();\r      a.accion         = \"verDesglose\";\r      a.nivelAgrupacion = get('Formulario.nivelAgrupacion');\r      a.sgv            = ListaArbol.datos.ij(k,2);\r      a.region         = ListaArbol.datos.ij(k,4);\r      a.gerente        = ListaArbol.datos.ij(k,6);\r      a.impVentas      = ListaArbol.datos.ij(k,8);\r      a.actiIni        = ListaArbol.datos.ij(k,9);\r      a.actiFinal      = ListaArbol.datos.ij(k,10);\r      a.nPedidos       = ListaArbol.datos.ij(k,11);\r      a.actividad      = ListaArbol.datos.ij(k,12);\r      a.constancia     = ListaArbol.datos.ij(k,13);\r      a.ingresos       = ListaArbol.datos.ij(k,14);\r      a.reingresos     = ListaArbol.datos.ij(k,15);\r      a.egresos        = ListaArbol.datos.ij(k,16);\r      a.entregadas     = ListaArbol.datos.ij(k,17);\r      a.recibidas      = ListaArbol.datos.ij(k,18);\r      a.capitalizacion = ListaArbol.datos.ij(k,19);\r      a.ppu            = ListaArbol.datos.ij(k,20);\r      a.pvp            = ListaArbol.datos.ij(k,21);\r      a.pup            = ListaArbol.datos.ij(k,22);\r      a.pop            = ListaArbol.datos.ij(k,23);\r      a.retencion      = ListaArbol.datos.ij(k,24);\r      a.cobranza       = ListaArbol.datos.ij(k,25);\r      a.rotacion       = ListaArbol.datos.ij(k,26);\r      \r      return a;\r   \r   }\r   \r\r   function crearObjetoZona(k){\r      var a = new Object();\r      a.accion         = \"verDesglose\";\r      a.nivelAgrupacion = get('Formulario.nivelAgrupacion');\r      a.sgv            = ListaArbol.datos.ij(k,2);\r      a.region         = ListaArbol.datos.ij(k,4);\r      a.zona           = ListaArbol.datos.ij(k,6);\r      a.gerente        = ListaArbol.datos.ij(k,8);\r      a.impVentas      = ListaArbol.datos.ij(k,10);\r      a.actiIni        = ListaArbol.datos.ij(k,11);\r      a.actiFinal      = ListaArbol.datos.ij(k,12);\r      a.nPedidos       = ListaArbol.datos.ij(k,13);\r      a.actividad      = ListaArbol.datos.ij(k,14);\r      a.constancia     = ListaArbol.datos.ij(k,15);\r      a.ingresos       = ListaArbol.datos.ij(k,16);\r      a.reingresos     = ListaArbol.datos.ij(k,17);\r      a.egresos        = ListaArbol.datos.ij(k,18);\r      a.entregadas     = ListaArbol.datos.ij(k,19);\r      a.recibidas      = ListaArbol.datos.ij(k,20);\r      a.capitalizacion = ListaArbol.datos.ij(k,21);\r      a.ppu            = ListaArbol.datos.ij(k,22);\r      a.pvp            = ListaArbol.datos.ij(k,23);\r      a.pup            = ListaArbol.datos.ij(k,24);\r      a.pop            = ListaArbol.datos.ij(k,25);\r      a.retencion      = ListaArbol.datos.ij(k,26);\r      a.cobranza       = ListaArbol.datos.ij(k,27);\r      a.rotacion       = ListaArbol.datos.ij(k,28);\r      \r      return a;\r   \r   }\r\r\r   function crearObjetoSeccion(k){\r      var a = new Object();\r      a.accion         = \"verDesglose\";\r      a.nivelAgrupacion = get('Formulario.nivelAgrupacion');\r   \r      a.sgv            = ListaArbol.datos.ij(k,2);\r      a.region         = ListaArbol.datos.ij(k,4);\r      a.zona           = ListaArbol.datos.ij(k,6);\r      a.seccion        = ListaArbol.datos.ij(k,8);\r      a.gerente        = ListaArbol.datos.ij(k,10);\r      a.impVentas      = ListaArbol.datos.ij(k,12);\r      a.actiIni        = ListaArbol.datos.ij(k,13);\r      a.actiFinal      = ListaArbol.datos.ij(k,14);\r      a.nPedidos       = ListaArbol.datos.ij(k,15);\r      a.actividad      = ListaArbol.datos.ij(k,16);\r      a.constancia     = ListaArbol.datos.ij(k,17);\r      a.ingresos       = ListaArbol.datos.ij(k,18);\r      a.reingresos     = ListaArbol.datos.ij(k,19);\r      a.egresos        = ListaArbol.datos.ij(k,20);\r      a.entregadas     = ListaArbol.datos.ij(k,21);\r      a.recibidas      = ListaArbol.datos.ij(k,22);\r      a.capitalizacion = ListaArbol.datos.ij(k,23);\r      a.ppu            = ListaArbol.datos.ij(k,24);\r      a.pvp            = ListaArbol.datos.ij(k,25);\r      a.pup            = ListaArbol.datos.ij(k,26);\r      a.pop            = ListaArbol.datos.ij(k,27);\r      a.retencion      = ListaArbol.datos.ij(k,28);\r      a.cobranza       = ListaArbol.datos.ij(k,29);\r      a.rotacion       = ListaArbol.datos.ij(k,30);\r      \r      return a;\r   \r   }\r   \r\r   function asignarPremios(){\r      if(ListaArbol.datos.longitud!=0) {\r      \r          var nivelAgrupacion = get('Formulario.nivelAgrupacion');\r          var gerentes = new String();\r         \r          if((nivelAgrupacion == '1') || (nivelAgrupacion == '2')){\r              gerentes = obtenerGerentes(3);\r          }\r          \r          if(nivelAgrupacion == '3'){\r             gerentes = obtenerGerentes(5);\r             \r          }\r          \r          if(nivelAgrupacion == '4'){\r              gerentes = obtenerGerentes(7);\r          }\r          \r          if(nivelAgrupacion == '5'){\r              gerentes = obtenerGerentes(9);\r          }\r         \r         \r          var a = new Object();\r          a.gerentes = gerentes;\r          a.accion = 'asignarPremiosRankingRecuperarNiveles';\r          a.concurso = get('Formulario.oidConcurso');\r           \r          mostrarModalSICC('LPMantenimientoRanking','asignarPremiosRankingRecuperarNiveles', a);          \r          \r      } else {\r          GestionarMensaje('1581');\r      }\r   }\r   \r\r   function obtenerGerentes(posicion){\r   \r      var gerentes = new String();\r   \r      for(var k=0;k<ListaArbol.datos.longitud;k++){\r         gerentes = gerentes + ListaArbol.datos.ij(k,posicion) + ',';\r      }\r      \r      gerentes = gerentes.substring(0, gerentes.length - 1)\r      return gerentes;\r  }\r   \r   \r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","Formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","accion" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","idioma" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","pais" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","nivelAgrupacion" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","agrupacionGeneral" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","agrupacionSGV" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","agrupacionRegion" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","agrupacionZona" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","agrupacionSeccion" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","agrupacionTerritorio" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","oidConcurso" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(22)).setAttribute("nombre","capa1" );
      ((Element)v.get(6)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("table"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("width","100%" );
      ((Element)v.get(23)).setAttribute("border","0" );
      ((Element)v.get(23)).setAttribute("cellspacing","0" );
      ((Element)v.get(23)).setAttribute("cellpadding","0" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).setAttribute("width","12" );
      ((Element)v.get(25)).setAttribute("align","center" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(26)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).setAttribute("width","12" );
      ((Element)v.get(26)).setAttribute("height","12" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:27 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).setAttribute("width","750" );
      ((Element)v.get(24)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:29 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).setAttribute("width","12" );
      ((Element)v.get(24)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(30)).setAttribute("src","b.gif" );
      ((Element)v.get(30)).setAttribute("width","12" );
      ((Element)v.get(30)).setAttribute("height","1" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */
      /* Termina nodo:24   */

      /* Empieza nodo:31 / Elemento padre: 23   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(23)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(33)).setAttribute("src","b.gif" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:34 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(36)).setAttribute("class","legend" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(37)).setAttribute("nombre","lblInformacionPremios" );
      ((Element)v.get(37)).setAttribute("alto","13" );
      ((Element)v.get(37)).setAttribute("filas","1" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(37)).setAttribute("cod","00331" );
      ((Element)v.get(37)).setAttribute("id","legend" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:38 / Elemento padre: 35   */
      v.add(doc.createElement("table"));
      ((Element)v.get(38)).setAttribute("width","100%" );
      ((Element)v.get(38)).setAttribute("border","0" );
      ((Element)v.get(38)).setAttribute("align","center" );
      ((Element)v.get(38)).setAttribute("cellspacing","0" );
      ((Element)v.get(38)).setAttribute("cellpadding","0" );
      ((Element)v.get(35)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).setAttribute("colspan","4" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).setAttribute("width","8" );
      ((Element)v.get(41)).setAttribute("height","8" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:42 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).setAttribute("width","8" );
      ((Element)v.get(44)).setAttribute("height","339" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).setAttribute("width","100%" );
      ((Element)v.get(42)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","450" );
      ((Element)v.get(46)).setAttribute("height","8" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */
      /* Termina nodo:42   */

      /* Empieza nodo:47 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).setAttribute("colspan","4" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","8" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */
      /* Termina nodo:38   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:50 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","8" );
      ((Element)v.get(51)).setAttribute("height","12" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:31   */

      /* Empieza nodo:52 / Elemento padre: 23   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(23)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("table"));
      ((Element)v.get(57)).setAttribute("width","100%" );
      ((Element)v.get(57)).setAttribute("border","0" );
      ((Element)v.get(57)).setAttribute("align","center" );
      ((Element)v.get(57)).setAttribute("cellspacing","0" );
      ((Element)v.get(57)).setAttribute("cellpadding","0" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).setAttribute("class","botonera" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(60)).setAttribute("nombre","btnAsignarPremios" );
      ((Element)v.get(60)).setAttribute("ID","botonContenido" );
      ((Element)v.get(60)).setAttribute("tipo","html" );
      ((Element)v.get(60)).setAttribute("accion","verDesglose();" );
      ((Element)v.get(60)).setAttribute("estado","false" );
      ((Element)v.get(60)).setAttribute("cod","1795" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 59   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(61)).setAttribute("nombre","btnVerDesglose" );
      ((Element)v.get(61)).setAttribute("ID","botonContenido" );
      ((Element)v.get(61)).setAttribute("tipo","html" );
      ((Element)v.get(61)).setAttribute("accion","asignarPremios();" );
      ((Element)v.get(61)).setAttribute("estado","false" );
      ((Element)v.get(61)).setAttribute("cod","1796" );
      ((Element)v.get(59)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:62 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","8" );
      ((Element)v.get(63)).setAttribute("height","12" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:52   */

      /* Empieza nodo:64 / Elemento padre: 23   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(23)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("width","12" );
      ((Element)v.get(65)).setAttribute("align","center" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","12" );
      ((Element)v.get(66)).setAttribute("height","12" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("width","750" );
      ((Element)v.get(64)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("width","12" );
      ((Element)v.get(64)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","12" );
      ((Element)v.get(70)).setAttribute("height","12" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:64   */
      /* Termina nodo:23   */
      /* Termina nodo:22   */

      /* Empieza nodo:71 / Elemento padre: 6   */
      v.add(doc.createElement("SCROLL"));
      ((Element)v.get(71)).setAttribute("nombre","scrollPrincipal" );
      ((Element)v.get(71)).setAttribute("x","20" );
      ((Element)v.get(71)).setAttribute("y","25" );
      ((Element)v.get(71)).setAttribute("ancho","310" );
      ((Element)v.get(71)).setAttribute("alto","220" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(71)).setAttribute("colorf","" );
      ((Element)v.get(71)).setAttribute("visibilidad","visible" );
      ((Element)v.get(71)).setAttribute("incx","10" );
      ((Element)v.get(71)).setAttribute("incy","10" );
      ((Element)v.get(71)).setAttribute("colores","" );
      ((Element)v.get(6)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("REJILLA"));
      ((Element)v.get(72)).setAttribute("nombre","RArbol" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:6   */


   }

}


import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_datos_concurso_ranking_mostrar  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         

      getXML450(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_datos_concurso_ranking_mostrar" );
      ((Element)v.get(0)).setAttribute("cod","0527" );
      ((Element)v.get(0)).setAttribute("titulo","Calcular Ranking" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
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
      v.add(doc.createTextNode("\r   \r\r  function onLoadPag()   {\r    fMostrarMensajeError();\r    configurarMenuSecundario('Formulario');\r    DrdEnsanchaConMargenDcho('listado1',12);\r\r    document.all[\"Cplistado1\"].style.visibility='';\r    document.all[\"CpLin1listado1\"].style.visibility='';\r    document.all[\"CpLin2listado1\"].style.visibility='';\r    document.all[\"CpLin3listado1\"].style.visibility='';\r    document.all[\"CpLin4listado1\"].style.visibility='';\r\r    document.all[\"primera1Div\"].style.visibility='hidden';\r    document.all[\"ret1Div\"].style.visibility='hidden';\r    document.all[\"ava1Div\"].style.visibility='hidden';\r    document.all[\"separaDiv\"].style.visibility='hidden';	\r    eval (ON_RSZ);\r\r		\r	    if(get(\"Formulario.pantalla\")==\"resultado concurso evolutivo\"){\r	    		if(get(\"Formulario.hIndCalificar\")=='0') {\r			deshabilitarHabilitarBoton('botonContenido','Calificar','D');\r		}\r	} else {\r		document.all[\"Calificar\"].style.visibility='hidden';\r	}\r\r    \r    cargarLista();\r\r   }\r   \r   \r   function cargarLista(){\r      var arr = new Array();\r      \r      arr[arr.length] = [\"oidConcurso\", get(\"Formulario.oidConcurso\")];\r      arr[arr.length] = [\"oidNivelPremiacion\", get(\"Formulario.oidNivelPremiacion\")];\r      arr[arr.length] = [\"numeroAspirantes\", get(\"Formulario.numAspirantes\")];\r      arr[arr.length] = [\"numeroPremio\", get(\"Formulario.numPremio\")];\r      arr[arr.length] = [\"oidPremio\", get(\"Formulario.oidPremio\")];\r      arr[arr.length] = [\"oidTipoPremio\", get(\"Formulario.oidTipoPremio\")];\r      arr[arr.length] = [\"cantidadInicialPuntos\", get(\"Formulario.inicialPuntos\")];\r      arr[arr.length] = [\"cantidadFinalPuntos\", get(\"Formulario.finalPuntos\")];\r      \r      configurarPaginado(mipgndo, \"INCGanadorasAspirantesNivel\", \"ConectorGanadorasAspirantesNivel\", \"es.indra.sicc.dtos.inc.DTONivelesRanking\", arr);\r      \r   \r   }\r\r\r   function comunicar(){\r      var oidCliente = new String();\r      var posiciones = new String();  \r      \r      for(var x=0;x<listado1.datos.length; x++) {\r                  if(listado1.datos[x][1]==\"iconDorada.gif\") {\r             oidCliente = oidCliente + listado1.datos[x][6] + ',';\r             posiciones = posiciones + (x+1) + ',';\r         }\r      }\r            \r      oidCliente = oidCliente.substring(0, oidCliente.length - 1);\r      posiciones = posiciones.substring(0, posiciones.length - 1);\r    \r      set('Formulario.oidClientes' , oidCliente);\r      set('Formulario.posiciones' , posiciones);\r      set('Formulario.accion', 'comunicar');\r      set('Formulario.conectorAction', 'LPMantenimientoRanking');\r      eval('Formulario').oculto = 'S';\r\r      enviaSICC('Formulario');   \r   }\r\r   function btCalificarOnClick(){\r	        var oidCliente = new String();\r      var posiciones = new String();  \r      \r      for(var x=0;x<listado1.datos.length; x++) {\r                  if(listado1.datos[x][1]==\"iconDorada.gif\") {\r             oidCliente = oidCliente + listado1.datos[x][6] + ',';\r             posiciones = posiciones + (x+1) + ',';\r         }\r      }\r            \r      oidCliente = oidCliente.substring(0, oidCliente.length - 1);\r      posiciones = posiciones.substring(0, posiciones.length - 1);\r    \r      set('Formulario.oidClientes' , oidCliente);\r      set('Formulario.posiciones' , posiciones);\r      set('Formulario.accion', 'calificar');\r      set('Formulario.conectorAction', 'LPMantenimientoRanking');\r      eval('Formulario').oculto = 'S';\r\r      enviaSICC('Formulario');   \r   }\r\r\r   \r"));
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
      ((Element)v.get(14)).setAttribute("nombre","oidConcurso" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","oidNivelPremiacion" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","inicialPuntos" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","finalPuntos" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","numPremio" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","numAspirantes" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","oidPremio" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","oidTipoPremio" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","oidClientes" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 6   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","posiciones" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hIndCalificar" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","pantalla" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 6   */
      v.add(doc.createElement("table"));
      ((Element)v.get(26)).setAttribute("width","100%" );
      ((Element)v.get(26)).setAttribute("border","0" );
      ((Element)v.get(26)).setAttribute("cellspacing","0" );
      ((Element)v.get(26)).setAttribute("cellpadding","0" );
      ((Element)v.get(6)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).setAttribute("width","12" );
      ((Element)v.get(28)).setAttribute("align","center" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(29)).setAttribute("src","b.gif" );
      ((Element)v.get(29)).setAttribute("width","12" );
      ((Element)v.get(29)).setAttribute("height","12" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:30 / Elemento padre: 27   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).setAttribute("width","400" );
      ((Element)v.get(27)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(31)).setAttribute("src","b.gif" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:32 / Elemento padre: 27   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).setAttribute("width","12" );
      ((Element)v.get(27)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(33)).setAttribute("src","b.gif" );
      ((Element)v.get(33)).setAttribute("width","12" );
      ((Element)v.get(33)).setAttribute("height","1" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:32   */
      /* Termina nodo:27   */
      /* Termina nodo:26   */

      /* Empieza nodo:34 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(34)).setAttribute("nombre","listado1" );
      ((Element)v.get(34)).setAttribute("ancho","400" );
      ((Element)v.get(34)).setAttribute("alto","317" );
      ((Element)v.get(34)).setAttribute("x","12" );
      ((Element)v.get(34)).setAttribute("y","12" );
      ((Element)v.get(34)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(34)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(35)).setAttribute("precarga","S" );
      ((Element)v.get(35)).setAttribute("conROver","S" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(36)).setAttribute("normal","iconEstrella.gif" );
      ((Element)v.get(36)).setAttribute("rollOver","iconEstrella.gif" );
      ((Element)v.get(36)).setAttribute("seleccionado","iconEstrella.gif" );
      ((Element)v.get(36)).setAttribute("desactivado","iconEstrella.gif" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 35   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(37)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(37)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(37)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(37)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(35)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 35   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(38)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(38)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(35)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:35   */

      /* Empieza nodo:39 / Elemento padre: 34   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(34)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(40)).setAttribute("borde","1" );
      ((Element)v.get(40)).setAttribute("horizDatos","1" );
      ((Element)v.get(40)).setAttribute("horizCabecera","1" );
      ((Element)v.get(40)).setAttribute("vertical","1" );
      ((Element)v.get(40)).setAttribute("horizTitulo","1" );
      ((Element)v.get(40)).setAttribute("horizBase","1" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 39   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(41)).setAttribute("borde","#999999" );
      ((Element)v.get(41)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(41)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(41)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(41)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(41)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(41)).setAttribute("horizBase","#999999" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(39)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:39   */

      /* Empieza nodo:42 / Elemento padre: 34   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(42)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(42)).setAttribute("alto","22" );
      ((Element)v.get(42)).setAttribute("imgFondo","" );
      ((Element)v.get(42)).setAttribute("cod","00631" );
      ((Element)v.get(42)).setAttribute("ID","datosTitle" );
      ((Element)v.get(34)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 34   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(43)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(43)).setAttribute("alto","22" );
      ((Element)v.get(43)).setAttribute("imgFondo","" );
      ((Element)v.get(34)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 34   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(44)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(44)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(44)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(44)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(44)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(44)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(34)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(45)).setAttribute("ancho","10" );
      ((Element)v.get(45)).setAttribute("minimizable","S" );
      ((Element)v.get(45)).setAttribute("minimizada","N" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 44   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(46)).setAttribute("ancho","50" );
      ((Element)v.get(46)).setAttribute("minimizable","S" );
      ((Element)v.get(46)).setAttribute("minimizada","N" );
      ((Element)v.get(44)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 44   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(47)).setAttribute("ancho","200" );
      ((Element)v.get(47)).setAttribute("minimizable","S" );
      ((Element)v.get(47)).setAttribute("minimizada","N" );
      ((Element)v.get(44)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 44   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(48)).setAttribute("ancho","75" );
      ((Element)v.get(48)).setAttribute("minimizable","S" );
      ((Element)v.get(48)).setAttribute("minimizada","N" );
      ((Element)v.get(44)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 44   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(49)).setAttribute("ancho","50" );
      ((Element)v.get(49)).setAttribute("minimizable","S" );
      ((Element)v.get(49)).setAttribute("minimizada","N" );
      ((Element)v.get(49)).setAttribute("oculta","S" );
      ((Element)v.get(44)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 44   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(50)).setAttribute("ancho","50" );
      ((Element)v.get(50)).setAttribute("minimizable","S" );
      ((Element)v.get(50)).setAttribute("minimizada","N" );
      ((Element)v.get(50)).setAttribute("oculta","S" );
      ((Element)v.get(44)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 44   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(51)).setAttribute("ancho","50" );
      ((Element)v.get(51)).setAttribute("minimizable","S" );
      ((Element)v.get(51)).setAttribute("minimizada","N" );
      ((Element)v.get(51)).setAttribute("oculta","S" );
      ((Element)v.get(44)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 44   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(52)).setAttribute("ancho","50" );
      ((Element)v.get(52)).setAttribute("minimizable","S" );
      ((Element)v.get(52)).setAttribute("minimizada","N" );
      ((Element)v.get(52)).setAttribute("oculta","S" );
      ((Element)v.get(44)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 44   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(53)).setAttribute("ancho","50" );
      ((Element)v.get(53)).setAttribute("minimizable","S" );
      ((Element)v.get(53)).setAttribute("minimizada","N" );
      ((Element)v.get(53)).setAttribute("oculta","S" );
      ((Element)v.get(44)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 44   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(54)).setAttribute("ancho","50" );
      ((Element)v.get(54)).setAttribute("minimizable","S" );
      ((Element)v.get(54)).setAttribute("minimizada","N" );
      ((Element)v.get(54)).setAttribute("oculta","S" );
      ((Element)v.get(44)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 44   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(55)).setAttribute("ancho","50" );
      ((Element)v.get(55)).setAttribute("minimizable","S" );
      ((Element)v.get(55)).setAttribute("minimizada","N" );
      ((Element)v.get(55)).setAttribute("oculta","S" );
      ((Element)v.get(44)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:44   */

      /* Empieza nodo:56 / Elemento padre: 34   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(56)).setAttribute("alto","20" );
      ((Element)v.get(56)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(56)).setAttribute("imgFondo","" );
      ((Element)v.get(56)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(34)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("COL"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(57)).setAttribute("colFondo","" );
      ((Element)v.get(57)).setAttribute("ID","EstCab" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 56   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(58)).setAttribute("colFondo","" );
      ((Element)v.get(58)).setAttribute("ID","EstCab" );
      ((Element)v.get(58)).setAttribute("cod","263" );
      ((Element)v.get(56)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 56   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(59)).setAttribute("colFondo","" );
      ((Element)v.get(59)).setAttribute("ID","EstCab" );
      ((Element)v.get(59)).setAttribute("cod","264" );
      ((Element)v.get(56)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 56   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(60)).setAttribute("colFondo","" );
      ((Element)v.get(60)).setAttribute("ID","EstCab" );
      ((Element)v.get(60)).setAttribute("cod","2118" );
      ((Element)v.get(56)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 56   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(61)).setAttribute("colFondo","" );
      ((Element)v.get(61)).setAttribute("ID","EstCab" );
      ((Element)v.get(61)).setAttribute("cod","263" );
      ((Element)v.get(56)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 56   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(62)).setAttribute("colFondo","" );
      ((Element)v.get(62)).setAttribute("ID","EstCab" );
      ((Element)v.get(62)).setAttribute("cod","264" );
      ((Element)v.get(56)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 56   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(63)).setAttribute("colFondo","" );
      ((Element)v.get(63)).setAttribute("ID","EstCab" );
      ((Element)v.get(63)).setAttribute("cod","2118" );
      ((Element)v.get(56)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 56   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(64)).setAttribute("colFondo","" );
      ((Element)v.get(64)).setAttribute("ID","EstCab" );
      ((Element)v.get(64)).setAttribute("cod","263" );
      ((Element)v.get(56)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 56   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(65)).setAttribute("colFondo","" );
      ((Element)v.get(65)).setAttribute("ID","EstCab" );
      ((Element)v.get(65)).setAttribute("cod","264" );
      ((Element)v.get(56)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 56   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(66)).setAttribute("colFondo","" );
      ((Element)v.get(66)).setAttribute("ID","EstCab" );
      ((Element)v.get(66)).setAttribute("cod","2118" );
      ((Element)v.get(56)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 56   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(67)).setAttribute("colFondo","" );
      ((Element)v.get(67)).setAttribute("ID","EstCab" );
      ((Element)v.get(67)).setAttribute("cod","263" );
      ((Element)v.get(56)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:56   */

      /* Empieza nodo:68 / Elemento padre: 34   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(68)).setAttribute("alto","22" );
      ((Element)v.get(68)).setAttribute("accion","" );
      ((Element)v.get(68)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(68)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(68)).setAttribute("maxSel","0" );
      ((Element)v.get(68)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(68)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(68)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(68)).setAttribute("onLoad","" );
      ((Element)v.get(68)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(34)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(69)).setAttribute("tipo","imagen" );
      ((Element)v.get(69)).setAttribute("ID","EstDat" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 68   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(70)).setAttribute("tipo","texto" );
      ((Element)v.get(70)).setAttribute("ID","EstDat2" );
      ((Element)v.get(68)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 68   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(71)).setAttribute("tipo","texto" );
      ((Element)v.get(71)).setAttribute("ID","EstDat" );
      ((Element)v.get(68)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 68   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(72)).setAttribute("tipo","texto" );
      ((Element)v.get(72)).setAttribute("ID","EstDat2" );
      ((Element)v.get(68)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 68   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(73)).setAttribute("tipo","texto" );
      ((Element)v.get(73)).setAttribute("ID","EstDat" );
      ((Element)v.get(68)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 68   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(74)).setAttribute("tipo","texto" );
      ((Element)v.get(74)).setAttribute("ID","EstDat2" );
      ((Element)v.get(68)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 68   */
      v.add(doc.createElement("COL"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(75)).setAttribute("tipo","texto" );
      ((Element)v.get(75)).setAttribute("ID","EstDat" );
      ((Element)v.get(68)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 68   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(76)).setAttribute("tipo","texto" );
      ((Element)v.get(76)).setAttribute("ID","EstDat2" );
      ((Element)v.get(68)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 68   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(77)).setAttribute("tipo","texto" );
      ((Element)v.get(77)).setAttribute("ID","EstDat" );
      ((Element)v.get(68)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 68   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(78)).setAttribute("tipo","texto" );
      ((Element)v.get(78)).setAttribute("ID","EstDat2" );
      ((Element)v.get(68)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 68   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(79)).setAttribute("tipo","texto" );
      ((Element)v.get(79)).setAttribute("ID","EstDat" );
      ((Element)v.get(68)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:68   */

      /* Empieza nodo:80 / Elemento padre: 34   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(34)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 34   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(81)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(81)).setAttribute("ancho","400" );
      ((Element)v.get(81)).setAttribute("sep","$" );
      ((Element)v.get(81)).setAttribute("x","12" );
      ((Element)v.get(81)).setAttribute("class","botonera" );
      ((Element)v.get(81)).setAttribute("y","306" );
      ((Element)v.get(81)).setAttribute("control","|" );
      ((Element)v.get(81)).setAttribute("conector","conector_inc" );
      ((Element)v.get(81)).setAttribute("rowset","" );
      ((Element)v.get(81)).setAttribute("cargainicial","N" );
      ((Element)v.get(34)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(82)).setAttribute("nombre","ret1" );
      ((Element)v.get(82)).setAttribute("x","37" );
      ((Element)v.get(82)).setAttribute("y","310" );
      ((Element)v.get(82)).setAttribute("ID","botonContenido" );
      ((Element)v.get(82)).setAttribute("img","retroceder_on" );
      ((Element)v.get(82)).setAttribute("tipo","0" );
      ((Element)v.get(82)).setAttribute("estado","false" );
      ((Element)v.get(82)).setAttribute("alt","" );
      ((Element)v.get(82)).setAttribute("codigo","" );
      ((Element)v.get(82)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 81   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(83)).setAttribute("nombre","ava1" );
      ((Element)v.get(83)).setAttribute("x","52" );
      ((Element)v.get(83)).setAttribute("y","310" );
      ((Element)v.get(83)).setAttribute("ID","botonContenido" );
      ((Element)v.get(83)).setAttribute("img","avanzar_on" );
      ((Element)v.get(83)).setAttribute("tipo","0" );
      ((Element)v.get(83)).setAttribute("estado","false" );
      ((Element)v.get(83)).setAttribute("alt","" );
      ((Element)v.get(83)).setAttribute("codigo","" );
      ((Element)v.get(83)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(81)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:81   */
      /* Termina nodo:34   */

      /* Empieza nodo:84 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(84)).setAttribute("nombre","primera1" );
      ((Element)v.get(84)).setAttribute("x","20" );
      ((Element)v.get(84)).setAttribute("y","310" );
      ((Element)v.get(84)).setAttribute("ID","botonContenido" );
      ((Element)v.get(84)).setAttribute("img","primera_on" );
      ((Element)v.get(84)).setAttribute("tipo","-2" );
      ((Element)v.get(84)).setAttribute("estado","false" );
      ((Element)v.get(84)).setAttribute("alt","" );
      ((Element)v.get(84)).setAttribute("codigo","" );
      ((Element)v.get(84)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(85)).setAttribute("nombre","separa" );
      ((Element)v.get(85)).setAttribute("x","59" );
      ((Element)v.get(85)).setAttribute("y","306" );
      ((Element)v.get(85)).setAttribute("ID","botonContenido" );
      ((Element)v.get(85)).setAttribute("img","separa_base" );
      ((Element)v.get(85)).setAttribute("tipo","0" );
      ((Element)v.get(85)).setAttribute("estado","false" );
      ((Element)v.get(85)).setAttribute("alt","" );
      ((Element)v.get(85)).setAttribute("codigo","" );
      ((Element)v.get(85)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(86)).setAttribute("nombre","ComunicarAParticipantes" );
      ((Element)v.get(86)).setAttribute("x","12" );
      ((Element)v.get(86)).setAttribute("y","307" );
      ((Element)v.get(86)).setAttribute("ID","botonContenido" );
      ((Element)v.get(86)).setAttribute("img","" );
      ((Element)v.get(86)).setAttribute("tipo","html" );
      ((Element)v.get(86)).setAttribute("estado","false" );
      ((Element)v.get(86)).setAttribute("alt","" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(86)).setAttribute("cod","2589" );
      ((Element)v.get(86)).setAttribute("accion","comunicar()" );
      ((Element)v.get(6)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(87)).setAttribute("nombre","Calificar" );
      ((Element)v.get(87)).setAttribute("x","205" );
      ((Element)v.get(87)).setAttribute("y","307" );
      ((Element)v.get(87)).setAttribute("ID","botonContenido" );
      ((Element)v.get(87)).setAttribute("img","" );
      ((Element)v.get(87)).setAttribute("tipo","html" );
      ((Element)v.get(87)).setAttribute("estado","false" );
      ((Element)v.get(87)).setAttribute("alt","" );
      ((Element)v.get(87)).setAttribute("cod","2590" );
      ((Element)v.get(87)).setAttribute("accion","btCalificarOnClick()" );
      ((Element)v.get(6)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(88)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(88)).setAttribute("alto","12" );
      ((Element)v.get(88)).setAttribute("ancho","100" );
      ((Element)v.get(88)).setAttribute("colorf","" );
      ((Element)v.get(88)).setAttribute("borde","0" );
      ((Element)v.get(88)).setAttribute("imagenf","" );
      ((Element)v.get(88)).setAttribute("repeat","" );
      ((Element)v.get(88)).setAttribute("padding","" );
      ((Element)v.get(88)).setAttribute("visibilidad","visible" );
      ((Element)v.get(88)).setAttribute("contravsb","" );
      ((Element)v.get(88)).setAttribute("x","0" );
      ((Element)v.get(88)).setAttribute("y","310" );
      ((Element)v.get(88)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:6   */


   }

}

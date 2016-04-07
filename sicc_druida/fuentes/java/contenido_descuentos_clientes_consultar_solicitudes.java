
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_descuentos_clientes_consultar_solicitudes  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_descuentos_clientes_consultar_solicitudes" );
      ((Element)v.get(0)).setAttribute("cod","0337" );
      ((Element)v.get(0)).setAttribute("titulo","Consultar descuentos a clientes" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag()" );
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
      v.add(doc.createTextNode("\r   \r\r  function onLoadPag()   {\r    configurarMenuSecundario(\"formulario\");  \r    DrdEnsanchaConMargenDcho('listado1',12);\r    ocultaCapas();   \r    eval (ON_RSZ);\r    accionPaginar();    \r   }\r\r   function muestraCapas() {\r    document.all[\"Cplistado1\"].style.visibility='';\r    document.all[\"CpLin1listado1\"].style.visibility='';\r    document.all[\"CpLin2listado1\"].style.visibility='';\r    document.all[\"CpLin3listado1\"].style.visibility='';\r    document.all[\"CpLin4listado1\"].style.visibility='';\r    document.all[\"primera1Div\"].style.visibility='';\r    document.all[\"ret1Div\"].style.visibility='';\r    document.all[\"ava1Div\"].style.visibility='';\r    document.all[\"separaDiv\"].style.visibility='';\r    document.all[\"DetalleDiv\"].style.visibility='';\r   }  \r\r   function ocultaCapas() {\r    document.all[\"Cplistado1\"].style.visibility='hidden';\r    document.all[\"CpLin1listado1\"].style.visibility='hidden';\r    document.all[\"CpLin2listado1\"].style.visibility='hidden';\r    document.all[\"CpLin3listado1\"].style.visibility='hidden';\r    document.all[\"CpLin4listado1\"].style.visibility='hidden';\r    document.all[\"primera1Div\"].style.visibility='hidden';\r    document.all[\"ret1Div\"].style.visibility='hidden';\r    document.all[\"ava1Div\"].style.visibility='hidden';\r    document.all[\"separaDiv\"].style.visibility='hidden';\r    document.all[\"DetalleDiv\"].style.visibility='hidden';\r   }   \r\r   function accionDetalle() {\r    if (listado1.numSelecc()!= 1) {\r      GestionarMensaje('1022',null,null,null);\r      return false;\r    }\r\r    var arrAux = new Array();\r    arrAux = listado1.codSeleccionados();\r    var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);\r    var obj = new Object();\r    obj.oidSolicitud = listado1.datos[posicion][0];    \r    \r    mostrarModalSICC('LPDescuentosPorCliente','detalleSolicitud',obj,800,400);\r    accionPaginar();\r  }\r\r  function obtenerPosicionListaEditable(clave, lista){\r    this.posicion = 0;\r    if (lista.codSeleccionados().length > 0){\r      for(var k=0;k<lista.datos.length;k++) {\r         if (lista.datos[k][0] == clave) {\r           posicion=k;\r           break;\r         }\r      }           \r      return posicion;\r    }\r   }\r\r   function accionPaginar() {\r    var arr = new Array();    \r    \r    arr[arr.length]=new Array(\"oidPais\", get(\"formulario.oidPais\"));\r    arr[arr.length]=new Array(\"oidMarca\", get(\"formulario.oidMarca\"));\r    arr[arr.length]=new Array(\"oidCanal\", get(\"formulario.oidCanal\"));\r    arr[arr.length]=new Array(\"oidCliente\", get(\"formulario.oidCliente\"));\r    arr[arr.length]=new Array(\"periodoDesde\", get(\"formulario.periodoDesde\"));\r    arr[arr.length]=new Array(\"periodoHasta\", get(\"formulario.periodoHasta\"));\r\r    configurarPaginado(mipgndo,\"DTOBuscarSolicitudesPorClienteDTO\",\"ConectorBuscarSolicitudesPorClienteDTO\",\"es.indra.sicc.dtos.dto.DTOEBuscarSolicitudesClienteDTO\",arr);\r   }\r\r   function fVolver() {    \r      window.close();\r   }\r\r   function muestraLista( ultima, rowset, error){\r    var tamano = rowset.length;\r    if (tamano > 0) {\r      muestraCapas();\r      eval (ON_RSZ);\r      focoBotonDetalle();\r      return true;      \r    }\r\r    else {\r      ocultaCapas();\r      eval (ON_RSZ);  \r           window.close();\r      return false;\r    }\r  }  \r\r  function focoBotonDetalle() {\r    focalizaBotonHTML_XY('Detalle');\r  }\r   \r   \r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","accion" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","oidPais" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","oidIdioma" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","desPais" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","oidCliente" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","oidMarca" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","oidCanal" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","codigoCliente" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","periodoDesde" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","periodoHasta" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","oid" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","oidSolicitud" );
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
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(26)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).setAttribute("width","424" );
      ((Element)v.get(26)).setAttribute("height","12" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:25   */
      /* Termina nodo:24   */
      /* Termina nodo:23   */
      /* Termina nodo:22   */

      /* Empieza nodo:27 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(27)).setAttribute("nombre","listado1" );
      ((Element)v.get(27)).setAttribute("ancho","400" );
      ((Element)v.get(27)).setAttribute("alto","299" );
      ((Element)v.get(27)).setAttribute("x","12" );
      ((Element)v.get(27)).setAttribute("y","12" );
      ((Element)v.get(27)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(27)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(28)).setAttribute("precarga","S" );
      ((Element)v.get(28)).setAttribute("conROver","S" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(29)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(29)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(29)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(29)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 28   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(30)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(30)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(30)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(30)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(28)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 28   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(31)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(31)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(28)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:28   */

      /* Empieza nodo:32 / Elemento padre: 27   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(27)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(33)).setAttribute("borde","1" );
      ((Element)v.get(33)).setAttribute("horizDatos","1" );
      ((Element)v.get(33)).setAttribute("horizCabecera","1" );
      ((Element)v.get(33)).setAttribute("vertical","1" );
      ((Element)v.get(33)).setAttribute("horizTitulo","1" );
      ((Element)v.get(33)).setAttribute("horizBase","1" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 32   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(34)).setAttribute("borde","#999999" );
      ((Element)v.get(34)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(34)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(34)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(34)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(34)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(34)).setAttribute("horizBase","#999999" );
      ((Element)v.get(32)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:32   */

      /* Empieza nodo:35 / Elemento padre: 27   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(35)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(35)).setAttribute("alto","22" );
      ((Element)v.get(35)).setAttribute("imgFondo","" );
      ((Element)v.get(35)).setAttribute("cod","00174" );
      ((Element)v.get(35)).setAttribute("ID","datosTitle" );
      ((Element)v.get(27)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 27   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(36)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(36)).setAttribute("alto","22" );
      ((Element)v.get(36)).setAttribute("imgFondo","" );
      ((Element)v.get(27)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 27   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(37)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(37)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(37)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(37)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(37)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(37)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(27)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(38)).setAttribute("ancho","90" );
      ((Element)v.get(38)).setAttribute("minimizable","S" );
      ((Element)v.get(38)).setAttribute("minimizada","N" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 37   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(39)).setAttribute("ancho","90" );
      ((Element)v.get(39)).setAttribute("minimizable","S" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(39)).setAttribute("minimizada","N" );
      ((Element)v.get(37)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 37   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(40)).setAttribute("ancho","90" );
      ((Element)v.get(40)).setAttribute("minimizable","S" );
      ((Element)v.get(40)).setAttribute("minimizada","N" );
      ((Element)v.get(37)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 37   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(41)).setAttribute("ancho","90" );
      ((Element)v.get(41)).setAttribute("minimizable","S" );
      ((Element)v.get(41)).setAttribute("minimizada","N" );
      ((Element)v.get(37)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:37   */

      /* Empieza nodo:42 / Elemento padre: 27   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(42)).setAttribute("alto","20" );
      ((Element)v.get(42)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(42)).setAttribute("imgFondo","" );
      ((Element)v.get(42)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(27)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(43)).setAttribute("colFondo","" );
      ((Element)v.get(43)).setAttribute("ID","EstCab" );
      ((Element)v.get(43)).setAttribute("cod","226" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(44)).setAttribute("colFondo","" );
      ((Element)v.get(44)).setAttribute("ID","EstCab" );
      ((Element)v.get(44)).setAttribute("cod","188" );
      ((Element)v.get(42)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(45)).setAttribute("colFondo","" );
      ((Element)v.get(45)).setAttribute("ID","EstCab" );
      ((Element)v.get(45)).setAttribute("cod","920" );
      ((Element)v.get(42)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(46)).setAttribute("colFondo","" );
      ((Element)v.get(46)).setAttribute("ID","EstCab" );
      ((Element)v.get(46)).setAttribute("cod","341" );
      ((Element)v.get(42)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:42   */

      /* Empieza nodo:47 / Elemento padre: 27   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(47)).setAttribute("alto","22" );
      ((Element)v.get(47)).setAttribute("accion","" );
      ((Element)v.get(47)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(47)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(47)).setAttribute("maxSel","-1" );
      ((Element)v.get(47)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(47)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(47)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(47)).setAttribute("onLoad","" );
      ((Element)v.get(47)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(27)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(48)).setAttribute("tipo","texto" );
      ((Element)v.get(48)).setAttribute("ID","EstDat" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 47   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(49)).setAttribute("tipo","texto" );
      ((Element)v.get(49)).setAttribute("ID","EstDat2" );
      ((Element)v.get(47)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 47   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(50)).setAttribute("tipo","texto" );
      ((Element)v.get(50)).setAttribute("ID","EstDat" );
      ((Element)v.get(47)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 47   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(51)).setAttribute("tipo","texto" );
      ((Element)v.get(51)).setAttribute("ID","EstDat2" );
      ((Element)v.get(47)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:47   */

      /* Empieza nodo:52 / Elemento padre: 27   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(27)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 27   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(53)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(53)).setAttribute("ancho","400" );
      ((Element)v.get(53)).setAttribute("sep","$" );
      ((Element)v.get(53)).setAttribute("x","12" );
      ((Element)v.get(53)).setAttribute("class","botonera" );
      ((Element)v.get(53)).setAttribute("y","288" );
      ((Element)v.get(53)).setAttribute("control","|" );
      ((Element)v.get(53)).setAttribute("conector","" );
      ((Element)v.get(53)).setAttribute("rowset","" );
      ((Element)v.get(53)).setAttribute("cargainicial","N" );
      ((Element)v.get(53)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(27)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(54)).setAttribute("nombre","ret1" );
      ((Element)v.get(54)).setAttribute("x","37" );
      ((Element)v.get(54)).setAttribute("y","292" );
      ((Element)v.get(54)).setAttribute("ID","botonContenido" );
      ((Element)v.get(54)).setAttribute("img","retroceder_on" );
      ((Element)v.get(54)).setAttribute("tipo","0" );
      ((Element)v.get(54)).setAttribute("estado","false" );
      ((Element)v.get(54)).setAttribute("alt","" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(54)).setAttribute("codigo","" );
      ((Element)v.get(54)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 53   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(55)).setAttribute("nombre","ava1" );
      ((Element)v.get(55)).setAttribute("x","52" );
      ((Element)v.get(55)).setAttribute("y","292" );
      ((Element)v.get(55)).setAttribute("ID","botonContenido" );
      ((Element)v.get(55)).setAttribute("img","avanzar_on" );
      ((Element)v.get(55)).setAttribute("tipo","0" );
      ((Element)v.get(55)).setAttribute("estado","false" );
      ((Element)v.get(55)).setAttribute("alt","" );
      ((Element)v.get(55)).setAttribute("codigo","" );
      ((Element)v.get(55)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(53)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:53   */
      /* Termina nodo:27   */

      /* Empieza nodo:56 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(56)).setAttribute("nombre","primera1" );
      ((Element)v.get(56)).setAttribute("x","20" );
      ((Element)v.get(56)).setAttribute("y","292" );
      ((Element)v.get(56)).setAttribute("ID","botonContenido" );
      ((Element)v.get(56)).setAttribute("img","primera_on" );
      ((Element)v.get(56)).setAttribute("tipo","-2" );
      ((Element)v.get(56)).setAttribute("estado","false" );
      ((Element)v.get(56)).setAttribute("alt","" );
      ((Element)v.get(56)).setAttribute("codigo","" );
      ((Element)v.get(56)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(57)).setAttribute("nombre","separa" );
      ((Element)v.get(57)).setAttribute("x","59" );
      ((Element)v.get(57)).setAttribute("y","288" );
      ((Element)v.get(57)).setAttribute("ID","botonContenido" );
      ((Element)v.get(57)).setAttribute("img","separa_base" );
      ((Element)v.get(57)).setAttribute("tipo","0" );
      ((Element)v.get(57)).setAttribute("estado","false" );
      ((Element)v.get(57)).setAttribute("alt","" );
      ((Element)v.get(57)).setAttribute("codigo","" );
      ((Element)v.get(57)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(58)).setAttribute("nombre","Detalle" );
      ((Element)v.get(58)).setAttribute("x","80" );
      ((Element)v.get(58)).setAttribute("y","289" );
      ((Element)v.get(58)).setAttribute("ID","botonContenido" );
      ((Element)v.get(58)).setAttribute("tipo","html" );
      ((Element)v.get(58)).setAttribute("estado","false" );
      ((Element)v.get(58)).setAttribute("cod","3" );
      ((Element)v.get(58)).setAttribute("accion","accionDetalle();" );
      ((Element)v.get(58)).setAttribute("ontab","focoBotonDetalle();" );
      ((Element)v.get(58)).setAttribute("onshtab","focoBotonDetalle();" );
      ((Element)v.get(6)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(59)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(59)).setAttribute("alto","12" );
      ((Element)v.get(59)).setAttribute("ancho","50" );
      ((Element)v.get(59)).setAttribute("x","0" );
      ((Element)v.get(59)).setAttribute("y","311" );
      ((Element)v.get(6)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:6   */


   }

}

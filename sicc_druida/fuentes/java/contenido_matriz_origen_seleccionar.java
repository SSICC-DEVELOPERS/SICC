
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_matriz_origen_seleccionar  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_matriz_origen_seleccionar" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","Ingresar valores descuento" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag()" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode("\r          \r	function onLoadPag()   {\r			 configurarMenuSecundario('formulario');\r	    DrdEnsanchaConMargenDcho('listado1',12);\r	    document.all[\"Cplistado1\"].style.visibility='visible';\r	    document.all[\"CpLin1listado1\"].style.visibility='visible';\r	    document.all[\"CpLin2listado1\"].style.visibility='visible';\r	    document.all[\"CpLin3listado1\"].style.visibility='visible';\r	    document.all[\"CpLin4listado1\"].style.visibility='visible';\r	    document.all[\"primera1Div\"].style.visibility='visible';\r	    document.all[\"ret1Div\"].style.visibility='visible';\r	    document.all[\"ava1Div\"].style.visibility='visible';\r	    document.all[\"separaDiv\"].style.visibility='visible';\r	    document.all[\"btnCrearDiv\"].style.visibility='visible';\r	    eval (ON_RSZ);  \r	}\r\r    function accionCrear()\r    {\r        if (listado1.numSelecc() == 1){\r            var codigo = new Array();\r            \r            codigo = listado1.codSeleccionados();\r\r            set('formulario.hidOidCabeceraMatrizSel', codigo);\r            set('formulario.accion', 'crear');\r            enviaSICC('formulario');\r        }\r        else\r            GestionarMensaje('406');\r        \r    }\r\r    function accionBuscar ()\r    {\r        configurarPaginado (mipgndo,'DTOBuscarMatricesDTOActivas','ConectorBuscarMatricesDTOActivas',\r           'es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion', armarArray());\r    }\r\r    function armarArray()\r    {\r        var vArray = new Array();\r        vArray[0] = new Array('oidIdioma',get(\"formulario.hidIdioma\"));\r        vArray[1] = new Array('oidPais',get(\"formulario.hidPais\"));\r        return vArray;\r    }\r\r\r   \r  "));
      ((Element)v.get(1)).appendChild((Text)v.get(2));

      /* Termina nodo Texto:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(5)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(6)).setAttribute("valor","LPSeleccionarMatrizDTO" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","accion" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","hidOidCabeceraMatrizSel" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","hidIdioma" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","hidPais" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 5   */
      v.add(doc.createElement("table"));
      ((Element)v.get(11)).setAttribute("width","100%" );
      ((Element)v.get(11)).setAttribute("border","0" );
      ((Element)v.get(11)).setAttribute("cellspacing","0" );
      ((Element)v.get(11)).setAttribute("cellpadding","0" );
      ((Element)v.get(5)).appendChild((Element)v.get(11));

      /* Empieza nodo:12 / Elemento padre: 11   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(11)).appendChild((Element)v.get(12));

      /* Empieza nodo:13 / Elemento padre: 12   */
      v.add(doc.createElement("td"));
      ((Element)v.get(13)).setAttribute("width","100%" );
      ((Element)v.get(12)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(14)).setAttribute("src","b.gif" );
      ((Element)v.get(14)).setAttribute("width","424" );
      ((Element)v.get(14)).setAttribute("height","8" );
      ((Element)v.get(13)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */
      /* Termina nodo:13   */
      /* Termina nodo:12   */
      /* Termina nodo:11   */

      /* Empieza nodo:15 / Elemento padre: 5   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(15)).setAttribute("nombre","listado1" );
      ((Element)v.get(15)).setAttribute("ancho","400" );
      ((Element)v.get(15)).setAttribute("alto","301" );
      ((Element)v.get(15)).setAttribute("x","12" );
      ((Element)v.get(15)).setAttribute("y","12" );
      ((Element)v.get(15)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(15)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(5)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(16)).setAttribute("precarga","S" );
      ((Element)v.get(16)).setAttribute("conROver","S" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(17)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(17)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(17)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(17)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 16   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(18)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(18)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(18)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(18)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(16)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 16   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(19)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(19)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(16)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */
      /* Termina nodo:16   */

      /* Empieza nodo:20 / Elemento padre: 15   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(15)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(21)).setAttribute("borde","1" );
      ((Element)v.get(21)).setAttribute("horizDatos","1" );
      ((Element)v.get(21)).setAttribute("horizCabecera","1" );
      ((Element)v.get(21)).setAttribute("vertical","1" );
      ((Element)v.get(21)).setAttribute("horizTitulo","1" );
      ((Element)v.get(21)).setAttribute("horizBase","1" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 20   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(22)).setAttribute("borde","#999999" );
      ((Element)v.get(22)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(22)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(22)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(22)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(22)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(22)).setAttribute("horizBase","#999999" );
      ((Element)v.get(20)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */
      /* Termina nodo:20   */

      /* Empieza nodo:23 / Elemento padre: 15   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(23)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(23)).setAttribute("alto","22" );
      ((Element)v.get(23)).setAttribute("imgFondo","" );
      ((Element)v.get(23)).setAttribute("cod","0085" );
      ((Element)v.get(23)).setAttribute("ID","datosTitle" );
      ((Element)v.get(15)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 15   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(24)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(24)).setAttribute("alto","22" );
      ((Element)v.get(24)).setAttribute("imgFondo","" );
      ((Element)v.get(15)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 15   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(25)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(25)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(25)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(25)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(25)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(25)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(15)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(26)).setAttribute("ancho","1" );
      ((Element)v.get(26)).setAttribute("minimizable","S" );
      ((Element)v.get(26)).setAttribute("minimizada","N" );
      ((Element)v.get(26)).setAttribute("orden","" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:27 / Elemento padre: 15   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(27)).setAttribute("alto","20" );
      ((Element)v.get(27)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(27)).setAttribute("imgFondo","" );
      ((Element)v.get(27)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(15)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(28)).setAttribute("colFondo","" );
      ((Element)v.get(28)).setAttribute("ID","EstCab" );
      ((Element)v.get(28)).setAttribute("align","center" );
      ((Element)v.get(28)).setAttribute("cod","9" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:29 / Elemento padre: 15   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(29)).setAttribute("alto","22" );
      ((Element)v.get(29)).setAttribute("accion","" );
      ((Element)v.get(29)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(29)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(29)).setAttribute("maxSel","-1" );
      ((Element)v.get(29)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(29)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(29)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(29)).setAttribute("onLoad","" );
      ((Element)v.get(29)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(15)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(30)).setAttribute("tipo","texto" );
      ((Element)v.get(30)).setAttribute("ID","EstDat" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:31 / Elemento padre: 15   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(15)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 15   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(32)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(32)).setAttribute("ancho","400" );
      ((Element)v.get(32)).setAttribute("sep","$" );
      ((Element)v.get(32)).setAttribute("x","12" );
      ((Element)v.get(32)).setAttribute("class","botonera" );
      ((Element)v.get(32)).setAttribute("y","290" );
      ((Element)v.get(32)).setAttribute("control","|" );
      ((Element)v.get(32)).setAttribute("conector","" );
      ((Element)v.get(32)).setAttribute("rowset","" );
      ((Element)v.get(32)).setAttribute("cargainicial","N" );
      ((Element)v.get(15)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(33)).setAttribute("nombre","ret1" );
      ((Element)v.get(33)).setAttribute("x","37" );
      ((Element)v.get(33)).setAttribute("y","294" );
      ((Element)v.get(33)).setAttribute("ID","botonContenido" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(33)).setAttribute("img","retroceder_on" );
      ((Element)v.get(33)).setAttribute("tipo","0" );
      ((Element)v.get(33)).setAttribute("estado","false" );
      ((Element)v.get(33)).setAttribute("alt","" );
      ((Element)v.get(33)).setAttribute("codigo","" );
      ((Element)v.get(33)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 32   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(34)).setAttribute("nombre","ava1" );
      ((Element)v.get(34)).setAttribute("x","52" );
      ((Element)v.get(34)).setAttribute("y","294" );
      ((Element)v.get(34)).setAttribute("ID","botonContenido" );
      ((Element)v.get(34)).setAttribute("img","avanzar_on" );
      ((Element)v.get(34)).setAttribute("tipo","0" );
      ((Element)v.get(34)).setAttribute("estado","false" );
      ((Element)v.get(34)).setAttribute("alt","" );
      ((Element)v.get(34)).setAttribute("codigo","" );
      ((Element)v.get(34)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(32)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:32   */
      /* Termina nodo:15   */

      /* Empieza nodo:35 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(35)).setAttribute("nombre","primera1" );
      ((Element)v.get(35)).setAttribute("x","20" );
      ((Element)v.get(35)).setAttribute("y","294" );
      ((Element)v.get(35)).setAttribute("ID","botonContenido" );
      ((Element)v.get(35)).setAttribute("img","primera_on" );
      ((Element)v.get(35)).setAttribute("tipo","-2" );
      ((Element)v.get(35)).setAttribute("estado","false" );
      ((Element)v.get(35)).setAttribute("alt","" );
      ((Element)v.get(35)).setAttribute("codigo","" );
      ((Element)v.get(35)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(5)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(36)).setAttribute("nombre","separa" );
      ((Element)v.get(36)).setAttribute("x","59" );
      ((Element)v.get(36)).setAttribute("y","290" );
      ((Element)v.get(36)).setAttribute("ID","botonContenido" );
      ((Element)v.get(36)).setAttribute("img","separa_base" );
      ((Element)v.get(36)).setAttribute("tipo","0" );
      ((Element)v.get(36)).setAttribute("estado","false" );
      ((Element)v.get(36)).setAttribute("alt","" );
      ((Element)v.get(36)).setAttribute("codigo","" );
      ((Element)v.get(36)).setAttribute("accion","" );
      ((Element)v.get(5)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(37)).setAttribute("nombre","btnCrear" );
      ((Element)v.get(37)).setAttribute("x","80" );
      ((Element)v.get(37)).setAttribute("y","291" );
      ((Element)v.get(37)).setAttribute("ID","botonContenido" );
      ((Element)v.get(37)).setAttribute("tipo","html" );
      ((Element)v.get(37)).setAttribute("estado","false" );
      ((Element)v.get(37)).setAttribute("cod","835" );
      ((Element)v.get(37)).setAttribute("accion","accionCrear();" );
      ((Element)v.get(5)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(38)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(38)).setAttribute("alto","12" );
      ((Element)v.get(38)).setAttribute("ancho","100%" );
      ((Element)v.get(38)).setAttribute("colorf","" );
      ((Element)v.get(38)).setAttribute("borde","0" );
      ((Element)v.get(38)).setAttribute("imagenf","" );
      ((Element)v.get(38)).setAttribute("repeat","" );
      ((Element)v.get(38)).setAttribute("padding","" );
      ((Element)v.get(38)).setAttribute("visibilidad","visible" );
      ((Element)v.get(38)).setAttribute("contravsb","" );
      ((Element)v.get(38)).setAttribute("x","0" );
      ((Element)v.get(38)).setAttribute("y","313" );
      ((Element)v.get(38)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:5   */


   }

}

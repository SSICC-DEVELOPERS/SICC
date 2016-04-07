
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_ordenes_bloqueadas_notificar_detalle  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_ordenes_bloqueadas_notificar_detalle" );
      ((Element)v.get(0)).setAttribute("cod","0277" );
      ((Element)v.get(0)).setAttribute("titulo","" );
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
      v.add(doc.createTextNode("    \r  \r    function onLoadPag()   \r    {           \r        configurarMenuSecundario(\"frmContenido\");\r        DrdEnsanchaConMargenDcho('listado2',12); \r        \r        document.all[\"Cplistado2\"].style.visibility=''; \r        document.all[\"CpLin1listado2\"].style.visibility='';  \r        document.all[\"CpLin2listado2\"].style.visibility=''; \r        document.all[\"CpLin3listado2\"].style.visibility='';\r        document.all[\"CpLin4listado2\"].style.visibility='';  \r        \r        document.all[\"primera1Div\"].style.visibility='hidden'; \r        document.all[\"ret1Div\"].style.visibility='hidden';\r        document.all[\"ava1Div\"].style.visibility='hidden';  \r        document.all[\"separaDiv\"].style.visibility='hidden'; \r        \r        eval (ON_RSZ);\r        cargaDetalleEnLista(get('frmContenido.hidDetalleSolicitudes') );\r        focalizaBotonHTML_XY('Imprimir');\r    }\r    \r    function onSeleccionaSolicitud(fila)\r    {\r                    \r        var seleccion=listado2.codigos();		\r        var vNotificado = listado2.extraeDato(seleccion[fila], 13);\r    \r        if (vNotificado != get('frmContenido.hidConstanteMaeComFax'))\r                listado2.deselecciona(fila);\r    }\r\r    \r    function onClickImprimir()\r    {\r	    if(listado2.codSeleccionados()!='') {\r						var listadoSeleccionado=\"\";\r			listadoSeleccionado = listado2String();\r			\r			var obj = new Object();        \r			obj.hidDetalleSel = listadoSeleccionado;\r			var whnd = mostrarModalSICC('LPNotificarOrdenesBloqueadas','Imprimir',obj,\r					null, 570);\r			if(whnd!=null)\r			{\r				\r			}\r        }else{\r			GestionarMensaje('4', null, null, null);\r		}\r        \r    }\r    \r    function cargaDetalleEnLista(listaItems){\r		var fila = listaItems.split('$');\r		for(i=0;i<fila.length;i++){\r			if (fila[i] != ''){\r				var datos = fila[i];\r                var newRow = datos.split('|');\r				listado2.insertar(newRow);\r			}\r		}\r	}\r\r    function listado2String()\r    {\r\r        var codigo = listado2.codSeleccionados();\r        var total = \"\";\r\r        for(var a = 0; a < codigo.length ; a++){\r            var toAdd = \"\";\r            \r            toAdd = \"oid:\"+ codigo[a];\r\r            if(listado2.extraeDato(codigo[a], 0)!= null && listado2.extraeDato(codigo[a], 0)!=\"\")\r                toAdd = toAdd + \"|\" + \"cc:\" + listado2.extraeDato(codigo[a], 0);                if(listado2.extraeDato(codigo[a], 1)!= null && listado2.extraeDato(codigo[a], 1)!=\"\")\r                toAdd = toAdd + \"|\" + \"mc:\"  + listado2.extraeDato(codigo[a], 1);                if(listado2.extraeDato(codigo[a], 2)!= null && listado2.extraeDato(codigo[a], 2)!=\"\")\r                toAdd = toAdd + \"|\" + \"co:\"  + listado2.extraeDato(codigo[a], 2);                    \r            if(listado2.extraeDato(codigo[a], 3)!= null && listado2.extraeDato(codigo[a], 3)!=\"\")\r                toAdd = toAdd + \"|\" + \"gs:\"  + listado2.extraeDato(codigo[a], 3);                if(listado2.extraeDato(codigo[a], 4)!= null && listado2.extraeDato(codigo[a], 4)!=\"\")\r                toAdd = toAdd + \"|\" + \"es:\"  + listado2.extraeDato(codigo[a], 4);    \r            if(listado2.extraeDato(codigo[a], 5)!= null && listado2.extraeDato(codigo[a], 5)!=\"\")\r                toAdd = toAdd + \"|\" + \"ns:\" + listado2.extraeDato(codigo[a], 5);                if(listado2.extraeDato(codigo[a], 6)!= null && listado2.extraeDato(codigo[a], 6)!=\"\")\r                toAdd = toAdd + \"|\" + \"mo:\"  + listado2.extraeDato(codigo[a], 6);                if(listado2.extraeDato(codigo[a], 7)!= null && listado2.extraeDato(codigo[a], 7)!=\"\")\r                toAdd = toAdd + \"|\" + \"md:\"  + listado2.extraeDato(codigo[a], 7);    \r            if(listado2.extraeDato(codigo[a], 8)!= null && listado2.extraeDato(codigo[a], 8)!=\"\")\r                toAdd = toAdd + \"|\" + \"r1:\" + listado2.extraeDato(codigo[a], 8);                if(listado2.extraeDato(codigo[a], 9)!= null && listado2.extraeDato(codigo[a], 9)!=\"\")\r                toAdd = toAdd + \"|\" + \"r2:\"  + listado2.extraeDato(codigo[a], 9);                if(listado2.extraeDato(codigo[a], 10)!= null && listado2.extraeDato(codigo[a], 10)!=\"\")\r                toAdd = toAdd + \"|\" + \"r3:\"  + listado2.extraeDato(codigo[a], 10);                if(listado2.extraeDato(codigo[a], 11)!= null && listado2.extraeDato(codigo[a], 11)!=\"\")\r                toAdd = toAdd + \"|\" + \"r4:\" + listado2.extraeDato(codigo[a], 11);                \r            if(listado2.extraeDato(codigo[a], 12)!= null && listado2.extraeDato(codigo[a], 12)!=\"\")\r                toAdd = toAdd + \"|\" + \"gz:\"  + listado2.extraeDato(codigo[a], 12);                \r            if(listado2.extraeDato(codigo[a], 13)!= null && listado2.extraeDato(codigo[a], 13)!=\"\")\r                toAdd = toAdd + \"|\" + \"cm:\"  + listado2.extraeDato(codigo[a], 13);    \r            total = total + \"$\" + toAdd;          \r            \r        }\r        return total;\r    }\r    \r    function fVolver()\r    {\r        window.close();\r    }\r    \r    \r  "));
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
      ((Element)v.get(4)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(5)).setAttribute("nombre","frmContenido" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(6)).setAttribute("valor","" );
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
      ((Element)v.get(8)).setAttribute("nombre","hidPais" );
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
      ((Element)v.get(10)).setAttribute("nombre","hidDetalleSolicitudes" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","hidConstanteMaeComFax" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(12)).setAttribute("nombre","capa1" );
      ((Element)v.get(5)).appendChild((Element)v.get(12));

      /* Empieza nodo:13 / Elemento padre: 12   */
      v.add(doc.createElement("table"));
      ((Element)v.get(13)).setAttribute("width","100%" );
      ((Element)v.get(13)).setAttribute("border","0" );
      ((Element)v.get(13)).setAttribute("cellspacing","0" );
      ((Element)v.get(13)).setAttribute("cellpadding","0" );
      ((Element)v.get(12)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(13)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("td"));
      ((Element)v.get(14)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(16)).setAttribute("src","b.gif" );
      ((Element)v.get(16)).setAttribute("width","524" );
      ((Element)v.get(16)).setAttribute("height","12" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */
      /* Termina nodo:15   */
      /* Termina nodo:14   */
      /* Termina nodo:13   */
      /* Termina nodo:12   */

      /* Empieza nodo:17 / Elemento padre: 5   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(17)).setAttribute("nombre","listado2" );
      ((Element)v.get(17)).setAttribute("ancho","500" );
      ((Element)v.get(17)).setAttribute("alto","317" );
      ((Element)v.get(17)).setAttribute("x","12" );
      ((Element)v.get(17)).setAttribute("y","12" );
      ((Element)v.get(17)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(17)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(5)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(18)).setAttribute("precarga","S" );
      ((Element)v.get(18)).setAttribute("conROver","S" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(19)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(19)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(19)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(19)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 18   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(20)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(20)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(20)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(20)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(18)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 18   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(21)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(21)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(18)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */
      /* Termina nodo:18   */

      /* Empieza nodo:22 / Elemento padre: 17   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(17)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(23)).setAttribute("borde","1" );
      ((Element)v.get(23)).setAttribute("horizDatos","1" );
      ((Element)v.get(23)).setAttribute("horizCabecera","1" );
      ((Element)v.get(23)).setAttribute("vertical","1" );
      ((Element)v.get(23)).setAttribute("horizTitulo","1" );
      ((Element)v.get(23)).setAttribute("horizBase","1" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 22   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(24)).setAttribute("borde","#999999" );
      ((Element)v.get(24)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(24)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(24)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(24)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(24)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(24)).setAttribute("horizBase","#999999" );
      ((Element)v.get(22)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:22   */

      /* Empieza nodo:25 / Elemento padre: 17   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(25)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(25)).setAttribute("alto","22" );
      ((Element)v.get(25)).setAttribute("imgFondo","" );
      ((Element)v.get(25)).setAttribute("cod","00174" );
      ((Element)v.get(25)).setAttribute("ID","datosTitle" );
      ((Element)v.get(17)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 17   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(26)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(26)).setAttribute("alto","22" );
      ((Element)v.get(26)).setAttribute("imgFondo","" );
      ((Element)v.get(17)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 17   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(27)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(27)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(27)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(27)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(27)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(27)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(17)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(28)).setAttribute("ancho","100" );
      ((Element)v.get(28)).setAttribute("minimizable","S" );
      ((Element)v.get(28)).setAttribute("minimizada","N" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 27   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(29)).setAttribute("ancho","100" );
      ((Element)v.get(29)).setAttribute("minimizable","S" );
      ((Element)v.get(29)).setAttribute("minimizada","N" );
      ((Element)v.get(27)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 27   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(30)).setAttribute("ancho","100" );
      ((Element)v.get(30)).setAttribute("minimizable","S" );
      ((Element)v.get(30)).setAttribute("minimizada","N" );
      ((Element)v.get(27)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 27   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(31)).setAttribute("ancho","100" );
      ((Element)v.get(31)).setAttribute("minimizable","S" );
      ((Element)v.get(31)).setAttribute("minimizada","N" );
      ((Element)v.get(27)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 27   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(32)).setAttribute("ancho","100" );
      ((Element)v.get(32)).setAttribute("minimizable","S" );
      ((Element)v.get(32)).setAttribute("minimizada","N" );
      ((Element)v.get(27)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 27   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(33)).setAttribute("ancho","130" );
      ((Element)v.get(33)).setAttribute("minimizable","S" );
      ((Element)v.get(33)).setAttribute("minimizada","N" );
      ((Element)v.get(27)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 27   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(34)).setAttribute("ancho","100" );
      ((Element)v.get(34)).setAttribute("minimizable","S" );
      ((Element)v.get(34)).setAttribute("minimizada","N" );
      ((Element)v.get(27)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 27   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(35)).setAttribute("ancho","150" );
      ((Element)v.get(35)).setAttribute("minimizable","S" );
      ((Element)v.get(35)).setAttribute("minimizada","N" );
      ((Element)v.get(27)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 27   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(36)).setAttribute("ancho","150" );
      ((Element)v.get(36)).setAttribute("minimizable","S" );
      ((Element)v.get(36)).setAttribute("minimizada","N" );
      ((Element)v.get(27)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 27   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(37)).setAttribute("ancho","150" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(37)).setAttribute("minimizable","S" );
      ((Element)v.get(37)).setAttribute("minimizada","N" );
      ((Element)v.get(27)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 27   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(38)).setAttribute("ancho","150" );
      ((Element)v.get(38)).setAttribute("minimizable","S" );
      ((Element)v.get(38)).setAttribute("minimizada","N" );
      ((Element)v.get(27)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 27   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(39)).setAttribute("ancho","150" );
      ((Element)v.get(39)).setAttribute("minimizable","S" );
      ((Element)v.get(39)).setAttribute("minimizada","N" );
      ((Element)v.get(27)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 27   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(40)).setAttribute("ancho","100" );
      ((Element)v.get(40)).setAttribute("minimizable","S" );
      ((Element)v.get(40)).setAttribute("minimizada","N" );
      ((Element)v.get(27)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 27   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(41)).setAttribute("ancho","100" );
      ((Element)v.get(41)).setAttribute("minimizable","S" );
      ((Element)v.get(41)).setAttribute("minimizada","N" );
      ((Element)v.get(41)).setAttribute("oculta","S" );
      ((Element)v.get(27)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:27   */

      /* Empieza nodo:42 / Elemento padre: 17   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(42)).setAttribute("alto","20" );
      ((Element)v.get(42)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(42)).setAttribute("imgFondo","" );
      ((Element)v.get(42)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(17)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(43)).setAttribute("colFondo","" );
      ((Element)v.get(43)).setAttribute("ID","EstCab" );
      ((Element)v.get(43)).setAttribute("cod","263" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(44)).setAttribute("colFondo","" );
      ((Element)v.get(44)).setAttribute("ID","EstCab" );
      ((Element)v.get(44)).setAttribute("cod","2783" );
      ((Element)v.get(42)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(45)).setAttribute("colFondo","" );
      ((Element)v.get(45)).setAttribute("ID","EstCab" );
      ((Element)v.get(45)).setAttribute("cod","1812" );
      ((Element)v.get(42)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(46)).setAttribute("colFondo","" );
      ((Element)v.get(46)).setAttribute("ID","EstCab" );
      ((Element)v.get(46)).setAttribute("cod","888" );
      ((Element)v.get(42)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(47)).setAttribute("colFondo","" );
      ((Element)v.get(47)).setAttribute("ID","EstCab" );
      ((Element)v.get(47)).setAttribute("cod","596" );
      ((Element)v.get(42)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(48)).setAttribute("colFondo","" );
      ((Element)v.get(48)).setAttribute("ID","EstCab" );
      ((Element)v.get(48)).setAttribute("cod","1167" );
      ((Element)v.get(42)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(49)).setAttribute("colFondo","" );
      ((Element)v.get(49)).setAttribute("ID","EstCab" );
      ((Element)v.get(49)).setAttribute("cod","1165" );
      ((Element)v.get(42)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(50)).setAttribute("colFondo","" );
      ((Element)v.get(50)).setAttribute("ID","EstCab" );
      ((Element)v.get(50)).setAttribute("cod","1166" );
      ((Element)v.get(42)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(51)).setAttribute("colFondo","" );
      ((Element)v.get(51)).setAttribute("ID","EstCab" );
      ((Element)v.get(51)).setAttribute("cod","1160" );
      ((Element)v.get(42)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(52)).setAttribute("colFondo","" );
      ((Element)v.get(52)).setAttribute("ID","EstCab" );
      ((Element)v.get(52)).setAttribute("cod","1161" );
      ((Element)v.get(42)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(53)).setAttribute("colFondo","" );
      ((Element)v.get(53)).setAttribute("ID","EstCab" );
      ((Element)v.get(53)).setAttribute("cod","1162" );
      ((Element)v.get(42)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(54)).setAttribute("colFondo","" );
      ((Element)v.get(54)).setAttribute("ID","EstCab" );
      ((Element)v.get(54)).setAttribute("cod","1163" );
      ((Element)v.get(42)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 42   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(55)).setAttribute("colFondo","" );
      ((Element)v.get(55)).setAttribute("ID","EstCab" );
      ((Element)v.get(55)).setAttribute("cod","1164" );
      ((Element)v.get(42)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 42   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(56)).setAttribute("colFondo","" );
      ((Element)v.get(56)).setAttribute("ID","EstCab" );
      ((Element)v.get(42)).appendChild((Element)v.get(56));

      /* Elemento padre:56 / Elemento actual: 57   */
      v.add(doc.createTextNode("oidMedioComunicacion"));
      ((Element)v.get(56)).appendChild((Text)v.get(57));

      /* Termina nodo Texto:57   */
      /* Termina nodo:56   */
      /* Termina nodo:42   */

      /* Empieza nodo:58 / Elemento padre: 17   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(58)).setAttribute("alto","22" );
      ((Element)v.get(58)).setAttribute("accion","onSeleccionaSolicitud(FILAEVENTO);" );
      ((Element)v.get(58)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(58)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(58)).setAttribute("maxSel","1" );
      ((Element)v.get(58)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(58)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(58)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(58)).setAttribute("onLoad","" );
      ((Element)v.get(58)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(17)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(59)).setAttribute("tipo","texto" );
      ((Element)v.get(59)).setAttribute("ID","EstDat" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 58   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(60)).setAttribute("tipo","texto" );
      ((Element)v.get(60)).setAttribute("ID","EstDat2" );
      ((Element)v.get(58)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 58   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(61)).setAttribute("tipo","texto" );
      ((Element)v.get(61)).setAttribute("ID","EstDat" );
      ((Element)v.get(58)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 58   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(62)).setAttribute("tipo","texto" );
      ((Element)v.get(62)).setAttribute("ID","EstDat2" );
      ((Element)v.get(58)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 58   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(63)).setAttribute("tipo","texto" );
      ((Element)v.get(63)).setAttribute("ID","EstDat" );
      ((Element)v.get(58)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 58   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(64)).setAttribute("tipo","texto" );
      ((Element)v.get(64)).setAttribute("ID","EstDat2" );
      ((Element)v.get(58)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 58   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(65)).setAttribute("tipo","texto" );
      ((Element)v.get(65)).setAttribute("ID","EstDat" );
      ((Element)v.get(58)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 58   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(66)).setAttribute("tipo","texto" );
      ((Element)v.get(66)).setAttribute("ID","EstDat2" );
      ((Element)v.get(58)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 58   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(67)).setAttribute("tipo","texto" );
      ((Element)v.get(67)).setAttribute("ID","EstDat" );
      ((Element)v.get(58)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 58   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(68)).setAttribute("tipo","texto" );
      ((Element)v.get(68)).setAttribute("ID","EstDat2" );
      ((Element)v.get(58)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 58   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(69)).setAttribute("tipo","texto" );
      ((Element)v.get(69)).setAttribute("ID","EstDat" );
      ((Element)v.get(58)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 58   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(70)).setAttribute("tipo","texto" );
      ((Element)v.get(70)).setAttribute("ID","EstDat2" );
      ((Element)v.get(58)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 58   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(71)).setAttribute("tipo","texto" );
      ((Element)v.get(71)).setAttribute("ID","EstDat" );
      ((Element)v.get(58)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 58   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(72)).setAttribute("tipo","texto" );
      ((Element)v.get(72)).setAttribute("ID","EstDat2" );
      ((Element)v.get(58)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:58   */

      /* Empieza nodo:73 / Elemento padre: 17   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(17)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 17   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(74)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(74)).setAttribute("ancho","683" );
      ((Element)v.get(74)).setAttribute("sep","$" );
      ((Element)v.get(74)).setAttribute("x","12" );
      ((Element)v.get(74)).setAttribute("class","botonera" );
      ((Element)v.get(74)).setAttribute("y","306" );
      ((Element)v.get(74)).setAttribute("control","|" );
      ((Element)v.get(74)).setAttribute("conector","conector_prototipo_2" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(74)).setAttribute("rowset","" );
      ((Element)v.get(74)).setAttribute("cargainicial","N" );
      ((Element)v.get(17)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(75)).setAttribute("nombre","ret1" );
      ((Element)v.get(75)).setAttribute("x","37" );
      ((Element)v.get(75)).setAttribute("y","310" );
      ((Element)v.get(75)).setAttribute("ID","botonContenido" );
      ((Element)v.get(75)).setAttribute("img","retroceder_on" );
      ((Element)v.get(75)).setAttribute("tipo","0" );
      ((Element)v.get(75)).setAttribute("estado","false" );
      ((Element)v.get(75)).setAttribute("alt","" );
      ((Element)v.get(75)).setAttribute("codigo","" );
      ((Element)v.get(75)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 74   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(76)).setAttribute("nombre","ava1" );
      ((Element)v.get(76)).setAttribute("x","52" );
      ((Element)v.get(76)).setAttribute("y","310" );
      ((Element)v.get(76)).setAttribute("ID","botonContenido" );
      ((Element)v.get(76)).setAttribute("img","avanzar_on" );
      ((Element)v.get(76)).setAttribute("tipo","0" );
      ((Element)v.get(76)).setAttribute("estado","false" );
      ((Element)v.get(76)).setAttribute("alt","" );
      ((Element)v.get(76)).setAttribute("codigo","" );
      ((Element)v.get(76)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(74)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:74   */
      /* Termina nodo:17   */

      /* Empieza nodo:77 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(77)).setAttribute("nombre","primera1" );
      ((Element)v.get(77)).setAttribute("x","20" );
      ((Element)v.get(77)).setAttribute("y","310" );
      ((Element)v.get(77)).setAttribute("ID","botonContenido" );
      ((Element)v.get(77)).setAttribute("img","primera_on" );
      ((Element)v.get(77)).setAttribute("tipo","0" );
      ((Element)v.get(77)).setAttribute("estado","false" );
      ((Element)v.get(77)).setAttribute("alt","" );
      ((Element)v.get(77)).setAttribute("codigo","" );
      ((Element)v.get(77)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(5)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(78)).setAttribute("nombre","separa" );
      ((Element)v.get(78)).setAttribute("x","59" );
      ((Element)v.get(78)).setAttribute("y","306" );
      ((Element)v.get(78)).setAttribute("ID","botonContenido" );
      ((Element)v.get(78)).setAttribute("img","separa_base" );
      ((Element)v.get(78)).setAttribute("tipo","0" );
      ((Element)v.get(78)).setAttribute("estado","false" );
      ((Element)v.get(78)).setAttribute("alt","" );
      ((Element)v.get(78)).setAttribute("codigo","" );
      ((Element)v.get(78)).setAttribute("accion","" );
      ((Element)v.get(5)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(79)).setAttribute("nombre","Imprimir" );
      ((Element)v.get(79)).setAttribute("x","13" );
      ((Element)v.get(79)).setAttribute("y","307" );
      ((Element)v.get(79)).setAttribute("ID","botonContenido" );
      ((Element)v.get(79)).setAttribute("tipo","html" );
      ((Element)v.get(79)).setAttribute("estado","false" );
      ((Element)v.get(79)).setAttribute("cod","1157" );
      ((Element)v.get(79)).setAttribute("accion","onClickImprimir();" );
      ((Element)v.get(79)).setAttribute("onshtab","focalizaBotonHTML_XY('Imprimir');" );
      ((Element)v.get(79)).setAttribute("ontab","focalizaBotonHTML_XY('Imprimir');" );
      ((Element)v.get(5)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(80)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(80)).setAttribute("alto","12" );
      ((Element)v.get(80)).setAttribute("ancho","50" );
      ((Element)v.get(80)).setAttribute("x","0" );
      ((Element)v.get(80)).setAttribute("y","329" );
      ((Element)v.get(5)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:5   */


   }

}


import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_ordenes_bloqueadas_notificar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_ordenes_bloqueadas_notificar" );
      ((Element)v.get(0)).setAttribute("cod","0277" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode("\r  \r\r    function onLoadPag()   {\r  \r        DrdEnsanchaConMargenDcho('listado1',12);\r        \r        document.all[\"Cplistado1\"].style.visibility='';\r        document.all[\"CpLin1listado1\"].style.visibility='';\r        document.all[\"CpLin2listado1\"].style.visibility='';\r        document.all[\"CpLin3listado1\"].style.visibility='';\r        document.all[\"CpLin4listado1\"].style.visibility='';\r        \r        document.all[\"primera1Div\"].style.visibility='hidden';\r        document.all[\"ret1Div\"].style.visibility='hidden';\r        document.all[\"ava1Div\"].style.visibility='hidden';\r        document.all[\"separaDiv\"].style.visibility='hidden';\r        \r        eval (ON_RSZ);  \r        fMostrarMensajeError();\r        \r                           \r        configurarPaginado(mipgndo,'CARCargaOrdenesNotificar','ConectorCargaOrdenesNotificar',\r            'es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion',armaArray());\r      \r        configurarMenuSecundario(\"frmContenido\");\r        focalizaBotonHTML_XY('Notificar');\r        btnProxy(2,0);\r        btnProxy(3,1);\r        btnProxy(7,1);\r        btnProxy(8,1);\r        btnProxy(9,1);\r        btnProxy(10,1);\r    }\r\r    function armaArray(){ \r        var arrDatos = new Array();\r        var i=0;\r        \r        arrDatos[i] = new Array('oidPais',get('frmContenido.hidPais'));\r		i++;\r		arrDatos[i] = new Array('oidIdioma',get('frmContenido.hidIdioma'));\r		i++;\r        \r		return arrDatos;\r    }\r\r    function onClickNotificar()\r    {\r                                var listadoSeleccionado=\"\";\r        listadoSeleccionado = listado2String();\r        \r        var codigo = listado1.codSeleccionados();\r\r		if(codigo!='') {\r\r			var vSalir = 1;\r			var vCom = 0;\r			var vEmail = get('frmContenido.hidConstanteMAEEmail');\r							  \r			var i=0;\r			while (vSalir == 1 && i < codigo.length) \r			{\r				vCom = listado1.extraeDato(codigo[i], 12);\r				if (vCom != vEmail)\r				{\r					vSalir = 0;\r				}\r				i++;\r			}\r			 \r			\r			if (vSalir == 0)\r			{\r				var obj = new Object();        \r				obj.hidDetalleSolicitudes = listadoSeleccionado;				\r				var whnd = mostrarModalSICC('LPNotificarOrdenesBloqueadas','Notificar',obj,\r					null, 570);\r			\r				configurarPaginado(mipgndo,'CARCargaOrdenesNotificar','ConectorCargaOrdenesNotificar',\r				'es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion',armaArray());   \r			}\r			else\r			{\r				eval('frmContenido').oculto = 'S';\r				set('frmContenido.hidDetalleSolicitudes', listadoSeleccionado);\r				set('frmContenido.conectorAction','LPNotificarOrdenesBloqueadas');   \r				set('frmContenido.accion','Notificar');\r				enviaSICC('frmContenido');\r			}\r\r		}else{		\r		    			GestionarMensaje('4', null, null, null);		\r		}\r    }\r    \r    function listado2String()\r    {\r        var codigo = listado1.codSeleccionados();\r        var total = \"\";\r\r        for(var a = 0; a < codigo.length ; a++){\r            var toAdd = \"\";\r            \r            toAdd = \"oid:\"+ codigo[a];\r\r            if(listado1.extraeDato(codigo[a], 0)!= null && listado1.extraeDato(codigo[a], 0)!=\"\")\r                toAdd = toAdd + \"|\" + \"cc:\" + listado1.extraeDato(codigo[a], 0);                if(listado1.extraeDato(codigo[a], 13)!= null && listado1.extraeDato(codigo[a], 13)!=\"\")\r                toAdd = toAdd + \"|\" + \"mc:\"  + listado1.extraeDato(codigo[a], 13);                if(listado1.extraeDato(codigo[a], 14)!= null && listado1.extraeDato(codigo[a], 14)!=\"\")\r                toAdd = toAdd + \"|\" + \"co:\"  + listado1.extraeDato(codigo[a], 14);                    \r            if(listado1.extraeDato(codigo[a], 1)!= null && listado1.extraeDato(codigo[a], 1)!=\"\")\r                toAdd = toAdd + \"|\" + \"gs:\"  + listado1.extraeDato(codigo[a], 1);                if(listado1.extraeDato(codigo[a], 2)!= null && listado1.extraeDato(codigo[a], 2)!=\"\")\r                toAdd = toAdd + \"|\" + \"es:\"  + listado1.extraeDato(codigo[a], 2);    \r            if(listado1.extraeDato(codigo[a], 3)!= null && listado1.extraeDato(codigo[a], 3)!=\"\")\r                toAdd = toAdd + \"|\" + \"ns:\" + listado1.extraeDato(codigo[a], 3);                if(listado1.extraeDato(codigo[a], 4)!= null && listado1.extraeDato(codigo[a], 4)!=\"\")\r                toAdd = toAdd + \"|\" + \"mo:\"  + listado1.extraeDato(codigo[a], 4);                if(listado1.extraeDato(codigo[a], 5)!= null && listado1.extraeDato(codigo[a], 5)!=\"\")\r                toAdd = toAdd + \"|\" + \"md:\"  + listado1.extraeDato(codigo[a], 5);    \r            if(listado1.extraeDato(codigo[a], 6)!= null && listado1.extraeDato(codigo[a], 6)!=\"\")\r                toAdd = toAdd + \"|\" + \"r1:\" + listado1.extraeDato(codigo[a], 6);                if(listado1.extraeDato(codigo[a], 7)!= null && listado1.extraeDato(codigo[a], 7)!=\"\")\r                toAdd = toAdd + \"|\" + \"r2:\"  + listado1.extraeDato(codigo[a], 7);                if(listado1.extraeDato(codigo[a], 8)!= null && listado1.extraeDato(codigo[a], 8)!=\"\")\r                toAdd = toAdd + \"|\" + \"r3:\"  + listado1.extraeDato(codigo[a], 8);                if(listado1.extraeDato(codigo[a], 9)!= null && listado1.extraeDato(codigo[a], 9)!=\"\")            \r                toAdd = toAdd + \"|\" + \"r4:\" + listado1.extraeDato(codigo[a], 9);                \r            if(listado1.extraeDato(codigo[a], 10)!= null && listado1.extraeDato(codigo[a], 10)!=\"\")\r                toAdd = toAdd + \"|\" + \"gz:\"  + listado1.extraeDato(codigo[a], 10);                \r            if(listado1.extraeDato(codigo[a], 12)!= null && listado1.extraeDato(codigo[a], 12)!=\"\")\r                toAdd = toAdd + \"|\" + \"cm:\"  + listado1.extraeDato(codigo[a], 12);                    \r            if(listado1.extraeDato(codigo[a], 11)!= null && listado1.extraeDato(codigo[a], 11)!=\"\")\r                toAdd = toAdd + \"|\" + \"no:\" + listado1.extraeDato(codigo[a], 11);                               \r\r            total = total + \"$\" + toAdd;          \r            \r        }\r        return total;\r    }\r    \r    function accionMensajeDeExito()\r    {\r        configurarPaginado(mipgndo,'CARCargaOrdenesNotificar','ConectorCargaOrdenesNotificar',\r            'es.indra.sicc.cmn.negocio.auditoria.DTOSiccPaginacion',armaArray());   \r    }\r    \r    function accionError()\r    {\r		focalizaBotonHTML_XY('Notificar');\r    }\r    \r    \r    function onSeleccionaSolicitud(fila){\r     \r        \r        var seleccion=listado1.codigos();\r        var vNotificado = listado1.extraeDato(seleccion[fila], 15);\r        var vComunicacion = listado1.extraeDato(seleccion[fila], 14);\r\r        if (vNotificado == get('frmContenido.hidConstanteCmnTRUE'))\r                listado1.deselecciona(fila);    \r        else \r        {\r            if (vComunicacion == '')\r            {\r                listado1.deselecciona(fila);\r                GestionarMensaje('1454');\r            }\r        }\r    }\r    \r   \r  "));
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
      ((Element)v.get(8)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","errDescripcion" );
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
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","hidIdioma" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","hidDetalleSolicitudes" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hidConstanteCmnTRUE" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hidConstanteMAEEmail" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(15)).setAttribute("nombre","capaTitulo" );
      ((Element)v.get(5)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("table"));
      ((Element)v.get(16)).setAttribute("width","100%" );
      ((Element)v.get(16)).setAttribute("border","0" );
      ((Element)v.get(16)).setAttribute("align","center" );
      ((Element)v.get(16)).setAttribute("cellspacing","0" );
      ((Element)v.get(16)).setAttribute("cellpadding","0" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(16)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("td"));
      ((Element)v.get(17)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(19)).setAttribute("src","b.gif" );
      ((Element)v.get(19)).setAttribute("width","424" );
      ((Element)v.get(19)).setAttribute("height","1" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */
      /* Termina nodo:18   */
      /* Termina nodo:17   */
      /* Termina nodo:16   */
      /* Termina nodo:15   */

      /* Empieza nodo:20 / Elemento padre: 5   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(20)).setAttribute("nombre","listado1" );
      ((Element)v.get(20)).setAttribute("ancho","400" );
      ((Element)v.get(20)).setAttribute("alto","317" );
      ((Element)v.get(20)).setAttribute("x","12" );
      ((Element)v.get(20)).setAttribute("y","12" );
      ((Element)v.get(20)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(20)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(5)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(21)).setAttribute("precarga","S" );
      ((Element)v.get(21)).setAttribute("conROver","S" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(20)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(22)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(22)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(22)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(22)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 21   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(23)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(23)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(23)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(23)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(21)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 21   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(24)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(24)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(21)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:21   */

      /* Empieza nodo:25 / Elemento padre: 20   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(20)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(26)).setAttribute("borde","1" );
      ((Element)v.get(26)).setAttribute("horizDatos","1" );
      ((Element)v.get(26)).setAttribute("horizCabecera","1" );
      ((Element)v.get(26)).setAttribute("vertical","1" );
      ((Element)v.get(26)).setAttribute("horizTitulo","1" );
      ((Element)v.get(26)).setAttribute("horizBase","1" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 25   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(27)).setAttribute("borde","#999999" );
      ((Element)v.get(27)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(27)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(27)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(27)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(27)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(27)).setAttribute("horizBase","#999999" );
      ((Element)v.get(25)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:25   */

      /* Empieza nodo:28 / Elemento padre: 20   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(28)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(28)).setAttribute("alto","22" );
      ((Element)v.get(28)).setAttribute("imgFondo","" );
      ((Element)v.get(28)).setAttribute("cod","00463" );
      ((Element)v.get(28)).setAttribute("ID","datosTitle" );
      ((Element)v.get(20)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 20   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(29)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(29)).setAttribute("alto","22" );
      ((Element)v.get(29)).setAttribute("imgFondo","" );
      ((Element)v.get(20)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 20   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(30)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(30)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(30)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(30)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(30)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(30)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(20)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(31)).setAttribute("ancho","100" );
      ((Element)v.get(31)).setAttribute("minimizable","S" );
      ((Element)v.get(31)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(32)).setAttribute("ancho","100" );
      ((Element)v.get(32)).setAttribute("minimizable","S" );
      ((Element)v.get(32)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(33)).setAttribute("ancho","100" );
      ((Element)v.get(33)).setAttribute("minimizable","S" );
      ((Element)v.get(33)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(34)).setAttribute("ancho","160" );
      ((Element)v.get(34)).setAttribute("minimizable","S" );
      ((Element)v.get(34)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(35)).setAttribute("ancho","100" );
      ((Element)v.get(35)).setAttribute("minimizable","S" );
      ((Element)v.get(35)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(36)).setAttribute("ancho","150" );
      ((Element)v.get(36)).setAttribute("minimizable","S" );
      ((Element)v.get(36)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(37)).setAttribute("ancho","150" );
      ((Element)v.get(37)).setAttribute("minimizable","S" );
      ((Element)v.get(37)).setAttribute("minimizada","N" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(30)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(38)).setAttribute("ancho","150" );
      ((Element)v.get(38)).setAttribute("minimizable","S" );
      ((Element)v.get(38)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(39)).setAttribute("ancho","150" );
      ((Element)v.get(39)).setAttribute("minimizable","S" );
      ((Element)v.get(39)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(40)).setAttribute("ancho","150" );
      ((Element)v.get(40)).setAttribute("minimizable","S" );
      ((Element)v.get(40)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(41)).setAttribute("ancho","100" );
      ((Element)v.get(41)).setAttribute("minimizable","S" );
      ((Element)v.get(41)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(42)).setAttribute("ancho","100" );
      ((Element)v.get(42)).setAttribute("minimizable","S" );
      ((Element)v.get(42)).setAttribute("minimizada","N" );
      ((Element)v.get(30)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(43)).setAttribute("ancho","100" );
      ((Element)v.get(43)).setAttribute("minimizable","S" );
      ((Element)v.get(43)).setAttribute("minimizada","N" );
      ((Element)v.get(43)).setAttribute("oculta","S" );
      ((Element)v.get(30)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(44)).setAttribute("ancho","100" );
      ((Element)v.get(44)).setAttribute("minimizable","S" );
      ((Element)v.get(44)).setAttribute("minimizada","N" );
      ((Element)v.get(44)).setAttribute("oculta","S" );
      ((Element)v.get(30)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(45)).setAttribute("ancho","100" );
      ((Element)v.get(45)).setAttribute("minimizable","S" );
      ((Element)v.get(45)).setAttribute("minimizada","N" );
      ((Element)v.get(45)).setAttribute("oculta","S" );
      ((Element)v.get(30)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 30   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(46)).setAttribute("ancho","100" );
      ((Element)v.get(46)).setAttribute("minimizable","S" );
      ((Element)v.get(46)).setAttribute("minimizada","N" );
      ((Element)v.get(46)).setAttribute("oculta","S" );
      ((Element)v.get(30)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:30   */

      /* Empieza nodo:47 / Elemento padre: 20   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(47)).setAttribute("alto","20" );
      ((Element)v.get(47)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(47)).setAttribute("imgFondo","" );
      ((Element)v.get(47)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(20)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(48)).setAttribute("colFondo","" );
      ((Element)v.get(48)).setAttribute("ID","EstCab" );
      ((Element)v.get(48)).setAttribute("cod","263" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Elemento padre:48 / Elemento actual: 49   */
      v.add(doc.createTextNode("Cód. cliente"));
      ((Element)v.get(48)).appendChild((Text)v.get(49));

      /* Termina nodo Texto:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 47   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(50)).setAttribute("colFondo","" );
      ((Element)v.get(50)).setAttribute("ID","EstCab" );
      ((Element)v.get(50)).setAttribute("cod","888" );
      ((Element)v.get(47)).appendChild((Element)v.get(50));

      /* Elemento padre:50 / Elemento actual: 51   */
      v.add(doc.createTextNode("Grupo solicitud"));
      ((Element)v.get(50)).appendChild((Text)v.get(51));

      /* Termina nodo Texto:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 47   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(52)).setAttribute("colFondo","" );
      ((Element)v.get(52)).setAttribute("ID","EstCab" );
      ((Element)v.get(52)).setAttribute("cod","596" );
      ((Element)v.get(47)).appendChild((Element)v.get(52));

      /* Elemento padre:52 / Elemento actual: 53   */
      v.add(doc.createTextNode("Estatus"));
      ((Element)v.get(52)).appendChild((Text)v.get(53));

      /* Termina nodo Texto:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 47   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(54)).setAttribute("colFondo","" );
      ((Element)v.get(54)).setAttribute("ID","EstCab" );
      ((Element)v.get(54)).setAttribute("cod","1167" );
      ((Element)v.get(47)).appendChild((Element)v.get(54));

      /* Elemento padre:54 / Elemento actual: 55   */
      v.add(doc.createTextNode("Nº solicitud entrega"));
      ((Element)v.get(54)).appendChild((Text)v.get(55));

      /* Termina nodo Texto:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 47   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(56)).setAttribute("colFondo","" );
      ((Element)v.get(56)).setAttribute("ID","EstCab" );
      ((Element)v.get(56)).setAttribute("cod","1165" );
      ((Element)v.get(47)).appendChild((Element)v.get(56));

      /* Elemento padre:56 / Elemento actual: 57   */
      v.add(doc.createTextNode("Monto orden"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(56)).appendChild((Text)v.get(57));

      /* Termina nodo Texto:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 47   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(58)).setAttribute("colFondo","" );
      ((Element)v.get(58)).setAttribute("ID","EstCab" );
      ((Element)v.get(58)).setAttribute("cod","1166" );
      ((Element)v.get(47)).appendChild((Element)v.get(58));

      /* Elemento padre:58 / Elemento actual: 59   */
      v.add(doc.createTextNode("Monto deuda vencida"));
      ((Element)v.get(58)).appendChild((Text)v.get(59));

      /* Termina nodo Texto:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 47   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(60)).setAttribute("colFondo","" );
      ((Element)v.get(60)).setAttribute("ID","EstCab" );
      ((Element)v.get(60)).setAttribute("cod","1160" );
      ((Element)v.get(47)).appendChild((Element)v.get(60));

      /* Elemento padre:60 / Elemento actual: 61   */
      v.add(doc.createTextNode("Resultado validación 1"));
      ((Element)v.get(60)).appendChild((Text)v.get(61));

      /* Termina nodo Texto:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 47   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(62)).setAttribute("colFondo","" );
      ((Element)v.get(62)).setAttribute("ID","EstCab" );
      ((Element)v.get(62)).setAttribute("cod","1161" );
      ((Element)v.get(47)).appendChild((Element)v.get(62));

      /* Elemento padre:62 / Elemento actual: 63   */
      v.add(doc.createTextNode("Resultado validación 2"));
      ((Element)v.get(62)).appendChild((Text)v.get(63));

      /* Termina nodo Texto:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 47   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(64)).setAttribute("colFondo","" );
      ((Element)v.get(64)).setAttribute("ID","EstCab" );
      ((Element)v.get(64)).setAttribute("cod","1162" );
      ((Element)v.get(47)).appendChild((Element)v.get(64));

      /* Elemento padre:64 / Elemento actual: 65   */
      v.add(doc.createTextNode("Resultado validación 3"));
      ((Element)v.get(64)).appendChild((Text)v.get(65));

      /* Termina nodo Texto:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 47   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(66)).setAttribute("colFondo","" );
      ((Element)v.get(66)).setAttribute("ID","EstCab" );
      ((Element)v.get(66)).setAttribute("cod","1163" );
      ((Element)v.get(47)).appendChild((Element)v.get(66));

      /* Elemento padre:66 / Elemento actual: 67   */
      v.add(doc.createTextNode("Resultado validación 4"));
      ((Element)v.get(66)).appendChild((Text)v.get(67));

      /* Termina nodo Texto:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 47   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(68)).setAttribute("colFondo","" );
      ((Element)v.get(68)).setAttribute("ID","EstCab" );
      ((Element)v.get(68)).setAttribute("cod","1164" );
      ((Element)v.get(47)).appendChild((Element)v.get(68));

      /* Elemento padre:68 / Elemento actual: 69   */
      v.add(doc.createTextNode("Gerente zona"));
      ((Element)v.get(68)).appendChild((Text)v.get(69));

      /* Termina nodo Texto:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 47   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(70)).setAttribute("colFondo","" );
      ((Element)v.get(70)).setAttribute("ID","EstCab" );
      ((Element)v.get(70)).setAttribute("cod","2251" );
      ((Element)v.get(47)).appendChild((Element)v.get(70));

      /* Elemento padre:70 / Elemento actual: 71   */
      v.add(doc.createTextNode("Notificado"));
      ((Element)v.get(70)).appendChild((Text)v.get(71));

      /* Termina nodo Texto:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 47   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(72)).setAttribute("colFondo","" );
      ((Element)v.get(72)).setAttribute("ID","EstCab" );
      ((Element)v.get(47)).appendChild((Element)v.get(72));

      /* Elemento padre:72 / Elemento actual: 73   */
      v.add(doc.createTextNode("oidMedioComunicacion"));
      ((Element)v.get(72)).appendChild((Text)v.get(73));

      /* Termina nodo Texto:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 47   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(74)).setAttribute("colFondo","" );
      ((Element)v.get(74)).setAttribute("ID","EstCab" );
      ((Element)v.get(47)).appendChild((Element)v.get(74));

      /* Elemento padre:74 / Elemento actual: 75   */
      v.add(doc.createTextNode("MedioComunicacion"));
      ((Element)v.get(74)).appendChild((Text)v.get(75));

      /* Termina nodo Texto:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 47   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(76)).setAttribute("colFondo","" );
      ((Element)v.get(76)).setAttribute("ID","EstCab" );
      ((Element)v.get(47)).appendChild((Element)v.get(76));

      /* Elemento padre:76 / Elemento actual: 77   */
      v.add(doc.createTextNode("Comunicacion"));
      ((Element)v.get(76)).appendChild((Text)v.get(77));

      /* Termina nodo Texto:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 47   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(78)).setAttribute("colFondo","" );
      ((Element)v.get(78)).setAttribute("ID","EstCab" );
      ((Element)v.get(47)).appendChild((Element)v.get(78));

      /* Elemento padre:78 / Elemento actual: 79   */
      v.add(doc.createTextNode("Valor Notificado"));
      ((Element)v.get(78)).appendChild((Text)v.get(79));

      /* Termina nodo Texto:79   */
      /* Termina nodo:78   */
      /* Termina nodo:47   */

      /* Empieza nodo:80 / Elemento padre: 20   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(80)).setAttribute("alto","22" );
      ((Element)v.get(80)).setAttribute("accion","onSeleccionaSolicitud(FILAEVENTO);" );
      ((Element)v.get(80)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(80)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(80)).setAttribute("maxSel","-1" );
      ((Element)v.get(80)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(80)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(80)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(80)).setAttribute("onLoad","" );
      ((Element)v.get(80)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(20)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(81)).setAttribute("tipo","texto" );
      ((Element)v.get(81)).setAttribute("ID","EstDat" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 80   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(82)).setAttribute("tipo","texto" );
      ((Element)v.get(82)).setAttribute("ID","EstDat2" );
      ((Element)v.get(80)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 80   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(83)).setAttribute("tipo","texto" );
      ((Element)v.get(83)).setAttribute("ID","EstDat" );
      ((Element)v.get(80)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 80   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(84)).setAttribute("tipo","texto" );
      ((Element)v.get(84)).setAttribute("ID","EstDat2" );
      ((Element)v.get(80)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 80   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(85)).setAttribute("tipo","texto" );
      ((Element)v.get(85)).setAttribute("ID","EstDat" );
      ((Element)v.get(80)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 80   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(86)).setAttribute("tipo","texto" );
      ((Element)v.get(86)).setAttribute("ID","EstDat2" );
      ((Element)v.get(80)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 80   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(87)).setAttribute("tipo","texto" );
      ((Element)v.get(87)).setAttribute("ID","EstDat" );
      ((Element)v.get(80)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 80   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(88)).setAttribute("tipo","texto" );
      ((Element)v.get(88)).setAttribute("ID","EstDat2" );
      ((Element)v.get(80)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 80   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(89)).setAttribute("tipo","texto" );
      ((Element)v.get(89)).setAttribute("ID","EstDat" );
      ((Element)v.get(80)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 80   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(90)).setAttribute("tipo","texto" );
      ((Element)v.get(90)).setAttribute("ID","EstDat2" );
      ((Element)v.get(80)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 80   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(91)).setAttribute("tipo","texto" );
      ((Element)v.get(91)).setAttribute("ID","EstDat" );
      ((Element)v.get(80)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 80   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(92)).setAttribute("tipo","texto" );
      ((Element)v.get(92)).setAttribute("ID","EstDat2" );
      ((Element)v.get(80)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 80   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(93)).setAttribute("tipo","texto" );
      ((Element)v.get(93)).setAttribute("ID","EstDat" );
      ((Element)v.get(80)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 80   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(94)).setAttribute("tipo","texto" );
      ((Element)v.get(94)).setAttribute("ID","EstDat2" );
      ((Element)v.get(80)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 80   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(95)).setAttribute("tipo","texto" );
      ((Element)v.get(95)).setAttribute("ID","EstDat" );
      ((Element)v.get(80)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 80   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(96)).setAttribute("tipo","texto" );
      ((Element)v.get(96)).setAttribute("ID","EstDat2" );
      ((Element)v.get(80)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:80   */

      /* Empieza nodo:97 / Elemento padre: 20   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(20)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 20   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(98)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(98)).setAttribute("ancho","400" );
      ((Element)v.get(98)).setAttribute("sep","$" );
      ((Element)v.get(98)).setAttribute("x","12" );
      ((Element)v.get(98)).setAttribute("class","botonera" );
      ((Element)v.get(98)).setAttribute("y","306" );
      ((Element)v.get(98)).setAttribute("control","|" );
      ((Element)v.get(98)).setAttribute("conector","" );
      ((Element)v.get(98)).setAttribute("rowset","" );
      ((Element)v.get(98)).setAttribute("cargainicial","N" );
      ((Element)v.get(20)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(99)).setAttribute("nombre","ret1" );
      ((Element)v.get(99)).setAttribute("x","37" );
      ((Element)v.get(99)).setAttribute("y","310" );
      ((Element)v.get(99)).setAttribute("ID","botonContenido" );
      ((Element)v.get(99)).setAttribute("img","retroceder_on" );
      ((Element)v.get(99)).setAttribute("tipo","0" );
      ((Element)v.get(99)).setAttribute("estado","false" );
      ((Element)v.get(99)).setAttribute("alt","" );
      ((Element)v.get(99)).setAttribute("codigo","" );
      ((Element)v.get(99)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 98   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(100)).setAttribute("nombre","ava1" );
      ((Element)v.get(100)).setAttribute("x","52" );
      ((Element)v.get(100)).setAttribute("y","310" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(100)).setAttribute("ID","botonContenido" );
      ((Element)v.get(100)).setAttribute("img","avanzar_on" );
      ((Element)v.get(100)).setAttribute("tipo","0" );
      ((Element)v.get(100)).setAttribute("estado","false" );
      ((Element)v.get(100)).setAttribute("alt","" );
      ((Element)v.get(100)).setAttribute("codigo","" );
      ((Element)v.get(100)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(98)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:98   */
      /* Termina nodo:20   */

      /* Empieza nodo:101 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(101)).setAttribute("nombre","primera1" );
      ((Element)v.get(101)).setAttribute("x","20" );
      ((Element)v.get(101)).setAttribute("y","310" );
      ((Element)v.get(101)).setAttribute("ID","botonContenido" );
      ((Element)v.get(101)).setAttribute("img","primera_on" );
      ((Element)v.get(101)).setAttribute("tipo","0" );
      ((Element)v.get(101)).setAttribute("estado","false" );
      ((Element)v.get(101)).setAttribute("alt","" );
      ((Element)v.get(101)).setAttribute("codigo","" );
      ((Element)v.get(101)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(5)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(102)).setAttribute("nombre","separa" );
      ((Element)v.get(102)).setAttribute("x","59" );
      ((Element)v.get(102)).setAttribute("y","306" );
      ((Element)v.get(102)).setAttribute("ID","botonContenido" );
      ((Element)v.get(102)).setAttribute("img","separa_base" );
      ((Element)v.get(102)).setAttribute("tipo","0" );
      ((Element)v.get(102)).setAttribute("estado","false" );
      ((Element)v.get(102)).setAttribute("alt","" );
      ((Element)v.get(102)).setAttribute("codigo","" );
      ((Element)v.get(102)).setAttribute("accion","" );
      ((Element)v.get(5)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(103)).setAttribute("nombre","Notificar" );
      ((Element)v.get(103)).setAttribute("x","13" );
      ((Element)v.get(103)).setAttribute("y","307" );
      ((Element)v.get(103)).setAttribute("ID","botonContenido" );
      ((Element)v.get(103)).setAttribute("tipo","html" );
      ((Element)v.get(103)).setAttribute("estado","false" );
      ((Element)v.get(103)).setAttribute("cod","1168" );
      ((Element)v.get(103)).setAttribute("accion","onClickNotificar();" );
      ((Element)v.get(103)).setAttribute("onshtab","focalizaBotonHTML_XY('Notificar');" );
      ((Element)v.get(103)).setAttribute("ontab","focalizaBotonHTML_XY('Notificar');" );
      ((Element)v.get(5)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(104)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(104)).setAttribute("alto","18" );
      ((Element)v.get(104)).setAttribute("ancho","100" );
      ((Element)v.get(104)).setAttribute("colorf","" );
      ((Element)v.get(104)).setAttribute("borde","0" );
      ((Element)v.get(104)).setAttribute("imagenf","" );
      ((Element)v.get(104)).setAttribute("repeat","" );
      ((Element)v.get(104)).setAttribute("padding","" );
      ((Element)v.get(104)).setAttribute("visibilidad","visible" );
      ((Element)v.get(104)).setAttribute("contravsb","" );
      ((Element)v.get(104)).setAttribute("x","0" );
      ((Element)v.get(104)).setAttribute("y","329" );
      ((Element)v.get(104)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:5   */


   }

}


import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_monto_ventas_recomendadas_mantener  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_monto_ventas_recomendadas_mantener" );
      ((Element)v.get(0)).setAttribute("cod","0506" );
      ((Element)v.get(0)).setAttribute("titulo","Mantener Monto ventas recomendadas" );
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
      v.add(doc.createTextNode("\r \r\r	function onLoadPag()   {        \r		DrdEnsanchaConMargenDcho('listado1',12);\r	    document.all[\"Cplistado1\"].style.visibility='';\r		document.all[\"CpLin1listado1\"].style.visibility='';\r        document.all[\"CpLin2listado1\"].style.visibility='';\r        document.all[\"CpLin3listado1\"].style.visibility='';\r        document.all[\"CpLin4listado1\"].style.visibility='';\r        document.all[\"separaDiv\"].style.visibility='hidden';\r        document.all[\"primera1Div\"].style.visibility='hidden';\r        document.all[\"ret1Div\"].style.visibility='hidden';\r        document.all[\"ava1Div\"].style.visibility='hidden';\r               \r        eval (ON_RSZ);  \r        configurarMenuSecundario('formulario');        \r		btnProxy(7, 0);\r		btnProxy(8, 0);\r		btnProxy(9, 0);\r\r        if (get('formulario.opcionMenu') == 'Consultar Concurso') {\r			btnProxy(5, 0);\r            deshabilitar();\r        }\r		else {\r			focalizaBotonHTML('botonContenido','btnAceptar');\r		}        \r   }\r  \r   \r   function accionAceptar()  {\r        listado1.actualizaDat();\r		var datos = listado1.datos;\r				var vacio = \"false\";\r\r		for(var i=0; i<datos.length && vacio; i++) {\r						if(datos[i][4]!=\"\") {\r				vacio = \"false\";\r				break;\r			}\r			vacio = \"true\";\r		}\r\r		if(vacio==\"false\") {\r						\r				var retorno = sicc_valida_numero_LE('txtCantidad', GestionarMensaje(\"1558\", null, null, null), 0, 999999999.99, 'Numerico', 'listado1', 4);\r				if(retorno==true) {\r					var listaMontoVenta = listado1Tostring();        \r					var arr = new Array();\r					arr[0] = listaMontoVenta;\r					var datos = listado1.datos;\r					var lon = listado1.datos.length;\r					returnValue = arr;\r					close();\r				}\r				else {\r					return;\r				}\r		}\r		else {\r			GestionarMensaje(\"INC-006\");\r		}		\r   }\r   \r   function listado1Tostring(){      \r        var codigo = listado1.codigos();\r  	    var total = \"\";\r		listado1.actualizaDat();\r\r		var datos = listado1.datos;\r        lon = listado1.datos.length;\r\r		  		  total = \"[\";\r		  for (var i = 0; i < lon; i++) {\r				 var fila = datos[i];\r				 if ( i != 0 ) \r				  	  total = total + \"|\";\r\r  				 for (var j = 0; j < fila.length; j++) {\r				 	  if ( j != 0)\r						   total = total + \"&\";\r\r					   var valor = datos[i][j]; \r					   if ( valor != null && valor != undefined && valor != \"\")\r						    total = total + valor;\r					   else	 \r						    total = total + \" \"; \r\r				  } \r		   } \r			total = total + \"]\";\r\r 		  return total;\r	}\r    \r    function focalizaListaShTab(FILAEVENTO) {\r        if (FILAEVENTO == 0)  {\r            focalizaBotonHTML('botonContenido','btnAceptar');\r        }\r    }\r    \r    function deshabilitar() {\r        var lacolumna=3;         var deshabilitado=true;          \r        listado1.tiposCol[lacolumna][8]=deshabilitado;         \r        listado1.actualizaDat();\r        listado1.repinta();\r\r		document.getElementById(\"btnAceptar\").disabled = true;\r   	}\r    \r    function fVolver() {\r        window.close();\r    }\r\r\r    function focalizaLista(){\r        if(listado1.datos.length > 0){\r            document.selection.empty();\r            var nombrelistado = \"listado1\";\r            var nombreTextbox = \"txtCantidad\";\r            var indiceFila = 0;\r\r            eval(nombrelistado+\".preparaCamposDR()\");\r                        focaliza('frm'+nombrelistado+'.'+nombreTextbox+'_'+indiceFila,'');\r        }else focalizaBotonHTML('botonContenido','btnAceptar');\r    } \r\r   \r   \r   \r"));
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
      ((Element)v.get(4)).setAttribute("src","validaciones_sicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(5)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","accion" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","hidLstMVR" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 5   */
      v.add(doc.createElement("table"));
      ((Element)v.get(10)).setAttribute("width","100%" );
      ((Element)v.get(10)).setAttribute("border","0" );
      ((Element)v.get(10)).setAttribute("cellspacing","0" );
      ((Element)v.get(10)).setAttribute("cellpadding","0" );
      ((Element)v.get(5)).appendChild((Element)v.get(10));

      /* Empieza nodo:11 / Elemento padre: 10   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(10)).appendChild((Element)v.get(11));

      /* Empieza nodo:12 / Elemento padre: 11   */
      v.add(doc.createElement("td"));
      ((Element)v.get(12)).setAttribute("width","100%" );
      ((Element)v.get(11)).appendChild((Element)v.get(12));

      /* Empieza nodo:13 / Elemento padre: 12   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(13)).setAttribute("src","b.gif" );
      ((Element)v.get(13)).setAttribute("width","555" );
      ((Element)v.get(13)).setAttribute("height","8" );
      ((Element)v.get(12)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */
      /* Termina nodo:12   */
      /* Termina nodo:11   */
      /* Termina nodo:10   */

      /* Empieza nodo:14 / Elemento padre: 5   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(14)).setAttribute("nombre","listado1" );
      ((Element)v.get(14)).setAttribute("ancho","531" );
      ((Element)v.get(14)).setAttribute("alto","161" );
      ((Element)v.get(14)).setAttribute("x","12" );
      ((Element)v.get(14)).setAttribute("y","12" );
      ((Element)v.get(14)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(14)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(5)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(15)).setAttribute("precarga","S" );
      ((Element)v.get(15)).setAttribute("conROver","S" );
      ((Element)v.get(14)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(16)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(16)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(16)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(16)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 15   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(17)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(17)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(17)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(17)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(15)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 15   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(18)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(18)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(15)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */
      /* Termina nodo:15   */

      /* Empieza nodo:19 / Elemento padre: 14   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(14)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(20)).setAttribute("borde","1" );
      ((Element)v.get(20)).setAttribute("horizDatos","1" );
      ((Element)v.get(20)).setAttribute("horizCabecera","1" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(20)).setAttribute("vertical","0" );
      ((Element)v.get(20)).setAttribute("horizTitulo","1" );
      ((Element)v.get(20)).setAttribute("horizBase","1" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 19   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(21)).setAttribute("borde","#999999" );
      ((Element)v.get(21)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(21)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(21)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(21)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(21)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(21)).setAttribute("horizBase","#999999" );
      ((Element)v.get(19)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */
      /* Termina nodo:19   */

      /* Empieza nodo:22 / Elemento padre: 14   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(22)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(22)).setAttribute("alto","22" );
      ((Element)v.get(22)).setAttribute("imgFondo","" );
      ((Element)v.get(22)).setAttribute("cod","00314" );
      ((Element)v.get(22)).setAttribute("ID","datosTitle" );
      ((Element)v.get(14)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 14   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(23)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(23)).setAttribute("alto","22" );
      ((Element)v.get(23)).setAttribute("imgFondo","" );
      ((Element)v.get(14)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 14   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(24)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(24)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(24)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(24)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(24)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(24)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(14)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(25)).setAttribute("ancho","30" );
      ((Element)v.get(25)).setAttribute("minimizable","S" );
      ((Element)v.get(25)).setAttribute("minimizada","N" );
      ((Element)v.get(25)).setAttribute("oculta","S" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 24   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(26)).setAttribute("ancho","30" );
      ((Element)v.get(26)).setAttribute("minimizable","S" );
      ((Element)v.get(26)).setAttribute("minimizada","N" );
      ((Element)v.get(26)).setAttribute("oculta","S" );
      ((Element)v.get(24)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 24   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(27)).setAttribute("ancho","15" );
      ((Element)v.get(27)).setAttribute("minimizable","S" );
      ((Element)v.get(27)).setAttribute("minimizada","N" );
      ((Element)v.get(24)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 24   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(28)).setAttribute("ancho","10" );
      ((Element)v.get(28)).setAttribute("minimizable","S" );
      ((Element)v.get(28)).setAttribute("minimizada","N" );
      ((Element)v.get(24)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:24   */

      /* Empieza nodo:29 / Elemento padre: 14   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(29)).setAttribute("alto","20" );
      ((Element)v.get(29)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(29)).setAttribute("imgFondo","" );
      ((Element)v.get(29)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(14)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(30)).setAttribute("colFondo","" );
      ((Element)v.get(30)).setAttribute("ID","EstCab" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Elemento padre:30 / Elemento actual: 31   */
      v.add(doc.createTextNode("oidMontoVenta"));
      ((Element)v.get(30)).appendChild((Text)v.get(31));

      /* Termina nodo Texto:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:32 / Elemento padre: 29   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(32)).setAttribute("colFondo","" );
      ((Element)v.get(32)).setAttribute("ID","EstCab" );
      ((Element)v.get(29)).appendChild((Element)v.get(32));

      /* Elemento padre:32 / Elemento actual: 33   */
      v.add(doc.createTextNode("oidTipoMontoVenta"));
      ((Element)v.get(32)).appendChild((Text)v.get(33));

      /* Termina nodo Texto:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:34 / Elemento padre: 29   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(34)).setAttribute("colFondo","" );
      ((Element)v.get(34)).setAttribute("ID","EstCab" );
      ((Element)v.get(34)).setAttribute("cod","9" );
      ((Element)v.get(34)).setAttribute("align","center" );
      ((Element)v.get(29)).appendChild((Element)v.get(34));

      /* Elemento padre:34 / Elemento actual: 35   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(34)).appendChild((Text)v.get(35));

      /* Termina nodo Texto:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 29   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(36)).setAttribute("colFondo","" );
      ((Element)v.get(36)).setAttribute("ID","EstCab" );
      ((Element)v.get(36)).setAttribute("cod","1172" );
      ((Element)v.get(29)).appendChild((Element)v.get(36));

      /* Elemento padre:36 / Elemento actual: 37   */
      v.add(doc.createTextNode("Cantidad"));
      ((Element)v.get(36)).appendChild((Text)v.get(37));

      /* Termina nodo Texto:37   */
      /* Termina nodo:36   */
      /* Termina nodo:29   */

      /* Empieza nodo:38 / Elemento padre: 14   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(38)).setAttribute("alto","22" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(38)).setAttribute("accion","" );
      ((Element)v.get(38)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(38)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(38)).setAttribute("maxSel","0" );
      ((Element)v.get(38)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(38)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(38)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(38)).setAttribute("onLoad","" );
      ((Element)v.get(38)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(14)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(39)).setAttribute("tipo","texto" );
      ((Element)v.get(39)).setAttribute("ID","EstDat2" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 38   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(40)).setAttribute("tipo","texto" );
      ((Element)v.get(40)).setAttribute("ID","EstDat2" );
      ((Element)v.get(38)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 38   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(41)).setAttribute("tipo","texto" );
      ((Element)v.get(41)).setAttribute("ID","EstDat" );
      ((Element)v.get(38)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 38   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(42)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(42)).setAttribute("nombre","txtCantidad" );
      ((Element)v.get(42)).setAttribute("size","15" );
      ((Element)v.get(42)).setAttribute("max","12" );
      ((Element)v.get(42)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(42)).setAttribute("ID","EstDat2" );
      ((Element)v.get(42)).setAttribute("validacion","ValidaAlfanumerico(valor)" );
      ((Element)v.get(42)).setAttribute("onshtab","focalizaListaShTab(FILAEVENTO)" );
      ((Element)v.get(38)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:38   */

      /* Empieza nodo:43 / Elemento padre: 14   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(14)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 14   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(44)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(44)).setAttribute("ancho","531" );
      ((Element)v.get(44)).setAttribute("sep","$" );
      ((Element)v.get(44)).setAttribute("x","12" );
      ((Element)v.get(44)).setAttribute("class","botonera" );
      ((Element)v.get(44)).setAttribute("y","151" );
      ((Element)v.get(44)).setAttribute("control","|" );
      ((Element)v.get(44)).setAttribute("conector","" );
      ((Element)v.get(44)).setAttribute("rowset","" );
      ((Element)v.get(44)).setAttribute("cargainicial","N" );
      ((Element)v.get(14)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(45)).setAttribute("nombre","ret1" );
      ((Element)v.get(45)).setAttribute("x","37" );
      ((Element)v.get(45)).setAttribute("y","155" );
      ((Element)v.get(45)).setAttribute("ID","botonContenido" );
      ((Element)v.get(45)).setAttribute("img","retroceder_on" );
      ((Element)v.get(45)).setAttribute("tipo","0" );
      ((Element)v.get(45)).setAttribute("estado","false" );
      ((Element)v.get(45)).setAttribute("alt","" );
      ((Element)v.get(45)).setAttribute("codigo","" );
      ((Element)v.get(45)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 44   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(46)).setAttribute("nombre","ava1" );
      ((Element)v.get(46)).setAttribute("x","52" );
      ((Element)v.get(46)).setAttribute("y","155" );
      ((Element)v.get(46)).setAttribute("ID","botonContenido" );
      ((Element)v.get(46)).setAttribute("img","avanzar_on" );
      ((Element)v.get(46)).setAttribute("tipo","0" );
      ((Element)v.get(46)).setAttribute("estado","false" );
      ((Element)v.get(46)).setAttribute("alt","" );
      ((Element)v.get(46)).setAttribute("codigo","" );
      ((Element)v.get(46)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(44)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:44   */
      /* Termina nodo:14   */

      /* Empieza nodo:47 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(47)).setAttribute("nombre","primera1" );
      ((Element)v.get(47)).setAttribute("x","20" );
      ((Element)v.get(47)).setAttribute("y","155" );
      ((Element)v.get(47)).setAttribute("ID","botonContenido" );
      ((Element)v.get(47)).setAttribute("img","primera_on" );
      ((Element)v.get(47)).setAttribute("tipo","0" );
      ((Element)v.get(47)).setAttribute("estado","false" );
      ((Element)v.get(47)).setAttribute("alt","" );
      ((Element)v.get(47)).setAttribute("codigo","" );
      ((Element)v.get(47)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(5)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(48)).setAttribute("nombre","separa" );
      ((Element)v.get(48)).setAttribute("x","59" );
      ((Element)v.get(48)).setAttribute("y","151" );
      ((Element)v.get(48)).setAttribute("ID","botonContenido" );
      ((Element)v.get(48)).setAttribute("img","separa_base" );
      ((Element)v.get(48)).setAttribute("tipo","0" );
      ((Element)v.get(48)).setAttribute("estado","false" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(48)).setAttribute("alt","" );
      ((Element)v.get(48)).setAttribute("codigo","" );
      ((Element)v.get(48)).setAttribute("accion","" );
      ((Element)v.get(5)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 5   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(49)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(49)).setAttribute("x","13" );
      ((Element)v.get(49)).setAttribute("y","152" );
      ((Element)v.get(49)).setAttribute("ID","botonContenido" );
      ((Element)v.get(49)).setAttribute("tipo","html" );
      ((Element)v.get(49)).setAttribute("estado","false" );
      ((Element)v.get(49)).setAttribute("cod","12" );
      ((Element)v.get(49)).setAttribute("accion","accionAceptar();" );
      ((Element)v.get(49)).setAttribute("ontab","focalizaLista();" );
      ((Element)v.get(5)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(50)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(50)).setAttribute("alto","12" );
      ((Element)v.get(50)).setAttribute("ancho","100%" );
      ((Element)v.get(50)).setAttribute("colorf","" );
      ((Element)v.get(50)).setAttribute("borde","0" );
      ((Element)v.get(50)).setAttribute("imagenf","" );
      ((Element)v.get(50)).setAttribute("repeat","" );
      ((Element)v.get(50)).setAttribute("padding","" );
      ((Element)v.get(50)).setAttribute("visibilidad","visible" );
      ((Element)v.get(50)).setAttribute("contravsb","" );
      ((Element)v.get(50)).setAttribute("x","0" );
      ((Element)v.get(50)).setAttribute("y","174" );
      ((Element)v.get(50)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:5   */


   }

}

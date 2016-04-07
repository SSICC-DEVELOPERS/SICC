
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_simulacion_descuentos_realizar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_simulacion_descuentos_realizar" );
      ((Element)v.get(0)).setAttribute("cod","0282" );
      ((Element)v.get(0)).setAttribute("titulo","Realizar simulación de descuento" );
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
      v.add(doc.createTextNode("\r   \r\r  function onLoadPag()  {\r    configurarMenuSecundario(\"formulario\");\r    fMostrarMensajeError();\r   \r    document.all.btnSeleccionarSolicitud.focus();\r    DrdEnsanchaConMargenDcho('listado1',12);\r   \r    document.all[\"Cplistado1\"].style.visibility='visible';\r    document.all[\"CpLin1listado1\"].style.visibility='visible';\r    document.all[\"CpLin2listado1\"].style.visibility='visible';\r    document.all[\"CpLin3listado1\"].style.visibility='visible';\r    document.all[\"CpLin4listado1\"].style.visibility='visible';\r    document.all[\"primera1Div\"].style.visibility='hidden';\r    document.all[\"ret1Div\"].style.visibility='hidden';\r    document.all[\"ava1Div\"].style.visibility='hidden';\r    document.all[\"separaDiv\"].style.visibility='hidden';\r    document.all[\"btnCalcularDiv\"].style.visibility='';\r    document.all[\"btnAprobarDiv\"].style.visibility='';\r    document.all[\"btnSeleccionarSolicitudDiv\"].style.visibility='';\r    document.all[\"btnModificarSolicitudDiv\"].style.visibility=''; \r    document.all[\"btnDetalleDiv\"].style.visibility=''; \r   \r    if (get('formulario.hBtnAProbarHab') == 0)\r    {\r        deshabilitarHabilitarBoton('botonContenido','btnAprobar','D');\r        deshabilitarHabilitarBoton('botonContenido','btnCalcular','A');\r    }\r    else\r    {\r        deshabilitarHabilitarBoton('botonContenido','btnAprobar','A');\r        deshabilitarHabilitarBoton('botonContenido','btnCalcular','D');\r    }\r        \r    eval (ON_RSZ);   \r  }\r\r  function accionCalcular()  {\r\r    /*\r    if ( get('formulario.accion') == \"\" )  {\r          return;\r    }\r    if ( get('formulario.accion') == \"calcular\" )  {\r          return;\r    }*/\r    set('formulario.accion','calcular');\r    enviaSICC('formulario');\r  }\r  function accionAprobar()  {\r   /* if ( get('formulario.accion') == \"\" )  {\r          return;\r    }\r    if ( get('formulario.accion') == \"modificar\" )  {\r      return;\r    }*/\r    set('formulario.accion','aprobar');\r    enviaSICC('formulario');\r  }\r  function accionSeleccionarSolicitudes()  {\r    set('formulario.accion','seleccionarSolicitudes');\r    enviaSICC('formulario');\r  }\rfunction accionModificarSolicitud()  {\r	        var parametros = new Object();\r    codigo = listado1.codSeleccionados();\r\r    if ( codigo.length == 1 )  {\r		parametros.hOidSolicitud = codigo[0].toString();\r		parametros.hCodCliente = listado1.extraeDato(codigo[0] ,0);\r		parametros.hNombreCliente = listado1.extraeDato(codigo[0] ,1);\r		parametros.hCampaniaSolicitud = listado1.extraeDato(codigo[0] ,2);\r		parametros.hFechaSolicitud = listado1.extraeDato(codigo[0] ,3);\r		parametros.hMontoTotalSolicitud = listado1.extraeDato(codigo[0] ,4);\r		parametros.hDetalleSolicitudes = get('formulario.hDetalleSolicitudes');\r		var detalle = mostrarModalSICC(\"LPModificarSolicitud\",\"\", parametros );\r\r						if ( detalle != \"\" )  { 															\r						var detalleS = new Array();\r			detalleS = detalle.split(\"|\");\r						var detalleSolicitud = new Array();\r			longitud = detalleS.length - 1;\r			cantidadRegs = longitud / 5 ;\r			\r			var vTotalLinea = '';\r			var vTotalSolic = 0;\r			var vNumAux = 0;\r\r			\r			for (var k = 0; k < detalleS.length; k += 5){\r\r				if (detalleS[k + 3] != null && detalleS[k + 3] != undefined){\r					vNumAux = eval(detalleS[k + 3]);\r					vTotalSolic += vNumAux;\r				}\r			}\r\r			var seleccionados = listado1.codSeleccionados();\r			listado1.insertaDato(seleccionados[0], 4, '' + numeroDeFormatoSICC(vTotalSolic));\r\r			for (f=0; f<cantidadRegs; f++){\r																detalleSolicitud[f] = new Array();\r\r				for (c=0; c<5;c++){\r					detalleSolicitud[f][c] = detalleS[c + f*5];\r				}\r			}\r\r									        \r			var ds = get('formulario.hDetalleSolicitudes');\r\r						var arrayTemp = ds.split(\"|\");\r						\r			detalleSolicitudes = new Array();\r			cantidadPosiciones = ( ( arrayTemp.length - 1 ) / 5 );\r			\r			for (c=0; c<cantidadPosiciones; c++){\r				detalleSolicitudes[c] = new Array();\r				detalleSolicitudes[c][0] = arrayTemp[0 + 5*c ];\r				detalleSolicitudes[c][1] = arrayTemp[1 + 5*c ];\r				detalleSolicitudes[c][2] = arrayTemp[2 + 5*c ];\r				detalleSolicitudes[c][3] = arrayTemp[3 + 5*c ];\r				detalleSolicitudes[c][4] = arrayTemp[4 + 5*c ];          \r			}\r\r												\r			for (s=0; s<detalleSolicitud.length; s++){\r				for (f=0; f<detalleSolicitudes.length; f++){\r					if (detalleSolicitud[s][0] == detalleSolicitudes[f][0])  {\r						if (detalleSolicitud[s][1] == detalleSolicitudes[f][1])  {\r							detalleSolicitudes[f][2] = detalleSolicitud[s][2];\r							detalleSolicitudes[f][3] = detalleSolicitud[s][3];\r							detalleSolicitudes[f][4] = detalleSolicitud[s][4];\r						}\r					}\r				}\r			}\r\r						\r			var detSol = \"\";\r			\r			for (f=0; f<detalleSolicitudes.length; f++)  {\r				detSol =  detSol +\r                detalleSolicitudes[f][0] + '|' +\r                detalleSolicitudes[f][1] + '|' +\r                detalleSolicitudes[f][2] + '|' +\r                detalleSolicitudes[f][3] + '|' +\r                detalleSolicitudes[f][4] + '|';\r			}\r\r						\r			set('formulario.hDetalleSolicitudes', detSol);\r			set('formulario.accion','modificar');\r		}\r	} else {\r		GestionarMensaje('2525');\r		document.all.btnModificarSolicitud.focus();\r	}\r}\r\r  function accionDetalle()  {\r            if ( listado1.codSeleccionados().length == 1 )  {\r      var parametros = new Object();\r      codigo = listado1.codSeleccionados();\r      parametros.hOidSolicitud = codigo[0].toString();\r      parametros.hCodCliente = listado1.extraeDato(codigo[0] ,0);\r      parametros.hNombreCliente = listado1.extraeDato(codigo[0] ,1);\r      parametros.hCampaniaSolicitud = listado1.extraeDato(codigo[0] ,2);\r      parametros.hFechaSolicitud = listado1.extraeDato(codigo[0] ,3);\r      parametros.hMontoTotalSolicitud = listado1.extraeDato(codigo[0] ,4);\r      parametros.hDetalleSolicitudes = get('formulario.hDetalleSolicitudes');\r      mostrarModalSICC(\"LPSimulacionDescuento\",\"detalle\", parametros );\r    } else {\r        GestionarMensaje('2525');\r        document.all.btnDetalle.focus();\r      }\r  }\r  function focalizarOnShTabBC()  {\r    document.all.btnDetalle.focus();\r  }\r  \r  function focalizarOnTabBC()  {\r    try {\r      document.all.btnAprobar.focus();\r    } catch (e)  {\r        document.all.btnSeleccionarSolicitud.focus();\r      }\r  }\r\r  function focalizarOnShTabBA()  {\r    try {\r      document.all.btnCalcular.focus();\r    } catch (e)  {\r        document.all.btnDetalle.focus();\r      }\r  }\r\r  function focalizarOnTabBA()  {\r    try {\r      document.all.btnSeleccionarSolicitud.focus();\r    } catch (e)  {\r        document.all.btnModificarSolicitud.focus();\r      }\r  }\r\r  function focalizarOnShTabBSS()  {\r    try {\r      document.all.btnAprobar.focus();\r    } catch (e)  {\r        try  {\r          document.all.btnCalcular.focus();\r        } catch (e)  {\r            document.all.btnDetalle.focus();            \r          }\r      }\r  }\r\r  function focalizarOnTabBSS()  {\r    document.all.btnModificarSolicitud.focus();\r  }\r\r  function focalizarOnShTabBD()  {\r    document.all.btnModificarSolicitud.focus();\r  }\r\r  function focalizarOnTabBD()  {\r    try {\r      document.all.btnCalcular.focus();\r    } catch (e)  {\r        try  {\r          document.all.btnAprobar.focus();\r        } catch (e)  {\r            document.all.btnSeleccionarSolicitud.focus();            \r          }\r      }\r  }\r\r\r\r \r"));
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
      ((Element)v.get(7)).setAttribute("valor","LPSimulacionDescuento" );
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
      ((Element)v.get(11)).setAttribute("nombre","hOidDescuento" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","hDetalleSolicitudes" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hOidSolicitud" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hCodCliente" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hNombreCliente" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hCampaniaSolicitud" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hFechaSolicitud" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hMontoTotalSolicitud" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hBtnAProbarHab" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(20)).setAttribute("nombre","capa1" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("table"));
      ((Element)v.get(21)).setAttribute("width","100%" );
      ((Element)v.get(21)).setAttribute("border","0" );
      ((Element)v.get(21)).setAttribute("cellspacing","0" );
      ((Element)v.get(21)).setAttribute("cellpadding","0" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("width","100%" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(24)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).setAttribute("width","715" );
      ((Element)v.get(24)).setAttribute("height","8" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:23   */
      /* Termina nodo:22   */
      /* Termina nodo:21   */
      /* Termina nodo:20   */

      /* Empieza nodo:25 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(25)).setAttribute("nombre","listado1" );
      ((Element)v.get(25)).setAttribute("ancho","691" );
      ((Element)v.get(25)).setAttribute("alto","301" );
      ((Element)v.get(25)).setAttribute("x","12" );
      ((Element)v.get(25)).setAttribute("y","12" );
      ((Element)v.get(25)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(25)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(26)).setAttribute("precarga","S" );
      ((Element)v.get(26)).setAttribute("conROver","S" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(27)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(27)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(27)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(27)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 26   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(28)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(28)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(28)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(28)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(26)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 26   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(29)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(29)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(26)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:26   */

      /* Empieza nodo:30 / Elemento padre: 25   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(25)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(31)).setAttribute("borde","1" );
      ((Element)v.get(31)).setAttribute("horizDatos","1" );
      ((Element)v.get(31)).setAttribute("horizCabecera","1" );
      ((Element)v.get(31)).setAttribute("vertical","1" );
      ((Element)v.get(31)).setAttribute("horizTitulo","1" );
      ((Element)v.get(31)).setAttribute("horizBase","1" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 30   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(32)).setAttribute("borde","#999999" );
      ((Element)v.get(32)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(32)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(32)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(32)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(32)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(32)).setAttribute("horizBase","#999999" );
      ((Element)v.get(30)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:30   */

      /* Empieza nodo:33 / Elemento padre: 25   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(33)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(33)).setAttribute("alto","22" );
      ((Element)v.get(33)).setAttribute("imgFondo","" );
      ((Element)v.get(33)).setAttribute("cod","0027" );
      ((Element)v.get(33)).setAttribute("ID","datosTitle" );
      ((Element)v.get(25)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 25   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(34)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(34)).setAttribute("alto","22" );
      ((Element)v.get(34)).setAttribute("imgFondo","" );
      ((Element)v.get(25)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 25   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(35)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(35)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(35)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(35)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(35)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(35)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(25)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(36)).setAttribute("ancho","26" );
      ((Element)v.get(36)).setAttribute("minimizable","S" );
      ((Element)v.get(36)).setAttribute("minimizada","N" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 35   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(37)).setAttribute("ancho","40" );
      ((Element)v.get(37)).setAttribute("minimizable","S" );
      ((Element)v.get(37)).setAttribute("minimizada","N" );
      ((Element)v.get(37)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(35)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 35   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(38)).setAttribute("ancho","13" );
      ((Element)v.get(38)).setAttribute("minimizable","S" );
      ((Element)v.get(38)).setAttribute("minimizada","N" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(35)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 35   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(39)).setAttribute("ancho","26" );
      ((Element)v.get(39)).setAttribute("minimizable","S" );
      ((Element)v.get(39)).setAttribute("minimizada","N" );
      ((Element)v.get(35)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 35   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(40)).setAttribute("ancho","23" );
      ((Element)v.get(40)).setAttribute("minimizable","S" );
      ((Element)v.get(40)).setAttribute("minimizada","N" );
      ((Element)v.get(40)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(35)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:35   */

      /* Empieza nodo:41 / Elemento padre: 25   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(41)).setAttribute("alto","20" );
      ((Element)v.get(41)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(41)).setAttribute("imgFondo","" );
      ((Element)v.get(41)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(25)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(42)).setAttribute("colFondo","" );
      ((Element)v.get(42)).setAttribute("ID","EstCab" );
      ((Element)v.get(42)).setAttribute("align","center" );
      ((Element)v.get(42)).setAttribute("cod","263" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Elemento padre:42 / Elemento actual: 43   */
      v.add(doc.createTextNode("Cód. cliente"));
      ((Element)v.get(42)).appendChild((Text)v.get(43));

      /* Termina nodo Texto:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 41   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(44)).setAttribute("colFondo","" );
      ((Element)v.get(44)).setAttribute("ID","EstCab" );
      ((Element)v.get(44)).setAttribute("cod","264" );
      ((Element)v.get(41)).appendChild((Element)v.get(44));

      /* Elemento padre:44 / Elemento actual: 45   */
      v.add(doc.createTextNode("Nombre cliente"));
      ((Element)v.get(44)).appendChild((Text)v.get(45));

      /* Termina nodo Texto:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 41   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(46)).setAttribute("colFondo","" );
      ((Element)v.get(46)).setAttribute("ID","EstCab" );
      ((Element)v.get(46)).setAttribute("cod","810" );
      ((Element)v.get(41)).appendChild((Element)v.get(46));

      /* Elemento padre:46 / Elemento actual: 47   */
      v.add(doc.createTextNode("Campaña"));
      ((Element)v.get(46)).appendChild((Text)v.get(47));

      /* Termina nodo Texto:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 41   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(48)).setAttribute("colFondo","" );
      ((Element)v.get(48)).setAttribute("ID","EstCab" );
      ((Element)v.get(48)).setAttribute("cod","188" );
      ((Element)v.get(41)).appendChild((Element)v.get(48));

      /* Elemento padre:48 / Elemento actual: 49   */
      v.add(doc.createTextNode("Fecha"));
      ((Element)v.get(48)).appendChild((Text)v.get(49));

      /* Termina nodo Texto:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 41   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(50)).setAttribute("colFondo","" );
      ((Element)v.get(50)).setAttribute("ID","EstCab" );
      ((Element)v.get(50)).setAttribute("cod","920" );
      ((Element)v.get(41)).appendChild((Element)v.get(50));

      /* Elemento padre:50 / Elemento actual: 51   */
      v.add(doc.createTextNode("Monto total"));
      ((Element)v.get(50)).appendChild((Text)v.get(51));

      /* Termina nodo Texto:51   */
      /* Termina nodo:50   */
      /* Termina nodo:41   */

      /* Empieza nodo:52 / Elemento padre: 25   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(52)).setAttribute("alto","22" );
      ((Element)v.get(52)).setAttribute("accion","" );
      ((Element)v.get(52)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(52)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(52)).setAttribute("maxSel","1" );
      ((Element)v.get(52)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(52)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(52)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(52)).setAttribute("onLoad","" );
      ((Element)v.get(52)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(25)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(53)).setAttribute("tipo","texto" );
      ((Element)v.get(53)).setAttribute("ID","EstDat" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 52   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(54)).setAttribute("tipo","texto" );
      ((Element)v.get(54)).setAttribute("ID","EstDat2" );
      ((Element)v.get(52)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 52   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(55)).setAttribute("tipo","texto" );
      ((Element)v.get(55)).setAttribute("ID","EstDat" );
      ((Element)v.get(52)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 52   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(56)).setAttribute("tipo","texto" );
      ((Element)v.get(56)).setAttribute("ID","EstDat2" );
      ((Element)v.get(52)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 52   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(57)).setAttribute("tipo","texto" );
      ((Element)v.get(57)).setAttribute("ID","EstDat" );
      ((Element)v.get(52)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:52   */

      /* Empieza nodo:58 / Elemento padre: 25   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(25)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 25   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(59)).setAttribute("nombre","mipgndo" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(59)).setAttribute("ancho","691" );
      ((Element)v.get(59)).setAttribute("sep","$" );
      ((Element)v.get(59)).setAttribute("x","12" );
      ((Element)v.get(59)).setAttribute("class","botonera" );
      ((Element)v.get(59)).setAttribute("y","290" );
      ((Element)v.get(59)).setAttribute("control","|" );
      ((Element)v.get(59)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(59)).setAttribute("rowset","" );
      ((Element)v.get(59)).setAttribute("cargainicial","N" );
      ((Element)v.get(25)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(60)).setAttribute("nombre","ret1" );
      ((Element)v.get(60)).setAttribute("x","37" );
      ((Element)v.get(60)).setAttribute("y","294" );
      ((Element)v.get(60)).setAttribute("ID","botonContenido" );
      ((Element)v.get(60)).setAttribute("img","retroceder_on" );
      ((Element)v.get(60)).setAttribute("tipo","0" );
      ((Element)v.get(60)).setAttribute("estado","false" );
      ((Element)v.get(60)).setAttribute("alt","" );
      ((Element)v.get(60)).setAttribute("codigo","" );
      ((Element)v.get(60)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 59   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(61)).setAttribute("nombre","ava1" );
      ((Element)v.get(61)).setAttribute("x","52" );
      ((Element)v.get(61)).setAttribute("y","294" );
      ((Element)v.get(61)).setAttribute("ID","botonContenido" );
      ((Element)v.get(61)).setAttribute("img","avanzar_on" );
      ((Element)v.get(61)).setAttribute("tipo","0" );
      ((Element)v.get(61)).setAttribute("estado","false" );
      ((Element)v.get(61)).setAttribute("alt","" );
      ((Element)v.get(61)).setAttribute("codigo","" );
      ((Element)v.get(61)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(59)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:59   */
      /* Termina nodo:25   */

      /* Empieza nodo:62 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(62)).setAttribute("nombre","primera1" );
      ((Element)v.get(62)).setAttribute("x","20" );
      ((Element)v.get(62)).setAttribute("y","294" );
      ((Element)v.get(62)).setAttribute("ID","botonContenido" );
      ((Element)v.get(62)).setAttribute("img","primera_on" );
      ((Element)v.get(62)).setAttribute("tipo","-2" );
      ((Element)v.get(62)).setAttribute("estado","false" );
      ((Element)v.get(62)).setAttribute("alt","" );
      ((Element)v.get(62)).setAttribute("codigo","" );
      ((Element)v.get(62)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(63)).setAttribute("nombre","separa" );
      ((Element)v.get(63)).setAttribute("x","59" );
      ((Element)v.get(63)).setAttribute("y","290" );
      ((Element)v.get(63)).setAttribute("ID","botonContenido" );
      ((Element)v.get(63)).setAttribute("img","separa_base" );
      ((Element)v.get(63)).setAttribute("tipo","0" );
      ((Element)v.get(63)).setAttribute("estado","false" );
      ((Element)v.get(63)).setAttribute("alt","" );
      ((Element)v.get(63)).setAttribute("codigo","" );
      ((Element)v.get(63)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(64)).setAttribute("nombre","btnCalcular" );
      ((Element)v.get(64)).setAttribute("accion","accionCalcular();" );
      ((Element)v.get(64)).setAttribute("onshtab","focalizarOnShTabBC();" );
      ((Element)v.get(64)).setAttribute("ontab","focalizarOnTabBC();" );
      ((Element)v.get(64)).setAttribute("x","13" );
      ((Element)v.get(64)).setAttribute("y","291" );
      ((Element)v.get(64)).setAttribute("ID","botonContenido" );
      ((Element)v.get(64)).setAttribute("tipo","html" );
      ((Element)v.get(64)).setAttribute("estado","false" );
      ((Element)v.get(64)).setAttribute("cod","1300" );
      ((Element)v.get(6)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(65)).setAttribute("nombre","btnAprobar" );
      ((Element)v.get(65)).setAttribute("accion","accionAprobar();" );
      ((Element)v.get(65)).setAttribute("onshtab","focalizarOnShTabBA();" );
      ((Element)v.get(65)).setAttribute("ontab","focalizarOnTabBA();" );
      ((Element)v.get(65)).setAttribute("x","71" );
      ((Element)v.get(65)).setAttribute("y","291" );
      ((Element)v.get(65)).setAttribute("ID","botonContenido" );
      ((Element)v.get(65)).setAttribute("tipo","html" );
      ((Element)v.get(65)).setAttribute("estado","false" );
      ((Element)v.get(65)).setAttribute("cod","1169" );
      ((Element)v.get(6)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(66)).setAttribute("nombre","btnSeleccionarSolicitud" );
      ((Element)v.get(66)).setAttribute("accion","accionSeleccionarSolicitudes();" );
      ((Element)v.get(66)).setAttribute("onshtab","focalizarOnShTabBSS();" );
      ((Element)v.get(66)).setAttribute("ontab","focalizarOnTabBSS();" );
      ((Element)v.get(66)).setAttribute("x","131" );
      ((Element)v.get(66)).setAttribute("y","291" );
      ((Element)v.get(66)).setAttribute("ID","botonContenido" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(66)).setAttribute("tipo","html" );
      ((Element)v.get(66)).setAttribute("estado","false" );
      ((Element)v.get(66)).setAttribute("cod","0420" );
      ((Element)v.get(6)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(67)).setAttribute("nombre","btnModificarSolicitud" );
      ((Element)v.get(67)).setAttribute("accion","accionModificarSolicitud();" );
      ((Element)v.get(67)).setAttribute("x","279" );
      ((Element)v.get(67)).setAttribute("y","291" );
      ((Element)v.get(67)).setAttribute("ID","botonContenido" );
      ((Element)v.get(67)).setAttribute("tipo","html" );
      ((Element)v.get(67)).setAttribute("estado","false" );
      ((Element)v.get(67)).setAttribute("cod","915" );
      ((Element)v.get(6)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(68)).setAttribute("nombre","btnDetalle" );
      ((Element)v.get(68)).setAttribute("accion","accionDetalle();" );
      ((Element)v.get(68)).setAttribute("onshtab","focalizarOnShTabBD();" );
      ((Element)v.get(68)).setAttribute("ontab","focalizarOnTabBD();" );
      ((Element)v.get(68)).setAttribute("x","408" );
      ((Element)v.get(68)).setAttribute("y","291" );
      ((Element)v.get(68)).setAttribute("ID","botonContenido" );
      ((Element)v.get(68)).setAttribute("tipo","html" );
      ((Element)v.get(68)).setAttribute("estado","false" );
      ((Element)v.get(68)).setAttribute("cod","3" );
      ((Element)v.get(6)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(69)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(69)).setAttribute("alto","12" );
      ((Element)v.get(69)).setAttribute("ancho","100%" );
      ((Element)v.get(69)).setAttribute("colorf","" );
      ((Element)v.get(69)).setAttribute("borde","0" );
      ((Element)v.get(69)).setAttribute("imagenf","" );
      ((Element)v.get(69)).setAttribute("repeat","" );
      ((Element)v.get(69)).setAttribute("padding","" );
      ((Element)v.get(69)).setAttribute("visibilidad","visible" );
      ((Element)v.get(69)).setAttribute("contravsb","" );
      ((Element)v.get(69)).setAttribute("x","0" );
      ((Element)v.get(69)).setAttribute("y","313" );
      ((Element)v.get(69)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:6   */


   }

}

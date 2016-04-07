
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_caja_cerrar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_caja_cerrar" );
      ((Element)v.get(0)).setAttribute("cod","0474" );
      ((Element)v.get(0)).setAttribute("titulo","Cerrar una caja" );
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
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(2));

      /* Elemento padre:2 / Elemento actual: 3   */
      v.add(doc.createTextNode("\r   \r\r	function onLoadPag()   {\r		configurarMenuSecundario('frmFormulario');\r		DrdEnsanchaConMargenDcho('listado1',12);\r		document.all[\"Cplistado1\"].style.visibility='';\r		document.all[\"CpLin1listado1\"].style.visibility='';\r		document.all[\"CpLin2listado1\"].style.visibility='';\r		document.all[\"CpLin3listado1\"].style.visibility='';\r		document.all[\"CpLin4listado1\"].style.visibility='';\r\r		document.all[\"primera1Div\"].style.visibility='hidden';\r		document.all[\"ret1Div\"].style.visibility='hidden';\r		document.all[\"ava1Div\"].style.visibility='hidden'; \r		document.all[\"separaDiv\"].style.visibility='hidden';\r		document.all[\"btnAnadirDiv\"].style.visibility='';\r		document.all[\"btnModificarDiv\"].style.visibility='';\r		eval (ON_RSZ);  \r\r		configurarMenuSecundario(\"formulario\");\r		fMostrarMensajeError();\r\r		if((get(\"frmFormulario.errCodigo\")=='30108') || (get(\"frmFormulario.errCodigo\")=='30109') ){\r\r			eval(\"frmFormulario\").oculto = \"N\";\r			set('frmFormulario.conectorAction', 'LPCerrarUnaCaja');\r			set('frmFormulario.accion', '');\r			/*enviaSICC('frmFormulario');*/\r\r		} else if(get(\"frmFormulario.errCodigo\")!=null){\r			redireccionar();	\r\r		} else {\r			focalizaBotonHTML_XY(\"btnAnadir\");\r		}     \r\r	}\r\r	function reiniciar()  {\r		 GestionarMensaje('1583');   \r		 set('frmFormulario.conectorAction', 'LPCerrarUnaCaja');\r		 eval(\"frmFormulario\").oculto = \"N\";\r		 set('frmFormulario.accion', '');\r         enviaSICC('frmFormulario');\r	}\r\r\r   function redireccionar(){\r\r      var error = get('frmFormulario.errCodigo');\r\r	  if(error == '30107' || error == '30103' || error == '30109'){\r\r		deshabilitarHabilitarBoton('botonContenido','btnAnadir','D')\r		deshabilitarHabilitarBoton('botonContenido','btnModificar','D')\r		deshabilitarHabilitarBoton('botonContenido','btnEliminar','D')\r\r      /*} else if(error == '30108'|| error == '30109' ){*/\r      } else if(error == '30108' ){\r		 eval(\"frmFormulario\").oculto = \"N\";\r         set('frmFormulario.conectorAction', 'LPCerrarUnaCaja');\r		 set('frmFormulario.accion', '');\r         enviaSICC('frmFormulario');\r\r      }\r\r   }\r\r   function accionModificar(){\r\r      if (listado1.codSeleccionados().length == 1){\r         var a = new Object();\r         a.accion = 'modificar';\r         a.hSubacceso = get('frmFormulario.hSubacceso');\r         a.hMedioPago     = listado1.extraeDato(listado1.codSeleccionados(), 4);\r         a.hMoneda        = listado1.extraeDato(listado1.codSeleccionados(), 5);\r         a.hImporte       = listado1.extraeDato(listado1.codSeleccionados(), 2);\r         a.hImporteDivisa = listado1.extraeDato(listado1.codSeleccionados(), 3);\r         \r		 var codigoSeleccionado = listado1.codSeleccionados();\r		 var filaSeleccion =  DrIndiceEnArray(listado1.datos, codigoSeleccionado, 0) ;\r         \r         var vWnd = mostrarModalSICC('LPCerrarUnaCaja','modificar', a);\r\r         if(vWnd != null){\r						var arrListado = listado1.datos;   \r			var medioPago = new String(vWnd[0]);\r			var moneda 	=  new String(vWnd[1]);\r 			var importe =  new String(vWnd[2]);\r			var importeDivisa =  new String(vWnd[3]);\r			arrListado[filaSeleccion][1] = medioPago;\r			arrListado[filaSeleccion][2] = moneda;\r			arrListado[filaSeleccion][3] = importe;\r			arrListado[filaSeleccion][4] = importeDivisa;\r						listado1.datos = arrListado;   \r						listado1.save();   \r			listado1.repintaDat();   \r         }\r      }else {   \r           GestionarMensaje('4');   \r      }\r   }\r\r\r\r   function accionAniadir(){\r      var a = new Object();\r      a.accion = 'modificar';\r      a.hSubacceso = get('frmFormulario.hSubacceso');\r      var vWnd = mostrarModalSICC('LPCerrarUnaCaja','anyadir', a);\r      if(vWnd != null){\r          var arr = new Array();\r          \r          arr[arr.length] = listado1.generaCodigo();\r          arr[arr.length] = vWnd[0]; \r          arr[arr.length] = vWnd[1]; \r          arr[arr.length] = vWnd[2]; \r          arr[arr.length] = vWnd[3];\r          arr[arr.length] = vWnd[4];\r          arr[arr.length] = vWnd[5];\r          \r          listado1.insertar(arr);\r          listado1.repinta();\r      }\r   }\r\r   function accionEliminar(){\r      fBorrar();\r   }\r\r   function fBorrar(){\r      if(listado1.codSeleccionados().length > 0){\r         listado1.eliminarSelecc();\r      }else{\r         GestionarMensaje('4');\r      }\r   }\r\r\r   function fGuardar(){\r\r      if(listado1.datos.length > 0){\r		 var nro = get('frmFormulario.hIdOportunidad');\r		 if(get('frmFormulario.hIdOportunidad')==\"1\"){\r			nro=2;\r			eval(\"frmFormulario\").oculto = \"N\";\r		 }else{\r			eval(\"frmFormulario\").oculto = \"S\";\r			nro='1';\r		 }\r		 set('frmFormulario.hIdOportunidad', nro);		 \r         set('frmFormulario.accion', 'guardar');\r         set('frmFormulario.conectorAction', 'LPCerrarUnaCaja');\r         recolectarListado();\r         enviaSICC('frmFormulario');    \r      }\r   }\r\r\r   function recolectarListado(){\r      var datos = new String();\r\r      for(var i=0; i < listado1.datos.length;i++) {\r       \r\r          if(listado1.datos[i][3] == ''){\r             datos = datos + ' ;';\r          }else{\r             datos = datos + listado1.datos[i][3] + ';';\r          }\r\r          if(listado1.datos[i][4] == ''){\r             datos = datos + ' ;';\r          }else{\r             datos = datos + listado1.datos[i][4] + ';';\r          }\r\r          if(listado1.datos[i][5] == ''){\r             datos = datos + ' ;';\r          }else{\r             datos = datos + listado1.datos[i][5] + ';';\r          }\r\r          if(listado1.datos[i][6] == ''){\r             datos = datos + ' |';\r          }else{\r             datos = datos + listado1.datos[i][6] + '|';\r          }\r              \r\r      }\r      set('frmFormulario.hListado', datos);\r      \r   }\r\r\r\r	 \r   \r   \r"));
      ((Element)v.get(2)).appendChild((Text)v.get(3));

      /* Termina nodo Texto:3   */
      /* Termina nodo:2   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(4)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(4)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(5)).setAttribute("nombre","accion" );
      ((Element)v.get(5)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","hPais" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","hPaisDescripcion" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","hSubacceso" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hCaja" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hMedioPago" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hMoneda" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hImporte" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hImporteDivisa" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hListado" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hIdOportunidad" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 4   */
      v.add(doc.createElement("table"));
      ((Element)v.get(20)).setAttribute("width","100%" );
      ((Element)v.get(20)).setAttribute("border","0" );
      ((Element)v.get(20)).setAttribute("cellspacing","0" );
      ((Element)v.get(20)).setAttribute("cellpadding","0" );
      ((Element)v.get(4)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("td"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("width","100%" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(23)).setAttribute("src","b.gif" );
      ((Element)v.get(23)).setAttribute("width","674" );
      ((Element)v.get(23)).setAttribute("height","8" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */
      /* Termina nodo:22   */
      /* Termina nodo:21   */
      /* Termina nodo:20   */

      /* Empieza nodo:24 / Elemento padre: 4   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(24)).setAttribute("nombre","listado1" );
      ((Element)v.get(24)).setAttribute("ancho","650" );
      ((Element)v.get(24)).setAttribute("alto","301" );
      ((Element)v.get(24)).setAttribute("x","12" );
      ((Element)v.get(24)).setAttribute("y","12" );
      ((Element)v.get(24)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(24)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(4)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(25)).setAttribute("precarga","S" );
      ((Element)v.get(25)).setAttribute("conROver","S" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(26)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(26)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(26)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(26)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 25   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(27)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(27)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(27)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(27)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(25)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 25   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(28)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(28)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(25)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:25   */

      /* Empieza nodo:29 / Elemento padre: 24   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(24)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(30)).setAttribute("borde","1" );
      ((Element)v.get(30)).setAttribute("horizDatos","1" );
      ((Element)v.get(30)).setAttribute("horizCabecera","1" );
      ((Element)v.get(30)).setAttribute("vertical","1" );
      ((Element)v.get(30)).setAttribute("horizTitulo","1" );
      ((Element)v.get(30)).setAttribute("horizBase","1" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 29   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(31)).setAttribute("borde","#999999" );
      ((Element)v.get(31)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(31)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(31)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(31)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(31)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(31)).setAttribute("horizBase","#999999" );
      ((Element)v.get(29)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:29   */

      /* Empieza nodo:32 / Elemento padre: 24   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(32)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(32)).setAttribute("alto","22" );
      ((Element)v.get(32)).setAttribute("imgFondo","" );
      ((Element)v.get(32)).setAttribute("ID","datosTitle" );
      ((Element)v.get(32)).setAttribute("cod","00271" );
      ((Element)v.get(24)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 24   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(33)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(33)).setAttribute("alto","22" );
      ((Element)v.get(33)).setAttribute("imgFondo","" );
      ((Element)v.get(24)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 24   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(34)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(34)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(34)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(34)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(34)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(34)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(24)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(35)).setAttribute("ancho","100" );
      ((Element)v.get(35)).setAttribute("minimizable","S" );
      ((Element)v.get(35)).setAttribute("minimizada","N" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 34   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(36)).setAttribute("ancho","80" );
      ((Element)v.get(36)).setAttribute("minimizable","S" );
      ((Element)v.get(36)).setAttribute("minimizada","N" );
      ((Element)v.get(34)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 34   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(37)).setAttribute("ancho","60" );
      ((Element)v.get(37)).setAttribute("minimizable","S" );
      ((Element)v.get(37)).setAttribute("minimizada","N" );
      ((Element)v.get(34)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 34   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(38)).setAttribute("ancho","60" );
      ((Element)v.get(38)).setAttribute("minimizable","S" );
      ((Element)v.get(38)).setAttribute("minimizada","N" );
      ((Element)v.get(34)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 34   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(39)).setAttribute("ancho","60" );
      ((Element)v.get(39)).setAttribute("minimizable","S" );
      ((Element)v.get(39)).setAttribute("minimizada","N" );
      ((Element)v.get(39)).setAttribute("oculta","S" );
      ((Element)v.get(34)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 34   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(40)).setAttribute("ancho","60" );
      ((Element)v.get(40)).setAttribute("minimizable","S" );
      ((Element)v.get(40)).setAttribute("minimizada","N" );
      ((Element)v.get(40)).setAttribute("oculta","S" );
      ((Element)v.get(34)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:34   */

      /* Empieza nodo:41 / Elemento padre: 24   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(41)).setAttribute("alto","20" );
      ((Element)v.get(41)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(41)).setAttribute("imgFondo","" );
      ((Element)v.get(41)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(24)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(42)).setAttribute("colFondo","" );
      ((Element)v.get(42)).setAttribute("ID","EstCab" );
      ((Element)v.get(42)).setAttribute("cod","673" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 41   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(43)).setAttribute("colFondo","" );
      ((Element)v.get(43)).setAttribute("ID","EstCab" );
      ((Element)v.get(43)).setAttribute("cod","1216" );
      ((Element)v.get(41)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 41   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(44)).setAttribute("colFondo","" );
      ((Element)v.get(44)).setAttribute("ID","EstCab" );
      ((Element)v.get(44)).setAttribute("cod","573" );
      ((Element)v.get(41)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 41   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(45)).setAttribute("colFondo","" );
      ((Element)v.get(45)).setAttribute("ID","EstCab" );
      ((Element)v.get(45)).setAttribute("cod","668" );
      ((Element)v.get(41)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 41   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(46)).setAttribute("colFondo","" );
      ((Element)v.get(46)).setAttribute("ID","EstCab" );
      ((Element)v.get(46)).setAttribute("align","center" );
      ((Element)v.get(41)).appendChild((Element)v.get(46));

      /* Elemento padre:46 / Elemento actual: 47   */
      v.add(doc.createTextNode("oidMedioPago"));
      ((Element)v.get(46)).appendChild((Text)v.get(47));

      /* Termina nodo Texto:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 41   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(48)).setAttribute("colFondo","" );
      ((Element)v.get(48)).setAttribute("ID","EstCab" );
      ((Element)v.get(48)).setAttribute("align","center" );
      ((Element)v.get(41)).appendChild((Element)v.get(48));

      /* Elemento padre:48 / Elemento actual: 49   */
      v.add(doc.createTextNode("oidMoneda"));
      ((Element)v.get(48)).appendChild((Text)v.get(49));

      /* Termina nodo Texto:49   */
      /* Termina nodo:48   */
      /* Termina nodo:41   */

      /* Empieza nodo:50 / Elemento padre: 24   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(50)).setAttribute("alto","22" );
      ((Element)v.get(50)).setAttribute("accion","" );
      ((Element)v.get(50)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(50)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(50)).setAttribute("maxSel","-1" );
      ((Element)v.get(50)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(50)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(50)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(50)).setAttribute("onLoad","" );
      ((Element)v.get(50)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(24)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(51)).setAttribute("tipo","texto" );
      ((Element)v.get(51)).setAttribute("ID","EstDat" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 50   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(52)).setAttribute("tipo","texto" );
      ((Element)v.get(52)).setAttribute("ID","EstDat2" );
      ((Element)v.get(50)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 50   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(53)).setAttribute("tipo","texto" );
      ((Element)v.get(53)).setAttribute("ID","EstDat" );
      ((Element)v.get(50)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 50   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(54)).setAttribute("tipo","texto" );
      ((Element)v.get(54)).setAttribute("ID","EstDat2" );
      ((Element)v.get(50)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 50   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(55)).setAttribute("tipo","texto" );
      ((Element)v.get(55)).setAttribute("ID","EstDat" );
      ((Element)v.get(50)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 50   */
      v.add(doc.createElement("COL"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(56)).setAttribute("tipo","texto" );
      ((Element)v.get(56)).setAttribute("ID","EstDat2" );
      ((Element)v.get(50)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:50   */

      /* Empieza nodo:57 / Elemento padre: 24   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(24)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 24   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(58)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(58)).setAttribute("ancho","650" );
      ((Element)v.get(58)).setAttribute("sep","$" );
      ((Element)v.get(58)).setAttribute("x","12" );
      ((Element)v.get(58)).setAttribute("class","botonera" );
      ((Element)v.get(58)).setAttribute("y","290" );
      ((Element)v.get(58)).setAttribute("control","|" );
      ((Element)v.get(58)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(58)).setAttribute("rowset","" );
      ((Element)v.get(58)).setAttribute("cargainicial","N" );
      ((Element)v.get(24)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(59)).setAttribute("nombre","ret1" );
      ((Element)v.get(59)).setAttribute("x","37" );
      ((Element)v.get(59)).setAttribute("y","294" );
      ((Element)v.get(59)).setAttribute("ID","botonContenido" );
      ((Element)v.get(59)).setAttribute("img","retroceder_on" );
      ((Element)v.get(59)).setAttribute("tipo","0" );
      ((Element)v.get(59)).setAttribute("estado","false" );
      ((Element)v.get(59)).setAttribute("alt","" );
      ((Element)v.get(59)).setAttribute("codigo","" );
      ((Element)v.get(59)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 58   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(60)).setAttribute("nombre","ava1" );
      ((Element)v.get(60)).setAttribute("x","52" );
      ((Element)v.get(60)).setAttribute("y","294" );
      ((Element)v.get(60)).setAttribute("ID","botonContenido" );
      ((Element)v.get(60)).setAttribute("img","avanzar_on" );
      ((Element)v.get(60)).setAttribute("tipo","0" );
      ((Element)v.get(60)).setAttribute("estado","false" );
      ((Element)v.get(60)).setAttribute("alt","" );
      ((Element)v.get(60)).setAttribute("codigo","" );
      ((Element)v.get(60)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(58)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:58   */
      /* Termina nodo:24   */

      /* Empieza nodo:61 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(61)).setAttribute("nombre","primera1" );
      ((Element)v.get(61)).setAttribute("x","20" );
      ((Element)v.get(61)).setAttribute("y","294" );
      ((Element)v.get(61)).setAttribute("ID","botonContenido" );
      ((Element)v.get(61)).setAttribute("img","primera_on" );
      ((Element)v.get(61)).setAttribute("tipo","-2" );
      ((Element)v.get(61)).setAttribute("estado","false" );
      ((Element)v.get(61)).setAttribute("alt","" );
      ((Element)v.get(61)).setAttribute("codigo","" );
      ((Element)v.get(61)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(4)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(62)).setAttribute("nombre","separa" );
      ((Element)v.get(62)).setAttribute("x","59" );
      ((Element)v.get(62)).setAttribute("y","290" );
      ((Element)v.get(62)).setAttribute("ID","botonContenido" );
      ((Element)v.get(62)).setAttribute("img","separa_base" );
      ((Element)v.get(62)).setAttribute("tipo","0" );
      ((Element)v.get(62)).setAttribute("estado","false" );
      ((Element)v.get(62)).setAttribute("alt","" );
      ((Element)v.get(62)).setAttribute("codigo","" );
      ((Element)v.get(62)).setAttribute("accion","" );
      ((Element)v.get(4)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(63)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(63)).setAttribute("x","13" );
      ((Element)v.get(63)).setAttribute("y","291" );
      ((Element)v.get(63)).setAttribute("ID","botonContenido" );
      ((Element)v.get(63)).setAttribute("img","" );
      ((Element)v.get(63)).setAttribute("tipo","html" );
      ((Element)v.get(63)).setAttribute("estado","false" );
      ((Element)v.get(63)).setAttribute("cod","404" );
      ((Element)v.get(63)).setAttribute("accion","accionAniadir();" );
      ((Element)v.get(63)).setAttribute("onshtab","focalizaBotonHTML_XY('btnEliminar');" );
      ((Element)v.get(4)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(64)).setAttribute("nombre","btnModificar" );
      ((Element)v.get(64)).setAttribute("x","61" );
      ((Element)v.get(64)).setAttribute("y","291" );
      ((Element)v.get(64)).setAttribute("ID","botonContenido" );
      ((Element)v.get(64)).setAttribute("img","" );
      ((Element)v.get(64)).setAttribute("tipo","html" );
      ((Element)v.get(64)).setAttribute("estado","false" );
      ((Element)v.get(64)).setAttribute("cod","2" );
      ((Element)v.get(64)).setAttribute("accion","accionModificar();" );
      ((Element)v.get(4)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(65)).setAttribute("nombre","btnEliminar" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(65)).setAttribute("x","127" );
      ((Element)v.get(65)).setAttribute("y","291" );
      ((Element)v.get(65)).setAttribute("ID","botonContenido" );
      ((Element)v.get(65)).setAttribute("img","" );
      ((Element)v.get(65)).setAttribute("tipo","html" );
      ((Element)v.get(65)).setAttribute("estado","false" );
      ((Element)v.get(65)).setAttribute("cod","1254" );
      ((Element)v.get(65)).setAttribute("accion","accionEliminar();" );
      ((Element)v.get(65)).setAttribute("ontab","focalizaBotonHTML_XY('btnAnadir');" );
      ((Element)v.get(4)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(66)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(66)).setAttribute("alto","12" );
      ((Element)v.get(66)).setAttribute("ancho","100%" );
      ((Element)v.get(66)).setAttribute("colorf","" );
      ((Element)v.get(66)).setAttribute("borde","0" );
      ((Element)v.get(66)).setAttribute("imagenf","" );
      ((Element)v.get(66)).setAttribute("repeat","" );
      ((Element)v.get(66)).setAttribute("padding","" );
      ((Element)v.get(66)).setAttribute("visibilidad","visible" );
      ((Element)v.get(66)).setAttribute("contravsb","" );
      ((Element)v.get(66)).setAttribute("x","0" );
      ((Element)v.get(66)).setAttribute("y","313" );
      ((Element)v.get(66)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:4   */


   }

}


import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_estructura_geopolitica_pais_definir  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_estructura_geopolitica_pais_definir" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Definir Estructura Geopolítica de País" );
      ((Element)v.get(0)).setAttribute("onload","initCarga();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("cod","072" );
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
      v.add(doc.createTextNode("\r\rvar varNoLimpiarSICC = true;\r	 function initCarga() {	\r            DrdEnsanchaConMargenDcho('listado1',12);\r			document.all[\"Cplistado1\"].style.visibility='';\r			document.all[\"CpLin1listado1\"].style.visibility='';\r			document.all[\"CpLin2listado1\"].style.visibility='';\r			document.all[\"CpLin3listado1\"].style.visibility='';\r			document.all[\"CpLin4listado1\"].style.visibility='';\r			document.all[\"primera1Div\"].style.visibility='hidden';\r			document.all[\"ret1Div\"].style.visibility='hidden';\r			document.all[\"ava1Div\"].style.visibility='hidden';\r			document.all[\"separaDiv\"].style.visibility='hidden';\r		\r			eval (ON_RSZ);\r\r						var correcto = chequeaErrores();\r\r			configurarMenuSecundario(\"frmformula\");\r			\r						if (correcto == true) {\r			        cantNiveles = listado1.datos.length; \r					document.getElementById(\"nivel_0\").focus();\r					var exito = get(\"frmformula.exito\");\r					if (exito == \"S\") {\r							 var wnd = fMostrarMensajeExito();\r							 set(\"frmformula.conectorAction\", \"LPDefinirEG\");\r							 set(\"frmformula.accion\", \"volver\");\r						     enviaSICC(\"frmformula\");\r					}					\r					if (get('frmformula.casoDeUso') == \"definir\") {\r											}\r			} \r\r	 }\r\r	 var cantNiveles = null; \r	 \r	 function chequeaErrores()	 {\r			var codigoError = get(\"frmformula.errCodigo\");\r			var descError = get(\"frmformula.errDescripcion\");\r			if (codigoError == \"\")	{\r					return true;\r			} else {\r  				    fMostrarMensajeError(codigoError, descError);\r										if (codigoError == 240050001 || codigoError == 240220001) {\r					    						set(\"frmformula.conectorAction\", \"LPDefinirEG\");\r						set(\"frmformula.accion\", \"volver\");\r					    enviaSICC(\"frmformula\");\r					}					\r																				llenaCajasValoresAnt();\r					return false;\r			}\r	 }\r	\r	function setComboDefault(hid, cb) {\r		 iSeleccionado = new Array(); \r		 iSeleccionado[0] = get(hid);\r		 set(cb,iSeleccionado);\r	}\r\r	function accionaActualizar() {\r															var bDatosValidados = false;\r			var bChequeaCorrelatividad = false;\r			bDatosValidados = chequearDatos();\r									if (bDatosValidados == true) {\r					bChequeaCorrelatividad = chequeaCorrelatividad();\r					if (bChequeaCorrelatividad == true)                             \r							enviaDefinir();					\r			}\r	}\r\r	 function chequearDatos() {	\r																		var i = 0;\r			var bBreak = false;\r			var bTextoVacio = true; \r			var bCaracteresInvalidos = false;\r			var sContenidoTextBox;\r			var sValorEtiqueta = \"\";\r						while (bBreak == false && i<cantNiveles) {\r 			  	  sContenidoTextBox = document.getElementById(\"nivel_\" + i).value;\r				  				  if (sContenidoTextBox != \"\")  {\r 						 bTextoVacio = false;  						 						 bCaracteresInvalidos = validaChars(sContenidoTextBox);\r						 if (bCaracteresInvalidos == false) {\r								sValorEtiqueta = devuelveEtiqueta(i);\r								GestionarMensaje(\"959\", sValorEtiqueta, null, null);\r																document.getElementById(\"nivel_\" + i).focus();\r								bBreak = true;\r						  }\r				  }\r				  i++;\r			}\r			if (bTextoVacio == true) {\r				GestionarMensaje(\"970\", null, null, null);\r				document.getElementById(\"nivel_0\").focus();\r				return false;\r			} \r			if (bBreak == true)  					return false;\r			else\r				   return true;\r	 }\r\r	 function chequeaCorrelatividad() {\r												\r			var arrayNiveles = new Array(cantNiveles);\r			var indicesCajasConTexto = new Array(cantNiveles);  			var indiceBuffer = 0;\r			var cantCajasTextoLlenas = 0 ;\r			var nValor;\r			var bBreak = false;\r			var i = 0;\r					\r																					while (i < cantNiveles)	{\r				var nValor = document.getElementById(\"nivel_\" + i).value; \r				if (nValor != \"\") {\r					indicesCajasConTexto[cantCajasTextoLlenas] = i;\r					cantCajasTextoLlenas++;\r				}\r				i++;\r			}\r									if (cantCajasTextoLlenas == 1) { 					nValor = document.getElementById(\"nivel_\" + indicesCajasConTexto[0] ).value;\r										if (nValor == \"1\") {\r					      return true;\r					}else {\r						GestionarMensaje(\"964\", null, null, null); \r												return false;\r					}\r			} \r			i = 0;\r\r															while (i < cantCajasTextoLlenas) {\r				arrayNiveles[i] = 0;\r				i++;\r			}\r			i = 0;\r			while ( i < cantCajasTextoLlenas ) {	\r				nValor = document.getElementById(\"nivel_\" + indicesCajasConTexto[i]).value;\r								if ( nValor > 0 && nValor <= cantCajasTextoLlenas) { 					arrayNiveles[nValor-1]++;\r									}				\r				i++;\r			}\r			\r															i = 0;\r			var vBuffer = 0;\r						while (i < cantCajasTextoLlenas && bBreak == false)	{\r					vBuffer = arrayNiveles[i];\r					if (vBuffer == 0) {\r						GestionarMensaje(\"965\", (i+1), null, null);\r												bBreak = true;\r					} else if (vBuffer > 1)	{\r						GestionarMensaje(\"966\", (i+1), null, null);\r												bBreak = true;\r					}\r					i++;\r			}\r			return !bBreak;				 }\r\r	 function validaChars(str) {\r			var c;		\r			permitidos=\"0123456789\";\r			for (var i=0; i<str.length; i++) {\r				c=str.charAt(i);\r				if ( permitidos.indexOf(c) == -1 ) \r				  return false;\r				else if ( c == ' ' && i == 0 )\r				  return false;\r				else if ( c == ' ' && i == (str.length-1) )\r					return false;				\r			}	\r			return true;\r		}\r\r		function devuelveEtiqueta(indice) {\r			   				   					                return listado1.datos[indice][1];\r				/*var valorEtiq = get(\"frmformula.valorEtiquetas\");\r				var vectorSpliteado = valorEtiq.split(\"|\");\r				return vectorSpliteado[indice];*/\r		}\r\r		function obtieneOidOcultos() {\r 			 			 			 			 			 			 var i = 0;\r			 var valorARetornar;\r			 while ( i < cantNiveles) {\r										valorOculto = listado1.datos[i][0];\r										if (valorOculto == \"\")\r						valorOculto = \"NADA\";\r\r										if (i == 0)\r						valorARetornar = valorOculto;\r					else\r						valorARetornar = valorARetornar + \"|\" + valorOculto;\r					i++;\r			 }\r			 			 return valorARetornar;\r   	 }\r\r		 function obtieneValoresCajasTexto() {\r			 			 			  			 			 			 var i = 0;\r			 var valorARetornar;\r			 while ( i < cantNiveles) {\r					valorOculto = document.getElementById(\"nivel_\" + i).value;\r					if (valorOculto == \"\")\r						valorOculto = \"NADA\";\r										if (i == 0)\r						valorARetornar = valorOculto;\r					else\r						valorARetornar = valorARetornar + \"|\" + valorOculto;\r					i++;\r			 }\r			 			 return valorARetornar;\r		 }\r\r	 function enviaDefinir() {\r			var oidOcultos = obtieneOidOcultos();\r			var valoresTextBoxes = obtieneValoresCajasTexto();\r						set(\"frmformula.enviaOid\", oidOcultos);\r     					set(\"frmformula.enviaNivel\", valoresTextBoxes);\r			set(\"frmformula.accion\", \"definir\");\r			set(\"frmformula.conectorAction\", \"LPDefinirEG\");\r\r            			enviaSICC(\"frmformula\");\r	 }\r\r	 function fGuardar() {\r												\r			accionaActualizar() ;\r	 }\r\r	 function fLimpiar() {\r 		  var cantNiveles = listado1.datos.length;\r		  var i = 0;\r		  for (i=0; i< cantNiveles; i++) {\r								document.getElementById(\"nivel_\" + i).value = \"\";\r		  }\r		  document.getElementById(\"nivel_0\").focus();\r		  return;\r	 }\r\r	 function fSalir() {\r			set(\"frmformula.conectorAction\", \"LPInicioBelcorp\");\r			enviaSICC(\"frmformula\");\r	 }\r\r	 function validaCeros()	 {\r									var bBreak = false;\r			var nCantNiveles = listado1.datos.length;\r			var i = 0;\r			var nValor = \"\";			\r			while (bBreak == false && i < nCantNiveles)	{\r					nValor = document.getElementById(\"nivel_\" + i).value;\r					if (nValor == \"\") {\r						GestionarMensaje(\"967\", null, null, null);\r						document.getElementById(\"nivel_\" + i).focus();\r						bBreak = true;\r					}\r					i++;\r			}\r			return !bBreak;  	 }\r\r	 function llenaCajasValoresAnt() {\r															var oidAnterior = get(\"frmformula.hidRecibeOidAnterior\");\r			var nivelAnterior = get(\"frmformula.hidRecibeNivelAnterior\");\r			var cantNiveles = listado1.datos.length;\r			var i = 0;\r			var oidSplit = oidAnterior.split(\"|\");\r			var nivelSplit = nivelAnterior.split(\"|\");\r\r									 for (i = 0; i < cantNiveles; i++) {\r				 if (nivelSplit[i] == \"NADA\")\r					document.getElementById(\"nivel_\" + i).value = \"\";			\r				 else\r					document.getElementById(\"nivel_\" + i).value = nivelSplit[i];		\r			 }\r	 }\r\r\r	 function focalizaListaTab(FILAEVENTO) {\r						if(FILAEVENTO == (listado1.datos.length - 1)){			\r			listado1.preparaCamposDR();            \r            setTimeout(\"focaliza('frmlistado1.nivel_0','')\",10); \r		}       \r    }\r\r\r	function focalizaListaShTab(FILAEVENTO) {\r		\r		if(FILAEVENTO == 0){\r			linea= listado1.datos.length - 1;\r			listado1.preparaCamposDR();            \r            setTimeout(\"focaliza('frmlistado1.nivel_' + linea,'')\",10); \r		}       \r    }\r\r\r\r"));
      ((Element)v.get(2)).appendChild((Text)v.get(3));

      /* Termina nodo Texto:3   */
      /* Termina nodo:2   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(4)).setAttribute("nombre","frmformula" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(5)).setAttribute("nombre","accion" );
      ((Element)v.get(5)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","hidPaisABuscar" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","cantNiveles" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","valorEtiquetas" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","enviaOid" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","enviaNivel" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","exito" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hidRecibeOidAnterior" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hidRecibeNivelAnterior" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 4   */
      v.add(doc.createElement("table"));
      ((Element)v.get(18)).setAttribute("width","100%" );
      ((Element)v.get(18)).setAttribute("border","0" );
      ((Element)v.get(18)).setAttribute("cellspacing","0" );
      ((Element)v.get(18)).setAttribute("cellpadding","0" );
      ((Element)v.get(4)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("td"));
      ((Element)v.get(20)).setAttribute("width","100%" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(21)).setAttribute("src","b.gif" );
      ((Element)v.get(21)).setAttribute("width","424" );
      ((Element)v.get(21)).setAttribute("height","8" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */
      /* Termina nodo:20   */
      /* Termina nodo:19   */
      /* Termina nodo:18   */

      /* Empieza nodo:22 / Elemento padre: 4   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(22)).setAttribute("nombre","listado1" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("ancho","400" );
      ((Element)v.get(22)).setAttribute("alto","254" );
      ((Element)v.get(22)).setAttribute("x","12" );
      ((Element)v.get(22)).setAttribute("y","12" );
      ((Element)v.get(22)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(22)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(4)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(23)).setAttribute("precarga","S" );
      ((Element)v.get(23)).setAttribute("conROver","S" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(24)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(24)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(24)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(24)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 23   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(25)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(25)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(25)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(25)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(23)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 23   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(26)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(26)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(23)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:23   */

      /* Empieza nodo:27 / Elemento padre: 22   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(22)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(28)).setAttribute("borde","1" );
      ((Element)v.get(28)).setAttribute("horizDatos","1" );
      ((Element)v.get(28)).setAttribute("horizCabecera","1" );
      ((Element)v.get(28)).setAttribute("vertical","1" );
      ((Element)v.get(28)).setAttribute("horizTitulo","1" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 27   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(29)).setAttribute("borde","#999999" );
      ((Element)v.get(29)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(29)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(29)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(29)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(29)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(27)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:27   */

      /* Empieza nodo:30 / Elemento padre: 22   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(30)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(30)).setAttribute("alto","22" );
      ((Element)v.get(30)).setAttribute("imgFondo","" );
      ((Element)v.get(30)).setAttribute("cod","00502" );
      ((Element)v.get(30)).setAttribute("ID","datosTitle" );
      ((Element)v.get(22)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 22   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(31)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(31)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(31)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(31)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(31)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(31)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(22)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(32)).setAttribute("ancho","80" );
      ((Element)v.get(32)).setAttribute("minimizable","S" );
      ((Element)v.get(32)).setAttribute("minimizada","N" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 31   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(33)).setAttribute("ancho","50" );
      ((Element)v.get(33)).setAttribute("minimizable","S" );
      ((Element)v.get(33)).setAttribute("minimizada","N" );
      ((Element)v.get(31)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:31   */

      /* Empieza nodo:34 / Elemento padre: 22   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(34)).setAttribute("alto","20" );
      ((Element)v.get(34)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(34)).setAttribute("imgFondo","" );
      ((Element)v.get(34)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(34)).setAttribute("ajustarAMitadInf","S" );
      ((Element)v.get(22)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(35)).setAttribute("colFondo","" );
      ((Element)v.get(35)).setAttribute("ID","EstCab" );
      ((Element)v.get(35)).setAttribute("align","center" );
      ((Element)v.get(35)).setAttribute("cod","2202" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Elemento padre:35 / Elemento actual: 36   */
      v.add(doc.createTextNode("Niveles geográficos"));
      ((Element)v.get(35)).appendChild((Text)v.get(36));

      /* Termina nodo Texto:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:37 / Elemento padre: 34   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(37)).setAttribute("colFondo","" );
      ((Element)v.get(37)).setAttribute("ID","EstCab" );
      ((Element)v.get(37)).setAttribute("cod","357" );
      ((Element)v.get(34)).appendChild((Element)v.get(37));

      /* Elemento padre:37 / Elemento actual: 38   */
      v.add(doc.createTextNode("Nivel"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(37)).appendChild((Text)v.get(38));

      /* Termina nodo Texto:38   */
      /* Termina nodo:37   */
      /* Termina nodo:34   */

      /* Empieza nodo:39 / Elemento padre: 22   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(39)).setAttribute("alto","22" );
      ((Element)v.get(39)).setAttribute("accion","" );
      ((Element)v.get(39)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(39)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(39)).setAttribute("maxSel","0" );
      ((Element)v.get(39)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(39)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(39)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(39)).setAttribute("onLoad","" );
      ((Element)v.get(39)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(22)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(40)).setAttribute("tipo","texto" );
      ((Element)v.get(40)).setAttribute("ID","EstDat" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 39   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(41)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(41)).setAttribute("nombre","nivel" );
      ((Element)v.get(41)).setAttribute("size","2" );
      ((Element)v.get(41)).setAttribute("max","2" );
      ((Element)v.get(41)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(41)).setAttribute("ID","EstDat2" );
      ((Element)v.get(41)).setAttribute("onTab","focalizaListaTab(FILAEVENTO)" );
      ((Element)v.get(41)).setAttribute("onShTab","focalizaListaShTab(FILAEVENTO);" );
      ((Element)v.get(39)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:39   */

      /* Empieza nodo:42 / Elemento padre: 22   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(22)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 22   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(43)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(43)).setAttribute("ancho","400" );
      ((Element)v.get(43)).setAttribute("sep","$" );
      ((Element)v.get(43)).setAttribute("x","12" );
      ((Element)v.get(43)).setAttribute("class","botonera" );
      ((Element)v.get(43)).setAttribute("y","244" );
      ((Element)v.get(43)).setAttribute("control","|" );
      ((Element)v.get(43)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(43)).setAttribute("rowset","" );
      ((Element)v.get(43)).setAttribute("cargainicial","N" );
      ((Element)v.get(22)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(44)).setAttribute("nombre","ret1" );
      ((Element)v.get(44)).setAttribute("x","37" );
      ((Element)v.get(44)).setAttribute("y","240" );
      ((Element)v.get(44)).setAttribute("ID","botonContenido" );
      ((Element)v.get(44)).setAttribute("img","retroceder_on" );
      ((Element)v.get(44)).setAttribute("tipo","0" );
      ((Element)v.get(44)).setAttribute("estado","false" );
      ((Element)v.get(44)).setAttribute("alt","" );
      ((Element)v.get(44)).setAttribute("codigo","" );
      ((Element)v.get(44)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 43   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(45)).setAttribute("nombre","ava1" );
      ((Element)v.get(45)).setAttribute("x","52" );
      ((Element)v.get(45)).setAttribute("y","240" );
      ((Element)v.get(45)).setAttribute("ID","botonContenido" );
      ((Element)v.get(45)).setAttribute("img","avanzar_on" );
      ((Element)v.get(45)).setAttribute("tipo","0" );
      ((Element)v.get(45)).setAttribute("estado","false" );
      ((Element)v.get(45)).setAttribute("alt","" );
      ((Element)v.get(45)).setAttribute("codigo","" );
      ((Element)v.get(45)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(43)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:43   */
      /* Termina nodo:22   */

      /* Empieza nodo:46 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(46)).setAttribute("nombre","primera1" );
      ((Element)v.get(46)).setAttribute("x","20" );
      ((Element)v.get(46)).setAttribute("y","240" );
      ((Element)v.get(46)).setAttribute("ID","botonContenido" );
      ((Element)v.get(46)).setAttribute("img","primera_on" );
      ((Element)v.get(46)).setAttribute("tipo","0" );
      ((Element)v.get(46)).setAttribute("estado","false" );
      ((Element)v.get(46)).setAttribute("alt","" );
      ((Element)v.get(46)).setAttribute("codigo","" );
      ((Element)v.get(46)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(4)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 4   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(47)).setAttribute("nombre","separa" );
      ((Element)v.get(47)).setAttribute("x","59" );
      ((Element)v.get(47)).setAttribute("y","243" );
      ((Element)v.get(47)).setAttribute("ID","botonContenido" );
      ((Element)v.get(47)).setAttribute("img","separa_base" );
      ((Element)v.get(47)).setAttribute("tipo","0" );
      ((Element)v.get(47)).setAttribute("estado","false" );
      ((Element)v.get(47)).setAttribute("alt","" );
      ((Element)v.get(47)).setAttribute("codigo","" );
      ((Element)v.get(47)).setAttribute("accion","" );
      ((Element)v.get(4)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(48)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(48)).setAttribute("alto","12" );
      ((Element)v.get(48)).setAttribute("ancho","100%" );
      ((Element)v.get(48)).setAttribute("colorf","" );
      ((Element)v.get(48)).setAttribute("borde","0" );
      ((Element)v.get(48)).setAttribute("imagenf","" );
      ((Element)v.get(48)).setAttribute("repeat","" );
      ((Element)v.get(48)).setAttribute("padding","" );
      ((Element)v.get(48)).setAttribute("visibilidad","visible" );
      ((Element)v.get(48)).setAttribute("contravsb","" );
      ((Element)v.get(48)).setAttribute("x","0" );
      ((Element)v.get(48)).setAttribute("y","267" );
      ((Element)v.get(48)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:4   */


   }

}

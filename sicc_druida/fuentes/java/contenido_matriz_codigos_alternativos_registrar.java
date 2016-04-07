
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_matriz_codigos_alternativos_registrar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_matriz_codigos_alternativos_registrar" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","Registrar Matriz de Códigos Alternativos" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Registrar Matriz de Códigos Alternativos" );
      ((Element)v.get(0)).setAttribute("onload","LoadBar()" );
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
      v.add(doc.createTextNode("\r\r\r  \r\rvar formName = 'frmFormulario.';\rvar formNameSinPunto = 'frmFormulario';\rvar cantNiveles = null; \r\rfunction fLimpiar(){	\r	cargarAccion(\"Matriz seleccionada\",\"N\");\r}\r\r \rfunction LoadBar(){ \r	configurarMenuSecundario(\"frmFormulario\");\r    DrdEnsanchaConMargenDcho('listado1',12);\r	\r    eval (ON_RSZ);  \r\r	focalizaBotonHTML('botonContenido' ,'btnBuscarProductoPrincipal');	\r\r    if( !fMostrarMensajeError() ){\r		if(get(formName + 'accion')==\"Matriz seleccionada\") {	\r			deshabilitarHabilitarBoton('botonContenido','btnBuscarProductoAlternativo','D')			\r		} else {\r			deshabilitarHabilitarBoton('botonContenido','btnBuscarProductoAlternativo','A')			\r		}\r\r		if((get('frmFormulario.hidDatosReemp')==\"N\") || (get('frmFormulario.hidDatosReemp')==\"\")){\r			ocultarLista();\r			btnProxy(1,'0');\r			btnProxy(4,'0');\r		} else if(get('frmFormulario.hidDatosReemp')==\"S\") {\r			mostrarLista();\r			btnProxy(1,'1');\r			btnProxy(4,'1');\r		}\r	}\r}	\r\r\rfunction ocultarLista() {\r	document.all[\"Cplistado1\"].style.visibility='hidden';\r	document.all[\"CpLin1listado1\"].style.visibility='hidden';\r	document.all[\"CpLin2listado1\"].style.visibility='hidden';\r	document.all[\"CpLin3listado1\"].style.visibility='hidden';\r	document.all[\"CpLin4listado1\"].style.visibility='hidden';\r	}\r\r\rfunction mostrarLista() {\r	document.all[\"Cplistado1\"].style.visibility='';\r	document.all[\"CpLin1listado1\"].style.visibility='';\r	document.all[\"CpLin2listado1\"].style.visibility='';\r	document.all[\"CpLin3listado1\"].style.visibility='';\r	document.all[\"CpLin4listado1\"].style.visibility='';\r	}\r\r\rfunction focalizaTab(componente) {  \r	if(componente==1){\r		if(get(formName + 'accion')==\"Matriz seleccionada\") {\r			focalizaBotonHTML('botonContenido' ,'btnBuscarProductoPrincipal');	\r		}else if (get(formName + 'accion')==\"productoPrincipalSeleccionado\" || get(formName + 'accion')==\"grupoProductosSeleccionado\"){	\r			focalizaBotonHTML('botonContenido' ,'btnBuscarProductoAlternativo');\r		}\r	}else if (componente==2){\r		focalizaBotonHTML('botonContenido' ,'btnBuscarProductoPrincipal');	\r	}\r}\r\r\rfunction focalizaTabShift(componente) {    \r	if (componente==1){	\r		if(get(formName + 'accion')==\"Matriz seleccionada\") {\r			focalizaBotonHTML('botonContenido' ,'btnBuscarProductoPrincipal');	\r		}else if (get(formName + 'accion')==\"productoPrincipalSeleccionado\" || get(formName + 'accion')==\"grupoProductosSeleccionado\"){	\r			focalizaBotonHTML('botonContenido' ,'btnBuscarProductoAlternativo');	\r		}\r	}else if (componente==2){	\r		focalizaBotonHTML('botonContenido' ,'btnBuscarProductoPrincipal');	\r	}\r}\r\r\rfunction chequeoCampos(){\r	var bDatosValidados = false;\r	var bChequeaCorrelatividad = false;\r\r	bDatosValidados = chequearDatos();\r		\r	if(bDatosValidados == true) {\r		bChequeaCorrelatividad = chequeaCorrelatividad2();\r		\r		if(bChequeaCorrelatividad == false){ \r			return 0;\r		}else{\r			return new Boolean(true);\r		}\r	}else{\r		return false;\r	}\r}\r\r\rfunction chequearDatos() {	\r	var i = 0;\r	var bBreak = false;			\r	var bCaracteresInvalidos = false;\r	var sContenidoTextBox;\r	var sValorEtiqueta = \"\";\r	\r	while (bBreak == false && i<cantNiveles) {			 \r		sContenidoTextBox = document.getElementById(\"Texto1_\" + i).value;	\r						\r		if(sContenidoTextBox != \"\")  { 					 \r						bCaracteresInvalidos = validaChars(sContenidoTextBox);\r			if(bCaracteresInvalidos == false) {\r				sValorEtiqueta = devuelveEtiqueta(i);\r								GestionarMensaje(\"1253\", sValorEtiqueta, null, null);								\r								document.getElementById(\"Texto1_\" + i).focus();\r				bBreak = true;\r				break;\r			}\r		}else{\r						sValorEtiqueta = devuelveEtiqueta(i);\r			GestionarMensaje(\"1254\", sValorEtiqueta, null, null);\r			document.getElementById(\"Texto1_\" + i).focus();						\r			bBreak = true;\r			break;\r		}\r		i++;\r	}\r\r	if(bBreak == true)  		return false;\r	else\r		return true;\r}\r\r\rfunction validaChars(str) {\r	var c;		\r	permitidos=\"0123456789\";\r	\r	for (var i=0; i<str.length; i++) {\r		c=str.charAt(i);\r		\r		if( permitidos.indexOf(c) == -1 ) \r			return false;\r		else if ( c == ' ' && i == 0 )\r			return false;\r		else if ( c == ' ' && i == (str.length-1) )\r			return false;				\r	}	\r	return true;\r}\r\rfunction devuelveEtiqueta(indice) {\r	   				\r	nombre =  listado1.datos[indice][1];			\r	return nombre;\r}\r\r\rfunction chequeaCorrelatividad() {\r						\r	var arrayNiveles = new Array(cantNiveles);\r	var indicesCajasConTexto = new Array(cantNiveles);  	var indiceBuffer = 0;\r	var cantCajasTextoLlenas = 0 ;\r	var nValor;\r	var bBreak = false;\r	var i = 0;\r			\r							\r	while(i < cantNiveles)	{\r		var nValor = document.getElementById(\"Texto1_\" + i).value; \r		\r		if (nValor != \"\") {\r			indicesCajasConTexto[cantCajasTextoLlenas] = i;\r			cantCajasTextoLlenas++;\r		}\r		i++;\r	}\r\r			\r	if (cantCajasTextoLlenas == 1) { 		nValor = document.getElementById(\"Texto1_\" + indicesCajasConTexto[0] ).value;\r					\r				if (nValor == \"1\") {\r			return true;\r		}else{\r			GestionarMensaje(\"964\", null, null, null); \r						return false;\r		}\r	} \r	\r	i = 0;\r\r				\r	while(i < cantCajasTextoLlenas){\r		arrayNiveles[i] = 0;\r		i++;\r	}\r	\r	i = 0;\r			\r	while( i < cantCajasTextoLlenas ){	\r		nValor = document.getElementById(\"Texto1_\" + indicesCajasConTexto[i]).value;\r				\r		if(( nValor > 0 ) && nValor <= cantCajasTextoLlenas){ 			arrayNiveles[nValor-1]++;\r					}				\r		i++;\r	}\r	\r	\r				\r	i = 0;\r	var vBuffer = 0;\r	\r	while(i < cantCajasTextoLlenas && bBreak == false){\r		vBuffer = arrayNiveles[i];\r												\r		if(vBuffer > 1){	\r			GestionarMensaje(\"966\", (i+1), null, null);\r						bBreak = true;\r		}\r		i++;\r	}\r	return !bBreak;	}\r\r\rfunction chequeaCorrelatividad2(){\r	var arrayNiveles = new Array(cantNiveles);\r	\r	var i=0;\r	var x=0;\r	var duplicado=0;\r	var logica = false;\r	var cantCajasTextoLlenas = 0 ;\r	var valCajasConTexto = new Array(cantNiveles);\r	while(i < cantNiveles){\r		var nValor = document.getElementById(\"Texto1_\" + i).value; \r		\r		if(nValor != \"\"){\r			valCajasConTexto[cantCajasTextoLlenas] = nValor;\r			cantCajasTextoLlenas++;\r		}\r		i++;\r	}\r	i=0;\r	x=0;\r	\r	while (i<cantCajasTextoLlenas){\r		var nValor = document.getElementById(\"Texto1_\" + i).value;\r		\r		while (x<cantCajasTextoLlenas){\r			if(valCajasConTexto[x]==nValor){\r				duplicado ++;\r			}\r			\r			if(duplicado > 1){\r								GestionarMensaje(\"1287\", (nValor), null, null);\r				return false;\r			}	\r			x++;\r		}\r		i++;\r	    x=0;\r		duplicado=0;\r	}\r	return new Boolean(true);		\r}\r\rfunction checkeoNumeroOrden(){\r    var codigos = listado1.codigos();\r    listado1.actualizaDat();\r  	cantNiveles = listado1.datos.length; \r    var todosNrOrden = new Array();\r		for (var i=0; i<codigos.length ; i++){\r                nrOrden = listado1.extraeDato(codigos[i], 2);\r        if(nrOrden==\"\"){\r            GestionarMensaje(\"PRE0050\", null, null, null);\r            return false;\r        }\r        if (existeEnArray(todosNrOrden, nrOrden)){\r            GestionarMensaje(\"PRE0050\", null, null, null);\r            return false;\r        }\r        todosNrOrden[i]=nrOrden;\r    }\r    return true;\r}\r\rfunction existeEnArray(array, valor){\r    for (var i=0; i<array.length;i++){\r        if (array[i] == valor){\r            return true;\r        }\r    }\r    return false;\r}\r\r\rfunction fGuardar(){\r	var codigos = listado1.codigos();\r	listado1.actualizaDat();\r\r	var cadena = \"\";\r	cantNiveles = listado1.datos.length; \r\r	    if(chequearDatos()){\r    		\r		for (var i=0; i<codigos.length ; i++){\r			if( i != 0)\r				cadena = cadena + \"|\";\r\r			cadena = cadena + codigos[i] + \",\";\r\r						codVenta = listado1.extraeDato(codigos[i], 0);\r					\r			if (codVenta==\"\"){\r				codVenta=\" \";\r			}\r\r			cadena = cadena + codVenta + \",\";\r\r						desc = listado1.extraeDato(codigos[i], 1);\r			cadena = cadena + desc + \",\";\r\r						nrOrden = listado1.extraeDato(codigos[i], 2);\r\r			if(nrOrden==\"\"){\r				nrOrden=\" \";\r			}\r				\r			cadena = cadena + nrOrden + \",\";				\r\r						emiteMen = listado1.extraeDato(codigos[i], 3);\r			cadena = cadena + emiteMen;\r					}\r				\r		set(\"frmFormulario.elementosSeleccionados\", cadena);\r		\r		cargarAccion(\"guardarMatriz\", \"S\");\r	  }\r}\r\r\rfunction fBorrar() {\r	var cantElementos = listado1.codSeleccionados();\r\r	if( cantElementos.length == 0 ){\r		GestionarMensaje(\"4\", null, null, null);\r	}else{\r		listado1.eliminarSelecc();\r	}\r    \r	if(listado1.codigos().length==0){       \r		ocultarLista();\r		btnProxy(4,'0');\r		btnProxy(1,'0');\r	}else{\r		btnProxy(4,'1');\r	}\r}\r\r\rfunction cargarAccion(accion, oculto){\r	if(accion == 'buscarProductosAlternativos'){\r		armarCadena();\r	}\r	eval(formNameSinPunto).oculto= oculto;\r	set(formName + \"conectorAction\" ,\"LPMantenimientoMatrizCodigosAlternativos\");\r	set(formName + 'accion', accion);\r	enviaSICC(formNameSinPunto);	\r}\r\r\rfunction armarCadena(){\r	var codigos = listado1.codigos();\r	listado1.actualizaDat();\r\r	var cadena = \"\";\r	cantNiveles = listado1.datos.length; \r\r	\r	for (var i=0; i<codigos.length ; i++){\r		if ( i != 0)\r			cadena = cadena + \"|\";\r\r		cadena = cadena + codigos[i] + \",\";\r\r				codVenta = listado1.extraeDato(codigos[i], 0);\r				\r		if (codVenta==\"\"){\r			codVenta=\" \";\r		}\r\r		cadena = cadena + codVenta + \",\";\r\r				desc = listado1.extraeDato(codigos[i], 1);\r		cadena = cadena + desc + \",\";\r\r				nrOrden = listado1.extraeDato(codigos[i], 2);\r\r		if (nrOrden==\"\"){\r			nrOrden=\" \";\r		}\r			\r		cadena = cadena + nrOrden + \",\";				\r\r				emiteMen = listado1.extraeDato(codigos[i], 3);\r		cadena = cadena + emiteMen;\r			}\r				\r	set(\"frmFormulario.elementosSeleccionados\", cadena);\r\r	}\r\r  \r\r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","accion" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","hidDatosReemp" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","hPais" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","elementosSeleccionados" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","UltimaLP" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","descripcionProducto" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","codigoVenta" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","varExitoInserta" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","oidMatrizCodigoAlternativo" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","oidMatrizFacturacion" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 6   */
      v.add(doc.createElement("table"));
      ((Element)v.get(21)).setAttribute("width","100%" );
      ((Element)v.get(21)).setAttribute("border","0" );
      ((Element)v.get(21)).setAttribute("cellspacing","0" );
      ((Element)v.get(21)).setAttribute("cellpadding","0" );
      ((Element)v.get(6)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).setAttribute("width","12" );
      ((Element)v.get(23)).setAttribute("align","center" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(24)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).setAttribute("width","12" );
      ((Element)v.get(24)).setAttribute("height","12" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:23   */

      /* Empieza nodo:25 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).setAttribute("width","750" );
      ((Element)v.get(22)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(26)).setAttribute("src","b.gif" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:27 / Elemento padre: 22   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).setAttribute("width","12" );
      ((Element)v.get(22)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(28)).setAttribute("width","12" );
      ((Element)v.get(28)).setAttribute("height","1" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */
      /* Termina nodo:22   */

      /* Empieza nodo:29 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(31)).setAttribute("src","b.gif" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:32 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(34)).setAttribute("class","legend" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(35)).setAttribute("nombre","lblProductoPrincipal" );
      ((Element)v.get(35)).setAttribute("alto","13" );
      ((Element)v.get(35)).setAttribute("filas","1" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(35)).setAttribute("id","legend" );
      ((Element)v.get(35)).setAttribute("cod","0014" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 33   */
      v.add(doc.createElement("table"));
      ((Element)v.get(36)).setAttribute("width","100%" );
      ((Element)v.get(36)).setAttribute("border","0" );
      ((Element)v.get(36)).setAttribute("align","center" );
      ((Element)v.get(36)).setAttribute("cellspacing","0" );
      ((Element)v.get(36)).setAttribute("cellpadding","0" );
      ((Element)v.get(33)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("table"));
      ((Element)v.get(39)).setAttribute("width","600" );
      ((Element)v.get(39)).setAttribute("border","0" );
      ((Element)v.get(39)).setAttribute("align","left" );
      ((Element)v.get(39)).setAttribute("cellspacing","0" );
      ((Element)v.get(39)).setAttribute("cellpadding","0" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).setAttribute("colspan","4" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).setAttribute("width","8" );
      ((Element)v.get(42)).setAttribute("height","8" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:43 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(45)).setAttribute("width","8" );
      ((Element)v.get(45)).setAttribute("height","8" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(47)).setAttribute("nombre","lblCodigoVenta" );
      ((Element)v.get(47)).setAttribute("alto","13" );
      ((Element)v.get(47)).setAttribute("filas","1" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(47)).setAttribute("id","datosTitle" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(47)).setAttribute("cod","336" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","25" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(51)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(51)).setAttribute("alto","13" );
      ((Element)v.get(51)).setAttribute("filas","1" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(51)).setAttribute("id","datosTitle" );
      ((Element)v.get(51)).setAttribute("cod","9" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 43   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("width","100%" );
      ((Element)v.get(43)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","8" );
      ((Element)v.get(53)).setAttribute("height","8" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */
      /* Termina nodo:43   */

      /* Empieza nodo:54 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","8" );
      ((Element)v.get(56)).setAttribute("height","8" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(58)).setAttribute("nombre","lblCodigoVentaXX" );
      ((Element)v.get(58)).setAttribute("alto","13" );
      ((Element)v.get(58)).setAttribute("filas","1" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(58)).setAttribute("id","datosCampos" );
      ((Element)v.get(58)).setAttribute("codigo","" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","25" );
      ((Element)v.get(60)).setAttribute("height","8" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(62)).setAttribute("nombre","lblDescripcionXX" );
      ((Element)v.get(62)).setAttribute("alto","13" );
      ((Element)v.get(62)).setAttribute("filas","1" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(62)).setAttribute("id","datosCampos" );
      ((Element)v.get(62)).setAttribute("codigo","" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("width","100%" );
      ((Element)v.get(54)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","8" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:54   */

      /* Empieza nodo:65 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("colspan","4" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","8" );
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:68 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:29   */

      /* Empieza nodo:70 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("table"));
      ((Element)v.get(75)).setAttribute("width","100%" );
      ((Element)v.get(75)).setAttribute("border","0" );
      ((Element)v.get(75)).setAttribute("align","center" );
      ((Element)v.get(75)).setAttribute("cellspacing","0" );
      ((Element)v.get(75)).setAttribute("cellpadding","0" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("class","botonera" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(78)).setAttribute("nombre","btnBuscarProductoPrincipal" );
      ((Element)v.get(78)).setAttribute("ID","botonContenido" );
      ((Element)v.get(78)).setAttribute("tipo","html" );
      ((Element)v.get(78)).setAttribute("accion","cargarAccion('buscarProductoPrincipal','N');" );
      ((Element)v.get(78)).setAttribute("estado","false" );
      ((Element)v.get(78)).setAttribute("cod","431" );
      ((Element)v.get(78)).setAttribute("ontab","focalizaTab(1);" );
      ((Element)v.get(78)).setAttribute("onshtab","focalizaTabShift(1);" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 77   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(79)).setAttribute("nombre","btnBuscarProductoAlternativo" );
      ((Element)v.get(79)).setAttribute("ID","botonContenido" );
      ((Element)v.get(79)).setAttribute("tipo","html" );
      ((Element)v.get(79)).setAttribute("accion","cargarAccion('buscarProductosAlternativos','N');" );
      ((Element)v.get(79)).setAttribute("estado","false" );
      ((Element)v.get(79)).setAttribute("cod","432" );
      ((Element)v.get(79)).setAttribute("ontab","focalizaTab(2);" );
      ((Element)v.get(79)).setAttribute("onshtab","focalizaTabShift(2);" );
      ((Element)v.get(77)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:80 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).setAttribute("width","8" );
      ((Element)v.get(81)).setAttribute("height","12" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:70   */

      /* Empieza nodo:82 / Elemento padre: 21   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(21)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("width","12" );
      ((Element)v.get(83)).setAttribute("align","center" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","12" );
      ((Element)v.get(84)).setAttribute("height","12" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).setAttribute("width","756" );
      ((Element)v.get(82)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).setAttribute("width","12" );
      ((Element)v.get(82)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","12" );
      ((Element)v.get(88)).setAttribute("height","1" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:82   */
      /* Termina nodo:21   */

      /* Empieza nodo:89 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(89)).setAttribute("nombre","listado1" );
      ((Element)v.get(89)).setAttribute("ancho","803" );
      ((Element)v.get(89)).setAttribute("alto","299" );
      ((Element)v.get(89)).setAttribute("x","12" );
      ((Element)v.get(89)).setAttribute("y","117" );
      ((Element)v.get(89)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(89)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(90)).setAttribute("precarga","S" );
      ((Element)v.get(90)).setAttribute("conROver","S" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(91)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(91)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(91)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(91)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 90   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(92)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(92)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(92)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(92)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(90)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 90   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(93)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(93)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(90)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:90   */

      /* Empieza nodo:94 / Elemento padre: 89   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(89)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(95)).setAttribute("borde","1" );
      ((Element)v.get(95)).setAttribute("horizDatos","1" );
      ((Element)v.get(95)).setAttribute("horizCabecera","1" );
      ((Element)v.get(95)).setAttribute("vertical","1" );
      ((Element)v.get(95)).setAttribute("horizTitulo","1" );
      ((Element)v.get(95)).setAttribute("horizBase","1" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 94   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(96)).setAttribute("borde","#999999" );
      ((Element)v.get(96)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(96)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(96)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(96)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(96)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(96)).setAttribute("horizBase","#999999" );
      ((Element)v.get(94)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:94   */

      /* Empieza nodo:97 / Elemento padre: 89   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(97)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(97)).setAttribute("alto","22" );
      ((Element)v.get(97)).setAttribute("imgFondo","" );
      ((Element)v.get(97)).setAttribute("cod","430" );
      ((Element)v.get(97)).setAttribute("ID","datosTitle" );
      ((Element)v.get(89)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 89   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(98)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(98)).setAttribute("alto","22" );
      ((Element)v.get(98)).setAttribute("imgFondo","" );
      ((Element)v.get(89)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 89   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(99)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(99)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(99)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(99)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(99)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(99)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(89)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(100)).setAttribute("ancho","100" );
      ((Element)v.get(100)).setAttribute("minimizable","S" );
      ((Element)v.get(100)).setAttribute("minimizada","N" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(101)).setAttribute("ancho","200" );
      ((Element)v.get(101)).setAttribute("minimizable","S" );
      ((Element)v.get(101)).setAttribute("minimizada","N" );
      ((Element)v.get(99)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(102)).setAttribute("ancho","80" );
      ((Element)v.get(102)).setAttribute("minimizable","S" );
      ((Element)v.get(102)).setAttribute("minimizada","N" );
      ((Element)v.get(99)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 99   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(103)).setAttribute("ancho","90" );
      ((Element)v.get(103)).setAttribute("minimizable","S" );
      ((Element)v.get(103)).setAttribute("minimizada","N" );
      ((Element)v.get(99)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:99   */

      /* Empieza nodo:104 / Elemento padre: 89   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(104)).setAttribute("alto","20" );
      ((Element)v.get(104)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(104)).setAttribute("imgFondo","" );
      ((Element)v.get(104)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(89)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(105)).setAttribute("colFondo","" );
      ((Element)v.get(105)).setAttribute("ID","EstCab" );
      ((Element)v.get(105)).setAttribute("align","center" );
      ((Element)v.get(105)).setAttribute("cod","336" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Elemento padre:105 / Elemento actual: 106   */
      v.add(doc.createTextNode("Código venta"));
      ((Element)v.get(105)).appendChild((Text)v.get(106));

      /* Termina nodo Texto:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(107)).setAttribute("colFondo","" );
      ((Element)v.get(107)).setAttribute("ID","EstCab" );
      ((Element)v.get(107)).setAttribute("cod","9" );
      ((Element)v.get(104)).appendChild((Element)v.get(107));

      /* Elemento padre:107 / Elemento actual: 108   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(107)).appendChild((Text)v.get(108));

      /* Termina nodo Texto:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 104   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(109)).setAttribute("colFondo","" );
      ((Element)v.get(109)).setAttribute("ID","EstCab" );
      ((Element)v.get(109)).setAttribute("cod","433" );
      ((Element)v.get(104)).appendChild((Element)v.get(109));

      /* Elemento padre:109 / Elemento actual: 110   */
      v.add(doc.createTextNode("Nº de orden"));
      ((Element)v.get(109)).appendChild((Text)v.get(110));

      /* Termina nodo Texto:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 104   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(111)).setAttribute("colFondo","" );
      ((Element)v.get(111)).setAttribute("ID","EstCab" );
      ((Element)v.get(111)).setAttribute("cod","434" );
      ((Element)v.get(104)).appendChild((Element)v.get(111));

      /* Elemento padre:111 / Elemento actual: 112   */
      v.add(doc.createTextNode("Emitir mensaje"));
      ((Element)v.get(111)).appendChild((Text)v.get(112));

      /* Termina nodo Texto:112   */
      /* Termina nodo:111   */
      /* Termina nodo:104   */

      /* Empieza nodo:113 / Elemento padre: 89   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(113)).setAttribute("alto","22" );
      ((Element)v.get(113)).setAttribute("accion","" );
      ((Element)v.get(113)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(113)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(113)).setAttribute("maxSel","-1" );
      ((Element)v.get(113)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(113)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(113)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(113)).setAttribute("onLoad","" );
      ((Element)v.get(113)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(89)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(114)).setAttribute("tipo","texto" );
      ((Element)v.get(114)).setAttribute("ID","EstDat" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */

      /* Empieza nodo:115 / Elemento padre: 113   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(115)).setAttribute("tipo","texto" );
      ((Element)v.get(115)).setAttribute("ID","EstDat2" );
      ((Element)v.get(113)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */

      /* Empieza nodo:116 / Elemento padre: 113   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(116)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(116)).setAttribute("nombre","Texto1" );
      ((Element)v.get(116)).setAttribute("size","3" );
      ((Element)v.get(116)).setAttribute("max","2" );
      ((Element)v.get(116)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(116)).setAttribute("ID","EstDat" );
      ((Element)v.get(113)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */

      /* Empieza nodo:117 / Elemento padre: 113   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(117)).setAttribute("tipo","checkbox" );
      ((Element)v.get(117)).setAttribute("nombre","cbx1" );
      ((Element)v.get(117)).setAttribute("ID","EstDat2" );
      ((Element)v.get(113)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:113   */

      /* Empieza nodo:118 / Elemento padre: 89   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(89)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:89   */

      /* Empieza nodo:119 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(119)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(119)).setAttribute("alto","18" );
      ((Element)v.get(119)).setAttribute("ancho","100%" );
      ((Element)v.get(119)).setAttribute("colorf","" );
      ((Element)v.get(119)).setAttribute("borde","0" );
      ((Element)v.get(119)).setAttribute("imagenf","" );
      ((Element)v.get(119)).setAttribute("repeat","" );
      ((Element)v.get(119)).setAttribute("padding","" );
      ((Element)v.get(119)).setAttribute("visibilidad","visible" );
      ((Element)v.get(119)).setAttribute("contravsb","" );
      ((Element)v.get(119)).setAttribute("x","0" );
      ((Element)v.get(119)).setAttribute("y","416" );
      ((Element)v.get(119)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:6   */


   }

}

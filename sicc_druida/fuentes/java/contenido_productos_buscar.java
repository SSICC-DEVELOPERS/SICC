
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_productos_buscar  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         

      getXML450(doc);
         

      getXML540(doc);
         

      getXML630(doc);
         

      getXML720(doc);
         

      getXML810(doc);
         

      getXML900(doc);
         

      getXML990(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_productos_buscar" );
      ((Element)v.get(0)).setAttribute("cod","0644" );
      ((Element)v.get(0)).setAttribute("titulo","Ingresar valores de descuento" );
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
      v.add(doc.createTextNode("\r   \r\r  var listasVisibles=\"N\";\r  var btnEliminarHab=\"N\";\r\r  var uniNegChg = \"N\";\r    \r  var unidadNegocioSel='';\r  var marcaSel = '';\r  \r\r  function onLoadPag()\r  {\r\r        fMostrarMensajeError();\r		configurarMenuSecundario('formulario');\r		\r        ocultarListado();\r        eval (ON_RSZ);  \r\r		 deshabilitarHabilitarBoton('botonContenido','btnEliminar','D');\r  	     deshabilitarHabilitarBoton('botonContenido','btnAceptar','D');\r         \r		 focaliza(\"formulario.txtCodProducto\");\r   }\r\r\r    function mostrarListado()\r	 {\r        DrdEnsanchaConMargenDcho('listado1',12);\r        document.all[\"Cplistado1\"].style.visibility='';\r        document.all[\"CpLin1listado1\"].style.visibility='';\r        document.all[\"CpLin2listado1\"].style.visibility='';\r        document.all[\"CpLin3listado1\"].style.visibility='';\r        document.all[\"CpLin4listado1\"].style.visibility='';\r        document.all[\"separaDiv\"].style.visibility='';\r        document.all[\"primera1Div\"].style.visibility='';\r        document.all[\"ret1Div\"].style.visibility='';\r        document.all[\"ava1Div\"].style.visibility='';\r        document.all[\"btnAnadirDiv\"].style.visibility='';\r    \r        DrdEnsanchaConMargenDcho('listado2',12);\r        document.all[\"Cplistado2\"].style.visibility='';\r        document.all[\"CpLin1listado2\"].style.visibility='';\r        document.all[\"CpLin2listado2\"].style.visibility='';\r        document.all[\"CpLin3listado2\"].style.visibility='';\r        document.all[\"CpLin4listado2\"].style.visibility='';\r        document.all[\"separa2Div\"].style.visibility='hidden';\r        document.all[\"primera2Div\"].style.visibility='hidden';\r        document.all[\"ret2Div\"].style.visibility='hidden';\r        document.all[\"ava2Div\"].style.visibility='hidden';\r        document.all[\"btnEliminarDiv\"].style.visibility='';\r        document.all[\"btnAceptarDiv\"].style.visibility='';\r        listasVisibles=\"S\";\r    }\r\r    function ocultarListado(){\r        DrdEnsanchaConMargenDcho('listado1',12);\r        document.all[\"Cplistado1\"].style.visibility='hidden';\r        document.all[\"CpLin1listado1\"].style.visibility='hidden';\r        document.all[\"CpLin2listado1\"].style.visibility='hidden';\r        document.all[\"CpLin3listado1\"].style.visibility='hidden';\r        document.all[\"CpLin4listado1\"].style.visibility='hidden';\r        document.all[\"separaDiv\"].style.visibility='hidden';\r        document.all[\"primera1Div\"].style.visibility='hidden';\r        document.all[\"ret1Div\"].style.visibility='hidden';\r        document.all[\"ava1Div\"].style.visibility='hidden';\r        document.all[\"btnAnadirDiv\"].style.visibility='hidden';\r    \r        DrdEnsanchaConMargenDcho('listado2',12);\r        document.all[\"Cplistado2\"].style.visibility='hidden';\r        document.all[\"CpLin1listado2\"].style.visibility='hidden';\r        document.all[\"CpLin2listado2\"].style.visibility='hidden';\r        document.all[\"CpLin3listado2\"].style.visibility='hidden';\r        document.all[\"CpLin4listado2\"].style.visibility='hidden';\r        document.all[\"separa2Div\"].style.visibility='hidden';\r        document.all[\"primera2Div\"].style.visibility='hidden';\r        document.all[\"ret2Div\"].style.visibility='hidden';\r        document.all[\"ava2Div\"].style.visibility='hidden';\r        document.all[\"btnEliminarDiv\"].style.visibility='hidden';\r        document.all[\"btnAceptarDiv\"].style.visibility='hidden';\r\r        listasVisibles=\"N\";\r    }\r\r    function aniadir(){\r        var cant = listado1.numSelecc();\r  		  var toAdd = \"\";\r		  var codigo = \"\";\r\r		if ( cant == 0 ){\r				GestionarMensaje(\"8\", null,null,null);\r		}else{\r				codigo = listado1.codSeleccionados();\r				for(var a = 0; a < codigo.length ; a++)\r				{\r										toAdd = listado1.extraeDato(codigo[a], 0);\r										toAdd = toAdd + \"|\" + listado1.extraeDato(codigo[a], 1);\r					\r					pasaListaTemporal(codigo[a], toAdd);\r\r					                    deshabilitarHabilitarBoton('botonContenido','btnEliminar','A');\r                    deshabilitarHabilitarBoton('botonContenido','btnAceptar','A');\r                    deshabilitarHabilitarBoton('botonContenido','btnAnadir','A');\r                    btnEliminarHab = \"S\";\r				}\r		}\r\r		deselecciona(listado1.codigos(), listado1.codSeleccionados());\r    }\r\r\r    function pasaListaTemporal(codigo, datos){\r        var codigosTemporal = listado2.codigos();\r        var match = rowMatch(codigo, codigosTemporal);\r        if (match){\r                    }else{\r            datos = codigo + \"|\" + datos;              var newRow = new Array();\r            newRow = datos.split(\"|\");\r            listado2.insertar(newRow);\r        }\r    }\r\r	function rowMatch(codigo, codigosTemporal){\r        var flag = false;\r        var i = 0;\r        while ( (i < codigosTemporal.length) && (flag == false) ){\r            if ( codigo == codigosTemporal[i] )\r                flag = true;	\r            i++;\r        }\r        return flag;\r    }\r\r\r	function deselecciona(codigos, codSeleccionados){\r\r		for(var i = 0; i < codSeleccionados.length ; i++){\r			for(var a = 0; a < codigos.length ; a++){\r				if(codigos[a] == codSeleccionados[i]){\r					listado1.deselecciona(a); \r					break;\r				}\r			}\r		}\r	}\r\r\r    function eliminar(){\r        var cantElementos = listado2.codSeleccionados();\r			if ( cantElementos.length == 0 ){\r				GestionarMensaje(\"8\", null, null, null);\r			}else{\r				listado2.eliminarSelecc();\r				if (listado2.datos.length == 0) 				{\r						 deshabilitarHabilitarBoton('botonContenido','btnEliminar','D');\r						 deshabilitarHabilitarBoton('botonContenido','btnAceptar','D');\r                                                  btnEliminarHab = \"N\";\r				}\r		}\r    }\r\r\r    function seleccionar(){\r        var cantElementos = listado2.codigos();\r		if ( cantElementos.length == 0 ){\r			GestionarMensaje(\"8\", null,null,null);\r			return;\r		}\r	\r		var arr = new Array();\r		var vFilaCompleta = tomarFilas();\r		arr[0] = vFilaCompleta;\r		\r        arr[1] = marcaSel;\r        arr[2] = unidadNegocioSel;\r        \r		returnValue = arr;\r		close();\r   }\r\r    function tomarFilas(){\r        var codigo = listado2.codigos();\r        var toAdd = \"\";\r        var total = \"\";\r        for(var a = 0; a < codigo.length ; a++){\r            toAdd = codigo[a];\r            toAdd = toAdd + \"|\" + listado2.extraeDato (codigo[a], 0);\r            toAdd = toAdd + \"|\" + listado2.extraeDato (codigo[a], 1);\r            total = total + \"$\" + toAdd;\r        }		\r        return total;\r    }\r\r\r    function accionBuscar(){\r       \r        configurarPaginado(mipgndo, 'DTOBuscarProductosDTO', 'ConectorBuscarProductosDTO', \r		'es.indra.sicc.dtos.dto.DTOEBuscarProductosDTO', armarArray());\r    }\r\r\r    function armarArray(){\r        var vArray = new Array();\r		var i=0;\r        vArray[i] = new Array('oidIdioma',get('formulario.hidIdioma'));\r		i++;\r        \r		if (get('formulario.txtCodProducto')!=''){\r			vArray[i] = new Array('codigoProducto',  get('formulario.txtCodProducto'));\r			i++;\r		}\r		\r		if (get('formulario.txtDescripcionProducto')!=''){\r			vArray[i] = new Array('descripcionProducto', get('formulario.txtDescripcionProducto'));\r			i++;\r		}\r		\r		if (get('formulario.cbMarca','V')!=''){\r			vArray[i] = new Array('oidMarca', 			 get('formulario.cbMarca'));\r			i++;\r            marcaSel= get('formulario.cbMarca','V');\r		}\r\r		if (get('formulario.cbUnidadNegocio','V')!=''){\r			vArray[i] = new Array('oidUnidadNegocio', 	 get('formulario.cbUnidadNegocio'));\r			i++;\r\r            if (unidadNegocioSel != get('formulario.cbUnidadNegocio','V') )\r                        uniNegChg = \"S\";\r                        \r                unidadNegocioSel = get('formulario.cbUnidadNegocio','V');\r		}\r        else\r            unidadNegocioSel = '';\r\r		if (get('formulario.cbNegocio','V')!=''){\r			vArray[i] = new Array('oidNegocio', 		 get('formulario.cbNegocio'));\r			i++;           \r		}\r        \r		if (get('formulario.cbSupergenerico','V')!=''){\r			vArray[i] = new Array('oidSuperGenerico', 	 get('formulario.cbSupergenerico'));\r			i++;\r             \r        }\r        \r		if (get('formulario.cbGenerico','V')!=''){\r			vArray[i] = new Array('oidGenerico', 		 get('formulario.cbGenerico'));\r			i++;\r        }\r            \r        return vArray;\r    }\r\r\r	function muestraLista(ultima, rowset) {\r\r         var tamano = rowset.length;\r\r         if (tamano > 0) \r			{\r				 listasVisibles= \"S\";\r				 deshabilitarHabilitarBoton('botonContenido','btnAnadir','A');\r				 mostrarListado();			\r				 return true;\r		    } else \r			 {\r										 deshabilitarHabilitarBoton('botonContenido','btnAnadir','D');\r					 if(listasVisibles==\"N\") \r						ocultarListado();\r\r					return false;\r  		    }\r    }\r\r	function fLimpiar()\r    {\r        var nuevos_datos = new Array();\r        listado2.setDatos(nuevos_datos);\r        ocultarListado();\r\r        focaliza(\"formulario.txtCodProducto\");\r    }\r\r\r	function focalizaTab(){  \r		if(listasVisibles==\"S\"){\r		   focalizaBotonHTML_XY('btnAnadir');\r		}else{\r		   focaliza(\"formulario.txtCodProducto\");\r		}\r    }\r\r	function focalizaShTab(){  \r\r		if(listasVisibles==\"S\"){\r            if(listado2.datos.length >  0)\r                focalizaBotonHTML_XY('btnAceptar');\r            else\r                focalizaBotonHTML_XY('btnAnadir');\r		}else{\r		   focalizaBotonHTML('botonContenido','btnBuscar');\r		}\r    }\r\r	function fVolver(){	\r		window.close();\r	}\r   \r    function focalizaParaAniadirTab()\r    {\r        if(listado2.datos.length >  0)\r	         focalizaBotonHTML('botonContenido','btnEliminar');\r        else\r            focaliza('formulario.txtCodProducto');	   \r\r    }\r   \r   \r"));
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
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

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
      ((Element)v.get(9)).setAttribute("nombre","hidIdioma" );
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
      ((Element)v.get(12)).setAttribute("nombre","hidProductosSeleccionados" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","oidMarcaCorporativa" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(14)).setAttribute("nombre","capa1" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("table"));
      ((Element)v.get(15)).setAttribute("width","100%" );
      ((Element)v.get(15)).setAttribute("border","0" );
      ((Element)v.get(15)).setAttribute("cellspacing","0" );
      ((Element)v.get(15)).setAttribute("cellpadding","0" );
      ((Element)v.get(14)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(15)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("td"));
      ((Element)v.get(17)).setAttribute("width","12" );
      ((Element)v.get(17)).setAttribute("align","center" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(18)).setAttribute("src","b.gif" );
      ((Element)v.get(18)).setAttribute("width","12" );
      ((Element)v.get(18)).setAttribute("height","12" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */
      /* Termina nodo:17   */

      /* Empieza nodo:19 / Elemento padre: 16   */
      v.add(doc.createElement("td"));
      ((Element)v.get(19)).setAttribute("width","750" );
      ((Element)v.get(16)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(20)).setAttribute("src","b.gif" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */
      /* Termina nodo:19   */

      /* Empieza nodo:21 / Elemento padre: 16   */
      v.add(doc.createElement("td"));
      ((Element)v.get(21)).setAttribute("width","12" );
      ((Element)v.get(16)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(22)).setAttribute("src","b.gif" );
      ((Element)v.get(22)).setAttribute("width","12" );
      ((Element)v.get(22)).setAttribute("height","1" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */
      /* Termina nodo:21   */
      /* Termina nodo:16   */

      /* Empieza nodo:23 / Elemento padre: 15   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(15)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:26 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(28)).setAttribute("class","legend" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(29)).setAttribute("nombre","lblCriteriosBuscqueda" );
      ((Element)v.get(29)).setAttribute("alto","13" );
      ((Element)v.get(29)).setAttribute("filas","1" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(29)).setAttribute("cod","0075" );
      ((Element)v.get(29)).setAttribute("id","legend" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:30 / Elemento padre: 27   */
      v.add(doc.createElement("table"));
      ((Element)v.get(30)).setAttribute("width","100%" );
      ((Element)v.get(30)).setAttribute("border","0" );
      ((Element)v.get(30)).setAttribute("align","center" );
      ((Element)v.get(30)).setAttribute("cellspacing","0" );
      ((Element)v.get(30)).setAttribute("cellpadding","0" );
      ((Element)v.get(27)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("table"));
      ((Element)v.get(33)).setAttribute("width","650" );
      ((Element)v.get(33)).setAttribute("border","0" );
      ((Element)v.get(33)).setAttribute("align","left" );
      ((Element)v.get(33)).setAttribute("cellspacing","0" );
      ((Element)v.get(33)).setAttribute("cellpadding","0" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).setAttribute("colspan","4" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(36)).setAttribute("src","b.gif" );
      ((Element)v.get(36)).setAttribute("width","8" );
      ((Element)v.get(36)).setAttribute("height","8" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:37 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).setAttribute("width","8" );
      ((Element)v.get(39)).setAttribute("height","8" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(41)).setAttribute("nombre","lblCodProducto" );
      ((Element)v.get(41)).setAttribute("alto","13" );
      ((Element)v.get(41)).setAttribute("filas","1" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(41)).setAttribute("id","datosTitle" );
      ((Element)v.get(41)).setAttribute("cod","337" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","25" );
      ((Element)v.get(43)).setAttribute("height","8" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(45)).setAttribute("nombre","lblDescripcionProducto" );
      ((Element)v.get(45)).setAttribute("alto","13" );
      ((Element)v.get(45)).setAttribute("filas","1" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(45)).setAttribute("id","datosTitle" );
      ((Element)v.get(45)).setAttribute("cod","338" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","25" );
      ((Element)v.get(47)).setAttribute("height","8" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(49)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(49)).setAttribute("alto","13" );
      ((Element)v.get(49)).setAttribute("filas","1" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(49)).setAttribute("id","datosTitle" );
      ((Element)v.get(49)).setAttribute("cod","6" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).setAttribute("width","100%" );
      ((Element)v.get(50)).setAttribute("colspan","2" );
      ((Element)v.get(37)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","8" );
      ((Element)v.get(51)).setAttribute("height","8" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:37   */

      /* Empieza nodo:52 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","8" );
      ((Element)v.get(54)).setAttribute("height","8" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(56)).setAttribute("nombre","txtCodProducto" );
      ((Element)v.get(56)).setAttribute("id","datosCampos" );
      ((Element)v.get(56)).setAttribute("max","20" );
      ((Element)v.get(56)).setAttribute("tipo","" );
      ((Element)v.get(56)).setAttribute("onchange","" );
      ((Element)v.get(56)).setAttribute("req","N" );
      ((Element)v.get(56)).setAttribute("size","20" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(56)).setAttribute("validacion","" );
      ((Element)v.get(56)).setAttribute("onshtab","focalizaShTab();" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","25" );
      ((Element)v.get(58)).setAttribute("height","8" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(60)).setAttribute("nombre","txtDescripcionProducto" );
      ((Element)v.get(60)).setAttribute("id","datosCampos" );
      ((Element)v.get(60)).setAttribute("max","50" );
      ((Element)v.get(60)).setAttribute("tipo","" );
      ((Element)v.get(60)).setAttribute("onchange","" );
      ((Element)v.get(60)).setAttribute("req","N" );
      ((Element)v.get(60)).setAttribute("size","50" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(60)).setAttribute("validacion","" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","25" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(52)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(64)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(64)).setAttribute("id","datosCampos" );
      ((Element)v.get(64)).setAttribute("size","1" );
      ((Element)v.get(64)).setAttribute("multiple","N" );
      ((Element)v.get(64)).setAttribute("req","N" );
      ((Element)v.get(64)).setAttribute("valorinicial","" );
      ((Element)v.get(64)).setAttribute("textoinicial","" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:66 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("width","100%" );
      ((Element)v.get(52)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","8" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:52   */

      /* Empieza nodo:68 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("colspan","4" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","8" );
      ((Element)v.get(70)).setAttribute("height","8" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:33   */
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:71 / Elemento padre: 30   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(30)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("table"));
      ((Element)v.get(73)).setAttribute("width","650" );
      ((Element)v.get(73)).setAttribute("border","0" );
      ((Element)v.get(73)).setAttribute("align","left" );
      ((Element)v.get(73)).setAttribute("cellspacing","0" );
      ((Element)v.get(73)).setAttribute("cellpadding","0" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","8" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(78)).setAttribute("nombre","lblUnidadNegocio" );
      ((Element)v.get(78)).setAttribute("alto","13" );
      ((Element)v.get(78)).setAttribute("filas","1" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(78)).setAttribute("id","datosTitle" );
      ((Element)v.get(78)).setAttribute("cod","587" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","25" );
      ((Element)v.get(80)).setAttribute("height","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(82)).setAttribute("nombre","lblNegocio" );
      ((Element)v.get(82)).setAttribute("alto","13" );
      ((Element)v.get(82)).setAttribute("filas","1" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(82)).setAttribute("id","datosTitle" );
      ((Element)v.get(82)).setAttribute("cod","588" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("width","100%" );
      ((Element)v.get(83)).setAttribute("colspan","2" );
      ((Element)v.get(74)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","8" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:74   */

      /* Empieza nodo:85 / Elemento padre: 73   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(73)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).setAttribute("width","8" );
      ((Element)v.get(87)).setAttribute("height","8" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(85)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(89)).setAttribute("nombre","cbUnidadNegocio" );
      ((Element)v.get(89)).setAttribute("id","datosCampos" );
      ((Element)v.get(89)).setAttribute("size","1" );
      ((Element)v.get(89)).setAttribute("multiple","N" );
      ((Element)v.get(89)).setAttribute("req","N" );
      ((Element)v.get(89)).setAttribute("valorinicial","" );
      ((Element)v.get(89)).setAttribute("textoinicial","" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("ROWSET"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:91 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","25" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(85)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(94)).setAttribute("nombre","cbNegocio" );
      ((Element)v.get(94)).setAttribute("id","datosCampos" );
      ((Element)v.get(94)).setAttribute("size","1" );
      ((Element)v.get(94)).setAttribute("multiple","N" );
      ((Element)v.get(94)).setAttribute("req","N" );
      ((Element)v.get(94)).setAttribute("valorinicial","" );
      ((Element)v.get(94)).setAttribute("textoinicial","" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:96 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("width","100%" );
      ((Element)v.get(85)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","8" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:85   */

      /* Empieza nodo:98 / Elemento padre: 73   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(73)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("colspan","4" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","8" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:101 / Elemento padre: 30   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(30)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("table"));
      ((Element)v.get(103)).setAttribute("width","650" );
      ((Element)v.get(103)).setAttribute("border","0" );
      ((Element)v.get(103)).setAttribute("align","left" );
      ((Element)v.get(103)).setAttribute("cellspacing","0" );
      ((Element)v.get(103)).setAttribute("cellpadding","0" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","8" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(108)).setAttribute("nombre","lblSupergenerico" );
      ((Element)v.get(108)).setAttribute("alto","13" );
      ((Element)v.get(108)).setAttribute("filas","1" );
      ((Element)v.get(108)).setAttribute("valor","" );
      ((Element)v.get(108)).setAttribute("id","datosTitle" );
      ((Element)v.get(108)).setAttribute("cod","590" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","25" );
      ((Element)v.get(110)).setAttribute("height","8" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(112)).setAttribute("nombre","lblGenerico" );
      ((Element)v.get(112)).setAttribute("alto","13" );
      ((Element)v.get(112)).setAttribute("filas","1" );
      ((Element)v.get(112)).setAttribute("valor","" );
      ((Element)v.get(112)).setAttribute("id","datosTitle" );
      ((Element)v.get(112)).setAttribute("cod","589" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("width","100%" );
      ((Element)v.get(113)).setAttribute("colspan","2" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(104)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","8" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:104   */

      /* Empieza nodo:115 / Elemento padre: 103   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(103)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","8" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(115)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(119)).setAttribute("nombre","cbSupergenerico" );
      ((Element)v.get(119)).setAttribute("id","datosCampos" );
      ((Element)v.get(119)).setAttribute("size","1" );
      ((Element)v.get(119)).setAttribute("multiple","N" );
      ((Element)v.get(119)).setAttribute("req","N" );
      ((Element)v.get(119)).setAttribute("valorinicial","" );
      ((Element)v.get(119)).setAttribute("textoinicial","" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:121 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","25" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(115)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(124)).setAttribute("nombre","cbGenerico" );
      ((Element)v.get(124)).setAttribute("id","datosCampos" );
      ((Element)v.get(124)).setAttribute("size","1" );
      ((Element)v.get(124)).setAttribute("multiple","N" );
      ((Element)v.get(124)).setAttribute("req","N" );
      ((Element)v.get(124)).setAttribute("valorinicial","" );
      ((Element)v.get(124)).setAttribute("textoinicial","" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:126 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).setAttribute("width","100%" );
      ((Element)v.get(115)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","8" );
      ((Element)v.get(127)).setAttribute("height","8" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:115   */

      /* Empieza nodo:128 / Elemento padre: 103   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(103)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("colspan","4" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","8" );
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:30   */
      /* Termina nodo:27   */
      /* Termina nodo:26   */

      /* Empieza nodo:131 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(132)).setAttribute("width","8" );
      ((Element)v.get(132)).setAttribute("height","12" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:23   */

      /* Empieza nodo:133 / Elemento padre: 15   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(15)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("table"));
      ((Element)v.get(138)).setAttribute("width","100%" );
      ((Element)v.get(138)).setAttribute("border","0" );
      ((Element)v.get(138)).setAttribute("align","center" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(138)).setAttribute("cellspacing","0" );
      ((Element)v.get(138)).setAttribute("cellpadding","0" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("class","botonera" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(141)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(141)).setAttribute("ID","botonContenido" );
      ((Element)v.get(141)).setAttribute("tipo","html" );
      ((Element)v.get(141)).setAttribute("accion","accionBuscar();" );
      ((Element)v.get(141)).setAttribute("ontab","focalizaTab();" );
      ((Element)v.get(141)).setAttribute("estado","false" );
      ((Element)v.get(141)).setAttribute("cod","1" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:142 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
      ((Element)v.get(143)).setAttribute("width","8" );
      ((Element)v.get(143)).setAttribute("height","12" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:133   */

      /* Empieza nodo:144 / Elemento padre: 15   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(15)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).setAttribute("width","12" );
      ((Element)v.get(145)).setAttribute("align","center" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","12" );
      ((Element)v.get(146)).setAttribute("height","24" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:147 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).setAttribute("width","750" );
      ((Element)v.get(144)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).setAttribute("width","12" );
      ((Element)v.get(144)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","12" );
      ((Element)v.get(150)).setAttribute("height","24" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:144   */
      /* Termina nodo:15   */
      /* Termina nodo:14   */

      /* Empieza nodo:151 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(151)).setAttribute("nombre","listado1" );
      ((Element)v.get(151)).setAttribute("ancho","654" );
      ((Element)v.get(151)).setAttribute("alto","301" );
      ((Element)v.get(151)).setAttribute("x","12" );
      ((Element)v.get(151)).setAttribute("y","202" );
      ((Element)v.get(151)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(151)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(152)).setAttribute("precarga","S" );
      ((Element)v.get(152)).setAttribute("conROver","S" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(153)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(153)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(153)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(153)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 152   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(154)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(154)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(154)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(154)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(152)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */

      /* Empieza nodo:155 / Elemento padre: 152   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(155)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(155)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(152)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:152   */

      /* Empieza nodo:156 / Elemento padre: 151   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(151)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(157)).setAttribute("borde","1" );
      ((Element)v.get(157)).setAttribute("horizDatos","1" );
      ((Element)v.get(157)).setAttribute("horizCabecera","1" );
      ((Element)v.get(157)).setAttribute("vertical","0" );
      ((Element)v.get(157)).setAttribute("horizTitulo","1" );
      ((Element)v.get(157)).setAttribute("horizBase","1" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */

      /* Empieza nodo:158 / Elemento padre: 156   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(158)).setAttribute("borde","#999999" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(158)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(158)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(158)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(158)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(158)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(158)).setAttribute("horizBase","#999999" );
      ((Element)v.get(156)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:156   */

      /* Empieza nodo:159 / Elemento padre: 151   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(159)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(159)).setAttribute("alto","22" );
      ((Element)v.get(159)).setAttribute("imgFondo","" );
      ((Element)v.get(159)).setAttribute("cod","00135" );
      ((Element)v.get(159)).setAttribute("ID","datosTitle" );
      ((Element)v.get(151)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */

      /* Empieza nodo:160 / Elemento padre: 151   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(160)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(160)).setAttribute("alto","22" );
      ((Element)v.get(160)).setAttribute("imgFondo","" );
      ((Element)v.get(151)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */

      /* Empieza nodo:161 / Elemento padre: 151   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(161)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(161)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(161)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(161)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(161)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(161)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(151)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(162)).setAttribute("ancho","120" );
      ((Element)v.get(162)).setAttribute("minimizable","S" );
      ((Element)v.get(162)).setAttribute("minimizada","N" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */

      /* Empieza nodo:163 / Elemento padre: 161   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(163)).setAttribute("ancho","250" );
      ((Element)v.get(163)).setAttribute("minimizable","S" );
      ((Element)v.get(163)).setAttribute("minimizada","N" );
      ((Element)v.get(163)).setAttribute("orden","" );
      ((Element)v.get(161)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:161   */

      /* Empieza nodo:164 / Elemento padre: 151   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(164)).setAttribute("alto","20" );
      ((Element)v.get(164)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(164)).setAttribute("imgFondo","" );
      ((Element)v.get(164)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(151)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(165)).setAttribute("colFondo","" );
      ((Element)v.get(165)).setAttribute("ID","EstCab" );
      ((Element)v.get(165)).setAttribute("align","center" );
      ((Element)v.get(165)).setAttribute("cod","337" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Elemento padre:165 / Elemento actual: 166   */
      v.add(doc.createTextNode("Cód. producto"));
      ((Element)v.get(165)).appendChild((Text)v.get(166));

      /* Termina nodo Texto:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(167)).setAttribute("colFondo","" );
      ((Element)v.get(167)).setAttribute("ID","EstCab" );
      ((Element)v.get(167)).setAttribute("cod","338" );
      ((Element)v.get(164)).appendChild((Element)v.get(167));

      /* Elemento padre:167 / Elemento actual: 168   */
      v.add(doc.createTextNode("Descripción producto"));
      ((Element)v.get(167)).appendChild((Text)v.get(168));

      /* Termina nodo Texto:168   */
      /* Termina nodo:167   */
      /* Termina nodo:164   */

      /* Empieza nodo:169 / Elemento padre: 151   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(169)).setAttribute("alto","22" );
      ((Element)v.get(169)).setAttribute("accion","" );
      ((Element)v.get(169)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(169)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(169)).setAttribute("maxSel","-1" );
      ((Element)v.get(169)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(169)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(169)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(169)).setAttribute("onLoad","" );
      ((Element)v.get(169)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(151)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(170)).setAttribute("tipo","texto" );
      ((Element)v.get(170)).setAttribute("ID","EstDat" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(171)).setAttribute("tipo","texto" );
      ((Element)v.get(171)).setAttribute("ID","EstDat2" );
      ((Element)v.get(169)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:169   */

      /* Empieza nodo:172 / Elemento padre: 151   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(151)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */

      /* Empieza nodo:173 / Elemento padre: 151   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(173)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(173)).setAttribute("ancho","654" );
      ((Element)v.get(173)).setAttribute("sep","$" );
      ((Element)v.get(173)).setAttribute("x","12" );
      ((Element)v.get(173)).setAttribute("class","botonera" );
      ((Element)v.get(173)).setAttribute("y","480" );
      ((Element)v.get(173)).setAttribute("control","|" );
      ((Element)v.get(173)).setAttribute("conector","" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(173)).setAttribute("rowset","" );
      ((Element)v.get(173)).setAttribute("cargainicial","N" );
      ((Element)v.get(173)).setAttribute("onload","procesarPaginado(mipgndo,msgError,ultima,rowset,'muestraLista(ultima,rowset)');" );
      ((Element)v.get(151)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(174)).setAttribute("nombre","ret1" );
      ((Element)v.get(174)).setAttribute("x","37" );
      ((Element)v.get(174)).setAttribute("y","484" );
      ((Element)v.get(174)).setAttribute("ID","botonContenido" );
      ((Element)v.get(174)).setAttribute("img","retroceder_on" );
      ((Element)v.get(174)).setAttribute("tipo","0" );
      ((Element)v.get(174)).setAttribute("estado","false" );
      ((Element)v.get(174)).setAttribute("alt","" );
      ((Element)v.get(174)).setAttribute("codigo","" );
      ((Element)v.get(174)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 173   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(175)).setAttribute("nombre","ava1" );
      ((Element)v.get(175)).setAttribute("x","52" );
      ((Element)v.get(175)).setAttribute("y","484" );
      ((Element)v.get(175)).setAttribute("ID","botonContenido" );
      ((Element)v.get(175)).setAttribute("img","avanzar_on" );
      ((Element)v.get(175)).setAttribute("tipo","0" );
      ((Element)v.get(175)).setAttribute("estado","false" );
      ((Element)v.get(175)).setAttribute("alt","" );
      ((Element)v.get(175)).setAttribute("codigo","" );
      ((Element)v.get(175)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(173)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:173   */
      /* Termina nodo:151   */

      /* Empieza nodo:176 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(176)).setAttribute("nombre","primera1" );
      ((Element)v.get(176)).setAttribute("x","20" );
      ((Element)v.get(176)).setAttribute("y","484" );
      ((Element)v.get(176)).setAttribute("ID","botonContenido" );
      ((Element)v.get(176)).setAttribute("img","primera_on" );
      ((Element)v.get(176)).setAttribute("tipo","-2" );
      ((Element)v.get(176)).setAttribute("estado","false" );
      ((Element)v.get(176)).setAttribute("alt","" );
      ((Element)v.get(176)).setAttribute("codigo","" );
      ((Element)v.get(176)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */

      /* Empieza nodo:177 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(177)).setAttribute("nombre","separa" );
      ((Element)v.get(177)).setAttribute("x","59" );
      ((Element)v.get(177)).setAttribute("y","480" );
      ((Element)v.get(177)).setAttribute("ID","botonContenido" );
      ((Element)v.get(177)).setAttribute("img","separa_base" );
      ((Element)v.get(177)).setAttribute("tipo","0" );
      ((Element)v.get(177)).setAttribute("estado","false" );
      ((Element)v.get(177)).setAttribute("alt","" );
      ((Element)v.get(177)).setAttribute("codigo","" );
      ((Element)v.get(177)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(178)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(178)).setAttribute("x","80" );
      ((Element)v.get(178)).setAttribute("y","481" );
      ((Element)v.get(178)).setAttribute("ID","botonContenido" );
      ((Element)v.get(178)).setAttribute("tipo","html" );
      ((Element)v.get(178)).setAttribute("estado","false" );
      ((Element)v.get(178)).setAttribute("cod","404" );
      ((Element)v.get(178)).setAttribute("accion","aniadir();" );
      ((Element)v.get(178)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnBuscar');" );
      ((Element)v.get(178)).setAttribute("ontab","focalizaParaAniadirTab();" );
      ((Element)v.get(6)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */

      /* Empieza nodo:179 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(179)).setAttribute("nombre","listado2" );
      ((Element)v.get(179)).setAttribute("ancho","654" );
      ((Element)v.get(179)).setAttribute("alto","301" );
      ((Element)v.get(179)).setAttribute("x","12" );
      ((Element)v.get(179)).setAttribute("y","527" );
      ((Element)v.get(179)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(179)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(180)).setAttribute("precarga","S" );
      ((Element)v.get(180)).setAttribute("conROver","S" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(181)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(181)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(181)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(181)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */

      /* Empieza nodo:182 / Elemento padre: 180   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(182)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(182)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(182)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(182)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(180)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 180   */
      v.add(doc.createElement("BTNORDENAR"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(183)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(183)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(180)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:180   */

      /* Empieza nodo:184 / Elemento padre: 179   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(179)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(185)).setAttribute("borde","1" );
      ((Element)v.get(185)).setAttribute("horizDatos","1" );
      ((Element)v.get(185)).setAttribute("horizCabecera","1" );
      ((Element)v.get(185)).setAttribute("vertical","0" );
      ((Element)v.get(185)).setAttribute("horizTitulo","1" );
      ((Element)v.get(185)).setAttribute("horizBase","1" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */

      /* Empieza nodo:186 / Elemento padre: 184   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(186)).setAttribute("borde","#999999" );
      ((Element)v.get(186)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(186)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(186)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(186)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(186)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(186)).setAttribute("horizBase","#999999" );
      ((Element)v.get(184)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:184   */

      /* Empieza nodo:187 / Elemento padre: 179   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(187)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(187)).setAttribute("alto","22" );
      ((Element)v.get(187)).setAttribute("imgFondo","" );
      ((Element)v.get(187)).setAttribute("cod","0094" );
      ((Element)v.get(187)).setAttribute("ID","datosTitle" );
      ((Element)v.get(179)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */

      /* Empieza nodo:188 / Elemento padre: 179   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(188)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(188)).setAttribute("alto","22" );
      ((Element)v.get(188)).setAttribute("imgFondo","" );
      ((Element)v.get(179)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */

      /* Empieza nodo:189 / Elemento padre: 179   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(189)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(189)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(189)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(189)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(189)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(189)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(179)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(190)).setAttribute("ancho","120" );
      ((Element)v.get(190)).setAttribute("minimizable","S" );
      ((Element)v.get(190)).setAttribute("minimizada","N" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */

      /* Empieza nodo:191 / Elemento padre: 189   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(191)).setAttribute("ancho","250" );
      ((Element)v.get(191)).setAttribute("minimizable","S" );
      ((Element)v.get(191)).setAttribute("minimizada","N" );
      ((Element)v.get(191)).setAttribute("orden","" );
      ((Element)v.get(189)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:189   */

      /* Empieza nodo:192 / Elemento padre: 179   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(192)).setAttribute("alto","20" );
      ((Element)v.get(192)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(192)).setAttribute("imgFondo","" );
      ((Element)v.get(192)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(179)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(193)).setAttribute("colFondo","" );
      ((Element)v.get(193)).setAttribute("ID","EstCab" );
      ((Element)v.get(193)).setAttribute("align","center" );
      ((Element)v.get(193)).setAttribute("cod","337" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Elemento padre:193 / Elemento actual: 194   */
      v.add(doc.createTextNode("Cód. producto"));
      ((Element)v.get(193)).appendChild((Text)v.get(194));

      /* Termina nodo Texto:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 192   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(195)).setAttribute("colFondo","" );
      ((Element)v.get(195)).setAttribute("ID","EstCab" );
      ((Element)v.get(195)).setAttribute("cod","338" );
      ((Element)v.get(192)).appendChild((Element)v.get(195));

      /* Elemento padre:195 / Elemento actual: 196   */
      v.add(doc.createTextNode("Descripción producto"));
      ((Element)v.get(195)).appendChild((Text)v.get(196));

      /* Termina nodo Texto:196   */
      /* Termina nodo:195   */
      /* Termina nodo:192   */

      /* Empieza nodo:197 / Elemento padre: 179   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(197)).setAttribute("alto","22" );
      ((Element)v.get(197)).setAttribute("accion","" );
      ((Element)v.get(197)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(197)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(197)).setAttribute("maxSel","-1" );
      ((Element)v.get(197)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(197)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(197)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(197)).setAttribute("onLoad","" );
      ((Element)v.get(197)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(179)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(198)).setAttribute("tipo","texto" );
      ((Element)v.get(198)).setAttribute("ID","EstDat" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */

      /* Empieza nodo:199 / Elemento padre: 197   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(199)).setAttribute("tipo","texto" );
      ((Element)v.get(199)).setAttribute("ID","EstDat2" );
      ((Element)v.get(197)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:197   */

      /* Empieza nodo:200 / Elemento padre: 179   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(179)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */

      /* Empieza nodo:201 / Elemento padre: 179   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(201)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(201)).setAttribute("ancho","654" );
      ((Element)v.get(201)).setAttribute("sep","$" );
      ((Element)v.get(201)).setAttribute("x","12" );
      ((Element)v.get(201)).setAttribute("class","botonera" );
      ((Element)v.get(201)).setAttribute("y","805" );
      ((Element)v.get(201)).setAttribute("control","|" );
      ((Element)v.get(201)).setAttribute("conector","" );
      ((Element)v.get(201)).setAttribute("rowset","" );
      ((Element)v.get(201)).setAttribute("cargainicial","N" );
      ((Element)v.get(179)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(202)).setAttribute("nombre","ret2" );
      ((Element)v.get(202)).setAttribute("x","37" );
      ((Element)v.get(202)).setAttribute("y","809" );
      ((Element)v.get(202)).setAttribute("ID","botonContenido" );
      ((Element)v.get(202)).setAttribute("img","retroceder_on" );
      ((Element)v.get(202)).setAttribute("tipo","0" );
      ((Element)v.get(202)).setAttribute("estado","false" );
      ((Element)v.get(202)).setAttribute("alt","" );
      ((Element)v.get(202)).setAttribute("codigo","" );
      ((Element)v.get(202)).setAttribute("accion","mipgndo2.retroceder();" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */

      /* Empieza nodo:203 / Elemento padre: 201   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(203)).setAttribute("nombre","ava2" );
      ((Element)v.get(203)).setAttribute("x","52" );
      ((Element)v.get(203)).setAttribute("y","809" );
      ((Element)v.get(203)).setAttribute("ID","botonContenido" );
      ((Element)v.get(203)).setAttribute("img","avanzar_on" );
      ((Element)v.get(203)).setAttribute("tipo","0" );
      ((Element)v.get(203)).setAttribute("estado","false" );
      ((Element)v.get(203)).setAttribute("alt","" );
      ((Element)v.get(203)).setAttribute("codigo","" );
      ((Element)v.get(203)).setAttribute("accion","mipgndo2.avanzar();" );
      ((Element)v.get(201)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:201   */
      /* Termina nodo:179   */

      /* Empieza nodo:204 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(204)).setAttribute("nombre","primera2" );
      ((Element)v.get(204)).setAttribute("x","20" );
      ((Element)v.get(204)).setAttribute("y","809" );
      ((Element)v.get(204)).setAttribute("ID","botonContenido" );
      ((Element)v.get(204)).setAttribute("img","primera_on" );
      ((Element)v.get(204)).setAttribute("tipo","-2" );
      ((Element)v.get(204)).setAttribute("estado","false" );
      ((Element)v.get(204)).setAttribute("alt","" );
      ((Element)v.get(204)).setAttribute("codigo","" );
      ((Element)v.get(204)).setAttribute("accion","mipgndo2.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */

      /* Empieza nodo:205 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(205)).setAttribute("nombre","separa2" );
      ((Element)v.get(205)).setAttribute("x","59" );
      ((Element)v.get(205)).setAttribute("y","805" );
      ((Element)v.get(205)).setAttribute("ID","botonContenido" );
      ((Element)v.get(205)).setAttribute("img","separa_base" );
      ((Element)v.get(205)).setAttribute("tipo","0" );
      ((Element)v.get(205)).setAttribute("estado","false" );
      ((Element)v.get(205)).setAttribute("alt","" );
      ((Element)v.get(205)).setAttribute("codigo","" );
      ((Element)v.get(205)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */

      /* Empieza nodo:206 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(206)).setAttribute("nombre","btnEliminar" );
      ((Element)v.get(206)).setAttribute("x","13" );
      ((Element)v.get(206)).setAttribute("y","806" );
      ((Element)v.get(206)).setAttribute("ID","botonContenido" );
      ((Element)v.get(206)).setAttribute("tipo","html" );
      ((Element)v.get(206)).setAttribute("estado","false" );
      ((Element)v.get(206)).setAttribute("cod","1254" );
      ((Element)v.get(206)).setAttribute("accion","eliminar();" );
      ((Element)v.get(206)).setAttribute("onshtab","focalizaBotonHTML_XY('btnAnadir');" );
      ((Element)v.get(6)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */

      /* Empieza nodo:207 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(207)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(207)).setAttribute("x","67" );
      ((Element)v.get(207)).setAttribute("y","806" );
      ((Element)v.get(207)).setAttribute("ID","botonContenido" );
      ((Element)v.get(207)).setAttribute("tipo","html" );
      ((Element)v.get(207)).setAttribute("estado","false" );
      ((Element)v.get(207)).setAttribute("cod","12" );
      ((Element)v.get(207)).setAttribute("accion","seleccionar();" );
      ((Element)v.get(207)).setAttribute("ontab","focaliza('formulario.txtCodProducto');" );
      ((Element)v.get(6)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */

      /* Empieza nodo:208 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(208)).setAttribute("nombre","capaEspacio" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(208)).setAttribute("alto","12" );
      ((Element)v.get(208)).setAttribute("ancho","100%" );
      ((Element)v.get(208)).setAttribute("colorf","" );
      ((Element)v.get(208)).setAttribute("borde","0" );
      ((Element)v.get(208)).setAttribute("imagenf","" );
      ((Element)v.get(208)).setAttribute("repeat","" );
      ((Element)v.get(208)).setAttribute("padding","" );
      ((Element)v.get(208)).setAttribute("visibilidad","visible" );
      ((Element)v.get(208)).setAttribute("contravsb","" );
      ((Element)v.get(208)).setAttribute("x","0" );
      ((Element)v.get(208)).setAttribute("y","828" );
      ((Element)v.get(208)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:6   */


   }

}


import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_plantilla_concurso_modificar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_plantilla_concurso_modificar" );
      ((Element)v.get(0)).setAttribute("cod","0940" );
      ((Element)v.get(0)).setAttribute("titulo","" );
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
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Elemento padre:5 / Elemento actual: 6   */
      v.add(doc.createTextNode("\r   \r\r  function onLoadPag()   {  \r    DrdEnsanchaConMargenDcho('listado1',12);     \r    eval (ON_RSZ);  \r		configurarMenuSecundario(\"frmFormulario\");\r		ocultaCapas();\r		focalizaNumeroPlantilla();\r  }\r\r  function ocultaCapas() {\r		document.all[\"Cplistado1\"].style.visibility='hidden';\r    document.all[\"CpLin1listado1\"].style.visibility='hidden';\r    document.all[\"CpLin2listado1\"].style.visibility='hidden';\r    document.all[\"CpLin3listado1\"].style.visibility='hidden';\r    document.all[\"CpLin4listado1\"].style.visibility='hidden';\r    document.all[\"avaDiv\"].style.visibility='hidden';\r    document.all[\"retDiv\"].style.visibility='hidden';\r    document.all[\"separaDiv\"].style.visibility='hidden';\r	document.all[\"primeraDiv\"].style.visibility='hidden';\r    document.all[\"ModificarDiv\"].style.visibility='hidden';\r    document.all[\"DetalleDiv\"].style.visibility='hidden';\r\r		var opcion = get(\"frmFormulario.opcionMenu\");\r    if(opcion == \"EliminarPlantilla\") {\r		btnProxy(4, '0');\r	}	 \r  }\r\r  function muestraCapas() {\r		document.all[\"Cplistado1\"].style.visibility='';\r    document.all[\"CpLin1listado1\"].style.visibility='';\r    document.all[\"CpLin2listado1\"].style.visibility='';\r    document.all[\"CpLin3listado1\"].style.visibility='';\r    document.all[\"CpLin4listado1\"].style.visibility='';\r    document.all[\"avaDiv\"].style.visibility='';\r    document.all[\"retDiv\"].style.visibility='';\r    document.all[\"separaDiv\"].style.visibility='';\r	document.all[\"primeraDiv\"].style.visibility='';\r\r	var opcion = get(\"frmFormulario.opcionMenu\");\r		if(opcion == \"ModificarPlantilla\") {\r		document.all[\"ModificarDiv\"].style.visibility='';\r		document.all[\"DetalleDiv\"].style.visibility='hidden';\r	}\r		if(opcion == \"ConsultarPlantilla\") {\r	    document.all[\"ModificarDiv\"].style.visibility='hidden';\r		document.all[\"DetalleDiv\"].style.visibility='';\r	}\r			if(opcion == \"EliminarPlantilla\") {\r	    document.all[\"ModificarDiv\"].style.visibility='hidden';\r		document.all[\"DetalleDiv\"].style.visibility='';\r		listado1.maxSel = \"-1\";\r 		btnProxy(4, '1');\r	}\r  }\r\r function focalizaNumeroPlantilla() {\r		focaliza('frmFormulario.txtNumPlantilla','');\r }\r\r function focalizaUltimoBoton() {	\r	var oculto = document.all[\"Cplistado1\"].style.visibility;\r	    if(oculto=='hidden') {\r		focaliza('frmFormulario.txtNumPlantilla','');\r		return;\r    }  \r\r    var opcion = get('frmFormulario.opcionMenu');\r        if(opcion=='ModificarPlantilla'){\r		focalizaBotonHTML_XY('Modificar');\r    }\r        if((opcion=='ConsultarPlantilla') || (opcion=='EliminarPlantilla')){\r		focalizaBotonHTML_XY('Detalle');\r    }\r  }\r    \r  function focalizaBotonBuscar() {\r		focalizaBotonHTML('botonContenido','btnBuscar');\r  }\r\r  function fLimpiar() {\r		var objArr = document.all['cbAcceso'];\r    for(var i=0; i < objArr.length; i++){\r		if(objArr[i].tagName && objArr[i].tagName.toUpperCase()==\"SELECT\"){\r			if (!objArr[i].disabled) {\r				var aCombo = new Array(new Array(\"\",\"\"));\r				set_combo('frmFormulario.cbAcceso',aCombo, []);				\r			}\r        }\r     }\r		focalizaNumeroPlantilla();\r   }\r\r   function onChangeCanal() {\r		if(get(\"frmFormulario.cbCanal\")!=\"\"){	\r		var arr = new Array();      \r		arr[arr.length] = new Array(\"oid\", get(\"frmFormulario.cbCanal\"));\r		arr[arr.length] = new Array(\"oidPais\", get(\"frmFormulario.oidPais\")); \r		arr[arr.length] = new Array(\"oidIdioma\", get(\"frmFormulario.oidIdioma\")); \r		recargaCombo(\"frmFormulario.cbAcceso\", 'SEGObtieneAccesosPorCanal','es.indra.sicc.util.DTOOID', arr);\r	}\r	else {	\r						var datosNuevo = new Array();\r        datosNuevo[0] = [\"\",\"\"];    \r        set_combo(\"frmFormulario.cbAcceso\", datosNuevo);     \r	}\r   }\r\r   function accionBuscar() {\r		if(sicc_validaciones_generales()) {\r		var opcion = get(\"frmFormulario.opcionMenu\");\r  \r  \r  	    var arr = new Array();\r		arr[arr.length] = new Array(\"numeroPlantilla\", get(\"frmFormulario.txtNumPlantilla\")+\"\");\r		arr[arr.length] = new Array(\"nombrePlantilla\", get(\"frmFormulario.txtNombrePlantilla\")+\"\");\r		arr[arr.length] = new Array(\"oidPaisPlantilla\", get(\"frmFormulario.cbPais\")+\"\");\r	    arr[arr.length] = new Array(\"oidMarca\", get(\"frmFormulario.cbMarca\")+\"\");\r		arr[arr.length] = new Array(\"oidCanal\", get(\"frmFormulario.cbCanal\")+\"\");\r	    arr[arr.length] = new Array(\"oidAcceso\", get(\"frmFormulario.cbAcceso\")+\"\");\r		arr[arr.length] = new Array(\"oidIdioma\", get(\"frmFormulario.oidIdioma\")+\"\");\r		\r    \r            if((opcion==\"ModificarPlantilla\") || (opcion==\"EliminarPlantilla\")) {\r      arr[arr.length] = new Array(\"indBloqueado\", '0' +\"\");\r    }\r    \r    configurarPaginado(mipgndo,\"INCBuscarPlantillas\",\"ConectorBuscarPlantillas\",\"es.indra.sicc.dtos.inc.DTOBusquedaPlantilla\",arr);  \r	}\r   }\r\r   function accionModificar() {\r	  	  if (listado1.numSelecc()!= 1) {\r		GestionarMensaje('1022',null,null,null);\r		return false;\r	  }\r\r  	  	        var arrAux = new Array();\r      arrAux = listado1.codSeleccionados();\r      var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);\r      var obj = new Object();\r\r      obj.oidPlantilla = listado1.datos[posicion][0];           \r      obj.accion = \"modificar\";\r	  obj.opcionMenu = \"ModificarPlantilla\";\r      \r      mostrarModalSICC('LPMantenimientoPlantilla','modificar',obj,800,500);\r	  	  accionBuscar();\r  	  	  focalizaNumeroPlantilla();\r   }\r\r  function accionDetalle () {\r	  	  	  if (listado1.numSelecc()!= 1) {\r		GestionarMensaje('1022',null,null,null);\r		return false;\r	  }\r\r      var arrAux = new Array();\r      arrAux = listado1.codSeleccionados();\r      var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);\r      var obj = new Object();\r\r      obj.oidPlantilla = listado1.datos[posicion][0];           \r      obj.accion = \"detalle\";\r	  \r	  var opcion = get(\"frmFormulario.opcionMenu\");\r	  if(opcion==\"ConsultarPlantilla\") {\r		obj.opcionMenu = \"ConsultarPlantilla\";\r	  }\r	  else {\r		obj.opcionMenu = \"EliminarPlantilla\";\r	  }  	  \r      \r      mostrarModalSICC('LPMantenimientoPlantilla','detalle',obj,800,500);\r	  focalizaNumeroPlantilla();\r   }\r\r  function accionEliminar() {\r	      if (listado1.numSelecc()== 0) {\r         GestionarMensaje('1021',null,null,null);\r         return false;\r     }\r      \r     eliminarFilas(listado1.codSeleccionados(),\"INCEliminarPlantilla\", mipgndo);\r   }\r\r   function fBorrar(){\r		accionEliminar();\r   }\r\rfunction mostrarMensajeNohayDatos() {\r	GestionarMensaje('MMGGlobal.query.noresults.message');	\r}\r\rfunction muestraLista(ultima, rowset, error){\r         var tamano = rowset.length;\r                  if (tamano > 0) {\r                  muestraCapas();\r             eval (ON_RSZ);\r                  focalizaNumeroPlantilla();\r                  return true;\r         }\r                  else {\r                  ocultaCapas();\r                  focalizaNumeroPlantilla();\r                  return false;\r         }\r}\r\r\rfunction obtenerPosicionListaEditable(clave, lista){\r	this.posicion = 0;\r    if (lista.codSeleccionados().length > 0){\r		for(var k=0;k<lista.datos.length;k++) {\r			if (lista.datos[k][0] == clave) {\r				posicion=k;\r                break;\r            }\r		 }         \r	     return posicion;\r	}\r}\r   \r\rfunction focalizaBotonAnterior(){\r	 var oculto = document.all[\"Cplistado1\"].style.visibility;\r\r	      if(oculto=='hidden') {\r		focalizaBotonHTML('botonContenido','btnBuscar');\r		return;\r     }  \r	 else {\r		var opcion = get('frmFormulario.opcionMenu');\r	 			if(opcion=='ModificarPlantilla'){\r			focalizaBotonHTML_XY('Modificar');\r		}\r	 			if((opcion=='ConsultarPlantilla') || (opcion=='EliminarPlantilla')){\r			focalizaBotonHTML_XY('Detalle');\r		}\r	 }     \r}\r\r\r   \r"));
      ((Element)v.get(5)).appendChild((Text)v.get(6));

      /* Termina nodo Texto:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","txtNumPlantilla" );
      ((Element)v.get(8)).setAttribute("required","false" );
      ((Element)v.get(8)).setAttribute("cod","1606" );
      ((Element)v.get(8)).setAttribute("format","e" );
      ((Element)v.get(8)).setAttribute("min","0" );
      ((Element)v.get(8)).setAttribute("max","99999" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */
      /* Termina nodo:7   */

      /* Empieza nodo:9 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(9)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","accion" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","oidPais" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","oidIdioma" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","indBloqueado" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 9   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(18)).setAttribute("nombre","capa1" );
      ((Element)v.get(18)).setAttribute("x","0" );
      ((Element)v.get(18)).setAttribute("y","0" );
      ((Element)v.get(9)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("table"));
      ((Element)v.get(19)).setAttribute("width","100%" );
      ((Element)v.get(19)).setAttribute("border","0" );
      ((Element)v.get(19)).setAttribute("cellspacing","0" );
      ((Element)v.get(19)).setAttribute("cellpadding","0" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(19)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("td"));
      ((Element)v.get(21)).setAttribute("width","12" );
      ((Element)v.get(21)).setAttribute("align","center" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(22)).setAttribute("src","b.gif" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("width","12" );
      ((Element)v.get(22)).setAttribute("height","12" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */
      /* Termina nodo:21   */

      /* Empieza nodo:23 / Elemento padre: 20   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).setAttribute("width","750" );
      ((Element)v.get(20)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(24)).setAttribute("src","b.gif" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:23   */

      /* Empieza nodo:25 / Elemento padre: 20   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).setAttribute("width","12" );
      ((Element)v.get(20)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(26)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).setAttribute("width","12" );
      ((Element)v.get(26)).setAttribute("height","1" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:25   */
      /* Termina nodo:20   */

      /* Empieza nodo:27 / Elemento padre: 19   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(19)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(29)).setAttribute("src","b.gif" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:30 / Elemento padre: 27   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(32)).setAttribute("class","legend" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(33)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(33)).setAttribute("alto","13" );
      ((Element)v.get(33)).setAttribute("filas","1" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(33)).setAttribute("id","legend" );
      ((Element)v.get(33)).setAttribute("cod","0075" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:34 / Elemento padre: 31   */
      v.add(doc.createElement("table"));
      ((Element)v.get(34)).setAttribute("width","100%" );
      ((Element)v.get(34)).setAttribute("border","0" );
      ((Element)v.get(34)).setAttribute("align","center" );
      ((Element)v.get(34)).setAttribute("cellspacing","0" );
      ((Element)v.get(34)).setAttribute("cellpadding","0" );
      ((Element)v.get(31)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("table"));
      ((Element)v.get(37)).setAttribute("width","486" );
      ((Element)v.get(37)).setAttribute("border","0" );
      ((Element)v.get(37)).setAttribute("align","left" );
      ((Element)v.get(37)).setAttribute("cellspacing","0" );
      ((Element)v.get(37)).setAttribute("cellpadding","0" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).setAttribute("colspan","3" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(40)).setAttribute("src","b.gif" );
      ((Element)v.get(40)).setAttribute("width","8" );
      ((Element)v.get(40)).setAttribute("height","8" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:41 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","8" );
      ((Element)v.get(43)).setAttribute("height","8" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(45)).setAttribute("nombre","lblNumPlantilla" );
      ((Element)v.get(45)).setAttribute("alto","13" );
      ((Element)v.get(45)).setAttribute("filas","1" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(45)).setAttribute("id","datosTitle" );
      ((Element)v.get(45)).setAttribute("cod","1606" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(47)).setAttribute("width","25" );
      ((Element)v.get(47)).setAttribute("height","8" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(49)).setAttribute("nombre","lblNombrePlantilla" );
      ((Element)v.get(49)).setAttribute("alto","13" );
      ((Element)v.get(49)).setAttribute("filas","1" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(49)).setAttribute("id","datosTitle" );
      ((Element)v.get(49)).setAttribute("cod","743" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).setAttribute("width","100%" );
      ((Element)v.get(41)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","8" );
      ((Element)v.get(51)).setAttribute("height","8" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */
      /* Termina nodo:41   */

      /* Empieza nodo:52 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(52));

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
      ((Element)v.get(56)).setAttribute("nombre","txtNumPlantilla" );
      ((Element)v.get(56)).setAttribute("id","datosCampos" );
      ((Element)v.get(56)).setAttribute("max","5" );
      ((Element)v.get(56)).setAttribute("tipo","" );
      ((Element)v.get(56)).setAttribute("onchange","" );
      ((Element)v.get(56)).setAttribute("req","N" );
      ((Element)v.get(56)).setAttribute("size","5" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(56)).setAttribute("validacion","" );
      ((Element)v.get(56)).setAttribute("onshtab","focalizaBotonAnterior();" );
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
      ((Element)v.get(60)).setAttribute("nombre","txtNombrePlantilla" );
      ((Element)v.get(60)).setAttribute("id","datosCampos" );
      ((Element)v.get(60)).setAttribute("max","75" );
      ((Element)v.get(60)).setAttribute("tipo","" );
      ((Element)v.get(60)).setAttribute("onchange","" );
      ((Element)v.get(60)).setAttribute("req","N" );
      ((Element)v.get(60)).setAttribute("size","75" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(60)).setAttribute("validacion","" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).setAttribute("width","100%" );
      ((Element)v.get(52)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","8" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:52   */

      /* Empieza nodo:63 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).setAttribute("colspan","3" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","8" );
      ((Element)v.get(65)).setAttribute("height","7" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:66 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("table"));
      ((Element)v.get(68)).setAttribute("width","486" );
      ((Element)v.get(68)).setAttribute("border","0" );
      ((Element)v.get(68)).setAttribute("align","left" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(68)).setAttribute("cellspacing","0" );
      ((Element)v.get(68)).setAttribute("cellpadding","0" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","8" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(73)).setAttribute("nombre","lblPais" );
      ((Element)v.get(73)).setAttribute("alto","13" );
      ((Element)v.get(73)).setAttribute("filas","1" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(73)).setAttribute("id","datosTitle" );
      ((Element)v.get(73)).setAttribute("cod","5" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","25" );
      ((Element)v.get(75)).setAttribute("height","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(77)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(77)).setAttribute("alto","13" );
      ((Element)v.get(77)).setAttribute("filas","1" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(77)).setAttribute("id","datosTitle" );
      ((Element)v.get(77)).setAttribute("cod","6" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("width","100%" );
      ((Element)v.get(69)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","8" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:69   */

      /* Empieza nodo:80 / Elemento padre: 68   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(68)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","8" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(80)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(84)).setAttribute("nombre","cbPais" );
      ((Element)v.get(84)).setAttribute("id","datosCampos" );
      ((Element)v.get(84)).setAttribute("size","1" );
      ((Element)v.get(84)).setAttribute("multiple","N" );
      ((Element)v.get(84)).setAttribute("req","N" );
      ((Element)v.get(84)).setAttribute("valorinicial","" );
      ((Element)v.get(84)).setAttribute("textoinicial","" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:86 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).setAttribute("width","25" );
      ((Element)v.get(87)).setAttribute("height","8" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(80)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(89)).setAttribute("nombre","cbMarca" );
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

      /* Empieza nodo:91 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("width","100%" );
      ((Element)v.get(80)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","8" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:80   */

      /* Empieza nodo:93 / Elemento padre: 68   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(68)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("colspan","3" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","8" );
      ((Element)v.get(95)).setAttribute("height","8" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:96 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("table"));
      ((Element)v.get(98)).setAttribute("width","486" );
      ((Element)v.get(98)).setAttribute("border","0" );
      ((Element)v.get(98)).setAttribute("align","left" );
      ((Element)v.get(98)).setAttribute("cellspacing","0" );
      ((Element)v.get(98)).setAttribute("cellpadding","0" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","8" );
      ((Element)v.get(101)).setAttribute("height","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(103)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(103)).setAttribute("alto","13" );
      ((Element)v.get(103)).setAttribute("filas","1" );
      ((Element)v.get(103)).setAttribute("valor","" );
      ((Element)v.get(103)).setAttribute("id","datosTitle" );
      ((Element)v.get(103)).setAttribute("cod","7" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","25" );
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(107)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(107)).setAttribute("alto","13" );
      ((Element)v.get(107)).setAttribute("filas","1" );
      ((Element)v.get(107)).setAttribute("valor","" );
      ((Element)v.get(107)).setAttribute("id","datosTitle" );
      ((Element)v.get(107)).setAttribute("cod","10" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("width","100%" );
      ((Element)v.get(99)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","8" );
      ((Element)v.get(109)).setAttribute("height","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:99   */

      /* Empieza nodo:110 / Elemento padre: 98   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(98)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).setAttribute("width","8" );
      ((Element)v.get(112)).setAttribute("height","8" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(113)).setAttribute("valign","top" );
      ((Element)v.get(110)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(114)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(114)).setAttribute("id","datosCampos" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(114)).setAttribute("size","1" );
      ((Element)v.get(114)).setAttribute("multiple","N" );
      ((Element)v.get(114)).setAttribute("req","N" );
      ((Element)v.get(114)).setAttribute("valorinicial","" );
      ((Element)v.get(114)).setAttribute("textoinicial","" );
      ((Element)v.get(114)).setAttribute("onchange","onChangeCanal();" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:116 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","25" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(110)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(119)).setAttribute("nombre","cbAcceso" );
      ((Element)v.get(119)).setAttribute("id","datosCampos" );
      ((Element)v.get(119)).setAttribute("size","1" );
      ((Element)v.get(119)).setAttribute("multiple","N" );
      ((Element)v.get(119)).setAttribute("req","N" );
      ((Element)v.get(119)).setAttribute("valorinicial","" );
      ((Element)v.get(119)).setAttribute("textoinicial","" );
      ((Element)v.get(119)).setAttribute("ontab","focalizaBotonBuscar();" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:121 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).setAttribute("width","100%" );
      ((Element)v.get(110)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","8" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:110   */

      /* Empieza nodo:123 / Elemento padre: 98   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(98)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).setAttribute("colspan","3" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).setAttribute("width","8" );
      ((Element)v.get(125)).setAttribute("height","8" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:34   */
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:126 / Elemento padre: 27   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:27   */

      /* Empieza nodo:128 / Elemento padre: 19   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(19)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("table"));
      ((Element)v.get(133)).setAttribute("width","100%" );
      ((Element)v.get(133)).setAttribute("border","0" );
      ((Element)v.get(133)).setAttribute("align","center" );
      ((Element)v.get(133)).setAttribute("cellspacing","0" );
      ((Element)v.get(133)).setAttribute("cellpadding","0" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).setAttribute("class","botonera" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(136)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(136)).setAttribute("ID","botonContenido" );
      ((Element)v.get(136)).setAttribute("tipo","html" );
      ((Element)v.get(136)).setAttribute("estado","false" );
      ((Element)v.get(136)).setAttribute("cod","1" );
      ((Element)v.get(136)).setAttribute("ontab","focalizaUltimoBoton();" );
      ((Element)v.get(136)).setAttribute("accion","accionBuscar();" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:137 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(138)).setAttribute("width","8" );
      ((Element)v.get(138)).setAttribute("height","12" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:128   */

      /* Empieza nodo:139 / Elemento padre: 19   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(19)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("width","12" );
      ((Element)v.get(140)).setAttribute("align","center" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).setAttribute("width","12" );
      ((Element)v.get(141)).setAttribute("height","12" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:142 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).setAttribute("width","756" );
      ((Element)v.get(139)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:144 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).setAttribute("width","12" );
      ((Element)v.get(139)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).setAttribute("width","12" );
      ((Element)v.get(145)).setAttribute("height","1" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:139   */
      /* Termina nodo:19   */
      /* Termina nodo:18   */

      /* Empieza nodo:146 / Elemento padre: 9   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(146)).setAttribute("nombre","listado1" );
      ((Element)v.get(146)).setAttribute("ancho","489" );
      ((Element)v.get(146)).setAttribute("alto","317" );
      ((Element)v.get(146)).setAttribute("x","12" );
      ((Element)v.get(146)).setAttribute("y","201" );
      ((Element)v.get(146)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(146)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(9)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(147)).setAttribute("precarga","S" );
      ((Element)v.get(147)).setAttribute("conROver","S" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(148)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(148)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(148)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(148)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */

      /* Empieza nodo:149 / Elemento padre: 147   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(149)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(149)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(149)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(149)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(147)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */

      /* Empieza nodo:150 / Elemento padre: 147   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(150)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(150)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(147)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:147   */

      /* Empieza nodo:151 / Elemento padre: 146   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(146)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(152)).setAttribute("borde","1" );
      ((Element)v.get(152)).setAttribute("horizDatos","1" );
      ((Element)v.get(152)).setAttribute("horizCabecera","1" );
      ((Element)v.get(152)).setAttribute("vertical","1" );
      ((Element)v.get(152)).setAttribute("horizTitulo","1" );
      ((Element)v.get(152)).setAttribute("horizBase","1" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */

      /* Empieza nodo:153 / Elemento padre: 151   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(153)).setAttribute("borde","#999999" );
      ((Element)v.get(153)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(153)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(153)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(153)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(153)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(153)).setAttribute("horizBase","#999999" );
      ((Element)v.get(151)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:151   */

      /* Empieza nodo:154 / Elemento padre: 146   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(154)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(154)).setAttribute("alto","22" );
      ((Element)v.get(154)).setAttribute("imgFondo","" );
      ((Element)v.get(154)).setAttribute("cod","00135" );
      ((Element)v.get(154)).setAttribute("ID","datosTitle" );
      ((Element)v.get(146)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */

      /* Empieza nodo:155 / Elemento padre: 146   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(155)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(155)).setAttribute("alto","22" );
      ((Element)v.get(155)).setAttribute("imgFondo","" );
      ((Element)v.get(146)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */

      /* Empieza nodo:156 / Elemento padre: 146   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(156)).setAttribute("ajustarMinimo","S" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(156)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(156)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(156)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(156)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(156)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(146)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(157)).setAttribute("ancho","100" );
      ((Element)v.get(157)).setAttribute("minimizable","S" );
      ((Element)v.get(157)).setAttribute("minimizada","N" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */

      /* Empieza nodo:158 / Elemento padre: 156   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(158)).setAttribute("ancho","120" );
      ((Element)v.get(158)).setAttribute("minimizable","S" );
      ((Element)v.get(158)).setAttribute("minimizada","N" );
      ((Element)v.get(156)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */

      /* Empieza nodo:159 / Elemento padre: 156   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(159)).setAttribute("ancho","100" );
      ((Element)v.get(159)).setAttribute("minimizable","S" );
      ((Element)v.get(159)).setAttribute("minimizada","N" );
      ((Element)v.get(156)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */

      /* Empieza nodo:160 / Elemento padre: 156   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(160)).setAttribute("ancho","100" );
      ((Element)v.get(160)).setAttribute("minimizable","S" );
      ((Element)v.get(160)).setAttribute("minimizada","N" );
      ((Element)v.get(156)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */

      /* Empieza nodo:161 / Elemento padre: 156   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(161)).setAttribute("ancho","100" );
      ((Element)v.get(161)).setAttribute("minimizable","S" );
      ((Element)v.get(161)).setAttribute("minimizada","N" );
      ((Element)v.get(156)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */

      /* Empieza nodo:162 / Elemento padre: 156   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(162)).setAttribute("ancho","100" );
      ((Element)v.get(162)).setAttribute("minimizable","S" );
      ((Element)v.get(162)).setAttribute("minimizada","N" );
      ((Element)v.get(156)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:156   */

      /* Empieza nodo:163 / Elemento padre: 146   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(163)).setAttribute("alto","20" );
      ((Element)v.get(163)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(163)).setAttribute("imgFondo","" );
      ((Element)v.get(163)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(146)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(164)).setAttribute("colFondo","" );
      ((Element)v.get(164)).setAttribute("ID","EstCab" );
      ((Element)v.get(164)).setAttribute("cod","1606" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */

      /* Empieza nodo:165 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(165)).setAttribute("colFondo","" );
      ((Element)v.get(165)).setAttribute("ID","EstCab" );
      ((Element)v.get(165)).setAttribute("cod","743" );
      ((Element)v.get(163)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */

      /* Empieza nodo:166 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(166)).setAttribute("colFondo","" );
      ((Element)v.get(166)).setAttribute("ID","EstCab" );
      ((Element)v.get(166)).setAttribute("cod","5" );
      ((Element)v.get(163)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */

      /* Empieza nodo:167 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(167)).setAttribute("colFondo","" );
      ((Element)v.get(167)).setAttribute("ID","EstCab" );
      ((Element)v.get(167)).setAttribute("cod","6" );
      ((Element)v.get(163)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(168)).setAttribute("colFondo","" );
      ((Element)v.get(168)).setAttribute("ID","EstCab" );
      ((Element)v.get(168)).setAttribute("cod","7" );
      ((Element)v.get(163)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 163   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(169)).setAttribute("colFondo","" );
      ((Element)v.get(169)).setAttribute("ID","EstCab" );
      ((Element)v.get(169)).setAttribute("cod","10" );
      ((Element)v.get(163)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:163   */

      /* Empieza nodo:170 / Elemento padre: 146   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(170)).setAttribute("alto","22" );
      ((Element)v.get(170)).setAttribute("accion","" );
      ((Element)v.get(170)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(170)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(170)).setAttribute("maxSel","1" );
      ((Element)v.get(170)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(170)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(170)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(170)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(146)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(171)).setAttribute("tipo","texto" );
      ((Element)v.get(171)).setAttribute("ID","EstDat" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */

      /* Empieza nodo:172 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(172)).setAttribute("tipo","texto" );
      ((Element)v.get(172)).setAttribute("ID","EstDat2" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(170)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */

      /* Empieza nodo:173 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(173)).setAttribute("tipo","texto" );
      ((Element)v.get(173)).setAttribute("ID","EstDat" );
      ((Element)v.get(170)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */

      /* Empieza nodo:174 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(174)).setAttribute("tipo","texto" );
      ((Element)v.get(174)).setAttribute("ID","EstDat2" );
      ((Element)v.get(170)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(175)).setAttribute("tipo","texto" );
      ((Element)v.get(175)).setAttribute("ID","EstDat" );
      ((Element)v.get(170)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */

      /* Empieza nodo:176 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(176)).setAttribute("tipo","texto" );
      ((Element)v.get(176)).setAttribute("ID","EstDat2" );
      ((Element)v.get(170)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:170   */

      /* Empieza nodo:177 / Elemento padre: 146   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(146)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 146   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(178)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(178)).setAttribute("ancho","489" );
      ((Element)v.get(178)).setAttribute("sep","$" );
      ((Element)v.get(178)).setAttribute("x","12" );
      ((Element)v.get(178)).setAttribute("class","botonera" );
      ((Element)v.get(178)).setAttribute("y","495" );
      ((Element)v.get(178)).setAttribute("control","|" );
      ((Element)v.get(178)).setAttribute("conector","" );
      ((Element)v.get(178)).setAttribute("rowset","" );
      ((Element)v.get(178)).setAttribute("cargainicial","N" );
      ((Element)v.get(178)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(146)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(179)).setAttribute("nombre","ret" );
      ((Element)v.get(179)).setAttribute("x","37" );
      ((Element)v.get(179)).setAttribute("y","499" );
      ((Element)v.get(179)).setAttribute("ID","botonContenido" );
      ((Element)v.get(179)).setAttribute("img","retroceder_on" );
      ((Element)v.get(179)).setAttribute("tipo","0" );
      ((Element)v.get(179)).setAttribute("estado","false" );
      ((Element)v.get(179)).setAttribute("alt","" );
      ((Element)v.get(179)).setAttribute("codigo","" );
      ((Element)v.get(179)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */

      /* Empieza nodo:180 / Elemento padre: 178   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(180)).setAttribute("nombre","ava" );
      ((Element)v.get(180)).setAttribute("x","52" );
      ((Element)v.get(180)).setAttribute("y","499" );
      ((Element)v.get(180)).setAttribute("ID","botonContenido" );
      ((Element)v.get(180)).setAttribute("img","avanzar_on" );
      ((Element)v.get(180)).setAttribute("tipo","0" );
      ((Element)v.get(180)).setAttribute("estado","false" );
      ((Element)v.get(180)).setAttribute("alt","" );
      ((Element)v.get(180)).setAttribute("codigo","" );
      ((Element)v.get(180)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(178)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:178   */
      /* Termina nodo:146   */

      /* Empieza nodo:181 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(181)).setAttribute("nombre","primera" );
      ((Element)v.get(181)).setAttribute("x","20" );
      ((Element)v.get(181)).setAttribute("y","499" );
      ((Element)v.get(181)).setAttribute("ID","botonContenido" );
      ((Element)v.get(181)).setAttribute("img","primera_on" );
      ((Element)v.get(181)).setAttribute("tipo","0" );
      ((Element)v.get(181)).setAttribute("estado","false" );
      ((Element)v.get(181)).setAttribute("alt","" );
      ((Element)v.get(181)).setAttribute("codigo","" );
      ((Element)v.get(181)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(9)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */

      /* Empieza nodo:182 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(182)).setAttribute("nombre","separa" );
      ((Element)v.get(182)).setAttribute("x","59" );
      ((Element)v.get(182)).setAttribute("y","495" );
      ((Element)v.get(182)).setAttribute("ID","botonContenido" );
      ((Element)v.get(182)).setAttribute("img","separa_base" );
      ((Element)v.get(182)).setAttribute("tipo","0" );
      ((Element)v.get(182)).setAttribute("estado","false" );
      ((Element)v.get(182)).setAttribute("alt","" );
      ((Element)v.get(182)).setAttribute("codigo","" );
      ((Element)v.get(182)).setAttribute("accion","" );
      ((Element)v.get(9)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(183)).setAttribute("nombre","Modificar" );
      ((Element)v.get(183)).setAttribute("x","80" );
      ((Element)v.get(183)).setAttribute("y","496" );
      ((Element)v.get(183)).setAttribute("ID","botonContenido" );
      ((Element)v.get(183)).setAttribute("img","" );
      ((Element)v.get(183)).setAttribute("tipo","html" );
      ((Element)v.get(183)).setAttribute("estado","false" );
      ((Element)v.get(183)).setAttribute("alt","" );
      ((Element)v.get(183)).setAttribute("cod","2" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(183)).setAttribute("ontab","focalizaNumeroPlantilla();" );
      ((Element)v.get(183)).setAttribute("onshtab","focalizaBotonBuscar();" );
      ((Element)v.get(183)).setAttribute("accion","accionModificar();" );
      ((Element)v.get(9)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */

      /* Empieza nodo:184 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(184)).setAttribute("nombre","Detalle" );
      ((Element)v.get(184)).setAttribute("x","80" );
      ((Element)v.get(184)).setAttribute("y","496" );
      ((Element)v.get(184)).setAttribute("ID","botonContenido" );
      ((Element)v.get(184)).setAttribute("img","" );
      ((Element)v.get(184)).setAttribute("tipo","html" );
      ((Element)v.get(184)).setAttribute("estado","false" );
      ((Element)v.get(184)).setAttribute("alt","" );
      ((Element)v.get(184)).setAttribute("cod","3" );
      ((Element)v.get(184)).setAttribute("ontab","focalizaNumeroPlantilla();" );
      ((Element)v.get(184)).setAttribute("onshtab","focalizaBotonBuscar();" );
      ((Element)v.get(184)).setAttribute("accion","accionDetalle();" );
      ((Element)v.get(9)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */

      /* Empieza nodo:185 / Elemento padre: 9   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(185)).setAttribute("nombre","capaEspacio2" );
      ((Element)v.get(185)).setAttribute("alto","18" );
      ((Element)v.get(185)).setAttribute("ancho","100" );
      ((Element)v.get(185)).setAttribute("colorf","" );
      ((Element)v.get(185)).setAttribute("borde","0" );
      ((Element)v.get(185)).setAttribute("imagenf","" );
      ((Element)v.get(185)).setAttribute("repeat","" );
      ((Element)v.get(185)).setAttribute("padding","" );
      ((Element)v.get(185)).setAttribute("visibilidad","visible" );
      ((Element)v.get(185)).setAttribute("contravsb","" );
      ((Element)v.get(185)).setAttribute("x","0" );
      ((Element)v.get(185)).setAttribute("y","518" );
      ((Element)v.get(185)).setAttribute("zindex","" );
      ((Element)v.get(9)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:9   */


   }

}


import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_plantilla_comisiones_modificar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_plantilla_comisiones_modificar" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","" );
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
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Elemento padre:5 / Elemento actual: 6   */
      v.add(doc.createTextNode("\r   \r\r    /* u.m. 01/01/2005\r	*/\r    \r	var ucs;\r	function onLoadPag()   \r	{	configurarMenuSecundario(\"formulario\");\r	\r  	   \r		ocultarLista();\r        DrdEnsanchaConMargenDcho('listado1',12);\r        eval (ON_RSZ);  \r	\r		ucs = _get('casoDeUso');\r\r		if(ucs=='eliminar'){\r				btnProxy(4,1);\r		}else{\r			btnProxy(4,0);\r		}\r		btnProxy(5,1)\r		accion(_form+'cbAcceso','.disabled=true')\r		focaliza(_form+'txtCodPlantilla')\r    }\r\r	function onClickModificar()\r	{	pos=chkPos()\r		if(pos != null)\r		{   obj = new Object()\r			obj.oidPlantilla = listado1.datos[pos][0];             \r\r			if(listado1.datos[pos][10] == get('formulario.constEliminado'))\r			{\r               			   GestionarMensaje('UICOM0004');\r			}\r            else\r			{\r																				obj.casoDeUso = ucs\r				obj.conectorAction = 'LPPlantillaComisiones'\r				mostrarModalSICC('LPPlantillaComisiones','modificar plantilla',obj,800,360);\r								onClickBuscar()\r			}\r		}\r	}\r\r	function onClickCopiar()\r	{	pos=chkPos()\r		if(pos != null)\r		{   var obj = new Object()\r			obj.oidPlantilla = listado1.datos[pos][0]; 			obj.casoDeUso = ucs;\r			obj.conectorAction = 'LPPlantillaComisiones';\r			var vWnd = mostrarModalSICC('LPPlantillaComisiones','copiar plantilla',obj,800,360);\r\r			if(vWnd)\r			  onClickBuscar();\r		}\r	}\r\r	function onClickDetalle() {   \r	    \r		pos = chkPos();\r		if (pos != null) {   \r			if (listado1.datos[pos][10] == get('formulario.constEliminado'))	{\r               			   GestionarMensaje('UICOM0055');\r			} else {\r					obj = new Object()\r					obj.oidPlantilla = listado1.datos[pos][0]; \r					obj.casoDeUso = ucs\r					obj.conectorAction = 'LPPlantillaComisiones'\r					var vWnd = mostrarModalSICC('LPPlantillaComisiones','consultar plantilla',obj,800,360);\r\r					if(vWnd) \r					  onClickBuscar();					\r			}\r		}\r	}\r\r	function cargarAcceso() {   \r	    \r		args = new Args();\r		with (args)	{	\r		    put('codigo',_get('txtCodPlantilla'));\r		    put('oidPais',_get('cbPais'));\r			put('oidIdioma',_get('oidIdioma'));\r			put('oidCanal',_get('cbCanal'));			\r		}\r        recargaCombo(_form+'cbAcceso', 'COMObtenerAccesosPlantilla', 'es.indra.sicc.dtos.com.DTOBusquedaAccesosPlantilla', args.getArgs())\r        accion(_form+'cbAcceso','.disabled=false');	\r		onClickBuscar();\r	}\r    \r\r	function fBorrar(){	eliminarByList('COMEliminarPlantillasCom') }\r\r	function onClickBuscar() {\r       \r		if (sicc_validaciones_generales()) {\r		  var args = new Args();\r		  with (args) {\r		     put('codPlantilla',_get('txtCodPlantilla'));\r		     put('oidIdioma',_get('oidIdioma'));\r		     put('descripcion',_get('txtDescripcion'));\r		     put('oidPaisPlanti',(_get('cbPais') =='')?'':_get('cbPais'));\r		     put('oidMarca',_get('cbMarca'));\r		     put('oidCanal',_get('cbCanal'));\r		     put('oidAcceso',_get('cbAcceso'));\r		     put('oidEstado',_get('cbEstado'));\r		 }		 \r		 configurarPaginado(mipgndo,'COMBuscarPlantillasComisiones','ConectorBuscarPlantillaComisiones',\r		   			   'es.indra.sicc.dtos.com.DTOBusquedaPlantillas', args.getArgs());				\r        }\r    }\r\r\r\r\rfunction muestraLista( ultima, rowset, error) {\r			var tamano = rowset.length;\r			if (tamano > 0){\r			  mostrarLista();\r			  eval (ON_RSZ);  \r			  \r			  return true;\r			}else{\r			  ocultarLista();\r			  document.all['btnModificarDiv'].style.visibility='hidden';\r 			  document.all['btnDetalleDiv'].style.visibility='hidden';\r			  eval (ON_RSZ);                      \r			  return false;\r			}\r    }\r\r   function mostrarLista(){\r        document.all[\"Cplistado1\"].style.visibility='visible';\r		document.all[\"CpLin1listado1\"].style.visibility='visible';\r		document.all[\"CpLin2listado1\"].style.visibility='visible';\r		document.all[\"CpLin3listado1\"].style.visibility='visible';\r		document.all[\"CpLin4listado1\"].style.visibility='visible';\r		document.all[\"primera1Div\"].style.visibility='visible';\r		document.all[\"ret1Div\"].style.visibility='visible';\r		document.all[\"ava1Div\"].style.visibility='visible';\r		document.all[\"separaDiv\"].style.visibility='visible';\r\r		ucs = _get('casoDeUso');\r\r		if(ucs=='modificar'){\r			document.all['btnModificarDiv'].style.visibility='visible';\r		}else{\r  	      if(ucs=='consultar'){\r			document.all['btnDetalleDiv'].style.visibility='visible';\r		   }else if(ucs=='eliminar'){\r			document.all['btnDetalleDiv'].style.visibility='hidden';\r			document.all['btnCopiarDiv'].style.visibility='hidden';\r			document.all['btnModificarDiv'].style.visibility='hidden';\r		   }else{\r		    document.all['btnModificarDiv'].style.visibility='hidden';\r            document.all['btnCopiarDiv'].style.visibility='visible';   		   }\r        }\r   }\r\r   \r   function ocultarLista(){\r  \r        document.all[\"Cplistado1\"].style.visibility='hidden';\r		document.all[\"CpLin1listado1\"].style.visibility='hidden';\r		document.all[\"CpLin2listado1\"].style.visibility='hidden';\r		document.all[\"CpLin3listado1\"].style.visibility='hidden';\r		document.all[\"CpLin4listado1\"].style.visibility='hidden';\r		document.all[\"primera1Div\"].style.visibility='hidden';\r		document.all[\"ret1Div\"].style.visibility='hidden';\r		document.all[\"ava1Div\"].style.visibility='hidden';\r		document.all[\"separaDiv\"].style.visibility='hidden';\r  	    document.all['btnModificarDiv'].style.visibility='hidden';\r        document.all['btnDetalleDiv'].style.visibility='hidden';\r		document.all['btnCopiarDiv'].style.visibility='hidden';\r \r   \r   \r   }\r	function armarArray() \r    {\r		 var vArray = new Array();\r		 var i = 0;\r		 vArray[i] = new Array('codPlantilla',_get('txtCodPlantilla'));\r		 i++;\r		 vArray[i] = new Array('descripcion',_get('txtDescripcion'));\r		 i++;\r		 vArray[i] = new Array('oidPais',_get('cbPais'));\r		 i++;\r		 vArray[i] = new Array('oidMarca',_get('cbMarca'));\r		 i++;\r		 vArray[i] = new Array('oidCanal',_get('cbCanal'));\r		 i++;\r		 vArray[i] = new Array('oidAcceso',_get('cbAcceso'));\r		 i++;\r		 vArray[i] = new Array('oidEstado',_get('cbEstado'));\r		\r		 return vArray; \r    }\r\r	function fLimpiar()\r	{	var arr = new Array();  arr[0] = \"\";\r		set(_form+'cbPais', arr)\r		set(_form+'cbMarca', arr)\r		set(_form+'cbCanal')\r		set(_form+'cbAcceso',arr)\r		set_combo(_form+'cbAcceso','')\r		set(_form+'cbEstado', arr)\r		set(_form+'txtCodPlantilla',\"\")\r		set(_form+'txtDescripcion',\"\")\r		limpiaI18N('formulario','1')\r		focaliza(_form+'txtCodPlantilla')\r	}\r    \r	function toDetalle()\r	{  \r	   if(document.all[\"btnModificarDiv\"].style.visibility == 'visible')           \r	   	   focalizaBotonHTML('botonContenido', 'btnModificar'); \r	   else\r	   {\r           if(document.all[\"btnDetalleDiv\"].style.visibility == 'visible')\r		     focalizaBotonHTML('botonContenido','btnDetalle');\r		   else\r		   {\r		     if(document.all[\"btnCopiarDiv\"].style.visibility == 'visible')\r		        focalizaBotonHTML('botonContenido','btnCopiar');\r		     else\r			 {			 \r				 if(arguments[0])\r					 focalizaBotonHTML('botonContenido','btnBuscar');\r				 else\r					 focaliza(_form+'txtCodPlantilla');\r			 }\r		   }\r	   }\r	}\r\r	_form='formulario.';ucs=null;\r	\r	function _get(){\r	   return get(_form+arguments[0])\r	} \r	\r	function hide(){\r	   document.all[arguments[0]].style.visibility='hidden'\r	}\r	\r	function show(){\r	   document.all[arguments[0]].style.visibility='visible'\r	}\r    \r	    function Args(){\r	   this.i=0;this.vArray=new Array();\r	}\r	\r	Args.prototype.put=function(){this.vArray[this.i]=new Array(arguments[0],arguments[1]);this.i++}\r	Args.prototype.getArgs=function(){return this.vArray;}\r    	\r	function chkPos() 	{	if(listado1.numSelecc() == 1)\r			return obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);			\r		else\r		{  if(listado1.numSelecc() > 1)\r			cdos_mostrarAlert(GestionarMensaje(\"240\"));		  \r		   else\r		   {  if(listado1.numSelecc() < 1)\r				 GestionarMensaje(\"4\");\r		   }\r		}\r		return null;\r	}\r		function eliminarByList()\r	{	if(listado1.numSelecc() < 1)\r			GestionarMensaje(\"4\");    		else\r		{	eliminarFilas(listado1.codSeleccionados(),arguments[0],mipgndo);\r			onClickBuscar();\r		}\r	}\r\r\r   \r\r "));
      ((Element)v.get(5)).appendChild((Text)v.get(6));

      /* Termina nodo Texto:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(5)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","txtCodPlantilla" );
      ((Element)v.get(8)).setAttribute("required","false" );
      ((Element)v.get(8)).setAttribute("cod","716" );
      ((Element)v.get(8)).setAttribute("min","0" );
      ((Element)v.get(8)).setAttribute("max","999999999999" );
      ((Element)v.get(8)).setAttribute("format","e" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */
      /* Termina nodo:7   */
      /* Termina nodo:5   */

      /* Empieza nodo:9 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(9)).setAttribute("nombre","formulario" );
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
      ((Element)v.get(13)).setAttribute("nombre","oidPais" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","oidIdioma" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","constEliminado" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 9   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(19)).setAttribute("nombre","capa1" );
      ((Element)v.get(9)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("table"));
      ((Element)v.get(20)).setAttribute("width","100%" );
      ((Element)v.get(20)).setAttribute("border","0" );
      ((Element)v.get(20)).setAttribute("cellspacing","0" );
      ((Element)v.get(20)).setAttribute("cellpadding","0" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("td"));
      ((Element)v.get(22)).setAttribute("width","12" );
      ((Element)v.get(22)).setAttribute("align","center" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(23)).setAttribute("src","b.gif" );
      ((Element)v.get(23)).setAttribute("width","12" );
      ((Element)v.get(23)).setAttribute("height","12" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */
      /* Termina nodo:22   */

      /* Empieza nodo:24 / Elemento padre: 21   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).setAttribute("width","750" );
      ((Element)v.get(21)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:26 / Elemento padre: 21   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).setAttribute("width","12" );
      ((Element)v.get(21)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(27)).setAttribute("src","b.gif" );
      ((Element)v.get(27)).setAttribute("width","12" );
      ((Element)v.get(27)).setAttribute("height","1" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */
      /* Termina nodo:21   */

      /* Empieza nodo:28 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(30)).setAttribute("src","b.gif" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:31 / Elemento padre: 28   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(33)).setAttribute("class","legend" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(34)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(34)).setAttribute("alto","13" );
      ((Element)v.get(34)).setAttribute("filas","1" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(34)).setAttribute("id","legend" );
      ((Element)v.get(34)).setAttribute("cod","0075" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:35 / Elemento padre: 32   */
      v.add(doc.createElement("table"));
      ((Element)v.get(35)).setAttribute("width","100%" );
      ((Element)v.get(35)).setAttribute("border","0" );
      ((Element)v.get(35)).setAttribute("align","center" );
      ((Element)v.get(35)).setAttribute("cellspacing","0" );
      ((Element)v.get(35)).setAttribute("cellpadding","0" );
      ((Element)v.get(32)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("table"));
      ((Element)v.get(38)).setAttribute("width","586" );
      ((Element)v.get(38)).setAttribute("border","0" );
      ((Element)v.get(38)).setAttribute("align","left" );
      ((Element)v.get(38)).setAttribute("cellspacing","0" );
      ((Element)v.get(38)).setAttribute("cellpadding","0" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).setAttribute("colspan","4" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).setAttribute("width","8" );
      ((Element)v.get(41)).setAttribute("height","8" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:42 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).setAttribute("width","8" );
      ((Element)v.get(44)).setAttribute("height","8" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(46)).setAttribute("nombre","lblCodPlantilla" );
      ((Element)v.get(46)).setAttribute("alto","13" );
      ((Element)v.get(46)).setAttribute("filas","1" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(46)).setAttribute("cod","716" );
      ((Element)v.get(46)).setAttribute("id","datosTitle" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(48)).setAttribute("src","b.gif" );
      ((Element)v.get(48)).setAttribute("width","25" );
      ((Element)v.get(48)).setAttribute("height","8" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(50)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(50)).setAttribute("alto","13" );
      ((Element)v.get(50)).setAttribute("filas","1" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(50)).setAttribute("id","datosTitle" );
      ((Element)v.get(50)).setAttribute("cod","9" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).setAttribute("width","100%" );
      ((Element)v.get(42)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(52)).setAttribute("width","8" );
      ((Element)v.get(52)).setAttribute("height","8" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */
      /* Termina nodo:42   */

      /* Empieza nodo:53 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).setAttribute("width","8" );
      ((Element)v.get(55)).setAttribute("height","8" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(53)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(57)).setAttribute("nombre","txtCodPlantilla" );
      ((Element)v.get(57)).setAttribute("id","datosCampos" );
      ((Element)v.get(57)).setAttribute("max","12" );
      ((Element)v.get(57)).setAttribute("tipo","" );
      ((Element)v.get(57)).setAttribute("onchange","cargarAcceso()" );
      ((Element)v.get(57)).setAttribute("req","N" );
      ((Element)v.get(57)).setAttribute("size","15" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(57)).setAttribute("validacion","" );
      ((Element)v.get(57)).setAttribute("onshtab","toDetalle(true)" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","25" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(53)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(61)).setAttribute("nombre","txtDescripcion" );
      ((Element)v.get(61)).setAttribute("id","datosCampos" );
      ((Element)v.get(61)).setAttribute("max","30" );
      ((Element)v.get(61)).setAttribute("tipo","" );
      ((Element)v.get(61)).setAttribute("onchange","" );
      ((Element)v.get(61)).setAttribute("req","N" );
      ((Element)v.get(61)).setAttribute("size","30" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(61)).setAttribute("validacion","" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("width","100%" );
      ((Element)v.get(53)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","8" );
      ((Element)v.get(63)).setAttribute("height","8" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:53   */

      /* Empieza nodo:64 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("colspan","4" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","8" );
      ((Element)v.get(66)).setAttribute("height","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:67 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("table"));
      ((Element)v.get(69)).setAttribute("width","586" );
      ((Element)v.get(69)).setAttribute("border","0" );
      ((Element)v.get(69)).setAttribute("align","left" );
      ((Element)v.get(69)).setAttribute("cellspacing","0" );
      ((Element)v.get(69)).setAttribute("cellpadding","0" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","8" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(74)).setAttribute("nombre","lblPais" );
      ((Element)v.get(74)).setAttribute("alto","13" );
      ((Element)v.get(74)).setAttribute("filas","1" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(74)).setAttribute("id","datosTitle" );
      ((Element)v.get(74)).setAttribute("cod","5" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","25" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(78)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(78)).setAttribute("alto","13" );
      ((Element)v.get(78)).setAttribute("filas","1" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(78)).setAttribute("id","datosTitle" );
      ((Element)v.get(78)).setAttribute("cod","6" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","25" );
      ((Element)v.get(80)).setAttribute("height","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(82)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(82)).setAttribute("alto","13" );
      ((Element)v.get(82)).setAttribute("filas","1" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(82)).setAttribute("id","datosTitle" );
      ((Element)v.get(82)).setAttribute("cod","7" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("width","100%" );
      ((Element)v.get(70)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","8" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:70   */

      /* Empieza nodo:85 / Elemento padre: 69   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(69)).appendChild((Element)v.get(85));

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
      ((Element)v.get(89)).setAttribute("nombre","cbPais" );
      ((Element)v.get(89)).setAttribute("id","datosCampos" );
      ((Element)v.get(89)).setAttribute("size","1" );
      ((Element)v.get(89)).setAttribute("multiple","N" );
      ((Element)v.get(89)).setAttribute("req","N" );
      ((Element)v.get(89)).setAttribute("valorinicial","" );
      ((Element)v.get(89)).setAttribute("textoinicial","" );
      ((Element)v.get(89)).setAttribute("onchange","cargarAcceso()" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("ROWSET"));
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
      ((Element)v.get(94)).setAttribute("nombre","cbMarca" );
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
      ((Element)v.get(85)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","25" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(85)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(99)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(99)).setAttribute("id","datosCampos" );
      ((Element)v.get(99)).setAttribute("size","1" );
      ((Element)v.get(99)).setAttribute("multiple","N" );
      ((Element)v.get(99)).setAttribute("req","N" );
      ((Element)v.get(99)).setAttribute("valorinicial","" );
      ((Element)v.get(99)).setAttribute("textoinicial","" );
      ((Element)v.get(99)).setAttribute("onchange","cargarAcceso()" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:101 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).setAttribute("width","100%" );
      ((Element)v.get(85)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).setAttribute("width","8" );
      ((Element)v.get(102)).setAttribute("height","8" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:85   */

      /* Empieza nodo:103 / Elemento padre: 69   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(69)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("colspan","4" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","8" );
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:106 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("table"));
      ((Element)v.get(108)).setAttribute("width","586" );
      ((Element)v.get(108)).setAttribute("border","0" );
      ((Element)v.get(108)).setAttribute("align","left" );
      ((Element)v.get(108)).setAttribute("cellspacing","0" );
      ((Element)v.get(108)).setAttribute("cellpadding","0" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).setAttribute("width","8" );
      ((Element)v.get(111)).setAttribute("height","8" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(113)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(113)).setAttribute("alto","13" );
      ((Element)v.get(113)).setAttribute("filas","1" );
      ((Element)v.get(113)).setAttribute("valor","" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(113)).setAttribute("id","datosTitle" );
      ((Element)v.get(113)).setAttribute("cod","10" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","25" );
      ((Element)v.get(115)).setAttribute("height","8" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(117)).setAttribute("nombre","lblEstado" );
      ((Element)v.get(117)).setAttribute("alto","13" );
      ((Element)v.get(117)).setAttribute("filas","1" );
      ((Element)v.get(117)).setAttribute("valor","" );
      ((Element)v.get(117)).setAttribute("cod","400" );
      ((Element)v.get(117)).setAttribute("id","datosTitle" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("width","100%" );
      ((Element)v.get(109)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).setAttribute("width","8" );
      ((Element)v.get(119)).setAttribute("height","8" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:109   */

      /* Empieza nodo:120 / Elemento padre: 108   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(108)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","8" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(120)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(124)).setAttribute("nombre","cbAcceso" );
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

      /* Empieza nodo:126 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","25" );
      ((Element)v.get(127)).setAttribute("height","8" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:128 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(120)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(129)).setAttribute("nombre","cbEstado" );
      ((Element)v.get(129)).setAttribute("id","datosCampos" );
      ((Element)v.get(129)).setAttribute("size","1" );
      ((Element)v.get(129)).setAttribute("multiple","N" );
      ((Element)v.get(129)).setAttribute("req","N" );
      ((Element)v.get(129)).setAttribute("valorinicial","" );
      ((Element)v.get(129)).setAttribute("textoinicial","" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:131 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).setAttribute("width","100%" );
      ((Element)v.get(120)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(132)).setAttribute("width","8" );
      ((Element)v.get(132)).setAttribute("height","8" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:120   */

      /* Empieza nodo:133 / Elemento padre: 108   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(108)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).setAttribute("colspan","4" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","8" );
      ((Element)v.get(135)).setAttribute("height","8" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:35   */
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:136 / Elemento padre: 28   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:28   */

      /* Empieza nodo:138 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("table"));
      ((Element)v.get(143)).setAttribute("width","100%" );
      ((Element)v.get(143)).setAttribute("border","0" );
      ((Element)v.get(143)).setAttribute("align","center" );
      ((Element)v.get(143)).setAttribute("cellspacing","0" );
      ((Element)v.get(143)).setAttribute("cellpadding","0" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).setAttribute("class","botonera" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(146)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(146)).setAttribute("ID","botonContenido" );
      ((Element)v.get(146)).setAttribute("tipo","html" );
      ((Element)v.get(146)).setAttribute("accion","onClickBuscar()" );
      ((Element)v.get(146)).setAttribute("cod","1" );
      ((Element)v.get(146)).setAttribute("estado","false" );
      ((Element)v.get(146)).setAttribute("ontab","toDetalle()" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:147 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).setAttribute("width","8" );
      ((Element)v.get(148)).setAttribute("height","12" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:138   */

      /* Empieza nodo:149 / Elemento padre: 20   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(20)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).setAttribute("width","12" );
      ((Element)v.get(150)).setAttribute("align","center" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).setAttribute("width","12" );
      ((Element)v.get(151)).setAttribute("height","12" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).setAttribute("width","756" );
      ((Element)v.get(149)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:154 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).setAttribute("width","12" );
      ((Element)v.get(149)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(155)).setAttribute("src","b.gif" );
      ((Element)v.get(155)).setAttribute("width","12" );
      ((Element)v.get(155)).setAttribute("height","1" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:149   */
      /* Termina nodo:20   */
      /* Termina nodo:19   */

      /* Empieza nodo:156 / Elemento padre: 9   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(156)).setAttribute("nombre","listado1" );
      ((Element)v.get(156)).setAttribute("ancho","690" );
      ((Element)v.get(156)).setAttribute("alto","317" );
      ((Element)v.get(156)).setAttribute("x","12" );
      ((Element)v.get(156)).setAttribute("y","202" );
      ((Element)v.get(156)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(156)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(9)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(157)).setAttribute("precarga","S" );
      ((Element)v.get(157)).setAttribute("conROver","S" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(158)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(158)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(158)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(158)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */

      /* Empieza nodo:159 / Elemento padre: 157   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(159)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(159)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(159)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(159)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(157)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */

      /* Empieza nodo:160 / Elemento padre: 157   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(160)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(160)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(157)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:157   */

      /* Empieza nodo:161 / Elemento padre: 156   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(156)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(162)).setAttribute("borde","1" );
      ((Element)v.get(162)).setAttribute("horizDatos","1" );
      ((Element)v.get(162)).setAttribute("horizCabecera","1" );
      ((Element)v.get(162)).setAttribute("vertical","0" );
      ((Element)v.get(162)).setAttribute("horizTitulo","1" );
      ((Element)v.get(162)).setAttribute("horizBase","1" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */

      /* Empieza nodo:163 / Elemento padre: 161   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(163)).setAttribute("borde","#999999" );
      ((Element)v.get(163)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(163)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(163)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(163)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(163)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(163)).setAttribute("horizBase","#999999" );
      ((Element)v.get(161)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:161   */

      /* Empieza nodo:164 / Elemento padre: 156   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(164)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(164)).setAttribute("alto","22" );
      ((Element)v.get(164)).setAttribute("imgFondo","" );
      ((Element)v.get(164)).setAttribute("cod","00135" );
      ((Element)v.get(164)).setAttribute("ID","datosTitle" );
      ((Element)v.get(156)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */

      /* Empieza nodo:165 / Elemento padre: 156   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(165)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(165)).setAttribute("alto","22" );
      ((Element)v.get(165)).setAttribute("imgFondo","" );
      ((Element)v.get(156)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */

      /* Empieza nodo:166 / Elemento padre: 156   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(166)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(166)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(166)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(166)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(166)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(166)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(156)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(167)).setAttribute("ancho","100" );
      ((Element)v.get(167)).setAttribute("minimizable","S" );
      ((Element)v.get(167)).setAttribute("minimizada","N" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(168)).setAttribute("ancho","100" );
      ((Element)v.get(168)).setAttribute("minimizable","S" );
      ((Element)v.get(168)).setAttribute("minimizada","N" );
      ((Element)v.get(166)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(169)).setAttribute("ancho","100" );
      ((Element)v.get(169)).setAttribute("minimizable","S" );
      ((Element)v.get(169)).setAttribute("minimizada","N" );
      ((Element)v.get(166)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */

      /* Empieza nodo:170 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(170)).setAttribute("ancho","100" );
      ((Element)v.get(170)).setAttribute("minimizable","S" );
      ((Element)v.get(170)).setAttribute("minimizada","N" );
      ((Element)v.get(166)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(171)).setAttribute("ancho","100" );
      ((Element)v.get(171)).setAttribute("minimizable","S" );
      ((Element)v.get(171)).setAttribute("minimizada","N" );
      ((Element)v.get(166)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */

      /* Empieza nodo:172 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(172)).setAttribute("ancho","100" );
      ((Element)v.get(172)).setAttribute("minimizable","S" );
      ((Element)v.get(172)).setAttribute("minimizada","N" );
      ((Element)v.get(166)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */

      /* Empieza nodo:173 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(173)).setAttribute("ancho","100" );
      ((Element)v.get(173)).setAttribute("minimizable","S" );
      ((Element)v.get(173)).setAttribute("minimizada","N" );
      ((Element)v.get(166)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */

      /* Empieza nodo:174 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(174)).setAttribute("ancho","100" );
      ((Element)v.get(174)).setAttribute("minimizable","S" );
      ((Element)v.get(174)).setAttribute("minimizada","N" );
      ((Element)v.get(166)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(175)).setAttribute("ancho","230" );
      ((Element)v.get(175)).setAttribute("minimizable","S" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(175)).setAttribute("minimizada","N" );
      ((Element)v.get(166)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */

      /* Empieza nodo:176 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(176)).setAttribute("ancho","100" );
      ((Element)v.get(176)).setAttribute("minimizable","S" );
      ((Element)v.get(176)).setAttribute("minimizada","N" );
      ((Element)v.get(166)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:166   */

      /* Empieza nodo:177 / Elemento padre: 156   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(177)).setAttribute("alto","20" );
      ((Element)v.get(177)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(177)).setAttribute("imgFondo","" );
      ((Element)v.get(177)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(156)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(178)).setAttribute("colFondo","" );
      ((Element)v.get(178)).setAttribute("ID","EstCab" );
      ((Element)v.get(178)).setAttribute("cod","716" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */

      /* Empieza nodo:179 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(179)).setAttribute("colFondo","" );
      ((Element)v.get(179)).setAttribute("ID","EstCab" );
      ((Element)v.get(179)).setAttribute("cod","9" );
      ((Element)v.get(177)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */

      /* Empieza nodo:180 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(180)).setAttribute("colFondo","" );
      ((Element)v.get(180)).setAttribute("ID","EstCab" );
      ((Element)v.get(180)).setAttribute("cod","5" );
      ((Element)v.get(177)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(181)).setAttribute("colFondo","" );
      ((Element)v.get(181)).setAttribute("ID","EstCab" );
      ((Element)v.get(181)).setAttribute("cod","6" );
      ((Element)v.get(177)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */

      /* Empieza nodo:182 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(182)).setAttribute("colFondo","" );
      ((Element)v.get(182)).setAttribute("ID","EstCab" );
      ((Element)v.get(182)).setAttribute("cod","7" );
      ((Element)v.get(177)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(183)).setAttribute("colFondo","" );
      ((Element)v.get(183)).setAttribute("ID","EstCab" );
      ((Element)v.get(183)).setAttribute("cod","10" );
      ((Element)v.get(177)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */

      /* Empieza nodo:184 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(184)).setAttribute("colFondo","" );
      ((Element)v.get(184)).setAttribute("ID","EstCab" );
      ((Element)v.get(184)).setAttribute("cod","1857" );
      ((Element)v.get(177)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */

      /* Empieza nodo:185 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(185)).setAttribute("colFondo","" );
      ((Element)v.get(185)).setAttribute("ID","EstCab" );
      ((Element)v.get(185)).setAttribute("cod","1699" );
      ((Element)v.get(177)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */

      /* Empieza nodo:186 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(186)).setAttribute("colFondo","" );
      ((Element)v.get(186)).setAttribute("ID","EstCab" );
      ((Element)v.get(186)).setAttribute("cod","1700" );
      ((Element)v.get(177)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */

      /* Empieza nodo:187 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(187)).setAttribute("colFondo","" );
      ((Element)v.get(187)).setAttribute("ID","EstCab" );
      ((Element)v.get(187)).setAttribute("cod","400" );
      ((Element)v.get(177)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:177   */

      /* Empieza nodo:188 / Elemento padre: 156   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(188)).setAttribute("alto","22" );
      ((Element)v.get(188)).setAttribute("accion","" );
      ((Element)v.get(188)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(188)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(188)).setAttribute("maxSel","-1" );
      ((Element)v.get(188)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(188)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(188)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(188)).setAttribute("onLoad","" );
      ((Element)v.get(188)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(156)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(189)).setAttribute("tipo","texto" );
      ((Element)v.get(189)).setAttribute("ID","EstDat" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */

      /* Empieza nodo:190 / Elemento padre: 188   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(190)).setAttribute("tipo","texto" );
      ((Element)v.get(190)).setAttribute("ID","EstDat2" );
      ((Element)v.get(188)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */

      /* Empieza nodo:191 / Elemento padre: 188   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(191)).setAttribute("tipo","texto" );
      ((Element)v.get(191)).setAttribute("ID","EstDat" );
      ((Element)v.get(188)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */

      /* Empieza nodo:192 / Elemento padre: 188   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(192)).setAttribute("tipo","texto" );
      ((Element)v.get(192)).setAttribute("ID","EstDat2" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(188)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */

      /* Empieza nodo:193 / Elemento padre: 188   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(193)).setAttribute("tipo","texto" );
      ((Element)v.get(193)).setAttribute("ID","EstDat" );
      ((Element)v.get(188)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */

      /* Empieza nodo:194 / Elemento padre: 188   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(194)).setAttribute("tipo","texto" );
      ((Element)v.get(194)).setAttribute("ID","EstDat2" );
      ((Element)v.get(188)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */

      /* Empieza nodo:195 / Elemento padre: 188   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(195)).setAttribute("tipo","texto" );
      ((Element)v.get(195)).setAttribute("ID","EstDat" );
      ((Element)v.get(188)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */

      /* Empieza nodo:196 / Elemento padre: 188   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(196)).setAttribute("tipo","texto" );
      ((Element)v.get(196)).setAttribute("ID","EstDat2" );
      ((Element)v.get(188)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */

      /* Empieza nodo:197 / Elemento padre: 188   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(197)).setAttribute("tipo","texto" );
      ((Element)v.get(197)).setAttribute("ID","EstDat" );
      ((Element)v.get(188)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */

      /* Empieza nodo:198 / Elemento padre: 188   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(198)).setAttribute("tipo","texto" );
      ((Element)v.get(198)).setAttribute("ID","EstDat2" );
      ((Element)v.get(188)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:188   */

      /* Empieza nodo:199 / Elemento padre: 156   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(156)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */

      /* Empieza nodo:200 / Elemento padre: 156   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(200)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(200)).setAttribute("ancho","690" );
      ((Element)v.get(200)).setAttribute("sep","$" );
      ((Element)v.get(200)).setAttribute("x","12" );
      ((Element)v.get(200)).setAttribute("class","botonera" );
      ((Element)v.get(200)).setAttribute("y","496" );
      ((Element)v.get(200)).setAttribute("control","|" );
      ((Element)v.get(200)).setAttribute("conector","" );
      ((Element)v.get(200)).setAttribute("rowset","" );
      ((Element)v.get(200)).setAttribute("cargainicial","N" );
      ((Element)v.get(200)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(156)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(201)).setAttribute("nombre","ret1" );
      ((Element)v.get(201)).setAttribute("x","37" );
      ((Element)v.get(201)).setAttribute("y","500" );
      ((Element)v.get(201)).setAttribute("ID","botonContenido" );
      ((Element)v.get(201)).setAttribute("img","retroceder_on" );
      ((Element)v.get(201)).setAttribute("tipo","0" );
      ((Element)v.get(201)).setAttribute("estado","false" );
      ((Element)v.get(201)).setAttribute("alt","" );
      ((Element)v.get(201)).setAttribute("codigo","" );
      ((Element)v.get(201)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */

      /* Empieza nodo:202 / Elemento padre: 200   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(202)).setAttribute("nombre","ava1" );
      ((Element)v.get(202)).setAttribute("x","52" );
      ((Element)v.get(202)).setAttribute("y","500" );
      ((Element)v.get(202)).setAttribute("ID","botonContenido" );
      ((Element)v.get(202)).setAttribute("img","avanzar_on" );
      ((Element)v.get(202)).setAttribute("tipo","0" );
      ((Element)v.get(202)).setAttribute("estado","false" );
      ((Element)v.get(202)).setAttribute("alt","" );
      ((Element)v.get(202)).setAttribute("codigo","" );
      ((Element)v.get(202)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(200)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:200   */
      /* Termina nodo:156   */

      /* Empieza nodo:203 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(203)).setAttribute("nombre","primera1" );
      ((Element)v.get(203)).setAttribute("x","20" );
      ((Element)v.get(203)).setAttribute("y","500" );
      ((Element)v.get(203)).setAttribute("ID","botonContenido" );
      ((Element)v.get(203)).setAttribute("img","primera_on" );
      ((Element)v.get(203)).setAttribute("tipo","-2" );
      ((Element)v.get(203)).setAttribute("estado","false" );
      ((Element)v.get(203)).setAttribute("alt","" );
      ((Element)v.get(203)).setAttribute("codigo","" );
      ((Element)v.get(203)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(9)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */

      /* Empieza nodo:204 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(204)).setAttribute("nombre","separa" );
      ((Element)v.get(204)).setAttribute("x","59" );
      ((Element)v.get(204)).setAttribute("y","496" );
      ((Element)v.get(204)).setAttribute("ID","botonContenido" );
      ((Element)v.get(204)).setAttribute("img","separa_base" );
      ((Element)v.get(204)).setAttribute("tipo","0" );
      ((Element)v.get(204)).setAttribute("estado","false" );
      ((Element)v.get(204)).setAttribute("alt","" );
      ((Element)v.get(204)).setAttribute("codigo","" );
      ((Element)v.get(204)).setAttribute("accion","" );
      ((Element)v.get(9)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */

      /* Empieza nodo:205 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(205)).setAttribute("nombre","btnModificar" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(205)).setAttribute("x","80" );
      ((Element)v.get(205)).setAttribute("y","497" );
      ((Element)v.get(205)).setAttribute("ID","botonContenido" );
      ((Element)v.get(205)).setAttribute("tipo","html" );
      ((Element)v.get(205)).setAttribute("estado","false" );
      ((Element)v.get(205)).setAttribute("cod","2" );
      ((Element)v.get(205)).setAttribute("accion","onClickModificar()" );
      ((Element)v.get(205)).setAttribute("ontab","focaliza('formulario.txtCodPlantilla')" );
      ((Element)v.get(205)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnBuscar')" );
      ((Element)v.get(9)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */

      /* Empieza nodo:206 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(206)).setAttribute("nombre","btnCopiar" );
      ((Element)v.get(206)).setAttribute("x","80" );
      ((Element)v.get(206)).setAttribute("y","497" );
      ((Element)v.get(206)).setAttribute("ID","botonContenido" );
      ((Element)v.get(206)).setAttribute("tipo","html" );
      ((Element)v.get(206)).setAttribute("estado","false" );
      ((Element)v.get(206)).setAttribute("cod","721" );
      ((Element)v.get(206)).setAttribute("accion","onClickCopiar()" );
      ((Element)v.get(206)).setAttribute("ontab","focaliza('formulario.txtCodPlantilla')" );
      ((Element)v.get(206)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnBuscar')" );
      ((Element)v.get(9)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */

      /* Empieza nodo:207 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(207)).setAttribute("nombre","btnDetalle" );
      ((Element)v.get(207)).setAttribute("x","80" );
      ((Element)v.get(207)).setAttribute("y","497" );
      ((Element)v.get(207)).setAttribute("ID","botonContenido" );
      ((Element)v.get(207)).setAttribute("tipo","html" );
      ((Element)v.get(207)).setAttribute("estado","false" );
      ((Element)v.get(207)).setAttribute("cod","3" );
      ((Element)v.get(207)).setAttribute("accion","onClickDetalle()" );
      ((Element)v.get(207)).setAttribute("ontab","focaliza('formulario.txtCodPlantilla')" );
      ((Element)v.get(207)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnBuscar')" );
      ((Element)v.get(9)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */

      /* Empieza nodo:208 / Elemento padre: 9   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(208)).setAttribute("nombre","capaEspacio" );
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
      ((Element)v.get(208)).setAttribute("y","519" );
      ((Element)v.get(208)).setAttribute("zindex","" );
      ((Element)v.get(9)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:9   */


   }

}


import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_usuarios_cobranzas_modificar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_usuarios_cobranzas_modificar" );
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
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Elemento padre:4 / Elemento actual: 5   */
      v.add(doc.createTextNode("\r   \r\r  function onLoadPag()   \r  { configurarMenuSecundario(\"formulario\");\r	ocultaLista1();\r	document.all[\"btnModificarDiv\"].style.visibility='hidden';\r    document.all[\"btnDetalleDiv\"].style.visibility='hidden';\r    eval(ON_RSZ);	\r	fMostrarMensajeError();	  \r	focaliza(\"formulario.txtCodUsuario\");\r	btnProxy(1,0);\r  }\r\r   function onClickBuscar() \r   {\r	 configurarPaginado(mipgndo,'COBObtenerUsuariosCob',\r	                            'ConectorObtenerUsuariosCob',\r								'es.indra.sicc.dtos.cob.DTOBuscarUsuariosCob', armarArray());	 \r	 muestraLista1();\r\r\r	 \r	 \r   }\r\r   function a()\r	{\r	   return;\r	}\r   \r   function armarArray() \r   {\r     var vArray = new Array();\r	 var i = 0;\r	 vArray[i] = new Array('codUsuario',(get('formulario.txtCodUsuario')).toUpperCase());\r	 i++;\r	 vArray[i] = new Array('nombre1',get('formulario.txtNombre1'));\r	 i++;\r	 vArray[i] = new Array('nombre2',get('formulario.txtNombre2'));\r	 i++;\r	 vArray[i] = new Array('apellido1',get('formulario.txtApellido1'));\r	 i++;\r	 vArray[i] = new Array('apellido2',get('formulario.txtApellido2'));\r	 i++;\r	 vArray[i] = new Array('oidEstadoUsuario',get('formulario.cbEstadoUsuario'));\r	 	 return vArray; \r   }\r      \r   function onClickModificar()    {\r       /*Si solo se ha seleccionado un registro{ \r			Mostrar ventana modal y emergente y Llamar a la LPUsuariosCobranzas con: \r			- accion=\"modificar usuario\" \r			- oidUsuarioCob \r			- idUsuario \r			- codUsuario \r			- nombre \r			}otro caso{ mostrar el error correspondiente } */\r       if(listado1.numSelecc() == 1)\r	   {                  var arrAux = new Array();\r			 var obj = new Object();\r			 arrAux = listado1.codSeleccionados();\r			 var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);\r			 var oid = listado1.datos[posicion][0];\r			 var codUsuario = listado1.datos[posicion][1];\r			 var nombre = listado1.datos[posicion][2];\r			 var idUsuario = listado1.datos[posicion][3];\r			 var casoDeUso = get('formulario.casoDeUso');\r			 obj.oid = oid;\r			 obj.codUsuario = codUsuario;\r			 obj.nombre = nombre;\r			 obj.idUsuario = idUsuario;\r			 obj.casoDeUso = casoDeUso;\r			 var vWnd = mostrarModalSICC('LPInsertarUsuariosCobranzas','modificar usuario',obj);\r			 			 if(vWnd == 'LIMPIAR')\r               onClickModificar();\r			 else\r			   onClickBuscar();\r       }\r	   else\r	   {  if(listado1.numSelecc() > 1)\r	         cdos_mostrarAlert(GestionarMensaje(\"240\"));          \r		  else\r		  {  if(listado1.numSelecc() < 1)\r                 GestionarMensaje(\"4\");\r          }\r       }\r   }\r   \r   \r   function onClickDetalle()    {\r      /*Si solo se ha seleccionado un registro de la lstResultados: \r		Se muestra la ventana emergente y modal PgUsuariosCobranzas y \r		Llama a la LPUsuariosCobranzas con: \r		- accion=\"detalle usuario\" \r		- oid del registro seleccionado \r		- idUsuario \r		- codUsuario \r		- nombre \r		}otro caso{  mostrar el error correspondiente } */\r	   if(listado1.numSelecc() == 1)\r	   {  	 var pos = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);			\r             var obj = new Object();\r			 obj.oid = listado1.datos[pos][0];\r			 			 obj.codUsuario = listado1.datos[pos][1];\r			 obj.nombre = listado1.datos[pos][2];\r			 obj.idUsuario = listado1.datos[pos][3];\r			 obj.casoDeUso = get('formulario.casoDeUso');\r			 var vWnd = mostrarModalSICC('LPUsuariosCobranzas','detalle usuario',obj);\r	   }\r	   else\r	   {  if(listado1.numSelecc() > 1)\r		    cdos_mostrarAlert(GestionarMensaje(\"240\"));		  \r		  else\r		  {  if(listado1.numSelecc() < 1)\r				 GestionarMensaje(\"4\");\r		  }\r	   }\r   }\r\r   function fBorrar() \r   {\r	  if(listado1.numSelecc() < 1)\r         GestionarMensaje(\"4\");       else\r	  {\r				eliminarFilas(listado1.codSeleccionados(),'COBEliminarUsuariosCobranzas',mipgndo);\r			  }\r   }\r\r   function fLimpiar()\r   {     \r	   var arr = new Array();  arr[0] = \"\";\r	   set('formulario.cbEstadoUsuario', arr);\r	   set('formulario.txtNombre1',\"\");\r	   set('formulario.txtNombre2',\"\");\r	   set('formulario.txtApellido1',\"\");\r	   set('formulario.txtApellido1',\"\");\r       set('formulario.txtCodUsuario',\"\");\r       focaliza('formulario.txtCodUsuario');\r   }\r\r   function muestraLista( ultima, rowset, error)\r   {	var tamano = rowset.length;\r		if (tamano > 0)\r		{  muestraLista1();\r		   if(get('formulario.casoDeUso') == 'modificar')\r				document.all[\"btnModificarDiv\"].style.visibility='visible';\r		   if(get('formulario.casoDeUso') == 'consultar')\r				document.all[\"btnDetalleDiv\"].style.visibility='visible';\r		   eval (ON_RSZ);      \r		   return true;\r		}\r		else \r		{  ocultaLista1();\r		   if(get('formulario.casoDeUso') == 'modificar')\r				document.all[\"btnModificarDiv\"].style.visibility='hidden';\r		   if(get('formulario.casoDeUso') == 'consultar')\r				document.all[\"btnDetalleDiv\"].style.visibility='hidden';\r		   eval (ON_RSZ);                      \r		   return false;\r		}\r   }\r\r   function muestraLista1()\r   {\r		DrdEnsanchaConMargenDcho('listado1',12);	    \r	    document.all[\"Cplistado1\"].style.visibility='';\r	    document.all[\"CpLin1listado1\"].style.visibility='';\r	    document.all[\"CpLin2listado1\"].style.visibility='';\r	    document.all[\"CpLin3listado1\"].style.visibility='';\r	    document.all[\"CpLin4listado1\"].style.visibility='';\r	    document.all[\"primera1Div\"].style.visibility='';\r	    document.all[\"ret1Div\"].style.visibility='';\r	    document.all[\"ava1Div\"].style.visibility='';\r	    document.all[\"separaDiv\"].style.visibility='';\r	}\r\r\r	function ocultaLista1()\r	{\r		DrdEnsanchaConMargenDcho('listado1',12);	    \r	    document.all[\"Cplistado1\"].style.visibility='hidden';\r	    document.all[\"CpLin1listado1\"].style.visibility='hidden';\r	    document.all[\"CpLin2listado1\"].style.visibility='hidden';\r	    document.all[\"CpLin3listado1\"].style.visibility='hidden';\r	    document.all[\"CpLin4listado1\"].style.visibility='hidden';\r	    document.all[\"primera1Div\"].style.visibility='hidden';\r	    document.all[\"ret1Div\"].style.visibility='hidden';\r	    document.all[\"ava1Div\"].style.visibility='hidden';\r	    document.all[\"separaDiv\"].style.visibility='hidden';\r	}\r\r	function toDetalle()\r	{\r	   if(document.all[\"btnModificarDiv\"].style.visibility == 'visible')           \r		   focalizaBotonHTML('botonContenido', 'btnModificar'); \r	   else\r	   {\r           if(document.all[\"btnDetalleDiv\"].style.visibility == 'visible')\r		     focalizaBotonHTML('botonContenido','btnDetalle');\r		   else\r		   {\r		     if(arguments[0])\r			     focalizaBotonHTML('botonContenido','btnBuscar');\r			 else\r		         focaliza('formulario.txtCodUsuario');\r		   }\r	   }\r	}\r\r   \r"));
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
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","accion" );
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
      ((Element)v.get(12)).setAttribute("nombre","oidIdioma" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","oidPais" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","idUsuario" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","estadoAnterior" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","oidEstadoUsuario" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("table"));
      ((Element)v.get(18)).setAttribute("width","100%" );
      ((Element)v.get(18)).setAttribute("border","0" );
      ((Element)v.get(18)).setAttribute("cellspacing","0" );
      ((Element)v.get(18)).setAttribute("cellpadding","0" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("td"));
      ((Element)v.get(20)).setAttribute("width","12" );
      ((Element)v.get(20)).setAttribute("align","center" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(21)).setAttribute("src","b.gif" );
      ((Element)v.get(21)).setAttribute("width","12" );
      ((Element)v.get(21)).setAttribute("height","12" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */
      /* Termina nodo:20   */

      /* Empieza nodo:22 / Elemento padre: 19   */
      v.add(doc.createElement("td"));
      ((Element)v.get(22)).setAttribute("width","750" );
      ((Element)v.get(19)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(23)).setAttribute("src","b.gif" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */
      /* Termina nodo:22   */

      /* Empieza nodo:24 / Elemento padre: 19   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).setAttribute("width","12" );
      ((Element)v.get(19)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(25)).setAttribute("width","12" );
      ((Element)v.get(25)).setAttribute("height","1" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */
      /* Termina nodo:19   */

      /* Empieza nodo:26 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:29 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(31)).setAttribute("class","legend" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(32)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(32)).setAttribute("alto","13" );
      ((Element)v.get(32)).setAttribute("filas","1" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(32)).setAttribute("id","legend" );
      ((Element)v.get(32)).setAttribute("cod","0075" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:33 / Elemento padre: 30   */
      v.add(doc.createElement("table"));
      ((Element)v.get(33)).setAttribute("width","100%" );
      ((Element)v.get(33)).setAttribute("border","0" );
      ((Element)v.get(33)).setAttribute("align","center" );
      ((Element)v.get(33)).setAttribute("cellspacing","0" );
      ((Element)v.get(33)).setAttribute("cellpadding","0" );
      ((Element)v.get(30)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("table"));
      ((Element)v.get(36)).setAttribute("width","647" );
      ((Element)v.get(36)).setAttribute("border","0" );
      ((Element)v.get(36)).setAttribute("align","left" );
      ((Element)v.get(36)).setAttribute("cellspacing","0" );
      ((Element)v.get(36)).setAttribute("cellpadding","0" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).setAttribute("colspan","4" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).setAttribute("width","8" );
      ((Element)v.get(39)).setAttribute("height","8" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:40 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).setAttribute("width","8" );
      ((Element)v.get(42)).setAttribute("height","8" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:43 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(44)).setAttribute("nombre","lblCodUsuario" );
      ((Element)v.get(44)).setAttribute("alto","13" );
      ((Element)v.get(44)).setAttribute("filas","1" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(44)).setAttribute("id","datosTitle" );
      ((Element)v.get(44)).setAttribute("cod","825" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","25" );
      ((Element)v.get(46)).setAttribute("height","8" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(48)).setAttribute("nombre","lblEstado" );
      ((Element)v.get(48)).setAttribute("alto","13" );
      ((Element)v.get(48)).setAttribute("filas","1" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(48)).setAttribute("id","datosTitle" );
      ((Element)v.get(48)).setAttribute("cod","400" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).setAttribute("width","100%" );
      ((Element)v.get(40)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(50)).setAttribute("width","8" );
      ((Element)v.get(50)).setAttribute("height","8" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */
      /* Termina nodo:40   */

      /* Empieza nodo:51 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","8" );
      ((Element)v.get(53)).setAttribute("height","8" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(51)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(55)).setAttribute("nombre","txtCodUsuario" );
      ((Element)v.get(55)).setAttribute("id","datosCampos" );
      ((Element)v.get(55)).setAttribute("max","20" );
      ((Element)v.get(55)).setAttribute("tipo","" );
      ((Element)v.get(55)).setAttribute("onchange","" );
      ((Element)v.get(55)).setAttribute("req","N" );
      ((Element)v.get(55)).setAttribute("size","26" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(55)).setAttribute("validacion","" );
      ((Element)v.get(55)).setAttribute("onshtab","toDetalle(true)" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","25" );
      ((Element)v.get(57)).setAttribute("height","8" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(51)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(59)).setAttribute("nombre","cbEstadoUsuario" );
      ((Element)v.get(59)).setAttribute("id","datosCampos" );
      ((Element)v.get(59)).setAttribute("size","1" );
      ((Element)v.get(59)).setAttribute("multiple","N" );
      ((Element)v.get(59)).setAttribute("req","N" );
      ((Element)v.get(59)).setAttribute("valorinicial","" );
      ((Element)v.get(59)).setAttribute("textoinicial","" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:61 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).setAttribute("width","100%" );
      ((Element)v.get(51)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","8" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:51   */

      /* Empieza nodo:63 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).setAttribute("colspan","4" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","8" );
      ((Element)v.get(65)).setAttribute("height","8" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:36   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:66 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("table"));
      ((Element)v.get(68)).setAttribute("width","647" );
      ((Element)v.get(68)).setAttribute("border","0" );
      ((Element)v.get(68)).setAttribute("align","left" );
      ((Element)v.get(68)).setAttribute("cellspacing","0" );
      ((Element)v.get(68)).setAttribute("cellpadding","0" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("tr"));
   }

   private void getXML270(Document doc) {
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
      ((Element)v.get(73)).setAttribute("nombre","lblNombre1" );
      ((Element)v.get(73)).setAttribute("alto","13" );
      ((Element)v.get(73)).setAttribute("filas","1" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(73)).setAttribute("id","datosTitle" );
      ((Element)v.get(73)).setAttribute("cod","93" );
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
      ((Element)v.get(77)).setAttribute("nombre","lblNombre2" );
      ((Element)v.get(77)).setAttribute("alto","13" );
      ((Element)v.get(77)).setAttribute("filas","1" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(77)).setAttribute("id","datosTitle" );
      ((Element)v.get(77)).setAttribute("cod","94" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","25" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(81)).setAttribute("nombre","lblApellido1" );
      ((Element)v.get(81)).setAttribute("alto","13" );
      ((Element)v.get(81)).setAttribute("filas","1" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(81)).setAttribute("id","datosTitle" );
      ((Element)v.get(81)).setAttribute("cod","16" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","25" );
      ((Element)v.get(83)).setAttribute("height","8" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(85)).setAttribute("nombre","lblApellido2" );
      ((Element)v.get(85)).setAttribute("alto","13" );
      ((Element)v.get(85)).setAttribute("filas","1" );
      ((Element)v.get(85)).setAttribute("valor","" );
      ((Element)v.get(85)).setAttribute("id","datosTitle" );
      ((Element)v.get(85)).setAttribute("cod","17" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).setAttribute("width","100%" );
      ((Element)v.get(69)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).setAttribute("width","8" );
      ((Element)v.get(87)).setAttribute("height","8" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:69   */

      /* Empieza nodo:88 / Elemento padre: 68   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(68)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","8" );
      ((Element)v.get(90)).setAttribute("height","8" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(88)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("CTEXTO"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(92)).setAttribute("nombre","txtNombre1" );
      ((Element)v.get(92)).setAttribute("id","datosCampos" );
      ((Element)v.get(92)).setAttribute("max","25" );
      ((Element)v.get(92)).setAttribute("tipo","" );
      ((Element)v.get(92)).setAttribute("onchange","" );
      ((Element)v.get(92)).setAttribute("req","N" );
      ((Element)v.get(92)).setAttribute("size","25" );
      ((Element)v.get(92)).setAttribute("valor","" );
      ((Element)v.get(92)).setAttribute("validacion","" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","25" );
      ((Element)v.get(94)).setAttribute("height","8" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(96)).setAttribute("nombre","txtNombre2" );
      ((Element)v.get(96)).setAttribute("id","datosCampos" );
      ((Element)v.get(96)).setAttribute("max","25" );
      ((Element)v.get(96)).setAttribute("tipo","" );
      ((Element)v.get(96)).setAttribute("onchange","" );
      ((Element)v.get(96)).setAttribute("req","N" );
      ((Element)v.get(96)).setAttribute("size","25" );
      ((Element)v.get(96)).setAttribute("valor","" );
      ((Element)v.get(96)).setAttribute("validacion","" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).setAttribute("width","25" );
      ((Element)v.get(98)).setAttribute("height","8" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(88)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(100)).setAttribute("nombre","txtApellido1" );
      ((Element)v.get(100)).setAttribute("id","datosCampos" );
      ((Element)v.get(100)).setAttribute("max","25" );
      ((Element)v.get(100)).setAttribute("tipo","" );
      ((Element)v.get(100)).setAttribute("onchange","" );
      ((Element)v.get(100)).setAttribute("req","N" );
      ((Element)v.get(100)).setAttribute("size","25" );
      ((Element)v.get(100)).setAttribute("valor","" );
      ((Element)v.get(100)).setAttribute("validacion","" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).setAttribute("width","25" );
      ((Element)v.get(102)).setAttribute("height","8" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(104)).setAttribute("nombre","txtApellido2" );
      ((Element)v.get(104)).setAttribute("id","datosCampos" );
      ((Element)v.get(104)).setAttribute("max","25" );
      ((Element)v.get(104)).setAttribute("tipo","" );
      ((Element)v.get(104)).setAttribute("onchange","" );
      ((Element)v.get(104)).setAttribute("req","N" );
      ((Element)v.get(104)).setAttribute("size","25" );
      ((Element)v.get(104)).setAttribute("valor","" );
      ((Element)v.get(104)).setAttribute("validacion","" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).setAttribute("width","100%" );
      ((Element)v.get(88)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","8" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:88   */

      /* Empieza nodo:107 / Elemento padre: 68   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(68)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("colspan","4" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","8" );
      ((Element)v.get(109)).setAttribute("height","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:33   */
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:110 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(26)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:26   */

      /* Empieza nodo:112 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("table"));
      ((Element)v.get(117)).setAttribute("width","100%" );
      ((Element)v.get(117)).setAttribute("border","0" );
      ((Element)v.get(117)).setAttribute("align","center" );
      ((Element)v.get(117)).setAttribute("cellspacing","0" );
      ((Element)v.get(117)).setAttribute("cellpadding","0" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).setAttribute("class","botonera" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(120)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(120)).setAttribute("ID","botonContenido" );
      ((Element)v.get(120)).setAttribute("tipo","html" );
      ((Element)v.get(120)).setAttribute("accion","onClickBuscar()" );
      ((Element)v.get(120)).setAttribute("estado","false" );
      ((Element)v.get(120)).setAttribute("cod","1" );
      ((Element)v.get(120)).setAttribute("ontab","toDetalle()" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:121 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","8" );
      ((Element)v.get(122)).setAttribute("height","12" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:112   */

      /* Empieza nodo:123 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).setAttribute("width","12" );
      ((Element)v.get(124)).setAttribute("align","center" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).setAttribute("width","12" );
      ((Element)v.get(125)).setAttribute("height","12" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:126 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).setAttribute("width","756" );
      ((Element)v.get(123)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:128 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).setAttribute("width","12" );
      ((Element)v.get(123)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","12" );
      ((Element)v.get(129)).setAttribute("height","1" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:123   */
      /* Termina nodo:18   */

      /* Empieza nodo:130 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(130)).setAttribute("nombre","listado1" );
      ((Element)v.get(130)).setAttribute("ancho","651" );
      ((Element)v.get(130)).setAttribute("alto","301" );
      ((Element)v.get(130)).setAttribute("x","12" );
      ((Element)v.get(130)).setAttribute("y","163" );
      ((Element)v.get(130)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(130)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(131)).setAttribute("precarga","S" );
      ((Element)v.get(131)).setAttribute("conROver","S" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(132)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(132)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(132)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(132)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */

      /* Empieza nodo:133 / Elemento padre: 131   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(133)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(133)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(133)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(133)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(131)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 131   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(134)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(134)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(131)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:131   */

      /* Empieza nodo:135 / Elemento padre: 130   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(130)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(136)).setAttribute("borde","1" );
      ((Element)v.get(136)).setAttribute("horizDatos","1" );
      ((Element)v.get(136)).setAttribute("horizCabecera","1" );
      ((Element)v.get(136)).setAttribute("vertical","0" );
      ((Element)v.get(136)).setAttribute("horizTitulo","1" );
      ((Element)v.get(136)).setAttribute("horizBase","1" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */

      /* Empieza nodo:137 / Elemento padre: 135   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(137)).setAttribute("borde","#999999" );
      ((Element)v.get(137)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(137)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(137)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(137)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(137)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(137)).setAttribute("horizBase","#999999" );
      ((Element)v.get(135)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:135   */

      /* Empieza nodo:138 / Elemento padre: 130   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(138)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(138)).setAttribute("alto","22" );
      ((Element)v.get(138)).setAttribute("imgFondo","" );
      ((Element)v.get(138)).setAttribute("cod","00135" );
      ((Element)v.get(138)).setAttribute("ID","datosTitle" );
      ((Element)v.get(130)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 130   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(139)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(139)).setAttribute("alto","22" );
      ((Element)v.get(139)).setAttribute("imgFondo","" );
      ((Element)v.get(130)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 130   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(140)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(140)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(140)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(140)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(140)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(140)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(130)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(141)).setAttribute("ancho","30" );
      ((Element)v.get(141)).setAttribute("minimizable","S" );
      ((Element)v.get(141)).setAttribute("minimizada","N" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(142)).setAttribute("ancho","100" );
      ((Element)v.get(142)).setAttribute("minimizable","S" );
      ((Element)v.get(142)).setAttribute("minimizada","N" );
      ((Element)v.get(140)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 140   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(143)).setAttribute("ancho","30" );
      ((Element)v.get(143)).setAttribute("minimizable","S" );
      ((Element)v.get(143)).setAttribute("minimizada","N" );
      ((Element)v.get(143)).setAttribute("oculta","S" );
      ((Element)v.get(140)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:140   */

      /* Empieza nodo:144 / Elemento padre: 130   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(144)).setAttribute("alto","20" );
      ((Element)v.get(144)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(144)).setAttribute("imgFondo","" );
      ((Element)v.get(144)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(130)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(145)).setAttribute("colFondo","" );
      ((Element)v.get(145)).setAttribute("ID","EstCab" );
      ((Element)v.get(145)).setAttribute("cod","825" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */

      /* Empieza nodo:146 / Elemento padre: 144   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(146)).setAttribute("colFondo","" );
      ((Element)v.get(146)).setAttribute("ID","EstCab" );
      ((Element)v.get(146)).setAttribute("cod","1039" );
      ((Element)v.get(144)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */

      /* Empieza nodo:147 / Elemento padre: 144   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(147)).setAttribute("colFondo","" );
      ((Element)v.get(147)).setAttribute("ID","EstCab" );
      ((Element)v.get(144)).appendChild((Element)v.get(147));

      /* Elemento padre:147 / Elemento actual: 148   */
      v.add(doc.createTextNode("idUsuario"));
      ((Element)v.get(147)).appendChild((Text)v.get(148));

      /* Termina nodo Texto:148   */
      /* Termina nodo:147   */
      /* Termina nodo:144   */

      /* Empieza nodo:149 / Elemento padre: 130   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(149)).setAttribute("alto","22" );
      ((Element)v.get(149)).setAttribute("accion","" );
      ((Element)v.get(149)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(149)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(149)).setAttribute("maxSel","-1" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(149)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(149)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(149)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(149)).setAttribute("onLoad","" );
      ((Element)v.get(149)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(130)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(150)).setAttribute("tipo","texto" );
      ((Element)v.get(150)).setAttribute("ID","EstDat" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */

      /* Empieza nodo:151 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(151)).setAttribute("tipo","texto" );
      ((Element)v.get(151)).setAttribute("ID","EstDat2" );
      ((Element)v.get(149)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */

      /* Empieza nodo:152 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(152)).setAttribute("tipo","texto" );
      ((Element)v.get(152)).setAttribute("ID","EstDat" );
      ((Element)v.get(149)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:149   */

      /* Empieza nodo:153 / Elemento padre: 130   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(130)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 130   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(154)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(154)).setAttribute("ancho","651" );
      ((Element)v.get(154)).setAttribute("sep","$" );
      ((Element)v.get(154)).setAttribute("x","12" );
      ((Element)v.get(154)).setAttribute("class","botonera" );
      ((Element)v.get(154)).setAttribute("y","441" );
      ((Element)v.get(154)).setAttribute("control","|" );
      ((Element)v.get(154)).setAttribute("conector","" );
      ((Element)v.get(154)).setAttribute("rowset","" );
      ((Element)v.get(154)).setAttribute("cargainicial","N" );
      ((Element)v.get(154)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(130)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(155)).setAttribute("nombre","ret1" );
      ((Element)v.get(155)).setAttribute("x","37" );
      ((Element)v.get(155)).setAttribute("y","445" );
      ((Element)v.get(155)).setAttribute("ID","botonContenido" );
      ((Element)v.get(155)).setAttribute("img","retroceder_on" );
      ((Element)v.get(155)).setAttribute("tipo","0" );
      ((Element)v.get(155)).setAttribute("estado","false" );
      ((Element)v.get(155)).setAttribute("alt","" );
      ((Element)v.get(155)).setAttribute("codigo","" );
      ((Element)v.get(155)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */

      /* Empieza nodo:156 / Elemento padre: 154   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(156)).setAttribute("nombre","ava1" );
      ((Element)v.get(156)).setAttribute("x","52" );
      ((Element)v.get(156)).setAttribute("y","445" );
      ((Element)v.get(156)).setAttribute("ID","botonContenido" );
      ((Element)v.get(156)).setAttribute("img","avanzar_on" );
      ((Element)v.get(156)).setAttribute("tipo","0" );
      ((Element)v.get(156)).setAttribute("estado","false" );
      ((Element)v.get(156)).setAttribute("alt","" );
      ((Element)v.get(156)).setAttribute("codigo","" );
      ((Element)v.get(156)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(154)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:154   */
      /* Termina nodo:130   */

      /* Empieza nodo:157 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(157)).setAttribute("nombre","primera1" );
      ((Element)v.get(157)).setAttribute("x","20" );
      ((Element)v.get(157)).setAttribute("y","445" );
      ((Element)v.get(157)).setAttribute("ID","botonContenido" );
      ((Element)v.get(157)).setAttribute("img","primera_on" );
      ((Element)v.get(157)).setAttribute("tipo","-2" );
      ((Element)v.get(157)).setAttribute("estado","false" );
      ((Element)v.get(157)).setAttribute("alt","" );
      ((Element)v.get(157)).setAttribute("codigo","" );
      ((Element)v.get(157)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */

      /* Empieza nodo:158 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(158)).setAttribute("nombre","separa" );
      ((Element)v.get(158)).setAttribute("x","59" );
      ((Element)v.get(158)).setAttribute("y","441" );
      ((Element)v.get(158)).setAttribute("ID","botonContenido" );
      ((Element)v.get(158)).setAttribute("img","separa_base" );
      ((Element)v.get(158)).setAttribute("tipo","0" );
      ((Element)v.get(158)).setAttribute("estado","false" );
      ((Element)v.get(158)).setAttribute("alt","" );
      ((Element)v.get(158)).setAttribute("codigo","" );
      ((Element)v.get(158)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */

      /* Empieza nodo:159 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(159)).setAttribute("nombre","btnModificar" );
      ((Element)v.get(159)).setAttribute("x","80" );
      ((Element)v.get(159)).setAttribute("y","442" );
      ((Element)v.get(159)).setAttribute("ID","botonContenido" );
      ((Element)v.get(159)).setAttribute("tipo","html" );
      ((Element)v.get(159)).setAttribute("estado","false" );
      ((Element)v.get(159)).setAttribute("cod","2" );
      ((Element)v.get(159)).setAttribute("accion","onClickModificar()" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(159)).setAttribute("ontab","focaliza('formulario.txtCodUsuario')" );
      ((Element)v.get(159)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnBuscar')" );
      ((Element)v.get(6)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */

      /* Empieza nodo:160 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(160)).setAttribute("nombre","btnDetalle" );
      ((Element)v.get(160)).setAttribute("x","80" );
      ((Element)v.get(160)).setAttribute("y","442" );
      ((Element)v.get(160)).setAttribute("ID","botonContenido" );
      ((Element)v.get(160)).setAttribute("tipo","html" );
      ((Element)v.get(160)).setAttribute("estado","false" );
      ((Element)v.get(160)).setAttribute("cod","3" );
      ((Element)v.get(160)).setAttribute("accion","onClickDetalle()" );
      ((Element)v.get(160)).setAttribute("ontab","focaliza('formulario.txtCodUsuario')" );
      ((Element)v.get(160)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnBuscar')" );
      ((Element)v.get(6)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */

      /* Empieza nodo:161 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(161)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(161)).setAttribute("alto","12" );
      ((Element)v.get(161)).setAttribute("ancho","100" );
      ((Element)v.get(161)).setAttribute("colorf","" );
      ((Element)v.get(161)).setAttribute("borde","0" );
      ((Element)v.get(161)).setAttribute("imagenf","" );
      ((Element)v.get(161)).setAttribute("repeat","" );
      ((Element)v.get(161)).setAttribute("padding","" );
      ((Element)v.get(161)).setAttribute("visibilidad","visible" );
      ((Element)v.get(161)).setAttribute("contravsb","" );
      ((Element)v.get(161)).setAttribute("x","0" );
      ((Element)v.get(161)).setAttribute("y","464" );
      ((Element)v.get(161)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:6   */


   }

}

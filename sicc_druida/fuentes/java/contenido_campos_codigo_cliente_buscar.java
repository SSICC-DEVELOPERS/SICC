
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_campos_codigo_cliente_buscar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_campos_codigo_cliente_buscar" );
      ((Element)v.get(0)).setAttribute("cod","0638" );
      ((Element)v.get(0)).setAttribute("titulo","Buscar campos código de cliente" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Buscar campos código de cliente" );
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
      v.add(doc.createTextNode("\r   \r\r	function ocultaCapas(){\r	    document.all[\"Cplistado1\"].style.visibility='hidden';\r	    document.all[\"CpLin1listado1\"].style.visibility='hidden';\r	    document.all[\"CpLin2listado1\"].style.visibility='hidden';\r	    document.all[\"CpLin3listado1\"].style.visibility='hidden';\r	    document.all[\"CpLin4listado1\"].style.visibility='hidden';\r	    document.all[\"primera1Div\"].style.visibility='hidden';\r	    document.all[\"ret1Div\"].style.visibility='hidden';\r	    document.all[\"ava1Div\"].style.visibility='hidden';\r	    document.all[\"separaDiv\"].style.visibility='hidden';\r	    document.all[\"AceptarDiv\"].style.visibility='hidden';\r	}\r	\r	function muestraCapas(){\r		document.all[\"Cplistado1\"].style.visibility='';\r		document.all[\"CpLin1listado1\"].style.visibility='';\r		document.all[\"CpLin2listado1\"].style.visibility='';\r		document.all[\"CpLin3listado1\"].style.visibility='';\r		document.all[\"CpLin4listado1\"].style.visibility='';\r		document.all[\"primera1Div\"].style.visibility='';\r		document.all[\"ret1Div\"].style.visibility='';\r		document.all[\"ava1Div\"].style.visibility='';\r		document.all[\"separaDiv\"].style.visibility='';\r		document.all[\"AceptarDiv\"].style.visibility='';\r	}\r	\r	function muestraLista( ultima, rowset){\r		var tamano = rowset.length;\r		if (tamano > 0) {\r			muestraCapas();\r			eval (ON_RSZ);\r			focaliza('frmBusquedaRapidaCliente.txtCodCliente','');\r			return true;\r		} else {\r			ocultaCapas();	    \r         focaliza('frmBusquedaRapidaCliente.txtCodCliente','');\r		  	return false;\r		}\r	}\r	\r  function fVolver(){\r  	this.close();\r  }\r  \r  function onLoadPag()   {\r    configurarMenuSecundario(\"frmBusquedaRapidaCliente\");\r    btnProxy(2, '1');\r    btnProxy(3, '0');\r    \r    DrdEnsanchaConMargenDcho('listado1',12);\r    \r	 ocultaCapas();\r\r    eval (ON_RSZ);  \r	focaliza(\"frmBusquedaRapidaCliente.txtCodCliente\");\r   }\r\r   function checkTableShTab(){\r		  if(document.all[\"Cplistado1\"].style.visibility == 'hidden') \r			  focalizaBotonHTML('botonContenido','btnBuscar');\r			else focalizaBotonHTML('botonContenido','Aceptar');\r	}\r\r	function checkTableTab(){\r			if(document.all[\"Cplistado1\"].style.visibility == 'hidden') \r			  focaliza('frmBusquedaRapidaCliente.txtCodCliente');\r			else focalizaBotonHTML('botonContenido','Aceptar');\r\r		}\r\r   function fLimpiar(){\r	set('frmBusquedaRapidaCliente.txtCodCliente','');\r	set('frmBusquedaRapidaCliente.txtDNI','');\r	set('frmBusquedaRapidaCliente.txtNombre1','');\r	set('frmBusquedaRapidaCliente.txtNombre2','');\r	set('frmBusquedaRapidaCliente.txtApellido2','');\r	set('frmBusquedaRapidaCliente.txtCriterioBusqueda1','');\r	set('frmBusquedaRapidaCliente.txtCriterioBusqueda2','');\r\r	document.selection.empty();\r	focaliza('frmBusquedaRapidaCliente.txtCodCliente',''); \r	}\r\r	function Buscar2(){\r		set('frmBusquedaRapidaCliente.conectorAction','LPBusquedaRapidaCliente');\r		set('frmBusquedaRapidaCliente.accion','buscar');\r		enviaSICC('frmBusquedaRapidaCliente');\r	}\r	function Buscar(){	\r		var arr = new Array();\r		\r		arr[arr.length]=new Array(\"codigoCliente\",get('frmBusquedaRapidaCliente.txtCodCliente'));\r		arr[arr.length]=new Array(\"documentoIdentidad\",get('frmBusquedaRapidaCliente.txtDNI'));\r		arr[arr.length]=new Array(\"nombre1\",get('frmBusquedaRapidaCliente.txtNombre1'));\r		arr[arr.length]=new Array(\"nombre2\",get('frmBusquedaRapidaCliente.txtNombre2'));\r		arr[arr.length]=new Array(\"apellido1\",get('frmBusquedaRapidaCliente.txtApellido1'));\r		arr[arr.length]=new Array(\"apellido2\",get('frmBusquedaRapidaCliente.txtApellido2'));\r		arr[arr.length]=new Array(\"criterioBusqueda1\",get('frmBusquedaRapidaCliente.txtCriterioBusqueda1'));\r		arr[arr.length]=new Array(\"criterioBusqueda2\",get('frmBusquedaRapidaCliente.txtCriterioBusqueda2'));\r		arr[arr.length]=new Array(\"oidPais\",get('frmBusquedaRapidaCliente.hidOidPais'));\r		arr[arr.length]=new Array(\"oidIdioma\",get('frmBusquedaRapidaCliente.hidOidIdioma'));\r		\r		configurarPaginado(	mipgndo,\r									\"MAEBusquedaRapidaCliente\",\r									\"ConectorBusquedaRapidaCliente\",\r									\"es.indra.sicc.dtos.mae.DTOBusquedaRapidaCliente\",\r									arr\r								);\r	}\r\r	function aceptar(){\r      if (listado1.numSelecc()== 1)\r 	  {		\r		var arrAux = new Array();\r		arrAux = listado1.codSeleccionados();\r		var posicion = obtenerPosicionListaEditable(listado1.codSeleccionados(),listado1);		\r		var arr = new Array();\r		arr[0] = listado1.datos[posicion][0]; 		arr[1] = listado1.datos[posicion][1]; 		arr[2] = listado1.datos[posicion][2]; 		arr[3] = listado1.datos[posicion][3]; 		arr[4] = listado1.datos[posicion][4]; 		arr[5] = listado1.datos[posicion][5]; \r		returnValue = arr;\r		close();\r	  }\r	  else {\r						GestionarMensaje('1487');\r	  }\r}\r   \r\r   \r"));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","frmBusquedaRapidaCliente" );
      ((Element)v.get(6)).setAttribute("oculto","S" );
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
      ((Element)v.get(11)).setAttribute("nombre","exito" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","hidApellido1" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hidApellido2" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hidNombre1" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hidNombre2" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hidCodCliente" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hidDocu" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hidCriterioB1" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hidCriterioB2" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hidOidPais" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hidOidIdioma" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 6   */
      v.add(doc.createElement("table"));
      ((Element)v.get(22)).setAttribute("width","100%" );
      ((Element)v.get(22)).setAttribute("border","0" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("cellspacing","0" );
      ((Element)v.get(22)).setAttribute("cellpadding","0" );
      ((Element)v.get(6)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).setAttribute("width","12" );
      ((Element)v.get(24)).setAttribute("align","center" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(25)).setAttribute("width","12" );
      ((Element)v.get(25)).setAttribute("height","12" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:26 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).setAttribute("width","750" );
      ((Element)v.get(23)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(27)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */

      /* Empieza nodo:28 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(28)).setAttribute("width","12" );
      ((Element)v.get(23)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(29)).setAttribute("src","b.gif" );
      ((Element)v.get(29)).setAttribute("width","12" );
      ((Element)v.get(29)).setAttribute("height","1" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:28   */
      /* Termina nodo:23   */

      /* Empieza nodo:30 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(32)).setAttribute("src","b.gif" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:33 / Elemento padre: 30   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(35)).setAttribute("class","legend" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(36)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(36)).setAttribute("alto","13" );
      ((Element)v.get(36)).setAttribute("filas","1" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(36)).setAttribute("id","legend" );
      ((Element)v.get(36)).setAttribute("cod","0075" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:37 / Elemento padre: 34   */
      v.add(doc.createElement("table"));
      ((Element)v.get(37)).setAttribute("width","100%" );
      ((Element)v.get(37)).setAttribute("border","0" );
      ((Element)v.get(37)).setAttribute("align","center" );
      ((Element)v.get(37)).setAttribute("cellspacing","0" );
      ((Element)v.get(37)).setAttribute("cellpadding","0" );
      ((Element)v.get(34)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("table"));
      ((Element)v.get(40)).setAttribute("width","647" );
      ((Element)v.get(40)).setAttribute("border","0" );
      ((Element)v.get(40)).setAttribute("align","left" );
      ((Element)v.get(40)).setAttribute("cellspacing","0" );
      ((Element)v.get(40)).setAttribute("cellpadding","0" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).setAttribute("colspan","8" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","8" );
      ((Element)v.get(43)).setAttribute("height","8" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:44 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","8" );
      ((Element)v.get(46)).setAttribute("height","8" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(48)).setAttribute("nombre","lblCodCliente" );
      ((Element)v.get(48)).setAttribute("alto","13" );
      ((Element)v.get(48)).setAttribute("filas","1" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(48)).setAttribute("id","datosTitle" );
      ((Element)v.get(48)).setAttribute("cod","263" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(50)).setAttribute("width","25" );
      ((Element)v.get(50)).setAttribute("height","8" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(52)).setAttribute("nombre","lblDNI" );
      ((Element)v.get(52)).setAttribute("alto","13" );
      ((Element)v.get(52)).setAttribute("filas","1" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(52)).setAttribute("id","datosTitle" );
      ((Element)v.get(52)).setAttribute("cod","1364" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).setAttribute("width","100%" );
      ((Element)v.get(44)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(54)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).setAttribute("width","8" );
      ((Element)v.get(54)).setAttribute("height","8" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:44   */

      /* Empieza nodo:55 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","8" );
      ((Element)v.get(57)).setAttribute("height","8" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(55)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(59)).setAttribute("nombre","txtCodCliente" );
      ((Element)v.get(59)).setAttribute("id","datosCampos" );
      ((Element)v.get(59)).setAttribute("max","15" );
      ((Element)v.get(59)).setAttribute("tipo","" );
      ((Element)v.get(59)).setAttribute("onchange","" );
      ((Element)v.get(59)).setAttribute("req","N" );
      ((Element)v.get(59)).setAttribute("size","15" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(59)).setAttribute("validacion","" );
      ((Element)v.get(59)).setAttribute("onshtab","checkTableShTab();" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","25" );
      ((Element)v.get(61)).setAttribute("height","8" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(55)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(63)).setAttribute("nombre","txtDNI" );
      ((Element)v.get(63)).setAttribute("id","datosCampos" );
      ((Element)v.get(63)).setAttribute("max","30" );
      ((Element)v.get(63)).setAttribute("tipo","" );
      ((Element)v.get(63)).setAttribute("onchange","" );
      ((Element)v.get(63)).setAttribute("req","N" );
      ((Element)v.get(63)).setAttribute("size","40" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(63)).setAttribute("validacion","" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).setAttribute("width","100%" );
      ((Element)v.get(55)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","8" );
      ((Element)v.get(65)).setAttribute("height","8" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:55   */

      /* Empieza nodo:66 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("colspan","9" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","8" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:40   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:69 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("table"));
      ((Element)v.get(71)).setAttribute("width","647" );
      ((Element)v.get(71)).setAttribute("border","0" );
      ((Element)v.get(71)).setAttribute("align","left" );
      ((Element)v.get(71)).setAttribute("cellspacing","0" );
      ((Element)v.get(71)).setAttribute("cellpadding","0" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","8" );
      ((Element)v.get(74)).setAttribute("height","8" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(76)).setAttribute("nombre","lblNombre1" );
      ((Element)v.get(76)).setAttribute("alto","13" );
      ((Element)v.get(76)).setAttribute("filas","1" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(76)).setAttribute("id","datosTitle" );
      ((Element)v.get(76)).setAttribute("cod","93" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","25" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(80)).setAttribute("nombre","lblNombre2" );
      ((Element)v.get(80)).setAttribute("alto","13" );
      ((Element)v.get(80)).setAttribute("filas","1" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(80)).setAttribute("id","datosTitle" );
      ((Element)v.get(80)).setAttribute("cod","94" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","25" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(84)).setAttribute("nombre","lblApellido1" );
      ((Element)v.get(84)).setAttribute("alto","13" );
      ((Element)v.get(84)).setAttribute("filas","1" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(84)).setAttribute("id","datosTitle" );
      ((Element)v.get(84)).setAttribute("cod","16" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","25" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(88)).setAttribute("nombre","lblApellido2" );
      ((Element)v.get(88)).setAttribute("alto","13" );
      ((Element)v.get(88)).setAttribute("filas","1" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(88)).setAttribute("id","datosTitle" );
      ((Element)v.get(88)).setAttribute("cod","17" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("width","100%" );
      ((Element)v.get(72)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","8" );
      ((Element)v.get(90)).setAttribute("height","8" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:72   */

      /* Empieza nodo:91 / Elemento padre: 71   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(71)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","8" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(91)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(95)).setAttribute("nombre","txtNombre1" );
      ((Element)v.get(95)).setAttribute("id","datosCampos" );
      ((Element)v.get(95)).setAttribute("max","25" );
      ((Element)v.get(95)).setAttribute("tipo","" );
      ((Element)v.get(95)).setAttribute("onchange","" );
      ((Element)v.get(95)).setAttribute("req","N" );
      ((Element)v.get(95)).setAttribute("size","25" );
      ((Element)v.get(95)).setAttribute("valor","" );
      ((Element)v.get(95)).setAttribute("validacion","" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","25" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(91)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(99)).setAttribute("nombre","txtNombre2" );
      ((Element)v.get(99)).setAttribute("id","datosCampos" );
      ((Element)v.get(99)).setAttribute("max","25" );
      ((Element)v.get(99)).setAttribute("tipo","" );
      ((Element)v.get(99)).setAttribute("onchange","" );
      ((Element)v.get(99)).setAttribute("req","N" );
      ((Element)v.get(99)).setAttribute("size","25" );
      ((Element)v.get(99)).setAttribute("valor","" );
      ((Element)v.get(99)).setAttribute("validacion","" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","25" );
      ((Element)v.get(101)).setAttribute("height","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(91)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(103)).setAttribute("nombre","txtApellido1" );
      ((Element)v.get(103)).setAttribute("id","datosCampos" );
      ((Element)v.get(103)).setAttribute("max","25" );
      ((Element)v.get(103)).setAttribute("tipo","" );
      ((Element)v.get(103)).setAttribute("onchange","" );
      ((Element)v.get(103)).setAttribute("req","N" );
      ((Element)v.get(103)).setAttribute("size","25" );
      ((Element)v.get(103)).setAttribute("valor","" );
      ((Element)v.get(103)).setAttribute("validacion","" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","25" );
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(91)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(107)).setAttribute("nombre","txtApellido2" );
      ((Element)v.get(107)).setAttribute("id","datosCampos" );
      ((Element)v.get(107)).setAttribute("max","25" );
      ((Element)v.get(107)).setAttribute("tipo","" );
      ((Element)v.get(107)).setAttribute("onchange","" );
      ((Element)v.get(107)).setAttribute("req","N" );
      ((Element)v.get(107)).setAttribute("size","25" );
      ((Element)v.get(107)).setAttribute("valor","" );
      ((Element)v.get(107)).setAttribute("validacion","" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 91   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("width","100%" );
      ((Element)v.get(91)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","8" );
      ((Element)v.get(109)).setAttribute("height","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:91   */

      /* Empieza nodo:110 / Elemento padre: 71   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(71)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("colspan","9" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).setAttribute("width","8" );
      ((Element)v.get(112)).setAttribute("height","8" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:113 / Elemento padre: 37   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(37)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("table"));
      ((Element)v.get(115)).setAttribute("width","647" );
      ((Element)v.get(115)).setAttribute("border","0" );
      ((Element)v.get(115)).setAttribute("align","left" );
      ((Element)v.get(115)).setAttribute("cellspacing","0" );
      ((Element)v.get(115)).setAttribute("cellpadding","0" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","8" );
      ((Element)v.get(118)).setAttribute("height","8" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(120)).setAttribute("nombre","lblCriterioBusqueda1" );
      ((Element)v.get(120)).setAttribute("alto","13" );
      ((Element)v.get(120)).setAttribute("filas","1" );
      ((Element)v.get(120)).setAttribute("valor","" );
      ((Element)v.get(120)).setAttribute("id","datosTitle" );
      ((Element)v.get(120)).setAttribute("cod","2208" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","25" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(124)).setAttribute("nombre","lblCriterioBusqueda2" );
      ((Element)v.get(124)).setAttribute("alto","13" );
      ((Element)v.get(124)).setAttribute("filas","1" );
      ((Element)v.get(124)).setAttribute("valor","" );
      ((Element)v.get(124)).setAttribute("id","datosTitle" );
      ((Element)v.get(124)).setAttribute("cod","2209" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).setAttribute("width","100%" );
      ((Element)v.get(116)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","8" );
      ((Element)v.get(126)).setAttribute("height","8" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:116   */

      /* Empieza nodo:127 / Elemento padre: 115   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(115)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","8" );
      ((Element)v.get(129)).setAttribute("height","8" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(127)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(131)).setAttribute("nombre","txtCriterioBusqueda1" );
      ((Element)v.get(131)).setAttribute("id","datosCampos" );
      ((Element)v.get(131)).setAttribute("max","50" );
      ((Element)v.get(131)).setAttribute("tipo","" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(131)).setAttribute("onchange","" );
      ((Element)v.get(131)).setAttribute("req","N" );
      ((Element)v.get(131)).setAttribute("size","50" );
      ((Element)v.get(131)).setAttribute("valor","" );
      ((Element)v.get(131)).setAttribute("validacion","" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","25" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(127)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(135)).setAttribute("nombre","txtCriterioBusqueda2" );
      ((Element)v.get(135)).setAttribute("id","datosCampos" );
      ((Element)v.get(135)).setAttribute("max","50" );
      ((Element)v.get(135)).setAttribute("tipo","" );
      ((Element)v.get(135)).setAttribute("onchange","" );
      ((Element)v.get(135)).setAttribute("req","N" );
      ((Element)v.get(135)).setAttribute("size","50" );
      ((Element)v.get(135)).setAttribute("valor","" );
      ((Element)v.get(135)).setAttribute("validacion","" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).setAttribute("width","100%" );
      ((Element)v.get(127)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","8" );
      ((Element)v.get(137)).setAttribute("height","8" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:127   */

      /* Empieza nodo:138 / Elemento padre: 115   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(115)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).setAttribute("colspan","9" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","8" );
      ((Element)v.get(140)).setAttribute("height","8" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:37   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:141 / Elemento padre: 30   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:30   */

      /* Empieza nodo:143 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:146 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("table"));
      ((Element)v.get(148)).setAttribute("width","100%" );
      ((Element)v.get(148)).setAttribute("border","0" );
      ((Element)v.get(148)).setAttribute("align","center" );
      ((Element)v.get(148)).setAttribute("cellspacing","0" );
      ((Element)v.get(148)).setAttribute("cellpadding","0" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).setAttribute("class","botonera" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(151)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(151)).setAttribute("ID","botonContenido" );
      ((Element)v.get(151)).setAttribute("tipo","html" );
      ((Element)v.get(151)).setAttribute("accion","Buscar();" );
      ((Element)v.get(151)).setAttribute("estado","false" );
      ((Element)v.get(151)).setAttribute("cod","1" );
      ((Element)v.get(151)).setAttribute("ontab","checkTableTab();" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:152 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","8" );
      ((Element)v.get(153)).setAttribute("height","12" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:143   */

      /* Empieza nodo:154 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(22)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).setAttribute("width","12" );
      ((Element)v.get(155)).setAttribute("align","center" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","12" );
      ((Element)v.get(156)).setAttribute("height","12" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).setAttribute("width","756" );
      ((Element)v.get(154)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).setAttribute("width","12" );
      ((Element)v.get(154)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).setAttribute("width","12" );
      ((Element)v.get(160)).setAttribute("height","1" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */
      /* Termina nodo:154   */
      /* Termina nodo:22   */

      /* Empieza nodo:161 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(161)).setAttribute("nombre","listado1" );
      ((Element)v.get(161)).setAttribute("ancho","651" );
      ((Element)v.get(161)).setAttribute("alto","317" );
      ((Element)v.get(161)).setAttribute("x","12" );
      ((Element)v.get(161)).setAttribute("y","204" );
      ((Element)v.get(161)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(161)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(162)).setAttribute("precarga","S" );
      ((Element)v.get(162)).setAttribute("conROver","S" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(163)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(163)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(163)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(163)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */

      /* Empieza nodo:164 / Elemento padre: 162   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(164)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(164)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(164)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(164)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(162)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */

      /* Empieza nodo:165 / Elemento padre: 162   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(165)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(165)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(162)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:162   */

      /* Empieza nodo:166 / Elemento padre: 161   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(161)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(167)).setAttribute("borde","1" );
      ((Element)v.get(167)).setAttribute("horizDatos","1" );
      ((Element)v.get(167)).setAttribute("horizCabecera","1" );
      ((Element)v.get(167)).setAttribute("vertical","1" );
      ((Element)v.get(167)).setAttribute("horizTitulo","1" );
      ((Element)v.get(167)).setAttribute("horizBase","1" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 166   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(168)).setAttribute("borde","#999999" );
      ((Element)v.get(168)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(168)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(168)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(168)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(168)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(168)).setAttribute("horizBase","#999999" );
      ((Element)v.get(166)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:166   */

      /* Empieza nodo:169 / Elemento padre: 161   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(169)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(169)).setAttribute("alto","22" );
      ((Element)v.get(169)).setAttribute("imgFondo","" );
      ((Element)v.get(169)).setAttribute("cod","00135" );
      ((Element)v.get(169)).setAttribute("ID","datosTitle" );
      ((Element)v.get(161)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */

      /* Empieza nodo:170 / Elemento padre: 161   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(170)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(170)).setAttribute("alto","22" );
      ((Element)v.get(170)).setAttribute("imgFondo","" );
      ((Element)v.get(161)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 161   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(171)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(171)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(171)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(171)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(171)).setAttribute("AnchoMinimizadas","20" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(171)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(161)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(172)).setAttribute("ancho","50" );
      ((Element)v.get(172)).setAttribute("minimizable","S" );
      ((Element)v.get(172)).setAttribute("minimizada","N" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */

      /* Empieza nodo:173 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(173)).setAttribute("ancho","50" );
      ((Element)v.get(173)).setAttribute("minimizable","S" );
      ((Element)v.get(173)).setAttribute("minimizada","N" );
      ((Element)v.get(171)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */

      /* Empieza nodo:174 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(174)).setAttribute("ancho","50" );
      ((Element)v.get(174)).setAttribute("minimizable","S" );
      ((Element)v.get(174)).setAttribute("minimizada","N" );
      ((Element)v.get(171)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(175)).setAttribute("ancho","50" );
      ((Element)v.get(175)).setAttribute("minimizable","S" );
      ((Element)v.get(175)).setAttribute("minimizada","N" );
      ((Element)v.get(171)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */

      /* Empieza nodo:176 / Elemento padre: 171   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(176)).setAttribute("ancho","50" );
      ((Element)v.get(176)).setAttribute("minimizable","S" );
      ((Element)v.get(176)).setAttribute("minimizada","N" );
      ((Element)v.get(171)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:171   */

      /* Empieza nodo:177 / Elemento padre: 161   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(177)).setAttribute("alto","20" );
      ((Element)v.get(177)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(177)).setAttribute("imgFondo","" );
      ((Element)v.get(177)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(177)).setAttribute("ajustarAMitadInf","S" );
      ((Element)v.get(161)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(178)).setAttribute("colFondo","" );
      ((Element)v.get(178)).setAttribute("ID","EstCab" );
      ((Element)v.get(178)).setAttribute("align","center" );
      ((Element)v.get(178)).setAttribute("cod","263" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Elemento padre:178 / Elemento actual: 179   */
      v.add(doc.createTextNode("Cód. cliente"));
      ((Element)v.get(178)).appendChild((Text)v.get(179));

      /* Termina nodo Texto:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(180)).setAttribute("colFondo","" );
      ((Element)v.get(180)).setAttribute("ID","EstCab" );
      ((Element)v.get(180)).setAttribute("cod","93" );
      ((Element)v.get(177)).appendChild((Element)v.get(180));

      /* Elemento padre:180 / Elemento actual: 181   */
      v.add(doc.createTextNode("Nombre 1"));
      ((Element)v.get(180)).appendChild((Text)v.get(181));

      /* Termina nodo Texto:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(182)).setAttribute("colFondo","" );
      ((Element)v.get(182)).setAttribute("ID","EstCab" );
      ((Element)v.get(182)).setAttribute("cod","94" );
      ((Element)v.get(177)).appendChild((Element)v.get(182));

      /* Elemento padre:182 / Elemento actual: 183   */
      v.add(doc.createTextNode("Nombre 2"));
      ((Element)v.get(182)).appendChild((Text)v.get(183));

      /* Termina nodo Texto:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(184)).setAttribute("colFondo","" );
      ((Element)v.get(184)).setAttribute("ID","EstCab" );
      ((Element)v.get(184)).setAttribute("cod","16" );
      ((Element)v.get(177)).appendChild((Element)v.get(184));

      /* Elemento padre:184 / Elemento actual: 185   */
      v.add(doc.createTextNode("Apellido 1"));
      ((Element)v.get(184)).appendChild((Text)v.get(185));

      /* Termina nodo Texto:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 177   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(186)).setAttribute("colFondo","" );
      ((Element)v.get(186)).setAttribute("ID","EstCab" );
      ((Element)v.get(186)).setAttribute("cod","17" );
      ((Element)v.get(177)).appendChild((Element)v.get(186));

      /* Elemento padre:186 / Elemento actual: 187   */
      v.add(doc.createTextNode("Apellido 2"));
      ((Element)v.get(186)).appendChild((Text)v.get(187));

      /* Termina nodo Texto:187   */
      /* Termina nodo:186   */
      /* Termina nodo:177   */

      /* Empieza nodo:188 / Elemento padre: 161   */
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
      ((Element)v.get(161)).appendChild((Element)v.get(188));

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
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(191)).setAttribute("tipo","texto" );
      ((Element)v.get(191)).setAttribute("ID","EstDat" );
      ((Element)v.get(188)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */

      /* Empieza nodo:192 / Elemento padre: 188   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(192)).setAttribute("tipo","texto" );
      ((Element)v.get(192)).setAttribute("ID","EstDat2" );
      ((Element)v.get(188)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */

      /* Empieza nodo:193 / Elemento padre: 188   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(193)).setAttribute("tipo","texto" );
      ((Element)v.get(193)).setAttribute("ID","EstDat" );
      ((Element)v.get(188)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:188   */

      /* Empieza nodo:194 / Elemento padre: 161   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(161)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */

      /* Empieza nodo:195 / Elemento padre: 161   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(195)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(195)).setAttribute("ancho","651" );
      ((Element)v.get(195)).setAttribute("sep","$" );
      ((Element)v.get(195)).setAttribute("x","12" );
      ((Element)v.get(195)).setAttribute("class","botonera" );
      ((Element)v.get(195)).setAttribute("y","499" );
      ((Element)v.get(195)).setAttribute("control","|" );
      ((Element)v.get(195)).setAttribute("conector","" );
      ((Element)v.get(195)).setAttribute("rowset","" );
      ((Element)v.get(195)).setAttribute("cargainicial","N" );
      ((Element)v.get(195)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(161)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(196)).setAttribute("nombre","ret1" );
      ((Element)v.get(196)).setAttribute("x","37" );
      ((Element)v.get(196)).setAttribute("y","503" );
      ((Element)v.get(196)).setAttribute("ID","botonContenido" );
      ((Element)v.get(196)).setAttribute("img","retroceder_on" );
      ((Element)v.get(196)).setAttribute("tipo","0" );
      ((Element)v.get(196)).setAttribute("estado","false" );
      ((Element)v.get(196)).setAttribute("alt","" );
      ((Element)v.get(196)).setAttribute("codigo","" );
      ((Element)v.get(196)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */

      /* Empieza nodo:197 / Elemento padre: 195   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(197)).setAttribute("nombre","ava1" );
      ((Element)v.get(197)).setAttribute("x","52" );
      ((Element)v.get(197)).setAttribute("y","503" );
      ((Element)v.get(197)).setAttribute("ID","botonContenido" );
      ((Element)v.get(197)).setAttribute("img","avanzar_on" );
      ((Element)v.get(197)).setAttribute("tipo","0" );
      ((Element)v.get(197)).setAttribute("estado","false" );
      ((Element)v.get(197)).setAttribute("alt","" );
      ((Element)v.get(197)).setAttribute("codigo","" );
      ((Element)v.get(197)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(195)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:195   */
      /* Termina nodo:161   */

      /* Empieza nodo:198 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(198)).setAttribute("nombre","primera1" );
      ((Element)v.get(198)).setAttribute("x","20" );
      ((Element)v.get(198)).setAttribute("y","503" );
      ((Element)v.get(198)).setAttribute("ID","botonContenido" );
      ((Element)v.get(198)).setAttribute("img","primera_on" );
      ((Element)v.get(198)).setAttribute("tipo","-2" );
      ((Element)v.get(198)).setAttribute("estado","false" );
      ((Element)v.get(198)).setAttribute("alt","" );
      ((Element)v.get(198)).setAttribute("codigo","" );
      ((Element)v.get(198)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */

      /* Empieza nodo:199 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(199)).setAttribute("nombre","separa" );
      ((Element)v.get(199)).setAttribute("x","59" );
      ((Element)v.get(199)).setAttribute("y","498" );
      ((Element)v.get(199)).setAttribute("ID","botonContenido" );
      ((Element)v.get(199)).setAttribute("img","separa_base" );
      ((Element)v.get(199)).setAttribute("tipo","0" );
      ((Element)v.get(199)).setAttribute("estado","false" );
      ((Element)v.get(199)).setAttribute("alt","" );
      ((Element)v.get(199)).setAttribute("codigo","" );
      ((Element)v.get(199)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */

      /* Empieza nodo:200 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(200)).setAttribute("nombre","Aceptar" );
      ((Element)v.get(200)).setAttribute("x","80" );
      ((Element)v.get(200)).setAttribute("y","499" );
      ((Element)v.get(200)).setAttribute("ID","botonContenido" );
      ((Element)v.get(200)).setAttribute("tipo","html" );
      ((Element)v.get(200)).setAttribute("estado","false" );
      ((Element)v.get(200)).setAttribute("accion","aceptar();" );
      ((Element)v.get(200)).setAttribute("cod","12" );
      ((Element)v.get(200)).setAttribute("ontab","focaliza('frmBusquedaRapidaCliente.txtCodCliente');" );
      ((Element)v.get(200)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnBuscar');" );
      ((Element)v.get(6)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */

      /* Empieza nodo:201 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(201)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(201)).setAttribute("alto","12" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(201)).setAttribute("ancho","100%" );
      ((Element)v.get(201)).setAttribute("colorf","" );
      ((Element)v.get(201)).setAttribute("borde","0" );
      ((Element)v.get(201)).setAttribute("imagenf","" );
      ((Element)v.get(201)).setAttribute("repeat","" );
      ((Element)v.get(201)).setAttribute("padding","" );
      ((Element)v.get(201)).setAttribute("visibilidad","visible" );
      ((Element)v.get(201)).setAttribute("contravsb","" );
      ((Element)v.get(201)).setAttribute("x","0" );
      ((Element)v.get(201)).setAttribute("y","522" );
      ((Element)v.get(201)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:6   */


   }

}

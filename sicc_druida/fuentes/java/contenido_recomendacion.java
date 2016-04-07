
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_recomendacion  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML1080(doc);
         

      getXML1170(doc);
         

      getXML1260(doc);
         

      getXML1350(doc);
         

      getXML1440(doc);
         

      getXML1530(doc);
         

      getXML1620(doc);
         

      getXML1710(doc);
         

      getXML1800(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_recomendacion" );
      ((Element)v.get(0)).setAttribute("cod","0945" );
      ((Element)v.get(0)).setAttribute("titulo","Consulta general de concursos" );
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
      v.add(doc.createTextNode("\r     \r \r	function onLoadPag() {\r	    configurarMenuSecundario(\"frmFormulario\");\r		configurarBotones();\r		asignarLabels();\r\r				if(get(\"frmFormulario.ocultaCabecera\") == \"true\") {\r			document.all[\"capaEspacio2\"].style.visibility= \"hidden\";\r			document.all[\"PedidosRecomendadas\"].style.visibility= \"hidden\";\r						document.all[\"PedidosRecomendante\"].style.visibility= \"hidden\";\r						listado1.alternaVerColumna(16,false);\r		}\r\r		if(get(\"frmFormulario.ocultaColumnas\") == \"true\") {\r						listado1.alternaVerColumna(4,false);\r			listado1.alternaVerColumna(5,false);\r		}	\r		cargarLista();\r	}\r\r	function fVolver() {\r		window.close();\r	}\r\r	function configurarBotones() {\r		 btnProxy(2,'1');\r 		 btnProxy(3,'0');\r  		 btnProxy(5,'0');\r		 btnProxy(7,'0');\r		 btnProxy(8,'0');\r		 btnProxy(9,'0');\r	}\r	\r	function mostrarListaResultados() {		\r		DrdEnsanchaConMargenDcho('listado1',12);	    \r	    document.all[\"Cplistado1\"].style.visibility='';\r	    document.all[\"CpLin1listado1\"].style.visibility='';\r	    document.all[\"CpLin2listado1\"].style.visibility='';\r	    document.all[\"CpLin3listado1\"].style.visibility='';\r	    document.all[\"CpLin4listado1\"].style.visibility='';\r	    document.all[\"primera1Div\"].style.visibility='';\r	    document.all[\"ret1Div\"].style.visibility='';\r	    document.all[\"ava1Div\"].style.visibility='';\r	    document.all[\"separaDiv\"].style.visibility='';\r	    eval (ON_RSZ); \r	}\r\r	function mostrarListaResultados2() {		\r		DrdEnsanchaConMargenDcho('listado2',12);	    \r	    document.all[\"Cplistado2\"].style.visibility='';\r	    document.all[\"CpLin1listado2\"].style.visibility='';\r	    document.all[\"CpLin2listado2\"].style.visibility='';\r	    document.all[\"CpLin3listado2\"].style.visibility='';\r	    document.all[\"CpLin4listado2\"].style.visibility='';\r	    document.all[\"primera2Div\"].style.visibility='';\r	    document.all[\"ret2Div\"].style.visibility='';\r	    document.all[\"ava2Div\"].style.visibility='';\r	    document.all[\"separa2Div\"].style.visibility='';\r	    eval (ON_RSZ); \r	}\r\r	function mostrarListaResultados3() {		\r		DrdEnsanchaConMargenDcho('listado3',12);	    \r	    document.all[\"Cplistado3\"].style.visibility='';\r	    document.all[\"CpLin1listado3\"].style.visibility='';\r	    document.all[\"CpLin2listado3\"].style.visibility='';\r	    document.all[\"CpLin3listado3\"].style.visibility='';\r	    document.all[\"CpLin4listado3\"].style.visibility='';\r	    document.all[\"primera3Div\"].style.visibility='';\r	    document.all[\"ret3Div\"].style.visibility='';\r	    document.all[\"ava3Div\"].style.visibility='';\r	    document.all[\"separa3Div\"].style.visibility='';\r	    eval (ON_RSZ); \r	}\r\r	function cargarLista() {\r		var arr = new Array();\r		arr[arr.length] = new Array(\"oidCliente\", get(\"frmFormulario.oidCliente\")+\"\");\r		arr[arr.length] = new Array(\"oidPais\", get(\"frmFormulario.oidPais\")+\"\");\r		arr[arr.length] = new Array(\"oidIdioma\", get(\"frmFormulario.oidIdioma\")+\"\");\r\r		if (get(\"frmFormulario.accion\") == \"consultarRecomendacionPart\") { \r			arr[arr.length] = new Array(\"oidConcurso\", get(\"frmFormulario.oidConcurso\")+\"\");\r			arr[arr.length] = new Array(\"numeroConcurso\", get(\"frmFormulario.numeroConcurso\")+\"\");\r			arr[arr.length] = new Array(\"oidRegion\", get(\"frmFormulario.oidRegion\")+\"\"); \r			arr[arr.length] = new Array(\"oidZona\", get(\"frmFormulario.oidZona\")+\"\");\r			arr[arr.length] = new Array(\"oidSeccion\", get(\"frmFormulario.oidSeccion\")+\"\"); \r		}\r		\r		configurarPaginado(mipgndo,\"INCConsultarDetalleRecomendacion\", \r		\"ConectorConsultarDetalleRecomendacion\",\r		\"es.indra.sicc.dtos.inc.DTOCabeceraConsultaIntegral\",arr);		\r\r		if (get(\"frmFormulario.accion\") == \"consultarRecomendacionPart\") { \r\r			configurarPaginado(mipgndo2,\"INCConsultarDetallePedidosRecomendadas\", \r			\"ConectorConsultarDetallePedidosRecomendadas\",\r			\"es.indra.sicc.dtos.inc.DTOCabeceraConsultaIntegral\",arr);	\r\r            			configurarPaginadoExt(mipgndo3,\"INCConsultarDetallePedidosRecomendante\", \r			\"ConectorConsultarDetallePedidosRecomendante\",\r			\"es.indra.sicc.dtos.inc.DTOCabeceraConsultaIntegral\",arr, 0, 4);	\r		}\r	}\r\r	function asignarLabels() {\r		txt_to('lbldtDescripcion', get(\"frmFormulario.laDescripcionConcurso\"));\r		txt_to('lbldtNumConcurso', get(\"frmFormulario.laNumeroConcurso\"));\r		txt_to('lbldtCodClienteRecomendante', get(\"frmFormulario.laCodigoCliente\"));\r		txt_to('lbldtNombreApellido', get(\"frmFormulario.laNombreApellidos\"));\r\r        		if (get(\"frmFormulario.accion\") == \"consultarRecomendacionPart\") { \r			txt_to('lbldtNumPedSolicitadosRecomendada', get(\"frmFormulario.numPedSolicitadosRecomendada\"));\r			txt_to('lbldtNumPedSolicitadosRecomendante', get(\"frmFormulario.numPedSolicitadosRecomendante\"));\r			txt_to('lbldtMontoPedSolicitadosRecomendada', get(\"frmFormulario.montoPedSolicitadosRecomendada\"));\r			txt_to('lbldtPeriodoInicio', get(\"frmFormulario.periodoInicio\"));\r			txt_to('lbldtPeriodoFin', get(\"frmFormulario.periodoFin\"));\r			txt_to('lbldtMontoMinRecomendada', get(\"frmFormulario.montoMinRecomendada\"));\r		}\r    }\r\r\r	function muestraLista(ultima, rowset, error){\r		mostrarListaResultados();\r		return true;\r	}\r\r    	function muestraLista2(ultima, rowset, error){\r		mostrarListaResultados2();\r		return true;\r	}\r\r		function muestraLista3(ultima, rowset, error){\r		mostrarListaResultados3();\r		return true;\r	}\r\r  \r  "));
      ((Element)v.get(4)).appendChild((Text)v.get(5));

      /* Termina nodo Texto:5   */
      /* Termina nodo:4   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","frmFormulario" );
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
      ((Element)v.get(11)).setAttribute("nombre","laDescripcionConcurso" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","laNumeroConcurso" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","oidConcurso" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","oidRegion" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","oidZona" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","oidSeccion" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","numPedSolicitadosRecomendada" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","numPedSolicitadosRecomendante" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","montoPedSolicitadosRecomendada" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","periodoInicio" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","periodoFin" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","montoMinRecomendada" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 6   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","laCodigoCliente" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","laNombreApellidos" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","oidCliente" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","oidPais" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","oidIdioma" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","ocultaCabecera" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","ocultaColumnas" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(30)).setAttribute("nombre","capaEspacio1" );
      ((Element)v.get(30)).setAttribute("x","0" );
      ((Element)v.get(30)).setAttribute("y","0" );
      ((Element)v.get(6)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("table"));
      ((Element)v.get(31)).setAttribute("width","100%" );
      ((Element)v.get(31)).setAttribute("border","0" );
      ((Element)v.get(31)).setAttribute("cellspacing","0" );
      ((Element)v.get(31)).setAttribute("cellpadding","0" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).setAttribute("width","12" );
      ((Element)v.get(33)).setAttribute("align","center" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(34)).setAttribute("src","b.gif" );
      ((Element)v.get(34)).setAttribute("width","12" );
      ((Element)v.get(34)).setAttribute("height","12" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:35 / Elemento padre: 32   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).setAttribute("width","750" );
      ((Element)v.get(32)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(36)).setAttribute("src","b.gif" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:37 / Elemento padre: 32   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).setAttribute("width","12" );
      ((Element)v.get(32)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(38)).setAttribute("src","b.gif" );
      ((Element)v.get(38)).setAttribute("width","12" );
      ((Element)v.get(38)).setAttribute("height","1" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */
      /* Termina nodo:32   */

      /* Empieza nodo:39 / Elemento padre: 31   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(44)).setAttribute("class","legend" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(45)).setAttribute("nombre","lblDatosCabecera" );
      ((Element)v.get(45)).setAttribute("alto","13" );
      ((Element)v.get(45)).setAttribute("filas","1" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(45)).setAttribute("id","legend" );
      ((Element)v.get(45)).setAttribute("cod","00156" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 43   */
      v.add(doc.createElement("table"));
      ((Element)v.get(46)).setAttribute("width","100%" );
      ((Element)v.get(46)).setAttribute("border","0" );
      ((Element)v.get(46)).setAttribute("align","center" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(46)).setAttribute("cellspacing","0" );
      ((Element)v.get(46)).setAttribute("cellpadding","0" );
      ((Element)v.get(43)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("table"));
      ((Element)v.get(49)).setAttribute("width","650" );
      ((Element)v.get(49)).setAttribute("border","0" );
      ((Element)v.get(49)).setAttribute("align","left" );
      ((Element)v.get(49)).setAttribute("cellspacing","0" );
      ((Element)v.get(49)).setAttribute("cellpadding","0" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).setAttribute("colspan","3" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(52)).setAttribute("width","8" );
      ((Element)v.get(52)).setAttribute("height","8" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:53 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(53));

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
      ((Element)v.get(53)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(57)).setAttribute("nombre","lblCodClienteRecomendante" );
      ((Element)v.get(57)).setAttribute("alto","13" );
      ((Element)v.get(57)).setAttribute("filas","1" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(57)).setAttribute("id","datosTitle" );
      ((Element)v.get(57)).setAttribute("cod","2901" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("width","100%" );
      ((Element)v.get(53)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","8" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:53   */

      /* Empieza nodo:60 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","8" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(64)).setAttribute("nombre","lbldtCodClienteRecomendante" );
      ((Element)v.get(64)).setAttribute("alto","13" );
      ((Element)v.get(64)).setAttribute("filas","1" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(64)).setAttribute("id","datosCampos" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("width","100%" );
      ((Element)v.get(60)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","8" );
      ((Element)v.get(66)).setAttribute("height","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:60   */

      /* Empieza nodo:67 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).setAttribute("colspan","3" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","8" );
      ((Element)v.get(69)).setAttribute("height","8" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:70 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("table"));
      ((Element)v.get(72)).setAttribute("width","650" );
      ((Element)v.get(72)).setAttribute("border","0" );
      ((Element)v.get(72)).setAttribute("align","left" );
      ((Element)v.get(72)).setAttribute("cellspacing","0" );
      ((Element)v.get(72)).setAttribute("cellpadding","0" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","8" );
      ((Element)v.get(75)).setAttribute("height","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(77)).setAttribute("nombre","lblNombreApellido" );
      ((Element)v.get(77)).setAttribute("alto","13" );
      ((Element)v.get(77)).setAttribute("filas","1" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(77)).setAttribute("id","datosTitle" );
      ((Element)v.get(77)).setAttribute("cod","943" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("width","100%" );
      ((Element)v.get(73)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","8" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:73   */

      /* Empieza nodo:80 / Elemento padre: 72   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(72)).appendChild((Element)v.get(80));

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
      ((Element)v.get(80)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(84)).setAttribute("nombre","lbldtNombreApellido" );
      ((Element)v.get(84)).setAttribute("alto","13" );
      ((Element)v.get(84)).setAttribute("filas","1" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(84)).setAttribute("id","datosCampos" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).setAttribute("width","100%" );
      ((Element)v.get(80)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","8" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:80   */

      /* Empieza nodo:87 / Elemento padre: 72   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(72)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("colspan","3" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","8" );
      ((Element)v.get(89)).setAttribute("height","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:46   */
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:90 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:39   */

      /* Empieza nodo:92 / Elemento padre: 31   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).setAttribute("width","12" );
      ((Element)v.get(93)).setAttribute("align","center" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","12" );
      ((Element)v.get(94)).setAttribute("height","12" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).setAttribute("width","756" );
      ((Element)v.get(92)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).setAttribute("width","12" );
      ((Element)v.get(92)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).setAttribute("width","12" );
      ((Element)v.get(98)).setAttribute("height","1" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:92   */
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:99 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(99)).setAttribute("nombre","capaEspacio2" );
      ((Element)v.get(99)).setAttribute("x","0" );
      ((Element)v.get(99)).setAttribute("y","100" );
      ((Element)v.get(6)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("table"));
      ((Element)v.get(100)).setAttribute("width","100%" );
      ((Element)v.get(100)).setAttribute("border","0" );
      ((Element)v.get(100)).setAttribute("cellspacing","0" );
      ((Element)v.get(100)).setAttribute("cellpadding","0" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).setAttribute("width","12" );
      ((Element)v.get(102)).setAttribute("align","center" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","12" );
      ((Element)v.get(103)).setAttribute("height","12" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("width","750" );
      ((Element)v.get(101)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).setAttribute("width","12" );
      ((Element)v.get(101)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","12" );
      ((Element)v.get(107)).setAttribute("height","1" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:101   */

      /* Empieza nodo:108 / Elemento padre: 100   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(100)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(113)).setAttribute("class","legend" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(114)).setAttribute("nombre","lblDatosConcurso" );
      ((Element)v.get(114)).setAttribute("alto","13" );
      ((Element)v.get(114)).setAttribute("filas","1" );
      ((Element)v.get(114)).setAttribute("valor","" );
      ((Element)v.get(114)).setAttribute("id","legend" );
      ((Element)v.get(114)).setAttribute("cod","00283" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 112   */
      v.add(doc.createElement("table"));
      ((Element)v.get(115)).setAttribute("width","100%" );
      ((Element)v.get(115)).setAttribute("border","0" );
      ((Element)v.get(115)).setAttribute("align","center" );
      ((Element)v.get(115)).setAttribute("cellspacing","0" );
      ((Element)v.get(115)).setAttribute("cellpadding","0" );
      ((Element)v.get(112)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("table"));
      ((Element)v.get(118)).setAttribute("width","650" );
      ((Element)v.get(118)).setAttribute("border","0" );
      ((Element)v.get(118)).setAttribute("align","left" );
      ((Element)v.get(118)).setAttribute("cellspacing","0" );
      ((Element)v.get(118)).setAttribute("cellpadding","0" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(120)).setAttribute("colspan","3" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","8" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:122 / Elemento padre: 118   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(118)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","8" );
      ((Element)v.get(124)).setAttribute("height","8" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(126)).setAttribute("nombre","lblNumConcurso" );
      ((Element)v.get(126)).setAttribute("alto","13" );
      ((Element)v.get(126)).setAttribute("filas","1" );
      ((Element)v.get(126)).setAttribute("valor","" );
      ((Element)v.get(126)).setAttribute("id","datosTitle" );
      ((Element)v.get(126)).setAttribute("cod","1604" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","25" );
      ((Element)v.get(128)).setAttribute("height","8" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(130)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(130)).setAttribute("alto","13" );
      ((Element)v.get(130)).setAttribute("filas","1" );
      ((Element)v.get(130)).setAttribute("valor","" );
      ((Element)v.get(130)).setAttribute("id","datosTitle" );
      ((Element)v.get(130)).setAttribute("cod","9" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).setAttribute("width","100%" );
      ((Element)v.get(122)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(132)).setAttribute("width","8" );
      ((Element)v.get(132)).setAttribute("height","8" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:122   */

      /* Empieza nodo:133 / Elemento padre: 118   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(118)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","8" );
      ((Element)v.get(135)).setAttribute("height","8" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(137)).setAttribute("nombre","lbldtNumConcurso" );
      ((Element)v.get(137)).setAttribute("alto","13" );
      ((Element)v.get(137)).setAttribute("filas","1" );
      ((Element)v.get(137)).setAttribute("valor","" );
      ((Element)v.get(137)).setAttribute("id","datosCampos" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).setAttribute("width","25" );
      ((Element)v.get(139)).setAttribute("height","8" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(141)).setAttribute("nombre","lbldtDescripcion" );
      ((Element)v.get(141)).setAttribute("alto","13" );
      ((Element)v.get(141)).setAttribute("filas","1" );
      ((Element)v.get(141)).setAttribute("valor","" );
      ((Element)v.get(141)).setAttribute("id","datosCampos" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:142 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).setAttribute("width","100%" );
      ((Element)v.get(133)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(143)).setAttribute("width","8" );
      ((Element)v.get(143)).setAttribute("height","8" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:133   */

      /* Empieza nodo:144 / Elemento padre: 118   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(118)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).setAttribute("colspan","3" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","8" );
      ((Element)v.get(146)).setAttribute("height","8" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:147 / Elemento padre: 112   */
      v.add(doc.createElement("table"));
      ((Element)v.get(147)).setAttribute("width","100%" );
      ((Element)v.get(147)).setAttribute("border","0" );
      ((Element)v.get(147)).setAttribute("align","center" );
      ((Element)v.get(147)).setAttribute("cellspacing","0" );
      ((Element)v.get(147)).setAttribute("cellpadding","0" );
      ((Element)v.get(112)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("table"));
      ((Element)v.get(150)).setAttribute("width","650" );
      ((Element)v.get(150)).setAttribute("border","0" );
      ((Element)v.get(150)).setAttribute("align","left" );
      ((Element)v.get(150)).setAttribute("cellspacing","0" );
      ((Element)v.get(150)).setAttribute("cellpadding","0" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).setAttribute("colspan","3" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","8" );
      ((Element)v.get(153)).setAttribute("height","8" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:154 / Elemento padre: 150   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(150)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","8" );
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(158)).setAttribute("nombre","lblNumPedSolicitadosRecomendada" );
      ((Element)v.get(158)).setAttribute("alto","13" );
      ((Element)v.get(158)).setAttribute("filas","1" );
      ((Element)v.get(158)).setAttribute("valor","" );
      ((Element)v.get(158)).setAttribute("id","datosTitle" );
      ((Element)v.get(158)).setAttribute("cod","3378" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).setAttribute("width","25" );
      ((Element)v.get(160)).setAttribute("height","8" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(162)).setAttribute("nombre","lblNumPedSolicitadosRecomendante" );
      ((Element)v.get(162)).setAttribute("alto","13" );
      ((Element)v.get(162)).setAttribute("filas","1" );
      ((Element)v.get(162)).setAttribute("valor","" );
      ((Element)v.get(162)).setAttribute("id","datosTitle" );
      ((Element)v.get(162)).setAttribute("cod","3379" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","25" );
      ((Element)v.get(164)).setAttribute("height","8" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(166)).setAttribute("nombre","lblMontoMinRecomendada" );
      ((Element)v.get(166)).setAttribute("alto","13" );
      ((Element)v.get(166)).setAttribute("filas","1" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(166)).setAttribute("valor","" );
      ((Element)v.get(166)).setAttribute("id","datosTitle" );
      ((Element)v.get(166)).setAttribute("cod","3398" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","25" );
      ((Element)v.get(168)).setAttribute("height","8" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(170)).setAttribute("nombre","lblMontoPedSolicitadosRecomendada" );
      ((Element)v.get(170)).setAttribute("alto","13" );
      ((Element)v.get(170)).setAttribute("filas","1" );
      ((Element)v.get(170)).setAttribute("valor","" );
      ((Element)v.get(170)).setAttribute("id","datosTitle" );
      ((Element)v.get(170)).setAttribute("cod","3380" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).setAttribute("width","100%" );
      ((Element)v.get(154)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).setAttribute("width","8" );
      ((Element)v.get(172)).setAttribute("height","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */
      /* Termina nodo:154   */

      /* Empieza nodo:173 / Elemento padre: 150   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(150)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(175)).setAttribute("src","b.gif" );
      ((Element)v.get(175)).setAttribute("width","8" );
      ((Element)v.get(175)).setAttribute("height","8" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(177)).setAttribute("nombre","lbldtNumPedSolicitadosRecomendada" );
      ((Element)v.get(177)).setAttribute("alto","13" );
      ((Element)v.get(177)).setAttribute("filas","1" );
      ((Element)v.get(177)).setAttribute("valor","" );
      ((Element)v.get(177)).setAttribute("id","datosCampos" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:178 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).setAttribute("width","25" );
      ((Element)v.get(179)).setAttribute("height","8" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(181)).setAttribute("nombre","lbldtNumPedSolicitadosRecomendante" );
      ((Element)v.get(181)).setAttribute("alto","13" );
      ((Element)v.get(181)).setAttribute("filas","1" );
      ((Element)v.get(181)).setAttribute("valor","" );
      ((Element)v.get(181)).setAttribute("id","datosCampos" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(183)).setAttribute("src","b.gif" );
      ((Element)v.get(183)).setAttribute("width","25" );
      ((Element)v.get(183)).setAttribute("height","8" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(185)).setAttribute("nombre","lbldtMontoMinRecomendada" );
      ((Element)v.get(185)).setAttribute("alto","13" );
      ((Element)v.get(185)).setAttribute("filas","1" );
      ((Element)v.get(185)).setAttribute("valor","" );
      ((Element)v.get(185)).setAttribute("id","datosCampos" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(187)).setAttribute("src","b.gif" );
      ((Element)v.get(187)).setAttribute("width","25" );
      ((Element)v.get(187)).setAttribute("height","8" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:188 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(189)).setAttribute("nombre","lbldtMontoPedSolicitadosRecomendada" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(189)).setAttribute("alto","13" );
      ((Element)v.get(189)).setAttribute("filas","1" );
      ((Element)v.get(189)).setAttribute("valor","" );
      ((Element)v.get(189)).setAttribute("id","datosCampos" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).setAttribute("width","100%" );
      ((Element)v.get(173)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(191)).setAttribute("src","b.gif" );
      ((Element)v.get(191)).setAttribute("width","8" );
      ((Element)v.get(191)).setAttribute("height","8" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */
      /* Termina nodo:173   */

      /* Empieza nodo:192 / Elemento padre: 150   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(150)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).setAttribute("colspan","3" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(194)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).setAttribute("width","8" );
      ((Element)v.get(194)).setAttribute("height","8" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:195 / Elemento padre: 147   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(147)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("table"));
      ((Element)v.get(197)).setAttribute("width","650" );
      ((Element)v.get(197)).setAttribute("border","0" );
      ((Element)v.get(197)).setAttribute("align","left" );
      ((Element)v.get(197)).setAttribute("cellspacing","0" );
      ((Element)v.get(197)).setAttribute("cellpadding","0" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).setAttribute("colspan","3" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(200)).setAttribute("src","b.gif" );
      ((Element)v.get(200)).setAttribute("width","8" );
      ((Element)v.get(200)).setAttribute("height","8" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:201 / Elemento padre: 197   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(197)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(203)).setAttribute("src","b.gif" );
      ((Element)v.get(203)).setAttribute("width","8" );
      ((Element)v.get(203)).setAttribute("height","8" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(205)).setAttribute("nombre","lblPeriodoInicio" );
      ((Element)v.get(205)).setAttribute("alto","13" );
      ((Element)v.get(205)).setAttribute("filas","1" );
      ((Element)v.get(205)).setAttribute("valor","" );
      ((Element)v.get(205)).setAttribute("id","datosTitle" );
      ((Element)v.get(205)).setAttribute("cod","1241" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(207)).setAttribute("src","b.gif" );
      ((Element)v.get(207)).setAttribute("width","25" );
      ((Element)v.get(207)).setAttribute("height","8" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(209)).setAttribute("nombre","lblPeriodoFin" );
      ((Element)v.get(209)).setAttribute("alto","13" );
      ((Element)v.get(209)).setAttribute("filas","1" );
      ((Element)v.get(209)).setAttribute("valor","" );
      ((Element)v.get(209)).setAttribute("id","datosTitle" );
      ((Element)v.get(209)).setAttribute("cod","967" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).setAttribute("width","100%" );
      ((Element)v.get(201)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(211)).setAttribute("width","8" );
      ((Element)v.get(211)).setAttribute("height","8" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:201   */

      /* Empieza nodo:212 / Elemento padre: 197   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(197)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(214)).setAttribute("src","b.gif" );
      ((Element)v.get(214)).setAttribute("width","8" );
      ((Element)v.get(214)).setAttribute("height","8" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(216)).setAttribute("nombre","lbldtPeriodoInicio" );
      ((Element)v.get(216)).setAttribute("alto","13" );
      ((Element)v.get(216)).setAttribute("filas","1" );
      ((Element)v.get(216)).setAttribute("valor","" );
      ((Element)v.get(216)).setAttribute("id","datosCampos" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:217 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(218)).setAttribute("src","b.gif" );
      ((Element)v.get(218)).setAttribute("width","25" );
      ((Element)v.get(218)).setAttribute("height","8" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:219 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(220)).setAttribute("nombre","lbldtPeriodoFin" );
      ((Element)v.get(220)).setAttribute("alto","13" );
      ((Element)v.get(220)).setAttribute("filas","1" );
      ((Element)v.get(220)).setAttribute("valor","" );
      ((Element)v.get(220)).setAttribute("id","datosCampos" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:221 / Elemento padre: 212   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).setAttribute("width","100%" );
      ((Element)v.get(212)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(222)).setAttribute("width","8" );
      ((Element)v.get(222)).setAttribute("height","8" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */
      /* Termina nodo:212   */

      /* Empieza nodo:223 / Elemento padre: 197   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(197)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).setAttribute("colspan","3" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(225)).setAttribute("src","b.gif" );
      ((Element)v.get(225)).setAttribute("width","8" );
      ((Element)v.get(225)).setAttribute("height","8" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:197   */
      /* Termina nodo:196   */
      /* Termina nodo:195   */
      /* Termina nodo:147   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:226 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */
      /* Termina nodo:108   */

      /* Empieza nodo:228 / Elemento padre: 100   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(100)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).setAttribute("width","12" );
      ((Element)v.get(229)).setAttribute("align","center" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(230)).setAttribute("width","12" );
      ((Element)v.get(230)).setAttribute("height","12" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).setAttribute("width","756" );
      ((Element)v.get(228)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(232)).setAttribute("src","b.gif" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:233 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(233)).setAttribute("width","12" );
      ((Element)v.get(228)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(234)).setAttribute("src","b.gif" );
      ((Element)v.get(234)).setAttribute("width","12" );
      ((Element)v.get(234)).setAttribute("height","1" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */
      /* Termina nodo:228   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:235 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(235)).setAttribute("nombre","listado1" );
      ((Element)v.get(235)).setAttribute("ancho","664" );
      ((Element)v.get(235)).setAttribute("alto","317" );
      ((Element)v.get(235)).setAttribute("x","12" );
      ((Element)v.get(235)).setAttribute("y","182" );
      ((Element)v.get(235)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(235)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("IMGBOTONES"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(236)).setAttribute("precarga","S" );
      ((Element)v.get(236)).setAttribute("conROver","S" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(237)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(237)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(237)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(237)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */

      /* Empieza nodo:238 / Elemento padre: 236   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(238)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(238)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(238)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(238)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(236)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */

      /* Empieza nodo:239 / Elemento padre: 236   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(239)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(239)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(236)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:236   */

      /* Empieza nodo:240 / Elemento padre: 235   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(235)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(241)).setAttribute("borde","1" );
      ((Element)v.get(241)).setAttribute("horizDatos","1" );
      ((Element)v.get(241)).setAttribute("horizCabecera","1" );
      ((Element)v.get(241)).setAttribute("vertical","1" );
      ((Element)v.get(241)).setAttribute("horizTitulo","1" );
      ((Element)v.get(241)).setAttribute("horizBase","1" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */

      /* Empieza nodo:242 / Elemento padre: 240   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(242)).setAttribute("borde","#999999" );
      ((Element)v.get(242)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(242)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(242)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(242)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(242)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(242)).setAttribute("horizBase","#999999" );
      ((Element)v.get(240)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:240   */

      /* Empieza nodo:243 / Elemento padre: 235   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(243)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(243)).setAttribute("alto","22" );
      ((Element)v.get(243)).setAttribute("imgFondo","" );
      ((Element)v.get(243)).setAttribute("cod","00133" );
      ((Element)v.get(243)).setAttribute("ID","datosTitle" );
      ((Element)v.get(235)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */

      /* Empieza nodo:244 / Elemento padre: 235   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(244)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(244)).setAttribute("alto","22" );
      ((Element)v.get(244)).setAttribute("imgFondo","" );
      ((Element)v.get(235)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */

      /* Empieza nodo:245 / Elemento padre: 235   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(245)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(245)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(245)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(245)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(245)).setAttribute("AnchoMinimizadas","25" );
      ((Element)v.get(245)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(235)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(246)).setAttribute("ancho","100" );
      ((Element)v.get(246)).setAttribute("minimizable","S" );
      ((Element)v.get(246)).setAttribute("minimizada","N" );
      ((Element)v.get(246)).setAttribute("oculta","S" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */

      /* Empieza nodo:247 / Elemento padre: 245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(247)).setAttribute("ancho","100" );
      ((Element)v.get(247)).setAttribute("minimizable","S" );
      ((Element)v.get(247)).setAttribute("minimizada","N" );
      ((Element)v.get(247)).setAttribute("oculta","S" );
      ((Element)v.get(245)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */

      /* Empieza nodo:248 / Elemento padre: 245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(248)).setAttribute("ancho","100" );
      ((Element)v.get(248)).setAttribute("minimizable","S" );
      ((Element)v.get(248)).setAttribute("minimizada","N" );
      ((Element)v.get(245)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */

      /* Empieza nodo:249 / Elemento padre: 245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(249)).setAttribute("ancho","100" );
      ((Element)v.get(249)).setAttribute("minimizable","S" );
      ((Element)v.get(249)).setAttribute("minimizada","N" );
      ((Element)v.get(245)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */

      /* Empieza nodo:250 / Elemento padre: 245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(250)).setAttribute("ancho","100" );
      ((Element)v.get(250)).setAttribute("minimizable","S" );
      ((Element)v.get(250)).setAttribute("minimizada","N" );
      ((Element)v.get(245)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */

      /* Empieza nodo:251 / Elemento padre: 245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(251)).setAttribute("ancho","150" );
      ((Element)v.get(251)).setAttribute("minimizable","S" );
      ((Element)v.get(251)).setAttribute("minimizada","N" );
      ((Element)v.get(245)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */

      /* Empieza nodo:252 / Elemento padre: 245   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(252)).setAttribute("ancho","100" );
      ((Element)v.get(252)).setAttribute("minimizable","S" );
      ((Element)v.get(252)).setAttribute("minimizada","N" );
      ((Element)v.get(245)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */

      /* Empieza nodo:253 / Elemento padre: 245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(253)).setAttribute("ancho","150" );
      ((Element)v.get(253)).setAttribute("minimizable","S" );
      ((Element)v.get(253)).setAttribute("minimizada","N" );
      ((Element)v.get(245)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */

      /* Empieza nodo:254 / Elemento padre: 245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(254)).setAttribute("ancho","150" );
      ((Element)v.get(254)).setAttribute("minimizable","S" );
      ((Element)v.get(254)).setAttribute("minimizada","N" );
      ((Element)v.get(245)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */

      /* Empieza nodo:255 / Elemento padre: 245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(255)).setAttribute("ancho","150" );
      ((Element)v.get(255)).setAttribute("minimizable","S" );
      ((Element)v.get(255)).setAttribute("minimizada","N" );
      ((Element)v.get(245)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */

      /* Empieza nodo:256 / Elemento padre: 245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(256)).setAttribute("ancho","200" );
      ((Element)v.get(256)).setAttribute("minimizable","S" );
      ((Element)v.get(256)).setAttribute("minimizada","N" );
      ((Element)v.get(245)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */

      /* Empieza nodo:257 / Elemento padre: 245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(257)).setAttribute("ancho","200" );
      ((Element)v.get(257)).setAttribute("minimizable","S" );
      ((Element)v.get(257)).setAttribute("minimizada","N" );
      ((Element)v.get(245)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */

      /* Empieza nodo:258 / Elemento padre: 245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(258)).setAttribute("ancho","200" );
      ((Element)v.get(258)).setAttribute("minimizable","S" );
      ((Element)v.get(258)).setAttribute("minimizada","N" );
      ((Element)v.get(245)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */

      /* Empieza nodo:259 / Elemento padre: 245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(259)).setAttribute("ancho","150" );
      ((Element)v.get(259)).setAttribute("minimizable","S" );
      ((Element)v.get(259)).setAttribute("minimizada","N" );
      ((Element)v.get(245)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */

      /* Empieza nodo:260 / Elemento padre: 245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(260)).setAttribute("ancho","100" );
      ((Element)v.get(260)).setAttribute("minimizable","S" );
      ((Element)v.get(260)).setAttribute("minimizada","N" );
      ((Element)v.get(245)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */

      /* Empieza nodo:261 / Elemento padre: 245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(261)).setAttribute("ancho","90" );
      ((Element)v.get(261)).setAttribute("minimizable","S" );
      ((Element)v.get(261)).setAttribute("minimizada","N" );
      ((Element)v.get(245)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */

      /* Empieza nodo:262 / Elemento padre: 245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(262)).setAttribute("ancho","200" );
      ((Element)v.get(262)).setAttribute("minimizable","S" );
      ((Element)v.get(262)).setAttribute("minimizada","N" );
      ((Element)v.get(245)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:245   */

      /* Empieza nodo:263 / Elemento padre: 235   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(263)).setAttribute("alto","20" );
      ((Element)v.get(263)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(263)).setAttribute("imgFondo","" );
      ((Element)v.get(263)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(235)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(264)).setAttribute("colFondo","" );
      ((Element)v.get(264)).setAttribute("ID","EstCab" );
      ((Element)v.get(264)).setAttribute("cod","" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */

      /* Empieza nodo:265 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(265)).setAttribute("colFondo","" );
      ((Element)v.get(265)).setAttribute("ID","EstCab" );
      ((Element)v.get(265)).setAttribute("cod","" );
      ((Element)v.get(263)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */

      /* Empieza nodo:266 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(266)).setAttribute("colFondo","" );
      ((Element)v.get(266)).setAttribute("ID","EstCab" );
      ((Element)v.get(266)).setAttribute("cod","153" );
      ((Element)v.get(263)).appendChild((Element)v.get(266));

      /* Elemento padre:266 / Elemento actual: 267   */
      v.add(doc.createTextNode("Origen"));
      ((Element)v.get(266)).appendChild((Text)v.get(267));

      /* Termina nodo Texto:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:268 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(268)).setAttribute("colFondo","" );
      ((Element)v.get(268)).setAttribute("ID","EstCab" );
      ((Element)v.get(268)).setAttribute("cod","2891" );
      ((Element)v.get(263)).appendChild((Element)v.get(268));

      /* Elemento padre:268 / Elemento actual: 269   */
      v.add(doc.createTextNode("Fecha inscripción"));
      ((Element)v.get(268)).appendChild((Text)v.get(269));

      /* Termina nodo Texto:269   */
      /* Termina nodo:268   */

      /* Empieza nodo:270 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(270)).setAttribute("colFondo","" );
      ((Element)v.get(270)).setAttribute("ID","EstCab" );
      ((Element)v.get(270)).setAttribute("cod","1604" );
      ((Element)v.get(263)).appendChild((Element)v.get(270));

      /* Elemento padre:270 / Elemento actual: 271   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createTextNode("Nro Concurso"));
      ((Element)v.get(270)).appendChild((Text)v.get(271));

      /* Termina nodo Texto:271   */
      /* Termina nodo:270   */

      /* Empieza nodo:272 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(272)).setAttribute("colFondo","" );
      ((Element)v.get(272)).setAttribute("ID","EstCab" );
      ((Element)v.get(272)).setAttribute("cod","9" );
      ((Element)v.get(263)).appendChild((Element)v.get(272));

      /* Elemento padre:272 / Elemento actual: 273   */
      v.add(doc.createTextNode("Descripcion"));
      ((Element)v.get(272)).appendChild((Text)v.get(273));

      /* Termina nodo Texto:273   */
      /* Termina nodo:272   */

      /* Empieza nodo:274 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(274)).setAttribute("colFondo","" );
      ((Element)v.get(274)).setAttribute("ID","EstCab" );
      ((Element)v.get(274)).setAttribute("cod","276" );
      ((Element)v.get(263)).appendChild((Element)v.get(274));

      /* Elemento padre:274 / Elemento actual: 275   */
      v.add(doc.createTextNode("Período"));
      ((Element)v.get(274)).appendChild((Text)v.get(275));

      /* Termina nodo Texto:275   */
      /* Termina nodo:274   */

      /* Empieza nodo:276 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(276)).setAttribute("colFondo","" );
      ((Element)v.get(276)).setAttribute("ID","EstCab" );
      ((Element)v.get(276)).setAttribute("cod","2892" );
      ((Element)v.get(263)).appendChild((Element)v.get(276));

      /* Elemento padre:276 / Elemento actual: 277   */
      v.add(doc.createTextNode("Cód. recomendada"));
      ((Element)v.get(276)).appendChild((Text)v.get(277));

      /* Termina nodo Texto:277   */
      /* Termina nodo:276   */

      /* Empieza nodo:278 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(278)).setAttribute("colFondo","" );
      ((Element)v.get(278)).setAttribute("ID","EstCab" );
      ((Element)v.get(278)).setAttribute("cod","943" );
      ((Element)v.get(263)).appendChild((Element)v.get(278));

      /* Elemento padre:278 / Elemento actual: 279   */
      v.add(doc.createTextNode("Nombre y Apellidos"));
      ((Element)v.get(278)).appendChild((Text)v.get(279));

      /* Termina nodo Texto:279   */
      /* Termina nodo:278   */

      /* Empieza nodo:280 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(280)).setAttribute("colFondo","" );
      ((Element)v.get(280)).setAttribute("ID","EstCab" );
      ((Element)v.get(280)).setAttribute("cod","695" );
      ((Element)v.get(263)).appendChild((Element)v.get(280));

      /* Elemento padre:280 / Elemento actual: 281   */
      v.add(doc.createTextNode("Situación"));
      ((Element)v.get(280)).appendChild((Text)v.get(281));

      /* Termina nodo Texto:281   */
      /* Termina nodo:280   */

      /* Empieza nodo:282 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(282)).setAttribute("colFondo","" );
      ((Element)v.get(282)).setAttribute("ID","EstCab" );
      ((Element)v.get(282)).setAttribute("cod","2897" );
      ((Element)v.get(263)).appendChild((Element)v.get(282));

      /* Elemento padre:282 / Elemento actual: 283   */
      v.add(doc.createTextNode("Motivo incumplimiento"));
      ((Element)v.get(282)).appendChild((Text)v.get(283));

      /* Termina nodo Texto:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:284 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(284)).setAttribute("colFondo","" );
      ((Element)v.get(284)).setAttribute("ID","EstCab" );
      ((Element)v.get(284)).setAttribute("cod","2888" );
      ((Element)v.get(263)).appendChild((Element)v.get(284));

      /* Elemento padre:284 / Elemento actual: 285   */
      v.add(doc.createTextNode("Premio reemplazo"));
      ((Element)v.get(284)).appendChild((Text)v.get(285));

      /* Termina nodo Texto:285   */
      /* Termina nodo:284   */

      /* Empieza nodo:286 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(286)).setAttribute("colFondo","" );
      ((Element)v.get(286)).setAttribute("ID","EstCab" );
      ((Element)v.get(286)).setAttribute("cod","3382" );
      ((Element)v.get(263)).appendChild((Element)v.get(286));

      /* Elemento padre:286 / Elemento actual: 287   */
      v.add(doc.createTextNode("Monto Total recomendada"));
      ((Element)v.get(286)).appendChild((Text)v.get(287));

      /* Termina nodo Texto:287   */
      /* Termina nodo:286   */

      /* Empieza nodo:288 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(288)).setAttribute("colFondo","" );
      ((Element)v.get(288)).setAttribute("ID","EstCab" );
      ((Element)v.get(288)).setAttribute("cod","357" );
      ((Element)v.get(263)).appendChild((Element)v.get(288));

      /* Elemento padre:288 / Elemento actual: 289   */
      v.add(doc.createTextNode("Nivel"));
      ((Element)v.get(288)).appendChild((Text)v.get(289));

      /* Termina nodo Texto:289   */
      /* Termina nodo:288   */

      /* Empieza nodo:290 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(290)).setAttribute("colFondo","" );
      ((Element)v.get(290)).setAttribute("ID","EstCab" );
      ((Element)v.get(290)).setAttribute("cod","1691" );
      ((Element)v.get(263)).appendChild((Element)v.get(290));

      /* Elemento padre:290 / Elemento actual: 291   */
      v.add(doc.createTextNode("Nº premio"));
      ((Element)v.get(290)).appendChild((Text)v.get(291));

      /* Termina nodo Texto:291   */
      /* Termina nodo:290   */

      /* Empieza nodo:292 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(292)).setAttribute("colFondo","" );
      ((Element)v.get(292)).setAttribute("ID","EstCab" );
      ((Element)v.get(292)).setAttribute("cod","1696" );
      ((Element)v.get(263)).appendChild((Element)v.get(292));

      /* Elemento padre:292 / Elemento actual: 293   */
      v.add(doc.createTextNode("Tipo premio"));
      ((Element)v.get(292)).appendChild((Text)v.get(293));

      /* Termina nodo Texto:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:294 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(294)).setAttribute("colFondo","" );
      ((Element)v.get(294)).setAttribute("ID","EstCab" );
      ((Element)v.get(294)).setAttribute("cod","2878" );
      ((Element)v.get(263)).appendChild((Element)v.get(294));

      /* Elemento padre:294 / Elemento actual: 295   */
      v.add(doc.createTextNode("Datos premio"));
      ((Element)v.get(294)).appendChild((Text)v.get(295));

      /* Termina nodo Texto:295   */
      /* Termina nodo:294   */
      /* Termina nodo:263   */

      /* Empieza nodo:296 / Elemento padre: 235   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(296)).setAttribute("alto","22" );
      ((Element)v.get(296)).setAttribute("accion","" );
      ((Element)v.get(296)).setAttribute("tipoEnvio","edicion" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(296)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(296)).setAttribute("maxSel","-1" );
      ((Element)v.get(296)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(296)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(296)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(296)).setAttribute("onLoad","" );
      ((Element)v.get(296)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(235)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(297)).setAttribute("tipo","texto" );
      ((Element)v.get(297)).setAttribute("ID","EstDat" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */

      /* Empieza nodo:298 / Elemento padre: 296   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(298)).setAttribute("tipo","texto" );
      ((Element)v.get(298)).setAttribute("ID","EstDat" );
      ((Element)v.get(296)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */

      /* Empieza nodo:299 / Elemento padre: 296   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(299)).setAttribute("tipo","texto" );
      ((Element)v.get(299)).setAttribute("ID","EstDat2" );
      ((Element)v.get(296)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */

      /* Empieza nodo:300 / Elemento padre: 296   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(300)).setAttribute("tipo","texto" );
      ((Element)v.get(300)).setAttribute("ID","EstDat" );
      ((Element)v.get(296)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */

      /* Empieza nodo:301 / Elemento padre: 296   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(301)).setAttribute("tipo","texto" );
      ((Element)v.get(301)).setAttribute("ID","EstDat2" );
      ((Element)v.get(296)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */

      /* Empieza nodo:302 / Elemento padre: 296   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(302)).setAttribute("tipo","texto" );
      ((Element)v.get(302)).setAttribute("ID","EstDat" );
      ((Element)v.get(296)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */

      /* Empieza nodo:303 / Elemento padre: 296   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(303)).setAttribute("tipo","texto" );
      ((Element)v.get(303)).setAttribute("ID","EstDat2" );
      ((Element)v.get(296)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */

      /* Empieza nodo:304 / Elemento padre: 296   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(304)).setAttribute("tipo","texto" );
      ((Element)v.get(304)).setAttribute("ID","EstDat" );
      ((Element)v.get(296)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */

      /* Empieza nodo:305 / Elemento padre: 296   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(305)).setAttribute("tipo","texto" );
      ((Element)v.get(305)).setAttribute("ID","EstDat2" );
      ((Element)v.get(296)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */

      /* Empieza nodo:306 / Elemento padre: 296   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(306)).setAttribute("tipo","texto" );
      ((Element)v.get(306)).setAttribute("ID","EstDat" );
      ((Element)v.get(296)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */

      /* Empieza nodo:307 / Elemento padre: 296   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(307)).setAttribute("tipo","texto" );
      ((Element)v.get(307)).setAttribute("ID","EstDat2" );
      ((Element)v.get(296)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */

      /* Empieza nodo:308 / Elemento padre: 296   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(308)).setAttribute("tipo","texto" );
      ((Element)v.get(308)).setAttribute("ID","EstDat" );
      ((Element)v.get(296)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */

      /* Empieza nodo:309 / Elemento padre: 296   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(309)).setAttribute("tipo","texto" );
      ((Element)v.get(309)).setAttribute("ID","EstDat2" );
      ((Element)v.get(296)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */

      /* Empieza nodo:310 / Elemento padre: 296   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(310)).setAttribute("tipo","texto" );
      ((Element)v.get(310)).setAttribute("ID","EstDat" );
      ((Element)v.get(296)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */

      /* Empieza nodo:311 / Elemento padre: 296   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(311)).setAttribute("tipo","texto" );
      ((Element)v.get(311)).setAttribute("ID","EstDat2" );
      ((Element)v.get(296)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */

      /* Empieza nodo:312 / Elemento padre: 296   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(312)).setAttribute("tipo","texto" );
      ((Element)v.get(312)).setAttribute("ID","EstDat" );
      ((Element)v.get(296)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */

      /* Empieza nodo:313 / Elemento padre: 296   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(313)).setAttribute("tipo","texto" );
      ((Element)v.get(313)).setAttribute("ID","EstDat2" );
      ((Element)v.get(296)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:296   */

      /* Empieza nodo:314 / Elemento padre: 235   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(235)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */

      /* Empieza nodo:315 / Elemento padre: 235   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(315)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(315)).setAttribute("ancho","664" );
      ((Element)v.get(315)).setAttribute("sep","$" );
      ((Element)v.get(315)).setAttribute("x","12" );
      ((Element)v.get(315)).setAttribute("class","botonera" );
      ((Element)v.get(315)).setAttribute("y","476" );
      ((Element)v.get(315)).setAttribute("control","|" );
      ((Element)v.get(315)).setAttribute("conector","" );
      ((Element)v.get(315)).setAttribute("rowset","" );
      ((Element)v.get(315)).setAttribute("cargainicial","N" );
      ((Element)v.get(315)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(235)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(316)).setAttribute("nombre","ret1" );
      ((Element)v.get(316)).setAttribute("x","37" );
      ((Element)v.get(316)).setAttribute("y","480" );
      ((Element)v.get(316)).setAttribute("ID","botonContenido" );
      ((Element)v.get(316)).setAttribute("img","retroceder_on" );
      ((Element)v.get(316)).setAttribute("tipo","0" );
      ((Element)v.get(316)).setAttribute("estado","false" );
      ((Element)v.get(316)).setAttribute("alt","" );
      ((Element)v.get(316)).setAttribute("codigo","" );
      ((Element)v.get(316)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */

      /* Empieza nodo:317 / Elemento padre: 315   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(317)).setAttribute("nombre","ava1" );
      ((Element)v.get(317)).setAttribute("x","52" );
      ((Element)v.get(317)).setAttribute("y","480" );
      ((Element)v.get(317)).setAttribute("ID","botonContenido" );
      ((Element)v.get(317)).setAttribute("img","avanzar_on" );
      ((Element)v.get(317)).setAttribute("tipo","0" );
      ((Element)v.get(317)).setAttribute("estado","false" );
      ((Element)v.get(317)).setAttribute("alt","" );
      ((Element)v.get(317)).setAttribute("codigo","" );
      ((Element)v.get(317)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(315)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:315   */
      /* Termina nodo:235   */

      /* Empieza nodo:318 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(318)).setAttribute("nombre","primera1" );
      ((Element)v.get(318)).setAttribute("x","20" );
      ((Element)v.get(318)).setAttribute("y","480" );
      ((Element)v.get(318)).setAttribute("ID","botonContenido" );
      ((Element)v.get(318)).setAttribute("img","primera_on" );
      ((Element)v.get(318)).setAttribute("tipo","0" );
      ((Element)v.get(318)).setAttribute("estado","false" );
      ((Element)v.get(318)).setAttribute("alt","" );
      ((Element)v.get(318)).setAttribute("codigo","" );
      ((Element)v.get(318)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */

      /* Empieza nodo:319 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(319)).setAttribute("nombre","separa" );
      ((Element)v.get(319)).setAttribute("x","59" );
      ((Element)v.get(319)).setAttribute("y","476" );
      ((Element)v.get(319)).setAttribute("ID","botonContenido" );
      ((Element)v.get(319)).setAttribute("img","separa_base" );
      ((Element)v.get(319)).setAttribute("tipo","0" );
      ((Element)v.get(319)).setAttribute("estado","false" );
      ((Element)v.get(319)).setAttribute("alt","" );
      ((Element)v.get(319)).setAttribute("codigo","" );
      ((Element)v.get(319)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */

      /* Empieza nodo:320 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(320)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(320)).setAttribute("alto","12" );
      ((Element)v.get(320)).setAttribute("ancho","50" );
      ((Element)v.get(320)).setAttribute("colorf","" );
      ((Element)v.get(320)).setAttribute("borde","0" );
      ((Element)v.get(320)).setAttribute("imagenf","" );
      ((Element)v.get(320)).setAttribute("repeat","" );
      ((Element)v.get(320)).setAttribute("padding","" );
      ((Element)v.get(320)).setAttribute("visibilidad","visible" );
      ((Element)v.get(320)).setAttribute("contravsb","" );
      ((Element)v.get(320)).setAttribute("x","0" );
      ((Element)v.get(320)).setAttribute("y","499" );
      ((Element)v.get(320)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */

      /* Empieza nodo:321 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(321)).setAttribute("nombre","PedidosRecomendadas" );
      ((Element)v.get(321)).setAttribute("x","0" );
      ((Element)v.get(321)).setAttribute("y","0" );
      ((Element)v.get(6)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(322)).setAttribute("nombre","listado2" );
      ((Element)v.get(322)).setAttribute("ancho","664" );
      ((Element)v.get(322)).setAttribute("alto","317" );
      ((Element)v.get(322)).setAttribute("x","12" );
      ((Element)v.get(322)).setAttribute("y","620" );
      ((Element)v.get(322)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(322)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(323)).setAttribute("precarga","S" );
      ((Element)v.get(323)).setAttribute("conROver","S" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(324)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(324)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(324)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(324)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */

      /* Empieza nodo:325 / Elemento padre: 323   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(325)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(325)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(325)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(325)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(323)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */

      /* Empieza nodo:326 / Elemento padre: 323   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(326)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(326)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(323)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:323   */

      /* Empieza nodo:327 / Elemento padre: 322   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(322)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(328)).setAttribute("borde","1" );
      ((Element)v.get(328)).setAttribute("horizDatos","1" );
      ((Element)v.get(328)).setAttribute("horizCabecera","1" );
      ((Element)v.get(328)).setAttribute("vertical","1" );
      ((Element)v.get(328)).setAttribute("horizTitulo","1" );
      ((Element)v.get(328)).setAttribute("horizBase","1" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */

      /* Empieza nodo:329 / Elemento padre: 327   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(329)).setAttribute("borde","#999999" );
      ((Element)v.get(329)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(329)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(329)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(329)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(329)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(329)).setAttribute("horizBase","#999999" );
      ((Element)v.get(327)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:327   */

      /* Empieza nodo:330 / Elemento padre: 322   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(330)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(330)).setAttribute("alto","22" );
      ((Element)v.get(330)).setAttribute("imgFondo","" );
      ((Element)v.get(330)).setAttribute("cod","3384" );
      ((Element)v.get(330)).setAttribute("ID","datosTitle" );
      ((Element)v.get(322)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */

      /* Empieza nodo:331 / Elemento padre: 322   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(331)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(331)).setAttribute("alto","22" );
      ((Element)v.get(331)).setAttribute("imgFondo","" );
      ((Element)v.get(322)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */

      /* Empieza nodo:332 / Elemento padre: 322   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(332)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(332)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(332)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(332)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(332)).setAttribute("AnchoMinimizadas","25" );
      ((Element)v.get(332)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(322)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(333)).setAttribute("ancho","100" );
      ((Element)v.get(333)).setAttribute("minimizable","S" );
      ((Element)v.get(333)).setAttribute("minimizada","N" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */

      /* Empieza nodo:334 / Elemento padre: 332   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(334)).setAttribute("ancho","100" );
      ((Element)v.get(334)).setAttribute("minimizable","S" );
      ((Element)v.get(334)).setAttribute("minimizada","N" );
      ((Element)v.get(332)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */

      /* Empieza nodo:335 / Elemento padre: 332   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(335)).setAttribute("ancho","100" );
      ((Element)v.get(335)).setAttribute("minimizable","S" );
      ((Element)v.get(335)).setAttribute("minimizada","N" );
      ((Element)v.get(332)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */

      /* Empieza nodo:336 / Elemento padre: 332   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(336)).setAttribute("ancho","100" );
      ((Element)v.get(336)).setAttribute("minimizable","S" );
      ((Element)v.get(336)).setAttribute("minimizada","N" );
      ((Element)v.get(332)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */

      /* Empieza nodo:337 / Elemento padre: 332   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(337)).setAttribute("ancho","100" );
      ((Element)v.get(337)).setAttribute("minimizable","S" );
      ((Element)v.get(337)).setAttribute("minimizada","N" );
      ((Element)v.get(332)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */

      /* Empieza nodo:338 / Elemento padre: 332   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(338)).setAttribute("ancho","100" );
      ((Element)v.get(338)).setAttribute("minimizable","S" );
      ((Element)v.get(338)).setAttribute("minimizada","N" );
      ((Element)v.get(332)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */

      /* Empieza nodo:339 / Elemento padre: 332   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(339)).setAttribute("ancho","100" );
      ((Element)v.get(339)).setAttribute("minimizable","S" );
      ((Element)v.get(339)).setAttribute("minimizada","N" );
      ((Element)v.get(332)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */
      /* Termina nodo:332   */

      /* Empieza nodo:340 / Elemento padre: 322   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(340)).setAttribute("alto","20" );
      ((Element)v.get(340)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(340)).setAttribute("imgFondo","" );
      ((Element)v.get(340)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(322)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(341)).setAttribute("colFondo","" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(341)).setAttribute("ID","EstCab" );
      ((Element)v.get(341)).setAttribute("cod","2892" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));

      /* Elemento padre:341 / Elemento actual: 342   */
      v.add(doc.createTextNode("Cod recomendada "));
      ((Element)v.get(341)).appendChild((Text)v.get(342));

      /* Termina nodo Texto:342   */
      /* Termina nodo:341   */

      /* Empieza nodo:343 / Elemento padre: 340   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(343)).setAttribute("colFondo","" );
      ((Element)v.get(343)).setAttribute("ID","EstCab" );
      ((Element)v.get(343)).setAttribute("cod","276" );
      ((Element)v.get(340)).appendChild((Element)v.get(343));

      /* Elemento padre:343 / Elemento actual: 344   */
      v.add(doc.createTextNode("Periodo solicitud"));
      ((Element)v.get(343)).appendChild((Text)v.get(344));

      /* Termina nodo Texto:344   */
      /* Termina nodo:343   */

      /* Empieza nodo:345 / Elemento padre: 340   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(345)).setAttribute("colFondo","" );
      ((Element)v.get(345)).setAttribute("ID","EstCab" );
      ((Element)v.get(345)).setAttribute("cod","1171" );
      ((Element)v.get(340)).appendChild((Element)v.get(345));

      /* Elemento padre:345 / Elemento actual: 346   */
      v.add(doc.createTextNode("Fecha Solicitud"));
      ((Element)v.get(345)).appendChild((Text)v.get(346));

      /* Termina nodo Texto:346   */
      /* Termina nodo:345   */

      /* Empieza nodo:347 / Elemento padre: 340   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(347)).setAttribute("colFondo","" );
      ((Element)v.get(347)).setAttribute("ID","EstCab" );
      ((Element)v.get(347)).setAttribute("cod","422" );
      ((Element)v.get(340)).appendChild((Element)v.get(347));

      /* Elemento padre:347 / Elemento actual: 348   */
      v.add(doc.createTextNode("Nro. documento "));
      ((Element)v.get(347)).appendChild((Text)v.get(348));

      /* Termina nodo Texto:348   */
      /* Termina nodo:347   */

      /* Empieza nodo:349 / Elemento padre: 340   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(349)).setAttribute("colFondo","" );
      ((Element)v.get(349)).setAttribute("ID","EstCab" );
      ((Element)v.get(349)).setAttribute("cod","3383" );
      ((Element)v.get(340)).appendChild((Element)v.get(349));

      /* Elemento padre:349 / Elemento actual: 350   */
      v.add(doc.createTextNode("Monto solicitud"));
      ((Element)v.get(349)).appendChild((Text)v.get(350));

      /* Termina nodo Texto:350   */
      /* Termina nodo:349   */

      /* Empieza nodo:351 / Elemento padre: 340   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(351)).setAttribute("colFondo","" );
      ((Element)v.get(351)).setAttribute("ID","EstCab" );
      ((Element)v.get(351)).setAttribute("cod","3395" );
      ((Element)v.get(340)).appendChild((Element)v.get(351));

      /* Elemento padre:351 / Elemento actual: 352   */
      v.add(doc.createTextNode("Ind Anulacion"));
      ((Element)v.get(351)).appendChild((Text)v.get(352));

      /* Termina nodo Texto:352   */
      /* Termina nodo:351   */

      /* Empieza nodo:353 / Elemento padre: 340   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(353)).setAttribute("colFondo","" );
      ((Element)v.get(353)).setAttribute("ID","EstCab" );
      ((Element)v.get(353)).setAttribute("cod","3396" );
      ((Element)v.get(340)).appendChild((Element)v.get(353));

      /* Elemento padre:353 / Elemento actual: 354   */
      v.add(doc.createTextNode("Fecha Anulacion"));
      ((Element)v.get(353)).appendChild((Text)v.get(354));

      /* Termina nodo Texto:354   */
      /* Termina nodo:353   */
      /* Termina nodo:340   */

      /* Empieza nodo:355 / Elemento padre: 322   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(355)).setAttribute("alto","22" );
      ((Element)v.get(355)).setAttribute("accion","" );
      ((Element)v.get(355)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(355)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(355)).setAttribute("maxSel","-1" );
      ((Element)v.get(355)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(355)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(355)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(355)).setAttribute("onLoad","" );
      ((Element)v.get(355)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(322)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(356)).setAttribute("tipo","texto" );
      ((Element)v.get(356)).setAttribute("ID","EstDat" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */

      /* Empieza nodo:357 / Elemento padre: 355   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(357)).setAttribute("tipo","texto" );
      ((Element)v.get(357)).setAttribute("ID","EstDat" );
      ((Element)v.get(355)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */

      /* Empieza nodo:358 / Elemento padre: 355   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(358)).setAttribute("tipo","texto" );
      ((Element)v.get(358)).setAttribute("ID","EstDat2" );
      ((Element)v.get(355)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */

      /* Empieza nodo:359 / Elemento padre: 355   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(359)).setAttribute("tipo","texto" );
      ((Element)v.get(359)).setAttribute("ID","EstDat" );
      ((Element)v.get(355)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */

      /* Empieza nodo:360 / Elemento padre: 355   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(360)).setAttribute("tipo","texto" );
      ((Element)v.get(360)).setAttribute("ID","EstDat2" );
      ((Element)v.get(355)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */

      /* Empieza nodo:361 / Elemento padre: 355   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(361)).setAttribute("tipo","texto" );
      ((Element)v.get(361)).setAttribute("ID","EstDat" );
      ((Element)v.get(355)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */

      /* Empieza nodo:362 / Elemento padre: 355   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(362)).setAttribute("tipo","texto" );
      ((Element)v.get(362)).setAttribute("ID","EstDat2" );
      ((Element)v.get(355)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:355   */

      /* Empieza nodo:363 / Elemento padre: 322   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(322)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */

      /* Empieza nodo:364 / Elemento padre: 322   */
      v.add(doc.createElement("PAGINADO"));
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(364)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(364)).setAttribute("ancho","664" );
      ((Element)v.get(364)).setAttribute("sep","$" );
      ((Element)v.get(364)).setAttribute("x","12" );
      ((Element)v.get(364)).setAttribute("class","botonera" );
      ((Element)v.get(364)).setAttribute("y","914" );
      ((Element)v.get(364)).setAttribute("control","|" );
      ((Element)v.get(364)).setAttribute("conector","" );
      ((Element)v.get(364)).setAttribute("rowset","" );
      ((Element)v.get(364)).setAttribute("cargainicial","N" );
      ((Element)v.get(364)).setAttribute("onload","procesarPaginado(mipgndo2,msgError, ultima, rowset, 'muestraLista2(ultima, rowset)')" );
      ((Element)v.get(322)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(365)).setAttribute("nombre","ret2" );
      ((Element)v.get(365)).setAttribute("x","37" );
      ((Element)v.get(365)).setAttribute("y","918" );
      ((Element)v.get(365)).setAttribute("ID","botonContenido" );
      ((Element)v.get(365)).setAttribute("img","retroceder_on" );
      ((Element)v.get(365)).setAttribute("tipo","0" );
      ((Element)v.get(365)).setAttribute("estado","false" );
      ((Element)v.get(365)).setAttribute("alt","" );
      ((Element)v.get(365)).setAttribute("codigo","" );
      ((Element)v.get(365)).setAttribute("accion","mipgndo2.retroceder();" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */

      /* Empieza nodo:366 / Elemento padre: 364   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(366)).setAttribute("nombre","ava2" );
      ((Element)v.get(366)).setAttribute("x","52" );
      ((Element)v.get(366)).setAttribute("y","918" );
      ((Element)v.get(366)).setAttribute("ID","botonContenido" );
      ((Element)v.get(366)).setAttribute("img","avanzar_on" );
      ((Element)v.get(366)).setAttribute("tipo","0" );
      ((Element)v.get(366)).setAttribute("estado","false" );
      ((Element)v.get(366)).setAttribute("alt","" );
      ((Element)v.get(366)).setAttribute("codigo","" );
      ((Element)v.get(366)).setAttribute("accion","mipgndo2.avanzar();" );
      ((Element)v.get(364)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */
      /* Termina nodo:364   */
      /* Termina nodo:322   */

      /* Empieza nodo:367 / Elemento padre: 321   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(367)).setAttribute("nombre","primera2" );
      ((Element)v.get(367)).setAttribute("x","20" );
      ((Element)v.get(367)).setAttribute("y","918" );
      ((Element)v.get(367)).setAttribute("ID","botonContenido" );
      ((Element)v.get(367)).setAttribute("img","primera_on" );
      ((Element)v.get(367)).setAttribute("tipo","0" );
      ((Element)v.get(367)).setAttribute("estado","false" );
      ((Element)v.get(367)).setAttribute("alt","" );
      ((Element)v.get(367)).setAttribute("codigo","" );
      ((Element)v.get(367)).setAttribute("accion","mipgndo2.retrocederPrimeraPagina();" );
      ((Element)v.get(321)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */

      /* Empieza nodo:368 / Elemento padre: 321   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(368)).setAttribute("nombre","separa2" );
      ((Element)v.get(368)).setAttribute("x","59" );
      ((Element)v.get(368)).setAttribute("y","914" );
      ((Element)v.get(368)).setAttribute("ID","botonContenido" );
      ((Element)v.get(368)).setAttribute("img","separa_base" );
      ((Element)v.get(368)).setAttribute("tipo","0" );
      ((Element)v.get(368)).setAttribute("estado","false" );
      ((Element)v.get(368)).setAttribute("alt","" );
      ((Element)v.get(368)).setAttribute("codigo","" );
      ((Element)v.get(368)).setAttribute("accion","" );
      ((Element)v.get(321)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */

      /* Empieza nodo:369 / Elemento padre: 321   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(369)).setAttribute("nombre","capaEspacio3" );
      ((Element)v.get(369)).setAttribute("alto","12" );
      ((Element)v.get(369)).setAttribute("ancho","50" );
      ((Element)v.get(369)).setAttribute("colorf","" );
      ((Element)v.get(369)).setAttribute("borde","0" );
      ((Element)v.get(369)).setAttribute("imagenf","" );
      ((Element)v.get(369)).setAttribute("repeat","" );
      ((Element)v.get(369)).setAttribute("padding","" );
      ((Element)v.get(369)).setAttribute("visibilidad","visible" );
      ((Element)v.get(369)).setAttribute("contravsb","" );
      ((Element)v.get(369)).setAttribute("x","0" );
      ((Element)v.get(369)).setAttribute("y","937" );
      ((Element)v.get(369)).setAttribute("zindex","" );
      ((Element)v.get(321)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:321   */

      /* Empieza nodo:370 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(370)).setAttribute("nombre","PedidosRecomendante" );
      ((Element)v.get(370)).setAttribute("x","0" );
      ((Element)v.get(370)).setAttribute("y","0" );
      ((Element)v.get(6)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(371)).setAttribute("nombre","listado3" );
      ((Element)v.get(371)).setAttribute("ancho","664" );
      ((Element)v.get(371)).setAttribute("alto","317" );
      ((Element)v.get(371)).setAttribute("x","12" );
      ((Element)v.get(371)).setAttribute("y","970" );
      ((Element)v.get(371)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(371)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("IMGBOTONES"));
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(372)).setAttribute("precarga","S" );
      ((Element)v.get(372)).setAttribute("conROver","S" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(373)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(373)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(373)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(373)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */

      /* Empieza nodo:374 / Elemento padre: 372   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(374)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(374)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(374)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(374)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(372)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */

      /* Empieza nodo:375 / Elemento padre: 372   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(375)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(375)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(372)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */
      /* Termina nodo:372   */

      /* Empieza nodo:376 / Elemento padre: 371   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(371)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(377)).setAttribute("borde","1" );
      ((Element)v.get(377)).setAttribute("horizDatos","1" );
      ((Element)v.get(377)).setAttribute("horizCabecera","1" );
      ((Element)v.get(377)).setAttribute("vertical","1" );
      ((Element)v.get(377)).setAttribute("horizTitulo","1" );
      ((Element)v.get(377)).setAttribute("horizBase","1" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */

      /* Empieza nodo:378 / Elemento padre: 376   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(378)).setAttribute("borde","#999999" );
      ((Element)v.get(378)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(378)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(378)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(378)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(378)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(378)).setAttribute("horizBase","#999999" );
      ((Element)v.get(376)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:376   */

      /* Empieza nodo:379 / Elemento padre: 371   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(379)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(379)).setAttribute("alto","22" );
      ((Element)v.get(379)).setAttribute("imgFondo","" );
      ((Element)v.get(379)).setAttribute("cod","3397" );
      ((Element)v.get(379)).setAttribute("ID","datosTitle" );
      ((Element)v.get(371)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */

      /* Empieza nodo:380 / Elemento padre: 371   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(380)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(380)).setAttribute("alto","22" );
      ((Element)v.get(380)).setAttribute("imgFondo","" );
      ((Element)v.get(371)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */

      /* Empieza nodo:381 / Elemento padre: 371   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(381)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(381)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(381)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(381)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(381)).setAttribute("AnchoMinimizadas","25" );
      ((Element)v.get(381)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(371)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(382)).setAttribute("ancho","100" );
      ((Element)v.get(382)).setAttribute("minimizable","S" );
      ((Element)v.get(382)).setAttribute("minimizada","N" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */

      /* Empieza nodo:383 / Elemento padre: 381   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(383)).setAttribute("ancho","100" );
      ((Element)v.get(383)).setAttribute("minimizable","S" );
      ((Element)v.get(383)).setAttribute("minimizada","N" );
      ((Element)v.get(381)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */

      /* Empieza nodo:384 / Elemento padre: 381   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(384)).setAttribute("ancho","100" );
      ((Element)v.get(384)).setAttribute("minimizable","S" );
      ((Element)v.get(384)).setAttribute("minimizada","N" );
      ((Element)v.get(381)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */

      /* Empieza nodo:385 / Elemento padre: 381   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(385)).setAttribute("ancho","100" );
      ((Element)v.get(385)).setAttribute("minimizable","S" );
      ((Element)v.get(385)).setAttribute("minimizada","N" );
      ((Element)v.get(381)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */

      /* Empieza nodo:386 / Elemento padre: 381   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(386)).setAttribute("ancho","100" );
      ((Element)v.get(386)).setAttribute("minimizable","S" );
      ((Element)v.get(386)).setAttribute("minimizada","N" );
      ((Element)v.get(381)).appendChild((Element)v.get(386));
      /* Termina nodo:386   */

      /* Empieza nodo:387 / Elemento padre: 381   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(387)).setAttribute("ancho","100" );
      ((Element)v.get(387)).setAttribute("minimizable","S" );
      ((Element)v.get(387)).setAttribute("minimizada","N" );
      ((Element)v.get(381)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */
      /* Termina nodo:381   */

      /* Empieza nodo:388 / Elemento padre: 371   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(388)).setAttribute("alto","20" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(388)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(388)).setAttribute("imgFondo","" );
      ((Element)v.get(388)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(371)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(389)).setAttribute("colFondo","" );
      ((Element)v.get(389)).setAttribute("ID","EstCab" );
      ((Element)v.get(389)).setAttribute("cod","276" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));

      /* Elemento padre:389 / Elemento actual: 390   */
      v.add(doc.createTextNode("Periodo solicitud"));
      ((Element)v.get(389)).appendChild((Text)v.get(390));

      /* Termina nodo Texto:390   */
      /* Termina nodo:389   */

      /* Empieza nodo:391 / Elemento padre: 388   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(391)).setAttribute("colFondo","" );
      ((Element)v.get(391)).setAttribute("ID","EstCab" );
      ((Element)v.get(391)).setAttribute("cod","1171" );
      ((Element)v.get(388)).appendChild((Element)v.get(391));

      /* Elemento padre:391 / Elemento actual: 392   */
      v.add(doc.createTextNode("Fecha Solicitud"));
      ((Element)v.get(391)).appendChild((Text)v.get(392));

      /* Termina nodo Texto:392   */
      /* Termina nodo:391   */

      /* Empieza nodo:393 / Elemento padre: 388   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(393)).setAttribute("colFondo","" );
      ((Element)v.get(393)).setAttribute("ID","EstCab" );
      ((Element)v.get(393)).setAttribute("cod","422" );
      ((Element)v.get(388)).appendChild((Element)v.get(393));

      /* Elemento padre:393 / Elemento actual: 394   */
      v.add(doc.createTextNode("Nro. documento "));
      ((Element)v.get(393)).appendChild((Text)v.get(394));

      /* Termina nodo Texto:394   */
      /* Termina nodo:393   */

      /* Empieza nodo:395 / Elemento padre: 388   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(395)).setAttribute("colFondo","" );
      ((Element)v.get(395)).setAttribute("ID","EstCab" );
      ((Element)v.get(395)).setAttribute("cod","3383" );
      ((Element)v.get(388)).appendChild((Element)v.get(395));

      /* Elemento padre:395 / Elemento actual: 396   */
      v.add(doc.createTextNode("Monto solicitud"));
      ((Element)v.get(395)).appendChild((Text)v.get(396));

      /* Termina nodo Texto:396   */
      /* Termina nodo:395   */

      /* Empieza nodo:397 / Elemento padre: 388   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(397)).setAttribute("colFondo","" );
      ((Element)v.get(397)).setAttribute("ID","EstCab" );
      ((Element)v.get(397)).setAttribute("cod","3395" );
      ((Element)v.get(388)).appendChild((Element)v.get(397));

      /* Elemento padre:397 / Elemento actual: 398   */
      v.add(doc.createTextNode("Ind Anulacion"));
      ((Element)v.get(397)).appendChild((Text)v.get(398));

      /* Termina nodo Texto:398   */
      /* Termina nodo:397   */

      /* Empieza nodo:399 / Elemento padre: 388   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(399)).setAttribute("colFondo","" );
      ((Element)v.get(399)).setAttribute("ID","EstCab" );
      ((Element)v.get(399)).setAttribute("cod","3396" );
      ((Element)v.get(388)).appendChild((Element)v.get(399));

      /* Elemento padre:399 / Elemento actual: 400   */
      v.add(doc.createTextNode("Fecha Anulacion"));
      ((Element)v.get(399)).appendChild((Text)v.get(400));

      /* Termina nodo Texto:400   */
      /* Termina nodo:399   */
      /* Termina nodo:388   */

      /* Empieza nodo:401 / Elemento padre: 371   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(401)).setAttribute("alto","22" );
      ((Element)v.get(401)).setAttribute("accion","" );
      ((Element)v.get(401)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(401)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(401)).setAttribute("maxSel","-1" );
      ((Element)v.get(401)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(401)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(401)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(401)).setAttribute("onLoad","" );
      ((Element)v.get(401)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(371)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(402)).setAttribute("tipo","texto" );
      ((Element)v.get(402)).setAttribute("ID","EstDat" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */

      /* Empieza nodo:403 / Elemento padre: 401   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(403)).setAttribute("tipo","texto" );
      ((Element)v.get(403)).setAttribute("ID","EstDat2" );
      ((Element)v.get(401)).appendChild((Element)v.get(403));
      /* Termina nodo:403   */

      /* Empieza nodo:404 / Elemento padre: 401   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(404)).setAttribute("tipo","texto" );
      ((Element)v.get(404)).setAttribute("ID","EstDat" );
      ((Element)v.get(401)).appendChild((Element)v.get(404));
      /* Termina nodo:404   */

      /* Empieza nodo:405 / Elemento padre: 401   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(405)).setAttribute("tipo","texto" );
      ((Element)v.get(405)).setAttribute("ID","EstDat2" );
      ((Element)v.get(401)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */

      /* Empieza nodo:406 / Elemento padre: 401   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(406)).setAttribute("tipo","texto" );
      ((Element)v.get(406)).setAttribute("ID","EstDat" );
      ((Element)v.get(401)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */

      /* Empieza nodo:407 / Elemento padre: 401   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(407)).setAttribute("tipo","texto" );
      ((Element)v.get(407)).setAttribute("ID","EstDat2" );
      ((Element)v.get(401)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */
      /* Termina nodo:401   */

      /* Empieza nodo:408 / Elemento padre: 371   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(371)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */

      /* Empieza nodo:409 / Elemento padre: 371   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(409)).setAttribute("nombre","mipgndo3" );
      ((Element)v.get(409)).setAttribute("ancho","664" );
      ((Element)v.get(409)).setAttribute("sep","$" );
      ((Element)v.get(409)).setAttribute("x","12" );
      ((Element)v.get(409)).setAttribute("class","botonera" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(409)).setAttribute("y","1264" );
      ((Element)v.get(409)).setAttribute("control","|" );
      ((Element)v.get(409)).setAttribute("conector","" );
      ((Element)v.get(409)).setAttribute("rowset","" );
      ((Element)v.get(409)).setAttribute("cargainicial","N" );
      ((Element)v.get(409)).setAttribute("onload","procesarPaginado(mipgndo3,msgError, ultima, rowset, 'muestraLista3(ultima, rowset)')" );
      ((Element)v.get(371)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(410)).setAttribute("nombre","ret3" );
      ((Element)v.get(410)).setAttribute("x","37" );
      ((Element)v.get(410)).setAttribute("y","1268" );
      ((Element)v.get(410)).setAttribute("ID","botonContenido" );
      ((Element)v.get(410)).setAttribute("img","retroceder_on" );
      ((Element)v.get(410)).setAttribute("tipo","0" );
      ((Element)v.get(410)).setAttribute("estado","false" );
      ((Element)v.get(410)).setAttribute("alt","" );
      ((Element)v.get(410)).setAttribute("codigo","" );
      ((Element)v.get(410)).setAttribute("accion","mipgndo3.retroceder();" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */

      /* Empieza nodo:411 / Elemento padre: 409   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(411)).setAttribute("nombre","ava3" );
      ((Element)v.get(411)).setAttribute("x","52" );
      ((Element)v.get(411)).setAttribute("y","1268" );
      ((Element)v.get(411)).setAttribute("ID","botonContenido" );
      ((Element)v.get(411)).setAttribute("img","avanzar_on" );
      ((Element)v.get(411)).setAttribute("tipo","0" );
      ((Element)v.get(411)).setAttribute("estado","false" );
      ((Element)v.get(411)).setAttribute("alt","" );
      ((Element)v.get(411)).setAttribute("codigo","" );
      ((Element)v.get(411)).setAttribute("accion","mipgndo3.avanzar();" );
      ((Element)v.get(409)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */
      /* Termina nodo:409   */
      /* Termina nodo:371   */

      /* Empieza nodo:412 / Elemento padre: 370   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(412)).setAttribute("nombre","primera3" );
      ((Element)v.get(412)).setAttribute("x","20" );
      ((Element)v.get(412)).setAttribute("y","1268" );
      ((Element)v.get(412)).setAttribute("ID","botonContenido" );
      ((Element)v.get(412)).setAttribute("img","primera_on" );
      ((Element)v.get(412)).setAttribute("tipo","0" );
      ((Element)v.get(412)).setAttribute("estado","false" );
      ((Element)v.get(412)).setAttribute("alt","" );
      ((Element)v.get(412)).setAttribute("codigo","" );
      ((Element)v.get(412)).setAttribute("accion","mipgndo3.retrocederPrimeraPagina();" );
      ((Element)v.get(370)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */

      /* Empieza nodo:413 / Elemento padre: 370   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(413)).setAttribute("nombre","separa3" );
      ((Element)v.get(413)).setAttribute("x","59" );
      ((Element)v.get(413)).setAttribute("y","1264" );
      ((Element)v.get(413)).setAttribute("ID","botonContenido" );
      ((Element)v.get(413)).setAttribute("img","separa_base" );
      ((Element)v.get(413)).setAttribute("tipo","0" );
      ((Element)v.get(413)).setAttribute("estado","false" );
      ((Element)v.get(413)).setAttribute("alt","" );
      ((Element)v.get(413)).setAttribute("codigo","" );
      ((Element)v.get(413)).setAttribute("accion","" );
      ((Element)v.get(370)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */

      /* Empieza nodo:414 / Elemento padre: 370   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(414)).setAttribute("nombre","capaEspacio4" );
      ((Element)v.get(414)).setAttribute("alto","12" );
      ((Element)v.get(414)).setAttribute("ancho","50" );
      ((Element)v.get(414)).setAttribute("colorf","" );
      ((Element)v.get(414)).setAttribute("borde","0" );
      ((Element)v.get(414)).setAttribute("imagenf","" );
      ((Element)v.get(414)).setAttribute("repeat","" );
      ((Element)v.get(414)).setAttribute("padding","" );
      ((Element)v.get(414)).setAttribute("visibilidad","visible" );
      ((Element)v.get(414)).setAttribute("contravsb","" );
      ((Element)v.get(414)).setAttribute("x","0" );
      ((Element)v.get(414)).setAttribute("y","1287" );
      ((Element)v.get(414)).setAttribute("zindex","" );
      ((Element)v.get(370)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */
      /* Termina nodo:370   */
      /* Termina nodo:6   */


   }

}

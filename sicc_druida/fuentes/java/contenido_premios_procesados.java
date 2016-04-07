
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_premios_procesados  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML1890(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_premios_procesados" );
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
      v.add(doc.createTextNode("\r     \r\r	function onLoadPag() {\r	    configurarMenuSecundario(\"frmFormulario\");\r		asignarLabels();\r		mostrarListasResultados();\r		\r		cargarListaPremioArticulo(); \r		cargarListaPremioMonetario(); \r		cargarListaPremioPuntos(); \r		cargarListaPremioDescuento();\r		configurarBotones();\r	}\r\r	function configurarBotones() {\r		 btnProxy(2,'1');\r 		 btnProxy(3,'0');\r  		 btnProxy(5,'0');\r		 btnProxy(7,'0');\r		 btnProxy(8,'0');\r		 btnProxy(9,'0');\r	}\r	\r	function fVolver() {\r		window.close();\r	}\r\r	function asignarLabels(){\r		txt_to('lbldtCodCliente', get(\"frmFormulario.laCodigoCliente\"));\r		txt_to('lbldtNombreApellido', get(\"frmFormulario.laNombreApellido\"));\r		txt_to('lbldtNumConcurso', get(\"frmFormulario.laNumeroConcurso\"));\r		txt_to('lbldtDescripcion', get(\"frmFormulario.laDescripcionConcurso\"));\r	}\r\r	function mostrarListasResultados() { \r	    DrdEnsanchaConMargenDcho('listado1',12);\r	    \r	    document.all[\"Cplistado1\"].style.visibility='';\r	    document.all[\"CpLin1listado1\"].style.visibility='';\r	    document.all[\"CpLin2listado1\"].style.visibility='';\r	    document.all[\"CpLin3listado1\"].style.visibility='';\r	    document.all[\"CpLin4listado1\"].style.visibility='';\r\r	    document.all[\"primera1Div\"].style.visibility='';\r	    document.all[\"ret1Div\"].style.visibility='';\r	    document.all[\"ava1Div\"].style.visibility='';\r	    document.all[\"separaDiv\"].style.visibility='';\r\r	    DrdEnsanchaConMargenDcho('listado2',12);\r	    \r	    document.all[\"Cplistado2\"].style.visibility='';\r	    document.all[\"CpLin1listado2\"].style.visibility='';\r	    document.all[\"CpLin2listado2\"].style.visibility='';\r	    document.all[\"CpLin3listado2\"].style.visibility='';\r	    document.all[\"CpLin4listado2\"].style.visibility='';\r\r	    document.all[\"primera2Div\"].style.visibility='';\r	    document.all[\"ret2Div\"].style.visibility='';\r	    document.all[\"ava2Div\"].style.visibility='';\r	    document.all[\"separa2Div\"].style.visibility='';\r	    \r	    DrdEnsanchaConMargenDcho('listado3',12);\r	    \r	    document.all[\"Cplistado3\"].style.visibility='';\r	    document.all[\"CpLin1listado3\"].style.visibility='';\r	    document.all[\"CpLin2listado3\"].style.visibility='';\r	    document.all[\"CpLin3listado3\"].style.visibility='';\r	    document.all[\"CpLin4listado3\"].style.visibility='';\r\r	    document.all[\"primera3Div\"].style.visibility='';\r	    document.all[\"ret3Div\"].style.visibility='';\r	    document.all[\"ava3Div\"].style.visibility='';\r	    document.all[\"separa3Div\"].style.visibility='';\r	    \r	    DrdEnsanchaConMargenDcho('listado4',12);\r	    \r	    document.all[\"Cplistado4\"].style.visibility='';\r	    document.all[\"CpLin1listado4\"].style.visibility='';\r	    document.all[\"CpLin2listado4\"].style.visibility='';\r	    document.all[\"CpLin3listado4\"].style.visibility='';\r	    document.all[\"CpLin4listado4\"].style.visibility='';\r\r	    document.all[\"primera4Div\"].style.visibility='';\r	    document.all[\"ret4Div\"].style.visibility='';\r	    document.all[\"ava4Div\"].style.visibility='';\r	    document.all[\"separa4Div\"].style.visibility='';\r\r		eval (ON_RSZ);  \r\r	}\r\r	function cargarListaPremioArticulo() {\r		var arr = new Array();\r		arr[arr.length] = new Array(\"oidConcurso\", get(\"frmFormulario.oidConcurso\")+\"\");\r		arr[arr.length] = new Array(\"oidCliente\", get(\"frmFormulario.oidCliente\")+\"\");\r		arr[arr.length] = new Array(\"numeroConcurso\", get(\"frmFormulario.lanumeroConcurso\")+\"\");\r		arr[arr.length] = new Array(\"oidRegion\", get(\"frmFormulario.oidRegion\")+\"\"); \r		arr[arr.length] = new Array(\"oidZona\", get(\"frmFormulario.oidZona\")+\"\");\r		arr[arr.length] = new Array(\"oidSeccion\", get(\"frmFormulario.oidSeccion\")+\"\"); \r		arr[arr.length] = new Array(\"oidPais\", get(\"frmFormulario.oidPais\")+\"\");\r		arr[arr.length] = new Array(\"oidIdioma\", get(\"frmFormulario.oidIdioma\")+\"\");\r		\r		configurarPaginado(mipgndo,\"INCConsultarDetallePremioArticulo\",\r							\"ConectorConsultarDetallePremioArticulo\",\"es.indra.sicc.dtos.inc.DTOCabeceraConsultaIntegral\",arr);		\r	}\r\r	function cargarListaPremioMonetario() {\r		var arr = new Array();\r		arr[arr.length] = new Array(\"oidConcurso\", get(\"frmFormulario.oidConcurso\")+\"\");\r		arr[arr.length] = new Array(\"oidCliente\", get(\"frmFormulario.oidCliente\")+\"\");\r		arr[arr.length] = new Array(\"numeroConcurso\", get(\"frmFormulario.lanumeroConcurso\")+\"\");\r		arr[arr.length] = new Array(\"oidRegion\", get(\"frmFormulario.oidRegion\")+\"\"); \r		arr[arr.length] = new Array(\"oidZona\", get(\"frmFormulario.oidZona\")+\"\");\r		arr[arr.length] = new Array(\"oidSeccion\", get(\"frmFormulario.oidSeccion\")+\"\"); \r		arr[arr.length] = new Array(\"oidPais\", get(\"frmFormulario.oidPais\")+\"\");\r		arr[arr.length] = new Array(\"oidIdioma\", get(\"frmFormulario.oidIdioma\")+\"\");\r		\r		configurarPaginado(mipgndo2,\"INCConsultarDetallePremioMonetario\",\r							\"ConectorConsultarDetallePremioMonetario\",\"es.indra.sicc.dtos.inc.DTOCabeceraConsultaIntegral\",arr);		\r	}\r\r	function cargarListaPremioPuntos() {\r		var arr = new Array();\r		arr[arr.length] = new Array(\"oidConcurso\", get(\"frmFormulario.oidConcurso\")+\"\");\r		arr[arr.length] = new Array(\"oidCliente\", get(\"frmFormulario.oidCliente\")+\"\");\r		arr[arr.length] = new Array(\"numeroConcurso\", get(\"frmFormulario.lanumeroConcurso\")+\"\");\r		arr[arr.length] = new Array(\"oidRegion\", get(\"frmFormulario.oidRegion\")+\"\"); \r		arr[arr.length] = new Array(\"oidZona\", get(\"frmFormulario.oidZona\")+\"\");\r		arr[arr.length] = new Array(\"oidSeccion\", get(\"frmFormulario.oidSeccion\")+\"\"); \r		arr[arr.length] = new Array(\"oidPais\", get(\"frmFormulario.oidPais\")+\"\");\r		arr[arr.length] = new Array(\"oidIdioma\", get(\"frmFormulario.oidIdioma\")+\"\");\r		\r		configurarPaginado(mipgndo3,\"INCConsultarDetallePremioPuntos\",\r							\"ConectorConsultarDetallePremioPuntos\",\"es.indra.sicc.dtos.inc.DTOCabeceraConsultaIntegral\",arr);		\r	}\r\r	function cargarListaPremioDescuento() {\r		var arr = new Array();\r		arr[arr.length] = new Array(\"oidConcurso\", get(\"frmFormulario.oidConcurso\")+\"\");\r		arr[arr.length] = new Array(\"oidCliente\", get(\"frmFormulario.oidCliente\")+\"\");\r		arr[arr.length] = new Array(\"numeroConcurso\", get(\"frmFormulario.lanumeroConcurso\")+\"\");\r		arr[arr.length] = new Array(\"oidRegion\", get(\"frmFormulario.oidRegion\")+\"\"); \r		arr[arr.length] = new Array(\"oidZona\", get(\"frmFormulario.oidZona\")+\"\");\r		arr[arr.length] = new Array(\"oidSeccion\", get(\"frmFormulario.oidSeccion\")+\"\"); \r		arr[arr.length] = new Array(\"oidPais\", get(\"frmFormulario.oidPais\")+\"\");\r		arr[arr.length] = new Array(\"oidIdioma\", get(\"frmFormulario.oidIdioma\")+\"\");\r		\r		configurarPaginado(mipgndo4,\"INCConsultarDetallePremioDescuento\",\r							\"ConectorConsultarDetallePremioDescuento\",\"es.indra.sicc.dtos.inc.DTOCabeceraConsultaIntegral\",arr);		\r	}\r\r	function muestraLista(ultima, rowset, error) {\r			return true;\r	}\r\r\r\r\r  \r  "));
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
      ((Element)v.get(11)).setAttribute("nombre","laCodigoCliente" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","laNombreApellido" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","laNumeroConcurso" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","laDescripcionConcurso" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","oidConcurso" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","oidCliente" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","oidRegion" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","oidZona" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","oidSeccion" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","oidPais" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","oidIdioma" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(22)).setAttribute("nombre","capaEspacio1" );
      ((Element)v.get(22)).setAttribute("x","0" );
      ((Element)v.get(22)).setAttribute("y","0" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(6)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("table"));
      ((Element)v.get(23)).setAttribute("width","100%" );
      ((Element)v.get(23)).setAttribute("border","0" );
      ((Element)v.get(23)).setAttribute("cellspacing","0" );
      ((Element)v.get(23)).setAttribute("cellpadding","0" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).setAttribute("width","12" );
      ((Element)v.get(25)).setAttribute("align","center" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(26)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).setAttribute("width","12" );
      ((Element)v.get(26)).setAttribute("height","12" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:25   */

      /* Empieza nodo:27 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).setAttribute("width","750" );
      ((Element)v.get(24)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:29 / Elemento padre: 24   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).setAttribute("width","12" );
      ((Element)v.get(24)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(30)).setAttribute("src","b.gif" );
      ((Element)v.get(30)).setAttribute("width","12" );
      ((Element)v.get(30)).setAttribute("height","1" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */
      /* Termina nodo:24   */

      /* Empieza nodo:31 / Elemento padre: 23   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(23)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(33)).setAttribute("src","b.gif" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:34 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(36)).setAttribute("class","legend" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(37)).setAttribute("nombre","lblDatosCabecera" );
      ((Element)v.get(37)).setAttribute("alto","13" );
      ((Element)v.get(37)).setAttribute("filas","1" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(37)).setAttribute("id","legend" );
      ((Element)v.get(37)).setAttribute("cod","00156" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:38 / Elemento padre: 35   */
      v.add(doc.createElement("table"));
      ((Element)v.get(38)).setAttribute("width","100%" );
      ((Element)v.get(38)).setAttribute("border","0" );
      ((Element)v.get(38)).setAttribute("align","center" );
      ((Element)v.get(38)).setAttribute("cellspacing","0" );
      ((Element)v.get(38)).setAttribute("cellpadding","0" );
      ((Element)v.get(35)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("table"));
      ((Element)v.get(41)).setAttribute("width","734" );
      ((Element)v.get(41)).setAttribute("border","0" );
      ((Element)v.get(41)).setAttribute("align","left" );
      ((Element)v.get(41)).setAttribute("cellspacing","0" );
      ((Element)v.get(41)).setAttribute("cellpadding","0" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).setAttribute("colspan","3" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).setAttribute("width","8" );
      ((Element)v.get(44)).setAttribute("height","8" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:45 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","8" );
      ((Element)v.get(47)).setAttribute("height","8" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(49)).setAttribute("nombre","lblCodCliente" );
      ((Element)v.get(49)).setAttribute("alto","13" );
      ((Element)v.get(49)).setAttribute("filas","1" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(49)).setAttribute("id","datosTitle" );
      ((Element)v.get(49)).setAttribute("cod","263" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(51)).setAttribute("width","25" );
      ((Element)v.get(51)).setAttribute("height","8" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(53)).setAttribute("nombre","lblNombreApellido" );
      ((Element)v.get(53)).setAttribute("alto","13" );
      ((Element)v.get(53)).setAttribute("filas","1" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(53)).setAttribute("id","datosTitle" );
      ((Element)v.get(53)).setAttribute("cod","943" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 45   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).setAttribute("width","100%" );
      ((Element)v.get(45)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).setAttribute("width","8" );
      ((Element)v.get(55)).setAttribute("height","8" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */
      /* Termina nodo:45   */

      /* Empieza nodo:56 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","8" );
      ((Element)v.get(58)).setAttribute("height","8" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(60)).setAttribute("nombre","lbldtCodCliente" );
      ((Element)v.get(60)).setAttribute("alto","13" );
      ((Element)v.get(60)).setAttribute("filas","1" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(60)).setAttribute("id","datosCampos" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","25" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(64)).setAttribute("nombre","lbldtNombreApellido" );
      ((Element)v.get(64)).setAttribute("alto","13" );
      ((Element)v.get(64)).setAttribute("filas","1" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(64)).setAttribute("id","datosCampos" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("width","100%" );
      ((Element)v.get(56)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","8" );
      ((Element)v.get(66)).setAttribute("height","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:56   */

      /* Empieza nodo:67 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(67));

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
      /* Termina nodo:41   */
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:70 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("table"));
      ((Element)v.get(72)).setAttribute("width","734" );
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
      ((Element)v.get(77)).setAttribute("nombre","lblNumConcurso" );
      ((Element)v.get(77)).setAttribute("alto","13" );
      ((Element)v.get(77)).setAttribute("filas","1" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(77)).setAttribute("id","datosTitle" );
      ((Element)v.get(77)).setAttribute("cod","1604" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","25" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(81)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(81)).setAttribute("alto","13" );
      ((Element)v.get(81)).setAttribute("filas","1" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(81)).setAttribute("id","datosTitle" );
      ((Element)v.get(81)).setAttribute("cod","9" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).setAttribute("width","100%" );
      ((Element)v.get(73)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","8" );
      ((Element)v.get(83)).setAttribute("height","8" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:73   */

      /* Empieza nodo:84 / Elemento padre: 72   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(72)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","8" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(88)).setAttribute("nombre","lbldtNumConcurso" );
      ((Element)v.get(88)).setAttribute("alto","13" );
      ((Element)v.get(88)).setAttribute("filas","1" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(88)).setAttribute("id","datosCampos" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","25" );
      ((Element)v.get(90)).setAttribute("height","8" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(92)).setAttribute("nombre","lbldtDescripcion" );
      ((Element)v.get(92)).setAttribute("alto","13" );
      ((Element)v.get(92)).setAttribute("filas","1" );
      ((Element)v.get(92)).setAttribute("valor","" );
      ((Element)v.get(92)).setAttribute("id","datosCampos" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).setAttribute("width","100%" );
      ((Element)v.get(84)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","8" );
      ((Element)v.get(94)).setAttribute("height","8" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:84   */

      /* Empieza nodo:95 / Elemento padre: 72   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(72)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("colspan","3" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","8" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:38   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:98 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:31   */

      /* Empieza nodo:100 / Elemento padre: 23   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(23)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).setAttribute("width","12" );
      ((Element)v.get(101)).setAttribute("align","center" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).setAttribute("width","12" );
      ((Element)v.get(102)).setAttribute("height","12" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("width","756" );
      ((Element)v.get(100)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).setAttribute("width","12" );
      ((Element)v.get(100)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","12" );
      ((Element)v.get(106)).setAttribute("height","1" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:100   */
      /* Termina nodo:23   */
      /* Termina nodo:22   */

      /* Empieza nodo:107 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(107)).setAttribute("nombre","listado1" );
      ((Element)v.get(107)).setAttribute("ancho","738" );
      ((Element)v.get(107)).setAttribute("alto","317" );
      ((Element)v.get(107)).setAttribute("x","12" );
      ((Element)v.get(107)).setAttribute("y","158" );
      ((Element)v.get(107)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(107)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(108)).setAttribute("precarga","S" );
      ((Element)v.get(108)).setAttribute("conROver","S" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(109)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(109)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(109)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(109)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 108   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(110)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(110)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(110)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(110)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(108)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 108   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(111)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(111)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(108)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:108   */

      /* Empieza nodo:112 / Elemento padre: 107   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(107)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(113)).setAttribute("borde","1" );
      ((Element)v.get(113)).setAttribute("horizDatos","1" );
      ((Element)v.get(113)).setAttribute("horizCabecera","1" );
      ((Element)v.get(113)).setAttribute("vertical","1" );
      ((Element)v.get(113)).setAttribute("horizTitulo","1" );
      ((Element)v.get(113)).setAttribute("horizBase","1" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */

      /* Empieza nodo:114 / Elemento padre: 112   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(114)).setAttribute("borde","#999999" );
      ((Element)v.get(114)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(114)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(114)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(114)).setAttribute("horizCabecera","#999999" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(114)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(114)).setAttribute("horizBase","#999999" );
      ((Element)v.get(112)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:112   */

      /* Empieza nodo:115 / Elemento padre: 107   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(115)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(115)).setAttribute("alto","22" );
      ((Element)v.get(115)).setAttribute("imgFondo","" );
      ((Element)v.get(115)).setAttribute("cod","00352" );
      ((Element)v.get(115)).setAttribute("ID","datosTitle" );
      ((Element)v.get(107)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */

      /* Empieza nodo:116 / Elemento padre: 107   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(116)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(116)).setAttribute("alto","22" );
      ((Element)v.get(116)).setAttribute("imgFondo","" );
      ((Element)v.get(107)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */

      /* Empieza nodo:117 / Elemento padre: 107   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(117)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(117)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(117)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(117)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(117)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(117)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(107)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(118)).setAttribute("ancho","100" );
      ((Element)v.get(118)).setAttribute("minimizable","S" );
      ((Element)v.get(118)).setAttribute("minimizada","N" );
      ((Element)v.get(118)).setAttribute("oculta","S" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */

      /* Empieza nodo:119 / Elemento padre: 117   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(119)).setAttribute("ancho","100" );
      ((Element)v.get(119)).setAttribute("minimizable","S" );
      ((Element)v.get(119)).setAttribute("minimizada","N" );
      ((Element)v.get(119)).setAttribute("oculta","S" );
      ((Element)v.get(117)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */

      /* Empieza nodo:120 / Elemento padre: 117   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(120)).setAttribute("ancho","100" );
      ((Element)v.get(120)).setAttribute("minimizable","S" );
      ((Element)v.get(120)).setAttribute("minimizada","N" );
      ((Element)v.get(117)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 117   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(121)).setAttribute("ancho","100" );
      ((Element)v.get(121)).setAttribute("minimizable","S" );
      ((Element)v.get(121)).setAttribute("minimizada","N" );
      ((Element)v.get(117)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */

      /* Empieza nodo:122 / Elemento padre: 117   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(122)).setAttribute("ancho","100" );
      ((Element)v.get(122)).setAttribute("minimizable","S" );
      ((Element)v.get(122)).setAttribute("minimizada","N" );
      ((Element)v.get(117)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 117   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(123)).setAttribute("ancho","100" );
      ((Element)v.get(123)).setAttribute("minimizable","S" );
      ((Element)v.get(123)).setAttribute("minimizada","N" );
      ((Element)v.get(123)).setAttribute("oculta","S" );
      ((Element)v.get(117)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 117   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(124)).setAttribute("ancho","90" );
      ((Element)v.get(124)).setAttribute("minimizable","S" );
      ((Element)v.get(124)).setAttribute("minimizada","N" );
      ((Element)v.get(124)).setAttribute("oculta","S" );
      ((Element)v.get(117)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */

      /* Empieza nodo:125 / Elemento padre: 117   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(125)).setAttribute("ancho","100" );
      ((Element)v.get(125)).setAttribute("minimizable","S" );
      ((Element)v.get(125)).setAttribute("minimizada","N" );
      ((Element)v.get(117)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 117   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(126)).setAttribute("ancho","150" );
      ((Element)v.get(126)).setAttribute("minimizable","S" );
      ((Element)v.get(126)).setAttribute("minimizada","N" );
      ((Element)v.get(117)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 117   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(127)).setAttribute("ancho","100" );
      ((Element)v.get(127)).setAttribute("minimizable","S" );
      ((Element)v.get(127)).setAttribute("minimizada","N" );
      ((Element)v.get(127)).setAttribute("oculta","S" );
      ((Element)v.get(117)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */

      /* Empieza nodo:128 / Elemento padre: 117   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(128)).setAttribute("ancho","90" );
      ((Element)v.get(128)).setAttribute("minimizable","S" );
      ((Element)v.get(128)).setAttribute("minimizada","N" );
      ((Element)v.get(117)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */

      /* Empieza nodo:129 / Elemento padre: 117   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(129)).setAttribute("ancho","200" );
      ((Element)v.get(129)).setAttribute("minimizable","S" );
      ((Element)v.get(129)).setAttribute("minimizada","N" );
      ((Element)v.get(117)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */

      /* Empieza nodo:130 / Elemento padre: 117   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(130)).setAttribute("ancho","150" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(130)).setAttribute("minimizable","S" );
      ((Element)v.get(130)).setAttribute("minimizada","N" );
      ((Element)v.get(117)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 117   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(131)).setAttribute("ancho","100" );
      ((Element)v.get(131)).setAttribute("minimizable","S" );
      ((Element)v.get(131)).setAttribute("minimizada","N" );
      ((Element)v.get(117)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 117   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(132)).setAttribute("ancho","120" );
      ((Element)v.get(132)).setAttribute("minimizable","S" );
      ((Element)v.get(132)).setAttribute("minimizada","N" );
      ((Element)v.get(117)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */

      /* Empieza nodo:133 / Elemento padre: 117   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(133)).setAttribute("ancho","100" );
      ((Element)v.get(133)).setAttribute("minimizable","S" );
      ((Element)v.get(133)).setAttribute("minimizada","N" );
      ((Element)v.get(117)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 117   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(134)).setAttribute("ancho","150" );
      ((Element)v.get(134)).setAttribute("minimizable","S" );
      ((Element)v.get(134)).setAttribute("minimizada","N" );
      ((Element)v.get(117)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:117   */

      /* Empieza nodo:135 / Elemento padre: 107   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(135)).setAttribute("alto","20" );
      ((Element)v.get(135)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(135)).setAttribute("imgFondo","" );
      ((Element)v.get(135)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(107)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(136)).setAttribute("colFondo","" );
      ((Element)v.get(136)).setAttribute("ID","EstCab" );
      ((Element)v.get(136)).setAttribute("cod","" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Elemento padre:136 / Elemento actual: 137   */
      v.add(doc.createTextNode("OID"));
      ((Element)v.get(136)).appendChild((Text)v.get(137));

      /* Termina nodo Texto:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 135   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(138)).setAttribute("colFondo","" );
      ((Element)v.get(138)).setAttribute("ID","EstCab" );
      ((Element)v.get(138)).setAttribute("cod","" );
      ((Element)v.get(135)).appendChild((Element)v.get(138));

      /* Elemento padre:138 / Elemento actual: 139   */
      v.add(doc.createTextNode("CLIE_OID_CLIE"));
      ((Element)v.get(138)).appendChild((Text)v.get(139));

      /* Termina nodo Texto:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 135   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(140)).setAttribute("colFondo","" );
      ((Element)v.get(140)).setAttribute("ID","EstCab" );
      ((Element)v.get(140)).setAttribute("cod","422" );
      ((Element)v.get(135)).appendChild((Element)v.get(140));

      /* Elemento padre:140 / Elemento actual: 141   */
      v.add(doc.createTextNode("Nº documento"));
      ((Element)v.get(140)).appendChild((Text)v.get(141));

      /* Termina nodo Texto:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:142 / Elemento padre: 135   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(142)).setAttribute("colFondo","" );
      ((Element)v.get(142)).setAttribute("ID","EstCab" );
      ((Element)v.get(142)).setAttribute("cod","1920" );
      ((Element)v.get(135)).appendChild((Element)v.get(142));

      /* Elemento padre:142 / Elemento actual: 143   */
      v.add(doc.createTextNode("Tipo doc."));
      ((Element)v.get(142)).appendChild((Text)v.get(143));

      /* Termina nodo Texto:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:144 / Elemento padre: 135   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(144)).setAttribute("colFondo","" );
      ((Element)v.get(144)).setAttribute("ID","EstCab" );
      ((Element)v.get(144)).setAttribute("cod","2876" );
      ((Element)v.get(135)).appendChild((Element)v.get(144));

      /* Elemento padre:144 / Elemento actual: 145   */
      v.add(doc.createTextNode("Fecha obtención"));
      ((Element)v.get(144)).appendChild((Text)v.get(145));

      /* Termina nodo Texto:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:146 / Elemento padre: 135   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(146)).setAttribute("colFondo","" );
      ((Element)v.get(146)).setAttribute("ID","EstCab" );
      ((Element)v.get(146)).setAttribute("cod","2876" );
      ((Element)v.get(135)).appendChild((Element)v.get(146));

      /* Elemento padre:146 / Elemento actual: 147   */
      v.add(doc.createTextNode("NUMERO_CONCURSO"));
      ((Element)v.get(146)).appendChild((Text)v.get(147));

      /* Termina nodo Texto:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:148 / Elemento padre: 135   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(148)).setAttribute("colFondo","" );
      ((Element)v.get(148)).setAttribute("ID","EstCab" );
      ((Element)v.get(148)).setAttribute("cod","2876" );
      ((Element)v.get(135)).appendChild((Element)v.get(148));

      /* Elemento padre:148 / Elemento actual: 149   */
      v.add(doc.createTextNode("DESC_CONCURSO"));
      ((Element)v.get(148)).appendChild((Text)v.get(149));

      /* Termina nodo Texto:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 135   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(150)).setAttribute("colFondo","" );
      ((Element)v.get(150)).setAttribute("ID","EstCab" );
      ((Element)v.get(150)).setAttribute("cod","357" );
      ((Element)v.get(135)).appendChild((Element)v.get(150));

      /* Elemento padre:150 / Elemento actual: 151   */
      v.add(doc.createTextNode("Nivel"));
      ((Element)v.get(150)).appendChild((Text)v.get(151));

      /* Termina nodo Texto:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 135   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(152)).setAttribute("colFondo","" );
      ((Element)v.get(152)).setAttribute("ID","EstCab" );
      ((Element)v.get(152)).setAttribute("cod","1691" );
      ((Element)v.get(135)).appendChild((Element)v.get(152));

      /* Elemento padre:152 / Elemento actual: 153   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createTextNode("Nº premio"));
      ((Element)v.get(152)).appendChild((Text)v.get(153));

      /* Termina nodo Texto:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:154 / Elemento padre: 135   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(154)).setAttribute("colFondo","" );
      ((Element)v.get(154)).setAttribute("ID","EstCab" );
      ((Element)v.get(154)).setAttribute("cod","2876" );
      ((Element)v.get(135)).appendChild((Element)v.get(154));

      /* Elemento padre:154 / Elemento actual: 155   */
      v.add(doc.createTextNode("TIPO_PREMIO"));
      ((Element)v.get(154)).appendChild((Text)v.get(155));

      /* Termina nodo Texto:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:156 / Elemento padre: 135   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(156)).setAttribute("colFondo","" );
      ((Element)v.get(156)).setAttribute("ID","EstCab" );
      ((Element)v.get(156)).setAttribute("cod","337" );
      ((Element)v.get(135)).appendChild((Element)v.get(156));

      /* Elemento padre:156 / Elemento actual: 157   */
      v.add(doc.createTextNode("Cód. producto"));
      ((Element)v.get(156)).appendChild((Text)v.get(157));

      /* Termina nodo Texto:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:158 / Elemento padre: 135   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(158)).setAttribute("colFondo","" );
      ((Element)v.get(158)).setAttribute("ID","EstCab" );
      ((Element)v.get(158)).setAttribute("cod","2895" );
      ((Element)v.get(135)).appendChild((Element)v.get(158));

      /* Elemento padre:158 / Elemento actual: 159   */
      v.add(doc.createTextNode("Descripción premio"));
      ((Element)v.get(158)).appendChild((Text)v.get(159));

      /* Termina nodo Texto:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 135   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(160)).setAttribute("colFondo","" );
      ((Element)v.get(160)).setAttribute("ID","EstCab" );
      ((Element)v.get(160)).setAttribute("cod","1853" );
      ((Element)v.get(135)).appendChild((Element)v.get(160));

      /* Elemento padre:160 / Elemento actual: 161   */
      v.add(doc.createTextNode("Cód. venta ficticio"));
      ((Element)v.get(160)).appendChild((Text)v.get(161));

      /* Termina nodo Texto:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 135   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(162)).setAttribute("colFondo","" );
      ((Element)v.get(162)).setAttribute("ID","EstCab" );
      ((Element)v.get(162)).setAttribute("cod","1172" );
      ((Element)v.get(135)).appendChild((Element)v.get(162));

      /* Elemento padre:162 / Elemento actual: 163   */
      v.add(doc.createTextNode("Cantidad"));
      ((Element)v.get(162)).appendChild((Text)v.get(163));

      /* Termina nodo Texto:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 135   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(164)).setAttribute("colFondo","" );
      ((Element)v.get(164)).setAttribute("ID","EstCab" );
      ((Element)v.get(164)).setAttribute("cod","695" );
      ((Element)v.get(135)).appendChild((Element)v.get(164));

      /* Elemento padre:164 / Elemento actual: 165   */
      v.add(doc.createTextNode("Situación"));
      ((Element)v.get(164)).appendChild((Text)v.get(165));

      /* Termina nodo Texto:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 135   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(166)).setAttribute("colFondo","" );
      ((Element)v.get(166)).setAttribute("ID","EstCab" );
      ((Element)v.get(166)).setAttribute("cod","526" );
      ((Element)v.get(135)).appendChild((Element)v.get(166));

      /* Elemento padre:166 / Elemento actual: 167   */
      v.add(doc.createTextNode("Reemplazo"));
      ((Element)v.get(166)).appendChild((Text)v.get(167));

      /* Termina nodo Texto:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:168 / Elemento padre: 135   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(168)).setAttribute("colFondo","" );
      ((Element)v.get(168)).setAttribute("ID","EstCab" );
      ((Element)v.get(168)).setAttribute("cod","2889" );
      ((Element)v.get(135)).appendChild((Element)v.get(168));

      /* Elemento padre:168 / Elemento actual: 169   */
      v.add(doc.createTextNode("Campaña despacho"));
      ((Element)v.get(168)).appendChild((Text)v.get(169));

      /* Termina nodo Texto:169   */
      /* Termina nodo:168   */
      /* Termina nodo:135   */

      /* Empieza nodo:170 / Elemento padre: 107   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(170)).setAttribute("alto","22" );
      ((Element)v.get(170)).setAttribute("accion","" );
      ((Element)v.get(170)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(170)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(170)).setAttribute("maxSel","-1" );
      ((Element)v.get(170)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(170)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(170)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(170)).setAttribute("onLoad","" );
      ((Element)v.get(170)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(107)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(171)).setAttribute("tipo","texto" );
      ((Element)v.get(171)).setAttribute("ID","EstDat" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */

      /* Empieza nodo:172 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(172)).setAttribute("tipo","texto" );
      ((Element)v.get(172)).setAttribute("ID","EstDat" );
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
   }

   private void getXML720(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(176)).setAttribute("tipo","texto" );
      ((Element)v.get(176)).setAttribute("ID","EstDat" );
      ((Element)v.get(170)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */

      /* Empieza nodo:177 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(177)).setAttribute("tipo","texto" );
      ((Element)v.get(177)).setAttribute("ID","EstDat2" );
      ((Element)v.get(170)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(178)).setAttribute("tipo","texto" );
      ((Element)v.get(178)).setAttribute("ID","EstDat2" );
      ((Element)v.get(170)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */

      /* Empieza nodo:179 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(179)).setAttribute("tipo","texto" );
      ((Element)v.get(179)).setAttribute("ID","EstDat" );
      ((Element)v.get(170)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */

      /* Empieza nodo:180 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(180)).setAttribute("tipo","texto" );
      ((Element)v.get(180)).setAttribute("ID","EstDat" );
      ((Element)v.get(170)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(181)).setAttribute("tipo","texto" );
      ((Element)v.get(181)).setAttribute("ID","EstDat2" );
      ((Element)v.get(170)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */

      /* Empieza nodo:182 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(182)).setAttribute("tipo","texto" );
      ((Element)v.get(182)).setAttribute("ID","EstDat" );
      ((Element)v.get(170)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(183)).setAttribute("tipo","texto" );
      ((Element)v.get(183)).setAttribute("ID","EstDat2" );
      ((Element)v.get(170)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */

      /* Empieza nodo:184 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(184)).setAttribute("tipo","texto" );
      ((Element)v.get(184)).setAttribute("ID","EstDat" );
      ((Element)v.get(170)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */

      /* Empieza nodo:185 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(185)).setAttribute("tipo","texto" );
      ((Element)v.get(185)).setAttribute("ID","EstDat2" );
      ((Element)v.get(170)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */

      /* Empieza nodo:186 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(186)).setAttribute("tipo","texto" );
      ((Element)v.get(186)).setAttribute("ID","EstDat" );
      ((Element)v.get(170)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */

      /* Empieza nodo:187 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(187)).setAttribute("tipo","texto" );
      ((Element)v.get(187)).setAttribute("ID","EstDat2" );
      ((Element)v.get(170)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:170   */

      /* Empieza nodo:188 / Elemento padre: 107   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(107)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */

      /* Empieza nodo:189 / Elemento padre: 107   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(189)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(189)).setAttribute("ancho","738" );
      ((Element)v.get(189)).setAttribute("sep","$" );
      ((Element)v.get(189)).setAttribute("x","12" );
      ((Element)v.get(189)).setAttribute("class","botonera" );
      ((Element)v.get(189)).setAttribute("y","452" );
      ((Element)v.get(189)).setAttribute("control","|" );
      ((Element)v.get(189)).setAttribute("conector","" );
      ((Element)v.get(189)).setAttribute("rowset","" );
      ((Element)v.get(189)).setAttribute("cargainicial","N" );
      ((Element)v.get(189)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(107)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(190)).setAttribute("nombre","ret1" );
      ((Element)v.get(190)).setAttribute("x","37" );
      ((Element)v.get(190)).setAttribute("y","456" );
      ((Element)v.get(190)).setAttribute("ID","botonContenido" );
      ((Element)v.get(190)).setAttribute("img","retroceder_on" );
      ((Element)v.get(190)).setAttribute("tipo","0" );
      ((Element)v.get(190)).setAttribute("estado","false" );
      ((Element)v.get(190)).setAttribute("alt","" );
      ((Element)v.get(190)).setAttribute("codigo","" );
      ((Element)v.get(190)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */

      /* Empieza nodo:191 / Elemento padre: 189   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(191)).setAttribute("nombre","ava1" );
      ((Element)v.get(191)).setAttribute("x","52" );
      ((Element)v.get(191)).setAttribute("y","456" );
      ((Element)v.get(191)).setAttribute("ID","botonContenido" );
      ((Element)v.get(191)).setAttribute("img","avanzar_on" );
      ((Element)v.get(191)).setAttribute("tipo","0" );
      ((Element)v.get(191)).setAttribute("estado","false" );
      ((Element)v.get(191)).setAttribute("alt","" );
      ((Element)v.get(191)).setAttribute("codigo","" );
      ((Element)v.get(191)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(189)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:189   */
      /* Termina nodo:107   */

      /* Empieza nodo:192 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(192)).setAttribute("nombre","primera1" );
      ((Element)v.get(192)).setAttribute("x","20" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(192)).setAttribute("y","456" );
      ((Element)v.get(192)).setAttribute("ID","botonContenido" );
      ((Element)v.get(192)).setAttribute("img","primera_on" );
      ((Element)v.get(192)).setAttribute("tipo","0" );
      ((Element)v.get(192)).setAttribute("estado","false" );
      ((Element)v.get(192)).setAttribute("alt","" );
      ((Element)v.get(192)).setAttribute("codigo","" );
      ((Element)v.get(192)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */

      /* Empieza nodo:193 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(193)).setAttribute("nombre","separa" );
      ((Element)v.get(193)).setAttribute("x","59" );
      ((Element)v.get(193)).setAttribute("y","452" );
      ((Element)v.get(193)).setAttribute("ID","botonContenido" );
      ((Element)v.get(193)).setAttribute("img","separa_base" );
      ((Element)v.get(193)).setAttribute("tipo","0" );
      ((Element)v.get(193)).setAttribute("estado","false" );
      ((Element)v.get(193)).setAttribute("alt","" );
      ((Element)v.get(193)).setAttribute("codigo","" );
      ((Element)v.get(193)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */

      /* Empieza nodo:194 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(194)).setAttribute("nombre","listado2" );
      ((Element)v.get(194)).setAttribute("ancho","738" );
      ((Element)v.get(194)).setAttribute("alto","317" );
      ((Element)v.get(194)).setAttribute("x","12" );
      ((Element)v.get(194)).setAttribute("y","499" );
      ((Element)v.get(194)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(194)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(195)).setAttribute("precarga","S" );
      ((Element)v.get(195)).setAttribute("conROver","S" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(196)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(196)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(196)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(196)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */

      /* Empieza nodo:197 / Elemento padre: 195   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(197)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(197)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(197)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(197)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(195)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */

      /* Empieza nodo:198 / Elemento padre: 195   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(198)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(198)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(195)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:195   */

      /* Empieza nodo:199 / Elemento padre: 194   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(194)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(200)).setAttribute("borde","1" );
      ((Element)v.get(200)).setAttribute("horizDatos","1" );
      ((Element)v.get(200)).setAttribute("horizCabecera","1" );
      ((Element)v.get(200)).setAttribute("vertical","1" );
      ((Element)v.get(200)).setAttribute("horizTitulo","1" );
      ((Element)v.get(200)).setAttribute("horizBase","1" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */

      /* Empieza nodo:201 / Elemento padre: 199   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(201)).setAttribute("borde","#999999" );
      ((Element)v.get(201)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(201)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(201)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(201)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(201)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(201)).setAttribute("horizBase","#999999" );
      ((Element)v.get(199)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:199   */

      /* Empieza nodo:202 / Elemento padre: 194   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(202)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(202)).setAttribute("alto","22" );
      ((Element)v.get(202)).setAttribute("imgFondo","" );
      ((Element)v.get(202)).setAttribute("cod","00348" );
      ((Element)v.get(202)).setAttribute("ID","datosTitle" );
      ((Element)v.get(194)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */

      /* Empieza nodo:203 / Elemento padre: 194   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(203)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(203)).setAttribute("alto","22" );
      ((Element)v.get(203)).setAttribute("imgFondo","" );
      ((Element)v.get(194)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */

      /* Empieza nodo:204 / Elemento padre: 194   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(204)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(204)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(204)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(204)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(204)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(204)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(194)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("COL"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(205)).setAttribute("ancho","100" );
      ((Element)v.get(205)).setAttribute("minimizable","S" );
      ((Element)v.get(205)).setAttribute("minimizada","N" );
      ((Element)v.get(205)).setAttribute("oculta","S" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */

      /* Empieza nodo:206 / Elemento padre: 204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(206)).setAttribute("ancho","100" );
      ((Element)v.get(206)).setAttribute("minimizable","S" );
      ((Element)v.get(206)).setAttribute("minimizada","N" );
      ((Element)v.get(206)).setAttribute("oculta","S" );
      ((Element)v.get(204)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */

      /* Empieza nodo:207 / Elemento padre: 204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(207)).setAttribute("ancho","100" );
      ((Element)v.get(207)).setAttribute("minimizable","S" );
      ((Element)v.get(207)).setAttribute("minimizada","N" );
      ((Element)v.get(204)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */

      /* Empieza nodo:208 / Elemento padre: 204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(208)).setAttribute("ancho","100" );
      ((Element)v.get(208)).setAttribute("minimizable","S" );
      ((Element)v.get(208)).setAttribute("minimizada","N" );
      ((Element)v.get(208)).setAttribute("oculta","S" );
      ((Element)v.get(204)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */

      /* Empieza nodo:209 / Elemento padre: 204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(209)).setAttribute("ancho","100" );
      ((Element)v.get(209)).setAttribute("minimizable","S" );
      ((Element)v.get(209)).setAttribute("minimizada","N" );
      ((Element)v.get(209)).setAttribute("oculta","S" );
      ((Element)v.get(204)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */

      /* Empieza nodo:210 / Elemento padre: 204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(210)).setAttribute("ancho","100" );
      ((Element)v.get(210)).setAttribute("minimizable","S" );
      ((Element)v.get(210)).setAttribute("minimizada","N" );
      ((Element)v.get(204)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */

      /* Empieza nodo:211 / Elemento padre: 204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(211)).setAttribute("ancho","100" );
      ((Element)v.get(211)).setAttribute("minimizable","S" );
      ((Element)v.get(211)).setAttribute("minimizada","N" );
      ((Element)v.get(204)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */

      /* Empieza nodo:212 / Elemento padre: 204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(212)).setAttribute("ancho","90" );
      ((Element)v.get(212)).setAttribute("minimizable","S" );
      ((Element)v.get(212)).setAttribute("minimizada","N" );
      ((Element)v.get(212)).setAttribute("oculta","S" );
      ((Element)v.get(204)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */

      /* Empieza nodo:213 / Elemento padre: 204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(213)).setAttribute("ancho","100" );
      ((Element)v.get(213)).setAttribute("minimizable","S" );
      ((Element)v.get(213)).setAttribute("minimizada","N" );
      ((Element)v.get(204)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */

      /* Empieza nodo:214 / Elemento padre: 204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(214)).setAttribute("ancho","100" );
      ((Element)v.get(214)).setAttribute("minimizable","S" );
      ((Element)v.get(214)).setAttribute("minimizada","N" );
      ((Element)v.get(204)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */

      /* Empieza nodo:215 / Elemento padre: 204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(215)).setAttribute("ancho","100" );
      ((Element)v.get(215)).setAttribute("minimizable","S" );
      ((Element)v.get(215)).setAttribute("minimizada","N" );
      ((Element)v.get(204)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */

      /* Empieza nodo:216 / Elemento padre: 204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(216)).setAttribute("ancho","90" );
      ((Element)v.get(216)).setAttribute("minimizable","S" );
      ((Element)v.get(216)).setAttribute("minimizada","N" );
      ((Element)v.get(204)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */

      /* Empieza nodo:217 / Elemento padre: 204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(217)).setAttribute("ancho","100" );
      ((Element)v.get(217)).setAttribute("minimizable","S" );
      ((Element)v.get(217)).setAttribute("minimizada","N" );
      ((Element)v.get(217)).setAttribute("oculta","S" );
      ((Element)v.get(204)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */

      /* Empieza nodo:218 / Elemento padre: 204   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(218)).setAttribute("ancho","150" );
      ((Element)v.get(218)).setAttribute("minimizable","S" );
      ((Element)v.get(218)).setAttribute("minimizada","N" );
      ((Element)v.get(204)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:204   */

      /* Empieza nodo:219 / Elemento padre: 194   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(219)).setAttribute("alto","20" );
      ((Element)v.get(219)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(219)).setAttribute("imgFondo","" );
      ((Element)v.get(219)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(194)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(220)).setAttribute("colFondo","" );
      ((Element)v.get(220)).setAttribute("ID","EstCab" );
      ((Element)v.get(220)).setAttribute("cod","" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));

      /* Elemento padre:220 / Elemento actual: 221   */
      v.add(doc.createTextNode("OID"));
      ((Element)v.get(220)).appendChild((Text)v.get(221));

      /* Termina nodo Texto:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:222 / Elemento padre: 219   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(222)).setAttribute("colFondo","" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(222)).setAttribute("ID","EstCab" );
      ((Element)v.get(222)).setAttribute("cod","1" );
      ((Element)v.get(219)).appendChild((Element)v.get(222));

      /* Elemento padre:222 / Elemento actual: 223   */
      v.add(doc.createTextNode("CLIE_OID_CLIE"));
      ((Element)v.get(222)).appendChild((Text)v.get(223));

      /* Termina nodo Texto:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:224 / Elemento padre: 219   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(224)).setAttribute("colFondo","" );
      ((Element)v.get(224)).setAttribute("ID","EstCab" );
      ((Element)v.get(224)).setAttribute("cod","2876" );
      ((Element)v.get(219)).appendChild((Element)v.get(224));

      /* Elemento padre:224 / Elemento actual: 225   */
      v.add(doc.createTextNode("Fecha obtención"));
      ((Element)v.get(224)).appendChild((Text)v.get(225));

      /* Termina nodo Texto:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:226 / Elemento padre: 219   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(226)).setAttribute("colFondo","" );
      ((Element)v.get(226)).setAttribute("ID","EstCab" );
      ((Element)v.get(226)).setAttribute("cod","1" );
      ((Element)v.get(219)).appendChild((Element)v.get(226));

      /* Elemento padre:226 / Elemento actual: 227   */
      v.add(doc.createTextNode("NUMERO_CONCURSO"));
      ((Element)v.get(226)).appendChild((Text)v.get(227));

      /* Termina nodo Texto:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 219   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(228)).setAttribute("colFondo","" );
      ((Element)v.get(228)).setAttribute("ID","EstCab" );
      ((Element)v.get(228)).setAttribute("cod","1" );
      ((Element)v.get(219)).appendChild((Element)v.get(228));

      /* Elemento padre:228 / Elemento actual: 229   */
      v.add(doc.createTextNode("DESC_CONCURSO"));
      ((Element)v.get(228)).appendChild((Text)v.get(229));

      /* Termina nodo Texto:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:230 / Elemento padre: 219   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(230)).setAttribute("colFondo","" );
      ((Element)v.get(230)).setAttribute("ID","EstCab" );
      ((Element)v.get(230)).setAttribute("cod","357" );
      ((Element)v.get(219)).appendChild((Element)v.get(230));

      /* Elemento padre:230 / Elemento actual: 231   */
      v.add(doc.createTextNode("Nivel"));
      ((Element)v.get(230)).appendChild((Text)v.get(231));

      /* Termina nodo Texto:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:232 / Elemento padre: 219   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(232)).setAttribute("colFondo","" );
      ((Element)v.get(232)).setAttribute("ID","EstCab" );
      ((Element)v.get(232)).setAttribute("cod","1691" );
      ((Element)v.get(219)).appendChild((Element)v.get(232));

      /* Elemento padre:232 / Elemento actual: 233   */
      v.add(doc.createTextNode("Nº premio"));
      ((Element)v.get(232)).appendChild((Text)v.get(233));

      /* Termina nodo Texto:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:234 / Elemento padre: 219   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(234)).setAttribute("colFondo","" );
      ((Element)v.get(234)).setAttribute("ID","EstCab" );
      ((Element)v.get(234)).setAttribute("cod","1" );
      ((Element)v.get(219)).appendChild((Element)v.get(234));

      /* Elemento padre:234 / Elemento actual: 235   */
      v.add(doc.createTextNode("TIPO_PREMIO"));
      ((Element)v.get(234)).appendChild((Text)v.get(235));

      /* Termina nodo Texto:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:236 / Elemento padre: 219   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(236)).setAttribute("colFondo","" );
      ((Element)v.get(236)).setAttribute("ID","EstCab" );
      ((Element)v.get(236)).setAttribute("cod","2902" );
      ((Element)v.get(219)).appendChild((Element)v.get(236));

      /* Elemento padre:236 / Elemento actual: 237   */
      v.add(doc.createTextNode("Tipo moneda"));
      ((Element)v.get(236)).appendChild((Text)v.get(237));

      /* Termina nodo Texto:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:238 / Elemento padre: 219   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(238)).setAttribute("colFondo","" );
      ((Element)v.get(238)).setAttribute("ID","EstCab" );
      ((Element)v.get(238)).setAttribute("cod","573" );
      ((Element)v.get(219)).appendChild((Element)v.get(238));

      /* Elemento padre:238 / Elemento actual: 239   */
      v.add(doc.createTextNode("Importe"));
      ((Element)v.get(238)).appendChild((Text)v.get(239));

      /* Termina nodo Texto:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:240 / Elemento padre: 219   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(240)).setAttribute("colFondo","" );
      ((Element)v.get(240)).setAttribute("ID","EstCab" );
      ((Element)v.get(240)).setAttribute("cod","1390" );
      ((Element)v.get(219)).appendChild((Element)v.get(240));

      /* Elemento padre:240 / Elemento actual: 241   */
      v.add(doc.createTextNode("Destino"));
      ((Element)v.get(240)).appendChild((Text)v.get(241));

      /* Termina nodo Texto:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:242 / Elemento padre: 219   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(242)).setAttribute("colFondo","" );
      ((Element)v.get(242)).setAttribute("ID","EstCab" );
      ((Element)v.get(242)).setAttribute("cod","695" );
      ((Element)v.get(219)).appendChild((Element)v.get(242));

      /* Elemento padre:242 / Elemento actual: 243   */
      v.add(doc.createTextNode("Situación"));
      ((Element)v.get(242)).appendChild((Text)v.get(243));

      /* Termina nodo Texto:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:244 / Elemento padre: 219   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(244)).setAttribute("colFondo","" );
      ((Element)v.get(244)).setAttribute("ID","EstCab" );
      ((Element)v.get(244)).setAttribute("cod","1" );
      ((Element)v.get(219)).appendChild((Element)v.get(244));

      /* Elemento padre:244 / Elemento actual: 245   */
      v.add(doc.createTextNode("PREMIO_REEMPLAZO"));
      ((Element)v.get(244)).appendChild((Text)v.get(245));

      /* Termina nodo Texto:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:246 / Elemento padre: 219   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(246)).setAttribute("colFondo","" );
      ((Element)v.get(246)).setAttribute("ID","EstCab" );
      ((Element)v.get(246)).setAttribute("cod","2889" );
      ((Element)v.get(219)).appendChild((Element)v.get(246));

      /* Elemento padre:246 / Elemento actual: 247   */
      v.add(doc.createTextNode("Campaña despacho"));
      ((Element)v.get(246)).appendChild((Text)v.get(247));

      /* Termina nodo Texto:247   */
      /* Termina nodo:246   */
      /* Termina nodo:219   */

      /* Empieza nodo:248 / Elemento padre: 194   */
      v.add(doc.createElement("DATOS"));
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(248)).setAttribute("alto","22" );
      ((Element)v.get(248)).setAttribute("accion","" );
      ((Element)v.get(248)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(248)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(248)).setAttribute("maxSel","-1" );
      ((Element)v.get(248)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(248)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(248)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(248)).setAttribute("onLoad","" );
      ((Element)v.get(248)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(194)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(249)).setAttribute("tipo","texto" );
      ((Element)v.get(249)).setAttribute("ID","EstDat" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */

      /* Empieza nodo:250 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(250)).setAttribute("tipo","texto" );
      ((Element)v.get(250)).setAttribute("ID","EstDat" );
      ((Element)v.get(248)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */

      /* Empieza nodo:251 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(251)).setAttribute("tipo","texto" );
      ((Element)v.get(251)).setAttribute("ID","EstDat" );
      ((Element)v.get(248)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */

      /* Empieza nodo:252 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(252)).setAttribute("tipo","texto" );
      ((Element)v.get(252)).setAttribute("ID","EstDat" );
      ((Element)v.get(248)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */

      /* Empieza nodo:253 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(253)).setAttribute("tipo","texto" );
      ((Element)v.get(253)).setAttribute("ID","EstDat2" );
      ((Element)v.get(248)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */

      /* Empieza nodo:254 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(254)).setAttribute("tipo","texto" );
      ((Element)v.get(254)).setAttribute("ID","EstDat2" );
      ((Element)v.get(248)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */

      /* Empieza nodo:255 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(255)).setAttribute("tipo","texto" );
      ((Element)v.get(255)).setAttribute("ID","EstDat" );
      ((Element)v.get(248)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */

      /* Empieza nodo:256 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(256)).setAttribute("tipo","texto" );
      ((Element)v.get(256)).setAttribute("ID","EstDat" );
      ((Element)v.get(248)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */

      /* Empieza nodo:257 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(257)).setAttribute("tipo","texto" );
      ((Element)v.get(257)).setAttribute("ID","EstDat2" );
      ((Element)v.get(248)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */

      /* Empieza nodo:258 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(258)).setAttribute("tipo","texto" );
      ((Element)v.get(258)).setAttribute("ID","EstDat" );
      ((Element)v.get(248)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */

      /* Empieza nodo:259 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(259)).setAttribute("tipo","texto" );
      ((Element)v.get(259)).setAttribute("ID","EstDat2" );
      ((Element)v.get(248)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */

      /* Empieza nodo:260 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(260)).setAttribute("tipo","texto" );
      ((Element)v.get(260)).setAttribute("ID","EstDat" );
      ((Element)v.get(248)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */

      /* Empieza nodo:261 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(261)).setAttribute("tipo","texto" );
      ((Element)v.get(261)).setAttribute("ID","EstDat2" );
      ((Element)v.get(248)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */

      /* Empieza nodo:262 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(262)).setAttribute("tipo","texto" );
      ((Element)v.get(262)).setAttribute("ID","EstDat2" );
      ((Element)v.get(248)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:248   */

      /* Empieza nodo:263 / Elemento padre: 194   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(194)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */

      /* Empieza nodo:264 / Elemento padre: 194   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(264)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(264)).setAttribute("ancho","738" );
      ((Element)v.get(264)).setAttribute("sep","$" );
      ((Element)v.get(264)).setAttribute("x","12" );
      ((Element)v.get(264)).setAttribute("class","botonera" );
      ((Element)v.get(264)).setAttribute("y","793" );
      ((Element)v.get(264)).setAttribute("control","|" );
      ((Element)v.get(264)).setAttribute("conector","" );
      ((Element)v.get(264)).setAttribute("rowset","" );
      ((Element)v.get(264)).setAttribute("cargainicial","N" );
      ((Element)v.get(264)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(194)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(265)).setAttribute("nombre","ret2" );
      ((Element)v.get(265)).setAttribute("x","37" );
      ((Element)v.get(265)).setAttribute("y","797" );
      ((Element)v.get(265)).setAttribute("ID","botonContenido" );
      ((Element)v.get(265)).setAttribute("img","retroceder_on" );
      ((Element)v.get(265)).setAttribute("tipo","0" );
      ((Element)v.get(265)).setAttribute("estado","false" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(265)).setAttribute("alt","" );
      ((Element)v.get(265)).setAttribute("codigo","" );
      ((Element)v.get(265)).setAttribute("accion","mipgndo2.retroceder();" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */

      /* Empieza nodo:266 / Elemento padre: 264   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(266)).setAttribute("nombre","ava2" );
      ((Element)v.get(266)).setAttribute("x","52" );
      ((Element)v.get(266)).setAttribute("y","797" );
      ((Element)v.get(266)).setAttribute("ID","botonContenido" );
      ((Element)v.get(266)).setAttribute("img","avanzar_on" );
      ((Element)v.get(266)).setAttribute("tipo","0" );
      ((Element)v.get(266)).setAttribute("estado","false" );
      ((Element)v.get(266)).setAttribute("alt","" );
      ((Element)v.get(266)).setAttribute("codigo","" );
      ((Element)v.get(266)).setAttribute("accion","mipgndo2.avanzar();" );
      ((Element)v.get(264)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:264   */
      /* Termina nodo:194   */

      /* Empieza nodo:267 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(267)).setAttribute("nombre","primera2" );
      ((Element)v.get(267)).setAttribute("x","20" );
      ((Element)v.get(267)).setAttribute("y","797" );
      ((Element)v.get(267)).setAttribute("ID","botonContenido" );
      ((Element)v.get(267)).setAttribute("img","primera_on" );
      ((Element)v.get(267)).setAttribute("tipo","0" );
      ((Element)v.get(267)).setAttribute("estado","false" );
      ((Element)v.get(267)).setAttribute("alt","" );
      ((Element)v.get(267)).setAttribute("codigo","" );
      ((Element)v.get(267)).setAttribute("accion","mipgndo2.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */

      /* Empieza nodo:268 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(268)).setAttribute("nombre","separa2" );
      ((Element)v.get(268)).setAttribute("x","59" );
      ((Element)v.get(268)).setAttribute("y","793" );
      ((Element)v.get(268)).setAttribute("ID","botonContenido" );
      ((Element)v.get(268)).setAttribute("img","separa_base" );
      ((Element)v.get(268)).setAttribute("tipo","0" );
      ((Element)v.get(268)).setAttribute("estado","false" );
      ((Element)v.get(268)).setAttribute("alt","" );
      ((Element)v.get(268)).setAttribute("codigo","" );
      ((Element)v.get(268)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */

      /* Empieza nodo:269 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(269)).setAttribute("nombre","listado3" );
      ((Element)v.get(269)).setAttribute("ancho","738" );
      ((Element)v.get(269)).setAttribute("alto","317" );
      ((Element)v.get(269)).setAttribute("x","12" );
      ((Element)v.get(269)).setAttribute("y","840" );
      ((Element)v.get(269)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(269)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(270)).setAttribute("precarga","S" );
      ((Element)v.get(270)).setAttribute("conROver","S" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(271)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(271)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(271)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(271)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */

      /* Empieza nodo:272 / Elemento padre: 270   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(272)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(272)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(272)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(272)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(270)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */

      /* Empieza nodo:273 / Elemento padre: 270   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(273)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(273)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(270)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */
      /* Termina nodo:270   */

      /* Empieza nodo:274 / Elemento padre: 269   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(269)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(275)).setAttribute("borde","1" );
      ((Element)v.get(275)).setAttribute("horizDatos","1" );
      ((Element)v.get(275)).setAttribute("horizCabecera","1" );
      ((Element)v.get(275)).setAttribute("vertical","1" );
      ((Element)v.get(275)).setAttribute("horizTitulo","1" );
      ((Element)v.get(275)).setAttribute("horizBase","1" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */

      /* Empieza nodo:276 / Elemento padre: 274   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(276)).setAttribute("borde","#999999" );
      ((Element)v.get(276)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(276)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(276)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(276)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(276)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(276)).setAttribute("horizBase","#999999" );
      ((Element)v.get(274)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:274   */

      /* Empieza nodo:277 / Elemento padre: 269   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(277)).setAttribute("colFondo","#CECFCE" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(277)).setAttribute("alto","22" );
      ((Element)v.get(277)).setAttribute("imgFondo","" );
      ((Element)v.get(277)).setAttribute("cod","00347" );
      ((Element)v.get(277)).setAttribute("ID","datosTitle" );
      ((Element)v.get(269)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */

      /* Empieza nodo:278 / Elemento padre: 269   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(278)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(278)).setAttribute("alto","22" );
      ((Element)v.get(278)).setAttribute("imgFondo","" );
      ((Element)v.get(269)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */

      /* Empieza nodo:279 / Elemento padre: 269   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(279)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(279)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(279)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(279)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(279)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(279)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(269)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(280)).setAttribute("ancho","100" );
      ((Element)v.get(280)).setAttribute("minimizable","S" );
      ((Element)v.get(280)).setAttribute("minimizada","N" );
      ((Element)v.get(280)).setAttribute("oculta","S" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */

      /* Empieza nodo:281 / Elemento padre: 279   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(281)).setAttribute("ancho","100" );
      ((Element)v.get(281)).setAttribute("minimizable","S" );
      ((Element)v.get(281)).setAttribute("minimizada","N" );
      ((Element)v.get(281)).setAttribute("oculta","S" );
      ((Element)v.get(279)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */

      /* Empieza nodo:282 / Elemento padre: 279   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(282)).setAttribute("ancho","100" );
      ((Element)v.get(282)).setAttribute("minimizable","S" );
      ((Element)v.get(282)).setAttribute("minimizada","N" );
      ((Element)v.get(279)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */

      /* Empieza nodo:283 / Elemento padre: 279   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(283)).setAttribute("ancho","100" );
      ((Element)v.get(283)).setAttribute("minimizable","S" );
      ((Element)v.get(283)).setAttribute("minimizada","N" );
      ((Element)v.get(283)).setAttribute("oculta","S" );
      ((Element)v.get(279)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */

      /* Empieza nodo:284 / Elemento padre: 279   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(284)).setAttribute("ancho","100" );
      ((Element)v.get(284)).setAttribute("minimizable","S" );
      ((Element)v.get(284)).setAttribute("minimizada","N" );
      ((Element)v.get(284)).setAttribute("oculta","S" );
      ((Element)v.get(279)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */

      /* Empieza nodo:285 / Elemento padre: 279   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(285)).setAttribute("ancho","200" );
      ((Element)v.get(285)).setAttribute("minimizable","S" );
      ((Element)v.get(285)).setAttribute("minimizada","N" );
      ((Element)v.get(279)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */

      /* Empieza nodo:286 / Elemento padre: 279   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(286)).setAttribute("ancho","180" );
      ((Element)v.get(286)).setAttribute("minimizable","S" );
      ((Element)v.get(286)).setAttribute("minimizada","N" );
      ((Element)v.get(279)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */

      /* Empieza nodo:287 / Elemento padre: 279   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(287)).setAttribute("ancho","90" );
      ((Element)v.get(287)).setAttribute("minimizable","S" );
      ((Element)v.get(287)).setAttribute("minimizada","N" );
      ((Element)v.get(279)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */

      /* Empieza nodo:288 / Elemento padre: 279   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(288)).setAttribute("ancho","90" );
      ((Element)v.get(288)).setAttribute("minimizable","S" );
      ((Element)v.get(288)).setAttribute("minimizada","N" );
      ((Element)v.get(288)).setAttribute("oculta","S" );
      ((Element)v.get(279)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */

      /* Empieza nodo:289 / Elemento padre: 279   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(289)).setAttribute("ancho","150" );
      ((Element)v.get(289)).setAttribute("minimizable","S" );
      ((Element)v.get(289)).setAttribute("minimizada","N" );
      ((Element)v.get(279)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */

      /* Empieza nodo:290 / Elemento padre: 279   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(290)).setAttribute("ancho","150" );
      ((Element)v.get(290)).setAttribute("minimizable","S" );
      ((Element)v.get(290)).setAttribute("minimizada","N" );
      ((Element)v.get(279)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */

      /* Empieza nodo:291 / Elemento padre: 279   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(291)).setAttribute("ancho","100" );
      ((Element)v.get(291)).setAttribute("minimizable","S" );
      ((Element)v.get(291)).setAttribute("minimizada","N" );
      ((Element)v.get(279)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:279   */

      /* Empieza nodo:292 / Elemento padre: 269   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(292)).setAttribute("alto","20" );
      ((Element)v.get(292)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(292)).setAttribute("imgFondo","" );
      ((Element)v.get(292)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(269)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(293)).setAttribute("colFondo","" );
      ((Element)v.get(293)).setAttribute("ID","EstCab" );
      ((Element)v.get(293)).setAttribute("cod","" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));

      /* Elemento padre:293 / Elemento actual: 294   */
      v.add(doc.createTextNode("OID"));
      ((Element)v.get(293)).appendChild((Text)v.get(294));

      /* Termina nodo Texto:294   */
      /* Termina nodo:293   */

      /* Empieza nodo:295 / Elemento padre: 292   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(295)).setAttribute("colFondo","" );
      ((Element)v.get(295)).setAttribute("ID","EstCab" );
      ((Element)v.get(295)).setAttribute("cod","1" );
      ((Element)v.get(292)).appendChild((Element)v.get(295));

      /* Elemento padre:295 / Elemento actual: 296   */
      v.add(doc.createTextNode("CLIE_OID_CLIE"));
      ((Element)v.get(295)).appendChild((Text)v.get(296));

      /* Termina nodo Texto:296   */
      /* Termina nodo:295   */

      /* Empieza nodo:297 / Elemento padre: 292   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(297)).setAttribute("colFondo","" );
      ((Element)v.get(297)).setAttribute("ID","EstCab" );
      ((Element)v.get(297)).setAttribute("cod","2876" );
      ((Element)v.get(292)).appendChild((Element)v.get(297));

      /* Elemento padre:297 / Elemento actual: 298   */
      v.add(doc.createTextNode("Fecha obtención"));
      ((Element)v.get(297)).appendChild((Text)v.get(298));

      /* Termina nodo Texto:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:299 / Elemento padre: 292   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(299)).setAttribute("colFondo","" );
      ((Element)v.get(299)).setAttribute("ID","EstCab" );
      ((Element)v.get(299)).setAttribute("cod","1" );
      ((Element)v.get(292)).appendChild((Element)v.get(299));

      /* Elemento padre:299 / Elemento actual: 300   */
      v.add(doc.createTextNode("NUMERO_CONCURSO"));
      ((Element)v.get(299)).appendChild((Text)v.get(300));

      /* Termina nodo Texto:300   */
      /* Termina nodo:299   */

      /* Empieza nodo:301 / Elemento padre: 292   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(301)).setAttribute("colFondo","" );
      ((Element)v.get(301)).setAttribute("ID","EstCab" );
      ((Element)v.get(301)).setAttribute("cod","1" );
      ((Element)v.get(292)).appendChild((Element)v.get(301));

      /* Elemento padre:301 / Elemento actual: 302   */
      v.add(doc.createTextNode("DESC_CONCURSO"));
      ((Element)v.get(301)).appendChild((Text)v.get(302));

      /* Termina nodo Texto:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:303 / Elemento padre: 292   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(303)).setAttribute("colFondo","" );
      ((Element)v.get(303)).setAttribute("ID","EstCab" );
      ((Element)v.get(303)).setAttribute("cod","2903" );
      ((Element)v.get(292)).appendChild((Element)v.get(303));

      /* Elemento padre:303 / Elemento actual: 304   */
      v.add(doc.createTextNode("Campaña asignación puntos"));
      ((Element)v.get(303)).appendChild((Text)v.get(304));

      /* Termina nodo Texto:304   */
      /* Termina nodo:303   */

      /* Empieza nodo:305 / Elemento padre: 292   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(305)).setAttribute("colFondo","" );
      ((Element)v.get(305)).setAttribute("ID","EstCab" );
      ((Element)v.get(305)).setAttribute("cod","357" );
      ((Element)v.get(292)).appendChild((Element)v.get(305));

      /* Elemento padre:305 / Elemento actual: 306   */
      v.add(doc.createTextNode("Nivel"));
      ((Element)v.get(305)).appendChild((Text)v.get(306));

      /* Termina nodo Texto:306   */
      /* Termina nodo:305   */

      /* Empieza nodo:307 / Elemento padre: 292   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(307)).setAttribute("colFondo","" );
      ((Element)v.get(307)).setAttribute("ID","EstCab" );
      ((Element)v.get(307)).setAttribute("cod","1691" );
      ((Element)v.get(292)).appendChild((Element)v.get(307));

      /* Elemento padre:307 / Elemento actual: 308   */
      v.add(doc.createTextNode("Nº premio"));
      ((Element)v.get(307)).appendChild((Text)v.get(308));

      /* Termina nodo Texto:308   */
      /* Termina nodo:307   */

      /* Empieza nodo:309 / Elemento padre: 292   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(309)).setAttribute("colFondo","" );
      ((Element)v.get(309)).setAttribute("ID","EstCab" );
      ((Element)v.get(309)).setAttribute("cod","1" );
      ((Element)v.get(292)).appendChild((Element)v.get(309));

      /* Elemento padre:309 / Elemento actual: 310   */
      v.add(doc.createTextNode("TIPO_PREMIO"));
      ((Element)v.get(309)).appendChild((Text)v.get(310));

      /* Termina nodo Texto:310   */
      /* Termina nodo:309   */

      /* Empieza nodo:311 / Elemento padre: 292   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(311)).setAttribute("colFondo","" );
      ((Element)v.get(311)).setAttribute("ID","EstCab" );
      ((Element)v.get(311)).setAttribute("cod","2904" );
      ((Element)v.get(292)).appendChild((Element)v.get(311));

      /* Elemento padre:311 / Elemento actual: 312   */
      v.add(doc.createTextNode("Nº concurso destino"));
      ((Element)v.get(311)).appendChild((Text)v.get(312));

      /* Termina nodo Texto:312   */
      /* Termina nodo:311   */

      /* Empieza nodo:313 / Elemento padre: 292   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(313)).setAttribute("colFondo","" );
      ((Element)v.get(313)).setAttribute("ID","EstCab" );
      ((Element)v.get(313)).setAttribute("cod","3071" );
      ((Element)v.get(292)).appendChild((Element)v.get(313));

      /* Elemento padre:313 / Elemento actual: 314   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(313)).appendChild((Text)v.get(314));

      /* Termina nodo Texto:314   */
      /* Termina nodo:313   */

      /* Empieza nodo:315 / Elemento padre: 292   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(315)).setAttribute("colFondo","" );
      ((Element)v.get(315)).setAttribute("ID","EstCab" );
      ((Element)v.get(315)).setAttribute("cod","2424" );
      ((Element)v.get(292)).appendChild((Element)v.get(315));

      /* Elemento padre:315 / Elemento actual: 316   */
      v.add(doc.createTextNode("Nº puntos"));
      ((Element)v.get(315)).appendChild((Text)v.get(316));

      /* Termina nodo Texto:316   */
      /* Termina nodo:315   */
      /* Termina nodo:292   */

      /* Empieza nodo:317 / Elemento padre: 269   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(317)).setAttribute("alto","22" );
      ((Element)v.get(317)).setAttribute("accion","" );
      ((Element)v.get(317)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(317)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(317)).setAttribute("maxSel","-1" );
      ((Element)v.get(317)).setAttribute("msgErrMaxSel","" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(317)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(317)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(317)).setAttribute("onLoad","" );
      ((Element)v.get(317)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(269)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(318)).setAttribute("tipo","texto" );
      ((Element)v.get(318)).setAttribute("ID","EstDat" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */

      /* Empieza nodo:319 / Elemento padre: 317   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(319)).setAttribute("tipo","texto" );
      ((Element)v.get(319)).setAttribute("ID","EstDat" );
      ((Element)v.get(317)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */

      /* Empieza nodo:320 / Elemento padre: 317   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(320)).setAttribute("tipo","texto" );
      ((Element)v.get(320)).setAttribute("ID","EstDat" );
      ((Element)v.get(317)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */

      /* Empieza nodo:321 / Elemento padre: 317   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(321)).setAttribute("tipo","texto" );
      ((Element)v.get(321)).setAttribute("ID","EstDat" );
      ((Element)v.get(317)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */

      /* Empieza nodo:322 / Elemento padre: 317   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(322)).setAttribute("tipo","texto" );
      ((Element)v.get(322)).setAttribute("ID","EstDat2" );
      ((Element)v.get(317)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */

      /* Empieza nodo:323 / Elemento padre: 317   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(323)).setAttribute("tipo","texto" );
      ((Element)v.get(323)).setAttribute("ID","EstDat2" );
      ((Element)v.get(317)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */

      /* Empieza nodo:324 / Elemento padre: 317   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(324)).setAttribute("tipo","texto" );
      ((Element)v.get(324)).setAttribute("ID","EstDat" );
      ((Element)v.get(317)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */

      /* Empieza nodo:325 / Elemento padre: 317   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(325)).setAttribute("tipo","texto" );
      ((Element)v.get(325)).setAttribute("ID","EstDat2" );
      ((Element)v.get(317)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */

      /* Empieza nodo:326 / Elemento padre: 317   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(326)).setAttribute("tipo","texto" );
      ((Element)v.get(326)).setAttribute("ID","EstDat2" );
      ((Element)v.get(317)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */

      /* Empieza nodo:327 / Elemento padre: 317   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(327)).setAttribute("tipo","texto" );
      ((Element)v.get(327)).setAttribute("ID","EstDat" );
      ((Element)v.get(317)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */

      /* Empieza nodo:328 / Elemento padre: 317   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(328)).setAttribute("tipo","texto" );
      ((Element)v.get(328)).setAttribute("ID","EstDat2" );
      ((Element)v.get(317)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */

      /* Empieza nodo:329 / Elemento padre: 317   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(329)).setAttribute("tipo","texto" );
      ((Element)v.get(329)).setAttribute("ID","EstDat" );
      ((Element)v.get(317)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:317   */

      /* Empieza nodo:330 / Elemento padre: 269   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(269)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */

      /* Empieza nodo:331 / Elemento padre: 269   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(331)).setAttribute("nombre","mipgndo3" );
      ((Element)v.get(331)).setAttribute("ancho","738" );
      ((Element)v.get(331)).setAttribute("sep","$" );
      ((Element)v.get(331)).setAttribute("x","12" );
      ((Element)v.get(331)).setAttribute("class","botonera" );
      ((Element)v.get(331)).setAttribute("y","1134" );
      ((Element)v.get(331)).setAttribute("control","|" );
      ((Element)v.get(331)).setAttribute("conector","" );
      ((Element)v.get(331)).setAttribute("rowset","" );
      ((Element)v.get(331)).setAttribute("cargainicial","N" );
      ((Element)v.get(331)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(269)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(332)).setAttribute("nombre","ret3" );
      ((Element)v.get(332)).setAttribute("x","37" );
      ((Element)v.get(332)).setAttribute("y","1138" );
      ((Element)v.get(332)).setAttribute("ID","botonContenido" );
      ((Element)v.get(332)).setAttribute("img","retroceder_on" );
      ((Element)v.get(332)).setAttribute("tipo","0" );
      ((Element)v.get(332)).setAttribute("estado","false" );
      ((Element)v.get(332)).setAttribute("alt","" );
      ((Element)v.get(332)).setAttribute("codigo","" );
      ((Element)v.get(332)).setAttribute("accion","mipgndo3.retroceder();" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */

      /* Empieza nodo:333 / Elemento padre: 331   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(333)).setAttribute("nombre","ava3" );
      ((Element)v.get(333)).setAttribute("x","52" );
      ((Element)v.get(333)).setAttribute("y","1138" );
      ((Element)v.get(333)).setAttribute("ID","botonContenido" );
      ((Element)v.get(333)).setAttribute("img","avanzar_on" );
      ((Element)v.get(333)).setAttribute("tipo","0" );
      ((Element)v.get(333)).setAttribute("estado","false" );
      ((Element)v.get(333)).setAttribute("alt","" );
      ((Element)v.get(333)).setAttribute("codigo","" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(333)).setAttribute("accion","mipgndo3.avanzar();" );
      ((Element)v.get(331)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */
      /* Termina nodo:331   */
      /* Termina nodo:269   */

      /* Empieza nodo:334 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(334)).setAttribute("nombre","primera3" );
      ((Element)v.get(334)).setAttribute("x","20" );
      ((Element)v.get(334)).setAttribute("y","1138" );
      ((Element)v.get(334)).setAttribute("ID","botonContenido" );
      ((Element)v.get(334)).setAttribute("img","primera_on" );
      ((Element)v.get(334)).setAttribute("tipo","0" );
      ((Element)v.get(334)).setAttribute("estado","false" );
      ((Element)v.get(334)).setAttribute("alt","" );
      ((Element)v.get(334)).setAttribute("codigo","" );
      ((Element)v.get(334)).setAttribute("accion","mipgndo3.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */

      /* Empieza nodo:335 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(335)).setAttribute("nombre","separa3" );
      ((Element)v.get(335)).setAttribute("x","59" );
      ((Element)v.get(335)).setAttribute("y","1134" );
      ((Element)v.get(335)).setAttribute("ID","botonContenido" );
      ((Element)v.get(335)).setAttribute("img","separa_base" );
      ((Element)v.get(335)).setAttribute("tipo","0" );
      ((Element)v.get(335)).setAttribute("estado","false" );
      ((Element)v.get(335)).setAttribute("alt","" );
      ((Element)v.get(335)).setAttribute("codigo","" );
      ((Element)v.get(335)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */

      /* Empieza nodo:336 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(336)).setAttribute("nombre","listado4" );
      ((Element)v.get(336)).setAttribute("ancho","738" );
      ((Element)v.get(336)).setAttribute("alto","300" );
      ((Element)v.get(336)).setAttribute("x","12" );
      ((Element)v.get(336)).setAttribute("y","1181" );
      ((Element)v.get(336)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(336)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(337)).setAttribute("precarga","S" );
      ((Element)v.get(337)).setAttribute("conROver","S" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(338)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(338)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(338)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(338)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */

      /* Empieza nodo:339 / Elemento padre: 337   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(339)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(339)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(339)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(339)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(337)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */

      /* Empieza nodo:340 / Elemento padre: 337   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(340)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(340)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(337)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:337   */

      /* Empieza nodo:341 / Elemento padre: 336   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(336)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(342)).setAttribute("borde","1" );
      ((Element)v.get(342)).setAttribute("horizDatos","1" );
      ((Element)v.get(342)).setAttribute("horizCabecera","1" );
      ((Element)v.get(342)).setAttribute("vertical","1" );
      ((Element)v.get(342)).setAttribute("horizTitulo","1" );
      ((Element)v.get(342)).setAttribute("horizBase","1" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */

      /* Empieza nodo:343 / Elemento padre: 341   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(343)).setAttribute("borde","#999999" );
      ((Element)v.get(343)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(343)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(343)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(343)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(343)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(343)).setAttribute("horizBase","#999999" );
      ((Element)v.get(341)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */
      /* Termina nodo:341   */

      /* Empieza nodo:344 / Elemento padre: 336   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(344)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(344)).setAttribute("alto","22" );
      ((Element)v.get(344)).setAttribute("imgFondo","" );
      ((Element)v.get(344)).setAttribute("cod","00355" );
      ((Element)v.get(344)).setAttribute("ID","datosTitle" );
      ((Element)v.get(336)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */

      /* Empieza nodo:345 / Elemento padre: 336   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(345)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(345)).setAttribute("alto","22" );
      ((Element)v.get(345)).setAttribute("imgFondo","" );
      ((Element)v.get(336)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */

      /* Empieza nodo:346 / Elemento padre: 336   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(346)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(346)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(346)).setAttribute("blancosAInsertar","1" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(346)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(346)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(346)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(336)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(347)).setAttribute("ancho","100" );
      ((Element)v.get(347)).setAttribute("minimizable","S" );
      ((Element)v.get(347)).setAttribute("minimizada","N" );
      ((Element)v.get(347)).setAttribute("oculta","S" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */

      /* Empieza nodo:348 / Elemento padre: 346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(348)).setAttribute("ancho","100" );
      ((Element)v.get(348)).setAttribute("minimizable","S" );
      ((Element)v.get(348)).setAttribute("minimizada","N" );
      ((Element)v.get(348)).setAttribute("oculta","S" );
      ((Element)v.get(346)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */

      /* Empieza nodo:349 / Elemento padre: 346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(349)).setAttribute("ancho","100" );
      ((Element)v.get(349)).setAttribute("minimizable","S" );
      ((Element)v.get(349)).setAttribute("minimizada","N" );
      ((Element)v.get(346)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */

      /* Empieza nodo:350 / Elemento padre: 346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(350)).setAttribute("ancho","200" );
      ((Element)v.get(350)).setAttribute("minimizable","S" );
      ((Element)v.get(350)).setAttribute("minimizada","N" );
      ((Element)v.get(346)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */

      /* Empieza nodo:351 / Elemento padre: 346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(351)).setAttribute("ancho","100" );
      ((Element)v.get(351)).setAttribute("minimizable","S" );
      ((Element)v.get(351)).setAttribute("minimizada","N" );
      ((Element)v.get(351)).setAttribute("oculta","S" );
      ((Element)v.get(346)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */

      /* Empieza nodo:352 / Elemento padre: 346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(352)).setAttribute("ancho","100" );
      ((Element)v.get(352)).setAttribute("minimizable","S" );
      ((Element)v.get(352)).setAttribute("minimizada","N" );
      ((Element)v.get(352)).setAttribute("oculta","S" );
      ((Element)v.get(346)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */

      /* Empieza nodo:353 / Elemento padre: 346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(353)).setAttribute("ancho","180" );
      ((Element)v.get(353)).setAttribute("minimizable","S" );
      ((Element)v.get(353)).setAttribute("minimizada","N" );
      ((Element)v.get(346)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */

      /* Empieza nodo:354 / Elemento padre: 346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(354)).setAttribute("ancho","90" );
      ((Element)v.get(354)).setAttribute("minimizable","S" );
      ((Element)v.get(354)).setAttribute("minimizada","N" );
      ((Element)v.get(346)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */

      /* Empieza nodo:355 / Elemento padre: 346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(355)).setAttribute("ancho","90" );
      ((Element)v.get(355)).setAttribute("minimizable","S" );
      ((Element)v.get(355)).setAttribute("minimizada","N" );
      ((Element)v.get(355)).setAttribute("oculta","S" );
      ((Element)v.get(346)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */

      /* Empieza nodo:356 / Elemento padre: 346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(356)).setAttribute("ancho","100" );
      ((Element)v.get(356)).setAttribute("minimizable","S" );
      ((Element)v.get(356)).setAttribute("minimizada","N" );
      ((Element)v.get(346)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */

      /* Empieza nodo:357 / Elemento padre: 346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(357)).setAttribute("ancho","90" );
      ((Element)v.get(357)).setAttribute("minimizable","S" );
      ((Element)v.get(357)).setAttribute("minimizada","N" );
      ((Element)v.get(346)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:346   */

      /* Empieza nodo:358 / Elemento padre: 336   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(358)).setAttribute("alto","20" );
      ((Element)v.get(358)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(358)).setAttribute("imgFondo","" );
      ((Element)v.get(358)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(336)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(359)).setAttribute("colFondo","" );
      ((Element)v.get(359)).setAttribute("ID","EstCab" );
      ((Element)v.get(359)).setAttribute("cod","" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));

      /* Elemento padre:359 / Elemento actual: 360   */
      v.add(doc.createTextNode("OID"));
      ((Element)v.get(359)).appendChild((Text)v.get(360));

      /* Termina nodo Texto:360   */
      /* Termina nodo:359   */

      /* Empieza nodo:361 / Elemento padre: 358   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(361)).setAttribute("colFondo","" );
      ((Element)v.get(361)).setAttribute("ID","EstCab" );
      ((Element)v.get(361)).setAttribute("cod","1" );
      ((Element)v.get(358)).appendChild((Element)v.get(361));

      /* Elemento padre:361 / Elemento actual: 362   */
      v.add(doc.createTextNode("CLIE_OID_CLIE"));
      ((Element)v.get(361)).appendChild((Text)v.get(362));

      /* Termina nodo Texto:362   */
      /* Termina nodo:361   */

      /* Empieza nodo:363 / Elemento padre: 358   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(363)).setAttribute("colFondo","" );
      ((Element)v.get(363)).setAttribute("ID","EstCab" );
      ((Element)v.get(363)).setAttribute("cod","2876" );
      ((Element)v.get(358)).appendChild((Element)v.get(363));

      /* Elemento padre:363 / Elemento actual: 364   */
      v.add(doc.createTextNode("Fecha obtención"));
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(363)).appendChild((Text)v.get(364));

      /* Termina nodo Texto:364   */
      /* Termina nodo:363   */

      /* Empieza nodo:365 / Elemento padre: 358   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(365)).setAttribute("colFondo","" );
      ((Element)v.get(365)).setAttribute("ID","EstCab" );
      ((Element)v.get(365)).setAttribute("cod","2905" );
      ((Element)v.get(358)).appendChild((Element)v.get(365));

      /* Elemento padre:365 / Elemento actual: 366   */
      v.add(doc.createTextNode("Campaña asignación descuento"));
      ((Element)v.get(365)).appendChild((Text)v.get(366));

      /* Termina nodo Texto:366   */
      /* Termina nodo:365   */

      /* Empieza nodo:367 / Elemento padre: 358   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(367)).setAttribute("colFondo","" );
      ((Element)v.get(367)).setAttribute("ID","EstCab" );
      ((Element)v.get(367)).setAttribute("cod","1" );
      ((Element)v.get(358)).appendChild((Element)v.get(367));

      /* Elemento padre:367 / Elemento actual: 368   */
      v.add(doc.createTextNode("NUMERO_CONCURSO"));
      ((Element)v.get(367)).appendChild((Text)v.get(368));

      /* Termina nodo Texto:368   */
      /* Termina nodo:367   */

      /* Empieza nodo:369 / Elemento padre: 358   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(369)).setAttribute("colFondo","" );
      ((Element)v.get(369)).setAttribute("ID","EstCab" );
      ((Element)v.get(369)).setAttribute("cod","1" );
      ((Element)v.get(358)).appendChild((Element)v.get(369));

      /* Elemento padre:369 / Elemento actual: 370   */
      v.add(doc.createTextNode("DESC_CONCURSO"));
      ((Element)v.get(369)).appendChild((Text)v.get(370));

      /* Termina nodo Texto:370   */
      /* Termina nodo:369   */

      /* Empieza nodo:371 / Elemento padre: 358   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(371)).setAttribute("colFondo","" );
      ((Element)v.get(371)).setAttribute("ID","EstCab" );
      ((Element)v.get(371)).setAttribute("cod","357" );
      ((Element)v.get(358)).appendChild((Element)v.get(371));

      /* Elemento padre:371 / Elemento actual: 372   */
      v.add(doc.createTextNode("Nivel"));
      ((Element)v.get(371)).appendChild((Text)v.get(372));

      /* Termina nodo Texto:372   */
      /* Termina nodo:371   */

      /* Empieza nodo:373 / Elemento padre: 358   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(373)).setAttribute("colFondo","" );
      ((Element)v.get(373)).setAttribute("ID","EstCab" );
      ((Element)v.get(373)).setAttribute("cod","1691" );
      ((Element)v.get(358)).appendChild((Element)v.get(373));

      /* Elemento padre:373 / Elemento actual: 374   */
      v.add(doc.createTextNode("Nº premio"));
      ((Element)v.get(373)).appendChild((Text)v.get(374));

      /* Termina nodo Texto:374   */
      /* Termina nodo:373   */

      /* Empieza nodo:375 / Elemento padre: 358   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(375)).setAttribute("colFondo","" );
      ((Element)v.get(375)).setAttribute("ID","EstCab" );
      ((Element)v.get(375)).setAttribute("cod","1" );
      ((Element)v.get(358)).appendChild((Element)v.get(375));

      /* Elemento padre:375 / Elemento actual: 376   */
      v.add(doc.createTextNode("TIPO_PREMIO"));
      ((Element)v.get(375)).appendChild((Text)v.get(376));

      /* Termina nodo Texto:376   */
      /* Termina nodo:375   */

      /* Empieza nodo:377 / Elemento padre: 358   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(377)).setAttribute("colFondo","" );
      ((Element)v.get(377)).setAttribute("ID","EstCab" );
      ((Element)v.get(377)).setAttribute("cod","2906" );
      ((Element)v.get(358)).appendChild((Element)v.get(377));

      /* Elemento padre:377 / Elemento actual: 378   */
      v.add(doc.createTextNode("% Descuento"));
      ((Element)v.get(377)).appendChild((Text)v.get(378));

      /* Termina nodo Texto:378   */
      /* Termina nodo:377   */

      /* Empieza nodo:379 / Elemento padre: 358   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(379)).setAttribute("colFondo","" );
      ((Element)v.get(379)).setAttribute("ID","EstCab" );
      ((Element)v.get(379)).setAttribute("cod","917" );
      ((Element)v.get(358)).appendChild((Element)v.get(379));

      /* Elemento padre:379 / Elemento actual: 380   */
      v.add(doc.createTextNode("Monto"));
      ((Element)v.get(379)).appendChild((Text)v.get(380));

      /* Termina nodo Texto:380   */
      /* Termina nodo:379   */
      /* Termina nodo:358   */

      /* Empieza nodo:381 / Elemento padre: 336   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(381)).setAttribute("alto","22" );
      ((Element)v.get(381)).setAttribute("accion","" );
      ((Element)v.get(381)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(381)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(381)).setAttribute("maxSel","-1" );
      ((Element)v.get(381)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(381)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(381)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(381)).setAttribute("onLoad","" );
      ((Element)v.get(381)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(336)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(382)).setAttribute("tipo","texto" );
      ((Element)v.get(382)).setAttribute("ID","EstDat" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */

      /* Empieza nodo:383 / Elemento padre: 381   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(383)).setAttribute("tipo","texto" );
      ((Element)v.get(383)).setAttribute("ID","EstDat" );
      ((Element)v.get(381)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */

      /* Empieza nodo:384 / Elemento padre: 381   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(384)).setAttribute("tipo","texto" );
      ((Element)v.get(384)).setAttribute("ID","EstDat" );
      ((Element)v.get(381)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */

      /* Empieza nodo:385 / Elemento padre: 381   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(385)).setAttribute("tipo","texto" );
      ((Element)v.get(385)).setAttribute("ID","EstDat2" );
      ((Element)v.get(381)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */

      /* Empieza nodo:386 / Elemento padre: 381   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(386)).setAttribute("tipo","texto" );
      ((Element)v.get(386)).setAttribute("ID","EstDat2" );
      ((Element)v.get(381)).appendChild((Element)v.get(386));
      /* Termina nodo:386   */

      /* Empieza nodo:387 / Elemento padre: 381   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(387)).setAttribute("tipo","texto" );
      ((Element)v.get(387)).setAttribute("ID","EstDat" );
      ((Element)v.get(381)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */

      /* Empieza nodo:388 / Elemento padre: 381   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(388)).setAttribute("tipo","texto" );
      ((Element)v.get(388)).setAttribute("ID","EstDat" );
      ((Element)v.get(381)).appendChild((Element)v.get(388));
      /* Termina nodo:388   */

      /* Empieza nodo:389 / Elemento padre: 381   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(389)).setAttribute("tipo","texto" );
      ((Element)v.get(389)).setAttribute("ID","EstDat2" );
      ((Element)v.get(381)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */

      /* Empieza nodo:390 / Elemento padre: 381   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(390)).setAttribute("tipo","texto" );
      ((Element)v.get(390)).setAttribute("ID","EstDat2" );
      ((Element)v.get(381)).appendChild((Element)v.get(390));
      /* Termina nodo:390   */

      /* Empieza nodo:391 / Elemento padre: 381   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(391)).setAttribute("tipo","texto" );
      ((Element)v.get(391)).setAttribute("ID","EstDat" );
      ((Element)v.get(381)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */

      /* Empieza nodo:392 / Elemento padre: 381   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(392)).setAttribute("tipo","texto" );
      ((Element)v.get(392)).setAttribute("ID","EstDat2" );
      ((Element)v.get(381)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */
      /* Termina nodo:381   */

      /* Empieza nodo:393 / Elemento padre: 336   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(336)).appendChild((Element)v.get(393));
      /* Termina nodo:393   */

      /* Empieza nodo:394 / Elemento padre: 336   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(394)).setAttribute("nombre","mipgndo4" );
      ((Element)v.get(394)).setAttribute("ancho","738" );
      ((Element)v.get(394)).setAttribute("sep","$" );
      ((Element)v.get(394)).setAttribute("x","12" );
      ((Element)v.get(394)).setAttribute("class","botonera" );
      ((Element)v.get(394)).setAttribute("y","1458" );
      ((Element)v.get(394)).setAttribute("control","|" );
      ((Element)v.get(394)).setAttribute("conector","" );
      ((Element)v.get(394)).setAttribute("rowset","" );
      ((Element)v.get(394)).setAttribute("cargainicial","N" );
      ((Element)v.get(394)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(336)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(395)).setAttribute("nombre","ret4" );
      ((Element)v.get(395)).setAttribute("x","37" );
      ((Element)v.get(395)).setAttribute("y","1462" );
      ((Element)v.get(395)).setAttribute("ID","botonContenido" );
      ((Element)v.get(395)).setAttribute("img","retroceder_on" );
      ((Element)v.get(395)).setAttribute("tipo","0" );
      ((Element)v.get(395)).setAttribute("estado","false" );
      ((Element)v.get(395)).setAttribute("alt","" );
      ((Element)v.get(395)).setAttribute("codigo","" );
      ((Element)v.get(395)).setAttribute("accion","mipgndo4.retroceder();" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */

      /* Empieza nodo:396 / Elemento padre: 394   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(396)).setAttribute("nombre","ava4" );
      ((Element)v.get(396)).setAttribute("x","52" );
      ((Element)v.get(396)).setAttribute("y","1462" );
      ((Element)v.get(396)).setAttribute("ID","botonContenido" );
      ((Element)v.get(396)).setAttribute("img","avanzar_on" );
      ((Element)v.get(396)).setAttribute("tipo","0" );
      ((Element)v.get(396)).setAttribute("estado","false" );
      ((Element)v.get(396)).setAttribute("alt","" );
      ((Element)v.get(396)).setAttribute("codigo","" );
      ((Element)v.get(396)).setAttribute("accion","mipgndo4.avanzar();" );
      ((Element)v.get(394)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */
      /* Termina nodo:394   */
      /* Termina nodo:336   */

      /* Empieza nodo:397 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(397)).setAttribute("nombre","primera4" );
      ((Element)v.get(397)).setAttribute("x","20" );
      ((Element)v.get(397)).setAttribute("y","1462" );
      ((Element)v.get(397)).setAttribute("ID","botonContenido" );
      ((Element)v.get(397)).setAttribute("img","primera_on" );
      ((Element)v.get(397)).setAttribute("tipo","0" );
      ((Element)v.get(397)).setAttribute("estado","false" );
      ((Element)v.get(397)).setAttribute("alt","" );
      ((Element)v.get(397)).setAttribute("codigo","" );
      ((Element)v.get(397)).setAttribute("accion","mipgndo4.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */

      /* Empieza nodo:398 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(398)).setAttribute("nombre","separa4" );
      ((Element)v.get(398)).setAttribute("x","59" );
      ((Element)v.get(398)).setAttribute("y","1458" );
      ((Element)v.get(398)).setAttribute("ID","botonContenido" );
      ((Element)v.get(398)).setAttribute("img","separa_base" );
      ((Element)v.get(398)).setAttribute("tipo","0" );
      ((Element)v.get(398)).setAttribute("estado","false" );
      ((Element)v.get(398)).setAttribute("alt","" );
      ((Element)v.get(398)).setAttribute("codigo","" );
      ((Element)v.get(398)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */

      /* Empieza nodo:399 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(399)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(399)).setAttribute("alto","12" );
      ((Element)v.get(399)).setAttribute("ancho","50" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(399)).setAttribute("colorf","" );
      ((Element)v.get(399)).setAttribute("borde","0" );
      ((Element)v.get(399)).setAttribute("imagenf","" );
      ((Element)v.get(399)).setAttribute("repeat","" );
      ((Element)v.get(399)).setAttribute("padding","" );
      ((Element)v.get(399)).setAttribute("visibilidad","visible" );
      ((Element)v.get(399)).setAttribute("contravsb","" );
      ((Element)v.get(399)).setAttribute("x","0" );
      ((Element)v.get(399)).setAttribute("y","1478" );
      ((Element)v.get(399)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */
      /* Termina nodo:6   */


   }

}


import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_cargos_abonos_directos_aplicar  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML1980(doc);
         

      getXML2070(doc);
         

      getXML2160(doc);
         

      getXML2250(doc);
         

      getXML2340(doc);
         

      getXML2430(doc);
         

      getXML2520(doc);
         

      getXML2610(doc);
         

      getXML2700(doc);
         

      getXML2790(doc);
         

      getXML2880(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_cargos_abonos_directos_aplicar" );
      ((Element)v.get(0)).setAttribute("cod","0161" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Aplicar cargos y abonos directos" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag()" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(1)).setAttribute("nombre","JAVASCRIPT1" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode(" \r      \r 			function fot(FE, TE){ \r        		if (TE == 9) { \r                	setTimeout(\"restauraFocoLista(\" + FE + \",'listado3.form.Texto4')\", 1); \r        		} \r			} \r			\r			function fot2(FE, TE){\r				if(TE == 9){\r					setTimeout(\"restauraFocoLista(\" + FE + \",'listado4.form.Texto6')\", 1);	\r				}\r			}\r			function fot3(FE, TE){\r				if(TE == 9){\r					setTimeout(\"restauraFocoLista(\" + FE + \",'listado3.form.Texto3')\", 1);	\r				}\r			}\r			function fot4(FE, TE){\r				if(TE == 9){\r					setTimeout(\"restauraFocoLista(\" + FE + \",'listado4.form.Texto5')\", 1);	\r				}\r			}\r       \r"));
      ((Element)v.get(1)).appendChild((Text)v.get(2));

      /* Termina nodo Texto:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("STYLE"));
      ((Element)v.get(3)).setAttribute("TYPE","text/css" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Elemento padre:3 / Elemento actual: 4   */
      v.add(doc.createTextNode("\r   \r\r\r#ret1Div {visibility:hidden;}\r#ava1Div {visibility:hidden;}\r#primera1Div {visibility:hidden;}\r#separa1Div {visibility:hidden;}\r#Cplistado1{visibility:hidden;}\r#CpLin1listado1{visibility:hidden;}\r#CpLin2listado1{visibility:hidden;}\r#CpLin3listado1{visibility:hidden;}\r#CpLin4listado1{visibility:hidden;}\r\r#ret2Div {visibility:hidden;}\r#ava2Div {visibility:hidden;}\r#primera2Div {visibility:hidden;}\r#separa2Div {visibility:hidden;}\r#Cplistado2{visibility:hidden;}\r#CpLin1listado2{visibility:hidden;}\r#CpLin2listado2{visibility:hidden;}\r#CpLin3listado2{visibility:hidden;}\r#CpLin4listado2{visibility:hidden;}\r\r#ret3Div {visibility:hidden;}\r#ava3Div {visibility:hidden;}\r#primera3Div {visibility:hidden;}\r#separa3Div {visibility:hidden;}\r#Cplistado3{visibility:hidden;}\r#CpLin1listado3{visibility:hidden;}\r#CpLin2listado3{visibility:hidden;}\r#CpLin3listado3{visibility:hidden;}\r#CpLin4listado3{visibility:hidden;}\r\r#ret4Div {visibility:hidden;}\r#ava4Div {visibility:hidden;}\r#primera4Div {visibility:hidden;}\r#separa4Div {visibility:hidden;}\r#Cplistado4{visibility:hidden;}\r#CpLin1listado4{visibility:hidden;}\r#CpLin2listado4{visibility:hidden;}\r#CpLin3listado4{visibility:hidden;}\r#CpLin4listado4{visibility:hidden;}\r\r   \r"));
      ((Element)v.get(3)).appendChild((Text)v.get(4));

      /* Termina nodo Texto:4   */
      /* Termina nodo:3   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(6)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(7)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(8)).setAttribute("src","ccc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(9)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(10)).setAttribute("src","contenido_cargos_abonos_directos_aplicar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 0   */
      v.add(doc.createElement("MATRIZJS"));
      ((Element)v.get(11)).setAttribute("nombre","datosAccesos" );
      ((Element)v.get(0)).appendChild((Element)v.get(11));

      /* Empieza nodo:12 / Elemento padre: 11   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(11)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */
      /* Termina nodo:11   */

      /* Empieza nodo:13 / Elemento padre: 0   */
      v.add(doc.createElement("MATRIZJS"));
      ((Element)v.get(13)).setAttribute("nombre","datosSubaccesos" );
      ((Element)v.get(0)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(13)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */
      /* Termina nodo:13   */

      /* Empieza nodo:15 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(16)).setAttribute("name","cbAplicacion" );
      ((Element)v.get(16)).setAttribute("required","true" );
      ((Element)v.get(16)).setAttribute("cod","1321" );
      ((Element)v.get(16)).setAttribute("group","grupo1" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 15   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(17)).setAttribute("name","txtFechaValor" );
      ((Element)v.get(17)).setAttribute("required","true" );
      ((Element)v.get(17)).setAttribute("cod","656" );
      ((Element)v.get(15)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 15   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(18)).setAttribute("name","cbEmpresa" );
      ((Element)v.get(18)).setAttribute("required","true" );
      ((Element)v.get(18)).setAttribute("cod","57" );
      ((Element)v.get(15)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 15   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(19)).setAttribute("name","txtCodCliente" );
      ((Element)v.get(19)).setAttribute("required","false" );
      ((Element)v.get(19)).setAttribute("cod","679" );
      ((Element)v.get(15)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */
      /* Termina nodo:15   */

      /* Empieza nodo:20 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(20)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(20)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","errSeverity" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(24)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(20)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","accion" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","idioma" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","pais" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","canal" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","empresa" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","acceso" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","subacceso" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","longitudCodigoCliente" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","tasaCambioMonedaAlternativa" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","listaVisible" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","modificable" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","oid" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","casoUso" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","NIdentificacion" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","htxtFechaValor" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","htxtFechaDocumento" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","hid_SeparadorMiles" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hid_SeparadorDecimales" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hid_NumeroDecimales" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","cancelacionCuotas" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","aplicacionCobros" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","aplicacionGastos" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(47)).setAttribute("nombre","generacionVencimientos" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","codigoCliente" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","separadorColumnas" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 20   */
      v.add(doc.createElement("table"));
      ((Element)v.get(50)).setAttribute("width","100%" );
      ((Element)v.get(50)).setAttribute("border","0" );
      ((Element)v.get(50)).setAttribute("cellspacing","0" );
      ((Element)v.get(50)).setAttribute("cellpadding","0" );
      ((Element)v.get(20)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("width","12" );
      ((Element)v.get(52)).setAttribute("align","center" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","12" );
      ((Element)v.get(53)).setAttribute("height","12" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).setAttribute("width","750" );
      ((Element)v.get(51)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).setAttribute("width","12" );
      ((Element)v.get(51)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","12" );
      ((Element)v.get(57)).setAttribute("height","1" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:51   */

      /* Empieza nodo:58 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(63)).setAttribute("class","legend" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(64)).setAttribute("nombre","lblAplicacionProceso" );
      ((Element)v.get(64)).setAttribute("alto","13" );
      ((Element)v.get(64)).setAttribute("filas","1" );
      ((Element)v.get(64)).setAttribute("id","legend" );
      ((Element)v.get(64)).setAttribute("cod","00129" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 62   */
      v.add(doc.createElement("table"));
      ((Element)v.get(65)).setAttribute("width","100%" );
      ((Element)v.get(65)).setAttribute("border","0" );
      ((Element)v.get(65)).setAttribute("align","center" );
      ((Element)v.get(65)).setAttribute("cellspacing","0" );
      ((Element)v.get(65)).setAttribute("cellpadding","0" );
      ((Element)v.get(62)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("table"));
      ((Element)v.get(68)).setAttribute("width","738" );
      ((Element)v.get(68)).setAttribute("border","0" );
      ((Element)v.get(68)).setAttribute("align","left" );
      ((Element)v.get(68)).setAttribute("cellspacing","0" );
      ((Element)v.get(68)).setAttribute("cellpadding","0" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).setAttribute("colspan","4" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","8" );
      ((Element)v.get(71)).setAttribute("height","8" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:72 / Elemento padre: 68   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(68)).appendChild((Element)v.get(72));

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
      ((Element)v.get(76)).setAttribute("nombre","lblAplicacion" );
      ((Element)v.get(76)).setAttribute("alto","13" );
      ((Element)v.get(76)).setAttribute("filas","1" );
      ((Element)v.get(76)).setAttribute("id","datosTitle" );
      ((Element)v.get(76)).setAttribute("cod","1321" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("width","100%" );
      ((Element)v.get(72)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","8" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:72   */

      /* Empieza nodo:79 / Elemento padre: 68   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(68)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).setAttribute("width","8" );
      ((Element)v.get(81)).setAttribute("height","8" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(79)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(83)).setAttribute("nombre","cbAplicacion" );
      ((Element)v.get(83)).setAttribute("id","datosCampos" );
      ((Element)v.get(83)).setAttribute("onchange","" );
      ((Element)v.get(83)).setAttribute("size","1" );
      ((Element)v.get(83)).setAttribute("multiple","N" );
      ((Element)v.get(83)).setAttribute("readonly","N" );
      ((Element)v.get(83)).setAttribute("req","S" );
      ((Element)v.get(83)).setAttribute("onshtab","focalizaEjecutar();" );
      ((Element)v.get(83)).setAttribute("valorinicial","" );
      ((Element)v.get(83)).setAttribute("textoinicial","" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:85 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).setAttribute("width","100%" );
      ((Element)v.get(79)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","8" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:79   */

      /* Empieza nodo:87 / Elemento padre: 68   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(68)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("colspan","4" );
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
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:90 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:58   */

      /* Empieza nodo:92 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("table"));
      ((Element)v.get(97)).setAttribute("width","100%" );
      ((Element)v.get(97)).setAttribute("border","0" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(97)).setAttribute("align","center" );
      ((Element)v.get(97)).setAttribute("cellspacing","0" );
      ((Element)v.get(97)).setAttribute("cellpadding","0" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("class","botonera" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(100)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(100)).setAttribute("ID","botonContenido" );
      ((Element)v.get(100)).setAttribute("tipo","html" );
      ((Element)v.get(100)).setAttribute("onfocus","" );
      ((Element)v.get(100)).setAttribute("ontab","focaliza('frmFormulario.cbEmpresa');" );
      ((Element)v.get(100)).setAttribute("onshtab","focaliza('frmFormulario.cbAplicacion');" );
      ((Element)v.get(100)).setAttribute("accion","accionAceptar();" );
      ((Element)v.get(100)).setAttribute("estado","false" );
      ((Element)v.get(100)).setAttribute("cod","12" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:101 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).setAttribute("width","8" );
      ((Element)v.get(102)).setAttribute("height","12" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:92   */

      /* Empieza nodo:103 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("colspan","4" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","8" );
      ((Element)v.get(105)).setAttribute("height","15" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:50   */

      /* Empieza nodo:106 / Elemento padre: 20   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(106)).setAttribute("nombre","capaCabecera" );
      ((Element)v.get(106)).setAttribute("alto","250" );
      ((Element)v.get(106)).setAttribute("ancho","100%" );
      ((Element)v.get(106)).setAttribute("colorf","" );
      ((Element)v.get(106)).setAttribute("borde","0" );
      ((Element)v.get(106)).setAttribute("imagenf","" );
      ((Element)v.get(106)).setAttribute("repeat","" );
      ((Element)v.get(106)).setAttribute("padding","" );
      ((Element)v.get(106)).setAttribute("visibilidad","visible" );
      ((Element)v.get(106)).setAttribute("contravsb","" );
      ((Element)v.get(106)).setAttribute("x","0" );
      ((Element)v.get(106)).setAttribute("y","104" );
      ((Element)v.get(106)).setAttribute("zindex","" );
      ((Element)v.get(20)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("table"));
      ((Element)v.get(107)).setAttribute("width","100%" );
      ((Element)v.get(107)).setAttribute("border","0" );
      ((Element)v.get(107)).setAttribute("cellspacing","0" );
      ((Element)v.get(107)).setAttribute("cellpadding","0" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).setAttribute("width","12" );
      ((Element)v.get(109)).setAttribute("align","center" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","12" );
      ((Element)v.get(110)).setAttribute("height","12" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("width","756" );
      ((Element)v.get(108)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("width","12" );
      ((Element)v.get(108)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","12" );
      ((Element)v.get(114)).setAttribute("height","1" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:108   */

      /* Empieza nodo:115 / Elemento padre: 107   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(107)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 115   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(120)).setAttribute("class","legend" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(121)).setAttribute("nombre","lblCabecera" );
      ((Element)v.get(121)).setAttribute("alto","13" );
      ((Element)v.get(121)).setAttribute("filas","1" );
      ((Element)v.get(121)).setAttribute("valor","" );
      ((Element)v.get(121)).setAttribute("id","legend" );
      ((Element)v.get(121)).setAttribute("cod","0077" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 119   */
      v.add(doc.createElement("table"));
      ((Element)v.get(122)).setAttribute("width","100%" );
      ((Element)v.get(122)).setAttribute("border","0" );
      ((Element)v.get(122)).setAttribute("align","center" );
      ((Element)v.get(122)).setAttribute("cellspacing","0" );
      ((Element)v.get(122)).setAttribute("cellpadding","0" );
      ((Element)v.get(119)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("table"));
      ((Element)v.get(125)).setAttribute("width","743" );
      ((Element)v.get(125)).setAttribute("border","0" );
      ((Element)v.get(125)).setAttribute("align","left" );
      ((Element)v.get(125)).setAttribute("cellspacing","0" );
      ((Element)v.get(125)).setAttribute("cellpadding","0" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).setAttribute("colspan","4" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","8" );
      ((Element)v.get(128)).setAttribute("height","8" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:129 / Elemento padre: 125   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(125)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(131)).setAttribute("src","b.gif" );
      ((Element)v.get(131)).setAttribute("width","8" );
      ((Element)v.get(131)).setAttribute("height","8" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(133)).setAttribute("nombre","lblNIdentificacion" );
      ((Element)v.get(133)).setAttribute("alto","13" );
      ((Element)v.get(133)).setAttribute("filas","1" );
      ((Element)v.get(133)).setAttribute("id","datosTitle" );
      ((Element)v.get(133)).setAttribute("cod","679" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","25" );
      ((Element)v.get(135)).setAttribute("height","8" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(137)).setAttribute("nombre","lblAnio" );
      ((Element)v.get(137)).setAttribute("alto","13" );
      ((Element)v.get(137)).setAttribute("filas","1" );
      ((Element)v.get(137)).setAttribute("id","datosTitle" );
      ((Element)v.get(137)).setAttribute("cod","171" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).setAttribute("width","25" );
      ((Element)v.get(139)).setAttribute("height","8" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(141)).setAttribute("nombre","lblMes" );
      ((Element)v.get(141)).setAttribute("alto","13" );
      ((Element)v.get(141)).setAttribute("filas","1" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(141)).setAttribute("id","datosTitle" );
      ((Element)v.get(141)).setAttribute("cod","674" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:142 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
      ((Element)v.get(143)).setAttribute("width","25" );
      ((Element)v.get(143)).setAttribute("height","8" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:144 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(145)).setAttribute("nombre","lblEmpresa" );
      ((Element)v.get(145)).setAttribute("alto","13" );
      ((Element)v.get(145)).setAttribute("filas","1" );
      ((Element)v.get(145)).setAttribute("id","datosTitle" );
      ((Element)v.get(145)).setAttribute("cod","57" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:146 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).setAttribute("width","100%" );
      ((Element)v.get(129)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).setAttribute("width","8" );
      ((Element)v.get(147)).setAttribute("height","8" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:129   */

      /* Empieza nodo:148 / Elemento padre: 125   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(125)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","8" );
      ((Element)v.get(150)).setAttribute("height","8" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).setAttribute("valign","bottom" );
      ((Element)v.get(148)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(152)).setAttribute("nombre","lblvalorNIdentificacion" );
      ((Element)v.get(152)).setAttribute("alto","13" );
      ((Element)v.get(152)).setAttribute("filas","1" );
      ((Element)v.get(152)).setAttribute("id","datosCampos" );
      ((Element)v.get(152)).setAttribute("valor","" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:153 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).setAttribute("width","25" );
      ((Element)v.get(154)).setAttribute("height","8" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).setAttribute("valign","bottom" );
      ((Element)v.get(148)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(156)).setAttribute("nombre","lblvalorAnio" );
      ((Element)v.get(156)).setAttribute("alto","13" );
      ((Element)v.get(156)).setAttribute("filas","1" );
      ((Element)v.get(156)).setAttribute("id","datosCampos" );
      ((Element)v.get(156)).setAttribute("valor","" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(158)).setAttribute("width","25" );
      ((Element)v.get(158)).setAttribute("height","8" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).setAttribute("valign","bottom" );
      ((Element)v.get(148)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(160)).setAttribute("nombre","lblvalorMes" );
      ((Element)v.get(160)).setAttribute("alto","13" );
      ((Element)v.get(160)).setAttribute("filas","1" );
      ((Element)v.get(160)).setAttribute("id","datosCampos" );
      ((Element)v.get(160)).setAttribute("valor","" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(162)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).setAttribute("width","25" );
      ((Element)v.get(162)).setAttribute("height","8" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(163)).setAttribute("valign","top" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(148)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(164)).setAttribute("nombre","cbEmpresa" );
      ((Element)v.get(164)).setAttribute("onchange","" );
      ((Element)v.get(164)).setAttribute("id","datosCampos" );
      ((Element)v.get(164)).setAttribute("size","1" );
      ((Element)v.get(164)).setAttribute("onshtab","focalizaAnteriorEmpresa();" );
      ((Element)v.get(164)).setAttribute("multiple","N" );
      ((Element)v.get(164)).setAttribute("readonly","N" );
      ((Element)v.get(164)).setAttribute("req","S" );
      ((Element)v.get(164)).setAttribute("valorinicial","" );
      ((Element)v.get(164)).setAttribute("textoinicial","" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:166 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).setAttribute("width","100%" );
      ((Element)v.get(148)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).setAttribute("width","8" );
      ((Element)v.get(167)).setAttribute("height","8" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:148   */

      /* Empieza nodo:168 / Elemento padre: 125   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(125)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).setAttribute("colspan","4" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).setAttribute("width","8" );
      ((Element)v.get(170)).setAttribute("height","8" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:168   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:171 / Elemento padre: 122   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(122)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("table"));
      ((Element)v.get(173)).setAttribute("width","743" );
      ((Element)v.get(173)).setAttribute("border","0" );
      ((Element)v.get(173)).setAttribute("align","left" );
      ((Element)v.get(173)).setAttribute("cellspacing","0" );
      ((Element)v.get(173)).setAttribute("cellpadding","0" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(176)).setAttribute("src","b.gif" );
      ((Element)v.get(176)).setAttribute("width","8" );
      ((Element)v.get(176)).setAttribute("height","8" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(178)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(178)).setAttribute("alto","13" );
      ((Element)v.get(178)).setAttribute("filas","1" );
      ((Element)v.get(178)).setAttribute("id","datosTitle" );
      ((Element)v.get(178)).setAttribute("cod","7" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:179 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(180)).setAttribute("src","b.gif" );
      ((Element)v.get(180)).setAttribute("width","25" );
      ((Element)v.get(180)).setAttribute("height","8" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(182)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(182)).setAttribute("alto","13" );
      ((Element)v.get(182)).setAttribute("filas","1" );
      ((Element)v.get(182)).setAttribute("id","datosTitle" );
      ((Element)v.get(182)).setAttribute("cod","10" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","25" );
      ((Element)v.get(184)).setAttribute("height","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(186)).setAttribute("nombre","lblSubacceso" );
      ((Element)v.get(186)).setAttribute("alto","13" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(186)).setAttribute("filas","1" );
      ((Element)v.get(186)).setAttribute("id","datosTitle" );
      ((Element)v.get(186)).setAttribute("cod","122" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).setAttribute("width","100%" );
      ((Element)v.get(174)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
      ((Element)v.get(188)).setAttribute("width","8" );
      ((Element)v.get(188)).setAttribute("height","8" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */
      /* Termina nodo:174   */

      /* Empieza nodo:189 / Elemento padre: 173   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(173)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(191)).setAttribute("src","b.gif" );
      ((Element)v.get(191)).setAttribute("width","8" );
      ((Element)v.get(191)).setAttribute("height","8" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(189)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(193)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(193)).setAttribute("id","datosCampos" );
      ((Element)v.get(193)).setAttribute("onchange","canalOnChange();" );
      ((Element)v.get(193)).setAttribute("size","1" );
      ((Element)v.get(193)).setAttribute("multiple","N" );
      ((Element)v.get(193)).setAttribute("readonly","N" );
      ((Element)v.get(193)).setAttribute("req","N" );
      ((Element)v.get(193)).setAttribute("valorinicial","" );
      ((Element)v.get(193)).setAttribute("textoinicial","" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:195 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(189)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(196)).setAttribute("width","25" );
      ((Element)v.get(196)).setAttribute("height","8" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(189)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(198)).setAttribute("nombre","cbAcceso" );
      ((Element)v.get(198)).setAttribute("id","datosCampos" );
      ((Element)v.get(198)).setAttribute("onchange","accesoOnChange();" );
      ((Element)v.get(198)).setAttribute("size","1" );
      ((Element)v.get(198)).setAttribute("multiple","N" );
      ((Element)v.get(198)).setAttribute("readonly","N" );
      ((Element)v.get(198)).setAttribute("req","N" );
      ((Element)v.get(198)).setAttribute("valorinicial","" );
      ((Element)v.get(198)).setAttribute("textoinicial","" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:200 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(189)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).setAttribute("width","25" );
      ((Element)v.get(201)).setAttribute("height","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(189)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(203)).setAttribute("nombre","cbSubacceso" );
      ((Element)v.get(203)).setAttribute("onchange","" );
      ((Element)v.get(203)).setAttribute("id","datosCampos" );
      ((Element)v.get(203)).setAttribute("size","1" );
      ((Element)v.get(203)).setAttribute("multiple","N" );
      ((Element)v.get(203)).setAttribute("readonly","N" );
      ((Element)v.get(203)).setAttribute("req","N" );
      ((Element)v.get(203)).setAttribute("valorinicial","" );
      ((Element)v.get(203)).setAttribute("textoinicial","" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:205 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).setAttribute("width","100%" );
      ((Element)v.get(189)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).setAttribute("width","8" );
      ((Element)v.get(206)).setAttribute("height","8" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */
      /* Termina nodo:189   */

      /* Empieza nodo:207 / Elemento padre: 173   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(173)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).setAttribute("colspan","4" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","8" );
      ((Element)v.get(209)).setAttribute("height","8" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:173   */
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:210 / Elemento padre: 122   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(122)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("table"));
      ((Element)v.get(212)).setAttribute("width","743" );
      ((Element)v.get(212)).setAttribute("border","0" );
      ((Element)v.get(212)).setAttribute("align","left" );
      ((Element)v.get(212)).setAttribute("cellspacing","0" );
      ((Element)v.get(212)).setAttribute("cellpadding","0" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(215)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).setAttribute("width","8" );
      ((Element)v.get(215)).setAttribute("height","8" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:216 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).setAttribute("colspan","2" );
      ((Element)v.get(213)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(217)).setAttribute("nombre","lblCodCliente" );
      ((Element)v.get(217)).setAttribute("alto","13" );
      ((Element)v.get(217)).setAttribute("filas","1" );
      ((Element)v.get(217)).setAttribute("id","datosTitle" );
      ((Element)v.get(217)).setAttribute("cod","263" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:218 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("width","25" );
      ((Element)v.get(219)).setAttribute("height","8" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(221)).setAttribute("nombre","lblFechaDocumentot" );
      ((Element)v.get(221)).setAttribute("alto","13" );
      ((Element)v.get(221)).setAttribute("filas","1" );
      ((Element)v.get(221)).setAttribute("id","datosTitle" );
      ((Element)v.get(221)).setAttribute("cod","383" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:222 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(223)).setAttribute("src","b.gif" );
      ((Element)v.get(223)).setAttribute("width","25" );
      ((Element)v.get(223)).setAttribute("height","8" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:224 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(225)).setAttribute("nombre","lblFechaValor" );
      ((Element)v.get(225)).setAttribute("alto","13" );
      ((Element)v.get(225)).setAttribute("filas","1" );
      ((Element)v.get(225)).setAttribute("id","datosTitle" );
      ((Element)v.get(225)).setAttribute("cod","656" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:226 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).setAttribute("width","25" );
      ((Element)v.get(227)).setAttribute("height","8" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(229)).setAttribute("nombre","lblReferenciExterna" );
      ((Element)v.get(229)).setAttribute("alto","13" );
      ((Element)v.get(229)).setAttribute("filas","1" );
      ((Element)v.get(229)).setAttribute("id","datosTitle" );
      ((Element)v.get(229)).setAttribute("cod","692" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:230 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(230)).setAttribute("width","100%" );
      ((Element)v.get(213)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(231)).setAttribute("src","b.gif" );
      ((Element)v.get(231)).setAttribute("width","8" );
      ((Element)v.get(231)).setAttribute("height","8" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */
      /* Termina nodo:213   */

      /* Empieza nodo:232 / Elemento padre: 212   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(212)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(234)).setAttribute("src","b.gif" );
      ((Element)v.get(234)).setAttribute("width","8" );
      ((Element)v.get(234)).setAttribute("height","8" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:235 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(235)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(232)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(236)).setAttribute("nombre","txtCodCliente" );
      ((Element)v.get(236)).setAttribute("id","datosCampos" );
      ((Element)v.get(236)).setAttribute("max","15" );
      ((Element)v.get(236)).setAttribute("tipo","" );
      ((Element)v.get(236)).setAttribute("onchange","" );
      ((Element)v.get(236)).setAttribute("onblur","codigoClienteOnBlur();" );
      ((Element)v.get(236)).setAttribute("readonly","N" );
      ((Element)v.get(236)).setAttribute("req","N" );
      ((Element)v.get(236)).setAttribute("size","20" );
      ((Element)v.get(236)).setAttribute("valor","" );
      ((Element)v.get(236)).setAttribute("validacion","" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:237 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(238)).setAttribute("src","b.gif" );
      ((Element)v.get(238)).setAttribute("width","8" );
      ((Element)v.get(238)).setAttribute("height","8" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */

      /* Empieza nodo:239 / Elemento padre: 237   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(239)).setAttribute("name","lupa" );
      ((Element)v.get(239)).setAttribute("src","iconBuscar.gif" );
      ((Element)v.get(239)).setAttribute("onclick","accionSeleccionarCliente();" );
      ((Element)v.get(237)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:237   */

      /* Empieza nodo:240 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(241)).setAttribute("src","b.gif" );
      ((Element)v.get(241)).setAttribute("width","25" );
      ((Element)v.get(241)).setAttribute("height","8" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:242 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(243)).setAttribute("nombre","lblFechaDocumento" );
      ((Element)v.get(243)).setAttribute("alto","13" );
      ((Element)v.get(243)).setAttribute("filas","1" );
      ((Element)v.get(243)).setAttribute("id","datosCampos" );
      ((Element)v.get(243)).setAttribute("valor","" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:244 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(245)).setAttribute("src","b.gif" );
      ((Element)v.get(245)).setAttribute("width","25" );
      ((Element)v.get(245)).setAttribute("height","8" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:246 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(246)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(232)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(247)).setAttribute("nombre","txtFechaValor" );
      ((Element)v.get(247)).setAttribute("id","datosCampos" );
      ((Element)v.get(247)).setAttribute("max","10" );
      ((Element)v.get(247)).setAttribute("tipo","" );
      ((Element)v.get(247)).setAttribute("onblur","validaFecha('txtFechaValor')" );
      ((Element)v.get(247)).setAttribute("onchange","" );
      ((Element)v.get(247)).setAttribute("req","S" );
      ((Element)v.get(247)).setAttribute("size","12" );
      ((Element)v.get(247)).setAttribute("valor","" );
      ((Element)v.get(247)).setAttribute("validacion","" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:248 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(249)).setAttribute("src","b.gif" );
      ((Element)v.get(249)).setAttribute("width","25" );
      ((Element)v.get(249)).setAttribute("height","8" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:250 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
   }

   private void getXML990(Document doc) {
      ((Element)v.get(250)).setAttribute("valign","bottom" );
      ((Element)v.get(232)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(251)).setAttribute("nombre","txtReferenciaExterna" );
      ((Element)v.get(251)).setAttribute("id","datosCampos" );
      ((Element)v.get(251)).setAttribute("max","20" );
      ((Element)v.get(251)).setAttribute("tipo","" );
      ((Element)v.get(251)).setAttribute("onchange","" );
      ((Element)v.get(251)).setAttribute("readonly","N" );
      ((Element)v.get(251)).setAttribute("req","N" );
      ((Element)v.get(251)).setAttribute("size","30" );
      ((Element)v.get(251)).setAttribute("valor","" );
      ((Element)v.get(251)).setAttribute("validacion","" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:252 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(252)).setAttribute("width","100%" );
      ((Element)v.get(232)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(253)).setAttribute("src","b.gif" );
      ((Element)v.get(253)).setAttribute("width","8" );
      ((Element)v.get(253)).setAttribute("height","8" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */
      /* Termina nodo:232   */

      /* Empieza nodo:254 / Elemento padre: 212   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(212)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("td"));
      ((Element)v.get(255)).setAttribute("colspan","4" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(256)).setAttribute("src","b.gif" );
      ((Element)v.get(256)).setAttribute("width","8" );
      ((Element)v.get(256)).setAttribute("height","8" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */
      /* Termina nodo:254   */
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:257 / Elemento padre: 122   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(122)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(257)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("table"));
      ((Element)v.get(259)).setAttribute("width","743" );
      ((Element)v.get(259)).setAttribute("border","0" );
      ((Element)v.get(259)).setAttribute("align","left" );
      ((Element)v.get(259)).setAttribute("cellspacing","0" );
      ((Element)v.get(259)).setAttribute("cellpadding","0" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(259)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("td"));
      ((Element)v.get(260)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(262)).setAttribute("src","b.gif" );
      ((Element)v.get(262)).setAttribute("width","8" );
      ((Element)v.get(262)).setAttribute("height","8" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */

      /* Empieza nodo:263 / Elemento padre: 260   */
      v.add(doc.createElement("td"));
      ((Element)v.get(260)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(264)).setAttribute("nombre","lblObservaciones" );
      ((Element)v.get(264)).setAttribute("alto","13" );
      ((Element)v.get(264)).setAttribute("filas","1" );
      ((Element)v.get(264)).setAttribute("valor","" );
      ((Element)v.get(264)).setAttribute("id","datosTitle" );
      ((Element)v.get(264)).setAttribute("cod","169" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */

      /* Empieza nodo:265 / Elemento padre: 260   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).setAttribute("width","100%" );
      ((Element)v.get(260)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(266)).setAttribute("src","b.gif" );
      ((Element)v.get(266)).setAttribute("width","8" );
      ((Element)v.get(266)).setAttribute("height","8" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */
      /* Termina nodo:260   */

      /* Empieza nodo:267 / Elemento padre: 259   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(259)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("td"));
      ((Element)v.get(267)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(269)).setAttribute("src","b.gif" );
      ((Element)v.get(269)).setAttribute("width","8" );
      ((Element)v.get(269)).setAttribute("height","8" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */

      /* Empieza nodo:270 / Elemento padre: 267   */
      v.add(doc.createElement("td"));
      ((Element)v.get(270)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(267)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(271)).setAttribute("cols","50" );
      ((Element)v.get(271)).setAttribute("id","datosCampos" );
      ((Element)v.get(271)).setAttribute("msjreq","" );
      ((Element)v.get(271)).setAttribute("nombre","areatxtObservaciones" );
      ((Element)v.get(271)).setAttribute("readonly","N" );
      ((Element)v.get(271)).setAttribute("req","N" );
      ((Element)v.get(271)).setAttribute("rows","3" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(271)).setAttribute("tabindex","2" );
      ((Element)v.get(271)).setAttribute("valor","" );
      ((Element)v.get(271)).setAttribute("max","100" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */

      /* Empieza nodo:272 / Elemento padre: 267   */
      v.add(doc.createElement("td"));
      ((Element)v.get(272)).setAttribute("width","100%" );
      ((Element)v.get(267)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(273)).setAttribute("src","b.gif" );
      ((Element)v.get(273)).setAttribute("width","8" );
      ((Element)v.get(273)).setAttribute("height","8" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */
      /* Termina nodo:272   */
      /* Termina nodo:267   */

      /* Empieza nodo:274 / Elemento padre: 259   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(259)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).setAttribute("colspan","4" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(276)).setAttribute("src","b.gif" );
      ((Element)v.get(276)).setAttribute("width","8" );
      ((Element)v.get(276)).setAttribute("height","8" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */
      /* Termina nodo:274   */
      /* Termina nodo:259   */
      /* Termina nodo:258   */
      /* Termina nodo:257   */
      /* Termina nodo:122   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:277 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(278)).setAttribute("src","b.gif" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */
      /* Termina nodo:115   */

      /* Empieza nodo:279 / Elemento padre: 107   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(107)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(281)).setAttribute("src","b.gif" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:280   */

      /* Empieza nodo:282 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(282)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("table"));
      ((Element)v.get(284)).setAttribute("width","100%" );
      ((Element)v.get(284)).setAttribute("border","0" );
      ((Element)v.get(284)).setAttribute("align","center" );
      ((Element)v.get(284)).setAttribute("cellspacing","0" );
      ((Element)v.get(284)).setAttribute("cellpadding","0" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(284)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(286)).setAttribute("class","botonera" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(287)).setAttribute("nombre","cbEleccion" );
      ((Element)v.get(287)).setAttribute("id","datosCampos" );
      ((Element)v.get(287)).setAttribute("onshtab","focalizaAnteriorEleccion();" );
      ((Element)v.get(287)).setAttribute("size","1" );
      ((Element)v.get(287)).setAttribute("multiple","N" );
      ((Element)v.get(287)).setAttribute("req","N" );
      ((Element)v.get(287)).setAttribute("valorinicial","" );
      ((Element)v.get(287)).setAttribute("textoinicial","" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:287   */
      /* Termina nodo:286   */

      /* Empieza nodo:289 / Elemento padre: 285   */
      v.add(doc.createElement("td"));
      ((Element)v.get(289)).setAttribute("class","botonera" );
      ((Element)v.get(289)).setAttribute("width","100%" );
      ((Element)v.get(285)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(290)).setAttribute("nombre","btnEjecutar" );
      ((Element)v.get(290)).setAttribute("ID","botonContenido" );
      ((Element)v.get(290)).setAttribute("tipo","html" );
      ((Element)v.get(290)).setAttribute("accion","accionEjecutar();" );
      ((Element)v.get(290)).setAttribute("onshtab","focaliza('frmFormulario.cbEleccion');" );
      ((Element)v.get(290)).setAttribute("ontab","focalizaSiguienteEjecutar();" );
      ((Element)v.get(290)).setAttribute("estado","false" );
      ((Element)v.get(290)).setAttribute("cod","382" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */
      /* Termina nodo:289   */
      /* Termina nodo:285   */
      /* Termina nodo:284   */
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:291 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(292)).setAttribute("src","b.gif" );
      ((Element)v.get(292)).setAttribute("width","8" );
      ((Element)v.get(292)).setAttribute("height","12" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:291   */
      /* Termina nodo:279   */

      /* Empieza nodo:293 / Elemento padre: 107   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(107)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(294)).setAttribute("colspan","4" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(295)).setAttribute("src","b.gif" );
      ((Element)v.get(295)).setAttribute("width","8" );
      ((Element)v.get(295)).setAttribute("height","15" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */
      /* Termina nodo:293   */
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:296 / Elemento padre: 20   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(296)).setAttribute("nombre","capaImportes" );
      ((Element)v.get(296)).setAttribute("alto","150" );
      ((Element)v.get(296)).setAttribute("ancho","100%" );
      ((Element)v.get(296)).setAttribute("colorf","" );
      ((Element)v.get(296)).setAttribute("borde","0" );
      ((Element)v.get(296)).setAttribute("imagenf","" );
      ((Element)v.get(296)).setAttribute("repeat","" );
      ((Element)v.get(296)).setAttribute("padding","" );
      ((Element)v.get(296)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(296)).setAttribute("contravsb","" );
      ((Element)v.get(296)).setAttribute("x","0" );
      ((Element)v.get(296)).setAttribute("y","369" );
      ((Element)v.get(296)).setAttribute("zindex","" );
      ((Element)v.get(20)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("table"));
      ((Element)v.get(297)).setAttribute("width","100%" );
      ((Element)v.get(297)).setAttribute("border","0" );
      ((Element)v.get(297)).setAttribute("cellspacing","0" );
      ((Element)v.get(297)).setAttribute("cellpadding","0" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(297)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("td"));
      ((Element)v.get(298)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(300)).setAttribute("src","b.gif" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */
      /* Termina nodo:299   */

      /* Empieza nodo:301 / Elemento padre: 298   */
      v.add(doc.createElement("td"));
      ((Element)v.get(298)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(301)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(303)).setAttribute("class","legend" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(304)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(304)).setAttribute("alto","13" );
      ((Element)v.get(304)).setAttribute("filas","1" );
      ((Element)v.get(304)).setAttribute("id","legend" );
      ((Element)v.get(304)).setAttribute("cod","00130" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */

      /* Empieza nodo:305 / Elemento padre: 302   */
      v.add(doc.createElement("table"));
      ((Element)v.get(305)).setAttribute("width","100%" );
      ((Element)v.get(305)).setAttribute("border","0" );
      ((Element)v.get(305)).setAttribute("align","center" );
      ((Element)v.get(305)).setAttribute("cellspacing","0" );
      ((Element)v.get(305)).setAttribute("cellpadding","0" );
      ((Element)v.get(302)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(305)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("td"));
      ((Element)v.get(306)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("table"));
      ((Element)v.get(308)).setAttribute("width","732" );
      ((Element)v.get(308)).setAttribute("border","0" );
      ((Element)v.get(308)).setAttribute("align","left" );
      ((Element)v.get(308)).setAttribute("cellspacing","0" );
      ((Element)v.get(308)).setAttribute("cellpadding","0" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(308)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).setAttribute("colspan","4" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(311)).setAttribute("src","b.gif" );
      ((Element)v.get(311)).setAttribute("width","8" );
      ((Element)v.get(311)).setAttribute("height","8" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */
      /* Termina nodo:309   */

      /* Empieza nodo:312 / Elemento padre: 308   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(308)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("td"));
      ((Element)v.get(312)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(314)).setAttribute("src","b.gif" );
      ((Element)v.get(314)).setAttribute("width","8" );
      ((Element)v.get(314)).setAttribute("height","8" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */

      /* Empieza nodo:315 / Elemento padre: 312   */
      v.add(doc.createElement("td"));
      ((Element)v.get(312)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(316)).setAttribute("nombre","lblImporteCuotas" );
      ((Element)v.get(316)).setAttribute("alto","13" );
      ((Element)v.get(316)).setAttribute("filas","1" );
      ((Element)v.get(316)).setAttribute("id","datosTitle" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(316)).setAttribute("cod","1228" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:317 / Elemento padre: 312   */
      v.add(doc.createElement("td"));
      ((Element)v.get(312)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(318)).setAttribute("src","b.gif" );
      ((Element)v.get(318)).setAttribute("width","25" );
      ((Element)v.get(318)).setAttribute("height","8" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:317   */

      /* Empieza nodo:319 / Elemento padre: 312   */
      v.add(doc.createElement("td"));
      ((Element)v.get(312)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(320)).setAttribute("nombre","lblImporteCobros" );
      ((Element)v.get(320)).setAttribute("alto","13" );
      ((Element)v.get(320)).setAttribute("filas","1" );
      ((Element)v.get(320)).setAttribute("id","datosTitle" );
      ((Element)v.get(320)).setAttribute("cod","665" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */

      /* Empieza nodo:321 / Elemento padre: 312   */
      v.add(doc.createElement("td"));
      ((Element)v.get(312)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(322)).setAttribute("src","b.gif" );
      ((Element)v.get(322)).setAttribute("width","25" );
      ((Element)v.get(322)).setAttribute("height","8" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */
      /* Termina nodo:321   */

      /* Empieza nodo:323 / Elemento padre: 312   */
      v.add(doc.createElement("td"));
      ((Element)v.get(312)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(324)).setAttribute("nombre","lblImporteConceptos" );
      ((Element)v.get(324)).setAttribute("alto","13" );
      ((Element)v.get(324)).setAttribute("filas","1" );
      ((Element)v.get(324)).setAttribute("id","datosTitle" );
      ((Element)v.get(324)).setAttribute("cod","666" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */
      /* Termina nodo:323   */

      /* Empieza nodo:325 / Elemento padre: 312   */
      v.add(doc.createElement("td"));
      ((Element)v.get(325)).setAttribute("width","100%" );
      ((Element)v.get(312)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(326)).setAttribute("src","b.gif" );
      ((Element)v.get(326)).setAttribute("width","8" );
      ((Element)v.get(326)).setAttribute("height","8" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:325   */
      /* Termina nodo:312   */

      /* Empieza nodo:327 / Elemento padre: 308   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(308)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("td"));
      ((Element)v.get(327)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(329)).setAttribute("src","b.gif" );
      ((Element)v.get(329)).setAttribute("width","8" );
      ((Element)v.get(329)).setAttribute("height","8" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:328   */

      /* Empieza nodo:330 / Elemento padre: 327   */
      v.add(doc.createElement("td"));
      ((Element)v.get(327)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(331)).setAttribute("nombre","lblvalorImporteCuotas" );
      ((Element)v.get(331)).setAttribute("alto","13" );
      ((Element)v.get(331)).setAttribute("filas","1" );
      ((Element)v.get(331)).setAttribute("id","datosCampos" );
      ((Element)v.get(331)).setAttribute("valor","                " );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */

      /* Empieza nodo:332 / Elemento padre: 327   */
      v.add(doc.createElement("td"));
      ((Element)v.get(327)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(333)).setAttribute("src","b.gif" );
      ((Element)v.get(333)).setAttribute("width","25" );
      ((Element)v.get(333)).setAttribute("height","8" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */
      /* Termina nodo:332   */

      /* Empieza nodo:334 / Elemento padre: 327   */
      v.add(doc.createElement("td"));
      ((Element)v.get(327)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(335)).setAttribute("nombre","lblvalorImporteCobros" );
      ((Element)v.get(335)).setAttribute("alto","13" );
      ((Element)v.get(335)).setAttribute("filas","1" );
      ((Element)v.get(335)).setAttribute("id","datosCampos" );
      ((Element)v.get(335)).setAttribute("valor","                " );
      ((Element)v.get(334)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */
      /* Termina nodo:334   */

      /* Empieza nodo:336 / Elemento padre: 327   */
      v.add(doc.createElement("td"));
      ((Element)v.get(327)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(337)).setAttribute("src","b.gif" );
      ((Element)v.get(337)).setAttribute("width","25" );
      ((Element)v.get(337)).setAttribute("height","8" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */
      /* Termina nodo:336   */

      /* Empieza nodo:338 / Elemento padre: 327   */
      v.add(doc.createElement("td"));
      ((Element)v.get(327)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(339)).setAttribute("nombre","lblvalorImporteConceptos" );
      ((Element)v.get(339)).setAttribute("alto","13" );
      ((Element)v.get(339)).setAttribute("filas","1" );
      ((Element)v.get(339)).setAttribute("id","datosCampos" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(339)).setAttribute("valor","               " );
      ((Element)v.get(338)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */
      /* Termina nodo:338   */

      /* Empieza nodo:340 / Elemento padre: 327   */
      v.add(doc.createElement("td"));
      ((Element)v.get(340)).setAttribute("width","100%" );
      ((Element)v.get(327)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(341)).setAttribute("src","b.gif" );
      ((Element)v.get(341)).setAttribute("width","8" );
      ((Element)v.get(341)).setAttribute("height","8" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */
      /* Termina nodo:340   */
      /* Termina nodo:327   */

      /* Empieza nodo:342 / Elemento padre: 308   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(308)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("td"));
      ((Element)v.get(343)).setAttribute("colspan","4" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(344)).setAttribute("src","b.gif" );
      ((Element)v.get(344)).setAttribute("width","8" );
      ((Element)v.get(344)).setAttribute("height","8" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:343   */
      /* Termina nodo:342   */
      /* Termina nodo:308   */
      /* Termina nodo:307   */
      /* Termina nodo:306   */

      /* Empieza nodo:345 / Elemento padre: 305   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(305)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("td"));
      ((Element)v.get(345)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("table"));
      ((Element)v.get(347)).setAttribute("width","732" );
      ((Element)v.get(347)).setAttribute("border","0" );
      ((Element)v.get(347)).setAttribute("align","left" );
      ((Element)v.get(347)).setAttribute("cellspacing","0" );
      ((Element)v.get(347)).setAttribute("cellpadding","0" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(347)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("td"));
      ((Element)v.get(349)).setAttribute("colspan","4" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(350)).setAttribute("src","b.gif" );
      ((Element)v.get(350)).setAttribute("width","8" );
      ((Element)v.get(350)).setAttribute("height","8" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:349   */
      /* Termina nodo:348   */

      /* Empieza nodo:351 / Elemento padre: 347   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(347)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("td"));
      ((Element)v.get(351)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(353)).setAttribute("src","b.gif" );
      ((Element)v.get(353)).setAttribute("width","8" );
      ((Element)v.get(353)).setAttribute("height","8" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */
      /* Termina nodo:352   */

      /* Empieza nodo:354 / Elemento padre: 351   */
      v.add(doc.createElement("td"));
      ((Element)v.get(351)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(355)).setAttribute("nombre","lblImporteGeneracion" );
      ((Element)v.get(355)).setAttribute("alto","13" );
      ((Element)v.get(355)).setAttribute("filas","1" );
      ((Element)v.get(355)).setAttribute("id","datosTitle" );
      ((Element)v.get(355)).setAttribute("cod","669" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */
      /* Termina nodo:354   */

      /* Empieza nodo:356 / Elemento padre: 351   */
      v.add(doc.createElement("td"));
      ((Element)v.get(351)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(357)).setAttribute("src","b.gif" );
      ((Element)v.get(357)).setAttribute("width","25" );
      ((Element)v.get(357)).setAttribute("height","8" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */

      /* Empieza nodo:358 / Elemento padre: 351   */
      v.add(doc.createElement("td"));
      ((Element)v.get(351)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(359)).setAttribute("nombre","lblResultado" );
      ((Element)v.get(359)).setAttribute("alto","13" );
      ((Element)v.get(359)).setAttribute("filas","1" );
      ((Element)v.get(359)).setAttribute("id","datosTitle" );
      ((Element)v.get(359)).setAttribute("cod","693" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */
      /* Termina nodo:358   */

      /* Empieza nodo:360 / Elemento padre: 351   */
      v.add(doc.createElement("td"));
      ((Element)v.get(360)).setAttribute("width","100%" );
      ((Element)v.get(351)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(361)).setAttribute("src","b.gif" );
      ((Element)v.get(361)).setAttribute("width","8" );
      ((Element)v.get(361)).setAttribute("height","8" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */
      /* Termina nodo:360   */
      /* Termina nodo:351   */

      /* Empieza nodo:362 / Elemento padre: 347   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(347)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("td"));
      ((Element)v.get(362)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(364)).setAttribute("src","b.gif" );
      ((Element)v.get(364)).setAttribute("width","8" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(364)).setAttribute("height","8" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */
      /* Termina nodo:363   */

      /* Empieza nodo:365 / Elemento padre: 362   */
      v.add(doc.createElement("td"));
      ((Element)v.get(362)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(366)).setAttribute("nombre","lblvalorImporteGeneracion" );
      ((Element)v.get(366)).setAttribute("alto","13" );
      ((Element)v.get(366)).setAttribute("filas","1" );
      ((Element)v.get(366)).setAttribute("id","datosCampos" );
      ((Element)v.get(366)).setAttribute("valor","                " );
      ((Element)v.get(365)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */
      /* Termina nodo:365   */

      /* Empieza nodo:367 / Elemento padre: 362   */
      v.add(doc.createElement("td"));
      ((Element)v.get(362)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(368)).setAttribute("src","b.gif" );
      ((Element)v.get(368)).setAttribute("width","25" );
      ((Element)v.get(368)).setAttribute("height","8" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */
      /* Termina nodo:367   */

      /* Empieza nodo:369 / Elemento padre: 362   */
      v.add(doc.createElement("td"));
      ((Element)v.get(362)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(370)).setAttribute("nombre","lblvalorResultado" );
      ((Element)v.get(370)).setAttribute("alto","13" );
      ((Element)v.get(370)).setAttribute("filas","1" );
      ((Element)v.get(370)).setAttribute("id","datosCampos" );
      ((Element)v.get(370)).setAttribute("valor","                " );
      ((Element)v.get(369)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */
      /* Termina nodo:369   */

      /* Empieza nodo:371 / Elemento padre: 362   */
      v.add(doc.createElement("td"));
      ((Element)v.get(371)).setAttribute("width","100%" );
      ((Element)v.get(362)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(372)).setAttribute("src","b.gif" );
      ((Element)v.get(372)).setAttribute("width","8" );
      ((Element)v.get(372)).setAttribute("height","8" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */
      /* Termina nodo:371   */
      /* Termina nodo:362   */

      /* Empieza nodo:373 / Elemento padre: 347   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(347)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("td"));
      ((Element)v.get(374)).setAttribute("colspan","4" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(375)).setAttribute("src","b.gif" );
      ((Element)v.get(375)).setAttribute("width","8" );
      ((Element)v.get(375)).setAttribute("height","8" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */
      /* Termina nodo:374   */
      /* Termina nodo:373   */
      /* Termina nodo:347   */
      /* Termina nodo:346   */
      /* Termina nodo:345   */
      /* Termina nodo:305   */
      /* Termina nodo:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:376 / Elemento padre: 298   */
      v.add(doc.createElement("td"));
      ((Element)v.get(298)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(377)).setAttribute("src","b.gif" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */
      /* Termina nodo:376   */
      /* Termina nodo:298   */

      /* Empieza nodo:378 / Elemento padre: 297   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(297)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("td"));
      ((Element)v.get(379)).setAttribute("width","12" );
      ((Element)v.get(379)).setAttribute("align","center" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(380)).setAttribute("src","b.gif" );
      ((Element)v.get(380)).setAttribute("width","12" );
      ((Element)v.get(380)).setAttribute("height","12" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */
      /* Termina nodo:379   */

      /* Empieza nodo:381 / Elemento padre: 378   */
      v.add(doc.createElement("td"));
      ((Element)v.get(381)).setAttribute("width","756" );
      ((Element)v.get(378)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(382)).setAttribute("src","b.gif" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */
      /* Termina nodo:381   */

      /* Empieza nodo:383 / Elemento padre: 378   */
      v.add(doc.createElement("td"));
      ((Element)v.get(383)).setAttribute("width","12" );
      ((Element)v.get(378)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(384)).setAttribute("src","b.gif" );
      ((Element)v.get(384)).setAttribute("width","12" );
      ((Element)v.get(384)).setAttribute("height","1" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */
      /* Termina nodo:383   */
      /* Termina nodo:378   */
      /* Termina nodo:297   */
      /* Termina nodo:296   */

      /* Empieza nodo:385 / Elemento padre: 20   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(385)).setAttribute("nombre","listado1" );
      ((Element)v.get(385)).setAttribute("ancho","742" );
      ((Element)v.get(385)).setAttribute("alto","317" );
      ((Element)v.get(385)).setAttribute("x","12" );
      ((Element)v.get(385)).setAttribute("y","490" );
      ((Element)v.get(385)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(385)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(20)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(386)).setAttribute("precarga","S" );
      ((Element)v.get(386)).setAttribute("conROver","S" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(387)).setAttribute("normal","btnLista2N.gif" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(387)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(387)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(387)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */

      /* Empieza nodo:388 / Elemento padre: 386   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(388)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(388)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(388)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(388)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(386)).appendChild((Element)v.get(388));
      /* Termina nodo:388   */

      /* Empieza nodo:389 / Elemento padre: 386   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(389)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(389)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(386)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:386   */

      /* Empieza nodo:390 / Elemento padre: 385   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(385)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(391)).setAttribute("borde","1" );
      ((Element)v.get(391)).setAttribute("horizDatos","1" );
      ((Element)v.get(391)).setAttribute("horizCabecera","1" );
      ((Element)v.get(391)).setAttribute("vertical","1" );
      ((Element)v.get(391)).setAttribute("horizTitulo","1" );
      ((Element)v.get(391)).setAttribute("horizBase","1" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */

      /* Empieza nodo:392 / Elemento padre: 390   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(392)).setAttribute("borde","#999999" );
      ((Element)v.get(392)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(392)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(392)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(392)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(392)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(392)).setAttribute("horizBase","#999999" );
      ((Element)v.get(390)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */
      /* Termina nodo:390   */

      /* Empieza nodo:393 / Elemento padre: 385   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(393)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(393)).setAttribute("alto","22" );
      ((Element)v.get(393)).setAttribute("imgFondo","" );
      ((Element)v.get(393)).setAttribute("cod","0016" );
      ((Element)v.get(393)).setAttribute("ID","datosTitle" );
      ((Element)v.get(385)).appendChild((Element)v.get(393));
      /* Termina nodo:393   */

      /* Empieza nodo:394 / Elemento padre: 385   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(394)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(394)).setAttribute("alto","22" );
      ((Element)v.get(394)).setAttribute("imgFondo","" );
      ((Element)v.get(385)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */

      /* Empieza nodo:395 / Elemento padre: 385   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(395)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(395)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(395)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(395)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(395)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(395)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(385)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(396)).setAttribute("ancho","80" );
      ((Element)v.get(396)).setAttribute("minimizable","S" );
      ((Element)v.get(396)).setAttribute("minimizada","N" );
      ((Element)v.get(395)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */

      /* Empieza nodo:397 / Elemento padre: 395   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(397)).setAttribute("ancho","100" );
      ((Element)v.get(397)).setAttribute("minimizable","S" );
      ((Element)v.get(397)).setAttribute("minimizada","N" );
      ((Element)v.get(397)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(395)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */

      /* Empieza nodo:398 / Elemento padre: 395   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(398)).setAttribute("ancho","100" );
      ((Element)v.get(398)).setAttribute("minimizable","S" );
      ((Element)v.get(398)).setAttribute("minimizada","N" );
      ((Element)v.get(395)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */

      /* Empieza nodo:399 / Elemento padre: 395   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(399)).setAttribute("ancho","100" );
      ((Element)v.get(399)).setAttribute("minimizable","S" );
      ((Element)v.get(399)).setAttribute("minimizada","N" );
      ((Element)v.get(395)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */

      /* Empieza nodo:400 / Elemento padre: 395   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(400)).setAttribute("ancho","100" );
      ((Element)v.get(400)).setAttribute("minimizable","S" );
      ((Element)v.get(400)).setAttribute("minimizada","N" );
      ((Element)v.get(395)).appendChild((Element)v.get(400));
      /* Termina nodo:400   */

      /* Empieza nodo:401 / Elemento padre: 395   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(401)).setAttribute("ancho","100" );
      ((Element)v.get(401)).setAttribute("minimizable","S" );
      ((Element)v.get(401)).setAttribute("minimizada","N" );
      ((Element)v.get(395)).appendChild((Element)v.get(401));
      /* Termina nodo:401   */

      /* Empieza nodo:402 / Elemento padre: 395   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(402)).setAttribute("ancho","100" );
      ((Element)v.get(402)).setAttribute("minimizable","S" );
      ((Element)v.get(402)).setAttribute("minimizada","N" );
      ((Element)v.get(395)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */

      /* Empieza nodo:403 / Elemento padre: 395   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(403)).setAttribute("ancho","150" );
      ((Element)v.get(403)).setAttribute("minimizable","S" );
      ((Element)v.get(403)).setAttribute("minimizada","N" );
      ((Element)v.get(403)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(395)).appendChild((Element)v.get(403));
      /* Termina nodo:403   */

      /* Empieza nodo:404 / Elemento padre: 395   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(404)).setAttribute("ancho","120" );
      ((Element)v.get(404)).setAttribute("minimizable","S" );
      ((Element)v.get(404)).setAttribute("minimizada","N" );
      ((Element)v.get(395)).appendChild((Element)v.get(404));
      /* Termina nodo:404   */

      /* Empieza nodo:405 / Elemento padre: 395   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(405)).setAttribute("ancho","100" );
      ((Element)v.get(405)).setAttribute("minimizable","S" );
      ((Element)v.get(405)).setAttribute("minimizada","N" );
      ((Element)v.get(395)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */

      /* Empieza nodo:406 / Elemento padre: 395   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(406)).setAttribute("ancho","150" );
      ((Element)v.get(406)).setAttribute("minimizable","S" );
      ((Element)v.get(406)).setAttribute("minimizada","N" );
      ((Element)v.get(406)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(395)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */

      /* Empieza nodo:407 / Elemento padre: 395   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(407)).setAttribute("ancho","150" );
      ((Element)v.get(407)).setAttribute("minimizable","S" );
      ((Element)v.get(407)).setAttribute("minimizada","N" );
      ((Element)v.get(395)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */

      /* Empieza nodo:408 / Elemento padre: 395   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(408)).setAttribute("ancho","60" );
      ((Element)v.get(408)).setAttribute("minimizable","S" );
      ((Element)v.get(408)).setAttribute("minimizada","N" );
      ((Element)v.get(395)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */

      /* Empieza nodo:409 / Elemento padre: 395   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(409)).setAttribute("ancho","100" );
      ((Element)v.get(409)).setAttribute("minimizable","S" );
      ((Element)v.get(409)).setAttribute("minimizada","N" );
      ((Element)v.get(409)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(395)).appendChild((Element)v.get(409));
      /* Termina nodo:409   */

      /* Empieza nodo:410 / Elemento padre: 395   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(410)).setAttribute("ancho","130" );
      ((Element)v.get(410)).setAttribute("minimizable","S" );
      ((Element)v.get(410)).setAttribute("minimizada","N" );
      ((Element)v.get(395)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */

      /* Empieza nodo:411 / Elemento padre: 395   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(411)).setAttribute("ancho","100" );
      ((Element)v.get(411)).setAttribute("minimizable","S" );
      ((Element)v.get(411)).setAttribute("minimizada","N" );
      ((Element)v.get(411)).setAttribute("oculta","S" );
      ((Element)v.get(395)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */

      /* Empieza nodo:412 / Elemento padre: 395   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(412)).setAttribute("ancho","100" );
      ((Element)v.get(412)).setAttribute("minimizable","S" );
      ((Element)v.get(412)).setAttribute("minimizada","N" );
      ((Element)v.get(412)).setAttribute("oculta","S" );
      ((Element)v.get(395)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */

      /* Empieza nodo:413 / Elemento padre: 395   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(413)).setAttribute("ancho","100" );
      ((Element)v.get(413)).setAttribute("minimizable","S" );
      ((Element)v.get(413)).setAttribute("minimizada","N" );
      ((Element)v.get(413)).setAttribute("oculta","S" );
      ((Element)v.get(395)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */
      /* Termina nodo:395   */

      /* Empieza nodo:414 / Elemento padre: 385   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(414)).setAttribute("alto","20" );
      ((Element)v.get(414)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(414)).setAttribute("imgFondo","" );
      ((Element)v.get(414)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(385)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(415)).setAttribute("colFondo","" );
      ((Element)v.get(415)).setAttribute("ID","EstCab" );
      ((Element)v.get(415)).setAttribute("align","center" );
      ((Element)v.get(415)).setAttribute("cod","263" );
      ((Element)v.get(414)).appendChild((Element)v.get(415));

      /* Elemento padre:415 / Elemento actual: 416   */
      v.add(doc.createTextNode("Cód. cliente"));
      ((Element)v.get(415)).appendChild((Text)v.get(416));

      /* Termina nodo Texto:416   */
      /* Termina nodo:415   */

      /* Empieza nodo:417 / Elemento padre: 414   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(417)).setAttribute("colFondo","" );
      ((Element)v.get(417)).setAttribute("ID","EstCab" );
      ((Element)v.get(417)).setAttribute("cod","7" );
      ((Element)v.get(414)).appendChild((Element)v.get(417));

      /* Elemento padre:417 / Elemento actual: 418   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(417)).appendChild((Text)v.get(418));

      /* Termina nodo Texto:418   */
      /* Termina nodo:417   */

      /* Empieza nodo:419 / Elemento padre: 414   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(419)).setAttribute("colFondo","" );
      ((Element)v.get(419)).setAttribute("ID","EstCab" );
      ((Element)v.get(419)).setAttribute("cod","10" );
      ((Element)v.get(414)).appendChild((Element)v.get(419));

      /* Elemento padre:419 / Elemento actual: 420   */
      v.add(doc.createTextNode("Acceso"));
      ((Element)v.get(419)).appendChild((Text)v.get(420));

      /* Termina nodo Texto:420   */
      /* Termina nodo:419   */

      /* Empieza nodo:421 / Elemento padre: 414   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(421)).setAttribute("colFondo","" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(421)).setAttribute("ID","EstCab" );
      ((Element)v.get(421)).setAttribute("cod","122" );
      ((Element)v.get(414)).appendChild((Element)v.get(421));

      /* Elemento padre:421 / Elemento actual: 422   */
      v.add(doc.createTextNode("Subacceso"));
      ((Element)v.get(421)).appendChild((Text)v.get(422));

      /* Termina nodo Texto:422   */
      /* Termina nodo:421   */

      /* Empieza nodo:423 / Elemento padre: 414   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(423)).setAttribute("colFondo","" );
      ((Element)v.get(423)).setAttribute("ID","EstCab" );
      ((Element)v.get(423)).setAttribute("cod","422" );
      ((Element)v.get(414)).appendChild((Element)v.get(423));

      /* Elemento padre:423 / Elemento actual: 424   */
      v.add(doc.createTextNode("Nº documento"));
      ((Element)v.get(423)).appendChild((Text)v.get(424));

      /* Termina nodo Texto:424   */
      /* Termina nodo:423   */

      /* Empieza nodo:425 / Elemento padre: 414   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(425)).setAttribute("colFondo","" );
      ((Element)v.get(425)).setAttribute("ID","EstCab" );
      ((Element)v.get(425)).setAttribute("cod","1192" );
      ((Element)v.get(414)).appendChild((Element)v.get(425));

      /* Elemento padre:425 / Elemento actual: 426   */
      v.add(doc.createTextNode("Nº orden cuota"));
      ((Element)v.get(425)).appendChild((Text)v.get(426));

      /* Termina nodo Texto:426   */
      /* Termina nodo:425   */

      /* Empieza nodo:427 / Elemento padre: 414   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(427)).setAttribute("colFondo","" );
      ((Element)v.get(427)).setAttribute("ID","EstCab" );
      ((Element)v.get(427)).setAttribute("cod","383" );
      ((Element)v.get(414)).appendChild((Element)v.get(427));

      /* Elemento padre:427 / Elemento actual: 428   */
      v.add(doc.createTextNode("Fecha doc."));
      ((Element)v.get(427)).appendChild((Text)v.get(428));

      /* Termina nodo Texto:428   */
      /* Termina nodo:427   */

      /* Empieza nodo:429 / Elemento padre: 414   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(429)).setAttribute("colFondo","" );
      ((Element)v.get(429)).setAttribute("ID","EstCab" );
      ((Element)v.get(429)).setAttribute("cod","883" );
      ((Element)v.get(414)).appendChild((Element)v.get(429));

      /* Elemento padre:429 / Elemento actual: 430   */
      v.add(doc.createTextNode("Fecha vencimiento"));
      ((Element)v.get(429)).appendChild((Text)v.get(430));

      /* Termina nodo Texto:430   */
      /* Termina nodo:429   */

      /* Empieza nodo:431 / Elemento padre: 414   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(431)).setAttribute("colFondo","" );
      ((Element)v.get(431)).setAttribute("ID","EstCab" );
      ((Element)v.get(431)).setAttribute("cod","1225" );
      ((Element)v.get(414)).appendChild((Element)v.get(431));

      /* Elemento padre:431 / Elemento actual: 432   */
      v.add(doc.createTextNode("Medio pago teórico"));
      ((Element)v.get(431)).appendChild((Text)v.get(432));

      /* Termina nodo Texto:432   */
      /* Termina nodo:431   */

      /* Empieza nodo:433 / Elemento padre: 414   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(433)).setAttribute("colFondo","" );
      ((Element)v.get(433)).setAttribute("ID","EstCab" );
      ((Element)v.get(433)).setAttribute("cod","1226" );
      ((Element)v.get(414)).appendChild((Element)v.get(433));

      /* Elemento padre:433 / Elemento actual: 434   */
      v.add(doc.createTextNode("Importe cuota"));
      ((Element)v.get(433)).appendChild((Text)v.get(434));

      /* Termina nodo Texto:434   */
      /* Termina nodo:433   */

      /* Empieza nodo:435 / Elemento padre: 414   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(435)).setAttribute("colFondo","" );
      ((Element)v.get(435)).setAttribute("ID","EstCab" );
      ((Element)v.get(435)).setAttribute("cod","1227" );
      ((Element)v.get(414)).appendChild((Element)v.get(435));

      /* Elemento padre:435 / Elemento actual: 436   */
      v.add(doc.createTextNode("Importe aplicado"));
      ((Element)v.get(435)).appendChild((Text)v.get(436));

      /* Termina nodo Texto:436   */
      /* Termina nodo:435   */

      /* Empieza nodo:437 / Elemento padre: 414   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(437)).setAttribute("colFondo","" );
      ((Element)v.get(437)).setAttribute("ID","EstCab" );
      ((Element)v.get(437)).setAttribute("cod","902" );
      ((Element)v.get(414)).appendChild((Element)v.get(437));

      /* Elemento padre:437 / Elemento actual: 438   */
      v.add(doc.createTextNode("Importe pendiente"));
      ((Element)v.get(437)).appendChild((Text)v.get(438));

      /* Termina nodo Texto:438   */
      /* Termina nodo:437   */

      /* Empieza nodo:439 / Elemento padre: 414   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(439)).setAttribute("colFondo","" );
      ((Element)v.get(439)).setAttribute("ID","EstCab" );
      ((Element)v.get(439)).setAttribute("cod","642" );
      ((Element)v.get(414)).appendChild((Element)v.get(439));

      /* Elemento padre:439 / Elemento actual: 440   */
      v.add(doc.createTextNode("Divisa"));
      ((Element)v.get(439)).appendChild((Text)v.get(440));

      /* Termina nodo Texto:440   */
      /* Termina nodo:439   */

      /* Empieza nodo:441 / Elemento padre: 414   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(441)).setAttribute("colFondo","" );
      ((Element)v.get(441)).setAttribute("ID","EstCab" );
      ((Element)v.get(441)).setAttribute("cod","668" );
      ((Element)v.get(414)).appendChild((Element)v.get(441));

      /* Elemento padre:441 / Elemento actual: 442   */
      v.add(doc.createTextNode("Importe divisa"));
      ((Element)v.get(441)).appendChild((Text)v.get(442));

      /* Termina nodo Texto:442   */
      /* Termina nodo:441   */

      /* Empieza nodo:443 / Elemento padre: 414   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(443)).setAttribute("colFondo","" );
      ((Element)v.get(443)).setAttribute("ID","EstCab" );
      ((Element)v.get(443)).setAttribute("cod","1229" );
      ((Element)v.get(414)).appendChild((Element)v.get(443));

      /* Elemento padre:443 / Elemento actual: 444   */
      v.add(doc.createTextNode("Importe a aplicar"));
      ((Element)v.get(443)).appendChild((Text)v.get(444));

      /* Termina nodo Texto:444   */
      /* Termina nodo:443   */

      /* Empieza nodo:445 / Elemento padre: 414   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(445)).setAttribute("colFondo","" );
      ((Element)v.get(445)).setAttribute("ID","EstCab" );
      ((Element)v.get(414)).appendChild((Element)v.get(445));

      /* Elemento padre:445 / Elemento actual: 446   */
      v.add(doc.createTextNode("medioPagoOid"));
      ((Element)v.get(445)).appendChild((Text)v.get(446));

      /* Termina nodo Texto:446   */
      /* Termina nodo:445   */

      /* Empieza nodo:447 / Elemento padre: 414   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(447)).setAttribute("colFondo","" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(447)).setAttribute("ID","EstCab" );
      ((Element)v.get(414)).appendChild((Element)v.get(447));

      /* Elemento padre:447 / Elemento actual: 448   */
      v.add(doc.createTextNode("oidMovimiento"));
      ((Element)v.get(447)).appendChild((Text)v.get(448));

      /* Termina nodo Texto:448   */
      /* Termina nodo:447   */

      /* Empieza nodo:449 / Elemento padre: 414   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(449)).setAttribute("colFondo","" );
      ((Element)v.get(449)).setAttribute("ID","EstCab" );
      ((Element)v.get(414)).appendChild((Element)v.get(449));

      /* Elemento padre:449 / Elemento actual: 450   */
      v.add(doc.createTextNode("oidDetalle"));
      ((Element)v.get(449)).appendChild((Text)v.get(450));

      /* Termina nodo Texto:450   */
      /* Termina nodo:449   */
      /* Termina nodo:414   */

      /* Empieza nodo:451 / Elemento padre: 385   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(451)).setAttribute("alto","22" );
      ((Element)v.get(451)).setAttribute("accion","" );
      ((Element)v.get(451)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(451)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(451)).setAttribute("maxSel","-1" );
      ((Element)v.get(451)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(451)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(451)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(451)).setAttribute("onLoad","" );
      ((Element)v.get(451)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(385)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(452)).setAttribute("tipo","texto" );
      ((Element)v.get(452)).setAttribute("ID","EstDat" );
      ((Element)v.get(451)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */

      /* Empieza nodo:453 / Elemento padre: 451   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(453)).setAttribute("tipo","texto" );
      ((Element)v.get(453)).setAttribute("ID","EstDat2" );
      ((Element)v.get(451)).appendChild((Element)v.get(453));
      /* Termina nodo:453   */

      /* Empieza nodo:454 / Elemento padre: 451   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(454)).setAttribute("tipo","texto" );
      ((Element)v.get(454)).setAttribute("ID","EstDat" );
      ((Element)v.get(451)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */

      /* Empieza nodo:455 / Elemento padre: 451   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(455)).setAttribute("tipo","texto" );
      ((Element)v.get(455)).setAttribute("ID","EstDat2" );
      ((Element)v.get(451)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */

      /* Empieza nodo:456 / Elemento padre: 451   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(456)).setAttribute("tipo","texto" );
      ((Element)v.get(456)).setAttribute("ID","EstDat" );
      ((Element)v.get(451)).appendChild((Element)v.get(456));
      /* Termina nodo:456   */

      /* Empieza nodo:457 / Elemento padre: 451   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(457)).setAttribute("tipo","texto" );
      ((Element)v.get(457)).setAttribute("ID","EstDat" );
      ((Element)v.get(451)).appendChild((Element)v.get(457));
      /* Termina nodo:457   */

      /* Empieza nodo:458 / Elemento padre: 451   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(458)).setAttribute("tipo","texto" );
      ((Element)v.get(458)).setAttribute("ID","EstDat2" );
      ((Element)v.get(451)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */

      /* Empieza nodo:459 / Elemento padre: 451   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(459)).setAttribute("tipo","texto" );
      ((Element)v.get(459)).setAttribute("ID","EstDat" );
      ((Element)v.get(451)).appendChild((Element)v.get(459));
      /* Termina nodo:459   */

      /* Empieza nodo:460 / Elemento padre: 451   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(460)).setAttribute("tipo","texto" );
      ((Element)v.get(460)).setAttribute("ID","EstDat2" );
      ((Element)v.get(451)).appendChild((Element)v.get(460));
      /* Termina nodo:460   */

      /* Empieza nodo:461 / Elemento padre: 451   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(461)).setAttribute("tipo","texto" );
      ((Element)v.get(461)).setAttribute("ID","EstDat" );
      ((Element)v.get(451)).appendChild((Element)v.get(461));
      /* Termina nodo:461   */

      /* Empieza nodo:462 / Elemento padre: 451   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(462)).setAttribute("tipo","texto" );
      ((Element)v.get(462)).setAttribute("ID","EstDat2" );
      ((Element)v.get(451)).appendChild((Element)v.get(462));
      /* Termina nodo:462   */

      /* Empieza nodo:463 / Elemento padre: 451   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(463)).setAttribute("tipo","texto" );
      ((Element)v.get(463)).setAttribute("ID","EstDat" );
      ((Element)v.get(451)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */

      /* Empieza nodo:464 / Elemento padre: 451   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(464)).setAttribute("tipo","texto" );
      ((Element)v.get(464)).setAttribute("ID","EstDat2" );
      ((Element)v.get(451)).appendChild((Element)v.get(464));
      /* Termina nodo:464   */

      /* Empieza nodo:465 / Elemento padre: 451   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(465)).setAttribute("tipo","texto" );
      ((Element)v.get(465)).setAttribute("ID","EstDat" );
      ((Element)v.get(451)).appendChild((Element)v.get(465));
      /* Termina nodo:465   */

      /* Empieza nodo:466 / Elemento padre: 451   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(466)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(466)).setAttribute("nombre","Texto1" );
      ((Element)v.get(466)).setAttribute("size","18" );
      ((Element)v.get(466)).setAttribute("deshabilitado","N" );
      ((Element)v.get(466)).setAttribute("readonly","N" );
      ((Element)v.get(466)).setAttribute("max","18" );
      ((Element)v.get(466)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(466)).setAttribute("ID","EstDat2" );
      ((Element)v.get(466)).setAttribute("onShTab","focalizaAnteriorLista(FILAEVENTO, TECLAEVENTO)" );
      ((Element)v.get(466)).setAttribute("onTab","focalizaSiguienteLista(FILAEVENTO, TECLAEVENTO)" );
      ((Element)v.get(466)).setAttribute("onBlur","importeAplicarCancelacionCuotasOnBlur(FILAEVENTO);" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(466)).setAttribute("validacion","validaImporteNegativo(valor, 10)" );
      ((Element)v.get(451)).appendChild((Element)v.get(466));
      /* Termina nodo:466   */

      /* Empieza nodo:467 / Elemento padre: 451   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(467)).setAttribute("tipo","texto" );
      ((Element)v.get(467)).setAttribute("ID","EstDat" );
      ((Element)v.get(451)).appendChild((Element)v.get(467));
      /* Termina nodo:467   */

      /* Empieza nodo:468 / Elemento padre: 451   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(468)).setAttribute("tipo","texto" );
      ((Element)v.get(468)).setAttribute("ID","EstDat" );
      ((Element)v.get(451)).appendChild((Element)v.get(468));
      /* Termina nodo:468   */

      /* Empieza nodo:469 / Elemento padre: 451   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(469)).setAttribute("tipo","texto" );
      ((Element)v.get(469)).setAttribute("ID","EstDat2" );
      ((Element)v.get(451)).appendChild((Element)v.get(469));
      /* Termina nodo:469   */
      /* Termina nodo:451   */

      /* Empieza nodo:470 / Elemento padre: 385   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(385)).appendChild((Element)v.get(470));
      /* Termina nodo:470   */
      /* Termina nodo:385   */

      /* Empieza nodo:471 / Elemento padre: 20   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(471)).setAttribute("nombre","listado2" );
      ((Element)v.get(471)).setAttribute("ancho","742" );
      ((Element)v.get(471)).setAttribute("alto","317" );
      ((Element)v.get(471)).setAttribute("x","12" );
      ((Element)v.get(471)).setAttribute("y","489" );
      ((Element)v.get(471)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(471)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(20)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(472)).setAttribute("precarga","S" );
      ((Element)v.get(472)).setAttribute("conROver","S" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));

      /* Empieza nodo:473 / Elemento padre: 472   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(473)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(473)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(473)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(473)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(472)).appendChild((Element)v.get(473));
      /* Termina nodo:473   */

      /* Empieza nodo:474 / Elemento padre: 472   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(474)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(474)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(474)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(474)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(472)).appendChild((Element)v.get(474));
      /* Termina nodo:474   */

      /* Empieza nodo:475 / Elemento padre: 472   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(475)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(475)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(472)).appendChild((Element)v.get(475));
      /* Termina nodo:475   */
      /* Termina nodo:472   */

      /* Empieza nodo:476 / Elemento padre: 471   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(471)).appendChild((Element)v.get(476));

      /* Empieza nodo:477 / Elemento padre: 476   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(477)).setAttribute("borde","1" );
      ((Element)v.get(477)).setAttribute("horizDatos","1" );
      ((Element)v.get(477)).setAttribute("horizCabecera","1" );
      ((Element)v.get(477)).setAttribute("vertical","1" );
      ((Element)v.get(477)).setAttribute("horizTitulo","1" );
      ((Element)v.get(477)).setAttribute("horizBase","1" );
      ((Element)v.get(476)).appendChild((Element)v.get(477));
      /* Termina nodo:477   */

      /* Empieza nodo:478 / Elemento padre: 476   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(478)).setAttribute("borde","#999999" );
      ((Element)v.get(478)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(478)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(478)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(478)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(478)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(478)).setAttribute("horizBase","#999999" );
      ((Element)v.get(476)).appendChild((Element)v.get(478));
      /* Termina nodo:478   */
      /* Termina nodo:476   */

      /* Empieza nodo:479 / Elemento padre: 471   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(479)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(479)).setAttribute("alto","22" );
      ((Element)v.get(479)).setAttribute("imgFondo","" );
      ((Element)v.get(479)).setAttribute("cod","0015" );
      ((Element)v.get(479)).setAttribute("ID","datosTitle" );
      ((Element)v.get(471)).appendChild((Element)v.get(479));
      /* Termina nodo:479   */

      /* Empieza nodo:480 / Elemento padre: 471   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(480)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(480)).setAttribute("alto","22" );
      ((Element)v.get(480)).setAttribute("imgFondo","" );
      ((Element)v.get(471)).appendChild((Element)v.get(480));
      /* Termina nodo:480   */

      /* Empieza nodo:481 / Elemento padre: 471   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(481)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(481)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(481)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(481)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(481)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(481)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(471)).appendChild((Element)v.get(481));

      /* Empieza nodo:482 / Elemento padre: 481   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(482)).setAttribute("ancho","120" );
      ((Element)v.get(482)).setAttribute("minimizable","S" );
      ((Element)v.get(482)).setAttribute("minimizada","N" );
      ((Element)v.get(481)).appendChild((Element)v.get(482));
      /* Termina nodo:482   */

      /* Empieza nodo:483 / Elemento padre: 481   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(483)).setAttribute("ancho","180" );
      ((Element)v.get(483)).setAttribute("minimizable","S" );
      ((Element)v.get(483)).setAttribute("minimizada","N" );
      ((Element)v.get(481)).appendChild((Element)v.get(483));
      /* Termina nodo:483   */

      /* Empieza nodo:484 / Elemento padre: 481   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(484)).setAttribute("ancho","120" );
      ((Element)v.get(484)).setAttribute("minimizable","S" );
      ((Element)v.get(484)).setAttribute("minimizada","N" );
      ((Element)v.get(484)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(481)).appendChild((Element)v.get(484));
      /* Termina nodo:484   */

      /* Empieza nodo:485 / Elemento padre: 481   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(485)).setAttribute("ancho","120" );
      ((Element)v.get(485)).setAttribute("minimizable","S" );
      ((Element)v.get(485)).setAttribute("minimizada","N" );
      ((Element)v.get(481)).appendChild((Element)v.get(485));
      /* Termina nodo:485   */

      /* Empieza nodo:486 / Elemento padre: 481   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(486)).setAttribute("ancho","180" );
      ((Element)v.get(486)).setAttribute("minimizable","S" );
      ((Element)v.get(486)).setAttribute("minimizada","N" );
      ((Element)v.get(481)).appendChild((Element)v.get(486));
      /* Termina nodo:486   */

      /* Empieza nodo:487 / Elemento padre: 481   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(487)).setAttribute("ancho","120" );
      ((Element)v.get(487)).setAttribute("minimizable","S" );
      ((Element)v.get(487)).setAttribute("minimizada","N" );
      ((Element)v.get(481)).appendChild((Element)v.get(487));
      /* Termina nodo:487   */

      /* Empieza nodo:488 / Elemento padre: 481   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(488)).setAttribute("ancho","120" );
      ((Element)v.get(488)).setAttribute("minimizable","S" );
      ((Element)v.get(488)).setAttribute("minimizada","N" );
      ((Element)v.get(481)).appendChild((Element)v.get(488));
      /* Termina nodo:488   */

      /* Empieza nodo:489 / Elemento padre: 481   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(489)).setAttribute("ancho","120" );
      ((Element)v.get(489)).setAttribute("minimizable","S" );
      ((Element)v.get(489)).setAttribute("minimizada","N" );
      ((Element)v.get(481)).appendChild((Element)v.get(489));
      /* Termina nodo:489   */

      /* Empieza nodo:490 / Elemento padre: 481   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(490)).setAttribute("ancho","100" );
      ((Element)v.get(490)).setAttribute("minimizable","S" );
      ((Element)v.get(490)).setAttribute("minimizada","N" );
      ((Element)v.get(490)).setAttribute("oculta","S" );
      ((Element)v.get(481)).appendChild((Element)v.get(490));
      /* Termina nodo:490   */

      /* Empieza nodo:491 / Elemento padre: 481   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(491)).setAttribute("ancho","100" );
      ((Element)v.get(491)).setAttribute("minimizable","S" );
      ((Element)v.get(491)).setAttribute("minimizada","N" );
      ((Element)v.get(491)).setAttribute("oculta","S" );
      ((Element)v.get(481)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */

      /* Empieza nodo:492 / Elemento padre: 481   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(492)).setAttribute("ancho","100" );
      ((Element)v.get(492)).setAttribute("minimizable","S" );
      ((Element)v.get(492)).setAttribute("minimizada","N" );
      ((Element)v.get(492)).setAttribute("oculta","S" );
      ((Element)v.get(481)).appendChild((Element)v.get(492));
      /* Termina nodo:492   */
      /* Termina nodo:481   */

      /* Empieza nodo:493 / Elemento padre: 471   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(493)).setAttribute("alto","20" );
      ((Element)v.get(493)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(493)).setAttribute("imgFondo","" );
      ((Element)v.get(493)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(471)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(494)).setAttribute("colFondo","" );
      ((Element)v.get(494)).setAttribute("ID","EstCab" );
      ((Element)v.get(494)).setAttribute("cod","263" );
      ((Element)v.get(493)).appendChild((Element)v.get(494));

      /* Elemento padre:494 / Elemento actual: 495   */
      v.add(doc.createTextNode("Cód. cliente"));
      ((Element)v.get(494)).appendChild((Text)v.get(495));

      /* Termina nodo Texto:495   */
      /* Termina nodo:494   */

      /* Empieza nodo:496 / Elemento padre: 493   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(496)).setAttribute("colFondo","" );
      ((Element)v.get(496)).setAttribute("ID","EstCab" );
      ((Element)v.get(496)).setAttribute("cod","637" );
      ((Element)v.get(493)).appendChild((Element)v.get(496));

      /* Elemento padre:496 / Elemento actual: 497   */
      v.add(doc.createTextNode("Cuenta corriente bancaria "));
      ((Element)v.get(496)).appendChild((Text)v.get(497));

      /* Termina nodo Texto:497   */
      /* Termina nodo:496   */

      /* Empieza nodo:498 / Elemento padre: 493   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(498)).setAttribute("colFondo","" );
      ((Element)v.get(498)).setAttribute("ID","EstCab" );
      ((Element)v.get(498)).setAttribute("cod","654" );
      ((Element)v.get(493)).appendChild((Element)v.get(498));

      /* Elemento padre:498 / Elemento actual: 499   */
      v.add(doc.createTextNode("Fecha pago"));
      ((Element)v.get(498)).appendChild((Text)v.get(499));

      /* Termina nodo Texto:499   */
      /* Termina nodo:498   */

      /* Empieza nodo:500 / Elemento padre: 493   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(500)).setAttribute("colFondo","" );
      ((Element)v.get(500)).setAttribute("ID","EstCab" );
      ((Element)v.get(500)).setAttribute("cod","680" );
      ((Element)v.get(493)).appendChild((Element)v.get(500));

      /* Elemento padre:500 / Elemento actual: 501   */
      v.add(doc.createTextNode("Nº lote"));
      ((Element)v.get(500)).appendChild((Text)v.get(501));

      /* Termina nodo Texto:501   */
      /* Termina nodo:500   */

      /* Empieza nodo:502 / Elemento padre: 493   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(502)).setAttribute("colFondo","" );
      ((Element)v.get(502)).setAttribute("ID","EstCab" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(502)).setAttribute("cod","634" );
      ((Element)v.get(493)).appendChild((Element)v.get(502));

      /* Elemento padre:502 / Elemento actual: 503   */
      v.add(doc.createTextNode("Consecutivo transacción"));
      ((Element)v.get(502)).appendChild((Text)v.get(503));

      /* Termina nodo Texto:503   */
      /* Termina nodo:502   */

      /* Empieza nodo:504 / Elemento padre: 493   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(504)).setAttribute("colFondo","" );
      ((Element)v.get(504)).setAttribute("ID","EstCab" );
      ((Element)v.get(504)).setAttribute("cod","670" );
      ((Element)v.get(493)).appendChild((Element)v.get(504));

      /* Elemento padre:504 / Elemento actual: 505   */
      v.add(doc.createTextNode("Importe pago"));
      ((Element)v.get(504)).appendChild((Text)v.get(505));

      /* Termina nodo Texto:505   */
      /* Termina nodo:504   */

      /* Empieza nodo:506 / Elemento padre: 493   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(506)).setAttribute("colFondo","" );
      ((Element)v.get(506)).setAttribute("ID","EstCab" );
      ((Element)v.get(506)).setAttribute("cod","902" );
      ((Element)v.get(493)).appendChild((Element)v.get(506));

      /* Elemento padre:506 / Elemento actual: 507   */
      v.add(doc.createTextNode("Importe pendiente"));
      ((Element)v.get(506)).appendChild((Text)v.get(507));

      /* Termina nodo Texto:507   */
      /* Termina nodo:506   */

      /* Empieza nodo:508 / Elemento padre: 493   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(508)).setAttribute("colFondo","" );
      ((Element)v.get(508)).setAttribute("ID","EstCab" );
      ((Element)v.get(508)).setAttribute("cod","1229" );
      ((Element)v.get(493)).appendChild((Element)v.get(508));

      /* Elemento padre:508 / Elemento actual: 509   */
      v.add(doc.createTextNode("Importe a aplicar"));
      ((Element)v.get(508)).appendChild((Text)v.get(509));

      /* Termina nodo Texto:509   */
      /* Termina nodo:508   */

      /* Empieza nodo:510 / Elemento padre: 493   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(510)).setAttribute("colFondo","" );
      ((Element)v.get(510)).setAttribute("ID","EstCab" );
      ((Element)v.get(493)).appendChild((Element)v.get(510));

      /* Elemento padre:510 / Elemento actual: 511   */
      v.add(doc.createTextNode("cuentaCorrienteOid"));
      ((Element)v.get(510)).appendChild((Text)v.get(511));

      /* Termina nodo Texto:511   */
      /* Termina nodo:510   */

      /* Empieza nodo:512 / Elemento padre: 493   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(512)).setAttribute("colFondo","" );
      ((Element)v.get(512)).setAttribute("ID","EstCab" );
      ((Element)v.get(493)).appendChild((Element)v.get(512));

      /* Elemento padre:512 / Elemento actual: 513   */
      v.add(doc.createTextNode("oidMovimiento"));
      ((Element)v.get(512)).appendChild((Text)v.get(513));

      /* Termina nodo Texto:513   */
      /* Termina nodo:512   */

      /* Empieza nodo:514 / Elemento padre: 493   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(514)).setAttribute("colFondo","" );
      ((Element)v.get(514)).setAttribute("ID","EstCab" );
      ((Element)v.get(493)).appendChild((Element)v.get(514));

      /* Elemento padre:514 / Elemento actual: 515   */
      v.add(doc.createTextNode("oidDetalle "));
      ((Element)v.get(514)).appendChild((Text)v.get(515));

      /* Termina nodo Texto:515   */
      /* Termina nodo:514   */
      /* Termina nodo:493   */

      /* Empieza nodo:516 / Elemento padre: 471   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(516)).setAttribute("alto","22" );
      ((Element)v.get(516)).setAttribute("accion","" );
      ((Element)v.get(516)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(516)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(516)).setAttribute("maxSel","-1" );
      ((Element)v.get(516)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(516)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(516)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(516)).setAttribute("onLoad","" );
      ((Element)v.get(516)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(471)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(517)).setAttribute("tipo","texto" );
      ((Element)v.get(517)).setAttribute("ID","EstDat" );
      ((Element)v.get(516)).appendChild((Element)v.get(517));
      /* Termina nodo:517   */

      /* Empieza nodo:518 / Elemento padre: 516   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(518)).setAttribute("tipo","texto" );
      ((Element)v.get(518)).setAttribute("ID","EstDat2" );
      ((Element)v.get(516)).appendChild((Element)v.get(518));
      /* Termina nodo:518   */

      /* Empieza nodo:519 / Elemento padre: 516   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(519)).setAttribute("tipo","texto" );
      ((Element)v.get(519)).setAttribute("ID","EstDat" );
      ((Element)v.get(516)).appendChild((Element)v.get(519));
      /* Termina nodo:519   */

      /* Empieza nodo:520 / Elemento padre: 516   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(520)).setAttribute("tipo","texto" );
      ((Element)v.get(520)).setAttribute("ID","EstDat2" );
      ((Element)v.get(516)).appendChild((Element)v.get(520));
      /* Termina nodo:520   */

      /* Empieza nodo:521 / Elemento padre: 516   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(521)).setAttribute("tipo","texto" );
      ((Element)v.get(521)).setAttribute("ID","EstDat" );
      ((Element)v.get(516)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */

      /* Empieza nodo:522 / Elemento padre: 516   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(522)).setAttribute("tipo","texto" );
      ((Element)v.get(522)).setAttribute("ID","EstDat2" );
      ((Element)v.get(516)).appendChild((Element)v.get(522));
      /* Termina nodo:522   */

      /* Empieza nodo:523 / Elemento padre: 516   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(523)).setAttribute("tipo","texto" );
      ((Element)v.get(523)).setAttribute("ID","EstDat" );
      ((Element)v.get(516)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */

      /* Empieza nodo:524 / Elemento padre: 516   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(524)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(524)).setAttribute("nombre","Texto2" );
      ((Element)v.get(524)).setAttribute("size","18" );
      ((Element)v.get(524)).setAttribute("deshabilitado","N" );
      ((Element)v.get(524)).setAttribute("readonly","N" );
      ((Element)v.get(524)).setAttribute("max","18" );
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(524)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(524)).setAttribute("ID","EstDat2" );
      ((Element)v.get(524)).setAttribute("onShTab","focalizaAnteriorLista(FILAEVENTO, TECLAEVENTO)" );
      ((Element)v.get(524)).setAttribute("onTab","focalizaSiguienteLista(FILAEVENTO, TECLAEVENTO)" );
      ((Element)v.get(524)).setAttribute("onBlur","filaEvento = FILAEVENTO;importeCobrosOnBlur(FILAEVENTO);" );
      ((Element)v.get(524)).setAttribute("validacion","validaImporteNegativo(valor, 10)" );
      ((Element)v.get(516)).appendChild((Element)v.get(524));
      /* Termina nodo:524   */

      /* Empieza nodo:525 / Elemento padre: 516   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(525)).setAttribute("tipo","texto" );
      ((Element)v.get(525)).setAttribute("ID","EstDat" );
      ((Element)v.get(516)).appendChild((Element)v.get(525));
      /* Termina nodo:525   */

      /* Empieza nodo:526 / Elemento padre: 516   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(526)).setAttribute("tipo","texto" );
      ((Element)v.get(526)).setAttribute("ID","EstDat2" );
      ((Element)v.get(516)).appendChild((Element)v.get(526));
      /* Termina nodo:526   */

      /* Empieza nodo:527 / Elemento padre: 516   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(527)).setAttribute("tipo","texto" );
      ((Element)v.get(527)).setAttribute("ID","EstDat" );
      ((Element)v.get(516)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */
      /* Termina nodo:516   */

      /* Empieza nodo:528 / Elemento padre: 471   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(471)).appendChild((Element)v.get(528));
      /* Termina nodo:528   */
      /* Termina nodo:471   */

      /* Empieza nodo:529 / Elemento padre: 20   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(529)).setAttribute("nombre","listado3" );
      ((Element)v.get(529)).setAttribute("ancho","742" );
      ((Element)v.get(529)).setAttribute("alto","317" );
      ((Element)v.get(529)).setAttribute("x","12" );
      ((Element)v.get(529)).setAttribute("y","489" );
      ((Element)v.get(529)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(529)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(20)).appendChild((Element)v.get(529));

      /* Empieza nodo:530 / Elemento padre: 529   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(530)).setAttribute("precarga","S" );
      ((Element)v.get(530)).setAttribute("conROver","S" );
      ((Element)v.get(529)).appendChild((Element)v.get(530));

      /* Empieza nodo:531 / Elemento padre: 530   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(531)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(531)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(531)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(531)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(530)).appendChild((Element)v.get(531));
      /* Termina nodo:531   */

      /* Empieza nodo:532 / Elemento padre: 530   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(532)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(532)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(532)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(532)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(530)).appendChild((Element)v.get(532));
      /* Termina nodo:532   */

      /* Empieza nodo:533 / Elemento padre: 530   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(533)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(533)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(530)).appendChild((Element)v.get(533));
      /* Termina nodo:533   */
      /* Termina nodo:530   */

      /* Empieza nodo:534 / Elemento padre: 529   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(529)).appendChild((Element)v.get(534));

      /* Empieza nodo:535 / Elemento padre: 534   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(535)).setAttribute("borde","1" );
      ((Element)v.get(535)).setAttribute("horizDatos","1" );
      ((Element)v.get(535)).setAttribute("horizCabecera","1" );
      ((Element)v.get(535)).setAttribute("vertical","1" );
      ((Element)v.get(535)).setAttribute("horizTitulo","1" );
      ((Element)v.get(535)).setAttribute("horizBase","1" );
      ((Element)v.get(534)).appendChild((Element)v.get(535));
      /* Termina nodo:535   */

      /* Empieza nodo:536 / Elemento padre: 534   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(536)).setAttribute("borde","#999999" );
      ((Element)v.get(536)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(536)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(536)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(536)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(536)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(536)).setAttribute("horizBase","#999999" );
      ((Element)v.get(534)).appendChild((Element)v.get(536));
      /* Termina nodo:536   */
      /* Termina nodo:534   */

      /* Empieza nodo:537 / Elemento padre: 529   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(537)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(537)).setAttribute("alto","22" );
      ((Element)v.get(537)).setAttribute("imgFondo","" );
      ((Element)v.get(537)).setAttribute("cod","0017" );
      ((Element)v.get(537)).setAttribute("ID","datosTitle" );
      ((Element)v.get(529)).appendChild((Element)v.get(537));
      /* Termina nodo:537   */

      /* Empieza nodo:538 / Elemento padre: 529   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(538)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(538)).setAttribute("alto","22" );
      ((Element)v.get(538)).setAttribute("imgFondo","" );
      ((Element)v.get(529)).appendChild((Element)v.get(538));
      /* Termina nodo:538   */

      /* Empieza nodo:539 / Elemento padre: 529   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(539)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(539)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(539)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(539)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(539)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(539)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(529)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("COL"));
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(540)).setAttribute("ancho","100" );
      ((Element)v.get(540)).setAttribute("minimizable","S" );
      ((Element)v.get(540)).setAttribute("minimizada","N" );
      ((Element)v.get(539)).appendChild((Element)v.get(540));
      /* Termina nodo:540   */

      /* Empieza nodo:541 / Elemento padre: 539   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(541)).setAttribute("ancho","100" );
      ((Element)v.get(541)).setAttribute("minimizable","S" );
      ((Element)v.get(541)).setAttribute("minimizada","N" );
      ((Element)v.get(541)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(539)).appendChild((Element)v.get(541));
      /* Termina nodo:541   */

      /* Empieza nodo:542 / Elemento padre: 539   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(542)).setAttribute("ancho","100" );
      ((Element)v.get(542)).setAttribute("minimizable","S" );
      ((Element)v.get(542)).setAttribute("minimizada","N" );
      ((Element)v.get(539)).appendChild((Element)v.get(542));
      /* Termina nodo:542   */

      /* Empieza nodo:543 / Elemento padre: 539   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(543)).setAttribute("ancho","100" );
      ((Element)v.get(543)).setAttribute("minimizable","S" );
      ((Element)v.get(543)).setAttribute("minimizada","N" );
      ((Element)v.get(539)).appendChild((Element)v.get(543));
      /* Termina nodo:543   */

      /* Empieza nodo:544 / Elemento padre: 539   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(544)).setAttribute("ancho","100" );
      ((Element)v.get(544)).setAttribute("minimizable","S" );
      ((Element)v.get(544)).setAttribute("minimizada","N" );
      ((Element)v.get(544)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(539)).appendChild((Element)v.get(544));
      /* Termina nodo:544   */

      /* Empieza nodo:545 / Elemento padre: 539   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(545)).setAttribute("ancho","100" );
      ((Element)v.get(545)).setAttribute("minimizable","S" );
      ((Element)v.get(545)).setAttribute("minimizada","N" );
      ((Element)v.get(539)).appendChild((Element)v.get(545));
      /* Termina nodo:545   */

      /* Empieza nodo:546 / Elemento padre: 539   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(546)).setAttribute("ancho","100" );
      ((Element)v.get(546)).setAttribute("minimizable","S" );
      ((Element)v.get(546)).setAttribute("minimizada","N" );
      ((Element)v.get(539)).appendChild((Element)v.get(546));
      /* Termina nodo:546   */

      /* Empieza nodo:547 / Elemento padre: 539   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(547)).setAttribute("ancho","100" );
      ((Element)v.get(547)).setAttribute("minimizable","S" );
      ((Element)v.get(547)).setAttribute("minimizada","N" );
      ((Element)v.get(547)).setAttribute("oculta","S" );
      ((Element)v.get(539)).appendChild((Element)v.get(547));
      /* Termina nodo:547   */

      /* Empieza nodo:548 / Elemento padre: 539   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(548)).setAttribute("ancho","100" );
      ((Element)v.get(548)).setAttribute("minimizable","S" );
      ((Element)v.get(548)).setAttribute("minimizada","N" );
      ((Element)v.get(548)).setAttribute("oculta","S" );
      ((Element)v.get(539)).appendChild((Element)v.get(548));
      /* Termina nodo:548   */

      /* Empieza nodo:549 / Elemento padre: 539   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(549)).setAttribute("ancho","100" );
      ((Element)v.get(549)).setAttribute("minimizable","S" );
      ((Element)v.get(549)).setAttribute("minimizada","N" );
      ((Element)v.get(549)).setAttribute("oculta","S" );
      ((Element)v.get(539)).appendChild((Element)v.get(549));
      /* Termina nodo:549   */
      /* Termina nodo:539   */

      /* Empieza nodo:550 / Elemento padre: 529   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(550)).setAttribute("alto","20" );
      ((Element)v.get(550)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(550)).setAttribute("imgFondo","" );
      ((Element)v.get(550)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(529)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(551)).setAttribute("colFondo","" );
      ((Element)v.get(551)).setAttribute("ID","EstCab" );
      ((Element)v.get(551)).setAttribute("align","center" );
      ((Element)v.get(551)).setAttribute("cod","263" );
      ((Element)v.get(550)).appendChild((Element)v.get(551));

      /* Elemento padre:551 / Elemento actual: 552   */
      v.add(doc.createTextNode("Cód. cliente"));
      ((Element)v.get(551)).appendChild((Text)v.get(552));

      /* Termina nodo Texto:552   */
      /* Termina nodo:551   */

      /* Empieza nodo:553 / Elemento padre: 550   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(553)).setAttribute("colFondo","" );
      ((Element)v.get(553)).setAttribute("ID","EstCab" );
      ((Element)v.get(553)).setAttribute("cod","636" );
      ((Element)v.get(550)).appendChild((Element)v.get(553));

      /* Elemento padre:553 / Elemento actual: 554   */
      v.add(doc.createTextNode("CCC"));
      ((Element)v.get(553)).appendChild((Text)v.get(554));

      /* Termina nodo Texto:554   */
      /* Termina nodo:553   */

      /* Empieza nodo:555 / Elemento padre: 550   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(555)).setAttribute("colFondo","" );
      ((Element)v.get(555)).setAttribute("ID","EstCab" );
      ((Element)v.get(555)).setAttribute("cod","1977" );
      ((Element)v.get(550)).appendChild((Element)v.get(555));

      /* Elemento padre:555 / Elemento actual: 556   */
      v.add(doc.createTextNode("Tipo abono"));
      ((Element)v.get(555)).appendChild((Text)v.get(556));

      /* Termina nodo Texto:556   */
      /* Termina nodo:555   */

      /* Empieza nodo:557 / Elemento padre: 550   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(557)).setAttribute("colFondo","" );
      ((Element)v.get(557)).setAttribute("ID","EstCab" );
      ((Element)v.get(557)).setAttribute("cod","660" );
      ((Element)v.get(550)).appendChild((Element)v.get(557));

      /* Elemento padre:557 / Elemento actual: 558   */
      v.add(doc.createTextNode("Glosa contable"));
      ((Element)v.get(557)).appendChild((Text)v.get(558));

      /* Termina nodo Texto:558   */
      /* Termina nodo:557   */

      /* Empieza nodo:559 / Elemento padre: 550   */
      v.add(doc.createElement("COL"));
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(559)).setAttribute("colFondo","" );
      ((Element)v.get(559)).setAttribute("ID","EstCab" );
      ((Element)v.get(559)).setAttribute("cod","642" );
      ((Element)v.get(550)).appendChild((Element)v.get(559));

      /* Elemento padre:559 / Elemento actual: 560   */
      v.add(doc.createTextNode("Divisa"));
      ((Element)v.get(559)).appendChild((Text)v.get(560));

      /* Termina nodo Texto:560   */
      /* Termina nodo:559   */

      /* Empieza nodo:561 / Elemento padre: 550   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(561)).setAttribute("colFondo","" );
      ((Element)v.get(561)).setAttribute("ID","EstCab" );
      ((Element)v.get(561)).setAttribute("cod","573" );
      ((Element)v.get(550)).appendChild((Element)v.get(561));

      /* Elemento padre:561 / Elemento actual: 562   */
      v.add(doc.createTextNode("Importe "));
      ((Element)v.get(561)).appendChild((Text)v.get(562));

      /* Termina nodo Texto:562   */
      /* Termina nodo:561   */

      /* Empieza nodo:563 / Elemento padre: 550   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(563)).setAttribute("colFondo","" );
      ((Element)v.get(563)).setAttribute("ID","EstCab" );
      ((Element)v.get(563)).setAttribute("cod","668" );
      ((Element)v.get(550)).appendChild((Element)v.get(563));

      /* Elemento padre:563 / Elemento actual: 564   */
      v.add(doc.createTextNode("Importe divisa"));
      ((Element)v.get(563)).appendChild((Text)v.get(564));

      /* Termina nodo Texto:564   */
      /* Termina nodo:563   */

      /* Empieza nodo:565 / Elemento padre: 550   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(565)).setAttribute("colFondo","" );
      ((Element)v.get(565)).setAttribute("ID","EstCab" );
      ((Element)v.get(550)).appendChild((Element)v.get(565));

      /* Elemento padre:565 / Elemento actual: 566   */
      v.add(doc.createTextNode("cuentaCorrienteOid"));
      ((Element)v.get(565)).appendChild((Text)v.get(566));

      /* Termina nodo Texto:566   */
      /* Termina nodo:565   */

      /* Empieza nodo:567 / Elemento padre: 550   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(567)).setAttribute("colFondo","" );
      ((Element)v.get(567)).setAttribute("ID","EstCab" );
      ((Element)v.get(550)).appendChild((Element)v.get(567));

      /* Elemento padre:567 / Elemento actual: 568   */
      v.add(doc.createTextNode("tipoAbonoOid"));
      ((Element)v.get(567)).appendChild((Text)v.get(568));

      /* Termina nodo Texto:568   */
      /* Termina nodo:567   */

      /* Empieza nodo:569 / Elemento padre: 550   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(569)).setAttribute("colFondo","" );
      ((Element)v.get(569)).setAttribute("ID","EstCab" );
      ((Element)v.get(550)).appendChild((Element)v.get(569));

      /* Elemento padre:569 / Elemento actual: 570   */
      v.add(doc.createTextNode("oidDetalle"));
      ((Element)v.get(569)).appendChild((Text)v.get(570));

      /* Termina nodo Texto:570   */
      /* Termina nodo:569   */
      /* Termina nodo:550   */

      /* Empieza nodo:571 / Elemento padre: 529   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(571)).setAttribute("alto","22" );
      ((Element)v.get(571)).setAttribute("accion","" );
      ((Element)v.get(571)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(571)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(571)).setAttribute("maxSel","-1" );
      ((Element)v.get(571)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(571)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(571)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(571)).setAttribute("onLoad","" );
      ((Element)v.get(571)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(529)).appendChild((Element)v.get(571));

      /* Empieza nodo:572 / Elemento padre: 571   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(572)).setAttribute("tipo","texto" );
      ((Element)v.get(572)).setAttribute("ID","EstDat" );
      ((Element)v.get(571)).appendChild((Element)v.get(572));
      /* Termina nodo:572   */

      /* Empieza nodo:573 / Elemento padre: 571   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(573)).setAttribute("tipo","texto" );
      ((Element)v.get(573)).setAttribute("ID","EstDat2" );
      ((Element)v.get(571)).appendChild((Element)v.get(573));
      /* Termina nodo:573   */

      /* Empieza nodo:574 / Elemento padre: 571   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(574)).setAttribute("tipo","texto" );
      ((Element)v.get(574)).setAttribute("ID","EstDat" );
      ((Element)v.get(571)).appendChild((Element)v.get(574));
      /* Termina nodo:574   */

      /* Empieza nodo:575 / Elemento padre: 571   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(575)).setAttribute("tipo","texto" );
      ((Element)v.get(575)).setAttribute("ID","EstDat2" );
      ((Element)v.get(571)).appendChild((Element)v.get(575));
      /* Termina nodo:575   */

      /* Empieza nodo:576 / Elemento padre: 571   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(576)).setAttribute("tipo","texto" );
      ((Element)v.get(576)).setAttribute("ID","EstDat" );
      ((Element)v.get(571)).appendChild((Element)v.get(576));
      /* Termina nodo:576   */

      /* Empieza nodo:577 / Elemento padre: 571   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(577)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(577)).setAttribute("nombre","Texto3" );
      ((Element)v.get(577)).setAttribute("size","18" );
      ((Element)v.get(577)).setAttribute("deshabilitado","N" );
      ((Element)v.get(577)).setAttribute("readonly","N" );
      ((Element)v.get(577)).setAttribute("max","18" );
      ((Element)v.get(577)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(577)).setAttribute("ID","EstDat2" );
      ((Element)v.get(577)).setAttribute("onTab","fot(FILAEVENTO, TECLAEVENTO);" );
      ((Element)v.get(577)).setAttribute("onShTab","focalizaAnteriorLista(FILAEVENTO, TECLAEVENTO)" );
      ((Element)v.get(577)).setAttribute("onBlur","importeConceptosOnBlur(FILAEVENTO);" );
      ((Element)v.get(577)).setAttribute("validacion","validaMonto(valor, 10)" );
      ((Element)v.get(571)).appendChild((Element)v.get(577));
      /* Termina nodo:577   */

      /* Empieza nodo:578 / Elemento padre: 571   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(578)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(578)).setAttribute("nombre","Texto4" );
      ((Element)v.get(578)).setAttribute("size","18" );
      ((Element)v.get(578)).setAttribute("deshabilitado","N" );
      ((Element)v.get(578)).setAttribute("readonly","N" );
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(578)).setAttribute("max","18" );
      ((Element)v.get(578)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(578)).setAttribute("ID","EstDat" );
      ((Element)v.get(578)).setAttribute("onTab","focalizaSiguienteLista(FILAEVENTO, TECLAEVENTO)" );
      ((Element)v.get(578)).setAttribute("onShTab","fot3(FILAEVENTO, TECLAEVENTO);" );
      ((Element)v.get(578)).setAttribute("onBlur","importeDivisaConceptosOnBlur(FILAEVENTO);" );
      ((Element)v.get(578)).setAttribute("validacion","validaMonto(valor, 10)" );
      ((Element)v.get(571)).appendChild((Element)v.get(578));
      /* Termina nodo:578   */

      /* Empieza nodo:579 / Elemento padre: 571   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(579)).setAttribute("tipo","texto" );
      ((Element)v.get(579)).setAttribute("ID","EstDat2" );
      ((Element)v.get(571)).appendChild((Element)v.get(579));
      /* Termina nodo:579   */

      /* Empieza nodo:580 / Elemento padre: 571   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(580)).setAttribute("tipo","texto" );
      ((Element)v.get(580)).setAttribute("ID","EstDat" );
      ((Element)v.get(571)).appendChild((Element)v.get(580));
      /* Termina nodo:580   */

      /* Empieza nodo:581 / Elemento padre: 571   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(581)).setAttribute("tipo","texto" );
      ((Element)v.get(581)).setAttribute("ID","EstDat2" );
      ((Element)v.get(571)).appendChild((Element)v.get(581));
      /* Termina nodo:581   */
      /* Termina nodo:571   */

      /* Empieza nodo:582 / Elemento padre: 529   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(529)).appendChild((Element)v.get(582));
      /* Termina nodo:582   */
      /* Termina nodo:529   */

      /* Empieza nodo:583 / Elemento padre: 20   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(583)).setAttribute("nombre","listado4" );
      ((Element)v.get(583)).setAttribute("ancho","742" );
      ((Element)v.get(583)).setAttribute("alto","317" );
      ((Element)v.get(583)).setAttribute("x","12" );
      ((Element)v.get(583)).setAttribute("y","489" );
      ((Element)v.get(583)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(583)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(20)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(584)).setAttribute("precarga","S" );
      ((Element)v.get(584)).setAttribute("conROver","S" );
      ((Element)v.get(583)).appendChild((Element)v.get(584));

      /* Empieza nodo:585 / Elemento padre: 584   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(585)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(585)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(585)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(585)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(584)).appendChild((Element)v.get(585));
      /* Termina nodo:585   */

      /* Empieza nodo:586 / Elemento padre: 584   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(586)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(586)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(586)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(586)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(584)).appendChild((Element)v.get(586));
      /* Termina nodo:586   */

      /* Empieza nodo:587 / Elemento padre: 584   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(587)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(587)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(584)).appendChild((Element)v.get(587));
      /* Termina nodo:587   */
      /* Termina nodo:584   */

      /* Empieza nodo:588 / Elemento padre: 583   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(583)).appendChild((Element)v.get(588));

      /* Empieza nodo:589 / Elemento padre: 588   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(589)).setAttribute("borde","1" );
      ((Element)v.get(589)).setAttribute("horizDatos","1" );
      ((Element)v.get(589)).setAttribute("horizCabecera","1" );
      ((Element)v.get(589)).setAttribute("vertical","1" );
      ((Element)v.get(589)).setAttribute("horizTitulo","1" );
      ((Element)v.get(589)).setAttribute("horizBase","1" );
      ((Element)v.get(588)).appendChild((Element)v.get(589));
      /* Termina nodo:589   */

      /* Empieza nodo:590 / Elemento padre: 588   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(590)).setAttribute("borde","#999999" );
      ((Element)v.get(590)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(590)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(590)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(590)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(590)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(590)).setAttribute("horizBase","#999999" );
      ((Element)v.get(588)).appendChild((Element)v.get(590));
      /* Termina nodo:590   */
      /* Termina nodo:588   */

      /* Empieza nodo:591 / Elemento padre: 583   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(591)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(591)).setAttribute("alto","22" );
      ((Element)v.get(591)).setAttribute("imgFondo","" );
      ((Element)v.get(591)).setAttribute("cod","0018" );
      ((Element)v.get(591)).setAttribute("ID","datosTitle" );
      ((Element)v.get(583)).appendChild((Element)v.get(591));
      /* Termina nodo:591   */

      /* Empieza nodo:592 / Elemento padre: 583   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(592)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(592)).setAttribute("alto","22" );
      ((Element)v.get(592)).setAttribute("imgFondo","" );
      ((Element)v.get(583)).appendChild((Element)v.get(592));
      /* Termina nodo:592   */

      /* Empieza nodo:593 / Elemento padre: 583   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(593)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(593)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(593)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(593)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(593)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(593)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(583)).appendChild((Element)v.get(593));

      /* Empieza nodo:594 / Elemento padre: 593   */
   }

   private void getXML2520(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(594)).setAttribute("ancho","120" );
      ((Element)v.get(594)).setAttribute("minimizable","S" );
      ((Element)v.get(594)).setAttribute("minimizada","N" );
      ((Element)v.get(593)).appendChild((Element)v.get(594));
      /* Termina nodo:594   */

      /* Empieza nodo:595 / Elemento padre: 593   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(595)).setAttribute("ancho","120" );
      ((Element)v.get(595)).setAttribute("minimizable","S" );
      ((Element)v.get(595)).setAttribute("minimizada","N" );
      ((Element)v.get(593)).appendChild((Element)v.get(595));
      /* Termina nodo:595   */

      /* Empieza nodo:596 / Elemento padre: 593   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(596)).setAttribute("ancho","120" );
      ((Element)v.get(596)).setAttribute("minimizable","S" );
      ((Element)v.get(596)).setAttribute("minimizada","N" );
      ((Element)v.get(596)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(593)).appendChild((Element)v.get(596));
      /* Termina nodo:596   */

      /* Empieza nodo:597 / Elemento padre: 593   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(597)).setAttribute("ancho","120" );
      ((Element)v.get(597)).setAttribute("minimizable","S" );
      ((Element)v.get(597)).setAttribute("minimizada","N" );
      ((Element)v.get(593)).appendChild((Element)v.get(597));
      /* Termina nodo:597   */

      /* Empieza nodo:598 / Elemento padre: 593   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(598)).setAttribute("ancho","120" );
      ((Element)v.get(598)).setAttribute("minimizable","S" );
      ((Element)v.get(598)).setAttribute("minimizada","N" );
      ((Element)v.get(593)).appendChild((Element)v.get(598));
      /* Termina nodo:598   */

      /* Empieza nodo:599 / Elemento padre: 593   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(599)).setAttribute("ancho","120" );
      ((Element)v.get(599)).setAttribute("minimizable","S" );
      ((Element)v.get(599)).setAttribute("minimizada","N" );
      ((Element)v.get(599)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(593)).appendChild((Element)v.get(599));
      /* Termina nodo:599   */

      /* Empieza nodo:600 / Elemento padre: 593   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(600)).setAttribute("ancho","120" );
      ((Element)v.get(600)).setAttribute("minimizable","S" );
      ((Element)v.get(600)).setAttribute("minimizada","N" );
      ((Element)v.get(593)).appendChild((Element)v.get(600));
      /* Termina nodo:600   */

      /* Empieza nodo:601 / Elemento padre: 593   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(601)).setAttribute("ancho","120" );
      ((Element)v.get(601)).setAttribute("minimizable","S" );
      ((Element)v.get(601)).setAttribute("minimizada","N" );
      ((Element)v.get(593)).appendChild((Element)v.get(601));
      /* Termina nodo:601   */

      /* Empieza nodo:602 / Elemento padre: 593   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(602)).setAttribute("ancho","120" );
      ((Element)v.get(602)).setAttribute("minimizable","S" );
      ((Element)v.get(602)).setAttribute("minimizada","N" );
      ((Element)v.get(602)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(593)).appendChild((Element)v.get(602));
      /* Termina nodo:602   */

      /* Empieza nodo:603 / Elemento padre: 593   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(603)).setAttribute("ancho","150" );
      ((Element)v.get(603)).setAttribute("minimizable","S" );
      ((Element)v.get(603)).setAttribute("minimizada","N" );
      ((Element)v.get(593)).appendChild((Element)v.get(603));
      /* Termina nodo:603   */

      /* Empieza nodo:604 / Elemento padre: 593   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(604)).setAttribute("ancho","120" );
      ((Element)v.get(604)).setAttribute("minimizable","S" );
      ((Element)v.get(604)).setAttribute("minimizada","N" );
      ((Element)v.get(593)).appendChild((Element)v.get(604));
      /* Termina nodo:604   */

      /* Empieza nodo:605 / Elemento padre: 593   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(605)).setAttribute("ancho","120" );
      ((Element)v.get(605)).setAttribute("minimizable","S" );
      ((Element)v.get(605)).setAttribute("minimizada","N" );
      ((Element)v.get(605)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(593)).appendChild((Element)v.get(605));
      /* Termina nodo:605   */

      /* Empieza nodo:606 / Elemento padre: 593   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(606)).setAttribute("ancho","120" );
      ((Element)v.get(606)).setAttribute("minimizable","S" );
      ((Element)v.get(606)).setAttribute("minimizada","N" );
      ((Element)v.get(593)).appendChild((Element)v.get(606));
      /* Termina nodo:606   */

      /* Empieza nodo:607 / Elemento padre: 593   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(607)).setAttribute("ancho","120" );
      ((Element)v.get(607)).setAttribute("minimizable","S" );
      ((Element)v.get(607)).setAttribute("minimizada","N" );
      ((Element)v.get(593)).appendChild((Element)v.get(607));
      /* Termina nodo:607   */

      /* Empieza nodo:608 / Elemento padre: 593   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(608)).setAttribute("ancho","100" );
      ((Element)v.get(608)).setAttribute("minimizable","S" );
      ((Element)v.get(608)).setAttribute("minimizada","N" );
      ((Element)v.get(608)).setAttribute("oculta","S" );
      ((Element)v.get(593)).appendChild((Element)v.get(608));
      /* Termina nodo:608   */

      /* Empieza nodo:609 / Elemento padre: 593   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(609)).setAttribute("ancho","100" );
      ((Element)v.get(609)).setAttribute("minimizable","S" );
      ((Element)v.get(609)).setAttribute("minimizada","N" );
      ((Element)v.get(609)).setAttribute("oculta","S" );
      ((Element)v.get(593)).appendChild((Element)v.get(609));
      /* Termina nodo:609   */

      /* Empieza nodo:610 / Elemento padre: 593   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(610)).setAttribute("ancho","100" );
      ((Element)v.get(610)).setAttribute("minimizable","S" );
      ((Element)v.get(610)).setAttribute("minimizada","N" );
   }

   private void getXML2610(Document doc) {
      ((Element)v.get(610)).setAttribute("oculta","S" );
      ((Element)v.get(593)).appendChild((Element)v.get(610));
      /* Termina nodo:610   */

      /* Empieza nodo:611 / Elemento padre: 593   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(611)).setAttribute("ancho","100" );
      ((Element)v.get(611)).setAttribute("minimizable","S" );
      ((Element)v.get(611)).setAttribute("minimizada","N" );
      ((Element)v.get(611)).setAttribute("oculta","S" );
      ((Element)v.get(593)).appendChild((Element)v.get(611));
      /* Termina nodo:611   */

      /* Empieza nodo:612 / Elemento padre: 593   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(612)).setAttribute("ancho","100" );
      ((Element)v.get(612)).setAttribute("minimizable","S" );
      ((Element)v.get(612)).setAttribute("minimizada","N" );
      ((Element)v.get(612)).setAttribute("oculta","S" );
      ((Element)v.get(593)).appendChild((Element)v.get(612));
      /* Termina nodo:612   */

      /* Empieza nodo:613 / Elemento padre: 593   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(613)).setAttribute("ancho","100" );
      ((Element)v.get(613)).setAttribute("minimizable","S" );
      ((Element)v.get(613)).setAttribute("minimizada","N" );
      ((Element)v.get(613)).setAttribute("oculta","S" );
      ((Element)v.get(593)).appendChild((Element)v.get(613));
      /* Termina nodo:613   */

      /* Empieza nodo:614 / Elemento padre: 593   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(614)).setAttribute("ancho","100" );
      ((Element)v.get(614)).setAttribute("minimizable","S" );
      ((Element)v.get(614)).setAttribute("minimizada","N" );
      ((Element)v.get(614)).setAttribute("oculta","S" );
      ((Element)v.get(593)).appendChild((Element)v.get(614));
      /* Termina nodo:614   */
      /* Termina nodo:593   */

      /* Empieza nodo:615 / Elemento padre: 583   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(615)).setAttribute("alto","20" );
      ((Element)v.get(615)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(615)).setAttribute("imgFondo","" );
      ((Element)v.get(615)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(583)).appendChild((Element)v.get(615));

      /* Empieza nodo:616 / Elemento padre: 615   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(616)).setAttribute("colFondo","" );
      ((Element)v.get(616)).setAttribute("ID","EstCab" );
      ((Element)v.get(616)).setAttribute("align","center" );
      ((Element)v.get(616)).setAttribute("cod","263" );
      ((Element)v.get(615)).appendChild((Element)v.get(616));

      /* Elemento padre:616 / Elemento actual: 617   */
      v.add(doc.createTextNode("Cód. cliente"));
      ((Element)v.get(616)).appendChild((Text)v.get(617));

      /* Termina nodo Texto:617   */
      /* Termina nodo:616   */

      /* Empieza nodo:618 / Elemento padre: 615   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(618)).setAttribute("colFondo","" );
      ((Element)v.get(618)).setAttribute("ID","EstCab" );
      ((Element)v.get(618)).setAttribute("align","center" );
      ((Element)v.get(618)).setAttribute("cod","6" );
      ((Element)v.get(615)).appendChild((Element)v.get(618));

      /* Elemento padre:618 / Elemento actual: 619   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(618)).appendChild((Text)v.get(619));

      /* Termina nodo Texto:619   */
      /* Termina nodo:618   */

      /* Empieza nodo:620 / Elemento padre: 615   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(620)).setAttribute("colFondo","" );
      ((Element)v.get(620)).setAttribute("ID","EstCab" );
      ((Element)v.get(620)).setAttribute("cod","7" );
      ((Element)v.get(615)).appendChild((Element)v.get(620));

      /* Elemento padre:620 / Elemento actual: 621   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(620)).appendChild((Text)v.get(621));

      /* Termina nodo Texto:621   */
      /* Termina nodo:620   */

      /* Empieza nodo:622 / Elemento padre: 615   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(622)).setAttribute("colFondo","" );
      ((Element)v.get(622)).setAttribute("ID","EstCab" );
      ((Element)v.get(622)).setAttribute("cod","10" );
      ((Element)v.get(615)).appendChild((Element)v.get(622));

      /* Elemento padre:622 / Elemento actual: 623   */
      v.add(doc.createTextNode("Acceso"));
      ((Element)v.get(622)).appendChild((Text)v.get(623));

      /* Termina nodo Texto:623   */
      /* Termina nodo:622   */

      /* Empieza nodo:624 / Elemento padre: 615   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(624)).setAttribute("colFondo","" );
      ((Element)v.get(624)).setAttribute("ID","EstCab" );
      ((Element)v.get(624)).setAttribute("cod","122" );
      ((Element)v.get(615)).appendChild((Element)v.get(624));

      /* Elemento padre:624 / Elemento actual: 625   */
      v.add(doc.createTextNode("Subacceso"));
      ((Element)v.get(624)).appendChild((Text)v.get(625));

      /* Termina nodo Texto:625   */
      /* Termina nodo:624   */

      /* Empieza nodo:626 / Elemento padre: 615   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(626)).setAttribute("colFondo","" );
      ((Element)v.get(626)).setAttribute("ID","EstCab" );
      ((Element)v.get(626)).setAttribute("cod","422" );
      ((Element)v.get(615)).appendChild((Element)v.get(626));

      /* Elemento padre:626 / Elemento actual: 627   */
      v.add(doc.createTextNode("Nº documento"));
      ((Element)v.get(626)).appendChild((Text)v.get(627));

      /* Termina nodo Texto:627   */
      /* Termina nodo:626   */

      /* Empieza nodo:628 / Elemento padre: 615   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(628)).setAttribute("colFondo","" );
      ((Element)v.get(628)).setAttribute("ID","EstCab" );
      ((Element)v.get(628)).setAttribute("cod","692" );
      ((Element)v.get(615)).appendChild((Element)v.get(628));

      /* Elemento padre:628 / Elemento actual: 629   */
      v.add(doc.createTextNode("Referencia externa"));
      ((Element)v.get(628)).appendChild((Text)v.get(629));

      /* Termina nodo Texto:629   */
      /* Termina nodo:628   */

      /* Empieza nodo:630 / Elemento padre: 615   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(630)).setAttribute("colFondo","" );
      ((Element)v.get(630)).setAttribute("ID","EstCab" );
      ((Element)v.get(630)).setAttribute("cod","656" );
      ((Element)v.get(615)).appendChild((Element)v.get(630));

      /* Elemento padre:630 / Elemento actual: 631   */
      v.add(doc.createTextNode("Fecha valor"));
      ((Element)v.get(630)).appendChild((Text)v.get(631));

      /* Termina nodo Texto:631   */
      /* Termina nodo:630   */

      /* Empieza nodo:632 / Elemento padre: 615   */
   }

   private void getXML2700(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(632)).setAttribute("colFondo","" );
      ((Element)v.get(632)).setAttribute("ID","EstCab" );
      ((Element)v.get(632)).setAttribute("cod","883" );
      ((Element)v.get(615)).appendChild((Element)v.get(632));

      /* Elemento padre:632 / Elemento actual: 633   */
      v.add(doc.createTextNode("Fecha vencimiento"));
      ((Element)v.get(632)).appendChild((Text)v.get(633));

      /* Termina nodo Texto:633   */
      /* Termina nodo:632   */

      /* Empieza nodo:634 / Elemento padre: 615   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(634)).setAttribute("colFondo","" );
      ((Element)v.get(634)).setAttribute("ID","EstCab" );
      ((Element)v.get(634)).setAttribute("cod","1225" );
      ((Element)v.get(615)).appendChild((Element)v.get(634));

      /* Elemento padre:634 / Elemento actual: 635   */
      v.add(doc.createTextNode("Medio pago teórico"));
      ((Element)v.get(634)).appendChild((Text)v.get(635));

      /* Termina nodo Texto:635   */
      /* Termina nodo:634   */

      /* Empieza nodo:636 / Elemento padre: 615   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(636)).setAttribute("colFondo","" );
      ((Element)v.get(636)).setAttribute("ID","EstCab" );
      ((Element)v.get(636)).setAttribute("cod","642" );
      ((Element)v.get(615)).appendChild((Element)v.get(636));

      /* Elemento padre:636 / Elemento actual: 637   */
      v.add(doc.createTextNode("Divisa"));
      ((Element)v.get(636)).appendChild((Text)v.get(637));

      /* Termina nodo Texto:637   */
      /* Termina nodo:636   */

      /* Empieza nodo:638 / Elemento padre: 615   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(638)).setAttribute("colFondo","" );
      ((Element)v.get(638)).setAttribute("ID","EstCab" );
      ((Element)v.get(638)).setAttribute("cod","573" );
      ((Element)v.get(615)).appendChild((Element)v.get(638));

      /* Elemento padre:638 / Elemento actual: 639   */
      v.add(doc.createTextNode("Importe"));
      ((Element)v.get(638)).appendChild((Text)v.get(639));

      /* Termina nodo Texto:639   */
      /* Termina nodo:638   */

      /* Empieza nodo:640 / Elemento padre: 615   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(640)).setAttribute("colFondo","" );
      ((Element)v.get(640)).setAttribute("ID","EstCab" );
      ((Element)v.get(640)).setAttribute("cod","668" );
      ((Element)v.get(615)).appendChild((Element)v.get(640));

      /* Elemento padre:640 / Elemento actual: 641   */
      v.add(doc.createTextNode("Importe divisa"));
      ((Element)v.get(640)).appendChild((Text)v.get(641));

      /* Termina nodo Texto:641   */
      /* Termina nodo:640   */

      /* Empieza nodo:642 / Elemento padre: 615   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(642)).setAttribute("colFondo","" );
      ((Element)v.get(642)).setAttribute("ID","EstCab" );
      ((Element)v.get(642)).setAttribute("align","center" );
      ((Element)v.get(642)).setAttribute("cod","169" );
      ((Element)v.get(615)).appendChild((Element)v.get(642));

      /* Elemento padre:642 / Elemento actual: 643   */
      v.add(doc.createTextNode("Observaciones"));
      ((Element)v.get(642)).appendChild((Text)v.get(643));

      /* Termina nodo Texto:643   */
      /* Termina nodo:642   */

      /* Empieza nodo:644 / Elemento padre: 615   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(644)).setAttribute("colFondo","" );
      ((Element)v.get(644)).setAttribute("ID","EstCab" );
      ((Element)v.get(615)).appendChild((Element)v.get(644));

      /* Elemento padre:644 / Elemento actual: 645   */
      v.add(doc.createTextNode("medioPagoOid"));
      ((Element)v.get(644)).appendChild((Text)v.get(645));

      /* Termina nodo Texto:645   */
      /* Termina nodo:644   */

      /* Empieza nodo:646 / Elemento padre: 615   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(646)).setAttribute("colFondo","" );
      ((Element)v.get(646)).setAttribute("ID","EstCab" );
      ((Element)v.get(615)).appendChild((Element)v.get(646));

      /* Elemento padre:646 / Elemento actual: 647   */
      v.add(doc.createTextNode("marcaOid"));
      ((Element)v.get(646)).appendChild((Text)v.get(647));

      /* Termina nodo Texto:647   */
      /* Termina nodo:646   */

      /* Empieza nodo:648 / Elemento padre: 615   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(648)).setAttribute("colFondo","" );
      ((Element)v.get(648)).setAttribute("ID","EstCab" );
      ((Element)v.get(615)).appendChild((Element)v.get(648));

      /* Elemento padre:648 / Elemento actual: 649   */
      v.add(doc.createTextNode("canalOid"));
      ((Element)v.get(648)).appendChild((Text)v.get(649));

      /* Termina nodo Texto:649   */
      /* Termina nodo:648   */

      /* Empieza nodo:650 / Elemento padre: 615   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(650)).setAttribute("colFondo","" );
      ((Element)v.get(650)).setAttribute("ID","EstCab" );
      ((Element)v.get(615)).appendChild((Element)v.get(650));

      /* Elemento padre:650 / Elemento actual: 651   */
      v.add(doc.createTextNode("accesoOid"));
      ((Element)v.get(650)).appendChild((Text)v.get(651));

      /* Termina nodo Texto:651   */
      /* Termina nodo:650   */

      /* Empieza nodo:652 / Elemento padre: 615   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(652)).setAttribute("colFondo","" );
      ((Element)v.get(652)).setAttribute("ID","EstCab" );
      ((Element)v.get(615)).appendChild((Element)v.get(652));

      /* Elemento padre:652 / Elemento actual: 653   */
      v.add(doc.createTextNode("subaccesoOid"));
      ((Element)v.get(652)).appendChild((Text)v.get(653));

      /* Termina nodo Texto:653   */
      /* Termina nodo:652   */

      /* Empieza nodo:654 / Elemento padre: 615   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(654)).setAttribute("colFondo","" );
      ((Element)v.get(654)).setAttribute("ID","EstCab" );
      ((Element)v.get(615)).appendChild((Element)v.get(654));

      /* Elemento padre:654 / Elemento actual: 655   */
      v.add(doc.createTextNode("oidMovimiento"));
      ((Element)v.get(654)).appendChild((Text)v.get(655));

      /* Termina nodo Texto:655   */
      /* Termina nodo:654   */

      /* Empieza nodo:656 / Elemento padre: 615   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(656)).setAttribute("colFondo","" );
      ((Element)v.get(656)).setAttribute("ID","EstCab" );
      ((Element)v.get(615)).appendChild((Element)v.get(656));

      /* Elemento padre:656 / Elemento actual: 657   */
      v.add(doc.createTextNode("oidDetalle"));
      ((Element)v.get(656)).appendChild((Text)v.get(657));

      /* Termina nodo Texto:657   */
      /* Termina nodo:656   */
      /* Termina nodo:615   */

      /* Empieza nodo:658 / Elemento padre: 583   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(658)).setAttribute("alto","22" );
      ((Element)v.get(658)).setAttribute("accion","" );
      ((Element)v.get(658)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(658)).setAttribute("formaEnvio","xml" );
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(658)).setAttribute("maxSel","-1" );
      ((Element)v.get(658)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(658)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(658)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(658)).setAttribute("onLoad","" );
      ((Element)v.get(658)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(583)).appendChild((Element)v.get(658));

      /* Empieza nodo:659 / Elemento padre: 658   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(659)).setAttribute("tipo","texto" );
      ((Element)v.get(659)).setAttribute("ID","EstDat" );
      ((Element)v.get(658)).appendChild((Element)v.get(659));
      /* Termina nodo:659   */

      /* Empieza nodo:660 / Elemento padre: 658   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(660)).setAttribute("tipo","texto" );
      ((Element)v.get(660)).setAttribute("ID","EstDat2" );
      ((Element)v.get(658)).appendChild((Element)v.get(660));
      /* Termina nodo:660   */

      /* Empieza nodo:661 / Elemento padre: 658   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(661)).setAttribute("tipo","texto" );
      ((Element)v.get(661)).setAttribute("ID","EstDat" );
      ((Element)v.get(658)).appendChild((Element)v.get(661));
      /* Termina nodo:661   */

      /* Empieza nodo:662 / Elemento padre: 658   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(662)).setAttribute("tipo","texto" );
      ((Element)v.get(662)).setAttribute("ID","EstDat2" );
      ((Element)v.get(658)).appendChild((Element)v.get(662));
      /* Termina nodo:662   */

      /* Empieza nodo:663 / Elemento padre: 658   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(663)).setAttribute("tipo","texto" );
      ((Element)v.get(663)).setAttribute("ID","EstDat" );
      ((Element)v.get(658)).appendChild((Element)v.get(663));
      /* Termina nodo:663   */

      /* Empieza nodo:664 / Elemento padre: 658   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(664)).setAttribute("tipo","texto" );
      ((Element)v.get(664)).setAttribute("ID","EstDat2" );
      ((Element)v.get(658)).appendChild((Element)v.get(664));
      /* Termina nodo:664   */

      /* Empieza nodo:665 / Elemento padre: 658   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(665)).setAttribute("tipo","texto" );
      ((Element)v.get(665)).setAttribute("ID","EstDat" );
      ((Element)v.get(658)).appendChild((Element)v.get(665));
      /* Termina nodo:665   */

      /* Empieza nodo:666 / Elemento padre: 658   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(666)).setAttribute("tipo","texto" );
      ((Element)v.get(666)).setAttribute("ID","EstDat2" );
      ((Element)v.get(658)).appendChild((Element)v.get(666));
      /* Termina nodo:666   */

      /* Empieza nodo:667 / Elemento padre: 658   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(667)).setAttribute("tipo","texto" );
      ((Element)v.get(667)).setAttribute("ID","EstDat" );
      ((Element)v.get(658)).appendChild((Element)v.get(667));
      /* Termina nodo:667   */

      /* Empieza nodo:668 / Elemento padre: 658   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(668)).setAttribute("tipo","texto" );
      ((Element)v.get(668)).setAttribute("ID","EstDat2" );
      ((Element)v.get(658)).appendChild((Element)v.get(668));
      /* Termina nodo:668   */

      /* Empieza nodo:669 / Elemento padre: 658   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(669)).setAttribute("tipo","texto" );
      ((Element)v.get(669)).setAttribute("ID","EstDat" );
      ((Element)v.get(658)).appendChild((Element)v.get(669));
      /* Termina nodo:669   */

      /* Empieza nodo:670 / Elemento padre: 658   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(670)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(670)).setAttribute("nombre","Texto5" );
      ((Element)v.get(670)).setAttribute("deshabilitado","N" );
      ((Element)v.get(670)).setAttribute("size","18" );
      ((Element)v.get(670)).setAttribute("max","18" );
      ((Element)v.get(670)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(670)).setAttribute("ID","EstDat2" );
      ((Element)v.get(670)).setAttribute("onTab","fot2(FILAEVENTO, TECLAEVENTO);" );
      ((Element)v.get(670)).setAttribute("onShTab","focalizaAnteriorLista(FILAEVENTO, TECLAEVENTO)" );
      ((Element)v.get(670)).setAttribute("onBlur","importeVencimientosOnBlur(FILAEVENTO);" );
      ((Element)v.get(670)).setAttribute("validacion","validaMonto(valor, 10)" );
      ((Element)v.get(658)).appendChild((Element)v.get(670));
      /* Termina nodo:670   */

      /* Empieza nodo:671 / Elemento padre: 658   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(671)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(671)).setAttribute("nombre","Texto6" );
      ((Element)v.get(671)).setAttribute("deshabilitado","N" );
      ((Element)v.get(671)).setAttribute("size","18" );
      ((Element)v.get(671)).setAttribute("max","18" );
      ((Element)v.get(671)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(671)).setAttribute("ID","EstDat" );
      ((Element)v.get(671)).setAttribute("onTab","focalizaSiguienteLista(FILAEVENTO, TECLAEVENTO)" );
      ((Element)v.get(671)).setAttribute("onShTab","fot4(FILAEVENTO, TECLAEVENTO);" );
      ((Element)v.get(671)).setAttribute("onBlur","importeDivisaVencimientosOnBlur(FILAEVENTO);" );
      ((Element)v.get(671)).setAttribute("validacion","validaMonto(valor, 10)" );
      ((Element)v.get(658)).appendChild((Element)v.get(671));
      /* Termina nodo:671   */

      /* Empieza nodo:672 / Elemento padre: 658   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(672)).setAttribute("tipo","texto" );
      ((Element)v.get(672)).setAttribute("ID","EstDat2" );
      ((Element)v.get(658)).appendChild((Element)v.get(672));
      /* Termina nodo:672   */

      /* Empieza nodo:673 / Elemento padre: 658   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(673)).setAttribute("tipo","texto" );
      ((Element)v.get(673)).setAttribute("ID","EstDat" );
      ((Element)v.get(658)).appendChild((Element)v.get(673));
      /* Termina nodo:673   */

      /* Empieza nodo:674 / Elemento padre: 658   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(674)).setAttribute("tipo","texto" );
      ((Element)v.get(674)).setAttribute("ID","EstDat2" );
      ((Element)v.get(658)).appendChild((Element)v.get(674));
      /* Termina nodo:674   */

      /* Empieza nodo:675 / Elemento padre: 658   */
      v.add(doc.createElement("COL"));
   }

   private void getXML2880(Document doc) {
      ((Element)v.get(675)).setAttribute("tipo","texto" );
      ((Element)v.get(675)).setAttribute("ID","EstDat" );
      ((Element)v.get(658)).appendChild((Element)v.get(675));
      /* Termina nodo:675   */

      /* Empieza nodo:676 / Elemento padre: 658   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(676)).setAttribute("tipo","texto" );
      ((Element)v.get(676)).setAttribute("ID","EstDat2" );
      ((Element)v.get(658)).appendChild((Element)v.get(676));
      /* Termina nodo:676   */

      /* Empieza nodo:677 / Elemento padre: 658   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(677)).setAttribute("tipo","texto" );
      ((Element)v.get(677)).setAttribute("ID","EstDat" );
      ((Element)v.get(658)).appendChild((Element)v.get(677));
      /* Termina nodo:677   */

      /* Empieza nodo:678 / Elemento padre: 658   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(678)).setAttribute("tipo","texto" );
      ((Element)v.get(678)).setAttribute("ID","EstDat2" );
      ((Element)v.get(658)).appendChild((Element)v.get(678));
      /* Termina nodo:678   */

      /* Empieza nodo:679 / Elemento padre: 658   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(679)).setAttribute("tipo","texto" );
      ((Element)v.get(679)).setAttribute("ID","EstDat" );
      ((Element)v.get(658)).appendChild((Element)v.get(679));
      /* Termina nodo:679   */
      /* Termina nodo:658   */

      /* Empieza nodo:680 / Elemento padre: 583   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(583)).appendChild((Element)v.get(680));
      /* Termina nodo:680   */
      /* Termina nodo:583   */

      /* Empieza nodo:681 / Elemento padre: 20   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(681)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(681)).setAttribute("alto","12" );
      ((Element)v.get(681)).setAttribute("ancho","100%" );
      ((Element)v.get(681)).setAttribute("colorf","" );
      ((Element)v.get(681)).setAttribute("borde","0" );
      ((Element)v.get(681)).setAttribute("imagenf","" );
      ((Element)v.get(681)).setAttribute("repeat","" );
      ((Element)v.get(681)).setAttribute("padding","" );
      ((Element)v.get(681)).setAttribute("visibilidad","visible" );
      ((Element)v.get(681)).setAttribute("contravsb","" );
      ((Element)v.get(681)).setAttribute("x","0" );
      ((Element)v.get(681)).setAttribute("y","766" );
      ((Element)v.get(681)).setAttribute("zindex","" );
      ((Element)v.get(20)).appendChild((Element)v.get(681));
      /* Termina nodo:681   */
      /* Termina nodo:20   */

      /* Empieza nodo:682 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(682)).setAttribute("nombre","frmContenidoEnvia" );
      ((Element)v.get(682)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(682));

      /* Empieza nodo:683 / Elemento padre: 682   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(683)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(683)).setAttribute("valor","" );
      ((Element)v.get(682)).appendChild((Element)v.get(683));
      /* Termina nodo:683   */

      /* Empieza nodo:684 / Elemento padre: 682   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(684)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(684)).setAttribute("valor","" );
      ((Element)v.get(682)).appendChild((Element)v.get(684));
      /* Termina nodo:684   */

      /* Empieza nodo:685 / Elemento padre: 682   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(685)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(685)).setAttribute("valor","" );
      ((Element)v.get(682)).appendChild((Element)v.get(685));
      /* Termina nodo:685   */
      /* Termina nodo:682   */


   }

}

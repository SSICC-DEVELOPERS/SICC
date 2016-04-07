
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_pagos_reasignar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_pagos_reasignar" );
      ((Element)v.get(0)).setAttribute("cod","01076" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("STYLE"));
      ((Element)v.get(1)).setAttribute("TYPE","text/css" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode("\r   \r\r\r#ret1Div {visibility:hidden;}\r#ava1Div {visibility:hidden;}\r#primera1Div {visibility:hidden;}\r#separa1Div {visibility:hidden;}\r#Cplistado1{visibility:hidden;}\r#CpLin1listado1{visibility:hidden;}\r#CpLin2listado1{visibility:hidden;}\r#CpLin3listado1{visibility:hidden;}\r#CpLin4listado1{visibility:hidden;}\r\r#ConfirmarDiv{visibility:hidden;}\r#DetalleDiv{visibility:hidden;}\r#ConsultaDiv{visibility:hidden;}\r\r   \r"));
      ((Element)v.get(1)).appendChild((Text)v.get(2));

      /* Termina nodo Texto:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(6)).setAttribute("src","contenido_pagos_reasignar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(7)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","FechaMov" );
      ((Element)v.get(9)).setAttribute("required","false" );
      ((Element)v.get(9)).setAttribute("format","F" );
      ((Element)v.get(9)).setAttribute("cod","651" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","NLote" );
      ((Element)v.get(10)).setAttribute("required","false" );
      ((Element)v.get(10)).setAttribute("format","N" );
      ((Element)v.get(10)).setAttribute("min","1" );
      ((Element)v.get(10)).setAttribute("max","999999999999" );
      ((Element)v.get(10)).setAttribute("cod","680" );
      ((Element)v.get(8)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","consecutivoTransaccion" );
      ((Element)v.get(11)).setAttribute("required","false" );
      ((Element)v.get(11)).setAttribute("format","N" );
      ((Element)v.get(11)).setAttribute("min","1" );
      ((Element)v.get(11)).setAttribute("max","9999999999" );
      ((Element)v.get(11)).setAttribute("cod","634" );
      ((Element)v.get(8)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","codigoCliente" );
      ((Element)v.get(12)).setAttribute("required","false" );
      ((Element)v.get(12)).setAttribute("format","N" );
      ((Element)v.get(12)).setAttribute("cod","263" );
      ((Element)v.get(8)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","nroCupon" );
      ((Element)v.get(13)).setAttribute("required","false" );
      ((Element)v.get(13)).setAttribute("format","N" );
      ((Element)v.get(13)).setAttribute("min","1" );
      ((Element)v.get(13)).setAttribute("max","999999999999" );
      ((Element)v.get(13)).setAttribute("cod","675" );
      ((Element)v.get(8)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","nroBoletaFactura" );
      ((Element)v.get(14)).setAttribute("required","false" );
      ((Element)v.get(14)).setAttribute("format","N" );
      ((Element)v.get(14)).setAttribute("min","1" );
      ((Element)v.get(14)).setAttribute("max","9999999999" );
      ((Element)v.get(14)).setAttribute("cod","2004" );
      ((Element)v.get(8)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(15)).setAttribute("name","importeDesde" );
      ((Element)v.get(15)).setAttribute("required","false" );
      ((Element)v.get(15)).setAttribute("format","M" );
      ((Element)v.get(15)).setAttribute("cod","01074" );
      ((Element)v.get(8)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 8   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(16)).setAttribute("name","importeHasta" );
      ((Element)v.get(16)).setAttribute("required","false" );
      ((Element)v.get(16)).setAttribute("format","M" );
      ((Element)v.get(16)).setAttribute("cod","01075" );
      ((Element)v.get(8)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */
      /* Termina nodo:8   */
      /* Termina nodo:7   */

      /* Empieza nodo:17 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(17)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(17)).setAttribute("oculto","S" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(0)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","errSeverity" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","accion" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","idioma" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","pais" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","oidCliente" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","oidMovimiento" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 17   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","longitudCodigo" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(17)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 17   */
      v.add(doc.createElement("table"));
      ((Element)v.get(28)).setAttribute("width","100%" );
      ((Element)v.get(28)).setAttribute("border","0" );
      ((Element)v.get(28)).setAttribute("cellspacing","0" );
      ((Element)v.get(28)).setAttribute("cellpadding","0" );
      ((Element)v.get(17)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(30)).setAttribute("width","12" );
      ((Element)v.get(30)).setAttribute("align","center" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(31)).setAttribute("src","b.gif" );
      ((Element)v.get(31)).setAttribute("width","12" );
      ((Element)v.get(31)).setAttribute("height","12" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:32 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).setAttribute("width","750" );
      ((Element)v.get(29)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(33)).setAttribute("src","b.gif" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:34 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).setAttribute("width","12" );
      ((Element)v.get(29)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(35)).setAttribute("src","b.gif" );
      ((Element)v.get(35)).setAttribute("width","12" );
      ((Element)v.get(35)).setAttribute("height","1" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */
      /* Termina nodo:29   */

      /* Empieza nodo:36 / Elemento padre: 28   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(28)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(38)).setAttribute("src","b.gif" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:39 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(41)).setAttribute("class","legend" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(42)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(42)).setAttribute("alto","13" );
      ((Element)v.get(42)).setAttribute("filas","1" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(42)).setAttribute("id","legend" );
      ((Element)v.get(42)).setAttribute("cod","0075" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:43 / Elemento padre: 40   */
      v.add(doc.createElement("table"));
      ((Element)v.get(43)).setAttribute("width","100%" );
      ((Element)v.get(43)).setAttribute("border","0" );
      ((Element)v.get(43)).setAttribute("align","center" );
      ((Element)v.get(43)).setAttribute("cellspacing","0" );
      ((Element)v.get(43)).setAttribute("cellpadding","0" );
      ((Element)v.get(40)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("table"));
      ((Element)v.get(46)).setAttribute("width","693" );
      ((Element)v.get(46)).setAttribute("border","0" );
      ((Element)v.get(46)).setAttribute("align","left" );
      ((Element)v.get(46)).setAttribute("cellspacing","0" );
      ((Element)v.get(46)).setAttribute("cellpadding","0" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).setAttribute("colspan","4" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","8" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:50 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(52)).setAttribute("src","b.gif" );
      ((Element)v.get(52)).setAttribute("width","8" );
      ((Element)v.get(52)).setAttribute("height","8" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(54)).setAttribute("nombre","lblBanco" );
      ((Element)v.get(54)).setAttribute("alto","13" );
      ((Element)v.get(54)).setAttribute("filas","1" );
      ((Element)v.get(54)).setAttribute("id","datosTitle" );
      ((Element)v.get(54)).setAttribute("cod","617" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","25" );
      ((Element)v.get(56)).setAttribute("height","8" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(58)).setAttribute("nombre","lblCCC" );
      ((Element)v.get(58)).setAttribute("alto","13" );
      ((Element)v.get(58)).setAttribute("filas","1" );
      ((Element)v.get(58)).setAttribute("id","datosTitle" );
      ((Element)v.get(58)).setAttribute("cod","636" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","25" );
      ((Element)v.get(60)).setAttribute("height","8" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(62)).setAttribute("nombre","lblFechaMov" );
      ((Element)v.get(62)).setAttribute("alto","13" );
      ((Element)v.get(62)).setAttribute("filas","1" );
      ((Element)v.get(62)).setAttribute("id","datosTitle" );
      ((Element)v.get(62)).setAttribute("cod","651" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","8" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(50)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(66)).setAttribute("nombre","lblNlote" );
      ((Element)v.get(66)).setAttribute("alto","13" );
      ((Element)v.get(66)).setAttribute("filas","1" );
      ((Element)v.get(66)).setAttribute("id","datosTitle" );
      ((Element)v.get(66)).setAttribute("cod","680" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).setAttribute("width","100%" );
      ((Element)v.get(50)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","8" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:50   */

      /* Empieza nodo:69 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(69));

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
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(73)).setAttribute("nombre","cbBanco" );
      ((Element)v.get(73)).setAttribute("size","1" );
      ((Element)v.get(73)).setAttribute("multiple","N" );
      ((Element)v.get(73)).setAttribute("onshtab","focalizaPagina('Confirmar');" );
      ((Element)v.get(73)).setAttribute("onchange","bancoOnChange();" );
      ((Element)v.get(73)).setAttribute("valorinicial","" );
      ((Element)v.get(73)).setAttribute("textoinicial","" );
      ((Element)v.get(73)).setAttribute("id","datosCampos" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:75 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","25" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(78)).setAttribute("nombre","cbCCC" );
      ((Element)v.get(78)).setAttribute("size","1" );
      ((Element)v.get(78)).setAttribute("multiple","N" );
      ((Element)v.get(78)).setAttribute("valorinicial","" );
      ((Element)v.get(78)).setAttribute("textoinicial","" );
      ((Element)v.get(78)).setAttribute("id","datosCampos" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:80 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).setAttribute("width","25" );
      ((Element)v.get(81)).setAttribute("height","8" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(83)).setAttribute("nombre","FechaMov" );
      ((Element)v.get(83)).setAttribute("id","datosCampos" );
      ((Element)v.get(83)).setAttribute("max","10" );
      ((Element)v.get(83)).setAttribute("tipo","" );
      ((Element)v.get(83)).setAttribute("req","N" );
      ((Element)v.get(83)).setAttribute("size","12" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(83)).setAttribute("validacion","" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","25" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(87)).setAttribute("nombre","NLote" );
      ((Element)v.get(87)).setAttribute("id","datosCampos" );
      ((Element)v.get(87)).setAttribute("max","12" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(87)).setAttribute("tipo","" );
      ((Element)v.get(87)).setAttribute("req","N" );
      ((Element)v.get(87)).setAttribute("size","16" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(87)).setAttribute("validacion","" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("width","100%" );
      ((Element)v.get(69)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","8" );
      ((Element)v.get(89)).setAttribute("height","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:69   */

      /* Empieza nodo:90 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("colspan","4" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","8" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:46   */
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:93 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("table"));
      ((Element)v.get(95)).setAttribute("width","693" );
      ((Element)v.get(95)).setAttribute("border","0" );
      ((Element)v.get(95)).setAttribute("align","left" );
      ((Element)v.get(95)).setAttribute("cellspacing","0" );
      ((Element)v.get(95)).setAttribute("cellpadding","0" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).setAttribute("width","8" );
      ((Element)v.get(98)).setAttribute("height","8" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(100)).setAttribute("nombre","lblConsecutivo" );
      ((Element)v.get(100)).setAttribute("alto","13" );
      ((Element)v.get(100)).setAttribute("filas","1" );
      ((Element)v.get(100)).setAttribute("id","datosTitle" );
      ((Element)v.get(100)).setAttribute("cod","634" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).setAttribute("width","8" );
      ((Element)v.get(102)).setAttribute("height","8" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(104)).setAttribute("nombre","lblcodigoCliente" );
      ((Element)v.get(104)).setAttribute("alto","13" );
      ((Element)v.get(104)).setAttribute("filas","1" );
      ((Element)v.get(104)).setAttribute("id","datosTitle" );
      ((Element)v.get(104)).setAttribute("cod","263" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","8" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","8" );
      ((Element)v.get(108)).setAttribute("height","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","8" );
      ((Element)v.get(110)).setAttribute("height","8" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 96   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(112)).setAttribute("nombre","lblRegion" );
      ((Element)v.get(112)).setAttribute("alto","13" );
      ((Element)v.get(112)).setAttribute("filas","1" );
      ((Element)v.get(112)).setAttribute("id","datosTitle" );
      ((Element)v.get(112)).setAttribute("cod","109" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","8" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(116)).setAttribute("nombre","lblZona" );
      ((Element)v.get(116)).setAttribute("alto","13" );
      ((Element)v.get(116)).setAttribute("filas","1" );
      ((Element)v.get(116)).setAttribute("id","datosTitle" );
      ((Element)v.get(116)).setAttribute("cod","00233" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).setAttribute("width","100%" );
      ((Element)v.get(96)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","8" );
      ((Element)v.get(118)).setAttribute("height","8" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:96   */

      /* Empieza nodo:119 / Elemento padre: 95   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(95)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","8" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(123)).setAttribute("nombre","consecutivoTransaccion" );
      ((Element)v.get(123)).setAttribute("id","datosCampos" );
      ((Element)v.get(123)).setAttribute("max","10" );
      ((Element)v.get(123)).setAttribute("tipo","" );
      ((Element)v.get(123)).setAttribute("onblur","" );
      ((Element)v.get(123)).setAttribute("req","N" );
      ((Element)v.get(123)).setAttribute("size","12" );
      ((Element)v.get(123)).setAttribute("valor","" );
      ((Element)v.get(123)).setAttribute("validacion","" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).setAttribute("width","8" );
      ((Element)v.get(125)).setAttribute("height","8" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:126 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(127)).setAttribute("nombre","codigoCliente" );
      ((Element)v.get(127)).setAttribute("id","datosCampos" );
      ((Element)v.get(127)).setAttribute("max","12" );
      ((Element)v.get(127)).setAttribute("tipo","" );
      ((Element)v.get(127)).setAttribute("onblur","" );
      ((Element)v.get(127)).setAttribute("req","N" );
      ((Element)v.get(127)).setAttribute("size","13" );
      ((Element)v.get(127)).setAttribute("valor","" );
      ((Element)v.get(127)).setAttribute("validacion","" );
      ((Element)v.get(127)).setAttribute("onchange","completarCodigoCliente();" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:128 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","8" );
      ((Element)v.get(129)).setAttribute("height","8" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(131)).setAttribute("src","iconBuscar.gif" );
      ((Element)v.get(131)).setAttribute("onclick","buscarCliente();" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(119)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","8" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(135)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(135)).setAttribute("size","1" );
      ((Element)v.get(135)).setAttribute("multiple","N" );
      ((Element)v.get(135)).setAttribute("valorinicial","" );
      ((Element)v.get(135)).setAttribute("textoinicial","" );
      ((Element)v.get(135)).setAttribute("id","datosCampos" );
      ((Element)v.get(135)).setAttribute("onchange","regionOnChange();" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:137 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","8" );
      ((Element)v.get(138)).setAttribute("height","8" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(140)).setAttribute("nombre","cbZona" );
      ((Element)v.get(140)).setAttribute("size","1" );
      ((Element)v.get(140)).setAttribute("multiple","N" );
      ((Element)v.get(140)).setAttribute("valorinicial","" );
      ((Element)v.get(140)).setAttribute("textoinicial","" );
      ((Element)v.get(140)).setAttribute("id","datosCampos" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:142 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).setAttribute("width","100%" );
      ((Element)v.get(119)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
      ((Element)v.get(143)).setAttribute("width","8" );
      ((Element)v.get(143)).setAttribute("height","8" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:119   */

      /* Empieza nodo:144 / Elemento padre: 95   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(95)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).setAttribute("colspan","4" );
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
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:147 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("table"));
      ((Element)v.get(149)).setAttribute("width","693" );
      ((Element)v.get(149)).setAttribute("border","0" );
      ((Element)v.get(149)).setAttribute("align","left" );
      ((Element)v.get(149)).setAttribute("cellspacing","0" );
      ((Element)v.get(149)).setAttribute("cellpadding","0" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).setAttribute("width","8" );
      ((Element)v.get(152)).setAttribute("height","8" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:153 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(154)).setAttribute("nombre","lblNroCupon" );
      ((Element)v.get(154)).setAttribute("alto","13" );
      ((Element)v.get(154)).setAttribute("filas","1" );
      ((Element)v.get(154)).setAttribute("id","datosTitle" );
      ((Element)v.get(154)).setAttribute("cod","675" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","8" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(158)).setAttribute("nombre","lblNroBoletaFactura" );
      ((Element)v.get(158)).setAttribute("alto","13" );
      ((Element)v.get(158)).setAttribute("filas","1" );
      ((Element)v.get(158)).setAttribute("id","datosTitle" );
      ((Element)v.get(158)).setAttribute("cod","2004" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).setAttribute("width","8" );
      ((Element)v.get(160)).setAttribute("height","8" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(162)).setAttribute("nombre","lblImporteDesde" );
      ((Element)v.get(162)).setAttribute("alto","13" );
      ((Element)v.get(162)).setAttribute("filas","1" );
      ((Element)v.get(162)).setAttribute("id","datosTitle" );
      ((Element)v.get(162)).setAttribute("cod","01074" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","8" );
      ((Element)v.get(164)).setAttribute("height","8" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(166)).setAttribute("nombre","lblImporteHasta" );
      ((Element)v.get(166)).setAttribute("alto","13" );
      ((Element)v.get(166)).setAttribute("filas","1" );
      ((Element)v.get(166)).setAttribute("id","datosTitle" );
      ((Element)v.get(166)).setAttribute("cod","01075" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).setAttribute("width","100%" );
      ((Element)v.get(150)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","8" );
      ((Element)v.get(168)).setAttribute("height","8" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */
      /* Termina nodo:150   */

      /* Empieza nodo:169 / Elemento padre: 149   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(149)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(171)).setAttribute("src","b.gif" );
      ((Element)v.get(171)).setAttribute("width","8" );
      ((Element)v.get(171)).setAttribute("height","8" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:172 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(173)).setAttribute("nombre","nroCupon" );
      ((Element)v.get(173)).setAttribute("id","datosCampos" );
      ((Element)v.get(173)).setAttribute("max","12" );
      ((Element)v.get(173)).setAttribute("tipo","" );
      ((Element)v.get(173)).setAttribute("onblur","" );
      ((Element)v.get(173)).setAttribute("req","N" );
      ((Element)v.get(173)).setAttribute("size","13" );
      ((Element)v.get(173)).setAttribute("valor","" );
      ((Element)v.get(173)).setAttribute("validacion","" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:174 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(175)).setAttribute("src","b.gif" );
      ((Element)v.get(175)).setAttribute("width","8" );
      ((Element)v.get(175)).setAttribute("height","8" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(177)).setAttribute("nombre","nroBoletaFactura" );
      ((Element)v.get(177)).setAttribute("id","datosCampos" );
      ((Element)v.get(177)).setAttribute("max","10" );
      ((Element)v.get(177)).setAttribute("tipo","" );
      ((Element)v.get(177)).setAttribute("onblur","" );
      ((Element)v.get(177)).setAttribute("req","N" );
      ((Element)v.get(177)).setAttribute("size","12" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(177)).setAttribute("valor","" );
      ((Element)v.get(177)).setAttribute("validacion","" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:178 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).setAttribute("width","8" );
      ((Element)v.get(179)).setAttribute("height","8" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(181)).setAttribute("nombre","importeDesde" );
      ((Element)v.get(181)).setAttribute("id","datosCampos" );
      ((Element)v.get(181)).setAttribute("max","13" );
      ((Element)v.get(181)).setAttribute("tipo","" );
      ((Element)v.get(181)).setAttribute("onblur","" );
      ((Element)v.get(181)).setAttribute("req","N" );
      ((Element)v.get(181)).setAttribute("size","15" );
      ((Element)v.get(181)).setAttribute("valor","" );
      ((Element)v.get(181)).setAttribute("validacion","" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(183)).setAttribute("src","b.gif" );
      ((Element)v.get(183)).setAttribute("width","8" );
      ((Element)v.get(183)).setAttribute("height","8" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(185)).setAttribute("nombre","importeHasta" );
      ((Element)v.get(185)).setAttribute("id","datosCampos" );
      ((Element)v.get(185)).setAttribute("max","13" );
      ((Element)v.get(185)).setAttribute("tipo","" );
      ((Element)v.get(185)).setAttribute("onblur","" );
      ((Element)v.get(185)).setAttribute("req","N" );
      ((Element)v.get(185)).setAttribute("size","15" );
      ((Element)v.get(185)).setAttribute("valor","" );
      ((Element)v.get(185)).setAttribute("validacion","" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).setAttribute("width","100%" );
      ((Element)v.get(169)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(187)).setAttribute("src","b.gif" );
      ((Element)v.get(187)).setAttribute("width","8" );
      ((Element)v.get(187)).setAttribute("height","8" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */
      /* Termina nodo:169   */

      /* Empieza nodo:188 / Elemento padre: 149   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(149)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(189)).setAttribute("colspan","4" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","8" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */
      /* Termina nodo:188   */
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:43   */
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:191 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(192)).setAttribute("src","b.gif" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:36   */

      /* Empieza nodo:193 / Elemento padre: 28   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(28)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(195)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("table"));
      ((Element)v.get(198)).setAttribute("width","100%" );
      ((Element)v.get(198)).setAttribute("border","0" );
      ((Element)v.get(198)).setAttribute("align","center" );
      ((Element)v.get(198)).setAttribute("cellspacing","0" );
      ((Element)v.get(198)).setAttribute("cellpadding","0" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(200)).setAttribute("class","botonera" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("BOTON"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(201)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(201)).setAttribute("ID","botonContenido" );
      ((Element)v.get(201)).setAttribute("tipo","html" );
      ((Element)v.get(201)).setAttribute("ontab","focalizaPagina('Detalle');" );
      ((Element)v.get(201)).setAttribute("accion","accionBuscar();" );
      ((Element)v.get(201)).setAttribute("estado","false" );
      ((Element)v.get(201)).setAttribute("cod","1" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:198   */
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:202 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(203)).setAttribute("src","b.gif" );
      ((Element)v.get(203)).setAttribute("width","8" );
      ((Element)v.get(203)).setAttribute("height","12" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */
      /* Termina nodo:193   */

      /* Empieza nodo:204 / Elemento padre: 28   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(28)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).setAttribute("width","12" );
      ((Element)v.get(205)).setAttribute("align","center" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).setAttribute("width","12" );
      ((Element)v.get(206)).setAttribute("height","12" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:207 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).setAttribute("width","756" );
      ((Element)v.get(204)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:209 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).setAttribute("width","12" );
      ((Element)v.get(204)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(210)).setAttribute("src","b.gif" );
      ((Element)v.get(210)).setAttribute("width","12" );
      ((Element)v.get(210)).setAttribute("height","1" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */
      /* Termina nodo:204   */
      /* Termina nodo:28   */

      /* Empieza nodo:211 / Elemento padre: 17   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(211)).setAttribute("nombre","listado1" );
      ((Element)v.get(211)).setAttribute("ancho","697" );
      ((Element)v.get(211)).setAttribute("alto","317" );
      ((Element)v.get(211)).setAttribute("x","12" );
      ((Element)v.get(211)).setAttribute("y","199" );
      ((Element)v.get(211)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(211)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(17)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(212)).setAttribute("precarga","S" );
      ((Element)v.get(212)).setAttribute("conROver","S" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(213)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(213)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(213)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(213)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */

      /* Empieza nodo:214 / Elemento padre: 212   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(214)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(214)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(214)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(214)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(212)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */

      /* Empieza nodo:215 / Elemento padre: 212   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(215)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(215)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(212)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:212   */

      /* Empieza nodo:216 / Elemento padre: 211   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(211)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(217)).setAttribute("borde","1" );
      ((Element)v.get(217)).setAttribute("horizDatos","1" );
      ((Element)v.get(217)).setAttribute("horizCabecera","1" );
      ((Element)v.get(217)).setAttribute("vertical","0" );
      ((Element)v.get(217)).setAttribute("horizTitulo","1" );
      ((Element)v.get(217)).setAttribute("horizBase","1" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */

      /* Empieza nodo:218 / Elemento padre: 216   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(218)).setAttribute("borde","#999999" );
      ((Element)v.get(218)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(218)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(218)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(218)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(218)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(218)).setAttribute("horizBase","#999999" );
      ((Element)v.get(216)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:216   */

      /* Empieza nodo:219 / Elemento padre: 211   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(219)).setAttribute("colFondo","#CECFCE" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(219)).setAttribute("alto","22" );
      ((Element)v.get(219)).setAttribute("imgFondo","" );
      ((Element)v.get(219)).setAttribute("cod","00135" );
      ((Element)v.get(219)).setAttribute("ID","datosTitle" );
      ((Element)v.get(211)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */

      /* Empieza nodo:220 / Elemento padre: 211   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(220)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(220)).setAttribute("alto","22" );
      ((Element)v.get(220)).setAttribute("imgFondo","" );
      ((Element)v.get(211)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */

      /* Empieza nodo:221 / Elemento padre: 211   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(221)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(221)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(221)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(221)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(221)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(221)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(211)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(222)).setAttribute("ancho","140" );
      ((Element)v.get(222)).setAttribute("minimizable","S" );
      ((Element)v.get(222)).setAttribute("minimizada","N" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */

      /* Empieza nodo:223 / Elemento padre: 221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(223)).setAttribute("ancho","80" );
      ((Element)v.get(223)).setAttribute("minimizable","S" );
      ((Element)v.get(223)).setAttribute("minimizada","N" );
      ((Element)v.get(221)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */

      /* Empieza nodo:224 / Elemento padre: 221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(224)).setAttribute("ancho","200" );
      ((Element)v.get(224)).setAttribute("minimizable","S" );
      ((Element)v.get(224)).setAttribute("minimizada","N" );
      ((Element)v.get(221)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */

      /* Empieza nodo:225 / Elemento padre: 221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(225)).setAttribute("ancho","120" );
      ((Element)v.get(225)).setAttribute("minimizable","S" );
      ((Element)v.get(225)).setAttribute("minimizada","N" );
      ((Element)v.get(221)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */

      /* Empieza nodo:226 / Elemento padre: 221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(226)).setAttribute("ancho","80" );
      ((Element)v.get(226)).setAttribute("minimizable","S" );
      ((Element)v.get(226)).setAttribute("minimizada","N" );
      ((Element)v.get(221)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */

      /* Empieza nodo:227 / Elemento padre: 221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(227)).setAttribute("ancho","80" );
      ((Element)v.get(227)).setAttribute("minimizable","S" );
      ((Element)v.get(227)).setAttribute("minimizada","N" );
      ((Element)v.get(221)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */

      /* Empieza nodo:228 / Elemento padre: 221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(228)).setAttribute("ancho","80" );
      ((Element)v.get(228)).setAttribute("minimizable","S" );
      ((Element)v.get(228)).setAttribute("minimizada","N" );
      ((Element)v.get(221)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */

      /* Empieza nodo:229 / Elemento padre: 221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(229)).setAttribute("ancho","80" );
      ((Element)v.get(229)).setAttribute("minimizable","S" );
      ((Element)v.get(229)).setAttribute("minimizada","N" );
      ((Element)v.get(221)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */

      /* Empieza nodo:230 / Elemento padre: 221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(230)).setAttribute("ancho","100" );
      ((Element)v.get(230)).setAttribute("minimizable","S" );
      ((Element)v.get(230)).setAttribute("minimizada","N" );
      ((Element)v.get(221)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */

      /* Empieza nodo:231 / Elemento padre: 221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(231)).setAttribute("ancho","40" );
      ((Element)v.get(231)).setAttribute("minimizable","S" );
      ((Element)v.get(231)).setAttribute("minimizada","N" );
      ((Element)v.get(221)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */

      /* Empieza nodo:232 / Elemento padre: 221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(232)).setAttribute("ancho","40" );
      ((Element)v.get(232)).setAttribute("minimizable","S" );
      ((Element)v.get(232)).setAttribute("minimizada","N" );
      ((Element)v.get(221)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */

      /* Empieza nodo:233 / Elemento padre: 221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(233)).setAttribute("ancho","60" );
      ((Element)v.get(233)).setAttribute("minimizable","S" );
      ((Element)v.get(233)).setAttribute("minimizada","N" );
      ((Element)v.get(221)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */

      /* Empieza nodo:234 / Elemento padre: 221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(234)).setAttribute("ancho","60" );
      ((Element)v.get(234)).setAttribute("minimizable","S" );
      ((Element)v.get(234)).setAttribute("minimizada","N" );
      ((Element)v.get(221)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */

      /* Empieza nodo:235 / Elemento padre: 221   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(235)).setAttribute("ancho","10" );
      ((Element)v.get(235)).setAttribute("minimizable","S" );
      ((Element)v.get(235)).setAttribute("minimizada","N" );
      ((Element)v.get(235)).setAttribute("oculta","S" );
      ((Element)v.get(221)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:221   */

      /* Empieza nodo:236 / Elemento padre: 211   */
      v.add(doc.createElement("CABECERA"));
   }

   private void getXML990(Document doc) {
      ((Element)v.get(236)).setAttribute("alto","30" );
      ((Element)v.get(236)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(236)).setAttribute("imgFondo","" );
      ((Element)v.get(236)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(211)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(237)).setAttribute("colFondo","" );
      ((Element)v.get(237)).setAttribute("ID","EstCab" );
      ((Element)v.get(237)).setAttribute("cod","636" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Elemento padre:237 / Elemento actual: 238   */
      v.add(doc.createTextNode("Cuenta Corriente"));
      ((Element)v.get(237)).appendChild((Text)v.get(238));

      /* Termina nodo Texto:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 236   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(239)).setAttribute("colFondo","" );
      ((Element)v.get(239)).setAttribute("ID","EstCab" );
      ((Element)v.get(239)).setAttribute("cod","263" );
      ((Element)v.get(236)).appendChild((Element)v.get(239));

      /* Elemento padre:239 / Elemento actual: 240   */
      v.add(doc.createTextNode("Código Cliente"));
      ((Element)v.get(239)).appendChild((Text)v.get(240));

      /* Termina nodo Texto:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:241 / Elemento padre: 236   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(241)).setAttribute("colFondo","" );
      ((Element)v.get(241)).setAttribute("ID","EstCab" );
      ((Element)v.get(241)).setAttribute("cod","264" );
      ((Element)v.get(236)).appendChild((Element)v.get(241));

      /* Elemento padre:241 / Elemento actual: 242   */
      v.add(doc.createTextNode("Nombre Cliente"));
      ((Element)v.get(241)).appendChild((Text)v.get(242));

      /* Termina nodo Texto:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:243 / Elemento padre: 236   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(243)).setAttribute("colFondo","" );
      ((Element)v.get(243)).setAttribute("ID","EstCab" );
      ((Element)v.get(243)).setAttribute("cod","680" );
      ((Element)v.get(236)).appendChild((Element)v.get(243));

      /* Elemento padre:243 / Elemento actual: 244   */
      v.add(doc.createTextNode("Nº lote"));
      ((Element)v.get(243)).appendChild((Text)v.get(244));

      /* Termina nodo Texto:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:245 / Elemento padre: 236   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(245)).setAttribute("colFondo","" );
      ((Element)v.get(245)).setAttribute("ID","EstCab" );
      ((Element)v.get(245)).setAttribute("cod","634" );
      ((Element)v.get(236)).appendChild((Element)v.get(245));

      /* Elemento padre:245 / Elemento actual: 246   */
      v.add(doc.createTextNode("Consecutivo Transacción"));
      ((Element)v.get(245)).appendChild((Text)v.get(246));

      /* Termina nodo Texto:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:247 / Elemento padre: 236   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(247)).setAttribute("colFondo","" );
      ((Element)v.get(247)).setAttribute("ID","EstCab" );
      ((Element)v.get(247)).setAttribute("cod","654" );
      ((Element)v.get(236)).appendChild((Element)v.get(247));

      /* Elemento padre:247 / Elemento actual: 248   */
      v.add(doc.createTextNode("Fecha Pago"));
      ((Element)v.get(247)).appendChild((Text)v.get(248));

      /* Termina nodo Texto:248   */
      /* Termina nodo:247   */

      /* Empieza nodo:249 / Elemento padre: 236   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(249)).setAttribute("colFondo","" );
      ((Element)v.get(249)).setAttribute("ID","EstCab" );
      ((Element)v.get(249)).setAttribute("cod","670" );
      ((Element)v.get(236)).appendChild((Element)v.get(249));

      /* Elemento padre:249 / Elemento actual: 250   */
      v.add(doc.createTextNode("Importe pago"));
      ((Element)v.get(249)).appendChild((Text)v.get(250));

      /* Termina nodo Texto:250   */
      /* Termina nodo:249   */

      /* Empieza nodo:251 / Elemento padre: 236   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(251)).setAttribute("colFondo","" );
      ((Element)v.get(251)).setAttribute("ID","EstCab" );
      ((Element)v.get(251)).setAttribute("cod","00287" );
      ((Element)v.get(236)).appendChild((Element)v.get(251));

      /* Elemento padre:251 / Elemento actual: 252   */
      v.add(doc.createTextNode("Importe pendiente"));
      ((Element)v.get(251)).appendChild((Text)v.get(252));

      /* Termina nodo Texto:252   */
      /* Termina nodo:251   */

      /* Empieza nodo:253 / Elemento padre: 236   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(253)).setAttribute("colFondo","" );
      ((Element)v.get(253)).setAttribute("ID","EstCab" );
      ((Element)v.get(253)).setAttribute("cod","702" );
      ((Element)v.get(236)).appendChild((Element)v.get(253));

      /* Elemento padre:253 / Elemento actual: 254   */
      v.add(doc.createTextNode("Tipo Transacción"));
      ((Element)v.get(253)).appendChild((Text)v.get(254));

      /* Termina nodo Texto:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:255 / Elemento padre: 236   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(255)).setAttribute("colFondo","" );
      ((Element)v.get(255)).setAttribute("ID","EstCab" );
      ((Element)v.get(255)).setAttribute("cod","171" );
      ((Element)v.get(236)).appendChild((Element)v.get(255));

      /* Elemento padre:255 / Elemento actual: 256   */
      v.add(doc.createTextNode("Año"));
      ((Element)v.get(255)).appendChild((Text)v.get(256));

      /* Termina nodo Texto:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:257 / Elemento padre: 236   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(257)).setAttribute("colFondo","" );
      ((Element)v.get(257)).setAttribute("ID","EstCab" );
      ((Element)v.get(257)).setAttribute("cod","674" );
      ((Element)v.get(236)).appendChild((Element)v.get(257));

      /* Elemento padre:257 / Elemento actual: 258   */
      v.add(doc.createTextNode("Mes"));
      ((Element)v.get(257)).appendChild((Text)v.get(258));

      /* Termina nodo Texto:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:259 / Elemento padre: 236   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(259)).setAttribute("colFondo","" );
      ((Element)v.get(259)).setAttribute("ID","EstCab" );
      ((Element)v.get(259)).setAttribute("cod","226" );
      ((Element)v.get(236)).appendChild((Element)v.get(259));

      /* Elemento padre:259 / Elemento actual: 260   */
      v.add(doc.createTextNode("Número"));
      ((Element)v.get(259)).appendChild((Text)v.get(260));

      /* Termina nodo Texto:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:261 / Elemento padre: 236   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(261)).setAttribute("colFondo","" );
      ((Element)v.get(261)).setAttribute("ID","EstCab" );
      ((Element)v.get(261)).setAttribute("cod","400" );
      ((Element)v.get(236)).appendChild((Element)v.get(261));

      /* Elemento padre:261 / Elemento actual: 262   */
      v.add(doc.createTextNode("Estado"));
      ((Element)v.get(261)).appendChild((Text)v.get(262));

      /* Termina nodo Texto:262   */
      /* Termina nodo:261   */

      /* Empieza nodo:263 / Elemento padre: 236   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(263)).setAttribute("colFondo","" );
      ((Element)v.get(263)).setAttribute("ID","EstCab" );
      ((Element)v.get(263)).setAttribute("cod","" );
      ((Element)v.get(236)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:236   */

      /* Empieza nodo:264 / Elemento padre: 211   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(264)).setAttribute("alto","22" );
      ((Element)v.get(264)).setAttribute("accion","" );
      ((Element)v.get(264)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(264)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(264)).setAttribute("maxSel","-1" );
      ((Element)v.get(264)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(264)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(264)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(264)).setAttribute("onLoad","" );
      ((Element)v.get(264)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(211)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(265)).setAttribute("tipo","texto" );
      ((Element)v.get(265)).setAttribute("ID","EstDat" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */

      /* Empieza nodo:266 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(266)).setAttribute("tipo","texto" );
      ((Element)v.get(266)).setAttribute("ID","EstDat2" );
      ((Element)v.get(264)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */

      /* Empieza nodo:267 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(267)).setAttribute("tipo","texto" );
      ((Element)v.get(267)).setAttribute("ID","EstDat" );
      ((Element)v.get(264)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */

      /* Empieza nodo:268 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(268)).setAttribute("tipo","texto" );
      ((Element)v.get(268)).setAttribute("ID","EstDat2" );
      ((Element)v.get(264)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */

      /* Empieza nodo:269 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(269)).setAttribute("tipo","texto" );
      ((Element)v.get(269)).setAttribute("ID","EstDat" );
      ((Element)v.get(264)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */

      /* Empieza nodo:270 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(270)).setAttribute("tipo","texto" );
      ((Element)v.get(270)).setAttribute("ID","EstDat2" );
      ((Element)v.get(264)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */

      /* Empieza nodo:271 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(271)).setAttribute("tipo","texto" );
      ((Element)v.get(271)).setAttribute("ID","EstDat" );
      ((Element)v.get(264)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */

      /* Empieza nodo:272 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(272)).setAttribute("tipo","texto" );
      ((Element)v.get(272)).setAttribute("ID","EstDat2" );
      ((Element)v.get(264)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */

      /* Empieza nodo:273 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(273)).setAttribute("tipo","texto" );
      ((Element)v.get(273)).setAttribute("ID","EstDat" );
      ((Element)v.get(264)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */

      /* Empieza nodo:274 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(274)).setAttribute("tipo","texto" );
      ((Element)v.get(274)).setAttribute("ID","EstDat2" );
      ((Element)v.get(264)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */

      /* Empieza nodo:275 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(275)).setAttribute("tipo","texto" );
      ((Element)v.get(275)).setAttribute("ID","EstDat" );
      ((Element)v.get(264)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */

      /* Empieza nodo:276 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(276)).setAttribute("tipo","texto" );
      ((Element)v.get(276)).setAttribute("ID","EstDat2" );
      ((Element)v.get(264)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */

      /* Empieza nodo:277 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(277)).setAttribute("tipo","texto" );
      ((Element)v.get(277)).setAttribute("ID","EstDat" );
      ((Element)v.get(264)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */

      /* Empieza nodo:278 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(278)).setAttribute("tipo","texto" );
      ((Element)v.get(278)).setAttribute("ID","EstDat2" );
      ((Element)v.get(264)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:264   */

      /* Empieza nodo:279 / Elemento padre: 211   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(211)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */

      /* Empieza nodo:280 / Elemento padre: 211   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(280)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(280)).setAttribute("ancho","697" );
      ((Element)v.get(280)).setAttribute("sep","$" );
      ((Element)v.get(280)).setAttribute("x","12" );
      ((Element)v.get(280)).setAttribute("class","botonera" );
      ((Element)v.get(280)).setAttribute("y","493" );
      ((Element)v.get(280)).setAttribute("control","|" );
      ((Element)v.get(280)).setAttribute("conector","ConectorBuscarMovBancConfirmar" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(280)).setAttribute("rowset","" );
      ((Element)v.get(280)).setAttribute("onload","procesarPaginado(mipgndo, msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(280)).setAttribute("cargainicial","N" );
      ((Element)v.get(211)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(281)).setAttribute("nombre","ret1" );
      ((Element)v.get(281)).setAttribute("x","37" );
      ((Element)v.get(281)).setAttribute("y","497" );
      ((Element)v.get(281)).setAttribute("ID","botonContenido" );
      ((Element)v.get(281)).setAttribute("img","retroceder_on" );
      ((Element)v.get(281)).setAttribute("tipo","0" );
      ((Element)v.get(281)).setAttribute("estado","false" );
      ((Element)v.get(281)).setAttribute("alt","" );
      ((Element)v.get(281)).setAttribute("codigo","" );
      ((Element)v.get(281)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */

      /* Empieza nodo:282 / Elemento padre: 280   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(282)).setAttribute("nombre","ava1" );
      ((Element)v.get(282)).setAttribute("x","52" );
      ((Element)v.get(282)).setAttribute("y","497" );
      ((Element)v.get(282)).setAttribute("ID","botonContenido" );
      ((Element)v.get(282)).setAttribute("img","avanzar_on" );
      ((Element)v.get(282)).setAttribute("tipo","0" );
      ((Element)v.get(282)).setAttribute("estado","false" );
      ((Element)v.get(282)).setAttribute("alt","" );
      ((Element)v.get(282)).setAttribute("codigo","" );
      ((Element)v.get(282)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(280)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:280   */
      /* Termina nodo:211   */

      /* Empieza nodo:283 / Elemento padre: 17   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(283)).setAttribute("nombre","primera1" );
      ((Element)v.get(283)).setAttribute("x","20" );
      ((Element)v.get(283)).setAttribute("y","497" );
      ((Element)v.get(283)).setAttribute("ID","botonContenido" );
      ((Element)v.get(283)).setAttribute("img","primera_on" );
      ((Element)v.get(283)).setAttribute("tipo","-2" );
      ((Element)v.get(283)).setAttribute("estado","false" );
      ((Element)v.get(283)).setAttribute("alt","" );
      ((Element)v.get(283)).setAttribute("codigo","" );
      ((Element)v.get(283)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(17)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */

      /* Empieza nodo:284 / Elemento padre: 17   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(284)).setAttribute("nombre","separa1" );
      ((Element)v.get(284)).setAttribute("x","59" );
      ((Element)v.get(284)).setAttribute("y","493" );
      ((Element)v.get(284)).setAttribute("ID","botonContenido" );
      ((Element)v.get(284)).setAttribute("img","separa_base" );
      ((Element)v.get(284)).setAttribute("tipo","0" );
      ((Element)v.get(284)).setAttribute("estado","false" );
      ((Element)v.get(284)).setAttribute("alt","" );
      ((Element)v.get(284)).setAttribute("codigo","" );
      ((Element)v.get(284)).setAttribute("accion","" );
      ((Element)v.get(17)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */

      /* Empieza nodo:285 / Elemento padre: 17   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(285)).setAttribute("nombre","Detalle" );
      ((Element)v.get(285)).setAttribute("x","80" );
      ((Element)v.get(285)).setAttribute("y","494" );
      ((Element)v.get(285)).setAttribute("ID","botonContenido" );
      ((Element)v.get(285)).setAttribute("accion","consultarDetalle();" );
      ((Element)v.get(285)).setAttribute("onshtab","focalizaPagina('btnBuscar')" );
      ((Element)v.get(285)).setAttribute("tipo","html" );
      ((Element)v.get(285)).setAttribute("estado","false" );
      ((Element)v.get(285)).setAttribute("cod","3" );
      ((Element)v.get(17)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */

      /* Empieza nodo:286 / Elemento padre: 17   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(286)).setAttribute("nombre","Consulta" );
      ((Element)v.get(286)).setAttribute("x","132" );
      ((Element)v.get(286)).setAttribute("y","494" );
      ((Element)v.get(286)).setAttribute("ID","botonContenido" );
      ((Element)v.get(286)).setAttribute("accion","consultarCC();" );
      ((Element)v.get(286)).setAttribute("tipo","html" );
      ((Element)v.get(286)).setAttribute("estado","false" );
      ((Element)v.get(286)).setAttribute("cod","636" );
      ((Element)v.get(286)).setAttribute("ontab","focalizaPagina('cbBanco');" );
      ((Element)v.get(17)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */

      /* Empieza nodo:287 / Elemento padre: 17   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(287)).setAttribute("nombre","Confirmar" );
      ((Element)v.get(287)).setAttribute("x","256" );
      ((Element)v.get(287)).setAttribute("y","494" );
      ((Element)v.get(287)).setAttribute("ID","botonContenido" );
      ((Element)v.get(287)).setAttribute("tipo","html" );
      ((Element)v.get(287)).setAttribute("estado","false" );
      ((Element)v.get(287)).setAttribute("accion","buscarReceptor();" );
      ((Element)v.get(287)).setAttribute("cod","977" );
      ((Element)v.get(17)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */

      /* Empieza nodo:288 / Elemento padre: 17   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(288)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(288)).setAttribute("alto","12" );
      ((Element)v.get(288)).setAttribute("ancho","100%" );
      ((Element)v.get(288)).setAttribute("colorf","" );
      ((Element)v.get(288)).setAttribute("borde","0" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(288)).setAttribute("imagenf","" );
      ((Element)v.get(288)).setAttribute("repeat","" );
      ((Element)v.get(288)).setAttribute("padding","" );
      ((Element)v.get(288)).setAttribute("visibilidad","visible" );
      ((Element)v.get(288)).setAttribute("contravsb","" );
      ((Element)v.get(288)).setAttribute("x","0" );
      ((Element)v.get(288)).setAttribute("y","481" );
      ((Element)v.get(288)).setAttribute("zindex","" );
      ((Element)v.get(17)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:17   */


   }

}


import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_producto_no_buscar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_producto_no_buscar" );
      ((Element)v.get(0)).setAttribute("cod","0223" );
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
      v.add(doc.createTextNode("\r   \r\r#ret1Div {visibility:hidden;}\r#ava1Div {visibility:hidden;}\r#primera1Div {visibility:hidden;}\r#separaDiv {visibility:hidden;}\r#Cplistado1{visibility:hidden;}\r#CpLin1listado1{visibility:hidden;}\r#CpLin2listado1{visibility:hidden;}\r#CpLin3listado1{visibility:hidden;}\r#CpLin4listado1{visibility:hidden;}\r\r#Anadir1Div{visibility:hidden;}\r\r#CplistadoAux{visibility:hidden;}\r#CpLin1listadoAux{visibility:hidden;}\r#CpLin2listadoAux{visibility:hidden;}\r#CpLin3listadoAux{visibility:hidden;}\r#CpLin4listadoAux{visibility:hidden;}\r\r#EliminarDiv{visibility:hidden;}\r#AceptarDiv{visibility:hidden;}\r\r\r#Cplistado2{visibility:hidden;}\r#CpLin1listado2{visibility:hidden;}\r#CpLin2listado2{visibility:hidden;}\r#CpLin3listado2{visibility:hidden;}\r#CpLin4listado2{visibility:hidden;}\r\r#Aceptar2Div{visibility:hidden;}\r\r\r#Cplistado3{visibility:hidden;}\r#CpLin1listado3{visibility:hidden;}\r#CpLin2listado3{visibility:hidden;}\r#CpLin3listado3{visibility:hidden;}\r#CpLin4listado3{visibility:hidden;}\r\r#Aceptar3Div{visibility:hidden;}\r\r   \r"));
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
      ((Element)v.get(6)).setAttribute("src","contenido_producto_no_buscar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","xxx" );
      ((Element)v.get(8)).setAttribute("required","false" );
      ((Element)v.get(8)).setAttribute("cod","506" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */
      /* Termina nodo:7   */

      /* Empieza nodo:9 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(9)).setAttribute("nombre","frmContenido" );
      ((Element)v.get(0)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","errSeverity" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","accion" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","idioma" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","pais" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","casoUso" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","ingresaDevuelve" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","devuelveFisicoFactura" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","devuelveFactura" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","ingresaEnvia" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","enviaFactura" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("nombre","oidNumDocumento" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","oidCliente" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","oidOperacion" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","tipoMovimiento" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","oidTipoMovimiento" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hid_SeparadorMiles" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hid_SeparadorDecimales" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hid_NumeroDecimales" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","arrayList" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","pagina" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","cerrar" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","visible" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","numeroLinea" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hOidsMotivoDevolucion" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hDescsMotivoDevolucion" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 9   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(38)).setAttribute("nombre","capaContenido" );
      ((Element)v.get(38)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(9)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("table"));
      ((Element)v.get(39)).setAttribute("width","100%" );
      ((Element)v.get(39)).setAttribute("border","0" );
      ((Element)v.get(39)).setAttribute("cellspacing","0" );
      ((Element)v.get(39)).setAttribute("cellpadding","0" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).setAttribute("width","12" );
      ((Element)v.get(41)).setAttribute("align","center" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).setAttribute("width","12" );
      ((Element)v.get(42)).setAttribute("height","12" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:43 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).setAttribute("width","750" );
      ((Element)v.get(40)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 40   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).setAttribute("width","12" );
      ((Element)v.get(40)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","12" );
      ((Element)v.get(46)).setAttribute("height","1" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */
      /* Termina nodo:40   */

      /* Empieza nodo:47 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(52)).setAttribute("class","legend" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(53)).setAttribute("nombre","lblCriterios" );
      ((Element)v.get(53)).setAttribute("alto","13" );
      ((Element)v.get(53)).setAttribute("filas","1" );
      ((Element)v.get(53)).setAttribute("valor","Datos Búsqueda" );
      ((Element)v.get(53)).setAttribute("id","legend" );
      ((Element)v.get(53)).setAttribute("cod","0075" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 51   */
      v.add(doc.createElement("table"));
      ((Element)v.get(54)).setAttribute("width","100%" );
      ((Element)v.get(54)).setAttribute("border","0" );
      ((Element)v.get(54)).setAttribute("align","center" );
      ((Element)v.get(54)).setAttribute("cellspacing","0" );
      ((Element)v.get(54)).setAttribute("cellpadding","0" );
      ((Element)v.get(51)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("table"));
      ((Element)v.get(57)).setAttribute("width","628" );
      ((Element)v.get(57)).setAttribute("border","0" );
      ((Element)v.get(57)).setAttribute("align","left" );
      ((Element)v.get(57)).setAttribute("cellspacing","0" );
      ((Element)v.get(57)).setAttribute("cellpadding","0" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).setAttribute("colspan","4" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","8" );
      ((Element)v.get(60)).setAttribute("height","8" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:61 / Elemento padre: 57   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(57)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","8" );
      ((Element)v.get(63)).setAttribute("height","8" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(65)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(65)).setAttribute("alto","13" );
      ((Element)v.get(65)).setAttribute("filas","1" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(65)).setAttribute("id","datosTitle" );
      ((Element)v.get(65)).setAttribute("cod","9" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","25" );
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(69)).setAttribute("nombre","lblCodVenta" );
      ((Element)v.get(69)).setAttribute("alto","13" );
      ((Element)v.get(69)).setAttribute("filas","1" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(69)).setAttribute("id","datosTitle" );
      ((Element)v.get(69)).setAttribute("cod","336" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 61   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","25" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(73)).setAttribute("nombre","lblCodProducto" );
      ((Element)v.get(73)).setAttribute("alto","13" );
      ((Element)v.get(73)).setAttribute("filas","1" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(73)).setAttribute("id","datosTitle" );
      ((Element)v.get(73)).setAttribute("cod","337" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","25" );
      ((Element)v.get(75)).setAttribute("height","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(77)).setAttribute("nombre","lblPagCat" );
      ((Element)v.get(77)).setAttribute("alto","13" );
      ((Element)v.get(77)).setAttribute("filas","1" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(77)).setAttribute("id","datosTitle" );
      ((Element)v.get(77)).setAttribute("cod","571" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("width","100%" );
      ((Element)v.get(61)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","8" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:61   */

      /* Empieza nodo:80 / Elemento padre: 57   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(57)).appendChild((Element)v.get(80));

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
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(84)).setAttribute("nombre","txtDescripcion" );
      ((Element)v.get(84)).setAttribute("id","datosCampos" );
      ((Element)v.get(84)).setAttribute("max","30" );
      ((Element)v.get(84)).setAttribute("tipo","" );
      ((Element)v.get(84)).setAttribute("onchange","" );
      ((Element)v.get(84)).setAttribute("onshtab","document.body.focus();focalizaAnteriorDescripcion();" );
      ((Element)v.get(84)).setAttribute("req","N" );
      ((Element)v.get(84)).setAttribute("size","40" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(84)).setAttribute("validacion","" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","25" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(80)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(88)).setAttribute("nombre","txtCodVenta" );
      ((Element)v.get(88)).setAttribute("id","datosCampos" );
      ((Element)v.get(88)).setAttribute("max","18" );
      ((Element)v.get(88)).setAttribute("tipo","" );
      ((Element)v.get(88)).setAttribute("onchange","mayusculas('txtCodVenta')" );
      ((Element)v.get(88)).setAttribute("req","N" );
      ((Element)v.get(88)).setAttribute("size","24" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(88)).setAttribute("validacion","" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","25" );
      ((Element)v.get(90)).setAttribute("height","8" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(80)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(92)).setAttribute("nombre","txtCodProducto" );
      ((Element)v.get(92)).setAttribute("id","datosCampos" );
      ((Element)v.get(92)).setAttribute("max","15" );
      ((Element)v.get(92)).setAttribute("tipo","" );
      ((Element)v.get(92)).setAttribute("onchange","mayusculas('txtCodProducto')" );
      ((Element)v.get(92)).setAttribute("req","N" );
      ((Element)v.get(92)).setAttribute("size","19" );
      ((Element)v.get(92)).setAttribute("valor","" );
      ((Element)v.get(92)).setAttribute("validacion","" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","25" );
      ((Element)v.get(94)).setAttribute("height","8" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(80)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(96)).setAttribute("nombre","txtPagCat" );
      ((Element)v.get(96)).setAttribute("id","datosCampos" );
      ((Element)v.get(96)).setAttribute("max","3" );
      ((Element)v.get(96)).setAttribute("tipo","" );
      ((Element)v.get(96)).setAttribute("onblur","validaEntero('txtPagCat');" );
      ((Element)v.get(96)).setAttribute("onchange","" );
      ((Element)v.get(96)).setAttribute("req","N" );
      ((Element)v.get(96)).setAttribute("size","3" );
      ((Element)v.get(96)).setAttribute("valor","" );
      ((Element)v.get(96)).setAttribute("validacion","" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).setAttribute("width","100%" );
      ((Element)v.get(80)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).setAttribute("width","8" );
      ((Element)v.get(98)).setAttribute("height","8" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:80   */

      /* Empieza nodo:99 / Elemento padre: 57   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(57)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).setAttribute("colspan","4" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","8" );
      ((Element)v.get(101)).setAttribute("height","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:54   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:102 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:47   */

      /* Empieza nodo:104 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("table"));
      ((Element)v.get(109)).setAttribute("width","100%" );
      ((Element)v.get(109)).setAttribute("border","0" );
      ((Element)v.get(109)).setAttribute("align","center" );
      ((Element)v.get(109)).setAttribute("cellspacing","0" );
      ((Element)v.get(109)).setAttribute("cellpadding","0" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("class","botonera" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(112)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(112)).setAttribute("ID","botonContenido" );
      ((Element)v.get(112)).setAttribute("tipo","html" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(112)).setAttribute("ontab","focalizaSiguienteBuscar();" );
      ((Element)v.get(112)).setAttribute("accion","onClickBuscar();" );
      ((Element)v.get(112)).setAttribute("estado","false" );
      ((Element)v.get(112)).setAttribute("cod","1" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:113 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","8" );
      ((Element)v.get(114)).setAttribute("height","12" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:104   */

      /* Empieza nodo:115 / Elemento padre: 39   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(39)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).setAttribute("width","12" );
      ((Element)v.get(116)).setAttribute("align","center" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","12" );
      ((Element)v.get(117)).setAttribute("height","12" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("width","750" );
      ((Element)v.get(115)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).setAttribute("width","12" );
      ((Element)v.get(115)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","12" );
      ((Element)v.get(121)).setAttribute("height","1" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:115   */
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:122 / Elemento padre: 9   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(122)).setAttribute("nombre","listado1" );
      ((Element)v.get(122)).setAttribute("ancho","631" );
      ((Element)v.get(122)).setAttribute("alto","317" );
      ((Element)v.get(122)).setAttribute("x","12" );
      ((Element)v.get(122)).setAttribute("y","124" );
      ((Element)v.get(122)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(122)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(9)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(123)).setAttribute("precarga","S" );
      ((Element)v.get(123)).setAttribute("conROver","S" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(124)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(124)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(124)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(124)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */

      /* Empieza nodo:125 / Elemento padre: 123   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(125)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(125)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(125)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(125)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(123)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 123   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(126)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(126)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(123)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:123   */

      /* Empieza nodo:127 / Elemento padre: 122   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(122)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(128)).setAttribute("borde","1" );
      ((Element)v.get(128)).setAttribute("horizDatos","1" );
      ((Element)v.get(128)).setAttribute("horizCabecera","1" );
      ((Element)v.get(128)).setAttribute("vertical","1" );
      ((Element)v.get(128)).setAttribute("horizTitulo","1" );
      ((Element)v.get(128)).setAttribute("horizBase","1" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */

      /* Empieza nodo:129 / Elemento padre: 127   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(129)).setAttribute("borde","#999999" );
      ((Element)v.get(129)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(129)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(129)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(129)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(129)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(129)).setAttribute("horizBase","#999999" );
      ((Element)v.get(127)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:127   */

      /* Empieza nodo:130 / Elemento padre: 122   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(130)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(130)).setAttribute("alto","22" );
      ((Element)v.get(130)).setAttribute("imgFondo","" );
      ((Element)v.get(130)).setAttribute("cod","00135" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(130)).setAttribute("ID","datosTitle" );
      ((Element)v.get(122)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 122   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(131)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(131)).setAttribute("alto","22" );
      ((Element)v.get(131)).setAttribute("imgFondo","" );
      ((Element)v.get(122)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 122   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(132)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(132)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(132)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(132)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(132)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(132)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(122)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(133)).setAttribute("ancho","150" );
      ((Element)v.get(133)).setAttribute("minimizable","S" );
      ((Element)v.get(133)).setAttribute("minimizada","N" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */

      /* Empieza nodo:134 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(134)).setAttribute("ancho","100" );
      ((Element)v.get(134)).setAttribute("minimizable","S" );
      ((Element)v.get(134)).setAttribute("minimizada","N" );
      ((Element)v.get(132)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */

      /* Empieza nodo:135 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(135)).setAttribute("ancho","100" );
      ((Element)v.get(135)).setAttribute("minimizable","S" );
      ((Element)v.get(135)).setAttribute("minimizada","N" );
      ((Element)v.get(132)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(136)).setAttribute("ancho","100" );
      ((Element)v.get(136)).setAttribute("minimizable","S" );
      ((Element)v.get(136)).setAttribute("minimizada","N" );
      ((Element)v.get(132)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */

      /* Empieza nodo:137 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(137)).setAttribute("ancho","100" );
      ((Element)v.get(137)).setAttribute("minimizable","S" );
      ((Element)v.get(137)).setAttribute("minimizada","N" );
      ((Element)v.get(132)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(138)).setAttribute("ancho","130" );
      ((Element)v.get(138)).setAttribute("minimizable","S" );
      ((Element)v.get(138)).setAttribute("minimizada","N" );
      ((Element)v.get(132)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(139)).setAttribute("ancho","130" );
      ((Element)v.get(139)).setAttribute("minimizable","S" );
      ((Element)v.get(139)).setAttribute("minimizada","N" );
      ((Element)v.get(139)).setAttribute("oculta","S" );
      ((Element)v.get(132)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(140)).setAttribute("ancho","130" );
      ((Element)v.get(140)).setAttribute("minimizable","S" );
      ((Element)v.get(140)).setAttribute("minimizada","N" );
      ((Element)v.get(140)).setAttribute("oculta","S" );
      ((Element)v.get(132)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(141)).setAttribute("ancho","130" );
      ((Element)v.get(141)).setAttribute("minimizable","S" );
      ((Element)v.get(141)).setAttribute("minimizada","N" );
      ((Element)v.get(141)).setAttribute("oculta","S" );
      ((Element)v.get(132)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(142)).setAttribute("ancho","130" );
      ((Element)v.get(142)).setAttribute("minimizable","S" );
      ((Element)v.get(142)).setAttribute("minimizada","N" );
      ((Element)v.get(142)).setAttribute("oculta","S" );
      ((Element)v.get(132)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(143)).setAttribute("ancho","130" );
      ((Element)v.get(143)).setAttribute("minimizable","S" );
      ((Element)v.get(143)).setAttribute("minimizada","N" );
      ((Element)v.get(143)).setAttribute("oculta","S" );
      ((Element)v.get(132)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(144)).setAttribute("ancho","150" );
      ((Element)v.get(144)).setAttribute("minimizable","S" );
      ((Element)v.get(144)).setAttribute("minimizada","N" );
      ((Element)v.get(132)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(145)).setAttribute("ancho","100" );
      ((Element)v.get(145)).setAttribute("minimizable","S" );
      ((Element)v.get(145)).setAttribute("minimizada","N" );
      ((Element)v.get(132)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */

      /* Empieza nodo:146 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(146)).setAttribute("ancho","130" );
      ((Element)v.get(146)).setAttribute("minimizable","S" );
      ((Element)v.get(146)).setAttribute("minimizada","N" );
      ((Element)v.get(132)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */

      /* Empieza nodo:147 / Elemento padre: 132   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(147)).setAttribute("ancho","130" );
      ((Element)v.get(147)).setAttribute("minimizable","S" );
      ((Element)v.get(147)).setAttribute("minimizada","N" );
      ((Element)v.get(132)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */

      /* Empieza nodo:148 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(148)).setAttribute("ancho","130" );
      ((Element)v.get(148)).setAttribute("minimizable","S" );
      ((Element)v.get(148)).setAttribute("minimizada","N" );
      ((Element)v.get(148)).setAttribute("oculta","S" );
      ((Element)v.get(132)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:132   */

      /* Empieza nodo:149 / Elemento padre: 122   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(149)).setAttribute("alto","20" );
      ((Element)v.get(149)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(149)).setAttribute("imgFondo","" );
      ((Element)v.get(149)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(122)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(150)).setAttribute("colFondo","" );
      ((Element)v.get(150)).setAttribute("ID","EstCab" );
      ((Element)v.get(150)).setAttribute("cod","338" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */

      /* Empieza nodo:151 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(151)).setAttribute("colFondo","" );
      ((Element)v.get(151)).setAttribute("ID","EstCab" );
      ((Element)v.get(151)).setAttribute("cod","276" );
      ((Element)v.get(149)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */

      /* Empieza nodo:152 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(152)).setAttribute("colFondo","" );
      ((Element)v.get(152)).setAttribute("ID","EstCab" );
      ((Element)v.get(152)).setAttribute("cod","465" );
      ((Element)v.get(149)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */

      /* Empieza nodo:153 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(153)).setAttribute("colFondo","" );
      ((Element)v.get(153)).setAttribute("ID","EstCab" );
      ((Element)v.get(153)).setAttribute("cod","336" );
      ((Element)v.get(149)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(154)).setAttribute("colFondo","" );
      ((Element)v.get(154)).setAttribute("ID","EstCab" );
      ((Element)v.get(154)).setAttribute("cod","337" );
      ((Element)v.get(149)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */

      /* Empieza nodo:155 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(155)).setAttribute("colFondo","" );
      ((Element)v.get(155)).setAttribute("ID","EstCab" );
      ((Element)v.get(155)).setAttribute("cod","530" );
      ((Element)v.get(149)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */

      /* Empieza nodo:156 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(156)).setAttribute("colFondo","" );
      ((Element)v.get(156)).setAttribute("ID","EstCab" );
      ((Element)v.get(156)).setAttribute("cod","302" );
      ((Element)v.get(149)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */

      /* Empieza nodo:157 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(157)).setAttribute("colFondo","" );
      ((Element)v.get(157)).setAttribute("ID","EstCab" );
      ((Element)v.get(157)).setAttribute("cod","302" );
      ((Element)v.get(149)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */

      /* Empieza nodo:158 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(158)).setAttribute("colFondo","" );
      ((Element)v.get(158)).setAttribute("ID","EstCab" );
      ((Element)v.get(158)).setAttribute("cod","302" );
      ((Element)v.get(149)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */

      /* Empieza nodo:159 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(159)).setAttribute("colFondo","" );
      ((Element)v.get(159)).setAttribute("ID","EstCab" );
      ((Element)v.get(159)).setAttribute("cod","302" );
      ((Element)v.get(149)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */

      /* Empieza nodo:160 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(160)).setAttribute("colFondo","" );
      ((Element)v.get(160)).setAttribute("ID","EstCab" );
      ((Element)v.get(160)).setAttribute("cod","302" );
      ((Element)v.get(149)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */

      /* Empieza nodo:161 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(161)).setAttribute("colFondo","" );
      ((Element)v.get(161)).setAttribute("ID","EstCab" );
      ((Element)v.get(161)).setAttribute("cod","506" );
      ((Element)v.get(149)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */

      /* Empieza nodo:162 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(162)).setAttribute("colFondo","" );
      ((Element)v.get(162)).setAttribute("ID","EstCab" );
      ((Element)v.get(162)).setAttribute("cod","2492" );
      ((Element)v.get(149)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */

      /* Empieza nodo:163 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(163)).setAttribute("colFondo","" );
      ((Element)v.get(163)).setAttribute("ID","EstCab" );
      ((Element)v.get(163)).setAttribute("cod","309" );
      ((Element)v.get(149)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */

      /* Empieza nodo:164 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(164)).setAttribute("colFondo","" );
      ((Element)v.get(164)).setAttribute("ID","EstCab" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(164)).setAttribute("cod","302" );
      ((Element)v.get(149)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */

      /* Empieza nodo:165 / Elemento padre: 149   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(165)).setAttribute("colFondo","" );
      ((Element)v.get(165)).setAttribute("ID","EstCab" );
      ((Element)v.get(165)).setAttribute("cod","302" );
      ((Element)v.get(149)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:149   */

      /* Empieza nodo:166 / Elemento padre: 122   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(166)).setAttribute("alto","22" );
      ((Element)v.get(166)).setAttribute("accion","" );
      ((Element)v.get(166)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(166)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(166)).setAttribute("maxSel","-1" );
      ((Element)v.get(166)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(166)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(166)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(166)).setAttribute("onLoad","" );
      ((Element)v.get(166)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(122)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(167)).setAttribute("tipo","texto" );
      ((Element)v.get(167)).setAttribute("ID","EstDat" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(168)).setAttribute("tipo","texto" );
      ((Element)v.get(168)).setAttribute("ID","EstDat2" );
      ((Element)v.get(166)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(169)).setAttribute("tipo","texto" );
      ((Element)v.get(169)).setAttribute("ID","EstDat" );
      ((Element)v.get(166)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */

      /* Empieza nodo:170 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(170)).setAttribute("tipo","texto" );
      ((Element)v.get(170)).setAttribute("ID","EstDat2" );
      ((Element)v.get(166)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(171)).setAttribute("tipo","texto" );
      ((Element)v.get(171)).setAttribute("ID","EstDat" );
      ((Element)v.get(166)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */

      /* Empieza nodo:172 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(172)).setAttribute("tipo","texto" );
      ((Element)v.get(172)).setAttribute("ID","EstDat" );
      ((Element)v.get(166)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */

      /* Empieza nodo:173 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(173)).setAttribute("tipo","texto" );
      ((Element)v.get(173)).setAttribute("ID","EstDat" );
      ((Element)v.get(166)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */

      /* Empieza nodo:174 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(174)).setAttribute("tipo","texto" );
      ((Element)v.get(174)).setAttribute("ID","EstDat" );
      ((Element)v.get(166)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(175)).setAttribute("tipo","texto" );
      ((Element)v.get(175)).setAttribute("ID","EstDat" );
      ((Element)v.get(166)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */

      /* Empieza nodo:176 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(176)).setAttribute("tipo","texto" );
      ((Element)v.get(176)).setAttribute("ID","EstDat" );
      ((Element)v.get(166)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */

      /* Empieza nodo:177 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(177)).setAttribute("tipo","texto" );
      ((Element)v.get(177)).setAttribute("ID","EstDat2" );
      ((Element)v.get(166)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(178)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(178)).setAttribute("nombre","txtUnidadesReclamadasNo" );
      ((Element)v.get(178)).setAttribute("size","7" );
      ((Element)v.get(178)).setAttribute("max","7" );
      ((Element)v.get(178)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(178)).setAttribute("ID","EstDat" );
      ((Element)v.get(166)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */

      /* Empieza nodo:179 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(179)).setAttribute("tipo","texto" );
      ((Element)v.get(179)).setAttribute("ID","EstDat2" );
      ((Element)v.get(166)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */

      /* Empieza nodo:180 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(180)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(180)).setAttribute("nombre","txtUnidadesDevueltasNo" );
      ((Element)v.get(180)).setAttribute("size","7" );
      ((Element)v.get(180)).setAttribute("max","7" );
      ((Element)v.get(180)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(180)).setAttribute("ID","EstDat" );
      ((Element)v.get(166)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(181)).setAttribute("tipo","combo" );
      ((Element)v.get(181)).setAttribute("nombre","cbMotivoDevolucionNo" );
      ((Element)v.get(181)).setAttribute("ID","EstDat2" );
      ((Element)v.get(181)).setAttribute("IDOBJ","EstDatForm" );
      ((Element)v.get(166)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("COL"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(182)).setAttribute("tipo","texto" );
      ((Element)v.get(182)).setAttribute("ID","EstDat" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 181   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(181)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:181   */

      /* Empieza nodo:184 / Elemento padre: 166   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(184)).setAttribute("tipo","texto" );
      ((Element)v.get(184)).setAttribute("ID","EstDat2" );
      ((Element)v.get(166)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:166   */

      /* Empieza nodo:185 / Elemento padre: 122   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(122)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */

      /* Empieza nodo:186 / Elemento padre: 122   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(186)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(186)).setAttribute("ancho","631" );
      ((Element)v.get(186)).setAttribute("sep","$" );
      ((Element)v.get(186)).setAttribute("x","12" );
      ((Element)v.get(186)).setAttribute("class","botonera" );
      ((Element)v.get(186)).setAttribute("y","418" );
      ((Element)v.get(186)).setAttribute("control","|" );
      ((Element)v.get(186)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(186)).setAttribute("rowset","" );
      ((Element)v.get(186)).setAttribute("onload","procesarPaginado(mipgndo, msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(186)).setAttribute("cargainicial","N" );
      ((Element)v.get(122)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(187)).setAttribute("nombre","ret1" );
      ((Element)v.get(187)).setAttribute("x","37" );
      ((Element)v.get(187)).setAttribute("y","422" );
      ((Element)v.get(187)).setAttribute("ID","botonContenido" );
      ((Element)v.get(187)).setAttribute("img","retroceder_on" );
      ((Element)v.get(187)).setAttribute("tipo","0" );
      ((Element)v.get(187)).setAttribute("estado","false" );
      ((Element)v.get(187)).setAttribute("alt","" );
      ((Element)v.get(187)).setAttribute("codigo","" );
      ((Element)v.get(187)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */

      /* Empieza nodo:188 / Elemento padre: 186   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(188)).setAttribute("nombre","ava1" );
      ((Element)v.get(188)).setAttribute("x","52" );
      ((Element)v.get(188)).setAttribute("y","422" );
      ((Element)v.get(188)).setAttribute("ID","botonContenido" );
      ((Element)v.get(188)).setAttribute("img","avanzar_on" );
      ((Element)v.get(188)).setAttribute("tipo","0" );
      ((Element)v.get(188)).setAttribute("estado","false" );
      ((Element)v.get(188)).setAttribute("alt","" );
      ((Element)v.get(188)).setAttribute("codigo","" );
      ((Element)v.get(188)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(186)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:186   */
      /* Termina nodo:122   */

      /* Empieza nodo:189 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(189)).setAttribute("nombre","primera1" );
      ((Element)v.get(189)).setAttribute("x","20" );
      ((Element)v.get(189)).setAttribute("y","422" );
      ((Element)v.get(189)).setAttribute("ID","botonContenido" );
      ((Element)v.get(189)).setAttribute("img","primera_on" );
      ((Element)v.get(189)).setAttribute("tipo","-2" );
      ((Element)v.get(189)).setAttribute("estado","false" );
      ((Element)v.get(189)).setAttribute("alt","" );
      ((Element)v.get(189)).setAttribute("codigo","" );
      ((Element)v.get(189)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(9)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */

      /* Empieza nodo:190 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(190)).setAttribute("nombre","separa" );
      ((Element)v.get(190)).setAttribute("x","59" );
      ((Element)v.get(190)).setAttribute("y","418" );
      ((Element)v.get(190)).setAttribute("ID","botonContenido" );
      ((Element)v.get(190)).setAttribute("img","separa_base" );
      ((Element)v.get(190)).setAttribute("tipo","0" );
      ((Element)v.get(190)).setAttribute("estado","false" );
      ((Element)v.get(190)).setAttribute("alt","" );
      ((Element)v.get(190)).setAttribute("codigo","" );
      ((Element)v.get(190)).setAttribute("accion","" );
      ((Element)v.get(9)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */

      /* Empieza nodo:191 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(191)).setAttribute("nombre","Anadir1" );
      ((Element)v.get(191)).setAttribute("x","80" );
      ((Element)v.get(191)).setAttribute("y","419" );
      ((Element)v.get(191)).setAttribute("ID","botonContenido" );
      ((Element)v.get(191)).setAttribute("ontab","document.all['Aceptar'].focus();" );
      ((Element)v.get(191)).setAttribute("onshtab","document.all['btnBuscar'].focus();" );
      ((Element)v.get(191)).setAttribute("accion","onCLickAdd()" );
      ((Element)v.get(191)).setAttribute("tipo","html" );
      ((Element)v.get(191)).setAttribute("estado","false" );
      ((Element)v.get(191)).setAttribute("cod","404" );
      ((Element)v.get(9)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */

      /* Empieza nodo:192 / Elemento padre: 9   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(192)).setAttribute("nombre","listadoAux" );
      ((Element)v.get(192)).setAttribute("ancho","631" );
      ((Element)v.get(192)).setAttribute("alto","317" );
      ((Element)v.get(192)).setAttribute("x","12" );
      ((Element)v.get(192)).setAttribute("y","465" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(192)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(192)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(9)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(193)).setAttribute("precarga","S" );
      ((Element)v.get(193)).setAttribute("conROver","S" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(194)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(194)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(194)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(194)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */

      /* Empieza nodo:195 / Elemento padre: 193   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(195)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(195)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(195)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(195)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(193)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */

      /* Empieza nodo:196 / Elemento padre: 193   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(196)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(196)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(193)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:193   */

      /* Empieza nodo:197 / Elemento padre: 192   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(192)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(198)).setAttribute("borde","1" );
      ((Element)v.get(198)).setAttribute("horizDatos","1" );
      ((Element)v.get(198)).setAttribute("horizCabecera","1" );
      ((Element)v.get(198)).setAttribute("vertical","1" );
      ((Element)v.get(198)).setAttribute("horizTitulo","1" );
      ((Element)v.get(198)).setAttribute("horizBase","1" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */

      /* Empieza nodo:199 / Elemento padre: 197   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(199)).setAttribute("borde","#999999" );
      ((Element)v.get(199)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(199)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(199)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(199)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(199)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(199)).setAttribute("horizBase","#999999" );
      ((Element)v.get(197)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:197   */

      /* Empieza nodo:200 / Elemento padre: 192   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(200)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(200)).setAttribute("alto","22" );
      ((Element)v.get(200)).setAttribute("imgFondo","" );
      ((Element)v.get(200)).setAttribute("cod","00499" );
      ((Element)v.get(200)).setAttribute("ID","datosTitle" );
      ((Element)v.get(192)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */

      /* Empieza nodo:201 / Elemento padre: 192   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(201)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(201)).setAttribute("alto","22" );
      ((Element)v.get(201)).setAttribute("imgFondo","" );
      ((Element)v.get(192)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */

      /* Empieza nodo:202 / Elemento padre: 192   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(202)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(202)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(202)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(202)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(202)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(202)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(192)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(203)).setAttribute("ancho","150" );
      ((Element)v.get(203)).setAttribute("minimizable","S" );
      ((Element)v.get(203)).setAttribute("minimizada","N" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */

      /* Empieza nodo:204 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(204)).setAttribute("ancho","100" );
      ((Element)v.get(204)).setAttribute("minimizable","S" );
      ((Element)v.get(204)).setAttribute("minimizada","N" );
      ((Element)v.get(202)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */

      /* Empieza nodo:205 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(205)).setAttribute("ancho","100" );
      ((Element)v.get(205)).setAttribute("minimizable","S" );
      ((Element)v.get(205)).setAttribute("minimizada","N" );
      ((Element)v.get(202)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */

      /* Empieza nodo:206 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(206)).setAttribute("ancho","100" );
      ((Element)v.get(206)).setAttribute("minimizable","S" );
      ((Element)v.get(206)).setAttribute("minimizada","N" );
      ((Element)v.get(202)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */

      /* Empieza nodo:207 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(207)).setAttribute("ancho","100" );
      ((Element)v.get(207)).setAttribute("minimizable","S" );
      ((Element)v.get(207)).setAttribute("minimizada","N" );
      ((Element)v.get(202)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */

      /* Empieza nodo:208 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(208)).setAttribute("ancho","130" );
      ((Element)v.get(208)).setAttribute("minimizable","S" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(208)).setAttribute("minimizada","N" );
      ((Element)v.get(202)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */

      /* Empieza nodo:209 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(209)).setAttribute("ancho","130" );
      ((Element)v.get(209)).setAttribute("minimizable","S" );
      ((Element)v.get(209)).setAttribute("minimizada","N" );
      ((Element)v.get(209)).setAttribute("oculta","S" );
      ((Element)v.get(202)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */

      /* Empieza nodo:210 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(210)).setAttribute("ancho","130" );
      ((Element)v.get(210)).setAttribute("minimizable","S" );
      ((Element)v.get(210)).setAttribute("minimizada","N" );
      ((Element)v.get(210)).setAttribute("oculta","S" );
      ((Element)v.get(202)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */

      /* Empieza nodo:211 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(211)).setAttribute("ancho","130" );
      ((Element)v.get(211)).setAttribute("minimizable","S" );
      ((Element)v.get(211)).setAttribute("minimizada","N" );
      ((Element)v.get(211)).setAttribute("oculta","S" );
      ((Element)v.get(202)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */

      /* Empieza nodo:212 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(212)).setAttribute("ancho","130" );
      ((Element)v.get(212)).setAttribute("minimizable","S" );
      ((Element)v.get(212)).setAttribute("minimizada","N" );
      ((Element)v.get(212)).setAttribute("oculta","S" );
      ((Element)v.get(202)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */

      /* Empieza nodo:213 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(213)).setAttribute("ancho","130" );
      ((Element)v.get(213)).setAttribute("minimizable","S" );
      ((Element)v.get(213)).setAttribute("minimizada","N" );
      ((Element)v.get(213)).setAttribute("oculta","S" );
      ((Element)v.get(202)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */

      /* Empieza nodo:214 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(214)).setAttribute("ancho","150" );
      ((Element)v.get(214)).setAttribute("minimizable","S" );
      ((Element)v.get(214)).setAttribute("minimizada","N" );
      ((Element)v.get(202)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */

      /* Empieza nodo:215 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(215)).setAttribute("ancho","100" );
      ((Element)v.get(215)).setAttribute("minimizable","S" );
      ((Element)v.get(215)).setAttribute("minimizada","N" );
      ((Element)v.get(202)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */

      /* Empieza nodo:216 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(216)).setAttribute("ancho","130" );
      ((Element)v.get(216)).setAttribute("minimizable","S" );
      ((Element)v.get(216)).setAttribute("minimizada","N" );
      ((Element)v.get(202)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */

      /* Empieza nodo:217 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(217)).setAttribute("ancho","130" );
      ((Element)v.get(217)).setAttribute("minimizable","S" );
      ((Element)v.get(217)).setAttribute("minimizada","N" );
      ((Element)v.get(202)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */

      /* Empieza nodo:218 / Elemento padre: 202   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(218)).setAttribute("ancho","130" );
      ((Element)v.get(218)).setAttribute("minimizable","S" );
      ((Element)v.get(218)).setAttribute("minimizada","N" );
      ((Element)v.get(218)).setAttribute("oculta","S" );
      ((Element)v.get(202)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:202   */

      /* Empieza nodo:219 / Elemento padre: 192   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(219)).setAttribute("alto","20" );
      ((Element)v.get(219)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(219)).setAttribute("imgFondo","" );
      ((Element)v.get(219)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(192)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(220)).setAttribute("colFondo","" );
      ((Element)v.get(220)).setAttribute("ID","EstCab" );
      ((Element)v.get(220)).setAttribute("cod","338" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */

      /* Empieza nodo:221 / Elemento padre: 219   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(221)).setAttribute("colFondo","" );
      ((Element)v.get(221)).setAttribute("ID","EstCab" );
      ((Element)v.get(221)).setAttribute("cod","276" );
      ((Element)v.get(219)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */

      /* Empieza nodo:222 / Elemento padre: 219   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(222)).setAttribute("colFondo","" );
      ((Element)v.get(222)).setAttribute("ID","EstCab" );
      ((Element)v.get(222)).setAttribute("cod","465" );
      ((Element)v.get(219)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */

      /* Empieza nodo:223 / Elemento padre: 219   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(223)).setAttribute("colFondo","" );
      ((Element)v.get(223)).setAttribute("ID","EstCab" );
      ((Element)v.get(223)).setAttribute("cod","336" );
      ((Element)v.get(219)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */

      /* Empieza nodo:224 / Elemento padre: 219   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(224)).setAttribute("colFondo","" );
      ((Element)v.get(224)).setAttribute("ID","EstCab" );
      ((Element)v.get(224)).setAttribute("cod","337" );
      ((Element)v.get(219)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */

      /* Empieza nodo:225 / Elemento padre: 219   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(225)).setAttribute("colFondo","" );
      ((Element)v.get(225)).setAttribute("ID","EstCab" );
      ((Element)v.get(225)).setAttribute("cod","530" );
      ((Element)v.get(219)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */

      /* Empieza nodo:226 / Elemento padre: 219   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(226)).setAttribute("colFondo","" );
      ((Element)v.get(226)).setAttribute("ID","EstCab" );
      ((Element)v.get(226)).setAttribute("cod","302" );
      ((Element)v.get(219)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */

      /* Empieza nodo:227 / Elemento padre: 219   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(227)).setAttribute("colFondo","" );
      ((Element)v.get(227)).setAttribute("ID","EstCab" );
      ((Element)v.get(227)).setAttribute("cod","302" );
      ((Element)v.get(219)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */

      /* Empieza nodo:228 / Elemento padre: 219   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(228)).setAttribute("colFondo","" );
      ((Element)v.get(228)).setAttribute("ID","EstCab" );
      ((Element)v.get(228)).setAttribute("cod","302" );
      ((Element)v.get(219)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */

      /* Empieza nodo:229 / Elemento padre: 219   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(229)).setAttribute("colFondo","" );
      ((Element)v.get(229)).setAttribute("ID","EstCab" );
      ((Element)v.get(229)).setAttribute("cod","302" );
      ((Element)v.get(219)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */

      /* Empieza nodo:230 / Elemento padre: 219   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(230)).setAttribute("colFondo","" );
      ((Element)v.get(230)).setAttribute("ID","EstCab" );
      ((Element)v.get(230)).setAttribute("cod","302" );
      ((Element)v.get(219)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */

      /* Empieza nodo:231 / Elemento padre: 219   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(231)).setAttribute("colFondo","" );
      ((Element)v.get(231)).setAttribute("ID","EstCab" );
      ((Element)v.get(231)).setAttribute("cod","506" );
      ((Element)v.get(219)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */

      /* Empieza nodo:232 / Elemento padre: 219   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(232)).setAttribute("colFondo","" );
      ((Element)v.get(232)).setAttribute("ID","EstCab" );
      ((Element)v.get(232)).setAttribute("cod","2492" );
      ((Element)v.get(219)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */

      /* Empieza nodo:233 / Elemento padre: 219   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(233)).setAttribute("colFondo","" );
      ((Element)v.get(233)).setAttribute("ID","EstCab" );
      ((Element)v.get(233)).setAttribute("cod","309" );
      ((Element)v.get(219)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */

      /* Empieza nodo:234 / Elemento padre: 219   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(234)).setAttribute("colFondo","" );
      ((Element)v.get(234)).setAttribute("ID","EstCab" );
      ((Element)v.get(234)).setAttribute("cod","302" );
      ((Element)v.get(219)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */

      /* Empieza nodo:235 / Elemento padre: 219   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(235)).setAttribute("colFondo","" );
      ((Element)v.get(235)).setAttribute("ID","EstCab" );
      ((Element)v.get(235)).setAttribute("cod","302" );
      ((Element)v.get(219)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:219   */

      /* Empieza nodo:236 / Elemento padre: 192   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(236)).setAttribute("alto","22" );
      ((Element)v.get(236)).setAttribute("accion","" );
      ((Element)v.get(236)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(236)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(236)).setAttribute("maxSel","-1" );
      ((Element)v.get(236)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(236)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(236)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(236)).setAttribute("onLoad","" );
      ((Element)v.get(236)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(192)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(237)).setAttribute("tipo","texto" );
      ((Element)v.get(237)).setAttribute("ID","EstDat2" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */

      /* Empieza nodo:238 / Elemento padre: 236   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(238)).setAttribute("tipo","texto" );
      ((Element)v.get(238)).setAttribute("ID","EstDat" );
      ((Element)v.get(236)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */

      /* Empieza nodo:239 / Elemento padre: 236   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(239)).setAttribute("tipo","texto" );
      ((Element)v.get(239)).setAttribute("ID","EstDat2" );
      ((Element)v.get(236)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */

      /* Empieza nodo:240 / Elemento padre: 236   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(240)).setAttribute("tipo","texto" );
      ((Element)v.get(240)).setAttribute("ID","EstDat" );
      ((Element)v.get(236)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */

      /* Empieza nodo:241 / Elemento padre: 236   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(241)).setAttribute("tipo","texto" );
      ((Element)v.get(241)).setAttribute("ID","EstDat2" );
      ((Element)v.get(236)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */

      /* Empieza nodo:242 / Elemento padre: 236   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(242)).setAttribute("tipo","texto" );
      ((Element)v.get(242)).setAttribute("ID","EstDat" );
      ((Element)v.get(236)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */

      /* Empieza nodo:243 / Elemento padre: 236   */
   }

   private void getXML1170(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(243)).setAttribute("tipo","texto" );
      ((Element)v.get(243)).setAttribute("ID","EstDat" );
      ((Element)v.get(236)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */

      /* Empieza nodo:244 / Elemento padre: 236   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(244)).setAttribute("tipo","texto" );
      ((Element)v.get(244)).setAttribute("ID","EstDat" );
      ((Element)v.get(236)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */

      /* Empieza nodo:245 / Elemento padre: 236   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(245)).setAttribute("tipo","texto" );
      ((Element)v.get(245)).setAttribute("ID","EstDat" );
      ((Element)v.get(236)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */

      /* Empieza nodo:246 / Elemento padre: 236   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(246)).setAttribute("tipo","texto" );
      ((Element)v.get(246)).setAttribute("ID","EstDat" );
      ((Element)v.get(236)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */

      /* Empieza nodo:247 / Elemento padre: 236   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(247)).setAttribute("tipo","texto" );
      ((Element)v.get(247)).setAttribute("ID","EstDat" );
      ((Element)v.get(236)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */

      /* Empieza nodo:248 / Elemento padre: 236   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(248)).setAttribute("tipo","texto" );
      ((Element)v.get(248)).setAttribute("ID","EstDat2" );
      ((Element)v.get(236)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */

      /* Empieza nodo:249 / Elemento padre: 236   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(249)).setAttribute("tipo","texto" );
      ((Element)v.get(249)).setAttribute("ID","EstDat" );
      ((Element)v.get(236)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */

      /* Empieza nodo:250 / Elemento padre: 236   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(250)).setAttribute("tipo","texto" );
      ((Element)v.get(250)).setAttribute("ID","EstDat2" );
      ((Element)v.get(236)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */

      /* Empieza nodo:251 / Elemento padre: 236   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(251)).setAttribute("tipo","texto" );
      ((Element)v.get(251)).setAttribute("ID","EstDat" );
      ((Element)v.get(236)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */

      /* Empieza nodo:252 / Elemento padre: 236   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(252)).setAttribute("tipo","texto" );
      ((Element)v.get(252)).setAttribute("ID","EstDat2" );
      ((Element)v.get(236)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:236   */

      /* Empieza nodo:253 / Elemento padre: 192   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(192)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:192   */

      /* Empieza nodo:254 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(254)).setAttribute("nombre","Aceptar" );
      ((Element)v.get(254)).setAttribute("x","13" );
      ((Element)v.get(254)).setAttribute("y","760" );
      ((Element)v.get(254)).setAttribute("ID","botonContenido" );
      ((Element)v.get(254)).setAttribute("onshtab","document.all['Anadir1'].focus();" );
      ((Element)v.get(254)).setAttribute("accion","aceptarDevuelveNo()" );
      ((Element)v.get(254)).setAttribute("tipo","html" );
      ((Element)v.get(254)).setAttribute("estado","false" );
      ((Element)v.get(254)).setAttribute("cod","12" );
      ((Element)v.get(9)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */

      /* Empieza nodo:255 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(255)).setAttribute("nombre","Eliminar" );
      ((Element)v.get(255)).setAttribute("x","71" );
      ((Element)v.get(255)).setAttribute("y","760" );
      ((Element)v.get(255)).setAttribute("ID","botonContenido" );
      ((Element)v.get(255)).setAttribute("ontab","focaliza(FORMULARIO + '.txtDescripcion')" );
      ((Element)v.get(255)).setAttribute("accion","onClickEliminar();" );
      ((Element)v.get(255)).setAttribute("tipo","html" );
      ((Element)v.get(255)).setAttribute("estado","false" );
      ((Element)v.get(255)).setAttribute("cod","1254" );
      ((Element)v.get(9)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */

      /* Empieza nodo:256 / Elemento padre: 9   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(256)).setAttribute("nombre","listado2" );
      ((Element)v.get(256)).setAttribute("ancho","631" );
      ((Element)v.get(256)).setAttribute("alto","317" );
      ((Element)v.get(256)).setAttribute("x","12" );
      ((Element)v.get(256)).setAttribute("y","12" );
      ((Element)v.get(256)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(256)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(9)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(257)).setAttribute("precarga","S" );
      ((Element)v.get(257)).setAttribute("conROver","S" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(258)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(258)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(258)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(258)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */

      /* Empieza nodo:259 / Elemento padre: 257   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(259)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(259)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(259)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(259)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(257)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */

      /* Empieza nodo:260 / Elemento padre: 257   */
      v.add(doc.createElement("BTNORDENAR"));
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(260)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(260)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(257)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:257   */

      /* Empieza nodo:261 / Elemento padre: 256   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(256)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(262)).setAttribute("borde","1" );
      ((Element)v.get(262)).setAttribute("horizDatos","1" );
      ((Element)v.get(262)).setAttribute("horizCabecera","1" );
      ((Element)v.get(262)).setAttribute("vertical","1" );
      ((Element)v.get(262)).setAttribute("horizTitulo","1" );
      ((Element)v.get(262)).setAttribute("horizBase","1" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */

      /* Empieza nodo:263 / Elemento padre: 261   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(263)).setAttribute("borde","#999999" );
      ((Element)v.get(263)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(263)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(263)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(263)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(263)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(263)).setAttribute("horizBase","#999999" );
      ((Element)v.get(261)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:261   */

      /* Empieza nodo:264 / Elemento padre: 256   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(264)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(264)).setAttribute("alto","22" );
      ((Element)v.get(264)).setAttribute("imgFondo","" );
      ((Element)v.get(264)).setAttribute("cod","00105" );
      ((Element)v.get(264)).setAttribute("ID","datosTitle" );
      ((Element)v.get(256)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */

      /* Empieza nodo:265 / Elemento padre: 256   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(265)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(265)).setAttribute("alto","22" );
      ((Element)v.get(265)).setAttribute("imgFondo","" );
      ((Element)v.get(256)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */

      /* Empieza nodo:266 / Elemento padre: 256   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(266)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(266)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(266)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(266)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(266)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(266)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(256)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(267)).setAttribute("ancho","130" );
      ((Element)v.get(267)).setAttribute("minimizable","S" );
      ((Element)v.get(267)).setAttribute("minimizada","N" );
      ((Element)v.get(267)).setAttribute("oculta","S" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */

      /* Empieza nodo:268 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(268)).setAttribute("ancho","100" );
      ((Element)v.get(268)).setAttribute("minimizable","S" );
      ((Element)v.get(268)).setAttribute("minimizada","N" );
      ((Element)v.get(266)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */

      /* Empieza nodo:269 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(269)).setAttribute("ancho","130" );
      ((Element)v.get(269)).setAttribute("minimizable","S" );
      ((Element)v.get(269)).setAttribute("minimizada","N" );
      ((Element)v.get(266)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */

      /* Empieza nodo:270 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(270)).setAttribute("ancho","130" );
      ((Element)v.get(270)).setAttribute("minimizable","S" );
      ((Element)v.get(270)).setAttribute("minimizada","N" );
      ((Element)v.get(270)).setAttribute("oculta","S" );
      ((Element)v.get(266)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */

      /* Empieza nodo:271 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(271)).setAttribute("ancho","100" );
      ((Element)v.get(271)).setAttribute("minimizable","S" );
      ((Element)v.get(271)).setAttribute("minimizada","N" );
      ((Element)v.get(271)).setAttribute("oculta","S" );
      ((Element)v.get(266)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */

      /* Empieza nodo:272 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(272)).setAttribute("ancho","100" );
      ((Element)v.get(272)).setAttribute("minimizable","S" );
      ((Element)v.get(272)).setAttribute("minimizada","N" );
      ((Element)v.get(266)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */

      /* Empieza nodo:273 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(273)).setAttribute("ancho","150" );
      ((Element)v.get(273)).setAttribute("minimizable","S" );
      ((Element)v.get(273)).setAttribute("minimizada","N" );
      ((Element)v.get(266)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */

      /* Empieza nodo:274 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(274)).setAttribute("ancho","150" );
      ((Element)v.get(274)).setAttribute("minimizable","S" );
      ((Element)v.get(274)).setAttribute("minimizada","N" );
      ((Element)v.get(266)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */

      /* Empieza nodo:275 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(275)).setAttribute("ancho","100" );
      ((Element)v.get(275)).setAttribute("minimizable","S" );
      ((Element)v.get(275)).setAttribute("minimizada","N" );
      ((Element)v.get(266)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */

      /* Empieza nodo:276 / Elemento padre: 266   */
   }

   private void getXML1350(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(276)).setAttribute("ancho","150" );
      ((Element)v.get(276)).setAttribute("minimizable","S" );
      ((Element)v.get(276)).setAttribute("minimizada","N" );
      ((Element)v.get(266)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */

      /* Empieza nodo:277 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(277)).setAttribute("ancho","130" );
      ((Element)v.get(277)).setAttribute("minimizable","S" );
      ((Element)v.get(277)).setAttribute("minimizada","N" );
      ((Element)v.get(266)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */

      /* Empieza nodo:278 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(278)).setAttribute("ancho","150" );
      ((Element)v.get(278)).setAttribute("minimizable","S" );
      ((Element)v.get(278)).setAttribute("minimizada","N" );
      ((Element)v.get(266)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */

      /* Empieza nodo:279 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(279)).setAttribute("ancho","150" );
      ((Element)v.get(279)).setAttribute("minimizable","S" );
      ((Element)v.get(279)).setAttribute("minimizada","N" );
      ((Element)v.get(266)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */

      /* Empieza nodo:280 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(280)).setAttribute("ancho","130" );
      ((Element)v.get(280)).setAttribute("minimizable","S" );
      ((Element)v.get(280)).setAttribute("minimizada","N" );
      ((Element)v.get(266)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */

      /* Empieza nodo:281 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(281)).setAttribute("ancho","130" );
      ((Element)v.get(281)).setAttribute("minimizable","S" );
      ((Element)v.get(281)).setAttribute("minimizada","N" );
      ((Element)v.get(281)).setAttribute("oculta","S" );
      ((Element)v.get(266)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */

      /* Empieza nodo:282 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(282)).setAttribute("ancho","130" );
      ((Element)v.get(282)).setAttribute("minimizable","S" );
      ((Element)v.get(282)).setAttribute("minimizada","N" );
      ((Element)v.get(282)).setAttribute("oculta","S" );
      ((Element)v.get(266)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */

      /* Empieza nodo:283 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(283)).setAttribute("ancho","130" );
      ((Element)v.get(283)).setAttribute("minimizable","S" );
      ((Element)v.get(283)).setAttribute("minimizada","N" );
      ((Element)v.get(283)).setAttribute("oculta","S" );
      ((Element)v.get(266)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */

      /* Empieza nodo:284 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(284)).setAttribute("ancho","130" );
      ((Element)v.get(284)).setAttribute("minimizable","S" );
      ((Element)v.get(284)).setAttribute("minimizada","N" );
      ((Element)v.get(266)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */

      /* Empieza nodo:285 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(285)).setAttribute("ancho","130" );
      ((Element)v.get(285)).setAttribute("minimizable","S" );
      ((Element)v.get(285)).setAttribute("minimizada","N" );
      ((Element)v.get(266)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */

      /* Empieza nodo:286 / Elemento padre: 266   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(286)).setAttribute("ancho","130" );
      ((Element)v.get(286)).setAttribute("minimizable","S" );
      ((Element)v.get(286)).setAttribute("minimizada","N" );
      ((Element)v.get(266)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:266   */

      /* Empieza nodo:287 / Elemento padre: 256   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(287)).setAttribute("alto","20" );
      ((Element)v.get(287)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(287)).setAttribute("imgFondo","" );
      ((Element)v.get(287)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(256)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(288)).setAttribute("colFondo","" );
      ((Element)v.get(288)).setAttribute("ID","EstCab" );
      ((Element)v.get(288)).setAttribute("cod","302" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */

      /* Empieza nodo:289 / Elemento padre: 287   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(289)).setAttribute("colFondo","" );
      ((Element)v.get(289)).setAttribute("ID","EstCab" );
      ((Element)v.get(289)).setAttribute("cod","338" );
      ((Element)v.get(287)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */

      /* Empieza nodo:290 / Elemento padre: 287   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(290)).setAttribute("colFondo","" );
      ((Element)v.get(290)).setAttribute("ID","EstCab" );
      ((Element)v.get(290)).setAttribute("cod","276" );
      ((Element)v.get(287)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */

      /* Empieza nodo:291 / Elemento padre: 287   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(291)).setAttribute("colFondo","" );
      ((Element)v.get(291)).setAttribute("ID","EstCab" );
      ((Element)v.get(291)).setAttribute("cod","302" );
      ((Element)v.get(287)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */

      /* Empieza nodo:292 / Elemento padre: 287   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(292)).setAttribute("colFondo","" );
      ((Element)v.get(292)).setAttribute("ID","EstCab" );
      ((Element)v.get(292)).setAttribute("cod","302" );
      ((Element)v.get(287)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */

      /* Empieza nodo:293 / Elemento padre: 287   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(293)).setAttribute("colFondo","" );
      ((Element)v.get(293)).setAttribute("ID","EstCab" );
      ((Element)v.get(293)).setAttribute("cod","465" );
      ((Element)v.get(287)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */

      /* Empieza nodo:294 / Elemento padre: 287   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(294)).setAttribute("colFondo","" );
      ((Element)v.get(294)).setAttribute("ID","EstCab" );
      ((Element)v.get(294)).setAttribute("cod","336" );
      ((Element)v.get(287)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */

      /* Empieza nodo:295 / Elemento padre: 287   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(295)).setAttribute("colFondo","" );
      ((Element)v.get(295)).setAttribute("ID","EstCab" );
      ((Element)v.get(295)).setAttribute("cod","337" );
      ((Element)v.get(287)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */

      /* Empieza nodo:296 / Elemento padre: 287   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(296)).setAttribute("colFondo","" );
      ((Element)v.get(296)).setAttribute("ID","EstCab" );
      ((Element)v.get(296)).setAttribute("cod","2354" );
      ((Element)v.get(287)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */

      /* Empieza nodo:297 / Elemento padre: 287   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(297)).setAttribute("colFondo","" );
      ((Element)v.get(297)).setAttribute("ID","EstCab" );
      ((Element)v.get(297)).setAttribute("cod","341" );
      ((Element)v.get(287)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */

      /* Empieza nodo:298 / Elemento padre: 287   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(298)).setAttribute("colFondo","" );
      ((Element)v.get(298)).setAttribute("ID","EstCab" );
      ((Element)v.get(298)).setAttribute("cod","2356" );
      ((Element)v.get(287)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */

      /* Empieza nodo:299 / Elemento padre: 287   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(299)).setAttribute("colFondo","" );
      ((Element)v.get(299)).setAttribute("ID","EstCab" );
      ((Element)v.get(299)).setAttribute("cod","504" );
      ((Element)v.get(287)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */

      /* Empieza nodo:300 / Elemento padre: 287   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(300)).setAttribute("colFondo","" );
      ((Element)v.get(300)).setAttribute("ID","EstCab" );
      ((Element)v.get(300)).setAttribute("cod","339" );
      ((Element)v.get(287)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */

      /* Empieza nodo:301 / Elemento padre: 287   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(301)).setAttribute("colFondo","" );
      ((Element)v.get(301)).setAttribute("ID","EstCab" );
      ((Element)v.get(301)).setAttribute("cod","1011" );
      ((Element)v.get(287)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */

      /* Empieza nodo:302 / Elemento padre: 287   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(302)).setAttribute("colFondo","" );
      ((Element)v.get(302)).setAttribute("ID","EstCab" );
      ((Element)v.get(302)).setAttribute("cod","506" );
      ((Element)v.get(287)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */

      /* Empieza nodo:303 / Elemento padre: 287   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(303)).setAttribute("colFondo","" );
      ((Element)v.get(303)).setAttribute("ID","EstCab" );
      ((Element)v.get(303)).setAttribute("cod","309" );
      ((Element)v.get(287)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */

      /* Empieza nodo:304 / Elemento padre: 287   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(304)).setAttribute("colFondo","" );
      ((Element)v.get(304)).setAttribute("ID","EstCab" );
      ((Element)v.get(304)).setAttribute("cod","302" );
      ((Element)v.get(287)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */

      /* Empieza nodo:305 / Elemento padre: 287   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(305)).setAttribute("colFondo","" );
      ((Element)v.get(305)).setAttribute("ID","EstCab" );
      ((Element)v.get(305)).setAttribute("cod","309" );
      ((Element)v.get(287)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */

      /* Empieza nodo:306 / Elemento padre: 287   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(306)).setAttribute("colFondo","" );
      ((Element)v.get(306)).setAttribute("ID","EstCab" );
      ((Element)v.get(306)).setAttribute("cod","309" );
      ((Element)v.get(287)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */

      /* Empieza nodo:307 / Elemento padre: 287   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(307)).setAttribute("colFondo","" );
      ((Element)v.get(307)).setAttribute("ID","EstCab" );
      ((Element)v.get(307)).setAttribute("cod","309" );
      ((Element)v.get(287)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:287   */

      /* Empieza nodo:308 / Elemento padre: 256   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(308)).setAttribute("alto","22" );
      ((Element)v.get(308)).setAttribute("accion","" );
      ((Element)v.get(308)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(308)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(308)).setAttribute("maxSel","-1" );
      ((Element)v.get(308)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(308)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(308)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(308)).setAttribute("onLoad","" );
      ((Element)v.get(308)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(256)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(309)).setAttribute("tipo","texto" );
      ((Element)v.get(309)).setAttribute("ID","EstDat" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */

      /* Empieza nodo:310 / Elemento padre: 308   */
   }

   private void getXML1530(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(310)).setAttribute("tipo","texto" );
      ((Element)v.get(310)).setAttribute("ID","EstDat2" );
      ((Element)v.get(308)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */

      /* Empieza nodo:311 / Elemento padre: 308   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(311)).setAttribute("tipo","texto" );
      ((Element)v.get(311)).setAttribute("ID","EstDat" );
      ((Element)v.get(308)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */

      /* Empieza nodo:312 / Elemento padre: 308   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(312)).setAttribute("tipo","texto" );
      ((Element)v.get(312)).setAttribute("ID","EstDat2" );
      ((Element)v.get(308)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */

      /* Empieza nodo:313 / Elemento padre: 308   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(313)).setAttribute("tipo","texto" );
      ((Element)v.get(313)).setAttribute("ID","EstDat2" );
      ((Element)v.get(308)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */

      /* Empieza nodo:314 / Elemento padre: 308   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(314)).setAttribute("tipo","texto" );
      ((Element)v.get(314)).setAttribute("ID","EstDat" );
      ((Element)v.get(308)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */

      /* Empieza nodo:315 / Elemento padre: 308   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(315)).setAttribute("tipo","texto" );
      ((Element)v.get(315)).setAttribute("ID","EstDat2" );
      ((Element)v.get(308)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */

      /* Empieza nodo:316 / Elemento padre: 308   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(316)).setAttribute("tipo","texto" );
      ((Element)v.get(316)).setAttribute("ID","EstDat" );
      ((Element)v.get(308)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */

      /* Empieza nodo:317 / Elemento padre: 308   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(317)).setAttribute("tipo","texto" );
      ((Element)v.get(317)).setAttribute("ID","EstDat2" );
      ((Element)v.get(308)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */

      /* Empieza nodo:318 / Elemento padre: 308   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(318)).setAttribute("tipo","texto" );
      ((Element)v.get(318)).setAttribute("ID","EstDat" );
      ((Element)v.get(308)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */

      /* Empieza nodo:319 / Elemento padre: 308   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(319)).setAttribute("tipo","texto" );
      ((Element)v.get(319)).setAttribute("ID","EstDat2" );
      ((Element)v.get(308)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */

      /* Empieza nodo:320 / Elemento padre: 308   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(320)).setAttribute("tipo","texto" );
      ((Element)v.get(320)).setAttribute("ID","EstDat" );
      ((Element)v.get(308)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */

      /* Empieza nodo:321 / Elemento padre: 308   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(321)).setAttribute("tipo","texto" );
      ((Element)v.get(321)).setAttribute("ID","EstDat2" );
      ((Element)v.get(308)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */

      /* Empieza nodo:322 / Elemento padre: 308   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(322)).setAttribute("tipo","texto" );
      ((Element)v.get(322)).setAttribute("ID","EstDat2" );
      ((Element)v.get(308)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */

      /* Empieza nodo:323 / Elemento padre: 308   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(323)).setAttribute("tipo","texto" );
      ((Element)v.get(323)).setAttribute("ID","EstDat" );
      ((Element)v.get(308)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */

      /* Empieza nodo:324 / Elemento padre: 308   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(324)).setAttribute("tipo","texto" );
      ((Element)v.get(324)).setAttribute("ID","EstDat2" );
      ((Element)v.get(308)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */

      /* Empieza nodo:325 / Elemento padre: 308   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(325)).setAttribute("tipo","texto" );
      ((Element)v.get(325)).setAttribute("ID","EstDat" );
      ((Element)v.get(308)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */

      /* Empieza nodo:326 / Elemento padre: 308   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(326)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(326)).setAttribute("nombre","txtUnidadesReclamadasSi" );
      ((Element)v.get(326)).setAttribute("size","7" );
      ((Element)v.get(326)).setAttribute("max","7" );
      ((Element)v.get(326)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(326)).setAttribute("ID","EstDat" );
      ((Element)v.get(308)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */

      /* Empieza nodo:327 / Elemento padre: 308   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(327)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(327)).setAttribute("nombre","txtUnidadesDevueltasSi" );
      ((Element)v.get(327)).setAttribute("size","7" );
      ((Element)v.get(327)).setAttribute("max","7" );
      ((Element)v.get(327)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(327)).setAttribute("ID","EstDat2" );
      ((Element)v.get(308)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */

      /* Empieza nodo:328 / Elemento padre: 308   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(328)).setAttribute("tipo","combo" );
      ((Element)v.get(328)).setAttribute("nombre","cbMotivoDevolucionSi" );
      ((Element)v.get(328)).setAttribute("ID","EstDat" );
      ((Element)v.get(328)).setAttribute("IDOBJ","EstDatForm" );
      ((Element)v.get(308)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:328   */
      /* Termina nodo:308   */

      /* Empieza nodo:330 / Elemento padre: 256   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(256)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:256   */

      /* Empieza nodo:331 / Elemento padre: 9   */
   }

   private void getXML1620(Document doc) {
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(331)).setAttribute("nombre","Aceptar2" );
      ((Element)v.get(331)).setAttribute("x","13" );
      ((Element)v.get(331)).setAttribute("y","307" );
      ((Element)v.get(331)).setAttribute("ID","botonContenido" );
      ((Element)v.get(331)).setAttribute("accion","aceptarDevuelveSi()" );
      ((Element)v.get(331)).setAttribute("ontab","document.all['Aceptar2'].focus();" );
      ((Element)v.get(331)).setAttribute("onshtab","document.all['Aceptar2'].focus();" );
      ((Element)v.get(331)).setAttribute("tipo","html" );
      ((Element)v.get(331)).setAttribute("estado","false" );
      ((Element)v.get(331)).setAttribute("cod","12" );
      ((Element)v.get(9)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */

      /* Empieza nodo:332 / Elemento padre: 9   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(332)).setAttribute("nombre","listado3" );
      ((Element)v.get(332)).setAttribute("ancho","631" );
      ((Element)v.get(332)).setAttribute("alto","317" );
      ((Element)v.get(332)).setAttribute("x","12" );
      ((Element)v.get(332)).setAttribute("y","12" );
      ((Element)v.get(332)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(332)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(9)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(333)).setAttribute("precarga","S" );
      ((Element)v.get(333)).setAttribute("conROver","S" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(334)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(334)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(334)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(334)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */

      /* Empieza nodo:335 / Elemento padre: 333   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(335)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(335)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(335)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(335)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(333)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */

      /* Empieza nodo:336 / Elemento padre: 333   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(336)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(336)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(333)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:333   */

      /* Empieza nodo:337 / Elemento padre: 332   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(332)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(338)).setAttribute("borde","1" );
      ((Element)v.get(338)).setAttribute("horizDatos","1" );
      ((Element)v.get(338)).setAttribute("horizCabecera","1" );
      ((Element)v.get(338)).setAttribute("vertical","1" );
      ((Element)v.get(338)).setAttribute("horizTitulo","1" );
      ((Element)v.get(338)).setAttribute("horizBase","1" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */

      /* Empieza nodo:339 / Elemento padre: 337   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(339)).setAttribute("borde","#999999" );
      ((Element)v.get(339)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(339)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(339)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(339)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(339)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(339)).setAttribute("horizBase","#999999" );
      ((Element)v.get(337)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */
      /* Termina nodo:337   */

      /* Empieza nodo:340 / Elemento padre: 332   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(340)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(340)).setAttribute("alto","22" );
      ((Element)v.get(340)).setAttribute("imgFondo","" );
      ((Element)v.get(340)).setAttribute("cod","00105" );
      ((Element)v.get(340)).setAttribute("ID","datosTitle" );
      ((Element)v.get(332)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */

      /* Empieza nodo:341 / Elemento padre: 332   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(341)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(341)).setAttribute("alto","22" );
      ((Element)v.get(341)).setAttribute("imgFondo","" );
      ((Element)v.get(332)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */

      /* Empieza nodo:342 / Elemento padre: 332   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(342)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(342)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(342)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(342)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(342)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(342)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(332)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(343)).setAttribute("ancho","130" );
      ((Element)v.get(343)).setAttribute("minimizable","S" );
      ((Element)v.get(343)).setAttribute("minimizada","N" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */

      /* Empieza nodo:344 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(344)).setAttribute("ancho","100" );
      ((Element)v.get(344)).setAttribute("minimizable","S" );
      ((Element)v.get(344)).setAttribute("minimizada","N" );
      ((Element)v.get(342)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */

      /* Empieza nodo:345 / Elemento padre: 342   */
   }

   private void getXML1710(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(345)).setAttribute("ancho","130" );
      ((Element)v.get(345)).setAttribute("minimizable","S" );
      ((Element)v.get(345)).setAttribute("minimizada","N" );
      ((Element)v.get(345)).setAttribute("oculta","S" );
      ((Element)v.get(342)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */

      /* Empieza nodo:346 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(346)).setAttribute("ancho","130" );
      ((Element)v.get(346)).setAttribute("minimizable","S" );
      ((Element)v.get(346)).setAttribute("minimizada","N" );
      ((Element)v.get(346)).setAttribute("oculta","S" );
      ((Element)v.get(342)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */

      /* Empieza nodo:347 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(347)).setAttribute("ancho","100" );
      ((Element)v.get(347)).setAttribute("minimizable","S" );
      ((Element)v.get(347)).setAttribute("minimizada","N" );
      ((Element)v.get(342)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */

      /* Empieza nodo:348 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(348)).setAttribute("ancho","100" );
      ((Element)v.get(348)).setAttribute("minimizable","S" );
      ((Element)v.get(348)).setAttribute("minimizada","N" );
      ((Element)v.get(342)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */

      /* Empieza nodo:349 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(349)).setAttribute("ancho","100" );
      ((Element)v.get(349)).setAttribute("minimizable","S" );
      ((Element)v.get(349)).setAttribute("minimizada","N" );
      ((Element)v.get(342)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */

      /* Empieza nodo:350 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(350)).setAttribute("ancho","150" );
      ((Element)v.get(350)).setAttribute("minimizable","S" );
      ((Element)v.get(350)).setAttribute("minimizada","N" );
      ((Element)v.get(342)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */

      /* Empieza nodo:351 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(351)).setAttribute("ancho","130" );
      ((Element)v.get(351)).setAttribute("minimizable","S" );
      ((Element)v.get(351)).setAttribute("minimizada","N" );
      ((Element)v.get(342)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */

      /* Empieza nodo:352 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(352)).setAttribute("ancho","150" );
      ((Element)v.get(352)).setAttribute("minimizable","S" );
      ((Element)v.get(352)).setAttribute("minimizada","N" );
      ((Element)v.get(342)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */

      /* Empieza nodo:353 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(353)).setAttribute("ancho","130" );
      ((Element)v.get(353)).setAttribute("minimizable","S" );
      ((Element)v.get(353)).setAttribute("minimizada","N" );
      ((Element)v.get(353)).setAttribute("oculta","S" );
      ((Element)v.get(342)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */

      /* Empieza nodo:354 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(354)).setAttribute("ancho","130" );
      ((Element)v.get(354)).setAttribute("minimizable","S" );
      ((Element)v.get(354)).setAttribute("minimizada","N" );
      ((Element)v.get(354)).setAttribute("oculta","S" );
      ((Element)v.get(342)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */

      /* Empieza nodo:355 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(355)).setAttribute("ancho","130" );
      ((Element)v.get(355)).setAttribute("minimizable","S" );
      ((Element)v.get(355)).setAttribute("minimizada","N" );
      ((Element)v.get(355)).setAttribute("oculta","S" );
      ((Element)v.get(342)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */

      /* Empieza nodo:356 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(356)).setAttribute("ancho","130" );
      ((Element)v.get(356)).setAttribute("minimizable","S" );
      ((Element)v.get(356)).setAttribute("minimizada","N" );
      ((Element)v.get(356)).setAttribute("oculta","S" );
      ((Element)v.get(342)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */

      /* Empieza nodo:357 / Elemento padre: 342   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(357)).setAttribute("ancho","130" );
      ((Element)v.get(357)).setAttribute("minimizable","S" );
      ((Element)v.get(357)).setAttribute("minimizada","N" );
      ((Element)v.get(342)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:342   */

      /* Empieza nodo:358 / Elemento padre: 332   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(358)).setAttribute("alto","20" );
      ((Element)v.get(358)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(358)).setAttribute("imgFondo","" );
      ((Element)v.get(358)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(332)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(359)).setAttribute("colFondo","" );
      ((Element)v.get(359)).setAttribute("ID","EstCab" );
      ((Element)v.get(359)).setAttribute("cod","338" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */

      /* Empieza nodo:360 / Elemento padre: 358   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(360)).setAttribute("colFondo","" );
      ((Element)v.get(360)).setAttribute("ID","EstCab" );
      ((Element)v.get(360)).setAttribute("cod","276" );
      ((Element)v.get(358)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */

      /* Empieza nodo:361 / Elemento padre: 358   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(361)).setAttribute("colFondo","" );
      ((Element)v.get(361)).setAttribute("ID","EstCab" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(361)).setAttribute("cod","506" );
      ((Element)v.get(358)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */

      /* Empieza nodo:362 / Elemento padre: 358   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(362)).setAttribute("colFondo","" );
      ((Element)v.get(362)).setAttribute("ID","EstCab" );
      ((Element)v.get(362)).setAttribute("cod","506" );
      ((Element)v.get(358)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */

      /* Empieza nodo:363 / Elemento padre: 358   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(363)).setAttribute("colFondo","" );
      ((Element)v.get(363)).setAttribute("ID","EstCab" );
      ((Element)v.get(363)).setAttribute("cod","465" );
      ((Element)v.get(358)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */

      /* Empieza nodo:364 / Elemento padre: 358   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(364)).setAttribute("colFondo","" );
      ((Element)v.get(364)).setAttribute("ID","EstCab" );
      ((Element)v.get(364)).setAttribute("cod","336" );
      ((Element)v.get(358)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */

      /* Empieza nodo:365 / Elemento padre: 358   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(365)).setAttribute("colFondo","" );
      ((Element)v.get(365)).setAttribute("ID","EstCab" );
      ((Element)v.get(365)).setAttribute("cod","337" );
      ((Element)v.get(358)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */

      /* Empieza nodo:366 / Elemento padre: 358   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(366)).setAttribute("colFondo","" );
      ((Element)v.get(366)).setAttribute("ID","EstCab" );
      ((Element)v.get(366)).setAttribute("cod","530" );
      ((Element)v.get(358)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */

      /* Empieza nodo:367 / Elemento padre: 358   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(367)).setAttribute("colFondo","" );
      ((Element)v.get(367)).setAttribute("ID","EstCab" );
      ((Element)v.get(367)).setAttribute("cod","504" );
      ((Element)v.get(358)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */

      /* Empieza nodo:368 / Elemento padre: 358   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(368)).setAttribute("colFondo","" );
      ((Element)v.get(368)).setAttribute("ID","EstCab" );
      ((Element)v.get(368)).setAttribute("cod","339" );
      ((Element)v.get(358)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */

      /* Empieza nodo:369 / Elemento padre: 358   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(369)).setAttribute("colFondo","" );
      ((Element)v.get(369)).setAttribute("ID","EstCab" );
      ((Element)v.get(369)).setAttribute("cod","506" );
      ((Element)v.get(358)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */

      /* Empieza nodo:370 / Elemento padre: 358   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(370)).setAttribute("colFondo","" );
      ((Element)v.get(370)).setAttribute("ID","EstCab" );
      ((Element)v.get(370)).setAttribute("cod","506" );
      ((Element)v.get(358)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */

      /* Empieza nodo:371 / Elemento padre: 358   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(371)).setAttribute("colFondo","" );
      ((Element)v.get(371)).setAttribute("ID","EstCab" );
      ((Element)v.get(371)).setAttribute("cod","506" );
      ((Element)v.get(358)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */

      /* Empieza nodo:372 / Elemento padre: 358   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(372)).setAttribute("colFondo","" );
      ((Element)v.get(372)).setAttribute("ID","EstCab" );
      ((Element)v.get(372)).setAttribute("cod","506" );
      ((Element)v.get(358)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */

      /* Empieza nodo:373 / Elemento padre: 358   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(373)).setAttribute("colFondo","" );
      ((Element)v.get(373)).setAttribute("ID","EstCab" );
      ((Element)v.get(373)).setAttribute("cod","506" );
      ((Element)v.get(358)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */
      /* Termina nodo:358   */

      /* Empieza nodo:374 / Elemento padre: 332   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(374)).setAttribute("alto","22" );
      ((Element)v.get(374)).setAttribute("accion","" );
      ((Element)v.get(374)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(374)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(374)).setAttribute("maxSel","-1" );
      ((Element)v.get(374)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(374)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(374)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(374)).setAttribute("onLoad","" );
      ((Element)v.get(374)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(332)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(375)).setAttribute("tipo","texto" );
      ((Element)v.get(375)).setAttribute("ID","EstDat" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */

      /* Empieza nodo:376 / Elemento padre: 374   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(376)).setAttribute("tipo","texto" );
      ((Element)v.get(376)).setAttribute("ID","EstDat2" );
      ((Element)v.get(374)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */

      /* Empieza nodo:377 / Elemento padre: 374   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(377)).setAttribute("tipo","texto" );
      ((Element)v.get(377)).setAttribute("ID","EstDat" );
      ((Element)v.get(374)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */

      /* Empieza nodo:378 / Elemento padre: 374   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(378)).setAttribute("tipo","texto" );
      ((Element)v.get(378)).setAttribute("ID","EstDat" );
      ((Element)v.get(374)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */

      /* Empieza nodo:379 / Elemento padre: 374   */
   }

   private void getXML1890(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(379)).setAttribute("tipo","texto" );
      ((Element)v.get(379)).setAttribute("ID","EstDat2" );
      ((Element)v.get(374)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */

      /* Empieza nodo:380 / Elemento padre: 374   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(380)).setAttribute("tipo","texto" );
      ((Element)v.get(380)).setAttribute("ID","EstDat" );
      ((Element)v.get(374)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */

      /* Empieza nodo:381 / Elemento padre: 374   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(381)).setAttribute("tipo","texto" );
      ((Element)v.get(381)).setAttribute("ID","EstDat2" );
      ((Element)v.get(374)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */

      /* Empieza nodo:382 / Elemento padre: 374   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(382)).setAttribute("tipo","texto" );
      ((Element)v.get(382)).setAttribute("ID","EstDat" );
      ((Element)v.get(374)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */

      /* Empieza nodo:383 / Elemento padre: 374   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(383)).setAttribute("tipo","texto" );
      ((Element)v.get(383)).setAttribute("ID","EstDat2" );
      ((Element)v.get(374)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */

      /* Empieza nodo:384 / Elemento padre: 374   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(384)).setAttribute("tipo","texto" );
      ((Element)v.get(384)).setAttribute("ID","EstDat" );
      ((Element)v.get(374)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */

      /* Empieza nodo:385 / Elemento padre: 374   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(385)).setAttribute("tipo","texto" );
      ((Element)v.get(385)).setAttribute("ID","EstDat" );
      ((Element)v.get(374)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */

      /* Empieza nodo:386 / Elemento padre: 374   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(386)).setAttribute("tipo","texto" );
      ((Element)v.get(386)).setAttribute("ID","EstDat" );
      ((Element)v.get(374)).appendChild((Element)v.get(386));
      /* Termina nodo:386   */

      /* Empieza nodo:387 / Elemento padre: 374   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(387)).setAttribute("tipo","texto" );
      ((Element)v.get(387)).setAttribute("ID","EstDat" );
      ((Element)v.get(374)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */

      /* Empieza nodo:388 / Elemento padre: 374   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(388)).setAttribute("tipo","texto" );
      ((Element)v.get(388)).setAttribute("ID","EstDat" );
      ((Element)v.get(374)).appendChild((Element)v.get(388));
      /* Termina nodo:388   */

      /* Empieza nodo:389 / Elemento padre: 374   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(389)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(389)).setAttribute("nombre","txtNUnidR" );
      ((Element)v.get(389)).setAttribute("ID","EstDat2" );
      ((Element)v.get(389)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(389)).setAttribute("onShTab","focalizaAnteriorLista(FILAEVENTO, TECLAEVENTO)" );
      ((Element)v.get(389)).setAttribute("onTab","focalizaSiguienteLista(FILAEVENTO, TECLAEVENTO)" );
      ((Element)v.get(389)).setAttribute("onBlur","validar(FILAEVENTO);" );
      ((Element)v.get(389)).setAttribute("validacion","validaUnidades(valor, 6)" );
      ((Element)v.get(389)).setAttribute("size","8" );
      ((Element)v.get(389)).setAttribute("max","7" );
      ((Element)v.get(389)).setAttribute("req","N" );
      ((Element)v.get(374)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:374   */

      /* Empieza nodo:390 / Elemento padre: 332   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(332)).appendChild((Element)v.get(390));
      /* Termina nodo:390   */
      /* Termina nodo:332   */

      /* Empieza nodo:391 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(391)).setAttribute("nombre","Aceptar3" );
      ((Element)v.get(391)).setAttribute("x","13" );
      ((Element)v.get(391)).setAttribute("y","307" );
      ((Element)v.get(391)).setAttribute("ID","botonContenido" );
      ((Element)v.get(391)).setAttribute("accion","aceptarEnvia()" );
      ((Element)v.get(391)).setAttribute("ontab","focalizaPrimeroListado();" );
      ((Element)v.get(391)).setAttribute("onshtab","focalizaUltimoListado()" );
      ((Element)v.get(391)).setAttribute("tipo","html" );
      ((Element)v.get(391)).setAttribute("estado","false" );
      ((Element)v.get(391)).setAttribute("cod","12" );
      ((Element)v.get(9)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */

      /* Empieza nodo:392 / Elemento padre: 9   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(392)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(392)).setAttribute("alto","12" );
      ((Element)v.get(392)).setAttribute("ancho","50" );
      ((Element)v.get(392)).setAttribute("colorf","" );
      ((Element)v.get(392)).setAttribute("borde","0" );
      ((Element)v.get(392)).setAttribute("imagenf","" );
      ((Element)v.get(392)).setAttribute("repeat","" );
      ((Element)v.get(392)).setAttribute("padding","" );
      ((Element)v.get(392)).setAttribute("visibilidad","visible" );
      ((Element)v.get(392)).setAttribute("contravsb","" );
      ((Element)v.get(392)).setAttribute("x","0" );
      ((Element)v.get(392)).setAttribute("y","782" );
      ((Element)v.get(392)).setAttribute("zindex","" );
      ((Element)v.get(9)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */
      /* Termina nodo:9   */


   }

}

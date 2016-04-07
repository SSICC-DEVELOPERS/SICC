
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_clientes_ficha_presentar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_clientes_ficha_presentar" );
      ((Element)v.get(0)).setAttribute("cod","0561" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("STYLE"));
      ((Element)v.get(1)).setAttribute("TYPE","text/css" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Elemento padre:1 / Elemento actual: 2   */
      v.add(doc.createTextNode("\r   \r\r#ret3Div {visibility:hidden;}\r#ava3Div {visibility:hidden;}\r#primera3Div {visibility:hidden;}\r#separa3Div {visibility:hidden;}\r#Cplistado3{visibility:hidden;}\r#CpLin1listado3{visibility:hidden;}\r#CpLin2listado3{visibility:hidden;}\r#CpLin3listado3{visibility:hidden;}\r#CpLin4listado3{visibility:hidden;}\r\r   \r"));
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
      ((Element)v.get(4)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(6)).setAttribute("src","contenido_clientes_ficha_presentar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(7)).setAttribute("nombre","formulario" );
      ((Element)v.get(7)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","errSeverity" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","accion" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","idioma" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","pais" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","oidContacto" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","oidCliente" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","codCliente" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","oidTipoCliente" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","oidSubtipoCliente" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","indConsultoraInterna" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","activaBtActualiza" );
      ((Element)v.get(21)).setAttribute("valor","N" );
      ((Element)v.get(7)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","activaBtBloqueo" );
      ((Element)v.get(22)).setAttribute("valor","N" );
      ((Element)v.get(7)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 7   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(23)).setAttribute("valor","Presentar" );
      ((Element)v.get(7)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 7   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(24)).setAttribute("nombre","capa" );
      ((Element)v.get(24)).setAttribute("x","0" );
      ((Element)v.get(24)).setAttribute("y","0" );
      ((Element)v.get(24)).setAttribute("ancho","100%" );
      ((Element)v.get(24)).setAttribute("alto","100%" );
      ((Element)v.get(7)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("table"));
      ((Element)v.get(25)).setAttribute("width","100%" );
      ((Element)v.get(25)).setAttribute("border","0" );
      ((Element)v.get(25)).setAttribute("cellspacing","0" );
      ((Element)v.get(25)).setAttribute("cellpadding","0" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(27)).setAttribute("width","12" );
      ((Element)v.get(27)).setAttribute("align","center" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(28)).setAttribute("width","12" );
      ((Element)v.get(28)).setAttribute("height","12" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:29 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).setAttribute("width","750" );
      ((Element)v.get(26)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(30)).setAttribute("src","b.gif" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:31 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).setAttribute("width","12" );
      ((Element)v.get(26)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(32)).setAttribute("src","b.gif" );
      ((Element)v.get(32)).setAttribute("width","12" );
      ((Element)v.get(32)).setAttribute("height","1" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */
      /* Termina nodo:26   */

      /* Empieza nodo:33 / Elemento padre: 25   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(25)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(35)).setAttribute("src","b.gif" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(38)).setAttribute("class","legend" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(39)).setAttribute("nombre","lblDatosGenerales" );
      ((Element)v.get(39)).setAttribute("alto","13" );
      ((Element)v.get(39)).setAttribute("filas","1" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(39)).setAttribute("cod","0011" );
      ((Element)v.get(39)).setAttribute("id","legend" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 37   */
      v.add(doc.createElement("table"));
      ((Element)v.get(40)).setAttribute("width","100%" );
      ((Element)v.get(40)).setAttribute("border","0" );
      ((Element)v.get(40)).setAttribute("align","center" );
      ((Element)v.get(40)).setAttribute("cellspacing","0" );
      ((Element)v.get(40)).setAttribute("cellpadding","0" );
      ((Element)v.get(37)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("table"));
      ((Element)v.get(43)).setAttribute("width","718" );
      ((Element)v.get(43)).setAttribute("border","0" );
      ((Element)v.get(43)).setAttribute("align","left" );
      ((Element)v.get(43)).setAttribute("cellspacing","0" );
      ((Element)v.get(43)).setAttribute("cellpadding","0" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).setAttribute("colspan","4" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","8" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(46)).setAttribute("height","8" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:47 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","8" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(51)).setAttribute("nombre","lblCodCliente" );
      ((Element)v.get(51)).setAttribute("alto","13" );
      ((Element)v.get(51)).setAttribute("filas","1" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(51)).setAttribute("id","datosTitle" );
      ((Element)v.get(51)).setAttribute("cod","263" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","25" );
      ((Element)v.get(53)).setAttribute("height","8" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(55)).setAttribute("nombre","lblTipoDocIdentidad" );
      ((Element)v.get(55)).setAttribute("alto","13" );
      ((Element)v.get(55)).setAttribute("filas","1" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(55)).setAttribute("id","datosTitle" );
      ((Element)v.get(55)).setAttribute("cod","1126" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","25" );
      ((Element)v.get(57)).setAttribute("height","8" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(59)).setAttribute("nombre","lblNumDocumento" );
      ((Element)v.get(59)).setAttribute("alto","13" );
      ((Element)v.get(59)).setAttribute("filas","1" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(59)).setAttribute("id","datosTitle" );
      ((Element)v.get(59)).setAttribute("cod","422" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).setAttribute("width","100%" );
      ((Element)v.get(47)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","8" );
      ((Element)v.get(61)).setAttribute("height","8" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:47   */

      /* Empieza nodo:62 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","8" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(66)).setAttribute("nombre","lbldtCodCliente" );
      ((Element)v.get(66)).setAttribute("alto","13" );
      ((Element)v.get(66)).setAttribute("filas","1" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(66)).setAttribute("id","datosCampos" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","25" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(70)).setAttribute("nombre","lbldtTipoDocIdentidad" );
      ((Element)v.get(70)).setAttribute("alto","13" );
      ((Element)v.get(70)).setAttribute("filas","1" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(70)).setAttribute("id","datosCampos" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","25" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(74)).setAttribute("nombre","lbldtNumDocumento" );
      ((Element)v.get(74)).setAttribute("alto","13" );
      ((Element)v.get(74)).setAttribute("filas","1" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(74)).setAttribute("id","datosCampos" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("width","100%" );
      ((Element)v.get(62)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","8" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:62   */

      /* Empieza nodo:77 / Elemento padre: 43   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(43)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("colspan","4" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","8" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:43   */
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:80 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("table"));
      ((Element)v.get(82)).setAttribute("width","718" );
      ((Element)v.get(82)).setAttribute("border","0" );
      ((Element)v.get(82)).setAttribute("align","left" );
      ((Element)v.get(82)).setAttribute("cellspacing","0" );
      ((Element)v.get(82)).setAttribute("cellpadding","0" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","8" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(87)).setAttribute("nombre","lblApellido1" );
      ((Element)v.get(87)).setAttribute("alto","13" );
      ((Element)v.get(87)).setAttribute("filas","1" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(87)).setAttribute("id","datosTitle" );
      ((Element)v.get(87)).setAttribute("cod","16" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","25" );
      ((Element)v.get(89)).setAttribute("height","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(91)).setAttribute("nombre","lblApellido2" );
      ((Element)v.get(91)).setAttribute("alto","13" );
      ((Element)v.get(91)).setAttribute("filas","1" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(91)).setAttribute("id","datosTitle" );
      ((Element)v.get(91)).setAttribute("cod","17" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","25" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(95)).setAttribute("nombre","lblApellidoCasada" );
      ((Element)v.get(95)).setAttribute("alto","13" );
      ((Element)v.get(95)).setAttribute("filas","1" );
      ((Element)v.get(95)).setAttribute("valor","" );
      ((Element)v.get(95)).setAttribute("id","datosTitle" );
      ((Element)v.get(95)).setAttribute("cod","18" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","8" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(99)).setAttribute("nombre","lblNombre1" );
      ((Element)v.get(99)).setAttribute("alto","13" );
      ((Element)v.get(99)).setAttribute("filas","1" );
      ((Element)v.get(99)).setAttribute("valor","" );
      ((Element)v.get(99)).setAttribute("id","datosTitle" );
      ((Element)v.get(99)).setAttribute("cod","93" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","25" );
      ((Element)v.get(101)).setAttribute("height","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(103)).setAttribute("nombre","lblNombre2" );
      ((Element)v.get(103)).setAttribute("alto","13" );
      ((Element)v.get(103)).setAttribute("filas","1" );
      ((Element)v.get(103)).setAttribute("valor","" );
      ((Element)v.get(103)).setAttribute("id","datosTitle" );
      ((Element)v.get(103)).setAttribute("cod","94" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","25" );
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(107)).setAttribute("nombre","lblEstatus" );
      ((Element)v.get(107)).setAttribute("alto","13" );
      ((Element)v.get(107)).setAttribute("filas","1" );
      ((Element)v.get(107)).setAttribute("valor","" );
      ((Element)v.get(107)).setAttribute("id","datosTitle" );
      ((Element)v.get(107)).setAttribute("cod","596" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","25" );
      ((Element)v.get(109)).setAttribute("height","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(111)).setAttribute("nombre","lblIndicadorActivo" );
      ((Element)v.get(111)).setAttribute("alto","13" );
      ((Element)v.get(111)).setAttribute("filas","1" );
      ((Element)v.get(111)).setAttribute("valor","" );
      ((Element)v.get(111)).setAttribute("id","datosTitle" );
      ((Element)v.get(111)).setAttribute("cod","905" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).setAttribute("width","100%" );
      ((Element)v.get(83)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).setAttribute("width","8" );
      ((Element)v.get(113)).setAttribute("height","8" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:83   */

      /* Empieza nodo:114 / Elemento padre: 82   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(82)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(116)).setAttribute("width","8" );
      ((Element)v.get(116)).setAttribute("height","8" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(118)).setAttribute("nombre","lbldtApellido1" );
      ((Element)v.get(118)).setAttribute("alto","13" );
      ((Element)v.get(118)).setAttribute("filas","1" );
      ((Element)v.get(118)).setAttribute("valor","" );
      ((Element)v.get(118)).setAttribute("id","datosCampos" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).setAttribute("width","25" );
      ((Element)v.get(120)).setAttribute("height","8" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(122)).setAttribute("nombre","lbldtApellido2" );
      ((Element)v.get(122)).setAttribute("alto","13" );
      ((Element)v.get(122)).setAttribute("filas","1" );
      ((Element)v.get(122)).setAttribute("valor","" );
      ((Element)v.get(122)).setAttribute("id","datosCampos" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","25" );
      ((Element)v.get(124)).setAttribute("height","8" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(126)).setAttribute("nombre","lbldtApellidoCasada" );
      ((Element)v.get(126)).setAttribute("alto","13" );
      ((Element)v.get(126)).setAttribute("filas","1" );
      ((Element)v.get(126)).setAttribute("valor","" );
      ((Element)v.get(126)).setAttribute("id","datosCampos" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","8" );
      ((Element)v.get(128)).setAttribute("height","8" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(130)).setAttribute("nombre","lbldtNombre1" );
      ((Element)v.get(130)).setAttribute("alto","13" );
      ((Element)v.get(130)).setAttribute("filas","1" );
      ((Element)v.get(130)).setAttribute("valor","" );
      ((Element)v.get(130)).setAttribute("id","datosCampos" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(132)).setAttribute("width","25" );
      ((Element)v.get(132)).setAttribute("height","8" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(134)).setAttribute("nombre","lbldtNombre2" );
      ((Element)v.get(134)).setAttribute("alto","13" );
      ((Element)v.get(134)).setAttribute("filas","1" );
      ((Element)v.get(134)).setAttribute("valor","" );
      ((Element)v.get(134)).setAttribute("id","datosCampos" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","25" );
      ((Element)v.get(136)).setAttribute("height","8" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 114   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(138)).setAttribute("nombre","lbldtEstatus" );
      ((Element)v.get(138)).setAttribute("alto","13" );
      ((Element)v.get(138)).setAttribute("filas","1" );
      ((Element)v.get(138)).setAttribute("valor","" );
      ((Element)v.get(138)).setAttribute("id","datosCampos" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","25" );
      ((Element)v.get(140)).setAttribute("height","8" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(142)).setAttribute("nombre","lbldtIndicadorActivo" );
      ((Element)v.get(142)).setAttribute("alto","13" );
      ((Element)v.get(142)).setAttribute("filas","1" );
      ((Element)v.get(142)).setAttribute("valor","" );
      ((Element)v.get(142)).setAttribute("id","datosCampos" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).setAttribute("width","100%" );
      ((Element)v.get(114)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","8" );
      ((Element)v.get(144)).setAttribute("height","8" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:114   */

      /* Empieza nodo:145 / Elemento padre: 82   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(82)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).setAttribute("colspan","14" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).setAttribute("width","8" );
      ((Element)v.get(147)).setAttribute("height","8" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:148 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("table"));
      ((Element)v.get(150)).setAttribute("width","718" );
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
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","8" );
      ((Element)v.get(153)).setAttribute("height","8" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:154 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(155)).setAttribute("nombre","lblTratamiento" );
      ((Element)v.get(155)).setAttribute("alto","13" );
      ((Element)v.get(155)).setAttribute("filas","1" );
      ((Element)v.get(155)).setAttribute("valor","" );
      ((Element)v.get(155)).setAttribute("id","datosTitle" );
      ((Element)v.get(155)).setAttribute("cod","757" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:156 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(157)).setAttribute("src","b.gif" );
      ((Element)v.get(157)).setAttribute("width","25" );
      ((Element)v.get(157)).setAttribute("height","8" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:158 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(159)).setAttribute("nombre","lblFechaNac" );
      ((Element)v.get(159)).setAttribute("alto","13" );
      ((Element)v.get(159)).setAttribute("filas","1" );
      ((Element)v.get(159)).setAttribute("valor","" );
      ((Element)v.get(159)).setAttribute("id","datosTitle" );
      ((Element)v.get(159)).setAttribute("cod","877" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 151   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).setAttribute("width","100%" );
      ((Element)v.get(151)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).setAttribute("width","8" );
      ((Element)v.get(161)).setAttribute("height","8" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:151   */

      /* Empieza nodo:162 / Elemento padre: 150   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(150)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","8" );
      ((Element)v.get(164)).setAttribute("height","8" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(166)).setAttribute("nombre","lbldtTratamiento" );
      ((Element)v.get(166)).setAttribute("alto","13" );
      ((Element)v.get(166)).setAttribute("filas","1" );
      ((Element)v.get(166)).setAttribute("valor","" );
      ((Element)v.get(166)).setAttribute("id","datosCampos" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","25" );
      ((Element)v.get(168)).setAttribute("height","8" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(170)).setAttribute("nombre","lbldtFechaNac" );
      ((Element)v.get(170)).setAttribute("alto","13" );
      ((Element)v.get(170)).setAttribute("filas","1" );
      ((Element)v.get(170)).setAttribute("valor","" );
      ((Element)v.get(170)).setAttribute("id","datosCampos" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).setAttribute("width","100%" );
      ((Element)v.get(162)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).setAttribute("width","8" );
      ((Element)v.get(172)).setAttribute("height","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */
      /* Termina nodo:162   */

      /* Empieza nodo:173 / Elemento padre: 150   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(150)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).setAttribute("colspan","9" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(175)).setAttribute("src","b.gif" );
      ((Element)v.get(175)).setAttribute("width","8" );
      ((Element)v.get(175)).setAttribute("height","8" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */
      /* Termina nodo:173   */
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:176 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("table"));
      ((Element)v.get(178)).setAttribute("width","718" );
      ((Element)v.get(178)).setAttribute("border","0" );
      ((Element)v.get(178)).setAttribute("align","left" );
      ((Element)v.get(178)).setAttribute("cellspacing","0" );
      ((Element)v.get(178)).setAttribute("cellpadding","0" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(178)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).setAttribute("width","8" );
      ((Element)v.get(181)).setAttribute("height","8" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(183)).setAttribute("nombre","lblFechaProximoContacto" );
      ((Element)v.get(183)).setAttribute("alto","13" );
      ((Element)v.get(183)).setAttribute("filas","1" );
      ((Element)v.get(183)).setAttribute("valor","" );
      ((Element)v.get(183)).setAttribute("id","datosTitle" );
      ((Element)v.get(183)).setAttribute("cod","1995" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 179   */
   }

   private void getXML720(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(185)).setAttribute("src","b.gif" );
      ((Element)v.get(185)).setAttribute("width","25" );
      ((Element)v.get(185)).setAttribute("height","8" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(187)).setAttribute("nombre","lblBloqueo" );
      ((Element)v.get(187)).setAttribute("alto","13" );
      ((Element)v.get(187)).setAttribute("filas","1" );
      ((Element)v.get(187)).setAttribute("valor","" );
      ((Element)v.get(187)).setAttribute("id","datosTitle" );
      ((Element)v.get(187)).setAttribute("cod","1996" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:188 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(189)).setAttribute("src","b.gif" );
      ((Element)v.get(189)).setAttribute("width","25" );
      ((Element)v.get(189)).setAttribute("height","8" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(191)).setAttribute("nombre","lblFechaIngreso" );
      ((Element)v.get(191)).setAttribute("alto","13" );
      ((Element)v.get(191)).setAttribute("filas","1" );
      ((Element)v.get(191)).setAttribute("valor","" );
      ((Element)v.get(191)).setAttribute("id","datosTitle" );
      ((Element)v.get(191)).setAttribute("cod","499" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","25" );
      ((Element)v.get(193)).setAttribute("height","8" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:194 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(195)).setAttribute("nombre","lblPeriodoIngreso" );
      ((Element)v.get(195)).setAttribute("alto","13" );
      ((Element)v.get(195)).setAttribute("filas","1" );
      ((Element)v.get(195)).setAttribute("valor","" );
      ((Element)v.get(195)).setAttribute("id","datosTitle" );
      ((Element)v.get(195)).setAttribute("cod","1998" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(196)).setAttribute("width","100%" );
      ((Element)v.get(179)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(197)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).setAttribute("width","8" );
      ((Element)v.get(197)).setAttribute("height","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */
      /* Termina nodo:179   */

      /* Empieza nodo:198 / Elemento padre: 178   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(178)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(200)).setAttribute("src","b.gif" );
      ((Element)v.get(200)).setAttribute("width","8" );
      ((Element)v.get(200)).setAttribute("height","8" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:201 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(202)).setAttribute("nombre","lbldtFechaProximoContacto" );
      ((Element)v.get(202)).setAttribute("alto","13" );
      ((Element)v.get(202)).setAttribute("filas","1" );
      ((Element)v.get(202)).setAttribute("valor","" );
      ((Element)v.get(202)).setAttribute("id","datosCampos" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:203 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).setAttribute("width","25" );
      ((Element)v.get(204)).setAttribute("height","8" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:205 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(206)).setAttribute("nombre","lbldtBloqueo" );
      ((Element)v.get(206)).setAttribute("alto","13" );
      ((Element)v.get(206)).setAttribute("filas","1" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(206)).setAttribute("valor","" );
      ((Element)v.get(206)).setAttribute("id","datosCampos" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:207 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).setAttribute("width","25" );
      ((Element)v.get(208)).setAttribute("height","8" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:209 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(210)).setAttribute("nombre","lbldtFechaIngreso" );
      ((Element)v.get(210)).setAttribute("alto","13" );
      ((Element)v.get(210)).setAttribute("filas","1" );
      ((Element)v.get(210)).setAttribute("valor","" );
      ((Element)v.get(210)).setAttribute("id","datosCampos" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */

      /* Empieza nodo:211 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(212)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).setAttribute("width","25" );
      ((Element)v.get(212)).setAttribute("height","8" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */

      /* Empieza nodo:213 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(214)).setAttribute("nombre","lbldtPeriodoIngreso" );
      ((Element)v.get(214)).setAttribute("alto","13" );
      ((Element)v.get(214)).setAttribute("filas","1" );
      ((Element)v.get(214)).setAttribute("valor","" );
      ((Element)v.get(214)).setAttribute("id","datosCampos" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(215)).setAttribute("width","100%" );
      ((Element)v.get(198)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(216)).setAttribute("src","b.gif" );
      ((Element)v.get(216)).setAttribute("width","8" );
      ((Element)v.get(216)).setAttribute("height","8" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */
      /* Termina nodo:198   */

      /* Empieza nodo:217 / Elemento padre: 178   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(178)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).setAttribute("colspan","4" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("width","8" );
      ((Element)v.get(219)).setAttribute("height","12" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:217   */
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:220 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("table"));
      ((Element)v.get(222)).setAttribute("width","718" );
      ((Element)v.get(222)).setAttribute("border","0" );
      ((Element)v.get(222)).setAttribute("align","left" );
      ((Element)v.get(222)).setAttribute("cellspacing","0" );
      ((Element)v.get(222)).setAttribute("cellpadding","0" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(222)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(225)).setAttribute("src","b.gif" );
      ((Element)v.get(225)).setAttribute("width","8" );
      ((Element)v.get(225)).setAttribute("height","8" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:226 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(227)).setAttribute("nombre","lblTipoDireccion" );
      ((Element)v.get(227)).setAttribute("alto","13" );
      ((Element)v.get(227)).setAttribute("filas","1" );
      ((Element)v.get(227)).setAttribute("valor","" );
      ((Element)v.get(227)).setAttribute("id","datosTitle" );
      ((Element)v.get(227)).setAttribute("cod","MaeTipoDirec.codTipoDire.label" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(229)).setAttribute("src","b.gif" );
      ((Element)v.get(229)).setAttribute("width","25" );
      ((Element)v.get(229)).setAttribute("height","8" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:230 / Elemento padre: 223   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(231)).setAttribute("nombre","lblTipoVia" );
      ((Element)v.get(231)).setAttribute("alto","13" );
      ((Element)v.get(231)).setAttribute("filas","1" );
      ((Element)v.get(231)).setAttribute("valor","" );
      ((Element)v.get(231)).setAttribute("id","datosTitle" );
      ((Element)v.get(231)).setAttribute("cod","215" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:232 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(233)).setAttribute("src","b.gif" );
      ((Element)v.get(233)).setAttribute("width","25" );
      ((Element)v.get(233)).setAttribute("height","8" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:234 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(235)).setAttribute("nombre","lblVia" );
      ((Element)v.get(235)).setAttribute("alto","13" );
      ((Element)v.get(235)).setAttribute("filas","1" );
      ((Element)v.get(235)).setAttribute("valor","" );
      ((Element)v.get(235)).setAttribute("id","datosTitle" );
      ((Element)v.get(235)).setAttribute("cod","216" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:236 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(237)).setAttribute("src","b.gif" );
      ((Element)v.get(237)).setAttribute("width","25" );
      ((Element)v.get(237)).setAttribute("height","8" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:238 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(239)).setAttribute("nombre","lblNumeroPrincipal" );
      ((Element)v.get(239)).setAttribute("alto","13" );
      ((Element)v.get(239)).setAttribute("filas","1" );
      ((Element)v.get(239)).setAttribute("valor","" );
      ((Element)v.get(239)).setAttribute("id","datosTitle" );
      ((Element)v.get(239)).setAttribute("cod","939" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:240 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(241)).setAttribute("src","b.gif" );
      ((Element)v.get(241)).setAttribute("width","25" );
      ((Element)v.get(241)).setAttribute("height","8" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:242 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(243)).setAttribute("nombre","lblObservaciones" );
      ((Element)v.get(243)).setAttribute("alto","13" );
      ((Element)v.get(243)).setAttribute("filas","1" );
      ((Element)v.get(243)).setAttribute("valor","" );
      ((Element)v.get(243)).setAttribute("id","datosTitle" );
      ((Element)v.get(243)).setAttribute("cod","169" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:244 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(245)).setAttribute("src","b.gif" );
      ((Element)v.get(245)).setAttribute("width","25" );
      ((Element)v.get(245)).setAttribute("height","8" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:246 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(247)).setAttribute("nombre","lblDescripcionUbigeo" );
      ((Element)v.get(247)).setAttribute("alto","13" );
      ((Element)v.get(247)).setAttribute("filas","1" );
      ((Element)v.get(247)).setAttribute("valor","" );
      ((Element)v.get(247)).setAttribute("id","datosTitle" );
      ((Element)v.get(247)).setAttribute("cod","227" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:248 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).setAttribute("width","100%" );
      ((Element)v.get(223)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(249)).setAttribute("src","b.gif" );
      ((Element)v.get(249)).setAttribute("width","8" );
      ((Element)v.get(249)).setAttribute("height","8" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */
      /* Termina nodo:223   */

      /* Empieza nodo:250 / Elemento padre: 222   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(222)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(252)).setAttribute("src","b.gif" );
      ((Element)v.get(252)).setAttribute("width","8" );
      ((Element)v.get(252)).setAttribute("height","8" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */

      /* Empieza nodo:253 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(254)).setAttribute("nombre","lbldtTipoDireccion" );
      ((Element)v.get(254)).setAttribute("alto","13" );
      ((Element)v.get(254)).setAttribute("filas","1" );
      ((Element)v.get(254)).setAttribute("valor","" );
      ((Element)v.get(254)).setAttribute("id","datosCampos" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:255 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(256)).setAttribute("src","b.gif" );
      ((Element)v.get(256)).setAttribute("width","25" );
      ((Element)v.get(256)).setAttribute("height","8" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:257 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(258)).setAttribute("nombre","lbldtTipoVia" );
      ((Element)v.get(258)).setAttribute("alto","13" );
      ((Element)v.get(258)).setAttribute("filas","1" );
      ((Element)v.get(258)).setAttribute("valor","" );
      ((Element)v.get(258)).setAttribute("id","datosCampos" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:259 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(260)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).setAttribute("width","25" );
      ((Element)v.get(260)).setAttribute("height","8" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:261 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(262)).setAttribute("nombre","lbldtVia" );
      ((Element)v.get(262)).setAttribute("alto","13" );
      ((Element)v.get(262)).setAttribute("filas","1" );
      ((Element)v.get(262)).setAttribute("valor","" );
      ((Element)v.get(262)).setAttribute("id","datosCampos" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */

      /* Empieza nodo:263 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(264)).setAttribute("src","b.gif" );
      ((Element)v.get(264)).setAttribute("width","25" );
      ((Element)v.get(264)).setAttribute("height","8" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */

      /* Empieza nodo:265 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(266)).setAttribute("nombre","lbldtNumeroPrincipal" );
      ((Element)v.get(266)).setAttribute("alto","13" );
      ((Element)v.get(266)).setAttribute("filas","1" );
      ((Element)v.get(266)).setAttribute("valor","" );
      ((Element)v.get(266)).setAttribute("id","datosCampos" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */

      /* Empieza nodo:267 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(268)).setAttribute("src","b.gif" );
      ((Element)v.get(268)).setAttribute("width","25" );
      ((Element)v.get(268)).setAttribute("height","8" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */

      /* Empieza nodo:269 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(270)).setAttribute("nombre","lbldtObservaciones" );
      ((Element)v.get(270)).setAttribute("alto","13" );
      ((Element)v.get(270)).setAttribute("filas","1" );
      ((Element)v.get(270)).setAttribute("valor","" );
      ((Element)v.get(270)).setAttribute("id","datosCampos" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:269   */

      /* Empieza nodo:271 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(272)).setAttribute("src","b.gif" );
      ((Element)v.get(272)).setAttribute("width","25" );
      ((Element)v.get(272)).setAttribute("height","8" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:271   */

      /* Empieza nodo:273 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(274)).setAttribute("nombre","lbldtDescripcionUbigeo" );
      ((Element)v.get(274)).setAttribute("alto","13" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(274)).setAttribute("filas","1" );
      ((Element)v.get(274)).setAttribute("valor","" );
      ((Element)v.get(274)).setAttribute("id","datosCampos" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */

      /* Empieza nodo:275 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).setAttribute("width","100%" );
      ((Element)v.get(250)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(276)).setAttribute("src","b.gif" );
      ((Element)v.get(276)).setAttribute("width","8" );
      ((Element)v.get(276)).setAttribute("height","8" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */
      /* Termina nodo:250   */

      /* Empieza nodo:277 / Elemento padre: 222   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(222)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("td"));
      ((Element)v.get(278)).setAttribute("colspan","13" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(279)).setAttribute("src","b.gif" );
      ((Element)v.get(279)).setAttribute("width","8" );
      ((Element)v.get(279)).setAttribute("height","12" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */
      /* Termina nodo:277   */
      /* Termina nodo:222   */
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:280 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(281)).setAttribute("width","750" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(282)).setAttribute("src","b.gif" );
      ((Element)v.get(282)).setAttribute("width","12" );
      ((Element)v.get(282)).setAttribute("height","170" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */
      /* Termina nodo:280   */

      /* Empieza nodo:283 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("td"));
      ((Element)v.get(283)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("table"));
      ((Element)v.get(285)).setAttribute("width","100%" );
      ((Element)v.get(285)).setAttribute("border","0" );
      ((Element)v.get(285)).setAttribute("align","center" );
      ((Element)v.get(285)).setAttribute("cellspacing","0" );
      ((Element)v.get(285)).setAttribute("cellpadding","0" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(285)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("table"));
      ((Element)v.get(288)).setAttribute("width","100%" );
      ((Element)v.get(288)).setAttribute("border","0" );
      ((Element)v.get(288)).setAttribute("align","center" );
      ((Element)v.get(288)).setAttribute("cellspacing","0" );
      ((Element)v.get(288)).setAttribute("cellpadding","0" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(288)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(289)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(291)).setAttribute("src","b.gif" );
      ((Element)v.get(291)).setAttribute("width","8" );
      ((Element)v.get(291)).setAttribute("height","12" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */

      /* Empieza nodo:292 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(289)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(292)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(294)).setAttribute("class","legend" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(295)).setAttribute("nombre","LegendUltimoPedidSaldoUnico" );
      ((Element)v.get(295)).setAttribute("alto","13" );
      ((Element)v.get(295)).setAttribute("filas","1" );
      ((Element)v.get(295)).setAttribute("valor","" );
      ((Element)v.get(295)).setAttribute("cod","0052" );
      ((Element)v.get(295)).setAttribute("id","legend" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */

      /* Empieza nodo:296 / Elemento padre: 293   */
      v.add(doc.createElement("table"));
      ((Element)v.get(296)).setAttribute("width","100%" );
      ((Element)v.get(296)).setAttribute("border","0" );
      ((Element)v.get(296)).setAttribute("align","center" );
      ((Element)v.get(296)).setAttribute("cellspacing","0" );
      ((Element)v.get(296)).setAttribute("cellpadding","0" );
      ((Element)v.get(293)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(296)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("td"));
      ((Element)v.get(297)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("table"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(299)).setAttribute("width","698" );
      ((Element)v.get(299)).setAttribute("border","0" );
      ((Element)v.get(299)).setAttribute("align","left" );
      ((Element)v.get(299)).setAttribute("cellspacing","0" );
      ((Element)v.get(299)).setAttribute("cellpadding","0" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(299)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(301)).setAttribute("colspan","12" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(302)).setAttribute("src","b.gif" );
      ((Element)v.get(302)).setAttribute("width","8" );
      ((Element)v.get(302)).setAttribute("height","8" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */
      /* Termina nodo:300   */

      /* Empieza nodo:303 / Elemento padre: 299   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(299)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(305)).setAttribute("src","b.gif" );
      ((Element)v.get(305)).setAttribute("width","8" );
      ((Element)v.get(305)).setAttribute("height","8" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:304   */

      /* Empieza nodo:306 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(307)).setAttribute("nombre","lblFechaUltimoPedido" );
      ((Element)v.get(307)).setAttribute("alto","13" );
      ((Element)v.get(307)).setAttribute("filas","1" );
      ((Element)v.get(307)).setAttribute("valor","" );
      ((Element)v.get(307)).setAttribute("id","datosTitle" );
      ((Element)v.get(307)).setAttribute("cod","361" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:306   */

      /* Empieza nodo:308 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(309)).setAttribute("src","b.gif" );
      ((Element)v.get(309)).setAttribute("width","25" );
      ((Element)v.get(309)).setAttribute("height","8" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:310 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(311)).setAttribute("nombre","lblCampaniaUltimoPedido" );
      ((Element)v.get(311)).setAttribute("alto","13" );
      ((Element)v.get(311)).setAttribute("filas","1" );
      ((Element)v.get(311)).setAttribute("valor","" );
      ((Element)v.get(311)).setAttribute("id","datosTitle" );
      ((Element)v.get(311)).setAttribute("cod","00343" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:312 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(313)).setAttribute("src","b.gif" );
      ((Element)v.get(313)).setAttribute("width","25" );
      ((Element)v.get(313)).setAttribute("height","8" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:312   */

      /* Empieza nodo:314 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(315)).setAttribute("nombre","lblNumeroBoleta" );
      ((Element)v.get(315)).setAttribute("alto","13" );
      ((Element)v.get(315)).setAttribute("filas","1" );
      ((Element)v.get(315)).setAttribute("valor","" );
      ((Element)v.get(315)).setAttribute("id","datosTitle" );
      ((Element)v.get(315)).setAttribute("cod","2850" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:314   */

      /* Empieza nodo:316 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(317)).setAttribute("src","b.gif" );
      ((Element)v.get(317)).setAttribute("width","25" );
      ((Element)v.get(317)).setAttribute("height","8" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:316   */

      /* Empieza nodo:318 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(319)).setAttribute("nombre","lblSaldoBoleta" );
      ((Element)v.get(319)).setAttribute("alto","13" );
      ((Element)v.get(319)).setAttribute("filas","1" );
      ((Element)v.get(319)).setAttribute("valor","" );
      ((Element)v.get(319)).setAttribute("id","datosTitle" );
      ((Element)v.get(319)).setAttribute("cod","1142" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */
      /* Termina nodo:318   */

      /* Empieza nodo:320 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(321)).setAttribute("src","b.gif" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(321)).setAttribute("width","25" );
      ((Element)v.get(321)).setAttribute("height","8" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:320   */

      /* Empieza nodo:322 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(323)).setAttribute("nombre","lblSaldoUnico" );
      ((Element)v.get(323)).setAttribute("alto","13" );
      ((Element)v.get(323)).setAttribute("filas","1" );
      ((Element)v.get(323)).setAttribute("valor","" );
      ((Element)v.get(323)).setAttribute("id","datosTitle" );
      ((Element)v.get(323)).setAttribute("cod","SegPais.indSaldUnic.label" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:324 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(324)).setAttribute("width","100%" );
      ((Element)v.get(303)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(325)).setAttribute("src","b.gif" );
      ((Element)v.get(325)).setAttribute("width","8" );
      ((Element)v.get(325)).setAttribute("height","8" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */
      /* Termina nodo:303   */

      /* Empieza nodo:326 / Elemento padre: 299   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(299)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(328)).setAttribute("src","b.gif" );
      ((Element)v.get(328)).setAttribute("width","8" );
      ((Element)v.get(328)).setAttribute("height","8" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:327   */

      /* Empieza nodo:329 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(330)).setAttribute("nombre","lbldtFechaUltimoPedido" );
      ((Element)v.get(330)).setAttribute("alto","13" );
      ((Element)v.get(330)).setAttribute("filas","1" );
      ((Element)v.get(330)).setAttribute("valor","" );
      ((Element)v.get(330)).setAttribute("id","datosCampos" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:331 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(332)).setAttribute("src","b.gif" );
      ((Element)v.get(332)).setAttribute("width","25" );
      ((Element)v.get(332)).setAttribute("height","8" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:331   */

      /* Empieza nodo:333 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(334)).setAttribute("nombre","lbldtCampaniaUltimoPedido" );
      ((Element)v.get(334)).setAttribute("alto","13" );
      ((Element)v.get(334)).setAttribute("filas","1" );
      ((Element)v.get(334)).setAttribute("valor","" );
      ((Element)v.get(334)).setAttribute("id","datosCampos" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:335 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(336)).setAttribute("src","b.gif" );
      ((Element)v.get(336)).setAttribute("width","25" );
      ((Element)v.get(336)).setAttribute("height","8" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(338)).setAttribute("nombre","lbldtNumeroBoleta" );
      ((Element)v.get(338)).setAttribute("alto","13" );
      ((Element)v.get(338)).setAttribute("filas","1" );
      ((Element)v.get(338)).setAttribute("valor","" );
      ((Element)v.get(338)).setAttribute("id","datosCampos" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:339 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(340)).setAttribute("src","b.gif" );
      ((Element)v.get(340)).setAttribute("width","25" );
      ((Element)v.get(340)).setAttribute("height","8" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */

      /* Empieza nodo:341 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(342)).setAttribute("nombre","lbldtSaldoBoleta" );
      ((Element)v.get(342)).setAttribute("alto","13" );
      ((Element)v.get(342)).setAttribute("filas","1" );
      ((Element)v.get(342)).setAttribute("valor","" );
      ((Element)v.get(342)).setAttribute("id","datosCampos" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */

      /* Empieza nodo:343 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(344)).setAttribute("src","b.gif" );
      ((Element)v.get(344)).setAttribute("width","25" );
      ((Element)v.get(344)).setAttribute("height","8" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:343   */

      /* Empieza nodo:345 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(346)).setAttribute("nombre","lbldtSaldoUnico" );
      ((Element)v.get(346)).setAttribute("alto","13" );
      ((Element)v.get(346)).setAttribute("filas","1" );
      ((Element)v.get(346)).setAttribute("valor","" );
      ((Element)v.get(346)).setAttribute("id","datosCampos" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:345   */

      /* Empieza nodo:347 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(347)).setAttribute("width","100%" );
      ((Element)v.get(326)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(348)).setAttribute("src","b.gif" );
      ((Element)v.get(348)).setAttribute("width","8" );
      ((Element)v.get(348)).setAttribute("height","8" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:347   */
      /* Termina nodo:326   */

      /* Empieza nodo:349 / Elemento padre: 299   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(299)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("td"));
      ((Element)v.get(350)).setAttribute("colspan","12" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(351)).setAttribute("src","b.gif" );
      ((Element)v.get(351)).setAttribute("width","8" );
      ((Element)v.get(351)).setAttribute("height","8" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */
      /* Termina nodo:350   */
      /* Termina nodo:349   */
      /* Termina nodo:299   */
      /* Termina nodo:298   */
      /* Termina nodo:297   */
      /* Termina nodo:296   */
      /* Termina nodo:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:352 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(289)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(353)).setAttribute("src","b.gif" );
      ((Element)v.get(353)).setAttribute("width","8" );
      ((Element)v.get(353)).setAttribute("height","12" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */
      /* Termina nodo:352   */
      /* Termina nodo:289   */

      /* Empieza nodo:354 / Elemento padre: 288   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(288)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).setAttribute("colspan","4" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(356)).setAttribute("src","b.gif" );
      ((Element)v.get(356)).setAttribute("width","8" );
      ((Element)v.get(356)).setAttribute("height","15" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */
      /* Termina nodo:355   */
      /* Termina nodo:354   */
      /* Termina nodo:288   */
      /* Termina nodo:287   */
      /* Termina nodo:286   */
      /* Termina nodo:285   */
      /* Termina nodo:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:357 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("td"));
      ((Element)v.get(357)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("table"));
      ((Element)v.get(359)).setAttribute("width","100%" );
      ((Element)v.get(359)).setAttribute("border","0" );
      ((Element)v.get(359)).setAttribute("align","center" );
      ((Element)v.get(359)).setAttribute("cellspacing","0" );
      ((Element)v.get(359)).setAttribute("cellpadding","0" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(359)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("td"));
      ((Element)v.get(360)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("table"));
      ((Element)v.get(362)).setAttribute("width","100%" );
      ((Element)v.get(362)).setAttribute("border","0" );
      ((Element)v.get(362)).setAttribute("align","center" );
      ((Element)v.get(362)).setAttribute("cellspacing","0" );
      ((Element)v.get(362)).setAttribute("cellpadding","0" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(362)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("td"));
      ((Element)v.get(363)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(365)).setAttribute("src","b.gif" );
      ((Element)v.get(365)).setAttribute("width","8" );
      ((Element)v.get(365)).setAttribute("height","12" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */
      /* Termina nodo:364   */

      /* Empieza nodo:366 / Elemento padre: 363   */
      v.add(doc.createElement("td"));
      ((Element)v.get(363)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(366)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(368)).setAttribute("class","legend" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(369)).setAttribute("nombre","lblInformacionCliente" );
      ((Element)v.get(369)).setAttribute("alto","13" );
      ((Element)v.get(369)).setAttribute("filas","1" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(369)).setAttribute("valor","" );
      ((Element)v.get(369)).setAttribute("cod","00183" );
      ((Element)v.get(369)).setAttribute("id","legend" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */

      /* Empieza nodo:370 / Elemento padre: 367   */
      v.add(doc.createElement("table"));
      ((Element)v.get(370)).setAttribute("width","100%" );
      ((Element)v.get(370)).setAttribute("border","0" );
      ((Element)v.get(370)).setAttribute("align","center" );
      ((Element)v.get(370)).setAttribute("cellspacing","0" );
      ((Element)v.get(370)).setAttribute("cellpadding","0" );
      ((Element)v.get(367)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(370)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("td"));
      ((Element)v.get(371)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("table"));
      ((Element)v.get(373)).setAttribute("width","698" );
      ((Element)v.get(373)).setAttribute("border","0" );
      ((Element)v.get(373)).setAttribute("align","left" );
      ((Element)v.get(373)).setAttribute("cellspacing","0" );
      ((Element)v.get(373)).setAttribute("cellpadding","0" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(373)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("td"));
      ((Element)v.get(375)).setAttribute("colspan","4" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(376)).setAttribute("src","b.gif" );
      ((Element)v.get(376)).setAttribute("width","8" );
      ((Element)v.get(376)).setAttribute("height","8" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */
      /* Termina nodo:375   */
      /* Termina nodo:374   */

      /* Empieza nodo:377 / Elemento padre: 373   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(373)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("td"));
      ((Element)v.get(377)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(379)).setAttribute("src","b.gif" );
      ((Element)v.get(379)).setAttribute("width","8" );
      ((Element)v.get(379)).setAttribute("height","8" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */
      /* Termina nodo:378   */

      /* Empieza nodo:380 / Elemento padre: 377   */
      v.add(doc.createElement("td"));
      ((Element)v.get(377)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(381)).setAttribute("nombre","lblTipoCliente" );
      ((Element)v.get(381)).setAttribute("alto","13" );
      ((Element)v.get(381)).setAttribute("filas","1" );
      ((Element)v.get(381)).setAttribute("valor","" );
      ((Element)v.get(381)).setAttribute("id","datosTitle" );
      ((Element)v.get(381)).setAttribute("cod","1869" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */
      /* Termina nodo:380   */

      /* Empieza nodo:382 / Elemento padre: 377   */
      v.add(doc.createElement("td"));
      ((Element)v.get(377)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(383)).setAttribute("src","b.gif" );
      ((Element)v.get(383)).setAttribute("width","25" );
      ((Element)v.get(383)).setAttribute("height","8" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */
      /* Termina nodo:382   */

      /* Empieza nodo:384 / Elemento padre: 377   */
      v.add(doc.createElement("td"));
      ((Element)v.get(377)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(385)).setAttribute("nombre","lblSubtipoCliente" );
      ((Element)v.get(385)).setAttribute("alto","13" );
      ((Element)v.get(385)).setAttribute("filas","1" );
      ((Element)v.get(385)).setAttribute("valor","" );
      ((Element)v.get(385)).setAttribute("id","datosTitle" );
      ((Element)v.get(385)).setAttribute("cod","595" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */
      /* Termina nodo:384   */

      /* Empieza nodo:386 / Elemento padre: 377   */
      v.add(doc.createElement("td"));
      ((Element)v.get(377)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(387)).setAttribute("src","b.gif" );
      ((Element)v.get(387)).setAttribute("width","8" );
      ((Element)v.get(387)).setAttribute("height","8" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */
      /* Termina nodo:386   */

      /* Empieza nodo:388 / Elemento padre: 377   */
      v.add(doc.createElement("td"));
      ((Element)v.get(377)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(389)).setAttribute("nombre","lblTipoClasificacion" );
      ((Element)v.get(389)).setAttribute("alto","13" );
      ((Element)v.get(389)).setAttribute("filas","1" );
      ((Element)v.get(389)).setAttribute("valor","" );
      ((Element)v.get(389)).setAttribute("id","datosTitle" );
      ((Element)v.get(389)).setAttribute("cod","756" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:388   */

      /* Empieza nodo:390 / Elemento padre: 377   */
      v.add(doc.createElement("td"));
      ((Element)v.get(377)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(391)).setAttribute("src","b.gif" );
      ((Element)v.get(391)).setAttribute("width","25" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(391)).setAttribute("height","8" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */
      /* Termina nodo:390   */

      /* Empieza nodo:392 / Elemento padre: 377   */
      v.add(doc.createElement("td"));
      ((Element)v.get(377)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(393)).setAttribute("nombre","lblClasificacion" );
      ((Element)v.get(393)).setAttribute("alto","13" );
      ((Element)v.get(393)).setAttribute("filas","1" );
      ((Element)v.get(393)).setAttribute("valor","" );
      ((Element)v.get(393)).setAttribute("id","datosTitle" );
      ((Element)v.get(393)).setAttribute("cod","550" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));
      /* Termina nodo:393   */
      /* Termina nodo:392   */

      /* Empieza nodo:394 / Elemento padre: 377   */
      v.add(doc.createElement("td"));
      ((Element)v.get(394)).setAttribute("width","100%" );
      ((Element)v.get(377)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(395)).setAttribute("src","b.gif" );
      ((Element)v.get(395)).setAttribute("width","8" );
      ((Element)v.get(395)).setAttribute("height","8" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */
      /* Termina nodo:394   */
      /* Termina nodo:377   */

      /* Empieza nodo:396 / Elemento padre: 373   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(373)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("td"));
      ((Element)v.get(396)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(398)).setAttribute("src","b.gif" );
      ((Element)v.get(398)).setAttribute("width","8" );
      ((Element)v.get(398)).setAttribute("height","8" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */
      /* Termina nodo:397   */

      /* Empieza nodo:399 / Elemento padre: 396   */
      v.add(doc.createElement("td"));
      ((Element)v.get(396)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(400)).setAttribute("nombre","cbdtTipoCliente" );
      ((Element)v.get(400)).setAttribute("id","datosCampos" );
      ((Element)v.get(400)).setAttribute("onshtab","" );
      ((Element)v.get(400)).setAttribute("size","3" );
      ((Element)v.get(400)).setAttribute("multiple","S" );
      ((Element)v.get(400)).setAttribute("req","N" );
      ((Element)v.get(400)).setAttribute("valorinicial","" );
      ((Element)v.get(400)).setAttribute("textoinicial","" );
      ((Element)v.get(400)).setAttribute("onchange","fnTipificacion(0)" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(400)).appendChild((Element)v.get(401));
      /* Termina nodo:401   */
      /* Termina nodo:400   */
      /* Termina nodo:399   */

      /* Empieza nodo:402 / Elemento padre: 396   */
      v.add(doc.createElement("td"));
      ((Element)v.get(396)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(403)).setAttribute("src","b.gif" );
      ((Element)v.get(403)).setAttribute("width","25" );
      ((Element)v.get(403)).setAttribute("height","8" );
      ((Element)v.get(402)).appendChild((Element)v.get(403));
      /* Termina nodo:403   */
      /* Termina nodo:402   */

      /* Empieza nodo:404 / Elemento padre: 396   */
      v.add(doc.createElement("td"));
      ((Element)v.get(396)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(405)).setAttribute("nombre","cbdtSubTipoCliente" );
      ((Element)v.get(405)).setAttribute("id","datosCampos" );
      ((Element)v.get(405)).setAttribute("onshtab","" );
      ((Element)v.get(405)).setAttribute("size","3" );
      ((Element)v.get(405)).setAttribute("multiple","S" );
      ((Element)v.get(405)).setAttribute("req","N" );
      ((Element)v.get(405)).setAttribute("valorinicial","" );
      ((Element)v.get(405)).setAttribute("textoinicial","" );
      ((Element)v.get(405)).setAttribute("onchange","fnTipificacion(1)" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(405)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */
      /* Termina nodo:405   */
      /* Termina nodo:404   */

      /* Empieza nodo:407 / Elemento padre: 396   */
      v.add(doc.createElement("td"));
      ((Element)v.get(396)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(408)).setAttribute("src","b.gif" );
      ((Element)v.get(408)).setAttribute("width","8" );
      ((Element)v.get(408)).setAttribute("height","8" );
      ((Element)v.get(407)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */
      /* Termina nodo:407   */

      /* Empieza nodo:409 / Elemento padre: 396   */
      v.add(doc.createElement("td"));
      ((Element)v.get(396)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(410)).setAttribute("nombre","cbdtTipoClasificacion" );
      ((Element)v.get(410)).setAttribute("id","datosCampos" );
      ((Element)v.get(410)).setAttribute("onshtab","" );
      ((Element)v.get(410)).setAttribute("size","3" );
      ((Element)v.get(410)).setAttribute("multiple","S" );
      ((Element)v.get(410)).setAttribute("req","N" );
      ((Element)v.get(410)).setAttribute("valorinicial","" );
      ((Element)v.get(410)).setAttribute("textoinicial","" );
      ((Element)v.get(410)).setAttribute("onchange","fnTipificacion(2)" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(410)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */
      /* Termina nodo:410   */
      /* Termina nodo:409   */

      /* Empieza nodo:412 / Elemento padre: 396   */
      v.add(doc.createElement("td"));
      ((Element)v.get(396)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
   }

   private void getXML1620(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(413)).setAttribute("src","b.gif" );
      ((Element)v.get(413)).setAttribute("width","25" );
      ((Element)v.get(413)).setAttribute("height","8" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */
      /* Termina nodo:412   */

      /* Empieza nodo:414 / Elemento padre: 396   */
      v.add(doc.createElement("td"));
      ((Element)v.get(396)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(415)).setAttribute("nombre","cbdtClasificacion" );
      ((Element)v.get(415)).setAttribute("id","datosCampos" );
      ((Element)v.get(415)).setAttribute("onshtab","" );
      ((Element)v.get(415)).setAttribute("size","3" );
      ((Element)v.get(415)).setAttribute("multiple","S" );
      ((Element)v.get(415)).setAttribute("req","N" );
      ((Element)v.get(415)).setAttribute("valorinicial","" );
      ((Element)v.get(415)).setAttribute("textoinicial","" );
      ((Element)v.get(415)).setAttribute("onchange","fnTipificacion(3)" );
      ((Element)v.get(414)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(415)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */
      /* Termina nodo:415   */
      /* Termina nodo:414   */

      /* Empieza nodo:417 / Elemento padre: 396   */
      v.add(doc.createElement("td"));
      ((Element)v.get(417)).setAttribute("width","100%" );
      ((Element)v.get(396)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(418)).setAttribute("src","b.gif" );
      ((Element)v.get(418)).setAttribute("width","8" );
      ((Element)v.get(418)).setAttribute("height","8" );
      ((Element)v.get(417)).appendChild((Element)v.get(418));
      /* Termina nodo:418   */
      /* Termina nodo:417   */
      /* Termina nodo:396   */

      /* Empieza nodo:419 / Elemento padre: 373   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(373)).appendChild((Element)v.get(419));

      /* Empieza nodo:420 / Elemento padre: 419   */
      v.add(doc.createElement("td"));
      ((Element)v.get(420)).setAttribute("colspan","8" );
      ((Element)v.get(419)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(421)).setAttribute("src","b.gif" );
      ((Element)v.get(421)).setAttribute("width","8" );
      ((Element)v.get(421)).setAttribute("height","8" );
      ((Element)v.get(420)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */
      /* Termina nodo:420   */
      /* Termina nodo:419   */
      /* Termina nodo:373   */
      /* Termina nodo:372   */
      /* Termina nodo:371   */
      /* Termina nodo:370   */
      /* Termina nodo:367   */
      /* Termina nodo:366   */

      /* Empieza nodo:422 / Elemento padre: 363   */
      v.add(doc.createElement("td"));
      ((Element)v.get(363)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(423)).setAttribute("src","b.gif" );
      ((Element)v.get(423)).setAttribute("width","8" );
      ((Element)v.get(423)).setAttribute("height","12" );
      ((Element)v.get(422)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */
      /* Termina nodo:422   */
      /* Termina nodo:363   */

      /* Empieza nodo:424 / Elemento padre: 362   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(362)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("td"));
      ((Element)v.get(425)).setAttribute("colspan","4" );
      ((Element)v.get(424)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(426)).setAttribute("src","b.gif" );
      ((Element)v.get(426)).setAttribute("width","8" );
      ((Element)v.get(426)).setAttribute("height","15" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));
      /* Termina nodo:426   */
      /* Termina nodo:425   */
      /* Termina nodo:424   */
      /* Termina nodo:362   */
      /* Termina nodo:361   */
      /* Termina nodo:360   */
      /* Termina nodo:359   */
      /* Termina nodo:358   */
      /* Termina nodo:357   */

      /* Empieza nodo:427 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("td"));
      ((Element)v.get(427)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("table"));
      ((Element)v.get(429)).setAttribute("width","100%" );
      ((Element)v.get(429)).setAttribute("border","0" );
      ((Element)v.get(429)).setAttribute("align","center" );
      ((Element)v.get(429)).setAttribute("cellspacing","0" );
      ((Element)v.get(429)).setAttribute("cellpadding","0" );
      ((Element)v.get(428)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(429)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("td"));
      ((Element)v.get(430)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("table"));
      ((Element)v.get(432)).setAttribute("width","100%" );
      ((Element)v.get(432)).setAttribute("border","0" );
      ((Element)v.get(432)).setAttribute("align","center" );
      ((Element)v.get(432)).setAttribute("cellspacing","0" );
      ((Element)v.get(432)).setAttribute("cellpadding","0" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(432)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("td"));
      ((Element)v.get(433)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(435)).setAttribute("src","b.gif" );
      ((Element)v.get(435)).setAttribute("width","8" );
      ((Element)v.get(435)).setAttribute("height","12" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */
      /* Termina nodo:434   */

      /* Empieza nodo:436 / Elemento padre: 433   */
      v.add(doc.createElement("td"));
      ((Element)v.get(433)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(436)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
   }

   private void getXML1710(Document doc) {
      v.add(doc.createElement("legend"));
      ((Element)v.get(438)).setAttribute("class","legend" );
      ((Element)v.get(437)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(439)).setAttribute("nombre","lblConsultora" );
      ((Element)v.get(439)).setAttribute("alto","13" );
      ((Element)v.get(439)).setAttribute("filas","1" );
      ((Element)v.get(439)).setAttribute("valor","" );
      ((Element)v.get(439)).setAttribute("cod","1991" );
      ((Element)v.get(439)).setAttribute("id","legend" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */
      /* Termina nodo:438   */

      /* Empieza nodo:440 / Elemento padre: 437   */
      v.add(doc.createElement("table"));
      ((Element)v.get(440)).setAttribute("width","700" );
      ((Element)v.get(440)).setAttribute("border","0" );
      ((Element)v.get(440)).setAttribute("align","left" );
      ((Element)v.get(440)).setAttribute("cellspacing","0" );
      ((Element)v.get(440)).setAttribute("cellpadding","0" );
      ((Element)v.get(437)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(440)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("td"));
      ((Element)v.get(442)).setAttribute("colspan","4" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));

      /* Empieza nodo:443 / Elemento padre: 442   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(443)).setAttribute("src","b.gif" );
      ((Element)v.get(443)).setAttribute("width","8" );
      ((Element)v.get(443)).setAttribute("height","8" );
      ((Element)v.get(442)).appendChild((Element)v.get(443));
      /* Termina nodo:443   */
      /* Termina nodo:442   */
      /* Termina nodo:441   */

      /* Empieza nodo:444 / Elemento padre: 440   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(440)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("td"));
      ((Element)v.get(444)).appendChild((Element)v.get(445));

      /* Empieza nodo:446 / Elemento padre: 445   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(446)).setAttribute("src","b.gif" );
      ((Element)v.get(446)).setAttribute("width","8" );
      ((Element)v.get(446)).setAttribute("height","8" );
      ((Element)v.get(445)).appendChild((Element)v.get(446));
      /* Termina nodo:446   */
      /* Termina nodo:445   */

      /* Empieza nodo:447 / Elemento padre: 444   */
      v.add(doc.createElement("td"));
      ((Element)v.get(444)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(448)).setAttribute("nombre","lblApellido1x" );
      ((Element)v.get(448)).setAttribute("alto","13" );
      ((Element)v.get(448)).setAttribute("filas","1" );
      ((Element)v.get(448)).setAttribute("valor","" );
      ((Element)v.get(448)).setAttribute("id","datosTitle" );
      ((Element)v.get(448)).setAttribute("cod","16" );
      ((Element)v.get(447)).appendChild((Element)v.get(448));
      /* Termina nodo:448   */
      /* Termina nodo:447   */

      /* Empieza nodo:449 / Elemento padre: 444   */
      v.add(doc.createElement("td"));
      ((Element)v.get(444)).appendChild((Element)v.get(449));

      /* Empieza nodo:450 / Elemento padre: 449   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(450)).setAttribute("src","b.gif" );
      ((Element)v.get(450)).setAttribute("width","25" );
      ((Element)v.get(450)).setAttribute("height","8" );
      ((Element)v.get(449)).appendChild((Element)v.get(450));
      /* Termina nodo:450   */
      /* Termina nodo:449   */

      /* Empieza nodo:451 / Elemento padre: 444   */
      v.add(doc.createElement("td"));
      ((Element)v.get(444)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(452)).setAttribute("nombre","lblApellido2x" );
      ((Element)v.get(452)).setAttribute("alto","13" );
      ((Element)v.get(452)).setAttribute("filas","1" );
      ((Element)v.get(452)).setAttribute("valor","" );
      ((Element)v.get(452)).setAttribute("id","datosTitle" );
      ((Element)v.get(452)).setAttribute("cod","17" );
      ((Element)v.get(451)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */
      /* Termina nodo:451   */

      /* Empieza nodo:453 / Elemento padre: 444   */
      v.add(doc.createElement("td"));
      ((Element)v.get(444)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(454)).setAttribute("src","b.gif" );
      ((Element)v.get(454)).setAttribute("width","25" );
      ((Element)v.get(454)).setAttribute("height","8" );
      ((Element)v.get(453)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */
      /* Termina nodo:453   */

      /* Empieza nodo:455 / Elemento padre: 444   */
      v.add(doc.createElement("td"));
      ((Element)v.get(444)).appendChild((Element)v.get(455));

      /* Empieza nodo:456 / Elemento padre: 455   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(456)).setAttribute("nombre","lblNombre1x" );
      ((Element)v.get(456)).setAttribute("alto","13" );
      ((Element)v.get(456)).setAttribute("filas","1" );
      ((Element)v.get(456)).setAttribute("valor","" );
      ((Element)v.get(456)).setAttribute("id","datosTitle" );
      ((Element)v.get(456)).setAttribute("cod","93" );
      ((Element)v.get(455)).appendChild((Element)v.get(456));
      /* Termina nodo:456   */
      /* Termina nodo:455   */

      /* Empieza nodo:457 / Elemento padre: 444   */
      v.add(doc.createElement("td"));
      ((Element)v.get(444)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(458)).setAttribute("src","b.gif" );
      ((Element)v.get(458)).setAttribute("width","25" );
      ((Element)v.get(458)).setAttribute("height","8" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */
      /* Termina nodo:457   */

      /* Empieza nodo:459 / Elemento padre: 444   */
      v.add(doc.createElement("td"));
      ((Element)v.get(444)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
   }

   private void getXML1800(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(460)).setAttribute("nombre","lblNombre2x" );
      ((Element)v.get(460)).setAttribute("alto","13" );
      ((Element)v.get(460)).setAttribute("filas","1" );
      ((Element)v.get(460)).setAttribute("valor","" );
      ((Element)v.get(460)).setAttribute("id","datosTitle" );
      ((Element)v.get(460)).setAttribute("cod","94" );
      ((Element)v.get(459)).appendChild((Element)v.get(460));
      /* Termina nodo:460   */
      /* Termina nodo:459   */

      /* Empieza nodo:461 / Elemento padre: 444   */
      v.add(doc.createElement("td"));
      ((Element)v.get(461)).setAttribute("width","100%" );
      ((Element)v.get(444)).appendChild((Element)v.get(461));

      /* Empieza nodo:462 / Elemento padre: 461   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(462)).setAttribute("src","b.gif" );
      ((Element)v.get(462)).setAttribute("width","8" );
      ((Element)v.get(462)).setAttribute("height","8" );
      ((Element)v.get(461)).appendChild((Element)v.get(462));
      /* Termina nodo:462   */
      /* Termina nodo:461   */
      /* Termina nodo:444   */

      /* Empieza nodo:463 / Elemento padre: 440   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(440)).appendChild((Element)v.get(463));

      /* Empieza nodo:464 / Elemento padre: 463   */
      v.add(doc.createElement("td"));
      ((Element)v.get(463)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(465)).setAttribute("src","b.gif" );
      ((Element)v.get(465)).setAttribute("width","8" );
      ((Element)v.get(465)).setAttribute("height","8" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));
      /* Termina nodo:465   */
      /* Termina nodo:464   */

      /* Empieza nodo:466 / Elemento padre: 463   */
      v.add(doc.createElement("td"));
      ((Element)v.get(463)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(467)).setAttribute("nombre","lbldtApellido1x" );
      ((Element)v.get(467)).setAttribute("alto","13" );
      ((Element)v.get(467)).setAttribute("filas","1" );
      ((Element)v.get(467)).setAttribute("valor","" );
      ((Element)v.get(467)).setAttribute("id","datosCampos" );
      ((Element)v.get(466)).appendChild((Element)v.get(467));
      /* Termina nodo:467   */
      /* Termina nodo:466   */

      /* Empieza nodo:468 / Elemento padre: 463   */
      v.add(doc.createElement("td"));
      ((Element)v.get(463)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(469)).setAttribute("src","b.gif" );
      ((Element)v.get(469)).setAttribute("width","25" );
      ((Element)v.get(469)).setAttribute("height","8" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));
      /* Termina nodo:469   */
      /* Termina nodo:468   */

      /* Empieza nodo:470 / Elemento padre: 463   */
      v.add(doc.createElement("td"));
      ((Element)v.get(463)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(471)).setAttribute("nombre","lbldtApellido2x" );
      ((Element)v.get(471)).setAttribute("alto","13" );
      ((Element)v.get(471)).setAttribute("filas","1" );
      ((Element)v.get(471)).setAttribute("valor","" );
      ((Element)v.get(471)).setAttribute("id","datosCampos" );
      ((Element)v.get(470)).appendChild((Element)v.get(471));
      /* Termina nodo:471   */
      /* Termina nodo:470   */

      /* Empieza nodo:472 / Elemento padre: 463   */
      v.add(doc.createElement("td"));
      ((Element)v.get(463)).appendChild((Element)v.get(472));

      /* Empieza nodo:473 / Elemento padre: 472   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(473)).setAttribute("src","b.gif" );
      ((Element)v.get(473)).setAttribute("width","25" );
      ((Element)v.get(473)).setAttribute("height","8" );
      ((Element)v.get(472)).appendChild((Element)v.get(473));
      /* Termina nodo:473   */
      /* Termina nodo:472   */

      /* Empieza nodo:474 / Elemento padre: 463   */
      v.add(doc.createElement("td"));
      ((Element)v.get(463)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(475)).setAttribute("nombre","lbldtNombre1x" );
      ((Element)v.get(475)).setAttribute("alto","13" );
      ((Element)v.get(475)).setAttribute("filas","1" );
      ((Element)v.get(475)).setAttribute("valor","" );
      ((Element)v.get(475)).setAttribute("id","datosCampos" );
      ((Element)v.get(474)).appendChild((Element)v.get(475));
      /* Termina nodo:475   */
      /* Termina nodo:474   */

      /* Empieza nodo:476 / Elemento padre: 463   */
      v.add(doc.createElement("td"));
      ((Element)v.get(463)).appendChild((Element)v.get(476));

      /* Empieza nodo:477 / Elemento padre: 476   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(477)).setAttribute("src","b.gif" );
      ((Element)v.get(477)).setAttribute("width","25" );
      ((Element)v.get(477)).setAttribute("height","8" );
      ((Element)v.get(476)).appendChild((Element)v.get(477));
      /* Termina nodo:477   */
      /* Termina nodo:476   */

      /* Empieza nodo:478 / Elemento padre: 463   */
      v.add(doc.createElement("td"));
      ((Element)v.get(463)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(479)).setAttribute("nombre","lbldtNombre2x" );
      ((Element)v.get(479)).setAttribute("alto","13" );
      ((Element)v.get(479)).setAttribute("filas","1" );
      ((Element)v.get(479)).setAttribute("valor","" );
      ((Element)v.get(479)).setAttribute("id","datosCampos" );
      ((Element)v.get(478)).appendChild((Element)v.get(479));
      /* Termina nodo:479   */
      /* Termina nodo:478   */

      /* Empieza nodo:480 / Elemento padre: 463   */
      v.add(doc.createElement("td"));
      ((Element)v.get(480)).setAttribute("width","100%" );
      ((Element)v.get(463)).appendChild((Element)v.get(480));

      /* Empieza nodo:481 / Elemento padre: 480   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(481)).setAttribute("src","b.gif" );
      ((Element)v.get(481)).setAttribute("width","8" );
      ((Element)v.get(481)).setAttribute("height","8" );
      ((Element)v.get(480)).appendChild((Element)v.get(481));
      /* Termina nodo:481   */
      /* Termina nodo:480   */
      /* Termina nodo:463   */

      /* Empieza nodo:482 / Elemento padre: 440   */
   }

   private void getXML1890(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(440)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("td"));
      ((Element)v.get(483)).setAttribute("colspan","4" );
      ((Element)v.get(482)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(484)).setAttribute("src","b.gif" );
      ((Element)v.get(484)).setAttribute("width","8" );
      ((Element)v.get(484)).setAttribute("height","8" );
      ((Element)v.get(483)).appendChild((Element)v.get(484));
      /* Termina nodo:484   */
      /* Termina nodo:483   */
      /* Termina nodo:482   */
      /* Termina nodo:440   */
      /* Termina nodo:437   */
      /* Termina nodo:436   */

      /* Empieza nodo:485 / Elemento padre: 433   */
      v.add(doc.createElement("td"));
      ((Element)v.get(433)).appendChild((Element)v.get(485));

      /* Empieza nodo:486 / Elemento padre: 485   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(486)).setAttribute("src","b.gif" );
      ((Element)v.get(486)).setAttribute("width","8" );
      ((Element)v.get(486)).setAttribute("height","12" );
      ((Element)v.get(485)).appendChild((Element)v.get(486));
      /* Termina nodo:486   */
      /* Termina nodo:485   */
      /* Termina nodo:433   */

      /* Empieza nodo:487 / Elemento padre: 432   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(432)).appendChild((Element)v.get(487));

      /* Empieza nodo:488 / Elemento padre: 487   */
      v.add(doc.createElement("td"));
      ((Element)v.get(488)).setAttribute("colspan","4" );
      ((Element)v.get(487)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(489)).setAttribute("src","b.gif" );
      ((Element)v.get(489)).setAttribute("width","8" );
      ((Element)v.get(489)).setAttribute("height","15" );
      ((Element)v.get(488)).appendChild((Element)v.get(489));
      /* Termina nodo:489   */
      /* Termina nodo:488   */
      /* Termina nodo:487   */
      /* Termina nodo:432   */
      /* Termina nodo:431   */
      /* Termina nodo:430   */
      /* Termina nodo:429   */
      /* Termina nodo:428   */
      /* Termina nodo:427   */
      /* Termina nodo:40   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:490 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(491)).setAttribute("src","b.gif" );
      ((Element)v.get(491)).setAttribute("width","8" );
      ((Element)v.get(491)).setAttribute("height","12" );
      ((Element)v.get(490)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */
      /* Termina nodo:490   */
      /* Termina nodo:33   */

      /* Empieza nodo:492 / Elemento padre: 25   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(25)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("td"));
      ((Element)v.get(493)).setAttribute("width","12" );
      ((Element)v.get(493)).setAttribute("align","center" );
      ((Element)v.get(492)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(494)).setAttribute("src","b.gif" );
      ((Element)v.get(494)).setAttribute("width","12" );
      ((Element)v.get(494)).setAttribute("height","898" );
      ((Element)v.get(493)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */
      /* Termina nodo:493   */

      /* Empieza nodo:495 / Elemento padre: 492   */
      v.add(doc.createElement("td"));
      ((Element)v.get(495)).setAttribute("width","750" );
      ((Element)v.get(492)).appendChild((Element)v.get(495));

      /* Empieza nodo:496 / Elemento padre: 495   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(496)).setAttribute("src","b.gif" );
      ((Element)v.get(495)).appendChild((Element)v.get(496));
      /* Termina nodo:496   */
      /* Termina nodo:495   */

      /* Empieza nodo:497 / Elemento padre: 492   */
      v.add(doc.createElement("td"));
      ((Element)v.get(497)).setAttribute("width","12" );
      ((Element)v.get(492)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(498)).setAttribute("src","b.gif" );
      ((Element)v.get(498)).setAttribute("width","12" );
      ((Element)v.get(498)).setAttribute("height","898" );
      ((Element)v.get(497)).appendChild((Element)v.get(498));
      /* Termina nodo:498   */
      /* Termina nodo:497   */
      /* Termina nodo:492   */

      /* Empieza nodo:499 / Elemento padre: 25   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(25)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("td"));
      ((Element)v.get(499)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(501)).setAttribute("src","b.gif" );
      ((Element)v.get(500)).appendChild((Element)v.get(501));
      /* Termina nodo:501   */
      /* Termina nodo:500   */

      /* Empieza nodo:502 / Elemento padre: 499   */
      v.add(doc.createElement("td"));
      ((Element)v.get(499)).appendChild((Element)v.get(502));

      /* Empieza nodo:503 / Elemento padre: 502   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(502)).appendChild((Element)v.get(503));

      /* Empieza nodo:504 / Elemento padre: 503   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(504)).setAttribute("class","legend" );
      ((Element)v.get(503)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(505)).setAttribute("nombre","lblGrupoDatosEconomicos" );
      ((Element)v.get(505)).setAttribute("alto","13" );
      ((Element)v.get(505)).setAttribute("filas","1" );
      ((Element)v.get(505)).setAttribute("valor","" );
      ((Element)v.get(505)).setAttribute("cod","00407" );
      ((Element)v.get(505)).setAttribute("id","legend" );
      ((Element)v.get(504)).appendChild((Element)v.get(505));
      /* Termina nodo:505   */
      /* Termina nodo:504   */

      /* Empieza nodo:506 / Elemento padre: 503   */
      v.add(doc.createElement("table"));
      ((Element)v.get(506)).setAttribute("width","100%" );
      ((Element)v.get(506)).setAttribute("border","0" );
      ((Element)v.get(506)).setAttribute("align","center" );
      ((Element)v.get(506)).setAttribute("cellspacing","0" );
      ((Element)v.get(506)).setAttribute("cellpadding","0" );
      ((Element)v.get(503)).appendChild((Element)v.get(506));

      /* Empieza nodo:507 / Elemento padre: 506   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(506)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
   }

   private void getXML1980(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(507)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("table"));
      ((Element)v.get(509)).setAttribute("width","718" );
      ((Element)v.get(509)).setAttribute("border","0" );
      ((Element)v.get(509)).setAttribute("align","left" );
      ((Element)v.get(509)).setAttribute("cellspacing","0" );
      ((Element)v.get(509)).setAttribute("cellpadding","0" );
      ((Element)v.get(508)).appendChild((Element)v.get(509));

      /* Empieza nodo:510 / Elemento padre: 509   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(509)).appendChild((Element)v.get(510));

      /* Empieza nodo:511 / Elemento padre: 510   */
      v.add(doc.createElement("td"));
      ((Element)v.get(511)).setAttribute("colspan","4" );
      ((Element)v.get(510)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(512)).setAttribute("src","b.gif" );
      ((Element)v.get(512)).setAttribute("width","8" );
      ((Element)v.get(512)).setAttribute("height","8" );
      ((Element)v.get(511)).appendChild((Element)v.get(512));
      /* Termina nodo:512   */
      /* Termina nodo:511   */
      /* Termina nodo:510   */

      /* Empieza nodo:513 / Elemento padre: 509   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(509)).appendChild((Element)v.get(513));

      /* Empieza nodo:514 / Elemento padre: 513   */
      v.add(doc.createElement("td"));
      ((Element)v.get(513)).appendChild((Element)v.get(514));

      /* Empieza nodo:515 / Elemento padre: 514   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(515)).setAttribute("src","b.gif" );
      ((Element)v.get(515)).setAttribute("width","8" );
      ((Element)v.get(515)).setAttribute("height","8" );
      ((Element)v.get(514)).appendChild((Element)v.get(515));
      /* Termina nodo:515   */
      /* Termina nodo:514   */

      /* Empieza nodo:516 / Elemento padre: 513   */
      v.add(doc.createElement("td"));
      ((Element)v.get(513)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(517)).setAttribute("nombre","lblMontoLineaCredito" );
      ((Element)v.get(517)).setAttribute("alto","13" );
      ((Element)v.get(517)).setAttribute("filas","1" );
      ((Element)v.get(517)).setAttribute("valor","" );
      ((Element)v.get(517)).setAttribute("id","datosTitle" );
      ((Element)v.get(517)).setAttribute("cod","1999" );
      ((Element)v.get(516)).appendChild((Element)v.get(517));
      /* Termina nodo:517   */
      /* Termina nodo:516   */

      /* Empieza nodo:518 / Elemento padre: 513   */
      v.add(doc.createElement("td"));
      ((Element)v.get(513)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(519)).setAttribute("src","b.gif" );
      ((Element)v.get(519)).setAttribute("width","25" );
      ((Element)v.get(519)).setAttribute("height","8" );
      ((Element)v.get(518)).appendChild((Element)v.get(519));
      /* Termina nodo:519   */
      /* Termina nodo:518   */

      /* Empieza nodo:520 / Elemento padre: 513   */
      v.add(doc.createElement("td"));
      ((Element)v.get(513)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(521)).setAttribute("nombre","lblMontoSolicitudesNuevas" );
      ((Element)v.get(521)).setAttribute("alto","13" );
      ((Element)v.get(521)).setAttribute("filas","1" );
      ((Element)v.get(521)).setAttribute("valor","" );
      ((Element)v.get(521)).setAttribute("id","datosTitle" );
      ((Element)v.get(521)).setAttribute("cod","2000" );
      ((Element)v.get(520)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */
      /* Termina nodo:520   */

      /* Empieza nodo:522 / Elemento padre: 513   */
      v.add(doc.createElement("td"));
      ((Element)v.get(513)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(523)).setAttribute("src","b.gif" );
      ((Element)v.get(523)).setAttribute("width","25" );
      ((Element)v.get(523)).setAttribute("height","8" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */
      /* Termina nodo:522   */

      /* Empieza nodo:524 / Elemento padre: 513   */
      v.add(doc.createElement("td"));
      ((Element)v.get(513)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(525)).setAttribute("nombre","lblNivelRiesgo" );
      ((Element)v.get(525)).setAttribute("alto","13" );
      ((Element)v.get(525)).setAttribute("filas","1" );
      ((Element)v.get(525)).setAttribute("valor","" );
      ((Element)v.get(525)).setAttribute("id","datosTitle" );
      ((Element)v.get(525)).setAttribute("cod","928" );
      ((Element)v.get(524)).appendChild((Element)v.get(525));
      /* Termina nodo:525   */
      /* Termina nodo:524   */

      /* Empieza nodo:526 / Elemento padre: 513   */
      v.add(doc.createElement("td"));
      ((Element)v.get(526)).setAttribute("width","100%" );
      ((Element)v.get(513)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(527)).setAttribute("src","b.gif" );
      ((Element)v.get(527)).setAttribute("width","8" );
      ((Element)v.get(527)).setAttribute("height","8" );
      ((Element)v.get(526)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */
      /* Termina nodo:526   */
      /* Termina nodo:513   */

      /* Empieza nodo:528 / Elemento padre: 509   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(509)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("td"));
      ((Element)v.get(528)).appendChild((Element)v.get(529));

      /* Empieza nodo:530 / Elemento padre: 529   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(530)).setAttribute("src","b.gif" );
      ((Element)v.get(530)).setAttribute("width","8" );
      ((Element)v.get(530)).setAttribute("height","8" );
      ((Element)v.get(529)).appendChild((Element)v.get(530));
      /* Termina nodo:530   */
      /* Termina nodo:529   */

      /* Empieza nodo:531 / Elemento padre: 528   */
      v.add(doc.createElement("td"));
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(528)).appendChild((Element)v.get(531));

      /* Empieza nodo:532 / Elemento padre: 531   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(532)).setAttribute("nombre","lbldtMontoLineaCredito" );
      ((Element)v.get(532)).setAttribute("alto","13" );
      ((Element)v.get(532)).setAttribute("filas","1" );
      ((Element)v.get(532)).setAttribute("valor","" );
      ((Element)v.get(532)).setAttribute("id","datosCampos" );
      ((Element)v.get(531)).appendChild((Element)v.get(532));
      /* Termina nodo:532   */
      /* Termina nodo:531   */

      /* Empieza nodo:533 / Elemento padre: 528   */
      v.add(doc.createElement("td"));
      ((Element)v.get(528)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(534)).setAttribute("src","b.gif" );
      ((Element)v.get(534)).setAttribute("width","25" );
      ((Element)v.get(534)).setAttribute("height","8" );
      ((Element)v.get(533)).appendChild((Element)v.get(534));
      /* Termina nodo:534   */
      /* Termina nodo:533   */

      /* Empieza nodo:535 / Elemento padre: 528   */
      v.add(doc.createElement("td"));
      ((Element)v.get(528)).appendChild((Element)v.get(535));

      /* Empieza nodo:536 / Elemento padre: 535   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(536)).setAttribute("nombre","lbldtMontoSolicitudesNuevas" );
      ((Element)v.get(536)).setAttribute("alto","13" );
      ((Element)v.get(536)).setAttribute("filas","1" );
      ((Element)v.get(536)).setAttribute("valor","" );
      ((Element)v.get(536)).setAttribute("id","datosCampos" );
      ((Element)v.get(535)).appendChild((Element)v.get(536));
      /* Termina nodo:536   */
      /* Termina nodo:535   */

      /* Empieza nodo:537 / Elemento padre: 528   */
      v.add(doc.createElement("td"));
      ((Element)v.get(528)).appendChild((Element)v.get(537));

      /* Empieza nodo:538 / Elemento padre: 537   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(538)).setAttribute("src","b.gif" );
      ((Element)v.get(538)).setAttribute("width","25" );
      ((Element)v.get(538)).setAttribute("height","8" );
      ((Element)v.get(537)).appendChild((Element)v.get(538));
      /* Termina nodo:538   */
      /* Termina nodo:537   */

      /* Empieza nodo:539 / Elemento padre: 528   */
      v.add(doc.createElement("td"));
      ((Element)v.get(528)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(540)).setAttribute("nombre","lbldtNivelRiesgo" );
      ((Element)v.get(540)).setAttribute("alto","13" );
      ((Element)v.get(540)).setAttribute("filas","1" );
      ((Element)v.get(540)).setAttribute("valor","" );
      ((Element)v.get(540)).setAttribute("id","datosCampos" );
      ((Element)v.get(539)).appendChild((Element)v.get(540));
      /* Termina nodo:540   */
      /* Termina nodo:539   */

      /* Empieza nodo:541 / Elemento padre: 528   */
      v.add(doc.createElement("td"));
      ((Element)v.get(541)).setAttribute("width","100%" );
      ((Element)v.get(528)).appendChild((Element)v.get(541));

      /* Empieza nodo:542 / Elemento padre: 541   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(542)).setAttribute("src","b.gif" );
      ((Element)v.get(542)).setAttribute("width","8" );
      ((Element)v.get(542)).setAttribute("height","8" );
      ((Element)v.get(541)).appendChild((Element)v.get(542));
      /* Termina nodo:542   */
      /* Termina nodo:541   */
      /* Termina nodo:528   */

      /* Empieza nodo:543 / Elemento padre: 509   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(509)).appendChild((Element)v.get(543));

      /* Empieza nodo:544 / Elemento padre: 543   */
      v.add(doc.createElement("td"));
      ((Element)v.get(544)).setAttribute("colspan","4" );
      ((Element)v.get(543)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(545)).setAttribute("src","b.gif" );
      ((Element)v.get(545)).setAttribute("width","8" );
      ((Element)v.get(545)).setAttribute("height","8" );
      ((Element)v.get(544)).appendChild((Element)v.get(545));
      /* Termina nodo:545   */
      /* Termina nodo:544   */
      /* Termina nodo:543   */
      /* Termina nodo:509   */
      /* Termina nodo:508   */
      /* Termina nodo:507   */
      /* Termina nodo:506   */
      /* Termina nodo:503   */
      /* Termina nodo:502   */

      /* Empieza nodo:546 / Elemento padre: 499   */
      v.add(doc.createElement("td"));
      ((Element)v.get(499)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(547)).setAttribute("src","b.gif" );
      ((Element)v.get(547)).setAttribute("width","8" );
      ((Element)v.get(547)).setAttribute("height","12" );
      ((Element)v.get(546)).appendChild((Element)v.get(547));
      /* Termina nodo:547   */
      /* Termina nodo:546   */
      /* Termina nodo:499   */

      /* Empieza nodo:548 / Elemento padre: 25   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(25)).appendChild((Element)v.get(548));

      /* Empieza nodo:549 / Elemento padre: 548   */
      v.add(doc.createElement("td"));
      ((Element)v.get(548)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(550)).setAttribute("src","b.gif" );
      ((Element)v.get(549)).appendChild((Element)v.get(550));
      /* Termina nodo:550   */
      /* Termina nodo:549   */

      /* Empieza nodo:551 / Elemento padre: 548   */
      v.add(doc.createElement("td"));
      ((Element)v.get(548)).appendChild((Element)v.get(551));

      /* Empieza nodo:552 / Elemento padre: 551   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(551)).appendChild((Element)v.get(552));

      /* Empieza nodo:553 / Elemento padre: 552   */
      v.add(doc.createElement("table"));
      ((Element)v.get(553)).setAttribute("width","100%" );
      ((Element)v.get(553)).setAttribute("border","0" );
      ((Element)v.get(553)).setAttribute("align","center" );
      ((Element)v.get(553)).setAttribute("cellspacing","0" );
      ((Element)v.get(553)).setAttribute("cellpadding","0" );
      ((Element)v.get(552)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(553)).appendChild((Element)v.get(554));

      /* Empieza nodo:555 / Elemento padre: 554   */
      v.add(doc.createElement("td"));
      ((Element)v.get(555)).setAttribute("class","botonera" );
      ((Element)v.get(554)).appendChild((Element)v.get(555));

      /* Empieza nodo:556 / Elemento padre: 555   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(556)).setAttribute("nombre","btnRealizarBloqueoAdministrativo" );
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(556)).setAttribute("ID","botonContenido" );
      ((Element)v.get(556)).setAttribute("tipo","html" );
      ((Element)v.get(556)).setAttribute("accion","accionBloqueoAdministrativo();" );
      ((Element)v.get(556)).setAttribute("onshtab","focalizaAnteriorBloqueo();" );
      ((Element)v.get(556)).setAttribute("ontab","focalizaSiguienteBloqueo();" );
      ((Element)v.get(556)).setAttribute("estado","false" );
      ((Element)v.get(556)).setAttribute("cod","2072" );
      ((Element)v.get(555)).appendChild((Element)v.get(556));
      /* Termina nodo:556   */

      /* Empieza nodo:557 / Elemento padre: 555   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(557)).setAttribute("nombre","btnActualizarEstadoContacto" );
      ((Element)v.get(557)).setAttribute("ID","botonContenido" );
      ((Element)v.get(557)).setAttribute("tipo","html" );
      ((Element)v.get(557)).setAttribute("accion","accionActualizarEstadoContacto();" );
      ((Element)v.get(557)).setAttribute("ontab","navPestana('lblContactos');" );
      ((Element)v.get(557)).setAttribute("estado","false" );
      ((Element)v.get(557)).setAttribute("cod","2789" );
      ((Element)v.get(555)).appendChild((Element)v.get(557));
      /* Termina nodo:557   */
      /* Termina nodo:555   */
      /* Termina nodo:554   */
      /* Termina nodo:553   */
      /* Termina nodo:552   */
      /* Termina nodo:551   */

      /* Empieza nodo:558 / Elemento padre: 548   */
      v.add(doc.createElement("td"));
      ((Element)v.get(548)).appendChild((Element)v.get(558));

      /* Empieza nodo:559 / Elemento padre: 558   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(559)).setAttribute("src","b.gif" );
      ((Element)v.get(559)).setAttribute("width","8" );
      ((Element)v.get(559)).setAttribute("height","12" );
      ((Element)v.get(558)).appendChild((Element)v.get(559));
      /* Termina nodo:559   */
      /* Termina nodo:558   */
      /* Termina nodo:548   */

      /* Empieza nodo:560 / Elemento padre: 25   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(25)).appendChild((Element)v.get(560));

      /* Empieza nodo:561 / Elemento padre: 560   */
      v.add(doc.createElement("td"));
      ((Element)v.get(561)).setAttribute("width","12" );
      ((Element)v.get(561)).setAttribute("align","center" );
      ((Element)v.get(560)).appendChild((Element)v.get(561));

      /* Empieza nodo:562 / Elemento padre: 561   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(562)).setAttribute("src","b.gif" );
      ((Element)v.get(562)).setAttribute("width","12" );
      ((Element)v.get(562)).setAttribute("height","12" );
      ((Element)v.get(561)).appendChild((Element)v.get(562));
      /* Termina nodo:562   */
      /* Termina nodo:561   */

      /* Empieza nodo:563 / Elemento padre: 560   */
      v.add(doc.createElement("td"));
      ((Element)v.get(563)).setAttribute("width","750" );
      ((Element)v.get(560)).appendChild((Element)v.get(563));

      /* Empieza nodo:564 / Elemento padre: 563   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(564)).setAttribute("src","b.gif" );
      ((Element)v.get(563)).appendChild((Element)v.get(564));
      /* Termina nodo:564   */
      /* Termina nodo:563   */

      /* Empieza nodo:565 / Elemento padre: 560   */
      v.add(doc.createElement("td"));
      ((Element)v.get(565)).setAttribute("width","12" );
      ((Element)v.get(560)).appendChild((Element)v.get(565));

      /* Empieza nodo:566 / Elemento padre: 565   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(566)).setAttribute("src","b.gif" );
      ((Element)v.get(566)).setAttribute("width","12" );
      ((Element)v.get(566)).setAttribute("height","12" );
      ((Element)v.get(565)).appendChild((Element)v.get(566));
      /* Termina nodo:566   */
      /* Termina nodo:565   */
      /* Termina nodo:560   */
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:567 / Elemento padre: 7   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(567)).setAttribute("nombre","listado5" );
      ((Element)v.get(567)).setAttribute("ancho","660" );
      ((Element)v.get(567)).setAttribute("alto","150" );
      ((Element)v.get(567)).setAttribute("x","36" );
      ((Element)v.get(567)).setAttribute("y","210" );
      ((Element)v.get(567)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(567)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(7)).appendChild((Element)v.get(567));

      /* Empieza nodo:568 / Elemento padre: 567   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(568)).setAttribute("precarga","S" );
      ((Element)v.get(568)).setAttribute("conROver","S" );
      ((Element)v.get(567)).appendChild((Element)v.get(568));

      /* Empieza nodo:569 / Elemento padre: 568   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(569)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(569)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(569)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(569)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(568)).appendChild((Element)v.get(569));
      /* Termina nodo:569   */

      /* Empieza nodo:570 / Elemento padre: 568   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(570)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(570)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(570)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(570)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(568)).appendChild((Element)v.get(570));
      /* Termina nodo:570   */

      /* Empieza nodo:571 / Elemento padre: 568   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(571)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(571)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(568)).appendChild((Element)v.get(571));
      /* Termina nodo:571   */
      /* Termina nodo:568   */

      /* Empieza nodo:572 / Elemento padre: 567   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(567)).appendChild((Element)v.get(572));

      /* Empieza nodo:573 / Elemento padre: 572   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(573)).setAttribute("borde","1" );
      ((Element)v.get(573)).setAttribute("horizDatos","1" );
      ((Element)v.get(573)).setAttribute("horizCabecera","1" );
      ((Element)v.get(573)).setAttribute("vertical","0" );
      ((Element)v.get(573)).setAttribute("horizTitulo","1" );
      ((Element)v.get(573)).setAttribute("horizBase","1" );
      ((Element)v.get(572)).appendChild((Element)v.get(573));
      /* Termina nodo:573   */

      /* Empieza nodo:574 / Elemento padre: 572   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(574)).setAttribute("borde","#999999" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(574)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(574)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(574)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(574)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(574)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(574)).setAttribute("horizBase","#999999" );
      ((Element)v.get(572)).appendChild((Element)v.get(574));
      /* Termina nodo:574   */
      /* Termina nodo:572   */

      /* Empieza nodo:575 / Elemento padre: 567   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(575)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(575)).setAttribute("alto","22" );
      ((Element)v.get(575)).setAttribute("imgFondo","" );
      ((Element)v.get(575)).setAttribute("cod","00144" );
      ((Element)v.get(575)).setAttribute("ID","datosTitle" );
      ((Element)v.get(567)).appendChild((Element)v.get(575));
      /* Termina nodo:575   */

      /* Empieza nodo:576 / Elemento padre: 567   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(576)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(576)).setAttribute("alto","22" );
      ((Element)v.get(576)).setAttribute("imgFondo","" );
      ((Element)v.get(567)).appendChild((Element)v.get(576));
      /* Termina nodo:576   */

      /* Empieza nodo:577 / Elemento padre: 567   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(577)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(577)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(577)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(577)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(577)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(577)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(567)).appendChild((Element)v.get(577));

      /* Empieza nodo:578 / Elemento padre: 577   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(578)).setAttribute("ancho","100" );
      ((Element)v.get(578)).setAttribute("minimizable","S" );
      ((Element)v.get(578)).setAttribute("minimizada","N" );
      ((Element)v.get(577)).appendChild((Element)v.get(578));
      /* Termina nodo:578   */

      /* Empieza nodo:579 / Elemento padre: 577   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(579)).setAttribute("ancho","100" );
      ((Element)v.get(579)).setAttribute("minimizable","S" );
      ((Element)v.get(579)).setAttribute("minimizada","N" );
      ((Element)v.get(577)).appendChild((Element)v.get(579));
      /* Termina nodo:579   */

      /* Empieza nodo:580 / Elemento padre: 577   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(580)).setAttribute("ancho","100" );
      ((Element)v.get(580)).setAttribute("minimizable","S" );
      ((Element)v.get(580)).setAttribute("minimizada","N" );
      ((Element)v.get(577)).appendChild((Element)v.get(580));
      /* Termina nodo:580   */
      /* Termina nodo:577   */

      /* Empieza nodo:581 / Elemento padre: 567   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(581)).setAttribute("alto","20" );
      ((Element)v.get(581)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(581)).setAttribute("imgFondo","" );
      ((Element)v.get(581)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(567)).appendChild((Element)v.get(581));

      /* Empieza nodo:582 / Elemento padre: 581   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(582)).setAttribute("colFondo","" );
      ((Element)v.get(582)).setAttribute("ID","EstCab" );
      ((Element)v.get(582)).setAttribute("align","center" );
      ((Element)v.get(582)).setAttribute("cod","1350" );
      ((Element)v.get(581)).appendChild((Element)v.get(582));
      /* Termina nodo:582   */

      /* Empieza nodo:583 / Elemento padre: 581   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(583)).setAttribute("colFondo","" );
      ((Element)v.get(583)).setAttribute("ID","EstCab" );
      ((Element)v.get(583)).setAttribute("align","center" );
      ((Element)v.get(583)).setAttribute("cod","1352" );
      ((Element)v.get(581)).appendChild((Element)v.get(583));
      /* Termina nodo:583   */

      /* Empieza nodo:584 / Elemento padre: 581   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(584)).setAttribute("colFondo","" );
      ((Element)v.get(584)).setAttribute("ID","EstCab" );
      ((Element)v.get(584)).setAttribute("align","center" );
      ((Element)v.get(584)).setAttribute("cod","3392" );
      ((Element)v.get(581)).appendChild((Element)v.get(584));
      /* Termina nodo:584   */
      /* Termina nodo:581   */

      /* Empieza nodo:585 / Elemento padre: 567   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(585)).setAttribute("alto","22" );
      ((Element)v.get(585)).setAttribute("accion","" );
      ((Element)v.get(585)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(585)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(585)).setAttribute("maxSel","-1" );
      ((Element)v.get(585)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(585)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(585)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(585)).setAttribute("onLoad","" );
      ((Element)v.get(585)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(567)).appendChild((Element)v.get(585));

      /* Empieza nodo:586 / Elemento padre: 585   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(586)).setAttribute("tipo","texto" );
      ((Element)v.get(586)).setAttribute("ID","EstDat" );
      ((Element)v.get(585)).appendChild((Element)v.get(586));
      /* Termina nodo:586   */

      /* Empieza nodo:587 / Elemento padre: 585   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(587)).setAttribute("tipo","texto" );
      ((Element)v.get(587)).setAttribute("ID","EstDat2" );
      ((Element)v.get(585)).appendChild((Element)v.get(587));
      /* Termina nodo:587   */

      /* Empieza nodo:588 / Elemento padre: 585   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(588)).setAttribute("tipo","texto" );
      ((Element)v.get(588)).setAttribute("ID","EstDat" );
      ((Element)v.get(585)).appendChild((Element)v.get(588));
      /* Termina nodo:588   */
      /* Termina nodo:585   */

      /* Empieza nodo:589 / Elemento padre: 567   */
   }

   private void getXML2340(Document doc) {
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(567)).appendChild((Element)v.get(589));
      /* Termina nodo:589   */
      /* Termina nodo:567   */

      /* Empieza nodo:590 / Elemento padre: 7   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(590)).setAttribute("nombre","listado1" );
      ((Element)v.get(590)).setAttribute("ancho","722" );
      ((Element)v.get(590)).setAttribute("alto","317" );
      ((Element)v.get(590)).setAttribute("x","12" );
      ((Element)v.get(590)).setAttribute("y","657" );
      ((Element)v.get(590)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(590)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(7)).appendChild((Element)v.get(590));

      /* Empieza nodo:591 / Elemento padre: 590   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(591)).setAttribute("precarga","S" );
      ((Element)v.get(591)).setAttribute("conROver","S" );
      ((Element)v.get(590)).appendChild((Element)v.get(591));

      /* Empieza nodo:592 / Elemento padre: 591   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(592)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(592)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(592)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(592)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(591)).appendChild((Element)v.get(592));
      /* Termina nodo:592   */

      /* Empieza nodo:593 / Elemento padre: 591   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(593)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(593)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(593)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(593)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(591)).appendChild((Element)v.get(593));
      /* Termina nodo:593   */

      /* Empieza nodo:594 / Elemento padre: 591   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(594)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(594)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(591)).appendChild((Element)v.get(594));
      /* Termina nodo:594   */
      /* Termina nodo:591   */

      /* Empieza nodo:595 / Elemento padre: 590   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(590)).appendChild((Element)v.get(595));

      /* Empieza nodo:596 / Elemento padre: 595   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(596)).setAttribute("borde","1" );
      ((Element)v.get(596)).setAttribute("horizDatos","1" );
      ((Element)v.get(596)).setAttribute("horizCabecera","1" );
      ((Element)v.get(596)).setAttribute("vertical","0" );
      ((Element)v.get(596)).setAttribute("horizTitulo","1" );
      ((Element)v.get(596)).setAttribute("horizBase","1" );
      ((Element)v.get(595)).appendChild((Element)v.get(596));
      /* Termina nodo:596   */

      /* Empieza nodo:597 / Elemento padre: 595   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(597)).setAttribute("borde","#999999" );
      ((Element)v.get(597)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(597)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(597)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(597)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(597)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(597)).setAttribute("horizBase","#999999" );
      ((Element)v.get(595)).appendChild((Element)v.get(597));
      /* Termina nodo:597   */
      /* Termina nodo:595   */

      /* Empieza nodo:598 / Elemento padre: 590   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(598)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(598)).setAttribute("alto","22" );
      ((Element)v.get(598)).setAttribute("imgFondo","" );
      ((Element)v.get(598)).setAttribute("cod","00406" );
      ((Element)v.get(598)).setAttribute("ID","datosTitle" );
      ((Element)v.get(590)).appendChild((Element)v.get(598));
      /* Termina nodo:598   */

      /* Empieza nodo:599 / Elemento padre: 590   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(599)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(599)).setAttribute("alto","22" );
      ((Element)v.get(599)).setAttribute("imgFondo","" );
      ((Element)v.get(590)).appendChild((Element)v.get(599));
      /* Termina nodo:599   */

      /* Empieza nodo:600 / Elemento padre: 590   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(600)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(600)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(600)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(600)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(600)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(600)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(590)).appendChild((Element)v.get(600));

      /* Empieza nodo:601 / Elemento padre: 600   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(601)).setAttribute("ancho","100" );
      ((Element)v.get(601)).setAttribute("minimizable","S" );
      ((Element)v.get(601)).setAttribute("minimizada","N" );
      ((Element)v.get(600)).appendChild((Element)v.get(601));
      /* Termina nodo:601   */

      /* Empieza nodo:602 / Elemento padre: 600   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(602)).setAttribute("ancho","100" );
      ((Element)v.get(602)).setAttribute("minimizable","S" );
      ((Element)v.get(602)).setAttribute("minimizada","N" );
      ((Element)v.get(600)).appendChild((Element)v.get(602));
      /* Termina nodo:602   */

      /* Empieza nodo:603 / Elemento padre: 600   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(603)).setAttribute("ancho","100" );
      ((Element)v.get(603)).setAttribute("minimizable","S" );
      ((Element)v.get(603)).setAttribute("minimizada","N" );
      ((Element)v.get(600)).appendChild((Element)v.get(603));
      /* Termina nodo:603   */

      /* Empieza nodo:604 / Elemento padre: 600   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(604)).setAttribute("ancho","130" );
      ((Element)v.get(604)).setAttribute("minimizable","S" );
      ((Element)v.get(604)).setAttribute("minimizada","N" );
      ((Element)v.get(600)).appendChild((Element)v.get(604));
      /* Termina nodo:604   */

      /* Empieza nodo:605 / Elemento padre: 600   */
   }

   private void getXML2430(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(605)).setAttribute("ancho","100" );
      ((Element)v.get(605)).setAttribute("minimizable","S" );
      ((Element)v.get(605)).setAttribute("minimizada","N" );
      ((Element)v.get(600)).appendChild((Element)v.get(605));
      /* Termina nodo:605   */

      /* Empieza nodo:606 / Elemento padre: 600   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(606)).setAttribute("ancho","100" );
      ((Element)v.get(606)).setAttribute("minimizable","S" );
      ((Element)v.get(606)).setAttribute("minimizada","N" );
      ((Element)v.get(600)).appendChild((Element)v.get(606));
      /* Termina nodo:606   */

      /* Empieza nodo:607 / Elemento padre: 600   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(607)).setAttribute("ancho","100" );
      ((Element)v.get(607)).setAttribute("minimizable","S" );
      ((Element)v.get(607)).setAttribute("minimizada","N" );
      ((Element)v.get(600)).appendChild((Element)v.get(607));
      /* Termina nodo:607   */

      /* Empieza nodo:608 / Elemento padre: 600   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(608)).setAttribute("ancho","100" );
      ((Element)v.get(608)).setAttribute("minimizable","S" );
      ((Element)v.get(608)).setAttribute("minimizada","N" );
      ((Element)v.get(600)).appendChild((Element)v.get(608));
      /* Termina nodo:608   */

      /* Empieza nodo:609 / Elemento padre: 600   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(609)).setAttribute("ancho","100" );
      ((Element)v.get(609)).setAttribute("minimizable","S" );
      ((Element)v.get(609)).setAttribute("minimizada","N" );
      ((Element)v.get(600)).appendChild((Element)v.get(609));
      /* Termina nodo:609   */

      /* Empieza nodo:610 / Elemento padre: 600   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(610)).setAttribute("ancho","100" );
      ((Element)v.get(610)).setAttribute("minimizable","S" );
      ((Element)v.get(610)).setAttribute("minimizada","N" );
      ((Element)v.get(600)).appendChild((Element)v.get(610));
      /* Termina nodo:610   */
      /* Termina nodo:600   */

      /* Empieza nodo:611 / Elemento padre: 590   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(611)).setAttribute("alto","20" );
      ((Element)v.get(611)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(611)).setAttribute("imgFondo","" );
      ((Element)v.get(611)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(590)).appendChild((Element)v.get(611));

      /* Empieza nodo:612 / Elemento padre: 611   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(612)).setAttribute("colFondo","" );
      ((Element)v.get(612)).setAttribute("ID","EstCab" );
      ((Element)v.get(612)).setAttribute("align","center" );
      ((Element)v.get(612)).setAttribute("cod","276" );
      ((Element)v.get(611)).appendChild((Element)v.get(612));
      /* Termina nodo:612   */

      /* Empieza nodo:613 / Elemento padre: 611   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(613)).setAttribute("colFondo","" );
      ((Element)v.get(613)).setAttribute("ID","EstCab" );
      ((Element)v.get(613)).setAttribute("align","center" );
      ((Element)v.get(613)).setAttribute("cod","6" );
      ((Element)v.get(611)).appendChild((Element)v.get(613));
      /* Termina nodo:613   */

      /* Empieza nodo:614 / Elemento padre: 611   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(614)).setAttribute("colFondo","" );
      ((Element)v.get(614)).setAttribute("ID","EstCab" );
      ((Element)v.get(614)).setAttribute("align","center" );
      ((Element)v.get(614)).setAttribute("cod","7" );
      ((Element)v.get(611)).appendChild((Element)v.get(614));
      /* Termina nodo:614   */

      /* Empieza nodo:615 / Elemento padre: 611   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(615)).setAttribute("colFondo","" );
      ((Element)v.get(615)).setAttribute("ID","EstCab" );
      ((Element)v.get(615)).setAttribute("align","center" );
      ((Element)v.get(615)).setAttribute("cod","124" );
      ((Element)v.get(611)).appendChild((Element)v.get(615));
      /* Termina nodo:615   */

      /* Empieza nodo:616 / Elemento padre: 611   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(616)).setAttribute("colFondo","" );
      ((Element)v.get(616)).setAttribute("ID","EstCab" );
      ((Element)v.get(616)).setAttribute("align","center" );
      ((Element)v.get(616)).setAttribute("cod","109" );
      ((Element)v.get(611)).appendChild((Element)v.get(616));
      /* Termina nodo:616   */

      /* Empieza nodo:617 / Elemento padre: 611   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(617)).setAttribute("colFondo","" );
      ((Element)v.get(617)).setAttribute("ID","EstCab" );
      ((Element)v.get(617)).setAttribute("align","center" );
      ((Element)v.get(617)).setAttribute("cod","143" );
      ((Element)v.get(611)).appendChild((Element)v.get(617));
      /* Termina nodo:617   */

      /* Empieza nodo:618 / Elemento padre: 611   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(618)).setAttribute("colFondo","" );
      ((Element)v.get(618)).setAttribute("ID","EstCab" );
      ((Element)v.get(618)).setAttribute("align","center" );
      ((Element)v.get(618)).setAttribute("cod","112" );
      ((Element)v.get(611)).appendChild((Element)v.get(618));
      /* Termina nodo:618   */

      /* Empieza nodo:619 / Elemento padre: 611   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(619)).setAttribute("colFondo","" );
      ((Element)v.get(619)).setAttribute("ID","EstCab" );
      ((Element)v.get(619)).setAttribute("align","center" );
      ((Element)v.get(619)).setAttribute("cod","126" );
      ((Element)v.get(611)).appendChild((Element)v.get(619));
      /* Termina nodo:619   */

      /* Empieza nodo:620 / Elemento padre: 611   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(620)).setAttribute("colFondo","" );
      ((Element)v.get(620)).setAttribute("ID","EstCab" );
      ((Element)v.get(620)).setAttribute("align","center" );
      ((Element)v.get(620)).setAttribute("cod","905" );
      ((Element)v.get(611)).appendChild((Element)v.get(620));
      /* Termina nodo:620   */

      /* Empieza nodo:621 / Elemento padre: 611   */
   }

   private void getXML2520(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(621)).setAttribute("colFondo","" );
      ((Element)v.get(621)).setAttribute("ID","EstCab" );
      ((Element)v.get(621)).setAttribute("align","center" );
      ((Element)v.get(621)).setAttribute("cod","3400" );
      ((Element)v.get(611)).appendChild((Element)v.get(621));
      /* Termina nodo:621   */
      /* Termina nodo:611   */

      /* Empieza nodo:622 / Elemento padre: 590   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(622)).setAttribute("alto","22" );
      ((Element)v.get(622)).setAttribute("accion","" );
      ((Element)v.get(622)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(622)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(622)).setAttribute("maxSel","-1" );
      ((Element)v.get(622)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(622)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(622)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(622)).setAttribute("onLoad","" );
      ((Element)v.get(622)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(590)).appendChild((Element)v.get(622));

      /* Empieza nodo:623 / Elemento padre: 622   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(623)).setAttribute("tipo","texto" );
      ((Element)v.get(623)).setAttribute("ID","EstDat" );
      ((Element)v.get(622)).appendChild((Element)v.get(623));
      /* Termina nodo:623   */

      /* Empieza nodo:624 / Elemento padre: 622   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(624)).setAttribute("tipo","texto" );
      ((Element)v.get(624)).setAttribute("ID","EstDat2" );
      ((Element)v.get(622)).appendChild((Element)v.get(624));
      /* Termina nodo:624   */

      /* Empieza nodo:625 / Elemento padre: 622   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(625)).setAttribute("tipo","texto" );
      ((Element)v.get(625)).setAttribute("ID","EstDat" );
      ((Element)v.get(622)).appendChild((Element)v.get(625));
      /* Termina nodo:625   */

      /* Empieza nodo:626 / Elemento padre: 622   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(626)).setAttribute("tipo","texto" );
      ((Element)v.get(626)).setAttribute("ID","EstDat2" );
      ((Element)v.get(622)).appendChild((Element)v.get(626));
      /* Termina nodo:626   */

      /* Empieza nodo:627 / Elemento padre: 622   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(627)).setAttribute("tipo","texto" );
      ((Element)v.get(627)).setAttribute("ID","EstDat" );
      ((Element)v.get(622)).appendChild((Element)v.get(627));
      /* Termina nodo:627   */

      /* Empieza nodo:628 / Elemento padre: 622   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(628)).setAttribute("tipo","texto" );
      ((Element)v.get(628)).setAttribute("ID","EstDat2" );
      ((Element)v.get(622)).appendChild((Element)v.get(628));
      /* Termina nodo:628   */

      /* Empieza nodo:629 / Elemento padre: 622   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(629)).setAttribute("tipo","texto" );
      ((Element)v.get(629)).setAttribute("ID","EstDat" );
      ((Element)v.get(622)).appendChild((Element)v.get(629));
      /* Termina nodo:629   */

      /* Empieza nodo:630 / Elemento padre: 622   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(630)).setAttribute("tipo","texto" );
      ((Element)v.get(630)).setAttribute("ID","EstDat2" );
      ((Element)v.get(622)).appendChild((Element)v.get(630));
      /* Termina nodo:630   */

      /* Empieza nodo:631 / Elemento padre: 622   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(631)).setAttribute("tipo","texto" );
      ((Element)v.get(631)).setAttribute("ID","EstDat" );
      ((Element)v.get(622)).appendChild((Element)v.get(631));
      /* Termina nodo:631   */

      /* Empieza nodo:632 / Elemento padre: 622   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(632)).setAttribute("tipo","texto" );
      ((Element)v.get(632)).setAttribute("ID","EstDat2" );
      ((Element)v.get(622)).appendChild((Element)v.get(632));
      /* Termina nodo:632   */
      /* Termina nodo:622   */

      /* Empieza nodo:633 / Elemento padre: 590   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(590)).appendChild((Element)v.get(633));
      /* Termina nodo:633   */
      /* Termina nodo:590   */

      /* Empieza nodo:634 / Elemento padre: 7   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(634)).setAttribute("nombre","listado2" );
      ((Element)v.get(634)).setAttribute("ancho","722" );
      ((Element)v.get(634)).setAttribute("alto","184" );
      ((Element)v.get(634)).setAttribute("x","12" );
      ((Element)v.get(634)).setAttribute("y","990" );
      ((Element)v.get(634)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(634)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(7)).appendChild((Element)v.get(634));

      /* Empieza nodo:635 / Elemento padre: 634   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(635)).setAttribute("precarga","S" );
      ((Element)v.get(635)).setAttribute("conROver","S" );
      ((Element)v.get(634)).appendChild((Element)v.get(635));

      /* Empieza nodo:636 / Elemento padre: 635   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(636)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(636)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(636)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(636)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(635)).appendChild((Element)v.get(636));
      /* Termina nodo:636   */

      /* Empieza nodo:637 / Elemento padre: 635   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(637)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(637)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(637)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(637)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(635)).appendChild((Element)v.get(637));
      /* Termina nodo:637   */

      /* Empieza nodo:638 / Elemento padre: 635   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(638)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(638)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(635)).appendChild((Element)v.get(638));
      /* Termina nodo:638   */
      /* Termina nodo:635   */

      /* Empieza nodo:639 / Elemento padre: 634   */
      v.add(doc.createElement("LINEAS"));
   }

   private void getXML2610(Document doc) {
      ((Element)v.get(634)).appendChild((Element)v.get(639));

      /* Empieza nodo:640 / Elemento padre: 639   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(640)).setAttribute("borde","1" );
      ((Element)v.get(640)).setAttribute("horizDatos","1" );
      ((Element)v.get(640)).setAttribute("horizCabecera","1" );
      ((Element)v.get(640)).setAttribute("vertical","0" );
      ((Element)v.get(640)).setAttribute("horizTitulo","1" );
      ((Element)v.get(640)).setAttribute("horizBase","1" );
      ((Element)v.get(639)).appendChild((Element)v.get(640));
      /* Termina nodo:640   */

      /* Empieza nodo:641 / Elemento padre: 639   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(641)).setAttribute("borde","#999999" );
      ((Element)v.get(641)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(641)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(641)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(641)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(641)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(641)).setAttribute("horizBase","#999999" );
      ((Element)v.get(639)).appendChild((Element)v.get(641));
      /* Termina nodo:641   */
      /* Termina nodo:639   */

      /* Empieza nodo:642 / Elemento padre: 634   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(642)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(642)).setAttribute("alto","22" );
      ((Element)v.get(642)).setAttribute("imgFondo","" );
      ((Element)v.get(642)).setAttribute("cod","00408" );
      ((Element)v.get(642)).setAttribute("ID","datosTitle" );
      ((Element)v.get(634)).appendChild((Element)v.get(642));
      /* Termina nodo:642   */

      /* Empieza nodo:643 / Elemento padre: 634   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(643)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(643)).setAttribute("alto","22" );
      ((Element)v.get(643)).setAttribute("imgFondo","" );
      ((Element)v.get(634)).appendChild((Element)v.get(643));
      /* Termina nodo:643   */

      /* Empieza nodo:644 / Elemento padre: 634   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(644)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(644)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(644)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(644)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(644)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(644)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(634)).appendChild((Element)v.get(644));

      /* Empieza nodo:645 / Elemento padre: 644   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(645)).setAttribute("ancho","70" );
      ((Element)v.get(645)).setAttribute("minimizable","S" );
      ((Element)v.get(645)).setAttribute("minimizada","N" );
      ((Element)v.get(644)).appendChild((Element)v.get(645));
      /* Termina nodo:645   */

      /* Empieza nodo:646 / Elemento padre: 644   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(646)).setAttribute("ancho","100" );
      ((Element)v.get(646)).setAttribute("minimizable","S" );
      ((Element)v.get(646)).setAttribute("minimizada","N" );
      ((Element)v.get(644)).appendChild((Element)v.get(646));
      /* Termina nodo:646   */

      /* Empieza nodo:647 / Elemento padre: 644   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(647)).setAttribute("ancho","100" );
      ((Element)v.get(647)).setAttribute("minimizable","S" );
      ((Element)v.get(647)).setAttribute("minimizada","N" );
      ((Element)v.get(644)).appendChild((Element)v.get(647));
      /* Termina nodo:647   */

      /* Empieza nodo:648 / Elemento padre: 644   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(648)).setAttribute("ancho","100" );
      ((Element)v.get(648)).setAttribute("minimizable","S" );
      ((Element)v.get(648)).setAttribute("minimizada","N" );
      ((Element)v.get(644)).appendChild((Element)v.get(648));
      /* Termina nodo:648   */
      /* Termina nodo:644   */

      /* Empieza nodo:649 / Elemento padre: 634   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(649)).setAttribute("alto","20" );
      ((Element)v.get(649)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(649)).setAttribute("imgFondo","" );
      ((Element)v.get(649)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(634)).appendChild((Element)v.get(649));

      /* Empieza nodo:650 / Elemento padre: 649   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(650)).setAttribute("colFondo","" );
      ((Element)v.get(650)).setAttribute("ID","EstCab" );
      ((Element)v.get(650)).setAttribute("align","center" );
      ((Element)v.get(650)).setAttribute("cod","424" );
      ((Element)v.get(649)).appendChild((Element)v.get(650));
      /* Termina nodo:650   */

      /* Empieza nodo:651 / Elemento padre: 649   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(651)).setAttribute("colFondo","" );
      ((Element)v.get(651)).setAttribute("ID","EstCab" );
      ((Element)v.get(651)).setAttribute("align","center" );
      ((Element)v.get(651)).setAttribute("cod","1400" );
      ((Element)v.get(649)).appendChild((Element)v.get(651));
      /* Termina nodo:651   */

      /* Empieza nodo:652 / Elemento padre: 649   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(652)).setAttribute("colFondo","" );
      ((Element)v.get(652)).setAttribute("ID","EstCab" );
      ((Element)v.get(652)).setAttribute("align","center" );
      ((Element)v.get(652)).setAttribute("cod","1402" );
      ((Element)v.get(649)).appendChild((Element)v.get(652));
      /* Termina nodo:652   */

      /* Empieza nodo:653 / Elemento padre: 649   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(653)).setAttribute("colFondo","" );
      ((Element)v.get(653)).setAttribute("ID","EstCab" );
      ((Element)v.get(653)).setAttribute("align","center" );
      ((Element)v.get(653)).setAttribute("cod","2001" );
      ((Element)v.get(649)).appendChild((Element)v.get(653));
      /* Termina nodo:653   */
      /* Termina nodo:649   */

      /* Empieza nodo:654 / Elemento padre: 634   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(654)).setAttribute("alto","22" );
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(654)).setAttribute("accion","" );
      ((Element)v.get(654)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(654)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(654)).setAttribute("maxSel","-1" );
      ((Element)v.get(654)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(654)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(654)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(654)).setAttribute("onLoad","" );
      ((Element)v.get(654)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(634)).appendChild((Element)v.get(654));

      /* Empieza nodo:655 / Elemento padre: 654   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(655)).setAttribute("tipo","texto" );
      ((Element)v.get(655)).setAttribute("ID","EstDat" );
      ((Element)v.get(654)).appendChild((Element)v.get(655));
      /* Termina nodo:655   */

      /* Empieza nodo:656 / Elemento padre: 654   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(656)).setAttribute("tipo","texto" );
      ((Element)v.get(656)).setAttribute("ID","EstDat2" );
      ((Element)v.get(654)).appendChild((Element)v.get(656));
      /* Termina nodo:656   */

      /* Empieza nodo:657 / Elemento padre: 654   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(657)).setAttribute("tipo","texto" );
      ((Element)v.get(657)).setAttribute("ID","EstDat" );
      ((Element)v.get(654)).appendChild((Element)v.get(657));
      /* Termina nodo:657   */

      /* Empieza nodo:658 / Elemento padre: 654   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(658)).setAttribute("tipo","texto" );
      ((Element)v.get(658)).setAttribute("ID","EstDat2" );
      ((Element)v.get(654)).appendChild((Element)v.get(658));
      /* Termina nodo:658   */
      /* Termina nodo:654   */

      /* Empieza nodo:659 / Elemento padre: 634   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(634)).appendChild((Element)v.get(659));
      /* Termina nodo:659   */
      /* Termina nodo:634   */

      /* Empieza nodo:660 / Elemento padre: 7   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(660)).setAttribute("nombre","listado3" );
      ((Element)v.get(660)).setAttribute("ancho","722" );
      ((Element)v.get(660)).setAttribute("alto","301" );
      ((Element)v.get(660)).setAttribute("x","12" );
      ((Element)v.get(660)).setAttribute("y","1206" );
      ((Element)v.get(660)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(660)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(7)).appendChild((Element)v.get(660));

      /* Empieza nodo:661 / Elemento padre: 660   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(661)).setAttribute("precarga","S" );
      ((Element)v.get(661)).setAttribute("conROver","S" );
      ((Element)v.get(660)).appendChild((Element)v.get(661));

      /* Empieza nodo:662 / Elemento padre: 661   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(662)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(662)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(662)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(662)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(661)).appendChild((Element)v.get(662));
      /* Termina nodo:662   */

      /* Empieza nodo:663 / Elemento padre: 661   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(663)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(663)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(663)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(663)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(661)).appendChild((Element)v.get(663));
      /* Termina nodo:663   */

      /* Empieza nodo:664 / Elemento padre: 661   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(664)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(664)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(661)).appendChild((Element)v.get(664));
      /* Termina nodo:664   */
      /* Termina nodo:661   */

      /* Empieza nodo:665 / Elemento padre: 660   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(660)).appendChild((Element)v.get(665));

      /* Empieza nodo:666 / Elemento padre: 665   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(666)).setAttribute("borde","1" );
      ((Element)v.get(666)).setAttribute("horizDatos","1" );
      ((Element)v.get(666)).setAttribute("horizCabecera","1" );
      ((Element)v.get(666)).setAttribute("vertical","0" );
      ((Element)v.get(666)).setAttribute("horizTitulo","1" );
      ((Element)v.get(666)).setAttribute("horizBase","1" );
      ((Element)v.get(665)).appendChild((Element)v.get(666));
      /* Termina nodo:666   */

      /* Empieza nodo:667 / Elemento padre: 665   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(667)).setAttribute("borde","#999999" );
      ((Element)v.get(667)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(667)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(667)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(667)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(667)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(667)).setAttribute("horizBase","#999999" );
      ((Element)v.get(665)).appendChild((Element)v.get(667));
      /* Termina nodo:667   */
      /* Termina nodo:665   */

      /* Empieza nodo:668 / Elemento padre: 660   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(668)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(668)).setAttribute("alto","22" );
      ((Element)v.get(668)).setAttribute("imgFondo","" );
      ((Element)v.get(668)).setAttribute("cod","00409" );
      ((Element)v.get(668)).setAttribute("ID","datosTitle" );
      ((Element)v.get(660)).appendChild((Element)v.get(668));
      /* Termina nodo:668   */

      /* Empieza nodo:669 / Elemento padre: 660   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(669)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(669)).setAttribute("alto","22" );
      ((Element)v.get(669)).setAttribute("imgFondo","" );
      ((Element)v.get(660)).appendChild((Element)v.get(669));
      /* Termina nodo:669   */

      /* Empieza nodo:670 / Elemento padre: 660   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(670)).setAttribute("ajustarMinimo","S" );
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(670)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(670)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(670)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(670)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(670)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(660)).appendChild((Element)v.get(670));

      /* Empieza nodo:671 / Elemento padre: 670   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(671)).setAttribute("ancho","50" );
      ((Element)v.get(671)).setAttribute("minimizable","S" );
      ((Element)v.get(671)).setAttribute("minimizada","N" );
      ((Element)v.get(670)).appendChild((Element)v.get(671));
      /* Termina nodo:671   */

      /* Empieza nodo:672 / Elemento padre: 670   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(672)).setAttribute("ancho","105" );
      ((Element)v.get(672)).setAttribute("minimizable","S" );
      ((Element)v.get(672)).setAttribute("minimizada","N" );
      ((Element)v.get(670)).appendChild((Element)v.get(672));
      /* Termina nodo:672   */

      /* Empieza nodo:673 / Elemento padre: 670   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(673)).setAttribute("ancho","50" );
      ((Element)v.get(673)).setAttribute("minimizable","S" );
      ((Element)v.get(673)).setAttribute("minimizada","N" );
      ((Element)v.get(670)).appendChild((Element)v.get(673));
      /* Termina nodo:673   */

      /* Empieza nodo:674 / Elemento padre: 670   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(674)).setAttribute("ancho","95" );
      ((Element)v.get(674)).setAttribute("minimizable","S" );
      ((Element)v.get(674)).setAttribute("minimizada","N" );
      ((Element)v.get(670)).appendChild((Element)v.get(674));
      /* Termina nodo:674   */
      /* Termina nodo:670   */

      /* Empieza nodo:675 / Elemento padre: 660   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(675)).setAttribute("alto","20" );
      ((Element)v.get(675)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(675)).setAttribute("imgFondo","" );
      ((Element)v.get(675)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(660)).appendChild((Element)v.get(675));

      /* Empieza nodo:676 / Elemento padre: 675   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(676)).setAttribute("colFondo","" );
      ((Element)v.get(676)).setAttribute("ID","EstCab" );
      ((Element)v.get(676)).setAttribute("align","center" );
      ((Element)v.get(676)).setAttribute("cod","2002" );
      ((Element)v.get(675)).appendChild((Element)v.get(676));
      /* Termina nodo:676   */

      /* Empieza nodo:677 / Elemento padre: 675   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(677)).setAttribute("colFondo","" );
      ((Element)v.get(677)).setAttribute("ID","EstCab" );
      ((Element)v.get(677)).setAttribute("align","center" );
      ((Element)v.get(677)).setAttribute("cod","2003" );
      ((Element)v.get(675)).appendChild((Element)v.get(677));
      /* Termina nodo:677   */

      /* Empieza nodo:678 / Elemento padre: 675   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(678)).setAttribute("colFondo","" );
      ((Element)v.get(678)).setAttribute("ID","EstCab" );
      ((Element)v.get(678)).setAttribute("align","center" );
      ((Element)v.get(678)).setAttribute("cod","400" );
      ((Element)v.get(675)).appendChild((Element)v.get(678));
      /* Termina nodo:678   */

      /* Empieza nodo:679 / Elemento padre: 675   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(679)).setAttribute("colFondo","" );
      ((Element)v.get(679)).setAttribute("ID","EstCab" );
      ((Element)v.get(679)).setAttribute("align","center" );
      ((Element)v.get(679)).setAttribute("cod","1078" );
      ((Element)v.get(675)).appendChild((Element)v.get(679));
      /* Termina nodo:679   */
      /* Termina nodo:675   */

      /* Empieza nodo:680 / Elemento padre: 660   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(680)).setAttribute("alto","22" );
      ((Element)v.get(680)).setAttribute("accion","" );
      ((Element)v.get(680)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(680)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(680)).setAttribute("maxSel","1" );
      ((Element)v.get(680)).setAttribute("deseleccionaSiMaxSel","S" );
      ((Element)v.get(680)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(680)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(680)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(680)).setAttribute("onLoad","" );
      ((Element)v.get(680)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(660)).appendChild((Element)v.get(680));

      /* Empieza nodo:681 / Elemento padre: 680   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(681)).setAttribute("tipo","texto" );
      ((Element)v.get(681)).setAttribute("ID","EstDat" );
      ((Element)v.get(680)).appendChild((Element)v.get(681));
      /* Termina nodo:681   */

      /* Empieza nodo:682 / Elemento padre: 680   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(682)).setAttribute("tipo","texto" );
      ((Element)v.get(682)).setAttribute("ID","EstDat2" );
      ((Element)v.get(680)).appendChild((Element)v.get(682));
      /* Termina nodo:682   */

      /* Empieza nodo:683 / Elemento padre: 680   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(683)).setAttribute("tipo","texto" );
      ((Element)v.get(683)).setAttribute("ID","EstDat" );
      ((Element)v.get(680)).appendChild((Element)v.get(683));
      /* Termina nodo:683   */

      /* Empieza nodo:684 / Elemento padre: 680   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(684)).setAttribute("tipo","texto" );
      ((Element)v.get(684)).setAttribute("ID","EstDat2" );
      ((Element)v.get(680)).appendChild((Element)v.get(684));
      /* Termina nodo:684   */
      /* Termina nodo:680   */

      /* Empieza nodo:685 / Elemento padre: 660   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(660)).appendChild((Element)v.get(685));
      /* Termina nodo:685   */

      /* Empieza nodo:686 / Elemento padre: 660   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(686)).setAttribute("nombre","mipgndo3" );
      ((Element)v.get(686)).setAttribute("ancho","722" );
   }

   private void getXML2880(Document doc) {
      ((Element)v.get(686)).setAttribute("sep","$" );
      ((Element)v.get(686)).setAttribute("x","12" );
      ((Element)v.get(686)).setAttribute("class","botonera" );
      ((Element)v.get(686)).setAttribute("y","1314" );
      ((Element)v.get(686)).setAttribute("control","|" );
      ((Element)v.get(686)).setAttribute("conector","conectorSandra2" );
      ((Element)v.get(686)).setAttribute("onload","procesarPaginado(mipgndo3, msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(686)).setAttribute("rowset","" );
      ((Element)v.get(686)).setAttribute("cargainicial","N" );
      ((Element)v.get(660)).appendChild((Element)v.get(686));

      /* Empieza nodo:687 / Elemento padre: 686   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(687)).setAttribute("nombre","ret3" );
      ((Element)v.get(687)).setAttribute("x","37" );
      ((Element)v.get(687)).setAttribute("y","1488" );
      ((Element)v.get(687)).setAttribute("ID","botonContenido" );
      ((Element)v.get(687)).setAttribute("img","retroceder_on" );
      ((Element)v.get(687)).setAttribute("tipo","0" );
      ((Element)v.get(687)).setAttribute("estado","false" );
      ((Element)v.get(687)).setAttribute("alt","" );
      ((Element)v.get(687)).setAttribute("codigo","" );
      ((Element)v.get(687)).setAttribute("accion","mipgndo3.retroceder();" );
      ((Element)v.get(686)).appendChild((Element)v.get(687));
      /* Termina nodo:687   */

      /* Empieza nodo:688 / Elemento padre: 686   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(688)).setAttribute("nombre","ava3" );
      ((Element)v.get(688)).setAttribute("x","52" );
      ((Element)v.get(688)).setAttribute("y","1488" );
      ((Element)v.get(688)).setAttribute("ID","botonContenido" );
      ((Element)v.get(688)).setAttribute("img","avanzar_on" );
      ((Element)v.get(688)).setAttribute("tipo","0" );
      ((Element)v.get(688)).setAttribute("estado","false" );
      ((Element)v.get(688)).setAttribute("alt","" );
      ((Element)v.get(688)).setAttribute("codigo","" );
      ((Element)v.get(688)).setAttribute("accion","mipgndo3.avanzar();" );
      ((Element)v.get(686)).appendChild((Element)v.get(688));
      /* Termina nodo:688   */
      /* Termina nodo:686   */
      /* Termina nodo:660   */

      /* Empieza nodo:689 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(689)).setAttribute("nombre","primera3" );
      ((Element)v.get(689)).setAttribute("x","20" );
      ((Element)v.get(689)).setAttribute("y","1488" );
      ((Element)v.get(689)).setAttribute("ID","botonContenido" );
      ((Element)v.get(689)).setAttribute("img","primera_on" );
      ((Element)v.get(689)).setAttribute("tipo","-2" );
      ((Element)v.get(689)).setAttribute("estado","false" );
      ((Element)v.get(689)).setAttribute("alt","" );
      ((Element)v.get(689)).setAttribute("codigo","" );
      ((Element)v.get(689)).setAttribute("accion","mipgndo3.retrocederPrimeraPagina();" );
      ((Element)v.get(7)).appendChild((Element)v.get(689));
      /* Termina nodo:689   */

      /* Empieza nodo:690 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(690)).setAttribute("nombre","separa3" );
      ((Element)v.get(690)).setAttribute("x","59" );
      ((Element)v.get(690)).setAttribute("y","1484" );
      ((Element)v.get(690)).setAttribute("ID","botonContenido" );
      ((Element)v.get(690)).setAttribute("img","separa_base" );
      ((Element)v.get(690)).setAttribute("tipo","0" );
      ((Element)v.get(690)).setAttribute("estado","false" );
      ((Element)v.get(690)).setAttribute("alt","" );
      ((Element)v.get(690)).setAttribute("codigo","" );
      ((Element)v.get(690)).setAttribute("accion","" );
      ((Element)v.get(7)).appendChild((Element)v.get(690));
      /* Termina nodo:690   */
      /* Termina nodo:7   */

      /* Empieza nodo:691 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(691)).setAttribute("nombre","frmContenidoEnvia" );
      ((Element)v.get(691)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(691));

      /* Empieza nodo:692 / Elemento padre: 691   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(692)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(692)).setAttribute("valor","" );
      ((Element)v.get(691)).appendChild((Element)v.get(692));
      /* Termina nodo:692   */

      /* Empieza nodo:693 / Elemento padre: 691   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(693)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(693)).setAttribute("valor","" );
      ((Element)v.get(691)).appendChild((Element)v.get(693));
      /* Termina nodo:693   */

      /* Empieza nodo:694 / Elemento padre: 691   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(694)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(694)).setAttribute("valor","" );
      ((Element)v.get(691)).appendChild((Element)v.get(694));
      /* Termina nodo:694   */

      /* Empieza nodo:695 / Elemento padre: 691   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(691)).appendChild((Element)v.get(695));
      /* Termina nodo:695   */
      /* Termina nodo:691   */


   }

}

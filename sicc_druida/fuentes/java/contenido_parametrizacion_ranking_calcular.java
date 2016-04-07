
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_parametrizacion_ranking_calcular  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_parametrizacion_ranking_calcular" );
      ((Element)v.get(0)).setAttribute("cod","0527" );
      ((Element)v.get(0)).setAttribute("titulo","Calcular Ranking" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoad();" );
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
      ((Element)v.get(4)).setAttribute("src","contenido_parametrizacion_ranking_calcular.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(5)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","textNumAspirantes" );
      ((Element)v.get(7)).setAttribute("required","false" );
      ((Element)v.get(7)).setAttribute("cod","2447" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbNivelAgregacion" );
      ((Element)v.get(8)).setAttribute("required","false" );
      ((Element)v.get(8)).setAttribute("cod","1792" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbSubgerenciaVentas" );
      ((Element)v.get(9)).setAttribute("required","false" );
      ((Element)v.get(9)).setAttribute("cod","124" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbRegion" );
      ((Element)v.get(10)).setAttribute("required","false" );
      ((Element)v.get(10)).setAttribute("cod","109" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbZona" );
      ((Element)v.get(11)).setAttribute("required","false" );
      ((Element)v.get(11)).setAttribute("cod","143" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","cbSeccion" );
      ((Element)v.get(12)).setAttribute("required","false" );
      ((Element)v.get(12)).setAttribute("cod","112" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","cbTerritorio" );
      ((Element)v.get(13)).setAttribute("required","false" );
      ((Element)v.get(13)).setAttribute("cod","126" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */
      /* Termina nodo:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:14 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(14)).setAttribute("nombre","Formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","accion" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","idioma" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","pais" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","descConcurso" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","oidConcurso" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","version" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","descValorCalculo" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","oidValorCalculo" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","descBaseCalculo" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","oidBaseCalculo" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","oidDirigidoA" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","agrupacionGeneral" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","agrupacionSGV" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","agrupacionRegion" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","agrupacionZona" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","agrupacionSeccion" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","dirigidoGte" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","variablesVenta" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","oidTipoRanking" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 14   */
      v.add(doc.createElement("table"));
      ((Element)v.get(38)).setAttribute("width","100%" );
      ((Element)v.get(38)).setAttribute("border","0" );
      ((Element)v.get(38)).setAttribute("cellspacing","0" );
      ((Element)v.get(38)).setAttribute("cellpadding","0" );
      ((Element)v.get(14)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).setAttribute("width","12" );
      ((Element)v.get(40)).setAttribute("align","center" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).setAttribute("width","12" );
      ((Element)v.get(41)).setAttribute("height","12" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).setAttribute("width","750" );
      ((Element)v.get(39)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(44)).setAttribute("width","12" );
      ((Element)v.get(39)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(45)).setAttribute("width","12" );
      ((Element)v.get(45)).setAttribute("height","1" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */
      /* Termina nodo:39   */

      /* Empieza nodo:46 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(48)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(51)).setAttribute("class","legend" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(52)).setAttribute("nombre","lblDatosCabecera" );
      ((Element)v.get(52)).setAttribute("alto","13" );
      ((Element)v.get(52)).setAttribute("filas","1" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(52)).setAttribute("id","legend" );
      ((Element)v.get(52)).setAttribute("cod","00156" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 50   */
      v.add(doc.createElement("table"));
      ((Element)v.get(53)).setAttribute("width","100%" );
      ((Element)v.get(53)).setAttribute("border","0" );
      ((Element)v.get(53)).setAttribute("align","center" );
      ((Element)v.get(53)).setAttribute("cellspacing","0" );
      ((Element)v.get(53)).setAttribute("cellpadding","0" );
      ((Element)v.get(50)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("table"));
      ((Element)v.get(56)).setAttribute("width","525" );
      ((Element)v.get(56)).setAttribute("border","0" );
      ((Element)v.get(56)).setAttribute("align","left" );
      ((Element)v.get(56)).setAttribute("cellspacing","0" );
      ((Element)v.get(56)).setAttribute("cellpadding","0" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("colspan","9" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","8" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:60 / Elemento padre: 56   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(56)).appendChild((Element)v.get(60));

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
      ((Element)v.get(64)).setAttribute("nombre","lblNumConcurso" );
      ((Element)v.get(64)).setAttribute("alto","13" );
      ((Element)v.get(64)).setAttribute("filas","1" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(64)).setAttribute("id","datosTitle" );
      ((Element)v.get(64)).setAttribute("cod","1604" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","25" );
      ((Element)v.get(66)).setAttribute("height","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(68)).setAttribute("nombre","lblVersion" );
      ((Element)v.get(68)).setAttribute("alto","13" );
      ((Element)v.get(68)).setAttribute("filas","1" );
      ((Element)v.get(68)).setAttribute("valor","" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(68)).setAttribute("id","datosTitle" );
      ((Element)v.get(68)).setAttribute("cod","1607" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","25" );
      ((Element)v.get(70)).setAttribute("height","8" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(72)).setAttribute("nombre","lblValorCalculo" );
      ((Element)v.get(72)).setAttribute("alto","13" );
      ((Element)v.get(72)).setAttribute("filas","1" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(72)).setAttribute("id","datosTitle" );
      ((Element)v.get(72)).setAttribute("cod","2444" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","25" );
      ((Element)v.get(74)).setAttribute("height","8" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(76)).setAttribute("nombre","lblBaseCalculo" );
      ((Element)v.get(76)).setAttribute("alto","13" );
      ((Element)v.get(76)).setAttribute("filas","1" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(76)).setAttribute("id","datosTitle" );
      ((Element)v.get(76)).setAttribute("cod","1181" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("width","100%" );
      ((Element)v.get(60)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","8" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:60   */

      /* Empieza nodo:79 / Elemento padre: 56   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(56)).appendChild((Element)v.get(79));

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
      ((Element)v.get(79)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(83)).setAttribute("nombre","lbldtNumConcurso" );
      ((Element)v.get(83)).setAttribute("alto","13" );
      ((Element)v.get(83)).setAttribute("filas","1" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(83)).setAttribute("id","datosCampos" );
      ((Element)v.get(83)).setAttribute("codigo","" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","25" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(87)).setAttribute("nombre","lbldtVersion" );
      ((Element)v.get(87)).setAttribute("alto","13" );
      ((Element)v.get(87)).setAttribute("filas","1" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(87)).setAttribute("id","datosCampos" );
      ((Element)v.get(87)).setAttribute("codigo","" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","25" );
      ((Element)v.get(89)).setAttribute("height","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(91)).setAttribute("nombre","lbldtValorCalculo" );
      ((Element)v.get(91)).setAttribute("alto","13" );
      ((Element)v.get(91)).setAttribute("filas","1" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(91)).setAttribute("id","datosCampos" );
      ((Element)v.get(91)).setAttribute("codigo","" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","25" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(95)).setAttribute("nombre","lbldtBaseCalculo" );
      ((Element)v.get(95)).setAttribute("alto","13" );
      ((Element)v.get(95)).setAttribute("filas","1" );
      ((Element)v.get(95)).setAttribute("valor","" );
      ((Element)v.get(95)).setAttribute("id","datosCampos" );
      ((Element)v.get(95)).setAttribute("codigo","" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("width","100%" );
      ((Element)v.get(79)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","8" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:79   */

      /* Empieza nodo:98 / Elemento padre: 56   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(56)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("colspan","9" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","8" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:101 / Elemento padre: 46   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:46   */

      /* Empieza nodo:103 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("width","12" );
      ((Element)v.get(104)).setAttribute("align","center" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","12" );
      ((Element)v.get(105)).setAttribute("height","12" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).setAttribute("width","756" );
      ((Element)v.get(103)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","15" );
      ((Element)v.get(107)).setAttribute("height","15" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("width","12" );
      ((Element)v.get(103)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","12" );
      ((Element)v.get(109)).setAttribute("height","1" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:103   */

      /* Empieza nodo:110 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(115)).setAttribute("class","legend" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(116)).setAttribute("nombre","lblDatosParametrizacion" );
      ((Element)v.get(116)).setAttribute("alto","13" );
      ((Element)v.get(116)).setAttribute("filas","1" );
      ((Element)v.get(116)).setAttribute("valor","" );
      ((Element)v.get(116)).setAttribute("id","legend" );
      ((Element)v.get(116)).setAttribute("cod","00603" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 114   */
      v.add(doc.createElement("table"));
      ((Element)v.get(117)).setAttribute("width","100%" );
      ((Element)v.get(117)).setAttribute("border","0" );
      ((Element)v.get(117)).setAttribute("align","center" );
      ((Element)v.get(117)).setAttribute("cellspacing","0" );
      ((Element)v.get(117)).setAttribute("cellpadding","0" );
      ((Element)v.get(114)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).setAttribute("colspan","9" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).setAttribute("width","8" );
      ((Element)v.get(120)).setAttribute("height","328" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:121 / Elemento padre: 117   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(117)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("table"));
      ((Element)v.get(123)).setAttribute("width","525" );
      ((Element)v.get(123)).setAttribute("border","0" );
      ((Element)v.get(123)).setAttribute("align","left" );
      ((Element)v.get(123)).setAttribute("cellspacing","0" );
      ((Element)v.get(123)).setAttribute("cellpadding","0" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).setAttribute("colspan","9" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","8" );
      ((Element)v.get(126)).setAttribute("height","8" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:127 / Elemento padre: 123   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(123)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","10" );
      ((Element)v.get(129)).setAttribute("height","8" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(131)).setAttribute("nombre","lblNumAspirantes" );
      ((Element)v.get(131)).setAttribute("alto","13" );
      ((Element)v.get(131)).setAttribute("filas","1" );
      ((Element)v.get(131)).setAttribute("valor","" );
      ((Element)v.get(131)).setAttribute("id","datosTitle" );
      ((Element)v.get(131)).setAttribute("cod","3095" );
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
      ((Element)v.get(127)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(135)).setAttribute("nombre","lblNivelAgregacion" );
      ((Element)v.get(135)).setAttribute("alto","13" );
      ((Element)v.get(135)).setAttribute("filas","1" );
      ((Element)v.get(135)).setAttribute("valor","" );
      ((Element)v.get(135)).setAttribute("id","datosTitle" );
      ((Element)v.get(135)).setAttribute("cod","1792" );
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

      /* Empieza nodo:138 / Elemento padre: 123   */
      v.add(doc.createElement("tr"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(123)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","8" );
      ((Element)v.get(140)).setAttribute("height","8" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(142)).setAttribute("nombre","textNumAspirantes" );
      ((Element)v.get(142)).setAttribute("id","datosCampos" );
      ((Element)v.get(142)).setAttribute("max","3" );
      ((Element)v.get(142)).setAttribute("tipo","" );
      ((Element)v.get(142)).setAttribute("onchange","" );
      ((Element)v.get(142)).setAttribute("req","N" );
      ((Element)v.get(142)).setAttribute("size","3" );
      ((Element)v.get(142)).setAttribute("valor","" );
      ((Element)v.get(142)).setAttribute("validacion","" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","25" );
      ((Element)v.get(144)).setAttribute("height","8" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(138)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(146)).setAttribute("nombre","cbNivelAgregacion" );
      ((Element)v.get(146)).setAttribute("id","datosCampos" );
      ((Element)v.get(146)).setAttribute("size","1" );
      ((Element)v.get(146)).setAttribute("multiple","N" );
      ((Element)v.get(146)).setAttribute("req","N" );
      ((Element)v.get(146)).setAttribute("valorinicial","" );
      ((Element)v.get(146)).setAttribute("textoinicial","" );
      ((Element)v.get(146)).setAttribute("onchange","onchangeAgrupacion();" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:148 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).setAttribute("width","100%" );
      ((Element)v.get(138)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","8" );
      ((Element)v.get(149)).setAttribute("height","12" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:138   */

      /* Empieza nodo:150 / Elemento padre: 123   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(123)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).setAttribute("colspan","9" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).setAttribute("width","8" );
      ((Element)v.get(152)).setAttribute("height","12" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:150   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:153 / Elemento padre: 117   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(117)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("table"));
      ((Element)v.get(155)).setAttribute("width","100%" );
      ((Element)v.get(155)).setAttribute("border","0" );
      ((Element)v.get(155)).setAttribute("align","center" );
      ((Element)v.get(155)).setAttribute("cellspacing","0" );
      ((Element)v.get(155)).setAttribute("cellpadding","0" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).setAttribute("width","12" );
      ((Element)v.get(157)).setAttribute("align","center" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(158)).setAttribute("width","12" );
      ((Element)v.get(158)).setAttribute("height","12" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).setAttribute("width","732" );
      ((Element)v.get(156)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).setAttribute("width","12" );
      ((Element)v.get(160)).setAttribute("height","12" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).setAttribute("width","12" );
      ((Element)v.get(156)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(162)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).setAttribute("width","12" );
      ((Element)v.get(162)).setAttribute("height","1" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:156   */

      /* Empieza nodo:163 / Elemento padre: 155   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(155)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(165)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(168)).setAttribute("class","legend" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(169)).setAttribute("nombre","lblNivelGeografico" );
      ((Element)v.get(169)).setAttribute("alto","13" );
      ((Element)v.get(169)).setAttribute("filas","1" );
      ((Element)v.get(169)).setAttribute("valor","" );
      ((Element)v.get(169)).setAttribute("id","legend" );
      ((Element)v.get(169)).setAttribute("cod","00446" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 167   */
      v.add(doc.createElement("table"));
      ((Element)v.get(170)).setAttribute("width","100%" );
      ((Element)v.get(170)).setAttribute("border","0" );
      ((Element)v.get(170)).setAttribute("align","center" );
      ((Element)v.get(170)).setAttribute("cellspacing","0" );
      ((Element)v.get(170)).setAttribute("cellpadding","0" );
      ((Element)v.get(167)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("table"));
      ((Element)v.get(173)).setAttribute("width","501" );
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
      ((Element)v.get(175)).setAttribute("colspan","5" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(176)).setAttribute("src","b.gif" );
      ((Element)v.get(176)).setAttribute("width","8" );
      ((Element)v.get(176)).setAttribute("height","8" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:177 / Elemento padre: 173   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(173)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).setAttribute("width","8" );
      ((Element)v.get(179)).setAttribute("height","8" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(181)).setAttribute("nombre","lblSubgerenciaVentas" );
      ((Element)v.get(181)).setAttribute("alto","13" );
      ((Element)v.get(181)).setAttribute("filas","1" );
      ((Element)v.get(181)).setAttribute("valor","" );
      ((Element)v.get(181)).setAttribute("id","datosTitle" );
      ((Element)v.get(181)).setAttribute("cod","124" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(183)).setAttribute("src","b.gif" );
      ((Element)v.get(183)).setAttribute("width","25" );
      ((Element)v.get(183)).setAttribute("height","8" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(185)).setAttribute("nombre","lblRegion" );
      ((Element)v.get(185)).setAttribute("alto","13" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(185)).setAttribute("filas","1" );
      ((Element)v.get(185)).setAttribute("valor","" );
      ((Element)v.get(185)).setAttribute("id","datosTitle" );
      ((Element)v.get(185)).setAttribute("cod","109" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).setAttribute("width","100%" );
      ((Element)v.get(177)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(187)).setAttribute("src","b.gif" );
      ((Element)v.get(187)).setAttribute("width","8" );
      ((Element)v.get(187)).setAttribute("height","8" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */
      /* Termina nodo:177   */

      /* Empieza nodo:188 / Elemento padre: 173   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(173)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","8" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(188)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(192)).setAttribute("nombre","cbSubgerenciaVentas" );
      ((Element)v.get(192)).setAttribute("id","datosCampos" );
      ((Element)v.get(192)).setAttribute("size","5" );
      ((Element)v.get(192)).setAttribute("multiple","S" );
      ((Element)v.get(192)).setAttribute("req","N" );
      ((Element)v.get(192)).setAttribute("valorinicial","" );
      ((Element)v.get(192)).setAttribute("textoinicial","" );
      ((Element)v.get(192)).setAttribute("onchange","onchangeSGV();" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:194 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(195)).setAttribute("src","b.gif" );
      ((Element)v.get(195)).setAttribute("width","25" );
      ((Element)v.get(195)).setAttribute("height","8" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(196)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(188)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(197)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(197)).setAttribute("id","datosCampos" );
      ((Element)v.get(197)).setAttribute("size","5" );
      ((Element)v.get(197)).setAttribute("multiple","S" );
      ((Element)v.get(197)).setAttribute("req","N" );
      ((Element)v.get(197)).setAttribute("valorinicial","" );
      ((Element)v.get(197)).setAttribute("textoinicial","" );
      ((Element)v.get(197)).setAttribute("onchange","onchangeRegion();" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:199 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).setAttribute("width","100%" );
      ((Element)v.get(188)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(200)).setAttribute("src","b.gif" );
      ((Element)v.get(200)).setAttribute("width","8" );
      ((Element)v.get(200)).setAttribute("height","8" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:188   */

      /* Empieza nodo:201 / Elemento padre: 173   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(173)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).setAttribute("colspan","5" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(203)).setAttribute("src","b.gif" );
      ((Element)v.get(203)).setAttribute("width","8" );
      ((Element)v.get(203)).setAttribute("height","8" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */
      /* Termina nodo:201   */
      /* Termina nodo:173   */
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:204 / Elemento padre: 170   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(170)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(204)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("table"));
      ((Element)v.get(206)).setAttribute("width","501" );
      ((Element)v.get(206)).setAttribute("border","0" );
      ((Element)v.get(206)).setAttribute("align","left" );
      ((Element)v.get(206)).setAttribute("cellspacing","0" );
      ((Element)v.get(206)).setAttribute("cellpadding","0" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(206)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","8" );
      ((Element)v.get(209)).setAttribute("height","8" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(211)).setAttribute("nombre","lblZona" );
      ((Element)v.get(211)).setAttribute("alto","13" );
      ((Element)v.get(211)).setAttribute("filas","1" );
      ((Element)v.get(211)).setAttribute("valor","" );
      ((Element)v.get(211)).setAttribute("id","datosTitle" );
      ((Element)v.get(211)).setAttribute("cod","143" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(213)).setAttribute("src","b.gif" );
      ((Element)v.get(213)).setAttribute("width","25" );
      ((Element)v.get(213)).setAttribute("height","8" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:214 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(215)).setAttribute("nombre","lblSeccion" );
      ((Element)v.get(215)).setAttribute("alto","13" );
      ((Element)v.get(215)).setAttribute("filas","1" );
      ((Element)v.get(215)).setAttribute("valor","" );
      ((Element)v.get(215)).setAttribute("id","datosTitle" );
      ((Element)v.get(215)).setAttribute("cod","112" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:216 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).setAttribute("width","100%" );
      ((Element)v.get(207)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(217)).setAttribute("src","b.gif" );
      ((Element)v.get(217)).setAttribute("width","8" );
      ((Element)v.get(217)).setAttribute("height","8" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */
      /* Termina nodo:207   */

      /* Empieza nodo:218 / Elemento padre: 206   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(206)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(220)).setAttribute("src","b.gif" );
      ((Element)v.get(220)).setAttribute("width","8" );
      ((Element)v.get(220)).setAttribute("height","8" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:221 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(218)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(222)).setAttribute("nombre","cbZona" );
      ((Element)v.get(222)).setAttribute("id","datosCampos" );
      ((Element)v.get(222)).setAttribute("size","5" );
      ((Element)v.get(222)).setAttribute("multiple","S" );
      ((Element)v.get(222)).setAttribute("req","N" );
      ((Element)v.get(222)).setAttribute("valorinicial","" );
      ((Element)v.get(222)).setAttribute("textoinicial","" );
      ((Element)v.get(222)).setAttribute("onchange","onchangeZona();" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:224 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(225)).setAttribute("src","b.gif" );
      ((Element)v.get(225)).setAttribute("width","25" );
      ((Element)v.get(225)).setAttribute("height","8" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:226 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(218)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(227)).setAttribute("nombre","cbSeccion" );
      ((Element)v.get(227)).setAttribute("id","datosCampos" );
      ((Element)v.get(227)).setAttribute("size","5" );
      ((Element)v.get(227)).setAttribute("multiple","S" );
      ((Element)v.get(227)).setAttribute("req","N" );
      ((Element)v.get(227)).setAttribute("valorinicial","" );
      ((Element)v.get(227)).setAttribute("textoinicial","" );
      ((Element)v.get(227)).setAttribute("onchange","onchangeSeccion();" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:229 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).setAttribute("width","100%" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(218)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(230)).setAttribute("width","8" );
      ((Element)v.get(230)).setAttribute("height","8" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */
      /* Termina nodo:218   */

      /* Empieza nodo:231 / Elemento padre: 206   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(206)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).setAttribute("colspan","5" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(233)).setAttribute("src","b.gif" );
      ((Element)v.get(233)).setAttribute("width","8" );
      ((Element)v.get(233)).setAttribute("height","8" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */
      /* Termina nodo:231   */
      /* Termina nodo:206   */
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:234 / Elemento padre: 170   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(170)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("table"));
      ((Element)v.get(236)).setAttribute("width","501" );
      ((Element)v.get(236)).setAttribute("border","0" );
      ((Element)v.get(236)).setAttribute("align","left" );
      ((Element)v.get(236)).setAttribute("cellspacing","0" );
      ((Element)v.get(236)).setAttribute("cellpadding","0" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(239)).setAttribute("src","b.gif" );
      ((Element)v.get(239)).setAttribute("width","8" );
      ((Element)v.get(239)).setAttribute("height","8" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:240 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(241)).setAttribute("nombre","lblTerritorio" );
      ((Element)v.get(241)).setAttribute("alto","13" );
      ((Element)v.get(241)).setAttribute("filas","1" );
      ((Element)v.get(241)).setAttribute("valor","" );
      ((Element)v.get(241)).setAttribute("id","datosTitle" );
      ((Element)v.get(241)).setAttribute("cod","126" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:242 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).setAttribute("width","100%" );
      ((Element)v.get(237)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(243)).setAttribute("src","b.gif" );
      ((Element)v.get(243)).setAttribute("width","8" );
      ((Element)v.get(243)).setAttribute("height","8" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */
      /* Termina nodo:237   */

      /* Empieza nodo:244 / Elemento padre: 236   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(236)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(246)).setAttribute("src","b.gif" );
      ((Element)v.get(246)).setAttribute("width","8" );
      ((Element)v.get(246)).setAttribute("height","8" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:247 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(244)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(248)).setAttribute("nombre","cbTerritorio" );
      ((Element)v.get(248)).setAttribute("id","datosCampos" );
      ((Element)v.get(248)).setAttribute("size","5" );
      ((Element)v.get(248)).setAttribute("multiple","S" );
      ((Element)v.get(248)).setAttribute("req","N" );
      ((Element)v.get(248)).setAttribute("valorinicial","" );
      ((Element)v.get(248)).setAttribute("textoinicial","" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */
      /* Termina nodo:247   */

      /* Empieza nodo:250 / Elemento padre: 244   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).setAttribute("width","100%" );
      ((Element)v.get(244)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(251)).setAttribute("src","b.gif" );
      ((Element)v.get(251)).setAttribute("width","8" );
      ((Element)v.get(251)).setAttribute("height","8" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */
      /* Termina nodo:244   */

      /* Empieza nodo:252 / Elemento padre: 236   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(236)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(253)).setAttribute("colspan","3" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(254)).setAttribute("src","b.gif" );
      ((Element)v.get(254)).setAttribute("width","8" );
      ((Element)v.get(254)).setAttribute("height","12" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */
      /* Termina nodo:252   */
      /* Termina nodo:236   */
      /* Termina nodo:235   */
      /* Termina nodo:234   */
      /* Termina nodo:170   */
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:255 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(256)).setAttribute("src","b.gif" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */
      /* Termina nodo:163   */

      /* Empieza nodo:257 / Elemento padre: 155   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(155)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).setAttribute("colspan","3" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(259)).setAttribute("src","b.gif" );
      ((Element)v.get(259)).setAttribute("width","8" );
      ((Element)v.get(259)).setAttribute("height","12" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */
      /* Termina nodo:257   */
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:117   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:260 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(261)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */
      /* Termina nodo:110   */

      /* Empieza nodo:262 / Elemento padre: 38   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(38)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("td"));
      ((Element)v.get(262)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(264)).setAttribute("src","b.gif" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */

      /* Empieza nodo:265 / Elemento padre: 262   */
      v.add(doc.createElement("td"));
      ((Element)v.get(262)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(265)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("table"));
      ((Element)v.get(267)).setAttribute("width","100%" );
      ((Element)v.get(267)).setAttribute("border","0" );
      ((Element)v.get(267)).setAttribute("align","center" );
      ((Element)v.get(267)).setAttribute("cellspacing","0" );
      ((Element)v.get(267)).setAttribute("cellpadding","0" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(267)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("td"));
      ((Element)v.get(269)).setAttribute("class","botonera" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(270)).setAttribute("nombre","btnCalcular" );
      ((Element)v.get(270)).setAttribute("ID","botonContenido" );
      ((Element)v.get(270)).setAttribute("tipo","html" );
      ((Element)v.get(270)).setAttribute("accion","calcularOnclick()" );
      ((Element)v.get(270)).setAttribute("estado","false" );
      ((Element)v.get(270)).setAttribute("cod","1300" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:269   */
      /* Termina nodo:268   */
      /* Termina nodo:267   */
      /* Termina nodo:266   */
      /* Termina nodo:265   */

      /* Empieza nodo:271 / Elemento padre: 262   */
      v.add(doc.createElement("td"));
      ((Element)v.get(262)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(272)).setAttribute("src","b.gif" );
      ((Element)v.get(272)).setAttribute("width","8" );
      ((Element)v.get(272)).setAttribute("height","12" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:271   */
      /* Termina nodo:262   */
      /* Termina nodo:38   */

      /* Empieza nodo:273 / Elemento padre: 14   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(273)).setAttribute("nombre","listado1" );
      ((Element)v.get(273)).setAttribute("ancho","580" );
      ((Element)v.get(273)).setAttribute("alto","300" );
      ((Element)v.get(273)).setAttribute("x","24" );
      ((Element)v.get(273)).setAttribute("y","108" );
      ((Element)v.get(273)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(273)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(14)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(274)).setAttribute("precarga","S" );
      ((Element)v.get(274)).setAttribute("conROver","S" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(275)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(275)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(275)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(275)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */

      /* Empieza nodo:276 / Elemento padre: 274   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(276)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(276)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(276)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(276)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(274)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */

      /* Empieza nodo:277 / Elemento padre: 274   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(277)).setAttribute("ordenar","ascendente_on.gif" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(277)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(274)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:274   */

      /* Empieza nodo:278 / Elemento padre: 273   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(273)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(279)).setAttribute("borde","1" );
      ((Element)v.get(279)).setAttribute("horizDatos","1" );
      ((Element)v.get(279)).setAttribute("horizCabecera","1" );
      ((Element)v.get(279)).setAttribute("vertical","1" );
      ((Element)v.get(279)).setAttribute("horizTitulo","1" );
      ((Element)v.get(279)).setAttribute("horizBase","1" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */

      /* Empieza nodo:280 / Elemento padre: 278   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(280)).setAttribute("borde","#999999" );
      ((Element)v.get(280)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(280)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(280)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(280)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(280)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(280)).setAttribute("horizBase","#999999" );
      ((Element)v.get(278)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:278   */

      /* Empieza nodo:281 / Elemento padre: 273   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(281)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(281)).setAttribute("alto","22" );
      ((Element)v.get(281)).setAttribute("imgFondo","" );
      ((Element)v.get(281)).setAttribute("cod","00605" );
      ((Element)v.get(281)).setAttribute("ID","datosTitle" );
      ((Element)v.get(273)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */

      /* Empieza nodo:282 / Elemento padre: 273   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(282)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(282)).setAttribute("alto","22" );
      ((Element)v.get(282)).setAttribute("imgFondo","" );
      ((Element)v.get(273)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */

      /* Empieza nodo:283 / Elemento padre: 273   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(283)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(283)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(283)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(283)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(283)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(283)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(273)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(284)).setAttribute("ancho","50" );
      ((Element)v.get(284)).setAttribute("minimizable","S" );
      ((Element)v.get(284)).setAttribute("minimizada","N" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */

      /* Empieza nodo:285 / Elemento padre: 283   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(285)).setAttribute("ancho","50" );
      ((Element)v.get(285)).setAttribute("minimizable","S" );
      ((Element)v.get(285)).setAttribute("minimizada","N" );
      ((Element)v.get(283)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */

      /* Empieza nodo:286 / Elemento padre: 283   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(286)).setAttribute("ancho","50" );
      ((Element)v.get(286)).setAttribute("minimizable","S" );
      ((Element)v.get(286)).setAttribute("minimizada","N" );
      ((Element)v.get(283)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */

      /* Empieza nodo:287 / Elemento padre: 283   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(287)).setAttribute("ancho","50" );
      ((Element)v.get(287)).setAttribute("minimizable","S" );
      ((Element)v.get(287)).setAttribute("minimizada","N" );
      ((Element)v.get(283)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:283   */

      /* Empieza nodo:288 / Elemento padre: 273   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(288)).setAttribute("alto","20" );
      ((Element)v.get(288)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(288)).setAttribute("imgFondo","" );
      ((Element)v.get(288)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(273)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(289)).setAttribute("colFondo","" );
      ((Element)v.get(289)).setAttribute("ID","EstCab" );
      ((Element)v.get(289)).setAttribute("cod","2449" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */

      /* Empieza nodo:290 / Elemento padre: 288   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(290)).setAttribute("colFondo","" );
      ((Element)v.get(290)).setAttribute("ID","EstCab" );
      ((Element)v.get(290)).setAttribute("cod","2445" );
      ((Element)v.get(288)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */

      /* Empieza nodo:291 / Elemento padre: 288   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(291)).setAttribute("colFondo","" );
      ((Element)v.get(291)).setAttribute("ID","EstCab" );
      ((Element)v.get(291)).setAttribute("cod","2446" );
      ((Element)v.get(288)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */

      /* Empieza nodo:292 / Elemento padre: 288   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(292)).setAttribute("colFondo","" );
      ((Element)v.get(292)).setAttribute("ID","EstCab" );
      ((Element)v.get(292)).setAttribute("cod","2447" );
      ((Element)v.get(288)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:288   */

      /* Empieza nodo:293 / Elemento padre: 273   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(293)).setAttribute("alto","22" );
      ((Element)v.get(293)).setAttribute("accion","" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(293)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(293)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(293)).setAttribute("maxSel","-1" );
      ((Element)v.get(293)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(293)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(293)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(293)).setAttribute("onLoad","" );
      ((Element)v.get(293)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(273)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(294)).setAttribute("tipo","texto" );
      ((Element)v.get(294)).setAttribute("ID","EstDat" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */

      /* Empieza nodo:295 / Elemento padre: 293   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(295)).setAttribute("tipo","texto" );
      ((Element)v.get(295)).setAttribute("ID","EstDat2" );
      ((Element)v.get(293)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */

      /* Empieza nodo:296 / Elemento padre: 293   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(296)).setAttribute("tipo","texto" );
      ((Element)v.get(296)).setAttribute("ID","EstDat" );
      ((Element)v.get(293)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */

      /* Empieza nodo:297 / Elemento padre: 293   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(297)).setAttribute("tipo","texto" );
      ((Element)v.get(297)).setAttribute("ID","EstDat2" );
      ((Element)v.get(293)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:293   */

      /* Empieza nodo:298 / Elemento padre: 273   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(273)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */

      /* Empieza nodo:299 / Elemento padre: 273   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(299)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(299)).setAttribute("ancho","580" );
      ((Element)v.get(299)).setAttribute("sep","$" );
      ((Element)v.get(299)).setAttribute("x","12" );
      ((Element)v.get(299)).setAttribute("class","botonera" );
      ((Element)v.get(299)).setAttribute("y","385" );
      ((Element)v.get(299)).setAttribute("control","|" );
      ((Element)v.get(299)).setAttribute("conector","conector_inc" );
      ((Element)v.get(299)).setAttribute("rowset","" );
      ((Element)v.get(299)).setAttribute("cargainicial","N" );
      ((Element)v.get(273)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(300)).setAttribute("nombre","ret1" );
      ((Element)v.get(300)).setAttribute("x","49" );
      ((Element)v.get(300)).setAttribute("y","389" );
      ((Element)v.get(300)).setAttribute("ID","botonContenido" );
      ((Element)v.get(300)).setAttribute("img","retroceder_on" );
      ((Element)v.get(300)).setAttribute("tipo","0" );
      ((Element)v.get(300)).setAttribute("estado","false" );
      ((Element)v.get(300)).setAttribute("alt","" );
      ((Element)v.get(300)).setAttribute("codigo","" );
      ((Element)v.get(300)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */

      /* Empieza nodo:301 / Elemento padre: 299   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(301)).setAttribute("nombre","ava1" );
      ((Element)v.get(301)).setAttribute("x","64" );
      ((Element)v.get(301)).setAttribute("y","389" );
      ((Element)v.get(301)).setAttribute("ID","botonContenido" );
      ((Element)v.get(301)).setAttribute("img","avanzar_on" );
      ((Element)v.get(301)).setAttribute("tipo","0" );
      ((Element)v.get(301)).setAttribute("estado","false" );
      ((Element)v.get(301)).setAttribute("alt","" );
      ((Element)v.get(301)).setAttribute("codigo","" );
      ((Element)v.get(301)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(299)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:299   */
      /* Termina nodo:273   */

      /* Empieza nodo:302 / Elemento padre: 14   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(302)).setAttribute("nombre","primera1" );
      ((Element)v.get(302)).setAttribute("x","32" );
      ((Element)v.get(302)).setAttribute("y","389" );
      ((Element)v.get(302)).setAttribute("ID","botonContenido" );
      ((Element)v.get(302)).setAttribute("img","primera_on" );
      ((Element)v.get(302)).setAttribute("tipo","-2" );
      ((Element)v.get(302)).setAttribute("estado","false" );
      ((Element)v.get(302)).setAttribute("alt","" );
      ((Element)v.get(302)).setAttribute("codigo","" );
      ((Element)v.get(302)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(14)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */

      /* Empieza nodo:303 / Elemento padre: 14   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(303)).setAttribute("nombre","separa" );
      ((Element)v.get(303)).setAttribute("x","71" );
      ((Element)v.get(303)).setAttribute("y","385" );
      ((Element)v.get(303)).setAttribute("ID","botonContenido" );
      ((Element)v.get(303)).setAttribute("img","separa_base" );
      ((Element)v.get(303)).setAttribute("tipo","0" );
      ((Element)v.get(303)).setAttribute("estado","false" );
      ((Element)v.get(303)).setAttribute("alt","" );
      ((Element)v.get(303)).setAttribute("codigo","" );
      ((Element)v.get(303)).setAttribute("accion","" );
      ((Element)v.get(14)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */

      /* Empieza nodo:304 / Elemento padre: 14   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(304)).setAttribute("nombre","listado2" );
      ((Element)v.get(304)).setAttribute("ancho","606" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(304)).setAttribute("alto","300" );
      ((Element)v.get(304)).setAttribute("x","12" );
      ((Element)v.get(304)).setAttribute("y","835" );
      ((Element)v.get(304)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(304)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(14)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(305)).setAttribute("precarga","S" );
      ((Element)v.get(305)).setAttribute("conROver","S" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(306)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(306)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(306)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(306)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */

      /* Empieza nodo:307 / Elemento padre: 305   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(307)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(307)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(307)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(307)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(305)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */

      /* Empieza nodo:308 / Elemento padre: 305   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(308)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(308)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(305)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:305   */

      /* Empieza nodo:309 / Elemento padre: 304   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(304)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(310)).setAttribute("borde","1" );
      ((Element)v.get(310)).setAttribute("horizDatos","1" );
      ((Element)v.get(310)).setAttribute("horizCabecera","1" );
      ((Element)v.get(310)).setAttribute("vertical","1" );
      ((Element)v.get(310)).setAttribute("horizTitulo","1" );
      ((Element)v.get(310)).setAttribute("horizBase","1" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */

      /* Empieza nodo:311 / Elemento padre: 309   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(311)).setAttribute("borde","#999999" );
      ((Element)v.get(311)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(311)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(311)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(311)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(311)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(311)).setAttribute("horizBase","#999999" );
      ((Element)v.get(309)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:309   */

      /* Empieza nodo:312 / Elemento padre: 304   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(312)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(312)).setAttribute("alto","22" );
      ((Element)v.get(312)).setAttribute("imgFondo","" );
      ((Element)v.get(312)).setAttribute("cod","00606" );
      ((Element)v.get(312)).setAttribute("ID","datosTitle" );
      ((Element)v.get(304)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */

      /* Empieza nodo:313 / Elemento padre: 304   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(313)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(313)).setAttribute("alto","22" );
      ((Element)v.get(313)).setAttribute("imgFondo","" );
      ((Element)v.get(304)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */

      /* Empieza nodo:314 / Elemento padre: 304   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(314)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(314)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(314)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(314)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(314)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(314)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(304)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(315)).setAttribute("ancho","50" );
      ((Element)v.get(315)).setAttribute("minimizable","S" );
      ((Element)v.get(315)).setAttribute("minimizada","N" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */

      /* Empieza nodo:316 / Elemento padre: 314   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(316)).setAttribute("ancho","50" );
      ((Element)v.get(316)).setAttribute("minimizable","S" );
      ((Element)v.get(316)).setAttribute("minimizada","N" );
      ((Element)v.get(314)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */

      /* Empieza nodo:317 / Elemento padre: 314   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(317)).setAttribute("ancho","50" );
      ((Element)v.get(317)).setAttribute("minimizable","S" );
      ((Element)v.get(317)).setAttribute("minimizada","N" );
      ((Element)v.get(314)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */

      /* Empieza nodo:318 / Elemento padre: 314   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(318)).setAttribute("ancho","50" );
      ((Element)v.get(318)).setAttribute("minimizable","S" );
      ((Element)v.get(318)).setAttribute("minimizada","N" );
      ((Element)v.get(314)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */

      /* Empieza nodo:319 / Elemento padre: 314   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(319)).setAttribute("ancho","50" );
      ((Element)v.get(319)).setAttribute("minimizable","S" );
      ((Element)v.get(319)).setAttribute("minimizada","N" );
      ((Element)v.get(319)).setAttribute("oculta","S" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(314)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */

      /* Empieza nodo:320 / Elemento padre: 314   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(320)).setAttribute("ancho","50" );
      ((Element)v.get(320)).setAttribute("minimizable","S" );
      ((Element)v.get(320)).setAttribute("minimizada","N" );
      ((Element)v.get(320)).setAttribute("oculta","S" );
      ((Element)v.get(314)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */

      /* Empieza nodo:321 / Elemento padre: 314   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(321)).setAttribute("ancho","50" );
      ((Element)v.get(321)).setAttribute("minimizable","S" );
      ((Element)v.get(321)).setAttribute("minimizada","N" );
      ((Element)v.get(321)).setAttribute("oculta","S" );
      ((Element)v.get(314)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:314   */

      /* Empieza nodo:322 / Elemento padre: 304   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(322)).setAttribute("alto","20" );
      ((Element)v.get(322)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(322)).setAttribute("imgFondo","" );
      ((Element)v.get(322)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(304)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(323)).setAttribute("colFondo","" );
      ((Element)v.get(323)).setAttribute("ID","EstCab" );
      ((Element)v.get(323)).setAttribute("cod","2449" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */

      /* Empieza nodo:324 / Elemento padre: 322   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(324)).setAttribute("colFondo","" );
      ((Element)v.get(324)).setAttribute("ID","EstCab" );
      ((Element)v.get(324)).setAttribute("cod","2445" );
      ((Element)v.get(322)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */

      /* Empieza nodo:325 / Elemento padre: 322   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(325)).setAttribute("colFondo","" );
      ((Element)v.get(325)).setAttribute("ID","EstCab" );
      ((Element)v.get(325)).setAttribute("cod","2446" );
      ((Element)v.get(322)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */

      /* Empieza nodo:326 / Elemento padre: 322   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(326)).setAttribute("colFondo","" );
      ((Element)v.get(326)).setAttribute("ID","EstCab" );
      ((Element)v.get(326)).setAttribute("cod","1691" );
      ((Element)v.get(322)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */

      /* Empieza nodo:327 / Elemento padre: 322   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(327)).setAttribute("colFondo","" );
      ((Element)v.get(327)).setAttribute("ID","EstCab" );
      ((Element)v.get(327)).setAttribute("cod","2445" );
      ((Element)v.get(322)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */

      /* Empieza nodo:328 / Elemento padre: 322   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(328)).setAttribute("colFondo","" );
      ((Element)v.get(328)).setAttribute("ID","EstCab" );
      ((Element)v.get(328)).setAttribute("cod","2446" );
      ((Element)v.get(322)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */

      /* Empieza nodo:329 / Elemento padre: 322   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(329)).setAttribute("colFondo","" );
      ((Element)v.get(329)).setAttribute("ID","EstCab" );
      ((Element)v.get(329)).setAttribute("cod","1691" );
      ((Element)v.get(322)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:322   */

      /* Empieza nodo:330 / Elemento padre: 304   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(330)).setAttribute("alto","22" );
      ((Element)v.get(330)).setAttribute("accion","" );
      ((Element)v.get(330)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(330)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(330)).setAttribute("maxSel","-1" );
      ((Element)v.get(330)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(330)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(330)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(330)).setAttribute("onLoad","" );
      ((Element)v.get(330)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(304)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(331)).setAttribute("tipo","texto" );
      ((Element)v.get(331)).setAttribute("ID","EstDat" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */

      /* Empieza nodo:332 / Elemento padre: 330   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(332)).setAttribute("tipo","texto" );
      ((Element)v.get(332)).setAttribute("ID","EstDat2" );
      ((Element)v.get(330)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */

      /* Empieza nodo:333 / Elemento padre: 330   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(333)).setAttribute("tipo","texto" );
      ((Element)v.get(333)).setAttribute("ID","EstDat" );
      ((Element)v.get(330)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */

      /* Empieza nodo:334 / Elemento padre: 330   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(334)).setAttribute("tipo","texto" );
      ((Element)v.get(334)).setAttribute("ID","EstDat2" );
      ((Element)v.get(330)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */

      /* Empieza nodo:335 / Elemento padre: 330   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(335)).setAttribute("tipo","texto" );
      ((Element)v.get(335)).setAttribute("ID","EstDat" );
      ((Element)v.get(330)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */

      /* Empieza nodo:336 / Elemento padre: 330   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(336)).setAttribute("tipo","texto" );
      ((Element)v.get(336)).setAttribute("ID","EstDat2" );
      ((Element)v.get(330)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */

      /* Empieza nodo:337 / Elemento padre: 330   */
   }

   private void getXML1440(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(337)).setAttribute("tipo","texto" );
      ((Element)v.get(337)).setAttribute("ID","EstDat" );
      ((Element)v.get(330)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */
      /* Termina nodo:330   */

      /* Empieza nodo:338 / Elemento padre: 304   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(304)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */

      /* Empieza nodo:339 / Elemento padre: 304   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(339)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(339)).setAttribute("ancho","606" );
      ((Element)v.get(339)).setAttribute("sep","$" );
      ((Element)v.get(339)).setAttribute("x","12" );
      ((Element)v.get(339)).setAttribute("class","botonera" );
      ((Element)v.get(339)).setAttribute("y","1112" );
      ((Element)v.get(339)).setAttribute("control","|" );
      ((Element)v.get(339)).setAttribute("conector","conector_inc2" );
      ((Element)v.get(339)).setAttribute("rowset","" );
      ((Element)v.get(339)).setAttribute("cargainicial","N" );
      ((Element)v.get(304)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(340)).setAttribute("nombre","ret2" );
      ((Element)v.get(340)).setAttribute("x","37" );
      ((Element)v.get(340)).setAttribute("y","1116" );
      ((Element)v.get(340)).setAttribute("ID","botonContenido" );
      ((Element)v.get(340)).setAttribute("img","retroceder_on" );
      ((Element)v.get(340)).setAttribute("tipo","0" );
      ((Element)v.get(340)).setAttribute("estado","false" );
      ((Element)v.get(340)).setAttribute("alt","" );
      ((Element)v.get(340)).setAttribute("codigo","" );
      ((Element)v.get(340)).setAttribute("accion","mipgndo2.retroceder();" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */

      /* Empieza nodo:341 / Elemento padre: 339   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(341)).setAttribute("nombre","ava2" );
      ((Element)v.get(341)).setAttribute("x","52" );
      ((Element)v.get(341)).setAttribute("y","1116" );
      ((Element)v.get(341)).setAttribute("ID","botonContenido" );
      ((Element)v.get(341)).setAttribute("img","avanzar_on" );
      ((Element)v.get(341)).setAttribute("tipo","0" );
      ((Element)v.get(341)).setAttribute("estado","false" );
      ((Element)v.get(341)).setAttribute("alt","" );
      ((Element)v.get(341)).setAttribute("codigo","" );
      ((Element)v.get(341)).setAttribute("accion","mipgndo2.avanzar();" );
      ((Element)v.get(339)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */
      /* Termina nodo:339   */
      /* Termina nodo:304   */

      /* Empieza nodo:342 / Elemento padre: 14   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(342)).setAttribute("nombre","primera2" );
      ((Element)v.get(342)).setAttribute("x","20" );
      ((Element)v.get(342)).setAttribute("y","1116" );
      ((Element)v.get(342)).setAttribute("ID","botonContenido" );
      ((Element)v.get(342)).setAttribute("img","primera_on" );
      ((Element)v.get(342)).setAttribute("tipo","-2" );
      ((Element)v.get(342)).setAttribute("estado","false" );
      ((Element)v.get(342)).setAttribute("alt","" );
      ((Element)v.get(342)).setAttribute("codigo","" );
      ((Element)v.get(342)).setAttribute("accion","mipgndo2.retrocederPrimeraPagina();" );
      ((Element)v.get(14)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */

      /* Empieza nodo:343 / Elemento padre: 14   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(343)).setAttribute("nombre","separa2" );
      ((Element)v.get(343)).setAttribute("x","59" );
      ((Element)v.get(343)).setAttribute("y","1112" );
      ((Element)v.get(343)).setAttribute("ID","botonContenido" );
      ((Element)v.get(343)).setAttribute("img","separa_base" );
      ((Element)v.get(343)).setAttribute("tipo","0" );
      ((Element)v.get(343)).setAttribute("estado","false" );
      ((Element)v.get(343)).setAttribute("alt","" );
      ((Element)v.get(343)).setAttribute("codigo","" );
      ((Element)v.get(343)).setAttribute("accion","" );
      ((Element)v.get(14)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */

      /* Empieza nodo:344 / Elemento padre: 14   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(344)).setAttribute("nombre","btnGanadoras2" );
      ((Element)v.get(344)).setAttribute("x","80" );
      ((Element)v.get(344)).setAttribute("y","1113" );
      ((Element)v.get(344)).setAttribute("ID","botonContenido" );
      ((Element)v.get(344)).setAttribute("img","" );
      ((Element)v.get(344)).setAttribute("tipo","html" );
      ((Element)v.get(344)).setAttribute("estado","false" );
      ((Element)v.get(344)).setAttribute("cod","2451" );
      ((Element)v.get(344)).setAttribute("accion","ganadorasOnClick();" );
      ((Element)v.get(14)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */

      /* Empieza nodo:345 / Elemento padre: 14   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(345)).setAttribute("nombre","capaEspacio2" );
      ((Element)v.get(345)).setAttribute("alto","12" );
      ((Element)v.get(345)).setAttribute("ancho","100" );
      ((Element)v.get(345)).setAttribute("colorf","" );
      ((Element)v.get(345)).setAttribute("borde","0" );
      ((Element)v.get(345)).setAttribute("imagenf","" );
      ((Element)v.get(345)).setAttribute("repeat","" );
      ((Element)v.get(345)).setAttribute("padding","" );
      ((Element)v.get(345)).setAttribute("visibilidad","visible" );
      ((Element)v.get(345)).setAttribute("contravsb","" );
      ((Element)v.get(345)).setAttribute("x","0" );
      ((Element)v.get(345)).setAttribute("y","1135" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(345)).setAttribute("zindex","" );
      ((Element)v.get(14)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */
      /* Termina nodo:14   */


   }

}


import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_mapa_zonas_lineas_armado_insertar_temp  implements es.indra.druida.base.ObjetoXML {
   private ArrayList v = new ArrayList();

   public Element getXML (Document doc){
      

      getXML0(doc);
         

      getXML90(doc);
         

      getXML180(doc);
         

      getXML270(doc);
         

      getXML360(doc);
         

      getXML450(doc);
         

      getXML540(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_mapa_zonas_lineas_armado_insertar" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","" );
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
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(5)).setAttribute("nombre","formulario" );
      ((Element)v.get(5)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(6)).setAttribute("nombre","capa1" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("table"));
      ((Element)v.get(7)).setAttribute("width","100%" );
      ((Element)v.get(7)).setAttribute("border","0" );
      ((Element)v.get(7)).setAttribute("cellspacing","0" );
      ((Element)v.get(7)).setAttribute("cellpadding","0" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(7)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("td"));
      ((Element)v.get(9)).setAttribute("width","12" );
      ((Element)v.get(9)).setAttribute("align","center" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(10)).setAttribute("src","b.gif" );
      ((Element)v.get(10)).setAttribute("width","12" );
      ((Element)v.get(10)).setAttribute("height","12" );
      ((Element)v.get(9)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */
      /* Termina nodo:9   */

      /* Empieza nodo:11 / Elemento padre: 8   */
      v.add(doc.createElement("td"));
      ((Element)v.get(11)).setAttribute("width","750" );
      ((Element)v.get(8)).appendChild((Element)v.get(11));

      /* Empieza nodo:12 / Elemento padre: 11   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(12)).setAttribute("src","b.gif" );
      ((Element)v.get(11)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */
      /* Termina nodo:11   */

      /* Empieza nodo:13 / Elemento padre: 8   */
      v.add(doc.createElement("td"));
      ((Element)v.get(13)).setAttribute("width","12" );
      ((Element)v.get(8)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(14)).setAttribute("src","b.gif" );
      ((Element)v.get(14)).setAttribute("width","12" );
      ((Element)v.get(14)).setAttribute("height","1" );
      ((Element)v.get(13)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */
      /* Termina nodo:13   */
      /* Termina nodo:8   */

      /* Empieza nodo:15 / Elemento padre: 7   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(7)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(15)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(17)).setAttribute("src","b.gif" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */
      /* Termina nodo:16   */

      /* Empieza nodo:18 / Elemento padre: 15   */
      v.add(doc.createElement("td"));
      ((Element)v.get(15)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(18)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(20)).setAttribute("class","legend" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(21)).setAttribute("nombre","lblDatosDeAlta" );
      ((Element)v.get(21)).setAttribute("alto","13" );
      ((Element)v.get(21)).setAttribute("filas","1" );
      ((Element)v.get(21)).setAttribute("cod","00127" );
      ((Element)v.get(21)).setAttribute("id","legend" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */
      /* Termina nodo:20   */

      /* Empieza nodo:22 / Elemento padre: 19   */
      v.add(doc.createElement("table"));
      ((Element)v.get(22)).setAttribute("width","100%" );
      ((Element)v.get(22)).setAttribute("border","0" );
      ((Element)v.get(22)).setAttribute("align","center" );
      ((Element)v.get(22)).setAttribute("cellspacing","0" );
      ((Element)v.get(22)).setAttribute("cellpadding","0" );
      ((Element)v.get(19)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(24)).setAttribute("colspan","4" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(25)).setAttribute("width","8" );
      ((Element)v.get(25)).setAttribute("height","8" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */
      /* Termina nodo:23   */

      /* Empieza nodo:26 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(28)).setAttribute("width","8" );
      ((Element)v.get(28)).setAttribute("height","8" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:29 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(30)).setAttribute("nombre","lblCentroDistribucion" );
      ((Element)v.get(30)).setAttribute("alto","13" );
      ((Element)v.get(30)).setAttribute("filas","1" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(30)).setAttribute("id","datosTitle" );
      ((Element)v.get(30)).setAttribute("cod","2054" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:31 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(32)).setAttribute("src","b.gif" );
      ((Element)v.get(32)).setAttribute("width","25" );
      ((Element)v.get(32)).setAttribute("height","8" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:33 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(34)).setAttribute("nombre","lblMapaCentroDistribucion" );
      ((Element)v.get(34)).setAttribute("alto","13" );
      ((Element)v.get(34)).setAttribute("filas","1" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(34)).setAttribute("id","datosTitle" );
      ((Element)v.get(34)).setAttribute("cod","2925" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:35 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).setAttribute("width","100%" );
      ((Element)v.get(26)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(36)).setAttribute("src","b.gif" );
      ((Element)v.get(36)).setAttribute("width","8" );
      ((Element)v.get(36)).setAttribute("height","8" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */
      /* Termina nodo:26   */

      /* Empieza nodo:37 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).setAttribute("width","8" );
      ((Element)v.get(39)).setAttribute("height","8" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(37)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(41)).setAttribute("nombre","cbCentroDistribucion" );
      ((Element)v.get(41)).setAttribute("id","datosCampos" );
      ((Element)v.get(41)).setAttribute("size","1" );
      ((Element)v.get(41)).setAttribute("multiple","N" );
      ((Element)v.get(41)).setAttribute("req","S" );
      ((Element)v.get(41)).setAttribute("onchange","" );
      ((Element)v.get(41)).setAttribute("onshtab","" );
      ((Element)v.get(41)).setAttribute("valorinicial","" );
      ((Element)v.get(41)).setAttribute("textoinicial","" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:43 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).setAttribute("width","25" );
      ((Element)v.get(44)).setAttribute("height","8" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(37)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(46)).setAttribute("nombre","cbMapaCentroDistribucion" );
      ((Element)v.get(46)).setAttribute("id","datosCampos" );
      ((Element)v.get(46)).setAttribute("size","1" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(46)).setAttribute("multiple","N" );
      ((Element)v.get(46)).setAttribute("req","S" );
      ((Element)v.get(46)).setAttribute("onchange","" );
      ((Element)v.get(46)).setAttribute("onshtab","" );
      ((Element)v.get(46)).setAttribute("valorinicial","" );
      ((Element)v.get(46)).setAttribute("textoinicial","" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:48 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).setAttribute("width","100%" );
      ((Element)v.get(37)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","8" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:37   */

      /* Empieza nodo:50 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).setAttribute("colspan","4" );
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
      /* Termina nodo:22   */

      /* Empieza nodo:53 / Elemento padre: 19   */
      v.add(doc.createElement("table"));
      ((Element)v.get(53)).setAttribute("width","100%" );
      ((Element)v.get(53)).setAttribute("border","0" );
      ((Element)v.get(53)).setAttribute("align","center" );
      ((Element)v.get(53)).setAttribute("cellspacing","0" );
      ((Element)v.get(53)).setAttribute("cellpadding","0" );
      ((Element)v.get(19)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).setAttribute("colspan","4" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","8" );
      ((Element)v.get(56)).setAttribute("height","8" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:57 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","8" );
      ((Element)v.get(59)).setAttribute("height","8" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(61)).setAttribute("nombre","lblMapaZonas" );
      ((Element)v.get(61)).setAttribute("alto","13" );
      ((Element)v.get(61)).setAttribute("filas","1" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(61)).setAttribute("id","datosTitle" );
      ((Element)v.get(61)).setAttribute("cod","2968" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","8" );
      ((Element)v.get(63)).setAttribute("height","8" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(65)).setAttribute("nombre","lblLineas" );
      ((Element)v.get(65)).setAttribute("alto","13" );
      ((Element)v.get(65)).setAttribute("filas","1" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(65)).setAttribute("id","datosTitle" );
      ((Element)v.get(65)).setAttribute("cod","2968" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("width","100%" );
      ((Element)v.get(57)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","8" );
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:57   */

      /* Empieza nodo:68 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","8" );
      ((Element)v.get(70)).setAttribute("height","8" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(68)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(72)).setAttribute("nombre","txtMapaZonas" );
      ((Element)v.get(72)).setAttribute("id","datosCampos" );
      ((Element)v.get(72)).setAttribute("max","30" );
      ((Element)v.get(72)).setAttribute("tipo","" );
      ((Element)v.get(72)).setAttribute("onchange","" );
      ((Element)v.get(72)).setAttribute("onshtab","" );
      ((Element)v.get(72)).setAttribute("req","S" );
      ((Element)v.get(72)).setAttribute("size","30" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(72)).setAttribute("validacion","" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","8" );
      ((Element)v.get(74)).setAttribute("height","8" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(68)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(76)).setAttribute("nombre","cbLineas" );
      ((Element)v.get(76)).setAttribute("id","datosCampos" );
      ((Element)v.get(76)).setAttribute("size","1" );
      ((Element)v.get(76)).setAttribute("multiple","N" );
      ((Element)v.get(76)).setAttribute("req","S" );
      ((Element)v.get(76)).setAttribute("onchange","" );
      ((Element)v.get(76)).setAttribute("onshtab","" );
      ((Element)v.get(76)).setAttribute("valorinicial","" );
      ((Element)v.get(76)).setAttribute("textoinicial","" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:78 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("width","100%" );
      ((Element)v.get(68)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","8" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:68   */

      /* Empieza nodo:80 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).setAttribute("colspan","4" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","8" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:53   */

      /* Empieza nodo:83 / Elemento padre: 19   */
      v.add(doc.createElement("table"));
      ((Element)v.get(83)).setAttribute("width","100%" );
      ((Element)v.get(83)).setAttribute("border","0" );
      ((Element)v.get(83)).setAttribute("align","center" );
      ((Element)v.get(83)).setAttribute("cellspacing","0" );
      ((Element)v.get(83)).setAttribute("cellpadding","0" );
      ((Element)v.get(83)).setAttribute("height","350" );
      ((Element)v.get(19)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).setAttribute("colspan","4" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","8" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:19   */
      /* Termina nodo:18   */
      /* Termina nodo:15   */
      /* Termina nodo:7   */
      /* Termina nodo:6   */

      /* Empieza nodo:87 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(87)).setAttribute("nombre","capaLista" );
      ((Element)v.get(87)).setAttribute("ancho","95%" );
      ((Element)v.get(87)).setAttribute("alto","330" );
      ((Element)v.get(87)).setAttribute("x","17" );
      ((Element)v.get(87)).setAttribute("y","150" );
      ((Element)v.get(87)).setAttribute("colorf","" );
      ((Element)v.get(87)).setAttribute("borde","0" );
      ((Element)v.get(87)).setAttribute("imagenf","" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(87)).setAttribute("repeat","" );
      ((Element)v.get(87)).setAttribute("padding","" );
      ((Element)v.get(87)).setAttribute("visibilidad","" );
      ((Element)v.get(87)).setAttribute("contravsb","" );
      ((Element)v.get(87)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(88)).setAttribute("nombre","listado1" );
      ((Element)v.get(88)).setAttribute("ancho","369" );
      ((Element)v.get(88)).setAttribute("alto","301" );
      ((Element)v.get(88)).setAttribute("x","12" );
      ((Element)v.get(88)).setAttribute("y","0" );
      ((Element)v.get(88)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(88)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(89)).setAttribute("precarga","S" );
      ((Element)v.get(89)).setAttribute("conROver","S" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(90)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(90)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(90)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(90)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 89   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(91)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(91)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(91)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(91)).setAttribute("aximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(89)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 89   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(92)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(92)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(89)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:89   */

      /* Empieza nodo:93 / Elemento padre: 88   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(88)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(94)).setAttribute("borde","1" );
      ((Element)v.get(94)).setAttribute("horizDatos","1" );
      ((Element)v.get(94)).setAttribute("horizCabecera","1" );
      ((Element)v.get(94)).setAttribute("vertical","1" );
      ((Element)v.get(94)).setAttribute("horizTitulo","1" );
      ((Element)v.get(94)).setAttribute("horizBase","1" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 93   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(95)).setAttribute("borde","#999999" );
      ((Element)v.get(95)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(95)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(95)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(95)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(95)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(95)).setAttribute("horizBase","#999999" );
      ((Element)v.get(93)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:93   */

      /* Empieza nodo:96 / Elemento padre: 88   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(96)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(96)).setAttribute("alto","22" );
      ((Element)v.get(96)).setAttribute("imgFondo","" );
      ((Element)v.get(96)).setAttribute("cod","00133" );
      ((Element)v.get(96)).setAttribute("ID","datosTitle" );
      ((Element)v.get(88)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 88   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(97)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(97)).setAttribute("alto","22" );
      ((Element)v.get(97)).setAttribute("imgFondo","" );
      ((Element)v.get(88)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 88   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(98)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(98)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(98)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(98)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(98)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(98)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(88)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(99)).setAttribute("ancho","50" );
      ((Element)v.get(99)).setAttribute("minimizable","S" );
      ((Element)v.get(99)).setAttribute("minimizada","N" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(100)).setAttribute("ancho","50" );
      ((Element)v.get(100)).setAttribute("minimizable","S" );
      ((Element)v.get(100)).setAttribute("minimizada","N" );
      ((Element)v.get(98)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(101)).setAttribute("ancho","50" );
      ((Element)v.get(101)).setAttribute("minimizable","S" );
      ((Element)v.get(101)).setAttribute("minimizada","N" );
      ((Element)v.get(98)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 98   */
      v.add(doc.createElement("COL"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(102)).setAttribute("ancho","50" );
      ((Element)v.get(102)).setAttribute("minimizable","S" );
      ((Element)v.get(102)).setAttribute("minimizada","N" );
      ((Element)v.get(98)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:98   */

      /* Empieza nodo:103 / Elemento padre: 88   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(103)).setAttribute("alto","25" );
      ((Element)v.get(103)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(103)).setAttribute("imgFondo","" );
      ((Element)v.get(103)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(88)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(104)).setAttribute("colFondo","" );
      ((Element)v.get(104)).setAttribute("ID","EstCab" );
      ((Element)v.get(104)).setAttribute("cod","2929" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Elemento padre:104 / Elemento actual: 105   */
      v.add(doc.createTextNode("Sublinea"));
      ((Element)v.get(104)).appendChild((Text)v.get(105));

      /* Termina nodo Texto:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 103   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(106)).setAttribute("colFondo","" );
      ((Element)v.get(106)).setAttribute("ID","EstCab" );
      ((Element)v.get(106)).setAttribute("cod","IntAccesBuzonIvrzn.zzonOidZona.label" );
      ((Element)v.get(103)).appendChild((Element)v.get(106));

      /* Elemento padre:106 / Elemento actual: 107   */
      v.add(doc.createTextNode("Zona"));
      ((Element)v.get(106)).appendChild((Text)v.get(107));

      /* Termina nodo Texto:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 103   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(108)).setAttribute("colFondo","" );
      ((Element)v.get(108)).setAttribute("ID","EstCab" );
      ((Element)v.get(108)).setAttribute("cod","2930" );
      ((Element)v.get(103)).appendChild((Element)v.get(108));

      /* Elemento padre:108 / Elemento actual: 109   */
      v.add(doc.createTextNode("Bahia inicial"));
      ((Element)v.get(108)).appendChild((Text)v.get(109));

      /* Termina nodo Texto:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 103   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(110)).setAttribute("colFondo","" );
      ((Element)v.get(110)).setAttribute("ID","EstCab" );
      ((Element)v.get(110)).setAttribute("cod","2931" );
      ((Element)v.get(103)).appendChild((Element)v.get(110));

      /* Elemento padre:110 / Elemento actual: 111   */
      v.add(doc.createTextNode("bahia final"));
      ((Element)v.get(110)).appendChild((Text)v.get(111));

      /* Termina nodo Texto:111   */
      /* Termina nodo:110   */
      /* Termina nodo:103   */

      /* Empieza nodo:112 / Elemento padre: 88   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(112)).setAttribute("alto","22" );
      ((Element)v.get(112)).setAttribute("accion","" );
      ((Element)v.get(112)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(112)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(112)).setAttribute("maxSel","-1" );
      ((Element)v.get(112)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(112)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(112)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(112)).setAttribute("onLoad","" );
      ((Element)v.get(112)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(88)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(113)).setAttribute("tipo","combo" );
      ((Element)v.get(113)).setAttribute("nombre","comboTipoCajaProducto" );
      ((Element)v.get(113)).setAttribute("IDOBJ","EstDatForm" );
      ((Element)v.get(113)).setAttribute("ID","EstDat" );
      ((Element)v.get(113)).setAttribute("req","S" );
      ((Element)v.get(113)).setAttribute("size","1" );
      ((Element)v.get(113)).setAttribute("multiple","N" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 112   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(115)).setAttribute("tipo","texto" );
      ((Element)v.get(115)).setAttribute("ID","EstDat" );
      ((Element)v.get(112)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */

      /* Empieza nodo:116 / Elemento padre: 112   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(116)).setAttribute("tipo","texto" );
      ((Element)v.get(116)).setAttribute("ID","EstDat" );
      ((Element)v.get(112)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */

      /* Empieza nodo:117 / Elemento padre: 112   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(117)).setAttribute("tipo","texto" );
      ((Element)v.get(117)).setAttribute("ID","EstDat" );
      ((Element)v.get(112)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:112   */

      /* Empieza nodo:118 / Elemento padre: 88   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(88)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:88   */

      /* Empieza nodo:119 / Elemento padre: 87   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(119)).setAttribute("nombre","Eliminar" );
      ((Element)v.get(119)).setAttribute("x","20" );
      ((Element)v.get(119)).setAttribute("y","279" );
      ((Element)v.get(119)).setAttribute("ID","botonContenido" );
      ((Element)v.get(119)).setAttribute("tipo","html" );
      ((Element)v.get(119)).setAttribute("estado","false" );
      ((Element)v.get(119)).setAttribute("cod","MMGGlobal.removeButton.label" );
      ((Element)v.get(119)).setAttribute("accion","" );
      ((Element)v.get(87)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */

      /* Empieza nodo:120 / Elemento padre: 87   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(120)).setAttribute("nombre","Aniadir" );
      ((Element)v.get(120)).setAttribute("x","80" );
      ((Element)v.get(120)).setAttribute("y","279" );
      ((Element)v.get(120)).setAttribute("ID","botonContenido" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(120)).setAttribute("tipo","html" );
      ((Element)v.get(120)).setAttribute("estado","false" );
      ((Element)v.get(120)).setAttribute("cod","MMGGlobal.localization.addbutton.label" );
      ((Element)v.get(120)).setAttribute("accion","" );
      ((Element)v.get(87)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:87   */
      /* Termina nodo:5   */


   }

}

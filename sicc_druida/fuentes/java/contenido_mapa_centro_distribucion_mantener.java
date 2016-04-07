
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_mapa_centro_distribucion_mantener  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_mapa_centro_distribucion_mantener" );
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
      ((Element)v.get(21)).setAttribute("cod","00664" );
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
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(25)).setAttribute("width","8" );
      ((Element)v.get(25)).setAttribute("height","8" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:26 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(27)).setAttribute("nombre","lblCentroDistribucion" );
      ((Element)v.get(27)).setAttribute("alto","13" );
      ((Element)v.get(27)).setAttribute("filas","1" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(27)).setAttribute("id","datosTitle" );
      ((Element)v.get(27)).setAttribute("cod","2054" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */

      /* Empieza nodo:28 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(29)).setAttribute("src","b.gif" );
      ((Element)v.get(29)).setAttribute("width","25" );
      ((Element)v.get(29)).setAttribute("height","8" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:30 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(31)).setAttribute("nombre","lblMapaCentroDistribucion" );
      ((Element)v.get(31)).setAttribute("alto","13" );
      ((Element)v.get(31)).setAttribute("filas","1" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(31)).setAttribute("id","datosTitle" );
      ((Element)v.get(31)).setAttribute("cod","2925" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:32 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(32)).setAttribute("width","100%" );
      ((Element)v.get(23)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(33)).setAttribute("src","b.gif" );
      ((Element)v.get(33)).setAttribute("width","8" );
      ((Element)v.get(33)).setAttribute("height","8" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */
      /* Termina nodo:32   */
      /* Termina nodo:23   */

      /* Empieza nodo:34 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(36)).setAttribute("src","b.gif" );
      ((Element)v.get(36)).setAttribute("width","8" );
      ((Element)v.get(36)).setAttribute("height","8" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:37 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(34)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(38)).setAttribute("nombre","cbCentroDistribucion" );
      ((Element)v.get(38)).setAttribute("id","datosCampos" );
      ((Element)v.get(38)).setAttribute("size","1" );
      ((Element)v.get(38)).setAttribute("multiple","N" );
      ((Element)v.get(38)).setAttribute("req","S" );
      ((Element)v.get(38)).setAttribute("onchange","" );
      ((Element)v.get(38)).setAttribute("onshtab","" );
      ((Element)v.get(38)).setAttribute("valorinicial","" );
      ((Element)v.get(38)).setAttribute("textoinicial","" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:40 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(34)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).setAttribute("width","25" );
      ((Element)v.get(41)).setAttribute("height","8" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(34)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(43)).setAttribute("nombre","cbLineasEstimadosVenta" );
      ((Element)v.get(43)).setAttribute("id","datosCampos" );
      ((Element)v.get(43)).setAttribute("size","1" );
      ((Element)v.get(43)).setAttribute("multiple","N" );
      ((Element)v.get(43)).setAttribute("req","S" );
      ((Element)v.get(43)).setAttribute("onchange","" );
      ((Element)v.get(43)).setAttribute("onshtab","" );
      ((Element)v.get(43)).setAttribute("valorinicial","" );
      ((Element)v.get(43)).setAttribute("textoinicial","" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:45 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(45)).setAttribute("width","100%" );
      ((Element)v.get(34)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","8" );
      ((Element)v.get(46)).setAttribute("height","8" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */
      /* Termina nodo:34   */

      /* Empieza nodo:47 / Elemento padre: 22   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(22)).appendChild((Element)v.get(47));

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
      /* Termina nodo:22   */

      /* Empieza nodo:50 / Elemento padre: 19   */
      v.add(doc.createElement("table"));
      ((Element)v.get(50)).setAttribute("width","100%" );
      ((Element)v.get(50)).setAttribute("border","0" );
      ((Element)v.get(50)).setAttribute("align","center" );
      ((Element)v.get(50)).setAttribute("cellspacing","0" );
      ((Element)v.get(50)).setAttribute("cellpadding","0" );
      ((Element)v.get(19)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(51));

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
      ((Element)v.get(51)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(55)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(55)).setAttribute("alto","13" );
      ((Element)v.get(55)).setAttribute("filas","1" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(55)).setAttribute("id","datosTitle" );
      ((Element)v.get(55)).setAttribute("cod","EduTipoCurso.marcOidMarc.label" );
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
      ((Element)v.get(51)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(59)).setAttribute("nombre","lblCamal" );
      ((Element)v.get(59)).setAttribute("alto","13" );
      ((Element)v.get(59)).setAttribute("filas","1" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(59)).setAttribute("id","datosTitle" );
      ((Element)v.get(59)).setAttribute("cod","FacAsignImpre.canaOidCana.label" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).setAttribute("width","100%" );
      ((Element)v.get(51)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","8" );
      ((Element)v.get(61)).setAttribute("height","8" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:51   */

      /* Empieza nodo:62 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(62));

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
      ((Element)v.get(65)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(62)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(66)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(66)).setAttribute("id","datosCampos" );
      ((Element)v.get(66)).setAttribute("size","1" );
      ((Element)v.get(66)).setAttribute("multiple","N" );
      ((Element)v.get(66)).setAttribute("req","S" );
      ((Element)v.get(66)).setAttribute("onchange","" );
      ((Element)v.get(66)).setAttribute("onshtab","" );
      ((Element)v.get(66)).setAttribute("valorinicial","" );
      ((Element)v.get(66)).setAttribute("textoinicial","" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:68 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","25" );
      ((Element)v.get(69)).setAttribute("height","8" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(62)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(71)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(71)).setAttribute("id","datosCampos" );
      ((Element)v.get(71)).setAttribute("size","1" );
      ((Element)v.get(71)).setAttribute("multiple","N" );
      ((Element)v.get(71)).setAttribute("req","S" );
      ((Element)v.get(71)).setAttribute("onchange","" );
      ((Element)v.get(71)).setAttribute("onshtab","" );
      ((Element)v.get(71)).setAttribute("valorinicial","" );
      ((Element)v.get(71)).setAttribute("textoinicial","" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:73 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).setAttribute("width","100%" );
      ((Element)v.get(62)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","8" );
      ((Element)v.get(74)).setAttribute("height","8" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:62   */

      /* Empieza nodo:75 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).setAttribute("colspan","4" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","8" );
      ((Element)v.get(77)).setAttribute("height","8" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:50   */

      /* Empieza nodo:78 / Elemento padre: 19   */
      v.add(doc.createElement("table"));
      ((Element)v.get(78)).setAttribute("width","100%" );
      ((Element)v.get(78)).setAttribute("border","0" );
      ((Element)v.get(78)).setAttribute("align","center" );
      ((Element)v.get(78)).setAttribute("cellspacing","0" );
      ((Element)v.get(78)).setAttribute("cellpadding","0" );
      ((Element)v.get(19)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(78)).appendChild((Element)v.get(79));

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
      ((Element)v.get(83)).setAttribute("nombre","lblPeriodo" );
      ((Element)v.get(83)).setAttribute("alto","13" );
      ((Element)v.get(83)).setAttribute("filas","1" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(83)).setAttribute("id","datosTitle" );
      ((Element)v.get(83)).setAttribute("cod","276" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).setAttribute("width","100%" );
      ((Element)v.get(79)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","8" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:79   */

      /* Empieza nodo:86 / Elemento padre: 78   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(78)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","8" );
      ((Element)v.get(88)).setAttribute("height","8" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(86)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(90)).setAttribute("nombre","cbPeriodo" );
      ((Element)v.get(90)).setAttribute("id","datosCampos" );
      ((Element)v.get(90)).setAttribute("size","1" );
      ((Element)v.get(90)).setAttribute("multiple","N" );
      ((Element)v.get(90)).setAttribute("req","S" );
      ((Element)v.get(90)).setAttribute("onchange","" );
      ((Element)v.get(90)).setAttribute("onshtab","" );
      ((Element)v.get(90)).setAttribute("valorinicial","" );
      ((Element)v.get(90)).setAttribute("textoinicial","" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:92 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).setAttribute("width","100%" );
      ((Element)v.get(86)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","8" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:86   */

      /* Empieza nodo:94 / Elemento padre: 78   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(78)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).setAttribute("colspan","4" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","8" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:78   */
      /* Termina nodo:19   */

      /* Empieza nodo:97 / Elemento padre: 18   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(18)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("table"));
      ((Element)v.get(98)).setAttribute("width","100%" );
      ((Element)v.get(98)).setAttribute("border","0" );
      ((Element)v.get(98)).setAttribute("align","center" );
      ((Element)v.get(98)).setAttribute("cellspacing","0" );
      ((Element)v.get(98)).setAttribute("cellpadding","0" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).setAttribute("class","botonera" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(101)).setAttribute("nombre","btnExpandir" );
      ((Element)v.get(101)).setAttribute("ID","botonContenido" );
      ((Element)v.get(101)).setAttribute("tipo","html" );
      ((Element)v.get(101)).setAttribute("accion","" );
      ((Element)v.get(101)).setAttribute("estado","false" );
      ((Element)v.get(101)).setAttribute("cod","2935" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 100   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(102)).setAttribute("nombre","btnDividir" );
      ((Element)v.get(102)).setAttribute("ID","botonContenido" );
      ((Element)v.get(102)).setAttribute("tipo","html" );
      ((Element)v.get(102)).setAttribute("accion","" );
      ((Element)v.get(102)).setAttribute("estado","false" );
      ((Element)v.get(102)).setAttribute("cod","2936" );
      ((Element)v.get(100)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:18   */
      /* Termina nodo:15   */

      /* Empieza nodo:103 / Elemento padre: 7   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(7)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("colspan","4" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","8" );
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:106 / Elemento padre: 7   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(7)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).setAttribute("colspan","4" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","8" );
      ((Element)v.get(108)).setAttribute("height","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:109 / Elemento padre: 7   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(7)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(114)).setAttribute("class","legend" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(115)).setAttribute("nombre","lblDatosDeAlta" );
      ((Element)v.get(115)).setAttribute("alto","13" );
      ((Element)v.get(115)).setAttribute("filas","1" );
      ((Element)v.get(115)).setAttribute("cod","2935" );
      ((Element)v.get(115)).setAttribute("id","legend" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 113   */
      v.add(doc.createElement("table"));
      ((Element)v.get(116)).setAttribute("width","100%" );
      ((Element)v.get(116)).setAttribute("border","0" );
      ((Element)v.get(116)).setAttribute("align","center" );
      ((Element)v.get(116)).setAttribute("cellspacing","0" );
      ((Element)v.get(116)).setAttribute("cellpadding","0" );
      ((Element)v.get(113)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).setAttribute("width","8" );
      ((Element)v.get(119)).setAttribute("height","8" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(121)).setAttribute("nombre","lblCodigoAnaquelDest" );
      ((Element)v.get(121)).setAttribute("alto","13" );
      ((Element)v.get(121)).setAttribute("filas","1" );
      ((Element)v.get(121)).setAttribute("valor","" );
      ((Element)v.get(121)).setAttribute("id","datosTitle" );
      ((Element)v.get(121)).setAttribute("cod","2945" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).setAttribute("width","25" );
      ((Element)v.get(123)).setAttribute("height","8" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(125)).setAttribute("nombre","lblMapaCentroDistribucion" );
      ((Element)v.get(125)).setAttribute("alto","13" );
      ((Element)v.get(125)).setAttribute("filas","1" );
      ((Element)v.get(125)).setAttribute("valor","" );
      ((Element)v.get(125)).setAttribute("id","datosTitle" );
      ((Element)v.get(125)).setAttribute("cod","2955" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:126 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).setAttribute("width","100%" );
      ((Element)v.get(117)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","8" );
      ((Element)v.get(127)).setAttribute("height","8" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:117   */

      /* Empieza nodo:128 / Elemento padre: 116   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(116)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","8" );
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(128)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(132)).setAttribute("nombre","txtCodAnaDest" );
      ((Element)v.get(132)).setAttribute("id","datosCampos" );
      ((Element)v.get(132)).setAttribute("max","2" );
      ((Element)v.get(132)).setAttribute("tipo","" );
      ((Element)v.get(132)).setAttribute("onchange","" );
      ((Element)v.get(132)).setAttribute("onshtab","" );
      ((Element)v.get(132)).setAttribute("req","S" );
      ((Element)v.get(132)).setAttribute("size","2" );
      ((Element)v.get(132)).setAttribute("valor","" );
      ((Element)v.get(132)).setAttribute("validacion","" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","25" );
      ((Element)v.get(134)).setAttribute("height","8" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(128)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(136)).setAttribute("nombre","txtCapacidad" );
      ((Element)v.get(136)).setAttribute("id","datosCampos" );
      ((Element)v.get(136)).setAttribute("max","2" );
      ((Element)v.get(136)).setAttribute("tipo","" );
      ((Element)v.get(136)).setAttribute("onchange","" );
      ((Element)v.get(136)).setAttribute("onshtab","" );
      ((Element)v.get(136)).setAttribute("req","S" );
      ((Element)v.get(136)).setAttribute("size","2" );
      ((Element)v.get(136)).setAttribute("valor","" );
      ((Element)v.get(136)).setAttribute("validacion","" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(137)).setAttribute("width","100%" );
      ((Element)v.get(128)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","8" );
      ((Element)v.get(138)).setAttribute("height","8" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:128   */

      /* Empieza nodo:139 / Elemento padre: 116   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(116)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("colspan","4" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).setAttribute("width","8" );
      ((Element)v.get(141)).setAttribute("height","8" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:116   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:109   */
      /* Termina nodo:7   */
      /* Termina nodo:6   */

      /* Empieza nodo:142 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(142)).setAttribute("nombre","capaLista" );
      ((Element)v.get(142)).setAttribute("ancho","100%" );
      ((Element)v.get(142)).setAttribute("alto","330" );
      ((Element)v.get(142)).setAttribute("x","17" );
      ((Element)v.get(142)).setAttribute("y","270" );
      ((Element)v.get(142)).setAttribute("colorf","" );
      ((Element)v.get(142)).setAttribute("borde","0" );
      ((Element)v.get(142)).setAttribute("imagenf","" );
      ((Element)v.get(142)).setAttribute("repeat","" );
      ((Element)v.get(142)).setAttribute("padding","" );
      ((Element)v.get(142)).setAttribute("visibilidad","" );
      ((Element)v.get(142)).setAttribute("contravsb","" );
      ((Element)v.get(142)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(143)).setAttribute("nombre","listado1" );
      ((Element)v.get(143)).setAttribute("ancho","369" );
      ((Element)v.get(143)).setAttribute("alto","301" );
      ((Element)v.get(143)).setAttribute("x","12" );
      ((Element)v.get(143)).setAttribute("y","0" );
      ((Element)v.get(143)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(143)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(144)).setAttribute("precarga","S" );
      ((Element)v.get(144)).setAttribute("conROver","S" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(145)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(145)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(145)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(145)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */

      /* Empieza nodo:146 / Elemento padre: 144   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(146)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(146)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(146)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(146)).setAttribute("aximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(144)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */

      /* Empieza nodo:147 / Elemento padre: 144   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(147)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(147)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(144)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:144   */

      /* Empieza nodo:148 / Elemento padre: 143   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(143)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(149)).setAttribute("borde","1" );
      ((Element)v.get(149)).setAttribute("horizDatos","1" );
      ((Element)v.get(149)).setAttribute("horizCabecera","1" );
      ((Element)v.get(149)).setAttribute("vertical","1" );
      ((Element)v.get(149)).setAttribute("horizTitulo","1" );
      ((Element)v.get(149)).setAttribute("horizBase","1" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */

      /* Empieza nodo:150 / Elemento padre: 148   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(150)).setAttribute("borde","#999999" );
      ((Element)v.get(150)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(150)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(150)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(150)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(150)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(150)).setAttribute("horizBase","#999999" );
      ((Element)v.get(148)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:148   */

      /* Empieza nodo:151 / Elemento padre: 143   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(151)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(151)).setAttribute("alto","22" );
      ((Element)v.get(151)).setAttribute("imgFondo","" );
      ((Element)v.get(151)).setAttribute("cod","00133" );
      ((Element)v.get(151)).setAttribute("ID","datosTitle" );
      ((Element)v.get(143)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */

      /* Empieza nodo:152 / Elemento padre: 143   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(152)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(152)).setAttribute("alto","22" );
      ((Element)v.get(152)).setAttribute("imgFondo","" );
      ((Element)v.get(143)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */

      /* Empieza nodo:153 / Elemento padre: 143   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(153)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(153)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(153)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(153)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(153)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(153)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(143)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(154)).setAttribute("ancho","50" );
      ((Element)v.get(154)).setAttribute("minimizable","S" );
      ((Element)v.get(154)).setAttribute("minimizada","N" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 143   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(155)).setAttribute("alto","25" );
      ((Element)v.get(155)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(155)).setAttribute("imgFondo","" );
      ((Element)v.get(155)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(143)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(156)).setAttribute("colFondo","" );
      ((Element)v.get(156)).setAttribute("ID","EstCab" );
      ((Element)v.get(156)).setAttribute("cod","2946" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 143   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(157)).setAttribute("alto","22" );
      ((Element)v.get(157)).setAttribute("accion","" );
      ((Element)v.get(157)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(157)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(157)).setAttribute("maxSel","-1" );
      ((Element)v.get(157)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(157)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(157)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(157)).setAttribute("onLoad","" );
      ((Element)v.get(157)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(143)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(158)).setAttribute("tipo","texto" );
      ((Element)v.get(158)).setAttribute("ID","EstDat" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 143   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(143)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:143   */

      /* Empieza nodo:160 / Elemento padre: 142   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(160)).setAttribute("nombre","btnAniadir" );
      ((Element)v.get(160)).setAttribute("x","20" );
      ((Element)v.get(160)).setAttribute("y","279" );
      ((Element)v.get(160)).setAttribute("ID","botonContenido" );
      ((Element)v.get(160)).setAttribute("tipo","html" );
      ((Element)v.get(160)).setAttribute("estado","false" );
      ((Element)v.get(160)).setAttribute("cod","MMGGlobal.localization.addbutton.label" );
      ((Element)v.get(160)).setAttribute("accion","" );
      ((Element)v.get(142)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */

      /* Empieza nodo:161 / Elemento padre: 142   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(161)).setAttribute("nombre","btnElimiar" );
      ((Element)v.get(161)).setAttribute("x","69" );
      ((Element)v.get(161)).setAttribute("y","279" );
      ((Element)v.get(161)).setAttribute("ID","botonContenido" );
      ((Element)v.get(161)).setAttribute("tipo","html" );
      ((Element)v.get(161)).setAttribute("estado","false" );
      ((Element)v.get(161)).setAttribute("cod","MMGGlobal.localization.removebutton.label" );
      ((Element)v.get(161)).setAttribute("accion","" );
      ((Element)v.get(142)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */

      /* Empieza nodo:162 / Elemento padre: 142   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(162)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(162)).setAttribute("x","125" );
      ((Element)v.get(162)).setAttribute("y","279" );
      ((Element)v.get(162)).setAttribute("ID","botonContenido" );
      ((Element)v.get(162)).setAttribute("tipo","html" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(162)).setAttribute("estado","false" );
      ((Element)v.get(162)).setAttribute("cod","MMGGlobal.localization.bindbutton.label" );
      ((Element)v.get(162)).setAttribute("accion","" );
      ((Element)v.get(142)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:142   */
      /* Termina nodo:5   */


   }

}

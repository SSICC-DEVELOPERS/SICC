
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_formas_pago_detalle_consultar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_formas_pago_detalle_consultar" );
      ((Element)v.get(0)).setAttribute("cod","0366" );
      ((Element)v.get(0)).setAttribute("titulo","" );
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
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","contenido_formas_pago_detalle_consultar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(5)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","accion" );
      ((Element)v.get(6)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","idioma" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","pais" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","tipoAccion" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 5   */
      v.add(doc.createElement("table"));
      ((Element)v.get(13)).setAttribute("width","100%" );
      ((Element)v.get(13)).setAttribute("border","0" );
      ((Element)v.get(13)).setAttribute("cellspacing","0" );
      ((Element)v.get(13)).setAttribute("cellpadding","0" );
      ((Element)v.get(5)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(13)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("td"));
      ((Element)v.get(15)).setAttribute("width","12" );
      ((Element)v.get(15)).setAttribute("align","center" );
      ((Element)v.get(14)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(16)).setAttribute("src","b.gif" );
      ((Element)v.get(16)).setAttribute("width","12" );
      ((Element)v.get(16)).setAttribute("height","12" );
      ((Element)v.get(15)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */
      /* Termina nodo:15   */

      /* Empieza nodo:17 / Elemento padre: 14   */
      v.add(doc.createElement("td"));
      ((Element)v.get(17)).setAttribute("width","750" );
      ((Element)v.get(14)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(18)).setAttribute("src","b.gif" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */
      /* Termina nodo:17   */

      /* Empieza nodo:19 / Elemento padre: 14   */
      v.add(doc.createElement("td"));
      ((Element)v.get(19)).setAttribute("width","12" );
      ((Element)v.get(14)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(20)).setAttribute("src","b.gif" );
      ((Element)v.get(20)).setAttribute("width","12" );
      ((Element)v.get(20)).setAttribute("height","1" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */
      /* Termina nodo:19   */
      /* Termina nodo:14   */

      /* Empieza nodo:21 / Elemento padre: 13   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(13)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("td"));
      ((Element)v.get(21)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(23)).setAttribute("src","b.gif" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */
      /* Termina nodo:22   */

      /* Empieza nodo:24 / Elemento padre: 21   */
      v.add(doc.createElement("td"));
      ((Element)v.get(21)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(26)).setAttribute("class","legend" );
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(27)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(27)).setAttribute("alto","13" );
      ((Element)v.get(27)).setAttribute("filas","1" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(27)).setAttribute("id","legend" );
      ((Element)v.get(27)).setAttribute("cod","0075" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */

      /* Empieza nodo:28 / Elemento padre: 25   */
      v.add(doc.createElement("table"));
      ((Element)v.get(28)).setAttribute("width","100%" );
      ((Element)v.get(28)).setAttribute("border","0" );
      ((Element)v.get(28)).setAttribute("align","center" );
      ((Element)v.get(28)).setAttribute("cellspacing","0" );
      ((Element)v.get(28)).setAttribute("cellpadding","0" );
      ((Element)v.get(25)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("td"));
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("table"));
      ((Element)v.get(31)).setAttribute("width","525" );
      ((Element)v.get(31)).setAttribute("border","0" );
      ((Element)v.get(31)).setAttribute("align","left" );
      ((Element)v.get(31)).setAttribute("cellspacing","0" );
      ((Element)v.get(31)).setAttribute("cellpadding","0" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).setAttribute("colspan","3" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(34)).setAttribute("src","b.gif" );
      ((Element)v.get(34)).setAttribute("width","8" );
      ((Element)v.get(34)).setAttribute("height","8" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */
      /* Termina nodo:33   */
      /* Termina nodo:32   */

      /* Empieza nodo:35 / Elemento padre: 31   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(37)).setAttribute("src","b.gif" );
      ((Element)v.get(37)).setAttribute("width","8" );
      ((Element)v.get(37)).setAttribute("height","8" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:38 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(39)).setAttribute("nombre","lblFormaPago" );
      ((Element)v.get(39)).setAttribute("alto","13" );
      ((Element)v.get(39)).setAttribute("filas","1" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(39)).setAttribute("id","datosTitle" );
      ((Element)v.get(39)).setAttribute("cod","541" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).setAttribute("width","100%" );
      ((Element)v.get(35)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).setAttribute("width","8" );
      ((Element)v.get(41)).setAttribute("height","8" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */
      /* Termina nodo:35   */

      /* Empieza nodo:42 / Elemento padre: 31   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).setAttribute("width","8" );
      ((Element)v.get(44)).setAttribute("height","8" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(46)).setAttribute("nombre","cbFormaPago" );
      ((Element)v.get(46)).setAttribute("id","datosCampos" );
      ((Element)v.get(46)).setAttribute("size","1" );
      ((Element)v.get(46)).setAttribute("multiple","N" );
      ((Element)v.get(46)).setAttribute("req","N" );
      ((Element)v.get(46)).setAttribute("valorinicial","" );
      ((Element)v.get(46)).setAttribute("textoinicial","" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(46)).setAttribute("onshtab","focoboton();" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:48 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).setAttribute("width","100%" );
      ((Element)v.get(42)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","8" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:42   */

      /* Empieza nodo:50 / Elemento padre: 31   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(31)).appendChild((Element)v.get(50));

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
      /* Termina nodo:31   */
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:53 / Elemento padre: 28   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(28)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("table"));
      ((Element)v.get(55)).setAttribute("width","525" );
      ((Element)v.get(55)).setAttribute("border","0" );
      ((Element)v.get(55)).setAttribute("align","left" );
      ((Element)v.get(55)).setAttribute("cellspacing","0" );
      ((Element)v.get(55)).setAttribute("cellpadding","0" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

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
      ((Element)v.get(60)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(60)).setAttribute("alto","13" );
      ((Element)v.get(60)).setAttribute("filas","1" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(60)).setAttribute("id","datosTitle" );
      ((Element)v.get(60)).setAttribute("cod","7" );
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
      ((Element)v.get(64)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(64)).setAttribute("alto","13" );
      ((Element)v.get(64)).setAttribute("filas","1" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(64)).setAttribute("id","datosTitle" );
      ((Element)v.get(64)).setAttribute("cod","6" );
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

      /* Empieza nodo:67 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","8" );
      ((Element)v.get(69)).setAttribute("height","8" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(67)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("COMBO"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(71)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(71)).setAttribute("id","datosCampos" );
      ((Element)v.get(71)).setAttribute("size","1" );
      ((Element)v.get(71)).setAttribute("multiple","N" );
      ((Element)v.get(71)).setAttribute("req","N" );
      ((Element)v.get(71)).setAttribute("valorinicial","" );
      ((Element)v.get(71)).setAttribute("textoinicial","" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:73 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(67)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","25" );
      ((Element)v.get(74)).setAttribute("height","8" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(67)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(76)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(76)).setAttribute("id","datosCampos" );
      ((Element)v.get(76)).setAttribute("size","1" );
      ((Element)v.get(76)).setAttribute("multiple","N" );
      ((Element)v.get(76)).setAttribute("req","N" );
      ((Element)v.get(76)).setAttribute("valorinicial","" );
      ((Element)v.get(76)).setAttribute("textoinicial","" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:78 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("width","100%" );
      ((Element)v.get(67)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","8" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:67   */

      /* Empieza nodo:80 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(80));

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
      /* Termina nodo:55   */
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:83 / Elemento padre: 28   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(28)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("table"));
      ((Element)v.get(85)).setAttribute("width","525" );
      ((Element)v.get(85)).setAttribute("border","0" );
      ((Element)v.get(85)).setAttribute("align","left" );
      ((Element)v.get(85)).setAttribute("cellspacing","0" );
      ((Element)v.get(85)).setAttribute("cellpadding","0" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(85)).appendChild((Element)v.get(86));

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
      ((Element)v.get(86)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(90)).setAttribute("nombre","lblMedioPago" );
      ((Element)v.get(90)).setAttribute("alto","13" );
      ((Element)v.get(90)).setAttribute("filas","1" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(90)).setAttribute("id","datosTitle" );
      ((Element)v.get(90)).setAttribute("cod","673" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","25" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(94)).setAttribute("nombre","lblIndicadorDias" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(94)).setAttribute("alto","13" );
      ((Element)v.get(94)).setAttribute("filas","1" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(94)).setAttribute("id","datosTitle" );
      ((Element)v.get(94)).setAttribute("cod","1281" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).setAttribute("width","100%" );
      ((Element)v.get(86)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","8" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:86   */

      /* Empieza nodo:97 / Elemento padre: 85   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(85)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","8" );
      ((Element)v.get(99)).setAttribute("height","8" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(101)).setAttribute("nombre","cbMedioPago" );
      ((Element)v.get(101)).setAttribute("id","datosCampos" );
      ((Element)v.get(101)).setAttribute("size","1" );
      ((Element)v.get(101)).setAttribute("multiple","N" );
      ((Element)v.get(101)).setAttribute("req","N" );
      ((Element)v.get(101)).setAttribute("valorinicial","" );
      ((Element)v.get(101)).setAttribute("textoinicial","" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:103 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","25" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(97)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(106)).setAttribute("nombre","cbIndicadorDias" );
      ((Element)v.get(106)).setAttribute("id","datosCampos" );
      ((Element)v.get(106)).setAttribute("size","1" );
      ((Element)v.get(106)).setAttribute("multiple","N" );
      ((Element)v.get(106)).setAttribute("req","N" );
      ((Element)v.get(106)).setAttribute("valorinicial","" );
      ((Element)v.get(106)).setAttribute("textoinicial","" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(108)).setAttribute("ID","1" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(109)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(109)).setAttribute("TIPO","STRING" );
      ((Element)v.get(109)).setAttribute("VALOR","00" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 108   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(110)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(110)).setAttribute("TIPO","STRING" );
      ((Element)v.get(110)).setAttribute("VALOR","N" );
      ((Element)v.get(108)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:108   */

      /* Empieza nodo:111 / Elemento padre: 107   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(111)).setAttribute("ID","2" );
      ((Element)v.get(107)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(112)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(112)).setAttribute("TIPO","STRING" );
      ((Element)v.get(112)).setAttribute("VALOR","01" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */

      /* Empieza nodo:113 / Elemento padre: 111   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(113)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(113)).setAttribute("TIPO","STRING" );
      ((Element)v.get(113)).setAttribute("VALOR","D" );
      ((Element)v.get(111)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:111   */

      /* Empieza nodo:114 / Elemento padre: 107   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(114)).setAttribute("ID","3" );
      ((Element)v.get(107)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(115)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(115)).setAttribute("TIPO","STRING" );
      ((Element)v.get(115)).setAttribute("VALOR","02" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */

      /* Empieza nodo:116 / Elemento padre: 114   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(116)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(116)).setAttribute("TIPO","STRING" );
      ((Element)v.get(116)).setAttribute("VALOR","F" );
      ((Element)v.get(114)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:114   */

      /* Empieza nodo:117 / Elemento padre: 107   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(117)).setAttribute("ID","4" );
      ((Element)v.get(107)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(118)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(118)).setAttribute("TIPO","STRING" );
      ((Element)v.get(118)).setAttribute("VALOR","03" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */

      /* Empieza nodo:119 / Elemento padre: 117   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(119)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(119)).setAttribute("TIPO","STRING" );
      ((Element)v.get(119)).setAttribute("VALOR","A" );
      ((Element)v.get(117)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:117   */
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:120 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).setAttribute("width","100%" );
      ((Element)v.get(97)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","8" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:97   */

      /* Empieza nodo:122 / Elemento padre: 85   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(85)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).setAttribute("colspan","4" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","8" );
      ((Element)v.get(124)).setAttribute("height","8" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:28   */
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:125 / Elemento padre: 21   */
      v.add(doc.createElement("td"));
      ((Element)v.get(21)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */
      /* Termina nodo:21   */

      /* Empieza nodo:127 / Elemento padre: 13   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(13)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("table"));
      ((Element)v.get(132)).setAttribute("width","100%" );
      ((Element)v.get(132)).setAttribute("border","0" );
      ((Element)v.get(132)).setAttribute("align","center" );
      ((Element)v.get(132)).setAttribute("cellspacing","0" );
      ((Element)v.get(132)).setAttribute("cellpadding","0" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).setAttribute("class","botonera" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(135)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(135)).setAttribute("ID","botonContenido" );
      ((Element)v.get(135)).setAttribute("tipo","html" );
      ((Element)v.get(135)).setAttribute("accion","accionBuscar();" );
      ((Element)v.get(135)).setAttribute("estado","false" );
      ((Element)v.get(135)).setAttribute("cod","1" );
      ((Element)v.get(135)).setAttribute("ontab","focobotonBuscar();" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:136 / Elemento padre: 127   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","8" );
      ((Element)v.get(137)).setAttribute("height","12" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:127   */

      /* Empieza nodo:138 / Elemento padre: 13   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(13)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).setAttribute("width","12" );
      ((Element)v.get(139)).setAttribute("align","center" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","12" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(140)).setAttribute("height","12" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).setAttribute("width","756" );
      ((Element)v.get(138)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).setAttribute("width","12" );
      ((Element)v.get(138)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","12" );
      ((Element)v.get(144)).setAttribute("height","1" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:138   */
      /* Termina nodo:13   */

      /* Empieza nodo:145 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(145)).setAttribute("nombre","capaLista" );
      ((Element)v.get(145)).setAttribute("alto","315" );
      ((Element)v.get(145)).setAttribute("ancho","100%" );
      ((Element)v.get(145)).setAttribute("colorf","" );
      ((Element)v.get(145)).setAttribute("borde","0" );
      ((Element)v.get(145)).setAttribute("imagenf","" );
      ((Element)v.get(145)).setAttribute("repeat","" );
      ((Element)v.get(145)).setAttribute("padding","" );
      ((Element)v.get(145)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(145)).setAttribute("contravsb","" );
      ((Element)v.get(145)).setAttribute("x","0" );
      ((Element)v.get(145)).setAttribute("y","201" );
      ((Element)v.get(145)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(146)).setAttribute("nombre","listado1" );
      ((Element)v.get(146)).setAttribute("ancho","529" );
      ((Element)v.get(146)).setAttribute("alto","317" );
      ((Element)v.get(146)).setAttribute("x","12" );
      ((Element)v.get(146)).setAttribute("y","0" );
      ((Element)v.get(146)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(146)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(147)).setAttribute("precarga","S" );
      ((Element)v.get(147)).setAttribute("conROver","S" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(148)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(148)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(148)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(148)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */

      /* Empieza nodo:149 / Elemento padre: 147   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(149)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(149)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(149)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(149)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(147)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */

      /* Empieza nodo:150 / Elemento padre: 147   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(150)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(150)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(147)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:147   */

      /* Empieza nodo:151 / Elemento padre: 146   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(146)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(152)).setAttribute("borde","1" );
      ((Element)v.get(152)).setAttribute("horizDatos","1" );
      ((Element)v.get(152)).setAttribute("horizCabecera","1" );
      ((Element)v.get(152)).setAttribute("vertical","1" );
      ((Element)v.get(152)).setAttribute("horizTitulo","1" );
      ((Element)v.get(152)).setAttribute("horizBase","1" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */

      /* Empieza nodo:153 / Elemento padre: 151   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(153)).setAttribute("borde","#999999" );
      ((Element)v.get(153)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(153)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(153)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(153)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(153)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(153)).setAttribute("horizBase","#999999" );
      ((Element)v.get(151)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:151   */

      /* Empieza nodo:154 / Elemento padre: 146   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(154)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(154)).setAttribute("alto","22" );
      ((Element)v.get(154)).setAttribute("imgFondo","" );
      ((Element)v.get(154)).setAttribute("cod","00135" );
      ((Element)v.get(154)).setAttribute("ID","datosTitle" );
      ((Element)v.get(146)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */

      /* Empieza nodo:155 / Elemento padre: 146   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(155)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(155)).setAttribute("alto","22" );
      ((Element)v.get(155)).setAttribute("imgFondo","" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(146)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */

      /* Empieza nodo:156 / Elemento padre: 146   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(156)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(156)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(156)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(156)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(156)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(156)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(146)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(157)).setAttribute("ancho","200" );
      ((Element)v.get(157)).setAttribute("minimizable","S" );
      ((Element)v.get(157)).setAttribute("minimizada","N" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */

      /* Empieza nodo:158 / Elemento padre: 156   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(158)).setAttribute("ancho","98" );
      ((Element)v.get(158)).setAttribute("minimizable","S" );
      ((Element)v.get(158)).setAttribute("minimizada","N" );
      ((Element)v.get(156)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */

      /* Empieza nodo:159 / Elemento padre: 156   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(159)).setAttribute("ancho","200" );
      ((Element)v.get(159)).setAttribute("minimizable","S" );
      ((Element)v.get(159)).setAttribute("minimizada","N" );
      ((Element)v.get(156)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */

      /* Empieza nodo:160 / Elemento padre: 156   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(160)).setAttribute("ancho","100" );
      ((Element)v.get(160)).setAttribute("minimizable","S" );
      ((Element)v.get(160)).setAttribute("minimizada","N" );
      ((Element)v.get(156)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */

      /* Empieza nodo:161 / Elemento padre: 156   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(161)).setAttribute("ancho","88" );
      ((Element)v.get(161)).setAttribute("minimizable","S" );
      ((Element)v.get(161)).setAttribute("minimizada","N" );
      ((Element)v.get(156)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */

      /* Empieza nodo:162 / Elemento padre: 156   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(162)).setAttribute("ancho","55" );
      ((Element)v.get(162)).setAttribute("minimizable","S" );
      ((Element)v.get(162)).setAttribute("minimizada","N" );
      ((Element)v.get(156)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */

      /* Empieza nodo:163 / Elemento padre: 156   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(163)).setAttribute("ancho","68" );
      ((Element)v.get(163)).setAttribute("minimizable","S" );
      ((Element)v.get(163)).setAttribute("minimizada","N" );
      ((Element)v.get(156)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:156   */

      /* Empieza nodo:164 / Elemento padre: 146   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(164)).setAttribute("alto","20" );
      ((Element)v.get(164)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(164)).setAttribute("imgFondo","" );
      ((Element)v.get(164)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(146)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(165)).setAttribute("colFondo","" );
      ((Element)v.get(165)).setAttribute("ID","EstCab" );
      ((Element)v.get(165)).setAttribute("cod","541" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */

      /* Empieza nodo:166 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(166)).setAttribute("colFondo","" );
      ((Element)v.get(166)).setAttribute("ID","EstCab" );
      ((Element)v.get(166)).setAttribute("cod","1284" );
      ((Element)v.get(164)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */

      /* Empieza nodo:167 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(167)).setAttribute("colFondo","" );
      ((Element)v.get(167)).setAttribute("ID","EstCab" );
      ((Element)v.get(167)).setAttribute("cod","673" );
      ((Element)v.get(164)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(168)).setAttribute("colFondo","" );
      ((Element)v.get(168)).setAttribute("ID","EstCab" );
      ((Element)v.get(168)).setAttribute("cod","1280" );
      ((Element)v.get(164)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(169)).setAttribute("colFondo","" );
      ((Element)v.get(169)).setAttribute("ID","EstCab" );
      ((Element)v.get(169)).setAttribute("cod","1281" );
      ((Element)v.get(164)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */

      /* Empieza nodo:170 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(170)).setAttribute("colFondo","" );
      ((Element)v.get(170)).setAttribute("ID","EstCab" );
      ((Element)v.get(170)).setAttribute("cod","261" );
      ((Element)v.get(164)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 164   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(171)).setAttribute("colFondo","" );
      ((Element)v.get(171)).setAttribute("ID","EstCab" );
      ((Element)v.get(171)).setAttribute("cod","173" );
      ((Element)v.get(164)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:164   */

      /* Empieza nodo:172 / Elemento padre: 146   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(172)).setAttribute("alto","22" );
      ((Element)v.get(172)).setAttribute("accion","" );
      ((Element)v.get(172)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(172)).setAttribute("formaEnvio","xml" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(172)).setAttribute("maxSel","-1" );
      ((Element)v.get(172)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(172)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(172)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(172)).setAttribute("onLoad","" );
      ((Element)v.get(172)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(146)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(173)).setAttribute("tipo","texto" );
      ((Element)v.get(173)).setAttribute("ID","EstDat" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */

      /* Empieza nodo:174 / Elemento padre: 172   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(174)).setAttribute("tipo","texto" );
      ((Element)v.get(174)).setAttribute("ID","EstDat2" );
      ((Element)v.get(172)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 172   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(175)).setAttribute("tipo","texto" );
      ((Element)v.get(175)).setAttribute("ID","EstDat" );
      ((Element)v.get(172)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */

      /* Empieza nodo:176 / Elemento padre: 172   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(176)).setAttribute("tipo","texto" );
      ((Element)v.get(176)).setAttribute("ID","EstDat2" );
      ((Element)v.get(172)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */

      /* Empieza nodo:177 / Elemento padre: 172   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(177)).setAttribute("tipo","texto" );
      ((Element)v.get(177)).setAttribute("ID","EstDat" );
      ((Element)v.get(172)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 172   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(178)).setAttribute("tipo","texto" );
      ((Element)v.get(178)).setAttribute("ID","EstDat2" );
      ((Element)v.get(172)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */

      /* Empieza nodo:179 / Elemento padre: 172   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(179)).setAttribute("tipo","texto" );
      ((Element)v.get(179)).setAttribute("ID","EstDat" );
      ((Element)v.get(172)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:172   */

      /* Empieza nodo:180 / Elemento padre: 146   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(146)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 146   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(181)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(181)).setAttribute("ancho","529" );
      ((Element)v.get(181)).setAttribute("sep","$" );
      ((Element)v.get(181)).setAttribute("x","12" );
      ((Element)v.get(181)).setAttribute("class","botonera" );
      ((Element)v.get(181)).setAttribute("y","294" );
      ((Element)v.get(181)).setAttribute("control","|" );
      ((Element)v.get(181)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(181)).setAttribute("rowset","" );
      ((Element)v.get(181)).setAttribute("cargainicial","N" );
      ((Element)v.get(181)).setAttribute("onload","procesarPaginado(mipgndo,msgError,ultima,rowset,'muestraLista(ultima, rowset)')" );
      ((Element)v.get(146)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(182)).setAttribute("nombre","ret1" );
      ((Element)v.get(182)).setAttribute("x","37" );
      ((Element)v.get(182)).setAttribute("y","298" );
      ((Element)v.get(182)).setAttribute("ID","botonContenido" );
      ((Element)v.get(182)).setAttribute("img","retroceder_on" );
      ((Element)v.get(182)).setAttribute("tipo","0" );
      ((Element)v.get(182)).setAttribute("estado","false" );
      ((Element)v.get(182)).setAttribute("alt","" );
      ((Element)v.get(182)).setAttribute("codigo","" );
      ((Element)v.get(182)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 181   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(183)).setAttribute("nombre","ava1" );
      ((Element)v.get(183)).setAttribute("x","52" );
      ((Element)v.get(183)).setAttribute("y","298" );
      ((Element)v.get(183)).setAttribute("ID","botonContenido" );
      ((Element)v.get(183)).setAttribute("img","avanzar_on" );
      ((Element)v.get(183)).setAttribute("tipo","0" );
      ((Element)v.get(183)).setAttribute("estado","false" );
      ((Element)v.get(183)).setAttribute("alt","" );
      ((Element)v.get(183)).setAttribute("codigo","" );
      ((Element)v.get(183)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(181)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:181   */
      /* Termina nodo:146   */

      /* Empieza nodo:184 / Elemento padre: 145   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(184)).setAttribute("nombre","prim1" );
      ((Element)v.get(184)).setAttribute("x","20" );
      ((Element)v.get(184)).setAttribute("y","298" );
      ((Element)v.get(184)).setAttribute("ID","botonContenido" );
      ((Element)v.get(184)).setAttribute("img","primera_on" );
      ((Element)v.get(184)).setAttribute("tipo","-2" );
      ((Element)v.get(184)).setAttribute("estado","false" );
      ((Element)v.get(184)).setAttribute("alt","" );
      ((Element)v.get(184)).setAttribute("codigo","" );
      ((Element)v.get(184)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(145)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */

      /* Empieza nodo:185 / Elemento padre: 145   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(185)).setAttribute("nombre","separa" );
      ((Element)v.get(185)).setAttribute("x","59" );
      ((Element)v.get(185)).setAttribute("y","294" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(185)).setAttribute("ID","botonContenido" );
      ((Element)v.get(185)).setAttribute("img","separa_base" );
      ((Element)v.get(185)).setAttribute("tipo","0" );
      ((Element)v.get(185)).setAttribute("estado","false" );
      ((Element)v.get(185)).setAttribute("alt","" );
      ((Element)v.get(185)).setAttribute("codigo","" );
      ((Element)v.get(185)).setAttribute("accion","" );
      ((Element)v.get(145)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */

      /* Empieza nodo:186 / Elemento padre: 145   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(186)).setAttribute("nombre","btnDetalle" );
      ((Element)v.get(186)).setAttribute("x","80" );
      ((Element)v.get(186)).setAttribute("y","294" );
      ((Element)v.get(186)).setAttribute("ID","botonContenido" );
      ((Element)v.get(186)).setAttribute("img","" );
      ((Element)v.get(186)).setAttribute("tipo","html" );
      ((Element)v.get(186)).setAttribute("estado","false" );
      ((Element)v.get(186)).setAttribute("cod","3" );
      ((Element)v.get(186)).setAttribute("accion","accionDetalle();" );
      ((Element)v.get(186)).setAttribute("ontab","focaliza('formulario.cbFormaPago');" );
      ((Element)v.get(186)).setAttribute("onshtab","focoBuscar();" );
      ((Element)v.get(145)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:145   */

      /* Empieza nodo:187 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(187)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(187)).setAttribute("alto","12" );
      ((Element)v.get(187)).setAttribute("ancho","100" );
      ((Element)v.get(187)).setAttribute("colorf","" );
      ((Element)v.get(187)).setAttribute("borde","0" );
      ((Element)v.get(187)).setAttribute("imagenf","" );
      ((Element)v.get(187)).setAttribute("repeat","" );
      ((Element)v.get(187)).setAttribute("padding","" );
      ((Element)v.get(187)).setAttribute("visibilidad","visible" );
      ((Element)v.get(187)).setAttribute("contravsb","" );
      ((Element)v.get(187)).setAttribute("x","0" );
      ((Element)v.get(187)).setAttribute("y","518" );
      ((Element)v.get(187)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:5   */


   }

}

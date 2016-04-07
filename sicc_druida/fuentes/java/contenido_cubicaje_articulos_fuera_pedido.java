
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_cubicaje_articulos_fuera_pedido  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_cubicaje_articulos_fuera_pedido" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","" );
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
      ((Element)v.get(4)).setAttribute("src","contenido_cubicaje_articulos_fuera_pedido.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbCentroDistribucion" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","ApeParamBalanAreaCheq.centroDistrib.label" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","txtFecha" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","188" );
      ((Element)v.get(8)).setAttribute("format","f" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */
      /* Termina nodo:6   */

      /* Empieza nodo:9 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(9)).setAttribute("nombre","formulario" );
      ((Element)v.get(9)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","accion" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","varIdioma" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","varPais" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 9   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(17)).setAttribute("nombre","capa1" );
      ((Element)v.get(9)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("table"));
      ((Element)v.get(18)).setAttribute("width","100%" );
      ((Element)v.get(18)).setAttribute("border","0" );
      ((Element)v.get(18)).setAttribute("cellspacing","0" );
      ((Element)v.get(18)).setAttribute("cellpadding","0" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("td"));
      ((Element)v.get(20)).setAttribute("width","12" );
      ((Element)v.get(20)).setAttribute("align","center" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(21)).setAttribute("src","b.gif" );
      ((Element)v.get(21)).setAttribute("width","12" );
      ((Element)v.get(21)).setAttribute("height","12" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */
      /* Termina nodo:20   */

      /* Empieza nodo:22 / Elemento padre: 19   */
      v.add(doc.createElement("td"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("width","750" );
      ((Element)v.get(19)).appendChild((Element)v.get(22));

      /* Empieza nodo:23 / Elemento padre: 22   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(23)).setAttribute("src","b.gif" );
      ((Element)v.get(22)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */
      /* Termina nodo:22   */

      /* Empieza nodo:24 / Elemento padre: 19   */
      v.add(doc.createElement("td"));
      ((Element)v.get(24)).setAttribute("width","12" );
      ((Element)v.get(19)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(25)).setAttribute("width","12" );
      ((Element)v.get(25)).setAttribute("height","1" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */
      /* Termina nodo:19   */

      /* Empieza nodo:26 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:29 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(31)).setAttribute("class","legend" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(32)).setAttribute("nombre","lblDatosDeAlta" );
      ((Element)v.get(32)).setAttribute("alto","13" );
      ((Element)v.get(32)).setAttribute("filas","1" );
      ((Element)v.get(32)).setAttribute("cod","ApeCubicArticFueraPed.legend.label" );
      ((Element)v.get(32)).setAttribute("id","legend" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:33 / Elemento padre: 30   */
      v.add(doc.createElement("table"));
      ((Element)v.get(33)).setAttribute("width","100%" );
      ((Element)v.get(33)).setAttribute("border","0" );
      ((Element)v.get(33)).setAttribute("align","center" );
      ((Element)v.get(33)).setAttribute("cellspacing","0" );
      ((Element)v.get(33)).setAttribute("cellpadding","0" );
      ((Element)v.get(30)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("td"));
      ((Element)v.get(35)).setAttribute("colspan","4" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(36)).setAttribute("src","b.gif" );
      ((Element)v.get(36)).setAttribute("width","8" );
      ((Element)v.get(36)).setAttribute("height","8" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:37 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(37));

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
      ((Element)v.get(37)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(41)).setAttribute("nombre","lblCentroDistribucion" );
      ((Element)v.get(41)).setAttribute("alto","13" );
      ((Element)v.get(41)).setAttribute("filas","1" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(41)).setAttribute("id","datosTitle" );
      ((Element)v.get(41)).setAttribute("cod","ApeCubicArticFueraPed.centroDistrib.label" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","25" );
      ((Element)v.get(43)).setAttribute("height","8" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(45)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(45)).setAttribute("alto","13" );
      ((Element)v.get(45)).setAttribute("filas","1" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(45)).setAttribute("id","datosTitle" );
      ((Element)v.get(45)).setAttribute("cod","6" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).setAttribute("width","100%" );
      ((Element)v.get(37)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","8" );
      ((Element)v.get(47)).setAttribute("height","8" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */
      /* Termina nodo:37   */

      /* Empieza nodo:48 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(50)).setAttribute("width","8" );
      ((Element)v.get(50)).setAttribute("height","8" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(51)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(48)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(52)).setAttribute("nombre","cbCentroDistribucion" );
      ((Element)v.get(52)).setAttribute("id","datosCampos" );
      ((Element)v.get(52)).setAttribute("size","1" );
      ((Element)v.get(52)).setAttribute("multiple","N" );
      ((Element)v.get(52)).setAttribute("req","S" );
      ((Element)v.get(52)).setAttribute("onchange","" );
      ((Element)v.get(52)).setAttribute("valorinicial","" );
      ((Element)v.get(52)).setAttribute("textoinicial","" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:54 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).setAttribute("width","25" );
      ((Element)v.get(55)).setAttribute("height","8" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(48)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(57)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(57)).setAttribute("id","datosCampos" );
      ((Element)v.get(57)).setAttribute("size","1" );
      ((Element)v.get(57)).setAttribute("multiple","N" );
      ((Element)v.get(57)).setAttribute("req","N" );
      ((Element)v.get(57)).setAttribute("onchange","onChangeMarcaCanal();" );
      ((Element)v.get(57)).setAttribute("valorinicial","" );
      ((Element)v.get(57)).setAttribute("textoinicial","" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:59 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).setAttribute("width","100%" );
      ((Element)v.get(48)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","8" );
      ((Element)v.get(60)).setAttribute("height","8" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:48   */

      /* Empieza nodo:61 / Elemento padre: 33   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(33)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("colspan","4" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","8" );
      ((Element)v.get(63)).setAttribute("height","8" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:33   */

      /* Empieza nodo:64 / Elemento padre: 30   */
      v.add(doc.createElement("table"));
      ((Element)v.get(64)).setAttribute("width","100%" );
      ((Element)v.get(64)).setAttribute("border","0" );
      ((Element)v.get(64)).setAttribute("align","center" );
      ((Element)v.get(64)).setAttribute("cellspacing","0" );
      ((Element)v.get(64)).setAttribute("cellpadding","0" );
      ((Element)v.get(30)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("colspan","4" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","8" );
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:68 / Elemento padre: 64   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(64)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","8" );
      ((Element)v.get(70)).setAttribute("height","8" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(72)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(72)).setAttribute("alto","13" );
      ((Element)v.get(72)).setAttribute("filas","1" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(72)).setAttribute("id","datosTitle" );
      ((Element)v.get(72)).setAttribute("cod","7" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","25" );
      ((Element)v.get(74)).setAttribute("height","8" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(76)).setAttribute("nombre","lblRegion" );
      ((Element)v.get(76)).setAttribute("alto","13" );
      ((Element)v.get(76)).setAttribute("filas","1" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(76)).setAttribute("id","datosTitle" );
      ((Element)v.get(76)).setAttribute("cod","00232" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","25" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(80)).setAttribute("nombre","lblZona" );
      ((Element)v.get(80)).setAttribute("alto","13" );
      ((Element)v.get(80)).setAttribute("filas","1" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(80)).setAttribute("id","datosTitle" );
      ((Element)v.get(80)).setAttribute("cod","00233" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","25" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(84)).setAttribute("nombre","lblSeccion" );
      ((Element)v.get(84)).setAttribute("alto","13" );
      ((Element)v.get(84)).setAttribute("filas","1" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(84)).setAttribute("id","datosTitle" );
      ((Element)v.get(84)).setAttribute("cod","00234" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","25" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(88)).setAttribute("nombre","lblFecha" );
      ((Element)v.get(88)).setAttribute("alto","13" );
      ((Element)v.get(88)).setAttribute("filas","1" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(88)).setAttribute("id","datosTitle" );
      ((Element)v.get(88)).setAttribute("cod","188" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("width","100%" );
      ((Element)v.get(68)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","8" );
      ((Element)v.get(90)).setAttribute("height","8" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:68   */

      /* Empieza nodo:91 / Elemento padre: 64   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(64)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","8" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(91)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(95)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(95)).setAttribute("id","datosCampos" );
      ((Element)v.get(95)).setAttribute("size","1" );
      ((Element)v.get(95)).setAttribute("multiple","N" );
      ((Element)v.get(95)).setAttribute("req","N" );
      ((Element)v.get(95)).setAttribute("onchange","onChangeMarcaCanal();" );
      ((Element)v.get(95)).setAttribute("valorinicial","" );
      ((Element)v.get(95)).setAttribute("textoinicial","" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:97 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).setAttribute("width","25" );
      ((Element)v.get(98)).setAttribute("height","8" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(91)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(100)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(100)).setAttribute("id","datosCampos" );
      ((Element)v.get(100)).setAttribute("size","1" );
      ((Element)v.get(100)).setAttribute("multiple","N" );
      ((Element)v.get(100)).setAttribute("req","N" );
      ((Element)v.get(100)).setAttribute("onchange","onChangeRegion();" );
      ((Element)v.get(100)).setAttribute("valorinicial","" );
      ((Element)v.get(100)).setAttribute("textoinicial","" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:102 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","25" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(91)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(105)).setAttribute("nombre","cbZona" );
      ((Element)v.get(105)).setAttribute("id","datosCampos" );
      ((Element)v.get(105)).setAttribute("size","1" );
      ((Element)v.get(105)).setAttribute("multiple","N" );
      ((Element)v.get(105)).setAttribute("req","N" );
      ((Element)v.get(105)).setAttribute("onchange","onChangeZona();" );
      ((Element)v.get(105)).setAttribute("valorinicial","" );
      ((Element)v.get(105)).setAttribute("textoinicial","" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:107 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","25" );
      ((Element)v.get(108)).setAttribute("height","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(91)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(110)).setAttribute("nombre","cbSeccion" );
      ((Element)v.get(110)).setAttribute("id","datosCampos" );
      ((Element)v.get(110)).setAttribute("size","1" );
      ((Element)v.get(110)).setAttribute("multiple","N" );
      ((Element)v.get(110)).setAttribute("req","N" );
      ((Element)v.get(110)).setAttribute("onchange","" );
      ((Element)v.get(110)).setAttribute("valorinicial","" );
      ((Element)v.get(110)).setAttribute("textoinicial","" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("ROWSET"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:112 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).setAttribute("width","25" );
      ((Element)v.get(113)).setAttribute("height","8" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(91)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(115)).setAttribute("nombre","txtFecha" );
      ((Element)v.get(115)).setAttribute("id","datosCampos" );
      ((Element)v.get(115)).setAttribute("max","10" );
      ((Element)v.get(115)).setAttribute("tipo","" );
      ((Element)v.get(115)).setAttribute("onchange","" );
      ((Element)v.get(115)).setAttribute("req","S" );
      ((Element)v.get(115)).setAttribute("size","12" );
      ((Element)v.get(115)).setAttribute("valor","" );
      ((Element)v.get(115)).setAttribute("validacion","" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).setAttribute("width","100%" );
      ((Element)v.get(91)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","8" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:91   */

      /* Empieza nodo:118 / Elemento padre: 64   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(64)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).setAttribute("colspan","4" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).setAttribute("width","8" );
      ((Element)v.get(120)).setAttribute("height","8" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:64   */
      /* Termina nodo:30   */

      /* Empieza nodo:121 / Elemento padre: 29   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(29)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("table"));
      ((Element)v.get(122)).setAttribute("width","100%" );
      ((Element)v.get(122)).setAttribute("border","0" );
      ((Element)v.get(122)).setAttribute("align","center" );
      ((Element)v.get(122)).setAttribute("cellspacing","0" );
      ((Element)v.get(122)).setAttribute("cellpadding","0" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).setAttribute("class","botonera" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(125)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(125)).setAttribute("ID","botonContenido" );
      ((Element)v.get(125)).setAttribute("tipo","html" );
      ((Element)v.get(125)).setAttribute("accion","accionBuscar();" );
      ((Element)v.get(125)).setAttribute("estado","false" );
      ((Element)v.get(125)).setAttribute("cod","1" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:29   */

      /* Empieza nodo:126 / Elemento padre: 26   */
      v.add(doc.createElement("td"));
      ((Element)v.get(26)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","8" );
      ((Element)v.get(127)).setAttribute("height","12" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:26   */

      /* Empieza nodo:128 / Elemento padre: 18   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(18)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("width","12" );
      ((Element)v.get(129)).setAttribute("align","center" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","12" );
      ((Element)v.get(130)).setAttribute("height","12" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).setAttribute("width","756" );
      ((Element)v.get(128)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).setAttribute("width","12" );
      ((Element)v.get(128)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","12" );
      ((Element)v.get(134)).setAttribute("height","1" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:128   */
      /* Termina nodo:18   */
      /* Termina nodo:17   */

      /* Empieza nodo:135 / Elemento padre: 9   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(135)).setAttribute("nombre","capaLista" );
      ((Element)v.get(135)).setAttribute("ancho","100%" );
      ((Element)v.get(135)).setAttribute("alto","330" );
      ((Element)v.get(135)).setAttribute("x","7" );
      ((Element)v.get(135)).setAttribute("y","200" );
      ((Element)v.get(135)).setAttribute("colorf","" );
      ((Element)v.get(135)).setAttribute("borde","0" );
      ((Element)v.get(135)).setAttribute("imagenf","" );
      ((Element)v.get(135)).setAttribute("repeat","" );
      ((Element)v.get(135)).setAttribute("padding","" );
      ((Element)v.get(135)).setAttribute("visibilidad","" );
      ((Element)v.get(135)).setAttribute("contravsb","" );
      ((Element)v.get(135)).setAttribute("zindex","" );
      ((Element)v.get(9)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(136)).setAttribute("nombre","listado1" );
      ((Element)v.get(136)).setAttribute("ancho","369" );
      ((Element)v.get(136)).setAttribute("alto","301" );
      ((Element)v.get(136)).setAttribute("x","12" );
      ((Element)v.get(136)).setAttribute("y","0" );
      ((Element)v.get(136)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(136)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(137)).setAttribute("precarga","S" );
      ((Element)v.get(137)).setAttribute("conROver","S" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(138)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(138)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(138)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(138)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 137   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(139)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(139)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(139)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(139)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(137)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 137   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(140)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(140)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(137)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:137   */

      /* Empieza nodo:141 / Elemento padre: 136   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(136)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(142)).setAttribute("borde","1" );
      ((Element)v.get(142)).setAttribute("horizDatos","1" );
      ((Element)v.get(142)).setAttribute("horizCabecera","1" );
      ((Element)v.get(142)).setAttribute("vertical","1" );
      ((Element)v.get(142)).setAttribute("horizTitulo","1" );
      ((Element)v.get(142)).setAttribute("horizBase","1" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 141   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(143)).setAttribute("borde","#999999" );
      ((Element)v.get(143)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(143)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(143)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(143)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(143)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(143)).setAttribute("horizBase","#999999" );
      ((Element)v.get(141)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:141   */

      /* Empieza nodo:144 / Elemento padre: 136   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(144)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(144)).setAttribute("alto","22" );
      ((Element)v.get(144)).setAttribute("imgFondo","" );
      ((Element)v.get(144)).setAttribute("cod","00135" );
      ((Element)v.get(144)).setAttribute("ID","datosTitle" );
      ((Element)v.get(136)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 136   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(145)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(145)).setAttribute("alto","22" );
      ((Element)v.get(145)).setAttribute("imgFondo","" );
      ((Element)v.get(136)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */

      /* Empieza nodo:146 / Elemento padre: 136   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(146)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(146)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(146)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(146)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(146)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(146)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(136)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(147)).setAttribute("ancho","100" );
      ((Element)v.get(147)).setAttribute("minimizable","S" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(147)).setAttribute("minimizada","N" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */

      /* Empieza nodo:148 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(148)).setAttribute("ancho","100" );
      ((Element)v.get(148)).setAttribute("minimizable","S" );
      ((Element)v.get(148)).setAttribute("minimizada","N" );
      ((Element)v.get(146)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */

      /* Empieza nodo:149 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(149)).setAttribute("ancho","100" );
      ((Element)v.get(149)).setAttribute("minimizable","S" );
      ((Element)v.get(149)).setAttribute("minimizada","N" );
      ((Element)v.get(146)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */

      /* Empieza nodo:150 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(150)).setAttribute("ancho","100" );
      ((Element)v.get(150)).setAttribute("minimizable","S" );
      ((Element)v.get(150)).setAttribute("minimizada","N" );
      ((Element)v.get(146)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */

      /* Empieza nodo:151 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(151)).setAttribute("ancho","100" );
      ((Element)v.get(151)).setAttribute("minimizable","S" );
      ((Element)v.get(151)).setAttribute("minimizada","N" );
      ((Element)v.get(146)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */

      /* Empieza nodo:152 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(152)).setAttribute("ancho","100" );
      ((Element)v.get(152)).setAttribute("minimizable","S" );
      ((Element)v.get(152)).setAttribute("minimizada","N" );
      ((Element)v.get(146)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */

      /* Empieza nodo:153 / Elemento padre: 146   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(153)).setAttribute("ancho","100" );
      ((Element)v.get(153)).setAttribute("minimizable","S" );
      ((Element)v.get(153)).setAttribute("minimizada","N" );
      ((Element)v.get(146)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:146   */

      /* Empieza nodo:154 / Elemento padre: 136   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(154)).setAttribute("alto","25" );
      ((Element)v.get(154)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(154)).setAttribute("imgFondo","" );
      ((Element)v.get(154)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(136)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(155)).setAttribute("colFondo","" );
      ((Element)v.get(155)).setAttribute("ID","EstCab" );
      ((Element)v.get(155)).setAttribute("align","center" );
      ((Element)v.get(155)).setAttribute("cod","ApeCubicArticFueraPed.ListaPicado.label" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Elemento padre:155 / Elemento actual: 156   */
      v.add(doc.createTextNode("Lista picado"));
      ((Element)v.get(155)).appendChild((Text)v.get(156));

      /* Termina nodo Texto:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(157)).setAttribute("colFondo","" );
      ((Element)v.get(157)).setAttribute("ID","EstCab" );
      ((Element)v.get(157)).setAttribute("cod","00232" );
      ((Element)v.get(154)).appendChild((Element)v.get(157));

      /* Elemento padre:157 / Elemento actual: 158   */
      v.add(doc.createTextNode("Regi�n"));
      ((Element)v.get(157)).appendChild((Text)v.get(158));

      /* Termina nodo Texto:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(159)).setAttribute("colFondo","" );
      ((Element)v.get(159)).setAttribute("ID","EstCab" );
      ((Element)v.get(159)).setAttribute("cod","00233" );
      ((Element)v.get(154)).appendChild((Element)v.get(159));

      /* Elemento padre:159 / Elemento actual: 160   */
      v.add(doc.createTextNode("Zona"));
      ((Element)v.get(159)).appendChild((Text)v.get(160));

      /* Termina nodo Texto:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(161)).setAttribute("colFondo","" );
      ((Element)v.get(161)).setAttribute("ID","EstCab" );
      ((Element)v.get(161)).setAttribute("cod","00234" );
      ((Element)v.get(154)).appendChild((Element)v.get(161));

      /* Elemento padre:161 / Elemento actual: 162   */
      v.add(doc.createTextNode("Secci�n"));
      ((Element)v.get(161)).appendChild((Text)v.get(162));

      /* Termina nodo Texto:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(163)).setAttribute("colFondo","" );
      ((Element)v.get(163)).setAttribute("ID","EstCab" );
      ((Element)v.get(163)).setAttribute("cod","ApeCubicArticFueraPed.codAgrup.label" );
      ((Element)v.get(154)).appendChild((Element)v.get(163));

      /* Elemento padre:163 / Elemento actual: 164   */
      v.add(doc.createTextNode("C�d. Agrupaci�n"));
      ((Element)v.get(163)).appendChild((Text)v.get(164));

      /* Termina nodo Texto:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(165)).setAttribute("colFondo","" );
      ((Element)v.get(165)).setAttribute("ID","EstCab" );
      ((Element)v.get(165)).setAttribute("cod","ApeCubicArticFueraPed.impreso.label" );
      ((Element)v.get(154)).appendChild((Element)v.get(165));

      /* Elemento padre:165 / Elemento actual: 166   */
      v.add(doc.createTextNode("Impreso"));
      ((Element)v.get(165)).appendChild((Text)v.get(166));

      /* Termina nodo Texto:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 154   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(167)).setAttribute("colFondo","" );
      ((Element)v.get(167)).setAttribute("ID","EstCab" );
      ((Element)v.get(167)).setAttribute("cod","ApeCubicArticFueraPed.palletAsignado.label" );
      ((Element)v.get(154)).appendChild((Element)v.get(167));

      /* Elemento padre:167 / Elemento actual: 168   */
      v.add(doc.createTextNode("Pallets asignados"));
      ((Element)v.get(167)).appendChild((Text)v.get(168));

      /* Termina nodo Texto:168   */
      /* Termina nodo:167   */
      /* Termina nodo:154   */

      /* Empieza nodo:169 / Elemento padre: 136   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(169)).setAttribute("alto","22" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(169)).setAttribute("accion","" );
      ((Element)v.get(169)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(169)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(169)).setAttribute("maxSel","-1" );
      ((Element)v.get(169)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(169)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(169)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(169)).setAttribute("onLoad","" );
      ((Element)v.get(169)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(136)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(170)).setAttribute("tipo","texto" );
      ((Element)v.get(170)).setAttribute("ID","EstDat" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(171)).setAttribute("tipo","texto" );
      ((Element)v.get(171)).setAttribute("ID","EstDat2" );
      ((Element)v.get(169)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */

      /* Empieza nodo:172 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(172)).setAttribute("tipo","texto" );
      ((Element)v.get(172)).setAttribute("ID","EstDat" );
      ((Element)v.get(169)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */

      /* Empieza nodo:173 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(173)).setAttribute("tipo","texto" );
      ((Element)v.get(173)).setAttribute("ID","EstDat2" );
      ((Element)v.get(169)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */

      /* Empieza nodo:174 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(174)).setAttribute("tipo","texto" );
      ((Element)v.get(174)).setAttribute("ID","EstDat2" );
      ((Element)v.get(169)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(175)).setAttribute("tipo","texto" );
      ((Element)v.get(175)).setAttribute("ID","EstDat2" );
      ((Element)v.get(169)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */

      /* Empieza nodo:176 / Elemento padre: 169   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(176)).setAttribute("tipo","texto" );
      ((Element)v.get(176)).setAttribute("ID","EstDat2" );
      ((Element)v.get(169)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:169   */

      /* Empieza nodo:177 / Elemento padre: 136   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(136)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 136   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(178)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(178)).setAttribute("ancho","679" );
      ((Element)v.get(178)).setAttribute("sep","$" );
      ((Element)v.get(178)).setAttribute("x","12" );
      ((Element)v.get(178)).setAttribute("class","botonera" );
      ((Element)v.get(178)).setAttribute("y","294" );
      ((Element)v.get(178)).setAttribute("control","|" );
      ((Element)v.get(178)).setAttribute("conector","ConectorBuscarCargosAbonos" );
      ((Element)v.get(178)).setAttribute("rowset","" );
      ((Element)v.get(178)).setAttribute("cargainicial","N" );
      ((Element)v.get(178)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(136)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(179)).setAttribute("nombre","ret1" );
      ((Element)v.get(179)).setAttribute("x","37" );
      ((Element)v.get(179)).setAttribute("y","282" );
      ((Element)v.get(179)).setAttribute("ID","botonContenido" );
      ((Element)v.get(179)).setAttribute("img","retroceder_on" );
      ((Element)v.get(179)).setAttribute("tipo","0" );
      ((Element)v.get(179)).setAttribute("estado","false" );
      ((Element)v.get(179)).setAttribute("alt","" );
      ((Element)v.get(179)).setAttribute("codigo","" );
      ((Element)v.get(179)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */

      /* Empieza nodo:180 / Elemento padre: 178   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(180)).setAttribute("nombre","ava1" );
      ((Element)v.get(180)).setAttribute("x","52" );
      ((Element)v.get(180)).setAttribute("y","282" );
      ((Element)v.get(180)).setAttribute("ID","botonContenido" );
      ((Element)v.get(180)).setAttribute("img","avanzar_on" );
      ((Element)v.get(180)).setAttribute("tipo","0" );
      ((Element)v.get(180)).setAttribute("estado","false" );
      ((Element)v.get(180)).setAttribute("alt","" );
      ((Element)v.get(180)).setAttribute("codigo","" );
      ((Element)v.get(180)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(178)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:178   */
      /* Termina nodo:136   */

      /* Empieza nodo:181 / Elemento padre: 135   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(181)).setAttribute("nombre","primera1" );
      ((Element)v.get(181)).setAttribute("x","20" );
      ((Element)v.get(181)).setAttribute("y","282" );
      ((Element)v.get(181)).setAttribute("ID","botonContenido" );
      ((Element)v.get(181)).setAttribute("img","primera_on" );
      ((Element)v.get(181)).setAttribute("tipo","-2" );
      ((Element)v.get(181)).setAttribute("estado","false" );
      ((Element)v.get(181)).setAttribute("alt","" );
      ((Element)v.get(181)).setAttribute("codigo","" );
      ((Element)v.get(181)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(135)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */

      /* Empieza nodo:182 / Elemento padre: 135   */
      v.add(doc.createElement("BOTON"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(182)).setAttribute("nombre","separa" );
      ((Element)v.get(182)).setAttribute("x","59" );
      ((Element)v.get(182)).setAttribute("y","278" );
      ((Element)v.get(182)).setAttribute("ID","botonContenido" );
      ((Element)v.get(182)).setAttribute("img","separa_base" );
      ((Element)v.get(182)).setAttribute("tipo","0" );
      ((Element)v.get(182)).setAttribute("estado","false" );
      ((Element)v.get(182)).setAttribute("alt","" );
      ((Element)v.get(182)).setAttribute("codigo","" );
      ((Element)v.get(182)).setAttribute("accion","" );
      ((Element)v.get(135)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 135   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(183)).setAttribute("nombre","AsignarPallet" );
      ((Element)v.get(183)).setAttribute("x","80" );
      ((Element)v.get(183)).setAttribute("y","279" );
      ((Element)v.get(183)).setAttribute("ID","botonContenido" );
      ((Element)v.get(183)).setAttribute("tipo","html" );
      ((Element)v.get(183)).setAttribute("estado","false" );
      ((Element)v.get(183)).setAttribute("cod","ApeCubicArticFueraPed.AsignarPallet.label" );
      ((Element)v.get(183)).setAttribute("accion","accionAsignarPallet();" );
      ((Element)v.get(135)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */

      /* Empieza nodo:184 / Elemento padre: 135   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(184)).setAttribute("nombre","VerDatosAgrup" );
      ((Element)v.get(184)).setAttribute("x","180" );
      ((Element)v.get(184)).setAttribute("y","279" );
      ((Element)v.get(184)).setAttribute("ID","botonContenido" );
      ((Element)v.get(184)).setAttribute("tipo","html" );
      ((Element)v.get(184)).setAttribute("estado","false" );
      ((Element)v.get(184)).setAttribute("cod","ApeCubicArticFueraPed.verDatosAgrup.label" );
      ((Element)v.get(184)).setAttribute("accion","accionVerDatosAgrup();" );
      ((Element)v.get(135)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:135   */

      /* Empieza nodo:185 / Elemento padre: 9   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(185)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(185)).setAttribute("alto","12" );
      ((Element)v.get(185)).setAttribute("ancho","100%" );
      ((Element)v.get(185)).setAttribute("colorf","" );
      ((Element)v.get(185)).setAttribute("borde","0" );
      ((Element)v.get(185)).setAttribute("imagenf","" );
      ((Element)v.get(185)).setAttribute("repeat","" );
      ((Element)v.get(185)).setAttribute("padding","" );
      ((Element)v.get(185)).setAttribute("visibilidad","visible" );
      ((Element)v.get(185)).setAttribute("contravsb","" );
      ((Element)v.get(185)).setAttribute("x","0" );
      ((Element)v.get(185)).setAttribute("y","428" );
      ((Element)v.get(185)).setAttribute("zindex","" );
      ((Element)v.get(9)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:9   */


   }

}

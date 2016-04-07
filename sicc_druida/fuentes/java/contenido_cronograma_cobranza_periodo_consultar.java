
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_cronograma_cobranza_periodo_consultar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_cronograma_cobranza_periodo_consultar" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","Consultar cronograma de cobranza para período" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Consultar cronograma de cobranza para período" );
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
      ((Element)v.get(2)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","contenido_cronograma_cobranza_periodo_consultar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","frmFormulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","accion" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","casoDeUso" );
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
      ((Element)v.get(11)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","hPais" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(14)).setAttribute("nombre","capaContenido" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("table"));
      ((Element)v.get(15)).setAttribute("width","100%" );
      ((Element)v.get(15)).setAttribute("border","0" );
      ((Element)v.get(15)).setAttribute("cellspacing","0" );
      ((Element)v.get(15)).setAttribute("cellpadding","0" );
      ((Element)v.get(14)).appendChild((Element)v.get(15));

      /* Empieza nodo:16 / Elemento padre: 15   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(15)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("td"));
      ((Element)v.get(17)).setAttribute("width","12" );
      ((Element)v.get(17)).setAttribute("align","center" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(18)).setAttribute("src","b.gif" );
      ((Element)v.get(18)).setAttribute("width","12" );
      ((Element)v.get(18)).setAttribute("height","12" );
      ((Element)v.get(17)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */
      /* Termina nodo:17   */

      /* Empieza nodo:19 / Elemento padre: 16   */
      v.add(doc.createElement("td"));
      ((Element)v.get(19)).setAttribute("width","750" );
      ((Element)v.get(16)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(20)).setAttribute("src","b.gif" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */
      /* Termina nodo:19   */

      /* Empieza nodo:21 / Elemento padre: 16   */
      v.add(doc.createElement("td"));
      ((Element)v.get(21)).setAttribute("width","12" );
      ((Element)v.get(16)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(22)).setAttribute("src","b.gif" );
      ((Element)v.get(22)).setAttribute("width","12" );
      ((Element)v.get(22)).setAttribute("height","1" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */
      /* Termina nodo:21   */
      /* Termina nodo:16   */

      /* Empieza nodo:23 / Elemento padre: 15   */
      v.add(doc.createElement("tr"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(15)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(25)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:26 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(28)).setAttribute("class","legend" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(29)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(29)).setAttribute("alto","13" );
      ((Element)v.get(29)).setAttribute("filas","1" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(29)).setAttribute("id","legend" );
      ((Element)v.get(29)).setAttribute("cod","0075" );
      ((Element)v.get(28)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:30 / Elemento padre: 27   */
      v.add(doc.createElement("table"));
      ((Element)v.get(30)).setAttribute("width","100%" );
      ((Element)v.get(30)).setAttribute("border","0" );
      ((Element)v.get(30)).setAttribute("align","center" );
      ((Element)v.get(30)).setAttribute("cellspacing","0" );
      ((Element)v.get(30)).setAttribute("cellpadding","0" );
      ((Element)v.get(27)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(30)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("td"));
      ((Element)v.get(31)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("table"));
      ((Element)v.get(33)).setAttribute("width","679" );
      ((Element)v.get(33)).setAttribute("border","0" );
      ((Element)v.get(33)).setAttribute("align","left" );
      ((Element)v.get(33)).setAttribute("cellspacing","0" );
      ((Element)v.get(33)).setAttribute("cellpadding","0" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));

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
      ((Element)v.get(41)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(41)).setAttribute("alto","13" );
      ((Element)v.get(41)).setAttribute("filas","1" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(41)).setAttribute("id","datosTitle" );
      ((Element)v.get(41)).setAttribute("cod","6" );
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
      ((Element)v.get(45)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(45)).setAttribute("alto","13" );
      ((Element)v.get(45)).setAttribute("filas","1" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(45)).setAttribute("id","datosTitle" );
      ((Element)v.get(45)).setAttribute("cod","7" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).setAttribute("width","100%" );
      ((Element)v.get(37)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
   }

   private void getXML180(Document doc) {
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
      ((Element)v.get(48)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(52)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(52)).setAttribute("id","datosCampos" );
      ((Element)v.get(52)).setAttribute("onchange","recargaPeriodo();" );
      ((Element)v.get(52)).setAttribute("onshtab","onshTabMarca();" );
      ((Element)v.get(52)).setAttribute("size","1" );
      ((Element)v.get(52)).setAttribute("multiple","N" );
      ((Element)v.get(52)).setAttribute("req","N" );
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
      ((Element)v.get(48)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(57)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(57)).setAttribute("id","datosCampos" );
      ((Element)v.get(57)).setAttribute("onchange","recargaPeriodo();" );
      ((Element)v.get(57)).setAttribute("size","1" );
      ((Element)v.get(57)).setAttribute("multiple","N" );
      ((Element)v.get(57)).setAttribute("req","N" );
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
      /* Termina nodo:32   */
      /* Termina nodo:31   */

      /* Empieza nodo:64 / Elemento padre: 30   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(30)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("table"));
      ((Element)v.get(66)).setAttribute("width","679" );
      ((Element)v.get(66)).setAttribute("border","0" );
      ((Element)v.get(66)).setAttribute("align","left" );
      ((Element)v.get(66)).setAttribute("cellspacing","0" );
      ((Element)v.get(66)).setAttribute("cellpadding","0" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(66)).appendChild((Element)v.get(67));

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
      ((Element)v.get(67)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(71)).setAttribute("nombre","lblPeriodo" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(71)).setAttribute("alto","13" );
      ((Element)v.get(71)).setAttribute("filas","1" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(71)).setAttribute("id","datosTitle" );
      ((Element)v.get(71)).setAttribute("cod","276" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("width","100%" );
      ((Element)v.get(67)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","8" );
      ((Element)v.get(73)).setAttribute("height","8" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:67   */

      /* Empieza nodo:74 / Elemento padre: 66   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(66)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","8" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(78)).setAttribute("nombre","cbPeriodo" );
      ((Element)v.get(78)).setAttribute("id","datosCampos" );
      ((Element)v.get(78)).setAttribute("size","1" );
      ((Element)v.get(78)).setAttribute("multiple","N" );
      ((Element)v.get(78)).setAttribute("req","N" );
      ((Element)v.get(78)).setAttribute("valorinicial","" );
      ((Element)v.get(78)).setAttribute("textoinicial","" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:80 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("width","100%" );
      ((Element)v.get(74)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).setAttribute("width","8" );
      ((Element)v.get(81)).setAttribute("height","8" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:74   */

      /* Empieza nodo:82 / Elemento padre: 66   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(66)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("colspan","4" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","8" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:30   */
      /* Termina nodo:27   */
      /* Termina nodo:26   */

      /* Empieza nodo:85 / Elemento padre: 23   */
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:23   */

      /* Empieza nodo:87 / Elemento padre: 15   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(15)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("table"));
      ((Element)v.get(92)).setAttribute("width","100%" );
      ((Element)v.get(92)).setAttribute("border","0" );
      ((Element)v.get(92)).setAttribute("align","center" );
      ((Element)v.get(92)).setAttribute("cellspacing","0" );
      ((Element)v.get(92)).setAttribute("cellpadding","0" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("class","botonera" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(95)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(95)).setAttribute("ID","botonContenido" );
      ((Element)v.get(95)).setAttribute("tipo","html" );
      ((Element)v.get(95)).setAttribute("accion","accionBuscar();" );
      ((Element)v.get(95)).setAttribute("ontab","onTabBuscar();" );
      ((Element)v.get(95)).setAttribute("estado","false" );
      ((Element)v.get(95)).setAttribute("cod","1" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:96 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","8" );
      ((Element)v.get(97)).setAttribute("height","12" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:87   */

      /* Empieza nodo:98 / Elemento padre: 15   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(15)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("width","12" );
      ((Element)v.get(99)).setAttribute("align","center" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","12" );
      ((Element)v.get(100)).setAttribute("height","12" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).setAttribute("width","756" );
      ((Element)v.get(98)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("width","12" );
      ((Element)v.get(98)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","12" );
      ((Element)v.get(104)).setAttribute("height","1" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:98   */
      /* Termina nodo:15   */
      /* Termina nodo:14   */

      /* Empieza nodo:105 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(105)).setAttribute("nombre","listado1" );
      ((Element)v.get(105)).setAttribute("ancho","554" );
      ((Element)v.get(105)).setAttribute("alto","317" );
      ((Element)v.get(105)).setAttribute("x","12" );
      ((Element)v.get(105)).setAttribute("y","162" );
      ((Element)v.get(105)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(105)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(106)).setAttribute("precarga","S" );
      ((Element)v.get(106)).setAttribute("conROver","S" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(107)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(107)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(107)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(107)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 106   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(108)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(108)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(108)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(108)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(106)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 106   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(109)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(109)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(106)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:106   */

      /* Empieza nodo:110 / Elemento padre: 105   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(105)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(111)).setAttribute("borde","1" );
      ((Element)v.get(111)).setAttribute("horizDatos","1" );
      ((Element)v.get(111)).setAttribute("horizCabecera","1" );
      ((Element)v.get(111)).setAttribute("vertical","1" );
      ((Element)v.get(111)).setAttribute("horizTitulo","1" );
      ((Element)v.get(111)).setAttribute("horizBase","1" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */

      /* Empieza nodo:112 / Elemento padre: 110   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(112)).setAttribute("borde","#999999" );
      ((Element)v.get(112)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(112)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(112)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(112)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(112)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(112)).setAttribute("horizBase","#999999" );
      ((Element)v.get(110)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:110   */

      /* Empieza nodo:113 / Elemento padre: 105   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(113)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(113)).setAttribute("alto","22" );
      ((Element)v.get(113)).setAttribute("imgFondo","" );
      ((Element)v.get(113)).setAttribute("cod","00135" );
      ((Element)v.get(113)).setAttribute("ID","datosTitle" );
      ((Element)v.get(105)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */

      /* Empieza nodo:114 / Elemento padre: 105   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(114)).setAttribute("colFondo","#CECFCE" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(114)).setAttribute("alto","22" );
      ((Element)v.get(114)).setAttribute("imgFondo","" );
      ((Element)v.get(105)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */

      /* Empieza nodo:115 / Elemento padre: 105   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(115)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(115)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(115)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(115)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(115)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(115)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(105)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(116)).setAttribute("ancho","100" );
      ((Element)v.get(116)).setAttribute("minimizable","S" );
      ((Element)v.get(116)).setAttribute("minimizada","N" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */

      /* Empieza nodo:117 / Elemento padre: 115   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(117)).setAttribute("ancho","130" );
      ((Element)v.get(117)).setAttribute("minimizable","S" );
      ((Element)v.get(117)).setAttribute("minimizada","N" );
      ((Element)v.get(115)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 115   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(118)).setAttribute("ancho","100" );
      ((Element)v.get(118)).setAttribute("minimizable","S" );
      ((Element)v.get(118)).setAttribute("minimizada","N" );
      ((Element)v.get(115)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */

      /* Empieza nodo:119 / Elemento padre: 115   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(119)).setAttribute("ancho","100" );
      ((Element)v.get(119)).setAttribute("minimizable","S" );
      ((Element)v.get(119)).setAttribute("minimizada","N" );
      ((Element)v.get(115)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */

      /* Empieza nodo:120 / Elemento padre: 115   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(120)).setAttribute("ancho","100" );
      ((Element)v.get(120)).setAttribute("minimizable","S" );
      ((Element)v.get(120)).setAttribute("minimizada","N" );
      ((Element)v.get(115)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 115   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(121)).setAttribute("ancho","100" );
      ((Element)v.get(121)).setAttribute("minimizable","S" );
      ((Element)v.get(121)).setAttribute("minimizada","N" );
      ((Element)v.get(115)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */

      /* Empieza nodo:122 / Elemento padre: 115   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(122)).setAttribute("ancho","100" );
      ((Element)v.get(122)).setAttribute("minimizable","S" );
      ((Element)v.get(122)).setAttribute("minimizada","N" );
      ((Element)v.get(115)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 115   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(123)).setAttribute("ancho","100" );
      ((Element)v.get(123)).setAttribute("minimizable","S" );
      ((Element)v.get(123)).setAttribute("minimizada","N" );
      ((Element)v.get(115)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 115   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(124)).setAttribute("ancho","100" );
      ((Element)v.get(124)).setAttribute("minimizable","S" );
      ((Element)v.get(124)).setAttribute("minimizada","N" );
      ((Element)v.get(115)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */

      /* Empieza nodo:125 / Elemento padre: 115   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(125)).setAttribute("ancho","100" );
      ((Element)v.get(125)).setAttribute("minimizable","S" );
      ((Element)v.get(125)).setAttribute("minimizada","N" );
      ((Element)v.get(115)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 115   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(126)).setAttribute("ancho","100" );
      ((Element)v.get(126)).setAttribute("minimizable","S" );
      ((Element)v.get(126)).setAttribute("minimizada","N" );
      ((Element)v.get(115)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 115   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(127)).setAttribute("ancho","100" );
      ((Element)v.get(127)).setAttribute("minimizable","S" );
      ((Element)v.get(127)).setAttribute("minimizada","N" );
      ((Element)v.get(115)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */

      /* Empieza nodo:128 / Elemento padre: 115   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(128)).setAttribute("ancho","130" );
      ((Element)v.get(128)).setAttribute("minimizable","S" );
      ((Element)v.get(128)).setAttribute("minimizada","N" );
      ((Element)v.get(115)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */

      /* Empieza nodo:129 / Elemento padre: 115   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(129)).setAttribute("ancho","130" );
      ((Element)v.get(129)).setAttribute("minimizable","S" );
      ((Element)v.get(129)).setAttribute("minimizada","N" );
      ((Element)v.get(115)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */

      /* Empieza nodo:130 / Elemento padre: 115   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(130)).setAttribute("ancho","130" );
      ((Element)v.get(130)).setAttribute("minimizable","S" );
      ((Element)v.get(130)).setAttribute("minimizada","N" );
      ((Element)v.get(115)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 115   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(131)).setAttribute("ancho","1" );
      ((Element)v.get(131)).setAttribute("minimizable","S" );
      ((Element)v.get(131)).setAttribute("minimizada","N" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(131)).setAttribute("oculta","S" );
      ((Element)v.get(115)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */

      /* Empieza nodo:132 / Elemento padre: 115   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(132)).setAttribute("ancho","1" );
      ((Element)v.get(132)).setAttribute("minimizable","S" );
      ((Element)v.get(132)).setAttribute("minimizada","N" );
      ((Element)v.get(132)).setAttribute("oculta","S" );
      ((Element)v.get(115)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */

      /* Empieza nodo:133 / Elemento padre: 115   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(133)).setAttribute("ancho","1" );
      ((Element)v.get(133)).setAttribute("minimizable","S" );
      ((Element)v.get(133)).setAttribute("minimizada","N" );
      ((Element)v.get(133)).setAttribute("oculta","S" );
      ((Element)v.get(115)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:115   */

      /* Empieza nodo:134 / Elemento padre: 105   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(134)).setAttribute("alto","20" );
      ((Element)v.get(134)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(134)).setAttribute("imgFondo","" );
      ((Element)v.get(134)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(105)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(135)).setAttribute("colFondo","" );
      ((Element)v.get(135)).setAttribute("ID","EstCab" );
      ((Element)v.get(135)).setAttribute("align","center" );
      ((Element)v.get(135)).setAttribute("cod","2512" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */

      /* Empieza nodo:136 / Elemento padre: 134   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(136)).setAttribute("colFondo","" );
      ((Element)v.get(136)).setAttribute("ID","EstCab" );
      ((Element)v.get(136)).setAttribute("align","center" );
      ((Element)v.get(136)).setAttribute("cod","1219" );
      ((Element)v.get(134)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */

      /* Empieza nodo:137 / Elemento padre: 134   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(137)).setAttribute("colFondo","" );
      ((Element)v.get(137)).setAttribute("ID","EstCab" );
      ((Element)v.get(137)).setAttribute("align","center" );
      ((Element)v.get(137)).setAttribute("cod","865" );
      ((Element)v.get(134)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */

      /* Empieza nodo:138 / Elemento padre: 134   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(138)).setAttribute("colFondo","" );
      ((Element)v.get(138)).setAttribute("ID","EstCab" );
      ((Element)v.get(138)).setAttribute("align","center" );
      ((Element)v.get(138)).setAttribute("cod","999" );
      ((Element)v.get(134)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */

      /* Empieza nodo:139 / Elemento padre: 134   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(139)).setAttribute("colFondo","" );
      ((Element)v.get(139)).setAttribute("ID","EstCab" );
      ((Element)v.get(139)).setAttribute("align","center" );
      ((Element)v.get(139)).setAttribute("cod","6" );
      ((Element)v.get(134)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */

      /* Empieza nodo:140 / Elemento padre: 134   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(140)).setAttribute("colFondo","" );
      ((Element)v.get(140)).setAttribute("ID","EstCab" );
      ((Element)v.get(140)).setAttribute("align","center" );
      ((Element)v.get(140)).setAttribute("cod","7" );
      ((Element)v.get(134)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */

      /* Empieza nodo:141 / Elemento padre: 134   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(141)).setAttribute("colFondo","" );
      ((Element)v.get(141)).setAttribute("ID","EstCab" );
      ((Element)v.get(141)).setAttribute("align","center" );
      ((Element)v.get(141)).setAttribute("cod","276" );
      ((Element)v.get(134)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */

      /* Empieza nodo:142 / Elemento padre: 134   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(142)).setAttribute("colFondo","" );
      ((Element)v.get(142)).setAttribute("ID","EstCab" );
      ((Element)v.get(142)).setAttribute("align","center" );
      ((Element)v.get(142)).setAttribute("cod","124" );
      ((Element)v.get(134)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */

      /* Empieza nodo:143 / Elemento padre: 134   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(143)).setAttribute("colFondo","" );
      ((Element)v.get(143)).setAttribute("ID","EstCab" );
      ((Element)v.get(143)).setAttribute("align","center" );
      ((Element)v.get(143)).setAttribute("cod","109" );
      ((Element)v.get(134)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */

      /* Empieza nodo:144 / Elemento padre: 134   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(144)).setAttribute("colFondo","" );
      ((Element)v.get(144)).setAttribute("ID","EstCab" );
      ((Element)v.get(144)).setAttribute("align","center" );
      ((Element)v.get(144)).setAttribute("cod","143" );
      ((Element)v.get(134)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */

      /* Empieza nodo:145 / Elemento padre: 134   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(145)).setAttribute("colFondo","" );
      ((Element)v.get(145)).setAttribute("ID","EstCab" );
      ((Element)v.get(145)).setAttribute("align","center" );
      ((Element)v.get(145)).setAttribute("cod","112" );
      ((Element)v.get(134)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */

      /* Empieza nodo:146 / Elemento padre: 134   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(146)).setAttribute("colFondo","" );
      ((Element)v.get(146)).setAttribute("ID","EstCab" );
      ((Element)v.get(146)).setAttribute("align","center" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(146)).setAttribute("cod","126" );
      ((Element)v.get(134)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */

      /* Empieza nodo:147 / Elemento padre: 134   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(147)).setAttribute("colFondo","" );
      ((Element)v.get(147)).setAttribute("ID","EstCab" );
      ((Element)v.get(147)).setAttribute("align","center" );
      ((Element)v.get(147)).setAttribute("cod","645" );
      ((Element)v.get(134)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */

      /* Empieza nodo:148 / Elemento padre: 134   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(148)).setAttribute("colFondo","" );
      ((Element)v.get(148)).setAttribute("ID","EstCab" );
      ((Element)v.get(148)).setAttribute("align","center" );
      ((Element)v.get(148)).setAttribute("cod","875" );
      ((Element)v.get(134)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */

      /* Empieza nodo:149 / Elemento padre: 134   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(149)).setAttribute("colFondo","" );
      ((Element)v.get(149)).setAttribute("ID","EstCab" );
      ((Element)v.get(149)).setAttribute("align","center" );
      ((Element)v.get(149)).setAttribute("cod","871" );
      ((Element)v.get(134)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */

      /* Empieza nodo:150 / Elemento padre: 134   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(150)).setAttribute("colFondo","" );
      ((Element)v.get(150)).setAttribute("ID","EstCab" );
      ((Element)v.get(134)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */

      /* Empieza nodo:151 / Elemento padre: 134   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(151)).setAttribute("colFondo","" );
      ((Element)v.get(151)).setAttribute("ID","EstCab" );
      ((Element)v.get(134)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */

      /* Empieza nodo:152 / Elemento padre: 134   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(152)).setAttribute("colFondo","" );
      ((Element)v.get(152)).setAttribute("ID","EstCab" );
      ((Element)v.get(134)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:134   */

      /* Empieza nodo:153 / Elemento padre: 105   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(153)).setAttribute("alto","22" );
      ((Element)v.get(153)).setAttribute("accion","" );
      ((Element)v.get(153)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(153)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(153)).setAttribute("maxSel","-1" );
      ((Element)v.get(153)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(153)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(153)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(153)).setAttribute("onLoad","" );
      ((Element)v.get(153)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(105)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(154)).setAttribute("tipo","texto" );
      ((Element)v.get(154)).setAttribute("ID","EstDat" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */

      /* Empieza nodo:155 / Elemento padre: 153   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(155)).setAttribute("tipo","texto" );
      ((Element)v.get(155)).setAttribute("ID","EstDat2" );
      ((Element)v.get(153)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */

      /* Empieza nodo:156 / Elemento padre: 153   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(156)).setAttribute("tipo","texto" );
      ((Element)v.get(156)).setAttribute("ID","EstDat" );
      ((Element)v.get(153)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */

      /* Empieza nodo:157 / Elemento padre: 153   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(157)).setAttribute("tipo","texto" );
      ((Element)v.get(157)).setAttribute("ID","EstDat2" );
      ((Element)v.get(153)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */

      /* Empieza nodo:158 / Elemento padre: 153   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(158)).setAttribute("tipo","texto" );
      ((Element)v.get(158)).setAttribute("ID","EstDat" );
      ((Element)v.get(153)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */

      /* Empieza nodo:159 / Elemento padre: 153   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(159)).setAttribute("tipo","texto" );
      ((Element)v.get(159)).setAttribute("ID","EstDat2" );
      ((Element)v.get(153)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */

      /* Empieza nodo:160 / Elemento padre: 153   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(160)).setAttribute("tipo","texto" );
      ((Element)v.get(160)).setAttribute("ID","EstDat" );
      ((Element)v.get(153)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */

      /* Empieza nodo:161 / Elemento padre: 153   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(161)).setAttribute("tipo","texto" );
      ((Element)v.get(161)).setAttribute("ID","EstDat2" );
      ((Element)v.get(153)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */

      /* Empieza nodo:162 / Elemento padre: 153   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(162)).setAttribute("tipo","texto" );
      ((Element)v.get(162)).setAttribute("ID","EstDat" );
      ((Element)v.get(153)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */

      /* Empieza nodo:163 / Elemento padre: 153   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(163)).setAttribute("tipo","texto" );
      ((Element)v.get(163)).setAttribute("ID","EstDat2" );
      ((Element)v.get(153)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */

      /* Empieza nodo:164 / Elemento padre: 153   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(164)).setAttribute("tipo","texto" );
      ((Element)v.get(164)).setAttribute("ID","EstDat" );
      ((Element)v.get(153)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */

      /* Empieza nodo:165 / Elemento padre: 153   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(165)).setAttribute("tipo","texto" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(165)).setAttribute("ID","EstDat2" );
      ((Element)v.get(153)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */

      /* Empieza nodo:166 / Elemento padre: 153   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(166)).setAttribute("tipo","texto" );
      ((Element)v.get(166)).setAttribute("ID","EstDat" );
      ((Element)v.get(153)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */

      /* Empieza nodo:167 / Elemento padre: 153   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(167)).setAttribute("tipo","texto" );
      ((Element)v.get(167)).setAttribute("ID","EstDat2" );
      ((Element)v.get(153)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 153   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(168)).setAttribute("tipo","texto" );
      ((Element)v.get(168)).setAttribute("ID","EstDat" );
      ((Element)v.get(153)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 153   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(169)).setAttribute("tipo","texto" );
      ((Element)v.get(169)).setAttribute("ID","EstDat" );
      ((Element)v.get(153)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */

      /* Empieza nodo:170 / Elemento padre: 153   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(170)).setAttribute("tipo","texto" );
      ((Element)v.get(170)).setAttribute("ID","EstDat2" );
      ((Element)v.get(153)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */

      /* Empieza nodo:171 / Elemento padre: 153   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(171)).setAttribute("tipo","texto" );
      ((Element)v.get(171)).setAttribute("ID","EstDat" );
      ((Element)v.get(153)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:153   */

      /* Empieza nodo:172 / Elemento padre: 105   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(105)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */

      /* Empieza nodo:173 / Elemento padre: 105   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(173)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(173)).setAttribute("ancho","554" );
      ((Element)v.get(173)).setAttribute("sep","$" );
      ((Element)v.get(173)).setAttribute("x","12" );
      ((Element)v.get(173)).setAttribute("class","botonera" );
      ((Element)v.get(173)).setAttribute("y","456" );
      ((Element)v.get(173)).setAttribute("control","|" );
      ((Element)v.get(173)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(173)).setAttribute("rowset","" );
      ((Element)v.get(173)).setAttribute("cargainicial","N" );
      ((Element)v.get(173)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(105)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(174)).setAttribute("nombre","ret1" );
      ((Element)v.get(174)).setAttribute("x","37" );
      ((Element)v.get(174)).setAttribute("y","460" );
      ((Element)v.get(174)).setAttribute("ID","botonContenido" );
      ((Element)v.get(174)).setAttribute("img","retroceder_on" );
      ((Element)v.get(174)).setAttribute("tipo","0" );
      ((Element)v.get(174)).setAttribute("estado","false" );
      ((Element)v.get(174)).setAttribute("alt","" );
      ((Element)v.get(174)).setAttribute("codigo","" );
      ((Element)v.get(174)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 173   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(175)).setAttribute("nombre","ava1" );
      ((Element)v.get(175)).setAttribute("x","52" );
      ((Element)v.get(175)).setAttribute("y","460" );
      ((Element)v.get(175)).setAttribute("ID","botonContenido" );
      ((Element)v.get(175)).setAttribute("img","avanzar_on" );
      ((Element)v.get(175)).setAttribute("tipo","0" );
      ((Element)v.get(175)).setAttribute("estado","false" );
      ((Element)v.get(175)).setAttribute("alt","" );
      ((Element)v.get(175)).setAttribute("codigo","" );
      ((Element)v.get(175)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(173)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:173   */
      /* Termina nodo:105   */

      /* Empieza nodo:176 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(176)).setAttribute("nombre","primera1" );
      ((Element)v.get(176)).setAttribute("x","20" );
      ((Element)v.get(176)).setAttribute("y","460" );
      ((Element)v.get(176)).setAttribute("ID","botonContenido" );
      ((Element)v.get(176)).setAttribute("img","primera_on" );
      ((Element)v.get(176)).setAttribute("tipo","-2" );
      ((Element)v.get(176)).setAttribute("estado","false" );
      ((Element)v.get(176)).setAttribute("alt","" );
      ((Element)v.get(176)).setAttribute("codigo","" );
      ((Element)v.get(176)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */

      /* Empieza nodo:177 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(177)).setAttribute("nombre","separa" );
      ((Element)v.get(177)).setAttribute("x","59" );
      ((Element)v.get(177)).setAttribute("y","456" );
      ((Element)v.get(177)).setAttribute("ID","botonContenido" );
      ((Element)v.get(177)).setAttribute("img","separa_base" );
      ((Element)v.get(177)).setAttribute("tipo","0" );
      ((Element)v.get(177)).setAttribute("estado","false" );
      ((Element)v.get(177)).setAttribute("alt","" );
      ((Element)v.get(177)).setAttribute("codigo","" );
      ((Element)v.get(177)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(178)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(178)).setAttribute("alto","12" );
      ((Element)v.get(178)).setAttribute("ancho","50" );
      ((Element)v.get(178)).setAttribute("colorf","" );
      ((Element)v.get(178)).setAttribute("borde","0" );
      ((Element)v.get(178)).setAttribute("imagenf","" );
      ((Element)v.get(178)).setAttribute("repeat","" );
      ((Element)v.get(178)).setAttribute("padding","" );
      ((Element)v.get(178)).setAttribute("visibilidad","visible" );
      ((Element)v.get(178)).setAttribute("contravsb","" );
      ((Element)v.get(178)).setAttribute("x","0" );
      ((Element)v.get(178)).setAttribute("y","479" );
      ((Element)v.get(178)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:6   */


   }

}

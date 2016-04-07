
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_cupon3_consultar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_cupon3_consultar" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag()" );
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
      ((Element)v.get(3)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","ccc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(6)).setAttribute("src","contenido_cupon3_consultar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(7)).setAttribute("nombre","Formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","idioma" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","pais" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","accion" );
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
      ((Element)v.get(12)).setAttribute("nombre","casoUso" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","errSeverity" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","numDigitosCodigoCliente" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 7   */
      v.add(doc.createElement("table"));
      ((Element)v.get(17)).setAttribute("width","100%" );
      ((Element)v.get(17)).setAttribute("border","0" );
      ((Element)v.get(17)).setAttribute("cellspacing","0" );
      ((Element)v.get(17)).setAttribute("cellpadding","0" );
      ((Element)v.get(7)).appendChild((Element)v.get(17));

      /* Empieza nodo:18 / Elemento padre: 17   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(17)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(19)).setAttribute("width","12" );
      ((Element)v.get(19)).setAttribute("align","center" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));

      /* Empieza nodo:20 / Elemento padre: 19   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(20)).setAttribute("src","b.gif" );
      ((Element)v.get(20)).setAttribute("width","12" );
      ((Element)v.get(20)).setAttribute("height","12" );
      ((Element)v.get(19)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */
      /* Termina nodo:19   */

      /* Empieza nodo:21 / Elemento padre: 18   */
      v.add(doc.createElement("td"));
      ((Element)v.get(21)).setAttribute("width","750" );
      ((Element)v.get(18)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(22)).setAttribute("src","b.gif" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */
      /* Termina nodo:21   */

      /* Empieza nodo:23 / Elemento padre: 18   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(23)).setAttribute("width","12" );
      ((Element)v.get(18)).appendChild((Element)v.get(23));

      /* Empieza nodo:24 / Elemento padre: 23   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(24)).setAttribute("src","b.gif" );
      ((Element)v.get(24)).setAttribute("width","12" );
      ((Element)v.get(24)).setAttribute("height","1" );
      ((Element)v.get(23)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */
      /* Termina nodo:23   */
      /* Termina nodo:18   */

      /* Empieza nodo:25 / Elemento padre: 17   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(17)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(27)).setAttribute("src","b.gif" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */
      /* Termina nodo:26   */

      /* Empieza nodo:28 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).appendChild((Element)v.get(28));

      /* Empieza nodo:29 / Elemento padre: 28   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(28)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(30)).setAttribute("class","legend" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(31)).setAttribute("nombre","lblTitCritBusc" );
      ((Element)v.get(31)).setAttribute("alto","13" );
      ((Element)v.get(31)).setAttribute("filas","1" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(31)).setAttribute("cod","0075" );
      ((Element)v.get(31)).setAttribute("id","legend" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:30   */

      /* Empieza nodo:32 / Elemento padre: 29   */
      v.add(doc.createElement("table"));
      ((Element)v.get(32)).setAttribute("width","100%" );
      ((Element)v.get(32)).setAttribute("border","0" );
      ((Element)v.get(32)).setAttribute("align","center" );
      ((Element)v.get(32)).setAttribute("cellspacing","0" );
      ((Element)v.get(32)).setAttribute("cellpadding","0" );
      ((Element)v.get(29)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("td"));
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("table"));
      ((Element)v.get(35)).setAttribute("width","690" );
      ((Element)v.get(35)).setAttribute("border","0" );
      ((Element)v.get(35)).setAttribute("align","left" );
      ((Element)v.get(35)).setAttribute("cellspacing","0" );
      ((Element)v.get(35)).setAttribute("cellpadding","0" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("td"));
      ((Element)v.get(37)).setAttribute("colspan","4" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(38)).setAttribute("src","b.gif" );
      ((Element)v.get(38)).setAttribute("width","8" );
      ((Element)v.get(38)).setAttribute("height","8" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:39 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).setAttribute("width","8" );
      ((Element)v.get(41)).setAttribute("height","8" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(43)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(43)).setAttribute("alto","13" );
      ((Element)v.get(43)).setAttribute("filas","1" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(43)).setAttribute("id","datosTitle" );
      ((Element)v.get(43)).setAttribute("cod","6" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(45)).setAttribute("width","25" );
      ((Element)v.get(45)).setAttribute("height","8" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(47)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(47)).setAttribute("alto","13" );
      ((Element)v.get(47)).setAttribute("filas","1" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(47)).setAttribute("id","datosTitle" );
      ((Element)v.get(47)).setAttribute("cod","7" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","25" );
      ((Element)v.get(49)).setAttribute("height","8" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(39)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(51)).setAttribute("nombre","lblPeriodo" );
      ((Element)v.get(51)).setAttribute("alto","13" );
      ((Element)v.get(51)).setAttribute("filas","1" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(51)).setAttribute("id","datosTitle" );
      ((Element)v.get(51)).setAttribute("cod","447" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 39   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("width","100%" );
      ((Element)v.get(39)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","8" );
      ((Element)v.get(53)).setAttribute("height","8" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */
      /* Termina nodo:39   */

      /* Empieza nodo:54 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","8" );
      ((Element)v.get(56)).setAttribute("height","8" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(58)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(58)).setAttribute("id","datosCampos" );
      ((Element)v.get(58)).setAttribute("size","1" );
      ((Element)v.get(58)).setAttribute("multiple","N" );
      ((Element)v.get(58)).setAttribute("req","N" );
      ((Element)v.get(58)).setAttribute("onchange","cambioMarcaCanal();" );
      ((Element)v.get(58)).setAttribute("onshtab","document.all['btnBuscar'].focus();" );
      ((Element)v.get(58)).setAttribute("valorinicial","" );
      ((Element)v.get(58)).setAttribute("textoinicial","" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:60 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","25" );
      ((Element)v.get(61)).setAttribute("height","8" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(63)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(63)).setAttribute("id","datosCampos" );
      ((Element)v.get(63)).setAttribute("size","1" );
      ((Element)v.get(63)).setAttribute("multiple","N" );
      ((Element)v.get(63)).setAttribute("req","N" );
      ((Element)v.get(63)).setAttribute("onchange","cambioMarcaCanal();" );
      ((Element)v.get(63)).setAttribute("valorinicial","" );
      ((Element)v.get(63)).setAttribute("textoinicial","" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:65 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","25" );
      ((Element)v.get(66)).setAttribute("height","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(68)).setAttribute("nombre","cbPeriodo" );
      ((Element)v.get(68)).setAttribute("id","datosCampos" );
      ((Element)v.get(68)).setAttribute("size","1" );
      ((Element)v.get(68)).setAttribute("multiple","N" );
      ((Element)v.get(68)).setAttribute("req","N" );
      ((Element)v.get(68)).setAttribute("valorinicial","" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(68)).setAttribute("textoinicial","" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:70 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).setAttribute("width","100%" );
      ((Element)v.get(54)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","8" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:54   */

      /* Empieza nodo:72 / Elemento padre: 35   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(35)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).setAttribute("colspan","4" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","8" );
      ((Element)v.get(74)).setAttribute("height","8" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:35   */
      /* Termina nodo:34   */
      /* Termina nodo:33   */

      /* Empieza nodo:75 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("table"));
      ((Element)v.get(77)).setAttribute("width","690" );
      ((Element)v.get(77)).setAttribute("border","0" );
      ((Element)v.get(77)).setAttribute("align","left" );
      ((Element)v.get(77)).setAttribute("cellspacing","0" );
      ((Element)v.get(77)).setAttribute("cellpadding","0" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","8" );
      ((Element)v.get(80)).setAttribute("height","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(82)).setAttribute("nombre","lblAno" );
      ((Element)v.get(82)).setAttribute("alto","13" );
      ((Element)v.get(82)).setAttribute("filas","1" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(82)).setAttribute("id","datosTitle" );
      ((Element)v.get(82)).setAttribute("cod","171" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","25" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(86)).setAttribute("nombre","lblMes" );
      ((Element)v.get(86)).setAttribute("alto","13" );
      ((Element)v.get(86)).setAttribute("filas","1" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(86)).setAttribute("id","datosTitle" );
      ((Element)v.get(86)).setAttribute("cod","674" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","25" );
      ((Element)v.get(88)).setAttribute("height","8" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(90)).setAttribute("nombre","lblNumero" );
      ((Element)v.get(90)).setAttribute("alto","13" );
      ((Element)v.get(90)).setAttribute("filas","1" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(90)).setAttribute("id","datosTitle" );
      ((Element)v.get(90)).setAttribute("cod","226" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 78   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("width","100%" );
      ((Element)v.get(78)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","8" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:78   */

      /* Empieza nodo:93 / Elemento padre: 77   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(77)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","8" );
      ((Element)v.get(95)).setAttribute("height","8" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(97)).setAttribute("nombre","txtAno" );
      ((Element)v.get(97)).setAttribute("id","datosCampos" );
      ((Element)v.get(97)).setAttribute("max","2" );
      ((Element)v.get(97)).setAttribute("tipo","" );
      ((Element)v.get(97)).setAttribute("onchange","" );
      ((Element)v.get(97)).setAttribute("onblur","validarAnio('txtAno');" );
      ((Element)v.get(97)).setAttribute("req","N" );
      ((Element)v.get(97)).setAttribute("size","2" );
      ((Element)v.get(97)).setAttribute("valor","" );
      ((Element)v.get(97)).setAttribute("validacion","" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","25" );
      ((Element)v.get(99)).setAttribute("height","8" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(101)).setAttribute("nombre","txtMes" );
      ((Element)v.get(101)).setAttribute("id","datosCampos" );
      ((Element)v.get(101)).setAttribute("max","2" );
      ((Element)v.get(101)).setAttribute("tipo","" );
      ((Element)v.get(101)).setAttribute("onchange","" );
      ((Element)v.get(101)).setAttribute("onblur","validarMes('txtMes');" );
      ((Element)v.get(101)).setAttribute("req","N" );
      ((Element)v.get(101)).setAttribute("size","2" );
      ((Element)v.get(101)).setAttribute("valor","" );
      ((Element)v.get(101)).setAttribute("validacion","" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","25" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(105)).setAttribute("nombre","txtNumero" );
      ((Element)v.get(105)).setAttribute("id","datosCampos" );
      ((Element)v.get(105)).setAttribute("max","8" );
      ((Element)v.get(105)).setAttribute("tipo","" );
      ((Element)v.get(105)).setAttribute("onchange","" );
      ((Element)v.get(105)).setAttribute("onblur","validarNumero('txtNumero');" );
      ((Element)v.get(105)).setAttribute("req","N" );
      ((Element)v.get(105)).setAttribute("size","12" );
      ((Element)v.get(105)).setAttribute("valor","" );
      ((Element)v.get(105)).setAttribute("validacion","" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).setAttribute("width","100%" );
      ((Element)v.get(93)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","8" );
      ((Element)v.get(107)).setAttribute("height","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:93   */

      /* Empieza nodo:108 / Elemento padre: 77   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(77)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).setAttribute("colspan","4" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","8" );
      ((Element)v.get(110)).setAttribute("height","8" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:111 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("table"));
      ((Element)v.get(113)).setAttribute("width","690" );
      ((Element)v.get(113)).setAttribute("border","0" );
      ((Element)v.get(113)).setAttribute("align","left" );
      ((Element)v.get(113)).setAttribute("cellspacing","0" );
      ((Element)v.get(113)).setAttribute("cellpadding","0" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(113)).appendChild((Element)v.get(114));

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
      ((Element)v.get(117)).setAttribute("colspan","3" );
      ((Element)v.get(114)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(118)).setAttribute("nombre","lblCodCliente" );
      ((Element)v.get(118)).setAttribute("alto","13" );
      ((Element)v.get(118)).setAttribute("filas","1" );
      ((Element)v.get(118)).setAttribute("valor","" );
      ((Element)v.get(118)).setAttribute("id","datosTitle" );
      ((Element)v.get(118)).setAttribute("cod","263" );
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
      ((Element)v.get(122)).setAttribute("nombre","lblFechaDoc" );
      ((Element)v.get(122)).setAttribute("alto","13" );
      ((Element)v.get(122)).setAttribute("filas","1" );
      ((Element)v.get(122)).setAttribute("valor","" );
      ((Element)v.get(122)).setAttribute("id","datosTitle" );
      ((Element)v.get(122)).setAttribute("cod","383" );
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
      ((Element)v.get(126)).setAttribute("nombre","lblFechaMov" );
      ((Element)v.get(126)).setAttribute("alto","13" );
      ((Element)v.get(126)).setAttribute("filas","1" );
      ((Element)v.get(126)).setAttribute("valor","" );
      ((Element)v.get(126)).setAttribute("id","datosTitle" );
      ((Element)v.get(126)).setAttribute("cod","651" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 114   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).setAttribute("width","100%" );
      ((Element)v.get(114)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","8" );
      ((Element)v.get(128)).setAttribute("height","8" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:114   */

      /* Empieza nodo:129 / Elemento padre: 113   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(113)).appendChild((Element)v.get(129));

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
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(133)).setAttribute("nombre","textCodCliente" );
      ((Element)v.get(133)).setAttribute("id","datosCampos" );
      ((Element)v.get(133)).setAttribute("max","15" );
      ((Element)v.get(133)).setAttribute("tipo","" );
      ((Element)v.get(133)).setAttribute("onchange","" );
      ((Element)v.get(133)).setAttribute("onblur","textCodClienteOnBlur();" );
      ((Element)v.get(133)).setAttribute("req","N" );
      ((Element)v.get(133)).setAttribute("size","19" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(133)).setAttribute("valor","" );
      ((Element)v.get(133)).setAttribute("validacion","" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","8" );
      ((Element)v.get(135)).setAttribute("height","8" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","iconBuscar.gif" );
      ((Element)v.get(137)).setAttribute("onclick","accionBTN_BuscarCliente();" );
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
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(141)).setAttribute("nombre","textFechaDoc" );
      ((Element)v.get(141)).setAttribute("id","datosCampos" );
      ((Element)v.get(141)).setAttribute("max","10" );
      ((Element)v.get(141)).setAttribute("tipo","" );
      ((Element)v.get(141)).setAttribute("onchange","" );
      ((Element)v.get(141)).setAttribute("req","N" );
      ((Element)v.get(141)).setAttribute("size","12" );
      ((Element)v.get(141)).setAttribute("valor","" );
      ((Element)v.get(141)).setAttribute("validacion","" );
      ((Element)v.get(141)).setAttribute("onblur","comprobarFecha('textFechaDoc');" );
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
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(145)).setAttribute("nombre","textFechaMov" );
      ((Element)v.get(145)).setAttribute("id","datosCampos" );
      ((Element)v.get(145)).setAttribute("max","10" );
      ((Element)v.get(145)).setAttribute("tipo","" );
      ((Element)v.get(145)).setAttribute("onchange","" );
      ((Element)v.get(145)).setAttribute("req","N" );
      ((Element)v.get(145)).setAttribute("size","12" );
      ((Element)v.get(145)).setAttribute("valor","" );
      ((Element)v.get(145)).setAttribute("validacion","" );
      ((Element)v.get(145)).setAttribute("onblur","comprobarFecha('textFechaMov');" );
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

      /* Empieza nodo:148 / Elemento padre: 113   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(113)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).setAttribute("colspan","4" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","8" );
      ((Element)v.get(150)).setAttribute("height","8" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:151 / Elemento padre: 32   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(32)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("table"));
      ((Element)v.get(153)).setAttribute("width","690" );
      ((Element)v.get(153)).setAttribute("border","0" );
      ((Element)v.get(153)).setAttribute("align","left" );
      ((Element)v.get(153)).setAttribute("cellspacing","0" );
      ((Element)v.get(153)).setAttribute("cellpadding","0" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","8" );
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(158)).setAttribute("nombre","lblBanco" );
      ((Element)v.get(158)).setAttribute("alto","13" );
      ((Element)v.get(158)).setAttribute("filas","1" );
      ((Element)v.get(158)).setAttribute("valor","" );
      ((Element)v.get(158)).setAttribute("id","datosTitle" );
      ((Element)v.get(158)).setAttribute("cod","637" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).setAttribute("width","25" );
      ((Element)v.get(160)).setAttribute("height","8" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(162)).setAttribute("nombre","lblSituacion" );
      ((Element)v.get(162)).setAttribute("alto","13" );
      ((Element)v.get(162)).setAttribute("filas","1" );
      ((Element)v.get(162)).setAttribute("valor","" );
      ((Element)v.get(162)).setAttribute("id","datosTitle" );
      ((Element)v.get(162)).setAttribute("cod","695" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).setAttribute("width","100%" );
      ((Element)v.get(154)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","8" );
      ((Element)v.get(164)).setAttribute("height","8" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:154   */

      /* Empieza nodo:165 / Elemento padre: 153   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(153)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).setAttribute("width","8" );
      ((Element)v.get(167)).setAttribute("height","8" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:168 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(169)).setAttribute("nombre","cbBanco" );
      ((Element)v.get(169)).setAttribute("id","datosCampos" );
      ((Element)v.get(169)).setAttribute("size","1" );
      ((Element)v.get(169)).setAttribute("multiple","N" );
      ((Element)v.get(169)).setAttribute("req","N" );
      ((Element)v.get(169)).setAttribute("valorinicial","" );
      ((Element)v.get(169)).setAttribute("textoinicial","" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:171 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).setAttribute("width","25" );
      ((Element)v.get(172)).setAttribute("height","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(174)).setAttribute("nombre","cbSituacion" );
      ((Element)v.get(174)).setAttribute("id","datosCampos" );
      ((Element)v.get(174)).setAttribute("size","1" );
      ((Element)v.get(174)).setAttribute("multiple","N" );
      ((Element)v.get(174)).setAttribute("req","N" );
      ((Element)v.get(174)).setAttribute("valorinicial","" );
      ((Element)v.get(174)).setAttribute("textoinicial","" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:176 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).setAttribute("width","100%" );
      ((Element)v.get(165)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","8" );
      ((Element)v.get(177)).setAttribute("height","8" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:165   */

      /* Empieza nodo:178 / Elemento padre: 153   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(153)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).setAttribute("colspan","4" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(180)).setAttribute("src","b.gif" );
      ((Element)v.get(180)).setAttribute("width","8" );
      ((Element)v.get(180)).setAttribute("height","8" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */
      /* Termina nodo:178   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:32   */
      /* Termina nodo:29   */
      /* Termina nodo:28   */

      /* Empieza nodo:181 / Elemento padre: 25   */
      v.add(doc.createElement("td"));
      ((Element)v.get(25)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(182)).setAttribute("src","b.gif" );
      ((Element)v.get(182)).setAttribute("width","8" );
      ((Element)v.get(182)).setAttribute("height","12" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */
      /* Termina nodo:25   */

      /* Empieza nodo:183 / Elemento padre: 17   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(17)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(185)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(186)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("table"));
      ((Element)v.get(188)).setAttribute("width","100%" );
      ((Element)v.get(188)).setAttribute("border","0" );
      ((Element)v.get(188)).setAttribute("align","center" );
      ((Element)v.get(188)).setAttribute("cellspacing","0" );
      ((Element)v.get(188)).setAttribute("cellpadding","0" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(188)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).setAttribute("class","botonera" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(191)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(191)).setAttribute("ID","botonContenido" );
      ((Element)v.get(191)).setAttribute("tipo","html" );
      ((Element)v.get(191)).setAttribute("accion","accionBTN_Buscar();" );
      ((Element)v.get(191)).setAttribute("ontab","focaliza(FORMULARIO+'.cbCanal');" );
      ((Element)v.get(191)).setAttribute("estado","false" );
      ((Element)v.get(191)).setAttribute("cod","1" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */
      /* Termina nodo:189   */
      /* Termina nodo:188   */
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:192 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","8" );
      ((Element)v.get(193)).setAttribute("height","12" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:183   */

      /* Empieza nodo:194 / Elemento padre: 17   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(17)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).setAttribute("width","12" );
      ((Element)v.get(195)).setAttribute("align","center" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(196)).setAttribute("width","12" );
      ((Element)v.get(196)).setAttribute("height","24" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).setAttribute("width","750" );
      ((Element)v.get(194)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).setAttribute("width","12" );
      ((Element)v.get(194)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(200)).setAttribute("src","b.gif" );
      ((Element)v.get(200)).setAttribute("width","12" );
      ((Element)v.get(200)).setAttribute("height","24" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:194   */
      /* Termina nodo:17   */

      /* Empieza nodo:201 / Elemento padre: 7   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(201)).setAttribute("nombre","capaLista" );
      ((Element)v.get(201)).setAttribute("alto","317" );
      ((Element)v.get(201)).setAttribute("ancho","100%" );
      ((Element)v.get(201)).setAttribute("colorf","" );
      ((Element)v.get(201)).setAttribute("borde","0" );
      ((Element)v.get(201)).setAttribute("imagenf","" );
      ((Element)v.get(201)).setAttribute("repeat","" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(201)).setAttribute("padding","" );
      ((Element)v.get(201)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(201)).setAttribute("contravsb","" );
      ((Element)v.get(201)).setAttribute("x","0" );
      ((Element)v.get(201)).setAttribute("y","242" );
      ((Element)v.get(201)).setAttribute("zindex","" );
      ((Element)v.get(7)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(202)).setAttribute("nombre","listado1" );
      ((Element)v.get(202)).setAttribute("ancho","694" );
      ((Element)v.get(202)).setAttribute("alto","317" );
      ((Element)v.get(202)).setAttribute("x","12" );
      ((Element)v.get(202)).setAttribute("y","0" );
      ((Element)v.get(202)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(202)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(203)).setAttribute("precarga","S" );
      ((Element)v.get(203)).setAttribute("conROver","S" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(204)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(204)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(204)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(204)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */

      /* Empieza nodo:205 / Elemento padre: 203   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(205)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(205)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(205)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(205)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(203)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */

      /* Empieza nodo:206 / Elemento padre: 203   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(206)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(206)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(203)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:203   */

      /* Empieza nodo:207 / Elemento padre: 202   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(202)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(208)).setAttribute("borde","1" );
      ((Element)v.get(208)).setAttribute("horizDatos","1" );
      ((Element)v.get(208)).setAttribute("horizCabecera","1" );
      ((Element)v.get(208)).setAttribute("vertical","1" );
      ((Element)v.get(208)).setAttribute("horizTitulo","1" );
      ((Element)v.get(208)).setAttribute("horizBase","1" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */

      /* Empieza nodo:209 / Elemento padre: 207   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(209)).setAttribute("borde","#999999" );
      ((Element)v.get(209)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(209)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(209)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(209)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(209)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(209)).setAttribute("horizBase","#999999" );
      ((Element)v.get(207)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:207   */

      /* Empieza nodo:210 / Elemento padre: 202   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(210)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(210)).setAttribute("alto","22" );
      ((Element)v.get(210)).setAttribute("imgFondo","" );
      ((Element)v.get(210)).setAttribute("cod","00135" );
      ((Element)v.get(210)).setAttribute("ID","datosTitle" );
      ((Element)v.get(202)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */

      /* Empieza nodo:211 / Elemento padre: 202   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(211)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(211)).setAttribute("alto","22" );
      ((Element)v.get(211)).setAttribute("imgFondo","" );
      ((Element)v.get(202)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */

      /* Empieza nodo:212 / Elemento padre: 202   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(212)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(212)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(212)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(212)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(212)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(212)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(202)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(213)).setAttribute("ancho","100" );
      ((Element)v.get(213)).setAttribute("minimizable","S" );
      ((Element)v.get(213)).setAttribute("minimizada","N" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */

      /* Empieza nodo:214 / Elemento padre: 212   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(214)).setAttribute("ancho","100" );
      ((Element)v.get(214)).setAttribute("minimizable","S" );
      ((Element)v.get(214)).setAttribute("minimizada","N" );
      ((Element)v.get(212)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */

      /* Empieza nodo:215 / Elemento padre: 212   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(215)).setAttribute("ancho","100" );
      ((Element)v.get(215)).setAttribute("minimizable","S" );
      ((Element)v.get(215)).setAttribute("minimizada","N" );
      ((Element)v.get(212)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */

      /* Empieza nodo:216 / Elemento padre: 212   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(216)).setAttribute("ancho","150" );
      ((Element)v.get(216)).setAttribute("minimizable","S" );
      ((Element)v.get(216)).setAttribute("minimizada","N" );
      ((Element)v.get(212)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */

      /* Empieza nodo:217 / Elemento padre: 212   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(217)).setAttribute("ancho","150" );
      ((Element)v.get(217)).setAttribute("minimizable","S" );
      ((Element)v.get(217)).setAttribute("minimizada","N" );
      ((Element)v.get(212)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */

      /* Empieza nodo:218 / Elemento padre: 212   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(218)).setAttribute("ancho","150" );
      ((Element)v.get(218)).setAttribute("minimizable","S" );
      ((Element)v.get(218)).setAttribute("minimizada","N" );
      ((Element)v.get(212)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */

      /* Empieza nodo:219 / Elemento padre: 212   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(219)).setAttribute("ancho","150" );
      ((Element)v.get(219)).setAttribute("minimizable","S" );
      ((Element)v.get(219)).setAttribute("minimizada","N" );
      ((Element)v.get(212)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */

      /* Empieza nodo:220 / Elemento padre: 212   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(220)).setAttribute("ancho","150" );
      ((Element)v.get(220)).setAttribute("minimizable","S" );
      ((Element)v.get(220)).setAttribute("minimizada","N" );
      ((Element)v.get(212)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */

      /* Empieza nodo:221 / Elemento padre: 212   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(221)).setAttribute("ancho","150" );
      ((Element)v.get(221)).setAttribute("minimizable","S" );
      ((Element)v.get(221)).setAttribute("minimizada","N" );
      ((Element)v.get(212)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */

      /* Empieza nodo:222 / Elemento padre: 212   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(222)).setAttribute("ancho","150" );
      ((Element)v.get(222)).setAttribute("minimizable","S" );
      ((Element)v.get(222)).setAttribute("minimizada","N" );
      ((Element)v.get(212)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:212   */

      /* Empieza nodo:223 / Elemento padre: 202   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(223)).setAttribute("alto","20" );
      ((Element)v.get(223)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(223)).setAttribute("imgFondo","" );
      ((Element)v.get(223)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(202)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(224)).setAttribute("colFondo","" );
      ((Element)v.get(224)).setAttribute("ID","EstCab" );
      ((Element)v.get(224)).setAttribute("align","center" );
      ((Element)v.get(224)).setAttribute("cod","171" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */

      /* Empieza nodo:225 / Elemento padre: 223   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(225)).setAttribute("colFondo","" );
      ((Element)v.get(225)).setAttribute("ID","EstCab" );
      ((Element)v.get(225)).setAttribute("align","center" );
      ((Element)v.get(225)).setAttribute("cod","674" );
      ((Element)v.get(223)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */

      /* Empieza nodo:226 / Elemento padre: 223   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(226)).setAttribute("colFondo","" );
      ((Element)v.get(226)).setAttribute("ID","EstCab" );
      ((Element)v.get(226)).setAttribute("align","center" );
      ((Element)v.get(226)).setAttribute("cod","226" );
      ((Element)v.get(223)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */

      /* Empieza nodo:227 / Elemento padre: 223   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(227)).setAttribute("colFondo","" );
      ((Element)v.get(227)).setAttribute("ID","EstCab" );
      ((Element)v.get(227)).setAttribute("align","center" );
      ((Element)v.get(227)).setAttribute("cod","276" );
      ((Element)v.get(223)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */

      /* Empieza nodo:228 / Elemento padre: 223   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(228)).setAttribute("colFondo","" );
      ((Element)v.get(228)).setAttribute("ID","EstCab" );
      ((Element)v.get(228)).setAttribute("align","center" );
      ((Element)v.get(228)).setAttribute("cod","263" );
      ((Element)v.get(223)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */

      /* Empieza nodo:229 / Elemento padre: 223   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(229)).setAttribute("colFondo","" );
      ((Element)v.get(229)).setAttribute("ID","EstCab" );
      ((Element)v.get(229)).setAttribute("align","center" );
      ((Element)v.get(229)).setAttribute("cod","647" );
      ((Element)v.get(223)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */

      /* Empieza nodo:230 / Elemento padre: 223   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(230)).setAttribute("colFondo","" );
      ((Element)v.get(230)).setAttribute("ID","EstCab" );
      ((Element)v.get(230)).setAttribute("align","center" );
      ((Element)v.get(230)).setAttribute("cod","383" );
      ((Element)v.get(223)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */

      /* Empieza nodo:231 / Elemento padre: 223   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(231)).setAttribute("colFondo","" );
      ((Element)v.get(231)).setAttribute("ID","EstCab" );
      ((Element)v.get(231)).setAttribute("align","center" );
      ((Element)v.get(231)).setAttribute("cod","637" );
      ((Element)v.get(223)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */

      /* Empieza nodo:232 / Elemento padre: 223   */
      v.add(doc.createElement("COL"));
   }

   private void getXML990(Document doc) {
      ((Element)v.get(232)).setAttribute("colFondo","" );
      ((Element)v.get(232)).setAttribute("ID","EstCab" );
      ((Element)v.get(232)).setAttribute("align","center" );
      ((Element)v.get(232)).setAttribute("cod","401" );
      ((Element)v.get(223)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */

      /* Empieza nodo:233 / Elemento padre: 223   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(233)).setAttribute("colFondo","" );
      ((Element)v.get(233)).setAttribute("ID","EstCab" );
      ((Element)v.get(233)).setAttribute("align","center" );
      ((Element)v.get(233)).setAttribute("cod","573" );
      ((Element)v.get(223)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:223   */

      /* Empieza nodo:234 / Elemento padre: 202   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(234)).setAttribute("alto","22" );
      ((Element)v.get(234)).setAttribute("accion","" );
      ((Element)v.get(234)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(234)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(234)).setAttribute("maxSel","-1" );
      ((Element)v.get(234)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(234)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(234)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(234)).setAttribute("onLoad","" );
      ((Element)v.get(234)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(202)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(235)).setAttribute("tipo","texto" );
      ((Element)v.get(235)).setAttribute("ID","EstDat" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */

      /* Empieza nodo:236 / Elemento padre: 234   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(236)).setAttribute("tipo","texto" );
      ((Element)v.get(236)).setAttribute("ID","EstDat2" );
      ((Element)v.get(234)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */

      /* Empieza nodo:237 / Elemento padre: 234   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(237)).setAttribute("tipo","texto" );
      ((Element)v.get(237)).setAttribute("ID","EstDat" );
      ((Element)v.get(234)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */

      /* Empieza nodo:238 / Elemento padre: 234   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(238)).setAttribute("tipo","texto" );
      ((Element)v.get(238)).setAttribute("ID","EstDat2" );
      ((Element)v.get(234)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */

      /* Empieza nodo:239 / Elemento padre: 234   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(239)).setAttribute("tipo","texto" );
      ((Element)v.get(239)).setAttribute("ID","EstDat" );
      ((Element)v.get(234)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */

      /* Empieza nodo:240 / Elemento padre: 234   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(240)).setAttribute("tipo","texto" );
      ((Element)v.get(240)).setAttribute("ID","EstDat2" );
      ((Element)v.get(234)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */

      /* Empieza nodo:241 / Elemento padre: 234   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(241)).setAttribute("tipo","texto" );
      ((Element)v.get(241)).setAttribute("ID","EstDat" );
      ((Element)v.get(234)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */

      /* Empieza nodo:242 / Elemento padre: 234   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(242)).setAttribute("tipo","texto" );
      ((Element)v.get(242)).setAttribute("ID","EstDat2" );
      ((Element)v.get(234)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */

      /* Empieza nodo:243 / Elemento padre: 234   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(243)).setAttribute("tipo","texto" );
      ((Element)v.get(243)).setAttribute("ID","EstDat" );
      ((Element)v.get(234)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */

      /* Empieza nodo:244 / Elemento padre: 234   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(244)).setAttribute("tipo","texto" );
      ((Element)v.get(244)).setAttribute("ID","EstDat2" );
      ((Element)v.get(234)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:234   */

      /* Empieza nodo:245 / Elemento padre: 202   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(202)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */

      /* Empieza nodo:246 / Elemento padre: 202   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(246)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(246)).setAttribute("ancho","694" );
      ((Element)v.get(246)).setAttribute("sep","$" );
      ((Element)v.get(246)).setAttribute("x","12" );
      ((Element)v.get(246)).setAttribute("class","botonera" );
      ((Element)v.get(246)).setAttribute("y","294" );
      ((Element)v.get(246)).setAttribute("control","|" );
      ((Element)v.get(246)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(246)).setAttribute("rowset","" );
      ((Element)v.get(246)).setAttribute("cargainicial","N" );
      ((Element)v.get(246)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)');" );
      ((Element)v.get(202)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(247)).setAttribute("nombre","ret1" );
      ((Element)v.get(247)).setAttribute("x","37" );
      ((Element)v.get(247)).setAttribute("y","298" );
      ((Element)v.get(247)).setAttribute("ID","botonContenido" );
      ((Element)v.get(247)).setAttribute("img","retroceder_on" );
      ((Element)v.get(247)).setAttribute("tipo","0" );
      ((Element)v.get(247)).setAttribute("estado","false" );
      ((Element)v.get(247)).setAttribute("alt","" );
      ((Element)v.get(247)).setAttribute("codigo","" );
      ((Element)v.get(247)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */

      /* Empieza nodo:248 / Elemento padre: 246   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(248)).setAttribute("nombre","ava1" );
      ((Element)v.get(248)).setAttribute("x","52" );
      ((Element)v.get(248)).setAttribute("y","298" );
      ((Element)v.get(248)).setAttribute("ID","botonContenido" );
      ((Element)v.get(248)).setAttribute("img","avanzar_on" );
      ((Element)v.get(248)).setAttribute("tipo","0" );
      ((Element)v.get(248)).setAttribute("estado","false" );
      ((Element)v.get(248)).setAttribute("alt","" );
      ((Element)v.get(248)).setAttribute("codigo","" );
      ((Element)v.get(248)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(246)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:246   */
      /* Termina nodo:202   */

      /* Empieza nodo:249 / Elemento padre: 201   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(249)).setAttribute("nombre","primera1" );
      ((Element)v.get(249)).setAttribute("x","20" );
      ((Element)v.get(249)).setAttribute("y","298" );
      ((Element)v.get(249)).setAttribute("ID","botonContenido" );
      ((Element)v.get(249)).setAttribute("img","primera_on" );
      ((Element)v.get(249)).setAttribute("tipo","-2" );
      ((Element)v.get(249)).setAttribute("estado","false" );
      ((Element)v.get(249)).setAttribute("alt","" );
      ((Element)v.get(249)).setAttribute("codigo","" );
      ((Element)v.get(249)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(201)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */

      /* Empieza nodo:250 / Elemento padre: 201   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(250)).setAttribute("nombre","separa" );
      ((Element)v.get(250)).setAttribute("x","59" );
      ((Element)v.get(250)).setAttribute("y","294" );
      ((Element)v.get(250)).setAttribute("ID","botonContenido" );
      ((Element)v.get(250)).setAttribute("img","separa_base" );
      ((Element)v.get(250)).setAttribute("tipo","0" );
      ((Element)v.get(250)).setAttribute("estado","false" );
      ((Element)v.get(250)).setAttribute("alt","" );
      ((Element)v.get(250)).setAttribute("codigo","" );
      ((Element)v.get(250)).setAttribute("accion","" );
      ((Element)v.get(201)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */

      /* Empieza nodo:251 / Elemento padre: 201   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(251)).setAttribute("nombre","Consultar" );
      ((Element)v.get(251)).setAttribute("x","80" );
      ((Element)v.get(251)).setAttribute("y","295" );
      ((Element)v.get(251)).setAttribute("ID","botonContenido" );
      ((Element)v.get(251)).setAttribute("img","" );
      ((Element)v.get(251)).setAttribute("tipo","html" );
      ((Element)v.get(251)).setAttribute("estado","true" );
      ((Element)v.get(251)).setAttribute("alt","" );
      ((Element)v.get(251)).setAttribute("cod","2773" );
      ((Element)v.get(251)).setAttribute("accion","" );
      ((Element)v.get(201)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:201   */

      /* Empieza nodo:252 / Elemento padre: 7   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(252)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(252)).setAttribute("alto","12" );
      ((Element)v.get(252)).setAttribute("ancho","100%" );
      ((Element)v.get(252)).setAttribute("colorf","" );
      ((Element)v.get(252)).setAttribute("borde","0" );
      ((Element)v.get(252)).setAttribute("imagenf","" );
      ((Element)v.get(252)).setAttribute("repeat","" );
      ((Element)v.get(252)).setAttribute("padding","" );
      ((Element)v.get(252)).setAttribute("visibilidad","visible" );
      ((Element)v.get(252)).setAttribute("contravsb","" );
      ((Element)v.get(252)).setAttribute("x","0" );
      ((Element)v.get(252)).setAttribute("y","559" );
      ((Element)v.get(252)).setAttribute("zindex","" );
      ((Element)v.get(7)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:7   */


   }

}

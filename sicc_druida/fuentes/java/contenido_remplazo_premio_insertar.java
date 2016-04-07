
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_remplazo_premio_insertar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_remplazo_premio_insertar" );
      ((Element)v.get(0)).setAttribute("cod","" );
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
      ((Element)v.get(2)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","ccc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(6)).setAttribute("src","contenido_remplazo_premio_insertar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbConcurso" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","1662" );
      ((Element)v.get(8)).setAttribute("req","S" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */
      /* Termina nodo:7   */

      /* Empieza nodo:9 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(9)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","idioma" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","pais" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","accion" );
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
      ((Element)v.get(14)).setAttribute("nombre","opcionMenu" );
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
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","errSeverity" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","nroPremio" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","codigo" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","descripcionProducto" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","ChkIndCenServG" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","oidCenServGar" );
      ((Element)v.get(22)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(9)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","CenServGar" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","NumMeses" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","areaObservaciones" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","PrecioPublico4" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","ArticuloDespacha4" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","rdTipoEntrega" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","oidCenServEntrega" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","CenServEntrega" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","ChkComunicacion" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","rbAlcanceGeografico" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","oidRegion" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","Region" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","oidZona" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","Zona" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","rbAlcanceGeografico2" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","ejecutar" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","ejecutarError" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","oidReemplazoArticuloLote" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","oidProducto" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","codigoProductoReemplazo" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","codVentaFicticio" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","undidades" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(45)).setAttribute("nombre","oidCriterioReemplazo" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","criterioReemplazo" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","valorCriterio" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","nroOrden" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","oidArticuloLote" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","indicadorActivo" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","valoresLista1" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","valoresLista2" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 9   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","posicionesEliminadas" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(9)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 9   */
      v.add(doc.createElement("table"));
      ((Element)v.get(54)).setAttribute("width","100%" );
      ((Element)v.get(54)).setAttribute("border","0" );
      ((Element)v.get(54)).setAttribute("cellspacing","0" );
      ((Element)v.get(54)).setAttribute("cellpadding","0" );
      ((Element)v.get(9)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).setAttribute("width","12" );
      ((Element)v.get(56)).setAttribute("align","center" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","12" );
      ((Element)v.get(57)).setAttribute("height","12" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:58 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("width","750" );
      ((Element)v.get(55)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).setAttribute("width","12" );
      ((Element)v.get(55)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","12" );
      ((Element)v.get(61)).setAttribute("height","1" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:55   */

      /* Empieza nodo:62 / Elemento padre: 54   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(54)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(67)).setAttribute("class","legend" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(68)).setAttribute("nombre","lblCriteriosBusqueda" );
      ((Element)v.get(68)).setAttribute("alto","13" );
      ((Element)v.get(68)).setAttribute("filas","1" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(68)).setAttribute("id","legend" );
      ((Element)v.get(68)).setAttribute("cod","0075" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 66   */
      v.add(doc.createElement("table"));
      ((Element)v.get(69)).setAttribute("width","100%" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(69)).setAttribute("border","0" );
      ((Element)v.get(69)).setAttribute("align","center" );
      ((Element)v.get(69)).setAttribute("cellspacing","0" );
      ((Element)v.get(69)).setAttribute("cellpadding","0" );
      ((Element)v.get(66)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("table"));
      ((Element)v.get(72)).setAttribute("width","693" );
      ((Element)v.get(72)).setAttribute("border","0" );
      ((Element)v.get(72)).setAttribute("align","left" );
      ((Element)v.get(72)).setAttribute("cellspacing","0" );
      ((Element)v.get(72)).setAttribute("cellpadding","0" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).setAttribute("colspan","4" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","8" );
      ((Element)v.get(75)).setAttribute("height","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:76 / Elemento padre: 72   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(72)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","8" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(80)).setAttribute("nombre","lblConcurso" );
      ((Element)v.get(80)).setAttribute("alto","13" );
      ((Element)v.get(80)).setAttribute("filas","1" );
      ((Element)v.get(80)).setAttribute("id","datosTitle" );
      ((Element)v.get(80)).setAttribute("cod","1662" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).setAttribute("width","100%" );
      ((Element)v.get(76)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","8" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:76   */

      /* Empieza nodo:83 / Elemento padre: 72   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(72)).appendChild((Element)v.get(83));

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
      ((Element)v.get(86)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(83)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(87)).setAttribute("nombre","cbConcurso" );
      ((Element)v.get(87)).setAttribute("id","datosCampos" );
      ((Element)v.get(87)).setAttribute("size","1" );
      ((Element)v.get(87)).setAttribute("multiple","N" );
      ((Element)v.get(87)).setAttribute("req","S" );
      ((Element)v.get(87)).setAttribute("valorinicial","" );
      ((Element)v.get(87)).setAttribute("textoinicial","" );
      ((Element)v.get(87)).setAttribute("onshtab","onShTabCbConcurso();" );
      ((Element)v.get(87)).setAttribute("ontab","onTabCbConcurso();" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:89 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("width","100%" );
      ((Element)v.get(83)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","8" );
      ((Element)v.get(90)).setAttribute("height","8" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:83   */

      /* Empieza nodo:91 / Elemento padre: 72   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(72)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).setAttribute("colspan","4" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","8" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:94 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:62   */

      /* Empieza nodo:96 / Elemento padre: 54   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(54)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("table"));
      ((Element)v.get(101)).setAttribute("width","100%" );
      ((Element)v.get(101)).setAttribute("border","0" );
      ((Element)v.get(101)).setAttribute("align","center" );
      ((Element)v.get(101)).setAttribute("cellspacing","0" );
      ((Element)v.get(101)).setAttribute("cellpadding","0" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("class","botonera" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(104)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(104)).setAttribute("ID","botonContenido" );
      ((Element)v.get(104)).setAttribute("tipo","html" );
      ((Element)v.get(104)).setAttribute("accion","accionBTNBuscar();" );
      ((Element)v.get(104)).setAttribute("estado","false" );
      ((Element)v.get(104)).setAttribute("cod","1" );
      ((Element)v.get(104)).setAttribute("ontab","onTabBtnBuscar();" );
      ((Element)v.get(104)).setAttribute("onshtab","onShTabBtnBuscar();" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:105 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","8" );
      ((Element)v.get(106)).setAttribute("height","12" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:96   */

      /* Empieza nodo:107 / Elemento padre: 54   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(54)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("width","12" );
      ((Element)v.get(108)).setAttribute("align","center" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","12" );
      ((Element)v.get(109)).setAttribute("height","12" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).setAttribute("width","756" );
      ((Element)v.get(107)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).setAttribute("width","12" );
      ((Element)v.get(107)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).setAttribute("width","12" );
      ((Element)v.get(113)).setAttribute("height","1" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:107   */
      /* Termina nodo:54   */

      /* Empieza nodo:114 / Elemento padre: 9   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(114)).setAttribute("nombre","listado1" );
      ((Element)v.get(114)).setAttribute("ancho","727" );
      ((Element)v.get(114)).setAttribute("alto","317" );
      ((Element)v.get(114)).setAttribute("x","12" );
      ((Element)v.get(114)).setAttribute("y","120" );
      ((Element)v.get(114)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(114)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(9)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(115)).setAttribute("precarga","S" );
      ((Element)v.get(115)).setAttribute("conROver","S" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(116)).setAttribute("normal","btnLista2N.gif" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(116)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(116)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(116)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */

      /* Empieza nodo:117 / Elemento padre: 115   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(117)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(117)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(117)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(117)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(115)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 115   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(118)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(118)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(115)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:115   */

      /* Empieza nodo:119 / Elemento padre: 114   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(114)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(120)).setAttribute("borde","1" );
      ((Element)v.get(120)).setAttribute("horizDatos","1" );
      ((Element)v.get(120)).setAttribute("horizCabecera","1" );
      ((Element)v.get(120)).setAttribute("vertical","0" );
      ((Element)v.get(120)).setAttribute("horizTitulo","1" );
      ((Element)v.get(120)).setAttribute("horizBase","1" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 119   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(121)).setAttribute("borde","#999999" );
      ((Element)v.get(121)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(121)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(121)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(121)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(121)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(121)).setAttribute("horizBase","#999999" );
      ((Element)v.get(119)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:119   */

      /* Empieza nodo:122 / Elemento padre: 114   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(122)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(122)).setAttribute("alto","22" );
      ((Element)v.get(122)).setAttribute("imgFondo","" );
      ((Element)v.get(122)).setAttribute("cod","3406" );
      ((Element)v.get(122)).setAttribute("ID","datosTitle" );
      ((Element)v.get(114)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 114   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(123)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(123)).setAttribute("alto","22" );
      ((Element)v.get(123)).setAttribute("imgFondo","" );
      ((Element)v.get(114)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */

      /* Empieza nodo:124 / Elemento padre: 114   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(124)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(124)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(124)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(124)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(124)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(124)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(114)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(125)).setAttribute("ancho","120" );
      ((Element)v.get(125)).setAttribute("minimizable","S" );
      ((Element)v.get(125)).setAttribute("minimizada","N" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */

      /* Empieza nodo:126 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(126)).setAttribute("ancho","100" );
      ((Element)v.get(126)).setAttribute("minimizable","S" );
      ((Element)v.get(126)).setAttribute("minimizada","N" );
      ((Element)v.get(124)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */

      /* Empieza nodo:127 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(127)).setAttribute("ancho","120" );
      ((Element)v.get(127)).setAttribute("minimizable","S" );
      ((Element)v.get(127)).setAttribute("minimizada","N" );
      ((Element)v.get(124)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */

      /* Empieza nodo:128 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(128)).setAttribute("ancho","120" );
      ((Element)v.get(128)).setAttribute("minimizable","S" );
      ((Element)v.get(128)).setAttribute("minimizada","N" );
      ((Element)v.get(124)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */

      /* Empieza nodo:129 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(129)).setAttribute("ancho","100" );
      ((Element)v.get(129)).setAttribute("minimizable","S" );
      ((Element)v.get(129)).setAttribute("minimizada","N" );
      ((Element)v.get(124)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */

      /* Empieza nodo:130 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(130)).setAttribute("ancho","120" );
      ((Element)v.get(130)).setAttribute("minimizable","S" );
      ((Element)v.get(130)).setAttribute("minimizada","N" );
      ((Element)v.get(130)).setAttribute("oculta","S" );
      ((Element)v.get(124)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */

      /* Empieza nodo:131 / Elemento padre: 124   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(131)).setAttribute("ancho","120" );
      ((Element)v.get(131)).setAttribute("minimizable","S" );
      ((Element)v.get(131)).setAttribute("minimizada","N" );
      ((Element)v.get(124)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:124   */

      /* Empieza nodo:132 / Elemento padre: 114   */
      v.add(doc.createElement("CABECERA"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(132)).setAttribute("alto","20" );
      ((Element)v.get(132)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(132)).setAttribute("imgFondo","" );
      ((Element)v.get(132)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(114)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(133)).setAttribute("colFondo","" );
      ((Element)v.get(133)).setAttribute("ID","EstCab" );
      ((Element)v.get(133)).setAttribute("cod","ZonEstruGeopo.dipoOidDiviPoli.label" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Elemento padre:133 / Elemento actual: 134   */
      v.add(doc.createTextNode("Nivel"));
      ((Element)v.get(133)).appendChild((Text)v.get(134));

      /* Termina nodo Texto:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(135)).setAttribute("colFondo","" );
      ((Element)v.get(135)).setAttribute("ID","EstCab" );
      ((Element)v.get(135)).setAttribute("cod","3407" );
      ((Element)v.get(132)).appendChild((Element)v.get(135));

      /* Elemento padre:135 / Elemento actual: 136   */
      v.add(doc.createTextNode("Nro. Premio"));
      ((Element)v.get(135)).appendChild((Text)v.get(136));

      /* Termina nodo Texto:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(137)).setAttribute("colFondo","" );
      ((Element)v.get(137)).setAttribute("ID","EstCab" );
      ((Element)v.get(137)).setAttribute("cod","ApeCajasCheq.prod.label" );
      ((Element)v.get(132)).appendChild((Element)v.get(137));

      /* Elemento padre:137 / Elemento actual: 138   */
      v.add(doc.createTextNode("Producto"));
      ((Element)v.get(137)).appendChild((Text)v.get(138));

      /* Termina nodo Texto:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(139)).setAttribute("colFondo","" );
      ((Element)v.get(139)).setAttribute("ID","EstCab" );
      ((Element)v.get(139)).setAttribute("cod","CarNivelRedon.Descripcion.label" );
      ((Element)v.get(132)).appendChild((Element)v.get(139));

      /* Elemento padre:139 / Elemento actual: 140   */
      v.add(doc.createTextNode("Descripcion"));
      ((Element)v.get(139)).appendChild((Text)v.get(140));

      /* Termina nodo Texto:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(141)).setAttribute("colFondo","" );
      ((Element)v.get(141)).setAttribute("ID","EstCab" );
      ((Element)v.get(141)).setAttribute("cod","ApeCargaEvaluar.unidadesPromedio.label" );
      ((Element)v.get(132)).appendChild((Element)v.get(141));

      /* Elemento padre:141 / Elemento actual: 142   */
      v.add(doc.createTextNode("unidades"));
      ((Element)v.get(141)).appendChild((Text)v.get(142));

      /* Termina nodo Texto:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(143)).setAttribute("colFondo","" );
      ((Element)v.get(143)).setAttribute("ID","EstCab" );
      ((Element)v.get(143)).setAttribute("cod","ApeCargaEvaluar.unidadesPromedio.label" );
      ((Element)v.get(132)).appendChild((Element)v.get(143));

      /* Elemento padre:143 / Elemento actual: 144   */
      v.add(doc.createTextNode("oid"));
      ((Element)v.get(143)).appendChild((Text)v.get(144));

      /* Termina nodo Texto:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 132   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(145)).setAttribute("colFondo","" );
      ((Element)v.get(145)).setAttribute("ID","EstCab" );
      ((Element)v.get(145)).setAttribute("cod","3413" );
      ((Element)v.get(132)).appendChild((Element)v.get(145));

      /* Elemento padre:145 / Elemento actual: 146   */
      v.add(doc.createTextNode("Cod. Venta ficticio"));
      ((Element)v.get(145)).appendChild((Text)v.get(146));

      /* Termina nodo Texto:146   */
      /* Termina nodo:145   */
      /* Termina nodo:132   */

      /* Empieza nodo:147 / Elemento padre: 114   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(147)).setAttribute("alto","22" );
      ((Element)v.get(147)).setAttribute("accion","" );
      ((Element)v.get(147)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(147)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(147)).setAttribute("maxSel","-1" );
      ((Element)v.get(147)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(147)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(147)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(147)).setAttribute("onLoad","" );
      ((Element)v.get(147)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(114)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(148)).setAttribute("tipo","texto" );
      ((Element)v.get(148)).setAttribute("ID","EstDat" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */

      /* Empieza nodo:149 / Elemento padre: 147   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(149)).setAttribute("tipo","texto" );
      ((Element)v.get(149)).setAttribute("ID","EstDat2" );
      ((Element)v.get(147)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */

      /* Empieza nodo:150 / Elemento padre: 147   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(150)).setAttribute("tipo","texto" );
      ((Element)v.get(150)).setAttribute("ID","EstDat" );
      ((Element)v.get(147)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */

      /* Empieza nodo:151 / Elemento padre: 147   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(151)).setAttribute("tipo","texto" );
      ((Element)v.get(151)).setAttribute("ID","EstDat2" );
      ((Element)v.get(147)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */

      /* Empieza nodo:152 / Elemento padre: 147   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(152)).setAttribute("tipo","texto" );
      ((Element)v.get(152)).setAttribute("ID","EstDat" );
      ((Element)v.get(147)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */

      /* Empieza nodo:153 / Elemento padre: 147   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(153)).setAttribute("tipo","texto" );
      ((Element)v.get(153)).setAttribute("ID","EstDat2" );
      ((Element)v.get(147)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */

      /* Empieza nodo:154 / Elemento padre: 147   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(154)).setAttribute("tipo","texto" );
      ((Element)v.get(154)).setAttribute("ID","EstDat2" );
      ((Element)v.get(147)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:147   */

      /* Empieza nodo:155 / Elemento padre: 114   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(114)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */

      /* Empieza nodo:156 / Elemento padre: 114   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(156)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(156)).setAttribute("ancho","697" );
      ((Element)v.get(156)).setAttribute("sep","$" );
      ((Element)v.get(156)).setAttribute("x","12" );
      ((Element)v.get(156)).setAttribute("class","botonera" );
      ((Element)v.get(156)).setAttribute("y","294" );
      ((Element)v.get(156)).setAttribute("control","|" );
      ((Element)v.get(156)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(156)).setAttribute("rowset","" );
      ((Element)v.get(156)).setAttribute("cargainicial","N" );
      ((Element)v.get(156)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset, error)')" );
      ((Element)v.get(114)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(157)).setAttribute("nombre","ret1" );
      ((Element)v.get(157)).setAttribute("x","37" );
      ((Element)v.get(157)).setAttribute("y","298" );
      ((Element)v.get(157)).setAttribute("ID","botonContenido" );
      ((Element)v.get(157)).setAttribute("img","retroceder_on" );
      ((Element)v.get(157)).setAttribute("tipo","0" );
      ((Element)v.get(157)).setAttribute("estado","false" );
      ((Element)v.get(157)).setAttribute("alt","" );
      ((Element)v.get(157)).setAttribute("codigo","" );
      ((Element)v.get(157)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */

      /* Empieza nodo:158 / Elemento padre: 156   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(158)).setAttribute("nombre","ava1" );
      ((Element)v.get(158)).setAttribute("x","52" );
      ((Element)v.get(158)).setAttribute("y","298" );
      ((Element)v.get(158)).setAttribute("ID","botonContenido" );
      ((Element)v.get(158)).setAttribute("img","avanzar_on" );
      ((Element)v.get(158)).setAttribute("tipo","0" );
      ((Element)v.get(158)).setAttribute("estado","false" );
      ((Element)v.get(158)).setAttribute("alt","" );
      ((Element)v.get(158)).setAttribute("codigo","" );
      ((Element)v.get(158)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(156)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:156   */
      /* Termina nodo:114   */

      /* Empieza nodo:159 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(159)).setAttribute("nombre","btnDefinirRemplazo" );
      ((Element)v.get(159)).setAttribute("x","10" );
      ((Element)v.get(159)).setAttribute("y","415" );
      ((Element)v.get(159)).setAttribute("ID","botonContenido" );
      ((Element)v.get(159)).setAttribute("tipo","html" );
      ((Element)v.get(159)).setAttribute("estado","false" );
      ((Element)v.get(159)).setAttribute("cod","3408" );
      ((Element)v.get(159)).setAttribute("ontab","onTabBtnDefinirRemplazo();" );
      ((Element)v.get(159)).setAttribute("onshtab","onShTabBtnDefinirRemplazo();" );
      ((Element)v.get(159)).setAttribute("accion","accionBTN_DefinirRemplazo();" );
      ((Element)v.get(9)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */

      /* Empieza nodo:160 / Elemento padre: 9   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(160)).setAttribute("nombre","listado2" );
      ((Element)v.get(160)).setAttribute("ancho","727" );
      ((Element)v.get(160)).setAttribute("alto","317" );
      ((Element)v.get(160)).setAttribute("x","12" );
      ((Element)v.get(160)).setAttribute("y","460" );
      ((Element)v.get(160)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(160)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(9)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(161)).setAttribute("precarga","S" );
      ((Element)v.get(161)).setAttribute("conROver","S" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(162)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(162)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(162)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(162)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */

      /* Empieza nodo:163 / Elemento padre: 161   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(163)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(163)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(163)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(163)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(161)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */

      /* Empieza nodo:164 / Elemento padre: 161   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(164)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(164)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(161)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:161   */

      /* Empieza nodo:165 / Elemento padre: 160   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(160)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(166)).setAttribute("borde","1" );
      ((Element)v.get(166)).setAttribute("horizDatos","1" );
      ((Element)v.get(166)).setAttribute("horizCabecera","1" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(166)).setAttribute("vertical","0" );
      ((Element)v.get(166)).setAttribute("horizTitulo","1" );
      ((Element)v.get(166)).setAttribute("horizBase","1" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */

      /* Empieza nodo:167 / Elemento padre: 165   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(167)).setAttribute("borde","#999999" );
      ((Element)v.get(167)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(167)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(167)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(167)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(167)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(167)).setAttribute("horizBase","#999999" );
      ((Element)v.get(165)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:165   */

      /* Empieza nodo:168 / Elemento padre: 160   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(168)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(168)).setAttribute("alto","22" );
      ((Element)v.get(168)).setAttribute("imgFondo","" );
      ((Element)v.get(168)).setAttribute("cod","3409" );
      ((Element)v.get(168)).setAttribute("ID","datosTitle" );
      ((Element)v.get(160)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */

      /* Empieza nodo:169 / Elemento padre: 160   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(169)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(169)).setAttribute("alto","22" );
      ((Element)v.get(169)).setAttribute("imgFondo","" );
      ((Element)v.get(160)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */

      /* Empieza nodo:170 / Elemento padre: 160   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(170)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(170)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(170)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(170)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(170)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(170)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(160)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(171)).setAttribute("ancho","120" );
      ((Element)v.get(171)).setAttribute("minimizable","S" );
      ((Element)v.get(171)).setAttribute("minimizada","N" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */

      /* Empieza nodo:172 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(172)).setAttribute("ancho","100" );
      ((Element)v.get(172)).setAttribute("minimizable","S" );
      ((Element)v.get(172)).setAttribute("minimizada","N" );
      ((Element)v.get(172)).setAttribute("oculta","S" );
      ((Element)v.get(170)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */

      /* Empieza nodo:173 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(173)).setAttribute("ancho","120" );
      ((Element)v.get(173)).setAttribute("minimizable","S" );
      ((Element)v.get(173)).setAttribute("minimizada","N" );
      ((Element)v.get(170)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */

      /* Empieza nodo:174 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(174)).setAttribute("ancho","120" );
      ((Element)v.get(174)).setAttribute("minimizable","S" );
      ((Element)v.get(174)).setAttribute("minimizada","N" );
      ((Element)v.get(170)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(175)).setAttribute("ancho","120" );
      ((Element)v.get(175)).setAttribute("minimizable","S" );
      ((Element)v.get(175)).setAttribute("minimizada","N" );
      ((Element)v.get(170)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */

      /* Empieza nodo:176 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(176)).setAttribute("ancho","120" );
      ((Element)v.get(176)).setAttribute("minimizable","S" );
      ((Element)v.get(176)).setAttribute("minimizada","N" );
      ((Element)v.get(170)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */

      /* Empieza nodo:177 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(177)).setAttribute("ancho","120" );
      ((Element)v.get(177)).setAttribute("minimizable","S" );
      ((Element)v.get(177)).setAttribute("minimizada","N" );
      ((Element)v.get(177)).setAttribute("oculta","S" );
      ((Element)v.get(170)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(178)).setAttribute("ancho","120" );
      ((Element)v.get(178)).setAttribute("minimizable","S" );
      ((Element)v.get(178)).setAttribute("minimizada","N" );
      ((Element)v.get(170)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */

      /* Empieza nodo:179 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(179)).setAttribute("ancho","120" );
      ((Element)v.get(179)).setAttribute("minimizable","S" );
      ((Element)v.get(179)).setAttribute("minimizada","N" );
      ((Element)v.get(170)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */

      /* Empieza nodo:180 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(180)).setAttribute("ancho","120" );
      ((Element)v.get(180)).setAttribute("minimizable","S" );
      ((Element)v.get(180)).setAttribute("minimizada","N" );
      ((Element)v.get(170)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(181)).setAttribute("ancho","120" );
      ((Element)v.get(181)).setAttribute("minimizable","S" );
      ((Element)v.get(181)).setAttribute("minimizada","N" );
      ((Element)v.get(170)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */

      /* Empieza nodo:182 / Elemento padre: 170   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(182)).setAttribute("ancho","120" );
      ((Element)v.get(182)).setAttribute("minimizable","S" );
      ((Element)v.get(182)).setAttribute("minimizada","N" );
      ((Element)v.get(182)).setAttribute("oculta","S" );
      ((Element)v.get(170)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(183)).setAttribute("ancho","120" );
      ((Element)v.get(183)).setAttribute("minimizable","S" );
      ((Element)v.get(183)).setAttribute("minimizada","N" );
      ((Element)v.get(183)).setAttribute("oculta","S" );
      ((Element)v.get(170)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */

      /* Empieza nodo:184 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(184)).setAttribute("ancho","120" );
      ((Element)v.get(184)).setAttribute("minimizable","S" );
      ((Element)v.get(184)).setAttribute("minimizada","N" );
      ((Element)v.get(184)).setAttribute("oculta","S" );
      ((Element)v.get(170)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */

      /* Empieza nodo:185 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(185)).setAttribute("ancho","120" );
      ((Element)v.get(185)).setAttribute("minimizable","S" );
      ((Element)v.get(185)).setAttribute("minimizada","N" );
      ((Element)v.get(185)).setAttribute("oculta","S" );
      ((Element)v.get(170)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */

      /* Empieza nodo:186 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(186)).setAttribute("ancho","120" );
      ((Element)v.get(186)).setAttribute("minimizable","S" );
      ((Element)v.get(186)).setAttribute("minimizada","N" );
      ((Element)v.get(186)).setAttribute("oculta","S" );
      ((Element)v.get(170)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */

      /* Empieza nodo:187 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(187)).setAttribute("ancho","120" );
      ((Element)v.get(187)).setAttribute("minimizable","S" );
      ((Element)v.get(187)).setAttribute("minimizada","N" );
      ((Element)v.get(187)).setAttribute("oculta","S" );
      ((Element)v.get(170)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */

      /* Empieza nodo:188 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(188)).setAttribute("ancho","120" );
      ((Element)v.get(188)).setAttribute("minimizable","S" );
      ((Element)v.get(188)).setAttribute("minimizada","N" );
      ((Element)v.get(188)).setAttribute("oculta","S" );
      ((Element)v.get(170)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */

      /* Empieza nodo:189 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(189)).setAttribute("ancho","120" );
      ((Element)v.get(189)).setAttribute("minimizable","S" );
      ((Element)v.get(189)).setAttribute("minimizada","N" );
      ((Element)v.get(189)).setAttribute("oculta","S" );
      ((Element)v.get(170)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */

      /* Empieza nodo:190 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(190)).setAttribute("ancho","120" );
      ((Element)v.get(190)).setAttribute("minimizable","S" );
      ((Element)v.get(190)).setAttribute("minimizada","N" );
      ((Element)v.get(190)).setAttribute("oculta","S" );
      ((Element)v.get(170)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */

      /* Empieza nodo:191 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(191)).setAttribute("ancho","120" );
      ((Element)v.get(191)).setAttribute("minimizable","S" );
      ((Element)v.get(191)).setAttribute("minimizada","N" );
      ((Element)v.get(191)).setAttribute("oculta","S" );
      ((Element)v.get(170)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */

      /* Empieza nodo:192 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(192)).setAttribute("ancho","120" );
      ((Element)v.get(192)).setAttribute("minimizable","S" );
      ((Element)v.get(192)).setAttribute("minimizada","N" );
      ((Element)v.get(192)).setAttribute("oculta","S" );
      ((Element)v.get(170)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */

      /* Empieza nodo:193 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(193)).setAttribute("ancho","120" );
      ((Element)v.get(193)).setAttribute("minimizable","S" );
      ((Element)v.get(193)).setAttribute("minimizada","N" );
      ((Element)v.get(193)).setAttribute("oculta","S" );
      ((Element)v.get(170)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */

      /* Empieza nodo:194 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(194)).setAttribute("ancho","120" );
      ((Element)v.get(194)).setAttribute("minimizable","S" );
      ((Element)v.get(194)).setAttribute("minimizada","N" );
      ((Element)v.get(194)).setAttribute("oculta","S" );
      ((Element)v.get(170)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */

      /* Empieza nodo:195 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(195)).setAttribute("ancho","120" );
      ((Element)v.get(195)).setAttribute("minimizable","S" );
      ((Element)v.get(195)).setAttribute("minimizada","N" );
      ((Element)v.get(195)).setAttribute("oculta","S" );
      ((Element)v.get(170)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */

      /* Empieza nodo:196 / Elemento padre: 170   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(196)).setAttribute("ancho","120" );
      ((Element)v.get(196)).setAttribute("minimizable","S" );
      ((Element)v.get(196)).setAttribute("minimizada","N" );
      ((Element)v.get(196)).setAttribute("oculta","S" );
      ((Element)v.get(170)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:170   */

      /* Empieza nodo:197 / Elemento padre: 160   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(197)).setAttribute("alto","20" );
      ((Element)v.get(197)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(197)).setAttribute("imgFondo","" );
      ((Element)v.get(197)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(160)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(198)).setAttribute("colFondo","" );
      ((Element)v.get(198)).setAttribute("ID","EstCab" );
      ((Element)v.get(198)).setAttribute("cod","3411" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Elemento padre:198 / Elemento actual: 199   */
      v.add(doc.createTextNode("Producto Reemplazado"));
      ((Element)v.get(198)).appendChild((Text)v.get(199));

      /* Termina nodo Texto:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(200)).setAttribute("colFondo","" );
      ((Element)v.get(200)).setAttribute("ID","EstCab" );
      ((Element)v.get(200)).setAttribute("cod","3412" );
      ((Element)v.get(197)).appendChild((Element)v.get(200));

      /* Elemento padre:200 / Elemento actual: 201   */
      v.add(doc.createTextNode("oidProductoReemplazo"));
      ((Element)v.get(200)).appendChild((Text)v.get(201));

      /* Termina nodo Texto:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(202)).setAttribute("colFondo","" );
      ((Element)v.get(202)).setAttribute("ID","EstCab" );
      ((Element)v.get(202)).setAttribute("cod","3412" );
      ((Element)v.get(197)).appendChild((Element)v.get(202));

      /* Elemento padre:202 / Elemento actual: 203   */
      v.add(doc.createTextNode("Producto Reemplazo"));
      ((Element)v.get(202)).appendChild((Text)v.get(203));

      /* Termina nodo Texto:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(204)).setAttribute("colFondo","" );
      ((Element)v.get(204)).setAttribute("ID","EstCab" );
      ((Element)v.get(204)).setAttribute("cod","CarNivelRedon.Descripcion.label" );
      ((Element)v.get(197)).appendChild((Element)v.get(204));

      /* Elemento padre:204 / Elemento actual: 205   */
      v.add(doc.createTextNode("Descripcion"));
      ((Element)v.get(204)).appendChild((Text)v.get(205));

      /* Termina nodo Texto:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(206)).setAttribute("colFondo","" );
      ((Element)v.get(206)).setAttribute("ID","EstCab" );
      ((Element)v.get(206)).setAttribute("cod","ApeCargaEvaluar.unidades.label" );
      ((Element)v.get(197)).appendChild((Element)v.get(206));

      /* Elemento padre:206 / Elemento actual: 207   */
      v.add(doc.createTextNode("Unidades"));
      ((Element)v.get(206)).appendChild((Text)v.get(207));

      /* Termina nodo Texto:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(208)).setAttribute("colFondo","" );
      ((Element)v.get(208)).setAttribute("ID","EstCab" );
      ((Element)v.get(208)).setAttribute("cod","3413" );
      ((Element)v.get(197)).appendChild((Element)v.get(208));

      /* Elemento padre:208 / Elemento actual: 209   */
      v.add(doc.createTextNode("Cod. Venta Ficticio"));
      ((Element)v.get(208)).appendChild((Text)v.get(209));

      /* Termina nodo Texto:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(210)).setAttribute("colFondo","" );
      ((Element)v.get(210)).setAttribute("ID","EstCab" );
      ((Element)v.get(210)).setAttribute("cod","3413" );
      ((Element)v.get(197)).appendChild((Element)v.get(210));

      /* Elemento padre:210 / Elemento actual: 211   */
      v.add(doc.createTextNode("oidCriterioReemplazo"));
      ((Element)v.get(210)).appendChild((Text)v.get(211));

      /* Termina nodo Texto:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(212)).setAttribute("colFondo","" );
      ((Element)v.get(212)).setAttribute("ID","EstCab" );
      ((Element)v.get(212)).setAttribute("cod","3414" );
      ((Element)v.get(197)).appendChild((Element)v.get(212));

      /* Elemento padre:212 / Elemento actual: 213   */
      v.add(doc.createTextNode("Criterio de Reemplazo"));
      ((Element)v.get(212)).appendChild((Text)v.get(213));

      /* Termina nodo Texto:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:214 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(214)).setAttribute("colFondo","" );
      ((Element)v.get(214)).setAttribute("ID","EstCab" );
      ((Element)v.get(214)).setAttribute("cod","3415" );
      ((Element)v.get(197)).appendChild((Element)v.get(214));

      /* Elemento padre:214 / Elemento actual: 215   */
      v.add(doc.createTextNode("Valor del Criterio"));
      ((Element)v.get(214)).appendChild((Text)v.get(215));

      /* Termina nodo Texto:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:216 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(216)).setAttribute("colFondo","" );
      ((Element)v.get(216)).setAttribute("ID","EstCab" );
      ((Element)v.get(216)).setAttribute("cod","3416" );
      ((Element)v.get(197)).appendChild((Element)v.get(216));

      /* Elemento padre:216 / Elemento actual: 217   */
      v.add(doc.createTextNode("Nro. Orden"));
      ((Element)v.get(216)).appendChild((Text)v.get(217));

      /* Termina nodo Texto:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:218 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(218)).setAttribute("colFondo","" );
      ((Element)v.get(218)).setAttribute("ID","EstCab" );
      ((Element)v.get(218)).setAttribute("cod","3417" );
      ((Element)v.get(197)).appendChild((Element)v.get(218));

      /* Elemento padre:218 / Elemento actual: 219   */
      v.add(doc.createTextNode("Indicador de Activo"));
      ((Element)v.get(218)).appendChild((Text)v.get(219));

      /* Termina nodo Texto:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(220)).setAttribute("colFondo","" );
      ((Element)v.get(220)).setAttribute("ID","EstCab" );
      ((Element)v.get(220)).setAttribute("cod","3417" );
      ((Element)v.get(197)).appendChild((Element)v.get(220));

      /* Elemento padre:220 / Elemento actual: 221   */
      v.add(doc.createTextNode("oidReemplazoArticuloLote"));
      ((Element)v.get(220)).appendChild((Text)v.get(221));

      /* Termina nodo Texto:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:222 / Elemento padre: 197   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(222)).setAttribute("colFondo","" );
      ((Element)v.get(222)).setAttribute("ID","EstCab" );
      ((Element)v.get(222)).setAttribute("cod","3417" );
      ((Element)v.get(197)).appendChild((Element)v.get(222));

      /* Elemento padre:222 / Elemento actual: 223   */
      v.add(doc.createTextNode("IndCenServG"));
      ((Element)v.get(222)).appendChild((Text)v.get(223));

      /* Termina nodo Texto:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:224 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(224)).setAttribute("colFondo","" );
      ((Element)v.get(224)).setAttribute("ID","EstCab" );
      ((Element)v.get(224)).setAttribute("cod","3417" );
      ((Element)v.get(197)).appendChild((Element)v.get(224));

      /* Elemento padre:224 / Elemento actual: 225   */
      v.add(doc.createTextNode("oidCenServGar"));
      ((Element)v.get(224)).appendChild((Text)v.get(225));

      /* Termina nodo Texto:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:226 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(226)).setAttribute("colFondo","" );
      ((Element)v.get(226)).setAttribute("ID","EstCab" );
      ((Element)v.get(226)).setAttribute("cod","3417" );
      ((Element)v.get(197)).appendChild((Element)v.get(226));

      /* Elemento padre:226 / Elemento actual: 227   */
      v.add(doc.createTextNode("NumMeses"));
      ((Element)v.get(226)).appendChild((Text)v.get(227));

      /* Termina nodo Texto:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(228)).setAttribute("colFondo","" );
      ((Element)v.get(228)).setAttribute("ID","EstCab" );
      ((Element)v.get(228)).setAttribute("cod","3417" );
      ((Element)v.get(197)).appendChild((Element)v.get(228));

      /* Elemento padre:228 / Elemento actual: 229   */
      v.add(doc.createTextNode("Observaciones"));
      ((Element)v.get(228)).appendChild((Text)v.get(229));

      /* Termina nodo Texto:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:230 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(230)).setAttribute("colFondo","" );
      ((Element)v.get(230)).setAttribute("ID","EstCab" );
      ((Element)v.get(230)).setAttribute("cod","3417" );
      ((Element)v.get(197)).appendChild((Element)v.get(230));

      /* Elemento padre:230 / Elemento actual: 231   */
      v.add(doc.createTextNode("PrecioPublico4"));
      ((Element)v.get(230)).appendChild((Text)v.get(231));

      /* Termina nodo Texto:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:232 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(232)).setAttribute("colFondo","" );
      ((Element)v.get(232)).setAttribute("ID","EstCab" );
      ((Element)v.get(232)).setAttribute("cod","3417" );
      ((Element)v.get(197)).appendChild((Element)v.get(232));

      /* Elemento padre:232 / Elemento actual: 233   */
      v.add(doc.createTextNode("ArticuloDespacha"));
      ((Element)v.get(232)).appendChild((Text)v.get(233));

      /* Termina nodo Texto:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:234 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(234)).setAttribute("colFondo","" );
      ((Element)v.get(234)).setAttribute("ID","EstCab" );
      ((Element)v.get(234)).setAttribute("cod","3417" );
      ((Element)v.get(197)).appendChild((Element)v.get(234));

      /* Elemento padre:234 / Elemento actual: 235   */
      v.add(doc.createTextNode("TipoEntrega"));
      ((Element)v.get(234)).appendChild((Text)v.get(235));

      /* Termina nodo Texto:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:236 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(236)).setAttribute("colFondo","" );
      ((Element)v.get(236)).setAttribute("ID","EstCab" );
      ((Element)v.get(236)).setAttribute("cod","3417" );
      ((Element)v.get(197)).appendChild((Element)v.get(236));

      /* Elemento padre:236 / Elemento actual: 237   */
      v.add(doc.createTextNode("CenServEntrega"));
      ((Element)v.get(236)).appendChild((Text)v.get(237));

      /* Termina nodo Texto:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:238 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(238)).setAttribute("colFondo","" );
      ((Element)v.get(238)).setAttribute("ID","EstCab" );
      ((Element)v.get(238)).setAttribute("cod","3417" );
      ((Element)v.get(197)).appendChild((Element)v.get(238));

      /* Elemento padre:238 / Elemento actual: 239   */
      v.add(doc.createTextNode("Comunicacion"));
      ((Element)v.get(238)).appendChild((Text)v.get(239));

      /* Termina nodo Texto:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:240 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(240)).setAttribute("colFondo","" );
      ((Element)v.get(240)).setAttribute("ID","EstCab" );
      ((Element)v.get(240)).setAttribute("cod","3417" );
      ((Element)v.get(197)).appendChild((Element)v.get(240));

      /* Elemento padre:240 / Elemento actual: 241   */
      v.add(doc.createTextNode("numeroPremio"));
      ((Element)v.get(240)).appendChild((Text)v.get(241));

      /* Termina nodo Texto:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:242 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(242)).setAttribute("colFondo","" );
      ((Element)v.get(242)).setAttribute("ID","EstCab" );
      ((Element)v.get(242)).setAttribute("cod","3417" );
      ((Element)v.get(197)).appendChild((Element)v.get(242));

      /* Elemento padre:242 / Elemento actual: 243   */
      v.add(doc.createTextNode("descripcionProductoReemplazado"));
      ((Element)v.get(242)).appendChild((Text)v.get(243));

      /* Termina nodo Texto:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:244 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(244)).setAttribute("colFondo","" );
      ((Element)v.get(244)).setAttribute("ID","EstCab" );
      ((Element)v.get(244)).setAttribute("cod","3417" );
      ((Element)v.get(197)).appendChild((Element)v.get(244));

      /* Elemento padre:244 / Elemento actual: 245   */
      v.add(doc.createTextNode("region"));
      ((Element)v.get(244)).appendChild((Text)v.get(245));

      /* Termina nodo Texto:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:246 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(246)).setAttribute("colFondo","" );
      ((Element)v.get(246)).setAttribute("ID","EstCab" );
      ((Element)v.get(246)).setAttribute("cod","3417" );
      ((Element)v.get(197)).appendChild((Element)v.get(246));

      /* Elemento padre:246 / Elemento actual: 247   */
      v.add(doc.createTextNode("zona"));
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(246)).appendChild((Text)v.get(247));

      /* Termina nodo Texto:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:248 / Elemento padre: 197   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(248)).setAttribute("colFondo","" );
      ((Element)v.get(248)).setAttribute("ID","EstCab" );
      ((Element)v.get(248)).setAttribute("cod","3417" );
      ((Element)v.get(197)).appendChild((Element)v.get(248));

      /* Elemento padre:248 / Elemento actual: 249   */
      v.add(doc.createTextNode("articuloLote"));
      ((Element)v.get(248)).appendChild((Text)v.get(249));

      /* Termina nodo Texto:249   */
      /* Termina nodo:248   */
      /* Termina nodo:197   */

      /* Empieza nodo:250 / Elemento padre: 160   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(250)).setAttribute("alto","22" );
      ((Element)v.get(250)).setAttribute("accion","" );
      ((Element)v.get(250)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(250)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(250)).setAttribute("maxSel","-1" );
      ((Element)v.get(250)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(250)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(250)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(250)).setAttribute("onLoad","" );
      ((Element)v.get(250)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(160)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(251)).setAttribute("tipo","texto" );
      ((Element)v.get(251)).setAttribute("ID","EstDat" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */

      /* Empieza nodo:252 / Elemento padre: 250   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(252)).setAttribute("tipo","texto" );
      ((Element)v.get(252)).setAttribute("ID","EstDat2" );
      ((Element)v.get(250)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */

      /* Empieza nodo:253 / Elemento padre: 250   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(253)).setAttribute("tipo","texto" );
      ((Element)v.get(253)).setAttribute("ID","EstDat" );
      ((Element)v.get(250)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */

      /* Empieza nodo:254 / Elemento padre: 250   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(254)).setAttribute("tipo","texto" );
      ((Element)v.get(254)).setAttribute("ID","EstDat2" );
      ((Element)v.get(250)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */

      /* Empieza nodo:255 / Elemento padre: 250   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(255)).setAttribute("tipo","texto" );
      ((Element)v.get(255)).setAttribute("ID","EstDat" );
      ((Element)v.get(250)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */

      /* Empieza nodo:256 / Elemento padre: 250   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(256)).setAttribute("tipo","texto" );
      ((Element)v.get(256)).setAttribute("ID","EstDat2" );
      ((Element)v.get(250)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */

      /* Empieza nodo:257 / Elemento padre: 250   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(257)).setAttribute("tipo","texto" );
      ((Element)v.get(257)).setAttribute("ID","EstDat" );
      ((Element)v.get(250)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */

      /* Empieza nodo:258 / Elemento padre: 250   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(258)).setAttribute("tipo","texto" );
      ((Element)v.get(258)).setAttribute("ID","EstDat2" );
      ((Element)v.get(250)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */

      /* Empieza nodo:259 / Elemento padre: 250   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(259)).setAttribute("tipo","texto" );
      ((Element)v.get(259)).setAttribute("ID","EstDat" );
      ((Element)v.get(250)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */

      /* Empieza nodo:260 / Elemento padre: 250   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(260)).setAttribute("tipo","texto" );
      ((Element)v.get(260)).setAttribute("ID","EstDat2" );
      ((Element)v.get(250)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */

      /* Empieza nodo:261 / Elemento padre: 250   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(261)).setAttribute("tipo","texto" );
      ((Element)v.get(261)).setAttribute("ID","EstDat" );
      ((Element)v.get(250)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */

      /* Empieza nodo:262 / Elemento padre: 250   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(262)).setAttribute("tipo","texto" );
      ((Element)v.get(262)).setAttribute("ID","EstDat2" );
      ((Element)v.get(250)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */

      /* Empieza nodo:263 / Elemento padre: 250   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(263)).setAttribute("tipo","texto" );
      ((Element)v.get(263)).setAttribute("ID","EstDat" );
      ((Element)v.get(250)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */

      /* Empieza nodo:264 / Elemento padre: 250   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(264)).setAttribute("tipo","texto" );
      ((Element)v.get(264)).setAttribute("ID","EstDat2" );
      ((Element)v.get(250)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */

      /* Empieza nodo:265 / Elemento padre: 250   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(265)).setAttribute("tipo","texto" );
      ((Element)v.get(265)).setAttribute("ID","EstDat" );
      ((Element)v.get(250)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */

      /* Empieza nodo:266 / Elemento padre: 250   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(266)).setAttribute("tipo","texto" );
      ((Element)v.get(266)).setAttribute("ID","EstDat2" );
      ((Element)v.get(250)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */

      /* Empieza nodo:267 / Elemento padre: 250   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(267)).setAttribute("tipo","texto" );
      ((Element)v.get(267)).setAttribute("ID","EstDat" );
      ((Element)v.get(250)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */

      /* Empieza nodo:268 / Elemento padre: 250   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(268)).setAttribute("tipo","texto" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(268)).setAttribute("ID","EstDat2" );
      ((Element)v.get(250)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */

      /* Empieza nodo:269 / Elemento padre: 250   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(269)).setAttribute("tipo","texto" );
      ((Element)v.get(269)).setAttribute("ID","EstDat" );
      ((Element)v.get(250)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */

      /* Empieza nodo:270 / Elemento padre: 250   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(270)).setAttribute("tipo","texto" );
      ((Element)v.get(270)).setAttribute("ID","EstDat2" );
      ((Element)v.get(250)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */

      /* Empieza nodo:271 / Elemento padre: 250   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(271)).setAttribute("tipo","texto" );
      ((Element)v.get(271)).setAttribute("ID","EstDat" );
      ((Element)v.get(250)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */

      /* Empieza nodo:272 / Elemento padre: 250   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(272)).setAttribute("tipo","texto" );
      ((Element)v.get(272)).setAttribute("ID","EstDat" );
      ((Element)v.get(250)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */

      /* Empieza nodo:273 / Elemento padre: 250   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(273)).setAttribute("tipo","texto" );
      ((Element)v.get(273)).setAttribute("ID","EstDat" );
      ((Element)v.get(250)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */

      /* Empieza nodo:274 / Elemento padre: 250   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(274)).setAttribute("tipo","texto" );
      ((Element)v.get(274)).setAttribute("ID","EstDat" );
      ((Element)v.get(250)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */

      /* Empieza nodo:275 / Elemento padre: 250   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(275)).setAttribute("tipo","texto" );
      ((Element)v.get(275)).setAttribute("ID","EstDat" );
      ((Element)v.get(250)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */

      /* Empieza nodo:276 / Elemento padre: 250   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(276)).setAttribute("tipo","texto" );
      ((Element)v.get(276)).setAttribute("ID","EstDat" );
      ((Element)v.get(250)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:250   */

      /* Empieza nodo:277 / Elemento padre: 160   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(160)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */

      /* Empieza nodo:278 / Elemento padre: 160   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(278)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(278)).setAttribute("ancho","697" );
      ((Element)v.get(278)).setAttribute("sep","$" );
      ((Element)v.get(278)).setAttribute("x","12" );
      ((Element)v.get(278)).setAttribute("class","botonera" );
      ((Element)v.get(278)).setAttribute("y","294" );
      ((Element)v.get(278)).setAttribute("control","|" );
      ((Element)v.get(278)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(278)).setAttribute("rowset","" );
      ((Element)v.get(278)).setAttribute("cargainicial","N" );
      ((Element)v.get(278)).setAttribute("onload","procesarPaginado(mipgndo2,msgError, ultima, rowset, 'muestraLista2(ultima, rowset, error)')" );
      ((Element)v.get(160)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(279)).setAttribute("nombre","ret2" );
      ((Element)v.get(279)).setAttribute("x","37" );
      ((Element)v.get(279)).setAttribute("y","298" );
      ((Element)v.get(279)).setAttribute("ID","botonContenido" );
      ((Element)v.get(279)).setAttribute("img","retroceder_on" );
      ((Element)v.get(279)).setAttribute("tipo","0" );
      ((Element)v.get(279)).setAttribute("estado","false" );
      ((Element)v.get(279)).setAttribute("alt","" );
      ((Element)v.get(279)).setAttribute("codigo","" );
      ((Element)v.get(279)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */

      /* Empieza nodo:280 / Elemento padre: 278   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(280)).setAttribute("nombre","ava2" );
      ((Element)v.get(280)).setAttribute("x","52" );
      ((Element)v.get(280)).setAttribute("y","298" );
      ((Element)v.get(280)).setAttribute("ID","botonContenido" );
      ((Element)v.get(280)).setAttribute("img","avanzar_on" );
      ((Element)v.get(280)).setAttribute("tipo","0" );
      ((Element)v.get(280)).setAttribute("estado","false" );
      ((Element)v.get(280)).setAttribute("alt","" );
      ((Element)v.get(280)).setAttribute("codigo","" );
      ((Element)v.get(280)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(278)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:278   */
      /* Termina nodo:160   */

      /* Empieza nodo:281 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(281)).setAttribute("nombre","btnConsultar" );
      ((Element)v.get(281)).setAttribute("x","10" );
      ((Element)v.get(281)).setAttribute("y","755" );
      ((Element)v.get(281)).setAttribute("ID","botonContenido" );
      ((Element)v.get(281)).setAttribute("tipo","html" );
      ((Element)v.get(281)).setAttribute("estado","false" );
      ((Element)v.get(281)).setAttribute("cod","150" );
      ((Element)v.get(281)).setAttribute("ontab","onTabConsultar();" );
      ((Element)v.get(281)).setAttribute("onshtab","onShTabConsultar();" );
      ((Element)v.get(281)).setAttribute("accion","accionBTN_Consultar();" );
      ((Element)v.get(9)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */

      /* Empieza nodo:282 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(282)).setAttribute("nombre","btnModificar" );
      ((Element)v.get(282)).setAttribute("x","78" );
      ((Element)v.get(282)).setAttribute("y","755" );
      ((Element)v.get(282)).setAttribute("ID","botonContenido" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(282)).setAttribute("tipo","html" );
      ((Element)v.get(282)).setAttribute("estado","false" );
      ((Element)v.get(282)).setAttribute("cod","2" );
      ((Element)v.get(282)).setAttribute("ontab","onTabModificar();" );
      ((Element)v.get(282)).setAttribute("onshtab","onShTabModificar();" );
      ((Element)v.get(282)).setAttribute("accion","accionBTN_Modificar();" );
      ((Element)v.get(9)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */

      /* Empieza nodo:283 / Elemento padre: 9   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(283)).setAttribute("nombre","btnEliminar" );
      ((Element)v.get(283)).setAttribute("x","143" );
      ((Element)v.get(283)).setAttribute("y","755" );
      ((Element)v.get(283)).setAttribute("ID","botonContenido" );
      ((Element)v.get(283)).setAttribute("tipo","html" );
      ((Element)v.get(283)).setAttribute("estado","false" );
      ((Element)v.get(283)).setAttribute("cod","1254" );
      ((Element)v.get(283)).setAttribute("ontab","onTabEliminar();" );
      ((Element)v.get(283)).setAttribute("onshtab","onShTabEliminar();" );
      ((Element)v.get(283)).setAttribute("accion","accionBTN_Elimiar();" );
      ((Element)v.get(9)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:9   */


   }

}

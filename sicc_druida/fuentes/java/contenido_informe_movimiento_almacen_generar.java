
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_informe_movimiento_almacen_generar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_informe_movimiento_almacen_generar" );
      ((Element)v.get(0)).setAttribute("cod","0852" );
      ((Element)v.get(0)).setAttribute("titulo","Generar informe movimiento del almacén por facturación" );
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
      ((Element)v.get(4)).setAttribute("src","contenido_informe_movimiento_almacen_generar.js" );
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
      ((Element)v.get(7)).setAttribute("name","cbMarca" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","6" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbCanal" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","7" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","txtFechaValorDesde" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","2677" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","txtFechaValorHasta" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","2678" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbCriterioSeleccion" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","2668" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","cbTipoReporte" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","2534" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */
      /* Termina nodo:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:13 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(13)).setAttribute("nombre","Formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(13));

      /* Empieza nodo:14 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","accion" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","pais" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","marca" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","canal" );
      ((Element)v.get(21)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(13)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","fechaValorDesde" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","fechaValorHasta" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","clase" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","codProductoDesde" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","codProductoHasta" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","region" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","zona" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","seccion" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","territorioDesde" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","criterio" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","tipoReporte" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","fechaActual" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","formato" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(35)).setAttribute("nombre","capa1" );
      ((Element)v.get(13)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("table"));
      ((Element)v.get(36)).setAttribute("width","100%" );
      ((Element)v.get(36)).setAttribute("border","0" );
      ((Element)v.get(36)).setAttribute("cellspacing","0" );
      ((Element)v.get(36)).setAttribute("cellpadding","0" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).setAttribute("width","12" );
      ((Element)v.get(38)).setAttribute("align","center" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(39)).setAttribute("width","12" );
      ((Element)v.get(39)).setAttribute("height","12" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).setAttribute("width","750" );
      ((Element)v.get(37)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 37   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).setAttribute("width","12" );
      ((Element)v.get(37)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","12" );
      ((Element)v.get(43)).setAttribute("height","1" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */
      /* Termina nodo:37   */

      /* Empieza nodo:44 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(49)).setAttribute("class","legend" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(50)).setAttribute("nombre","lblCriteriosSeleccion" );
      ((Element)v.get(50)).setAttribute("alto","13" );
      ((Element)v.get(50)).setAttribute("filas","1" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(50)).setAttribute("id","legend" );
      ((Element)v.get(50)).setAttribute("cod","00275" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 48   */
      v.add(doc.createElement("table"));
      ((Element)v.get(51)).setAttribute("width","100%" );
      ((Element)v.get(51)).setAttribute("border","0" );
      ((Element)v.get(51)).setAttribute("align","center" );
      ((Element)v.get(51)).setAttribute("cellspacing","0" );
      ((Element)v.get(51)).setAttribute("cellpadding","0" );
      ((Element)v.get(48)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("table"));
      ((Element)v.get(54)).setAttribute("width","100%" );
      ((Element)v.get(54)).setAttribute("border","0" );
      ((Element)v.get(54)).setAttribute("align","left" );
      ((Element)v.get(54)).setAttribute("cellspacing","0" );
      ((Element)v.get(54)).setAttribute("cellpadding","0" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).setAttribute("colspan","4" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","8" );
      ((Element)v.get(57)).setAttribute("height","8" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:58 / Elemento padre: 54   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(54)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","8" );
      ((Element)v.get(60)).setAttribute("height","8" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(62)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(62)).setAttribute("alto","13" );
      ((Element)v.get(62)).setAttribute("filas","1" );
      ((Element)v.get(62)).setAttribute("id","datosTitle" );
      ((Element)v.get(62)).setAttribute("cod","6" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","25" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(66)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(66)).setAttribute("alto","13" );
      ((Element)v.get(66)).setAttribute("filas","1" );
      ((Element)v.get(66)).setAttribute("id","datosTitle" );
      ((Element)v.get(66)).setAttribute("cod","7" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(68)).setAttribute("src","b.gif" );
      ((Element)v.get(68)).setAttribute("width","25" );
      ((Element)v.get(68)).setAttribute("height","8" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(70)).setAttribute("nombre","lblFechaValorDesde" );
      ((Element)v.get(70)).setAttribute("alto","13" );
      ((Element)v.get(70)).setAttribute("filas","1" );
      ((Element)v.get(70)).setAttribute("id","datosTitle" );
      ((Element)v.get(70)).setAttribute("cod","2677" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","25" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(74)).setAttribute("nombre","lblFechaValorHasta" );
      ((Element)v.get(74)).setAttribute("alto","13" );
      ((Element)v.get(74)).setAttribute("filas","1" );
      ((Element)v.get(74)).setAttribute("id","datosTitle" );
      ((Element)v.get(74)).setAttribute("cod","2678" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("width","100%" );
      ((Element)v.get(58)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","8" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:58   */

      /* Empieza nodo:77 / Elemento padre: 54   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(54)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","8" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(77)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(81)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(81)).setAttribute("size","5" );
      ((Element)v.get(81)).setAttribute("multiple","S" );
      ((Element)v.get(81)).setAttribute("valorinicial","" );
      ((Element)v.get(81)).setAttribute("textoinicial","" );
      ((Element)v.get(81)).setAttribute("id","datosCampos" );
      ((Element)v.get(81)).setAttribute("req","S" );
      ((Element)v.get(81)).setAttribute("onchange","cambioMarcaCanal();" );
      ((Element)v.get(81)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnGenerarExcel');" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:83 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","25" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(77)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(86)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(86)).setAttribute("size","5" );
      ((Element)v.get(86)).setAttribute("multiple","S" );
      ((Element)v.get(86)).setAttribute("valorinicial","" );
      ((Element)v.get(86)).setAttribute("textoinicial","" );
      ((Element)v.get(86)).setAttribute("id","datosCampos" );
      ((Element)v.get(86)).setAttribute("req","S" );
      ((Element)v.get(86)).setAttribute("onchange","cambioCanal();" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:88 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","25" );
      ((Element)v.get(89)).setAttribute("height","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(90)).setAttribute("valign","top" );
      ((Element)v.get(77)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("CTEXTO"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(91)).setAttribute("nombre","txtFechaValorDesde" );
      ((Element)v.get(91)).setAttribute("id","datosCampos" );
      ((Element)v.get(91)).setAttribute("max","10" );
      ((Element)v.get(91)).setAttribute("tipo","" );
      ((Element)v.get(91)).setAttribute("onchange","" );
      ((Element)v.get(91)).setAttribute("req","S" );
      ((Element)v.get(91)).setAttribute("size","12" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(91)).setAttribute("validacion","" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","25" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(94)).setAttribute("valign","top" );
      ((Element)v.get(77)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(95)).setAttribute("nombre","txtFechaValorHasta" );
      ((Element)v.get(95)).setAttribute("id","datosCampos" );
      ((Element)v.get(95)).setAttribute("max","10" );
      ((Element)v.get(95)).setAttribute("tipo","" );
      ((Element)v.get(95)).setAttribute("onchange","" );
      ((Element)v.get(95)).setAttribute("req","S" );
      ((Element)v.get(95)).setAttribute("size","12" );
      ((Element)v.get(95)).setAttribute("valor","" );
      ((Element)v.get(95)).setAttribute("validacion","" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("width","100%" );
      ((Element)v.get(77)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","8" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:77   */

      /* Empieza nodo:98 / Elemento padre: 54   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(54)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("colspan","4" );
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
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:101 / Elemento padre: 51   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("table"));
      ((Element)v.get(103)).setAttribute("width","10%" );
      ((Element)v.get(103)).setAttribute("border","0" );
      ((Element)v.get(103)).setAttribute("align","left" );
      ((Element)v.get(103)).setAttribute("cellspacing","0" );
      ((Element)v.get(103)).setAttribute("cellpadding","0" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","8" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(108)).setAttribute("nombre","lblClase" );
      ((Element)v.get(108)).setAttribute("alto","13" );
      ((Element)v.get(108)).setAttribute("filas","1" );
      ((Element)v.get(108)).setAttribute("id","datosTitle" );
      ((Element)v.get(108)).setAttribute("cod","3069" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","25" );
      ((Element)v.get(110)).setAttribute("height","8" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:104   */

      /* Empieza nodo:111 / Elemento padre: 103   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(103)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).setAttribute("width","8" );
      ((Element)v.get(113)).setAttribute("height","8" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(111)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(115)).setAttribute("nombre","cbClase" );
      ((Element)v.get(115)).setAttribute("size","5" );
      ((Element)v.get(115)).setAttribute("multiple","S" );
      ((Element)v.get(115)).setAttribute("valorinicial","" );
      ((Element)v.get(115)).setAttribute("textoinicial","" );
      ((Element)v.get(115)).setAttribute("id","datosCampos" );
      ((Element)v.get(115)).setAttribute("req","N" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:117 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","25" );
      ((Element)v.get(118)).setAttribute("height","8" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:111   */

      /* Empieza nodo:119 / Elemento padre: 103   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(103)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).setAttribute("colspan","3" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","8" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:122 / Elemento padre: 51   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("table"));
      ((Element)v.get(124)).setAttribute("width","1%" );
      ((Element)v.get(124)).setAttribute("border","0" );
      ((Element)v.get(124)).setAttribute("align","left" );
      ((Element)v.get(124)).setAttribute("cellspacing","0" );
      ((Element)v.get(124)).setAttribute("cellpadding","0" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","8" );
      ((Element)v.get(127)).setAttribute("height","8" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:128 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(129)).setAttribute("nombre","lblCodProducto" );
      ((Element)v.get(129)).setAttribute("alto","13" );
      ((Element)v.get(129)).setAttribute("filas","1" );
      ((Element)v.get(129)).setAttribute("id","datosTitle" );
      ((Element)v.get(129)).setAttribute("cod","337" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(131)).setAttribute("src","b.gif" );
      ((Element)v.get(131)).setAttribute("width","25" );
      ((Element)v.get(131)).setAttribute("height","8" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:125   */

      /* Empieza nodo:132 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","8" );
      ((Element)v.get(134)).setAttribute("height","8" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(135)).setAttribute("valign","top" );
      ((Element)v.get(132)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(136)).setAttribute("nombre","cbProducto" );
      ((Element)v.get(136)).setAttribute("size","5" );
      ((Element)v.get(136)).setAttribute("multiple","S" );
      ((Element)v.get(136)).setAttribute("valorinicial","" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(136)).setAttribute("textoinicial","" );
      ((Element)v.get(136)).setAttribute("id","datosCampos" );
      ((Element)v.get(136)).setAttribute("req","N" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:138 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).setAttribute("valign","top" );
      ((Element)v.get(132)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","iconBuscar.gif" );
      ((Element)v.get(139)).setAttribute("onclick","buscarProducto();" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:132   */

      /* Empieza nodo:140 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).setAttribute("colspan","3" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","8" );
      ((Element)v.get(142)).setAttribute("height","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:143 / Elemento padre: 51   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("table"));
      ((Element)v.get(145)).setAttribute("width","100%" );
      ((Element)v.get(145)).setAttribute("border","0" );
      ((Element)v.get(145)).setAttribute("align","left" );
      ((Element)v.get(145)).setAttribute("cellspacing","0" );
      ((Element)v.get(145)).setAttribute("cellpadding","0" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).setAttribute("width","8" );
      ((Element)v.get(148)).setAttribute("height","8" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(150)).setAttribute("nombre","lblRegion" );
      ((Element)v.get(150)).setAttribute("alto","13" );
      ((Element)v.get(150)).setAttribute("filas","1" );
      ((Element)v.get(150)).setAttribute("id","datosTitle" );
      ((Element)v.get(150)).setAttribute("cod","109" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).setAttribute("width","25" );
      ((Element)v.get(152)).setAttribute("height","8" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:153 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(154)).setAttribute("nombre","lblZona" );
      ((Element)v.get(154)).setAttribute("alto","13" );
      ((Element)v.get(154)).setAttribute("filas","1" );
      ((Element)v.get(154)).setAttribute("id","datosTitle" );
      ((Element)v.get(154)).setAttribute("cod","143" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).setAttribute("width","100%" );
      ((Element)v.get(146)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","8" );
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:146   */

      /* Empieza nodo:157 / Elemento padre: 145   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(145)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","8" );
      ((Element)v.get(159)).setAttribute("height","8" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(157)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(161)).setAttribute("nombre","cbRegion" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(161)).setAttribute("size","5" );
      ((Element)v.get(161)).setAttribute("multiple","S" );
      ((Element)v.get(161)).setAttribute("valorinicial","" );
      ((Element)v.get(161)).setAttribute("textoinicial","" );
      ((Element)v.get(161)).setAttribute("id","datosCampos" );
      ((Element)v.get(161)).setAttribute("req","N" );
      ((Element)v.get(161)).setAttribute("onchange","cambioRegionMarcaCanal();" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:163 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","25" );
      ((Element)v.get(164)).setAttribute("height","8" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(157)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(166)).setAttribute("nombre","cbZona" );
      ((Element)v.get(166)).setAttribute("size","5" );
      ((Element)v.get(166)).setAttribute("multiple","S" );
      ((Element)v.get(166)).setAttribute("valorinicial","" );
      ((Element)v.get(166)).setAttribute("textoinicial","" );
      ((Element)v.get(166)).setAttribute("id","datosCampos" );
      ((Element)v.get(166)).setAttribute("req","N" );
      ((Element)v.get(166)).setAttribute("onchange","cambioZona();" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:168 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).setAttribute("width","100%" );
      ((Element)v.get(157)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(169)).setAttribute("src","b.gif" );
      ((Element)v.get(169)).setAttribute("width","8" );
      ((Element)v.get(169)).setAttribute("height","8" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */
      /* Termina nodo:157   */

      /* Empieza nodo:170 / Elemento padre: 145   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(145)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).setAttribute("colspan","4" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).setAttribute("width","8" );
      ((Element)v.get(172)).setAttribute("height","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */
      /* Termina nodo:170   */
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:173 / Elemento padre: 51   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("table"));
      ((Element)v.get(175)).setAttribute("width","10%" );
      ((Element)v.get(175)).setAttribute("border","0" );
      ((Element)v.get(175)).setAttribute("align","left" );
      ((Element)v.get(175)).setAttribute("cellspacing","0" );
      ((Element)v.get(175)).setAttribute("cellpadding","0" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(178)).setAttribute("src","b.gif" );
      ((Element)v.get(178)).setAttribute("width","8" );
      ((Element)v.get(178)).setAttribute("height","8" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:179 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(180)).setAttribute("nombre","lblSeccion" );
      ((Element)v.get(180)).setAttribute("alto","13" );
      ((Element)v.get(180)).setAttribute("filas","1" );
      ((Element)v.get(180)).setAttribute("id","datosTitle" );
      ((Element)v.get(180)).setAttribute("cod","112" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(182)).setAttribute("src","b.gif" );
      ((Element)v.get(182)).setAttribute("width","25" );
      ((Element)v.get(182)).setAttribute("height","8" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(184)).setAttribute("nombre","lblTerritorioDesde" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(184)).setAttribute("alto","13" );
      ((Element)v.get(184)).setAttribute("filas","1" );
      ((Element)v.get(184)).setAttribute("id","datosTitle" );
      ((Element)v.get(184)).setAttribute("cod","997" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).setAttribute("width","100%" );
      ((Element)v.get(176)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).setAttribute("width","8" );
      ((Element)v.get(186)).setAttribute("height","8" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(188)).setAttribute("nombre","lblTerritorioHasta" );
      ((Element)v.get(188)).setAttribute("alto","13" );
      ((Element)v.get(188)).setAttribute("filas","1" );
      ((Element)v.get(188)).setAttribute("id","datosTitle" );
      ((Element)v.get(188)).setAttribute("cod","998" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(189)).setAttribute("width","100%" );
      ((Element)v.get(176)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","8" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */
      /* Termina nodo:176   */

      /* Empieza nodo:191 / Elemento padre: 175   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(175)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","8" );
      ((Element)v.get(193)).setAttribute("height","8" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:194 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(191)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(195)).setAttribute("nombre","cbSeccion" );
      ((Element)v.get(195)).setAttribute("size","5" );
      ((Element)v.get(195)).setAttribute("multiple","S" );
      ((Element)v.get(195)).setAttribute("valorinicial","" );
      ((Element)v.get(195)).setAttribute("textoinicial","" );
      ((Element)v.get(195)).setAttribute("id","datosCampos" );
      ((Element)v.get(195)).setAttribute("req","N" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:197 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).setAttribute("width","25" );
      ((Element)v.get(198)).setAttribute("height","8" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(199)).setAttribute("valign","top" );
      ((Element)v.get(191)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(200)).setAttribute("nombre","txtTerritorioDesde" );
      ((Element)v.get(200)).setAttribute("size","6" );
      ((Element)v.get(200)).setAttribute("multiple","S" );
      ((Element)v.get(200)).setAttribute("valorinicial","" );
      ((Element)v.get(200)).setAttribute("textoinicial","" );
      ((Element)v.get(200)).setAttribute("id","datosCampos" );
      ((Element)v.get(200)).setAttribute("req","N" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:201 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).setAttribute("width","100%" );
      ((Element)v.get(191)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(202)).setAttribute("src","b.gif" );
      ((Element)v.get(202)).setAttribute("width","8" );
      ((Element)v.get(202)).setAttribute("height","8" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:203 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(203)).setAttribute("valign","top" );
      ((Element)v.get(191)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(204)).setAttribute("nombre","txtTerritorioHasta" );
      ((Element)v.get(204)).setAttribute("size","6" );
      ((Element)v.get(204)).setAttribute("multiple","S" );
      ((Element)v.get(204)).setAttribute("valorinicial","" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(204)).setAttribute("textoinicial","" );
      ((Element)v.get(204)).setAttribute("id","datosCampos" );
      ((Element)v.get(204)).setAttribute("req","N" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:205 / Elemento padre: 191   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).setAttribute("width","100%" );
      ((Element)v.get(191)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).setAttribute("width","8" );
      ((Element)v.get(206)).setAttribute("height","8" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */
      /* Termina nodo:191   */

      /* Empieza nodo:207 / Elemento padre: 175   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(175)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).setAttribute("colspan","6" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","8" );
      ((Element)v.get(209)).setAttribute("height","8" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:175   */
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:210 / Elemento padre: 51   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(51)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("table"));
      ((Element)v.get(212)).setAttribute("width","100%" );
      ((Element)v.get(212)).setAttribute("border","0" );
      ((Element)v.get(212)).setAttribute("align","left" );
      ((Element)v.get(212)).setAttribute("cellspacing","0" );
      ((Element)v.get(212)).setAttribute("cellpadding","0" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(215)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).setAttribute("width","8" );
      ((Element)v.get(215)).setAttribute("height","8" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:216 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(217)).setAttribute("nombre","lblCriterioSeleccion" );
      ((Element)v.get(217)).setAttribute("alto","13" );
      ((Element)v.get(217)).setAttribute("filas","1" );
      ((Element)v.get(217)).setAttribute("id","datosTitle" );
      ((Element)v.get(217)).setAttribute("cod","2668" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:218 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("width","25" );
      ((Element)v.get(219)).setAttribute("height","8" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(221)).setAttribute("nombre","lblTipoReporte" );
      ((Element)v.get(221)).setAttribute("alto","13" );
      ((Element)v.get(221)).setAttribute("filas","1" );
      ((Element)v.get(221)).setAttribute("id","datosTitle" );
      ((Element)v.get(221)).setAttribute("cod","2534" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:222 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).setAttribute("width","100%" );
      ((Element)v.get(213)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(223)).setAttribute("src","b.gif" );
      ((Element)v.get(223)).setAttribute("width","8" );
      ((Element)v.get(223)).setAttribute("height","8" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */
      /* Termina nodo:213   */

      /* Empieza nodo:224 / Elemento padre: 212   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(212)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(226)).setAttribute("src","b.gif" );
      ((Element)v.get(226)).setAttribute("width","8" );
      ((Element)v.get(226)).setAttribute("height","8" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:227 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(227)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(224)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(228)).setAttribute("nombre","cbCriterioSeleccion" );
      ((Element)v.get(228)).setAttribute("size","1" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(228)).setAttribute("multiple","N" );
      ((Element)v.get(228)).setAttribute("valorinicial","1" );
      ((Element)v.get(228)).setAttribute("textoinicial","Venta Bruta" );
      ((Element)v.get(228)).setAttribute("id","datosCampos" );
      ((Element)v.get(228)).setAttribute("req","S" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(230)).setAttribute("ID","1" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(231)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(231)).setAttribute("TIPO","STRING" );
      ((Element)v.get(231)).setAttribute("VALOR","2" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */

      /* Empieza nodo:232 / Elemento padre: 230   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(232)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(232)).setAttribute("TIPO","STRING" );
      ((Element)v.get(232)).setAttribute("VALOR","Devolución" );
      ((Element)v.get(230)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:230   */

      /* Empieza nodo:233 / Elemento padre: 229   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(233)).setAttribute("ID","2" );
      ((Element)v.get(229)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(234)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(234)).setAttribute("TIPO","STRING" );
      ((Element)v.get(234)).setAttribute("VALOR","3" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */

      /* Empieza nodo:235 / Elemento padre: 233   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(235)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(235)).setAttribute("TIPO","STRING" );
      ((Element)v.get(235)).setAttribute("VALOR","Venta neta" );
      ((Element)v.get(233)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:233   */
      /* Termina nodo:229   */
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:236 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(237)).setAttribute("src","b.gif" );
      ((Element)v.get(237)).setAttribute("width","25" );
      ((Element)v.get(237)).setAttribute("height","8" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:238 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(238)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(224)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(239)).setAttribute("nombre","cbTipoReporte" );
      ((Element)v.get(239)).setAttribute("size","1" );
      ((Element)v.get(239)).setAttribute("multiple","N" );
      ((Element)v.get(239)).setAttribute("valorinicial","1" );
      ((Element)v.get(239)).setAttribute("textoinicial","Resumen" );
      ((Element)v.get(239)).setAttribute("id","datosCampos" );
      ((Element)v.get(239)).setAttribute("req","S" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(239)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(241)).setAttribute("ID","1" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(242)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(242)).setAttribute("TIPO","STRING" );
      ((Element)v.get(242)).setAttribute("VALOR","2" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */

      /* Empieza nodo:243 / Elemento padre: 241   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(243)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(243)).setAttribute("TIPO","STRING" );
      ((Element)v.get(243)).setAttribute("VALOR","Detalle" );
      ((Element)v.get(241)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:241   */
      /* Termina nodo:240   */
      /* Termina nodo:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:244 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).setAttribute("width","100%" );
      ((Element)v.get(224)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(245)).setAttribute("src","b.gif" );
      ((Element)v.get(245)).setAttribute("width","8" );
      ((Element)v.get(245)).setAttribute("height","8" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */
      /* Termina nodo:224   */

      /* Empieza nodo:246 / Elemento padre: 212   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(212)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).setAttribute("colspan","4" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(248)).setAttribute("src","b.gif" );
      ((Element)v.get(248)).setAttribute("width","8" );
      ((Element)v.get(248)).setAttribute("height","8" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */
      /* Termina nodo:246   */
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:51   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:249 / Elemento padre: 44   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(250)).setAttribute("src","b.gif" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */
      /* Termina nodo:44   */

      /* Empieza nodo:251 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(253)).setAttribute("src","b.gif" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */

      /* Empieza nodo:254 / Elemento padre: 251   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(254)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("table"));
      ((Element)v.get(256)).setAttribute("width","100%" );
      ((Element)v.get(256)).setAttribute("border","0" );
      ((Element)v.get(256)).setAttribute("align","center" );
      ((Element)v.get(256)).setAttribute("cellspacing","0" );
      ((Element)v.get(256)).setAttribute("cellpadding","0" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).setAttribute("class","botonera" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(259)).setAttribute("nombre","btnGenerarInforme" );
      ((Element)v.get(259)).setAttribute("ID","botonContenido" );
      ((Element)v.get(259)).setAttribute("tipo","html" );
      ((Element)v.get(259)).setAttribute("accion","generar();" );
      ((Element)v.get(259)).setAttribute("estado","false" );
      ((Element)v.get(259)).setAttribute("cod","2495" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */

      /* Empieza nodo:260 / Elemento padre: 258   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(260)).setAttribute("nombre","btnGenerarExcel" );
      ((Element)v.get(260)).setAttribute("ID","botonContenido" );
      ((Element)v.get(260)).setAttribute("tipo","html" );
      ((Element)v.get(260)).setAttribute("accion","generar('xls');" );
      ((Element)v.get(260)).setAttribute("estado","false" );
      ((Element)v.get(260)).setAttribute("cod","2526" );
      ((Element)v.get(260)).setAttribute("ontab","focaliza('Formulario.cbMarca');" );
      ((Element)v.get(258)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:258   */
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:255   */
      /* Termina nodo:254   */

      /* Empieza nodo:261 / Elemento padre: 251   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(262)).setAttribute("src","b.gif" );
      ((Element)v.get(262)).setAttribute("width","8" );
      ((Element)v.get(262)).setAttribute("height","12" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */
      /* Termina nodo:251   */

      /* Empieza nodo:263 / Elemento padre: 36   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(36)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(264)).setAttribute("width","12" );
      ((Element)v.get(264)).setAttribute("align","center" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(265)).setAttribute("src","b.gif" );
      ((Element)v.get(265)).setAttribute("width","12" );
      ((Element)v.get(265)).setAttribute("height","12" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */

      /* Empieza nodo:266 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).setAttribute("width","756" );
      ((Element)v.get(263)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(267)).setAttribute("src","b.gif" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:268 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(268)).setAttribute("width","12" );
      ((Element)v.get(263)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(269)).setAttribute("src","b.gif" );
      ((Element)v.get(269)).setAttribute("width","12" );
      ((Element)v.get(269)).setAttribute("height","1" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */
      /* Termina nodo:263   */
      /* Termina nodo:36   */
      /* Termina nodo:35   */

      /* Empieza nodo:270 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(270)).setAttribute("nombre","capaRegion" );
      ((Element)v.get(270)).setAttribute("alto","3" );
      ((Element)v.get(270)).setAttribute("ancho","624" );
      ((Element)v.get(270)).setAttribute("colorf","" );
      ((Element)v.get(270)).setAttribute("borde","0" );
      ((Element)v.get(270)).setAttribute("imagenf","" );
      ((Element)v.get(270)).setAttribute("repeat","" );
      ((Element)v.get(270)).setAttribute("padding","" );
      ((Element)v.get(270)).setAttribute("visibilidad","visible" );
      ((Element)v.get(270)).setAttribute("contravsb","" );
      ((Element)v.get(270)).setAttribute("x","0" );
      ((Element)v.get(270)).setAttribute("y","165" );
      ((Element)v.get(270)).setAttribute("zindex","" );
      ((Element)v.get(13)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(271)).setAttribute("seleccion","boton" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(271)).setAttribute("nombre","lstRegion" );
      ((Element)v.get(271)).setAttribute("x","12" );
      ((Element)v.get(271)).setAttribute("y","10" );
      ((Element)v.get(271)).setAttribute("ancho","600" );
      ((Element)v.get(271)).setAttribute("alto","3" );
      ((Element)v.get(271)).setAttribute("multisel","-1" );
      ((Element)v.get(271)).setAttribute("incy","10" );
      ((Element)v.get(271)).setAttribute("incx","10" );
      ((Element)v.get(271)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(271)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(271)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(271)).setAttribute("accion","" );
      ((Element)v.get(271)).setAttribute("sep","|" );
      ((Element)v.get(271)).setAttribute("pixelsborde","2" );
      ((Element)v.get(271)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(272)).setAttribute("nombre","cab1" );
      ((Element)v.get(272)).setAttribute("height","20" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(273)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(273)).setAttribute("ancho","40" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Elemento padre:273 / Elemento actual: 274   */
      v.add(doc.createTextNode("Region"));
      ((Element)v.get(273)).appendChild((Text)v.get(274));

      /* Termina nodo Texto:274   */
      /* Termina nodo:273   */

      /* Empieza nodo:275 / Elemento padre: 272   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(275)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(275)).setAttribute("ancho","60" );
      ((Element)v.get(272)).appendChild((Element)v.get(275));

      /* Elemento padre:275 / Elemento actual: 276   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(275)).appendChild((Text)v.get(276));

      /* Termina nodo Texto:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:277 / Elemento padre: 272   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(277)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(277)).setAttribute("ancho","440" );
      ((Element)v.get(272)).appendChild((Element)v.get(277));

      /* Elemento padre:277 / Elemento actual: 278   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(277)).appendChild((Text)v.get(278));

      /* Termina nodo Texto:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:279 / Elemento padre: 272   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(279)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(279)).setAttribute("ancho","440" );
      ((Element)v.get(272)).appendChild((Element)v.get(279));

      /* Elemento padre:279 / Elemento actual: 280   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(279)).appendChild((Text)v.get(280));

      /* Termina nodo Texto:280   */
      /* Termina nodo:279   */
      /* Termina nodo:272   */

      /* Empieza nodo:281 / Elemento padre: 271   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(281)).setAttribute("ancho","590" );
      ((Element)v.get(281)).setAttribute("filas","1" );
      ((Element)v.get(281)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(271)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(282)).setAttribute("ancho","40" );
      ((Element)v.get(282)).setAttribute("caracteres","20" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */

      /* Empieza nodo:283 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(283)).setAttribute("ancho","60" );
      ((Element)v.get(283)).setAttribute("caracteres","20" );
      ((Element)v.get(281)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */

      /* Empieza nodo:284 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(284)).setAttribute("ancho","440" );
      ((Element)v.get(284)).setAttribute("caracteres","30" );
      ((Element)v.get(281)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */

      /* Empieza nodo:285 / Elemento padre: 281   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(285)).setAttribute("ancho","440" );
      ((Element)v.get(285)).setAttribute("caracteres","30" );
      ((Element)v.get(281)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:281   */

      /* Empieza nodo:286 / Elemento padre: 271   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(271)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:271   */
      /* Termina nodo:270   */

      /* Empieza nodo:287 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(287)).setAttribute("nombre","capaZona" );
      ((Element)v.get(287)).setAttribute("alto","3" );
      ((Element)v.get(287)).setAttribute("ancho","624" );
      ((Element)v.get(287)).setAttribute("colorf","" );
      ((Element)v.get(287)).setAttribute("borde","0" );
      ((Element)v.get(287)).setAttribute("imagenf","" );
      ((Element)v.get(287)).setAttribute("repeat","" );
      ((Element)v.get(287)).setAttribute("padding","" );
      ((Element)v.get(287)).setAttribute("visibilidad","visible" );
      ((Element)v.get(287)).setAttribute("contravsb","" );
      ((Element)v.get(287)).setAttribute("x","0" );
      ((Element)v.get(287)).setAttribute("y","165" );
      ((Element)v.get(287)).setAttribute("zindex","" );
      ((Element)v.get(13)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(288)).setAttribute("seleccion","boton" );
      ((Element)v.get(288)).setAttribute("nombre","lstZona" );
      ((Element)v.get(288)).setAttribute("x","12" );
      ((Element)v.get(288)).setAttribute("y","10" );
      ((Element)v.get(288)).setAttribute("ancho","600" );
      ((Element)v.get(288)).setAttribute("alto","3" );
      ((Element)v.get(288)).setAttribute("multisel","-1" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(288)).setAttribute("incy","10" );
      ((Element)v.get(288)).setAttribute("incx","10" );
      ((Element)v.get(288)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(288)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(288)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(288)).setAttribute("accion","" );
      ((Element)v.get(288)).setAttribute("sep","|" );
      ((Element)v.get(288)).setAttribute("pixelsborde","2" );
      ((Element)v.get(288)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(289)).setAttribute("nombre","cab1" );
      ((Element)v.get(289)).setAttribute("height","20" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(290)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(290)).setAttribute("ancho","40" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));

      /* Elemento padre:290 / Elemento actual: 291   */
      v.add(doc.createTextNode("Zona"));
      ((Element)v.get(290)).appendChild((Text)v.get(291));

      /* Termina nodo Texto:291   */
      /* Termina nodo:290   */

      /* Empieza nodo:292 / Elemento padre: 289   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(292)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(292)).setAttribute("ancho","40" );
      ((Element)v.get(289)).appendChild((Element)v.get(292));

      /* Elemento padre:292 / Elemento actual: 293   */
      v.add(doc.createTextNode("Region"));
      ((Element)v.get(292)).appendChild((Text)v.get(293));

      /* Termina nodo Texto:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:294 / Elemento padre: 289   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(294)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(294)).setAttribute("ancho","60" );
      ((Element)v.get(289)).appendChild((Element)v.get(294));

      /* Elemento padre:294 / Elemento actual: 295   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(294)).appendChild((Text)v.get(295));

      /* Termina nodo Texto:295   */
      /* Termina nodo:294   */

      /* Empieza nodo:296 / Elemento padre: 289   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(296)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(296)).setAttribute("ancho","440" );
      ((Element)v.get(289)).appendChild((Element)v.get(296));

      /* Elemento padre:296 / Elemento actual: 297   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(296)).appendChild((Text)v.get(297));

      /* Termina nodo Texto:297   */
      /* Termina nodo:296   */

      /* Empieza nodo:298 / Elemento padre: 289   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(298)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(298)).setAttribute("ancho","440" );
      ((Element)v.get(289)).appendChild((Element)v.get(298));

      /* Elemento padre:298 / Elemento actual: 299   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(298)).appendChild((Text)v.get(299));

      /* Termina nodo Texto:299   */
      /* Termina nodo:298   */
      /* Termina nodo:289   */

      /* Empieza nodo:300 / Elemento padre: 288   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(300)).setAttribute("ancho","590" );
      ((Element)v.get(300)).setAttribute("filas","1" );
      ((Element)v.get(300)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(288)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(301)).setAttribute("ancho","40" );
      ((Element)v.get(301)).setAttribute("caracteres","20" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */

      /* Empieza nodo:302 / Elemento padre: 300   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(302)).setAttribute("ancho","60" );
      ((Element)v.get(302)).setAttribute("caracteres","20" );
      ((Element)v.get(300)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */

      /* Empieza nodo:303 / Elemento padre: 300   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(303)).setAttribute("ancho","440" );
      ((Element)v.get(303)).setAttribute("caracteres","30" );
      ((Element)v.get(300)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */

      /* Empieza nodo:304 / Elemento padre: 300   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(304)).setAttribute("ancho","440" );
      ((Element)v.get(304)).setAttribute("caracteres","30" );
      ((Element)v.get(300)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */

      /* Empieza nodo:305 / Elemento padre: 300   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(305)).setAttribute("ancho","440" );
      ((Element)v.get(305)).setAttribute("caracteres","30" );
      ((Element)v.get(300)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:300   */

      /* Empieza nodo:306 / Elemento padre: 288   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(288)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:288   */
      /* Termina nodo:287   */

      /* Empieza nodo:307 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(307)).setAttribute("nombre","capaZona" );
      ((Element)v.get(307)).setAttribute("alto","3" );
      ((Element)v.get(307)).setAttribute("ancho","624" );
      ((Element)v.get(307)).setAttribute("colorf","" );
      ((Element)v.get(307)).setAttribute("borde","0" );
      ((Element)v.get(307)).setAttribute("imagenf","" );
      ((Element)v.get(307)).setAttribute("repeat","" );
      ((Element)v.get(307)).setAttribute("padding","" );
      ((Element)v.get(307)).setAttribute("visibilidad","visible" );
      ((Element)v.get(307)).setAttribute("contravsb","" );
      ((Element)v.get(307)).setAttribute("x","0" );
      ((Element)v.get(307)).setAttribute("y","165" );
      ((Element)v.get(307)).setAttribute("zindex","" );
      ((Element)v.get(13)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(308)).setAttribute("seleccion","boton" );
      ((Element)v.get(308)).setAttribute("nombre","lstSecciones" );
      ((Element)v.get(308)).setAttribute("x","12" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(308)).setAttribute("y","10" );
      ((Element)v.get(308)).setAttribute("ancho","600" );
      ((Element)v.get(308)).setAttribute("alto","3" );
      ((Element)v.get(308)).setAttribute("multisel","-1" );
      ((Element)v.get(308)).setAttribute("incy","10" );
      ((Element)v.get(308)).setAttribute("incx","10" );
      ((Element)v.get(308)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(308)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(308)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(308)).setAttribute("accion","" );
      ((Element)v.get(308)).setAttribute("sep","|" );
      ((Element)v.get(308)).setAttribute("pixelsborde","2" );
      ((Element)v.get(308)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(309)).setAttribute("nombre","cab1" );
      ((Element)v.get(309)).setAttribute("height","20" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(310)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(310)).setAttribute("ancho","40" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));

      /* Elemento padre:310 / Elemento actual: 311   */
      v.add(doc.createTextNode("Zona"));
      ((Element)v.get(310)).appendChild((Text)v.get(311));

      /* Termina nodo Texto:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:312 / Elemento padre: 309   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(312)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(312)).setAttribute("ancho","40" );
      ((Element)v.get(309)).appendChild((Element)v.get(312));

      /* Elemento padre:312 / Elemento actual: 313   */
      v.add(doc.createTextNode("Seccion"));
      ((Element)v.get(312)).appendChild((Text)v.get(313));

      /* Termina nodo Texto:313   */
      /* Termina nodo:312   */

      /* Empieza nodo:314 / Elemento padre: 309   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(314)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(314)).setAttribute("ancho","60" );
      ((Element)v.get(309)).appendChild((Element)v.get(314));

      /* Elemento padre:314 / Elemento actual: 315   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(314)).appendChild((Text)v.get(315));

      /* Termina nodo Texto:315   */
      /* Termina nodo:314   */
      /* Termina nodo:309   */

      /* Empieza nodo:316 / Elemento padre: 308   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(316)).setAttribute("ancho","590" );
      ((Element)v.get(316)).setAttribute("filas","1" );
      ((Element)v.get(316)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(308)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(317)).setAttribute("ancho","40" );
      ((Element)v.get(317)).setAttribute("caracteres","20" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */

      /* Empieza nodo:318 / Elemento padre: 316   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(318)).setAttribute("ancho","60" );
      ((Element)v.get(318)).setAttribute("caracteres","20" );
      ((Element)v.get(316)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */

      /* Empieza nodo:319 / Elemento padre: 316   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(319)).setAttribute("ancho","440" );
      ((Element)v.get(319)).setAttribute("caracteres","30" );
      ((Element)v.get(316)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */
      /* Termina nodo:316   */

      /* Empieza nodo:320 / Elemento padre: 308   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(308)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:308   */
      /* Termina nodo:307   */
      /* Termina nodo:13   */


   }

}

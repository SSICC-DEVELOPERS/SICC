
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_producto_buscar_perf  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_producto_buscar_perf" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("cod","0150" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag()" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","UtilidadesDefinirOferta.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","contenido_producto_buscar_perf.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(8)).setAttribute("nombre","frmContenido" );
      ((Element)v.get(0)).appendChild((Element)v.get(8));

      /* Empieza nodo:9 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(11)).setAttribute("valor","LPBuscarProductoPerf" );
      ((Element)v.get(8)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","accion" );
      ((Element)v.get(12)).setAttribute("valor","buscar" );
      ((Element)v.get(8)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","oidCabeceraMF" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","oidEstrategia" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","oidPais" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","oidIdioma" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","oidAcceso" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","oidSubacceso" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","varCbMarca" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","varCbLineaProducto" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","varCbUnNegocio" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","varCbNegocio" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","varCbGenerico" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","varCbSuperGenerico" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","vartxtCodSAP" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","vartxtDescripcion" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","vartxtPagDesde" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","vartxtPagHasta" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","mostrarValoresAdicionales" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","multiseleccion" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","listado2STR" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","SICC_TOOLBAR_CONFIG" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","DES_CORT" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","oidCatalogo" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","descripcionCatalogo" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","mmat" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","flag" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 8   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","flag2" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(8)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(40)).setAttribute("nombre","capaContenido" );
      ((Element)v.get(40)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(40)).setAttribute("borde","0" );
      ((Element)v.get(40)).setAttribute("imagenf","" );
      ((Element)v.get(40)).setAttribute("repeat","" );
      ((Element)v.get(40)).setAttribute("padding","" );
      ((Element)v.get(40)).setAttribute("visibilidad","" );
      ((Element)v.get(40)).setAttribute("contravsb","" );
      ((Element)v.get(40)).setAttribute("x","0" );
      ((Element)v.get(40)).setAttribute("y","0" );
      ((Element)v.get(40)).setAttribute("zindex","" );
      ((Element)v.get(8)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("table"));
      ((Element)v.get(41)).setAttribute("width","100%" );
      ((Element)v.get(41)).setAttribute("border","0" );
      ((Element)v.get(41)).setAttribute("cellspacing","0" );
      ((Element)v.get(41)).setAttribute("cellpadding","0" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(43)).setAttribute("width","12" );
      ((Element)v.get(43)).setAttribute("align","center" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).setAttribute("width","12" );
      ((Element)v.get(44)).setAttribute("height","12" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(45)).setAttribute("width","750" );
      ((Element)v.get(42)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(47)).setAttribute("width","12" );
      ((Element)v.get(42)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(48)).setAttribute("src","b.gif" );
      ((Element)v.get(48)).setAttribute("width","12" );
      ((Element)v.get(48)).setAttribute("height","1" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */
      /* Termina nodo:42   */

      /* Empieza nodo:49 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(54)).setAttribute("class","legend" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(55)).setAttribute("nombre","lblCriterios" );
      ((Element)v.get(55)).setAttribute("alto","13" );
      ((Element)v.get(55)).setAttribute("filas","1" );
      ((Element)v.get(55)).setAttribute("valor","Datos Búsqueda" );
      ((Element)v.get(55)).setAttribute("id","legend" );
      ((Element)v.get(55)).setAttribute("cod","0075" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 53   */
      v.add(doc.createElement("table"));
      ((Element)v.get(56)).setAttribute("width","100%" );
      ((Element)v.get(56)).setAttribute("border","0" );
      ((Element)v.get(56)).setAttribute("align","center" );
      ((Element)v.get(56)).setAttribute("cellspacing","0" );
      ((Element)v.get(56)).setAttribute("cellpadding","0" );
      ((Element)v.get(53)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).setAttribute("colspan","4" );
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
      ((Element)v.get(64)).setAttribute("nombre","lblCodSAP" );
      ((Element)v.get(64)).setAttribute("alto","13" );
      ((Element)v.get(64)).setAttribute("filas","1" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(64)).setAttribute("id","datosTitle" );
      ((Element)v.get(64)).setAttribute("cod","585" );
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
      ((Element)v.get(68)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(68)).setAttribute("alto","13" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(68)).setAttribute("filas","1" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(68)).setAttribute("id","datosTitle" );
      ((Element)v.get(68)).setAttribute("cod","9" );
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
      ((Element)v.get(72)).setAttribute("nombre","lblCatalogo" );
      ((Element)v.get(72)).setAttribute("alto","13" );
      ((Element)v.get(72)).setAttribute("filas","1" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(72)).setAttribute("id","datosTitle" );
      ((Element)v.get(72)).setAttribute("cod","516" );
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
      ((Element)v.get(76)).setAttribute("nombre","lblPagDesde" );
      ((Element)v.get(76)).setAttribute("alto","13" );
      ((Element)v.get(76)).setAttribute("filas","1" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(76)).setAttribute("id","datosTitle" );
      ((Element)v.get(76)).setAttribute("cod","512" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","25" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(60)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(80)).setAttribute("nombre","lblPagHasta" );
      ((Element)v.get(80)).setAttribute("alto","13" );
      ((Element)v.get(80)).setAttribute("filas","1" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(80)).setAttribute("id","datosTitle" );
      ((Element)v.get(80)).setAttribute("cod","513" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 60   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).setAttribute("width","100%" );
      ((Element)v.get(60)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","8" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:60   */

      /* Empieza nodo:83 / Elemento padre: 56   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(56)).appendChild((Element)v.get(83));

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
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(87)).setAttribute("nombre","txtCodSAP" );
      ((Element)v.get(87)).setAttribute("id","datosCampos" );
      ((Element)v.get(87)).setAttribute("max","20" );
      ((Element)v.get(87)).setAttribute("tipo","" );
      ((Element)v.get(87)).setAttribute("onchange","" );
      ((Element)v.get(87)).setAttribute("req","N" );
      ((Element)v.get(87)).setAttribute("size","22" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(87)).setAttribute("validacion","" );
      ((Element)v.get(87)).setAttribute("onshtab"," focalizaTxtCodSAPOnShTab();" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","25" );
      ((Element)v.get(89)).setAttribute("height","8" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(83)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(91)).setAttribute("nombre","txtDescripcion" );
      ((Element)v.get(91)).setAttribute("id","datosCampos" );
      ((Element)v.get(91)).setAttribute("max","40" );
      ((Element)v.get(91)).setAttribute("tipo","" );
      ((Element)v.get(91)).setAttribute("onchange","" );
      ((Element)v.get(91)).setAttribute("req","N" );
      ((Element)v.get(91)).setAttribute("size","44" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(91)).setAttribute("validacion","" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","25" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(83)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(95)).setAttribute("nombre","cbCatalogo" );
      ((Element)v.get(95)).setAttribute("id","datosCampos" );
      ((Element)v.get(95)).setAttribute("size","1" );
      ((Element)v.get(95)).setAttribute("multiple","N" );
      ((Element)v.get(95)).setAttribute("req","N" );
      ((Element)v.get(95)).setAttribute("valorinicial","" );
      ((Element)v.get(95)).setAttribute("textoinicial","" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:97 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).setAttribute("width","25" );
      ((Element)v.get(98)).setAttribute("height","8" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(83)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(100)).setAttribute("nombre","txtPagDesde" );
      ((Element)v.get(100)).setAttribute("id","datosCampos" );
      ((Element)v.get(100)).setAttribute("max","3" );
      ((Element)v.get(100)).setAttribute("tipo","" );
      ((Element)v.get(100)).setAttribute("onchange","" );
      ((Element)v.get(100)).setAttribute("req","N" );
      ((Element)v.get(100)).setAttribute("size","3" );
      ((Element)v.get(100)).setAttribute("valor","" );
      ((Element)v.get(100)).setAttribute("validacion","" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).setAttribute("width","25" );
      ((Element)v.get(102)).setAttribute("height","8" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(83)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(104)).setAttribute("nombre","txtPagHasta" );
      ((Element)v.get(104)).setAttribute("id","datosCampos" );
      ((Element)v.get(104)).setAttribute("max","3" );
      ((Element)v.get(104)).setAttribute("tipo","" );
      ((Element)v.get(104)).setAttribute("onchange","" );
      ((Element)v.get(104)).setAttribute("req","N" );
      ((Element)v.get(104)).setAttribute("size","3" );
      ((Element)v.get(104)).setAttribute("valor","" );
      ((Element)v.get(104)).setAttribute("validacion","" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).setAttribute("width","100%" );
      ((Element)v.get(83)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","8" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:83   */

      /* Empieza nodo:107 / Elemento padre: 56   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(56)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).setAttribute("colspan","4" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","8" );
      ((Element)v.get(109)).setAttribute("height","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:56   */

      /* Empieza nodo:110 / Elemento padre: 53   */
      v.add(doc.createElement("table"));
      ((Element)v.get(110)).setAttribute("width","100%" );
      ((Element)v.get(110)).setAttribute("border","0" );
      ((Element)v.get(110)).setAttribute("align","center" );
      ((Element)v.get(110)).setAttribute("cellspacing","0" );
      ((Element)v.get(110)).setAttribute("cellpadding","0" );
      ((Element)v.get(53)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).setAttribute("width","8" );
      ((Element)v.get(113)).setAttribute("height","8" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(115)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(115)).setAttribute("alto","13" );
      ((Element)v.get(115)).setAttribute("filas","1" );
      ((Element)v.get(115)).setAttribute("valor","" );
      ((Element)v.get(115)).setAttribute("id","datosTitle" );
      ((Element)v.get(115)).setAttribute("cod","6" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","25" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(119)).setAttribute("nombre","lblLineaProducto" );
      ((Element)v.get(119)).setAttribute("alto","13" );
      ((Element)v.get(119)).setAttribute("filas","1" );
      ((Element)v.get(119)).setAttribute("valor","" );
      ((Element)v.get(119)).setAttribute("id","datosTitle" );
      ((Element)v.get(119)).setAttribute("cod","586" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 111   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).setAttribute("width","100%" );
      ((Element)v.get(111)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","8" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:111   */

      /* Empieza nodo:122 / Elemento padre: 110   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(110)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","8" );
      ((Element)v.get(124)).setAttribute("height","8" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(122)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(126)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(126)).setAttribute("id","datosCampos" );
      ((Element)v.get(126)).setAttribute("size","1" );
      ((Element)v.get(126)).setAttribute("multiple","N" );
      ((Element)v.get(126)).setAttribute("req","N" );
      ((Element)v.get(126)).setAttribute("valorinicial","" );
      ((Element)v.get(126)).setAttribute("textoinicial"," " );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:128 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","25" );
      ((Element)v.get(129)).setAttribute("height","8" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(130)).setAttribute("style","width:80px" );
      ((Element)v.get(122)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(131)).setAttribute("nombre","cbLineaProducto" );
      ((Element)v.get(131)).setAttribute("id","datosCampos" );
      ((Element)v.get(131)).setAttribute("max","50" );
      ((Element)v.get(131)).setAttribute("readonly","true" );
      ((Element)v.get(131)).setAttribute("tipo","" );
      ((Element)v.get(131)).setAttribute("onchange","" );
      ((Element)v.get(131)).setAttribute("req","N" );
      ((Element)v.get(131)).setAttribute("size","50" );
      ((Element)v.get(131)).setAttribute("valor","" );
      ((Element)v.get(131)).setAttribute("validacion","" );
      ((Element)v.get(131)).setAttribute("onshtab","" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).setAttribute("width","100%" );
      ((Element)v.get(122)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(133)).setAttribute("nombre","btnBuscarLProdu" );
      ((Element)v.get(133)).setAttribute("ID","botonContenido" );
      ((Element)v.get(133)).setAttribute("tipo","html" );
      ((Element)v.get(133)).setAttribute("estado","false" );
      ((Element)v.get(133)).setAttribute("cod","1" );
      ((Element)v.get(133)).setAttribute("accion","buscarLineaProducto();" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:122   */

      /* Empieza nodo:134 / Elemento padre: 110   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(110)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).setAttribute("colspan","4" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","8" );
      ((Element)v.get(136)).setAttribute("height","8" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:110   */

      /* Empieza nodo:137 / Elemento padre: 53   */
      v.add(doc.createElement("table"));
      ((Element)v.get(137)).setAttribute("width","100%" );
      ((Element)v.get(137)).setAttribute("border","0" );
      ((Element)v.get(137)).setAttribute("align","center" );
      ((Element)v.get(137)).setAttribute("cellspacing","0" );
      ((Element)v.get(137)).setAttribute("cellpadding","0" );
      ((Element)v.get(53)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(137)).appendChild((Element)v.get(138));

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
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(142)).setAttribute("nombre","lblUniNegocio" );
      ((Element)v.get(142)).setAttribute("alto","13" );
      ((Element)v.get(142)).setAttribute("filas","1" );
      ((Element)v.get(142)).setAttribute("valor","" );
      ((Element)v.get(142)).setAttribute("id","datosTitle" );
      ((Element)v.get(142)).setAttribute("cod","587" );
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
      ((Element)v.get(138)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(146)).setAttribute("nombre","lblNegocio" );
      ((Element)v.get(146)).setAttribute("alto","13" );
      ((Element)v.get(146)).setAttribute("filas","1" );
      ((Element)v.get(146)).setAttribute("valor","" );
      ((Element)v.get(146)).setAttribute("id","datosTitle" );
      ((Element)v.get(146)).setAttribute("cod","588" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:147 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).setAttribute("width","100%" );
      ((Element)v.get(138)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).setAttribute("width","8" );
      ((Element)v.get(148)).setAttribute("height","8" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:138   */

      /* Empieza nodo:149 / Elemento padre: 137   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(137)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).setAttribute("width","8" );
      ((Element)v.get(151)).setAttribute("height","8" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(149)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(153)).setAttribute("nombre","cbUniNegocio" );
      ((Element)v.get(153)).setAttribute("id","datosCampos" );
      ((Element)v.get(153)).setAttribute("size","1" );
      ((Element)v.get(153)).setAttribute("multiple","N" );
      ((Element)v.get(153)).setAttribute("req","N" );
      ((Element)v.get(153)).setAttribute("valorinicial","" );
      ((Element)v.get(153)).setAttribute("textoinicial"," " );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:155 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","25" );
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(149)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(158)).setAttribute("nombre","cbNegocio" );
      ((Element)v.get(158)).setAttribute("id","datosCampos" );
      ((Element)v.get(158)).setAttribute("size","1" );
      ((Element)v.get(158)).setAttribute("multiple","N" );
      ((Element)v.get(158)).setAttribute("req","N" );
      ((Element)v.get(158)).setAttribute("valorinicial","" );
      ((Element)v.get(158)).setAttribute("textoinicial"," " );
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:160 / Elemento padre: 149   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).setAttribute("width","100%" );
      ((Element)v.get(149)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).setAttribute("width","8" );
      ((Element)v.get(161)).setAttribute("height","8" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:149   */

      /* Empieza nodo:162 / Elemento padre: 137   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(137)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).setAttribute("colspan","4" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","8" );
      ((Element)v.get(164)).setAttribute("height","8" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:137   */

      /* Empieza nodo:165 / Elemento padre: 53   */
      v.add(doc.createElement("table"));
      ((Element)v.get(165)).setAttribute("width","100%" );
      ((Element)v.get(165)).setAttribute("border","0" );
      ((Element)v.get(165)).setAttribute("align","center" );
      ((Element)v.get(165)).setAttribute("cellspacing","0" );
      ((Element)v.get(165)).setAttribute("cellpadding","0" );
      ((Element)v.get(53)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","8" );
      ((Element)v.get(168)).setAttribute("height","8" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(170)).setAttribute("nombre","lblGenerico" );
      ((Element)v.get(170)).setAttribute("alto","13" );
      ((Element)v.get(170)).setAttribute("filas","1" );
      ((Element)v.get(170)).setAttribute("valor","" );
      ((Element)v.get(170)).setAttribute("id","datosTitle" );
      ((Element)v.get(170)).setAttribute("cod","589" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
   }

   private void getXML720(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).setAttribute("width","25" );
      ((Element)v.get(172)).setAttribute("height","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(174)).setAttribute("nombre","lblSupergenerico" );
      ((Element)v.get(174)).setAttribute("alto","13" );
      ((Element)v.get(174)).setAttribute("filas","1" );
      ((Element)v.get(174)).setAttribute("valor","" );
      ((Element)v.get(174)).setAttribute("id","datosTitle" );
      ((Element)v.get(174)).setAttribute("cod","590" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).setAttribute("width","100%" );
      ((Element)v.get(166)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(176)).setAttribute("src","b.gif" );
      ((Element)v.get(176)).setAttribute("width","8" );
      ((Element)v.get(176)).setAttribute("height","8" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */
      /* Termina nodo:166   */

      /* Empieza nodo:177 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(177));

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
      ((Element)v.get(180)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(177)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(181)).setAttribute("nombre","cbGenerico" );
      ((Element)v.get(181)).setAttribute("id","datosCampos" );
      ((Element)v.get(181)).setAttribute("max","30" );
      ((Element)v.get(181)).setAttribute("readonly","true" );
      ((Element)v.get(181)).setAttribute("tipo","" );
      ((Element)v.get(181)).setAttribute("onchange","" );
      ((Element)v.get(181)).setAttribute("req","N" );
      ((Element)v.get(181)).setAttribute("size","40" );
      ((Element)v.get(181)).setAttribute("valor","" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(183)).setAttribute("nombre","btnBuscarGenerico" );
      ((Element)v.get(183)).setAttribute("ID","botonContenido" );
      ((Element)v.get(183)).setAttribute("tipo","html" );
      ((Element)v.get(183)).setAttribute("estado","false" );
      ((Element)v.get(183)).setAttribute("cod","1" );
      ((Element)v.get(183)).setAttribute("accion","buscarGenerico();" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */

      /* Empieza nodo:184 / Elemento padre: 182   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","25" );
      ((Element)v.get(184)).setAttribute("height","8" );
      ((Element)v.get(182)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:182   */

      /* Empieza nodo:185 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(177)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(186)).setAttribute("nombre","cbSupergenerico" );
      ((Element)v.get(186)).setAttribute("id","datosCampos" );
      ((Element)v.get(186)).setAttribute("max","30" );
      ((Element)v.get(186)).setAttribute("readonly","true" );
      ((Element)v.get(186)).setAttribute("tipo","" );
      ((Element)v.get(186)).setAttribute("onchange","" );
      ((Element)v.get(186)).setAttribute("req","N" );
      ((Element)v.get(186)).setAttribute("size","40" );
      ((Element)v.get(186)).setAttribute("valor","" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).setAttribute("width","100%" );
      ((Element)v.get(177)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(188)).setAttribute("nombre","btnBuscarSuperGenerico" );
      ((Element)v.get(188)).setAttribute("ID","botonContenido" );
      ((Element)v.get(188)).setAttribute("tipo","html" );
      ((Element)v.get(188)).setAttribute("estado","false" );
      ((Element)v.get(188)).setAttribute("cod","1" );
      ((Element)v.get(188)).setAttribute("accion","buscarSuperGenerico();" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */
      /* Termina nodo:177   */

      /* Empieza nodo:189 / Elemento padre: 165   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(165)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).setAttribute("colspan","4" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(191)).setAttribute("src","b.gif" );
      ((Element)v.get(191)).setAttribute("width","8" );
      ((Element)v.get(191)).setAttribute("height","8" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */
      /* Termina nodo:189   */
      /* Termina nodo:165   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:192 / Elemento padre: 49   */
      v.add(doc.createElement("td"));
      ((Element)v.get(49)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:49   */

      /* Empieza nodo:194 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("table"));
      ((Element)v.get(199)).setAttribute("width","100%" );
      ((Element)v.get(199)).setAttribute("border","0" );
      ((Element)v.get(199)).setAttribute("align","center" );
      ((Element)v.get(199)).setAttribute("cellspacing","0" );
      ((Element)v.get(199)).setAttribute("cellpadding","0" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).setAttribute("class","botonera" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(202)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(202)).setAttribute("ID","botonContenido" );
      ((Element)v.get(202)).setAttribute("tipo","html" );
      ((Element)v.get(202)).setAttribute("estado","false" );
      ((Element)v.get(202)).setAttribute("cod","1" );
      ((Element)v.get(202)).setAttribute("accion","botonBuscar();" );
      ((Element)v.get(202)).setAttribute("ontab","focalizaBotonTab();" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:203 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).setAttribute("width","8" );
      ((Element)v.get(204)).setAttribute("height","12" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */
      /* Termina nodo:194   */

      /* Empieza nodo:205 / Elemento padre: 41   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(41)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(206)).setAttribute("width","12" );
      ((Element)v.get(206)).setAttribute("align","center" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(207)).setAttribute("src","b.gif" );
      ((Element)v.get(207)).setAttribute("width","12" );
      ((Element)v.get(207)).setAttribute("height","12" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).setAttribute("width","750" );
      ((Element)v.get(205)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 205   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).setAttribute("width","12" );
      ((Element)v.get(205)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(211)).setAttribute("width","12" );
      ((Element)v.get(211)).setAttribute("height","1" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:205   */
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:212 / Elemento padre: 8   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(212)).setAttribute("nombre","listado1" );
      ((Element)v.get(212)).setAttribute("ancho","664" );
      ((Element)v.get(212)).setAttribute("alto","317" );
      ((Element)v.get(212)).setAttribute("x","12" );
      ((Element)v.get(212)).setAttribute("y","241" );
      ((Element)v.get(212)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(212)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(8)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(213)).setAttribute("precarga","S" );
      ((Element)v.get(213)).setAttribute("conROver","S" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(214)).setAttribute("normal","btnLista2N.gif" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(214)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(214)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(214)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */

      /* Empieza nodo:215 / Elemento padre: 213   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(215)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(215)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(215)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(215)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(213)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */

      /* Empieza nodo:216 / Elemento padre: 213   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(216)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(216)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(213)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:213   */

      /* Empieza nodo:217 / Elemento padre: 212   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(212)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(218)).setAttribute("borde","1" );
      ((Element)v.get(218)).setAttribute("horizDatos","1" );
      ((Element)v.get(218)).setAttribute("horizCabecera","1" );
      ((Element)v.get(218)).setAttribute("vertical","1" );
      ((Element)v.get(218)).setAttribute("horizTitulo","1" );
      ((Element)v.get(218)).setAttribute("horizBase","1" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */

      /* Empieza nodo:219 / Elemento padre: 217   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(219)).setAttribute("borde","#999999" );
      ((Element)v.get(219)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(219)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(219)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(219)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(219)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(219)).setAttribute("horizBase","#999999" );
      ((Element)v.get(217)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:217   */

      /* Empieza nodo:220 / Elemento padre: 212   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(220)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(220)).setAttribute("alto","22" );
      ((Element)v.get(220)).setAttribute("imgFondo","" );
      ((Element)v.get(220)).setAttribute("cod","00135" );
      ((Element)v.get(220)).setAttribute("ID","datosTitle" );
      ((Element)v.get(212)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */

      /* Empieza nodo:221 / Elemento padre: 212   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(221)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(221)).setAttribute("alto","22" );
      ((Element)v.get(221)).setAttribute("imgFondo","" );
      ((Element)v.get(212)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */

      /* Empieza nodo:222 / Elemento padre: 212   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(222)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(222)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(222)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(222)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(222)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(222)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(212)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(223)).setAttribute("ancho","100" );
      ((Element)v.get(223)).setAttribute("minimizable","S" );
      ((Element)v.get(223)).setAttribute("minimizada","N" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */

      /* Empieza nodo:224 / Elemento padre: 222   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(224)).setAttribute("ancho","100" );
      ((Element)v.get(224)).setAttribute("minimizable","S" );
      ((Element)v.get(224)).setAttribute("minimizada","N" );
      ((Element)v.get(222)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */

      /* Empieza nodo:225 / Elemento padre: 222   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(225)).setAttribute("ancho","100" );
      ((Element)v.get(225)).setAttribute("minimizable","S" );
      ((Element)v.get(225)).setAttribute("minimizada","N" );
      ((Element)v.get(222)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */

      /* Empieza nodo:226 / Elemento padre: 222   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(226)).setAttribute("ancho","100" );
      ((Element)v.get(226)).setAttribute("minimizable","S" );
      ((Element)v.get(226)).setAttribute("minimizada","N" );
      ((Element)v.get(222)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */

      /* Empieza nodo:227 / Elemento padre: 222   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(227)).setAttribute("ancho","100" );
      ((Element)v.get(227)).setAttribute("minimizable","S" );
      ((Element)v.get(227)).setAttribute("minimizada","N" );
      ((Element)v.get(222)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */

      /* Empieza nodo:228 / Elemento padre: 222   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(228)).setAttribute("ancho","100" );
      ((Element)v.get(228)).setAttribute("minimizable","S" );
      ((Element)v.get(228)).setAttribute("minimizada","N" );
      ((Element)v.get(222)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */

      /* Empieza nodo:229 / Elemento padre: 222   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(229)).setAttribute("ancho","100" );
      ((Element)v.get(229)).setAttribute("minimizable","S" );
      ((Element)v.get(229)).setAttribute("minimizada","N" );
      ((Element)v.get(222)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */

      /* Empieza nodo:230 / Elemento padre: 222   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(230)).setAttribute("ancho","100" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(230)).setAttribute("minimizable","S" );
      ((Element)v.get(230)).setAttribute("minimizada","N" );
      ((Element)v.get(222)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */

      /* Empieza nodo:231 / Elemento padre: 222   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(231)).setAttribute("ancho","100" );
      ((Element)v.get(231)).setAttribute("minimizable","S" );
      ((Element)v.get(231)).setAttribute("minimizada","N" );
      ((Element)v.get(222)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */

      /* Empieza nodo:232 / Elemento padre: 222   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(232)).setAttribute("ancho","0" );
      ((Element)v.get(232)).setAttribute("minimizable","S" );
      ((Element)v.get(232)).setAttribute("minimizada","S" );
      ((Element)v.get(222)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */

      /* Empieza nodo:233 / Elemento padre: 222   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(233)).setAttribute("ancho","0" );
      ((Element)v.get(233)).setAttribute("minimizable","S" );
      ((Element)v.get(233)).setAttribute("minimizada","S" );
      ((Element)v.get(222)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */

      /* Empieza nodo:234 / Elemento padre: 222   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(234)).setAttribute("ancho","0" );
      ((Element)v.get(234)).setAttribute("minimizable","S" );
      ((Element)v.get(234)).setAttribute("minimizada","S" );
      ((Element)v.get(222)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */

      /* Empieza nodo:235 / Elemento padre: 222   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(235)).setAttribute("ancho","0" );
      ((Element)v.get(235)).setAttribute("minimizable","S" );
      ((Element)v.get(235)).setAttribute("minimizada","S" );
      ((Element)v.get(222)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */

      /* Empieza nodo:236 / Elemento padre: 222   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(236)).setAttribute("ancho","0" );
      ((Element)v.get(236)).setAttribute("minimizable","S" );
      ((Element)v.get(236)).setAttribute("minimizada","S" );
      ((Element)v.get(222)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */

      /* Empieza nodo:237 / Elemento padre: 222   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(237)).setAttribute("ancho","0" );
      ((Element)v.get(237)).setAttribute("minimizable","S" );
      ((Element)v.get(237)).setAttribute("minimizada","S" );
      ((Element)v.get(222)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */

      /* Empieza nodo:238 / Elemento padre: 222   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(238)).setAttribute("ancho","0" );
      ((Element)v.get(238)).setAttribute("minimizable","S" );
      ((Element)v.get(238)).setAttribute("minimizada","S" );
      ((Element)v.get(222)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */

      /* Empieza nodo:239 / Elemento padre: 222   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(239)).setAttribute("ancho","0" );
      ((Element)v.get(239)).setAttribute("minimizable","S" );
      ((Element)v.get(239)).setAttribute("minimizada","S" );
      ((Element)v.get(222)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */

      /* Empieza nodo:240 / Elemento padre: 222   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(240)).setAttribute("ancho","0" );
      ((Element)v.get(240)).setAttribute("minimizable","S" );
      ((Element)v.get(240)).setAttribute("minimizada","S" );
      ((Element)v.get(222)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */

      /* Empieza nodo:241 / Elemento padre: 222   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(241)).setAttribute("ancho","0" );
      ((Element)v.get(241)).setAttribute("minimizable","S" );
      ((Element)v.get(241)).setAttribute("minimizada","S" );
      ((Element)v.get(222)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */

      /* Empieza nodo:242 / Elemento padre: 222   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(242)).setAttribute("ancho","0" );
      ((Element)v.get(242)).setAttribute("minimizable","S" );
      ((Element)v.get(242)).setAttribute("minimizada","S" );
      ((Element)v.get(222)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */

      /* Empieza nodo:243 / Elemento padre: 222   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(243)).setAttribute("ancho","0" );
      ((Element)v.get(243)).setAttribute("minimizable","S" );
      ((Element)v.get(243)).setAttribute("minimizada","S" );
      ((Element)v.get(222)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */

      /* Empieza nodo:244 / Elemento padre: 222   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(244)).setAttribute("ancho","0" );
      ((Element)v.get(244)).setAttribute("minimizable","S" );
      ((Element)v.get(244)).setAttribute("minimizada","S" );
      ((Element)v.get(222)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */

      /* Empieza nodo:245 / Elemento padre: 222   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(245)).setAttribute("ancho","0" );
      ((Element)v.get(245)).setAttribute("minimizable","S" );
      ((Element)v.get(245)).setAttribute("minimizada","S" );
      ((Element)v.get(222)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */

      /* Empieza nodo:246 / Elemento padre: 222   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(246)).setAttribute("ancho","0" );
      ((Element)v.get(246)).setAttribute("minimizable","S" );
      ((Element)v.get(246)).setAttribute("minimizada","S" );
      ((Element)v.get(222)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */

      /* Empieza nodo:247 / Elemento padre: 222   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(247)).setAttribute("ancho","0" );
      ((Element)v.get(247)).setAttribute("minimizable","S" );
      ((Element)v.get(247)).setAttribute("minimizada","S" );
      ((Element)v.get(222)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:222   */

      /* Empieza nodo:248 / Elemento padre: 212   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(248)).setAttribute("alto","20" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(248)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(248)).setAttribute("imgFondo","" );
      ((Element)v.get(248)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(212)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(249)).setAttribute("colFondo","" );
      ((Element)v.get(249)).setAttribute("ID","EstCab" );
      ((Element)v.get(249)).setAttribute("cod","337" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));

      /* Elemento padre:249 / Elemento actual: 250   */
      v.add(doc.createTextNode("Cód. producto"));
      ((Element)v.get(249)).appendChild((Text)v.get(250));

      /* Termina nodo Texto:250   */
      /* Termina nodo:249   */

      /* Empieza nodo:251 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(251)).setAttribute("colFondo","" );
      ((Element)v.get(251)).setAttribute("ID","EstCab" );
      ((Element)v.get(251)).setAttribute("cod","9" );
      ((Element)v.get(248)).appendChild((Element)v.get(251));

      /* Elemento padre:251 / Elemento actual: 252   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(251)).appendChild((Text)v.get(252));

      /* Termina nodo Texto:252   */
      /* Termina nodo:251   */

      /* Empieza nodo:253 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(253)).setAttribute("colFondo","" );
      ((Element)v.get(253)).setAttribute("ID","EstCab" );
      ((Element)v.get(253)).setAttribute("cod","503" );
      ((Element)v.get(248)).appendChild((Element)v.get(253));

      /* Elemento padre:253 / Elemento actual: 254   */
      v.add(doc.createTextNode("Precio catálogo"));
      ((Element)v.get(253)).appendChild((Text)v.get(254));

      /* Termina nodo Texto:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:255 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(255)).setAttribute("colFondo","" );
      ((Element)v.get(255)).setAttribute("ID","EstCab" );
      ((Element)v.get(255)).setAttribute("cod","592" );
      ((Element)v.get(248)).appendChild((Element)v.get(255));

      /* Elemento padre:255 / Elemento actual: 256   */
      v.add(doc.createTextNode("Página"));
      ((Element)v.get(255)).appendChild((Text)v.get(256));

      /* Termina nodo Texto:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:257 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(257)).setAttribute("colFondo","" );
      ((Element)v.get(257)).setAttribute("ID","EstCab" );
      ((Element)v.get(257)).setAttribute("cod","608" );
      ((Element)v.get(248)).appendChild((Element)v.get(257));

      /* Elemento padre:257 / Elemento actual: 258   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(257)).appendChild((Text)v.get(258));

      /* Termina nodo Texto:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:259 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(259)).setAttribute("colFondo","" );
      ((Element)v.get(259)).setAttribute("ID","EstCab" );
      ((Element)v.get(259)).setAttribute("cod","581" );
      ((Element)v.get(248)).appendChild((Element)v.get(259));

      /* Elemento padre:259 / Elemento actual: 260   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(259)).appendChild((Text)v.get(260));

      /* Termina nodo Texto:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:261 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(261)).setAttribute("colFondo","" );
      ((Element)v.get(261)).setAttribute("ID","EstCab" );
      ((Element)v.get(261)).setAttribute("cod","481" );
      ((Element)v.get(248)).appendChild((Element)v.get(261));

      /* Elemento padre:261 / Elemento actual: 262   */
      v.add(doc.createTextNode("Atributo 1"));
      ((Element)v.get(261)).appendChild((Text)v.get(262));

      /* Termina nodo Texto:262   */
      /* Termina nodo:261   */

      /* Empieza nodo:263 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(263)).setAttribute("colFondo","" );
      ((Element)v.get(263)).setAttribute("ID","EstCab" );
      ((Element)v.get(263)).setAttribute("cod","482" );
      ((Element)v.get(248)).appendChild((Element)v.get(263));

      /* Elemento padre:263 / Elemento actual: 264   */
      v.add(doc.createTextNode("Atributo 2"));
      ((Element)v.get(263)).appendChild((Text)v.get(264));

      /* Termina nodo Texto:264   */
      /* Termina nodo:263   */

      /* Empieza nodo:265 / Elemento padre: 248   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(265)).setAttribute("colFondo","" );
      ((Element)v.get(265)).setAttribute("ID","EstCab" );
      ((Element)v.get(265)).setAttribute("cod","483" );
      ((Element)v.get(248)).appendChild((Element)v.get(265));

      /* Elemento padre:265 / Elemento actual: 266   */
      v.add(doc.createTextNode("Atributo 3"));
      ((Element)v.get(265)).appendChild((Text)v.get(266));

      /* Termina nodo Texto:266   */
      /* Termina nodo:265   */
      /* Termina nodo:248   */

      /* Empieza nodo:267 / Elemento padre: 212   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(267)).setAttribute("alto","22" );
      ((Element)v.get(267)).setAttribute("accion","" );
      ((Element)v.get(267)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(267)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(267)).setAttribute("maxSel","-1" );
      ((Element)v.get(267)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(267)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(267)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(267)).setAttribute("onLoad","" );
      ((Element)v.get(267)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(212)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(268)).setAttribute("tipo","texto" );
      ((Element)v.get(268)).setAttribute("ID","EstDat" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */

      /* Empieza nodo:269 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(269)).setAttribute("tipo","texto" );
      ((Element)v.get(269)).setAttribute("ID","EstDat2" );
      ((Element)v.get(267)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */

      /* Empieza nodo:270 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(270)).setAttribute("tipo","texto" );
      ((Element)v.get(270)).setAttribute("ID","EstDat" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(267)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */

      /* Empieza nodo:271 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(271)).setAttribute("tipo","texto" );
      ((Element)v.get(271)).setAttribute("ID","EstDat2" );
      ((Element)v.get(267)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */

      /* Empieza nodo:272 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(272)).setAttribute("tipo","texto" );
      ((Element)v.get(272)).setAttribute("ID","EstDat2" );
      ((Element)v.get(267)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */

      /* Empieza nodo:273 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(273)).setAttribute("tipo","texto" );
      ((Element)v.get(273)).setAttribute("ID","EstDat" );
      ((Element)v.get(267)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */

      /* Empieza nodo:274 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(274)).setAttribute("tipo","texto" );
      ((Element)v.get(274)).setAttribute("ID","EstDat2" );
      ((Element)v.get(267)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */

      /* Empieza nodo:275 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(275)).setAttribute("tipo","texto" );
      ((Element)v.get(275)).setAttribute("ID","EstDat" );
      ((Element)v.get(267)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */

      /* Empieza nodo:276 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(276)).setAttribute("tipo","texto" );
      ((Element)v.get(276)).setAttribute("ID","EstDat2" );
      ((Element)v.get(267)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */

      /* Empieza nodo:277 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(277)).setAttribute("tipo","texto" );
      ((Element)v.get(277)).setAttribute("ID","EstDat" );
      ((Element)v.get(267)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */

      /* Empieza nodo:278 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(278)).setAttribute("tipo","texto" );
      ((Element)v.get(278)).setAttribute("ID","EstDat2" );
      ((Element)v.get(267)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */

      /* Empieza nodo:279 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(279)).setAttribute("tipo","texto" );
      ((Element)v.get(279)).setAttribute("ID","EstDat" );
      ((Element)v.get(267)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */

      /* Empieza nodo:280 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(280)).setAttribute("tipo","texto" );
      ((Element)v.get(280)).setAttribute("ID","EstDat2" );
      ((Element)v.get(267)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */

      /* Empieza nodo:281 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(281)).setAttribute("tipo","texto" );
      ((Element)v.get(281)).setAttribute("ID","EstDat" );
      ((Element)v.get(267)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */

      /* Empieza nodo:282 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(282)).setAttribute("tipo","texto" );
      ((Element)v.get(282)).setAttribute("ID","EstDat2" );
      ((Element)v.get(267)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */

      /* Empieza nodo:283 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(283)).setAttribute("tipo","texto" );
      ((Element)v.get(283)).setAttribute("ID","EstDat" );
      ((Element)v.get(267)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */

      /* Empieza nodo:284 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(284)).setAttribute("tipo","texto" );
      ((Element)v.get(284)).setAttribute("ID","EstDat2" );
      ((Element)v.get(267)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */

      /* Empieza nodo:285 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(285)).setAttribute("tipo","texto" );
      ((Element)v.get(285)).setAttribute("ID","EstDat" );
      ((Element)v.get(267)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */

      /* Empieza nodo:286 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(286)).setAttribute("tipo","texto" );
      ((Element)v.get(286)).setAttribute("ID","EstDat2" );
      ((Element)v.get(267)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */

      /* Empieza nodo:287 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(287)).setAttribute("tipo","texto" );
      ((Element)v.get(287)).setAttribute("ID","EstDat" );
      ((Element)v.get(267)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */

      /* Empieza nodo:288 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(288)).setAttribute("tipo","texto" );
      ((Element)v.get(288)).setAttribute("ID","EstDat2" );
      ((Element)v.get(267)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */

      /* Empieza nodo:289 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(289)).setAttribute("tipo","texto" );
      ((Element)v.get(289)).setAttribute("ID","EstDat" );
      ((Element)v.get(267)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */

      /* Empieza nodo:290 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(290)).setAttribute("tipo","texto" );
      ((Element)v.get(290)).setAttribute("ID","EstDat2" );
      ((Element)v.get(267)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */

      /* Empieza nodo:291 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(291)).setAttribute("tipo","texto" );
      ((Element)v.get(291)).setAttribute("ID","EstDat" );
      ((Element)v.get(267)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */

      /* Empieza nodo:292 / Elemento padre: 267   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(292)).setAttribute("tipo","texto" );
      ((Element)v.get(292)).setAttribute("ID","EstDat2" );
      ((Element)v.get(267)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:267   */

      /* Empieza nodo:293 / Elemento padre: 212   */
      v.add(doc.createElement("ROWSET"));
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(212)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */

      /* Empieza nodo:294 / Elemento padre: 212   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(294)).setAttribute("nombre","mipgndo1" );
      ((Element)v.get(294)).setAttribute("ancho","664" );
      ((Element)v.get(294)).setAttribute("sep","$" );
      ((Element)v.get(294)).setAttribute("x","12" );
      ((Element)v.get(294)).setAttribute("class","botonera" );
      ((Element)v.get(294)).setAttribute("y","535" );
      ((Element)v.get(294)).setAttribute("control","|" );
      ((Element)v.get(294)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(294)).setAttribute("rowset","" );
      ((Element)v.get(294)).setAttribute("cargainicial","N" );
      ((Element)v.get(294)).setAttribute("onload","prueba(msgError, ultima, rowset);" );
      ((Element)v.get(212)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(295)).setAttribute("nombre","ret1" );
      ((Element)v.get(295)).setAttribute("x","37" );
      ((Element)v.get(295)).setAttribute("y","539" );
      ((Element)v.get(295)).setAttribute("ID","botonContenido" );
      ((Element)v.get(295)).setAttribute("img","retroceder_on" );
      ((Element)v.get(295)).setAttribute("tipo","0" );
      ((Element)v.get(295)).setAttribute("estado","false" );
      ((Element)v.get(295)).setAttribute("alt","" );
      ((Element)v.get(295)).setAttribute("codigo","" );
      ((Element)v.get(295)).setAttribute("accion","mipgndo1.retroceder();" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */

      /* Empieza nodo:296 / Elemento padre: 294   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(296)).setAttribute("nombre","ava1" );
      ((Element)v.get(296)).setAttribute("x","52" );
      ((Element)v.get(296)).setAttribute("y","539" );
      ((Element)v.get(296)).setAttribute("ID","botonContenido" );
      ((Element)v.get(296)).setAttribute("img","avanzar_on" );
      ((Element)v.get(296)).setAttribute("tipo","0" );
      ((Element)v.get(296)).setAttribute("estado","false" );
      ((Element)v.get(296)).setAttribute("alt","" );
      ((Element)v.get(296)).setAttribute("codigo","" );
      ((Element)v.get(296)).setAttribute("accion","mipgndo1.avanzar();" );
      ((Element)v.get(294)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:294   */
      /* Termina nodo:212   */

      /* Empieza nodo:297 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(297)).setAttribute("nombre","primera1" );
      ((Element)v.get(297)).setAttribute("x","20" );
      ((Element)v.get(297)).setAttribute("y","539" );
      ((Element)v.get(297)).setAttribute("ID","botonContenido" );
      ((Element)v.get(297)).setAttribute("img","primera_on" );
      ((Element)v.get(297)).setAttribute("tipo","-2" );
      ((Element)v.get(297)).setAttribute("estado","false" );
      ((Element)v.get(297)).setAttribute("alt","" );
      ((Element)v.get(297)).setAttribute("codigo","" );
      ((Element)v.get(297)).setAttribute("accion","mipgndo1.retrocederPrimeraPagina();" );
      ((Element)v.get(8)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */

      /* Empieza nodo:298 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(298)).setAttribute("nombre","separa1" );
      ((Element)v.get(298)).setAttribute("x","59" );
      ((Element)v.get(298)).setAttribute("y","535" );
      ((Element)v.get(298)).setAttribute("ID","botonContenido" );
      ((Element)v.get(298)).setAttribute("img","separa_base" );
      ((Element)v.get(298)).setAttribute("tipo","0" );
      ((Element)v.get(298)).setAttribute("estado","false" );
      ((Element)v.get(298)).setAttribute("alt","" );
      ((Element)v.get(298)).setAttribute("codigo","" );
      ((Element)v.get(298)).setAttribute("accion","" );
      ((Element)v.get(8)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */

      /* Empieza nodo:299 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(299)).setAttribute("nombre","Anadir" );
      ((Element)v.get(299)).setAttribute("x","80" );
      ((Element)v.get(299)).setAttribute("y","536" );
      ((Element)v.get(299)).setAttribute("ID","botonContenido" );
      ((Element)v.get(299)).setAttribute("tipo","html" );
      ((Element)v.get(299)).setAttribute("estado","false" );
      ((Element)v.get(299)).setAttribute("cod","404" );
      ((Element)v.get(299)).setAttribute("accion","botonAniadirBis();" );
      ((Element)v.get(299)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnBuscar');" );
      ((Element)v.get(299)).setAttribute("ontab","focalizaBotonHTML('botonContenido','Eliminar');" );
      ((Element)v.get(8)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */

      /* Empieza nodo:300 / Elemento padre: 8   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(300)).setAttribute("nombre","listado3" );
      ((Element)v.get(300)).setAttribute("ancho","664" );
      ((Element)v.get(300)).setAttribute("alto","317" );
      ((Element)v.get(300)).setAttribute("x","12" );
      ((Element)v.get(300)).setAttribute("y","241" );
      ((Element)v.get(300)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(300)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(8)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(301)).setAttribute("precarga","S" );
      ((Element)v.get(301)).setAttribute("conROver","S" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(302)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(302)).setAttribute("rollOver","btnLista2S.gif" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(302)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(302)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */

      /* Empieza nodo:303 / Elemento padre: 301   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(303)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(303)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(303)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(303)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(301)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */

      /* Empieza nodo:304 / Elemento padre: 301   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(304)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(304)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(301)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:301   */

      /* Empieza nodo:305 / Elemento padre: 300   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(300)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(306)).setAttribute("borde","1" );
      ((Element)v.get(306)).setAttribute("horizDatos","1" );
      ((Element)v.get(306)).setAttribute("horizCabecera","1" );
      ((Element)v.get(306)).setAttribute("vertical","1" );
      ((Element)v.get(306)).setAttribute("horizTitulo","1" );
      ((Element)v.get(306)).setAttribute("horizBase","1" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */

      /* Empieza nodo:307 / Elemento padre: 305   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(307)).setAttribute("borde","#999999" );
      ((Element)v.get(307)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(307)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(307)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(307)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(307)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(307)).setAttribute("horizBase","#999999" );
      ((Element)v.get(305)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:305   */

      /* Empieza nodo:308 / Elemento padre: 300   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(308)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(308)).setAttribute("alto","22" );
      ((Element)v.get(308)).setAttribute("imgFondo","" );
      ((Element)v.get(308)).setAttribute("cod","00135" );
      ((Element)v.get(308)).setAttribute("ID","datosTitle" );
      ((Element)v.get(300)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */

      /* Empieza nodo:309 / Elemento padre: 300   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(309)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(309)).setAttribute("alto","22" );
      ((Element)v.get(309)).setAttribute("imgFondo","" );
      ((Element)v.get(300)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */

      /* Empieza nodo:310 / Elemento padre: 300   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(310)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(310)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(310)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(310)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(310)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(310)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(300)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(311)).setAttribute("ancho","100" );
      ((Element)v.get(311)).setAttribute("minimizable","S" );
      ((Element)v.get(311)).setAttribute("minimizada","N" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */

      /* Empieza nodo:312 / Elemento padre: 310   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(312)).setAttribute("ancho","100" );
      ((Element)v.get(312)).setAttribute("minimizable","S" );
      ((Element)v.get(312)).setAttribute("minimizada","N" );
      ((Element)v.get(312)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(310)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */

      /* Empieza nodo:313 / Elemento padre: 310   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(313)).setAttribute("ancho","100" );
      ((Element)v.get(313)).setAttribute("minimizable","S" );
      ((Element)v.get(313)).setAttribute("minimizada","N" );
      ((Element)v.get(310)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */

      /* Empieza nodo:314 / Elemento padre: 310   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(314)).setAttribute("ancho","100" );
      ((Element)v.get(314)).setAttribute("minimizable","S" );
      ((Element)v.get(314)).setAttribute("minimizada","N" );
      ((Element)v.get(310)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */

      /* Empieza nodo:315 / Elemento padre: 310   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(315)).setAttribute("ancho","100" );
      ((Element)v.get(315)).setAttribute("minimizable","S" );
      ((Element)v.get(315)).setAttribute("minimizada","N" );
      ((Element)v.get(315)).setAttribute("orden","numerico" );
      ((Element)v.get(310)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */

      /* Empieza nodo:316 / Elemento padre: 310   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(316)).setAttribute("ancho","100" );
      ((Element)v.get(316)).setAttribute("minimizable","S" );
      ((Element)v.get(316)).setAttribute("minimizada","N" );
      ((Element)v.get(310)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */

      /* Empieza nodo:317 / Elemento padre: 310   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(317)).setAttribute("ancho","100" );
      ((Element)v.get(317)).setAttribute("minimizable","S" );
      ((Element)v.get(317)).setAttribute("minimizada","N" );
      ((Element)v.get(317)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(310)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */

      /* Empieza nodo:318 / Elemento padre: 310   */
   }

   private void getXML1440(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(318)).setAttribute("ancho","100" );
      ((Element)v.get(318)).setAttribute("minimizable","S" );
      ((Element)v.get(318)).setAttribute("minimizada","N" );
      ((Element)v.get(310)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */

      /* Empieza nodo:319 / Elemento padre: 310   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(319)).setAttribute("ancho","0" );
      ((Element)v.get(319)).setAttribute("minimizable","S" );
      ((Element)v.get(319)).setAttribute("minimizada","S" );
      ((Element)v.get(319)).setAttribute("oculta","S" );
      ((Element)v.get(310)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */

      /* Empieza nodo:320 / Elemento padre: 310   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(320)).setAttribute("ancho","0" );
      ((Element)v.get(320)).setAttribute("minimizable","S" );
      ((Element)v.get(320)).setAttribute("minimizada","S" );
      ((Element)v.get(320)).setAttribute("oculta","S" );
      ((Element)v.get(310)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:310   */

      /* Empieza nodo:321 / Elemento padre: 300   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(321)).setAttribute("alto","20" );
      ((Element)v.get(321)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(321)).setAttribute("imgFondo","" );
      ((Element)v.get(321)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(300)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(322)).setAttribute("colFondo","" );
      ((Element)v.get(322)).setAttribute("ID","EstCab" );
      ((Element)v.get(322)).setAttribute("align","center" );
      ((Element)v.get(322)).setAttribute("cod","337" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));

      /* Elemento padre:322 / Elemento actual: 323   */
      v.add(doc.createTextNode("Cód. producto"));
      ((Element)v.get(322)).appendChild((Text)v.get(323));

      /* Termina nodo Texto:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:324 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(324)).setAttribute("colFondo","" );
      ((Element)v.get(324)).setAttribute("ID","EstCab" );
      ((Element)v.get(324)).setAttribute("cod","9" );
      ((Element)v.get(321)).appendChild((Element)v.get(324));

      /* Elemento padre:324 / Elemento actual: 325   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(324)).appendChild((Text)v.get(325));

      /* Termina nodo Texto:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:326 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(326)).setAttribute("colFondo","" );
      ((Element)v.get(326)).setAttribute("ID","EstCab" );
      ((Element)v.get(326)).setAttribute("cod","503" );
      ((Element)v.get(321)).appendChild((Element)v.get(326));

      /* Elemento padre:326 / Elemento actual: 327   */
      v.add(doc.createTextNode("Precio catálogo"));
      ((Element)v.get(326)).appendChild((Text)v.get(327));

      /* Termina nodo Texto:327   */
      /* Termina nodo:326   */

      /* Empieza nodo:328 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(328)).setAttribute("colFondo","" );
      ((Element)v.get(328)).setAttribute("ID","EstCab" );
      ((Element)v.get(328)).setAttribute("cod","592" );
      ((Element)v.get(321)).appendChild((Element)v.get(328));

      /* Elemento padre:328 / Elemento actual: 329   */
      v.add(doc.createTextNode("Precio Posicionamiento"));
      ((Element)v.get(328)).appendChild((Text)v.get(329));

      /* Termina nodo Texto:329   */
      /* Termina nodo:328   */

      /* Empieza nodo:330 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(330)).setAttribute("colFondo","" );
      ((Element)v.get(330)).setAttribute("ID","EstCab" );
      ((Element)v.get(330)).setAttribute("cod","608" );
      ((Element)v.get(321)).appendChild((Element)v.get(330));

      /* Elemento padre:330 / Elemento actual: 331   */
      v.add(doc.createTextNode("Costo Estandard"));
      ((Element)v.get(330)).appendChild((Text)v.get(331));

      /* Termina nodo Texto:331   */
      /* Termina nodo:330   */

      /* Empieza nodo:332 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(332)).setAttribute("colFondo","" );
      ((Element)v.get(332)).setAttribute("ID","EstCab" );
      ((Element)v.get(332)).setAttribute("cod","481" );
      ((Element)v.get(321)).appendChild((Element)v.get(332));

      /* Elemento padre:332 / Elemento actual: 333   */
      v.add(doc.createTextNode("Atributo 1"));
      ((Element)v.get(332)).appendChild((Text)v.get(333));

      /* Termina nodo Texto:333   */
      /* Termina nodo:332   */

      /* Empieza nodo:334 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(334)).setAttribute("colFondo","" );
      ((Element)v.get(334)).setAttribute("ID","EstCab" );
      ((Element)v.get(334)).setAttribute("cod","482" );
      ((Element)v.get(321)).appendChild((Element)v.get(334));

      /* Elemento padre:334 / Elemento actual: 335   */
      v.add(doc.createTextNode("Atributo 2"));
      ((Element)v.get(334)).appendChild((Text)v.get(335));

      /* Termina nodo Texto:335   */
      /* Termina nodo:334   */

      /* Empieza nodo:336 / Elemento padre: 321   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(336)).setAttribute("colFondo","" );
      ((Element)v.get(336)).setAttribute("ID","EstCab" );
      ((Element)v.get(336)).setAttribute("cod","483" );
      ((Element)v.get(321)).appendChild((Element)v.get(336));

      /* Elemento padre:336 / Elemento actual: 337   */
      v.add(doc.createTextNode("Atributo 3"));
      ((Element)v.get(336)).appendChild((Text)v.get(337));

      /* Termina nodo Texto:337   */
      /* Termina nodo:336   */
      /* Termina nodo:321   */

      /* Empieza nodo:338 / Elemento padre: 300   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(338)).setAttribute("alto","22" );
      ((Element)v.get(338)).setAttribute("accion","" );
      ((Element)v.get(338)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(338)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(338)).setAttribute("maxSel","-1" );
      ((Element)v.get(338)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(338)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(338)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(338)).setAttribute("onLoad","" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(338)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(300)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(339)).setAttribute("tipo","texto" );
      ((Element)v.get(339)).setAttribute("ID","EstDat" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */

      /* Empieza nodo:340 / Elemento padre: 338   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(340)).setAttribute("tipo","texto" );
      ((Element)v.get(340)).setAttribute("ID","EstDat2" );
      ((Element)v.get(338)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */

      /* Empieza nodo:341 / Elemento padre: 338   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(341)).setAttribute("tipo","texto" );
      ((Element)v.get(341)).setAttribute("ID","EstDat" );
      ((Element)v.get(338)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */

      /* Empieza nodo:342 / Elemento padre: 338   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(342)).setAttribute("tipo","texto" );
      ((Element)v.get(342)).setAttribute("ID","EstDat2" );
      ((Element)v.get(338)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */

      /* Empieza nodo:343 / Elemento padre: 338   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(343)).setAttribute("tipo","texto" );
      ((Element)v.get(343)).setAttribute("ID","EstDat" );
      ((Element)v.get(338)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */

      /* Empieza nodo:344 / Elemento padre: 338   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(344)).setAttribute("tipo","texto" );
      ((Element)v.get(344)).setAttribute("ID","EstDat2" );
      ((Element)v.get(338)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */

      /* Empieza nodo:345 / Elemento padre: 338   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(345)).setAttribute("tipo","texto" );
      ((Element)v.get(345)).setAttribute("ID","EstDat" );
      ((Element)v.get(338)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */

      /* Empieza nodo:346 / Elemento padre: 338   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(346)).setAttribute("tipo","texto" );
      ((Element)v.get(346)).setAttribute("ID","EstDat2" );
      ((Element)v.get(338)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */

      /* Empieza nodo:347 / Elemento padre: 338   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(347)).setAttribute("tipo","texto" );
      ((Element)v.get(347)).setAttribute("ID","EstDat" );
      ((Element)v.get(338)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */

      /* Empieza nodo:348 / Elemento padre: 338   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(348)).setAttribute("tipo","texto" );
      ((Element)v.get(348)).setAttribute("ID","EstDat2" );
      ((Element)v.get(338)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:338   */

      /* Empieza nodo:349 / Elemento padre: 300   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(300)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */

      /* Empieza nodo:350 / Elemento padre: 300   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(350)).setAttribute("nombre","mipgndo3" );
      ((Element)v.get(350)).setAttribute("ancho","664" );
      ((Element)v.get(350)).setAttribute("sep","$" );
      ((Element)v.get(350)).setAttribute("x","12" );
      ((Element)v.get(350)).setAttribute("class","botonera" );
      ((Element)v.get(350)).setAttribute("y","535" );
      ((Element)v.get(350)).setAttribute("control","|" );
      ((Element)v.get(350)).setAttribute("conector","conector_victor" );
      ((Element)v.get(350)).setAttribute("rowset","" );
      ((Element)v.get(350)).setAttribute("cargainicial","N" );
      ((Element)v.get(350)).setAttribute("onload","procesarPaginado(mipgndo3,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(300)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(351)).setAttribute("nombre","ret3" );
      ((Element)v.get(351)).setAttribute("x","37" );
      ((Element)v.get(351)).setAttribute("y","539" );
      ((Element)v.get(351)).setAttribute("ID","botonContenido" );
      ((Element)v.get(351)).setAttribute("img","retroceder_on" );
      ((Element)v.get(351)).setAttribute("tipo","1" );
      ((Element)v.get(351)).setAttribute("estado","false" );
      ((Element)v.get(351)).setAttribute("alt","" );
      ((Element)v.get(351)).setAttribute("codigo","" );
      ((Element)v.get(351)).setAttribute("accion","mipgndo3.retroceder();" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */

      /* Empieza nodo:352 / Elemento padre: 350   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(352)).setAttribute("nombre","ava3" );
      ((Element)v.get(352)).setAttribute("x","52" );
      ((Element)v.get(352)).setAttribute("y","539" );
      ((Element)v.get(352)).setAttribute("ID","botonContenido" );
      ((Element)v.get(352)).setAttribute("img","avanzar_on" );
      ((Element)v.get(352)).setAttribute("tipo","1" );
      ((Element)v.get(352)).setAttribute("estado","false" );
      ((Element)v.get(352)).setAttribute("alt","" );
      ((Element)v.get(352)).setAttribute("codigo","" );
      ((Element)v.get(352)).setAttribute("accion","mipgndo3.avanzar();" );
      ((Element)v.get(350)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */
      /* Termina nodo:350   */
      /* Termina nodo:300   */

      /* Empieza nodo:353 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(353)).setAttribute("nombre","AnadirMae" );
      ((Element)v.get(353)).setAttribute("x","80" );
      ((Element)v.get(353)).setAttribute("y","536" );
      ((Element)v.get(353)).setAttribute("ID","botonContenido" );
      ((Element)v.get(353)).setAttribute("tipo","html" );
      ((Element)v.get(353)).setAttribute("estado","false" );
      ((Element)v.get(353)).setAttribute("cod","404" );
      ((Element)v.get(353)).setAttribute("accion","botonAniadirBis();" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(353)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnBuscar');" );
      ((Element)v.get(353)).setAttribute("ontab","focalizaBotonHTML('botonContenido','Eliminar');" );
      ((Element)v.get(8)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */

      /* Empieza nodo:354 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(354)).setAttribute("nombre","prim3" );
      ((Element)v.get(354)).setAttribute("x","20" );
      ((Element)v.get(354)).setAttribute("y","539" );
      ((Element)v.get(354)).setAttribute("ID","botonContenido" );
      ((Element)v.get(354)).setAttribute("img","primera_on" );
      ((Element)v.get(354)).setAttribute("tipo","-2" );
      ((Element)v.get(354)).setAttribute("estado","false" );
      ((Element)v.get(354)).setAttribute("alt","" );
      ((Element)v.get(354)).setAttribute("codigo","" );
      ((Element)v.get(354)).setAttribute("accion","mipgndo3.retrocederPrimeraPagina();" );
      ((Element)v.get(8)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */

      /* Empieza nodo:355 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(355)).setAttribute("nombre","separa3" );
      ((Element)v.get(355)).setAttribute("x","59" );
      ((Element)v.get(355)).setAttribute("y","535" );
      ((Element)v.get(355)).setAttribute("ID","botonContenido" );
      ((Element)v.get(355)).setAttribute("img","separa_base" );
      ((Element)v.get(355)).setAttribute("tipo","0" );
      ((Element)v.get(355)).setAttribute("estado","false" );
      ((Element)v.get(355)).setAttribute("alt","" );
      ((Element)v.get(355)).setAttribute("codigo","" );
      ((Element)v.get(355)).setAttribute("accion","" );
      ((Element)v.get(8)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */

      /* Empieza nodo:356 / Elemento padre: 8   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(356)).setAttribute("nombre","listado2" );
      ((Element)v.get(356)).setAttribute("ancho","664" );
      ((Element)v.get(356)).setAttribute("alto","317" );
      ((Element)v.get(356)).setAttribute("x","12" );
      ((Element)v.get(356)).setAttribute("y","582" );
      ((Element)v.get(356)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(356)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(8)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(357)).setAttribute("precarga","S" );
      ((Element)v.get(357)).setAttribute("conROver","S" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(358)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(358)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(358)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(358)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */

      /* Empieza nodo:359 / Elemento padre: 357   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(359)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(359)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(359)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(359)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(357)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */

      /* Empieza nodo:360 / Elemento padre: 357   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(360)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(360)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(357)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:357   */

      /* Empieza nodo:361 / Elemento padre: 356   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(356)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(362)).setAttribute("borde","1" );
      ((Element)v.get(362)).setAttribute("horizDatos","1" );
      ((Element)v.get(362)).setAttribute("horizCabecera","1" );
      ((Element)v.get(362)).setAttribute("vertical","1" );
      ((Element)v.get(362)).setAttribute("horizTitulo","1" );
      ((Element)v.get(362)).setAttribute("horizBase","1" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */

      /* Empieza nodo:363 / Elemento padre: 361   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(363)).setAttribute("borde","#999999" );
      ((Element)v.get(363)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(363)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(363)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(363)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(363)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(363)).setAttribute("horizBase","#999999" );
      ((Element)v.get(361)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */
      /* Termina nodo:361   */

      /* Empieza nodo:364 / Elemento padre: 356   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(364)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(364)).setAttribute("alto","22" );
      ((Element)v.get(364)).setAttribute("imgFondo","" );
      ((Element)v.get(364)).setAttribute("cod","00499" );
      ((Element)v.get(364)).setAttribute("ID","datosTitle" );
      ((Element)v.get(356)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */

      /* Empieza nodo:365 / Elemento padre: 356   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(365)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(365)).setAttribute("alto","22" );
      ((Element)v.get(365)).setAttribute("imgFondo","" );
      ((Element)v.get(356)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */

      /* Empieza nodo:366 / Elemento padre: 356   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(366)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(366)).setAttribute("permiteOrdenar","S" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(366)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(366)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(366)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(366)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(356)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(367)).setAttribute("ancho","100" );
      ((Element)v.get(367)).setAttribute("minimizable","S" );
      ((Element)v.get(367)).setAttribute("minimizada","N" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */

      /* Empieza nodo:368 / Elemento padre: 366   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(368)).setAttribute("ancho","100" );
      ((Element)v.get(368)).setAttribute("minimizable","S" );
      ((Element)v.get(368)).setAttribute("minimizada","N" );
      ((Element)v.get(366)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */

      /* Empieza nodo:369 / Elemento padre: 366   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(369)).setAttribute("ancho","100" );
      ((Element)v.get(369)).setAttribute("minimizable","S" );
      ((Element)v.get(369)).setAttribute("minimizada","N" );
      ((Element)v.get(366)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */

      /* Empieza nodo:370 / Elemento padre: 366   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(370)).setAttribute("ancho","100" );
      ((Element)v.get(370)).setAttribute("minimizable","S" );
      ((Element)v.get(370)).setAttribute("minimizada","N" );
      ((Element)v.get(366)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */

      /* Empieza nodo:371 / Elemento padre: 366   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(371)).setAttribute("ancho","100" );
      ((Element)v.get(371)).setAttribute("minimizable","S" );
      ((Element)v.get(371)).setAttribute("minimizada","N" );
      ((Element)v.get(366)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */

      /* Empieza nodo:372 / Elemento padre: 366   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(372)).setAttribute("ancho","100" );
      ((Element)v.get(372)).setAttribute("minimizable","S" );
      ((Element)v.get(372)).setAttribute("minimizada","N" );
      ((Element)v.get(366)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */

      /* Empieza nodo:373 / Elemento padre: 366   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(373)).setAttribute("ancho","100" );
      ((Element)v.get(373)).setAttribute("minimizable","S" );
      ((Element)v.get(373)).setAttribute("minimizada","N" );
      ((Element)v.get(366)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */

      /* Empieza nodo:374 / Elemento padre: 366   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(374)).setAttribute("ancho","100" );
      ((Element)v.get(374)).setAttribute("minimizable","S" );
      ((Element)v.get(374)).setAttribute("minimizada","N" );
      ((Element)v.get(366)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */

      /* Empieza nodo:375 / Elemento padre: 366   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(375)).setAttribute("ancho","100" );
      ((Element)v.get(375)).setAttribute("minimizable","S" );
      ((Element)v.get(375)).setAttribute("minimizada","N" );
      ((Element)v.get(366)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */

      /* Empieza nodo:376 / Elemento padre: 366   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(376)).setAttribute("ancho","0" );
      ((Element)v.get(376)).setAttribute("minimizable","S" );
      ((Element)v.get(376)).setAttribute("minimizada","S" );
      ((Element)v.get(366)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */

      /* Empieza nodo:377 / Elemento padre: 366   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(377)).setAttribute("ancho","0" );
      ((Element)v.get(377)).setAttribute("minimizable","S" );
      ((Element)v.get(377)).setAttribute("minimizada","S" );
      ((Element)v.get(366)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */

      /* Empieza nodo:378 / Elemento padre: 366   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(378)).setAttribute("ancho","0" );
      ((Element)v.get(378)).setAttribute("minimizable","S" );
      ((Element)v.get(378)).setAttribute("minimizada","S" );
      ((Element)v.get(366)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */

      /* Empieza nodo:379 / Elemento padre: 366   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(379)).setAttribute("ancho","0" );
      ((Element)v.get(379)).setAttribute("minimizable","S" );
      ((Element)v.get(379)).setAttribute("minimizada","S" );
      ((Element)v.get(366)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */

      /* Empieza nodo:380 / Elemento padre: 366   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(380)).setAttribute("ancho","0" );
      ((Element)v.get(380)).setAttribute("minimizable","S" );
      ((Element)v.get(380)).setAttribute("minimizada","S" );
      ((Element)v.get(366)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */

      /* Empieza nodo:381 / Elemento padre: 366   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(381)).setAttribute("ancho","0" );
      ((Element)v.get(381)).setAttribute("minimizable","S" );
      ((Element)v.get(381)).setAttribute("minimizada","S" );
      ((Element)v.get(366)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */

      /* Empieza nodo:382 / Elemento padre: 366   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(382)).setAttribute("ancho","0" );
      ((Element)v.get(382)).setAttribute("minimizable","S" );
      ((Element)v.get(382)).setAttribute("minimizada","S" );
      ((Element)v.get(366)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */

      /* Empieza nodo:383 / Elemento padre: 366   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(383)).setAttribute("ancho","0" );
      ((Element)v.get(383)).setAttribute("minimizable","S" );
      ((Element)v.get(383)).setAttribute("minimizada","S" );
      ((Element)v.get(366)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */

      /* Empieza nodo:384 / Elemento padre: 366   */
   }

   private void getXML1800(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(384)).setAttribute("ancho","0" );
      ((Element)v.get(384)).setAttribute("minimizable","S" );
      ((Element)v.get(384)).setAttribute("minimizada","S" );
      ((Element)v.get(366)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */

      /* Empieza nodo:385 / Elemento padre: 366   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(385)).setAttribute("ancho","0" );
      ((Element)v.get(385)).setAttribute("minimizable","S" );
      ((Element)v.get(385)).setAttribute("minimizada","S" );
      ((Element)v.get(366)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */

      /* Empieza nodo:386 / Elemento padre: 366   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(386)).setAttribute("ancho","0" );
      ((Element)v.get(386)).setAttribute("minimizable","S" );
      ((Element)v.get(386)).setAttribute("minimizada","S" );
      ((Element)v.get(366)).appendChild((Element)v.get(386));
      /* Termina nodo:386   */

      /* Empieza nodo:387 / Elemento padre: 366   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(387)).setAttribute("ancho","0" );
      ((Element)v.get(387)).setAttribute("minimizable","S" );
      ((Element)v.get(387)).setAttribute("minimizada","S" );
      ((Element)v.get(366)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */

      /* Empieza nodo:388 / Elemento padre: 366   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(388)).setAttribute("ancho","0" );
      ((Element)v.get(388)).setAttribute("minimizable","S" );
      ((Element)v.get(388)).setAttribute("minimizada","S" );
      ((Element)v.get(366)).appendChild((Element)v.get(388));
      /* Termina nodo:388   */

      /* Empieza nodo:389 / Elemento padre: 366   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(389)).setAttribute("ancho","0" );
      ((Element)v.get(389)).setAttribute("minimizable","S" );
      ((Element)v.get(389)).setAttribute("minimizada","S" );
      ((Element)v.get(366)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */

      /* Empieza nodo:390 / Elemento padre: 366   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(390)).setAttribute("ancho","0" );
      ((Element)v.get(390)).setAttribute("minimizable","S" );
      ((Element)v.get(390)).setAttribute("minimizada","S" );
      ((Element)v.get(366)).appendChild((Element)v.get(390));
      /* Termina nodo:390   */

      /* Empieza nodo:391 / Elemento padre: 366   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(391)).setAttribute("ancho","0" );
      ((Element)v.get(391)).setAttribute("minimizable","S" );
      ((Element)v.get(391)).setAttribute("minimizada","S" );
      ((Element)v.get(366)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */
      /* Termina nodo:366   */

      /* Empieza nodo:392 / Elemento padre: 356   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(392)).setAttribute("alto","20" );
      ((Element)v.get(392)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(392)).setAttribute("imgFondo","" );
      ((Element)v.get(392)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(356)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(393)).setAttribute("colFondo","" );
      ((Element)v.get(393)).setAttribute("ID","EstCab" );
      ((Element)v.get(393)).setAttribute("cod","337" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));

      /* Elemento padre:393 / Elemento actual: 394   */
      v.add(doc.createTextNode("Cód. producto"));
      ((Element)v.get(393)).appendChild((Text)v.get(394));

      /* Termina nodo Texto:394   */
      /* Termina nodo:393   */

      /* Empieza nodo:395 / Elemento padre: 392   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(395)).setAttribute("colFondo","" );
      ((Element)v.get(395)).setAttribute("ID","EstCab" );
      ((Element)v.get(395)).setAttribute("cod","9" );
      ((Element)v.get(392)).appendChild((Element)v.get(395));

      /* Elemento padre:395 / Elemento actual: 396   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(395)).appendChild((Text)v.get(396));

      /* Termina nodo Texto:396   */
      /* Termina nodo:395   */

      /* Empieza nodo:397 / Elemento padre: 392   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(397)).setAttribute("colFondo","" );
      ((Element)v.get(397)).setAttribute("ID","EstCab" );
      ((Element)v.get(397)).setAttribute("cod","503" );
      ((Element)v.get(392)).appendChild((Element)v.get(397));

      /* Elemento padre:397 / Elemento actual: 398   */
      v.add(doc.createTextNode("Precio catálogo"));
      ((Element)v.get(397)).appendChild((Text)v.get(398));

      /* Termina nodo Texto:398   */
      /* Termina nodo:397   */

      /* Empieza nodo:399 / Elemento padre: 392   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(399)).setAttribute("colFondo","" );
      ((Element)v.get(399)).setAttribute("ID","EstCab" );
      ((Element)v.get(399)).setAttribute("cod","592" );
      ((Element)v.get(392)).appendChild((Element)v.get(399));

      /* Elemento padre:399 / Elemento actual: 400   */
      v.add(doc.createTextNode("Página"));
      ((Element)v.get(399)).appendChild((Text)v.get(400));

      /* Termina nodo Texto:400   */
      /* Termina nodo:399   */

      /* Empieza nodo:401 / Elemento padre: 392   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(401)).setAttribute("colFondo","" );
      ((Element)v.get(401)).setAttribute("ID","EstCab" );
      ((Element)v.get(401)).setAttribute("cod","608" );
      ((Element)v.get(392)).appendChild((Element)v.get(401));

      /* Elemento padre:401 / Elemento actual: 402   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(401)).appendChild((Text)v.get(402));

      /* Termina nodo Texto:402   */
      /* Termina nodo:401   */

      /* Empieza nodo:403 / Elemento padre: 392   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(403)).setAttribute("colFondo","" );
      ((Element)v.get(403)).setAttribute("ID","EstCab" );
      ((Element)v.get(403)).setAttribute("cod","581" );
      ((Element)v.get(392)).appendChild((Element)v.get(403));

      /* Elemento padre:403 / Elemento actual: 404   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(403)).appendChild((Text)v.get(404));

      /* Termina nodo Texto:404   */
      /* Termina nodo:403   */

      /* Empieza nodo:405 / Elemento padre: 392   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(405)).setAttribute("colFondo","" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(405)).setAttribute("ID","EstCab" );
      ((Element)v.get(405)).setAttribute("cod","481" );
      ((Element)v.get(392)).appendChild((Element)v.get(405));

      /* Elemento padre:405 / Elemento actual: 406   */
      v.add(doc.createTextNode("Atributo 1"));
      ((Element)v.get(405)).appendChild((Text)v.get(406));

      /* Termina nodo Texto:406   */
      /* Termina nodo:405   */

      /* Empieza nodo:407 / Elemento padre: 392   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(407)).setAttribute("colFondo","" );
      ((Element)v.get(407)).setAttribute("ID","EstCab" );
      ((Element)v.get(407)).setAttribute("cod","482" );
      ((Element)v.get(392)).appendChild((Element)v.get(407));

      /* Elemento padre:407 / Elemento actual: 408   */
      v.add(doc.createTextNode("Atributo 2"));
      ((Element)v.get(407)).appendChild((Text)v.get(408));

      /* Termina nodo Texto:408   */
      /* Termina nodo:407   */

      /* Empieza nodo:409 / Elemento padre: 392   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(409)).setAttribute("colFondo","" );
      ((Element)v.get(409)).setAttribute("ID","EstCab" );
      ((Element)v.get(409)).setAttribute("cod","483" );
      ((Element)v.get(392)).appendChild((Element)v.get(409));

      /* Elemento padre:409 / Elemento actual: 410   */
      v.add(doc.createTextNode("Atributo 3"));
      ((Element)v.get(409)).appendChild((Text)v.get(410));

      /* Termina nodo Texto:410   */
      /* Termina nodo:409   */
      /* Termina nodo:392   */

      /* Empieza nodo:411 / Elemento padre: 356   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(411)).setAttribute("alto","22" );
      ((Element)v.get(411)).setAttribute("accion","" );
      ((Element)v.get(411)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(411)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(411)).setAttribute("maxSel","-1" );
      ((Element)v.get(411)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(411)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(411)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(411)).setAttribute("onLoad","" );
      ((Element)v.get(411)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(356)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(412)).setAttribute("tipo","texto" );
      ((Element)v.get(412)).setAttribute("ID","EstDat" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */

      /* Empieza nodo:413 / Elemento padre: 411   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(413)).setAttribute("tipo","texto" );
      ((Element)v.get(413)).setAttribute("ID","EstDat2" );
      ((Element)v.get(411)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */

      /* Empieza nodo:414 / Elemento padre: 411   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(414)).setAttribute("tipo","texto" );
      ((Element)v.get(414)).setAttribute("ID","EstDat" );
      ((Element)v.get(411)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */

      /* Empieza nodo:415 / Elemento padre: 411   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(415)).setAttribute("tipo","texto" );
      ((Element)v.get(415)).setAttribute("ID","EstDat2" );
      ((Element)v.get(411)).appendChild((Element)v.get(415));
      /* Termina nodo:415   */

      /* Empieza nodo:416 / Elemento padre: 411   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(416)).setAttribute("tipo","texto" );
      ((Element)v.get(416)).setAttribute("ID","EstDat2" );
      ((Element)v.get(411)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */

      /* Empieza nodo:417 / Elemento padre: 411   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(417)).setAttribute("tipo","texto" );
      ((Element)v.get(417)).setAttribute("ID","EstDat" );
      ((Element)v.get(411)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */

      /* Empieza nodo:418 / Elemento padre: 411   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(418)).setAttribute("tipo","texto" );
      ((Element)v.get(418)).setAttribute("ID","EstDat2" );
      ((Element)v.get(411)).appendChild((Element)v.get(418));
      /* Termina nodo:418   */

      /* Empieza nodo:419 / Elemento padre: 411   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(419)).setAttribute("tipo","texto" );
      ((Element)v.get(419)).setAttribute("ID","EstDat" );
      ((Element)v.get(411)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */

      /* Empieza nodo:420 / Elemento padre: 411   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(420)).setAttribute("tipo","texto" );
      ((Element)v.get(420)).setAttribute("ID","EstDat2" );
      ((Element)v.get(411)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */

      /* Empieza nodo:421 / Elemento padre: 411   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(421)).setAttribute("tipo","texto" );
      ((Element)v.get(421)).setAttribute("ID","EstDat" );
      ((Element)v.get(411)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */

      /* Empieza nodo:422 / Elemento padre: 411   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(422)).setAttribute("tipo","texto" );
      ((Element)v.get(422)).setAttribute("ID","EstDat2" );
      ((Element)v.get(411)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */

      /* Empieza nodo:423 / Elemento padre: 411   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(423)).setAttribute("tipo","texto" );
      ((Element)v.get(423)).setAttribute("ID","EstDat" );
      ((Element)v.get(411)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */

      /* Empieza nodo:424 / Elemento padre: 411   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(424)).setAttribute("tipo","texto" );
      ((Element)v.get(424)).setAttribute("ID","EstDat2" );
      ((Element)v.get(411)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */

      /* Empieza nodo:425 / Elemento padre: 411   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(425)).setAttribute("tipo","texto" );
      ((Element)v.get(425)).setAttribute("ID","EstDat" );
      ((Element)v.get(411)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */

      /* Empieza nodo:426 / Elemento padre: 411   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(426)).setAttribute("tipo","texto" );
      ((Element)v.get(426)).setAttribute("ID","EstDat2" );
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(411)).appendChild((Element)v.get(426));
      /* Termina nodo:426   */

      /* Empieza nodo:427 / Elemento padre: 411   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(427)).setAttribute("tipo","texto" );
      ((Element)v.get(427)).setAttribute("ID","EstDat" );
      ((Element)v.get(411)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */

      /* Empieza nodo:428 / Elemento padre: 411   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(428)).setAttribute("tipo","texto" );
      ((Element)v.get(428)).setAttribute("ID","EstDat2" );
      ((Element)v.get(411)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */

      /* Empieza nodo:429 / Elemento padre: 411   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(429)).setAttribute("tipo","texto" );
      ((Element)v.get(429)).setAttribute("ID","EstDat" );
      ((Element)v.get(411)).appendChild((Element)v.get(429));
      /* Termina nodo:429   */

      /* Empieza nodo:430 / Elemento padre: 411   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(430)).setAttribute("tipo","texto" );
      ((Element)v.get(430)).setAttribute("ID","EstDat" );
      ((Element)v.get(411)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */

      /* Empieza nodo:431 / Elemento padre: 411   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(431)).setAttribute("tipo","texto" );
      ((Element)v.get(431)).setAttribute("ID","EstDat2" );
      ((Element)v.get(411)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */

      /* Empieza nodo:432 / Elemento padre: 411   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(432)).setAttribute("tipo","texto" );
      ((Element)v.get(432)).setAttribute("ID","EstDat" );
      ((Element)v.get(411)).appendChild((Element)v.get(432));
      /* Termina nodo:432   */

      /* Empieza nodo:433 / Elemento padre: 411   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(433)).setAttribute("tipo","texto" );
      ((Element)v.get(433)).setAttribute("ID","EstDat2" );
      ((Element)v.get(411)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */

      /* Empieza nodo:434 / Elemento padre: 411   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(434)).setAttribute("tipo","texto" );
      ((Element)v.get(434)).setAttribute("ID","EstDat" );
      ((Element)v.get(411)).appendChild((Element)v.get(434));
      /* Termina nodo:434   */

      /* Empieza nodo:435 / Elemento padre: 411   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(435)).setAttribute("tipo","texto" );
      ((Element)v.get(435)).setAttribute("ID","EstDat2" );
      ((Element)v.get(411)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */

      /* Empieza nodo:436 / Elemento padre: 411   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(436)).setAttribute("tipo","texto" );
      ((Element)v.get(436)).setAttribute("ID","EstDat" );
      ((Element)v.get(411)).appendChild((Element)v.get(436));
      /* Termina nodo:436   */
      /* Termina nodo:411   */

      /* Empieza nodo:437 / Elemento padre: 356   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(356)).appendChild((Element)v.get(437));
      /* Termina nodo:437   */

      /* Empieza nodo:438 / Elemento padre: 356   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(438)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(438)).setAttribute("ancho","664" );
      ((Element)v.get(438)).setAttribute("sep","$" );
      ((Element)v.get(438)).setAttribute("x","12" );
      ((Element)v.get(438)).setAttribute("class","botonera" );
      ((Element)v.get(438)).setAttribute("y","876" );
      ((Element)v.get(438)).setAttribute("control","|" );
      ((Element)v.get(438)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(438)).setAttribute("rowset","" );
      ((Element)v.get(438)).setAttribute("cargainicial","N" );
      ((Element)v.get(356)).appendChild((Element)v.get(438));
      /* Termina nodo:438   */
      /* Termina nodo:356   */

      /* Empieza nodo:439 / Elemento padre: 8   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(439)).setAttribute("nombre","Eliminar" );
      ((Element)v.get(439)).setAttribute("x","13" );
      ((Element)v.get(439)).setAttribute("y","877" );
      ((Element)v.get(439)).setAttribute("ID","botonContenido" );
      ((Element)v.get(439)).setAttribute("tipo","html" );
      ((Element)v.get(439)).setAttribute("estado","false" );
      ((Element)v.get(439)).setAttribute("cod","1254" );
      ((Element)v.get(439)).setAttribute("accion","botonEliminar();" );
      ((Element)v.get(439)).setAttribute("onshtab","focalizaEliminarOnShTab();" );
      ((Element)v.get(439)).setAttribute("ontab","focaliza('frmContenido.txtCodSAP');" );
      ((Element)v.get(8)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */

      /* Empieza nodo:440 / Elemento padre: 8   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(440)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(440)).setAttribute("alto","12" );
      ((Element)v.get(440)).setAttribute("ancho","50" );
      ((Element)v.get(440)).setAttribute("colorf","" );
      ((Element)v.get(440)).setAttribute("borde","0" );
      ((Element)v.get(440)).setAttribute("imagenf","" );
      ((Element)v.get(440)).setAttribute("repeat","" );
      ((Element)v.get(440)).setAttribute("padding","" );
      ((Element)v.get(440)).setAttribute("visibilidad","visible" );
      ((Element)v.get(440)).setAttribute("contravsb","" );
      ((Element)v.get(440)).setAttribute("x","0" );
      ((Element)v.get(440)).setAttribute("y","899" );
      ((Element)v.get(440)).setAttribute("zindex","" );
      ((Element)v.get(8)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */
      /* Termina nodo:8   */


   }

}

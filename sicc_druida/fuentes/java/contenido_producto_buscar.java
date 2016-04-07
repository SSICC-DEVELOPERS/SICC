
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_producto_buscar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_producto_buscar" );
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
      ((Element)v.get(4)).setAttribute("src","contenido_producto_buscar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(7)).setAttribute("nombre","frmContenido" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));

      /* Empieza nodo:8 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(10)).setAttribute("valor","LPBuscarProducto" );
      ((Element)v.get(7)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","accion" );
      ((Element)v.get(11)).setAttribute("valor","buscar" );
      ((Element)v.get(7)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","oidCabeceraMF" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","oidEstrategia" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","oidPais" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","oidIdioma" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","oidAcceso" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","oidSubacceso" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","varCbMarca" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","varCbLineaProducto" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","varCbUnNegocio" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","varCbNegocio" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(23)).setAttribute("nombre","varCbGenerico" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","varCbSuperGenerico" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","vartxtCodSAP" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","vartxtDescripcion" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","vartxtPagDesde" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","vartxtPagHasta" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","mostrarValoresAdicionales" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","multiseleccion" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","listado2STR" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","SICC_TOOLBAR_CONFIG" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","DES_CORT" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hOidCatalogo" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hDescCatalogo" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","mmat" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","flag" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 7   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","flag2" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(7)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 7   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(39)).setAttribute("nombre","capaContenido" );
      ((Element)v.get(39)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(39)).setAttribute("borde","0" );
      ((Element)v.get(39)).setAttribute("imagenf","" );
      ((Element)v.get(39)).setAttribute("repeat","" );
      ((Element)v.get(39)).setAttribute("padding","" );
      ((Element)v.get(39)).setAttribute("visibilidad","" );
      ((Element)v.get(39)).setAttribute("contravsb","" );
      ((Element)v.get(39)).setAttribute("x","0" );
      ((Element)v.get(39)).setAttribute("y","0" );
      ((Element)v.get(39)).setAttribute("zindex","" );
      ((Element)v.get(7)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("table"));
      ((Element)v.get(40)).setAttribute("width","100%" );
      ((Element)v.get(40)).setAttribute("border","0" );
      ((Element)v.get(40)).setAttribute("cellspacing","0" );
      ((Element)v.get(40)).setAttribute("cellpadding","0" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).setAttribute("width","12" );
      ((Element)v.get(42)).setAttribute("align","center" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(43)).setAttribute("width","12" );
      ((Element)v.get(43)).setAttribute("height","12" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(44)).setAttribute("width","750" );
      ((Element)v.get(41)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */

      /* Empieza nodo:46 / Elemento padre: 41   */
      v.add(doc.createElement("td"));
      ((Element)v.get(46)).setAttribute("width","12" );
      ((Element)v.get(41)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","12" );
      ((Element)v.get(47)).setAttribute("height","1" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */
      /* Termina nodo:41   */

      /* Empieza nodo:48 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(50)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:51 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(53)).setAttribute("class","legend" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(54)).setAttribute("nombre","lblCriterios" );
      ((Element)v.get(54)).setAttribute("alto","13" );
      ((Element)v.get(54)).setAttribute("filas","1" );
      ((Element)v.get(54)).setAttribute("valor","Datos Búsqueda" );
      ((Element)v.get(54)).setAttribute("id","legend" );
      ((Element)v.get(54)).setAttribute("cod","0075" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:55 / Elemento padre: 52   */
      v.add(doc.createElement("table"));
      ((Element)v.get(55)).setAttribute("width","100%" );
      ((Element)v.get(55)).setAttribute("border","0" );
      ((Element)v.get(55)).setAttribute("align","center" );
      ((Element)v.get(55)).setAttribute("cellspacing","0" );
      ((Element)v.get(55)).setAttribute("cellpadding","0" );
      ((Element)v.get(52)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).setAttribute("colspan","4" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","8" );
      ((Element)v.get(58)).setAttribute("height","8" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */
      /* Termina nodo:56   */

      /* Empieza nodo:59 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(61)).setAttribute("src","b.gif" );
      ((Element)v.get(61)).setAttribute("width","8" );
      ((Element)v.get(61)).setAttribute("height","8" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */
      /* Termina nodo:60   */

      /* Empieza nodo:62 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(63)).setAttribute("nombre","lblCodSAP" );
      ((Element)v.get(63)).setAttribute("alto","13" );
      ((Element)v.get(63)).setAttribute("filas","1" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(63)).setAttribute("id","datosTitle" );
      ((Element)v.get(63)).setAttribute("cod","585" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(65)).setAttribute("width","25" );
      ((Element)v.get(65)).setAttribute("height","8" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(67)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(67)).setAttribute("alto","13" );
      ((Element)v.get(67)).setAttribute("filas","1" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(67)).setAttribute("id","datosTitle" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(67)).setAttribute("cod","9" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","25" );
      ((Element)v.get(69)).setAttribute("height","8" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(71)).setAttribute("nombre","lblCatalogo" );
      ((Element)v.get(71)).setAttribute("alto","13" );
      ((Element)v.get(71)).setAttribute("filas","1" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(71)).setAttribute("id","datosTitle" );
      ((Element)v.get(71)).setAttribute("cod","516" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","25" );
      ((Element)v.get(73)).setAttribute("height","8" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(75)).setAttribute("nombre","lblPagDesde" );
      ((Element)v.get(75)).setAttribute("alto","13" );
      ((Element)v.get(75)).setAttribute("filas","1" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(75)).setAttribute("id","datosTitle" );
      ((Element)v.get(75)).setAttribute("cod","512" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","25" );
      ((Element)v.get(77)).setAttribute("height","8" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(79)).setAttribute("nombre","lblPagHasta" );
      ((Element)v.get(79)).setAttribute("alto","13" );
      ((Element)v.get(79)).setAttribute("filas","1" );
      ((Element)v.get(79)).setAttribute("valor","" );
      ((Element)v.get(79)).setAttribute("id","datosTitle" );
      ((Element)v.get(79)).setAttribute("cod","513" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 59   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("width","100%" );
      ((Element)v.get(59)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).setAttribute("width","8" );
      ((Element)v.get(81)).setAttribute("height","8" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:59   */

      /* Empieza nodo:82 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","8" );
      ((Element)v.get(84)).setAttribute("height","8" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(82)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(86)).setAttribute("nombre","txtCodSAP" );
      ((Element)v.get(86)).setAttribute("id","datosCampos" );
      ((Element)v.get(86)).setAttribute("max","20" );
      ((Element)v.get(86)).setAttribute("tipo","" );
      ((Element)v.get(86)).setAttribute("onchange","" );
      ((Element)v.get(86)).setAttribute("req","N" );
      ((Element)v.get(86)).setAttribute("size","22" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(86)).setAttribute("validacion","" );
      ((Element)v.get(86)).setAttribute("onshtab"," focalizaTxtCodSAPOnShTab();" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","25" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(88)).setAttribute("height","8" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(82)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(90)).setAttribute("nombre","txtDescripcion" );
      ((Element)v.get(90)).setAttribute("id","datosCampos" );
      ((Element)v.get(90)).setAttribute("max","40" );
      ((Element)v.get(90)).setAttribute("tipo","" );
      ((Element)v.get(90)).setAttribute("onchange","" );
      ((Element)v.get(90)).setAttribute("req","N" );
      ((Element)v.get(90)).setAttribute("size","44" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(90)).setAttribute("validacion","" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","25" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(94)).setAttribute("nombre","lbldtCatalogo" );
      ((Element)v.get(94)).setAttribute("alto","13" );
      ((Element)v.get(94)).setAttribute("filas","1" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(94)).setAttribute("id","datosCampos" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","25" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(82)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(98)).setAttribute("nombre","txtPagDesde" );
      ((Element)v.get(98)).setAttribute("id","datosCampos" );
      ((Element)v.get(98)).setAttribute("max","3" );
      ((Element)v.get(98)).setAttribute("tipo","" );
      ((Element)v.get(98)).setAttribute("onchange","" );
      ((Element)v.get(98)).setAttribute("req","N" );
      ((Element)v.get(98)).setAttribute("size","3" );
      ((Element)v.get(98)).setAttribute("valor","" );
      ((Element)v.get(98)).setAttribute("validacion","" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","25" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(82)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(102)).setAttribute("nombre","txtPagHasta" );
      ((Element)v.get(102)).setAttribute("id","datosCampos" );
      ((Element)v.get(102)).setAttribute("max","3" );
      ((Element)v.get(102)).setAttribute("tipo","" );
      ((Element)v.get(102)).setAttribute("onchange","" );
      ((Element)v.get(102)).setAttribute("req","N" );
      ((Element)v.get(102)).setAttribute("size","3" );
      ((Element)v.get(102)).setAttribute("valor","" );
      ((Element)v.get(102)).setAttribute("validacion","" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("width","100%" );
      ((Element)v.get(82)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","8" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:82   */

      /* Empieza nodo:105 / Elemento padre: 55   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(55)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).setAttribute("colspan","4" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","8" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(107)).setAttribute("height","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:55   */

      /* Empieza nodo:108 / Elemento padre: 52   */
      v.add(doc.createElement("table"));
      ((Element)v.get(108)).setAttribute("width","100%" );
      ((Element)v.get(108)).setAttribute("border","0" );
      ((Element)v.get(108)).setAttribute("align","center" );
      ((Element)v.get(108)).setAttribute("cellspacing","0" );
      ((Element)v.get(108)).setAttribute("cellpadding","0" );
      ((Element)v.get(52)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).setAttribute("width","8" );
      ((Element)v.get(111)).setAttribute("height","8" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(113)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(113)).setAttribute("alto","13" );
      ((Element)v.get(113)).setAttribute("filas","1" );
      ((Element)v.get(113)).setAttribute("valor","" );
      ((Element)v.get(113)).setAttribute("id","datosTitle" );
      ((Element)v.get(113)).setAttribute("cod","6" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","25" );
      ((Element)v.get(115)).setAttribute("height","8" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(117)).setAttribute("nombre","lblLineaProducto" );
      ((Element)v.get(117)).setAttribute("alto","13" );
      ((Element)v.get(117)).setAttribute("filas","1" );
      ((Element)v.get(117)).setAttribute("valor","" );
      ((Element)v.get(117)).setAttribute("id","datosTitle" );
      ((Element)v.get(117)).setAttribute("cod","586" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("width","100%" );
      ((Element)v.get(109)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).setAttribute("width","8" );
      ((Element)v.get(119)).setAttribute("height","8" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:109   */

      /* Empieza nodo:120 / Elemento padre: 108   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(108)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","8" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(120)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(124)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(124)).setAttribute("id","datosCampos" );
      ((Element)v.get(124)).setAttribute("size","1" );
      ((Element)v.get(124)).setAttribute("multiple","N" );
      ((Element)v.get(124)).setAttribute("req","N" );
      ((Element)v.get(124)).setAttribute("valorinicial","" );
      ((Element)v.get(124)).setAttribute("textoinicial"," " );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:126 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","25" );
      ((Element)v.get(127)).setAttribute("height","8" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:128 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(128)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(128)).setAttribute("style","width:80px" );
      ((Element)v.get(120)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(129)).setAttribute("nombre","cbLineaProducto" );
      ((Element)v.get(129)).setAttribute("id","datosCampos" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(129)).setAttribute("max","50" );
      ((Element)v.get(129)).setAttribute("readonly","true" );
      ((Element)v.get(129)).setAttribute("tipo","" );
      ((Element)v.get(129)).setAttribute("onchange","" );
      ((Element)v.get(129)).setAttribute("req","N" );
      ((Element)v.get(129)).setAttribute("size","50" );
      ((Element)v.get(129)).setAttribute("valor","" );
      ((Element)v.get(129)).setAttribute("validacion","" );
      ((Element)v.get(129)).setAttribute("onshtab","" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).setAttribute("width","100%" );
      ((Element)v.get(120)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(131)).setAttribute("nombre","btnBuscarLProdu" );
      ((Element)v.get(131)).setAttribute("ID","botonContenido" );
      ((Element)v.get(131)).setAttribute("tipo","html" );
      ((Element)v.get(131)).setAttribute("estado","false" );
      ((Element)v.get(131)).setAttribute("cod","1" );
      ((Element)v.get(131)).setAttribute("accion","buscarLineaProducto();" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:120   */

      /* Empieza nodo:132 / Elemento padre: 108   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(108)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).setAttribute("colspan","4" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","8" );
      ((Element)v.get(134)).setAttribute("height","8" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:108   */

      /* Empieza nodo:135 / Elemento padre: 52   */
      v.add(doc.createElement("table"));
      ((Element)v.get(135)).setAttribute("width","100%" );
      ((Element)v.get(135)).setAttribute("border","0" );
      ((Element)v.get(135)).setAttribute("align","center" );
      ((Element)v.get(135)).setAttribute("cellspacing","0" );
      ((Element)v.get(135)).setAttribute("cellpadding","0" );
      ((Element)v.get(52)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","8" );
      ((Element)v.get(138)).setAttribute("height","8" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(140)).setAttribute("nombre","lblUniNegocio" );
      ((Element)v.get(140)).setAttribute("alto","13" );
      ((Element)v.get(140)).setAttribute("filas","1" );
      ((Element)v.get(140)).setAttribute("valor","" );
      ((Element)v.get(140)).setAttribute("id","datosTitle" );
      ((Element)v.get(140)).setAttribute("cod","587" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","25" );
      ((Element)v.get(142)).setAttribute("height","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(144)).setAttribute("nombre","lblNegocio" );
      ((Element)v.get(144)).setAttribute("alto","13" );
      ((Element)v.get(144)).setAttribute("filas","1" );
      ((Element)v.get(144)).setAttribute("valor","" );
      ((Element)v.get(144)).setAttribute("id","datosTitle" );
      ((Element)v.get(144)).setAttribute("cod","588" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).setAttribute("width","100%" );
      ((Element)v.get(136)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","8" );
      ((Element)v.get(146)).setAttribute("height","8" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:136   */

      /* Empieza nodo:147 / Elemento padre: 135   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(135)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","8" );
      ((Element)v.get(149)).setAttribute("height","8" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(147)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(151)).setAttribute("nombre","cbUniNegocio" );
      ((Element)v.get(151)).setAttribute("id","datosCampos" );
      ((Element)v.get(151)).setAttribute("size","1" );
      ((Element)v.get(151)).setAttribute("multiple","N" );
      ((Element)v.get(151)).setAttribute("req","N" );
      ((Element)v.get(151)).setAttribute("valorinicial","" );
      ((Element)v.get(151)).setAttribute("textoinicial"," " );
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:153 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).setAttribute("width","25" );
      ((Element)v.get(154)).setAttribute("height","8" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(147)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(156)).setAttribute("nombre","cbNegocio" );
      ((Element)v.get(156)).setAttribute("id","datosCampos" );
      ((Element)v.get(156)).setAttribute("size","1" );
      ((Element)v.get(156)).setAttribute("multiple","N" );
      ((Element)v.get(156)).setAttribute("req","N" );
      ((Element)v.get(156)).setAttribute("valorinicial","" );
      ((Element)v.get(156)).setAttribute("textoinicial"," " );
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:158 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).setAttribute("width","100%" );
      ((Element)v.get(147)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","8" );
      ((Element)v.get(159)).setAttribute("height","8" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:147   */

      /* Empieza nodo:160 / Elemento padre: 135   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(135)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(161)).setAttribute("colspan","4" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(162)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).setAttribute("width","8" );
      ((Element)v.get(162)).setAttribute("height","8" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:135   */

      /* Empieza nodo:163 / Elemento padre: 52   */
      v.add(doc.createElement("table"));
      ((Element)v.get(163)).setAttribute("width","100%" );
      ((Element)v.get(163)).setAttribute("border","0" );
      ((Element)v.get(163)).setAttribute("align","center" );
      ((Element)v.get(163)).setAttribute("cellspacing","0" );
      ((Element)v.get(163)).setAttribute("cellpadding","0" );
      ((Element)v.get(52)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).setAttribute("width","8" );
      ((Element)v.get(166)).setAttribute("height","8" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(168)).setAttribute("nombre","lblGenerico" );
      ((Element)v.get(168)).setAttribute("alto","13" );
      ((Element)v.get(168)).setAttribute("filas","1" );
      ((Element)v.get(168)).setAttribute("valor","" );
      ((Element)v.get(168)).setAttribute("id","datosTitle" );
      ((Element)v.get(168)).setAttribute("cod","589" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).setAttribute("width","25" );
      ((Element)v.get(170)).setAttribute("height","8" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(172)).setAttribute("nombre","lblSupergenerico" );
      ((Element)v.get(172)).setAttribute("alto","13" );
      ((Element)v.get(172)).setAttribute("filas","1" );
      ((Element)v.get(172)).setAttribute("valor","" );
      ((Element)v.get(172)).setAttribute("id","datosTitle" );
      ((Element)v.get(172)).setAttribute("cod","590" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(173)).setAttribute("width","100%" );
      ((Element)v.get(164)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).setAttribute("width","8" );
      ((Element)v.get(174)).setAttribute("height","8" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */
      /* Termina nodo:164   */

      /* Empieza nodo:175 / Elemento padre: 163   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(163)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","8" );
      ((Element)v.get(177)).setAttribute("height","8" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:178 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(175)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(179)).setAttribute("nombre","cbGenerico" );
      ((Element)v.get(179)).setAttribute("id","datosCampos" );
      ((Element)v.get(179)).setAttribute("max","30" );
      ((Element)v.get(179)).setAttribute("readonly","true" );
      ((Element)v.get(179)).setAttribute("tipo","" );
      ((Element)v.get(179)).setAttribute("onchange","" );
      ((Element)v.get(179)).setAttribute("req","N" );
      ((Element)v.get(179)).setAttribute("size","40" );
      ((Element)v.get(179)).setAttribute("valor","" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(181)).setAttribute("nombre","btnBuscarGenerico" );
      ((Element)v.get(181)).setAttribute("ID","botonContenido" );
      ((Element)v.get(181)).setAttribute("tipo","html" );
      ((Element)v.get(181)).setAttribute("estado","false" );
      ((Element)v.get(181)).setAttribute("cod","1" );
      ((Element)v.get(181)).setAttribute("accion","buscarGenerico();" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */

      /* Empieza nodo:182 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(182)).setAttribute("src","b.gif" );
      ((Element)v.get(182)).setAttribute("width","25" );
      ((Element)v.get(182)).setAttribute("height","8" );
      ((Element)v.get(180)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:180   */

      /* Empieza nodo:183 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(175)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(184)).setAttribute("nombre","cbSupergenerico" );
      ((Element)v.get(184)).setAttribute("id","datosCampos" );
      ((Element)v.get(184)).setAttribute("max","30" );
      ((Element)v.get(184)).setAttribute("readonly","true" );
      ((Element)v.get(184)).setAttribute("tipo","" );
      ((Element)v.get(184)).setAttribute("onchange","" );
      ((Element)v.get(184)).setAttribute("req","N" );
      ((Element)v.get(184)).setAttribute("size","40" );
      ((Element)v.get(184)).setAttribute("valor","" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).setAttribute("width","100%" );
      ((Element)v.get(175)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(186)).setAttribute("nombre","btnBuscarSuperGenerico" );
      ((Element)v.get(186)).setAttribute("ID","botonContenido" );
      ((Element)v.get(186)).setAttribute("tipo","html" );
      ((Element)v.get(186)).setAttribute("estado","false" );
      ((Element)v.get(186)).setAttribute("cod","1" );
      ((Element)v.get(186)).setAttribute("accion","buscarSuperGenerico();" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */
      /* Termina nodo:175   */

      /* Empieza nodo:187 / Elemento padre: 163   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(163)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).setAttribute("colspan","4" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(189)).setAttribute("src","b.gif" );
      ((Element)v.get(189)).setAttribute("width","8" );
      ((Element)v.get(189)).setAttribute("height","8" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */
      /* Termina nodo:187   */
      /* Termina nodo:163   */
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:190 / Elemento padre: 48   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(191)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */
      /* Termina nodo:48   */

      /* Empieza nodo:192 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(194)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 192   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("table"));
      ((Element)v.get(197)).setAttribute("width","100%" );
      ((Element)v.get(197)).setAttribute("border","0" );
      ((Element)v.get(197)).setAttribute("align","center" );
      ((Element)v.get(197)).setAttribute("cellspacing","0" );
      ((Element)v.get(197)).setAttribute("cellpadding","0" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).setAttribute("class","botonera" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(200)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(200)).setAttribute("ID","botonContenido" );
      ((Element)v.get(200)).setAttribute("tipo","html" );
      ((Element)v.get(200)).setAttribute("estado","false" );
      ((Element)v.get(200)).setAttribute("cod","1" );
      ((Element)v.get(200)).setAttribute("accion","botonBuscar();" );
      ((Element)v.get(200)).setAttribute("ontab","focalizaBotonTab();" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:198   */
      /* Termina nodo:197   */
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:201 / Elemento padre: 192   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(202)).setAttribute("src","b.gif" );
      ((Element)v.get(202)).setAttribute("width","8" );
      ((Element)v.get(202)).setAttribute("height","12" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */
      /* Termina nodo:192   */

      /* Empieza nodo:203 / Elemento padre: 40   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(40)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(204)).setAttribute("width","12" );
      ((Element)v.get(204)).setAttribute("align","center" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(205)).setAttribute("src","b.gif" );
      ((Element)v.get(205)).setAttribute("width","12" );
      ((Element)v.get(205)).setAttribute("height","12" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(206)).setAttribute("width","750" );
      ((Element)v.get(203)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(207)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).setAttribute("width","12" );
      ((Element)v.get(203)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","12" );
      ((Element)v.get(209)).setAttribute("height","1" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:203   */
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:210 / Elemento padre: 7   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(210)).setAttribute("nombre","listado1" );
      ((Element)v.get(210)).setAttribute("ancho","664" );
      ((Element)v.get(210)).setAttribute("alto","317" );
      ((Element)v.get(210)).setAttribute("x","12" );
      ((Element)v.get(210)).setAttribute("y","241" );
      ((Element)v.get(210)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(210)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(7)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(211)).setAttribute("precarga","S" );
      ((Element)v.get(211)).setAttribute("conROver","S" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(212)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(212)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(212)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(212)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */

      /* Empieza nodo:213 / Elemento padre: 211   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(213)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(213)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(213)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(213)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(211)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */

      /* Empieza nodo:214 / Elemento padre: 211   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(214)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(214)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(211)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:211   */

      /* Empieza nodo:215 / Elemento padre: 210   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(210)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(216)).setAttribute("borde","1" );
      ((Element)v.get(216)).setAttribute("horizDatos","1" );
      ((Element)v.get(216)).setAttribute("horizCabecera","1" );
      ((Element)v.get(216)).setAttribute("vertical","1" );
      ((Element)v.get(216)).setAttribute("horizTitulo","1" );
      ((Element)v.get(216)).setAttribute("horizBase","1" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */

      /* Empieza nodo:217 / Elemento padre: 215   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(217)).setAttribute("borde","#999999" );
      ((Element)v.get(217)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(217)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(217)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(217)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(217)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(217)).setAttribute("horizBase","#999999" );
      ((Element)v.get(215)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:215   */

      /* Empieza nodo:218 / Elemento padre: 210   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(218)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(218)).setAttribute("alto","22" );
      ((Element)v.get(218)).setAttribute("imgFondo","" );
      ((Element)v.get(218)).setAttribute("cod","00135" );
      ((Element)v.get(218)).setAttribute("ID","datosTitle" );
      ((Element)v.get(210)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */

      /* Empieza nodo:219 / Elemento padre: 210   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(219)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(219)).setAttribute("alto","22" );
      ((Element)v.get(219)).setAttribute("imgFondo","" );
      ((Element)v.get(210)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */

      /* Empieza nodo:220 / Elemento padre: 210   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(220)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(220)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(220)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(220)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(220)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(220)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(210)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(221)).setAttribute("ancho","100" );
      ((Element)v.get(221)).setAttribute("minimizable","S" );
      ((Element)v.get(221)).setAttribute("minimizada","N" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */

      /* Empieza nodo:222 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(222)).setAttribute("ancho","100" );
      ((Element)v.get(222)).setAttribute("minimizable","S" );
      ((Element)v.get(222)).setAttribute("minimizada","N" );
      ((Element)v.get(220)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */

      /* Empieza nodo:223 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(223)).setAttribute("ancho","100" );
      ((Element)v.get(223)).setAttribute("minimizable","S" );
      ((Element)v.get(223)).setAttribute("minimizada","N" );
      ((Element)v.get(220)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */

      /* Empieza nodo:224 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(224)).setAttribute("ancho","100" );
      ((Element)v.get(224)).setAttribute("minimizable","S" );
      ((Element)v.get(224)).setAttribute("minimizada","N" );
      ((Element)v.get(220)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */

      /* Empieza nodo:225 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(225)).setAttribute("ancho","100" );
      ((Element)v.get(225)).setAttribute("minimizable","S" );
      ((Element)v.get(225)).setAttribute("minimizada","N" );
      ((Element)v.get(220)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */

      /* Empieza nodo:226 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(226)).setAttribute("ancho","100" );
      ((Element)v.get(226)).setAttribute("minimizable","S" );
      ((Element)v.get(226)).setAttribute("minimizada","N" );
      ((Element)v.get(220)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */

      /* Empieza nodo:227 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(227)).setAttribute("ancho","100" );
      ((Element)v.get(227)).setAttribute("minimizable","S" );
      ((Element)v.get(227)).setAttribute("minimizada","N" );
      ((Element)v.get(220)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */

      /* Empieza nodo:228 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(228)).setAttribute("ancho","100" );
      ((Element)v.get(228)).setAttribute("minimizable","S" );
      ((Element)v.get(228)).setAttribute("minimizada","N" );
      ((Element)v.get(220)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */

      /* Empieza nodo:229 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(229)).setAttribute("ancho","100" );
      ((Element)v.get(229)).setAttribute("minimizable","S" );
      ((Element)v.get(229)).setAttribute("minimizada","N" );
      ((Element)v.get(220)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */

      /* Empieza nodo:230 / Elemento padre: 220   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(230)).setAttribute("ancho","0" );
      ((Element)v.get(230)).setAttribute("minimizable","S" );
      ((Element)v.get(230)).setAttribute("minimizada","S" );
      ((Element)v.get(220)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */

      /* Empieza nodo:231 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(231)).setAttribute("ancho","0" );
      ((Element)v.get(231)).setAttribute("minimizable","S" );
      ((Element)v.get(231)).setAttribute("minimizada","S" );
      ((Element)v.get(220)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */

      /* Empieza nodo:232 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(232)).setAttribute("ancho","0" );
      ((Element)v.get(232)).setAttribute("minimizable","S" );
      ((Element)v.get(232)).setAttribute("minimizada","S" );
      ((Element)v.get(220)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */

      /* Empieza nodo:233 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(233)).setAttribute("ancho","0" );
      ((Element)v.get(233)).setAttribute("minimizable","S" );
      ((Element)v.get(233)).setAttribute("minimizada","S" );
      ((Element)v.get(220)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */

      /* Empieza nodo:234 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(234)).setAttribute("ancho","0" );
      ((Element)v.get(234)).setAttribute("minimizable","S" );
      ((Element)v.get(234)).setAttribute("minimizada","S" );
      ((Element)v.get(220)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */

      /* Empieza nodo:235 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(235)).setAttribute("ancho","0" );
      ((Element)v.get(235)).setAttribute("minimizable","S" );
      ((Element)v.get(235)).setAttribute("minimizada","S" );
      ((Element)v.get(220)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */

      /* Empieza nodo:236 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(236)).setAttribute("ancho","0" );
      ((Element)v.get(236)).setAttribute("minimizable","S" );
      ((Element)v.get(236)).setAttribute("minimizada","S" );
      ((Element)v.get(220)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */

      /* Empieza nodo:237 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(237)).setAttribute("ancho","0" );
      ((Element)v.get(237)).setAttribute("minimizable","S" );
      ((Element)v.get(237)).setAttribute("minimizada","S" );
      ((Element)v.get(220)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */

      /* Empieza nodo:238 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(238)).setAttribute("ancho","0" );
      ((Element)v.get(238)).setAttribute("minimizable","S" );
      ((Element)v.get(238)).setAttribute("minimizada","S" );
      ((Element)v.get(220)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */

      /* Empieza nodo:239 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(239)).setAttribute("ancho","0" );
      ((Element)v.get(239)).setAttribute("minimizable","S" );
      ((Element)v.get(239)).setAttribute("minimizada","S" );
      ((Element)v.get(220)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */

      /* Empieza nodo:240 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(240)).setAttribute("ancho","0" );
      ((Element)v.get(240)).setAttribute("minimizable","S" );
      ((Element)v.get(240)).setAttribute("minimizada","S" );
      ((Element)v.get(220)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */

      /* Empieza nodo:241 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(241)).setAttribute("ancho","0" );
      ((Element)v.get(241)).setAttribute("minimizable","S" );
      ((Element)v.get(241)).setAttribute("minimizada","S" );
      ((Element)v.get(220)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */

      /* Empieza nodo:242 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(242)).setAttribute("ancho","0" );
      ((Element)v.get(242)).setAttribute("minimizable","S" );
      ((Element)v.get(242)).setAttribute("minimizada","S" );
      ((Element)v.get(220)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */

      /* Empieza nodo:243 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(243)).setAttribute("ancho","0" );
      ((Element)v.get(243)).setAttribute("minimizable","S" );
      ((Element)v.get(243)).setAttribute("minimizada","S" );
      ((Element)v.get(220)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */

      /* Empieza nodo:244 / Elemento padre: 220   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(244)).setAttribute("ancho","0" );
      ((Element)v.get(244)).setAttribute("minimizable","S" );
      ((Element)v.get(244)).setAttribute("minimizada","S" );
      ((Element)v.get(220)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:220   */

      /* Empieza nodo:245 / Elemento padre: 210   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(245)).setAttribute("alto","20" );
      ((Element)v.get(245)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(245)).setAttribute("imgFondo","" );
      ((Element)v.get(245)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(210)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(246)).setAttribute("colFondo","" );
      ((Element)v.get(246)).setAttribute("ID","EstCab" );
      ((Element)v.get(246)).setAttribute("cod","337" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));

      /* Elemento padre:246 / Elemento actual: 247   */
      v.add(doc.createTextNode("Cód. producto"));
      ((Element)v.get(246)).appendChild((Text)v.get(247));

      /* Termina nodo Texto:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:248 / Elemento padre: 245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(248)).setAttribute("colFondo","" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(248)).setAttribute("ID","EstCab" );
      ((Element)v.get(248)).setAttribute("cod","9" );
      ((Element)v.get(245)).appendChild((Element)v.get(248));

      /* Elemento padre:248 / Elemento actual: 249   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(248)).appendChild((Text)v.get(249));

      /* Termina nodo Texto:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:250 / Elemento padre: 245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(250)).setAttribute("colFondo","" );
      ((Element)v.get(250)).setAttribute("ID","EstCab" );
      ((Element)v.get(250)).setAttribute("cod","503" );
      ((Element)v.get(245)).appendChild((Element)v.get(250));

      /* Elemento padre:250 / Elemento actual: 251   */
      v.add(doc.createTextNode("Precio catálogo"));
      ((Element)v.get(250)).appendChild((Text)v.get(251));

      /* Termina nodo Texto:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:252 / Elemento padre: 245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(252)).setAttribute("colFondo","" );
      ((Element)v.get(252)).setAttribute("ID","EstCab" );
      ((Element)v.get(252)).setAttribute("cod","592" );
      ((Element)v.get(245)).appendChild((Element)v.get(252));

      /* Elemento padre:252 / Elemento actual: 253   */
      v.add(doc.createTextNode("Página"));
      ((Element)v.get(252)).appendChild((Text)v.get(253));

      /* Termina nodo Texto:253   */
      /* Termina nodo:252   */

      /* Empieza nodo:254 / Elemento padre: 245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(254)).setAttribute("colFondo","" );
      ((Element)v.get(254)).setAttribute("ID","EstCab" );
      ((Element)v.get(254)).setAttribute("cod","608" );
      ((Element)v.get(245)).appendChild((Element)v.get(254));

      /* Elemento padre:254 / Elemento actual: 255   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(254)).appendChild((Text)v.get(255));

      /* Termina nodo Texto:255   */
      /* Termina nodo:254   */

      /* Empieza nodo:256 / Elemento padre: 245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(256)).setAttribute("colFondo","" );
      ((Element)v.get(256)).setAttribute("ID","EstCab" );
      ((Element)v.get(256)).setAttribute("cod","581" );
      ((Element)v.get(245)).appendChild((Element)v.get(256));

      /* Elemento padre:256 / Elemento actual: 257   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(256)).appendChild((Text)v.get(257));

      /* Termina nodo Texto:257   */
      /* Termina nodo:256   */

      /* Empieza nodo:258 / Elemento padre: 245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(258)).setAttribute("colFondo","" );
      ((Element)v.get(258)).setAttribute("ID","EstCab" );
      ((Element)v.get(258)).setAttribute("cod","481" );
      ((Element)v.get(245)).appendChild((Element)v.get(258));

      /* Elemento padre:258 / Elemento actual: 259   */
      v.add(doc.createTextNode("Atributo 1"));
      ((Element)v.get(258)).appendChild((Text)v.get(259));

      /* Termina nodo Texto:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:260 / Elemento padre: 245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(260)).setAttribute("colFondo","" );
      ((Element)v.get(260)).setAttribute("ID","EstCab" );
      ((Element)v.get(260)).setAttribute("cod","482" );
      ((Element)v.get(245)).appendChild((Element)v.get(260));

      /* Elemento padre:260 / Elemento actual: 261   */
      v.add(doc.createTextNode("Atributo 2"));
      ((Element)v.get(260)).appendChild((Text)v.get(261));

      /* Termina nodo Texto:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:262 / Elemento padre: 245   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(262)).setAttribute("colFondo","" );
      ((Element)v.get(262)).setAttribute("ID","EstCab" );
      ((Element)v.get(262)).setAttribute("cod","483" );
      ((Element)v.get(245)).appendChild((Element)v.get(262));

      /* Elemento padre:262 / Elemento actual: 263   */
      v.add(doc.createTextNode("Atributo 3"));
      ((Element)v.get(262)).appendChild((Text)v.get(263));

      /* Termina nodo Texto:263   */
      /* Termina nodo:262   */
      /* Termina nodo:245   */

      /* Empieza nodo:264 / Elemento padre: 210   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(264)).setAttribute("alto","22" );
      ((Element)v.get(264)).setAttribute("accion","" );
      ((Element)v.get(264)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(264)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(264)).setAttribute("maxSel","-1" );
      ((Element)v.get(264)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(264)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(264)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(264)).setAttribute("onLoad","" );
      ((Element)v.get(264)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(210)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(265)).setAttribute("tipo","texto" );
      ((Element)v.get(265)).setAttribute("ID","EstDat" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */

      /* Empieza nodo:266 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(266)).setAttribute("tipo","texto" );
      ((Element)v.get(266)).setAttribute("ID","EstDat2" );
      ((Element)v.get(264)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */

      /* Empieza nodo:267 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(267)).setAttribute("tipo","texto" );
      ((Element)v.get(267)).setAttribute("ID","EstDat" );
      ((Element)v.get(264)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */

      /* Empieza nodo:268 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(268)).setAttribute("tipo","texto" );
      ((Element)v.get(268)).setAttribute("ID","EstDat2" );
      ((Element)v.get(264)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */

      /* Empieza nodo:269 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(269)).setAttribute("tipo","texto" );
      ((Element)v.get(269)).setAttribute("ID","EstDat2" );
      ((Element)v.get(264)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */

      /* Empieza nodo:270 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(270)).setAttribute("tipo","texto" );
      ((Element)v.get(270)).setAttribute("ID","EstDat" );
      ((Element)v.get(264)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */

      /* Empieza nodo:271 / Elemento padre: 264   */
   }

   private void getXML1170(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(271)).setAttribute("tipo","texto" );
      ((Element)v.get(271)).setAttribute("ID","EstDat2" );
      ((Element)v.get(264)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */

      /* Empieza nodo:272 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(272)).setAttribute("tipo","texto" );
      ((Element)v.get(272)).setAttribute("ID","EstDat" );
      ((Element)v.get(264)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */

      /* Empieza nodo:273 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(273)).setAttribute("tipo","texto" );
      ((Element)v.get(273)).setAttribute("ID","EstDat2" );
      ((Element)v.get(264)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */

      /* Empieza nodo:274 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(274)).setAttribute("tipo","texto" );
      ((Element)v.get(274)).setAttribute("ID","EstDat" );
      ((Element)v.get(264)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */

      /* Empieza nodo:275 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(275)).setAttribute("tipo","texto" );
      ((Element)v.get(275)).setAttribute("ID","EstDat2" );
      ((Element)v.get(264)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */

      /* Empieza nodo:276 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(276)).setAttribute("tipo","texto" );
      ((Element)v.get(276)).setAttribute("ID","EstDat" );
      ((Element)v.get(264)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */

      /* Empieza nodo:277 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(277)).setAttribute("tipo","texto" );
      ((Element)v.get(277)).setAttribute("ID","EstDat2" );
      ((Element)v.get(264)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */

      /* Empieza nodo:278 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(278)).setAttribute("tipo","texto" );
      ((Element)v.get(278)).setAttribute("ID","EstDat" );
      ((Element)v.get(264)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */

      /* Empieza nodo:279 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(279)).setAttribute("tipo","texto" );
      ((Element)v.get(279)).setAttribute("ID","EstDat2" );
      ((Element)v.get(264)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */

      /* Empieza nodo:280 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(280)).setAttribute("tipo","texto" );
      ((Element)v.get(280)).setAttribute("ID","EstDat" );
      ((Element)v.get(264)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */

      /* Empieza nodo:281 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(281)).setAttribute("tipo","texto" );
      ((Element)v.get(281)).setAttribute("ID","EstDat2" );
      ((Element)v.get(264)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */

      /* Empieza nodo:282 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(282)).setAttribute("tipo","texto" );
      ((Element)v.get(282)).setAttribute("ID","EstDat" );
      ((Element)v.get(264)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */

      /* Empieza nodo:283 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(283)).setAttribute("tipo","texto" );
      ((Element)v.get(283)).setAttribute("ID","EstDat2" );
      ((Element)v.get(264)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */

      /* Empieza nodo:284 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(284)).setAttribute("tipo","texto" );
      ((Element)v.get(284)).setAttribute("ID","EstDat" );
      ((Element)v.get(264)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */

      /* Empieza nodo:285 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(285)).setAttribute("tipo","texto" );
      ((Element)v.get(285)).setAttribute("ID","EstDat2" );
      ((Element)v.get(264)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */

      /* Empieza nodo:286 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(286)).setAttribute("tipo","texto" );
      ((Element)v.get(286)).setAttribute("ID","EstDat" );
      ((Element)v.get(264)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */

      /* Empieza nodo:287 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(287)).setAttribute("tipo","texto" );
      ((Element)v.get(287)).setAttribute("ID","EstDat2" );
      ((Element)v.get(264)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */

      /* Empieza nodo:288 / Elemento padre: 264   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(288)).setAttribute("tipo","texto" );
      ((Element)v.get(288)).setAttribute("ID","EstDat" );
      ((Element)v.get(264)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:264   */

      /* Empieza nodo:289 / Elemento padre: 210   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(210)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */

      /* Empieza nodo:290 / Elemento padre: 210   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(290)).setAttribute("nombre","mipgndo1" );
      ((Element)v.get(290)).setAttribute("ancho","664" );
      ((Element)v.get(290)).setAttribute("sep","$" );
      ((Element)v.get(290)).setAttribute("x","12" );
      ((Element)v.get(290)).setAttribute("class","botonera" );
      ((Element)v.get(290)).setAttribute("y","535" );
      ((Element)v.get(290)).setAttribute("control","|" );
      ((Element)v.get(290)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(290)).setAttribute("rowset","" );
      ((Element)v.get(290)).setAttribute("cargainicial","N" );
      ((Element)v.get(290)).setAttribute("onload","prueba(msgError, ultima, rowset);" );
      ((Element)v.get(210)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(291)).setAttribute("nombre","ret1" );
      ((Element)v.get(291)).setAttribute("x","37" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(291)).setAttribute("y","539" );
      ((Element)v.get(291)).setAttribute("ID","botonContenido" );
      ((Element)v.get(291)).setAttribute("img","retroceder_on" );
      ((Element)v.get(291)).setAttribute("tipo","0" );
      ((Element)v.get(291)).setAttribute("estado","false" );
      ((Element)v.get(291)).setAttribute("alt","" );
      ((Element)v.get(291)).setAttribute("codigo","" );
      ((Element)v.get(291)).setAttribute("accion","mipgndo1.retroceder();" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */

      /* Empieza nodo:292 / Elemento padre: 290   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(292)).setAttribute("nombre","ava1" );
      ((Element)v.get(292)).setAttribute("x","52" );
      ((Element)v.get(292)).setAttribute("y","539" );
      ((Element)v.get(292)).setAttribute("ID","botonContenido" );
      ((Element)v.get(292)).setAttribute("img","avanzar_on" );
      ((Element)v.get(292)).setAttribute("tipo","0" );
      ((Element)v.get(292)).setAttribute("estado","false" );
      ((Element)v.get(292)).setAttribute("alt","" );
      ((Element)v.get(292)).setAttribute("codigo","" );
      ((Element)v.get(292)).setAttribute("accion","mipgndo1.avanzar();" );
      ((Element)v.get(290)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:290   */
      /* Termina nodo:210   */

      /* Empieza nodo:293 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(293)).setAttribute("nombre","primera1" );
      ((Element)v.get(293)).setAttribute("x","20" );
      ((Element)v.get(293)).setAttribute("y","539" );
      ((Element)v.get(293)).setAttribute("ID","botonContenido" );
      ((Element)v.get(293)).setAttribute("img","primera_on" );
      ((Element)v.get(293)).setAttribute("tipo","-2" );
      ((Element)v.get(293)).setAttribute("estado","false" );
      ((Element)v.get(293)).setAttribute("alt","" );
      ((Element)v.get(293)).setAttribute("codigo","" );
      ((Element)v.get(293)).setAttribute("accion","mipgndo1.retrocederPrimeraPagina();" );
      ((Element)v.get(7)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */

      /* Empieza nodo:294 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(294)).setAttribute("nombre","separa1" );
      ((Element)v.get(294)).setAttribute("x","59" );
      ((Element)v.get(294)).setAttribute("y","535" );
      ((Element)v.get(294)).setAttribute("ID","botonContenido" );
      ((Element)v.get(294)).setAttribute("img","separa_base" );
      ((Element)v.get(294)).setAttribute("tipo","0" );
      ((Element)v.get(294)).setAttribute("estado","false" );
      ((Element)v.get(294)).setAttribute("alt","" );
      ((Element)v.get(294)).setAttribute("codigo","" );
      ((Element)v.get(294)).setAttribute("accion","" );
      ((Element)v.get(7)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */

      /* Empieza nodo:295 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(295)).setAttribute("nombre","Anadir" );
      ((Element)v.get(295)).setAttribute("x","80" );
      ((Element)v.get(295)).setAttribute("y","536" );
      ((Element)v.get(295)).setAttribute("ID","botonContenido" );
      ((Element)v.get(295)).setAttribute("tipo","html" );
      ((Element)v.get(295)).setAttribute("estado","false" );
      ((Element)v.get(295)).setAttribute("cod","404" );
      ((Element)v.get(295)).setAttribute("accion","botonAniadirBis();" );
      ((Element)v.get(295)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnBuscar');" );
      ((Element)v.get(295)).setAttribute("ontab","focalizaBotonHTML('botonContenido','Eliminar');" );
      ((Element)v.get(7)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */

      /* Empieza nodo:296 / Elemento padre: 7   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(296)).setAttribute("nombre","listado3" );
      ((Element)v.get(296)).setAttribute("ancho","664" );
      ((Element)v.get(296)).setAttribute("alto","317" );
      ((Element)v.get(296)).setAttribute("x","12" );
      ((Element)v.get(296)).setAttribute("y","241" );
      ((Element)v.get(296)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(296)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(7)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(297)).setAttribute("precarga","S" );
      ((Element)v.get(297)).setAttribute("conROver","S" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(298)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(298)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(298)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(298)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */

      /* Empieza nodo:299 / Elemento padre: 297   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(299)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(299)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(299)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(299)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(297)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */

      /* Empieza nodo:300 / Elemento padre: 297   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(300)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(300)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(297)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */
      /* Termina nodo:297   */

      /* Empieza nodo:301 / Elemento padre: 296   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(296)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(302)).setAttribute("borde","1" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(302)).setAttribute("horizDatos","1" );
      ((Element)v.get(302)).setAttribute("horizCabecera","1" );
      ((Element)v.get(302)).setAttribute("vertical","1" );
      ((Element)v.get(302)).setAttribute("horizTitulo","1" );
      ((Element)v.get(302)).setAttribute("horizBase","1" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */

      /* Empieza nodo:303 / Elemento padre: 301   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(303)).setAttribute("borde","#999999" );
      ((Element)v.get(303)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(303)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(303)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(303)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(303)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(303)).setAttribute("horizBase","#999999" );
      ((Element)v.get(301)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:301   */

      /* Empieza nodo:304 / Elemento padre: 296   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(304)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(304)).setAttribute("alto","22" );
      ((Element)v.get(304)).setAttribute("imgFondo","" );
      ((Element)v.get(304)).setAttribute("cod","00135" );
      ((Element)v.get(304)).setAttribute("ID","datosTitle" );
      ((Element)v.get(296)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */

      /* Empieza nodo:305 / Elemento padre: 296   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(305)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(305)).setAttribute("alto","22" );
      ((Element)v.get(305)).setAttribute("imgFondo","" );
      ((Element)v.get(296)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */

      /* Empieza nodo:306 / Elemento padre: 296   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(306)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(306)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(306)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(306)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(306)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(306)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(296)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(307)).setAttribute("ancho","100" );
      ((Element)v.get(307)).setAttribute("minimizable","S" );
      ((Element)v.get(307)).setAttribute("minimizada","N" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */

      /* Empieza nodo:308 / Elemento padre: 306   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(308)).setAttribute("ancho","100" );
      ((Element)v.get(308)).setAttribute("minimizable","S" );
      ((Element)v.get(308)).setAttribute("minimizada","N" );
      ((Element)v.get(308)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(306)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */

      /* Empieza nodo:309 / Elemento padre: 306   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(309)).setAttribute("ancho","100" );
      ((Element)v.get(309)).setAttribute("minimizable","S" );
      ((Element)v.get(309)).setAttribute("minimizada","N" );
      ((Element)v.get(306)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */

      /* Empieza nodo:310 / Elemento padre: 306   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(310)).setAttribute("ancho","100" );
      ((Element)v.get(310)).setAttribute("minimizable","S" );
      ((Element)v.get(310)).setAttribute("minimizada","N" );
      ((Element)v.get(306)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */

      /* Empieza nodo:311 / Elemento padre: 306   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(311)).setAttribute("ancho","100" );
      ((Element)v.get(311)).setAttribute("minimizable","S" );
      ((Element)v.get(311)).setAttribute("minimizada","N" );
      ((Element)v.get(311)).setAttribute("orden","numerico" );
      ((Element)v.get(306)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */

      /* Empieza nodo:312 / Elemento padre: 306   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(312)).setAttribute("ancho","100" );
      ((Element)v.get(312)).setAttribute("minimizable","S" );
      ((Element)v.get(312)).setAttribute("minimizada","N" );
      ((Element)v.get(306)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */

      /* Empieza nodo:313 / Elemento padre: 306   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(313)).setAttribute("ancho","100" );
      ((Element)v.get(313)).setAttribute("minimizable","S" );
      ((Element)v.get(313)).setAttribute("minimizada","N" );
      ((Element)v.get(313)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(306)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */

      /* Empieza nodo:314 / Elemento padre: 306   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(314)).setAttribute("ancho","100" );
      ((Element)v.get(314)).setAttribute("minimizable","S" );
      ((Element)v.get(314)).setAttribute("minimizada","N" );
      ((Element)v.get(306)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */

      /* Empieza nodo:315 / Elemento padre: 306   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(315)).setAttribute("ancho","0" );
      ((Element)v.get(315)).setAttribute("minimizable","S" );
      ((Element)v.get(315)).setAttribute("minimizada","S" );
      ((Element)v.get(315)).setAttribute("oculta","S" );
      ((Element)v.get(306)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */

      /* Empieza nodo:316 / Elemento padre: 306   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(316)).setAttribute("ancho","0" );
      ((Element)v.get(316)).setAttribute("minimizable","S" );
      ((Element)v.get(316)).setAttribute("minimizada","S" );
      ((Element)v.get(316)).setAttribute("oculta","S" );
      ((Element)v.get(306)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:306   */

      /* Empieza nodo:317 / Elemento padre: 296   */
   }

   private void getXML1440(Document doc) {
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(317)).setAttribute("alto","20" );
      ((Element)v.get(317)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(317)).setAttribute("imgFondo","" );
      ((Element)v.get(317)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(296)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(318)).setAttribute("colFondo","" );
      ((Element)v.get(318)).setAttribute("ID","EstCab" );
      ((Element)v.get(318)).setAttribute("align","center" );
      ((Element)v.get(318)).setAttribute("cod","337" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));

      /* Elemento padre:318 / Elemento actual: 319   */
      v.add(doc.createTextNode("Cód. producto"));
      ((Element)v.get(318)).appendChild((Text)v.get(319));

      /* Termina nodo Texto:319   */
      /* Termina nodo:318   */

      /* Empieza nodo:320 / Elemento padre: 317   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(320)).setAttribute("colFondo","" );
      ((Element)v.get(320)).setAttribute("ID","EstCab" );
      ((Element)v.get(320)).setAttribute("cod","9" );
      ((Element)v.get(317)).appendChild((Element)v.get(320));

      /* Elemento padre:320 / Elemento actual: 321   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(320)).appendChild((Text)v.get(321));

      /* Termina nodo Texto:321   */
      /* Termina nodo:320   */

      /* Empieza nodo:322 / Elemento padre: 317   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(322)).setAttribute("colFondo","" );
      ((Element)v.get(322)).setAttribute("ID","EstCab" );
      ((Element)v.get(322)).setAttribute("cod","503" );
      ((Element)v.get(317)).appendChild((Element)v.get(322));

      /* Elemento padre:322 / Elemento actual: 323   */
      v.add(doc.createTextNode("Precio catálogo"));
      ((Element)v.get(322)).appendChild((Text)v.get(323));

      /* Termina nodo Texto:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:324 / Elemento padre: 317   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(324)).setAttribute("colFondo","" );
      ((Element)v.get(324)).setAttribute("ID","EstCab" );
      ((Element)v.get(324)).setAttribute("cod","592" );
      ((Element)v.get(317)).appendChild((Element)v.get(324));

      /* Elemento padre:324 / Elemento actual: 325   */
      v.add(doc.createTextNode("Precio Posicionamiento"));
      ((Element)v.get(324)).appendChild((Text)v.get(325));

      /* Termina nodo Texto:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:326 / Elemento padre: 317   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(326)).setAttribute("colFondo","" );
      ((Element)v.get(326)).setAttribute("ID","EstCab" );
      ((Element)v.get(326)).setAttribute("cod","608" );
      ((Element)v.get(317)).appendChild((Element)v.get(326));

      /* Elemento padre:326 / Elemento actual: 327   */
      v.add(doc.createTextNode("Costo Estandard"));
      ((Element)v.get(326)).appendChild((Text)v.get(327));

      /* Termina nodo Texto:327   */
      /* Termina nodo:326   */

      /* Empieza nodo:328 / Elemento padre: 317   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(328)).setAttribute("colFondo","" );
      ((Element)v.get(328)).setAttribute("ID","EstCab" );
      ((Element)v.get(328)).setAttribute("cod","481" );
      ((Element)v.get(317)).appendChild((Element)v.get(328));

      /* Elemento padre:328 / Elemento actual: 329   */
      v.add(doc.createTextNode("Atributo 1"));
      ((Element)v.get(328)).appendChild((Text)v.get(329));

      /* Termina nodo Texto:329   */
      /* Termina nodo:328   */

      /* Empieza nodo:330 / Elemento padre: 317   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(330)).setAttribute("colFondo","" );
      ((Element)v.get(330)).setAttribute("ID","EstCab" );
      ((Element)v.get(330)).setAttribute("cod","482" );
      ((Element)v.get(317)).appendChild((Element)v.get(330));

      /* Elemento padre:330 / Elemento actual: 331   */
      v.add(doc.createTextNode("Atributo 2"));
      ((Element)v.get(330)).appendChild((Text)v.get(331));

      /* Termina nodo Texto:331   */
      /* Termina nodo:330   */

      /* Empieza nodo:332 / Elemento padre: 317   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(332)).setAttribute("colFondo","" );
      ((Element)v.get(332)).setAttribute("ID","EstCab" );
      ((Element)v.get(332)).setAttribute("cod","483" );
      ((Element)v.get(317)).appendChild((Element)v.get(332));

      /* Elemento padre:332 / Elemento actual: 333   */
      v.add(doc.createTextNode("Atributo 3"));
      ((Element)v.get(332)).appendChild((Text)v.get(333));

      /* Termina nodo Texto:333   */
      /* Termina nodo:332   */
      /* Termina nodo:317   */

      /* Empieza nodo:334 / Elemento padre: 296   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(334)).setAttribute("alto","22" );
      ((Element)v.get(334)).setAttribute("accion","" );
      ((Element)v.get(334)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(334)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(334)).setAttribute("maxSel","-1" );
      ((Element)v.get(334)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(334)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(334)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(334)).setAttribute("onLoad","" );
      ((Element)v.get(334)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(296)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(335)).setAttribute("tipo","texto" );
      ((Element)v.get(335)).setAttribute("ID","EstDat" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */

      /* Empieza nodo:336 / Elemento padre: 334   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(336)).setAttribute("tipo","texto" );
      ((Element)v.get(336)).setAttribute("ID","EstDat2" );
      ((Element)v.get(334)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */

      /* Empieza nodo:337 / Elemento padre: 334   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(337)).setAttribute("tipo","texto" );
      ((Element)v.get(337)).setAttribute("ID","EstDat" );
      ((Element)v.get(334)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */

      /* Empieza nodo:338 / Elemento padre: 334   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(338)).setAttribute("tipo","texto" );
      ((Element)v.get(338)).setAttribute("ID","EstDat2" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(334)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */

      /* Empieza nodo:339 / Elemento padre: 334   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(339)).setAttribute("tipo","texto" );
      ((Element)v.get(339)).setAttribute("ID","EstDat" );
      ((Element)v.get(334)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */

      /* Empieza nodo:340 / Elemento padre: 334   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(340)).setAttribute("tipo","texto" );
      ((Element)v.get(340)).setAttribute("ID","EstDat2" );
      ((Element)v.get(334)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */

      /* Empieza nodo:341 / Elemento padre: 334   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(341)).setAttribute("tipo","texto" );
      ((Element)v.get(341)).setAttribute("ID","EstDat" );
      ((Element)v.get(334)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */

      /* Empieza nodo:342 / Elemento padre: 334   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(342)).setAttribute("tipo","texto" );
      ((Element)v.get(342)).setAttribute("ID","EstDat2" );
      ((Element)v.get(334)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */

      /* Empieza nodo:343 / Elemento padre: 334   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(343)).setAttribute("tipo","texto" );
      ((Element)v.get(343)).setAttribute("ID","EstDat" );
      ((Element)v.get(334)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */

      /* Empieza nodo:344 / Elemento padre: 334   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(344)).setAttribute("tipo","texto" );
      ((Element)v.get(344)).setAttribute("ID","EstDat2" );
      ((Element)v.get(334)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:334   */

      /* Empieza nodo:345 / Elemento padre: 296   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(296)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */

      /* Empieza nodo:346 / Elemento padre: 296   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(346)).setAttribute("nombre","mipgndo3" );
      ((Element)v.get(346)).setAttribute("ancho","664" );
      ((Element)v.get(346)).setAttribute("sep","$" );
      ((Element)v.get(346)).setAttribute("x","12" );
      ((Element)v.get(346)).setAttribute("class","botonera" );
      ((Element)v.get(346)).setAttribute("y","535" );
      ((Element)v.get(346)).setAttribute("control","|" );
      ((Element)v.get(346)).setAttribute("conector","conector_victor" );
      ((Element)v.get(346)).setAttribute("rowset","" );
      ((Element)v.get(346)).setAttribute("cargainicial","N" );
      ((Element)v.get(346)).setAttribute("onload","procesarPaginado(mipgndo3,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(296)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(347)).setAttribute("nombre","ret3" );
      ((Element)v.get(347)).setAttribute("x","37" );
      ((Element)v.get(347)).setAttribute("y","539" );
      ((Element)v.get(347)).setAttribute("ID","botonContenido" );
      ((Element)v.get(347)).setAttribute("img","retroceder_on" );
      ((Element)v.get(347)).setAttribute("tipo","1" );
      ((Element)v.get(347)).setAttribute("estado","false" );
      ((Element)v.get(347)).setAttribute("alt","" );
      ((Element)v.get(347)).setAttribute("codigo","" );
      ((Element)v.get(347)).setAttribute("accion","mipgndo3.retroceder();" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */

      /* Empieza nodo:348 / Elemento padre: 346   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(348)).setAttribute("nombre","ava3" );
      ((Element)v.get(348)).setAttribute("x","52" );
      ((Element)v.get(348)).setAttribute("y","539" );
      ((Element)v.get(348)).setAttribute("ID","botonContenido" );
      ((Element)v.get(348)).setAttribute("img","avanzar_on" );
      ((Element)v.get(348)).setAttribute("tipo","1" );
      ((Element)v.get(348)).setAttribute("estado","false" );
      ((Element)v.get(348)).setAttribute("alt","" );
      ((Element)v.get(348)).setAttribute("codigo","" );
      ((Element)v.get(348)).setAttribute("accion","mipgndo3.avanzar();" );
      ((Element)v.get(346)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:346   */
      /* Termina nodo:296   */

      /* Empieza nodo:349 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(349)).setAttribute("nombre","AnadirMae" );
      ((Element)v.get(349)).setAttribute("x","80" );
      ((Element)v.get(349)).setAttribute("y","536" );
      ((Element)v.get(349)).setAttribute("ID","botonContenido" );
      ((Element)v.get(349)).setAttribute("tipo","html" );
      ((Element)v.get(349)).setAttribute("estado","false" );
      ((Element)v.get(349)).setAttribute("cod","404" );
      ((Element)v.get(349)).setAttribute("accion","botonAniadirBis();" );
      ((Element)v.get(349)).setAttribute("onshtab","focalizaBotonHTML('botonContenido','btnBuscar');" );
      ((Element)v.get(349)).setAttribute("ontab","focalizaBotonHTML('botonContenido','Eliminar');" );
      ((Element)v.get(7)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */

      /* Empieza nodo:350 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(350)).setAttribute("nombre","prim3" );
      ((Element)v.get(350)).setAttribute("x","20" );
      ((Element)v.get(350)).setAttribute("y","539" );
      ((Element)v.get(350)).setAttribute("ID","botonContenido" );
      ((Element)v.get(350)).setAttribute("img","primera_on" );
      ((Element)v.get(350)).setAttribute("tipo","-2" );
      ((Element)v.get(350)).setAttribute("estado","false" );
      ((Element)v.get(350)).setAttribute("alt","" );
      ((Element)v.get(350)).setAttribute("codigo","" );
      ((Element)v.get(350)).setAttribute("accion","mipgndo3.retrocederPrimeraPagina();" );
      ((Element)v.get(7)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */

      /* Empieza nodo:351 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(351)).setAttribute("nombre","separa3" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(351)).setAttribute("x","59" );
      ((Element)v.get(351)).setAttribute("y","535" );
      ((Element)v.get(351)).setAttribute("ID","botonContenido" );
      ((Element)v.get(351)).setAttribute("img","separa_base" );
      ((Element)v.get(351)).setAttribute("tipo","0" );
      ((Element)v.get(351)).setAttribute("estado","false" );
      ((Element)v.get(351)).setAttribute("alt","" );
      ((Element)v.get(351)).setAttribute("codigo","" );
      ((Element)v.get(351)).setAttribute("accion","" );
      ((Element)v.get(7)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */

      /* Empieza nodo:352 / Elemento padre: 7   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(352)).setAttribute("nombre","listado2" );
      ((Element)v.get(352)).setAttribute("ancho","664" );
      ((Element)v.get(352)).setAttribute("alto","317" );
      ((Element)v.get(352)).setAttribute("x","12" );
      ((Element)v.get(352)).setAttribute("y","582" );
      ((Element)v.get(352)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(352)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(7)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(353)).setAttribute("precarga","S" );
      ((Element)v.get(353)).setAttribute("conROver","S" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(354)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(354)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(354)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(354)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */

      /* Empieza nodo:355 / Elemento padre: 353   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(355)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(355)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(355)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(355)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(353)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */

      /* Empieza nodo:356 / Elemento padre: 353   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(356)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(356)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(353)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */
      /* Termina nodo:353   */

      /* Empieza nodo:357 / Elemento padre: 352   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(352)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(358)).setAttribute("borde","1" );
      ((Element)v.get(358)).setAttribute("horizDatos","1" );
      ((Element)v.get(358)).setAttribute("horizCabecera","1" );
      ((Element)v.get(358)).setAttribute("vertical","1" );
      ((Element)v.get(358)).setAttribute("horizTitulo","1" );
      ((Element)v.get(358)).setAttribute("horizBase","1" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */

      /* Empieza nodo:359 / Elemento padre: 357   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(359)).setAttribute("borde","#999999" );
      ((Element)v.get(359)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(359)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(359)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(359)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(359)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(359)).setAttribute("horizBase","#999999" );
      ((Element)v.get(357)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */
      /* Termina nodo:357   */

      /* Empieza nodo:360 / Elemento padre: 352   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(360)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(360)).setAttribute("alto","22" );
      ((Element)v.get(360)).setAttribute("imgFondo","" );
      ((Element)v.get(360)).setAttribute("cod","00499" );
      ((Element)v.get(360)).setAttribute("ID","datosTitle" );
      ((Element)v.get(352)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */

      /* Empieza nodo:361 / Elemento padre: 352   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(361)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(361)).setAttribute("alto","22" );
      ((Element)v.get(361)).setAttribute("imgFondo","" );
      ((Element)v.get(352)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */

      /* Empieza nodo:362 / Elemento padre: 352   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(362)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(362)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(362)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(362)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(362)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(362)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(352)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(363)).setAttribute("ancho","100" );
      ((Element)v.get(363)).setAttribute("minimizable","S" );
      ((Element)v.get(363)).setAttribute("minimizada","N" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */

      /* Empieza nodo:364 / Elemento padre: 362   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(364)).setAttribute("ancho","100" );
      ((Element)v.get(364)).setAttribute("minimizable","S" );
      ((Element)v.get(364)).setAttribute("minimizada","N" );
      ((Element)v.get(362)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */

      /* Empieza nodo:365 / Elemento padre: 362   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(365)).setAttribute("ancho","100" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(365)).setAttribute("minimizable","S" );
      ((Element)v.get(365)).setAttribute("minimizada","N" );
      ((Element)v.get(362)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */

      /* Empieza nodo:366 / Elemento padre: 362   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(366)).setAttribute("ancho","100" );
      ((Element)v.get(366)).setAttribute("minimizable","S" );
      ((Element)v.get(366)).setAttribute("minimizada","N" );
      ((Element)v.get(362)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */

      /* Empieza nodo:367 / Elemento padre: 362   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(367)).setAttribute("ancho","100" );
      ((Element)v.get(367)).setAttribute("minimizable","S" );
      ((Element)v.get(367)).setAttribute("minimizada","N" );
      ((Element)v.get(362)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */

      /* Empieza nodo:368 / Elemento padre: 362   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(368)).setAttribute("ancho","100" );
      ((Element)v.get(368)).setAttribute("minimizable","S" );
      ((Element)v.get(368)).setAttribute("minimizada","N" );
      ((Element)v.get(362)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */

      /* Empieza nodo:369 / Elemento padre: 362   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(369)).setAttribute("ancho","100" );
      ((Element)v.get(369)).setAttribute("minimizable","S" );
      ((Element)v.get(369)).setAttribute("minimizada","N" );
      ((Element)v.get(362)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */

      /* Empieza nodo:370 / Elemento padre: 362   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(370)).setAttribute("ancho","100" );
      ((Element)v.get(370)).setAttribute("minimizable","S" );
      ((Element)v.get(370)).setAttribute("minimizada","N" );
      ((Element)v.get(362)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */

      /* Empieza nodo:371 / Elemento padre: 362   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(371)).setAttribute("ancho","100" );
      ((Element)v.get(371)).setAttribute("minimizable","S" );
      ((Element)v.get(371)).setAttribute("minimizada","N" );
      ((Element)v.get(362)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */

      /* Empieza nodo:372 / Elemento padre: 362   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(372)).setAttribute("ancho","0" );
      ((Element)v.get(372)).setAttribute("minimizable","S" );
      ((Element)v.get(372)).setAttribute("minimizada","S" );
      ((Element)v.get(362)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */

      /* Empieza nodo:373 / Elemento padre: 362   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(373)).setAttribute("ancho","0" );
      ((Element)v.get(373)).setAttribute("minimizable","S" );
      ((Element)v.get(373)).setAttribute("minimizada","S" );
      ((Element)v.get(362)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */

      /* Empieza nodo:374 / Elemento padre: 362   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(374)).setAttribute("ancho","0" );
      ((Element)v.get(374)).setAttribute("minimizable","S" );
      ((Element)v.get(374)).setAttribute("minimizada","S" );
      ((Element)v.get(362)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */

      /* Empieza nodo:375 / Elemento padre: 362   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(375)).setAttribute("ancho","0" );
      ((Element)v.get(375)).setAttribute("minimizable","S" );
      ((Element)v.get(375)).setAttribute("minimizada","S" );
      ((Element)v.get(362)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */

      /* Empieza nodo:376 / Elemento padre: 362   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(376)).setAttribute("ancho","0" );
      ((Element)v.get(376)).setAttribute("minimizable","S" );
      ((Element)v.get(376)).setAttribute("minimizada","S" );
      ((Element)v.get(362)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */

      /* Empieza nodo:377 / Elemento padre: 362   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(377)).setAttribute("ancho","0" );
      ((Element)v.get(377)).setAttribute("minimizable","S" );
      ((Element)v.get(377)).setAttribute("minimizada","S" );
      ((Element)v.get(362)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */

      /* Empieza nodo:378 / Elemento padre: 362   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(378)).setAttribute("ancho","0" );
      ((Element)v.get(378)).setAttribute("minimizable","S" );
      ((Element)v.get(378)).setAttribute("minimizada","S" );
      ((Element)v.get(362)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */

      /* Empieza nodo:379 / Elemento padre: 362   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(379)).setAttribute("ancho","0" );
      ((Element)v.get(379)).setAttribute("minimizable","S" );
      ((Element)v.get(379)).setAttribute("minimizada","S" );
      ((Element)v.get(362)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */

      /* Empieza nodo:380 / Elemento padre: 362   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(380)).setAttribute("ancho","0" );
      ((Element)v.get(380)).setAttribute("minimizable","S" );
      ((Element)v.get(380)).setAttribute("minimizada","S" );
      ((Element)v.get(362)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */

      /* Empieza nodo:381 / Elemento padre: 362   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(381)).setAttribute("ancho","0" );
      ((Element)v.get(381)).setAttribute("minimizable","S" );
      ((Element)v.get(381)).setAttribute("minimizada","S" );
      ((Element)v.get(362)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */

      /* Empieza nodo:382 / Elemento padre: 362   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(382)).setAttribute("ancho","0" );
      ((Element)v.get(382)).setAttribute("minimizable","S" );
      ((Element)v.get(382)).setAttribute("minimizada","S" );
      ((Element)v.get(362)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */

      /* Empieza nodo:383 / Elemento padre: 362   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(383)).setAttribute("ancho","0" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(383)).setAttribute("minimizable","S" );
      ((Element)v.get(383)).setAttribute("minimizada","S" );
      ((Element)v.get(362)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */

      /* Empieza nodo:384 / Elemento padre: 362   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(384)).setAttribute("ancho","0" );
      ((Element)v.get(384)).setAttribute("minimizable","S" );
      ((Element)v.get(384)).setAttribute("minimizada","S" );
      ((Element)v.get(362)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */

      /* Empieza nodo:385 / Elemento padre: 362   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(385)).setAttribute("ancho","0" );
      ((Element)v.get(385)).setAttribute("minimizable","S" );
      ((Element)v.get(385)).setAttribute("minimizada","S" );
      ((Element)v.get(362)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */

      /* Empieza nodo:386 / Elemento padre: 362   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(386)).setAttribute("ancho","0" );
      ((Element)v.get(386)).setAttribute("minimizable","S" );
      ((Element)v.get(386)).setAttribute("minimizada","S" );
      ((Element)v.get(362)).appendChild((Element)v.get(386));
      /* Termina nodo:386   */
      /* Termina nodo:362   */

      /* Empieza nodo:387 / Elemento padre: 352   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(387)).setAttribute("alto","20" );
      ((Element)v.get(387)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(387)).setAttribute("imgFondo","" );
      ((Element)v.get(387)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(352)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(388)).setAttribute("colFondo","" );
      ((Element)v.get(388)).setAttribute("ID","EstCab" );
      ((Element)v.get(388)).setAttribute("cod","337" );
      ((Element)v.get(387)).appendChild((Element)v.get(388));

      /* Elemento padre:388 / Elemento actual: 389   */
      v.add(doc.createTextNode("Cód. producto"));
      ((Element)v.get(388)).appendChild((Text)v.get(389));

      /* Termina nodo Texto:389   */
      /* Termina nodo:388   */

      /* Empieza nodo:390 / Elemento padre: 387   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(390)).setAttribute("colFondo","" );
      ((Element)v.get(390)).setAttribute("ID","EstCab" );
      ((Element)v.get(390)).setAttribute("cod","9" );
      ((Element)v.get(387)).appendChild((Element)v.get(390));

      /* Elemento padre:390 / Elemento actual: 391   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(390)).appendChild((Text)v.get(391));

      /* Termina nodo Texto:391   */
      /* Termina nodo:390   */

      /* Empieza nodo:392 / Elemento padre: 387   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(392)).setAttribute("colFondo","" );
      ((Element)v.get(392)).setAttribute("ID","EstCab" );
      ((Element)v.get(392)).setAttribute("cod","503" );
      ((Element)v.get(387)).appendChild((Element)v.get(392));

      /* Elemento padre:392 / Elemento actual: 393   */
      v.add(doc.createTextNode("Precio catálogo"));
      ((Element)v.get(392)).appendChild((Text)v.get(393));

      /* Termina nodo Texto:393   */
      /* Termina nodo:392   */

      /* Empieza nodo:394 / Elemento padre: 387   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(394)).setAttribute("colFondo","" );
      ((Element)v.get(394)).setAttribute("ID","EstCab" );
      ((Element)v.get(394)).setAttribute("cod","592" );
      ((Element)v.get(387)).appendChild((Element)v.get(394));

      /* Elemento padre:394 / Elemento actual: 395   */
      v.add(doc.createTextNode("Página"));
      ((Element)v.get(394)).appendChild((Text)v.get(395));

      /* Termina nodo Texto:395   */
      /* Termina nodo:394   */

      /* Empieza nodo:396 / Elemento padre: 387   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(396)).setAttribute("colFondo","" );
      ((Element)v.get(396)).setAttribute("ID","EstCab" );
      ((Element)v.get(396)).setAttribute("cod","608" );
      ((Element)v.get(387)).appendChild((Element)v.get(396));

      /* Elemento padre:396 / Elemento actual: 397   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(396)).appendChild((Text)v.get(397));

      /* Termina nodo Texto:397   */
      /* Termina nodo:396   */

      /* Empieza nodo:398 / Elemento padre: 387   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(398)).setAttribute("colFondo","" );
      ((Element)v.get(398)).setAttribute("ID","EstCab" );
      ((Element)v.get(398)).setAttribute("cod","581" );
      ((Element)v.get(387)).appendChild((Element)v.get(398));

      /* Elemento padre:398 / Elemento actual: 399   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(398)).appendChild((Text)v.get(399));

      /* Termina nodo Texto:399   */
      /* Termina nodo:398   */

      /* Empieza nodo:400 / Elemento padre: 387   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(400)).setAttribute("colFondo","" );
      ((Element)v.get(400)).setAttribute("ID","EstCab" );
      ((Element)v.get(400)).setAttribute("cod","481" );
      ((Element)v.get(387)).appendChild((Element)v.get(400));

      /* Elemento padre:400 / Elemento actual: 401   */
      v.add(doc.createTextNode("Atributo 1"));
      ((Element)v.get(400)).appendChild((Text)v.get(401));

      /* Termina nodo Texto:401   */
      /* Termina nodo:400   */

      /* Empieza nodo:402 / Elemento padre: 387   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(402)).setAttribute("colFondo","" );
      ((Element)v.get(402)).setAttribute("ID","EstCab" );
      ((Element)v.get(402)).setAttribute("cod","482" );
      ((Element)v.get(387)).appendChild((Element)v.get(402));

      /* Elemento padre:402 / Elemento actual: 403   */
      v.add(doc.createTextNode("Atributo 2"));
      ((Element)v.get(402)).appendChild((Text)v.get(403));

      /* Termina nodo Texto:403   */
      /* Termina nodo:402   */

      /* Empieza nodo:404 / Elemento padre: 387   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(404)).setAttribute("colFondo","" );
      ((Element)v.get(404)).setAttribute("ID","EstCab" );
      ((Element)v.get(404)).setAttribute("cod","483" );
      ((Element)v.get(387)).appendChild((Element)v.get(404));

      /* Elemento padre:404 / Elemento actual: 405   */
      v.add(doc.createTextNode("Atributo 3"));
      ((Element)v.get(404)).appendChild((Text)v.get(405));

      /* Termina nodo Texto:405   */
      /* Termina nodo:404   */
      /* Termina nodo:387   */

      /* Empieza nodo:406 / Elemento padre: 352   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(406)).setAttribute("alto","22" );
      ((Element)v.get(406)).setAttribute("accion","" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(406)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(406)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(406)).setAttribute("maxSel","-1" );
      ((Element)v.get(406)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(406)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(406)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(406)).setAttribute("onLoad","" );
      ((Element)v.get(406)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(352)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(407)).setAttribute("tipo","texto" );
      ((Element)v.get(407)).setAttribute("ID","EstDat" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */

      /* Empieza nodo:408 / Elemento padre: 406   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(408)).setAttribute("tipo","texto" );
      ((Element)v.get(408)).setAttribute("ID","EstDat2" );
      ((Element)v.get(406)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */

      /* Empieza nodo:409 / Elemento padre: 406   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(409)).setAttribute("tipo","texto" );
      ((Element)v.get(409)).setAttribute("ID","EstDat" );
      ((Element)v.get(406)).appendChild((Element)v.get(409));
      /* Termina nodo:409   */

      /* Empieza nodo:410 / Elemento padre: 406   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(410)).setAttribute("tipo","texto" );
      ((Element)v.get(410)).setAttribute("ID","EstDat2" );
      ((Element)v.get(406)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */

      /* Empieza nodo:411 / Elemento padre: 406   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(411)).setAttribute("tipo","texto" );
      ((Element)v.get(411)).setAttribute("ID","EstDat2" );
      ((Element)v.get(406)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */

      /* Empieza nodo:412 / Elemento padre: 406   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(412)).setAttribute("tipo","texto" );
      ((Element)v.get(412)).setAttribute("ID","EstDat" );
      ((Element)v.get(406)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */

      /* Empieza nodo:413 / Elemento padre: 406   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(413)).setAttribute("tipo","texto" );
      ((Element)v.get(413)).setAttribute("ID","EstDat2" );
      ((Element)v.get(406)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */

      /* Empieza nodo:414 / Elemento padre: 406   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(414)).setAttribute("tipo","texto" );
      ((Element)v.get(414)).setAttribute("ID","EstDat" );
      ((Element)v.get(406)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */

      /* Empieza nodo:415 / Elemento padre: 406   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(415)).setAttribute("tipo","texto" );
      ((Element)v.get(415)).setAttribute("ID","EstDat2" );
      ((Element)v.get(406)).appendChild((Element)v.get(415));
      /* Termina nodo:415   */

      /* Empieza nodo:416 / Elemento padre: 406   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(416)).setAttribute("tipo","texto" );
      ((Element)v.get(416)).setAttribute("ID","EstDat" );
      ((Element)v.get(406)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */

      /* Empieza nodo:417 / Elemento padre: 406   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(417)).setAttribute("tipo","texto" );
      ((Element)v.get(417)).setAttribute("ID","EstDat2" );
      ((Element)v.get(406)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */

      /* Empieza nodo:418 / Elemento padre: 406   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(418)).setAttribute("tipo","texto" );
      ((Element)v.get(418)).setAttribute("ID","EstDat" );
      ((Element)v.get(406)).appendChild((Element)v.get(418));
      /* Termina nodo:418   */

      /* Empieza nodo:419 / Elemento padre: 406   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(419)).setAttribute("tipo","texto" );
      ((Element)v.get(419)).setAttribute("ID","EstDat2" );
      ((Element)v.get(406)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */

      /* Empieza nodo:420 / Elemento padre: 406   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(420)).setAttribute("tipo","texto" );
      ((Element)v.get(420)).setAttribute("ID","EstDat" );
      ((Element)v.get(406)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */

      /* Empieza nodo:421 / Elemento padre: 406   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(421)).setAttribute("tipo","texto" );
      ((Element)v.get(421)).setAttribute("ID","EstDat2" );
      ((Element)v.get(406)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */

      /* Empieza nodo:422 / Elemento padre: 406   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(422)).setAttribute("tipo","texto" );
      ((Element)v.get(422)).setAttribute("ID","EstDat" );
      ((Element)v.get(406)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */

      /* Empieza nodo:423 / Elemento padre: 406   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(423)).setAttribute("tipo","texto" );
      ((Element)v.get(423)).setAttribute("ID","EstDat2" );
      ((Element)v.get(406)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */

      /* Empieza nodo:424 / Elemento padre: 406   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(424)).setAttribute("tipo","texto" );
      ((Element)v.get(424)).setAttribute("ID","EstDat" );
      ((Element)v.get(406)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */

      /* Empieza nodo:425 / Elemento padre: 406   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(425)).setAttribute("tipo","texto" );
      ((Element)v.get(425)).setAttribute("ID","EstDat" );
      ((Element)v.get(406)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */

      /* Empieza nodo:426 / Elemento padre: 406   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(426)).setAttribute("tipo","texto" );
      ((Element)v.get(426)).setAttribute("ID","EstDat2" );
      ((Element)v.get(406)).appendChild((Element)v.get(426));
      /* Termina nodo:426   */

      /* Empieza nodo:427 / Elemento padre: 406   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(427)).setAttribute("tipo","texto" );
      ((Element)v.get(427)).setAttribute("ID","EstDat" );
      ((Element)v.get(406)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */

      /* Empieza nodo:428 / Elemento padre: 406   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(428)).setAttribute("tipo","texto" );
      ((Element)v.get(428)).setAttribute("ID","EstDat2" );
      ((Element)v.get(406)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */

      /* Empieza nodo:429 / Elemento padre: 406   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(429)).setAttribute("tipo","texto" );
      ((Element)v.get(429)).setAttribute("ID","EstDat" );
      ((Element)v.get(406)).appendChild((Element)v.get(429));
      /* Termina nodo:429   */

      /* Empieza nodo:430 / Elemento padre: 406   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(430)).setAttribute("tipo","texto" );
      ((Element)v.get(430)).setAttribute("ID","EstDat2" );
      ((Element)v.get(406)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */
      /* Termina nodo:406   */

      /* Empieza nodo:431 / Elemento padre: 352   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(352)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */

      /* Empieza nodo:432 / Elemento padre: 352   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(432)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(432)).setAttribute("ancho","664" );
      ((Element)v.get(432)).setAttribute("sep","$" );
      ((Element)v.get(432)).setAttribute("x","12" );
      ((Element)v.get(432)).setAttribute("class","botonera" );
      ((Element)v.get(432)).setAttribute("y","876" );
      ((Element)v.get(432)).setAttribute("control","|" );
      ((Element)v.get(432)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(432)).setAttribute("rowset","" );
      ((Element)v.get(432)).setAttribute("cargainicial","N" );
      ((Element)v.get(352)).appendChild((Element)v.get(432));
      /* Termina nodo:432   */
      /* Termina nodo:352   */

      /* Empieza nodo:433 / Elemento padre: 7   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(433)).setAttribute("nombre","Eliminar" );
      ((Element)v.get(433)).setAttribute("x","13" );
      ((Element)v.get(433)).setAttribute("y","877" );
      ((Element)v.get(433)).setAttribute("ID","botonContenido" );
      ((Element)v.get(433)).setAttribute("tipo","html" );
      ((Element)v.get(433)).setAttribute("estado","false" );
      ((Element)v.get(433)).setAttribute("cod","1254" );
      ((Element)v.get(433)).setAttribute("accion","botonEliminar();" );
      ((Element)v.get(433)).setAttribute("onshtab","focalizaEliminarOnShTab();" );
      ((Element)v.get(433)).setAttribute("ontab","focaliza('frmContenido.txtCodSAP');" );
      ((Element)v.get(7)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */

      /* Empieza nodo:434 / Elemento padre: 7   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(434)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(434)).setAttribute("alto","12" );
      ((Element)v.get(434)).setAttribute("ancho","50" );
      ((Element)v.get(434)).setAttribute("colorf","" );
      ((Element)v.get(434)).setAttribute("borde","0" );
      ((Element)v.get(434)).setAttribute("imagenf","" );
      ((Element)v.get(434)).setAttribute("repeat","" );
      ((Element)v.get(434)).setAttribute("padding","" );
      ((Element)v.get(434)).setAttribute("visibilidad","visible" );
      ((Element)v.get(434)).setAttribute("contravsb","" );
      ((Element)v.get(434)).setAttribute("x","0" );
      ((Element)v.get(434)).setAttribute("y","899" );
      ((Element)v.get(434)).setAttribute("zindex","" );
      ((Element)v.get(7)).appendChild((Element)v.get(434));
      /* Termina nodo:434   */
      /* Termina nodo:7   */


   }

}

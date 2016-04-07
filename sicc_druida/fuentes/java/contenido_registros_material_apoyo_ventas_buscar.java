
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_registros_material_apoyo_ventas_buscar  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML2070(doc);
         

      getXML2160(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_registros_material_apoyo_ventas_buscar" );
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
      ((Element)v.get(2)).setAttribute("src","contenido_registros_material_apoyo_ventas_buscar.js" );
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
      ((Element)v.get(5)).setAttribute("src","validaciones_sicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(6)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));

      /* Empieza nodo:7 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","accion" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","casoUso" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","oidPais" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","oidIdioma" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","hidCriterioOrdenacion" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","hidSelMarca" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","hidSelCanal" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","hidSelSubg" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hidSelRegion" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hidSelZona" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hidSelActividad" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hidSelPeriodo" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hidSelEstadoEnvio" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hidSelEstadoAutorizacion" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hidSelCriterio" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hidSelTipoCliente" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hidSelTipoDespacho" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hidSelTipoProductos" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hidReentrandoBusqueda" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hidContenidoProductos" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hidAgrupacionCliente" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hidAgrupacionDespacho" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hidAgrupacionProductos" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 6   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hidProductosCD" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(6)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 6   */
      v.add(doc.createElement("table"));
      ((Element)v.get(34)).setAttribute("width","100%" );
      ((Element)v.get(34)).setAttribute("border","0" );
      ((Element)v.get(34)).setAttribute("cellspacing","0" );
      ((Element)v.get(34)).setAttribute("cellpadding","0" );
      ((Element)v.get(6)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(35));

      /* Empieza nodo:36 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(36)).setAttribute("width","12" );
      ((Element)v.get(36)).setAttribute("align","center" );
      ((Element)v.get(35)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(37)).setAttribute("src","b.gif" );
      ((Element)v.get(37)).setAttribute("width","12" );
      ((Element)v.get(37)).setAttribute("height","12" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:38 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(38)).setAttribute("width","750" );
      ((Element)v.get(35)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(39)).setAttribute("src","b.gif" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 35   */
      v.add(doc.createElement("td"));
      ((Element)v.get(40)).setAttribute("width","12" );
      ((Element)v.get(35)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
      ((Element)v.get(41)).setAttribute("width","12" );
      ((Element)v.get(41)).setAttribute("height","1" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */
      /* Termina nodo:35   */

      /* Empieza nodo:42 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */

      /* Empieza nodo:45 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(47)).setAttribute("class","legend" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(48)).setAttribute("nombre","lblDatosCarga" );
      ((Element)v.get(48)).setAttribute("alto","13" );
      ((Element)v.get(48)).setAttribute("filas","1" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(48)).setAttribute("id","legend" );
      ((Element)v.get(48)).setAttribute("cod","0075" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 46   */
      v.add(doc.createElement("table"));
      ((Element)v.get(49)).setAttribute("width","100%" );
      ((Element)v.get(49)).setAttribute("border","0" );
      ((Element)v.get(49)).setAttribute("align","center" );
      ((Element)v.get(49)).setAttribute("cellspacing","0" );
      ((Element)v.get(49)).setAttribute("cellpadding","0" );
      ((Element)v.get(46)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("table"));
      ((Element)v.get(52)).setAttribute("width","660" );
      ((Element)v.get(52)).setAttribute("border","0" );
      ((Element)v.get(52)).setAttribute("align","left" );
      ((Element)v.get(52)).setAttribute("cellspacing","0" );
      ((Element)v.get(52)).setAttribute("cellpadding","0" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).setAttribute("colspan","4" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).setAttribute("width","8" );
      ((Element)v.get(55)).setAttribute("height","8" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:56 / Elemento padre: 52   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(52)).appendChild((Element)v.get(56));

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
      ((Element)v.get(60)).setAttribute("nombre","lblPais" );
      ((Element)v.get(60)).setAttribute("alto","13" );
      ((Element)v.get(60)).setAttribute("filas","1" );
      ((Element)v.get(60)).setAttribute("id","datosTitle" );
      ((Element)v.get(60)).setAttribute("cod","5" );
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
      ((Element)v.get(64)).setAttribute("id","datosTitle" );
      ((Element)v.get(64)).setAttribute("cod","6" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(66)).setAttribute("src","b.gif" );
      ((Element)v.get(66)).setAttribute("width","25" );
      ((Element)v.get(66)).setAttribute("height","8" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:67 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(68)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(68)).setAttribute("alto","13" );
      ((Element)v.get(68)).setAttribute("filas","1" );
      ((Element)v.get(68)).setAttribute("id","datosTitle" );
      ((Element)v.get(68)).setAttribute("cod","7" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */
      /* Termina nodo:67   */

      /* Empieza nodo:69 / Elemento padre: 56   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("width","100%" );
      ((Element)v.get(56)).appendChild((Element)v.get(69));

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
      /* Termina nodo:56   */

      /* Empieza nodo:71 / Elemento padre: 52   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(52)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).setAttribute("width","8" );
      ((Element)v.get(73)).setAttribute("height","8" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(75)).setAttribute("nombre","lbldtPais" );
      ((Element)v.get(75)).setAttribute("alto","13" );
      ((Element)v.get(75)).setAttribute("filas","1" );
      ((Element)v.get(75)).setAttribute("id","datosCampos" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","25" );
      ((Element)v.get(77)).setAttribute("height","8" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(79)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(79)).setAttribute("onshtab","shTabMarca();" );
      ((Element)v.get(79)).setAttribute("size","1" );
      ((Element)v.get(79)).setAttribute("multiple","N" );
      ((Element)v.get(79)).setAttribute("valorinicial","" );
      ((Element)v.get(79)).setAttribute("onchange","recargaCombos();" );
      ((Element)v.get(79)).setAttribute("textoinicial","" );
      ((Element)v.get(79)).setAttribute("id","datosCampos" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:81 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","25" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(84)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(84)).setAttribute("size","1" );
      ((Element)v.get(84)).setAttribute("multiple","N" );
      ((Element)v.get(84)).setAttribute("valorinicial","" );
      ((Element)v.get(84)).setAttribute("onchange","recargaCombos();" );
      ((Element)v.get(84)).setAttribute("textoinicial","" );
      ((Element)v.get(84)).setAttribute("id","datosCampos" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:86 / Elemento padre: 71   */
      v.add(doc.createElement("td"));
      ((Element)v.get(86)).setAttribute("width","100%" );
      ((Element)v.get(71)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).setAttribute("width","8" );
      ((Element)v.get(87)).setAttribute("height","8" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:71   */

      /* Empieza nodo:88 / Elemento padre: 52   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(52)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).setAttribute("colspan","4" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","8" );
      ((Element)v.get(90)).setAttribute("height","8" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:52   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:91 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("table"));
      ((Element)v.get(93)).setAttribute("width","660" );
      ((Element)v.get(93)).setAttribute("border","0" );
      ((Element)v.get(93)).setAttribute("align","left" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(93)).setAttribute("cellspacing","0" );
      ((Element)v.get(93)).setAttribute("cellpadding","0" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","8" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(98)).setAttribute("nombre","lblSubgerencia" );
      ((Element)v.get(98)).setAttribute("alto","13" );
      ((Element)v.get(98)).setAttribute("filas","1" );
      ((Element)v.get(98)).setAttribute("id","datosTitle" );
      ((Element)v.get(98)).setAttribute("cod","992" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","25" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(102)).setAttribute("nombre","lblRegion" );
      ((Element)v.get(102)).setAttribute("alto","13" );
      ((Element)v.get(102)).setAttribute("filas","1" );
      ((Element)v.get(102)).setAttribute("id","datosTitle" );
      ((Element)v.get(102)).setAttribute("cod","109" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("width","100%" );
      ((Element)v.get(94)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","8" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:94   */

      /* Empieza nodo:105 / Elemento padre: 93   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(93)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","8" );
      ((Element)v.get(107)).setAttribute("height","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(109)).setAttribute("nombre","cbSubgerencia" );
      ((Element)v.get(109)).setAttribute("onchange","onChangeSubG();" );
      ((Element)v.get(109)).setAttribute("size","5" );
      ((Element)v.get(109)).setAttribute("multiple","S" );
      ((Element)v.get(109)).setAttribute("valorinicial","" );
      ((Element)v.get(109)).setAttribute("textoinicial","" );
      ((Element)v.get(109)).setAttribute("id","datosCampos" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:111 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).setAttribute("width","25" );
      ((Element)v.get(112)).setAttribute("height","8" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(114)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(114)).setAttribute("onchange","onChangeRegiones();" );
      ((Element)v.get(114)).setAttribute("size","5" );
      ((Element)v.get(114)).setAttribute("multiple","S" );
      ((Element)v.get(114)).setAttribute("valorinicial","" );
      ((Element)v.get(114)).setAttribute("textoinicial","" );
      ((Element)v.get(114)).setAttribute("id","datosCampos" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:116 / Elemento padre: 105   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).setAttribute("width","100%" );
      ((Element)v.get(105)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","8" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:105   */

      /* Empieza nodo:118 / Elemento padre: 93   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(93)).appendChild((Element)v.get(118));

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
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:121 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("table"));
      ((Element)v.get(123)).setAttribute("width","660" );
      ((Element)v.get(123)).setAttribute("border","0" );
      ((Element)v.get(123)).setAttribute("align","left" );
      ((Element)v.get(123)).setAttribute("cellspacing","0" );
      ((Element)v.get(123)).setAttribute("cellpadding","0" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","8" );
      ((Element)v.get(126)).setAttribute("height","8" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(128)).setAttribute("nombre","lblZona" );
      ((Element)v.get(128)).setAttribute("alto","13" );
      ((Element)v.get(128)).setAttribute("filas","1" );
      ((Element)v.get(128)).setAttribute("id","datosTitle" );
      ((Element)v.get(128)).setAttribute("cod","143" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","25" );
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(132)).setAttribute("nombre","lblActividad" );
      ((Element)v.get(132)).setAttribute("alto","13" );
      ((Element)v.get(132)).setAttribute("filas","1" );
      ((Element)v.get(132)).setAttribute("id","datosTitle" );
      ((Element)v.get(132)).setAttribute("cod","173" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","25" );
      ((Element)v.get(134)).setAttribute("height","8" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(136)).setAttribute("nombre","lblPeriodo" );
      ((Element)v.get(136)).setAttribute("alto","13" );
      ((Element)v.get(136)).setAttribute("filas","1" );
      ((Element)v.get(136)).setAttribute("id","datosTitle" );
      ((Element)v.get(136)).setAttribute("cod","276" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(137)).setAttribute("width","100%" );
      ((Element)v.get(124)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","8" );
      ((Element)v.get(138)).setAttribute("height","8" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:124   */

      /* Empieza nodo:139 / Elemento padre: 123   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(123)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(141)).setAttribute("width","8" );
      ((Element)v.get(141)).setAttribute("height","8" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:142 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(143)).setAttribute("nombre","cbZona" );
      ((Element)v.get(143)).setAttribute("size","5" );
      ((Element)v.get(143)).setAttribute("multiple","S" );
      ((Element)v.get(143)).setAttribute("valorinicial","" );
      ((Element)v.get(143)).setAttribute("textoinicial","" );
      ((Element)v.get(143)).setAttribute("id","datosCampos" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:145 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","25" );
      ((Element)v.get(146)).setAttribute("height","8" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:147 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).setAttribute("valign","top" );
      ((Element)v.get(139)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(148)).setAttribute("nombre","cbActividad" );
      ((Element)v.get(148)).setAttribute("size","1" );
      ((Element)v.get(148)).setAttribute("multiple","N" );
      ((Element)v.get(148)).setAttribute("valorinicial","" );
      ((Element)v.get(148)).setAttribute("textoinicial","" );
      ((Element)v.get(148)).setAttribute("id","datosCampos" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:150 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(139)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).setAttribute("width","25" );
      ((Element)v.get(151)).setAttribute("height","8" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).setAttribute("valign","top" );
      ((Element)v.get(139)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(153)).setAttribute("nombre","cbPeriodo" );
      ((Element)v.get(153)).setAttribute("size","1" );
      ((Element)v.get(153)).setAttribute("multiple","N" );
      ((Element)v.get(153)).setAttribute("valorinicial","" );
      ((Element)v.get(153)).setAttribute("textoinicial","" );
      ((Element)v.get(153)).setAttribute("id","datosCampos" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:155 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).setAttribute("width","100%" );
      ((Element)v.get(139)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","8" );
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:139   */

      /* Empieza nodo:157 / Elemento padre: 123   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(123)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).setAttribute("colspan","4" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","8" );
      ((Element)v.get(159)).setAttribute("height","8" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:160 / Elemento padre: 49   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(49)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("table"));
      ((Element)v.get(162)).setAttribute("width","660" );
      ((Element)v.get(162)).setAttribute("border","0" );
      ((Element)v.get(162)).setAttribute("align","left" );
      ((Element)v.get(162)).setAttribute("cellspacing","0" );
      ((Element)v.get(162)).setAttribute("cellpadding","0" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(165)).setAttribute("src","b.gif" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(165)).setAttribute("width","8" );
      ((Element)v.get(165)).setAttribute("height","8" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(167)).setAttribute("nombre","lblEstadoEnvio" );
      ((Element)v.get(167)).setAttribute("alto","13" );
      ((Element)v.get(167)).setAttribute("filas","1" );
      ((Element)v.get(167)).setAttribute("id","datosTitle" );
      ((Element)v.get(167)).setAttribute("cod","863" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:168 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(169)).setAttribute("src","b.gif" );
      ((Element)v.get(169)).setAttribute("width","25" );
      ((Element)v.get(169)).setAttribute("height","8" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(171)).setAttribute("nombre","lblEstadoAutorizacion" );
      ((Element)v.get(171)).setAttribute("alto","13" );
      ((Element)v.get(171)).setAttribute("filas","1" );
      ((Element)v.get(171)).setAttribute("id","datosTitle" );
      ((Element)v.get(171)).setAttribute("cod","862" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:172 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(173)).setAttribute("src","b.gif" );
      ((Element)v.get(173)).setAttribute("width","25" );
      ((Element)v.get(173)).setAttribute("height","8" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:174 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(175)).setAttribute("nombre","lblOrdenacion" );
      ((Element)v.get(175)).setAttribute("alto","13" );
      ((Element)v.get(175)).setAttribute("filas","1" );
      ((Element)v.get(175)).setAttribute("id","datosTitle" );
      ((Element)v.get(175)).setAttribute("cod","953" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 163   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).setAttribute("width","100%" );
      ((Element)v.get(163)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","8" );
      ((Element)v.get(177)).setAttribute("height","8" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:163   */

      /* Empieza nodo:178 / Elemento padre: 162   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(162)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(180)).setAttribute("src","b.gif" );
      ((Element)v.get(180)).setAttribute("width","8" );
      ((Element)v.get(180)).setAttribute("height","8" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(182)).setAttribute("nombre","cbEstadoEnvio" );
      ((Element)v.get(182)).setAttribute("size","1" );
      ((Element)v.get(182)).setAttribute("multiple","N" );
      ((Element)v.get(182)).setAttribute("valorinicial","" );
      ((Element)v.get(182)).setAttribute("textoinicial","" );
      ((Element)v.get(182)).setAttribute("id","datosCampos" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:184 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(185)).setAttribute("src","b.gif" );
      ((Element)v.get(185)).setAttribute("width","25" );
      ((Element)v.get(185)).setAttribute("height","8" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(187)).setAttribute("nombre","cbEstadoAutorizacion" );
      ((Element)v.get(187)).setAttribute("size","1" );
      ((Element)v.get(187)).setAttribute("multiple","N" );
      ((Element)v.get(187)).setAttribute("valorinicial","" );
      ((Element)v.get(187)).setAttribute("textoinicial","" );
      ((Element)v.get(187)).setAttribute("id","datosCampos" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
   }

   private void getXML720(Document doc) {
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:189 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","25" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(178)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("table"));
      ((Element)v.get(192)).setAttribute("width","100%" );
      ((Element)v.get(192)).setAttribute("border","0" );
      ((Element)v.get(192)).setAttribute("cellspacing","0" );
      ((Element)v.get(192)).setAttribute("cellpadding","0" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).setAttribute("class","datosCampos" );
      ((Element)v.get(194)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(195)).setAttribute("nombre","rbOrdenacion" );
      ((Element)v.get(195)).setAttribute("ontab","tabOrdenacion();" );
      ((Element)v.get(195)).setAttribute("tipo","H" );
      ((Element)v.get(195)).setAttribute("id","datosCampos" );
      ((Element)v.get(195)).setAttribute("onclick","muestraCapaSEBA()" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(196)).setAttribute("valor","Cliente" );
      ((Element)v.get(196)).setAttribute("check","S" );
      ((Element)v.get(196)).setAttribute("onfocus","" );
      ((Element)v.get(196)).setAttribute("id","datosCampos" );
      ((Element)v.get(196)).setAttribute("cod","393" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Elemento padre:196 / Elemento actual: 197   */
      v.add(doc.createTextNode("yy"));
      ((Element)v.get(196)).appendChild((Text)v.get(197));

      /* Termina nodo Texto:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 195   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(198)).setAttribute("valor","Producto" );
      ((Element)v.get(198)).setAttribute("check","N" );
      ((Element)v.get(198)).setAttribute("onfocus","" );
      ((Element)v.get(198)).setAttribute("id","datosCampos" );
      ((Element)v.get(198)).setAttribute("cod","515" );
      ((Element)v.get(195)).appendChild((Element)v.get(198));

      /* Elemento padre:198 / Elemento actual: 199   */
      v.add(doc.createTextNode("nn"));
      ((Element)v.get(198)).appendChild((Text)v.get(199));

      /* Termina nodo Texto:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 195   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(200)).setAttribute("valor","Despacho" );
      ((Element)v.get(200)).setAttribute("check","N" );
      ((Element)v.get(200)).setAttribute("onfocus","" );
      ((Element)v.get(200)).setAttribute("id","datosCampos" );
      ((Element)v.get(200)).setAttribute("cod","1000" );
      ((Element)v.get(195)).appendChild((Element)v.get(200));

      /* Elemento padre:200 / Elemento actual: 201   */
      v.add(doc.createTextNode("nn"));
      ((Element)v.get(200)).appendChild((Text)v.get(201));

      /* Termina nodo Texto:201   */
      /* Termina nodo:200   */
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:202 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).setAttribute("width","100%" );
      ((Element)v.get(178)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(203)).setAttribute("src","b.gif" );
      ((Element)v.get(203)).setAttribute("width","8" );
      ((Element)v.get(203)).setAttribute("height","8" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */
      /* Termina nodo:178   */

      /* Empieza nodo:204 / Elemento padre: 162   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(162)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).setAttribute("colspan","4" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).setAttribute("width","8" );
      ((Element)v.get(206)).setAttribute("height","94" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */
      /* Termina nodo:204   */
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:49   */
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:207 / Elemento padre: 42   */
      v.add(doc.createElement("td"));
      ((Element)v.get(42)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:42   */

      /* Empieza nodo:209 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("table"));
      ((Element)v.get(214)).setAttribute("width","100%" );
      ((Element)v.get(214)).setAttribute("border","0" );
      ((Element)v.get(214)).setAttribute("align","center" );
      ((Element)v.get(214)).setAttribute("cellspacing","0" );
      ((Element)v.get(214)).setAttribute("cellpadding","0" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(214)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).setAttribute("class","botonera" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(217)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(217)).setAttribute("ID","botonContenido" );
      ((Element)v.get(217)).setAttribute("onshtab","shTabBuscar();" );
      ((Element)v.get(217)).setAttribute("ontab","tabBuscar();" );
      ((Element)v.get(217)).setAttribute("tipo","html" );
      ((Element)v.get(217)).setAttribute("accion","accionBuscar();" );
      ((Element)v.get(217)).setAttribute("estado","false" );
      ((Element)v.get(217)).setAttribute("cod","1" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */
      /* Termina nodo:215   */
      /* Termina nodo:214   */
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:218 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("width","8" );
      ((Element)v.get(219)).setAttribute("height","12" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:209   */

      /* Empieza nodo:220 / Elemento padre: 34   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(34)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).setAttribute("width","12" );
      ((Element)v.get(221)).setAttribute("align","center" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(222)).setAttribute("width","12" );
      ((Element)v.get(222)).setAttribute("height","12" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:223 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).setAttribute("width","756" );
      ((Element)v.get(220)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(224)).setAttribute("src","b.gif" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:225 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).setAttribute("width","12" );
      ((Element)v.get(220)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(226)).setAttribute("src","b.gif" );
      ((Element)v.get(226)).setAttribute("width","12" );
      ((Element)v.get(226)).setAttribute("height","1" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */
      /* Termina nodo:220   */
      /* Termina nodo:34   */

      /* Empieza nodo:227 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(227)).setAttribute("nombre","TipoClientes" );
      ((Element)v.get(227)).setAttribute("alto","80" );
      ((Element)v.get(227)).setAttribute("ancho","600" );
      ((Element)v.get(227)).setAttribute("colorf","" );
      ((Element)v.get(227)).setAttribute("borde","0" );
      ((Element)v.get(227)).setAttribute("imagenf","" );
      ((Element)v.get(227)).setAttribute("repeat","" );
      ((Element)v.get(227)).setAttribute("padding","" );
      ((Element)v.get(227)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(227)).setAttribute("contravsb","" );
      ((Element)v.get(227)).setAttribute("x","22" );
      ((Element)v.get(227)).setAttribute("y","284" );
      ((Element)v.get(227)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("table"));
      ((Element)v.get(228)).setAttribute("width","600" );
      ((Element)v.get(228)).setAttribute("border","0" );
      ((Element)v.get(228)).setAttribute("align","left" );
      ((Element)v.get(228)).setAttribute("cellspacing","0" );
      ((Element)v.get(228)).setAttribute("cellpadding","0" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(231)).setAttribute("nombre","lblTipoClientes" );
      ((Element)v.get(231)).setAttribute("filas","1" );
      ((Element)v.get(231)).setAttribute("id","datosTitle" );
      ((Element)v.get(231)).setAttribute("cod","393" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:232 / Elemento padre: 228   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(228)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(234)).setAttribute("nombre","cbTipoClientes" );
      ((Element)v.get(234)).setAttribute("onshtab","focaliza('formulario.rbOrdenacion', '');" );
      ((Element)v.get(234)).setAttribute("ontab","focalizaBtnBuscar();" );
      ((Element)v.get(234)).setAttribute("size","5" );
      ((Element)v.get(234)).setAttribute("multiple","S" );
      ((Element)v.get(234)).setAttribute("valorinicial","" );
      ((Element)v.get(234)).setAttribute("textoinicial","                " );
      ((Element)v.get(234)).setAttribute("id","datosCampos" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */
      /* Termina nodo:233   */
      /* Termina nodo:232   */
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:236 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(236)).setAttribute("nombre","Productos" );
      ((Element)v.get(236)).setAttribute("alto","80" );
      ((Element)v.get(236)).setAttribute("ancho","600" );
      ((Element)v.get(236)).setAttribute("colorf","" );
      ((Element)v.get(236)).setAttribute("borde","0" );
      ((Element)v.get(236)).setAttribute("imagenf","" );
      ((Element)v.get(236)).setAttribute("repeat","" );
      ((Element)v.get(236)).setAttribute("padding","" );
      ((Element)v.get(236)).setAttribute("visibilidad","" );
      ((Element)v.get(236)).setAttribute("contravsb","" );
      ((Element)v.get(236)).setAttribute("x","22" );
      ((Element)v.get(236)).setAttribute("y","284" );
      ((Element)v.get(236)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("table"));
      ((Element)v.get(237)).setAttribute("width","600" );
      ((Element)v.get(237)).setAttribute("border","0" );
      ((Element)v.get(237)).setAttribute("align","left" );
      ((Element)v.get(237)).setAttribute("cellspacing","0" );
      ((Element)v.get(237)).setAttribute("cellpadding","0" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(237)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).setAttribute("colspan","6" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(240)).setAttribute("nombre","lblProductos" );
      ((Element)v.get(240)).setAttribute("filas","1" );
      ((Element)v.get(240)).setAttribute("id","datosTitle" );
      ((Element)v.get(240)).setAttribute("cod","515" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:241 / Elemento padre: 237   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(237)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("td"));
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(243)).setAttribute("nombre","cbProductos" );
      ((Element)v.get(243)).setAttribute("onshtab","focaliza('formulario.rbOrdenacion', '');" );
      ((Element)v.get(243)).setAttribute("size","5" );
      ((Element)v.get(243)).setAttribute("multiple","S" );
      ((Element)v.get(243)).setAttribute("valorinicial","" );
      ((Element)v.get(243)).setAttribute("textoinicial","                " );
      ((Element)v.get(243)).setAttribute("id","datosCampos" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:245 / Elemento padre: 241   */
      v.add(doc.createElement("td"));
      ((Element)v.get(241)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(246)).setAttribute("src","b.gif" );
      ((Element)v.get(246)).setAttribute("width","8" );
      ((Element)v.get(246)).setAttribute("height","8" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:247 / Elemento padre: 241   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).setAttribute("valign","bottom" );
      ((Element)v.get(241)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(248)).setAttribute("nombre","btnBuscarProducto" );
      ((Element)v.get(248)).setAttribute("ID","botonContenido" );
      ((Element)v.get(248)).setAttribute("tipo","html" );
      ((Element)v.get(248)).setAttribute("accion","buscarProducto();" );
      ((Element)v.get(248)).setAttribute("estado","false" );
      ((Element)v.get(248)).setAttribute("cod","1" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */

      /* Empieza nodo:249 / Elemento padre: 241   */
      v.add(doc.createElement("td"));
      ((Element)v.get(241)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(250)).setAttribute("src","b.gif" );
      ((Element)v.get(250)).setAttribute("width","8" );
      ((Element)v.get(250)).setAttribute("height","8" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */

      /* Empieza nodo:251 / Elemento padre: 241   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).setAttribute("valign","bottom" );
      ((Element)v.get(241)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(252)).setAttribute("nombre","btnEliminar" );
      ((Element)v.get(252)).setAttribute("ID","botonContenido" );
      ((Element)v.get(252)).setAttribute("ontab","focalizaBtnBuscar();" );
      ((Element)v.get(252)).setAttribute("tipo","html" );
      ((Element)v.get(252)).setAttribute("accion","eliminaProdSeleccionados();" );
      ((Element)v.get(252)).setAttribute("estado","false" );
      ((Element)v.get(252)).setAttribute("cod","1254" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */

      /* Empieza nodo:253 / Elemento padre: 241   */
      v.add(doc.createElement("td"));
      ((Element)v.get(253)).setAttribute("width","100%" );
      ((Element)v.get(241)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(254)).setAttribute("src","b.gif" );
      ((Element)v.get(254)).setAttribute("width","8" );
      ((Element)v.get(254)).setAttribute("height","8" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */
      /* Termina nodo:241   */
      /* Termina nodo:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:255 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(255)).setAttribute("nombre","TipoDespacho" );
      ((Element)v.get(255)).setAttribute("alto","80" );
      ((Element)v.get(255)).setAttribute("ancho","600" );
      ((Element)v.get(255)).setAttribute("colorf","" );
      ((Element)v.get(255)).setAttribute("borde","0" );
      ((Element)v.get(255)).setAttribute("imagenf","" );
      ((Element)v.get(255)).setAttribute("repeat","" );
      ((Element)v.get(255)).setAttribute("padding","" );
      ((Element)v.get(255)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(255)).setAttribute("contravsb","" );
      ((Element)v.get(255)).setAttribute("x","22" );
      ((Element)v.get(255)).setAttribute("y","284" );
      ((Element)v.get(255)).setAttribute("zindex","" );
      ((Element)v.get(6)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("table"));
      ((Element)v.get(256)).setAttribute("width","600" );
      ((Element)v.get(256)).setAttribute("border","0" );
      ((Element)v.get(256)).setAttribute("align","left" );
      ((Element)v.get(256)).setAttribute("cellspacing","0" );
      ((Element)v.get(256)).setAttribute("cellpadding","0" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("td"));
      ((Element)v.get(257)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(259)).setAttribute("nombre","lblTipoDespacho" );
      ((Element)v.get(259)).setAttribute("filas","1" );
      ((Element)v.get(259)).setAttribute("id","datosTitle" );
      ((Element)v.get(259)).setAttribute("cod","1000" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:260 / Elemento padre: 256   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(256)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("td"));
      ((Element)v.get(260)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(262)).setAttribute("nombre","cbTipoDespacho" );
      ((Element)v.get(262)).setAttribute("onshtab","focaliza('formulario.rbOrdenacion', '');" );
      ((Element)v.get(262)).setAttribute("ontab","focalizaBtnBuscar();" );
      ((Element)v.get(262)).setAttribute("size","5" );
      ((Element)v.get(262)).setAttribute("multiple","S" );
      ((Element)v.get(262)).setAttribute("valorinicial","" );
      ((Element)v.get(262)).setAttribute("textoinicial","                " );
      ((Element)v.get(262)).setAttribute("id","datosCampos" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */
      /* Termina nodo:261   */
      /* Termina nodo:260   */
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:264 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(264)).setAttribute("nombre","listado1" );
      ((Element)v.get(264)).setAttribute("ancho","664" );
      ((Element)v.get(264)).setAttribute("alto","317" );
      ((Element)v.get(264)).setAttribute("x","12" );
      ((Element)v.get(264)).setAttribute("y","421" );
      ((Element)v.get(264)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(264)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(265)).setAttribute("precarga","S" );
      ((Element)v.get(265)).setAttribute("conROver","S" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(266)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(266)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(266)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(266)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */

      /* Empieza nodo:267 / Elemento padre: 265   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(267)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(267)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(267)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(267)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(265)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */

      /* Empieza nodo:268 / Elemento padre: 265   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(268)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(268)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(265)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:265   */

      /* Empieza nodo:269 / Elemento padre: 264   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(264)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(270)).setAttribute("borde","1" );
      ((Element)v.get(270)).setAttribute("horizDatos","1" );
      ((Element)v.get(270)).setAttribute("horizCabecera","1" );
      ((Element)v.get(270)).setAttribute("vertical","0" );
      ((Element)v.get(270)).setAttribute("horizTitulo","1" );
      ((Element)v.get(270)).setAttribute("horizBase","1" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */

      /* Empieza nodo:271 / Elemento padre: 269   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(271)).setAttribute("borde","#999999" );
      ((Element)v.get(271)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(271)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(271)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(271)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(271)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(271)).setAttribute("horizBase","#999999" );
      ((Element)v.get(269)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:269   */

      /* Empieza nodo:272 / Elemento padre: 264   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(272)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(272)).setAttribute("alto","22" );
      ((Element)v.get(272)).setAttribute("imgFondo","" );
      ((Element)v.get(272)).setAttribute("cod","0068" );
      ((Element)v.get(272)).setAttribute("ID","datosTitle" );
      ((Element)v.get(264)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */

      /* Empieza nodo:273 / Elemento padre: 264   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(273)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(273)).setAttribute("alto","22" );
      ((Element)v.get(273)).setAttribute("imgFondo","" );
      ((Element)v.get(264)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */

      /* Empieza nodo:274 / Elemento padre: 264   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(274)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(274)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(274)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(274)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(274)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(274)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(264)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(275)).setAttribute("ancho","30" );
      ((Element)v.get(275)).setAttribute("minimizable","S" );
      ((Element)v.get(275)).setAttribute("minimizada","N" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */

      /* Empieza nodo:276 / Elemento padre: 274   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(276)).setAttribute("ancho","10" );
      ((Element)v.get(276)).setAttribute("minimizable","S" );
      ((Element)v.get(276)).setAttribute("minimizada","N" );
      ((Element)v.get(276)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(274)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */

      /* Empieza nodo:277 / Elemento padre: 274   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(277)).setAttribute("ancho","30" );
      ((Element)v.get(277)).setAttribute("minimizable","S" );
      ((Element)v.get(277)).setAttribute("minimizada","N" );
      ((Element)v.get(274)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */

      /* Empieza nodo:278 / Elemento padre: 274   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(278)).setAttribute("ancho","30" );
      ((Element)v.get(278)).setAttribute("minimizable","S" );
      ((Element)v.get(278)).setAttribute("minimizada","N" );
      ((Element)v.get(274)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */

      /* Empieza nodo:279 / Elemento padre: 274   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(279)).setAttribute("ancho","20" );
      ((Element)v.get(279)).setAttribute("minimizable","S" );
      ((Element)v.get(279)).setAttribute("minimizada","N" );
      ((Element)v.get(274)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */

      /* Empieza nodo:280 / Elemento padre: 274   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(280)).setAttribute("ancho","60" );
      ((Element)v.get(280)).setAttribute("minimizable","S" );
      ((Element)v.get(280)).setAttribute("minimizada","N" );
      ((Element)v.get(280)).setAttribute("oculta","S" );
      ((Element)v.get(274)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */

      /* Empieza nodo:281 / Elemento padre: 274   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(281)).setAttribute("ancho","60" );
      ((Element)v.get(281)).setAttribute("minimizable","S" );
      ((Element)v.get(281)).setAttribute("minimizada","N" );
      ((Element)v.get(281)).setAttribute("oculta","S" );
      ((Element)v.get(274)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:274   */

      /* Empieza nodo:282 / Elemento padre: 264   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(282)).setAttribute("alto","20" );
      ((Element)v.get(282)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(282)).setAttribute("imgFondo","" );
      ((Element)v.get(282)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(264)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(283)).setAttribute("colFondo","" );
      ((Element)v.get(283)).setAttribute("ID","EstCab" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(283)).setAttribute("align","center" );
      ((Element)v.get(283)).setAttribute("cod","393" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));

      /* Elemento padre:283 / Elemento actual: 284   */
      v.add(doc.createTextNode("Tipo cliente"));
      ((Element)v.get(283)).appendChild((Text)v.get(284));

      /* Termina nodo Texto:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:285 / Elemento padre: 282   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(285)).setAttribute("colFondo","" );
      ((Element)v.get(285)).setAttribute("ID","EstCab" );
      ((Element)v.get(285)).setAttribute("cod","263" );
      ((Element)v.get(282)).appendChild((Element)v.get(285));

      /* Elemento padre:285 / Elemento actual: 286   */
      v.add(doc.createTextNode("Cód. cliente"));
      ((Element)v.get(285)).appendChild((Text)v.get(286));

      /* Termina nodo Texto:286   */
      /* Termina nodo:285   */

      /* Empieza nodo:287 / Elemento padre: 282   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(287)).setAttribute("colFondo","" );
      ((Element)v.get(287)).setAttribute("ID","EstCab" );
      ((Element)v.get(287)).setAttribute("cod","264" );
      ((Element)v.get(282)).appendChild((Element)v.get(287));

      /* Elemento padre:287 / Elemento actual: 288   */
      v.add(doc.createTextNode("Nombre cliente"));
      ((Element)v.get(287)).appendChild((Text)v.get(288));

      /* Termina nodo Texto:288   */
      /* Termina nodo:287   */

      /* Empieza nodo:289 / Elemento padre: 282   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(289)).setAttribute("colFondo","" );
      ((Element)v.get(289)).setAttribute("ID","EstCab" );
      ((Element)v.get(289)).setAttribute("cod","1000" );
      ((Element)v.get(282)).appendChild((Element)v.get(289));

      /* Elemento padre:289 / Elemento actual: 290   */
      v.add(doc.createTextNode("Tipo despacho"));
      ((Element)v.get(289)).appendChild((Text)v.get(290));

      /* Termina nodo Texto:290   */
      /* Termina nodo:289   */

      /* Empieza nodo:291 / Elemento padre: 282   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(291)).setAttribute("colFondo","" );
      ((Element)v.get(291)).setAttribute("ID","EstCab" );
      ((Element)v.get(291)).setAttribute("cod","873" );
      ((Element)v.get(282)).appendChild((Element)v.get(291));

      /* Elemento padre:291 / Elemento actual: 292   */
      v.add(doc.createTextNode("Fecha entrega"));
      ((Element)v.get(291)).appendChild((Text)v.get(292));

      /* Termina nodo Texto:292   */
      /* Termina nodo:291   */

      /* Empieza nodo:293 / Elemento padre: 282   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(293)).setAttribute("colFondo","" );
      ((Element)v.get(293)).setAttribute("ID","EstCab" );
      ((Element)v.get(293)).setAttribute("align","center" );
      ((Element)v.get(282)).appendChild((Element)v.get(293));

      /* Elemento padre:293 / Elemento actual: 294   */
      v.add(doc.createTextNode("oidTipoDespacho"));
      ((Element)v.get(293)).appendChild((Text)v.get(294));

      /* Termina nodo Texto:294   */
      /* Termina nodo:293   */

      /* Empieza nodo:295 / Elemento padre: 282   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(295)).setAttribute("colFondo","" );
      ((Element)v.get(295)).setAttribute("ID","EstCab" );
      ((Element)v.get(295)).setAttribute("align","center" );
      ((Element)v.get(282)).appendChild((Element)v.get(295));

      /* Elemento padre:295 / Elemento actual: 296   */
      v.add(doc.createTextNode("Fecha Entrega Original"));
      ((Element)v.get(295)).appendChild((Text)v.get(296));

      /* Termina nodo Texto:296   */
      /* Termina nodo:295   */
      /* Termina nodo:282   */

      /* Empieza nodo:297 / Elemento padre: 264   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(297)).setAttribute("alto","22" );
      ((Element)v.get(297)).setAttribute("accion","" );
      ((Element)v.get(297)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(297)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(297)).setAttribute("maxSel","-1" );
      ((Element)v.get(297)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(297)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(297)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(297)).setAttribute("onLoad","" );
      ((Element)v.get(297)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(264)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(298)).setAttribute("tipo","texto" );
      ((Element)v.get(298)).setAttribute("ID","EstDat" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */

      /* Empieza nodo:299 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(299)).setAttribute("tipo","texto" );
      ((Element)v.get(299)).setAttribute("ID","EstDat2" );
      ((Element)v.get(297)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */

      /* Empieza nodo:300 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(300)).setAttribute("tipo","texto" );
      ((Element)v.get(300)).setAttribute("ID","EstDat" );
      ((Element)v.get(297)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */

      /* Empieza nodo:301 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(301)).setAttribute("tipo","texto" );
      ((Element)v.get(301)).setAttribute("ID","EstDat2" );
      ((Element)v.get(297)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */

      /* Empieza nodo:302 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(302)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(302)).setAttribute("nombre","txtFechaEntrega1" );
      ((Element)v.get(302)).setAttribute("onchange","tipoClienteChange(FILAEVENTO);" );
      ((Element)v.get(302)).setAttribute("size","10" );
      ((Element)v.get(302)).setAttribute("max","10" );
      ((Element)v.get(302)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(302)).setAttribute("ID","EstDat" );
      ((Element)v.get(297)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */

      /* Empieza nodo:303 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(303)).setAttribute("tipo","texto" );
      ((Element)v.get(303)).setAttribute("ID","EstDat" );
      ((Element)v.get(297)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */

      /* Empieza nodo:304 / Elemento padre: 297   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(304)).setAttribute("tipo","texto" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(304)).setAttribute("ID","EstDat" );
      ((Element)v.get(297)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:297   */

      /* Empieza nodo:305 / Elemento padre: 264   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(264)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */

      /* Empieza nodo:306 / Elemento padre: 264   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(306)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(306)).setAttribute("ancho","664" );
      ((Element)v.get(306)).setAttribute("sep","$" );
      ((Element)v.get(306)).setAttribute("x","12" );
      ((Element)v.get(306)).setAttribute("class","botonera" );
      ((Element)v.get(306)).setAttribute("y","715" );
      ((Element)v.get(306)).setAttribute("control","|" );
      ((Element)v.get(306)).setAttribute("conector","" );
      ((Element)v.get(306)).setAttribute("rowset","" );
      ((Element)v.get(306)).setAttribute("cargainicial","N" );
      ((Element)v.get(264)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(307)).setAttribute("nombre","ret1" );
      ((Element)v.get(307)).setAttribute("x","37" );
      ((Element)v.get(307)).setAttribute("y","719" );
      ((Element)v.get(307)).setAttribute("ID","botonContenido" );
      ((Element)v.get(307)).setAttribute("img","retroceder_on" );
      ((Element)v.get(307)).setAttribute("tipo","0" );
      ((Element)v.get(307)).setAttribute("estado","false" );
      ((Element)v.get(307)).setAttribute("alt","" );
      ((Element)v.get(307)).setAttribute("codigo","" );
      ((Element)v.get(307)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */

      /* Empieza nodo:308 / Elemento padre: 306   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(308)).setAttribute("nombre","ava1" );
      ((Element)v.get(308)).setAttribute("x","52" );
      ((Element)v.get(308)).setAttribute("y","719" );
      ((Element)v.get(308)).setAttribute("ID","botonContenido" );
      ((Element)v.get(308)).setAttribute("img","avanzar_on" );
      ((Element)v.get(308)).setAttribute("tipo","0" );
      ((Element)v.get(308)).setAttribute("estado","false" );
      ((Element)v.get(308)).setAttribute("alt","" );
      ((Element)v.get(308)).setAttribute("codigo","" );
      ((Element)v.get(308)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(306)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:306   */
      /* Termina nodo:264   */

      /* Empieza nodo:309 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(309)).setAttribute("nombre","primera1" );
      ((Element)v.get(309)).setAttribute("x","20" );
      ((Element)v.get(309)).setAttribute("y","719" );
      ((Element)v.get(309)).setAttribute("ID","botonContenido" );
      ((Element)v.get(309)).setAttribute("img","primera_on" );
      ((Element)v.get(309)).setAttribute("tipo","1" );
      ((Element)v.get(309)).setAttribute("estado","false" );
      ((Element)v.get(309)).setAttribute("alt","" );
      ((Element)v.get(309)).setAttribute("codigo","" );
      ((Element)v.get(309)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */

      /* Empieza nodo:310 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(310)).setAttribute("nombre","separa1" );
      ((Element)v.get(310)).setAttribute("x","59" );
      ((Element)v.get(310)).setAttribute("y","715" );
      ((Element)v.get(310)).setAttribute("ID","botonContenido" );
      ((Element)v.get(310)).setAttribute("img","separa_base" );
      ((Element)v.get(310)).setAttribute("tipo","0" );
      ((Element)v.get(310)).setAttribute("estado","false" );
      ((Element)v.get(310)).setAttribute("alt","" );
      ((Element)v.get(310)).setAttribute("codigo","" );
      ((Element)v.get(310)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */

      /* Empieza nodo:311 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(311)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(311)).setAttribute("x","80" );
      ((Element)v.get(311)).setAttribute("y","716" );
      ((Element)v.get(311)).setAttribute("accion","accionAceptar();" );
      ((Element)v.get(311)).setAttribute("ontab","focaliza('formulario.cbMarca', '');" );
      ((Element)v.get(311)).setAttribute("onshtab","onShTabBtnAceptar('listado1');" );
      ((Element)v.get(311)).setAttribute("ID","botonContenido" );
      ((Element)v.get(311)).setAttribute("tipo","html" );
      ((Element)v.get(311)).setAttribute("estado","false" );
      ((Element)v.get(311)).setAttribute("cod","12" );
      ((Element)v.get(6)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */

      /* Empieza nodo:312 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(312)).setAttribute("nombre","listado3" );
      ((Element)v.get(312)).setAttribute("ancho","664" );
      ((Element)v.get(312)).setAttribute("alto","317" );
      ((Element)v.get(312)).setAttribute("x","12" );
      ((Element)v.get(312)).setAttribute("y","421" );
      ((Element)v.get(312)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(312)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(313)).setAttribute("precarga","S" );
      ((Element)v.get(313)).setAttribute("conROver","S" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("BTNSELECCION"));
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(314)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(314)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(314)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(314)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */

      /* Empieza nodo:315 / Elemento padre: 313   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(315)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(315)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(315)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(315)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(313)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */

      /* Empieza nodo:316 / Elemento padre: 313   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(316)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(316)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(313)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:313   */

      /* Empieza nodo:317 / Elemento padre: 312   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(312)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(318)).setAttribute("borde","1" );
      ((Element)v.get(318)).setAttribute("horizDatos","1" );
      ((Element)v.get(318)).setAttribute("horizCabecera","1" );
      ((Element)v.get(318)).setAttribute("vertical","0" );
      ((Element)v.get(318)).setAttribute("horizTitulo","1" );
      ((Element)v.get(318)).setAttribute("horizBase","1" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */

      /* Empieza nodo:319 / Elemento padre: 317   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(319)).setAttribute("borde","#999999" );
      ((Element)v.get(319)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(319)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(319)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(319)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(319)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(319)).setAttribute("horizBase","#999999" );
      ((Element)v.get(317)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */
      /* Termina nodo:317   */

      /* Empieza nodo:320 / Elemento padre: 312   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(320)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(320)).setAttribute("alto","22" );
      ((Element)v.get(320)).setAttribute("imgFondo","" );
      ((Element)v.get(320)).setAttribute("cod","00165" );
      ((Element)v.get(320)).setAttribute("ID","datosTitle" );
      ((Element)v.get(312)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */

      /* Empieza nodo:321 / Elemento padre: 312   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(321)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(321)).setAttribute("alto","22" );
      ((Element)v.get(321)).setAttribute("imgFondo","" );
      ((Element)v.get(312)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */

      /* Empieza nodo:322 / Elemento padre: 312   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(322)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(322)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(322)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(322)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(322)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(322)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(312)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(323)).setAttribute("ancho","30" );
      ((Element)v.get(323)).setAttribute("minimizable","S" );
      ((Element)v.get(323)).setAttribute("minimizada","N" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */

      /* Empieza nodo:324 / Elemento padre: 322   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(324)).setAttribute("ancho","10" );
      ((Element)v.get(324)).setAttribute("minimizable","S" );
      ((Element)v.get(324)).setAttribute("minimizada","N" );
      ((Element)v.get(324)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(322)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */

      /* Empieza nodo:325 / Elemento padre: 322   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(325)).setAttribute("ancho","30" );
      ((Element)v.get(325)).setAttribute("minimizable","S" );
      ((Element)v.get(325)).setAttribute("minimizada","N" );
      ((Element)v.get(322)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */

      /* Empieza nodo:326 / Elemento padre: 322   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(326)).setAttribute("ancho","30" );
      ((Element)v.get(326)).setAttribute("minimizable","S" );
      ((Element)v.get(326)).setAttribute("minimizada","N" );
      ((Element)v.get(322)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */

      /* Empieza nodo:327 / Elemento padre: 322   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(327)).setAttribute("ancho","20" );
      ((Element)v.get(327)).setAttribute("minimizable","S" );
      ((Element)v.get(327)).setAttribute("minimizada","N" );
      ((Element)v.get(322)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */

      /* Empieza nodo:328 / Elemento padre: 322   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(328)).setAttribute("ancho","60" );
      ((Element)v.get(328)).setAttribute("minimizable","S" );
      ((Element)v.get(328)).setAttribute("minimizada","N" );
      ((Element)v.get(328)).setAttribute("oculta","S" );
      ((Element)v.get(322)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */

      /* Empieza nodo:329 / Elemento padre: 322   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(329)).setAttribute("ancho","60" );
      ((Element)v.get(329)).setAttribute("minimizable","S" );
      ((Element)v.get(329)).setAttribute("minimizada","N" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(329)).setAttribute("oculta","S" );
      ((Element)v.get(322)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:322   */

      /* Empieza nodo:330 / Elemento padre: 312   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(330)).setAttribute("alto","20" );
      ((Element)v.get(330)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(330)).setAttribute("imgFondo","" );
      ((Element)v.get(330)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(312)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(331)).setAttribute("colFondo","" );
      ((Element)v.get(331)).setAttribute("ID","EstCab" );
      ((Element)v.get(331)).setAttribute("align","center" );
      ((Element)v.get(331)).setAttribute("cod","1000" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));

      /* Elemento padre:331 / Elemento actual: 332   */
      v.add(doc.createTextNode("Tipo despacho"));
      ((Element)v.get(331)).appendChild((Text)v.get(332));

      /* Termina nodo Texto:332   */
      /* Termina nodo:331   */

      /* Empieza nodo:333 / Elemento padre: 330   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(333)).setAttribute("colFondo","" );
      ((Element)v.get(333)).setAttribute("ID","EstCab" );
      ((Element)v.get(333)).setAttribute("cod","263" );
      ((Element)v.get(330)).appendChild((Element)v.get(333));

      /* Elemento padre:333 / Elemento actual: 334   */
      v.add(doc.createTextNode("Cód. cliente"));
      ((Element)v.get(333)).appendChild((Text)v.get(334));

      /* Termina nodo Texto:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:335 / Elemento padre: 330   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(335)).setAttribute("colFondo","" );
      ((Element)v.get(335)).setAttribute("ID","EstCab" );
      ((Element)v.get(335)).setAttribute("cod","264" );
      ((Element)v.get(330)).appendChild((Element)v.get(335));

      /* Elemento padre:335 / Elemento actual: 336   */
      v.add(doc.createTextNode("Nombre cliente"));
      ((Element)v.get(335)).appendChild((Text)v.get(336));

      /* Termina nodo Texto:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 330   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(337)).setAttribute("colFondo","" );
      ((Element)v.get(337)).setAttribute("ID","EstCab" );
      ((Element)v.get(337)).setAttribute("cod","393" );
      ((Element)v.get(330)).appendChild((Element)v.get(337));

      /* Elemento padre:337 / Elemento actual: 338   */
      v.add(doc.createTextNode("Tipo cliente"));
      ((Element)v.get(337)).appendChild((Text)v.get(338));

      /* Termina nodo Texto:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:339 / Elemento padre: 330   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(339)).setAttribute("colFondo","" );
      ((Element)v.get(339)).setAttribute("ID","EstCab" );
      ((Element)v.get(339)).setAttribute("cod","873" );
      ((Element)v.get(330)).appendChild((Element)v.get(339));

      /* Elemento padre:339 / Elemento actual: 340   */
      v.add(doc.createTextNode("Fecha entrega"));
      ((Element)v.get(339)).appendChild((Text)v.get(340));

      /* Termina nodo Texto:340   */
      /* Termina nodo:339   */

      /* Empieza nodo:341 / Elemento padre: 330   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(341)).setAttribute("colFondo","" );
      ((Element)v.get(341)).setAttribute("ID","EstCab" );
      ((Element)v.get(341)).setAttribute("align","center" );
      ((Element)v.get(330)).appendChild((Element)v.get(341));

      /* Elemento padre:341 / Elemento actual: 342   */
      v.add(doc.createTextNode("oidTipoCliente"));
      ((Element)v.get(341)).appendChild((Text)v.get(342));

      /* Termina nodo Texto:342   */
      /* Termina nodo:341   */

      /* Empieza nodo:343 / Elemento padre: 330   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(343)).setAttribute("colFondo","" );
      ((Element)v.get(343)).setAttribute("ID","EstCab" );
      ((Element)v.get(343)).setAttribute("align","center" );
      ((Element)v.get(330)).appendChild((Element)v.get(343));

      /* Elemento padre:343 / Elemento actual: 344   */
      v.add(doc.createTextNode("Fecha Entrega Original"));
      ((Element)v.get(343)).appendChild((Text)v.get(344));

      /* Termina nodo Texto:344   */
      /* Termina nodo:343   */
      /* Termina nodo:330   */

      /* Empieza nodo:345 / Elemento padre: 312   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(345)).setAttribute("alto","22" );
      ((Element)v.get(345)).setAttribute("accion","" );
      ((Element)v.get(345)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(345)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(345)).setAttribute("maxSel","-1" );
      ((Element)v.get(345)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(345)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(345)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(345)).setAttribute("onLoad","" );
      ((Element)v.get(345)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(312)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(346)).setAttribute("tipo","texto" );
      ((Element)v.get(346)).setAttribute("ID","EstDat" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */

      /* Empieza nodo:347 / Elemento padre: 345   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(347)).setAttribute("tipo","texto" );
      ((Element)v.get(347)).setAttribute("ID","EstDat2" );
      ((Element)v.get(345)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */

      /* Empieza nodo:348 / Elemento padre: 345   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(348)).setAttribute("tipo","texto" );
      ((Element)v.get(348)).setAttribute("ID","EstDat" );
      ((Element)v.get(345)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */

      /* Empieza nodo:349 / Elemento padre: 345   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(349)).setAttribute("tipo","texto" );
      ((Element)v.get(349)).setAttribute("ID","EstDat2" );
      ((Element)v.get(345)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */

      /* Empieza nodo:350 / Elemento padre: 345   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(350)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(350)).setAttribute("nombre","txtFechaEntrega3" );
      ((Element)v.get(350)).setAttribute("onchange","tipoDespachoChange(FILAEVENTO);" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(350)).setAttribute("size","10" );
      ((Element)v.get(350)).setAttribute("max","10" );
      ((Element)v.get(350)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(350)).setAttribute("ID","EstDat" );
      ((Element)v.get(345)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */

      /* Empieza nodo:351 / Elemento padre: 345   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(351)).setAttribute("tipo","texto" );
      ((Element)v.get(351)).setAttribute("ID","EstDat" );
      ((Element)v.get(345)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */

      /* Empieza nodo:352 / Elemento padre: 345   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(352)).setAttribute("tipo","texto" );
      ((Element)v.get(352)).setAttribute("ID","EstDat" );
      ((Element)v.get(345)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */
      /* Termina nodo:345   */

      /* Empieza nodo:353 / Elemento padre: 312   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(312)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */

      /* Empieza nodo:354 / Elemento padre: 312   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(354)).setAttribute("nombre","mipgndo3" );
      ((Element)v.get(354)).setAttribute("ancho","664" );
      ((Element)v.get(354)).setAttribute("sep","$" );
      ((Element)v.get(354)).setAttribute("x","12" );
      ((Element)v.get(354)).setAttribute("class","botonera" );
      ((Element)v.get(354)).setAttribute("y","715" );
      ((Element)v.get(354)).setAttribute("control","|" );
      ((Element)v.get(354)).setAttribute("conector","" );
      ((Element)v.get(354)).setAttribute("rowset","" );
      ((Element)v.get(354)).setAttribute("cargainicial","N" );
      ((Element)v.get(312)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(355)).setAttribute("nombre","ret3" );
      ((Element)v.get(355)).setAttribute("x","37" );
      ((Element)v.get(355)).setAttribute("y","719" );
      ((Element)v.get(355)).setAttribute("ID","botonContenido" );
      ((Element)v.get(355)).setAttribute("img","retroceder_on" );
      ((Element)v.get(355)).setAttribute("tipo","0" );
      ((Element)v.get(355)).setAttribute("estado","false" );
      ((Element)v.get(355)).setAttribute("alt","" );
      ((Element)v.get(355)).setAttribute("codigo","" );
      ((Element)v.get(355)).setAttribute("accion","mipgndo3.retroceder();" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */

      /* Empieza nodo:356 / Elemento padre: 354   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(356)).setAttribute("nombre","ava3" );
      ((Element)v.get(356)).setAttribute("x","52" );
      ((Element)v.get(356)).setAttribute("y","719" );
      ((Element)v.get(356)).setAttribute("ID","botonContenido" );
      ((Element)v.get(356)).setAttribute("img","avanzar_on" );
      ((Element)v.get(356)).setAttribute("tipo","0" );
      ((Element)v.get(356)).setAttribute("estado","false" );
      ((Element)v.get(356)).setAttribute("alt","" );
      ((Element)v.get(356)).setAttribute("codigo","" );
      ((Element)v.get(356)).setAttribute("accion","mipgndo3.avanzar();" );
      ((Element)v.get(354)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */
      /* Termina nodo:354   */
      /* Termina nodo:312   */

      /* Empieza nodo:357 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(357)).setAttribute("nombre","primera3" );
      ((Element)v.get(357)).setAttribute("x","20" );
      ((Element)v.get(357)).setAttribute("y","719" );
      ((Element)v.get(357)).setAttribute("ID","botonContenido" );
      ((Element)v.get(357)).setAttribute("img","primera_on" );
      ((Element)v.get(357)).setAttribute("tipo","1" );
      ((Element)v.get(357)).setAttribute("estado","false" );
      ((Element)v.get(357)).setAttribute("alt","" );
      ((Element)v.get(357)).setAttribute("codigo","" );
      ((Element)v.get(357)).setAttribute("accion","mipgndo3.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */

      /* Empieza nodo:358 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(358)).setAttribute("nombre","separa3" );
      ((Element)v.get(358)).setAttribute("x","59" );
      ((Element)v.get(358)).setAttribute("y","715" );
      ((Element)v.get(358)).setAttribute("ID","botonContenido" );
      ((Element)v.get(358)).setAttribute("img","separa_base" );
      ((Element)v.get(358)).setAttribute("tipo","0" );
      ((Element)v.get(358)).setAttribute("estado","false" );
      ((Element)v.get(358)).setAttribute("alt","" );
      ((Element)v.get(358)).setAttribute("codigo","" );
      ((Element)v.get(358)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */

      /* Empieza nodo:359 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(359)).setAttribute("nombre","btnAceptar2" );
      ((Element)v.get(359)).setAttribute("x","80" );
      ((Element)v.get(359)).setAttribute("y","716" );
      ((Element)v.get(359)).setAttribute("accion","accionAceptar();" );
      ((Element)v.get(359)).setAttribute("ontab","focaliza('formulario.cbMarca', '');" );
      ((Element)v.get(359)).setAttribute("onshtab","onShTabBtnAceptar('listado3');" );
      ((Element)v.get(359)).setAttribute("ID","botonContenido" );
      ((Element)v.get(359)).setAttribute("tipo","html" );
      ((Element)v.get(359)).setAttribute("estado","false" );
      ((Element)v.get(359)).setAttribute("cod","12" );
      ((Element)v.get(6)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */

      /* Empieza nodo:360 / Elemento padre: 6   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(360)).setAttribute("nombre","listado4" );
      ((Element)v.get(360)).setAttribute("ancho","664" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(360)).setAttribute("alto","317" );
      ((Element)v.get(360)).setAttribute("x","12" );
      ((Element)v.get(360)).setAttribute("y","421" );
      ((Element)v.get(360)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(360)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(6)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(361)).setAttribute("precarga","S" );
      ((Element)v.get(361)).setAttribute("conROver","S" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(362)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(362)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(362)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(362)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */

      /* Empieza nodo:363 / Elemento padre: 361   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(363)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(363)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(363)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(363)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(361)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */

      /* Empieza nodo:364 / Elemento padre: 361   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(364)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(364)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(361)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */
      /* Termina nodo:361   */

      /* Empieza nodo:365 / Elemento padre: 360   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(360)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(366)).setAttribute("borde","1" );
      ((Element)v.get(366)).setAttribute("horizDatos","1" );
      ((Element)v.get(366)).setAttribute("horizCabecera","1" );
      ((Element)v.get(366)).setAttribute("vertical","0" );
      ((Element)v.get(366)).setAttribute("horizTitulo","1" );
      ((Element)v.get(366)).setAttribute("horizBase","1" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */

      /* Empieza nodo:367 / Elemento padre: 365   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(367)).setAttribute("borde","#999999" );
      ((Element)v.get(367)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(367)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(367)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(367)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(367)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(367)).setAttribute("horizBase","#999999" );
      ((Element)v.get(365)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */
      /* Termina nodo:365   */

      /* Empieza nodo:368 / Elemento padre: 360   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(368)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(368)).setAttribute("alto","22" );
      ((Element)v.get(368)).setAttribute("imgFondo","" );
      ((Element)v.get(368)).setAttribute("cod","0094" );
      ((Element)v.get(368)).setAttribute("ID","datosTitle" );
      ((Element)v.get(360)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */

      /* Empieza nodo:369 / Elemento padre: 360   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(369)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(369)).setAttribute("alto","22" );
      ((Element)v.get(369)).setAttribute("imgFondo","" );
      ((Element)v.get(360)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */

      /* Empieza nodo:370 / Elemento padre: 360   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(370)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(370)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(370)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(370)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(370)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(370)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(360)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(371)).setAttribute("ancho","100" );
      ((Element)v.get(371)).setAttribute("minimizable","S" );
      ((Element)v.get(371)).setAttribute("minimizada","N" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */

      /* Empieza nodo:372 / Elemento padre: 370   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(372)).setAttribute("ancho","120" );
      ((Element)v.get(372)).setAttribute("minimizable","S" );
      ((Element)v.get(372)).setAttribute("minimizada","N" );
      ((Element)v.get(372)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(370)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */

      /* Empieza nodo:373 / Elemento padre: 370   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(373)).setAttribute("ancho","100" );
      ((Element)v.get(373)).setAttribute("minimizable","S" );
      ((Element)v.get(373)).setAttribute("minimizada","N" );
      ((Element)v.get(370)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */

      /* Empieza nodo:374 / Elemento padre: 370   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(374)).setAttribute("ancho","120" );
      ((Element)v.get(374)).setAttribute("minimizable","S" );
      ((Element)v.get(374)).setAttribute("minimizada","N" );
      ((Element)v.get(370)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */

      /* Empieza nodo:375 / Elemento padre: 370   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(375)).setAttribute("ancho","100" );
      ((Element)v.get(375)).setAttribute("minimizable","S" );
      ((Element)v.get(375)).setAttribute("minimizada","N" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(370)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */

      /* Empieza nodo:376 / Elemento padre: 370   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(376)).setAttribute("ancho","100" );
      ((Element)v.get(376)).setAttribute("minimizable","S" );
      ((Element)v.get(376)).setAttribute("minimizada","N" );
      ((Element)v.get(370)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */

      /* Empieza nodo:377 / Elemento padre: 370   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(377)).setAttribute("ancho","100" );
      ((Element)v.get(377)).setAttribute("minimizable","S" );
      ((Element)v.get(377)).setAttribute("minimizada","N" );
      ((Element)v.get(377)).setAttribute("orden","alfanumerico" );
      ((Element)v.get(370)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */

      /* Empieza nodo:378 / Elemento padre: 370   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(378)).setAttribute("ancho","120" );
      ((Element)v.get(378)).setAttribute("minimizable","S" );
      ((Element)v.get(378)).setAttribute("minimizada","N" );
      ((Element)v.get(370)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */

      /* Empieza nodo:379 / Elemento padre: 370   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(379)).setAttribute("ancho","120" );
      ((Element)v.get(379)).setAttribute("minimizable","S" );
      ((Element)v.get(379)).setAttribute("minimizada","N" );
      ((Element)v.get(370)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */

      /* Empieza nodo:380 / Elemento padre: 370   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(380)).setAttribute("ancho","100" );
      ((Element)v.get(380)).setAttribute("minimizable","S" );
      ((Element)v.get(380)).setAttribute("minimizada","N" );
      ((Element)v.get(370)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */

      /* Empieza nodo:381 / Elemento padre: 370   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(381)).setAttribute("ancho","100" );
      ((Element)v.get(381)).setAttribute("minimizable","S" );
      ((Element)v.get(381)).setAttribute("minimizada","N" );
      ((Element)v.get(370)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */

      /* Empieza nodo:382 / Elemento padre: 370   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(382)).setAttribute("ancho","100" );
      ((Element)v.get(382)).setAttribute("minimizable","S" );
      ((Element)v.get(382)).setAttribute("minimizada","N" );
      ((Element)v.get(370)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */
      /* Termina nodo:370   */

      /* Empieza nodo:383 / Elemento padre: 360   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(383)).setAttribute("alto","20" );
      ((Element)v.get(383)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(383)).setAttribute("imgFondo","" );
      ((Element)v.get(383)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(360)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(384)).setAttribute("colFondo","" );
      ((Element)v.get(384)).setAttribute("ID","EstCab" );
      ((Element)v.get(384)).setAttribute("align","center" );
      ((Element)v.get(384)).setAttribute("cod","337" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));

      /* Elemento padre:384 / Elemento actual: 385   */
      v.add(doc.createTextNode("Cód. producto"));
      ((Element)v.get(384)).appendChild((Text)v.get(385));

      /* Termina nodo Texto:385   */
      /* Termina nodo:384   */

      /* Empieza nodo:386 / Elemento padre: 383   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(386)).setAttribute("colFondo","" );
      ((Element)v.get(386)).setAttribute("ID","EstCab" );
      ((Element)v.get(386)).setAttribute("cod","338" );
      ((Element)v.get(383)).appendChild((Element)v.get(386));

      /* Elemento padre:386 / Elemento actual: 387   */
      v.add(doc.createTextNode("Descripción producto"));
      ((Element)v.get(386)).appendChild((Text)v.get(387));

      /* Termina nodo Texto:387   */
      /* Termina nodo:386   */

      /* Empieza nodo:388 / Elemento padre: 383   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(388)).setAttribute("colFondo","" );
      ((Element)v.get(388)).setAttribute("ID","EstCab" );
      ((Element)v.get(388)).setAttribute("cod","1015" );
      ((Element)v.get(383)).appendChild((Element)v.get(388));

      /* Elemento padre:388 / Elemento actual: 389   */
      v.add(doc.createTextNode("Unidades totales"));
      ((Element)v.get(388)).appendChild((Text)v.get(389));

      /* Termina nodo Texto:389   */
      /* Termina nodo:388   */

      /* Empieza nodo:390 / Elemento padre: 383   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(390)).setAttribute("colFondo","" );
      ((Element)v.get(390)).setAttribute("ID","EstCab" );
      ((Element)v.get(390)).setAttribute("cod","1011" );
      ((Element)v.get(383)).appendChild((Element)v.get(390));

      /* Elemento padre:390 / Elemento actual: 391   */
      v.add(doc.createTextNode("Unidades disponibles"));
      ((Element)v.get(390)).appendChild((Text)v.get(391));

      /* Termina nodo Texto:391   */
      /* Termina nodo:390   */

      /* Empieza nodo:392 / Elemento padre: 383   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(392)).setAttribute("colFondo","" );
      ((Element)v.get(392)).setAttribute("ID","EstCab" );
      ((Element)v.get(392)).setAttribute("cod","263" );
      ((Element)v.get(383)).appendChild((Element)v.get(392));

      /* Elemento padre:392 / Elemento actual: 393   */
      v.add(doc.createTextNode("Cód. cliente"));
      ((Element)v.get(392)).appendChild((Text)v.get(393));

      /* Termina nodo Texto:393   */
      /* Termina nodo:392   */

      /* Empieza nodo:394 / Elemento padre: 383   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(394)).setAttribute("colFondo","" );
      ((Element)v.get(394)).setAttribute("ID","EstCab" );
      ((Element)v.get(394)).setAttribute("cod","264" );
      ((Element)v.get(383)).appendChild((Element)v.get(394));

      /* Elemento padre:394 / Elemento actual: 395   */
      v.add(doc.createTextNode("Nombre cliente"));
      ((Element)v.get(394)).appendChild((Text)v.get(395));

      /* Termina nodo Texto:395   */
      /* Termina nodo:394   */

      /* Empieza nodo:396 / Elemento padre: 383   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(396)).setAttribute("colFondo","" );
      ((Element)v.get(396)).setAttribute("ID","EstCab" );
      ((Element)v.get(396)).setAttribute("cod","393" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(383)).appendChild((Element)v.get(396));

      /* Elemento padre:396 / Elemento actual: 397   */
      v.add(doc.createTextNode("Tipo cliente"));
      ((Element)v.get(396)).appendChild((Text)v.get(397));

      /* Termina nodo Texto:397   */
      /* Termina nodo:396   */

      /* Empieza nodo:398 / Elemento padre: 383   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(398)).setAttribute("colFondo","" );
      ((Element)v.get(398)).setAttribute("ID","EstCab" );
      ((Element)v.get(398)).setAttribute("cod","838" );
      ((Element)v.get(383)).appendChild((Element)v.get(398));

      /* Elemento padre:398 / Elemento actual: 399   */
      v.add(doc.createTextNode("Criterio asignación"));
      ((Element)v.get(398)).appendChild((Text)v.get(399));

      /* Termina nodo Texto:399   */
      /* Termina nodo:398   */

      /* Empieza nodo:400 / Elemento padre: 383   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(400)).setAttribute("colFondo","" );
      ((Element)v.get(400)).setAttribute("ID","EstCab" );
      ((Element)v.get(400)).setAttribute("cod","873" );
      ((Element)v.get(383)).appendChild((Element)v.get(400));

      /* Elemento padre:400 / Elemento actual: 401   */
      v.add(doc.createTextNode("Fecha entrega"));
      ((Element)v.get(400)).appendChild((Text)v.get(401));

      /* Termina nodo Texto:401   */
      /* Termina nodo:400   */

      /* Empieza nodo:402 / Elemento padre: 383   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(402)).setAttribute("colFondo","" );
      ((Element)v.get(402)).setAttribute("ID","EstCab" );
      ((Element)v.get(402)).setAttribute("cod","495" );
      ((Element)v.get(383)).appendChild((Element)v.get(402));

      /* Elemento padre:402 / Elemento actual: 403   */
      v.add(doc.createTextNode("Nº unidades"));
      ((Element)v.get(402)).appendChild((Text)v.get(403));

      /* Termina nodo Texto:403   */
      /* Termina nodo:402   */

      /* Empieza nodo:404 / Elemento padre: 383   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(404)).setAttribute("colFondo","" );
      ((Element)v.get(404)).setAttribute("ID","EstCab" );
      ((Element)v.get(404)).setAttribute("cod","863" );
      ((Element)v.get(383)).appendChild((Element)v.get(404));

      /* Elemento padre:404 / Elemento actual: 405   */
      v.add(doc.createTextNode("Estado envío"));
      ((Element)v.get(404)).appendChild((Text)v.get(405));

      /* Termina nodo Texto:405   */
      /* Termina nodo:404   */

      /* Empieza nodo:406 / Elemento padre: 383   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(406)).setAttribute("colFondo","" );
      ((Element)v.get(406)).setAttribute("ID","EstCab" );
      ((Element)v.get(406)).setAttribute("cod","862" );
      ((Element)v.get(383)).appendChild((Element)v.get(406));

      /* Elemento padre:406 / Elemento actual: 407   */
      v.add(doc.createTextNode("Estado autorización"));
      ((Element)v.get(406)).appendChild((Text)v.get(407));

      /* Termina nodo Texto:407   */
      /* Termina nodo:406   */
      /* Termina nodo:383   */

      /* Empieza nodo:408 / Elemento padre: 360   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(408)).setAttribute("alto","22" );
      ((Element)v.get(408)).setAttribute("accion","" );
      ((Element)v.get(408)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(408)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(408)).setAttribute("maxSel","-1" );
      ((Element)v.get(408)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(408)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(408)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(408)).setAttribute("onLoad","" );
      ((Element)v.get(408)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(360)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(409)).setAttribute("tipo","texto" );
      ((Element)v.get(409)).setAttribute("ID","EstDat" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));
      /* Termina nodo:409   */

      /* Empieza nodo:410 / Elemento padre: 408   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(410)).setAttribute("tipo","texto" );
      ((Element)v.get(410)).setAttribute("ID","EstDat2" );
      ((Element)v.get(408)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */

      /* Empieza nodo:411 / Elemento padre: 408   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(411)).setAttribute("tipo","texto" );
      ((Element)v.get(411)).setAttribute("ID","EstDat" );
      ((Element)v.get(408)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */

      /* Empieza nodo:412 / Elemento padre: 408   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(412)).setAttribute("tipo","texto" );
      ((Element)v.get(412)).setAttribute("ID","EstDat2" );
      ((Element)v.get(408)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */

      /* Empieza nodo:413 / Elemento padre: 408   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(413)).setAttribute("tipo","texto" );
      ((Element)v.get(413)).setAttribute("ID","EstDat" );
      ((Element)v.get(408)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */

      /* Empieza nodo:414 / Elemento padre: 408   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(414)).setAttribute("tipo","texto" );
      ((Element)v.get(414)).setAttribute("ID","EstDat2" );
      ((Element)v.get(408)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */

      /* Empieza nodo:415 / Elemento padre: 408   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(415)).setAttribute("tipo","texto" );
      ((Element)v.get(415)).setAttribute("ID","EstDat" );
      ((Element)v.get(408)).appendChild((Element)v.get(415));
      /* Termina nodo:415   */

      /* Empieza nodo:416 / Elemento padre: 408   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(416)).setAttribute("tipo","texto" );
      ((Element)v.get(416)).setAttribute("ID","EstDat2" );
      ((Element)v.get(408)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */

      /* Empieza nodo:417 / Elemento padre: 408   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(417)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(417)).setAttribute("nombre","txtFechaEntrega4" );
      ((Element)v.get(417)).setAttribute("onchange","productoChange(FILAEVENTO);" );
      ((Element)v.get(417)).setAttribute("size","10" );
      ((Element)v.get(417)).setAttribute("max","10" );
      ((Element)v.get(417)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(417)).setAttribute("ID","EstDat" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(408)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */

      /* Empieza nodo:418 / Elemento padre: 408   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(418)).setAttribute("tipo","cajatexto" );
      ((Element)v.get(418)).setAttribute("nombre","txtNumUnidades4" );
      ((Element)v.get(418)).setAttribute("onchange","productoChange(FILAEVENTO);" );
      ((Element)v.get(418)).setAttribute("size","10" );
      ((Element)v.get(418)).setAttribute("max","10" );
      ((Element)v.get(418)).setAttribute("IDOBJ","EstCajaDatForm" );
      ((Element)v.get(418)).setAttribute("ID","EstDat2" );
      ((Element)v.get(408)).appendChild((Element)v.get(418));
      /* Termina nodo:418   */

      /* Empieza nodo:419 / Elemento padre: 408   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(419)).setAttribute("tipo","texto" );
      ((Element)v.get(419)).setAttribute("ID","EstDat" );
      ((Element)v.get(408)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */

      /* Empieza nodo:420 / Elemento padre: 408   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(420)).setAttribute("tipo","combo" );
      ((Element)v.get(420)).setAttribute("nombre","cbEstadoAutorizacion4" );
      ((Element)v.get(420)).setAttribute("onchange","productoChange(FILAEVENTO);" );
      ((Element)v.get(420)).setAttribute("IDOBJ","EstDatForm" );
      ((Element)v.get(420)).setAttribute("ID","EstDat2" );
      ((Element)v.get(408)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(420)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(421)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(423)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(423)).setAttribute("TIPO","STRING" );
      ((Element)v.get(423)).setAttribute("VALOR","3" );
      ((Element)v.get(422)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */

      /* Empieza nodo:424 / Elemento padre: 422   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(424)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(424)).setAttribute("TIPO","STRING" );
      ((Element)v.get(424)).setAttribute("VALOR","Autorizado" );
      ((Element)v.get(422)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */
      /* Termina nodo:422   */

      /* Empieza nodo:425 / Elemento padre: 421   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(421)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(426)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(426)).setAttribute("TIPO","STRING" );
      ((Element)v.get(426)).setAttribute("VALOR","5" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));
      /* Termina nodo:426   */

      /* Empieza nodo:427 / Elemento padre: 425   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(427)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(427)).setAttribute("TIPO","STRING" );
      ((Element)v.get(427)).setAttribute("VALOR","Enviado para autorización" );
      ((Element)v.get(425)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */
      /* Termina nodo:425   */

      /* Empieza nodo:428 / Elemento padre: 421   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(421)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(429)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(429)).setAttribute("TIPO","STRING" );
      ((Element)v.get(429)).setAttribute("VALOR","2" );
      ((Element)v.get(428)).appendChild((Element)v.get(429));
      /* Termina nodo:429   */

      /* Empieza nodo:430 / Elemento padre: 428   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(430)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(430)).setAttribute("TIPO","STRING" );
      ((Element)v.get(430)).setAttribute("VALOR","Pendiente de envío" );
      ((Element)v.get(428)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */
      /* Termina nodo:428   */

      /* Empieza nodo:431 / Elemento padre: 421   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(421)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(432)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(432)).setAttribute("TIPO","STRING" );
      ((Element)v.get(432)).setAttribute("VALOR","4" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));
      /* Termina nodo:432   */

      /* Empieza nodo:433 / Elemento padre: 431   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(433)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(433)).setAttribute("TIPO","STRING" );
      ((Element)v.get(433)).setAttribute("VALOR","No autorizado" );
      ((Element)v.get(431)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */
      /* Termina nodo:431   */

      /* Empieza nodo:434 / Elemento padre: 421   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(421)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(435)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(435)).setAttribute("TIPO","STRING" );
      ((Element)v.get(435)).setAttribute("VALOR","1" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */

      /* Empieza nodo:436 / Elemento padre: 434   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(436)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(436)).setAttribute("TIPO","STRING" );
      ((Element)v.get(436)).setAttribute("VALOR","Sin autorización" );
      ((Element)v.get(434)).appendChild((Element)v.get(436));
      /* Termina nodo:436   */
      /* Termina nodo:434   */
      /* Termina nodo:421   */
      /* Termina nodo:420   */
      /* Termina nodo:408   */

      /* Empieza nodo:437 / Elemento padre: 360   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(360)).appendChild((Element)v.get(437));
      /* Termina nodo:437   */

      /* Empieza nodo:438 / Elemento padre: 360   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(438)).setAttribute("nombre","mipgndo4" );
      ((Element)v.get(438)).setAttribute("ancho","664" );
      ((Element)v.get(438)).setAttribute("sep","$" );
      ((Element)v.get(438)).setAttribute("x","12" );
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(438)).setAttribute("class","botonera" );
      ((Element)v.get(438)).setAttribute("y","715" );
      ((Element)v.get(438)).setAttribute("control","|" );
      ((Element)v.get(438)).setAttribute("conector","" );
      ((Element)v.get(438)).setAttribute("rowset","" );
      ((Element)v.get(438)).setAttribute("cargainicial","N" );
      ((Element)v.get(360)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(439)).setAttribute("nombre","ret4" );
      ((Element)v.get(439)).setAttribute("x","37" );
      ((Element)v.get(439)).setAttribute("y","719" );
      ((Element)v.get(439)).setAttribute("ID","botonContenido" );
      ((Element)v.get(439)).setAttribute("img","retroceder_on" );
      ((Element)v.get(439)).setAttribute("tipo","0" );
      ((Element)v.get(439)).setAttribute("estado","false" );
      ((Element)v.get(439)).setAttribute("alt","" );
      ((Element)v.get(439)).setAttribute("codigo","" );
      ((Element)v.get(439)).setAttribute("accion","mipgndo4.retroceder();" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */

      /* Empieza nodo:440 / Elemento padre: 438   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(440)).setAttribute("nombre","ava4" );
      ((Element)v.get(440)).setAttribute("x","52" );
      ((Element)v.get(440)).setAttribute("y","719" );
      ((Element)v.get(440)).setAttribute("ID","botonContenido" );
      ((Element)v.get(440)).setAttribute("img","avanzar_on" );
      ((Element)v.get(440)).setAttribute("tipo","0" );
      ((Element)v.get(440)).setAttribute("estado","false" );
      ((Element)v.get(440)).setAttribute("alt","" );
      ((Element)v.get(440)).setAttribute("codigo","" );
      ((Element)v.get(440)).setAttribute("accion","mipgndo4.avanzar();" );
      ((Element)v.get(438)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */
      /* Termina nodo:438   */
      /* Termina nodo:360   */

      /* Empieza nodo:441 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(441)).setAttribute("nombre","primera4" );
      ((Element)v.get(441)).setAttribute("x","20" );
      ((Element)v.get(441)).setAttribute("y","719" );
      ((Element)v.get(441)).setAttribute("ID","botonContenido" );
      ((Element)v.get(441)).setAttribute("img","primera_on" );
      ((Element)v.get(441)).setAttribute("tipo","1" );
      ((Element)v.get(441)).setAttribute("estado","false" );
      ((Element)v.get(441)).setAttribute("alt","" );
      ((Element)v.get(441)).setAttribute("codigo","" );
      ((Element)v.get(441)).setAttribute("accion","mipgndo4.retrocederPrimeraPagina();" );
      ((Element)v.get(6)).appendChild((Element)v.get(441));
      /* Termina nodo:441   */

      /* Empieza nodo:442 / Elemento padre: 6   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(442)).setAttribute("nombre","separa4" );
      ((Element)v.get(442)).setAttribute("x","59" );
      ((Element)v.get(442)).setAttribute("y","715" );
      ((Element)v.get(442)).setAttribute("ID","botonContenido" );
      ((Element)v.get(442)).setAttribute("img","separa_base" );
      ((Element)v.get(442)).setAttribute("tipo","0" );
      ((Element)v.get(442)).setAttribute("estado","false" );
      ((Element)v.get(442)).setAttribute("alt","" );
      ((Element)v.get(442)).setAttribute("codigo","" );
      ((Element)v.get(442)).setAttribute("accion","" );
      ((Element)v.get(6)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */

      /* Empieza nodo:443 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(443)).setAttribute("nombre","capaListaRegiones" );
      ((Element)v.get(443)).setAttribute("alto","10" );
      ((Element)v.get(443)).setAttribute("ancho","10" );
      ((Element)v.get(443)).setAttribute("colorf","" );
      ((Element)v.get(443)).setAttribute("borde","1" );
      ((Element)v.get(443)).setAttribute("imagenf","" );
      ((Element)v.get(443)).setAttribute("repeat","" );
      ((Element)v.get(443)).setAttribute("padding","" );
      ((Element)v.get(443)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(443)).setAttribute("contravsb","" );
      ((Element)v.get(443)).setAttribute("zindex","" );
      ((Element)v.get(443)).setAttribute("x","10" );
      ((Element)v.get(443)).setAttribute("y","10" );
      ((Element)v.get(6)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(444)).setAttribute("seleccion","boton" );
      ((Element)v.get(444)).setAttribute("nombre","listaRegiones" );
      ((Element)v.get(444)).setAttribute("ancho","582" );
      ((Element)v.get(444)).setAttribute("alto","150" );
      ((Element)v.get(444)).setAttribute("multisel","-1" );
      ((Element)v.get(444)).setAttribute("incy","1" );
      ((Element)v.get(444)).setAttribute("incx","10" );
      ((Element)v.get(444)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(444)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(444)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(444)).setAttribute("accion","" );
      ((Element)v.get(444)).setAttribute("sep","|" );
      ((Element)v.get(444)).setAttribute("pixelsborde","3" );
      ((Element)v.get(444)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(445)).setAttribute("nombre","cabecera" );
      ((Element)v.get(445)).setAttribute("height","20" );
      ((Element)v.get(444)).appendChild((Element)v.get(445));

      /* Empieza nodo:446 / Elemento padre: 445   */
   }

   private void getXML2070(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(446)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(446)).setAttribute("ancho","13" );
      ((Element)v.get(445)).appendChild((Element)v.get(446));
      /* Termina nodo:446   */

      /* Empieza nodo:447 / Elemento padre: 445   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(447)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(447)).setAttribute("ancho","300" );
      ((Element)v.get(445)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(448)).setAttribute("nombre","lbDivisionesPoliticas" );
      ((Element)v.get(448)).setAttribute("ancho","300" );
      ((Element)v.get(448)).setAttribute("alto","20" );
      ((Element)v.get(448)).setAttribute("filas","1" );
      ((Element)v.get(448)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(448)).setAttribute("valor","Divisiones Políticas" );
      ((Element)v.get(448)).setAttribute("enviaroculto","N" );
      ((Element)v.get(447)).appendChild((Element)v.get(448));
      /* Termina nodo:448   */
      /* Termina nodo:447   */

      /* Empieza nodo:449 / Elemento padre: 445   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(449)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(449)).setAttribute("ancho","150" );
      ((Element)v.get(445)).appendChild((Element)v.get(449));

      /* Empieza nodo:450 / Elemento padre: 449   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(450)).setAttribute("nombre","lbPais01" );
      ((Element)v.get(450)).setAttribute("ancho","150" );
      ((Element)v.get(450)).setAttribute("alto","20" );
      ((Element)v.get(450)).setAttribute("filas","1" );
      ((Element)v.get(450)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(450)).setAttribute("valor","País 01" );
      ((Element)v.get(450)).setAttribute("enviaroculto","N" );
      ((Element)v.get(449)).appendChild((Element)v.get(450));
      /* Termina nodo:450   */
      /* Termina nodo:449   */
      /* Termina nodo:445   */

      /* Empieza nodo:451 / Elemento padre: 444   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(451)).setAttribute("ancho","10" );
      ((Element)v.get(451)).setAttribute("filas","1" );
      ((Element)v.get(451)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(444)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(452)).setAttribute("ancho","13" );
      ((Element)v.get(451)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */

      /* Empieza nodo:453 / Elemento padre: 451   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(453)).setAttribute("ancho","300" );
      ((Element)v.get(453)).setAttribute("caracteres","100" );
      ((Element)v.get(451)).appendChild((Element)v.get(453));
      /* Termina nodo:453   */

      /* Empieza nodo:454 / Elemento padre: 451   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(454)).setAttribute("ancho","150" );
      ((Element)v.get(454)).setAttribute("caracteres","30" );
      ((Element)v.get(451)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */
      /* Termina nodo:451   */

      /* Empieza nodo:455 / Elemento padre: 444   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(444)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */
      /* Termina nodo:444   */
      /* Termina nodo:443   */

      /* Empieza nodo:456 / Elemento padre: 6   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(456)).setAttribute("nombre","capaListaZonas" );
      ((Element)v.get(456)).setAttribute("alto","10" );
      ((Element)v.get(456)).setAttribute("ancho","10" );
      ((Element)v.get(456)).setAttribute("colorf","" );
      ((Element)v.get(456)).setAttribute("borde","1" );
      ((Element)v.get(456)).setAttribute("imagenf","" );
      ((Element)v.get(456)).setAttribute("repeat","" );
      ((Element)v.get(456)).setAttribute("padding","" );
      ((Element)v.get(456)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(456)).setAttribute("contravsb","" );
      ((Element)v.get(456)).setAttribute("zindex","" );
      ((Element)v.get(456)).setAttribute("x","10" );
      ((Element)v.get(456)).setAttribute("y","10" );
      ((Element)v.get(6)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(457)).setAttribute("seleccion","boton" );
      ((Element)v.get(457)).setAttribute("nombre","listaZonas" );
      ((Element)v.get(457)).setAttribute("ancho","582" );
      ((Element)v.get(457)).setAttribute("alto","150" );
      ((Element)v.get(457)).setAttribute("multisel","-1" );
      ((Element)v.get(457)).setAttribute("incy","1" );
      ((Element)v.get(457)).setAttribute("incx","10" );
      ((Element)v.get(457)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(457)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(457)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(457)).setAttribute("accion","" );
      ((Element)v.get(457)).setAttribute("sep","|" );
      ((Element)v.get(457)).setAttribute("pixelsborde","3" );
      ((Element)v.get(457)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(456)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(458)).setAttribute("nombre","cabecera" );
      ((Element)v.get(458)).setAttribute("height","20" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));

      /* Empieza nodo:459 / Elemento padre: 458   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(459)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(459)).setAttribute("ancho","13" );
      ((Element)v.get(458)).appendChild((Element)v.get(459));
      /* Termina nodo:459   */

      /* Empieza nodo:460 / Elemento padre: 458   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(460)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(460)).setAttribute("ancho","300" );
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(458)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(461)).setAttribute("nombre","lbDivisionesPoliticas" );
      ((Element)v.get(461)).setAttribute("ancho","300" );
      ((Element)v.get(461)).setAttribute("alto","20" );
      ((Element)v.get(461)).setAttribute("filas","1" );
      ((Element)v.get(461)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(461)).setAttribute("valor","Divisiones Políticas" );
      ((Element)v.get(461)).setAttribute("enviaroculto","N" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));
      /* Termina nodo:461   */
      /* Termina nodo:460   */

      /* Empieza nodo:462 / Elemento padre: 458   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(462)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(462)).setAttribute("ancho","150" );
      ((Element)v.get(458)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(463)).setAttribute("nombre","lbPais01" );
      ((Element)v.get(463)).setAttribute("ancho","150" );
      ((Element)v.get(463)).setAttribute("alto","20" );
      ((Element)v.get(463)).setAttribute("filas","1" );
      ((Element)v.get(463)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(463)).setAttribute("valor","País 01" );
      ((Element)v.get(463)).setAttribute("enviaroculto","N" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */
      /* Termina nodo:462   */
      /* Termina nodo:458   */

      /* Empieza nodo:464 / Elemento padre: 457   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(464)).setAttribute("ancho","10" );
      ((Element)v.get(464)).setAttribute("filas","1" );
      ((Element)v.get(464)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(457)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(465)).setAttribute("ancho","13" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));
      /* Termina nodo:465   */

      /* Empieza nodo:466 / Elemento padre: 464   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(466)).setAttribute("ancho","300" );
      ((Element)v.get(466)).setAttribute("caracteres","100" );
      ((Element)v.get(464)).appendChild((Element)v.get(466));
      /* Termina nodo:466   */

      /* Empieza nodo:467 / Elemento padre: 464   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(467)).setAttribute("ancho","150" );
      ((Element)v.get(467)).setAttribute("caracteres","30" );
      ((Element)v.get(464)).appendChild((Element)v.get(467));
      /* Termina nodo:467   */
      /* Termina nodo:464   */

      /* Empieza nodo:468 / Elemento padre: 457   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(457)).appendChild((Element)v.get(468));
      /* Termina nodo:468   */
      /* Termina nodo:457   */
      /* Termina nodo:456   */
      /* Termina nodo:6   */


   }

}

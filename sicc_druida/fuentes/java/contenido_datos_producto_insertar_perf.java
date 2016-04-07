
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_datos_producto_insertar_perf  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_datos_producto_insertar_perf" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("cod","0397" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
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
      ((Element)v.get(4)).setAttribute("src","contenido_datos_producto_insertar_perf.js" );
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
      ((Element)v.get(7)).setAttribute("name","txtFactorRepeticion" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("format","N" );
      ((Element)v.get(7)).setAttribute("cod","529" );
      ((Element)v.get(7)).setAttribute("req","N" );
      ((Element)v.get(7)).setAttribute("max","99" );
      ((Element)v.get(7)).setAttribute("min","1" );
      ((Element)v.get(7)).setAttribute("group","gral" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","txtPrecioCat" );
      ((Element)v.get(8)).setAttribute("required","false" );
      ((Element)v.get(8)).setAttribute("format","N" );
      ((Element)v.get(8)).setAttribute("cod","503" );
      ((Element)v.get(8)).setAttribute("req","N" );
      ((Element)v.get(8)).setAttribute("max","999999999999.99" );
      ((Element)v.get(8)).setAttribute("min","0" );
      ((Element)v.get(8)).setAttribute("group","gral" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","txtUniEstimadas2" );
      ((Element)v.get(9)).setAttribute("required","false" );
      ((Element)v.get(9)).setAttribute("format","E" );
      ((Element)v.get(9)).setAttribute("cod","449" );
      ((Element)v.get(9)).setAttribute("req","N" );
      ((Element)v.get(9)).setAttribute("max","9999999999" );
      ((Element)v.get(9)).setAttribute("min","0" );
      ((Element)v.get(9)).setAttribute("group","gral" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","txtVentaNetaEstimada" );
      ((Element)v.get(10)).setAttribute("required","false" );
      ((Element)v.get(10)).setAttribute("format","N" );
      ((Element)v.get(10)).setAttribute("cod","605" );
      ((Element)v.get(10)).setAttribute("req","N" );
      ((Element)v.get(10)).setAttribute("max","999999999999999.99" );
      ((Element)v.get(10)).setAttribute("min","0" );
      ((Element)v.get(10)).setAttribute("group","gral" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","txtNPagCatalogo" );
      ((Element)v.get(11)).setAttribute("required","false" );
      ((Element)v.get(11)).setAttribute("format","E" );
      ((Element)v.get(11)).setAttribute("cod","606" );
      ((Element)v.get(11)).setAttribute("req","N" );
      ((Element)v.get(11)).setAttribute("max","999" );
      ((Element)v.get(11)).setAttribute("min","0" );
      ((Element)v.get(11)).setAttribute("group","gral" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","txtPosPagina" );
      ((Element)v.get(12)).setAttribute("required","false" );
      ((Element)v.get(12)).setAttribute("format","E" );
      ((Element)v.get(12)).setAttribute("cod","1284" );
      ((Element)v.get(12)).setAttribute("req","N" );
      ((Element)v.get(12)).setAttribute("max","999" );
      ((Element)v.get(12)).setAttribute("min","0" );
      ((Element)v.get(12)).setAttribute("group","gral" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","cbCondicionPromo" );
      ((Element)v.get(13)).setAttribute("required","false" );
      ((Element)v.get(13)).setAttribute("cod","607" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(13)).setAttribute("req","N" );
      ((Element)v.get(13)).setAttribute("group","gral" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","cbTipoOferta" );
      ((Element)v.get(14)).setAttribute("required","true" );
      ((Element)v.get(14)).setAttribute("cod","608" );
      ((Element)v.get(14)).setAttribute("req","N" );
      ((Element)v.get(14)).setAttribute("group","gral" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(15)).setAttribute("name","cbCicloVida" );
      ((Element)v.get(15)).setAttribute("required","true" );
      ((Element)v.get(15)).setAttribute("cod","581" );
      ((Element)v.get(15)).setAttribute("req","N" );
      ((Element)v.get(15)).setAttribute("group","gral" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(16)).setAttribute("name","cbVariante" );
      ((Element)v.get(16)).setAttribute("required","true" );
      ((Element)v.get(16)).setAttribute("cod","3053" );
      ((Element)v.get(16)).setAttribute("req","N" );
      ((Element)v.get(16)).setAttribute("group","priviledges" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(17)).setAttribute("name","txtPuntoFijo" );
      ((Element)v.get(17)).setAttribute("required","true" );
      ((Element)v.get(17)).setAttribute("format","E" );
      ((Element)v.get(17)).setAttribute("cod","3054" );
      ((Element)v.get(17)).setAttribute("req","N" );
      ((Element)v.get(17)).setAttribute("max","999" );
      ((Element)v.get(17)).setAttribute("min","0" );
      ((Element)v.get(17)).setAttribute("group","priviledges2" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */
      /* Termina nodo:6   */

      /* Empieza nodo:18 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(18)).setAttribute("nombre","frmContenido" );
      ((Element)v.get(0)).appendChild((Element)v.get(18));

      /* Empieza nodo:19 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(19)).setAttribute("valor","LPDatosProductoPerf" );
      ((Element)v.get(18)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","accion" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","oid" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","ocbCondicionPromo" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","ocbCicloVida" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","ocbTipoOferta" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","ocbProgramaFidelizacion" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","ocbVariante" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","imprimible" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","himprimible" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","digitable" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hdigitable" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","enableimprimible" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(32)).setAttribute("nombre","henableimprimible" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","enabledigitable" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","henabledigitable" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hTipoEstrategia" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hCompuestaFija" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","htipoOperacionMODIFICACION" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hlstTiposOferta" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hlstVariantes" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","comis" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","punta" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","estad" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","mmini" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","amesc" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","multiseleccion" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","precioPosX" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","hFideHabilita" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","hidDeshabilitarTrioCampos" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","htipoOperacion" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","obligaPuntoFijo" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 18   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","hlpRetorno" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(18)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 18   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(52)).setAttribute("nombre","capaContenido" );
      ((Element)v.get(52)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(52)).setAttribute("borde","0" );
      ((Element)v.get(52)).setAttribute("imagenf","" );
      ((Element)v.get(52)).setAttribute("repeat","" );
      ((Element)v.get(52)).setAttribute("padding","" );
      ((Element)v.get(52)).setAttribute("visibilidad","" );
      ((Element)v.get(52)).setAttribute("contravsb","" );
      ((Element)v.get(52)).setAttribute("x","0" );
      ((Element)v.get(52)).setAttribute("y","0" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(52)).setAttribute("zindex","" );
      ((Element)v.get(18)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("table"));
      ((Element)v.get(53)).setAttribute("width","100%" );
      ((Element)v.get(53)).setAttribute("border","0" );
      ((Element)v.get(53)).setAttribute("cellspacing","0" );
      ((Element)v.get(53)).setAttribute("cellpadding","0" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).setAttribute("width","12" );
      ((Element)v.get(55)).setAttribute("align","center" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","12" );
      ((Element)v.get(56)).setAttribute("height","12" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).setAttribute("width","750" );
      ((Element)v.get(54)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).setAttribute("width","12" );
      ((Element)v.get(54)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","12" );
      ((Element)v.get(60)).setAttribute("height","1" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:54   */

      /* Empieza nodo:61 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(66)).setAttribute("class","legend" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(67)).setAttribute("nombre","lblDatosProducto" );
      ((Element)v.get(67)).setAttribute("alto","13" );
      ((Element)v.get(67)).setAttribute("filas","1" );
      ((Element)v.get(67)).setAttribute("valor","Datos de producto" );
      ((Element)v.get(67)).setAttribute("id","legend" );
      ((Element)v.get(67)).setAttribute("cod","00105" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 65   */
      v.add(doc.createElement("table"));
      ((Element)v.get(68)).setAttribute("width","100%" );
      ((Element)v.get(68)).setAttribute("border","0" );
      ((Element)v.get(68)).setAttribute("align","center" );
      ((Element)v.get(68)).setAttribute("cellspacing","0" );
      ((Element)v.get(68)).setAttribute("cellpadding","0" );
      ((Element)v.get(65)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).setAttribute("colspan","4" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","8" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:72 / Elemento padre: 68   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(68)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","8" );
      ((Element)v.get(74)).setAttribute("height","8" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(76)).setAttribute("nombre","lblCodProducto" );
      ((Element)v.get(76)).setAttribute("alto","13" );
      ((Element)v.get(76)).setAttribute("filas","1" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(76)).setAttribute("id","datosTitle" );
      ((Element)v.get(76)).setAttribute("cod","337" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","25" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(80)).setAttribute("nombre","lblTextoBreve" );
      ((Element)v.get(80)).setAttribute("alto","13" );
      ((Element)v.get(80)).setAttribute("filas","1" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(80)).setAttribute("id","datosTitle" );
      ((Element)v.get(80)).setAttribute("cod","1214" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","25" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(84)).setAttribute("nombre","lblCatalogo" );
      ((Element)v.get(84)).setAttribute("alto","13" );
      ((Element)v.get(84)).setAttribute("filas","1" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(84)).setAttribute("id","datosTitle" );
      ((Element)v.get(84)).setAttribute("cod","516" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(86)).setAttribute("width","25" );
      ((Element)v.get(86)).setAttribute("height","8" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(88)).setAttribute("nombre","lblFactorRepeticion" );
      ((Element)v.get(88)).setAttribute("alto","13" );
      ((Element)v.get(88)).setAttribute("filas","1" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(88)).setAttribute("id","datosTitle" );
      ((Element)v.get(88)).setAttribute("cod","529" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(90)).setAttribute("width","25" );
      ((Element)v.get(90)).setAttribute("height","8" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(92)).setAttribute("nombre","lblDigitable" );
      ((Element)v.get(92)).setAttribute("alto","13" );
      ((Element)v.get(92)).setAttribute("filas","1" );
      ((Element)v.get(92)).setAttribute("valor","" );
      ((Element)v.get(92)).setAttribute("id","datosTitle" );
      ((Element)v.get(92)).setAttribute("cod","493" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","25" );
      ((Element)v.get(94)).setAttribute("height","8" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(96)).setAttribute("nombre","lblImprimible" );
      ((Element)v.get(96)).setAttribute("alto","13" );
      ((Element)v.get(96)).setAttribute("filas","1" );
      ((Element)v.get(96)).setAttribute("valor","" );
      ((Element)v.get(96)).setAttribute("id","datosTitle" );
      ((Element)v.get(96)).setAttribute("cod","1215" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).setAttribute("width","100%" );
      ((Element)v.get(72)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).setAttribute("width","8" );
      ((Element)v.get(98)).setAttribute("height","8" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:72   */

      /* Empieza nodo:99 / Elemento padre: 68   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(68)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","8" );
      ((Element)v.get(101)).setAttribute("height","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(99)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(103)).setAttribute("nombre","txtCodProducto" );
      ((Element)v.get(103)).setAttribute("id","datosCampos" );
      ((Element)v.get(103)).setAttribute("max","20" );
      ((Element)v.get(103)).setAttribute("tipo","" );
      ((Element)v.get(103)).setAttribute("onchange","" );
      ((Element)v.get(103)).setAttribute("req","N" );
      ((Element)v.get(103)).setAttribute("size","26" );
      ((Element)v.get(103)).setAttribute("valor","" );
      ((Element)v.get(103)).setAttribute("validacion","" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","25" );
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(99)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(107)).setAttribute("nombre","txtTextoBreve" );
      ((Element)v.get(107)).setAttribute("id","datosCampos" );
      ((Element)v.get(107)).setAttribute("max","40" );
      ((Element)v.get(107)).setAttribute("tipo","" );
      ((Element)v.get(107)).setAttribute("onchange","" );
      ((Element)v.get(107)).setAttribute("req","N" );
      ((Element)v.get(107)).setAttribute("size","40" );
      ((Element)v.get(107)).setAttribute("valor","" );
      ((Element)v.get(107)).setAttribute("validacion","" );
      ((Element)v.get(107)).setAttribute("onshtab"," toButton()" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:108 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","25" );
      ((Element)v.get(109)).setAttribute("height","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(99)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(111)).setAttribute("nombre","txtCatalogo" );
      ((Element)v.get(111)).setAttribute("id","datosCampos" );
      ((Element)v.get(111)).setAttribute("max","40" );
      ((Element)v.get(111)).setAttribute("tipo","" );
      ((Element)v.get(111)).setAttribute("onchange","" );
      ((Element)v.get(111)).setAttribute("req","N" );
      ((Element)v.get(111)).setAttribute("size","40" );
      ((Element)v.get(111)).setAttribute("valor","" );
      ((Element)v.get(111)).setAttribute("validacion","" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(113)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).setAttribute("width","25" );
      ((Element)v.get(113)).setAttribute("height","8" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(99)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(115)).setAttribute("nombre","txtFactorRepeticion" );
      ((Element)v.get(115)).setAttribute("id","datosCampos" );
      ((Element)v.get(115)).setAttribute("max","2" );
      ((Element)v.get(115)).setAttribute("tipo","" );
      ((Element)v.get(115)).setAttribute("onchange","" );
      ((Element)v.get(115)).setAttribute("req","S" );
      ((Element)v.get(115)).setAttribute("size","2" );
      ((Element)v.get(115)).setAttribute("valor","" );
      ((Element)v.get(115)).setAttribute("validacion","" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","25" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(119)).setAttribute("nombre","ckDigitable" );
      ((Element)v.get(119)).setAttribute("texto","" );
      ((Element)v.get(119)).setAttribute("check","N" );
      ((Element)v.get(119)).setAttribute("validacion","" );
      ((Element)v.get(119)).setAttribute("req","N" );
      ((Element)v.get(119)).setAttribute("id","datosCampos" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","25" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(123)).setAttribute("nombre","ckImprimible" );
      ((Element)v.get(123)).setAttribute("texto","" );
      ((Element)v.get(123)).setAttribute("check","N" );
      ((Element)v.get(123)).setAttribute("validacion","" );
      ((Element)v.get(123)).setAttribute("req","N" );
      ((Element)v.get(123)).setAttribute("id","datosCampos" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).setAttribute("width","100%" );
      ((Element)v.get(99)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).setAttribute("width","8" );
      ((Element)v.get(125)).setAttribute("height","8" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:99   */

      /* Empieza nodo:126 / Elemento padre: 68   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(68)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).setAttribute("colspan","4" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","8" );
      ((Element)v.get(128)).setAttribute("height","8" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:68   */

      /* Empieza nodo:129 / Elemento padre: 65   */
      v.add(doc.createElement("table"));
      ((Element)v.get(129)).setAttribute("width","100%" );
      ((Element)v.get(129)).setAttribute("border","0" );
      ((Element)v.get(129)).setAttribute("align","center" );
      ((Element)v.get(129)).setAttribute("cellspacing","0" );
      ((Element)v.get(129)).setAttribute("cellpadding","0" );
      ((Element)v.get(65)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(132)).setAttribute("width","8" );
      ((Element)v.get(132)).setAttribute("height","8" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(134)).setAttribute("nombre","lblComisionable" );
      ((Element)v.get(134)).setAttribute("alto","13" );
      ((Element)v.get(134)).setAttribute("filas","1" );
      ((Element)v.get(134)).setAttribute("valor","" );
      ((Element)v.get(134)).setAttribute("id","datosTitle" );
      ((Element)v.get(134)).setAttribute("cod","466" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","25" );
      ((Element)v.get(136)).setAttribute("height","8" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(138)).setAttribute("nombre","lblPuntaje" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(138)).setAttribute("alto","13" );
      ((Element)v.get(138)).setAttribute("filas","1" );
      ((Element)v.get(138)).setAttribute("valor","" );
      ((Element)v.get(138)).setAttribute("id","datosTitle" );
      ((Element)v.get(138)).setAttribute("cod","467" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","25" );
      ((Element)v.get(140)).setAttribute("height","8" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(142)).setAttribute("nombre","lblEstadisticable" );
      ((Element)v.get(142)).setAttribute("alto","13" );
      ((Element)v.get(142)).setAttribute("filas","1" );
      ((Element)v.get(142)).setAttribute("valor","" );
      ((Element)v.get(142)).setAttribute("id","datosTitle" );
      ((Element)v.get(142)).setAttribute("cod","468" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","25" );
      ((Element)v.get(144)).setAttribute("height","8" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(146)).setAttribute("nombre","lblMontoMinimo" );
      ((Element)v.get(146)).setAttribute("alto","13" );
      ((Element)v.get(146)).setAttribute("filas","1" );
      ((Element)v.get(146)).setAttribute("valor","" );
      ((Element)v.get(146)).setAttribute("id","datosTitle" );
      ((Element)v.get(146)).setAttribute("cod","469" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:147 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).setAttribute("width","25" );
      ((Element)v.get(148)).setAttribute("height","8" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(150)).setAttribute("nombre","lblAportaMonto" );
      ((Element)v.get(150)).setAttribute("alto","13" );
      ((Element)v.get(150)).setAttribute("filas","1" );
      ((Element)v.get(150)).setAttribute("valor","" );
      ((Element)v.get(150)).setAttribute("id","datosTitle" );
      ((Element)v.get(150)).setAttribute("cod","470" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).setAttribute("width","100%" );
      ((Element)v.get(130)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).setAttribute("width","8" );
      ((Element)v.get(152)).setAttribute("height","8" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:130   */

      /* Empieza nodo:153 / Elemento padre: 129   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(129)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(155)).setAttribute("src","b.gif" );
      ((Element)v.get(155)).setAttribute("width","8" );
      ((Element)v.get(155)).setAttribute("height","8" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:156 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(153)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(157)).setAttribute("nombre","lblComisionableX" );
      ((Element)v.get(157)).setAttribute("alto","13" );
      ((Element)v.get(157)).setAttribute("filas","1" );
      ((Element)v.get(157)).setAttribute("valor","" );
      ((Element)v.get(157)).setAttribute("id","datosCampos" );
      ((Element)v.get(157)).setAttribute("codi","5" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:158 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","25" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(159)).setAttribute("height","8" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(153)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(161)).setAttribute("nombre","lblPuntajeX" );
      ((Element)v.get(161)).setAttribute("alto","13" );
      ((Element)v.get(161)).setAttribute("filas","1" );
      ((Element)v.get(161)).setAttribute("valor","" );
      ((Element)v.get(161)).setAttribute("id","datosCampos" );
      ((Element)v.get(161)).setAttribute("codi","5" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(163)).setAttribute("width","25" );
      ((Element)v.get(163)).setAttribute("height","8" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(153)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(165)).setAttribute("nombre","lblEstadisticableX" );
      ((Element)v.get(165)).setAttribute("alto","13" );
      ((Element)v.get(165)).setAttribute("filas","1" );
      ((Element)v.get(165)).setAttribute("valor","" );
      ((Element)v.get(165)).setAttribute("id","datosCampos" );
      ((Element)v.get(165)).setAttribute("codi","5" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).setAttribute("width","25" );
      ((Element)v.get(167)).setAttribute("height","8" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:168 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(153)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(169)).setAttribute("nombre","lblMontoMinimoX" );
      ((Element)v.get(169)).setAttribute("alto","13" );
      ((Element)v.get(169)).setAttribute("filas","1" );
      ((Element)v.get(169)).setAttribute("valor","" );
      ((Element)v.get(169)).setAttribute("id","datosCampos" );
      ((Element)v.get(169)).setAttribute("codi","5" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(171)).setAttribute("src","b.gif" );
      ((Element)v.get(171)).setAttribute("width","25" );
      ((Element)v.get(171)).setAttribute("height","8" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:172 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(153)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(173)).setAttribute("nombre","lblAportaMontoX" );
      ((Element)v.get(173)).setAttribute("alto","13" );
      ((Element)v.get(173)).setAttribute("filas","1" );
      ((Element)v.get(173)).setAttribute("valor","" );
      ((Element)v.get(173)).setAttribute("id","datosCampos" );
      ((Element)v.get(173)).setAttribute("codi","5" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:174 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).setAttribute("width","100%" );
      ((Element)v.get(153)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(175)).setAttribute("src","b.gif" );
      ((Element)v.get(175)).setAttribute("width","8" );
      ((Element)v.get(175)).setAttribute("height","8" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */
      /* Termina nodo:153   */

      /* Empieza nodo:176 / Elemento padre: 129   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(129)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).setAttribute("colspan","4" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(178)).setAttribute("src","b.gif" );
      ((Element)v.get(178)).setAttribute("width","8" );
      ((Element)v.get(178)).setAttribute("height","8" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:129   */

      /* Empieza nodo:179 / Elemento padre: 65   */
      v.add(doc.createElement("table"));
      ((Element)v.get(179)).setAttribute("width","100%" );
      ((Element)v.get(179)).setAttribute("border","0" );
      ((Element)v.get(179)).setAttribute("align","center" );
      ((Element)v.get(179)).setAttribute("cellspacing","0" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(179)).setAttribute("cellpadding","0" );
      ((Element)v.get(65)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(182)).setAttribute("src","b.gif" );
      ((Element)v.get(182)).setAttribute("width","8" );
      ((Element)v.get(182)).setAttribute("height","8" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(184)).setAttribute("nombre","lblPrecioCat" );
      ((Element)v.get(184)).setAttribute("alto","13" );
      ((Element)v.get(184)).setAttribute("filas","1" );
      ((Element)v.get(184)).setAttribute("valor","" );
      ((Element)v.get(184)).setAttribute("id","datosTitle" );
      ((Element)v.get(184)).setAttribute("cod","503" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).setAttribute("width","25" );
      ((Element)v.get(186)).setAttribute("height","8" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(188)).setAttribute("nombre","lblPrecioPos" );
      ((Element)v.get(188)).setAttribute("alto","13" );
      ((Element)v.get(188)).setAttribute("filas","1" );
      ((Element)v.get(188)).setAttribute("valor","" );
      ((Element)v.get(188)).setAttribute("id","datosTitle" );
      ((Element)v.get(188)).setAttribute("cod","1116" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","25" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(192)).setAttribute("src","b.gif" );
      ((Element)v.get(192)).setAttribute("width","25" );
      ((Element)v.get(192)).setAttribute("height","8" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:193 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(194)).setAttribute("nombre","lblCosteEstandar" );
      ((Element)v.get(194)).setAttribute("alto","13" );
      ((Element)v.get(194)).setAttribute("filas","1" );
      ((Element)v.get(194)).setAttribute("valor","" );
      ((Element)v.get(194)).setAttribute("id","datosTitle" );
      ((Element)v.get(194)).setAttribute("cod","604" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).setAttribute("width","100%" );
      ((Element)v.get(180)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(196)).setAttribute("width","8" );
      ((Element)v.get(196)).setAttribute("height","8" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */
      /* Termina nodo:180   */

      /* Empieza nodo:197 / Elemento padre: 179   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(179)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(199)).setAttribute("src","b.gif" );
      ((Element)v.get(199)).setAttribute("width","8" );
      ((Element)v.get(199)).setAttribute("height","8" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 197   */
      v.add(doc.createElement("td"));
      ((Element)v.get(200)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(197)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(201)).setAttribute("nombre","txtPrecioCat" );
      ((Element)v.get(201)).setAttribute("id","datosCampos" );
      ((Element)v.get(201)).setAttribute("max","18" );
      ((Element)v.get(201)).setAttribute("tipo","" );
      ((Element)v.get(201)).setAttribute("onchange","" );
      ((Element)v.get(201)).setAttribute("req","N" );
      ((Element)v.get(201)).setAttribute("size","16" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(201)).setAttribute("valor","" );
      ((Element)v.get(201)).setAttribute("validacion","" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 197   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(203)).setAttribute("src","b.gif" );
      ((Element)v.get(203)).setAttribute("width","25" );
      ((Element)v.get(203)).setAttribute("height","8" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 197   */
      v.add(doc.createElement("td"));
      ((Element)v.get(204)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(197)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(205)).setAttribute("nombre","txtPrecioPos" );
      ((Element)v.get(205)).setAttribute("id","datosCampos" );
      ((Element)v.get(205)).setAttribute("max","18" );
      ((Element)v.get(205)).setAttribute("tipo","" );
      ((Element)v.get(205)).setAttribute("onchange","" );
      ((Element)v.get(205)).setAttribute("req","N" );
      ((Element)v.get(205)).setAttribute("size","16" );
      ((Element)v.get(205)).setAttribute("valor","" );
      ((Element)v.get(205)).setAttribute("validacion","" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 197   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(207)).setAttribute("src","b.gif" );
      ((Element)v.get(207)).setAttribute("width","25" );
      ((Element)v.get(207)).setAttribute("height","8" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 197   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","25" );
      ((Element)v.get(209)).setAttribute("height","8" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 197   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(197)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(211)).setAttribute("nombre","txtCosteEstandar" );
      ((Element)v.get(211)).setAttribute("id","datosCampos" );
      ((Element)v.get(211)).setAttribute("max","18" );
      ((Element)v.get(211)).setAttribute("tipo","" );
      ((Element)v.get(211)).setAttribute("onchange","" );
      ((Element)v.get(211)).setAttribute("req","N" );
      ((Element)v.get(211)).setAttribute("size","16" );
      ((Element)v.get(211)).setAttribute("valor","" );
      ((Element)v.get(211)).setAttribute("validacion","" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 197   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).setAttribute("width","100%" );
      ((Element)v.get(197)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(213)).setAttribute("src","b.gif" );
      ((Element)v.get(213)).setAttribute("width","8" );
      ((Element)v.get(213)).setAttribute("height","8" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */
      /* Termina nodo:197   */

      /* Empieza nodo:214 / Elemento padre: 179   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(179)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("td"));
      ((Element)v.get(215)).setAttribute("colspan","4" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(216)).setAttribute("src","b.gif" );
      ((Element)v.get(216)).setAttribute("width","8" );
      ((Element)v.get(216)).setAttribute("height","8" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */
      /* Termina nodo:214   */
      /* Termina nodo:179   */

      /* Empieza nodo:217 / Elemento padre: 65   */
      v.add(doc.createElement("table"));
      ((Element)v.get(217)).setAttribute("width","100%" );
      ((Element)v.get(217)).setAttribute("border","0" );
      ((Element)v.get(217)).setAttribute("align","center" );
      ((Element)v.get(217)).setAttribute("cellspacing","0" );
      ((Element)v.get(217)).setAttribute("cellpadding","0" );
      ((Element)v.get(65)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(220)).setAttribute("src","b.gif" );
      ((Element)v.get(220)).setAttribute("width","8" );
      ((Element)v.get(220)).setAttribute("height","8" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:221 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(222)).setAttribute("nombre","lblUniEstimadas2" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(222)).setAttribute("alto","13" );
      ((Element)v.get(222)).setAttribute("filas","1" );
      ((Element)v.get(222)).setAttribute("valor","" );
      ((Element)v.get(222)).setAttribute("id","datosTitle" );
      ((Element)v.get(222)).setAttribute("cod","449" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:223 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(224)).setAttribute("src","b.gif" );
      ((Element)v.get(224)).setAttribute("width","25" );
      ((Element)v.get(224)).setAttribute("height","8" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:225 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(226)).setAttribute("nombre","lblVentaNetaEstimada" );
      ((Element)v.get(226)).setAttribute("alto","13" );
      ((Element)v.get(226)).setAttribute("filas","1" );
      ((Element)v.get(226)).setAttribute("valor","" );
      ((Element)v.get(226)).setAttribute("id","datosTitle" );
      ((Element)v.get(226)).setAttribute("cod","605" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:227 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(228)).setAttribute("src","b.gif" );
      ((Element)v.get(228)).setAttribute("width","25" );
      ((Element)v.get(228)).setAttribute("height","8" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:229 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(230)).setAttribute("nombre","lblNPagCatalogo" );
      ((Element)v.get(230)).setAttribute("alto","13" );
      ((Element)v.get(230)).setAttribute("filas","1" );
      ((Element)v.get(230)).setAttribute("valor","" );
      ((Element)v.get(230)).setAttribute("id","datosTitle" );
      ((Element)v.get(230)).setAttribute("cod","606" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(232)).setAttribute("src","b.gif" );
      ((Element)v.get(232)).setAttribute("width","25" );
      ((Element)v.get(232)).setAttribute("height","8" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:233 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(234)).setAttribute("nombre","lblPosPagina" );
      ((Element)v.get(234)).setAttribute("alto","13" );
      ((Element)v.get(234)).setAttribute("filas","1" );
      ((Element)v.get(234)).setAttribute("valor","" );
      ((Element)v.get(234)).setAttribute("id","datosTitle" );
      ((Element)v.get(234)).setAttribute("cod","1284" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:235 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(235)).setAttribute("width","100%" );
      ((Element)v.get(218)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(236)).setAttribute("src","b.gif" );
      ((Element)v.get(236)).setAttribute("width","8" );
      ((Element)v.get(236)).setAttribute("height","8" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */
      /* Termina nodo:218   */

      /* Empieza nodo:237 / Elemento padre: 217   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(217)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(239)).setAttribute("src","b.gif" );
      ((Element)v.get(239)).setAttribute("width","8" );
      ((Element)v.get(239)).setAttribute("height","8" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:240 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(240)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(237)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(241)).setAttribute("nombre","txtUniEstimadas2" );
      ((Element)v.get(241)).setAttribute("id","datosCampos" );
      ((Element)v.get(241)).setAttribute("max","10" );
      ((Element)v.get(241)).setAttribute("tipo","" );
      ((Element)v.get(241)).setAttribute("onchange","" );
      ((Element)v.get(241)).setAttribute("req","N" );
      ((Element)v.get(241)).setAttribute("size","12" );
      ((Element)v.get(241)).setAttribute("valor","" );
      ((Element)v.get(241)).setAttribute("validacion","" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:242 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(243)).setAttribute("src","b.gif" );
      ((Element)v.get(243)).setAttribute("width","25" );
      ((Element)v.get(243)).setAttribute("height","8" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:244 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(237)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(245)).setAttribute("nombre","txtVentaNetaEstimada" );
      ((Element)v.get(245)).setAttribute("id","datosCampos" );
      ((Element)v.get(245)).setAttribute("max","20" );
      ((Element)v.get(245)).setAttribute("tipo","" );
      ((Element)v.get(245)).setAttribute("onchange","" );
      ((Element)v.get(245)).setAttribute("req","N" );
      ((Element)v.get(245)).setAttribute("size","26" );
      ((Element)v.get(245)).setAttribute("valor","" );
      ((Element)v.get(245)).setAttribute("validacion","" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:246 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(247)).setAttribute("src","b.gif" );
      ((Element)v.get(247)).setAttribute("width","25" );
      ((Element)v.get(247)).setAttribute("height","8" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:248 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(237)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(249)).setAttribute("nombre","txtNPagCatalogo" );
      ((Element)v.get(249)).setAttribute("id","datosCampos" );
      ((Element)v.get(249)).setAttribute("max","3" );
      ((Element)v.get(249)).setAttribute("tipo","" );
      ((Element)v.get(249)).setAttribute("onchange","" );
      ((Element)v.get(249)).setAttribute("req","N" );
      ((Element)v.get(249)).setAttribute("size","3" );
      ((Element)v.get(249)).setAttribute("valor","" );
      ((Element)v.get(249)).setAttribute("validacion","" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:250 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(251)).setAttribute("src","b.gif" );
      ((Element)v.get(251)).setAttribute("width","25" );
      ((Element)v.get(251)).setAttribute("height","8" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:252 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(252)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(237)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(253)).setAttribute("nombre","txtPosPagina" );
      ((Element)v.get(253)).setAttribute("id","datosCampos" );
      ((Element)v.get(253)).setAttribute("max","3" );
      ((Element)v.get(253)).setAttribute("tipo","" );
      ((Element)v.get(253)).setAttribute("onchange","" );
      ((Element)v.get(253)).setAttribute("req","N" );
      ((Element)v.get(253)).setAttribute("size","3" );
      ((Element)v.get(253)).setAttribute("valor","" );
      ((Element)v.get(253)).setAttribute("validacion","" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */

      /* Empieza nodo:254 / Elemento padre: 237   */
      v.add(doc.createElement("td"));
      ((Element)v.get(254)).setAttribute("width","100%" );
      ((Element)v.get(237)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(255)).setAttribute("src","b.gif" );
      ((Element)v.get(255)).setAttribute("width","8" );
      ((Element)v.get(255)).setAttribute("height","8" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */
      /* Termina nodo:237   */

      /* Empieza nodo:256 / Elemento padre: 217   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(217)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("td"));
      ((Element)v.get(257)).setAttribute("colspan","4" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(258)).setAttribute("src","b.gif" );
      ((Element)v.get(258)).setAttribute("width","8" );
      ((Element)v.get(258)).setAttribute("height","8" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:217   */

      /* Empieza nodo:259 / Elemento padre: 65   */
      v.add(doc.createElement("table"));
      ((Element)v.get(259)).setAttribute("width","100%" );
      ((Element)v.get(259)).setAttribute("border","0" );
      ((Element)v.get(259)).setAttribute("align","center" );
      ((Element)v.get(259)).setAttribute("cellspacing","0" );
      ((Element)v.get(259)).setAttribute("cellpadding","0" );
      ((Element)v.get(65)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(259)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("td"));
      ((Element)v.get(260)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
   }

   private void getXML1170(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(262)).setAttribute("src","b.gif" );
      ((Element)v.get(262)).setAttribute("width","8" );
      ((Element)v.get(262)).setAttribute("height","8" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */

      /* Empieza nodo:263 / Elemento padre: 260   */
      v.add(doc.createElement("td"));
      ((Element)v.get(260)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(264)).setAttribute("nombre","lblCondicionPromo" );
      ((Element)v.get(264)).setAttribute("alto","13" );
      ((Element)v.get(264)).setAttribute("filas","1" );
      ((Element)v.get(264)).setAttribute("valor","" );
      ((Element)v.get(264)).setAttribute("id","datosTitle" );
      ((Element)v.get(264)).setAttribute("cod","607" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */

      /* Empieza nodo:265 / Elemento padre: 260   */
      v.add(doc.createElement("td"));
      ((Element)v.get(260)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(266)).setAttribute("src","b.gif" );
      ((Element)v.get(266)).setAttribute("width","25" );
      ((Element)v.get(266)).setAttribute("height","8" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */

      /* Empieza nodo:267 / Elemento padre: 260   */
      v.add(doc.createElement("td"));
      ((Element)v.get(260)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(268)).setAttribute("nombre","lblTipoOferta" );
      ((Element)v.get(268)).setAttribute("alto","13" );
      ((Element)v.get(268)).setAttribute("filas","1" );
      ((Element)v.get(268)).setAttribute("valor","" );
      ((Element)v.get(268)).setAttribute("id","datosTitle" );
      ((Element)v.get(268)).setAttribute("cod","608" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */

      /* Empieza nodo:269 / Elemento padre: 260   */
      v.add(doc.createElement("td"));
      ((Element)v.get(260)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(270)).setAttribute("src","b.gif" );
      ((Element)v.get(270)).setAttribute("width","25" );
      ((Element)v.get(270)).setAttribute("height","8" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:269   */

      /* Empieza nodo:271 / Elemento padre: 260   */
      v.add(doc.createElement("td"));
      ((Element)v.get(260)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(272)).setAttribute("nombre","lblCicloVida" );
      ((Element)v.get(272)).setAttribute("alto","13" );
      ((Element)v.get(272)).setAttribute("filas","1" );
      ((Element)v.get(272)).setAttribute("valor","" );
      ((Element)v.get(272)).setAttribute("id","datosTitle" );
      ((Element)v.get(272)).setAttribute("cod","581" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:271   */

      /* Empieza nodo:273 / Elemento padre: 260   */
      v.add(doc.createElement("td"));
      ((Element)v.get(260)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(274)).setAttribute("src","b.gif" );
      ((Element)v.get(274)).setAttribute("width","25" );
      ((Element)v.get(274)).setAttribute("height","8" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */

      /* Empieza nodo:275 / Elemento padre: 260   */
      v.add(doc.createElement("td"));
      ((Element)v.get(260)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(276)).setAttribute("nombre","lblCentro" );
      ((Element)v.get(276)).setAttribute("alto","13" );
      ((Element)v.get(276)).setAttribute("filas","1" );
      ((Element)v.get(276)).setAttribute("valor","" );
      ((Element)v.get(276)).setAttribute("id","datosTitle" );
      ((Element)v.get(276)).setAttribute("cod","2119" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:277 / Elemento padre: 260   */
      v.add(doc.createElement("td"));
      ((Element)v.get(277)).setAttribute("width","100%" );
      ((Element)v.get(260)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(278)).setAttribute("src","b.gif" );
      ((Element)v.get(278)).setAttribute("width","8" );
      ((Element)v.get(278)).setAttribute("height","8" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */
      /* Termina nodo:260   */

      /* Empieza nodo:279 / Elemento padre: 259   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(259)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(281)).setAttribute("src","b.gif" );
      ((Element)v.get(281)).setAttribute("width","8" );
      ((Element)v.get(281)).setAttribute("height","8" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:280   */

      /* Empieza nodo:282 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(282)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(279)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(283)).setAttribute("nombre","cbCondicionPromo" );
      ((Element)v.get(283)).setAttribute("id","datosCampos" );
      ((Element)v.get(283)).setAttribute("size","1" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(283)).setAttribute("multiple","N" );
      ((Element)v.get(283)).setAttribute("req","N" );
      ((Element)v.get(283)).setAttribute("valorinicial","" );
      ((Element)v.get(283)).setAttribute("textoinicial","" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:285 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(286)).setAttribute("src","b.gif" );
      ((Element)v.get(286)).setAttribute("width","25" );
      ((Element)v.get(286)).setAttribute("height","8" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:285   */

      /* Empieza nodo:287 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(287)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(279)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(288)).setAttribute("nombre","cbTipoOferta" );
      ((Element)v.get(288)).setAttribute("id","datosCampos" );
      ((Element)v.get(288)).setAttribute("size","1" );
      ((Element)v.get(288)).setAttribute("multiple","N" );
      ((Element)v.get(288)).setAttribute("onchange","onChangeTipoOferta();" );
      ((Element)v.get(288)).setAttribute("req","S" );
      ((Element)v.get(288)).setAttribute("valorinicial","" );
      ((Element)v.get(288)).setAttribute("textoinicial","" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:288   */
      /* Termina nodo:287   */

      /* Empieza nodo:290 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(291)).setAttribute("src","b.gif" );
      ((Element)v.get(291)).setAttribute("width","25" );
      ((Element)v.get(291)).setAttribute("height","8" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */

      /* Empieza nodo:292 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(292)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(279)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(293)).setAttribute("nombre","cbCicloVida" );
      ((Element)v.get(293)).setAttribute("id","datosCampos" );
      ((Element)v.get(293)).setAttribute("size","1" );
      ((Element)v.get(293)).setAttribute("multiple","N" );
      ((Element)v.get(293)).setAttribute("req","S" );
      ((Element)v.get(293)).setAttribute("valorinicial","" );
      ((Element)v.get(293)).setAttribute("textoinicial","" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(293)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:295 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(296)).setAttribute("src","b.gif" );
      ((Element)v.get(296)).setAttribute("width","25" );
      ((Element)v.get(296)).setAttribute("height","8" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */

      /* Empieza nodo:297 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(297)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(279)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(298)).setAttribute("nombre","txtCentro" );
      ((Element)v.get(298)).setAttribute("id","datosCampos" );
      ((Element)v.get(298)).setAttribute("max","18" );
      ((Element)v.get(298)).setAttribute("tipo","" );
      ((Element)v.get(298)).setAttribute("onchange","" );
      ((Element)v.get(298)).setAttribute("req","N" );
      ((Element)v.get(298)).setAttribute("size","16" );
      ((Element)v.get(298)).setAttribute("valor","" );
      ((Element)v.get(298)).setAttribute("validacion","" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:299 / Elemento padre: 279   */
      v.add(doc.createElement("td"));
      ((Element)v.get(299)).setAttribute("width","100%" );
      ((Element)v.get(279)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(300)).setAttribute("src","b.gif" );
      ((Element)v.get(300)).setAttribute("width","8" );
      ((Element)v.get(300)).setAttribute("height","8" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */
      /* Termina nodo:299   */
      /* Termina nodo:279   */

      /* Empieza nodo:301 / Elemento padre: 259   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(259)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("td"));
      ((Element)v.get(302)).setAttribute("colspan","4" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(303)).setAttribute("src","b.gif" );
      ((Element)v.get(303)).setAttribute("width","8" );
      ((Element)v.get(303)).setAttribute("height","15" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:302   */
      /* Termina nodo:301   */
      /* Termina nodo:259   */

      /* Empieza nodo:304 / Elemento padre: 65   */
      v.add(doc.createElement("table"));
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(304)).setAttribute("width","100%" );
      ((Element)v.get(304)).setAttribute("align","center" );
      ((Element)v.get(304)).setAttribute("border","0" );
      ((Element)v.get(304)).setAttribute("cellspacing","0" );
      ((Element)v.get(304)).setAttribute("cellpadding","0" );
      ((Element)v.get(65)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(304)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("td"));
      ((Element)v.get(305)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(307)).setAttribute("src","b.gif" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:306   */

      /* Empieza nodo:308 / Elemento padre: 305   */
      v.add(doc.createElement("td"));
      ((Element)v.get(305)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(308)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(310)).setAttribute("class","legend" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(311)).setAttribute("nombre","lbldtProgramaFidelizacion" );
      ((Element)v.get(311)).setAttribute("alto","13" );
      ((Element)v.get(311)).setAttribute("filas","1" );
      ((Element)v.get(311)).setAttribute("valor","" );
      ((Element)v.get(311)).setAttribute("id","legend" );
      ((Element)v.get(311)).setAttribute("cod","3052" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:312 / Elemento padre: 309   */
      v.add(doc.createElement("table"));
      ((Element)v.get(312)).setAttribute("width","100%" );
      ((Element)v.get(312)).setAttribute("border","0" );
      ((Element)v.get(312)).setAttribute("align","center" );
      ((Element)v.get(312)).setAttribute("cellspacing","0" );
      ((Element)v.get(312)).setAttribute("cellpadding","0" );
      ((Element)v.get(309)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(312)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("td"));
      ((Element)v.get(313)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("table"));
      ((Element)v.get(315)).setAttribute("width","100%" );
      ((Element)v.get(315)).setAttribute("border","0" );
      ((Element)v.get(315)).setAttribute("align","left" );
      ((Element)v.get(315)).setAttribute("cellspacing","0" );
      ((Element)v.get(315)).setAttribute("cellpadding","0" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(315)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(317)).setAttribute("colspan","4" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(318)).setAttribute("src","b.gif" );
      ((Element)v.get(318)).setAttribute("width","8" );
      ((Element)v.get(318)).setAttribute("height","8" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:317   */
      /* Termina nodo:316   */

      /* Empieza nodo:319 / Elemento padre: 315   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(315)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("td"));
      ((Element)v.get(319)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(321)).setAttribute("src","b.gif" );
      ((Element)v.get(321)).setAttribute("width","8" );
      ((Element)v.get(321)).setAttribute("height","8" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:320   */

      /* Empieza nodo:322 / Elemento padre: 319   */
      v.add(doc.createElement("td"));
      ((Element)v.get(319)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(323)).setAttribute("nombre","lblProgramaFidelizacion" );
      ((Element)v.get(323)).setAttribute("alto","13" );
      ((Element)v.get(323)).setAttribute("filas","1" );
      ((Element)v.get(323)).setAttribute("valor","" );
      ((Element)v.get(323)).setAttribute("id","datosTitle" );
      ((Element)v.get(323)).setAttribute("cod","3052" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:324 / Elemento padre: 319   */
      v.add(doc.createElement("td"));
      ((Element)v.get(319)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(325)).setAttribute("src","b.gif" );
      ((Element)v.get(325)).setAttribute("width","25" );
      ((Element)v.get(325)).setAttribute("height","8" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:326 / Elemento padre: 319   */
      v.add(doc.createElement("td"));
      ((Element)v.get(319)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(327)).setAttribute("nombre","lblVariante" );
      ((Element)v.get(327)).setAttribute("alto","13" );
      ((Element)v.get(327)).setAttribute("filas","1" );
      ((Element)v.get(327)).setAttribute("valor","" );
      ((Element)v.get(327)).setAttribute("id","datosTitle" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(327)).setAttribute("cod","3053" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:326   */

      /* Empieza nodo:328 / Elemento padre: 319   */
      v.add(doc.createElement("td"));
      ((Element)v.get(319)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(329)).setAttribute("src","b.gif" );
      ((Element)v.get(329)).setAttribute("width","25" );
      ((Element)v.get(329)).setAttribute("height","8" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:328   */

      /* Empieza nodo:330 / Elemento padre: 319   */
      v.add(doc.createElement("td"));
      ((Element)v.get(319)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(331)).setAttribute("nombre","lblPuntoFijo" );
      ((Element)v.get(331)).setAttribute("alto","13" );
      ((Element)v.get(331)).setAttribute("filas","1" );
      ((Element)v.get(331)).setAttribute("valor","" );
      ((Element)v.get(331)).setAttribute("id","datosTitle" );
      ((Element)v.get(331)).setAttribute("cod","3054" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */

      /* Empieza nodo:332 / Elemento padre: 319   */
      v.add(doc.createElement("td"));
      ((Element)v.get(332)).setAttribute("width","100%" );
      ((Element)v.get(319)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(333)).setAttribute("src","b.gif" );
      ((Element)v.get(333)).setAttribute("width","8" );
      ((Element)v.get(333)).setAttribute("height","8" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */
      /* Termina nodo:332   */
      /* Termina nodo:319   */

      /* Empieza nodo:334 / Elemento padre: 315   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(315)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(334)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(336)).setAttribute("src","b.gif" );
      ((Element)v.get(336)).setAttribute("width","8" );
      ((Element)v.get(336)).setAttribute("height","8" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(337)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(334)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(338)).setAttribute("nombre","cbProgramaFidelizacion" );
      ((Element)v.get(338)).setAttribute("onchange","onChangeProgFide();" );
      ((Element)v.get(338)).setAttribute("id","datosCampos" );
      ((Element)v.get(338)).setAttribute("size","1" );
      ((Element)v.get(338)).setAttribute("multiple","N" );
      ((Element)v.get(338)).setAttribute("req","N" );
      ((Element)v.get(338)).setAttribute("valorinicial","" );
      ((Element)v.get(338)).setAttribute("textoinicial","" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(338)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */
      /* Termina nodo:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:340 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(334)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(341)).setAttribute("src","b.gif" );
      ((Element)v.get(341)).setAttribute("width","25" );
      ((Element)v.get(341)).setAttribute("height","8" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */
      /* Termina nodo:340   */

      /* Empieza nodo:342 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(342)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(334)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(343)).setAttribute("nombre","cbVariante" );
      ((Element)v.get(343)).setAttribute("id","datosCampos" );
      ((Element)v.get(343)).setAttribute("onchange","onChangeVariante();" );
      ((Element)v.get(343)).setAttribute("size","1" );
      ((Element)v.get(343)).setAttribute("multiple","N" );
      ((Element)v.get(343)).setAttribute("req","N" );
      ((Element)v.get(343)).setAttribute("valorinicial","" );
      ((Element)v.get(343)).setAttribute("textoinicial","" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:343   */
      /* Termina nodo:342   */

      /* Empieza nodo:345 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(334)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(346)).setAttribute("src","b.gif" );
      ((Element)v.get(346)).setAttribute("width","25" );
      ((Element)v.get(346)).setAttribute("height","8" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:345   */

      /* Empieza nodo:347 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(347)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(334)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(348)).setAttribute("nombre","txtPuntoFijo" );
      ((Element)v.get(348)).setAttribute("id","datosCampos" );
      ((Element)v.get(348)).setAttribute("max","3" );
      ((Element)v.get(348)).setAttribute("tipo","" );
      ((Element)v.get(348)).setAttribute("onchange","" );
      ((Element)v.get(348)).setAttribute("req","N" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(348)).setAttribute("size","3" );
      ((Element)v.get(348)).setAttribute("valor","" );
      ((Element)v.get(348)).setAttribute("validacion","" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:347   */

      /* Empieza nodo:349 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(349)).setAttribute("width","100%" );
      ((Element)v.get(334)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(350)).setAttribute("src","b.gif" );
      ((Element)v.get(350)).setAttribute("width","8" );
      ((Element)v.get(350)).setAttribute("height","8" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:349   */
      /* Termina nodo:334   */

      /* Empieza nodo:351 / Elemento padre: 315   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(315)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("td"));
      ((Element)v.get(352)).setAttribute("colspan","4" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(353)).setAttribute("src","b.gif" );
      ((Element)v.get(353)).setAttribute("width","8" );
      ((Element)v.get(353)).setAttribute("height","8" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */
      /* Termina nodo:352   */
      /* Termina nodo:351   */
      /* Termina nodo:315   */
      /* Termina nodo:314   */
      /* Termina nodo:313   */
      /* Termina nodo:312   */
      /* Termina nodo:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:354 / Elemento padre: 305   */
      v.add(doc.createElement("td"));
      ((Element)v.get(305)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(355)).setAttribute("src","b.gif" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */
      /* Termina nodo:354   */
      /* Termina nodo:305   */

      /* Empieza nodo:356 / Elemento padre: 304   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(304)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("td"));
      ((Element)v.get(357)).setAttribute("width","12" );
      ((Element)v.get(357)).setAttribute("align","center" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(358)).setAttribute("src","b.gif" );
      ((Element)v.get(358)).setAttribute("width","12" );
      ((Element)v.get(358)).setAttribute("height","12" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */
      /* Termina nodo:357   */

      /* Empieza nodo:359 / Elemento padre: 356   */
      v.add(doc.createElement("td"));
      ((Element)v.get(359)).setAttribute("width","756" );
      ((Element)v.get(356)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(360)).setAttribute("src","b.gif" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:359   */

      /* Empieza nodo:361 / Elemento padre: 356   */
      v.add(doc.createElement("td"));
      ((Element)v.get(361)).setAttribute("width","12" );
      ((Element)v.get(356)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(362)).setAttribute("src","b.gif" );
      ((Element)v.get(362)).setAttribute("width","12" );
      ((Element)v.get(362)).setAttribute("height","1" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:361   */
      /* Termina nodo:356   */
      /* Termina nodo:304   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:363 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(364)).setAttribute("src","b.gif" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */
      /* Termina nodo:363   */
      /* Termina nodo:61   */

      /* Empieza nodo:365 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("td"));
      ((Element)v.get(365)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(367)).setAttribute("src","b.gif" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */
      /* Termina nodo:366   */

      /* Empieza nodo:368 / Elemento padre: 365   */
      v.add(doc.createElement("td"));
      ((Element)v.get(365)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(368)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("table"));
      ((Element)v.get(370)).setAttribute("width","100%" );
      ((Element)v.get(370)).setAttribute("border","0" );
      ((Element)v.get(370)).setAttribute("align","center" );
      ((Element)v.get(370)).setAttribute("cellspacing","0" );
      ((Element)v.get(370)).setAttribute("cellpadding","0" );
      ((Element)v.get(369)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(370)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("td"));
      ((Element)v.get(372)).setAttribute("class","botonera" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(373)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(373)).setAttribute("ID","botonContenido" );
      ((Element)v.get(373)).setAttribute("tipo","html" );
      ((Element)v.get(373)).setAttribute("accion","guardar();" );
      ((Element)v.get(373)).setAttribute("estado","false" );
      ((Element)v.get(373)).setAttribute("cod","404" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */

      /* Empieza nodo:374 / Elemento padre: 372   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(374)).setAttribute("nombre","btnRangos" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(374)).setAttribute("ID","botonContenido" );
      ((Element)v.get(374)).setAttribute("tipo","html" );
      ((Element)v.get(374)).setAttribute("accion","accionCargarRangosPrecios();" );
      ((Element)v.get(374)).setAttribute("estado","false" );
      ((Element)v.get(374)).setAttribute("cod","3192" );
      ((Element)v.get(374)).setAttribute("ontab","goToFirstField()" );
      ((Element)v.get(372)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */
      /* Termina nodo:372   */
      /* Termina nodo:371   */
      /* Termina nodo:370   */
      /* Termina nodo:369   */
      /* Termina nodo:368   */

      /* Empieza nodo:375 / Elemento padre: 365   */
      v.add(doc.createElement("td"));
      ((Element)v.get(365)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(376)).setAttribute("src","b.gif" );
      ((Element)v.get(376)).setAttribute("width","8" );
      ((Element)v.get(376)).setAttribute("height","12" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */
      /* Termina nodo:375   */
      /* Termina nodo:365   */

      /* Empieza nodo:377 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("td"));
      ((Element)v.get(378)).setAttribute("width","12" );
      ((Element)v.get(378)).setAttribute("align","center" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(379)).setAttribute("src","b.gif" );
      ((Element)v.get(379)).setAttribute("width","12" );
      ((Element)v.get(379)).setAttribute("height","12" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */
      /* Termina nodo:378   */

      /* Empieza nodo:380 / Elemento padre: 377   */
      v.add(doc.createElement("td"));
      ((Element)v.get(380)).setAttribute("width","750" );
      ((Element)v.get(377)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(381)).setAttribute("src","b.gif" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */
      /* Termina nodo:380   */

      /* Empieza nodo:382 / Elemento padre: 377   */
      v.add(doc.createElement("td"));
      ((Element)v.get(382)).setAttribute("width","12" );
      ((Element)v.get(377)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(383)).setAttribute("src","b.gif" );
      ((Element)v.get(383)).setAttribute("width","12" );
      ((Element)v.get(383)).setAttribute("height","1" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */
      /* Termina nodo:382   */
      /* Termina nodo:377   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */
      /* Termina nodo:18   */


   }

}

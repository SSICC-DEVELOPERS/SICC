
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_productos_mantener_detalle_ranking  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML2250(doc);
         

      getXML2340(doc);
         

      getXML2430(doc);
         

      getXML2520(doc);
         

      getXML2610(doc);
         

      getXML2700(doc);
         

      getXML2790(doc);
         

      getXML2880(doc);
         

      getXML2970(doc);
         

      getXML3060(doc);
         

      getXML3150(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_productos_mantener_detalle" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","Crear concurso" );
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
      ((Element)v.get(2)).setAttribute("src","contenido_productos_mantener_detalle_ranking.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(3));

      /* Empieza nodo:4 / Elemento padre: 3   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(3)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(5)).setAttribute("name","cbMarcaProducto" );
      ((Element)v.get(5)).setAttribute("group","bloqueNegocio" );
      ((Element)v.get(5)).setAttribute("required","true" );
      ((Element)v.get(5)).setAttribute("cod","2448" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(6)).setAttribute("name","cbTipoOferta" );
      ((Element)v.get(6)).setAttribute("group","bloqueOferta" );
      ((Element)v.get(6)).setAttribute("required","true" );
      ((Element)v.get(6)).setAttribute("cod","608" );
      ((Element)v.get(4)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbCicloVida" );
      ((Element)v.get(7)).setAttribute("group","bloqueOferta" );
      ((Element)v.get(7)).setAttribute("required","false" );
      ((Element)v.get(7)).setAttribute("cod","581" );
      ((Element)v.get(4)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","txtCodProducto" );
      ((Element)v.get(8)).setAttribute("group","bloqueProducto" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","337" );
      ((Element)v.get(4)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbTipoOferta2" );
      ((Element)v.get(9)).setAttribute("group","bloqueProducto" );
      ((Element)v.get(9)).setAttribute("required","false" );
      ((Element)v.get(9)).setAttribute("cod","608" );
      ((Element)v.get(4)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbCicloVida2" );
      ((Element)v.get(10)).setAttribute("group","bloqueProducto" );
      ((Element)v.get(10)).setAttribute("required","false" );
      ((Element)v.get(10)).setAttribute("cod","581" );
      ((Element)v.get(4)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","txtMensaje" );
      ((Element)v.get(11)).setAttribute("group","txtMensaje" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","531" );
      ((Element)v.get(4)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","cbPeriodoDesde" );
      ((Element)v.get(12)).setAttribute("group","cbPeriodoDesde" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","1175" );
      ((Element)v.get(4)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","cbPeriodoHasta" );
      ((Element)v.get(13)).setAttribute("group","cbPeriodoHasta" );
      ((Element)v.get(13)).setAttribute("required","true" );
      ((Element)v.get(13)).setAttribute("cod","1176" );
      ((Element)v.get(4)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */
      /* Termina nodo:4   */
      /* Termina nodo:3   */

      /* Empieza nodo:14 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(14)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(14));

      /* Empieza nodo:15 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","accion" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(18)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","oidTipoProducto" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","descTipoProducto" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","camposDeshabilitados" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","datosObligatorios" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hcbMarcaProducto" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hcbUnidadNegocio" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hcbNegocio" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hcbSupergenerico" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hcbGenerico" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hcbTipoOferta" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hcbCicloVida" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hoidProducto" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","htxtCodigoProducto" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hcbPeriodoDesde" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hcbPeriodoHasta" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","htxtPuntosUnidad" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","htxtFactorMultiplicidad" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","htxtUnidadesExigidas" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","htxtMontoExigido" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","htxtPuntosExigidos" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","hlstProductos" );
      ((Element)v.get(40)).setAttribute("valor","" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(14)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","hchkComunicacion" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","htxtCodigoMensaje" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","oidTipoProductoValidos" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","oidTipoProductoExcluidos" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","oidCombo" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","descCombo" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","listadoAMostrar" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","hOidMarca" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 14   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(49)).setAttribute("nombre","capa" );
      ((Element)v.get(14)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("table"));
      ((Element)v.get(50)).setAttribute("width","100%" );
      ((Element)v.get(50)).setAttribute("border","0" );
      ((Element)v.get(50)).setAttribute("cellspacing","0" );
      ((Element)v.get(50)).setAttribute("cellpadding","0" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("width","12" );
      ((Element)v.get(52)).setAttribute("align","center" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","12" );
      ((Element)v.get(53)).setAttribute("height","12" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:54 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).setAttribute("width","750" );
      ((Element)v.get(51)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:56 / Elemento padre: 51   */
      v.add(doc.createElement("td"));
      ((Element)v.get(56)).setAttribute("width","12" );
      ((Element)v.get(51)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(57)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).setAttribute("width","12" );
      ((Element)v.get(57)).setAttribute("height","1" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:51   */

      /* Empieza nodo:58 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(63)).setAttribute("class","legend" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(64)).setAttribute("nombre","lblMantenerProductos" );
      ((Element)v.get(64)).setAttribute("alto","13" );
      ((Element)v.get(64)).setAttribute("filas","1" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(64)).setAttribute("id","legend" );
      ((Element)v.get(64)).setAttribute("cod","00333" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 62   */
      v.add(doc.createElement("table"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(65)).setAttribute("width","100%" );
      ((Element)v.get(65)).setAttribute("border","0" );
      ((Element)v.get(65)).setAttribute("align","center" );
      ((Element)v.get(65)).setAttribute("cellspacing","0" );
      ((Element)v.get(65)).setAttribute("cellpadding","0" );
      ((Element)v.get(62)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("table"));
      ((Element)v.get(68)).setAttribute("width","628" );
      ((Element)v.get(68)).setAttribute("border","0" );
      ((Element)v.get(68)).setAttribute("align","left" );
      ((Element)v.get(68)).setAttribute("cellspacing","0" );
      ((Element)v.get(68)).setAttribute("cellpadding","0" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

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
      ((Element)v.get(76)).setAttribute("nombre","lblProductos" );
      ((Element)v.get(76)).setAttribute("alto","13" );
      ((Element)v.get(76)).setAttribute("filas","1" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(76)).setAttribute("id","datosTitle" );
      ((Element)v.get(76)).setAttribute("cod","515" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 72   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("width","100%" );
      ((Element)v.get(72)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","8" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:72   */

      /* Empieza nodo:79 / Elemento padre: 68   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(68)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).setAttribute("width","8" );
      ((Element)v.get(81)).setAttribute("height","8" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(83)).setAttribute("nombre","lbldtProductos" );
      ((Element)v.get(83)).setAttribute("alto","13" );
      ((Element)v.get(83)).setAttribute("filas","1" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(83)).setAttribute("id","datosCampos" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).setAttribute("width","100%" );
      ((Element)v.get(79)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","8" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:79   */

      /* Empieza nodo:86 / Elemento padre: 68   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(68)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("td"));
      ((Element)v.get(87)).setAttribute("colspan","4" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","8" );
      ((Element)v.get(88)).setAttribute("height","8" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:89 / Elemento padre: 58   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(58)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(90)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:58   */

      /* Empieza nodo:91 / Elemento padre: 50   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(50)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).setAttribute("width","12" );
      ((Element)v.get(92)).setAttribute("align","center" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","12" );
      ((Element)v.get(93)).setAttribute("height","12" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("width","756" );
      ((Element)v.get(91)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("width","12" );
      ((Element)v.get(91)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","12" );
      ((Element)v.get(97)).setAttribute("height","1" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:91   */
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:98 / Elemento padre: 14   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(98)).setAttribute("nombre","capa1" );
      ((Element)v.get(98)).setAttribute("alto","100%" );
      ((Element)v.get(98)).setAttribute("ancho","100%" );
      ((Element)v.get(98)).setAttribute("colorf","" );
      ((Element)v.get(98)).setAttribute("borde","0" );
      ((Element)v.get(98)).setAttribute("imagenf","" );
      ((Element)v.get(98)).setAttribute("repeat","" );
      ((Element)v.get(98)).setAttribute("padding","" );
      ((Element)v.get(98)).setAttribute("visibilidad","visible" );
      ((Element)v.get(98)).setAttribute("contravsb","" );
      ((Element)v.get(98)).setAttribute("x","0" );
      ((Element)v.get(98)).setAttribute("y","71" );
      ((Element)v.get(98)).setAttribute("zindex","" );
      ((Element)v.get(14)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("table"));
      ((Element)v.get(99)).setAttribute("width","100%" );
      ((Element)v.get(99)).setAttribute("border","0" );
      ((Element)v.get(99)).setAttribute("cellspacing","0" );
      ((Element)v.get(99)).setAttribute("cellpadding","0" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).setAttribute("width","12" );
      ((Element)v.get(101)).setAttribute("align","center" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).setAttribute("width","12" );
      ((Element)v.get(102)).setAttribute("height","12" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(103)).setAttribute("width","750" );
      ((Element)v.get(100)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 100   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).setAttribute("width","12" );
      ((Element)v.get(100)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","12" );
      ((Element)v.get(106)).setAttribute("height","1" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:100   */

      /* Empieza nodo:107 / Elemento padre: 99   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(99)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("table"));
      ((Element)v.get(112)).setAttribute("width","100%" );
      ((Element)v.get(112)).setAttribute("border","0" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(112)).setAttribute("align","center" );
      ((Element)v.get(112)).setAttribute("cellspacing","0" );
      ((Element)v.get(112)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).setAttribute("colspan","3" );
      ((Element)v.get(114)).setAttribute("bgcolor","#E5E5E5" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("table"));
      ((Element)v.get(115)).setAttribute("width","100%" );
      ((Element)v.get(115)).setAttribute("border","0" );
      ((Element)v.get(115)).setAttribute("align","center" );
      ((Element)v.get(115)).setAttribute("cellspacing","0" );
      ((Element)v.get(115)).setAttribute("cellpadding","0" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("table"));
      ((Element)v.get(118)).setAttribute("width","100%" );
      ((Element)v.get(118)).setAttribute("height","100%" );
      ((Element)v.get(118)).setAttribute("border","0" );
      ((Element)v.get(118)).setAttribute("align","center" );
      ((Element)v.get(118)).setAttribute("cellpadding","0" );
      ((Element)v.get(118)).setAttribute("cellspacing","0" );
      ((Element)v.get(118)).setAttribute("class","menu4" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).setAttribute("width","12" );
      ((Element)v.get(120)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(120)).setAttribute("class","menu5texto" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","12" );
      ((Element)v.get(121)).setAttribute("height","30" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(122)).setAttribute("class","menu5texto" );
      ((Element)v.get(119)).appendChild((Element)v.get(122));

      /* Elemento padre:122 / Elemento actual: 123   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(122)).appendChild((Text)v.get(123));

      /* Termina nodo Texto:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).setAttribute("width","10" );
      ((Element)v.get(124)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(124)).setAttribute("class","menu5texto" );
      ((Element)v.get(119)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).setAttribute("width","10" );
      ((Element)v.get(125)).setAttribute("height","8" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:126 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).setAttribute("width","75" );
      ((Element)v.get(126)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(126)).setAttribute("class","menu5texto" );
      ((Element)v.get(119)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("table"));
      ((Element)v.get(127)).setAttribute("id","tabla1" );
      ((Element)v.get(127)).setAttribute("width","75" );
      ((Element)v.get(127)).setAttribute("border","0" );
      ((Element)v.get(127)).setAttribute("align","center" );
      ((Element)v.get(127)).setAttribute("cellpadding","1" );
      ((Element)v.get(127)).setAttribute("cellspacing","0" );
      ((Element)v.get(127)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(128)).setAttribute("align","center" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("id","celda1" );
      ((Element)v.get(129)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(129)).setAttribute("onmouseover","mouseOver('celda1');" );
      ((Element)v.get(129)).setAttribute("onclick","cambiaPestanya(1);" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(130)).setAttribute("id","lblpBloqueNegocio" );
      ((Element)v.get(130)).setAttribute("style","font-family: Arial, Helvetica, sans-serif; font-size: 11px; font-weight: bold; color: #000000; text-align: center; clip:  rect();" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:131 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).setAttribute("width","10" );
      ((Element)v.get(131)).setAttribute("class","menu5texto" );
      ((Element)v.get(119)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(132)).setAttribute("width","10" );
      ((Element)v.get(132)).setAttribute("height","8" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(133)).setAttribute("width","20" );
      ((Element)v.get(133)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(133)).setAttribute("class","menu5texto" );
      ((Element)v.get(119)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("table"));
      ((Element)v.get(134)).setAttribute("id","tabla2" );
      ((Element)v.get(134)).setAttribute("width","75" );
      ((Element)v.get(134)).setAttribute("border","0" );
      ((Element)v.get(134)).setAttribute("align","center" );
      ((Element)v.get(134)).setAttribute("cellpadding","1" );
      ((Element)v.get(134)).setAttribute("cellspacing","0" );
      ((Element)v.get(134)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(135)).setAttribute("align","center" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).setAttribute("id","celda2" );
      ((Element)v.get(136)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(136)).setAttribute("onmouseover","mouseOver('celda2');" );
      ((Element)v.get(136)).setAttribute("onclick","cambiaPestanya(2);" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(137)).setAttribute("id","lblpBloqueOferta" );
      ((Element)v.get(137)).setAttribute("style","font-family: Arial, Helvetica, sans-serif; font-size: 11px; font-weight: bold; color: #000000; text-align: center; clip:  rect();" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:138 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).setAttribute("width","10" );
      ((Element)v.get(138)).setAttribute("class","menu5texto" );
      ((Element)v.get(119)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).setAttribute("width","10" );
      ((Element)v.get(139)).setAttribute("height","8" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("width","20" );
      ((Element)v.get(140)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(140)).setAttribute("class","menu5texto" );
      ((Element)v.get(119)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("table"));
      ((Element)v.get(141)).setAttribute("id","tabla3" );
      ((Element)v.get(141)).setAttribute("width","75" );
      ((Element)v.get(141)).setAttribute("border","0" );
      ((Element)v.get(141)).setAttribute("align","center" );
      ((Element)v.get(141)).setAttribute("cellpadding","1" );
      ((Element)v.get(141)).setAttribute("cellspacing","0" );
      ((Element)v.get(141)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(142)).setAttribute("align","center" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).setAttribute("id","celda3" );
      ((Element)v.get(143)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(143)).setAttribute("onmouseover","mouseOver('celda3');" );
      ((Element)v.get(143)).setAttribute("onclick","cambiaPestanya(3);" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(144)).setAttribute("id","lblpBloqueProducto" );
      ((Element)v.get(144)).setAttribute("style","font-family: Arial, Helvetica, sans-serif; font-size: 11px; font-weight: bold; color: #000000; text-align: center; clip:  rect(   );" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:145 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).setAttribute("width","16" );
      ((Element)v.get(145)).setAttribute("class","menu5texto" );
      ((Element)v.get(119)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","12" );
      ((Element)v.get(146)).setAttribute("height","8" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:147 / Elemento padre: 112   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(112)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).setAttribute("width","12" );
      ((Element)v.get(148)).setAttribute("align","center" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","12" );
      ((Element)v.get(149)).setAttribute("height","158" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).setAttribute("width","756" );
      ((Element)v.get(147)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).setAttribute("width","12" );
      ((Element)v.get(147)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","12" );
      ((Element)v.get(153)).setAttribute("height","1" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:147   */

      /* Empieza nodo:154 / Elemento padre: 112   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(112)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(159)).setAttribute("class","legend" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(160)).setAttribute("nombre","lblDatosAsociados" );
      ((Element)v.get(160)).setAttribute("alto","13" );
      ((Element)v.get(160)).setAttribute("filas","1" );
      ((Element)v.get(160)).setAttribute("valor","" );
      ((Element)v.get(160)).setAttribute("id","legend" );
      ((Element)v.get(160)).setAttribute("cod","00364" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 158   */
      v.add(doc.createElement("table"));
      ((Element)v.get(161)).setAttribute("width","100%" );
      ((Element)v.get(161)).setAttribute("border","0" );
      ((Element)v.get(161)).setAttribute("align","center" );
      ((Element)v.get(161)).setAttribute("cellspacing","0" );
      ((Element)v.get(161)).setAttribute("cellpadding","0" );
      ((Element)v.get(158)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("table"));
      ((Element)v.get(164)).setAttribute("width","600" );
      ((Element)v.get(164)).setAttribute("border","0" );
      ((Element)v.get(164)).setAttribute("align","left" );
      ((Element)v.get(164)).setAttribute("cellspacing","0" );
      ((Element)v.get(164)).setAttribute("cellpadding","0" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).setAttribute("colspan","4" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).setAttribute("width","8" );
      ((Element)v.get(167)).setAttribute("height","8" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:168 / Elemento padre: 164   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(164)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).setAttribute("width","8" );
      ((Element)v.get(170)).setAttribute("height","8" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 168   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(172)).setAttribute("nombre","lblPeridoDesde" );
      ((Element)v.get(172)).setAttribute("alto","13" );
      ((Element)v.get(172)).setAttribute("filas","1" );
      ((Element)v.get(172)).setAttribute("valor","" );
      ((Element)v.get(172)).setAttribute("id","datosTitle" );
      ((Element)v.get(172)).setAttribute("cod","1175" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 168   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).setAttribute("width","25" );
      ((Element)v.get(174)).setAttribute("height","8" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 168   */
      v.add(doc.createElement("td"));
      ((Element)v.get(168)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(176)).setAttribute("nombre","lblPeridoHasta" );
      ((Element)v.get(176)).setAttribute("alto","13" );
      ((Element)v.get(176)).setAttribute("filas","1" );
      ((Element)v.get(176)).setAttribute("valor","" );
      ((Element)v.get(176)).setAttribute("id","datosTitle" );
      ((Element)v.get(176)).setAttribute("cod","1176" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 168   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).setAttribute("width","100%" );
      ((Element)v.get(168)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(178)).setAttribute("src","b.gif" );
      ((Element)v.get(178)).setAttribute("width","8" );
      ((Element)v.get(178)).setAttribute("height","8" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:168   */

      /* Empieza nodo:179 / Elemento padre: 164   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(164)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).setAttribute("width","8" );
      ((Element)v.get(181)).setAttribute("height","8" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(179)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(183)).setAttribute("nombre","cbPeriodoDesde" );
      ((Element)v.get(183)).setAttribute("id","datosCampos" );
      ((Element)v.get(183)).setAttribute("onshtab","shTabPeriodoDesde();" );
      ((Element)v.get(183)).setAttribute("size","1" );
      ((Element)v.get(183)).setAttribute("multiple","N" );
      ((Element)v.get(183)).setAttribute("req","N" );
      ((Element)v.get(183)).setAttribute("valorinicial","" );
      ((Element)v.get(183)).setAttribute("textoinicial","" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:185 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).setAttribute("width","25" );
      ((Element)v.get(186)).setAttribute("height","8" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 179   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(179)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(188)).setAttribute("nombre","cbPeriodoHasta" );
      ((Element)v.get(188)).setAttribute("id","datosCampos" );
      ((Element)v.get(188)).setAttribute("size","1" );
      ((Element)v.get(188)).setAttribute("multiple","N" );
      ((Element)v.get(188)).setAttribute("req","N" );
      ((Element)v.get(188)).setAttribute("valorinicial","" );
      ((Element)v.get(188)).setAttribute("textoinicial","" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */
      /* Termina nodo:187   */
      /* Termina nodo:179   */

      /* Empieza nodo:190 / Elemento padre: 164   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(164)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).setAttribute("colspan","4" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(192)).setAttribute("src","b.gif" );
      ((Element)v.get(192)).setAttribute("width","8" );
      ((Element)v.get(192)).setAttribute("height","8" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:190   */
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:193 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(194)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:154   */

      /* Empieza nodo:195 / Elemento padre: 112   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(112)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(196)).setAttribute("width","12" );
      ((Element)v.get(196)).setAttribute("align","center" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(197)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).setAttribute("width","12" );
      ((Element)v.get(197)).setAttribute("height","12" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).setAttribute("width","756" );
      ((Element)v.get(195)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(199)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(200)).setAttribute("width","12" );
      ((Element)v.get(195)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).setAttribute("width","12" );
      ((Element)v.get(201)).setAttribute("height","1" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */
      /* Termina nodo:195   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:202 / Elemento padre: 107   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(203)).setAttribute("src","b.gif" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */
      /* Termina nodo:107   */

      /* Empieza nodo:204 / Elemento padre: 99   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(99)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(204)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:207 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(204)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("table"));
      ((Element)v.get(209)).setAttribute("width","100%" );
      ((Element)v.get(209)).setAttribute("border","0" );
      ((Element)v.get(209)).setAttribute("align","center" );
      ((Element)v.get(209)).setAttribute("cellspacing","0" );
      ((Element)v.get(209)).setAttribute("cellpadding","0" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(209)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).setAttribute("class","botonera" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(212)).setAttribute("nombre","btnAnadir1" );
      ((Element)v.get(212)).setAttribute("ID","botonContenido" );
      ((Element)v.get(212)).setAttribute("tipo","html" );
      ((Element)v.get(212)).setAttribute("ontab","focaliza('formulario.ckComunicacion');" );
      ((Element)v.get(212)).setAttribute("accion","accionAniadir();" );
      ((Element)v.get(212)).setAttribute("estado","false" );
      ((Element)v.get(212)).setAttribute("cod","404" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:213 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(204)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(214)).setAttribute("src","b.gif" );
      ((Element)v.get(214)).setAttribute("width","8" );
      ((Element)v.get(214)).setAttribute("height","12" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */
      /* Termina nodo:204   */

      /* Empieza nodo:215 / Elemento padre: 99   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(99)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).setAttribute("width","12" );
      ((Element)v.get(216)).setAttribute("align","center" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(217)).setAttribute("src","b.gif" );
      ((Element)v.get(217)).setAttribute("width","12" );
      ((Element)v.get(217)).setAttribute("height","12" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:218 / Elemento padre: 215   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).setAttribute("width","756" );
      ((Element)v.get(215)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 215   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).setAttribute("width","12" );
      ((Element)v.get(215)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(221)).setAttribute("src","b.gif" );
      ((Element)v.get(221)).setAttribute("width","12" );
      ((Element)v.get(221)).setAttribute("height","1" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */
      /* Termina nodo:215   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:222 / Elemento padre: 14   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(222)).setAttribute("nombre","capa2" );
      ((Element)v.get(222)).setAttribute("alto","200" );
      ((Element)v.get(222)).setAttribute("ancho","100%" );
      ((Element)v.get(222)).setAttribute("colorf","" );
      ((Element)v.get(222)).setAttribute("borde","0" );
      ((Element)v.get(222)).setAttribute("imagenf","" );
      ((Element)v.get(222)).setAttribute("repeat","" );
      ((Element)v.get(222)).setAttribute("padding","" );
      ((Element)v.get(222)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(222)).setAttribute("contravsb","" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(222)).setAttribute("x","0" );
      ((Element)v.get(222)).setAttribute("y","109" );
      ((Element)v.get(222)).setAttribute("zindex","" );
      ((Element)v.get(14)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("table"));
      ((Element)v.get(223)).setAttribute("width","100%" );
      ((Element)v.get(223)).setAttribute("border","0" );
      ((Element)v.get(223)).setAttribute("cellspacing","0" );
      ((Element)v.get(223)).setAttribute("cellpadding","0" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(223)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).setAttribute("width","12" );
      ((Element)v.get(225)).setAttribute("align","center" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(226)).setAttribute("src","b.gif" );
      ((Element)v.get(226)).setAttribute("width","25" );
      ((Element)v.get(226)).setAttribute("height","12" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:227 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(227)).setAttribute("width","750" );
      ((Element)v.get(224)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(228)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:229 / Elemento padre: 224   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).setAttribute("width","12" );
      ((Element)v.get(224)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(230)).setAttribute("width","26" );
      ((Element)v.get(230)).setAttribute("height","1" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */
      /* Termina nodo:224   */

      /* Empieza nodo:231 / Elemento padre: 223   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(223)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(233)).setAttribute("src","b.gif" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:234 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(236)).setAttribute("class","legend" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(237)).setAttribute("nombre","lblBloqueNegocio" );
      ((Element)v.get(237)).setAttribute("alto","13" );
      ((Element)v.get(237)).setAttribute("filas","1" );
      ((Element)v.get(237)).setAttribute("valor","" );
      ((Element)v.get(237)).setAttribute("id","legend" );
      ((Element)v.get(237)).setAttribute("cod","00335" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:238 / Elemento padre: 235   */
      v.add(doc.createElement("table"));
      ((Element)v.get(238)).setAttribute("width","100%" );
      ((Element)v.get(238)).setAttribute("border","0" );
      ((Element)v.get(238)).setAttribute("align","center" );
      ((Element)v.get(238)).setAttribute("cellspacing","0" );
      ((Element)v.get(238)).setAttribute("cellpadding","0" );
      ((Element)v.get(235)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("table"));
      ((Element)v.get(241)).setAttribute("width","600" );
      ((Element)v.get(241)).setAttribute("border","0" );
      ((Element)v.get(241)).setAttribute("align","left" );
      ((Element)v.get(241)).setAttribute("cellspacing","0" );
      ((Element)v.get(241)).setAttribute("cellpadding","0" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).setAttribute("colspan","4" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(244)).setAttribute("src","b.gif" );
      ((Element)v.get(244)).setAttribute("width","8" );
      ((Element)v.get(244)).setAttribute("height","8" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:245 / Elemento padre: 241   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(241)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("td"));
      ((Element)v.get(245)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML990(Document doc) {
      ((Element)v.get(247)).setAttribute("src","b.gif" );
      ((Element)v.get(247)).setAttribute("width","8" );
      ((Element)v.get(247)).setAttribute("height","8" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:248 / Elemento padre: 245   */
      v.add(doc.createElement("td"));
      ((Element)v.get(245)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(249)).setAttribute("nombre","lblMarcaProducto" );
      ((Element)v.get(249)).setAttribute("alto","13" );
      ((Element)v.get(249)).setAttribute("filas","1" );
      ((Element)v.get(249)).setAttribute("valor","" );
      ((Element)v.get(249)).setAttribute("id","datosTitle" );
      ((Element)v.get(249)).setAttribute("cod","2448" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:250 / Elemento padre: 245   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).setAttribute("width","100%" );
      ((Element)v.get(245)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(251)).setAttribute("src","b.gif" );
      ((Element)v.get(251)).setAttribute("width","8" );
      ((Element)v.get(251)).setAttribute("height","8" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */
      /* Termina nodo:245   */

      /* Empieza nodo:252 / Elemento padre: 241   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(241)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(252)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(254)).setAttribute("src","b.gif" );
      ((Element)v.get(254)).setAttribute("width","8" );
      ((Element)v.get(254)).setAttribute("height","8" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:255 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(255)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(252)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(256)).setAttribute("nombre","cbMarcaProducto" );
      ((Element)v.get(256)).setAttribute("id","datosCampos" );
      ((Element)v.get(256)).setAttribute("size","1" );
      ((Element)v.get(256)).setAttribute("onshtab","focalizaAceptar();" );
      ((Element)v.get(256)).setAttribute("multiple","N" );
      ((Element)v.get(256)).setAttribute("req","S" );
      ((Element)v.get(256)).setAttribute("valorinicial","" );
      ((Element)v.get(256)).setAttribute("textoinicial","" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:258 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(258)).setAttribute("width","100%" );
      ((Element)v.get(252)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(259)).setAttribute("src","b.gif" );
      ((Element)v.get(259)).setAttribute("width","8" );
      ((Element)v.get(259)).setAttribute("height","8" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */
      /* Termina nodo:252   */

      /* Empieza nodo:260 / Elemento padre: 241   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(241)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).setAttribute("colspan","4" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(262)).setAttribute("src","b.gif" );
      ((Element)v.get(262)).setAttribute("width","8" );
      ((Element)v.get(262)).setAttribute("height","8" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */
      /* Termina nodo:260   */
      /* Termina nodo:241   */
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:263 / Elemento padre: 238   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(238)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
      ((Element)v.get(263)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("table"));
      ((Element)v.get(265)).setAttribute("width","600" );
      ((Element)v.get(265)).setAttribute("border","0" );
      ((Element)v.get(265)).setAttribute("align","left" );
      ((Element)v.get(265)).setAttribute("cellspacing","0" );
      ((Element)v.get(265)).setAttribute("cellpadding","0" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(265)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(268)).setAttribute("src","b.gif" );
      ((Element)v.get(268)).setAttribute("width","8" );
      ((Element)v.get(268)).setAttribute("height","8" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */

      /* Empieza nodo:269 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(270)).setAttribute("nombre","lblUnidadNegocio" );
      ((Element)v.get(270)).setAttribute("alto","13" );
      ((Element)v.get(270)).setAttribute("filas","1" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(270)).setAttribute("valor","" );
      ((Element)v.get(270)).setAttribute("id","datosTitle" );
      ((Element)v.get(270)).setAttribute("cod","1338" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:269   */

      /* Empieza nodo:271 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(272)).setAttribute("src","b.gif" );
      ((Element)v.get(272)).setAttribute("width","25" );
      ((Element)v.get(272)).setAttribute("height","8" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:271   */

      /* Empieza nodo:273 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(274)).setAttribute("nombre","lblNegocio" );
      ((Element)v.get(274)).setAttribute("alto","13" );
      ((Element)v.get(274)).setAttribute("filas","1" );
      ((Element)v.get(274)).setAttribute("valor","" );
      ((Element)v.get(274)).setAttribute("id","datosTitle" );
      ((Element)v.get(274)).setAttribute("cod","588" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */

      /* Empieza nodo:275 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).setAttribute("width","100%" );
      ((Element)v.get(266)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(276)).setAttribute("src","b.gif" );
      ((Element)v.get(276)).setAttribute("width","8" );
      ((Element)v.get(276)).setAttribute("height","8" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */
      /* Termina nodo:266   */

      /* Empieza nodo:277 / Elemento padre: 265   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(265)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("td"));
      ((Element)v.get(277)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(279)).setAttribute("src","b.gif" );
      ((Element)v.get(279)).setAttribute("width","8" );
      ((Element)v.get(279)).setAttribute("height","8" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */

      /* Empieza nodo:280 / Elemento padre: 277   */
      v.add(doc.createElement("td"));
      ((Element)v.get(280)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(277)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(281)).setAttribute("nombre","cbUnidadNegocio" );
      ((Element)v.get(281)).setAttribute("id","datosCampos" );
      ((Element)v.get(281)).setAttribute("size","1" );
      ((Element)v.get(281)).setAttribute("multiple","N" );
      ((Element)v.get(281)).setAttribute("req","N" );
      ((Element)v.get(281)).setAttribute("valorinicial","" );
      ((Element)v.get(281)).setAttribute("textoinicial","" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */
      /* Termina nodo:280   */

      /* Empieza nodo:283 / Elemento padre: 277   */
      v.add(doc.createElement("td"));
      ((Element)v.get(277)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(284)).setAttribute("src","b.gif" );
      ((Element)v.get(284)).setAttribute("width","25" );
      ((Element)v.get(284)).setAttribute("height","8" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:285 / Elemento padre: 277   */
      v.add(doc.createElement("td"));
      ((Element)v.get(285)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(277)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(286)).setAttribute("nombre","cbNegocio" );
      ((Element)v.get(286)).setAttribute("id","datosCampos" );
      ((Element)v.get(286)).setAttribute("size","1" );
      ((Element)v.get(286)).setAttribute("multiple","N" );
      ((Element)v.get(286)).setAttribute("req","N" );
      ((Element)v.get(286)).setAttribute("valorinicial","" );
      ((Element)v.get(286)).setAttribute("textoinicial","" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:286   */
      /* Termina nodo:285   */

      /* Empieza nodo:288 / Elemento padre: 277   */
      v.add(doc.createElement("td"));
      ((Element)v.get(288)).setAttribute("width","100%" );
      ((Element)v.get(277)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(289)).setAttribute("src","b.gif" );
      ((Element)v.get(289)).setAttribute("width","8" );
      ((Element)v.get(289)).setAttribute("height","8" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:288   */
      /* Termina nodo:277   */

      /* Empieza nodo:290 / Elemento padre: 265   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(265)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("td"));
      ((Element)v.get(291)).setAttribute("colspan","4" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(292)).setAttribute("src","b.gif" );
      ((Element)v.get(292)).setAttribute("width","8" );
      ((Element)v.get(292)).setAttribute("height","8" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:291   */
      /* Termina nodo:290   */
      /* Termina nodo:265   */
      /* Termina nodo:264   */
      /* Termina nodo:263   */

      /* Empieza nodo:293 / Elemento padre: 238   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(238)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(293)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("table"));
      ((Element)v.get(295)).setAttribute("width","600" );
      ((Element)v.get(295)).setAttribute("border","0" );
      ((Element)v.get(295)).setAttribute("align","left" );
      ((Element)v.get(295)).setAttribute("cellspacing","0" );
      ((Element)v.get(295)).setAttribute("cellpadding","0" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(295)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("td"));
      ((Element)v.get(296)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(298)).setAttribute("src","b.gif" );
      ((Element)v.get(298)).setAttribute("width","8" );
      ((Element)v.get(298)).setAttribute("height","8" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:299 / Elemento padre: 296   */
      v.add(doc.createElement("td"));
      ((Element)v.get(296)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(300)).setAttribute("nombre","lblSupergenerico" );
      ((Element)v.get(300)).setAttribute("alto","13" );
      ((Element)v.get(300)).setAttribute("filas","1" );
      ((Element)v.get(300)).setAttribute("valor","" );
      ((Element)v.get(300)).setAttribute("id","datosTitle" );
      ((Element)v.get(300)).setAttribute("cod","590" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */
      /* Termina nodo:299   */

      /* Empieza nodo:301 / Elemento padre: 296   */
      v.add(doc.createElement("td"));
      ((Element)v.get(296)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(302)).setAttribute("src","b.gif" );
      ((Element)v.get(302)).setAttribute("width","25" );
      ((Element)v.get(302)).setAttribute("height","8" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:303 / Elemento padre: 296   */
      v.add(doc.createElement("td"));
      ((Element)v.get(296)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(304)).setAttribute("nombre","lblGenerico" );
      ((Element)v.get(304)).setAttribute("alto","13" );
      ((Element)v.get(304)).setAttribute("filas","1" );
      ((Element)v.get(304)).setAttribute("valor","" );
      ((Element)v.get(304)).setAttribute("id","datosTitle" );
      ((Element)v.get(304)).setAttribute("cod","589" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */

      /* Empieza nodo:305 / Elemento padre: 296   */
      v.add(doc.createElement("td"));
      ((Element)v.get(305)).setAttribute("width","100%" );
      ((Element)v.get(296)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(306)).setAttribute("src","b.gif" );
      ((Element)v.get(306)).setAttribute("width","8" );
      ((Element)v.get(306)).setAttribute("height","8" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */
      /* Termina nodo:296   */

      /* Empieza nodo:307 / Elemento padre: 295   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(295)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("td"));
      ((Element)v.get(307)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(309)).setAttribute("src","b.gif" );
      ((Element)v.get(309)).setAttribute("width","8" );
      ((Element)v.get(309)).setAttribute("height","8" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:310 / Elemento padre: 307   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(307)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(311)).setAttribute("nombre","cbSupergenerico" );
      ((Element)v.get(311)).setAttribute("id","datosCampos" );
      ((Element)v.get(311)).setAttribute("size","1" );
      ((Element)v.get(311)).setAttribute("multiple","N" );
      ((Element)v.get(311)).setAttribute("req","N" );
      ((Element)v.get(311)).setAttribute("valorinicial","" );
      ((Element)v.get(311)).setAttribute("textoinicial","" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:313 / Elemento padre: 307   */
      v.add(doc.createElement("td"));
      ((Element)v.get(307)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(314)).setAttribute("src","b.gif" );
      ((Element)v.get(314)).setAttribute("width","25" );
      ((Element)v.get(314)).setAttribute("height","8" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */

      /* Empieza nodo:315 / Elemento padre: 307   */
      v.add(doc.createElement("td"));
      ((Element)v.get(315)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(307)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("COMBO"));
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(316)).setAttribute("nombre","cbGenerico" );
      ((Element)v.get(316)).setAttribute("id","datosCampos" );
      ((Element)v.get(316)).setAttribute("size","1" );
      ((Element)v.get(316)).setAttribute("multiple","N" );
      ((Element)v.get(316)).setAttribute("req","N" );
      ((Element)v.get(316)).setAttribute("ontab","tabDatosAsociados();" );
      ((Element)v.get(316)).setAttribute("valorinicial","" );
      ((Element)v.get(316)).setAttribute("textoinicial","" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:318 / Elemento padre: 307   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).setAttribute("width","100%" );
      ((Element)v.get(307)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(319)).setAttribute("src","b.gif" );
      ((Element)v.get(319)).setAttribute("width","8" );
      ((Element)v.get(319)).setAttribute("height","8" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */
      /* Termina nodo:318   */
      /* Termina nodo:307   */

      /* Empieza nodo:320 / Elemento padre: 295   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(295)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("td"));
      ((Element)v.get(321)).setAttribute("colspan","4" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(322)).setAttribute("src","b.gif" );
      ((Element)v.get(322)).setAttribute("width","8" );
      ((Element)v.get(322)).setAttribute("height","8" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */
      /* Termina nodo:321   */
      /* Termina nodo:320   */
      /* Termina nodo:295   */
      /* Termina nodo:294   */
      /* Termina nodo:293   */
      /* Termina nodo:238   */
      /* Termina nodo:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:323 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(324)).setAttribute("src","b.gif" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */
      /* Termina nodo:323   */
      /* Termina nodo:231   */

      /* Empieza nodo:325 / Elemento padre: 223   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(223)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).setAttribute("width","12" );
      ((Element)v.get(326)).setAttribute("align","center" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(327)).setAttribute("src","b.gif" );
      ((Element)v.get(327)).setAttribute("width","12" );
      ((Element)v.get(327)).setAttribute("height","12" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:326   */

      /* Empieza nodo:328 / Elemento padre: 325   */
      v.add(doc.createElement("td"));
      ((Element)v.get(328)).setAttribute("width","756" );
      ((Element)v.get(325)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(329)).setAttribute("src","b.gif" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:328   */

      /* Empieza nodo:330 / Elemento padre: 325   */
      v.add(doc.createElement("td"));
      ((Element)v.get(330)).setAttribute("width","12" );
      ((Element)v.get(325)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(331)).setAttribute("src","b.gif" );
      ((Element)v.get(331)).setAttribute("width","12" );
      ((Element)v.get(331)).setAttribute("height","1" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */
      /* Termina nodo:325   */
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:332 / Elemento padre: 14   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(332)).setAttribute("nombre","capa3" );
      ((Element)v.get(332)).setAttribute("alto","200" );
      ((Element)v.get(332)).setAttribute("ancho","100%" );
      ((Element)v.get(332)).setAttribute("colorf","" );
      ((Element)v.get(332)).setAttribute("borde","0" );
      ((Element)v.get(332)).setAttribute("imagenf","" );
      ((Element)v.get(332)).setAttribute("repeat","" );
      ((Element)v.get(332)).setAttribute("padding","" );
      ((Element)v.get(332)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(332)).setAttribute("contravsb","" );
      ((Element)v.get(332)).setAttribute("x","0" );
      ((Element)v.get(332)).setAttribute("y","109" );
      ((Element)v.get(332)).setAttribute("zindex","" );
      ((Element)v.get(14)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("table"));
      ((Element)v.get(333)).setAttribute("width","100%" );
      ((Element)v.get(333)).setAttribute("border","0" );
      ((Element)v.get(333)).setAttribute("cellspacing","0" );
      ((Element)v.get(333)).setAttribute("cellpadding","0" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(333)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(335)).setAttribute("width","12" );
      ((Element)v.get(335)).setAttribute("align","center" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(336)).setAttribute("src","b.gif" );
      ((Element)v.get(336)).setAttribute("width","25" );
      ((Element)v.get(336)).setAttribute("height","12" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(337)).setAttribute("width","750" );
      ((Element)v.get(334)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(338)).setAttribute("src","b.gif" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:339 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).setAttribute("width","12" );
      ((Element)v.get(334)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(340)).setAttribute("src","b.gif" );
      ((Element)v.get(340)).setAttribute("width","26" );
      ((Element)v.get(340)).setAttribute("height","1" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */
      /* Termina nodo:334   */

      /* Empieza nodo:341 / Elemento padre: 333   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(333)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(343)).setAttribute("src","b.gif" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */
      /* Termina nodo:342   */

      /* Empieza nodo:344 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(344)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(346)).setAttribute("class","legend" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(347)).setAttribute("nombre","lblBloqueOferta" );
      ((Element)v.get(347)).setAttribute("alto","13" );
      ((Element)v.get(347)).setAttribute("filas","1" );
      ((Element)v.get(347)).setAttribute("valor","" );
      ((Element)v.get(347)).setAttribute("id","legend" );
      ((Element)v.get(347)).setAttribute("cod","00336" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */
      /* Termina nodo:346   */

      /* Empieza nodo:348 / Elemento padre: 345   */
      v.add(doc.createElement("table"));
      ((Element)v.get(348)).setAttribute("width","100%" );
      ((Element)v.get(348)).setAttribute("border","0" );
      ((Element)v.get(348)).setAttribute("align","center" );
      ((Element)v.get(348)).setAttribute("cellspacing","0" );
      ((Element)v.get(348)).setAttribute("cellpadding","0" );
      ((Element)v.get(345)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(348)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("td"));
      ((Element)v.get(349)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("table"));
      ((Element)v.get(351)).setAttribute("width","600" );
      ((Element)v.get(351)).setAttribute("border","0" );
      ((Element)v.get(351)).setAttribute("align","left" );
      ((Element)v.get(351)).setAttribute("cellspacing","0" );
      ((Element)v.get(351)).setAttribute("cellpadding","0" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(351)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("td"));
      ((Element)v.get(353)).setAttribute("colspan","4" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(354)).setAttribute("src","b.gif" );
      ((Element)v.get(354)).setAttribute("width","8" );
      ((Element)v.get(354)).setAttribute("height","8" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */
      /* Termina nodo:353   */
      /* Termina nodo:352   */

      /* Empieza nodo:355 / Elemento padre: 351   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(351)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(357)).setAttribute("src","b.gif" );
      ((Element)v.get(357)).setAttribute("width","8" );
      ((Element)v.get(357)).setAttribute("height","8" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */

      /* Empieza nodo:358 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(359)).setAttribute("nombre","lblTipoOferta" );
      ((Element)v.get(359)).setAttribute("alto","13" );
      ((Element)v.get(359)).setAttribute("filas","1" );
      ((Element)v.get(359)).setAttribute("valor","" );
      ((Element)v.get(359)).setAttribute("id","datosTitle" );
      ((Element)v.get(359)).setAttribute("cod","608" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */
      /* Termina nodo:358   */

      /* Empieza nodo:360 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(361)).setAttribute("src","b.gif" );
      ((Element)v.get(361)).setAttribute("width","25" );
      ((Element)v.get(361)).setAttribute("height","8" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */
      /* Termina nodo:360   */

      /* Empieza nodo:362 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(363)).setAttribute("nombre","lblCicloVida" );
      ((Element)v.get(363)).setAttribute("alto","13" );
      ((Element)v.get(363)).setAttribute("filas","1" );
      ((Element)v.get(363)).setAttribute("valor","" );
      ((Element)v.get(363)).setAttribute("id","datosTitle" );
      ((Element)v.get(363)).setAttribute("cod","581" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */
      /* Termina nodo:362   */

      /* Empieza nodo:364 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(364)).setAttribute("width","100%" );
      ((Element)v.get(355)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(365)).setAttribute("src","b.gif" );
      ((Element)v.get(365)).setAttribute("width","8" );
      ((Element)v.get(365)).setAttribute("height","8" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */
      /* Termina nodo:364   */
      /* Termina nodo:355   */

      /* Empieza nodo:366 / Elemento padre: 351   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(351)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("td"));
      ((Element)v.get(366)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(368)).setAttribute("src","b.gif" );
      ((Element)v.get(368)).setAttribute("width","8" );
      ((Element)v.get(368)).setAttribute("height","8" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */
      /* Termina nodo:367   */

      /* Empieza nodo:369 / Elemento padre: 366   */
      v.add(doc.createElement("td"));
      ((Element)v.get(369)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(366)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(370)).setAttribute("nombre","cbTipoOferta" );
      ((Element)v.get(370)).setAttribute("id","datosCampos" );
      ((Element)v.get(370)).setAttribute("size","1" );
      ((Element)v.get(370)).setAttribute("multiple","N" );
      ((Element)v.get(370)).setAttribute("req","S" );
      ((Element)v.get(370)).setAttribute("onshtab","focalizaAceptar();" );
      ((Element)v.get(370)).setAttribute("valorinicial","" );
      ((Element)v.get(370)).setAttribute("textoinicial","" );
      ((Element)v.get(369)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */
      /* Termina nodo:370   */
      /* Termina nodo:369   */

      /* Empieza nodo:372 / Elemento padre: 366   */
      v.add(doc.createElement("td"));
      ((Element)v.get(366)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(373)).setAttribute("src","b.gif" );
      ((Element)v.get(373)).setAttribute("width","25" );
      ((Element)v.get(373)).setAttribute("height","8" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */
      /* Termina nodo:372   */

      /* Empieza nodo:374 / Elemento padre: 366   */
      v.add(doc.createElement("td"));
      ((Element)v.get(374)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(366)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(375)).setAttribute("nombre","cbCicloVida" );
      ((Element)v.get(375)).setAttribute("id","datosCampos" );
      ((Element)v.get(375)).setAttribute("size","1" );
      ((Element)v.get(375)).setAttribute("multiple","N" );
      ((Element)v.get(375)).setAttribute("req","N" );
      ((Element)v.get(375)).setAttribute("ontab","tabDatosAsociados();" );
      ((Element)v.get(375)).setAttribute("valorinicial","" );
      ((Element)v.get(375)).setAttribute("textoinicial","" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(375)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */
      /* Termina nodo:375   */
      /* Termina nodo:374   */

      /* Empieza nodo:377 / Elemento padre: 366   */
      v.add(doc.createElement("td"));
      ((Element)v.get(377)).setAttribute("width","100%" );
      ((Element)v.get(366)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(378)).setAttribute("src","b.gif" );
      ((Element)v.get(378)).setAttribute("width","8" );
      ((Element)v.get(378)).setAttribute("height","8" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:377   */
      /* Termina nodo:366   */

      /* Empieza nodo:379 / Elemento padre: 351   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(351)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("td"));
      ((Element)v.get(380)).setAttribute("colspan","4" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(381)).setAttribute("src","b.gif" );
      ((Element)v.get(381)).setAttribute("width","8" );
      ((Element)v.get(381)).setAttribute("height","78" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */
      /* Termina nodo:380   */
      /* Termina nodo:379   */
      /* Termina nodo:351   */
      /* Termina nodo:350   */
      /* Termina nodo:349   */
      /* Termina nodo:348   */
      /* Termina nodo:345   */
      /* Termina nodo:344   */

      /* Empieza nodo:382 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(383)).setAttribute("src","b.gif" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */
      /* Termina nodo:382   */
      /* Termina nodo:341   */

      /* Empieza nodo:384 / Elemento padre: 333   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(333)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
   }

   private void getXML1530(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(385)).setAttribute("width","12" );
      ((Element)v.get(385)).setAttribute("align","center" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(386)).setAttribute("src","b.gif" );
      ((Element)v.get(386)).setAttribute("width","24" );
      ((Element)v.get(386)).setAttribute("height","12" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));
      /* Termina nodo:386   */
      /* Termina nodo:385   */

      /* Empieza nodo:387 / Elemento padre: 384   */
      v.add(doc.createElement("td"));
      ((Element)v.get(387)).setAttribute("width","756" );
      ((Element)v.get(384)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(388)).setAttribute("src","b.gif" );
      ((Element)v.get(387)).appendChild((Element)v.get(388));
      /* Termina nodo:388   */
      /* Termina nodo:387   */

      /* Empieza nodo:389 / Elemento padre: 384   */
      v.add(doc.createElement("td"));
      ((Element)v.get(389)).setAttribute("width","12" );
      ((Element)v.get(384)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(390)).setAttribute("src","b.gif" );
      ((Element)v.get(390)).setAttribute("width","24" );
      ((Element)v.get(390)).setAttribute("height","1" );
      ((Element)v.get(389)).appendChild((Element)v.get(390));
      /* Termina nodo:390   */
      /* Termina nodo:389   */
      /* Termina nodo:384   */
      /* Termina nodo:333   */
      /* Termina nodo:332   */

      /* Empieza nodo:391 / Elemento padre: 14   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(391)).setAttribute("nombre","capa4" );
      ((Element)v.get(391)).setAttribute("alto","200" );
      ((Element)v.get(391)).setAttribute("ancho","100%" );
      ((Element)v.get(391)).setAttribute("colorf","" );
      ((Element)v.get(391)).setAttribute("borde","0" );
      ((Element)v.get(391)).setAttribute("imagenf","" );
      ((Element)v.get(391)).setAttribute("repeat","" );
      ((Element)v.get(391)).setAttribute("padding","" );
      ((Element)v.get(391)).setAttribute("visibilidad","" );
      ((Element)v.get(391)).setAttribute("contravsb","" );
      ((Element)v.get(391)).setAttribute("x","0" );
      ((Element)v.get(391)).setAttribute("y","109" );
      ((Element)v.get(391)).setAttribute("zindex","" );
      ((Element)v.get(14)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("table"));
      ((Element)v.get(392)).setAttribute("width","100%" );
      ((Element)v.get(392)).setAttribute("border","0" );
      ((Element)v.get(392)).setAttribute("cellspacing","0" );
      ((Element)v.get(392)).setAttribute("cellpadding","0" );
      ((Element)v.get(391)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(392)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("td"));
      ((Element)v.get(394)).setAttribute("width","12" );
      ((Element)v.get(394)).setAttribute("align","center" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(395)).setAttribute("src","b.gif" );
      ((Element)v.get(395)).setAttribute("width","25" );
      ((Element)v.get(395)).setAttribute("height","12" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */
      /* Termina nodo:394   */

      /* Empieza nodo:396 / Elemento padre: 393   */
      v.add(doc.createElement("td"));
      ((Element)v.get(396)).setAttribute("width","750" );
      ((Element)v.get(393)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(397)).setAttribute("src","b.gif" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */
      /* Termina nodo:396   */

      /* Empieza nodo:398 / Elemento padre: 393   */
      v.add(doc.createElement("td"));
      ((Element)v.get(398)).setAttribute("width","12" );
      ((Element)v.get(393)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(399)).setAttribute("src","b.gif" );
      ((Element)v.get(399)).setAttribute("width","26" );
      ((Element)v.get(399)).setAttribute("height","1" );
      ((Element)v.get(398)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */
      /* Termina nodo:398   */
      /* Termina nodo:393   */

      /* Empieza nodo:400 / Elemento padre: 392   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(392)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("td"));
      ((Element)v.get(400)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(402)).setAttribute("src","b.gif" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */
      /* Termina nodo:401   */

      /* Empieza nodo:403 / Elemento padre: 400   */
      v.add(doc.createElement("td"));
      ((Element)v.get(400)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(403)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(405)).setAttribute("class","legend" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(406)).setAttribute("nombre","lblBloqueProducto" );
      ((Element)v.get(406)).setAttribute("alto","13" );
      ((Element)v.get(406)).setAttribute("filas","1" );
      ((Element)v.get(406)).setAttribute("valor","" );
      ((Element)v.get(406)).setAttribute("id","legend" );
      ((Element)v.get(406)).setAttribute("cod","00337" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(405)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */
      /* Termina nodo:405   */

      /* Empieza nodo:407 / Elemento padre: 404   */
      v.add(doc.createElement("table"));
      ((Element)v.get(407)).setAttribute("width","100%" );
      ((Element)v.get(407)).setAttribute("border","0" );
      ((Element)v.get(407)).setAttribute("align","center" );
      ((Element)v.get(407)).setAttribute("cellspacing","0" );
      ((Element)v.get(407)).setAttribute("cellpadding","0" );
      ((Element)v.get(404)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(407)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("td"));
      ((Element)v.get(408)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("table"));
      ((Element)v.get(410)).setAttribute("width","600" );
      ((Element)v.get(410)).setAttribute("border","0" );
      ((Element)v.get(410)).setAttribute("align","left" );
      ((Element)v.get(410)).setAttribute("cellspacing","0" );
      ((Element)v.get(410)).setAttribute("cellpadding","0" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(410)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("td"));
      ((Element)v.get(412)).setAttribute("colspan","4" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(413)).setAttribute("src","b.gif" );
      ((Element)v.get(413)).setAttribute("width","8" );
      ((Element)v.get(413)).setAttribute("height","8" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */
      /* Termina nodo:412   */
      /* Termina nodo:411   */

      /* Empieza nodo:414 / Elemento padre: 410   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(410)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("td"));
      ((Element)v.get(414)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(416)).setAttribute("src","b.gif" );
      ((Element)v.get(416)).setAttribute("width","8" );
      ((Element)v.get(416)).setAttribute("height","8" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */
      /* Termina nodo:415   */

      /* Empieza nodo:417 / Elemento padre: 414   */
      v.add(doc.createElement("td"));
      ((Element)v.get(414)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(418)).setAttribute("nombre","lblCodProducto" );
      ((Element)v.get(418)).setAttribute("alto","13" );
      ((Element)v.get(418)).setAttribute("filas","1" );
      ((Element)v.get(418)).setAttribute("valor","" );
      ((Element)v.get(418)).setAttribute("id","datosTitle" );
      ((Element)v.get(418)).setAttribute("cod","337" );
      ((Element)v.get(417)).appendChild((Element)v.get(418));
      /* Termina nodo:418   */
      /* Termina nodo:417   */

      /* Empieza nodo:419 / Elemento padre: 414   */
      v.add(doc.createElement("td"));
      ((Element)v.get(419)).setAttribute("width","100%" );
      ((Element)v.get(414)).appendChild((Element)v.get(419));

      /* Empieza nodo:420 / Elemento padre: 419   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(420)).setAttribute("src","b.gif" );
      ((Element)v.get(420)).setAttribute("width","8" );
      ((Element)v.get(420)).setAttribute("height","8" );
      ((Element)v.get(419)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */
      /* Termina nodo:419   */
      /* Termina nodo:414   */

      /* Empieza nodo:421 / Elemento padre: 410   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(410)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("td"));
      ((Element)v.get(421)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(423)).setAttribute("src","b.gif" );
      ((Element)v.get(423)).setAttribute("width","8" );
      ((Element)v.get(423)).setAttribute("height","8" );
      ((Element)v.get(422)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */
      /* Termina nodo:422   */

      /* Empieza nodo:424 / Elemento padre: 421   */
      v.add(doc.createElement("td"));
      ((Element)v.get(424)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(421)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(425)).setAttribute("nombre","txtCodProducto" );
      ((Element)v.get(425)).setAttribute("id","datosCampos" );
      ((Element)v.get(425)).setAttribute("max","20" );
      ((Element)v.get(425)).setAttribute("tipo","" );
      ((Element)v.get(425)).setAttribute("onchange","limpiaOidOculto();" );
      ((Element)v.get(425)).setAttribute("req","S" );
      ((Element)v.get(425)).setAttribute("onshtab","focalizaAceptar();" );
      ((Element)v.get(425)).setAttribute("size","26" );
      ((Element)v.get(425)).setAttribute("valor","" );
      ((Element)v.get(425)).setAttribute("validacion","" );
      ((Element)v.get(424)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */
      /* Termina nodo:424   */

      /* Empieza nodo:426 / Elemento padre: 421   */
      v.add(doc.createElement("td"));
      ((Element)v.get(421)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(427)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(427)).setAttribute("ID","botonContenido" );
      ((Element)v.get(427)).setAttribute("tipo","html" );
      ((Element)v.get(427)).setAttribute("accion","accionBuscarProducto();" );
      ((Element)v.get(427)).setAttribute("estado","false" );
      ((Element)v.get(427)).setAttribute("cod","1" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */
      /* Termina nodo:426   */

      /* Empieza nodo:428 / Elemento padre: 421   */
   }

   private void getXML1710(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(428)).setAttribute("width","100%" );
      ((Element)v.get(421)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(429)).setAttribute("src","b.gif" );
      ((Element)v.get(429)).setAttribute("width","8" );
      ((Element)v.get(429)).setAttribute("height","8" );
      ((Element)v.get(428)).appendChild((Element)v.get(429));
      /* Termina nodo:429   */
      /* Termina nodo:428   */
      /* Termina nodo:421   */

      /* Empieza nodo:430 / Elemento padre: 410   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(410)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("td"));
      ((Element)v.get(431)).setAttribute("colspan","4" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(432)).setAttribute("src","b.gif" );
      ((Element)v.get(432)).setAttribute("width","8" );
      ((Element)v.get(432)).setAttribute("height","8" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));
      /* Termina nodo:432   */
      /* Termina nodo:431   */
      /* Termina nodo:430   */
      /* Termina nodo:410   */
      /* Termina nodo:409   */
      /* Termina nodo:408   */

      /* Empieza nodo:433 / Elemento padre: 407   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(407)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("td"));
      ((Element)v.get(433)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("table"));
      ((Element)v.get(435)).setAttribute("width","600" );
      ((Element)v.get(435)).setAttribute("border","0" );
      ((Element)v.get(435)).setAttribute("align","left" );
      ((Element)v.get(435)).setAttribute("cellspacing","0" );
      ((Element)v.get(435)).setAttribute("cellpadding","0" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(435)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("td"));
      ((Element)v.get(436)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(438)).setAttribute("src","b.gif" );
      ((Element)v.get(438)).setAttribute("width","8" );
      ((Element)v.get(438)).setAttribute("height","8" );
      ((Element)v.get(437)).appendChild((Element)v.get(438));
      /* Termina nodo:438   */
      /* Termina nodo:437   */

      /* Empieza nodo:439 / Elemento padre: 436   */
      v.add(doc.createElement("td"));
      ((Element)v.get(436)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(440)).setAttribute("nombre","lblTipoOferta2" );
      ((Element)v.get(440)).setAttribute("alto","13" );
      ((Element)v.get(440)).setAttribute("filas","1" );
      ((Element)v.get(440)).setAttribute("valor","" );
      ((Element)v.get(440)).setAttribute("id","datosTitle" );
      ((Element)v.get(440)).setAttribute("cod","608" );
      ((Element)v.get(439)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */
      /* Termina nodo:439   */

      /* Empieza nodo:441 / Elemento padre: 436   */
      v.add(doc.createElement("td"));
      ((Element)v.get(436)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(442)).setAttribute("src","b.gif" );
      ((Element)v.get(442)).setAttribute("width","25" );
      ((Element)v.get(442)).setAttribute("height","8" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */
      /* Termina nodo:441   */

      /* Empieza nodo:443 / Elemento padre: 436   */
      v.add(doc.createElement("td"));
      ((Element)v.get(436)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(444)).setAttribute("nombre","lblCicloVida2" );
      ((Element)v.get(444)).setAttribute("alto","13" );
      ((Element)v.get(444)).setAttribute("filas","1" );
      ((Element)v.get(444)).setAttribute("valor","" );
      ((Element)v.get(444)).setAttribute("id","datosTitle" );
      ((Element)v.get(444)).setAttribute("cod","581" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));
      /* Termina nodo:444   */
      /* Termina nodo:443   */

      /* Empieza nodo:445 / Elemento padre: 436   */
      v.add(doc.createElement("td"));
      ((Element)v.get(445)).setAttribute("width","100%" );
      ((Element)v.get(436)).appendChild((Element)v.get(445));

      /* Empieza nodo:446 / Elemento padre: 445   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(446)).setAttribute("src","b.gif" );
      ((Element)v.get(446)).setAttribute("width","8" );
      ((Element)v.get(446)).setAttribute("height","8" );
      ((Element)v.get(445)).appendChild((Element)v.get(446));
      /* Termina nodo:446   */
      /* Termina nodo:445   */
      /* Termina nodo:436   */

      /* Empieza nodo:447 / Elemento padre: 435   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(435)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("td"));
      ((Element)v.get(447)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(449)).setAttribute("src","b.gif" );
      ((Element)v.get(449)).setAttribute("width","8" );
      ((Element)v.get(449)).setAttribute("height","8" );
      ((Element)v.get(448)).appendChild((Element)v.get(449));
      /* Termina nodo:449   */
      /* Termina nodo:448   */

      /* Empieza nodo:450 / Elemento padre: 447   */
      v.add(doc.createElement("td"));
      ((Element)v.get(450)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(450)).setAttribute("valign","bottom" );
      ((Element)v.get(447)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(451)).setAttribute("nombre","cbTipoOferta2" );
      ((Element)v.get(451)).setAttribute("id","datosCampos" );
      ((Element)v.get(451)).setAttribute("size","1" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(451)).setAttribute("multiple","N" );
      ((Element)v.get(451)).setAttribute("req","N" );
      ((Element)v.get(451)).setAttribute("valorinicial","" );
      ((Element)v.get(451)).setAttribute("textoinicial","" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(451)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */
      /* Termina nodo:451   */
      /* Termina nodo:450   */

      /* Empieza nodo:453 / Elemento padre: 447   */
      v.add(doc.createElement("td"));
      ((Element)v.get(447)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(454)).setAttribute("src","b.gif" );
      ((Element)v.get(454)).setAttribute("width","25" );
      ((Element)v.get(454)).setAttribute("height","8" );
      ((Element)v.get(453)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */
      /* Termina nodo:453   */

      /* Empieza nodo:455 / Elemento padre: 447   */
      v.add(doc.createElement("td"));
      ((Element)v.get(455)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(447)).appendChild((Element)v.get(455));

      /* Empieza nodo:456 / Elemento padre: 455   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(456)).setAttribute("nombre","cbCicloVida2" );
      ((Element)v.get(456)).setAttribute("id","datosCampos" );
      ((Element)v.get(456)).setAttribute("size","1" );
      ((Element)v.get(456)).setAttribute("multiple","N" );
      ((Element)v.get(456)).setAttribute("req","N" );
      ((Element)v.get(456)).setAttribute("ontab","tabDatosAsociados();" );
      ((Element)v.get(456)).setAttribute("valorinicial","" );
      ((Element)v.get(456)).setAttribute("textoinicial","" );
      ((Element)v.get(455)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(456)).appendChild((Element)v.get(457));
      /* Termina nodo:457   */
      /* Termina nodo:456   */
      /* Termina nodo:455   */

      /* Empieza nodo:458 / Elemento padre: 447   */
      v.add(doc.createElement("td"));
      ((Element)v.get(458)).setAttribute("width","100%" );
      ((Element)v.get(447)).appendChild((Element)v.get(458));

      /* Empieza nodo:459 / Elemento padre: 458   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(459)).setAttribute("src","b.gif" );
      ((Element)v.get(459)).setAttribute("width","8" );
      ((Element)v.get(459)).setAttribute("height","8" );
      ((Element)v.get(458)).appendChild((Element)v.get(459));
      /* Termina nodo:459   */
      /* Termina nodo:458   */
      /* Termina nodo:447   */

      /* Empieza nodo:460 / Elemento padre: 435   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(435)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("td"));
      ((Element)v.get(461)).setAttribute("colspan","4" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));

      /* Empieza nodo:462 / Elemento padre: 461   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(462)).setAttribute("src","b.gif" );
      ((Element)v.get(462)).setAttribute("width","8" );
      ((Element)v.get(462)).setAttribute("height","45" );
      ((Element)v.get(461)).appendChild((Element)v.get(462));
      /* Termina nodo:462   */
      /* Termina nodo:461   */
      /* Termina nodo:460   */
      /* Termina nodo:435   */
      /* Termina nodo:434   */
      /* Termina nodo:433   */
      /* Termina nodo:407   */
      /* Termina nodo:404   */
      /* Termina nodo:403   */

      /* Empieza nodo:463 / Elemento padre: 400   */
      v.add(doc.createElement("td"));
      ((Element)v.get(400)).appendChild((Element)v.get(463));

      /* Empieza nodo:464 / Elemento padre: 463   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(464)).setAttribute("src","b.gif" );
      ((Element)v.get(463)).appendChild((Element)v.get(464));
      /* Termina nodo:464   */
      /* Termina nodo:463   */
      /* Termina nodo:400   */

      /* Empieza nodo:465 / Elemento padre: 392   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(392)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("td"));
      ((Element)v.get(466)).setAttribute("width","12" );
      ((Element)v.get(466)).setAttribute("align","center" );
      ((Element)v.get(465)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(467)).setAttribute("src","b.gif" );
      ((Element)v.get(467)).setAttribute("width","24" );
      ((Element)v.get(467)).setAttribute("height","12" );
      ((Element)v.get(466)).appendChild((Element)v.get(467));
      /* Termina nodo:467   */
      /* Termina nodo:466   */

      /* Empieza nodo:468 / Elemento padre: 465   */
      v.add(doc.createElement("td"));
      ((Element)v.get(468)).setAttribute("width","756" );
      ((Element)v.get(465)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(469)).setAttribute("src","b.gif" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));
      /* Termina nodo:469   */
      /* Termina nodo:468   */

      /* Empieza nodo:470 / Elemento padre: 465   */
      v.add(doc.createElement("td"));
      ((Element)v.get(470)).setAttribute("width","12" );
      ((Element)v.get(465)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(471)).setAttribute("src","b.gif" );
      ((Element)v.get(471)).setAttribute("width","24" );
      ((Element)v.get(471)).setAttribute("height","1" );
      ((Element)v.get(470)).appendChild((Element)v.get(471));
      /* Termina nodo:471   */
      /* Termina nodo:470   */
      /* Termina nodo:465   */
      /* Termina nodo:392   */
      /* Termina nodo:391   */

      /* Empieza nodo:472 / Elemento padre: 14   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(472)).setAttribute("nombre","capa5" );
      ((Element)v.get(472)).setAttribute("alto","100" );
      ((Element)v.get(472)).setAttribute("ancho","100%" );
      ((Element)v.get(472)).setAttribute("colorf","" );
      ((Element)v.get(472)).setAttribute("borde","0" );
      ((Element)v.get(472)).setAttribute("imagenf","" );
      ((Element)v.get(472)).setAttribute("repeat","" );
      ((Element)v.get(472)).setAttribute("padding","" );
      ((Element)v.get(472)).setAttribute("visibilidad","" );
      ((Element)v.get(472)).setAttribute("contravsb","" );
      ((Element)v.get(472)).setAttribute("x","0" );
      ((Element)v.get(472)).setAttribute("y","764" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(472)).setAttribute("zindex","" );
      ((Element)v.get(14)).appendChild((Element)v.get(472));

      /* Empieza nodo:473 / Elemento padre: 472   */
      v.add(doc.createElement("table"));
      ((Element)v.get(473)).setAttribute("width","100%" );
      ((Element)v.get(473)).setAttribute("border","0" );
      ((Element)v.get(473)).setAttribute("cellspacing","0" );
      ((Element)v.get(473)).setAttribute("cellpadding","0" );
      ((Element)v.get(472)).appendChild((Element)v.get(473));

      /* Empieza nodo:474 / Elemento padre: 473   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(473)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("td"));
      ((Element)v.get(475)).setAttribute("width","12" );
      ((Element)v.get(475)).setAttribute("align","center" );
      ((Element)v.get(474)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(476)).setAttribute("src","b.gif" );
      ((Element)v.get(476)).setAttribute("width","12" );
      ((Element)v.get(476)).setAttribute("height","12" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */
      /* Termina nodo:475   */

      /* Empieza nodo:477 / Elemento padre: 474   */
      v.add(doc.createElement("td"));
      ((Element)v.get(477)).setAttribute("width","750" );
      ((Element)v.get(474)).appendChild((Element)v.get(477));

      /* Empieza nodo:478 / Elemento padre: 477   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(478)).setAttribute("src","b.gif" );
      ((Element)v.get(477)).appendChild((Element)v.get(478));
      /* Termina nodo:478   */
      /* Termina nodo:477   */

      /* Empieza nodo:479 / Elemento padre: 474   */
      v.add(doc.createElement("td"));
      ((Element)v.get(479)).setAttribute("width","12" );
      ((Element)v.get(474)).appendChild((Element)v.get(479));

      /* Empieza nodo:480 / Elemento padre: 479   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(480)).setAttribute("src","b.gif" );
      ((Element)v.get(480)).setAttribute("width","12" );
      ((Element)v.get(480)).setAttribute("height","1" );
      ((Element)v.get(479)).appendChild((Element)v.get(480));
      /* Termina nodo:480   */
      /* Termina nodo:479   */
      /* Termina nodo:474   */

      /* Empieza nodo:481 / Elemento padre: 473   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(473)).appendChild((Element)v.get(481));

      /* Empieza nodo:482 / Elemento padre: 481   */
      v.add(doc.createElement("td"));
      ((Element)v.get(481)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(483)).setAttribute("src","b.gif" );
      ((Element)v.get(482)).appendChild((Element)v.get(483));
      /* Termina nodo:483   */
      /* Termina nodo:482   */

      /* Empieza nodo:484 / Elemento padre: 481   */
      v.add(doc.createElement("td"));
      ((Element)v.get(481)).appendChild((Element)v.get(484));

      /* Empieza nodo:485 / Elemento padre: 484   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(484)).appendChild((Element)v.get(485));

      /* Empieza nodo:486 / Elemento padre: 485   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(486)).setAttribute("class","legend" );
      ((Element)v.get(485)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(487)).setAttribute("nombre","lblOtrosDatos" );
      ((Element)v.get(487)).setAttribute("alto","13" );
      ((Element)v.get(487)).setAttribute("filas","1" );
      ((Element)v.get(487)).setAttribute("valor","" );
      ((Element)v.get(487)).setAttribute("id","legend" );
      ((Element)v.get(487)).setAttribute("cod","00167" );
      ((Element)v.get(486)).appendChild((Element)v.get(487));
      /* Termina nodo:487   */
      /* Termina nodo:486   */

      /* Empieza nodo:488 / Elemento padre: 485   */
      v.add(doc.createElement("table"));
      ((Element)v.get(488)).setAttribute("width","100%" );
      ((Element)v.get(488)).setAttribute("border","0" );
      ((Element)v.get(488)).setAttribute("align","center" );
      ((Element)v.get(488)).setAttribute("cellspacing","0" );
      ((Element)v.get(488)).setAttribute("cellpadding","0" );
      ((Element)v.get(485)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(488)).appendChild((Element)v.get(489));

      /* Empieza nodo:490 / Elemento padre: 489   */
      v.add(doc.createElement("td"));
      ((Element)v.get(489)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("table"));
      ((Element)v.get(491)).setAttribute("width","628" );
      ((Element)v.get(491)).setAttribute("border","0" );
      ((Element)v.get(491)).setAttribute("align","left" );
      ((Element)v.get(491)).setAttribute("cellspacing","0" );
      ((Element)v.get(491)).setAttribute("cellpadding","0" );
      ((Element)v.get(490)).appendChild((Element)v.get(491));

      /* Empieza nodo:492 / Elemento padre: 491   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(491)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("td"));
      ((Element)v.get(493)).setAttribute("colspan","4" );
      ((Element)v.get(492)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(494)).setAttribute("src","b.gif" );
      ((Element)v.get(494)).setAttribute("width","8" );
      ((Element)v.get(494)).setAttribute("height","8" );
      ((Element)v.get(493)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */
      /* Termina nodo:493   */
      /* Termina nodo:492   */

      /* Empieza nodo:495 / Elemento padre: 491   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(491)).appendChild((Element)v.get(495));

      /* Empieza nodo:496 / Elemento padre: 495   */
      v.add(doc.createElement("td"));
      ((Element)v.get(495)).appendChild((Element)v.get(496));

      /* Empieza nodo:497 / Elemento padre: 496   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(497)).setAttribute("src","b.gif" );
      ((Element)v.get(497)).setAttribute("width","8" );
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(497)).setAttribute("height","8" );
      ((Element)v.get(496)).appendChild((Element)v.get(497));
      /* Termina nodo:497   */
      /* Termina nodo:496   */

      /* Empieza nodo:498 / Elemento padre: 495   */
      v.add(doc.createElement("td"));
      ((Element)v.get(495)).appendChild((Element)v.get(498));

      /* Empieza nodo:499 / Elemento padre: 498   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(499)).setAttribute("nombre","lblComunicacion" );
      ((Element)v.get(499)).setAttribute("alto","13" );
      ((Element)v.get(499)).setAttribute("filas","1" );
      ((Element)v.get(499)).setAttribute("valor","" );
      ((Element)v.get(499)).setAttribute("id","datosTitle" );
      ((Element)v.get(499)).setAttribute("cod","1812" );
      ((Element)v.get(498)).appendChild((Element)v.get(499));
      /* Termina nodo:499   */
      /* Termina nodo:498   */

      /* Empieza nodo:500 / Elemento padre: 495   */
      v.add(doc.createElement("td"));
      ((Element)v.get(495)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(501)).setAttribute("src","b.gif" );
      ((Element)v.get(501)).setAttribute("width","25" );
      ((Element)v.get(501)).setAttribute("height","8" );
      ((Element)v.get(500)).appendChild((Element)v.get(501));
      /* Termina nodo:501   */
      /* Termina nodo:500   */

      /* Empieza nodo:502 / Elemento padre: 495   */
      v.add(doc.createElement("td"));
      ((Element)v.get(495)).appendChild((Element)v.get(502));

      /* Empieza nodo:503 / Elemento padre: 502   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(503)).setAttribute("nombre","lblMensaje" );
      ((Element)v.get(503)).setAttribute("alto","13" );
      ((Element)v.get(503)).setAttribute("filas","1" );
      ((Element)v.get(503)).setAttribute("valor","" );
      ((Element)v.get(503)).setAttribute("id","datosTitle" );
      ((Element)v.get(503)).setAttribute("cod","531" );
      ((Element)v.get(502)).appendChild((Element)v.get(503));
      /* Termina nodo:503   */
      /* Termina nodo:502   */

      /* Empieza nodo:504 / Elemento padre: 495   */
      v.add(doc.createElement("td"));
      ((Element)v.get(504)).setAttribute("width","100%" );
      ((Element)v.get(495)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(505)).setAttribute("src","b.gif" );
      ((Element)v.get(505)).setAttribute("width","8" );
      ((Element)v.get(505)).setAttribute("height","8" );
      ((Element)v.get(504)).appendChild((Element)v.get(505));
      /* Termina nodo:505   */
      /* Termina nodo:504   */
      /* Termina nodo:495   */

      /* Empieza nodo:506 / Elemento padre: 491   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(491)).appendChild((Element)v.get(506));

      /* Empieza nodo:507 / Elemento padre: 506   */
      v.add(doc.createElement("td"));
      ((Element)v.get(506)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(508)).setAttribute("src","b.gif" );
      ((Element)v.get(508)).setAttribute("width","8" );
      ((Element)v.get(508)).setAttribute("height","8" );
      ((Element)v.get(507)).appendChild((Element)v.get(508));
      /* Termina nodo:508   */
      /* Termina nodo:507   */

      /* Empieza nodo:509 / Elemento padre: 506   */
      v.add(doc.createElement("td"));
      ((Element)v.get(506)).appendChild((Element)v.get(509));

      /* Empieza nodo:510 / Elemento padre: 509   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(510)).setAttribute("nombre","ckComunicacion" );
      ((Element)v.get(510)).setAttribute("id","datosCampos" );
      ((Element)v.get(510)).setAttribute("onshtab","focalizaAnyadir();" );
      ((Element)v.get(510)).setAttribute("onclick","deshabilitaTextoMensaje();" );
      ((Element)v.get(510)).setAttribute("check","N" );
      ((Element)v.get(509)).appendChild((Element)v.get(510));
      /* Termina nodo:510   */
      /* Termina nodo:509   */

      /* Empieza nodo:511 / Elemento padre: 506   */
      v.add(doc.createElement("td"));
      ((Element)v.get(506)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(512)).setAttribute("src","b.gif" );
      ((Element)v.get(512)).setAttribute("width","25" );
      ((Element)v.get(512)).setAttribute("height","8" );
      ((Element)v.get(511)).appendChild((Element)v.get(512));
      /* Termina nodo:512   */
      /* Termina nodo:511   */

      /* Empieza nodo:513 / Elemento padre: 506   */
      v.add(doc.createElement("td"));
      ((Element)v.get(506)).appendChild((Element)v.get(513));

      /* Empieza nodo:514 / Elemento padre: 513   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(514)).setAttribute("nombre","txtMensaje" );
      ((Element)v.get(514)).setAttribute("id","datosCampos" );
      ((Element)v.get(514)).setAttribute("max","5" );
      ((Element)v.get(514)).setAttribute("tipo","" );
      ((Element)v.get(514)).setAttribute("onchange","" );
      ((Element)v.get(514)).setAttribute("req","N" );
      ((Element)v.get(514)).setAttribute("size","5" );
      ((Element)v.get(514)).setAttribute("valor","" );
      ((Element)v.get(514)).setAttribute("validacion","" );
      ((Element)v.get(513)).appendChild((Element)v.get(514));
      /* Termina nodo:514   */
      /* Termina nodo:513   */

      /* Empieza nodo:515 / Elemento padre: 506   */
      v.add(doc.createElement("td"));
      ((Element)v.get(515)).setAttribute("width","100%" );
      ((Element)v.get(506)).appendChild((Element)v.get(515));

      /* Empieza nodo:516 / Elemento padre: 515   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(516)).setAttribute("src","b.gif" );
      ((Element)v.get(516)).setAttribute("width","8" );
      ((Element)v.get(516)).setAttribute("height","8" );
      ((Element)v.get(515)).appendChild((Element)v.get(516));
      /* Termina nodo:516   */
      /* Termina nodo:515   */
      /* Termina nodo:506   */

      /* Empieza nodo:517 / Elemento padre: 491   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(491)).appendChild((Element)v.get(517));

      /* Empieza nodo:518 / Elemento padre: 517   */
      v.add(doc.createElement("td"));
      ((Element)v.get(518)).setAttribute("colspan","4" );
      ((Element)v.get(517)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(519)).setAttribute("src","b.gif" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(519)).setAttribute("width","8" );
      ((Element)v.get(519)).setAttribute("height","8" );
      ((Element)v.get(518)).appendChild((Element)v.get(519));
      /* Termina nodo:519   */
      /* Termina nodo:518   */
      /* Termina nodo:517   */
      /* Termina nodo:491   */
      /* Termina nodo:490   */
      /* Termina nodo:489   */
      /* Termina nodo:488   */
      /* Termina nodo:485   */
      /* Termina nodo:484   */

      /* Empieza nodo:520 / Elemento padre: 481   */
      v.add(doc.createElement("td"));
      ((Element)v.get(481)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(521)).setAttribute("src","b.gif" );
      ((Element)v.get(520)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */
      /* Termina nodo:520   */
      /* Termina nodo:481   */

      /* Empieza nodo:522 / Elemento padre: 473   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(473)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("td"));
      ((Element)v.get(522)).appendChild((Element)v.get(523));

      /* Empieza nodo:524 / Elemento padre: 523   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(524)).setAttribute("src","b.gif" );
      ((Element)v.get(523)).appendChild((Element)v.get(524));
      /* Termina nodo:524   */
      /* Termina nodo:523   */

      /* Empieza nodo:525 / Elemento padre: 522   */
      v.add(doc.createElement("td"));
      ((Element)v.get(522)).appendChild((Element)v.get(525));

      /* Empieza nodo:526 / Elemento padre: 525   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(525)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("table"));
      ((Element)v.get(527)).setAttribute("width","100%" );
      ((Element)v.get(527)).setAttribute("border","0" );
      ((Element)v.get(527)).setAttribute("align","center" );
      ((Element)v.get(527)).setAttribute("cellspacing","0" );
      ((Element)v.get(527)).setAttribute("cellpadding","0" );
      ((Element)v.get(526)).appendChild((Element)v.get(527));

      /* Empieza nodo:528 / Elemento padre: 527   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(527)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("td"));
      ((Element)v.get(529)).setAttribute("class","botonera" );
      ((Element)v.get(528)).appendChild((Element)v.get(529));

      /* Empieza nodo:530 / Elemento padre: 529   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(530)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(530)).setAttribute("ID","botonContenido" );
      ((Element)v.get(530)).setAttribute("tipo","html" );
      ((Element)v.get(530)).setAttribute("ontab","tabAceptar();" );
      ((Element)v.get(530)).setAttribute("accion","accionAceptar();" );
      ((Element)v.get(530)).setAttribute("estado","false" );
      ((Element)v.get(530)).setAttribute("cod","12" );
      ((Element)v.get(529)).appendChild((Element)v.get(530));
      /* Termina nodo:530   */
      /* Termina nodo:529   */
      /* Termina nodo:528   */
      /* Termina nodo:527   */
      /* Termina nodo:526   */
      /* Termina nodo:525   */

      /* Empieza nodo:531 / Elemento padre: 522   */
      v.add(doc.createElement("td"));
      ((Element)v.get(522)).appendChild((Element)v.get(531));

      /* Empieza nodo:532 / Elemento padre: 531   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(532)).setAttribute("src","b.gif" );
      ((Element)v.get(532)).setAttribute("width","8" );
      ((Element)v.get(532)).setAttribute("height","12" );
      ((Element)v.get(531)).appendChild((Element)v.get(532));
      /* Termina nodo:532   */
      /* Termina nodo:531   */
      /* Termina nodo:522   */

      /* Empieza nodo:533 / Elemento padre: 473   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(473)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("td"));
      ((Element)v.get(534)).setAttribute("width","12" );
      ((Element)v.get(534)).setAttribute("align","center" );
      ((Element)v.get(533)).appendChild((Element)v.get(534));

      /* Empieza nodo:535 / Elemento padre: 534   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(535)).setAttribute("src","b.gif" );
      ((Element)v.get(535)).setAttribute("width","12" );
      ((Element)v.get(535)).setAttribute("height","12" );
      ((Element)v.get(534)).appendChild((Element)v.get(535));
      /* Termina nodo:535   */
      /* Termina nodo:534   */

      /* Empieza nodo:536 / Elemento padre: 533   */
      v.add(doc.createElement("td"));
      ((Element)v.get(536)).setAttribute("width","756" );
      ((Element)v.get(533)).appendChild((Element)v.get(536));

      /* Empieza nodo:537 / Elemento padre: 536   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(537)).setAttribute("src","b.gif" );
      ((Element)v.get(536)).appendChild((Element)v.get(537));
      /* Termina nodo:537   */
      /* Termina nodo:536   */

      /* Empieza nodo:538 / Elemento padre: 533   */
      v.add(doc.createElement("td"));
      ((Element)v.get(538)).setAttribute("width","12" );
      ((Element)v.get(533)).appendChild((Element)v.get(538));

      /* Empieza nodo:539 / Elemento padre: 538   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(539)).setAttribute("src","b.gif" );
      ((Element)v.get(539)).setAttribute("width","12" );
      ((Element)v.get(539)).setAttribute("height","1" );
      ((Element)v.get(538)).appendChild((Element)v.get(539));
      /* Termina nodo:539   */
      /* Termina nodo:538   */
      /* Termina nodo:533   */
      /* Termina nodo:473   */
      /* Termina nodo:472   */

      /* Empieza nodo:540 / Elemento padre: 14   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(540)).setAttribute("nombre","listado1" );
      ((Element)v.get(540)).setAttribute("ancho","632" );
      ((Element)v.get(540)).setAttribute("alto","345" );
      ((Element)v.get(540)).setAttribute("x","12" );
      ((Element)v.get(540)).setAttribute("y","409" );
      ((Element)v.get(540)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(540)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(14)).appendChild((Element)v.get(540));

      /* Empieza nodo:541 / Elemento padre: 540   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(541)).setAttribute("precarga","S" );
      ((Element)v.get(541)).setAttribute("conROver","S" );
      ((Element)v.get(540)).appendChild((Element)v.get(541));

      /* Empieza nodo:542 / Elemento padre: 541   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(542)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(542)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(542)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(542)).setAttribute("desactivado","btnLista2D.gif" );
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(541)).appendChild((Element)v.get(542));
      /* Termina nodo:542   */

      /* Empieza nodo:543 / Elemento padre: 541   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(543)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(543)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(543)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(543)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(541)).appendChild((Element)v.get(543));
      /* Termina nodo:543   */

      /* Empieza nodo:544 / Elemento padre: 541   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(544)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(544)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(541)).appendChild((Element)v.get(544));
      /* Termina nodo:544   */
      /* Termina nodo:541   */

      /* Empieza nodo:545 / Elemento padre: 540   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(540)).appendChild((Element)v.get(545));

      /* Empieza nodo:546 / Elemento padre: 545   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(546)).setAttribute("borde","1" );
      ((Element)v.get(546)).setAttribute("horizDatos","1" );
      ((Element)v.get(546)).setAttribute("horizCabecera","1" );
      ((Element)v.get(546)).setAttribute("vertical","1" );
      ((Element)v.get(546)).setAttribute("horizTitulo","1" );
      ((Element)v.get(546)).setAttribute("horizBase","1" );
      ((Element)v.get(545)).appendChild((Element)v.get(546));
      /* Termina nodo:546   */

      /* Empieza nodo:547 / Elemento padre: 545   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(547)).setAttribute("borde","#999999" );
      ((Element)v.get(547)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(547)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(547)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(547)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(547)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(547)).setAttribute("horizBase","#999999" );
      ((Element)v.get(545)).appendChild((Element)v.get(547));
      /* Termina nodo:547   */
      /* Termina nodo:545   */

      /* Empieza nodo:548 / Elemento padre: 540   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(548)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(548)).setAttribute("alto","22" );
      ((Element)v.get(548)).setAttribute("imgFondo","" );
      ((Element)v.get(548)).setAttribute("cod","00338" );
      ((Element)v.get(548)).setAttribute("ID","datosTitle" );
      ((Element)v.get(540)).appendChild((Element)v.get(548));
      /* Termina nodo:548   */

      /* Empieza nodo:549 / Elemento padre: 540   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(549)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(549)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(549)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(549)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(549)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(549)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(540)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(550)).setAttribute("ancho","150" );
      ((Element)v.get(550)).setAttribute("minimizable","S" );
      ((Element)v.get(550)).setAttribute("minimizada","N" );
      ((Element)v.get(549)).appendChild((Element)v.get(550));
      /* Termina nodo:550   */

      /* Empieza nodo:551 / Elemento padre: 549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(551)).setAttribute("ancho","150" );
      ((Element)v.get(551)).setAttribute("minimizable","S" );
      ((Element)v.get(551)).setAttribute("minimizada","N" );
      ((Element)v.get(549)).appendChild((Element)v.get(551));
      /* Termina nodo:551   */

      /* Empieza nodo:552 / Elemento padre: 549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(552)).setAttribute("ancho","150" );
      ((Element)v.get(552)).setAttribute("minimizable","S" );
      ((Element)v.get(552)).setAttribute("minimizada","N" );
      ((Element)v.get(549)).appendChild((Element)v.get(552));
      /* Termina nodo:552   */

      /* Empieza nodo:553 / Elemento padre: 549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(553)).setAttribute("ancho","150" );
      ((Element)v.get(553)).setAttribute("minimizable","S" );
      ((Element)v.get(553)).setAttribute("minimizada","N" );
      ((Element)v.get(549)).appendChild((Element)v.get(553));
      /* Termina nodo:553   */

      /* Empieza nodo:554 / Elemento padre: 549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(554)).setAttribute("ancho","150" );
      ((Element)v.get(554)).setAttribute("minimizable","S" );
      ((Element)v.get(554)).setAttribute("minimizada","N" );
      ((Element)v.get(549)).appendChild((Element)v.get(554));
      /* Termina nodo:554   */

      /* Empieza nodo:555 / Elemento padre: 549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(555)).setAttribute("ancho","150" );
      ((Element)v.get(555)).setAttribute("minimizable","S" );
      ((Element)v.get(555)).setAttribute("minimizada","N" );
      ((Element)v.get(549)).appendChild((Element)v.get(555));
      /* Termina nodo:555   */

      /* Empieza nodo:556 / Elemento padre: 549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(556)).setAttribute("ancho","150" );
      ((Element)v.get(556)).setAttribute("minimizable","S" );
      ((Element)v.get(556)).setAttribute("minimizada","N" );
      ((Element)v.get(549)).appendChild((Element)v.get(556));
      /* Termina nodo:556   */

      /* Empieza nodo:557 / Elemento padre: 549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(557)).setAttribute("ancho","150" );
      ((Element)v.get(557)).setAttribute("minimizable","S" );
      ((Element)v.get(557)).setAttribute("minimizada","N" );
      ((Element)v.get(549)).appendChild((Element)v.get(557));
      /* Termina nodo:557   */

      /* Empieza nodo:558 / Elemento padre: 549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(558)).setAttribute("ancho","150" );
      ((Element)v.get(558)).setAttribute("minimizable","S" );
      ((Element)v.get(558)).setAttribute("minimizada","N" );
      ((Element)v.get(549)).appendChild((Element)v.get(558));
      /* Termina nodo:558   */

      /* Empieza nodo:559 / Elemento padre: 549   */
   }

   private void getXML2250(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(559)).setAttribute("ancho","150" );
      ((Element)v.get(559)).setAttribute("minimizable","S" );
      ((Element)v.get(559)).setAttribute("minimizada","N" );
      ((Element)v.get(549)).appendChild((Element)v.get(559));
      /* Termina nodo:559   */

      /* Empieza nodo:560 / Elemento padre: 549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(560)).setAttribute("ancho","150" );
      ((Element)v.get(560)).setAttribute("minimizable","S" );
      ((Element)v.get(560)).setAttribute("minimizada","N" );
      ((Element)v.get(560)).setAttribute("oculta","S" );
      ((Element)v.get(549)).appendChild((Element)v.get(560));
      /* Termina nodo:560   */

      /* Empieza nodo:561 / Elemento padre: 549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(561)).setAttribute("ancho","150" );
      ((Element)v.get(561)).setAttribute("minimizable","S" );
      ((Element)v.get(561)).setAttribute("minimizada","N" );
      ((Element)v.get(561)).setAttribute("oculta","S" );
      ((Element)v.get(549)).appendChild((Element)v.get(561));
      /* Termina nodo:561   */

      /* Empieza nodo:562 / Elemento padre: 549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(562)).setAttribute("ancho","150" );
      ((Element)v.get(562)).setAttribute("minimizable","S" );
      ((Element)v.get(562)).setAttribute("minimizada","N" );
      ((Element)v.get(562)).setAttribute("oculta","S" );
      ((Element)v.get(549)).appendChild((Element)v.get(562));
      /* Termina nodo:562   */

      /* Empieza nodo:563 / Elemento padre: 549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(563)).setAttribute("ancho","150" );
      ((Element)v.get(563)).setAttribute("minimizable","S" );
      ((Element)v.get(563)).setAttribute("minimizada","N" );
      ((Element)v.get(563)).setAttribute("oculta","S" );
      ((Element)v.get(549)).appendChild((Element)v.get(563));
      /* Termina nodo:563   */

      /* Empieza nodo:564 / Elemento padre: 549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(564)).setAttribute("ancho","150" );
      ((Element)v.get(564)).setAttribute("minimizable","S" );
      ((Element)v.get(564)).setAttribute("minimizada","N" );
      ((Element)v.get(564)).setAttribute("oculta","S" );
      ((Element)v.get(549)).appendChild((Element)v.get(564));
      /* Termina nodo:564   */

      /* Empieza nodo:565 / Elemento padre: 549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(565)).setAttribute("ancho","150" );
      ((Element)v.get(565)).setAttribute("minimizable","S" );
      ((Element)v.get(565)).setAttribute("minimizada","N" );
      ((Element)v.get(565)).setAttribute("oculta","S" );
      ((Element)v.get(549)).appendChild((Element)v.get(565));
      /* Termina nodo:565   */

      /* Empieza nodo:566 / Elemento padre: 549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(566)).setAttribute("ancho","150" );
      ((Element)v.get(566)).setAttribute("minimizable","S" );
      ((Element)v.get(566)).setAttribute("minimizada","N" );
      ((Element)v.get(566)).setAttribute("oculta","S" );
      ((Element)v.get(549)).appendChild((Element)v.get(566));
      /* Termina nodo:566   */

      /* Empieza nodo:567 / Elemento padre: 549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(567)).setAttribute("ancho","150" );
      ((Element)v.get(567)).setAttribute("minimizable","S" );
      ((Element)v.get(567)).setAttribute("minimizada","N" );
      ((Element)v.get(567)).setAttribute("oculta","S" );
      ((Element)v.get(549)).appendChild((Element)v.get(567));
      /* Termina nodo:567   */

      /* Empieza nodo:568 / Elemento padre: 549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(568)).setAttribute("ancho","150" );
      ((Element)v.get(568)).setAttribute("minimizable","S" );
      ((Element)v.get(568)).setAttribute("minimizada","N" );
      ((Element)v.get(568)).setAttribute("oculta","S" );
      ((Element)v.get(549)).appendChild((Element)v.get(568));
      /* Termina nodo:568   */

      /* Empieza nodo:569 / Elemento padre: 549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(569)).setAttribute("ancho","150" );
      ((Element)v.get(569)).setAttribute("minimizable","S" );
      ((Element)v.get(569)).setAttribute("minimizada","N" );
      ((Element)v.get(569)).setAttribute("oculta","S" );
      ((Element)v.get(549)).appendChild((Element)v.get(569));
      /* Termina nodo:569   */
      /* Termina nodo:549   */

      /* Empieza nodo:570 / Elemento padre: 540   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(570)).setAttribute("alto","40" );
      ((Element)v.get(570)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(570)).setAttribute("imgFondo","" );
      ((Element)v.get(570)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(570)).setAttribute("ajustarAMitadInf","S" );
      ((Element)v.get(540)).appendChild((Element)v.get(570));

      /* Empieza nodo:571 / Elemento padre: 570   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(571)).setAttribute("colFondo","" );
      ((Element)v.get(571)).setAttribute("ID","EstCab" );
      ((Element)v.get(571)).setAttribute("cod","00335" );
      ((Element)v.get(570)).appendChild((Element)v.get(571));

      /* Empieza nodo:572 / Elemento padre: 571   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(572)).setAttribute("colFondo","" );
      ((Element)v.get(572)).setAttribute("ID","EstCab" );
      ((Element)v.get(572)).setAttribute("cod","2448" );
      ((Element)v.get(571)).appendChild((Element)v.get(572));

      /* Elemento padre:572 / Elemento actual: 573   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(572)).appendChild((Text)v.get(573));

      /* Termina nodo Texto:573   */
      /* Termina nodo:572   */

      /* Empieza nodo:574 / Elemento padre: 571   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(574)).setAttribute("colFondo","" );
      ((Element)v.get(574)).setAttribute("ID","EstCab" );
      ((Element)v.get(574)).setAttribute("cod","1338" );
      ((Element)v.get(571)).appendChild((Element)v.get(574));

      /* Elemento padre:574 / Elemento actual: 575   */
      v.add(doc.createTextNode("Unidad negocio"));
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(574)).appendChild((Text)v.get(575));

      /* Termina nodo Texto:575   */
      /* Termina nodo:574   */

      /* Empieza nodo:576 / Elemento padre: 571   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(576)).setAttribute("colFondo","" );
      ((Element)v.get(576)).setAttribute("ID","EstCab" );
      ((Element)v.get(576)).setAttribute("cod","588" );
      ((Element)v.get(571)).appendChild((Element)v.get(576));

      /* Elemento padre:576 / Elemento actual: 577   */
      v.add(doc.createTextNode("Negocio"));
      ((Element)v.get(576)).appendChild((Text)v.get(577));

      /* Termina nodo Texto:577   */
      /* Termina nodo:576   */

      /* Empieza nodo:578 / Elemento padre: 571   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(578)).setAttribute("colFondo","" );
      ((Element)v.get(578)).setAttribute("ID","EstCab" );
      ((Element)v.get(578)).setAttribute("cod","590" );
      ((Element)v.get(571)).appendChild((Element)v.get(578));

      /* Elemento padre:578 / Elemento actual: 579   */
      v.add(doc.createTextNode("Supergenérico"));
      ((Element)v.get(578)).appendChild((Text)v.get(579));

      /* Termina nodo Texto:579   */
      /* Termina nodo:578   */

      /* Empieza nodo:580 / Elemento padre: 571   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(580)).setAttribute("colFondo","" );
      ((Element)v.get(580)).setAttribute("ID","EstCab" );
      ((Element)v.get(580)).setAttribute("cod","589" );
      ((Element)v.get(571)).appendChild((Element)v.get(580));

      /* Elemento padre:580 / Elemento actual: 581   */
      v.add(doc.createTextNode("Genérico"));
      ((Element)v.get(580)).appendChild((Text)v.get(581));

      /* Termina nodo Texto:581   */
      /* Termina nodo:580   */
      /* Termina nodo:571   */

      /* Empieza nodo:582 / Elemento padre: 570   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(582)).setAttribute("colFondo","" );
      ((Element)v.get(582)).setAttribute("ID","EstCab" );
      ((Element)v.get(582)).setAttribute("cod","00336" );
      ((Element)v.get(570)).appendChild((Element)v.get(582));

      /* Empieza nodo:583 / Elemento padre: 582   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(583)).setAttribute("colFondo","" );
      ((Element)v.get(583)).setAttribute("ID","EstCab" );
      ((Element)v.get(583)).setAttribute("cod","608" );
      ((Element)v.get(582)).appendChild((Element)v.get(583));

      /* Elemento padre:583 / Elemento actual: 584   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(583)).appendChild((Text)v.get(584));

      /* Termina nodo Texto:584   */
      /* Termina nodo:583   */

      /* Empieza nodo:585 / Elemento padre: 582   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(585)).setAttribute("colFondo","" );
      ((Element)v.get(585)).setAttribute("ID","EstCab" );
      ((Element)v.get(585)).setAttribute("cod","581" );
      ((Element)v.get(582)).appendChild((Element)v.get(585));

      /* Elemento padre:585 / Elemento actual: 586   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(585)).appendChild((Text)v.get(586));

      /* Termina nodo Texto:586   */
      /* Termina nodo:585   */
      /* Termina nodo:582   */

      /* Empieza nodo:587 / Elemento padre: 570   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(587)).setAttribute("colFondo","" );
      ((Element)v.get(587)).setAttribute("ID","EstCab" );
      ((Element)v.get(587)).setAttribute("cod","00337" );
      ((Element)v.get(570)).appendChild((Element)v.get(587));

      /* Empieza nodo:588 / Elemento padre: 587   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(588)).setAttribute("colFondo","" );
      ((Element)v.get(588)).setAttribute("ID","EstCab" );
      ((Element)v.get(588)).setAttribute("cod","337" );
      ((Element)v.get(587)).appendChild((Element)v.get(588));

      /* Elemento padre:588 / Elemento actual: 589   */
      v.add(doc.createTextNode("Cód. producto"));
      ((Element)v.get(588)).appendChild((Text)v.get(589));

      /* Termina nodo Texto:589   */
      /* Termina nodo:588   */

      /* Empieza nodo:590 / Elemento padre: 587   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(590)).setAttribute("colFondo","" );
      ((Element)v.get(590)).setAttribute("ID","EstCab" );
      ((Element)v.get(590)).setAttribute("cod","608" );
      ((Element)v.get(587)).appendChild((Element)v.get(590));

      /* Elemento padre:590 / Elemento actual: 591   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(590)).appendChild((Text)v.get(591));

      /* Termina nodo Texto:591   */
      /* Termina nodo:590   */

      /* Empieza nodo:592 / Elemento padre: 587   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(592)).setAttribute("colFondo","" );
      ((Element)v.get(592)).setAttribute("ID","EstCab" );
      ((Element)v.get(592)).setAttribute("cod","581" );
      ((Element)v.get(587)).appendChild((Element)v.get(592));

      /* Elemento padre:592 / Elemento actual: 593   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(592)).appendChild((Text)v.get(593));

      /* Termina nodo Texto:593   */
      /* Termina nodo:592   */
      /* Termina nodo:587   */

      /* Empieza nodo:594 / Elemento padre: 570   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(594)).setAttribute("colFondo","" );
      ((Element)v.get(594)).setAttribute("ID","EstCab" );
      ((Element)v.get(594)).setAttribute("cod","581" );
      ((Element)v.get(570)).appendChild((Element)v.get(594));

      /* Elemento padre:594 / Elemento actual: 595   */
      v.add(doc.createTextNode("oidMarca"));
      ((Element)v.get(594)).appendChild((Text)v.get(595));

      /* Termina nodo Texto:595   */
      /* Termina nodo:594   */

      /* Empieza nodo:596 / Elemento padre: 570   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(596)).setAttribute("colFondo","" );
      ((Element)v.get(596)).setAttribute("ID","EstCab" );
      ((Element)v.get(596)).setAttribute("cod","581" );
      ((Element)v.get(570)).appendChild((Element)v.get(596));

      /* Elemento padre:596 / Elemento actual: 597   */
      v.add(doc.createTextNode("oidUNegocio"));
      ((Element)v.get(596)).appendChild((Text)v.get(597));

      /* Termina nodo Texto:597   */
      /* Termina nodo:596   */

      /* Empieza nodo:598 / Elemento padre: 570   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(598)).setAttribute("colFondo","" );
      ((Element)v.get(598)).setAttribute("ID","EstCab" );
      ((Element)v.get(598)).setAttribute("cod","581" );
      ((Element)v.get(570)).appendChild((Element)v.get(598));

      /* Elemento padre:598 / Elemento actual: 599   */
      v.add(doc.createTextNode("oidNegocio"));
      ((Element)v.get(598)).appendChild((Text)v.get(599));

      /* Termina nodo Texto:599   */
      /* Termina nodo:598   */

      /* Empieza nodo:600 / Elemento padre: 570   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(600)).setAttribute("colFondo","" );
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(600)).setAttribute("ID","EstCab" );
      ((Element)v.get(600)).setAttribute("cod","581" );
      ((Element)v.get(570)).appendChild((Element)v.get(600));

      /* Elemento padre:600 / Elemento actual: 601   */
      v.add(doc.createTextNode("oidSuperGenerico"));
      ((Element)v.get(600)).appendChild((Text)v.get(601));

      /* Termina nodo Texto:601   */
      /* Termina nodo:600   */

      /* Empieza nodo:602 / Elemento padre: 570   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(602)).setAttribute("colFondo","" );
      ((Element)v.get(602)).setAttribute("ID","EstCab" );
      ((Element)v.get(602)).setAttribute("cod","581" );
      ((Element)v.get(570)).appendChild((Element)v.get(602));

      /* Elemento padre:602 / Elemento actual: 603   */
      v.add(doc.createTextNode("oidGenerico"));
      ((Element)v.get(602)).appendChild((Text)v.get(603));

      /* Termina nodo Texto:603   */
      /* Termina nodo:602   */

      /* Empieza nodo:604 / Elemento padre: 570   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(604)).setAttribute("colFondo","" );
      ((Element)v.get(604)).setAttribute("ID","EstCab" );
      ((Element)v.get(604)).setAttribute("cod","581" );
      ((Element)v.get(570)).appendChild((Element)v.get(604));

      /* Elemento padre:604 / Elemento actual: 605   */
      v.add(doc.createTextNode("oidTipoOferta"));
      ((Element)v.get(604)).appendChild((Text)v.get(605));

      /* Termina nodo Texto:605   */
      /* Termina nodo:604   */

      /* Empieza nodo:606 / Elemento padre: 570   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(606)).setAttribute("colFondo","" );
      ((Element)v.get(606)).setAttribute("ID","EstCab" );
      ((Element)v.get(606)).setAttribute("cod","581" );
      ((Element)v.get(570)).appendChild((Element)v.get(606));

      /* Elemento padre:606 / Elemento actual: 607   */
      v.add(doc.createTextNode("oidCicloVida"));
      ((Element)v.get(606)).appendChild((Text)v.get(607));

      /* Termina nodo Texto:607   */
      /* Termina nodo:606   */

      /* Empieza nodo:608 / Elemento padre: 570   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(608)).setAttribute("colFondo","" );
      ((Element)v.get(608)).setAttribute("ID","EstCab" );
      ((Element)v.get(608)).setAttribute("cod","581" );
      ((Element)v.get(570)).appendChild((Element)v.get(608));

      /* Elemento padre:608 / Elemento actual: 609   */
      v.add(doc.createTextNode("oidProducto"));
      ((Element)v.get(608)).appendChild((Text)v.get(609));

      /* Termina nodo Texto:609   */
      /* Termina nodo:608   */

      /* Empieza nodo:610 / Elemento padre: 570   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(610)).setAttribute("colFondo","" );
      ((Element)v.get(610)).setAttribute("ID","EstCab" );
      ((Element)v.get(610)).setAttribute("cod","581" );
      ((Element)v.get(570)).appendChild((Element)v.get(610));

      /* Elemento padre:610 / Elemento actual: 611   */
      v.add(doc.createTextNode("oidTipoOferta"));
      ((Element)v.get(610)).appendChild((Text)v.get(611));

      /* Termina nodo Texto:611   */
      /* Termina nodo:610   */

      /* Empieza nodo:612 / Elemento padre: 570   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(612)).setAttribute("colFondo","" );
      ((Element)v.get(612)).setAttribute("ID","EstCab" );
      ((Element)v.get(612)).setAttribute("cod","581" );
      ((Element)v.get(570)).appendChild((Element)v.get(612));

      /* Elemento padre:612 / Elemento actual: 613   */
      v.add(doc.createTextNode("oidCicloVida"));
      ((Element)v.get(612)).appendChild((Text)v.get(613));

      /* Termina nodo Texto:613   */
      /* Termina nodo:612   */
      /* Termina nodo:570   */

      /* Empieza nodo:614 / Elemento padre: 540   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(614)).setAttribute("alto","22" );
      ((Element)v.get(614)).setAttribute("accion","" );
      ((Element)v.get(614)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(614)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(614)).setAttribute("maxSel","-1" );
      ((Element)v.get(614)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(614)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(614)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(614)).setAttribute("onLoad","" );
      ((Element)v.get(614)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(540)).appendChild((Element)v.get(614));

      /* Empieza nodo:615 / Elemento padre: 614   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(615)).setAttribute("tipo","texto" );
      ((Element)v.get(615)).setAttribute("ID","EstDat" );
      ((Element)v.get(614)).appendChild((Element)v.get(615));
      /* Termina nodo:615   */

      /* Empieza nodo:616 / Elemento padre: 614   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(616)).setAttribute("tipo","texto" );
      ((Element)v.get(616)).setAttribute("ID","EstDat2" );
      ((Element)v.get(614)).appendChild((Element)v.get(616));
      /* Termina nodo:616   */

      /* Empieza nodo:617 / Elemento padre: 614   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(617)).setAttribute("tipo","texto" );
      ((Element)v.get(617)).setAttribute("ID","EstDat" );
      ((Element)v.get(614)).appendChild((Element)v.get(617));
      /* Termina nodo:617   */

      /* Empieza nodo:618 / Elemento padre: 614   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(618)).setAttribute("tipo","texto" );
      ((Element)v.get(618)).setAttribute("ID","EstDat2" );
      ((Element)v.get(614)).appendChild((Element)v.get(618));
      /* Termina nodo:618   */

      /* Empieza nodo:619 / Elemento padre: 614   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(619)).setAttribute("tipo","texto" );
      ((Element)v.get(619)).setAttribute("ID","EstDat" );
      ((Element)v.get(614)).appendChild((Element)v.get(619));
      /* Termina nodo:619   */

      /* Empieza nodo:620 / Elemento padre: 614   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(620)).setAttribute("tipo","texto" );
      ((Element)v.get(620)).setAttribute("ID","EstDat2" );
      ((Element)v.get(614)).appendChild((Element)v.get(620));
      /* Termina nodo:620   */

      /* Empieza nodo:621 / Elemento padre: 614   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(621)).setAttribute("tipo","texto" );
      ((Element)v.get(621)).setAttribute("ID","EstDat" );
      ((Element)v.get(614)).appendChild((Element)v.get(621));
      /* Termina nodo:621   */

      /* Empieza nodo:622 / Elemento padre: 614   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(622)).setAttribute("tipo","texto" );
      ((Element)v.get(622)).setAttribute("ID","EstDat2" );
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(614)).appendChild((Element)v.get(622));
      /* Termina nodo:622   */

      /* Empieza nodo:623 / Elemento padre: 614   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(623)).setAttribute("tipo","texto" );
      ((Element)v.get(623)).setAttribute("ID","EstDat" );
      ((Element)v.get(614)).appendChild((Element)v.get(623));
      /* Termina nodo:623   */

      /* Empieza nodo:624 / Elemento padre: 614   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(624)).setAttribute("tipo","texto" );
      ((Element)v.get(624)).setAttribute("ID","EstDat2" );
      ((Element)v.get(614)).appendChild((Element)v.get(624));
      /* Termina nodo:624   */

      /* Empieza nodo:625 / Elemento padre: 614   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(625)).setAttribute("tipo","texto" );
      ((Element)v.get(625)).setAttribute("ID","EstDat2" );
      ((Element)v.get(614)).appendChild((Element)v.get(625));
      /* Termina nodo:625   */

      /* Empieza nodo:626 / Elemento padre: 614   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(626)).setAttribute("tipo","texto" );
      ((Element)v.get(626)).setAttribute("ID","EstDat2" );
      ((Element)v.get(614)).appendChild((Element)v.get(626));
      /* Termina nodo:626   */

      /* Empieza nodo:627 / Elemento padre: 614   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(627)).setAttribute("tipo","texto" );
      ((Element)v.get(627)).setAttribute("ID","EstDat2" );
      ((Element)v.get(614)).appendChild((Element)v.get(627));
      /* Termina nodo:627   */

      /* Empieza nodo:628 / Elemento padre: 614   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(628)).setAttribute("tipo","texto" );
      ((Element)v.get(628)).setAttribute("ID","EstDat2" );
      ((Element)v.get(614)).appendChild((Element)v.get(628));
      /* Termina nodo:628   */

      /* Empieza nodo:629 / Elemento padre: 614   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(629)).setAttribute("tipo","texto" );
      ((Element)v.get(629)).setAttribute("ID","EstDat2" );
      ((Element)v.get(614)).appendChild((Element)v.get(629));
      /* Termina nodo:629   */

      /* Empieza nodo:630 / Elemento padre: 614   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(630)).setAttribute("tipo","texto" );
      ((Element)v.get(630)).setAttribute("ID","EstDat2" );
      ((Element)v.get(614)).appendChild((Element)v.get(630));
      /* Termina nodo:630   */

      /* Empieza nodo:631 / Elemento padre: 614   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(631)).setAttribute("tipo","texto" );
      ((Element)v.get(631)).setAttribute("ID","EstDat2" );
      ((Element)v.get(614)).appendChild((Element)v.get(631));
      /* Termina nodo:631   */

      /* Empieza nodo:632 / Elemento padre: 614   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(632)).setAttribute("tipo","texto" );
      ((Element)v.get(632)).setAttribute("ID","EstDat2" );
      ((Element)v.get(614)).appendChild((Element)v.get(632));
      /* Termina nodo:632   */

      /* Empieza nodo:633 / Elemento padre: 614   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(633)).setAttribute("tipo","texto" );
      ((Element)v.get(633)).setAttribute("ID","EstDat2" );
      ((Element)v.get(614)).appendChild((Element)v.get(633));
      /* Termina nodo:633   */

      /* Empieza nodo:634 / Elemento padre: 614   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(634)).setAttribute("tipo","texto" );
      ((Element)v.get(634)).setAttribute("ID","EstDat2" );
      ((Element)v.get(614)).appendChild((Element)v.get(634));
      /* Termina nodo:634   */
      /* Termina nodo:614   */

      /* Empieza nodo:635 / Elemento padre: 540   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(540)).appendChild((Element)v.get(635));
      /* Termina nodo:635   */

      /* Empieza nodo:636 / Elemento padre: 540   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(636)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(636)).setAttribute("ancho","504" );
      ((Element)v.get(636)).setAttribute("sep","$" );
      ((Element)v.get(636)).setAttribute("x","12" );
      ((Element)v.get(636)).setAttribute("class","botonera" );
      ((Element)v.get(636)).setAttribute("y","753" );
      ((Element)v.get(636)).setAttribute("control","|" );
      ((Element)v.get(636)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(636)).setAttribute("rowset","" );
      ((Element)v.get(636)).setAttribute("cargainicial","N" );
      ((Element)v.get(540)).appendChild((Element)v.get(636));

      /* Empieza nodo:637 / Elemento padre: 636   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(637)).setAttribute("nombre","ret1" );
      ((Element)v.get(637)).setAttribute("x","37" );
      ((Element)v.get(637)).setAttribute("y","757" );
      ((Element)v.get(637)).setAttribute("ID","botonContenido" );
      ((Element)v.get(637)).setAttribute("img","retroceder_on" );
      ((Element)v.get(637)).setAttribute("tipo","0" );
      ((Element)v.get(637)).setAttribute("estado","false" );
      ((Element)v.get(637)).setAttribute("alt","" );
      ((Element)v.get(637)).setAttribute("codigo","" );
      ((Element)v.get(637)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(636)).appendChild((Element)v.get(637));
      /* Termina nodo:637   */

      /* Empieza nodo:638 / Elemento padre: 636   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(638)).setAttribute("nombre","ava1" );
      ((Element)v.get(638)).setAttribute("x","52" );
      ((Element)v.get(638)).setAttribute("y","757" );
      ((Element)v.get(638)).setAttribute("ID","botonContenido" );
      ((Element)v.get(638)).setAttribute("img","avanzar_on" );
      ((Element)v.get(638)).setAttribute("tipo","0" );
      ((Element)v.get(638)).setAttribute("estado","false" );
      ((Element)v.get(638)).setAttribute("alt","" );
      ((Element)v.get(638)).setAttribute("codigo","" );
      ((Element)v.get(638)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(636)).appendChild((Element)v.get(638));
      /* Termina nodo:638   */
      /* Termina nodo:636   */
      /* Termina nodo:540   */

      /* Empieza nodo:639 / Elemento padre: 14   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(639)).setAttribute("nombre","primera1" );
      ((Element)v.get(639)).setAttribute("x","20" );
   }

   private void getXML2610(Document doc) {
      ((Element)v.get(639)).setAttribute("y","757" );
      ((Element)v.get(639)).setAttribute("ID","botonContenido" );
      ((Element)v.get(639)).setAttribute("img","primera_on" );
      ((Element)v.get(639)).setAttribute("tipo","0" );
      ((Element)v.get(639)).setAttribute("estado","false" );
      ((Element)v.get(639)).setAttribute("alt","" );
      ((Element)v.get(639)).setAttribute("codigo","" );
      ((Element)v.get(639)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(14)).appendChild((Element)v.get(639));
      /* Termina nodo:639   */

      /* Empieza nodo:640 / Elemento padre: 14   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(640)).setAttribute("nombre","separa" );
      ((Element)v.get(640)).setAttribute("x","59" );
      ((Element)v.get(640)).setAttribute("y","753" );
      ((Element)v.get(640)).setAttribute("ID","botonContenido" );
      ((Element)v.get(640)).setAttribute("img","separa_base" );
      ((Element)v.get(640)).setAttribute("tipo","0" );
      ((Element)v.get(640)).setAttribute("estado","false" );
      ((Element)v.get(640)).setAttribute("alt","" );
      ((Element)v.get(640)).setAttribute("codigo","" );
      ((Element)v.get(640)).setAttribute("accion","" );
      ((Element)v.get(14)).appendChild((Element)v.get(640));
      /* Termina nodo:640   */

      /* Empieza nodo:641 / Elemento padre: 14   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(641)).setAttribute("nombre","listado2" );
      ((Element)v.get(641)).setAttribute("ancho","632" );
      ((Element)v.get(641)).setAttribute("alto","345" );
      ((Element)v.get(641)).setAttribute("x","12" );
      ((Element)v.get(641)).setAttribute("y","409" );
      ((Element)v.get(641)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(641)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(14)).appendChild((Element)v.get(641));

      /* Empieza nodo:642 / Elemento padre: 641   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(642)).setAttribute("precarga","S" );
      ((Element)v.get(642)).setAttribute("conROver","S" );
      ((Element)v.get(641)).appendChild((Element)v.get(642));

      /* Empieza nodo:643 / Elemento padre: 642   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(643)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(643)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(643)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(643)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(642)).appendChild((Element)v.get(643));
      /* Termina nodo:643   */

      /* Empieza nodo:644 / Elemento padre: 642   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(644)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(644)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(644)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(644)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(642)).appendChild((Element)v.get(644));
      /* Termina nodo:644   */

      /* Empieza nodo:645 / Elemento padre: 642   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(645)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(645)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(642)).appendChild((Element)v.get(645));
      /* Termina nodo:645   */
      /* Termina nodo:642   */

      /* Empieza nodo:646 / Elemento padre: 641   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(641)).appendChild((Element)v.get(646));

      /* Empieza nodo:647 / Elemento padre: 646   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(647)).setAttribute("borde","1" );
      ((Element)v.get(647)).setAttribute("horizDatos","1" );
      ((Element)v.get(647)).setAttribute("horizCabecera","1" );
      ((Element)v.get(647)).setAttribute("vertical","1" );
      ((Element)v.get(647)).setAttribute("horizTitulo","1" );
      ((Element)v.get(647)).setAttribute("horizBase","1" );
      ((Element)v.get(646)).appendChild((Element)v.get(647));
      /* Termina nodo:647   */

      /* Empieza nodo:648 / Elemento padre: 646   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(648)).setAttribute("borde","#999999" );
      ((Element)v.get(648)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(648)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(648)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(648)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(648)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(648)).setAttribute("horizBase","#999999" );
      ((Element)v.get(646)).appendChild((Element)v.get(648));
      /* Termina nodo:648   */
      /* Termina nodo:646   */

      /* Empieza nodo:649 / Elemento padre: 641   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(649)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(649)).setAttribute("alto","22" );
      ((Element)v.get(649)).setAttribute("imgFondo","" );
      ((Element)v.get(649)).setAttribute("cod","00339" );
      ((Element)v.get(649)).setAttribute("ID","datosTitle" );
      ((Element)v.get(641)).appendChild((Element)v.get(649));
      /* Termina nodo:649   */

      /* Empieza nodo:650 / Elemento padre: 641   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(650)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(650)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(650)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(650)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(650)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(650)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(641)).appendChild((Element)v.get(650));

      /* Empieza nodo:651 / Elemento padre: 650   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(651)).setAttribute("ancho","150" );
      ((Element)v.get(651)).setAttribute("minimizable","S" );
      ((Element)v.get(651)).setAttribute("minimizada","N" );
      ((Element)v.get(650)).appendChild((Element)v.get(651));
      /* Termina nodo:651   */

      /* Empieza nodo:652 / Elemento padre: 650   */
      v.add(doc.createElement("COL"));
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(652)).setAttribute("ancho","150" );
      ((Element)v.get(652)).setAttribute("minimizable","S" );
      ((Element)v.get(652)).setAttribute("minimizada","N" );
      ((Element)v.get(650)).appendChild((Element)v.get(652));
      /* Termina nodo:652   */

      /* Empieza nodo:653 / Elemento padre: 650   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(653)).setAttribute("ancho","150" );
      ((Element)v.get(653)).setAttribute("minimizable","S" );
      ((Element)v.get(653)).setAttribute("minimizada","N" );
      ((Element)v.get(650)).appendChild((Element)v.get(653));
      /* Termina nodo:653   */

      /* Empieza nodo:654 / Elemento padre: 650   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(654)).setAttribute("ancho","150" );
      ((Element)v.get(654)).setAttribute("minimizable","S" );
      ((Element)v.get(654)).setAttribute("minimizada","N" );
      ((Element)v.get(650)).appendChild((Element)v.get(654));
      /* Termina nodo:654   */

      /* Empieza nodo:655 / Elemento padre: 650   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(655)).setAttribute("ancho","150" );
      ((Element)v.get(655)).setAttribute("minimizable","S" );
      ((Element)v.get(655)).setAttribute("minimizada","N" );
      ((Element)v.get(650)).appendChild((Element)v.get(655));
      /* Termina nodo:655   */

      /* Empieza nodo:656 / Elemento padre: 650   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(656)).setAttribute("ancho","150" );
      ((Element)v.get(656)).setAttribute("minimizable","S" );
      ((Element)v.get(656)).setAttribute("minimizada","N" );
      ((Element)v.get(650)).appendChild((Element)v.get(656));
      /* Termina nodo:656   */

      /* Empieza nodo:657 / Elemento padre: 650   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(657)).setAttribute("ancho","150" );
      ((Element)v.get(657)).setAttribute("minimizable","S" );
      ((Element)v.get(657)).setAttribute("minimizada","N" );
      ((Element)v.get(650)).appendChild((Element)v.get(657));
      /* Termina nodo:657   */

      /* Empieza nodo:658 / Elemento padre: 650   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(658)).setAttribute("ancho","150" );
      ((Element)v.get(658)).setAttribute("minimizable","S" );
      ((Element)v.get(658)).setAttribute("minimizada","N" );
      ((Element)v.get(650)).appendChild((Element)v.get(658));
      /* Termina nodo:658   */

      /* Empieza nodo:659 / Elemento padre: 650   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(659)).setAttribute("ancho","150" );
      ((Element)v.get(659)).setAttribute("minimizable","S" );
      ((Element)v.get(659)).setAttribute("minimizada","N" );
      ((Element)v.get(650)).appendChild((Element)v.get(659));
      /* Termina nodo:659   */

      /* Empieza nodo:660 / Elemento padre: 650   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(660)).setAttribute("ancho","150" );
      ((Element)v.get(660)).setAttribute("minimizable","S" );
      ((Element)v.get(660)).setAttribute("minimizada","N" );
      ((Element)v.get(650)).appendChild((Element)v.get(660));
      /* Termina nodo:660   */

      /* Empieza nodo:661 / Elemento padre: 650   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(661)).setAttribute("ancho","150" );
      ((Element)v.get(661)).setAttribute("minimizable","S" );
      ((Element)v.get(661)).setAttribute("minimizada","N" );
      ((Element)v.get(650)).appendChild((Element)v.get(661));
      /* Termina nodo:661   */

      /* Empieza nodo:662 / Elemento padre: 650   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(662)).setAttribute("ancho","150" );
      ((Element)v.get(662)).setAttribute("minimizable","S" );
      ((Element)v.get(662)).setAttribute("minimizada","N" );
      ((Element)v.get(650)).appendChild((Element)v.get(662));
      /* Termina nodo:662   */

      /* Empieza nodo:663 / Elemento padre: 650   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(663)).setAttribute("ancho","150" );
      ((Element)v.get(663)).setAttribute("minimizable","S" );
      ((Element)v.get(663)).setAttribute("minimizada","N" );
      ((Element)v.get(663)).setAttribute("oculta","S" );
      ((Element)v.get(650)).appendChild((Element)v.get(663));
      /* Termina nodo:663   */

      /* Empieza nodo:664 / Elemento padre: 650   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(664)).setAttribute("ancho","150" );
      ((Element)v.get(664)).setAttribute("minimizable","S" );
      ((Element)v.get(664)).setAttribute("minimizada","N" );
      ((Element)v.get(664)).setAttribute("oculta","S" );
      ((Element)v.get(650)).appendChild((Element)v.get(664));
      /* Termina nodo:664   */

      /* Empieza nodo:665 / Elemento padre: 650   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(665)).setAttribute("ancho","150" );
      ((Element)v.get(665)).setAttribute("minimizable","S" );
      ((Element)v.get(665)).setAttribute("minimizada","N" );
      ((Element)v.get(665)).setAttribute("oculta","S" );
      ((Element)v.get(650)).appendChild((Element)v.get(665));
      /* Termina nodo:665   */

      /* Empieza nodo:666 / Elemento padre: 650   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(666)).setAttribute("ancho","150" );
      ((Element)v.get(666)).setAttribute("minimizable","S" );
      ((Element)v.get(666)).setAttribute("minimizada","N" );
      ((Element)v.get(666)).setAttribute("oculta","S" );
      ((Element)v.get(650)).appendChild((Element)v.get(666));
      /* Termina nodo:666   */

      /* Empieza nodo:667 / Elemento padre: 650   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(667)).setAttribute("ancho","150" );
      ((Element)v.get(667)).setAttribute("minimizable","S" );
      ((Element)v.get(667)).setAttribute("minimizada","N" );
      ((Element)v.get(667)).setAttribute("oculta","S" );
      ((Element)v.get(650)).appendChild((Element)v.get(667));
      /* Termina nodo:667   */

      /* Empieza nodo:668 / Elemento padre: 650   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(668)).setAttribute("ancho","150" );
      ((Element)v.get(668)).setAttribute("minimizable","S" );
      ((Element)v.get(668)).setAttribute("minimizada","N" );
      ((Element)v.get(668)).setAttribute("oculta","S" );
      ((Element)v.get(650)).appendChild((Element)v.get(668));
      /* Termina nodo:668   */

      /* Empieza nodo:669 / Elemento padre: 650   */
   }

   private void getXML2790(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(669)).setAttribute("ancho","150" );
      ((Element)v.get(669)).setAttribute("minimizable","S" );
      ((Element)v.get(669)).setAttribute("minimizada","N" );
      ((Element)v.get(669)).setAttribute("oculta","S" );
      ((Element)v.get(650)).appendChild((Element)v.get(669));
      /* Termina nodo:669   */

      /* Empieza nodo:670 / Elemento padre: 650   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(670)).setAttribute("ancho","150" );
      ((Element)v.get(670)).setAttribute("minimizable","S" );
      ((Element)v.get(670)).setAttribute("minimizada","N" );
      ((Element)v.get(670)).setAttribute("oculta","S" );
      ((Element)v.get(650)).appendChild((Element)v.get(670));
      /* Termina nodo:670   */

      /* Empieza nodo:671 / Elemento padre: 650   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(671)).setAttribute("ancho","150" );
      ((Element)v.get(671)).setAttribute("minimizable","S" );
      ((Element)v.get(671)).setAttribute("minimizada","N" );
      ((Element)v.get(671)).setAttribute("oculta","S" );
      ((Element)v.get(650)).appendChild((Element)v.get(671));
      /* Termina nodo:671   */

      /* Empieza nodo:672 / Elemento padre: 650   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(672)).setAttribute("ancho","150" );
      ((Element)v.get(672)).setAttribute("minimizable","S" );
      ((Element)v.get(672)).setAttribute("minimizada","N" );
      ((Element)v.get(672)).setAttribute("oculta","S" );
      ((Element)v.get(650)).appendChild((Element)v.get(672));
      /* Termina nodo:672   */

      /* Empieza nodo:673 / Elemento padre: 650   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(673)).setAttribute("ancho","150" );
      ((Element)v.get(673)).setAttribute("minimizable","S" );
      ((Element)v.get(673)).setAttribute("minimizada","N" );
      ((Element)v.get(673)).setAttribute("oculta","S" );
      ((Element)v.get(650)).appendChild((Element)v.get(673));
      /* Termina nodo:673   */

      /* Empieza nodo:674 / Elemento padre: 650   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(674)).setAttribute("ancho","150" );
      ((Element)v.get(674)).setAttribute("minimizable","S" );
      ((Element)v.get(674)).setAttribute("minimizada","N" );
      ((Element)v.get(674)).setAttribute("oculta","S" );
      ((Element)v.get(650)).appendChild((Element)v.get(674));
      /* Termina nodo:674   */
      /* Termina nodo:650   */

      /* Empieza nodo:675 / Elemento padre: 641   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(675)).setAttribute("alto","40" );
      ((Element)v.get(675)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(675)).setAttribute("imgFondo","" );
      ((Element)v.get(675)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(675)).setAttribute("ajustarAMitadInf","S" );
      ((Element)v.get(641)).appendChild((Element)v.get(675));

      /* Empieza nodo:676 / Elemento padre: 675   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(676)).setAttribute("colFondo","" );
      ((Element)v.get(676)).setAttribute("ID","EstCab" );
      ((Element)v.get(676)).setAttribute("cod","00335" );
      ((Element)v.get(675)).appendChild((Element)v.get(676));

      /* Empieza nodo:677 / Elemento padre: 676   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(677)).setAttribute("colFondo","" );
      ((Element)v.get(677)).setAttribute("ID","EstCab" );
      ((Element)v.get(677)).setAttribute("cod","2448" );
      ((Element)v.get(676)).appendChild((Element)v.get(677));

      /* Elemento padre:677 / Elemento actual: 678   */
      v.add(doc.createTextNode("Marca Producto"));
      ((Element)v.get(677)).appendChild((Text)v.get(678));

      /* Termina nodo Texto:678   */
      /* Termina nodo:677   */

      /* Empieza nodo:679 / Elemento padre: 676   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(679)).setAttribute("colFondo","" );
      ((Element)v.get(679)).setAttribute("ID","EstCab" );
      ((Element)v.get(679)).setAttribute("cod","1338" );
      ((Element)v.get(676)).appendChild((Element)v.get(679));

      /* Elemento padre:679 / Elemento actual: 680   */
      v.add(doc.createTextNode("Unidad negocio"));
      ((Element)v.get(679)).appendChild((Text)v.get(680));

      /* Termina nodo Texto:680   */
      /* Termina nodo:679   */

      /* Empieza nodo:681 / Elemento padre: 676   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(681)).setAttribute("colFondo","" );
      ((Element)v.get(681)).setAttribute("ID","EstCab" );
      ((Element)v.get(681)).setAttribute("cod","588" );
      ((Element)v.get(676)).appendChild((Element)v.get(681));

      /* Elemento padre:681 / Elemento actual: 682   */
      v.add(doc.createTextNode("Negocio"));
      ((Element)v.get(681)).appendChild((Text)v.get(682));

      /* Termina nodo Texto:682   */
      /* Termina nodo:681   */

      /* Empieza nodo:683 / Elemento padre: 676   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(683)).setAttribute("colFondo","" );
      ((Element)v.get(683)).setAttribute("ID","EstCab" );
      ((Element)v.get(683)).setAttribute("cod","590" );
      ((Element)v.get(676)).appendChild((Element)v.get(683));

      /* Elemento padre:683 / Elemento actual: 684   */
      v.add(doc.createTextNode("Supergenérico"));
      ((Element)v.get(683)).appendChild((Text)v.get(684));

      /* Termina nodo Texto:684   */
      /* Termina nodo:683   */

      /* Empieza nodo:685 / Elemento padre: 676   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(685)).setAttribute("colFondo","" );
      ((Element)v.get(685)).setAttribute("ID","EstCab" );
      ((Element)v.get(685)).setAttribute("cod","589" );
      ((Element)v.get(676)).appendChild((Element)v.get(685));

      /* Elemento padre:685 / Elemento actual: 686   */
      v.add(doc.createTextNode("Genérico"));
      ((Element)v.get(685)).appendChild((Text)v.get(686));

      /* Termina nodo Texto:686   */
      /* Termina nodo:685   */
      /* Termina nodo:676   */

      /* Empieza nodo:687 / Elemento padre: 675   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(687)).setAttribute("colFondo","" );
      ((Element)v.get(687)).setAttribute("ID","EstCab" );
      ((Element)v.get(687)).setAttribute("cod","00336" );
      ((Element)v.get(675)).appendChild((Element)v.get(687));

      /* Empieza nodo:688 / Elemento padre: 687   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(688)).setAttribute("colFondo","" );
   }

   private void getXML2880(Document doc) {
      ((Element)v.get(688)).setAttribute("ID","EstCab" );
      ((Element)v.get(688)).setAttribute("cod","608" );
      ((Element)v.get(687)).appendChild((Element)v.get(688));

      /* Elemento padre:688 / Elemento actual: 689   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(688)).appendChild((Text)v.get(689));

      /* Termina nodo Texto:689   */
      /* Termina nodo:688   */

      /* Empieza nodo:690 / Elemento padre: 687   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(690)).setAttribute("colFondo","" );
      ((Element)v.get(690)).setAttribute("ID","EstCab" );
      ((Element)v.get(690)).setAttribute("cod","581" );
      ((Element)v.get(687)).appendChild((Element)v.get(690));

      /* Elemento padre:690 / Elemento actual: 691   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(690)).appendChild((Text)v.get(691));

      /* Termina nodo Texto:691   */
      /* Termina nodo:690   */
      /* Termina nodo:687   */

      /* Empieza nodo:692 / Elemento padre: 675   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(692)).setAttribute("colFondo","" );
      ((Element)v.get(692)).setAttribute("ID","EstCab" );
      ((Element)v.get(692)).setAttribute("cod","00337" );
      ((Element)v.get(675)).appendChild((Element)v.get(692));

      /* Empieza nodo:693 / Elemento padre: 692   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(693)).setAttribute("colFondo","" );
      ((Element)v.get(693)).setAttribute("ID","EstCab" );
      ((Element)v.get(693)).setAttribute("cod","337" );
      ((Element)v.get(692)).appendChild((Element)v.get(693));

      /* Elemento padre:693 / Elemento actual: 694   */
      v.add(doc.createTextNode("Cód. producto"));
      ((Element)v.get(693)).appendChild((Text)v.get(694));

      /* Termina nodo Texto:694   */
      /* Termina nodo:693   */

      /* Empieza nodo:695 / Elemento padre: 692   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(695)).setAttribute("colFondo","" );
      ((Element)v.get(695)).setAttribute("ID","EstCab" );
      ((Element)v.get(695)).setAttribute("cod","608" );
      ((Element)v.get(692)).appendChild((Element)v.get(695));

      /* Elemento padre:695 / Elemento actual: 696   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(695)).appendChild((Text)v.get(696));

      /* Termina nodo Texto:696   */
      /* Termina nodo:695   */

      /* Empieza nodo:697 / Elemento padre: 692   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(697)).setAttribute("colFondo","" );
      ((Element)v.get(697)).setAttribute("ID","EstCab" );
      ((Element)v.get(697)).setAttribute("cod","581" );
      ((Element)v.get(692)).appendChild((Element)v.get(697));

      /* Elemento padre:697 / Elemento actual: 698   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(697)).appendChild((Text)v.get(698));

      /* Termina nodo Texto:698   */
      /* Termina nodo:697   */
      /* Termina nodo:692   */

      /* Empieza nodo:699 / Elemento padre: 675   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(699)).setAttribute("colFondo","" );
      ((Element)v.get(699)).setAttribute("ID","EstCab" );
      ((Element)v.get(699)).setAttribute("cod","1175" );
      ((Element)v.get(675)).appendChild((Element)v.get(699));

      /* Elemento padre:699 / Elemento actual: 700   */
      v.add(doc.createTextNode("Período desde"));
      ((Element)v.get(699)).appendChild((Text)v.get(700));

      /* Termina nodo Texto:700   */
      /* Termina nodo:699   */

      /* Empieza nodo:701 / Elemento padre: 675   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(701)).setAttribute("colFondo","" );
      ((Element)v.get(701)).setAttribute("ID","EstCab" );
      ((Element)v.get(701)).setAttribute("cod","1176" );
      ((Element)v.get(675)).appendChild((Element)v.get(701));

      /* Elemento padre:701 / Elemento actual: 702   */
      v.add(doc.createTextNode("Período hasta"));
      ((Element)v.get(701)).appendChild((Text)v.get(702));

      /* Termina nodo Texto:702   */
      /* Termina nodo:701   */

      /* Empieza nodo:703 / Elemento padre: 675   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(703)).setAttribute("colFondo","" );
      ((Element)v.get(703)).setAttribute("ID","EstCab" );
      ((Element)v.get(703)).setAttribute("cod","2448" );
      ((Element)v.get(675)).appendChild((Element)v.get(703));

      /* Elemento padre:703 / Elemento actual: 704   */
      v.add(doc.createTextNode("oidMarca Producto"));
      ((Element)v.get(703)).appendChild((Text)v.get(704));

      /* Termina nodo Texto:704   */
      /* Termina nodo:703   */

      /* Empieza nodo:705 / Elemento padre: 675   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(705)).setAttribute("colFondo","" );
      ((Element)v.get(705)).setAttribute("ID","EstCab" );
      ((Element)v.get(705)).setAttribute("cod","1338" );
      ((Element)v.get(675)).appendChild((Element)v.get(705));

      /* Elemento padre:705 / Elemento actual: 706   */
      v.add(doc.createTextNode("oidUnidad negocio"));
      ((Element)v.get(705)).appendChild((Text)v.get(706));

      /* Termina nodo Texto:706   */
      /* Termina nodo:705   */

      /* Empieza nodo:707 / Elemento padre: 675   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(707)).setAttribute("colFondo","" );
      ((Element)v.get(707)).setAttribute("ID","EstCab" );
      ((Element)v.get(707)).setAttribute("cod","588" );
      ((Element)v.get(675)).appendChild((Element)v.get(707));

      /* Elemento padre:707 / Elemento actual: 708   */
      v.add(doc.createTextNode("oidNegocio"));
      ((Element)v.get(707)).appendChild((Text)v.get(708));

      /* Termina nodo Texto:708   */
      /* Termina nodo:707   */

      /* Empieza nodo:709 / Elemento padre: 675   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(709)).setAttribute("colFondo","" );
      ((Element)v.get(709)).setAttribute("ID","EstCab" );
      ((Element)v.get(709)).setAttribute("cod","590" );
      ((Element)v.get(675)).appendChild((Element)v.get(709));

      /* Elemento padre:709 / Elemento actual: 710   */
      v.add(doc.createTextNode("oidSupergenérico"));
      ((Element)v.get(709)).appendChild((Text)v.get(710));

      /* Termina nodo Texto:710   */
      /* Termina nodo:709   */

      /* Empieza nodo:711 / Elemento padre: 675   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(711)).setAttribute("colFondo","" );
      ((Element)v.get(711)).setAttribute("ID","EstCab" );
      ((Element)v.get(711)).setAttribute("cod","589" );
      ((Element)v.get(675)).appendChild((Element)v.get(711));

      /* Elemento padre:711 / Elemento actual: 712   */
      v.add(doc.createTextNode("oidGenérico"));
      ((Element)v.get(711)).appendChild((Text)v.get(712));

      /* Termina nodo Texto:712   */
      /* Termina nodo:711   */

      /* Empieza nodo:713 / Elemento padre: 675   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(713)).setAttribute("colFondo","" );
      ((Element)v.get(713)).setAttribute("ID","EstCab" );
   }

   private void getXML2970(Document doc) {
      ((Element)v.get(713)).setAttribute("cod","608" );
      ((Element)v.get(675)).appendChild((Element)v.get(713));

      /* Elemento padre:713 / Elemento actual: 714   */
      v.add(doc.createTextNode("oidTipo oferta"));
      ((Element)v.get(713)).appendChild((Text)v.get(714));

      /* Termina nodo Texto:714   */
      /* Termina nodo:713   */

      /* Empieza nodo:715 / Elemento padre: 675   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(715)).setAttribute("colFondo","" );
      ((Element)v.get(715)).setAttribute("ID","EstCab" );
      ((Element)v.get(715)).setAttribute("cod","581" );
      ((Element)v.get(675)).appendChild((Element)v.get(715));

      /* Elemento padre:715 / Elemento actual: 716   */
      v.add(doc.createTextNode("oidCiclo vida"));
      ((Element)v.get(715)).appendChild((Text)v.get(716));

      /* Termina nodo Texto:716   */
      /* Termina nodo:715   */

      /* Empieza nodo:717 / Elemento padre: 675   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(717)).setAttribute("colFondo","" );
      ((Element)v.get(717)).setAttribute("ID","EstCab" );
      ((Element)v.get(717)).setAttribute("cod","337" );
      ((Element)v.get(675)).appendChild((Element)v.get(717));

      /* Elemento padre:717 / Elemento actual: 718   */
      v.add(doc.createTextNode("oidCód. producto"));
      ((Element)v.get(717)).appendChild((Text)v.get(718));

      /* Termina nodo Texto:718   */
      /* Termina nodo:717   */

      /* Empieza nodo:719 / Elemento padre: 675   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(719)).setAttribute("colFondo","" );
      ((Element)v.get(719)).setAttribute("ID","EstCab" );
      ((Element)v.get(719)).setAttribute("cod","608" );
      ((Element)v.get(675)).appendChild((Element)v.get(719));

      /* Elemento padre:719 / Elemento actual: 720   */
      v.add(doc.createTextNode("oidTipo oferta"));
      ((Element)v.get(719)).appendChild((Text)v.get(720));

      /* Termina nodo Texto:720   */
      /* Termina nodo:719   */

      /* Empieza nodo:721 / Elemento padre: 675   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(721)).setAttribute("colFondo","" );
      ((Element)v.get(721)).setAttribute("ID","EstCab" );
      ((Element)v.get(721)).setAttribute("cod","581" );
      ((Element)v.get(675)).appendChild((Element)v.get(721));

      /* Elemento padre:721 / Elemento actual: 722   */
      v.add(doc.createTextNode("oidCiclo vida"));
      ((Element)v.get(721)).appendChild((Text)v.get(722));

      /* Termina nodo Texto:722   */
      /* Termina nodo:721   */

      /* Empieza nodo:723 / Elemento padre: 675   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(723)).setAttribute("colFondo","" );
      ((Element)v.get(723)).setAttribute("ID","EstCab" );
      ((Element)v.get(723)).setAttribute("cod","1175" );
      ((Element)v.get(675)).appendChild((Element)v.get(723));

      /* Elemento padre:723 / Elemento actual: 724   */
      v.add(doc.createTextNode("oidPeríodo desde"));
      ((Element)v.get(723)).appendChild((Text)v.get(724));

      /* Termina nodo Texto:724   */
      /* Termina nodo:723   */

      /* Empieza nodo:725 / Elemento padre: 675   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(725)).setAttribute("colFondo","" );
      ((Element)v.get(725)).setAttribute("ID","EstCab" );
      ((Element)v.get(725)).setAttribute("cod","1176" );
      ((Element)v.get(675)).appendChild((Element)v.get(725));

      /* Elemento padre:725 / Elemento actual: 726   */
      v.add(doc.createTextNode("oidPeríodo hasta"));
      ((Element)v.get(725)).appendChild((Text)v.get(726));

      /* Termina nodo Texto:726   */
      /* Termina nodo:725   */
      /* Termina nodo:675   */

      /* Empieza nodo:727 / Elemento padre: 641   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(727)).setAttribute("alto","22" );
      ((Element)v.get(727)).setAttribute("accion","" );
      ((Element)v.get(727)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(727)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(727)).setAttribute("maxSel","-1" );
      ((Element)v.get(727)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(727)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(727)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(727)).setAttribute("onLoad","" );
      ((Element)v.get(727)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(641)).appendChild((Element)v.get(727));

      /* Empieza nodo:728 / Elemento padre: 727   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(728)).setAttribute("tipo","texto" );
      ((Element)v.get(728)).setAttribute("ID","EstDat" );
      ((Element)v.get(727)).appendChild((Element)v.get(728));
      /* Termina nodo:728   */

      /* Empieza nodo:729 / Elemento padre: 727   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(729)).setAttribute("tipo","texto" );
      ((Element)v.get(729)).setAttribute("ID","EstDat2" );
      ((Element)v.get(727)).appendChild((Element)v.get(729));
      /* Termina nodo:729   */

      /* Empieza nodo:730 / Elemento padre: 727   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(730)).setAttribute("tipo","texto" );
      ((Element)v.get(730)).setAttribute("ID","EstDat" );
      ((Element)v.get(727)).appendChild((Element)v.get(730));
      /* Termina nodo:730   */

      /* Empieza nodo:731 / Elemento padre: 727   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(731)).setAttribute("tipo","texto" );
      ((Element)v.get(731)).setAttribute("ID","EstDat2" );
      ((Element)v.get(727)).appendChild((Element)v.get(731));
      /* Termina nodo:731   */

      /* Empieza nodo:732 / Elemento padre: 727   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(732)).setAttribute("tipo","texto" );
      ((Element)v.get(732)).setAttribute("ID","EstDat" );
      ((Element)v.get(727)).appendChild((Element)v.get(732));
      /* Termina nodo:732   */

      /* Empieza nodo:733 / Elemento padre: 727   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(733)).setAttribute("tipo","texto" );
      ((Element)v.get(733)).setAttribute("ID","EstDat2" );
      ((Element)v.get(727)).appendChild((Element)v.get(733));
      /* Termina nodo:733   */

      /* Empieza nodo:734 / Elemento padre: 727   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(734)).setAttribute("tipo","texto" );
      ((Element)v.get(734)).setAttribute("ID","EstDat" );
      ((Element)v.get(727)).appendChild((Element)v.get(734));
      /* Termina nodo:734   */

      /* Empieza nodo:735 / Elemento padre: 727   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(735)).setAttribute("tipo","texto" );
      ((Element)v.get(735)).setAttribute("ID","EstDat2" );
      ((Element)v.get(727)).appendChild((Element)v.get(735));
      /* Termina nodo:735   */

      /* Empieza nodo:736 / Elemento padre: 727   */
   }

   private void getXML3060(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(736)).setAttribute("tipo","texto" );
      ((Element)v.get(736)).setAttribute("ID","EstDat" );
      ((Element)v.get(727)).appendChild((Element)v.get(736));
      /* Termina nodo:736   */

      /* Empieza nodo:737 / Elemento padre: 727   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(737)).setAttribute("tipo","texto" );
      ((Element)v.get(737)).setAttribute("ID","EstDat2" );
      ((Element)v.get(727)).appendChild((Element)v.get(737));
      /* Termina nodo:737   */

      /* Empieza nodo:738 / Elemento padre: 727   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(738)).setAttribute("tipo","texto" );
      ((Element)v.get(738)).setAttribute("ID","EstDat" );
      ((Element)v.get(727)).appendChild((Element)v.get(738));
      /* Termina nodo:738   */

      /* Empieza nodo:739 / Elemento padre: 727   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(739)).setAttribute("tipo","texto" );
      ((Element)v.get(739)).setAttribute("ID","EstDat2" );
      ((Element)v.get(727)).appendChild((Element)v.get(739));
      /* Termina nodo:739   */

      /* Empieza nodo:740 / Elemento padre: 727   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(740)).setAttribute("tipo","texto" );
      ((Element)v.get(740)).setAttribute("ID","EstDat2" );
      ((Element)v.get(727)).appendChild((Element)v.get(740));
      /* Termina nodo:740   */

      /* Empieza nodo:741 / Elemento padre: 727   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(741)).setAttribute("tipo","texto" );
      ((Element)v.get(741)).setAttribute("ID","EstDat2" );
      ((Element)v.get(727)).appendChild((Element)v.get(741));
      /* Termina nodo:741   */

      /* Empieza nodo:742 / Elemento padre: 727   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(742)).setAttribute("tipo","texto" );
      ((Element)v.get(742)).setAttribute("ID","EstDat2" );
      ((Element)v.get(727)).appendChild((Element)v.get(742));
      /* Termina nodo:742   */

      /* Empieza nodo:743 / Elemento padre: 727   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(743)).setAttribute("tipo","texto" );
      ((Element)v.get(743)).setAttribute("ID","EstDat2" );
      ((Element)v.get(727)).appendChild((Element)v.get(743));
      /* Termina nodo:743   */

      /* Empieza nodo:744 / Elemento padre: 727   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(744)).setAttribute("tipo","texto" );
      ((Element)v.get(744)).setAttribute("ID","EstDat2" );
      ((Element)v.get(727)).appendChild((Element)v.get(744));
      /* Termina nodo:744   */

      /* Empieza nodo:745 / Elemento padre: 727   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(745)).setAttribute("tipo","texto" );
      ((Element)v.get(745)).setAttribute("ID","EstDat2" );
      ((Element)v.get(727)).appendChild((Element)v.get(745));
      /* Termina nodo:745   */

      /* Empieza nodo:746 / Elemento padre: 727   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(746)).setAttribute("tipo","texto" );
      ((Element)v.get(746)).setAttribute("ID","EstDat2" );
      ((Element)v.get(727)).appendChild((Element)v.get(746));
      /* Termina nodo:746   */

      /* Empieza nodo:747 / Elemento padre: 727   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(747)).setAttribute("tipo","texto" );
      ((Element)v.get(747)).setAttribute("ID","EstDat2" );
      ((Element)v.get(727)).appendChild((Element)v.get(747));
      /* Termina nodo:747   */

      /* Empieza nodo:748 / Elemento padre: 727   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(748)).setAttribute("tipo","texto" );
      ((Element)v.get(748)).setAttribute("ID","EstDat2" );
      ((Element)v.get(727)).appendChild((Element)v.get(748));
      /* Termina nodo:748   */

      /* Empieza nodo:749 / Elemento padre: 727   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(749)).setAttribute("tipo","texto" );
      ((Element)v.get(749)).setAttribute("ID","EstDat2" );
      ((Element)v.get(727)).appendChild((Element)v.get(749));
      /* Termina nodo:749   */

      /* Empieza nodo:750 / Elemento padre: 727   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(750)).setAttribute("tipo","texto" );
      ((Element)v.get(750)).setAttribute("ID","EstDat2" );
      ((Element)v.get(727)).appendChild((Element)v.get(750));
      /* Termina nodo:750   */

      /* Empieza nodo:751 / Elemento padre: 727   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(751)).setAttribute("tipo","texto" );
      ((Element)v.get(751)).setAttribute("ID","EstDat2" );
      ((Element)v.get(727)).appendChild((Element)v.get(751));
      /* Termina nodo:751   */
      /* Termina nodo:727   */

      /* Empieza nodo:752 / Elemento padre: 641   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(641)).appendChild((Element)v.get(752));
      /* Termina nodo:752   */

      /* Empieza nodo:753 / Elemento padre: 641   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(753)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(753)).setAttribute("ancho","504" );
      ((Element)v.get(753)).setAttribute("sep","$" );
      ((Element)v.get(753)).setAttribute("x","12" );
      ((Element)v.get(753)).setAttribute("class","botonera" );
      ((Element)v.get(753)).setAttribute("y","753" );
      ((Element)v.get(753)).setAttribute("control","|" );
      ((Element)v.get(753)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(753)).setAttribute("rowset","" );
      ((Element)v.get(753)).setAttribute("cargainicial","N" );
      ((Element)v.get(641)).appendChild((Element)v.get(753));

      /* Empieza nodo:754 / Elemento padre: 753   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(754)).setAttribute("nombre","ret2" );
      ((Element)v.get(754)).setAttribute("x","37" );
      ((Element)v.get(754)).setAttribute("y","757" );
      ((Element)v.get(754)).setAttribute("ID","botonContenido" );
      ((Element)v.get(754)).setAttribute("img","retroceder_on" );
      ((Element)v.get(754)).setAttribute("tipo","0" );
      ((Element)v.get(754)).setAttribute("estado","false" );
      ((Element)v.get(754)).setAttribute("alt","" );
      ((Element)v.get(754)).setAttribute("codigo","" );
      ((Element)v.get(754)).setAttribute("accion","mipgndo2.retroceder();" );
      ((Element)v.get(753)).appendChild((Element)v.get(754));
      /* Termina nodo:754   */

      /* Empieza nodo:755 / Elemento padre: 753   */
   }

   private void getXML3150(Document doc) {
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(755)).setAttribute("nombre","ava2" );
      ((Element)v.get(755)).setAttribute("x","52" );
      ((Element)v.get(755)).setAttribute("y","757" );
      ((Element)v.get(755)).setAttribute("ID","botonContenido" );
      ((Element)v.get(755)).setAttribute("img","avanzar_on" );
      ((Element)v.get(755)).setAttribute("tipo","0" );
      ((Element)v.get(755)).setAttribute("estado","false" );
      ((Element)v.get(755)).setAttribute("alt","" );
      ((Element)v.get(755)).setAttribute("codigo","" );
      ((Element)v.get(755)).setAttribute("accion","mipgndo2.avanzar();" );
      ((Element)v.get(753)).appendChild((Element)v.get(755));
      /* Termina nodo:755   */
      /* Termina nodo:753   */
      /* Termina nodo:641   */

      /* Empieza nodo:756 / Elemento padre: 14   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(756)).setAttribute("nombre","primera2" );
      ((Element)v.get(756)).setAttribute("x","20" );
      ((Element)v.get(756)).setAttribute("y","757" );
      ((Element)v.get(756)).setAttribute("ID","botonContenido" );
      ((Element)v.get(756)).setAttribute("img","primera_on" );
      ((Element)v.get(756)).setAttribute("tipo","0" );
      ((Element)v.get(756)).setAttribute("estado","false" );
      ((Element)v.get(756)).setAttribute("alt","" );
      ((Element)v.get(756)).setAttribute("codigo","" );
      ((Element)v.get(756)).setAttribute("accion","mipgndo2.retrocederPrimeraPagina();" );
      ((Element)v.get(14)).appendChild((Element)v.get(756));
      /* Termina nodo:756   */

      /* Empieza nodo:757 / Elemento padre: 14   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(757)).setAttribute("nombre","separa2" );
      ((Element)v.get(757)).setAttribute("x","59" );
      ((Element)v.get(757)).setAttribute("y","753" );
      ((Element)v.get(757)).setAttribute("ID","botonContenido" );
      ((Element)v.get(757)).setAttribute("img","separa_base" );
      ((Element)v.get(757)).setAttribute("tipo","0" );
      ((Element)v.get(757)).setAttribute("estado","false" );
      ((Element)v.get(757)).setAttribute("alt","" );
      ((Element)v.get(757)).setAttribute("codigo","" );
      ((Element)v.get(757)).setAttribute("accion","" );
      ((Element)v.get(14)).appendChild((Element)v.get(757));
      /* Termina nodo:757   */
      /* Termina nodo:14   */


   }

}


import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_productos_mantener_detalle  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML3240(doc);
         

      getXML3330(doc);
         

      getXML3420(doc);
         

      getXML3510(doc);
         

      getXML3600(doc);
         

      getXML3690(doc);
         

      getXML3780(doc);
         

      getXML3870(doc);
         

      getXML3960(doc);
         

      getXML4050(doc);
         

      getXML4140(doc);
         

      getXML4230(doc);
         

      getXML4320(doc);
         

      getXML4410(doc);
         

      getXML4500(doc);
         

      getXML4590(doc);
         

      getXML4680(doc);
         

      getXML4770(doc);
         
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
      ((Element)v.get(4)).setAttribute("src","contenido_productos_mantener_detalle.js" );
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
      ((Element)v.get(7)).setAttribute("name","cbMarcaProducto" );
      ((Element)v.get(7)).setAttribute("group","bloqueNegocio" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","2448" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbTipoOferta" );
      ((Element)v.get(8)).setAttribute("group","bloqueOferta" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","608" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbCicloVida" );
      ((Element)v.get(9)).setAttribute("group","bloqueOferta" );
      ((Element)v.get(9)).setAttribute("required","false" );
      ((Element)v.get(9)).setAttribute("cod","581" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","txtCodProducto" );
      ((Element)v.get(10)).setAttribute("group","bloqueProducto" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","337" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbTipoOferta2" );
      ((Element)v.get(11)).setAttribute("group","bloqueProducto" );
      ((Element)v.get(11)).setAttribute("required","false" );
      ((Element)v.get(11)).setAttribute("cod","608" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","cbCicloVida2" );
      ((Element)v.get(12)).setAttribute("group","bloqueProducto" );
      ((Element)v.get(12)).setAttribute("required","false" );
      ((Element)v.get(12)).setAttribute("cod","581" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","cbIndAgrup" );
      ((Element)v.get(13)).setAttribute("group","bloqueProducto" );
      ((Element)v.get(13)).setAttribute("required","true" );
      ((Element)v.get(13)).setAttribute("cod","3401" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","txtMensaje" );
      ((Element)v.get(14)).setAttribute("group","txtMensaje" );
      ((Element)v.get(14)).setAttribute("required","true" );
      ((Element)v.get(14)).setAttribute("cod","531" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(15)).setAttribute("name","cbPeriodoDesde" );
      ((Element)v.get(15)).setAttribute("group","cbPeriodoDesde" );
      ((Element)v.get(15)).setAttribute("required","true" );
      ((Element)v.get(15)).setAttribute("cod","1175" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(16)).setAttribute("name","cbPeriodoHasta" );
      ((Element)v.get(16)).setAttribute("group","cbPeriodoHasta" );
      ((Element)v.get(16)).setAttribute("required","true" );
      ((Element)v.get(16)).setAttribute("cod","1176" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(17)).setAttribute("name","txtUnidadesExigidas" );
      ((Element)v.get(17)).setAttribute("group","txtUnidadesExigidasR" );
      ((Element)v.get(17)).setAttribute("format","n" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(17)).setAttribute("min","0" );
      ((Element)v.get(17)).setAttribute("max","9999" );
      ((Element)v.get(17)).setAttribute("required","true" );
      ((Element)v.get(17)).setAttribute("cod","1815" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(18)).setAttribute("name","txtUnidadesExigidas" );
      ((Element)v.get(18)).setAttribute("group","txtUnidadesExigidas" );
      ((Element)v.get(18)).setAttribute("format","n" );
      ((Element)v.get(18)).setAttribute("min","0" );
      ((Element)v.get(18)).setAttribute("max","9999" );
      ((Element)v.get(18)).setAttribute("required","false" );
      ((Element)v.get(18)).setAttribute("cod","1815" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(19)).setAttribute("name","txtPuntosUnidad" );
      ((Element)v.get(19)).setAttribute("group","txtPuntosUnidadR" );
      ((Element)v.get(19)).setAttribute("format","n" );
      ((Element)v.get(19)).setAttribute("min","0" );
      ((Element)v.get(19)).setAttribute("max","999" );
      ((Element)v.get(19)).setAttribute("required","true" );
      ((Element)v.get(19)).setAttribute("cod","1813" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(20)).setAttribute("name","txtPuntosUnidad" );
      ((Element)v.get(20)).setAttribute("group","txtPuntosUnidad" );
      ((Element)v.get(20)).setAttribute("format","n" );
      ((Element)v.get(20)).setAttribute("min","0" );
      ((Element)v.get(20)).setAttribute("max","999" );
      ((Element)v.get(20)).setAttribute("required","false" );
      ((Element)v.get(20)).setAttribute("cod","1813" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(21)).setAttribute("name","txtFactorMultiplicidad" );
      ((Element)v.get(21)).setAttribute("group","txtFactorMultiplicidadR" );
      ((Element)v.get(21)).setAttribute("format","n" );
      ((Element)v.get(21)).setAttribute("min","0" );
      ((Element)v.get(21)).setAttribute("max","99" );
      ((Element)v.get(21)).setAttribute("required","true" );
      ((Element)v.get(21)).setAttribute("cod","1814" );
      ((Element)v.get(6)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(22)).setAttribute("name","txtFactorMultiplicidad" );
      ((Element)v.get(22)).setAttribute("group","txtFactorMultiplicidad" );
      ((Element)v.get(22)).setAttribute("format","n" );
      ((Element)v.get(22)).setAttribute("min","0" );
      ((Element)v.get(22)).setAttribute("max","99" );
      ((Element)v.get(22)).setAttribute("required","false" );
      ((Element)v.get(22)).setAttribute("cod","1814" );
      ((Element)v.get(6)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(23)).setAttribute("name","txtMontoExigido" );
      ((Element)v.get(23)).setAttribute("group","txtMontoExigidoR" );
      ((Element)v.get(23)).setAttribute("format","n" );
      ((Element)v.get(23)).setAttribute("min","0" );
      ((Element)v.get(23)).setAttribute("max","999999.999" );
      ((Element)v.get(23)).setAttribute("required","true" );
      ((Element)v.get(23)).setAttribute("cod","1816" );
      ((Element)v.get(6)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(24)).setAttribute("name","txtMontoExigido" );
      ((Element)v.get(24)).setAttribute("group","txtMontoExigido" );
      ((Element)v.get(24)).setAttribute("format","n" );
      ((Element)v.get(24)).setAttribute("min","0" );
      ((Element)v.get(24)).setAttribute("max","999999.999" );
      ((Element)v.get(24)).setAttribute("required","false" );
      ((Element)v.get(24)).setAttribute("cod","1816" );
      ((Element)v.get(6)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(25)).setAttribute("name","txtPuntosExigidos" );
      ((Element)v.get(25)).setAttribute("group","txtPuntosExigidosR" );
      ((Element)v.get(25)).setAttribute("format","n" );
      ((Element)v.get(25)).setAttribute("min","0" );
      ((Element)v.get(25)).setAttribute("max","9999" );
      ((Element)v.get(25)).setAttribute("required","true" );
      ((Element)v.get(25)).setAttribute("cod","1817" );
      ((Element)v.get(6)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(26)).setAttribute("name","txtPuntosExigidos" );
      ((Element)v.get(26)).setAttribute("group","txtPuntosExigidos" );
      ((Element)v.get(26)).setAttribute("format","n" );
      ((Element)v.get(26)).setAttribute("min","0" );
      ((Element)v.get(26)).setAttribute("max","9999" );
      ((Element)v.get(26)).setAttribute("required","false" );
      ((Element)v.get(26)).setAttribute("cod","1817" );
      ((Element)v.get(6)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:27 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(27)).setAttribute("nombre","formulario" );
      ((Element)v.get(0)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(28)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","accion" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","oidTipoProducto" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","descTipoProducto" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","camposDeshabilitados" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","datosObligatorios" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hcbMarcaProducto" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hcbUnidadNegocio" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hcbNegocio" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","hcbSupergenerico" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","hcbGenerico" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hcbTipoOferta" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hcbCicloVida" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","hoidProducto" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","htxtCodigoProducto" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","hcbPeriodoDesde" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","hcbPeriodoHasta" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","htxtPuntosUnidad" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","htxtFactorMultiplicidad" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","htxtUnidadesExigidas" );
      ((Element)v.get(50)).setAttribute("valor","" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(27)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","htxtMontoExigido" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","htxtPuntosExigidos" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","hIndAgrup" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","hlstProductos" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","hchkComunicacion" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","htxtCodigoMensaje" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","oidTipoProductoValidos" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","oidTipoProductoExcluidos" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","oidTipoProductoBonificados" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","oidTipoProductoExigidos" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","oidTipoProductoACalificar" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","oidTipoProductoExcluidosCalificacion" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(63)).setAttribute("nombre","listadoAMostrar" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(64)).setAttribute("nombre","hOidPeriodoDesde" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(65)).setAttribute("nombre","hOidPeriodoHasta" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(66)).setAttribute("nombre","hPaisParamGener" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(67)).setAttribute("nombre","hMarcaParamGener" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(68)).setAttribute("nombre","hCanalParamGener" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(69)).setAttribute("nombre","varCbSuperGenerico" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(70)).setAttribute("nombre","varCbGenerico" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 27   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(71)).setAttribute("nombre","capa" );
      ((Element)v.get(27)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("table"));
      ((Element)v.get(72)).setAttribute("width","100%" );
      ((Element)v.get(72)).setAttribute("border","0" );
      ((Element)v.get(72)).setAttribute("cellspacing","0" );
      ((Element)v.get(72)).setAttribute("cellpadding","0" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(74)).setAttribute("width","12" );
      ((Element)v.get(74)).setAttribute("align","center" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","12" );
      ((Element)v.get(75)).setAttribute("height","12" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).setAttribute("width","750" );
      ((Element)v.get(73)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 73   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("width","12" );
      ((Element)v.get(73)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","12" );
      ((Element)v.get(79)).setAttribute("height","1" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:73   */

      /* Empieza nodo:80 / Elemento padre: 72   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(72)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(85)).setAttribute("class","legend" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(86)).setAttribute("nombre","lblMantenerProductos" );
      ((Element)v.get(86)).setAttribute("alto","13" );
      ((Element)v.get(86)).setAttribute("filas","1" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(86)).setAttribute("id","legend" );
      ((Element)v.get(86)).setAttribute("cod","00333" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 84   */
      v.add(doc.createElement("table"));
      ((Element)v.get(87)).setAttribute("width","100%" );
      ((Element)v.get(87)).setAttribute("border","0" );
      ((Element)v.get(87)).setAttribute("align","center" );
      ((Element)v.get(87)).setAttribute("cellspacing","0" );
      ((Element)v.get(87)).setAttribute("cellpadding","0" );
      ((Element)v.get(84)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("table"));
      ((Element)v.get(90)).setAttribute("width","628" );
      ((Element)v.get(90)).setAttribute("border","0" );
      ((Element)v.get(90)).setAttribute("align","left" );
      ((Element)v.get(90)).setAttribute("cellspacing","0" );
      ((Element)v.get(90)).setAttribute("cellpadding","0" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).setAttribute("colspan","4" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","8" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:94 / Elemento padre: 90   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(90)).appendChild((Element)v.get(94));

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
      ((Element)v.get(98)).setAttribute("nombre","lblProductos" );
      ((Element)v.get(98)).setAttribute("alto","13" );
      ((Element)v.get(98)).setAttribute("filas","1" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(98)).setAttribute("valor","" );
      ((Element)v.get(98)).setAttribute("id","datosTitle" );
      ((Element)v.get(98)).setAttribute("cod","515" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("width","100%" );
      ((Element)v.get(94)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","8" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:94   */

      /* Empieza nodo:101 / Elemento padre: 90   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(90)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","8" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(105)).setAttribute("nombre","lbldtProductos" );
      ((Element)v.get(105)).setAttribute("alto","13" );
      ((Element)v.get(105)).setAttribute("filas","1" );
      ((Element)v.get(105)).setAttribute("valor","" );
      ((Element)v.get(105)).setAttribute("id","datosCampos" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).setAttribute("width","100%" );
      ((Element)v.get(101)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","8" );
      ((Element)v.get(107)).setAttribute("height","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:101   */

      /* Empieza nodo:108 / Elemento padre: 90   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(90)).appendChild((Element)v.get(108));

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
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:111 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:80   */

      /* Empieza nodo:113 / Elemento padre: 72   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(72)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(114)).setAttribute("width","12" );
      ((Element)v.get(114)).setAttribute("align","center" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","12" );
      ((Element)v.get(115)).setAttribute("height","12" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).setAttribute("width","756" );
      ((Element)v.get(113)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("width","12" );
      ((Element)v.get(113)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).setAttribute("width","12" );
      ((Element)v.get(119)).setAttribute("height","1" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:113   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:120 / Elemento padre: 27   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(120)).setAttribute("nombre","capa1" );
      ((Element)v.get(120)).setAttribute("alto","100%" );
      ((Element)v.get(120)).setAttribute("ancho","100%" );
      ((Element)v.get(120)).setAttribute("colorf","" );
      ((Element)v.get(120)).setAttribute("borde","0" );
      ((Element)v.get(120)).setAttribute("imagenf","" );
      ((Element)v.get(120)).setAttribute("repeat","" );
      ((Element)v.get(120)).setAttribute("padding","" );
      ((Element)v.get(120)).setAttribute("visibilidad","visible" );
      ((Element)v.get(120)).setAttribute("contravsb","" );
      ((Element)v.get(120)).setAttribute("x","0" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(120)).setAttribute("y","71" );
      ((Element)v.get(120)).setAttribute("zindex","" );
      ((Element)v.get(27)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("table"));
      ((Element)v.get(121)).setAttribute("width","100%" );
      ((Element)v.get(121)).setAttribute("border","0" );
      ((Element)v.get(121)).setAttribute("cellspacing","0" );
      ((Element)v.get(121)).setAttribute("cellpadding","0" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).setAttribute("width","12" );
      ((Element)v.get(123)).setAttribute("align","center" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","12" );
      ((Element)v.get(124)).setAttribute("height","12" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).setAttribute("width","750" );
      ((Element)v.get(122)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).setAttribute("width","12" );
      ((Element)v.get(122)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","12" );
      ((Element)v.get(128)).setAttribute("height","1" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:122   */

      /* Empieza nodo:129 / Elemento padre: 121   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(121)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(131)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("table"));
      ((Element)v.get(134)).setAttribute("width","100%" );
      ((Element)v.get(134)).setAttribute("border","0" );
      ((Element)v.get(134)).setAttribute("align","center" );
      ((Element)v.get(134)).setAttribute("cellspacing","0" );
      ((Element)v.get(134)).setAttribute("cellpadding","0" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).setAttribute("colspan","3" );
      ((Element)v.get(136)).setAttribute("bgcolor","#E5E5E5" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("table"));
      ((Element)v.get(137)).setAttribute("width","100%" );
      ((Element)v.get(137)).setAttribute("border","0" );
      ((Element)v.get(137)).setAttribute("align","center" );
      ((Element)v.get(137)).setAttribute("cellspacing","0" );
      ((Element)v.get(137)).setAttribute("cellpadding","0" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("table"));
      ((Element)v.get(140)).setAttribute("width","100%" );
      ((Element)v.get(140)).setAttribute("height","100%" );
      ((Element)v.get(140)).setAttribute("border","0" );
      ((Element)v.get(140)).setAttribute("align","center" );
      ((Element)v.get(140)).setAttribute("cellpadding","0" );
      ((Element)v.get(140)).setAttribute("cellspacing","0" );
      ((Element)v.get(140)).setAttribute("class","menu4" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).setAttribute("width","12" );
      ((Element)v.get(142)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(142)).setAttribute("class","menu5texto" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
      ((Element)v.get(143)).setAttribute("width","12" );
      ((Element)v.get(143)).setAttribute("height","30" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:144 / Elemento padre: 141   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(144)).setAttribute("class","menu5texto" );
      ((Element)v.get(141)).appendChild((Element)v.get(144));

      /* Elemento padre:144 / Elemento actual: 145   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(144)).appendChild((Text)v.get(145));

      /* Termina nodo Texto:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:146 / Elemento padre: 141   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).setAttribute("width","10" );
      ((Element)v.get(146)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(146)).setAttribute("class","menu5texto" );
      ((Element)v.get(141)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).setAttribute("width","10" );
      ((Element)v.get(147)).setAttribute("height","8" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:148 / Elemento padre: 141   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).setAttribute("width","75" );
      ((Element)v.get(148)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(148)).setAttribute("class","menu5texto" );
      ((Element)v.get(141)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("table"));
      ((Element)v.get(149)).setAttribute("id","tabla1" );
      ((Element)v.get(149)).setAttribute("width","75" );
      ((Element)v.get(149)).setAttribute("border","0" );
      ((Element)v.get(149)).setAttribute("align","center" );
      ((Element)v.get(149)).setAttribute("cellpadding","1" );
      ((Element)v.get(149)).setAttribute("cellspacing","0" );
      ((Element)v.get(149)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(150)).setAttribute("align","center" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).setAttribute("id","celda1" );
      ((Element)v.get(151)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(151)).setAttribute("onmouseover","mouseOver('celda1');" );
      ((Element)v.get(151)).setAttribute("onclick","cambiaPestanya(1);" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(152)).setAttribute("id","lblpBloqueNegocio" );
      ((Element)v.get(152)).setAttribute("style","font-family: Arial, Helvetica, sans-serif; font-size: 11px; font-weight: bold; color: #000000; text-align: center; clip:  rect();" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:153 / Elemento padre: 141   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).setAttribute("width","10" );
      ((Element)v.get(153)).setAttribute("class","menu5texto" );
      ((Element)v.get(141)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).setAttribute("width","10" );
      ((Element)v.get(154)).setAttribute("height","8" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 141   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).setAttribute("width","20" );
      ((Element)v.get(155)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(155)).setAttribute("class","menu5texto" );
      ((Element)v.get(141)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("table"));
      ((Element)v.get(156)).setAttribute("id","tabla2" );
      ((Element)v.get(156)).setAttribute("width","75" );
      ((Element)v.get(156)).setAttribute("border","0" );
      ((Element)v.get(156)).setAttribute("align","center" );
      ((Element)v.get(156)).setAttribute("cellpadding","1" );
      ((Element)v.get(156)).setAttribute("cellspacing","0" );
      ((Element)v.get(156)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(157)).setAttribute("align","center" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).setAttribute("id","celda2" );
      ((Element)v.get(158)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(158)).setAttribute("onmouseover","mouseOver('celda2');" );
      ((Element)v.get(158)).setAttribute("onclick","cambiaPestanya(2);" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(159)).setAttribute("id","lblpBloqueOferta" );
      ((Element)v.get(159)).setAttribute("style","font-family: Arial, Helvetica, sans-serif; font-size: 11px; font-weight: bold; color: #000000; text-align: center; clip:  rect();" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:160 / Elemento padre: 141   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).setAttribute("width","10" );
      ((Element)v.get(160)).setAttribute("class","menu5texto" );
      ((Element)v.get(141)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).setAttribute("width","10" );
      ((Element)v.get(161)).setAttribute("height","8" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 141   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).setAttribute("width","20" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(162)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(162)).setAttribute("class","menu5texto" );
      ((Element)v.get(141)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("table"));
      ((Element)v.get(163)).setAttribute("id","tabla3" );
      ((Element)v.get(163)).setAttribute("width","75" );
      ((Element)v.get(163)).setAttribute("border","0" );
      ((Element)v.get(163)).setAttribute("align","center" );
      ((Element)v.get(163)).setAttribute("cellpadding","1" );
      ((Element)v.get(163)).setAttribute("cellspacing","0" );
      ((Element)v.get(163)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(164)).setAttribute("align","center" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).setAttribute("id","celda3" );
      ((Element)v.get(165)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(165)).setAttribute("onmouseover","mouseOver('celda3');" );
      ((Element)v.get(165)).setAttribute("onclick","cambiaPestanya(3);" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("DIV"));
      ((Element)v.get(166)).setAttribute("id","lblpBloqueProducto" );
      ((Element)v.get(166)).setAttribute("style","font-family: Arial, Helvetica, sans-serif; font-size: 11px; font-weight: bold; color: #000000; text-align: center; clip:  rect(   );" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:167 / Elemento padre: 141   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).setAttribute("width","16" );
      ((Element)v.get(167)).setAttribute("class","menu5texto" );
      ((Element)v.get(141)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","12" );
      ((Element)v.get(168)).setAttribute("height","8" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:169 / Elemento padre: 134   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(134)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).setAttribute("width","12" );
      ((Element)v.get(170)).setAttribute("align","center" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(171)).setAttribute("src","b.gif" );
      ((Element)v.get(171)).setAttribute("width","12" );
      ((Element)v.get(171)).setAttribute("height","158" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:172 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).setAttribute("width","756" );
      ((Element)v.get(169)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(173)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:174 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).setAttribute("width","12" );
      ((Element)v.get(169)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(175)).setAttribute("src","b.gif" );
      ((Element)v.get(175)).setAttribute("width","12" );
      ((Element)v.get(175)).setAttribute("height","1" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */
      /* Termina nodo:169   */

      /* Empieza nodo:176 / Elemento padre: 134   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(134)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(178)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:179 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(181)).setAttribute("class","legend" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(182)).setAttribute("nombre","lblDatosAsociados" );
      ((Element)v.get(182)).setAttribute("alto","13" );
      ((Element)v.get(182)).setAttribute("filas","1" );
      ((Element)v.get(182)).setAttribute("valor","" );
      ((Element)v.get(182)).setAttribute("id","legend" );
      ((Element)v.get(182)).setAttribute("cod","00364" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 180   */
      v.add(doc.createElement("table"));
      ((Element)v.get(183)).setAttribute("width","100%" );
      ((Element)v.get(183)).setAttribute("border","0" );
      ((Element)v.get(183)).setAttribute("align","center" );
      ((Element)v.get(183)).setAttribute("cellspacing","0" );
      ((Element)v.get(183)).setAttribute("cellpadding","0" );
      ((Element)v.get(180)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("table"));
      ((Element)v.get(186)).setAttribute("width","600" );
      ((Element)v.get(186)).setAttribute("border","0" );
      ((Element)v.get(186)).setAttribute("align","left" );
      ((Element)v.get(186)).setAttribute("cellspacing","0" );
      ((Element)v.get(186)).setAttribute("cellpadding","0" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(186)).appendChild((Element)v.get(187));

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

      /* Empieza nodo:190 / Elemento padre: 186   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(186)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(192)).setAttribute("src","b.gif" );
      ((Element)v.get(192)).setAttribute("width","8" );
      ((Element)v.get(192)).setAttribute("height","8" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:193 / Elemento padre: 190   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(194)).setAttribute("nombre","lblPeridoDesde" );
      ((Element)v.get(194)).setAttribute("alto","13" );
      ((Element)v.get(194)).setAttribute("filas","1" );
      ((Element)v.get(194)).setAttribute("valor","" );
      ((Element)v.get(194)).setAttribute("id","datosTitle" );
      ((Element)v.get(194)).setAttribute("cod","1175" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 190   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(196)).setAttribute("width","25" );
      ((Element)v.get(196)).setAttribute("height","8" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 190   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(198)).setAttribute("nombre","lblPeridoHasta" );
      ((Element)v.get(198)).setAttribute("alto","13" );
      ((Element)v.get(198)).setAttribute("filas","1" );
      ((Element)v.get(198)).setAttribute("valor","" );
      ((Element)v.get(198)).setAttribute("id","datosTitle" );
      ((Element)v.get(198)).setAttribute("cod","1176" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 190   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(200)).setAttribute("src","b.gif" );
      ((Element)v.get(200)).setAttribute("width","25" );
      ((Element)v.get(200)).setAttribute("height","8" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:201 / Elemento padre: 190   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(202)).setAttribute("nombre","lblPuntosUnidad" );
      ((Element)v.get(202)).setAttribute("alto","13" );
      ((Element)v.get(202)).setAttribute("filas","1" );
      ((Element)v.get(202)).setAttribute("valor","" );
      ((Element)v.get(202)).setAttribute("id","datosTitle" );
      ((Element)v.get(202)).setAttribute("cod","1813" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:203 / Elemento padre: 190   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).setAttribute("width","25" );
      ((Element)v.get(204)).setAttribute("height","8" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:205 / Elemento padre: 190   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(206)).setAttribute("nombre","lblFactorMultiplicidad" );
      ((Element)v.get(206)).setAttribute("alto","13" );
      ((Element)v.get(206)).setAttribute("filas","1" );
      ((Element)v.get(206)).setAttribute("valor","" );
      ((Element)v.get(206)).setAttribute("id","datosTitle" );
      ((Element)v.get(206)).setAttribute("cod","1814" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:207 / Elemento padre: 190   */
      v.add(doc.createElement("td"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(207)).setAttribute("width","100%" );
      ((Element)v.get(190)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).setAttribute("width","8" );
      ((Element)v.get(208)).setAttribute("height","8" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:190   */

      /* Empieza nodo:209 / Elemento padre: 186   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(186)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(211)).setAttribute("width","8" );
      ((Element)v.get(211)).setAttribute("height","8" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(209)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(213)).setAttribute("nombre","cbPeriodoDesde" );
      ((Element)v.get(213)).setAttribute("onchange","onChangePeriodoDesde()" );
      ((Element)v.get(213)).setAttribute("id","datosCampos" );
      ((Element)v.get(213)).setAttribute("onshtab","shTabPeriodoDesde();" );
      ((Element)v.get(213)).setAttribute("size","1" );
      ((Element)v.get(213)).setAttribute("multiple","N" );
      ((Element)v.get(213)).setAttribute("req","N" );
      ((Element)v.get(213)).setAttribute("valorinicial","" );
      ((Element)v.get(213)).setAttribute("textoinicial","" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:215 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(216)).setAttribute("src","b.gif" );
      ((Element)v.get(216)).setAttribute("width","25" );
      ((Element)v.get(216)).setAttribute("height","8" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:217 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(217)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(209)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(218)).setAttribute("nombre","cbPeriodoHasta" );
      ((Element)v.get(218)).setAttribute("id","datosCampos" );
      ((Element)v.get(218)).setAttribute("size","1" );
      ((Element)v.get(218)).setAttribute("multiple","N" );
      ((Element)v.get(218)).setAttribute("req","N" );
      ((Element)v.get(218)).setAttribute("valorinicial","" );
      ((Element)v.get(218)).setAttribute("textoinicial","" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:220 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(221)).setAttribute("src","b.gif" );
      ((Element)v.get(221)).setAttribute("width","25" );
      ((Element)v.get(221)).setAttribute("height","8" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:222 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(223)).setAttribute("nombre","txtPuntosUnidad" );
      ((Element)v.get(223)).setAttribute("id","datosCampos" );
      ((Element)v.get(223)).setAttribute("max","3" );
      ((Element)v.get(223)).setAttribute("tipo","" );
      ((Element)v.get(223)).setAttribute("onchange","" );
      ((Element)v.get(223)).setAttribute("req","N" );
      ((Element)v.get(223)).setAttribute("size","3" );
      ((Element)v.get(223)).setAttribute("valor","" );
      ((Element)v.get(223)).setAttribute("validacion","" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:224 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(225)).setAttribute("src","b.gif" );
      ((Element)v.get(225)).setAttribute("width","25" );
      ((Element)v.get(225)).setAttribute("height","8" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:226 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(227)).setAttribute("nombre","txtFactorMultiplicidad" );
      ((Element)v.get(227)).setAttribute("id","datosCampos" );
      ((Element)v.get(227)).setAttribute("max","2" );
      ((Element)v.get(227)).setAttribute("tipo","" );
      ((Element)v.get(227)).setAttribute("onchange","" );
      ((Element)v.get(227)).setAttribute("req","N" );
      ((Element)v.get(227)).setAttribute("size","2" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(227)).setAttribute("valor","" );
      ((Element)v.get(227)).setAttribute("validacion","" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(228)).setAttribute("width","100%" );
      ((Element)v.get(209)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(229)).setAttribute("src","b.gif" );
      ((Element)v.get(229)).setAttribute("width","8" );
      ((Element)v.get(229)).setAttribute("height","8" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */
      /* Termina nodo:209   */

      /* Empieza nodo:230 / Elemento padre: 186   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(186)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).setAttribute("colspan","4" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(232)).setAttribute("src","b.gif" );
      ((Element)v.get(232)).setAttribute("width","8" );
      ((Element)v.get(232)).setAttribute("height","8" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */
      /* Termina nodo:230   */
      /* Termina nodo:186   */
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:233 / Elemento padre: 183   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(183)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("table"));
      ((Element)v.get(235)).setAttribute("width","600" );
      ((Element)v.get(235)).setAttribute("border","0" );
      ((Element)v.get(235)).setAttribute("align","left" );
      ((Element)v.get(235)).setAttribute("cellspacing","0" );
      ((Element)v.get(235)).setAttribute("cellpadding","0" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(238)).setAttribute("src","b.gif" );
      ((Element)v.get(238)).setAttribute("width","8" );
      ((Element)v.get(238)).setAttribute("height","8" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(240)).setAttribute("nombre","lblUnidadesExigidas" );
      ((Element)v.get(240)).setAttribute("alto","13" );
      ((Element)v.get(240)).setAttribute("filas","1" );
      ((Element)v.get(240)).setAttribute("valor","" );
      ((Element)v.get(240)).setAttribute("id","datosTitle" );
      ((Element)v.get(240)).setAttribute("cod","1815" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:241 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(242)).setAttribute("src","b.gif" );
      ((Element)v.get(242)).setAttribute("width","25" );
      ((Element)v.get(242)).setAttribute("height","8" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:243 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(244)).setAttribute("nombre","lblMontoExigido" );
      ((Element)v.get(244)).setAttribute("alto","13" );
      ((Element)v.get(244)).setAttribute("filas","1" );
      ((Element)v.get(244)).setAttribute("valor","" );
      ((Element)v.get(244)).setAttribute("id","datosTitle" );
      ((Element)v.get(244)).setAttribute("cod","1816" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:245 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(246)).setAttribute("src","b.gif" );
      ((Element)v.get(246)).setAttribute("width","25" );
      ((Element)v.get(246)).setAttribute("height","8" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:247 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(248)).setAttribute("nombre","lblPuntosExigidos" );
      ((Element)v.get(248)).setAttribute("alto","13" );
      ((Element)v.get(248)).setAttribute("filas","1" );
      ((Element)v.get(248)).setAttribute("valor","" );
      ((Element)v.get(248)).setAttribute("id","datosTitle" );
      ((Element)v.get(248)).setAttribute("cod","1817" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */

      /* Empieza nodo:249 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(249)).setAttribute("width","100%" );
      ((Element)v.get(236)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(250)).setAttribute("src","b.gif" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(250)).setAttribute("width","8" );
      ((Element)v.get(250)).setAttribute("height","8" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */
      /* Termina nodo:236   */

      /* Empieza nodo:251 / Elemento padre: 235   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(235)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(253)).setAttribute("src","b.gif" );
      ((Element)v.get(253)).setAttribute("width","8" );
      ((Element)v.get(253)).setAttribute("height","8" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */

      /* Empieza nodo:254 / Elemento padre: 251   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(255)).setAttribute("nombre","txtUnidadesExigidas" );
      ((Element)v.get(255)).setAttribute("id","datosCampos" );
      ((Element)v.get(255)).setAttribute("max","4" );
      ((Element)v.get(255)).setAttribute("tipo","" );
      ((Element)v.get(255)).setAttribute("onchange","" );
      ((Element)v.get(255)).setAttribute("req","N" );
      ((Element)v.get(255)).setAttribute("size","4" );
      ((Element)v.get(255)).setAttribute("valor","" );
      ((Element)v.get(255)).setAttribute("validacion","" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */

      /* Empieza nodo:256 / Elemento padre: 251   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(257)).setAttribute("src","b.gif" );
      ((Element)v.get(257)).setAttribute("width","25" );
      ((Element)v.get(257)).setAttribute("height","8" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */

      /* Empieza nodo:258 / Elemento padre: 251   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(259)).setAttribute("nombre","txtMontoExigido" );
      ((Element)v.get(259)).setAttribute("id","datosCampos" );
      ((Element)v.get(259)).setAttribute("max","12" );
      ((Element)v.get(259)).setAttribute("tipo","" );
      ((Element)v.get(259)).setAttribute("onchange","" );
      ((Element)v.get(259)).setAttribute("req","N" );
      ((Element)v.get(259)).setAttribute("size","9" );
      ((Element)v.get(259)).setAttribute("valor","" );
      ((Element)v.get(259)).setAttribute("validacion","" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:260 / Elemento padre: 251   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(261)).setAttribute("src","b.gif" );
      ((Element)v.get(261)).setAttribute("width","25" );
      ((Element)v.get(261)).setAttribute("height","8" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:262 / Elemento padre: 251   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(263)).setAttribute("nombre","txtPuntosExigidos" );
      ((Element)v.get(263)).setAttribute("id","datosCampos" );
      ((Element)v.get(263)).setAttribute("max","4" );
      ((Element)v.get(263)).setAttribute("tipo","" );
      ((Element)v.get(263)).setAttribute("onchange","" );
      ((Element)v.get(263)).setAttribute("req","N" );
      ((Element)v.get(263)).setAttribute("size","4" );
      ((Element)v.get(263)).setAttribute("valor","" );
      ((Element)v.get(263)).setAttribute("validacion","" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:264 / Elemento padre: 251   */
      v.add(doc.createElement("td"));
      ((Element)v.get(264)).setAttribute("width","100%" );
      ((Element)v.get(251)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(265)).setAttribute("src","b.gif" );
      ((Element)v.get(265)).setAttribute("width","8" );
      ((Element)v.get(265)).setAttribute("height","8" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */
      /* Termina nodo:251   */

      /* Empieza nodo:266 / Elemento padre: 235   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(235)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(267)).setAttribute("colspan","4" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(268)).setAttribute("src","b.gif" );
      ((Element)v.get(268)).setAttribute("width","8" );
      ((Element)v.get(268)).setAttribute("height","8" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */
      /* Termina nodo:266   */
      /* Termina nodo:235   */
      /* Termina nodo:234   */
      /* Termina nodo:233   */
      /* Termina nodo:183   */
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:269 / Elemento padre: 176   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(270)).setAttribute("src","b.gif" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:269   */
      /* Termina nodo:176   */

      /* Empieza nodo:271 / Elemento padre: 134   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(134)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
   }

   private void getXML1170(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(272)).setAttribute("width","12" );
      ((Element)v.get(272)).setAttribute("align","center" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(273)).setAttribute("src","b.gif" );
      ((Element)v.get(273)).setAttribute("width","12" );
      ((Element)v.get(273)).setAttribute("height","12" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */
      /* Termina nodo:272   */

      /* Empieza nodo:274 / Elemento padre: 271   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).setAttribute("width","756" );
      ((Element)v.get(271)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(275)).setAttribute("src","b.gif" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */
      /* Termina nodo:274   */

      /* Empieza nodo:276 / Elemento padre: 271   */
      v.add(doc.createElement("td"));
      ((Element)v.get(276)).setAttribute("width","12" );
      ((Element)v.get(271)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(277)).setAttribute("src","b.gif" );
      ((Element)v.get(277)).setAttribute("width","12" );
      ((Element)v.get(277)).setAttribute("height","1" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:276   */
      /* Termina nodo:271   */
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:278 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(279)).setAttribute("src","b.gif" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */
      /* Termina nodo:129   */

      /* Empieza nodo:280 / Elemento padre: 121   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(121)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(280)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(282)).setAttribute("src","b.gif" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */

      /* Empieza nodo:283 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(280)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(283)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("table"));
      ((Element)v.get(285)).setAttribute("width","100%" );
      ((Element)v.get(285)).setAttribute("border","0" );
      ((Element)v.get(285)).setAttribute("align","center" );
      ((Element)v.get(285)).setAttribute("cellspacing","0" );
      ((Element)v.get(285)).setAttribute("cellpadding","0" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(285)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(287)).setAttribute("class","botonera" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(288)).setAttribute("nombre","btnAnadir1" );
      ((Element)v.get(288)).setAttribute("ID","botonContenido" );
      ((Element)v.get(288)).setAttribute("tipo","html" );
      ((Element)v.get(288)).setAttribute("ontab","focaliza('formulario.ckComunicacion');" );
      ((Element)v.get(288)).setAttribute("accion","accionAniadir();" );
      ((Element)v.get(288)).setAttribute("estado","false" );
      ((Element)v.get(288)).setAttribute("cod","404" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:287   */
      /* Termina nodo:286   */
      /* Termina nodo:285   */
      /* Termina nodo:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:289 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(280)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(290)).setAttribute("src","b.gif" );
      ((Element)v.get(290)).setAttribute("width","8" );
      ((Element)v.get(290)).setAttribute("height","12" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */
      /* Termina nodo:289   */
      /* Termina nodo:280   */

      /* Empieza nodo:291 / Elemento padre: 121   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(121)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(292)).setAttribute("width","12" );
      ((Element)v.get(292)).setAttribute("align","center" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(293)).setAttribute("src","b.gif" );
      ((Element)v.get(293)).setAttribute("width","12" );
      ((Element)v.get(293)).setAttribute("height","12" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:294 / Elemento padre: 291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(294)).setAttribute("width","756" );
      ((Element)v.get(291)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(295)).setAttribute("src","b.gif" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */

      /* Empieza nodo:296 / Elemento padre: 291   */
      v.add(doc.createElement("td"));
      ((Element)v.get(296)).setAttribute("width","12" );
      ((Element)v.get(291)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(297)).setAttribute("src","b.gif" );
      ((Element)v.get(297)).setAttribute("width","12" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(297)).setAttribute("height","1" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:296   */
      /* Termina nodo:291   */
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:298 / Elemento padre: 27   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(298)).setAttribute("nombre","capa2" );
      ((Element)v.get(298)).setAttribute("alto","200" );
      ((Element)v.get(298)).setAttribute("ancho","100%" );
      ((Element)v.get(298)).setAttribute("colorf","" );
      ((Element)v.get(298)).setAttribute("borde","0" );
      ((Element)v.get(298)).setAttribute("imagenf","" );
      ((Element)v.get(298)).setAttribute("repeat","" );
      ((Element)v.get(298)).setAttribute("padding","" );
      ((Element)v.get(298)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(298)).setAttribute("contravsb","" );
      ((Element)v.get(298)).setAttribute("x","0" );
      ((Element)v.get(298)).setAttribute("y","109" );
      ((Element)v.get(298)).setAttribute("zindex","" );
      ((Element)v.get(27)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("table"));
      ((Element)v.get(299)).setAttribute("width","100%" );
      ((Element)v.get(299)).setAttribute("border","0" );
      ((Element)v.get(299)).setAttribute("cellspacing","0" );
      ((Element)v.get(299)).setAttribute("cellpadding","0" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(299)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(301)).setAttribute("width","12" );
      ((Element)v.get(301)).setAttribute("align","center" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(302)).setAttribute("src","b.gif" );
      ((Element)v.get(302)).setAttribute("width","25" );
      ((Element)v.get(302)).setAttribute("height","12" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:303 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).setAttribute("width","750" );
      ((Element)v.get(300)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(304)).setAttribute("src","b.gif" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */

      /* Empieza nodo:305 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(305)).setAttribute("width","12" );
      ((Element)v.get(300)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(306)).setAttribute("src","b.gif" );
      ((Element)v.get(306)).setAttribute("width","26" );
      ((Element)v.get(306)).setAttribute("height","1" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */
      /* Termina nodo:300   */

      /* Empieza nodo:307 / Elemento padre: 299   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(299)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("td"));
      ((Element)v.get(307)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(309)).setAttribute("src","b.gif" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:310 / Elemento padre: 307   */
      v.add(doc.createElement("td"));
      ((Element)v.get(307)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(310)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(312)).setAttribute("class","legend" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(313)).setAttribute("nombre","lblBloqueNegocio" );
      ((Element)v.get(313)).setAttribute("alto","13" );
      ((Element)v.get(313)).setAttribute("filas","1" );
      ((Element)v.get(313)).setAttribute("valor","" );
      ((Element)v.get(313)).setAttribute("id","legend" );
      ((Element)v.get(313)).setAttribute("cod","00335" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:312   */

      /* Empieza nodo:314 / Elemento padre: 311   */
      v.add(doc.createElement("table"));
      ((Element)v.get(314)).setAttribute("width","100%" );
      ((Element)v.get(314)).setAttribute("border","0" );
      ((Element)v.get(314)).setAttribute("align","center" );
      ((Element)v.get(314)).setAttribute("cellspacing","0" );
      ((Element)v.get(314)).setAttribute("cellpadding","0" );
      ((Element)v.get(311)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(314)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("td"));
      ((Element)v.get(315)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("table"));
      ((Element)v.get(317)).setAttribute("width","600" );
      ((Element)v.get(317)).setAttribute("border","0" );
      ((Element)v.get(317)).setAttribute("align","left" );
      ((Element)v.get(317)).setAttribute("cellspacing","0" );
      ((Element)v.get(317)).setAttribute("cellpadding","0" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(317)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
   }

   private void getXML1350(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(319)).setAttribute("colspan","4" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(320)).setAttribute("src","b.gif" );
      ((Element)v.get(320)).setAttribute("width","8" );
      ((Element)v.get(320)).setAttribute("height","8" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */
      /* Termina nodo:318   */

      /* Empieza nodo:321 / Elemento padre: 317   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(317)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("td"));
      ((Element)v.get(321)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(323)).setAttribute("src","b.gif" );
      ((Element)v.get(323)).setAttribute("width","8" );
      ((Element)v.get(323)).setAttribute("height","8" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:324 / Elemento padre: 321   */
      v.add(doc.createElement("td"));
      ((Element)v.get(321)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(325)).setAttribute("nombre","lblMarcaProducto" );
      ((Element)v.get(325)).setAttribute("alto","13" );
      ((Element)v.get(325)).setAttribute("filas","1" );
      ((Element)v.get(325)).setAttribute("valor","" );
      ((Element)v.get(325)).setAttribute("id","datosTitle" );
      ((Element)v.get(325)).setAttribute("cod","2448" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:326 / Elemento padre: 321   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).setAttribute("width","100%" );
      ((Element)v.get(321)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(327)).setAttribute("src","b.gif" );
      ((Element)v.get(327)).setAttribute("width","8" );
      ((Element)v.get(327)).setAttribute("height","8" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:326   */
      /* Termina nodo:321   */

      /* Empieza nodo:328 / Elemento padre: 317   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(317)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("td"));
      ((Element)v.get(328)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(330)).setAttribute("src","b.gif" );
      ((Element)v.get(330)).setAttribute("width","8" );
      ((Element)v.get(330)).setAttribute("height","8" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:331 / Elemento padre: 328   */
      v.add(doc.createElement("td"));
      ((Element)v.get(331)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(328)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(332)).setAttribute("nombre","cbMarcaProducto" );
      ((Element)v.get(332)).setAttribute("id","datosCampos" );
      ((Element)v.get(332)).setAttribute("size","1" );
      ((Element)v.get(332)).setAttribute("onshtab","focalizaAceptar();" );
      ((Element)v.get(332)).setAttribute("multiple","N" );
      ((Element)v.get(332)).setAttribute("req","S" );
      ((Element)v.get(332)).setAttribute("valorinicial","" );
      ((Element)v.get(332)).setAttribute("textoinicial","" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(332)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */
      /* Termina nodo:332   */
      /* Termina nodo:331   */

      /* Empieza nodo:334 / Elemento padre: 328   */
      v.add(doc.createElement("td"));
      ((Element)v.get(334)).setAttribute("width","100%" );
      ((Element)v.get(328)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(335)).setAttribute("src","b.gif" );
      ((Element)v.get(335)).setAttribute("width","8" );
      ((Element)v.get(335)).setAttribute("height","8" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */
      /* Termina nodo:334   */
      /* Termina nodo:328   */

      /* Empieza nodo:336 / Elemento padre: 317   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(317)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("td"));
      ((Element)v.get(337)).setAttribute("colspan","4" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(338)).setAttribute("src","b.gif" );
      ((Element)v.get(338)).setAttribute("width","8" );
      ((Element)v.get(338)).setAttribute("height","8" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */
      /* Termina nodo:336   */
      /* Termina nodo:317   */
      /* Termina nodo:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:339 / Elemento padre: 314   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(314)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("table"));
      ((Element)v.get(341)).setAttribute("width","600" );
      ((Element)v.get(341)).setAttribute("border","0" );
      ((Element)v.get(341)).setAttribute("align","left" );
      ((Element)v.get(341)).setAttribute("cellspacing","0" );
      ((Element)v.get(341)).setAttribute("cellpadding","0" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(341)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
   }

   private void getXML1440(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(342)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(344)).setAttribute("src","b.gif" );
      ((Element)v.get(344)).setAttribute("width","8" );
      ((Element)v.get(344)).setAttribute("height","8" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:343   */

      /* Empieza nodo:345 / Elemento padre: 342   */
      v.add(doc.createElement("td"));
      ((Element)v.get(342)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(346)).setAttribute("nombre","lblUnidadNegocio" );
      ((Element)v.get(346)).setAttribute("alto","13" );
      ((Element)v.get(346)).setAttribute("filas","1" );
      ((Element)v.get(346)).setAttribute("valor","" );
      ((Element)v.get(346)).setAttribute("id","datosTitle" );
      ((Element)v.get(346)).setAttribute("cod","1338" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:345   */

      /* Empieza nodo:347 / Elemento padre: 342   */
      v.add(doc.createElement("td"));
      ((Element)v.get(342)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(348)).setAttribute("src","b.gif" );
      ((Element)v.get(348)).setAttribute("width","25" );
      ((Element)v.get(348)).setAttribute("height","8" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:347   */

      /* Empieza nodo:349 / Elemento padre: 342   */
      v.add(doc.createElement("td"));
      ((Element)v.get(342)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(350)).setAttribute("nombre","lblNegocio" );
      ((Element)v.get(350)).setAttribute("alto","13" );
      ((Element)v.get(350)).setAttribute("filas","1" );
      ((Element)v.get(350)).setAttribute("valor","" );
      ((Element)v.get(350)).setAttribute("id","datosTitle" );
      ((Element)v.get(350)).setAttribute("cod","588" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:349   */

      /* Empieza nodo:351 / Elemento padre: 342   */
      v.add(doc.createElement("td"));
      ((Element)v.get(351)).setAttribute("width","100%" );
      ((Element)v.get(342)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(352)).setAttribute("src","b.gif" );
      ((Element)v.get(352)).setAttribute("width","8" );
      ((Element)v.get(352)).setAttribute("height","8" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */
      /* Termina nodo:351   */
      /* Termina nodo:342   */

      /* Empieza nodo:353 / Elemento padre: 341   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(341)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(353)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(355)).setAttribute("src","b.gif" );
      ((Element)v.get(355)).setAttribute("width","8" );
      ((Element)v.get(355)).setAttribute("height","8" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */
      /* Termina nodo:354   */

      /* Empieza nodo:356 / Elemento padre: 353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(356)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(353)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(357)).setAttribute("nombre","cbUnidadNegocio" );
      ((Element)v.get(357)).setAttribute("id","datosCampos" );
      ((Element)v.get(357)).setAttribute("size","1" );
      ((Element)v.get(357)).setAttribute("multiple","N" );
      ((Element)v.get(357)).setAttribute("req","N" );
      ((Element)v.get(357)).setAttribute("valorinicial","" );
      ((Element)v.get(357)).setAttribute("textoinicial","" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */
      /* Termina nodo:357   */
      /* Termina nodo:356   */

      /* Empieza nodo:359 / Elemento padre: 353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(353)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(360)).setAttribute("src","b.gif" );
      ((Element)v.get(360)).setAttribute("width","25" );
      ((Element)v.get(360)).setAttribute("height","8" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:359   */

      /* Empieza nodo:361 / Elemento padre: 353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(361)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(353)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(362)).setAttribute("nombre","cbNegocio" );
      ((Element)v.get(362)).setAttribute("id","datosCampos" );
      ((Element)v.get(362)).setAttribute("size","1" );
      ((Element)v.get(362)).setAttribute("multiple","N" );
      ((Element)v.get(362)).setAttribute("req","N" );
      ((Element)v.get(362)).setAttribute("valorinicial","" );
      ((Element)v.get(362)).setAttribute("textoinicial","" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(362)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */
      /* Termina nodo:362   */
      /* Termina nodo:361   */

      /* Empieza nodo:364 / Elemento padre: 353   */
      v.add(doc.createElement("td"));
      ((Element)v.get(364)).setAttribute("width","100%" );
      ((Element)v.get(353)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(365)).setAttribute("src","b.gif" );
      ((Element)v.get(365)).setAttribute("width","8" );
      ((Element)v.get(365)).setAttribute("height","8" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */
      /* Termina nodo:364   */
      /* Termina nodo:353   */

      /* Empieza nodo:366 / Elemento padre: 341   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(341)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("td"));
      ((Element)v.get(367)).setAttribute("colspan","4" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(368)).setAttribute("src","b.gif" );
      ((Element)v.get(368)).setAttribute("width","8" );
      ((Element)v.get(368)).setAttribute("height","8" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */
      /* Termina nodo:367   */
      /* Termina nodo:366   */
      /* Termina nodo:341   */
      /* Termina nodo:340   */
      /* Termina nodo:339   */

      /* Empieza nodo:369 / Elemento padre: 314   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(314)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("td"));
      ((Element)v.get(369)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("table"));
      ((Element)v.get(371)).setAttribute("width","600" );
      ((Element)v.get(371)).setAttribute("border","0" );
      ((Element)v.get(371)).setAttribute("align","left" );
      ((Element)v.get(371)).setAttribute("cellspacing","0" );
      ((Element)v.get(371)).setAttribute("cellpadding","0" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(371)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(372)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(374)).setAttribute("src","b.gif" );
      ((Element)v.get(374)).setAttribute("width","8" );
      ((Element)v.get(374)).setAttribute("height","8" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */
      /* Termina nodo:373   */

      /* Empieza nodo:375 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(372)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(376)).setAttribute("nombre","lblSupergenerico" );
      ((Element)v.get(376)).setAttribute("alto","13" );
      ((Element)v.get(376)).setAttribute("filas","1" );
      ((Element)v.get(376)).setAttribute("valor","" );
      ((Element)v.get(376)).setAttribute("id","datosTitle" );
      ((Element)v.get(376)).setAttribute("cod","590" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */
      /* Termina nodo:375   */

      /* Empieza nodo:377 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(372)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(378)).setAttribute("src","b.gif" );
      ((Element)v.get(378)).setAttribute("width","25" );
      ((Element)v.get(378)).setAttribute("height","8" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:377   */

      /* Empieza nodo:379 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(372)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(380)).setAttribute("src","b.gif" );
      ((Element)v.get(380)).setAttribute("width","25" );
      ((Element)v.get(380)).setAttribute("height","8" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */
      /* Termina nodo:379   */

      /* Empieza nodo:381 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(372)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(382)).setAttribute("nombre","lblGenerico" );
      ((Element)v.get(382)).setAttribute("alto","13" );
      ((Element)v.get(382)).setAttribute("filas","1" );
      ((Element)v.get(382)).setAttribute("valor","" );
      ((Element)v.get(382)).setAttribute("id","datosTitle" );
      ((Element)v.get(382)).setAttribute("cod","589" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */
      /* Termina nodo:381   */

      /* Empieza nodo:383 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(383)).setAttribute("width","100%" );
      ((Element)v.get(372)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(384)).setAttribute("src","b.gif" );
      ((Element)v.get(384)).setAttribute("width","8" );
      ((Element)v.get(384)).setAttribute("height","8" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */
      /* Termina nodo:383   */
      /* Termina nodo:372   */

      /* Empieza nodo:385 / Elemento padre: 371   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(371)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("td"));
      ((Element)v.get(385)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(387)).setAttribute("src","b.gif" );
      ((Element)v.get(387)).setAttribute("width","8" );
      ((Element)v.get(387)).setAttribute("height","8" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */
      /* Termina nodo:386   */

      /* Empieza nodo:388 / Elemento padre: 385   */
      v.add(doc.createElement("td"));
      ((Element)v.get(388)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(385)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(389)).setAttribute("nombre","cbSupergenerico" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(389)).setAttribute("id","datosCampos" );
      ((Element)v.get(389)).setAttribute("max","30" );
      ((Element)v.get(389)).setAttribute("readonly","true" );
      ((Element)v.get(389)).setAttribute("tipo","" );
      ((Element)v.get(389)).setAttribute("onchange","" );
      ((Element)v.get(389)).setAttribute("req","N" );
      ((Element)v.get(389)).setAttribute("size","40" );
      ((Element)v.get(389)).setAttribute("valor","" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:388   */

      /* Empieza nodo:390 / Elemento padre: 385   */
      v.add(doc.createElement("td"));
      ((Element)v.get(390)).setAttribute("width","100%" );
      ((Element)v.get(385)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(391)).setAttribute("nombre","btnBuscarSuperGenerico" );
      ((Element)v.get(391)).setAttribute("ID","botonContenido" );
      ((Element)v.get(391)).setAttribute("tipo","html" );
      ((Element)v.get(391)).setAttribute("estado","false" );
      ((Element)v.get(391)).setAttribute("cod","1" );
      ((Element)v.get(391)).setAttribute("accion","buscarSuperGenerico();" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */
      /* Termina nodo:390   */

      /* Empieza nodo:392 / Elemento padre: 385   */
      v.add(doc.createElement("td"));
      ((Element)v.get(385)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(393)).setAttribute("src","b.gif" );
      ((Element)v.get(393)).setAttribute("width","25" );
      ((Element)v.get(393)).setAttribute("height","8" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));
      /* Termina nodo:393   */
      /* Termina nodo:392   */

      /* Empieza nodo:394 / Elemento padre: 385   */
      v.add(doc.createElement("td"));
      ((Element)v.get(394)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(385)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(395)).setAttribute("nombre","cbGenerico" );
      ((Element)v.get(395)).setAttribute("id","datosCampos" );
      ((Element)v.get(395)).setAttribute("max","30" );
      ((Element)v.get(395)).setAttribute("readonly","true" );
      ((Element)v.get(395)).setAttribute("tipo","" );
      ((Element)v.get(395)).setAttribute("onchange","" );
      ((Element)v.get(395)).setAttribute("req","N" );
      ((Element)v.get(395)).setAttribute("size","40" );
      ((Element)v.get(395)).setAttribute("valor","" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */
      /* Termina nodo:394   */

      /* Empieza nodo:396 / Elemento padre: 385   */
      v.add(doc.createElement("td"));
      ((Element)v.get(385)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(397)).setAttribute("nombre","btnBuscarGenerico" );
      ((Element)v.get(397)).setAttribute("ID","botonContenido" );
      ((Element)v.get(397)).setAttribute("tipo","html" );
      ((Element)v.get(397)).setAttribute("estado","false" );
      ((Element)v.get(397)).setAttribute("cod","1" );
      ((Element)v.get(397)).setAttribute("accion","buscarGenerico();" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */

      /* Empieza nodo:398 / Elemento padre: 396   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(398)).setAttribute("src","b.gif" );
      ((Element)v.get(398)).setAttribute("width","25" );
      ((Element)v.get(398)).setAttribute("height","8" );
      ((Element)v.get(396)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */
      /* Termina nodo:396   */

      /* Empieza nodo:399 / Elemento padre: 385   */
      v.add(doc.createElement("td"));
      ((Element)v.get(399)).setAttribute("width","100%" );
      ((Element)v.get(385)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(400)).setAttribute("src","b.gif" );
      ((Element)v.get(400)).setAttribute("width","8" );
      ((Element)v.get(400)).setAttribute("height","8" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));
      /* Termina nodo:400   */
      /* Termina nodo:399   */
      /* Termina nodo:385   */

      /* Empieza nodo:401 / Elemento padre: 371   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(371)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("td"));
      ((Element)v.get(402)).setAttribute("colspan","4" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(403)).setAttribute("src","b.gif" );
      ((Element)v.get(403)).setAttribute("width","8" );
      ((Element)v.get(403)).setAttribute("height","8" );
      ((Element)v.get(402)).appendChild((Element)v.get(403));
      /* Termina nodo:403   */
      /* Termina nodo:402   */
      /* Termina nodo:401   */
      /* Termina nodo:371   */
      /* Termina nodo:370   */
      /* Termina nodo:369   */
      /* Termina nodo:314   */
      /* Termina nodo:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:404 / Elemento padre: 307   */
      v.add(doc.createElement("td"));
      ((Element)v.get(307)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(405)).setAttribute("src","b.gif" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */
      /* Termina nodo:404   */
      /* Termina nodo:307   */

      /* Empieza nodo:406 / Elemento padre: 299   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(299)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("td"));
      ((Element)v.get(407)).setAttribute("width","12" );
      ((Element)v.get(407)).setAttribute("align","center" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(408)).setAttribute("src","b.gif" );
      ((Element)v.get(408)).setAttribute("width","12" );
      ((Element)v.get(408)).setAttribute("height","12" );
      ((Element)v.get(407)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */
      /* Termina nodo:407   */

      /* Empieza nodo:409 / Elemento padre: 406   */
   }

   private void getXML1710(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(409)).setAttribute("width","756" );
      ((Element)v.get(406)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(410)).setAttribute("src","b.gif" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */
      /* Termina nodo:409   */

      /* Empieza nodo:411 / Elemento padre: 406   */
      v.add(doc.createElement("td"));
      ((Element)v.get(411)).setAttribute("width","12" );
      ((Element)v.get(406)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(412)).setAttribute("src","b.gif" );
      ((Element)v.get(412)).setAttribute("width","12" );
      ((Element)v.get(412)).setAttribute("height","1" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */
      /* Termina nodo:411   */
      /* Termina nodo:406   */
      /* Termina nodo:299   */
      /* Termina nodo:298   */

      /* Empieza nodo:413 / Elemento padre: 27   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(413)).setAttribute("nombre","capa3" );
      ((Element)v.get(413)).setAttribute("alto","200" );
      ((Element)v.get(413)).setAttribute("ancho","100%" );
      ((Element)v.get(413)).setAttribute("colorf","" );
      ((Element)v.get(413)).setAttribute("borde","0" );
      ((Element)v.get(413)).setAttribute("imagenf","" );
      ((Element)v.get(413)).setAttribute("repeat","" );
      ((Element)v.get(413)).setAttribute("padding","" );
      ((Element)v.get(413)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(413)).setAttribute("contravsb","" );
      ((Element)v.get(413)).setAttribute("x","0" );
      ((Element)v.get(413)).setAttribute("y","109" );
      ((Element)v.get(413)).setAttribute("zindex","" );
      ((Element)v.get(27)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("table"));
      ((Element)v.get(414)).setAttribute("width","100%" );
      ((Element)v.get(414)).setAttribute("border","0" );
      ((Element)v.get(414)).setAttribute("cellspacing","0" );
      ((Element)v.get(414)).setAttribute("cellpadding","0" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(414)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("td"));
      ((Element)v.get(416)).setAttribute("width","12" );
      ((Element)v.get(416)).setAttribute("align","center" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));

      /* Empieza nodo:417 / Elemento padre: 416   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(417)).setAttribute("src","b.gif" );
      ((Element)v.get(417)).setAttribute("width","25" );
      ((Element)v.get(417)).setAttribute("height","12" );
      ((Element)v.get(416)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */
      /* Termina nodo:416   */

      /* Empieza nodo:418 / Elemento padre: 415   */
      v.add(doc.createElement("td"));
      ((Element)v.get(418)).setAttribute("width","750" );
      ((Element)v.get(415)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(419)).setAttribute("src","b.gif" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */
      /* Termina nodo:418   */

      /* Empieza nodo:420 / Elemento padre: 415   */
      v.add(doc.createElement("td"));
      ((Element)v.get(420)).setAttribute("width","12" );
      ((Element)v.get(415)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(421)).setAttribute("src","b.gif" );
      ((Element)v.get(421)).setAttribute("width","26" );
      ((Element)v.get(421)).setAttribute("height","1" );
      ((Element)v.get(420)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */
      /* Termina nodo:420   */
      /* Termina nodo:415   */

      /* Empieza nodo:422 / Elemento padre: 414   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(414)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("td"));
      ((Element)v.get(422)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(424)).setAttribute("src","b.gif" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */
      /* Termina nodo:423   */

      /* Empieza nodo:425 / Elemento padre: 422   */
      v.add(doc.createElement("td"));
      ((Element)v.get(422)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(425)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(427)).setAttribute("class","legend" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(428)).setAttribute("nombre","lblBloqueOferta" );
      ((Element)v.get(428)).setAttribute("alto","13" );
      ((Element)v.get(428)).setAttribute("filas","1" );
      ((Element)v.get(428)).setAttribute("valor","" );
      ((Element)v.get(428)).setAttribute("id","legend" );
      ((Element)v.get(428)).setAttribute("cod","00336" );
      ((Element)v.get(427)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */
      /* Termina nodo:427   */

      /* Empieza nodo:429 / Elemento padre: 426   */
      v.add(doc.createElement("table"));
      ((Element)v.get(429)).setAttribute("width","100%" );
      ((Element)v.get(429)).setAttribute("border","0" );
      ((Element)v.get(429)).setAttribute("align","center" );
      ((Element)v.get(429)).setAttribute("cellspacing","0" );
      ((Element)v.get(429)).setAttribute("cellpadding","0" );
      ((Element)v.get(426)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("tr"));
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(429)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("td"));
      ((Element)v.get(430)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("table"));
      ((Element)v.get(432)).setAttribute("width","600" );
      ((Element)v.get(432)).setAttribute("border","0" );
      ((Element)v.get(432)).setAttribute("align","left" );
      ((Element)v.get(432)).setAttribute("cellspacing","0" );
      ((Element)v.get(432)).setAttribute("cellpadding","0" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(432)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("td"));
      ((Element)v.get(434)).setAttribute("colspan","4" );
      ((Element)v.get(433)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(435)).setAttribute("src","b.gif" );
      ((Element)v.get(435)).setAttribute("width","8" );
      ((Element)v.get(435)).setAttribute("height","8" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */
      /* Termina nodo:434   */
      /* Termina nodo:433   */

      /* Empieza nodo:436 / Elemento padre: 432   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(432)).appendChild((Element)v.get(436));

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
      ((Element)v.get(440)).setAttribute("nombre","lblTipoOferta" );
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
      ((Element)v.get(444)).setAttribute("nombre","lblCicloVida" );
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

      /* Empieza nodo:447 / Elemento padre: 432   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(432)).appendChild((Element)v.get(447));

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
      ((Element)v.get(447)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(451)).setAttribute("nombre","cbTipoOferta" );
      ((Element)v.get(451)).setAttribute("id","datosCampos" );
      ((Element)v.get(451)).setAttribute("size","1" );
      ((Element)v.get(451)).setAttribute("multiple","N" );
      ((Element)v.get(451)).setAttribute("req","S" );
      ((Element)v.get(451)).setAttribute("onshtab","focalizaAceptar();" );
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
   }

   private void getXML1890(Document doc) {
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
      ((Element)v.get(456)).setAttribute("nombre","cbCicloVida" );
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

      /* Empieza nodo:460 / Elemento padre: 432   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(432)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("td"));
      ((Element)v.get(461)).setAttribute("colspan","4" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));

      /* Empieza nodo:462 / Elemento padre: 461   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(462)).setAttribute("src","b.gif" );
      ((Element)v.get(462)).setAttribute("width","8" );
      ((Element)v.get(462)).setAttribute("height","78" );
      ((Element)v.get(461)).appendChild((Element)v.get(462));
      /* Termina nodo:462   */
      /* Termina nodo:461   */
      /* Termina nodo:460   */
      /* Termina nodo:432   */
      /* Termina nodo:431   */
      /* Termina nodo:430   */
      /* Termina nodo:429   */
      /* Termina nodo:426   */
      /* Termina nodo:425   */

      /* Empieza nodo:463 / Elemento padre: 422   */
      v.add(doc.createElement("td"));
      ((Element)v.get(422)).appendChild((Element)v.get(463));

      /* Empieza nodo:464 / Elemento padre: 463   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(464)).setAttribute("src","b.gif" );
      ((Element)v.get(463)).appendChild((Element)v.get(464));
      /* Termina nodo:464   */
      /* Termina nodo:463   */
      /* Termina nodo:422   */

      /* Empieza nodo:465 / Elemento padre: 414   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(414)).appendChild((Element)v.get(465));

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
      /* Termina nodo:414   */
      /* Termina nodo:413   */

      /* Empieza nodo:472 / Elemento padre: 27   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(472)).setAttribute("nombre","capa4" );
      ((Element)v.get(472)).setAttribute("alto","200" );
      ((Element)v.get(472)).setAttribute("ancho","100%" );
      ((Element)v.get(472)).setAttribute("colorf","" );
      ((Element)v.get(472)).setAttribute("borde","0" );
      ((Element)v.get(472)).setAttribute("imagenf","" );
      ((Element)v.get(472)).setAttribute("repeat","" );
      ((Element)v.get(472)).setAttribute("padding","" );
      ((Element)v.get(472)).setAttribute("visibilidad","" );
      ((Element)v.get(472)).setAttribute("contravsb","" );
      ((Element)v.get(472)).setAttribute("x","0" );
      ((Element)v.get(472)).setAttribute("y","109" );
      ((Element)v.get(472)).setAttribute("zindex","" );
      ((Element)v.get(27)).appendChild((Element)v.get(472));

      /* Empieza nodo:473 / Elemento padre: 472   */
      v.add(doc.createElement("table"));
      ((Element)v.get(473)).setAttribute("width","100%" );
      ((Element)v.get(473)).setAttribute("border","0" );
      ((Element)v.get(473)).setAttribute("cellspacing","0" );
      ((Element)v.get(473)).setAttribute("cellpadding","0" );
      ((Element)v.get(472)).appendChild((Element)v.get(473));

      /* Empieza nodo:474 / Elemento padre: 473   */
      v.add(doc.createElement("tr"));
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(473)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("td"));
      ((Element)v.get(475)).setAttribute("width","12" );
      ((Element)v.get(475)).setAttribute("align","center" );
      ((Element)v.get(474)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(476)).setAttribute("src","b.gif" );
      ((Element)v.get(476)).setAttribute("width","25" );
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
      ((Element)v.get(480)).setAttribute("width","26" );
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
      ((Element)v.get(487)).setAttribute("nombre","lblBloqueProducto" );
      ((Element)v.get(487)).setAttribute("alto","13" );
      ((Element)v.get(487)).setAttribute("filas","1" );
      ((Element)v.get(487)).setAttribute("valor","" );
      ((Element)v.get(487)).setAttribute("id","legend" );
      ((Element)v.get(487)).setAttribute("cod","00337" );
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
      ((Element)v.get(491)).setAttribute("width","600" );
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
      ((Element)v.get(497)).setAttribute("height","8" );
      ((Element)v.get(496)).appendChild((Element)v.get(497));
      /* Termina nodo:497   */
      /* Termina nodo:496   */

      /* Empieza nodo:498 / Elemento padre: 495   */
      v.add(doc.createElement("td"));
      ((Element)v.get(495)).appendChild((Element)v.get(498));

      /* Empieza nodo:499 / Elemento padre: 498   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(499)).setAttribute("nombre","lblCodProducto" );
      ((Element)v.get(499)).setAttribute("alto","13" );
      ((Element)v.get(499)).setAttribute("filas","1" );
      ((Element)v.get(499)).setAttribute("valor","" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(499)).setAttribute("id","datosTitle" );
      ((Element)v.get(499)).setAttribute("cod","337" );
      ((Element)v.get(498)).appendChild((Element)v.get(499));
      /* Termina nodo:499   */
      /* Termina nodo:498   */

      /* Empieza nodo:500 / Elemento padre: 495   */
      v.add(doc.createElement("td"));
      ((Element)v.get(500)).setAttribute("width","100%" );
      ((Element)v.get(495)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(501)).setAttribute("src","b.gif" );
      ((Element)v.get(501)).setAttribute("width","8" );
      ((Element)v.get(501)).setAttribute("height","8" );
      ((Element)v.get(500)).appendChild((Element)v.get(501));
      /* Termina nodo:501   */
      /* Termina nodo:500   */
      /* Termina nodo:495   */

      /* Empieza nodo:502 / Elemento padre: 491   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(491)).appendChild((Element)v.get(502));

      /* Empieza nodo:503 / Elemento padre: 502   */
      v.add(doc.createElement("td"));
      ((Element)v.get(502)).appendChild((Element)v.get(503));

      /* Empieza nodo:504 / Elemento padre: 503   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(504)).setAttribute("src","b.gif" );
      ((Element)v.get(504)).setAttribute("width","8" );
      ((Element)v.get(504)).setAttribute("height","8" );
      ((Element)v.get(503)).appendChild((Element)v.get(504));
      /* Termina nodo:504   */
      /* Termina nodo:503   */

      /* Empieza nodo:505 / Elemento padre: 502   */
      v.add(doc.createElement("td"));
      ((Element)v.get(505)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(502)).appendChild((Element)v.get(505));

      /* Empieza nodo:506 / Elemento padre: 505   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(506)).setAttribute("nombre","txtCodProducto" );
      ((Element)v.get(506)).setAttribute("id","datosCampos" );
      ((Element)v.get(506)).setAttribute("max","20" );
      ((Element)v.get(506)).setAttribute("tipo","" );
      ((Element)v.get(506)).setAttribute("onchange","limpiaOidOculto();" );
      ((Element)v.get(506)).setAttribute("req","S" );
      ((Element)v.get(506)).setAttribute("onshtab","focalizaAceptar();" );
      ((Element)v.get(506)).setAttribute("size","26" );
      ((Element)v.get(506)).setAttribute("valor","" );
      ((Element)v.get(506)).setAttribute("validacion","" );
      ((Element)v.get(505)).appendChild((Element)v.get(506));
      /* Termina nodo:506   */
      /* Termina nodo:505   */

      /* Empieza nodo:507 / Elemento padre: 502   */
      v.add(doc.createElement("td"));
      ((Element)v.get(502)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(508)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(508)).setAttribute("ID","botonContenido" );
      ((Element)v.get(508)).setAttribute("tipo","html" );
      ((Element)v.get(508)).setAttribute("accion","accionBuscarProducto();" );
      ((Element)v.get(508)).setAttribute("estado","false" );
      ((Element)v.get(508)).setAttribute("cod","1" );
      ((Element)v.get(507)).appendChild((Element)v.get(508));
      /* Termina nodo:508   */
      /* Termina nodo:507   */

      /* Empieza nodo:509 / Elemento padre: 502   */
      v.add(doc.createElement("td"));
      ((Element)v.get(509)).setAttribute("width","100%" );
      ((Element)v.get(502)).appendChild((Element)v.get(509));

      /* Empieza nodo:510 / Elemento padre: 509   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(510)).setAttribute("src","b.gif" );
      ((Element)v.get(510)).setAttribute("width","8" );
      ((Element)v.get(510)).setAttribute("height","8" );
      ((Element)v.get(509)).appendChild((Element)v.get(510));
      /* Termina nodo:510   */
      /* Termina nodo:509   */
      /* Termina nodo:502   */

      /* Empieza nodo:511 / Elemento padre: 491   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(491)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
      v.add(doc.createElement("td"));
      ((Element)v.get(512)).setAttribute("colspan","4" );
      ((Element)v.get(511)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(513)).setAttribute("src","b.gif" );
      ((Element)v.get(513)).setAttribute("width","8" );
      ((Element)v.get(513)).setAttribute("height","8" );
      ((Element)v.get(512)).appendChild((Element)v.get(513));
      /* Termina nodo:513   */
      /* Termina nodo:512   */
      /* Termina nodo:511   */
      /* Termina nodo:491   */
      /* Termina nodo:490   */
      /* Termina nodo:489   */

      /* Empieza nodo:514 / Elemento padre: 488   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(488)).appendChild((Element)v.get(514));

      /* Empieza nodo:515 / Elemento padre: 514   */
      v.add(doc.createElement("td"));
      ((Element)v.get(514)).appendChild((Element)v.get(515));

      /* Empieza nodo:516 / Elemento padre: 515   */
      v.add(doc.createElement("table"));
      ((Element)v.get(516)).setAttribute("width","600" );
      ((Element)v.get(516)).setAttribute("border","0" );
      ((Element)v.get(516)).setAttribute("align","left" );
      ((Element)v.get(516)).setAttribute("cellspacing","0" );
      ((Element)v.get(516)).setAttribute("cellpadding","0" );
      ((Element)v.get(515)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(516)).appendChild((Element)v.get(517));

      /* Empieza nodo:518 / Elemento padre: 517   */
      v.add(doc.createElement("td"));
      ((Element)v.get(517)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(519)).setAttribute("src","b.gif" );
      ((Element)v.get(519)).setAttribute("width","8" );
      ((Element)v.get(519)).setAttribute("height","8" );
      ((Element)v.get(518)).appendChild((Element)v.get(519));
      /* Termina nodo:519   */
      /* Termina nodo:518   */

      /* Empieza nodo:520 / Elemento padre: 517   */
      v.add(doc.createElement("td"));
      ((Element)v.get(517)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(521)).setAttribute("nombre","lblTipoOferta2" );
      ((Element)v.get(521)).setAttribute("alto","13" );
      ((Element)v.get(521)).setAttribute("filas","1" );
      ((Element)v.get(521)).setAttribute("valor","" );
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(521)).setAttribute("id","datosTitle" );
      ((Element)v.get(521)).setAttribute("cod","608" );
      ((Element)v.get(520)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */
      /* Termina nodo:520   */

      /* Empieza nodo:522 / Elemento padre: 517   */
      v.add(doc.createElement("td"));
      ((Element)v.get(517)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(523)).setAttribute("src","b.gif" );
      ((Element)v.get(523)).setAttribute("width","25" );
      ((Element)v.get(523)).setAttribute("height","8" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */
      /* Termina nodo:522   */

      /* Empieza nodo:524 / Elemento padre: 517   */
      v.add(doc.createElement("td"));
      ((Element)v.get(517)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(525)).setAttribute("nombre","lblCicloVida2" );
      ((Element)v.get(525)).setAttribute("alto","13" );
      ((Element)v.get(525)).setAttribute("filas","1" );
      ((Element)v.get(525)).setAttribute("valor","" );
      ((Element)v.get(525)).setAttribute("id","datosTitle" );
      ((Element)v.get(525)).setAttribute("cod","581" );
      ((Element)v.get(524)).appendChild((Element)v.get(525));
      /* Termina nodo:525   */
      /* Termina nodo:524   */

      /* Empieza nodo:526 / Elemento padre: 517   */
      v.add(doc.createElement("td"));
      ((Element)v.get(517)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(527)).setAttribute("src","b.gif" );
      ((Element)v.get(527)).setAttribute("width","25" );
      ((Element)v.get(527)).setAttribute("height","8" );
      ((Element)v.get(526)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */
      /* Termina nodo:526   */

      /* Empieza nodo:528 / Elemento padre: 517   */
      v.add(doc.createElement("td"));
      ((Element)v.get(517)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(529)).setAttribute("nombre","lblIndAgrup" );
      ((Element)v.get(529)).setAttribute("alto","13" );
      ((Element)v.get(529)).setAttribute("filas","1" );
      ((Element)v.get(529)).setAttribute("valor","" );
      ((Element)v.get(529)).setAttribute("id","datosTitle" );
      ((Element)v.get(529)).setAttribute("cod","3401" );
      ((Element)v.get(528)).appendChild((Element)v.get(529));
      /* Termina nodo:529   */
      /* Termina nodo:528   */

      /* Empieza nodo:530 / Elemento padre: 517   */
      v.add(doc.createElement("td"));
      ((Element)v.get(530)).setAttribute("width","100%" );
      ((Element)v.get(517)).appendChild((Element)v.get(530));

      /* Empieza nodo:531 / Elemento padre: 530   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(531)).setAttribute("src","b.gif" );
      ((Element)v.get(531)).setAttribute("width","8" );
      ((Element)v.get(531)).setAttribute("height","8" );
      ((Element)v.get(530)).appendChild((Element)v.get(531));
      /* Termina nodo:531   */
      /* Termina nodo:530   */
      /* Termina nodo:517   */

      /* Empieza nodo:532 / Elemento padre: 516   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(516)).appendChild((Element)v.get(532));

      /* Empieza nodo:533 / Elemento padre: 532   */
      v.add(doc.createElement("td"));
      ((Element)v.get(532)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(534)).setAttribute("src","b.gif" );
      ((Element)v.get(534)).setAttribute("width","8" );
      ((Element)v.get(534)).setAttribute("height","8" );
      ((Element)v.get(533)).appendChild((Element)v.get(534));
      /* Termina nodo:534   */
      /* Termina nodo:533   */

      /* Empieza nodo:535 / Elemento padre: 532   */
      v.add(doc.createElement("td"));
      ((Element)v.get(535)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(535)).setAttribute("valign","bottom" );
      ((Element)v.get(532)).appendChild((Element)v.get(535));

      /* Empieza nodo:536 / Elemento padre: 535   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(536)).setAttribute("nombre","cbTipoOferta2" );
      ((Element)v.get(536)).setAttribute("id","datosCampos" );
      ((Element)v.get(536)).setAttribute("size","1" );
      ((Element)v.get(536)).setAttribute("multiple","N" );
      ((Element)v.get(536)).setAttribute("req","N" );
      ((Element)v.get(536)).setAttribute("valorinicial","" );
      ((Element)v.get(536)).setAttribute("textoinicial","" );
      ((Element)v.get(535)).appendChild((Element)v.get(536));

      /* Empieza nodo:537 / Elemento padre: 536   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(536)).appendChild((Element)v.get(537));
      /* Termina nodo:537   */
      /* Termina nodo:536   */
      /* Termina nodo:535   */

      /* Empieza nodo:538 / Elemento padre: 532   */
      v.add(doc.createElement("td"));
      ((Element)v.get(532)).appendChild((Element)v.get(538));

      /* Empieza nodo:539 / Elemento padre: 538   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(539)).setAttribute("src","b.gif" );
      ((Element)v.get(539)).setAttribute("width","25" );
      ((Element)v.get(539)).setAttribute("height","8" );
      ((Element)v.get(538)).appendChild((Element)v.get(539));
      /* Termina nodo:539   */
      /* Termina nodo:538   */

      /* Empieza nodo:540 / Elemento padre: 532   */
      v.add(doc.createElement("td"));
      ((Element)v.get(540)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(532)).appendChild((Element)v.get(540));

      /* Empieza nodo:541 / Elemento padre: 540   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(541)).setAttribute("nombre","cbCicloVida2" );
      ((Element)v.get(541)).setAttribute("id","datosCampos" );
      ((Element)v.get(541)).setAttribute("size","1" );
      ((Element)v.get(541)).setAttribute("multiple","N" );
      ((Element)v.get(541)).setAttribute("req","N" );
      ((Element)v.get(541)).setAttribute("valorinicial","" );
      ((Element)v.get(541)).setAttribute("textoinicial","" );
      ((Element)v.get(540)).appendChild((Element)v.get(541));

      /* Empieza nodo:542 / Elemento padre: 541   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(541)).appendChild((Element)v.get(542));
      /* Termina nodo:542   */
      /* Termina nodo:541   */
      /* Termina nodo:540   */

      /* Empieza nodo:543 / Elemento padre: 532   */
   }

   private void getXML2250(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(532)).appendChild((Element)v.get(543));

      /* Empieza nodo:544 / Elemento padre: 543   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(544)).setAttribute("src","b.gif" );
      ((Element)v.get(544)).setAttribute("width","25" );
      ((Element)v.get(544)).setAttribute("height","8" );
      ((Element)v.get(543)).appendChild((Element)v.get(544));
      /* Termina nodo:544   */
      /* Termina nodo:543   */

      /* Empieza nodo:545 / Elemento padre: 532   */
      v.add(doc.createElement("td"));
      ((Element)v.get(545)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(532)).appendChild((Element)v.get(545));

      /* Empieza nodo:546 / Elemento padre: 545   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(546)).setAttribute("nombre","cbIndAgrup" );
      ((Element)v.get(546)).setAttribute("id","datosCampos" );
      ((Element)v.get(546)).setAttribute("size","1" );
      ((Element)v.get(546)).setAttribute("multiple","N" );
      ((Element)v.get(546)).setAttribute("req","N" );
      ((Element)v.get(546)).setAttribute("ontab","tabDatosAsociados();" );
      ((Element)v.get(546)).setAttribute("valorinicial","" );
      ((Element)v.get(546)).setAttribute("textoinicial","" );
      ((Element)v.get(545)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(546)).appendChild((Element)v.get(547));
      /* Termina nodo:547   */
      /* Termina nodo:546   */
      /* Termina nodo:545   */

      /* Empieza nodo:548 / Elemento padre: 532   */
      v.add(doc.createElement("td"));
      ((Element)v.get(548)).setAttribute("width","100%" );
      ((Element)v.get(532)).appendChild((Element)v.get(548));

      /* Empieza nodo:549 / Elemento padre: 548   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(549)).setAttribute("src","b.gif" );
      ((Element)v.get(549)).setAttribute("width","8" );
      ((Element)v.get(549)).setAttribute("height","8" );
      ((Element)v.get(548)).appendChild((Element)v.get(549));
      /* Termina nodo:549   */
      /* Termina nodo:548   */
      /* Termina nodo:532   */

      /* Empieza nodo:550 / Elemento padre: 516   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(516)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("td"));
      ((Element)v.get(551)).setAttribute("colspan","4" );
      ((Element)v.get(550)).appendChild((Element)v.get(551));

      /* Empieza nodo:552 / Elemento padre: 551   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(552)).setAttribute("src","b.gif" );
      ((Element)v.get(552)).setAttribute("width","8" );
      ((Element)v.get(552)).setAttribute("height","45" );
      ((Element)v.get(551)).appendChild((Element)v.get(552));
      /* Termina nodo:552   */
      /* Termina nodo:551   */
      /* Termina nodo:550   */
      /* Termina nodo:516   */
      /* Termina nodo:515   */
      /* Termina nodo:514   */
      /* Termina nodo:488   */
      /* Termina nodo:485   */
      /* Termina nodo:484   */

      /* Empieza nodo:553 / Elemento padre: 481   */
      v.add(doc.createElement("td"));
      ((Element)v.get(481)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(554)).setAttribute("src","b.gif" );
      ((Element)v.get(553)).appendChild((Element)v.get(554));
      /* Termina nodo:554   */
      /* Termina nodo:553   */
      /* Termina nodo:481   */

      /* Empieza nodo:555 / Elemento padre: 473   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(473)).appendChild((Element)v.get(555));

      /* Empieza nodo:556 / Elemento padre: 555   */
      v.add(doc.createElement("td"));
      ((Element)v.get(556)).setAttribute("width","12" );
      ((Element)v.get(556)).setAttribute("align","center" );
      ((Element)v.get(555)).appendChild((Element)v.get(556));

      /* Empieza nodo:557 / Elemento padre: 556   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(557)).setAttribute("src","b.gif" );
      ((Element)v.get(557)).setAttribute("width","24" );
      ((Element)v.get(557)).setAttribute("height","12" );
      ((Element)v.get(556)).appendChild((Element)v.get(557));
      /* Termina nodo:557   */
      /* Termina nodo:556   */

      /* Empieza nodo:558 / Elemento padre: 555   */
      v.add(doc.createElement("td"));
      ((Element)v.get(558)).setAttribute("width","756" );
      ((Element)v.get(555)).appendChild((Element)v.get(558));

      /* Empieza nodo:559 / Elemento padre: 558   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(559)).setAttribute("src","b.gif" );
      ((Element)v.get(558)).appendChild((Element)v.get(559));
      /* Termina nodo:559   */
      /* Termina nodo:558   */

      /* Empieza nodo:560 / Elemento padre: 555   */
      v.add(doc.createElement("td"));
      ((Element)v.get(560)).setAttribute("width","12" );
      ((Element)v.get(555)).appendChild((Element)v.get(560));

      /* Empieza nodo:561 / Elemento padre: 560   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(561)).setAttribute("src","b.gif" );
      ((Element)v.get(561)).setAttribute("width","24" );
      ((Element)v.get(561)).setAttribute("height","1" );
      ((Element)v.get(560)).appendChild((Element)v.get(561));
      /* Termina nodo:561   */
      /* Termina nodo:560   */
      /* Termina nodo:555   */
      /* Termina nodo:473   */
      /* Termina nodo:472   */

      /* Empieza nodo:562 / Elemento padre: 27   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(562)).setAttribute("nombre","capa5" );
      ((Element)v.get(562)).setAttribute("alto","100" );
      ((Element)v.get(562)).setAttribute("ancho","100%" );
      ((Element)v.get(562)).setAttribute("colorf","" );
      ((Element)v.get(562)).setAttribute("borde","0" );
      ((Element)v.get(562)).setAttribute("imagenf","" );
      ((Element)v.get(562)).setAttribute("repeat","" );
      ((Element)v.get(562)).setAttribute("padding","" );
      ((Element)v.get(562)).setAttribute("visibilidad","" );
      ((Element)v.get(562)).setAttribute("contravsb","" );
      ((Element)v.get(562)).setAttribute("x","0" );
      ((Element)v.get(562)).setAttribute("y","764" );
      ((Element)v.get(562)).setAttribute("zindex","" );
      ((Element)v.get(27)).appendChild((Element)v.get(562));

      /* Empieza nodo:563 / Elemento padre: 562   */
      v.add(doc.createElement("table"));
      ((Element)v.get(563)).setAttribute("width","100%" );
      ((Element)v.get(563)).setAttribute("border","0" );
      ((Element)v.get(563)).setAttribute("cellspacing","0" );
      ((Element)v.get(563)).setAttribute("cellpadding","0" );
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(562)).appendChild((Element)v.get(563));

      /* Empieza nodo:564 / Elemento padre: 563   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(564)).setAttribute("id","trMensajesEspacio" );
      ((Element)v.get(563)).appendChild((Element)v.get(564));

      /* Empieza nodo:565 / Elemento padre: 564   */
      v.add(doc.createElement("td"));
      ((Element)v.get(565)).setAttribute("width","12" );
      ((Element)v.get(565)).setAttribute("align","center" );
      ((Element)v.get(564)).appendChild((Element)v.get(565));

      /* Empieza nodo:566 / Elemento padre: 565   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(566)).setAttribute("src","b.gif" );
      ((Element)v.get(566)).setAttribute("width","12" );
      ((Element)v.get(566)).setAttribute("height","12" );
      ((Element)v.get(565)).appendChild((Element)v.get(566));
      /* Termina nodo:566   */
      /* Termina nodo:565   */

      /* Empieza nodo:567 / Elemento padre: 564   */
      v.add(doc.createElement("td"));
      ((Element)v.get(567)).setAttribute("width","750" );
      ((Element)v.get(564)).appendChild((Element)v.get(567));

      /* Empieza nodo:568 / Elemento padre: 567   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(568)).setAttribute("src","b.gif" );
      ((Element)v.get(567)).appendChild((Element)v.get(568));
      /* Termina nodo:568   */
      /* Termina nodo:567   */

      /* Empieza nodo:569 / Elemento padre: 564   */
      v.add(doc.createElement("td"));
      ((Element)v.get(569)).setAttribute("width","12" );
      ((Element)v.get(564)).appendChild((Element)v.get(569));

      /* Empieza nodo:570 / Elemento padre: 569   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(570)).setAttribute("src","b.gif" );
      ((Element)v.get(570)).setAttribute("width","12" );
      ((Element)v.get(570)).setAttribute("height","1" );
      ((Element)v.get(569)).appendChild((Element)v.get(570));
      /* Termina nodo:570   */
      /* Termina nodo:569   */
      /* Termina nodo:564   */

      /* Empieza nodo:571 / Elemento padre: 563   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(571)).setAttribute("id","trMensajes" );
      ((Element)v.get(563)).appendChild((Element)v.get(571));

      /* Empieza nodo:572 / Elemento padre: 571   */
      v.add(doc.createElement("td"));
      ((Element)v.get(571)).appendChild((Element)v.get(572));

      /* Empieza nodo:573 / Elemento padre: 572   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(573)).setAttribute("src","b.gif" );
      ((Element)v.get(572)).appendChild((Element)v.get(573));
      /* Termina nodo:573   */
      /* Termina nodo:572   */

      /* Empieza nodo:574 / Elemento padre: 571   */
      v.add(doc.createElement("td"));
      ((Element)v.get(571)).appendChild((Element)v.get(574));

      /* Empieza nodo:575 / Elemento padre: 574   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(574)).appendChild((Element)v.get(575));

      /* Empieza nodo:576 / Elemento padre: 575   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(576)).setAttribute("class","legend" );
      ((Element)v.get(575)).appendChild((Element)v.get(576));

      /* Empieza nodo:577 / Elemento padre: 576   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(577)).setAttribute("nombre","lblOtrosDatos" );
      ((Element)v.get(577)).setAttribute("alto","13" );
      ((Element)v.get(577)).setAttribute("filas","1" );
      ((Element)v.get(577)).setAttribute("valor","" );
      ((Element)v.get(577)).setAttribute("id","legend" );
      ((Element)v.get(577)).setAttribute("cod","00167" );
      ((Element)v.get(576)).appendChild((Element)v.get(577));
      /* Termina nodo:577   */
      /* Termina nodo:576   */

      /* Empieza nodo:578 / Elemento padre: 575   */
      v.add(doc.createElement("table"));
      ((Element)v.get(578)).setAttribute("width","100%" );
      ((Element)v.get(578)).setAttribute("border","0" );
      ((Element)v.get(578)).setAttribute("align","center" );
      ((Element)v.get(578)).setAttribute("cellspacing","0" );
      ((Element)v.get(578)).setAttribute("cellpadding","0" );
      ((Element)v.get(575)).appendChild((Element)v.get(578));

      /* Empieza nodo:579 / Elemento padre: 578   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(578)).appendChild((Element)v.get(579));

      /* Empieza nodo:580 / Elemento padre: 579   */
      v.add(doc.createElement("td"));
      ((Element)v.get(579)).appendChild((Element)v.get(580));

      /* Empieza nodo:581 / Elemento padre: 580   */
      v.add(doc.createElement("table"));
      ((Element)v.get(581)).setAttribute("width","628" );
      ((Element)v.get(581)).setAttribute("border","0" );
      ((Element)v.get(581)).setAttribute("align","left" );
      ((Element)v.get(581)).setAttribute("cellspacing","0" );
      ((Element)v.get(581)).setAttribute("cellpadding","0" );
      ((Element)v.get(580)).appendChild((Element)v.get(581));

      /* Empieza nodo:582 / Elemento padre: 581   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(581)).appendChild((Element)v.get(582));

      /* Empieza nodo:583 / Elemento padre: 582   */
      v.add(doc.createElement("td"));
      ((Element)v.get(583)).setAttribute("colspan","4" );
      ((Element)v.get(582)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(584)).setAttribute("src","b.gif" );
      ((Element)v.get(584)).setAttribute("width","8" );
      ((Element)v.get(584)).setAttribute("height","8" );
      ((Element)v.get(583)).appendChild((Element)v.get(584));
      /* Termina nodo:584   */
      /* Termina nodo:583   */
      /* Termina nodo:582   */

      /* Empieza nodo:585 / Elemento padre: 581   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(581)).appendChild((Element)v.get(585));

      /* Empieza nodo:586 / Elemento padre: 585   */
      v.add(doc.createElement("td"));
      ((Element)v.get(585)).appendChild((Element)v.get(586));

      /* Empieza nodo:587 / Elemento padre: 586   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(587)).setAttribute("src","b.gif" );
      ((Element)v.get(587)).setAttribute("width","8" );
      ((Element)v.get(587)).setAttribute("height","8" );
      ((Element)v.get(586)).appendChild((Element)v.get(587));
      /* Termina nodo:587   */
      /* Termina nodo:586   */

      /* Empieza nodo:588 / Elemento padre: 585   */
      v.add(doc.createElement("td"));
      ((Element)v.get(585)).appendChild((Element)v.get(588));

      /* Empieza nodo:589 / Elemento padre: 588   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(589)).setAttribute("nombre","lblComunicacion" );
      ((Element)v.get(589)).setAttribute("alto","13" );
      ((Element)v.get(589)).setAttribute("filas","1" );
      ((Element)v.get(589)).setAttribute("valor","" );
      ((Element)v.get(589)).setAttribute("id","datosTitle" );
      ((Element)v.get(589)).setAttribute("cod","1812" );
      ((Element)v.get(588)).appendChild((Element)v.get(589));
      /* Termina nodo:589   */
      /* Termina nodo:588   */

      /* Empieza nodo:590 / Elemento padre: 585   */
      v.add(doc.createElement("td"));
      ((Element)v.get(585)).appendChild((Element)v.get(590));

      /* Empieza nodo:591 / Elemento padre: 590   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(591)).setAttribute("src","b.gif" );
      ((Element)v.get(591)).setAttribute("width","25" );
      ((Element)v.get(591)).setAttribute("height","8" );
      ((Element)v.get(590)).appendChild((Element)v.get(591));
      /* Termina nodo:591   */
      /* Termina nodo:590   */

      /* Empieza nodo:592 / Elemento padre: 585   */
      v.add(doc.createElement("td"));
      ((Element)v.get(585)).appendChild((Element)v.get(592));

      /* Empieza nodo:593 / Elemento padre: 592   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(593)).setAttribute("nombre","lblMensaje" );
      ((Element)v.get(593)).setAttribute("alto","13" );
      ((Element)v.get(593)).setAttribute("filas","1" );
      ((Element)v.get(593)).setAttribute("valor","" );
      ((Element)v.get(593)).setAttribute("id","datosTitle" );
      ((Element)v.get(593)).setAttribute("cod","531" );
      ((Element)v.get(592)).appendChild((Element)v.get(593));
      /* Termina nodo:593   */
      /* Termina nodo:592   */

      /* Empieza nodo:594 / Elemento padre: 585   */
      v.add(doc.createElement("td"));
      ((Element)v.get(594)).setAttribute("width","100%" );
      ((Element)v.get(585)).appendChild((Element)v.get(594));

      /* Empieza nodo:595 / Elemento padre: 594   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(595)).setAttribute("src","b.gif" );
      ((Element)v.get(595)).setAttribute("width","8" );
      ((Element)v.get(595)).setAttribute("height","8" );
      ((Element)v.get(594)).appendChild((Element)v.get(595));
      /* Termina nodo:595   */
      /* Termina nodo:594   */
      /* Termina nodo:585   */

      /* Empieza nodo:596 / Elemento padre: 581   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(581)).appendChild((Element)v.get(596));

      /* Empieza nodo:597 / Elemento padre: 596   */
      v.add(doc.createElement("td"));
      ((Element)v.get(596)).appendChild((Element)v.get(597));

      /* Empieza nodo:598 / Elemento padre: 597   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(598)).setAttribute("src","b.gif" );
      ((Element)v.get(598)).setAttribute("width","8" );
      ((Element)v.get(598)).setAttribute("height","8" );
      ((Element)v.get(597)).appendChild((Element)v.get(598));
      /* Termina nodo:598   */
      /* Termina nodo:597   */

      /* Empieza nodo:599 / Elemento padre: 596   */
      v.add(doc.createElement("td"));
      ((Element)v.get(596)).appendChild((Element)v.get(599));

      /* Empieza nodo:600 / Elemento padre: 599   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(600)).setAttribute("nombre","ckComunicacion" );
      ((Element)v.get(600)).setAttribute("id","datosCampos" );
      ((Element)v.get(600)).setAttribute("onshtab","focalizaAnyadir();" );
      ((Element)v.get(600)).setAttribute("onclick","deshabilitaTextoMensaje();" );
      ((Element)v.get(600)).setAttribute("check","N" );
      ((Element)v.get(599)).appendChild((Element)v.get(600));
      /* Termina nodo:600   */
      /* Termina nodo:599   */

      /* Empieza nodo:601 / Elemento padre: 596   */
      v.add(doc.createElement("td"));
      ((Element)v.get(596)).appendChild((Element)v.get(601));

      /* Empieza nodo:602 / Elemento padre: 601   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(602)).setAttribute("src","b.gif" );
      ((Element)v.get(602)).setAttribute("width","25" );
      ((Element)v.get(602)).setAttribute("height","8" );
      ((Element)v.get(601)).appendChild((Element)v.get(602));
      /* Termina nodo:602   */
      /* Termina nodo:601   */

      /* Empieza nodo:603 / Elemento padre: 596   */
      v.add(doc.createElement("td"));
      ((Element)v.get(596)).appendChild((Element)v.get(603));

      /* Empieza nodo:604 / Elemento padre: 603   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(604)).setAttribute("nombre","txtMensaje" );
      ((Element)v.get(604)).setAttribute("id","datosCampos" );
      ((Element)v.get(604)).setAttribute("max","5" );
      ((Element)v.get(604)).setAttribute("tipo","" );
      ((Element)v.get(604)).setAttribute("onchange","" );
      ((Element)v.get(604)).setAttribute("req","N" );
      ((Element)v.get(604)).setAttribute("size","5" );
      ((Element)v.get(604)).setAttribute("valor","" );
      ((Element)v.get(604)).setAttribute("validacion","" );
      ((Element)v.get(603)).appendChild((Element)v.get(604));
      /* Termina nodo:604   */
      /* Termina nodo:603   */

      /* Empieza nodo:605 / Elemento padre: 596   */
      v.add(doc.createElement("td"));
      ((Element)v.get(605)).setAttribute("width","100%" );
      ((Element)v.get(596)).appendChild((Element)v.get(605));

      /* Empieza nodo:606 / Elemento padre: 605   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(606)).setAttribute("src","b.gif" );
      ((Element)v.get(606)).setAttribute("width","8" );
      ((Element)v.get(606)).setAttribute("height","8" );
      ((Element)v.get(605)).appendChild((Element)v.get(606));
      /* Termina nodo:606   */
      /* Termina nodo:605   */
      /* Termina nodo:596   */

      /* Empieza nodo:607 / Elemento padre: 581   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(581)).appendChild((Element)v.get(607));

      /* Empieza nodo:608 / Elemento padre: 607   */
      v.add(doc.createElement("td"));
      ((Element)v.get(608)).setAttribute("colspan","4" );
      ((Element)v.get(607)).appendChild((Element)v.get(608));

      /* Empieza nodo:609 / Elemento padre: 608   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(609)).setAttribute("src","b.gif" );
      ((Element)v.get(609)).setAttribute("width","8" );
      ((Element)v.get(609)).setAttribute("height","8" );
      ((Element)v.get(608)).appendChild((Element)v.get(609));
      /* Termina nodo:609   */
      /* Termina nodo:608   */
      /* Termina nodo:607   */
      /* Termina nodo:581   */
      /* Termina nodo:580   */
      /* Termina nodo:579   */
      /* Termina nodo:578   */
      /* Termina nodo:575   */
      /* Termina nodo:574   */

      /* Empieza nodo:610 / Elemento padre: 571   */
      v.add(doc.createElement("td"));
      ((Element)v.get(571)).appendChild((Element)v.get(610));

      /* Empieza nodo:611 / Elemento padre: 610   */
   }

   private void getXML2520(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(611)).setAttribute("src","b.gif" );
      ((Element)v.get(610)).appendChild((Element)v.get(611));
      /* Termina nodo:611   */
      /* Termina nodo:610   */
      /* Termina nodo:571   */

      /* Empieza nodo:612 / Elemento padre: 563   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(563)).appendChild((Element)v.get(612));

      /* Empieza nodo:613 / Elemento padre: 612   */
      v.add(doc.createElement("td"));
      ((Element)v.get(612)).appendChild((Element)v.get(613));

      /* Empieza nodo:614 / Elemento padre: 613   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(614)).setAttribute("src","b.gif" );
      ((Element)v.get(613)).appendChild((Element)v.get(614));
      /* Termina nodo:614   */
      /* Termina nodo:613   */

      /* Empieza nodo:615 / Elemento padre: 612   */
      v.add(doc.createElement("td"));
      ((Element)v.get(612)).appendChild((Element)v.get(615));

      /* Empieza nodo:616 / Elemento padre: 615   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(615)).appendChild((Element)v.get(616));

      /* Empieza nodo:617 / Elemento padre: 616   */
      v.add(doc.createElement("table"));
      ((Element)v.get(617)).setAttribute("width","100%" );
      ((Element)v.get(617)).setAttribute("border","0" );
      ((Element)v.get(617)).setAttribute("align","center" );
      ((Element)v.get(617)).setAttribute("cellspacing","0" );
      ((Element)v.get(617)).setAttribute("cellpadding","0" );
      ((Element)v.get(616)).appendChild((Element)v.get(617));

      /* Empieza nodo:618 / Elemento padre: 617   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(617)).appendChild((Element)v.get(618));

      /* Empieza nodo:619 / Elemento padre: 618   */
      v.add(doc.createElement("td"));
      ((Element)v.get(619)).setAttribute("class","botonera" );
      ((Element)v.get(618)).appendChild((Element)v.get(619));

      /* Empieza nodo:620 / Elemento padre: 619   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(620)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(620)).setAttribute("ID","botonContenido" );
      ((Element)v.get(620)).setAttribute("tipo","html" );
      ((Element)v.get(620)).setAttribute("ontab","tabAceptar();" );
      ((Element)v.get(620)).setAttribute("accion","accionAceptar();" );
      ((Element)v.get(620)).setAttribute("estado","false" );
      ((Element)v.get(620)).setAttribute("cod","12" );
      ((Element)v.get(619)).appendChild((Element)v.get(620));
      /* Termina nodo:620   */
      /* Termina nodo:619   */
      /* Termina nodo:618   */
      /* Termina nodo:617   */
      /* Termina nodo:616   */
      /* Termina nodo:615   */

      /* Empieza nodo:621 / Elemento padre: 612   */
      v.add(doc.createElement("td"));
      ((Element)v.get(612)).appendChild((Element)v.get(621));

      /* Empieza nodo:622 / Elemento padre: 621   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(622)).setAttribute("src","b.gif" );
      ((Element)v.get(622)).setAttribute("width","8" );
      ((Element)v.get(622)).setAttribute("height","12" );
      ((Element)v.get(621)).appendChild((Element)v.get(622));
      /* Termina nodo:622   */
      /* Termina nodo:621   */
      /* Termina nodo:612   */

      /* Empieza nodo:623 / Elemento padre: 563   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(563)).appendChild((Element)v.get(623));

      /* Empieza nodo:624 / Elemento padre: 623   */
      v.add(doc.createElement("td"));
      ((Element)v.get(624)).setAttribute("width","12" );
      ((Element)v.get(624)).setAttribute("align","center" );
      ((Element)v.get(623)).appendChild((Element)v.get(624));

      /* Empieza nodo:625 / Elemento padre: 624   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(625)).setAttribute("src","b.gif" );
      ((Element)v.get(625)).setAttribute("width","12" );
      ((Element)v.get(625)).setAttribute("height","12" );
      ((Element)v.get(624)).appendChild((Element)v.get(625));
      /* Termina nodo:625   */
      /* Termina nodo:624   */

      /* Empieza nodo:626 / Elemento padre: 623   */
      v.add(doc.createElement("td"));
      ((Element)v.get(626)).setAttribute("width","756" );
      ((Element)v.get(623)).appendChild((Element)v.get(626));

      /* Empieza nodo:627 / Elemento padre: 626   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(627)).setAttribute("src","b.gif" );
      ((Element)v.get(626)).appendChild((Element)v.get(627));
      /* Termina nodo:627   */
      /* Termina nodo:626   */

      /* Empieza nodo:628 / Elemento padre: 623   */
      v.add(doc.createElement("td"));
      ((Element)v.get(628)).setAttribute("width","12" );
      ((Element)v.get(623)).appendChild((Element)v.get(628));

      /* Empieza nodo:629 / Elemento padre: 628   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(629)).setAttribute("src","b.gif" );
      ((Element)v.get(629)).setAttribute("width","12" );
      ((Element)v.get(629)).setAttribute("height","1" );
      ((Element)v.get(628)).appendChild((Element)v.get(629));
      /* Termina nodo:629   */
      /* Termina nodo:628   */
      /* Termina nodo:623   */
      /* Termina nodo:563   */
      /* Termina nodo:562   */

      /* Empieza nodo:630 / Elemento padre: 27   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(630)).setAttribute("nombre","listado1" );
      ((Element)v.get(630)).setAttribute("ancho","632" );
      ((Element)v.get(630)).setAttribute("alto","315" );
      ((Element)v.get(630)).setAttribute("x","12" );
      ((Element)v.get(630)).setAttribute("y","439" );
      ((Element)v.get(630)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(630)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(27)).appendChild((Element)v.get(630));

      /* Empieza nodo:631 / Elemento padre: 630   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(631)).setAttribute("precarga","S" );
      ((Element)v.get(631)).setAttribute("conROver","S" );
      ((Element)v.get(630)).appendChild((Element)v.get(631));

      /* Empieza nodo:632 / Elemento padre: 631   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(632)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(632)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(632)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(632)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(631)).appendChild((Element)v.get(632));
      /* Termina nodo:632   */

      /* Empieza nodo:633 / Elemento padre: 631   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(633)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(633)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(633)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
   }

   private void getXML2610(Document doc) {
      ((Element)v.get(633)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(631)).appendChild((Element)v.get(633));
      /* Termina nodo:633   */

      /* Empieza nodo:634 / Elemento padre: 631   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(634)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(634)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(631)).appendChild((Element)v.get(634));
      /* Termina nodo:634   */
      /* Termina nodo:631   */

      /* Empieza nodo:635 / Elemento padre: 630   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(630)).appendChild((Element)v.get(635));

      /* Empieza nodo:636 / Elemento padre: 635   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(636)).setAttribute("borde","1" );
      ((Element)v.get(636)).setAttribute("horizDatos","1" );
      ((Element)v.get(636)).setAttribute("horizCabecera","1" );
      ((Element)v.get(636)).setAttribute("vertical","1" );
      ((Element)v.get(636)).setAttribute("horizTitulo","1" );
      ((Element)v.get(636)).setAttribute("horizBase","1" );
      ((Element)v.get(635)).appendChild((Element)v.get(636));
      /* Termina nodo:636   */

      /* Empieza nodo:637 / Elemento padre: 635   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(637)).setAttribute("borde","#999999" );
      ((Element)v.get(637)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(637)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(637)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(637)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(637)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(637)).setAttribute("horizBase","#999999" );
      ((Element)v.get(635)).appendChild((Element)v.get(637));
      /* Termina nodo:637   */
      /* Termina nodo:635   */

      /* Empieza nodo:638 / Elemento padre: 630   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(638)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(638)).setAttribute("alto","22" );
      ((Element)v.get(638)).setAttribute("imgFondo","" );
      ((Element)v.get(638)).setAttribute("cod","00338" );
      ((Element)v.get(638)).setAttribute("ID","datosTitle" );
      ((Element)v.get(630)).appendChild((Element)v.get(638));
      /* Termina nodo:638   */

      /* Empieza nodo:639 / Elemento padre: 630   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(639)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(639)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(639)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(639)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(639)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(639)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(630)).appendChild((Element)v.get(639));

      /* Empieza nodo:640 / Elemento padre: 639   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(640)).setAttribute("ancho","150" );
      ((Element)v.get(640)).setAttribute("minimizable","S" );
      ((Element)v.get(640)).setAttribute("minimizada","N" );
      ((Element)v.get(639)).appendChild((Element)v.get(640));
      /* Termina nodo:640   */

      /* Empieza nodo:641 / Elemento padre: 639   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(641)).setAttribute("ancho","150" );
      ((Element)v.get(641)).setAttribute("minimizable","S" );
      ((Element)v.get(641)).setAttribute("minimizada","N" );
      ((Element)v.get(639)).appendChild((Element)v.get(641));
      /* Termina nodo:641   */

      /* Empieza nodo:642 / Elemento padre: 639   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(642)).setAttribute("ancho","150" );
      ((Element)v.get(642)).setAttribute("minimizable","S" );
      ((Element)v.get(642)).setAttribute("minimizada","N" );
      ((Element)v.get(639)).appendChild((Element)v.get(642));
      /* Termina nodo:642   */

      /* Empieza nodo:643 / Elemento padre: 639   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(643)).setAttribute("ancho","150" );
      ((Element)v.get(643)).setAttribute("minimizable","S" );
      ((Element)v.get(643)).setAttribute("minimizada","N" );
      ((Element)v.get(639)).appendChild((Element)v.get(643));
      /* Termina nodo:643   */

      /* Empieza nodo:644 / Elemento padre: 639   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(644)).setAttribute("ancho","150" );
      ((Element)v.get(644)).setAttribute("minimizable","S" );
      ((Element)v.get(644)).setAttribute("minimizada","N" );
      ((Element)v.get(639)).appendChild((Element)v.get(644));
      /* Termina nodo:644   */

      /* Empieza nodo:645 / Elemento padre: 639   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(645)).setAttribute("ancho","150" );
      ((Element)v.get(645)).setAttribute("minimizable","S" );
      ((Element)v.get(645)).setAttribute("minimizada","N" );
      ((Element)v.get(639)).appendChild((Element)v.get(645));
      /* Termina nodo:645   */

      /* Empieza nodo:646 / Elemento padre: 639   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(646)).setAttribute("ancho","150" );
      ((Element)v.get(646)).setAttribute("minimizable","S" );
      ((Element)v.get(646)).setAttribute("minimizada","N" );
      ((Element)v.get(639)).appendChild((Element)v.get(646));
      /* Termina nodo:646   */

      /* Empieza nodo:647 / Elemento padre: 639   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(647)).setAttribute("ancho","150" );
      ((Element)v.get(647)).setAttribute("minimizable","S" );
      ((Element)v.get(647)).setAttribute("minimizada","N" );
      ((Element)v.get(639)).appendChild((Element)v.get(647));
      /* Termina nodo:647   */

      /* Empieza nodo:648 / Elemento padre: 639   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(648)).setAttribute("ancho","150" );
      ((Element)v.get(648)).setAttribute("minimizable","S" );
      ((Element)v.get(648)).setAttribute("minimizada","N" );
      ((Element)v.get(639)).appendChild((Element)v.get(648));
      /* Termina nodo:648   */

      /* Empieza nodo:649 / Elemento padre: 639   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(649)).setAttribute("ancho","150" );
      ((Element)v.get(649)).setAttribute("minimizable","S" );
      ((Element)v.get(649)).setAttribute("minimizada","N" );
      ((Element)v.get(639)).appendChild((Element)v.get(649));
      /* Termina nodo:649   */

      /* Empieza nodo:650 / Elemento padre: 639   */
   }

   private void getXML2700(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(650)).setAttribute("ancho","150" );
      ((Element)v.get(650)).setAttribute("minimizable","S" );
      ((Element)v.get(650)).setAttribute("minimizada","N" );
      ((Element)v.get(650)).setAttribute("oculta","S" );
      ((Element)v.get(639)).appendChild((Element)v.get(650));
      /* Termina nodo:650   */

      /* Empieza nodo:651 / Elemento padre: 639   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(651)).setAttribute("ancho","150" );
      ((Element)v.get(651)).setAttribute("minimizable","S" );
      ((Element)v.get(651)).setAttribute("minimizada","N" );
      ((Element)v.get(651)).setAttribute("oculta","S" );
      ((Element)v.get(639)).appendChild((Element)v.get(651));
      /* Termina nodo:651   */

      /* Empieza nodo:652 / Elemento padre: 639   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(652)).setAttribute("ancho","150" );
      ((Element)v.get(652)).setAttribute("minimizable","S" );
      ((Element)v.get(652)).setAttribute("minimizada","N" );
      ((Element)v.get(652)).setAttribute("oculta","S" );
      ((Element)v.get(639)).appendChild((Element)v.get(652));
      /* Termina nodo:652   */

      /* Empieza nodo:653 / Elemento padre: 639   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(653)).setAttribute("ancho","150" );
      ((Element)v.get(653)).setAttribute("minimizable","S" );
      ((Element)v.get(653)).setAttribute("minimizada","N" );
      ((Element)v.get(653)).setAttribute("oculta","S" );
      ((Element)v.get(639)).appendChild((Element)v.get(653));
      /* Termina nodo:653   */

      /* Empieza nodo:654 / Elemento padre: 639   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(654)).setAttribute("ancho","150" );
      ((Element)v.get(654)).setAttribute("minimizable","S" );
      ((Element)v.get(654)).setAttribute("minimizada","N" );
      ((Element)v.get(654)).setAttribute("oculta","S" );
      ((Element)v.get(639)).appendChild((Element)v.get(654));
      /* Termina nodo:654   */

      /* Empieza nodo:655 / Elemento padre: 639   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(655)).setAttribute("ancho","150" );
      ((Element)v.get(655)).setAttribute("minimizable","S" );
      ((Element)v.get(655)).setAttribute("minimizada","N" );
      ((Element)v.get(655)).setAttribute("oculta","S" );
      ((Element)v.get(639)).appendChild((Element)v.get(655));
      /* Termina nodo:655   */

      /* Empieza nodo:656 / Elemento padre: 639   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(656)).setAttribute("ancho","150" );
      ((Element)v.get(656)).setAttribute("minimizable","S" );
      ((Element)v.get(656)).setAttribute("minimizada","N" );
      ((Element)v.get(656)).setAttribute("oculta","S" );
      ((Element)v.get(639)).appendChild((Element)v.get(656));
      /* Termina nodo:656   */

      /* Empieza nodo:657 / Elemento padre: 639   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(657)).setAttribute("ancho","150" );
      ((Element)v.get(657)).setAttribute("minimizable","S" );
      ((Element)v.get(657)).setAttribute("minimizada","N" );
      ((Element)v.get(657)).setAttribute("oculta","S" );
      ((Element)v.get(639)).appendChild((Element)v.get(657));
      /* Termina nodo:657   */

      /* Empieza nodo:658 / Elemento padre: 639   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(658)).setAttribute("ancho","150" );
      ((Element)v.get(658)).setAttribute("minimizable","S" );
      ((Element)v.get(658)).setAttribute("minimizada","N" );
      ((Element)v.get(658)).setAttribute("oculta","S" );
      ((Element)v.get(639)).appendChild((Element)v.get(658));
      /* Termina nodo:658   */

      /* Empieza nodo:659 / Elemento padre: 639   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(659)).setAttribute("ancho","150" );
      ((Element)v.get(659)).setAttribute("minimizable","S" );
      ((Element)v.get(659)).setAttribute("minimizada","N" );
      ((Element)v.get(659)).setAttribute("oculta","S" );
      ((Element)v.get(639)).appendChild((Element)v.get(659));
      /* Termina nodo:659   */
      /* Termina nodo:639   */

      /* Empieza nodo:660 / Elemento padre: 630   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(660)).setAttribute("alto","40" );
      ((Element)v.get(660)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(660)).setAttribute("imgFondo","" );
      ((Element)v.get(660)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(660)).setAttribute("ajustarAMitadInf","S" );
      ((Element)v.get(630)).appendChild((Element)v.get(660));

      /* Empieza nodo:661 / Elemento padre: 660   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(661)).setAttribute("colFondo","" );
      ((Element)v.get(661)).setAttribute("ID","EstCab" );
      ((Element)v.get(661)).setAttribute("cod","00335" );
      ((Element)v.get(660)).appendChild((Element)v.get(661));

      /* Empieza nodo:662 / Elemento padre: 661   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(662)).setAttribute("colFondo","" );
      ((Element)v.get(662)).setAttribute("ID","EstCab" );
      ((Element)v.get(662)).setAttribute("cod","2448" );
      ((Element)v.get(661)).appendChild((Element)v.get(662));

      /* Elemento padre:662 / Elemento actual: 663   */
      v.add(doc.createTextNode("Marca"));
      ((Element)v.get(662)).appendChild((Text)v.get(663));

      /* Termina nodo Texto:663   */
      /* Termina nodo:662   */

      /* Empieza nodo:664 / Elemento padre: 661   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(664)).setAttribute("colFondo","" );
      ((Element)v.get(664)).setAttribute("ID","EstCab" );
      ((Element)v.get(664)).setAttribute("cod","1338" );
      ((Element)v.get(661)).appendChild((Element)v.get(664));

      /* Elemento padre:664 / Elemento actual: 665   */
      v.add(doc.createTextNode("Unidad negocio"));
      ((Element)v.get(664)).appendChild((Text)v.get(665));

      /* Termina nodo Texto:665   */
      /* Termina nodo:664   */

      /* Empieza nodo:666 / Elemento padre: 661   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(666)).setAttribute("colFondo","" );
      ((Element)v.get(666)).setAttribute("ID","EstCab" );
      ((Element)v.get(666)).setAttribute("cod","588" );
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(661)).appendChild((Element)v.get(666));

      /* Elemento padre:666 / Elemento actual: 667   */
      v.add(doc.createTextNode("Negocio"));
      ((Element)v.get(666)).appendChild((Text)v.get(667));

      /* Termina nodo Texto:667   */
      /* Termina nodo:666   */

      /* Empieza nodo:668 / Elemento padre: 661   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(668)).setAttribute("colFondo","" );
      ((Element)v.get(668)).setAttribute("ID","EstCab" );
      ((Element)v.get(668)).setAttribute("cod","590" );
      ((Element)v.get(661)).appendChild((Element)v.get(668));

      /* Elemento padre:668 / Elemento actual: 669   */
      v.add(doc.createTextNode("Supergenérico"));
      ((Element)v.get(668)).appendChild((Text)v.get(669));

      /* Termina nodo Texto:669   */
      /* Termina nodo:668   */

      /* Empieza nodo:670 / Elemento padre: 661   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(670)).setAttribute("colFondo","" );
      ((Element)v.get(670)).setAttribute("ID","EstCab" );
      ((Element)v.get(670)).setAttribute("cod","589" );
      ((Element)v.get(661)).appendChild((Element)v.get(670));

      /* Elemento padre:670 / Elemento actual: 671   */
      v.add(doc.createTextNode("Genérico"));
      ((Element)v.get(670)).appendChild((Text)v.get(671));

      /* Termina nodo Texto:671   */
      /* Termina nodo:670   */
      /* Termina nodo:661   */

      /* Empieza nodo:672 / Elemento padre: 660   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(672)).setAttribute("colFondo","" );
      ((Element)v.get(672)).setAttribute("ID","EstCab" );
      ((Element)v.get(672)).setAttribute("cod","00336" );
      ((Element)v.get(660)).appendChild((Element)v.get(672));

      /* Empieza nodo:673 / Elemento padre: 672   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(673)).setAttribute("colFondo","" );
      ((Element)v.get(673)).setAttribute("ID","EstCab" );
      ((Element)v.get(673)).setAttribute("cod","608" );
      ((Element)v.get(672)).appendChild((Element)v.get(673));

      /* Elemento padre:673 / Elemento actual: 674   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(673)).appendChild((Text)v.get(674));

      /* Termina nodo Texto:674   */
      /* Termina nodo:673   */

      /* Empieza nodo:675 / Elemento padre: 672   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(675)).setAttribute("colFondo","" );
      ((Element)v.get(675)).setAttribute("ID","EstCab" );
      ((Element)v.get(675)).setAttribute("cod","581" );
      ((Element)v.get(672)).appendChild((Element)v.get(675));

      /* Elemento padre:675 / Elemento actual: 676   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(675)).appendChild((Text)v.get(676));

      /* Termina nodo Texto:676   */
      /* Termina nodo:675   */
      /* Termina nodo:672   */

      /* Empieza nodo:677 / Elemento padre: 660   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(677)).setAttribute("colFondo","" );
      ((Element)v.get(677)).setAttribute("ID","EstCab" );
      ((Element)v.get(677)).setAttribute("cod","00337" );
      ((Element)v.get(660)).appendChild((Element)v.get(677));

      /* Empieza nodo:678 / Elemento padre: 677   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(678)).setAttribute("colFondo","" );
      ((Element)v.get(678)).setAttribute("ID","EstCab" );
      ((Element)v.get(678)).setAttribute("cod","337" );
      ((Element)v.get(677)).appendChild((Element)v.get(678));

      /* Elemento padre:678 / Elemento actual: 679   */
      v.add(doc.createTextNode("Cód. producto"));
      ((Element)v.get(678)).appendChild((Text)v.get(679));

      /* Termina nodo Texto:679   */
      /* Termina nodo:678   */

      /* Empieza nodo:680 / Elemento padre: 677   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(680)).setAttribute("colFondo","" );
      ((Element)v.get(680)).setAttribute("ID","EstCab" );
      ((Element)v.get(680)).setAttribute("cod","608" );
      ((Element)v.get(677)).appendChild((Element)v.get(680));

      /* Elemento padre:680 / Elemento actual: 681   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(680)).appendChild((Text)v.get(681));

      /* Termina nodo Texto:681   */
      /* Termina nodo:680   */

      /* Empieza nodo:682 / Elemento padre: 677   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(682)).setAttribute("colFondo","" );
      ((Element)v.get(682)).setAttribute("ID","EstCab" );
      ((Element)v.get(682)).setAttribute("cod","581" );
      ((Element)v.get(677)).appendChild((Element)v.get(682));

      /* Elemento padre:682 / Elemento actual: 683   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(682)).appendChild((Text)v.get(683));

      /* Termina nodo Texto:683   */
      /* Termina nodo:682   */
      /* Termina nodo:677   */

      /* Empieza nodo:684 / Elemento padre: 660   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(684)).setAttribute("colFondo","" );
      ((Element)v.get(684)).setAttribute("ID","EstCab" );
      ((Element)v.get(684)).setAttribute("cod","581" );
      ((Element)v.get(660)).appendChild((Element)v.get(684));

      /* Elemento padre:684 / Elemento actual: 685   */
      v.add(doc.createTextNode("oidMarca"));
      ((Element)v.get(684)).appendChild((Text)v.get(685));

      /* Termina nodo Texto:685   */
      /* Termina nodo:684   */

      /* Empieza nodo:686 / Elemento padre: 660   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(686)).setAttribute("colFondo","" );
      ((Element)v.get(686)).setAttribute("ID","EstCab" );
      ((Element)v.get(686)).setAttribute("cod","581" );
      ((Element)v.get(660)).appendChild((Element)v.get(686));

      /* Elemento padre:686 / Elemento actual: 687   */
      v.add(doc.createTextNode("oidUNegocio"));
      ((Element)v.get(686)).appendChild((Text)v.get(687));

      /* Termina nodo Texto:687   */
      /* Termina nodo:686   */

      /* Empieza nodo:688 / Elemento padre: 660   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(688)).setAttribute("colFondo","" );
      ((Element)v.get(688)).setAttribute("ID","EstCab" );
      ((Element)v.get(688)).setAttribute("cod","581" );
      ((Element)v.get(660)).appendChild((Element)v.get(688));

      /* Elemento padre:688 / Elemento actual: 689   */
      v.add(doc.createTextNode("oidNegocio"));
      ((Element)v.get(688)).appendChild((Text)v.get(689));

      /* Termina nodo Texto:689   */
      /* Termina nodo:688   */

      /* Empieza nodo:690 / Elemento padre: 660   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(690)).setAttribute("colFondo","" );
      ((Element)v.get(690)).setAttribute("ID","EstCab" );
      ((Element)v.get(690)).setAttribute("cod","581" );
      ((Element)v.get(660)).appendChild((Element)v.get(690));

      /* Elemento padre:690 / Elemento actual: 691   */
      v.add(doc.createTextNode("oidSuperGenerico"));
      ((Element)v.get(690)).appendChild((Text)v.get(691));

      /* Termina nodo Texto:691   */
      /* Termina nodo:690   */

      /* Empieza nodo:692 / Elemento padre: 660   */
   }

   private void getXML2880(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(692)).setAttribute("colFondo","" );
      ((Element)v.get(692)).setAttribute("ID","EstCab" );
      ((Element)v.get(692)).setAttribute("cod","581" );
      ((Element)v.get(660)).appendChild((Element)v.get(692));

      /* Elemento padre:692 / Elemento actual: 693   */
      v.add(doc.createTextNode("oidGenerico"));
      ((Element)v.get(692)).appendChild((Text)v.get(693));

      /* Termina nodo Texto:693   */
      /* Termina nodo:692   */

      /* Empieza nodo:694 / Elemento padre: 660   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(694)).setAttribute("colFondo","" );
      ((Element)v.get(694)).setAttribute("ID","EstCab" );
      ((Element)v.get(694)).setAttribute("cod","581" );
      ((Element)v.get(660)).appendChild((Element)v.get(694));

      /* Elemento padre:694 / Elemento actual: 695   */
      v.add(doc.createTextNode("oidTipoOferta"));
      ((Element)v.get(694)).appendChild((Text)v.get(695));

      /* Termina nodo Texto:695   */
      /* Termina nodo:694   */

      /* Empieza nodo:696 / Elemento padre: 660   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(696)).setAttribute("colFondo","" );
      ((Element)v.get(696)).setAttribute("ID","EstCab" );
      ((Element)v.get(696)).setAttribute("cod","581" );
      ((Element)v.get(660)).appendChild((Element)v.get(696));

      /* Elemento padre:696 / Elemento actual: 697   */
      v.add(doc.createTextNode("oidCicloVida"));
      ((Element)v.get(696)).appendChild((Text)v.get(697));

      /* Termina nodo Texto:697   */
      /* Termina nodo:696   */

      /* Empieza nodo:698 / Elemento padre: 660   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(698)).setAttribute("colFondo","" );
      ((Element)v.get(698)).setAttribute("ID","EstCab" );
      ((Element)v.get(698)).setAttribute("cod","581" );
      ((Element)v.get(660)).appendChild((Element)v.get(698));

      /* Elemento padre:698 / Elemento actual: 699   */
      v.add(doc.createTextNode("oidProducto"));
      ((Element)v.get(698)).appendChild((Text)v.get(699));

      /* Termina nodo Texto:699   */
      /* Termina nodo:698   */

      /* Empieza nodo:700 / Elemento padre: 660   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(700)).setAttribute("colFondo","" );
      ((Element)v.get(700)).setAttribute("ID","EstCab" );
      ((Element)v.get(700)).setAttribute("cod","581" );
      ((Element)v.get(660)).appendChild((Element)v.get(700));

      /* Elemento padre:700 / Elemento actual: 701   */
      v.add(doc.createTextNode("oidTipoOferta"));
      ((Element)v.get(700)).appendChild((Text)v.get(701));

      /* Termina nodo Texto:701   */
      /* Termina nodo:700   */

      /* Empieza nodo:702 / Elemento padre: 660   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(702)).setAttribute("colFondo","" );
      ((Element)v.get(702)).setAttribute("ID","EstCab" );
      ((Element)v.get(702)).setAttribute("cod","581" );
      ((Element)v.get(660)).appendChild((Element)v.get(702));

      /* Elemento padre:702 / Elemento actual: 703   */
      v.add(doc.createTextNode("oidCicloVida"));
      ((Element)v.get(702)).appendChild((Text)v.get(703));

      /* Termina nodo Texto:703   */
      /* Termina nodo:702   */
      /* Termina nodo:660   */

      /* Empieza nodo:704 / Elemento padre: 630   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(704)).setAttribute("alto","22" );
      ((Element)v.get(704)).setAttribute("accion","" );
      ((Element)v.get(704)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(704)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(704)).setAttribute("maxSel","-1" );
      ((Element)v.get(704)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(704)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(704)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(704)).setAttribute("onLoad","" );
      ((Element)v.get(704)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(630)).appendChild((Element)v.get(704));

      /* Empieza nodo:705 / Elemento padre: 704   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(705)).setAttribute("tipo","texto" );
      ((Element)v.get(705)).setAttribute("ID","EstDat" );
      ((Element)v.get(704)).appendChild((Element)v.get(705));
      /* Termina nodo:705   */

      /* Empieza nodo:706 / Elemento padre: 704   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(706)).setAttribute("tipo","texto" );
      ((Element)v.get(706)).setAttribute("ID","EstDat2" );
      ((Element)v.get(704)).appendChild((Element)v.get(706));
      /* Termina nodo:706   */

      /* Empieza nodo:707 / Elemento padre: 704   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(707)).setAttribute("tipo","texto" );
      ((Element)v.get(707)).setAttribute("ID","EstDat" );
      ((Element)v.get(704)).appendChild((Element)v.get(707));
      /* Termina nodo:707   */

      /* Empieza nodo:708 / Elemento padre: 704   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(708)).setAttribute("tipo","texto" );
      ((Element)v.get(708)).setAttribute("ID","EstDat2" );
      ((Element)v.get(704)).appendChild((Element)v.get(708));
      /* Termina nodo:708   */

      /* Empieza nodo:709 / Elemento padre: 704   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(709)).setAttribute("tipo","texto" );
      ((Element)v.get(709)).setAttribute("ID","EstDat" );
      ((Element)v.get(704)).appendChild((Element)v.get(709));
      /* Termina nodo:709   */

      /* Empieza nodo:710 / Elemento padre: 704   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(710)).setAttribute("tipo","texto" );
      ((Element)v.get(710)).setAttribute("ID","EstDat2" );
      ((Element)v.get(704)).appendChild((Element)v.get(710));
      /* Termina nodo:710   */

      /* Empieza nodo:711 / Elemento padre: 704   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(711)).setAttribute("tipo","texto" );
      ((Element)v.get(711)).setAttribute("ID","EstDat" );
      ((Element)v.get(704)).appendChild((Element)v.get(711));
      /* Termina nodo:711   */

      /* Empieza nodo:712 / Elemento padre: 704   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(712)).setAttribute("tipo","texto" );
      ((Element)v.get(712)).setAttribute("ID","EstDat2" );
      ((Element)v.get(704)).appendChild((Element)v.get(712));
      /* Termina nodo:712   */

      /* Empieza nodo:713 / Elemento padre: 704   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(713)).setAttribute("tipo","texto" );
      ((Element)v.get(713)).setAttribute("ID","EstDat" );
      ((Element)v.get(704)).appendChild((Element)v.get(713));
      /* Termina nodo:713   */

      /* Empieza nodo:714 / Elemento padre: 704   */
   }

   private void getXML2970(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(714)).setAttribute("tipo","texto" );
      ((Element)v.get(714)).setAttribute("ID","EstDat2" );
      ((Element)v.get(704)).appendChild((Element)v.get(714));
      /* Termina nodo:714   */

      /* Empieza nodo:715 / Elemento padre: 704   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(715)).setAttribute("tipo","texto" );
      ((Element)v.get(715)).setAttribute("ID","EstDat2" );
      ((Element)v.get(704)).appendChild((Element)v.get(715));
      /* Termina nodo:715   */

      /* Empieza nodo:716 / Elemento padre: 704   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(716)).setAttribute("tipo","texto" );
      ((Element)v.get(716)).setAttribute("ID","EstDat2" );
      ((Element)v.get(704)).appendChild((Element)v.get(716));
      /* Termina nodo:716   */

      /* Empieza nodo:717 / Elemento padre: 704   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(717)).setAttribute("tipo","texto" );
      ((Element)v.get(717)).setAttribute("ID","EstDat2" );
      ((Element)v.get(704)).appendChild((Element)v.get(717));
      /* Termina nodo:717   */

      /* Empieza nodo:718 / Elemento padre: 704   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(718)).setAttribute("tipo","texto" );
      ((Element)v.get(718)).setAttribute("ID","EstDat2" );
      ((Element)v.get(704)).appendChild((Element)v.get(718));
      /* Termina nodo:718   */

      /* Empieza nodo:719 / Elemento padre: 704   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(719)).setAttribute("tipo","texto" );
      ((Element)v.get(719)).setAttribute("ID","EstDat2" );
      ((Element)v.get(704)).appendChild((Element)v.get(719));
      /* Termina nodo:719   */

      /* Empieza nodo:720 / Elemento padre: 704   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(720)).setAttribute("tipo","texto" );
      ((Element)v.get(720)).setAttribute("ID","EstDat2" );
      ((Element)v.get(704)).appendChild((Element)v.get(720));
      /* Termina nodo:720   */

      /* Empieza nodo:721 / Elemento padre: 704   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(721)).setAttribute("tipo","texto" );
      ((Element)v.get(721)).setAttribute("ID","EstDat2" );
      ((Element)v.get(704)).appendChild((Element)v.get(721));
      /* Termina nodo:721   */

      /* Empieza nodo:722 / Elemento padre: 704   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(722)).setAttribute("tipo","texto" );
      ((Element)v.get(722)).setAttribute("ID","EstDat2" );
      ((Element)v.get(704)).appendChild((Element)v.get(722));
      /* Termina nodo:722   */

      /* Empieza nodo:723 / Elemento padre: 704   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(723)).setAttribute("tipo","texto" );
      ((Element)v.get(723)).setAttribute("ID","EstDat2" );
      ((Element)v.get(704)).appendChild((Element)v.get(723));
      /* Termina nodo:723   */

      /* Empieza nodo:724 / Elemento padre: 704   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(724)).setAttribute("tipo","texto" );
      ((Element)v.get(724)).setAttribute("ID","EstDat2" );
      ((Element)v.get(704)).appendChild((Element)v.get(724));
      /* Termina nodo:724   */
      /* Termina nodo:704   */

      /* Empieza nodo:725 / Elemento padre: 630   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(630)).appendChild((Element)v.get(725));
      /* Termina nodo:725   */

      /* Empieza nodo:726 / Elemento padre: 630   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(726)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(726)).setAttribute("ancho","504" );
      ((Element)v.get(726)).setAttribute("sep","$" );
      ((Element)v.get(726)).setAttribute("x","12" );
      ((Element)v.get(726)).setAttribute("class","botonera" );
      ((Element)v.get(726)).setAttribute("y","753" );
      ((Element)v.get(726)).setAttribute("control","|" );
      ((Element)v.get(726)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(726)).setAttribute("rowset","" );
      ((Element)v.get(726)).setAttribute("cargainicial","N" );
      ((Element)v.get(630)).appendChild((Element)v.get(726));

      /* Empieza nodo:727 / Elemento padre: 726   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(727)).setAttribute("nombre","ret1" );
      ((Element)v.get(727)).setAttribute("x","37" );
      ((Element)v.get(727)).setAttribute("y","757" );
      ((Element)v.get(727)).setAttribute("ID","botonContenido" );
      ((Element)v.get(727)).setAttribute("img","retroceder_on" );
      ((Element)v.get(727)).setAttribute("tipo","0" );
      ((Element)v.get(727)).setAttribute("estado","false" );
      ((Element)v.get(727)).setAttribute("alt","" );
      ((Element)v.get(727)).setAttribute("codigo","" );
      ((Element)v.get(727)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(726)).appendChild((Element)v.get(727));
      /* Termina nodo:727   */

      /* Empieza nodo:728 / Elemento padre: 726   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(728)).setAttribute("nombre","ava1" );
      ((Element)v.get(728)).setAttribute("x","52" );
      ((Element)v.get(728)).setAttribute("y","757" );
      ((Element)v.get(728)).setAttribute("ID","botonContenido" );
      ((Element)v.get(728)).setAttribute("img","avanzar_on" );
      ((Element)v.get(728)).setAttribute("tipo","0" );
      ((Element)v.get(728)).setAttribute("estado","false" );
      ((Element)v.get(728)).setAttribute("alt","" );
      ((Element)v.get(728)).setAttribute("codigo","" );
      ((Element)v.get(728)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(726)).appendChild((Element)v.get(728));
      /* Termina nodo:728   */
      /* Termina nodo:726   */
      /* Termina nodo:630   */

      /* Empieza nodo:729 / Elemento padre: 27   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(729)).setAttribute("nombre","primera1" );
      ((Element)v.get(729)).setAttribute("x","20" );
      ((Element)v.get(729)).setAttribute("y","757" );
      ((Element)v.get(729)).setAttribute("ID","botonContenido" );
      ((Element)v.get(729)).setAttribute("img","primera_on" );
      ((Element)v.get(729)).setAttribute("tipo","0" );
      ((Element)v.get(729)).setAttribute("estado","false" );
   }

   private void getXML3060(Document doc) {
      ((Element)v.get(729)).setAttribute("alt","" );
      ((Element)v.get(729)).setAttribute("codigo","" );
      ((Element)v.get(729)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(27)).appendChild((Element)v.get(729));
      /* Termina nodo:729   */

      /* Empieza nodo:730 / Elemento padre: 27   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(730)).setAttribute("nombre","separa" );
      ((Element)v.get(730)).setAttribute("x","59" );
      ((Element)v.get(730)).setAttribute("y","753" );
      ((Element)v.get(730)).setAttribute("ID","botonContenido" );
      ((Element)v.get(730)).setAttribute("img","separa_base" );
      ((Element)v.get(730)).setAttribute("tipo","0" );
      ((Element)v.get(730)).setAttribute("estado","false" );
      ((Element)v.get(730)).setAttribute("alt","" );
      ((Element)v.get(730)).setAttribute("codigo","" );
      ((Element)v.get(730)).setAttribute("accion","" );
      ((Element)v.get(27)).appendChild((Element)v.get(730));
      /* Termina nodo:730   */

      /* Empieza nodo:731 / Elemento padre: 27   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(731)).setAttribute("nombre","listado2" );
      ((Element)v.get(731)).setAttribute("ancho","632" );
      ((Element)v.get(731)).setAttribute("alto","315" );
      ((Element)v.get(731)).setAttribute("x","12" );
      ((Element)v.get(731)).setAttribute("y","439" );
      ((Element)v.get(731)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(731)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(27)).appendChild((Element)v.get(731));

      /* Empieza nodo:732 / Elemento padre: 731   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(732)).setAttribute("precarga","S" );
      ((Element)v.get(732)).setAttribute("conROver","S" );
      ((Element)v.get(731)).appendChild((Element)v.get(732));

      /* Empieza nodo:733 / Elemento padre: 732   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(733)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(733)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(733)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(733)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(732)).appendChild((Element)v.get(733));
      /* Termina nodo:733   */

      /* Empieza nodo:734 / Elemento padre: 732   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(734)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(734)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(734)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(734)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(732)).appendChild((Element)v.get(734));
      /* Termina nodo:734   */

      /* Empieza nodo:735 / Elemento padre: 732   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(735)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(735)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(732)).appendChild((Element)v.get(735));
      /* Termina nodo:735   */
      /* Termina nodo:732   */

      /* Empieza nodo:736 / Elemento padre: 731   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(731)).appendChild((Element)v.get(736));

      /* Empieza nodo:737 / Elemento padre: 736   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(737)).setAttribute("borde","1" );
      ((Element)v.get(737)).setAttribute("horizDatos","1" );
      ((Element)v.get(737)).setAttribute("horizCabecera","1" );
      ((Element)v.get(737)).setAttribute("vertical","1" );
      ((Element)v.get(737)).setAttribute("horizTitulo","1" );
      ((Element)v.get(737)).setAttribute("horizBase","1" );
      ((Element)v.get(736)).appendChild((Element)v.get(737));
      /* Termina nodo:737   */

      /* Empieza nodo:738 / Elemento padre: 736   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(738)).setAttribute("borde","#999999" );
      ((Element)v.get(738)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(738)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(738)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(738)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(738)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(738)).setAttribute("horizBase","#999999" );
      ((Element)v.get(736)).appendChild((Element)v.get(738));
      /* Termina nodo:738   */
      /* Termina nodo:736   */

      /* Empieza nodo:739 / Elemento padre: 731   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(739)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(739)).setAttribute("alto","22" );
      ((Element)v.get(739)).setAttribute("imgFondo","" );
      ((Element)v.get(739)).setAttribute("cod","00339" );
      ((Element)v.get(739)).setAttribute("ID","datosTitle" );
      ((Element)v.get(731)).appendChild((Element)v.get(739));
      /* Termina nodo:739   */

      /* Empieza nodo:740 / Elemento padre: 731   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(740)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(740)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(740)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(740)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(740)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(740)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(731)).appendChild((Element)v.get(740));

      /* Empieza nodo:741 / Elemento padre: 740   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(741)).setAttribute("ancho","150" );
      ((Element)v.get(741)).setAttribute("minimizable","S" );
      ((Element)v.get(741)).setAttribute("minimizada","N" );
      ((Element)v.get(740)).appendChild((Element)v.get(741));
      /* Termina nodo:741   */

      /* Empieza nodo:742 / Elemento padre: 740   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(742)).setAttribute("ancho","150" );
      ((Element)v.get(742)).setAttribute("minimizable","S" );
      ((Element)v.get(742)).setAttribute("minimizada","N" );
      ((Element)v.get(740)).appendChild((Element)v.get(742));
      /* Termina nodo:742   */

      /* Empieza nodo:743 / Elemento padre: 740   */
      v.add(doc.createElement("COL"));
   }

   private void getXML3150(Document doc) {
      ((Element)v.get(743)).setAttribute("ancho","150" );
      ((Element)v.get(743)).setAttribute("minimizable","S" );
      ((Element)v.get(743)).setAttribute("minimizada","N" );
      ((Element)v.get(740)).appendChild((Element)v.get(743));
      /* Termina nodo:743   */

      /* Empieza nodo:744 / Elemento padre: 740   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(744)).setAttribute("ancho","150" );
      ((Element)v.get(744)).setAttribute("minimizable","S" );
      ((Element)v.get(744)).setAttribute("minimizada","N" );
      ((Element)v.get(740)).appendChild((Element)v.get(744));
      /* Termina nodo:744   */

      /* Empieza nodo:745 / Elemento padre: 740   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(745)).setAttribute("ancho","150" );
      ((Element)v.get(745)).setAttribute("minimizable","S" );
      ((Element)v.get(745)).setAttribute("minimizada","N" );
      ((Element)v.get(740)).appendChild((Element)v.get(745));
      /* Termina nodo:745   */

      /* Empieza nodo:746 / Elemento padre: 740   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(746)).setAttribute("ancho","150" );
      ((Element)v.get(746)).setAttribute("minimizable","S" );
      ((Element)v.get(746)).setAttribute("minimizada","N" );
      ((Element)v.get(740)).appendChild((Element)v.get(746));
      /* Termina nodo:746   */

      /* Empieza nodo:747 / Elemento padre: 740   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(747)).setAttribute("ancho","150" );
      ((Element)v.get(747)).setAttribute("minimizable","S" );
      ((Element)v.get(747)).setAttribute("minimizada","N" );
      ((Element)v.get(740)).appendChild((Element)v.get(747));
      /* Termina nodo:747   */

      /* Empieza nodo:748 / Elemento padre: 740   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(748)).setAttribute("ancho","150" );
      ((Element)v.get(748)).setAttribute("minimizable","S" );
      ((Element)v.get(748)).setAttribute("minimizada","N" );
      ((Element)v.get(740)).appendChild((Element)v.get(748));
      /* Termina nodo:748   */

      /* Empieza nodo:749 / Elemento padre: 740   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(749)).setAttribute("ancho","150" );
      ((Element)v.get(749)).setAttribute("minimizable","S" );
      ((Element)v.get(749)).setAttribute("minimizada","N" );
      ((Element)v.get(740)).appendChild((Element)v.get(749));
      /* Termina nodo:749   */

      /* Empieza nodo:750 / Elemento padre: 740   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(750)).setAttribute("ancho","150" );
      ((Element)v.get(750)).setAttribute("minimizable","S" );
      ((Element)v.get(750)).setAttribute("minimizada","N" );
      ((Element)v.get(740)).appendChild((Element)v.get(750));
      /* Termina nodo:750   */

      /* Empieza nodo:751 / Elemento padre: 740   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(751)).setAttribute("ancho","150" );
      ((Element)v.get(751)).setAttribute("minimizable","S" );
      ((Element)v.get(751)).setAttribute("minimizada","N" );
      ((Element)v.get(740)).appendChild((Element)v.get(751));
      /* Termina nodo:751   */

      /* Empieza nodo:752 / Elemento padre: 740   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(752)).setAttribute("ancho","150" );
      ((Element)v.get(752)).setAttribute("minimizable","S" );
      ((Element)v.get(752)).setAttribute("minimizada","N" );
      ((Element)v.get(740)).appendChild((Element)v.get(752));
      /* Termina nodo:752   */

      /* Empieza nodo:753 / Elemento padre: 740   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(753)).setAttribute("ancho","150" );
      ((Element)v.get(753)).setAttribute("minimizable","S" );
      ((Element)v.get(753)).setAttribute("minimizada","N" );
      ((Element)v.get(753)).setAttribute("oculta","S" );
      ((Element)v.get(740)).appendChild((Element)v.get(753));
      /* Termina nodo:753   */

      /* Empieza nodo:754 / Elemento padre: 740   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(754)).setAttribute("ancho","150" );
      ((Element)v.get(754)).setAttribute("minimizable","S" );
      ((Element)v.get(754)).setAttribute("minimizada","N" );
      ((Element)v.get(754)).setAttribute("oculta","S" );
      ((Element)v.get(740)).appendChild((Element)v.get(754));
      /* Termina nodo:754   */

      /* Empieza nodo:755 / Elemento padre: 740   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(755)).setAttribute("ancho","150" );
      ((Element)v.get(755)).setAttribute("minimizable","S" );
      ((Element)v.get(755)).setAttribute("minimizada","N" );
      ((Element)v.get(755)).setAttribute("oculta","S" );
      ((Element)v.get(740)).appendChild((Element)v.get(755));
      /* Termina nodo:755   */

      /* Empieza nodo:756 / Elemento padre: 740   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(756)).setAttribute("ancho","150" );
      ((Element)v.get(756)).setAttribute("minimizable","S" );
      ((Element)v.get(756)).setAttribute("minimizada","N" );
      ((Element)v.get(756)).setAttribute("oculta","S" );
      ((Element)v.get(740)).appendChild((Element)v.get(756));
      /* Termina nodo:756   */

      /* Empieza nodo:757 / Elemento padre: 740   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(757)).setAttribute("ancho","150" );
      ((Element)v.get(757)).setAttribute("minimizable","S" );
      ((Element)v.get(757)).setAttribute("minimizada","N" );
      ((Element)v.get(757)).setAttribute("oculta","S" );
      ((Element)v.get(740)).appendChild((Element)v.get(757));
      /* Termina nodo:757   */

      /* Empieza nodo:758 / Elemento padre: 740   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(758)).setAttribute("ancho","150" );
      ((Element)v.get(758)).setAttribute("minimizable","S" );
      ((Element)v.get(758)).setAttribute("minimizada","N" );
      ((Element)v.get(758)).setAttribute("oculta","S" );
      ((Element)v.get(740)).appendChild((Element)v.get(758));
      /* Termina nodo:758   */

      /* Empieza nodo:759 / Elemento padre: 740   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(759)).setAttribute("ancho","150" );
      ((Element)v.get(759)).setAttribute("minimizable","S" );
      ((Element)v.get(759)).setAttribute("minimizada","N" );
      ((Element)v.get(759)).setAttribute("oculta","S" );
   }

   private void getXML3240(Document doc) {
      ((Element)v.get(740)).appendChild((Element)v.get(759));
      /* Termina nodo:759   */

      /* Empieza nodo:760 / Elemento padre: 740   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(760)).setAttribute("ancho","150" );
      ((Element)v.get(760)).setAttribute("minimizable","S" );
      ((Element)v.get(760)).setAttribute("minimizada","N" );
      ((Element)v.get(760)).setAttribute("oculta","S" );
      ((Element)v.get(740)).appendChild((Element)v.get(760));
      /* Termina nodo:760   */

      /* Empieza nodo:761 / Elemento padre: 740   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(761)).setAttribute("ancho","150" );
      ((Element)v.get(761)).setAttribute("minimizable","S" );
      ((Element)v.get(761)).setAttribute("minimizada","N" );
      ((Element)v.get(761)).setAttribute("oculta","S" );
      ((Element)v.get(740)).appendChild((Element)v.get(761));
      /* Termina nodo:761   */

      /* Empieza nodo:762 / Elemento padre: 740   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(762)).setAttribute("ancho","150" );
      ((Element)v.get(762)).setAttribute("minimizable","S" );
      ((Element)v.get(762)).setAttribute("minimizada","N" );
      ((Element)v.get(762)).setAttribute("oculta","S" );
      ((Element)v.get(740)).appendChild((Element)v.get(762));
      /* Termina nodo:762   */

      /* Empieza nodo:763 / Elemento padre: 740   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(763)).setAttribute("ancho","150" );
      ((Element)v.get(763)).setAttribute("minimizable","S" );
      ((Element)v.get(763)).setAttribute("minimizada","N" );
      ((Element)v.get(763)).setAttribute("oculta","S" );
      ((Element)v.get(740)).appendChild((Element)v.get(763));
      /* Termina nodo:763   */

      /* Empieza nodo:764 / Elemento padre: 740   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(764)).setAttribute("ancho","150" );
      ((Element)v.get(764)).setAttribute("minimizable","S" );
      ((Element)v.get(764)).setAttribute("minimizada","N" );
      ((Element)v.get(764)).setAttribute("oculta","S" );
      ((Element)v.get(740)).appendChild((Element)v.get(764));
      /* Termina nodo:764   */
      /* Termina nodo:740   */

      /* Empieza nodo:765 / Elemento padre: 731   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(765)).setAttribute("alto","40" );
      ((Element)v.get(765)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(765)).setAttribute("imgFondo","" );
      ((Element)v.get(765)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(765)).setAttribute("ajustarAMitadInf","S" );
      ((Element)v.get(731)).appendChild((Element)v.get(765));

      /* Empieza nodo:766 / Elemento padre: 765   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(766)).setAttribute("colFondo","" );
      ((Element)v.get(766)).setAttribute("ID","EstCab" );
      ((Element)v.get(766)).setAttribute("cod","00335" );
      ((Element)v.get(765)).appendChild((Element)v.get(766));

      /* Empieza nodo:767 / Elemento padre: 766   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(767)).setAttribute("colFondo","" );
      ((Element)v.get(767)).setAttribute("ID","EstCab" );
      ((Element)v.get(767)).setAttribute("cod","2448" );
      ((Element)v.get(766)).appendChild((Element)v.get(767));

      /* Elemento padre:767 / Elemento actual: 768   */
      v.add(doc.createTextNode("Marca Producto"));
      ((Element)v.get(767)).appendChild((Text)v.get(768));

      /* Termina nodo Texto:768   */
      /* Termina nodo:767   */

      /* Empieza nodo:769 / Elemento padre: 766   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(769)).setAttribute("colFondo","" );
      ((Element)v.get(769)).setAttribute("ID","EstCab" );
      ((Element)v.get(769)).setAttribute("cod","1338" );
      ((Element)v.get(766)).appendChild((Element)v.get(769));

      /* Elemento padre:769 / Elemento actual: 770   */
      v.add(doc.createTextNode("Unidad negocio"));
      ((Element)v.get(769)).appendChild((Text)v.get(770));

      /* Termina nodo Texto:770   */
      /* Termina nodo:769   */

      /* Empieza nodo:771 / Elemento padre: 766   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(771)).setAttribute("colFondo","" );
      ((Element)v.get(771)).setAttribute("ID","EstCab" );
      ((Element)v.get(771)).setAttribute("cod","588" );
      ((Element)v.get(766)).appendChild((Element)v.get(771));

      /* Elemento padre:771 / Elemento actual: 772   */
      v.add(doc.createTextNode("Negocio"));
      ((Element)v.get(771)).appendChild((Text)v.get(772));

      /* Termina nodo Texto:772   */
      /* Termina nodo:771   */

      /* Empieza nodo:773 / Elemento padre: 766   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(773)).setAttribute("colFondo","" );
      ((Element)v.get(773)).setAttribute("ID","EstCab" );
      ((Element)v.get(773)).setAttribute("cod","590" );
      ((Element)v.get(766)).appendChild((Element)v.get(773));

      /* Elemento padre:773 / Elemento actual: 774   */
      v.add(doc.createTextNode("Supergenérico"));
      ((Element)v.get(773)).appendChild((Text)v.get(774));

      /* Termina nodo Texto:774   */
      /* Termina nodo:773   */

      /* Empieza nodo:775 / Elemento padre: 766   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(775)).setAttribute("colFondo","" );
      ((Element)v.get(775)).setAttribute("ID","EstCab" );
      ((Element)v.get(775)).setAttribute("cod","589" );
      ((Element)v.get(766)).appendChild((Element)v.get(775));

      /* Elemento padre:775 / Elemento actual: 776   */
      v.add(doc.createTextNode("Genérico"));
      ((Element)v.get(775)).appendChild((Text)v.get(776));

      /* Termina nodo Texto:776   */
      /* Termina nodo:775   */
      /* Termina nodo:766   */

      /* Empieza nodo:777 / Elemento padre: 765   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(777)).setAttribute("colFondo","" );
      ((Element)v.get(777)).setAttribute("ID","EstCab" );
      ((Element)v.get(777)).setAttribute("cod","00336" );
      ((Element)v.get(765)).appendChild((Element)v.get(777));

      /* Empieza nodo:778 / Elemento padre: 777   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(778)).setAttribute("colFondo","" );
      ((Element)v.get(778)).setAttribute("ID","EstCab" );
      ((Element)v.get(778)).setAttribute("cod","608" );
      ((Element)v.get(777)).appendChild((Element)v.get(778));

      /* Elemento padre:778 / Elemento actual: 779   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(778)).appendChild((Text)v.get(779));

      /* Termina nodo Texto:779   */
      /* Termina nodo:778   */

      /* Empieza nodo:780 / Elemento padre: 777   */
   }

   private void getXML3330(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(780)).setAttribute("colFondo","" );
      ((Element)v.get(780)).setAttribute("ID","EstCab" );
      ((Element)v.get(780)).setAttribute("cod","581" );
      ((Element)v.get(777)).appendChild((Element)v.get(780));

      /* Elemento padre:780 / Elemento actual: 781   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(780)).appendChild((Text)v.get(781));

      /* Termina nodo Texto:781   */
      /* Termina nodo:780   */
      /* Termina nodo:777   */

      /* Empieza nodo:782 / Elemento padre: 765   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(782)).setAttribute("colFondo","" );
      ((Element)v.get(782)).setAttribute("ID","EstCab" );
      ((Element)v.get(782)).setAttribute("cod","00337" );
      ((Element)v.get(765)).appendChild((Element)v.get(782));

      /* Empieza nodo:783 / Elemento padre: 782   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(783)).setAttribute("colFondo","" );
      ((Element)v.get(783)).setAttribute("ID","EstCab" );
      ((Element)v.get(783)).setAttribute("cod","337" );
      ((Element)v.get(782)).appendChild((Element)v.get(783));

      /* Elemento padre:783 / Elemento actual: 784   */
      v.add(doc.createTextNode("Cód. producto"));
      ((Element)v.get(783)).appendChild((Text)v.get(784));

      /* Termina nodo Texto:784   */
      /* Termina nodo:783   */

      /* Empieza nodo:785 / Elemento padre: 782   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(785)).setAttribute("colFondo","" );
      ((Element)v.get(785)).setAttribute("ID","EstCab" );
      ((Element)v.get(785)).setAttribute("cod","608" );
      ((Element)v.get(782)).appendChild((Element)v.get(785));

      /* Elemento padre:785 / Elemento actual: 786   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(785)).appendChild((Text)v.get(786));

      /* Termina nodo Texto:786   */
      /* Termina nodo:785   */

      /* Empieza nodo:787 / Elemento padre: 782   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(787)).setAttribute("colFondo","" );
      ((Element)v.get(787)).setAttribute("ID","EstCab" );
      ((Element)v.get(787)).setAttribute("cod","581" );
      ((Element)v.get(782)).appendChild((Element)v.get(787));

      /* Elemento padre:787 / Elemento actual: 788   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(787)).appendChild((Text)v.get(788));

      /* Termina nodo Texto:788   */
      /* Termina nodo:787   */
      /* Termina nodo:782   */

      /* Empieza nodo:789 / Elemento padre: 765   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(789)).setAttribute("colFondo","" );
      ((Element)v.get(789)).setAttribute("ID","EstCab" );
      ((Element)v.get(789)).setAttribute("cod","1175" );
      ((Element)v.get(765)).appendChild((Element)v.get(789));

      /* Elemento padre:789 / Elemento actual: 790   */
      v.add(doc.createTextNode("Período desde"));
      ((Element)v.get(789)).appendChild((Text)v.get(790));

      /* Termina nodo Texto:790   */
      /* Termina nodo:789   */

      /* Empieza nodo:791 / Elemento padre: 765   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(791)).setAttribute("colFondo","" );
      ((Element)v.get(791)).setAttribute("ID","EstCab" );
      ((Element)v.get(791)).setAttribute("cod","1176" );
      ((Element)v.get(765)).appendChild((Element)v.get(791));

      /* Elemento padre:791 / Elemento actual: 792   */
      v.add(doc.createTextNode("Período hasta"));
      ((Element)v.get(791)).appendChild((Text)v.get(792));

      /* Termina nodo Texto:792   */
      /* Termina nodo:791   */

      /* Empieza nodo:793 / Elemento padre: 765   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(793)).setAttribute("colFondo","" );
      ((Element)v.get(793)).setAttribute("ID","EstCab" );
      ((Element)v.get(793)).setAttribute("cod","2448" );
      ((Element)v.get(765)).appendChild((Element)v.get(793));

      /* Elemento padre:793 / Elemento actual: 794   */
      v.add(doc.createTextNode("oidMarca Producto"));
      ((Element)v.get(793)).appendChild((Text)v.get(794));

      /* Termina nodo Texto:794   */
      /* Termina nodo:793   */

      /* Empieza nodo:795 / Elemento padre: 765   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(795)).setAttribute("colFondo","" );
      ((Element)v.get(795)).setAttribute("ID","EstCab" );
      ((Element)v.get(795)).setAttribute("cod","1338" );
      ((Element)v.get(765)).appendChild((Element)v.get(795));

      /* Elemento padre:795 / Elemento actual: 796   */
      v.add(doc.createTextNode("oidUnidad negocio"));
      ((Element)v.get(795)).appendChild((Text)v.get(796));

      /* Termina nodo Texto:796   */
      /* Termina nodo:795   */

      /* Empieza nodo:797 / Elemento padre: 765   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(797)).setAttribute("colFondo","" );
      ((Element)v.get(797)).setAttribute("ID","EstCab" );
      ((Element)v.get(797)).setAttribute("cod","588" );
      ((Element)v.get(765)).appendChild((Element)v.get(797));

      /* Elemento padre:797 / Elemento actual: 798   */
      v.add(doc.createTextNode("oidNegocio"));
      ((Element)v.get(797)).appendChild((Text)v.get(798));

      /* Termina nodo Texto:798   */
      /* Termina nodo:797   */

      /* Empieza nodo:799 / Elemento padre: 765   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(799)).setAttribute("colFondo","" );
      ((Element)v.get(799)).setAttribute("ID","EstCab" );
      ((Element)v.get(799)).setAttribute("cod","590" );
      ((Element)v.get(765)).appendChild((Element)v.get(799));

      /* Elemento padre:799 / Elemento actual: 800   */
      v.add(doc.createTextNode("oidSupergenérico"));
      ((Element)v.get(799)).appendChild((Text)v.get(800));

      /* Termina nodo Texto:800   */
      /* Termina nodo:799   */

      /* Empieza nodo:801 / Elemento padre: 765   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(801)).setAttribute("colFondo","" );
      ((Element)v.get(801)).setAttribute("ID","EstCab" );
      ((Element)v.get(801)).setAttribute("cod","589" );
      ((Element)v.get(765)).appendChild((Element)v.get(801));

      /* Elemento padre:801 / Elemento actual: 802   */
      v.add(doc.createTextNode("oidGenérico"));
      ((Element)v.get(801)).appendChild((Text)v.get(802));

      /* Termina nodo Texto:802   */
      /* Termina nodo:801   */

      /* Empieza nodo:803 / Elemento padre: 765   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(803)).setAttribute("colFondo","" );
      ((Element)v.get(803)).setAttribute("ID","EstCab" );
      ((Element)v.get(803)).setAttribute("cod","608" );
      ((Element)v.get(765)).appendChild((Element)v.get(803));

      /* Elemento padre:803 / Elemento actual: 804   */
      v.add(doc.createTextNode("oidTipo oferta"));
      ((Element)v.get(803)).appendChild((Text)v.get(804));

      /* Termina nodo Texto:804   */
      /* Termina nodo:803   */

      /* Empieza nodo:805 / Elemento padre: 765   */
      v.add(doc.createElement("COL"));
   }

   private void getXML3420(Document doc) {
      ((Element)v.get(805)).setAttribute("colFondo","" );
      ((Element)v.get(805)).setAttribute("ID","EstCab" );
      ((Element)v.get(805)).setAttribute("cod","581" );
      ((Element)v.get(765)).appendChild((Element)v.get(805));

      /* Elemento padre:805 / Elemento actual: 806   */
      v.add(doc.createTextNode("oidCiclo vida"));
      ((Element)v.get(805)).appendChild((Text)v.get(806));

      /* Termina nodo Texto:806   */
      /* Termina nodo:805   */

      /* Empieza nodo:807 / Elemento padre: 765   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(807)).setAttribute("colFondo","" );
      ((Element)v.get(807)).setAttribute("ID","EstCab" );
      ((Element)v.get(807)).setAttribute("cod","337" );
      ((Element)v.get(765)).appendChild((Element)v.get(807));

      /* Elemento padre:807 / Elemento actual: 808   */
      v.add(doc.createTextNode("oidCód. producto"));
      ((Element)v.get(807)).appendChild((Text)v.get(808));

      /* Termina nodo Texto:808   */
      /* Termina nodo:807   */

      /* Empieza nodo:809 / Elemento padre: 765   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(809)).setAttribute("colFondo","" );
      ((Element)v.get(809)).setAttribute("ID","EstCab" );
      ((Element)v.get(809)).setAttribute("cod","608" );
      ((Element)v.get(765)).appendChild((Element)v.get(809));

      /* Elemento padre:809 / Elemento actual: 810   */
      v.add(doc.createTextNode("oidTipo oferta"));
      ((Element)v.get(809)).appendChild((Text)v.get(810));

      /* Termina nodo Texto:810   */
      /* Termina nodo:809   */

      /* Empieza nodo:811 / Elemento padre: 765   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(811)).setAttribute("colFondo","" );
      ((Element)v.get(811)).setAttribute("ID","EstCab" );
      ((Element)v.get(811)).setAttribute("cod","581" );
      ((Element)v.get(765)).appendChild((Element)v.get(811));

      /* Elemento padre:811 / Elemento actual: 812   */
      v.add(doc.createTextNode("oidCiclo vida"));
      ((Element)v.get(811)).appendChild((Text)v.get(812));

      /* Termina nodo Texto:812   */
      /* Termina nodo:811   */

      /* Empieza nodo:813 / Elemento padre: 765   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(813)).setAttribute("colFondo","" );
      ((Element)v.get(813)).setAttribute("ID","EstCab" );
      ((Element)v.get(813)).setAttribute("cod","1175" );
      ((Element)v.get(765)).appendChild((Element)v.get(813));

      /* Elemento padre:813 / Elemento actual: 814   */
      v.add(doc.createTextNode("oidPeríodo desde"));
      ((Element)v.get(813)).appendChild((Text)v.get(814));

      /* Termina nodo Texto:814   */
      /* Termina nodo:813   */

      /* Empieza nodo:815 / Elemento padre: 765   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(815)).setAttribute("colFondo","" );
      ((Element)v.get(815)).setAttribute("ID","EstCab" );
      ((Element)v.get(815)).setAttribute("cod","1176" );
      ((Element)v.get(765)).appendChild((Element)v.get(815));

      /* Elemento padre:815 / Elemento actual: 816   */
      v.add(doc.createTextNode("oidPeríodo hasta"));
      ((Element)v.get(815)).appendChild((Text)v.get(816));

      /* Termina nodo Texto:816   */
      /* Termina nodo:815   */
      /* Termina nodo:765   */

      /* Empieza nodo:817 / Elemento padre: 731   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(817)).setAttribute("alto","22" );
      ((Element)v.get(817)).setAttribute("accion","" );
      ((Element)v.get(817)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(817)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(817)).setAttribute("maxSel","-1" );
      ((Element)v.get(817)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(817)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(817)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(817)).setAttribute("onLoad","" );
      ((Element)v.get(817)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(731)).appendChild((Element)v.get(817));

      /* Empieza nodo:818 / Elemento padre: 817   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(818)).setAttribute("tipo","texto" );
      ((Element)v.get(818)).setAttribute("ID","EstDat" );
      ((Element)v.get(817)).appendChild((Element)v.get(818));
      /* Termina nodo:818   */

      /* Empieza nodo:819 / Elemento padre: 817   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(819)).setAttribute("tipo","texto" );
      ((Element)v.get(819)).setAttribute("ID","EstDat2" );
      ((Element)v.get(817)).appendChild((Element)v.get(819));
      /* Termina nodo:819   */

      /* Empieza nodo:820 / Elemento padre: 817   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(820)).setAttribute("tipo","texto" );
      ((Element)v.get(820)).setAttribute("ID","EstDat" );
      ((Element)v.get(817)).appendChild((Element)v.get(820));
      /* Termina nodo:820   */

      /* Empieza nodo:821 / Elemento padre: 817   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(821)).setAttribute("tipo","texto" );
      ((Element)v.get(821)).setAttribute("ID","EstDat2" );
      ((Element)v.get(817)).appendChild((Element)v.get(821));
      /* Termina nodo:821   */

      /* Empieza nodo:822 / Elemento padre: 817   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(822)).setAttribute("tipo","texto" );
      ((Element)v.get(822)).setAttribute("ID","EstDat" );
      ((Element)v.get(817)).appendChild((Element)v.get(822));
      /* Termina nodo:822   */

      /* Empieza nodo:823 / Elemento padre: 817   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(823)).setAttribute("tipo","texto" );
      ((Element)v.get(823)).setAttribute("ID","EstDat2" );
      ((Element)v.get(817)).appendChild((Element)v.get(823));
      /* Termina nodo:823   */

      /* Empieza nodo:824 / Elemento padre: 817   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(824)).setAttribute("tipo","texto" );
      ((Element)v.get(824)).setAttribute("ID","EstDat" );
      ((Element)v.get(817)).appendChild((Element)v.get(824));
      /* Termina nodo:824   */

      /* Empieza nodo:825 / Elemento padre: 817   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(825)).setAttribute("tipo","texto" );
      ((Element)v.get(825)).setAttribute("ID","EstDat2" );
      ((Element)v.get(817)).appendChild((Element)v.get(825));
      /* Termina nodo:825   */

      /* Empieza nodo:826 / Elemento padre: 817   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(826)).setAttribute("tipo","texto" );
      ((Element)v.get(826)).setAttribute("ID","EstDat" );
      ((Element)v.get(817)).appendChild((Element)v.get(826));
      /* Termina nodo:826   */

      /* Empieza nodo:827 / Elemento padre: 817   */
      v.add(doc.createElement("COL"));
   }

   private void getXML3510(Document doc) {
      ((Element)v.get(827)).setAttribute("tipo","texto" );
      ((Element)v.get(827)).setAttribute("ID","EstDat2" );
      ((Element)v.get(817)).appendChild((Element)v.get(827));
      /* Termina nodo:827   */

      /* Empieza nodo:828 / Elemento padre: 817   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(828)).setAttribute("tipo","texto" );
      ((Element)v.get(828)).setAttribute("ID","EstDat" );
      ((Element)v.get(817)).appendChild((Element)v.get(828));
      /* Termina nodo:828   */

      /* Empieza nodo:829 / Elemento padre: 817   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(829)).setAttribute("tipo","texto" );
      ((Element)v.get(829)).setAttribute("ID","EstDat2" );
      ((Element)v.get(817)).appendChild((Element)v.get(829));
      /* Termina nodo:829   */

      /* Empieza nodo:830 / Elemento padre: 817   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(830)).setAttribute("tipo","texto" );
      ((Element)v.get(830)).setAttribute("ID","EstDat2" );
      ((Element)v.get(817)).appendChild((Element)v.get(830));
      /* Termina nodo:830   */

      /* Empieza nodo:831 / Elemento padre: 817   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(831)).setAttribute("tipo","texto" );
      ((Element)v.get(831)).setAttribute("ID","EstDat2" );
      ((Element)v.get(817)).appendChild((Element)v.get(831));
      /* Termina nodo:831   */

      /* Empieza nodo:832 / Elemento padre: 817   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(832)).setAttribute("tipo","texto" );
      ((Element)v.get(832)).setAttribute("ID","EstDat2" );
      ((Element)v.get(817)).appendChild((Element)v.get(832));
      /* Termina nodo:832   */

      /* Empieza nodo:833 / Elemento padre: 817   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(833)).setAttribute("tipo","texto" );
      ((Element)v.get(833)).setAttribute("ID","EstDat2" );
      ((Element)v.get(817)).appendChild((Element)v.get(833));
      /* Termina nodo:833   */

      /* Empieza nodo:834 / Elemento padre: 817   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(834)).setAttribute("tipo","texto" );
      ((Element)v.get(834)).setAttribute("ID","EstDat2" );
      ((Element)v.get(817)).appendChild((Element)v.get(834));
      /* Termina nodo:834   */

      /* Empieza nodo:835 / Elemento padre: 817   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(835)).setAttribute("tipo","texto" );
      ((Element)v.get(835)).setAttribute("ID","EstDat2" );
      ((Element)v.get(817)).appendChild((Element)v.get(835));
      /* Termina nodo:835   */

      /* Empieza nodo:836 / Elemento padre: 817   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(836)).setAttribute("tipo","texto" );
      ((Element)v.get(836)).setAttribute("ID","EstDat2" );
      ((Element)v.get(817)).appendChild((Element)v.get(836));
      /* Termina nodo:836   */

      /* Empieza nodo:837 / Elemento padre: 817   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(837)).setAttribute("tipo","texto" );
      ((Element)v.get(837)).setAttribute("ID","EstDat2" );
      ((Element)v.get(817)).appendChild((Element)v.get(837));
      /* Termina nodo:837   */

      /* Empieza nodo:838 / Elemento padre: 817   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(838)).setAttribute("tipo","texto" );
      ((Element)v.get(838)).setAttribute("ID","EstDat2" );
      ((Element)v.get(817)).appendChild((Element)v.get(838));
      /* Termina nodo:838   */

      /* Empieza nodo:839 / Elemento padre: 817   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(839)).setAttribute("tipo","texto" );
      ((Element)v.get(839)).setAttribute("ID","EstDat2" );
      ((Element)v.get(817)).appendChild((Element)v.get(839));
      /* Termina nodo:839   */

      /* Empieza nodo:840 / Elemento padre: 817   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(840)).setAttribute("tipo","texto" );
      ((Element)v.get(840)).setAttribute("ID","EstDat2" );
      ((Element)v.get(817)).appendChild((Element)v.get(840));
      /* Termina nodo:840   */

      /* Empieza nodo:841 / Elemento padre: 817   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(841)).setAttribute("tipo","texto" );
      ((Element)v.get(841)).setAttribute("ID","EstDat2" );
      ((Element)v.get(817)).appendChild((Element)v.get(841));
      /* Termina nodo:841   */
      /* Termina nodo:817   */

      /* Empieza nodo:842 / Elemento padre: 731   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(731)).appendChild((Element)v.get(842));
      /* Termina nodo:842   */

      /* Empieza nodo:843 / Elemento padre: 731   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(843)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(843)).setAttribute("ancho","504" );
      ((Element)v.get(843)).setAttribute("sep","$" );
      ((Element)v.get(843)).setAttribute("x","12" );
      ((Element)v.get(843)).setAttribute("class","botonera" );
      ((Element)v.get(843)).setAttribute("y","753" );
      ((Element)v.get(843)).setAttribute("control","|" );
      ((Element)v.get(843)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(843)).setAttribute("rowset","" );
      ((Element)v.get(843)).setAttribute("cargainicial","N" );
      ((Element)v.get(731)).appendChild((Element)v.get(843));

      /* Empieza nodo:844 / Elemento padre: 843   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(844)).setAttribute("nombre","ret2" );
      ((Element)v.get(844)).setAttribute("x","37" );
      ((Element)v.get(844)).setAttribute("y","757" );
      ((Element)v.get(844)).setAttribute("ID","botonContenido" );
      ((Element)v.get(844)).setAttribute("img","retroceder_on" );
      ((Element)v.get(844)).setAttribute("tipo","0" );
      ((Element)v.get(844)).setAttribute("estado","false" );
      ((Element)v.get(844)).setAttribute("alt","" );
      ((Element)v.get(844)).setAttribute("codigo","" );
      ((Element)v.get(844)).setAttribute("accion","mipgndo2.retroceder();" );
      ((Element)v.get(843)).appendChild((Element)v.get(844));
      /* Termina nodo:844   */

      /* Empieza nodo:845 / Elemento padre: 843   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(845)).setAttribute("nombre","ava2" );
      ((Element)v.get(845)).setAttribute("x","52" );
      ((Element)v.get(845)).setAttribute("y","757" );
      ((Element)v.get(845)).setAttribute("ID","botonContenido" );
   }

   private void getXML3600(Document doc) {
      ((Element)v.get(845)).setAttribute("img","avanzar_on" );
      ((Element)v.get(845)).setAttribute("tipo","0" );
      ((Element)v.get(845)).setAttribute("estado","false" );
      ((Element)v.get(845)).setAttribute("alt","" );
      ((Element)v.get(845)).setAttribute("codigo","" );
      ((Element)v.get(845)).setAttribute("accion","mipgndo2.avanzar();" );
      ((Element)v.get(843)).appendChild((Element)v.get(845));
      /* Termina nodo:845   */
      /* Termina nodo:843   */
      /* Termina nodo:731   */

      /* Empieza nodo:846 / Elemento padre: 27   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(846)).setAttribute("nombre","primera2" );
      ((Element)v.get(846)).setAttribute("x","20" );
      ((Element)v.get(846)).setAttribute("y","757" );
      ((Element)v.get(846)).setAttribute("ID","botonContenido" );
      ((Element)v.get(846)).setAttribute("img","primera_on" );
      ((Element)v.get(846)).setAttribute("tipo","0" );
      ((Element)v.get(846)).setAttribute("estado","false" );
      ((Element)v.get(846)).setAttribute("alt","" );
      ((Element)v.get(846)).setAttribute("codigo","" );
      ((Element)v.get(846)).setAttribute("accion","mipgndo2.retrocederPrimeraPagina();" );
      ((Element)v.get(27)).appendChild((Element)v.get(846));
      /* Termina nodo:846   */

      /* Empieza nodo:847 / Elemento padre: 27   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(847)).setAttribute("nombre","separa2" );
      ((Element)v.get(847)).setAttribute("x","59" );
      ((Element)v.get(847)).setAttribute("y","753" );
      ((Element)v.get(847)).setAttribute("ID","botonContenido" );
      ((Element)v.get(847)).setAttribute("img","separa_base" );
      ((Element)v.get(847)).setAttribute("tipo","0" );
      ((Element)v.get(847)).setAttribute("estado","false" );
      ((Element)v.get(847)).setAttribute("alt","" );
      ((Element)v.get(847)).setAttribute("codigo","" );
      ((Element)v.get(847)).setAttribute("accion","" );
      ((Element)v.get(27)).appendChild((Element)v.get(847));
      /* Termina nodo:847   */

      /* Empieza nodo:848 / Elemento padre: 27   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(848)).setAttribute("nombre","listado3" );
      ((Element)v.get(848)).setAttribute("ancho","632" );
      ((Element)v.get(848)).setAttribute("alto","315" );
      ((Element)v.get(848)).setAttribute("x","12" );
      ((Element)v.get(848)).setAttribute("y","439" );
      ((Element)v.get(848)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(848)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(27)).appendChild((Element)v.get(848));

      /* Empieza nodo:849 / Elemento padre: 848   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(849)).setAttribute("precarga","S" );
      ((Element)v.get(849)).setAttribute("conROver","S" );
      ((Element)v.get(848)).appendChild((Element)v.get(849));

      /* Empieza nodo:850 / Elemento padre: 849   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(850)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(850)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(850)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(850)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(849)).appendChild((Element)v.get(850));
      /* Termina nodo:850   */

      /* Empieza nodo:851 / Elemento padre: 849   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(851)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(851)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(851)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(851)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(849)).appendChild((Element)v.get(851));
      /* Termina nodo:851   */

      /* Empieza nodo:852 / Elemento padre: 849   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(852)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(852)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(849)).appendChild((Element)v.get(852));
      /* Termina nodo:852   */
      /* Termina nodo:849   */

      /* Empieza nodo:853 / Elemento padre: 848   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(848)).appendChild((Element)v.get(853));

      /* Empieza nodo:854 / Elemento padre: 853   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(854)).setAttribute("borde","1" );
      ((Element)v.get(854)).setAttribute("horizDatos","1" );
      ((Element)v.get(854)).setAttribute("horizCabecera","1" );
      ((Element)v.get(854)).setAttribute("vertical","1" );
      ((Element)v.get(854)).setAttribute("horizTitulo","1" );
      ((Element)v.get(854)).setAttribute("horizBase","1" );
      ((Element)v.get(853)).appendChild((Element)v.get(854));
      /* Termina nodo:854   */

      /* Empieza nodo:855 / Elemento padre: 853   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(855)).setAttribute("borde","#999999" );
      ((Element)v.get(855)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(855)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(855)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(855)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(855)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(855)).setAttribute("horizBase","#999999" );
      ((Element)v.get(853)).appendChild((Element)v.get(855));
      /* Termina nodo:855   */
      /* Termina nodo:853   */

      /* Empieza nodo:856 / Elemento padre: 848   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(856)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(856)).setAttribute("alto","22" );
      ((Element)v.get(856)).setAttribute("imgFondo","" );
      ((Element)v.get(856)).setAttribute("cod","00340" );
      ((Element)v.get(856)).setAttribute("ID","datosTitle" );
      ((Element)v.get(848)).appendChild((Element)v.get(856));
      /* Termina nodo:856   */

      /* Empieza nodo:857 / Elemento padre: 848   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(857)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(857)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(857)).setAttribute("blancosAInsertar","1" );
   }

   private void getXML3690(Document doc) {
      ((Element)v.get(857)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(857)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(857)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(848)).appendChild((Element)v.get(857));

      /* Empieza nodo:858 / Elemento padre: 857   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(858)).setAttribute("ancho","150" );
      ((Element)v.get(858)).setAttribute("minimizable","S" );
      ((Element)v.get(858)).setAttribute("minimizada","N" );
      ((Element)v.get(857)).appendChild((Element)v.get(858));
      /* Termina nodo:858   */

      /* Empieza nodo:859 / Elemento padre: 857   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(859)).setAttribute("ancho","150" );
      ((Element)v.get(859)).setAttribute("minimizable","S" );
      ((Element)v.get(859)).setAttribute("minimizada","N" );
      ((Element)v.get(857)).appendChild((Element)v.get(859));
      /* Termina nodo:859   */

      /* Empieza nodo:860 / Elemento padre: 857   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(860)).setAttribute("ancho","150" );
      ((Element)v.get(860)).setAttribute("minimizable","S" );
      ((Element)v.get(860)).setAttribute("minimizada","N" );
      ((Element)v.get(857)).appendChild((Element)v.get(860));
      /* Termina nodo:860   */

      /* Empieza nodo:861 / Elemento padre: 857   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(861)).setAttribute("ancho","150" );
      ((Element)v.get(861)).setAttribute("minimizable","S" );
      ((Element)v.get(861)).setAttribute("minimizada","N" );
      ((Element)v.get(857)).appendChild((Element)v.get(861));
      /* Termina nodo:861   */

      /* Empieza nodo:862 / Elemento padre: 857   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(862)).setAttribute("ancho","150" );
      ((Element)v.get(862)).setAttribute("minimizable","S" );
      ((Element)v.get(862)).setAttribute("minimizada","N" );
      ((Element)v.get(857)).appendChild((Element)v.get(862));
      /* Termina nodo:862   */

      /* Empieza nodo:863 / Elemento padre: 857   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(863)).setAttribute("ancho","150" );
      ((Element)v.get(863)).setAttribute("minimizable","S" );
      ((Element)v.get(863)).setAttribute("minimizada","N" );
      ((Element)v.get(857)).appendChild((Element)v.get(863));
      /* Termina nodo:863   */

      /* Empieza nodo:864 / Elemento padre: 857   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(864)).setAttribute("ancho","150" );
      ((Element)v.get(864)).setAttribute("minimizable","S" );
      ((Element)v.get(864)).setAttribute("minimizada","N" );
      ((Element)v.get(857)).appendChild((Element)v.get(864));
      /* Termina nodo:864   */

      /* Empieza nodo:865 / Elemento padre: 857   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(865)).setAttribute("ancho","150" );
      ((Element)v.get(865)).setAttribute("minimizable","S" );
      ((Element)v.get(865)).setAttribute("minimizada","N" );
      ((Element)v.get(857)).appendChild((Element)v.get(865));
      /* Termina nodo:865   */

      /* Empieza nodo:866 / Elemento padre: 857   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(866)).setAttribute("ancho","150" );
      ((Element)v.get(866)).setAttribute("minimizable","S" );
      ((Element)v.get(866)).setAttribute("minimizada","N" );
      ((Element)v.get(857)).appendChild((Element)v.get(866));
      /* Termina nodo:866   */

      /* Empieza nodo:867 / Elemento padre: 857   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(867)).setAttribute("ancho","150" );
      ((Element)v.get(867)).setAttribute("minimizable","S" );
      ((Element)v.get(867)).setAttribute("minimizada","N" );
      ((Element)v.get(857)).appendChild((Element)v.get(867));
      /* Termina nodo:867   */

      /* Empieza nodo:868 / Elemento padre: 857   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(868)).setAttribute("ancho","150" );
      ((Element)v.get(868)).setAttribute("minimizable","S" );
      ((Element)v.get(868)).setAttribute("minimizada","N" );
      ((Element)v.get(857)).appendChild((Element)v.get(868));
      /* Termina nodo:868   */

      /* Empieza nodo:869 / Elemento padre: 857   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(869)).setAttribute("ancho","150" );
      ((Element)v.get(869)).setAttribute("minimizable","S" );
      ((Element)v.get(869)).setAttribute("minimizada","N" );
      ((Element)v.get(857)).appendChild((Element)v.get(869));
      /* Termina nodo:869   */

      /* Empieza nodo:870 / Elemento padre: 857   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(870)).setAttribute("ancho","150" );
      ((Element)v.get(870)).setAttribute("minimizable","S" );
      ((Element)v.get(870)).setAttribute("minimizada","N" );
      ((Element)v.get(857)).appendChild((Element)v.get(870));
      /* Termina nodo:870   */

      /* Empieza nodo:871 / Elemento padre: 857   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(871)).setAttribute("ancho","150" );
      ((Element)v.get(871)).setAttribute("minimizable","S" );
      ((Element)v.get(871)).setAttribute("minimizada","N" );
      ((Element)v.get(857)).appendChild((Element)v.get(871));
      /* Termina nodo:871   */

      /* Empieza nodo:872 / Elemento padre: 857   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(872)).setAttribute("ancho","150" );
      ((Element)v.get(872)).setAttribute("minimizable","S" );
      ((Element)v.get(872)).setAttribute("minimizada","N" );
      ((Element)v.get(872)).setAttribute("oculta","S" );
      ((Element)v.get(857)).appendChild((Element)v.get(872));
      /* Termina nodo:872   */

      /* Empieza nodo:873 / Elemento padre: 857   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(873)).setAttribute("ancho","150" );
      ((Element)v.get(873)).setAttribute("minimizable","S" );
      ((Element)v.get(873)).setAttribute("minimizada","N" );
      ((Element)v.get(873)).setAttribute("oculta","S" );
      ((Element)v.get(857)).appendChild((Element)v.get(873));
      /* Termina nodo:873   */

      /* Empieza nodo:874 / Elemento padre: 857   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(874)).setAttribute("ancho","150" );
      ((Element)v.get(874)).setAttribute("minimizable","S" );
      ((Element)v.get(874)).setAttribute("minimizada","N" );
   }

   private void getXML3780(Document doc) {
      ((Element)v.get(874)).setAttribute("oculta","S" );
      ((Element)v.get(857)).appendChild((Element)v.get(874));
      /* Termina nodo:874   */

      /* Empieza nodo:875 / Elemento padre: 857   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(875)).setAttribute("ancho","150" );
      ((Element)v.get(875)).setAttribute("minimizable","S" );
      ((Element)v.get(875)).setAttribute("minimizada","N" );
      ((Element)v.get(875)).setAttribute("oculta","S" );
      ((Element)v.get(857)).appendChild((Element)v.get(875));
      /* Termina nodo:875   */

      /* Empieza nodo:876 / Elemento padre: 857   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(876)).setAttribute("ancho","150" );
      ((Element)v.get(876)).setAttribute("minimizable","S" );
      ((Element)v.get(876)).setAttribute("minimizada","N" );
      ((Element)v.get(876)).setAttribute("oculta","S" );
      ((Element)v.get(857)).appendChild((Element)v.get(876));
      /* Termina nodo:876   */

      /* Empieza nodo:877 / Elemento padre: 857   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(877)).setAttribute("ancho","150" );
      ((Element)v.get(877)).setAttribute("minimizable","S" );
      ((Element)v.get(877)).setAttribute("minimizada","N" );
      ((Element)v.get(877)).setAttribute("oculta","S" );
      ((Element)v.get(857)).appendChild((Element)v.get(877));
      /* Termina nodo:877   */

      /* Empieza nodo:878 / Elemento padre: 857   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(878)).setAttribute("ancho","150" );
      ((Element)v.get(878)).setAttribute("minimizable","S" );
      ((Element)v.get(878)).setAttribute("minimizada","N" );
      ((Element)v.get(878)).setAttribute("oculta","S" );
      ((Element)v.get(857)).appendChild((Element)v.get(878));
      /* Termina nodo:878   */

      /* Empieza nodo:879 / Elemento padre: 857   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(879)).setAttribute("ancho","150" );
      ((Element)v.get(879)).setAttribute("minimizable","S" );
      ((Element)v.get(879)).setAttribute("minimizada","N" );
      ((Element)v.get(879)).setAttribute("oculta","S" );
      ((Element)v.get(857)).appendChild((Element)v.get(879));
      /* Termina nodo:879   */

      /* Empieza nodo:880 / Elemento padre: 857   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(880)).setAttribute("ancho","150" );
      ((Element)v.get(880)).setAttribute("minimizable","S" );
      ((Element)v.get(880)).setAttribute("minimizada","N" );
      ((Element)v.get(880)).setAttribute("oculta","S" );
      ((Element)v.get(857)).appendChild((Element)v.get(880));
      /* Termina nodo:880   */

      /* Empieza nodo:881 / Elemento padre: 857   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(881)).setAttribute("ancho","150" );
      ((Element)v.get(881)).setAttribute("minimizable","S" );
      ((Element)v.get(881)).setAttribute("minimizada","N" );
      ((Element)v.get(881)).setAttribute("oculta","S" );
      ((Element)v.get(857)).appendChild((Element)v.get(881));
      /* Termina nodo:881   */

      /* Empieza nodo:882 / Elemento padre: 857   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(882)).setAttribute("ancho","150" );
      ((Element)v.get(882)).setAttribute("minimizable","S" );
      ((Element)v.get(882)).setAttribute("minimizada","N" );
      ((Element)v.get(882)).setAttribute("oculta","S" );
      ((Element)v.get(857)).appendChild((Element)v.get(882));
      /* Termina nodo:882   */

      /* Empieza nodo:883 / Elemento padre: 857   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(883)).setAttribute("ancho","150" );
      ((Element)v.get(883)).setAttribute("minimizable","S" );
      ((Element)v.get(883)).setAttribute("minimizada","N" );
      ((Element)v.get(883)).setAttribute("oculta","S" );
      ((Element)v.get(857)).appendChild((Element)v.get(883));
      /* Termina nodo:883   */
      /* Termina nodo:857   */

      /* Empieza nodo:884 / Elemento padre: 848   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(884)).setAttribute("alto","40" );
      ((Element)v.get(884)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(884)).setAttribute("imgFondo","" );
      ((Element)v.get(884)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(884)).setAttribute("ajustarAMitadInf","S" );
      ((Element)v.get(848)).appendChild((Element)v.get(884));

      /* Empieza nodo:885 / Elemento padre: 884   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(885)).setAttribute("colFondo","" );
      ((Element)v.get(885)).setAttribute("ID","EstCab" );
      ((Element)v.get(885)).setAttribute("cod","00335" );
      ((Element)v.get(884)).appendChild((Element)v.get(885));

      /* Empieza nodo:886 / Elemento padre: 885   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(886)).setAttribute("colFondo","" );
      ((Element)v.get(886)).setAttribute("ID","EstCab" );
      ((Element)v.get(886)).setAttribute("cod","2448" );
      ((Element)v.get(885)).appendChild((Element)v.get(886));

      /* Elemento padre:886 / Elemento actual: 887   */
      v.add(doc.createTextNode("Marca Producto"));
      ((Element)v.get(886)).appendChild((Text)v.get(887));

      /* Termina nodo Texto:887   */
      /* Termina nodo:886   */

      /* Empieza nodo:888 / Elemento padre: 885   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(888)).setAttribute("colFondo","" );
      ((Element)v.get(888)).setAttribute("ID","EstCab" );
      ((Element)v.get(888)).setAttribute("cod","1338" );
      ((Element)v.get(885)).appendChild((Element)v.get(888));

      /* Elemento padre:888 / Elemento actual: 889   */
      v.add(doc.createTextNode("Unidad negocio"));
      ((Element)v.get(888)).appendChild((Text)v.get(889));

      /* Termina nodo Texto:889   */
      /* Termina nodo:888   */

      /* Empieza nodo:890 / Elemento padre: 885   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(890)).setAttribute("colFondo","" );
      ((Element)v.get(890)).setAttribute("ID","EstCab" );
      ((Element)v.get(890)).setAttribute("cod","588" );
      ((Element)v.get(885)).appendChild((Element)v.get(890));

      /* Elemento padre:890 / Elemento actual: 891   */
      v.add(doc.createTextNode("Negocio"));
      ((Element)v.get(890)).appendChild((Text)v.get(891));

      /* Termina nodo Texto:891   */
      /* Termina nodo:890   */

      /* Empieza nodo:892 / Elemento padre: 885   */
      v.add(doc.createElement("COL"));
   }

   private void getXML3870(Document doc) {
      ((Element)v.get(892)).setAttribute("colFondo","" );
      ((Element)v.get(892)).setAttribute("ID","EstCab" );
      ((Element)v.get(892)).setAttribute("cod","590" );
      ((Element)v.get(885)).appendChild((Element)v.get(892));

      /* Elemento padre:892 / Elemento actual: 893   */
      v.add(doc.createTextNode("Supergenérico"));
      ((Element)v.get(892)).appendChild((Text)v.get(893));

      /* Termina nodo Texto:893   */
      /* Termina nodo:892   */

      /* Empieza nodo:894 / Elemento padre: 885   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(894)).setAttribute("colFondo","" );
      ((Element)v.get(894)).setAttribute("ID","EstCab" );
      ((Element)v.get(894)).setAttribute("cod","589" );
      ((Element)v.get(885)).appendChild((Element)v.get(894));

      /* Elemento padre:894 / Elemento actual: 895   */
      v.add(doc.createTextNode("Genérico"));
      ((Element)v.get(894)).appendChild((Text)v.get(895));

      /* Termina nodo Texto:895   */
      /* Termina nodo:894   */
      /* Termina nodo:885   */

      /* Empieza nodo:896 / Elemento padre: 884   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(896)).setAttribute("colFondo","" );
      ((Element)v.get(896)).setAttribute("ID","EstCab" );
      ((Element)v.get(896)).setAttribute("cod","00336" );
      ((Element)v.get(884)).appendChild((Element)v.get(896));

      /* Empieza nodo:897 / Elemento padre: 896   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(897)).setAttribute("colFondo","" );
      ((Element)v.get(897)).setAttribute("ID","EstCab" );
      ((Element)v.get(897)).setAttribute("cod","608" );
      ((Element)v.get(896)).appendChild((Element)v.get(897));

      /* Elemento padre:897 / Elemento actual: 898   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(897)).appendChild((Text)v.get(898));

      /* Termina nodo Texto:898   */
      /* Termina nodo:897   */

      /* Empieza nodo:899 / Elemento padre: 896   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(899)).setAttribute("colFondo","" );
      ((Element)v.get(899)).setAttribute("ID","EstCab" );
      ((Element)v.get(899)).setAttribute("cod","581" );
      ((Element)v.get(896)).appendChild((Element)v.get(899));

      /* Elemento padre:899 / Elemento actual: 900   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(899)).appendChild((Text)v.get(900));

      /* Termina nodo Texto:900   */
      /* Termina nodo:899   */
      /* Termina nodo:896   */

      /* Empieza nodo:901 / Elemento padre: 884   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(901)).setAttribute("colFondo","" );
      ((Element)v.get(901)).setAttribute("ID","EstCab" );
      ((Element)v.get(901)).setAttribute("cod","00337" );
      ((Element)v.get(884)).appendChild((Element)v.get(901));

      /* Empieza nodo:902 / Elemento padre: 901   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(902)).setAttribute("colFondo","" );
      ((Element)v.get(902)).setAttribute("ID","EstCab" );
      ((Element)v.get(902)).setAttribute("cod","337" );
      ((Element)v.get(901)).appendChild((Element)v.get(902));

      /* Elemento padre:902 / Elemento actual: 903   */
      v.add(doc.createTextNode("Cód. producto"));
      ((Element)v.get(902)).appendChild((Text)v.get(903));

      /* Termina nodo Texto:903   */
      /* Termina nodo:902   */

      /* Empieza nodo:904 / Elemento padre: 901   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(904)).setAttribute("colFondo","" );
      ((Element)v.get(904)).setAttribute("ID","EstCab" );
      ((Element)v.get(904)).setAttribute("cod","608" );
      ((Element)v.get(901)).appendChild((Element)v.get(904));

      /* Elemento padre:904 / Elemento actual: 905   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(904)).appendChild((Text)v.get(905));

      /* Termina nodo Texto:905   */
      /* Termina nodo:904   */

      /* Empieza nodo:906 / Elemento padre: 901   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(906)).setAttribute("colFondo","" );
      ((Element)v.get(906)).setAttribute("ID","EstCab" );
      ((Element)v.get(906)).setAttribute("cod","581" );
      ((Element)v.get(901)).appendChild((Element)v.get(906));

      /* Elemento padre:906 / Elemento actual: 907   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(906)).appendChild((Text)v.get(907));

      /* Termina nodo Texto:907   */
      /* Termina nodo:906   */
      /* Termina nodo:901   */

      /* Empieza nodo:908 / Elemento padre: 884   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(908)).setAttribute("colFondo","" );
      ((Element)v.get(908)).setAttribute("ID","EstCab" );
      ((Element)v.get(908)).setAttribute("cod","1175" );
      ((Element)v.get(884)).appendChild((Element)v.get(908));

      /* Elemento padre:908 / Elemento actual: 909   */
      v.add(doc.createTextNode("Período desde"));
      ((Element)v.get(908)).appendChild((Text)v.get(909));

      /* Termina nodo Texto:909   */
      /* Termina nodo:908   */

      /* Empieza nodo:910 / Elemento padre: 884   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(910)).setAttribute("colFondo","" );
      ((Element)v.get(910)).setAttribute("ID","EstCab" );
      ((Element)v.get(910)).setAttribute("cod","1176" );
      ((Element)v.get(884)).appendChild((Element)v.get(910));

      /* Elemento padre:910 / Elemento actual: 911   */
      v.add(doc.createTextNode("Período hasta"));
      ((Element)v.get(910)).appendChild((Text)v.get(911));

      /* Termina nodo Texto:911   */
      /* Termina nodo:910   */

      /* Empieza nodo:912 / Elemento padre: 884   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(912)).setAttribute("colFondo","" );
      ((Element)v.get(912)).setAttribute("ID","EstCab" );
      ((Element)v.get(912)).setAttribute("cod","1813" );
      ((Element)v.get(884)).appendChild((Element)v.get(912));

      /* Elemento padre:912 / Elemento actual: 913   */
      v.add(doc.createTextNode("Puntos unidad"));
      ((Element)v.get(912)).appendChild((Text)v.get(913));

      /* Termina nodo Texto:913   */
      /* Termina nodo:912   */

      /* Empieza nodo:914 / Elemento padre: 884   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(914)).setAttribute("colFondo","" );
      ((Element)v.get(914)).setAttribute("ID","EstCab" );
      ((Element)v.get(914)).setAttribute("cod","1814" );
      ((Element)v.get(884)).appendChild((Element)v.get(914));

      /* Elemento padre:914 / Elemento actual: 915   */
      v.add(doc.createTextNode("Factor multiplicidad"));
      ((Element)v.get(914)).appendChild((Text)v.get(915));

      /* Termina nodo Texto:915   */
      /* Termina nodo:914   */

      /* Empieza nodo:916 / Elemento padre: 884   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(916)).setAttribute("colFondo","" );
      ((Element)v.get(916)).setAttribute("ID","EstCab" );
      ((Element)v.get(916)).setAttribute("cod","2448" );
   }

   private void getXML3960(Document doc) {
      ((Element)v.get(884)).appendChild((Element)v.get(916));

      /* Elemento padre:916 / Elemento actual: 917   */
      v.add(doc.createTextNode("oidMarca Producto"));
      ((Element)v.get(916)).appendChild((Text)v.get(917));

      /* Termina nodo Texto:917   */
      /* Termina nodo:916   */

      /* Empieza nodo:918 / Elemento padre: 884   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(918)).setAttribute("colFondo","" );
      ((Element)v.get(918)).setAttribute("ID","EstCab" );
      ((Element)v.get(918)).setAttribute("cod","1338" );
      ((Element)v.get(884)).appendChild((Element)v.get(918));

      /* Elemento padre:918 / Elemento actual: 919   */
      v.add(doc.createTextNode("oidUnidad negocio"));
      ((Element)v.get(918)).appendChild((Text)v.get(919));

      /* Termina nodo Texto:919   */
      /* Termina nodo:918   */

      /* Empieza nodo:920 / Elemento padre: 884   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(920)).setAttribute("colFondo","" );
      ((Element)v.get(920)).setAttribute("ID","EstCab" );
      ((Element)v.get(920)).setAttribute("cod","588" );
      ((Element)v.get(884)).appendChild((Element)v.get(920));

      /* Elemento padre:920 / Elemento actual: 921   */
      v.add(doc.createTextNode("oidNegocio"));
      ((Element)v.get(920)).appendChild((Text)v.get(921));

      /* Termina nodo Texto:921   */
      /* Termina nodo:920   */

      /* Empieza nodo:922 / Elemento padre: 884   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(922)).setAttribute("colFondo","" );
      ((Element)v.get(922)).setAttribute("ID","EstCab" );
      ((Element)v.get(922)).setAttribute("cod","590" );
      ((Element)v.get(884)).appendChild((Element)v.get(922));

      /* Elemento padre:922 / Elemento actual: 923   */
      v.add(doc.createTextNode("oidSupergenérico"));
      ((Element)v.get(922)).appendChild((Text)v.get(923));

      /* Termina nodo Texto:923   */
      /* Termina nodo:922   */

      /* Empieza nodo:924 / Elemento padre: 884   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(924)).setAttribute("colFondo","" );
      ((Element)v.get(924)).setAttribute("ID","EstCab" );
      ((Element)v.get(924)).setAttribute("cod","589" );
      ((Element)v.get(884)).appendChild((Element)v.get(924));

      /* Elemento padre:924 / Elemento actual: 925   */
      v.add(doc.createTextNode("oidGenérico"));
      ((Element)v.get(924)).appendChild((Text)v.get(925));

      /* Termina nodo Texto:925   */
      /* Termina nodo:924   */

      /* Empieza nodo:926 / Elemento padre: 884   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(926)).setAttribute("colFondo","" );
      ((Element)v.get(926)).setAttribute("ID","EstCab" );
      ((Element)v.get(926)).setAttribute("cod","608" );
      ((Element)v.get(884)).appendChild((Element)v.get(926));

      /* Elemento padre:926 / Elemento actual: 927   */
      v.add(doc.createTextNode("oidTipo oferta"));
      ((Element)v.get(926)).appendChild((Text)v.get(927));

      /* Termina nodo Texto:927   */
      /* Termina nodo:926   */

      /* Empieza nodo:928 / Elemento padre: 884   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(928)).setAttribute("colFondo","" );
      ((Element)v.get(928)).setAttribute("ID","EstCab" );
      ((Element)v.get(928)).setAttribute("cod","581" );
      ((Element)v.get(884)).appendChild((Element)v.get(928));

      /* Elemento padre:928 / Elemento actual: 929   */
      v.add(doc.createTextNode("oidCiclo vida"));
      ((Element)v.get(928)).appendChild((Text)v.get(929));

      /* Termina nodo Texto:929   */
      /* Termina nodo:928   */

      /* Empieza nodo:930 / Elemento padre: 884   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(930)).setAttribute("colFondo","" );
      ((Element)v.get(930)).setAttribute("ID","EstCab" );
      ((Element)v.get(930)).setAttribute("cod","337" );
      ((Element)v.get(884)).appendChild((Element)v.get(930));

      /* Elemento padre:930 / Elemento actual: 931   */
      v.add(doc.createTextNode("oidCód. producto"));
      ((Element)v.get(930)).appendChild((Text)v.get(931));

      /* Termina nodo Texto:931   */
      /* Termina nodo:930   */

      /* Empieza nodo:932 / Elemento padre: 884   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(932)).setAttribute("colFondo","" );
      ((Element)v.get(932)).setAttribute("ID","EstCab" );
      ((Element)v.get(932)).setAttribute("cod","608" );
      ((Element)v.get(884)).appendChild((Element)v.get(932));

      /* Elemento padre:932 / Elemento actual: 933   */
      v.add(doc.createTextNode("oidTipo oferta"));
      ((Element)v.get(932)).appendChild((Text)v.get(933));

      /* Termina nodo Texto:933   */
      /* Termina nodo:932   */

      /* Empieza nodo:934 / Elemento padre: 884   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(934)).setAttribute("colFondo","" );
      ((Element)v.get(934)).setAttribute("ID","EstCab" );
      ((Element)v.get(934)).setAttribute("cod","581" );
      ((Element)v.get(884)).appendChild((Element)v.get(934));

      /* Elemento padre:934 / Elemento actual: 935   */
      v.add(doc.createTextNode("oidCiclo vida"));
      ((Element)v.get(934)).appendChild((Text)v.get(935));

      /* Termina nodo Texto:935   */
      /* Termina nodo:934   */

      /* Empieza nodo:936 / Elemento padre: 884   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(936)).setAttribute("colFondo","" );
      ((Element)v.get(936)).setAttribute("ID","EstCab" );
      ((Element)v.get(936)).setAttribute("cod","1175" );
      ((Element)v.get(884)).appendChild((Element)v.get(936));

      /* Elemento padre:936 / Elemento actual: 937   */
      v.add(doc.createTextNode("oidPeríodo desde"));
      ((Element)v.get(936)).appendChild((Text)v.get(937));

      /* Termina nodo Texto:937   */
      /* Termina nodo:936   */

      /* Empieza nodo:938 / Elemento padre: 884   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(938)).setAttribute("colFondo","" );
      ((Element)v.get(938)).setAttribute("ID","EstCab" );
      ((Element)v.get(938)).setAttribute("cod","1176" );
      ((Element)v.get(884)).appendChild((Element)v.get(938));

      /* Elemento padre:938 / Elemento actual: 939   */
      v.add(doc.createTextNode("oidPeríodo hasta"));
      ((Element)v.get(938)).appendChild((Text)v.get(939));

      /* Termina nodo Texto:939   */
      /* Termina nodo:938   */
      /* Termina nodo:884   */

      /* Empieza nodo:940 / Elemento padre: 848   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(940)).setAttribute("alto","22" );
      ((Element)v.get(940)).setAttribute("accion","" );
      ((Element)v.get(940)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(940)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(940)).setAttribute("maxSel","-1" );
      ((Element)v.get(940)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(940)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(940)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(940)).setAttribute("onLoad","" );
   }

   private void getXML4050(Document doc) {
      ((Element)v.get(940)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(848)).appendChild((Element)v.get(940));

      /* Empieza nodo:941 / Elemento padre: 940   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(941)).setAttribute("tipo","texto" );
      ((Element)v.get(941)).setAttribute("ID","EstDat" );
      ((Element)v.get(940)).appendChild((Element)v.get(941));
      /* Termina nodo:941   */

      /* Empieza nodo:942 / Elemento padre: 940   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(942)).setAttribute("tipo","texto" );
      ((Element)v.get(942)).setAttribute("ID","EstDat2" );
      ((Element)v.get(940)).appendChild((Element)v.get(942));
      /* Termina nodo:942   */

      /* Empieza nodo:943 / Elemento padre: 940   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(943)).setAttribute("tipo","texto" );
      ((Element)v.get(943)).setAttribute("ID","EstDat" );
      ((Element)v.get(940)).appendChild((Element)v.get(943));
      /* Termina nodo:943   */

      /* Empieza nodo:944 / Elemento padre: 940   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(944)).setAttribute("tipo","texto" );
      ((Element)v.get(944)).setAttribute("ID","EstDat2" );
      ((Element)v.get(940)).appendChild((Element)v.get(944));
      /* Termina nodo:944   */

      /* Empieza nodo:945 / Elemento padre: 940   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(945)).setAttribute("tipo","texto" );
      ((Element)v.get(945)).setAttribute("ID","EstDat" );
      ((Element)v.get(940)).appendChild((Element)v.get(945));
      /* Termina nodo:945   */

      /* Empieza nodo:946 / Elemento padre: 940   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(946)).setAttribute("tipo","texto" );
      ((Element)v.get(946)).setAttribute("ID","EstDat2" );
      ((Element)v.get(940)).appendChild((Element)v.get(946));
      /* Termina nodo:946   */

      /* Empieza nodo:947 / Elemento padre: 940   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(947)).setAttribute("tipo","texto" );
      ((Element)v.get(947)).setAttribute("ID","EstDat" );
      ((Element)v.get(940)).appendChild((Element)v.get(947));
      /* Termina nodo:947   */

      /* Empieza nodo:948 / Elemento padre: 940   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(948)).setAttribute("tipo","texto" );
      ((Element)v.get(948)).setAttribute("ID","EstDat2" );
      ((Element)v.get(940)).appendChild((Element)v.get(948));
      /* Termina nodo:948   */

      /* Empieza nodo:949 / Elemento padre: 940   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(949)).setAttribute("tipo","texto" );
      ((Element)v.get(949)).setAttribute("ID","EstDat" );
      ((Element)v.get(940)).appendChild((Element)v.get(949));
      /* Termina nodo:949   */

      /* Empieza nodo:950 / Elemento padre: 940   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(950)).setAttribute("tipo","texto" );
      ((Element)v.get(950)).setAttribute("ID","EstDat2" );
      ((Element)v.get(940)).appendChild((Element)v.get(950));
      /* Termina nodo:950   */

      /* Empieza nodo:951 / Elemento padre: 940   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(951)).setAttribute("tipo","texto" );
      ((Element)v.get(951)).setAttribute("ID","EstDat" );
      ((Element)v.get(940)).appendChild((Element)v.get(951));
      /* Termina nodo:951   */

      /* Empieza nodo:952 / Elemento padre: 940   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(952)).setAttribute("tipo","texto" );
      ((Element)v.get(952)).setAttribute("ID","EstDat2" );
      ((Element)v.get(940)).appendChild((Element)v.get(952));
      /* Termina nodo:952   */

      /* Empieza nodo:953 / Elemento padre: 940   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(953)).setAttribute("tipo","texto" );
      ((Element)v.get(953)).setAttribute("ID","EstDat" );
      ((Element)v.get(940)).appendChild((Element)v.get(953));
      /* Termina nodo:953   */

      /* Empieza nodo:954 / Elemento padre: 940   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(954)).setAttribute("tipo","texto" );
      ((Element)v.get(954)).setAttribute("ID","EstDat2" );
      ((Element)v.get(940)).appendChild((Element)v.get(954));
      /* Termina nodo:954   */

      /* Empieza nodo:955 / Elemento padre: 940   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(955)).setAttribute("tipo","texto" );
      ((Element)v.get(955)).setAttribute("ID","EstDat" );
      ((Element)v.get(940)).appendChild((Element)v.get(955));
      /* Termina nodo:955   */

      /* Empieza nodo:956 / Elemento padre: 940   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(956)).setAttribute("tipo","texto" );
      ((Element)v.get(956)).setAttribute("ID","EstDat2" );
      ((Element)v.get(940)).appendChild((Element)v.get(956));
      /* Termina nodo:956   */

      /* Empieza nodo:957 / Elemento padre: 940   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(957)).setAttribute("tipo","texto" );
      ((Element)v.get(957)).setAttribute("ID","EstDat" );
      ((Element)v.get(940)).appendChild((Element)v.get(957));
      /* Termina nodo:957   */

      /* Empieza nodo:958 / Elemento padre: 940   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(958)).setAttribute("tipo","texto" );
      ((Element)v.get(958)).setAttribute("ID","EstDat2" );
      ((Element)v.get(940)).appendChild((Element)v.get(958));
      /* Termina nodo:958   */

      /* Empieza nodo:959 / Elemento padre: 940   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(959)).setAttribute("tipo","texto" );
      ((Element)v.get(959)).setAttribute("ID","EstDat" );
      ((Element)v.get(940)).appendChild((Element)v.get(959));
      /* Termina nodo:959   */

      /* Empieza nodo:960 / Elemento padre: 940   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(960)).setAttribute("tipo","texto" );
      ((Element)v.get(960)).setAttribute("ID","EstDat2" );
      ((Element)v.get(940)).appendChild((Element)v.get(960));
      /* Termina nodo:960   */

      /* Empieza nodo:961 / Elemento padre: 940   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(961)).setAttribute("tipo","texto" );
      ((Element)v.get(961)).setAttribute("ID","EstDat" );
      ((Element)v.get(940)).appendChild((Element)v.get(961));
      /* Termina nodo:961   */

      /* Empieza nodo:962 / Elemento padre: 940   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(962)).setAttribute("tipo","texto" );
      ((Element)v.get(962)).setAttribute("ID","EstDat2" );
      ((Element)v.get(940)).appendChild((Element)v.get(962));
      /* Termina nodo:962   */

      /* Empieza nodo:963 / Elemento padre: 940   */
   }

   private void getXML4140(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(963)).setAttribute("tipo","texto" );
      ((Element)v.get(963)).setAttribute("ID","EstDat" );
      ((Element)v.get(940)).appendChild((Element)v.get(963));
      /* Termina nodo:963   */

      /* Empieza nodo:964 / Elemento padre: 940   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(964)).setAttribute("tipo","texto" );
      ((Element)v.get(964)).setAttribute("ID","EstDat2" );
      ((Element)v.get(940)).appendChild((Element)v.get(964));
      /* Termina nodo:964   */

      /* Empieza nodo:965 / Elemento padre: 940   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(965)).setAttribute("tipo","texto" );
      ((Element)v.get(965)).setAttribute("ID","EstDat" );
      ((Element)v.get(940)).appendChild((Element)v.get(965));
      /* Termina nodo:965   */

      /* Empieza nodo:966 / Elemento padre: 940   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(966)).setAttribute("tipo","texto" );
      ((Element)v.get(966)).setAttribute("ID","EstDat2" );
      ((Element)v.get(940)).appendChild((Element)v.get(966));
      /* Termina nodo:966   */
      /* Termina nodo:940   */

      /* Empieza nodo:967 / Elemento padre: 848   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(848)).appendChild((Element)v.get(967));
      /* Termina nodo:967   */

      /* Empieza nodo:968 / Elemento padre: 848   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(968)).setAttribute("nombre","mipgndo3" );
      ((Element)v.get(968)).setAttribute("ancho","504" );
      ((Element)v.get(968)).setAttribute("sep","$" );
      ((Element)v.get(968)).setAttribute("x","12" );
      ((Element)v.get(968)).setAttribute("class","botonera" );
      ((Element)v.get(968)).setAttribute("y","753" );
      ((Element)v.get(968)).setAttribute("control","|" );
      ((Element)v.get(968)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(968)).setAttribute("rowset","" );
      ((Element)v.get(968)).setAttribute("cargainicial","N" );
      ((Element)v.get(848)).appendChild((Element)v.get(968));

      /* Empieza nodo:969 / Elemento padre: 968   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(969)).setAttribute("nombre","ret3" );
      ((Element)v.get(969)).setAttribute("x","37" );
      ((Element)v.get(969)).setAttribute("y","757" );
      ((Element)v.get(969)).setAttribute("ID","botonContenido" );
      ((Element)v.get(969)).setAttribute("img","retroceder_on" );
      ((Element)v.get(969)).setAttribute("tipo","0" );
      ((Element)v.get(969)).setAttribute("estado","false" );
      ((Element)v.get(969)).setAttribute("alt","" );
      ((Element)v.get(969)).setAttribute("codigo","" );
      ((Element)v.get(969)).setAttribute("accion","mipgndo3.retroceder();" );
      ((Element)v.get(968)).appendChild((Element)v.get(969));
      /* Termina nodo:969   */

      /* Empieza nodo:970 / Elemento padre: 968   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(970)).setAttribute("nombre","ava3" );
      ((Element)v.get(970)).setAttribute("x","52" );
      ((Element)v.get(970)).setAttribute("y","757" );
      ((Element)v.get(970)).setAttribute("ID","botonContenido" );
      ((Element)v.get(970)).setAttribute("img","avanzar_on" );
      ((Element)v.get(970)).setAttribute("tipo","0" );
      ((Element)v.get(970)).setAttribute("estado","false" );
      ((Element)v.get(970)).setAttribute("alt","" );
      ((Element)v.get(970)).setAttribute("codigo","" );
      ((Element)v.get(970)).setAttribute("accion","mipgndo3.avanzar();" );
      ((Element)v.get(968)).appendChild((Element)v.get(970));
      /* Termina nodo:970   */
      /* Termina nodo:968   */
      /* Termina nodo:848   */

      /* Empieza nodo:971 / Elemento padre: 27   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(971)).setAttribute("nombre","primera3" );
      ((Element)v.get(971)).setAttribute("x","20" );
      ((Element)v.get(971)).setAttribute("y","757" );
      ((Element)v.get(971)).setAttribute("ID","botonContenido" );
      ((Element)v.get(971)).setAttribute("img","primera_on" );
      ((Element)v.get(971)).setAttribute("tipo","0" );
      ((Element)v.get(971)).setAttribute("estado","false" );
      ((Element)v.get(971)).setAttribute("alt","" );
      ((Element)v.get(971)).setAttribute("codigo","" );
      ((Element)v.get(971)).setAttribute("accion","mipgndo3.retrocederPrimeraPagina();" );
      ((Element)v.get(27)).appendChild((Element)v.get(971));
      /* Termina nodo:971   */

      /* Empieza nodo:972 / Elemento padre: 27   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(972)).setAttribute("nombre","separa3" );
      ((Element)v.get(972)).setAttribute("x","59" );
      ((Element)v.get(972)).setAttribute("y","753" );
      ((Element)v.get(972)).setAttribute("ID","botonContenido" );
      ((Element)v.get(972)).setAttribute("img","separa_base" );
      ((Element)v.get(972)).setAttribute("tipo","0" );
      ((Element)v.get(972)).setAttribute("estado","false" );
      ((Element)v.get(972)).setAttribute("alt","" );
      ((Element)v.get(972)).setAttribute("codigo","" );
      ((Element)v.get(972)).setAttribute("accion","" );
      ((Element)v.get(27)).appendChild((Element)v.get(972));
      /* Termina nodo:972   */

      /* Empieza nodo:973 / Elemento padre: 27   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(973)).setAttribute("nombre","listado4" );
      ((Element)v.get(973)).setAttribute("ancho","632" );
      ((Element)v.get(973)).setAttribute("alto","315" );
      ((Element)v.get(973)).setAttribute("x","12" );
      ((Element)v.get(973)).setAttribute("y","439" );
      ((Element)v.get(973)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(973)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(27)).appendChild((Element)v.get(973));

      /* Empieza nodo:974 / Elemento padre: 973   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(974)).setAttribute("precarga","S" );
      ((Element)v.get(974)).setAttribute("conROver","S" );
   }

   private void getXML4230(Document doc) {
      ((Element)v.get(973)).appendChild((Element)v.get(974));

      /* Empieza nodo:975 / Elemento padre: 974   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(975)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(975)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(975)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(975)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(974)).appendChild((Element)v.get(975));
      /* Termina nodo:975   */

      /* Empieza nodo:976 / Elemento padre: 974   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(976)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(976)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(976)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(976)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(974)).appendChild((Element)v.get(976));
      /* Termina nodo:976   */

      /* Empieza nodo:977 / Elemento padre: 974   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(977)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(977)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(974)).appendChild((Element)v.get(977));
      /* Termina nodo:977   */
      /* Termina nodo:974   */

      /* Empieza nodo:978 / Elemento padre: 973   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(973)).appendChild((Element)v.get(978));

      /* Empieza nodo:979 / Elemento padre: 978   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(979)).setAttribute("borde","1" );
      ((Element)v.get(979)).setAttribute("horizDatos","1" );
      ((Element)v.get(979)).setAttribute("horizCabecera","1" );
      ((Element)v.get(979)).setAttribute("vertical","1" );
      ((Element)v.get(979)).setAttribute("horizTitulo","1" );
      ((Element)v.get(979)).setAttribute("horizBase","1" );
      ((Element)v.get(978)).appendChild((Element)v.get(979));
      /* Termina nodo:979   */

      /* Empieza nodo:980 / Elemento padre: 978   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(980)).setAttribute("borde","#999999" );
      ((Element)v.get(980)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(980)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(980)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(980)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(980)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(980)).setAttribute("horizBase","#999999" );
      ((Element)v.get(978)).appendChild((Element)v.get(980));
      /* Termina nodo:980   */
      /* Termina nodo:978   */

      /* Empieza nodo:981 / Elemento padre: 973   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(981)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(981)).setAttribute("alto","22" );
      ((Element)v.get(981)).setAttribute("imgFondo","" );
      ((Element)v.get(981)).setAttribute("cod","00341" );
      ((Element)v.get(981)).setAttribute("ID","datosTitle" );
      ((Element)v.get(973)).appendChild((Element)v.get(981));
      /* Termina nodo:981   */

      /* Empieza nodo:982 / Elemento padre: 973   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(982)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(982)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(982)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(982)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(982)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(982)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(973)).appendChild((Element)v.get(982));

      /* Empieza nodo:983 / Elemento padre: 982   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(983)).setAttribute("ancho","150" );
      ((Element)v.get(983)).setAttribute("minimizable","S" );
      ((Element)v.get(983)).setAttribute("minimizada","N" );
      ((Element)v.get(982)).appendChild((Element)v.get(983));
      /* Termina nodo:983   */

      /* Empieza nodo:984 / Elemento padre: 982   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(984)).setAttribute("ancho","150" );
      ((Element)v.get(984)).setAttribute("minimizable","S" );
      ((Element)v.get(984)).setAttribute("minimizada","N" );
      ((Element)v.get(982)).appendChild((Element)v.get(984));
      /* Termina nodo:984   */

      /* Empieza nodo:985 / Elemento padre: 982   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(985)).setAttribute("ancho","150" );
      ((Element)v.get(985)).setAttribute("minimizable","S" );
      ((Element)v.get(985)).setAttribute("minimizada","N" );
      ((Element)v.get(982)).appendChild((Element)v.get(985));
      /* Termina nodo:985   */

      /* Empieza nodo:986 / Elemento padre: 982   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(986)).setAttribute("ancho","150" );
      ((Element)v.get(986)).setAttribute("minimizable","S" );
      ((Element)v.get(986)).setAttribute("minimizada","N" );
      ((Element)v.get(982)).appendChild((Element)v.get(986));
      /* Termina nodo:986   */

      /* Empieza nodo:987 / Elemento padre: 982   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(987)).setAttribute("ancho","150" );
      ((Element)v.get(987)).setAttribute("minimizable","S" );
      ((Element)v.get(987)).setAttribute("minimizada","N" );
      ((Element)v.get(982)).appendChild((Element)v.get(987));
      /* Termina nodo:987   */

      /* Empieza nodo:988 / Elemento padre: 982   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(988)).setAttribute("ancho","150" );
      ((Element)v.get(988)).setAttribute("minimizable","S" );
      ((Element)v.get(988)).setAttribute("minimizada","N" );
      ((Element)v.get(982)).appendChild((Element)v.get(988));
      /* Termina nodo:988   */

      /* Empieza nodo:989 / Elemento padre: 982   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(989)).setAttribute("ancho","150" );
      ((Element)v.get(989)).setAttribute("minimizable","S" );
      ((Element)v.get(989)).setAttribute("minimizada","N" );
      ((Element)v.get(982)).appendChild((Element)v.get(989));
      /* Termina nodo:989   */

      /* Empieza nodo:990 / Elemento padre: 982   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(990)).setAttribute("ancho","150" );
      ((Element)v.get(990)).setAttribute("minimizable","S" );
      ((Element)v.get(990)).setAttribute("minimizada","N" );
   }

   private void getXML4320(Document doc) {
      ((Element)v.get(982)).appendChild((Element)v.get(990));
      /* Termina nodo:990   */

      /* Empieza nodo:991 / Elemento padre: 982   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(991)).setAttribute("ancho","150" );
      ((Element)v.get(991)).setAttribute("minimizable","S" );
      ((Element)v.get(991)).setAttribute("minimizada","N" );
      ((Element)v.get(982)).appendChild((Element)v.get(991));
      /* Termina nodo:991   */

      /* Empieza nodo:992 / Elemento padre: 982   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(992)).setAttribute("ancho","150" );
      ((Element)v.get(992)).setAttribute("minimizable","S" );
      ((Element)v.get(992)).setAttribute("minimizada","N" );
      ((Element)v.get(982)).appendChild((Element)v.get(992));
      /* Termina nodo:992   */

      /* Empieza nodo:993 / Elemento padre: 982   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(993)).setAttribute("ancho","150" );
      ((Element)v.get(993)).setAttribute("minimizable","S" );
      ((Element)v.get(993)).setAttribute("minimizada","N" );
      ((Element)v.get(982)).appendChild((Element)v.get(993));
      /* Termina nodo:993   */

      /* Empieza nodo:994 / Elemento padre: 982   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(994)).setAttribute("ancho","150" );
      ((Element)v.get(994)).setAttribute("minimizable","S" );
      ((Element)v.get(994)).setAttribute("minimizada","N" );
      ((Element)v.get(982)).appendChild((Element)v.get(994));
      /* Termina nodo:994   */

      /* Empieza nodo:995 / Elemento padre: 982   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(995)).setAttribute("ancho","150" );
      ((Element)v.get(995)).setAttribute("minimizable","S" );
      ((Element)v.get(995)).setAttribute("minimizada","N" );
      ((Element)v.get(982)).appendChild((Element)v.get(995));
      /* Termina nodo:995   */

      /* Empieza nodo:996 / Elemento padre: 982   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(996)).setAttribute("ancho","150" );
      ((Element)v.get(996)).setAttribute("minimizable","S" );
      ((Element)v.get(996)).setAttribute("minimizada","N" );
      ((Element)v.get(982)).appendChild((Element)v.get(996));
      /* Termina nodo:996   */

      /* Empieza nodo:997 / Elemento padre: 982   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(997)).setAttribute("ancho","150" );
      ((Element)v.get(997)).setAttribute("minimizable","S" );
      ((Element)v.get(997)).setAttribute("minimizada","N" );
      ((Element)v.get(982)).appendChild((Element)v.get(997));
      /* Termina nodo:997   */

      /* Empieza nodo:998 / Elemento padre: 982   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(998)).setAttribute("ancho","150" );
      ((Element)v.get(998)).setAttribute("minimizable","S" );
      ((Element)v.get(998)).setAttribute("minimizada","N" );
      ((Element)v.get(982)).appendChild((Element)v.get(998));
      /* Termina nodo:998   */

      /* Empieza nodo:999 / Elemento padre: 982   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(999)).setAttribute("ancho","150" );
      ((Element)v.get(999)).setAttribute("minimizable","S" );
      ((Element)v.get(999)).setAttribute("minimizada","N" );
      ((Element)v.get(999)).setAttribute("oculta","S" );
      ((Element)v.get(982)).appendChild((Element)v.get(999));
      /* Termina nodo:999   */

      /* Empieza nodo:1000 / Elemento padre: 982   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1000)).setAttribute("ancho","150" );
      ((Element)v.get(1000)).setAttribute("minimizable","S" );
      ((Element)v.get(1000)).setAttribute("minimizada","N" );
      ((Element)v.get(1000)).setAttribute("oculta","S" );
      ((Element)v.get(982)).appendChild((Element)v.get(1000));
      /* Termina nodo:1000   */

      /* Empieza nodo:1001 / Elemento padre: 982   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1001)).setAttribute("ancho","150" );
      ((Element)v.get(1001)).setAttribute("minimizable","S" );
      ((Element)v.get(1001)).setAttribute("minimizada","N" );
      ((Element)v.get(1001)).setAttribute("oculta","S" );
      ((Element)v.get(982)).appendChild((Element)v.get(1001));
      /* Termina nodo:1001   */

      /* Empieza nodo:1002 / Elemento padre: 982   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1002)).setAttribute("ancho","150" );
      ((Element)v.get(1002)).setAttribute("minimizable","S" );
      ((Element)v.get(1002)).setAttribute("minimizada","N" );
      ((Element)v.get(1002)).setAttribute("oculta","S" );
      ((Element)v.get(982)).appendChild((Element)v.get(1002));
      /* Termina nodo:1002   */

      /* Empieza nodo:1003 / Elemento padre: 982   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1003)).setAttribute("ancho","150" );
      ((Element)v.get(1003)).setAttribute("minimizable","S" );
      ((Element)v.get(1003)).setAttribute("minimizada","N" );
      ((Element)v.get(1003)).setAttribute("oculta","S" );
      ((Element)v.get(982)).appendChild((Element)v.get(1003));
      /* Termina nodo:1003   */

      /* Empieza nodo:1004 / Elemento padre: 982   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1004)).setAttribute("ancho","150" );
      ((Element)v.get(1004)).setAttribute("minimizable","S" );
      ((Element)v.get(1004)).setAttribute("minimizada","N" );
      ((Element)v.get(1004)).setAttribute("oculta","S" );
      ((Element)v.get(982)).appendChild((Element)v.get(1004));
      /* Termina nodo:1004   */

      /* Empieza nodo:1005 / Elemento padre: 982   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1005)).setAttribute("ancho","150" );
      ((Element)v.get(1005)).setAttribute("minimizable","S" );
      ((Element)v.get(1005)).setAttribute("minimizada","N" );
      ((Element)v.get(1005)).setAttribute("oculta","S" );
      ((Element)v.get(982)).appendChild((Element)v.get(1005));
      /* Termina nodo:1005   */

      /* Empieza nodo:1006 / Elemento padre: 982   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1006)).setAttribute("ancho","150" );
      ((Element)v.get(1006)).setAttribute("minimizable","S" );
      ((Element)v.get(1006)).setAttribute("minimizada","N" );
      ((Element)v.get(1006)).setAttribute("oculta","S" );
      ((Element)v.get(982)).appendChild((Element)v.get(1006));
      /* Termina nodo:1006   */

      /* Empieza nodo:1007 / Elemento padre: 982   */
      v.add(doc.createElement("COL"));
   }

   private void getXML4410(Document doc) {
      ((Element)v.get(1007)).setAttribute("ancho","150" );
      ((Element)v.get(1007)).setAttribute("minimizable","S" );
      ((Element)v.get(1007)).setAttribute("minimizada","N" );
      ((Element)v.get(1007)).setAttribute("oculta","S" );
      ((Element)v.get(982)).appendChild((Element)v.get(1007));
      /* Termina nodo:1007   */

      /* Empieza nodo:1008 / Elemento padre: 982   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1008)).setAttribute("ancho","150" );
      ((Element)v.get(1008)).setAttribute("minimizable","S" );
      ((Element)v.get(1008)).setAttribute("minimizada","N" );
      ((Element)v.get(1008)).setAttribute("oculta","S" );
      ((Element)v.get(982)).appendChild((Element)v.get(1008));
      /* Termina nodo:1008   */

      /* Empieza nodo:1009 / Elemento padre: 982   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1009)).setAttribute("ancho","150" );
      ((Element)v.get(1009)).setAttribute("minimizable","S" );
      ((Element)v.get(1009)).setAttribute("minimizada","N" );
      ((Element)v.get(1009)).setAttribute("oculta","S" );
      ((Element)v.get(982)).appendChild((Element)v.get(1009));
      /* Termina nodo:1009   */

      /* Empieza nodo:1010 / Elemento padre: 982   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1010)).setAttribute("ancho","150" );
      ((Element)v.get(1010)).setAttribute("minimizable","S" );
      ((Element)v.get(1010)).setAttribute("minimizada","N" );
      ((Element)v.get(1010)).setAttribute("oculta","S" );
      ((Element)v.get(982)).appendChild((Element)v.get(1010));
      /* Termina nodo:1010   */

      /* Empieza nodo:1011 / Elemento padre: 982   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1011)).setAttribute("ancho","150" );
      ((Element)v.get(1011)).setAttribute("minimizable","S" );
      ((Element)v.get(1011)).setAttribute("minimizada","N" );
      ((Element)v.get(1011)).setAttribute("oculta","S" );
      ((Element)v.get(982)).appendChild((Element)v.get(1011));
      /* Termina nodo:1011   */
      /* Termina nodo:982   */

      /* Empieza nodo:1012 / Elemento padre: 973   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(1012)).setAttribute("alto","40" );
      ((Element)v.get(1012)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(1012)).setAttribute("imgFondo","" );
      ((Element)v.get(1012)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(1012)).setAttribute("ajustarAMitadInf","S" );
      ((Element)v.get(973)).appendChild((Element)v.get(1012));

      /* Empieza nodo:1013 / Elemento padre: 1012   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(1013)).setAttribute("colFondo","" );
      ((Element)v.get(1013)).setAttribute("ID","EstCab" );
      ((Element)v.get(1013)).setAttribute("cod","00335" );
      ((Element)v.get(1012)).appendChild((Element)v.get(1013));

      /* Empieza nodo:1014 / Elemento padre: 1013   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1014)).setAttribute("colFondo","" );
      ((Element)v.get(1014)).setAttribute("ID","EstCab" );
      ((Element)v.get(1014)).setAttribute("cod","2448" );
      ((Element)v.get(1013)).appendChild((Element)v.get(1014));

      /* Elemento padre:1014 / Elemento actual: 1015   */
      v.add(doc.createTextNode("Marca producto"));
      ((Element)v.get(1014)).appendChild((Text)v.get(1015));

      /* Termina nodo Texto:1015   */
      /* Termina nodo:1014   */

      /* Empieza nodo:1016 / Elemento padre: 1013   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1016)).setAttribute("colFondo","" );
      ((Element)v.get(1016)).setAttribute("ID","EstCab" );
      ((Element)v.get(1016)).setAttribute("cod","1338" );
      ((Element)v.get(1013)).appendChild((Element)v.get(1016));

      /* Elemento padre:1016 / Elemento actual: 1017   */
      v.add(doc.createTextNode("Unidad negocio"));
      ((Element)v.get(1016)).appendChild((Text)v.get(1017));

      /* Termina nodo Texto:1017   */
      /* Termina nodo:1016   */

      /* Empieza nodo:1018 / Elemento padre: 1013   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1018)).setAttribute("colFondo","" );
      ((Element)v.get(1018)).setAttribute("ID","EstCab" );
      ((Element)v.get(1018)).setAttribute("cod","588" );
      ((Element)v.get(1013)).appendChild((Element)v.get(1018));

      /* Elemento padre:1018 / Elemento actual: 1019   */
      v.add(doc.createTextNode("Negocio"));
      ((Element)v.get(1018)).appendChild((Text)v.get(1019));

      /* Termina nodo Texto:1019   */
      /* Termina nodo:1018   */

      /* Empieza nodo:1020 / Elemento padre: 1013   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1020)).setAttribute("colFondo","" );
      ((Element)v.get(1020)).setAttribute("ID","EstCab" );
      ((Element)v.get(1020)).setAttribute("cod","590" );
      ((Element)v.get(1013)).appendChild((Element)v.get(1020));

      /* Elemento padre:1020 / Elemento actual: 1021   */
      v.add(doc.createTextNode("Supergenérico"));
      ((Element)v.get(1020)).appendChild((Text)v.get(1021));

      /* Termina nodo Texto:1021   */
      /* Termina nodo:1020   */

      /* Empieza nodo:1022 / Elemento padre: 1013   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1022)).setAttribute("colFondo","" );
      ((Element)v.get(1022)).setAttribute("ID","EstCab" );
      ((Element)v.get(1022)).setAttribute("cod","589" );
      ((Element)v.get(1013)).appendChild((Element)v.get(1022));

      /* Elemento padre:1022 / Elemento actual: 1023   */
      v.add(doc.createTextNode("Genérico"));
      ((Element)v.get(1022)).appendChild((Text)v.get(1023));

      /* Termina nodo Texto:1023   */
      /* Termina nodo:1022   */
      /* Termina nodo:1013   */

      /* Empieza nodo:1024 / Elemento padre: 1012   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(1024)).setAttribute("colFondo","" );
      ((Element)v.get(1024)).setAttribute("ID","EstCab" );
      ((Element)v.get(1024)).setAttribute("cod","00336" );
      ((Element)v.get(1012)).appendChild((Element)v.get(1024));

      /* Empieza nodo:1025 / Elemento padre: 1024   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1025)).setAttribute("colFondo","" );
      ((Element)v.get(1025)).setAttribute("ID","EstCab" );
      ((Element)v.get(1025)).setAttribute("cod","608" );
      ((Element)v.get(1024)).appendChild((Element)v.get(1025));

      /* Elemento padre:1025 / Elemento actual: 1026   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(1025)).appendChild((Text)v.get(1026));

      /* Termina nodo Texto:1026   */
      /* Termina nodo:1025   */

      /* Empieza nodo:1027 / Elemento padre: 1024   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1027)).setAttribute("colFondo","" );
   }

   private void getXML4500(Document doc) {
      ((Element)v.get(1027)).setAttribute("ID","EstCab" );
      ((Element)v.get(1027)).setAttribute("cod","581" );
      ((Element)v.get(1024)).appendChild((Element)v.get(1027));

      /* Elemento padre:1027 / Elemento actual: 1028   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(1027)).appendChild((Text)v.get(1028));

      /* Termina nodo Texto:1028   */
      /* Termina nodo:1027   */
      /* Termina nodo:1024   */

      /* Empieza nodo:1029 / Elemento padre: 1012   */
      v.add(doc.createElement("GRUPO"));
      ((Element)v.get(1029)).setAttribute("colFondo","" );
      ((Element)v.get(1029)).setAttribute("ID","EstCab" );
      ((Element)v.get(1029)).setAttribute("cod","00337" );
      ((Element)v.get(1012)).appendChild((Element)v.get(1029));

      /* Empieza nodo:1030 / Elemento padre: 1029   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1030)).setAttribute("colFondo","" );
      ((Element)v.get(1030)).setAttribute("ID","EstCab" );
      ((Element)v.get(1030)).setAttribute("cod","337" );
      ((Element)v.get(1029)).appendChild((Element)v.get(1030));

      /* Elemento padre:1030 / Elemento actual: 1031   */
      v.add(doc.createTextNode("Cód. producto"));
      ((Element)v.get(1030)).appendChild((Text)v.get(1031));

      /* Termina nodo Texto:1031   */
      /* Termina nodo:1030   */

      /* Empieza nodo:1032 / Elemento padre: 1029   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1032)).setAttribute("colFondo","" );
      ((Element)v.get(1032)).setAttribute("ID","EstCab" );
      ((Element)v.get(1032)).setAttribute("cod","608" );
      ((Element)v.get(1029)).appendChild((Element)v.get(1032));

      /* Elemento padre:1032 / Elemento actual: 1033   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(1032)).appendChild((Text)v.get(1033));

      /* Termina nodo Texto:1033   */
      /* Termina nodo:1032   */

      /* Empieza nodo:1034 / Elemento padre: 1029   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1034)).setAttribute("colFondo","" );
      ((Element)v.get(1034)).setAttribute("ID","EstCab" );
      ((Element)v.get(1034)).setAttribute("cod","581" );
      ((Element)v.get(1029)).appendChild((Element)v.get(1034));

      /* Elemento padre:1034 / Elemento actual: 1035   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(1034)).appendChild((Text)v.get(1035));

      /* Termina nodo Texto:1035   */
      /* Termina nodo:1034   */

      /* Empieza nodo:1036 / Elemento padre: 1029   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1036)).setAttribute("colFondo","" );
      ((Element)v.get(1036)).setAttribute("ID","EstCab" );
      ((Element)v.get(1036)).setAttribute("cod","3401" );
      ((Element)v.get(1029)).appendChild((Element)v.get(1036));

      /* Elemento padre:1036 / Elemento actual: 1037   */
      v.add(doc.createTextNode("Ind Agrupacion"));
      ((Element)v.get(1036)).appendChild((Text)v.get(1037));

      /* Termina nodo Texto:1037   */
      /* Termina nodo:1036   */
      /* Termina nodo:1029   */

      /* Empieza nodo:1038 / Elemento padre: 1012   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1038)).setAttribute("colFondo","" );
      ((Element)v.get(1038)).setAttribute("ID","EstCab" );
      ((Element)v.get(1038)).setAttribute("cod","1175" );
      ((Element)v.get(1012)).appendChild((Element)v.get(1038));

      /* Elemento padre:1038 / Elemento actual: 1039   */
      v.add(doc.createTextNode("Período desde"));
      ((Element)v.get(1038)).appendChild((Text)v.get(1039));

      /* Termina nodo Texto:1039   */
      /* Termina nodo:1038   */

      /* Empieza nodo:1040 / Elemento padre: 1012   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1040)).setAttribute("colFondo","" );
      ((Element)v.get(1040)).setAttribute("ID","EstCab" );
      ((Element)v.get(1040)).setAttribute("cod","1176" );
      ((Element)v.get(1012)).appendChild((Element)v.get(1040));

      /* Elemento padre:1040 / Elemento actual: 1041   */
      v.add(doc.createTextNode("Período hasta"));
      ((Element)v.get(1040)).appendChild((Text)v.get(1041));

      /* Termina nodo Texto:1041   */
      /* Termina nodo:1040   */

      /* Empieza nodo:1042 / Elemento padre: 1012   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1042)).setAttribute("colFondo","" );
      ((Element)v.get(1042)).setAttribute("ID","EstCab" );
      ((Element)v.get(1042)).setAttribute("cod","1815" );
      ((Element)v.get(1012)).appendChild((Element)v.get(1042));

      /* Elemento padre:1042 / Elemento actual: 1043   */
      v.add(doc.createTextNode("Unidades exigidas"));
      ((Element)v.get(1042)).appendChild((Text)v.get(1043));

      /* Termina nodo Texto:1043   */
      /* Termina nodo:1042   */

      /* Empieza nodo:1044 / Elemento padre: 1012   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1044)).setAttribute("colFondo","" );
      ((Element)v.get(1044)).setAttribute("ID","EstCab" );
      ((Element)v.get(1044)).setAttribute("cod","1816" );
      ((Element)v.get(1012)).appendChild((Element)v.get(1044));

      /* Elemento padre:1044 / Elemento actual: 1045   */
      v.add(doc.createTextNode("Monto exigido"));
      ((Element)v.get(1044)).appendChild((Text)v.get(1045));

      /* Termina nodo Texto:1045   */
      /* Termina nodo:1044   */

      /* Empieza nodo:1046 / Elemento padre: 1012   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1046)).setAttribute("colFondo","" );
      ((Element)v.get(1046)).setAttribute("ID","EstCab" );
      ((Element)v.get(1046)).setAttribute("cod","1817" );
      ((Element)v.get(1012)).appendChild((Element)v.get(1046));

      /* Elemento padre:1046 / Elemento actual: 1047   */
      v.add(doc.createTextNode("Puntos exigidos"));
      ((Element)v.get(1046)).appendChild((Text)v.get(1047));

      /* Termina nodo Texto:1047   */
      /* Termina nodo:1046   */

      /* Empieza nodo:1048 / Elemento padre: 1012   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1048)).setAttribute("colFondo","" );
      ((Element)v.get(1048)).setAttribute("ID","EstCab" );
      ((Element)v.get(1048)).setAttribute("cod","2448" );
      ((Element)v.get(1012)).appendChild((Element)v.get(1048));

      /* Elemento padre:1048 / Elemento actual: 1049   */
      v.add(doc.createTextNode("oidMarca producto"));
      ((Element)v.get(1048)).appendChild((Text)v.get(1049));

      /* Termina nodo Texto:1049   */
      /* Termina nodo:1048   */

      /* Empieza nodo:1050 / Elemento padre: 1012   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1050)).setAttribute("colFondo","" );
      ((Element)v.get(1050)).setAttribute("ID","EstCab" );
      ((Element)v.get(1050)).setAttribute("cod","1338" );
      ((Element)v.get(1012)).appendChild((Element)v.get(1050));

      /* Elemento padre:1050 / Elemento actual: 1051   */
      v.add(doc.createTextNode("oidUnidad negocio"));
      ((Element)v.get(1050)).appendChild((Text)v.get(1051));

      /* Termina nodo Texto:1051   */
      /* Termina nodo:1050   */

      /* Empieza nodo:1052 / Elemento padre: 1012   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1052)).setAttribute("colFondo","" );
      ((Element)v.get(1052)).setAttribute("ID","EstCab" );
   }

   private void getXML4590(Document doc) {
      ((Element)v.get(1052)).setAttribute("cod","588" );
      ((Element)v.get(1012)).appendChild((Element)v.get(1052));

      /* Elemento padre:1052 / Elemento actual: 1053   */
      v.add(doc.createTextNode("oidNegocio"));
      ((Element)v.get(1052)).appendChild((Text)v.get(1053));

      /* Termina nodo Texto:1053   */
      /* Termina nodo:1052   */

      /* Empieza nodo:1054 / Elemento padre: 1012   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1054)).setAttribute("colFondo","" );
      ((Element)v.get(1054)).setAttribute("ID","EstCab" );
      ((Element)v.get(1054)).setAttribute("cod","590" );
      ((Element)v.get(1012)).appendChild((Element)v.get(1054));

      /* Elemento padre:1054 / Elemento actual: 1055   */
      v.add(doc.createTextNode("oidSupergenérico"));
      ((Element)v.get(1054)).appendChild((Text)v.get(1055));

      /* Termina nodo Texto:1055   */
      /* Termina nodo:1054   */

      /* Empieza nodo:1056 / Elemento padre: 1012   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1056)).setAttribute("colFondo","" );
      ((Element)v.get(1056)).setAttribute("ID","EstCab" );
      ((Element)v.get(1056)).setAttribute("cod","589" );
      ((Element)v.get(1012)).appendChild((Element)v.get(1056));

      /* Elemento padre:1056 / Elemento actual: 1057   */
      v.add(doc.createTextNode("oidGenérico"));
      ((Element)v.get(1056)).appendChild((Text)v.get(1057));

      /* Termina nodo Texto:1057   */
      /* Termina nodo:1056   */

      /* Empieza nodo:1058 / Elemento padre: 1012   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1058)).setAttribute("colFondo","" );
      ((Element)v.get(1058)).setAttribute("ID","EstCab" );
      ((Element)v.get(1058)).setAttribute("cod","608" );
      ((Element)v.get(1012)).appendChild((Element)v.get(1058));

      /* Elemento padre:1058 / Elemento actual: 1059   */
      v.add(doc.createTextNode("oidTipo oferta"));
      ((Element)v.get(1058)).appendChild((Text)v.get(1059));

      /* Termina nodo Texto:1059   */
      /* Termina nodo:1058   */

      /* Empieza nodo:1060 / Elemento padre: 1012   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1060)).setAttribute("colFondo","" );
      ((Element)v.get(1060)).setAttribute("ID","EstCab" );
      ((Element)v.get(1060)).setAttribute("cod","581" );
      ((Element)v.get(1012)).appendChild((Element)v.get(1060));

      /* Elemento padre:1060 / Elemento actual: 1061   */
      v.add(doc.createTextNode("oidCiclo vida"));
      ((Element)v.get(1060)).appendChild((Text)v.get(1061));

      /* Termina nodo Texto:1061   */
      /* Termina nodo:1060   */

      /* Empieza nodo:1062 / Elemento padre: 1012   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1062)).setAttribute("colFondo","" );
      ((Element)v.get(1062)).setAttribute("ID","EstCab" );
      ((Element)v.get(1062)).setAttribute("cod","337" );
      ((Element)v.get(1012)).appendChild((Element)v.get(1062));

      /* Elemento padre:1062 / Elemento actual: 1063   */
      v.add(doc.createTextNode("Cód. producto"));
      ((Element)v.get(1062)).appendChild((Text)v.get(1063));

      /* Termina nodo Texto:1063   */
      /* Termina nodo:1062   */

      /* Empieza nodo:1064 / Elemento padre: 1012   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1064)).setAttribute("colFondo","" );
      ((Element)v.get(1064)).setAttribute("ID","EstCab" );
      ((Element)v.get(1064)).setAttribute("cod","608" );
      ((Element)v.get(1012)).appendChild((Element)v.get(1064));

      /* Elemento padre:1064 / Elemento actual: 1065   */
      v.add(doc.createTextNode("oidTipo oferta"));
      ((Element)v.get(1064)).appendChild((Text)v.get(1065));

      /* Termina nodo Texto:1065   */
      /* Termina nodo:1064   */

      /* Empieza nodo:1066 / Elemento padre: 1012   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1066)).setAttribute("colFondo","" );
      ((Element)v.get(1066)).setAttribute("ID","EstCab" );
      ((Element)v.get(1066)).setAttribute("cod","581" );
      ((Element)v.get(1012)).appendChild((Element)v.get(1066));

      /* Elemento padre:1066 / Elemento actual: 1067   */
      v.add(doc.createTextNode("oidCiclo vida"));
      ((Element)v.get(1066)).appendChild((Text)v.get(1067));

      /* Termina nodo Texto:1067   */
      /* Termina nodo:1066   */

      /* Empieza nodo:1068 / Elemento padre: 1012   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1068)).setAttribute("colFondo","" );
      ((Element)v.get(1068)).setAttribute("ID","EstCab" );
      ((Element)v.get(1068)).setAttribute("cod","3401" );
      ((Element)v.get(1012)).appendChild((Element)v.get(1068));

      /* Elemento padre:1068 / Elemento actual: 1069   */
      v.add(doc.createTextNode("cod Ind Agrupacion"));
      ((Element)v.get(1068)).appendChild((Text)v.get(1069));

      /* Termina nodo Texto:1069   */
      /* Termina nodo:1068   */

      /* Empieza nodo:1070 / Elemento padre: 1012   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1070)).setAttribute("colFondo","" );
      ((Element)v.get(1070)).setAttribute("ID","EstCab" );
      ((Element)v.get(1070)).setAttribute("cod","1175" );
      ((Element)v.get(1012)).appendChild((Element)v.get(1070));

      /* Elemento padre:1070 / Elemento actual: 1071   */
      v.add(doc.createTextNode("oidPeríodo desde"));
      ((Element)v.get(1070)).appendChild((Text)v.get(1071));

      /* Termina nodo Texto:1071   */
      /* Termina nodo:1070   */

      /* Empieza nodo:1072 / Elemento padre: 1012   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1072)).setAttribute("colFondo","" );
      ((Element)v.get(1072)).setAttribute("ID","EstCab" );
      ((Element)v.get(1072)).setAttribute("cod","1176" );
      ((Element)v.get(1012)).appendChild((Element)v.get(1072));

      /* Elemento padre:1072 / Elemento actual: 1073   */
      v.add(doc.createTextNode("oidPeríodo hasta"));
      ((Element)v.get(1072)).appendChild((Text)v.get(1073));

      /* Termina nodo Texto:1073   */
      /* Termina nodo:1072   */
      /* Termina nodo:1012   */

      /* Empieza nodo:1074 / Elemento padre: 973   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(1074)).setAttribute("alto","22" );
      ((Element)v.get(1074)).setAttribute("accion","" );
      ((Element)v.get(1074)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(1074)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(1074)).setAttribute("maxSel","-1" );
      ((Element)v.get(1074)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(1074)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(1074)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(1074)).setAttribute("onLoad","" );
      ((Element)v.get(1074)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(973)).appendChild((Element)v.get(1074));

      /* Empieza nodo:1075 / Elemento padre: 1074   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1075)).setAttribute("tipo","texto" );
      ((Element)v.get(1075)).setAttribute("ID","EstDat" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1075));
      /* Termina nodo:1075   */

      /* Empieza nodo:1076 / Elemento padre: 1074   */
   }

   private void getXML4680(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(1076)).setAttribute("tipo","texto" );
      ((Element)v.get(1076)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1076));
      /* Termina nodo:1076   */

      /* Empieza nodo:1077 / Elemento padre: 1074   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1077)).setAttribute("tipo","texto" );
      ((Element)v.get(1077)).setAttribute("ID","EstDat" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1077));
      /* Termina nodo:1077   */

      /* Empieza nodo:1078 / Elemento padre: 1074   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1078)).setAttribute("tipo","texto" );
      ((Element)v.get(1078)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1078));
      /* Termina nodo:1078   */

      /* Empieza nodo:1079 / Elemento padre: 1074   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1079)).setAttribute("tipo","texto" );
      ((Element)v.get(1079)).setAttribute("ID","EstDat" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1079));
      /* Termina nodo:1079   */

      /* Empieza nodo:1080 / Elemento padre: 1074   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1080)).setAttribute("tipo","texto" );
      ((Element)v.get(1080)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1080));
      /* Termina nodo:1080   */

      /* Empieza nodo:1081 / Elemento padre: 1074   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1081)).setAttribute("tipo","texto" );
      ((Element)v.get(1081)).setAttribute("ID","EstDat" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1081));
      /* Termina nodo:1081   */

      /* Empieza nodo:1082 / Elemento padre: 1074   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1082)).setAttribute("tipo","texto" );
      ((Element)v.get(1082)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1082));
      /* Termina nodo:1082   */

      /* Empieza nodo:1083 / Elemento padre: 1074   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1083)).setAttribute("tipo","texto" );
      ((Element)v.get(1083)).setAttribute("ID","EstDat" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1083));
      /* Termina nodo:1083   */

      /* Empieza nodo:1084 / Elemento padre: 1074   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1084)).setAttribute("tipo","texto" );
      ((Element)v.get(1084)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1084));
      /* Termina nodo:1084   */

      /* Empieza nodo:1085 / Elemento padre: 1074   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1085)).setAttribute("tipo","texto" );
      ((Element)v.get(1085)).setAttribute("ID","EstDat" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1085));
      /* Termina nodo:1085   */

      /* Empieza nodo:1086 / Elemento padre: 1074   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1086)).setAttribute("tipo","texto" );
      ((Element)v.get(1086)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1086));
      /* Termina nodo:1086   */

      /* Empieza nodo:1087 / Elemento padre: 1074   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1087)).setAttribute("tipo","texto" );
      ((Element)v.get(1087)).setAttribute("ID","EstDat" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1087));
      /* Termina nodo:1087   */

      /* Empieza nodo:1088 / Elemento padre: 1074   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1088)).setAttribute("tipo","texto" );
      ((Element)v.get(1088)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1088));
      /* Termina nodo:1088   */

      /* Empieza nodo:1089 / Elemento padre: 1074   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1089)).setAttribute("tipo","texto" );
      ((Element)v.get(1089)).setAttribute("ID","EstDat" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1089));
      /* Termina nodo:1089   */

      /* Empieza nodo:1090 / Elemento padre: 1074   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1090)).setAttribute("tipo","texto" );
      ((Element)v.get(1090)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1090));
      /* Termina nodo:1090   */

      /* Empieza nodo:1091 / Elemento padre: 1074   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1091)).setAttribute("tipo","texto" );
      ((Element)v.get(1091)).setAttribute("ID","EstDat" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1091));
      /* Termina nodo:1091   */

      /* Empieza nodo:1092 / Elemento padre: 1074   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1092)).setAttribute("tipo","texto" );
      ((Element)v.get(1092)).setAttribute("ID","EstDat" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1092));
      /* Termina nodo:1092   */

      /* Empieza nodo:1093 / Elemento padre: 1074   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1093)).setAttribute("tipo","texto" );
      ((Element)v.get(1093)).setAttribute("ID","EstDat" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1093));
      /* Termina nodo:1093   */

      /* Empieza nodo:1094 / Elemento padre: 1074   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1094)).setAttribute("tipo","texto" );
      ((Element)v.get(1094)).setAttribute("ID","EstDat" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1094));
      /* Termina nodo:1094   */

      /* Empieza nodo:1095 / Elemento padre: 1074   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1095)).setAttribute("tipo","texto" );
      ((Element)v.get(1095)).setAttribute("ID","EstDat" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1095));
      /* Termina nodo:1095   */

      /* Empieza nodo:1096 / Elemento padre: 1074   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1096)).setAttribute("tipo","texto" );
      ((Element)v.get(1096)).setAttribute("ID","EstDat" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1096));
      /* Termina nodo:1096   */

      /* Empieza nodo:1097 / Elemento padre: 1074   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1097)).setAttribute("tipo","texto" );
      ((Element)v.get(1097)).setAttribute("ID","EstDat" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1097));
      /* Termina nodo:1097   */

      /* Empieza nodo:1098 / Elemento padre: 1074   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1098)).setAttribute("tipo","texto" );
   }

   private void getXML4770(Document doc) {
      ((Element)v.get(1098)).setAttribute("ID","EstDat" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1098));
      /* Termina nodo:1098   */

      /* Empieza nodo:1099 / Elemento padre: 1074   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1099)).setAttribute("tipo","texto" );
      ((Element)v.get(1099)).setAttribute("ID","EstDat" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1099));
      /* Termina nodo:1099   */

      /* Empieza nodo:1100 / Elemento padre: 1074   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1100)).setAttribute("tipo","texto" );
      ((Element)v.get(1100)).setAttribute("ID","EstDat" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1100));
      /* Termina nodo:1100   */

      /* Empieza nodo:1101 / Elemento padre: 1074   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1101)).setAttribute("tipo","texto" );
      ((Element)v.get(1101)).setAttribute("ID","EstDat" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1101));
      /* Termina nodo:1101   */

      /* Empieza nodo:1102 / Elemento padre: 1074   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1102)).setAttribute("tipo","texto" );
      ((Element)v.get(1102)).setAttribute("ID","EstDat" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1102));
      /* Termina nodo:1102   */

      /* Empieza nodo:1103 / Elemento padre: 1074   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1103)).setAttribute("tipo","texto" );
      ((Element)v.get(1103)).setAttribute("ID","EstDat" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1103));
      /* Termina nodo:1103   */
      /* Termina nodo:1074   */

      /* Empieza nodo:1104 / Elemento padre: 973   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(973)).appendChild((Element)v.get(1104));
      /* Termina nodo:1104   */

      /* Empieza nodo:1105 / Elemento padre: 973   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(1105)).setAttribute("nombre","mipgndo4" );
      ((Element)v.get(1105)).setAttribute("ancho","504" );
      ((Element)v.get(1105)).setAttribute("sep","$" );
      ((Element)v.get(1105)).setAttribute("x","12" );
      ((Element)v.get(1105)).setAttribute("class","botonera" );
      ((Element)v.get(1105)).setAttribute("y","753" );
      ((Element)v.get(1105)).setAttribute("control","|" );
      ((Element)v.get(1105)).setAttribute("conector","conectorSandra" );
      ((Element)v.get(1105)).setAttribute("rowset","" );
      ((Element)v.get(1105)).setAttribute("cargainicial","N" );
      ((Element)v.get(973)).appendChild((Element)v.get(1105));

      /* Empieza nodo:1106 / Elemento padre: 1105   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1106)).setAttribute("nombre","ret4" );
      ((Element)v.get(1106)).setAttribute("x","37" );
      ((Element)v.get(1106)).setAttribute("y","757" );
      ((Element)v.get(1106)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1106)).setAttribute("img","retroceder_on" );
      ((Element)v.get(1106)).setAttribute("tipo","0" );
      ((Element)v.get(1106)).setAttribute("estado","false" );
      ((Element)v.get(1106)).setAttribute("alt","" );
      ((Element)v.get(1106)).setAttribute("codigo","" );
      ((Element)v.get(1106)).setAttribute("accion","mipgndo4.retroceder();" );
      ((Element)v.get(1105)).appendChild((Element)v.get(1106));
      /* Termina nodo:1106   */

      /* Empieza nodo:1107 / Elemento padre: 1105   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1107)).setAttribute("nombre","ava4" );
      ((Element)v.get(1107)).setAttribute("x","52" );
      ((Element)v.get(1107)).setAttribute("y","757" );
      ((Element)v.get(1107)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1107)).setAttribute("img","avanzar_on" );
      ((Element)v.get(1107)).setAttribute("tipo","0" );
      ((Element)v.get(1107)).setAttribute("estado","false" );
      ((Element)v.get(1107)).setAttribute("alt","" );
      ((Element)v.get(1107)).setAttribute("codigo","" );
      ((Element)v.get(1107)).setAttribute("accion","mipgndo4.avanzar();" );
      ((Element)v.get(1105)).appendChild((Element)v.get(1107));
      /* Termina nodo:1107   */
      /* Termina nodo:1105   */
      /* Termina nodo:973   */

      /* Empieza nodo:1108 / Elemento padre: 27   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1108)).setAttribute("nombre","primera4" );
      ((Element)v.get(1108)).setAttribute("x","20" );
      ((Element)v.get(1108)).setAttribute("y","757" );
      ((Element)v.get(1108)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1108)).setAttribute("img","primera_on" );
      ((Element)v.get(1108)).setAttribute("tipo","0" );
      ((Element)v.get(1108)).setAttribute("estado","false" );
      ((Element)v.get(1108)).setAttribute("alt","" );
      ((Element)v.get(1108)).setAttribute("codigo","" );
      ((Element)v.get(1108)).setAttribute("accion","mipgndo4.retrocederPrimeraPagina();" );
      ((Element)v.get(27)).appendChild((Element)v.get(1108));
      /* Termina nodo:1108   */

      /* Empieza nodo:1109 / Elemento padre: 27   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1109)).setAttribute("nombre","separa4" );
      ((Element)v.get(1109)).setAttribute("x","59" );
      ((Element)v.get(1109)).setAttribute("y","753" );
      ((Element)v.get(1109)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1109)).setAttribute("img","separa_base" );
      ((Element)v.get(1109)).setAttribute("tipo","0" );
      ((Element)v.get(1109)).setAttribute("estado","false" );
      ((Element)v.get(1109)).setAttribute("alt","" );
      ((Element)v.get(1109)).setAttribute("codigo","" );
      ((Element)v.get(1109)).setAttribute("accion","" );
      ((Element)v.get(27)).appendChild((Element)v.get(1109));
      /* Termina nodo:1109   */
      /* Termina nodo:27   */


   }

}

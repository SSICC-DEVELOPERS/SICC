
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_datos_bp_detalle  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_datos_bp_detalle" );
      ((Element)v.get(0)).setAttribute("cod","0225" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","nueva entrada datos BP" );
      ((Element)v.get(0)).setAttribute("onload","carga();" );
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
      ((Element)v.get(4)).setAttribute("src","contenido_datos_bp_detalle.js" );
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
      ((Element)v.get(7)).setAttribute("name","txtCodProducto" );
      ((Element)v.get(7)).setAttribute("group","todos" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("format","t" );
      ((Element)v.get(7)).setAttribute("min","0" );
      ((Element)v.get(7)).setAttribute("max","20" );
      ((Element)v.get(7)).setAttribute("cod","337" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbTipoOferta" );
      ((Element)v.get(8)).setAttribute("group","todos" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","608" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbCicloVida" );
      ((Element)v.get(9)).setAttribute("group","todos" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","581" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","txtBaseDestinatarios" );
      ((Element)v.get(10)).setAttribute("group","todos" );
      ((Element)v.get(10)).setAttribute("required","false" );
      ((Element)v.get(10)).setAttribute("format","E" );
      ((Element)v.get(10)).setAttribute("min","0" );
      ((Element)v.get(10)).setAttribute("max","9999999999" );
      ((Element)v.get(10)).setAttribute("cod","807" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","txtFactorCorreccion" );
      ((Element)v.get(11)).setAttribute("group","todos" );
      ((Element)v.get(11)).setAttribute("required","false" );
      ((Element)v.get(11)).setAttribute("format","n" );
      ((Element)v.get(11)).setAttribute("min","0" );
      ((Element)v.get(11)).setAttribute("max","9999999999999.999" );
      ((Element)v.get(11)).setAttribute("cod","869" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","txtCriterio" );
      ((Element)v.get(12)).setAttribute("group","todos" );
      ((Element)v.get(12)).setAttribute("required","false" );
      ((Element)v.get(12)).setAttribute("format","t" );
      ((Element)v.get(12)).setAttribute("min","0" );
      ((Element)v.get(12)).setAttribute("max","20" );
      ((Element)v.get(12)).setAttribute("cod","837" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","txtPromedio" );
      ((Element)v.get(13)).setAttribute("group","todos" );
      ((Element)v.get(13)).setAttribute("required","false" );
      ((Element)v.get(13)).setAttribute("format","n" );
      ((Element)v.get(13)).setAttribute("min","0" );
      ((Element)v.get(13)).setAttribute("max","9999999999999.99" );
      ((Element)v.get(13)).setAttribute("cod","1371" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","txtUnidades" );
      ((Element)v.get(14)).setAttribute("group","todos" );
      ((Element)v.get(14)).setAttribute("required","false" );
      ((Element)v.get(14)).setAttribute("format","E" );
      ((Element)v.get(14)).setAttribute("min","0" );
      ((Element)v.get(14)).setAttribute("max","9999999999" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(14)).setAttribute("cod","1179" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(15)).setAttribute("name","atxtObservaciones" );
      ((Element)v.get(15)).setAttribute("group","todos" );
      ((Element)v.get(15)).setAttribute("required","false" );
      ((Element)v.get(15)).setAttribute("format","t" );
      ((Element)v.get(15)).setAttribute("min","0" );
      ((Element)v.get(15)).setAttribute("max","100" );
      ((Element)v.get(15)).setAttribute("cod","169" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(16)).setAttribute("name","txtCodVenta" );
      ((Element)v.get(16)).setAttribute("group","todos" );
      ((Element)v.get(16)).setAttribute("required","false" );
      ((Element)v.get(16)).setAttribute("format","t" );
      ((Element)v.get(16)).setAttribute("min","0" );
      ((Element)v.get(16)).setAttribute("max","18" );
      ((Element)v.get(16)).setAttribute("cod","336" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(17)).setAttribute("name","cbPeriodoFin" );
      ((Element)v.get(17)).setAttribute("group","todos" );
      ((Element)v.get(17)).setAttribute("required","false" );
      ((Element)v.get(17)).setAttribute("cod","967" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(18)).setAttribute("name","txtPrecio" );
      ((Element)v.get(18)).setAttribute("group","todos" );
      ((Element)v.get(18)).setAttribute("required","false" );
      ((Element)v.get(18)).setAttribute("format","m" );
      ((Element)v.get(18)).setAttribute("min","0" );
      ((Element)v.get(18)).setAttribute("max","99999999999999.99" );
      ((Element)v.get(18)).setAttribute("cod","377" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(19)).setAttribute("name","txtPrecioEstandar" );
      ((Element)v.get(19)).setAttribute("group","todos" );
      ((Element)v.get(19)).setAttribute("required","false" );
      ((Element)v.get(19)).setAttribute("format","m" );
      ((Element)v.get(19)).setAttribute("min","0" );
      ((Element)v.get(19)).setAttribute("max","99999999999999.99" );
      ((Element)v.get(19)).setAttribute("cod","1370" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(20)).setAttribute("name","txtPrecioContable" );
      ((Element)v.get(20)).setAttribute("group","todos" );
      ((Element)v.get(20)).setAttribute("required","false" );
      ((Element)v.get(20)).setAttribute("format","m" );
      ((Element)v.get(20)).setAttribute("min","0" );
      ((Element)v.get(20)).setAttribute("max","9999999999999.99" );
      ((Element)v.get(20)).setAttribute("cod","974" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(21)).setAttribute("name","cbFormaCobro" );
      ((Element)v.get(21)).setAttribute("group","todos" );
      ((Element)v.get(21)).setAttribute("required","true" );
      ((Element)v.get(21)).setAttribute("cod","884" );
      ((Element)v.get(6)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(22)).setAttribute("name","cbFormaPago" );
      ((Element)v.get(22)).setAttribute("group","todos" );
      ((Element)v.get(22)).setAttribute("required","false" );
      ((Element)v.get(22)).setAttribute("cod","541" );
      ((Element)v.get(6)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(23)).setAttribute("name","cbTipoDespacho" );
      ((Element)v.get(23)).setAttribute("group","todos" );
      ((Element)v.get(23)).setAttribute("required","true" );
      ((Element)v.get(23)).setAttribute("cod","1000" );
      ((Element)v.get(6)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(24)).setAttribute("name","cbEnvioSolicitud" );
      ((Element)v.get(24)).setAttribute("group","todos" );
      ((Element)v.get(24)).setAttribute("required","FALSE" );
      ((Element)v.get(24)).setAttribute("cod","859" );
      ((Element)v.get(6)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(25)).setAttribute("name","cbAcceso" );
      ((Element)v.get(25)).setAttribute("group","todos" );
      ((Element)v.get(25)).setAttribute("required","true" );
      ((Element)v.get(25)).setAttribute("cod","10" );
      ((Element)v.get(6)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(26)).setAttribute("name","cbSubacceso" );
      ((Element)v.get(26)).setAttribute("group","todos" );
      ((Element)v.get(26)).setAttribute("required","true" );
      ((Element)v.get(26)).setAttribute("cod","122" );
      ((Element)v.get(6)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(27)).setAttribute("name","cbSubgerencia" );
      ((Element)v.get(27)).setAttribute("group","todos" );
      ((Element)v.get(27)).setAttribute("required","false" );
      ((Element)v.get(27)).setAttribute("cod","992" );
      ((Element)v.get(6)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(28)).setAttribute("name","cbRegion" );
      ((Element)v.get(28)).setAttribute("group","todos" );
      ((Element)v.get(28)).setAttribute("required","false" );
      ((Element)v.get(28)).setAttribute("cod","109" );
      ((Element)v.get(6)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(29)).setAttribute("name","cbZona" );
      ((Element)v.get(29)).setAttribute("group","todos" );
      ((Element)v.get(29)).setAttribute("required","false" );
      ((Element)v.get(29)).setAttribute("cod","143" );
      ((Element)v.get(6)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(30)).setAttribute("name","cbSubtipoCliente" );
      ((Element)v.get(30)).setAttribute("group","todos" );
      ((Element)v.get(30)).setAttribute("required","false" );
      ((Element)v.get(30)).setAttribute("cod","595" );
      ((Element)v.get(6)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(31)).setAttribute("name","cbTipoClasificacionCliente" );
      ((Element)v.get(31)).setAttribute("group","todos" );
      ((Element)v.get(31)).setAttribute("required","false" );
      ((Element)v.get(31)).setAttribute("cod","610" );
      ((Element)v.get(6)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(32)).setAttribute("name","cbClasificacionCliente" );
      ((Element)v.get(32)).setAttribute("group","grupoTipoClasificacion" );
      ((Element)v.get(32)).setAttribute("required","true" );
      ((Element)v.get(32)).setAttribute("cod","611" );
      ((Element)v.get(6)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(33)).setAttribute("name","cbEstado" );
      ((Element)v.get(33)).setAttribute("group","todos" );
      ((Element)v.get(33)).setAttribute("required","false" );
      ((Element)v.get(33)).setAttribute("cod","400" );
      ((Element)v.get(6)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(34)).setAttribute("name","cbCriterioAsignacion" );
      ((Element)v.get(34)).setAttribute("group","criterioAsignacion" );
      ((Element)v.get(34)).setAttribute("required","true" );
      ((Element)v.get(34)).setAttribute("cod","838" );
      ((Element)v.get(6)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(35)).setAttribute("name","cbCodMensaje2" );
      ((Element)v.get(35)).setAttribute("group","cbCodMensaje2" );
      ((Element)v.get(35)).setAttribute("required","true" );
      ((Element)v.get(35)).setAttribute("cod","821" );
      ((Element)v.get(6)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(36)).setAttribute("name","cbCodMensaje3" );
      ((Element)v.get(36)).setAttribute("group","cbCodMensaje3" );
      ((Element)v.get(36)).setAttribute("required","true" );
      ((Element)v.get(36)).setAttribute("cod","821" );
      ((Element)v.get(6)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */
      /* Termina nodo:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:37 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(37)).setAttribute("nombre","frmUnico" );
      ((Element)v.get(0)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","accion" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","casoUso" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","varActividad" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","varCampanyaFuente" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 37   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","varCanal" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","varCatalogo" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","varCurso" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","varEdadDesde" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","varEdadHasta" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","varListaCliente" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","varMarca" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","varMonto" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","varNegocio" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","varNumeroAniversario" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","varPeriodo" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","varPeriodoCurso" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","varPeriodoHasta" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","varPeriodoDesde" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","varSubcriterio" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","varTipoCliente" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","varNumUnidadesCliente" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","varNumUnidadesTotales" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(63)).setAttribute("nombre","varUnidadNegocio" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(64)).setAttribute("nombre","varLblMarca" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(65)).setAttribute("nombre","varDescCanal" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(66)).setAttribute("nombre","varDescMarca" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(67)).setAttribute("nombre","varDescPeriodo" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(68)).setAttribute("nombre","varDescActividad" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(69)).setAttribute("nombre","varDescTipoCliente" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(70)).setAttribute("nombre","varOid" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(71)).setAttribute("nombre","varSubgerencia" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(72)).setAttribute("nombre","varRegion" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(73)).setAttribute("nombre","varZona" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(74)).setAttribute("nombre","varObservaciones" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(75)).setAttribute("nombre","varSubtipoCliente" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(76)).setAttribute("nombre","varTipoClasificacionCliente" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(77)).setAttribute("nombre","varClasificacionCliente" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(78)).setAttribute("nombre","varEstado" );
      ((Element)v.get(78)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(79)).setAttribute("nombre","varCriterioAsig" );
      ((Element)v.get(79)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(80)).setAttribute("nombre","varAcceso" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(81)).setAttribute("nombre","varSubacceso" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(82)).setAttribute("nombre","varPeriodoFin" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(83)).setAttribute("nombre","varTipoOferta" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(84)).setAttribute("nombre","varCicloVida" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(85)).setAttribute("nombre","varCodProducto" );
      ((Element)v.get(85)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(86)).setAttribute("nombre","varCodVenta" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(87)).setAttribute("nombre","varCodVentaOid" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(88)).setAttribute("nombre","varPrecioEstandar" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(89)).setAttribute("nombre","varPrecio" );
      ((Element)v.get(89)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 37   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(90)).setAttribute("nombre","varPrecioContable" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(91)).setAttribute("nombre","varBaseDestinatarios" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(92)).setAttribute("nombre","varFactorCorreccion" );
      ((Element)v.get(92)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(93)).setAttribute("nombre","varUEstimadas" );
      ((Element)v.get(93)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(94)).setAttribute("nombre","varUTotalesEstimadas" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(95)).setAttribute("nombre","varCriterio" );
      ((Element)v.get(95)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(96)).setAttribute("nombre","varFormaCobro" );
      ((Element)v.get(96)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(97)).setAttribute("nombre","varFormaPago" );
      ((Element)v.get(97)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(98)).setAttribute("nombre","varTipoDespacho" );
      ((Element)v.get(98)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(99)).setAttribute("nombre","varEnvioSolicitud" );
      ((Element)v.get(99)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(100)).setAttribute("nombre","varMensaje" );
      ((Element)v.get(100)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(101)).setAttribute("nombre","varMarcaCriterio" );
      ((Element)v.get(101)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(102)).setAttribute("nombre","varRadioMensaje" );
      ((Element)v.get(102)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(103)).setAttribute("nombre","varDesProducto" );
      ((Element)v.get(103)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(104)).setAttribute("nombre","varEstadoProceso" );
      ((Element)v.get(104)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(105)).setAttribute("nombre","hOidAcce" );
      ((Element)v.get(105)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(106)).setAttribute("nombre","hOidSubAcce" );
      ((Element)v.get(106)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(107)).setAttribute("nombre","hOidTipOfer" );
      ((Element)v.get(107)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(108)).setAttribute("nombre","hOidTipClie" );
      ((Element)v.get(108)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(109)).setAttribute("nombre","hOidSubTipClie" );
      ((Element)v.get(109)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(110)).setAttribute("nombre","hOidCicVida" );
      ((Element)v.get(110)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(111)).setAttribute("nombre","hOidCriAsig" );
      ((Element)v.get(111)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */

      /* Empieza nodo:112 / Elemento padre: 37   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(112)).setAttribute("nombre","hOidTipDesp" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(112)).setAttribute("valor","" );
      ((Element)v.get(37)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */

      /* Empieza nodo:113 / Elemento padre: 37   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(113)).setAttribute("nombre","capa1" );
      ((Element)v.get(37)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("table"));
      ((Element)v.get(114)).setAttribute("width","100%" );
      ((Element)v.get(114)).setAttribute("border","0" );
      ((Element)v.get(114)).setAttribute("cellspacing","0" );
      ((Element)v.get(114)).setAttribute("cellpadding","0" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).setAttribute("width","12" );
      ((Element)v.get(116)).setAttribute("align","center" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","12" );
      ((Element)v.get(117)).setAttribute("height","12" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("width","750" );
      ((Element)v.get(115)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(120)).setAttribute("width","12" );
      ((Element)v.get(115)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","12" );
      ((Element)v.get(121)).setAttribute("height","1" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:115   */

      /* Empieza nodo:122 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(127)).setAttribute("class","legend" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(128)).setAttribute("nombre","lblDatosCabecera" );
      ((Element)v.get(128)).setAttribute("alto","13" );
      ((Element)v.get(128)).setAttribute("filas","1" );
      ((Element)v.get(128)).setAttribute("valor","" );
      ((Element)v.get(128)).setAttribute("cod","00156" );
      ((Element)v.get(128)).setAttribute("id","legend" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 126   */
      v.add(doc.createElement("table"));
      ((Element)v.get(129)).setAttribute("width","100%" );
      ((Element)v.get(129)).setAttribute("border","0" );
      ((Element)v.get(129)).setAttribute("align","center" );
      ((Element)v.get(129)).setAttribute("cellspacing","0" );
      ((Element)v.get(129)).setAttribute("cellpadding","0" );
      ((Element)v.get(126)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("table"));
      ((Element)v.get(132)).setAttribute("width","714" );
      ((Element)v.get(132)).setAttribute("border","0" );
      ((Element)v.get(132)).setAttribute("align","left" );
      ((Element)v.get(132)).setAttribute("cellspacing","0" );
      ((Element)v.get(132)).setAttribute("cellpadding","0" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).setAttribute("colspan","4" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","8" );
      ((Element)v.get(135)).setAttribute("height","8" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:136 / Elemento padre: 132   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(132)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
   }

   private void getXML630(Document doc) {
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
      ((Element)v.get(140)).setAttribute("nombre","lblPais" );
      ((Element)v.get(140)).setAttribute("alto","13" );
      ((Element)v.get(140)).setAttribute("filas","1" );
      ((Element)v.get(140)).setAttribute("valor","" );
      ((Element)v.get(140)).setAttribute("id","datosTitle" );
      ((Element)v.get(140)).setAttribute("cod","5" );
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
      ((Element)v.get(144)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(144)).setAttribute("alto","13" );
      ((Element)v.get(144)).setAttribute("filas","1" );
      ((Element)v.get(144)).setAttribute("valor","" );
      ((Element)v.get(144)).setAttribute("id","datosTitle" );
      ((Element)v.get(144)).setAttribute("cod","6" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","25" );
      ((Element)v.get(146)).setAttribute("height","8" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:147 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(148)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(148)).setAttribute("alto","13" );
      ((Element)v.get(148)).setAttribute("filas","1" );
      ((Element)v.get(148)).setAttribute("valor","" );
      ((Element)v.get(148)).setAttribute("id","datosTitle" );
      ((Element)v.get(148)).setAttribute("cod","7" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).setAttribute("width","100%" );
      ((Element)v.get(136)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","8" );
      ((Element)v.get(150)).setAttribute("height","8" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:136   */

      /* Empieza nodo:151 / Elemento padre: 132   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(132)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","8" );
      ((Element)v.get(153)).setAttribute("height","8" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:154 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(155)).setAttribute("nombre","lbldtPais" );
      ((Element)v.get(155)).setAttribute("alto","13" );
      ((Element)v.get(155)).setAttribute("filas","1" );
      ((Element)v.get(155)).setAttribute("valor","" );
      ((Element)v.get(155)).setAttribute("id","datosCampos" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:156 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(157)).setAttribute("src","b.gif" );
      ((Element)v.get(157)).setAttribute("width","25" );
      ((Element)v.get(157)).setAttribute("height","8" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:158 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(159)).setAttribute("nombre","lbldtMarca" );
      ((Element)v.get(159)).setAttribute("alto","13" );
      ((Element)v.get(159)).setAttribute("filas","1" );
      ((Element)v.get(159)).setAttribute("valor","" );
      ((Element)v.get(159)).setAttribute("id","datosCampos" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).setAttribute("width","25" );
      ((Element)v.get(161)).setAttribute("height","8" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(163)).setAttribute("nombre","lbldtCanal" );
      ((Element)v.get(163)).setAttribute("alto","13" );
      ((Element)v.get(163)).setAttribute("filas","1" );
      ((Element)v.get(163)).setAttribute("valor","" );
      ((Element)v.get(163)).setAttribute("id","datosCampos" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).setAttribute("width","100%" );
      ((Element)v.get(151)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(165)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).setAttribute("width","8" );
      ((Element)v.get(165)).setAttribute("height","8" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */
      /* Termina nodo:151   */

      /* Empieza nodo:166 / Elemento padre: 132   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(132)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).setAttribute("colspan","4" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","8" );
      ((Element)v.get(168)).setAttribute("height","8" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:169 / Elemento padre: 129   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(129)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("table"));
      ((Element)v.get(171)).setAttribute("width","714" );
      ((Element)v.get(171)).setAttribute("border","0" );
      ((Element)v.get(171)).setAttribute("align","left" );
      ((Element)v.get(171)).setAttribute("cellspacing","0" );
      ((Element)v.get(171)).setAttribute("cellpadding","0" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).setAttribute("width","8" );
      ((Element)v.get(174)).setAttribute("height","8" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(176)).setAttribute("nombre","lblActividad" );
      ((Element)v.get(176)).setAttribute("alto","13" );
      ((Element)v.get(176)).setAttribute("filas","1" );
      ((Element)v.get(176)).setAttribute("valor","" );
      ((Element)v.get(176)).setAttribute("id","datosTitle" );
      ((Element)v.get(176)).setAttribute("cod","173" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(178)).setAttribute("src","b.gif" );
      ((Element)v.get(178)).setAttribute("width","25" );
      ((Element)v.get(178)).setAttribute("height","8" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:179 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(180)).setAttribute("nombre","lblPeriodo" );
      ((Element)v.get(180)).setAttribute("alto","13" );
      ((Element)v.get(180)).setAttribute("filas","1" );
      ((Element)v.get(180)).setAttribute("valor","" );
      ((Element)v.get(180)).setAttribute("id","datosTitle" );
      ((Element)v.get(180)).setAttribute("cod","276" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(182)).setAttribute("src","b.gif" );
      ((Element)v.get(182)).setAttribute("width","25" );
      ((Element)v.get(182)).setAttribute("height","8" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(172)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(184)).setAttribute("nombre","lblTiposCliente" );
      ((Element)v.get(184)).setAttribute("alto","13" );
      ((Element)v.get(184)).setAttribute("filas","1" );
      ((Element)v.get(184)).setAttribute("valor","" );
      ((Element)v.get(184)).setAttribute("id","datosTitle" );
      ((Element)v.get(184)).setAttribute("cod","1301" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 172   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).setAttribute("width","100%" );
      ((Element)v.get(172)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).setAttribute("width","8" );
      ((Element)v.get(186)).setAttribute("height","8" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */
      /* Termina nodo:172   */

      /* Empieza nodo:187 / Elemento padre: 171   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(171)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(189)).setAttribute("src","b.gif" );
      ((Element)v.get(189)).setAttribute("width","8" );
      ((Element)v.get(189)).setAttribute("height","8" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(191)).setAttribute("nombre","lbldtActividad" );
      ((Element)v.get(191)).setAttribute("alto","13" );
      ((Element)v.get(191)).setAttribute("filas","1" );
      ((Element)v.get(191)).setAttribute("valor","" );
      ((Element)v.get(191)).setAttribute("id","datosCampos" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","25" );
      ((Element)v.get(193)).setAttribute("height","8" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:194 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(195)).setAttribute("nombre","lbldtPeriodo" );
      ((Element)v.get(195)).setAttribute("alto","13" );
      ((Element)v.get(195)).setAttribute("filas","1" );
      ((Element)v.get(195)).setAttribute("valor","" );
      ((Element)v.get(195)).setAttribute("id","datosCampos" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(197)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).setAttribute("width","25" );
      ((Element)v.get(197)).setAttribute("height","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(199)).setAttribute("nombre","lbldtTiposCliente" );
      ((Element)v.get(199)).setAttribute("alto","13" );
      ((Element)v.get(199)).setAttribute("filas","1" );
      ((Element)v.get(199)).setAttribute("valor","" );
      ((Element)v.get(199)).setAttribute("id","datosCampos" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 187   */
      v.add(doc.createElement("td"));
      ((Element)v.get(200)).setAttribute("width","100%" );
      ((Element)v.get(187)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).setAttribute("width","8" );
      ((Element)v.get(201)).setAttribute("height","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */
      /* Termina nodo:187   */

      /* Empieza nodo:202 / Elemento padre: 171   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(171)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).setAttribute("colspan","4" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).setAttribute("width","8" );
      ((Element)v.get(204)).setAttribute("height","8" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */
      /* Termina nodo:202   */
      /* Termina nodo:171   */
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:129   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:205 / Elemento padre: 122   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).setAttribute("width","8" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(206)).setAttribute("height","12" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */
      /* Termina nodo:122   */

      /* Empieza nodo:207 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).setAttribute("width","12" );
      ((Element)v.get(208)).setAttribute("align","center" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","12" );
      ((Element)v.get(209)).setAttribute("height","15" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).setAttribute("width","750" );
      ((Element)v.get(207)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 207   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).setAttribute("width","12" );
      ((Element)v.get(207)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(213)).setAttribute("src","b.gif" );
      ((Element)v.get(213)).setAttribute("width","12" );
      ((Element)v.get(213)).setAttribute("height","15" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */
      /* Termina nodo:207   */

      /* Empieza nodo:214 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(216)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:217 / Elemento padre: 214   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(219)).setAttribute("class","legend" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(220)).setAttribute("nombre","lblDatosGenerales" );
      ((Element)v.get(220)).setAttribute("alto","13" );
      ((Element)v.get(220)).setAttribute("filas","1" );
      ((Element)v.get(220)).setAttribute("valor","" );
      ((Element)v.get(220)).setAttribute("cod","0011" );
      ((Element)v.get(220)).setAttribute("id","legend" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:221 / Elemento padre: 218   */
      v.add(doc.createElement("table"));
      ((Element)v.get(221)).setAttribute("width","100%" );
      ((Element)v.get(221)).setAttribute("border","0" );
      ((Element)v.get(221)).setAttribute("align","center" );
      ((Element)v.get(221)).setAttribute("cellspacing","0" );
      ((Element)v.get(221)).setAttribute("cellpadding","0" );
      ((Element)v.get(218)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(221)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("table"));
      ((Element)v.get(224)).setAttribute("width","714" );
      ((Element)v.get(224)).setAttribute("border","0" );
      ((Element)v.get(224)).setAttribute("align","left" );
      ((Element)v.get(224)).setAttribute("cellspacing","0" );
      ((Element)v.get(224)).setAttribute("cellpadding","0" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(224)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).setAttribute("colspan","4" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).setAttribute("width","8" );
      ((Element)v.get(227)).setAttribute("height","8" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:228 / Elemento padre: 224   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(224)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(230)).setAttribute("width","8" );
      ((Element)v.get(230)).setAttribute("height","8" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(228)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(232)).setAttribute("nombre","lblCodProducto" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(232)).setAttribute("alto","13" );
      ((Element)v.get(232)).setAttribute("filas","1" );
      ((Element)v.get(232)).setAttribute("valor","" );
      ((Element)v.get(232)).setAttribute("id","datosTitle" );
      ((Element)v.get(232)).setAttribute("cod","337" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:233 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(228)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(234)).setAttribute("src","b.gif" );
      ((Element)v.get(234)).setAttribute("width","25" );
      ((Element)v.get(234)).setAttribute("height","8" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:235 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(228)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(236)).setAttribute("nombre","lbldes" );
      ((Element)v.get(236)).setAttribute("alto","13" );
      ((Element)v.get(236)).setAttribute("filas","1" );
      ((Element)v.get(236)).setAttribute("valor","" );
      ((Element)v.get(236)).setAttribute("id","datosTitle" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:237 / Elemento padre: 228   */
      v.add(doc.createElement("td"));
      ((Element)v.get(237)).setAttribute("width","100%" );
      ((Element)v.get(228)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(238)).setAttribute("src","b.gif" );
      ((Element)v.get(238)).setAttribute("width","8" );
      ((Element)v.get(238)).setAttribute("height","8" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */
      /* Termina nodo:228   */

      /* Empieza nodo:239 / Elemento padre: 224   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(224)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(241)).setAttribute("src","b.gif" );
      ((Element)v.get(241)).setAttribute("width","8" );
      ((Element)v.get(241)).setAttribute("height","8" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:242 / Elemento padre: 239   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(239)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(243)).setAttribute("nombre","txtCodProducto" );
      ((Element)v.get(243)).setAttribute("onshtab","shtab();" );
      ((Element)v.get(243)).setAttribute("id","datosCampos" );
      ((Element)v.get(243)).setAttribute("max","20" );
      ((Element)v.get(243)).setAttribute("tipo","" );
      ((Element)v.get(243)).setAttribute("onchange","desProducto();" );
      ((Element)v.get(243)).setAttribute("req","S" );
      ((Element)v.get(243)).setAttribute("valor","" );
      ((Element)v.get(243)).setAttribute("size","32" );
      ((Element)v.get(243)).setAttribute("validacion","" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:244 / Elemento padre: 239   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(245)).setAttribute("src","b.gif" );
      ((Element)v.get(245)).setAttribute("width","25" );
      ((Element)v.get(245)).setAttribute("height","8" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:246 / Elemento padre: 239   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(247)).setAttribute("nombre","lblDesProducto" );
      ((Element)v.get(247)).setAttribute("alto","13" );
      ((Element)v.get(247)).setAttribute("filas","1" );
      ((Element)v.get(247)).setAttribute("valor","" );
      ((Element)v.get(247)).setAttribute("id","datosTitle" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:248 / Elemento padre: 239   */
      v.add(doc.createElement("td"));
      ((Element)v.get(248)).setAttribute("width","100%" );
      ((Element)v.get(239)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(249)).setAttribute("src","b.gif" );
      ((Element)v.get(249)).setAttribute("width","8" );
      ((Element)v.get(249)).setAttribute("height","8" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */
      /* Termina nodo:239   */

      /* Empieza nodo:250 / Elemento padre: 224   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(224)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).setAttribute("colspan","4" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(252)).setAttribute("src","b.gif" );
      ((Element)v.get(252)).setAttribute("width","8" );
      ((Element)v.get(252)).setAttribute("height","8" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */
      /* Termina nodo:250   */
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:253 / Elemento padre: 221   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(221)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(253)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("table"));
      ((Element)v.get(255)).setAttribute("width","714" );
      ((Element)v.get(255)).setAttribute("border","0" );
      ((Element)v.get(255)).setAttribute("align","left" );
      ((Element)v.get(255)).setAttribute("cellspacing","0" );
      ((Element)v.get(255)).setAttribute("cellpadding","0" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(255)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(258)).setAttribute("src","b.gif" );
      ((Element)v.get(258)).setAttribute("width","8" );
      ((Element)v.get(258)).setAttribute("height","8" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:259 / Elemento padre: 256   */
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(260)).setAttribute("nombre","lblTipoOferta" );
      ((Element)v.get(260)).setAttribute("alto","13" );
      ((Element)v.get(260)).setAttribute("filas","1" );
      ((Element)v.get(260)).setAttribute("valor","" );
      ((Element)v.get(260)).setAttribute("id","datosTitle" );
      ((Element)v.get(260)).setAttribute("cod","608" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:261 / Elemento padre: 256   */
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(262)).setAttribute("src","b.gif" );
      ((Element)v.get(262)).setAttribute("width","25" );
      ((Element)v.get(262)).setAttribute("height","8" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */

      /* Empieza nodo:263 / Elemento padre: 256   */
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(264)).setAttribute("nombre","lblCicloVida" );
      ((Element)v.get(264)).setAttribute("alto","13" );
      ((Element)v.get(264)).setAttribute("filas","1" );
      ((Element)v.get(264)).setAttribute("valor","" );
      ((Element)v.get(264)).setAttribute("id","datosTitle" );
      ((Element)v.get(264)).setAttribute("cod","581" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */

      /* Empieza nodo:265 / Elemento padre: 256   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).setAttribute("width","100%" );
      ((Element)v.get(256)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(266)).setAttribute("src","b.gif" );
      ((Element)v.get(266)).setAttribute("width","8" );
      ((Element)v.get(266)).setAttribute("height","8" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */
      /* Termina nodo:256   */

      /* Empieza nodo:267 / Elemento padre: 255   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(255)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("td"));
      ((Element)v.get(267)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(269)).setAttribute("src","b.gif" );
      ((Element)v.get(269)).setAttribute("width","8" );
      ((Element)v.get(269)).setAttribute("height","8" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */

      /* Empieza nodo:270 / Elemento padre: 267   */
      v.add(doc.createElement("td"));
      ((Element)v.get(270)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(267)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(271)).setAttribute("nombre","cbTipoOferta" );
      ((Element)v.get(271)).setAttribute("id","datosCampos" );
      ((Element)v.get(271)).setAttribute("size","1" );
      ((Element)v.get(271)).setAttribute("multiple","N" );
      ((Element)v.get(271)).setAttribute("req","S" );
      ((Element)v.get(271)).setAttribute("valorinicial","" );
      ((Element)v.get(271)).setAttribute("onshtab","shTabOferta();" );
      ((Element)v.get(271)).setAttribute("textoinicial","" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:271   */
      /* Termina nodo:270   */

      /* Empieza nodo:273 / Elemento padre: 267   */
      v.add(doc.createElement("td"));
      ((Element)v.get(267)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(274)).setAttribute("src","b.gif" );
      ((Element)v.get(274)).setAttribute("width","25" );
      ((Element)v.get(274)).setAttribute("height","8" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */

      /* Empieza nodo:275 / Elemento padre: 267   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(267)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(276)).setAttribute("nombre","cbCicloVida" );
      ((Element)v.get(276)).setAttribute("id","datosCampos" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(276)).setAttribute("size","1" );
      ((Element)v.get(276)).setAttribute("multiple","N" );
      ((Element)v.get(276)).setAttribute("req","S" );
      ((Element)v.get(276)).setAttribute("valorinicial","" );
      ((Element)v.get(276)).setAttribute("textoinicial","" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:278 / Elemento padre: 267   */
      v.add(doc.createElement("td"));
      ((Element)v.get(278)).setAttribute("width","100%" );
      ((Element)v.get(267)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(279)).setAttribute("src","b.gif" );
      ((Element)v.get(279)).setAttribute("width","8" );
      ((Element)v.get(279)).setAttribute("height","8" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */
      /* Termina nodo:267   */

      /* Empieza nodo:280 / Elemento padre: 255   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(255)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("td"));
      ((Element)v.get(281)).setAttribute("colspan","4" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(282)).setAttribute("src","b.gif" );
      ((Element)v.get(282)).setAttribute("width","8" );
      ((Element)v.get(282)).setAttribute("height","8" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */
      /* Termina nodo:280   */
      /* Termina nodo:255   */
      /* Termina nodo:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:283 / Elemento padre: 221   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(221)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("td"));
      ((Element)v.get(283)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("table"));
      ((Element)v.get(285)).setAttribute("width","714" );
      ((Element)v.get(285)).setAttribute("border","0" );
      ((Element)v.get(285)).setAttribute("align","left" );
      ((Element)v.get(285)).setAttribute("cellspacing","0" );
      ((Element)v.get(285)).setAttribute("cellpadding","0" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(285)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(288)).setAttribute("src","b.gif" );
      ((Element)v.get(288)).setAttribute("width","8" );
      ((Element)v.get(288)).setAttribute("height","8" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:287   */

      /* Empieza nodo:289 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(290)).setAttribute("nombre","lblBaseDestinatarios" );
      ((Element)v.get(290)).setAttribute("alto","13" );
      ((Element)v.get(290)).setAttribute("filas","1" );
      ((Element)v.get(290)).setAttribute("valor","" );
      ((Element)v.get(290)).setAttribute("id","datosTitle" );
      ((Element)v.get(290)).setAttribute("cod","807" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */
      /* Termina nodo:289   */

      /* Empieza nodo:291 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(292)).setAttribute("src","b.gif" );
      ((Element)v.get(292)).setAttribute("width","25" );
      ((Element)v.get(292)).setAttribute("height","8" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:291   */

      /* Empieza nodo:293 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(294)).setAttribute("nombre","lblFactorCorreccion" );
      ((Element)v.get(294)).setAttribute("alto","13" );
      ((Element)v.get(294)).setAttribute("filas","1" );
      ((Element)v.get(294)).setAttribute("valor","" );
      ((Element)v.get(294)).setAttribute("id","datosTitle" );
      ((Element)v.get(294)).setAttribute("cod","869" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:293   */

      /* Empieza nodo:295 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(296)).setAttribute("src","b.gif" );
      ((Element)v.get(296)).setAttribute("width","25" );
      ((Element)v.get(296)).setAttribute("height","8" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */

      /* Empieza nodo:297 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(298)).setAttribute("nombre","lblCriterio" );
      ((Element)v.get(298)).setAttribute("alto","13" );
      ((Element)v.get(298)).setAttribute("filas","1" );
      ((Element)v.get(298)).setAttribute("valor","" );
      ((Element)v.get(298)).setAttribute("id","datosTitle" );
      ((Element)v.get(298)).setAttribute("cod","837" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:299 / Elemento padre: 286   */
   }

   private void getXML1260(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(300)).setAttribute("src","b.gif" );
      ((Element)v.get(300)).setAttribute("width","25" );
      ((Element)v.get(300)).setAttribute("height","8" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */
      /* Termina nodo:299   */

      /* Empieza nodo:301 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(302)).setAttribute("nombre","lblPromedio" );
      ((Element)v.get(302)).setAttribute("alto","13" );
      ((Element)v.get(302)).setAttribute("filas","1" );
      ((Element)v.get(302)).setAttribute("valor","" );
      ((Element)v.get(302)).setAttribute("id","datosTitle" );
      ((Element)v.get(302)).setAttribute("cod","3452" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:303 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(304)).setAttribute("src","b.gif" );
      ((Element)v.get(304)).setAttribute("width","25" );
      ((Element)v.get(304)).setAttribute("height","8" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */

      /* Empieza nodo:305 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(306)).setAttribute("nombre","lblUnidades" );
      ((Element)v.get(306)).setAttribute("alto","13" );
      ((Element)v.get(306)).setAttribute("filas","1" );
      ((Element)v.get(306)).setAttribute("valor","" );
      ((Element)v.get(306)).setAttribute("id","datosTitle" );
      ((Element)v.get(306)).setAttribute("cod","1179" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */

      /* Empieza nodo:307 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(307)).setAttribute("width","100%" );
      ((Element)v.get(286)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(308)).setAttribute("src","b.gif" );
      ((Element)v.get(308)).setAttribute("width","8" );
      ((Element)v.get(308)).setAttribute("height","8" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:307   */
      /* Termina nodo:286   */

      /* Empieza nodo:309 / Elemento padre: 285   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(285)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(311)).setAttribute("src","b.gif" );
      ((Element)v.get(311)).setAttribute("width","8" );
      ((Element)v.get(311)).setAttribute("height","8" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:312 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(313)).setAttribute("nombre","txtBaseDestinatarios" );
      ((Element)v.get(313)).setAttribute("id","datosCampos" );
      ((Element)v.get(313)).setAttribute("max","10" );
      ((Element)v.get(313)).setAttribute("tipo","" );
      ((Element)v.get(313)).setAttribute("onchange","" );
      ((Element)v.get(313)).setAttribute("req","N" );
      ((Element)v.get(313)).setAttribute("valor","" );
      ((Element)v.get(313)).setAttribute("size","12" );
      ((Element)v.get(313)).setAttribute("validacion","" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:312   */

      /* Empieza nodo:314 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(315)).setAttribute("src","b.gif" );
      ((Element)v.get(315)).setAttribute("width","25" );
      ((Element)v.get(315)).setAttribute("height","8" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:314   */

      /* Empieza nodo:316 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(317)).setAttribute("nombre","txtFactorCorreccion" );
      ((Element)v.get(317)).setAttribute("id","datosCampos" );
      ((Element)v.get(317)).setAttribute("max","17" );
      ((Element)v.get(317)).setAttribute("tipo","" );
      ((Element)v.get(317)).setAttribute("onchange","" );
      ((Element)v.get(317)).setAttribute("req","N" );
      ((Element)v.get(317)).setAttribute("valor","" );
      ((Element)v.get(317)).setAttribute("size","23" );
      ((Element)v.get(317)).setAttribute("validacion","" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:316   */

      /* Empieza nodo:318 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(319)).setAttribute("src","b.gif" );
      ((Element)v.get(319)).setAttribute("width","25" );
      ((Element)v.get(319)).setAttribute("height","8" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(318)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */
      /* Termina nodo:318   */

      /* Empieza nodo:320 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(321)).setAttribute("nombre","txtCriterio" );
      ((Element)v.get(321)).setAttribute("id","datosCampos" );
      ((Element)v.get(321)).setAttribute("max","20" );
      ((Element)v.get(321)).setAttribute("tipo","" );
      ((Element)v.get(321)).setAttribute("onchange","" );
      ((Element)v.get(321)).setAttribute("req","N" );
      ((Element)v.get(321)).setAttribute("valor","" );
      ((Element)v.get(321)).setAttribute("size","31" );
      ((Element)v.get(321)).setAttribute("validacion","" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:320   */

      /* Empieza nodo:322 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(323)).setAttribute("src","b.gif" );
      ((Element)v.get(323)).setAttribute("width","25" );
      ((Element)v.get(323)).setAttribute("height","8" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:324 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(325)).setAttribute("nombre","txtPromedio" );
      ((Element)v.get(325)).setAttribute("id","datosCampos" );
      ((Element)v.get(325)).setAttribute("max","13" );
      ((Element)v.get(325)).setAttribute("tipo","" );
      ((Element)v.get(325)).setAttribute("onchange","" );
      ((Element)v.get(325)).setAttribute("req","N" );
      ((Element)v.get(325)).setAttribute("valor","" );
      ((Element)v.get(325)).setAttribute("size","16" );
      ((Element)v.get(325)).setAttribute("validacion","" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:326 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(327)).setAttribute("src","b.gif" );
      ((Element)v.get(327)).setAttribute("width","25" );
      ((Element)v.get(327)).setAttribute("height","8" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:326   */

      /* Empieza nodo:328 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(329)).setAttribute("nombre","txtUnidades" );
      ((Element)v.get(329)).setAttribute("id","datosCampos" );
      ((Element)v.get(329)).setAttribute("max","10" );
      ((Element)v.get(329)).setAttribute("tipo","" );
      ((Element)v.get(329)).setAttribute("onchange","" );
      ((Element)v.get(329)).setAttribute("req","N" );
      ((Element)v.get(329)).setAttribute("valor","" );
      ((Element)v.get(329)).setAttribute("size","12" );
      ((Element)v.get(329)).setAttribute("validacion","" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:328   */

      /* Empieza nodo:330 / Elemento padre: 309   */
      v.add(doc.createElement("td"));
      ((Element)v.get(330)).setAttribute("width","100%" );
      ((Element)v.get(309)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(331)).setAttribute("src","b.gif" );
      ((Element)v.get(331)).setAttribute("width","8" );
      ((Element)v.get(331)).setAttribute("height","8" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */
      /* Termina nodo:309   */

      /* Empieza nodo:332 / Elemento padre: 285   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(285)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("td"));
      ((Element)v.get(333)).setAttribute("colspan","4" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(334)).setAttribute("src","b.gif" );
      ((Element)v.get(334)).setAttribute("width","8" );
      ((Element)v.get(334)).setAttribute("height","8" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */
      /* Termina nodo:332   */
      /* Termina nodo:285   */
      /* Termina nodo:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:335 / Elemento padre: 221   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(221)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("td"));
      ((Element)v.get(335)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("table"));
      ((Element)v.get(337)).setAttribute("width","714" );
      ((Element)v.get(337)).setAttribute("border","0" );
      ((Element)v.get(337)).setAttribute("align","left" );
      ((Element)v.get(337)).setAttribute("cellspacing","0" );
      ((Element)v.get(337)).setAttribute("cellpadding","0" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(337)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("td"));
      ((Element)v.get(338)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(340)).setAttribute("src","b.gif" );
      ((Element)v.get(340)).setAttribute("width","8" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(340)).setAttribute("height","8" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */

      /* Empieza nodo:341 / Elemento padre: 338   */
      v.add(doc.createElement("td"));
      ((Element)v.get(338)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(342)).setAttribute("nombre","lblObservaciones" );
      ((Element)v.get(342)).setAttribute("alto","13" );
      ((Element)v.get(342)).setAttribute("filas","1" );
      ((Element)v.get(342)).setAttribute("valor","" );
      ((Element)v.get(342)).setAttribute("id","datosTitle" );
      ((Element)v.get(342)).setAttribute("cod","169" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */

      /* Empieza nodo:343 / Elemento padre: 338   */
      v.add(doc.createElement("td"));
      ((Element)v.get(338)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(344)).setAttribute("src","b.gif" );
      ((Element)v.get(344)).setAttribute("width","25" );
      ((Element)v.get(344)).setAttribute("height","8" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:343   */

      /* Empieza nodo:345 / Elemento padre: 338   */
      v.add(doc.createElement("td"));
      ((Element)v.get(338)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(346)).setAttribute("nombre","lblCodVenta" );
      ((Element)v.get(346)).setAttribute("alto","13" );
      ((Element)v.get(346)).setAttribute("filas","1" );
      ((Element)v.get(346)).setAttribute("valor","" );
      ((Element)v.get(346)).setAttribute("id","datosTitle" );
      ((Element)v.get(346)).setAttribute("cod","336" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:345   */

      /* Empieza nodo:347 / Elemento padre: 338   */
      v.add(doc.createElement("td"));
      ((Element)v.get(347)).setAttribute("width","100%" );
      ((Element)v.get(338)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(348)).setAttribute("src","b.gif" );
      ((Element)v.get(348)).setAttribute("width","8" );
      ((Element)v.get(348)).setAttribute("height","8" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:347   */
      /* Termina nodo:338   */

      /* Empieza nodo:349 / Elemento padre: 337   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(337)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("td"));
      ((Element)v.get(349)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(351)).setAttribute("src","b.gif" );
      ((Element)v.get(351)).setAttribute("width","8" );
      ((Element)v.get(351)).setAttribute("height","8" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */
      /* Termina nodo:350   */

      /* Empieza nodo:352 / Elemento padre: 349   */
      v.add(doc.createElement("td"));
      ((Element)v.get(352)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(349)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(353)).setAttribute("cols","50" );
      ((Element)v.get(353)).setAttribute("id","datosCampos" );
      ((Element)v.get(353)).setAttribute("max","100" );
      ((Element)v.get(353)).setAttribute("nombre","atxtObservaciones" );
      ((Element)v.get(353)).setAttribute("readonly","N" );
      ((Element)v.get(353)).setAttribute("req","N" );
      ((Element)v.get(353)).setAttribute("rows","3" );
      ((Element)v.get(353)).setAttribute("tabindex","2" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */
      /* Termina nodo:352   */

      /* Empieza nodo:354 / Elemento padre: 349   */
      v.add(doc.createElement("td"));
      ((Element)v.get(349)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(355)).setAttribute("src","b.gif" );
      ((Element)v.get(355)).setAttribute("width","25" );
      ((Element)v.get(355)).setAttribute("height","8" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */
      /* Termina nodo:354   */

      /* Empieza nodo:356 / Elemento padre: 349   */
      v.add(doc.createElement("td"));
      ((Element)v.get(356)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(356)).setAttribute("valign","top" );
      ((Element)v.get(349)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(357)).setAttribute("nombre","txtCodVenta" );
      ((Element)v.get(357)).setAttribute("id","datosCampos" );
      ((Element)v.get(357)).setAttribute("max","12" );
      ((Element)v.get(357)).setAttribute("tipo","" );
      ((Element)v.get(357)).setAttribute("onchange","" );
      ((Element)v.get(357)).setAttribute("req","N" );
      ((Element)v.get(357)).setAttribute("valor","" );
      ((Element)v.get(357)).setAttribute("size","16" );
      ((Element)v.get(357)).setAttribute("validacion","" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */

      /* Empieza nodo:358 / Elemento padre: 349   */
      v.add(doc.createElement("td"));
      ((Element)v.get(358)).setAttribute("width","100%" );
      ((Element)v.get(349)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(359)).setAttribute("src","b.gif" );
      ((Element)v.get(359)).setAttribute("width","8" );
      ((Element)v.get(359)).setAttribute("height","8" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */
      /* Termina nodo:358   */
      /* Termina nodo:349   */

      /* Empieza nodo:360 / Elemento padre: 337   */
      v.add(doc.createElement("tr"));
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(337)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("td"));
      ((Element)v.get(361)).setAttribute("colspan","4" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(362)).setAttribute("src","b.gif" );
      ((Element)v.get(362)).setAttribute("width","8" );
      ((Element)v.get(362)).setAttribute("height","8" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:361   */
      /* Termina nodo:360   */
      /* Termina nodo:337   */
      /* Termina nodo:336   */
      /* Termina nodo:335   */
      /* Termina nodo:221   */
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:363 / Elemento padre: 214   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(364)).setAttribute("src","b.gif" );
      ((Element)v.get(364)).setAttribute("width","8" );
      ((Element)v.get(364)).setAttribute("height","12" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */
      /* Termina nodo:363   */
      /* Termina nodo:214   */

      /* Empieza nodo:365 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("td"));
      ((Element)v.get(366)).setAttribute("width","12" );
      ((Element)v.get(366)).setAttribute("align","center" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(367)).setAttribute("src","b.gif" );
      ((Element)v.get(367)).setAttribute("width","12" );
      ((Element)v.get(367)).setAttribute("height","15" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */
      /* Termina nodo:366   */

      /* Empieza nodo:368 / Elemento padre: 365   */
      v.add(doc.createElement("td"));
      ((Element)v.get(368)).setAttribute("width","750" );
      ((Element)v.get(365)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(369)).setAttribute("src","b.gif" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */

      /* Empieza nodo:370 / Elemento padre: 365   */
      v.add(doc.createElement("td"));
      ((Element)v.get(370)).setAttribute("width","12" );
      ((Element)v.get(365)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(371)).setAttribute("src","b.gif" );
      ((Element)v.get(371)).setAttribute("width","12" );
      ((Element)v.get(371)).setAttribute("height","15" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */
      /* Termina nodo:370   */
      /* Termina nodo:365   */

      /* Empieza nodo:372 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(372)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(374)).setAttribute("src","b.gif" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */
      /* Termina nodo:373   */

      /* Empieza nodo:375 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(372)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(375)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(377)).setAttribute("class","legend" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(378)).setAttribute("nombre","lblConfiguracionProductos" );
      ((Element)v.get(378)).setAttribute("alto","13" );
      ((Element)v.get(378)).setAttribute("filas","1" );
      ((Element)v.get(378)).setAttribute("valor","" );
      ((Element)v.get(378)).setAttribute("cod","00587" );
      ((Element)v.get(378)).setAttribute("id","legend" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:377   */

      /* Empieza nodo:379 / Elemento padre: 376   */
      v.add(doc.createElement("table"));
      ((Element)v.get(379)).setAttribute("width","100%" );
      ((Element)v.get(379)).setAttribute("border","0" );
      ((Element)v.get(379)).setAttribute("align","center" );
      ((Element)v.get(379)).setAttribute("cellspacing","0" );
      ((Element)v.get(379)).setAttribute("cellpadding","0" );
      ((Element)v.get(376)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(379)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("td"));
      ((Element)v.get(380)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("table"));
      ((Element)v.get(382)).setAttribute("width","714" );
      ((Element)v.get(382)).setAttribute("border","0" );
      ((Element)v.get(382)).setAttribute("align","left" );
      ((Element)v.get(382)).setAttribute("cellspacing","0" );
      ((Element)v.get(382)).setAttribute("cellpadding","0" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(382)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("td"));
      ((Element)v.get(384)).setAttribute("colspan","4" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(385)).setAttribute("src","b.gif" );
      ((Element)v.get(385)).setAttribute("width","8" );
      ((Element)v.get(385)).setAttribute("height","8" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(384)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */
      /* Termina nodo:384   */
      /* Termina nodo:383   */

      /* Empieza nodo:386 / Elemento padre: 382   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(382)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(388)).setAttribute("src","b.gif" );
      ((Element)v.get(388)).setAttribute("width","8" );
      ((Element)v.get(388)).setAttribute("height","8" );
      ((Element)v.get(387)).appendChild((Element)v.get(388));
      /* Termina nodo:388   */
      /* Termina nodo:387   */

      /* Empieza nodo:389 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(390)).setAttribute("nombre","lblPeriodoFin" );
      ((Element)v.get(390)).setAttribute("alto","13" );
      ((Element)v.get(390)).setAttribute("filas","1" );
      ((Element)v.get(390)).setAttribute("valor","" );
      ((Element)v.get(390)).setAttribute("id","datosTitle" );
      ((Element)v.get(390)).setAttribute("cod","967" );
      ((Element)v.get(389)).appendChild((Element)v.get(390));
      /* Termina nodo:390   */
      /* Termina nodo:389   */

      /* Empieza nodo:391 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(392)).setAttribute("src","b.gif" );
      ((Element)v.get(392)).setAttribute("width","25" );
      ((Element)v.get(392)).setAttribute("height","8" );
      ((Element)v.get(391)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */
      /* Termina nodo:391   */

      /* Empieza nodo:393 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(394)).setAttribute("nombre","lblPrecio" );
      ((Element)v.get(394)).setAttribute("alto","13" );
      ((Element)v.get(394)).setAttribute("filas","1" );
      ((Element)v.get(394)).setAttribute("valor","" );
      ((Element)v.get(394)).setAttribute("id","datosTitle" );
      ((Element)v.get(394)).setAttribute("cod","377" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */
      /* Termina nodo:393   */

      /* Empieza nodo:395 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(396)).setAttribute("src","b.gif" );
      ((Element)v.get(396)).setAttribute("width","25" );
      ((Element)v.get(396)).setAttribute("height","8" );
      ((Element)v.get(395)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */
      /* Termina nodo:395   */

      /* Empieza nodo:397 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(398)).setAttribute("nombre","lblPrecioEstandar" );
      ((Element)v.get(398)).setAttribute("alto","13" );
      ((Element)v.get(398)).setAttribute("filas","1" );
      ((Element)v.get(398)).setAttribute("valor","" );
      ((Element)v.get(398)).setAttribute("id","datosTitle" );
      ((Element)v.get(398)).setAttribute("cod","1370" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */
      /* Termina nodo:397   */

      /* Empieza nodo:399 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(400)).setAttribute("src","b.gif" );
      ((Element)v.get(400)).setAttribute("width","25" );
      ((Element)v.get(400)).setAttribute("height","8" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));
      /* Termina nodo:400   */
      /* Termina nodo:399   */

      /* Empieza nodo:401 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(402)).setAttribute("nombre","lblPrecioContable" );
      ((Element)v.get(402)).setAttribute("alto","13" );
      ((Element)v.get(402)).setAttribute("filas","1" );
      ((Element)v.get(402)).setAttribute("valor","" );
      ((Element)v.get(402)).setAttribute("id","datosTitle" );
      ((Element)v.get(402)).setAttribute("cod","974" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */
      /* Termina nodo:401   */

      /* Empieza nodo:403 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(403)).setAttribute("width","100%" );
      ((Element)v.get(386)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(404)).setAttribute("src","b.gif" );
      ((Element)v.get(404)).setAttribute("width","8" );
      ((Element)v.get(404)).setAttribute("height","8" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));
      /* Termina nodo:404   */
      /* Termina nodo:403   */
      /* Termina nodo:386   */

      /* Empieza nodo:405 / Elemento padre: 382   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(382)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("td"));
      ((Element)v.get(405)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(407)).setAttribute("src","b.gif" );
      ((Element)v.get(407)).setAttribute("width","8" );
      ((Element)v.get(407)).setAttribute("height","8" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */
      /* Termina nodo:406   */

      /* Empieza nodo:408 / Elemento padre: 405   */
      v.add(doc.createElement("td"));
      ((Element)v.get(408)).setAttribute("nowrap","nowrap" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(405)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(409)).setAttribute("nombre","cbPeriodoFin" );
      ((Element)v.get(409)).setAttribute("id","datosCampos" );
      ((Element)v.get(409)).setAttribute("size","1" );
      ((Element)v.get(409)).setAttribute("multiple","N" );
      ((Element)v.get(409)).setAttribute("req","N" );
      ((Element)v.get(409)).setAttribute("valorinicial","" );
      ((Element)v.get(409)).setAttribute("textoinicial","" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(409)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */
      /* Termina nodo:409   */
      /* Termina nodo:408   */

      /* Empieza nodo:411 / Elemento padre: 405   */
      v.add(doc.createElement("td"));
      ((Element)v.get(405)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(412)).setAttribute("src","b.gif" );
      ((Element)v.get(412)).setAttribute("width","25" );
      ((Element)v.get(412)).setAttribute("height","8" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */
      /* Termina nodo:411   */

      /* Empieza nodo:413 / Elemento padre: 405   */
      v.add(doc.createElement("td"));
      ((Element)v.get(413)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(405)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(414)).setAttribute("nombre","txtPrecio" );
      ((Element)v.get(414)).setAttribute("id","datosCampos" );
      ((Element)v.get(414)).setAttribute("max","" );
      ((Element)v.get(414)).setAttribute("tipo","16" );
      ((Element)v.get(414)).setAttribute("onchange","" );
      ((Element)v.get(414)).setAttribute("req","N" );
      ((Element)v.get(414)).setAttribute("valor","" );
      ((Element)v.get(414)).setAttribute("size","24" );
      ((Element)v.get(414)).setAttribute("validacion","" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */
      /* Termina nodo:413   */

      /* Empieza nodo:415 / Elemento padre: 405   */
      v.add(doc.createElement("td"));
      ((Element)v.get(405)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(416)).setAttribute("src","b.gif" );
      ((Element)v.get(416)).setAttribute("width","25" );
      ((Element)v.get(416)).setAttribute("height","8" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */
      /* Termina nodo:415   */

      /* Empieza nodo:417 / Elemento padre: 405   */
      v.add(doc.createElement("td"));
      ((Element)v.get(417)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(405)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(418)).setAttribute("nombre","txtPrecioEstandar" );
      ((Element)v.get(418)).setAttribute("id","datosCampos" );
      ((Element)v.get(418)).setAttribute("max","16" );
      ((Element)v.get(418)).setAttribute("tipo","" );
      ((Element)v.get(418)).setAttribute("onchange","" );
      ((Element)v.get(418)).setAttribute("req","N" );
      ((Element)v.get(418)).setAttribute("valor","" );
      ((Element)v.get(418)).setAttribute("size","24" );
      ((Element)v.get(418)).setAttribute("validacion","" );
      ((Element)v.get(417)).appendChild((Element)v.get(418));
      /* Termina nodo:418   */
      /* Termina nodo:417   */

      /* Empieza nodo:419 / Elemento padre: 405   */
      v.add(doc.createElement("td"));
      ((Element)v.get(405)).appendChild((Element)v.get(419));

      /* Empieza nodo:420 / Elemento padre: 419   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(420)).setAttribute("src","b.gif" );
      ((Element)v.get(420)).setAttribute("width","25" );
      ((Element)v.get(420)).setAttribute("height","8" );
      ((Element)v.get(419)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */
      /* Termina nodo:419   */

      /* Empieza nodo:421 / Elemento padre: 405   */
      v.add(doc.createElement("td"));
      ((Element)v.get(421)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(405)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(422)).setAttribute("nombre","txtPrecioContable" );
      ((Element)v.get(422)).setAttribute("id","datosCampos" );
      ((Element)v.get(422)).setAttribute("max","16" );
      ((Element)v.get(422)).setAttribute("tipo","" );
      ((Element)v.get(422)).setAttribute("onchange","" );
      ((Element)v.get(422)).setAttribute("req","N" );
      ((Element)v.get(422)).setAttribute("valor","" );
      ((Element)v.get(422)).setAttribute("size","24" );
      ((Element)v.get(422)).setAttribute("validacion","" );
      ((Element)v.get(421)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */
      /* Termina nodo:421   */

      /* Empieza nodo:423 / Elemento padre: 405   */
      v.add(doc.createElement("td"));
      ((Element)v.get(423)).setAttribute("width","100%" );
      ((Element)v.get(405)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(424)).setAttribute("src","b.gif" );
      ((Element)v.get(424)).setAttribute("width","8" );
      ((Element)v.get(424)).setAttribute("height","8" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */
      /* Termina nodo:423   */
      /* Termina nodo:405   */

      /* Empieza nodo:425 / Elemento padre: 382   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(382)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("td"));
      ((Element)v.get(426)).setAttribute("colspan","4" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(427)).setAttribute("src","b.gif" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(427)).setAttribute("width","8" );
      ((Element)v.get(427)).setAttribute("height","8" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */
      /* Termina nodo:426   */
      /* Termina nodo:425   */
      /* Termina nodo:382   */
      /* Termina nodo:381   */
      /* Termina nodo:380   */

      /* Empieza nodo:428 / Elemento padre: 379   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(379)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("td"));
      ((Element)v.get(428)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("table"));
      ((Element)v.get(430)).setAttribute("width","714" );
      ((Element)v.get(430)).setAttribute("border","0" );
      ((Element)v.get(430)).setAttribute("align","left" );
      ((Element)v.get(430)).setAttribute("cellspacing","0" );
      ((Element)v.get(430)).setAttribute("cellpadding","0" );
      ((Element)v.get(429)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(430)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("td"));
      ((Element)v.get(431)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(433)).setAttribute("src","b.gif" );
      ((Element)v.get(433)).setAttribute("width","8" );
      ((Element)v.get(433)).setAttribute("height","8" );
      ((Element)v.get(432)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */
      /* Termina nodo:432   */

      /* Empieza nodo:434 / Elemento padre: 431   */
      v.add(doc.createElement("td"));
      ((Element)v.get(431)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(435)).setAttribute("nombre","lblFormaCobro" );
      ((Element)v.get(435)).setAttribute("alto","13" );
      ((Element)v.get(435)).setAttribute("filas","1" );
      ((Element)v.get(435)).setAttribute("valor","" );
      ((Element)v.get(435)).setAttribute("id","datosTitle" );
      ((Element)v.get(435)).setAttribute("cod","884" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */
      /* Termina nodo:434   */

      /* Empieza nodo:436 / Elemento padre: 431   */
      v.add(doc.createElement("td"));
      ((Element)v.get(431)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(437)).setAttribute("src","b.gif" );
      ((Element)v.get(437)).setAttribute("width","25" );
      ((Element)v.get(437)).setAttribute("height","8" );
      ((Element)v.get(436)).appendChild((Element)v.get(437));
      /* Termina nodo:437   */
      /* Termina nodo:436   */

      /* Empieza nodo:438 / Elemento padre: 431   */
      v.add(doc.createElement("td"));
      ((Element)v.get(431)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(439)).setAttribute("nombre","lblFormaPago" );
      ((Element)v.get(439)).setAttribute("alto","13" );
      ((Element)v.get(439)).setAttribute("filas","1" );
      ((Element)v.get(439)).setAttribute("valor","" );
      ((Element)v.get(439)).setAttribute("id","datosTitle" );
      ((Element)v.get(439)).setAttribute("cod","541" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */
      /* Termina nodo:438   */

      /* Empieza nodo:440 / Elemento padre: 431   */
      v.add(doc.createElement("td"));
      ((Element)v.get(431)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(441)).setAttribute("src","b.gif" );
      ((Element)v.get(441)).setAttribute("width","25" );
      ((Element)v.get(441)).setAttribute("height","8" );
      ((Element)v.get(440)).appendChild((Element)v.get(441));
      /* Termina nodo:441   */
      /* Termina nodo:440   */

      /* Empieza nodo:442 / Elemento padre: 431   */
      v.add(doc.createElement("td"));
      ((Element)v.get(431)).appendChild((Element)v.get(442));

      /* Empieza nodo:443 / Elemento padre: 442   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(443)).setAttribute("nombre","lblTipoDespacho" );
      ((Element)v.get(443)).setAttribute("alto","13" );
      ((Element)v.get(443)).setAttribute("filas","1" );
      ((Element)v.get(443)).setAttribute("valor","" );
      ((Element)v.get(443)).setAttribute("id","datosTitle" );
      ((Element)v.get(443)).setAttribute("cod","1000" );
      ((Element)v.get(442)).appendChild((Element)v.get(443));
      /* Termina nodo:443   */
      /* Termina nodo:442   */

      /* Empieza nodo:444 / Elemento padre: 431   */
      v.add(doc.createElement("td"));
      ((Element)v.get(444)).setAttribute("width","100%" );
      ((Element)v.get(431)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(445)).setAttribute("src","b.gif" );
      ((Element)v.get(445)).setAttribute("width","8" );
      ((Element)v.get(445)).setAttribute("height","8" );
      ((Element)v.get(444)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */
      /* Termina nodo:444   */
      /* Termina nodo:431   */

      /* Empieza nodo:446 / Elemento padre: 430   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(430)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("td"));
      ((Element)v.get(446)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(448)).setAttribute("src","b.gif" );
      ((Element)v.get(448)).setAttribute("width","8" );
      ((Element)v.get(448)).setAttribute("height","8" );
      ((Element)v.get(447)).appendChild((Element)v.get(448));
      /* Termina nodo:448   */
      /* Termina nodo:447   */

      /* Empieza nodo:449 / Elemento padre: 446   */
      v.add(doc.createElement("td"));
      ((Element)v.get(449)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(446)).appendChild((Element)v.get(449));

      /* Empieza nodo:450 / Elemento padre: 449   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(450)).setAttribute("nombre","cbFormaCobro" );
      ((Element)v.get(450)).setAttribute("id","datosCampos" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(450)).setAttribute("size","1" );
      ((Element)v.get(450)).setAttribute("multiple","N" );
      ((Element)v.get(450)).setAttribute("req","S" );
      ((Element)v.get(450)).setAttribute("valorinicial","" );
      ((Element)v.get(450)).setAttribute("onchange","onchangeFormaCobro();" );
      ((Element)v.get(450)).setAttribute("textoinicial","" );
      ((Element)v.get(449)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(450)).appendChild((Element)v.get(451));
      /* Termina nodo:451   */
      /* Termina nodo:450   */
      /* Termina nodo:449   */

      /* Empieza nodo:452 / Elemento padre: 446   */
      v.add(doc.createElement("td"));
      ((Element)v.get(446)).appendChild((Element)v.get(452));

      /* Empieza nodo:453 / Elemento padre: 452   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(453)).setAttribute("src","b.gif" );
      ((Element)v.get(453)).setAttribute("width","25" );
      ((Element)v.get(453)).setAttribute("height","8" );
      ((Element)v.get(452)).appendChild((Element)v.get(453));
      /* Termina nodo:453   */
      /* Termina nodo:452   */

      /* Empieza nodo:454 / Elemento padre: 446   */
      v.add(doc.createElement("td"));
      ((Element)v.get(454)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(446)).appendChild((Element)v.get(454));

      /* Empieza nodo:455 / Elemento padre: 454   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(455)).setAttribute("nombre","cbFormaPago" );
      ((Element)v.get(455)).setAttribute("id","datosCampos" );
      ((Element)v.get(455)).setAttribute("size","1" );
      ((Element)v.get(455)).setAttribute("multiple","N" );
      ((Element)v.get(455)).setAttribute("req","S" );
      ((Element)v.get(455)).setAttribute("valorinicial","" );
      ((Element)v.get(455)).setAttribute("textoinicial","" );
      ((Element)v.get(454)).appendChild((Element)v.get(455));

      /* Empieza nodo:456 / Elemento padre: 455   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(455)).appendChild((Element)v.get(456));
      /* Termina nodo:456   */
      /* Termina nodo:455   */
      /* Termina nodo:454   */

      /* Empieza nodo:457 / Elemento padre: 446   */
      v.add(doc.createElement("td"));
      ((Element)v.get(446)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(458)).setAttribute("src","b.gif" );
      ((Element)v.get(458)).setAttribute("width","25" );
      ((Element)v.get(458)).setAttribute("height","8" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */
      /* Termina nodo:457   */

      /* Empieza nodo:459 / Elemento padre: 446   */
      v.add(doc.createElement("td"));
      ((Element)v.get(459)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(446)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(460)).setAttribute("nombre","cbTipoDespacho" );
      ((Element)v.get(460)).setAttribute("onchange","cambiaDespacho('noDetalle');" );
      ((Element)v.get(460)).setAttribute("id","datosCampos" );
      ((Element)v.get(460)).setAttribute("size","1" );
      ((Element)v.get(460)).setAttribute("multiple","N" );
      ((Element)v.get(460)).setAttribute("req","S" );
      ((Element)v.get(460)).setAttribute("valorinicial","" );
      ((Element)v.get(460)).setAttribute("textoinicial","" );
      ((Element)v.get(459)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(460)).appendChild((Element)v.get(461));
      /* Termina nodo:461   */
      /* Termina nodo:460   */
      /* Termina nodo:459   */

      /* Empieza nodo:462 / Elemento padre: 446   */
      v.add(doc.createElement("td"));
      ((Element)v.get(462)).setAttribute("width","100%" );
      ((Element)v.get(446)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(463)).setAttribute("src","b.gif" );
      ((Element)v.get(463)).setAttribute("width","8" );
      ((Element)v.get(463)).setAttribute("height","8" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */
      /* Termina nodo:462   */
      /* Termina nodo:446   */

      /* Empieza nodo:464 / Elemento padre: 430   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(430)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("td"));
      ((Element)v.get(465)).setAttribute("colspan","4" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(466)).setAttribute("src","b.gif" );
      ((Element)v.get(466)).setAttribute("width","8" );
      ((Element)v.get(466)).setAttribute("height","8" );
      ((Element)v.get(465)).appendChild((Element)v.get(466));
      /* Termina nodo:466   */
      /* Termina nodo:465   */
      /* Termina nodo:464   */
      /* Termina nodo:430   */
      /* Termina nodo:429   */
      /* Termina nodo:428   */

      /* Empieza nodo:467 / Elemento padre: 379   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(379)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("td"));
      ((Element)v.get(467)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("table"));
      ((Element)v.get(469)).setAttribute("width","714" );
      ((Element)v.get(469)).setAttribute("border","0" );
      ((Element)v.get(469)).setAttribute("align","left" );
      ((Element)v.get(469)).setAttribute("cellspacing","0" );
      ((Element)v.get(469)).setAttribute("cellpadding","0" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));

      /* Empieza nodo:470 / Elemento padre: 469   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(469)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("td"));
      ((Element)v.get(470)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(472)).setAttribute("src","b.gif" );
      ((Element)v.get(472)).setAttribute("width","8" );
      ((Element)v.get(472)).setAttribute("height","8" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));
      /* Termina nodo:472   */
      /* Termina nodo:471   */

      /* Empieza nodo:473 / Elemento padre: 470   */
   }

   private void getXML1980(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(470)).appendChild((Element)v.get(473));

      /* Empieza nodo:474 / Elemento padre: 473   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(474)).setAttribute("nombre","lblEnvioSolicitud" );
      ((Element)v.get(474)).setAttribute("alto","13" );
      ((Element)v.get(474)).setAttribute("filas","1" );
      ((Element)v.get(474)).setAttribute("valor","" );
      ((Element)v.get(474)).setAttribute("id","datosTitle" );
      ((Element)v.get(474)).setAttribute("cod","859" );
      ((Element)v.get(473)).appendChild((Element)v.get(474));
      /* Termina nodo:474   */
      /* Termina nodo:473   */

      /* Empieza nodo:475 / Elemento padre: 470   */
      v.add(doc.createElement("td"));
      ((Element)v.get(475)).setAttribute("width","100%" );
      ((Element)v.get(470)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(476)).setAttribute("src","b.gif" );
      ((Element)v.get(476)).setAttribute("width","8" );
      ((Element)v.get(476)).setAttribute("height","8" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */
      /* Termina nodo:475   */
      /* Termina nodo:470   */

      /* Empieza nodo:477 / Elemento padre: 469   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(469)).appendChild((Element)v.get(477));

      /* Empieza nodo:478 / Elemento padre: 477   */
      v.add(doc.createElement("td"));
      ((Element)v.get(477)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(479)).setAttribute("src","b.gif" );
      ((Element)v.get(479)).setAttribute("width","8" );
      ((Element)v.get(479)).setAttribute("height","8" );
      ((Element)v.get(478)).appendChild((Element)v.get(479));
      /* Termina nodo:479   */
      /* Termina nodo:478   */

      /* Empieza nodo:480 / Elemento padre: 477   */
      v.add(doc.createElement("td"));
      ((Element)v.get(480)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(477)).appendChild((Element)v.get(480));

      /* Empieza nodo:481 / Elemento padre: 480   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(481)).setAttribute("nombre","cbEnvioSolicitud" );
      ((Element)v.get(481)).setAttribute("id","datosCampos" );
      ((Element)v.get(481)).setAttribute("size","1" );
      ((Element)v.get(481)).setAttribute("multiple","N" );
      ((Element)v.get(481)).setAttribute("req","N" );
      ((Element)v.get(481)).setAttribute("valorinicial","" );
      ((Element)v.get(481)).setAttribute("textoinicial","" );
      ((Element)v.get(480)).appendChild((Element)v.get(481));

      /* Empieza nodo:482 / Elemento padre: 481   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(481)).appendChild((Element)v.get(482));
      /* Termina nodo:482   */
      /* Termina nodo:481   */
      /* Termina nodo:480   */

      /* Empieza nodo:483 / Elemento padre: 477   */
      v.add(doc.createElement("td"));
      ((Element)v.get(483)).setAttribute("width","100%" );
      ((Element)v.get(477)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(484)).setAttribute("src","b.gif" );
      ((Element)v.get(484)).setAttribute("width","8" );
      ((Element)v.get(484)).setAttribute("height","8" );
      ((Element)v.get(483)).appendChild((Element)v.get(484));
      /* Termina nodo:484   */
      /* Termina nodo:483   */
      /* Termina nodo:477   */

      /* Empieza nodo:485 / Elemento padre: 469   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(469)).appendChild((Element)v.get(485));

      /* Empieza nodo:486 / Elemento padre: 485   */
      v.add(doc.createElement("td"));
      ((Element)v.get(486)).setAttribute("colspan","4" );
      ((Element)v.get(485)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(487)).setAttribute("src","b.gif" );
      ((Element)v.get(487)).setAttribute("width","8" );
      ((Element)v.get(487)).setAttribute("height","8" );
      ((Element)v.get(486)).appendChild((Element)v.get(487));
      /* Termina nodo:487   */
      /* Termina nodo:486   */
      /* Termina nodo:485   */
      /* Termina nodo:469   */
      /* Termina nodo:468   */
      /* Termina nodo:467   */
      /* Termina nodo:379   */
      /* Termina nodo:376   */
      /* Termina nodo:375   */

      /* Empieza nodo:488 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(372)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(489)).setAttribute("src","b.gif" );
      ((Element)v.get(489)).setAttribute("width","8" );
      ((Element)v.get(489)).setAttribute("height","12" );
      ((Element)v.get(488)).appendChild((Element)v.get(489));
      /* Termina nodo:489   */
      /* Termina nodo:488   */
      /* Termina nodo:372   */

      /* Empieza nodo:490 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("td"));
      ((Element)v.get(491)).setAttribute("width","12" );
      ((Element)v.get(491)).setAttribute("align","center" );
      ((Element)v.get(490)).appendChild((Element)v.get(491));

      /* Empieza nodo:492 / Elemento padre: 491   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(492)).setAttribute("src","b.gif" );
      ((Element)v.get(492)).setAttribute("width","12" );
      ((Element)v.get(492)).setAttribute("height","15" );
      ((Element)v.get(491)).appendChild((Element)v.get(492));
      /* Termina nodo:492   */
      /* Termina nodo:491   */

      /* Empieza nodo:493 / Elemento padre: 490   */
      v.add(doc.createElement("td"));
      ((Element)v.get(493)).setAttribute("width","750" );
      ((Element)v.get(490)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(494)).setAttribute("src","b.gif" );
      ((Element)v.get(493)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */
      /* Termina nodo:493   */

      /* Empieza nodo:495 / Elemento padre: 490   */
      v.add(doc.createElement("td"));
      ((Element)v.get(495)).setAttribute("width","12" );
      ((Element)v.get(490)).appendChild((Element)v.get(495));

      /* Empieza nodo:496 / Elemento padre: 495   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(496)).setAttribute("src","b.gif" );
      ((Element)v.get(496)).setAttribute("width","12" );
      ((Element)v.get(496)).setAttribute("height","15" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(495)).appendChild((Element)v.get(496));
      /* Termina nodo:496   */
      /* Termina nodo:495   */
      /* Termina nodo:490   */

      /* Empieza nodo:497 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
      v.add(doc.createElement("td"));
      ((Element)v.get(497)).appendChild((Element)v.get(498));

      /* Empieza nodo:499 / Elemento padre: 498   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(499)).setAttribute("src","b.gif" );
      ((Element)v.get(498)).appendChild((Element)v.get(499));
      /* Termina nodo:499   */
      /* Termina nodo:498   */

      /* Empieza nodo:500 / Elemento padre: 497   */
      v.add(doc.createElement("td"));
      ((Element)v.get(497)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(500)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(502)).setAttribute("class","legend" );
      ((Element)v.get(501)).appendChild((Element)v.get(502));

      /* Empieza nodo:503 / Elemento padre: 502   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(503)).setAttribute("nombre","lblAlcanceEnvío" );
      ((Element)v.get(503)).setAttribute("alto","13" );
      ((Element)v.get(503)).setAttribute("filas","1" );
      ((Element)v.get(503)).setAttribute("valor","" );
      ((Element)v.get(503)).setAttribute("cod","00608" );
      ((Element)v.get(503)).setAttribute("id","legend" );
      ((Element)v.get(502)).appendChild((Element)v.get(503));
      /* Termina nodo:503   */
      /* Termina nodo:502   */

      /* Empieza nodo:504 / Elemento padre: 501   */
      v.add(doc.createElement("table"));
      ((Element)v.get(504)).setAttribute("width","100%" );
      ((Element)v.get(504)).setAttribute("border","0" );
      ((Element)v.get(504)).setAttribute("align","center" );
      ((Element)v.get(504)).setAttribute("cellspacing","0" );
      ((Element)v.get(504)).setAttribute("cellpadding","0" );
      ((Element)v.get(501)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(504)).appendChild((Element)v.get(505));

      /* Empieza nodo:506 / Elemento padre: 505   */
      v.add(doc.createElement("td"));
      ((Element)v.get(505)).appendChild((Element)v.get(506));

      /* Empieza nodo:507 / Elemento padre: 506   */
      v.add(doc.createElement("table"));
      ((Element)v.get(507)).setAttribute("width","714" );
      ((Element)v.get(507)).setAttribute("border","0" );
      ((Element)v.get(507)).setAttribute("align","left" );
      ((Element)v.get(507)).setAttribute("cellspacing","0" );
      ((Element)v.get(507)).setAttribute("cellpadding","0" );
      ((Element)v.get(506)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(507)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("td"));
      ((Element)v.get(509)).setAttribute("colspan","4" );
      ((Element)v.get(508)).appendChild((Element)v.get(509));

      /* Empieza nodo:510 / Elemento padre: 509   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(510)).setAttribute("src","b.gif" );
      ((Element)v.get(510)).setAttribute("width","8" );
      ((Element)v.get(510)).setAttribute("height","8" );
      ((Element)v.get(509)).appendChild((Element)v.get(510));
      /* Termina nodo:510   */
      /* Termina nodo:509   */
      /* Termina nodo:508   */

      /* Empieza nodo:511 / Elemento padre: 507   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(507)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
      v.add(doc.createElement("td"));
      ((Element)v.get(511)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(513)).setAttribute("src","b.gif" );
      ((Element)v.get(513)).setAttribute("width","8" );
      ((Element)v.get(513)).setAttribute("height","8" );
      ((Element)v.get(512)).appendChild((Element)v.get(513));
      /* Termina nodo:513   */
      /* Termina nodo:512   */

      /* Empieza nodo:514 / Elemento padre: 511   */
      v.add(doc.createElement("td"));
      ((Element)v.get(511)).appendChild((Element)v.get(514));

      /* Empieza nodo:515 / Elemento padre: 514   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(515)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(515)).setAttribute("alto","13" );
      ((Element)v.get(515)).setAttribute("filas","1" );
      ((Element)v.get(515)).setAttribute("valor","" );
      ((Element)v.get(515)).setAttribute("id","datosTitle" );
      ((Element)v.get(515)).setAttribute("cod","10" );
      ((Element)v.get(514)).appendChild((Element)v.get(515));
      /* Termina nodo:515   */
      /* Termina nodo:514   */

      /* Empieza nodo:516 / Elemento padre: 511   */
      v.add(doc.createElement("td"));
      ((Element)v.get(511)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(517)).setAttribute("src","b.gif" );
      ((Element)v.get(517)).setAttribute("width","25" );
      ((Element)v.get(517)).setAttribute("height","8" );
      ((Element)v.get(516)).appendChild((Element)v.get(517));
      /* Termina nodo:517   */
      /* Termina nodo:516   */

      /* Empieza nodo:518 / Elemento padre: 511   */
      v.add(doc.createElement("td"));
      ((Element)v.get(511)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(519)).setAttribute("nombre","lblSubacceso" );
      ((Element)v.get(519)).setAttribute("alto","13" );
      ((Element)v.get(519)).setAttribute("filas","1" );
      ((Element)v.get(519)).setAttribute("valor","" );
      ((Element)v.get(519)).setAttribute("id","datosTitle" );
      ((Element)v.get(519)).setAttribute("cod","122" );
      ((Element)v.get(518)).appendChild((Element)v.get(519));
      /* Termina nodo:519   */
      /* Termina nodo:518   */

      /* Empieza nodo:520 / Elemento padre: 511   */
      v.add(doc.createElement("td"));
      ((Element)v.get(520)).setAttribute("width","100%" );
      ((Element)v.get(511)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
   }

   private void getXML2160(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(521)).setAttribute("src","b.gif" );
      ((Element)v.get(521)).setAttribute("width","8" );
      ((Element)v.get(521)).setAttribute("height","8" );
      ((Element)v.get(520)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */
      /* Termina nodo:520   */
      /* Termina nodo:511   */

      /* Empieza nodo:522 / Elemento padre: 507   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(507)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("td"));
      ((Element)v.get(522)).appendChild((Element)v.get(523));

      /* Empieza nodo:524 / Elemento padre: 523   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(524)).setAttribute("src","b.gif" );
      ((Element)v.get(524)).setAttribute("width","8" );
      ((Element)v.get(524)).setAttribute("height","8" );
      ((Element)v.get(523)).appendChild((Element)v.get(524));
      /* Termina nodo:524   */
      /* Termina nodo:523   */

      /* Empieza nodo:525 / Elemento padre: 522   */
      v.add(doc.createElement("td"));
      ((Element)v.get(525)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(522)).appendChild((Element)v.get(525));

      /* Empieza nodo:526 / Elemento padre: 525   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(526)).setAttribute("nombre","cbAcceso" );
      ((Element)v.get(526)).setAttribute("id","datosCampos" );
      ((Element)v.get(526)).setAttribute("onchange","cambiaAcceso();" );
      ((Element)v.get(526)).setAttribute("size","5" );
      ((Element)v.get(526)).setAttribute("multiple","S" );
      ((Element)v.get(526)).setAttribute("req","S" );
      ((Element)v.get(526)).setAttribute("valorinicial","" );
      ((Element)v.get(526)).setAttribute("textoinicial","" );
      ((Element)v.get(525)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(526)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */
      /* Termina nodo:526   */
      /* Termina nodo:525   */

      /* Empieza nodo:528 / Elemento padre: 522   */
      v.add(doc.createElement("td"));
      ((Element)v.get(522)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(529)).setAttribute("src","b.gif" );
      ((Element)v.get(529)).setAttribute("width","25" );
      ((Element)v.get(529)).setAttribute("height","8" );
      ((Element)v.get(528)).appendChild((Element)v.get(529));
      /* Termina nodo:529   */
      /* Termina nodo:528   */

      /* Empieza nodo:530 / Elemento padre: 522   */
      v.add(doc.createElement("td"));
      ((Element)v.get(530)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(522)).appendChild((Element)v.get(530));

      /* Empieza nodo:531 / Elemento padre: 530   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(531)).setAttribute("nombre","cbSubacceso" );
      ((Element)v.get(531)).setAttribute("id","datosCampos" );
      ((Element)v.get(531)).setAttribute("size","5" );
      ((Element)v.get(531)).setAttribute("multiple","S" );
      ((Element)v.get(531)).setAttribute("req","S" );
      ((Element)v.get(531)).setAttribute("valorinicial","" );
      ((Element)v.get(531)).setAttribute("textoinicial","" );
      ((Element)v.get(530)).appendChild((Element)v.get(531));

      /* Empieza nodo:532 / Elemento padre: 531   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(531)).appendChild((Element)v.get(532));
      /* Termina nodo:532   */
      /* Termina nodo:531   */
      /* Termina nodo:530   */

      /* Empieza nodo:533 / Elemento padre: 522   */
      v.add(doc.createElement("td"));
      ((Element)v.get(533)).setAttribute("width","100%" );
      ((Element)v.get(522)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(534)).setAttribute("src","b.gif" );
      ((Element)v.get(534)).setAttribute("width","8" );
      ((Element)v.get(534)).setAttribute("height","8" );
      ((Element)v.get(533)).appendChild((Element)v.get(534));
      /* Termina nodo:534   */
      /* Termina nodo:533   */
      /* Termina nodo:522   */

      /* Empieza nodo:535 / Elemento padre: 507   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(507)).appendChild((Element)v.get(535));

      /* Empieza nodo:536 / Elemento padre: 535   */
      v.add(doc.createElement("td"));
      ((Element)v.get(536)).setAttribute("colspan","4" );
      ((Element)v.get(535)).appendChild((Element)v.get(536));

      /* Empieza nodo:537 / Elemento padre: 536   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(537)).setAttribute("src","b.gif" );
      ((Element)v.get(537)).setAttribute("width","8" );
      ((Element)v.get(537)).setAttribute("height","8" );
      ((Element)v.get(536)).appendChild((Element)v.get(537));
      /* Termina nodo:537   */
      /* Termina nodo:536   */
      /* Termina nodo:535   */
      /* Termina nodo:507   */
      /* Termina nodo:506   */
      /* Termina nodo:505   */

      /* Empieza nodo:538 / Elemento padre: 504   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(504)).appendChild((Element)v.get(538));

      /* Empieza nodo:539 / Elemento padre: 538   */
      v.add(doc.createElement("td"));
      ((Element)v.get(538)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("table"));
      ((Element)v.get(540)).setAttribute("width","714" );
      ((Element)v.get(540)).setAttribute("border","0" );
      ((Element)v.get(540)).setAttribute("align","left" );
      ((Element)v.get(540)).setAttribute("cellspacing","0" );
      ((Element)v.get(540)).setAttribute("cellpadding","0" );
      ((Element)v.get(539)).appendChild((Element)v.get(540));

      /* Empieza nodo:541 / Elemento padre: 540   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(540)).appendChild((Element)v.get(541));

      /* Empieza nodo:542 / Elemento padre: 541   */
      v.add(doc.createElement("td"));
      ((Element)v.get(542)).setAttribute("colspan","4" );
      ((Element)v.get(541)).appendChild((Element)v.get(542));

      /* Empieza nodo:543 / Elemento padre: 542   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(543)).setAttribute("src","b.gif" );
      ((Element)v.get(543)).setAttribute("width","8" );
      ((Element)v.get(543)).setAttribute("height","8" );
      ((Element)v.get(542)).appendChild((Element)v.get(543));
      /* Termina nodo:543   */
      /* Termina nodo:542   */
      /* Termina nodo:541   */

      /* Empieza nodo:544 / Elemento padre: 540   */
      v.add(doc.createElement("tr"));
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(540)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("td"));
      ((Element)v.get(544)).appendChild((Element)v.get(545));

      /* Empieza nodo:546 / Elemento padre: 545   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(546)).setAttribute("src","b.gif" );
      ((Element)v.get(546)).setAttribute("width","8" );
      ((Element)v.get(546)).setAttribute("height","8" );
      ((Element)v.get(545)).appendChild((Element)v.get(546));
      /* Termina nodo:546   */
      /* Termina nodo:545   */

      /* Empieza nodo:547 / Elemento padre: 544   */
      v.add(doc.createElement("td"));
      ((Element)v.get(544)).appendChild((Element)v.get(547));

      /* Empieza nodo:548 / Elemento padre: 547   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(548)).setAttribute("nombre","lblSubgerencia" );
      ((Element)v.get(548)).setAttribute("alto","13" );
      ((Element)v.get(548)).setAttribute("filas","1" );
      ((Element)v.get(548)).setAttribute("valor","" );
      ((Element)v.get(548)).setAttribute("id","datosTitle" );
      ((Element)v.get(548)).setAttribute("cod","992" );
      ((Element)v.get(547)).appendChild((Element)v.get(548));
      /* Termina nodo:548   */
      /* Termina nodo:547   */

      /* Empieza nodo:549 / Elemento padre: 544   */
      v.add(doc.createElement("td"));
      ((Element)v.get(544)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(550)).setAttribute("src","b.gif" );
      ((Element)v.get(550)).setAttribute("width","25" );
      ((Element)v.get(550)).setAttribute("height","8" );
      ((Element)v.get(549)).appendChild((Element)v.get(550));
      /* Termina nodo:550   */
      /* Termina nodo:549   */

      /* Empieza nodo:551 / Elemento padre: 544   */
      v.add(doc.createElement("td"));
      ((Element)v.get(544)).appendChild((Element)v.get(551));

      /* Empieza nodo:552 / Elemento padre: 551   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(552)).setAttribute("nombre","lblRegion" );
      ((Element)v.get(552)).setAttribute("alto","13" );
      ((Element)v.get(552)).setAttribute("filas","1" );
      ((Element)v.get(552)).setAttribute("valor","" );
      ((Element)v.get(552)).setAttribute("id","datosTitle" );
      ((Element)v.get(552)).setAttribute("cod","109" );
      ((Element)v.get(551)).appendChild((Element)v.get(552));
      /* Termina nodo:552   */
      /* Termina nodo:551   */

      /* Empieza nodo:553 / Elemento padre: 544   */
      v.add(doc.createElement("td"));
      ((Element)v.get(553)).setAttribute("width","100%" );
      ((Element)v.get(544)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(554)).setAttribute("src","b.gif" );
      ((Element)v.get(554)).setAttribute("width","8" );
      ((Element)v.get(554)).setAttribute("height","8" );
      ((Element)v.get(553)).appendChild((Element)v.get(554));
      /* Termina nodo:554   */
      /* Termina nodo:553   */
      /* Termina nodo:544   */

      /* Empieza nodo:555 / Elemento padre: 540   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(540)).appendChild((Element)v.get(555));

      /* Empieza nodo:556 / Elemento padre: 555   */
      v.add(doc.createElement("td"));
      ((Element)v.get(555)).appendChild((Element)v.get(556));

      /* Empieza nodo:557 / Elemento padre: 556   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(557)).setAttribute("src","b.gif" );
      ((Element)v.get(557)).setAttribute("width","8" );
      ((Element)v.get(557)).setAttribute("height","8" );
      ((Element)v.get(556)).appendChild((Element)v.get(557));
      /* Termina nodo:557   */
      /* Termina nodo:556   */

      /* Empieza nodo:558 / Elemento padre: 555   */
      v.add(doc.createElement("td"));
      ((Element)v.get(558)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(555)).appendChild((Element)v.get(558));

      /* Empieza nodo:559 / Elemento padre: 558   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(559)).setAttribute("nombre","cbSubgerencia" );
      ((Element)v.get(559)).setAttribute("id","datosCampos" );
      ((Element)v.get(559)).setAttribute("onchange","cambiaRegion();" );
      ((Element)v.get(559)).setAttribute("size","5" );
      ((Element)v.get(559)).setAttribute("multiple","S" );
      ((Element)v.get(559)).setAttribute("req","N" );
      ((Element)v.get(559)).setAttribute("valorinicial","" );
      ((Element)v.get(559)).setAttribute("textoinicial","" );
      ((Element)v.get(558)).appendChild((Element)v.get(559));

      /* Empieza nodo:560 / Elemento padre: 559   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(559)).appendChild((Element)v.get(560));
      /* Termina nodo:560   */
      /* Termina nodo:559   */
      /* Termina nodo:558   */

      /* Empieza nodo:561 / Elemento padre: 555   */
      v.add(doc.createElement("td"));
      ((Element)v.get(555)).appendChild((Element)v.get(561));

      /* Empieza nodo:562 / Elemento padre: 561   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(562)).setAttribute("src","b.gif" );
      ((Element)v.get(562)).setAttribute("width","25" );
      ((Element)v.get(562)).setAttribute("height","8" );
      ((Element)v.get(561)).appendChild((Element)v.get(562));
      /* Termina nodo:562   */
      /* Termina nodo:561   */

      /* Empieza nodo:563 / Elemento padre: 555   */
      v.add(doc.createElement("td"));
      ((Element)v.get(563)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(555)).appendChild((Element)v.get(563));

      /* Empieza nodo:564 / Elemento padre: 563   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(564)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(564)).setAttribute("id","datosCampos" );
      ((Element)v.get(564)).setAttribute("onchange","cambiaZona();" );
      ((Element)v.get(564)).setAttribute("size","5" );
      ((Element)v.get(564)).setAttribute("multiple","S" );
      ((Element)v.get(564)).setAttribute("req","N" );
      ((Element)v.get(564)).setAttribute("valorinicial","" );
      ((Element)v.get(564)).setAttribute("textoinicial","" );
      ((Element)v.get(563)).appendChild((Element)v.get(564));

      /* Empieza nodo:565 / Elemento padre: 564   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(564)).appendChild((Element)v.get(565));
      /* Termina nodo:565   */
      /* Termina nodo:564   */
      /* Termina nodo:563   */

      /* Empieza nodo:566 / Elemento padre: 555   */
      v.add(doc.createElement("td"));
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(566)).setAttribute("width","100%" );
      ((Element)v.get(555)).appendChild((Element)v.get(566));

      /* Empieza nodo:567 / Elemento padre: 566   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(567)).setAttribute("src","b.gif" );
      ((Element)v.get(567)).setAttribute("width","8" );
      ((Element)v.get(567)).setAttribute("height","8" );
      ((Element)v.get(566)).appendChild((Element)v.get(567));
      /* Termina nodo:567   */
      /* Termina nodo:566   */
      /* Termina nodo:555   */

      /* Empieza nodo:568 / Elemento padre: 540   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(540)).appendChild((Element)v.get(568));

      /* Empieza nodo:569 / Elemento padre: 568   */
      v.add(doc.createElement("td"));
      ((Element)v.get(569)).setAttribute("colspan","4" );
      ((Element)v.get(568)).appendChild((Element)v.get(569));

      /* Empieza nodo:570 / Elemento padre: 569   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(570)).setAttribute("src","b.gif" );
      ((Element)v.get(570)).setAttribute("width","8" );
      ((Element)v.get(570)).setAttribute("height","8" );
      ((Element)v.get(569)).appendChild((Element)v.get(570));
      /* Termina nodo:570   */
      /* Termina nodo:569   */
      /* Termina nodo:568   */
      /* Termina nodo:540   */
      /* Termina nodo:539   */
      /* Termina nodo:538   */

      /* Empieza nodo:571 / Elemento padre: 504   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(504)).appendChild((Element)v.get(571));

      /* Empieza nodo:572 / Elemento padre: 571   */
      v.add(doc.createElement("td"));
      ((Element)v.get(571)).appendChild((Element)v.get(572));

      /* Empieza nodo:573 / Elemento padre: 572   */
      v.add(doc.createElement("table"));
      ((Element)v.get(573)).setAttribute("width","714" );
      ((Element)v.get(573)).setAttribute("border","0" );
      ((Element)v.get(573)).setAttribute("align","left" );
      ((Element)v.get(573)).setAttribute("cellspacing","0" );
      ((Element)v.get(573)).setAttribute("cellpadding","0" );
      ((Element)v.get(572)).appendChild((Element)v.get(573));

      /* Empieza nodo:574 / Elemento padre: 573   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(573)).appendChild((Element)v.get(574));

      /* Empieza nodo:575 / Elemento padre: 574   */
      v.add(doc.createElement("td"));
      ((Element)v.get(574)).appendChild((Element)v.get(575));

      /* Empieza nodo:576 / Elemento padre: 575   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(576)).setAttribute("src","b.gif" );
      ((Element)v.get(576)).setAttribute("width","8" );
      ((Element)v.get(576)).setAttribute("height","8" );
      ((Element)v.get(575)).appendChild((Element)v.get(576));
      /* Termina nodo:576   */
      /* Termina nodo:575   */

      /* Empieza nodo:577 / Elemento padre: 574   */
      v.add(doc.createElement("td"));
      ((Element)v.get(574)).appendChild((Element)v.get(577));

      /* Empieza nodo:578 / Elemento padre: 577   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(578)).setAttribute("nombre","lblZona" );
      ((Element)v.get(578)).setAttribute("alto","13" );
      ((Element)v.get(578)).setAttribute("filas","1" );
      ((Element)v.get(578)).setAttribute("valor","" );
      ((Element)v.get(578)).setAttribute("id","datosTitle" );
      ((Element)v.get(578)).setAttribute("cod","143" );
      ((Element)v.get(577)).appendChild((Element)v.get(578));
      /* Termina nodo:578   */
      /* Termina nodo:577   */

      /* Empieza nodo:579 / Elemento padre: 574   */
      v.add(doc.createElement("td"));
      ((Element)v.get(579)).setAttribute("width","100%" );
      ((Element)v.get(574)).appendChild((Element)v.get(579));

      /* Empieza nodo:580 / Elemento padre: 579   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(580)).setAttribute("src","b.gif" );
      ((Element)v.get(580)).setAttribute("width","8" );
      ((Element)v.get(580)).setAttribute("height","8" );
      ((Element)v.get(579)).appendChild((Element)v.get(580));
      /* Termina nodo:580   */
      /* Termina nodo:579   */
      /* Termina nodo:574   */

      /* Empieza nodo:581 / Elemento padre: 573   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(573)).appendChild((Element)v.get(581));

      /* Empieza nodo:582 / Elemento padre: 581   */
      v.add(doc.createElement("td"));
      ((Element)v.get(581)).appendChild((Element)v.get(582));

      /* Empieza nodo:583 / Elemento padre: 582   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(583)).setAttribute("src","b.gif" );
      ((Element)v.get(583)).setAttribute("width","8" );
      ((Element)v.get(583)).setAttribute("height","8" );
      ((Element)v.get(582)).appendChild((Element)v.get(583));
      /* Termina nodo:583   */
      /* Termina nodo:582   */

      /* Empieza nodo:584 / Elemento padre: 581   */
      v.add(doc.createElement("td"));
      ((Element)v.get(584)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(581)).appendChild((Element)v.get(584));

      /* Empieza nodo:585 / Elemento padre: 584   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(585)).setAttribute("nombre","cbZona" );
      ((Element)v.get(585)).setAttribute("id","datosCampos" );
      ((Element)v.get(585)).setAttribute("size","5" );
      ((Element)v.get(585)).setAttribute("multiple","S" );
      ((Element)v.get(585)).setAttribute("req","N" );
      ((Element)v.get(585)).setAttribute("valorinicial","" );
      ((Element)v.get(585)).setAttribute("textoinicial","" );
      ((Element)v.get(584)).appendChild((Element)v.get(585));

      /* Empieza nodo:586 / Elemento padre: 585   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(585)).appendChild((Element)v.get(586));
      /* Termina nodo:586   */
      /* Termina nodo:585   */
      /* Termina nodo:584   */

      /* Empieza nodo:587 / Elemento padre: 581   */
      v.add(doc.createElement("td"));
      ((Element)v.get(587)).setAttribute("width","100%" );
      ((Element)v.get(581)).appendChild((Element)v.get(587));

      /* Empieza nodo:588 / Elemento padre: 587   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(588)).setAttribute("src","b.gif" );
      ((Element)v.get(588)).setAttribute("width","8" );
      ((Element)v.get(588)).setAttribute("height","8" );
      ((Element)v.get(587)).appendChild((Element)v.get(588));
      /* Termina nodo:588   */
      /* Termina nodo:587   */
      /* Termina nodo:581   */

      /* Empieza nodo:589 / Elemento padre: 573   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(573)).appendChild((Element)v.get(589));

      /* Empieza nodo:590 / Elemento padre: 589   */
      v.add(doc.createElement("td"));
      ((Element)v.get(590)).setAttribute("colspan","4" );
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(589)).appendChild((Element)v.get(590));

      /* Empieza nodo:591 / Elemento padre: 590   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(591)).setAttribute("src","b.gif" );
      ((Element)v.get(591)).setAttribute("width","8" );
      ((Element)v.get(591)).setAttribute("height","8" );
      ((Element)v.get(590)).appendChild((Element)v.get(591));
      /* Termina nodo:591   */
      /* Termina nodo:590   */
      /* Termina nodo:589   */
      /* Termina nodo:573   */
      /* Termina nodo:572   */
      /* Termina nodo:571   */

      /* Empieza nodo:592 / Elemento padre: 504   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(504)).appendChild((Element)v.get(592));

      /* Empieza nodo:593 / Elemento padre: 592   */
      v.add(doc.createElement("td"));
      ((Element)v.get(592)).appendChild((Element)v.get(593));

      /* Empieza nodo:594 / Elemento padre: 593   */
      v.add(doc.createElement("table"));
      ((Element)v.get(594)).setAttribute("width","714" );
      ((Element)v.get(594)).setAttribute("border","0" );
      ((Element)v.get(594)).setAttribute("align","left" );
      ((Element)v.get(594)).setAttribute("cellspacing","0" );
      ((Element)v.get(594)).setAttribute("cellpadding","0" );
      ((Element)v.get(593)).appendChild((Element)v.get(594));

      /* Empieza nodo:595 / Elemento padre: 594   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(594)).appendChild((Element)v.get(595));

      /* Empieza nodo:596 / Elemento padre: 595   */
      v.add(doc.createElement("td"));
      ((Element)v.get(595)).appendChild((Element)v.get(596));

      /* Empieza nodo:597 / Elemento padre: 596   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(597)).setAttribute("src","b.gif" );
      ((Element)v.get(597)).setAttribute("width","8" );
      ((Element)v.get(597)).setAttribute("height","8" );
      ((Element)v.get(596)).appendChild((Element)v.get(597));
      /* Termina nodo:597   */
      /* Termina nodo:596   */

      /* Empieza nodo:598 / Elemento padre: 595   */
      v.add(doc.createElement("td"));
      ((Element)v.get(595)).appendChild((Element)v.get(598));

      /* Empieza nodo:599 / Elemento padre: 598   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(599)).setAttribute("nombre","lblSubtipoCliente" );
      ((Element)v.get(599)).setAttribute("alto","13" );
      ((Element)v.get(599)).setAttribute("filas","1" );
      ((Element)v.get(599)).setAttribute("valor","" );
      ((Element)v.get(599)).setAttribute("id","datosTitle" );
      ((Element)v.get(599)).setAttribute("cod","595" );
      ((Element)v.get(598)).appendChild((Element)v.get(599));
      /* Termina nodo:599   */
      /* Termina nodo:598   */

      /* Empieza nodo:600 / Elemento padre: 595   */
      v.add(doc.createElement("td"));
      ((Element)v.get(595)).appendChild((Element)v.get(600));

      /* Empieza nodo:601 / Elemento padre: 600   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(601)).setAttribute("src","b.gif" );
      ((Element)v.get(601)).setAttribute("width","25" );
      ((Element)v.get(601)).setAttribute("height","8" );
      ((Element)v.get(600)).appendChild((Element)v.get(601));
      /* Termina nodo:601   */
      /* Termina nodo:600   */

      /* Empieza nodo:602 / Elemento padre: 595   */
      v.add(doc.createElement("td"));
      ((Element)v.get(595)).appendChild((Element)v.get(602));

      /* Empieza nodo:603 / Elemento padre: 602   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(603)).setAttribute("nombre","lblTipoClasificacionCliente" );
      ((Element)v.get(603)).setAttribute("alto","13" );
      ((Element)v.get(603)).setAttribute("filas","1" );
      ((Element)v.get(603)).setAttribute("valor","" );
      ((Element)v.get(603)).setAttribute("id","datosTitle" );
      ((Element)v.get(603)).setAttribute("cod","610" );
      ((Element)v.get(602)).appendChild((Element)v.get(603));
      /* Termina nodo:603   */
      /* Termina nodo:602   */

      /* Empieza nodo:604 / Elemento padre: 595   */
      v.add(doc.createElement("td"));
      ((Element)v.get(604)).setAttribute("width","100%" );
      ((Element)v.get(595)).appendChild((Element)v.get(604));

      /* Empieza nodo:605 / Elemento padre: 604   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(605)).setAttribute("src","b.gif" );
      ((Element)v.get(605)).setAttribute("width","8" );
      ((Element)v.get(605)).setAttribute("height","8" );
      ((Element)v.get(604)).appendChild((Element)v.get(605));
      /* Termina nodo:605   */
      /* Termina nodo:604   */
      /* Termina nodo:595   */

      /* Empieza nodo:606 / Elemento padre: 594   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(594)).appendChild((Element)v.get(606));

      /* Empieza nodo:607 / Elemento padre: 606   */
      v.add(doc.createElement("td"));
      ((Element)v.get(606)).appendChild((Element)v.get(607));

      /* Empieza nodo:608 / Elemento padre: 607   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(608)).setAttribute("src","b.gif" );
      ((Element)v.get(608)).setAttribute("width","8" );
      ((Element)v.get(608)).setAttribute("height","8" );
      ((Element)v.get(607)).appendChild((Element)v.get(608));
      /* Termina nodo:608   */
      /* Termina nodo:607   */

      /* Empieza nodo:609 / Elemento padre: 606   */
      v.add(doc.createElement("td"));
      ((Element)v.get(609)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(606)).appendChild((Element)v.get(609));

      /* Empieza nodo:610 / Elemento padre: 609   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(610)).setAttribute("nombre","cbSubtipoCliente" );
      ((Element)v.get(610)).setAttribute("onchange","cambiaTiposClasificacion();" );
      ((Element)v.get(610)).setAttribute("id","datosCampos" );
      ((Element)v.get(610)).setAttribute("size","1" );
      ((Element)v.get(610)).setAttribute("multiple","N" );
      ((Element)v.get(610)).setAttribute("req","N" );
      ((Element)v.get(610)).setAttribute("valorinicial","" );
      ((Element)v.get(610)).setAttribute("textoinicial","" );
      ((Element)v.get(609)).appendChild((Element)v.get(610));

      /* Empieza nodo:611 / Elemento padre: 610   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(610)).appendChild((Element)v.get(611));
      /* Termina nodo:611   */
      /* Termina nodo:610   */
      /* Termina nodo:609   */

      /* Empieza nodo:612 / Elemento padre: 606   */
      v.add(doc.createElement("td"));
      ((Element)v.get(606)).appendChild((Element)v.get(612));

      /* Empieza nodo:613 / Elemento padre: 612   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(613)).setAttribute("src","b.gif" );
      ((Element)v.get(613)).setAttribute("width","25" );
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(613)).setAttribute("height","8" );
      ((Element)v.get(612)).appendChild((Element)v.get(613));
      /* Termina nodo:613   */
      /* Termina nodo:612   */

      /* Empieza nodo:614 / Elemento padre: 606   */
      v.add(doc.createElement("td"));
      ((Element)v.get(614)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(606)).appendChild((Element)v.get(614));

      /* Empieza nodo:615 / Elemento padre: 614   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(615)).setAttribute("nombre","cbTipoClasificacionCliente" );
      ((Element)v.get(615)).setAttribute("onchange","cambiaClasificaciones();" );
      ((Element)v.get(615)).setAttribute("id","datosCampos" );
      ((Element)v.get(615)).setAttribute("size","1" );
      ((Element)v.get(615)).setAttribute("multiple","N" );
      ((Element)v.get(615)).setAttribute("req","N" );
      ((Element)v.get(615)).setAttribute("valorinicial","" );
      ((Element)v.get(615)).setAttribute("textoinicial","" );
      ((Element)v.get(614)).appendChild((Element)v.get(615));

      /* Empieza nodo:616 / Elemento padre: 615   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(615)).appendChild((Element)v.get(616));
      /* Termina nodo:616   */
      /* Termina nodo:615   */
      /* Termina nodo:614   */

      /* Empieza nodo:617 / Elemento padre: 606   */
      v.add(doc.createElement("td"));
      ((Element)v.get(617)).setAttribute("width","100%" );
      ((Element)v.get(606)).appendChild((Element)v.get(617));

      /* Empieza nodo:618 / Elemento padre: 617   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(618)).setAttribute("src","b.gif" );
      ((Element)v.get(618)).setAttribute("width","8" );
      ((Element)v.get(618)).setAttribute("height","8" );
      ((Element)v.get(617)).appendChild((Element)v.get(618));
      /* Termina nodo:618   */
      /* Termina nodo:617   */
      /* Termina nodo:606   */

      /* Empieza nodo:619 / Elemento padre: 594   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(594)).appendChild((Element)v.get(619));

      /* Empieza nodo:620 / Elemento padre: 619   */
      v.add(doc.createElement("td"));
      ((Element)v.get(620)).setAttribute("colspan","4" );
      ((Element)v.get(619)).appendChild((Element)v.get(620));

      /* Empieza nodo:621 / Elemento padre: 620   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(621)).setAttribute("src","b.gif" );
      ((Element)v.get(621)).setAttribute("width","8" );
      ((Element)v.get(621)).setAttribute("height","8" );
      ((Element)v.get(620)).appendChild((Element)v.get(621));
      /* Termina nodo:621   */
      /* Termina nodo:620   */
      /* Termina nodo:619   */
      /* Termina nodo:594   */
      /* Termina nodo:593   */
      /* Termina nodo:592   */

      /* Empieza nodo:622 / Elemento padre: 504   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(504)).appendChild((Element)v.get(622));

      /* Empieza nodo:623 / Elemento padre: 622   */
      v.add(doc.createElement("td"));
      ((Element)v.get(622)).appendChild((Element)v.get(623));

      /* Empieza nodo:624 / Elemento padre: 623   */
      v.add(doc.createElement("table"));
      ((Element)v.get(624)).setAttribute("width","714" );
      ((Element)v.get(624)).setAttribute("border","0" );
      ((Element)v.get(624)).setAttribute("align","left" );
      ((Element)v.get(624)).setAttribute("cellspacing","0" );
      ((Element)v.get(624)).setAttribute("cellpadding","0" );
      ((Element)v.get(623)).appendChild((Element)v.get(624));

      /* Empieza nodo:625 / Elemento padre: 624   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(624)).appendChild((Element)v.get(625));

      /* Empieza nodo:626 / Elemento padre: 625   */
      v.add(doc.createElement("td"));
      ((Element)v.get(625)).appendChild((Element)v.get(626));

      /* Empieza nodo:627 / Elemento padre: 626   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(627)).setAttribute("src","b.gif" );
      ((Element)v.get(627)).setAttribute("width","8" );
      ((Element)v.get(627)).setAttribute("height","8" );
      ((Element)v.get(626)).appendChild((Element)v.get(627));
      /* Termina nodo:627   */
      /* Termina nodo:626   */

      /* Empieza nodo:628 / Elemento padre: 625   */
      v.add(doc.createElement("td"));
      ((Element)v.get(625)).appendChild((Element)v.get(628));

      /* Empieza nodo:629 / Elemento padre: 628   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(629)).setAttribute("nombre","lblClasificacionCliente" );
      ((Element)v.get(629)).setAttribute("alto","13" );
      ((Element)v.get(629)).setAttribute("filas","1" );
      ((Element)v.get(629)).setAttribute("valor","" );
      ((Element)v.get(629)).setAttribute("id","datosTitle" );
      ((Element)v.get(629)).setAttribute("cod","611" );
      ((Element)v.get(628)).appendChild((Element)v.get(629));
      /* Termina nodo:629   */
      /* Termina nodo:628   */

      /* Empieza nodo:630 / Elemento padre: 625   */
      v.add(doc.createElement("td"));
      ((Element)v.get(625)).appendChild((Element)v.get(630));

      /* Empieza nodo:631 / Elemento padre: 630   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(631)).setAttribute("src","b.gif" );
      ((Element)v.get(631)).setAttribute("width","25" );
      ((Element)v.get(631)).setAttribute("height","8" );
      ((Element)v.get(630)).appendChild((Element)v.get(631));
      /* Termina nodo:631   */
      /* Termina nodo:630   */

      /* Empieza nodo:632 / Elemento padre: 625   */
      v.add(doc.createElement("td"));
      ((Element)v.get(625)).appendChild((Element)v.get(632));

      /* Empieza nodo:633 / Elemento padre: 632   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(633)).setAttribute("nombre","lblEstado" );
      ((Element)v.get(633)).setAttribute("alto","13" );
      ((Element)v.get(633)).setAttribute("filas","1" );
      ((Element)v.get(633)).setAttribute("valor","" );
      ((Element)v.get(633)).setAttribute("id","datosTitle" );
      ((Element)v.get(633)).setAttribute("cod","400" );
      ((Element)v.get(632)).appendChild((Element)v.get(633));
      /* Termina nodo:633   */
      /* Termina nodo:632   */

      /* Empieza nodo:634 / Elemento padre: 625   */
      v.add(doc.createElement("td"));
      ((Element)v.get(634)).setAttribute("width","100%" );
      ((Element)v.get(625)).appendChild((Element)v.get(634));

      /* Empieza nodo:635 / Elemento padre: 634   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(635)).setAttribute("src","b.gif" );
      ((Element)v.get(635)).setAttribute("width","8" );
      ((Element)v.get(635)).setAttribute("height","8" );
      ((Element)v.get(634)).appendChild((Element)v.get(635));
      /* Termina nodo:635   */
      /* Termina nodo:634   */
      /* Termina nodo:625   */

      /* Empieza nodo:636 / Elemento padre: 624   */
   }

   private void getXML2610(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(624)).appendChild((Element)v.get(636));

      /* Empieza nodo:637 / Elemento padre: 636   */
      v.add(doc.createElement("td"));
      ((Element)v.get(636)).appendChild((Element)v.get(637));

      /* Empieza nodo:638 / Elemento padre: 637   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(638)).setAttribute("src","b.gif" );
      ((Element)v.get(638)).setAttribute("width","8" );
      ((Element)v.get(638)).setAttribute("height","8" );
      ((Element)v.get(637)).appendChild((Element)v.get(638));
      /* Termina nodo:638   */
      /* Termina nodo:637   */

      /* Empieza nodo:639 / Elemento padre: 636   */
      v.add(doc.createElement("td"));
      ((Element)v.get(639)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(636)).appendChild((Element)v.get(639));

      /* Empieza nodo:640 / Elemento padre: 639   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(640)).setAttribute("nombre","cbClasificacionCliente" );
      ((Element)v.get(640)).setAttribute("id","datosCampos" );
      ((Element)v.get(640)).setAttribute("size","1" );
      ((Element)v.get(640)).setAttribute("multiple","N" );
      ((Element)v.get(640)).setAttribute("req","N" );
      ((Element)v.get(640)).setAttribute("valorinicial","" );
      ((Element)v.get(640)).setAttribute("textoinicial","" );
      ((Element)v.get(639)).appendChild((Element)v.get(640));

      /* Empieza nodo:641 / Elemento padre: 640   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(640)).appendChild((Element)v.get(641));
      /* Termina nodo:641   */
      /* Termina nodo:640   */
      /* Termina nodo:639   */

      /* Empieza nodo:642 / Elemento padre: 636   */
      v.add(doc.createElement("td"));
      ((Element)v.get(636)).appendChild((Element)v.get(642));

      /* Empieza nodo:643 / Elemento padre: 642   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(643)).setAttribute("src","b.gif" );
      ((Element)v.get(643)).setAttribute("width","25" );
      ((Element)v.get(643)).setAttribute("height","8" );
      ((Element)v.get(642)).appendChild((Element)v.get(643));
      /* Termina nodo:643   */
      /* Termina nodo:642   */

      /* Empieza nodo:644 / Elemento padre: 636   */
      v.add(doc.createElement("td"));
      ((Element)v.get(644)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(636)).appendChild((Element)v.get(644));

      /* Empieza nodo:645 / Elemento padre: 644   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(645)).setAttribute("nombre","cbEstado" );
      ((Element)v.get(645)).setAttribute("id","datosCampos" );
      ((Element)v.get(645)).setAttribute("size","1" );
      ((Element)v.get(645)).setAttribute("multiple","N" );
      ((Element)v.get(645)).setAttribute("req","N" );
      ((Element)v.get(645)).setAttribute("valorinicial","" );
      ((Element)v.get(645)).setAttribute("textoinicial","" );
      ((Element)v.get(644)).appendChild((Element)v.get(645));

      /* Empieza nodo:646 / Elemento padre: 645   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(645)).appendChild((Element)v.get(646));
      /* Termina nodo:646   */
      /* Termina nodo:645   */
      /* Termina nodo:644   */

      /* Empieza nodo:647 / Elemento padre: 636   */
      v.add(doc.createElement("td"));
      ((Element)v.get(647)).setAttribute("width","100%" );
      ((Element)v.get(636)).appendChild((Element)v.get(647));

      /* Empieza nodo:648 / Elemento padre: 647   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(648)).setAttribute("src","b.gif" );
      ((Element)v.get(648)).setAttribute("width","8" );
      ((Element)v.get(648)).setAttribute("height","8" );
      ((Element)v.get(647)).appendChild((Element)v.get(648));
      /* Termina nodo:648   */
      /* Termina nodo:647   */
      /* Termina nodo:636   */

      /* Empieza nodo:649 / Elemento padre: 624   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(624)).appendChild((Element)v.get(649));

      /* Empieza nodo:650 / Elemento padre: 649   */
      v.add(doc.createElement("td"));
      ((Element)v.get(650)).setAttribute("colspan","4" );
      ((Element)v.get(649)).appendChild((Element)v.get(650));

      /* Empieza nodo:651 / Elemento padre: 650   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(651)).setAttribute("src","b.gif" );
      ((Element)v.get(651)).setAttribute("width","8" );
      ((Element)v.get(651)).setAttribute("height","8" );
      ((Element)v.get(650)).appendChild((Element)v.get(651));
      /* Termina nodo:651   */
      /* Termina nodo:650   */
      /* Termina nodo:649   */
      /* Termina nodo:624   */
      /* Termina nodo:623   */
      /* Termina nodo:622   */
      /* Termina nodo:504   */
      /* Termina nodo:501   */
      /* Termina nodo:500   */

      /* Empieza nodo:652 / Elemento padre: 497   */
      v.add(doc.createElement("td"));
      ((Element)v.get(497)).appendChild((Element)v.get(652));

      /* Empieza nodo:653 / Elemento padre: 652   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(653)).setAttribute("src","b.gif" );
      ((Element)v.get(653)).setAttribute("width","8" );
      ((Element)v.get(653)).setAttribute("height","12" );
      ((Element)v.get(652)).appendChild((Element)v.get(653));
      /* Termina nodo:653   */
      /* Termina nodo:652   */
      /* Termina nodo:497   */

      /* Empieza nodo:654 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(654));

      /* Empieza nodo:655 / Elemento padre: 654   */
      v.add(doc.createElement("td"));
      ((Element)v.get(654)).appendChild((Element)v.get(655));

      /* Empieza nodo:656 / Elemento padre: 655   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(656)).setAttribute("src","b.gif" );
      ((Element)v.get(655)).appendChild((Element)v.get(656));
      /* Termina nodo:656   */
      /* Termina nodo:655   */

      /* Empieza nodo:657 / Elemento padre: 654   */
      v.add(doc.createElement("td"));
      ((Element)v.get(654)).appendChild((Element)v.get(657));

      /* Empieza nodo:658 / Elemento padre: 657   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(657)).appendChild((Element)v.get(658));

      /* Empieza nodo:659 / Elemento padre: 658   */
      v.add(doc.createElement("table"));
      ((Element)v.get(659)).setAttribute("width","100%" );
      ((Element)v.get(659)).setAttribute("border","0" );
      ((Element)v.get(659)).setAttribute("align","center" );
      ((Element)v.get(659)).setAttribute("cellspacing","0" );
      ((Element)v.get(659)).setAttribute("cellpadding","0" );
      ((Element)v.get(658)).appendChild((Element)v.get(659));

      /* Empieza nodo:660 / Elemento padre: 659   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(659)).appendChild((Element)v.get(660));

      /* Empieza nodo:661 / Elemento padre: 660   */
      v.add(doc.createElement("td"));
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(661)).setAttribute("class","botonera" );
      ((Element)v.get(660)).appendChild((Element)v.get(661));

      /* Empieza nodo:662 / Elemento padre: 661   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(662)).setAttribute("nombre","btnListaClientes" );
      ((Element)v.get(662)).setAttribute("ID","botonContenido" );
      ((Element)v.get(662)).setAttribute("tipo","html" );
      ((Element)v.get(662)).setAttribute("accion","listaClientes();" );
      ((Element)v.get(662)).setAttribute("estado","false" );
      ((Element)v.get(662)).setAttribute("cod","1375" );
      ((Element)v.get(661)).appendChild((Element)v.get(662));
      /* Termina nodo:662   */
      /* Termina nodo:661   */
      /* Termina nodo:660   */
      /* Termina nodo:659   */
      /* Termina nodo:658   */
      /* Termina nodo:657   */

      /* Empieza nodo:663 / Elemento padre: 654   */
      v.add(doc.createElement("td"));
      ((Element)v.get(654)).appendChild((Element)v.get(663));

      /* Empieza nodo:664 / Elemento padre: 663   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(664)).setAttribute("src","b.gif" );
      ((Element)v.get(664)).setAttribute("width","8" );
      ((Element)v.get(664)).setAttribute("height","12" );
      ((Element)v.get(663)).appendChild((Element)v.get(664));
      /* Termina nodo:664   */
      /* Termina nodo:663   */
      /* Termina nodo:654   */

      /* Empieza nodo:665 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(665));

      /* Empieza nodo:666 / Elemento padre: 665   */
      v.add(doc.createElement("td"));
      ((Element)v.get(666)).setAttribute("width","12" );
      ((Element)v.get(666)).setAttribute("align","center" );
      ((Element)v.get(665)).appendChild((Element)v.get(666));

      /* Empieza nodo:667 / Elemento padre: 666   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(667)).setAttribute("src","b.gif" );
      ((Element)v.get(667)).setAttribute("width","12" );
      ((Element)v.get(667)).setAttribute("height","15" );
      ((Element)v.get(666)).appendChild((Element)v.get(667));
      /* Termina nodo:667   */
      /* Termina nodo:666   */

      /* Empieza nodo:668 / Elemento padre: 665   */
      v.add(doc.createElement("td"));
      ((Element)v.get(668)).setAttribute("width","750" );
      ((Element)v.get(665)).appendChild((Element)v.get(668));

      /* Empieza nodo:669 / Elemento padre: 668   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(669)).setAttribute("src","b.gif" );
      ((Element)v.get(668)).appendChild((Element)v.get(669));
      /* Termina nodo:669   */
      /* Termina nodo:668   */

      /* Empieza nodo:670 / Elemento padre: 665   */
      v.add(doc.createElement("td"));
      ((Element)v.get(670)).setAttribute("width","12" );
      ((Element)v.get(665)).appendChild((Element)v.get(670));

      /* Empieza nodo:671 / Elemento padre: 670   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(671)).setAttribute("src","b.gif" );
      ((Element)v.get(671)).setAttribute("width","12" );
      ((Element)v.get(671)).setAttribute("height","15" );
      ((Element)v.get(670)).appendChild((Element)v.get(671));
      /* Termina nodo:671   */
      /* Termina nodo:670   */
      /* Termina nodo:665   */

      /* Empieza nodo:672 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(672));

      /* Empieza nodo:673 / Elemento padre: 672   */
      v.add(doc.createElement("td"));
      ((Element)v.get(672)).appendChild((Element)v.get(673));

      /* Empieza nodo:674 / Elemento padre: 673   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(674)).setAttribute("src","b.gif" );
      ((Element)v.get(673)).appendChild((Element)v.get(674));
      /* Termina nodo:674   */
      /* Termina nodo:673   */

      /* Empieza nodo:675 / Elemento padre: 672   */
      v.add(doc.createElement("td"));
      ((Element)v.get(672)).appendChild((Element)v.get(675));

      /* Empieza nodo:676 / Elemento padre: 675   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(675)).appendChild((Element)v.get(676));

      /* Empieza nodo:677 / Elemento padre: 676   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(677)).setAttribute("class","legend" );
      ((Element)v.get(676)).appendChild((Element)v.get(677));

      /* Empieza nodo:678 / Elemento padre: 677   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(678)).setAttribute("nombre","lblCriteriosAsignacion" );
      ((Element)v.get(678)).setAttribute("alto","13" );
      ((Element)v.get(678)).setAttribute("filas","1" );
      ((Element)v.get(678)).setAttribute("valor","" );
      ((Element)v.get(678)).setAttribute("cod","0033" );
      ((Element)v.get(678)).setAttribute("id","legend" );
      ((Element)v.get(677)).appendChild((Element)v.get(678));
      /* Termina nodo:678   */
      /* Termina nodo:677   */

      /* Empieza nodo:679 / Elemento padre: 676   */
      v.add(doc.createElement("table"));
      ((Element)v.get(679)).setAttribute("width","100%" );
      ((Element)v.get(679)).setAttribute("border","0" );
      ((Element)v.get(679)).setAttribute("align","center" );
      ((Element)v.get(679)).setAttribute("cellspacing","0" );
      ((Element)v.get(679)).setAttribute("cellpadding","0" );
      ((Element)v.get(676)).appendChild((Element)v.get(679));

      /* Empieza nodo:680 / Elemento padre: 679   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(679)).appendChild((Element)v.get(680));

      /* Empieza nodo:681 / Elemento padre: 680   */
      v.add(doc.createElement("td"));
      ((Element)v.get(680)).appendChild((Element)v.get(681));

      /* Empieza nodo:682 / Elemento padre: 681   */
      v.add(doc.createElement("table"));
      ((Element)v.get(682)).setAttribute("width","714" );
      ((Element)v.get(682)).setAttribute("border","0" );
      ((Element)v.get(682)).setAttribute("align","left" );
      ((Element)v.get(682)).setAttribute("cellspacing","0" );
      ((Element)v.get(682)).setAttribute("cellpadding","0" );
      ((Element)v.get(681)).appendChild((Element)v.get(682));

      /* Empieza nodo:683 / Elemento padre: 682   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(682)).appendChild((Element)v.get(683));

      /* Empieza nodo:684 / Elemento padre: 683   */
      v.add(doc.createElement("td"));
      ((Element)v.get(684)).setAttribute("colspan","4" );
      ((Element)v.get(683)).appendChild((Element)v.get(684));

      /* Empieza nodo:685 / Elemento padre: 684   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(685)).setAttribute("src","b.gif" );
      ((Element)v.get(685)).setAttribute("width","8" );
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(685)).setAttribute("height","8" );
      ((Element)v.get(684)).appendChild((Element)v.get(685));
      /* Termina nodo:685   */
      /* Termina nodo:684   */
      /* Termina nodo:683   */

      /* Empieza nodo:686 / Elemento padre: 682   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(682)).appendChild((Element)v.get(686));

      /* Empieza nodo:687 / Elemento padre: 686   */
      v.add(doc.createElement("td"));
      ((Element)v.get(686)).appendChild((Element)v.get(687));

      /* Empieza nodo:688 / Elemento padre: 687   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(688)).setAttribute("src","b.gif" );
      ((Element)v.get(688)).setAttribute("width","8" );
      ((Element)v.get(688)).setAttribute("height","8" );
      ((Element)v.get(687)).appendChild((Element)v.get(688));
      /* Termina nodo:688   */
      /* Termina nodo:687   */

      /* Empieza nodo:689 / Elemento padre: 686   */
      v.add(doc.createElement("td"));
      ((Element)v.get(686)).appendChild((Element)v.get(689));

      /* Empieza nodo:690 / Elemento padre: 689   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(690)).setAttribute("nombre","lblCriterioAsignacion" );
      ((Element)v.get(690)).setAttribute("alto","13" );
      ((Element)v.get(690)).setAttribute("filas","1" );
      ((Element)v.get(690)).setAttribute("valor","" );
      ((Element)v.get(690)).setAttribute("id","datosTitle" );
      ((Element)v.get(690)).setAttribute("cod","838" );
      ((Element)v.get(689)).appendChild((Element)v.get(690));
      /* Termina nodo:690   */
      /* Termina nodo:689   */

      /* Empieza nodo:691 / Elemento padre: 686   */
      v.add(doc.createElement("td"));
      ((Element)v.get(691)).setAttribute("width","100%" );
      ((Element)v.get(686)).appendChild((Element)v.get(691));

      /* Empieza nodo:692 / Elemento padre: 691   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(692)).setAttribute("src","b.gif" );
      ((Element)v.get(692)).setAttribute("width","8" );
      ((Element)v.get(692)).setAttribute("height","8" );
      ((Element)v.get(691)).appendChild((Element)v.get(692));
      /* Termina nodo:692   */
      /* Termina nodo:691   */
      /* Termina nodo:686   */

      /* Empieza nodo:693 / Elemento padre: 682   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(682)).appendChild((Element)v.get(693));

      /* Empieza nodo:694 / Elemento padre: 693   */
      v.add(doc.createElement("td"));
      ((Element)v.get(693)).appendChild((Element)v.get(694));

      /* Empieza nodo:695 / Elemento padre: 694   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(695)).setAttribute("src","b.gif" );
      ((Element)v.get(695)).setAttribute("width","8" );
      ((Element)v.get(695)).setAttribute("height","8" );
      ((Element)v.get(694)).appendChild((Element)v.get(695));
      /* Termina nodo:695   */
      /* Termina nodo:694   */

      /* Empieza nodo:696 / Elemento padre: 693   */
      v.add(doc.createElement("td"));
      ((Element)v.get(696)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(693)).appendChild((Element)v.get(696));

      /* Empieza nodo:697 / Elemento padre: 696   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(697)).setAttribute("nombre","cbCriterioAsignacion" );
      ((Element)v.get(697)).setAttribute("onchange","onchangeCriterioAsignacion();" );
      ((Element)v.get(697)).setAttribute("id","datosCampos" );
      ((Element)v.get(697)).setAttribute("size","1" );
      ((Element)v.get(697)).setAttribute("multiple","N" );
      ((Element)v.get(697)).setAttribute("req","N" );
      ((Element)v.get(697)).setAttribute("valorinicial","" );
      ((Element)v.get(697)).setAttribute("textoinicial","" );
      ((Element)v.get(696)).appendChild((Element)v.get(697));

      /* Empieza nodo:698 / Elemento padre: 697   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(697)).appendChild((Element)v.get(698));
      /* Termina nodo:698   */
      /* Termina nodo:697   */
      /* Termina nodo:696   */

      /* Empieza nodo:699 / Elemento padre: 693   */
      v.add(doc.createElement("td"));
      ((Element)v.get(699)).setAttribute("width","100%" );
      ((Element)v.get(693)).appendChild((Element)v.get(699));

      /* Empieza nodo:700 / Elemento padre: 699   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(700)).setAttribute("src","b.gif" );
      ((Element)v.get(700)).setAttribute("width","8" );
      ((Element)v.get(700)).setAttribute("height","8" );
      ((Element)v.get(699)).appendChild((Element)v.get(700));
      /* Termina nodo:700   */
      /* Termina nodo:699   */
      /* Termina nodo:693   */

      /* Empieza nodo:701 / Elemento padre: 682   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(682)).appendChild((Element)v.get(701));

      /* Empieza nodo:702 / Elemento padre: 701   */
      v.add(doc.createElement("td"));
      ((Element)v.get(702)).setAttribute("colspan","4" );
      ((Element)v.get(701)).appendChild((Element)v.get(702));

      /* Empieza nodo:703 / Elemento padre: 702   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(703)).setAttribute("src","b.gif" );
      ((Element)v.get(703)).setAttribute("width","8" );
      ((Element)v.get(703)).setAttribute("height","8" );
      ((Element)v.get(702)).appendChild((Element)v.get(703));
      /* Termina nodo:703   */
      /* Termina nodo:702   */
      /* Termina nodo:701   */
      /* Termina nodo:682   */
      /* Termina nodo:681   */
      /* Termina nodo:680   */
      /* Termina nodo:679   */
      /* Termina nodo:676   */
      /* Termina nodo:675   */

      /* Empieza nodo:704 / Elemento padre: 672   */
      v.add(doc.createElement("td"));
      ((Element)v.get(672)).appendChild((Element)v.get(704));

      /* Empieza nodo:705 / Elemento padre: 704   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(705)).setAttribute("src","b.gif" );
      ((Element)v.get(705)).setAttribute("width","8" );
      ((Element)v.get(705)).setAttribute("height","12" );
      ((Element)v.get(704)).appendChild((Element)v.get(705));
      /* Termina nodo:705   */
      /* Termina nodo:704   */
      /* Termina nodo:672   */

      /* Empieza nodo:706 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(706));

      /* Empieza nodo:707 / Elemento padre: 706   */
      v.add(doc.createElement("td"));
      ((Element)v.get(706)).appendChild((Element)v.get(707));

      /* Empieza nodo:708 / Elemento padre: 707   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(708)).setAttribute("src","b.gif" );
      ((Element)v.get(707)).appendChild((Element)v.get(708));
      /* Termina nodo:708   */
      /* Termina nodo:707   */

      /* Empieza nodo:709 / Elemento padre: 706   */
      v.add(doc.createElement("td"));
      ((Element)v.get(706)).appendChild((Element)v.get(709));

      /* Empieza nodo:710 / Elemento padre: 709   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(709)).appendChild((Element)v.get(710));

      /* Empieza nodo:711 / Elemento padre: 710   */
      v.add(doc.createElement("table"));
   }

   private void getXML2880(Document doc) {
      ((Element)v.get(711)).setAttribute("width","100%" );
      ((Element)v.get(711)).setAttribute("border","0" );
      ((Element)v.get(711)).setAttribute("align","center" );
      ((Element)v.get(711)).setAttribute("cellspacing","0" );
      ((Element)v.get(711)).setAttribute("cellpadding","0" );
      ((Element)v.get(710)).appendChild((Element)v.get(711));

      /* Empieza nodo:712 / Elemento padre: 711   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(711)).appendChild((Element)v.get(712));

      /* Empieza nodo:713 / Elemento padre: 712   */
      v.add(doc.createElement("td"));
      ((Element)v.get(713)).setAttribute("class","botonera" );
      ((Element)v.get(712)).appendChild((Element)v.get(713));

      /* Empieza nodo:714 / Elemento padre: 713   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(714)).setAttribute("nombre","btnAceptar" );
      ((Element)v.get(714)).setAttribute("ID","botonContenido" );
      ((Element)v.get(714)).setAttribute("tipo","html" );
      ((Element)v.get(714)).setAttribute("ontab","tabAceptar();" );
      ((Element)v.get(714)).setAttribute("accion","criteriosAsignacion();" );
      ((Element)v.get(714)).setAttribute("estado","false" );
      ((Element)v.get(714)).setAttribute("cod","12" );
      ((Element)v.get(713)).appendChild((Element)v.get(714));
      /* Termina nodo:714   */
      /* Termina nodo:713   */
      /* Termina nodo:712   */
      /* Termina nodo:711   */
      /* Termina nodo:710   */
      /* Termina nodo:709   */

      /* Empieza nodo:715 / Elemento padre: 706   */
      v.add(doc.createElement("td"));
      ((Element)v.get(706)).appendChild((Element)v.get(715));

      /* Empieza nodo:716 / Elemento padre: 715   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(716)).setAttribute("src","b.gif" );
      ((Element)v.get(716)).setAttribute("width","8" );
      ((Element)v.get(716)).setAttribute("height","12" );
      ((Element)v.get(715)).appendChild((Element)v.get(716));
      /* Termina nodo:716   */
      /* Termina nodo:715   */
      /* Termina nodo:706   */

      /* Empieza nodo:717 / Elemento padre: 114   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(114)).appendChild((Element)v.get(717));

      /* Empieza nodo:718 / Elemento padre: 717   */
      v.add(doc.createElement("td"));
      ((Element)v.get(718)).setAttribute("width","12" );
      ((Element)v.get(718)).setAttribute("align","center" );
      ((Element)v.get(717)).appendChild((Element)v.get(718));

      /* Empieza nodo:719 / Elemento padre: 718   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(719)).setAttribute("src","b.gif" );
      ((Element)v.get(719)).setAttribute("width","12" );
      ((Element)v.get(719)).setAttribute("height","12" );
      ((Element)v.get(718)).appendChild((Element)v.get(719));
      /* Termina nodo:719   */
      /* Termina nodo:718   */

      /* Empieza nodo:720 / Elemento padre: 717   */
      v.add(doc.createElement("td"));
      ((Element)v.get(720)).setAttribute("width","750" );
      ((Element)v.get(717)).appendChild((Element)v.get(720));

      /* Empieza nodo:721 / Elemento padre: 720   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(721)).setAttribute("src","b.gif" );
      ((Element)v.get(720)).appendChild((Element)v.get(721));
      /* Termina nodo:721   */
      /* Termina nodo:720   */

      /* Empieza nodo:722 / Elemento padre: 717   */
      v.add(doc.createElement("td"));
      ((Element)v.get(722)).setAttribute("width","12" );
      ((Element)v.get(717)).appendChild((Element)v.get(722));

      /* Empieza nodo:723 / Elemento padre: 722   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(723)).setAttribute("src","b.gif" );
      ((Element)v.get(723)).setAttribute("width","12" );
      ((Element)v.get(723)).setAttribute("height","12" );
      ((Element)v.get(722)).appendChild((Element)v.get(723));
      /* Termina nodo:723   */
      /* Termina nodo:722   */
      /* Termina nodo:717   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:724 / Elemento padre: 37   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(724)).setAttribute("nombre","capa2" );
      ((Element)v.get(724)).setAttribute("alto","120" );
      ((Element)v.get(724)).setAttribute("ancho","100%" );
      ((Element)v.get(724)).setAttribute("colorf","" );
      ((Element)v.get(724)).setAttribute("borde","0" );
      ((Element)v.get(724)).setAttribute("imagenf","" );
      ((Element)v.get(724)).setAttribute("repeat","" );
      ((Element)v.get(724)).setAttribute("padding","" );
      ((Element)v.get(724)).setAttribute("visibilidad","" );
      ((Element)v.get(724)).setAttribute("contravsb","" );
      ((Element)v.get(724)).setAttribute("x","0" );
      ((Element)v.get(724)).setAttribute("y","1006" );
      ((Element)v.get(724)).setAttribute("zindex","" );
      ((Element)v.get(37)).appendChild((Element)v.get(724));

      /* Empieza nodo:725 / Elemento padre: 724   */
      v.add(doc.createElement("table"));
      ((Element)v.get(725)).setAttribute("width","100%" );
      ((Element)v.get(725)).setAttribute("border","0" );
      ((Element)v.get(725)).setAttribute("cellspacing","0" );
      ((Element)v.get(725)).setAttribute("cellpadding","0" );
      ((Element)v.get(724)).appendChild((Element)v.get(725));

      /* Empieza nodo:726 / Elemento padre: 725   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(725)).appendChild((Element)v.get(726));

      /* Empieza nodo:727 / Elemento padre: 726   */
      v.add(doc.createElement("td"));
      ((Element)v.get(727)).setAttribute("width","12" );
      ((Element)v.get(727)).setAttribute("align","center" );
      ((Element)v.get(726)).appendChild((Element)v.get(727));

      /* Empieza nodo:728 / Elemento padre: 727   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(728)).setAttribute("src","b.gif" );
      ((Element)v.get(728)).setAttribute("width","12" );
      ((Element)v.get(728)).setAttribute("height","12" );
      ((Element)v.get(727)).appendChild((Element)v.get(728));
      /* Termina nodo:728   */
      /* Termina nodo:727   */

      /* Empieza nodo:729 / Elemento padre: 726   */
      v.add(doc.createElement("td"));
      ((Element)v.get(729)).setAttribute("width","750" );
      ((Element)v.get(726)).appendChild((Element)v.get(729));

      /* Empieza nodo:730 / Elemento padre: 729   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(730)).setAttribute("src","b.gif" );
      ((Element)v.get(729)).appendChild((Element)v.get(730));
      /* Termina nodo:730   */
      /* Termina nodo:729   */

      /* Empieza nodo:731 / Elemento padre: 726   */
   }

   private void getXML2970(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(731)).setAttribute("width","12" );
      ((Element)v.get(726)).appendChild((Element)v.get(731));

      /* Empieza nodo:732 / Elemento padre: 731   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(732)).setAttribute("src","b.gif" );
      ((Element)v.get(732)).setAttribute("width","12" );
      ((Element)v.get(732)).setAttribute("height","1" );
      ((Element)v.get(731)).appendChild((Element)v.get(732));
      /* Termina nodo:732   */
      /* Termina nodo:731   */
      /* Termina nodo:726   */

      /* Empieza nodo:733 / Elemento padre: 725   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(725)).appendChild((Element)v.get(733));

      /* Empieza nodo:734 / Elemento padre: 733   */
      v.add(doc.createElement("td"));
      ((Element)v.get(733)).appendChild((Element)v.get(734));

      /* Empieza nodo:735 / Elemento padre: 734   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(735)).setAttribute("src","b.gif" );
      ((Element)v.get(734)).appendChild((Element)v.get(735));
      /* Termina nodo:735   */
      /* Termina nodo:734   */

      /* Empieza nodo:736 / Elemento padre: 733   */
      v.add(doc.createElement("td"));
      ((Element)v.get(733)).appendChild((Element)v.get(736));

      /* Empieza nodo:737 / Elemento padre: 736   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(736)).appendChild((Element)v.get(737));

      /* Empieza nodo:738 / Elemento padre: 737   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(738)).setAttribute("class","legend" );
      ((Element)v.get(737)).appendChild((Element)v.get(738));

      /* Empieza nodo:739 / Elemento padre: 738   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(739)).setAttribute("nombre","lblEnvioMensaje2" );
      ((Element)v.get(739)).setAttribute("alto","13" );
      ((Element)v.get(739)).setAttribute("filas","1" );
      ((Element)v.get(739)).setAttribute("valor","" );
      ((Element)v.get(739)).setAttribute("cod","00284" );
      ((Element)v.get(739)).setAttribute("id","legend" );
      ((Element)v.get(738)).appendChild((Element)v.get(739));
      /* Termina nodo:739   */
      /* Termina nodo:738   */

      /* Empieza nodo:740 / Elemento padre: 737   */
      v.add(doc.createElement("table"));
      ((Element)v.get(740)).setAttribute("width","100%" );
      ((Element)v.get(740)).setAttribute("border","0" );
      ((Element)v.get(740)).setAttribute("align","center" );
      ((Element)v.get(740)).setAttribute("cellspacing","0" );
      ((Element)v.get(740)).setAttribute("cellpadding","0" );
      ((Element)v.get(737)).appendChild((Element)v.get(740));

      /* Empieza nodo:741 / Elemento padre: 740   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(740)).appendChild((Element)v.get(741));

      /* Empieza nodo:742 / Elemento padre: 741   */
      v.add(doc.createElement("td"));
      ((Element)v.get(741)).appendChild((Element)v.get(742));

      /* Empieza nodo:743 / Elemento padre: 742   */
      v.add(doc.createElement("table"));
      ((Element)v.get(743)).setAttribute("width","714" );
      ((Element)v.get(743)).setAttribute("border","0" );
      ((Element)v.get(743)).setAttribute("align","left" );
      ((Element)v.get(743)).setAttribute("cellspacing","0" );
      ((Element)v.get(743)).setAttribute("cellpadding","0" );
      ((Element)v.get(742)).appendChild((Element)v.get(743));

      /* Empieza nodo:744 / Elemento padre: 743   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(743)).appendChild((Element)v.get(744));

      /* Empieza nodo:745 / Elemento padre: 744   */
      v.add(doc.createElement("td"));
      ((Element)v.get(745)).setAttribute("colspan","4" );
      ((Element)v.get(744)).appendChild((Element)v.get(745));

      /* Empieza nodo:746 / Elemento padre: 745   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(746)).setAttribute("src","b.gif" );
      ((Element)v.get(746)).setAttribute("width","8" );
      ((Element)v.get(746)).setAttribute("height","8" );
      ((Element)v.get(745)).appendChild((Element)v.get(746));
      /* Termina nodo:746   */
      /* Termina nodo:745   */
      /* Termina nodo:744   */

      /* Empieza nodo:747 / Elemento padre: 743   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(743)).appendChild((Element)v.get(747));

      /* Empieza nodo:748 / Elemento padre: 747   */
      v.add(doc.createElement("td"));
      ((Element)v.get(747)).appendChild((Element)v.get(748));

      /* Empieza nodo:749 / Elemento padre: 748   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(749)).setAttribute("src","b.gif" );
      ((Element)v.get(749)).setAttribute("width","8" );
      ((Element)v.get(749)).setAttribute("height","8" );
      ((Element)v.get(748)).appendChild((Element)v.get(749));
      /* Termina nodo:749   */
      /* Termina nodo:748   */

      /* Empieza nodo:750 / Elemento padre: 747   */
      v.add(doc.createElement("td"));
      ((Element)v.get(747)).appendChild((Element)v.get(750));

      /* Empieza nodo:751 / Elemento padre: 750   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(751)).setAttribute("nombre","lblEnviarMensaje2" );
      ((Element)v.get(751)).setAttribute("alto","13" );
      ((Element)v.get(751)).setAttribute("filas","1" );
      ((Element)v.get(751)).setAttribute("valor","" );
      ((Element)v.get(751)).setAttribute("id","datosTitle" );
      ((Element)v.get(751)).setAttribute("cod","1221" );
      ((Element)v.get(750)).appendChild((Element)v.get(751));
      /* Termina nodo:751   */
      /* Termina nodo:750   */

      /* Empieza nodo:752 / Elemento padre: 747   */
      v.add(doc.createElement("td"));
      ((Element)v.get(747)).appendChild((Element)v.get(752));

      /* Empieza nodo:753 / Elemento padre: 752   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(753)).setAttribute("src","b.gif" );
      ((Element)v.get(753)).setAttribute("width","25" );
      ((Element)v.get(753)).setAttribute("height","8" );
      ((Element)v.get(752)).appendChild((Element)v.get(753));
      /* Termina nodo:753   */
      /* Termina nodo:752   */

      /* Empieza nodo:754 / Elemento padre: 747   */
      v.add(doc.createElement("td"));
      ((Element)v.get(747)).appendChild((Element)v.get(754));

      /* Empieza nodo:755 / Elemento padre: 754   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(755)).setAttribute("nombre","lblCodMensaje2" );
      ((Element)v.get(755)).setAttribute("alto","13" );
      ((Element)v.get(755)).setAttribute("filas","1" );
   }

   private void getXML3060(Document doc) {
      ((Element)v.get(755)).setAttribute("valor","" );
      ((Element)v.get(755)).setAttribute("id","datosTitle" );
      ((Element)v.get(755)).setAttribute("cod","821" );
      ((Element)v.get(754)).appendChild((Element)v.get(755));
      /* Termina nodo:755   */
      /* Termina nodo:754   */

      /* Empieza nodo:756 / Elemento padre: 747   */
      v.add(doc.createElement("td"));
      ((Element)v.get(756)).setAttribute("width","100%" );
      ((Element)v.get(747)).appendChild((Element)v.get(756));

      /* Empieza nodo:757 / Elemento padre: 756   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(757)).setAttribute("src","b.gif" );
      ((Element)v.get(757)).setAttribute("width","8" );
      ((Element)v.get(757)).setAttribute("height","8" );
      ((Element)v.get(756)).appendChild((Element)v.get(757));
      /* Termina nodo:757   */
      /* Termina nodo:756   */
      /* Termina nodo:747   */

      /* Empieza nodo:758 / Elemento padre: 743   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(743)).appendChild((Element)v.get(758));

      /* Empieza nodo:759 / Elemento padre: 758   */
      v.add(doc.createElement("td"));
      ((Element)v.get(758)).appendChild((Element)v.get(759));

      /* Empieza nodo:760 / Elemento padre: 759   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(760)).setAttribute("src","b.gif" );
      ((Element)v.get(760)).setAttribute("width","8" );
      ((Element)v.get(760)).setAttribute("height","8" );
      ((Element)v.get(759)).appendChild((Element)v.get(760));
      /* Termina nodo:760   */
      /* Termina nodo:759   */

      /* Empieza nodo:761 / Elemento padre: 758   */
      v.add(doc.createElement("td"));
      ((Element)v.get(761)).setAttribute("class","datosCampos" );
      ((Element)v.get(761)).setAttribute("valign","bottom" );
      ((Element)v.get(758)).appendChild((Element)v.get(761));

      /* Empieza nodo:762 / Elemento padre: 761   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(762)).setAttribute("nombre","rbEnviarMensaje2" );
      ((Element)v.get(762)).setAttribute("tipo","H" );
      ((Element)v.get(762)).setAttribute("id","datosCampos" );
      ((Element)v.get(762)).setAttribute("onclick","cambiaRadio2();" );
      ((Element)v.get(762)).setAttribute("ontab","tabRbEnviarMensaje('cbCodMensaje2');" );
      ((Element)v.get(761)).appendChild((Element)v.get(762));

      /* Empieza nodo:763 / Elemento padre: 762   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(763)).setAttribute("valor","S" );
      ((Element)v.get(763)).setAttribute("check","N" );
      ((Element)v.get(763)).setAttribute("onfocus","" );
      ((Element)v.get(763)).setAttribute("id","datosCampos" );
      ((Element)v.get(763)).setAttribute("cod","117" );
      ((Element)v.get(762)).appendChild((Element)v.get(763));

      /* Elemento padre:763 / Elemento actual: 764   */
      v.add(doc.createTextNode("yy"));
      ((Element)v.get(763)).appendChild((Text)v.get(764));

      /* Termina nodo Texto:764   */
      /* Termina nodo:763   */

      /* Empieza nodo:765 / Elemento padre: 762   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(765)).setAttribute("valor","N" );
      ((Element)v.get(765)).setAttribute("check","N" );
      ((Element)v.get(765)).setAttribute("onfocus","" );
      ((Element)v.get(765)).setAttribute("id","datosCampos" );
      ((Element)v.get(765)).setAttribute("cod","87" );
      ((Element)v.get(762)).appendChild((Element)v.get(765));

      /* Elemento padre:765 / Elemento actual: 766   */
      v.add(doc.createTextNode("nn"));
      ((Element)v.get(765)).appendChild((Text)v.get(766));

      /* Termina nodo Texto:766   */
      /* Termina nodo:765   */
      /* Termina nodo:762   */
      /* Termina nodo:761   */

      /* Empieza nodo:767 / Elemento padre: 758   */
      v.add(doc.createElement("td"));
      ((Element)v.get(758)).appendChild((Element)v.get(767));

      /* Empieza nodo:768 / Elemento padre: 767   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(768)).setAttribute("src","b.gif" );
      ((Element)v.get(768)).setAttribute("width","25" );
      ((Element)v.get(768)).setAttribute("height","8" );
      ((Element)v.get(767)).appendChild((Element)v.get(768));
      /* Termina nodo:768   */
      /* Termina nodo:767   */

      /* Empieza nodo:769 / Elemento padre: 758   */
      v.add(doc.createElement("td"));
      ((Element)v.get(769)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(758)).appendChild((Element)v.get(769));

      /* Empieza nodo:770 / Elemento padre: 769   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(770)).setAttribute("nombre","cbCodMensaje2" );
      ((Element)v.get(770)).setAttribute("id","datosCampos" );
      ((Element)v.get(770)).setAttribute("size","1" );
      ((Element)v.get(770)).setAttribute("multiple","N" );
      ((Element)v.get(770)).setAttribute("req","S" );
      ((Element)v.get(770)).setAttribute("valorinicial","" );
      ((Element)v.get(770)).setAttribute("textoinicial","" );
      ((Element)v.get(769)).appendChild((Element)v.get(770));

      /* Empieza nodo:771 / Elemento padre: 770   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(770)).appendChild((Element)v.get(771));
      /* Termina nodo:771   */
      /* Termina nodo:770   */
      /* Termina nodo:769   */

      /* Empieza nodo:772 / Elemento padre: 758   */
      v.add(doc.createElement("td"));
      ((Element)v.get(772)).setAttribute("width","100%" );
      ((Element)v.get(758)).appendChild((Element)v.get(772));

      /* Empieza nodo:773 / Elemento padre: 772   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(773)).setAttribute("src","b.gif" );
      ((Element)v.get(773)).setAttribute("width","8" );
      ((Element)v.get(773)).setAttribute("height","8" );
      ((Element)v.get(772)).appendChild((Element)v.get(773));
      /* Termina nodo:773   */
      /* Termina nodo:772   */
      /* Termina nodo:758   */

      /* Empieza nodo:774 / Elemento padre: 743   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(743)).appendChild((Element)v.get(774));

      /* Empieza nodo:775 / Elemento padre: 774   */
      v.add(doc.createElement("td"));
      ((Element)v.get(775)).setAttribute("colspan","4" );
      ((Element)v.get(774)).appendChild((Element)v.get(775));

      /* Empieza nodo:776 / Elemento padre: 775   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(776)).setAttribute("src","b.gif" );
      ((Element)v.get(776)).setAttribute("width","8" );
      ((Element)v.get(776)).setAttribute("height","8" );
      ((Element)v.get(775)).appendChild((Element)v.get(776));
      /* Termina nodo:776   */
      /* Termina nodo:775   */
      /* Termina nodo:774   */
      /* Termina nodo:743   */
      /* Termina nodo:742   */
      /* Termina nodo:741   */
      /* Termina nodo:740   */
      /* Termina nodo:737   */
      /* Termina nodo:736   */

      /* Empieza nodo:777 / Elemento padre: 733   */
      v.add(doc.createElement("td"));
   }

   private void getXML3150(Document doc) {
      ((Element)v.get(733)).appendChild((Element)v.get(777));

      /* Empieza nodo:778 / Elemento padre: 777   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(778)).setAttribute("src","b.gif" );
      ((Element)v.get(778)).setAttribute("width","8" );
      ((Element)v.get(778)).setAttribute("height","12" );
      ((Element)v.get(777)).appendChild((Element)v.get(778));
      /* Termina nodo:778   */
      /* Termina nodo:777   */
      /* Termina nodo:733   */

      /* Empieza nodo:779 / Elemento padre: 725   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(725)).appendChild((Element)v.get(779));

      /* Empieza nodo:780 / Elemento padre: 779   */
      v.add(doc.createElement("td"));
      ((Element)v.get(779)).appendChild((Element)v.get(780));

      /* Empieza nodo:781 / Elemento padre: 780   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(781)).setAttribute("src","b.gif" );
      ((Element)v.get(780)).appendChild((Element)v.get(781));
      /* Termina nodo:781   */
      /* Termina nodo:780   */

      /* Empieza nodo:782 / Elemento padre: 779   */
      v.add(doc.createElement("td"));
      ((Element)v.get(779)).appendChild((Element)v.get(782));

      /* Empieza nodo:783 / Elemento padre: 782   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(782)).appendChild((Element)v.get(783));

      /* Empieza nodo:784 / Elemento padre: 783   */
      v.add(doc.createElement("table"));
      ((Element)v.get(784)).setAttribute("width","100%" );
      ((Element)v.get(784)).setAttribute("border","0" );
      ((Element)v.get(784)).setAttribute("align","center" );
      ((Element)v.get(784)).setAttribute("cellspacing","0" );
      ((Element)v.get(784)).setAttribute("cellpadding","0" );
      ((Element)v.get(783)).appendChild((Element)v.get(784));

      /* Empieza nodo:785 / Elemento padre: 784   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(784)).appendChild((Element)v.get(785));

      /* Empieza nodo:786 / Elemento padre: 785   */
      v.add(doc.createElement("td"));
      ((Element)v.get(786)).setAttribute("class","botonera" );
      ((Element)v.get(785)).appendChild((Element)v.get(786));

      /* Empieza nodo:787 / Elemento padre: 786   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(787)).setAttribute("nombre","btnNuevaEntrada" );
      ((Element)v.get(787)).setAttribute("ID","botonContenido" );
      ((Element)v.get(787)).setAttribute("tipo","html" );
      ((Element)v.get(787)).setAttribute("accion","nuevaEntrada();" );
      ((Element)v.get(787)).setAttribute("estado","false" );
      ((Element)v.get(787)).setAttribute("cod","945" );
      ((Element)v.get(787)).setAttribute("ontab","focalizaCampoProducto();" );
      ((Element)v.get(786)).appendChild((Element)v.get(787));
      /* Termina nodo:787   */
      /* Termina nodo:786   */
      /* Termina nodo:785   */
      /* Termina nodo:784   */
      /* Termina nodo:783   */
      /* Termina nodo:782   */

      /* Empieza nodo:788 / Elemento padre: 779   */
      v.add(doc.createElement("td"));
      ((Element)v.get(779)).appendChild((Element)v.get(788));

      /* Empieza nodo:789 / Elemento padre: 788   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(789)).setAttribute("src","b.gif" );
      ((Element)v.get(789)).setAttribute("width","8" );
      ((Element)v.get(789)).setAttribute("height","12" );
      ((Element)v.get(788)).appendChild((Element)v.get(789));
      /* Termina nodo:789   */
      /* Termina nodo:788   */
      /* Termina nodo:779   */

      /* Empieza nodo:790 / Elemento padre: 725   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(725)).appendChild((Element)v.get(790));

      /* Empieza nodo:791 / Elemento padre: 790   */
      v.add(doc.createElement("td"));
      ((Element)v.get(791)).setAttribute("width","12" );
      ((Element)v.get(791)).setAttribute("align","center" );
      ((Element)v.get(790)).appendChild((Element)v.get(791));

      /* Empieza nodo:792 / Elemento padre: 791   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(792)).setAttribute("src","b.gif" );
      ((Element)v.get(792)).setAttribute("width","12" );
      ((Element)v.get(792)).setAttribute("height","12" );
      ((Element)v.get(791)).appendChild((Element)v.get(792));
      /* Termina nodo:792   */
      /* Termina nodo:791   */

      /* Empieza nodo:793 / Elemento padre: 790   */
      v.add(doc.createElement("td"));
      ((Element)v.get(793)).setAttribute("width","750" );
      ((Element)v.get(790)).appendChild((Element)v.get(793));

      /* Empieza nodo:794 / Elemento padre: 793   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(794)).setAttribute("src","b.gif" );
      ((Element)v.get(793)).appendChild((Element)v.get(794));
      /* Termina nodo:794   */
      /* Termina nodo:793   */

      /* Empieza nodo:795 / Elemento padre: 790   */
      v.add(doc.createElement("td"));
      ((Element)v.get(795)).setAttribute("width","12" );
      ((Element)v.get(790)).appendChild((Element)v.get(795));

      /* Empieza nodo:796 / Elemento padre: 795   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(796)).setAttribute("src","b.gif" );
      ((Element)v.get(796)).setAttribute("width","12" );
      ((Element)v.get(796)).setAttribute("height","12" );
      ((Element)v.get(795)).appendChild((Element)v.get(796));
      /* Termina nodo:796   */
      /* Termina nodo:795   */
      /* Termina nodo:790   */
      /* Termina nodo:725   */
      /* Termina nodo:724   */

      /* Empieza nodo:797 / Elemento padre: 37   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(797)).setAttribute("nombre","capa3" );
      ((Element)v.get(797)).setAttribute("alto","120" );
      ((Element)v.get(797)).setAttribute("ancho","100%" );
      ((Element)v.get(797)).setAttribute("colorf","" );
      ((Element)v.get(797)).setAttribute("borde","0" );
      ((Element)v.get(797)).setAttribute("imagenf","" );
      ((Element)v.get(797)).setAttribute("repeat","" );
      ((Element)v.get(797)).setAttribute("padding","" );
      ((Element)v.get(797)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(797)).setAttribute("contravsb","" );
      ((Element)v.get(797)).setAttribute("x","0" );
      ((Element)v.get(797)).setAttribute("y","1006" );
      ((Element)v.get(797)).setAttribute("zindex","" );
      ((Element)v.get(37)).appendChild((Element)v.get(797));

      /* Empieza nodo:798 / Elemento padre: 797   */
      v.add(doc.createElement("table"));
      ((Element)v.get(798)).setAttribute("width","100%" );
      ((Element)v.get(798)).setAttribute("border","0" );
      ((Element)v.get(798)).setAttribute("cellspacing","0" );
      ((Element)v.get(798)).setAttribute("cellpadding","0" );
   }

   private void getXML3240(Document doc) {
      ((Element)v.get(797)).appendChild((Element)v.get(798));

      /* Empieza nodo:799 / Elemento padre: 798   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(798)).appendChild((Element)v.get(799));

      /* Empieza nodo:800 / Elemento padre: 799   */
      v.add(doc.createElement("td"));
      ((Element)v.get(800)).setAttribute("width","12" );
      ((Element)v.get(800)).setAttribute("align","center" );
      ((Element)v.get(799)).appendChild((Element)v.get(800));

      /* Empieza nodo:801 / Elemento padre: 800   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(801)).setAttribute("src","b.gif" );
      ((Element)v.get(801)).setAttribute("width","12" );
      ((Element)v.get(801)).setAttribute("height","12" );
      ((Element)v.get(800)).appendChild((Element)v.get(801));
      /* Termina nodo:801   */
      /* Termina nodo:800   */

      /* Empieza nodo:802 / Elemento padre: 799   */
      v.add(doc.createElement("td"));
      ((Element)v.get(802)).setAttribute("width","750" );
      ((Element)v.get(799)).appendChild((Element)v.get(802));

      /* Empieza nodo:803 / Elemento padre: 802   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(803)).setAttribute("src","b.gif" );
      ((Element)v.get(802)).appendChild((Element)v.get(803));
      /* Termina nodo:803   */
      /* Termina nodo:802   */

      /* Empieza nodo:804 / Elemento padre: 799   */
      v.add(doc.createElement("td"));
      ((Element)v.get(804)).setAttribute("width","12" );
      ((Element)v.get(799)).appendChild((Element)v.get(804));

      /* Empieza nodo:805 / Elemento padre: 804   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(805)).setAttribute("src","b.gif" );
      ((Element)v.get(805)).setAttribute("width","12" );
      ((Element)v.get(805)).setAttribute("height","1" );
      ((Element)v.get(804)).appendChild((Element)v.get(805));
      /* Termina nodo:805   */
      /* Termina nodo:804   */
      /* Termina nodo:799   */

      /* Empieza nodo:806 / Elemento padre: 798   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(798)).appendChild((Element)v.get(806));

      /* Empieza nodo:807 / Elemento padre: 806   */
      v.add(doc.createElement("td"));
      ((Element)v.get(806)).appendChild((Element)v.get(807));

      /* Empieza nodo:808 / Elemento padre: 807   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(808)).setAttribute("src","b.gif" );
      ((Element)v.get(807)).appendChild((Element)v.get(808));
      /* Termina nodo:808   */
      /* Termina nodo:807   */

      /* Empieza nodo:809 / Elemento padre: 806   */
      v.add(doc.createElement("td"));
      ((Element)v.get(806)).appendChild((Element)v.get(809));

      /* Empieza nodo:810 / Elemento padre: 809   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(809)).appendChild((Element)v.get(810));

      /* Empieza nodo:811 / Elemento padre: 810   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(811)).setAttribute("class","legend" );
      ((Element)v.get(810)).appendChild((Element)v.get(811));

      /* Empieza nodo:812 / Elemento padre: 811   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(812)).setAttribute("nombre","lblEnvioMensajes3" );
      ((Element)v.get(812)).setAttribute("alto","13" );
      ((Element)v.get(812)).setAttribute("filas","1" );
      ((Element)v.get(812)).setAttribute("valor","" );
      ((Element)v.get(812)).setAttribute("cod","00284" );
      ((Element)v.get(812)).setAttribute("id","legend" );
      ((Element)v.get(811)).appendChild((Element)v.get(812));
      /* Termina nodo:812   */
      /* Termina nodo:811   */

      /* Empieza nodo:813 / Elemento padre: 810   */
      v.add(doc.createElement("table"));
      ((Element)v.get(813)).setAttribute("width","100%" );
      ((Element)v.get(813)).setAttribute("border","0" );
      ((Element)v.get(813)).setAttribute("align","center" );
      ((Element)v.get(813)).setAttribute("cellspacing","0" );
      ((Element)v.get(813)).setAttribute("cellpadding","0" );
      ((Element)v.get(810)).appendChild((Element)v.get(813));

      /* Empieza nodo:814 / Elemento padre: 813   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(813)).appendChild((Element)v.get(814));

      /* Empieza nodo:815 / Elemento padre: 814   */
      v.add(doc.createElement("td"));
      ((Element)v.get(814)).appendChild((Element)v.get(815));

      /* Empieza nodo:816 / Elemento padre: 815   */
      v.add(doc.createElement("table"));
      ((Element)v.get(816)).setAttribute("width","714" );
      ((Element)v.get(816)).setAttribute("border","0" );
      ((Element)v.get(816)).setAttribute("align","left" );
      ((Element)v.get(816)).setAttribute("cellspacing","0" );
      ((Element)v.get(816)).setAttribute("cellpadding","0" );
      ((Element)v.get(815)).appendChild((Element)v.get(816));

      /* Empieza nodo:817 / Elemento padre: 816   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(816)).appendChild((Element)v.get(817));

      /* Empieza nodo:818 / Elemento padre: 817   */
      v.add(doc.createElement("td"));
      ((Element)v.get(818)).setAttribute("colspan","4" );
      ((Element)v.get(817)).appendChild((Element)v.get(818));

      /* Empieza nodo:819 / Elemento padre: 818   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(819)).setAttribute("src","b.gif" );
      ((Element)v.get(819)).setAttribute("width","8" );
      ((Element)v.get(819)).setAttribute("height","8" );
      ((Element)v.get(818)).appendChild((Element)v.get(819));
      /* Termina nodo:819   */
      /* Termina nodo:818   */
      /* Termina nodo:817   */

      /* Empieza nodo:820 / Elemento padre: 816   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(816)).appendChild((Element)v.get(820));

      /* Empieza nodo:821 / Elemento padre: 820   */
      v.add(doc.createElement("td"));
      ((Element)v.get(820)).appendChild((Element)v.get(821));

      /* Empieza nodo:822 / Elemento padre: 821   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(822)).setAttribute("src","b.gif" );
      ((Element)v.get(822)).setAttribute("width","8" );
      ((Element)v.get(822)).setAttribute("height","8" );
      ((Element)v.get(821)).appendChild((Element)v.get(822));
      /* Termina nodo:822   */
      /* Termina nodo:821   */

      /* Empieza nodo:823 / Elemento padre: 820   */
      v.add(doc.createElement("td"));
      ((Element)v.get(820)).appendChild((Element)v.get(823));

      /* Empieza nodo:824 / Elemento padre: 823   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(824)).setAttribute("nombre","lblEnviarMensaje3" );
      ((Element)v.get(824)).setAttribute("alto","13" );
   }

   private void getXML3330(Document doc) {
      ((Element)v.get(824)).setAttribute("filas","1" );
      ((Element)v.get(824)).setAttribute("valor","" );
      ((Element)v.get(824)).setAttribute("id","datosTitle" );
      ((Element)v.get(824)).setAttribute("cod","1221" );
      ((Element)v.get(823)).appendChild((Element)v.get(824));
      /* Termina nodo:824   */
      /* Termina nodo:823   */

      /* Empieza nodo:825 / Elemento padre: 820   */
      v.add(doc.createElement("td"));
      ((Element)v.get(820)).appendChild((Element)v.get(825));

      /* Empieza nodo:826 / Elemento padre: 825   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(826)).setAttribute("src","b.gif" );
      ((Element)v.get(826)).setAttribute("width","25" );
      ((Element)v.get(826)).setAttribute("height","8" );
      ((Element)v.get(825)).appendChild((Element)v.get(826));
      /* Termina nodo:826   */
      /* Termina nodo:825   */

      /* Empieza nodo:827 / Elemento padre: 820   */
      v.add(doc.createElement("td"));
      ((Element)v.get(820)).appendChild((Element)v.get(827));

      /* Empieza nodo:828 / Elemento padre: 827   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(828)).setAttribute("nombre","lblCodMensaje3" );
      ((Element)v.get(828)).setAttribute("alto","13" );
      ((Element)v.get(828)).setAttribute("filas","1" );
      ((Element)v.get(828)).setAttribute("valor","" );
      ((Element)v.get(828)).setAttribute("id","datosTitle" );
      ((Element)v.get(828)).setAttribute("cod","821" );
      ((Element)v.get(827)).appendChild((Element)v.get(828));
      /* Termina nodo:828   */
      /* Termina nodo:827   */

      /* Empieza nodo:829 / Elemento padre: 820   */
      v.add(doc.createElement("td"));
      ((Element)v.get(829)).setAttribute("width","100%" );
      ((Element)v.get(820)).appendChild((Element)v.get(829));

      /* Empieza nodo:830 / Elemento padre: 829   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(830)).setAttribute("src","b.gif" );
      ((Element)v.get(830)).setAttribute("width","8" );
      ((Element)v.get(830)).setAttribute("height","8" );
      ((Element)v.get(829)).appendChild((Element)v.get(830));
      /* Termina nodo:830   */
      /* Termina nodo:829   */
      /* Termina nodo:820   */

      /* Empieza nodo:831 / Elemento padre: 816   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(816)).appendChild((Element)v.get(831));

      /* Empieza nodo:832 / Elemento padre: 831   */
      v.add(doc.createElement("td"));
      ((Element)v.get(831)).appendChild((Element)v.get(832));

      /* Empieza nodo:833 / Elemento padre: 832   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(833)).setAttribute("src","b.gif" );
      ((Element)v.get(833)).setAttribute("width","8" );
      ((Element)v.get(833)).setAttribute("height","8" );
      ((Element)v.get(832)).appendChild((Element)v.get(833));
      /* Termina nodo:833   */
      /* Termina nodo:832   */

      /* Empieza nodo:834 / Elemento padre: 831   */
      v.add(doc.createElement("td"));
      ((Element)v.get(834)).setAttribute("class","datosCampos" );
      ((Element)v.get(834)).setAttribute("valign","bottom" );
      ((Element)v.get(831)).appendChild((Element)v.get(834));

      /* Empieza nodo:835 / Elemento padre: 834   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(835)).setAttribute("nombre","rbEnviarMensaje3" );
      ((Element)v.get(835)).setAttribute("tipo","H" );
      ((Element)v.get(835)).setAttribute("id","datosCampos" );
      ((Element)v.get(835)).setAttribute("onclick","cambiaRadio3();" );
      ((Element)v.get(835)).setAttribute("ontab","tabRbEnviarMensaje('cbCodMensaje3');" );
      ((Element)v.get(835)).setAttribute("onshtab","onshTabRadio3();" );
      ((Element)v.get(834)).appendChild((Element)v.get(835));

      /* Empieza nodo:836 / Elemento padre: 835   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(836)).setAttribute("valor","S" );
      ((Element)v.get(836)).setAttribute("check","N" );
      ((Element)v.get(836)).setAttribute("onfocus","" );
      ((Element)v.get(836)).setAttribute("id","datosCampos" );
      ((Element)v.get(836)).setAttribute("cod","117" );
      ((Element)v.get(835)).appendChild((Element)v.get(836));

      /* Elemento padre:836 / Elemento actual: 837   */
      v.add(doc.createTextNode("yy"));
      ((Element)v.get(836)).appendChild((Text)v.get(837));

      /* Termina nodo Texto:837   */
      /* Termina nodo:836   */

      /* Empieza nodo:838 / Elemento padre: 835   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(838)).setAttribute("valor","N" );
      ((Element)v.get(838)).setAttribute("check","N" );
      ((Element)v.get(838)).setAttribute("onfocus","" );
      ((Element)v.get(838)).setAttribute("id","datosCampos" );
      ((Element)v.get(838)).setAttribute("cod","87" );
      ((Element)v.get(835)).appendChild((Element)v.get(838));

      /* Elemento padre:838 / Elemento actual: 839   */
      v.add(doc.createTextNode("nn"));
      ((Element)v.get(838)).appendChild((Text)v.get(839));

      /* Termina nodo Texto:839   */
      /* Termina nodo:838   */
      /* Termina nodo:835   */
      /* Termina nodo:834   */

      /* Empieza nodo:840 / Elemento padre: 831   */
      v.add(doc.createElement("td"));
      ((Element)v.get(831)).appendChild((Element)v.get(840));

      /* Empieza nodo:841 / Elemento padre: 840   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(841)).setAttribute("src","b.gif" );
      ((Element)v.get(841)).setAttribute("width","25" );
      ((Element)v.get(841)).setAttribute("height","8" );
      ((Element)v.get(840)).appendChild((Element)v.get(841));
      /* Termina nodo:841   */
      /* Termina nodo:840   */

      /* Empieza nodo:842 / Elemento padre: 831   */
      v.add(doc.createElement("td"));
      ((Element)v.get(842)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(831)).appendChild((Element)v.get(842));

      /* Empieza nodo:843 / Elemento padre: 842   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(843)).setAttribute("nombre","cbCodMensaje3" );
      ((Element)v.get(843)).setAttribute("id","datosCampos" );
      ((Element)v.get(843)).setAttribute("ontab","focaliza('frmUnico.txtCodProducto', '');" );
      ((Element)v.get(843)).setAttribute("size","1" );
      ((Element)v.get(843)).setAttribute("multiple","N" );
      ((Element)v.get(843)).setAttribute("req","S" );
      ((Element)v.get(843)).setAttribute("valorinicial","" );
      ((Element)v.get(843)).setAttribute("textoinicial","" );
      ((Element)v.get(842)).appendChild((Element)v.get(843));

      /* Empieza nodo:844 / Elemento padre: 843   */
      v.add(doc.createElement("ROWSET"));
   }

   private void getXML3420(Document doc) {
      ((Element)v.get(843)).appendChild((Element)v.get(844));
      /* Termina nodo:844   */
      /* Termina nodo:843   */
      /* Termina nodo:842   */

      /* Empieza nodo:845 / Elemento padre: 831   */
      v.add(doc.createElement("td"));
      ((Element)v.get(845)).setAttribute("width","100%" );
      ((Element)v.get(831)).appendChild((Element)v.get(845));

      /* Empieza nodo:846 / Elemento padre: 845   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(846)).setAttribute("src","b.gif" );
      ((Element)v.get(846)).setAttribute("width","8" );
      ((Element)v.get(846)).setAttribute("height","8" );
      ((Element)v.get(845)).appendChild((Element)v.get(846));
      /* Termina nodo:846   */
      /* Termina nodo:845   */
      /* Termina nodo:831   */

      /* Empieza nodo:847 / Elemento padre: 816   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(816)).appendChild((Element)v.get(847));

      /* Empieza nodo:848 / Elemento padre: 847   */
      v.add(doc.createElement("td"));
      ((Element)v.get(848)).setAttribute("colspan","4" );
      ((Element)v.get(847)).appendChild((Element)v.get(848));

      /* Empieza nodo:849 / Elemento padre: 848   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(849)).setAttribute("src","b.gif" );
      ((Element)v.get(849)).setAttribute("width","8" );
      ((Element)v.get(849)).setAttribute("height","8" );
      ((Element)v.get(848)).appendChild((Element)v.get(849));
      /* Termina nodo:849   */
      /* Termina nodo:848   */
      /* Termina nodo:847   */
      /* Termina nodo:816   */
      /* Termina nodo:815   */
      /* Termina nodo:814   */
      /* Termina nodo:813   */
      /* Termina nodo:810   */
      /* Termina nodo:809   */

      /* Empieza nodo:850 / Elemento padre: 806   */
      v.add(doc.createElement("td"));
      ((Element)v.get(806)).appendChild((Element)v.get(850));

      /* Empieza nodo:851 / Elemento padre: 850   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(851)).setAttribute("src","b.gif" );
      ((Element)v.get(851)).setAttribute("width","8" );
      ((Element)v.get(851)).setAttribute("height","12" );
      ((Element)v.get(850)).appendChild((Element)v.get(851));
      /* Termina nodo:851   */
      /* Termina nodo:850   */
      /* Termina nodo:806   */

      /* Empieza nodo:852 / Elemento padre: 798   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(798)).appendChild((Element)v.get(852));

      /* Empieza nodo:853 / Elemento padre: 852   */
      v.add(doc.createElement("td"));
      ((Element)v.get(853)).setAttribute("width","12" );
      ((Element)v.get(853)).setAttribute("align","center" );
      ((Element)v.get(852)).appendChild((Element)v.get(853));

      /* Empieza nodo:854 / Elemento padre: 853   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(854)).setAttribute("src","b.gif" );
      ((Element)v.get(854)).setAttribute("width","12" );
      ((Element)v.get(854)).setAttribute("height","12" );
      ((Element)v.get(853)).appendChild((Element)v.get(854));
      /* Termina nodo:854   */
      /* Termina nodo:853   */

      /* Empieza nodo:855 / Elemento padre: 852   */
      v.add(doc.createElement("td"));
      ((Element)v.get(855)).setAttribute("width","750" );
      ((Element)v.get(852)).appendChild((Element)v.get(855));

      /* Empieza nodo:856 / Elemento padre: 855   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(856)).setAttribute("src","b.gif" );
      ((Element)v.get(855)).appendChild((Element)v.get(856));
      /* Termina nodo:856   */
      /* Termina nodo:855   */

      /* Empieza nodo:857 / Elemento padre: 852   */
      v.add(doc.createElement("td"));
      ((Element)v.get(857)).setAttribute("width","12" );
      ((Element)v.get(852)).appendChild((Element)v.get(857));

      /* Empieza nodo:858 / Elemento padre: 857   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(858)).setAttribute("src","b.gif" );
      ((Element)v.get(858)).setAttribute("width","12" );
      ((Element)v.get(858)).setAttribute("height","12" );
      ((Element)v.get(857)).appendChild((Element)v.get(858));
      /* Termina nodo:858   */
      /* Termina nodo:857   */
      /* Termina nodo:852   */
      /* Termina nodo:798   */
      /* Termina nodo:797   */

      /* Empieza nodo:859 / Elemento padre: 37   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(859)).setAttribute("nombre","capaListaRegiones" );
      ((Element)v.get(859)).setAttribute("alto","10" );
      ((Element)v.get(859)).setAttribute("ancho","10" );
      ((Element)v.get(859)).setAttribute("colorf","" );
      ((Element)v.get(859)).setAttribute("borde","1" );
      ((Element)v.get(859)).setAttribute("imagenf","" );
      ((Element)v.get(859)).setAttribute("repeat","" );
      ((Element)v.get(859)).setAttribute("padding","" );
      ((Element)v.get(859)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(859)).setAttribute("contravsb","" );
      ((Element)v.get(859)).setAttribute("zindex","" );
      ((Element)v.get(859)).setAttribute("x","10" );
      ((Element)v.get(859)).setAttribute("y","10" );
      ((Element)v.get(37)).appendChild((Element)v.get(859));

      /* Empieza nodo:860 / Elemento padre: 859   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(860)).setAttribute("seleccion","boton" );
      ((Element)v.get(860)).setAttribute("nombre","listaRegiones" );
      ((Element)v.get(860)).setAttribute("ancho","582" );
      ((Element)v.get(860)).setAttribute("alto","150" );
      ((Element)v.get(860)).setAttribute("multisel","-1" );
      ((Element)v.get(860)).setAttribute("incy","1" );
      ((Element)v.get(860)).setAttribute("incx","10" );
      ((Element)v.get(860)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(860)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(860)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(860)).setAttribute("accion","" );
      ((Element)v.get(860)).setAttribute("sep","|" );
      ((Element)v.get(860)).setAttribute("pixelsborde","3" );
      ((Element)v.get(860)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(859)).appendChild((Element)v.get(860));

      /* Empieza nodo:861 / Elemento padre: 860   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(861)).setAttribute("nombre","cabecera" );
      ((Element)v.get(861)).setAttribute("height","20" );
      ((Element)v.get(860)).appendChild((Element)v.get(861));

      /* Empieza nodo:862 / Elemento padre: 861   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(862)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(862)).setAttribute("ancho","13" );
      ((Element)v.get(861)).appendChild((Element)v.get(862));
      /* Termina nodo:862   */

      /* Empieza nodo:863 / Elemento padre: 861   */
   }

   private void getXML3510(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(863)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(863)).setAttribute("ancho","300" );
      ((Element)v.get(861)).appendChild((Element)v.get(863));

      /* Empieza nodo:864 / Elemento padre: 863   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(864)).setAttribute("nombre","lbDivisionesPoliticas" );
      ((Element)v.get(864)).setAttribute("ancho","300" );
      ((Element)v.get(864)).setAttribute("alto","20" );
      ((Element)v.get(864)).setAttribute("filas","1" );
      ((Element)v.get(864)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(864)).setAttribute("valor","Divisiones Políticas" );
      ((Element)v.get(864)).setAttribute("enviaroculto","N" );
      ((Element)v.get(863)).appendChild((Element)v.get(864));
      /* Termina nodo:864   */
      /* Termina nodo:863   */

      /* Empieza nodo:865 / Elemento padre: 861   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(865)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(865)).setAttribute("ancho","150" );
      ((Element)v.get(861)).appendChild((Element)v.get(865));

      /* Empieza nodo:866 / Elemento padre: 865   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(866)).setAttribute("nombre","lbPais01" );
      ((Element)v.get(866)).setAttribute("ancho","150" );
      ((Element)v.get(866)).setAttribute("alto","20" );
      ((Element)v.get(866)).setAttribute("filas","1" );
      ((Element)v.get(866)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(866)).setAttribute("valor","País 01" );
      ((Element)v.get(866)).setAttribute("enviaroculto","N" );
      ((Element)v.get(865)).appendChild((Element)v.get(866));
      /* Termina nodo:866   */
      /* Termina nodo:865   */
      /* Termina nodo:861   */

      /* Empieza nodo:867 / Elemento padre: 860   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(867)).setAttribute("ancho","10" );
      ((Element)v.get(867)).setAttribute("filas","1" );
      ((Element)v.get(867)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(860)).appendChild((Element)v.get(867));

      /* Empieza nodo:868 / Elemento padre: 867   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(868)).setAttribute("ancho","13" );
      ((Element)v.get(867)).appendChild((Element)v.get(868));
      /* Termina nodo:868   */

      /* Empieza nodo:869 / Elemento padre: 867   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(869)).setAttribute("ancho","300" );
      ((Element)v.get(869)).setAttribute("caracteres","100" );
      ((Element)v.get(867)).appendChild((Element)v.get(869));
      /* Termina nodo:869   */

      /* Empieza nodo:870 / Elemento padre: 867   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(870)).setAttribute("ancho","150" );
      ((Element)v.get(870)).setAttribute("caracteres","30" );
      ((Element)v.get(867)).appendChild((Element)v.get(870));
      /* Termina nodo:870   */
      /* Termina nodo:867   */

      /* Empieza nodo:871 / Elemento padre: 860   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(860)).appendChild((Element)v.get(871));
      /* Termina nodo:871   */
      /* Termina nodo:860   */
      /* Termina nodo:859   */

      /* Empieza nodo:872 / Elemento padre: 37   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(872)).setAttribute("nombre","capaListaZonas" );
      ((Element)v.get(872)).setAttribute("alto","10" );
      ((Element)v.get(872)).setAttribute("ancho","10" );
      ((Element)v.get(872)).setAttribute("colorf","" );
      ((Element)v.get(872)).setAttribute("borde","1" );
      ((Element)v.get(872)).setAttribute("imagenf","" );
      ((Element)v.get(872)).setAttribute("repeat","" );
      ((Element)v.get(872)).setAttribute("padding","" );
      ((Element)v.get(872)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(872)).setAttribute("contravsb","" );
      ((Element)v.get(872)).setAttribute("zindex","" );
      ((Element)v.get(872)).setAttribute("x","10" );
      ((Element)v.get(872)).setAttribute("y","10" );
      ((Element)v.get(37)).appendChild((Element)v.get(872));

      /* Empieza nodo:873 / Elemento padre: 872   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(873)).setAttribute("seleccion","boton" );
      ((Element)v.get(873)).setAttribute("nombre","listaZonas" );
      ((Element)v.get(873)).setAttribute("ancho","582" );
      ((Element)v.get(873)).setAttribute("alto","150" );
      ((Element)v.get(873)).setAttribute("multisel","-1" );
      ((Element)v.get(873)).setAttribute("incy","1" );
      ((Element)v.get(873)).setAttribute("incx","10" );
      ((Element)v.get(873)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(873)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(873)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(873)).setAttribute("accion","" );
      ((Element)v.get(873)).setAttribute("sep","|" );
      ((Element)v.get(873)).setAttribute("pixelsborde","3" );
      ((Element)v.get(873)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(872)).appendChild((Element)v.get(873));

      /* Empieza nodo:874 / Elemento padre: 873   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(874)).setAttribute("nombre","cabecera" );
      ((Element)v.get(874)).setAttribute("height","20" );
      ((Element)v.get(873)).appendChild((Element)v.get(874));

      /* Empieza nodo:875 / Elemento padre: 874   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(875)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(875)).setAttribute("ancho","13" );
      ((Element)v.get(874)).appendChild((Element)v.get(875));
      /* Termina nodo:875   */

      /* Empieza nodo:876 / Elemento padre: 874   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(876)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(876)).setAttribute("ancho","300" );
      ((Element)v.get(874)).appendChild((Element)v.get(876));

      /* Empieza nodo:877 / Elemento padre: 876   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(877)).setAttribute("nombre","lbDivisionesPoliticas" );
      ((Element)v.get(877)).setAttribute("ancho","300" );
   }

   private void getXML3600(Document doc) {
      ((Element)v.get(877)).setAttribute("alto","20" );
      ((Element)v.get(877)).setAttribute("filas","1" );
      ((Element)v.get(877)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(877)).setAttribute("valor","Divisiones Políticas" );
      ((Element)v.get(877)).setAttribute("enviaroculto","N" );
      ((Element)v.get(876)).appendChild((Element)v.get(877));
      /* Termina nodo:877   */
      /* Termina nodo:876   */

      /* Empieza nodo:878 / Elemento padre: 874   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(878)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(878)).setAttribute("ancho","150" );
      ((Element)v.get(874)).appendChild((Element)v.get(878));

      /* Empieza nodo:879 / Elemento padre: 878   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(879)).setAttribute("nombre","lbPais01" );
      ((Element)v.get(879)).setAttribute("ancho","150" );
      ((Element)v.get(879)).setAttribute("alto","20" );
      ((Element)v.get(879)).setAttribute("filas","1" );
      ((Element)v.get(879)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(879)).setAttribute("valor","País 01" );
      ((Element)v.get(879)).setAttribute("enviaroculto","N" );
      ((Element)v.get(878)).appendChild((Element)v.get(879));
      /* Termina nodo:879   */
      /* Termina nodo:878   */
      /* Termina nodo:874   */

      /* Empieza nodo:880 / Elemento padre: 873   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(880)).setAttribute("ancho","10" );
      ((Element)v.get(880)).setAttribute("filas","1" );
      ((Element)v.get(880)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(873)).appendChild((Element)v.get(880));

      /* Empieza nodo:881 / Elemento padre: 880   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(881)).setAttribute("ancho","13" );
      ((Element)v.get(880)).appendChild((Element)v.get(881));
      /* Termina nodo:881   */

      /* Empieza nodo:882 / Elemento padre: 880   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(882)).setAttribute("ancho","300" );
      ((Element)v.get(882)).setAttribute("caracteres","100" );
      ((Element)v.get(880)).appendChild((Element)v.get(882));
      /* Termina nodo:882   */

      /* Empieza nodo:883 / Elemento padre: 880   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(883)).setAttribute("ancho","150" );
      ((Element)v.get(883)).setAttribute("caracteres","30" );
      ((Element)v.get(880)).appendChild((Element)v.get(883));
      /* Termina nodo:883   */
      /* Termina nodo:880   */

      /* Empieza nodo:884 / Elemento padre: 873   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(873)).appendChild((Element)v.get(884));
      /* Termina nodo:884   */
      /* Termina nodo:873   */
      /* Termina nodo:872   */

      /* Empieza nodo:885 / Elemento padre: 37   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(885)).setAttribute("nombre","capaListaTiposClasificacion" );
      ((Element)v.get(885)).setAttribute("alto","10" );
      ((Element)v.get(885)).setAttribute("ancho","10" );
      ((Element)v.get(885)).setAttribute("colorf","" );
      ((Element)v.get(885)).setAttribute("borde","1" );
      ((Element)v.get(885)).setAttribute("imagenf","" );
      ((Element)v.get(885)).setAttribute("repeat","" );
      ((Element)v.get(885)).setAttribute("padding","" );
      ((Element)v.get(885)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(885)).setAttribute("contravsb","" );
      ((Element)v.get(885)).setAttribute("zindex","" );
      ((Element)v.get(885)).setAttribute("x","10" );
      ((Element)v.get(885)).setAttribute("y","10" );
      ((Element)v.get(37)).appendChild((Element)v.get(885));

      /* Empieza nodo:886 / Elemento padre: 885   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(886)).setAttribute("seleccion","boton" );
      ((Element)v.get(886)).setAttribute("nombre","listaTiposClasificacion" );
      ((Element)v.get(886)).setAttribute("ancho","582" );
      ((Element)v.get(886)).setAttribute("alto","150" );
      ((Element)v.get(886)).setAttribute("multisel","-1" );
      ((Element)v.get(886)).setAttribute("incy","1" );
      ((Element)v.get(886)).setAttribute("incx","10" );
      ((Element)v.get(886)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(886)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(886)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(886)).setAttribute("accion","" );
      ((Element)v.get(886)).setAttribute("sep","|" );
      ((Element)v.get(886)).setAttribute("pixelsborde","3" );
      ((Element)v.get(886)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(885)).appendChild((Element)v.get(886));

      /* Empieza nodo:887 / Elemento padre: 886   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(887)).setAttribute("nombre","cabecera" );
      ((Element)v.get(887)).setAttribute("height","20" );
      ((Element)v.get(886)).appendChild((Element)v.get(887));

      /* Empieza nodo:888 / Elemento padre: 887   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(888)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(888)).setAttribute("ancho","13" );
      ((Element)v.get(887)).appendChild((Element)v.get(888));
      /* Termina nodo:888   */

      /* Empieza nodo:889 / Elemento padre: 887   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(889)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(889)).setAttribute("ancho","300" );
      ((Element)v.get(887)).appendChild((Element)v.get(889));

      /* Empieza nodo:890 / Elemento padre: 889   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(890)).setAttribute("nombre","lbDivisionesPoliticas" );
      ((Element)v.get(890)).setAttribute("ancho","300" );
      ((Element)v.get(890)).setAttribute("alto","20" );
      ((Element)v.get(890)).setAttribute("filas","1" );
      ((Element)v.get(890)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(890)).setAttribute("valor","Divisiones Políticas" );
      ((Element)v.get(890)).setAttribute("enviaroculto","N" );
      ((Element)v.get(889)).appendChild((Element)v.get(890));
      /* Termina nodo:890   */
      /* Termina nodo:889   */

      /* Empieza nodo:891 / Elemento padre: 887   */
      v.add(doc.createElement("COL"));
   }

   private void getXML3690(Document doc) {
      ((Element)v.get(891)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(891)).setAttribute("ancho","150" );
      ((Element)v.get(887)).appendChild((Element)v.get(891));

      /* Empieza nodo:892 / Elemento padre: 891   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(892)).setAttribute("nombre","lbPais01" );
      ((Element)v.get(892)).setAttribute("ancho","150" );
      ((Element)v.get(892)).setAttribute("alto","20" );
      ((Element)v.get(892)).setAttribute("filas","1" );
      ((Element)v.get(892)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(892)).setAttribute("valor","País 01" );
      ((Element)v.get(892)).setAttribute("enviaroculto","N" );
      ((Element)v.get(891)).appendChild((Element)v.get(892));
      /* Termina nodo:892   */
      /* Termina nodo:891   */
      /* Termina nodo:887   */

      /* Empieza nodo:893 / Elemento padre: 886   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(893)).setAttribute("ancho","10" );
      ((Element)v.get(893)).setAttribute("filas","1" );
      ((Element)v.get(893)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(886)).appendChild((Element)v.get(893));

      /* Empieza nodo:894 / Elemento padre: 893   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(894)).setAttribute("ancho","13" );
      ((Element)v.get(893)).appendChild((Element)v.get(894));
      /* Termina nodo:894   */

      /* Empieza nodo:895 / Elemento padre: 893   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(895)).setAttribute("ancho","300" );
      ((Element)v.get(895)).setAttribute("caracteres","100" );
      ((Element)v.get(893)).appendChild((Element)v.get(895));
      /* Termina nodo:895   */

      /* Empieza nodo:896 / Elemento padre: 893   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(896)).setAttribute("ancho","150" );
      ((Element)v.get(896)).setAttribute("caracteres","30" );
      ((Element)v.get(893)).appendChild((Element)v.get(896));
      /* Termina nodo:896   */
      /* Termina nodo:893   */

      /* Empieza nodo:897 / Elemento padre: 886   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(886)).appendChild((Element)v.get(897));
      /* Termina nodo:897   */
      /* Termina nodo:886   */
      /* Termina nodo:885   */

      /* Empieza nodo:898 / Elemento padre: 37   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(898)).setAttribute("nombre","capaListaClasificaciones" );
      ((Element)v.get(898)).setAttribute("alto","10" );
      ((Element)v.get(898)).setAttribute("ancho","10" );
      ((Element)v.get(898)).setAttribute("colorf","" );
      ((Element)v.get(898)).setAttribute("borde","1" );
      ((Element)v.get(898)).setAttribute("imagenf","" );
      ((Element)v.get(898)).setAttribute("repeat","" );
      ((Element)v.get(898)).setAttribute("padding","" );
      ((Element)v.get(898)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(898)).setAttribute("contravsb","" );
      ((Element)v.get(898)).setAttribute("zindex","" );
      ((Element)v.get(898)).setAttribute("x","10" );
      ((Element)v.get(898)).setAttribute("y","10" );
      ((Element)v.get(37)).appendChild((Element)v.get(898));

      /* Empieza nodo:899 / Elemento padre: 898   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(899)).setAttribute("seleccion","boton" );
      ((Element)v.get(899)).setAttribute("nombre","listaClasificaciones" );
      ((Element)v.get(899)).setAttribute("ancho","582" );
      ((Element)v.get(899)).setAttribute("alto","150" );
      ((Element)v.get(899)).setAttribute("multisel","-1" );
      ((Element)v.get(899)).setAttribute("incy","1" );
      ((Element)v.get(899)).setAttribute("incx","10" );
      ((Element)v.get(899)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(899)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(899)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(899)).setAttribute("accion","" );
      ((Element)v.get(899)).setAttribute("sep","|" );
      ((Element)v.get(899)).setAttribute("pixelsborde","3" );
      ((Element)v.get(899)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(898)).appendChild((Element)v.get(899));

      /* Empieza nodo:900 / Elemento padre: 899   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(900)).setAttribute("nombre","cabecera" );
      ((Element)v.get(900)).setAttribute("height","20" );
      ((Element)v.get(899)).appendChild((Element)v.get(900));

      /* Empieza nodo:901 / Elemento padre: 900   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(901)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(901)).setAttribute("ancho","13" );
      ((Element)v.get(900)).appendChild((Element)v.get(901));
      /* Termina nodo:901   */

      /* Empieza nodo:902 / Elemento padre: 900   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(902)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(902)).setAttribute("ancho","300" );
      ((Element)v.get(900)).appendChild((Element)v.get(902));

      /* Empieza nodo:903 / Elemento padre: 902   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(903)).setAttribute("nombre","lbDivisionesPoliticas" );
      ((Element)v.get(903)).setAttribute("ancho","300" );
      ((Element)v.get(903)).setAttribute("alto","20" );
      ((Element)v.get(903)).setAttribute("filas","1" );
      ((Element)v.get(903)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(903)).setAttribute("valor","Divisiones Políticas" );
      ((Element)v.get(903)).setAttribute("enviaroculto","N" );
      ((Element)v.get(902)).appendChild((Element)v.get(903));
      /* Termina nodo:903   */
      /* Termina nodo:902   */

      /* Empieza nodo:904 / Elemento padre: 900   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(904)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(904)).setAttribute("ancho","150" );
      ((Element)v.get(900)).appendChild((Element)v.get(904));

      /* Empieza nodo:905 / Elemento padre: 904   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(905)).setAttribute("nombre","lbPais01" );
      ((Element)v.get(905)).setAttribute("ancho","150" );
      ((Element)v.get(905)).setAttribute("alto","20" );
   }

   private void getXML3780(Document doc) {
      ((Element)v.get(905)).setAttribute("filas","1" );
      ((Element)v.get(905)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(905)).setAttribute("valor","País 01" );
      ((Element)v.get(905)).setAttribute("enviaroculto","N" );
      ((Element)v.get(904)).appendChild((Element)v.get(905));
      /* Termina nodo:905   */
      /* Termina nodo:904   */
      /* Termina nodo:900   */

      /* Empieza nodo:906 / Elemento padre: 899   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(906)).setAttribute("ancho","10" );
      ((Element)v.get(906)).setAttribute("filas","1" );
      ((Element)v.get(906)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(899)).appendChild((Element)v.get(906));

      /* Empieza nodo:907 / Elemento padre: 906   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(907)).setAttribute("ancho","13" );
      ((Element)v.get(906)).appendChild((Element)v.get(907));
      /* Termina nodo:907   */

      /* Empieza nodo:908 / Elemento padre: 906   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(908)).setAttribute("ancho","300" );
      ((Element)v.get(908)).setAttribute("caracteres","100" );
      ((Element)v.get(906)).appendChild((Element)v.get(908));
      /* Termina nodo:908   */

      /* Empieza nodo:909 / Elemento padre: 906   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(909)).setAttribute("ancho","150" );
      ((Element)v.get(909)).setAttribute("caracteres","30" );
      ((Element)v.get(906)).appendChild((Element)v.get(909));
      /* Termina nodo:909   */
      /* Termina nodo:906   */

      /* Empieza nodo:910 / Elemento padre: 899   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(899)).appendChild((Element)v.get(910));
      /* Termina nodo:910   */
      /* Termina nodo:899   */
      /* Termina nodo:898   */

      /* Empieza nodo:911 / Elemento padre: 37   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(911)).setAttribute("nombre","capaListaSubaccesos" );
      ((Element)v.get(911)).setAttribute("alto","10" );
      ((Element)v.get(911)).setAttribute("ancho","10" );
      ((Element)v.get(911)).setAttribute("colorf","" );
      ((Element)v.get(911)).setAttribute("borde","1" );
      ((Element)v.get(911)).setAttribute("imagenf","" );
      ((Element)v.get(911)).setAttribute("repeat","" );
      ((Element)v.get(911)).setAttribute("padding","" );
      ((Element)v.get(911)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(911)).setAttribute("contravsb","" );
      ((Element)v.get(911)).setAttribute("zindex","" );
      ((Element)v.get(911)).setAttribute("x","10" );
      ((Element)v.get(911)).setAttribute("y","10" );
      ((Element)v.get(37)).appendChild((Element)v.get(911));

      /* Empieza nodo:912 / Elemento padre: 911   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(912)).setAttribute("seleccion","boton" );
      ((Element)v.get(912)).setAttribute("nombre","listaSubaccesos" );
      ((Element)v.get(912)).setAttribute("ancho","582" );
      ((Element)v.get(912)).setAttribute("alto","150" );
      ((Element)v.get(912)).setAttribute("multisel","-1" );
      ((Element)v.get(912)).setAttribute("incy","1" );
      ((Element)v.get(912)).setAttribute("incx","10" );
      ((Element)v.get(912)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(912)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(912)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(912)).setAttribute("accion","" );
      ((Element)v.get(912)).setAttribute("sep","|" );
      ((Element)v.get(912)).setAttribute("pixelsborde","3" );
      ((Element)v.get(912)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(911)).appendChild((Element)v.get(912));

      /* Empieza nodo:913 / Elemento padre: 912   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(913)).setAttribute("nombre","cabecera" );
      ((Element)v.get(913)).setAttribute("height","20" );
      ((Element)v.get(912)).appendChild((Element)v.get(913));

      /* Empieza nodo:914 / Elemento padre: 913   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(914)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(914)).setAttribute("ancho","13" );
      ((Element)v.get(913)).appendChild((Element)v.get(914));
      /* Termina nodo:914   */

      /* Empieza nodo:915 / Elemento padre: 913   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(915)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(915)).setAttribute("ancho","300" );
      ((Element)v.get(913)).appendChild((Element)v.get(915));

      /* Empieza nodo:916 / Elemento padre: 915   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(916)).setAttribute("nombre","lblDesc" );
      ((Element)v.get(916)).setAttribute("ancho","300" );
      ((Element)v.get(916)).setAttribute("alto","20" );
      ((Element)v.get(916)).setAttribute("filas","1" );
      ((Element)v.get(916)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(916)).setAttribute("valor","Divisiones Políticas" );
      ((Element)v.get(916)).setAttribute("enviaroculto","N" );
      ((Element)v.get(915)).appendChild((Element)v.get(916));
      /* Termina nodo:916   */
      /* Termina nodo:915   */

      /* Empieza nodo:917 / Elemento padre: 913   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(917)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(917)).setAttribute("ancho","150" );
      ((Element)v.get(913)).appendChild((Element)v.get(917));

      /* Empieza nodo:918 / Elemento padre: 917   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(918)).setAttribute("nombre","lblOidAcceso" );
      ((Element)v.get(918)).setAttribute("ancho","150" );
      ((Element)v.get(918)).setAttribute("alto","20" );
      ((Element)v.get(918)).setAttribute("filas","1" );
      ((Element)v.get(918)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(918)).setAttribute("valor","País 01" );
      ((Element)v.get(918)).setAttribute("enviaroculto","N" );
      ((Element)v.get(917)).appendChild((Element)v.get(918));
      /* Termina nodo:918   */
      /* Termina nodo:917   */

      /* Empieza nodo:919 / Elemento padre: 913   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(919)).setAttribute("id","fondoCabecera" );
   }

   private void getXML3870(Document doc) {
      ((Element)v.get(919)).setAttribute("ancho","300" );
      ((Element)v.get(913)).appendChild((Element)v.get(919));

      /* Empieza nodo:920 / Elemento padre: 919   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(920)).setAttribute("nombre","lblCanaOidCana" );
      ((Element)v.get(920)).setAttribute("ancho","300" );
      ((Element)v.get(920)).setAttribute("alto","20" );
      ((Element)v.get(920)).setAttribute("filas","1" );
      ((Element)v.get(920)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(920)).setAttribute("valor","Divisiones Políticas" );
      ((Element)v.get(920)).setAttribute("enviaroculto","N" );
      ((Element)v.get(919)).appendChild((Element)v.get(920));
      /* Termina nodo:920   */
      /* Termina nodo:919   */
      /* Termina nodo:913   */

      /* Empieza nodo:921 / Elemento padre: 912   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(921)).setAttribute("ancho","10" );
      ((Element)v.get(921)).setAttribute("filas","1" );
      ((Element)v.get(921)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(912)).appendChild((Element)v.get(921));

      /* Empieza nodo:922 / Elemento padre: 921   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(922)).setAttribute("ancho","13" );
      ((Element)v.get(921)).appendChild((Element)v.get(922));
      /* Termina nodo:922   */

      /* Empieza nodo:923 / Elemento padre: 921   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(923)).setAttribute("ancho","300" );
      ((Element)v.get(923)).setAttribute("caracteres","100" );
      ((Element)v.get(921)).appendChild((Element)v.get(923));
      /* Termina nodo:923   */

      /* Empieza nodo:924 / Elemento padre: 921   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(924)).setAttribute("ancho","150" );
      ((Element)v.get(924)).setAttribute("caracteres","30" );
      ((Element)v.get(921)).appendChild((Element)v.get(924));
      /* Termina nodo:924   */

      /* Empieza nodo:925 / Elemento padre: 921   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(925)).setAttribute("ancho","150" );
      ((Element)v.get(925)).setAttribute("caracteres","30" );
      ((Element)v.get(921)).appendChild((Element)v.get(925));
      /* Termina nodo:925   */
      /* Termina nodo:921   */

      /* Empieza nodo:926 / Elemento padre: 912   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(912)).appendChild((Element)v.get(926));
      /* Termina nodo:926   */
      /* Termina nodo:912   */
      /* Termina nodo:911   */

      /* Empieza nodo:927 / Elemento padre: 37   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(927)).setAttribute("nombre","capaListaEnvioSolicitud" );
      ((Element)v.get(927)).setAttribute("alto","10" );
      ((Element)v.get(927)).setAttribute("ancho","10" );
      ((Element)v.get(927)).setAttribute("colorf","" );
      ((Element)v.get(927)).setAttribute("borde","1" );
      ((Element)v.get(927)).setAttribute("imagenf","" );
      ((Element)v.get(927)).setAttribute("repeat","" );
      ((Element)v.get(927)).setAttribute("padding","" );
      ((Element)v.get(927)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(927)).setAttribute("contravsb","" );
      ((Element)v.get(927)).setAttribute("zindex","" );
      ((Element)v.get(927)).setAttribute("x","10" );
      ((Element)v.get(927)).setAttribute("y","10" );
      ((Element)v.get(37)).appendChild((Element)v.get(927));

      /* Empieza nodo:928 / Elemento padre: 927   */
      v.add(doc.createElement("LISTA"));
      ((Element)v.get(928)).setAttribute("seleccion","boton" );
      ((Element)v.get(928)).setAttribute("nombre","listaEnvioSolicitud" );
      ((Element)v.get(928)).setAttribute("ancho","582" );
      ((Element)v.get(928)).setAttribute("alto","150" );
      ((Element)v.get(928)).setAttribute("multisel","-1" );
      ((Element)v.get(928)).setAttribute("incy","1" );
      ((Element)v.get(928)).setAttribute("incx","10" );
      ((Element)v.get(928)).setAttribute("colorf","#EFEFEF" );
      ((Element)v.get(928)).setAttribute("imagenoff","close_no.gif" );
      ((Element)v.get(928)).setAttribute("imagenon","close_up.gif" );
      ((Element)v.get(928)).setAttribute("accion","" );
      ((Element)v.get(928)).setAttribute("sep","|" );
      ((Element)v.get(928)).setAttribute("pixelsborde","3" );
      ((Element)v.get(928)).setAttribute("colorborde","#CCCCCC" );
      ((Element)v.get(927)).appendChild((Element)v.get(928));

      /* Empieza nodo:929 / Elemento padre: 928   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(929)).setAttribute("nombre","cabecera" );
      ((Element)v.get(929)).setAttribute("height","20" );
      ((Element)v.get(928)).appendChild((Element)v.get(929));

      /* Empieza nodo:930 / Elemento padre: 929   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(930)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(930)).setAttribute("ancho","13" );
      ((Element)v.get(929)).appendChild((Element)v.get(930));
      /* Termina nodo:930   */

      /* Empieza nodo:931 / Elemento padre: 929   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(931)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(931)).setAttribute("ancho","300" );
      ((Element)v.get(929)).appendChild((Element)v.get(931));

      /* Empieza nodo:932 / Elemento padre: 931   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(932)).setAttribute("nombre","lblOidEnvio" );
      ((Element)v.get(932)).setAttribute("ancho","300" );
      ((Element)v.get(932)).setAttribute("alto","20" );
      ((Element)v.get(932)).setAttribute("filas","1" );
      ((Element)v.get(932)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(932)).setAttribute("valor","Divisiones Políticas" );
      ((Element)v.get(932)).setAttribute("enviaroculto","N" );
      ((Element)v.get(931)).appendChild((Element)v.get(932));
      /* Termina nodo:932   */
      /* Termina nodo:931   */

      /* Empieza nodo:933 / Elemento padre: 929   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(933)).setAttribute("id","fondoCabecera" );
      ((Element)v.get(933)).setAttribute("ancho","150" );
      ((Element)v.get(929)).appendChild((Element)v.get(933));

      /* Empieza nodo:934 / Elemento padre: 933   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML3960(Document doc) {
      ((Element)v.get(934)).setAttribute("nombre","lblDescEnvioSolicitud" );
      ((Element)v.get(934)).setAttribute("ancho","150" );
      ((Element)v.get(934)).setAttribute("alto","20" );
      ((Element)v.get(934)).setAttribute("filas","1" );
      ((Element)v.get(934)).setAttribute("id","datosCamposCabecera" );
      ((Element)v.get(934)).setAttribute("valor","País 01" );
      ((Element)v.get(934)).setAttribute("enviaroculto","N" );
      ((Element)v.get(933)).appendChild((Element)v.get(934));
      /* Termina nodo:934   */
      /* Termina nodo:933   */
      /* Termina nodo:929   */

      /* Empieza nodo:935 / Elemento padre: 928   */
      v.add(doc.createElement("PRESENTACION"));
      ((Element)v.get(935)).setAttribute("ancho","10" );
      ((Element)v.get(935)).setAttribute("filas","1" );
      ((Element)v.get(935)).setAttribute("bloquesid","['datosCamposCenterImpar', 'datosCamposCenterPar']" );
      ((Element)v.get(928)).appendChild((Element)v.get(935));

      /* Empieza nodo:936 / Elemento padre: 935   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(936)).setAttribute("ancho","13" );
      ((Element)v.get(935)).appendChild((Element)v.get(936));
      /* Termina nodo:936   */

      /* Empieza nodo:937 / Elemento padre: 935   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(937)).setAttribute("ancho","300" );
      ((Element)v.get(937)).setAttribute("caracteres","100" );
      ((Element)v.get(935)).appendChild((Element)v.get(937));
      /* Termina nodo:937   */

      /* Empieza nodo:938 / Elemento padre: 935   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(938)).setAttribute("ancho","150" );
      ((Element)v.get(938)).setAttribute("caracteres","100" );
      ((Element)v.get(935)).appendChild((Element)v.get(938));
      /* Termina nodo:938   */
      /* Termina nodo:935   */

      /* Empieza nodo:939 / Elemento padre: 928   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(928)).appendChild((Element)v.get(939));
      /* Termina nodo:939   */
      /* Termina nodo:928   */
      /* Termina nodo:927   */
      /* Termina nodo:37   */


   }

}

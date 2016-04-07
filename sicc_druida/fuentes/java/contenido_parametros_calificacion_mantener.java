
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_parametros_calificacion_mantener  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_parametros_calificacion_mantener" );
      ((Element)v.get(0)).setAttribute("cod","0491" );
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
      ((Element)v.get(4)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(5)).setAttribute("src","pestanyas_concurso_inc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(6)).setAttribute("src","validaciones_sicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(7)).setAttribute("src","contenido_parametros_calificacion_mantener.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(9));

      /* Empieza nodo:10 / Elemento padre: 9   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbFormaCalculo" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","1671" );
      ((Element)v.get(10)).setAttribute("group","FormaCalculo" );
      ((Element)v.get(9)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 9   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbTipoIncremento" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","1963" );
      ((Element)v.get(11)).setAttribute("group","tipoIncremento" );
      ((Element)v.get(9)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 9   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","cbPeriodoEvaluacionDesde" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","1958" );
      ((Element)v.get(12)).setAttribute("group","periodos" );
      ((Element)v.get(9)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 9   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","cbPeriodoEvaluacionHasta" );
      ((Element)v.get(13)).setAttribute("required","true" );
      ((Element)v.get(13)).setAttribute("cod","1959" );
      ((Element)v.get(13)).setAttribute("group","periodos" );
      ((Element)v.get(9)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 9   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","cbTipoDeterminacionMetas" );
      ((Element)v.get(14)).setAttribute("required","true" );
      ((Element)v.get(14)).setAttribute("cod","1962" );
      ((Element)v.get(14)).setAttribute("group","tipoDetMetas" );
      ((Element)v.get(9)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 9   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(15)).setAttribute("name","cbTipoVentaIncremental" );
      ((Element)v.get(15)).setAttribute("required","true" );
      ((Element)v.get(15)).setAttribute("cod","2443" );
      ((Element)v.get(15)).setAttribute("group","tipoVentaIncremental" );
      ((Element)v.get(9)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 9   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(16)).setAttribute("name","txtDesde" );
      ((Element)v.get(16)).setAttribute("required","true" );
      ((Element)v.get(16)).setAttribute("cod","555" );
      ((Element)v.get(16)).setAttribute("group","rangoIncremento" );
      ((Element)v.get(16)).setAttribute("format","n" );
      ((Element)v.get(16)).setAttribute("min","0" );
      ((Element)v.get(16)).setAttribute("max","9999999999.99" );
      ((Element)v.get(9)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 9   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(17)).setAttribute("name","txtHasta" );
      ((Element)v.get(17)).setAttribute("required","true" );
      ((Element)v.get(17)).setAttribute("cod","145" );
      ((Element)v.get(17)).setAttribute("group","rangoIncremento" );
      ((Element)v.get(17)).setAttribute("format","n" );
      ((Element)v.get(17)).setAttribute("min","0" );
      ((Element)v.get(17)).setAttribute("max","9999999999.99" );
      ((Element)v.get(9)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 9   */
      v.add(doc.createElement("ELEMENTO"));
   }

   private void getXML90(Document doc) {
      ((Element)v.get(18)).setAttribute("name","txtIncremento" );
      ((Element)v.get(18)).setAttribute("required","true" );
      ((Element)v.get(18)).setAttribute("cod","1740" );
      ((Element)v.get(18)).setAttribute("group","rangoIncrementoPorcentaje" );
      ((Element)v.get(18)).setAttribute("format","n" );
      ((Element)v.get(18)).setAttribute("min","1" );
      ((Element)v.get(18)).setAttribute("max","999" );
      ((Element)v.get(9)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 9   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(19)).setAttribute("name","txtIncremento" );
      ((Element)v.get(19)).setAttribute("required","true" );
      ((Element)v.get(19)).setAttribute("cod","1740" );
      ((Element)v.get(19)).setAttribute("group","rangoIncrementoNOPorcentaje" );
      ((Element)v.get(19)).setAttribute("format","n" );
      ((Element)v.get(19)).setAttribute("min","0" );
      ((Element)v.get(19)).setAttribute("max","9999999999.99" );
      ((Element)v.get(9)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */
      /* Termina nodo:9   */

      /* Empieza nodo:20 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(20)).setAttribute("nombre","formulario" );
      ((Element)v.get(20)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(20));

      /* Empieza nodo:21 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","accion" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","idPestanyaDest" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","opcionMenu" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","datosObligatorios" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","oidParamCalificacion" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","oidDirigidoA" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hDescDirigidoA" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","oidTipoVentaCalificacion" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","indMetasBloqueadas" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","listasCalificacion" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","cteOidTipoVtaCalifProyectada" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","cteOidTipoVtaCalifHistorica" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","listaVariablesVentaProyectada" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","listaMetasVentaProyectada" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(38)).setAttribute("nombre","listaMetasTipoVenta" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","listaIncrementosPorRango" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","descTipoVentaCalificacion" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","hPeriodoEvaluacionDesde" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hPeriodoEvaluacionHasta" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hTipoVentaIncremental" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","hTipoVentaHistorica" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","hTipoDeterminacionMetas" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","hFormaCalculo" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","hTipoIncremento" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","hBloquearMetas" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","hMetasModificables" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","hComunicaciones" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","hDevoluciones" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","hAnulaciones" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","hFaltantesNoAnunciados" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","hEstadoCbPeriodoEvaluacionDesde" );
      ((Element)v.get(54)).setAttribute("valor","S" );
      ((Element)v.get(20)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","hEstadoCbPeriodoEvaluacionHasta" );
      ((Element)v.get(55)).setAttribute("valor","S" );
      ((Element)v.get(20)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","hEstadoCbTipoVentaIncremental" );
      ((Element)v.get(56)).setAttribute("valor","S" );
      ((Element)v.get(20)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","hEstadoCbTipoVentaHistorica" );
      ((Element)v.get(57)).setAttribute("valor","S" );
      ((Element)v.get(20)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","hEstadoCbTipoDeterminacionMetas" );
      ((Element)v.get(58)).setAttribute("valor","S" );
      ((Element)v.get(20)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","hEstadoCbFormaCalculo" );
      ((Element)v.get(59)).setAttribute("valor","S" );
      ((Element)v.get(20)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","hEstadoCbTipoIncremento" );
      ((Element)v.get(60)).setAttribute("valor","S" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(20)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","hEstadoCkBloquearMetas" );
      ((Element)v.get(61)).setAttribute("valor","S" );
      ((Element)v.get(20)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","hEstadoCkMetasModificables" );
      ((Element)v.get(62)).setAttribute("valor","S" );
      ((Element)v.get(20)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(63)).setAttribute("nombre","hEstadoCkComunicaciones" );
      ((Element)v.get(63)).setAttribute("valor","S" );
      ((Element)v.get(20)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(64)).setAttribute("nombre","hEstadoCkDevolucines" );
      ((Element)v.get(64)).setAttribute("valor","S" );
      ((Element)v.get(20)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(65)).setAttribute("nombre","hEstadoCkAnulaciones" );
      ((Element)v.get(65)).setAttribute("valor","S" );
      ((Element)v.get(20)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(66)).setAttribute("nombre","hEstadoCkFaltantesNoAnunciados" );
      ((Element)v.get(66)).setAttribute("valor","S" );
      ((Element)v.get(20)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(67)).setAttribute("nombre","hEstadoTxtMensaje" );
      ((Element)v.get(67)).setAttribute("valor","S" );
      ((Element)v.get(20)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(68)).setAttribute("nombre","hEstadoTxtDesde" );
      ((Element)v.get(68)).setAttribute("valor","S" );
      ((Element)v.get(20)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(69)).setAttribute("nombre","hEstadoTxtHasta" );
      ((Element)v.get(69)).setAttribute("valor","S" );
      ((Element)v.get(20)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(70)).setAttribute("nombre","hEstadoTxtIncremento" );
      ((Element)v.get(70)).setAttribute("valor","S" );
      ((Element)v.get(20)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(71)).setAttribute("nombre","hEstadoTxtValorIncremento" );
      ((Element)v.get(71)).setAttribute("valor","S" );
      ((Element)v.get(20)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(72)).setAttribute("nombre","hEstadoBtnAnadir" );
      ((Element)v.get(72)).setAttribute("valor","S" );
      ((Element)v.get(20)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(73)).setAttribute("nombre","hEstadoBtnProductosCalificar" );
      ((Element)v.get(73)).setAttribute("valor","S" );
      ((Element)v.get(20)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(74)).setAttribute("nombre","hEstadoBtnEliminar" );
      ((Element)v.get(74)).setAttribute("valor","S" );
      ((Element)v.get(20)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(75)).setAttribute("nombre","hEstadoBtnCalcularMetas" );
      ((Element)v.get(75)).setAttribute("valor","S" );
      ((Element)v.get(20)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(76)).setAttribute("nombre","hEstadoBtnMantenerMetas" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */

      /* Empieza nodo:77 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(77)).setAttribute("nombre","hEstadoBtnDefinirVentaProyectada" );
      ((Element)v.get(77)).setAttribute("valor","S" );
      ((Element)v.get(20)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */

      /* Empieza nodo:78 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(78)).setAttribute("nombre","hEstadoBtnConsultarMetasTipoVenta" );
      ((Element)v.get(78)).setAttribute("valor","N" );
      ((Element)v.get(20)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */

      /* Empieza nodo:79 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(79)).setAttribute("nombre","hEstadoBtnConsultarMetasVentaProyectada" );
      ((Element)v.get(79)).setAttribute("valor","N" );
      ((Element)v.get(20)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */

      /* Empieza nodo:80 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(80)).setAttribute("nombre","OID_TIPO_VTA_INC_INCREMENTAL_NIVELES" );
      ((Element)v.get(80)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */

      /* Empieza nodo:81 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(81)).setAttribute("nombre","OID_TIPO_VTA_INC_INCREMENTAL" );
      ((Element)v.get(81)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */

      /* Empieza nodo:82 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(82)).setAttribute("nombre","hIndEstadoProductos" );
      ((Element)v.get(82)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */

      /* Empieza nodo:83 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(83)).setAttribute("nombre","hIndEstadoAmbitoGeografico" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */

      /* Empieza nodo:84 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(84)).setAttribute("nombre","hIndEstadoCalificion" );
      ((Element)v.get(84)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */

      /* Empieza nodo:85 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(85)).setAttribute("nombre","hIndEstadoGerentes" );
      ((Element)v.get(85)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */

      /* Empieza nodo:86 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(86)).setAttribute("nombre","hIndEstadoConsultoras" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */

      /* Empieza nodo:87 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(87)).setAttribute("nombre","hIndEstadoProgramaNuevas" );
      ((Element)v.get(87)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */

      /* Empieza nodo:88 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(88)).setAttribute("nombre","hIndEstadoMultinivel" );
      ((Element)v.get(88)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */

      /* Empieza nodo:89 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(89)).setAttribute("nombre","valorMenu" );
      ((Element)v.get(89)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */

      /* Empieza nodo:90 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(90)).setAttribute("nombre","hIndEstadoCapaIncrementos" );
      ((Element)v.get(90)).setAttribute("valor","N" );
      ((Element)v.get(20)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */

      /* Empieza nodo:91 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(91)).setAttribute("nombre","oidPerDesde" );
      ((Element)v.get(91)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */

      /* Empieza nodo:92 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(92)).setAttribute("nombre","oidPerHasta" );
      ((Element)v.get(92)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */

      /* Empieza nodo:93 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(93)).setAttribute("nombre","oidFormaCal" );
      ((Element)v.get(93)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */

      /* Empieza nodo:94 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(94)).setAttribute("nombre","valIncremento" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */

      /* Empieza nodo:95 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(95)).setAttribute("nombre","tipoIncremento" );
      ((Element)v.get(95)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */

      /* Empieza nodo:96 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(96)).setAttribute("nombre","sOidAgrupacion" );
      ((Element)v.get(96)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */

      /* Empieza nodo:97 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(97)).setAttribute("nombre","tempCkActivas" );
      ((Element)v.get(97)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */

      /* Empieza nodo:98 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(98)).setAttribute("nombre","tempCkIngreso" );
      ((Element)v.get(98)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */

      /* Empieza nodo:99 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(99)).setAttribute("nombre","tempCkReingreso" );
      ((Element)v.get(99)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */

      /* Empieza nodo:100 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(100)).setAttribute("nombre","tempCkEgresos" );
      ((Element)v.get(100)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */

      /* Empieza nodo:101 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(101)).setAttribute("nombre","tempCkEntregadas" );
      ((Element)v.get(101)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */

      /* Empieza nodo:102 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(102)).setAttribute("nombre","tempCkRecibidas" );
      ((Element)v.get(102)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */

      /* Empieza nodo:103 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(103)).setAttribute("nombre","tempCkCapitalizacion" );
      ((Element)v.get(103)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */

      /* Empieza nodo:104 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(104)).setAttribute("nombre","tempCkActivasFinales" );
      ((Element)v.get(104)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */

      /* Empieza nodo:105 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(105)).setAttribute("nombre","tempCkActividad" );
      ((Element)v.get(105)).setAttribute("valor","" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(20)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */

      /* Empieza nodo:106 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(106)).setAttribute("nombre","tempCkNumpedidos" );
      ((Element)v.get(106)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */

      /* Empieza nodo:107 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(107)).setAttribute("nombre","tempCkPrecioPromedioUnitario" );
      ((Element)v.get(107)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */

      /* Empieza nodo:108 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(108)).setAttribute("nombre","tempCkPromedioVentaPedido" );
      ((Element)v.get(108)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */

      /* Empieza nodo:109 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(109)).setAttribute("nombre","tempCkPromedioUnidadesPedido" );
      ((Element)v.get(109)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */

      /* Empieza nodo:110 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(110)).setAttribute("nombre","tempCkPromedioOrdenesPedido" );
      ((Element)v.get(110)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */

      /* Empieza nodo:111 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(111)).setAttribute("nombre","tempCkRetencion" );
      ((Element)v.get(111)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */

      /* Empieza nodo:112 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(112)).setAttribute("nombre","tempCkVentaEstadisticable" );
      ((Element)v.get(112)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */

      /* Empieza nodo:113 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(113)).setAttribute("nombre","variablesVentaProyectada" );
      ((Element)v.get(113)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */

      /* Empieza nodo:114 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(114)).setAttribute("nombre","tempOidTipoVentaIncremental" );
      ((Element)v.get(114)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */

      /* Empieza nodo:115 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(115)).setAttribute("nombre","incrementoPorcentaje" );
      ((Element)v.get(115)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */

      /* Empieza nodo:116 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(116)).setAttribute("nombre","incrementoCantidad" );
      ((Element)v.get(116)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */

      /* Empieza nodo:117 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(117)).setAttribute("nombre","hEstadoValorIncremento" );
      ((Element)v.get(117)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */

      /* Empieza nodo:118 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(118)).setAttribute("nombre","hidLstEstatusVta" );
      ((Element)v.get(118)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */

      /* Empieza nodo:119 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(119)).setAttribute("nombre","hFormatoDef" );
      ((Element)v.get(119)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */

      /* Empieza nodo:120 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(120)).setAttribute("nombre","cteOidDirigidoAConsultora" );
      ((Element)v.get(120)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */

      /* Empieza nodo:121 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(121)).setAttribute("nombre","tieneCalificacionParticipantes" );
      ((Element)v.get(121)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */

      /* Empieza nodo:122 / Elemento padre: 20   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(122)).setAttribute("nombre","tieneEstatusDeVenta" );
      ((Element)v.get(122)).setAttribute("valor","" );
      ((Element)v.get(20)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */

      /* Empieza nodo:123 / Elemento padre: 20   */
      v.add(doc.createElement("table"));
      ((Element)v.get(123)).setAttribute("width","100%" );
      ((Element)v.get(123)).setAttribute("height","100%" );
      ((Element)v.get(123)).setAttribute("border","0" );
      ((Element)v.get(123)).setAttribute("align","center" );
      ((Element)v.get(123)).setAttribute("cellpadding","0" );
      ((Element)v.get(123)).setAttribute("cellspacing","0" );
      ((Element)v.get(123)).setAttribute("class","menu4" );
      ((Element)v.get(20)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).setAttribute("width","12" );
      ((Element)v.get(125)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(125)).setAttribute("class","menu5texto" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","12" );
      ((Element)v.get(126)).setAttribute("height","30" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 124   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(127)).setAttribute("class","menu5texto" );
      ((Element)v.get(124)).appendChild((Element)v.get(127));

      /* Elemento padre:127 / Elemento actual: 128   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(127)).appendChild((Text)v.get(128));

      /* Termina nodo Texto:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("width","10" );
      ((Element)v.get(129)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(129)).setAttribute("class","menu5texto" );
      ((Element)v.get(124)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","10" );
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).setAttribute("width","92" );
      ((Element)v.get(131)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(131)).setAttribute("class","menu5texto" );
      ((Element)v.get(124)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("table"));
      ((Element)v.get(132)).setAttribute("width","75" );
      ((Element)v.get(132)).setAttribute("border","1" );
      ((Element)v.get(132)).setAttribute("align","center" );
      ((Element)v.get(132)).setAttribute("cellpadding","1" );
      ((Element)v.get(132)).setAttribute("cellspacing","0" );
      ((Element)v.get(132)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(132)).setAttribute("onmouseover","activarPuntero('formulario', 1, 'lblParametrosGenerales');" );
      ((Element)v.get(132)).setAttribute("onclick","onClickPestanyaPagina(1, 'formulario', 'LPMantenerParametrosCalificacion');" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(133)).setAttribute("align","center" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(135)).setAttribute("nombre","lblParametrosGenerales" );
      ((Element)v.get(135)).setAttribute("alto","13" );
      ((Element)v.get(135)).setAttribute("filas","1" );
      ((Element)v.get(135)).setAttribute("valor","" );
      ((Element)v.get(135)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(135)).setAttribute("cod","00393" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:136 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(136)).setAttribute("width","10" );
      ((Element)v.get(136)).setAttribute("class","menu5texto" );
      ((Element)v.get(124)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","10" );
      ((Element)v.get(137)).setAttribute("height","8" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).setAttribute("width","20" );
      ((Element)v.get(138)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(138)).setAttribute("class","menu5texto" );
      ((Element)v.get(124)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("table"));
      ((Element)v.get(139)).setAttribute("width","75" );
      ((Element)v.get(139)).setAttribute("border","1" );
      ((Element)v.get(139)).setAttribute("align","center" );
      ((Element)v.get(139)).setAttribute("cellpadding","1" );
      ((Element)v.get(139)).setAttribute("cellspacing","0" );
      ((Element)v.get(139)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(139)).setAttribute("onmouseover","activarPuntero('formulario', 5, 'lblProductos');" );
      ((Element)v.get(139)).setAttribute("onclick","onClickPestanyaPagina(5, 'formulario', 'LPMantenerParametrosCalificacion');" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(140)).setAttribute("align","center" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("td"));
      ((Element)v.get(141)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(142)).setAttribute("nombre","lblProductos" );
      ((Element)v.get(142)).setAttribute("alto","13" );
      ((Element)v.get(142)).setAttribute("filas","1" );
      ((Element)v.get(142)).setAttribute("valor","" );
      ((Element)v.get(142)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(142)).setAttribute("cod","0094" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:143 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).setAttribute("width","10" );
      ((Element)v.get(143)).setAttribute("class","menu5texto" );
      ((Element)v.get(124)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","10" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(144)).setAttribute("height","8" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).setAttribute("width","20" );
      ((Element)v.get(145)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(145)).setAttribute("class","menu5texto" );
      ((Element)v.get(124)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("table"));
      ((Element)v.get(146)).setAttribute("width","75" );
      ((Element)v.get(146)).setAttribute("border","1" );
      ((Element)v.get(146)).setAttribute("align","center" );
      ((Element)v.get(146)).setAttribute("cellpadding","1" );
      ((Element)v.get(146)).setAttribute("cellspacing","0" );
      ((Element)v.get(146)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(146)).setAttribute("onmouseover","activarPuntero('formulario', 6, 'lblPremios');" );
      ((Element)v.get(146)).setAttribute("onclick","onClickPestanyaPagina(6, 'formulario', 'LPMantenerParametrosCalificacion');" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(147)).setAttribute("align","center" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(149)).setAttribute("nombre","lblPremios" );
      ((Element)v.get(149)).setAttribute("alto","13" );
      ((Element)v.get(149)).setAttribute("filas","1" );
      ((Element)v.get(149)).setAttribute("valor","" );
      ((Element)v.get(149)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(149)).setAttribute("cod","00394" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:150 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).setAttribute("width","10" );
      ((Element)v.get(150)).setAttribute("class","menu5texto" );
      ((Element)v.get(124)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).setAttribute("width","10" );
      ((Element)v.get(151)).setAttribute("height","8" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).setAttribute("width","20" );
      ((Element)v.get(152)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(152)).setAttribute("class","menu5texto" );
      ((Element)v.get(124)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("table"));
      ((Element)v.get(153)).setAttribute("width","75" );
      ((Element)v.get(153)).setAttribute("border","1" );
      ((Element)v.get(153)).setAttribute("align","center" );
      ((Element)v.get(153)).setAttribute("cellpadding","1" );
      ((Element)v.get(153)).setAttribute("cellspacing","0" );
      ((Element)v.get(153)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(153)).setAttribute("onmouseover","activarPuntero('formulario', 7, 'lblRequisitos');" );
      ((Element)v.get(153)).setAttribute("onclick","onClickPestanyaPagina(7, 'formulario', 'LPMantenerParametrosCalificacion');" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(154)).setAttribute("align","center" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(156)).setAttribute("nombre","lblRequisitos" );
      ((Element)v.get(156)).setAttribute("alto","13" );
      ((Element)v.get(156)).setAttribute("filas","1" );
      ((Element)v.get(156)).setAttribute("valor","" );
      ((Element)v.get(156)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(156)).setAttribute("cod","00395" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:157 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).setAttribute("width","10" );
      ((Element)v.get(157)).setAttribute("class","menu5texto" );
      ((Element)v.get(124)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(158)).setAttribute("width","10" );
      ((Element)v.get(158)).setAttribute("height","8" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).setAttribute("width","20" );
      ((Element)v.get(159)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(159)).setAttribute("class","menu5texto" );
      ((Element)v.get(124)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("table"));
      ((Element)v.get(160)).setAttribute("width","75" );
      ((Element)v.get(160)).setAttribute("border","1" );
      ((Element)v.get(160)).setAttribute("align","center" );
      ((Element)v.get(160)).setAttribute("cellpadding","1" );
      ((Element)v.get(160)).setAttribute("cellspacing","0" );
      ((Element)v.get(160)).setAttribute("bordercolor","#496A9A" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(160)).setAttribute("onmouseover","activarPuntero('formulario', 4, 'lblObtencionPuntos');" );
      ((Element)v.get(160)).setAttribute("onclick","onClickPestanyaPagina(4, 'formulario', 'LPMantenerParametrosCalificacion');" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(161)).setAttribute("align","center" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(163)).setAttribute("nombre","lblObtencionPuntos" );
      ((Element)v.get(163)).setAttribute("alto","13" );
      ((Element)v.get(163)).setAttribute("filas","1" );
      ((Element)v.get(163)).setAttribute("valor","" );
      ((Element)v.get(163)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(163)).setAttribute("cod","00396" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:164 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).setAttribute("width","10" );
      ((Element)v.get(164)).setAttribute("class","menu5texto" );
      ((Element)v.get(124)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(165)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).setAttribute("width","10" );
      ((Element)v.get(165)).setAttribute("height","8" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(166)).setAttribute("width","20" );
      ((Element)v.get(166)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(166)).setAttribute("class","menu5texto" );
      ((Element)v.get(124)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("table"));
      ((Element)v.get(167)).setAttribute("width","75" );
      ((Element)v.get(167)).setAttribute("border","1" );
      ((Element)v.get(167)).setAttribute("align","center" );
      ((Element)v.get(167)).setAttribute("cellpadding","1" );
      ((Element)v.get(167)).setAttribute("cellspacing","0" );
      ((Element)v.get(167)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(167)).setAttribute("onmouseover","activarPuntero('formulario', 8, 'lblDespachoPremios');" );
      ((Element)v.get(167)).setAttribute("onclick","onClickPestanyaPagina(8, 'formulario', 'LPMantenerParametrosCalificacion');" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(168)).setAttribute("align","center" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(170)).setAttribute("nombre","lblDespachoPremios" );
      ((Element)v.get(170)).setAttribute("alto","13" );
      ((Element)v.get(170)).setAttribute("filas","1" );
      ((Element)v.get(170)).setAttribute("valor","" );
      ((Element)v.get(170)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(170)).setAttribute("cod","00397" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:168   */
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:171 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).setAttribute("width","16" );
      ((Element)v.get(171)).setAttribute("class","menu5texto" );
      ((Element)v.get(124)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).setAttribute("width","12" );
      ((Element)v.get(172)).setAttribute("height","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:173 / Elemento padre: 20   */
      v.add(doc.createElement("table"));
      ((Element)v.get(173)).setAttribute("width","100%" );
      ((Element)v.get(173)).setAttribute("height","100%" );
      ((Element)v.get(173)).setAttribute("border","0" );
      ((Element)v.get(173)).setAttribute("align","center" );
      ((Element)v.get(173)).setAttribute("cellpadding","0" );
      ((Element)v.get(173)).setAttribute("cellspacing","0" );
      ((Element)v.get(173)).setAttribute("class","menu4" );
      ((Element)v.get(20)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).setAttribute("width","12" );
      ((Element)v.get(175)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(175)).setAttribute("class","menu5texto" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(176)).setAttribute("src","b.gif" );
      ((Element)v.get(176)).setAttribute("width","12" );
      ((Element)v.get(176)).setAttribute("height","30" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(177)).setAttribute("class","menu5texto" );
      ((Element)v.get(174)).appendChild((Element)v.get(177));

      /* Elemento padre:177 / Elemento actual: 178   */
      v.add(doc.createTextNode(" "));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(177)).appendChild((Text)v.get(178));

      /* Termina nodo Texto:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:179 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(179)).setAttribute("width","10" );
      ((Element)v.get(179)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(179)).setAttribute("class","menu5texto" );
      ((Element)v.get(174)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(180)).setAttribute("src","b.gif" );
      ((Element)v.get(180)).setAttribute("width","10" );
      ((Element)v.get(180)).setAttribute("height","8" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(181)).setAttribute("width","70" );
      ((Element)v.get(181)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(181)).setAttribute("class","menu5texto" );
      ((Element)v.get(174)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("table"));
      ((Element)v.get(182)).setAttribute("width","75" );
      ((Element)v.get(182)).setAttribute("border","1" );
      ((Element)v.get(182)).setAttribute("align","center" );
      ((Element)v.get(182)).setAttribute("cellpadding","1" );
      ((Element)v.get(182)).setAttribute("cellspacing","0" );
      ((Element)v.get(182)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(182)).setAttribute("onmouseover","activarPuntero('formulario', 3, 'lblAmbitoGeografico');" );
      ((Element)v.get(182)).setAttribute("onclick","onClickPestanyaPagina(3, 'formulario', 'LPMantenerParametrosCalificacion');" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(183)).setAttribute("align","center" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(184)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(185)).setAttribute("nombre","lblAmbitoGeografico" );
      ((Element)v.get(185)).setAttribute("alto","13" );
      ((Element)v.get(185)).setAttribute("filas","1" );
      ((Element)v.get(185)).setAttribute("valor","" );
      ((Element)v.get(185)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(185)).setAttribute("cod","2801" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */
      /* Termina nodo:183   */
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:186 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).setAttribute("width","10" );
      ((Element)v.get(186)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(186)).setAttribute("class","menu5texto" );
      ((Element)v.get(174)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(187)).setAttribute("src","b.gif" );
      ((Element)v.get(187)).setAttribute("width","10" );
      ((Element)v.get(187)).setAttribute("height","8" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:188 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).setAttribute("width","70" );
      ((Element)v.get(188)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(188)).setAttribute("class","menu5texto" );
      ((Element)v.get(174)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("table"));
      ((Element)v.get(189)).setAttribute("width","75" );
      ((Element)v.get(189)).setAttribute("border","1" );
      ((Element)v.get(189)).setAttribute("align","center" );
      ((Element)v.get(189)).setAttribute("cellpadding","1" );
      ((Element)v.get(189)).setAttribute("cellspacing","0" );
      ((Element)v.get(189)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(189)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(190)).setAttribute("align","center" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("td"));
      ((Element)v.get(191)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(192)).setAttribute("nombre","lblCalificacion" );
      ((Element)v.get(192)).setAttribute("alto","13" );
      ((Element)v.get(192)).setAttribute("filas","1" );
      ((Element)v.get(192)).setAttribute("valor","" );
      ((Element)v.get(192)).setAttribute("id","menu5textoblanca" );
      ((Element)v.get(192)).setAttribute("cod","00398" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:190   */
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:193 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).setAttribute("width","10" );
      ((Element)v.get(193)).setAttribute("class","menu5texto" );
      ((Element)v.get(174)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(194)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).setAttribute("width","10" );
      ((Element)v.get(194)).setAttribute("height","8" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).setAttribute("width","20" );
      ((Element)v.get(195)).setAttribute("nowrap","nowrap" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(195)).setAttribute("class","menu5texto" );
      ((Element)v.get(174)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("table"));
      ((Element)v.get(196)).setAttribute("width","75" );
      ((Element)v.get(196)).setAttribute("border","1" );
      ((Element)v.get(196)).setAttribute("align","center" );
      ((Element)v.get(196)).setAttribute("cellpadding","1" );
      ((Element)v.get(196)).setAttribute("cellspacing","0" );
      ((Element)v.get(196)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(196)).setAttribute("onmouseover","activarPuntero('formulario', 10, 'lblGerentes');" );
      ((Element)v.get(196)).setAttribute("onclick","onClickPestanyaPagina(10, 'formulario', 'LPMantenerParametrosCalificacion');" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(197)).setAttribute("align","center" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("td"));
      ((Element)v.get(198)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(199)).setAttribute("nombre","lblGerentes" );
      ((Element)v.get(199)).setAttribute("alto","13" );
      ((Element)v.get(199)).setAttribute("filas","1" );
      ((Element)v.get(199)).setAttribute("valor","" );
      ((Element)v.get(199)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(199)).setAttribute("cod","00399" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */
      /* Termina nodo:197   */
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:200 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(200)).setAttribute("width","10" );
      ((Element)v.get(200)).setAttribute("class","menu5texto" );
      ((Element)v.get(174)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).setAttribute("width","10" );
      ((Element)v.get(201)).setAttribute("height","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).setAttribute("width","20" );
      ((Element)v.get(202)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(202)).setAttribute("class","menu5texto" );
      ((Element)v.get(174)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("table"));
      ((Element)v.get(203)).setAttribute("width","75" );
      ((Element)v.get(203)).setAttribute("border","1" );
      ((Element)v.get(203)).setAttribute("align","center" );
      ((Element)v.get(203)).setAttribute("cellpadding","1" );
      ((Element)v.get(203)).setAttribute("cellspacing","0" );
      ((Element)v.get(203)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(203)).setAttribute("onmouseover","activarPuntero('formulario', 11, 'lblConsultoras');" );
      ((Element)v.get(203)).setAttribute("onclick","onClickPestanyaPagina(11, 'formulario', 'LPMantenerParametrosCalificacion');" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(204)).setAttribute("align","center" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(206)).setAttribute("nombre","lblConsultoras" );
      ((Element)v.get(206)).setAttribute("alto","13" );
      ((Element)v.get(206)).setAttribute("filas","1" );
      ((Element)v.get(206)).setAttribute("valor","" );
      ((Element)v.get(206)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(206)).setAttribute("cod","00401" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */
      /* Termina nodo:204   */
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:207 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(207)).setAttribute("width","10" );
      ((Element)v.get(207)).setAttribute("class","menu5texto" );
      ((Element)v.get(174)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).setAttribute("width","10" );
      ((Element)v.get(208)).setAttribute("height","8" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:209 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).setAttribute("width","20" );
      ((Element)v.get(209)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(209)).setAttribute("class","menu5texto" );
      ((Element)v.get(174)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("table"));
      ((Element)v.get(210)).setAttribute("width","75" );
      ((Element)v.get(210)).setAttribute("border","1" );
      ((Element)v.get(210)).setAttribute("align","center" );
      ((Element)v.get(210)).setAttribute("cellpadding","1" );
      ((Element)v.get(210)).setAttribute("cellspacing","0" );
      ((Element)v.get(210)).setAttribute("ID","DatosGenerales" );
      ((Element)v.get(210)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(210)).setAttribute("onclick","onClickPestanyaPagina(2, 'formulario', 'LPMantenerParametrosCalificacion');" );
      ((Element)v.get(210)).setAttribute("onmouseover","activarPuntero('formulario', 2, 'lblProgramaNuevas');" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("tr"));
   }

   private void getXML990(Document doc) {
      ((Element)v.get(211)).setAttribute("align","center" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("td"));
      ((Element)v.get(212)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(213)).setAttribute("nombre","lblProgramaNuevas" );
      ((Element)v.get(213)).setAttribute("alto","13" );
      ((Element)v.get(213)).setAttribute("filas","1" );
      ((Element)v.get(213)).setAttribute("valor","" );
      ((Element)v.get(213)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(213)).setAttribute("cod","00590" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:209   */

      /* Empieza nodo:214 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).setAttribute("width","10" );
      ((Element)v.get(214)).setAttribute("class","menu5texto" );
      ((Element)v.get(174)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(215)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).setAttribute("width","10" );
      ((Element)v.get(215)).setAttribute("height","8" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:216 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).setAttribute("width","20" );
      ((Element)v.get(216)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(216)).setAttribute("class","menu5texto" );
      ((Element)v.get(174)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("table"));
      ((Element)v.get(217)).setAttribute("width","75" );
      ((Element)v.get(217)).setAttribute("border","1" );
      ((Element)v.get(217)).setAttribute("align","center" );
      ((Element)v.get(217)).setAttribute("cellpadding","1" );
      ((Element)v.get(217)).setAttribute("cellspacing","0" );
      ((Element)v.get(217)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(217)).setAttribute("onclick","onClickPestanyaPagina(12, 'formulario', 'LPMantenerParametrosCalificacion');" );
      ((Element)v.get(217)).setAttribute("onmouseover","activarPuntero('formulario', 12, 'lblMultinivel');" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(218)).setAttribute("align","center" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(219)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(220)).setAttribute("nombre","lblMultinivel" );
      ((Element)v.get(220)).setAttribute("alto","13" );
      ((Element)v.get(220)).setAttribute("filas","1" );
      ((Element)v.get(220)).setAttribute("valor","" );
      ((Element)v.get(220)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(220)).setAttribute("cod","00400" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:221 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).setAttribute("width","16" );
      ((Element)v.get(221)).setAttribute("class","menu5texto" );
      ((Element)v.get(174)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(222)).setAttribute("width","12" );
      ((Element)v.get(222)).setAttribute("height","8" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:223 / Elemento padre: 20   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(223)).setAttribute("nombre","capaEspacio1" );
      ((Element)v.get(223)).setAttribute("x","0" );
      ((Element)v.get(223)).setAttribute("y","60" );
      ((Element)v.get(20)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("table"));
      ((Element)v.get(224)).setAttribute("width","100%" );
      ((Element)v.get(224)).setAttribute("border","0" );
      ((Element)v.get(224)).setAttribute("cellspacing","0" );
      ((Element)v.get(224)).setAttribute("cellpadding","0" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(224)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).setAttribute("width","12" );
      ((Element)v.get(226)).setAttribute("align","center" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).setAttribute("width","12" );
      ((Element)v.get(227)).setAttribute("height","12" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(228)).setAttribute("width","750" );
      ((Element)v.get(225)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(229)).setAttribute("src","b.gif" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:230 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(230)).setAttribute("width","12" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(225)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(231)).setAttribute("src","b.gif" );
      ((Element)v.get(231)).setAttribute("width","12" );
      ((Element)v.get(231)).setAttribute("height","1" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */
      /* Termina nodo:225   */

      /* Empieza nodo:232 / Elemento padre: 224   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(224)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(234)).setAttribute("src","b.gif" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:235 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(237)).setAttribute("class","legend" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(238)).setAttribute("nombre","lblParametrosCalificacion" );
      ((Element)v.get(238)).setAttribute("alto","13" );
      ((Element)v.get(238)).setAttribute("filas","1" );
      ((Element)v.get(238)).setAttribute("valor","" );
      ((Element)v.get(238)).setAttribute("id","legend" );
      ((Element)v.get(238)).setAttribute("cod","00383" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 236   */
      v.add(doc.createElement("table"));
      ((Element)v.get(239)).setAttribute("width","100%" );
      ((Element)v.get(239)).setAttribute("border","0" );
      ((Element)v.get(239)).setAttribute("align","center" );
      ((Element)v.get(239)).setAttribute("cellspacing","0" );
      ((Element)v.get(239)).setAttribute("cellpadding","0" );
      ((Element)v.get(236)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(239)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("td"));
      ((Element)v.get(240)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("table"));
      ((Element)v.get(242)).setAttribute("width","666" );
      ((Element)v.get(242)).setAttribute("border","0" );
      ((Element)v.get(242)).setAttribute("align","left" );
      ((Element)v.get(242)).setAttribute("cellspacing","0" );
      ((Element)v.get(242)).setAttribute("cellpadding","0" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(242)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(244)).setAttribute("colspan","3" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(245)).setAttribute("src","b.gif" );
      ((Element)v.get(245)).setAttribute("width","8" );
      ((Element)v.get(245)).setAttribute("height","8" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:246 / Elemento padre: 242   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(242)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("td"));
      ((Element)v.get(246)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(248)).setAttribute("src","b.gif" );
      ((Element)v.get(248)).setAttribute("width","8" );
      ((Element)v.get(248)).setAttribute("height","8" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */

      /* Empieza nodo:249 / Elemento padre: 246   */
      v.add(doc.createElement("td"));
      ((Element)v.get(246)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(250)).setAttribute("nombre","lblTipoVentaCalificacion" );
      ((Element)v.get(250)).setAttribute("alto","13" );
      ((Element)v.get(250)).setAttribute("filas","1" );
      ((Element)v.get(250)).setAttribute("valor","" );
      ((Element)v.get(250)).setAttribute("id","datosTitle" );
      ((Element)v.get(250)).setAttribute("cod","1960" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */

      /* Empieza nodo:251 / Elemento padre: 246   */
      v.add(doc.createElement("td"));
      ((Element)v.get(246)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(252)).setAttribute("src","b.gif" );
      ((Element)v.get(252)).setAttribute("width","25" );
      ((Element)v.get(252)).setAttribute("height","8" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */

      /* Empieza nodo:253 / Elemento padre: 246   */
      v.add(doc.createElement("td"));
      ((Element)v.get(246)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(254)).setAttribute("nombre","lblPeriodoEvaluacionDesde" );
      ((Element)v.get(254)).setAttribute("alto","13" );
      ((Element)v.get(254)).setAttribute("filas","1" );
      ((Element)v.get(254)).setAttribute("valor","" );
      ((Element)v.get(254)).setAttribute("id","datosTitle" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(254)).setAttribute("cod","1958" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:255 / Elemento padre: 246   */
      v.add(doc.createElement("td"));
      ((Element)v.get(246)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(256)).setAttribute("src","b.gif" );
      ((Element)v.get(256)).setAttribute("width","25" );
      ((Element)v.get(256)).setAttribute("height","8" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:257 / Elemento padre: 246   */
      v.add(doc.createElement("td"));
      ((Element)v.get(246)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(258)).setAttribute("nombre","lblPeriodoEvaluacionHasta" );
      ((Element)v.get(258)).setAttribute("alto","13" );
      ((Element)v.get(258)).setAttribute("filas","1" );
      ((Element)v.get(258)).setAttribute("valor","P" );
      ((Element)v.get(258)).setAttribute("id","datosTitle" );
      ((Element)v.get(258)).setAttribute("cod","1959" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:259 / Elemento padre: 246   */
      v.add(doc.createElement("td"));
      ((Element)v.get(246)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(260)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).setAttribute("width","25" );
      ((Element)v.get(260)).setAttribute("height","8" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:261 / Elemento padre: 246   */
      v.add(doc.createElement("td"));
      ((Element)v.get(246)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(262)).setAttribute("nombre","lblDirigidoa" );
      ((Element)v.get(262)).setAttribute("alto","13" );
      ((Element)v.get(262)).setAttribute("filas","1" );
      ((Element)v.get(262)).setAttribute("valor","" );
      ((Element)v.get(262)).setAttribute("id","datosTitle" );
      ((Element)v.get(262)).setAttribute("cod","1626" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */

      /* Empieza nodo:263 / Elemento padre: 246   */
      v.add(doc.createElement("td"));
      ((Element)v.get(263)).setAttribute("width","100%" );
      ((Element)v.get(246)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(264)).setAttribute("src","b.gif" );
      ((Element)v.get(264)).setAttribute("width","8" );
      ((Element)v.get(264)).setAttribute("height","8" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */
      /* Termina nodo:246   */

      /* Empieza nodo:265 / Elemento padre: 242   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(242)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(267)).setAttribute("src","b.gif" );
      ((Element)v.get(267)).setAttribute("width","8" );
      ((Element)v.get(267)).setAttribute("height","8" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:268 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(269)).setAttribute("nombre","lbldtTipoVentaCalificacion" );
      ((Element)v.get(269)).setAttribute("alto","13" );
      ((Element)v.get(269)).setAttribute("filas","1" );
      ((Element)v.get(269)).setAttribute("valor","" );
      ((Element)v.get(269)).setAttribute("id","datosCampos" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */

      /* Empieza nodo:270 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(271)).setAttribute("width","25" );
      ((Element)v.get(271)).setAttribute("height","8" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */

      /* Empieza nodo:272 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(272)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(265)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(273)).setAttribute("nombre","cbPeriodoEvaluacionDesde" );
      ((Element)v.get(273)).setAttribute("id","datosCampos" );
      ((Element)v.get(273)).setAttribute("size","1" );
      ((Element)v.get(273)).setAttribute("multiple","N" );
      ((Element)v.get(273)).setAttribute("req","S" );
      ((Element)v.get(273)).setAttribute("valorinicial","" );
      ((Element)v.get(273)).setAttribute("textoinicial","" );
      ((Element)v.get(273)).setAttribute("ontab","setTabFocus('cbPeriodoEvaluacionDesde')" );
      ((Element)v.get(273)).setAttribute("onshtab","setSHTabFocus('cbPeriodoEvaluacionDesde')" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */
      /* Termina nodo:272   */

      /* Empieza nodo:275 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(276)).setAttribute("src","b.gif" );
      ((Element)v.get(276)).setAttribute("width","25" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(276)).setAttribute("height","8" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:277 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(277)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(265)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(278)).setAttribute("nombre","cbPeriodoEvaluacionHasta" );
      ((Element)v.get(278)).setAttribute("id","datosCampos" );
      ((Element)v.get(278)).setAttribute("size","1" );
      ((Element)v.get(278)).setAttribute("multiple","N" );
      ((Element)v.get(278)).setAttribute("req","S" );
      ((Element)v.get(278)).setAttribute("valorinicial","" );
      ((Element)v.get(278)).setAttribute("textoinicial","" );
      ((Element)v.get(278)).setAttribute("ontab","setTabFocus('cbPeriodoEvaluacionHasta')" );
      ((Element)v.get(278)).setAttribute("onshtab","setSHTabFocus('cbPeriodoEvaluacionHasta')" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:280 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(281)).setAttribute("src","b.gif" );
      ((Element)v.get(281)).setAttribute("width","25" );
      ((Element)v.get(281)).setAttribute("height","8" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:280   */

      /* Empieza nodo:282 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(283)).setAttribute("nombre","lblDirigidoadt" );
      ((Element)v.get(283)).setAttribute("alto","13" );
      ((Element)v.get(283)).setAttribute("filas","1" );
      ((Element)v.get(283)).setAttribute("valor","" );
      ((Element)v.get(283)).setAttribute("id","datosCampos" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:284 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(284)).setAttribute("width","100%" );
      ((Element)v.get(265)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(285)).setAttribute("src","b.gif" );
      ((Element)v.get(285)).setAttribute("width","8" );
      ((Element)v.get(285)).setAttribute("height","8" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */
      /* Termina nodo:265   */

      /* Empieza nodo:286 / Elemento padre: 242   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(242)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(287)).setAttribute("colspan","3" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(288)).setAttribute("src","b.gif" );
      ((Element)v.get(288)).setAttribute("width","8" );
      ((Element)v.get(288)).setAttribute("height","8" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:287   */
      /* Termina nodo:286   */
      /* Termina nodo:242   */
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:289 / Elemento padre: 239   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(239)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(289)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("table"));
      ((Element)v.get(291)).setAttribute("width","666" );
      ((Element)v.get(291)).setAttribute("border","0" );
      ((Element)v.get(291)).setAttribute("align","left" );
      ((Element)v.get(291)).setAttribute("cellspacing","0" );
      ((Element)v.get(291)).setAttribute("cellpadding","0" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(291)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(292)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(294)).setAttribute("src","b.gif" );
      ((Element)v.get(294)).setAttribute("width","8" );
      ((Element)v.get(294)).setAttribute("height","8" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:293   */

      /* Empieza nodo:295 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(292)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(296)).setAttribute("nombre","lblBloquearMetas" );
      ((Element)v.get(296)).setAttribute("alto","13" );
      ((Element)v.get(296)).setAttribute("filas","1" );
      ((Element)v.get(296)).setAttribute("valor","" );
      ((Element)v.get(296)).setAttribute("id","datosTitle" );
      ((Element)v.get(296)).setAttribute("cod","1898" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */

      /* Empieza nodo:297 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(292)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(298)).setAttribute("src","b.gif" );
      ((Element)v.get(298)).setAttribute("width","25" );
      ((Element)v.get(298)).setAttribute("height","8" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:299 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(292)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(300)).setAttribute("nombre","lblMetasModificables" );
      ((Element)v.get(300)).setAttribute("alto","13" );
      ((Element)v.get(300)).setAttribute("filas","1" );
      ((Element)v.get(300)).setAttribute("valor","" );
      ((Element)v.get(300)).setAttribute("id","datosTitle" );
      ((Element)v.get(300)).setAttribute("cod","1902" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */
      /* Termina nodo:299   */

      /* Empieza nodo:301 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(292)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(302)).setAttribute("src","b.gif" );
      ((Element)v.get(302)).setAttribute("width","25" );
      ((Element)v.get(302)).setAttribute("height","8" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:303 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(292)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(304)).setAttribute("nombre","lblComunicacion" );
      ((Element)v.get(304)).setAttribute("alto","13" );
      ((Element)v.get(304)).setAttribute("filas","1" );
      ((Element)v.get(304)).setAttribute("valor","" );
      ((Element)v.get(304)).setAttribute("id","datosTitle" );
      ((Element)v.get(304)).setAttribute("cod","1812" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */

      /* Empieza nodo:305 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(292)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(306)).setAttribute("src","b.gif" );
      ((Element)v.get(306)).setAttribute("width","25" );
      ((Element)v.get(306)).setAttribute("height","8" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */

      /* Empieza nodo:307 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(292)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(308)).setAttribute("nombre","lblMensaje" );
      ((Element)v.get(308)).setAttribute("alto","13" );
      ((Element)v.get(308)).setAttribute("filas","1" );
      ((Element)v.get(308)).setAttribute("valor","" );
      ((Element)v.get(308)).setAttribute("id","datosTitle" );
      ((Element)v.get(308)).setAttribute("cod","531" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:307   */

      /* Empieza nodo:309 / Elemento padre: 292   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).setAttribute("width","100%" );
      ((Element)v.get(292)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(310)).setAttribute("src","b.gif" );
      ((Element)v.get(310)).setAttribute("width","8" );
      ((Element)v.get(310)).setAttribute("height","8" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */
      /* Termina nodo:309   */
      /* Termina nodo:292   */

      /* Empieza nodo:311 / Elemento padre: 291   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(291)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("td"));
      ((Element)v.get(311)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(313)).setAttribute("src","b.gif" );
      ((Element)v.get(313)).setAttribute("width","8" );
      ((Element)v.get(313)).setAttribute("height","8" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:312   */

      /* Empieza nodo:314 / Elemento padre: 311   */
      v.add(doc.createElement("td"));
      ((Element)v.get(311)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(315)).setAttribute("nombre","ckBloquearMetas" );
      ((Element)v.get(315)).setAttribute("id","datosCampos" );
      ((Element)v.get(315)).setAttribute("onclick","onChangeBloquearMetas();" );
      ((Element)v.get(315)).setAttribute("check","N" );
      ((Element)v.get(315)).setAttribute("readonly","N" );
      ((Element)v.get(315)).setAttribute("ontab","setTabFocus('ckBloquearMetas')" );
      ((Element)v.get(315)).setAttribute("onshtab","setSHTabFocus('ckBloquearMetas')" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:314   */

      /* Empieza nodo:316 / Elemento padre: 311   */
      v.add(doc.createElement("td"));
      ((Element)v.get(311)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(317)).setAttribute("src","b.gif" );
      ((Element)v.get(317)).setAttribute("width","25" );
      ((Element)v.get(317)).setAttribute("height","8" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:316   */

      /* Empieza nodo:318 / Elemento padre: 311   */
      v.add(doc.createElement("td"));
      ((Element)v.get(311)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(319)).setAttribute("nombre","ckMetasModificables" );
      ((Element)v.get(319)).setAttribute("id","datosCampos" );
      ((Element)v.get(319)).setAttribute("onclick","onChangeMetasModificables();" );
      ((Element)v.get(319)).setAttribute("check","N" );
      ((Element)v.get(319)).setAttribute("ontab","setTabFocus('ckMetasModificables')" );
      ((Element)v.get(319)).setAttribute("onshtab","setSHTabFocus('ckMetasModificables')" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */
      /* Termina nodo:318   */

      /* Empieza nodo:320 / Elemento padre: 311   */
      v.add(doc.createElement("td"));
      ((Element)v.get(311)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
   }

   private void getXML1440(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(321)).setAttribute("src","b.gif" );
      ((Element)v.get(321)).setAttribute("width","25" );
      ((Element)v.get(321)).setAttribute("height","8" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:320   */

      /* Empieza nodo:322 / Elemento padre: 311   */
      v.add(doc.createElement("td"));
      ((Element)v.get(311)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(323)).setAttribute("nombre","ckComunicaciones" );
      ((Element)v.get(323)).setAttribute("id","datosCampos" );
      ((Element)v.get(323)).setAttribute("onclick","onChangeComunicacion();" );
      ((Element)v.get(323)).setAttribute("check","N" );
      ((Element)v.get(323)).setAttribute("ontab","setTabFocus('ckComunicaciones')" );
      ((Element)v.get(323)).setAttribute("onshtab","setSHTabFocus('ckComunicaciones')" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:324 / Elemento padre: 311   */
      v.add(doc.createElement("td"));
      ((Element)v.get(311)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(325)).setAttribute("src","b.gif" );
      ((Element)v.get(325)).setAttribute("width","25" );
      ((Element)v.get(325)).setAttribute("height","8" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:326 / Elemento padre: 311   */
      v.add(doc.createElement("td"));
      ((Element)v.get(311)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(327)).setAttribute("nombre","txtMensaje" );
      ((Element)v.get(327)).setAttribute("id","datosCampos" );
      ((Element)v.get(327)).setAttribute("max","5" );
      ((Element)v.get(327)).setAttribute("tipo","" );
      ((Element)v.get(327)).setAttribute("onchange","" );
      ((Element)v.get(327)).setAttribute("req","N" );
      ((Element)v.get(327)).setAttribute("size","5" );
      ((Element)v.get(327)).setAttribute("valor","" );
      ((Element)v.get(327)).setAttribute("validacion","" );
      ((Element)v.get(327)).setAttribute("ontab","setTabFocus('txtMensaje')" );
      ((Element)v.get(327)).setAttribute("onshtab","setSHTabFocus('txtMensaje')" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:326   */

      /* Empieza nodo:328 / Elemento padre: 311   */
      v.add(doc.createElement("td"));
      ((Element)v.get(328)).setAttribute("width","100%" );
      ((Element)v.get(311)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(329)).setAttribute("src","b.gif" );
      ((Element)v.get(329)).setAttribute("width","8" );
      ((Element)v.get(329)).setAttribute("height","8" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:328   */
      /* Termina nodo:311   */

      /* Empieza nodo:330 / Elemento padre: 291   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(291)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("td"));
      ((Element)v.get(331)).setAttribute("colspan","3" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(332)).setAttribute("src","b.gif" );
      ((Element)v.get(332)).setAttribute("width","8" );
      ((Element)v.get(332)).setAttribute("height","8" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:331   */
      /* Termina nodo:330   */
      /* Termina nodo:291   */
      /* Termina nodo:290   */
      /* Termina nodo:289   */

      /* Empieza nodo:333 / Elemento padre: 239   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(239)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("td"));
      ((Element)v.get(333)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("table"));
      ((Element)v.get(335)).setAttribute("width","666" );
      ((Element)v.get(335)).setAttribute("border","0" );
      ((Element)v.get(335)).setAttribute("align","left" );
      ((Element)v.get(335)).setAttribute("cellspacing","0" );
      ((Element)v.get(335)).setAttribute("cellpadding","0" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(335)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("td"));
      ((Element)v.get(336)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(338)).setAttribute("src","b.gif" );
      ((Element)v.get(338)).setAttribute("width","8" );
      ((Element)v.get(338)).setAttribute("height","8" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:339 / Elemento padre: 336   */
      v.add(doc.createElement("td"));
      ((Element)v.get(336)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(340)).setAttribute("nombre","lblTipoVentaHistorica" );
      ((Element)v.get(340)).setAttribute("alto","13" );
      ((Element)v.get(340)).setAttribute("filas","1" );
      ((Element)v.get(340)).setAttribute("valor","" );
      ((Element)v.get(340)).setAttribute("id","datosTitle" );
      ((Element)v.get(340)).setAttribute("cod","1961" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */

      /* Empieza nodo:341 / Elemento padre: 336   */
      v.add(doc.createElement("td"));
      ((Element)v.get(336)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(342)).setAttribute("src","b.gif" );
      ((Element)v.get(342)).setAttribute("width","25" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(342)).setAttribute("height","8" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */

      /* Empieza nodo:343 / Elemento padre: 336   */
      v.add(doc.createElement("td"));
      ((Element)v.get(336)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(344)).setAttribute("nombre","lblTipoVentaIncremental" );
      ((Element)v.get(344)).setAttribute("alto","13" );
      ((Element)v.get(344)).setAttribute("filas","1" );
      ((Element)v.get(344)).setAttribute("valor","" );
      ((Element)v.get(344)).setAttribute("id","datosTitle" );
      ((Element)v.get(344)).setAttribute("cod","2443" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:343   */

      /* Empieza nodo:345 / Elemento padre: 336   */
      v.add(doc.createElement("td"));
      ((Element)v.get(336)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(346)).setAttribute("src","b.gif" );
      ((Element)v.get(346)).setAttribute("width","25" );
      ((Element)v.get(346)).setAttribute("height","8" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:345   */

      /* Empieza nodo:347 / Elemento padre: 336   */
      v.add(doc.createElement("td"));
      ((Element)v.get(336)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(348)).setAttribute("nombre","lblTipoDeterminacionMetas" );
      ((Element)v.get(348)).setAttribute("alto","13" );
      ((Element)v.get(348)).setAttribute("filas","1" );
      ((Element)v.get(348)).setAttribute("valor","" );
      ((Element)v.get(348)).setAttribute("id","datosTitle" );
      ((Element)v.get(348)).setAttribute("cod","1962" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:347   */

      /* Empieza nodo:349 / Elemento padre: 336   */
      v.add(doc.createElement("td"));
      ((Element)v.get(349)).setAttribute("width","100%" );
      ((Element)v.get(336)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(350)).setAttribute("src","b.gif" );
      ((Element)v.get(350)).setAttribute("width","8" );
      ((Element)v.get(350)).setAttribute("height","8" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:349   */
      /* Termina nodo:336   */

      /* Empieza nodo:351 / Elemento padre: 335   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(335)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("td"));
      ((Element)v.get(351)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(353)).setAttribute("src","b.gif" );
      ((Element)v.get(353)).setAttribute("width","8" );
      ((Element)v.get(353)).setAttribute("height","8" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */
      /* Termina nodo:352   */

      /* Empieza nodo:354 / Elemento padre: 351   */
      v.add(doc.createElement("td"));
      ((Element)v.get(354)).setAttribute("valign","bottom" );
      ((Element)v.get(354)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(351)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(355)).setAttribute("nombre","cbTipoVentaHistorica" );
      ((Element)v.get(355)).setAttribute("id","datosCampos" );
      ((Element)v.get(355)).setAttribute("size","1" );
      ((Element)v.get(355)).setAttribute("multiple","N" );
      ((Element)v.get(355)).setAttribute("req","N" );
      ((Element)v.get(355)).setAttribute("valorinicial","" );
      ((Element)v.get(355)).setAttribute("textoinicial","" );
      ((Element)v.get(355)).setAttribute("ontab","setTabFocus('cbTipoVentaHistorica')" );
      ((Element)v.get(355)).setAttribute("onshtab","setSHTabFocus('cbTipoVentaHistorica')" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(355)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */
      /* Termina nodo:355   */
      /* Termina nodo:354   */

      /* Empieza nodo:357 / Elemento padre: 351   */
      v.add(doc.createElement("td"));
      ((Element)v.get(351)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(358)).setAttribute("src","b.gif" );
      ((Element)v.get(358)).setAttribute("width","25" );
      ((Element)v.get(358)).setAttribute("height","8" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */
      /* Termina nodo:357   */

      /* Empieza nodo:359 / Elemento padre: 351   */
      v.add(doc.createElement("td"));
      ((Element)v.get(359)).setAttribute("valign","bottom" );
      ((Element)v.get(359)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(351)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(360)).setAttribute("nombre","cbTipoVentaIncremental" );
      ((Element)v.get(360)).setAttribute("id","datosCampos" );
      ((Element)v.get(360)).setAttribute("size","1" );
      ((Element)v.get(360)).setAttribute("multiple","N" );
      ((Element)v.get(360)).setAttribute("req","N" );
      ((Element)v.get(360)).setAttribute("valorinicial","" );
      ((Element)v.get(360)).setAttribute("textoinicial","" );
      ((Element)v.get(360)).setAttribute("ontab","setTabFocus('cbTipoVentaIncremental')" );
      ((Element)v.get(360)).setAttribute("onshtab","setSHTabFocus('cbTipoVentaIncremental')" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */
      /* Termina nodo:360   */
      /* Termina nodo:359   */

      /* Empieza nodo:362 / Elemento padre: 351   */
      v.add(doc.createElement("td"));
      ((Element)v.get(351)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(363)).setAttribute("src","b.gif" );
      ((Element)v.get(363)).setAttribute("width","25" );
      ((Element)v.get(363)).setAttribute("height","8" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */
      /* Termina nodo:362   */

      /* Empieza nodo:364 / Elemento padre: 351   */
      v.add(doc.createElement("td"));
      ((Element)v.get(364)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(351)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(365)).setAttribute("nombre","cbTipoDeterminacionMetas" );
      ((Element)v.get(365)).setAttribute("id","datosCampos" );
      ((Element)v.get(365)).setAttribute("size","1" );
      ((Element)v.get(365)).setAttribute("multiple","N" );
      ((Element)v.get(365)).setAttribute("req","S" );
      ((Element)v.get(365)).setAttribute("valorinicial","" );
      ((Element)v.get(365)).setAttribute("textoinicial","" );
      ((Element)v.get(365)).setAttribute("ontab","setTabFocus('cbTipoDeterminacionMetas')" );
      ((Element)v.get(365)).setAttribute("onshtab","setSHTabFocus('cbTipoDeterminacionMetas')" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(365)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */
      /* Termina nodo:365   */
      /* Termina nodo:364   */

      /* Empieza nodo:367 / Elemento padre: 351   */
      v.add(doc.createElement("td"));
      ((Element)v.get(367)).setAttribute("width","100%" );
      ((Element)v.get(351)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(368)).setAttribute("src","b.gif" );
      ((Element)v.get(368)).setAttribute("width","8" );
      ((Element)v.get(368)).setAttribute("height","8" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */
      /* Termina nodo:367   */
      /* Termina nodo:351   */

      /* Empieza nodo:369 / Elemento padre: 335   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(335)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("td"));
      ((Element)v.get(370)).setAttribute("colspan","3" );
      ((Element)v.get(369)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(371)).setAttribute("src","b.gif" );
      ((Element)v.get(371)).setAttribute("width","8" );
      ((Element)v.get(371)).setAttribute("height","8" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */
      /* Termina nodo:370   */
      /* Termina nodo:369   */
      /* Termina nodo:335   */
      /* Termina nodo:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:372 / Elemento padre: 239   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(239)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(372)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("table"));
      ((Element)v.get(374)).setAttribute("width","666" );
      ((Element)v.get(374)).setAttribute("border","0" );
      ((Element)v.get(374)).setAttribute("align","left" );
      ((Element)v.get(374)).setAttribute("cellspacing","0" );
      ((Element)v.get(374)).setAttribute("cellpadding","0" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(374)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("td"));
      ((Element)v.get(375)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(377)).setAttribute("src","b.gif" );
      ((Element)v.get(377)).setAttribute("width","8" );
      ((Element)v.get(377)).setAttribute("height","8" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */
      /* Termina nodo:376   */

      /* Empieza nodo:378 / Elemento padre: 375   */
      v.add(doc.createElement("td"));
      ((Element)v.get(375)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(379)).setAttribute("nombre","lblDevoluciones" );
      ((Element)v.get(379)).setAttribute("alto","13" );
      ((Element)v.get(379)).setAttribute("filas","1" );
      ((Element)v.get(379)).setAttribute("valor","" );
      ((Element)v.get(379)).setAttribute("id","datosTitle" );
      ((Element)v.get(379)).setAttribute("cod","1623" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */
      /* Termina nodo:378   */

      /* Empieza nodo:380 / Elemento padre: 375   */
      v.add(doc.createElement("td"));
      ((Element)v.get(375)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(381)).setAttribute("src","b.gif" );
      ((Element)v.get(381)).setAttribute("width","25" );
      ((Element)v.get(381)).setAttribute("height","8" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */
      /* Termina nodo:380   */

      /* Empieza nodo:382 / Elemento padre: 375   */
      v.add(doc.createElement("td"));
      ((Element)v.get(375)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(383)).setAttribute("nombre","lblAnulaciones" );
      ((Element)v.get(383)).setAttribute("alto","13" );
      ((Element)v.get(383)).setAttribute("filas","1" );
      ((Element)v.get(383)).setAttribute("valor","" );
      ((Element)v.get(383)).setAttribute("id","datosTitle" );
      ((Element)v.get(383)).setAttribute("cod","1624" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */
      /* Termina nodo:382   */

      /* Empieza nodo:384 / Elemento padre: 375   */
      v.add(doc.createElement("td"));
      ((Element)v.get(375)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(385)).setAttribute("src","b.gif" );
      ((Element)v.get(385)).setAttribute("width","25" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(385)).setAttribute("height","8" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */
      /* Termina nodo:384   */

      /* Empieza nodo:386 / Elemento padre: 375   */
      v.add(doc.createElement("td"));
      ((Element)v.get(375)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(387)).setAttribute("nombre","lblFaltantesNoAnunciados" );
      ((Element)v.get(387)).setAttribute("alto","13" );
      ((Element)v.get(387)).setAttribute("filas","1" );
      ((Element)v.get(387)).setAttribute("valor","" );
      ((Element)v.get(387)).setAttribute("id","datosTitle" );
      ((Element)v.get(387)).setAttribute("cod","1625" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */
      /* Termina nodo:386   */

      /* Empieza nodo:388 / Elemento padre: 375   */
      v.add(doc.createElement("td"));
      ((Element)v.get(375)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(389)).setAttribute("src","b.gif" );
      ((Element)v.get(389)).setAttribute("width","25" );
      ((Element)v.get(389)).setAttribute("height","8" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:388   */

      /* Empieza nodo:390 / Elemento padre: 375   */
      v.add(doc.createElement("td"));
      ((Element)v.get(375)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(391)).setAttribute("nombre","lblFormaCalculo" );
      ((Element)v.get(391)).setAttribute("alto","13" );
      ((Element)v.get(391)).setAttribute("filas","1" );
      ((Element)v.get(391)).setAttribute("valor","" );
      ((Element)v.get(391)).setAttribute("id","datosTitle" );
      ((Element)v.get(391)).setAttribute("cod","1671" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */
      /* Termina nodo:390   */

      /* Empieza nodo:392 / Elemento padre: 375   */
      v.add(doc.createElement("td"));
      ((Element)v.get(375)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(393)).setAttribute("src","b.gif" );
      ((Element)v.get(393)).setAttribute("width","25" );
      ((Element)v.get(393)).setAttribute("height","8" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));
      /* Termina nodo:393   */
      /* Termina nodo:392   */

      /* Empieza nodo:394 / Elemento padre: 375   */
      v.add(doc.createElement("td"));
      ((Element)v.get(375)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(395)).setAttribute("nombre","lblTipoIncremento" );
      ((Element)v.get(395)).setAttribute("alto","13" );
      ((Element)v.get(395)).setAttribute("filas","1" );
      ((Element)v.get(395)).setAttribute("valor","" );
      ((Element)v.get(395)).setAttribute("id","datosTitle" );
      ((Element)v.get(395)).setAttribute("cod","1963" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */
      /* Termina nodo:394   */

      /* Empieza nodo:396 / Elemento padre: 375   */
      v.add(doc.createElement("td"));
      ((Element)v.get(396)).setAttribute("width","100%" );
      ((Element)v.get(375)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(397)).setAttribute("src","b.gif" );
      ((Element)v.get(397)).setAttribute("width","8" );
      ((Element)v.get(397)).setAttribute("height","8" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */
      /* Termina nodo:396   */
      /* Termina nodo:375   */

      /* Empieza nodo:398 / Elemento padre: 374   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(374)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("td"));
      ((Element)v.get(398)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(400)).setAttribute("src","b.gif" );
      ((Element)v.get(400)).setAttribute("width","8" );
      ((Element)v.get(400)).setAttribute("height","8" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));
      /* Termina nodo:400   */
      /* Termina nodo:399   */

      /* Empieza nodo:401 / Elemento padre: 398   */
      v.add(doc.createElement("td"));
      ((Element)v.get(398)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(402)).setAttribute("nombre","ckDevolucines" );
      ((Element)v.get(402)).setAttribute("id","datosCampos" );
      ((Element)v.get(402)).setAttribute("onclick","" );
      ((Element)v.get(402)).setAttribute("check","N" );
      ((Element)v.get(402)).setAttribute("ontab","setTabFocus('ckDevolucines')" );
      ((Element)v.get(402)).setAttribute("onshtab","setSHTabFocus('ckDevolucines')" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */
      /* Termina nodo:401   */

      /* Empieza nodo:403 / Elemento padre: 398   */
      v.add(doc.createElement("td"));
      ((Element)v.get(398)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(404)).setAttribute("src","b.gif" );
      ((Element)v.get(404)).setAttribute("width","25" );
      ((Element)v.get(404)).setAttribute("height","8" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));
      /* Termina nodo:404   */
      /* Termina nodo:403   */

      /* Empieza nodo:405 / Elemento padre: 398   */
      v.add(doc.createElement("td"));
      ((Element)v.get(398)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(406)).setAttribute("nombre","ckAnulaciones" );
      ((Element)v.get(406)).setAttribute("id","datosCampos" );
      ((Element)v.get(406)).setAttribute("onclick","" );
      ((Element)v.get(406)).setAttribute("check","N" );
      ((Element)v.get(406)).setAttribute("ontab","setTabFocus('ckAnulaciones')" );
      ((Element)v.get(406)).setAttribute("onshtab","setSHTabFocus('ckAnulaciones')" );
      ((Element)v.get(405)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */
      /* Termina nodo:405   */

      /* Empieza nodo:407 / Elemento padre: 398   */
   }

   private void getXML1800(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(398)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(408)).setAttribute("src","b.gif" );
      ((Element)v.get(408)).setAttribute("width","25" );
      ((Element)v.get(408)).setAttribute("height","8" );
      ((Element)v.get(407)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */
      /* Termina nodo:407   */

      /* Empieza nodo:409 / Elemento padre: 398   */
      v.add(doc.createElement("td"));
      ((Element)v.get(398)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(410)).setAttribute("nombre","ckFaltantesNoAnunciados" );
      ((Element)v.get(410)).setAttribute("id","datosCampos" );
      ((Element)v.get(410)).setAttribute("onclick","" );
      ((Element)v.get(410)).setAttribute("check","N" );
      ((Element)v.get(410)).setAttribute("ontab","setTabFocus('ckFaltantesNoAnunciados')" );
      ((Element)v.get(410)).setAttribute("onshtab","setSHTabFocus('ckFaltantesNoAnunciados')" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */
      /* Termina nodo:409   */

      /* Empieza nodo:411 / Elemento padre: 398   */
      v.add(doc.createElement("td"));
      ((Element)v.get(398)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(412)).setAttribute("src","b.gif" );
      ((Element)v.get(412)).setAttribute("width","25" );
      ((Element)v.get(412)).setAttribute("height","8" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */
      /* Termina nodo:411   */

      /* Empieza nodo:413 / Elemento padre: 398   */
      v.add(doc.createElement("td"));
      ((Element)v.get(413)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(398)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(414)).setAttribute("nombre","cbFormaCalculo" );
      ((Element)v.get(414)).setAttribute("id","datosCampos" );
      ((Element)v.get(414)).setAttribute("size","1" );
      ((Element)v.get(414)).setAttribute("multiple","N" );
      ((Element)v.get(414)).setAttribute("req","N" );
      ((Element)v.get(414)).setAttribute("valorinicial","" );
      ((Element)v.get(414)).setAttribute("textoinicial","" );
      ((Element)v.get(414)).setAttribute("ontab","setTabFocus('cbFormaCalculo')" );
      ((Element)v.get(414)).setAttribute("onshtab","setSHTabFocus('cbFormaCalculo')" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(414)).appendChild((Element)v.get(415));
      /* Termina nodo:415   */
      /* Termina nodo:414   */
      /* Termina nodo:413   */

      /* Empieza nodo:416 / Elemento padre: 398   */
      v.add(doc.createElement("td"));
      ((Element)v.get(398)).appendChild((Element)v.get(416));

      /* Empieza nodo:417 / Elemento padre: 416   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(417)).setAttribute("src","b.gif" );
      ((Element)v.get(417)).setAttribute("width","25" );
      ((Element)v.get(417)).setAttribute("height","8" );
      ((Element)v.get(416)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */
      /* Termina nodo:416   */

      /* Empieza nodo:418 / Elemento padre: 398   */
      v.add(doc.createElement("td"));
      ((Element)v.get(418)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(418)).setAttribute("valign","bottom" );
      ((Element)v.get(398)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(419)).setAttribute("nombre","cbTipoIncremento" );
      ((Element)v.get(419)).setAttribute("id","datosCampos" );
      ((Element)v.get(419)).setAttribute("size","1" );
      ((Element)v.get(419)).setAttribute("multiple","N" );
      ((Element)v.get(419)).setAttribute("req","N" );
      ((Element)v.get(419)).setAttribute("valorinicial","" );
      ((Element)v.get(419)).setAttribute("textoinicial","" );
      ((Element)v.get(419)).setAttribute("ontab","setTabFocus('cbTipoIncremento')" );
      ((Element)v.get(419)).setAttribute("onshtab","setSHTabFocus('cbTipoIncremento')" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));

      /* Empieza nodo:420 / Elemento padre: 419   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(419)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */
      /* Termina nodo:419   */
      /* Termina nodo:418   */

      /* Empieza nodo:421 / Elemento padre: 398   */
      v.add(doc.createElement("td"));
      ((Element)v.get(421)).setAttribute("width","100%" );
      ((Element)v.get(398)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(422)).setAttribute("src","b.gif" );
      ((Element)v.get(422)).setAttribute("width","8" );
      ((Element)v.get(422)).setAttribute("height","8" );
      ((Element)v.get(421)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */
      /* Termina nodo:421   */
      /* Termina nodo:398   */

      /* Empieza nodo:423 / Elemento padre: 374   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(374)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("td"));
      ((Element)v.get(424)).setAttribute("colspan","3" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(425)).setAttribute("src","b.gif" );
      ((Element)v.get(425)).setAttribute("width","8" );
      ((Element)v.get(425)).setAttribute("height","8" );
      ((Element)v.get(424)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */
      /* Termina nodo:424   */
      /* Termina nodo:423   */
      /* Termina nodo:374   */
      /* Termina nodo:373   */
      /* Termina nodo:372   */

      /* Empieza nodo:426 / Elemento padre: 239   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(239)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("td"));
      ((Element)v.get(426)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("table"));
      ((Element)v.get(428)).setAttribute("width","100%" );
      ((Element)v.get(428)).setAttribute("align","left" );
      ((Element)v.get(428)).setAttribute("border","0" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(428)).setAttribute("cellspacing","0" );
      ((Element)v.get(428)).setAttribute("cellpadding","0" );
      ((Element)v.get(427)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(428)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("td"));
      ((Element)v.get(430)).setAttribute("width","8" );
      ((Element)v.get(430)).setAttribute("align","center" );
      ((Element)v.get(429)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(431)).setAttribute("src","b.gif" );
      ((Element)v.get(431)).setAttribute("width","8" );
      ((Element)v.get(431)).setAttribute("height","12" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */
      /* Termina nodo:430   */

      /* Empieza nodo:432 / Elemento padre: 429   */
      v.add(doc.createElement("td"));
      ((Element)v.get(432)).setAttribute("width","750" );
      ((Element)v.get(429)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(433)).setAttribute("src","b.gif" );
      ((Element)v.get(432)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */
      /* Termina nodo:432   */

      /* Empieza nodo:434 / Elemento padre: 429   */
      v.add(doc.createElement("td"));
      ((Element)v.get(434)).setAttribute("width","8" );
      ((Element)v.get(429)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(435)).setAttribute("src","b.gif" );
      ((Element)v.get(435)).setAttribute("width","8" );
      ((Element)v.get(435)).setAttribute("height","1" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */
      /* Termina nodo:434   */
      /* Termina nodo:429   */

      /* Empieza nodo:436 / Elemento padre: 428   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(436)).setAttribute("id","capaIncremento" );
      ((Element)v.get(428)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("td"));
      ((Element)v.get(436)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(438)).setAttribute("src","b.gif" );
      ((Element)v.get(437)).appendChild((Element)v.get(438));
      /* Termina nodo:438   */
      /* Termina nodo:437   */

      /* Empieza nodo:439 / Elemento padre: 436   */
      v.add(doc.createElement("td"));
      ((Element)v.get(436)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(439)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(441)).setAttribute("class","legend" );
      ((Element)v.get(440)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(442)).setAttribute("nombre","lblDatosIncremento" );
      ((Element)v.get(442)).setAttribute("alto","13" );
      ((Element)v.get(442)).setAttribute("filas","1" );
      ((Element)v.get(442)).setAttribute("valor","" );
      ((Element)v.get(442)).setAttribute("id","legend" );
      ((Element)v.get(442)).setAttribute("cod","00384" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */
      /* Termina nodo:441   */

      /* Empieza nodo:443 / Elemento padre: 440   */
      v.add(doc.createElement("table"));
      ((Element)v.get(443)).setAttribute("width","100%" );
      ((Element)v.get(443)).setAttribute("border","0" );
      ((Element)v.get(443)).setAttribute("align","center" );
      ((Element)v.get(443)).setAttribute("cellspacing","0" );
      ((Element)v.get(443)).setAttribute("cellpadding","0" );
      ((Element)v.get(440)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(443)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("td"));
      ((Element)v.get(444)).appendChild((Element)v.get(445));

      /* Empieza nodo:446 / Elemento padre: 445   */
      v.add(doc.createElement("table"));
      ((Element)v.get(446)).setAttribute("width","100%" );
      ((Element)v.get(446)).setAttribute("border","0" );
      ((Element)v.get(446)).setAttribute("align","left" );
      ((Element)v.get(446)).setAttribute("cellspacing","0" );
      ((Element)v.get(446)).setAttribute("cellpadding","0" );
      ((Element)v.get(445)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(446)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("td"));
      ((Element)v.get(448)).setAttribute("width","8" );
      ((Element)v.get(448)).setAttribute("align","center" );
      ((Element)v.get(447)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(449)).setAttribute("src","b.gif" );
      ((Element)v.get(449)).setAttribute("width","8" );
      ((Element)v.get(449)).setAttribute("height","12" );
      ((Element)v.get(448)).appendChild((Element)v.get(449));
      /* Termina nodo:449   */
      /* Termina nodo:448   */

      /* Empieza nodo:450 / Elemento padre: 447   */
      v.add(doc.createElement("td"));
      ((Element)v.get(450)).setAttribute("width","750" );
      ((Element)v.get(447)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(451)).setAttribute("src","b.gif" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));
      /* Termina nodo:451   */
      /* Termina nodo:450   */

      /* Empieza nodo:452 / Elemento padre: 447   */
      v.add(doc.createElement("td"));
      ((Element)v.get(452)).setAttribute("width","8" );
      ((Element)v.get(447)).appendChild((Element)v.get(452));

      /* Empieza nodo:453 / Elemento padre: 452   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(453)).setAttribute("src","b.gif" );
      ((Element)v.get(453)).setAttribute("width","8" );
      ((Element)v.get(453)).setAttribute("height","1" );
      ((Element)v.get(452)).appendChild((Element)v.get(453));
      /* Termina nodo:453   */
      /* Termina nodo:452   */
      /* Termina nodo:447   */

      /* Empieza nodo:454 / Elemento padre: 446   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(446)).appendChild((Element)v.get(454));

      /* Empieza nodo:455 / Elemento padre: 454   */
      v.add(doc.createElement("td"));
      ((Element)v.get(454)).appendChild((Element)v.get(455));

      /* Empieza nodo:456 / Elemento padre: 455   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(456)).setAttribute("src","b.gif" );
      ((Element)v.get(455)).appendChild((Element)v.get(456));
      /* Termina nodo:456   */
      /* Termina nodo:455   */

      /* Empieza nodo:457 / Elemento padre: 454   */
      v.add(doc.createElement("td"));
      ((Element)v.get(454)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(457)).appendChild((Element)v.get(458));

      /* Empieza nodo:459 / Elemento padre: 458   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(459)).setAttribute("class","legend" );
      ((Element)v.get(458)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(460)).setAttribute("nombre","lblDatosAnadir" );
      ((Element)v.get(460)).setAttribute("alto","13" );
      ((Element)v.get(460)).setAttribute("filas","1" );
      ((Element)v.get(460)).setAttribute("valor","" );
      ((Element)v.get(460)).setAttribute("id","legend" );
      ((Element)v.get(460)).setAttribute("cod","00280" );
      ((Element)v.get(459)).appendChild((Element)v.get(460));
      /* Termina nodo:460   */
      /* Termina nodo:459   */

      /* Empieza nodo:461 / Elemento padre: 458   */
      v.add(doc.createElement("table"));
      ((Element)v.get(461)).setAttribute("width","100%" );
      ((Element)v.get(461)).setAttribute("border","0" );
      ((Element)v.get(461)).setAttribute("align","center" );
      ((Element)v.get(461)).setAttribute("cellspacing","0" );
      ((Element)v.get(461)).setAttribute("cellpadding","0" );
      ((Element)v.get(458)).appendChild((Element)v.get(461));

      /* Empieza nodo:462 / Elemento padre: 461   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(461)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("td"));
      ((Element)v.get(462)).appendChild((Element)v.get(463));

      /* Empieza nodo:464 / Elemento padre: 463   */
      v.add(doc.createElement("table"));
      ((Element)v.get(464)).setAttribute("width","644" );
      ((Element)v.get(464)).setAttribute("border","0" );
      ((Element)v.get(464)).setAttribute("align","left" );
      ((Element)v.get(464)).setAttribute("cellspacing","0" );
      ((Element)v.get(464)).setAttribute("cellpadding","0" );
      ((Element)v.get(463)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(464)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("td"));
      ((Element)v.get(466)).setAttribute("colspan","3" );
      ((Element)v.get(465)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(467)).setAttribute("src","b.gif" );
      ((Element)v.get(467)).setAttribute("width","8" );
      ((Element)v.get(467)).setAttribute("height","8" );
      ((Element)v.get(466)).appendChild((Element)v.get(467));
      /* Termina nodo:467   */
      /* Termina nodo:466   */
      /* Termina nodo:465   */

      /* Empieza nodo:468 / Elemento padre: 464   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(464)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("td"));
      ((Element)v.get(468)).appendChild((Element)v.get(469));

      /* Empieza nodo:470 / Elemento padre: 469   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(470)).setAttribute("src","b.gif" );
      ((Element)v.get(470)).setAttribute("width","8" );
      ((Element)v.get(470)).setAttribute("height","8" );
      ((Element)v.get(469)).appendChild((Element)v.get(470));
      /* Termina nodo:470   */
      /* Termina nodo:469   */

      /* Empieza nodo:471 / Elemento padre: 468   */
      v.add(doc.createElement("td"));
      ((Element)v.get(468)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(472)).setAttribute("nombre","lblDesde" );
      ((Element)v.get(472)).setAttribute("alto","13" );
      ((Element)v.get(472)).setAttribute("filas","1" );
      ((Element)v.get(472)).setAttribute("valor","" );
      ((Element)v.get(472)).setAttribute("id","datosTitle" );
      ((Element)v.get(472)).setAttribute("cod","555" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));
      /* Termina nodo:472   */
      /* Termina nodo:471   */

      /* Empieza nodo:473 / Elemento padre: 468   */
      v.add(doc.createElement("td"));
      ((Element)v.get(468)).appendChild((Element)v.get(473));

      /* Empieza nodo:474 / Elemento padre: 473   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(474)).setAttribute("src","b.gif" );
      ((Element)v.get(474)).setAttribute("width","25" );
      ((Element)v.get(474)).setAttribute("height","8" );
      ((Element)v.get(473)).appendChild((Element)v.get(474));
      /* Termina nodo:474   */
      /* Termina nodo:473   */

      /* Empieza nodo:475 / Elemento padre: 468   */
      v.add(doc.createElement("td"));
      ((Element)v.get(468)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(476)).setAttribute("nombre","lblHasta" );
      ((Element)v.get(476)).setAttribute("alto","13" );
      ((Element)v.get(476)).setAttribute("filas","1" );
      ((Element)v.get(476)).setAttribute("valor","" );
      ((Element)v.get(476)).setAttribute("id","datosTitle" );
      ((Element)v.get(476)).setAttribute("cod","145" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */
      /* Termina nodo:475   */

      /* Empieza nodo:477 / Elemento padre: 468   */
   }

   private void getXML2070(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(468)).appendChild((Element)v.get(477));

      /* Empieza nodo:478 / Elemento padre: 477   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(478)).setAttribute("src","b.gif" );
      ((Element)v.get(478)).setAttribute("width","25" );
      ((Element)v.get(478)).setAttribute("height","8" );
      ((Element)v.get(477)).appendChild((Element)v.get(478));
      /* Termina nodo:478   */
      /* Termina nodo:477   */

      /* Empieza nodo:479 / Elemento padre: 468   */
      v.add(doc.createElement("td"));
      ((Element)v.get(468)).appendChild((Element)v.get(479));

      /* Empieza nodo:480 / Elemento padre: 479   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(480)).setAttribute("nombre","lblIncremento" );
      ((Element)v.get(480)).setAttribute("alto","13" );
      ((Element)v.get(480)).setAttribute("filas","1" );
      ((Element)v.get(480)).setAttribute("valor","" );
      ((Element)v.get(480)).setAttribute("id","datosTitle" );
      ((Element)v.get(480)).setAttribute("cod","1740" );
      ((Element)v.get(479)).appendChild((Element)v.get(480));
      /* Termina nodo:480   */
      /* Termina nodo:479   */

      /* Empieza nodo:481 / Elemento padre: 468   */
      v.add(doc.createElement("td"));
      ((Element)v.get(481)).setAttribute("width","100%" );
      ((Element)v.get(468)).appendChild((Element)v.get(481));

      /* Empieza nodo:482 / Elemento padre: 481   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(482)).setAttribute("src","b.gif" );
      ((Element)v.get(482)).setAttribute("width","8" );
      ((Element)v.get(482)).setAttribute("height","8" );
      ((Element)v.get(481)).appendChild((Element)v.get(482));
      /* Termina nodo:482   */
      /* Termina nodo:481   */
      /* Termina nodo:468   */

      /* Empieza nodo:483 / Elemento padre: 464   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(464)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("td"));
      ((Element)v.get(483)).appendChild((Element)v.get(484));

      /* Empieza nodo:485 / Elemento padre: 484   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(485)).setAttribute("src","b.gif" );
      ((Element)v.get(485)).setAttribute("width","8" );
      ((Element)v.get(485)).setAttribute("height","8" );
      ((Element)v.get(484)).appendChild((Element)v.get(485));
      /* Termina nodo:485   */
      /* Termina nodo:484   */

      /* Empieza nodo:486 / Elemento padre: 483   */
      v.add(doc.createElement("td"));
      ((Element)v.get(483)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(487)).setAttribute("nombre","txtDesde" );
      ((Element)v.get(487)).setAttribute("id","datosCampos" );
      ((Element)v.get(487)).setAttribute("max","13" );
      ((Element)v.get(487)).setAttribute("tipo","" );
      ((Element)v.get(487)).setAttribute("onchange","" );
      ((Element)v.get(487)).setAttribute("req","N" );
      ((Element)v.get(487)).setAttribute("size","16" );
      ((Element)v.get(487)).setAttribute("valor","" );
      ((Element)v.get(487)).setAttribute("validacion","" );
      ((Element)v.get(487)).setAttribute("ontab","setTabFocus('txtDesde')" );
      ((Element)v.get(487)).setAttribute("onshtab","setSHTabFocus('txtDesde')" );
      ((Element)v.get(486)).appendChild((Element)v.get(487));
      /* Termina nodo:487   */
      /* Termina nodo:486   */

      /* Empieza nodo:488 / Elemento padre: 483   */
      v.add(doc.createElement("td"));
      ((Element)v.get(483)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(489)).setAttribute("src","b.gif" );
      ((Element)v.get(489)).setAttribute("width","25" );
      ((Element)v.get(489)).setAttribute("height","8" );
      ((Element)v.get(488)).appendChild((Element)v.get(489));
      /* Termina nodo:489   */
      /* Termina nodo:488   */

      /* Empieza nodo:490 / Elemento padre: 483   */
      v.add(doc.createElement("td"));
      ((Element)v.get(483)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(491)).setAttribute("nombre","txtHasta" );
      ((Element)v.get(491)).setAttribute("id","datosCampos" );
      ((Element)v.get(491)).setAttribute("max","13" );
      ((Element)v.get(491)).setAttribute("tipo","" );
      ((Element)v.get(491)).setAttribute("onchange","" );
      ((Element)v.get(491)).setAttribute("req","N" );
      ((Element)v.get(491)).setAttribute("size","16" );
      ((Element)v.get(491)).setAttribute("valor","" );
      ((Element)v.get(491)).setAttribute("validacion","" );
      ((Element)v.get(491)).setAttribute("ontab","setTabFocus('txtHasta')" );
      ((Element)v.get(491)).setAttribute("onshtab","setSHTabFocus('txtHasta')" );
      ((Element)v.get(490)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */
      /* Termina nodo:490   */

      /* Empieza nodo:492 / Elemento padre: 483   */
      v.add(doc.createElement("td"));
      ((Element)v.get(483)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(493)).setAttribute("src","b.gif" );
      ((Element)v.get(493)).setAttribute("width","25" );
      ((Element)v.get(493)).setAttribute("height","8" );
      ((Element)v.get(492)).appendChild((Element)v.get(493));
      /* Termina nodo:493   */
      /* Termina nodo:492   */

      /* Empieza nodo:494 / Elemento padre: 483   */
      v.add(doc.createElement("td"));
      ((Element)v.get(483)).appendChild((Element)v.get(494));

      /* Empieza nodo:495 / Elemento padre: 494   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(495)).setAttribute("nombre","txtIncremento" );
      ((Element)v.get(495)).setAttribute("id","datosCampos" );
      ((Element)v.get(495)).setAttribute("max","13" );
      ((Element)v.get(495)).setAttribute("tipo","" );
      ((Element)v.get(495)).setAttribute("onchange","" );
      ((Element)v.get(495)).setAttribute("req","N" );
      ((Element)v.get(495)).setAttribute("size","16" );
      ((Element)v.get(495)).setAttribute("valor","" );
      ((Element)v.get(495)).setAttribute("validacion","" );
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(495)).setAttribute("ontab","setTabFocus('txtIncremento')" );
      ((Element)v.get(495)).setAttribute("onshtab","setSHTabFocus('txtIncremento')" );
      ((Element)v.get(494)).appendChild((Element)v.get(495));
      /* Termina nodo:495   */
      /* Termina nodo:494   */

      /* Empieza nodo:496 / Elemento padre: 483   */
      v.add(doc.createElement("td"));
      ((Element)v.get(496)).setAttribute("width","100%" );
      ((Element)v.get(483)).appendChild((Element)v.get(496));

      /* Empieza nodo:497 / Elemento padre: 496   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(497)).setAttribute("src","b.gif" );
      ((Element)v.get(497)).setAttribute("width","8" );
      ((Element)v.get(497)).setAttribute("height","8" );
      ((Element)v.get(496)).appendChild((Element)v.get(497));
      /* Termina nodo:497   */
      /* Termina nodo:496   */
      /* Termina nodo:483   */

      /* Empieza nodo:498 / Elemento padre: 464   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(464)).appendChild((Element)v.get(498));

      /* Empieza nodo:499 / Elemento padre: 498   */
      v.add(doc.createElement("td"));
      ((Element)v.get(499)).setAttribute("colspan","3" );
      ((Element)v.get(498)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(500)).setAttribute("src","b.gif" );
      ((Element)v.get(500)).setAttribute("width","8" );
      ((Element)v.get(500)).setAttribute("height","8" );
      ((Element)v.get(499)).appendChild((Element)v.get(500));
      /* Termina nodo:500   */
      /* Termina nodo:499   */
      /* Termina nodo:498   */
      /* Termina nodo:464   */
      /* Termina nodo:463   */
      /* Termina nodo:462   */
      /* Termina nodo:461   */
      /* Termina nodo:458   */
      /* Termina nodo:457   */

      /* Empieza nodo:501 / Elemento padre: 454   */
      v.add(doc.createElement("td"));
      ((Element)v.get(454)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(502)).setAttribute("src","b.gif" );
      ((Element)v.get(501)).appendChild((Element)v.get(502));
      /* Termina nodo:502   */
      /* Termina nodo:501   */
      /* Termina nodo:454   */

      /* Empieza nodo:503 / Elemento padre: 446   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(446)).appendChild((Element)v.get(503));

      /* Empieza nodo:504 / Elemento padre: 503   */
      v.add(doc.createElement("td"));
      ((Element)v.get(503)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(505)).setAttribute("src","b.gif" );
      ((Element)v.get(504)).appendChild((Element)v.get(505));
      /* Termina nodo:505   */
      /* Termina nodo:504   */

      /* Empieza nodo:506 / Elemento padre: 503   */
      v.add(doc.createElement("td"));
      ((Element)v.get(503)).appendChild((Element)v.get(506));

      /* Empieza nodo:507 / Elemento padre: 506   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(506)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
      v.add(doc.createElement("table"));
      ((Element)v.get(508)).setAttribute("width","100%" );
      ((Element)v.get(508)).setAttribute("border","0" );
      ((Element)v.get(508)).setAttribute("align","center" );
      ((Element)v.get(508)).setAttribute("cellspacing","0" );
      ((Element)v.get(508)).setAttribute("cellpadding","0" );
      ((Element)v.get(507)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(508)).appendChild((Element)v.get(509));

      /* Empieza nodo:510 / Elemento padre: 509   */
      v.add(doc.createElement("td"));
      ((Element)v.get(510)).setAttribute("class","botonera" );
      ((Element)v.get(509)).appendChild((Element)v.get(510));

      /* Empieza nodo:511 / Elemento padre: 510   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(511)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(511)).setAttribute("ID","botonContenido" );
      ((Element)v.get(511)).setAttribute("tipo","html" );
      ((Element)v.get(511)).setAttribute("accion","accionAnyadir()" );
      ((Element)v.get(511)).setAttribute("estado","false" );
      ((Element)v.get(511)).setAttribute("cod","404" );
      ((Element)v.get(511)).setAttribute("ontab","setTabFocus('btnAnadir')" );
      ((Element)v.get(511)).setAttribute("onshtab","setSHTabFocus('btnAnadir')" );
      ((Element)v.get(510)).appendChild((Element)v.get(511));
      /* Termina nodo:511   */
      /* Termina nodo:510   */
      /* Termina nodo:509   */
      /* Termina nodo:508   */
      /* Termina nodo:507   */
      /* Termina nodo:506   */

      /* Empieza nodo:512 / Elemento padre: 503   */
      v.add(doc.createElement("td"));
      ((Element)v.get(503)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(513)).setAttribute("src","b.gif" );
      ((Element)v.get(513)).setAttribute("width","8" );
      ((Element)v.get(513)).setAttribute("height","12" );
      ((Element)v.get(512)).appendChild((Element)v.get(513));
      /* Termina nodo:513   */
      /* Termina nodo:512   */
      /* Termina nodo:503   */

      /* Empieza nodo:514 / Elemento padre: 446   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(446)).appendChild((Element)v.get(514));

      /* Empieza nodo:515 / Elemento padre: 514   */
      v.add(doc.createElement("td"));
      ((Element)v.get(515)).setAttribute("colspan","3" );
      ((Element)v.get(514)).appendChild((Element)v.get(515));

      /* Empieza nodo:516 / Elemento padre: 515   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(516)).setAttribute("src","b.gif" );
      ((Element)v.get(516)).setAttribute("width","8" );
      ((Element)v.get(516)).setAttribute("height","336" );
      ((Element)v.get(515)).appendChild((Element)v.get(516));
      /* Termina nodo:516   */
      /* Termina nodo:515   */
      /* Termina nodo:514   */
      /* Termina nodo:446   */
      /* Termina nodo:445   */
      /* Termina nodo:444   */
      /* Termina nodo:443   */
      /* Termina nodo:440   */
      /* Termina nodo:439   */

      /* Empieza nodo:517 / Elemento padre: 436   */
      v.add(doc.createElement("td"));
      ((Element)v.get(436)).appendChild((Element)v.get(517));

      /* Empieza nodo:518 / Elemento padre: 517   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(518)).setAttribute("src","b.gif" );
      ((Element)v.get(517)).appendChild((Element)v.get(518));
      /* Termina nodo:518   */
      /* Termina nodo:517   */
      /* Termina nodo:436   */

      /* Empieza nodo:519 / Elemento padre: 428   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(428)).appendChild((Element)v.get(519));

      /* Empieza nodo:520 / Elemento padre: 519   */
      v.add(doc.createElement("td"));
      ((Element)v.get(520)).setAttribute("width","8" );
      ((Element)v.get(520)).setAttribute("align","center" );
      ((Element)v.get(519)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(521)).setAttribute("src","b.gif" );
      ((Element)v.get(521)).setAttribute("width","8" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(521)).setAttribute("height","12" );
      ((Element)v.get(520)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */
      /* Termina nodo:520   */

      /* Empieza nodo:522 / Elemento padre: 519   */
      v.add(doc.createElement("td"));
      ((Element)v.get(522)).setAttribute("width","756" );
      ((Element)v.get(519)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(523)).setAttribute("src","b.gif" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */
      /* Termina nodo:522   */

      /* Empieza nodo:524 / Elemento padre: 519   */
      v.add(doc.createElement("td"));
      ((Element)v.get(524)).setAttribute("width","8" );
      ((Element)v.get(519)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(525)).setAttribute("src","b.gif" );
      ((Element)v.get(525)).setAttribute("width","8" );
      ((Element)v.get(525)).setAttribute("height","1" );
      ((Element)v.get(524)).appendChild((Element)v.get(525));
      /* Termina nodo:525   */
      /* Termina nodo:524   */
      /* Termina nodo:519   */
      /* Termina nodo:428   */
      /* Termina nodo:427   */
      /* Termina nodo:426   */
      /* Termina nodo:239   */
      /* Termina nodo:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:526 / Elemento padre: 232   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(527)).setAttribute("src","b.gif" );
      ((Element)v.get(526)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */
      /* Termina nodo:526   */
      /* Termina nodo:232   */

      /* Empieza nodo:528 / Elemento padre: 224   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(224)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("td"));
      ((Element)v.get(528)).appendChild((Element)v.get(529));

      /* Empieza nodo:530 / Elemento padre: 529   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(530)).setAttribute("src","b.gif" );
      ((Element)v.get(529)).appendChild((Element)v.get(530));
      /* Termina nodo:530   */
      /* Termina nodo:529   */

      /* Empieza nodo:531 / Elemento padre: 528   */
      v.add(doc.createElement("td"));
      ((Element)v.get(528)).appendChild((Element)v.get(531));

      /* Empieza nodo:532 / Elemento padre: 531   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(531)).appendChild((Element)v.get(532));

      /* Empieza nodo:533 / Elemento padre: 532   */
      v.add(doc.createElement("table"));
      ((Element)v.get(533)).setAttribute("width","100%" );
      ((Element)v.get(533)).setAttribute("border","0" );
      ((Element)v.get(533)).setAttribute("align","center" );
      ((Element)v.get(533)).setAttribute("cellspacing","0" );
      ((Element)v.get(533)).setAttribute("cellpadding","0" );
      ((Element)v.get(532)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(533)).appendChild((Element)v.get(534));

      /* Empieza nodo:535 / Elemento padre: 534   */
      v.add(doc.createElement("td"));
      ((Element)v.get(535)).setAttribute("class","botonera" );
      ((Element)v.get(534)).appendChild((Element)v.get(535));

      /* Empieza nodo:536 / Elemento padre: 535   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(536)).setAttribute("nombre","btnProductosCalificar" );
      ((Element)v.get(536)).setAttribute("ID","botonContenido" );
      ((Element)v.get(536)).setAttribute("tipo","html" );
      ((Element)v.get(536)).setAttribute("accion","accionProductosCalificar();" );
      ((Element)v.get(536)).setAttribute("estado","false" );
      ((Element)v.get(536)).setAttribute("cod","1964" );
      ((Element)v.get(536)).setAttribute("ontab","setTabFocus('btnProductosCalificar')" );
      ((Element)v.get(536)).setAttribute("onshtab","setSHTabFocus('btnProductosCalificar')" );
      ((Element)v.get(535)).appendChild((Element)v.get(536));
      /* Termina nodo:536   */

      /* Empieza nodo:537 / Elemento padre: 535   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(537)).setAttribute("nombre","btnDefinirVentaProyectada" );
      ((Element)v.get(537)).setAttribute("ID","botonContenido" );
      ((Element)v.get(537)).setAttribute("tipo","html" );
      ((Element)v.get(537)).setAttribute("accion","accionDefinirVentaProyectada();" );
      ((Element)v.get(537)).setAttribute("estado","false" );
      ((Element)v.get(537)).setAttribute("cod","1966" );
      ((Element)v.get(537)).setAttribute("ontab","setTabFocus('btnDefinirVentaProyectada')" );
      ((Element)v.get(537)).setAttribute("onshtab","setSHTabFocus('btnDefinirVentaProyectada')" );
      ((Element)v.get(535)).appendChild((Element)v.get(537));
      /* Termina nodo:537   */

      /* Empieza nodo:538 / Elemento padre: 535   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(538)).setAttribute("nombre","btnParticipantes" );
      ((Element)v.get(538)).setAttribute("ID","botonContenido" );
      ((Element)v.get(538)).setAttribute("tipo","html" );
      ((Element)v.get(538)).setAttribute("accion","accionParticipantes();" );
      ((Element)v.get(538)).setAttribute("estado","false" );
      ((Element)v.get(538)).setAttribute("cod","745" );
      ((Element)v.get(538)).setAttribute("ontab","setTabFocus('btnParticipantes')" );
      ((Element)v.get(538)).setAttribute("onshtab","setSHTabFocus('btnParticipantes')" );
      ((Element)v.get(535)).appendChild((Element)v.get(538));
      /* Termina nodo:538   */

      /* Empieza nodo:539 / Elemento padre: 535   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(539)).setAttribute("nombre","btnCalcularMetas" );
      ((Element)v.get(539)).setAttribute("ID","botonContenido" );
      ((Element)v.get(539)).setAttribute("tipo","html" );
      ((Element)v.get(539)).setAttribute("accion","accionCalcularMetas();" );
      ((Element)v.get(539)).setAttribute("estado","false" );
      ((Element)v.get(539)).setAttribute("cod","1732" );
      ((Element)v.get(539)).setAttribute("ontab","setTabFocus('btnCalcularMetas')" );
      ((Element)v.get(539)).setAttribute("onshtab","setSHTabFocus('btnCalcularMetas')" );
      ((Element)v.get(535)).appendChild((Element)v.get(539));
      /* Termina nodo:539   */

      /* Empieza nodo:540 / Elemento padre: 535   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(540)).setAttribute("nombre","btnMantenerMetas" );
      ((Element)v.get(540)).setAttribute("ID","botonContenido" );
      ((Element)v.get(540)).setAttribute("tipo","html" );
      ((Element)v.get(540)).setAttribute("accion","accionMantenerMetas();" );
      ((Element)v.get(540)).setAttribute("estado","false" );
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(540)).setAttribute("cod","2858" );
      ((Element)v.get(540)).setAttribute("ontab","setTabFocus('btnMantenerMetas')" );
      ((Element)v.get(540)).setAttribute("onshtab","setSHTabFocus('btnMantenerMetas')" );
      ((Element)v.get(535)).appendChild((Element)v.get(540));
      /* Termina nodo:540   */

      /* Empieza nodo:541 / Elemento padre: 535   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(541)).setAttribute("nombre","btnConsultarMetasTipoVenta" );
      ((Element)v.get(541)).setAttribute("ID","botonContenido" );
      ((Element)v.get(541)).setAttribute("tipo","html" );
      ((Element)v.get(541)).setAttribute("accion","accionConsultarMetasTipoVenta();" );
      ((Element)v.get(541)).setAttribute("estado","false" );
      ((Element)v.get(541)).setAttribute("cod","0546" );
      ((Element)v.get(541)).setAttribute("ontab","" );
      ((Element)v.get(541)).setAttribute("onshtab","" );
      ((Element)v.get(535)).appendChild((Element)v.get(541));
      /* Termina nodo:541   */
      /* Termina nodo:535   */
      /* Termina nodo:534   */

      /* Empieza nodo:542 / Elemento padre: 533   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(533)).appendChild((Element)v.get(542));

      /* Empieza nodo:543 / Elemento padre: 542   */
      v.add(doc.createElement("td"));
      ((Element)v.get(543)).setAttribute("class","botonera" );
      ((Element)v.get(542)).appendChild((Element)v.get(543));

      /* Empieza nodo:544 / Elemento padre: 543   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(544)).setAttribute("nombre","btnConsultarMetasVentaProyectada" );
      ((Element)v.get(544)).setAttribute("ID","botonContenido" );
      ((Element)v.get(544)).setAttribute("tipo","html" );
      ((Element)v.get(544)).setAttribute("accion","accionConsultarMetasVentaProyectada();" );
      ((Element)v.get(544)).setAttribute("estado","false" );
      ((Element)v.get(544)).setAttribute("cod","0545" );
      ((Element)v.get(544)).setAttribute("ontab","" );
      ((Element)v.get(544)).setAttribute("onshtab","" );
      ((Element)v.get(543)).appendChild((Element)v.get(544));
      /* Termina nodo:544   */
      /* Termina nodo:543   */
      /* Termina nodo:542   */
      /* Termina nodo:533   */
      /* Termina nodo:532   */
      /* Termina nodo:531   */

      /* Empieza nodo:545 / Elemento padre: 528   */
      v.add(doc.createElement("td"));
      ((Element)v.get(528)).appendChild((Element)v.get(545));

      /* Empieza nodo:546 / Elemento padre: 545   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(546)).setAttribute("src","b.gif" );
      ((Element)v.get(546)).setAttribute("width","8" );
      ((Element)v.get(546)).setAttribute("height","12" );
      ((Element)v.get(545)).appendChild((Element)v.get(546));
      /* Termina nodo:546   */
      /* Termina nodo:545   */
      /* Termina nodo:528   */

      /* Empieza nodo:547 / Elemento padre: 224   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(224)).appendChild((Element)v.get(547));

      /* Empieza nodo:548 / Elemento padre: 547   */
      v.add(doc.createElement("td"));
      ((Element)v.get(548)).setAttribute("width","12" );
      ((Element)v.get(548)).setAttribute("align","center" );
      ((Element)v.get(547)).appendChild((Element)v.get(548));

      /* Empieza nodo:549 / Elemento padre: 548   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(549)).setAttribute("src","b.gif" );
      ((Element)v.get(549)).setAttribute("width","12" );
      ((Element)v.get(549)).setAttribute("height","12" );
      ((Element)v.get(548)).appendChild((Element)v.get(549));
      /* Termina nodo:549   */
      /* Termina nodo:548   */

      /* Empieza nodo:550 / Elemento padre: 547   */
      v.add(doc.createElement("td"));
      ((Element)v.get(550)).setAttribute("width","756" );
      ((Element)v.get(547)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(551)).setAttribute("src","b.gif" );
      ((Element)v.get(550)).appendChild((Element)v.get(551));
      /* Termina nodo:551   */
      /* Termina nodo:550   */

      /* Empieza nodo:552 / Elemento padre: 547   */
      v.add(doc.createElement("td"));
      ((Element)v.get(552)).setAttribute("width","12" );
      ((Element)v.get(547)).appendChild((Element)v.get(552));

      /* Empieza nodo:553 / Elemento padre: 552   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(553)).setAttribute("src","b.gif" );
      ((Element)v.get(553)).setAttribute("width","12" );
      ((Element)v.get(553)).setAttribute("height","1" );
      ((Element)v.get(552)).appendChild((Element)v.get(553));
      /* Termina nodo:553   */
      /* Termina nodo:552   */
      /* Termina nodo:547   */
      /* Termina nodo:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:554 / Elemento padre: 20   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(554)).setAttribute("nombre","listado3" );
      ((Element)v.get(554)).setAttribute("ancho","647" );
      ((Element)v.get(554)).setAttribute("alto","299" );
      ((Element)v.get(554)).setAttribute("x","32" );
      ((Element)v.get(554)).setAttribute("y","395" );
      ((Element)v.get(554)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(554)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(20)).appendChild((Element)v.get(554));

      /* Empieza nodo:555 / Elemento padre: 554   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(555)).setAttribute("precarga","S" );
      ((Element)v.get(555)).setAttribute("conROver","S" );
      ((Element)v.get(554)).appendChild((Element)v.get(555));

      /* Empieza nodo:556 / Elemento padre: 555   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(556)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(556)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(556)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(556)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(555)).appendChild((Element)v.get(556));
      /* Termina nodo:556   */

      /* Empieza nodo:557 / Elemento padre: 555   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(557)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(557)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(557)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(557)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(555)).appendChild((Element)v.get(557));
      /* Termina nodo:557   */

      /* Empieza nodo:558 / Elemento padre: 555   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(558)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(558)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(555)).appendChild((Element)v.get(558));
      /* Termina nodo:558   */
      /* Termina nodo:555   */

      /* Empieza nodo:559 / Elemento padre: 554   */
   }

   private void getXML2430(Document doc) {
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(554)).appendChild((Element)v.get(559));

      /* Empieza nodo:560 / Elemento padre: 559   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(560)).setAttribute("borde","1" );
      ((Element)v.get(560)).setAttribute("horizDatos","1" );
      ((Element)v.get(560)).setAttribute("horizCabecera","1" );
      ((Element)v.get(560)).setAttribute("vertical","0" );
      ((Element)v.get(560)).setAttribute("horizTitulo","1" );
      ((Element)v.get(560)).setAttribute("horizBase","1" );
      ((Element)v.get(559)).appendChild((Element)v.get(560));
      /* Termina nodo:560   */

      /* Empieza nodo:561 / Elemento padre: 559   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(561)).setAttribute("borde","#999999" );
      ((Element)v.get(561)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(561)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(561)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(561)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(561)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(561)).setAttribute("horizBase","#999999" );
      ((Element)v.get(559)).appendChild((Element)v.get(561));
      /* Termina nodo:561   */
      /* Termina nodo:559   */

      /* Empieza nodo:562 / Elemento padre: 554   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(562)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(562)).setAttribute("alto","22" );
      ((Element)v.get(562)).setAttribute("imgFondo","" );
      ((Element)v.get(562)).setAttribute("cod","00385" );
      ((Element)v.get(562)).setAttribute("ID","datosTitle" );
      ((Element)v.get(554)).appendChild((Element)v.get(562));
      /* Termina nodo:562   */

      /* Empieza nodo:563 / Elemento padre: 554   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(563)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(563)).setAttribute("alto","22" );
      ((Element)v.get(563)).setAttribute("imgFondo","" );
      ((Element)v.get(554)).appendChild((Element)v.get(563));
      /* Termina nodo:563   */

      /* Empieza nodo:564 / Elemento padre: 554   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(564)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(564)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(564)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(564)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(564)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(564)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(554)).appendChild((Element)v.get(564));

      /* Empieza nodo:565 / Elemento padre: 564   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(565)).setAttribute("ancho","5" );
      ((Element)v.get(565)).setAttribute("minimizable","S" );
      ((Element)v.get(565)).setAttribute("minimizada","N" );
      ((Element)v.get(564)).appendChild((Element)v.get(565));
      /* Termina nodo:565   */

      /* Empieza nodo:566 / Elemento padre: 564   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(566)).setAttribute("ancho","10" );
      ((Element)v.get(566)).setAttribute("minimizable","S" );
      ((Element)v.get(566)).setAttribute("minimizada","N" );
      ((Element)v.get(564)).appendChild((Element)v.get(566));
      /* Termina nodo:566   */

      /* Empieza nodo:567 / Elemento padre: 564   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(567)).setAttribute("ancho","10" );
      ((Element)v.get(567)).setAttribute("minimizable","S" );
      ((Element)v.get(567)).setAttribute("minimizada","N" );
      ((Element)v.get(564)).appendChild((Element)v.get(567));
      /* Termina nodo:567   */
      /* Termina nodo:564   */

      /* Empieza nodo:568 / Elemento padre: 554   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(568)).setAttribute("alto","20" );
      ((Element)v.get(568)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(568)).setAttribute("imgFondo","" );
      ((Element)v.get(568)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(554)).appendChild((Element)v.get(568));

      /* Empieza nodo:569 / Elemento padre: 568   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(569)).setAttribute("colFondo","" );
      ((Element)v.get(569)).setAttribute("ID","EstCab" );
      ((Element)v.get(569)).setAttribute("cod","555" );
      ((Element)v.get(568)).appendChild((Element)v.get(569));

      /* Elemento padre:569 / Elemento actual: 570   */
      v.add(doc.createTextNode("Desde"));
      ((Element)v.get(569)).appendChild((Text)v.get(570));

      /* Termina nodo Texto:570   */
      /* Termina nodo:569   */

      /* Empieza nodo:571 / Elemento padre: 568   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(571)).setAttribute("colFondo","" );
      ((Element)v.get(571)).setAttribute("ID","EstCab" );
      ((Element)v.get(571)).setAttribute("cod","145" );
      ((Element)v.get(568)).appendChild((Element)v.get(571));

      /* Elemento padre:571 / Elemento actual: 572   */
      v.add(doc.createTextNode("Hasta"));
      ((Element)v.get(571)).appendChild((Text)v.get(572));

      /* Termina nodo Texto:572   */
      /* Termina nodo:571   */

      /* Empieza nodo:573 / Elemento padre: 568   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(573)).setAttribute("colFondo","" );
      ((Element)v.get(573)).setAttribute("ID","EstCab" );
      ((Element)v.get(573)).setAttribute("cod","1740" );
      ((Element)v.get(568)).appendChild((Element)v.get(573));

      /* Elemento padre:573 / Elemento actual: 574   */
      v.add(doc.createTextNode("Incremento"));
      ((Element)v.get(573)).appendChild((Text)v.get(574));

      /* Termina nodo Texto:574   */
      /* Termina nodo:573   */
      /* Termina nodo:568   */

      /* Empieza nodo:575 / Elemento padre: 554   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(575)).setAttribute("alto","22" );
      ((Element)v.get(575)).setAttribute("accion","" );
      ((Element)v.get(575)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(575)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(575)).setAttribute("maxSel","-1" );
      ((Element)v.get(575)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(575)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(575)).setAttribute("colorROver","#D0D9E8" );
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(575)).setAttribute("onLoad","" );
      ((Element)v.get(575)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(554)).appendChild((Element)v.get(575));

      /* Empieza nodo:576 / Elemento padre: 575   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(576)).setAttribute("tipo","texto" );
      ((Element)v.get(576)).setAttribute("ID","EstDat" );
      ((Element)v.get(575)).appendChild((Element)v.get(576));
      /* Termina nodo:576   */

      /* Empieza nodo:577 / Elemento padre: 575   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(577)).setAttribute("tipo","texto" );
      ((Element)v.get(577)).setAttribute("ID","EstDat2" );
      ((Element)v.get(575)).appendChild((Element)v.get(577));
      /* Termina nodo:577   */

      /* Empieza nodo:578 / Elemento padre: 575   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(578)).setAttribute("tipo","texto" );
      ((Element)v.get(578)).setAttribute("ID","EstDat" );
      ((Element)v.get(575)).appendChild((Element)v.get(578));
      /* Termina nodo:578   */
      /* Termina nodo:575   */

      /* Empieza nodo:579 / Elemento padre: 554   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(554)).appendChild((Element)v.get(579));
      /* Termina nodo:579   */

      /* Empieza nodo:580 / Elemento padre: 554   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(580)).setAttribute("nombre","mipgndo3" );
      ((Element)v.get(580)).setAttribute("ancho","615" );
      ((Element)v.get(580)).setAttribute("sep","$" );
      ((Element)v.get(580)).setAttribute("x","32" );
      ((Element)v.get(580)).setAttribute("class","botonera" );
      ((Element)v.get(580)).setAttribute("y","671" );
      ((Element)v.get(580)).setAttribute("control","|" );
      ((Element)v.get(580)).setAttribute("conector","conectorSandra2" );
      ((Element)v.get(580)).setAttribute("rowset","" );
      ((Element)v.get(580)).setAttribute("cargainicial","N" );
      ((Element)v.get(554)).appendChild((Element)v.get(580));

      /* Empieza nodo:581 / Elemento padre: 580   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(581)).setAttribute("nombre","ret3" );
      ((Element)v.get(581)).setAttribute("x","57" );
      ((Element)v.get(581)).setAttribute("y","675" );
      ((Element)v.get(581)).setAttribute("ID","botonContenido" );
      ((Element)v.get(581)).setAttribute("img","retroceder_on" );
      ((Element)v.get(581)).setAttribute("tipo","0" );
      ((Element)v.get(581)).setAttribute("estado","false" );
      ((Element)v.get(581)).setAttribute("alt","" );
      ((Element)v.get(581)).setAttribute("codigo","" );
      ((Element)v.get(581)).setAttribute("accion","mipgndo3.retroceder();" );
      ((Element)v.get(580)).appendChild((Element)v.get(581));
      /* Termina nodo:581   */

      /* Empieza nodo:582 / Elemento padre: 580   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(582)).setAttribute("nombre","ava3" );
      ((Element)v.get(582)).setAttribute("x","72" );
      ((Element)v.get(582)).setAttribute("y","675" );
      ((Element)v.get(582)).setAttribute("ID","botonContenido" );
      ((Element)v.get(582)).setAttribute("img","avanzar_on" );
      ((Element)v.get(582)).setAttribute("tipo","0" );
      ((Element)v.get(582)).setAttribute("estado","false" );
      ((Element)v.get(582)).setAttribute("alt","" );
      ((Element)v.get(582)).setAttribute("codigo","" );
      ((Element)v.get(582)).setAttribute("accion","mipgndo3.avanzar();" );
      ((Element)v.get(580)).appendChild((Element)v.get(582));
      /* Termina nodo:582   */
      /* Termina nodo:580   */
      /* Termina nodo:554   */

      /* Empieza nodo:583 / Elemento padre: 20   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(583)).setAttribute("nombre","primera3" );
      ((Element)v.get(583)).setAttribute("x","40" );
      ((Element)v.get(583)).setAttribute("y","675" );
      ((Element)v.get(583)).setAttribute("ID","botonContenido" );
      ((Element)v.get(583)).setAttribute("img","primera_on" );
      ((Element)v.get(583)).setAttribute("tipo","0" );
      ((Element)v.get(583)).setAttribute("estado","false" );
      ((Element)v.get(583)).setAttribute("alt","" );
      ((Element)v.get(583)).setAttribute("codigo","" );
      ((Element)v.get(583)).setAttribute("accion","mipgndo3.retrocederPrimeraPagina();" );
      ((Element)v.get(20)).appendChild((Element)v.get(583));
      /* Termina nodo:583   */

      /* Empieza nodo:584 / Elemento padre: 20   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(584)).setAttribute("nombre","separa3" );
      ((Element)v.get(584)).setAttribute("x","79" );
      ((Element)v.get(584)).setAttribute("y","671" );
      ((Element)v.get(584)).setAttribute("ID","botonContenido" );
      ((Element)v.get(584)).setAttribute("img","separa_base" );
      ((Element)v.get(584)).setAttribute("tipo","0" );
      ((Element)v.get(584)).setAttribute("estado","false" );
      ((Element)v.get(584)).setAttribute("alt","" );
      ((Element)v.get(584)).setAttribute("codigo","" );
      ((Element)v.get(584)).setAttribute("accion","" );
      ((Element)v.get(20)).appendChild((Element)v.get(584));
      /* Termina nodo:584   */

      /* Empieza nodo:585 / Elemento padre: 20   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(585)).setAttribute("nombre","btnEliminar" );
      ((Element)v.get(585)).setAttribute("x","33" );
      ((Element)v.get(585)).setAttribute("y","672" );
      ((Element)v.get(585)).setAttribute("ID","botonContenido" );
      ((Element)v.get(585)).setAttribute("tipo","html" );
      ((Element)v.get(585)).setAttribute("estado","false" );
      ((Element)v.get(585)).setAttribute("cod","1254" );
      ((Element)v.get(585)).setAttribute("accion","accionEliminar()" );
      ((Element)v.get(585)).setAttribute("ontab","setTabFocus('btnEliminar')" );
      ((Element)v.get(585)).setAttribute("onshtab","setSHTabFocus('btnEliminar')" );
      ((Element)v.get(20)).appendChild((Element)v.get(585));
      /* Termina nodo:585   */
      /* Termina nodo:20   */


   }

}

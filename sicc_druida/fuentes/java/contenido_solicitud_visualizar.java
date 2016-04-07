
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_solicitud_visualizar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_solicitud_visualizar" );
      ((Element)v.get(0)).setAttribute("cod","0922" );
      ((Element)v.get(0)).setAttribute("titulo","Consultar Solicitudes" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Visualizar Solicitud" );
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
      ((Element)v.get(2)).setAttribute("src","contenido_solicitud_visualizar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(5)).setAttribute("name","cbAccesoFisico" );
      ((Element)v.get(5)).setAttribute("required","true" );
      ((Element)v.get(5)).setAttribute("cod","1389" );
      ((Element)v.get(5)).setAttribute("group","pest1" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(6)).setAttribute("name","cbTipoDespacho" );
      ((Element)v.get(6)).setAttribute("required","true" );
      ((Element)v.get(6)).setAttribute("cod","1000" );
      ((Element)v.get(6)).setAttribute("group","pest1" );
      ((Element)v.get(4)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","txtReceptorFactura" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","1391" );
      ((Element)v.get(7)).setAttribute("group","pest3" );
      ((Element)v.get(4)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","txtPagadorFactura" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","2343" );
      ((Element)v.get(8)).setAttribute("group","pest3" );
      ((Element)v.get(4)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbDestino" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","1390" );
      ((Element)v.get(9)).setAttribute("group","pest3" );
      ((Element)v.get(4)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbTipoDocumentoIdentidad" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","1126" );
      ((Element)v.get(10)).setAttribute("group","pest3" );
      ((Element)v.get(4)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","txtNumeroClientes" );
      ((Element)v.get(11)).setAttribute("required","false" );
      ((Element)v.get(11)).setAttribute("cod","930" );
      ((Element)v.get(11)).setAttribute("group","pest3" );
      ((Element)v.get(11)).setAttribute("format","e" );
      ((Element)v.get(11)).setAttribute("min","0" );
      ((Element)v.get(11)).setAttribute("max","99999" );
      ((Element)v.get(4)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 4   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","txtFechaPrevistaFacturacion" );
      ((Element)v.get(12)).setAttribute("required","false" );
      ((Element)v.get(12)).setAttribute("cod","2352" );
      ((Element)v.get(12)).setAttribute("format","f" );
      ((Element)v.get(12)).setAttribute("group","pest5" );
      ((Element)v.get(4)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */
      /* Termina nodo:4   */

      /* Empieza nodo:13 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(13)).setAttribute("nombre","frmFormulario" );
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
      ((Element)v.get(15)).setAttribute("valor","LPConsultarModificarSolicitud" );
      ((Element)v.get(13)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(17)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(13)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hCasoDeUso" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hLongitudCodCliente" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hIndicadorBusquedaCliente" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","enablebtVisualizarPosiciones" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","enablebtModificarPosiciones" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","enableCamposModificar" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hcbAccesoFisico" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hcbTipoDespacho" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hcbDestino" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hcbTipoDocumentoIdentidad" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hcbFormaPago" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hoidCabeceraSolicitud" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hoidTipoSolicitud" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hoidProceso" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hcodCliente" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hnroSolicitud" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hoidSubacceso" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hoidMarca" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hoidCanal" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hoidPeriodo" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hoidAcceso" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hoidTipoCliente" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(40)).setAttribute("nombre","hoidSubtipocliente" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","hoidSubgerenciaventas" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hoidRegion" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hoidZona" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","hoidSeccion" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","hoidTerritorio" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","hoidTipoDocumentoLegal" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","hoidNroDocumento" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","hoidMoneda" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","hoidEstadoSolicitud" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","hoidGrupoProcesos" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","hoidCliente" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","hoidConsultora" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","hoidReceptor" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","hoidPagador" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","hcerrar" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","hultimaPestana" );
      ((Element)v.get(56)).setAttribute("valor","1" );
      ((Element)v.get(13)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 13   */
      v.add(doc.createElement("table"));
      ((Element)v.get(57)).setAttribute("width","100%" );
      ((Element)v.get(57)).setAttribute("height","100%" );
      ((Element)v.get(57)).setAttribute("border","0" );
      ((Element)v.get(57)).setAttribute("align","center" );
      ((Element)v.get(57)).setAttribute("cellpadding","0" );
      ((Element)v.get(57)).setAttribute("cellspacing","0" );
      ((Element)v.get(57)).setAttribute("class","menu4" );
      ((Element)v.get(13)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).setAttribute("width","12" );
      ((Element)v.get(59)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(59)).setAttribute("class","menu5texto" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","12" );
      ((Element)v.get(60)).setAttribute("height","30" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).setAttribute("nowrap","nowrap" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(61)).setAttribute("class","menu5texto" );
      ((Element)v.get(58)).appendChild((Element)v.get(61));

      /* Elemento padre:61 / Elemento actual: 62   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(61)).appendChild((Text)v.get(62));

      /* Termina nodo Texto:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("width","10" );
      ((Element)v.get(63)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(63)).setAttribute("class","menu5texto" );
      ((Element)v.get(58)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","10" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:65 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).setAttribute("width","92" );
      ((Element)v.get(65)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(65)).setAttribute("class","menu5texto" );
      ((Element)v.get(58)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("table"));
      ((Element)v.get(66)).setAttribute("width","75" );
      ((Element)v.get(66)).setAttribute("border","1" );
      ((Element)v.get(66)).setAttribute("align","center" );
      ((Element)v.get(66)).setAttribute("cellpadding","1" );
      ((Element)v.get(66)).setAttribute("cellspacing","0" );
      ((Element)v.get(66)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(66)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(67)).setAttribute("align","center" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).setAttribute("id","pestana1" );
      ((Element)v.get(68)).setAttribute("onmouseover","poneMano('pestana1');" );
      ((Element)v.get(68)).setAttribute("onclick","onClickPestana('1');" );
      ((Element)v.get(68)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(69)).setAttribute("nombre","lblPestana1" );
      ((Element)v.get(69)).setAttribute("alto","13" );
      ((Element)v.get(69)).setAttribute("filas","1" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(69)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(69)).setAttribute("cod","PedRegPedidos.infBasicaDoc.label" );
      ((Element)v.get(69)).setAttribute("onshtab","tabGenerico('cbAccesoFisico','sh');" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:70 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(70)).setAttribute("width","10" );
      ((Element)v.get(70)).setAttribute("class","menu5texto" );
      ((Element)v.get(58)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","10" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(72)).setAttribute("width","20" );
      ((Element)v.get(72)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(72)).setAttribute("class","menu5texto" );
      ((Element)v.get(58)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("table"));
      ((Element)v.get(73)).setAttribute("width","75" );
      ((Element)v.get(73)).setAttribute("border","1" );
      ((Element)v.get(73)).setAttribute("align","center" );
      ((Element)v.get(73)).setAttribute("cellpadding","1" );
      ((Element)v.get(73)).setAttribute("cellspacing","0" );
      ((Element)v.get(73)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(74)).setAttribute("align","center" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("id","pestana2" );
      ((Element)v.get(75)).setAttribute("onmouseover","poneMano('pestana2');" );
      ((Element)v.get(75)).setAttribute("onclick","onClickPestana('2');" );
      ((Element)v.get(75)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(76)).setAttribute("nombre","lblPestana2" );
      ((Element)v.get(76)).setAttribute("alto","13" );
      ((Element)v.get(76)).setAttribute("filas","1" );
      ((Element)v.get(76)).setAttribute("valor","" );
      ((Element)v.get(76)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(76)).setAttribute("cod","PedRegPedidos.infCliente.label" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:77 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("width","10" );
      ((Element)v.get(77)).setAttribute("class","menu5texto" );
      ((Element)v.get(58)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","10" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).setAttribute("width","20" );
      ((Element)v.get(79)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(79)).setAttribute("class","menu5texto" );
      ((Element)v.get(58)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("table"));
      ((Element)v.get(80)).setAttribute("width","75" );
      ((Element)v.get(80)).setAttribute("border","1" );
      ((Element)v.get(80)).setAttribute("align","center" );
      ((Element)v.get(80)).setAttribute("cellpadding","1" );
      ((Element)v.get(80)).setAttribute("cellspacing","0" );
      ((Element)v.get(80)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(81)).setAttribute("align","center" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).setAttribute("id","pestana3" );
      ((Element)v.get(82)).setAttribute("onmouseover","poneMano('pestana3');" );
      ((Element)v.get(82)).setAttribute("onclick","onClickPestana('3');" );
      ((Element)v.get(82)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(83)).setAttribute("nombre","lblPestana3" );
      ((Element)v.get(83)).setAttribute("alto","13" );
      ((Element)v.get(83)).setAttribute("filas","1" );
      ((Element)v.get(83)).setAttribute("valor","" );
      ((Element)v.get(83)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(83)).setAttribute("cod","PedRegPedidos.infAdminDoc.label" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:84 / Elemento padre: 58   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).setAttribute("width","16" );
      ((Element)v.get(84)).setAttribute("class","menu5texto" );
      ((Element)v.get(58)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).setAttribute("width","12" );
      ((Element)v.get(85)).setAttribute("height","8" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:86 / Elemento padre: 13   */
      v.add(doc.createElement("table"));
      ((Element)v.get(86)).setAttribute("width","100%" );
      ((Element)v.get(86)).setAttribute("height","100%" );
      ((Element)v.get(86)).setAttribute("border","0" );
      ((Element)v.get(86)).setAttribute("align","center" );
      ((Element)v.get(86)).setAttribute("cellpadding","0" );
      ((Element)v.get(86)).setAttribute("cellspacing","0" );
      ((Element)v.get(86)).setAttribute("class","menu4" );
      ((Element)v.get(13)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("width","12" );
      ((Element)v.get(88)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(88)).setAttribute("class","menu5texto" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(89)).setAttribute("src","b.gif" );
      ((Element)v.get(89)).setAttribute("width","12" );
      ((Element)v.get(89)).setAttribute("height","30" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(90)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(90)).setAttribute("class","menu5texto" );
      ((Element)v.get(87)).appendChild((Element)v.get(90));

      /* Elemento padre:90 / Elemento actual: 91   */
      v.add(doc.createTextNode(" "));
      ((Element)v.get(90)).appendChild((Text)v.get(91));

      /* Termina nodo Texto:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).setAttribute("width","10" );
      ((Element)v.get(92)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(92)).setAttribute("class","menu5texto" );
      ((Element)v.get(87)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","10" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(94)).setAttribute("width","70" );
      ((Element)v.get(94)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(94)).setAttribute("class","menu5texto" );
      ((Element)v.get(87)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("table"));
      ((Element)v.get(95)).setAttribute("width","75" );
      ((Element)v.get(95)).setAttribute("border","1" );
      ((Element)v.get(95)).setAttribute("align","center" );
      ((Element)v.get(95)).setAttribute("cellpadding","1" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(95)).setAttribute("cellspacing","0" );
      ((Element)v.get(95)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(96)).setAttribute("align","center" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).setAttribute("id","pestana4" );
      ((Element)v.get(97)).setAttribute("onmouseover","poneMano('pestana4');" );
      ((Element)v.get(97)).setAttribute("onclick","onClickPestana('4');" );
      ((Element)v.get(97)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(98)).setAttribute("nombre","lblPestana4" );
      ((Element)v.get(98)).setAttribute("alto","13" );
      ((Element)v.get(98)).setAttribute("filas","1" );
      ((Element)v.get(98)).setAttribute("valor","" );
      ((Element)v.get(98)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(98)).setAttribute("cod","PedRegPedidos.infEconDoc.label" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:99 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("width","10" );
      ((Element)v.get(99)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(99)).setAttribute("class","menu5texto" );
      ((Element)v.get(87)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","10" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(101)).setAttribute("width","70" );
      ((Element)v.get(101)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(101)).setAttribute("class","menu5texto" );
      ((Element)v.get(87)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("table"));
      ((Element)v.get(102)).setAttribute("width","75" );
      ((Element)v.get(102)).setAttribute("border","1" );
      ((Element)v.get(102)).setAttribute("align","center" );
      ((Element)v.get(102)).setAttribute("cellpadding","1" );
      ((Element)v.get(102)).setAttribute("cellspacing","0" );
      ((Element)v.get(102)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(103)).setAttribute("align","center" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("id","pestana5" );
      ((Element)v.get(104)).setAttribute("onmouseover","poneMano('pestana5');" );
      ((Element)v.get(104)).setAttribute("onclick","onClickPestana('5');" );
      ((Element)v.get(104)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(105)).setAttribute("nombre","lblPestana5" );
      ((Element)v.get(105)).setAttribute("alto","13" );
      ((Element)v.get(105)).setAttribute("filas","1" );
      ((Element)v.get(105)).setAttribute("valor","" );
      ((Element)v.get(105)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(105)).setAttribute("cod","PedRegPedidos.infEstadDoc.label" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:106 / Elemento padre: 87   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).setAttribute("width","16" );
      ((Element)v.get(106)).setAttribute("class","menu5texto" );
      ((Element)v.get(87)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","12" );
      ((Element)v.get(107)).setAttribute("height","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:108 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(108)).setAttribute("nombre","capa1" );
      ((Element)v.get(108)).setAttribute("visibilidad","visible" );
      ((Element)v.get(13)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("table"));
      ((Element)v.get(109)).setAttribute("width","100%" );
      ((Element)v.get(109)).setAttribute("border","0" );
      ((Element)v.get(109)).setAttribute("cellspacing","0" );
      ((Element)v.get(109)).setAttribute("cellpadding","0" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("width","12" );
      ((Element)v.get(111)).setAttribute("align","center" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).setAttribute("width","12" );
      ((Element)v.get(112)).setAttribute("height","12" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 110   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("width","750" );
      ((Element)v.get(110)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 110   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).setAttribute("width","12" );
      ((Element)v.get(110)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(116)).setAttribute("width","12" );
      ((Element)v.get(116)).setAttribute("height","1" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:110   */

      /* Empieza nodo:117 / Elemento padre: 109   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(109)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(122)).setAttribute("class","legend" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(123)).setAttribute("nombre","lblInformacionBasicaDocumento" );
      ((Element)v.get(123)).setAttribute("alto","13" );
      ((Element)v.get(123)).setAttribute("filas","1" );
      ((Element)v.get(123)).setAttribute("valor","" );
      ((Element)v.get(123)).setAttribute("id","legend" );
      ((Element)v.get(123)).setAttribute("cod","00572" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 121   */
      v.add(doc.createElement("table"));
      ((Element)v.get(124)).setAttribute("width","100%" );
      ((Element)v.get(124)).setAttribute("border","0" );
      ((Element)v.get(124)).setAttribute("align","center" );
      ((Element)v.get(124)).setAttribute("cellspacing","0" );
      ((Element)v.get(124)).setAttribute("cellpadding","0" );
      ((Element)v.get(121)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("td"));
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("table"));
      ((Element)v.get(127)).setAttribute("width","655" );
      ((Element)v.get(127)).setAttribute("border","0" );
      ((Element)v.get(127)).setAttribute("align","left" );
      ((Element)v.get(127)).setAttribute("cellspacing","0" );
      ((Element)v.get(127)).setAttribute("cellpadding","0" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("colspan","3" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","8" );
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:131 / Elemento padre: 127   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(127)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","8" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(135)).setAttribute("nombre","lblTipoSolicitud" );
      ((Element)v.get(135)).setAttribute("alto","13" );
      ((Element)v.get(135)).setAttribute("filas","1" );
      ((Element)v.get(135)).setAttribute("valor","" );
      ((Element)v.get(135)).setAttribute("id","datosTitle" );
      ((Element)v.get(135)).setAttribute("cod","415" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).setAttribute("width","25" );
      ((Element)v.get(137)).setAttribute("height","8" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 131   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(139)).setAttribute("nombre","lblSubacceso" );
      ((Element)v.get(139)).setAttribute("alto","13" );
      ((Element)v.get(139)).setAttribute("filas","1" );
      ((Element)v.get(139)).setAttribute("valor","" );
      ((Element)v.get(139)).setAttribute("id","datosTitle" );
      ((Element)v.get(139)).setAttribute("cod","122" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).setAttribute("width","25" );
      ((Element)v.get(141)).setAttribute("height","8" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:142 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(143)).setAttribute("nombre","lblNumeroSolicitud" );
      ((Element)v.get(143)).setAttribute("alto","13" );
      ((Element)v.get(143)).setAttribute("filas","1" );
      ((Element)v.get(143)).setAttribute("valor","" );
      ((Element)v.get(143)).setAttribute("id","datosTitle" );
      ((Element)v.get(143)).setAttribute("cod","424" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:144 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).setAttribute("width","100%" );
      ((Element)v.get(131)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).setAttribute("width","8" );
      ((Element)v.get(145)).setAttribute("height","8" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:131   */

      /* Empieza nodo:146 / Elemento padre: 127   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(127)).appendChild((Element)v.get(146));

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
      ((Element)v.get(150)).setAttribute("nombre","lblTipoSolicitudXX" );
      ((Element)v.get(150)).setAttribute("alto","13" );
      ((Element)v.get(150)).setAttribute("filas","1" );
      ((Element)v.get(150)).setAttribute("valor","" );
      ((Element)v.get(150)).setAttribute("id","datosCampos" );
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
      ((Element)v.get(154)).setAttribute("nombre","lblSubaccesoXX" );
      ((Element)v.get(154)).setAttribute("alto","13" );
      ((Element)v.get(154)).setAttribute("filas","1" );
      ((Element)v.get(154)).setAttribute("valor","" );
      ((Element)v.get(154)).setAttribute("id","datosCampos" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","25" );
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(146)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(158)).setAttribute("nombre","lblNumeroSolicitudXX" );
      ((Element)v.get(158)).setAttribute("alto","13" );
      ((Element)v.get(158)).setAttribute("filas","1" );
      ((Element)v.get(158)).setAttribute("valor","" );
      ((Element)v.get(158)).setAttribute("id","datosCampos" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 146   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).setAttribute("width","100%" );
      ((Element)v.get(146)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(160)).setAttribute("width","8" );
      ((Element)v.get(160)).setAttribute("height","8" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */
      /* Termina nodo:146   */

      /* Empieza nodo:161 / Elemento padre: 127   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(127)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("td"));
      ((Element)v.get(162)).setAttribute("colspan","3" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(163)).setAttribute("width","8" );
      ((Element)v.get(163)).setAttribute("height","7" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:164 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("table"));
      ((Element)v.get(166)).setAttribute("width","655" );
      ((Element)v.get(166)).setAttribute("border","0" );
      ((Element)v.get(166)).setAttribute("align","left" );
      ((Element)v.get(166)).setAttribute("cellspacing","0" );
      ((Element)v.get(166)).setAttribute("cellpadding","0" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(169)).setAttribute("src","b.gif" );
      ((Element)v.get(169)).setAttribute("width","8" );
      ((Element)v.get(169)).setAttribute("height","8" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(171)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(171)).setAttribute("alto","13" );
      ((Element)v.get(171)).setAttribute("filas","1" );
      ((Element)v.get(171)).setAttribute("valor","" );
      ((Element)v.get(171)).setAttribute("id","datosTitle" );
      ((Element)v.get(171)).setAttribute("cod","6" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:172 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(173)).setAttribute("src","b.gif" );
      ((Element)v.get(173)).setAttribute("width","25" );
      ((Element)v.get(173)).setAttribute("height","8" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:174 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(175)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(175)).setAttribute("alto","13" );
      ((Element)v.get(175)).setAttribute("filas","1" );
      ((Element)v.get(175)).setAttribute("valor","" );
      ((Element)v.get(175)).setAttribute("id","datosTitle" );
      ((Element)v.get(175)).setAttribute("cod","7" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(176)).setAttribute("width","100%" );
      ((Element)v.get(167)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","8" );
      ((Element)v.get(177)).setAttribute("height","8" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:167   */

      /* Empieza nodo:178 / Elemento padre: 166   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(166)).appendChild((Element)v.get(178));

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
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(182)).setAttribute("nombre","lblMarcaXX" );
      ((Element)v.get(182)).setAttribute("alto","13" );
      ((Element)v.get(182)).setAttribute("filas","1" );
      ((Element)v.get(182)).setAttribute("valor","" );
      ((Element)v.get(182)).setAttribute("id","datosCampos" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */

      /* Empieza nodo:183 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(184)).setAttribute("width","25" );
      ((Element)v.get(184)).setAttribute("height","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(186)).setAttribute("nombre","lblCanalXX" );
      ((Element)v.get(186)).setAttribute("alto","13" );
      ((Element)v.get(186)).setAttribute("filas","1" );
      ((Element)v.get(186)).setAttribute("valor","" );
      ((Element)v.get(186)).setAttribute("id","datosCampos" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 178   */
      v.add(doc.createElement("td"));
      ((Element)v.get(187)).setAttribute("width","100%" );
      ((Element)v.get(178)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
      ((Element)v.get(188)).setAttribute("width","8" );
      ((Element)v.get(188)).setAttribute("height","8" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */
      /* Termina nodo:178   */

      /* Empieza nodo:189 / Elemento padre: 166   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(166)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).setAttribute("colspan","3" );
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
      /* Termina nodo:166   */
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:192 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("td"));
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("table"));
      ((Element)v.get(194)).setAttribute("width","655" );
      ((Element)v.get(194)).setAttribute("border","0" );
      ((Element)v.get(194)).setAttribute("align","left" );
      ((Element)v.get(194)).setAttribute("cellspacing","0" );
      ((Element)v.get(194)).setAttribute("cellpadding","0" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(197)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).setAttribute("width","8" );
      ((Element)v.get(197)).setAttribute("height","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(199)).setAttribute("nombre","lblPeriodo" );
      ((Element)v.get(199)).setAttribute("alto","13" );
      ((Element)v.get(199)).setAttribute("filas","1" );
      ((Element)v.get(199)).setAttribute("valor","" );
      ((Element)v.get(199)).setAttribute("id","datosTitle" );
      ((Element)v.get(199)).setAttribute("cod","276" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).setAttribute("width","25" );
      ((Element)v.get(201)).setAttribute("height","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(203)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(203)).setAttribute("alto","13" );
      ((Element)v.get(203)).setAttribute("filas","1" );
      ((Element)v.get(203)).setAttribute("valor","" );
      ((Element)v.get(203)).setAttribute("id","datosTitle" );
      ((Element)v.get(203)).setAttribute("cod","10" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(205)).setAttribute("src","b.gif" );
      ((Element)v.get(205)).setAttribute("width","25" );
      ((Element)v.get(205)).setAttribute("height","8" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(207)).setAttribute("nombre","lblAccesoFisico" );
      ((Element)v.get(207)).setAttribute("alto","13" );
      ((Element)v.get(207)).setAttribute("filas","1" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(207)).setAttribute("valor","" );
      ((Element)v.get(207)).setAttribute("id","datosTitle" );
      ((Element)v.get(207)).setAttribute("cod","1389" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).setAttribute("width","100%" );
      ((Element)v.get(195)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","8" );
      ((Element)v.get(209)).setAttribute("height","8" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:195   */

      /* Empieza nodo:210 / Elemento padre: 194   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(194)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(212)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).setAttribute("width","8" );
      ((Element)v.get(212)).setAttribute("height","8" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */

      /* Empieza nodo:213 / Elemento padre: 210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(214)).setAttribute("nombre","lblPeriodoXX" );
      ((Element)v.get(214)).setAttribute("alto","13" );
      ((Element)v.get(214)).setAttribute("filas","1" );
      ((Element)v.get(214)).setAttribute("valor","" );
      ((Element)v.get(214)).setAttribute("id","datosCampos" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(216)).setAttribute("src","b.gif" );
      ((Element)v.get(216)).setAttribute("width","25" );
      ((Element)v.get(216)).setAttribute("height","8" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:217 / Elemento padre: 210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(218)).setAttribute("nombre","lblAccesoXX" );
      ((Element)v.get(218)).setAttribute("alto","13" );
      ((Element)v.get(218)).setAttribute("filas","1" );
      ((Element)v.get(218)).setAttribute("valor","" );
      ((Element)v.get(218)).setAttribute("id","datosCampos" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:219 / Elemento padre: 210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(210)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(220)).setAttribute("src","b.gif" );
      ((Element)v.get(220)).setAttribute("width","25" );
      ((Element)v.get(220)).setAttribute("height","8" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:221 / Elemento padre: 210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(221)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(210)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(222)).setAttribute("nombre","cbAccesoFisico" );
      ((Element)v.get(222)).setAttribute("id","datosCampos" );
      ((Element)v.get(222)).setAttribute("size","1" );
      ((Element)v.get(222)).setAttribute("multiple","N" );
      ((Element)v.get(222)).setAttribute("req","S" );
      ((Element)v.get(222)).setAttribute("valorinicial","" );
      ((Element)v.get(222)).setAttribute("textoinicial","" );
      ((Element)v.get(222)).setAttribute("ontab","tabGenerico('cbAccesoFisico');" );
      ((Element)v.get(222)).setAttribute("onshtab","tabGenerico('cbAccesoFisico','sh');" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(222)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(224)).setAttribute("ID","1" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(225)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(225)).setAttribute("TIPO","STRING" );
      ((Element)v.get(225)).setAttribute("VALOR","00" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */

      /* Empieza nodo:226 / Elemento padre: 224   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(226)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(226)).setAttribute("TIPO","STRING" );
      ((Element)v.get(226)).setAttribute("VALOR","Fax" );
      ((Element)v.get(224)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:224   */

      /* Empieza nodo:227 / Elemento padre: 223   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(227)).setAttribute("ID","2" );
      ((Element)v.get(223)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(228)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(228)).setAttribute("TIPO","STRING" );
      ((Element)v.get(228)).setAttribute("VALOR","01" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */

      /* Empieza nodo:229 / Elemento padre: 227   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(229)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(229)).setAttribute("TIPO","STRING" );
      ((Element)v.get(229)).setAttribute("VALOR","Mail" );
      ((Element)v.get(227)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:227   */

      /* Empieza nodo:230 / Elemento padre: 223   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(230)).setAttribute("ID","2" );
      ((Element)v.get(223)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(231)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(231)).setAttribute("TIPO","STRING" );
      ((Element)v.get(231)).setAttribute("VALOR","02" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */

      /* Empieza nodo:232 / Elemento padre: 230   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(232)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(232)).setAttribute("TIPO","STRING" );
      ((Element)v.get(232)).setAttribute("VALOR","Otros" );
      ((Element)v.get(230)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:230   */
      /* Termina nodo:223   */
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:233 / Elemento padre: 210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(233)).setAttribute("width","100%" );
      ((Element)v.get(210)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(234)).setAttribute("src","b.gif" );
      ((Element)v.get(234)).setAttribute("width","8" );
      ((Element)v.get(234)).setAttribute("height","8" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */
      /* Termina nodo:210   */

      /* Empieza nodo:235 / Elemento padre: 194   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(194)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).setAttribute("colspan","3" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(237)).setAttribute("src","b.gif" );
      ((Element)v.get(237)).setAttribute("width","8" );
      ((Element)v.get(237)).setAttribute("height","8" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */
      /* Termina nodo:235   */
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:238 / Elemento padre: 124   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(124)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("td"));
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("table"));
      ((Element)v.get(240)).setAttribute("width","655" );
      ((Element)v.get(240)).setAttribute("border","0" );
      ((Element)v.get(240)).setAttribute("align","left" );
      ((Element)v.get(240)).setAttribute("cellspacing","0" );
      ((Element)v.get(240)).setAttribute("cellpadding","0" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(240)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("td"));
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(243)).setAttribute("src","b.gif" );
      ((Element)v.get(243)).setAttribute("width","8" );
      ((Element)v.get(243)).setAttribute("height","8" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:244 / Elemento padre: 241   */
      v.add(doc.createElement("td"));
      ((Element)v.get(241)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(245)).setAttribute("nombre","lblTipoDespacho" );
      ((Element)v.get(245)).setAttribute("alto","13" );
      ((Element)v.get(245)).setAttribute("filas","1" );
      ((Element)v.get(245)).setAttribute("valor","" );
      ((Element)v.get(245)).setAttribute("id","datosTitle" );
      ((Element)v.get(245)).setAttribute("cod","1000" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:246 / Elemento padre: 241   */
      v.add(doc.createElement("td"));
      ((Element)v.get(241)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(247)).setAttribute("src","b.gif" );
      ((Element)v.get(247)).setAttribute("width","25" );
      ((Element)v.get(247)).setAttribute("height","8" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:248 / Elemento padre: 241   */
      v.add(doc.createElement("td"));
      ((Element)v.get(241)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(249)).setAttribute("nombre","lblSociedadVentas" );
      ((Element)v.get(249)).setAttribute("alto","13" );
      ((Element)v.get(249)).setAttribute("filas","1" );
      ((Element)v.get(249)).setAttribute("valor","" );
      ((Element)v.get(249)).setAttribute("id","datosTitle" );
      ((Element)v.get(249)).setAttribute("cod","2014" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:250 / Elemento padre: 241   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).setAttribute("width","100%" );
      ((Element)v.get(241)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(251)).setAttribute("src","b.gif" );
      ((Element)v.get(251)).setAttribute("height","8" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */
      /* Termina nodo:241   */

      /* Empieza nodo:252 / Elemento padre: 240   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(240)).appendChild((Element)v.get(252));

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
      ((Element)v.get(256)).setAttribute("nombre","cbTipoDespacho" );
      ((Element)v.get(256)).setAttribute("id","datosCampos" );
      ((Element)v.get(256)).setAttribute("size","1" );
      ((Element)v.get(256)).setAttribute("multiple","N" );
      ((Element)v.get(256)).setAttribute("req","S" );
      ((Element)v.get(256)).setAttribute("valorinicial","" );
      ((Element)v.get(256)).setAttribute("textoinicial","" );
      ((Element)v.get(256)).setAttribute("ontab","tabGenerico('cbTipoDespacho');" );
      ((Element)v.get(256)).setAttribute("onshtab","tabGenerico('cbTipoDespacho','sh');" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:258 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(252)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(259)).setAttribute("src","b.gif" );
      ((Element)v.get(259)).setAttribute("width","25" );
      ((Element)v.get(259)).setAttribute("height","8" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:260 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(252)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(261)).setAttribute("nombre","lblSociedadVentasXX" );
      ((Element)v.get(261)).setAttribute("alto","13" );
      ((Element)v.get(261)).setAttribute("filas","1" );
      ((Element)v.get(261)).setAttribute("valor","" );
      ((Element)v.get(261)).setAttribute("id","datosCampos" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:262 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(262)).setAttribute("width","100%" );
      ((Element)v.get(252)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(263)).setAttribute("src","b.gif" );
      ((Element)v.get(263)).setAttribute("width","8" );
      ((Element)v.get(263)).setAttribute("height","8" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */
      /* Termina nodo:252   */

      /* Empieza nodo:264 / Elemento padre: 240   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(240)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).setAttribute("colspan","3" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(266)).setAttribute("src","b.gif" );
      ((Element)v.get(266)).setAttribute("width","8" );
      ((Element)v.get(266)).setAttribute("height","8" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */
      /* Termina nodo:264   */
      /* Termina nodo:240   */
      /* Termina nodo:239   */
      /* Termina nodo:238   */
      /* Termina nodo:124   */
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:267 / Elemento padre: 117   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(268)).setAttribute("src","b.gif" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */
      /* Termina nodo:117   */

      /* Empieza nodo:269 / Elemento padre: 109   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(109)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */

      /* Empieza nodo:272 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(269)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("table"));
      ((Element)v.get(274)).setAttribute("width","100%" );
      ((Element)v.get(274)).setAttribute("border","0" );
      ((Element)v.get(274)).setAttribute("align","center" );
      ((Element)v.get(274)).setAttribute("cellspacing","0" );
      ((Element)v.get(274)).setAttribute("cellpadding","0" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(274)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(276)).setAttribute("class","botonera" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(277)).setAttribute("nombre","btnVisualizarPosicion" );
      ((Element)v.get(277)).setAttribute("ID","botonContenido" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(277)).setAttribute("tipo","html" );
      ((Element)v.get(277)).setAttribute("accion","accionVisualizarPosiciones();" );
      ((Element)v.get(277)).setAttribute("estado","false" );
      ((Element)v.get(277)).setAttribute("cod","2762" );
      ((Element)v.get(277)).setAttribute("ontab","tabGenerico('btnVisualizarPosicion');" );
      ((Element)v.get(277)).setAttribute("onshtab","tabGenerico('btnVisualizarPosicion','sh');" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */

      /* Empieza nodo:278 / Elemento padre: 276   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(278)).setAttribute("nombre","btnModificarPosicion" );
      ((Element)v.get(278)).setAttribute("ID","botonContenido" );
      ((Element)v.get(278)).setAttribute("tipo","html" );
      ((Element)v.get(278)).setAttribute("accion","accionModificarPosiciones();" );
      ((Element)v.get(278)).setAttribute("estado","false" );
      ((Element)v.get(278)).setAttribute("cod","2763" );
      ((Element)v.get(278)).setAttribute("ontab","tabGenerico('btnModificarPosicion');" );
      ((Element)v.get(278)).setAttribute("onshtab","tabGenerico('btnModificarPosicion','sh');" );
      ((Element)v.get(276)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:276   */
      /* Termina nodo:275   */
      /* Termina nodo:274   */
      /* Termina nodo:273   */
      /* Termina nodo:272   */

      /* Empieza nodo:279 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(269)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(280)).setAttribute("src","b.gif" );
      ((Element)v.get(280)).setAttribute("width","8" );
      ((Element)v.get(280)).setAttribute("height","12" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */
      /* Termina nodo:269   */

      /* Empieza nodo:281 / Elemento padre: 109   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(109)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(282)).setAttribute("width","12" );
      ((Element)v.get(282)).setAttribute("align","center" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(283)).setAttribute("src","b.gif" );
      ((Element)v.get(283)).setAttribute("width","12" );
      ((Element)v.get(283)).setAttribute("height","12" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:284 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(284)).setAttribute("width","756" );
      ((Element)v.get(281)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(285)).setAttribute("src","b.gif" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */

      /* Empieza nodo:286 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).setAttribute("width","12" );
      ((Element)v.get(281)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(287)).setAttribute("src","b.gif" );
      ((Element)v.get(287)).setAttribute("width","12" );
      ((Element)v.get(287)).setAttribute("height","1" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:286   */
      /* Termina nodo:281   */
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:288 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(288)).setAttribute("nombre","capa2" );
      ((Element)v.get(288)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(13)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("table"));
      ((Element)v.get(289)).setAttribute("width","100%" );
      ((Element)v.get(289)).setAttribute("border","0" );
      ((Element)v.get(289)).setAttribute("cellspacing","0" );
      ((Element)v.get(289)).setAttribute("cellpadding","0" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(289)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("td"));
      ((Element)v.get(291)).setAttribute("width","12" );
      ((Element)v.get(291)).setAttribute("align","center" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(292)).setAttribute("src","b.gif" );
      ((Element)v.get(292)).setAttribute("width","12" );
      ((Element)v.get(292)).setAttribute("height","12" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:291   */

      /* Empieza nodo:293 / Elemento padre: 290   */
      v.add(doc.createElement("td"));
      ((Element)v.get(293)).setAttribute("width","750" );
      ((Element)v.get(290)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(294)).setAttribute("src","b.gif" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:293   */

      /* Empieza nodo:295 / Elemento padre: 290   */
      v.add(doc.createElement("td"));
      ((Element)v.get(295)).setAttribute("width","12" );
      ((Element)v.get(290)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(296)).setAttribute("src","b.gif" );
      ((Element)v.get(296)).setAttribute("width","12" );
      ((Element)v.get(296)).setAttribute("height","1" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */
      /* Termina nodo:290   */

      /* Empieza nodo:297 / Elemento padre: 289   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(289)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("td"));
      ((Element)v.get(297)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(299)).setAttribute("src","b.gif" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */

      /* Empieza nodo:300 / Elemento padre: 297   */
      v.add(doc.createElement("td"));
      ((Element)v.get(297)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(300)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(302)).setAttribute("class","legend" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(303)).setAttribute("nombre","lblInformacionCliente" );
      ((Element)v.get(303)).setAttribute("alto","13" );
      ((Element)v.get(303)).setAttribute("filas","1" );
      ((Element)v.get(303)).setAttribute("valor","" );
      ((Element)v.get(303)).setAttribute("id","legend" );
      ((Element)v.get(303)).setAttribute("cod","00183" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:302   */

      /* Empieza nodo:304 / Elemento padre: 301   */
      v.add(doc.createElement("table"));
      ((Element)v.get(304)).setAttribute("width","100%" );
      ((Element)v.get(304)).setAttribute("border","0" );
      ((Element)v.get(304)).setAttribute("align","center" );
      ((Element)v.get(304)).setAttribute("cellspacing","0" );
      ((Element)v.get(304)).setAttribute("cellpadding","0" );
      ((Element)v.get(301)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(304)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("td"));
      ((Element)v.get(305)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("table"));
      ((Element)v.get(307)).setAttribute("width","655" );
      ((Element)v.get(307)).setAttribute("border","0" );
      ((Element)v.get(307)).setAttribute("align","left" );
      ((Element)v.get(307)).setAttribute("cellspacing","0" );
      ((Element)v.get(307)).setAttribute("cellpadding","0" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(307)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("td"));
      ((Element)v.get(309)).setAttribute("colspan","3" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(310)).setAttribute("src","b.gif" );
      ((Element)v.get(310)).setAttribute("width","8" );
      ((Element)v.get(310)).setAttribute("height","8" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */
      /* Termina nodo:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:311 / Elemento padre: 307   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(307)).appendChild((Element)v.get(311));

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
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(315)).setAttribute("nombre","lblCodigoCliente" );
      ((Element)v.get(315)).setAttribute("alto","13" );
      ((Element)v.get(315)).setAttribute("filas","1" );
      ((Element)v.get(315)).setAttribute("valor","" );
      ((Element)v.get(315)).setAttribute("id","datosTitle" );
      ((Element)v.get(315)).setAttribute("cod","263" );
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
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(319)).setAttribute("nombre","lblNombre" );
      ((Element)v.get(319)).setAttribute("alto","13" );
      ((Element)v.get(319)).setAttribute("filas","1" );
      ((Element)v.get(319)).setAttribute("valor","" );
      ((Element)v.get(319)).setAttribute("id","datosTitle" );
      ((Element)v.get(319)).setAttribute("cod","1039" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */
      /* Termina nodo:318   */

      /* Empieza nodo:320 / Elemento padre: 311   */
      v.add(doc.createElement("td"));
      ((Element)v.get(311)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
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
      v.add(doc.createElement("LABELC"));
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(323)).setAttribute("nombre","lblApellidos" );
      ((Element)v.get(323)).setAttribute("alto","13" );
      ((Element)v.get(323)).setAttribute("filas","1" );
      ((Element)v.get(323)).setAttribute("valor","" );
      ((Element)v.get(323)).setAttribute("id","datosTitle" );
      ((Element)v.get(323)).setAttribute("cod","1141" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:324 / Elemento padre: 311   */
      v.add(doc.createElement("td"));
      ((Element)v.get(324)).setAttribute("width","100%" );
      ((Element)v.get(311)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(325)).setAttribute("src","b.gif" );
      ((Element)v.get(325)).setAttribute("width","8" );
      ((Element)v.get(325)).setAttribute("height","8" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */
      /* Termina nodo:311   */

      /* Empieza nodo:326 / Elemento padre: 307   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(307)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(328)).setAttribute("src","b.gif" );
      ((Element)v.get(328)).setAttribute("width","8" );
      ((Element)v.get(328)).setAttribute("height","8" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:327   */

      /* Empieza nodo:329 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(330)).setAttribute("nombre","lblCodigoClienteXX" );
      ((Element)v.get(330)).setAttribute("alto","13" );
      ((Element)v.get(330)).setAttribute("filas","1" );
      ((Element)v.get(330)).setAttribute("valor","" );
      ((Element)v.get(330)).setAttribute("id","datosCampos" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:331 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(332)).setAttribute("src","b.gif" );
      ((Element)v.get(332)).setAttribute("width","25" );
      ((Element)v.get(332)).setAttribute("height","8" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:331   */

      /* Empieza nodo:333 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(334)).setAttribute("nombre","lblNombreXX" );
      ((Element)v.get(334)).setAttribute("alto","13" );
      ((Element)v.get(334)).setAttribute("filas","1" );
      ((Element)v.get(334)).setAttribute("valor","" );
      ((Element)v.get(334)).setAttribute("id","datosCampos" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:335 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(336)).setAttribute("src","b.gif" );
      ((Element)v.get(336)).setAttribute("width","25" );
      ((Element)v.get(336)).setAttribute("height","8" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(338)).setAttribute("nombre","lblApellidosXX" );
      ((Element)v.get(338)).setAttribute("alto","13" );
      ((Element)v.get(338)).setAttribute("filas","1" );
      ((Element)v.get(338)).setAttribute("valor","" );
      ((Element)v.get(338)).setAttribute("id","datosCampos" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:339 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).setAttribute("width","100%" );
      ((Element)v.get(326)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(340)).setAttribute("src","b.gif" );
      ((Element)v.get(340)).setAttribute("width","8" );
      ((Element)v.get(340)).setAttribute("height","8" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */
      /* Termina nodo:326   */

      /* Empieza nodo:341 / Elemento padre: 307   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(307)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(342)).setAttribute("colspan","3" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(343)).setAttribute("src","b.gif" );
      ((Element)v.get(343)).setAttribute("width","8" );
      ((Element)v.get(343)).setAttribute("height","7" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */
      /* Termina nodo:342   */
      /* Termina nodo:341   */
      /* Termina nodo:307   */
      /* Termina nodo:306   */
      /* Termina nodo:305   */

      /* Empieza nodo:344 / Elemento padre: 304   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(304)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("td"));
      ((Element)v.get(344)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("table"));
      ((Element)v.get(346)).setAttribute("width","655" );
      ((Element)v.get(346)).setAttribute("border","0" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(346)).setAttribute("align","left" );
      ((Element)v.get(346)).setAttribute("cellspacing","0" );
      ((Element)v.get(346)).setAttribute("cellpadding","0" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(346)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("td"));
      ((Element)v.get(347)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(349)).setAttribute("src","b.gif" );
      ((Element)v.get(349)).setAttribute("width","8" );
      ((Element)v.get(349)).setAttribute("height","8" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */
      /* Termina nodo:348   */

      /* Empieza nodo:350 / Elemento padre: 347   */
      v.add(doc.createElement("td"));
      ((Element)v.get(347)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(351)).setAttribute("nombre","lblTipoCliente" );
      ((Element)v.get(351)).setAttribute("alto","13" );
      ((Element)v.get(351)).setAttribute("filas","1" );
      ((Element)v.get(351)).setAttribute("valor","" );
      ((Element)v.get(351)).setAttribute("id","datosTitle" );
      ((Element)v.get(351)).setAttribute("cod","393" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */
      /* Termina nodo:350   */

      /* Empieza nodo:352 / Elemento padre: 347   */
      v.add(doc.createElement("td"));
      ((Element)v.get(347)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(353)).setAttribute("src","b.gif" );
      ((Element)v.get(353)).setAttribute("width","25" );
      ((Element)v.get(353)).setAttribute("height","8" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */
      /* Termina nodo:352   */

      /* Empieza nodo:354 / Elemento padre: 347   */
      v.add(doc.createElement("td"));
      ((Element)v.get(347)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(355)).setAttribute("nombre","lblSubTipoCliente" );
      ((Element)v.get(355)).setAttribute("alto","13" );
      ((Element)v.get(355)).setAttribute("filas","1" );
      ((Element)v.get(355)).setAttribute("valor","" );
      ((Element)v.get(355)).setAttribute("id","datosTitle" );
      ((Element)v.get(355)).setAttribute("cod","595" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */
      /* Termina nodo:354   */

      /* Empieza nodo:356 / Elemento padre: 347   */
      v.add(doc.createElement("td"));
      ((Element)v.get(356)).setAttribute("width","100%" );
      ((Element)v.get(347)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(357)).setAttribute("src","b.gif" );
      ((Element)v.get(357)).setAttribute("width","8" );
      ((Element)v.get(357)).setAttribute("height","8" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */
      /* Termina nodo:347   */

      /* Empieza nodo:358 / Elemento padre: 346   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(346)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("td"));
      ((Element)v.get(358)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(360)).setAttribute("src","b.gif" );
      ((Element)v.get(360)).setAttribute("width","8" );
      ((Element)v.get(360)).setAttribute("height","8" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:359   */

      /* Empieza nodo:361 / Elemento padre: 358   */
      v.add(doc.createElement("td"));
      ((Element)v.get(358)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(362)).setAttribute("nombre","lblTipoClienteXX" );
      ((Element)v.get(362)).setAttribute("alto","13" );
      ((Element)v.get(362)).setAttribute("filas","1" );
      ((Element)v.get(362)).setAttribute("valor","" );
      ((Element)v.get(362)).setAttribute("id","datosCampos" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:361   */

      /* Empieza nodo:363 / Elemento padre: 358   */
      v.add(doc.createElement("td"));
      ((Element)v.get(358)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(364)).setAttribute("src","b.gif" );
      ((Element)v.get(364)).setAttribute("width","25" );
      ((Element)v.get(364)).setAttribute("height","8" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */
      /* Termina nodo:363   */

      /* Empieza nodo:365 / Elemento padre: 358   */
      v.add(doc.createElement("td"));
      ((Element)v.get(358)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(366)).setAttribute("nombre","lblSubTipoClienteXX" );
      ((Element)v.get(366)).setAttribute("alto","13" );
      ((Element)v.get(366)).setAttribute("filas","1" );
      ((Element)v.get(366)).setAttribute("valor","" );
      ((Element)v.get(366)).setAttribute("id","datosCampos" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */
      /* Termina nodo:365   */

      /* Empieza nodo:367 / Elemento padre: 358   */
      v.add(doc.createElement("td"));
      ((Element)v.get(367)).setAttribute("width","100%" );
      ((Element)v.get(358)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(368)).setAttribute("src","b.gif" );
      ((Element)v.get(368)).setAttribute("width","8" );
      ((Element)v.get(368)).setAttribute("height","8" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */
      /* Termina nodo:367   */
      /* Termina nodo:358   */

      /* Empieza nodo:369 / Elemento padre: 346   */
   }

   private void getXML1530(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(346)).appendChild((Element)v.get(369));

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
      /* Termina nodo:346   */
      /* Termina nodo:345   */
      /* Termina nodo:344   */

      /* Empieza nodo:372 / Elemento padre: 304   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(304)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("td"));
      ((Element)v.get(372)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("table"));
      ((Element)v.get(374)).setAttribute("width","655" );
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
      ((Element)v.get(379)).setAttribute("nombre","lblSubgerenciaVentas" );
      ((Element)v.get(379)).setAttribute("alto","13" );
      ((Element)v.get(379)).setAttribute("filas","1" );
      ((Element)v.get(379)).setAttribute("valor","" );
      ((Element)v.get(379)).setAttribute("id","datosTitle" );
      ((Element)v.get(379)).setAttribute("cod","124" );
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
      ((Element)v.get(383)).setAttribute("nombre","lblRegion" );
      ((Element)v.get(383)).setAttribute("alto","13" );
      ((Element)v.get(383)).setAttribute("filas","1" );
      ((Element)v.get(383)).setAttribute("valor","" );
      ((Element)v.get(383)).setAttribute("id","datosTitle" );
      ((Element)v.get(383)).setAttribute("cod","109" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */
      /* Termina nodo:382   */

      /* Empieza nodo:384 / Elemento padre: 375   */
      v.add(doc.createElement("td"));
      ((Element)v.get(384)).setAttribute("width","100%" );
      ((Element)v.get(375)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(385)).setAttribute("src","b.gif" );
      ((Element)v.get(385)).setAttribute("width","8" );
      ((Element)v.get(385)).setAttribute("height","8" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */
      /* Termina nodo:384   */
      /* Termina nodo:375   */

      /* Empieza nodo:386 / Elemento padre: 374   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(374)).appendChild((Element)v.get(386));

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
      ((Element)v.get(390)).setAttribute("nombre","lblSubgerenciaVentasXX" );
      ((Element)v.get(390)).setAttribute("alto","13" );
      ((Element)v.get(390)).setAttribute("filas","1" );
      ((Element)v.get(390)).setAttribute("valor","" );
      ((Element)v.get(390)).setAttribute("id","datosCampos" );
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
   }

   private void getXML1620(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(394)).setAttribute("nombre","lblRegionXX" );
      ((Element)v.get(394)).setAttribute("alto","13" );
      ((Element)v.get(394)).setAttribute("filas","1" );
      ((Element)v.get(394)).setAttribute("valor","" );
      ((Element)v.get(394)).setAttribute("id","datosCampos" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */
      /* Termina nodo:393   */

      /* Empieza nodo:395 / Elemento padre: 386   */
      v.add(doc.createElement("td"));
      ((Element)v.get(395)).setAttribute("width","100%" );
      ((Element)v.get(386)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(396)).setAttribute("src","b.gif" );
      ((Element)v.get(396)).setAttribute("width","8" );
      ((Element)v.get(396)).setAttribute("height","8" );
      ((Element)v.get(395)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */
      /* Termina nodo:395   */
      /* Termina nodo:386   */

      /* Empieza nodo:397 / Elemento padre: 374   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(374)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("td"));
      ((Element)v.get(398)).setAttribute("colspan","3" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(399)).setAttribute("src","b.gif" );
      ((Element)v.get(399)).setAttribute("width","8" );
      ((Element)v.get(399)).setAttribute("height","8" );
      ((Element)v.get(398)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */
      /* Termina nodo:398   */
      /* Termina nodo:397   */
      /* Termina nodo:374   */
      /* Termina nodo:373   */
      /* Termina nodo:372   */

      /* Empieza nodo:400 / Elemento padre: 304   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(304)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("td"));
      ((Element)v.get(400)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("table"));
      ((Element)v.get(402)).setAttribute("width","655" );
      ((Element)v.get(402)).setAttribute("border","0" );
      ((Element)v.get(402)).setAttribute("align","left" );
      ((Element)v.get(402)).setAttribute("cellspacing","0" );
      ((Element)v.get(402)).setAttribute("cellpadding","0" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(402)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("td"));
      ((Element)v.get(403)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(405)).setAttribute("src","b.gif" );
      ((Element)v.get(405)).setAttribute("width","8" );
      ((Element)v.get(405)).setAttribute("height","8" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */
      /* Termina nodo:404   */

      /* Empieza nodo:406 / Elemento padre: 403   */
      v.add(doc.createElement("td"));
      ((Element)v.get(403)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(407)).setAttribute("nombre","lblZona" );
      ((Element)v.get(407)).setAttribute("alto","13" );
      ((Element)v.get(407)).setAttribute("filas","1" );
      ((Element)v.get(407)).setAttribute("valor","" );
      ((Element)v.get(407)).setAttribute("id","datosTitle" );
      ((Element)v.get(407)).setAttribute("cod","143" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */
      /* Termina nodo:406   */

      /* Empieza nodo:408 / Elemento padre: 403   */
      v.add(doc.createElement("td"));
      ((Element)v.get(403)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(409)).setAttribute("src","b.gif" );
      ((Element)v.get(409)).setAttribute("width","25" );
      ((Element)v.get(409)).setAttribute("height","8" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));
      /* Termina nodo:409   */
      /* Termina nodo:408   */

      /* Empieza nodo:410 / Elemento padre: 403   */
      v.add(doc.createElement("td"));
      ((Element)v.get(403)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(411)).setAttribute("nombre","lblSeccion" );
      ((Element)v.get(411)).setAttribute("alto","13" );
      ((Element)v.get(411)).setAttribute("filas","1" );
      ((Element)v.get(411)).setAttribute("valor","" );
      ((Element)v.get(411)).setAttribute("id","datosTitle" );
      ((Element)v.get(411)).setAttribute("cod","112" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */
      /* Termina nodo:410   */

      /* Empieza nodo:412 / Elemento padre: 403   */
      v.add(doc.createElement("td"));
      ((Element)v.get(412)).setAttribute("width","100%" );
      ((Element)v.get(403)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(413)).setAttribute("src","b.gif" );
      ((Element)v.get(413)).setAttribute("width","8" );
      ((Element)v.get(413)).setAttribute("height","8" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */
      /* Termina nodo:412   */
      /* Termina nodo:403   */

      /* Empieza nodo:414 / Elemento padre: 402   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(402)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("td"));
      ((Element)v.get(414)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(416)).setAttribute("src","b.gif" );
      ((Element)v.get(416)).setAttribute("width","8" );
      ((Element)v.get(416)).setAttribute("height","8" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(415)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */
      /* Termina nodo:415   */

      /* Empieza nodo:417 / Elemento padre: 414   */
      v.add(doc.createElement("td"));
      ((Element)v.get(414)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(418)).setAttribute("nombre","lblZonaXX" );
      ((Element)v.get(418)).setAttribute("alto","13" );
      ((Element)v.get(418)).setAttribute("filas","1" );
      ((Element)v.get(418)).setAttribute("valor","" );
      ((Element)v.get(418)).setAttribute("id","datosCampos" );
      ((Element)v.get(417)).appendChild((Element)v.get(418));
      /* Termina nodo:418   */
      /* Termina nodo:417   */

      /* Empieza nodo:419 / Elemento padre: 414   */
      v.add(doc.createElement("td"));
      ((Element)v.get(414)).appendChild((Element)v.get(419));

      /* Empieza nodo:420 / Elemento padre: 419   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(420)).setAttribute("src","b.gif" );
      ((Element)v.get(420)).setAttribute("width","25" );
      ((Element)v.get(420)).setAttribute("height","8" );
      ((Element)v.get(419)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */
      /* Termina nodo:419   */

      /* Empieza nodo:421 / Elemento padre: 414   */
      v.add(doc.createElement("td"));
      ((Element)v.get(414)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(422)).setAttribute("nombre","lblSeccionXX" );
      ((Element)v.get(422)).setAttribute("alto","13" );
      ((Element)v.get(422)).setAttribute("filas","1" );
      ((Element)v.get(422)).setAttribute("valor","" );
      ((Element)v.get(422)).setAttribute("id","datosCampos" );
      ((Element)v.get(421)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */
      /* Termina nodo:421   */

      /* Empieza nodo:423 / Elemento padre: 414   */
      v.add(doc.createElement("td"));
      ((Element)v.get(423)).setAttribute("width","100%" );
      ((Element)v.get(414)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(424)).setAttribute("src","b.gif" );
      ((Element)v.get(424)).setAttribute("width","8" );
      ((Element)v.get(424)).setAttribute("height","8" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */
      /* Termina nodo:423   */
      /* Termina nodo:414   */

      /* Empieza nodo:425 / Elemento padre: 402   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(402)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("td"));
      ((Element)v.get(426)).setAttribute("colspan","3" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(427)).setAttribute("src","b.gif" );
      ((Element)v.get(427)).setAttribute("width","8" );
      ((Element)v.get(427)).setAttribute("height","8" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */
      /* Termina nodo:426   */
      /* Termina nodo:425   */
      /* Termina nodo:402   */
      /* Termina nodo:401   */
      /* Termina nodo:400   */

      /* Empieza nodo:428 / Elemento padre: 304   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(304)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("td"));
      ((Element)v.get(428)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("table"));
      ((Element)v.get(430)).setAttribute("width","655" );
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
      ((Element)v.get(435)).setAttribute("nombre","lblTerritorio" );
      ((Element)v.get(435)).setAttribute("alto","13" );
      ((Element)v.get(435)).setAttribute("filas","1" );
      ((Element)v.get(435)).setAttribute("valor","" );
      ((Element)v.get(435)).setAttribute("id","datosTitle" );
      ((Element)v.get(435)).setAttribute("cod","126" );
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
      ((Element)v.get(439)).setAttribute("nombre","lblUbigeo" );
      ((Element)v.get(439)).setAttribute("alto","13" );
      ((Element)v.get(439)).setAttribute("filas","1" );
      ((Element)v.get(439)).setAttribute("valor","" );
      ((Element)v.get(439)).setAttribute("id","datosTitle" );
      ((Element)v.get(439)).setAttribute("cod","135" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(438)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */
      /* Termina nodo:438   */

      /* Empieza nodo:440 / Elemento padre: 431   */
      v.add(doc.createElement("td"));
      ((Element)v.get(440)).setAttribute("width","100%" );
      ((Element)v.get(431)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(441)).setAttribute("src","b.gif" );
      ((Element)v.get(441)).setAttribute("width","8" );
      ((Element)v.get(441)).setAttribute("height","8" );
      ((Element)v.get(440)).appendChild((Element)v.get(441));
      /* Termina nodo:441   */
      /* Termina nodo:440   */
      /* Termina nodo:431   */

      /* Empieza nodo:442 / Elemento padre: 430   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(430)).appendChild((Element)v.get(442));

      /* Empieza nodo:443 / Elemento padre: 442   */
      v.add(doc.createElement("td"));
      ((Element)v.get(442)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(444)).setAttribute("src","b.gif" );
      ((Element)v.get(444)).setAttribute("width","8" );
      ((Element)v.get(444)).setAttribute("height","8" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));
      /* Termina nodo:444   */
      /* Termina nodo:443   */

      /* Empieza nodo:445 / Elemento padre: 442   */
      v.add(doc.createElement("td"));
      ((Element)v.get(442)).appendChild((Element)v.get(445));

      /* Empieza nodo:446 / Elemento padre: 445   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(446)).setAttribute("nombre","lblTerritorioXX" );
      ((Element)v.get(446)).setAttribute("alto","13" );
      ((Element)v.get(446)).setAttribute("filas","1" );
      ((Element)v.get(446)).setAttribute("valor","" );
      ((Element)v.get(446)).setAttribute("id","datosCampos" );
      ((Element)v.get(445)).appendChild((Element)v.get(446));
      /* Termina nodo:446   */
      /* Termina nodo:445   */

      /* Empieza nodo:447 / Elemento padre: 442   */
      v.add(doc.createElement("td"));
      ((Element)v.get(442)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(448)).setAttribute("src","b.gif" );
      ((Element)v.get(448)).setAttribute("width","25" );
      ((Element)v.get(448)).setAttribute("height","8" );
      ((Element)v.get(447)).appendChild((Element)v.get(448));
      /* Termina nodo:448   */
      /* Termina nodo:447   */

      /* Empieza nodo:449 / Elemento padre: 442   */
      v.add(doc.createElement("td"));
      ((Element)v.get(442)).appendChild((Element)v.get(449));

      /* Empieza nodo:450 / Elemento padre: 449   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(450)).setAttribute("nombre","lblUbigeoXX" );
      ((Element)v.get(450)).setAttribute("alto","13" );
      ((Element)v.get(450)).setAttribute("filas","1" );
      ((Element)v.get(450)).setAttribute("valor","" );
      ((Element)v.get(450)).setAttribute("id","datosCampos" );
      ((Element)v.get(449)).appendChild((Element)v.get(450));
      /* Termina nodo:450   */
      /* Termina nodo:449   */

      /* Empieza nodo:451 / Elemento padre: 442   */
      v.add(doc.createElement("td"));
      ((Element)v.get(451)).setAttribute("width","100%" );
      ((Element)v.get(442)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(452)).setAttribute("src","b.gif" );
      ((Element)v.get(452)).setAttribute("width","8" );
      ((Element)v.get(452)).setAttribute("height","8" );
      ((Element)v.get(451)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */
      /* Termina nodo:451   */
      /* Termina nodo:442   */

      /* Empieza nodo:453 / Elemento padre: 430   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(430)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("td"));
      ((Element)v.get(454)).setAttribute("colspan","3" );
      ((Element)v.get(453)).appendChild((Element)v.get(454));

      /* Empieza nodo:455 / Elemento padre: 454   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(455)).setAttribute("src","b.gif" );
      ((Element)v.get(455)).setAttribute("width","8" );
      ((Element)v.get(455)).setAttribute("height","8" );
      ((Element)v.get(454)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */
      /* Termina nodo:454   */
      /* Termina nodo:453   */
      /* Termina nodo:430   */
      /* Termina nodo:429   */
      /* Termina nodo:428   */
      /* Termina nodo:304   */
      /* Termina nodo:301   */
      /* Termina nodo:300   */

      /* Empieza nodo:456 / Elemento padre: 297   */
      v.add(doc.createElement("td"));
      ((Element)v.get(297)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(457)).setAttribute("src","b.gif" );
      ((Element)v.get(456)).appendChild((Element)v.get(457));
      /* Termina nodo:457   */
      /* Termina nodo:456   */
      /* Termina nodo:297   */

      /* Empieza nodo:458 / Elemento padre: 289   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(289)).appendChild((Element)v.get(458));

      /* Empieza nodo:459 / Elemento padre: 458   */
      v.add(doc.createElement("td"));
      ((Element)v.get(458)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(460)).setAttribute("src","b.gif" );
      ((Element)v.get(459)).appendChild((Element)v.get(460));
      /* Termina nodo:460   */
      /* Termina nodo:459   */

      /* Empieza nodo:461 / Elemento padre: 458   */
      v.add(doc.createElement("td"));
      ((Element)v.get(458)).appendChild((Element)v.get(461));

      /* Empieza nodo:462 / Elemento padre: 461   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(461)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("table"));
      ((Element)v.get(463)).setAttribute("width","100%" );
      ((Element)v.get(463)).setAttribute("border","0" );
      ((Element)v.get(463)).setAttribute("align","center" );
      ((Element)v.get(463)).setAttribute("cellspacing","0" );
      ((Element)v.get(463)).setAttribute("cellpadding","0" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));

      /* Empieza nodo:464 / Elemento padre: 463   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(463)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("td"));
      ((Element)v.get(465)).setAttribute("class","botonera" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("BOTON"));
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(466)).setAttribute("nombre","btnVisualizarPosicion2" );
      ((Element)v.get(466)).setAttribute("ID","botonContenido" );
      ((Element)v.get(466)).setAttribute("tipo","html" );
      ((Element)v.get(466)).setAttribute("accion","accionVisualizarPosiciones();" );
      ((Element)v.get(466)).setAttribute("estado","false" );
      ((Element)v.get(466)).setAttribute("cod","2762" );
      ((Element)v.get(466)).setAttribute("ontab","tabGenerico('btnVisualizarPosicion2');" );
      ((Element)v.get(466)).setAttribute("onshtab","tabGenerico('btnVisualizarPosicion2','sh');" );
      ((Element)v.get(465)).appendChild((Element)v.get(466));
      /* Termina nodo:466   */

      /* Empieza nodo:467 / Elemento padre: 465   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(467)).setAttribute("nombre","btnModificarPosicion2" );
      ((Element)v.get(467)).setAttribute("ID","botonContenido" );
      ((Element)v.get(467)).setAttribute("tipo","html" );
      ((Element)v.get(467)).setAttribute("accion","accionModificarPosiciones();" );
      ((Element)v.get(467)).setAttribute("estado","false" );
      ((Element)v.get(467)).setAttribute("cod","2763" );
      ((Element)v.get(467)).setAttribute("ontab","tabGenerico('btnModificarPosicion2');" );
      ((Element)v.get(467)).setAttribute("onshtab","tabGenerico('btnModificarPosicion2','sh');" );
      ((Element)v.get(465)).appendChild((Element)v.get(467));
      /* Termina nodo:467   */
      /* Termina nodo:465   */
      /* Termina nodo:464   */
      /* Termina nodo:463   */
      /* Termina nodo:462   */
      /* Termina nodo:461   */

      /* Empieza nodo:468 / Elemento padre: 458   */
      v.add(doc.createElement("td"));
      ((Element)v.get(458)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(469)).setAttribute("src","b.gif" );
      ((Element)v.get(469)).setAttribute("width","8" );
      ((Element)v.get(469)).setAttribute("height","12" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));
      /* Termina nodo:469   */
      /* Termina nodo:468   */
      /* Termina nodo:458   */

      /* Empieza nodo:470 / Elemento padre: 289   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(289)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("td"));
      ((Element)v.get(471)).setAttribute("width","12" );
      ((Element)v.get(471)).setAttribute("align","center" );
      ((Element)v.get(470)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(472)).setAttribute("src","b.gif" );
      ((Element)v.get(472)).setAttribute("width","12" );
      ((Element)v.get(472)).setAttribute("height","12" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));
      /* Termina nodo:472   */
      /* Termina nodo:471   */

      /* Empieza nodo:473 / Elemento padre: 470   */
      v.add(doc.createElement("td"));
      ((Element)v.get(473)).setAttribute("width","756" );
      ((Element)v.get(470)).appendChild((Element)v.get(473));

      /* Empieza nodo:474 / Elemento padre: 473   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(474)).setAttribute("src","b.gif" );
      ((Element)v.get(473)).appendChild((Element)v.get(474));
      /* Termina nodo:474   */
      /* Termina nodo:473   */

      /* Empieza nodo:475 / Elemento padre: 470   */
      v.add(doc.createElement("td"));
      ((Element)v.get(475)).setAttribute("width","12" );
      ((Element)v.get(470)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(476)).setAttribute("src","b.gif" );
      ((Element)v.get(476)).setAttribute("width","12" );
      ((Element)v.get(476)).setAttribute("height","1" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */
      /* Termina nodo:475   */
      /* Termina nodo:470   */
      /* Termina nodo:289   */
      /* Termina nodo:288   */

      /* Empieza nodo:477 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(477)).setAttribute("nombre","capa3" );
      ((Element)v.get(477)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(13)).appendChild((Element)v.get(477));

      /* Empieza nodo:478 / Elemento padre: 477   */
      v.add(doc.createElement("table"));
      ((Element)v.get(478)).setAttribute("width","100%" );
      ((Element)v.get(478)).setAttribute("border","0" );
      ((Element)v.get(478)).setAttribute("cellspacing","0" );
      ((Element)v.get(478)).setAttribute("cellpadding","0" );
      ((Element)v.get(477)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(478)).appendChild((Element)v.get(479));

      /* Empieza nodo:480 / Elemento padre: 479   */
      v.add(doc.createElement("td"));
      ((Element)v.get(480)).setAttribute("width","12" );
      ((Element)v.get(480)).setAttribute("align","center" );
      ((Element)v.get(479)).appendChild((Element)v.get(480));

      /* Empieza nodo:481 / Elemento padre: 480   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(481)).setAttribute("src","b.gif" );
      ((Element)v.get(481)).setAttribute("width","12" );
      ((Element)v.get(481)).setAttribute("height","12" );
      ((Element)v.get(480)).appendChild((Element)v.get(481));
      /* Termina nodo:481   */
      /* Termina nodo:480   */

      /* Empieza nodo:482 / Elemento padre: 479   */
      v.add(doc.createElement("td"));
      ((Element)v.get(482)).setAttribute("width","750" );
      ((Element)v.get(479)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(483)).setAttribute("src","b.gif" );
      ((Element)v.get(482)).appendChild((Element)v.get(483));
      /* Termina nodo:483   */
      /* Termina nodo:482   */

      /* Empieza nodo:484 / Elemento padre: 479   */
      v.add(doc.createElement("td"));
      ((Element)v.get(484)).setAttribute("width","12" );
      ((Element)v.get(479)).appendChild((Element)v.get(484));

      /* Empieza nodo:485 / Elemento padre: 484   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(485)).setAttribute("src","b.gif" );
      ((Element)v.get(485)).setAttribute("width","12" );
      ((Element)v.get(485)).setAttribute("height","1" );
      ((Element)v.get(484)).appendChild((Element)v.get(485));
      /* Termina nodo:485   */
      /* Termina nodo:484   */
      /* Termina nodo:479   */

      /* Empieza nodo:486 / Elemento padre: 478   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(478)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("td"));
      ((Element)v.get(486)).appendChild((Element)v.get(487));

      /* Empieza nodo:488 / Elemento padre: 487   */
   }

   private void getXML1980(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(488)).setAttribute("src","b.gif" );
      ((Element)v.get(487)).appendChild((Element)v.get(488));
      /* Termina nodo:488   */
      /* Termina nodo:487   */

      /* Empieza nodo:489 / Elemento padre: 486   */
      v.add(doc.createElement("td"));
      ((Element)v.get(486)).appendChild((Element)v.get(489));

      /* Empieza nodo:490 / Elemento padre: 489   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(489)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(491)).setAttribute("class","legend" );
      ((Element)v.get(490)).appendChild((Element)v.get(491));

      /* Empieza nodo:492 / Elemento padre: 491   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(492)).setAttribute("nombre","lblInformacionAdministrativaDocumento" );
      ((Element)v.get(492)).setAttribute("alto","13" );
      ((Element)v.get(492)).setAttribute("filas","1" );
      ((Element)v.get(492)).setAttribute("valor","" );
      ((Element)v.get(492)).setAttribute("id","legend" );
      ((Element)v.get(492)).setAttribute("cod","00573" );
      ((Element)v.get(491)).appendChild((Element)v.get(492));
      /* Termina nodo:492   */
      /* Termina nodo:491   */

      /* Empieza nodo:493 / Elemento padre: 490   */
      v.add(doc.createElement("table"));
      ((Element)v.get(493)).setAttribute("width","100%" );
      ((Element)v.get(493)).setAttribute("border","0" );
      ((Element)v.get(493)).setAttribute("align","center" );
      ((Element)v.get(493)).setAttribute("cellspacing","0" );
      ((Element)v.get(493)).setAttribute("cellpadding","0" );
      ((Element)v.get(490)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(493)).appendChild((Element)v.get(494));

      /* Empieza nodo:495 / Elemento padre: 494   */
      v.add(doc.createElement("td"));
      ((Element)v.get(494)).appendChild((Element)v.get(495));

      /* Empieza nodo:496 / Elemento padre: 495   */
      v.add(doc.createElement("table"));
      ((Element)v.get(496)).setAttribute("width","655" );
      ((Element)v.get(496)).setAttribute("border","0" );
      ((Element)v.get(496)).setAttribute("align","left" );
      ((Element)v.get(496)).setAttribute("cellspacing","0" );
      ((Element)v.get(496)).setAttribute("cellpadding","0" );
      ((Element)v.get(495)).appendChild((Element)v.get(496));

      /* Empieza nodo:497 / Elemento padre: 496   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(496)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
      v.add(doc.createElement("td"));
      ((Element)v.get(498)).setAttribute("colspan","3" );
      ((Element)v.get(497)).appendChild((Element)v.get(498));

      /* Empieza nodo:499 / Elemento padre: 498   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(499)).setAttribute("src","b.gif" );
      ((Element)v.get(499)).setAttribute("width","8" );
      ((Element)v.get(499)).setAttribute("height","8" );
      ((Element)v.get(498)).appendChild((Element)v.get(499));
      /* Termina nodo:499   */
      /* Termina nodo:498   */
      /* Termina nodo:497   */

      /* Empieza nodo:500 / Elemento padre: 496   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(496)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("td"));
      ((Element)v.get(500)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(502)).setAttribute("src","b.gif" );
      ((Element)v.get(502)).setAttribute("width","8" );
      ((Element)v.get(502)).setAttribute("height","8" );
      ((Element)v.get(501)).appendChild((Element)v.get(502));
      /* Termina nodo:502   */
      /* Termina nodo:501   */

      /* Empieza nodo:503 / Elemento padre: 500   */
      v.add(doc.createElement("td"));
      ((Element)v.get(503)).setAttribute("colspan","3" );
      ((Element)v.get(500)).appendChild((Element)v.get(503));

      /* Empieza nodo:504 / Elemento padre: 503   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(504)).setAttribute("nombre","lblConsultoraReferencia" );
      ((Element)v.get(504)).setAttribute("alto","13" );
      ((Element)v.get(504)).setAttribute("filas","1" );
      ((Element)v.get(504)).setAttribute("valor","" );
      ((Element)v.get(504)).setAttribute("id","datosTitle" );
      ((Element)v.get(504)).setAttribute("cod","1420" );
      ((Element)v.get(503)).appendChild((Element)v.get(504));
      /* Termina nodo:504   */
      /* Termina nodo:503   */

      /* Empieza nodo:505 / Elemento padre: 500   */
      v.add(doc.createElement("td"));
      ((Element)v.get(500)).appendChild((Element)v.get(505));

      /* Empieza nodo:506 / Elemento padre: 505   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(506)).setAttribute("src","b.gif" );
      ((Element)v.get(506)).setAttribute("width","25" );
      ((Element)v.get(506)).setAttribute("height","8" );
      ((Element)v.get(505)).appendChild((Element)v.get(506));
      /* Termina nodo:506   */
      /* Termina nodo:505   */

      /* Empieza nodo:507 / Elemento padre: 500   */
      v.add(doc.createElement("td"));
      ((Element)v.get(507)).setAttribute("colspan","3" );
      ((Element)v.get(500)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(508)).setAttribute("nombre","lblReceptorFactura" );
      ((Element)v.get(508)).setAttribute("alto","13" );
      ((Element)v.get(508)).setAttribute("filas","1" );
      ((Element)v.get(508)).setAttribute("valor","" );
      ((Element)v.get(508)).setAttribute("id","datosTitle" );
      ((Element)v.get(508)).setAttribute("cod","1391" );
      ((Element)v.get(507)).appendChild((Element)v.get(508));
      /* Termina nodo:508   */
      /* Termina nodo:507   */

      /* Empieza nodo:509 / Elemento padre: 500   */
      v.add(doc.createElement("td"));
      ((Element)v.get(500)).appendChild((Element)v.get(509));

      /* Empieza nodo:510 / Elemento padre: 509   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(510)).setAttribute("src","b.gif" );
      ((Element)v.get(510)).setAttribute("width","25" );
      ((Element)v.get(510)).setAttribute("height","8" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(509)).appendChild((Element)v.get(510));
      /* Termina nodo:510   */
      /* Termina nodo:509   */

      /* Empieza nodo:511 / Elemento padre: 500   */
      v.add(doc.createElement("td"));
      ((Element)v.get(511)).setAttribute("colspan","3" );
      ((Element)v.get(500)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(512)).setAttribute("nombre","lblPagadorFactura" );
      ((Element)v.get(512)).setAttribute("alto","13" );
      ((Element)v.get(512)).setAttribute("filas","1" );
      ((Element)v.get(512)).setAttribute("valor","" );
      ((Element)v.get(512)).setAttribute("id","datosTitle" );
      ((Element)v.get(512)).setAttribute("cod","2343" );
      ((Element)v.get(511)).appendChild((Element)v.get(512));
      /* Termina nodo:512   */
      /* Termina nodo:511   */

      /* Empieza nodo:513 / Elemento padre: 500   */
      v.add(doc.createElement("td"));
      ((Element)v.get(500)).appendChild((Element)v.get(513));

      /* Empieza nodo:514 / Elemento padre: 513   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(514)).setAttribute("src","b.gif" );
      ((Element)v.get(514)).setAttribute("width","25" );
      ((Element)v.get(514)).setAttribute("height","8" );
      ((Element)v.get(513)).appendChild((Element)v.get(514));
      /* Termina nodo:514   */
      /* Termina nodo:513   */

      /* Empieza nodo:515 / Elemento padre: 500   */
      v.add(doc.createElement("td"));
      ((Element)v.get(500)).appendChild((Element)v.get(515));

      /* Empieza nodo:516 / Elemento padre: 515   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(516)).setAttribute("nombre","lblNumeroClientes" );
      ((Element)v.get(516)).setAttribute("alto","13" );
      ((Element)v.get(516)).setAttribute("filas","1" );
      ((Element)v.get(516)).setAttribute("valor","" );
      ((Element)v.get(516)).setAttribute("id","datosTitle" );
      ((Element)v.get(516)).setAttribute("cod","930" );
      ((Element)v.get(515)).appendChild((Element)v.get(516));
      /* Termina nodo:516   */
      /* Termina nodo:515   */

      /* Empieza nodo:517 / Elemento padre: 500   */
      v.add(doc.createElement("td"));
      ((Element)v.get(517)).setAttribute("width","100%" );
      ((Element)v.get(500)).appendChild((Element)v.get(517));

      /* Empieza nodo:518 / Elemento padre: 517   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(518)).setAttribute("src","b.gif" );
      ((Element)v.get(518)).setAttribute("width","8" );
      ((Element)v.get(518)).setAttribute("height","8" );
      ((Element)v.get(517)).appendChild((Element)v.get(518));
      /* Termina nodo:518   */
      /* Termina nodo:517   */
      /* Termina nodo:500   */

      /* Empieza nodo:519 / Elemento padre: 496   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(496)).appendChild((Element)v.get(519));

      /* Empieza nodo:520 / Elemento padre: 519   */
      v.add(doc.createElement("td"));
      ((Element)v.get(519)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(521)).setAttribute("src","b.gif" );
      ((Element)v.get(521)).setAttribute("width","8" );
      ((Element)v.get(521)).setAttribute("height","8" );
      ((Element)v.get(520)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */
      /* Termina nodo:520   */

      /* Empieza nodo:522 / Elemento padre: 519   */
      v.add(doc.createElement("td"));
      ((Element)v.get(519)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(523)).setAttribute("nombre","txtConsultoraReferencia" );
      ((Element)v.get(523)).setAttribute("id","datosCampos" );
      ((Element)v.get(523)).setAttribute("max","15" );
      ((Element)v.get(523)).setAttribute("tipo","" );
      ((Element)v.get(523)).setAttribute("onchange","onChangeCodCliente('C');" );
      ((Element)v.get(523)).setAttribute("req","N" );
      ((Element)v.get(523)).setAttribute("size","19" );
      ((Element)v.get(523)).setAttribute("valor","" );
      ((Element)v.get(523)).setAttribute("validacion","" );
      ((Element)v.get(523)).setAttribute("ontab","tabGenerico('txtConsultoraReferencia');" );
      ((Element)v.get(523)).setAttribute("onshtab","tabGenerico('txtConsultoraReferencia','sh');" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */
      /* Termina nodo:522   */

      /* Empieza nodo:524 / Elemento padre: 519   */
      v.add(doc.createElement("td"));
      ((Element)v.get(519)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(525)).setAttribute("src","b.gif" );
      ((Element)v.get(525)).setAttribute("width","8" );
      ((Element)v.get(525)).setAttribute("height","8" );
      ((Element)v.get(524)).appendChild((Element)v.get(525));
      /* Termina nodo:525   */
      /* Termina nodo:524   */

      /* Empieza nodo:526 / Elemento padre: 519   */
      v.add(doc.createElement("td"));
      ((Element)v.get(519)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(527)).setAttribute("src","iconBuscar.gif" );
      ((Element)v.get(527)).setAttribute("onclick","accionBuscarCliente('1');" );
      ((Element)v.get(526)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */
      /* Termina nodo:526   */

      /* Empieza nodo:528 / Elemento padre: 519   */
      v.add(doc.createElement("td"));
      ((Element)v.get(519)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(529)).setAttribute("src","b.gif" );
      ((Element)v.get(529)).setAttribute("width","25" );
      ((Element)v.get(529)).setAttribute("height","8" );
      ((Element)v.get(528)).appendChild((Element)v.get(529));
      /* Termina nodo:529   */
      /* Termina nodo:528   */

      /* Empieza nodo:530 / Elemento padre: 519   */
      v.add(doc.createElement("td"));
      ((Element)v.get(530)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(519)).appendChild((Element)v.get(530));

      /* Empieza nodo:531 / Elemento padre: 530   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(531)).setAttribute("nombre","txtReceptorFactura" );
      ((Element)v.get(531)).setAttribute("id","datosCampos" );
      ((Element)v.get(531)).setAttribute("max","15" );
      ((Element)v.get(531)).setAttribute("tipo","" );
      ((Element)v.get(531)).setAttribute("onchange","onChangeCodCliente('R');" );
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(531)).setAttribute("req","S" );
      ((Element)v.get(531)).setAttribute("size","19" );
      ((Element)v.get(531)).setAttribute("valor","" );
      ((Element)v.get(531)).setAttribute("validacion","" );
      ((Element)v.get(531)).setAttribute("ontab","tabGenerico('txtReceptorFactura');" );
      ((Element)v.get(531)).setAttribute("onshtab","tabGenerico('txtReceptorFactura','sh');" );
      ((Element)v.get(530)).appendChild((Element)v.get(531));
      /* Termina nodo:531   */
      /* Termina nodo:530   */

      /* Empieza nodo:532 / Elemento padre: 519   */
      v.add(doc.createElement("td"));
      ((Element)v.get(519)).appendChild((Element)v.get(532));

      /* Empieza nodo:533 / Elemento padre: 532   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(533)).setAttribute("src","b.gif" );
      ((Element)v.get(533)).setAttribute("width","8" );
      ((Element)v.get(533)).setAttribute("height","8" );
      ((Element)v.get(532)).appendChild((Element)v.get(533));
      /* Termina nodo:533   */
      /* Termina nodo:532   */

      /* Empieza nodo:534 / Elemento padre: 519   */
      v.add(doc.createElement("td"));
      ((Element)v.get(519)).appendChild((Element)v.get(534));

      /* Empieza nodo:535 / Elemento padre: 534   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(535)).setAttribute("src","iconBuscar.gif" );
      ((Element)v.get(535)).setAttribute("onclick","accionBuscarCliente('2');" );
      ((Element)v.get(534)).appendChild((Element)v.get(535));
      /* Termina nodo:535   */
      /* Termina nodo:534   */

      /* Empieza nodo:536 / Elemento padre: 519   */
      v.add(doc.createElement("td"));
      ((Element)v.get(519)).appendChild((Element)v.get(536));

      /* Empieza nodo:537 / Elemento padre: 536   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(537)).setAttribute("src","b.gif" );
      ((Element)v.get(537)).setAttribute("width","8" );
      ((Element)v.get(537)).setAttribute("height","8" );
      ((Element)v.get(536)).appendChild((Element)v.get(537));
      /* Termina nodo:537   */
      /* Termina nodo:536   */

      /* Empieza nodo:538 / Elemento padre: 519   */
      v.add(doc.createElement("td"));
      ((Element)v.get(538)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(519)).appendChild((Element)v.get(538));

      /* Empieza nodo:539 / Elemento padre: 538   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(539)).setAttribute("nombre","txtPagadorFactura" );
      ((Element)v.get(539)).setAttribute("id","datosCampos" );
      ((Element)v.get(539)).setAttribute("max","15" );
      ((Element)v.get(539)).setAttribute("tipo","" );
      ((Element)v.get(539)).setAttribute("onchange","onChangeCodCliente('P');" );
      ((Element)v.get(539)).setAttribute("req","S" );
      ((Element)v.get(539)).setAttribute("size","19" );
      ((Element)v.get(539)).setAttribute("valor","" );
      ((Element)v.get(539)).setAttribute("validacion","" );
      ((Element)v.get(539)).setAttribute("ontab","tabGenerico('txtPagadorFactura');" );
      ((Element)v.get(539)).setAttribute("onshtab","tabGenerico('txtPagadorFactura','sh');" );
      ((Element)v.get(538)).appendChild((Element)v.get(539));
      /* Termina nodo:539   */
      /* Termina nodo:538   */

      /* Empieza nodo:540 / Elemento padre: 519   */
      v.add(doc.createElement("td"));
      ((Element)v.get(519)).appendChild((Element)v.get(540));

      /* Empieza nodo:541 / Elemento padre: 540   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(541)).setAttribute("src","b.gif" );
      ((Element)v.get(541)).setAttribute("width","8" );
      ((Element)v.get(541)).setAttribute("height","8" );
      ((Element)v.get(540)).appendChild((Element)v.get(541));
      /* Termina nodo:541   */
      /* Termina nodo:540   */

      /* Empieza nodo:542 / Elemento padre: 519   */
      v.add(doc.createElement("td"));
      ((Element)v.get(519)).appendChild((Element)v.get(542));

      /* Empieza nodo:543 / Elemento padre: 542   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(543)).setAttribute("src","iconBuscar.gif" );
      ((Element)v.get(543)).setAttribute("onclick","accionBuscarCliente('3');" );
      ((Element)v.get(542)).appendChild((Element)v.get(543));
      /* Termina nodo:543   */
      /* Termina nodo:542   */

      /* Empieza nodo:544 / Elemento padre: 519   */
      v.add(doc.createElement("td"));
      ((Element)v.get(519)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(545)).setAttribute("src","b.gif" );
      ((Element)v.get(545)).setAttribute("width","8" );
      ((Element)v.get(545)).setAttribute("height","8" );
      ((Element)v.get(544)).appendChild((Element)v.get(545));
      /* Termina nodo:545   */
      /* Termina nodo:544   */

      /* Empieza nodo:546 / Elemento padre: 519   */
      v.add(doc.createElement("td"));
      ((Element)v.get(519)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(547)).setAttribute("nombre","txtNumeroClientes" );
      ((Element)v.get(547)).setAttribute("id","datosCampos" );
      ((Element)v.get(547)).setAttribute("max","5" );
      ((Element)v.get(547)).setAttribute("tipo","" );
      ((Element)v.get(547)).setAttribute("onchange","" );
      ((Element)v.get(547)).setAttribute("req","N" );
      ((Element)v.get(547)).setAttribute("size","6" );
      ((Element)v.get(547)).setAttribute("valor","" );
      ((Element)v.get(547)).setAttribute("validacion","" );
      ((Element)v.get(547)).setAttribute("ontab","tabGenerico('txtNumeroClientes');" );
      ((Element)v.get(547)).setAttribute("onshtab","tabGenerico('txtNumeroClientes','sh');" );
      ((Element)v.get(546)).appendChild((Element)v.get(547));
      /* Termina nodo:547   */
      /* Termina nodo:546   */

      /* Empieza nodo:548 / Elemento padre: 519   */
      v.add(doc.createElement("td"));
      ((Element)v.get(548)).setAttribute("width","100%" );
      ((Element)v.get(519)).appendChild((Element)v.get(548));

      /* Empieza nodo:549 / Elemento padre: 548   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(549)).setAttribute("src","b.gif" );
      ((Element)v.get(549)).setAttribute("width","8" );
      ((Element)v.get(549)).setAttribute("height","8" );
      ((Element)v.get(548)).appendChild((Element)v.get(549));
      /* Termina nodo:549   */
      /* Termina nodo:548   */
      /* Termina nodo:519   */

      /* Empieza nodo:550 / Elemento padre: 496   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(496)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("td"));
      ((Element)v.get(551)).setAttribute("colspan","3" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(550)).appendChild((Element)v.get(551));

      /* Empieza nodo:552 / Elemento padre: 551   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(552)).setAttribute("src","b.gif" );
      ((Element)v.get(552)).setAttribute("width","8" );
      ((Element)v.get(552)).setAttribute("height","8" );
      ((Element)v.get(551)).appendChild((Element)v.get(552));
      /* Termina nodo:552   */
      /* Termina nodo:551   */
      /* Termina nodo:550   */
      /* Termina nodo:496   */
      /* Termina nodo:495   */
      /* Termina nodo:494   */

      /* Empieza nodo:553 / Elemento padre: 493   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(493)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
      v.add(doc.createElement("td"));
      ((Element)v.get(553)).appendChild((Element)v.get(554));

      /* Empieza nodo:555 / Elemento padre: 554   */
      v.add(doc.createElement("table"));
      ((Element)v.get(555)).setAttribute("width","655" );
      ((Element)v.get(555)).setAttribute("border","0" );
      ((Element)v.get(555)).setAttribute("align","left" );
      ((Element)v.get(555)).setAttribute("cellspacing","0" );
      ((Element)v.get(555)).setAttribute("cellpadding","0" );
      ((Element)v.get(554)).appendChild((Element)v.get(555));

      /* Empieza nodo:556 / Elemento padre: 555   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(555)).appendChild((Element)v.get(556));

      /* Empieza nodo:557 / Elemento padre: 556   */
      v.add(doc.createElement("td"));
      ((Element)v.get(556)).appendChild((Element)v.get(557));

      /* Empieza nodo:558 / Elemento padre: 557   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(558)).setAttribute("src","b.gif" );
      ((Element)v.get(558)).setAttribute("width","8" );
      ((Element)v.get(558)).setAttribute("height","8" );
      ((Element)v.get(557)).appendChild((Element)v.get(558));
      /* Termina nodo:558   */
      /* Termina nodo:557   */

      /* Empieza nodo:559 / Elemento padre: 556   */
      v.add(doc.createElement("td"));
      ((Element)v.get(556)).appendChild((Element)v.get(559));

      /* Empieza nodo:560 / Elemento padre: 559   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(560)).setAttribute("nombre","lblDestino" );
      ((Element)v.get(560)).setAttribute("alto","13" );
      ((Element)v.get(560)).setAttribute("filas","1" );
      ((Element)v.get(560)).setAttribute("valor","" );
      ((Element)v.get(560)).setAttribute("id","datosTitle" );
      ((Element)v.get(560)).setAttribute("cod","1390" );
      ((Element)v.get(559)).appendChild((Element)v.get(560));
      /* Termina nodo:560   */
      /* Termina nodo:559   */

      /* Empieza nodo:561 / Elemento padre: 556   */
      v.add(doc.createElement("td"));
      ((Element)v.get(561)).setAttribute("width","100%" );
      ((Element)v.get(556)).appendChild((Element)v.get(561));

      /* Empieza nodo:562 / Elemento padre: 561   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(562)).setAttribute("src","b.gif" );
      ((Element)v.get(562)).setAttribute("width","8" );
      ((Element)v.get(562)).setAttribute("height","8" );
      ((Element)v.get(561)).appendChild((Element)v.get(562));
      /* Termina nodo:562   */
      /* Termina nodo:561   */
      /* Termina nodo:556   */

      /* Empieza nodo:563 / Elemento padre: 555   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(555)).appendChild((Element)v.get(563));

      /* Empieza nodo:564 / Elemento padre: 563   */
      v.add(doc.createElement("td"));
      ((Element)v.get(563)).appendChild((Element)v.get(564));

      /* Empieza nodo:565 / Elemento padre: 564   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(565)).setAttribute("src","b.gif" );
      ((Element)v.get(565)).setAttribute("width","8" );
      ((Element)v.get(565)).setAttribute("height","8" );
      ((Element)v.get(564)).appendChild((Element)v.get(565));
      /* Termina nodo:565   */
      /* Termina nodo:564   */

      /* Empieza nodo:566 / Elemento padre: 563   */
      v.add(doc.createElement("td"));
      ((Element)v.get(566)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(563)).appendChild((Element)v.get(566));

      /* Empieza nodo:567 / Elemento padre: 566   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(567)).setAttribute("nombre","cbDestino" );
      ((Element)v.get(567)).setAttribute("id","datosCampos" );
      ((Element)v.get(567)).setAttribute("size","1" );
      ((Element)v.get(567)).setAttribute("multiple","N" );
      ((Element)v.get(567)).setAttribute("req","S" );
      ((Element)v.get(567)).setAttribute("valorinicial","" );
      ((Element)v.get(567)).setAttribute("textoinicial","" );
      ((Element)v.get(567)).setAttribute("ontab","tabGenerico('cbDestino');" );
      ((Element)v.get(567)).setAttribute("onshtab","tabGenerico('cbDestino','sh');" );
      ((Element)v.get(566)).appendChild((Element)v.get(567));

      /* Empieza nodo:568 / Elemento padre: 567   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(567)).appendChild((Element)v.get(568));
      /* Termina nodo:568   */
      /* Termina nodo:567   */
      /* Termina nodo:566   */

      /* Empieza nodo:569 / Elemento padre: 563   */
      v.add(doc.createElement("td"));
      ((Element)v.get(569)).setAttribute("width","100%" );
      ((Element)v.get(563)).appendChild((Element)v.get(569));

      /* Empieza nodo:570 / Elemento padre: 569   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(570)).setAttribute("src","b.gif" );
      ((Element)v.get(570)).setAttribute("width","8" );
      ((Element)v.get(570)).setAttribute("height","8" );
      ((Element)v.get(569)).appendChild((Element)v.get(570));
      /* Termina nodo:570   */
      /* Termina nodo:569   */
      /* Termina nodo:563   */
      /* Termina nodo:555   */
      /* Termina nodo:554   */
      /* Termina nodo:553   */

      /* Empieza nodo:571 / Elemento padre: 493   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(493)).appendChild((Element)v.get(571));

      /* Empieza nodo:572 / Elemento padre: 571   */
      v.add(doc.createElement("td"));
      ((Element)v.get(571)).appendChild((Element)v.get(572));

      /* Empieza nodo:573 / Elemento padre: 572   */
      v.add(doc.createElement("table"));
      ((Element)v.get(573)).setAttribute("width","655" );
      ((Element)v.get(573)).setAttribute("border","0" );
      ((Element)v.get(573)).setAttribute("align","left" );
      ((Element)v.get(573)).setAttribute("cellspacing","0" );
      ((Element)v.get(573)).setAttribute("cellpadding","0" );
      ((Element)v.get(572)).appendChild((Element)v.get(573));

      /* Empieza nodo:574 / Elemento padre: 573   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(573)).appendChild((Element)v.get(574));

      /* Empieza nodo:575 / Elemento padre: 574   */
   }

   private void getXML2340(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(575)).setAttribute("colspan","3" );
      ((Element)v.get(574)).appendChild((Element)v.get(575));

      /* Empieza nodo:576 / Elemento padre: 575   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(576)).setAttribute("src","b.gif" );
      ((Element)v.get(576)).setAttribute("width","8" );
      ((Element)v.get(576)).setAttribute("height","8" );
      ((Element)v.get(575)).appendChild((Element)v.get(576));
      /* Termina nodo:576   */
      /* Termina nodo:575   */
      /* Termina nodo:574   */

      /* Empieza nodo:577 / Elemento padre: 573   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(573)).appendChild((Element)v.get(577));

      /* Empieza nodo:578 / Elemento padre: 577   */
      v.add(doc.createElement("td"));
      ((Element)v.get(577)).appendChild((Element)v.get(578));

      /* Empieza nodo:579 / Elemento padre: 578   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(579)).setAttribute("src","b.gif" );
      ((Element)v.get(579)).setAttribute("width","8" );
      ((Element)v.get(579)).setAttribute("height","8" );
      ((Element)v.get(578)).appendChild((Element)v.get(579));
      /* Termina nodo:579   */
      /* Termina nodo:578   */

      /* Empieza nodo:580 / Elemento padre: 577   */
      v.add(doc.createElement("td"));
      ((Element)v.get(577)).appendChild((Element)v.get(580));

      /* Empieza nodo:581 / Elemento padre: 580   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(581)).setAttribute("nombre","lblTipoDocumentoIdentidad" );
      ((Element)v.get(581)).setAttribute("alto","13" );
      ((Element)v.get(581)).setAttribute("filas","1" );
      ((Element)v.get(581)).setAttribute("valor","" );
      ((Element)v.get(581)).setAttribute("id","datosTitle" );
      ((Element)v.get(581)).setAttribute("cod","1126" );
      ((Element)v.get(580)).appendChild((Element)v.get(581));
      /* Termina nodo:581   */
      /* Termina nodo:580   */

      /* Empieza nodo:582 / Elemento padre: 577   */
      v.add(doc.createElement("td"));
      ((Element)v.get(577)).appendChild((Element)v.get(582));

      /* Empieza nodo:583 / Elemento padre: 582   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(583)).setAttribute("src","b.gif" );
      ((Element)v.get(583)).setAttribute("width","25" );
      ((Element)v.get(583)).setAttribute("height","8" );
      ((Element)v.get(582)).appendChild((Element)v.get(583));
      /* Termina nodo:583   */
      /* Termina nodo:582   */

      /* Empieza nodo:584 / Elemento padre: 577   */
      v.add(doc.createElement("td"));
      ((Element)v.get(577)).appendChild((Element)v.get(584));

      /* Empieza nodo:585 / Elemento padre: 584   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(585)).setAttribute("nombre","lblTipoDocumentoLegal" );
      ((Element)v.get(585)).setAttribute("alto","13" );
      ((Element)v.get(585)).setAttribute("filas","1" );
      ((Element)v.get(585)).setAttribute("valor","" );
      ((Element)v.get(585)).setAttribute("id","datosTitle" );
      ((Element)v.get(585)).setAttribute("cod","1392" );
      ((Element)v.get(584)).appendChild((Element)v.get(585));
      /* Termina nodo:585   */
      /* Termina nodo:584   */

      /* Empieza nodo:586 / Elemento padre: 577   */
      v.add(doc.createElement("td"));
      ((Element)v.get(577)).appendChild((Element)v.get(586));

      /* Empieza nodo:587 / Elemento padre: 586   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(587)).setAttribute("src","b.gif" );
      ((Element)v.get(587)).setAttribute("width","25" );
      ((Element)v.get(587)).setAttribute("height","8" );
      ((Element)v.get(586)).appendChild((Element)v.get(587));
      /* Termina nodo:587   */
      /* Termina nodo:586   */

      /* Empieza nodo:588 / Elemento padre: 577   */
      v.add(doc.createElement("td"));
      ((Element)v.get(577)).appendChild((Element)v.get(588));

      /* Empieza nodo:589 / Elemento padre: 588   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(589)).setAttribute("nombre","lblNumeroDocumentoLegal" );
      ((Element)v.get(589)).setAttribute("alto","13" );
      ((Element)v.get(589)).setAttribute("filas","1" );
      ((Element)v.get(589)).setAttribute("valor","" );
      ((Element)v.get(589)).setAttribute("id","datosTitle" );
      ((Element)v.get(589)).setAttribute("cod","1421" );
      ((Element)v.get(588)).appendChild((Element)v.get(589));
      /* Termina nodo:589   */
      /* Termina nodo:588   */

      /* Empieza nodo:590 / Elemento padre: 577   */
      v.add(doc.createElement("td"));
      ((Element)v.get(590)).setAttribute("width","100%" );
      ((Element)v.get(577)).appendChild((Element)v.get(590));

      /* Empieza nodo:591 / Elemento padre: 590   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(591)).setAttribute("src","b.gif" );
      ((Element)v.get(591)).setAttribute("width","8" );
      ((Element)v.get(591)).setAttribute("height","8" );
      ((Element)v.get(590)).appendChild((Element)v.get(591));
      /* Termina nodo:591   */
      /* Termina nodo:590   */
      /* Termina nodo:577   */

      /* Empieza nodo:592 / Elemento padre: 573   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(573)).appendChild((Element)v.get(592));

      /* Empieza nodo:593 / Elemento padre: 592   */
      v.add(doc.createElement("td"));
      ((Element)v.get(592)).appendChild((Element)v.get(593));

      /* Empieza nodo:594 / Elemento padre: 593   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(594)).setAttribute("src","b.gif" );
      ((Element)v.get(594)).setAttribute("width","8" );
      ((Element)v.get(594)).setAttribute("height","8" );
      ((Element)v.get(593)).appendChild((Element)v.get(594));
      /* Termina nodo:594   */
      /* Termina nodo:593   */

      /* Empieza nodo:595 / Elemento padre: 592   */
      v.add(doc.createElement("td"));
      ((Element)v.get(595)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(592)).appendChild((Element)v.get(595));

      /* Empieza nodo:596 / Elemento padre: 595   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(596)).setAttribute("nombre","cbTipoDocumentoIdentidad" );
      ((Element)v.get(596)).setAttribute("id","datosCampos" );
      ((Element)v.get(596)).setAttribute("size","1" );
      ((Element)v.get(596)).setAttribute("multiple","N" );
      ((Element)v.get(596)).setAttribute("req","S" );
      ((Element)v.get(596)).setAttribute("valorinicial","" );
      ((Element)v.get(596)).setAttribute("textoinicial","" );
      ((Element)v.get(596)).setAttribute("ontab","tabGenerico('cbTipoDocumentoIdentidad');" );
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(596)).setAttribute("onshtab","tabGenerico('cbTipoDocumentoIdentidad','sh');" );
      ((Element)v.get(595)).appendChild((Element)v.get(596));

      /* Empieza nodo:597 / Elemento padre: 596   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(596)).appendChild((Element)v.get(597));
      /* Termina nodo:597   */
      /* Termina nodo:596   */
      /* Termina nodo:595   */

      /* Empieza nodo:598 / Elemento padre: 592   */
      v.add(doc.createElement("td"));
      ((Element)v.get(592)).appendChild((Element)v.get(598));

      /* Empieza nodo:599 / Elemento padre: 598   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(599)).setAttribute("src","b.gif" );
      ((Element)v.get(599)).setAttribute("width","25" );
      ((Element)v.get(599)).setAttribute("height","8" );
      ((Element)v.get(598)).appendChild((Element)v.get(599));
      /* Termina nodo:599   */
      /* Termina nodo:598   */

      /* Empieza nodo:600 / Elemento padre: 592   */
      v.add(doc.createElement("td"));
      ((Element)v.get(592)).appendChild((Element)v.get(600));

      /* Empieza nodo:601 / Elemento padre: 600   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(601)).setAttribute("nombre","lblTipoDocumentoLegalXX" );
      ((Element)v.get(601)).setAttribute("alto","13" );
      ((Element)v.get(601)).setAttribute("filas","1" );
      ((Element)v.get(601)).setAttribute("valor","" );
      ((Element)v.get(601)).setAttribute("id","datosCampos" );
      ((Element)v.get(600)).appendChild((Element)v.get(601));
      /* Termina nodo:601   */
      /* Termina nodo:600   */

      /* Empieza nodo:602 / Elemento padre: 592   */
      v.add(doc.createElement("td"));
      ((Element)v.get(592)).appendChild((Element)v.get(602));

      /* Empieza nodo:603 / Elemento padre: 602   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(603)).setAttribute("src","b.gif" );
      ((Element)v.get(603)).setAttribute("width","25" );
      ((Element)v.get(603)).setAttribute("height","8" );
      ((Element)v.get(602)).appendChild((Element)v.get(603));
      /* Termina nodo:603   */
      /* Termina nodo:602   */

      /* Empieza nodo:604 / Elemento padre: 592   */
      v.add(doc.createElement("td"));
      ((Element)v.get(592)).appendChild((Element)v.get(604));

      /* Empieza nodo:605 / Elemento padre: 604   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(605)).setAttribute("nombre","lblNumeroDocumentoLegalXX" );
      ((Element)v.get(605)).setAttribute("alto","13" );
      ((Element)v.get(605)).setAttribute("filas","1" );
      ((Element)v.get(605)).setAttribute("valor","" );
      ((Element)v.get(605)).setAttribute("id","datosCampos" );
      ((Element)v.get(604)).appendChild((Element)v.get(605));
      /* Termina nodo:605   */
      /* Termina nodo:604   */

      /* Empieza nodo:606 / Elemento padre: 592   */
      v.add(doc.createElement("td"));
      ((Element)v.get(606)).setAttribute("width","100%" );
      ((Element)v.get(592)).appendChild((Element)v.get(606));

      /* Empieza nodo:607 / Elemento padre: 606   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(607)).setAttribute("src","b.gif" );
      ((Element)v.get(607)).setAttribute("width","8" );
      ((Element)v.get(607)).setAttribute("height","8" );
      ((Element)v.get(606)).appendChild((Element)v.get(607));
      /* Termina nodo:607   */
      /* Termina nodo:606   */
      /* Termina nodo:592   */

      /* Empieza nodo:608 / Elemento padre: 573   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(573)).appendChild((Element)v.get(608));

      /* Empieza nodo:609 / Elemento padre: 608   */
      v.add(doc.createElement("td"));
      ((Element)v.get(609)).setAttribute("colspan","3" );
      ((Element)v.get(608)).appendChild((Element)v.get(609));

      /* Empieza nodo:610 / Elemento padre: 609   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(610)).setAttribute("src","b.gif" );
      ((Element)v.get(610)).setAttribute("width","8" );
      ((Element)v.get(610)).setAttribute("height","7" );
      ((Element)v.get(609)).appendChild((Element)v.get(610));
      /* Termina nodo:610   */
      /* Termina nodo:609   */
      /* Termina nodo:608   */
      /* Termina nodo:573   */
      /* Termina nodo:572   */
      /* Termina nodo:571   */

      /* Empieza nodo:611 / Elemento padre: 493   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(493)).appendChild((Element)v.get(611));

      /* Empieza nodo:612 / Elemento padre: 611   */
      v.add(doc.createElement("td"));
      ((Element)v.get(611)).appendChild((Element)v.get(612));

      /* Empieza nodo:613 / Elemento padre: 612   */
      v.add(doc.createElement("table"));
      ((Element)v.get(613)).setAttribute("width","655" );
      ((Element)v.get(613)).setAttribute("border","0" );
      ((Element)v.get(613)).setAttribute("align","left" );
      ((Element)v.get(613)).setAttribute("cellspacing","0" );
      ((Element)v.get(613)).setAttribute("cellpadding","0" );
      ((Element)v.get(612)).appendChild((Element)v.get(613));

      /* Empieza nodo:614 / Elemento padre: 613   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(613)).appendChild((Element)v.get(614));

      /* Empieza nodo:615 / Elemento padre: 614   */
      v.add(doc.createElement("td"));
      ((Element)v.get(614)).appendChild((Element)v.get(615));

      /* Empieza nodo:616 / Elemento padre: 615   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(616)).setAttribute("src","b.gif" );
      ((Element)v.get(616)).setAttribute("width","8" );
      ((Element)v.get(616)).setAttribute("height","8" );
      ((Element)v.get(615)).appendChild((Element)v.get(616));
      /* Termina nodo:616   */
      /* Termina nodo:615   */

      /* Empieza nodo:617 / Elemento padre: 614   */
      v.add(doc.createElement("td"));
      ((Element)v.get(614)).appendChild((Element)v.get(617));

      /* Empieza nodo:618 / Elemento padre: 617   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(618)).setAttribute("nombre","lblFormaPago" );
      ((Element)v.get(618)).setAttribute("alto","13" );
      ((Element)v.get(618)).setAttribute("filas","1" );
      ((Element)v.get(618)).setAttribute("valor","" );
      ((Element)v.get(618)).setAttribute("id","datosTitle" );
      ((Element)v.get(618)).setAttribute("cod","541" );
      ((Element)v.get(617)).appendChild((Element)v.get(618));
      /* Termina nodo:618   */
      /* Termina nodo:617   */

      /* Empieza nodo:619 / Elemento padre: 614   */
      v.add(doc.createElement("td"));
      ((Element)v.get(614)).appendChild((Element)v.get(619));

      /* Empieza nodo:620 / Elemento padre: 619   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(620)).setAttribute("src","b.gif" );
      ((Element)v.get(620)).setAttribute("width","25" );
      ((Element)v.get(620)).setAttribute("height","8" );
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(619)).appendChild((Element)v.get(620));
      /* Termina nodo:620   */
      /* Termina nodo:619   */

      /* Empieza nodo:621 / Elemento padre: 614   */
      v.add(doc.createElement("td"));
      ((Element)v.get(614)).appendChild((Element)v.get(621));

      /* Empieza nodo:622 / Elemento padre: 621   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(622)).setAttribute("nombre","lblIndicadorImpuestos" );
      ((Element)v.get(622)).setAttribute("alto","13" );
      ((Element)v.get(622)).setAttribute("filas","1" );
      ((Element)v.get(622)).setAttribute("valor","" );
      ((Element)v.get(622)).setAttribute("id","datosTitle" );
      ((Element)v.get(622)).setAttribute("cod","1333" );
      ((Element)v.get(621)).appendChild((Element)v.get(622));
      /* Termina nodo:622   */
      /* Termina nodo:621   */

      /* Empieza nodo:623 / Elemento padre: 614   */
      v.add(doc.createElement("td"));
      ((Element)v.get(623)).setAttribute("width","100%" );
      ((Element)v.get(614)).appendChild((Element)v.get(623));

      /* Empieza nodo:624 / Elemento padre: 623   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(624)).setAttribute("src","b.gif" );
      ((Element)v.get(624)).setAttribute("width","8" );
      ((Element)v.get(624)).setAttribute("height","8" );
      ((Element)v.get(623)).appendChild((Element)v.get(624));
      /* Termina nodo:624   */
      /* Termina nodo:623   */
      /* Termina nodo:614   */

      /* Empieza nodo:625 / Elemento padre: 613   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(613)).appendChild((Element)v.get(625));

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
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(629)).setAttribute("nombre","cbFormaPago" );
      ((Element)v.get(629)).setAttribute("id","datosCampos" );
      ((Element)v.get(629)).setAttribute("size","1" );
      ((Element)v.get(629)).setAttribute("multiple","N" );
      ((Element)v.get(629)).setAttribute("req","N" );
      ((Element)v.get(629)).setAttribute("valorinicial","" );
      ((Element)v.get(629)).setAttribute("textoinicial","" );
      ((Element)v.get(629)).setAttribute("ontab","tabGenerico('cbFormaPago');" );
      ((Element)v.get(629)).setAttribute("onshtab","tabGenerico('cbFormaPago','sh');" );
      ((Element)v.get(628)).appendChild((Element)v.get(629));

      /* Empieza nodo:630 / Elemento padre: 629   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(629)).appendChild((Element)v.get(630));
      /* Termina nodo:630   */
      /* Termina nodo:629   */
      /* Termina nodo:628   */

      /* Empieza nodo:631 / Elemento padre: 625   */
      v.add(doc.createElement("td"));
      ((Element)v.get(625)).appendChild((Element)v.get(631));

      /* Empieza nodo:632 / Elemento padre: 631   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(632)).setAttribute("src","b.gif" );
      ((Element)v.get(632)).setAttribute("width","25" );
      ((Element)v.get(632)).setAttribute("height","8" );
      ((Element)v.get(631)).appendChild((Element)v.get(632));
      /* Termina nodo:632   */
      /* Termina nodo:631   */

      /* Empieza nodo:633 / Elemento padre: 625   */
      v.add(doc.createElement("td"));
      ((Element)v.get(625)).appendChild((Element)v.get(633));

      /* Empieza nodo:634 / Elemento padre: 633   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(634)).setAttribute("nombre","lblIndicadorImpuestosXX" );
      ((Element)v.get(634)).setAttribute("alto","13" );
      ((Element)v.get(634)).setAttribute("filas","1" );
      ((Element)v.get(634)).setAttribute("valor","" );
      ((Element)v.get(634)).setAttribute("id","datosCampos" );
      ((Element)v.get(633)).appendChild((Element)v.get(634));
      /* Termina nodo:634   */
      /* Termina nodo:633   */

      /* Empieza nodo:635 / Elemento padre: 625   */
      v.add(doc.createElement("td"));
      ((Element)v.get(635)).setAttribute("width","100%" );
      ((Element)v.get(625)).appendChild((Element)v.get(635));

      /* Empieza nodo:636 / Elemento padre: 635   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(636)).setAttribute("src","b.gif" );
      ((Element)v.get(636)).setAttribute("width","8" );
      ((Element)v.get(636)).setAttribute("height","8" );
      ((Element)v.get(635)).appendChild((Element)v.get(636));
      /* Termina nodo:636   */
      /* Termina nodo:635   */
      /* Termina nodo:625   */

      /* Empieza nodo:637 / Elemento padre: 613   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(613)).appendChild((Element)v.get(637));

      /* Empieza nodo:638 / Elemento padre: 637   */
      v.add(doc.createElement("td"));
      ((Element)v.get(638)).setAttribute("colspan","3" );
      ((Element)v.get(637)).appendChild((Element)v.get(638));

      /* Empieza nodo:639 / Elemento padre: 638   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(639)).setAttribute("src","b.gif" );
      ((Element)v.get(639)).setAttribute("width","8" );
      ((Element)v.get(639)).setAttribute("height","8" );
      ((Element)v.get(638)).appendChild((Element)v.get(639));
      /* Termina nodo:639   */
      /* Termina nodo:638   */
      /* Termina nodo:637   */
      /* Termina nodo:613   */
      /* Termina nodo:612   */
      /* Termina nodo:611   */
      /* Termina nodo:493   */
      /* Termina nodo:490   */
      /* Termina nodo:489   */

      /* Empieza nodo:640 / Elemento padre: 486   */
      v.add(doc.createElement("td"));
      ((Element)v.get(486)).appendChild((Element)v.get(640));

      /* Empieza nodo:641 / Elemento padre: 640   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(641)).setAttribute("src","b.gif" );
      ((Element)v.get(640)).appendChild((Element)v.get(641));
      /* Termina nodo:641   */
      /* Termina nodo:640   */
      /* Termina nodo:486   */

      /* Empieza nodo:642 / Elemento padre: 478   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(478)).appendChild((Element)v.get(642));

      /* Empieza nodo:643 / Elemento padre: 642   */
      v.add(doc.createElement("td"));
      ((Element)v.get(642)).appendChild((Element)v.get(643));

      /* Empieza nodo:644 / Elemento padre: 643   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(644)).setAttribute("src","b.gif" );
      ((Element)v.get(643)).appendChild((Element)v.get(644));
      /* Termina nodo:644   */
      /* Termina nodo:643   */

      /* Empieza nodo:645 / Elemento padre: 642   */
      v.add(doc.createElement("td"));
   }

   private void getXML2610(Document doc) {
      ((Element)v.get(642)).appendChild((Element)v.get(645));

      /* Empieza nodo:646 / Elemento padre: 645   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(645)).appendChild((Element)v.get(646));

      /* Empieza nodo:647 / Elemento padre: 646   */
      v.add(doc.createElement("table"));
      ((Element)v.get(647)).setAttribute("width","100%" );
      ((Element)v.get(647)).setAttribute("border","0" );
      ((Element)v.get(647)).setAttribute("align","center" );
      ((Element)v.get(647)).setAttribute("cellspacing","0" );
      ((Element)v.get(647)).setAttribute("cellpadding","0" );
      ((Element)v.get(646)).appendChild((Element)v.get(647));

      /* Empieza nodo:648 / Elemento padre: 647   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(647)).appendChild((Element)v.get(648));

      /* Empieza nodo:649 / Elemento padre: 648   */
      v.add(doc.createElement("td"));
      ((Element)v.get(649)).setAttribute("class","botonera" );
      ((Element)v.get(648)).appendChild((Element)v.get(649));

      /* Empieza nodo:650 / Elemento padre: 649   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(650)).setAttribute("nombre","btnVisualizarPosicion3" );
      ((Element)v.get(650)).setAttribute("ID","botonContenido" );
      ((Element)v.get(650)).setAttribute("tipo","html" );
      ((Element)v.get(650)).setAttribute("accion","accionVisualizarPosiciones();" );
      ((Element)v.get(650)).setAttribute("estado","false" );
      ((Element)v.get(650)).setAttribute("cod","2762" );
      ((Element)v.get(650)).setAttribute("ontab","tabGenerico('btnVisualizarPosicion3');" );
      ((Element)v.get(650)).setAttribute("onshtab","tabGenerico('btnVisualizarPosicion3','sh');" );
      ((Element)v.get(649)).appendChild((Element)v.get(650));
      /* Termina nodo:650   */

      /* Empieza nodo:651 / Elemento padre: 649   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(651)).setAttribute("nombre","btnModificarPosicion3" );
      ((Element)v.get(651)).setAttribute("ID","botonContenido" );
      ((Element)v.get(651)).setAttribute("tipo","html" );
      ((Element)v.get(651)).setAttribute("accion","accionModificarPosiciones();" );
      ((Element)v.get(651)).setAttribute("estado","false" );
      ((Element)v.get(651)).setAttribute("cod","2763" );
      ((Element)v.get(651)).setAttribute("ontab","tabGenerico('btnModificarPosicion3');" );
      ((Element)v.get(651)).setAttribute("onshtab","tabGenerico('btnModificarPosicion3','sh');" );
      ((Element)v.get(649)).appendChild((Element)v.get(651));
      /* Termina nodo:651   */
      /* Termina nodo:649   */
      /* Termina nodo:648   */
      /* Termina nodo:647   */
      /* Termina nodo:646   */
      /* Termina nodo:645   */

      /* Empieza nodo:652 / Elemento padre: 642   */
      v.add(doc.createElement("td"));
      ((Element)v.get(642)).appendChild((Element)v.get(652));

      /* Empieza nodo:653 / Elemento padre: 652   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(653)).setAttribute("src","b.gif" );
      ((Element)v.get(653)).setAttribute("width","8" );
      ((Element)v.get(653)).setAttribute("height","12" );
      ((Element)v.get(652)).appendChild((Element)v.get(653));
      /* Termina nodo:653   */
      /* Termina nodo:652   */
      /* Termina nodo:642   */

      /* Empieza nodo:654 / Elemento padre: 478   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(478)).appendChild((Element)v.get(654));

      /* Empieza nodo:655 / Elemento padre: 654   */
      v.add(doc.createElement("td"));
      ((Element)v.get(655)).setAttribute("width","12" );
      ((Element)v.get(655)).setAttribute("align","center" );
      ((Element)v.get(654)).appendChild((Element)v.get(655));

      /* Empieza nodo:656 / Elemento padre: 655   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(656)).setAttribute("src","b.gif" );
      ((Element)v.get(656)).setAttribute("width","12" );
      ((Element)v.get(656)).setAttribute("height","12" );
      ((Element)v.get(655)).appendChild((Element)v.get(656));
      /* Termina nodo:656   */
      /* Termina nodo:655   */

      /* Empieza nodo:657 / Elemento padre: 654   */
      v.add(doc.createElement("td"));
      ((Element)v.get(657)).setAttribute("width","756" );
      ((Element)v.get(654)).appendChild((Element)v.get(657));

      /* Empieza nodo:658 / Elemento padre: 657   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(658)).setAttribute("src","b.gif" );
      ((Element)v.get(657)).appendChild((Element)v.get(658));
      /* Termina nodo:658   */
      /* Termina nodo:657   */

      /* Empieza nodo:659 / Elemento padre: 654   */
      v.add(doc.createElement("td"));
      ((Element)v.get(659)).setAttribute("width","12" );
      ((Element)v.get(654)).appendChild((Element)v.get(659));

      /* Empieza nodo:660 / Elemento padre: 659   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(660)).setAttribute("src","b.gif" );
      ((Element)v.get(660)).setAttribute("width","12" );
      ((Element)v.get(660)).setAttribute("height","1" );
      ((Element)v.get(659)).appendChild((Element)v.get(660));
      /* Termina nodo:660   */
      /* Termina nodo:659   */
      /* Termina nodo:654   */
      /* Termina nodo:478   */
      /* Termina nodo:477   */

      /* Empieza nodo:661 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(661)).setAttribute("nombre","capa4" );
      ((Element)v.get(661)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(13)).appendChild((Element)v.get(661));

      /* Empieza nodo:662 / Elemento padre: 661   */
      v.add(doc.createElement("table"));
      ((Element)v.get(662)).setAttribute("width","100%" );
      ((Element)v.get(662)).setAttribute("border","0" );
      ((Element)v.get(662)).setAttribute("cellspacing","0" );
      ((Element)v.get(662)).setAttribute("cellpadding","0" );
      ((Element)v.get(661)).appendChild((Element)v.get(662));

      /* Empieza nodo:663 / Elemento padre: 662   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(662)).appendChild((Element)v.get(663));

      /* Empieza nodo:664 / Elemento padre: 663   */
      v.add(doc.createElement("td"));
      ((Element)v.get(664)).setAttribute("width","12" );
      ((Element)v.get(664)).setAttribute("align","center" );
      ((Element)v.get(663)).appendChild((Element)v.get(664));

      /* Empieza nodo:665 / Elemento padre: 664   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(665)).setAttribute("src","b.gif" );
      ((Element)v.get(665)).setAttribute("width","12" );
      ((Element)v.get(665)).setAttribute("height","12" );
      ((Element)v.get(664)).appendChild((Element)v.get(665));
      /* Termina nodo:665   */
      /* Termina nodo:664   */

      /* Empieza nodo:666 / Elemento padre: 663   */
      v.add(doc.createElement("td"));
      ((Element)v.get(666)).setAttribute("width","750" );
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(663)).appendChild((Element)v.get(666));

      /* Empieza nodo:667 / Elemento padre: 666   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(667)).setAttribute("src","b.gif" );
      ((Element)v.get(666)).appendChild((Element)v.get(667));
      /* Termina nodo:667   */
      /* Termina nodo:666   */

      /* Empieza nodo:668 / Elemento padre: 663   */
      v.add(doc.createElement("td"));
      ((Element)v.get(668)).setAttribute("width","12" );
      ((Element)v.get(663)).appendChild((Element)v.get(668));

      /* Empieza nodo:669 / Elemento padre: 668   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(669)).setAttribute("src","b.gif" );
      ((Element)v.get(669)).setAttribute("width","12" );
      ((Element)v.get(669)).setAttribute("height","1" );
      ((Element)v.get(668)).appendChild((Element)v.get(669));
      /* Termina nodo:669   */
      /* Termina nodo:668   */
      /* Termina nodo:663   */

      /* Empieza nodo:670 / Elemento padre: 662   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(662)).appendChild((Element)v.get(670));

      /* Empieza nodo:671 / Elemento padre: 670   */
      v.add(doc.createElement("td"));
      ((Element)v.get(670)).appendChild((Element)v.get(671));

      /* Empieza nodo:672 / Elemento padre: 671   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(672)).setAttribute("src","b.gif" );
      ((Element)v.get(671)).appendChild((Element)v.get(672));
      /* Termina nodo:672   */
      /* Termina nodo:671   */

      /* Empieza nodo:673 / Elemento padre: 670   */
      v.add(doc.createElement("td"));
      ((Element)v.get(670)).appendChild((Element)v.get(673));

      /* Empieza nodo:674 / Elemento padre: 673   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(673)).appendChild((Element)v.get(674));

      /* Empieza nodo:675 / Elemento padre: 674   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(675)).setAttribute("class","legend" );
      ((Element)v.get(674)).appendChild((Element)v.get(675));

      /* Empieza nodo:676 / Elemento padre: 675   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(676)).setAttribute("nombre","lblInformacionEconomicaDocumento" );
      ((Element)v.get(676)).setAttribute("alto","13" );
      ((Element)v.get(676)).setAttribute("filas","1" );
      ((Element)v.get(676)).setAttribute("valor","" );
      ((Element)v.get(676)).setAttribute("id","legend" );
      ((Element)v.get(676)).setAttribute("cod","00574" );
      ((Element)v.get(675)).appendChild((Element)v.get(676));
      /* Termina nodo:676   */
      /* Termina nodo:675   */

      /* Empieza nodo:677 / Elemento padre: 674   */
      v.add(doc.createElement("table"));
      ((Element)v.get(677)).setAttribute("width","100%" );
      ((Element)v.get(677)).setAttribute("border","0" );
      ((Element)v.get(677)).setAttribute("align","center" );
      ((Element)v.get(677)).setAttribute("cellspacing","0" );
      ((Element)v.get(677)).setAttribute("cellpadding","0" );
      ((Element)v.get(674)).appendChild((Element)v.get(677));

      /* Empieza nodo:678 / Elemento padre: 677   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(677)).appendChild((Element)v.get(678));

      /* Empieza nodo:679 / Elemento padre: 678   */
      v.add(doc.createElement("td"));
      ((Element)v.get(678)).appendChild((Element)v.get(679));

      /* Empieza nodo:680 / Elemento padre: 679   */
      v.add(doc.createElement("table"));
      ((Element)v.get(680)).setAttribute("width","655" );
      ((Element)v.get(680)).setAttribute("border","0" );
      ((Element)v.get(680)).setAttribute("align","left" );
      ((Element)v.get(680)).setAttribute("cellspacing","0" );
      ((Element)v.get(680)).setAttribute("cellpadding","0" );
      ((Element)v.get(679)).appendChild((Element)v.get(680));

      /* Empieza nodo:681 / Elemento padre: 680   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(680)).appendChild((Element)v.get(681));

      /* Empieza nodo:682 / Elemento padre: 681   */
      v.add(doc.createElement("td"));
      ((Element)v.get(682)).setAttribute("colspan","3" );
      ((Element)v.get(681)).appendChild((Element)v.get(682));

      /* Empieza nodo:683 / Elemento padre: 682   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(683)).setAttribute("src","b.gif" );
      ((Element)v.get(683)).setAttribute("width","8" );
      ((Element)v.get(683)).setAttribute("height","8" );
      ((Element)v.get(682)).appendChild((Element)v.get(683));
      /* Termina nodo:683   */
      /* Termina nodo:682   */
      /* Termina nodo:681   */

      /* Empieza nodo:684 / Elemento padre: 680   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(680)).appendChild((Element)v.get(684));

      /* Empieza nodo:685 / Elemento padre: 684   */
      v.add(doc.createElement("td"));
      ((Element)v.get(684)).appendChild((Element)v.get(685));

      /* Empieza nodo:686 / Elemento padre: 685   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(686)).setAttribute("src","b.gif" );
      ((Element)v.get(686)).setAttribute("width","8" );
      ((Element)v.get(686)).setAttribute("height","8" );
      ((Element)v.get(685)).appendChild((Element)v.get(686));
      /* Termina nodo:686   */
      /* Termina nodo:685   */

      /* Empieza nodo:687 / Elemento padre: 684   */
      v.add(doc.createElement("td"));
      ((Element)v.get(684)).appendChild((Element)v.get(687));

      /* Empieza nodo:688 / Elemento padre: 687   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(688)).setAttribute("nombre","lblMoneda" );
      ((Element)v.get(688)).setAttribute("alto","13" );
      ((Element)v.get(688)).setAttribute("filas","1" );
      ((Element)v.get(688)).setAttribute("valor","" );
      ((Element)v.get(688)).setAttribute("id","datosTitle" );
      ((Element)v.get(688)).setAttribute("cod","1216" );
      ((Element)v.get(687)).appendChild((Element)v.get(688));
      /* Termina nodo:688   */
      /* Termina nodo:687   */

      /* Empieza nodo:689 / Elemento padre: 684   */
      v.add(doc.createElement("td"));
      ((Element)v.get(684)).appendChild((Element)v.get(689));

      /* Empieza nodo:690 / Elemento padre: 689   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(690)).setAttribute("src","b.gif" );
      ((Element)v.get(690)).setAttribute("width","25" );
      ((Element)v.get(690)).setAttribute("height","8" );
      ((Element)v.get(689)).appendChild((Element)v.get(690));
      /* Termina nodo:690   */
      /* Termina nodo:689   */

      /* Empieza nodo:691 / Elemento padre: 684   */
      v.add(doc.createElement("td"));
      ((Element)v.get(684)).appendChild((Element)v.get(691));

      /* Empieza nodo:692 / Elemento padre: 691   */
   }

   private void getXML2790(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(692)).setAttribute("nombre","lblMontoDescuento1" );
      ((Element)v.get(692)).setAttribute("alto","13" );
      ((Element)v.get(692)).setAttribute("filas","1" );
      ((Element)v.get(692)).setAttribute("valor","" );
      ((Element)v.get(692)).setAttribute("id","datosTitle" );
      ((Element)v.get(692)).setAttribute("cod","2349" );
      ((Element)v.get(691)).appendChild((Element)v.get(692));
      /* Termina nodo:692   */
      /* Termina nodo:691   */

      /* Empieza nodo:693 / Elemento padre: 684   */
      v.add(doc.createElement("td"));
      ((Element)v.get(684)).appendChild((Element)v.get(693));

      /* Empieza nodo:694 / Elemento padre: 693   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(694)).setAttribute("src","b.gif" );
      ((Element)v.get(694)).setAttribute("width","25" );
      ((Element)v.get(694)).setAttribute("height","8" );
      ((Element)v.get(693)).appendChild((Element)v.get(694));
      /* Termina nodo:694   */
      /* Termina nodo:693   */

      /* Empieza nodo:695 / Elemento padre: 684   */
      v.add(doc.createElement("td"));
      ((Element)v.get(684)).appendChild((Element)v.get(695));

      /* Empieza nodo:696 / Elemento padre: 695   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(696)).setAttribute("nombre","lblMontoDescuento2" );
      ((Element)v.get(696)).setAttribute("alto","13" );
      ((Element)v.get(696)).setAttribute("filas","1" );
      ((Element)v.get(696)).setAttribute("valor","" );
      ((Element)v.get(696)).setAttribute("id","datosTitle" );
      ((Element)v.get(696)).setAttribute("cod","2350" );
      ((Element)v.get(695)).appendChild((Element)v.get(696));
      /* Termina nodo:696   */
      /* Termina nodo:695   */

      /* Empieza nodo:697 / Elemento padre: 684   */
      v.add(doc.createElement("td"));
      ((Element)v.get(684)).appendChild((Element)v.get(697));

      /* Empieza nodo:698 / Elemento padre: 697   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(698)).setAttribute("src","b.gif" );
      ((Element)v.get(698)).setAttribute("width","25" );
      ((Element)v.get(698)).setAttribute("height","8" );
      ((Element)v.get(697)).appendChild((Element)v.get(698));
      /* Termina nodo:698   */
      /* Termina nodo:697   */

      /* Empieza nodo:699 / Elemento padre: 684   */
      v.add(doc.createElement("td"));
      ((Element)v.get(684)).appendChild((Element)v.get(699));

      /* Empieza nodo:700 / Elemento padre: 699   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(700)).setAttribute("nombre","lblMontoDescuento3" );
      ((Element)v.get(700)).setAttribute("alto","13" );
      ((Element)v.get(700)).setAttribute("filas","1" );
      ((Element)v.get(700)).setAttribute("valor","" );
      ((Element)v.get(700)).setAttribute("id","datosTitle" );
      ((Element)v.get(700)).setAttribute("cod","2351" );
      ((Element)v.get(699)).appendChild((Element)v.get(700));
      /* Termina nodo:700   */
      /* Termina nodo:699   */

      /* Empieza nodo:701 / Elemento padre: 684   */
      v.add(doc.createElement("td"));
      ((Element)v.get(684)).appendChild((Element)v.get(701));

      /* Empieza nodo:702 / Elemento padre: 701   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(702)).setAttribute("src","b.gif" );
      ((Element)v.get(702)).setAttribute("width","25" );
      ((Element)v.get(702)).setAttribute("height","8" );
      ((Element)v.get(701)).appendChild((Element)v.get(702));
      /* Termina nodo:702   */
      /* Termina nodo:701   */

      /* Empieza nodo:703 / Elemento padre: 684   */
      v.add(doc.createElement("td"));
      ((Element)v.get(684)).appendChild((Element)v.get(703));

      /* Empieza nodo:704 / Elemento padre: 703   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(704)).setAttribute("nombre","lblFletePagar" );
      ((Element)v.get(704)).setAttribute("alto","13" );
      ((Element)v.get(704)).setAttribute("filas","1" );
      ((Element)v.get(704)).setAttribute("valor","" );
      ((Element)v.get(704)).setAttribute("id","datosTitle" );
      ((Element)v.get(704)).setAttribute("cod","1401" );
      ((Element)v.get(703)).appendChild((Element)v.get(704));
      /* Termina nodo:704   */
      /* Termina nodo:703   */

      /* Empieza nodo:705 / Elemento padre: 684   */
      v.add(doc.createElement("td"));
      ((Element)v.get(705)).setAttribute("width","100%" );
      ((Element)v.get(684)).appendChild((Element)v.get(705));

      /* Empieza nodo:706 / Elemento padre: 705   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(706)).setAttribute("src","b.gif" );
      ((Element)v.get(706)).setAttribute("width","8" );
      ((Element)v.get(706)).setAttribute("height","8" );
      ((Element)v.get(705)).appendChild((Element)v.get(706));
      /* Termina nodo:706   */
      /* Termina nodo:705   */
      /* Termina nodo:684   */

      /* Empieza nodo:707 / Elemento padre: 680   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(680)).appendChild((Element)v.get(707));

      /* Empieza nodo:708 / Elemento padre: 707   */
      v.add(doc.createElement("td"));
      ((Element)v.get(707)).appendChild((Element)v.get(708));

      /* Empieza nodo:709 / Elemento padre: 708   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(709)).setAttribute("src","b.gif" );
      ((Element)v.get(709)).setAttribute("width","8" );
      ((Element)v.get(709)).setAttribute("height","8" );
      ((Element)v.get(708)).appendChild((Element)v.get(709));
      /* Termina nodo:709   */
      /* Termina nodo:708   */

      /* Empieza nodo:710 / Elemento padre: 707   */
      v.add(doc.createElement("td"));
      ((Element)v.get(707)).appendChild((Element)v.get(710));

      /* Empieza nodo:711 / Elemento padre: 710   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(711)).setAttribute("nombre","lblMonedaXX" );
      ((Element)v.get(711)).setAttribute("alto","13" );
      ((Element)v.get(711)).setAttribute("filas","1" );
      ((Element)v.get(711)).setAttribute("valor","" );
      ((Element)v.get(711)).setAttribute("id","datosCampos" );
      ((Element)v.get(710)).appendChild((Element)v.get(711));
      /* Termina nodo:711   */
      /* Termina nodo:710   */

      /* Empieza nodo:712 / Elemento padre: 707   */
      v.add(doc.createElement("td"));
      ((Element)v.get(707)).appendChild((Element)v.get(712));

      /* Empieza nodo:713 / Elemento padre: 712   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(713)).setAttribute("src","b.gif" );
      ((Element)v.get(713)).setAttribute("width","25" );
   }

   private void getXML2880(Document doc) {
      ((Element)v.get(713)).setAttribute("height","8" );
      ((Element)v.get(712)).appendChild((Element)v.get(713));
      /* Termina nodo:713   */
      /* Termina nodo:712   */

      /* Empieza nodo:714 / Elemento padre: 707   */
      v.add(doc.createElement("td"));
      ((Element)v.get(707)).appendChild((Element)v.get(714));

      /* Empieza nodo:715 / Elemento padre: 714   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(715)).setAttribute("nombre","lblMontoDescuento1XX" );
      ((Element)v.get(715)).setAttribute("alto","13" );
      ((Element)v.get(715)).setAttribute("filas","1" );
      ((Element)v.get(715)).setAttribute("valor","" );
      ((Element)v.get(715)).setAttribute("id","datosCampos" );
      ((Element)v.get(714)).appendChild((Element)v.get(715));
      /* Termina nodo:715   */
      /* Termina nodo:714   */

      /* Empieza nodo:716 / Elemento padre: 707   */
      v.add(doc.createElement("td"));
      ((Element)v.get(707)).appendChild((Element)v.get(716));

      /* Empieza nodo:717 / Elemento padre: 716   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(717)).setAttribute("src","b.gif" );
      ((Element)v.get(717)).setAttribute("width","25" );
      ((Element)v.get(717)).setAttribute("height","8" );
      ((Element)v.get(716)).appendChild((Element)v.get(717));
      /* Termina nodo:717   */
      /* Termina nodo:716   */

      /* Empieza nodo:718 / Elemento padre: 707   */
      v.add(doc.createElement("td"));
      ((Element)v.get(707)).appendChild((Element)v.get(718));

      /* Empieza nodo:719 / Elemento padre: 718   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(719)).setAttribute("nombre","lblMontoDescuento2XX" );
      ((Element)v.get(719)).setAttribute("alto","13" );
      ((Element)v.get(719)).setAttribute("filas","1" );
      ((Element)v.get(719)).setAttribute("valor","" );
      ((Element)v.get(719)).setAttribute("id","datosCampos" );
      ((Element)v.get(718)).appendChild((Element)v.get(719));
      /* Termina nodo:719   */
      /* Termina nodo:718   */

      /* Empieza nodo:720 / Elemento padre: 707   */
      v.add(doc.createElement("td"));
      ((Element)v.get(707)).appendChild((Element)v.get(720));

      /* Empieza nodo:721 / Elemento padre: 720   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(721)).setAttribute("src","b.gif" );
      ((Element)v.get(721)).setAttribute("width","25" );
      ((Element)v.get(721)).setAttribute("height","8" );
      ((Element)v.get(720)).appendChild((Element)v.get(721));
      /* Termina nodo:721   */
      /* Termina nodo:720   */

      /* Empieza nodo:722 / Elemento padre: 707   */
      v.add(doc.createElement("td"));
      ((Element)v.get(707)).appendChild((Element)v.get(722));

      /* Empieza nodo:723 / Elemento padre: 722   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(723)).setAttribute("nombre","lblMontoDescuento3XX" );
      ((Element)v.get(723)).setAttribute("alto","13" );
      ((Element)v.get(723)).setAttribute("filas","1" );
      ((Element)v.get(723)).setAttribute("valor","" );
      ((Element)v.get(723)).setAttribute("id","datosCampos" );
      ((Element)v.get(722)).appendChild((Element)v.get(723));
      /* Termina nodo:723   */
      /* Termina nodo:722   */

      /* Empieza nodo:724 / Elemento padre: 707   */
      v.add(doc.createElement("td"));
      ((Element)v.get(707)).appendChild((Element)v.get(724));

      /* Empieza nodo:725 / Elemento padre: 724   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(725)).setAttribute("src","b.gif" );
      ((Element)v.get(725)).setAttribute("width","25" );
      ((Element)v.get(725)).setAttribute("height","8" );
      ((Element)v.get(724)).appendChild((Element)v.get(725));
      /* Termina nodo:725   */
      /* Termina nodo:724   */

      /* Empieza nodo:726 / Elemento padre: 707   */
      v.add(doc.createElement("td"));
      ((Element)v.get(707)).appendChild((Element)v.get(726));

      /* Empieza nodo:727 / Elemento padre: 726   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(727)).setAttribute("nombre","lblFletePagarXX" );
      ((Element)v.get(727)).setAttribute("alto","13" );
      ((Element)v.get(727)).setAttribute("filas","1" );
      ((Element)v.get(727)).setAttribute("valor","" );
      ((Element)v.get(727)).setAttribute("id","datosCampos" );
      ((Element)v.get(726)).appendChild((Element)v.get(727));
      /* Termina nodo:727   */
      /* Termina nodo:726   */

      /* Empieza nodo:728 / Elemento padre: 707   */
      v.add(doc.createElement("td"));
      ((Element)v.get(728)).setAttribute("width","100%" );
      ((Element)v.get(707)).appendChild((Element)v.get(728));

      /* Empieza nodo:729 / Elemento padre: 728   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(729)).setAttribute("src","b.gif" );
      ((Element)v.get(729)).setAttribute("width","8" );
      ((Element)v.get(729)).setAttribute("height","8" );
      ((Element)v.get(728)).appendChild((Element)v.get(729));
      /* Termina nodo:729   */
      /* Termina nodo:728   */
      /* Termina nodo:707   */

      /* Empieza nodo:730 / Elemento padre: 680   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(680)).appendChild((Element)v.get(730));

      /* Empieza nodo:731 / Elemento padre: 730   */
      v.add(doc.createElement("td"));
      ((Element)v.get(731)).setAttribute("colspan","3" );
      ((Element)v.get(730)).appendChild((Element)v.get(731));

      /* Empieza nodo:732 / Elemento padre: 731   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(732)).setAttribute("src","b.gif" );
      ((Element)v.get(732)).setAttribute("width","8" );
      ((Element)v.get(732)).setAttribute("height","8" );
      ((Element)v.get(731)).appendChild((Element)v.get(732));
      /* Termina nodo:732   */
      /* Termina nodo:731   */
      /* Termina nodo:730   */
      /* Termina nodo:680   */
      /* Termina nodo:679   */
      /* Termina nodo:678   */

      /* Empieza nodo:733 / Elemento padre: 677   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(677)).appendChild((Element)v.get(733));

      /* Empieza nodo:734 / Elemento padre: 733   */
      v.add(doc.createElement("td"));
      ((Element)v.get(733)).appendChild((Element)v.get(734));

      /* Empieza nodo:735 / Elemento padre: 734   */
      v.add(doc.createElement("table"));
      ((Element)v.get(735)).setAttribute("width","655" );
      ((Element)v.get(735)).setAttribute("border","0" );
      ((Element)v.get(735)).setAttribute("align","left" );
      ((Element)v.get(735)).setAttribute("cellspacing","0" );
      ((Element)v.get(735)).setAttribute("cellpadding","0" );
      ((Element)v.get(734)).appendChild((Element)v.get(735));

      /* Empieza nodo:736 / Elemento padre: 735   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(735)).appendChild((Element)v.get(736));

      /* Empieza nodo:737 / Elemento padre: 736   */
   }

   private void getXML2970(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(736)).appendChild((Element)v.get(737));

      /* Empieza nodo:738 / Elemento padre: 737   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(738)).setAttribute("src","b.gif" );
      ((Element)v.get(738)).setAttribute("width","8" );
      ((Element)v.get(738)).setAttribute("height","8" );
      ((Element)v.get(737)).appendChild((Element)v.get(738));
      /* Termina nodo:738   */
      /* Termina nodo:737   */

      /* Empieza nodo:739 / Elemento padre: 736   */
      v.add(doc.createElement("td"));
      ((Element)v.get(736)).appendChild((Element)v.get(739));

      /* Empieza nodo:740 / Elemento padre: 739   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(740)).setAttribute("nombre","lblTotalImpuestos" );
      ((Element)v.get(740)).setAttribute("alto","13" );
      ((Element)v.get(740)).setAttribute("filas","1" );
      ((Element)v.get(740)).setAttribute("valor","" );
      ((Element)v.get(740)).setAttribute("id","datosTitle" );
      ((Element)v.get(740)).setAttribute("cod","1425" );
      ((Element)v.get(739)).appendChild((Element)v.get(740));
      /* Termina nodo:740   */
      /* Termina nodo:739   */

      /* Empieza nodo:741 / Elemento padre: 736   */
      v.add(doc.createElement("td"));
      ((Element)v.get(736)).appendChild((Element)v.get(741));

      /* Empieza nodo:742 / Elemento padre: 741   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(742)).setAttribute("src","b.gif" );
      ((Element)v.get(742)).setAttribute("width","25" );
      ((Element)v.get(742)).setAttribute("height","8" );
      ((Element)v.get(741)).appendChild((Element)v.get(742));
      /* Termina nodo:742   */
      /* Termina nodo:741   */

      /* Empieza nodo:743 / Elemento padre: 736   */
      v.add(doc.createElement("td"));
      ((Element)v.get(736)).appendChild((Element)v.get(743));

      /* Empieza nodo:744 / Elemento padre: 743   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(744)).setAttribute("nombre","lblTotalPagar" );
      ((Element)v.get(744)).setAttribute("alto","13" );
      ((Element)v.get(744)).setAttribute("filas","1" );
      ((Element)v.get(744)).setAttribute("valor","" );
      ((Element)v.get(744)).setAttribute("id","datosTitle" );
      ((Element)v.get(744)).setAttribute("cod","1402" );
      ((Element)v.get(743)).appendChild((Element)v.get(744));
      /* Termina nodo:744   */
      /* Termina nodo:743   */

      /* Empieza nodo:745 / Elemento padre: 736   */
      v.add(doc.createElement("td"));
      ((Element)v.get(745)).setAttribute("width","100%" );
      ((Element)v.get(736)).appendChild((Element)v.get(745));

      /* Empieza nodo:746 / Elemento padre: 745   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(746)).setAttribute("src","b.gif" );
      ((Element)v.get(746)).setAttribute("width","8" );
      ((Element)v.get(746)).setAttribute("height","8" );
      ((Element)v.get(745)).appendChild((Element)v.get(746));
      /* Termina nodo:746   */
      /* Termina nodo:745   */
      /* Termina nodo:736   */

      /* Empieza nodo:747 / Elemento padre: 735   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(735)).appendChild((Element)v.get(747));

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
      ((Element)v.get(751)).setAttribute("nombre","lblTotalImpuestosXX" );
      ((Element)v.get(751)).setAttribute("alto","13" );
      ((Element)v.get(751)).setAttribute("filas","1" );
      ((Element)v.get(751)).setAttribute("valor","" );
      ((Element)v.get(751)).setAttribute("id","datosCampos" );
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
      ((Element)v.get(755)).setAttribute("nombre","lblTotalPagarXX" );
      ((Element)v.get(755)).setAttribute("alto","13" );
      ((Element)v.get(755)).setAttribute("filas","1" );
      ((Element)v.get(755)).setAttribute("valor","" );
      ((Element)v.get(755)).setAttribute("id","datosCampos" );
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

      /* Empieza nodo:758 / Elemento padre: 735   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(735)).appendChild((Element)v.get(758));

      /* Empieza nodo:759 / Elemento padre: 758   */
      v.add(doc.createElement("td"));
      ((Element)v.get(759)).setAttribute("colspan","3" );
      ((Element)v.get(758)).appendChild((Element)v.get(759));

      /* Empieza nodo:760 / Elemento padre: 759   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML3060(Document doc) {
      ((Element)v.get(760)).setAttribute("src","b.gif" );
      ((Element)v.get(760)).setAttribute("width","8" );
      ((Element)v.get(760)).setAttribute("height","8" );
      ((Element)v.get(759)).appendChild((Element)v.get(760));
      /* Termina nodo:760   */
      /* Termina nodo:759   */
      /* Termina nodo:758   */
      /* Termina nodo:735   */
      /* Termina nodo:734   */
      /* Termina nodo:733   */
      /* Termina nodo:677   */
      /* Termina nodo:674   */
      /* Termina nodo:673   */

      /* Empieza nodo:761 / Elemento padre: 670   */
      v.add(doc.createElement("td"));
      ((Element)v.get(670)).appendChild((Element)v.get(761));

      /* Empieza nodo:762 / Elemento padre: 761   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(762)).setAttribute("src","b.gif" );
      ((Element)v.get(761)).appendChild((Element)v.get(762));
      /* Termina nodo:762   */
      /* Termina nodo:761   */
      /* Termina nodo:670   */

      /* Empieza nodo:763 / Elemento padre: 662   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(662)).appendChild((Element)v.get(763));

      /* Empieza nodo:764 / Elemento padre: 763   */
      v.add(doc.createElement("td"));
      ((Element)v.get(763)).appendChild((Element)v.get(764));

      /* Empieza nodo:765 / Elemento padre: 764   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(765)).setAttribute("src","b.gif" );
      ((Element)v.get(764)).appendChild((Element)v.get(765));
      /* Termina nodo:765   */
      /* Termina nodo:764   */

      /* Empieza nodo:766 / Elemento padre: 763   */
      v.add(doc.createElement("td"));
      ((Element)v.get(763)).appendChild((Element)v.get(766));

      /* Empieza nodo:767 / Elemento padre: 766   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(766)).appendChild((Element)v.get(767));

      /* Empieza nodo:768 / Elemento padre: 767   */
      v.add(doc.createElement("table"));
      ((Element)v.get(768)).setAttribute("width","100%" );
      ((Element)v.get(768)).setAttribute("border","0" );
      ((Element)v.get(768)).setAttribute("align","center" );
      ((Element)v.get(768)).setAttribute("cellspacing","0" );
      ((Element)v.get(768)).setAttribute("cellpadding","0" );
      ((Element)v.get(767)).appendChild((Element)v.get(768));

      /* Empieza nodo:769 / Elemento padre: 768   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(768)).appendChild((Element)v.get(769));

      /* Empieza nodo:770 / Elemento padre: 769   */
      v.add(doc.createElement("td"));
      ((Element)v.get(770)).setAttribute("class","botonera" );
      ((Element)v.get(769)).appendChild((Element)v.get(770));

      /* Empieza nodo:771 / Elemento padre: 770   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(771)).setAttribute("nombre","btnVisualizarPosicion4" );
      ((Element)v.get(771)).setAttribute("ID","botonContenido" );
      ((Element)v.get(771)).setAttribute("tipo","html" );
      ((Element)v.get(771)).setAttribute("accion","accionVisualizarPosiciones();" );
      ((Element)v.get(771)).setAttribute("estado","false" );
      ((Element)v.get(771)).setAttribute("cod","2762" );
      ((Element)v.get(771)).setAttribute("ontab","tabGenerico('btnVisualizarPosicion4');" );
      ((Element)v.get(771)).setAttribute("onshtab","tabGenerico('btnVisualizarPosicion4','sh');" );
      ((Element)v.get(770)).appendChild((Element)v.get(771));
      /* Termina nodo:771   */

      /* Empieza nodo:772 / Elemento padre: 770   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(772)).setAttribute("nombre","btnModificarPosicion4" );
      ((Element)v.get(772)).setAttribute("ID","botonContenido" );
      ((Element)v.get(772)).setAttribute("tipo","html" );
      ((Element)v.get(772)).setAttribute("accion","accionModificarPosiciones();" );
      ((Element)v.get(772)).setAttribute("estado","false" );
      ((Element)v.get(772)).setAttribute("cod","2763" );
      ((Element)v.get(772)).setAttribute("ontab","tabGenerico('btnModificarPosicion4');" );
      ((Element)v.get(772)).setAttribute("onshtab","tabGenerico('btnModificarPosicion4','sh');" );
      ((Element)v.get(770)).appendChild((Element)v.get(772));
      /* Termina nodo:772   */
      /* Termina nodo:770   */
      /* Termina nodo:769   */
      /* Termina nodo:768   */
      /* Termina nodo:767   */
      /* Termina nodo:766   */

      /* Empieza nodo:773 / Elemento padre: 763   */
      v.add(doc.createElement("td"));
      ((Element)v.get(763)).appendChild((Element)v.get(773));

      /* Empieza nodo:774 / Elemento padre: 773   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(774)).setAttribute("src","b.gif" );
      ((Element)v.get(774)).setAttribute("width","8" );
      ((Element)v.get(774)).setAttribute("height","12" );
      ((Element)v.get(773)).appendChild((Element)v.get(774));
      /* Termina nodo:774   */
      /* Termina nodo:773   */
      /* Termina nodo:763   */

      /* Empieza nodo:775 / Elemento padre: 662   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(662)).appendChild((Element)v.get(775));

      /* Empieza nodo:776 / Elemento padre: 775   */
      v.add(doc.createElement("td"));
      ((Element)v.get(776)).setAttribute("width","12" );
      ((Element)v.get(776)).setAttribute("align","center" );
      ((Element)v.get(775)).appendChild((Element)v.get(776));

      /* Empieza nodo:777 / Elemento padre: 776   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(777)).setAttribute("src","b.gif" );
      ((Element)v.get(777)).setAttribute("width","12" );
      ((Element)v.get(777)).setAttribute("height","12" );
      ((Element)v.get(776)).appendChild((Element)v.get(777));
      /* Termina nodo:777   */
      /* Termina nodo:776   */

      /* Empieza nodo:778 / Elemento padre: 775   */
      v.add(doc.createElement("td"));
      ((Element)v.get(778)).setAttribute("width","756" );
      ((Element)v.get(775)).appendChild((Element)v.get(778));

      /* Empieza nodo:779 / Elemento padre: 778   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(779)).setAttribute("src","b.gif" );
      ((Element)v.get(778)).appendChild((Element)v.get(779));
      /* Termina nodo:779   */
      /* Termina nodo:778   */

      /* Empieza nodo:780 / Elemento padre: 775   */
      v.add(doc.createElement("td"));
      ((Element)v.get(780)).setAttribute("width","12" );
      ((Element)v.get(775)).appendChild((Element)v.get(780));

      /* Empieza nodo:781 / Elemento padre: 780   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(781)).setAttribute("src","b.gif" );
      ((Element)v.get(781)).setAttribute("width","12" );
      ((Element)v.get(781)).setAttribute("height","1" );
      ((Element)v.get(780)).appendChild((Element)v.get(781));
      /* Termina nodo:781   */
      /* Termina nodo:780   */
      /* Termina nodo:775   */
      /* Termina nodo:662   */
      /* Termina nodo:661   */

      /* Empieza nodo:782 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(782)).setAttribute("nombre","capa5" );
      ((Element)v.get(782)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(13)).appendChild((Element)v.get(782));

      /* Empieza nodo:783 / Elemento padre: 782   */
      v.add(doc.createElement("table"));
      ((Element)v.get(783)).setAttribute("width","100%" );
   }

   private void getXML3150(Document doc) {
      ((Element)v.get(783)).setAttribute("border","0" );
      ((Element)v.get(783)).setAttribute("cellspacing","0" );
      ((Element)v.get(783)).setAttribute("cellpadding","0" );
      ((Element)v.get(782)).appendChild((Element)v.get(783));

      /* Empieza nodo:784 / Elemento padre: 783   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(783)).appendChild((Element)v.get(784));

      /* Empieza nodo:785 / Elemento padre: 784   */
      v.add(doc.createElement("td"));
      ((Element)v.get(785)).setAttribute("width","12" );
      ((Element)v.get(785)).setAttribute("align","center" );
      ((Element)v.get(784)).appendChild((Element)v.get(785));

      /* Empieza nodo:786 / Elemento padre: 785   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(786)).setAttribute("src","b.gif" );
      ((Element)v.get(786)).setAttribute("width","12" );
      ((Element)v.get(786)).setAttribute("height","12" );
      ((Element)v.get(785)).appendChild((Element)v.get(786));
      /* Termina nodo:786   */
      /* Termina nodo:785   */

      /* Empieza nodo:787 / Elemento padre: 784   */
      v.add(doc.createElement("td"));
      ((Element)v.get(787)).setAttribute("width","750" );
      ((Element)v.get(784)).appendChild((Element)v.get(787));

      /* Empieza nodo:788 / Elemento padre: 787   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(788)).setAttribute("src","b.gif" );
      ((Element)v.get(787)).appendChild((Element)v.get(788));
      /* Termina nodo:788   */
      /* Termina nodo:787   */

      /* Empieza nodo:789 / Elemento padre: 784   */
      v.add(doc.createElement("td"));
      ((Element)v.get(789)).setAttribute("width","12" );
      ((Element)v.get(784)).appendChild((Element)v.get(789));

      /* Empieza nodo:790 / Elemento padre: 789   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(790)).setAttribute("src","b.gif" );
      ((Element)v.get(790)).setAttribute("width","12" );
      ((Element)v.get(790)).setAttribute("height","1" );
      ((Element)v.get(789)).appendChild((Element)v.get(790));
      /* Termina nodo:790   */
      /* Termina nodo:789   */
      /* Termina nodo:784   */

      /* Empieza nodo:791 / Elemento padre: 783   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(783)).appendChild((Element)v.get(791));

      /* Empieza nodo:792 / Elemento padre: 791   */
      v.add(doc.createElement("td"));
      ((Element)v.get(791)).appendChild((Element)v.get(792));

      /* Empieza nodo:793 / Elemento padre: 792   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(793)).setAttribute("src","b.gif" );
      ((Element)v.get(792)).appendChild((Element)v.get(793));
      /* Termina nodo:793   */
      /* Termina nodo:792   */

      /* Empieza nodo:794 / Elemento padre: 791   */
      v.add(doc.createElement("td"));
      ((Element)v.get(791)).appendChild((Element)v.get(794));

      /* Empieza nodo:795 / Elemento padre: 794   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(794)).appendChild((Element)v.get(795));

      /* Empieza nodo:796 / Elemento padre: 795   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(796)).setAttribute("class","legend" );
      ((Element)v.get(795)).appendChild((Element)v.get(796));

      /* Empieza nodo:797 / Elemento padre: 796   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(797)).setAttribute("nombre","lblInformacionEstadoDocumento" );
      ((Element)v.get(797)).setAttribute("alto","13" );
      ((Element)v.get(797)).setAttribute("filas","1" );
      ((Element)v.get(797)).setAttribute("valor","" );
      ((Element)v.get(797)).setAttribute("id","legend" );
      ((Element)v.get(797)).setAttribute("cod","00184" );
      ((Element)v.get(796)).appendChild((Element)v.get(797));
      /* Termina nodo:797   */
      /* Termina nodo:796   */

      /* Empieza nodo:798 / Elemento padre: 795   */
      v.add(doc.createElement("table"));
      ((Element)v.get(798)).setAttribute("width","100%" );
      ((Element)v.get(798)).setAttribute("border","0" );
      ((Element)v.get(798)).setAttribute("align","center" );
      ((Element)v.get(798)).setAttribute("cellspacing","0" );
      ((Element)v.get(798)).setAttribute("cellpadding","0" );
      ((Element)v.get(795)).appendChild((Element)v.get(798));

      /* Empieza nodo:799 / Elemento padre: 798   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(798)).appendChild((Element)v.get(799));

      /* Empieza nodo:800 / Elemento padre: 799   */
      v.add(doc.createElement("td"));
      ((Element)v.get(799)).appendChild((Element)v.get(800));

      /* Empieza nodo:801 / Elemento padre: 800   */
      v.add(doc.createElement("table"));
      ((Element)v.get(801)).setAttribute("width","655" );
      ((Element)v.get(801)).setAttribute("border","0" );
      ((Element)v.get(801)).setAttribute("align","left" );
      ((Element)v.get(801)).setAttribute("cellspacing","0" );
      ((Element)v.get(801)).setAttribute("cellpadding","0" );
      ((Element)v.get(800)).appendChild((Element)v.get(801));

      /* Empieza nodo:802 / Elemento padre: 801   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(801)).appendChild((Element)v.get(802));

      /* Empieza nodo:803 / Elemento padre: 802   */
      v.add(doc.createElement("td"));
      ((Element)v.get(803)).setAttribute("colspan","3" );
      ((Element)v.get(802)).appendChild((Element)v.get(803));

      /* Empieza nodo:804 / Elemento padre: 803   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(804)).setAttribute("src","b.gif" );
      ((Element)v.get(804)).setAttribute("width","8" );
      ((Element)v.get(804)).setAttribute("height","8" );
      ((Element)v.get(803)).appendChild((Element)v.get(804));
      /* Termina nodo:804   */
      /* Termina nodo:803   */
      /* Termina nodo:802   */

      /* Empieza nodo:805 / Elemento padre: 801   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(801)).appendChild((Element)v.get(805));

      /* Empieza nodo:806 / Elemento padre: 805   */
      v.add(doc.createElement("td"));
      ((Element)v.get(805)).appendChild((Element)v.get(806));

      /* Empieza nodo:807 / Elemento padre: 806   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(807)).setAttribute("src","b.gif" );
      ((Element)v.get(807)).setAttribute("width","8" );
      ((Element)v.get(807)).setAttribute("height","8" );
      ((Element)v.get(806)).appendChild((Element)v.get(807));
      /* Termina nodo:807   */
      /* Termina nodo:806   */

      /* Empieza nodo:808 / Elemento padre: 805   */
      v.add(doc.createElement("td"));
      ((Element)v.get(805)).appendChild((Element)v.get(808));

      /* Empieza nodo:809 / Elemento padre: 808   */
   }

   private void getXML3240(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(809)).setAttribute("nombre","lblFechaPrevistaFacturacion" );
      ((Element)v.get(809)).setAttribute("alto","13" );
      ((Element)v.get(809)).setAttribute("filas","1" );
      ((Element)v.get(809)).setAttribute("valor","" );
      ((Element)v.get(809)).setAttribute("id","datosTitle" );
      ((Element)v.get(809)).setAttribute("cod","2352" );
      ((Element)v.get(808)).appendChild((Element)v.get(809));
      /* Termina nodo:809   */
      /* Termina nodo:808   */

      /* Empieza nodo:810 / Elemento padre: 805   */
      v.add(doc.createElement("td"));
      ((Element)v.get(805)).appendChild((Element)v.get(810));

      /* Empieza nodo:811 / Elemento padre: 810   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(811)).setAttribute("src","b.gif" );
      ((Element)v.get(811)).setAttribute("width","25" );
      ((Element)v.get(811)).setAttribute("height","8" );
      ((Element)v.get(810)).appendChild((Element)v.get(811));
      /* Termina nodo:811   */
      /* Termina nodo:810   */

      /* Empieza nodo:812 / Elemento padre: 805   */
      v.add(doc.createElement("td"));
      ((Element)v.get(805)).appendChild((Element)v.get(812));

      /* Empieza nodo:813 / Elemento padre: 812   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(813)).setAttribute("nombre","lblFechaFacturacion" );
      ((Element)v.get(813)).setAttribute("alto","13" );
      ((Element)v.get(813)).setAttribute("filas","1" );
      ((Element)v.get(813)).setAttribute("valor","" );
      ((Element)v.get(813)).setAttribute("id","datosTitle" );
      ((Element)v.get(813)).setAttribute("cod","876" );
      ((Element)v.get(812)).appendChild((Element)v.get(813));
      /* Termina nodo:813   */
      /* Termina nodo:812   */

      /* Empieza nodo:814 / Elemento padre: 805   */
      v.add(doc.createElement("td"));
      ((Element)v.get(805)).appendChild((Element)v.get(814));

      /* Empieza nodo:815 / Elemento padre: 814   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(815)).setAttribute("src","b.gif" );
      ((Element)v.get(815)).setAttribute("width","25" );
      ((Element)v.get(815)).setAttribute("height","8" );
      ((Element)v.get(814)).appendChild((Element)v.get(815));
      /* Termina nodo:815   */
      /* Termina nodo:814   */

      /* Empieza nodo:816 / Elemento padre: 805   */
      v.add(doc.createElement("td"));
      ((Element)v.get(805)).appendChild((Element)v.get(816));

      /* Empieza nodo:817 / Elemento padre: 816   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(817)).setAttribute("nombre","lblEstadoCredito" );
      ((Element)v.get(817)).setAttribute("alto","13" );
      ((Element)v.get(817)).setAttribute("filas","1" );
      ((Element)v.get(817)).setAttribute("valor","" );
      ((Element)v.get(817)).setAttribute("id","datosTitle" );
      ((Element)v.get(817)).setAttribute("cod","1422" );
      ((Element)v.get(816)).appendChild((Element)v.get(817));
      /* Termina nodo:817   */
      /* Termina nodo:816   */

      /* Empieza nodo:818 / Elemento padre: 805   */
      v.add(doc.createElement("td"));
      ((Element)v.get(805)).appendChild((Element)v.get(818));

      /* Empieza nodo:819 / Elemento padre: 818   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(819)).setAttribute("src","b.gif" );
      ((Element)v.get(819)).setAttribute("width","25" );
      ((Element)v.get(819)).setAttribute("height","8" );
      ((Element)v.get(818)).appendChild((Element)v.get(819));
      /* Termina nodo:819   */
      /* Termina nodo:818   */

      /* Empieza nodo:820 / Elemento padre: 805   */
      v.add(doc.createElement("td"));
      ((Element)v.get(805)).appendChild((Element)v.get(820));

      /* Empieza nodo:821 / Elemento padre: 820   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(821)).setAttribute("nombre","lblGrupoProcesos" );
      ((Element)v.get(821)).setAttribute("alto","13" );
      ((Element)v.get(821)).setAttribute("filas","1" );
      ((Element)v.get(821)).setAttribute("valor","" );
      ((Element)v.get(821)).setAttribute("id","datosTitle" );
      ((Element)v.get(821)).setAttribute("cod","1466" );
      ((Element)v.get(820)).appendChild((Element)v.get(821));
      /* Termina nodo:821   */
      /* Termina nodo:820   */

      /* Empieza nodo:822 / Elemento padre: 805   */
      v.add(doc.createElement("td"));
      ((Element)v.get(822)).setAttribute("width","100%" );
      ((Element)v.get(805)).appendChild((Element)v.get(822));

      /* Empieza nodo:823 / Elemento padre: 822   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(823)).setAttribute("src","b.gif" );
      ((Element)v.get(823)).setAttribute("width","8" );
      ((Element)v.get(823)).setAttribute("height","8" );
      ((Element)v.get(822)).appendChild((Element)v.get(823));
      /* Termina nodo:823   */
      /* Termina nodo:822   */
      /* Termina nodo:805   */

      /* Empieza nodo:824 / Elemento padre: 801   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(801)).appendChild((Element)v.get(824));

      /* Empieza nodo:825 / Elemento padre: 824   */
      v.add(doc.createElement("td"));
      ((Element)v.get(824)).appendChild((Element)v.get(825));

      /* Empieza nodo:826 / Elemento padre: 825   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(826)).setAttribute("src","b.gif" );
      ((Element)v.get(826)).setAttribute("width","8" );
      ((Element)v.get(826)).setAttribute("height","8" );
      ((Element)v.get(825)).appendChild((Element)v.get(826));
      /* Termina nodo:826   */
      /* Termina nodo:825   */

      /* Empieza nodo:827 / Elemento padre: 824   */
      v.add(doc.createElement("td"));
      ((Element)v.get(824)).appendChild((Element)v.get(827));

      /* Empieza nodo:828 / Elemento padre: 827   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(828)).setAttribute("nombre","txtFechaPrevistaFacturacion" );
      ((Element)v.get(828)).setAttribute("id","datosCampos" );
      ((Element)v.get(828)).setAttribute("max","10" );
      ((Element)v.get(828)).setAttribute("tipo","" );
      ((Element)v.get(828)).setAttribute("onchange","" );
      ((Element)v.get(828)).setAttribute("req","N" );
      ((Element)v.get(828)).setAttribute("size","12" );
      ((Element)v.get(828)).setAttribute("valor","" );
      ((Element)v.get(828)).setAttribute("validacion","" );
      ((Element)v.get(828)).setAttribute("ontab","tabGenerico('txtFechaPrevistaFacturacion');" );
      ((Element)v.get(828)).setAttribute("onshtab","tabGenerico('txtFechaPrevistaFacturacion','sh');" );
   }

   private void getXML3330(Document doc) {
      ((Element)v.get(827)).appendChild((Element)v.get(828));
      /* Termina nodo:828   */
      /* Termina nodo:827   */

      /* Empieza nodo:829 / Elemento padre: 824   */
      v.add(doc.createElement("td"));
      ((Element)v.get(824)).appendChild((Element)v.get(829));

      /* Empieza nodo:830 / Elemento padre: 829   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(830)).setAttribute("src","b.gif" );
      ((Element)v.get(830)).setAttribute("width","25" );
      ((Element)v.get(830)).setAttribute("height","8" );
      ((Element)v.get(829)).appendChild((Element)v.get(830));
      /* Termina nodo:830   */
      /* Termina nodo:829   */

      /* Empieza nodo:831 / Elemento padre: 824   */
      v.add(doc.createElement("td"));
      ((Element)v.get(824)).appendChild((Element)v.get(831));

      /* Empieza nodo:832 / Elemento padre: 831   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(832)).setAttribute("nombre","lblFechaFacturacionXX" );
      ((Element)v.get(832)).setAttribute("alto","13" );
      ((Element)v.get(832)).setAttribute("filas","1" );
      ((Element)v.get(832)).setAttribute("valor","xx-xx-xxxx" );
      ((Element)v.get(832)).setAttribute("id","datosCampos" );
      ((Element)v.get(831)).appendChild((Element)v.get(832));
      /* Termina nodo:832   */
      /* Termina nodo:831   */

      /* Empieza nodo:833 / Elemento padre: 824   */
      v.add(doc.createElement("td"));
      ((Element)v.get(824)).appendChild((Element)v.get(833));

      /* Empieza nodo:834 / Elemento padre: 833   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(834)).setAttribute("src","b.gif" );
      ((Element)v.get(834)).setAttribute("width","25" );
      ((Element)v.get(834)).setAttribute("height","8" );
      ((Element)v.get(833)).appendChild((Element)v.get(834));
      /* Termina nodo:834   */
      /* Termina nodo:833   */

      /* Empieza nodo:835 / Elemento padre: 824   */
      v.add(doc.createElement("td"));
      ((Element)v.get(824)).appendChild((Element)v.get(835));

      /* Empieza nodo:836 / Elemento padre: 835   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(836)).setAttribute("nombre","lblEstadoCreditoXX" );
      ((Element)v.get(836)).setAttribute("alto","13" );
      ((Element)v.get(836)).setAttribute("filas","1" );
      ((Element)v.get(836)).setAttribute("valor","xx1" );
      ((Element)v.get(836)).setAttribute("id","datosCampos" );
      ((Element)v.get(835)).appendChild((Element)v.get(836));
      /* Termina nodo:836   */
      /* Termina nodo:835   */

      /* Empieza nodo:837 / Elemento padre: 824   */
      v.add(doc.createElement("td"));
      ((Element)v.get(824)).appendChild((Element)v.get(837));

      /* Empieza nodo:838 / Elemento padre: 837   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(838)).setAttribute("src","b.gif" );
      ((Element)v.get(838)).setAttribute("width","25" );
      ((Element)v.get(838)).setAttribute("height","8" );
      ((Element)v.get(837)).appendChild((Element)v.get(838));
      /* Termina nodo:838   */
      /* Termina nodo:837   */

      /* Empieza nodo:839 / Elemento padre: 824   */
      v.add(doc.createElement("td"));
      ((Element)v.get(824)).appendChild((Element)v.get(839));

      /* Empieza nodo:840 / Elemento padre: 839   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(840)).setAttribute("nombre","lblGrupoProcesosXX" );
      ((Element)v.get(840)).setAttribute("alto","13" );
      ((Element)v.get(840)).setAttribute("filas","1" );
      ((Element)v.get(840)).setAttribute("valor","" );
      ((Element)v.get(840)).setAttribute("id","datosCampos" );
      ((Element)v.get(839)).appendChild((Element)v.get(840));
      /* Termina nodo:840   */
      /* Termina nodo:839   */

      /* Empieza nodo:841 / Elemento padre: 824   */
      v.add(doc.createElement("td"));
      ((Element)v.get(841)).setAttribute("width","100%" );
      ((Element)v.get(824)).appendChild((Element)v.get(841));

      /* Empieza nodo:842 / Elemento padre: 841   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(842)).setAttribute("src","b.gif" );
      ((Element)v.get(842)).setAttribute("width","8" );
      ((Element)v.get(842)).setAttribute("height","8" );
      ((Element)v.get(841)).appendChild((Element)v.get(842));
      /* Termina nodo:842   */
      /* Termina nodo:841   */
      /* Termina nodo:824   */

      /* Empieza nodo:843 / Elemento padre: 801   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(801)).appendChild((Element)v.get(843));

      /* Empieza nodo:844 / Elemento padre: 843   */
      v.add(doc.createElement("td"));
      ((Element)v.get(844)).setAttribute("colspan","3" );
      ((Element)v.get(843)).appendChild((Element)v.get(844));

      /* Empieza nodo:845 / Elemento padre: 844   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(845)).setAttribute("src","b.gif" );
      ((Element)v.get(845)).setAttribute("width","8" );
      ((Element)v.get(845)).setAttribute("height","7" );
      ((Element)v.get(844)).appendChild((Element)v.get(845));
      /* Termina nodo:845   */
      /* Termina nodo:844   */
      /* Termina nodo:843   */
      /* Termina nodo:801   */
      /* Termina nodo:800   */
      /* Termina nodo:799   */

      /* Empieza nodo:846 / Elemento padre: 798   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(798)).appendChild((Element)v.get(846));

      /* Empieza nodo:847 / Elemento padre: 846   */
      v.add(doc.createElement("td"));
      ((Element)v.get(846)).appendChild((Element)v.get(847));

      /* Empieza nodo:848 / Elemento padre: 847   */
      v.add(doc.createElement("table"));
      ((Element)v.get(848)).setAttribute("width","655" );
      ((Element)v.get(848)).setAttribute("border","0" );
      ((Element)v.get(848)).setAttribute("align","left" );
      ((Element)v.get(848)).setAttribute("cellspacing","0" );
      ((Element)v.get(848)).setAttribute("cellpadding","0" );
      ((Element)v.get(847)).appendChild((Element)v.get(848));

      /* Empieza nodo:849 / Elemento padre: 848   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(848)).appendChild((Element)v.get(849));

      /* Empieza nodo:850 / Elemento padre: 849   */
      v.add(doc.createElement("td"));
      ((Element)v.get(849)).appendChild((Element)v.get(850));

      /* Empieza nodo:851 / Elemento padre: 850   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(851)).setAttribute("src","b.gif" );
      ((Element)v.get(851)).setAttribute("width","8" );
      ((Element)v.get(851)).setAttribute("height","8" );
      ((Element)v.get(850)).appendChild((Element)v.get(851));
      /* Termina nodo:851   */
      /* Termina nodo:850   */

      /* Empieza nodo:852 / Elemento padre: 849   */
      v.add(doc.createElement("td"));
      ((Element)v.get(849)).appendChild((Element)v.get(852));

      /* Empieza nodo:853 / Elemento padre: 852   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML3420(Document doc) {
      ((Element)v.get(853)).setAttribute("nombre","lblProcesoValidacion" );
      ((Element)v.get(853)).setAttribute("alto","13" );
      ((Element)v.get(853)).setAttribute("filas","1" );
      ((Element)v.get(853)).setAttribute("valor","" );
      ((Element)v.get(853)).setAttribute("id","datosTitle" );
      ((Element)v.get(853)).setAttribute("cod","1399" );
      ((Element)v.get(852)).appendChild((Element)v.get(853));
      /* Termina nodo:853   */
      /* Termina nodo:852   */

      /* Empieza nodo:854 / Elemento padre: 849   */
      v.add(doc.createElement("td"));
      ((Element)v.get(849)).appendChild((Element)v.get(854));

      /* Empieza nodo:855 / Elemento padre: 854   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(855)).setAttribute("src","b.gif" );
      ((Element)v.get(855)).setAttribute("width","25" );
      ((Element)v.get(855)).setAttribute("height","8" );
      ((Element)v.get(854)).appendChild((Element)v.get(855));
      /* Termina nodo:855   */
      /* Termina nodo:854   */

      /* Empieza nodo:856 / Elemento padre: 849   */
      v.add(doc.createElement("td"));
      ((Element)v.get(849)).appendChild((Element)v.get(856));

      /* Empieza nodo:857 / Elemento padre: 856   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(857)).setAttribute("nombre","lblEstadoSolicitud" );
      ((Element)v.get(857)).setAttribute("alto","13" );
      ((Element)v.get(857)).setAttribute("filas","1" );
      ((Element)v.get(857)).setAttribute("valor","" );
      ((Element)v.get(857)).setAttribute("id","datosTitle" );
      ((Element)v.get(857)).setAttribute("cod","1400" );
      ((Element)v.get(856)).appendChild((Element)v.get(857));
      /* Termina nodo:857   */
      /* Termina nodo:856   */

      /* Empieza nodo:858 / Elemento padre: 849   */
      v.add(doc.createElement("td"));
      ((Element)v.get(858)).setAttribute("width","100%" );
      ((Element)v.get(849)).appendChild((Element)v.get(858));

      /* Empieza nodo:859 / Elemento padre: 858   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(859)).setAttribute("src","b.gif" );
      ((Element)v.get(859)).setAttribute("width","8" );
      ((Element)v.get(859)).setAttribute("height","8" );
      ((Element)v.get(858)).appendChild((Element)v.get(859));
      /* Termina nodo:859   */
      /* Termina nodo:858   */
      /* Termina nodo:849   */

      /* Empieza nodo:860 / Elemento padre: 848   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(848)).appendChild((Element)v.get(860));

      /* Empieza nodo:861 / Elemento padre: 860   */
      v.add(doc.createElement("td"));
      ((Element)v.get(860)).appendChild((Element)v.get(861));

      /* Empieza nodo:862 / Elemento padre: 861   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(862)).setAttribute("src","b.gif" );
      ((Element)v.get(862)).setAttribute("width","8" );
      ((Element)v.get(862)).setAttribute("height","8" );
      ((Element)v.get(861)).appendChild((Element)v.get(862));
      /* Termina nodo:862   */
      /* Termina nodo:861   */

      /* Empieza nodo:863 / Elemento padre: 860   */
      v.add(doc.createElement("td"));
      ((Element)v.get(860)).appendChild((Element)v.get(863));

      /* Empieza nodo:864 / Elemento padre: 863   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(864)).setAttribute("nombre","lblProcesoValidacionXX" );
      ((Element)v.get(864)).setAttribute("alto","13" );
      ((Element)v.get(864)).setAttribute("filas","1" );
      ((Element)v.get(864)).setAttribute("valor","" );
      ((Element)v.get(864)).setAttribute("id","datosCampos" );
      ((Element)v.get(863)).appendChild((Element)v.get(864));
      /* Termina nodo:864   */
      /* Termina nodo:863   */

      /* Empieza nodo:865 / Elemento padre: 860   */
      v.add(doc.createElement("td"));
      ((Element)v.get(860)).appendChild((Element)v.get(865));

      /* Empieza nodo:866 / Elemento padre: 865   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(866)).setAttribute("src","b.gif" );
      ((Element)v.get(866)).setAttribute("width","25" );
      ((Element)v.get(866)).setAttribute("height","8" );
      ((Element)v.get(865)).appendChild((Element)v.get(866));
      /* Termina nodo:866   */
      /* Termina nodo:865   */

      /* Empieza nodo:867 / Elemento padre: 860   */
      v.add(doc.createElement("td"));
      ((Element)v.get(860)).appendChild((Element)v.get(867));

      /* Empieza nodo:868 / Elemento padre: 867   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(868)).setAttribute("nombre","lblEstadoSolicitudXX" );
      ((Element)v.get(868)).setAttribute("alto","13" );
      ((Element)v.get(868)).setAttribute("filas","1" );
      ((Element)v.get(868)).setAttribute("valor","" );
      ((Element)v.get(868)).setAttribute("id","datosCampos" );
      ((Element)v.get(867)).appendChild((Element)v.get(868));
      /* Termina nodo:868   */
      /* Termina nodo:867   */

      /* Empieza nodo:869 / Elemento padre: 860   */
      v.add(doc.createElement("td"));
      ((Element)v.get(869)).setAttribute("width","100%" );
      ((Element)v.get(860)).appendChild((Element)v.get(869));

      /* Empieza nodo:870 / Elemento padre: 869   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(870)).setAttribute("src","b.gif" );
      ((Element)v.get(870)).setAttribute("width","8" );
      ((Element)v.get(870)).setAttribute("height","8" );
      ((Element)v.get(869)).appendChild((Element)v.get(870));
      /* Termina nodo:870   */
      /* Termina nodo:869   */
      /* Termina nodo:860   */

      /* Empieza nodo:871 / Elemento padre: 848   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(848)).appendChild((Element)v.get(871));

      /* Empieza nodo:872 / Elemento padre: 871   */
      v.add(doc.createElement("td"));
      ((Element)v.get(872)).setAttribute("colspan","3" );
      ((Element)v.get(871)).appendChild((Element)v.get(872));

      /* Empieza nodo:873 / Elemento padre: 872   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(873)).setAttribute("src","b.gif" );
      ((Element)v.get(873)).setAttribute("width","8" );
      ((Element)v.get(873)).setAttribute("height","8" );
      ((Element)v.get(872)).appendChild((Element)v.get(873));
      /* Termina nodo:873   */
      /* Termina nodo:872   */
      /* Termina nodo:871   */
      /* Termina nodo:848   */
      /* Termina nodo:847   */
      /* Termina nodo:846   */
      /* Termina nodo:798   */
      /* Termina nodo:795   */
      /* Termina nodo:794   */

      /* Empieza nodo:874 / Elemento padre: 791   */
      v.add(doc.createElement("td"));
      ((Element)v.get(791)).appendChild((Element)v.get(874));

      /* Empieza nodo:875 / Elemento padre: 874   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(875)).setAttribute("src","b.gif" );
      ((Element)v.get(874)).appendChild((Element)v.get(875));
      /* Termina nodo:875   */
      /* Termina nodo:874   */
      /* Termina nodo:791   */

      /* Empieza nodo:876 / Elemento padre: 783   */
      v.add(doc.createElement("tr"));
   }

   private void getXML3510(Document doc) {
      ((Element)v.get(783)).appendChild((Element)v.get(876));

      /* Empieza nodo:877 / Elemento padre: 876   */
      v.add(doc.createElement("td"));
      ((Element)v.get(876)).appendChild((Element)v.get(877));

      /* Empieza nodo:878 / Elemento padre: 877   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(878)).setAttribute("src","b.gif" );
      ((Element)v.get(877)).appendChild((Element)v.get(878));
      /* Termina nodo:878   */
      /* Termina nodo:877   */

      /* Empieza nodo:879 / Elemento padre: 876   */
      v.add(doc.createElement("td"));
      ((Element)v.get(876)).appendChild((Element)v.get(879));

      /* Empieza nodo:880 / Elemento padre: 879   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(879)).appendChild((Element)v.get(880));

      /* Empieza nodo:881 / Elemento padre: 880   */
      v.add(doc.createElement("table"));
      ((Element)v.get(881)).setAttribute("width","100%" );
      ((Element)v.get(881)).setAttribute("border","0" );
      ((Element)v.get(881)).setAttribute("align","center" );
      ((Element)v.get(881)).setAttribute("cellspacing","0" );
      ((Element)v.get(881)).setAttribute("cellpadding","0" );
      ((Element)v.get(880)).appendChild((Element)v.get(881));

      /* Empieza nodo:882 / Elemento padre: 881   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(881)).appendChild((Element)v.get(882));

      /* Empieza nodo:883 / Elemento padre: 882   */
      v.add(doc.createElement("td"));
      ((Element)v.get(883)).setAttribute("class","botonera" );
      ((Element)v.get(882)).appendChild((Element)v.get(883));

      /* Empieza nodo:884 / Elemento padre: 883   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(884)).setAttribute("nombre","btnVisualizarPosicion5" );
      ((Element)v.get(884)).setAttribute("ID","botonContenido" );
      ((Element)v.get(884)).setAttribute("tipo","html" );
      ((Element)v.get(884)).setAttribute("accion","accionVisualizarPosiciones();" );
      ((Element)v.get(884)).setAttribute("estado","false" );
      ((Element)v.get(884)).setAttribute("cod","2762" );
      ((Element)v.get(884)).setAttribute("ontab","tabGenerico('btnVisualizarPosicion5');" );
      ((Element)v.get(884)).setAttribute("onshtab","tabGenerico('btnVisualizarPosicion5','sh');" );
      ((Element)v.get(883)).appendChild((Element)v.get(884));
      /* Termina nodo:884   */

      /* Empieza nodo:885 / Elemento padre: 883   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(885)).setAttribute("nombre","btnModificarPosicion5" );
      ((Element)v.get(885)).setAttribute("ID","botonContenido" );
      ((Element)v.get(885)).setAttribute("tipo","html" );
      ((Element)v.get(885)).setAttribute("accion","accionModificarPosiciones();" );
      ((Element)v.get(885)).setAttribute("estado","false" );
      ((Element)v.get(885)).setAttribute("cod","2763" );
      ((Element)v.get(885)).setAttribute("ontab","tabGenerico('btnModificarPosicion5');" );
      ((Element)v.get(885)).setAttribute("onshtab","tabGenerico('btnModificarPosicion5','sh');" );
      ((Element)v.get(883)).appendChild((Element)v.get(885));
      /* Termina nodo:885   */
      /* Termina nodo:883   */
      /* Termina nodo:882   */
      /* Termina nodo:881   */
      /* Termina nodo:880   */
      /* Termina nodo:879   */

      /* Empieza nodo:886 / Elemento padre: 876   */
      v.add(doc.createElement("td"));
      ((Element)v.get(876)).appendChild((Element)v.get(886));

      /* Empieza nodo:887 / Elemento padre: 886   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(887)).setAttribute("src","b.gif" );
      ((Element)v.get(887)).setAttribute("width","8" );
      ((Element)v.get(887)).setAttribute("height","12" );
      ((Element)v.get(886)).appendChild((Element)v.get(887));
      /* Termina nodo:887   */
      /* Termina nodo:886   */
      /* Termina nodo:876   */

      /* Empieza nodo:888 / Elemento padre: 783   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(783)).appendChild((Element)v.get(888));

      /* Empieza nodo:889 / Elemento padre: 888   */
      v.add(doc.createElement("td"));
      ((Element)v.get(889)).setAttribute("width","12" );
      ((Element)v.get(889)).setAttribute("align","center" );
      ((Element)v.get(888)).appendChild((Element)v.get(889));

      /* Empieza nodo:890 / Elemento padre: 889   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(890)).setAttribute("src","b.gif" );
      ((Element)v.get(890)).setAttribute("width","12" );
      ((Element)v.get(890)).setAttribute("height","12" );
      ((Element)v.get(889)).appendChild((Element)v.get(890));
      /* Termina nodo:890   */
      /* Termina nodo:889   */

      /* Empieza nodo:891 / Elemento padre: 888   */
      v.add(doc.createElement("td"));
      ((Element)v.get(891)).setAttribute("width","756" );
      ((Element)v.get(888)).appendChild((Element)v.get(891));

      /* Empieza nodo:892 / Elemento padre: 891   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(892)).setAttribute("src","b.gif" );
      ((Element)v.get(891)).appendChild((Element)v.get(892));
      /* Termina nodo:892   */
      /* Termina nodo:891   */

      /* Empieza nodo:893 / Elemento padre: 888   */
      v.add(doc.createElement("td"));
      ((Element)v.get(893)).setAttribute("width","12" );
      ((Element)v.get(888)).appendChild((Element)v.get(893));

      /* Empieza nodo:894 / Elemento padre: 893   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(894)).setAttribute("src","b.gif" );
      ((Element)v.get(894)).setAttribute("width","12" );
      ((Element)v.get(894)).setAttribute("height","1" );
      ((Element)v.get(893)).appendChild((Element)v.get(894));
      /* Termina nodo:894   */
      /* Termina nodo:893   */
      /* Termina nodo:888   */
      /* Termina nodo:783   */
      /* Termina nodo:782   */
      /* Termina nodo:13   */


   }

}


import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_actividades_insertar_mav  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_actividades_insertar" );
      ((Element)v.get(0)).setAttribute("cod","050" );
      ((Element)v.get(0)).setAttribute("titulo","Insertar actividades" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Insertar actividades" );
      ((Element)v.get(0)).setAttribute("onload","onLoad()" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","contenido_actividades_insertar_mav.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(6)).setAttribute("name","txtDescripcionActividad" );
      ((Element)v.get(6)).setAttribute("required","true" );
      ((Element)v.get(6)).setAttribute("cod","9" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","areatxtObservaciones" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("format","t" );
      ((Element)v.get(7)).setAttribute("max","100" );
      ((Element)v.get(7)).setAttribute("cod","843" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbMarca" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","6" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbCanal" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","7" );
      ((Element)v.get(5)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbTipoCliente" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","393" );
      ((Element)v.get(5)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbTipoOferta" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","608" );
      ((Element)v.get(5)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","cbCicloVida" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","581" );
      ((Element)v.get(5)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","cbTipoDespacho" );
      ((Element)v.get(13)).setAttribute("required","true" );
      ((Element)v.get(13)).setAttribute("cod","1000" );
      ((Element)v.get(5)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","cbCondicionPago" );
      ((Element)v.get(14)).setAttribute("required","true" );
      ((Element)v.get(14)).setAttribute("cod","830" );
      ((Element)v.get(5)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(15)).setAttribute("name","cbFormaPago" );
      ((Element)v.get(15)).setAttribute("required","false" );
      ((Element)v.get(15)).setAttribute("cod","541" );
      ((Element)v.get(5)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(16)).setAttribute("name","cbCriterioAsignacion" );
      ((Element)v.get(16)).setAttribute("required","true" );
      ((Element)v.get(16)).setAttribute("cod","838" );
      ((Element)v.get(5)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(17)).setAttribute("name","cbEnvioSolicitud" );
      ((Element)v.get(17)).setAttribute("required","false" );
      ((Element)v.get(17)).setAttribute("cod","859" );
      ((Element)v.get(5)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(18)).setAttribute("name","cbTipoSolicitudOrigen" );
      ((Element)v.get(18)).setAttribute("required","false" );
      ((Element)v.get(18)).setAttribute("cod","1005" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(5)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(19)).setAttribute("name","cbTipoSolicitudDestino" );
      ((Element)v.get(19)).setAttribute("required","false" );
      ((Element)v.get(19)).setAttribute("cod","1004" );
      ((Element)v.get(5)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(20)).setAttribute("name","cbTipoPosicionEnvio" );
      ((Element)v.get(20)).setAttribute("required","false" );
      ((Element)v.get(20)).setAttribute("cod","1002" );
      ((Element)v.get(5)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(21)).setAttribute("name","cbSubtipoPosicionEnvio" );
      ((Element)v.get(21)).setAttribute("required","false" );
      ((Element)v.get(21)).setAttribute("cod","2587" );
      ((Element)v.get(5)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(22)).setAttribute("name","cbSubtipoCliente" );
      ((Element)v.get(22)).setAttribute("required","false" );
      ((Element)v.get(22)).setAttribute("cod","595" );
      ((Element)v.get(5)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(23)).setAttribute("name","FacturaIntercompanias" );
      ((Element)v.get(23)).setAttribute("required","false" );
      ((Element)v.get(23)).setAttribute("cod","1378" );
      ((Element)v.get(5)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(24)).setAttribute("name","cbRazonSocial" );
      ((Element)v.get(24)).setAttribute("required","false" );
      ((Element)v.get(24)).setAttribute("cod","1381" );
      ((Element)v.get(5)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(25)).setAttribute("name","txtRazonSocialF" );
      ((Element)v.get(25)).setAttribute("required","false" );
      ((Element)v.get(25)).setAttribute("cod","1382" );
      ((Element)v.get(5)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(26)).setAttribute("name","cbTipoSolicitudPago" );
      ((Element)v.get(26)).setAttribute("required","false" );
      ((Element)v.get(26)).setAttribute("cod","1383" );
      ((Element)v.get(5)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */
      /* Termina nodo:5   */

      /* Empieza nodo:27 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(27)).setAttribute("nombre","frmInsertarActividades" );
      ((Element)v.get(27)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","accion" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(29)).setAttribute("valor","LPMantenimientoActividadesMAV" );
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
      ((Element)v.get(32)).setAttribute("nombre","casodeuso" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","oidCliente" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","oidClienteAnterior" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","oidIdioma" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","oidPais" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","oidActividad" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","marca" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(39)).setAttribute("nombre","campagnaEvaluacion" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","cicloVida" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","criterioAsignacion" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","estados" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","isFacturaIntercompanias" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","canal" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","envioConSolicitud" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","formaPago" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","tipoCondicionPago" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","tipoPosicionDestino" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","tipoPosicionParaPago" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","tipoSolicitudDestino" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","tipoSolicitudParaPago" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","razonSocialQueFactura" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","subtipoCliente" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","tipoCliente" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","tipoDespacho" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","tipoOferta" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","tipoSolicitudOrigen" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","Limpiar" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","tipoPosicionEnvio" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","subtipoPosicionEnvio" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","condicionPago" );
      ((Element)v.get(61)).setAttribute("valor","" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(27)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","subtipoPosicionPago" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(63)).setAttribute("nombre","operacionMAV012" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(64)).setAttribute("nombre","operacionMAV023" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 27   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(65)).setAttribute("nombre","subtiposCliente" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(27)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 27   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(66)).setAttribute("nombre","capa1" );
      ((Element)v.get(27)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("table"));
      ((Element)v.get(67)).setAttribute("width","100%" );
      ((Element)v.get(67)).setAttribute("border","0" );
      ((Element)v.get(67)).setAttribute("cellspacing","0" );
      ((Element)v.get(67)).setAttribute("cellpadding","0" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(69)).setAttribute("width","12" );
      ((Element)v.get(69)).setAttribute("align","center" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(70)).setAttribute("width","12" );
      ((Element)v.get(70)).setAttribute("height","12" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).setAttribute("width","750" );
      ((Element)v.get(68)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).setAttribute("width","12" );
      ((Element)v.get(68)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","12" );
      ((Element)v.get(74)).setAttribute("height","1" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:68   */

      /* Empieza nodo:75 / Elemento padre: 67   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(67)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(80)).setAttribute("class","legend" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(81)).setAttribute("nombre","lblActividades" );
      ((Element)v.get(81)).setAttribute("alto","13" );
      ((Element)v.get(81)).setAttribute("filas","1" );
      ((Element)v.get(81)).setAttribute("cod","0051" );
      ((Element)v.get(81)).setAttribute("id","legend" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 79   */
      v.add(doc.createElement("table"));
      ((Element)v.get(82)).setAttribute("width","100%" );
      ((Element)v.get(82)).setAttribute("border","0" );
      ((Element)v.get(82)).setAttribute("align","center" );
      ((Element)v.get(82)).setAttribute("cellspacing","0" );
      ((Element)v.get(82)).setAttribute("cellpadding","0" );
      ((Element)v.get(79)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("table"));
      ((Element)v.get(85)).setAttribute("width","711" );
      ((Element)v.get(85)).setAttribute("border","0" );
      ((Element)v.get(85)).setAttribute("align","left" );
      ((Element)v.get(85)).setAttribute("cellspacing","0" );
      ((Element)v.get(85)).setAttribute("cellpadding","0" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
   }

   private void getXML360(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(85)).appendChild((Element)v.get(86));

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

      /* Empieza nodo:89 / Elemento padre: 85   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(85)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).setAttribute("width","8" );
      ((Element)v.get(91)).setAttribute("height","8" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(93)).setAttribute("nombre","lblPais" );
      ((Element)v.get(93)).setAttribute("alto","13" );
      ((Element)v.get(93)).setAttribute("filas","1" );
      ((Element)v.get(93)).setAttribute("valor","" );
      ((Element)v.get(93)).setAttribute("id","datosTitle" );
      ((Element)v.get(93)).setAttribute("cod","5" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","25" );
      ((Element)v.get(95)).setAttribute("height","8" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(97)).setAttribute("nombre","lblCodActividad" );
      ((Element)v.get(97)).setAttribute("alto","13" );
      ((Element)v.get(97)).setAttribute("filas","1" );
      ((Element)v.get(97)).setAttribute("valor","" );
      ((Element)v.get(97)).setAttribute("id","datosTitle" );
      ((Element)v.get(97)).setAttribute("cod","151" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(89)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","25" );
      ((Element)v.get(99)).setAttribute("height","8" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).setAttribute("colspan","3" );
      ((Element)v.get(89)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(101)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(101)).setAttribute("alto","13" );
      ((Element)v.get(101)).setAttribute("filas","1" );
      ((Element)v.get(101)).setAttribute("valor","" );
      ((Element)v.get(101)).setAttribute("id","datosTitle" );
      ((Element)v.get(101)).setAttribute("cod","9" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 89   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).setAttribute("width","100%" );
      ((Element)v.get(89)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","8" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:89   */

      /* Empieza nodo:104 / Elemento padre: 85   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(85)).appendChild((Element)v.get(104));

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
      ((Element)v.get(107)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(104)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(108)).setAttribute("nombre","lbldtPais" );
      ((Element)v.get(108)).setAttribute("alto","13" );
      ((Element)v.get(108)).setAttribute("filas","1" );
      ((Element)v.get(108)).setAttribute("id","datosCampos" );
      ((Element)v.get(108)).setAttribute("valor","" );
   }

   private void getXML450(Document doc) {
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

      /* Empieza nodo:111 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(104)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(112)).setAttribute("nombre","lbldtCodActividad" );
      ((Element)v.get(112)).setAttribute("alto","13" );
      ((Element)v.get(112)).setAttribute("filas","1" );
      ((Element)v.get(112)).setAttribute("id","datosCampos" );
      ((Element)v.get(112)).setAttribute("valor","" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","25" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(104)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(116)).setAttribute("nombre","txtDescripcionActividad" );
      ((Element)v.get(116)).setAttribute("id","datosCampos" );
      ((Element)v.get(116)).setAttribute("max","40" );
      ((Element)v.get(116)).setAttribute("tipo","" );
      ((Element)v.get(116)).setAttribute("onchange","" );
      ((Element)v.get(116)).setAttribute("req","S" );
      ((Element)v.get(116)).setAttribute("size","40" );
      ((Element)v.get(116)).setAttribute("valor","" );
      ((Element)v.get(116)).setAttribute("validacion","" );
      ((Element)v.get(116)).setAttribute("ontab","tab('txtDescripcionActividad')" );
      ((Element)v.get(116)).setAttribute("onshtab","shtab('txtDescripcionActividad')" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","8" );
      ((Element)v.get(118)).setAttribute("height","8" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(120)).setAttribute("src","iconmultidioma.gif" );
      ((Element)v.get(120)).setAttribute("width","21" );
      ((Element)v.get(120)).setAttribute("height","15" );
      ((Element)v.get(120)).setAttribute("onclick","levantarI18N('frmInsertarActividades','1');" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).setAttribute("width","100%" );
      ((Element)v.get(104)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","8" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:104   */

      /* Empieza nodo:123 / Elemento padre: 85   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(85)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).setAttribute("colspan","4" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).setAttribute("width","8" );
      ((Element)v.get(125)).setAttribute("height","8" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:126 / Elemento padre: 82   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(82)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("table"));
      ((Element)v.get(128)).setAttribute("width","711" );
      ((Element)v.get(128)).setAttribute("border","0" );
      ((Element)v.get(128)).setAttribute("align","left" );
      ((Element)v.get(128)).setAttribute("cellspacing","0" );
      ((Element)v.get(128)).setAttribute("cellpadding","0" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(131)).setAttribute("src","b.gif" );
      ((Element)v.get(131)).setAttribute("width","8" );
      ((Element)v.get(131)).setAttribute("height","8" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(133)).setAttribute("nombre","lblDescripcionDetalladaActividad" );
      ((Element)v.get(133)).setAttribute("alto","13" );
      ((Element)v.get(133)).setAttribute("filas","1" );
      ((Element)v.get(133)).setAttribute("valor","" );
      ((Element)v.get(133)).setAttribute("id","datosTitle" );
      ((Element)v.get(133)).setAttribute("cod","843" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","25" );
      ((Element)v.get(135)).setAttribute("height","8" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(137)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(137)).setAttribute("alto","13" );
      ((Element)v.get(137)).setAttribute("filas","1" );
      ((Element)v.get(137)).setAttribute("valor","" );
      ((Element)v.get(137)).setAttribute("id","datosTitle" );
      ((Element)v.get(137)).setAttribute("cod","6" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:138 / Elemento padre: 129   */
      v.add(doc.createElement("td"));
      ((Element)v.get(138)).setAttribute("width","100%" );
      ((Element)v.get(129)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).setAttribute("width","8" );
      ((Element)v.get(139)).setAttribute("height","8" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:129   */

      /* Empieza nodo:140 / Elemento padre: 128   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(128)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","8" );
      ((Element)v.get(142)).setAttribute("height","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 140   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(143)).setAttribute("valign","bottom" );
      ((Element)v.get(140)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("AREATEXTO"));
      ((Element)v.get(144)).setAttribute("cols","50" );
      ((Element)v.get(144)).setAttribute("id","datosCampos" );
      ((Element)v.get(144)).setAttribute("msjreq","" );
      ((Element)v.get(144)).setAttribute("nombre","areatxtObservaciones" );
      ((Element)v.get(144)).setAttribute("readonly","N" );
      ((Element)v.get(144)).setAttribute("req","S" );
      ((Element)v.get(144)).setAttribute("rows","3" );
      ((Element)v.get(144)).setAttribute("tabindex","2" );
      ((Element)v.get(144)).setAttribute("valor","" );
      ((Element)v.get(144)).setAttribute("ontab","tab('areatxtObservaciones')" );
      ((Element)v.get(144)).setAttribute("onshtab","shtab('areatxtObservaciones')" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 140   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).setAttribute("width","25" );
      ((Element)v.get(146)).setAttribute("height","8" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:147 / Elemento padre: 140   */
      v.add(doc.createElement("td"));
      ((Element)v.get(147)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(147)).setAttribute("valign","top" );
      ((Element)v.get(140)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(148)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(148)).setAttribute("id","datosCampos" );
      ((Element)v.get(148)).setAttribute("size","1" );
      ((Element)v.get(148)).setAttribute("multiple","N" );
      ((Element)v.get(148)).setAttribute("req","S" );
      ((Element)v.get(148)).setAttribute("valorinicial","" );
      ((Element)v.get(148)).setAttribute("textoinicial","" );
      ((Element)v.get(148)).setAttribute("ontab","tab('cbMarca')" );
      ((Element)v.get(148)).setAttribute("onshtab","shtab('cbMarca')" );
      ((Element)v.get(148)).setAttribute("onchange","marcaOnChange()" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:150 / Elemento padre: 140   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).setAttribute("width","100%" );
      ((Element)v.get(140)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).setAttribute("width","8" );
      ((Element)v.get(151)).setAttribute("height","8" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */
      /* Termina nodo:140   */

      /* Empieza nodo:152 / Elemento padre: 128   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(128)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).setAttribute("colspan","4" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).setAttribute("width","8" );
      ((Element)v.get(154)).setAttribute("height","8" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:155 / Elemento padre: 82   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(82)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("table"));
      ((Element)v.get(157)).setAttribute("width","711" );
      ((Element)v.get(157)).setAttribute("border","0" );
      ((Element)v.get(157)).setAttribute("align","left" );
      ((Element)v.get(157)).setAttribute("cellspacing","0" );
      ((Element)v.get(157)).setAttribute("cellpadding","0" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).setAttribute("width","8" );
      ((Element)v.get(160)).setAttribute("height","8" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(162)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(162)).setAttribute("alto","13" );
      ((Element)v.get(162)).setAttribute("filas","1" );
      ((Element)v.get(162)).setAttribute("valor","" );
      ((Element)v.get(162)).setAttribute("id","datosTitle" );
      ((Element)v.get(162)).setAttribute("cod","7" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","25" );
      ((Element)v.get(164)).setAttribute("height","8" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(166)).setAttribute("nombre","lblTipoCliente" );
      ((Element)v.get(166)).setAttribute("alto","13" );
      ((Element)v.get(166)).setAttribute("filas","1" );
      ((Element)v.get(166)).setAttribute("valor","" );
      ((Element)v.get(166)).setAttribute("id","datosTitle" );
      ((Element)v.get(166)).setAttribute("cod","393" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 158   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).setAttribute("width","100%" );
      ((Element)v.get(158)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","8" );
      ((Element)v.get(168)).setAttribute("height","8" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */
      /* Termina nodo:158   */

      /* Empieza nodo:169 / Elemento padre: 157   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(157)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(171)).setAttribute("src","b.gif" );
      ((Element)v.get(171)).setAttribute("width","8" );
      ((Element)v.get(171)).setAttribute("height","8" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:172 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(172)).setAttribute("valign","top" );
      ((Element)v.get(169)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(173)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(173)).setAttribute("id","datosCampos" );
      ((Element)v.get(173)).setAttribute("size","1" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(173)).setAttribute("multiple","N" );
      ((Element)v.get(173)).setAttribute("req","S" );
      ((Element)v.get(173)).setAttribute("valorinicial","" );
      ((Element)v.get(173)).setAttribute("textoinicial","" );
      ((Element)v.get(173)).setAttribute("ontab","tab('cbCanal')" );
      ((Element)v.get(173)).setAttribute("onshtab","shtab('cbCanal')" );
      ((Element)v.get(173)).setAttribute("onchange","canalOnChange()" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:175 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(176)).setAttribute("src","b.gif" );
      ((Element)v.get(176)).setAttribute("width","25" );
      ((Element)v.get(176)).setAttribute("height","8" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(177)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(177)).setAttribute("valign","top" );
      ((Element)v.get(169)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(178)).setAttribute("nombre","cbTipoCliente" );
      ((Element)v.get(178)).setAttribute("id","datosCampos" );
      ((Element)v.get(178)).setAttribute("size","1" );
      ((Element)v.get(178)).setAttribute("multiple","N" );
      ((Element)v.get(178)).setAttribute("req","S" );
      ((Element)v.get(178)).setAttribute("valorinicial","" );
      ((Element)v.get(178)).setAttribute("textoinicial","" );
      ((Element)v.get(178)).setAttribute("ontab","tab('cbTipoCliente')" );
      ((Element)v.get(178)).setAttribute("onshtab","shtab('cbTipoCliente')" );
      ((Element)v.get(178)).setAttribute("onchange","tipoClienteOnChange()" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:180 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).setAttribute("width","100%" );
      ((Element)v.get(169)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).setAttribute("width","8" );
      ((Element)v.get(181)).setAttribute("height","8" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */
      /* Termina nodo:169   */

      /* Empieza nodo:182 / Elemento padre: 157   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(157)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).setAttribute("colspan","4" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","8" );
      ((Element)v.get(184)).setAttribute("height","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */
      /* Termina nodo:182   */
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:185 / Elemento padre: 82   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(82)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("table"));
      ((Element)v.get(187)).setAttribute("width","711" );
      ((Element)v.get(187)).setAttribute("border","0" );
      ((Element)v.get(187)).setAttribute("align","left" );
      ((Element)v.get(187)).setAttribute("cellspacing","0" );
      ((Element)v.get(187)).setAttribute("cellpadding","0" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","8" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(188)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(192)).setAttribute("nombre","lblTipoOferta" );
      ((Element)v.get(192)).setAttribute("alto","13" );
      ((Element)v.get(192)).setAttribute("filas","1" );
      ((Element)v.get(192)).setAttribute("valor","" );
      ((Element)v.get(192)).setAttribute("id","datosTitle" );
      ((Element)v.get(192)).setAttribute("cod","608" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:193 / Elemento padre: 188   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).setAttribute("width","100%" );
      ((Element)v.get(188)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(194)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).setAttribute("width","8" );
      ((Element)v.get(194)).setAttribute("height","8" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:188   */

      /* Empieza nodo:195 / Elemento padre: 187   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(187)).appendChild((Element)v.get(195));

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
      ((Element)v.get(198)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(195)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(199)).setAttribute("nombre","cbTipoOferta" );
      ((Element)v.get(199)).setAttribute("id","datosCampos" );
      ((Element)v.get(199)).setAttribute("size","5" );
      ((Element)v.get(199)).setAttribute("multiple","S" );
      ((Element)v.get(199)).setAttribute("req","S" );
      ((Element)v.get(199)).setAttribute("valorinicial","" );
      ((Element)v.get(199)).setAttribute("textoinicial","" );
      ((Element)v.get(199)).setAttribute("ontab","tab('cbTipoOferta')" );
      ((Element)v.get(199)).setAttribute("onshtab","shtab('cbTipoOferta')" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:201 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).setAttribute("width","100%" );
      ((Element)v.get(195)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(202)).setAttribute("src","b.gif" );
      ((Element)v.get(202)).setAttribute("width","8" );
      ((Element)v.get(202)).setAttribute("height","8" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */
      /* Termina nodo:195   */

      /* Empieza nodo:203 / Elemento padre: 187   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(187)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("td"));
      ((Element)v.get(204)).setAttribute("colspan","4" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(205)).setAttribute("src","b.gif" );
      ((Element)v.get(205)).setAttribute("width","8" );
      ((Element)v.get(205)).setAttribute("height","8" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */
      /* Termina nodo:203   */
      /* Termina nodo:187   */
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:206 / Elemento padre: 82   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(82)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("td"));
      ((Element)v.get(206)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("table"));
      ((Element)v.get(208)).setAttribute("width","711" );
      ((Element)v.get(208)).setAttribute("border","0" );
      ((Element)v.get(208)).setAttribute("align","left" );
      ((Element)v.get(208)).setAttribute("cellspacing","0" );
      ((Element)v.get(208)).setAttribute("cellpadding","0" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(208)).appendChild((Element)v.get(209));

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
      ((Element)v.get(209)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(213)).setAttribute("nombre","lblCicloVida" );
      ((Element)v.get(213)).setAttribute("alto","13" );
      ((Element)v.get(213)).setAttribute("filas","1" );
      ((Element)v.get(213)).setAttribute("valor","" );
      ((Element)v.get(213)).setAttribute("id","datosTitle" );
      ((Element)v.get(213)).setAttribute("cod","581" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:214 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(215)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).setAttribute("width","25" );
      ((Element)v.get(215)).setAttribute("height","8" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:216 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(217)).setAttribute("nombre","lblTipoDespacho" );
      ((Element)v.get(217)).setAttribute("alto","13" );
      ((Element)v.get(217)).setAttribute("filas","1" );
      ((Element)v.get(217)).setAttribute("valor","" );
      ((Element)v.get(217)).setAttribute("id","datosTitle" );
      ((Element)v.get(217)).setAttribute("cod","1000" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:218 / Elemento padre: 209   */
      v.add(doc.createElement("td"));
      ((Element)v.get(218)).setAttribute("width","100%" );
      ((Element)v.get(209)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("width","8" );
      ((Element)v.get(219)).setAttribute("height","8" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:209   */

      /* Empieza nodo:220 / Elemento padre: 208   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(208)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(222)).setAttribute("width","8" );
      ((Element)v.get(222)).setAttribute("height","8" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:223 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(220)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(224)).setAttribute("nombre","cbCicloVida" );
      ((Element)v.get(224)).setAttribute("id","datosCampos" );
      ((Element)v.get(224)).setAttribute("size","5" );
      ((Element)v.get(224)).setAttribute("multiple","S" );
      ((Element)v.get(224)).setAttribute("req","S" );
      ((Element)v.get(224)).setAttribute("valorinicial","" );
      ((Element)v.get(224)).setAttribute("textoinicial","" );
      ((Element)v.get(224)).setAttribute("ontab","tab('cbCicloVida')" );
      ((Element)v.get(224)).setAttribute("onshtab","shtab('cbCicloVida')" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:226 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).setAttribute("width","25" );
      ((Element)v.get(227)).setAttribute("height","8" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(228)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(228)).setAttribute("valign","top" );
      ((Element)v.get(220)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(229)).setAttribute("nombre","cbTipoDespacho" );
      ((Element)v.get(229)).setAttribute("id","datosCampos" );
      ((Element)v.get(229)).setAttribute("size","4" );
      ((Element)v.get(229)).setAttribute("multiple","S" );
      ((Element)v.get(229)).setAttribute("req","S" );
      ((Element)v.get(229)).setAttribute("valorinicial","" );
      ((Element)v.get(229)).setAttribute("textoinicial","" );
      ((Element)v.get(229)).setAttribute("ontab","tab('cbTipoDespacho')" );
      ((Element)v.get(229)).setAttribute("onshtab","shtab('cbTipoDespacho')" );
      ((Element)v.get(229)).setAttribute("onchange","tipoDespachoOnChange()" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:231 / Elemento padre: 220   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).setAttribute("width","100%" );
      ((Element)v.get(220)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(232)).setAttribute("src","b.gif" );
      ((Element)v.get(232)).setAttribute("width","8" );
      ((Element)v.get(232)).setAttribute("height","8" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */
      /* Termina nodo:220   */

      /* Empieza nodo:233 / Elemento padre: 208   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(208)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).setAttribute("colspan","4" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(235)).setAttribute("src","b.gif" );
      ((Element)v.get(235)).setAttribute("width","8" );
      ((Element)v.get(235)).setAttribute("height","8" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */
      /* Termina nodo:233   */
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:236 / Elemento padre: 82   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(82)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("td"));
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("table"));
      ((Element)v.get(238)).setAttribute("width","711" );
      ((Element)v.get(238)).setAttribute("border","0" );
      ((Element)v.get(238)).setAttribute("align","left" );
      ((Element)v.get(238)).setAttribute("cellspacing","0" );
      ((Element)v.get(238)).setAttribute("cellpadding","0" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
   }

   private void getXML990(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(240)).setAttribute("colspan","4" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(241)).setAttribute("src","b.gif" );
      ((Element)v.get(241)).setAttribute("width","8" );
      ((Element)v.get(241)).setAttribute("height","8" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:242 / Elemento padre: 238   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(238)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(244)).setAttribute("src","b.gif" );
      ((Element)v.get(244)).setAttribute("width","8" );
      ((Element)v.get(244)).setAttribute("height","8" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:245 / Elemento padre: 242   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(246)).setAttribute("nombre","lblEnvioSolicitud" );
      ((Element)v.get(246)).setAttribute("alto","13" );
      ((Element)v.get(246)).setAttribute("filas","1" );
      ((Element)v.get(246)).setAttribute("valor","" );
      ((Element)v.get(246)).setAttribute("id","datosTitle" );
      ((Element)v.get(246)).setAttribute("cod","859" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:247 / Elemento padre: 242   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(248)).setAttribute("src","b.gif" );
      ((Element)v.get(248)).setAttribute("width","25" );
      ((Element)v.get(248)).setAttribute("height","8" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */

      /* Empieza nodo:249 / Elemento padre: 242   */
      v.add(doc.createElement("td"));
      ((Element)v.get(242)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(250)).setAttribute("nombre","lblTipoSolicitudOrigen" );
      ((Element)v.get(250)).setAttribute("alto","13" );
      ((Element)v.get(250)).setAttribute("filas","1" );
      ((Element)v.get(250)).setAttribute("valor","" );
      ((Element)v.get(250)).setAttribute("id","datosTitle" );
      ((Element)v.get(250)).setAttribute("cod","1005" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */

      /* Empieza nodo:251 / Elemento padre: 242   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).setAttribute("width","100%" );
      ((Element)v.get(242)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(252)).setAttribute("src","b.gif" );
      ((Element)v.get(252)).setAttribute("width","8" );
      ((Element)v.get(252)).setAttribute("height","8" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */
      /* Termina nodo:242   */

      /* Empieza nodo:253 / Elemento padre: 238   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(238)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("td"));
      ((Element)v.get(253)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(255)).setAttribute("src","b.gif" );
      ((Element)v.get(255)).setAttribute("width","8" );
      ((Element)v.get(255)).setAttribute("height","8" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */

      /* Empieza nodo:256 / Elemento padre: 253   */
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(256)).setAttribute("valign","top" );
      ((Element)v.get(253)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(257)).setAttribute("nombre","cbEnvioSolicitud" );
      ((Element)v.get(257)).setAttribute("id","datosCampos" );
      ((Element)v.get(257)).setAttribute("size","1" );
      ((Element)v.get(257)).setAttribute("multiple","N" );
      ((Element)v.get(257)).setAttribute("req","N" );
      ((Element)v.get(257)).setAttribute("valorinicial","" );
      ((Element)v.get(257)).setAttribute("textoinicial","" );
      ((Element)v.get(257)).setAttribute("ontab","tab('cbEnvioSolicitud')" );
      ((Element)v.get(257)).setAttribute("onshtab","shtab('cbEnvioSolicitud')" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */
      /* Termina nodo:256   */

      /* Empieza nodo:259 / Elemento padre: 253   */
      v.add(doc.createElement("td"));
      ((Element)v.get(253)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(260)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).setAttribute("width","25" );
      ((Element)v.get(260)).setAttribute("height","8" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:261 / Elemento padre: 253   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(253)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(262)).setAttribute("nombre","cbTipoSolicitudOrigen" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(262)).setAttribute("id","datosCampos" );
      ((Element)v.get(262)).setAttribute("size","5" );
      ((Element)v.get(262)).setAttribute("multiple","S" );
      ((Element)v.get(262)).setAttribute("req","N" );
      ((Element)v.get(262)).setAttribute("valorinicial","" );
      ((Element)v.get(262)).setAttribute("textoinicial","" );
      ((Element)v.get(262)).setAttribute("ontab","tab('cbTipoSolicitudOrigen')" );
      ((Element)v.get(262)).setAttribute("onshtab","shtab('cbTipoSolicitudOrigen')" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */
      /* Termina nodo:261   */

      /* Empieza nodo:264 / Elemento padre: 253   */
      v.add(doc.createElement("td"));
      ((Element)v.get(264)).setAttribute("width","100%" );
      ((Element)v.get(253)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(265)).setAttribute("src","b.gif" );
      ((Element)v.get(265)).setAttribute("width","8" );
      ((Element)v.get(265)).setAttribute("height","8" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */
      /* Termina nodo:253   */

      /* Empieza nodo:266 / Elemento padre: 238   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(238)).appendChild((Element)v.get(266));

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
      /* Termina nodo:238   */
      /* Termina nodo:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:269 / Elemento padre: 82   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(82)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("table"));
      ((Element)v.get(271)).setAttribute("width","711" );
      ((Element)v.get(271)).setAttribute("border","0" );
      ((Element)v.get(271)).setAttribute("align","left" );
      ((Element)v.get(271)).setAttribute("cellspacing","0" );
      ((Element)v.get(271)).setAttribute("cellpadding","0" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(271)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(273)).setAttribute("colspan","4" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(274)).setAttribute("src","b.gif" );
      ((Element)v.get(274)).setAttribute("width","8" );
      ((Element)v.get(274)).setAttribute("height","8" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */
      /* Termina nodo:272   */

      /* Empieza nodo:275 / Elemento padre: 271   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(271)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(277)).setAttribute("src","b.gif" );
      ((Element)v.get(277)).setAttribute("width","8" );
      ((Element)v.get(277)).setAttribute("height","8" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:276   */

      /* Empieza nodo:278 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(279)).setAttribute("nombre","lblTipoSolicitudDestino" );
      ((Element)v.get(279)).setAttribute("alto","13" );
      ((Element)v.get(279)).setAttribute("filas","1" );
      ((Element)v.get(279)).setAttribute("valor","" );
      ((Element)v.get(279)).setAttribute("id","datosTitle" );
      ((Element)v.get(279)).setAttribute("cod","1004" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */

      /* Empieza nodo:280 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(281)).setAttribute("src","b.gif" );
      ((Element)v.get(281)).setAttribute("width","25" );
      ((Element)v.get(281)).setAttribute("height","8" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:280   */

      /* Empieza nodo:282 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(275)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(283)).setAttribute("nombre","lblTipoPosicionEnvio" );
      ((Element)v.get(283)).setAttribute("alto","13" );
      ((Element)v.get(283)).setAttribute("filas","1" );
      ((Element)v.get(283)).setAttribute("valor","" );
      ((Element)v.get(283)).setAttribute("id","datosTitle" );
      ((Element)v.get(283)).setAttribute("cod","1002" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:284 / Elemento padre: 275   */
      v.add(doc.createElement("td"));
      ((Element)v.get(284)).setAttribute("width","100%" );
      ((Element)v.get(275)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(285)).setAttribute("src","b.gif" );
      ((Element)v.get(285)).setAttribute("width","8" );
      ((Element)v.get(285)).setAttribute("height","8" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */
      /* Termina nodo:275   */

      /* Empieza nodo:286 / Elemento padre: 271   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(271)).appendChild((Element)v.get(286));

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
      ((Element)v.get(289)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(286)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(290)).setAttribute("nombre","cbTipoSolicitudDestino" );
      ((Element)v.get(290)).setAttribute("id","datosCampos" );
      ((Element)v.get(290)).setAttribute("size","1" );
      ((Element)v.get(290)).setAttribute("multiple","N" );
      ((Element)v.get(290)).setAttribute("req","N" );
      ((Element)v.get(290)).setAttribute("valorinicial","" );
      ((Element)v.get(290)).setAttribute("textoinicial","" );
      ((Element)v.get(290)).setAttribute("ontab","tab('cbTipoSolicitudDestino')" );
      ((Element)v.get(290)).setAttribute("onshtab","shtab('cbTipoSolicitudDestino')" );
      ((Element)v.get(290)).setAttribute("onchange","tipoSolicitudDestinoOnChange()" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */
      /* Termina nodo:289   */

      /* Empieza nodo:292 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(286)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(293)).setAttribute("src","b.gif" );
      ((Element)v.get(293)).setAttribute("width","25" );
      ((Element)v.get(293)).setAttribute("height","8" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:294 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(294)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(286)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(295)).setAttribute("nombre","cbTipoPosicionEnvio" );
      ((Element)v.get(295)).setAttribute("id","datosCampos" );
      ((Element)v.get(295)).setAttribute("size","1" );
      ((Element)v.get(295)).setAttribute("multiple","N" );
      ((Element)v.get(295)).setAttribute("req","N" );
      ((Element)v.get(295)).setAttribute("valorinicial","" );
      ((Element)v.get(295)).setAttribute("textoinicial","" );
      ((Element)v.get(295)).setAttribute("ontab","tab('cbTipoPosicionEnvio')" );
      ((Element)v.get(295)).setAttribute("onshtab","shtab('cbTipoPosicionEnvio')" );
      ((Element)v.get(295)).setAttribute("onchange","tipoPosicionEnvioOnChange()" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */
      /* Termina nodo:294   */

      /* Empieza nodo:297 / Elemento padre: 286   */
      v.add(doc.createElement("td"));
      ((Element)v.get(297)).setAttribute("width","100%" );
      ((Element)v.get(286)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(298)).setAttribute("src","b.gif" );
      ((Element)v.get(298)).setAttribute("width","8" );
      ((Element)v.get(298)).setAttribute("height","8" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */
      /* Termina nodo:286   */

      /* Empieza nodo:299 / Elemento padre: 271   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(271)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).setAttribute("colspan","4" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(301)).setAttribute("src","b.gif" );
      ((Element)v.get(301)).setAttribute("width","8" );
      ((Element)v.get(301)).setAttribute("height","8" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:300   */
      /* Termina nodo:299   */
      /* Termina nodo:271   */
      /* Termina nodo:270   */
      /* Termina nodo:269   */

      /* Empieza nodo:302 / Elemento padre: 82   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(82)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("td"));
      ((Element)v.get(302)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("table"));
      ((Element)v.get(304)).setAttribute("width","711" );
      ((Element)v.get(304)).setAttribute("border","0" );
      ((Element)v.get(304)).setAttribute("align","left" );
      ((Element)v.get(304)).setAttribute("cellspacing","0" );
      ((Element)v.get(304)).setAttribute("cellpadding","0" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(304)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("td"));
      ((Element)v.get(306)).setAttribute("colspan","4" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(307)).setAttribute("src","b.gif" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(307)).setAttribute("width","8" );
      ((Element)v.get(307)).setAttribute("height","8" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:306   */
      /* Termina nodo:305   */

      /* Empieza nodo:308 / Elemento padre: 304   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(304)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("td"));
      ((Element)v.get(308)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(310)).setAttribute("src","b.gif" );
      ((Element)v.get(310)).setAttribute("width","8" );
      ((Element)v.get(310)).setAttribute("height","8" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */
      /* Termina nodo:309   */

      /* Empieza nodo:311 / Elemento padre: 308   */
      v.add(doc.createElement("td"));
      ((Element)v.get(308)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(312)).setAttribute("nombre","lblSubtipoPosicionEnvio" );
      ((Element)v.get(312)).setAttribute("alto","13" );
      ((Element)v.get(312)).setAttribute("filas","1" );
      ((Element)v.get(312)).setAttribute("valor","" );
      ((Element)v.get(312)).setAttribute("id","datosTitle" );
      ((Element)v.get(312)).setAttribute("cod","2587" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */

      /* Empieza nodo:313 / Elemento padre: 308   */
      v.add(doc.createElement("td"));
      ((Element)v.get(313)).setAttribute("width","100%" );
      ((Element)v.get(308)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(314)).setAttribute("src","b.gif" );
      ((Element)v.get(314)).setAttribute("width","8" );
      ((Element)v.get(314)).setAttribute("height","8" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */
      /* Termina nodo:308   */

      /* Empieza nodo:315 / Elemento padre: 304   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(304)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("td"));
      ((Element)v.get(315)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(317)).setAttribute("src","b.gif" );
      ((Element)v.get(317)).setAttribute("width","8" );
      ((Element)v.get(317)).setAttribute("height","8" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:316   */

      /* Empieza nodo:318 / Elemento padre: 315   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(315)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(319)).setAttribute("nombre","cbSubtipoPosicionEnvio" );
      ((Element)v.get(319)).setAttribute("id","datosCampos" );
      ((Element)v.get(319)).setAttribute("size","1" );
      ((Element)v.get(319)).setAttribute("multiple","N" );
      ((Element)v.get(319)).setAttribute("req","N" );
      ((Element)v.get(319)).setAttribute("valorinicial","" );
      ((Element)v.get(319)).setAttribute("textoinicial","" );
      ((Element)v.get(319)).setAttribute("ontab","tab('cbSubtipoPosicionEnvio')" );
      ((Element)v.get(319)).setAttribute("onshtab","shtab('cbSubtipoPosicionEnvio')" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */
      /* Termina nodo:318   */

      /* Empieza nodo:321 / Elemento padre: 315   */
      v.add(doc.createElement("td"));
      ((Element)v.get(321)).setAttribute("width","100%" );
      ((Element)v.get(315)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(322)).setAttribute("src","b.gif" );
      ((Element)v.get(322)).setAttribute("width","8" );
      ((Element)v.get(322)).setAttribute("height","8" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */
      /* Termina nodo:321   */
      /* Termina nodo:315   */

      /* Empieza nodo:323 / Elemento padre: 304   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(304)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("td"));
      ((Element)v.get(324)).setAttribute("colspan","4" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(325)).setAttribute("src","b.gif" );
      ((Element)v.get(325)).setAttribute("width","8" );
      ((Element)v.get(325)).setAttribute("height","8" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */
      /* Termina nodo:323   */
      /* Termina nodo:304   */
      /* Termina nodo:303   */
      /* Termina nodo:302   */

      /* Empieza nodo:326 / Elemento padre: 82   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(82)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("table"));
      ((Element)v.get(328)).setAttribute("width","711" );
      ((Element)v.get(328)).setAttribute("border","0" );
      ((Element)v.get(328)).setAttribute("align","left" );
      ((Element)v.get(328)).setAttribute("cellspacing","0" );
      ((Element)v.get(328)).setAttribute("cellpadding","0" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(328)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("td"));
      ((Element)v.get(330)).setAttribute("colspan","4" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(331)).setAttribute("src","b.gif" );
      ((Element)v.get(331)).setAttribute("width","8" );
      ((Element)v.get(331)).setAttribute("height","8" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:332 / Elemento padre: 328   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(328)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("td"));
      ((Element)v.get(332)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(334)).setAttribute("src","b.gif" );
      ((Element)v.get(334)).setAttribute("width","8" );
      ((Element)v.get(334)).setAttribute("height","8" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:335 / Elemento padre: 332   */
      v.add(doc.createElement("td"));
      ((Element)v.get(332)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(336)).setAttribute("nombre","lblSubtipoCliente" );
      ((Element)v.get(336)).setAttribute("alto","13" );
      ((Element)v.get(336)).setAttribute("filas","1" );
      ((Element)v.get(336)).setAttribute("valor","" );
      ((Element)v.get(336)).setAttribute("id","datosTitle" );
      ((Element)v.get(336)).setAttribute("cod","595" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 332   */
      v.add(doc.createElement("td"));
      ((Element)v.get(332)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(338)).setAttribute("src","b.gif" );
      ((Element)v.get(338)).setAttribute("width","25" );
      ((Element)v.get(338)).setAttribute("height","8" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:339 / Elemento padre: 332   */
      v.add(doc.createElement("td"));
      ((Element)v.get(332)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(340)).setAttribute("nombre","lblEstado" );
      ((Element)v.get(340)).setAttribute("alto","13" );
      ((Element)v.get(340)).setAttribute("filas","1" );
      ((Element)v.get(340)).setAttribute("valor","" );
      ((Element)v.get(340)).setAttribute("id","datosTitle" );
      ((Element)v.get(340)).setAttribute("cod","400" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */

      /* Empieza nodo:341 / Elemento padre: 332   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).setAttribute("width","100%" );
      ((Element)v.get(332)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(342)).setAttribute("src","b.gif" );
      ((Element)v.get(342)).setAttribute("width","8" );
      ((Element)v.get(342)).setAttribute("height","8" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */
      /* Termina nodo:332   */

      /* Empieza nodo:343 / Elemento padre: 328   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(328)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("td"));
      ((Element)v.get(343)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(345)).setAttribute("src","b.gif" );
      ((Element)v.get(345)).setAttribute("width","8" );
      ((Element)v.get(345)).setAttribute("height","8" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */
      /* Termina nodo:344   */

      /* Empieza nodo:346 / Elemento padre: 343   */
      v.add(doc.createElement("td"));
      ((Element)v.get(346)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(343)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(347)).setAttribute("nombre","cbSubtipoCliente" );
      ((Element)v.get(347)).setAttribute("id","datosCampos" );
      ((Element)v.get(347)).setAttribute("size","5" );
      ((Element)v.get(347)).setAttribute("multiple","S" );
      ((Element)v.get(347)).setAttribute("req","N" );
      ((Element)v.get(347)).setAttribute("valorinicial","" );
      ((Element)v.get(347)).setAttribute("textoinicial","" );
      ((Element)v.get(347)).setAttribute("ontab","tab('cbSubtipoCliente')" );
      ((Element)v.get(347)).setAttribute("onshtab","shtab('cbSubtipoCliente')" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(347)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:347   */
      /* Termina nodo:346   */

      /* Empieza nodo:349 / Elemento padre: 343   */
      v.add(doc.createElement("td"));
      ((Element)v.get(343)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(350)).setAttribute("src","b.gif" );
      ((Element)v.get(350)).setAttribute("width","25" );
      ((Element)v.get(350)).setAttribute("height","8" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:349   */

      /* Empieza nodo:351 / Elemento padre: 343   */
      v.add(doc.createElement("td"));
      ((Element)v.get(351)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(343)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(352)).setAttribute("nombre","cbEstado" );
      ((Element)v.get(352)).setAttribute("id","datosCampos" );
      ((Element)v.get(352)).setAttribute("size","5" );
      ((Element)v.get(352)).setAttribute("multiple","S" );
      ((Element)v.get(352)).setAttribute("req","N" );
      ((Element)v.get(352)).setAttribute("valorinicial","" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(352)).setAttribute("textoinicial","" );
      ((Element)v.get(352)).setAttribute("ontab","tab('cbEstado')" );
      ((Element)v.get(352)).setAttribute("onshtab","shtab('cbEstado')" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(352)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */
      /* Termina nodo:352   */
      /* Termina nodo:351   */

      /* Empieza nodo:354 / Elemento padre: 343   */
      v.add(doc.createElement("td"));
      ((Element)v.get(354)).setAttribute("width","100%" );
      ((Element)v.get(343)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(355)).setAttribute("src","b.gif" );
      ((Element)v.get(355)).setAttribute("width","8" );
      ((Element)v.get(355)).setAttribute("height","8" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */
      /* Termina nodo:354   */
      /* Termina nodo:343   */

      /* Empieza nodo:356 / Elemento padre: 328   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(328)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("td"));
      ((Element)v.get(357)).setAttribute("colspan","4" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(358)).setAttribute("src","b.gif" );
      ((Element)v.get(358)).setAttribute("width","8" );
      ((Element)v.get(358)).setAttribute("height","8" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */
      /* Termina nodo:357   */
      /* Termina nodo:356   */
      /* Termina nodo:328   */
      /* Termina nodo:327   */
      /* Termina nodo:326   */

      /* Empieza nodo:359 / Elemento padre: 82   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(82)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("td"));
      ((Element)v.get(359)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("table"));
      ((Element)v.get(361)).setAttribute("width","711" );
      ((Element)v.get(361)).setAttribute("border","0" );
      ((Element)v.get(361)).setAttribute("align","left" );
      ((Element)v.get(361)).setAttribute("cellspacing","0" );
      ((Element)v.get(361)).setAttribute("cellpadding","0" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(361)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("td"));
      ((Element)v.get(363)).setAttribute("colspan","4" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(364)).setAttribute("src","b.gif" );
      ((Element)v.get(364)).setAttribute("width","8" );
      ((Element)v.get(364)).setAttribute("height","8" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */
      /* Termina nodo:363   */
      /* Termina nodo:362   */

      /* Empieza nodo:365 / Elemento padre: 361   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(361)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("td"));
      ((Element)v.get(365)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(367)).setAttribute("src","b.gif" );
      ((Element)v.get(367)).setAttribute("width","8" );
      ((Element)v.get(367)).setAttribute("height","8" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */
      /* Termina nodo:366   */

      /* Empieza nodo:368 / Elemento padre: 365   */
      v.add(doc.createElement("td"));
      ((Element)v.get(365)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(369)).setAttribute("nombre","lblCondicionPago" );
      ((Element)v.get(369)).setAttribute("alto","13" );
      ((Element)v.get(369)).setAttribute("filas","1" );
      ((Element)v.get(369)).setAttribute("valor","" );
      ((Element)v.get(369)).setAttribute("id","datosTitle" );
      ((Element)v.get(369)).setAttribute("cod","830" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */

      /* Empieza nodo:370 / Elemento padre: 365   */
      v.add(doc.createElement("td"));
      ((Element)v.get(365)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(371)).setAttribute("src","b.gif" );
      ((Element)v.get(371)).setAttribute("width","25" );
      ((Element)v.get(371)).setAttribute("height","8" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */
      /* Termina nodo:370   */

      /* Empieza nodo:372 / Elemento padre: 365   */
      v.add(doc.createElement("td"));
      ((Element)v.get(365)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(373)).setAttribute("nombre","lblFormaPago" );
      ((Element)v.get(373)).setAttribute("alto","13" );
      ((Element)v.get(373)).setAttribute("filas","1" );
      ((Element)v.get(373)).setAttribute("valor","" );
      ((Element)v.get(373)).setAttribute("id","datosTitle" );
      ((Element)v.get(373)).setAttribute("cod","541" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */
      /* Termina nodo:372   */

      /* Empieza nodo:374 / Elemento padre: 365   */
      v.add(doc.createElement("td"));
      ((Element)v.get(365)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(375)).setAttribute("src","b.gif" );
      ((Element)v.get(375)).setAttribute("width","25" );
      ((Element)v.get(375)).setAttribute("height","8" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */
      /* Termina nodo:374   */

      /* Empieza nodo:376 / Elemento padre: 365   */
      v.add(doc.createElement("td"));
      ((Element)v.get(365)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
   }

   private void getXML1530(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(377)).setAttribute("nombre","lblCriterioAsignacion" );
      ((Element)v.get(377)).setAttribute("alto","13" );
      ((Element)v.get(377)).setAttribute("filas","1" );
      ((Element)v.get(377)).setAttribute("valor","" );
      ((Element)v.get(377)).setAttribute("id","datosTitle" );
      ((Element)v.get(377)).setAttribute("cod","838" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */
      /* Termina nodo:376   */

      /* Empieza nodo:378 / Elemento padre: 365   */
      v.add(doc.createElement("td"));
      ((Element)v.get(365)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(379)).setAttribute("src","b.gif" );
      ((Element)v.get(379)).setAttribute("width","25" );
      ((Element)v.get(379)).setAttribute("height","8" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */
      /* Termina nodo:378   */

      /* Empieza nodo:380 / Elemento padre: 365   */
      v.add(doc.createElement("td"));
      ((Element)v.get(365)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(381)).setAttribute("nombre","lblCampanaEvaluacion" );
      ((Element)v.get(381)).setAttribute("alto","13" );
      ((Element)v.get(381)).setAttribute("filas","1" );
      ((Element)v.get(381)).setAttribute("valor","" );
      ((Element)v.get(381)).setAttribute("id","datosTitle" );
      ((Element)v.get(381)).setAttribute("cod","811" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */
      /* Termina nodo:380   */

      /* Empieza nodo:382 / Elemento padre: 365   */
      v.add(doc.createElement("td"));
      ((Element)v.get(382)).setAttribute("width","100%" );
      ((Element)v.get(365)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(383)).setAttribute("src","b.gif" );
      ((Element)v.get(383)).setAttribute("width","8" );
      ((Element)v.get(383)).setAttribute("height","8" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */
      /* Termina nodo:382   */
      /* Termina nodo:365   */

      /* Empieza nodo:384 / Elemento padre: 361   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(361)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("td"));
      ((Element)v.get(384)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(386)).setAttribute("src","b.gif" );
      ((Element)v.get(386)).setAttribute("width","8" );
      ((Element)v.get(386)).setAttribute("height","8" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));
      /* Termina nodo:386   */
      /* Termina nodo:385   */

      /* Empieza nodo:387 / Elemento padre: 384   */
      v.add(doc.createElement("td"));
      ((Element)v.get(387)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(387)).setAttribute("valign","top" );
      ((Element)v.get(384)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(388)).setAttribute("nombre","cbCondicionPago" );
      ((Element)v.get(388)).setAttribute("id","datosCampos" );
      ((Element)v.get(388)).setAttribute("size","1" );
      ((Element)v.get(388)).setAttribute("onchange","condicionPagoOnChange();" );
      ((Element)v.get(388)).setAttribute("multiple","N" );
      ((Element)v.get(388)).setAttribute("req","S" );
      ((Element)v.get(388)).setAttribute("valorinicial","" );
      ((Element)v.get(388)).setAttribute("textoinicial","" );
      ((Element)v.get(388)).setAttribute("ontab","tab('cbCondicionPago')" );
      ((Element)v.get(388)).setAttribute("onshtab","shtab('cbCondicionPago')" );
      ((Element)v.get(387)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(388)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:388   */
      /* Termina nodo:387   */

      /* Empieza nodo:390 / Elemento padre: 384   */
      v.add(doc.createElement("td"));
      ((Element)v.get(384)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(391)).setAttribute("src","b.gif" );
      ((Element)v.get(391)).setAttribute("width","25" );
      ((Element)v.get(391)).setAttribute("height","8" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */
      /* Termina nodo:390   */

      /* Empieza nodo:392 / Elemento padre: 384   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(392)).setAttribute("valign","top" );
      ((Element)v.get(384)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(393)).setAttribute("nombre","cbFormaPago" );
      ((Element)v.get(393)).setAttribute("id","datosCampos" );
      ((Element)v.get(393)).setAttribute("size","1" );
      ((Element)v.get(393)).setAttribute("multiple","N" );
      ((Element)v.get(393)).setAttribute("req","N" );
      ((Element)v.get(393)).setAttribute("valorinicial","" );
      ((Element)v.get(393)).setAttribute("textoinicial","" );
      ((Element)v.get(393)).setAttribute("ontab","tab('cbFormaPago')" );
      ((Element)v.get(393)).setAttribute("onshtab","shtab('cbFormaPago')" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(393)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */
      /* Termina nodo:393   */
      /* Termina nodo:392   */

      /* Empieza nodo:395 / Elemento padre: 384   */
      v.add(doc.createElement("td"));
      ((Element)v.get(384)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(396)).setAttribute("src","b.gif" );
      ((Element)v.get(396)).setAttribute("width","25" );
      ((Element)v.get(396)).setAttribute("height","8" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(395)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */
      /* Termina nodo:395   */

      /* Empieza nodo:397 / Elemento padre: 384   */
      v.add(doc.createElement("td"));
      ((Element)v.get(397)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(384)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(398)).setAttribute("nombre","cbCriterioAsignacion" );
      ((Element)v.get(398)).setAttribute("id","datosCampos" );
      ((Element)v.get(398)).setAttribute("size","3" );
      ((Element)v.get(398)).setAttribute("multiple","S" );
      ((Element)v.get(398)).setAttribute("req","S" );
      ((Element)v.get(398)).setAttribute("valorinicial","" );
      ((Element)v.get(398)).setAttribute("textoinicial","" );
      ((Element)v.get(398)).setAttribute("ontab","tab('cbCriterioAsignacion')" );
      ((Element)v.get(398)).setAttribute("onshtab","shtab('cbCriterioAsignacion')" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(398)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */
      /* Termina nodo:398   */
      /* Termina nodo:397   */

      /* Empieza nodo:400 / Elemento padre: 384   */
      v.add(doc.createElement("td"));
      ((Element)v.get(384)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(401)).setAttribute("src","b.gif" );
      ((Element)v.get(401)).setAttribute("width","25" );
      ((Element)v.get(401)).setAttribute("height","8" );
      ((Element)v.get(400)).appendChild((Element)v.get(401));
      /* Termina nodo:401   */
      /* Termina nodo:400   */

      /* Empieza nodo:402 / Elemento padre: 384   */
      v.add(doc.createElement("td"));
      ((Element)v.get(402)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(402)).setAttribute("valign","top" );
      ((Element)v.get(384)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(403)).setAttribute("nombre","cbCampana" );
      ((Element)v.get(403)).setAttribute("id","datosCampos" );
      ((Element)v.get(403)).setAttribute("size","1" );
      ((Element)v.get(403)).setAttribute("multiple","N" );
      ((Element)v.get(403)).setAttribute("req","N" );
      ((Element)v.get(403)).setAttribute("valorinicial","+9" );
      ((Element)v.get(403)).setAttribute("textoinicial","+9" );
      ((Element)v.get(403)).setAttribute("ontab","tab('cbCampana')" );
      ((Element)v.get(403)).setAttribute("onshtab","shtab('cbCampana')" );
      ((Element)v.get(402)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(403)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(405)).setAttribute("ID","1" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(406)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(406)).setAttribute("TIPO","STRING" );
      ((Element)v.get(406)).setAttribute("VALOR","+8" );
      ((Element)v.get(405)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */

      /* Empieza nodo:407 / Elemento padre: 405   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(407)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(407)).setAttribute("TIPO","STRING" );
      ((Element)v.get(407)).setAttribute("VALOR","+8" );
      ((Element)v.get(405)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */
      /* Termina nodo:405   */

      /* Empieza nodo:408 / Elemento padre: 404   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(408)).setAttribute("ID","2" );
      ((Element)v.get(404)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(409)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(409)).setAttribute("TIPO","STRING" );
      ((Element)v.get(409)).setAttribute("VALOR","+7" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));
      /* Termina nodo:409   */

      /* Empieza nodo:410 / Elemento padre: 408   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(410)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(410)).setAttribute("TIPO","STRING" );
      ((Element)v.get(410)).setAttribute("VALOR","+7" );
      ((Element)v.get(408)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */
      /* Termina nodo:408   */

      /* Empieza nodo:411 / Elemento padre: 404   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(411)).setAttribute("ID","3" );
      ((Element)v.get(404)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(412)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(412)).setAttribute("TIPO","STRING" );
      ((Element)v.get(412)).setAttribute("VALOR","+6" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */

      /* Empieza nodo:413 / Elemento padre: 411   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(413)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(413)).setAttribute("TIPO","STRING" );
      ((Element)v.get(413)).setAttribute("VALOR","+6" );
      ((Element)v.get(411)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */
      /* Termina nodo:411   */

      /* Empieza nodo:414 / Elemento padre: 404   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(414)).setAttribute("ID","4" );
      ((Element)v.get(404)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(415)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(415)).setAttribute("TIPO","STRING" );
      ((Element)v.get(415)).setAttribute("VALOR","+5" );
      ((Element)v.get(414)).appendChild((Element)v.get(415));
      /* Termina nodo:415   */

      /* Empieza nodo:416 / Elemento padre: 414   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(416)).setAttribute("NOMBRE","DESCRIPCION" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(416)).setAttribute("TIPO","STRING" );
      ((Element)v.get(416)).setAttribute("VALOR","+5" );
      ((Element)v.get(414)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */
      /* Termina nodo:414   */

      /* Empieza nodo:417 / Elemento padre: 404   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(417)).setAttribute("ID","5" );
      ((Element)v.get(404)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(418)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(418)).setAttribute("TIPO","STRING" );
      ((Element)v.get(418)).setAttribute("VALOR","+4" );
      ((Element)v.get(417)).appendChild((Element)v.get(418));
      /* Termina nodo:418   */

      /* Empieza nodo:419 / Elemento padre: 417   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(419)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(419)).setAttribute("TIPO","STRING" );
      ((Element)v.get(419)).setAttribute("VALOR","+4" );
      ((Element)v.get(417)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */
      /* Termina nodo:417   */

      /* Empieza nodo:420 / Elemento padre: 404   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(420)).setAttribute("ID","6" );
      ((Element)v.get(404)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(421)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(421)).setAttribute("TIPO","STRING" );
      ((Element)v.get(421)).setAttribute("VALOR","+3" );
      ((Element)v.get(420)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */

      /* Empieza nodo:422 / Elemento padre: 420   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(422)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(422)).setAttribute("TIPO","STRING" );
      ((Element)v.get(422)).setAttribute("VALOR","+3" );
      ((Element)v.get(420)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */
      /* Termina nodo:420   */

      /* Empieza nodo:423 / Elemento padre: 404   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(423)).setAttribute("ID","7" );
      ((Element)v.get(404)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(424)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(424)).setAttribute("TIPO","STRING" );
      ((Element)v.get(424)).setAttribute("VALOR","+2" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */

      /* Empieza nodo:425 / Elemento padre: 423   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(425)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(425)).setAttribute("TIPO","STRING" );
      ((Element)v.get(425)).setAttribute("VALOR","+2" );
      ((Element)v.get(423)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */
      /* Termina nodo:423   */

      /* Empieza nodo:426 / Elemento padre: 404   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(426)).setAttribute("ID","8" );
      ((Element)v.get(404)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(427)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(427)).setAttribute("TIPO","STRING" );
      ((Element)v.get(427)).setAttribute("VALOR","+1" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */

      /* Empieza nodo:428 / Elemento padre: 426   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(428)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(428)).setAttribute("TIPO","STRING" );
      ((Element)v.get(428)).setAttribute("VALOR","+1" );
      ((Element)v.get(426)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */
      /* Termina nodo:426   */

      /* Empieza nodo:429 / Elemento padre: 404   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(429)).setAttribute("ID","1" );
      ((Element)v.get(404)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(430)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(430)).setAttribute("TIPO","STRING" );
      ((Element)v.get(430)).setAttribute("VALOR","0" );
      ((Element)v.get(429)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */

      /* Empieza nodo:431 / Elemento padre: 429   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(431)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(431)).setAttribute("TIPO","STRING" );
      ((Element)v.get(431)).setAttribute("VALOR","0" );
      ((Element)v.get(429)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */
      /* Termina nodo:429   */

      /* Empieza nodo:432 / Elemento padre: 404   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(432)).setAttribute("ID","9" );
      ((Element)v.get(404)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(433)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(433)).setAttribute("TIPO","STRING" );
      ((Element)v.get(433)).setAttribute("VALOR","-1" );
      ((Element)v.get(432)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */

      /* Empieza nodo:434 / Elemento padre: 432   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(434)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(434)).setAttribute("TIPO","STRING" );
      ((Element)v.get(434)).setAttribute("VALOR","-1" );
      ((Element)v.get(432)).appendChild((Element)v.get(434));
      /* Termina nodo:434   */
      /* Termina nodo:432   */

      /* Empieza nodo:435 / Elemento padre: 404   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(435)).setAttribute("ID","10" );
      ((Element)v.get(404)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(436)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(436)).setAttribute("TIPO","STRING" );
      ((Element)v.get(436)).setAttribute("VALOR","-2" );
      ((Element)v.get(435)).appendChild((Element)v.get(436));
      /* Termina nodo:436   */

      /* Empieza nodo:437 / Elemento padre: 435   */
      v.add(doc.createElement("CAMPO"));
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(437)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(437)).setAttribute("TIPO","STRING" );
      ((Element)v.get(437)).setAttribute("VALOR","-2" );
      ((Element)v.get(435)).appendChild((Element)v.get(437));
      /* Termina nodo:437   */
      /* Termina nodo:435   */

      /* Empieza nodo:438 / Elemento padre: 404   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(438)).setAttribute("ID","11" );
      ((Element)v.get(404)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(439)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(439)).setAttribute("TIPO","STRING" );
      ((Element)v.get(439)).setAttribute("VALOR","-3" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */

      /* Empieza nodo:440 / Elemento padre: 438   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(440)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(440)).setAttribute("TIPO","STRING" );
      ((Element)v.get(440)).setAttribute("VALOR","-3" );
      ((Element)v.get(438)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */
      /* Termina nodo:438   */

      /* Empieza nodo:441 / Elemento padre: 404   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(441)).setAttribute("ID","12" );
      ((Element)v.get(404)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(442)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(442)).setAttribute("TIPO","STRING" );
      ((Element)v.get(442)).setAttribute("VALOR","-4" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */

      /* Empieza nodo:443 / Elemento padre: 441   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(443)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(443)).setAttribute("TIPO","STRING" );
      ((Element)v.get(443)).setAttribute("VALOR","-4" );
      ((Element)v.get(441)).appendChild((Element)v.get(443));
      /* Termina nodo:443   */
      /* Termina nodo:441   */

      /* Empieza nodo:444 / Elemento padre: 404   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(444)).setAttribute("ID","13" );
      ((Element)v.get(404)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(445)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(445)).setAttribute("TIPO","STRING" );
      ((Element)v.get(445)).setAttribute("VALOR","-5" );
      ((Element)v.get(444)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */

      /* Empieza nodo:446 / Elemento padre: 444   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(446)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(446)).setAttribute("TIPO","STRING" );
      ((Element)v.get(446)).setAttribute("VALOR","-5" );
      ((Element)v.get(444)).appendChild((Element)v.get(446));
      /* Termina nodo:446   */
      /* Termina nodo:444   */

      /* Empieza nodo:447 / Elemento padre: 404   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(447)).setAttribute("ID","14" );
      ((Element)v.get(404)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(448)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(448)).setAttribute("TIPO","STRING" );
      ((Element)v.get(448)).setAttribute("VALOR","-6" );
      ((Element)v.get(447)).appendChild((Element)v.get(448));
      /* Termina nodo:448   */

      /* Empieza nodo:449 / Elemento padre: 447   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(449)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(449)).setAttribute("TIPO","STRING" );
      ((Element)v.get(449)).setAttribute("VALOR","-6" );
      ((Element)v.get(447)).appendChild((Element)v.get(449));
      /* Termina nodo:449   */
      /* Termina nodo:447   */

      /* Empieza nodo:450 / Elemento padre: 404   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(450)).setAttribute("ID","15" );
      ((Element)v.get(404)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(451)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(451)).setAttribute("TIPO","STRING" );
      ((Element)v.get(451)).setAttribute("VALOR","-7" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));
      /* Termina nodo:451   */

      /* Empieza nodo:452 / Elemento padre: 450   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(452)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(452)).setAttribute("TIPO","STRING" );
      ((Element)v.get(452)).setAttribute("VALOR","-7" );
      ((Element)v.get(450)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */
      /* Termina nodo:450   */

      /* Empieza nodo:453 / Elemento padre: 404   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(453)).setAttribute("ID","16" );
      ((Element)v.get(404)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(454)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(454)).setAttribute("TIPO","STRING" );
      ((Element)v.get(454)).setAttribute("VALOR","-8" );
      ((Element)v.get(453)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */

      /* Empieza nodo:455 / Elemento padre: 453   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(455)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(455)).setAttribute("TIPO","STRING" );
      ((Element)v.get(455)).setAttribute("VALOR","-8" );
      ((Element)v.get(453)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */
      /* Termina nodo:453   */

      /* Empieza nodo:456 / Elemento padre: 404   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(456)).setAttribute("ID","17" );
      ((Element)v.get(404)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(457)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(457)).setAttribute("TIPO","STRING" );
      ((Element)v.get(457)).setAttribute("VALOR","-9" );
      ((Element)v.get(456)).appendChild((Element)v.get(457));
      /* Termina nodo:457   */

      /* Empieza nodo:458 / Elemento padre: 456   */
   }

   private void getXML1890(Document doc) {
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(458)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(458)).setAttribute("TIPO","STRING" );
      ((Element)v.get(458)).setAttribute("VALOR","-9" );
      ((Element)v.get(456)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */
      /* Termina nodo:456   */
      /* Termina nodo:404   */
      /* Termina nodo:403   */
      /* Termina nodo:402   */

      /* Empieza nodo:459 / Elemento padre: 384   */
      v.add(doc.createElement("td"));
      ((Element)v.get(459)).setAttribute("width","100%" );
      ((Element)v.get(384)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(460)).setAttribute("src","b.gif" );
      ((Element)v.get(460)).setAttribute("width","8" );
      ((Element)v.get(460)).setAttribute("height","8" );
      ((Element)v.get(459)).appendChild((Element)v.get(460));
      /* Termina nodo:460   */
      /* Termina nodo:459   */
      /* Termina nodo:384   */

      /* Empieza nodo:461 / Elemento padre: 361   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(361)).appendChild((Element)v.get(461));

      /* Empieza nodo:462 / Elemento padre: 461   */
      v.add(doc.createElement("td"));
      ((Element)v.get(462)).setAttribute("colspan","4" );
      ((Element)v.get(461)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(463)).setAttribute("src","b.gif" );
      ((Element)v.get(463)).setAttribute("width","8" );
      ((Element)v.get(463)).setAttribute("height","8" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */
      /* Termina nodo:462   */
      /* Termina nodo:461   */
      /* Termina nodo:361   */
      /* Termina nodo:360   */
      /* Termina nodo:359   */
      /* Termina nodo:82   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:464 / Elemento padre: 75   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(465)).setAttribute("src","b.gif" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));
      /* Termina nodo:465   */
      /* Termina nodo:464   */
      /* Termina nodo:75   */

      /* Empieza nodo:466 / Elemento padre: 67   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(67)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("td"));
      ((Element)v.get(467)).setAttribute("colspan","4" );
      ((Element)v.get(466)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(468)).setAttribute("src","b.gif" );
      ((Element)v.get(468)).setAttribute("width","8" );
      ((Element)v.get(468)).setAttribute("height","15" );
      ((Element)v.get(467)).appendChild((Element)v.get(468));
      /* Termina nodo:468   */
      /* Termina nodo:467   */
      /* Termina nodo:466   */

      /* Empieza nodo:469 / Elemento padre: 67   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(67)).appendChild((Element)v.get(469));

      /* Empieza nodo:470 / Elemento padre: 469   */
      v.add(doc.createElement("td"));
      ((Element)v.get(469)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(471)).setAttribute("src","b.gif" );
      ((Element)v.get(470)).appendChild((Element)v.get(471));
      /* Termina nodo:471   */
      /* Termina nodo:470   */

      /* Empieza nodo:472 / Elemento padre: 469   */
      v.add(doc.createElement("td"));
      ((Element)v.get(469)).appendChild((Element)v.get(472));

      /* Empieza nodo:473 / Elemento padre: 472   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(472)).appendChild((Element)v.get(473));

      /* Empieza nodo:474 / Elemento padre: 473   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(474)).setAttribute("class","legend" );
      ((Element)v.get(473)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(475)).setAttribute("nombre","lblAtributosAsociadosPagoIntercompanias" );
      ((Element)v.get(475)).setAttribute("alto","13" );
      ((Element)v.get(475)).setAttribute("filas","1" );
      ((Element)v.get(475)).setAttribute("cod","00171" );
      ((Element)v.get(475)).setAttribute("id","legend" );
      ((Element)v.get(474)).appendChild((Element)v.get(475));
      /* Termina nodo:475   */
      /* Termina nodo:474   */

      /* Empieza nodo:476 / Elemento padre: 473   */
      v.add(doc.createElement("table"));
      ((Element)v.get(476)).setAttribute("width","100%" );
      ((Element)v.get(476)).setAttribute("border","0" );
      ((Element)v.get(476)).setAttribute("align","center" );
      ((Element)v.get(476)).setAttribute("cellspacing","0" );
      ((Element)v.get(476)).setAttribute("cellpadding","0" );
      ((Element)v.get(473)).appendChild((Element)v.get(476));

      /* Empieza nodo:477 / Elemento padre: 476   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(476)).appendChild((Element)v.get(477));

      /* Empieza nodo:478 / Elemento padre: 477   */
      v.add(doc.createElement("td"));
      ((Element)v.get(477)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("table"));
      ((Element)v.get(479)).setAttribute("width","711" );
      ((Element)v.get(479)).setAttribute("border","0" );
      ((Element)v.get(479)).setAttribute("align","left" );
      ((Element)v.get(479)).setAttribute("cellspacing","0" );
      ((Element)v.get(479)).setAttribute("cellpadding","0" );
      ((Element)v.get(478)).appendChild((Element)v.get(479));

      /* Empieza nodo:480 / Elemento padre: 479   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(479)).appendChild((Element)v.get(480));

      /* Empieza nodo:481 / Elemento padre: 480   */
      v.add(doc.createElement("td"));
      ((Element)v.get(481)).setAttribute("colspan","4" );
      ((Element)v.get(480)).appendChild((Element)v.get(481));

      /* Empieza nodo:482 / Elemento padre: 481   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(482)).setAttribute("src","b.gif" );
      ((Element)v.get(482)).setAttribute("width","8" );
      ((Element)v.get(482)).setAttribute("height","8" );
      ((Element)v.get(481)).appendChild((Element)v.get(482));
      /* Termina nodo:482   */
      /* Termina nodo:481   */
      /* Termina nodo:480   */

      /* Empieza nodo:483 / Elemento padre: 479   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(479)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("td"));
   }

   private void getXML1980(Document doc) {
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
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(487)).setAttribute("nombre","lblFacturaIntercompanias" );
      ((Element)v.get(487)).setAttribute("alto","13" );
      ((Element)v.get(487)).setAttribute("filas","1" );
      ((Element)v.get(487)).setAttribute("id","datosTitle" );
      ((Element)v.get(487)).setAttribute("cod","1378" );
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
      ((Element)v.get(490)).setAttribute("colspan","2" );
      ((Element)v.get(483)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(491)).setAttribute("nombre","lblCosto" );
      ((Element)v.get(491)).setAttribute("alto","13" );
      ((Element)v.get(491)).setAttribute("filas","1" );
      ((Element)v.get(491)).setAttribute("id","datosTitle" );
      ((Element)v.get(491)).setAttribute("cod","1379" );
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
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(495)).setAttribute("nombre","lblRazonSocialFactura" );
      ((Element)v.get(495)).setAttribute("alto","13" );
      ((Element)v.get(495)).setAttribute("filas","1" );
      ((Element)v.get(495)).setAttribute("id","datosTitle" );
      ((Element)v.get(495)).setAttribute("cod","1381" );
      ((Element)v.get(494)).appendChild((Element)v.get(495));
      /* Termina nodo:495   */
      /* Termina nodo:494   */

      /* Empieza nodo:496 / Elemento padre: 483   */
      v.add(doc.createElement("td"));
      ((Element)v.get(483)).appendChild((Element)v.get(496));

      /* Empieza nodo:497 / Elemento padre: 496   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(497)).setAttribute("src","b.gif" );
      ((Element)v.get(497)).setAttribute("width","25" );
      ((Element)v.get(497)).setAttribute("height","8" );
      ((Element)v.get(496)).appendChild((Element)v.get(497));
      /* Termina nodo:497   */
      /* Termina nodo:496   */

      /* Empieza nodo:498 / Elemento padre: 483   */
      v.add(doc.createElement("td"));
      ((Element)v.get(498)).setAttribute("colspan","3" );
      ((Element)v.get(483)).appendChild((Element)v.get(498));

      /* Empieza nodo:499 / Elemento padre: 498   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(499)).setAttribute("nombre","lblRazonSocialFacturada" );
      ((Element)v.get(499)).setAttribute("alto","13" );
      ((Element)v.get(499)).setAttribute("filas","1" );
      ((Element)v.get(499)).setAttribute("id","datosTitle" );
      ((Element)v.get(499)).setAttribute("cod","1382" );
      ((Element)v.get(498)).appendChild((Element)v.get(499));
      /* Termina nodo:499   */
      /* Termina nodo:498   */

      /* Empieza nodo:500 / Elemento padre: 483   */
      v.add(doc.createElement("td"));
      ((Element)v.get(500)).setAttribute("width","100%" );
      ((Element)v.get(483)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(501)).setAttribute("src","b.gif" );
      ((Element)v.get(501)).setAttribute("width","8" );
      ((Element)v.get(501)).setAttribute("height","8" );
      ((Element)v.get(500)).appendChild((Element)v.get(501));
      /* Termina nodo:501   */
      /* Termina nodo:500   */
      /* Termina nodo:483   */

      /* Empieza nodo:502 / Elemento padre: 479   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(479)).appendChild((Element)v.get(502));

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
      ((Element)v.get(505)).setAttribute("valign","bottom" );
      ((Element)v.get(502)).appendChild((Element)v.get(505));

      /* Empieza nodo:506 / Elemento padre: 505   */
      v.add(doc.createElement("table"));
      ((Element)v.get(506)).setAttribute("width","100%" );
      ((Element)v.get(506)).setAttribute("border","0" );
      ((Element)v.get(506)).setAttribute("cellspacing","0" );
      ((Element)v.get(506)).setAttribute("cellpadding","0" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(505)).appendChild((Element)v.get(506));

      /* Empieza nodo:507 / Elemento padre: 506   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(506)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
      v.add(doc.createElement("td"));
      ((Element)v.get(508)).setAttribute("class","datosCampos" );
      ((Element)v.get(507)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(509)).setAttribute("nombre","FacturaIntercompanias" );
      ((Element)v.get(509)).setAttribute("tipo","H" );
      ((Element)v.get(509)).setAttribute("id","datosCampos" );
      ((Element)v.get(508)).appendChild((Element)v.get(509));

      /* Empieza nodo:510 / Elemento padre: 509   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(510)).setAttribute("valor","S" );
      ((Element)v.get(510)).setAttribute("check","N" );
      ((Element)v.get(510)).setAttribute("onfocus","cambiaRadioB('S')" );
      ((Element)v.get(510)).setAttribute("id","datosCampos" );
      ((Element)v.get(510)).setAttribute("cod","117" );
      ((Element)v.get(509)).appendChild((Element)v.get(510));

      /* Elemento padre:510 / Elemento actual: 511   */
      v.add(doc.createTextNode("yy"));
      ((Element)v.get(510)).appendChild((Text)v.get(511));

      /* Termina nodo Texto:511   */
      /* Termina nodo:510   */

      /* Empieza nodo:512 / Elemento padre: 509   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(512)).setAttribute("valor","N" );
      ((Element)v.get(512)).setAttribute("check","N" );
      ((Element)v.get(512)).setAttribute("onfocus","cambiaRadioB('N')" );
      ((Element)v.get(512)).setAttribute("id","datosCampos" );
      ((Element)v.get(512)).setAttribute("cod","87" );
      ((Element)v.get(509)).appendChild((Element)v.get(512));

      /* Elemento padre:512 / Elemento actual: 513   */
      v.add(doc.createTextNode("nn"));
      ((Element)v.get(512)).appendChild((Text)v.get(513));

      /* Termina nodo Texto:513   */
      /* Termina nodo:512   */
      /* Termina nodo:509   */
      /* Termina nodo:508   */
      /* Termina nodo:507   */
      /* Termina nodo:506   */
      /* Termina nodo:505   */

      /* Empieza nodo:514 / Elemento padre: 502   */
      v.add(doc.createElement("td"));
      ((Element)v.get(502)).appendChild((Element)v.get(514));

      /* Empieza nodo:515 / Elemento padre: 514   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(515)).setAttribute("src","b.gif" );
      ((Element)v.get(515)).setAttribute("width","25" );
      ((Element)v.get(515)).setAttribute("height","8" );
      ((Element)v.get(514)).appendChild((Element)v.get(515));
      /* Termina nodo:515   */
      /* Termina nodo:514   */

      /* Empieza nodo:516 / Elemento padre: 502   */
      v.add(doc.createElement("td"));
      ((Element)v.get(516)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(516)).setAttribute("valign","bottom" );
      ((Element)v.get(502)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(517)).setAttribute("nombre","txtCosto" );
      ((Element)v.get(517)).setAttribute("id","datosCampos" );
      ((Element)v.get(517)).setAttribute("max","5" );
      ((Element)v.get(517)).setAttribute("tipo","" );
      ((Element)v.get(517)).setAttribute("onchange","" );
      ((Element)v.get(517)).setAttribute("req","N" );
      ((Element)v.get(517)).setAttribute("size","5" );
      ((Element)v.get(517)).setAttribute("valor","" );
      ((Element)v.get(517)).setAttribute("validacion","" );
      ((Element)v.get(517)).setAttribute("ontab","tab('txtCosto')" );
      ((Element)v.get(517)).setAttribute("onshtab","shtab('txtCosto')" );
      ((Element)v.get(516)).appendChild((Element)v.get(517));
      /* Termina nodo:517   */
      /* Termina nodo:516   */

      /* Empieza nodo:518 / Elemento padre: 502   */
      v.add(doc.createElement("td"));
      ((Element)v.get(502)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(519)).setAttribute("nombre","lbldtCosto" );
      ((Element)v.get(519)).setAttribute("ancho","30" );
      ((Element)v.get(519)).setAttribute("alto","13" );
      ((Element)v.get(519)).setAttribute("filas","1" );
      ((Element)v.get(519)).setAttribute("id","datosCampos" );
      ((Element)v.get(519)).setAttribute("cod","1380" );
      ((Element)v.get(518)).appendChild((Element)v.get(519));
      /* Termina nodo:519   */
      /* Termina nodo:518   */

      /* Empieza nodo:520 / Elemento padre: 502   */
      v.add(doc.createElement("td"));
      ((Element)v.get(502)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(521)).setAttribute("src","b.gif" );
      ((Element)v.get(521)).setAttribute("width","25" );
      ((Element)v.get(521)).setAttribute("height","8" );
      ((Element)v.get(520)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */
      /* Termina nodo:520   */

      /* Empieza nodo:522 / Elemento padre: 502   */
      v.add(doc.createElement("td"));
      ((Element)v.get(522)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(522)).setAttribute("valign","top" );
      ((Element)v.get(502)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(523)).setAttribute("nombre","cbRazonSocialFactura" );
      ((Element)v.get(523)).setAttribute("id","datosCampos" );
      ((Element)v.get(523)).setAttribute("size","1" );
      ((Element)v.get(523)).setAttribute("multiple","N" );
      ((Element)v.get(523)).setAttribute("req","N" );
      ((Element)v.get(523)).setAttribute("valorinicial","" );
      ((Element)v.get(523)).setAttribute("textoinicial","" );
      ((Element)v.get(523)).setAttribute("ontab","tab('cbRazonSocialFactura')" );
      ((Element)v.get(523)).setAttribute("onshtab","shtab('cbRazonSocialFactura')" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));

      /* Empieza nodo:524 / Elemento padre: 523   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(523)).appendChild((Element)v.get(524));
      /* Termina nodo:524   */
      /* Termina nodo:523   */
      /* Termina nodo:522   */

      /* Empieza nodo:525 / Elemento padre: 502   */
      v.add(doc.createElement("td"));
      ((Element)v.get(502)).appendChild((Element)v.get(525));

      /* Empieza nodo:526 / Elemento padre: 525   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(526)).setAttribute("src","b.gif" );
      ((Element)v.get(526)).setAttribute("width","25" );
      ((Element)v.get(526)).setAttribute("height","8" );
      ((Element)v.get(525)).appendChild((Element)v.get(526));
      /* Termina nodo:526   */
      /* Termina nodo:525   */

      /* Empieza nodo:527 / Elemento padre: 502   */
      v.add(doc.createElement("td"));
      ((Element)v.get(527)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(502)).appendChild((Element)v.get(527));

      /* Empieza nodo:528 / Elemento padre: 527   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(528)).setAttribute("nombre","txtRazonSocialF" );
      ((Element)v.get(528)).setAttribute("id","datosCampos" );
      ((Element)v.get(528)).setAttribute("max","15" );
      ((Element)v.get(528)).setAttribute("tipo","" );
      ((Element)v.get(528)).setAttribute("onchange","" );
      ((Element)v.get(528)).setAttribute("req","N" );
      ((Element)v.get(528)).setAttribute("size","15" );
      ((Element)v.get(528)).setAttribute("valor","" );
      ((Element)v.get(528)).setAttribute("validacion","" );
      ((Element)v.get(528)).setAttribute("ontab","tab('txtRazonSocialF')" );
      ((Element)v.get(528)).setAttribute("onshtab","shtab('txtRazonSocialF')" );
      ((Element)v.get(527)).appendChild((Element)v.get(528));
      /* Termina nodo:528   */
      /* Termina nodo:527   */

      /* Empieza nodo:529 / Elemento padre: 502   */
      v.add(doc.createElement("td"));
      ((Element)v.get(502)).appendChild((Element)v.get(529));

      /* Empieza nodo:530 / Elemento padre: 529   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(530)).setAttribute("src","b.gif" );
      ((Element)v.get(530)).setAttribute("width","8" );
      ((Element)v.get(530)).setAttribute("height","8" );
      ((Element)v.get(529)).appendChild((Element)v.get(530));
      /* Termina nodo:530   */
      /* Termina nodo:529   */

      /* Empieza nodo:531 / Elemento padre: 502   */
      v.add(doc.createElement("td"));
      ((Element)v.get(502)).appendChild((Element)v.get(531));

      /* Empieza nodo:532 / Elemento padre: 531   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(532)).setAttribute("src","iconBuscar.gif" );
      ((Element)v.get(532)).setAttribute("onclick","accionBuscarClientes()" );
      ((Element)v.get(531)).appendChild((Element)v.get(532));
      /* Termina nodo:532   */
      /* Termina nodo:531   */

      /* Empieza nodo:533 / Elemento padre: 502   */
      v.add(doc.createElement("td"));
      ((Element)v.get(533)).setAttribute("width","100%" );
      ((Element)v.get(502)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(534)).setAttribute("src","b.gif" );
      ((Element)v.get(534)).setAttribute("width","8" );
      ((Element)v.get(534)).setAttribute("height","8" );
      ((Element)v.get(533)).appendChild((Element)v.get(534));
      /* Termina nodo:534   */
      /* Termina nodo:533   */
      /* Termina nodo:502   */

      /* Empieza nodo:535 / Elemento padre: 479   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(479)).appendChild((Element)v.get(535));

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
      /* Termina nodo:479   */
      /* Termina nodo:478   */
      /* Termina nodo:477   */

      /* Empieza nodo:538 / Elemento padre: 476   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(476)).appendChild((Element)v.get(538));

      /* Empieza nodo:539 / Elemento padre: 538   */
      v.add(doc.createElement("td"));
      ((Element)v.get(538)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("table"));
      ((Element)v.get(540)).setAttribute("width","711" );
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
      ((Element)v.get(541)).appendChild((Element)v.get(542));

      /* Empieza nodo:543 / Elemento padre: 542   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(543)).setAttribute("src","b.gif" );
      ((Element)v.get(543)).setAttribute("width","8" );
      ((Element)v.get(543)).setAttribute("height","8" );
      ((Element)v.get(542)).appendChild((Element)v.get(543));
      /* Termina nodo:543   */
      /* Termina nodo:542   */

      /* Empieza nodo:544 / Elemento padre: 541   */
      v.add(doc.createElement("td"));
      ((Element)v.get(541)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(545)).setAttribute("nombre","lblTipoSolicitudPago" );
      ((Element)v.get(545)).setAttribute("alto","13" );
      ((Element)v.get(545)).setAttribute("filas","1" );
      ((Element)v.get(545)).setAttribute("id","datosTitle" );
      ((Element)v.get(545)).setAttribute("cod","1383" );
      ((Element)v.get(544)).appendChild((Element)v.get(545));
      /* Termina nodo:545   */
      /* Termina nodo:544   */

      /* Empieza nodo:546 / Elemento padre: 541   */
      v.add(doc.createElement("td"));
      ((Element)v.get(541)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(547)).setAttribute("src","b.gif" );
      ((Element)v.get(547)).setAttribute("width","25" );
      ((Element)v.get(547)).setAttribute("height","8" );
      ((Element)v.get(546)).appendChild((Element)v.get(547));
      /* Termina nodo:547   */
      /* Termina nodo:546   */

      /* Empieza nodo:548 / Elemento padre: 541   */
      v.add(doc.createElement("td"));
      ((Element)v.get(541)).appendChild((Element)v.get(548));

      /* Empieza nodo:549 / Elemento padre: 548   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(549)).setAttribute("nombre","lblTipoPosicionPago" );
      ((Element)v.get(549)).setAttribute("alto","13" );
      ((Element)v.get(549)).setAttribute("filas","1" );
      ((Element)v.get(549)).setAttribute("id","datosTitle" );
      ((Element)v.get(549)).setAttribute("cod","1384" );
      ((Element)v.get(548)).appendChild((Element)v.get(549));
      /* Termina nodo:549   */
      /* Termina nodo:548   */

      /* Empieza nodo:550 / Elemento padre: 541   */
      v.add(doc.createElement("td"));
      ((Element)v.get(550)).setAttribute("width","100%" );
      ((Element)v.get(541)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(551)).setAttribute("src","b.gif" );
      ((Element)v.get(551)).setAttribute("width","8" );
      ((Element)v.get(551)).setAttribute("height","8" );
      ((Element)v.get(550)).appendChild((Element)v.get(551));
      /* Termina nodo:551   */
      /* Termina nodo:550   */
      /* Termina nodo:541   */

      /* Empieza nodo:552 / Elemento padre: 540   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(540)).appendChild((Element)v.get(552));

      /* Empieza nodo:553 / Elemento padre: 552   */
      v.add(doc.createElement("td"));
      ((Element)v.get(552)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(554)).setAttribute("src","b.gif" );
      ((Element)v.get(554)).setAttribute("width","8" );
      ((Element)v.get(554)).setAttribute("height","8" );
      ((Element)v.get(553)).appendChild((Element)v.get(554));
      /* Termina nodo:554   */
      /* Termina nodo:553   */

      /* Empieza nodo:555 / Elemento padre: 552   */
      v.add(doc.createElement("td"));
      ((Element)v.get(555)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(555)).setAttribute("valign","top" );
      ((Element)v.get(552)).appendChild((Element)v.get(555));

      /* Empieza nodo:556 / Elemento padre: 555   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(556)).setAttribute("nombre","cbTipoSolicitudPago" );
      ((Element)v.get(556)).setAttribute("id","datosCampos" );
      ((Element)v.get(556)).setAttribute("size","1" );
      ((Element)v.get(556)).setAttribute("multiple","N" );
      ((Element)v.get(556)).setAttribute("req","N" );
      ((Element)v.get(556)).setAttribute("valorinicial","" );
      ((Element)v.get(556)).setAttribute("textoinicial","" );
      ((Element)v.get(556)).setAttribute("ontab","tab('cbTipoSolicitudPago')" );
      ((Element)v.get(556)).setAttribute("onshtab","shtab('cbTipoSolicitudPago')" );
      ((Element)v.get(556)).setAttribute("onchange","tipoSolicitudParaPagoOnChange()" );
      ((Element)v.get(555)).appendChild((Element)v.get(556));

      /* Empieza nodo:557 / Elemento padre: 556   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(556)).appendChild((Element)v.get(557));
      /* Termina nodo:557   */
      /* Termina nodo:556   */
      /* Termina nodo:555   */

      /* Empieza nodo:558 / Elemento padre: 552   */
      v.add(doc.createElement("td"));
      ((Element)v.get(552)).appendChild((Element)v.get(558));

      /* Empieza nodo:559 / Elemento padre: 558   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(559)).setAttribute("src","b.gif" );
      ((Element)v.get(559)).setAttribute("width","25" );
      ((Element)v.get(559)).setAttribute("height","8" );
      ((Element)v.get(558)).appendChild((Element)v.get(559));
      /* Termina nodo:559   */
      /* Termina nodo:558   */

      /* Empieza nodo:560 / Elemento padre: 552   */
      v.add(doc.createElement("td"));
      ((Element)v.get(560)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(560)).setAttribute("valign","top" );
      ((Element)v.get(552)).appendChild((Element)v.get(560));

      /* Empieza nodo:561 / Elemento padre: 560   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(561)).setAttribute("nombre","cbTipoPosicionPago" );
      ((Element)v.get(561)).setAttribute("id","datosCampos" );
      ((Element)v.get(561)).setAttribute("size","1" );
      ((Element)v.get(561)).setAttribute("multiple","N" );
      ((Element)v.get(561)).setAttribute("req","N" );
      ((Element)v.get(561)).setAttribute("valorinicial","" );
      ((Element)v.get(561)).setAttribute("textoinicial","" );
      ((Element)v.get(561)).setAttribute("ontab","tab('cbTipoPosicionPago')" );
      ((Element)v.get(561)).setAttribute("onshtab","shtab('cbTipoPosicionPago')" );
      ((Element)v.get(561)).setAttribute("onchange","tipoPosicionParaPagoOnChange()" );
      ((Element)v.get(560)).appendChild((Element)v.get(561));

      /* Empieza nodo:562 / Elemento padre: 561   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(561)).appendChild((Element)v.get(562));
      /* Termina nodo:562   */
      /* Termina nodo:561   */
      /* Termina nodo:560   */

      /* Empieza nodo:563 / Elemento padre: 552   */
      v.add(doc.createElement("td"));
      ((Element)v.get(563)).setAttribute("width","100%" );
      ((Element)v.get(552)).appendChild((Element)v.get(563));

      /* Empieza nodo:564 / Elemento padre: 563   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(564)).setAttribute("src","b.gif" );
      ((Element)v.get(564)).setAttribute("width","8" );
      ((Element)v.get(564)).setAttribute("height","8" );
      ((Element)v.get(563)).appendChild((Element)v.get(564));
      /* Termina nodo:564   */
      /* Termina nodo:563   */
      /* Termina nodo:552   */

      /* Empieza nodo:565 / Elemento padre: 540   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(540)).appendChild((Element)v.get(565));

      /* Empieza nodo:566 / Elemento padre: 565   */
      v.add(doc.createElement("td"));
      ((Element)v.get(566)).setAttribute("colspan","4" );
      ((Element)v.get(565)).appendChild((Element)v.get(566));

      /* Empieza nodo:567 / Elemento padre: 566   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(567)).setAttribute("src","b.gif" );
      ((Element)v.get(567)).setAttribute("width","8" );
      ((Element)v.get(567)).setAttribute("height","8" );
      ((Element)v.get(566)).appendChild((Element)v.get(567));
      /* Termina nodo:567   */
      /* Termina nodo:566   */
      /* Termina nodo:565   */
      /* Termina nodo:540   */
      /* Termina nodo:539   */
      /* Termina nodo:538   */

      /* Empieza nodo:568 / Elemento padre: 476   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(476)).appendChild((Element)v.get(568));

      /* Empieza nodo:569 / Elemento padre: 568   */
      v.add(doc.createElement("td"));
      ((Element)v.get(568)).appendChild((Element)v.get(569));

      /* Empieza nodo:570 / Elemento padre: 569   */
      v.add(doc.createElement("table"));
      ((Element)v.get(570)).setAttribute("width","711" );
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(570)).setAttribute("border","0" );
      ((Element)v.get(570)).setAttribute("align","left" );
      ((Element)v.get(570)).setAttribute("cellspacing","0" );
      ((Element)v.get(570)).setAttribute("cellpadding","0" );
      ((Element)v.get(569)).appendChild((Element)v.get(570));

      /* Empieza nodo:571 / Elemento padre: 570   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(570)).appendChild((Element)v.get(571));

      /* Empieza nodo:572 / Elemento padre: 571   */
      v.add(doc.createElement("td"));
      ((Element)v.get(571)).appendChild((Element)v.get(572));

      /* Empieza nodo:573 / Elemento padre: 572   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(573)).setAttribute("src","b.gif" );
      ((Element)v.get(573)).setAttribute("width","8" );
      ((Element)v.get(573)).setAttribute("height","8" );
      ((Element)v.get(572)).appendChild((Element)v.get(573));
      /* Termina nodo:573   */
      /* Termina nodo:572   */

      /* Empieza nodo:574 / Elemento padre: 571   */
      v.add(doc.createElement("td"));
      ((Element)v.get(571)).appendChild((Element)v.get(574));

      /* Empieza nodo:575 / Elemento padre: 574   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(575)).setAttribute("nombre","lblSubtipoPosicionPago" );
      ((Element)v.get(575)).setAttribute("alto","13" );
      ((Element)v.get(575)).setAttribute("filas","1" );
      ((Element)v.get(575)).setAttribute("id","datosTitle" );
      ((Element)v.get(575)).setAttribute("cod","2582" );
      ((Element)v.get(574)).appendChild((Element)v.get(575));
      /* Termina nodo:575   */
      /* Termina nodo:574   */

      /* Empieza nodo:576 / Elemento padre: 571   */
      v.add(doc.createElement("td"));
      ((Element)v.get(576)).setAttribute("width","100%" );
      ((Element)v.get(571)).appendChild((Element)v.get(576));

      /* Empieza nodo:577 / Elemento padre: 576   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(577)).setAttribute("src","b.gif" );
      ((Element)v.get(577)).setAttribute("width","8" );
      ((Element)v.get(577)).setAttribute("height","8" );
      ((Element)v.get(576)).appendChild((Element)v.get(577));
      /* Termina nodo:577   */
      /* Termina nodo:576   */
      /* Termina nodo:571   */

      /* Empieza nodo:578 / Elemento padre: 570   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(570)).appendChild((Element)v.get(578));

      /* Empieza nodo:579 / Elemento padre: 578   */
      v.add(doc.createElement("td"));
      ((Element)v.get(578)).appendChild((Element)v.get(579));

      /* Empieza nodo:580 / Elemento padre: 579   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(580)).setAttribute("src","b.gif" );
      ((Element)v.get(580)).setAttribute("width","8" );
      ((Element)v.get(580)).setAttribute("height","8" );
      ((Element)v.get(579)).appendChild((Element)v.get(580));
      /* Termina nodo:580   */
      /* Termina nodo:579   */

      /* Empieza nodo:581 / Elemento padre: 578   */
      v.add(doc.createElement("td"));
      ((Element)v.get(581)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(578)).appendChild((Element)v.get(581));

      /* Empieza nodo:582 / Elemento padre: 581   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(582)).setAttribute("nombre","cbSubtipoPosicionPago" );
      ((Element)v.get(582)).setAttribute("id","datosCampos" );
      ((Element)v.get(582)).setAttribute("size","1" );
      ((Element)v.get(582)).setAttribute("multiple","N" );
      ((Element)v.get(582)).setAttribute("req","N" );
      ((Element)v.get(582)).setAttribute("valorinicial","" );
      ((Element)v.get(582)).setAttribute("textoinicial","" );
      ((Element)v.get(582)).setAttribute("ontab","tab('cbSubtipoPosicionPago')" );
      ((Element)v.get(582)).setAttribute("onshtab","shtab('cbSubtipoPosicionPago')" );
      ((Element)v.get(581)).appendChild((Element)v.get(582));

      /* Empieza nodo:583 / Elemento padre: 582   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(582)).appendChild((Element)v.get(583));
      /* Termina nodo:583   */
      /* Termina nodo:582   */
      /* Termina nodo:581   */

      /* Empieza nodo:584 / Elemento padre: 578   */
      v.add(doc.createElement("td"));
      ((Element)v.get(584)).setAttribute("width","100%" );
      ((Element)v.get(578)).appendChild((Element)v.get(584));

      /* Empieza nodo:585 / Elemento padre: 584   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(585)).setAttribute("src","b.gif" );
      ((Element)v.get(585)).setAttribute("width","8" );
      ((Element)v.get(585)).setAttribute("height","8" );
      ((Element)v.get(584)).appendChild((Element)v.get(585));
      /* Termina nodo:585   */
      /* Termina nodo:584   */
      /* Termina nodo:578   */

      /* Empieza nodo:586 / Elemento padre: 570   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(570)).appendChild((Element)v.get(586));

      /* Empieza nodo:587 / Elemento padre: 586   */
      v.add(doc.createElement("td"));
      ((Element)v.get(587)).setAttribute("colspan","4" );
      ((Element)v.get(586)).appendChild((Element)v.get(587));

      /* Empieza nodo:588 / Elemento padre: 587   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(588)).setAttribute("src","b.gif" );
      ((Element)v.get(588)).setAttribute("width","8" );
      ((Element)v.get(588)).setAttribute("height","8" );
      ((Element)v.get(587)).appendChild((Element)v.get(588));
      /* Termina nodo:588   */
      /* Termina nodo:587   */
      /* Termina nodo:586   */
      /* Termina nodo:570   */
      /* Termina nodo:569   */
      /* Termina nodo:568   */
      /* Termina nodo:476   */
      /* Termina nodo:473   */
      /* Termina nodo:472   */

      /* Empieza nodo:589 / Elemento padre: 469   */
      v.add(doc.createElement("td"));
      ((Element)v.get(469)).appendChild((Element)v.get(589));

      /* Empieza nodo:590 / Elemento padre: 589   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(590)).setAttribute("src","b.gif" );
      ((Element)v.get(589)).appendChild((Element)v.get(590));
      /* Termina nodo:590   */
      /* Termina nodo:589   */
      /* Termina nodo:469   */

      /* Empieza nodo:591 / Elemento padre: 67   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(67)).appendChild((Element)v.get(591));

      /* Empieza nodo:592 / Elemento padre: 591   */
      v.add(doc.createElement("td"));
      ((Element)v.get(592)).setAttribute("width","12" );
      ((Element)v.get(592)).setAttribute("align","center" );
      ((Element)v.get(591)).appendChild((Element)v.get(592));

      /* Empieza nodo:593 / Elemento padre: 592   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(593)).setAttribute("src","b.gif" );
      ((Element)v.get(593)).setAttribute("width","12" );
      ((Element)v.get(593)).setAttribute("height","12" );
      ((Element)v.get(592)).appendChild((Element)v.get(593));
      /* Termina nodo:593   */
      /* Termina nodo:592   */

      /* Empieza nodo:594 / Elemento padre: 591   */
   }

   private void getXML2430(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(594)).setAttribute("width","756" );
      ((Element)v.get(591)).appendChild((Element)v.get(594));

      /* Empieza nodo:595 / Elemento padre: 594   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(595)).setAttribute("src","b.gif" );
      ((Element)v.get(594)).appendChild((Element)v.get(595));
      /* Termina nodo:595   */
      /* Termina nodo:594   */

      /* Empieza nodo:596 / Elemento padre: 591   */
      v.add(doc.createElement("td"));
      ((Element)v.get(596)).setAttribute("width","12" );
      ((Element)v.get(591)).appendChild((Element)v.get(596));

      /* Empieza nodo:597 / Elemento padre: 596   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(597)).setAttribute("src","b.gif" );
      ((Element)v.get(597)).setAttribute("width","12" );
      ((Element)v.get(597)).setAttribute("height","1" );
      ((Element)v.get(596)).appendChild((Element)v.get(597));
      /* Termina nodo:597   */
      /* Termina nodo:596   */
      /* Termina nodo:591   */
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:27   */


   }

}

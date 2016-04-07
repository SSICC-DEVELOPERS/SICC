
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_parametros_cartera_insertar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_parametros_cartera_insertar" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Insertar parámetros de cartera" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag();" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Empieza nodo:2 / Elemento padre: 1   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(2)).setAttribute("name","cbCodConfiguracion" );
      ((Element)v.get(2)).setAttribute("required","true" );
      ((Element)v.get(2)).setAttribute("cod","1474" );
      ((Element)v.get(2)).setAttribute("group","grupo1" );
      ((Element)v.get(1)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 1   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(3)).setAttribute("name","cbNivelRiesgo" );
      ((Element)v.get(3)).setAttribute("required","true" );
      ((Element)v.get(3)).setAttribute("cod","928" );
      ((Element)v.get(3)).setAttribute("group","grupo1" );
      ((Element)v.get(1)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 1   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(4)).setAttribute("name","cbGrupoSolicitud" );
      ((Element)v.get(4)).setAttribute("required","true" );
      ((Element)v.get(4)).setAttribute("cod","888" );
      ((Element)v.get(4)).setAttribute("group","grupo1" );
      ((Element)v.get(1)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 1   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(5)).setAttribute("name","cbMarca" );
      ((Element)v.get(5)).setAttribute("required","true" );
      ((Element)v.get(5)).setAttribute("cod","6" );
      ((Element)v.get(5)).setAttribute("group","grupo1" );
      ((Element)v.get(1)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 1   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(6)).setAttribute("name","cbCanal" );
      ((Element)v.get(6)).setAttribute("required","true" );
      ((Element)v.get(6)).setAttribute("cod","7" );
      ((Element)v.get(6)).setAttribute("group","grupo1" );
      ((Element)v.get(1)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 1   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbSubgerenciaVentas" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","124" );
      ((Element)v.get(7)).setAttribute("group","grupo1" );
      ((Element)v.get(1)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 1   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","txtLineaCreditoInicial" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","1475" );
      ((Element)v.get(8)).setAttribute("format","n" );
      ((Element)v.get(8)).setAttribute("min","0" );
      ((Element)v.get(8)).setAttribute("max","9999999999.99" );
      ((Element)v.get(8)).setAttribute("group","grupo1" );
      ((Element)v.get(1)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 1   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbNivelRiesgoInicial" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","1476" );
      ((Element)v.get(9)).setAttribute("group","grupo1" );
      ((Element)v.get(1)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */
      /* Termina nodo:1   */

      /* Empieza nodo:10 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(10)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(11)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(12)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(13)).setAttribute("src","contenido_parametros_cartera_insertar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(14)).setAttribute("nombre","frmInsertarCartera" );
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
      ((Element)v.get(17)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 14   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","hPais" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","hDatosLista" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","hidAsignaciones" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","hCodigoConf" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hGrupoSolic" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","hNivelRiesgo" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","hOidCodConf" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hidAsignTemp" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","oid" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hidCodConf" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hidNivelRiesgo" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hidGrupoSolicitud" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","hidIndDiasDeuda" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hidDiasDeuda" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hidIndLineaCredito" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hidFechaDesde" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hidFechaHasta" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hidIndValidacion" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hidPorcValidacion" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hidIndMontoMax" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hidMontoMax" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","hidIndPorcMax" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","hidPorcMaxPerm" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hidDiasAdici" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hidOid" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","marcaDefecto" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","canalDefecto" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","sgvDefecto" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","regionDefecto" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","zonaDefecto" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","focoSolapa" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 14   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(14)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 14   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(52)).setAttribute("nombre","capaEspacio2" );
      ((Element)v.get(14)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("table"));
      ((Element)v.get(53)).setAttribute("width","100%" );
      ((Element)v.get(53)).setAttribute("height","100%" );
      ((Element)v.get(53)).setAttribute("border","0" );
      ((Element)v.get(53)).setAttribute("align","center" );
      ((Element)v.get(53)).setAttribute("cellpadding","0" );
      ((Element)v.get(53)).setAttribute("cellspacing","0" );
      ((Element)v.get(53)).setAttribute("class","menu4" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(55)).setAttribute("width","12" );
      ((Element)v.get(55)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(55)).setAttribute("class","menu5texto" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","12" );
      ((Element)v.get(56)).setAttribute("height","35" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(57)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(57)).setAttribute("class","menu5texto" );
      ((Element)v.get(54)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(59)).setAttribute("width","10" );
      ((Element)v.get(59)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(59)).setAttribute("class","menu5texto" );
      ((Element)v.get(54)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(60)).setAttribute("src","b.gif" );
      ((Element)v.get(60)).setAttribute("width","10" );
      ((Element)v.get(60)).setAttribute("height","8" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(61)).setAttribute("width","92" );
      ((Element)v.get(61)).setAttribute("nowrap","nowrap" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(61)).setAttribute("class","menu5texto" );
      ((Element)v.get(54)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("table"));
      ((Element)v.get(62)).setAttribute("width","75" );
      ((Element)v.get(62)).setAttribute("border","1" );
      ((Element)v.get(62)).setAttribute("align","center" );
      ((Element)v.get(62)).setAttribute("cellpadding","1" );
      ((Element)v.get(62)).setAttribute("cellspacing","0" );
      ((Element)v.get(62)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(62)).setAttribute("bgcolor","#496A9A" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(63)).setAttribute("align","left" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(65)).setAttribute("nombre","lblUnidades" );
      ((Element)v.get(65)).setAttribute("ancho","150" );
      ((Element)v.get(65)).setAttribute("alto","13" );
      ((Element)v.get(65)).setAttribute("filas","1" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(65)).setAttribute("id","menu5textoblanca" );
      ((Element)v.get(65)).setAttribute("cod","0043" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:66 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("width","10" );
      ((Element)v.get(66)).setAttribute("class","menu5texto" );
      ((Element)v.get(54)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","10" );
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).setAttribute("width","20" );
      ((Element)v.get(68)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(68)).setAttribute("class","menu5texto" );
      ((Element)v.get(54)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("table"));
      ((Element)v.get(69)).setAttribute("width","75" );
      ((Element)v.get(69)).setAttribute("border","1" );
      ((Element)v.get(69)).setAttribute("align","center" );
      ((Element)v.get(69)).setAttribute("cellpadding","1" );
      ((Element)v.get(69)).setAttribute("cellspacing","0" );
      ((Element)v.get(69)).setAttribute("bordercolor","#496A9A" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(70)).setAttribute("align","left" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).setAttribute("id","codigo" );
      ((Element)v.get(71)).setAttribute("onmouseover","poneManito('codigo');" );
      ((Element)v.get(71)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(71)).setAttribute("onclick","pasoACodigo();" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(72)).setAttribute("nombre","lblCodigoConf" );
      ((Element)v.get(72)).setAttribute("ancho","120" );
      ((Element)v.get(72)).setAttribute("alto","13" );
      ((Element)v.get(72)).setAttribute("filas","1" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(72)).setAttribute("id","menu5textonegrita" );
      ((Element)v.get(72)).setAttribute("cod","00402" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:73 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).setAttribute("width","16" );
      ((Element)v.get(73)).setAttribute("class","menu5texto" );
      ((Element)v.get(54)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","12" );
      ((Element)v.get(74)).setAttribute("height","8" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:75 / Elemento padre: 52   */
      v.add(doc.createElement("table"));
      ((Element)v.get(75)).setAttribute("width","100%" );
      ((Element)v.get(75)).setAttribute("border","0" );
      ((Element)v.get(75)).setAttribute("cellspacing","0" );
      ((Element)v.get(75)).setAttribute("cellpadding","0" );
      ((Element)v.get(52)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).setAttribute("width","12" );
      ((Element)v.get(77)).setAttribute("align","center" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","12" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(78)).setAttribute("height","12" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(79)).setAttribute("width","750" );
      ((Element)v.get(76)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:81 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(81)).setAttribute("width","12" );
      ((Element)v.get(76)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","12" );
      ((Element)v.get(82)).setAttribute("height","1" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:76   */

      /* Empieza nodo:83 / Elemento padre: 75   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(75)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(85)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:86 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(88)).setAttribute("class","legend" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(89)).setAttribute("nombre","lblUnidadesAdministrativas" );
      ((Element)v.get(89)).setAttribute("alto","13" );
      ((Element)v.get(89)).setAttribute("filas","1" );
      ((Element)v.get(89)).setAttribute("cod","0043" );
      ((Element)v.get(89)).setAttribute("id","legend" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:90 / Elemento padre: 87   */
      v.add(doc.createElement("table"));
      ((Element)v.get(90)).setAttribute("width","100%" );
      ((Element)v.get(90)).setAttribute("border","0" );
      ((Element)v.get(90)).setAttribute("align","center" );
      ((Element)v.get(90)).setAttribute("cellspacing","0" );
      ((Element)v.get(90)).setAttribute("cellpadding","0" );
      ((Element)v.get(87)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("table"));
      ((Element)v.get(93)).setAttribute("width","631" );
      ((Element)v.get(93)).setAttribute("border","0" );
      ((Element)v.get(93)).setAttribute("align","left" );
      ((Element)v.get(93)).setAttribute("cellspacing","0" );
      ((Element)v.get(93)).setAttribute("cellpadding","0" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("td"));
      ((Element)v.get(95)).setAttribute("colspan","4" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","8" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:97 / Elemento padre: 93   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(93)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(99)).setAttribute("width","8" );
      ((Element)v.get(99)).setAttribute("height","8" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(101)).setAttribute("nombre","lblCodConfiguracion" );
      ((Element)v.get(101)).setAttribute("alto","13" );
      ((Element)v.get(101)).setAttribute("filas","1" );
      ((Element)v.get(101)).setAttribute("valor","" );
      ((Element)v.get(101)).setAttribute("id","datosTitle" );
      ((Element)v.get(101)).setAttribute("cod","1474" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","8" );
      ((Element)v.get(103)).setAttribute("height","8" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(97)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 97   */
      v.add(doc.createElement("td"));
      ((Element)v.get(106)).setAttribute("width","100%" );
      ((Element)v.get(97)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(107)).setAttribute("width","8" );
      ((Element)v.get(107)).setAttribute("height","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:97   */

      /* Empieza nodo:108 / Elemento padre: 93   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(93)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","8" );
      ((Element)v.get(110)).setAttribute("height","8" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(108)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(112)).setAttribute("nombre","cbCodConfiguracion" );
      ((Element)v.get(112)).setAttribute("id","datosCampos" );
      ((Element)v.get(112)).setAttribute("size","1" );
      ((Element)v.get(112)).setAttribute("multiple","N" );
      ((Element)v.get(112)).setAttribute("req","S" );
      ((Element)v.get(112)).setAttribute("valorinicial","" );
      ((Element)v.get(112)).setAttribute("textoinicial","" );
      ((Element)v.get(112)).setAttribute("onchange","onchange_SelecCodigoConfiguracion();" );
      ((Element)v.get(112)).setAttribute("onshtab","focoBotonModificar();" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:114 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(108)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","8" );
      ((Element)v.get(115)).setAttribute("height","8" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).setAttribute("class","botonera" );
      ((Element)v.get(108)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(117)).setAttribute("nombre","btnCopiar" );
      ((Element)v.get(117)).setAttribute("ID","botonContenido" );
      ((Element)v.get(117)).setAttribute("tipo","html" );
      ((Element)v.get(117)).setAttribute("accion","copiar();" );
      ((Element)v.get(117)).setAttribute("estado","false" );
      ((Element)v.get(117)).setAttribute("cod","721" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 108   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).setAttribute("width","100%" );
      ((Element)v.get(108)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).setAttribute("width","8" );
      ((Element)v.get(119)).setAttribute("height","8" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:108   */

      /* Empieza nodo:120 / Elemento padre: 93   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(93)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).setAttribute("colspan","4" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","8" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:123 / Elemento padre: 90   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(90)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("table"));
      ((Element)v.get(125)).setAttribute("width","631" );
      ((Element)v.get(125)).setAttribute("border","0" );
      ((Element)v.get(125)).setAttribute("align","left" );
      ((Element)v.get(125)).setAttribute("cellspacing","0" );
      ((Element)v.get(125)).setAttribute("cellpadding","0" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","8" );
      ((Element)v.get(128)).setAttribute("height","8" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(130)).setAttribute("nombre","lblNivelRiesgo" );
      ((Element)v.get(130)).setAttribute("alto","13" );
      ((Element)v.get(130)).setAttribute("filas","1" );
      ((Element)v.get(130)).setAttribute("valor","" );
      ((Element)v.get(130)).setAttribute("id","datosTitle" );
      ((Element)v.get(130)).setAttribute("cod","928" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(132)).setAttribute("width","25" );
      ((Element)v.get(132)).setAttribute("height","8" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */

      /* Empieza nodo:133 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(134)).setAttribute("nombre","lblGrupoSolicitud" );
      ((Element)v.get(134)).setAttribute("alto","13" );
      ((Element)v.get(134)).setAttribute("filas","1" );
      ((Element)v.get(134)).setAttribute("valor","" );
      ((Element)v.get(134)).setAttribute("id","datosTitle" );
      ((Element)v.get(134)).setAttribute("cod","888" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 126   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).setAttribute("width","100%" );
      ((Element)v.get(126)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","8" );
      ((Element)v.get(136)).setAttribute("height","8" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:126   */

      /* Empieza nodo:137 / Elemento padre: 125   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(125)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("td"));
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).setAttribute("width","8" );
      ((Element)v.get(139)).setAttribute("height","8" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 137   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(137)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(141)).setAttribute("nombre","cbNivelRiesgo" );
      ((Element)v.get(141)).setAttribute("id","datosCampos" );
      ((Element)v.get(141)).setAttribute("size","5" );
      ((Element)v.get(141)).setAttribute("multiple","N" );
      ((Element)v.get(141)).setAttribute("req","S" );
      ((Element)v.get(141)).setAttribute("valorinicial","" );
      ((Element)v.get(141)).setAttribute("textoinicial","" );
      ((Element)v.get(141)).setAttribute("onchange","onchange_nivelRiesgo();" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:143 / Elemento padre: 137   */
      v.add(doc.createElement("td"));
      ((Element)v.get(137)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","25" );
      ((Element)v.get(144)).setAttribute("height","8" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 137   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(137)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(146)).setAttribute("nombre","cbGrupoSolicitud" );
      ((Element)v.get(146)).setAttribute("id","datosCampos" );
      ((Element)v.get(146)).setAttribute("size","5" );
      ((Element)v.get(146)).setAttribute("multiple","N" );
      ((Element)v.get(146)).setAttribute("req","S" );
      ((Element)v.get(146)).setAttribute("valorinicial","" );
      ((Element)v.get(146)).setAttribute("textoinicial","" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:148 / Elemento padre: 137   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).setAttribute("width","100%" );
      ((Element)v.get(137)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(149)).setAttribute("width","8" );
      ((Element)v.get(149)).setAttribute("height","8" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:137   */

      /* Empieza nodo:150 / Elemento padre: 125   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(125)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).setAttribute("colspan","4" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).setAttribute("width","8" );
      ((Element)v.get(152)).setAttribute("height","8" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:150   */
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:153 / Elemento padre: 90   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(90)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("table"));
      ((Element)v.get(155)).setAttribute("width","631" );
      ((Element)v.get(155)).setAttribute("border","0" );
      ((Element)v.get(155)).setAttribute("align","left" );
      ((Element)v.get(155)).setAttribute("cellspacing","0" );
      ((Element)v.get(155)).setAttribute("cellpadding","0" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(158)).setAttribute("width","8" );
      ((Element)v.get(158)).setAttribute("height","8" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(160)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(160)).setAttribute("alto","13" );
      ((Element)v.get(160)).setAttribute("filas","1" );
      ((Element)v.get(160)).setAttribute("valor","" );
      ((Element)v.get(160)).setAttribute("id","datosTitle" );
      ((Element)v.get(160)).setAttribute("cod","6" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(162)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).setAttribute("width","25" );
      ((Element)v.get(162)).setAttribute("height","8" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(164)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(164)).setAttribute("alto","13" );
      ((Element)v.get(164)).setAttribute("filas","1" );
      ((Element)v.get(164)).setAttribute("valor","" );
      ((Element)v.get(164)).setAttribute("id","datosTitle" );
      ((Element)v.get(164)).setAttribute("cod","7" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).setAttribute("width","100%" );
      ((Element)v.get(156)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).setAttribute("width","8" );
      ((Element)v.get(166)).setAttribute("height","8" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */
      /* Termina nodo:156   */

      /* Empieza nodo:167 / Elemento padre: 155   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(155)).appendChild((Element)v.get(167));

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
      ((Element)v.get(170)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(167)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(171)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(171)).setAttribute("id","datosCampos" );
      ((Element)v.get(171)).setAttribute("size","1" );
      ((Element)v.get(171)).setAttribute("multiple","N" );
      ((Element)v.get(171)).setAttribute("req","S" );
      ((Element)v.get(171)).setAttribute("valorinicial","" );
      ((Element)v.get(171)).setAttribute("textoinicial","" );
      ((Element)v.get(171)).setAttribute("onchange","onchange_marca();" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
   }

   private void getXML720(Document doc) {
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:173 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).setAttribute("width","25" );
      ((Element)v.get(174)).setAttribute("height","8" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(167)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(176)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(176)).setAttribute("id","datosCampos" );
      ((Element)v.get(176)).setAttribute("size","1" );
      ((Element)v.get(176)).setAttribute("multiple","N" );
      ((Element)v.get(176)).setAttribute("req","S" );
      ((Element)v.get(176)).setAttribute("valorinicial","" );
      ((Element)v.get(176)).setAttribute("textoinicial","" );
      ((Element)v.get(176)).setAttribute("onchange","onchange_canal();" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:178 / Elemento padre: 167   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).setAttribute("width","100%" );
      ((Element)v.get(167)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).setAttribute("width","8" );
      ((Element)v.get(179)).setAttribute("height","8" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */
      /* Termina nodo:167   */

      /* Empieza nodo:180 / Elemento padre: 155   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(155)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(181)).setAttribute("colspan","4" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(182)).setAttribute("src","b.gif" );
      ((Element)v.get(182)).setAttribute("width","8" );
      ((Element)v.get(182)).setAttribute("height","8" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */
      /* Termina nodo:180   */
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:183 / Elemento padre: 90   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(90)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("td"));
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("table"));
      ((Element)v.get(185)).setAttribute("width","631" );
      ((Element)v.get(185)).setAttribute("border","0" );
      ((Element)v.get(185)).setAttribute("align","left" );
      ((Element)v.get(185)).setAttribute("cellspacing","0" );
      ((Element)v.get(185)).setAttribute("cellpadding","0" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(185)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
      ((Element)v.get(188)).setAttribute("width","8" );
      ((Element)v.get(188)).setAttribute("height","8" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 186   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(190)).setAttribute("nombre","lblSubgerenciaVentas" );
      ((Element)v.get(190)).setAttribute("alto","13" );
      ((Element)v.get(190)).setAttribute("filas","1" );
      ((Element)v.get(190)).setAttribute("valor","" );
      ((Element)v.get(190)).setAttribute("id","datosTitle" );
      ((Element)v.get(190)).setAttribute("cod","124" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 186   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(192)).setAttribute("src","b.gif" );
      ((Element)v.get(192)).setAttribute("width","25" );
      ((Element)v.get(192)).setAttribute("height","8" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:193 / Elemento padre: 186   */
      v.add(doc.createElement("td"));
      ((Element)v.get(186)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(194)).setAttribute("nombre","lblRegión" );
      ((Element)v.get(194)).setAttribute("alto","13" );
      ((Element)v.get(194)).setAttribute("filas","1" );
      ((Element)v.get(194)).setAttribute("valor","" );
      ((Element)v.get(194)).setAttribute("id","datosTitle" );
      ((Element)v.get(194)).setAttribute("cod","109" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 186   */
      v.add(doc.createElement("td"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(195)).setAttribute("width","100%" );
      ((Element)v.get(186)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(196)).setAttribute("width","8" );
      ((Element)v.get(196)).setAttribute("height","8" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */
      /* Termina nodo:186   */

      /* Empieza nodo:197 / Elemento padre: 185   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(185)).appendChild((Element)v.get(197));

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
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(201)).setAttribute("nombre","cbSubgerenciaVentas" );
      ((Element)v.get(201)).setAttribute("id","datosCampos" );
      ((Element)v.get(201)).setAttribute("size","1" );
      ((Element)v.get(201)).setAttribute("multiple","N" );
      ((Element)v.get(201)).setAttribute("req","S" );
      ((Element)v.get(201)).setAttribute("valorinicial","" );
      ((Element)v.get(201)).setAttribute("textoinicial","" );
      ((Element)v.get(201)).setAttribute("onchange","onchange_subgerenciaVenta();" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:203 / Elemento padre: 197   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).setAttribute("width","25" );
      ((Element)v.get(204)).setAttribute("height","8" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:205 / Elemento padre: 197   */
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(197)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(206)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(206)).setAttribute("id","datosCampos" );
      ((Element)v.get(206)).setAttribute("size","1" );
      ((Element)v.get(206)).setAttribute("multiple","N" );
      ((Element)v.get(206)).setAttribute("req","N" );
      ((Element)v.get(206)).setAttribute("valorinicial","" );
      ((Element)v.get(206)).setAttribute("textoinicial","" );
      ((Element)v.get(206)).setAttribute("onchange","onchange_Region();" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:208 / Elemento padre: 197   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).setAttribute("width","100%" );
      ((Element)v.get(197)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","8" );
      ((Element)v.get(209)).setAttribute("height","8" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:197   */

      /* Empieza nodo:210 / Elemento padre: 185   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(185)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).setAttribute("colspan","4" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(212)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).setAttribute("width","8" );
      ((Element)v.get(212)).setAttribute("height","8" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:185   */
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:213 / Elemento padre: 90   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(90)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(213)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("table"));
      ((Element)v.get(215)).setAttribute("width","631" );
      ((Element)v.get(215)).setAttribute("border","0" );
      ((Element)v.get(215)).setAttribute("align","left" );
      ((Element)v.get(215)).setAttribute("cellspacing","0" );
      ((Element)v.get(215)).setAttribute("cellpadding","0" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(218)).setAttribute("src","b.gif" );
      ((Element)v.get(218)).setAttribute("width","8" );
      ((Element)v.get(218)).setAttribute("height","8" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:219 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(220)).setAttribute("nombre","lblZona" );
      ((Element)v.get(220)).setAttribute("alto","13" );
      ((Element)v.get(220)).setAttribute("filas","1" );
      ((Element)v.get(220)).setAttribute("valor","" );
      ((Element)v.get(220)).setAttribute("id","datosTitle" );
      ((Element)v.get(220)).setAttribute("cod","143" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:221 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(222)).setAttribute("width","25" );
      ((Element)v.get(222)).setAttribute("height","8" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:223 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(224)).setAttribute("nombre","lblLineaCreditoInicial" );
      ((Element)v.get(224)).setAttribute("alto","13" );
      ((Element)v.get(224)).setAttribute("filas","1" );
      ((Element)v.get(224)).setAttribute("valor","" );
      ((Element)v.get(224)).setAttribute("id","datosTitle" );
      ((Element)v.get(224)).setAttribute("cod","1475" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:225 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(226)).setAttribute("src","b.gif" );
      ((Element)v.get(226)).setAttribute("width","25" );
      ((Element)v.get(226)).setAttribute("height","8" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:227 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(228)).setAttribute("nombre","lblNivelRiesgoInicial" );
      ((Element)v.get(228)).setAttribute("alto","13" );
      ((Element)v.get(228)).setAttribute("filas","1" );
      ((Element)v.get(228)).setAttribute("valor","" );
      ((Element)v.get(228)).setAttribute("id","datosTitle" );
      ((Element)v.get(228)).setAttribute("cod","1476" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:229 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(229)).setAttribute("width","100%" );
      ((Element)v.get(216)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(230)).setAttribute("width","8" );
      ((Element)v.get(230)).setAttribute("height","8" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */
      /* Termina nodo:216   */

      /* Empieza nodo:231 / Elemento padre: 215   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(215)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(233)).setAttribute("src","b.gif" );
      ((Element)v.get(233)).setAttribute("width","8" );
      ((Element)v.get(233)).setAttribute("height","8" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:234 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(231)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(235)).setAttribute("nombre","cbZona" );
      ((Element)v.get(235)).setAttribute("id","datosCampos" );
      ((Element)v.get(235)).setAttribute("size","1" );
      ((Element)v.get(235)).setAttribute("multiple","N" );
      ((Element)v.get(235)).setAttribute("req","N" );
      ((Element)v.get(235)).setAttribute("valorinicial","" );
      ((Element)v.get(235)).setAttribute("textoinicial","" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:237 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(238)).setAttribute("src","b.gif" );
      ((Element)v.get(238)).setAttribute("width","25" );
      ((Element)v.get(238)).setAttribute("height","8" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(231)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(240)).setAttribute("nombre","txtLineaCreditoInicial" );
      ((Element)v.get(240)).setAttribute("id","datosCampos" );
      ((Element)v.get(240)).setAttribute("max","16" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(240)).setAttribute("tipo","" );
      ((Element)v.get(240)).setAttribute("onchange","" );
      ((Element)v.get(240)).setAttribute("req","S" );
      ((Element)v.get(240)).setAttribute("size","16" );
      ((Element)v.get(240)).setAttribute("valor","" );
      ((Element)v.get(240)).setAttribute("validacion","" );
      ((Element)v.get(240)).setAttribute("ontab","focoNivelRiesgo();" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:241 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(231)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(242)).setAttribute("src","b.gif" );
      ((Element)v.get(242)).setAttribute("width","25" );
      ((Element)v.get(242)).setAttribute("height","8" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:243 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(231)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(244)).setAttribute("nombre","cbNivelRiesgoInicial" );
      ((Element)v.get(244)).setAttribute("id","datosCampos" );
      ((Element)v.get(244)).setAttribute("size","1" );
      ((Element)v.get(244)).setAttribute("multiple","N" );
      ((Element)v.get(244)).setAttribute("req","S" );
      ((Element)v.get(244)).setAttribute("valorinicial","" );
      ((Element)v.get(244)).setAttribute("textoinicial","" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:246 / Elemento padre: 231   */
      v.add(doc.createElement("td"));
      ((Element)v.get(246)).setAttribute("width","100%" );
      ((Element)v.get(231)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(247)).setAttribute("src","b.gif" );
      ((Element)v.get(247)).setAttribute("width","8" );
      ((Element)v.get(247)).setAttribute("height","8" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */
      /* Termina nodo:231   */

      /* Empieza nodo:248 / Elemento padre: 215   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(215)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("td"));
      ((Element)v.get(249)).setAttribute("colspan","4" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(250)).setAttribute("src","b.gif" );
      ((Element)v.get(250)).setAttribute("width","8" );
      ((Element)v.get(250)).setAttribute("height","8" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */
      /* Termina nodo:248   */
      /* Termina nodo:215   */
      /* Termina nodo:214   */
      /* Termina nodo:213   */
      /* Termina nodo:90   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:251 / Elemento padre: 83   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(252)).setAttribute("src","b.gif" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */
      /* Termina nodo:83   */

      /* Empieza nodo:253 / Elemento padre: 75   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(75)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("td"));
      ((Element)v.get(253)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(255)).setAttribute("src","b.gif" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */

      /* Empieza nodo:256 / Elemento padre: 253   */
      v.add(doc.createElement("td"));
      ((Element)v.get(253)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("table"));
      ((Element)v.get(258)).setAttribute("width","100%" );
      ((Element)v.get(258)).setAttribute("border","0" );
      ((Element)v.get(258)).setAttribute("align","center" );
      ((Element)v.get(258)).setAttribute("cellspacing","0" );
      ((Element)v.get(258)).setAttribute("cellpadding","0" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(258)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("td"));
      ((Element)v.get(260)).setAttribute("height","5" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:261 / Elemento padre: 258   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(258)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("td"));
      ((Element)v.get(262)).setAttribute("class","botonera" );
      ((Element)v.get(262)).setAttribute("height","20" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(263)).setAttribute("nombre","btnAnadirCAPA" );
      ((Element)v.get(263)).setAttribute("visibilidad","visible" );
      ((Element)v.get(263)).setAttribute("colorf","" );
      ((Element)v.get(263)).setAttribute("ID","botonera" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(264)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(264)).setAttribute("ID","botonContenido" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(264)).setAttribute("tipo","html" );
      ((Element)v.get(264)).setAttribute("accion","aniadir();" );
      ((Element)v.get(264)).setAttribute("estado","false" );
      ((Element)v.get(264)).setAttribute("cod","404" );
      ((Element)v.get(264)).setAttribute("ontab","focoBotonModificar();" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */

      /* Empieza nodo:265 / Elemento padre: 262   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(265)).setAttribute("nombre","btnAplicarCambiosCAPA" );
      ((Element)v.get(265)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(265)).setAttribute("colorf","" );
      ((Element)v.get(265)).setAttribute("ID","botonera" );
      ((Element)v.get(262)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(266)).setAttribute("nombre","btnAplicarCambios" );
      ((Element)v.get(266)).setAttribute("ID","botonContenido" );
      ((Element)v.get(266)).setAttribute("tipo","html" );
      ((Element)v.get(266)).setAttribute("accion","aniadir();" );
      ((Element)v.get(266)).setAttribute("estado","false" );
      ((Element)v.get(266)).setAttribute("cod","CarParametros.update.label" );
      ((Element)v.get(266)).setAttribute("ontab","focoBotonModificar();" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */
      /* Termina nodo:262   */
      /* Termina nodo:261   */
      /* Termina nodo:258   */
      /* Termina nodo:257   */
      /* Termina nodo:256   */

      /* Empieza nodo:267 / Elemento padre: 253   */
      v.add(doc.createElement("td"));
      ((Element)v.get(253)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(268)).setAttribute("src","b.gif" );
      ((Element)v.get(268)).setAttribute("width","8" );
      ((Element)v.get(268)).setAttribute("height","12" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */
      /* Termina nodo:253   */

      /* Empieza nodo:269 / Elemento padre: 75   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(75)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(270)).setAttribute("width","12" );
      ((Element)v.get(270)).setAttribute("align","center" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(271)).setAttribute("width","12" );
      ((Element)v.get(271)).setAttribute("height","12" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */

      /* Empieza nodo:272 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(272)).setAttribute("width","756" );
      ((Element)v.get(269)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(273)).setAttribute("src","b.gif" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */
      /* Termina nodo:272   */

      /* Empieza nodo:274 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).setAttribute("width","12" );
      ((Element)v.get(269)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(275)).setAttribute("src","b.gif" );
      ((Element)v.get(275)).setAttribute("width","12" );
      ((Element)v.get(275)).setAttribute("height","1" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */
      /* Termina nodo:274   */
      /* Termina nodo:269   */
      /* Termina nodo:75   */
      /* Termina nodo:52   */

      /* Empieza nodo:276 / Elemento padre: 14   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(276)).setAttribute("nombre","listado1" );
      ((Element)v.get(276)).setAttribute("ancho","634" );
      ((Element)v.get(276)).setAttribute("alto","317" );
      ((Element)v.get(276)).setAttribute("x","12" );
      ((Element)v.get(276)).setAttribute("y","374" );
      ((Element)v.get(276)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(276)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(14)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(277)).setAttribute("precarga","S" );
      ((Element)v.get(277)).setAttribute("conROver","S" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(278)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(278)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(278)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(278)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */

      /* Empieza nodo:279 / Elemento padre: 277   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(279)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(279)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(279)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(279)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(277)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */

      /* Empieza nodo:280 / Elemento padre: 277   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(280)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(280)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(277)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:277   */

      /* Empieza nodo:281 / Elemento padre: 276   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(276)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(282)).setAttribute("borde","1" );
      ((Element)v.get(282)).setAttribute("horizDatos","1" );
      ((Element)v.get(282)).setAttribute("horizCabecera","1" );
      ((Element)v.get(282)).setAttribute("vertical","1" );
      ((Element)v.get(282)).setAttribute("horizTitulo","1" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(282)).setAttribute("horizBase","1" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */

      /* Empieza nodo:283 / Elemento padre: 281   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(283)).setAttribute("borde","#999999" );
      ((Element)v.get(283)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(283)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(283)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(283)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(283)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(283)).setAttribute("horizBase","#999999" );
      ((Element)v.get(281)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:281   */

      /* Empieza nodo:284 / Elemento padre: 276   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(284)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(284)).setAttribute("alto","22" );
      ((Element)v.get(284)).setAttribute("imgFondo","" );
      ((Element)v.get(284)).setAttribute("cod","00208" );
      ((Element)v.get(284)).setAttribute("ID","datosTitle" );
      ((Element)v.get(276)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */

      /* Empieza nodo:285 / Elemento padre: 276   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(285)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(285)).setAttribute("alto","22" );
      ((Element)v.get(285)).setAttribute("imgFondo","" );
      ((Element)v.get(276)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */

      /* Empieza nodo:286 / Elemento padre: 276   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(286)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(286)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(286)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(286)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(286)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(286)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(276)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(287)).setAttribute("ancho","30" );
      ((Element)v.get(287)).setAttribute("minimizable","S" );
      ((Element)v.get(287)).setAttribute("minimizada","N" );
      ((Element)v.get(287)).setAttribute("oculta","S" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */

      /* Empieza nodo:288 / Elemento padre: 286   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(288)).setAttribute("ancho","120" );
      ((Element)v.get(288)).setAttribute("minimizable","S" );
      ((Element)v.get(288)).setAttribute("minimizada","N" );
      ((Element)v.get(286)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */

      /* Empieza nodo:289 / Elemento padre: 286   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(289)).setAttribute("ancho","100" );
      ((Element)v.get(289)).setAttribute("minimizable","S" );
      ((Element)v.get(289)).setAttribute("minimizada","N" );
      ((Element)v.get(286)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */

      /* Empieza nodo:290 / Elemento padre: 286   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(290)).setAttribute("ancho","120" );
      ((Element)v.get(290)).setAttribute("minimizable","S" );
      ((Element)v.get(290)).setAttribute("minimizada","N" );
      ((Element)v.get(286)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */

      /* Empieza nodo:291 / Elemento padre: 286   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(291)).setAttribute("ancho","80" );
      ((Element)v.get(291)).setAttribute("minimizable","S" );
      ((Element)v.get(291)).setAttribute("minimizada","N" );
      ((Element)v.get(286)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */

      /* Empieza nodo:292 / Elemento padre: 286   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(292)).setAttribute("ancho","50" );
      ((Element)v.get(292)).setAttribute("minimizable","S" );
      ((Element)v.get(292)).setAttribute("minimizada","N" );
      ((Element)v.get(286)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */

      /* Empieza nodo:293 / Elemento padre: 286   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(293)).setAttribute("ancho","130" );
      ((Element)v.get(293)).setAttribute("minimizable","S" );
      ((Element)v.get(293)).setAttribute("minimizada","N" );
      ((Element)v.get(286)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */

      /* Empieza nodo:294 / Elemento padre: 286   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(294)).setAttribute("ancho","40" );
      ((Element)v.get(294)).setAttribute("minimizable","S" );
      ((Element)v.get(294)).setAttribute("minimizada","N" );
      ((Element)v.get(286)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */

      /* Empieza nodo:295 / Elemento padre: 286   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(295)).setAttribute("ancho","50" );
      ((Element)v.get(295)).setAttribute("minimizable","S" );
      ((Element)v.get(295)).setAttribute("minimizada","N" );
      ((Element)v.get(286)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */

      /* Empieza nodo:296 / Elemento padre: 286   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(296)).setAttribute("ancho","140" );
      ((Element)v.get(296)).setAttribute("minimizable","S" );
      ((Element)v.get(296)).setAttribute("minimizada","N" );
      ((Element)v.get(286)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */

      /* Empieza nodo:297 / Elemento padre: 286   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(297)).setAttribute("ancho","130" );
      ((Element)v.get(297)).setAttribute("minimizable","S" );
      ((Element)v.get(297)).setAttribute("minimizada","N" );
      ((Element)v.get(286)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */

      /* Empieza nodo:298 / Elemento padre: 286   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(298)).setAttribute("ancho","50" );
      ((Element)v.get(298)).setAttribute("minimizable","S" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(298)).setAttribute("minimizada","N" );
      ((Element)v.get(298)).setAttribute("oculta","S" );
      ((Element)v.get(286)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */

      /* Empieza nodo:299 / Elemento padre: 286   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(299)).setAttribute("ancho","50" );
      ((Element)v.get(299)).setAttribute("minimizable","S" );
      ((Element)v.get(299)).setAttribute("minimizada","N" );
      ((Element)v.get(299)).setAttribute("oculta","S" );
      ((Element)v.get(286)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */

      /* Empieza nodo:300 / Elemento padre: 286   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(300)).setAttribute("ancho","50" );
      ((Element)v.get(300)).setAttribute("minimizable","S" );
      ((Element)v.get(300)).setAttribute("minimizada","N" );
      ((Element)v.get(300)).setAttribute("oculta","S" );
      ((Element)v.get(286)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */

      /* Empieza nodo:301 / Elemento padre: 286   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(301)).setAttribute("ancho","30" );
      ((Element)v.get(301)).setAttribute("minimizable","S" );
      ((Element)v.get(301)).setAttribute("minimizada","N" );
      ((Element)v.get(301)).setAttribute("oculta","S" );
      ((Element)v.get(286)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */

      /* Empieza nodo:302 / Elemento padre: 286   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(302)).setAttribute("ancho","50" );
      ((Element)v.get(302)).setAttribute("minimizable","S" );
      ((Element)v.get(302)).setAttribute("minimizada","N" );
      ((Element)v.get(302)).setAttribute("oculta","S" );
      ((Element)v.get(286)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */

      /* Empieza nodo:303 / Elemento padre: 286   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(303)).setAttribute("ancho","30" );
      ((Element)v.get(303)).setAttribute("minimizable","S" );
      ((Element)v.get(303)).setAttribute("minimizada","N" );
      ((Element)v.get(303)).setAttribute("oculta","S" );
      ((Element)v.get(286)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */

      /* Empieza nodo:304 / Elemento padre: 286   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(304)).setAttribute("ancho","50" );
      ((Element)v.get(304)).setAttribute("minimizable","S" );
      ((Element)v.get(304)).setAttribute("minimizada","N" );
      ((Element)v.get(304)).setAttribute("oculta","S" );
      ((Element)v.get(286)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */

      /* Empieza nodo:305 / Elemento padre: 286   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(305)).setAttribute("ancho","30" );
      ((Element)v.get(305)).setAttribute("minimizable","S" );
      ((Element)v.get(305)).setAttribute("minimizada","N" );
      ((Element)v.get(305)).setAttribute("oculta","S" );
      ((Element)v.get(286)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */

      /* Empieza nodo:306 / Elemento padre: 286   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(306)).setAttribute("ancho","50" );
      ((Element)v.get(306)).setAttribute("minimizable","S" );
      ((Element)v.get(306)).setAttribute("minimizada","N" );
      ((Element)v.get(306)).setAttribute("oculta","S" );
      ((Element)v.get(286)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:286   */

      /* Empieza nodo:307 / Elemento padre: 276   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(307)).setAttribute("alto","20" );
      ((Element)v.get(307)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(307)).setAttribute("imgFondo","" );
      ((Element)v.get(307)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(276)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(308)).setAttribute("colFondo","" );
      ((Element)v.get(308)).setAttribute("ID","EstCab" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));

      /* Elemento padre:308 / Elemento actual: 309   */
      v.add(doc.createTextNode("oidAsignacion"));
      ((Element)v.get(308)).appendChild((Text)v.get(309));

      /* Termina nodo Texto:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:310 / Elemento padre: 307   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(310)).setAttribute("colFondo","" );
      ((Element)v.get(310)).setAttribute("ID","EstCab" );
      ((Element)v.get(310)).setAttribute("cod","1474" );
      ((Element)v.get(307)).appendChild((Element)v.get(310));

      /* Elemento padre:310 / Elemento actual: 311   */
      v.add(doc.createTextNode("Cód. configuración"));
      ((Element)v.get(310)).appendChild((Text)v.get(311));

      /* Termina nodo Texto:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:312 / Elemento padre: 307   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(312)).setAttribute("colFondo","" );
      ((Element)v.get(312)).setAttribute("ID","EstCab" );
      ((Element)v.get(312)).setAttribute("cod","928" );
      ((Element)v.get(307)).appendChild((Element)v.get(312));

      /* Elemento padre:312 / Elemento actual: 313   */
      v.add(doc.createTextNode("Nivel riesgo"));
      ((Element)v.get(312)).appendChild((Text)v.get(313));

      /* Termina nodo Texto:313   */
      /* Termina nodo:312   */

      /* Empieza nodo:314 / Elemento padre: 307   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(314)).setAttribute("colFondo","" );
      ((Element)v.get(314)).setAttribute("ID","EstCab" );
      ((Element)v.get(314)).setAttribute("cod","888" );
      ((Element)v.get(307)).appendChild((Element)v.get(314));

      /* Elemento padre:314 / Elemento actual: 315   */
      v.add(doc.createTextNode("Grupo solicitud"));
      ((Element)v.get(314)).appendChild((Text)v.get(315));

      /* Termina nodo Texto:315   */
      /* Termina nodo:314   */

      /* Empieza nodo:316 / Elemento padre: 307   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(316)).setAttribute("colFondo","" );
      ((Element)v.get(316)).setAttribute("ID","EstCab" );
      ((Element)v.get(316)).setAttribute("cod","6" );
      ((Element)v.get(307)).appendChild((Element)v.get(316));

      /* Elemento padre:316 / Elemento actual: 317   */
      v.add(doc.createTextNode("Marca"));
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(316)).appendChild((Text)v.get(317));

      /* Termina nodo Texto:317   */
      /* Termina nodo:316   */

      /* Empieza nodo:318 / Elemento padre: 307   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(318)).setAttribute("colFondo","" );
      ((Element)v.get(318)).setAttribute("ID","EstCab" );
      ((Element)v.get(318)).setAttribute("cod","7" );
      ((Element)v.get(307)).appendChild((Element)v.get(318));

      /* Elemento padre:318 / Elemento actual: 319   */
      v.add(doc.createTextNode("Canal"));
      ((Element)v.get(318)).appendChild((Text)v.get(319));

      /* Termina nodo Texto:319   */
      /* Termina nodo:318   */

      /* Empieza nodo:320 / Elemento padre: 307   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(320)).setAttribute("colFondo","" );
      ((Element)v.get(320)).setAttribute("ID","EstCab" );
      ((Element)v.get(320)).setAttribute("cod","124" );
      ((Element)v.get(307)).appendChild((Element)v.get(320));

      /* Elemento padre:320 / Elemento actual: 321   */
      v.add(doc.createTextNode("Subgerencia ventas"));
      ((Element)v.get(320)).appendChild((Text)v.get(321));

      /* Termina nodo Texto:321   */
      /* Termina nodo:320   */

      /* Empieza nodo:322 / Elemento padre: 307   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(322)).setAttribute("colFondo","" );
      ((Element)v.get(322)).setAttribute("ID","EstCab" );
      ((Element)v.get(322)).setAttribute("cod","109" );
      ((Element)v.get(307)).appendChild((Element)v.get(322));

      /* Elemento padre:322 / Elemento actual: 323   */
      v.add(doc.createTextNode("Región"));
      ((Element)v.get(322)).appendChild((Text)v.get(323));

      /* Termina nodo Texto:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:324 / Elemento padre: 307   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(324)).setAttribute("colFondo","" );
      ((Element)v.get(324)).setAttribute("ID","EstCab" );
      ((Element)v.get(324)).setAttribute("cod","143" );
      ((Element)v.get(307)).appendChild((Element)v.get(324));

      /* Elemento padre:324 / Elemento actual: 325   */
      v.add(doc.createTextNode("Zona"));
      ((Element)v.get(324)).appendChild((Text)v.get(325));

      /* Termina nodo Texto:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:326 / Elemento padre: 307   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(326)).setAttribute("colFondo","" );
      ((Element)v.get(326)).setAttribute("ID","EstCab" );
      ((Element)v.get(326)).setAttribute("cod","1475" );
      ((Element)v.get(307)).appendChild((Element)v.get(326));

      /* Elemento padre:326 / Elemento actual: 327   */
      v.add(doc.createTextNode("Línea crédito inicial"));
      ((Element)v.get(326)).appendChild((Text)v.get(327));

      /* Termina nodo Texto:327   */
      /* Termina nodo:326   */

      /* Empieza nodo:328 / Elemento padre: 307   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(328)).setAttribute("colFondo","" );
      ((Element)v.get(328)).setAttribute("ID","EstCab" );
      ((Element)v.get(328)).setAttribute("cod","1476" );
      ((Element)v.get(307)).appendChild((Element)v.get(328));

      /* Elemento padre:328 / Elemento actual: 329   */
      v.add(doc.createTextNode("Nivel riesgo inicial"));
      ((Element)v.get(328)).appendChild((Text)v.get(329));

      /* Termina nodo Texto:329   */
      /* Termina nodo:328   */

      /* Empieza nodo:330 / Elemento padre: 307   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(330)).setAttribute("colFondo","" );
      ((Element)v.get(330)).setAttribute("ID","EstCab" );
      ((Element)v.get(307)).appendChild((Element)v.get(330));

      /* Elemento padre:330 / Elemento actual: 331   */
      v.add(doc.createTextNode("oidCodConf"));
      ((Element)v.get(330)).appendChild((Text)v.get(331));

      /* Termina nodo Texto:331   */
      /* Termina nodo:330   */

      /* Empieza nodo:332 / Elemento padre: 307   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(332)).setAttribute("colFondo","" );
      ((Element)v.get(332)).setAttribute("ID","EstCab" );
      ((Element)v.get(307)).appendChild((Element)v.get(332));

      /* Elemento padre:332 / Elemento actual: 333   */
      v.add(doc.createTextNode("oidNivelRiesgo"));
      ((Element)v.get(332)).appendChild((Text)v.get(333));

      /* Termina nodo Texto:333   */
      /* Termina nodo:332   */

      /* Empieza nodo:334 / Elemento padre: 307   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(334)).setAttribute("colFondo","" );
      ((Element)v.get(334)).setAttribute("ID","EstCab" );
      ((Element)v.get(307)).appendChild((Element)v.get(334));

      /* Elemento padre:334 / Elemento actual: 335   */
      v.add(doc.createTextNode("oidGrupoSolicitud"));
      ((Element)v.get(334)).appendChild((Text)v.get(335));

      /* Termina nodo Texto:335   */
      /* Termina nodo:334   */

      /* Empieza nodo:336 / Elemento padre: 307   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(336)).setAttribute("colFondo","" );
      ((Element)v.get(336)).setAttribute("ID","EstCab" );
      ((Element)v.get(307)).appendChild((Element)v.get(336));

      /* Elemento padre:336 / Elemento actual: 337   */
      v.add(doc.createTextNode("oidMarca"));
      ((Element)v.get(336)).appendChild((Text)v.get(337));

      /* Termina nodo Texto:337   */
      /* Termina nodo:336   */

      /* Empieza nodo:338 / Elemento padre: 307   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(338)).setAttribute("colFondo","" );
      ((Element)v.get(338)).setAttribute("ID","EstCab" );
      ((Element)v.get(307)).appendChild((Element)v.get(338));

      /* Elemento padre:338 / Elemento actual: 339   */
      v.add(doc.createTextNode("oidCanal"));
      ((Element)v.get(338)).appendChild((Text)v.get(339));

      /* Termina nodo Texto:339   */
      /* Termina nodo:338   */

      /* Empieza nodo:340 / Elemento padre: 307   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(340)).setAttribute("colFondo","" );
      ((Element)v.get(340)).setAttribute("ID","EstCab" );
      ((Element)v.get(307)).appendChild((Element)v.get(340));

      /* Elemento padre:340 / Elemento actual: 341   */
      v.add(doc.createTextNode("oidSubgerenciaVenta"));
      ((Element)v.get(340)).appendChild((Text)v.get(341));

      /* Termina nodo Texto:341   */
      /* Termina nodo:340   */

      /* Empieza nodo:342 / Elemento padre: 307   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(342)).setAttribute("colFondo","" );
      ((Element)v.get(342)).setAttribute("ID","EstCab" );
      ((Element)v.get(307)).appendChild((Element)v.get(342));

      /* Elemento padre:342 / Elemento actual: 343   */
      v.add(doc.createTextNode("oidRegion"));
      ((Element)v.get(342)).appendChild((Text)v.get(343));

      /* Termina nodo Texto:343   */
      /* Termina nodo:342   */

      /* Empieza nodo:344 / Elemento padre: 307   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(344)).setAttribute("colFondo","" );
      ((Element)v.get(344)).setAttribute("ID","EstCab" );
      ((Element)v.get(307)).appendChild((Element)v.get(344));

      /* Elemento padre:344 / Elemento actual: 345   */
      v.add(doc.createTextNode("oidZona"));
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(344)).appendChild((Text)v.get(345));

      /* Termina nodo Texto:345   */
      /* Termina nodo:344   */

      /* Empieza nodo:346 / Elemento padre: 307   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(346)).setAttribute("colFondo","" );
      ((Element)v.get(346)).setAttribute("ID","EstCab" );
      ((Element)v.get(307)).appendChild((Element)v.get(346));

      /* Elemento padre:346 / Elemento actual: 347   */
      v.add(doc.createTextNode("oidNivelRiesgoInicial"));
      ((Element)v.get(346)).appendChild((Text)v.get(347));

      /* Termina nodo Texto:347   */
      /* Termina nodo:346   */
      /* Termina nodo:307   */

      /* Empieza nodo:348 / Elemento padre: 276   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(348)).setAttribute("alto","22" );
      ((Element)v.get(348)).setAttribute("accion","" );
      ((Element)v.get(348)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(348)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(348)).setAttribute("maxSel","-1" );
      ((Element)v.get(348)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(348)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(348)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(348)).setAttribute("onLoad","" );
      ((Element)v.get(348)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(276)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(349)).setAttribute("tipo","texto" );
      ((Element)v.get(349)).setAttribute("ID","EstDat" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */

      /* Empieza nodo:350 / Elemento padre: 348   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(350)).setAttribute("tipo","texto" );
      ((Element)v.get(350)).setAttribute("ID","EstDat2" );
      ((Element)v.get(348)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */

      /* Empieza nodo:351 / Elemento padre: 348   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(351)).setAttribute("tipo","texto" );
      ((Element)v.get(351)).setAttribute("ID","EstDat" );
      ((Element)v.get(348)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */

      /* Empieza nodo:352 / Elemento padre: 348   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(352)).setAttribute("tipo","texto" );
      ((Element)v.get(352)).setAttribute("ID","EstDat2" );
      ((Element)v.get(348)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */

      /* Empieza nodo:353 / Elemento padre: 348   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(353)).setAttribute("tipo","texto" );
      ((Element)v.get(353)).setAttribute("ID","EstDat" );
      ((Element)v.get(348)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */

      /* Empieza nodo:354 / Elemento padre: 348   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(354)).setAttribute("tipo","texto" );
      ((Element)v.get(354)).setAttribute("ID","EstDat2" );
      ((Element)v.get(348)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */

      /* Empieza nodo:355 / Elemento padre: 348   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(355)).setAttribute("tipo","texto" );
      ((Element)v.get(355)).setAttribute("ID","EstDat" );
      ((Element)v.get(348)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */

      /* Empieza nodo:356 / Elemento padre: 348   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(356)).setAttribute("tipo","texto" );
      ((Element)v.get(356)).setAttribute("ID","EstDat2" );
      ((Element)v.get(348)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */

      /* Empieza nodo:357 / Elemento padre: 348   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(357)).setAttribute("tipo","texto" );
      ((Element)v.get(357)).setAttribute("ID","EstDat" );
      ((Element)v.get(348)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */

      /* Empieza nodo:358 / Elemento padre: 348   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(358)).setAttribute("tipo","texto" );
      ((Element)v.get(358)).setAttribute("ID","EstDat2" );
      ((Element)v.get(348)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */

      /* Empieza nodo:359 / Elemento padre: 348   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(359)).setAttribute("tipo","texto" );
      ((Element)v.get(359)).setAttribute("ID","EstDat" );
      ((Element)v.get(348)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */

      /* Empieza nodo:360 / Elemento padre: 348   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(360)).setAttribute("tipo","texto" );
      ((Element)v.get(360)).setAttribute("ID","EstDat2" );
      ((Element)v.get(348)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */

      /* Empieza nodo:361 / Elemento padre: 348   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(361)).setAttribute("tipo","texto" );
      ((Element)v.get(361)).setAttribute("ID","EstDat" );
      ((Element)v.get(348)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */

      /* Empieza nodo:362 / Elemento padre: 348   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(362)).setAttribute("tipo","texto" );
      ((Element)v.get(362)).setAttribute("ID","EstDat2" );
      ((Element)v.get(348)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */

      /* Empieza nodo:363 / Elemento padre: 348   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(363)).setAttribute("tipo","texto" );
      ((Element)v.get(363)).setAttribute("ID","EstDat" );
      ((Element)v.get(348)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */

      /* Empieza nodo:364 / Elemento padre: 348   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(364)).setAttribute("tipo","texto" );
      ((Element)v.get(364)).setAttribute("ID","EstDat2" );
      ((Element)v.get(348)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */

      /* Empieza nodo:365 / Elemento padre: 348   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(365)).setAttribute("tipo","texto" );
      ((Element)v.get(365)).setAttribute("ID","EstDat" );
      ((Element)v.get(348)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */

      /* Empieza nodo:366 / Elemento padre: 348   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(366)).setAttribute("tipo","texto" );
      ((Element)v.get(366)).setAttribute("ID","EstDat2" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(348)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */

      /* Empieza nodo:367 / Elemento padre: 348   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(367)).setAttribute("tipo","texto" );
      ((Element)v.get(367)).setAttribute("ID","EstDat" );
      ((Element)v.get(348)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */

      /* Empieza nodo:368 / Elemento padre: 348   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(368)).setAttribute("tipo","texto" );
      ((Element)v.get(368)).setAttribute("ID","EstDat2" );
      ((Element)v.get(348)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */
      /* Termina nodo:348   */

      /* Empieza nodo:369 / Elemento padre: 276   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(276)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */

      /* Empieza nodo:370 / Elemento padre: 276   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(370)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(370)).setAttribute("ancho","634" );
      ((Element)v.get(370)).setAttribute("sep","$" );
      ((Element)v.get(370)).setAttribute("x","12" );
      ((Element)v.get(370)).setAttribute("class","botonera" );
      ((Element)v.get(370)).setAttribute("y","667" );
      ((Element)v.get(370)).setAttribute("control","|" );
      ((Element)v.get(370)).setAttribute("conector","" );
      ((Element)v.get(370)).setAttribute("rowset","" );
      ((Element)v.get(370)).setAttribute("cargainicial","N" );
      ((Element)v.get(370)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)');" );
      ((Element)v.get(276)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(371)).setAttribute("nombre","ret1" );
      ((Element)v.get(371)).setAttribute("x","37" );
      ((Element)v.get(371)).setAttribute("y","671" );
      ((Element)v.get(371)).setAttribute("ID","botonContenido" );
      ((Element)v.get(371)).setAttribute("img","retroceder_on" );
      ((Element)v.get(371)).setAttribute("tipo","0" );
      ((Element)v.get(371)).setAttribute("estado","false" );
      ((Element)v.get(371)).setAttribute("alt","" );
      ((Element)v.get(371)).setAttribute("codigo","" );
      ((Element)v.get(371)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */

      /* Empieza nodo:372 / Elemento padre: 370   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(372)).setAttribute("nombre","ava1" );
      ((Element)v.get(372)).setAttribute("x","52" );
      ((Element)v.get(372)).setAttribute("y","671" );
      ((Element)v.get(372)).setAttribute("ID","botonContenido" );
      ((Element)v.get(372)).setAttribute("img","avanzar_on" );
      ((Element)v.get(372)).setAttribute("tipo","0" );
      ((Element)v.get(372)).setAttribute("estado","false" );
      ((Element)v.get(372)).setAttribute("alt","" );
      ((Element)v.get(372)).setAttribute("codigo","" );
      ((Element)v.get(372)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(370)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */
      /* Termina nodo:370   */
      /* Termina nodo:276   */

      /* Empieza nodo:373 / Elemento padre: 14   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(373)).setAttribute("nombre","primera1" );
      ((Element)v.get(373)).setAttribute("x","20" );
      ((Element)v.get(373)).setAttribute("y","671" );
      ((Element)v.get(373)).setAttribute("ID","botonContenido" );
      ((Element)v.get(373)).setAttribute("img","primera_on" );
      ((Element)v.get(373)).setAttribute("tipo","-2" );
      ((Element)v.get(373)).setAttribute("estado","false" );
      ((Element)v.get(373)).setAttribute("alt","" );
      ((Element)v.get(373)).setAttribute("codigo","" );
      ((Element)v.get(373)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(14)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */

      /* Empieza nodo:374 / Elemento padre: 14   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(374)).setAttribute("nombre","separa" );
      ((Element)v.get(374)).setAttribute("x","59" );
      ((Element)v.get(374)).setAttribute("y","667" );
      ((Element)v.get(374)).setAttribute("ID","botonContenido" );
      ((Element)v.get(374)).setAttribute("img","separa_base" );
      ((Element)v.get(374)).setAttribute("tipo","0" );
      ((Element)v.get(374)).setAttribute("estado","false" );
      ((Element)v.get(374)).setAttribute("alt","" );
      ((Element)v.get(374)).setAttribute("codigo","" );
      ((Element)v.get(374)).setAttribute("accion","" );
      ((Element)v.get(14)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */

      /* Empieza nodo:375 / Elemento padre: 14   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(375)).setAttribute("nombre","btnModificar" );
      ((Element)v.get(375)).setAttribute("x","80" );
      ((Element)v.get(375)).setAttribute("y","668" );
      ((Element)v.get(375)).setAttribute("ID","botonContenido" );
      ((Element)v.get(375)).setAttribute("img","" );
      ((Element)v.get(375)).setAttribute("tipo","html" );
      ((Element)v.get(375)).setAttribute("estado","false" );
      ((Element)v.get(375)).setAttribute("cod","2" );
      ((Element)v.get(375)).setAttribute("accion","modificar();" );
      ((Element)v.get(375)).setAttribute("ontab","focoSolapa();" );
      ((Element)v.get(375)).setAttribute("onshtab","focoBotonAniadir();" );
      ((Element)v.get(14)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */

      /* Empieza nodo:376 / Elemento padre: 14   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(376)).setAttribute("nombre","capaEspacio" );
      ((Element)v.get(376)).setAttribute("alto","12" );
      ((Element)v.get(376)).setAttribute("ancho","50" );
      ((Element)v.get(376)).setAttribute("colorf","" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(376)).setAttribute("x","0" );
      ((Element)v.get(376)).setAttribute("y","692" );
      ((Element)v.get(14)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */
      /* Termina nodo:14   */


   }

}

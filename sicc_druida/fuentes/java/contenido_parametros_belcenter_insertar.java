
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_parametros_belcenter_insertar  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_parametros_belcenter_insertar" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("cod","" );
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
      ((Element)v.get(4)).setAttribute("src","contenido_parametros_belcenter_insertar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(6)).setAttribute("name","cbCanal" );
      ((Element)v.get(6)).setAttribute("required","true" );
      ((Element)v.get(6)).setAttribute("cod","7" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbAcceso" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","00468" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbSubAcceso" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","BelParamBelce.sbacOidSbac.label" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","txtDireccion" );
      ((Element)v.get(9)).setAttribute("format","t" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","BelParamBelce.valDire.label" );
      ((Element)v.get(5)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","txtNombreLocal" );
      ((Element)v.get(10)).setAttribute("format","t" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","BelParamBelce.valNombLoca.label" );
      ((Element)v.get(5)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","txtCodCliente" );
      ((Element)v.get(11)).setAttribute("format","e" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","BelParamBelce.clieOidClie.label" );
      ((Element)v.get(11)).setAttribute("min","0" );
      ((Element)v.get(11)).setAttribute("max","999999999" );
      ((Element)v.get(5)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","txtMontoMaxDife" );
      ((Element)v.get(12)).setAttribute("format","m" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","BelParamBelce.valMontMaxiDife.label" );
      ((Element)v.get(12)).setAttribute("min","0" );
      ((Element)v.get(12)).setAttribute("max","999999999999.99" );
      ((Element)v.get(5)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","txtLimiteCaja" );
      ((Element)v.get(13)).setAttribute("format","m" );
      ((Element)v.get(13)).setAttribute("required","true" );
      ((Element)v.get(13)).setAttribute("cod","BelParamBelce.valLimiEfecCaja.label" );
      ((Element)v.get(13)).setAttribute("min","0" );
      ((Element)v.get(13)).setAttribute("max","999999999999.99" );
      ((Element)v.get(5)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","txtNumeroCajas" );
      ((Element)v.get(14)).setAttribute("format","e" );
      ((Element)v.get(14)).setAttribute("required","true" );
      ((Element)v.get(14)).setAttribute("cod","BelParamBelce.numCaja.label" );
      ((Element)v.get(14)).setAttribute("min","0" );
      ((Element)v.get(14)).setAttribute("max","999" );
      ((Element)v.get(5)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(15)).setAttribute("name","txtTiempoReposicion" );
      ((Element)v.get(15)).setAttribute("format","e" );
      ((Element)v.get(15)).setAttribute("required","true" );
      ((Element)v.get(15)).setAttribute("cod","BelParamBelce.valTiempRepo.label" );
      ((Element)v.get(15)).setAttribute("min","0" );
      ((Element)v.get(15)).setAttribute("max","99" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(5)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(16)).setAttribute("name","cbAdministradorBel" );
      ((Element)v.get(16)).setAttribute("required","true" );
      ((Element)v.get(16)).setAttribute("cod","BelParamBelce.valUsua.label" );
      ((Element)v.get(5)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(17)).setAttribute("name","txtFactorLocal" );
      ((Element)v.get(17)).setAttribute("format","n" );
      ((Element)v.get(17)).setAttribute("required","true" );
      ((Element)v.get(17)).setAttribute("cod","BelParamBelce.valFactLoca.label" );
      ((Element)v.get(17)).setAttribute("min","0" );
      ((Element)v.get(17)).setAttribute("max","99999.99" );
      ((Element)v.get(5)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(18)).setAttribute("name","txtNumMaxProductos" );
      ((Element)v.get(18)).setAttribute("format","e" );
      ((Element)v.get(18)).setAttribute("required","true" );
      ((Element)v.get(18)).setAttribute("cod","BelParamBelce.numMaxiProd.label" );
      ((Element)v.get(18)).setAttribute("min","0" );
      ((Element)v.get(18)).setAttribute("max","999" );
      ((Element)v.get(5)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(19)).setAttribute("name","txtAlertaStock" );
      ((Element)v.get(19)).setAttribute("format","e" );
      ((Element)v.get(19)).setAttribute("required","true" );
      ((Element)v.get(19)).setAttribute("cod","BelParamBelce.valAlerStoc.label" );
      ((Element)v.get(19)).setAttribute("min","0" );
      ((Element)v.get(19)).setAttribute("max","9999999999" );
      ((Element)v.get(5)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(20)).setAttribute("name","cbMovStockTransito" );
      ((Element)v.get(20)).setAttribute("required","true" );
      ((Element)v.get(20)).setAttribute("cod","BelParamBelce.tmalOidStocTran.label" );
      ((Element)v.get(5)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(21)).setAttribute("name","cbMovReg" );
      ((Element)v.get(21)).setAttribute("required","true" );
      ((Element)v.get(21)).setAttribute("cod","BelParamBelce.tmalOidRegu.label" );
      ((Element)v.get(5)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(22)).setAttribute("name","cbMovRegSap" );
      ((Element)v.get(22)).setAttribute("required","true" );
      ((Element)v.get(22)).setAttribute("cod","BelParamBelce.tmalOidReguSap.label" );
      ((Element)v.get(5)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(23)).setAttribute("name","cbDevolverStockExist" );
      ((Element)v.get(23)).setAttribute("required","true" );
      ((Element)v.get(23)).setAttribute("cod","BelParamBelce.tmalOidDevoStoc.label" );
      ((Element)v.get(5)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(24)).setAttribute("name","cbMovStockDev" );
      ((Element)v.get(24)).setAttribute("required","true" );
      ((Element)v.get(24)).setAttribute("cod","BelParamBelce.tmalOidStocDevo.label" );
      ((Element)v.get(5)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(25)).setAttribute("name","cbTipoMovCob" );
      ((Element)v.get(25)).setAttribute("required","true" );
      ((Element)v.get(25)).setAttribute("cod","BelParamBelce.tmvcOidCobr.label" );
      ((Element)v.get(5)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(26)).setAttribute("name","cbSociedad" );
      ((Element)v.get(26)).setAttribute("required","true" );
      ((Element)v.get(26)).setAttribute("cod","BelParamBelce.sociOidSoci.label" );
      ((Element)v.get(5)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(27)).setAttribute("name","cbCuentaCCC" );
      ((Element)v.get(27)).setAttribute("required","true" );
      ((Element)v.get(27)).setAttribute("cod","BelParamBelce.ccbaOidCuenCorrBanc.label" );
      ((Element)v.get(5)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(28)).setAttribute("name","cbTipoMovCierre" );
      ((Element)v.get(28)).setAttribute("required","true" );
      ((Element)v.get(28)).setAttribute("cod","BelParamBelce.tmvcOidCier.label" );
      ((Element)v.get(5)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(29)).setAttribute("name","cbTipoTransaccion" );
      ((Element)v.get(29)).setAttribute("required","true" );
      ((Element)v.get(29)).setAttribute("cod","702" );
      ((Element)v.get(5)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */
      /* Termina nodo:5   */

      /* Empieza nodo:30 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(30)).setAttribute("nombre","frmParametrosBelcenter" );
      ((Element)v.get(0)).appendChild((Element)v.get(30));

      /* Empieza nodo:31 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","idioma" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","pais" );
      ((Element)v.get(32)).setAttribute("valor","" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(30)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","accion" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","casoUso" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","codigoCliente" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","oidCliente" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","hOidParametroBel" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","hCbCanal" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hCbAcceso" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hCbSubAcceso" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","hCbMovStockDev" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","hCbTipoMovCob" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","hCbMovConfirmarStock" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","hCbMovStockTransito" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","hCbMovConfirmarStockTransito" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","hCbMovReg" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","hCbMovRegSap" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","hCbDevolverStockExist" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","hCbTipoMovCierre" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","hCbCuentaCCC" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","hCbSociedad" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(55)).setAttribute("nombre","hCbTipoTransaccion" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","hCbAdministradorBel" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","hCbMovPetExist" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 30   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","hNombreAdministrador" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(30)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 30   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(59)).setAttribute("nombre","capa2" );
      ((Element)v.get(59)).setAttribute("x","0" );
      ((Element)v.get(59)).setAttribute("y","390" );
      ((Element)v.get(30)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("table"));
      ((Element)v.get(60)).setAttribute("width","100%" );
      ((Element)v.get(60)).setAttribute("border","0" );
      ((Element)v.get(60)).setAttribute("cellspacing","0" );
      ((Element)v.get(60)).setAttribute("cellpadding","0" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(62)).setAttribute("width","12" );
      ((Element)v.get(62)).setAttribute("align","center" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(63)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).setAttribute("width","12" );
      ((Element)v.get(63)).setAttribute("height","12" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:64 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(64)).setAttribute("width","756" );
      ((Element)v.get(61)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(65)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:66 / Elemento padre: 61   */
      v.add(doc.createElement("td"));
      ((Element)v.get(66)).setAttribute("width","12" );
      ((Element)v.get(61)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","12" );
      ((Element)v.get(67)).setAttribute("height","12" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:61   */

      /* Empieza nodo:68 / Elemento padre: 60   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(60)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(70)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */

      /* Empieza nodo:71 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(71)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(73)).setAttribute("class","legend" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(74)).setAttribute("nombre","lblDatosCabecera2" );
      ((Element)v.get(74)).setAttribute("alto","13" );
      ((Element)v.get(74)).setAttribute("filas","1" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(74)).setAttribute("cod","BelParamBelce.lov.label" );
      ((Element)v.get(74)).setAttribute("id","legend" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 72   */
      v.add(doc.createElement("table"));
      ((Element)v.get(75)).setAttribute("width","100%" );
      ((Element)v.get(75)).setAttribute("border","0" );
      ((Element)v.get(75)).setAttribute("align","center" );
      ((Element)v.get(75)).setAttribute("cellspacing","0" );
      ((Element)v.get(75)).setAttribute("cellpadding","0" );
      ((Element)v.get(72)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("td"));
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("table"));
      ((Element)v.get(78)).setAttribute("width","654" );
      ((Element)v.get(78)).setAttribute("border","0" );
      ((Element)v.get(78)).setAttribute("align","left" );
      ((Element)v.get(78)).setAttribute("cellspacing","0" );
      ((Element)v.get(78)).setAttribute("cellpadding","0" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("colspan","4" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).setAttribute("width","8" );
      ((Element)v.get(81)).setAttribute("height","8" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:79   */

      /* Empieza nodo:82 / Elemento padre: 78   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(78)).appendChild((Element)v.get(82));

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
      ((Element)v.get(82)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(86)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(86)).setAttribute("alto","13" );
      ((Element)v.get(86)).setAttribute("filas","1" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(86)).setAttribute("id","datosTitle" );
      ((Element)v.get(86)).setAttribute("cod","7" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","8" );
      ((Element)v.get(88)).setAttribute("height","8" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(90)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(90)).setAttribute("alto","13" );
      ((Element)v.get(90)).setAttribute("filas","1" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(90)).setAttribute("id","datosTitle" );
      ((Element)v.get(90)).setAttribute("cod","00468" );
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
      ((Element)v.get(94)).setAttribute("nombre","lblSubAcceso" );
      ((Element)v.get(94)).setAttribute("alto","13" );
      ((Element)v.get(94)).setAttribute("filas","1" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(94)).setAttribute("id","datosTitle" );
      ((Element)v.get(94)).setAttribute("cod","BelParamBelce.sbacOidSbac.label" );
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
      ((Element)v.get(97)).setAttribute("width","100%" );
      ((Element)v.get(82)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).setAttribute("width","8" );
      ((Element)v.get(98)).setAttribute("height","8" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:82   */

      /* Empieza nodo:99 / Elemento padre: 78   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(78)).appendChild((Element)v.get(99));

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
   }

   private void getXML450(Document doc) {
      ((Element)v.get(99)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(103)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(103)).setAttribute("id","datosCampos" );
      ((Element)v.get(103)).setAttribute("size","1" );
      ((Element)v.get(103)).setAttribute("multiple","N" );
      ((Element)v.get(103)).setAttribute("req","S" );
      ((Element)v.get(103)).setAttribute("valorinicial","" );
      ((Element)v.get(103)).setAttribute("textoinicial","" );
      ((Element)v.get(103)).setAttribute("ontab","setTabCampos('cbCanal');" );
      ((Element)v.get(103)).setAttribute("onshtab","setShTabCampos('cbCanal');" );
      ((Element)v.get(103)).setAttribute("onchange","cbCanalOnChange()" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:105 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","8" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(99)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(108)).setAttribute("nombre","cbAcceso" );
      ((Element)v.get(108)).setAttribute("id","datosCampos" );
      ((Element)v.get(108)).setAttribute("size","1" );
      ((Element)v.get(108)).setAttribute("multiple","N" );
      ((Element)v.get(108)).setAttribute("req","S" );
      ((Element)v.get(108)).setAttribute("valorinicial","" );
      ((Element)v.get(108)).setAttribute("textoinicial","" );
      ((Element)v.get(108)).setAttribute("ontab","focaliza('frmParametrosBelcenter.cbSubAcceso');" );
      ((Element)v.get(108)).setAttribute("onchange","cbAccesoOnChange();" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:110 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(111)).setAttribute("src","b.gif" );
      ((Element)v.get(111)).setAttribute("width","25" );
      ((Element)v.get(111)).setAttribute("height","8" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:112 / Elemento padre: 99   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(99)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(113)).setAttribute("nombre","cbSubAcceso" );
      ((Element)v.get(113)).setAttribute("id","datosCampos" );
      ((Element)v.get(113)).setAttribute("size","1" );
      ((Element)v.get(113)).setAttribute("multiple","N" );
      ((Element)v.get(113)).setAttribute("req","S" );
      ((Element)v.get(113)).setAttribute("valorinicial","" );
      ((Element)v.get(113)).setAttribute("textoinicial","" );
      ((Element)v.get(113)).setAttribute("ontab","setTabCampos('cbSubAcceso');" );
      ((Element)v.get(113)).setAttribute("onshtab","setShTabCampos('cbSubAcceso');" );
      ((Element)v.get(113)).setAttribute("onchange","" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:99   */

      /* Empieza nodo:115 / Elemento padre: 78   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(78)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("td"));
      ((Element)v.get(116)).setAttribute("colspan","4" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","8" );
      ((Element)v.get(117)).setAttribute("height","8" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:118 / Elemento padre: 75   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(75)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("table"));
      ((Element)v.get(120)).setAttribute("width","654" );
      ((Element)v.get(120)).setAttribute("border","0" );
      ((Element)v.get(120)).setAttribute("align","left" );
      ((Element)v.get(120)).setAttribute("cellspacing","0" );
      ((Element)v.get(120)).setAttribute("cellpadding","0" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("colspan","4" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(123)).setAttribute("width","8" );
      ((Element)v.get(123)).setAttribute("height","8" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:124 / Elemento padre: 120   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(120)).appendChild((Element)v.get(124));

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
      ((Element)v.get(128)).setAttribute("nombre","lblDireccion" );
      ((Element)v.get(128)).setAttribute("alto","13" );
      ((Element)v.get(128)).setAttribute("filas","1" );
      ((Element)v.get(128)).setAttribute("valor","" );
      ((Element)v.get(128)).setAttribute("id","datosTitle" );
      ((Element)v.get(128)).setAttribute("cod","BelParamBelce.valDire.label" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","8" );
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(132)).setAttribute("nombre","lblTelefono" );
      ((Element)v.get(132)).setAttribute("alto","13" );
      ((Element)v.get(132)).setAttribute("filas","1" );
      ((Element)v.get(132)).setAttribute("valor","" );
      ((Element)v.get(132)).setAttribute("id","datosTitle" );
      ((Element)v.get(132)).setAttribute("cod","BelParamBelce.valTfno.label" );
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
      ((Element)v.get(136)).setAttribute("nombre","lblNombreLocal" );
      ((Element)v.get(136)).setAttribute("alto","13" );
      ((Element)v.get(136)).setAttribute("filas","1" );
      ((Element)v.get(136)).setAttribute("valor","" );
      ((Element)v.get(136)).setAttribute("id","datosTitle" );
      ((Element)v.get(136)).setAttribute("cod","BelParamBelce.valNombLoca.label" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","25" );
      ((Element)v.get(138)).setAttribute("height","8" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(140)).setAttribute("nombre","lblCliente" );
      ((Element)v.get(140)).setAttribute("alto","13" );
      ((Element)v.get(140)).setAttribute("filas","1" );
      ((Element)v.get(140)).setAttribute("valor","" );
      ((Element)v.get(140)).setAttribute("id","datosTitle" );
      ((Element)v.get(140)).setAttribute("cod","BelParamBelce.clieOidClie.label" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(124)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","25" );
      ((Element)v.get(142)).setAttribute("height","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 124   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).setAttribute("width","100%" );
      ((Element)v.get(124)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","8" );
      ((Element)v.get(144)).setAttribute("height","8" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:124   */

      /* Empieza nodo:145 / Elemento padre: 120   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(120)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).setAttribute("width","8" );
      ((Element)v.get(147)).setAttribute("height","8" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:148 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(148)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(145)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(149)).setAttribute("nombre","txtDireccion" );
      ((Element)v.get(149)).setAttribute("id","datosCampos" );
      ((Element)v.get(149)).setAttribute("max","50" );
      ((Element)v.get(149)).setAttribute("tipo","" );
      ((Element)v.get(149)).setAttribute("req","S" );
      ((Element)v.get(149)).setAttribute("size","25" );
      ((Element)v.get(149)).setAttribute("valor","" );
      ((Element)v.get(149)).setAttribute("validacion","" );
      ((Element)v.get(149)).setAttribute("ontab","setTabCampos('txtDireccion');" );
      ((Element)v.get(149)).setAttribute("onshtab","setShTabCampos('txtDireccion');" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).setAttribute("width","25" );
      ((Element)v.get(151)).setAttribute("height","8" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(152)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(145)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(153)).setAttribute("nombre","txtTelefono" );
      ((Element)v.get(153)).setAttribute("id","datosCampos" );
      ((Element)v.get(153)).setAttribute("max","30" );
      ((Element)v.get(153)).setAttribute("tipo","" );
      ((Element)v.get(153)).setAttribute("onchange","" );
      ((Element)v.get(153)).setAttribute("req","N" );
      ((Element)v.get(153)).setAttribute("size","10" );
      ((Element)v.get(153)).setAttribute("valor","" );
      ((Element)v.get(153)).setAttribute("validacion","" );
      ((Element)v.get(153)).setAttribute("ontab","setTabCampos('txtTelefono');" );
      ((Element)v.get(153)).setAttribute("onshtab","setShTabCampos('txtTelefono');" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:154 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(155)).setAttribute("src","b.gif" );
      ((Element)v.get(155)).setAttribute("width","25" );
      ((Element)v.get(155)).setAttribute("height","8" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:156 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(145)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(157)).setAttribute("nombre","txtNombreLocal" );
      ((Element)v.get(157)).setAttribute("id","datosCampos" );
      ((Element)v.get(157)).setAttribute("max","40" );
      ((Element)v.get(157)).setAttribute("tipo","" );
      ((Element)v.get(157)).setAttribute("onchange","" );
      ((Element)v.get(157)).setAttribute("req","S" );
      ((Element)v.get(157)).setAttribute("size","30" );
      ((Element)v.get(157)).setAttribute("valor","" );
      ((Element)v.get(157)).setAttribute("validacion","" );
      ((Element)v.get(157)).setAttribute("ontab","setTabCampos('txtNombreLocal');" );
      ((Element)v.get(157)).setAttribute("onshtab","setShTabCampos('txtNombreLocal');" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:158 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","25" );
      ((Element)v.get(159)).setAttribute("height","8" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(145)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(161)).setAttribute("nombre","txtCodCliente" );
      ((Element)v.get(161)).setAttribute("id","datosCampos" );
      ((Element)v.get(161)).setAttribute("max","11" );
      ((Element)v.get(161)).setAttribute("tipo","" );
      ((Element)v.get(161)).setAttribute("onchange","onChangeCodigoCliente();" );
      ((Element)v.get(161)).setAttribute("req","S" );
      ((Element)v.get(161)).setAttribute("size","30" );
      ((Element)v.get(161)).setAttribute("valor","" );
      ((Element)v.get(161)).setAttribute("validacion","" );
      ((Element)v.get(161)).setAttribute("ontab","setTabCampos('txtCodCliente');" );
      ((Element)v.get(161)).setAttribute("onshtab","setShTabCampos('txtCodCliente');" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(161)).setAttribute("onblur","onBlurCodigoCliente()" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(145)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","iconBuscar.gif" );
      ((Element)v.get(163)).setAttribute("onmouseover","" );
      ((Element)v.get(163)).setAttribute("onclick","btnBusquedaClienteOnClick();" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(164)).setAttribute("width","100%" );
      ((Element)v.get(145)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(165)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).setAttribute("width","8" );
      ((Element)v.get(165)).setAttribute("height","8" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */
      /* Termina nodo:145   */

      /* Empieza nodo:166 / Elemento padre: 120   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(120)).appendChild((Element)v.get(166));

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
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:169 / Elemento padre: 75   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(75)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("table"));
      ((Element)v.get(171)).setAttribute("width","654" );
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
      ((Element)v.get(173)).setAttribute("colspan","4" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).setAttribute("width","8" );
      ((Element)v.get(174)).setAttribute("height","8" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:175 / Elemento padre: 171   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(171)).appendChild((Element)v.get(175));

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
      ((Element)v.get(175)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(179)).setAttribute("nombre","lblMontoMaxDife" );
      ((Element)v.get(179)).setAttribute("alto","13" );
      ((Element)v.get(179)).setAttribute("filas","1" );
      ((Element)v.get(179)).setAttribute("valor","" );
      ((Element)v.get(179)).setAttribute("id","datosTitle" );
      ((Element)v.get(179)).setAttribute("cod","BelParamBelce.valMontMaxiDife.label" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).setAttribute("width","25" );
      ((Element)v.get(181)).setAttribute("height","8" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(183)).setAttribute("nombre","lblLimiteCaja" );
      ((Element)v.get(183)).setAttribute("alto","13" );
      ((Element)v.get(183)).setAttribute("filas","1" );
      ((Element)v.get(183)).setAttribute("valor","" );
      ((Element)v.get(183)).setAttribute("id","datosTitle" );
      ((Element)v.get(183)).setAttribute("cod","BelParamBelce.valLimiEfecCaja.label" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(185)).setAttribute("src","b.gif" );
      ((Element)v.get(185)).setAttribute("width","25" );
      ((Element)v.get(185)).setAttribute("height","8" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(187)).setAttribute("nombre","lblNumeroCajas" );
      ((Element)v.get(187)).setAttribute("alto","13" );
      ((Element)v.get(187)).setAttribute("filas","1" );
      ((Element)v.get(187)).setAttribute("valor","" );
      ((Element)v.get(187)).setAttribute("id","datosTitle" );
      ((Element)v.get(187)).setAttribute("cod","BelParamBelce.numCaja.label" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:188 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(189)).setAttribute("src","b.gif" );
      ((Element)v.get(189)).setAttribute("width","8" );
      ((Element)v.get(189)).setAttribute("height","8" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:190 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(191)).setAttribute("nombre","lblTiempoReposicion" );
      ((Element)v.get(191)).setAttribute("alto","13" );
      ((Element)v.get(191)).setAttribute("filas","1" );
      ((Element)v.get(191)).setAttribute("valor","" );
      ((Element)v.get(191)).setAttribute("id","datosTitle" );
      ((Element)v.get(191)).setAttribute("cod","BelParamBelce.valTiempRepo.label" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 175   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","25" );
      ((Element)v.get(193)).setAttribute("height","8" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:175   */

      /* Empieza nodo:194 / Elemento padre: 171   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(171)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(196)).setAttribute("width","8" );
      ((Element)v.get(196)).setAttribute("height","8" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(194)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(198)).setAttribute("nombre","txtMontoMaxDife" );
      ((Element)v.get(198)).setAttribute("id","datosCampos" );
      ((Element)v.get(198)).setAttribute("max","15" );
      ((Element)v.get(198)).setAttribute("tipo","" );
      ((Element)v.get(198)).setAttribute("onchange","" );
      ((Element)v.get(198)).setAttribute("req","S" );
      ((Element)v.get(198)).setAttribute("size","15" );
      ((Element)v.get(198)).setAttribute("valor","" );
      ((Element)v.get(198)).setAttribute("validacion","" );
      ((Element)v.get(198)).setAttribute("ontab","setTabCampos('txtMontoMaxDife');" );
      ((Element)v.get(198)).setAttribute("onshtab","setShTabCampos('txtMontoMaxDife');" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(200)).setAttribute("src","b.gif" );
      ((Element)v.get(200)).setAttribute("width","25" );
      ((Element)v.get(200)).setAttribute("height","8" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:201 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(201)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(194)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(202)).setAttribute("nombre","txtLimiteCaja" );
      ((Element)v.get(202)).setAttribute("id","datosCampos" );
      ((Element)v.get(202)).setAttribute("max","15" );
      ((Element)v.get(202)).setAttribute("tipo","" );
      ((Element)v.get(202)).setAttribute("onchange","" );
      ((Element)v.get(202)).setAttribute("req","S" );
      ((Element)v.get(202)).setAttribute("size","15" );
      ((Element)v.get(202)).setAttribute("valor","" );
      ((Element)v.get(202)).setAttribute("validacion","" );
      ((Element)v.get(202)).setAttribute("ontab","setTabCampos('txtLimiteCaja');" );
      ((Element)v.get(202)).setAttribute("onshtab","setShTabCampos('txtLimiteCaja');" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:203 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).setAttribute("width","25" );
      ((Element)v.get(204)).setAttribute("height","8" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:205 / Elemento padre: 194   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(205)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(194)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(206)).setAttribute("nombre","txtNumeroCajas" );
      ((Element)v.get(206)).setAttribute("id","datosCampos" );
      ((Element)v.get(206)).setAttribute("max","7" );
      ((Element)v.get(206)).setAttribute("tipo","" );
      ((Element)v.get(206)).setAttribute("onchange","" );
      ((Element)v.get(206)).setAttribute("req","S" );
      ((Element)v.get(206)).setAttribute("size","7" );
      ((Element)v.get(206)).setAttribute("valor","" );
      ((Element)v.get(206)).setAttribute("validacion","" );
      ((Element)v.get(206)).setAttribute("ontab","setTabCampos('txtNumeroCajas');" );
      ((Element)v.get(206)).setAttribute("onshtab","setShTabCampos('txtNumeroCajas');" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:207 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).setAttribute("width","25" );
      ((Element)v.get(208)).setAttribute("height","8" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:209 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(209)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(194)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(210)).setAttribute("nombre","txtTiempoReposicion" );
      ((Element)v.get(210)).setAttribute("id","datosCampos" );
      ((Element)v.get(210)).setAttribute("max","9" );
      ((Element)v.get(210)).setAttribute("tipo","" );
      ((Element)v.get(210)).setAttribute("onchange","" );
      ((Element)v.get(210)).setAttribute("req","S" );
      ((Element)v.get(210)).setAttribute("size","9" );
      ((Element)v.get(210)).setAttribute("valor","" );
      ((Element)v.get(210)).setAttribute("validacion","" );
      ((Element)v.get(210)).setAttribute("ontab","setTabCampos('txtTiempoReposicion');" );
      ((Element)v.get(210)).setAttribute("onshtab","setShTabCampos('txtTiempoReposicion');" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */

      /* Empieza nodo:211 / Elemento padre: 194   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).setAttribute("width","100%" );
      ((Element)v.get(194)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(212)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).setAttribute("width","8" );
      ((Element)v.get(212)).setAttribute("height","8" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:194   */

      /* Empieza nodo:213 / Elemento padre: 171   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(171)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).setAttribute("colspan","4" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(215)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).setAttribute("width","8" );
      ((Element)v.get(215)).setAttribute("height","8" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */
      /* Termina nodo:213   */
      /* Termina nodo:171   */
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:216 / Elemento padre: 75   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(75)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("table"));
      ((Element)v.get(218)).setAttribute("width","654" );
      ((Element)v.get(218)).setAttribute("border","0" );
      ((Element)v.get(218)).setAttribute("align","left" );
      ((Element)v.get(218)).setAttribute("cellspacing","0" );
      ((Element)v.get(218)).setAttribute("cellpadding","0" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("td"));
      ((Element)v.get(220)).setAttribute("colspan","4" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(221)).setAttribute("src","b.gif" );
      ((Element)v.get(221)).setAttribute("width","8" );
      ((Element)v.get(221)).setAttribute("height","8" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:222 / Elemento padre: 218   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(218)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(224)).setAttribute("src","b.gif" );
      ((Element)v.get(224)).setAttribute("width","8" );
      ((Element)v.get(224)).setAttribute("height","8" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:225 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML990(Document doc) {
      ((Element)v.get(226)).setAttribute("nombre","lblAdministradorBel" );
      ((Element)v.get(226)).setAttribute("alto","13" );
      ((Element)v.get(226)).setAttribute("filas","1" );
      ((Element)v.get(226)).setAttribute("valor","" );
      ((Element)v.get(226)).setAttribute("id","datosTitle" );
      ((Element)v.get(226)).setAttribute("cod","BelParamBelce.valUsua.label" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:227 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(228)).setAttribute("src","b.gif" );
      ((Element)v.get(228)).setAttribute("width","25" );
      ((Element)v.get(228)).setAttribute("height","8" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:229 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(230)).setAttribute("nombre","lblFactorLocal" );
      ((Element)v.get(230)).setAttribute("alto","13" );
      ((Element)v.get(230)).setAttribute("filas","1" );
      ((Element)v.get(230)).setAttribute("valor","" );
      ((Element)v.get(230)).setAttribute("id","datosTitle" );
      ((Element)v.get(230)).setAttribute("cod","BelParamBelce.valFactLoca.label" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(232)).setAttribute("src","b.gif" );
      ((Element)v.get(232)).setAttribute("width","25" );
      ((Element)v.get(232)).setAttribute("height","8" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:233 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(234)).setAttribute("nombre","lblNumMaxProductos" );
      ((Element)v.get(234)).setAttribute("alto","13" );
      ((Element)v.get(234)).setAttribute("filas","1" );
      ((Element)v.get(234)).setAttribute("valor","" );
      ((Element)v.get(234)).setAttribute("id","datosTitle" );
      ((Element)v.get(234)).setAttribute("cod","BelParamBelce.numMaxiProd.label" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:235 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(236)).setAttribute("src","b.gif" );
      ((Element)v.get(236)).setAttribute("width","25" );
      ((Element)v.get(236)).setAttribute("height","8" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:237 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(222)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(238)).setAttribute("nombre","lblAlertStock" );
      ((Element)v.get(238)).setAttribute("alto","13" );
      ((Element)v.get(238)).setAttribute("filas","1" );
      ((Element)v.get(238)).setAttribute("valor","" );
      ((Element)v.get(238)).setAttribute("id","datosTitle" );
      ((Element)v.get(238)).setAttribute("cod","BelParamBelce.valAlerStoc.label" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).setAttribute("width","100%" );
      ((Element)v.get(222)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(240)).setAttribute("src","b.gif" );
      ((Element)v.get(240)).setAttribute("width","8" );
      ((Element)v.get(240)).setAttribute("height","8" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:241 / Elemento padre: 222   */
      v.add(doc.createElement("td"));
      ((Element)v.get(241)).setAttribute("width","100%" );
      ((Element)v.get(222)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(242)).setAttribute("src","b.gif" );
      ((Element)v.get(242)).setAttribute("width","8" );
      ((Element)v.get(242)).setAttribute("height","8" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */
      /* Termina nodo:222   */

      /* Empieza nodo:243 / Elemento padre: 218   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(218)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(245)).setAttribute("src","b.gif" );
      ((Element)v.get(245)).setAttribute("width","8" );
      ((Element)v.get(245)).setAttribute("height","8" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:246 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(246)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(243)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(247)).setAttribute("nombre","cbAdministradorBel" );
      ((Element)v.get(247)).setAttribute("id","datosCampos" );
      ((Element)v.get(247)).setAttribute("size","1" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(247)).setAttribute("multiple","N" );
      ((Element)v.get(247)).setAttribute("req","S" );
      ((Element)v.get(247)).setAttribute("valorinicial","" );
      ((Element)v.get(247)).setAttribute("textoinicial","" );
      ((Element)v.get(247)).setAttribute("ontab","setTabCampos('cbAdministradorBel');" );
      ((Element)v.get(247)).setAttribute("onshtab","setShTabCampos('cbAdministradorBel');" );
      ((Element)v.get(247)).setAttribute("onchange","" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:249 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(250)).setAttribute("src","b.gif" );
      ((Element)v.get(250)).setAttribute("width","25" );
      ((Element)v.get(250)).setAttribute("height","8" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */

      /* Empieza nodo:251 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(243)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(252)).setAttribute("nombre","txtFactorLocal" );
      ((Element)v.get(252)).setAttribute("id","datosCampos" );
      ((Element)v.get(252)).setAttribute("max","10" );
      ((Element)v.get(252)).setAttribute("tipo","" );
      ((Element)v.get(252)).setAttribute("onchange","" );
      ((Element)v.get(252)).setAttribute("req","S" );
      ((Element)v.get(252)).setAttribute("size","10" );
      ((Element)v.get(252)).setAttribute("valor","" );
      ((Element)v.get(252)).setAttribute("validacion","" );
      ((Element)v.get(252)).setAttribute("ontab","setTabCampos('txtFactorLocal');" );
      ((Element)v.get(252)).setAttribute("onshtab","setShTabCampos('txtFactorLocal');" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */

      /* Empieza nodo:253 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(254)).setAttribute("src","b.gif" );
      ((Element)v.get(254)).setAttribute("width","25" );
      ((Element)v.get(254)).setAttribute("height","8" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:255 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(255)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(243)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(256)).setAttribute("nombre","txtNumMaxProductos" );
      ((Element)v.get(256)).setAttribute("id","datosCampos" );
      ((Element)v.get(256)).setAttribute("max","3" );
      ((Element)v.get(256)).setAttribute("tipo","" );
      ((Element)v.get(256)).setAttribute("onchange","" );
      ((Element)v.get(256)).setAttribute("req","S" );
      ((Element)v.get(256)).setAttribute("size","3" );
      ((Element)v.get(256)).setAttribute("valor","" );
      ((Element)v.get(256)).setAttribute("validacion","" );
      ((Element)v.get(256)).setAttribute("ontab","setTabCampos('txtNumMaxProductos');" );
      ((Element)v.get(256)).setAttribute("onshtab","setShTabCampos('txtNumMaxProductos');" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:257 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(258)).setAttribute("src","b.gif" );
      ((Element)v.get(258)).setAttribute("width","25" );
      ((Element)v.get(258)).setAttribute("height","8" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:259 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(259)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(243)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(260)).setAttribute("nombre","txtAlertaStock" );
      ((Element)v.get(260)).setAttribute("id","datosCampos" );
      ((Element)v.get(260)).setAttribute("max","12" );
      ((Element)v.get(260)).setAttribute("tipo","" );
      ((Element)v.get(260)).setAttribute("onchange","" );
      ((Element)v.get(260)).setAttribute("req","S" );
      ((Element)v.get(260)).setAttribute("size","12" );
      ((Element)v.get(260)).setAttribute("valor","" );
      ((Element)v.get(260)).setAttribute("validacion","" );
      ((Element)v.get(260)).setAttribute("ontab","setTabCampos('txtAlertaStock');" );
      ((Element)v.get(260)).setAttribute("onshtab","setShTabCampos('txtAlertaStock');" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:261 / Elemento padre: 243   */
      v.add(doc.createElement("td"));
      ((Element)v.get(261)).setAttribute("width","100%" );
      ((Element)v.get(243)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(262)).setAttribute("src","b.gif" );
      ((Element)v.get(262)).setAttribute("width","8" );
      ((Element)v.get(262)).setAttribute("height","8" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */
      /* Termina nodo:243   */

      /* Empieza nodo:263 / Elemento padre: 218   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(218)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("td"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(264)).setAttribute("colspan","4" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(265)).setAttribute("src","b.gif" );
      ((Element)v.get(265)).setAttribute("width","8" );
      ((Element)v.get(265)).setAttribute("height","8" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */
      /* Termina nodo:263   */
      /* Termina nodo:218   */
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:266 / Elemento padre: 75   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(75)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("td"));
      ((Element)v.get(266)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("table"));
      ((Element)v.get(268)).setAttribute("width","654" );
      ((Element)v.get(268)).setAttribute("border","0" );
      ((Element)v.get(268)).setAttribute("align","left" );
      ((Element)v.get(268)).setAttribute("cellspacing","0" );
      ((Element)v.get(268)).setAttribute("cellpadding","0" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(268)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("td"));
      ((Element)v.get(270)).setAttribute("colspan","4" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(271)).setAttribute("width","8" );
      ((Element)v.get(271)).setAttribute("height","8" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */
      /* Termina nodo:269   */

      /* Empieza nodo:272 / Elemento padre: 268   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(268)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(274)).setAttribute("src","b.gif" );
      ((Element)v.get(274)).setAttribute("width","8" );
      ((Element)v.get(274)).setAttribute("height","8" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */

      /* Empieza nodo:275 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(272)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(276)).setAttribute("nombre","lblMovStockTransito" );
      ((Element)v.get(276)).setAttribute("alto","13" );
      ((Element)v.get(276)).setAttribute("filas","1" );
      ((Element)v.get(276)).setAttribute("valor","" );
      ((Element)v.get(276)).setAttribute("id","datosTitle" );
      ((Element)v.get(276)).setAttribute("cod","BelParamBelce.tmalOidStocTran.label" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:277 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(272)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(278)).setAttribute("src","b.gif" );
      ((Element)v.get(278)).setAttribute("width","25" );
      ((Element)v.get(278)).setAttribute("height","8" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:279 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(272)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(280)).setAttribute("nombre","lblMovConfirmarStock" );
      ((Element)v.get(280)).setAttribute("alto","13" );
      ((Element)v.get(280)).setAttribute("filas","1" );
      ((Element)v.get(280)).setAttribute("valor","" );
      ((Element)v.get(280)).setAttribute("id","datosTitle" );
      ((Element)v.get(280)).setAttribute("cod","BelParamBelce.tmalOidConfStoc.label" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */

      /* Empieza nodo:281 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(272)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(282)).setAttribute("src","b.gif" );
      ((Element)v.get(282)).setAttribute("width","25" );
      ((Element)v.get(282)).setAttribute("height","8" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */

      /* Empieza nodo:283 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(272)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(284)).setAttribute("nombre","lblMovReg" );
      ((Element)v.get(284)).setAttribute("alto","13" );
      ((Element)v.get(284)).setAttribute("filas","1" );
      ((Element)v.get(284)).setAttribute("valor","" );
      ((Element)v.get(284)).setAttribute("id","datosTitle" );
      ((Element)v.get(284)).setAttribute("cod","BelParamBelce.tmalOidRegu.label" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:285 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
      ((Element)v.get(285)).setAttribute("width","100%" );
      ((Element)v.get(272)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(286)).setAttribute("src","b.gif" );
      ((Element)v.get(286)).setAttribute("width","8" );
      ((Element)v.get(286)).setAttribute("height","8" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:285   */

      /* Empieza nodo:287 / Elemento padre: 272   */
      v.add(doc.createElement("td"));
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(287)).setAttribute("width","100%" );
      ((Element)v.get(272)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(288)).setAttribute("src","b.gif" );
      ((Element)v.get(288)).setAttribute("width","8" );
      ((Element)v.get(288)).setAttribute("height","8" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:287   */
      /* Termina nodo:272   */

      /* Empieza nodo:289 / Elemento padre: 268   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(268)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(289)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(291)).setAttribute("src","b.gif" );
      ((Element)v.get(291)).setAttribute("width","8" );
      ((Element)v.get(291)).setAttribute("height","8" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */

      /* Empieza nodo:292 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(292)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(289)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(293)).setAttribute("nombre","cbMovStockTransito" );
      ((Element)v.get(293)).setAttribute("id","datosCampos" );
      ((Element)v.get(293)).setAttribute("size","1" );
      ((Element)v.get(293)).setAttribute("multiple","N" );
      ((Element)v.get(293)).setAttribute("req","S" );
      ((Element)v.get(293)).setAttribute("valorinicial","" );
      ((Element)v.get(293)).setAttribute("textoinicial","" );
      ((Element)v.get(293)).setAttribute("ontab","setTabCampos('cbMovStockTransito');" );
      ((Element)v.get(293)).setAttribute("onshtab","setShTabCampos('cbMovStockTransito');" );
      ((Element)v.get(293)).setAttribute("onchange","" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(293)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:295 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(289)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(296)).setAttribute("src","b.gif" );
      ((Element)v.get(296)).setAttribute("width","25" );
      ((Element)v.get(296)).setAttribute("height","8" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */

      /* Empieza nodo:297 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(297)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(289)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(298)).setAttribute("nombre","cbMovConfirmarStock" );
      ((Element)v.get(298)).setAttribute("id","datosCampos" );
      ((Element)v.get(298)).setAttribute("size","1" );
      ((Element)v.get(298)).setAttribute("multiple","N" );
      ((Element)v.get(298)).setAttribute("req","N" );
      ((Element)v.get(298)).setAttribute("valorinicial","" );
      ((Element)v.get(298)).setAttribute("textoinicial","" );
      ((Element)v.get(298)).setAttribute("ontab","setTabCampos('cbMovConfirmarStock');" );
      ((Element)v.get(298)).setAttribute("onshtab","setShTabCampos('cbMovConfirmarStock');" );
      ((Element)v.get(298)).setAttribute("onchange","" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:300 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(289)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(301)).setAttribute("src","b.gif" );
      ((Element)v.get(301)).setAttribute("width","25" );
      ((Element)v.get(301)).setAttribute("height","8" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:300   */

      /* Empieza nodo:302 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(302)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(289)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(303)).setAttribute("nombre","cbMovReg" );
      ((Element)v.get(303)).setAttribute("id","datosCampos" );
      ((Element)v.get(303)).setAttribute("size","1" );
      ((Element)v.get(303)).setAttribute("multiple","N" );
      ((Element)v.get(303)).setAttribute("req","S" );
      ((Element)v.get(303)).setAttribute("valorinicial","" );
      ((Element)v.get(303)).setAttribute("textoinicial","" );
      ((Element)v.get(303)).setAttribute("ontab","setTabCampos('cbMovReg');" );
      ((Element)v.get(303)).setAttribute("onshtab","setShTabCampos('cbMovReg');" );
      ((Element)v.get(303)).setAttribute("onchange","" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */
      /* Termina nodo:302   */

      /* Empieza nodo:305 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(305)).setAttribute("width","100%" );
      ((Element)v.get(289)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(306)).setAttribute("src","b.gif" );
      ((Element)v.get(306)).setAttribute("width","8" );
      ((Element)v.get(306)).setAttribute("height","8" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */
      /* Termina nodo:289   */

      /* Empieza nodo:307 / Elemento padre: 268   */
      v.add(doc.createElement("tr"));
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(268)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("td"));
      ((Element)v.get(308)).setAttribute("colspan","4" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(309)).setAttribute("src","b.gif" );
      ((Element)v.get(309)).setAttribute("width","8" );
      ((Element)v.get(309)).setAttribute("height","8" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */
      /* Termina nodo:307   */
      /* Termina nodo:268   */
      /* Termina nodo:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:310 / Elemento padre: 75   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(75)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("table"));
      ((Element)v.get(312)).setAttribute("width","654" );
      ((Element)v.get(312)).setAttribute("border","0" );
      ((Element)v.get(312)).setAttribute("align","left" );
      ((Element)v.get(312)).setAttribute("cellspacing","0" );
      ((Element)v.get(312)).setAttribute("cellpadding","0" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(312)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("td"));
      ((Element)v.get(314)).setAttribute("colspan","4" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(315)).setAttribute("src","b.gif" );
      ((Element)v.get(315)).setAttribute("width","8" );
      ((Element)v.get(315)).setAttribute("height","8" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:314   */
      /* Termina nodo:313   */

      /* Empieza nodo:316 / Elemento padre: 312   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(312)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(316)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(318)).setAttribute("src","b.gif" );
      ((Element)v.get(318)).setAttribute("width","8" );
      ((Element)v.get(318)).setAttribute("height","8" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:317   */

      /* Empieza nodo:319 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(316)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(320)).setAttribute("nombre","lblMovRegSap" );
      ((Element)v.get(320)).setAttribute("alto","13" );
      ((Element)v.get(320)).setAttribute("filas","1" );
      ((Element)v.get(320)).setAttribute("valor","" );
      ((Element)v.get(320)).setAttribute("id","datosTitle" );
      ((Element)v.get(320)).setAttribute("cod","BelParamBelce.tmalOidReguSap.label" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */

      /* Empieza nodo:321 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(316)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(322)).setAttribute("src","b.gif" );
      ((Element)v.get(322)).setAttribute("width","25" );
      ((Element)v.get(322)).setAttribute("height","8" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */
      /* Termina nodo:321   */

      /* Empieza nodo:323 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(316)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(324)).setAttribute("nombre","lblDevolverStockExist" );
      ((Element)v.get(324)).setAttribute("alto","13" );
      ((Element)v.get(324)).setAttribute("filas","1" );
      ((Element)v.get(324)).setAttribute("valor","" );
      ((Element)v.get(324)).setAttribute("id","datosTitle" );
      ((Element)v.get(324)).setAttribute("cod","BelParamBelce.tmalOidDevoStoc.label" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */
      /* Termina nodo:323   */

      /* Empieza nodo:325 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(316)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(326)).setAttribute("src","b.gif" );
      ((Element)v.get(326)).setAttribute("width","25" );
      ((Element)v.get(326)).setAttribute("height","8" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:325   */

      /* Empieza nodo:327 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(316)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(328)).setAttribute("nombre","lblMovPetExist" );
      ((Element)v.get(328)).setAttribute("alto","13" );
      ((Element)v.get(328)).setAttribute("filas","1" );
      ((Element)v.get(328)).setAttribute("valor","" );
      ((Element)v.get(328)).setAttribute("id","datosTitle" );
      ((Element)v.get(328)).setAttribute("cod","BelParamBelce.tmalOidPetiExis.label" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:327   */

      /* Empieza nodo:329 / Elemento padre: 316   */
      v.add(doc.createElement("td"));
      ((Element)v.get(329)).setAttribute("width","100%" );
      ((Element)v.get(316)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(330)).setAttribute("src","b.gif" );
      ((Element)v.get(330)).setAttribute("width","8" );
      ((Element)v.get(330)).setAttribute("height","8" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(329)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:329   */
      /* Termina nodo:316   */

      /* Empieza nodo:331 / Elemento padre: 312   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(312)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("td"));
      ((Element)v.get(331)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(333)).setAttribute("src","b.gif" );
      ((Element)v.get(333)).setAttribute("width","8" );
      ((Element)v.get(333)).setAttribute("height","8" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */
      /* Termina nodo:332   */

      /* Empieza nodo:334 / Elemento padre: 331   */
      v.add(doc.createElement("td"));
      ((Element)v.get(334)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(331)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(335)).setAttribute("nombre","cbMovRegSap" );
      ((Element)v.get(335)).setAttribute("id","datosCampos" );
      ((Element)v.get(335)).setAttribute("size","1" );
      ((Element)v.get(335)).setAttribute("multiple","N" );
      ((Element)v.get(335)).setAttribute("req","S" );
      ((Element)v.get(335)).setAttribute("valorinicial","" );
      ((Element)v.get(335)).setAttribute("textoinicial","" );
      ((Element)v.get(335)).setAttribute("ontab","setTabCampos('cbMovRegSap');" );
      ((Element)v.get(335)).setAttribute("onshtab","setShTabCampos('cbMovRegSap');" );
      ((Element)v.get(335)).setAttribute("onchange","" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */
      /* Termina nodo:334   */

      /* Empieza nodo:337 / Elemento padre: 331   */
      v.add(doc.createElement("td"));
      ((Element)v.get(331)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(338)).setAttribute("src","b.gif" );
      ((Element)v.get(338)).setAttribute("width","25" );
      ((Element)v.get(338)).setAttribute("height","8" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:339 / Elemento padre: 331   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(331)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(340)).setAttribute("nombre","cbDevolverStockExist" );
      ((Element)v.get(340)).setAttribute("id","datosCampos" );
      ((Element)v.get(340)).setAttribute("size","1" );
      ((Element)v.get(340)).setAttribute("multiple","N" );
      ((Element)v.get(340)).setAttribute("req","S" );
      ((Element)v.get(340)).setAttribute("valorinicial","" );
      ((Element)v.get(340)).setAttribute("textoinicial","" );
      ((Element)v.get(340)).setAttribute("ontab","setTabCampos('cbDevolverStockExist');" );
      ((Element)v.get(340)).setAttribute("onshtab","setShTabCampos('cbDevolverStockExist');" );
      ((Element)v.get(340)).setAttribute("onchange","" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(340)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */
      /* Termina nodo:340   */
      /* Termina nodo:339   */

      /* Empieza nodo:342 / Elemento padre: 331   */
      v.add(doc.createElement("td"));
      ((Element)v.get(331)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(343)).setAttribute("src","b.gif" );
      ((Element)v.get(343)).setAttribute("width","25" );
      ((Element)v.get(343)).setAttribute("height","8" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */
      /* Termina nodo:342   */

      /* Empieza nodo:344 / Elemento padre: 331   */
      v.add(doc.createElement("td"));
      ((Element)v.get(344)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(331)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(345)).setAttribute("nombre","cbMovPetExist" );
      ((Element)v.get(345)).setAttribute("id","datosCampos" );
      ((Element)v.get(345)).setAttribute("size","1" );
      ((Element)v.get(345)).setAttribute("multiple","N" );
      ((Element)v.get(345)).setAttribute("req","N" );
      ((Element)v.get(345)).setAttribute("valorinicial","" );
      ((Element)v.get(345)).setAttribute("textoinicial","" );
      ((Element)v.get(345)).setAttribute("ontab","setTabCampos('cbMovPetExist');" );
      ((Element)v.get(345)).setAttribute("onshtab","setShTabCampos('cbMovPetExist');" );
      ((Element)v.get(345)).setAttribute("onchange","" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:345   */
      /* Termina nodo:344   */

      /* Empieza nodo:347 / Elemento padre: 331   */
      v.add(doc.createElement("td"));
      ((Element)v.get(347)).setAttribute("width","100%" );
      ((Element)v.get(331)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(348)).setAttribute("src","b.gif" );
      ((Element)v.get(348)).setAttribute("width","8" );
      ((Element)v.get(348)).setAttribute("height","8" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:347   */
      /* Termina nodo:331   */

      /* Empieza nodo:349 / Elemento padre: 312   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(312)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("td"));
      ((Element)v.get(350)).setAttribute("colspan","4" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(351)).setAttribute("src","b.gif" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(351)).setAttribute("width","8" );
      ((Element)v.get(351)).setAttribute("height","8" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */
      /* Termina nodo:350   */
      /* Termina nodo:349   */
      /* Termina nodo:312   */
      /* Termina nodo:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:352 / Elemento padre: 75   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(75)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("td"));
      ((Element)v.get(352)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("table"));
      ((Element)v.get(354)).setAttribute("width","654" );
      ((Element)v.get(354)).setAttribute("border","0" );
      ((Element)v.get(354)).setAttribute("align","left" );
      ((Element)v.get(354)).setAttribute("cellspacing","0" );
      ((Element)v.get(354)).setAttribute("cellpadding","0" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(354)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(356)).setAttribute("colspan","4" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(357)).setAttribute("src","b.gif" );
      ((Element)v.get(357)).setAttribute("width","8" );
      ((Element)v.get(357)).setAttribute("height","8" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */
      /* Termina nodo:355   */

      /* Empieza nodo:358 / Elemento padre: 354   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(354)).appendChild((Element)v.get(358));

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
      ((Element)v.get(362)).setAttribute("nombre","lblMovConfirmarStockTransito" );
      ((Element)v.get(362)).setAttribute("alto","13" );
      ((Element)v.get(362)).setAttribute("filas","1" );
      ((Element)v.get(362)).setAttribute("valor","" );
      ((Element)v.get(362)).setAttribute("id","datosTitle" );
      ((Element)v.get(362)).setAttribute("cod","BelParamBelce.tmalOidConfStocTran.label" );
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
      ((Element)v.get(366)).setAttribute("nombre","lblMovStockDev" );
      ((Element)v.get(366)).setAttribute("alto","13" );
      ((Element)v.get(366)).setAttribute("filas","1" );
      ((Element)v.get(366)).setAttribute("valor","" );
      ((Element)v.get(366)).setAttribute("id","datosTitle" );
      ((Element)v.get(366)).setAttribute("cod","BelParamBelce.tmalOidStocDevo.label" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */
      /* Termina nodo:365   */

      /* Empieza nodo:367 / Elemento padre: 358   */
      v.add(doc.createElement("td"));
      ((Element)v.get(358)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(368)).setAttribute("src","b.gif" );
      ((Element)v.get(368)).setAttribute("width","25" );
      ((Element)v.get(368)).setAttribute("height","8" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */
      /* Termina nodo:367   */

      /* Empieza nodo:369 / Elemento padre: 358   */
      v.add(doc.createElement("td"));
      ((Element)v.get(358)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(370)).setAttribute("nombre","lblTipoMovCob" );
      ((Element)v.get(370)).setAttribute("alto","13" );
      ((Element)v.get(370)).setAttribute("filas","1" );
      ((Element)v.get(370)).setAttribute("valor","" );
      ((Element)v.get(370)).setAttribute("id","datosTitle" );
      ((Element)v.get(370)).setAttribute("cod","BelParamBelce.tmvcOidCobr.label" );
      ((Element)v.get(369)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */
      /* Termina nodo:369   */

      /* Empieza nodo:371 / Elemento padre: 358   */
      v.add(doc.createElement("td"));
      ((Element)v.get(371)).setAttribute("width","100%" );
      ((Element)v.get(358)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(372)).setAttribute("src","b.gif" );
      ((Element)v.get(372)).setAttribute("width","8" );
      ((Element)v.get(372)).setAttribute("height","8" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */
      /* Termina nodo:371   */
      /* Termina nodo:358   */

      /* Empieza nodo:373 / Elemento padre: 354   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(354)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("td"));
      ((Element)v.get(373)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(375)).setAttribute("src","b.gif" );
      ((Element)v.get(375)).setAttribute("width","8" );
      ((Element)v.get(375)).setAttribute("height","8" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */
      /* Termina nodo:374   */

      /* Empieza nodo:376 / Elemento padre: 373   */
      v.add(doc.createElement("td"));
      ((Element)v.get(376)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(373)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(377)).setAttribute("nombre","cbMovConfirmarStockTransito" );
      ((Element)v.get(377)).setAttribute("id","datosCampos" );
      ((Element)v.get(377)).setAttribute("size","1" );
      ((Element)v.get(377)).setAttribute("multiple","N" );
      ((Element)v.get(377)).setAttribute("req","N" );
      ((Element)v.get(377)).setAttribute("valorinicial","" );
      ((Element)v.get(377)).setAttribute("textoinicial","" );
      ((Element)v.get(377)).setAttribute("ontab","setTabCampos('cbMovConfirmarStockTransito');" );
      ((Element)v.get(377)).setAttribute("onshtab","setShTabCampos('cbMovConfirmarStockTransito');" );
      ((Element)v.get(377)).setAttribute("onchange","" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(377)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:377   */
      /* Termina nodo:376   */

      /* Empieza nodo:379 / Elemento padre: 373   */
      v.add(doc.createElement("td"));
      ((Element)v.get(373)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(380)).setAttribute("src","b.gif" );
      ((Element)v.get(380)).setAttribute("width","25" );
      ((Element)v.get(380)).setAttribute("height","8" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */
      /* Termina nodo:379   */

      /* Empieza nodo:381 / Elemento padre: 373   */
      v.add(doc.createElement("td"));
      ((Element)v.get(381)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(373)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(382)).setAttribute("nombre","cbMovStockDev" );
      ((Element)v.get(382)).setAttribute("id","datosCampos" );
      ((Element)v.get(382)).setAttribute("size","1" );
      ((Element)v.get(382)).setAttribute("multiple","N" );
      ((Element)v.get(382)).setAttribute("req","S" );
      ((Element)v.get(382)).setAttribute("valorinicial","" );
      ((Element)v.get(382)).setAttribute("textoinicial","" );
      ((Element)v.get(382)).setAttribute("ontab","setTabCampos('cbMovStockDev');" );
      ((Element)v.get(382)).setAttribute("onshtab","setShTabCampos('cbMovStockDev');" );
      ((Element)v.get(382)).setAttribute("onchange","" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(382)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */
      /* Termina nodo:382   */
      /* Termina nodo:381   */

      /* Empieza nodo:384 / Elemento padre: 373   */
      v.add(doc.createElement("td"));
      ((Element)v.get(373)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(385)).setAttribute("src","b.gif" );
      ((Element)v.get(385)).setAttribute("width","25" );
      ((Element)v.get(385)).setAttribute("height","8" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */
      /* Termina nodo:384   */

      /* Empieza nodo:386 / Elemento padre: 373   */
      v.add(doc.createElement("td"));
      ((Element)v.get(386)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(373)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(387)).setAttribute("nombre","cbTipoMovCob" );
      ((Element)v.get(387)).setAttribute("id","datosCampos" );
      ((Element)v.get(387)).setAttribute("size","1" );
      ((Element)v.get(387)).setAttribute("multiple","N" );
      ((Element)v.get(387)).setAttribute("req","S" );
      ((Element)v.get(387)).setAttribute("valorinicial","" );
      ((Element)v.get(387)).setAttribute("textoinicial","" );
      ((Element)v.get(387)).setAttribute("ontab","setTabCampos('cbTipoMovCob');" );
      ((Element)v.get(387)).setAttribute("onshtab","setShTabCampos('cbTipoMovCob');" );
      ((Element)v.get(387)).setAttribute("onchange","" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(387)).appendChild((Element)v.get(388));
      /* Termina nodo:388   */
      /* Termina nodo:387   */
      /* Termina nodo:386   */

      /* Empieza nodo:389 / Elemento padre: 373   */
      v.add(doc.createElement("td"));
      ((Element)v.get(389)).setAttribute("width","100%" );
      ((Element)v.get(373)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(390)).setAttribute("src","b.gif" );
      ((Element)v.get(390)).setAttribute("width","8" );
      ((Element)v.get(390)).setAttribute("height","8" );
      ((Element)v.get(389)).appendChild((Element)v.get(390));
      /* Termina nodo:390   */
      /* Termina nodo:389   */
      /* Termina nodo:373   */

      /* Empieza nodo:391 / Elemento padre: 354   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(354)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("td"));
      ((Element)v.get(392)).setAttribute("colspan","4" );
      ((Element)v.get(391)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(393)).setAttribute("src","b.gif" );
      ((Element)v.get(393)).setAttribute("width","8" );
      ((Element)v.get(393)).setAttribute("height","8" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));
      /* Termina nodo:393   */
      /* Termina nodo:392   */
      /* Termina nodo:391   */
      /* Termina nodo:354   */
      /* Termina nodo:353   */
      /* Termina nodo:352   */

      /* Empieza nodo:394 / Elemento padre: 75   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(75)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("td"));
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(394)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("table"));
      ((Element)v.get(396)).setAttribute("width","654" );
      ((Element)v.get(396)).setAttribute("border","0" );
      ((Element)v.get(396)).setAttribute("align","left" );
      ((Element)v.get(396)).setAttribute("cellspacing","0" );
      ((Element)v.get(396)).setAttribute("cellpadding","0" );
      ((Element)v.get(395)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(396)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("td"));
      ((Element)v.get(398)).setAttribute("colspan","4" );
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

      /* Empieza nodo:400 / Elemento padre: 396   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(396)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("td"));
      ((Element)v.get(400)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(402)).setAttribute("src","b.gif" );
      ((Element)v.get(402)).setAttribute("width","8" );
      ((Element)v.get(402)).setAttribute("height","8" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */
      /* Termina nodo:401   */

      /* Empieza nodo:403 / Elemento padre: 400   */
      v.add(doc.createElement("td"));
      ((Element)v.get(400)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(404)).setAttribute("nombre","lblCodCliente" );
      ((Element)v.get(404)).setAttribute("alto","13" );
      ((Element)v.get(404)).setAttribute("filas","1" );
      ((Element)v.get(404)).setAttribute("valor","" );
      ((Element)v.get(404)).setAttribute("id","datosTitle" );
      ((Element)v.get(404)).setAttribute("cod","BelParamBelce.sociOidSoci.label" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));
      /* Termina nodo:404   */
      /* Termina nodo:403   */

      /* Empieza nodo:405 / Elemento padre: 400   */
      v.add(doc.createElement("td"));
      ((Element)v.get(400)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(406)).setAttribute("src","b.gif" );
      ((Element)v.get(406)).setAttribute("width","25" );
      ((Element)v.get(406)).setAttribute("height","8" );
      ((Element)v.get(405)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */
      /* Termina nodo:405   */

      /* Empieza nodo:407 / Elemento padre: 400   */
      v.add(doc.createElement("td"));
      ((Element)v.get(400)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(408)).setAttribute("nombre","lblCuentaCCC" );
      ((Element)v.get(408)).setAttribute("alto","13" );
      ((Element)v.get(408)).setAttribute("filas","1" );
      ((Element)v.get(408)).setAttribute("valor","" );
      ((Element)v.get(408)).setAttribute("id","datosTitle" );
      ((Element)v.get(408)).setAttribute("cod","BelParamBelce.ccbaOidCuenCorrBanc.label" );
      ((Element)v.get(407)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */
      /* Termina nodo:407   */

      /* Empieza nodo:409 / Elemento padre: 400   */
      v.add(doc.createElement("td"));
      ((Element)v.get(400)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(410)).setAttribute("src","b.gif" );
      ((Element)v.get(410)).setAttribute("width","25" );
      ((Element)v.get(410)).setAttribute("height","8" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */
      /* Termina nodo:409   */

      /* Empieza nodo:411 / Elemento padre: 400   */
      v.add(doc.createElement("td"));
      ((Element)v.get(400)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(412)).setAttribute("nombre","lblTipoMovCierre" );
      ((Element)v.get(412)).setAttribute("alto","13" );
      ((Element)v.get(412)).setAttribute("filas","1" );
      ((Element)v.get(412)).setAttribute("valor","" );
      ((Element)v.get(412)).setAttribute("id","datosTitle" );
      ((Element)v.get(412)).setAttribute("cod","BelParamBelce.tmvcOidCier.label" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */
      /* Termina nodo:411   */

      /* Empieza nodo:413 / Elemento padre: 400   */
      v.add(doc.createElement("td"));
      ((Element)v.get(413)).setAttribute("width","100%" );
      ((Element)v.get(400)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(414)).setAttribute("src","b.gif" );
      ((Element)v.get(414)).setAttribute("width","8" );
      ((Element)v.get(414)).setAttribute("height","8" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */
      /* Termina nodo:413   */
      /* Termina nodo:400   */

      /* Empieza nodo:415 / Elemento padre: 396   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(396)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("td"));
      ((Element)v.get(415)).appendChild((Element)v.get(416));

      /* Empieza nodo:417 / Elemento padre: 416   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(417)).setAttribute("src","b.gif" );
      ((Element)v.get(417)).setAttribute("width","8" );
      ((Element)v.get(417)).setAttribute("height","8" );
      ((Element)v.get(416)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */
      /* Termina nodo:416   */

      /* Empieza nodo:418 / Elemento padre: 415   */
      v.add(doc.createElement("td"));
      ((Element)v.get(418)).setAttribute("nowrap","nowrap" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(415)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(419)).setAttribute("nombre","cbSociedad" );
      ((Element)v.get(419)).setAttribute("id","datosCampos" );
      ((Element)v.get(419)).setAttribute("size","1" );
      ((Element)v.get(419)).setAttribute("multiple","N" );
      ((Element)v.get(419)).setAttribute("req","S" );
      ((Element)v.get(419)).setAttribute("valorinicial","" );
      ((Element)v.get(419)).setAttribute("textoinicial","" );
      ((Element)v.get(419)).setAttribute("ontab","setTabCampos('cbSociedad');" );
      ((Element)v.get(419)).setAttribute("onshtab","setShTabCampos('cbSociedad');" );
      ((Element)v.get(419)).setAttribute("onchange","cbSociedadOnChange();" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));

      /* Empieza nodo:420 / Elemento padre: 419   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(419)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */
      /* Termina nodo:419   */
      /* Termina nodo:418   */

      /* Empieza nodo:421 / Elemento padre: 415   */
      v.add(doc.createElement("td"));
      ((Element)v.get(415)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(422)).setAttribute("src","b.gif" );
      ((Element)v.get(422)).setAttribute("width","25" );
      ((Element)v.get(422)).setAttribute("height","8" );
      ((Element)v.get(421)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */
      /* Termina nodo:421   */

      /* Empieza nodo:423 / Elemento padre: 415   */
      v.add(doc.createElement("td"));
      ((Element)v.get(423)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(415)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(424)).setAttribute("nombre","cbCuentaCCC" );
      ((Element)v.get(424)).setAttribute("id","datosCampos" );
      ((Element)v.get(424)).setAttribute("size","1" );
      ((Element)v.get(424)).setAttribute("multiple","N" );
      ((Element)v.get(424)).setAttribute("req","S" );
      ((Element)v.get(424)).setAttribute("valorinicial","" );
      ((Element)v.get(424)).setAttribute("textoinicial","" );
      ((Element)v.get(424)).setAttribute("ontab","setTabCampos('cbCuentaCCC');" );
      ((Element)v.get(424)).setAttribute("onshtab","setShTabCampos('cbCuentaCCC');" );
      ((Element)v.get(424)).setAttribute("onchange","" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(424)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */
      /* Termina nodo:424   */
      /* Termina nodo:423   */

      /* Empieza nodo:426 / Elemento padre: 415   */
      v.add(doc.createElement("td"));
      ((Element)v.get(415)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(427)).setAttribute("src","b.gif" );
      ((Element)v.get(427)).setAttribute("width","25" );
      ((Element)v.get(427)).setAttribute("height","8" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */
      /* Termina nodo:426   */

      /* Empieza nodo:428 / Elemento padre: 415   */
      v.add(doc.createElement("td"));
      ((Element)v.get(428)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(415)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(429)).setAttribute("nombre","cbTipoMovCierre" );
      ((Element)v.get(429)).setAttribute("id","datosCampos" );
      ((Element)v.get(429)).setAttribute("size","1" );
      ((Element)v.get(429)).setAttribute("multiple","N" );
      ((Element)v.get(429)).setAttribute("req","S" );
      ((Element)v.get(429)).setAttribute("valorinicial","" );
      ((Element)v.get(429)).setAttribute("textoinicial","" );
      ((Element)v.get(429)).setAttribute("ontab","setTabCampos('cbTipoMovCierre');" );
      ((Element)v.get(429)).setAttribute("onshtab","setShTabCampos('cbTipoMovCierre');" );
      ((Element)v.get(429)).setAttribute("onchange","" );
      ((Element)v.get(428)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(429)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */
      /* Termina nodo:429   */
      /* Termina nodo:428   */

      /* Empieza nodo:431 / Elemento padre: 415   */
      v.add(doc.createElement("td"));
      ((Element)v.get(431)).setAttribute("width","100%" );
      ((Element)v.get(415)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(432)).setAttribute("src","b.gif" );
      ((Element)v.get(432)).setAttribute("width","8" );
      ((Element)v.get(432)).setAttribute("height","8" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));
      /* Termina nodo:432   */
      /* Termina nodo:431   */
      /* Termina nodo:415   */

      /* Empieza nodo:433 / Elemento padre: 396   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(396)).appendChild((Element)v.get(433));

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
      /* Termina nodo:396   */
      /* Termina nodo:395   */
      /* Termina nodo:394   */

      /* Empieza nodo:436 / Elemento padre: 75   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(75)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("td"));
      ((Element)v.get(436)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("table"));
      ((Element)v.get(438)).setAttribute("width","654" );
      ((Element)v.get(438)).setAttribute("border","0" );
      ((Element)v.get(438)).setAttribute("align","left" );
      ((Element)v.get(438)).setAttribute("cellspacing","0" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(438)).setAttribute("cellpadding","0" );
      ((Element)v.get(437)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(438)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("td"));
      ((Element)v.get(440)).setAttribute("colspan","4" );
      ((Element)v.get(439)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(441)).setAttribute("src","b.gif" );
      ((Element)v.get(441)).setAttribute("width","8" );
      ((Element)v.get(441)).setAttribute("height","8" );
      ((Element)v.get(440)).appendChild((Element)v.get(441));
      /* Termina nodo:441   */
      /* Termina nodo:440   */
      /* Termina nodo:439   */

      /* Empieza nodo:442 / Elemento padre: 438   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(438)).appendChild((Element)v.get(442));

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
      ((Element)v.get(446)).setAttribute("nombre","lblTipoTransaccion" );
      ((Element)v.get(446)).setAttribute("alto","13" );
      ((Element)v.get(446)).setAttribute("filas","1" );
      ((Element)v.get(446)).setAttribute("valor","" );
      ((Element)v.get(446)).setAttribute("id","datosTitle" );
      ((Element)v.get(446)).setAttribute("cod","702" );
      ((Element)v.get(445)).appendChild((Element)v.get(446));
      /* Termina nodo:446   */
      /* Termina nodo:445   */

      /* Empieza nodo:447 / Elemento padre: 442   */
      v.add(doc.createElement("td"));
      ((Element)v.get(447)).setAttribute("width","100%" );
      ((Element)v.get(442)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(448)).setAttribute("src","b.gif" );
      ((Element)v.get(448)).setAttribute("width","8" );
      ((Element)v.get(448)).setAttribute("height","8" );
      ((Element)v.get(447)).appendChild((Element)v.get(448));
      /* Termina nodo:448   */
      /* Termina nodo:447   */
      /* Termina nodo:442   */

      /* Empieza nodo:449 / Elemento padre: 438   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(438)).appendChild((Element)v.get(449));

      /* Empieza nodo:450 / Elemento padre: 449   */
      v.add(doc.createElement("td"));
      ((Element)v.get(449)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(451)).setAttribute("src","b.gif" );
      ((Element)v.get(451)).setAttribute("width","8" );
      ((Element)v.get(451)).setAttribute("height","8" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));
      /* Termina nodo:451   */
      /* Termina nodo:450   */

      /* Empieza nodo:452 / Elemento padre: 449   */
      v.add(doc.createElement("td"));
      ((Element)v.get(452)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(449)).appendChild((Element)v.get(452));

      /* Empieza nodo:453 / Elemento padre: 452   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(453)).setAttribute("nombre","cbTipoTransaccion" );
      ((Element)v.get(453)).setAttribute("id","datosCampos" );
      ((Element)v.get(453)).setAttribute("size","1" );
      ((Element)v.get(453)).setAttribute("multiple","N" );
      ((Element)v.get(453)).setAttribute("req","S" );
      ((Element)v.get(453)).setAttribute("valorinicial","" );
      ((Element)v.get(453)).setAttribute("textoinicial","" );
      ((Element)v.get(453)).setAttribute("ontab","setTabCampos('cbTipoTransaccion');" );
      ((Element)v.get(453)).setAttribute("onshtab","setShTabCampos('cbTipoTransaccion');" );
      ((Element)v.get(453)).setAttribute("onchange","" );
      ((Element)v.get(452)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(453)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */
      /* Termina nodo:453   */
      /* Termina nodo:452   */

      /* Empieza nodo:455 / Elemento padre: 449   */
      v.add(doc.createElement("td"));
      ((Element)v.get(455)).setAttribute("width","100%" );
      ((Element)v.get(449)).appendChild((Element)v.get(455));

      /* Empieza nodo:456 / Elemento padre: 455   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(456)).setAttribute("src","b.gif" );
      ((Element)v.get(456)).setAttribute("width","8" );
      ((Element)v.get(456)).setAttribute("height","8" );
      ((Element)v.get(455)).appendChild((Element)v.get(456));
      /* Termina nodo:456   */
      /* Termina nodo:455   */
      /* Termina nodo:449   */

      /* Empieza nodo:457 / Elemento padre: 438   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(438)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("td"));
      ((Element)v.get(458)).setAttribute("colspan","4" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));

      /* Empieza nodo:459 / Elemento padre: 458   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(459)).setAttribute("src","b.gif" );
      ((Element)v.get(459)).setAttribute("width","8" );
      ((Element)v.get(459)).setAttribute("height","8" );
      ((Element)v.get(458)).appendChild((Element)v.get(459));
      /* Termina nodo:459   */
      /* Termina nodo:458   */
      /* Termina nodo:457   */
      /* Termina nodo:438   */
      /* Termina nodo:437   */
      /* Termina nodo:436   */
      /* Termina nodo:75   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:460 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(461)).setAttribute("src","b.gif" );
      ((Element)v.get(461)).setAttribute("width","8" );
      ((Element)v.get(461)).setAttribute("height","12" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));
      /* Termina nodo:461   */
      /* Termina nodo:460   */
      /* Termina nodo:68   */

      /* Empieza nodo:462 / Elemento padre: 60   */
   }

   private void getXML1980(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(60)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("td"));
      ((Element)v.get(463)).setAttribute("width","12" );
      ((Element)v.get(463)).setAttribute("align","center" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));

      /* Empieza nodo:464 / Elemento padre: 463   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(464)).setAttribute("src","b.gif" );
      ((Element)v.get(464)).setAttribute("width","12" );
      ((Element)v.get(464)).setAttribute("height","12" );
      ((Element)v.get(463)).appendChild((Element)v.get(464));
      /* Termina nodo:464   */
      /* Termina nodo:463   */

      /* Empieza nodo:465 / Elemento padre: 462   */
      v.add(doc.createElement("td"));
      ((Element)v.get(465)).setAttribute("width","756" );
      ((Element)v.get(462)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(466)).setAttribute("src","b.gif" );
      ((Element)v.get(465)).appendChild((Element)v.get(466));
      /* Termina nodo:466   */
      /* Termina nodo:465   */

      /* Empieza nodo:467 / Elemento padre: 462   */
      v.add(doc.createElement("td"));
      ((Element)v.get(467)).setAttribute("width","12" );
      ((Element)v.get(462)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(468)).setAttribute("src","b.gif" );
      ((Element)v.get(468)).setAttribute("width","12" );
      ((Element)v.get(468)).setAttribute("height","12" );
      ((Element)v.get(467)).appendChild((Element)v.get(468));
      /* Termina nodo:468   */
      /* Termina nodo:467   */
      /* Termina nodo:462   */
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:469 / Elemento padre: 30   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(469)).setAttribute("nombre","listado3" );
      ((Element)v.get(469)).setAttribute("ancho","542" );
      ((Element)v.get(469)).setAttribute("alto","301" );
      ((Element)v.get(469)).setAttribute("x","12" );
      ((Element)v.get(469)).setAttribute("y","54" );
      ((Element)v.get(469)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(469)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(30)).appendChild((Element)v.get(469));

      /* Empieza nodo:470 / Elemento padre: 469   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(470)).setAttribute("precarga","S" );
      ((Element)v.get(470)).setAttribute("conROver","S" );
      ((Element)v.get(469)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(471)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(471)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(471)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(471)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(470)).appendChild((Element)v.get(471));
      /* Termina nodo:471   */

      /* Empieza nodo:472 / Elemento padre: 470   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(472)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(472)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(472)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(472)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(470)).appendChild((Element)v.get(472));
      /* Termina nodo:472   */

      /* Empieza nodo:473 / Elemento padre: 470   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(473)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(473)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(470)).appendChild((Element)v.get(473));
      /* Termina nodo:473   */
      /* Termina nodo:470   */

      /* Empieza nodo:474 / Elemento padre: 469   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(469)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(475)).setAttribute("borde","1" );
      ((Element)v.get(475)).setAttribute("horizDatos","1" );
      ((Element)v.get(475)).setAttribute("horizCabecera","1" );
      ((Element)v.get(475)).setAttribute("vertical","0" );
      ((Element)v.get(475)).setAttribute("horizTitulo","1" );
      ((Element)v.get(475)).setAttribute("horizBase","1" );
      ((Element)v.get(474)).appendChild((Element)v.get(475));
      /* Termina nodo:475   */

      /* Empieza nodo:476 / Elemento padre: 474   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(476)).setAttribute("borde","#999999" );
      ((Element)v.get(476)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(476)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(476)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(476)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(476)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(476)).setAttribute("horizBase","#999999" );
      ((Element)v.get(474)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */
      /* Termina nodo:474   */

      /* Empieza nodo:477 / Elemento padre: 469   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(477)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(477)).setAttribute("alto","22" );
      ((Element)v.get(477)).setAttribute("imgFondo","" );
      ((Element)v.get(477)).setAttribute("cod","0098" );
      ((Element)v.get(477)).setAttribute("ID","datosTitle" );
      ((Element)v.get(469)).appendChild((Element)v.get(477));
      /* Termina nodo:477   */

      /* Empieza nodo:478 / Elemento padre: 469   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(478)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(478)).setAttribute("alto","22" );
      ((Element)v.get(478)).setAttribute("imgFondo","" );
      ((Element)v.get(469)).appendChild((Element)v.get(478));
      /* Termina nodo:478   */

      /* Empieza nodo:479 / Elemento padre: 469   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(479)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(479)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(479)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(479)).setAttribute("sinSaltoLinea","S" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(479)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(479)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(469)).appendChild((Element)v.get(479));

      /* Empieza nodo:480 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(480)).setAttribute("ancho","130" );
      ((Element)v.get(480)).setAttribute("minimizable","S" );
      ((Element)v.get(480)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(480));
      /* Termina nodo:480   */

      /* Empieza nodo:481 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(481)).setAttribute("ancho","130" );
      ((Element)v.get(481)).setAttribute("minimizable","S" );
      ((Element)v.get(481)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(481));
      /* Termina nodo:481   */

      /* Empieza nodo:482 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(482)).setAttribute("ancho","130" );
      ((Element)v.get(482)).setAttribute("minimizable","S" );
      ((Element)v.get(482)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(482));
      /* Termina nodo:482   */

      /* Empieza nodo:483 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(483)).setAttribute("ancho","100" );
      ((Element)v.get(483)).setAttribute("minimizable","S" );
      ((Element)v.get(483)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(483));
      /* Termina nodo:483   */

      /* Empieza nodo:484 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(484)).setAttribute("ancho","130" );
      ((Element)v.get(484)).setAttribute("minimizable","S" );
      ((Element)v.get(484)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(484));
      /* Termina nodo:484   */

      /* Empieza nodo:485 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(485)).setAttribute("ancho","180" );
      ((Element)v.get(485)).setAttribute("minimizable","S" );
      ((Element)v.get(485)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(485));
      /* Termina nodo:485   */

      /* Empieza nodo:486 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(486)).setAttribute("ancho","150" );
      ((Element)v.get(486)).setAttribute("minimizable","S" );
      ((Element)v.get(486)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(486));
      /* Termina nodo:486   */

      /* Empieza nodo:487 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(487)).setAttribute("ancho","120" );
      ((Element)v.get(487)).setAttribute("minimizable","S" );
      ((Element)v.get(487)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(487));
      /* Termina nodo:487   */

      /* Empieza nodo:488 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(488)).setAttribute("ancho","130" );
      ((Element)v.get(488)).setAttribute("minimizable","S" );
      ((Element)v.get(488)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(488));
      /* Termina nodo:488   */

      /* Empieza nodo:489 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(489)).setAttribute("ancho","160" );
      ((Element)v.get(489)).setAttribute("minimizable","S" );
      ((Element)v.get(489)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(489));
      /* Termina nodo:489   */

      /* Empieza nodo:490 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(490)).setAttribute("ancho","140" );
      ((Element)v.get(490)).setAttribute("minimizable","S" );
      ((Element)v.get(490)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(490));
      /* Termina nodo:490   */

      /* Empieza nodo:491 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(491)).setAttribute("ancho","200" );
      ((Element)v.get(491)).setAttribute("minimizable","S" );
      ((Element)v.get(491)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */

      /* Empieza nodo:492 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(492)).setAttribute("ancho","200" );
      ((Element)v.get(492)).setAttribute("minimizable","S" );
      ((Element)v.get(492)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(492));
      /* Termina nodo:492   */

      /* Empieza nodo:493 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(493)).setAttribute("ancho","120" );
      ((Element)v.get(493)).setAttribute("minimizable","S" );
      ((Element)v.get(493)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(493));
      /* Termina nodo:493   */

      /* Empieza nodo:494 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(494)).setAttribute("ancho","200" );
      ((Element)v.get(494)).setAttribute("minimizable","S" );
      ((Element)v.get(494)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */

      /* Empieza nodo:495 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(495)).setAttribute("ancho","200" );
      ((Element)v.get(495)).setAttribute("minimizable","S" );
      ((Element)v.get(495)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(495));
      /* Termina nodo:495   */

      /* Empieza nodo:496 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(496)).setAttribute("ancho","200" );
      ((Element)v.get(496)).setAttribute("minimizable","S" );
      ((Element)v.get(496)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(496));
      /* Termina nodo:496   */

      /* Empieza nodo:497 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(497)).setAttribute("ancho","200" );
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(497)).setAttribute("minimizable","S" );
      ((Element)v.get(497)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(497));
      /* Termina nodo:497   */

      /* Empieza nodo:498 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(498)).setAttribute("ancho","260" );
      ((Element)v.get(498)).setAttribute("minimizable","S" );
      ((Element)v.get(498)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(498));
      /* Termina nodo:498   */

      /* Empieza nodo:499 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(499)).setAttribute("ancho","200" );
      ((Element)v.get(499)).setAttribute("minimizable","S" );
      ((Element)v.get(499)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(499));
      /* Termina nodo:499   */

      /* Empieza nodo:500 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(500)).setAttribute("ancho","260" );
      ((Element)v.get(500)).setAttribute("minimizable","S" );
      ((Element)v.get(500)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(500));
      /* Termina nodo:500   */

      /* Empieza nodo:501 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(501)).setAttribute("ancho","200" );
      ((Element)v.get(501)).setAttribute("minimizable","S" );
      ((Element)v.get(501)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(501));
      /* Termina nodo:501   */

      /* Empieza nodo:502 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(502)).setAttribute("ancho","130" );
      ((Element)v.get(502)).setAttribute("minimizable","S" );
      ((Element)v.get(502)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(502));
      /* Termina nodo:502   */

      /* Empieza nodo:503 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(503)).setAttribute("ancho","50" );
      ((Element)v.get(503)).setAttribute("minimizable","S" );
      ((Element)v.get(503)).setAttribute("minimizada","N" );
      ((Element)v.get(503)).setAttribute("oculta","S" );
      ((Element)v.get(479)).appendChild((Element)v.get(503));
      /* Termina nodo:503   */

      /* Empieza nodo:504 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(504)).setAttribute("ancho","50" );
      ((Element)v.get(504)).setAttribute("minimizable","S" );
      ((Element)v.get(504)).setAttribute("minimizada","N" );
      ((Element)v.get(504)).setAttribute("oculta","S" );
      ((Element)v.get(479)).appendChild((Element)v.get(504));
      /* Termina nodo:504   */

      /* Empieza nodo:505 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(505)).setAttribute("ancho","180" );
      ((Element)v.get(505)).setAttribute("minimizable","S" );
      ((Element)v.get(505)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(505));
      /* Termina nodo:505   */

      /* Empieza nodo:506 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(506)).setAttribute("ancho","100" );
      ((Element)v.get(506)).setAttribute("minimizable","S" );
      ((Element)v.get(506)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(506));
      /* Termina nodo:506   */

      /* Empieza nodo:507 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(507)).setAttribute("ancho","130" );
      ((Element)v.get(507)).setAttribute("minimizable","S" );
      ((Element)v.get(507)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(507));
      /* Termina nodo:507   */

      /* Empieza nodo:508 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(508)).setAttribute("ancho","50" );
      ((Element)v.get(508)).setAttribute("minimizable","S" );
      ((Element)v.get(508)).setAttribute("minimizada","N" );
      ((Element)v.get(508)).setAttribute("oculta","S" );
      ((Element)v.get(479)).appendChild((Element)v.get(508));
      /* Termina nodo:508   */

      /* Empieza nodo:509 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(509)).setAttribute("ancho","50" );
      ((Element)v.get(509)).setAttribute("minimizable","S" );
      ((Element)v.get(509)).setAttribute("minimizada","N" );
      ((Element)v.get(509)).setAttribute("oculta","S" );
      ((Element)v.get(479)).appendChild((Element)v.get(509));
      /* Termina nodo:509   */

      /* Empieza nodo:510 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(510)).setAttribute("ancho","50" );
      ((Element)v.get(510)).setAttribute("minimizable","S" );
      ((Element)v.get(510)).setAttribute("minimizada","N" );
      ((Element)v.get(510)).setAttribute("oculta","S" );
      ((Element)v.get(479)).appendChild((Element)v.get(510));
      /* Termina nodo:510   */

      /* Empieza nodo:511 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(511)).setAttribute("ancho","50" );
      ((Element)v.get(511)).setAttribute("minimizable","S" );
      ((Element)v.get(511)).setAttribute("minimizada","N" );
      ((Element)v.get(511)).setAttribute("oculta","S" );
      ((Element)v.get(479)).appendChild((Element)v.get(511));
      /* Termina nodo:511   */

      /* Empieza nodo:512 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(512)).setAttribute("ancho","50" );
      ((Element)v.get(512)).setAttribute("minimizable","S" );
      ((Element)v.get(512)).setAttribute("minimizada","N" );
      ((Element)v.get(512)).setAttribute("oculta","S" );
      ((Element)v.get(479)).appendChild((Element)v.get(512));
      /* Termina nodo:512   */
      /* Termina nodo:479   */

      /* Empieza nodo:513 / Elemento padre: 469   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(513)).setAttribute("alto","20" );
      ((Element)v.get(513)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(513)).setAttribute("imgFondo","" );
      ((Element)v.get(513)).setAttribute("colFondo","#CCCCCC" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(469)).appendChild((Element)v.get(513));

      /* Empieza nodo:514 / Elemento padre: 513   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(514)).setAttribute("colFondo","" );
      ((Element)v.get(514)).setAttribute("ID","EstCab" );
      ((Element)v.get(514)).setAttribute("cod","7" );
      ((Element)v.get(513)).appendChild((Element)v.get(514));
      /* Termina nodo:514   */

      /* Empieza nodo:515 / Elemento padre: 513   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(515)).setAttribute("colFondo","" );
      ((Element)v.get(515)).setAttribute("ID","EstCab" );
      ((Element)v.get(515)).setAttribute("cod","10" );
      ((Element)v.get(513)).appendChild((Element)v.get(515));
      /* Termina nodo:515   */

      /* Empieza nodo:516 / Elemento padre: 513   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(516)).setAttribute("colFondo","" );
      ((Element)v.get(516)).setAttribute("ID","EstCab" );
      ((Element)v.get(516)).setAttribute("cod","122" );
      ((Element)v.get(513)).appendChild((Element)v.get(516));
      /* Termina nodo:516   */

      /* Empieza nodo:517 / Elemento padre: 513   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(517)).setAttribute("colFondo","" );
      ((Element)v.get(517)).setAttribute("ID","EstCab" );
      ((Element)v.get(517)).setAttribute("cod","00417" );
      ((Element)v.get(513)).appendChild((Element)v.get(517));
      /* Termina nodo:517   */

      /* Empieza nodo:518 / Elemento padre: 513   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(518)).setAttribute("colFondo","" );
      ((Element)v.get(518)).setAttribute("ID","EstCab" );
      ((Element)v.get(518)).setAttribute("cod","125" );
      ((Element)v.get(513)).appendChild((Element)v.get(518));
      /* Termina nodo:518   */

      /* Empieza nodo:519 / Elemento padre: 513   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(519)).setAttribute("colFondo","" );
      ((Element)v.get(519)).setAttribute("ID","EstCab" );
      ((Element)v.get(519)).setAttribute("cod","BelParamBelce.valMontMaxiDife.label" );
      ((Element)v.get(513)).appendChild((Element)v.get(519));
      /* Termina nodo:519   */

      /* Empieza nodo:520 / Elemento padre: 513   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(520)).setAttribute("colFondo","" );
      ((Element)v.get(520)).setAttribute("ID","EstCab" );
      ((Element)v.get(520)).setAttribute("cod","BelParamBelce.valLimiEfecCaja.label" );
      ((Element)v.get(513)).appendChild((Element)v.get(520));
      /* Termina nodo:520   */

      /* Empieza nodo:521 / Elemento padre: 513   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(521)).setAttribute("colFondo","" );
      ((Element)v.get(521)).setAttribute("ID","EstCab" );
      ((Element)v.get(521)).setAttribute("cod","BelParamBelce.numCaja.label" );
      ((Element)v.get(513)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */

      /* Empieza nodo:522 / Elemento padre: 513   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(522)).setAttribute("colFondo","" );
      ((Element)v.get(522)).setAttribute("ID","EstCab" );
      ((Element)v.get(522)).setAttribute("cod","BelParamBelce.valNombLoca.label" );
      ((Element)v.get(513)).appendChild((Element)v.get(522));
      /* Termina nodo:522   */

      /* Empieza nodo:523 / Elemento padre: 513   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(523)).setAttribute("colFondo","" );
      ((Element)v.get(523)).setAttribute("ID","EstCab" );
      ((Element)v.get(523)).setAttribute("cod","BelParamBelce.valTiempRepo.label" );
      ((Element)v.get(513)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */

      /* Empieza nodo:524 / Elemento padre: 513   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(524)).setAttribute("colFondo","" );
      ((Element)v.get(524)).setAttribute("ID","EstCab" );
      ((Element)v.get(524)).setAttribute("cod","BelParamBelce.valFactLoca.label" );
      ((Element)v.get(513)).appendChild((Element)v.get(524));
      /* Termina nodo:524   */

      /* Empieza nodo:525 / Elemento padre: 513   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(525)).setAttribute("colFondo","" );
      ((Element)v.get(525)).setAttribute("ID","EstCab" );
      ((Element)v.get(525)).setAttribute("cod","2292" );
      ((Element)v.get(513)).appendChild((Element)v.get(525));
      /* Termina nodo:525   */

      /* Empieza nodo:526 / Elemento padre: 513   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(526)).setAttribute("colFondo","" );
      ((Element)v.get(526)).setAttribute("ID","EstCab" );
      ((Element)v.get(526)).setAttribute("cod","BelParamBelce.numMaxiProd.label" );
      ((Element)v.get(513)).appendChild((Element)v.get(526));
      /* Termina nodo:526   */

      /* Empieza nodo:527 / Elemento padre: 513   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(527)).setAttribute("colFondo","" );
      ((Element)v.get(527)).setAttribute("ID","EstCab" );
      ((Element)v.get(527)).setAttribute("cod","BelParamBelce.valAlerStoc.label" );
      ((Element)v.get(513)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */

      /* Empieza nodo:528 / Elemento padre: 513   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(528)).setAttribute("colFondo","" );
      ((Element)v.get(528)).setAttribute("ID","EstCab" );
      ((Element)v.get(528)).setAttribute("cod","BelParamBelce.tmalOidStocTran.label" );
      ((Element)v.get(513)).appendChild((Element)v.get(528));
      /* Termina nodo:528   */

      /* Empieza nodo:529 / Elemento padre: 513   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(529)).setAttribute("colFondo","" );
      ((Element)v.get(529)).setAttribute("ID","EstCab" );
      ((Element)v.get(529)).setAttribute("cod","BelParamBelce.tmalOidConfStoc.label" );
      ((Element)v.get(513)).appendChild((Element)v.get(529));
      /* Termina nodo:529   */

      /* Empieza nodo:530 / Elemento padre: 513   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(530)).setAttribute("colFondo","" );
      ((Element)v.get(530)).setAttribute("ID","EstCab" );
      ((Element)v.get(530)).setAttribute("cod","BelParamBelce.tmalOidRegu.label" );
      ((Element)v.get(513)).appendChild((Element)v.get(530));
      /* Termina nodo:530   */

      /* Empieza nodo:531 / Elemento padre: 513   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(531)).setAttribute("colFondo","" );
      ((Element)v.get(531)).setAttribute("ID","EstCab" );
      ((Element)v.get(531)).setAttribute("cod","BelParamBelce.tmalOidReguSap.label" );
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(513)).appendChild((Element)v.get(531));
      /* Termina nodo:531   */

      /* Empieza nodo:532 / Elemento padre: 513   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(532)).setAttribute("colFondo","" );
      ((Element)v.get(532)).setAttribute("ID","EstCab" );
      ((Element)v.get(532)).setAttribute("cod","BelParamBelce.tmalOidDevoStoc.label" );
      ((Element)v.get(513)).appendChild((Element)v.get(532));
      /* Termina nodo:532   */

      /* Empieza nodo:533 / Elemento padre: 513   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(533)).setAttribute("colFondo","" );
      ((Element)v.get(533)).setAttribute("ID","EstCab" );
      ((Element)v.get(533)).setAttribute("cod","BelParamBelce.tmalOidPetiExis.label" );
      ((Element)v.get(513)).appendChild((Element)v.get(533));
      /* Termina nodo:533   */

      /* Empieza nodo:534 / Elemento padre: 513   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(534)).setAttribute("colFondo","" );
      ((Element)v.get(534)).setAttribute("ID","EstCab" );
      ((Element)v.get(534)).setAttribute("cod","BelParamBelce.tmalOidConfStocTran.label" );
      ((Element)v.get(513)).appendChild((Element)v.get(534));
      /* Termina nodo:534   */

      /* Empieza nodo:535 / Elemento padre: 513   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(535)).setAttribute("colFondo","" );
      ((Element)v.get(535)).setAttribute("ID","EstCab" );
      ((Element)v.get(535)).setAttribute("cod","BelParamBelce.tmalOidStocDevo.label" );
      ((Element)v.get(513)).appendChild((Element)v.get(535));
      /* Termina nodo:535   */

      /* Empieza nodo:536 / Elemento padre: 513   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(536)).setAttribute("colFondo","" );
      ((Element)v.get(536)).setAttribute("ID","EstCab" );
      ((Element)v.get(536)).setAttribute("cod","BelParamBelce.tmvcOidCobr.label" );
      ((Element)v.get(513)).appendChild((Element)v.get(536));
      /* Termina nodo:536   */

      /* Empieza nodo:537 / Elemento padre: 513   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(537)).setAttribute("colFondo","" );
      ((Element)v.get(537)).setAttribute("ID","EstCab" );
      ((Element)v.get(537)).setAttribute("cod","BelParamBelce.clieOidClie.label" );
      ((Element)v.get(513)).appendChild((Element)v.get(537));
      /* Termina nodo:537   */

      /* Empieza nodo:538 / Elemento padre: 513   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(538)).setAttribute("colFondo","" );
      ((Element)v.get(538)).setAttribute("ID","EstCab" );
      ((Element)v.get(538)).setAttribute("cod","BelParamBelce.ccbaOidCuenCorrBanc.label" );
      ((Element)v.get(513)).appendChild((Element)v.get(538));
      /* Termina nodo:538   */

      /* Empieza nodo:539 / Elemento padre: 513   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(539)).setAttribute("colFondo","" );
      ((Element)v.get(539)).setAttribute("ID","EstCab" );
      ((Element)v.get(539)).setAttribute("cod","BelParamBelce.tmvcOidCier.label" );
      ((Element)v.get(513)).appendChild((Element)v.get(539));
      /* Termina nodo:539   */

      /* Empieza nodo:540 / Elemento padre: 513   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(540)).setAttribute("colFondo","" );
      ((Element)v.get(540)).setAttribute("ID","EstCab" );
      ((Element)v.get(540)).setAttribute("cod","57" );
      ((Element)v.get(513)).appendChild((Element)v.get(540));
      /* Termina nodo:540   */

      /* Empieza nodo:541 / Elemento padre: 513   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(541)).setAttribute("colFondo","" );
      ((Element)v.get(541)).setAttribute("ID","EstCab" );
      ((Element)v.get(541)).setAttribute("cod","702" );
      ((Element)v.get(513)).appendChild((Element)v.get(541));
      /* Termina nodo:541   */

      /* Empieza nodo:542 / Elemento padre: 513   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(542)).setAttribute("colFondo","" );
      ((Element)v.get(542)).setAttribute("ID","EstCab" );
      ((Element)v.get(542)).setAttribute("cod","1" );
      ((Element)v.get(513)).appendChild((Element)v.get(542));
      /* Termina nodo:542   */

      /* Empieza nodo:543 / Elemento padre: 513   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(543)).setAttribute("colFondo","" );
      ((Element)v.get(543)).setAttribute("ID","EstCab" );
      ((Element)v.get(543)).setAttribute("cod","1" );
      ((Element)v.get(513)).appendChild((Element)v.get(543));
      /* Termina nodo:543   */

      /* Empieza nodo:544 / Elemento padre: 513   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(544)).setAttribute("colFondo","" );
      ((Element)v.get(544)).setAttribute("ID","EstCab" );
      ((Element)v.get(544)).setAttribute("cod","1" );
      ((Element)v.get(513)).appendChild((Element)v.get(544));
      /* Termina nodo:544   */

      /* Empieza nodo:545 / Elemento padre: 513   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(545)).setAttribute("colFondo","" );
      ((Element)v.get(545)).setAttribute("ID","EstCab" );
      ((Element)v.get(545)).setAttribute("cod","1" );
      ((Element)v.get(513)).appendChild((Element)v.get(545));
      /* Termina nodo:545   */

      /* Empieza nodo:546 / Elemento padre: 513   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(546)).setAttribute("colFondo","" );
      ((Element)v.get(546)).setAttribute("ID","EstCab" );
      ((Element)v.get(546)).setAttribute("cod","1" );
      ((Element)v.get(513)).appendChild((Element)v.get(546));
      /* Termina nodo:546   */
      /* Termina nodo:513   */

      /* Empieza nodo:547 / Elemento padre: 469   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(547)).setAttribute("alto","22" );
      ((Element)v.get(547)).setAttribute("accion","" );
      ((Element)v.get(547)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(547)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(547)).setAttribute("maxSel","-1" );
      ((Element)v.get(547)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(547)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(547)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(547)).setAttribute("onLoad","" );
      ((Element)v.get(547)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(469)).appendChild((Element)v.get(547));

      /* Empieza nodo:548 / Elemento padre: 547   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(548)).setAttribute("tipo","texto" );
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(548)).setAttribute("ID","EstDat2" );
      ((Element)v.get(547)).appendChild((Element)v.get(548));
      /* Termina nodo:548   */

      /* Empieza nodo:549 / Elemento padre: 547   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(549)).setAttribute("tipo","texto" );
      ((Element)v.get(549)).setAttribute("ID","EstDat" );
      ((Element)v.get(547)).appendChild((Element)v.get(549));
      /* Termina nodo:549   */

      /* Empieza nodo:550 / Elemento padre: 547   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(550)).setAttribute("tipo","texto" );
      ((Element)v.get(550)).setAttribute("ID","EstDat2" );
      ((Element)v.get(547)).appendChild((Element)v.get(550));
      /* Termina nodo:550   */

      /* Empieza nodo:551 / Elemento padre: 547   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(551)).setAttribute("tipo","texto" );
      ((Element)v.get(551)).setAttribute("ID","EstDat" );
      ((Element)v.get(547)).appendChild((Element)v.get(551));
      /* Termina nodo:551   */

      /* Empieza nodo:552 / Elemento padre: 547   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(552)).setAttribute("tipo","texto" );
      ((Element)v.get(552)).setAttribute("ID","EstDat2" );
      ((Element)v.get(547)).appendChild((Element)v.get(552));
      /* Termina nodo:552   */

      /* Empieza nodo:553 / Elemento padre: 547   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(553)).setAttribute("tipo","texto" );
      ((Element)v.get(553)).setAttribute("ID","EstDat" );
      ((Element)v.get(547)).appendChild((Element)v.get(553));
      /* Termina nodo:553   */

      /* Empieza nodo:554 / Elemento padre: 547   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(554)).setAttribute("tipo","texto" );
      ((Element)v.get(554)).setAttribute("ID","EstDat2" );
      ((Element)v.get(547)).appendChild((Element)v.get(554));
      /* Termina nodo:554   */

      /* Empieza nodo:555 / Elemento padre: 547   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(555)).setAttribute("tipo","texto" );
      ((Element)v.get(555)).setAttribute("ID","EstDat" );
      ((Element)v.get(547)).appendChild((Element)v.get(555));
      /* Termina nodo:555   */

      /* Empieza nodo:556 / Elemento padre: 547   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(556)).setAttribute("tipo","texto" );
      ((Element)v.get(556)).setAttribute("ID","EstDat2" );
      ((Element)v.get(547)).appendChild((Element)v.get(556));
      /* Termina nodo:556   */

      /* Empieza nodo:557 / Elemento padre: 547   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(557)).setAttribute("tipo","texto" );
      ((Element)v.get(557)).setAttribute("ID","EstDat" );
      ((Element)v.get(547)).appendChild((Element)v.get(557));
      /* Termina nodo:557   */

      /* Empieza nodo:558 / Elemento padre: 547   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(558)).setAttribute("tipo","texto" );
      ((Element)v.get(558)).setAttribute("ID","EstDat2" );
      ((Element)v.get(547)).appendChild((Element)v.get(558));
      /* Termina nodo:558   */

      /* Empieza nodo:559 / Elemento padre: 547   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(559)).setAttribute("tipo","texto" );
      ((Element)v.get(559)).setAttribute("ID","EstDat" );
      ((Element)v.get(547)).appendChild((Element)v.get(559));
      /* Termina nodo:559   */

      /* Empieza nodo:560 / Elemento padre: 547   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(560)).setAttribute("tipo","texto" );
      ((Element)v.get(560)).setAttribute("ID","EstDat2" );
      ((Element)v.get(547)).appendChild((Element)v.get(560));
      /* Termina nodo:560   */

      /* Empieza nodo:561 / Elemento padre: 547   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(561)).setAttribute("tipo","texto" );
      ((Element)v.get(561)).setAttribute("ID","EstDat" );
      ((Element)v.get(547)).appendChild((Element)v.get(561));
      /* Termina nodo:561   */

      /* Empieza nodo:562 / Elemento padre: 547   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(562)).setAttribute("tipo","texto" );
      ((Element)v.get(562)).setAttribute("ID","EstDat2" );
      ((Element)v.get(547)).appendChild((Element)v.get(562));
      /* Termina nodo:562   */

      /* Empieza nodo:563 / Elemento padre: 547   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(563)).setAttribute("tipo","texto" );
      ((Element)v.get(563)).setAttribute("ID","EstDat" );
      ((Element)v.get(547)).appendChild((Element)v.get(563));
      /* Termina nodo:563   */

      /* Empieza nodo:564 / Elemento padre: 547   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(564)).setAttribute("tipo","texto" );
      ((Element)v.get(564)).setAttribute("ID","EstDat2" );
      ((Element)v.get(547)).appendChild((Element)v.get(564));
      /* Termina nodo:564   */

      /* Empieza nodo:565 / Elemento padre: 547   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(565)).setAttribute("tipo","texto" );
      ((Element)v.get(565)).setAttribute("ID","EstDat" );
      ((Element)v.get(547)).appendChild((Element)v.get(565));
      /* Termina nodo:565   */

      /* Empieza nodo:566 / Elemento padre: 547   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(566)).setAttribute("tipo","texto" );
      ((Element)v.get(566)).setAttribute("ID","EstDat2" );
      ((Element)v.get(547)).appendChild((Element)v.get(566));
      /* Termina nodo:566   */

      /* Empieza nodo:567 / Elemento padre: 547   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(567)).setAttribute("tipo","texto" );
      ((Element)v.get(567)).setAttribute("ID","EstDat" );
      ((Element)v.get(547)).appendChild((Element)v.get(567));
      /* Termina nodo:567   */

      /* Empieza nodo:568 / Elemento padre: 547   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(568)).setAttribute("tipo","texto" );
      ((Element)v.get(568)).setAttribute("ID","EstDat2" );
      ((Element)v.get(547)).appendChild((Element)v.get(568));
      /* Termina nodo:568   */

      /* Empieza nodo:569 / Elemento padre: 547   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(569)).setAttribute("tipo","texto" );
      ((Element)v.get(569)).setAttribute("ID","EstDat" );
      ((Element)v.get(547)).appendChild((Element)v.get(569));
      /* Termina nodo:569   */

      /* Empieza nodo:570 / Elemento padre: 547   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(570)).setAttribute("tipo","texto" );
      ((Element)v.get(570)).setAttribute("ID","EstDat2" );
      ((Element)v.get(547)).appendChild((Element)v.get(570));
      /* Termina nodo:570   */

      /* Empieza nodo:571 / Elemento padre: 547   */
   }

   private void getXML2520(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(571)).setAttribute("tipo","texto" );
      ((Element)v.get(571)).setAttribute("ID","EstDat" );
      ((Element)v.get(547)).appendChild((Element)v.get(571));
      /* Termina nodo:571   */

      /* Empieza nodo:572 / Elemento padre: 547   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(572)).setAttribute("tipo","texto" );
      ((Element)v.get(572)).setAttribute("ID","EstDat2" );
      ((Element)v.get(547)).appendChild((Element)v.get(572));
      /* Termina nodo:572   */

      /* Empieza nodo:573 / Elemento padre: 547   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(573)).setAttribute("tipo","texto" );
      ((Element)v.get(573)).setAttribute("ID","EstDat" );
      ((Element)v.get(547)).appendChild((Element)v.get(573));
      /* Termina nodo:573   */

      /* Empieza nodo:574 / Elemento padre: 547   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(574)).setAttribute("tipo","texto" );
      ((Element)v.get(574)).setAttribute("ID","EstDat2" );
      ((Element)v.get(547)).appendChild((Element)v.get(574));
      /* Termina nodo:574   */

      /* Empieza nodo:575 / Elemento padre: 547   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(575)).setAttribute("tipo","texto" );
      ((Element)v.get(575)).setAttribute("ID","EstDat" );
      ((Element)v.get(547)).appendChild((Element)v.get(575));
      /* Termina nodo:575   */

      /* Empieza nodo:576 / Elemento padre: 547   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(576)).setAttribute("tipo","texto" );
      ((Element)v.get(576)).setAttribute("ID","EstDat2" );
      ((Element)v.get(547)).appendChild((Element)v.get(576));
      /* Termina nodo:576   */

      /* Empieza nodo:577 / Elemento padre: 547   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(577)).setAttribute("tipo","texto" );
      ((Element)v.get(577)).setAttribute("ID","EstDat" );
      ((Element)v.get(547)).appendChild((Element)v.get(577));
      /* Termina nodo:577   */

      /* Empieza nodo:578 / Elemento padre: 547   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(578)).setAttribute("tipo","texto" );
      ((Element)v.get(578)).setAttribute("ID","EstDat2" );
      ((Element)v.get(547)).appendChild((Element)v.get(578));
      /* Termina nodo:578   */

      /* Empieza nodo:579 / Elemento padre: 547   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(579)).setAttribute("tipo","texto" );
      ((Element)v.get(579)).setAttribute("ID","EstDat" );
      ((Element)v.get(547)).appendChild((Element)v.get(579));
      /* Termina nodo:579   */

      /* Empieza nodo:580 / Elemento padre: 547   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(580)).setAttribute("tipo","texto" );
      ((Element)v.get(580)).setAttribute("ID","EstDat2" );
      ((Element)v.get(547)).appendChild((Element)v.get(580));
      /* Termina nodo:580   */
      /* Termina nodo:547   */

      /* Empieza nodo:581 / Elemento padre: 469   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(469)).appendChild((Element)v.get(581));
      /* Termina nodo:581   */

      /* Empieza nodo:582 / Elemento padre: 469   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(582)).setAttribute("nombre","mipgndo3" );
      ((Element)v.get(582)).setAttribute("ancho","542" );
      ((Element)v.get(582)).setAttribute("sep","$" );
      ((Element)v.get(582)).setAttribute("x","12" );
      ((Element)v.get(582)).setAttribute("class","botonera" );
      ((Element)v.get(582)).setAttribute("y","1287" );
      ((Element)v.get(582)).setAttribute("control","|" );
      ((Element)v.get(582)).setAttribute("conector","" );
      ((Element)v.get(582)).setAttribute("rowset","" );
      ((Element)v.get(582)).setAttribute("cargainicial","N" );
      ((Element)v.get(469)).appendChild((Element)v.get(582));

      /* Empieza nodo:583 / Elemento padre: 582   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(583)).setAttribute("nombre","ret3" );
      ((Element)v.get(583)).setAttribute("x","49" );
      ((Element)v.get(583)).setAttribute("y","336" );
      ((Element)v.get(583)).setAttribute("ID","botonContenido" );
      ((Element)v.get(583)).setAttribute("img","retroceder_on" );
      ((Element)v.get(583)).setAttribute("tipo","0" );
      ((Element)v.get(583)).setAttribute("estado","false" );
      ((Element)v.get(583)).setAttribute("alt","" );
      ((Element)v.get(583)).setAttribute("codigo","" );
      ((Element)v.get(583)).setAttribute("accion","mipgndo3.retroceder();" );
      ((Element)v.get(582)).appendChild((Element)v.get(583));
      /* Termina nodo:583   */

      /* Empieza nodo:584 / Elemento padre: 582   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(584)).setAttribute("nombre","ava3" );
      ((Element)v.get(584)).setAttribute("x","64" );
      ((Element)v.get(584)).setAttribute("y","336" );
      ((Element)v.get(584)).setAttribute("ID","botonContenido" );
      ((Element)v.get(584)).setAttribute("img","avanzar_on" );
      ((Element)v.get(584)).setAttribute("tipo","0" );
      ((Element)v.get(584)).setAttribute("estado","false" );
      ((Element)v.get(584)).setAttribute("alt","" );
      ((Element)v.get(584)).setAttribute("codigo","" );
      ((Element)v.get(584)).setAttribute("accion","mipgndo3.avanzar();" );
      ((Element)v.get(582)).appendChild((Element)v.get(584));
      /* Termina nodo:584   */
      /* Termina nodo:582   */
      /* Termina nodo:469   */
      /* Termina nodo:30   */


   }

}

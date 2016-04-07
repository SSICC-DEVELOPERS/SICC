
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_oferta_definir  implements es.indra.druida.base.ObjetoXML {
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
      ((Element)v.get(0)).setAttribute("nombre","contenido_oferta_definir" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("cod","0188" );
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
      ((Element)v.get(2)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","contenido_oferta_definir.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(6)).setAttribute("name","cbAcceso" );
      ((Element)v.get(6)).setAttribute("required","true" );
      ((Element)v.get(6)).setAttribute("cod","10" );
      ((Element)v.get(6)).setAttribute("group","gr" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","cbSubacceso" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","122" );
      ((Element)v.get(7)).setAttribute("group","gr" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbArgumentoVenta" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","528" );
      ((Element)v.get(8)).setAttribute("group","grgral" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","txtNGrupos" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","533" );
      ((Element)v.get(9)).setAttribute("group","grngrup" );
      ((Element)v.get(5)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","txtNPaquetes" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("cod","534" );
      ((Element)v.get(10)).setAttribute("group","grnpaq" );
      ((Element)v.get(5)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","txtNGrupCondicionantes" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("cod","535" );
      ((Element)v.get(11)).setAttribute("group","grcond" );
      ((Element)v.get(5)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","txtNGrupCondicionados" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("cod","537" );
      ((Element)v.get(12)).setAttribute("group","grcond" );
      ((Element)v.get(5)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","cbTipoCliente" );
      ((Element)v.get(13)).setAttribute("required","true" );
      ((Element)v.get(13)).setAttribute("cod","393" );
      ((Element)v.get(13)).setAttribute("group","vexcl" );
      ((Element)v.get(5)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","cbIdCuadre" );
      ((Element)v.get(14)).setAttribute("required","true" );
      ((Element)v.get(14)).setAttribute("cod","461" );
      ((Element)v.get(14)).setAttribute("group","idCuadre" );
      ((Element)v.get(5)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 5   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(15)).setAttribute("name","cbCatalogo" );
      ((Element)v.get(15)).setAttribute("required","true" );
      ((Element)v.get(15)).setAttribute("cod","516" );
      ((Element)v.get(15)).setAttribute("group","catalogo" );
      ((Element)v.get(5)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */
      /* Termina nodo:5   */

      /* Empieza nodo:16 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(16)).setAttribute("nombre","frmContenido" );
      ((Element)v.get(0)).appendChild((Element)v.get(16));

      /* Empieza nodo:17 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","accion" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 16   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(21)).setAttribute("valor","LPDefinirOferta" );
      ((Element)v.get(16)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","oidCabeceraMF" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","oidEstrategia" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","elemSelecc" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","numGrupos" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","numPaqu" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","indCuadre" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","numGrupCondtes" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","numGrupCondos" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","condCondos" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","condCondtes" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hTipoCliente" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hDesTipoCliente" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hSubtipoCliente" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hDesSubtipoCliente" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hTipoClasificacion" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hDesTipoClasificacion" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hClasificacion" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hDesClasificacion" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","hEstatusCliente" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","hDesEstatusCliente" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hEstatus2" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hArgumentoVenta" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","hFormaPago" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","hIndCuadre" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","hAcceso" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","hSubacceso" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","hAccesoDef" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","hSubaccesoDef" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","cvDespAuto" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","despAuto" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","despCompl" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","btnBPPpal" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","btnBPAsoc" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","hrbCondicionantes" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","hrbCondicionados" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","hrbDespachoCompleto" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","hrbDespachoAutomatico" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","hrbRecObligPedido" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","hrbVentaExclusiva" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","maxGrupo" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","maxGruposCondicionantes" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 16   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(63)).setAttribute("nombre","maxGruposCondicionados" );
      ((Element)v.get(63)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(64)).setAttribute("nombre","argumentoVta" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(65)).setAttribute("nombre","primeraEjecucion" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(66)).setAttribute("nombre","descCatalogo" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 16   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(67)).setAttribute("nombre","hCatalogoSel" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(16)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 16   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(68)).setAttribute("nombre","capaContenido" );
      ((Element)v.get(68)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(68)).setAttribute("borde","0" );
      ((Element)v.get(68)).setAttribute("imagenf","" );
      ((Element)v.get(68)).setAttribute("repeat","" );
      ((Element)v.get(68)).setAttribute("padding","" );
      ((Element)v.get(68)).setAttribute("visibilidad","" );
      ((Element)v.get(68)).setAttribute("contravsb","" );
      ((Element)v.get(68)).setAttribute("x","0" );
      ((Element)v.get(68)).setAttribute("y","0" );
      ((Element)v.get(68)).setAttribute("zindex","" );
      ((Element)v.get(16)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("table"));
      ((Element)v.get(69)).setAttribute("width","100%" );
      ((Element)v.get(69)).setAttribute("border","0" );
      ((Element)v.get(69)).setAttribute("cellspacing","0" );
      ((Element)v.get(69)).setAttribute("cellpadding","0" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(69)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(71)).setAttribute("width","12" );
      ((Element)v.get(71)).setAttribute("align","center" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","12" );
      ((Element)v.get(72)).setAttribute("height","12" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(73)).setAttribute("width","750" );
      ((Element)v.get(70)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 70   */
      v.add(doc.createElement("td"));
      ((Element)v.get(75)).setAttribute("width","12" );
      ((Element)v.get(70)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","12" );
      ((Element)v.get(76)).setAttribute("height","1" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:70   */

      /* Empieza nodo:77 / Elemento padre: 69   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(69)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(82)).setAttribute("class","legend" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(83)).setAttribute("nombre","lblDatos" );
      ((Element)v.get(83)).setAttribute("alto","13" );
      ((Element)v.get(83)).setAttribute("filas","1" );
      ((Element)v.get(83)).setAttribute("valor","Datos de oferta" );
      ((Element)v.get(83)).setAttribute("id","legend" );
      ((Element)v.get(83)).setAttribute("cod","00113" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 81   */
      v.add(doc.createElement("table"));
      ((Element)v.get(84)).setAttribute("width","100%" );
      ((Element)v.get(84)).setAttribute("border","0" );
      ((Element)v.get(84)).setAttribute("align","center" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(84)).setAttribute("cellspacing","0" );
      ((Element)v.get(84)).setAttribute("cellpadding","0" );
      ((Element)v.get(81)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("td"));
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("table"));
      ((Element)v.get(87)).setAttribute("width","730" );
      ((Element)v.get(87)).setAttribute("border","0" );
      ((Element)v.get(87)).setAttribute("align","left" );
      ((Element)v.get(87)).setAttribute("cellspacing","0" );
      ((Element)v.get(87)).setAttribute("cellpadding","0" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(87)).appendChild((Element)v.get(88));

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

      /* Empieza nodo:91 / Elemento padre: 87   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(87)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(93)).setAttribute("src","b.gif" );
      ((Element)v.get(93)).setAttribute("width","8" );
      ((Element)v.get(93)).setAttribute("height","8" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:94 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(95)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(95)).setAttribute("alto","13" );
      ((Element)v.get(95)).setAttribute("filas","1" );
      ((Element)v.get(95)).setAttribute("valor","" );
      ((Element)v.get(95)).setAttribute("id","datosTitle" );
      ((Element)v.get(95)).setAttribute("cod","10" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","25" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(99)).setAttribute("nombre","lblSubacceso" );
      ((Element)v.get(99)).setAttribute("alto","13" );
      ((Element)v.get(99)).setAttribute("filas","1" );
      ((Element)v.get(99)).setAttribute("valor","" );
      ((Element)v.get(99)).setAttribute("id","datosTitle" );
      ((Element)v.get(99)).setAttribute("cod","122" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:100 / Elemento padre: 91   */
      v.add(doc.createElement("td"));
      ((Element)v.get(100)).setAttribute("width","100%" );
      ((Element)v.get(91)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","8" );
      ((Element)v.get(101)).setAttribute("height","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:91   */

      /* Empieza nodo:102 / Elemento padre: 87   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(87)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","8" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(105)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(102)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(106)).setAttribute("nombre","cbAcceso" );
      ((Element)v.get(106)).setAttribute("id","datosCampos" );
      ((Element)v.get(106)).setAttribute("size","1" );
      ((Element)v.get(106)).setAttribute("multiple","N" );
      ((Element)v.get(106)).setAttribute("req","N" );
      ((Element)v.get(106)).setAttribute("valorinicial","" );
      ((Element)v.get(106)).setAttribute("textoinicial","" );
      ((Element)v.get(106)).setAttribute("onchange","accesoOnChange();" );
      ((Element)v.get(106)).setAttribute("onblur","" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(106)).setAttribute("ontab","tabGenerico('cbAcceso');" );
      ((Element)v.get(106)).setAttribute("onshtab","tabGenerico('cbAcceso','sh');" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:108 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","25" );
      ((Element)v.get(109)).setAttribute("height","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(110)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(102)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(111)).setAttribute("nombre","cbSubacceso" );
      ((Element)v.get(111)).setAttribute("id","datosCampos" );
      ((Element)v.get(111)).setAttribute("size","1" );
      ((Element)v.get(111)).setAttribute("multiple","N" );
      ((Element)v.get(111)).setAttribute("req","N" );
      ((Element)v.get(111)).setAttribute("valorinicial","" );
      ((Element)v.get(111)).setAttribute("textoinicial","" );
      ((Element)v.get(111)).setAttribute("ontab","tabGenerico('cbSubacceso');" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */

      /* Empieza nodo:113 / Elemento padre: 102   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).setAttribute("width","100%" );
      ((Element)v.get(102)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","8" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:102   */

      /* Empieza nodo:115 / Elemento padre: 87   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(87)).appendChild((Element)v.get(115));

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
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:118 / Elemento padre: 84   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(84)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("td"));
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("table"));
      ((Element)v.get(120)).setAttribute("width","730" );
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
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).setAttribute("width","8" );
      ((Element)v.get(123)).setAttribute("height","8" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(125)).setAttribute("nombre","lblCatalogo" );
      ((Element)v.get(125)).setAttribute("alto","13" );
      ((Element)v.get(125)).setAttribute("filas","1" );
      ((Element)v.get(125)).setAttribute("valor","" );
      ((Element)v.get(125)).setAttribute("id","datosTitle" );
      ((Element)v.get(125)).setAttribute("cod","516" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:126 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","25" );
      ((Element)v.get(127)).setAttribute("height","8" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:128 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(129)).setAttribute("nombre","lblArgumentoVenta" );
      ((Element)v.get(129)).setAttribute("alto","13" );
      ((Element)v.get(129)).setAttribute("filas","1" );
      ((Element)v.get(129)).setAttribute("valor","" );
      ((Element)v.get(129)).setAttribute("id","datosTitle" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(129)).setAttribute("cod","528" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 121   */
      v.add(doc.createElement("td"));
      ((Element)v.get(130)).setAttribute("width","100%" );
      ((Element)v.get(121)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(131)).setAttribute("src","b.gif" );
      ((Element)v.get(131)).setAttribute("width","8" );
      ((Element)v.get(131)).setAttribute("height","8" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:121   */

      /* Empieza nodo:132 / Elemento padre: 120   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(120)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","8" );
      ((Element)v.get(134)).setAttribute("height","8" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(132)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(136)).setAttribute("nombre","cbCatalogo" );
      ((Element)v.get(136)).setAttribute("id","datosCampos" );
      ((Element)v.get(136)).setAttribute("size","1" );
      ((Element)v.get(136)).setAttribute("multiple","N" );
      ((Element)v.get(136)).setAttribute("req","S" );
      ((Element)v.get(136)).setAttribute("valorinicial","" );
      ((Element)v.get(136)).setAttribute("textoinicial","" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:138 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(139)).setAttribute("src","b.gif" );
      ((Element)v.get(139)).setAttribute("width","25" );
      ((Element)v.get(139)).setAttribute("height","8" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:140 / Elemento padre: 132   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(140)).setAttribute("valign","bottom" );
      ((Element)v.get(132)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(141)).setAttribute("nombre","cbArgumentoVenta" );
      ((Element)v.get(141)).setAttribute("id","datosCampos" );
      ((Element)v.get(141)).setAttribute("size","1" );
      ((Element)v.get(141)).setAttribute("multiple","N" );
      ((Element)v.get(141)).setAttribute("req","N" );
      ((Element)v.get(141)).setAttribute("valorinicial","" );
      ((Element)v.get(141)).setAttribute("textoinicial","" );
      ((Element)v.get(141)).setAttribute("ontab","tabGenerico('cbArgumentoVenta');" );
      ((Element)v.get(141)).setAttribute("onshtab","tabGenerico('cbArgumentoVenta','sh');" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:132   */

      /* Empieza nodo:143 / Elemento padre: 120   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(120)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("td"));
      ((Element)v.get(144)).setAttribute("colspan","4" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).setAttribute("width","8" );
      ((Element)v.get(145)).setAttribute("height","8" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:84   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:146 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(77)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:77   */

      /* Empieza nodo:148 / Elemento padre: 69   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(69)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("td"));
      ((Element)v.get(149)).setAttribute("colspan","4" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","8" );
      ((Element)v.get(150)).setAttribute("height","497" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:151 / Elemento padre: 69   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(69)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:154 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(151)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(156)).setAttribute("class","legend" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(157)).setAttribute("nombre","lblDatosOfer" );
      ((Element)v.get(157)).setAttribute("alto","13" );
      ((Element)v.get(157)).setAttribute("filas","1" );
      ((Element)v.get(157)).setAttribute("valor","Datos de oferta" );
      ((Element)v.get(157)).setAttribute("id","legend" );
      ((Element)v.get(157)).setAttribute("cod","00113" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:158 / Elemento padre: 155   */
      v.add(doc.createElement("table"));
      ((Element)v.get(158)).setAttribute("width","100%" );
      ((Element)v.get(158)).setAttribute("border","0" );
      ((Element)v.get(158)).setAttribute("align","center" );
      ((Element)v.get(158)).setAttribute("cellspacing","0" );
      ((Element)v.get(158)).setAttribute("cellpadding","0" );
      ((Element)v.get(155)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("td"));
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("table"));
      ((Element)v.get(161)).setAttribute("width","730" );
      ((Element)v.get(161)).setAttribute("border","0" );
      ((Element)v.get(161)).setAttribute("align","left" );
      ((Element)v.get(161)).setAttribute("cellspacing","0" );
      ((Element)v.get(161)).setAttribute("cellpadding","0" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).setAttribute("colspan","4" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","8" );
      ((Element)v.get(164)).setAttribute("height","8" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:165 / Elemento padre: 161   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(161)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).setAttribute("width","8" );
      ((Element)v.get(167)).setAttribute("height","8" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:168 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(169)).setAttribute("nombre","lblNGrupos" );
      ((Element)v.get(169)).setAttribute("alto","13" );
      ((Element)v.get(169)).setAttribute("filas","1" );
      ((Element)v.get(169)).setAttribute("valor","" );
      ((Element)v.get(169)).setAttribute("id","datosTitle" );
      ((Element)v.get(169)).setAttribute("cod","533" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(171)).setAttribute("src","b.gif" );
      ((Element)v.get(171)).setAttribute("width","25" );
      ((Element)v.get(171)).setAttribute("height","8" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:172 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(173)).setAttribute("nombre","lblNPaquetes" );
      ((Element)v.get(173)).setAttribute("alto","13" );
      ((Element)v.get(173)).setAttribute("filas","1" );
      ((Element)v.get(173)).setAttribute("valor","" );
      ((Element)v.get(173)).setAttribute("id","datosTitle" );
      ((Element)v.get(173)).setAttribute("cod","534" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:174 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(175)).setAttribute("src","b.gif" );
      ((Element)v.get(175)).setAttribute("width","25" );
      ((Element)v.get(175)).setAttribute("height","8" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(177)).setAttribute("nombre","lblIdCuadre" );
      ((Element)v.get(177)).setAttribute("alto","13" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(177)).setAttribute("filas","1" );
      ((Element)v.get(177)).setAttribute("valor","" );
      ((Element)v.get(177)).setAttribute("id","datosTitle" );
      ((Element)v.get(177)).setAttribute("cod","461" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:178 / Elemento padre: 165   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).setAttribute("width","100%" );
      ((Element)v.get(165)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).setAttribute("width","8" );
      ((Element)v.get(179)).setAttribute("height","8" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */
      /* Termina nodo:165   */

      /* Empieza nodo:180 / Elemento padre: 161   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(161)).appendChild((Element)v.get(180));

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
      ((Element)v.get(183)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(180)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(184)).setAttribute("nombre","txtNGrupos" );
      ((Element)v.get(184)).setAttribute("id","datosCampos" );
      ((Element)v.get(184)).setAttribute("max","2" );
      ((Element)v.get(184)).setAttribute("tipo","" );
      ((Element)v.get(184)).setAttribute("onchange","accionNumeroGruposIntroducido();" );
      ((Element)v.get(184)).setAttribute("onblur","saleDe('txtNGrupos');" );
      ((Element)v.get(184)).setAttribute("req","N" );
      ((Element)v.get(184)).setAttribute("size","2" );
      ((Element)v.get(184)).setAttribute("valor","" );
      ((Element)v.get(184)).setAttribute("validacion","" );
      ((Element)v.get(184)).setAttribute("onshtab","tabGenerico('txtNGrupos','sh');" );
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
      ((Element)v.get(187)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(180)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(188)).setAttribute("nombre","txtNPaquetes" );
      ((Element)v.get(188)).setAttribute("id","datosCampos" );
      ((Element)v.get(188)).setAttribute("max","2" );
      ((Element)v.get(188)).setAttribute("tipo","" );
      ((Element)v.get(188)).setAttribute("onchange","" );
      ((Element)v.get(188)).setAttribute("onblur","saleDe('txtNPaquetes');" );
      ((Element)v.get(188)).setAttribute("req","N" );
      ((Element)v.get(188)).setAttribute("size","2" );
      ((Element)v.get(188)).setAttribute("valor","" );
      ((Element)v.get(188)).setAttribute("validacion","" );
      ((Element)v.get(188)).setAttribute("onshtab","tabGenerico('txtNPaquetes','sh');" );
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
      ((Element)v.get(191)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(180)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(192)).setAttribute("nombre","cbIdCuadre" );
      ((Element)v.get(192)).setAttribute("id","datosCampos" );
      ((Element)v.get(192)).setAttribute("size","1" );
      ((Element)v.get(192)).setAttribute("multiple","N" );
      ((Element)v.get(192)).setAttribute("req","N" );
      ((Element)v.get(192)).setAttribute("valorinicial","" );
      ((Element)v.get(192)).setAttribute("textoinicial","" );
      ((Element)v.get(192)).setAttribute("onshtab","tabGenerico('cbIdCuadre','sh');" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:194 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(194)).setAttribute("width","100%" );
      ((Element)v.get(180)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(195)).setAttribute("src","b.gif" );
      ((Element)v.get(195)).setAttribute("width","8" );
      ((Element)v.get(195)).setAttribute("height","8" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:180   */

      /* Empieza nodo:196 / Elemento padre: 161   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(161)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("td"));
      ((Element)v.get(197)).setAttribute("colspan","4" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).setAttribute("width","8" );
      ((Element)v.get(198)).setAttribute("height","8" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */
      /* Termina nodo:196   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:199 / Elemento padre: 158   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(158)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("td"));
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("table"));
      ((Element)v.get(201)).setAttribute("width","730" );
      ((Element)v.get(201)).setAttribute("border","0" );
      ((Element)v.get(201)).setAttribute("align","left" );
      ((Element)v.get(201)).setAttribute("cellspacing","0" );
      ((Element)v.get(201)).setAttribute("cellpadding","0" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).setAttribute("width","8" );
      ((Element)v.get(204)).setAttribute("height","8" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:205 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(206)).setAttribute("nombre","lblNGrupCondicionantes" );
      ((Element)v.get(206)).setAttribute("alto","13" );
      ((Element)v.get(206)).setAttribute("filas","1" );
      ((Element)v.get(206)).setAttribute("valor","" );
      ((Element)v.get(206)).setAttribute("id","datosTitle" );
      ((Element)v.get(206)).setAttribute("cod","535" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:207 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).setAttribute("width","25" );
      ((Element)v.get(208)).setAttribute("height","8" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:209 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(210)).setAttribute("nombre","lblCondicionantes" );
      ((Element)v.get(210)).setAttribute("alto","13" );
      ((Element)v.get(210)).setAttribute("filas","1" );
      ((Element)v.get(210)).setAttribute("valor","" );
      ((Element)v.get(210)).setAttribute("id","datosTitle" );
      ((Element)v.get(210)).setAttribute("cod","536" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */

      /* Empieza nodo:211 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(212)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).setAttribute("width","25" );
      ((Element)v.get(212)).setAttribute("height","8" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */

      /* Empieza nodo:213 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(214)).setAttribute("nombre","lblNGrupCondicionados" );
      ((Element)v.get(214)).setAttribute("alto","13" );
      ((Element)v.get(214)).setAttribute("filas","1" );
      ((Element)v.get(214)).setAttribute("valor","" );
      ((Element)v.get(214)).setAttribute("id","datosTitle" );
      ((Element)v.get(214)).setAttribute("cod","537" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(216)).setAttribute("src","b.gif" );
      ((Element)v.get(216)).setAttribute("width","25" );
      ((Element)v.get(216)).setAttribute("height","8" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:217 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(218)).setAttribute("nombre","lblCondicionados" );
      ((Element)v.get(218)).setAttribute("alto","13" );
      ((Element)v.get(218)).setAttribute("filas","1" );
      ((Element)v.get(218)).setAttribute("valor","" );
      ((Element)v.get(218)).setAttribute("id","datosTitle" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(218)).setAttribute("cod","538" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:219 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(220)).setAttribute("src","b.gif" );
      ((Element)v.get(220)).setAttribute("width","25" );
      ((Element)v.get(220)).setAttribute("height","8" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:221 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(202)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(222)).setAttribute("nombre","lblDespachoCompleto" );
      ((Element)v.get(222)).setAttribute("alto","13" );
      ((Element)v.get(222)).setAttribute("filas","1" );
      ((Element)v.get(222)).setAttribute("valor","" );
      ((Element)v.get(222)).setAttribute("id","datosTitle" );
      ((Element)v.get(222)).setAttribute("cod","539" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:223 / Elemento padre: 202   */
      v.add(doc.createElement("td"));
      ((Element)v.get(223)).setAttribute("width","100%" );
      ((Element)v.get(202)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(224)).setAttribute("src","b.gif" );
      ((Element)v.get(224)).setAttribute("width","8" );
      ((Element)v.get(224)).setAttribute("height","8" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:202   */

      /* Empieza nodo:225 / Elemento padre: 201   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(201)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).setAttribute("width","8" );
      ((Element)v.get(227)).setAttribute("height","8" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(228)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(225)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(229)).setAttribute("nombre","txtNGrupCondicionantes" );
      ((Element)v.get(229)).setAttribute("onchange","sumarYPoner();" );
      ((Element)v.get(229)).setAttribute("onblur","saledeCondiciona();" );
      ((Element)v.get(229)).setAttribute("id","datosCampos" );
      ((Element)v.get(229)).setAttribute("max","2" );
      ((Element)v.get(229)).setAttribute("tipo","" );
      ((Element)v.get(229)).setAttribute("req","N" );
      ((Element)v.get(229)).setAttribute("size","2" );
      ((Element)v.get(229)).setAttribute("valor","" );
      ((Element)v.get(229)).setAttribute("validacion","" );
      ((Element)v.get(229)).setAttribute("onshtab","tabGenerico('txtNGrupCondicionantes','sh');" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:230 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(231)).setAttribute("src","b.gif" );
      ((Element)v.get(231)).setAttribute("width","25" );
      ((Element)v.get(231)).setAttribute("height","8" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:232 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(232)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(225)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("table"));
      ((Element)v.get(233)).setAttribute("width","100%" );
      ((Element)v.get(233)).setAttribute("border","0" );
      ((Element)v.get(233)).setAttribute("cellspacing","0" );
      ((Element)v.get(233)).setAttribute("cellpadding","0" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("td"));
      ((Element)v.get(235)).setAttribute("class","datosCampos" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(236)).setAttribute("nombre","rbCondicionantes" );
      ((Element)v.get(236)).setAttribute("tipo","H" );
      ((Element)v.get(236)).setAttribute("id","datosCampos" );
      ((Element)v.get(236)).setAttribute("onshtab","tabGenerico('rbCondicionantes','sh');" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(237)).setAttribute("valor","S" );
      ((Element)v.get(237)).setAttribute("check","N" );
      ((Element)v.get(237)).setAttribute("onfocus","" );
      ((Element)v.get(237)).setAttribute("id","datosCampos" );
      ((Element)v.get(237)).setAttribute("cod","1310" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Elemento padre:237 / Elemento actual: 238   */
      v.add(doc.createTextNode("Y"));
      ((Element)v.get(237)).appendChild((Text)v.get(238));

      /* Termina nodo Texto:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 236   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(239)).setAttribute("valor","N" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(239)).setAttribute("check","N" );
      ((Element)v.get(239)).setAttribute("onfocus","" );
      ((Element)v.get(239)).setAttribute("id","datosCampos" );
      ((Element)v.get(239)).setAttribute("cod","1311" );
      ((Element)v.get(236)).appendChild((Element)v.get(239));

      /* Elemento padre:239 / Elemento actual: 240   */
      v.add(doc.createTextNode("O"));
      ((Element)v.get(239)).appendChild((Text)v.get(240));

      /* Termina nodo Texto:240   */
      /* Termina nodo:239   */
      /* Termina nodo:236   */
      /* Termina nodo:235   */
      /* Termina nodo:234   */
      /* Termina nodo:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:241 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(242)).setAttribute("src","b.gif" );
      ((Element)v.get(242)).setAttribute("width","25" );
      ((Element)v.get(242)).setAttribute("height","8" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:243 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(243)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(225)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(244)).setAttribute("nombre","txtNGrupCondicionados" );
      ((Element)v.get(244)).setAttribute("onchange","sumarYPoner();" );
      ((Element)v.get(244)).setAttribute("onblur","saledeCondiciona();" );
      ((Element)v.get(244)).setAttribute("id","datosCampos" );
      ((Element)v.get(244)).setAttribute("max","2" );
      ((Element)v.get(244)).setAttribute("tipo","" );
      ((Element)v.get(244)).setAttribute("req","N" );
      ((Element)v.get(244)).setAttribute("size","2" );
      ((Element)v.get(244)).setAttribute("valor","" );
      ((Element)v.get(244)).setAttribute("validacion","" );
      ((Element)v.get(244)).setAttribute("onshtab","tabGenerico('txtNGrupCondicionados','sh');" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:245 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(246)).setAttribute("src","b.gif" );
      ((Element)v.get(246)).setAttribute("width","25" );
      ((Element)v.get(246)).setAttribute("height","8" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:247 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(247)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(225)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("table"));
      ((Element)v.get(248)).setAttribute("width","100%" );
      ((Element)v.get(248)).setAttribute("border","0" );
      ((Element)v.get(248)).setAttribute("cellspacing","0" );
      ((Element)v.get(248)).setAttribute("cellpadding","0" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(248)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("td"));
      ((Element)v.get(250)).setAttribute("class","datosCampos" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(251)).setAttribute("nombre","rbCondicionados" );
      ((Element)v.get(251)).setAttribute("tipo","H" );
      ((Element)v.get(251)).setAttribute("id","datosCampos" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(252)).setAttribute("valor","S" );
      ((Element)v.get(252)).setAttribute("check","N" );
      ((Element)v.get(252)).setAttribute("onfocus","" );
      ((Element)v.get(252)).setAttribute("id","datosCampos" );
      ((Element)v.get(252)).setAttribute("cod","1310" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));

      /* Elemento padre:252 / Elemento actual: 253   */
      v.add(doc.createTextNode("Y"));
      ((Element)v.get(252)).appendChild((Text)v.get(253));

      /* Termina nodo Texto:253   */
      /* Termina nodo:252   */

      /* Empieza nodo:254 / Elemento padre: 251   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(254)).setAttribute("valor","N" );
      ((Element)v.get(254)).setAttribute("check","N" );
      ((Element)v.get(254)).setAttribute("onfocus","" );
      ((Element)v.get(254)).setAttribute("id","datosCampos" );
      ((Element)v.get(254)).setAttribute("cod","1311" );
      ((Element)v.get(251)).appendChild((Element)v.get(254));

      /* Elemento padre:254 / Elemento actual: 255   */
      v.add(doc.createTextNode("O"));
      ((Element)v.get(254)).appendChild((Text)v.get(255));

      /* Termina nodo Texto:255   */
      /* Termina nodo:254   */
      /* Termina nodo:251   */
      /* Termina nodo:250   */
      /* Termina nodo:249   */
      /* Termina nodo:248   */
      /* Termina nodo:247   */

      /* Empieza nodo:256 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(257)).setAttribute("src","b.gif" );
      ((Element)v.get(257)).setAttribute("width","25" );
      ((Element)v.get(257)).setAttribute("height","8" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */

      /* Empieza nodo:258 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(225)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(259)).setAttribute("nombre","ckDespachoCompleto" );
      ((Element)v.get(259)).setAttribute("texto","" );
      ((Element)v.get(259)).setAttribute("check","N" );
      ((Element)v.get(259)).setAttribute("validacion","" );
      ((Element)v.get(259)).setAttribute("req","N" );
      ((Element)v.get(259)).setAttribute("id","datosCampos" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(259)).setAttribute("onshtab","tabGenerico('ckDespachoCompleto','sh');" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:260 / Elemento padre: 225   */
      v.add(doc.createElement("td"));
      ((Element)v.get(260)).setAttribute("width","100%" );
      ((Element)v.get(225)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(261)).setAttribute("src","b.gif" );
      ((Element)v.get(261)).setAttribute("width","8" );
      ((Element)v.get(261)).setAttribute("height","8" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */
      /* Termina nodo:225   */

      /* Empieza nodo:262 / Elemento padre: 201   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(201)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("td"));
      ((Element)v.get(263)).setAttribute("colspan","4" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(264)).setAttribute("src","b.gif" );
      ((Element)v.get(264)).setAttribute("width","8" );
      ((Element)v.get(264)).setAttribute("height","8" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */
      /* Termina nodo:262   */
      /* Termina nodo:201   */
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:265 / Elemento padre: 158   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(158)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("table"));
      ((Element)v.get(267)).setAttribute("width","730" );
      ((Element)v.get(267)).setAttribute("border","0" );
      ((Element)v.get(267)).setAttribute("align","left" );
      ((Element)v.get(267)).setAttribute("cellspacing","0" );
      ((Element)v.get(267)).setAttribute("cellpadding","0" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(267)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("td"));
      ((Element)v.get(268)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(270)).setAttribute("src","b.gif" );
      ((Element)v.get(270)).setAttribute("width","8" );
      ((Element)v.get(270)).setAttribute("height","8" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:269   */

      /* Empieza nodo:271 / Elemento padre: 268   */
      v.add(doc.createElement("td"));
      ((Element)v.get(268)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(272)).setAttribute("nombre","lblDespachoAutomatico" );
      ((Element)v.get(272)).setAttribute("alto","13" );
      ((Element)v.get(272)).setAttribute("filas","1" );
      ((Element)v.get(272)).setAttribute("valor","" );
      ((Element)v.get(272)).setAttribute("id","datosTitle" );
      ((Element)v.get(272)).setAttribute("cod","540" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:271   */

      /* Empieza nodo:273 / Elemento padre: 268   */
      v.add(doc.createElement("td"));
      ((Element)v.get(268)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(274)).setAttribute("src","b.gif" );
      ((Element)v.get(274)).setAttribute("width","25" );
      ((Element)v.get(274)).setAttribute("height","8" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */

      /* Empieza nodo:275 / Elemento padre: 268   */
      v.add(doc.createElement("td"));
      ((Element)v.get(268)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(276)).setAttribute("nombre","lblRecObligPedido" );
      ((Element)v.get(276)).setAttribute("alto","13" );
      ((Element)v.get(276)).setAttribute("filas","1" );
      ((Element)v.get(276)).setAttribute("valor","" );
      ((Element)v.get(276)).setAttribute("id","datosTitle" );
      ((Element)v.get(276)).setAttribute("cod","601" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:277 / Elemento padre: 268   */
      v.add(doc.createElement("td"));
      ((Element)v.get(268)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(278)).setAttribute("src","b.gif" );
      ((Element)v.get(278)).setAttribute("width","25" );
      ((Element)v.get(278)).setAttribute("height","8" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:279 / Elemento padre: 268   */
      v.add(doc.createElement("td"));
      ((Element)v.get(268)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(280)).setAttribute("nombre","lblFormaPago" );
      ((Element)v.get(280)).setAttribute("alto","13" );
      ((Element)v.get(280)).setAttribute("filas","1" );
      ((Element)v.get(280)).setAttribute("valor","" );
      ((Element)v.get(280)).setAttribute("id","datosTitle" );
      ((Element)v.get(280)).setAttribute("cod","541" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */

      /* Empieza nodo:281 / Elemento padre: 268   */
      v.add(doc.createElement("td"));
      ((Element)v.get(281)).setAttribute("width","100%" );
      ((Element)v.get(268)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(282)).setAttribute("src","b.gif" );
      ((Element)v.get(282)).setAttribute("width","8" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(282)).setAttribute("height","8" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */
      /* Termina nodo:268   */

      /* Empieza nodo:283 / Elemento padre: 267   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(267)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("td"));
      ((Element)v.get(283)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(285)).setAttribute("src","b.gif" );
      ((Element)v.get(285)).setAttribute("width","8" );
      ((Element)v.get(285)).setAttribute("height","8" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */

      /* Empieza nodo:286 / Elemento padre: 283   */
      v.add(doc.createElement("td"));
      ((Element)v.get(283)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(287)).setAttribute("nombre","ckDespachoAutomatico" );
      ((Element)v.get(287)).setAttribute("texto","" );
      ((Element)v.get(287)).setAttribute("check","N" );
      ((Element)v.get(287)).setAttribute("validacion","" );
      ((Element)v.get(287)).setAttribute("req","N" );
      ((Element)v.get(287)).setAttribute("id","datosCampos" );
      ((Element)v.get(287)).setAttribute("onshtab","tabGenerico('ckDespachoAutomatico','sh');" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:286   */

      /* Empieza nodo:288 / Elemento padre: 283   */
      v.add(doc.createElement("td"));
      ((Element)v.get(283)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(289)).setAttribute("src","b.gif" );
      ((Element)v.get(289)).setAttribute("width","25" );
      ((Element)v.get(289)).setAttribute("height","8" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:288   */

      /* Empieza nodo:290 / Elemento padre: 283   */
      v.add(doc.createElement("td"));
      ((Element)v.get(283)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(291)).setAttribute("nombre","ckRecObligPedido" );
      ((Element)v.get(291)).setAttribute("texto","" );
      ((Element)v.get(291)).setAttribute("check","N" );
      ((Element)v.get(291)).setAttribute("validacion","" );
      ((Element)v.get(291)).setAttribute("req","N" );
      ((Element)v.get(291)).setAttribute("id","datosCampos" );
      ((Element)v.get(291)).setAttribute("ontab","tabGenerico('ckRecObligPedido','tab');" );
      ((Element)v.get(291)).setAttribute("onshtab","tabGenerico('ckRecObligPedido','sh');" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */

      /* Empieza nodo:292 / Elemento padre: 283   */
      v.add(doc.createElement("td"));
      ((Element)v.get(283)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(293)).setAttribute("src","b.gif" );
      ((Element)v.get(293)).setAttribute("width","25" );
      ((Element)v.get(293)).setAttribute("height","8" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:294 / Elemento padre: 283   */
      v.add(doc.createElement("td"));
      ((Element)v.get(294)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(283)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(295)).setAttribute("nombre","cbFormaPago" );
      ((Element)v.get(295)).setAttribute("id","datosCampos" );
      ((Element)v.get(295)).setAttribute("size","1" );
      ((Element)v.get(295)).setAttribute("multiple","N" );
      ((Element)v.get(295)).setAttribute("req","N" );
      ((Element)v.get(295)).setAttribute("valorinicial","" );
      ((Element)v.get(295)).setAttribute("textoinicial","" );
      ((Element)v.get(295)).setAttribute("onshtab","tabGenerico('cbFormaPago','sh');" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */
      /* Termina nodo:294   */

      /* Empieza nodo:297 / Elemento padre: 283   */
      v.add(doc.createElement("td"));
      ((Element)v.get(297)).setAttribute("width","100%" );
      ((Element)v.get(283)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(298)).setAttribute("src","b.gif" );
      ((Element)v.get(298)).setAttribute("width","8" );
      ((Element)v.get(298)).setAttribute("height","8" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */
      /* Termina nodo:283   */

      /* Empieza nodo:299 / Elemento padre: 267   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(267)).appendChild((Element)v.get(299));

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
      /* Termina nodo:267   */
      /* Termina nodo:266   */
      /* Termina nodo:265   */
      /* Termina nodo:158   */
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:302 / Elemento padre: 151   */
      v.add(doc.createElement("td"));
      ((Element)v.get(151)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(303)).setAttribute("src","b.gif" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:302   */
      /* Termina nodo:151   */

      /* Empieza nodo:304 / Elemento padre: 69   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(69)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("td"));
      ((Element)v.get(305)).setAttribute("colspan","4" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(304)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(306)).setAttribute("src","b.gif" );
      ((Element)v.get(306)).setAttribute("width","8" );
      ((Element)v.get(306)).setAttribute("height","15" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */
      /* Termina nodo:304   */

      /* Empieza nodo:307 / Elemento padre: 69   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(69)).appendChild((Element)v.get(307));

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
      ((Element)v.get(313)).setAttribute("nombre","lblDatosCliente" );
      ((Element)v.get(313)).setAttribute("alto","13" );
      ((Element)v.get(313)).setAttribute("filas","1" );
      ((Element)v.get(313)).setAttribute("valor","Datos Búsqueda" );
      ((Element)v.get(313)).setAttribute("id","legend" );
      ((Element)v.get(313)).setAttribute("cod","0091" );
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
      ((Element)v.get(317)).setAttribute("width","730" );
      ((Element)v.get(317)).setAttribute("border","0" );
      ((Element)v.get(317)).setAttribute("align","left" );
      ((Element)v.get(317)).setAttribute("cellspacing","0" );
      ((Element)v.get(317)).setAttribute("cellpadding","0" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(317)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
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
      ((Element)v.get(325)).setAttribute("nombre","lblVentaExclusiva" );
      ((Element)v.get(325)).setAttribute("alto","13" );
      ((Element)v.get(325)).setAttribute("filas","1" );
      ((Element)v.get(325)).setAttribute("valor","" );
      ((Element)v.get(325)).setAttribute("id","datosTitle" );
      ((Element)v.get(325)).setAttribute("cod","548" );
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
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(330)).setAttribute("height","8" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:331 / Elemento padre: 328   */
      v.add(doc.createElement("td"));
      ((Element)v.get(328)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(332)).setAttribute("nombre","ckVentaExclusiva" );
      ((Element)v.get(332)).setAttribute("texto","" );
      ((Element)v.get(332)).setAttribute("check","N" );
      ((Element)v.get(332)).setAttribute("validacion","" );
      ((Element)v.get(332)).setAttribute("req","N" );
      ((Element)v.get(332)).setAttribute("id","datosCampos" );
      ((Element)v.get(332)).setAttribute("onclick","cambioVentaExclusiva();" );
      ((Element)v.get(332)).setAttribute("ontab","tabGenerico('ckVentaExclusiva','tab');" );
      ((Element)v.get(332)).setAttribute("onshtab","tabGenerico('ckVentaExclusiva','sh');" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:331   */

      /* Empieza nodo:333 / Elemento padre: 328   */
      v.add(doc.createElement("td"));
      ((Element)v.get(333)).setAttribute("width","100%" );
      ((Element)v.get(328)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(334)).setAttribute("src","b.gif" );
      ((Element)v.get(334)).setAttribute("width","8" );
      ((Element)v.get(334)).setAttribute("height","8" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */
      /* Termina nodo:328   */

      /* Empieza nodo:335 / Elemento padre: 317   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(317)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("td"));
      ((Element)v.get(336)).setAttribute("colspan","4" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(337)).setAttribute("src","b.gif" );
      ((Element)v.get(337)).setAttribute("width","8" );
      ((Element)v.get(337)).setAttribute("height","8" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */
      /* Termina nodo:336   */
      /* Termina nodo:335   */
      /* Termina nodo:317   */
      /* Termina nodo:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:338 / Elemento padre: 314   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(314)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("td"));
      ((Element)v.get(338)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("table"));
      ((Element)v.get(340)).setAttribute("width","730" );
      ((Element)v.get(340)).setAttribute("border","0" );
      ((Element)v.get(340)).setAttribute("align","left" );
      ((Element)v.get(340)).setAttribute("cellspacing","0" );
      ((Element)v.get(340)).setAttribute("cellpadding","0" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(340)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(343)).setAttribute("src","b.gif" );
      ((Element)v.get(343)).setAttribute("width","8" );
      ((Element)v.get(343)).setAttribute("height","8" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */
      /* Termina nodo:342   */

      /* Empieza nodo:344 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(345)).setAttribute("nombre","lblTipoCliente" );
      ((Element)v.get(345)).setAttribute("alto","13" );
      ((Element)v.get(345)).setAttribute("filas","1" );
      ((Element)v.get(345)).setAttribute("valor","" );
      ((Element)v.get(345)).setAttribute("id","datosTitle" );
      ((Element)v.get(345)).setAttribute("cod","393" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */
      /* Termina nodo:344   */

      /* Empieza nodo:346 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(347)).setAttribute("src","b.gif" );
      ((Element)v.get(347)).setAttribute("width","25" );
      ((Element)v.get(347)).setAttribute("height","8" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */
      /* Termina nodo:346   */

      /* Empieza nodo:348 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(349)).setAttribute("nombre","lblSubtipoCliente" );
      ((Element)v.get(349)).setAttribute("alto","13" );
      ((Element)v.get(349)).setAttribute("filas","1" );
      ((Element)v.get(349)).setAttribute("valor","" );
      ((Element)v.get(349)).setAttribute("id","datosTitle" );
      ((Element)v.get(349)).setAttribute("cod","595" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */
      /* Termina nodo:348   */

      /* Empieza nodo:350 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(350)).setAttribute("width","100%" );
      ((Element)v.get(341)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(351)).setAttribute("src","b.gif" );
      ((Element)v.get(351)).setAttribute("width","8" );
      ((Element)v.get(351)).setAttribute("height","8" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */
      /* Termina nodo:350   */
      /* Termina nodo:341   */

      /* Empieza nodo:352 / Elemento padre: 340   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(340)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
   }

   private void getXML1440(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(352)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(354)).setAttribute("src","b.gif" );
      ((Element)v.get(354)).setAttribute("width","8" );
      ((Element)v.get(354)).setAttribute("height","8" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */
      /* Termina nodo:353   */

      /* Empieza nodo:355 / Elemento padre: 352   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(352)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(356)).setAttribute("nombre","cbTipoCliente" );
      ((Element)v.get(356)).setAttribute("id","datosCampos" );
      ((Element)v.get(356)).setAttribute("size","1" );
      ((Element)v.get(356)).setAttribute("multiple","N" );
      ((Element)v.get(356)).setAttribute("req","N" );
      ((Element)v.get(356)).setAttribute("valorinicial","" );
      ((Element)v.get(356)).setAttribute("textoinicial","" );
      ((Element)v.get(356)).setAttribute("onchange","tipoClienteOnChange();" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */
      /* Termina nodo:355   */

      /* Empieza nodo:358 / Elemento padre: 352   */
      v.add(doc.createElement("td"));
      ((Element)v.get(352)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(359)).setAttribute("src","b.gif" );
      ((Element)v.get(359)).setAttribute("width","25" );
      ((Element)v.get(359)).setAttribute("height","8" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */
      /* Termina nodo:358   */

      /* Empieza nodo:360 / Elemento padre: 352   */
      v.add(doc.createElement("td"));
      ((Element)v.get(360)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(352)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(361)).setAttribute("nombre","cbSubtipoCliente" );
      ((Element)v.get(361)).setAttribute("id","datosCampos" );
      ((Element)v.get(361)).setAttribute("size","1" );
      ((Element)v.get(361)).setAttribute("multiple","N" );
      ((Element)v.get(361)).setAttribute("req","N" );
      ((Element)v.get(361)).setAttribute("valorinicial","" );
      ((Element)v.get(361)).setAttribute("textoinicial","" );
      ((Element)v.get(361)).setAttribute("onchange","subtipoClienteOnChange();" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:361   */
      /* Termina nodo:360   */

      /* Empieza nodo:363 / Elemento padre: 352   */
      v.add(doc.createElement("td"));
      ((Element)v.get(363)).setAttribute("width","100%" );
      ((Element)v.get(352)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(364)).setAttribute("src","b.gif" );
      ((Element)v.get(364)).setAttribute("width","8" );
      ((Element)v.get(364)).setAttribute("height","8" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */
      /* Termina nodo:363   */
      /* Termina nodo:352   */

      /* Empieza nodo:365 / Elemento padre: 340   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(340)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("td"));
      ((Element)v.get(366)).setAttribute("colspan","4" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(367)).setAttribute("src","b.gif" );
      ((Element)v.get(367)).setAttribute("width","8" );
      ((Element)v.get(367)).setAttribute("height","8" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */
      /* Termina nodo:366   */
      /* Termina nodo:365   */
      /* Termina nodo:340   */
      /* Termina nodo:339   */
      /* Termina nodo:338   */

      /* Empieza nodo:368 / Elemento padre: 314   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(314)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("td"));
      ((Element)v.get(368)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("table"));
      ((Element)v.get(370)).setAttribute("width","730" );
      ((Element)v.get(370)).setAttribute("border","0" );
      ((Element)v.get(370)).setAttribute("align","left" );
      ((Element)v.get(370)).setAttribute("cellspacing","0" );
      ((Element)v.get(370)).setAttribute("cellpadding","0" );
      ((Element)v.get(369)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(370)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("td"));
      ((Element)v.get(371)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(373)).setAttribute("src","b.gif" );
      ((Element)v.get(373)).setAttribute("width","8" );
      ((Element)v.get(373)).setAttribute("height","8" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */
      /* Termina nodo:372   */

      /* Empieza nodo:374 / Elemento padre: 371   */
      v.add(doc.createElement("td"));
      ((Element)v.get(371)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(375)).setAttribute("nombre","lblTipoClasificacion" );
      ((Element)v.get(375)).setAttribute("alto","13" );
      ((Element)v.get(375)).setAttribute("filas","1" );
      ((Element)v.get(375)).setAttribute("valor","" );
      ((Element)v.get(375)).setAttribute("id","datosTitle" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(375)).setAttribute("cod","610" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */
      /* Termina nodo:374   */

      /* Empieza nodo:376 / Elemento padre: 371   */
      v.add(doc.createElement("td"));
      ((Element)v.get(371)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(377)).setAttribute("src","b.gif" );
      ((Element)v.get(377)).setAttribute("width","25" );
      ((Element)v.get(377)).setAttribute("height","8" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */
      /* Termina nodo:376   */

      /* Empieza nodo:378 / Elemento padre: 371   */
      v.add(doc.createElement("td"));
      ((Element)v.get(371)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(379)).setAttribute("nombre","lblClasificacion" );
      ((Element)v.get(379)).setAttribute("alto","13" );
      ((Element)v.get(379)).setAttribute("filas","1" );
      ((Element)v.get(379)).setAttribute("valor","" );
      ((Element)v.get(379)).setAttribute("id","datosTitle" );
      ((Element)v.get(379)).setAttribute("cod","550" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */
      /* Termina nodo:378   */

      /* Empieza nodo:380 / Elemento padre: 371   */
      v.add(doc.createElement("td"));
      ((Element)v.get(380)).setAttribute("width","100%" );
      ((Element)v.get(371)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(381)).setAttribute("src","b.gif" );
      ((Element)v.get(381)).setAttribute("width","8" );
      ((Element)v.get(381)).setAttribute("height","8" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */
      /* Termina nodo:380   */
      /* Termina nodo:371   */

      /* Empieza nodo:382 / Elemento padre: 370   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(370)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("td"));
      ((Element)v.get(382)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(384)).setAttribute("src","b.gif" );
      ((Element)v.get(384)).setAttribute("width","8" );
      ((Element)v.get(384)).setAttribute("height","8" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */
      /* Termina nodo:383   */

      /* Empieza nodo:385 / Elemento padre: 382   */
      v.add(doc.createElement("td"));
      ((Element)v.get(385)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(382)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(386)).setAttribute("nombre","cbTipoClasificacion" );
      ((Element)v.get(386)).setAttribute("id","datosCampos" );
      ((Element)v.get(386)).setAttribute("size","1" );
      ((Element)v.get(386)).setAttribute("multiple","N" );
      ((Element)v.get(386)).setAttribute("req","N" );
      ((Element)v.get(386)).setAttribute("valorinicial","" );
      ((Element)v.get(386)).setAttribute("textoinicial","" );
      ((Element)v.get(386)).setAttribute("onchange","tipoClasificacionOnChange();" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(386)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */
      /* Termina nodo:386   */
      /* Termina nodo:385   */

      /* Empieza nodo:388 / Elemento padre: 382   */
      v.add(doc.createElement("td"));
      ((Element)v.get(382)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(389)).setAttribute("src","b.gif" );
      ((Element)v.get(389)).setAttribute("width","25" );
      ((Element)v.get(389)).setAttribute("height","8" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:388   */

      /* Empieza nodo:390 / Elemento padre: 382   */
      v.add(doc.createElement("td"));
      ((Element)v.get(390)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(382)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(391)).setAttribute("nombre","cbClasificacion" );
      ((Element)v.get(391)).setAttribute("id","datosCampos" );
      ((Element)v.get(391)).setAttribute("size","1" );
      ((Element)v.get(391)).setAttribute("multiple","N" );
      ((Element)v.get(391)).setAttribute("req","N" );
      ((Element)v.get(391)).setAttribute("valorinicial","" );
      ((Element)v.get(391)).setAttribute("textoinicial","" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(391)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */
      /* Termina nodo:391   */
      /* Termina nodo:390   */

      /* Empieza nodo:393 / Elemento padre: 382   */
      v.add(doc.createElement("td"));
      ((Element)v.get(393)).setAttribute("width","100%" );
      ((Element)v.get(382)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(394)).setAttribute("src","b.gif" );
      ((Element)v.get(394)).setAttribute("width","8" );
      ((Element)v.get(394)).setAttribute("height","8" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */
      /* Termina nodo:393   */
      /* Termina nodo:382   */

      /* Empieza nodo:395 / Elemento padre: 370   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(370)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("td"));
      ((Element)v.get(396)).setAttribute("colspan","4" );
      ((Element)v.get(395)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(397)).setAttribute("src","b.gif" );
      ((Element)v.get(397)).setAttribute("width","8" );
      ((Element)v.get(397)).setAttribute("height","8" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */
      /* Termina nodo:396   */
      /* Termina nodo:395   */
      /* Termina nodo:370   */
      /* Termina nodo:369   */
      /* Termina nodo:368   */

      /* Empieza nodo:398 / Elemento padre: 314   */
   }

   private void getXML1620(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(314)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("td"));
      ((Element)v.get(398)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("table"));
      ((Element)v.get(400)).setAttribute("width","730" );
      ((Element)v.get(400)).setAttribute("border","0" );
      ((Element)v.get(400)).setAttribute("align","left" );
      ((Element)v.get(400)).setAttribute("cellspacing","0" );
      ((Element)v.get(400)).setAttribute("cellpadding","0" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(400)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("td"));
      ((Element)v.get(401)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(403)).setAttribute("src","b.gif" );
      ((Element)v.get(403)).setAttribute("width","8" );
      ((Element)v.get(403)).setAttribute("height","8" );
      ((Element)v.get(402)).appendChild((Element)v.get(403));
      /* Termina nodo:403   */
      /* Termina nodo:402   */

      /* Empieza nodo:404 / Elemento padre: 401   */
      v.add(doc.createElement("td"));
      ((Element)v.get(401)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(405)).setAttribute("nombre","lblEstatusCliente" );
      ((Element)v.get(405)).setAttribute("alto","13" );
      ((Element)v.get(405)).setAttribute("filas","1" );
      ((Element)v.get(405)).setAttribute("valor","" );
      ((Element)v.get(405)).setAttribute("id","datosTitle" );
      ((Element)v.get(405)).setAttribute("cod","612" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */
      /* Termina nodo:404   */

      /* Empieza nodo:406 / Elemento padre: 401   */
      v.add(doc.createElement("td"));
      ((Element)v.get(401)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(407)).setAttribute("src","b.gif" );
      ((Element)v.get(407)).setAttribute("width","25" );
      ((Element)v.get(407)).setAttribute("height","8" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */
      /* Termina nodo:406   */

      /* Empieza nodo:408 / Elemento padre: 401   */
      v.add(doc.createElement("td"));
      ((Element)v.get(401)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(409)).setAttribute("nombre","lblEstatus2" );
      ((Element)v.get(409)).setAttribute("alto","13" );
      ((Element)v.get(409)).setAttribute("filas","1" );
      ((Element)v.get(409)).setAttribute("valor","" );
      ((Element)v.get(409)).setAttribute("id","datosTitle" );
      ((Element)v.get(409)).setAttribute("cod","552" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));
      /* Termina nodo:409   */
      /* Termina nodo:408   */

      /* Empieza nodo:410 / Elemento padre: 401   */
      v.add(doc.createElement("td"));
      ((Element)v.get(410)).setAttribute("width","100%" );
      ((Element)v.get(401)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(411)).setAttribute("src","b.gif" );
      ((Element)v.get(411)).setAttribute("width","8" );
      ((Element)v.get(411)).setAttribute("height","8" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */
      /* Termina nodo:410   */
      /* Termina nodo:401   */

      /* Empieza nodo:412 / Elemento padre: 400   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(400)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("td"));
      ((Element)v.get(412)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(414)).setAttribute("src","b.gif" );
      ((Element)v.get(414)).setAttribute("width","8" );
      ((Element)v.get(414)).setAttribute("height","8" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */
      /* Termina nodo:413   */

      /* Empieza nodo:415 / Elemento padre: 412   */
      v.add(doc.createElement("td"));
      ((Element)v.get(415)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(412)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(416)).setAttribute("nombre","cbEstatusCliente" );
      ((Element)v.get(416)).setAttribute("id","datosCampos" );
      ((Element)v.get(416)).setAttribute("size","1" );
      ((Element)v.get(416)).setAttribute("multiple","N" );
      ((Element)v.get(416)).setAttribute("req","N" );
      ((Element)v.get(416)).setAttribute("valorinicial","" );
      ((Element)v.get(416)).setAttribute("textoinicial","" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));

      /* Empieza nodo:417 / Elemento padre: 416   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(416)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */
      /* Termina nodo:416   */
      /* Termina nodo:415   */

      /* Empieza nodo:418 / Elemento padre: 412   */
      v.add(doc.createElement("td"));
      ((Element)v.get(412)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(419)).setAttribute("src","b.gif" );
      ((Element)v.get(419)).setAttribute("width","25" );
      ((Element)v.get(419)).setAttribute("height","8" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */
      /* Termina nodo:418   */

      /* Empieza nodo:420 / Elemento padre: 412   */
      v.add(doc.createElement("td"));
      ((Element)v.get(420)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(412)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(421)).setAttribute("nombre","txtEstatus2" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(421)).setAttribute("id","datosCampos" );
      ((Element)v.get(421)).setAttribute("size","2" );
      ((Element)v.get(421)).setAttribute("max","1" );
      ((Element)v.get(421)).setAttribute("valor","" );
      ((Element)v.get(421)).setAttribute("req","N" );
      ((Element)v.get(421)).setAttribute("ontab","tabGenerico('txtEstatus2','tab');" );
      ((Element)v.get(420)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */
      /* Termina nodo:420   */

      /* Empieza nodo:422 / Elemento padre: 412   */
      v.add(doc.createElement("td"));
      ((Element)v.get(422)).setAttribute("width","100%" );
      ((Element)v.get(412)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(423)).setAttribute("src","b.gif" );
      ((Element)v.get(423)).setAttribute("width","8" );
      ((Element)v.get(423)).setAttribute("height","8" );
      ((Element)v.get(422)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */
      /* Termina nodo:422   */
      /* Termina nodo:412   */

      /* Empieza nodo:424 / Elemento padre: 400   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(400)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("td"));
      ((Element)v.get(425)).setAttribute("colspan","4" );
      ((Element)v.get(424)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(426)).setAttribute("src","b.gif" );
      ((Element)v.get(426)).setAttribute("width","8" );
      ((Element)v.get(426)).setAttribute("height","8" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));
      /* Termina nodo:426   */
      /* Termina nodo:425   */
      /* Termina nodo:424   */
      /* Termina nodo:400   */
      /* Termina nodo:399   */
      /* Termina nodo:398   */
      /* Termina nodo:314   */
      /* Termina nodo:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:427 / Elemento padre: 307   */
      v.add(doc.createElement("td"));
      ((Element)v.get(307)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(428)).setAttribute("src","b.gif" );
      ((Element)v.get(427)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */
      /* Termina nodo:427   */
      /* Termina nodo:307   */

      /* Empieza nodo:429 / Elemento padre: 69   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(69)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("td"));
      ((Element)v.get(429)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(431)).setAttribute("src","b.gif" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */
      /* Termina nodo:430   */

      /* Empieza nodo:432 / Elemento padre: 429   */
      v.add(doc.createElement("td"));
      ((Element)v.get(429)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(432)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("table"));
      ((Element)v.get(434)).setAttribute("width","100%" );
      ((Element)v.get(434)).setAttribute("border","0" );
      ((Element)v.get(434)).setAttribute("align","center" );
      ((Element)v.get(434)).setAttribute("cellspacing","0" );
      ((Element)v.get(434)).setAttribute("cellpadding","0" );
      ((Element)v.get(433)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(434)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("td"));
      ((Element)v.get(436)).setAttribute("class","botonera" );
      ((Element)v.get(435)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(437)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(437)).setAttribute("ID","botonContenido" );
      ((Element)v.get(437)).setAttribute("tipo","html" );
      ((Element)v.get(437)).setAttribute("accion","accionAniadirVentaExclusiva();" );
      ((Element)v.get(437)).setAttribute("estado","false" );
      ((Element)v.get(437)).setAttribute("cod","404" );
      ((Element)v.get(437)).setAttribute("ontab","tabGenerico('btnAnadir','tab');" );
      ((Element)v.get(437)).setAttribute("onshtab","tabGenerico('btnAnadir','sh');" );
      ((Element)v.get(436)).appendChild((Element)v.get(437));
      /* Termina nodo:437   */
      /* Termina nodo:436   */
      /* Termina nodo:435   */
      /* Termina nodo:434   */
      /* Termina nodo:433   */
      /* Termina nodo:432   */

      /* Empieza nodo:438 / Elemento padre: 429   */
      v.add(doc.createElement("td"));
      ((Element)v.get(429)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(439)).setAttribute("src","b.gif" );
      ((Element)v.get(439)).setAttribute("width","8" );
      ((Element)v.get(439)).setAttribute("height","12" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */
      /* Termina nodo:438   */
      /* Termina nodo:429   */

      /* Empieza nodo:440 / Elemento padre: 69   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(69)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("td"));
      ((Element)v.get(441)).setAttribute("width","12" );
      ((Element)v.get(441)).setAttribute("align","center" );
      ((Element)v.get(440)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(442)).setAttribute("src","b.gif" );
      ((Element)v.get(442)).setAttribute("width","12" );
      ((Element)v.get(442)).setAttribute("height","12" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */
      /* Termina nodo:441   */

      /* Empieza nodo:443 / Elemento padre: 440   */
      v.add(doc.createElement("td"));
      ((Element)v.get(443)).setAttribute("width","750" );
      ((Element)v.get(440)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(444)).setAttribute("src","b.gif" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));
      /* Termina nodo:444   */
      /* Termina nodo:443   */

      /* Empieza nodo:445 / Elemento padre: 440   */
      v.add(doc.createElement("td"));
      ((Element)v.get(445)).setAttribute("width","12" );
      ((Element)v.get(440)).appendChild((Element)v.get(445));

      /* Empieza nodo:446 / Elemento padre: 445   */
   }

   private void getXML1800(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(446)).setAttribute("src","b.gif" );
      ((Element)v.get(446)).setAttribute("width","12" );
      ((Element)v.get(446)).setAttribute("height","1" );
      ((Element)v.get(445)).appendChild((Element)v.get(446));
      /* Termina nodo:446   */
      /* Termina nodo:445   */
      /* Termina nodo:440   */
      /* Termina nodo:69   */

      /* Empieza nodo:447 / Elemento padre: 68   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(447)).setAttribute("nombre","listado1" );
      ((Element)v.get(447)).setAttribute("ancho","733" );
      ((Element)v.get(447)).setAttribute("alto","108" );
      ((Element)v.get(447)).setAttribute("x","12" );
      ((Element)v.get(447)).setAttribute("y","138" );
      ((Element)v.get(447)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(447)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(68)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(448)).setAttribute("precarga","S" );
      ((Element)v.get(448)).setAttribute("conROver","S" );
      ((Element)v.get(447)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(449)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(449)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(449)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(449)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(448)).appendChild((Element)v.get(449));
      /* Termina nodo:449   */

      /* Empieza nodo:450 / Elemento padre: 448   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(450)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(450)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(450)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(450)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(448)).appendChild((Element)v.get(450));
      /* Termina nodo:450   */

      /* Empieza nodo:451 / Elemento padre: 448   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(451)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(451)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(448)).appendChild((Element)v.get(451));
      /* Termina nodo:451   */
      /* Termina nodo:448   */

      /* Empieza nodo:452 / Elemento padre: 447   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(447)).appendChild((Element)v.get(452));

      /* Empieza nodo:453 / Elemento padre: 452   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(453)).setAttribute("borde","1" );
      ((Element)v.get(453)).setAttribute("horizDatos","1" );
      ((Element)v.get(453)).setAttribute("horizCabecera","1" );
      ((Element)v.get(453)).setAttribute("vertical","1" );
      ((Element)v.get(453)).setAttribute("horizTitulo","1" );
      ((Element)v.get(453)).setAttribute("horizBase","1" );
      ((Element)v.get(452)).appendChild((Element)v.get(453));
      /* Termina nodo:453   */

      /* Empieza nodo:454 / Elemento padre: 452   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(454)).setAttribute("borde","#999999" );
      ((Element)v.get(454)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(454)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(454)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(454)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(454)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(454)).setAttribute("horizBase","#999999" );
      ((Element)v.get(452)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */
      /* Termina nodo:452   */

      /* Empieza nodo:455 / Elemento padre: 447   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(455)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(455)).setAttribute("alto","22" );
      ((Element)v.get(455)).setAttribute("imgFondo","" );
      ((Element)v.get(455)).setAttribute("cod","0014" );
      ((Element)v.get(455)).setAttribute("ID","datosTitle" );
      ((Element)v.get(447)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */

      /* Empieza nodo:456 / Elemento padre: 447   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(456)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(456)).setAttribute("alto","22" );
      ((Element)v.get(456)).setAttribute("imgFondo","" );
      ((Element)v.get(447)).appendChild((Element)v.get(456));
      /* Termina nodo:456   */

      /* Empieza nodo:457 / Elemento padre: 447   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(457)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(457)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(457)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(457)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(457)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(457)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(447)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(458)).setAttribute("ancho","100" );
      ((Element)v.get(458)).setAttribute("minimizable","S" );
      ((Element)v.get(458)).setAttribute("minimizada","N" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */

      /* Empieza nodo:459 / Elemento padre: 457   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(459)).setAttribute("ancho","100" );
      ((Element)v.get(459)).setAttribute("minimizable","S" );
      ((Element)v.get(459)).setAttribute("minimizada","N" );
      ((Element)v.get(457)).appendChild((Element)v.get(459));
      /* Termina nodo:459   */

      /* Empieza nodo:460 / Elemento padre: 457   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(460)).setAttribute("ancho","100" );
      ((Element)v.get(460)).setAttribute("minimizable","S" );
      ((Element)v.get(460)).setAttribute("minimizada","N" );
      ((Element)v.get(457)).appendChild((Element)v.get(460));
      /* Termina nodo:460   */

      /* Empieza nodo:461 / Elemento padre: 457   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(461)).setAttribute("ancho","70" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(461)).setAttribute("minimizable","S" );
      ((Element)v.get(461)).setAttribute("minimizada","N" );
      ((Element)v.get(457)).appendChild((Element)v.get(461));
      /* Termina nodo:461   */

      /* Empieza nodo:462 / Elemento padre: 457   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(462)).setAttribute("ancho","130" );
      ((Element)v.get(462)).setAttribute("minimizable","S" );
      ((Element)v.get(462)).setAttribute("minimizada","N" );
      ((Element)v.get(457)).appendChild((Element)v.get(462));
      /* Termina nodo:462   */

      /* Empieza nodo:463 / Elemento padre: 457   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(463)).setAttribute("ancho","100" );
      ((Element)v.get(463)).setAttribute("minimizable","S" );
      ((Element)v.get(463)).setAttribute("minimizada","N" );
      ((Element)v.get(457)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */

      /* Empieza nodo:464 / Elemento padre: 457   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(464)).setAttribute("ancho","80" );
      ((Element)v.get(464)).setAttribute("minimizable","S" );
      ((Element)v.get(464)).setAttribute("minimizada","N" );
      ((Element)v.get(457)).appendChild((Element)v.get(464));
      /* Termina nodo:464   */

      /* Empieza nodo:465 / Elemento padre: 457   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(465)).setAttribute("ancho","80" );
      ((Element)v.get(465)).setAttribute("minimizable","S" );
      ((Element)v.get(465)).setAttribute("minimizada","N" );
      ((Element)v.get(457)).appendChild((Element)v.get(465));
      /* Termina nodo:465   */

      /* Empieza nodo:466 / Elemento padre: 457   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(466)).setAttribute("ancho","80" );
      ((Element)v.get(466)).setAttribute("minimizable","S" );
      ((Element)v.get(466)).setAttribute("minimizada","N" );
      ((Element)v.get(457)).appendChild((Element)v.get(466));
      /* Termina nodo:466   */
      /* Termina nodo:457   */

      /* Empieza nodo:467 / Elemento padre: 447   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(467)).setAttribute("alto","20" );
      ((Element)v.get(467)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(467)).setAttribute("imgFondo","" );
      ((Element)v.get(467)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(447)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(468)).setAttribute("colFondo","" );
      ((Element)v.get(468)).setAttribute("ID","EstCab" );
      ((Element)v.get(468)).setAttribute("cod","8" );
      ((Element)v.get(467)).appendChild((Element)v.get(468));

      /* Elemento padre:468 / Elemento actual: 469   */
      v.add(doc.createTextNode("Código"));
      ((Element)v.get(468)).appendChild((Text)v.get(469));

      /* Termina nodo Texto:469   */
      /* Termina nodo:468   */

      /* Empieza nodo:470 / Elemento padre: 467   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(470)).setAttribute("colFondo","" );
      ((Element)v.get(470)).setAttribute("ID","EstCab" );
      ((Element)v.get(470)).setAttribute("cod","9" );
      ((Element)v.get(467)).appendChild((Element)v.get(470));

      /* Elemento padre:470 / Elemento actual: 471   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(470)).appendChild((Text)v.get(471));

      /* Termina nodo Texto:471   */
      /* Termina nodo:470   */

      /* Empieza nodo:472 / Elemento padre: 467   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(472)).setAttribute("colFondo","" );
      ((Element)v.get(472)).setAttribute("ID","EstCab" );
      ((Element)v.get(472)).setAttribute("cod","608" );
      ((Element)v.get(467)).appendChild((Element)v.get(472));

      /* Elemento padre:472 / Elemento actual: 473   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(472)).appendChild((Text)v.get(473));

      /* Termina nodo Texto:473   */
      /* Termina nodo:472   */

      /* Empieza nodo:474 / Elemento padre: 467   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(474)).setAttribute("colFondo","" );
      ((Element)v.get(474)).setAttribute("ID","EstCab" );
      ((Element)v.get(474)).setAttribute("cod","581" );
      ((Element)v.get(467)).appendChild((Element)v.get(474));

      /* Elemento padre:474 / Elemento actual: 475   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(474)).appendChild((Text)v.get(475));

      /* Termina nodo Texto:475   */
      /* Termina nodo:474   */

      /* Empieza nodo:476 / Elemento padre: 467   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(476)).setAttribute("colFondo","" );
      ((Element)v.get(476)).setAttribute("ID","EstCab" );
      ((Element)v.get(476)).setAttribute("cod","529" );
      ((Element)v.get(467)).appendChild((Element)v.get(476));

      /* Elemento padre:476 / Elemento actual: 477   */
      v.add(doc.createTextNode("Factor repetición"));
      ((Element)v.get(476)).appendChild((Text)v.get(477));

      /* Termina nodo Texto:477   */
      /* Termina nodo:476   */

      /* Empieza nodo:478 / Elemento padre: 467   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(478)).setAttribute("colFondo","" );
      ((Element)v.get(478)).setAttribute("ID","EstCab" );
      ((Element)v.get(478)).setAttribute("cod","530" );
      ((Element)v.get(467)).appendChild((Element)v.get(478));

      /* Elemento padre:478 / Elemento actual: 479   */
      v.add(doc.createTextNode("Precio unitario"));
      ((Element)v.get(478)).appendChild((Text)v.get(479));

      /* Termina nodo Texto:479   */
      /* Termina nodo:478   */

      /* Empieza nodo:480 / Elemento padre: 467   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(480)).setAttribute("colFondo","" );
      ((Element)v.get(480)).setAttribute("ID","EstCab" );
      ((Element)v.get(480)).setAttribute("cod","481" );
      ((Element)v.get(467)).appendChild((Element)v.get(480));

      /* Elemento padre:480 / Elemento actual: 481   */
      v.add(doc.createTextNode("Atributo 1"));
      ((Element)v.get(480)).appendChild((Text)v.get(481));

      /* Termina nodo Texto:481   */
      /* Termina nodo:480   */

      /* Empieza nodo:482 / Elemento padre: 467   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(482)).setAttribute("colFondo","" );
      ((Element)v.get(482)).setAttribute("ID","EstCab" );
      ((Element)v.get(482)).setAttribute("cod","482" );
      ((Element)v.get(467)).appendChild((Element)v.get(482));

      /* Elemento padre:482 / Elemento actual: 483   */
      v.add(doc.createTextNode("Atributo 2"));
      ((Element)v.get(482)).appendChild((Text)v.get(483));

      /* Termina nodo Texto:483   */
      /* Termina nodo:482   */

      /* Empieza nodo:484 / Elemento padre: 467   */
   }

   private void getXML1980(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(484)).setAttribute("colFondo","" );
      ((Element)v.get(484)).setAttribute("ID","EstCab" );
      ((Element)v.get(484)).setAttribute("cod","483" );
      ((Element)v.get(467)).appendChild((Element)v.get(484));

      /* Elemento padre:484 / Elemento actual: 485   */
      v.add(doc.createTextNode("Atributo 3"));
      ((Element)v.get(484)).appendChild((Text)v.get(485));

      /* Termina nodo Texto:485   */
      /* Termina nodo:484   */
      /* Termina nodo:467   */

      /* Empieza nodo:486 / Elemento padre: 447   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(486)).setAttribute("alto","22" );
      ((Element)v.get(486)).setAttribute("accion","" );
      ((Element)v.get(486)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(486)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(486)).setAttribute("maxSel","-1" );
      ((Element)v.get(486)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(486)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(486)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(486)).setAttribute("onLoad","" );
      ((Element)v.get(486)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(447)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(487)).setAttribute("tipo","texto" );
      ((Element)v.get(487)).setAttribute("ID","EstDat" );
      ((Element)v.get(486)).appendChild((Element)v.get(487));
      /* Termina nodo:487   */

      /* Empieza nodo:488 / Elemento padre: 486   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(488)).setAttribute("tipo","texto" );
      ((Element)v.get(488)).setAttribute("ID","EstDat2" );
      ((Element)v.get(486)).appendChild((Element)v.get(488));
      /* Termina nodo:488   */

      /* Empieza nodo:489 / Elemento padre: 486   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(489)).setAttribute("tipo","texto" );
      ((Element)v.get(489)).setAttribute("ID","EstDat" );
      ((Element)v.get(486)).appendChild((Element)v.get(489));
      /* Termina nodo:489   */

      /* Empieza nodo:490 / Elemento padre: 486   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(490)).setAttribute("tipo","texto" );
      ((Element)v.get(490)).setAttribute("ID","EstDat2" );
      ((Element)v.get(486)).appendChild((Element)v.get(490));
      /* Termina nodo:490   */

      /* Empieza nodo:491 / Elemento padre: 486   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(491)).setAttribute("tipo","texto" );
      ((Element)v.get(491)).setAttribute("ID","EstDat2" );
      ((Element)v.get(486)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */

      /* Empieza nodo:492 / Elemento padre: 486   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(492)).setAttribute("tipo","texto" );
      ((Element)v.get(492)).setAttribute("ID","EstDat" );
      ((Element)v.get(486)).appendChild((Element)v.get(492));
      /* Termina nodo:492   */

      /* Empieza nodo:493 / Elemento padre: 486   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(493)).setAttribute("tipo","texto" );
      ((Element)v.get(493)).setAttribute("ID","EstDat2" );
      ((Element)v.get(486)).appendChild((Element)v.get(493));
      /* Termina nodo:493   */

      /* Empieza nodo:494 / Elemento padre: 486   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(494)).setAttribute("tipo","texto" );
      ((Element)v.get(494)).setAttribute("ID","EstDat" );
      ((Element)v.get(486)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */

      /* Empieza nodo:495 / Elemento padre: 486   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(495)).setAttribute("tipo","texto" );
      ((Element)v.get(495)).setAttribute("ID","EstDat2" );
      ((Element)v.get(486)).appendChild((Element)v.get(495));
      /* Termina nodo:495   */
      /* Termina nodo:486   */

      /* Empieza nodo:496 / Elemento padre: 447   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(447)).appendChild((Element)v.get(496));
      /* Termina nodo:496   */

      /* Empieza nodo:497 / Elemento padre: 447   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(497)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(497)).setAttribute("ancho","733" );
      ((Element)v.get(497)).setAttribute("sep","$" );
      ((Element)v.get(497)).setAttribute("x","12" );
      ((Element)v.get(497)).setAttribute("class","botonera" );
      ((Element)v.get(497)).setAttribute("y","223" );
      ((Element)v.get(497)).setAttribute("control","|" );
      ((Element)v.get(497)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(497)).setAttribute("rowset","" );
      ((Element)v.get(497)).setAttribute("cargainicial","N" );
      ((Element)v.get(447)).appendChild((Element)v.get(497));
      /* Termina nodo:497   */
      /* Termina nodo:447   */

      /* Empieza nodo:498 / Elemento padre: 68   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(498)).setAttribute("nombre","Buscar1" );
      ((Element)v.get(498)).setAttribute("x","13" );
      ((Element)v.get(498)).setAttribute("y","224" );
      ((Element)v.get(498)).setAttribute("ID","botonContenido" );
      ((Element)v.get(498)).setAttribute("tipo","html" );
      ((Element)v.get(498)).setAttribute("estado","false" );
      ((Element)v.get(498)).setAttribute("cod","1" );
      ((Element)v.get(498)).setAttribute("accion","accionBuscarProductoPrincipal();" );
      ((Element)v.get(498)).setAttribute("ontab","tabGenerico('Buscar1','tab');" );
      ((Element)v.get(498)).setAttribute("onshtab","tabGenerico('Buscar1','sh');" );
      ((Element)v.get(68)).appendChild((Element)v.get(498));
      /* Termina nodo:498   */

      /* Empieza nodo:499 / Elemento padre: 68   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(499)).setAttribute("nombre","listado2" );
      ((Element)v.get(499)).setAttribute("ancho","733" );
      ((Element)v.get(499)).setAttribute("alto","317" );
      ((Element)v.get(499)).setAttribute("x","12" );
      ((Element)v.get(499)).setAttribute("y","270" );
      ((Element)v.get(499)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(499)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(68)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
   }

   private void getXML2070(Document doc) {
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(500)).setAttribute("precarga","S" );
      ((Element)v.get(500)).setAttribute("conROver","S" );
      ((Element)v.get(499)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(501)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(501)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(501)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(501)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(500)).appendChild((Element)v.get(501));
      /* Termina nodo:501   */

      /* Empieza nodo:502 / Elemento padre: 500   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(502)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(502)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(502)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(502)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(500)).appendChild((Element)v.get(502));
      /* Termina nodo:502   */

      /* Empieza nodo:503 / Elemento padre: 500   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(503)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(503)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(500)).appendChild((Element)v.get(503));
      /* Termina nodo:503   */
      /* Termina nodo:500   */

      /* Empieza nodo:504 / Elemento padre: 499   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(499)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(505)).setAttribute("borde","1" );
      ((Element)v.get(505)).setAttribute("horizDatos","1" );
      ((Element)v.get(505)).setAttribute("horizCabecera","1" );
      ((Element)v.get(505)).setAttribute("vertical","1" );
      ((Element)v.get(505)).setAttribute("horizTitulo","1" );
      ((Element)v.get(505)).setAttribute("horizBase","1" );
      ((Element)v.get(504)).appendChild((Element)v.get(505));
      /* Termina nodo:505   */

      /* Empieza nodo:506 / Elemento padre: 504   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(506)).setAttribute("borde","#999999" );
      ((Element)v.get(506)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(506)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(506)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(506)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(506)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(506)).setAttribute("horizBase","#999999" );
      ((Element)v.get(504)).appendChild((Element)v.get(506));
      /* Termina nodo:506   */
      /* Termina nodo:504   */

      /* Empieza nodo:507 / Elemento padre: 499   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(507)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(507)).setAttribute("alto","22" );
      ((Element)v.get(507)).setAttribute("imgFondo","" );
      ((Element)v.get(507)).setAttribute("cod","0012" );
      ((Element)v.get(507)).setAttribute("ID","datosTitle" );
      ((Element)v.get(499)).appendChild((Element)v.get(507));
      /* Termina nodo:507   */

      /* Empieza nodo:508 / Elemento padre: 499   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(508)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(508)).setAttribute("alto","22" );
      ((Element)v.get(508)).setAttribute("imgFondo","" );
      ((Element)v.get(499)).appendChild((Element)v.get(508));
      /* Termina nodo:508   */

      /* Empieza nodo:509 / Elemento padre: 499   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(509)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(509)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(509)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(509)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(509)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(509)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(499)).appendChild((Element)v.get(509));

      /* Empieza nodo:510 / Elemento padre: 509   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(510)).setAttribute("ancho","100" );
      ((Element)v.get(510)).setAttribute("minimizable","S" );
      ((Element)v.get(510)).setAttribute("minimizada","N" );
      ((Element)v.get(509)).appendChild((Element)v.get(510));
      /* Termina nodo:510   */

      /* Empieza nodo:511 / Elemento padre: 509   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(511)).setAttribute("ancho","100" );
      ((Element)v.get(511)).setAttribute("minimizable","S" );
      ((Element)v.get(511)).setAttribute("minimizada","N" );
      ((Element)v.get(509)).appendChild((Element)v.get(511));
      /* Termina nodo:511   */

      /* Empieza nodo:512 / Elemento padre: 509   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(512)).setAttribute("ancho","100" );
      ((Element)v.get(512)).setAttribute("minimizable","S" );
      ((Element)v.get(512)).setAttribute("minimizada","N" );
      ((Element)v.get(509)).appendChild((Element)v.get(512));
      /* Termina nodo:512   */

      /* Empieza nodo:513 / Elemento padre: 509   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(513)).setAttribute("ancho","70" );
      ((Element)v.get(513)).setAttribute("minimizable","S" );
      ((Element)v.get(513)).setAttribute("minimizada","N" );
      ((Element)v.get(509)).appendChild((Element)v.get(513));
      /* Termina nodo:513   */

      /* Empieza nodo:514 / Elemento padre: 509   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(514)).setAttribute("ancho","130" );
      ((Element)v.get(514)).setAttribute("minimizable","S" );
      ((Element)v.get(514)).setAttribute("minimizada","N" );
      ((Element)v.get(509)).appendChild((Element)v.get(514));
      /* Termina nodo:514   */

      /* Empieza nodo:515 / Elemento padre: 509   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(515)).setAttribute("ancho","100" );
      ((Element)v.get(515)).setAttribute("minimizable","S" );
      ((Element)v.get(515)).setAttribute("minimizada","N" );
      ((Element)v.get(509)).appendChild((Element)v.get(515));
      /* Termina nodo:515   */

      /* Empieza nodo:516 / Elemento padre: 509   */
      v.add(doc.createElement("COL"));
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(516)).setAttribute("ancho","80" );
      ((Element)v.get(516)).setAttribute("minimizable","S" );
      ((Element)v.get(516)).setAttribute("minimizada","N" );
      ((Element)v.get(509)).appendChild((Element)v.get(516));
      /* Termina nodo:516   */

      /* Empieza nodo:517 / Elemento padre: 509   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(517)).setAttribute("ancho","80" );
      ((Element)v.get(517)).setAttribute("minimizable","S" );
      ((Element)v.get(517)).setAttribute("minimizada","N" );
      ((Element)v.get(509)).appendChild((Element)v.get(517));
      /* Termina nodo:517   */

      /* Empieza nodo:518 / Elemento padre: 509   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(518)).setAttribute("ancho","80" );
      ((Element)v.get(518)).setAttribute("minimizable","S" );
      ((Element)v.get(518)).setAttribute("minimizada","N" );
      ((Element)v.get(509)).appendChild((Element)v.get(518));
      /* Termina nodo:518   */
      /* Termina nodo:509   */

      /* Empieza nodo:519 / Elemento padre: 499   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(519)).setAttribute("alto","20" );
      ((Element)v.get(519)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(519)).setAttribute("imgFondo","" );
      ((Element)v.get(519)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(499)).appendChild((Element)v.get(519));

      /* Empieza nodo:520 / Elemento padre: 519   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(520)).setAttribute("colFondo","" );
      ((Element)v.get(520)).setAttribute("ID","EstCab" );
      ((Element)v.get(520)).setAttribute("cod","8" );
      ((Element)v.get(519)).appendChild((Element)v.get(520));

      /* Elemento padre:520 / Elemento actual: 521   */
      v.add(doc.createTextNode("Código"));
      ((Element)v.get(520)).appendChild((Text)v.get(521));

      /* Termina nodo Texto:521   */
      /* Termina nodo:520   */

      /* Empieza nodo:522 / Elemento padre: 519   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(522)).setAttribute("colFondo","" );
      ((Element)v.get(522)).setAttribute("ID","EstCab" );
      ((Element)v.get(522)).setAttribute("cod","9" );
      ((Element)v.get(519)).appendChild((Element)v.get(522));

      /* Elemento padre:522 / Elemento actual: 523   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(522)).appendChild((Text)v.get(523));

      /* Termina nodo Texto:523   */
      /* Termina nodo:522   */

      /* Empieza nodo:524 / Elemento padre: 519   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(524)).setAttribute("colFondo","" );
      ((Element)v.get(524)).setAttribute("ID","EstCab" );
      ((Element)v.get(524)).setAttribute("cod","608" );
      ((Element)v.get(519)).appendChild((Element)v.get(524));

      /* Elemento padre:524 / Elemento actual: 525   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(524)).appendChild((Text)v.get(525));

      /* Termina nodo Texto:525   */
      /* Termina nodo:524   */

      /* Empieza nodo:526 / Elemento padre: 519   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(526)).setAttribute("colFondo","" );
      ((Element)v.get(526)).setAttribute("ID","EstCab" );
      ((Element)v.get(526)).setAttribute("cod","581" );
      ((Element)v.get(519)).appendChild((Element)v.get(526));

      /* Elemento padre:526 / Elemento actual: 527   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(526)).appendChild((Text)v.get(527));

      /* Termina nodo Texto:527   */
      /* Termina nodo:526   */

      /* Empieza nodo:528 / Elemento padre: 519   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(528)).setAttribute("colFondo","" );
      ((Element)v.get(528)).setAttribute("ID","EstCab" );
      ((Element)v.get(528)).setAttribute("cod","529" );
      ((Element)v.get(519)).appendChild((Element)v.get(528));

      /* Elemento padre:528 / Elemento actual: 529   */
      v.add(doc.createTextNode("Factor repetición"));
      ((Element)v.get(528)).appendChild((Text)v.get(529));

      /* Termina nodo Texto:529   */
      /* Termina nodo:528   */

      /* Empieza nodo:530 / Elemento padre: 519   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(530)).setAttribute("colFondo","" );
      ((Element)v.get(530)).setAttribute("ID","EstCab" );
      ((Element)v.get(530)).setAttribute("cod","530" );
      ((Element)v.get(519)).appendChild((Element)v.get(530));

      /* Elemento padre:530 / Elemento actual: 531   */
      v.add(doc.createTextNode("Precio unitario"));
      ((Element)v.get(530)).appendChild((Text)v.get(531));

      /* Termina nodo Texto:531   */
      /* Termina nodo:530   */

      /* Empieza nodo:532 / Elemento padre: 519   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(532)).setAttribute("colFondo","" );
      ((Element)v.get(532)).setAttribute("ID","EstCab" );
      ((Element)v.get(532)).setAttribute("cod","481" );
      ((Element)v.get(519)).appendChild((Element)v.get(532));

      /* Elemento padre:532 / Elemento actual: 533   */
      v.add(doc.createTextNode("Atributo 1"));
      ((Element)v.get(532)).appendChild((Text)v.get(533));

      /* Termina nodo Texto:533   */
      /* Termina nodo:532   */

      /* Empieza nodo:534 / Elemento padre: 519   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(534)).setAttribute("colFondo","" );
      ((Element)v.get(534)).setAttribute("ID","EstCab" );
      ((Element)v.get(534)).setAttribute("cod","482" );
      ((Element)v.get(519)).appendChild((Element)v.get(534));

      /* Elemento padre:534 / Elemento actual: 535   */
      v.add(doc.createTextNode("Atributo 2"));
      ((Element)v.get(534)).appendChild((Text)v.get(535));

      /* Termina nodo Texto:535   */
      /* Termina nodo:534   */

      /* Empieza nodo:536 / Elemento padre: 519   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(536)).setAttribute("colFondo","" );
      ((Element)v.get(536)).setAttribute("ID","EstCab" );
      ((Element)v.get(536)).setAttribute("cod","483" );
      ((Element)v.get(519)).appendChild((Element)v.get(536));

      /* Elemento padre:536 / Elemento actual: 537   */
      v.add(doc.createTextNode("Atributo 3"));
      ((Element)v.get(536)).appendChild((Text)v.get(537));

      /* Termina nodo Texto:537   */
      /* Termina nodo:536   */
      /* Termina nodo:519   */

      /* Empieza nodo:538 / Elemento padre: 499   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(538)).setAttribute("alto","22" );
      ((Element)v.get(538)).setAttribute("accion","" );
      ((Element)v.get(538)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(538)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(538)).setAttribute("maxSel","-1" );
      ((Element)v.get(538)).setAttribute("msgErrMaxSel","" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(538)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(538)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(538)).setAttribute("onLoad","" );
      ((Element)v.get(538)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(499)).appendChild((Element)v.get(538));

      /* Empieza nodo:539 / Elemento padre: 538   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(539)).setAttribute("tipo","texto" );
      ((Element)v.get(539)).setAttribute("ID","EstDat" );
      ((Element)v.get(538)).appendChild((Element)v.get(539));
      /* Termina nodo:539   */

      /* Empieza nodo:540 / Elemento padre: 538   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(540)).setAttribute("tipo","texto" );
      ((Element)v.get(540)).setAttribute("ID","EstDat2" );
      ((Element)v.get(538)).appendChild((Element)v.get(540));
      /* Termina nodo:540   */

      /* Empieza nodo:541 / Elemento padre: 538   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(541)).setAttribute("tipo","texto" );
      ((Element)v.get(541)).setAttribute("ID","EstDat" );
      ((Element)v.get(538)).appendChild((Element)v.get(541));
      /* Termina nodo:541   */

      /* Empieza nodo:542 / Elemento padre: 538   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(542)).setAttribute("tipo","texto" );
      ((Element)v.get(542)).setAttribute("ID","EstDat2" );
      ((Element)v.get(538)).appendChild((Element)v.get(542));
      /* Termina nodo:542   */

      /* Empieza nodo:543 / Elemento padre: 538   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(543)).setAttribute("tipo","texto" );
      ((Element)v.get(543)).setAttribute("ID","EstDat2" );
      ((Element)v.get(538)).appendChild((Element)v.get(543));
      /* Termina nodo:543   */

      /* Empieza nodo:544 / Elemento padre: 538   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(544)).setAttribute("tipo","texto" );
      ((Element)v.get(544)).setAttribute("ID","EstDat" );
      ((Element)v.get(538)).appendChild((Element)v.get(544));
      /* Termina nodo:544   */

      /* Empieza nodo:545 / Elemento padre: 538   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(545)).setAttribute("tipo","texto" );
      ((Element)v.get(545)).setAttribute("ID","EstDat2" );
      ((Element)v.get(538)).appendChild((Element)v.get(545));
      /* Termina nodo:545   */

      /* Empieza nodo:546 / Elemento padre: 538   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(546)).setAttribute("tipo","texto" );
      ((Element)v.get(546)).setAttribute("ID","EstDat" );
      ((Element)v.get(538)).appendChild((Element)v.get(546));
      /* Termina nodo:546   */

      /* Empieza nodo:547 / Elemento padre: 538   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(547)).setAttribute("tipo","texto" );
      ((Element)v.get(547)).setAttribute("ID","EstDat2" );
      ((Element)v.get(538)).appendChild((Element)v.get(547));
      /* Termina nodo:547   */
      /* Termina nodo:538   */

      /* Empieza nodo:548 / Elemento padre: 499   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(499)).appendChild((Element)v.get(548));
      /* Termina nodo:548   */

      /* Empieza nodo:549 / Elemento padre: 499   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(549)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(549)).setAttribute("ancho","733" );
      ((Element)v.get(549)).setAttribute("sep","$" );
      ((Element)v.get(549)).setAttribute("x","12" );
      ((Element)v.get(549)).setAttribute("class","botonera" );
      ((Element)v.get(549)).setAttribute("y","564" );
      ((Element)v.get(549)).setAttribute("control","|" );
      ((Element)v.get(549)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(549)).setAttribute("rowset","" );
      ((Element)v.get(549)).setAttribute("cargainicial","N" );
      ((Element)v.get(499)).appendChild((Element)v.get(549));
      /* Termina nodo:549   */
      /* Termina nodo:499   */

      /* Empieza nodo:550 / Elemento padre: 68   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(550)).setAttribute("nombre","Buscar2" );
      ((Element)v.get(550)).setAttribute("x","13" );
      ((Element)v.get(550)).setAttribute("y","565" );
      ((Element)v.get(550)).setAttribute("ID","botonContenido" );
      ((Element)v.get(550)).setAttribute("tipo","html" );
      ((Element)v.get(550)).setAttribute("estado","false" );
      ((Element)v.get(550)).setAttribute("cod","1" );
      ((Element)v.get(550)).setAttribute("accion","accionBuscarProductoAsociado();" );
      ((Element)v.get(550)).setAttribute("ontab","tabGenerico('Buscar2','tab');" );
      ((Element)v.get(550)).setAttribute("onshtab","tabGenerico('Buscar2','sh');" );
      ((Element)v.get(68)).appendChild((Element)v.get(550));
      /* Termina nodo:550   */

      /* Empieza nodo:551 / Elemento padre: 68   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(551)).setAttribute("nombre","listado3" );
      ((Element)v.get(551)).setAttribute("ancho","733" );
      ((Element)v.get(551)).setAttribute("alto","317" );
      ((Element)v.get(551)).setAttribute("x","12" );
      ((Element)v.get(551)).setAttribute("y","999" );
      ((Element)v.get(551)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(551)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(68)).appendChild((Element)v.get(551));

      /* Empieza nodo:552 / Elemento padre: 551   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(552)).setAttribute("precarga","S" );
      ((Element)v.get(552)).setAttribute("conROver","S" );
      ((Element)v.get(551)).appendChild((Element)v.get(552));

      /* Empieza nodo:553 / Elemento padre: 552   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(553)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(553)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(553)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(553)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(552)).appendChild((Element)v.get(553));
      /* Termina nodo:553   */

      /* Empieza nodo:554 / Elemento padre: 552   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(554)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(554)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(554)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(554)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(552)).appendChild((Element)v.get(554));
      /* Termina nodo:554   */

      /* Empieza nodo:555 / Elemento padre: 552   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(555)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(555)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(552)).appendChild((Element)v.get(555));
      /* Termina nodo:555   */
      /* Termina nodo:552   */

      /* Empieza nodo:556 / Elemento padre: 551   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(551)).appendChild((Element)v.get(556));

      /* Empieza nodo:557 / Elemento padre: 556   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(557)).setAttribute("borde","1" );
      ((Element)v.get(557)).setAttribute("horizDatos","1" );
      ((Element)v.get(557)).setAttribute("horizCabecera","1" );
      ((Element)v.get(557)).setAttribute("vertical","1" );
      ((Element)v.get(557)).setAttribute("horizTitulo","1" );
      ((Element)v.get(557)).setAttribute("horizBase","1" );
      ((Element)v.get(556)).appendChild((Element)v.get(557));
      /* Termina nodo:557   */

      /* Empieza nodo:558 / Elemento padre: 556   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(558)).setAttribute("borde","#999999" );
      ((Element)v.get(558)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(558)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(558)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(558)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(558)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(558)).setAttribute("horizBase","#999999" );
      ((Element)v.get(556)).appendChild((Element)v.get(558));
      /* Termina nodo:558   */
      /* Termina nodo:556   */

      /* Empieza nodo:559 / Elemento padre: 551   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(559)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(559)).setAttribute("alto","22" );
      ((Element)v.get(559)).setAttribute("imgFondo","" );
      ((Element)v.get(559)).setAttribute("cod","0013" );
      ((Element)v.get(559)).setAttribute("ID","datosTitle" );
      ((Element)v.get(551)).appendChild((Element)v.get(559));
      /* Termina nodo:559   */

      /* Empieza nodo:560 / Elemento padre: 551   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(560)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(560)).setAttribute("alto","22" );
      ((Element)v.get(560)).setAttribute("imgFondo","" );
      ((Element)v.get(551)).appendChild((Element)v.get(560));
      /* Termina nodo:560   */

      /* Empieza nodo:561 / Elemento padre: 551   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(561)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(561)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(561)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(561)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(561)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(561)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(551)).appendChild((Element)v.get(561));

      /* Empieza nodo:562 / Elemento padre: 561   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(562)).setAttribute("ancho","100" );
      ((Element)v.get(562)).setAttribute("minimizable","S" );
      ((Element)v.get(562)).setAttribute("minimizada","N" );
      ((Element)v.get(561)).appendChild((Element)v.get(562));
      /* Termina nodo:562   */

      /* Empieza nodo:563 / Elemento padre: 561   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(563)).setAttribute("ancho","100" );
      ((Element)v.get(563)).setAttribute("minimizable","S" );
      ((Element)v.get(563)).setAttribute("minimizada","N" );
      ((Element)v.get(561)).appendChild((Element)v.get(563));
      /* Termina nodo:563   */

      /* Empieza nodo:564 / Elemento padre: 561   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(564)).setAttribute("ancho","100" );
      ((Element)v.get(564)).setAttribute("minimizable","S" );
      ((Element)v.get(564)).setAttribute("minimizada","N" );
      ((Element)v.get(561)).appendChild((Element)v.get(564));
      /* Termina nodo:564   */

      /* Empieza nodo:565 / Elemento padre: 561   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(565)).setAttribute("ancho","70" );
      ((Element)v.get(565)).setAttribute("minimizable","S" );
      ((Element)v.get(565)).setAttribute("minimizada","N" );
      ((Element)v.get(561)).appendChild((Element)v.get(565));
      /* Termina nodo:565   */

      /* Empieza nodo:566 / Elemento padre: 561   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(566)).setAttribute("ancho","100" );
      ((Element)v.get(566)).setAttribute("minimizable","S" );
      ((Element)v.get(566)).setAttribute("minimizada","N" );
      ((Element)v.get(561)).appendChild((Element)v.get(566));
      /* Termina nodo:566   */

      /* Empieza nodo:567 / Elemento padre: 561   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(567)).setAttribute("ancho","100" );
      ((Element)v.get(567)).setAttribute("minimizable","S" );
      ((Element)v.get(567)).setAttribute("minimizada","N" );
      ((Element)v.get(561)).appendChild((Element)v.get(567));
      /* Termina nodo:567   */
      /* Termina nodo:561   */

      /* Empieza nodo:568 / Elemento padre: 551   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(568)).setAttribute("alto","20" );
      ((Element)v.get(568)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(568)).setAttribute("imgFondo","" );
      ((Element)v.get(568)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(551)).appendChild((Element)v.get(568));

      /* Empieza nodo:569 / Elemento padre: 568   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(569)).setAttribute("colFondo","" );
      ((Element)v.get(569)).setAttribute("ID","EstCab" );
      ((Element)v.get(569)).setAttribute("cod","393" );
      ((Element)v.get(568)).appendChild((Element)v.get(569));

      /* Elemento padre:569 / Elemento actual: 570   */
      v.add(doc.createTextNode("Tipo cliente"));
      ((Element)v.get(569)).appendChild((Text)v.get(570));

      /* Termina nodo Texto:570   */
      /* Termina nodo:569   */

      /* Empieza nodo:571 / Elemento padre: 568   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(571)).setAttribute("colFondo","" );
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(571)).setAttribute("ID","EstCab" );
      ((Element)v.get(571)).setAttribute("cod","595" );
      ((Element)v.get(568)).appendChild((Element)v.get(571));

      /* Elemento padre:571 / Elemento actual: 572   */
      v.add(doc.createTextNode("Subtipo cliente"));
      ((Element)v.get(571)).appendChild((Text)v.get(572));

      /* Termina nodo Texto:572   */
      /* Termina nodo:571   */

      /* Empieza nodo:573 / Elemento padre: 568   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(573)).setAttribute("colFondo","" );
      ((Element)v.get(573)).setAttribute("ID","EstCab" );
      ((Element)v.get(573)).setAttribute("cod","756" );
      ((Element)v.get(568)).appendChild((Element)v.get(573));

      /* Elemento padre:573 / Elemento actual: 574   */
      v.add(doc.createTextNode("Tipo clasificación"));
      ((Element)v.get(573)).appendChild((Text)v.get(574));

      /* Termina nodo Texto:574   */
      /* Termina nodo:573   */

      /* Empieza nodo:575 / Elemento padre: 568   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(575)).setAttribute("colFondo","" );
      ((Element)v.get(575)).setAttribute("ID","EstCab" );
      ((Element)v.get(575)).setAttribute("cod","550" );
      ((Element)v.get(568)).appendChild((Element)v.get(575));

      /* Elemento padre:575 / Elemento actual: 576   */
      v.add(doc.createTextNode("Clasificación"));
      ((Element)v.get(575)).appendChild((Text)v.get(576));

      /* Termina nodo Texto:576   */
      /* Termina nodo:575   */

      /* Empieza nodo:577 / Elemento padre: 568   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(577)).setAttribute("colFondo","" );
      ((Element)v.get(577)).setAttribute("ID","EstCab" );
      ((Element)v.get(577)).setAttribute("cod","551" );
      ((Element)v.get(568)).appendChild((Element)v.get(577));

      /* Elemento padre:577 / Elemento actual: 578   */
      v.add(doc.createTextNode("Estatus 1"));
      ((Element)v.get(577)).appendChild((Text)v.get(578));

      /* Termina nodo Texto:578   */
      /* Termina nodo:577   */

      /* Empieza nodo:579 / Elemento padre: 568   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(579)).setAttribute("colFondo","" );
      ((Element)v.get(579)).setAttribute("ID","EstCab" );
      ((Element)v.get(579)).setAttribute("cod","552" );
      ((Element)v.get(568)).appendChild((Element)v.get(579));

      /* Elemento padre:579 / Elemento actual: 580   */
      v.add(doc.createTextNode("Estatus 2"));
      ((Element)v.get(579)).appendChild((Text)v.get(580));

      /* Termina nodo Texto:580   */
      /* Termina nodo:579   */
      /* Termina nodo:568   */

      /* Empieza nodo:581 / Elemento padre: 551   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(581)).setAttribute("alto","22" );
      ((Element)v.get(581)).setAttribute("accion","" );
      ((Element)v.get(581)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(581)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(581)).setAttribute("maxSel","-1" );
      ((Element)v.get(581)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(581)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(581)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(581)).setAttribute("onLoad","" );
      ((Element)v.get(581)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(551)).appendChild((Element)v.get(581));

      /* Empieza nodo:582 / Elemento padre: 581   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(582)).setAttribute("tipo","texto" );
      ((Element)v.get(582)).setAttribute("ID","EstDat" );
      ((Element)v.get(581)).appendChild((Element)v.get(582));
      /* Termina nodo:582   */

      /* Empieza nodo:583 / Elemento padre: 581   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(583)).setAttribute("tipo","texto" );
      ((Element)v.get(583)).setAttribute("ID","EstDat2" );
      ((Element)v.get(581)).appendChild((Element)v.get(583));
      /* Termina nodo:583   */

      /* Empieza nodo:584 / Elemento padre: 581   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(584)).setAttribute("tipo","texto" );
      ((Element)v.get(584)).setAttribute("ID","EstDat" );
      ((Element)v.get(581)).appendChild((Element)v.get(584));
      /* Termina nodo:584   */

      /* Empieza nodo:585 / Elemento padre: 581   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(585)).setAttribute("tipo","texto" );
      ((Element)v.get(585)).setAttribute("ID","EstDat2" );
      ((Element)v.get(581)).appendChild((Element)v.get(585));
      /* Termina nodo:585   */

      /* Empieza nodo:586 / Elemento padre: 581   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(586)).setAttribute("tipo","texto" );
      ((Element)v.get(586)).setAttribute("ID","EstDat" );
      ((Element)v.get(581)).appendChild((Element)v.get(586));
      /* Termina nodo:586   */

      /* Empieza nodo:587 / Elemento padre: 581   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(587)).setAttribute("tipo","texto" );
      ((Element)v.get(587)).setAttribute("ID","EstDat2" );
      ((Element)v.get(581)).appendChild((Element)v.get(587));
      /* Termina nodo:587   */
      /* Termina nodo:581   */

      /* Empieza nodo:588 / Elemento padre: 551   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(551)).appendChild((Element)v.get(588));
      /* Termina nodo:588   */

      /* Empieza nodo:589 / Elemento padre: 551   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(589)).setAttribute("nombre","mipgndo3" );
      ((Element)v.get(589)).setAttribute("ancho","733" );
      ((Element)v.get(589)).setAttribute("sep","$" );
      ((Element)v.get(589)).setAttribute("x","12" );
      ((Element)v.get(589)).setAttribute("class","botonera" );
      ((Element)v.get(589)).setAttribute("y","1293" );
      ((Element)v.get(589)).setAttribute("control","|" );
      ((Element)v.get(589)).setAttribute("conector","conector_prototipo_2" );
      ((Element)v.get(589)).setAttribute("rowset","" );
      ((Element)v.get(589)).setAttribute("cargainicial","N" );
      ((Element)v.get(551)).appendChild((Element)v.get(589));
      /* Termina nodo:589   */
      /* Termina nodo:551   */

      /* Empieza nodo:590 / Elemento padre: 68   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(590)).setAttribute("nombre","Anadir" );
      ((Element)v.get(590)).setAttribute("x","13" );
      ((Element)v.get(590)).setAttribute("y","1294" );
      ((Element)v.get(590)).setAttribute("ID","botonContenido" );
      ((Element)v.get(590)).setAttribute("tipo","html" );
      ((Element)v.get(590)).setAttribute("estado","false" );
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(590)).setAttribute("cod","1254" );
      ((Element)v.get(590)).setAttribute("accion","accionEliminarVentaExclusiva();" );
      ((Element)v.get(590)).setAttribute("ontab","tabGenerico('Anadir','tab');" );
      ((Element)v.get(590)).setAttribute("onshtab","tabGenerico('Anadir','sh');" );
      ((Element)v.get(68)).appendChild((Element)v.get(590));
      /* Termina nodo:590   */
      /* Termina nodo:68   */
      /* Termina nodo:16   */


   }

}

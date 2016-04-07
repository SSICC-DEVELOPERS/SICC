
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_oferta_definir_perf  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_oferta_definir_perf" );
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
      ((Element)v.get(3)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","contenido_oferta_definir_perf.js" );
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
      ((Element)v.get(7)).setAttribute("name","cbAcceso" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","10" );
      ((Element)v.get(7)).setAttribute("group","gr" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbSubacceso" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","122" );
      ((Element)v.get(8)).setAttribute("group","gr" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbArgumentoVenta" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("cod","528" );
      ((Element)v.get(9)).setAttribute("group","grgral" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","txtNGrupos" );
      ((Element)v.get(10)).setAttribute("required","false" );
      ((Element)v.get(10)).setAttribute("format","E" );
      ((Element)v.get(10)).setAttribute("cod","533" );
      ((Element)v.get(10)).setAttribute("req","N" );
      ((Element)v.get(10)).setAttribute("max","99" );
      ((Element)v.get(10)).setAttribute("min","0" );
      ((Element)v.get(10)).setAttribute("group","numGrupos" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","txtNPaquetes" );
      ((Element)v.get(11)).setAttribute("required","false" );
      ((Element)v.get(11)).setAttribute("format","E" );
      ((Element)v.get(11)).setAttribute("cod","534" );
      ((Element)v.get(11)).setAttribute("req","N" );
      ((Element)v.get(11)).setAttribute("max","99" );
      ((Element)v.get(11)).setAttribute("min","0" );
      ((Element)v.get(11)).setAttribute("group","numPaq" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","txtNGrupCondicionantes" );
      ((Element)v.get(12)).setAttribute("required","false" );
      ((Element)v.get(12)).setAttribute("format","E" );
      ((Element)v.get(12)).setAttribute("cod","535" );
      ((Element)v.get(12)).setAttribute("req","N" );
      ((Element)v.get(12)).setAttribute("max","99" );
      ((Element)v.get(12)).setAttribute("min","0" );
      ((Element)v.get(12)).setAttribute("group","numGrupoCnd" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","txtNGrupCondicionados" );
      ((Element)v.get(13)).setAttribute("required","false" );
      ((Element)v.get(13)).setAttribute("format","E" );
      ((Element)v.get(13)).setAttribute("cod","537" );
      ((Element)v.get(13)).setAttribute("req","N" );
      ((Element)v.get(13)).setAttribute("max","99" );
      ((Element)v.get(13)).setAttribute("min","0" );
      ((Element)v.get(13)).setAttribute("group","numGrupoCnd" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","txtNGrupos" );
      ((Element)v.get(14)).setAttribute("required","true" );
      ((Element)v.get(14)).setAttribute("cod","533" );
      ((Element)v.get(14)).setAttribute("group","grngrup" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(15)).setAttribute("name","txtNPaquetes" );
      ((Element)v.get(15)).setAttribute("required","true" );
      ((Element)v.get(15)).setAttribute("cod","534" );
      ((Element)v.get(15)).setAttribute("group","grnpaq" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(16)).setAttribute("name","txtNGrupCondicionantes" );
      ((Element)v.get(16)).setAttribute("required","true" );
      ((Element)v.get(16)).setAttribute("cod","535" );
      ((Element)v.get(16)).setAttribute("group","grcond" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(17)).setAttribute("name","txtNGrupCondicionados" );
      ((Element)v.get(17)).setAttribute("required","true" );
      ((Element)v.get(17)).setAttribute("cod","537" );
      ((Element)v.get(17)).setAttribute("group","grcond" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(18)).setAttribute("name","cbTipoCliente" );
      ((Element)v.get(18)).setAttribute("required","true" );
      ((Element)v.get(18)).setAttribute("cod","393" );
      ((Element)v.get(18)).setAttribute("group","vexcl" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(19)).setAttribute("name","cbIdCuadre" );
      ((Element)v.get(19)).setAttribute("required","true" );
      ((Element)v.get(19)).setAttribute("cod","461" );
      ((Element)v.get(19)).setAttribute("group","idCuadre" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(20)).setAttribute("name","cbCatalogo" );
      ((Element)v.get(20)).setAttribute("required","true" );
      ((Element)v.get(20)).setAttribute("cod","516" );
      ((Element)v.get(20)).setAttribute("group","catalogo" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */
      /* Termina nodo:6   */

      /* Empieza nodo:21 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(21)).setAttribute("nombre","frmContenido" );
      ((Element)v.get(0)).appendChild((Element)v.get(21));

      /* Empieza nodo:22 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","accion" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(26)).setAttribute("valor","LPDefinirOfertaPerf" );
      ((Element)v.get(21)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","oidCabeceraMF" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","oidEstrategia" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","numGrupos" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","numPaqu" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","indCuadre" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","numGrupCondtes" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","numGrupCondos" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","condCondos" );
      ((Element)v.get(34)).setAttribute("valor","" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(21)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","condCondtes" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hAccesoDef" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hSubaccesoDef" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","cvDespAuto" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","despAuto" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","despCompl" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","btnBPPpal" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","btnBPAsoc" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","maxGrupo" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","maxGruposCondicionantes" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","maxGruposCondicionados" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","cuadreGrupos" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","argumentoVta" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","descCatalogo" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","hCtePREMF" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","promociones" );
      ((Element)v.get(50)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","ranking" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","condicionada" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","hlstIdCuadresMono" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","hlstIdCuadresMulti" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","hZona" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","hRegion" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML270(Document doc) {
      ((Element)v.get(57)).setAttribute("nombre","arrZonas" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 21   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","arrRegiones" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(21)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 21   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(59)).setAttribute("nombre","capaContenido" );
      ((Element)v.get(59)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(59)).setAttribute("borde","0" );
      ((Element)v.get(59)).setAttribute("imagenf","" );
      ((Element)v.get(59)).setAttribute("repeat","" );
      ((Element)v.get(59)).setAttribute("padding","" );
      ((Element)v.get(59)).setAttribute("visibilidad","" );
      ((Element)v.get(59)).setAttribute("contravsb","" );
      ((Element)v.get(59)).setAttribute("x","0" );
      ((Element)v.get(59)).setAttribute("y","0" );
      ((Element)v.get(59)).setAttribute("zindex","" );
      ((Element)v.get(21)).appendChild((Element)v.get(59));

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
      ((Element)v.get(64)).setAttribute("width","750" );
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
      ((Element)v.get(67)).setAttribute("height","1" );
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
      ((Element)v.get(74)).setAttribute("nombre","lblDatos" );
      ((Element)v.get(74)).setAttribute("alto","13" );
      ((Element)v.get(74)).setAttribute("filas","1" );
      ((Element)v.get(74)).setAttribute("valor","Datos de oferta" );
      ((Element)v.get(74)).setAttribute("id","legend" );
      ((Element)v.get(74)).setAttribute("cod","00113" );
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
      ((Element)v.get(78)).setAttribute("width","730" );
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
      ((Element)v.get(86)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(86)).setAttribute("alto","13" );
      ((Element)v.get(86)).setAttribute("filas","1" );
      ((Element)v.get(86)).setAttribute("valor","" );
      ((Element)v.get(86)).setAttribute("id","datosTitle" );
      ((Element)v.get(86)).setAttribute("cod","10" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(88)).setAttribute("src","b.gif" );
      ((Element)v.get(88)).setAttribute("width","25" );
      ((Element)v.get(88)).setAttribute("height","8" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:89 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(90)).setAttribute("nombre","lblSubacceso" );
      ((Element)v.get(90)).setAttribute("alto","13" );
      ((Element)v.get(90)).setAttribute("filas","1" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(90)).setAttribute("id","datosTitle" );
      ((Element)v.get(90)).setAttribute("cod","122" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 82   */
      v.add(doc.createElement("td"));
      ((Element)v.get(91)).setAttribute("width","100%" );
      ((Element)v.get(82)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","8" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:82   */

      /* Empieza nodo:93 / Elemento padre: 78   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(78)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(95)).setAttribute("src","b.gif" );
      ((Element)v.get(95)).setAttribute("width","8" );
      ((Element)v.get(95)).setAttribute("height","8" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:96 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(93)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(97)).setAttribute("nombre","cbAcceso" );
      ((Element)v.get(97)).setAttribute("id","datosCampos" );
      ((Element)v.get(97)).setAttribute("size","1" );
      ((Element)v.get(97)).setAttribute("multiple","N" );
      ((Element)v.get(97)).setAttribute("req","N" );
      ((Element)v.get(97)).setAttribute("valorinicial","" );
      ((Element)v.get(97)).setAttribute("textoinicial","" );
      ((Element)v.get(97)).setAttribute("onchange","accesoOnChange();" );
      ((Element)v.get(97)).setAttribute("onblur","" );
      ((Element)v.get(97)).setAttribute("ontab","tabGenerico('cbAcceso');" );
      ((Element)v.get(97)).setAttribute("onshtab","tabGenerico('cbAcceso','sh');" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:99 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","25" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(101)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(93)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(102)).setAttribute("nombre","cbSubacceso" );
      ((Element)v.get(102)).setAttribute("id","datosCampos" );
      ((Element)v.get(102)).setAttribute("size","1" );
      ((Element)v.get(102)).setAttribute("multiple","N" );
      ((Element)v.get(102)).setAttribute("req","N" );
      ((Element)v.get(102)).setAttribute("valorinicial","" );
      ((Element)v.get(102)).setAttribute("textoinicial","" );
      ((Element)v.get(102)).setAttribute("ontab","tabGenerico('cbSubacceso');" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:104 / Elemento padre: 93   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).setAttribute("width","100%" );
      ((Element)v.get(93)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","8" );
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:93   */

      /* Empieza nodo:106 / Elemento padre: 78   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(78)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("td"));
      ((Element)v.get(107)).setAttribute("colspan","4" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","8" );
      ((Element)v.get(108)).setAttribute("height","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:78   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:109 / Elemento padre: 75   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(75)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("td"));
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("table"));
      ((Element)v.get(111)).setAttribute("width","730" );
      ((Element)v.get(111)).setAttribute("border","0" );
      ((Element)v.get(111)).setAttribute("align","left" );
      ((Element)v.get(111)).setAttribute("cellspacing","0" );
      ((Element)v.get(111)).setAttribute("cellpadding","0" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","8" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(116)).setAttribute("nombre","lblCatalogo" );
      ((Element)v.get(116)).setAttribute("alto","13" );
      ((Element)v.get(116)).setAttribute("filas","1" );
      ((Element)v.get(116)).setAttribute("valor","" );
      ((Element)v.get(116)).setAttribute("id","datosTitle" );
      ((Element)v.get(116)).setAttribute("cod","516" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","25" );
      ((Element)v.get(118)).setAttribute("height","8" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */

      /* Empieza nodo:119 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(112)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(120)).setAttribute("nombre","lblArgumentoVenta" );
      ((Element)v.get(120)).setAttribute("alto","13" );
      ((Element)v.get(120)).setAttribute("filas","1" );
      ((Element)v.get(120)).setAttribute("valor","" );
      ((Element)v.get(120)).setAttribute("id","datosTitle" );
      ((Element)v.get(120)).setAttribute("cod","528" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */

      /* Empieza nodo:121 / Elemento padre: 112   */
      v.add(doc.createElement("td"));
      ((Element)v.get(121)).setAttribute("width","100%" );
      ((Element)v.get(112)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","8" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:112   */

      /* Empieza nodo:123 / Elemento padre: 111   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(111)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(125)).setAttribute("width","8" );
      ((Element)v.get(125)).setAttribute("height","8" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:126 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(123)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(127)).setAttribute("nombre","cbCatalogo" );
      ((Element)v.get(127)).setAttribute("id","datosCampos" );
      ((Element)v.get(127)).setAttribute("size","1" );
      ((Element)v.get(127)).setAttribute("multiple","N" );
      ((Element)v.get(127)).setAttribute("req","S" );
      ((Element)v.get(127)).setAttribute("valorinicial","" );
      ((Element)v.get(127)).setAttribute("textoinicial","" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:129 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(123)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","25" );
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 123   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(131)).setAttribute("valign","bottom" );
      ((Element)v.get(123)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(132)).setAttribute("nombre","cbArgumentoVenta" );
      ((Element)v.get(132)).setAttribute("id","datosCampos" );
      ((Element)v.get(132)).setAttribute("size","1" );
      ((Element)v.get(132)).setAttribute("multiple","N" );
      ((Element)v.get(132)).setAttribute("req","N" );
      ((Element)v.get(132)).setAttribute("valorinicial","" );
      ((Element)v.get(132)).setAttribute("textoinicial","" );
      ((Element)v.get(132)).setAttribute("ontab","tabGenerico('cbArgumentoVenta');" );
      ((Element)v.get(132)).setAttribute("onshtab","tabGenerico('cbArgumentoVenta','sh');" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:123   */

      /* Empieza nodo:134 / Elemento padre: 111   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(111)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(135)).setAttribute("colspan","4" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","8" );
      ((Element)v.get(136)).setAttribute("height","8" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:75   */
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:137 / Elemento padre: 68   */
      v.add(doc.createElement("td"));
      ((Element)v.get(68)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:68   */

      /* Empieza nodo:139 / Elemento padre: 60   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(60)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("colspan","4" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).setAttribute("width","8" );
      ((Element)v.get(141)).setAttribute("height","497" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:142 / Elemento padre: 60   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(60)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(147)).setAttribute("class","legend" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(148)).setAttribute("nombre","lblDatosOfer" );
      ((Element)v.get(148)).setAttribute("alto","13" );
      ((Element)v.get(148)).setAttribute("filas","1" );
      ((Element)v.get(148)).setAttribute("valor","Datos de oferta" );
      ((Element)v.get(148)).setAttribute("id","legend" );
      ((Element)v.get(148)).setAttribute("cod","00113" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 146   */
      v.add(doc.createElement("table"));
      ((Element)v.get(149)).setAttribute("width","100%" );
      ((Element)v.get(149)).setAttribute("border","0" );
      ((Element)v.get(149)).setAttribute("align","center" );
      ((Element)v.get(149)).setAttribute("cellspacing","0" );
      ((Element)v.get(149)).setAttribute("cellpadding","0" );
      ((Element)v.get(146)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("td"));
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("table"));
      ((Element)v.get(152)).setAttribute("width","730" );
      ((Element)v.get(152)).setAttribute("border","0" );
      ((Element)v.get(152)).setAttribute("align","left" );
      ((Element)v.get(152)).setAttribute("cellspacing","0" );
      ((Element)v.get(152)).setAttribute("cellpadding","0" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("td"));
      ((Element)v.get(154)).setAttribute("colspan","4" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(155)).setAttribute("src","b.gif" );
      ((Element)v.get(155)).setAttribute("width","8" );
      ((Element)v.get(155)).setAttribute("height","8" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:156 / Elemento padre: 152   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(152)).appendChild((Element)v.get(156));

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
      ((Element)v.get(160)).setAttribute("nombre","lblNGrupos" );
      ((Element)v.get(160)).setAttribute("alto","13" );
      ((Element)v.get(160)).setAttribute("filas","1" );
      ((Element)v.get(160)).setAttribute("valor","" );
      ((Element)v.get(160)).setAttribute("id","datosTitle" );
      ((Element)v.get(160)).setAttribute("cod","533" );
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
      ((Element)v.get(164)).setAttribute("nombre","lblNPaquetes" );
      ((Element)v.get(164)).setAttribute("alto","13" );
      ((Element)v.get(164)).setAttribute("filas","1" );
      ((Element)v.get(164)).setAttribute("valor","" );
      ((Element)v.get(164)).setAttribute("id","datosTitle" );
      ((Element)v.get(164)).setAttribute("cod","534" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(166)).setAttribute("width","25" );
      ((Element)v.get(166)).setAttribute("height","8" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(156)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(168)).setAttribute("nombre","lblIdCuadre" );
      ((Element)v.get(168)).setAttribute("alto","13" );
      ((Element)v.get(168)).setAttribute("filas","1" );
      ((Element)v.get(168)).setAttribute("valor","" );
      ((Element)v.get(168)).setAttribute("id","datosTitle" );
      ((Element)v.get(168)).setAttribute("cod","461" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 156   */
      v.add(doc.createElement("td"));
      ((Element)v.get(169)).setAttribute("width","100%" );
      ((Element)v.get(156)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).setAttribute("width","8" );
      ((Element)v.get(170)).setAttribute("height","8" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:156   */

      /* Empieza nodo:171 / Elemento padre: 152   */
   }

   private void getXML720(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(152)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(173)).setAttribute("src","b.gif" );
      ((Element)v.get(173)).setAttribute("width","8" );
      ((Element)v.get(173)).setAttribute("height","8" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:174 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(174)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(171)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(175)).setAttribute("nombre","txtNGrupos" );
      ((Element)v.get(175)).setAttribute("id","datosCampos" );
      ((Element)v.get(175)).setAttribute("max","2" );
      ((Element)v.get(175)).setAttribute("tipo","" );
      ((Element)v.get(175)).setAttribute("onchange","accionNumeroGruposIntroducido();" );
      ((Element)v.get(175)).setAttribute("req","N" );
      ((Element)v.get(175)).setAttribute("size","2" );
      ((Element)v.get(175)).setAttribute("valor","" );
      ((Element)v.get(175)).setAttribute("validacion","" );
      ((Element)v.get(175)).setAttribute("onshtab","tabGenerico('txtNGrupos','sh');" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","25" );
      ((Element)v.get(177)).setAttribute("height","8" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:178 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(171)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(179)).setAttribute("nombre","txtNPaquetes" );
      ((Element)v.get(179)).setAttribute("id","datosCampos" );
      ((Element)v.get(179)).setAttribute("max","2" );
      ((Element)v.get(179)).setAttribute("tipo","" );
      ((Element)v.get(179)).setAttribute("onchange","" );
      ((Element)v.get(179)).setAttribute("req","N" );
      ((Element)v.get(179)).setAttribute("size","2" );
      ((Element)v.get(179)).setAttribute("valor","" );
      ((Element)v.get(179)).setAttribute("validacion","" );
      ((Element)v.get(179)).setAttribute("onshtab","tabGenerico('txtNPaquetes','sh');" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(171)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).setAttribute("width","25" );
      ((Element)v.get(181)).setAttribute("height","8" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(182)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(171)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(183)).setAttribute("nombre","cbIdCuadre" );
      ((Element)v.get(183)).setAttribute("id","datosCampos" );
      ((Element)v.get(183)).setAttribute("size","1" );
      ((Element)v.get(183)).setAttribute("multiple","N" );
      ((Element)v.get(183)).setAttribute("req","N" );
      ((Element)v.get(183)).setAttribute("valorinicial","" );
      ((Element)v.get(183)).setAttribute("textoinicial","" );
      ((Element)v.get(183)).setAttribute("onshtab","tabGenerico('cbIdCuadre','sh');" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:185 / Elemento padre: 171   */
      v.add(doc.createElement("td"));
      ((Element)v.get(185)).setAttribute("width","100%" );
      ((Element)v.get(171)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).setAttribute("width","8" );
      ((Element)v.get(186)).setAttribute("height","8" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */
      /* Termina nodo:171   */

      /* Empieza nodo:187 / Elemento padre: 152   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(152)).appendChild((Element)v.get(187));

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
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:190 / Elemento padre: 149   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(149)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("td"));
      ((Element)v.get(190)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("table"));
      ((Element)v.get(192)).setAttribute("width","730" );
      ((Element)v.get(192)).setAttribute("border","0" );
      ((Element)v.get(192)).setAttribute("align","left" );
      ((Element)v.get(192)).setAttribute("cellspacing","0" );
      ((Element)v.get(192)).setAttribute("cellpadding","0" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(195)).setAttribute("src","b.gif" );
      ((Element)v.get(195)).setAttribute("width","8" );
      ((Element)v.get(195)).setAttribute("height","8" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(197)).setAttribute("nombre","lblNGrupCondicionantes" );
      ((Element)v.get(197)).setAttribute("alto","13" );
      ((Element)v.get(197)).setAttribute("filas","1" );
      ((Element)v.get(197)).setAttribute("valor","" );
      ((Element)v.get(197)).setAttribute("id","datosTitle" );
      ((Element)v.get(197)).setAttribute("cod","535" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(199)).setAttribute("src","b.gif" );
      ((Element)v.get(199)).setAttribute("width","25" );
      ((Element)v.get(199)).setAttribute("height","8" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(201)).setAttribute("nombre","lblCondicionantes" );
      ((Element)v.get(201)).setAttribute("alto","13" );
      ((Element)v.get(201)).setAttribute("filas","1" );
      ((Element)v.get(201)).setAttribute("valor","" );
      ((Element)v.get(201)).setAttribute("id","datosTitle" );
      ((Element)v.get(201)).setAttribute("cod","536" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(203)).setAttribute("src","b.gif" );
      ((Element)v.get(203)).setAttribute("width","25" );
      ((Element)v.get(203)).setAttribute("height","8" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(205)).setAttribute("nombre","lblNGrupCondicionados" );
      ((Element)v.get(205)).setAttribute("alto","13" );
      ((Element)v.get(205)).setAttribute("filas","1" );
      ((Element)v.get(205)).setAttribute("valor","" );
      ((Element)v.get(205)).setAttribute("id","datosTitle" );
      ((Element)v.get(205)).setAttribute("cod","537" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(207)).setAttribute("src","b.gif" );
      ((Element)v.get(207)).setAttribute("width","25" );
      ((Element)v.get(207)).setAttribute("height","8" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(209)).setAttribute("nombre","lblCondicionados" );
      ((Element)v.get(209)).setAttribute("alto","13" );
      ((Element)v.get(209)).setAttribute("filas","1" );
      ((Element)v.get(209)).setAttribute("valor","" );
      ((Element)v.get(209)).setAttribute("id","datosTitle" );
      ((Element)v.get(209)).setAttribute("cod","538" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(211)).setAttribute("width","25" );
      ((Element)v.get(211)).setAttribute("height","8" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(213)).setAttribute("nombre","lblDespachoCompleto" );
      ((Element)v.get(213)).setAttribute("alto","13" );
      ((Element)v.get(213)).setAttribute("filas","1" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(213)).setAttribute("valor","" );
      ((Element)v.get(213)).setAttribute("id","datosTitle" );
      ((Element)v.get(213)).setAttribute("cod","539" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:214 / Elemento padre: 193   */
      v.add(doc.createElement("td"));
      ((Element)v.get(214)).setAttribute("width","100%" );
      ((Element)v.get(193)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(215)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).setAttribute("width","8" );
      ((Element)v.get(215)).setAttribute("height","8" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */
      /* Termina nodo:193   */

      /* Empieza nodo:216 / Elemento padre: 192   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(192)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(218)).setAttribute("src","b.gif" );
      ((Element)v.get(218)).setAttribute("width","8" );
      ((Element)v.get(218)).setAttribute("height","8" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:219 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(219)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(216)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(220)).setAttribute("nombre","txtNGrupCondicionantes" );
      ((Element)v.get(220)).setAttribute("onchange","sumarYPoner();" );
      ((Element)v.get(220)).setAttribute("id","datosCampos" );
      ((Element)v.get(220)).setAttribute("max","2" );
      ((Element)v.get(220)).setAttribute("tipo","" );
      ((Element)v.get(220)).setAttribute("req","N" );
      ((Element)v.get(220)).setAttribute("size","2" );
      ((Element)v.get(220)).setAttribute("valor","" );
      ((Element)v.get(220)).setAttribute("validacion","" );
      ((Element)v.get(220)).setAttribute("onshtab","tabGenerico('txtNGrupCondicionantes','sh');" );
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
      ((Element)v.get(223)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(216)).appendChild((Element)v.get(223));

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
      ((Element)v.get(226)).setAttribute("class","datosCampos" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(227)).setAttribute("nombre","rbCondicionantes" );
      ((Element)v.get(227)).setAttribute("tipo","H" );
      ((Element)v.get(227)).setAttribute("id","datosCampos" );
      ((Element)v.get(227)).setAttribute("onshtab","tabGenerico('rbCondicionantes','sh');" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(228)).setAttribute("valor","S" );
      ((Element)v.get(228)).setAttribute("check","N" );
      ((Element)v.get(228)).setAttribute("onfocus","" );
      ((Element)v.get(228)).setAttribute("id","datosCampos" );
      ((Element)v.get(228)).setAttribute("cod","1310" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));

      /* Elemento padre:228 / Elemento actual: 229   */
      v.add(doc.createTextNode("Y"));
      ((Element)v.get(228)).appendChild((Text)v.get(229));

      /* Termina nodo Texto:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:230 / Elemento padre: 227   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(230)).setAttribute("valor","N" );
      ((Element)v.get(230)).setAttribute("check","N" );
      ((Element)v.get(230)).setAttribute("onfocus","" );
      ((Element)v.get(230)).setAttribute("id","datosCampos" );
      ((Element)v.get(230)).setAttribute("cod","1311" );
      ((Element)v.get(227)).appendChild((Element)v.get(230));

      /* Elemento padre:230 / Elemento actual: 231   */
      v.add(doc.createTextNode("O"));
      ((Element)v.get(230)).appendChild((Text)v.get(231));

      /* Termina nodo Texto:231   */
      /* Termina nodo:230   */
      /* Termina nodo:227   */
      /* Termina nodo:226   */
      /* Termina nodo:225   */
      /* Termina nodo:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:232 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(233)).setAttribute("src","b.gif" );
      ((Element)v.get(233)).setAttribute("width","25" );
      ((Element)v.get(233)).setAttribute("height","8" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:234 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(234)).setAttribute("nowrap","nowrap" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(216)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(235)).setAttribute("nombre","txtNGrupCondicionados" );
      ((Element)v.get(235)).setAttribute("onchange","sumarYPoner();" );
      ((Element)v.get(235)).setAttribute("id","datosCampos" );
      ((Element)v.get(235)).setAttribute("max","2" );
      ((Element)v.get(235)).setAttribute("tipo","" );
      ((Element)v.get(235)).setAttribute("req","N" );
      ((Element)v.get(235)).setAttribute("size","2" );
      ((Element)v.get(235)).setAttribute("valor","" );
      ((Element)v.get(235)).setAttribute("validacion","" );
      ((Element)v.get(235)).setAttribute("onshtab","tabGenerico('txtNGrupCondicionados','sh');" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:236 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(237)).setAttribute("src","b.gif" );
      ((Element)v.get(237)).setAttribute("width","25" );
      ((Element)v.get(237)).setAttribute("height","8" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:238 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(238)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(216)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("table"));
      ((Element)v.get(239)).setAttribute("width","100%" );
      ((Element)v.get(239)).setAttribute("border","0" );
      ((Element)v.get(239)).setAttribute("cellspacing","0" );
      ((Element)v.get(239)).setAttribute("cellpadding","0" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(239)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("td"));
      ((Element)v.get(241)).setAttribute("class","datosCampos" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(242)).setAttribute("nombre","rbCondicionados" );
      ((Element)v.get(242)).setAttribute("tipo","H" );
      ((Element)v.get(242)).setAttribute("id","datosCampos" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(243)).setAttribute("valor","S" );
      ((Element)v.get(243)).setAttribute("check","N" );
      ((Element)v.get(243)).setAttribute("onfocus","" );
      ((Element)v.get(243)).setAttribute("id","datosCampos" );
      ((Element)v.get(243)).setAttribute("cod","1310" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));

      /* Elemento padre:243 / Elemento actual: 244   */
      v.add(doc.createTextNode("Y"));
      ((Element)v.get(243)).appendChild((Text)v.get(244));

      /* Termina nodo Texto:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:245 / Elemento padre: 242   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(245)).setAttribute("valor","N" );
      ((Element)v.get(245)).setAttribute("check","N" );
      ((Element)v.get(245)).setAttribute("onfocus","" );
      ((Element)v.get(245)).setAttribute("id","datosCampos" );
      ((Element)v.get(245)).setAttribute("cod","1311" );
      ((Element)v.get(242)).appendChild((Element)v.get(245));

      /* Elemento padre:245 / Elemento actual: 246   */
      v.add(doc.createTextNode("O"));
      ((Element)v.get(245)).appendChild((Text)v.get(246));

      /* Termina nodo Texto:246   */
      /* Termina nodo:245   */
      /* Termina nodo:242   */
      /* Termina nodo:241   */
      /* Termina nodo:240   */
      /* Termina nodo:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:247 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(248)).setAttribute("src","b.gif" );
      ((Element)v.get(248)).setAttribute("width","25" );
      ((Element)v.get(248)).setAttribute("height","8" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */

      /* Empieza nodo:249 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(216)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(250)).setAttribute("nombre","ckDespachoCompleto" );
      ((Element)v.get(250)).setAttribute("texto","" );
      ((Element)v.get(250)).setAttribute("check","N" );
      ((Element)v.get(250)).setAttribute("validacion","" );
      ((Element)v.get(250)).setAttribute("req","N" );
      ((Element)v.get(250)).setAttribute("id","datosCampos" );
      ((Element)v.get(250)).setAttribute("onshtab","tabGenerico('ckDespachoCompleto','sh');" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */

      /* Empieza nodo:251 / Elemento padre: 216   */
      v.add(doc.createElement("td"));
      ((Element)v.get(251)).setAttribute("width","100%" );
      ((Element)v.get(216)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(252)).setAttribute("src","b.gif" );
      ((Element)v.get(252)).setAttribute("width","8" );
      ((Element)v.get(252)).setAttribute("height","8" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */
      /* Termina nodo:216   */

      /* Empieza nodo:253 / Elemento padre: 192   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(192)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("td"));
      ((Element)v.get(254)).setAttribute("colspan","4" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(255)).setAttribute("src","b.gif" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(255)).setAttribute("width","8" );
      ((Element)v.get(255)).setAttribute("height","8" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */
      /* Termina nodo:253   */
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:256 / Elemento padre: 149   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(149)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("td"));
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("table"));
      ((Element)v.get(258)).setAttribute("width","730" );
      ((Element)v.get(258)).setAttribute("border","0" );
      ((Element)v.get(258)).setAttribute("align","left" );
      ((Element)v.get(258)).setAttribute("cellspacing","0" );
      ((Element)v.get(258)).setAttribute("cellpadding","0" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(258)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("td"));
      ((Element)v.get(259)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(261)).setAttribute("src","b.gif" );
      ((Element)v.get(261)).setAttribute("width","8" );
      ((Element)v.get(261)).setAttribute("height","8" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:262 / Elemento padre: 259   */
      v.add(doc.createElement("td"));
      ((Element)v.get(259)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(263)).setAttribute("nombre","lblDespachoAutomatico" );
      ((Element)v.get(263)).setAttribute("alto","13" );
      ((Element)v.get(263)).setAttribute("filas","1" );
      ((Element)v.get(263)).setAttribute("valor","" );
      ((Element)v.get(263)).setAttribute("id","datosTitle" );
      ((Element)v.get(263)).setAttribute("cod","540" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:264 / Elemento padre: 259   */
      v.add(doc.createElement("td"));
      ((Element)v.get(259)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(265)).setAttribute("src","b.gif" );
      ((Element)v.get(265)).setAttribute("width","25" );
      ((Element)v.get(265)).setAttribute("height","8" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */

      /* Empieza nodo:266 / Elemento padre: 259   */
      v.add(doc.createElement("td"));
      ((Element)v.get(259)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(267)).setAttribute("nombre","lblRecObligPedido" );
      ((Element)v.get(267)).setAttribute("alto","13" );
      ((Element)v.get(267)).setAttribute("filas","1" );
      ((Element)v.get(267)).setAttribute("valor","" );
      ((Element)v.get(267)).setAttribute("id","datosTitle" );
      ((Element)v.get(267)).setAttribute("cod","601" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:268 / Elemento padre: 259   */
      v.add(doc.createElement("td"));
      ((Element)v.get(259)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(269)).setAttribute("src","b.gif" );
      ((Element)v.get(269)).setAttribute("width","25" );
      ((Element)v.get(269)).setAttribute("height","8" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */

      /* Empieza nodo:270 / Elemento padre: 259   */
      v.add(doc.createElement("td"));
      ((Element)v.get(259)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(271)).setAttribute("nombre","lblFormaPago" );
      ((Element)v.get(271)).setAttribute("alto","13" );
      ((Element)v.get(271)).setAttribute("filas","1" );
      ((Element)v.get(271)).setAttribute("valor","" );
      ((Element)v.get(271)).setAttribute("id","datosTitle" );
      ((Element)v.get(271)).setAttribute("cod","541" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */

      /* Empieza nodo:272 / Elemento padre: 259   */
      v.add(doc.createElement("td"));
      ((Element)v.get(272)).setAttribute("width","100%" );
      ((Element)v.get(259)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(273)).setAttribute("src","b.gif" );
      ((Element)v.get(273)).setAttribute("width","8" );
      ((Element)v.get(273)).setAttribute("height","8" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */
      /* Termina nodo:272   */
      /* Termina nodo:259   */

      /* Empieza nodo:274 / Elemento padre: 258   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(258)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(276)).setAttribute("src","b.gif" );
      ((Element)v.get(276)).setAttribute("width","8" );
      ((Element)v.get(276)).setAttribute("height","8" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:277 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(278)).setAttribute("nombre","ckDespachoAutomatico" );
      ((Element)v.get(278)).setAttribute("texto","" );
      ((Element)v.get(278)).setAttribute("check","N" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(278)).setAttribute("validacion","" );
      ((Element)v.get(278)).setAttribute("req","N" );
      ((Element)v.get(278)).setAttribute("id","datosCampos" );
      ((Element)v.get(278)).setAttribute("onshtab","tabGenerico('ckDespachoAutomatico','sh');" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:279 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(280)).setAttribute("src","b.gif" );
      ((Element)v.get(280)).setAttribute("width","25" );
      ((Element)v.get(280)).setAttribute("height","8" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */

      /* Empieza nodo:281 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(282)).setAttribute("nombre","ckRecObligPedido" );
      ((Element)v.get(282)).setAttribute("texto","" );
      ((Element)v.get(282)).setAttribute("check","N" );
      ((Element)v.get(282)).setAttribute("validacion","" );
      ((Element)v.get(282)).setAttribute("req","N" );
      ((Element)v.get(282)).setAttribute("id","datosCampos" );
      ((Element)v.get(282)).setAttribute("ontab","tabGenerico('ckRecObligPedido','tab');" );
      ((Element)v.get(282)).setAttribute("onshtab","tabGenerico('ckRecObligPedido','sh');" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */

      /* Empieza nodo:283 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(284)).setAttribute("src","b.gif" );
      ((Element)v.get(284)).setAttribute("width","25" );
      ((Element)v.get(284)).setAttribute("height","8" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:285 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(285)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(274)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(286)).setAttribute("nombre","cbFormaPago" );
      ((Element)v.get(286)).setAttribute("id","datosCampos" );
      ((Element)v.get(286)).setAttribute("size","1" );
      ((Element)v.get(286)).setAttribute("multiple","N" );
      ((Element)v.get(286)).setAttribute("req","N" );
      ((Element)v.get(286)).setAttribute("valorinicial","" );
      ((Element)v.get(286)).setAttribute("textoinicial","" );
      ((Element)v.get(286)).setAttribute("onshtab","tabGenerico('cbFormaPago','sh');" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:286   */
      /* Termina nodo:285   */

      /* Empieza nodo:288 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(289)).setAttribute("src","b.gif" );
      ((Element)v.get(289)).setAttribute("width","25" );
      ((Element)v.get(289)).setAttribute("height","8" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:288   */

      /* Empieza nodo:290 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(291)).setAttribute("nombre","btnGrupos" );
      ((Element)v.get(291)).setAttribute("ID","botonContenido" );
      ((Element)v.get(291)).setAttribute("tipo","html" );
      ((Element)v.get(291)).setAttribute("estado","false" );
      ((Element)v.get(291)).setAttribute("cod","545" );
      ((Element)v.get(291)).setAttribute("accion","accionDefinirGrupos();" );
      ((Element)v.get(291)).setAttribute("ontab","tabGenerico('btnGrupos','tab');" );
      ((Element)v.get(291)).setAttribute("onshtab","tabGenerico('btnGrupos','sh');" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */

      /* Empieza nodo:292 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(293)).setAttribute("src","b.gif" );
      ((Element)v.get(293)).setAttribute("width","25" );
      ((Element)v.get(293)).setAttribute("height","8" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:294 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(295)).setAttribute("nombre","btnCondicion" );
      ((Element)v.get(295)).setAttribute("ID","botonContenido" );
      ((Element)v.get(295)).setAttribute("tipo","html" );
      ((Element)v.get(295)).setAttribute("estado","false" );
      ((Element)v.get(295)).setAttribute("cod","542" );
      ((Element)v.get(295)).setAttribute("accion","accionDefinirCondicion();" );
      ((Element)v.get(295)).setAttribute("ontab","tabGenerico('btnCondicion','tab');" );
      ((Element)v.get(295)).setAttribute("onshtab","tabGenerico('btnCondicion','sh');" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */

      /* Empieza nodo:296 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(297)).setAttribute("src","b.gif" );
      ((Element)v.get(297)).setAttribute("width","25" );
      ((Element)v.get(297)).setAttribute("height","8" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(296)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:296   */

      /* Empieza nodo:298 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(274)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(299)).setAttribute("nombre","btnRanking" );
      ((Element)v.get(299)).setAttribute("ID","botonContenido" );
      ((Element)v.get(299)).setAttribute("tipo","html" );
      ((Element)v.get(299)).setAttribute("estado","false" );
      ((Element)v.get(299)).setAttribute("cod","0191" );
      ((Element)v.get(299)).setAttribute("accion","accionEvaluarRanking();" );
      ((Element)v.get(299)).setAttribute("ontab","tabGenerico('btnRanking','tab');" );
      ((Element)v.get(299)).setAttribute("onshtab","tabGenerico('btnRanking','sh');" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */

      /* Empieza nodo:300 / Elemento padre: 274   */
      v.add(doc.createElement("td"));
      ((Element)v.get(300)).setAttribute("width","100%" );
      ((Element)v.get(274)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(301)).setAttribute("src","b.gif" );
      ((Element)v.get(301)).setAttribute("width","8" );
      ((Element)v.get(301)).setAttribute("height","8" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:300   */
      /* Termina nodo:274   */

      /* Empieza nodo:302 / Elemento padre: 258   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(258)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).setAttribute("colspan","4" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(304)).setAttribute("src","b.gif" );
      ((Element)v.get(304)).setAttribute("width","8" );
      ((Element)v.get(304)).setAttribute("height","8" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */
      /* Termina nodo:302   */
      /* Termina nodo:258   */
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:149   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:305 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(306)).setAttribute("src","b.gif" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */
      /* Termina nodo:142   */

      /* Empieza nodo:307 / Elemento padre: 60   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(60)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("td"));
      ((Element)v.get(308)).setAttribute("colspan","4" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(309)).setAttribute("src","b.gif" );
      ((Element)v.get(309)).setAttribute("width","8" );
      ((Element)v.get(309)).setAttribute("height","15" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */
      /* Termina nodo:307   */

      /* Empieza nodo:310 / Elemento padre: 60   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(60)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(312)).setAttribute("src","b.gif" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */

      /* Empieza nodo:313 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(313)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(315)).setAttribute("class","legend" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(316)).setAttribute("nombre","lblDatosCliente" );
      ((Element)v.get(316)).setAttribute("alto","13" );
      ((Element)v.get(316)).setAttribute("filas","1" );
      ((Element)v.get(316)).setAttribute("valor","Datos Búsqueda" );
      ((Element)v.get(316)).setAttribute("id","legend" );
      ((Element)v.get(316)).setAttribute("cod","0091" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:317 / Elemento padre: 314   */
      v.add(doc.createElement("table"));
      ((Element)v.get(317)).setAttribute("width","100%" );
      ((Element)v.get(317)).setAttribute("border","0" );
      ((Element)v.get(317)).setAttribute("align","center" );
      ((Element)v.get(317)).setAttribute("cellspacing","0" );
      ((Element)v.get(317)).setAttribute("cellpadding","0" );
      ((Element)v.get(314)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(317)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("table"));
      ((Element)v.get(320)).setAttribute("width","730" );
      ((Element)v.get(320)).setAttribute("border","0" );
      ((Element)v.get(320)).setAttribute("align","left" );
      ((Element)v.get(320)).setAttribute("cellspacing","0" );
      ((Element)v.get(320)).setAttribute("cellpadding","0" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(320)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("td"));
      ((Element)v.get(322)).setAttribute("colspan","4" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(321)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(323)).setAttribute("src","b.gif" );
      ((Element)v.get(323)).setAttribute("width","8" );
      ((Element)v.get(323)).setAttribute("height","8" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */
      /* Termina nodo:321   */

      /* Empieza nodo:324 / Elemento padre: 320   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(320)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("td"));
      ((Element)v.get(324)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(326)).setAttribute("src","b.gif" );
      ((Element)v.get(326)).setAttribute("width","8" );
      ((Element)v.get(326)).setAttribute("height","8" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:325   */

      /* Empieza nodo:327 / Elemento padre: 324   */
      v.add(doc.createElement("td"));
      ((Element)v.get(324)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(328)).setAttribute("nombre","lblVentaExclusiva" );
      ((Element)v.get(328)).setAttribute("alto","13" );
      ((Element)v.get(328)).setAttribute("filas","1" );
      ((Element)v.get(328)).setAttribute("valor","" );
      ((Element)v.get(328)).setAttribute("id","datosTitle" );
      ((Element)v.get(328)).setAttribute("cod","548" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:327   */

      /* Empieza nodo:329 / Elemento padre: 324   */
      v.add(doc.createElement("td"));
      ((Element)v.get(329)).setAttribute("width","100%" );
      ((Element)v.get(324)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(330)).setAttribute("src","b.gif" );
      ((Element)v.get(330)).setAttribute("width","8" );
      ((Element)v.get(330)).setAttribute("height","8" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:329   */
      /* Termina nodo:324   */

      /* Empieza nodo:331 / Elemento padre: 320   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(320)).appendChild((Element)v.get(331));

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
      ((Element)v.get(331)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(335)).setAttribute("nombre","ckVentaExclusiva" );
      ((Element)v.get(335)).setAttribute("texto","" );
      ((Element)v.get(335)).setAttribute("check","N" );
      ((Element)v.get(335)).setAttribute("validacion","" );
      ((Element)v.get(335)).setAttribute("req","N" );
      ((Element)v.get(335)).setAttribute("id","datosCampos" );
      ((Element)v.get(335)).setAttribute("onclick","cambioVentaExclusiva();" );
      ((Element)v.get(335)).setAttribute("ontab","tabGenerico('ckVentaExclusiva','tab');" );
      ((Element)v.get(335)).setAttribute("onshtab","tabGenerico('ckVentaExclusiva','sh');" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */
      /* Termina nodo:334   */

      /* Empieza nodo:336 / Elemento padre: 331   */
      v.add(doc.createElement("td"));
      ((Element)v.get(336)).setAttribute("width","100%" );
      ((Element)v.get(331)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(337)).setAttribute("src","b.gif" );
      ((Element)v.get(337)).setAttribute("width","8" );
      ((Element)v.get(337)).setAttribute("height","8" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */
      /* Termina nodo:336   */
      /* Termina nodo:331   */

      /* Empieza nodo:338 / Elemento padre: 320   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(320)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("td"));
      ((Element)v.get(339)).setAttribute("colspan","4" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(340)).setAttribute("src","b.gif" );
      ((Element)v.get(340)).setAttribute("width","8" );
      ((Element)v.get(340)).setAttribute("height","8" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */
      /* Termina nodo:338   */
      /* Termina nodo:320   */
      /* Termina nodo:319   */
      /* Termina nodo:318   */

      /* Empieza nodo:341 / Elemento padre: 317   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(317)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("table"));
      ((Element)v.get(343)).setAttribute("width","730" );
      ((Element)v.get(343)).setAttribute("border","0" );
      ((Element)v.get(343)).setAttribute("align","left" );
      ((Element)v.get(343)).setAttribute("cellspacing","0" );
      ((Element)v.get(343)).setAttribute("cellpadding","0" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(343)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("td"));
      ((Element)v.get(344)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(346)).setAttribute("src","b.gif" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(346)).setAttribute("width","8" );
      ((Element)v.get(346)).setAttribute("height","8" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:345   */

      /* Empieza nodo:347 / Elemento padre: 344   */
      v.add(doc.createElement("td"));
      ((Element)v.get(344)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(348)).setAttribute("nombre","lblTipoCliente" );
      ((Element)v.get(348)).setAttribute("alto","13" );
      ((Element)v.get(348)).setAttribute("filas","1" );
      ((Element)v.get(348)).setAttribute("valor","" );
      ((Element)v.get(348)).setAttribute("id","datosTitle" );
      ((Element)v.get(348)).setAttribute("cod","393" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:347   */

      /* Empieza nodo:349 / Elemento padre: 344   */
      v.add(doc.createElement("td"));
      ((Element)v.get(344)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(350)).setAttribute("src","b.gif" );
      ((Element)v.get(350)).setAttribute("width","25" );
      ((Element)v.get(350)).setAttribute("height","8" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:349   */

      /* Empieza nodo:351 / Elemento padre: 344   */
      v.add(doc.createElement("td"));
      ((Element)v.get(344)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(352)).setAttribute("nombre","lblSubtipoCliente" );
      ((Element)v.get(352)).setAttribute("alto","13" );
      ((Element)v.get(352)).setAttribute("filas","1" );
      ((Element)v.get(352)).setAttribute("valor","" );
      ((Element)v.get(352)).setAttribute("id","datosTitle" );
      ((Element)v.get(352)).setAttribute("cod","595" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */
      /* Termina nodo:351   */

      /* Empieza nodo:353 / Elemento padre: 344   */
      v.add(doc.createElement("td"));
      ((Element)v.get(353)).setAttribute("width","100%" );
      ((Element)v.get(344)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(354)).setAttribute("src","b.gif" );
      ((Element)v.get(354)).setAttribute("width","8" );
      ((Element)v.get(354)).setAttribute("height","8" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */
      /* Termina nodo:353   */
      /* Termina nodo:344   */

      /* Empieza nodo:355 / Elemento padre: 343   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(343)).appendChild((Element)v.get(355));

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
      ((Element)v.get(358)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(355)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(359)).setAttribute("nombre","cbTipoCliente" );
      ((Element)v.get(359)).setAttribute("id","datosCampos" );
      ((Element)v.get(359)).setAttribute("size","1" );
      ((Element)v.get(359)).setAttribute("multiple","N" );
      ((Element)v.get(359)).setAttribute("req","N" );
      ((Element)v.get(359)).setAttribute("valorinicial","" );
      ((Element)v.get(359)).setAttribute("textoinicial","" );
      ((Element)v.get(359)).setAttribute("onchange","tipoClienteOnChange();" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(359)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:359   */
      /* Termina nodo:358   */

      /* Empieza nodo:361 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(355)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(362)).setAttribute("src","b.gif" );
      ((Element)v.get(362)).setAttribute("width","25" );
      ((Element)v.get(362)).setAttribute("height","8" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:361   */

      /* Empieza nodo:363 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(363)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(355)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(364)).setAttribute("nombre","cbSubtipoCliente" );
      ((Element)v.get(364)).setAttribute("id","datosCampos" );
      ((Element)v.get(364)).setAttribute("size","1" );
      ((Element)v.get(364)).setAttribute("multiple","N" );
      ((Element)v.get(364)).setAttribute("req","N" );
      ((Element)v.get(364)).setAttribute("valorinicial","" );
      ((Element)v.get(364)).setAttribute("textoinicial","" );
      ((Element)v.get(364)).setAttribute("onchange","subtipoClienteOnChange();" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(364)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */
      /* Termina nodo:364   */
      /* Termina nodo:363   */

      /* Empieza nodo:366 / Elemento padre: 355   */
      v.add(doc.createElement("td"));
      ((Element)v.get(366)).setAttribute("width","100%" );
      ((Element)v.get(355)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(367)).setAttribute("src","b.gif" );
      ((Element)v.get(367)).setAttribute("width","8" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(367)).setAttribute("height","8" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */
      /* Termina nodo:366   */
      /* Termina nodo:355   */

      /* Empieza nodo:368 / Elemento padre: 343   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(343)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("td"));
      ((Element)v.get(369)).setAttribute("colspan","4" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(370)).setAttribute("src","b.gif" );
      ((Element)v.get(370)).setAttribute("width","8" );
      ((Element)v.get(370)).setAttribute("height","8" );
      ((Element)v.get(369)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */
      /* Termina nodo:369   */
      /* Termina nodo:368   */
      /* Termina nodo:343   */
      /* Termina nodo:342   */
      /* Termina nodo:341   */

      /* Empieza nodo:371 / Elemento padre: 317   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(317)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("td"));
      ((Element)v.get(371)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("table"));
      ((Element)v.get(373)).setAttribute("width","730" );
      ((Element)v.get(373)).setAttribute("border","0" );
      ((Element)v.get(373)).setAttribute("align","left" );
      ((Element)v.get(373)).setAttribute("cellspacing","0" );
      ((Element)v.get(373)).setAttribute("cellpadding","0" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(373)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("td"));
      ((Element)v.get(374)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(376)).setAttribute("src","b.gif" );
      ((Element)v.get(376)).setAttribute("width","8" );
      ((Element)v.get(376)).setAttribute("height","8" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */
      /* Termina nodo:375   */

      /* Empieza nodo:377 / Elemento padre: 374   */
      v.add(doc.createElement("td"));
      ((Element)v.get(374)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(378)).setAttribute("nombre","lblTipoClasificacion" );
      ((Element)v.get(378)).setAttribute("alto","13" );
      ((Element)v.get(378)).setAttribute("filas","1" );
      ((Element)v.get(378)).setAttribute("valor","" );
      ((Element)v.get(378)).setAttribute("id","datosTitle" );
      ((Element)v.get(378)).setAttribute("cod","610" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:377   */

      /* Empieza nodo:379 / Elemento padre: 374   */
      v.add(doc.createElement("td"));
      ((Element)v.get(374)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(380)).setAttribute("src","b.gif" );
      ((Element)v.get(380)).setAttribute("width","25" );
      ((Element)v.get(380)).setAttribute("height","8" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */
      /* Termina nodo:379   */

      /* Empieza nodo:381 / Elemento padre: 374   */
      v.add(doc.createElement("td"));
      ((Element)v.get(374)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(382)).setAttribute("nombre","lblClasificacion" );
      ((Element)v.get(382)).setAttribute("alto","13" );
      ((Element)v.get(382)).setAttribute("filas","1" );
      ((Element)v.get(382)).setAttribute("valor","" );
      ((Element)v.get(382)).setAttribute("id","datosTitle" );
      ((Element)v.get(382)).setAttribute("cod","550" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */
      /* Termina nodo:381   */

      /* Empieza nodo:383 / Elemento padre: 374   */
      v.add(doc.createElement("td"));
      ((Element)v.get(383)).setAttribute("width","100%" );
      ((Element)v.get(374)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(384)).setAttribute("src","b.gif" );
      ((Element)v.get(384)).setAttribute("width","8" );
      ((Element)v.get(384)).setAttribute("height","8" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */
      /* Termina nodo:383   */
      /* Termina nodo:374   */

      /* Empieza nodo:385 / Elemento padre: 373   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(373)).appendChild((Element)v.get(385));

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
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(389)).setAttribute("nombre","cbTipoClasificacion" );
      ((Element)v.get(389)).setAttribute("id","datosCampos" );
      ((Element)v.get(389)).setAttribute("size","1" );
      ((Element)v.get(389)).setAttribute("multiple","N" );
      ((Element)v.get(389)).setAttribute("req","N" );
      ((Element)v.get(389)).setAttribute("valorinicial","" );
      ((Element)v.get(389)).setAttribute("textoinicial","" );
      ((Element)v.get(389)).setAttribute("onchange","tipoClasificacionOnChange();" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("ROWSET"));
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(389)).appendChild((Element)v.get(390));
      /* Termina nodo:390   */
      /* Termina nodo:389   */
      /* Termina nodo:388   */

      /* Empieza nodo:391 / Elemento padre: 385   */
      v.add(doc.createElement("td"));
      ((Element)v.get(385)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(392)).setAttribute("src","b.gif" );
      ((Element)v.get(392)).setAttribute("width","25" );
      ((Element)v.get(392)).setAttribute("height","8" );
      ((Element)v.get(391)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */
      /* Termina nodo:391   */

      /* Empieza nodo:393 / Elemento padre: 385   */
      v.add(doc.createElement("td"));
      ((Element)v.get(393)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(385)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(394)).setAttribute("nombre","cbClasificacion" );
      ((Element)v.get(394)).setAttribute("id","datosCampos" );
      ((Element)v.get(394)).setAttribute("size","1" );
      ((Element)v.get(394)).setAttribute("multiple","N" );
      ((Element)v.get(394)).setAttribute("req","N" );
      ((Element)v.get(394)).setAttribute("valorinicial","" );
      ((Element)v.get(394)).setAttribute("textoinicial","" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(394)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */
      /* Termina nodo:394   */
      /* Termina nodo:393   */

      /* Empieza nodo:396 / Elemento padre: 385   */
      v.add(doc.createElement("td"));
      ((Element)v.get(396)).setAttribute("width","100%" );
      ((Element)v.get(385)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(397)).setAttribute("src","b.gif" );
      ((Element)v.get(397)).setAttribute("width","8" );
      ((Element)v.get(397)).setAttribute("height","8" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */
      /* Termina nodo:396   */
      /* Termina nodo:385   */

      /* Empieza nodo:398 / Elemento padre: 373   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(373)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("td"));
      ((Element)v.get(399)).setAttribute("colspan","4" );
      ((Element)v.get(398)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(400)).setAttribute("src","b.gif" );
      ((Element)v.get(400)).setAttribute("width","8" );
      ((Element)v.get(400)).setAttribute("height","8" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));
      /* Termina nodo:400   */
      /* Termina nodo:399   */
      /* Termina nodo:398   */
      /* Termina nodo:373   */
      /* Termina nodo:372   */
      /* Termina nodo:371   */

      /* Empieza nodo:401 / Elemento padre: 317   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(317)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("td"));
      ((Element)v.get(401)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("table"));
      ((Element)v.get(403)).setAttribute("width","730" );
      ((Element)v.get(403)).setAttribute("border","0" );
      ((Element)v.get(403)).setAttribute("align","left" );
      ((Element)v.get(403)).setAttribute("cellspacing","0" );
      ((Element)v.get(403)).setAttribute("cellpadding","0" );
      ((Element)v.get(402)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(403)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("td"));
      ((Element)v.get(404)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(406)).setAttribute("src","b.gif" );
      ((Element)v.get(406)).setAttribute("width","8" );
      ((Element)v.get(406)).setAttribute("height","8" );
      ((Element)v.get(405)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */
      /* Termina nodo:405   */

      /* Empieza nodo:407 / Elemento padre: 404   */
      v.add(doc.createElement("td"));
      ((Element)v.get(404)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(408)).setAttribute("nombre","lblEstatusCliente" );
      ((Element)v.get(408)).setAttribute("alto","13" );
      ((Element)v.get(408)).setAttribute("filas","1" );
      ((Element)v.get(408)).setAttribute("valor","" );
      ((Element)v.get(408)).setAttribute("id","datosTitle" );
      ((Element)v.get(408)).setAttribute("cod","612" );
      ((Element)v.get(407)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */
      /* Termina nodo:407   */

      /* Empieza nodo:409 / Elemento padre: 404   */
      v.add(doc.createElement("td"));
      ((Element)v.get(404)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(410)).setAttribute("src","b.gif" );
      ((Element)v.get(410)).setAttribute("width","25" );
      ((Element)v.get(410)).setAttribute("height","8" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */
      /* Termina nodo:409   */

      /* Empieza nodo:411 / Elemento padre: 404   */
      v.add(doc.createElement("td"));
      ((Element)v.get(404)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(412)).setAttribute("nombre","lblEstatus2" );
      ((Element)v.get(412)).setAttribute("alto","13" );
      ((Element)v.get(412)).setAttribute("filas","1" );
      ((Element)v.get(412)).setAttribute("valor","" );
      ((Element)v.get(412)).setAttribute("id","datosTitle" );
      ((Element)v.get(412)).setAttribute("cod","552" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */
      /* Termina nodo:411   */

      /* Empieza nodo:413 / Elemento padre: 404   */
      v.add(doc.createElement("td"));
      ((Element)v.get(413)).setAttribute("width","100%" );
      ((Element)v.get(404)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
   }

   private void getXML1710(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(414)).setAttribute("src","b.gif" );
      ((Element)v.get(414)).setAttribute("width","8" );
      ((Element)v.get(414)).setAttribute("height","8" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */
      /* Termina nodo:413   */
      /* Termina nodo:404   */

      /* Empieza nodo:415 / Elemento padre: 403   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(403)).appendChild((Element)v.get(415));

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
      ((Element)v.get(415)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(419)).setAttribute("nombre","cbEstatusCliente" );
      ((Element)v.get(419)).setAttribute("id","datosCampos" );
      ((Element)v.get(419)).setAttribute("size","1" );
      ((Element)v.get(419)).setAttribute("multiple","N" );
      ((Element)v.get(419)).setAttribute("req","N" );
      ((Element)v.get(419)).setAttribute("valorinicial","" );
      ((Element)v.get(419)).setAttribute("textoinicial","" );
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
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(424)).setAttribute("nombre","txtEstatus2" );
      ((Element)v.get(424)).setAttribute("id","datosCampos" );
      ((Element)v.get(424)).setAttribute("size","2" );
      ((Element)v.get(424)).setAttribute("max","1" );
      ((Element)v.get(424)).setAttribute("valor","" );
      ((Element)v.get(424)).setAttribute("req","N" );
      ((Element)v.get(424)).setAttribute("ontab","tabGenerico('txtEstatus2','tab');" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */
      /* Termina nodo:423   */

      /* Empieza nodo:425 / Elemento padre: 415   */
      v.add(doc.createElement("td"));
      ((Element)v.get(425)).setAttribute("width","100%" );
      ((Element)v.get(415)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(426)).setAttribute("src","b.gif" );
      ((Element)v.get(426)).setAttribute("width","8" );
      ((Element)v.get(426)).setAttribute("height","8" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));
      /* Termina nodo:426   */
      /* Termina nodo:425   */
      /* Termina nodo:415   */

      /* Empieza nodo:427 / Elemento padre: 403   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(403)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("td"));
      ((Element)v.get(428)).setAttribute("colspan","4" );
      ((Element)v.get(427)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(429)).setAttribute("src","b.gif" );
      ((Element)v.get(429)).setAttribute("width","8" );
      ((Element)v.get(429)).setAttribute("height","8" );
      ((Element)v.get(428)).appendChild((Element)v.get(429));
      /* Termina nodo:429   */
      /* Termina nodo:428   */
      /* Termina nodo:427   */

      /* Empieza nodo:430 / Elemento padre: 403   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(403)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("td"));
      ((Element)v.get(430)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(432)).setAttribute("src","b.gif" );
      ((Element)v.get(432)).setAttribute("width","8" );
      ((Element)v.get(432)).setAttribute("height","8" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));
      /* Termina nodo:432   */
      /* Termina nodo:431   */

      /* Empieza nodo:433 / Elemento padre: 430   */
      v.add(doc.createElement("td"));
      ((Element)v.get(430)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(434)).setAttribute("nombre","rbRegion" );
      ((Element)v.get(434)).setAttribute("tipo","H" );
      ((Element)v.get(434)).setAttribute("id","datosCampos" );
      ((Element)v.get(434)).setAttribute("ontab","" );
      ((Element)v.get(434)).setAttribute("onshtab","" );
      ((Element)v.get(434)).setAttribute("onclick","onClickRegion()" );
      ((Element)v.get(433)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(435)).setAttribute("valor","S" );
      ((Element)v.get(435)).setAttribute("onfocus","" );
      ((Element)v.get(435)).setAttribute("id","datosCampos" );
      ((Element)v.get(435)).setAttribute("cod","109" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */
      /* Termina nodo:434   */
      /* Termina nodo:433   */

      /* Empieza nodo:436 / Elemento padre: 430   */
   }

   private void getXML1800(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(430)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(437)).setAttribute("src","b.gif" );
      ((Element)v.get(437)).setAttribute("width","25" );
      ((Element)v.get(437)).setAttribute("height","8" );
      ((Element)v.get(436)).appendChild((Element)v.get(437));
      /* Termina nodo:437   */
      /* Termina nodo:436   */

      /* Empieza nodo:438 / Elemento padre: 430   */
      v.add(doc.createElement("td"));
      ((Element)v.get(430)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(439)).setAttribute("nombre","rbZona" );
      ((Element)v.get(439)).setAttribute("tipo","H" );
      ((Element)v.get(439)).setAttribute("id","datosCampos" );
      ((Element)v.get(439)).setAttribute("ontab","" );
      ((Element)v.get(439)).setAttribute("onshtab","" );
      ((Element)v.get(439)).setAttribute("onclick","onClickZona()" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(440)).setAttribute("valor","N" );
      ((Element)v.get(440)).setAttribute("onfocus","" );
      ((Element)v.get(440)).setAttribute("id","datosCampos" );
      ((Element)v.get(440)).setAttribute("cod","143" );
      ((Element)v.get(439)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */
      /* Termina nodo:439   */
      /* Termina nodo:438   */

      /* Empieza nodo:441 / Elemento padre: 430   */
      v.add(doc.createElement("td"));
      ((Element)v.get(441)).setAttribute("width","100%" );
      ((Element)v.get(430)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(442)).setAttribute("src","b.gif" );
      ((Element)v.get(442)).setAttribute("width","8" );
      ((Element)v.get(442)).setAttribute("height","8" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */
      /* Termina nodo:441   */
      /* Termina nodo:430   */

      /* Empieza nodo:443 / Elemento padre: 403   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(403)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("td"));
      ((Element)v.get(443)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(445)).setAttribute("src","b.gif" );
      ((Element)v.get(445)).setAttribute("width","8" );
      ((Element)v.get(445)).setAttribute("height","8" );
      ((Element)v.get(444)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */
      /* Termina nodo:444   */

      /* Empieza nodo:446 / Elemento padre: 443   */
      v.add(doc.createElement("td"));
      ((Element)v.get(446)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(446)).setAttribute("valign","top" );
      ((Element)v.get(443)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(447)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(447)).setAttribute("id","datosCampos" );
      ((Element)v.get(447)).setAttribute("size","5" );
      ((Element)v.get(447)).setAttribute("multiple","S" );
      ((Element)v.get(447)).setAttribute("req","N" );
      ((Element)v.get(447)).setAttribute("valorinicial","" );
      ((Element)v.get(447)).setAttribute("onchange","" );
      ((Element)v.get(447)).setAttribute("textoinicial","" );
      ((Element)v.get(446)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(447)).appendChild((Element)v.get(448));
      /* Termina nodo:448   */
      /* Termina nodo:447   */
      /* Termina nodo:446   */

      /* Empieza nodo:449 / Elemento padre: 443   */
      v.add(doc.createElement("td"));
      ((Element)v.get(443)).appendChild((Element)v.get(449));

      /* Empieza nodo:450 / Elemento padre: 449   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(450)).setAttribute("src","b.gif" );
      ((Element)v.get(450)).setAttribute("width","25" );
      ((Element)v.get(450)).setAttribute("height","8" );
      ((Element)v.get(449)).appendChild((Element)v.get(450));
      /* Termina nodo:450   */
      /* Termina nodo:449   */

      /* Empieza nodo:451 / Elemento padre: 443   */
      v.add(doc.createElement("td"));
      ((Element)v.get(451)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(451)).setAttribute("valign","top" );
      ((Element)v.get(443)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(452)).setAttribute("nombre","cbZona" );
      ((Element)v.get(452)).setAttribute("id","datosCampos" );
      ((Element)v.get(452)).setAttribute("size","5" );
      ((Element)v.get(452)).setAttribute("multiple","S" );
      ((Element)v.get(452)).setAttribute("req","N" );
      ((Element)v.get(452)).setAttribute("valorinicial","" );
      ((Element)v.get(452)).setAttribute("textoinicial","" );
      ((Element)v.get(451)).appendChild((Element)v.get(452));

      /* Empieza nodo:453 / Elemento padre: 452   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(452)).appendChild((Element)v.get(453));
      /* Termina nodo:453   */
      /* Termina nodo:452   */
      /* Termina nodo:451   */

      /* Empieza nodo:454 / Elemento padre: 443   */
      v.add(doc.createElement("td"));
      ((Element)v.get(454)).setAttribute("width","100%" );
      ((Element)v.get(443)).appendChild((Element)v.get(454));

      /* Empieza nodo:455 / Elemento padre: 454   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(455)).setAttribute("src","b.gif" );
      ((Element)v.get(455)).setAttribute("width","8" );
      ((Element)v.get(455)).setAttribute("height","8" );
      ((Element)v.get(454)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */
      /* Termina nodo:454   */
      /* Termina nodo:443   */

      /* Empieza nodo:456 / Elemento padre: 403   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(403)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("td"));
      ((Element)v.get(457)).setAttribute("colspan","4" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(456)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(458)).setAttribute("src","b.gif" );
      ((Element)v.get(458)).setAttribute("width","8" );
      ((Element)v.get(458)).setAttribute("height","8" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */
      /* Termina nodo:457   */
      /* Termina nodo:456   */
      /* Termina nodo:403   */
      /* Termina nodo:402   */
      /* Termina nodo:401   */
      /* Termina nodo:317   */
      /* Termina nodo:314   */
      /* Termina nodo:313   */
      /* Termina nodo:310   */

      /* Empieza nodo:459 / Elemento padre: 60   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(60)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("td"));
      ((Element)v.get(459)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(461)).setAttribute("src","b.gif" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));
      /* Termina nodo:461   */
      /* Termina nodo:460   */

      /* Empieza nodo:462 / Elemento padre: 459   */
      v.add(doc.createElement("td"));
      ((Element)v.get(459)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(462)).appendChild((Element)v.get(463));

      /* Empieza nodo:464 / Elemento padre: 463   */
      v.add(doc.createElement("table"));
      ((Element)v.get(464)).setAttribute("width","100%" );
      ((Element)v.get(464)).setAttribute("border","0" );
      ((Element)v.get(464)).setAttribute("align","center" );
      ((Element)v.get(464)).setAttribute("cellspacing","0" );
      ((Element)v.get(464)).setAttribute("cellpadding","0" );
      ((Element)v.get(463)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(464)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("td"));
      ((Element)v.get(466)).setAttribute("class","botonera" );
      ((Element)v.get(465)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(467)).setAttribute("nombre","btnAnadir" );
      ((Element)v.get(467)).setAttribute("ID","botonContenido" );
      ((Element)v.get(467)).setAttribute("tipo","html" );
      ((Element)v.get(467)).setAttribute("accion","accionAniadirVentaExclusiva();" );
      ((Element)v.get(467)).setAttribute("estado","false" );
      ((Element)v.get(467)).setAttribute("cod","404" );
      ((Element)v.get(467)).setAttribute("ontab","tabGenerico('btnAnadir','tab');" );
      ((Element)v.get(467)).setAttribute("onshtab","tabGenerico('btnAnadir','sh');" );
      ((Element)v.get(466)).appendChild((Element)v.get(467));
      /* Termina nodo:467   */
      /* Termina nodo:466   */
      /* Termina nodo:465   */
      /* Termina nodo:464   */
      /* Termina nodo:463   */
      /* Termina nodo:462   */

      /* Empieza nodo:468 / Elemento padre: 459   */
      v.add(doc.createElement("td"));
      ((Element)v.get(459)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(469)).setAttribute("src","b.gif" );
      ((Element)v.get(469)).setAttribute("width","8" );
      ((Element)v.get(469)).setAttribute("height","12" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));
      /* Termina nodo:469   */
      /* Termina nodo:468   */
      /* Termina nodo:459   */

      /* Empieza nodo:470 / Elemento padre: 60   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(60)).appendChild((Element)v.get(470));

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
      ((Element)v.get(473)).setAttribute("width","750" );
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
      /* Termina nodo:60   */

      /* Empieza nodo:477 / Elemento padre: 59   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(477)).setAttribute("nombre","listado1" );
      ((Element)v.get(477)).setAttribute("ancho","733" );
      ((Element)v.get(477)).setAttribute("alto","108" );
      ((Element)v.get(477)).setAttribute("x","12" );
      ((Element)v.get(477)).setAttribute("y","138" );
      ((Element)v.get(477)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(477)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(59)).appendChild((Element)v.get(477));

      /* Empieza nodo:478 / Elemento padre: 477   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(478)).setAttribute("precarga","S" );
      ((Element)v.get(478)).setAttribute("conROver","S" );
      ((Element)v.get(477)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(479)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(479)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(479)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(479)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(478)).appendChild((Element)v.get(479));
      /* Termina nodo:479   */

      /* Empieza nodo:480 / Elemento padre: 478   */
   }

   private void getXML1980(Document doc) {
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(480)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(480)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(480)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(480)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(478)).appendChild((Element)v.get(480));
      /* Termina nodo:480   */

      /* Empieza nodo:481 / Elemento padre: 478   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(481)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(481)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(478)).appendChild((Element)v.get(481));
      /* Termina nodo:481   */
      /* Termina nodo:478   */

      /* Empieza nodo:482 / Elemento padre: 477   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(477)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(483)).setAttribute("borde","1" );
      ((Element)v.get(483)).setAttribute("horizDatos","1" );
      ((Element)v.get(483)).setAttribute("horizCabecera","1" );
      ((Element)v.get(483)).setAttribute("vertical","1" );
      ((Element)v.get(483)).setAttribute("horizTitulo","1" );
      ((Element)v.get(483)).setAttribute("horizBase","1" );
      ((Element)v.get(482)).appendChild((Element)v.get(483));
      /* Termina nodo:483   */

      /* Empieza nodo:484 / Elemento padre: 482   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(484)).setAttribute("borde","#999999" );
      ((Element)v.get(484)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(484)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(484)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(484)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(484)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(484)).setAttribute("horizBase","#999999" );
      ((Element)v.get(482)).appendChild((Element)v.get(484));
      /* Termina nodo:484   */
      /* Termina nodo:482   */

      /* Empieza nodo:485 / Elemento padre: 477   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(485)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(485)).setAttribute("alto","22" );
      ((Element)v.get(485)).setAttribute("imgFondo","" );
      ((Element)v.get(485)).setAttribute("cod","0014" );
      ((Element)v.get(485)).setAttribute("ID","datosTitle" );
      ((Element)v.get(477)).appendChild((Element)v.get(485));
      /* Termina nodo:485   */

      /* Empieza nodo:486 / Elemento padre: 477   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(486)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(486)).setAttribute("alto","22" );
      ((Element)v.get(486)).setAttribute("imgFondo","" );
      ((Element)v.get(477)).appendChild((Element)v.get(486));
      /* Termina nodo:486   */

      /* Empieza nodo:487 / Elemento padre: 477   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(487)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(487)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(487)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(487)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(487)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(487)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(477)).appendChild((Element)v.get(487));

      /* Empieza nodo:488 / Elemento padre: 487   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(488)).setAttribute("ancho","100" );
      ((Element)v.get(488)).setAttribute("minimizable","S" );
      ((Element)v.get(488)).setAttribute("minimizada","N" );
      ((Element)v.get(487)).appendChild((Element)v.get(488));
      /* Termina nodo:488   */

      /* Empieza nodo:489 / Elemento padre: 487   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(489)).setAttribute("ancho","100" );
      ((Element)v.get(489)).setAttribute("minimizable","S" );
      ((Element)v.get(489)).setAttribute("minimizada","N" );
      ((Element)v.get(487)).appendChild((Element)v.get(489));
      /* Termina nodo:489   */

      /* Empieza nodo:490 / Elemento padre: 487   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(490)).setAttribute("ancho","100" );
      ((Element)v.get(490)).setAttribute("minimizable","S" );
      ((Element)v.get(490)).setAttribute("minimizada","N" );
      ((Element)v.get(487)).appendChild((Element)v.get(490));
      /* Termina nodo:490   */

      /* Empieza nodo:491 / Elemento padre: 487   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(491)).setAttribute("ancho","70" );
      ((Element)v.get(491)).setAttribute("minimizable","S" );
      ((Element)v.get(491)).setAttribute("minimizada","N" );
      ((Element)v.get(487)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */

      /* Empieza nodo:492 / Elemento padre: 487   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(492)).setAttribute("ancho","130" );
      ((Element)v.get(492)).setAttribute("minimizable","S" );
      ((Element)v.get(492)).setAttribute("minimizada","N" );
      ((Element)v.get(487)).appendChild((Element)v.get(492));
      /* Termina nodo:492   */

      /* Empieza nodo:493 / Elemento padre: 487   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(493)).setAttribute("ancho","100" );
      ((Element)v.get(493)).setAttribute("minimizable","S" );
      ((Element)v.get(493)).setAttribute("minimizada","N" );
      ((Element)v.get(487)).appendChild((Element)v.get(493));
      /* Termina nodo:493   */

      /* Empieza nodo:494 / Elemento padre: 487   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(494)).setAttribute("ancho","80" );
      ((Element)v.get(494)).setAttribute("minimizable","S" );
      ((Element)v.get(494)).setAttribute("minimizada","N" );
      ((Element)v.get(487)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */

      /* Empieza nodo:495 / Elemento padre: 487   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(495)).setAttribute("ancho","80" );
      ((Element)v.get(495)).setAttribute("minimizable","S" );
      ((Element)v.get(495)).setAttribute("minimizada","N" );
      ((Element)v.get(487)).appendChild((Element)v.get(495));
      /* Termina nodo:495   */

      /* Empieza nodo:496 / Elemento padre: 487   */
      v.add(doc.createElement("COL"));
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(496)).setAttribute("ancho","80" );
      ((Element)v.get(496)).setAttribute("minimizable","S" );
      ((Element)v.get(496)).setAttribute("minimizada","N" );
      ((Element)v.get(487)).appendChild((Element)v.get(496));
      /* Termina nodo:496   */
      /* Termina nodo:487   */

      /* Empieza nodo:497 / Elemento padre: 477   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(497)).setAttribute("alto","20" );
      ((Element)v.get(497)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(497)).setAttribute("imgFondo","" );
      ((Element)v.get(497)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(477)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(498)).setAttribute("colFondo","" );
      ((Element)v.get(498)).setAttribute("ID","EstCab" );
      ((Element)v.get(498)).setAttribute("cod","8" );
      ((Element)v.get(497)).appendChild((Element)v.get(498));

      /* Elemento padre:498 / Elemento actual: 499   */
      v.add(doc.createTextNode("Código"));
      ((Element)v.get(498)).appendChild((Text)v.get(499));

      /* Termina nodo Texto:499   */
      /* Termina nodo:498   */

      /* Empieza nodo:500 / Elemento padre: 497   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(500)).setAttribute("colFondo","" );
      ((Element)v.get(500)).setAttribute("ID","EstCab" );
      ((Element)v.get(500)).setAttribute("cod","9" );
      ((Element)v.get(497)).appendChild((Element)v.get(500));

      /* Elemento padre:500 / Elemento actual: 501   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(500)).appendChild((Text)v.get(501));

      /* Termina nodo Texto:501   */
      /* Termina nodo:500   */

      /* Empieza nodo:502 / Elemento padre: 497   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(502)).setAttribute("colFondo","" );
      ((Element)v.get(502)).setAttribute("ID","EstCab" );
      ((Element)v.get(502)).setAttribute("cod","608" );
      ((Element)v.get(497)).appendChild((Element)v.get(502));

      /* Elemento padre:502 / Elemento actual: 503   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(502)).appendChild((Text)v.get(503));

      /* Termina nodo Texto:503   */
      /* Termina nodo:502   */

      /* Empieza nodo:504 / Elemento padre: 497   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(504)).setAttribute("colFondo","" );
      ((Element)v.get(504)).setAttribute("ID","EstCab" );
      ((Element)v.get(504)).setAttribute("cod","581" );
      ((Element)v.get(497)).appendChild((Element)v.get(504));

      /* Elemento padre:504 / Elemento actual: 505   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(504)).appendChild((Text)v.get(505));

      /* Termina nodo Texto:505   */
      /* Termina nodo:504   */

      /* Empieza nodo:506 / Elemento padre: 497   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(506)).setAttribute("colFondo","" );
      ((Element)v.get(506)).setAttribute("ID","EstCab" );
      ((Element)v.get(506)).setAttribute("cod","529" );
      ((Element)v.get(497)).appendChild((Element)v.get(506));

      /* Elemento padre:506 / Elemento actual: 507   */
      v.add(doc.createTextNode("Factor repetición"));
      ((Element)v.get(506)).appendChild((Text)v.get(507));

      /* Termina nodo Texto:507   */
      /* Termina nodo:506   */

      /* Empieza nodo:508 / Elemento padre: 497   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(508)).setAttribute("colFondo","" );
      ((Element)v.get(508)).setAttribute("ID","EstCab" );
      ((Element)v.get(508)).setAttribute("cod","530" );
      ((Element)v.get(497)).appendChild((Element)v.get(508));

      /* Elemento padre:508 / Elemento actual: 509   */
      v.add(doc.createTextNode("Precio unitario"));
      ((Element)v.get(508)).appendChild((Text)v.get(509));

      /* Termina nodo Texto:509   */
      /* Termina nodo:508   */

      /* Empieza nodo:510 / Elemento padre: 497   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(510)).setAttribute("colFondo","" );
      ((Element)v.get(510)).setAttribute("ID","EstCab" );
      ((Element)v.get(510)).setAttribute("cod","481" );
      ((Element)v.get(497)).appendChild((Element)v.get(510));

      /* Elemento padre:510 / Elemento actual: 511   */
      v.add(doc.createTextNode("Atributo 1"));
      ((Element)v.get(510)).appendChild((Text)v.get(511));

      /* Termina nodo Texto:511   */
      /* Termina nodo:510   */

      /* Empieza nodo:512 / Elemento padre: 497   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(512)).setAttribute("colFondo","" );
      ((Element)v.get(512)).setAttribute("ID","EstCab" );
      ((Element)v.get(512)).setAttribute("cod","482" );
      ((Element)v.get(497)).appendChild((Element)v.get(512));

      /* Elemento padre:512 / Elemento actual: 513   */
      v.add(doc.createTextNode("Atributo 2"));
      ((Element)v.get(512)).appendChild((Text)v.get(513));

      /* Termina nodo Texto:513   */
      /* Termina nodo:512   */

      /* Empieza nodo:514 / Elemento padre: 497   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(514)).setAttribute("colFondo","" );
      ((Element)v.get(514)).setAttribute("ID","EstCab" );
      ((Element)v.get(514)).setAttribute("cod","483" );
      ((Element)v.get(497)).appendChild((Element)v.get(514));

      /* Elemento padre:514 / Elemento actual: 515   */
      v.add(doc.createTextNode("Atributo 3"));
      ((Element)v.get(514)).appendChild((Text)v.get(515));

      /* Termina nodo Texto:515   */
      /* Termina nodo:514   */
      /* Termina nodo:497   */

      /* Empieza nodo:516 / Elemento padre: 477   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(516)).setAttribute("alto","22" );
      ((Element)v.get(516)).setAttribute("accion","" );
      ((Element)v.get(516)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(516)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(516)).setAttribute("maxSel","-1" );
      ((Element)v.get(516)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(516)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(516)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(516)).setAttribute("onLoad","" );
      ((Element)v.get(516)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(477)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(517)).setAttribute("tipo","texto" );
      ((Element)v.get(517)).setAttribute("ID","EstDat" );
      ((Element)v.get(516)).appendChild((Element)v.get(517));
      /* Termina nodo:517   */

      /* Empieza nodo:518 / Elemento padre: 516   */
      v.add(doc.createElement("COL"));
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(518)).setAttribute("tipo","texto" );
      ((Element)v.get(518)).setAttribute("ID","EstDat2" );
      ((Element)v.get(516)).appendChild((Element)v.get(518));
      /* Termina nodo:518   */

      /* Empieza nodo:519 / Elemento padre: 516   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(519)).setAttribute("tipo","texto" );
      ((Element)v.get(519)).setAttribute("ID","EstDat" );
      ((Element)v.get(516)).appendChild((Element)v.get(519));
      /* Termina nodo:519   */

      /* Empieza nodo:520 / Elemento padre: 516   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(520)).setAttribute("tipo","texto" );
      ((Element)v.get(520)).setAttribute("ID","EstDat2" );
      ((Element)v.get(516)).appendChild((Element)v.get(520));
      /* Termina nodo:520   */

      /* Empieza nodo:521 / Elemento padre: 516   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(521)).setAttribute("tipo","texto" );
      ((Element)v.get(521)).setAttribute("ID","EstDat2" );
      ((Element)v.get(516)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */

      /* Empieza nodo:522 / Elemento padre: 516   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(522)).setAttribute("tipo","texto" );
      ((Element)v.get(522)).setAttribute("ID","EstDat" );
      ((Element)v.get(516)).appendChild((Element)v.get(522));
      /* Termina nodo:522   */

      /* Empieza nodo:523 / Elemento padre: 516   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(523)).setAttribute("tipo","texto" );
      ((Element)v.get(523)).setAttribute("ID","EstDat2" );
      ((Element)v.get(516)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */

      /* Empieza nodo:524 / Elemento padre: 516   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(524)).setAttribute("tipo","texto" );
      ((Element)v.get(524)).setAttribute("ID","EstDat" );
      ((Element)v.get(516)).appendChild((Element)v.get(524));
      /* Termina nodo:524   */

      /* Empieza nodo:525 / Elemento padre: 516   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(525)).setAttribute("tipo","texto" );
      ((Element)v.get(525)).setAttribute("ID","EstDat2" );
      ((Element)v.get(516)).appendChild((Element)v.get(525));
      /* Termina nodo:525   */
      /* Termina nodo:516   */

      /* Empieza nodo:526 / Elemento padre: 477   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(477)).appendChild((Element)v.get(526));
      /* Termina nodo:526   */
      /* Termina nodo:477   */

      /* Empieza nodo:527 / Elemento padre: 59   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(527)).setAttribute("nombre","Buscar1" );
      ((Element)v.get(527)).setAttribute("x","13" );
      ((Element)v.get(527)).setAttribute("y","224" );
      ((Element)v.get(527)).setAttribute("ID","botonContenido" );
      ((Element)v.get(527)).setAttribute("tipo","html" );
      ((Element)v.get(527)).setAttribute("estado","false" );
      ((Element)v.get(527)).setAttribute("cod","1" );
      ((Element)v.get(527)).setAttribute("accion","accionBuscarProductoPrincipal();" );
      ((Element)v.get(527)).setAttribute("ontab","tabGenerico('Buscar1','tab');" );
      ((Element)v.get(527)).setAttribute("onshtab","tabGenerico('Buscar1','sh');" );
      ((Element)v.get(59)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */

      /* Empieza nodo:528 / Elemento padre: 59   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(528)).setAttribute("nombre","listado2" );
      ((Element)v.get(528)).setAttribute("ancho","733" );
      ((Element)v.get(528)).setAttribute("alto","317" );
      ((Element)v.get(528)).setAttribute("x","12" );
      ((Element)v.get(528)).setAttribute("y","270" );
      ((Element)v.get(528)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(528)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(59)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(529)).setAttribute("precarga","S" );
      ((Element)v.get(529)).setAttribute("conROver","S" );
      ((Element)v.get(528)).appendChild((Element)v.get(529));

      /* Empieza nodo:530 / Elemento padre: 529   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(530)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(530)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(530)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(530)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(529)).appendChild((Element)v.get(530));
      /* Termina nodo:530   */

      /* Empieza nodo:531 / Elemento padre: 529   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(531)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(531)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(531)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(531)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(529)).appendChild((Element)v.get(531));
      /* Termina nodo:531   */

      /* Empieza nodo:532 / Elemento padre: 529   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(532)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(532)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(529)).appendChild((Element)v.get(532));
      /* Termina nodo:532   */
      /* Termina nodo:529   */

      /* Empieza nodo:533 / Elemento padre: 528   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(528)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(534)).setAttribute("borde","1" );
      ((Element)v.get(534)).setAttribute("horizDatos","1" );
      ((Element)v.get(534)).setAttribute("horizCabecera","1" );
      ((Element)v.get(534)).setAttribute("vertical","1" );
      ((Element)v.get(534)).setAttribute("horizTitulo","1" );
      ((Element)v.get(534)).setAttribute("horizBase","1" );
      ((Element)v.get(533)).appendChild((Element)v.get(534));
      /* Termina nodo:534   */

      /* Empieza nodo:535 / Elemento padre: 533   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(535)).setAttribute("borde","#999999" );
      ((Element)v.get(535)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(535)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(535)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(535)).setAttribute("horizCabecera","#999999" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(535)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(535)).setAttribute("horizBase","#999999" );
      ((Element)v.get(533)).appendChild((Element)v.get(535));
      /* Termina nodo:535   */
      /* Termina nodo:533   */

      /* Empieza nodo:536 / Elemento padre: 528   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(536)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(536)).setAttribute("alto","22" );
      ((Element)v.get(536)).setAttribute("imgFondo","" );
      ((Element)v.get(536)).setAttribute("cod","0012" );
      ((Element)v.get(536)).setAttribute("ID","datosTitle" );
      ((Element)v.get(528)).appendChild((Element)v.get(536));
      /* Termina nodo:536   */

      /* Empieza nodo:537 / Elemento padre: 528   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(537)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(537)).setAttribute("alto","22" );
      ((Element)v.get(537)).setAttribute("imgFondo","" );
      ((Element)v.get(528)).appendChild((Element)v.get(537));
      /* Termina nodo:537   */

      /* Empieza nodo:538 / Elemento padre: 528   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(538)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(538)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(538)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(538)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(538)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(538)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(528)).appendChild((Element)v.get(538));

      /* Empieza nodo:539 / Elemento padre: 538   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(539)).setAttribute("ancho","100" );
      ((Element)v.get(539)).setAttribute("minimizable","S" );
      ((Element)v.get(539)).setAttribute("minimizada","N" );
      ((Element)v.get(538)).appendChild((Element)v.get(539));
      /* Termina nodo:539   */

      /* Empieza nodo:540 / Elemento padre: 538   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(540)).setAttribute("ancho","100" );
      ((Element)v.get(540)).setAttribute("minimizable","S" );
      ((Element)v.get(540)).setAttribute("minimizada","N" );
      ((Element)v.get(538)).appendChild((Element)v.get(540));
      /* Termina nodo:540   */

      /* Empieza nodo:541 / Elemento padre: 538   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(541)).setAttribute("ancho","100" );
      ((Element)v.get(541)).setAttribute("minimizable","S" );
      ((Element)v.get(541)).setAttribute("minimizada","N" );
      ((Element)v.get(538)).appendChild((Element)v.get(541));
      /* Termina nodo:541   */

      /* Empieza nodo:542 / Elemento padre: 538   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(542)).setAttribute("ancho","70" );
      ((Element)v.get(542)).setAttribute("minimizable","S" );
      ((Element)v.get(542)).setAttribute("minimizada","N" );
      ((Element)v.get(538)).appendChild((Element)v.get(542));
      /* Termina nodo:542   */

      /* Empieza nodo:543 / Elemento padre: 538   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(543)).setAttribute("ancho","130" );
      ((Element)v.get(543)).setAttribute("minimizable","S" );
      ((Element)v.get(543)).setAttribute("minimizada","N" );
      ((Element)v.get(538)).appendChild((Element)v.get(543));
      /* Termina nodo:543   */

      /* Empieza nodo:544 / Elemento padre: 538   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(544)).setAttribute("ancho","100" );
      ((Element)v.get(544)).setAttribute("minimizable","S" );
      ((Element)v.get(544)).setAttribute("minimizada","N" );
      ((Element)v.get(538)).appendChild((Element)v.get(544));
      /* Termina nodo:544   */

      /* Empieza nodo:545 / Elemento padre: 538   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(545)).setAttribute("ancho","80" );
      ((Element)v.get(545)).setAttribute("minimizable","S" );
      ((Element)v.get(545)).setAttribute("minimizada","N" );
      ((Element)v.get(538)).appendChild((Element)v.get(545));
      /* Termina nodo:545   */

      /* Empieza nodo:546 / Elemento padre: 538   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(546)).setAttribute("ancho","80" );
      ((Element)v.get(546)).setAttribute("minimizable","S" );
      ((Element)v.get(546)).setAttribute("minimizada","N" );
      ((Element)v.get(538)).appendChild((Element)v.get(546));
      /* Termina nodo:546   */

      /* Empieza nodo:547 / Elemento padre: 538   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(547)).setAttribute("ancho","80" );
      ((Element)v.get(547)).setAttribute("minimizable","S" );
      ((Element)v.get(547)).setAttribute("minimizada","N" );
      ((Element)v.get(538)).appendChild((Element)v.get(547));
      /* Termina nodo:547   */
      /* Termina nodo:538   */

      /* Empieza nodo:548 / Elemento padre: 528   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(548)).setAttribute("alto","20" );
      ((Element)v.get(548)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(548)).setAttribute("imgFondo","" );
      ((Element)v.get(548)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(528)).appendChild((Element)v.get(548));

      /* Empieza nodo:549 / Elemento padre: 548   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(549)).setAttribute("colFondo","" );
      ((Element)v.get(549)).setAttribute("ID","EstCab" );
      ((Element)v.get(549)).setAttribute("cod","8" );
      ((Element)v.get(548)).appendChild((Element)v.get(549));

      /* Elemento padre:549 / Elemento actual: 550   */
      v.add(doc.createTextNode("Código"));
      ((Element)v.get(549)).appendChild((Text)v.get(550));

      /* Termina nodo Texto:550   */
      /* Termina nodo:549   */

      /* Empieza nodo:551 / Elemento padre: 548   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(551)).setAttribute("colFondo","" );
      ((Element)v.get(551)).setAttribute("ID","EstCab" );
      ((Element)v.get(551)).setAttribute("cod","9" );
      ((Element)v.get(548)).appendChild((Element)v.get(551));

      /* Elemento padre:551 / Elemento actual: 552   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(551)).appendChild((Text)v.get(552));

      /* Termina nodo Texto:552   */
      /* Termina nodo:551   */

      /* Empieza nodo:553 / Elemento padre: 548   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(553)).setAttribute("colFondo","" );
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(553)).setAttribute("ID","EstCab" );
      ((Element)v.get(553)).setAttribute("cod","608" );
      ((Element)v.get(548)).appendChild((Element)v.get(553));

      /* Elemento padre:553 / Elemento actual: 554   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(553)).appendChild((Text)v.get(554));

      /* Termina nodo Texto:554   */
      /* Termina nodo:553   */

      /* Empieza nodo:555 / Elemento padre: 548   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(555)).setAttribute("colFondo","" );
      ((Element)v.get(555)).setAttribute("ID","EstCab" );
      ((Element)v.get(555)).setAttribute("cod","581" );
      ((Element)v.get(548)).appendChild((Element)v.get(555));

      /* Elemento padre:555 / Elemento actual: 556   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(555)).appendChild((Text)v.get(556));

      /* Termina nodo Texto:556   */
      /* Termina nodo:555   */

      /* Empieza nodo:557 / Elemento padre: 548   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(557)).setAttribute("colFondo","" );
      ((Element)v.get(557)).setAttribute("ID","EstCab" );
      ((Element)v.get(557)).setAttribute("cod","529" );
      ((Element)v.get(548)).appendChild((Element)v.get(557));

      /* Elemento padre:557 / Elemento actual: 558   */
      v.add(doc.createTextNode("Factor repetición"));
      ((Element)v.get(557)).appendChild((Text)v.get(558));

      /* Termina nodo Texto:558   */
      /* Termina nodo:557   */

      /* Empieza nodo:559 / Elemento padre: 548   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(559)).setAttribute("colFondo","" );
      ((Element)v.get(559)).setAttribute("ID","EstCab" );
      ((Element)v.get(559)).setAttribute("cod","530" );
      ((Element)v.get(548)).appendChild((Element)v.get(559));

      /* Elemento padre:559 / Elemento actual: 560   */
      v.add(doc.createTextNode("Precio unitario"));
      ((Element)v.get(559)).appendChild((Text)v.get(560));

      /* Termina nodo Texto:560   */
      /* Termina nodo:559   */

      /* Empieza nodo:561 / Elemento padre: 548   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(561)).setAttribute("colFondo","" );
      ((Element)v.get(561)).setAttribute("ID","EstCab" );
      ((Element)v.get(561)).setAttribute("cod","481" );
      ((Element)v.get(548)).appendChild((Element)v.get(561));

      /* Elemento padre:561 / Elemento actual: 562   */
      v.add(doc.createTextNode("Atributo 1"));
      ((Element)v.get(561)).appendChild((Text)v.get(562));

      /* Termina nodo Texto:562   */
      /* Termina nodo:561   */

      /* Empieza nodo:563 / Elemento padre: 548   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(563)).setAttribute("colFondo","" );
      ((Element)v.get(563)).setAttribute("ID","EstCab" );
      ((Element)v.get(563)).setAttribute("cod","482" );
      ((Element)v.get(548)).appendChild((Element)v.get(563));

      /* Elemento padre:563 / Elemento actual: 564   */
      v.add(doc.createTextNode("Atributo 2"));
      ((Element)v.get(563)).appendChild((Text)v.get(564));

      /* Termina nodo Texto:564   */
      /* Termina nodo:563   */

      /* Empieza nodo:565 / Elemento padre: 548   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(565)).setAttribute("colFondo","" );
      ((Element)v.get(565)).setAttribute("ID","EstCab" );
      ((Element)v.get(565)).setAttribute("cod","483" );
      ((Element)v.get(548)).appendChild((Element)v.get(565));

      /* Elemento padre:565 / Elemento actual: 566   */
      v.add(doc.createTextNode("Atributo 3"));
      ((Element)v.get(565)).appendChild((Text)v.get(566));

      /* Termina nodo Texto:566   */
      /* Termina nodo:565   */
      /* Termina nodo:548   */

      /* Empieza nodo:567 / Elemento padre: 528   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(567)).setAttribute("alto","22" );
      ((Element)v.get(567)).setAttribute("accion","" );
      ((Element)v.get(567)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(567)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(567)).setAttribute("maxSel","-1" );
      ((Element)v.get(567)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(567)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(567)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(567)).setAttribute("onLoad","" );
      ((Element)v.get(567)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(528)).appendChild((Element)v.get(567));

      /* Empieza nodo:568 / Elemento padre: 567   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(568)).setAttribute("tipo","texto" );
      ((Element)v.get(568)).setAttribute("ID","EstDat" );
      ((Element)v.get(567)).appendChild((Element)v.get(568));
      /* Termina nodo:568   */

      /* Empieza nodo:569 / Elemento padre: 567   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(569)).setAttribute("tipo","texto" );
      ((Element)v.get(569)).setAttribute("ID","EstDat2" );
      ((Element)v.get(567)).appendChild((Element)v.get(569));
      /* Termina nodo:569   */

      /* Empieza nodo:570 / Elemento padre: 567   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(570)).setAttribute("tipo","texto" );
      ((Element)v.get(570)).setAttribute("ID","EstDat" );
      ((Element)v.get(567)).appendChild((Element)v.get(570));
      /* Termina nodo:570   */

      /* Empieza nodo:571 / Elemento padre: 567   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(571)).setAttribute("tipo","texto" );
      ((Element)v.get(571)).setAttribute("ID","EstDat2" );
      ((Element)v.get(567)).appendChild((Element)v.get(571));
      /* Termina nodo:571   */

      /* Empieza nodo:572 / Elemento padre: 567   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(572)).setAttribute("tipo","texto" );
      ((Element)v.get(572)).setAttribute("ID","EstDat2" );
      ((Element)v.get(567)).appendChild((Element)v.get(572));
      /* Termina nodo:572   */

      /* Empieza nodo:573 / Elemento padre: 567   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(573)).setAttribute("tipo","texto" );
      ((Element)v.get(573)).setAttribute("ID","EstDat" );
      ((Element)v.get(567)).appendChild((Element)v.get(573));
      /* Termina nodo:573   */

      /* Empieza nodo:574 / Elemento padre: 567   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(574)).setAttribute("tipo","texto" );
      ((Element)v.get(574)).setAttribute("ID","EstDat2" );
      ((Element)v.get(567)).appendChild((Element)v.get(574));
      /* Termina nodo:574   */

      /* Empieza nodo:575 / Elemento padre: 567   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(575)).setAttribute("tipo","texto" );
      ((Element)v.get(575)).setAttribute("ID","EstDat" );
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(567)).appendChild((Element)v.get(575));
      /* Termina nodo:575   */

      /* Empieza nodo:576 / Elemento padre: 567   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(576)).setAttribute("tipo","texto" );
      ((Element)v.get(576)).setAttribute("ID","EstDat2" );
      ((Element)v.get(567)).appendChild((Element)v.get(576));
      /* Termina nodo:576   */
      /* Termina nodo:567   */

      /* Empieza nodo:577 / Elemento padre: 528   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(528)).appendChild((Element)v.get(577));
      /* Termina nodo:577   */
      /* Termina nodo:528   */

      /* Empieza nodo:578 / Elemento padre: 59   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(578)).setAttribute("nombre","Buscar2" );
      ((Element)v.get(578)).setAttribute("x","13" );
      ((Element)v.get(578)).setAttribute("y","565" );
      ((Element)v.get(578)).setAttribute("ID","botonContenido" );
      ((Element)v.get(578)).setAttribute("tipo","html" );
      ((Element)v.get(578)).setAttribute("estado","false" );
      ((Element)v.get(578)).setAttribute("cod","1" );
      ((Element)v.get(578)).setAttribute("accion","accionBuscarProductoAsociado();" );
      ((Element)v.get(578)).setAttribute("ontab","tabGenerico('Buscar2','tab');" );
      ((Element)v.get(578)).setAttribute("onshtab","tabGenerico('Buscar2','sh');" );
      ((Element)v.get(59)).appendChild((Element)v.get(578));
      /* Termina nodo:578   */

      /* Empieza nodo:579 / Elemento padre: 59   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(579)).setAttribute("nombre","listado3" );
      ((Element)v.get(579)).setAttribute("ancho","733" );
      ((Element)v.get(579)).setAttribute("alto","317" );
      ((Element)v.get(579)).setAttribute("x","12" );
      ((Element)v.get(579)).setAttribute("y","1100" );
      ((Element)v.get(579)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(579)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(59)).appendChild((Element)v.get(579));

      /* Empieza nodo:580 / Elemento padre: 579   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(580)).setAttribute("precarga","S" );
      ((Element)v.get(580)).setAttribute("conROver","S" );
      ((Element)v.get(579)).appendChild((Element)v.get(580));

      /* Empieza nodo:581 / Elemento padre: 580   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(581)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(581)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(581)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(581)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(580)).appendChild((Element)v.get(581));
      /* Termina nodo:581   */

      /* Empieza nodo:582 / Elemento padre: 580   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(582)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(582)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(582)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(582)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(580)).appendChild((Element)v.get(582));
      /* Termina nodo:582   */

      /* Empieza nodo:583 / Elemento padre: 580   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(583)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(583)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(580)).appendChild((Element)v.get(583));
      /* Termina nodo:583   */
      /* Termina nodo:580   */

      /* Empieza nodo:584 / Elemento padre: 579   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(579)).appendChild((Element)v.get(584));

      /* Empieza nodo:585 / Elemento padre: 584   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(585)).setAttribute("borde","1" );
      ((Element)v.get(585)).setAttribute("horizDatos","1" );
      ((Element)v.get(585)).setAttribute("horizCabecera","1" );
      ((Element)v.get(585)).setAttribute("vertical","1" );
      ((Element)v.get(585)).setAttribute("horizTitulo","1" );
      ((Element)v.get(585)).setAttribute("horizBase","1" );
      ((Element)v.get(584)).appendChild((Element)v.get(585));
      /* Termina nodo:585   */

      /* Empieza nodo:586 / Elemento padre: 584   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(586)).setAttribute("borde","#999999" );
      ((Element)v.get(586)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(586)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(586)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(586)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(586)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(586)).setAttribute("horizBase","#999999" );
      ((Element)v.get(584)).appendChild((Element)v.get(586));
      /* Termina nodo:586   */
      /* Termina nodo:584   */

      /* Empieza nodo:587 / Elemento padre: 579   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(587)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(587)).setAttribute("alto","22" );
      ((Element)v.get(587)).setAttribute("imgFondo","" );
      ((Element)v.get(587)).setAttribute("cod","0013" );
      ((Element)v.get(587)).setAttribute("ID","datosTitle" );
      ((Element)v.get(579)).appendChild((Element)v.get(587));
      /* Termina nodo:587   */

      /* Empieza nodo:588 / Elemento padre: 579   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(588)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(588)).setAttribute("alto","22" );
      ((Element)v.get(588)).setAttribute("imgFondo","" );
      ((Element)v.get(579)).appendChild((Element)v.get(588));
      /* Termina nodo:588   */

      /* Empieza nodo:589 / Elemento padre: 579   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(589)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(589)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(589)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(589)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(589)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(589)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(579)).appendChild((Element)v.get(589));

      /* Empieza nodo:590 / Elemento padre: 589   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(590)).setAttribute("ancho","100" );
      ((Element)v.get(590)).setAttribute("minimizable","S" );
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(590)).setAttribute("minimizada","N" );
      ((Element)v.get(589)).appendChild((Element)v.get(590));
      /* Termina nodo:590   */

      /* Empieza nodo:591 / Elemento padre: 589   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(591)).setAttribute("ancho","100" );
      ((Element)v.get(591)).setAttribute("minimizable","S" );
      ((Element)v.get(591)).setAttribute("minimizada","N" );
      ((Element)v.get(589)).appendChild((Element)v.get(591));
      /* Termina nodo:591   */

      /* Empieza nodo:592 / Elemento padre: 589   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(592)).setAttribute("ancho","100" );
      ((Element)v.get(592)).setAttribute("minimizable","S" );
      ((Element)v.get(592)).setAttribute("minimizada","N" );
      ((Element)v.get(589)).appendChild((Element)v.get(592));
      /* Termina nodo:592   */

      /* Empieza nodo:593 / Elemento padre: 589   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(593)).setAttribute("ancho","70" );
      ((Element)v.get(593)).setAttribute("minimizable","S" );
      ((Element)v.get(593)).setAttribute("minimizada","N" );
      ((Element)v.get(589)).appendChild((Element)v.get(593));
      /* Termina nodo:593   */

      /* Empieza nodo:594 / Elemento padre: 589   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(594)).setAttribute("ancho","100" );
      ((Element)v.get(594)).setAttribute("minimizable","S" );
      ((Element)v.get(594)).setAttribute("minimizada","N" );
      ((Element)v.get(589)).appendChild((Element)v.get(594));
      /* Termina nodo:594   */

      /* Empieza nodo:595 / Elemento padre: 589   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(595)).setAttribute("ancho","100" );
      ((Element)v.get(595)).setAttribute("minimizable","S" );
      ((Element)v.get(595)).setAttribute("minimizada","N" );
      ((Element)v.get(589)).appendChild((Element)v.get(595));
      /* Termina nodo:595   */

      /* Empieza nodo:596 / Elemento padre: 589   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(596)).setAttribute("ancho","100" );
      ((Element)v.get(596)).setAttribute("minimizable","S" );
      ((Element)v.get(596)).setAttribute("minimizada","N" );
      ((Element)v.get(589)).appendChild((Element)v.get(596));
      /* Termina nodo:596   */

      /* Empieza nodo:597 / Elemento padre: 589   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(597)).setAttribute("ancho","100" );
      ((Element)v.get(597)).setAttribute("minimizable","S" );
      ((Element)v.get(597)).setAttribute("minimizada","N" );
      ((Element)v.get(589)).appendChild((Element)v.get(597));
      /* Termina nodo:597   */
      /* Termina nodo:589   */

      /* Empieza nodo:598 / Elemento padre: 579   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(598)).setAttribute("alto","20" );
      ((Element)v.get(598)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(598)).setAttribute("imgFondo","" );
      ((Element)v.get(598)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(579)).appendChild((Element)v.get(598));

      /* Empieza nodo:599 / Elemento padre: 598   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(599)).setAttribute("colFondo","" );
      ((Element)v.get(599)).setAttribute("ID","EstCab" );
      ((Element)v.get(599)).setAttribute("cod","393" );
      ((Element)v.get(598)).appendChild((Element)v.get(599));

      /* Elemento padre:599 / Elemento actual: 600   */
      v.add(doc.createTextNode("Tipo cliente"));
      ((Element)v.get(599)).appendChild((Text)v.get(600));

      /* Termina nodo Texto:600   */
      /* Termina nodo:599   */

      /* Empieza nodo:601 / Elemento padre: 598   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(601)).setAttribute("colFondo","" );
      ((Element)v.get(601)).setAttribute("ID","EstCab" );
      ((Element)v.get(601)).setAttribute("cod","595" );
      ((Element)v.get(598)).appendChild((Element)v.get(601));

      /* Elemento padre:601 / Elemento actual: 602   */
      v.add(doc.createTextNode("Subtipo cliente"));
      ((Element)v.get(601)).appendChild((Text)v.get(602));

      /* Termina nodo Texto:602   */
      /* Termina nodo:601   */

      /* Empieza nodo:603 / Elemento padre: 598   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(603)).setAttribute("colFondo","" );
      ((Element)v.get(603)).setAttribute("ID","EstCab" );
      ((Element)v.get(603)).setAttribute("cod","756" );
      ((Element)v.get(598)).appendChild((Element)v.get(603));

      /* Elemento padre:603 / Elemento actual: 604   */
      v.add(doc.createTextNode("Tipo clasificación"));
      ((Element)v.get(603)).appendChild((Text)v.get(604));

      /* Termina nodo Texto:604   */
      /* Termina nodo:603   */

      /* Empieza nodo:605 / Elemento padre: 598   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(605)).setAttribute("colFondo","" );
      ((Element)v.get(605)).setAttribute("ID","EstCab" );
      ((Element)v.get(605)).setAttribute("cod","550" );
      ((Element)v.get(598)).appendChild((Element)v.get(605));

      /* Elemento padre:605 / Elemento actual: 606   */
      v.add(doc.createTextNode("Clasificación"));
      ((Element)v.get(605)).appendChild((Text)v.get(606));

      /* Termina nodo Texto:606   */
      /* Termina nodo:605   */

      /* Empieza nodo:607 / Elemento padre: 598   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(607)).setAttribute("colFondo","" );
      ((Element)v.get(607)).setAttribute("ID","EstCab" );
      ((Element)v.get(607)).setAttribute("cod","551" );
      ((Element)v.get(598)).appendChild((Element)v.get(607));

      /* Elemento padre:607 / Elemento actual: 608   */
      v.add(doc.createTextNode("Estatus 1"));
      ((Element)v.get(607)).appendChild((Text)v.get(608));

      /* Termina nodo Texto:608   */
      /* Termina nodo:607   */

      /* Empieza nodo:609 / Elemento padre: 598   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(609)).setAttribute("colFondo","" );
      ((Element)v.get(609)).setAttribute("ID","EstCab" );
      ((Element)v.get(609)).setAttribute("cod","552" );
      ((Element)v.get(598)).appendChild((Element)v.get(609));

      /* Elemento padre:609 / Elemento actual: 610   */
      v.add(doc.createTextNode("Estatus 2"));
      ((Element)v.get(609)).appendChild((Text)v.get(610));

      /* Termina nodo Texto:610   */
      /* Termina nodo:609   */

      /* Empieza nodo:611 / Elemento padre: 598   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(611)).setAttribute("colFondo","" );
      ((Element)v.get(611)).setAttribute("ID","EstCab" );
      ((Element)v.get(611)).setAttribute("cod","109" );
      ((Element)v.get(598)).appendChild((Element)v.get(611));

      /* Elemento padre:611 / Elemento actual: 612   */
   }

   private void getXML2610(Document doc) {
      v.add(doc.createTextNode("Region"));
      ((Element)v.get(611)).appendChild((Text)v.get(612));

      /* Termina nodo Texto:612   */
      /* Termina nodo:611   */

      /* Empieza nodo:613 / Elemento padre: 598   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(613)).setAttribute("colFondo","" );
      ((Element)v.get(613)).setAttribute("ID","EstCab" );
      ((Element)v.get(613)).setAttribute("cod","143" );
      ((Element)v.get(598)).appendChild((Element)v.get(613));

      /* Elemento padre:613 / Elemento actual: 614   */
      v.add(doc.createTextNode("Zona"));
      ((Element)v.get(613)).appendChild((Text)v.get(614));

      /* Termina nodo Texto:614   */
      /* Termina nodo:613   */
      /* Termina nodo:598   */

      /* Empieza nodo:615 / Elemento padre: 579   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(615)).setAttribute("alto","22" );
      ((Element)v.get(615)).setAttribute("accion","" );
      ((Element)v.get(615)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(615)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(615)).setAttribute("maxSel","-1" );
      ((Element)v.get(615)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(615)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(615)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(615)).setAttribute("onLoad","" );
      ((Element)v.get(615)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(579)).appendChild((Element)v.get(615));

      /* Empieza nodo:616 / Elemento padre: 615   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(616)).setAttribute("tipo","texto" );
      ((Element)v.get(616)).setAttribute("ID","EstDat" );
      ((Element)v.get(615)).appendChild((Element)v.get(616));
      /* Termina nodo:616   */

      /* Empieza nodo:617 / Elemento padre: 615   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(617)).setAttribute("tipo","texto" );
      ((Element)v.get(617)).setAttribute("ID","EstDat2" );
      ((Element)v.get(615)).appendChild((Element)v.get(617));
      /* Termina nodo:617   */

      /* Empieza nodo:618 / Elemento padre: 615   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(618)).setAttribute("tipo","texto" );
      ((Element)v.get(618)).setAttribute("ID","EstDat" );
      ((Element)v.get(615)).appendChild((Element)v.get(618));
      /* Termina nodo:618   */

      /* Empieza nodo:619 / Elemento padre: 615   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(619)).setAttribute("tipo","texto" );
      ((Element)v.get(619)).setAttribute("ID","EstDat2" );
      ((Element)v.get(615)).appendChild((Element)v.get(619));
      /* Termina nodo:619   */

      /* Empieza nodo:620 / Elemento padre: 615   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(620)).setAttribute("tipo","texto" );
      ((Element)v.get(620)).setAttribute("ID","EstDat" );
      ((Element)v.get(615)).appendChild((Element)v.get(620));
      /* Termina nodo:620   */

      /* Empieza nodo:621 / Elemento padre: 615   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(621)).setAttribute("tipo","texto" );
      ((Element)v.get(621)).setAttribute("ID","EstDat2" );
      ((Element)v.get(615)).appendChild((Element)v.get(621));
      /* Termina nodo:621   */

      /* Empieza nodo:622 / Elemento padre: 615   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(622)).setAttribute("tipo","texto" );
      ((Element)v.get(622)).setAttribute("ID","EstDat" );
      ((Element)v.get(615)).appendChild((Element)v.get(622));
      /* Termina nodo:622   */

      /* Empieza nodo:623 / Elemento padre: 615   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(623)).setAttribute("tipo","texto" );
      ((Element)v.get(623)).setAttribute("ID","EstDat2" );
      ((Element)v.get(615)).appendChild((Element)v.get(623));
      /* Termina nodo:623   */
      /* Termina nodo:615   */

      /* Empieza nodo:624 / Elemento padre: 579   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(579)).appendChild((Element)v.get(624));
      /* Termina nodo:624   */
      /* Termina nodo:579   */

      /* Empieza nodo:625 / Elemento padre: 59   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(625)).setAttribute("nombre","Anadir" );
      ((Element)v.get(625)).setAttribute("x","13" );
      ((Element)v.get(625)).setAttribute("y","1395" );
      ((Element)v.get(625)).setAttribute("ID","botonContenido" );
      ((Element)v.get(625)).setAttribute("tipo","html" );
      ((Element)v.get(625)).setAttribute("estado","false" );
      ((Element)v.get(625)).setAttribute("cod","1254" );
      ((Element)v.get(625)).setAttribute("accion","accionEliminarVentaExclusiva();" );
      ((Element)v.get(625)).setAttribute("ontab","tabGenerico('Anadir','tab');" );
      ((Element)v.get(625)).setAttribute("onshtab","tabGenerico('Anadir','sh');" );
      ((Element)v.get(59)).appendChild((Element)v.get(625));
      /* Termina nodo:625   */
      /* Termina nodo:59   */
      /* Termina nodo:21   */

      /* Empieza nodo:626 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(626)).setAttribute("nombre","frmFormularioEnviar" );
      ((Element)v.get(626)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(626));

      /* Empieza nodo:627 / Elemento padre: 626   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(627)).setAttribute("nombre","accion" );
      ((Element)v.get(627)).setAttribute("valor","Guardar Oferta" );
      ((Element)v.get(626)).appendChild((Element)v.get(627));
      /* Termina nodo:627   */

      /* Empieza nodo:628 / Elemento padre: 626   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(628)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(628)).setAttribute("valor","LPDefinirOfertaPerf" );
      ((Element)v.get(626)).appendChild((Element)v.get(628));
      /* Termina nodo:628   */

      /* Empieza nodo:629 / Elemento padre: 626   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(629)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(629)).setAttribute("valor","" );
      ((Element)v.get(626)).appendChild((Element)v.get(629));
      /* Termina nodo:629   */

      /* Empieza nodo:630 / Elemento padre: 626   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(630)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(630)).setAttribute("valor","" );
      ((Element)v.get(626)).appendChild((Element)v.get(630));
      /* Termina nodo:630   */

      /* Empieza nodo:631 / Elemento padre: 626   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(631)).setAttribute("nombre","sDatosGralesOferta" );
      ((Element)v.get(631)).setAttribute("valor","" );
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(626)).appendChild((Element)v.get(631));
      /* Termina nodo:631   */

      /* Empieza nodo:632 / Elemento padre: 626   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(632)).setAttribute("nombre","sDetallesOferta" );
      ((Element)v.get(632)).setAttribute("valor","" );
      ((Element)v.get(626)).appendChild((Element)v.get(632));
      /* Termina nodo:632   */

      /* Empieza nodo:633 / Elemento padre: 626   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(633)).setAttribute("nombre","sVentasExclusivas" );
      ((Element)v.get(633)).setAttribute("valor","" );
      ((Element)v.get(626)).appendChild((Element)v.get(633));
      /* Termina nodo:633   */

      /* Empieza nodo:634 / Elemento padre: 626   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(634)).setAttribute("nombre","sPromociones" );
      ((Element)v.get(634)).setAttribute("valor","" );
      ((Element)v.get(626)).appendChild((Element)v.get(634));
      /* Termina nodo:634   */

      /* Empieza nodo:635 / Elemento padre: 626   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(635)).setAttribute("nombre","sGrupos" );
      ((Element)v.get(635)).setAttribute("valor","" );
      ((Element)v.get(626)).appendChild((Element)v.get(635));
      /* Termina nodo:635   */
      /* Termina nodo:626   */


   }

}

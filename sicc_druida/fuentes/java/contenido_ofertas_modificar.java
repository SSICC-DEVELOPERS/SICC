
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_ofertas_modificar  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_ofertas_modificar" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("titulo","Modificar Ofertas" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","Modificar Ofertas" );
      ((Element)v.get(0)).setAttribute("onload","onLoadPag()" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JAVASCRIPT"));
      ((Element)v.get(0)).appendChild((Element)v.get(1));

      /* Empieza nodo:2 / Elemento padre: 1   */
      v.add(doc.createElement("VALIDACION"));
      ((Element)v.get(1)).appendChild((Element)v.get(2));

      /* Empieza nodo:3 / Elemento padre: 2   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(3)).setAttribute("name","cbArgumentoVenta" );
      ((Element)v.get(3)).setAttribute("required","true" );
      ((Element)v.get(3)).setAttribute("cod","528" );
      ((Element)v.get(3)).setAttribute("group","guardar" );
      ((Element)v.get(2)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 2   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(4)).setAttribute("name","rbCondicionCondicionados" );
      ((Element)v.get(4)).setAttribute("required","true" );
      ((Element)v.get(4)).setAttribute("cod","538" );
      ((Element)v.get(4)).setAttribute("group","condicionado" );
      ((Element)v.get(2)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 2   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(5)).setAttribute("name","rbCondicionCondicionantes" );
      ((Element)v.get(5)).setAttribute("required","true" );
      ((Element)v.get(5)).setAttribute("cod","536" );
      ((Element)v.get(5)).setAttribute("group","condicionante" );
      ((Element)v.get(2)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 2   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(6)).setAttribute("name","txtNumeroGruposCondicionantes" );
      ((Element)v.get(6)).setAttribute("required","true" );
      ((Element)v.get(6)).setAttribute("cod","535" );
      ((Element)v.get(6)).setAttribute("format","e" );
      ((Element)v.get(6)).setAttribute("min","0" );
      ((Element)v.get(6)).setAttribute("max","999999" );
      ((Element)v.get(6)).setAttribute("group","condicionadatexto" );
      ((Element)v.get(2)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 2   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(7)).setAttribute("name","txtNumeroGruposCondicionados" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("cod","537" );
      ((Element)v.get(7)).setAttribute("format","e" );
      ((Element)v.get(7)).setAttribute("min","0" );
      ((Element)v.get(7)).setAttribute("max","999999" );
      ((Element)v.get(7)).setAttribute("group","condicionadatexto" );
      ((Element)v.get(2)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 2   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbTipoCliente" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("cod","393" );
      ((Element)v.get(8)).setAttribute("group","ventaExclusiva" );
      ((Element)v.get(2)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */
      /* Termina nodo:2   */
      /* Termina nodo:1   */

      /* Empieza nodo:9 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(9)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(10)).setAttribute("src","PaginacionSicc.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(11)).setAttribute("src","DruidaTransactionMare.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(12)).setAttribute("src","contenido_ofertas_modificar.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

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
      ((Element)v.get(15)).setAttribute("valor","LPModificarOferta" );
      ((Element)v.get(13)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","casoDeUso" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","oidOferta" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","cadenaLineaPromocion" );
      ((Element)v.get(18)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(13)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","cadenaProductosGrupo" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","cadenaVentaExclusiva" );
      ((Element)v.get(20)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","cadenaProductoPrincipal" );
      ((Element)v.get(21)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","deshabilitar" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","hidOidCabeceraMF" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","btnBPAsoc" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","btnMPAsoc" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","hDesTipoCliente" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","hDesSubtipoCliente" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","hDesTipoClasificacion" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","hDesClasificacion" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","hDesEstatusCliente" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","txtEstatus2" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","hidOidArgVenta" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","hIndCuadre" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","hFormaPago" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","hidCKDespachoAutomatico" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","hidCKDespachoCompleto" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hidCKRecuperacionObligatoria" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hidGruposCnantes" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","hidGruposCnados" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","hidRDCondicionados" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
   }

   private void getXML180(Document doc) {
      ((Element)v.get(41)).setAttribute("nombre","hidRDCondicionantes" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","hidOidIndicadorCuadre" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","hidNroOrden" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","hidOidArgumentoVenta" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(45)).setAttribute("nombre","hidDespachoCompleto" );
      ((Element)v.get(45)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */

      /* Empieza nodo:46 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(46)).setAttribute("nombre","hidDespachoAutomatico" );
      ((Element)v.get(46)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */

      /* Empieza nodo:47 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(47)).setAttribute("nombre","hOidCondicion" );
      ((Element)v.get(47)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */

      /* Empieza nodo:48 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(48)).setAttribute("nombre","hidOidGrupo" );
      ((Element)v.get(48)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */

      /* Empieza nodo:49 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(49)).setAttribute("nombre","hNombreListas" );
      ((Element)v.get(49)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */

      /* Empieza nodo:50 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(50)).setAttribute("nombre","hDeshabilitaTodo" );
      ((Element)v.get(50)).setAttribute("valor","N" );
      ((Element)v.get(13)).appendChild((Element)v.get(50));
      /* Termina nodo:50   */

      /* Empieza nodo:51 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(51)).setAttribute("nombre","hValorError" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */

      /* Empieza nodo:52 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(52)).setAttribute("nombre","hidHabilitaIndicadorCuadre" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */

      /* Empieza nodo:53 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(53)).setAttribute("nombre","hidECondicionada" );
      ((Element)v.get(53)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */

      /* Empieza nodo:54 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(54)).setAttribute("nombre","hidEstrategiaVS" );
      ((Element)v.get(54)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */

      /* Empieza nodo:55 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(55)).setAttribute("nombre","hidHabiDesAutomatico" );
      ((Element)v.get(55)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */

      /* Empieza nodo:56 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(56)).setAttribute("nombre","hidHabiDesCompleto" );
      ((Element)v.get(56)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */

      /* Empieza nodo:57 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(57)).setAttribute("nombre","LPRegreso" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */

      /* Empieza nodo:58 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(58)).setAttribute("nombre","hidNroGrupo" );
      ((Element)v.get(58)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */

      /* Empieza nodo:59 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(59)).setAttribute("nombre","hidNroCondicion" );
      ((Element)v.get(59)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */

      /* Empieza nodo:60 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(60)).setAttribute("nombre","maxGrupo" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */

      /* Empieza nodo:61 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(61)).setAttribute("nombre","maxGruposCondicionantes" );
      ((Element)v.get(61)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(61));
      /* Termina nodo:61   */

      /* Empieza nodo:62 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(62)).setAttribute("nombre","maxGruposCondicionados" );
      ((Element)v.get(62)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */

      /* Empieza nodo:63 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(63)).setAttribute("nombre","nroPromociones" );
      ((Element)v.get(63)).setAttribute("valor","" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(13)).appendChild((Element)v.get(63));
      /* Termina nodo:63   */

      /* Empieza nodo:64 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(64)).setAttribute("nombre","elemSelecc" );
      ((Element)v.get(64)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */

      /* Empieza nodo:65 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(65)).setAttribute("nombre","hidNroGrupos" );
      ((Element)v.get(65)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(65));
      /* Termina nodo:65   */

      /* Empieza nodo:66 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(66)).setAttribute("nombre","hidNroPaquetes" );
      ((Element)v.get(66)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */

      /* Empieza nodo:67 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(67)).setAttribute("nombre","hidNroCondicionados" );
      ((Element)v.get(67)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */

      /* Empieza nodo:68 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(68)).setAttribute("nombre","varNombresListasDinamicas" );
      ((Element)v.get(68)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(68));
      /* Termina nodo:68   */

      /* Empieza nodo:69 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(69)).setAttribute("nombre","hidNroCondicionantes" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */

      /* Empieza nodo:70 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(70)).setAttribute("nombre","matrizFacturada" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */

      /* Empieza nodo:71 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(71)).setAttribute("nombre","hidNroPromo" );
      ((Element)v.get(71)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */

      /* Empieza nodo:72 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(72)).setAttribute("nombre","hidListaEditable" );
      ((Element)v.get(72)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */

      /* Empieza nodo:73 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(73)).setAttribute("nombre","hidCodSeleccionadosLE" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */

      /* Empieza nodo:74 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(74)).setAttribute("nombre","arrRegiones" );
      ((Element)v.get(74)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */

      /* Empieza nodo:75 / Elemento padre: 13   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(75)).setAttribute("nombre","arrZonas" );
      ((Element)v.get(75)).setAttribute("valor","" );
      ((Element)v.get(13)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */

      /* Empieza nodo:76 / Elemento padre: 13   */
      v.add(doc.createElement("table"));
      ((Element)v.get(76)).setAttribute("width","100%" );
      ((Element)v.get(76)).setAttribute("border","0" );
      ((Element)v.get(76)).setAttribute("cellspacing","0" );
      ((Element)v.get(76)).setAttribute("cellpadding","0" );
      ((Element)v.get(13)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(78)).setAttribute("width","12" );
      ((Element)v.get(78)).setAttribute("align","center" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","12" );
      ((Element)v.get(79)).setAttribute("height","12" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).setAttribute("width","750" );
      ((Element)v.get(77)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:82 / Elemento padre: 77   */
      v.add(doc.createElement("td"));
      ((Element)v.get(82)).setAttribute("width","12" );
      ((Element)v.get(77)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","12" );
      ((Element)v.get(83)).setAttribute("height","1" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */
      /* Termina nodo:77   */

      /* Empieza nodo:84 / Elemento padre: 76   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(76)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(86)).setAttribute("src","b.gif" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */

      /* Empieza nodo:87 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("fieldset"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(89)).setAttribute("class","legend" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(90)).setAttribute("nombre","lblDatosOferta" );
      ((Element)v.get(90)).setAttribute("alto","13" );
      ((Element)v.get(90)).setAttribute("filas","1" );
      ((Element)v.get(90)).setAttribute("valor","" );
      ((Element)v.get(90)).setAttribute("id","legend" );
      ((Element)v.get(90)).setAttribute("cod","00113" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:91 / Elemento padre: 88   */
      v.add(doc.createElement("table"));
      ((Element)v.get(91)).setAttribute("width","100%" );
      ((Element)v.get(91)).setAttribute("border","0" );
      ((Element)v.get(91)).setAttribute("align","center" );
      ((Element)v.get(91)).setAttribute("cellspacing","0" );
      ((Element)v.get(91)).setAttribute("cellpadding","0" );
      ((Element)v.get(88)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(91)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("td"));
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("table"));
      ((Element)v.get(94)).setAttribute("width","730" );
      ((Element)v.get(94)).setAttribute("border","0" );
      ((Element)v.get(94)).setAttribute("align","left" );
      ((Element)v.get(94)).setAttribute("cellspacing","0" );
      ((Element)v.get(94)).setAttribute("cellpadding","0" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("colspan","4" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","8" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:98 / Elemento padre: 94   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(94)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","8" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:101 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(102)).setAttribute("nombre","lblAcceso" );
      ((Element)v.get(102)).setAttribute("alto","13" );
      ((Element)v.get(102)).setAttribute("filas","1" );
      ((Element)v.get(102)).setAttribute("id","datosTitle" );
      ((Element)v.get(102)).setAttribute("cod","10" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","25" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(106)).setAttribute("nombre","lblSubacceso" );
      ((Element)v.get(106)).setAttribute("alto","13" );
      ((Element)v.get(106)).setAttribute("filas","1" );
      ((Element)v.get(106)).setAttribute("id","datosTitle" );
      ((Element)v.get(106)).setAttribute("cod","122" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */

      /* Empieza nodo:107 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","25" );
      ((Element)v.get(108)).setAttribute("height","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(98)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(110)).setAttribute("nombre","lblEstrategia" );
      ((Element)v.get(110)).setAttribute("alto","13" );
      ((Element)v.get(110)).setAttribute("filas","1" );
      ((Element)v.get(110)).setAttribute("id","datosTitle" );
      ((Element)v.get(110)).setAttribute("cod","478" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 98   */
   }

   private void getXML450(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(111)).setAttribute("width","100%" );
      ((Element)v.get(98)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).setAttribute("width","8" );
      ((Element)v.get(112)).setAttribute("height","8" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:98   */

      /* Empieza nodo:113 / Elemento padre: 94   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(94)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(115)).setAttribute("src","b.gif" );
      ((Element)v.get(115)).setAttribute("width","8" );
      ((Element)v.get(115)).setAttribute("height","8" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:116 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(117)).setAttribute("nombre","lblAccesoXX" );
      ((Element)v.get(117)).setAttribute("alto","13" );
      ((Element)v.get(117)).setAttribute("filas","1" );
      ((Element)v.get(117)).setAttribute("valor","" );
      ((Element)v.get(117)).setAttribute("id","datosCampos" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).setAttribute("width","25" );
      ((Element)v.get(119)).setAttribute("height","8" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(121)).setAttribute("nombre","lblSubaccesoXX" );
      ((Element)v.get(121)).setAttribute("alto","13" );
      ((Element)v.get(121)).setAttribute("filas","1" );
      ((Element)v.get(121)).setAttribute("valor","" );
      ((Element)v.get(121)).setAttribute("id","datosCampos" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).setAttribute("width","25" );
      ((Element)v.get(123)).setAttribute("height","8" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(113)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(125)).setAttribute("nombre","lbldtEstrategia" );
      ((Element)v.get(125)).setAttribute("alto","13" );
      ((Element)v.get(125)).setAttribute("filas","1" );
      ((Element)v.get(125)).setAttribute("valor","" );
      ((Element)v.get(125)).setAttribute("id","datosCampos" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */

      /* Empieza nodo:126 / Elemento padre: 113   */
      v.add(doc.createElement("td"));
      ((Element)v.get(126)).setAttribute("width","100%" );
      ((Element)v.get(113)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","1" );
      ((Element)v.get(127)).setAttribute("height","1" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:113   */

      /* Empieza nodo:128 / Elemento padre: 94   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(94)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("td"));
      ((Element)v.get(129)).setAttribute("colspan","4" );
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
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:131 / Elemento padre: 91   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(91)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("td"));
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("table"));
      ((Element)v.get(133)).setAttribute("width","730" );
      ((Element)v.get(133)).setAttribute("border","0" );
      ((Element)v.get(133)).setAttribute("align","left" );
      ((Element)v.get(133)).setAttribute("cellspacing","0" );
      ((Element)v.get(133)).setAttribute("cellpadding","0" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
   }

   private void getXML540(Document doc) {
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","8" );
      ((Element)v.get(136)).setAttribute("height","8" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(138)).setAttribute("nombre","lblCatalogo" );
      ((Element)v.get(138)).setAttribute("alto","13" );
      ((Element)v.get(138)).setAttribute("filas","1" );
      ((Element)v.get(138)).setAttribute("id","datosTitle" );
      ((Element)v.get(138)).setAttribute("cod","516" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","25" );
      ((Element)v.get(140)).setAttribute("height","8" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(142)).setAttribute("nombre","lblArgumentoVenta" );
      ((Element)v.get(142)).setAttribute("alto","13" );
      ((Element)v.get(142)).setAttribute("filas","1" );
      ((Element)v.get(142)).setAttribute("id","datosTitle" );
      ((Element)v.get(142)).setAttribute("cod","528" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 134   */
      v.add(doc.createElement("td"));
      ((Element)v.get(143)).setAttribute("width","100%" );
      ((Element)v.get(134)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","8" );
      ((Element)v.get(144)).setAttribute("height","8" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:134   */

      /* Empieza nodo:145 / Elemento padre: 133   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(133)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
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
      ((Element)v.get(145)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(149)).setAttribute("nombre","lbldtCatalogo" );
      ((Element)v.get(149)).setAttribute("alto","13" );
      ((Element)v.get(149)).setAttribute("filas","1" );
      ((Element)v.get(149)).setAttribute("valor","" );
      ((Element)v.get(149)).setAttribute("id","datosCampos" );
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
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(153)).setAttribute("nombre","cbArgumentoVenta" );
      ((Element)v.get(153)).setAttribute("id","datosCampos" );
      ((Element)v.get(153)).setAttribute("size","1" );
      ((Element)v.get(153)).setAttribute("multiple","N" );
      ((Element)v.get(153)).setAttribute("req","N" );
      ((Element)v.get(153)).setAttribute("valorinicial","" );
      ((Element)v.get(153)).setAttribute("textoinicial","" );
      ((Element)v.get(153)).setAttribute("ontab","tabGenerico('cbArgumentoVenta');" );
      ((Element)v.get(153)).setAttribute("onshtab","tabGenerico('cbArgumentoVenta','sh');" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:155 / Elemento padre: 145   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).setAttribute("width","100%" );
      ((Element)v.get(145)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","1" );
      ((Element)v.get(156)).setAttribute("height","1" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:145   */

      /* Empieza nodo:157 / Elemento padre: 133   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(133)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
   }

   private void getXML630(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(158)).setAttribute("colspan","4" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","8" );
      ((Element)v.get(159)).setAttribute("height","8" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:91   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:160 / Elemento padre: 84   */
      v.add(doc.createElement("td"));
      ((Element)v.get(84)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:84   */

      /* Empieza nodo:162 / Elemento padre: 76   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(76)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(163)).setAttribute("width","12" );
      ((Element)v.get(163)).setAttribute("align","center" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","12" );
      ((Element)v.get(164)).setAttribute("height","12" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).setAttribute("width","756" );
      ((Element)v.get(162)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(166)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:167 / Elemento padre: 162   */
      v.add(doc.createElement("td"));
      ((Element)v.get(167)).setAttribute("width","12" );
      ((Element)v.get(162)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","12" );
      ((Element)v.get(168)).setAttribute("height","1" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */
      /* Termina nodo:162   */
      /* Termina nodo:76   */

      /* Empieza nodo:169 / Elemento padre: 13   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(169)).setAttribute("nombre","listado1" );
      ((Element)v.get(169)).setAttribute("ancho","733" );
      ((Element)v.get(169)).setAttribute("alto","108" );
      ((Element)v.get(169)).setAttribute("x","12" );
      ((Element)v.get(169)).setAttribute("y","132" );
      ((Element)v.get(169)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(169)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(13)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(170)).setAttribute("precarga","S" );
      ((Element)v.get(170)).setAttribute("conROver","S" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(171)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(171)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(171)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(171)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */

      /* Empieza nodo:172 / Elemento padre: 170   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(172)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(172)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(172)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(172)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(170)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */

      /* Empieza nodo:173 / Elemento padre: 170   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(173)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(173)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(170)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:170   */

      /* Empieza nodo:174 / Elemento padre: 169   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(169)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(175)).setAttribute("borde","1" );
      ((Element)v.get(175)).setAttribute("horizDatos","1" );
      ((Element)v.get(175)).setAttribute("horizCabecera","1" );
      ((Element)v.get(175)).setAttribute("vertical","1" );
      ((Element)v.get(175)).setAttribute("horizTitulo","1" );
      ((Element)v.get(175)).setAttribute("horizBase","1" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */

      /* Empieza nodo:176 / Elemento padre: 174   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(176)).setAttribute("borde","#999999" );
      ((Element)v.get(176)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(176)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(176)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(176)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(176)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(176)).setAttribute("horizBase","#999999" );
      ((Element)v.get(174)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:174   */

      /* Empieza nodo:177 / Elemento padre: 169   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(177)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(177)).setAttribute("alto","22" );
      ((Element)v.get(177)).setAttribute("imgFondo","" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(177)).setAttribute("cod","579" );
      ((Element)v.get(177)).setAttribute("ID","datosTitle" );
      ((Element)v.get(169)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 169   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(178)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(178)).setAttribute("alto","22" );
      ((Element)v.get(178)).setAttribute("imgFondo","" );
      ((Element)v.get(169)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */

      /* Empieza nodo:179 / Elemento padre: 169   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(179)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(179)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(179)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(179)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(179)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(179)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(169)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(180)).setAttribute("ancho","100" );
      ((Element)v.get(180)).setAttribute("minimizable","S" );
      ((Element)v.get(180)).setAttribute("minimizada","N" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 179   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(181)).setAttribute("ancho","100" );
      ((Element)v.get(181)).setAttribute("minimizable","S" );
      ((Element)v.get(181)).setAttribute("minimizada","N" );
      ((Element)v.get(179)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */

      /* Empieza nodo:182 / Elemento padre: 179   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(182)).setAttribute("ancho","100" );
      ((Element)v.get(182)).setAttribute("minimizable","S" );
      ((Element)v.get(182)).setAttribute("minimizada","N" );
      ((Element)v.get(179)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 179   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(183)).setAttribute("ancho","100" );
      ((Element)v.get(183)).setAttribute("minimizable","S" );
      ((Element)v.get(183)).setAttribute("minimizada","N" );
      ((Element)v.get(179)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */

      /* Empieza nodo:184 / Elemento padre: 179   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(184)).setAttribute("ancho","120" );
      ((Element)v.get(184)).setAttribute("minimizable","S" );
      ((Element)v.get(184)).setAttribute("minimizada","N" );
      ((Element)v.get(179)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */

      /* Empieza nodo:185 / Elemento padre: 179   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(185)).setAttribute("ancho","100" );
      ((Element)v.get(185)).setAttribute("minimizable","S" );
      ((Element)v.get(185)).setAttribute("minimizada","N" );
      ((Element)v.get(179)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */

      /* Empieza nodo:186 / Elemento padre: 179   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(186)).setAttribute("ancho","100" );
      ((Element)v.get(186)).setAttribute("minimizable","S" );
      ((Element)v.get(186)).setAttribute("minimizada","N" );
      ((Element)v.get(179)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */

      /* Empieza nodo:187 / Elemento padre: 179   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(187)).setAttribute("ancho","100" );
      ((Element)v.get(187)).setAttribute("minimizable","S" );
      ((Element)v.get(187)).setAttribute("minimizada","N" );
      ((Element)v.get(179)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */

      /* Empieza nodo:188 / Elemento padre: 179   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(188)).setAttribute("ancho","100" );
      ((Element)v.get(188)).setAttribute("minimizable","S" );
      ((Element)v.get(188)).setAttribute("minimizada","N" );
      ((Element)v.get(179)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:179   */

      /* Empieza nodo:189 / Elemento padre: 169   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(189)).setAttribute("alto","20" );
      ((Element)v.get(189)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(189)).setAttribute("imgFondo","" );
      ((Element)v.get(189)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(169)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(190)).setAttribute("colFondo","" );
      ((Element)v.get(190)).setAttribute("ID","EstCab" );
      ((Element)v.get(190)).setAttribute("cod","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Elemento padre:190 / Elemento actual: 191   */
      v.add(doc.createTextNode("Código"));
      ((Element)v.get(190)).appendChild((Text)v.get(191));

      /* Termina nodo Texto:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 189   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(192)).setAttribute("colFondo","" );
      ((Element)v.get(192)).setAttribute("ID","EstCab" );
      ((Element)v.get(192)).setAttribute("cod","9" );
      ((Element)v.get(189)).appendChild((Element)v.get(192));

      /* Elemento padre:192 / Elemento actual: 193   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(192)).appendChild((Text)v.get(193));

      /* Termina nodo Texto:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:194 / Elemento padre: 189   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(194)).setAttribute("colFondo","" );
      ((Element)v.get(194)).setAttribute("ID","EstCab" );
      ((Element)v.get(194)).setAttribute("cod","608" );
      ((Element)v.get(189)).appendChild((Element)v.get(194));

      /* Elemento padre:194 / Elemento actual: 195   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(194)).appendChild((Text)v.get(195));

      /* Termina nodo Texto:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 189   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(196)).setAttribute("colFondo","" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(196)).setAttribute("ID","EstCab" );
      ((Element)v.get(196)).setAttribute("cod","581" );
      ((Element)v.get(189)).appendChild((Element)v.get(196));

      /* Elemento padre:196 / Elemento actual: 197   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(196)).appendChild((Text)v.get(197));

      /* Termina nodo Texto:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 189   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(198)).setAttribute("colFondo","" );
      ((Element)v.get(198)).setAttribute("ID","EstCab" );
      ((Element)v.get(198)).setAttribute("cod","529" );
      ((Element)v.get(189)).appendChild((Element)v.get(198));

      /* Elemento padre:198 / Elemento actual: 199   */
      v.add(doc.createTextNode("Factor repetición"));
      ((Element)v.get(198)).appendChild((Text)v.get(199));

      /* Termina nodo Texto:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 189   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(200)).setAttribute("colFondo","" );
      ((Element)v.get(200)).setAttribute("ID","EstCab" );
      ((Element)v.get(200)).setAttribute("cod","530" );
      ((Element)v.get(189)).appendChild((Element)v.get(200));

      /* Elemento padre:200 / Elemento actual: 201   */
      v.add(doc.createTextNode("Precio unitario"));
      ((Element)v.get(200)).appendChild((Text)v.get(201));

      /* Termina nodo Texto:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 189   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(202)).setAttribute("colFondo","" );
      ((Element)v.get(202)).setAttribute("ID","EstCab" );
      ((Element)v.get(202)).setAttribute("cod","481" );
      ((Element)v.get(189)).appendChild((Element)v.get(202));

      /* Elemento padre:202 / Elemento actual: 203   */
      v.add(doc.createTextNode("Atributo 1"));
      ((Element)v.get(202)).appendChild((Text)v.get(203));

      /* Termina nodo Texto:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 189   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(204)).setAttribute("colFondo","" );
      ((Element)v.get(204)).setAttribute("ID","EstCab" );
      ((Element)v.get(204)).setAttribute("cod","482" );
      ((Element)v.get(189)).appendChild((Element)v.get(204));

      /* Elemento padre:204 / Elemento actual: 205   */
      v.add(doc.createTextNode("Atributo 2"));
      ((Element)v.get(204)).appendChild((Text)v.get(205));

      /* Termina nodo Texto:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 189   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(206)).setAttribute("colFondo","" );
      ((Element)v.get(206)).setAttribute("ID","EstCab" );
      ((Element)v.get(206)).setAttribute("cod","483" );
      ((Element)v.get(189)).appendChild((Element)v.get(206));

      /* Elemento padre:206 / Elemento actual: 207   */
      v.add(doc.createTextNode("Atributo 3"));
      ((Element)v.get(206)).appendChild((Text)v.get(207));

      /* Termina nodo Texto:207   */
      /* Termina nodo:206   */
      /* Termina nodo:189   */

      /* Empieza nodo:208 / Elemento padre: 169   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(208)).setAttribute("alto","22" );
      ((Element)v.get(208)).setAttribute("accion","" );
      ((Element)v.get(208)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(208)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(208)).setAttribute("maxSel","-1" );
      ((Element)v.get(208)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(208)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(208)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(208)).setAttribute("onLoad","" );
      ((Element)v.get(208)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(169)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(209)).setAttribute("tipo","texto" );
      ((Element)v.get(209)).setAttribute("ID","EstDat" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */

      /* Empieza nodo:210 / Elemento padre: 208   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(210)).setAttribute("tipo","texto" );
      ((Element)v.get(210)).setAttribute("ID","EstDat2" );
      ((Element)v.get(208)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */

      /* Empieza nodo:211 / Elemento padre: 208   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(211)).setAttribute("tipo","texto" );
      ((Element)v.get(211)).setAttribute("ID","EstDat" );
      ((Element)v.get(208)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */

      /* Empieza nodo:212 / Elemento padre: 208   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(212)).setAttribute("tipo","texto" );
      ((Element)v.get(212)).setAttribute("ID","EstDat2" );
      ((Element)v.get(208)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */

      /* Empieza nodo:213 / Elemento padre: 208   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(213)).setAttribute("tipo","texto" );
      ((Element)v.get(213)).setAttribute("ID","EstDat" );
      ((Element)v.get(208)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */

      /* Empieza nodo:214 / Elemento padre: 208   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(214)).setAttribute("tipo","texto" );
      ((Element)v.get(214)).setAttribute("ID","EstDat2" );
      ((Element)v.get(208)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */

      /* Empieza nodo:215 / Elemento padre: 208   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(215)).setAttribute("tipo","texto" );
      ((Element)v.get(215)).setAttribute("ID","EstDat" );
      ((Element)v.get(208)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */

      /* Empieza nodo:216 / Elemento padre: 208   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(216)).setAttribute("tipo","texto" );
      ((Element)v.get(216)).setAttribute("ID","EstDat2" );
      ((Element)v.get(208)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */

      /* Empieza nodo:217 / Elemento padre: 208   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(217)).setAttribute("tipo","texto" );
      ((Element)v.get(217)).setAttribute("ID","EstDat" );
      ((Element)v.get(208)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:208   */

      /* Empieza nodo:218 / Elemento padre: 169   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(169)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */

      /* Empieza nodo:219 / Elemento padre: 169   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(219)).setAttribute("nombre","mipgndo1" );
      ((Element)v.get(219)).setAttribute("ancho","733" );
      ((Element)v.get(219)).setAttribute("sep","$" );
      ((Element)v.get(219)).setAttribute("x","12" );
      ((Element)v.get(219)).setAttribute("class","botonera" );
      ((Element)v.get(219)).setAttribute("y","217" );
      ((Element)v.get(219)).setAttribute("control","|" );
      ((Element)v.get(219)).setAttribute("conector","conector_tapon_esp" );
      ((Element)v.get(219)).setAttribute("rowset","" );
      ((Element)v.get(219)).setAttribute("cargainicial","N" );
      ((Element)v.get(169)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:169   */

      /* Empieza nodo:220 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(220)).setAttribute("nombre","separa1" );
      ((Element)v.get(220)).setAttribute("x","59" );
      ((Element)v.get(220)).setAttribute("y","217" );
      ((Element)v.get(220)).setAttribute("ID","botonContenido" );
      ((Element)v.get(220)).setAttribute("img","separa_base" );
      ((Element)v.get(220)).setAttribute("tipo","0" );
      ((Element)v.get(220)).setAttribute("estado","false" );
      ((Element)v.get(220)).setAttribute("alt","" );
      ((Element)v.get(220)).setAttribute("codigo","" );
      ((Element)v.get(220)).setAttribute("accion","" );
      ((Element)v.get(13)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */

      /* Empieza nodo:221 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(221)).setAttribute("nombre","Buscar" );
      ((Element)v.get(221)).setAttribute("x","13" );
      ((Element)v.get(221)).setAttribute("y","218" );
      ((Element)v.get(221)).setAttribute("ID","botonContenido" );
      ((Element)v.get(221)).setAttribute("tipo","html" );
      ((Element)v.get(221)).setAttribute("estado","false" );
      ((Element)v.get(221)).setAttribute("cod","1" );
      ((Element)v.get(221)).setAttribute("accion","accionBuscarProducto();" );
      ((Element)v.get(221)).setAttribute("ontab","tabGenerico('Buscar');" );
      ((Element)v.get(221)).setAttribute("onshtab","tabGenerico('Buscar','sh');" );
      ((Element)v.get(13)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */

      /* Empieza nodo:222 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(222)).setAttribute("nombre","Modificar" );
      ((Element)v.get(222)).setAttribute("x","65" );
      ((Element)v.get(222)).setAttribute("y","218" );
      ((Element)v.get(222)).setAttribute("ID","botonContenido" );
      ((Element)v.get(222)).setAttribute("tipo","html" );
      ((Element)v.get(222)).setAttribute("estado","false" );
      ((Element)v.get(222)).setAttribute("cod","2" );
      ((Element)v.get(222)).setAttribute("accion","accionModificarProducto();" );
      ((Element)v.get(222)).setAttribute("ontab","tabGenerico('Modificar');" );
      ((Element)v.get(222)).setAttribute("onshtab","tabGenerico('Modificar','sh');" );
      ((Element)v.get(13)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */

      /* Empieza nodo:223 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(223)).setAttribute("nombre","Consultar" );
      ((Element)v.get(223)).setAttribute("x","13" );
      ((Element)v.get(223)).setAttribute("y","218" );
      ((Element)v.get(223)).setAttribute("ID","botonContenido" );
      ((Element)v.get(223)).setAttribute("tipo","html" );
      ((Element)v.get(223)).setAttribute("estado","false" );
      ((Element)v.get(223)).setAttribute("cod","150" );
      ((Element)v.get(223)).setAttribute("accion","accionConsultarProducto();" );
      ((Element)v.get(223)).setAttribute("ontab","tabGenerico('Consultar');" );
      ((Element)v.get(223)).setAttribute("onshtab","tabGenerico('Consultar','sh');" );
      ((Element)v.get(13)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */

      /* Empieza nodo:224 / Elemento padre: 13   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(224)).setAttribute("nombre","listado2" );
      ((Element)v.get(224)).setAttribute("ancho","733" );
      ((Element)v.get(224)).setAttribute("alto","317" );
      ((Element)v.get(224)).setAttribute("x","12" );
      ((Element)v.get(224)).setAttribute("y","264" );
      ((Element)v.get(224)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(224)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(13)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(225)).setAttribute("precarga","S" );
      ((Element)v.get(225)).setAttribute("conROver","S" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(226)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(226)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(226)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(226)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */

      /* Empieza nodo:227 / Elemento padre: 225   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(227)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(227)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(227)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(227)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(225)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */

      /* Empieza nodo:228 / Elemento padre: 225   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(228)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(228)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(225)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:225   */

      /* Empieza nodo:229 / Elemento padre: 224   */
      v.add(doc.createElement("LINEAS"));
   }

   private void getXML990(Document doc) {
      ((Element)v.get(224)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(230)).setAttribute("borde","1" );
      ((Element)v.get(230)).setAttribute("horizDatos","1" );
      ((Element)v.get(230)).setAttribute("horizCabecera","1" );
      ((Element)v.get(230)).setAttribute("vertical","1" );
      ((Element)v.get(230)).setAttribute("horizTitulo","1" );
      ((Element)v.get(230)).setAttribute("horizBase","1" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */

      /* Empieza nodo:231 / Elemento padre: 229   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(231)).setAttribute("borde","#999999" );
      ((Element)v.get(231)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(231)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(231)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(231)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(231)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(231)).setAttribute("horizBase","#999999" );
      ((Element)v.get(229)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:229   */

      /* Empieza nodo:232 / Elemento padre: 224   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(232)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(232)).setAttribute("alto","22" );
      ((Element)v.get(232)).setAttribute("imgFondo","" );
      ((Element)v.get(232)).setAttribute("cod","532" );
      ((Element)v.get(232)).setAttribute("ID","datosTitle" );
      ((Element)v.get(224)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */

      /* Empieza nodo:233 / Elemento padre: 224   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(233)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(233)).setAttribute("alto","22" );
      ((Element)v.get(233)).setAttribute("imgFondo","" );
      ((Element)v.get(224)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */

      /* Empieza nodo:234 / Elemento padre: 224   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(234)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(234)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(234)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(234)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(234)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(234)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(224)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(235)).setAttribute("ancho","100" );
      ((Element)v.get(235)).setAttribute("minimizable","S" );
      ((Element)v.get(235)).setAttribute("minimizada","N" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */

      /* Empieza nodo:236 / Elemento padre: 234   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(236)).setAttribute("ancho","100" );
      ((Element)v.get(236)).setAttribute("minimizable","S" );
      ((Element)v.get(236)).setAttribute("minimizada","N" );
      ((Element)v.get(234)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */

      /* Empieza nodo:237 / Elemento padre: 234   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(237)).setAttribute("ancho","100" );
      ((Element)v.get(237)).setAttribute("minimizable","S" );
      ((Element)v.get(237)).setAttribute("minimizada","N" );
      ((Element)v.get(234)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */

      /* Empieza nodo:238 / Elemento padre: 234   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(238)).setAttribute("ancho","100" );
      ((Element)v.get(238)).setAttribute("minimizable","S" );
      ((Element)v.get(238)).setAttribute("minimizada","N" );
      ((Element)v.get(234)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */

      /* Empieza nodo:239 / Elemento padre: 234   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(239)).setAttribute("ancho","120" );
      ((Element)v.get(239)).setAttribute("minimizable","S" );
      ((Element)v.get(239)).setAttribute("minimizada","N" );
      ((Element)v.get(234)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */

      /* Empieza nodo:240 / Elemento padre: 234   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(240)).setAttribute("ancho","100" );
      ((Element)v.get(240)).setAttribute("minimizable","S" );
      ((Element)v.get(240)).setAttribute("minimizada","N" );
      ((Element)v.get(234)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */

      /* Empieza nodo:241 / Elemento padre: 234   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(241)).setAttribute("ancho","100" );
      ((Element)v.get(241)).setAttribute("minimizable","S" );
      ((Element)v.get(241)).setAttribute("minimizada","N" );
      ((Element)v.get(234)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */

      /* Empieza nodo:242 / Elemento padre: 234   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(242)).setAttribute("ancho","100" );
      ((Element)v.get(242)).setAttribute("minimizable","S" );
      ((Element)v.get(242)).setAttribute("minimizada","N" );
      ((Element)v.get(234)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */

      /* Empieza nodo:243 / Elemento padre: 234   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(243)).setAttribute("ancho","100" );
      ((Element)v.get(243)).setAttribute("minimizable","S" );
      ((Element)v.get(243)).setAttribute("minimizada","N" );
      ((Element)v.get(234)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:234   */

      /* Empieza nodo:244 / Elemento padre: 224   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(244)).setAttribute("alto","20" );
      ((Element)v.get(244)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(244)).setAttribute("imgFondo","" );
      ((Element)v.get(244)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(224)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("COL"));
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(245)).setAttribute("colFondo","" );
      ((Element)v.get(245)).setAttribute("ID","EstCab" );
      ((Element)v.get(245)).setAttribute("cod","8" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));

      /* Elemento padre:245 / Elemento actual: 246   */
      v.add(doc.createTextNode("Código"));
      ((Element)v.get(245)).appendChild((Text)v.get(246));

      /* Termina nodo Texto:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:247 / Elemento padre: 244   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(247)).setAttribute("colFondo","" );
      ((Element)v.get(247)).setAttribute("ID","EstCab" );
      ((Element)v.get(247)).setAttribute("cod","9" );
      ((Element)v.get(244)).appendChild((Element)v.get(247));

      /* Elemento padre:247 / Elemento actual: 248   */
      v.add(doc.createTextNode("Descripción"));
      ((Element)v.get(247)).appendChild((Text)v.get(248));

      /* Termina nodo Texto:248   */
      /* Termina nodo:247   */

      /* Empieza nodo:249 / Elemento padre: 244   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(249)).setAttribute("colFondo","" );
      ((Element)v.get(249)).setAttribute("ID","EstCab" );
      ((Element)v.get(249)).setAttribute("cod","608" );
      ((Element)v.get(244)).appendChild((Element)v.get(249));

      /* Elemento padre:249 / Elemento actual: 250   */
      v.add(doc.createTextNode("Tipo oferta"));
      ((Element)v.get(249)).appendChild((Text)v.get(250));

      /* Termina nodo Texto:250   */
      /* Termina nodo:249   */

      /* Empieza nodo:251 / Elemento padre: 244   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(251)).setAttribute("colFondo","" );
      ((Element)v.get(251)).setAttribute("ID","EstCab" );
      ((Element)v.get(251)).setAttribute("cod","581" );
      ((Element)v.get(244)).appendChild((Element)v.get(251));

      /* Elemento padre:251 / Elemento actual: 252   */
      v.add(doc.createTextNode("Ciclo vida"));
      ((Element)v.get(251)).appendChild((Text)v.get(252));

      /* Termina nodo Texto:252   */
      /* Termina nodo:251   */

      /* Empieza nodo:253 / Elemento padre: 244   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(253)).setAttribute("colFondo","" );
      ((Element)v.get(253)).setAttribute("ID","EstCab" );
      ((Element)v.get(253)).setAttribute("cod","529" );
      ((Element)v.get(244)).appendChild((Element)v.get(253));

      /* Elemento padre:253 / Elemento actual: 254   */
      v.add(doc.createTextNode("Factor repetición"));
      ((Element)v.get(253)).appendChild((Text)v.get(254));

      /* Termina nodo Texto:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:255 / Elemento padre: 244   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(255)).setAttribute("colFondo","" );
      ((Element)v.get(255)).setAttribute("ID","EstCab" );
      ((Element)v.get(255)).setAttribute("cod","530" );
      ((Element)v.get(244)).appendChild((Element)v.get(255));

      /* Elemento padre:255 / Elemento actual: 256   */
      v.add(doc.createTextNode("Precio unitario"));
      ((Element)v.get(255)).appendChild((Text)v.get(256));

      /* Termina nodo Texto:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:257 / Elemento padre: 244   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(257)).setAttribute("colFondo","" );
      ((Element)v.get(257)).setAttribute("ID","EstCab" );
      ((Element)v.get(257)).setAttribute("cod","481" );
      ((Element)v.get(244)).appendChild((Element)v.get(257));

      /* Elemento padre:257 / Elemento actual: 258   */
      v.add(doc.createTextNode("Atributo 1"));
      ((Element)v.get(257)).appendChild((Text)v.get(258));

      /* Termina nodo Texto:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:259 / Elemento padre: 244   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(259)).setAttribute("colFondo","" );
      ((Element)v.get(259)).setAttribute("ID","EstCab" );
      ((Element)v.get(259)).setAttribute("cod","482" );
      ((Element)v.get(244)).appendChild((Element)v.get(259));

      /* Elemento padre:259 / Elemento actual: 260   */
      v.add(doc.createTextNode("Atributo 2"));
      ((Element)v.get(259)).appendChild((Text)v.get(260));

      /* Termina nodo Texto:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:261 / Elemento padre: 244   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(261)).setAttribute("colFondo","" );
      ((Element)v.get(261)).setAttribute("ID","EstCab" );
      ((Element)v.get(261)).setAttribute("cod","483" );
      ((Element)v.get(244)).appendChild((Element)v.get(261));

      /* Elemento padre:261 / Elemento actual: 262   */
      v.add(doc.createTextNode("Atributo 3"));
      ((Element)v.get(261)).appendChild((Text)v.get(262));

      /* Termina nodo Texto:262   */
      /* Termina nodo:261   */
      /* Termina nodo:244   */

      /* Empieza nodo:263 / Elemento padre: 224   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(263)).setAttribute("alto","22" );
      ((Element)v.get(263)).setAttribute("accion","" );
      ((Element)v.get(263)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(263)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(263)).setAttribute("maxSel","-1" );
      ((Element)v.get(263)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(263)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(263)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(263)).setAttribute("onLoad","" );
      ((Element)v.get(263)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(224)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(264)).setAttribute("tipo","texto" );
      ((Element)v.get(264)).setAttribute("ID","EstDat" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */

      /* Empieza nodo:265 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(265)).setAttribute("tipo","texto" );
      ((Element)v.get(265)).setAttribute("ID","EstDat2" );
      ((Element)v.get(263)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */

      /* Empieza nodo:266 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(266)).setAttribute("tipo","texto" );
      ((Element)v.get(266)).setAttribute("ID","EstDat" );
      ((Element)v.get(263)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */

      /* Empieza nodo:267 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(267)).setAttribute("tipo","texto" );
      ((Element)v.get(267)).setAttribute("ID","EstDat2" );
      ((Element)v.get(263)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */

      /* Empieza nodo:268 / Elemento padre: 263   */
   }

   private void getXML1170(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(268)).setAttribute("tipo","texto" );
      ((Element)v.get(268)).setAttribute("ID","EstDat" );
      ((Element)v.get(263)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */

      /* Empieza nodo:269 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(269)).setAttribute("tipo","texto" );
      ((Element)v.get(269)).setAttribute("ID","EstDat2" );
      ((Element)v.get(263)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */

      /* Empieza nodo:270 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(270)).setAttribute("tipo","texto" );
      ((Element)v.get(270)).setAttribute("ID","EstDat" );
      ((Element)v.get(263)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */

      /* Empieza nodo:271 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(271)).setAttribute("tipo","texto" );
      ((Element)v.get(271)).setAttribute("ID","EstDat2" );
      ((Element)v.get(263)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */

      /* Empieza nodo:272 / Elemento padre: 263   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(272)).setAttribute("tipo","texto" );
      ((Element)v.get(272)).setAttribute("ID","EstDat" );
      ((Element)v.get(263)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:263   */

      /* Empieza nodo:273 / Elemento padre: 224   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(224)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */

      /* Empieza nodo:274 / Elemento padre: 224   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(274)).setAttribute("nombre","mipgndo2" );
      ((Element)v.get(274)).setAttribute("ancho","733" );
      ((Element)v.get(274)).setAttribute("sep","$" );
      ((Element)v.get(274)).setAttribute("x","12" );
      ((Element)v.get(274)).setAttribute("class","botonera" );
      ((Element)v.get(274)).setAttribute("y","558" );
      ((Element)v.get(274)).setAttribute("control","|" );
      ((Element)v.get(274)).setAttribute("conector","conector_tapon_esp" );
      ((Element)v.get(274)).setAttribute("rowset","" );
      ((Element)v.get(274)).setAttribute("cargainicial","N" );
      ((Element)v.get(224)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:224   */

      /* Empieza nodo:275 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(275)).setAttribute("nombre","separa2" );
      ((Element)v.get(275)).setAttribute("x","59" );
      ((Element)v.get(275)).setAttribute("y","558" );
      ((Element)v.get(275)).setAttribute("ID","botonContenido" );
      ((Element)v.get(275)).setAttribute("img","separa_base" );
      ((Element)v.get(275)).setAttribute("tipo","0" );
      ((Element)v.get(275)).setAttribute("estado","false" );
      ((Element)v.get(275)).setAttribute("alt","" );
      ((Element)v.get(275)).setAttribute("codigo","" );
      ((Element)v.get(275)).setAttribute("accion","" );
      ((Element)v.get(13)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */

      /* Empieza nodo:276 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(276)).setAttribute("nombre","Buscar2" );
      ((Element)v.get(276)).setAttribute("x","13" );
      ((Element)v.get(276)).setAttribute("y","559" );
      ((Element)v.get(276)).setAttribute("ID","botonContenido" );
      ((Element)v.get(276)).setAttribute("tipo","html" );
      ((Element)v.get(276)).setAttribute("estado","false" );
      ((Element)v.get(276)).setAttribute("cod","1" );
      ((Element)v.get(276)).setAttribute("accion","accionBuscarProductoAsoc();" );
      ((Element)v.get(276)).setAttribute("ontab","tabGenerico('Buscar2');" );
      ((Element)v.get(276)).setAttribute("onshtab","tabGenerico('Buscar2','sh');" );
      ((Element)v.get(13)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */

      /* Empieza nodo:277 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(277)).setAttribute("nombre","Eliminar2" );
      ((Element)v.get(277)).setAttribute("x","65" );
      ((Element)v.get(277)).setAttribute("y","559" );
      ((Element)v.get(277)).setAttribute("ID","botonContenido" );
      ((Element)v.get(277)).setAttribute("tipo","html" );
      ((Element)v.get(277)).setAttribute("estado","false" );
      ((Element)v.get(277)).setAttribute("cod","1254" );
      ((Element)v.get(277)).setAttribute("accion","accionEliminarProductos();" );
      ((Element)v.get(277)).setAttribute("ontab","tabGenerico('Eliminar2');" );
      ((Element)v.get(277)).setAttribute("onshtab","tabGenerico('Eliminar2','sh');" );
      ((Element)v.get(13)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */

      /* Empieza nodo:278 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(278)).setAttribute("nombre","Modificar2" );
      ((Element)v.get(278)).setAttribute("x","120" );
      ((Element)v.get(278)).setAttribute("y","559" );
      ((Element)v.get(278)).setAttribute("ID","botonContenido" );
      ((Element)v.get(278)).setAttribute("tipo","html" );
      ((Element)v.get(278)).setAttribute("estado","false" );
      ((Element)v.get(278)).setAttribute("cod","2" );
      ((Element)v.get(278)).setAttribute("accion","accionModificarProductoAsociado();" );
      ((Element)v.get(278)).setAttribute("ontab","tabGenerico('Modificar2');" );
      ((Element)v.get(278)).setAttribute("onshtab","tabGenerico('Modificar2','sh');" );
      ((Element)v.get(13)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */

      /* Empieza nodo:279 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(279)).setAttribute("nombre","Consultar2" );
      ((Element)v.get(279)).setAttribute("x","13" );
      ((Element)v.get(279)).setAttribute("y","559" );
      ((Element)v.get(279)).setAttribute("ID","botonContenido" );
      ((Element)v.get(279)).setAttribute("tipo","html" );
      ((Element)v.get(279)).setAttribute("estado","false" );
      ((Element)v.get(279)).setAttribute("cod","150" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(279)).setAttribute("accion","accionConsultarProductoAsociado();" );
      ((Element)v.get(279)).setAttribute("ontab","tabGenerico('Consultar2');" );
      ((Element)v.get(279)).setAttribute("onshtab","tabGenerico('Consultar2','sh');" );
      ((Element)v.get(13)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */

      /* Empieza nodo:280 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(280)).setAttribute("nombre","capaDatosGenerales" );
      ((Element)v.get(280)).setAttribute("alto","200" );
      ((Element)v.get(280)).setAttribute("ancho","100%" );
      ((Element)v.get(280)).setAttribute("colorf","" );
      ((Element)v.get(280)).setAttribute("borde","0" );
      ((Element)v.get(280)).setAttribute("imagenf","" );
      ((Element)v.get(280)).setAttribute("repeat","" );
      ((Element)v.get(280)).setAttribute("padding","" );
      ((Element)v.get(280)).setAttribute("visibilidad","visible" );
      ((Element)v.get(280)).setAttribute("contravsb","" );
      ((Element)v.get(280)).setAttribute("x","0" );
      ((Element)v.get(280)).setAttribute("y","593" );
      ((Element)v.get(280)).setAttribute("zindex","" );
      ((Element)v.get(13)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("table"));
      ((Element)v.get(281)).setAttribute("width","100%" );
      ((Element)v.get(281)).setAttribute("border","0" );
      ((Element)v.get(281)).setAttribute("cellspacing","0" );
      ((Element)v.get(281)).setAttribute("cellpadding","0" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(281)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("td"));
      ((Element)v.get(283)).setAttribute("width","12" );
      ((Element)v.get(283)).setAttribute("align","center" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(284)).setAttribute("src","b.gif" );
      ((Element)v.get(284)).setAttribute("width","12" );
      ((Element)v.get(284)).setAttribute("height","12" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:285 / Elemento padre: 282   */
      v.add(doc.createElement("td"));
      ((Element)v.get(285)).setAttribute("width","750" );
      ((Element)v.get(282)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(286)).setAttribute("src","b.gif" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:285   */

      /* Empieza nodo:287 / Elemento padre: 282   */
      v.add(doc.createElement("td"));
      ((Element)v.get(287)).setAttribute("width","12" );
      ((Element)v.get(282)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(288)).setAttribute("src","b.gif" );
      ((Element)v.get(288)).setAttribute("width","12" );
      ((Element)v.get(288)).setAttribute("height","1" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:287   */
      /* Termina nodo:282   */

      /* Empieza nodo:289 / Elemento padre: 281   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(281)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(289)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(291)).setAttribute("src","b.gif" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */

      /* Empieza nodo:292 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(289)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(292)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(294)).setAttribute("class","legend" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(295)).setAttribute("nombre","lblDatosGenerales" );
      ((Element)v.get(295)).setAttribute("alto","13" );
      ((Element)v.get(295)).setAttribute("filas","1" );
      ((Element)v.get(295)).setAttribute("valor","" );
      ((Element)v.get(295)).setAttribute("id","legend" );
      ((Element)v.get(295)).setAttribute("cod","0011" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */

      /* Empieza nodo:296 / Elemento padre: 293   */
      v.add(doc.createElement("table"));
      ((Element)v.get(296)).setAttribute("width","100%" );
      ((Element)v.get(296)).setAttribute("border","0" );
      ((Element)v.get(296)).setAttribute("align","center" );
      ((Element)v.get(296)).setAttribute("cellspacing","0" );
      ((Element)v.get(296)).setAttribute("cellpadding","0" );
      ((Element)v.get(293)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(296)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("td"));
      ((Element)v.get(297)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("table"));
      ((Element)v.get(299)).setAttribute("width","730" );
      ((Element)v.get(299)).setAttribute("border","0" );
      ((Element)v.get(299)).setAttribute("align","left" );
      ((Element)v.get(299)).setAttribute("cellspacing","0" );
      ((Element)v.get(299)).setAttribute("cellpadding","0" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
   }

   private void getXML1350(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(299)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("td"));
      ((Element)v.get(301)).setAttribute("colspan","4" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(302)).setAttribute("src","b.gif" );
      ((Element)v.get(302)).setAttribute("width","8" );
      ((Element)v.get(302)).setAttribute("height","8" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */
      /* Termina nodo:300   */

      /* Empieza nodo:303 / Elemento padre: 299   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(299)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(305)).setAttribute("src","b.gif" );
      ((Element)v.get(305)).setAttribute("width","8" );
      ((Element)v.get(305)).setAttribute("height","8" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:304   */

      /* Empieza nodo:306 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(307)).setAttribute("nombre","lblNumeroGrupos" );
      ((Element)v.get(307)).setAttribute("alto","13" );
      ((Element)v.get(307)).setAttribute("filas","1" );
      ((Element)v.get(307)).setAttribute("valor","" );
      ((Element)v.get(307)).setAttribute("id","datosTitle" );
      ((Element)v.get(307)).setAttribute("cod","533" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:306   */

      /* Empieza nodo:308 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(309)).setAttribute("src","b.gif" );
      ((Element)v.get(309)).setAttribute("width","25" );
      ((Element)v.get(309)).setAttribute("height","8" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:310 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(311)).setAttribute("nombre","lblNumeroPaquetes" );
      ((Element)v.get(311)).setAttribute("alto","13" );
      ((Element)v.get(311)).setAttribute("filas","1" );
      ((Element)v.get(311)).setAttribute("valor","" );
      ((Element)v.get(311)).setAttribute("id","datosTitle" );
      ((Element)v.get(311)).setAttribute("cod","534" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:312 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(313)).setAttribute("src","b.gif" );
      ((Element)v.get(313)).setAttribute("width","25" );
      ((Element)v.get(313)).setAttribute("height","8" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:312   */

      /* Empieza nodo:314 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(303)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(315)).setAttribute("nombre","lblIndicadorCuadre" );
      ((Element)v.get(315)).setAttribute("alto","13" );
      ((Element)v.get(315)).setAttribute("filas","1" );
      ((Element)v.get(315)).setAttribute("valor","" );
      ((Element)v.get(315)).setAttribute("id","datosTitle" );
      ((Element)v.get(315)).setAttribute("cod","461" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:314   */

      /* Empieza nodo:316 / Elemento padre: 303   */
      v.add(doc.createElement("td"));
      ((Element)v.get(316)).setAttribute("width","100%" );
      ((Element)v.get(303)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(317)).setAttribute("src","b.gif" );
      ((Element)v.get(317)).setAttribute("width","8" );
      ((Element)v.get(317)).setAttribute("height","8" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:316   */
      /* Termina nodo:303   */

      /* Empieza nodo:318 / Elemento padre: 299   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(299)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(320)).setAttribute("src","b.gif" );
      ((Element)v.get(320)).setAttribute("width","8" );
      ((Element)v.get(320)).setAttribute("height","8" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */

      /* Empieza nodo:321 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(321)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(318)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(322)).setAttribute("nombre","txtNumeroGrupos" );
      ((Element)v.get(322)).setAttribute("id","datosCampos" );
      ((Element)v.get(322)).setAttribute("max","2" );
      ((Element)v.get(322)).setAttribute("tipo","" );
      ((Element)v.get(322)).setAttribute("onchange","" );
      ((Element)v.get(322)).setAttribute("req","N" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(322)).setAttribute("size","2" );
      ((Element)v.get(322)).setAttribute("valor","" );
      ((Element)v.get(322)).setAttribute("validacion","" );
      ((Element)v.get(322)).setAttribute("ontab","tabGenerico('txtNumeroGrupos');" );
      ((Element)v.get(322)).setAttribute("onshtab","tabGenerico('txtNumeroGrupos','sh');" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */
      /* Termina nodo:321   */

      /* Empieza nodo:323 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(324)).setAttribute("src","b.gif" );
      ((Element)v.get(324)).setAttribute("width","25" );
      ((Element)v.get(324)).setAttribute("height","8" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */
      /* Termina nodo:323   */

      /* Empieza nodo:325 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(325)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(318)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(326)).setAttribute("nombre","txtNumeroPaquetes" );
      ((Element)v.get(326)).setAttribute("id","datosCampos" );
      ((Element)v.get(326)).setAttribute("max","2" );
      ((Element)v.get(326)).setAttribute("tipo","" );
      ((Element)v.get(326)).setAttribute("onchange","" );
      ((Element)v.get(326)).setAttribute("req","N" );
      ((Element)v.get(326)).setAttribute("size","2" );
      ((Element)v.get(326)).setAttribute("valor","" );
      ((Element)v.get(326)).setAttribute("validacion","" );
      ((Element)v.get(326)).setAttribute("ontab","tabGenerico('txtNumeroPaquetes');" );
      ((Element)v.get(326)).setAttribute("onshtab","tabGenerico('txtNumeroPaquetes','sh');" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:325   */

      /* Empieza nodo:327 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(328)).setAttribute("src","b.gif" );
      ((Element)v.get(328)).setAttribute("width","25" );
      ((Element)v.get(328)).setAttribute("height","8" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:327   */

      /* Empieza nodo:329 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(329)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(318)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(330)).setAttribute("nombre","cbIndicadorCuadre" );
      ((Element)v.get(330)).setAttribute("id","datosCampos" );
      ((Element)v.get(330)).setAttribute("size","1" );
      ((Element)v.get(330)).setAttribute("multiple","N" );
      ((Element)v.get(330)).setAttribute("req","N" );
      ((Element)v.get(330)).setAttribute("valorinicial","" );
      ((Element)v.get(330)).setAttribute("textoinicial","" );
      ((Element)v.get(330)).setAttribute("ontab","tabGenerico('cbIndicadorCuadre');" );
      ((Element)v.get(330)).setAttribute("onshtab","tabGenerico('cbIndicadorCuadre','sh');" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:332 / Elemento padre: 318   */
      v.add(doc.createElement("td"));
      ((Element)v.get(332)).setAttribute("width","100%" );
      ((Element)v.get(318)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(333)).setAttribute("src","b.gif" );
      ((Element)v.get(333)).setAttribute("width","8" );
      ((Element)v.get(333)).setAttribute("height","8" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */
      /* Termina nodo:332   */
      /* Termina nodo:318   */

      /* Empieza nodo:334 / Elemento padre: 299   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(299)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("td"));
      ((Element)v.get(335)).setAttribute("colspan","4" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(336)).setAttribute("src","b.gif" );
      ((Element)v.get(336)).setAttribute("width","8" );
      ((Element)v.get(336)).setAttribute("height","8" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */
      /* Termina nodo:334   */
      /* Termina nodo:299   */
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:337 / Elemento padre: 296   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(296)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("td"));
      ((Element)v.get(337)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("table"));
      ((Element)v.get(339)).setAttribute("width","730" );
      ((Element)v.get(339)).setAttribute("border","0" );
      ((Element)v.get(339)).setAttribute("align","left" );
      ((Element)v.get(339)).setAttribute("cellspacing","0" );
      ((Element)v.get(339)).setAttribute("cellpadding","0" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(339)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("td"));
      ((Element)v.get(341)).setAttribute("colspan","4" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(342)).setAttribute("src","b.gif" );
      ((Element)v.get(342)).setAttribute("width","8" );
      ((Element)v.get(342)).setAttribute("height","8" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */
      /* Termina nodo:340   */

      /* Empieza nodo:343 / Elemento padre: 339   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(339)).appendChild((Element)v.get(343));

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
      ((Element)v.get(343)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(347)).setAttribute("nombre","lblNumeroGruposCondicionantes" );
      ((Element)v.get(347)).setAttribute("alto","13" );
      ((Element)v.get(347)).setAttribute("filas","1" );
      ((Element)v.get(347)).setAttribute("valor","" );
      ((Element)v.get(347)).setAttribute("id","datosTitle" );
      ((Element)v.get(347)).setAttribute("cod","535" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */
      /* Termina nodo:346   */

      /* Empieza nodo:348 / Elemento padre: 343   */
      v.add(doc.createElement("td"));
      ((Element)v.get(343)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(349)).setAttribute("src","b.gif" );
      ((Element)v.get(349)).setAttribute("width","25" );
      ((Element)v.get(349)).setAttribute("height","8" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */
      /* Termina nodo:348   */

      /* Empieza nodo:350 / Elemento padre: 343   */
      v.add(doc.createElement("td"));
      ((Element)v.get(343)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(351)).setAttribute("nombre","lblCondicionCondicionantes" );
      ((Element)v.get(351)).setAttribute("alto","13" );
      ((Element)v.get(351)).setAttribute("filas","1" );
      ((Element)v.get(351)).setAttribute("valor","" );
      ((Element)v.get(351)).setAttribute("id","datosTitle" );
      ((Element)v.get(351)).setAttribute("cod","536" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */
      /* Termina nodo:350   */

      /* Empieza nodo:352 / Elemento padre: 343   */
      v.add(doc.createElement("td"));
      ((Element)v.get(343)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(353)).setAttribute("src","b.gif" );
      ((Element)v.get(353)).setAttribute("width","25" );
      ((Element)v.get(353)).setAttribute("height","8" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */
      /* Termina nodo:352   */

      /* Empieza nodo:354 / Elemento padre: 343   */
      v.add(doc.createElement("td"));
      ((Element)v.get(343)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(355)).setAttribute("nombre","lblNumeroGruposCondicionados" );
      ((Element)v.get(355)).setAttribute("alto","13" );
      ((Element)v.get(355)).setAttribute("filas","1" );
      ((Element)v.get(355)).setAttribute("valor","" );
      ((Element)v.get(355)).setAttribute("id","datosTitle" );
      ((Element)v.get(355)).setAttribute("cod","537" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */
      /* Termina nodo:354   */

      /* Empieza nodo:356 / Elemento padre: 343   */
      v.add(doc.createElement("td"));
      ((Element)v.get(343)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(357)).setAttribute("src","b.gif" );
      ((Element)v.get(357)).setAttribute("width","25" );
      ((Element)v.get(357)).setAttribute("height","8" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */

      /* Empieza nodo:358 / Elemento padre: 343   */
      v.add(doc.createElement("td"));
      ((Element)v.get(343)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(359)).setAttribute("nombre","lblCondicionCondicionados" );
      ((Element)v.get(359)).setAttribute("alto","13" );
      ((Element)v.get(359)).setAttribute("filas","1" );
      ((Element)v.get(359)).setAttribute("valor","" );
      ((Element)v.get(359)).setAttribute("id","datosTitle" );
      ((Element)v.get(359)).setAttribute("cod","538" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */
      /* Termina nodo:358   */

      /* Empieza nodo:360 / Elemento padre: 343   */
      v.add(doc.createElement("td"));
      ((Element)v.get(343)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(361)).setAttribute("src","b.gif" );
      ((Element)v.get(361)).setAttribute("width","25" );
      ((Element)v.get(361)).setAttribute("height","8" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */
      /* Termina nodo:360   */

      /* Empieza nodo:362 / Elemento padre: 343   */
      v.add(doc.createElement("td"));
      ((Element)v.get(343)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(363)).setAttribute("nombre","lblDespachoCompleto" );
      ((Element)v.get(363)).setAttribute("alto","13" );
      ((Element)v.get(363)).setAttribute("filas","1" );
      ((Element)v.get(363)).setAttribute("valor","" );
      ((Element)v.get(363)).setAttribute("id","datosTitle" );
      ((Element)v.get(363)).setAttribute("cod","539" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */
      /* Termina nodo:362   */

      /* Empieza nodo:364 / Elemento padre: 343   */
      v.add(doc.createElement("td"));
      ((Element)v.get(364)).setAttribute("width","100%" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(343)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(365)).setAttribute("src","b.gif" );
      ((Element)v.get(365)).setAttribute("width","8" );
      ((Element)v.get(365)).setAttribute("height","8" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */
      /* Termina nodo:364   */
      /* Termina nodo:343   */

      /* Empieza nodo:366 / Elemento padre: 339   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(339)).appendChild((Element)v.get(366));

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
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(370)).setAttribute("nombre","txtNumeroGruposCondicionantes" );
      ((Element)v.get(370)).setAttribute("id","datosCampos" );
      ((Element)v.get(370)).setAttribute("max","2" );
      ((Element)v.get(370)).setAttribute("tipo","" );
      ((Element)v.get(370)).setAttribute("onchange","" );
      ((Element)v.get(370)).setAttribute("req","N" );
      ((Element)v.get(370)).setAttribute("size","2" );
      ((Element)v.get(370)).setAttribute("valor","" );
      ((Element)v.get(370)).setAttribute("validacion","" );
      ((Element)v.get(370)).setAttribute("ontab","tabGenerico('txtNumeroGruposCondicionantes');" );
      ((Element)v.get(370)).setAttribute("onshtab","tabGenerico('txtNumeroGruposCondicionantes','sh');" );
      ((Element)v.get(369)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */
      /* Termina nodo:369   */

      /* Empieza nodo:371 / Elemento padre: 366   */
      v.add(doc.createElement("td"));
      ((Element)v.get(366)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(372)).setAttribute("src","b.gif" );
      ((Element)v.get(372)).setAttribute("width","25" );
      ((Element)v.get(372)).setAttribute("height","8" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */
      /* Termina nodo:371   */

      /* Empieza nodo:373 / Elemento padre: 366   */
      v.add(doc.createElement("td"));
      ((Element)v.get(373)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(366)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("table"));
      ((Element)v.get(373)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(374)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("td"));
      ((Element)v.get(376)).setAttribute("class","datosCampos" );
      ((Element)v.get(376)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(377)).setAttribute("nombre","rbCondicionCondicionantes" );
      ((Element)v.get(377)).setAttribute("tipo","H" );
      ((Element)v.get(377)).setAttribute("id","datosCampos" );
      ((Element)v.get(377)).setAttribute("req","N" );
      ((Element)v.get(377)).setAttribute("ontab","tabGenerico('rbCondicionCondicionantes');" );
      ((Element)v.get(377)).setAttribute("onshtab","tabGenerico('rbCondicionCondicionantes','sh');" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(378)).setAttribute("valor","S" );
      ((Element)v.get(378)).setAttribute("check","N" );
      ((Element)v.get(378)).setAttribute("onfocus","" );
      ((Element)v.get(378)).setAttribute("id","datosCampos" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));

      /* Elemento padre:378 / Elemento actual: 379   */
      v.add(doc.createTextNode("Y"));
      ((Element)v.get(378)).appendChild((Text)v.get(379));

      /* Termina nodo Texto:379   */
      /* Termina nodo:378   */

      /* Empieza nodo:380 / Elemento padre: 377   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(380)).setAttribute("valor","N" );
      ((Element)v.get(380)).setAttribute("onfocus","" );
      ((Element)v.get(380)).setAttribute("id","datosCampos" );
      ((Element)v.get(377)).appendChild((Element)v.get(380));

      /* Elemento padre:380 / Elemento actual: 381   */
      v.add(doc.createTextNode("O"));
      ((Element)v.get(380)).appendChild((Text)v.get(381));

      /* Termina nodo Texto:381   */
      /* Termina nodo:380   */
      /* Termina nodo:377   */
      /* Termina nodo:376   */
      /* Termina nodo:375   */
      /* Termina nodo:374   */
      /* Termina nodo:373   */

      /* Empieza nodo:382 / Elemento padre: 366   */
      v.add(doc.createElement("td"));
      ((Element)v.get(366)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(383)).setAttribute("src","b.gif" );
      ((Element)v.get(383)).setAttribute("width","25" );
      ((Element)v.get(383)).setAttribute("height","8" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */
      /* Termina nodo:382   */

      /* Empieza nodo:384 / Elemento padre: 366   */
      v.add(doc.createElement("td"));
      ((Element)v.get(384)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(366)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(385)).setAttribute("nombre","txtNumeroGruposCondicionados" );
      ((Element)v.get(385)).setAttribute("id","datosCampos" );
      ((Element)v.get(385)).setAttribute("max","2" );
      ((Element)v.get(385)).setAttribute("tipo","" );
      ((Element)v.get(385)).setAttribute("onchange","" );
      ((Element)v.get(385)).setAttribute("req","N" );
      ((Element)v.get(385)).setAttribute("size","2" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(385)).setAttribute("valor","" );
      ((Element)v.get(385)).setAttribute("validacion","" );
      ((Element)v.get(385)).setAttribute("ontab","tabGenerico('txtNumeroGruposCondicionados');" );
      ((Element)v.get(385)).setAttribute("onshtab","tabGenerico('txtNumeroGruposCondicionados','sh');" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */
      /* Termina nodo:384   */

      /* Empieza nodo:386 / Elemento padre: 366   */
      v.add(doc.createElement("td"));
      ((Element)v.get(366)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(387)).setAttribute("src","b.gif" );
      ((Element)v.get(387)).setAttribute("width","25" );
      ((Element)v.get(387)).setAttribute("height","8" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */
      /* Termina nodo:386   */

      /* Empieza nodo:388 / Elemento padre: 366   */
      v.add(doc.createElement("td"));
      ((Element)v.get(388)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(366)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("table"));
      ((Element)v.get(388)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(389)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("td"));
      ((Element)v.get(391)).setAttribute("class","datosCampos" );
      ((Element)v.get(391)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(392)).setAttribute("nombre","rbCondicionCondicionados" );
      ((Element)v.get(392)).setAttribute("tipo","H" );
      ((Element)v.get(392)).setAttribute("id","datosCampos" );
      ((Element)v.get(392)).setAttribute("req","N" );
      ((Element)v.get(392)).setAttribute("ontab","tabGenerico('rbCondicionCondicionados');" );
      ((Element)v.get(392)).setAttribute("onshtab","tabGenerico('rbCondicionCondicionados','sh');" );
      ((Element)v.get(391)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(393)).setAttribute("valor","S" );
      ((Element)v.get(393)).setAttribute("check","N" );
      ((Element)v.get(393)).setAttribute("onfocus","" );
      ((Element)v.get(393)).setAttribute("id","datosCampos" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));

      /* Elemento padre:393 / Elemento actual: 394   */
      v.add(doc.createTextNode("Y"));
      ((Element)v.get(393)).appendChild((Text)v.get(394));

      /* Termina nodo Texto:394   */
      /* Termina nodo:393   */

      /* Empieza nodo:395 / Elemento padre: 392   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(395)).setAttribute("valor","N" );
      ((Element)v.get(395)).setAttribute("onfocus","" );
      ((Element)v.get(395)).setAttribute("id","datosCampos" );
      ((Element)v.get(392)).appendChild((Element)v.get(395));

      /* Elemento padre:395 / Elemento actual: 396   */
      v.add(doc.createTextNode("O"));
      ((Element)v.get(395)).appendChild((Text)v.get(396));

      /* Termina nodo Texto:396   */
      /* Termina nodo:395   */
      /* Termina nodo:392   */
      /* Termina nodo:391   */
      /* Termina nodo:390   */
      /* Termina nodo:389   */
      /* Termina nodo:388   */

      /* Empieza nodo:397 / Elemento padre: 366   */
      v.add(doc.createElement("td"));
      ((Element)v.get(366)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(398)).setAttribute("src","b.gif" );
      ((Element)v.get(398)).setAttribute("width","25" );
      ((Element)v.get(398)).setAttribute("height","8" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */
      /* Termina nodo:397   */

      /* Empieza nodo:399 / Elemento padre: 366   */
      v.add(doc.createElement("td"));
      ((Element)v.get(366)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(400)).setAttribute("nombre","ckDespachoCompleto" );
      ((Element)v.get(400)).setAttribute("texto","" );
      ((Element)v.get(400)).setAttribute("check","N" );
      ((Element)v.get(400)).setAttribute("validacion","" );
      ((Element)v.get(400)).setAttribute("req","N" );
      ((Element)v.get(400)).setAttribute("id","datosCampos" );
      ((Element)v.get(400)).setAttribute("ontab","tabGenerico('ckDespachoCompleto');" );
      ((Element)v.get(400)).setAttribute("onshtab","tabGenerico('ckDespachoCompleto','sh');" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));
      /* Termina nodo:400   */
      /* Termina nodo:399   */

      /* Empieza nodo:401 / Elemento padre: 366   */
      v.add(doc.createElement("td"));
      ((Element)v.get(401)).setAttribute("width","100%" );
      ((Element)v.get(366)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(402)).setAttribute("src","b.gif" );
      ((Element)v.get(402)).setAttribute("width","1" );
      ((Element)v.get(402)).setAttribute("height","1" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */
      /* Termina nodo:401   */
      /* Termina nodo:366   */
      /* Termina nodo:339   */
      /* Termina nodo:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:403 / Elemento padre: 296   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(296)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("td"));
      ((Element)v.get(403)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("table"));
      ((Element)v.get(405)).setAttribute("width","730" );
      ((Element)v.get(405)).setAttribute("border","0" );
      ((Element)v.get(405)).setAttribute("align","left" );
      ((Element)v.get(405)).setAttribute("cellspacing","0" );
      ((Element)v.get(405)).setAttribute("cellpadding","0" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(405)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("td"));
      ((Element)v.get(407)).setAttribute("colspan","4" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(408)).setAttribute("src","b.gif" );
      ((Element)v.get(408)).setAttribute("width","8" );
      ((Element)v.get(408)).setAttribute("height","8" );
      ((Element)v.get(407)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */
      /* Termina nodo:407   */
      /* Termina nodo:406   */

      /* Empieza nodo:409 / Elemento padre: 405   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(405)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("td"));
      ((Element)v.get(409)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(411)).setAttribute("src","b.gif" );
      ((Element)v.get(411)).setAttribute("width","8" );
      ((Element)v.get(411)).setAttribute("height","8" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */
      /* Termina nodo:410   */

      /* Empieza nodo:412 / Elemento padre: 409   */
      v.add(doc.createElement("td"));
      ((Element)v.get(409)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(413)).setAttribute("nombre","lblDespachoAutomatico" );
      ((Element)v.get(413)).setAttribute("alto","13" );
      ((Element)v.get(413)).setAttribute("filas","1" );
      ((Element)v.get(413)).setAttribute("valor","" );
      ((Element)v.get(413)).setAttribute("id","datosTitle" );
      ((Element)v.get(413)).setAttribute("cod","540" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */
      /* Termina nodo:412   */

      /* Empieza nodo:414 / Elemento padre: 409   */
      v.add(doc.createElement("td"));
      ((Element)v.get(409)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(415)).setAttribute("src","b.gif" );
      ((Element)v.get(415)).setAttribute("width","25" );
      ((Element)v.get(415)).setAttribute("height","8" );
      ((Element)v.get(414)).appendChild((Element)v.get(415));
      /* Termina nodo:415   */
      /* Termina nodo:414   */

      /* Empieza nodo:416 / Elemento padre: 409   */
      v.add(doc.createElement("td"));
      ((Element)v.get(409)).appendChild((Element)v.get(416));

      /* Empieza nodo:417 / Elemento padre: 416   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(417)).setAttribute("nombre","lblRecObligPedido" );
      ((Element)v.get(417)).setAttribute("alto","13" );
      ((Element)v.get(417)).setAttribute("filas","1" );
      ((Element)v.get(417)).setAttribute("valor","" );
      ((Element)v.get(417)).setAttribute("id","datosTitle" );
      ((Element)v.get(417)).setAttribute("cod","601" );
      ((Element)v.get(416)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */
      /* Termina nodo:416   */

      /* Empieza nodo:418 / Elemento padre: 409   */
      v.add(doc.createElement("td"));
      ((Element)v.get(409)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(419)).setAttribute("src","b.gif" );
      ((Element)v.get(419)).setAttribute("width","25" );
      ((Element)v.get(419)).setAttribute("height","8" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */
      /* Termina nodo:418   */

      /* Empieza nodo:420 / Elemento padre: 409   */
      v.add(doc.createElement("td"));
      ((Element)v.get(420)).setAttribute("colspan","6" );
      ((Element)v.get(409)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(421)).setAttribute("nombre","lblFormaPago" );
      ((Element)v.get(421)).setAttribute("alto","13" );
      ((Element)v.get(421)).setAttribute("filas","1" );
      ((Element)v.get(421)).setAttribute("valor","" );
      ((Element)v.get(421)).setAttribute("id","datosTitle" );
      ((Element)v.get(421)).setAttribute("cod","541" );
      ((Element)v.get(420)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */
      /* Termina nodo:420   */

      /* Empieza nodo:422 / Elemento padre: 409   */
      v.add(doc.createElement("td"));
      ((Element)v.get(422)).setAttribute("width","100%" );
      ((Element)v.get(409)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(423)).setAttribute("src","b.gif" );
      ((Element)v.get(423)).setAttribute("width","8" );
      ((Element)v.get(423)).setAttribute("height","8" );
      ((Element)v.get(422)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */
      /* Termina nodo:422   */
      /* Termina nodo:409   */

      /* Empieza nodo:424 / Elemento padre: 405   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(405)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("td"));
      ((Element)v.get(424)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(426)).setAttribute("src","b.gif" );
      ((Element)v.get(426)).setAttribute("width","8" );
      ((Element)v.get(426)).setAttribute("height","8" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));
      /* Termina nodo:426   */
      /* Termina nodo:425   */

      /* Empieza nodo:427 / Elemento padre: 424   */
      v.add(doc.createElement("td"));
      ((Element)v.get(424)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(428)).setAttribute("nombre","ckDespachoAutomatico" );
      ((Element)v.get(428)).setAttribute("texto","" );
      ((Element)v.get(428)).setAttribute("check","N" );
      ((Element)v.get(428)).setAttribute("validacion","" );
      ((Element)v.get(428)).setAttribute("req","N" );
      ((Element)v.get(428)).setAttribute("id","datosCampos" );
      ((Element)v.get(428)).setAttribute("ontab","tabGenerico('ckDespachoAutomatico');" );
      ((Element)v.get(428)).setAttribute("onshtab","tabGenerico('ckDespachoAutomatico','sh');" );
      ((Element)v.get(427)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */
      /* Termina nodo:427   */

      /* Empieza nodo:429 / Elemento padre: 424   */
      v.add(doc.createElement("td"));
      ((Element)v.get(424)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(430)).setAttribute("src","b.gif" );
      ((Element)v.get(430)).setAttribute("width","25" );
      ((Element)v.get(430)).setAttribute("height","8" );
      ((Element)v.get(429)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */
      /* Termina nodo:429   */

      /* Empieza nodo:431 / Elemento padre: 424   */
      v.add(doc.createElement("td"));
      ((Element)v.get(424)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(432)).setAttribute("nombre","ckRecObligPedido" );
      ((Element)v.get(432)).setAttribute("texto","" );
      ((Element)v.get(432)).setAttribute("check","N" );
      ((Element)v.get(432)).setAttribute("validacion","" );
      ((Element)v.get(432)).setAttribute("req","N" );
      ((Element)v.get(432)).setAttribute("id","datosCampos" );
      ((Element)v.get(432)).setAttribute("ontab","tabGenerico('ckRecObligPedido');" );
      ((Element)v.get(432)).setAttribute("onshtab","tabGenerico('ckRecObligPedido','sh');" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));
      /* Termina nodo:432   */
      /* Termina nodo:431   */

      /* Empieza nodo:433 / Elemento padre: 424   */
      v.add(doc.createElement("td"));
      ((Element)v.get(424)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(434)).setAttribute("src","b.gif" );
      ((Element)v.get(434)).setAttribute("width","25" );
      ((Element)v.get(434)).setAttribute("height","8" );
      ((Element)v.get(433)).appendChild((Element)v.get(434));
      /* Termina nodo:434   */
      /* Termina nodo:433   */

      /* Empieza nodo:435 / Elemento padre: 424   */
      v.add(doc.createElement("td"));
      ((Element)v.get(435)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(424)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(436)).setAttribute("nombre","cbFormasPago" );
      ((Element)v.get(436)).setAttribute("id","datosCampos" );
      ((Element)v.get(436)).setAttribute("size","1" );
      ((Element)v.get(436)).setAttribute("multiple","N" );
      ((Element)v.get(436)).setAttribute("req","N" );
      ((Element)v.get(436)).setAttribute("valorinicial","" );
      ((Element)v.get(436)).setAttribute("textoinicial","" );
      ((Element)v.get(436)).setAttribute("ontab","tabGenerico('cbFormasPago');" );
      ((Element)v.get(436)).setAttribute("onshtab","tabGenerico('cbFormasPago','sh');" );
      ((Element)v.get(435)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(436)).appendChild((Element)v.get(437));
      /* Termina nodo:437   */
      /* Termina nodo:436   */
      /* Termina nodo:435   */

      /* Empieza nodo:438 / Elemento padre: 424   */
      v.add(doc.createElement("td"));
      ((Element)v.get(438)).setAttribute("width","100%" );
      ((Element)v.get(424)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(439)).setAttribute("src","b.gif" );
      ((Element)v.get(439)).setAttribute("width","1" );
      ((Element)v.get(439)).setAttribute("height","1" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */
      /* Termina nodo:438   */
      /* Termina nodo:424   */

      /* Empieza nodo:440 / Elemento padre: 405   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(405)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("td"));
      ((Element)v.get(441)).setAttribute("colspan","4" );
      ((Element)v.get(440)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(442)).setAttribute("src","b.gif" );
      ((Element)v.get(442)).setAttribute("width","8" );
      ((Element)v.get(442)).setAttribute("height","8" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */
      /* Termina nodo:441   */
      /* Termina nodo:440   */
      /* Termina nodo:405   */
      /* Termina nodo:404   */
      /* Termina nodo:403   */
      /* Termina nodo:296   */
      /* Termina nodo:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:443 / Elemento padre: 289   */
      v.add(doc.createElement("td"));
      ((Element)v.get(289)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(444)).setAttribute("src","b.gif" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));
      /* Termina nodo:444   */
      /* Termina nodo:443   */
      /* Termina nodo:289   */

      /* Empieza nodo:445 / Elemento padre: 281   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(281)).appendChild((Element)v.get(445));

      /* Empieza nodo:446 / Elemento padre: 445   */
      v.add(doc.createElement("td"));
      ((Element)v.get(446)).setAttribute("width","12" );
      ((Element)v.get(446)).setAttribute("align","center" );
      ((Element)v.get(445)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(447)).setAttribute("src","b.gif" );
      ((Element)v.get(447)).setAttribute("width","12" );
      ((Element)v.get(447)).setAttribute("height","12" );
      ((Element)v.get(446)).appendChild((Element)v.get(447));
      /* Termina nodo:447   */
      /* Termina nodo:446   */

      /* Empieza nodo:448 / Elemento padre: 445   */
      v.add(doc.createElement("td"));
      ((Element)v.get(448)).setAttribute("width","756" );
      ((Element)v.get(445)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(449)).setAttribute("src","b.gif" );
      ((Element)v.get(448)).appendChild((Element)v.get(449));
      /* Termina nodo:449   */
      /* Termina nodo:448   */

      /* Empieza nodo:450 / Elemento padre: 445   */
      v.add(doc.createElement("td"));
      ((Element)v.get(450)).setAttribute("width","12" );
      ((Element)v.get(445)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(451)).setAttribute("src","b.gif" );
      ((Element)v.get(451)).setAttribute("width","12" );
      ((Element)v.get(451)).setAttribute("height","1" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));
      /* Termina nodo:451   */
      /* Termina nodo:450   */
      /* Termina nodo:445   */
      /* Termina nodo:281   */
      /* Termina nodo:280   */

      /* Empieza nodo:452 / Elemento padre: 13   */
      v.add(doc.createElement("REJILLA"));
      ((Element)v.get(452)).setAttribute("nombre","rejlistado3" );
      ((Element)v.get(13)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */

      /* Empieza nodo:453 / Elemento padre: 13   */
   }

   private void getXML1980(Document doc) {
      v.add(doc.createElement("REJILLA"));
      ((Element)v.get(453)).setAttribute("nombre","rejlistado4" );
      ((Element)v.get(13)).appendChild((Element)v.get(453));
      /* Termina nodo:453   */

      /* Empieza nodo:454 / Elemento padre: 13   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(454)).setAttribute("nombre","capaVentaExclusiva" );
      ((Element)v.get(454)).setAttribute("x","0" );
      ((Element)v.get(454)).setAttribute("y","1711" );
      ((Element)v.get(13)).appendChild((Element)v.get(454));

      /* Empieza nodo:455 / Elemento padre: 454   */
      v.add(doc.createElement("table"));
      ((Element)v.get(455)).setAttribute("width","100%" );
      ((Element)v.get(455)).setAttribute("border","0" );
      ((Element)v.get(455)).setAttribute("cellspacing","0" );
      ((Element)v.get(455)).setAttribute("cellpadding","0" );
      ((Element)v.get(454)).appendChild((Element)v.get(455));

      /* Empieza nodo:456 / Elemento padre: 455   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(455)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("td"));
      ((Element)v.get(456)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(458)).setAttribute("src","b.gif" );
      ((Element)v.get(458)).setAttribute("width","12" );
      ((Element)v.get(458)).setAttribute("height","12" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */
      /* Termina nodo:457   */

      /* Empieza nodo:459 / Elemento padre: 456   */
      v.add(doc.createElement("td"));
      ((Element)v.get(459)).setAttribute("width","750" );
      ((Element)v.get(456)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(460)).setAttribute("src","b.gif" );
      ((Element)v.get(460)).setAttribute("width","1" );
      ((Element)v.get(460)).setAttribute("height","1" );
      ((Element)v.get(459)).appendChild((Element)v.get(460));
      /* Termina nodo:460   */
      /* Termina nodo:459   */

      /* Empieza nodo:461 / Elemento padre: 456   */
      v.add(doc.createElement("td"));
      ((Element)v.get(456)).appendChild((Element)v.get(461));

      /* Empieza nodo:462 / Elemento padre: 461   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(462)).setAttribute("src","b.gif" );
      ((Element)v.get(462)).setAttribute("width","12" );
      ((Element)v.get(462)).setAttribute("height","12" );
      ((Element)v.get(461)).appendChild((Element)v.get(462));
      /* Termina nodo:462   */
      /* Termina nodo:461   */
      /* Termina nodo:456   */

      /* Empieza nodo:463 / Elemento padre: 455   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(455)).appendChild((Element)v.get(463));

      /* Empieza nodo:464 / Elemento padre: 463   */
      v.add(doc.createElement("td"));
      ((Element)v.get(464)).setAttribute("width","12" );
      ((Element)v.get(463)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(465)).setAttribute("src","b.gif" );
      ((Element)v.get(465)).setAttribute("width","12" );
      ((Element)v.get(465)).setAttribute("height","12" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));
      /* Termina nodo:465   */
      /* Termina nodo:464   */

      /* Empieza nodo:466 / Elemento padre: 463   */
      v.add(doc.createElement("td"));
      ((Element)v.get(463)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(466)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(468)).setAttribute("class","legend" );
      ((Element)v.get(467)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(469)).setAttribute("nombre","lblVentaExclusiva" );
      ((Element)v.get(469)).setAttribute("alto","13" );
      ((Element)v.get(469)).setAttribute("filas","1" );
      ((Element)v.get(469)).setAttribute("valor","" );
      ((Element)v.get(469)).setAttribute("id","legend" );
      ((Element)v.get(469)).setAttribute("cod","0010" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));
      /* Termina nodo:469   */
      /* Termina nodo:468   */

      /* Empieza nodo:470 / Elemento padre: 467   */
      v.add(doc.createElement("table"));
      ((Element)v.get(470)).setAttribute("width","100%" );
      ((Element)v.get(470)).setAttribute("border","0" );
      ((Element)v.get(470)).setAttribute("align","center" );
      ((Element)v.get(470)).setAttribute("cellspacing","0" );
      ((Element)v.get(470)).setAttribute("cellpadding","0" );
      ((Element)v.get(467)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(470)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("td"));
      ((Element)v.get(472)).setAttribute("colspan","9" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));

      /* Empieza nodo:473 / Elemento padre: 472   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(473)).setAttribute("src","b.gif" );
      ((Element)v.get(473)).setAttribute("width","12" );
      ((Element)v.get(473)).setAttribute("height","12" );
      ((Element)v.get(472)).appendChild((Element)v.get(473));
      /* Termina nodo:473   */
      /* Termina nodo:472   */
      /* Termina nodo:471   */

      /* Empieza nodo:474 / Elemento padre: 470   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(470)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("td"));
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
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(477)).setAttribute("colspan","7" );
      ((Element)v.get(477)).setAttribute("width","100%" );
      ((Element)v.get(474)).appendChild((Element)v.get(477));

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
      ((Element)v.get(479)).appendChild((Element)v.get(480));

      /* Empieza nodo:481 / Elemento padre: 480   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(480)).appendChild((Element)v.get(481));

      /* Empieza nodo:482 / Elemento padre: 481   */
      v.add(doc.createElement("table"));
      ((Element)v.get(482)).setAttribute("width","100%" );
      ((Element)v.get(482)).setAttribute("border","0" );
      ((Element)v.get(482)).setAttribute("align","center" );
      ((Element)v.get(482)).setAttribute("cellspacing","0" );
      ((Element)v.get(482)).setAttribute("cellpadding","0" );
      ((Element)v.get(481)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(482)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("td"));
      ((Element)v.get(483)).appendChild((Element)v.get(484));

      /* Empieza nodo:485 / Elemento padre: 484   */
      v.add(doc.createElement("table"));
      ((Element)v.get(485)).setAttribute("width","702" );
      ((Element)v.get(485)).setAttribute("border","0" );
      ((Element)v.get(485)).setAttribute("align","left" );
      ((Element)v.get(485)).setAttribute("cellspacing","0" );
      ((Element)v.get(485)).setAttribute("cellpadding","0" );
      ((Element)v.get(484)).appendChild((Element)v.get(485));

      /* Empieza nodo:486 / Elemento padre: 485   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(485)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("td"));
      ((Element)v.get(487)).setAttribute("colspan","4" );
      ((Element)v.get(486)).appendChild((Element)v.get(487));

      /* Empieza nodo:488 / Elemento padre: 487   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(488)).setAttribute("src","b.gif" );
      ((Element)v.get(488)).setAttribute("width","8" );
      ((Element)v.get(488)).setAttribute("height","8" );
      ((Element)v.get(487)).appendChild((Element)v.get(488));
      /* Termina nodo:488   */
      /* Termina nodo:487   */
      /* Termina nodo:486   */

      /* Empieza nodo:489 / Elemento padre: 485   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(485)).appendChild((Element)v.get(489));

      /* Empieza nodo:490 / Elemento padre: 489   */
      v.add(doc.createElement("td"));
      ((Element)v.get(489)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(491)).setAttribute("src","b.gif" );
      ((Element)v.get(491)).setAttribute("width","8" );
      ((Element)v.get(491)).setAttribute("height","8" );
      ((Element)v.get(490)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */
      /* Termina nodo:490   */

      /* Empieza nodo:492 / Elemento padre: 489   */
      v.add(doc.createElement("td"));
      ((Element)v.get(489)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(493)).setAttribute("nombre","lblVentaExclusiva4" );
      ((Element)v.get(493)).setAttribute("alto","13" );
      ((Element)v.get(493)).setAttribute("filas","1" );
      ((Element)v.get(493)).setAttribute("valor","" );
      ((Element)v.get(493)).setAttribute("id","datosTitle" );
      ((Element)v.get(493)).setAttribute("cod","0010" );
      ((Element)v.get(492)).appendChild((Element)v.get(493));
      /* Termina nodo:493   */
      /* Termina nodo:492   */

      /* Empieza nodo:494 / Elemento padre: 489   */
      v.add(doc.createElement("td"));
      ((Element)v.get(489)).appendChild((Element)v.get(494));

      /* Empieza nodo:495 / Elemento padre: 494   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(495)).setAttribute("src","b.gif" );
      ((Element)v.get(495)).setAttribute("width","25" );
      ((Element)v.get(495)).setAttribute("height","8" );
      ((Element)v.get(494)).appendChild((Element)v.get(495));
      /* Termina nodo:495   */
      /* Termina nodo:494   */

      /* Empieza nodo:496 / Elemento padre: 489   */
      v.add(doc.createElement("td"));
      ((Element)v.get(489)).appendChild((Element)v.get(496));

      /* Empieza nodo:497 / Elemento padre: 496   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(497)).setAttribute("nombre","lblTipoCliente4" );
      ((Element)v.get(497)).setAttribute("alto","13" );
      ((Element)v.get(497)).setAttribute("filas","1" );
      ((Element)v.get(497)).setAttribute("valor","" );
      ((Element)v.get(497)).setAttribute("id","datosTitle" );
      ((Element)v.get(497)).setAttribute("cod","393" );
      ((Element)v.get(496)).appendChild((Element)v.get(497));
      /* Termina nodo:497   */
      /* Termina nodo:496   */

      /* Empieza nodo:498 / Elemento padre: 489   */
      v.add(doc.createElement("td"));
      ((Element)v.get(489)).appendChild((Element)v.get(498));

      /* Empieza nodo:499 / Elemento padre: 498   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(499)).setAttribute("src","b.gif" );
      ((Element)v.get(499)).setAttribute("width","25" );
      ((Element)v.get(499)).setAttribute("height","8" );
      ((Element)v.get(498)).appendChild((Element)v.get(499));
      /* Termina nodo:499   */
      /* Termina nodo:498   */

      /* Empieza nodo:500 / Elemento padre: 489   */
      v.add(doc.createElement("td"));
      ((Element)v.get(489)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(501)).setAttribute("nombre","lblSubTipoCliente4" );
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(501)).setAttribute("alto","13" );
      ((Element)v.get(501)).setAttribute("filas","1" );
      ((Element)v.get(501)).setAttribute("valor","" );
      ((Element)v.get(501)).setAttribute("id","datosTitle" );
      ((Element)v.get(501)).setAttribute("cod","595" );
      ((Element)v.get(500)).appendChild((Element)v.get(501));
      /* Termina nodo:501   */
      /* Termina nodo:500   */

      /* Empieza nodo:502 / Elemento padre: 489   */
      v.add(doc.createElement("td"));
      ((Element)v.get(502)).setAttribute("width","100%" );
      ((Element)v.get(489)).appendChild((Element)v.get(502));

      /* Empieza nodo:503 / Elemento padre: 502   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(503)).setAttribute("src","b.gif" );
      ((Element)v.get(503)).setAttribute("width","8" );
      ((Element)v.get(503)).setAttribute("height","8" );
      ((Element)v.get(502)).appendChild((Element)v.get(503));
      /* Termina nodo:503   */
      /* Termina nodo:502   */
      /* Termina nodo:489   */

      /* Empieza nodo:504 / Elemento padre: 485   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(485)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("td"));
      ((Element)v.get(504)).appendChild((Element)v.get(505));

      /* Empieza nodo:506 / Elemento padre: 505   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(506)).setAttribute("src","b.gif" );
      ((Element)v.get(506)).setAttribute("width","8" );
      ((Element)v.get(506)).setAttribute("height","8" );
      ((Element)v.get(505)).appendChild((Element)v.get(506));
      /* Termina nodo:506   */
      /* Termina nodo:505   */

      /* Empieza nodo:507 / Elemento padre: 504   */
      v.add(doc.createElement("td"));
      ((Element)v.get(504)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(508)).setAttribute("nombre","ckVentaExclusiva4" );
      ((Element)v.get(508)).setAttribute("texto","" );
      ((Element)v.get(508)).setAttribute("check","N" );
      ((Element)v.get(508)).setAttribute("onclick","ckVentaExclusivaOnChange();" );
      ((Element)v.get(508)).setAttribute("validacion","" );
      ((Element)v.get(508)).setAttribute("req","N" );
      ((Element)v.get(508)).setAttribute("id","datosCampos" );
      ((Element)v.get(508)).setAttribute("ontab","tabGenerico('ckVentaExclusiva4','tab');" );
      ((Element)v.get(508)).setAttribute("onshtab","tabGenerico('ckVentaExclusiva4','sh');" );
      ((Element)v.get(507)).appendChild((Element)v.get(508));
      /* Termina nodo:508   */
      /* Termina nodo:507   */

      /* Empieza nodo:509 / Elemento padre: 504   */
      v.add(doc.createElement("td"));
      ((Element)v.get(504)).appendChild((Element)v.get(509));

      /* Empieza nodo:510 / Elemento padre: 509   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(510)).setAttribute("src","b.gif" );
      ((Element)v.get(510)).setAttribute("width","25" );
      ((Element)v.get(510)).setAttribute("height","8" );
      ((Element)v.get(509)).appendChild((Element)v.get(510));
      /* Termina nodo:510   */
      /* Termina nodo:509   */

      /* Empieza nodo:511 / Elemento padre: 504   */
      v.add(doc.createElement("td"));
      ((Element)v.get(511)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(504)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(512)).setAttribute("nombre","cbTipoCliente" );
      ((Element)v.get(512)).setAttribute("id","datosCampos" );
      ((Element)v.get(512)).setAttribute("size","1" );
      ((Element)v.get(512)).setAttribute("multiple","N" );
      ((Element)v.get(512)).setAttribute("req","N" );
      ((Element)v.get(512)).setAttribute("valorinicial","" );
      ((Element)v.get(512)).setAttribute("textoinicial","" );
      ((Element)v.get(512)).setAttribute("onchange","tipoClienteOnChange();" );
      ((Element)v.get(511)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(512)).appendChild((Element)v.get(513));
      /* Termina nodo:513   */
      /* Termina nodo:512   */
      /* Termina nodo:511   */

      /* Empieza nodo:514 / Elemento padre: 504   */
      v.add(doc.createElement("td"));
      ((Element)v.get(504)).appendChild((Element)v.get(514));

      /* Empieza nodo:515 / Elemento padre: 514   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(515)).setAttribute("src","b.gif" );
      ((Element)v.get(515)).setAttribute("width","25" );
      ((Element)v.get(515)).setAttribute("height","8" );
      ((Element)v.get(514)).appendChild((Element)v.get(515));
      /* Termina nodo:515   */
      /* Termina nodo:514   */

      /* Empieza nodo:516 / Elemento padre: 504   */
      v.add(doc.createElement("td"));
      ((Element)v.get(516)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(504)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(517)).setAttribute("nombre","cbSubTipoCliente" );
      ((Element)v.get(517)).setAttribute("id","datosCampos" );
      ((Element)v.get(517)).setAttribute("size","1" );
      ((Element)v.get(517)).setAttribute("multiple","N" );
      ((Element)v.get(517)).setAttribute("req","N" );
      ((Element)v.get(517)).setAttribute("valorinicial","" );
      ((Element)v.get(517)).setAttribute("textoinicial","" );
      ((Element)v.get(517)).setAttribute("onchange","subtipoClienteOnChange();" );
      ((Element)v.get(516)).appendChild((Element)v.get(517));

      /* Empieza nodo:518 / Elemento padre: 517   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(517)).appendChild((Element)v.get(518));
      /* Termina nodo:518   */
      /* Termina nodo:517   */
      /* Termina nodo:516   */

      /* Empieza nodo:519 / Elemento padre: 504   */
      v.add(doc.createElement("td"));
      ((Element)v.get(519)).setAttribute("width","100%" );
      ((Element)v.get(504)).appendChild((Element)v.get(519));

      /* Empieza nodo:520 / Elemento padre: 519   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(520)).setAttribute("src","b.gif" );
      ((Element)v.get(520)).setAttribute("width","8" );
      ((Element)v.get(520)).setAttribute("height","8" );
      ((Element)v.get(519)).appendChild((Element)v.get(520));
      /* Termina nodo:520   */
      /* Termina nodo:519   */
      /* Termina nodo:504   */
      /* Termina nodo:485   */
      /* Termina nodo:484   */
      /* Termina nodo:483   */

      /* Empieza nodo:521 / Elemento padre: 482   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(482)).appendChild((Element)v.get(521));

      /* Empieza nodo:522 / Elemento padre: 521   */
   }

   private void getXML2250(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(521)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("table"));
      ((Element)v.get(523)).setAttribute("width","702" );
      ((Element)v.get(523)).setAttribute("border","0" );
      ((Element)v.get(523)).setAttribute("align","left" );
      ((Element)v.get(523)).setAttribute("cellspacing","0" );
      ((Element)v.get(523)).setAttribute("cellpadding","0" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));

      /* Empieza nodo:524 / Elemento padre: 523   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(523)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("td"));
      ((Element)v.get(525)).setAttribute("colspan","4" );
      ((Element)v.get(524)).appendChild((Element)v.get(525));

      /* Empieza nodo:526 / Elemento padre: 525   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(526)).setAttribute("src","b.gif" );
      ((Element)v.get(526)).setAttribute("width","8" );
      ((Element)v.get(526)).setAttribute("height","8" );
      ((Element)v.get(525)).appendChild((Element)v.get(526));
      /* Termina nodo:526   */
      /* Termina nodo:525   */
      /* Termina nodo:524   */

      /* Empieza nodo:527 / Elemento padre: 523   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(523)).appendChild((Element)v.get(527));

      /* Empieza nodo:528 / Elemento padre: 527   */
      v.add(doc.createElement("td"));
      ((Element)v.get(527)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(529)).setAttribute("src","b.gif" );
      ((Element)v.get(529)).setAttribute("width","8" );
      ((Element)v.get(529)).setAttribute("height","8" );
      ((Element)v.get(528)).appendChild((Element)v.get(529));
      /* Termina nodo:529   */
      /* Termina nodo:528   */

      /* Empieza nodo:530 / Elemento padre: 527   */
      v.add(doc.createElement("td"));
      ((Element)v.get(527)).appendChild((Element)v.get(530));

      /* Empieza nodo:531 / Elemento padre: 530   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(531)).setAttribute("nombre","lblTipoClasificacionCliente4" );
      ((Element)v.get(531)).setAttribute("alto","13" );
      ((Element)v.get(531)).setAttribute("filas","1" );
      ((Element)v.get(531)).setAttribute("valor","" );
      ((Element)v.get(531)).setAttribute("id","datosTitle" );
      ((Element)v.get(531)).setAttribute("cod","610" );
      ((Element)v.get(530)).appendChild((Element)v.get(531));
      /* Termina nodo:531   */
      /* Termina nodo:530   */

      /* Empieza nodo:532 / Elemento padre: 527   */
      v.add(doc.createElement("td"));
      ((Element)v.get(527)).appendChild((Element)v.get(532));

      /* Empieza nodo:533 / Elemento padre: 532   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(533)).setAttribute("src","b.gif" );
      ((Element)v.get(533)).setAttribute("width","25" );
      ((Element)v.get(533)).setAttribute("height","8" );
      ((Element)v.get(532)).appendChild((Element)v.get(533));
      /* Termina nodo:533   */
      /* Termina nodo:532   */

      /* Empieza nodo:534 / Elemento padre: 527   */
      v.add(doc.createElement("td"));
      ((Element)v.get(527)).appendChild((Element)v.get(534));

      /* Empieza nodo:535 / Elemento padre: 534   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(535)).setAttribute("nombre","lblClasificacionCliente4" );
      ((Element)v.get(535)).setAttribute("alto","13" );
      ((Element)v.get(535)).setAttribute("filas","1" );
      ((Element)v.get(535)).setAttribute("valor","" );
      ((Element)v.get(535)).setAttribute("id","datosTitle" );
      ((Element)v.get(535)).setAttribute("cod","611" );
      ((Element)v.get(534)).appendChild((Element)v.get(535));
      /* Termina nodo:535   */
      /* Termina nodo:534   */

      /* Empieza nodo:536 / Elemento padre: 527   */
      v.add(doc.createElement("td"));
      ((Element)v.get(536)).setAttribute("width","100%" );
      ((Element)v.get(527)).appendChild((Element)v.get(536));

      /* Empieza nodo:537 / Elemento padre: 536   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(537)).setAttribute("src","b.gif" );
      ((Element)v.get(537)).setAttribute("width","8" );
      ((Element)v.get(537)).setAttribute("height","8" );
      ((Element)v.get(536)).appendChild((Element)v.get(537));
      /* Termina nodo:537   */
      /* Termina nodo:536   */
      /* Termina nodo:527   */

      /* Empieza nodo:538 / Elemento padre: 523   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(523)).appendChild((Element)v.get(538));

      /* Empieza nodo:539 / Elemento padre: 538   */
      v.add(doc.createElement("td"));
      ((Element)v.get(538)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(540)).setAttribute("src","b.gif" );
      ((Element)v.get(540)).setAttribute("width","8" );
      ((Element)v.get(540)).setAttribute("height","8" );
      ((Element)v.get(539)).appendChild((Element)v.get(540));
      /* Termina nodo:540   */
      /* Termina nodo:539   */

      /* Empieza nodo:541 / Elemento padre: 538   */
      v.add(doc.createElement("td"));
      ((Element)v.get(541)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(538)).appendChild((Element)v.get(541));

      /* Empieza nodo:542 / Elemento padre: 541   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(542)).setAttribute("nombre","cbTipoClasificacionCliente" );
      ((Element)v.get(542)).setAttribute("id","datosCampos" );
      ((Element)v.get(542)).setAttribute("size","1" );
      ((Element)v.get(542)).setAttribute("multiple","N" );
      ((Element)v.get(542)).setAttribute("req","N" );
      ((Element)v.get(542)).setAttribute("valorinicial","" );
      ((Element)v.get(542)).setAttribute("textoinicial","" );
      ((Element)v.get(542)).setAttribute("onchange","tipoClasificacionOnChange();" );
      ((Element)v.get(541)).appendChild((Element)v.get(542));

      /* Empieza nodo:543 / Elemento padre: 542   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(542)).appendChild((Element)v.get(543));
      /* Termina nodo:543   */
      /* Termina nodo:542   */
      /* Termina nodo:541   */

      /* Empieza nodo:544 / Elemento padre: 538   */
      v.add(doc.createElement("td"));
      ((Element)v.get(538)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(545)).setAttribute("src","b.gif" );
      ((Element)v.get(545)).setAttribute("width","25" );
      ((Element)v.get(545)).setAttribute("height","8" );
      ((Element)v.get(544)).appendChild((Element)v.get(545));
      /* Termina nodo:545   */
      /* Termina nodo:544   */

      /* Empieza nodo:546 / Elemento padre: 538   */
      v.add(doc.createElement("td"));
      ((Element)v.get(546)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(538)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(547)).setAttribute("nombre","cbClasificacionCliente" );
      ((Element)v.get(547)).setAttribute("id","datosCampos" );
      ((Element)v.get(547)).setAttribute("size","1" );
      ((Element)v.get(547)).setAttribute("multiple","N" );
      ((Element)v.get(547)).setAttribute("req","N" );
      ((Element)v.get(547)).setAttribute("valorinicial","" );
      ((Element)v.get(547)).setAttribute("textoinicial","" );
      ((Element)v.get(546)).appendChild((Element)v.get(547));

      /* Empieza nodo:548 / Elemento padre: 547   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(547)).appendChild((Element)v.get(548));
      /* Termina nodo:548   */
      /* Termina nodo:547   */
      /* Termina nodo:546   */

      /* Empieza nodo:549 / Elemento padre: 538   */
      v.add(doc.createElement("td"));
      ((Element)v.get(549)).setAttribute("width","100%" );
      ((Element)v.get(538)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(550)).setAttribute("src","b.gif" );
      ((Element)v.get(550)).setAttribute("width","8" );
      ((Element)v.get(550)).setAttribute("height","8" );
      ((Element)v.get(549)).appendChild((Element)v.get(550));
      /* Termina nodo:550   */
      /* Termina nodo:549   */
      /* Termina nodo:538   */
      /* Termina nodo:523   */
      /* Termina nodo:522   */
      /* Termina nodo:521   */

      /* Empieza nodo:551 / Elemento padre: 482   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(482)).appendChild((Element)v.get(551));

      /* Empieza nodo:552 / Elemento padre: 551   */
      v.add(doc.createElement("td"));
      ((Element)v.get(551)).appendChild((Element)v.get(552));

      /* Empieza nodo:553 / Elemento padre: 552   */
      v.add(doc.createElement("table"));
      ((Element)v.get(553)).setAttribute("width","702" );
      ((Element)v.get(553)).setAttribute("border","0" );
      ((Element)v.get(553)).setAttribute("align","left" );
      ((Element)v.get(553)).setAttribute("cellspacing","0" );
      ((Element)v.get(553)).setAttribute("cellpadding","0" );
      ((Element)v.get(552)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(553)).appendChild((Element)v.get(554));

      /* Empieza nodo:555 / Elemento padre: 554   */
      v.add(doc.createElement("td"));
      ((Element)v.get(555)).setAttribute("colspan","4" );
      ((Element)v.get(554)).appendChild((Element)v.get(555));

      /* Empieza nodo:556 / Elemento padre: 555   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(556)).setAttribute("src","b.gif" );
      ((Element)v.get(556)).setAttribute("width","8" );
      ((Element)v.get(556)).setAttribute("height","8" );
      ((Element)v.get(555)).appendChild((Element)v.get(556));
      /* Termina nodo:556   */
      /* Termina nodo:555   */
      /* Termina nodo:554   */

      /* Empieza nodo:557 / Elemento padre: 553   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(553)).appendChild((Element)v.get(557));

      /* Empieza nodo:558 / Elemento padre: 557   */
      v.add(doc.createElement("td"));
      ((Element)v.get(557)).appendChild((Element)v.get(558));

      /* Empieza nodo:559 / Elemento padre: 558   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(559)).setAttribute("src","b.gif" );
      ((Element)v.get(559)).setAttribute("width","8" );
      ((Element)v.get(559)).setAttribute("height","8" );
      ((Element)v.get(558)).appendChild((Element)v.get(559));
      /* Termina nodo:559   */
      /* Termina nodo:558   */

      /* Empieza nodo:560 / Elemento padre: 557   */
      v.add(doc.createElement("td"));
      ((Element)v.get(557)).appendChild((Element)v.get(560));

      /* Empieza nodo:561 / Elemento padre: 560   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(561)).setAttribute("nombre","lblEstatusCliente4" );
      ((Element)v.get(561)).setAttribute("alto","13" );
      ((Element)v.get(561)).setAttribute("filas","1" );
      ((Element)v.get(561)).setAttribute("valor","" );
      ((Element)v.get(561)).setAttribute("id","datosTitle" );
      ((Element)v.get(561)).setAttribute("cod","612" );
      ((Element)v.get(560)).appendChild((Element)v.get(561));
      /* Termina nodo:561   */
      /* Termina nodo:560   */

      /* Empieza nodo:562 / Elemento padre: 557   */
      v.add(doc.createElement("td"));
      ((Element)v.get(557)).appendChild((Element)v.get(562));

      /* Empieza nodo:563 / Elemento padre: 562   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(563)).setAttribute("src","b.gif" );
      ((Element)v.get(563)).setAttribute("width","25" );
      ((Element)v.get(563)).setAttribute("height","8" );
      ((Element)v.get(562)).appendChild((Element)v.get(563));
      /* Termina nodo:563   */
      /* Termina nodo:562   */

      /* Empieza nodo:564 / Elemento padre: 557   */
      v.add(doc.createElement("td"));
      ((Element)v.get(557)).appendChild((Element)v.get(564));

      /* Empieza nodo:565 / Elemento padre: 564   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(565)).setAttribute("nombre","lblEstatus2Cliente4" );
      ((Element)v.get(565)).setAttribute("alto","13" );
      ((Element)v.get(565)).setAttribute("filas","1" );
      ((Element)v.get(565)).setAttribute("valor","" );
      ((Element)v.get(565)).setAttribute("id","datosTitle" );
      ((Element)v.get(565)).setAttribute("cod","613" );
      ((Element)v.get(564)).appendChild((Element)v.get(565));
      /* Termina nodo:565   */
      /* Termina nodo:564   */

      /* Empieza nodo:566 / Elemento padre: 557   */
      v.add(doc.createElement("td"));
      ((Element)v.get(566)).setAttribute("width","100%" );
      ((Element)v.get(557)).appendChild((Element)v.get(566));

      /* Empieza nodo:567 / Elemento padre: 566   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(567)).setAttribute("src","b.gif" );
      ((Element)v.get(567)).setAttribute("width","8" );
      ((Element)v.get(567)).setAttribute("height","8" );
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(566)).appendChild((Element)v.get(567));
      /* Termina nodo:567   */
      /* Termina nodo:566   */
      /* Termina nodo:557   */

      /* Empieza nodo:568 / Elemento padre: 553   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(553)).appendChild((Element)v.get(568));

      /* Empieza nodo:569 / Elemento padre: 568   */
      v.add(doc.createElement("td"));
      ((Element)v.get(568)).appendChild((Element)v.get(569));

      /* Empieza nodo:570 / Elemento padre: 569   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(570)).setAttribute("src","b.gif" );
      ((Element)v.get(570)).setAttribute("width","8" );
      ((Element)v.get(570)).setAttribute("height","8" );
      ((Element)v.get(569)).appendChild((Element)v.get(570));
      /* Termina nodo:570   */
      /* Termina nodo:569   */

      /* Empieza nodo:571 / Elemento padre: 568   */
      v.add(doc.createElement("td"));
      ((Element)v.get(571)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(568)).appendChild((Element)v.get(571));

      /* Empieza nodo:572 / Elemento padre: 571   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(572)).setAttribute("nombre","cbEstatusCliente" );
      ((Element)v.get(572)).setAttribute("id","datosCampos" );
      ((Element)v.get(572)).setAttribute("size","1" );
      ((Element)v.get(572)).setAttribute("multiple","N" );
      ((Element)v.get(572)).setAttribute("req","N" );
      ((Element)v.get(572)).setAttribute("valorinicial","" );
      ((Element)v.get(572)).setAttribute("textoinicial","" );
      ((Element)v.get(571)).appendChild((Element)v.get(572));

      /* Empieza nodo:573 / Elemento padre: 572   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(572)).appendChild((Element)v.get(573));
      /* Termina nodo:573   */
      /* Termina nodo:572   */
      /* Termina nodo:571   */

      /* Empieza nodo:574 / Elemento padre: 568   */
      v.add(doc.createElement("td"));
      ((Element)v.get(568)).appendChild((Element)v.get(574));

      /* Empieza nodo:575 / Elemento padre: 574   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(575)).setAttribute("src","b.gif" );
      ((Element)v.get(575)).setAttribute("width","25" );
      ((Element)v.get(575)).setAttribute("height","8" );
      ((Element)v.get(574)).appendChild((Element)v.get(575));
      /* Termina nodo:575   */
      /* Termina nodo:574   */

      /* Empieza nodo:576 / Elemento padre: 568   */
      v.add(doc.createElement("td"));
      ((Element)v.get(576)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(568)).appendChild((Element)v.get(576));

      /* Empieza nodo:577 / Elemento padre: 576   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(577)).setAttribute("nombre","txtEstatus2Cliente" );
      ((Element)v.get(577)).setAttribute("id","datosCampos" );
      ((Element)v.get(577)).setAttribute("max","1" );
      ((Element)v.get(577)).setAttribute("tipo","" );
      ((Element)v.get(577)).setAttribute("onchange","" );
      ((Element)v.get(577)).setAttribute("req","N" );
      ((Element)v.get(577)).setAttribute("size","2" );
      ((Element)v.get(577)).setAttribute("valor","" );
      ((Element)v.get(577)).setAttribute("validacion","" );
      ((Element)v.get(577)).setAttribute("ontab","tabGenerico('txtEstatus2Cliente');" );
      ((Element)v.get(577)).setAttribute("onshtab","tabGenerico('txtEstatus2Cliente','sh');" );
      ((Element)v.get(576)).appendChild((Element)v.get(577));
      /* Termina nodo:577   */
      /* Termina nodo:576   */

      /* Empieza nodo:578 / Elemento padre: 568   */
      v.add(doc.createElement("td"));
      ((Element)v.get(568)).appendChild((Element)v.get(578));

      /* Empieza nodo:579 / Elemento padre: 578   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(579)).setAttribute("src","b.gif" );
      ((Element)v.get(579)).setAttribute("width","25" );
      ((Element)v.get(579)).setAttribute("height","8" );
      ((Element)v.get(578)).appendChild((Element)v.get(579));
      /* Termina nodo:579   */
      /* Termina nodo:578   */

      /* Empieza nodo:580 / Elemento padre: 568   */
      v.add(doc.createElement("td"));
      ((Element)v.get(580)).setAttribute("width","100%" );
      ((Element)v.get(568)).appendChild((Element)v.get(580));

      /* Empieza nodo:581 / Elemento padre: 580   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(581)).setAttribute("src","b.gif" );
      ((Element)v.get(581)).setAttribute("width","8" );
      ((Element)v.get(581)).setAttribute("height","8" );
      ((Element)v.get(580)).appendChild((Element)v.get(581));
      /* Termina nodo:581   */
      /* Termina nodo:580   */
      /* Termina nodo:568   */

      /* Empieza nodo:582 / Elemento padre: 553   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(553)).appendChild((Element)v.get(582));

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

      /* Empieza nodo:585 / Elemento padre: 553   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(553)).appendChild((Element)v.get(585));

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
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(589)).setAttribute("nombre","rbRegion" );
      ((Element)v.get(589)).setAttribute("tipo","H" );
      ((Element)v.get(589)).setAttribute("id","datosCampos" );
      ((Element)v.get(589)).setAttribute("ontab","" );
      ((Element)v.get(589)).setAttribute("onshtab","" );
      ((Element)v.get(589)).setAttribute("onclick","onClickRegion()" );
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(588)).appendChild((Element)v.get(589));

      /* Empieza nodo:590 / Elemento padre: 589   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(590)).setAttribute("valor","S" );
      ((Element)v.get(590)).setAttribute("onfocus","" );
      ((Element)v.get(590)).setAttribute("id","datosCampos" );
      ((Element)v.get(590)).setAttribute("cod","109" );
      ((Element)v.get(589)).appendChild((Element)v.get(590));
      /* Termina nodo:590   */
      /* Termina nodo:589   */
      /* Termina nodo:588   */

      /* Empieza nodo:591 / Elemento padre: 585   */
      v.add(doc.createElement("td"));
      ((Element)v.get(585)).appendChild((Element)v.get(591));

      /* Empieza nodo:592 / Elemento padre: 591   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(592)).setAttribute("src","b.gif" );
      ((Element)v.get(592)).setAttribute("width","25" );
      ((Element)v.get(592)).setAttribute("height","8" );
      ((Element)v.get(591)).appendChild((Element)v.get(592));
      /* Termina nodo:592   */
      /* Termina nodo:591   */

      /* Empieza nodo:593 / Elemento padre: 585   */
      v.add(doc.createElement("td"));
      ((Element)v.get(585)).appendChild((Element)v.get(593));

      /* Empieza nodo:594 / Elemento padre: 593   */
      v.add(doc.createElement("RADIOB"));
      ((Element)v.get(594)).setAttribute("nombre","rbZona" );
      ((Element)v.get(594)).setAttribute("tipo","H" );
      ((Element)v.get(594)).setAttribute("id","datosCampos" );
      ((Element)v.get(594)).setAttribute("ontab","" );
      ((Element)v.get(594)).setAttribute("onshtab","" );
      ((Element)v.get(594)).setAttribute("onclick","onClickZona()" );
      ((Element)v.get(593)).appendChild((Element)v.get(594));

      /* Empieza nodo:595 / Elemento padre: 594   */
      v.add(doc.createElement("RBINPUT"));
      ((Element)v.get(595)).setAttribute("valor","N" );
      ((Element)v.get(595)).setAttribute("onfocus","" );
      ((Element)v.get(595)).setAttribute("id","datosCampos" );
      ((Element)v.get(595)).setAttribute("cod","143" );
      ((Element)v.get(594)).appendChild((Element)v.get(595));
      /* Termina nodo:595   */
      /* Termina nodo:594   */
      /* Termina nodo:593   */

      /* Empieza nodo:596 / Elemento padre: 585   */
      v.add(doc.createElement("td"));
      ((Element)v.get(596)).setAttribute("width","100%" );
      ((Element)v.get(585)).appendChild((Element)v.get(596));

      /* Empieza nodo:597 / Elemento padre: 596   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(597)).setAttribute("src","b.gif" );
      ((Element)v.get(597)).setAttribute("width","8" );
      ((Element)v.get(597)).setAttribute("height","8" );
      ((Element)v.get(596)).appendChild((Element)v.get(597));
      /* Termina nodo:597   */
      /* Termina nodo:596   */
      /* Termina nodo:585   */

      /* Empieza nodo:598 / Elemento padre: 553   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(553)).appendChild((Element)v.get(598));

      /* Empieza nodo:599 / Elemento padre: 598   */
      v.add(doc.createElement("td"));
      ((Element)v.get(598)).appendChild((Element)v.get(599));

      /* Empieza nodo:600 / Elemento padre: 599   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(600)).setAttribute("src","b.gif" );
      ((Element)v.get(600)).setAttribute("width","8" );
      ((Element)v.get(600)).setAttribute("height","8" );
      ((Element)v.get(599)).appendChild((Element)v.get(600));
      /* Termina nodo:600   */
      /* Termina nodo:599   */

      /* Empieza nodo:601 / Elemento padre: 598   */
      v.add(doc.createElement("td"));
      ((Element)v.get(601)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(601)).setAttribute("valign","top" );
      ((Element)v.get(598)).appendChild((Element)v.get(601));

      /* Empieza nodo:602 / Elemento padre: 601   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(602)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(602)).setAttribute("id","datosCampos" );
      ((Element)v.get(602)).setAttribute("size","5" );
      ((Element)v.get(602)).setAttribute("multiple","S" );
      ((Element)v.get(602)).setAttribute("req","N" );
      ((Element)v.get(602)).setAttribute("valorinicial","" );
      ((Element)v.get(602)).setAttribute("onchange","" );
      ((Element)v.get(602)).setAttribute("textoinicial","" );
      ((Element)v.get(601)).appendChild((Element)v.get(602));

      /* Empieza nodo:603 / Elemento padre: 602   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(602)).appendChild((Element)v.get(603));
      /* Termina nodo:603   */
      /* Termina nodo:602   */
      /* Termina nodo:601   */

      /* Empieza nodo:604 / Elemento padre: 598   */
      v.add(doc.createElement("td"));
      ((Element)v.get(598)).appendChild((Element)v.get(604));

      /* Empieza nodo:605 / Elemento padre: 604   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(605)).setAttribute("src","b.gif" );
      ((Element)v.get(605)).setAttribute("width","25" );
      ((Element)v.get(605)).setAttribute("height","8" );
      ((Element)v.get(604)).appendChild((Element)v.get(605));
      /* Termina nodo:605   */
      /* Termina nodo:604   */

      /* Empieza nodo:606 / Elemento padre: 598   */
      v.add(doc.createElement("td"));
      ((Element)v.get(606)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(606)).setAttribute("valign","top" );
      ((Element)v.get(598)).appendChild((Element)v.get(606));

      /* Empieza nodo:607 / Elemento padre: 606   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(607)).setAttribute("nombre","cbZona" );
      ((Element)v.get(607)).setAttribute("id","datosCampos" );
      ((Element)v.get(607)).setAttribute("size","5" );
      ((Element)v.get(607)).setAttribute("multiple","S" );
      ((Element)v.get(607)).setAttribute("req","N" );
      ((Element)v.get(607)).setAttribute("valorinicial","" );
      ((Element)v.get(607)).setAttribute("textoinicial","" );
      ((Element)v.get(606)).appendChild((Element)v.get(607));

      /* Empieza nodo:608 / Elemento padre: 607   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(607)).appendChild((Element)v.get(608));
      /* Termina nodo:608   */
      /* Termina nodo:607   */
      /* Termina nodo:606   */

      /* Empieza nodo:609 / Elemento padre: 598   */
      v.add(doc.createElement("td"));
      ((Element)v.get(609)).setAttribute("width","100%" );
      ((Element)v.get(598)).appendChild((Element)v.get(609));

      /* Empieza nodo:610 / Elemento padre: 609   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(610)).setAttribute("src","b.gif" );
   }

   private void getXML2610(Document doc) {
      ((Element)v.get(610)).setAttribute("width","8" );
      ((Element)v.get(610)).setAttribute("height","8" );
      ((Element)v.get(609)).appendChild((Element)v.get(610));
      /* Termina nodo:610   */
      /* Termina nodo:609   */
      /* Termina nodo:598   */

      /* Empieza nodo:611 / Elemento padre: 553   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(553)).appendChild((Element)v.get(611));

      /* Empieza nodo:612 / Elemento padre: 611   */
      v.add(doc.createElement("td"));
      ((Element)v.get(612)).setAttribute("colspan","4" );
      ((Element)v.get(611)).appendChild((Element)v.get(612));

      /* Empieza nodo:613 / Elemento padre: 612   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(613)).setAttribute("src","b.gif" );
      ((Element)v.get(613)).setAttribute("width","8" );
      ((Element)v.get(613)).setAttribute("height","8" );
      ((Element)v.get(612)).appendChild((Element)v.get(613));
      /* Termina nodo:613   */
      /* Termina nodo:612   */
      /* Termina nodo:611   */
      /* Termina nodo:553   */
      /* Termina nodo:552   */
      /* Termina nodo:551   */
      /* Termina nodo:482   */
      /* Termina nodo:481   */
      /* Termina nodo:480   */
      /* Termina nodo:479   */
      /* Termina nodo:478   */
      /* Termina nodo:477   */

      /* Empieza nodo:614 / Elemento padre: 474   */
      v.add(doc.createElement("td"));
      ((Element)v.get(474)).appendChild((Element)v.get(614));

      /* Empieza nodo:615 / Elemento padre: 614   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(615)).setAttribute("src","b.gif" );
      ((Element)v.get(615)).setAttribute("width","12" );
      ((Element)v.get(615)).setAttribute("height","12" );
      ((Element)v.get(614)).appendChild((Element)v.get(615));
      /* Termina nodo:615   */
      /* Termina nodo:614   */
      /* Termina nodo:474   */

      /* Empieza nodo:616 / Elemento padre: 470   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(470)).appendChild((Element)v.get(616));

      /* Empieza nodo:617 / Elemento padre: 616   */
      v.add(doc.createElement("td"));
      ((Element)v.get(616)).appendChild((Element)v.get(617));

      /* Empieza nodo:618 / Elemento padre: 617   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(618)).setAttribute("src","b.gif" );
      ((Element)v.get(617)).appendChild((Element)v.get(618));
      /* Termina nodo:618   */
      /* Termina nodo:617   */

      /* Empieza nodo:619 / Elemento padre: 616   */
      v.add(doc.createElement("td"));
      ((Element)v.get(619)).setAttribute("colspan","7" );
      ((Element)v.get(616)).appendChild((Element)v.get(619));

      /* Empieza nodo:620 / Elemento padre: 619   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(619)).appendChild((Element)v.get(620));

      /* Empieza nodo:621 / Elemento padre: 620   */
      v.add(doc.createElement("table"));
      ((Element)v.get(621)).setAttribute("width","100%" );
      ((Element)v.get(621)).setAttribute("border","0" );
      ((Element)v.get(621)).setAttribute("align","center" );
      ((Element)v.get(621)).setAttribute("cellspacing","0" );
      ((Element)v.get(621)).setAttribute("cellpadding","0" );
      ((Element)v.get(620)).appendChild((Element)v.get(621));

      /* Empieza nodo:622 / Elemento padre: 621   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(621)).appendChild((Element)v.get(622));

      /* Empieza nodo:623 / Elemento padre: 622   */
      v.add(doc.createElement("td"));
      ((Element)v.get(623)).setAttribute("class","botonera" );
      ((Element)v.get(623)).setAttribute("width","100%" );
      ((Element)v.get(622)).appendChild((Element)v.get(623));

      /* Empieza nodo:624 / Elemento padre: 623   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(624)).setAttribute("nombre","btnAnadir5" );
      ((Element)v.get(624)).setAttribute("ID","botonContenido" );
      ((Element)v.get(624)).setAttribute("tipo","html" );
      ((Element)v.get(624)).setAttribute("estado","false" );
      ((Element)v.get(624)).setAttribute("cod","404" );
      ((Element)v.get(624)).setAttribute("accion","accionAniadirVentaExclusiva();" );
      ((Element)v.get(624)).setAttribute("ontab","tabGenerico('btnAnadir5');" );
      ((Element)v.get(624)).setAttribute("onshtab","tabGenerico('btnAnadir5','sh');" );
      ((Element)v.get(623)).appendChild((Element)v.get(624));
      /* Termina nodo:624   */
      /* Termina nodo:623   */
      /* Termina nodo:622   */
      /* Termina nodo:621   */
      /* Termina nodo:620   */
      /* Termina nodo:619   */

      /* Empieza nodo:625 / Elemento padre: 616   */
      v.add(doc.createElement("td"));
      ((Element)v.get(616)).appendChild((Element)v.get(625));

      /* Empieza nodo:626 / Elemento padre: 625   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(626)).setAttribute("src","b.gif" );
      ((Element)v.get(626)).setAttribute("width","12" );
      ((Element)v.get(626)).setAttribute("height","12" );
      ((Element)v.get(625)).appendChild((Element)v.get(626));
      /* Termina nodo:626   */
      /* Termina nodo:625   */
      /* Termina nodo:616   */

      /* Empieza nodo:627 / Elemento padre: 470   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(470)).appendChild((Element)v.get(627));

      /* Empieza nodo:628 / Elemento padre: 627   */
      v.add(doc.createElement("td"));
      ((Element)v.get(628)).setAttribute("colspan","9" );
      ((Element)v.get(627)).appendChild((Element)v.get(628));

      /* Empieza nodo:629 / Elemento padre: 628   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(629)).setAttribute("src","b.gif" );
      ((Element)v.get(629)).setAttribute("width","12" );
      ((Element)v.get(629)).setAttribute("height","330" );
      ((Element)v.get(628)).appendChild((Element)v.get(629));
      /* Termina nodo:629   */
      /* Termina nodo:628   */
      /* Termina nodo:627   */
      /* Termina nodo:470   */
      /* Termina nodo:467   */
      /* Termina nodo:466   */

      /* Empieza nodo:630 / Elemento padre: 463   */
      v.add(doc.createElement("td"));
      ((Element)v.get(463)).appendChild((Element)v.get(630));

      /* Empieza nodo:631 / Elemento padre: 630   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(631)).setAttribute("src","b.gif" );
      ((Element)v.get(631)).setAttribute("width","12" );
      ((Element)v.get(631)).setAttribute("height","12" );
      ((Element)v.get(630)).appendChild((Element)v.get(631));
      /* Termina nodo:631   */
      /* Termina nodo:630   */
      /* Termina nodo:463   */

      /* Empieza nodo:632 / Elemento padre: 455   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(455)).appendChild((Element)v.get(632));

      /* Empieza nodo:633 / Elemento padre: 632   */
      v.add(doc.createElement("td"));
      ((Element)v.get(633)).setAttribute("width","12" );
      ((Element)v.get(633)).setAttribute("align","center" );
      ((Element)v.get(632)).appendChild((Element)v.get(633));

      /* Empieza nodo:634 / Elemento padre: 633   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(634)).setAttribute("src","b.gif" );
      ((Element)v.get(634)).setAttribute("width","12" );
      ((Element)v.get(634)).setAttribute("height","12" );
      ((Element)v.get(633)).appendChild((Element)v.get(634));
      /* Termina nodo:634   */
      /* Termina nodo:633   */

      /* Empieza nodo:635 / Elemento padre: 632   */
   }

   private void getXML2700(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(635)).setAttribute("width","750" );
      ((Element)v.get(632)).appendChild((Element)v.get(635));

      /* Empieza nodo:636 / Elemento padre: 635   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(636)).setAttribute("src","b.gif" );
      ((Element)v.get(635)).appendChild((Element)v.get(636));
      /* Termina nodo:636   */
      /* Termina nodo:635   */

      /* Empieza nodo:637 / Elemento padre: 632   */
      v.add(doc.createElement("td"));
      ((Element)v.get(637)).setAttribute("width","12" );
      ((Element)v.get(632)).appendChild((Element)v.get(637));

      /* Empieza nodo:638 / Elemento padre: 637   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(638)).setAttribute("src","b.gif" );
      ((Element)v.get(638)).setAttribute("width","12" );
      ((Element)v.get(638)).setAttribute("height","12" );
      ((Element)v.get(637)).appendChild((Element)v.get(638));
      /* Termina nodo:638   */
      /* Termina nodo:637   */
      /* Termina nodo:632   */
      /* Termina nodo:455   */
      /* Termina nodo:454   */

      /* Empieza nodo:639 / Elemento padre: 13   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(639)).setAttribute("nombre","listado5" );
      ((Element)v.get(639)).setAttribute("ancho","704" );
      ((Element)v.get(639)).setAttribute("alto","295" );
      ((Element)v.get(639)).setAttribute("x","27" );
      ((Element)v.get(639)).setAttribute("y","2228" );
      ((Element)v.get(639)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(639)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(13)).appendChild((Element)v.get(639));

      /* Empieza nodo:640 / Elemento padre: 639   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(640)).setAttribute("precarga","S" );
      ((Element)v.get(640)).setAttribute("conROver","S" );
      ((Element)v.get(639)).appendChild((Element)v.get(640));

      /* Empieza nodo:641 / Elemento padre: 640   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(641)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(641)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(641)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(641)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(640)).appendChild((Element)v.get(641));
      /* Termina nodo:641   */

      /* Empieza nodo:642 / Elemento padre: 640   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(642)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(642)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(642)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(642)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(640)).appendChild((Element)v.get(642));
      /* Termina nodo:642   */

      /* Empieza nodo:643 / Elemento padre: 640   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(643)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(643)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(640)).appendChild((Element)v.get(643));
      /* Termina nodo:643   */
      /* Termina nodo:640   */

      /* Empieza nodo:644 / Elemento padre: 639   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(639)).appendChild((Element)v.get(644));

      /* Empieza nodo:645 / Elemento padre: 644   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(645)).setAttribute("borde","1" );
      ((Element)v.get(645)).setAttribute("horizDatos","1" );
      ((Element)v.get(645)).setAttribute("horizCabecera","1" );
      ((Element)v.get(645)).setAttribute("vertical","1" );
      ((Element)v.get(645)).setAttribute("horizTitulo","1" );
      ((Element)v.get(645)).setAttribute("horizBase","1" );
      ((Element)v.get(644)).appendChild((Element)v.get(645));
      /* Termina nodo:645   */

      /* Empieza nodo:646 / Elemento padre: 644   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(646)).setAttribute("borde","#999999" );
      ((Element)v.get(646)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(646)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(646)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(646)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(646)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(646)).setAttribute("horizBase","#999999" );
      ((Element)v.get(644)).appendChild((Element)v.get(646));
      /* Termina nodo:646   */
      /* Termina nodo:644   */

      /* Empieza nodo:647 / Elemento padre: 639   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(647)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(647)).setAttribute("alto","22" );
      ((Element)v.get(647)).setAttribute("imgFondo","" );
      ((Element)v.get(639)).appendChild((Element)v.get(647));
      /* Termina nodo:647   */

      /* Empieza nodo:648 / Elemento padre: 639   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(648)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(648)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(648)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(648)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(648)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(648)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(639)).appendChild((Element)v.get(648));

      /* Empieza nodo:649 / Elemento padre: 648   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(649)).setAttribute("ancho","100" );
      ((Element)v.get(649)).setAttribute("minimizable","S" );
      ((Element)v.get(649)).setAttribute("minimizada","N" );
      ((Element)v.get(648)).appendChild((Element)v.get(649));
      /* Termina nodo:649   */

      /* Empieza nodo:650 / Elemento padre: 648   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(650)).setAttribute("ancho","100" );
      ((Element)v.get(650)).setAttribute("minimizable","S" );
      ((Element)v.get(650)).setAttribute("minimizada","N" );
      ((Element)v.get(648)).appendChild((Element)v.get(650));
      /* Termina nodo:650   */

      /* Empieza nodo:651 / Elemento padre: 648   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(651)).setAttribute("ancho","150" );
      ((Element)v.get(651)).setAttribute("minimizable","S" );
      ((Element)v.get(651)).setAttribute("minimizada","N" );
      ((Element)v.get(648)).appendChild((Element)v.get(651));
      /* Termina nodo:651   */

      /* Empieza nodo:652 / Elemento padre: 648   */
   }

   private void getXML2790(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(652)).setAttribute("ancho","130" );
      ((Element)v.get(652)).setAttribute("minimizable","S" );
      ((Element)v.get(652)).setAttribute("minimizada","N" );
      ((Element)v.get(648)).appendChild((Element)v.get(652));
      /* Termina nodo:652   */

      /* Empieza nodo:653 / Elemento padre: 648   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(653)).setAttribute("ancho","100" );
      ((Element)v.get(653)).setAttribute("minimizable","S" );
      ((Element)v.get(653)).setAttribute("minimizada","N" );
      ((Element)v.get(648)).appendChild((Element)v.get(653));
      /* Termina nodo:653   */

      /* Empieza nodo:654 / Elemento padre: 648   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(654)).setAttribute("ancho","100" );
      ((Element)v.get(654)).setAttribute("minimizable","S" );
      ((Element)v.get(654)).setAttribute("minimizada","N" );
      ((Element)v.get(648)).appendChild((Element)v.get(654));
      /* Termina nodo:654   */

      /* Empieza nodo:655 / Elemento padre: 648   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(655)).setAttribute("ancho","100" );
      ((Element)v.get(655)).setAttribute("minimizable","S" );
      ((Element)v.get(655)).setAttribute("minimizada","N" );
      ((Element)v.get(648)).appendChild((Element)v.get(655));
      /* Termina nodo:655   */

      /* Empieza nodo:656 / Elemento padre: 648   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(656)).setAttribute("ancho","100" );
      ((Element)v.get(656)).setAttribute("minimizable","S" );
      ((Element)v.get(656)).setAttribute("minimizada","N" );
      ((Element)v.get(648)).appendChild((Element)v.get(656));
      /* Termina nodo:656   */
      /* Termina nodo:648   */

      /* Empieza nodo:657 / Elemento padre: 639   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(657)).setAttribute("alto","20" );
      ((Element)v.get(657)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(657)).setAttribute("imgFondo","" );
      ((Element)v.get(657)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(639)).appendChild((Element)v.get(657));

      /* Empieza nodo:658 / Elemento padre: 657   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(658)).setAttribute("colFondo","" );
      ((Element)v.get(658)).setAttribute("ID","EstCab" );
      ((Element)v.get(658)).setAttribute("cod","393" );
      ((Element)v.get(657)).appendChild((Element)v.get(658));
      /* Termina nodo:658   */

      /* Empieza nodo:659 / Elemento padre: 657   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(659)).setAttribute("colFondo","" );
      ((Element)v.get(659)).setAttribute("ID","EstCab" );
      ((Element)v.get(659)).setAttribute("cod","595" );
      ((Element)v.get(657)).appendChild((Element)v.get(659));
      /* Termina nodo:659   */

      /* Empieza nodo:660 / Elemento padre: 657   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(660)).setAttribute("colFondo","" );
      ((Element)v.get(660)).setAttribute("ID","EstCab" );
      ((Element)v.get(660)).setAttribute("cod","610" );
      ((Element)v.get(657)).appendChild((Element)v.get(660));
      /* Termina nodo:660   */

      /* Empieza nodo:661 / Elemento padre: 657   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(661)).setAttribute("colFondo","" );
      ((Element)v.get(661)).setAttribute("ID","EstCab" );
      ((Element)v.get(661)).setAttribute("cod","611" );
      ((Element)v.get(657)).appendChild((Element)v.get(661));
      /* Termina nodo:661   */

      /* Empieza nodo:662 / Elemento padre: 657   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(662)).setAttribute("colFondo","" );
      ((Element)v.get(662)).setAttribute("ID","EstCab" );
      ((Element)v.get(662)).setAttribute("cod","551" );
      ((Element)v.get(657)).appendChild((Element)v.get(662));
      /* Termina nodo:662   */

      /* Empieza nodo:663 / Elemento padre: 657   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(663)).setAttribute("colFondo","" );
      ((Element)v.get(663)).setAttribute("ID","EstCab" );
      ((Element)v.get(663)).setAttribute("cod","552" );
      ((Element)v.get(657)).appendChild((Element)v.get(663));
      /* Termina nodo:663   */

      /* Empieza nodo:664 / Elemento padre: 657   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(664)).setAttribute("colFondo","" );
      ((Element)v.get(664)).setAttribute("ID","EstCab" );
      ((Element)v.get(664)).setAttribute("cod","109" );
      ((Element)v.get(657)).appendChild((Element)v.get(664));

      /* Elemento padre:664 / Elemento actual: 665   */
      v.add(doc.createTextNode("Region"));
      ((Element)v.get(664)).appendChild((Text)v.get(665));

      /* Termina nodo Texto:665   */
      /* Termina nodo:664   */

      /* Empieza nodo:666 / Elemento padre: 657   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(666)).setAttribute("colFondo","" );
      ((Element)v.get(666)).setAttribute("ID","EstCab" );
      ((Element)v.get(666)).setAttribute("cod","143" );
      ((Element)v.get(657)).appendChild((Element)v.get(666));

      /* Elemento padre:666 / Elemento actual: 667   */
      v.add(doc.createTextNode("Zona"));
      ((Element)v.get(666)).appendChild((Text)v.get(667));

      /* Termina nodo Texto:667   */
      /* Termina nodo:666   */
      /* Termina nodo:657   */

      /* Empieza nodo:668 / Elemento padre: 639   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(668)).setAttribute("alto","22" );
      ((Element)v.get(668)).setAttribute("accion","" );
      ((Element)v.get(668)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(668)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(668)).setAttribute("maxSel","-1" );
      ((Element)v.get(668)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(668)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(668)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(668)).setAttribute("onLoad","" );
      ((Element)v.get(668)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(639)).appendChild((Element)v.get(668));

      /* Empieza nodo:669 / Elemento padre: 668   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(669)).setAttribute("tipo","texto" );
      ((Element)v.get(669)).setAttribute("ID","EstDat" );
   }

   private void getXML2880(Document doc) {
      ((Element)v.get(668)).appendChild((Element)v.get(669));
      /* Termina nodo:669   */

      /* Empieza nodo:670 / Elemento padre: 668   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(670)).setAttribute("tipo","texto" );
      ((Element)v.get(670)).setAttribute("ID","EstDat2" );
      ((Element)v.get(668)).appendChild((Element)v.get(670));
      /* Termina nodo:670   */

      /* Empieza nodo:671 / Elemento padre: 668   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(671)).setAttribute("tipo","texto" );
      ((Element)v.get(671)).setAttribute("ID","EstDat" );
      ((Element)v.get(668)).appendChild((Element)v.get(671));
      /* Termina nodo:671   */

      /* Empieza nodo:672 / Elemento padre: 668   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(672)).setAttribute("tipo","texto" );
      ((Element)v.get(672)).setAttribute("ID","EstDat2" );
      ((Element)v.get(668)).appendChild((Element)v.get(672));
      /* Termina nodo:672   */

      /* Empieza nodo:673 / Elemento padre: 668   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(673)).setAttribute("tipo","texto" );
      ((Element)v.get(673)).setAttribute("ID","EstDat" );
      ((Element)v.get(668)).appendChild((Element)v.get(673));
      /* Termina nodo:673   */

      /* Empieza nodo:674 / Elemento padre: 668   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(674)).setAttribute("tipo","texto" );
      ((Element)v.get(674)).setAttribute("ID","EstDat2" );
      ((Element)v.get(668)).appendChild((Element)v.get(674));
      /* Termina nodo:674   */

      /* Empieza nodo:675 / Elemento padre: 668   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(675)).setAttribute("tipo","texto" );
      ((Element)v.get(675)).setAttribute("ID","EstDat" );
      ((Element)v.get(668)).appendChild((Element)v.get(675));
      /* Termina nodo:675   */

      /* Empieza nodo:676 / Elemento padre: 668   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(676)).setAttribute("tipo","texto" );
      ((Element)v.get(676)).setAttribute("ID","EstDat2" );
      ((Element)v.get(668)).appendChild((Element)v.get(676));
      /* Termina nodo:676   */
      /* Termina nodo:668   */

      /* Empieza nodo:677 / Elemento padre: 639   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(639)).appendChild((Element)v.get(677));
      /* Termina nodo:677   */

      /* Empieza nodo:678 / Elemento padre: 639   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(678)).setAttribute("nombre","mipgndo5" );
      ((Element)v.get(678)).setAttribute("ancho","704" );
      ((Element)v.get(678)).setAttribute("sep","$" );
      ((Element)v.get(678)).setAttribute("x","12" );
      ((Element)v.get(678)).setAttribute("class","botonera" );
      ((Element)v.get(678)).setAttribute("y","2500" );
      ((Element)v.get(678)).setAttribute("control","|" );
      ((Element)v.get(678)).setAttribute("conector","" );
      ((Element)v.get(678)).setAttribute("rowset","" );
      ((Element)v.get(678)).setAttribute("cargainicial","N" );
      ((Element)v.get(639)).appendChild((Element)v.get(678));
      /* Termina nodo:678   */
      /* Termina nodo:639   */

      /* Empieza nodo:679 / Elemento padre: 13   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(679)).setAttribute("nombre","Eliminar5" );
      ((Element)v.get(679)).setAttribute("x","30" );
      ((Element)v.get(679)).setAttribute("y","2501" );
      ((Element)v.get(679)).setAttribute("ID","botonContenido" );
      ((Element)v.get(679)).setAttribute("tipo","html" );
      ((Element)v.get(679)).setAttribute("estado","false" );
      ((Element)v.get(679)).setAttribute("cod","1254" );
      ((Element)v.get(679)).setAttribute("accion","accionEliminarVentaExclusiva();" );
      ((Element)v.get(679)).setAttribute("ontab","tabGenerico('Eliminar5');" );
      ((Element)v.get(679)).setAttribute("onshtab","tabGenerico('Eliminar5','sh');" );
      ((Element)v.get(13)).appendChild((Element)v.get(679));
      /* Termina nodo:679   */
      /* Termina nodo:13   */


   }

}

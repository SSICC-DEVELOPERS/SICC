
import org.w3c.dom.*;
import java.util.ArrayList;

public class contenido_ejecutar_reterritorializacion  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","contenido_ejecutar_reterritorializacion" );
      ((Element)v.get(0)).setAttribute("cod","3193" );
      ((Element)v.get(0)).setAttribute("titulo","" );
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
      ((Element)v.get(4)).setAttribute("src","contenido_ejecutar_reterritorializacion.js" );
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
      ((Element)v.get(7)).setAttribute("name","cbMarca" );
      ((Element)v.get(7)).setAttribute("required","true" );
      ((Element)v.get(7)).setAttribute("group","gBuscar" );
      ((Element)v.get(7)).setAttribute("cod","6" );
      ((Element)v.get(6)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(8)).setAttribute("name","cbCanal" );
      ((Element)v.get(8)).setAttribute("required","true" );
      ((Element)v.get(8)).setAttribute("group","gBuscar" );
      ((Element)v.get(8)).setAttribute("cod","00217" );
      ((Element)v.get(6)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(9)).setAttribute("name","cbPeriodo" );
      ((Element)v.get(9)).setAttribute("required","true" );
      ((Element)v.get(9)).setAttribute("group","gBuscar" );
      ((Element)v.get(9)).setAttribute("cod","447" );
      ((Element)v.get(6)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(10)).setAttribute("name","cbSubgerenciaVentas" );
      ((Element)v.get(10)).setAttribute("required","true" );
      ((Element)v.get(10)).setAttribute("group","gBuscar" );
      ((Element)v.get(10)).setAttribute("cod","124" );
      ((Element)v.get(6)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(11)).setAttribute("name","cbRegion" );
      ((Element)v.get(11)).setAttribute("required","true" );
      ((Element)v.get(11)).setAttribute("group","gBuscar" );
      ((Element)v.get(11)).setAttribute("cod","109" );
      ((Element)v.get(6)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(12)).setAttribute("name","cbZona" );
      ((Element)v.get(12)).setAttribute("required","true" );
      ((Element)v.get(12)).setAttribute("group","gBuscar" );
      ((Element)v.get(12)).setAttribute("cod","143" );
      ((Element)v.get(6)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(13)).setAttribute("name","cbSeccion" );
      ((Element)v.get(13)).setAttribute("required","true" );
      ((Element)v.get(13)).setAttribute("group","gBuscar" );
      ((Element)v.get(13)).setAttribute("cod","112" );
      ((Element)v.get(6)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(14)).setAttribute("name","cbTipoOperacion" );
      ((Element)v.get(14)).setAttribute("required","true" );
      ((Element)v.get(14)).setAttribute("group","gBuscar" );
      ((Element)v.get(14)).setAttribute("cod","3194" );
      ((Element)v.get(6)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(15)).setAttribute("name","cbTerrPartir" );
      ((Element)v.get(15)).setAttribute("required","true" );
      ((Element)v.get(15)).setAttribute("group","gBuscarPart" );
      ((Element)v.get(15)).setAttribute("cod","3195" );
      ((Element)v.get(6)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(16)).setAttribute("name","cbTerrOrigTrasv" );
      ((Element)v.get(16)).setAttribute("required","true" );
      ((Element)v.get(16)).setAttribute("group","gBuscarTrav" );
      ((Element)v.get(16)).setAttribute("cod","3196" );
      ((Element)v.get(6)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(17)).setAttribute("name","txtTerrCrear" );
      ((Element)v.get(17)).setAttribute("required","true" );
      ((Element)v.get(17)).setAttribute("format","e" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(17)).setAttribute("min","0" );
      ((Element)v.get(17)).setAttribute("max","999999" );
      ((Element)v.get(17)).setAttribute("group","gAniadirPart" );
      ((Element)v.get(17)).setAttribute("cod","3199" );
      ((Element)v.get(6)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(18)).setAttribute("name","cbNSE1" );
      ((Element)v.get(18)).setAttribute("required","true" );
      ((Element)v.get(18)).setAttribute("group","gAniadirPart" );
      ((Element)v.get(18)).setAttribute("cod","3200" );
      ((Element)v.get(6)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(19)).setAttribute("name","cbNSE2" );
      ((Element)v.get(19)).setAttribute("required","true" );
      ((Element)v.get(19)).setAttribute("group","gAniadirPart" );
      ((Element)v.get(19)).setAttribute("cod","3201" );
      ((Element)v.get(6)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(20)).setAttribute("name","cbConsultorasPart" );
      ((Element)v.get(20)).setAttribute("required","true" );
      ((Element)v.get(20)).setAttribute("group","gAniadirPart" );
      ((Element)v.get(20)).setAttribute("cod","00401" );
      ((Element)v.get(6)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(21)).setAttribute("name","cbSubgerenciaVentasTrasv" );
      ((Element)v.get(21)).setAttribute("required","true" );
      ((Element)v.get(21)).setAttribute("group","gAniadirTrasv" );
      ((Element)v.get(21)).setAttribute("cod","124" );
      ((Element)v.get(6)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(22)).setAttribute("name","cbRegionTrasv" );
      ((Element)v.get(22)).setAttribute("required","true" );
      ((Element)v.get(22)).setAttribute("group","gAniadirTrasv" );
      ((Element)v.get(22)).setAttribute("cod","109" );
      ((Element)v.get(6)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(23)).setAttribute("name","cbZonaTrasv" );
      ((Element)v.get(23)).setAttribute("required","true" );
      ((Element)v.get(23)).setAttribute("group","gAniadirTrasv" );
      ((Element)v.get(23)).setAttribute("cod","143" );
      ((Element)v.get(6)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(24)).setAttribute("name","cbSeccionTrasv" );
      ((Element)v.get(24)).setAttribute("required","true" );
      ((Element)v.get(24)).setAttribute("group","gAniadirTrasv" );
      ((Element)v.get(24)).setAttribute("cod","112" );
      ((Element)v.get(6)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(25)).setAttribute("name","cbTerrDest" );
      ((Element)v.get(25)).setAttribute("required","true" );
      ((Element)v.get(25)).setAttribute("group","gAniadirTrasv" );
      ((Element)v.get(25)).setAttribute("cod","3203" );
      ((Element)v.get(6)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(26)).setAttribute("name","cbConsultorasTrasv" );
      ((Element)v.get(26)).setAttribute("required","true" );
      ((Element)v.get(26)).setAttribute("group","gAniadirTrasv" );
      ((Element)v.get(26)).setAttribute("cod","00401" );
      ((Element)v.get(6)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(27)).setAttribute("name","cbTerr1Fusionar" );
      ((Element)v.get(27)).setAttribute("required","true" );
      ((Element)v.get(27)).setAttribute("group","gGuardarFusion" );
      ((Element)v.get(27)).setAttribute("cod","3223" );
      ((Element)v.get(6)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(28)).setAttribute("name","cbTerr2Fusionar" );
      ((Element)v.get(28)).setAttribute("required","true" );
      ((Element)v.get(28)).setAttribute("group","gGuardarFusion" );
      ((Element)v.get(28)).setAttribute("cod","3224" );
      ((Element)v.get(6)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(29)).setAttribute("name","txtTerrCrearFusion" );
      ((Element)v.get(29)).setAttribute("required","true" );
      ((Element)v.get(29)).setAttribute("format","e" );
      ((Element)v.get(29)).setAttribute("min","0" );
      ((Element)v.get(29)).setAttribute("max","999999" );
      ((Element)v.get(29)).setAttribute("group","gGuardarFusion" );
      ((Element)v.get(29)).setAttribute("cod","3199" );
      ((Element)v.get(6)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(30)).setAttribute("name","cbNSE1Fusion" );
      ((Element)v.get(30)).setAttribute("required","true" );
      ((Element)v.get(30)).setAttribute("group","gGuardarFusion" );
      ((Element)v.get(30)).setAttribute("cod","3200" );
      ((Element)v.get(6)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 6   */
      v.add(doc.createElement("ELEMENTO"));
      ((Element)v.get(31)).setAttribute("name","cbNSE2Fusion" );
      ((Element)v.get(31)).setAttribute("required","true" );
      ((Element)v.get(31)).setAttribute("group","gGuardarFusion" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(31)).setAttribute("cod","3201" );
      ((Element)v.get(6)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */
      /* Termina nodo:6   */
      /* Termina nodo:5   */

      /* Empieza nodo:32 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(32)).setAttribute("nombre","formulario" );
      ((Element)v.get(32)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(32));

      /* Empieza nodo:33 / Elemento padre: 32   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","accion" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(32)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 32   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(32)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 32   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(32)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 32   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(32)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 32   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(37)).setAttribute("nombre","hPais" );
      ((Element)v.get(37)).setAttribute("valor","" );
      ((Element)v.get(32)).appendChild((Element)v.get(37));
      /* Termina nodo:37   */

      /* Empieza nodo:38 / Elemento padre: 32   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(38)).setAttribute("nombre","hIdioma" );
      ((Element)v.get(38)).setAttribute("valor","" );
      ((Element)v.get(32)).appendChild((Element)v.get(38));
      /* Termina nodo:38   */

      /* Empieza nodo:39 / Elemento padre: 32   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(39)).setAttribute("nombre","UAPadre" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(32)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */

      /* Empieza nodo:40 / Elemento padre: 32   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(40)).setAttribute("nombre","codTerrPartir" );
      ((Element)v.get(40)).setAttribute("valor","" );
      ((Element)v.get(32)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */

      /* Empieza nodo:41 / Elemento padre: 32   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(41)).setAttribute("nombre","codTerrOrigTrasv" );
      ((Element)v.get(41)).setAttribute("valor","" );
      ((Element)v.get(32)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */

      /* Empieza nodo:42 / Elemento padre: 32   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(42)).setAttribute("nombre","listaDetalles" );
      ((Element)v.get(42)).setAttribute("valor","" );
      ((Element)v.get(32)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */

      /* Empieza nodo:43 / Elemento padre: 32   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(43)).setAttribute("nombre","codTerr1Fusionar" );
      ((Element)v.get(43)).setAttribute("valor","" );
      ((Element)v.get(32)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */

      /* Empieza nodo:44 / Elemento padre: 32   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(44)).setAttribute("nombre","codTerr2Fusionar" );
      ((Element)v.get(44)).setAttribute("valor","" );
      ((Element)v.get(32)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */

      /* Empieza nodo:45 / Elemento padre: 32   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(45)).setAttribute("nombre","capa1" );
      ((Element)v.get(32)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("table"));
      ((Element)v.get(46)).setAttribute("width","100%" );
      ((Element)v.get(46)).setAttribute("border","0" );
      ((Element)v.get(46)).setAttribute("cellspacing","0" );
      ((Element)v.get(46)).setAttribute("cellpadding","0" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(48)).setAttribute("width","12" );
      ((Element)v.get(48)).setAttribute("align","center" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(49)).setAttribute("src","b.gif" );
      ((Element)v.get(49)).setAttribute("width","12" );
      ((Element)v.get(49)).setAttribute("height","12" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:50 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(50)).setAttribute("width","750" );
      ((Element)v.get(47)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(51)).setAttribute("src","b.gif" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 47   */
      v.add(doc.createElement("td"));
      ((Element)v.get(52)).setAttribute("width","12" );
      ((Element)v.get(47)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(53)).setAttribute("src","b.gif" );
      ((Element)v.get(53)).setAttribute("width","12" );
      ((Element)v.get(53)).setAttribute("height","1" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));
      /* Termina nodo:53   */
      /* Termina nodo:52   */
      /* Termina nodo:47   */

      /* Empieza nodo:54 / Elemento padre: 46   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(46)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:57 / Elemento padre: 54   */
      v.add(doc.createElement("td"));
      ((Element)v.get(54)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(59)).setAttribute("class","legend" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(60)).setAttribute("nombre","lblDatosDeAlta" );
      ((Element)v.get(60)).setAttribute("alto","13" );
      ((Element)v.get(60)).setAttribute("filas","1" );
      ((Element)v.get(60)).setAttribute("cod","00127" );
      ((Element)v.get(60)).setAttribute("id","legend" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */

      /* Empieza nodo:61 / Elemento padre: 58   */
      v.add(doc.createElement("table"));
      ((Element)v.get(61)).setAttribute("width","100%" );
      ((Element)v.get(61)).setAttribute("border","0" );
      ((Element)v.get(61)).setAttribute("align","center" );
      ((Element)v.get(61)).setAttribute("cellspacing","0" );
      ((Element)v.get(61)).setAttribute("cellpadding","0" );
      ((Element)v.get(58)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("td"));
      ((Element)v.get(63)).setAttribute("colspan","7" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(64)).setAttribute("width","8" );
      ((Element)v.get(64)).setAttribute("height","8" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:65 / Elemento padre: 61   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(61)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","8" );
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(69)).setAttribute("nombre","lblMarca" );
      ((Element)v.get(69)).setAttribute("alto","13" );
      ((Element)v.get(69)).setAttribute("filas","1" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(69)).setAttribute("id","datosTitle" );
      ((Element)v.get(69)).setAttribute("cod","6" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","25" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(73)).setAttribute("nombre","lblCanal" );
      ((Element)v.get(73)).setAttribute("alto","13" );
      ((Element)v.get(73)).setAttribute("filas","1" );
      ((Element)v.get(73)).setAttribute("valor","" );
      ((Element)v.get(73)).setAttribute("id","datosTitle" );
      ((Element)v.get(73)).setAttribute("cod","00217" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */

      /* Empieza nodo:74 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(75)).setAttribute("src","b.gif" );
      ((Element)v.get(75)).setAttribute("width","8" );
      ((Element)v.get(75)).setAttribute("height","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));
      /* Termina nodo:75   */
      /* Termina nodo:74   */

      /* Empieza nodo:76 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
      ((Element)v.get(65)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(77)).setAttribute("nombre","lblPeriodo" );
      ((Element)v.get(77)).setAttribute("alto","13" );
      ((Element)v.get(77)).setAttribute("filas","1" );
      ((Element)v.get(77)).setAttribute("valor","" );
      ((Element)v.get(77)).setAttribute("id","datosTitle" );
      ((Element)v.get(77)).setAttribute("cod","447" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 65   */
      v.add(doc.createElement("td"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(78)).setAttribute("width","100%" );
      ((Element)v.get(65)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","8" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:65   */

      /* Empieza nodo:80 / Elemento padre: 61   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(61)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(82)).setAttribute("src","b.gif" );
      ((Element)v.get(82)).setAttribute("width","8" );
      ((Element)v.get(82)).setAttribute("height","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */

      /* Empieza nodo:83 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(83)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(80)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(84)).setAttribute("nombre","cbMarca" );
      ((Element)v.get(84)).setAttribute("id","datosCampos" );
      ((Element)v.get(84)).setAttribute("size","1" );
      ((Element)v.get(84)).setAttribute("multiple","N" );
      ((Element)v.get(84)).setAttribute("req","S" );
      ((Element)v.get(84)).setAttribute("onchange","onChangeCbMarca();" );
      ((Element)v.get(84)).setAttribute("onshtab","focalizaMarcaShTab();" );
      ((Element)v.get(84)).setAttribute("valorinicial","" );
      ((Element)v.get(84)).setAttribute("textoinicial","" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(84)).appendChild((Element)v.get(85));
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:86 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(87)).setAttribute("src","b.gif" );
      ((Element)v.get(87)).setAttribute("width","25" );
      ((Element)v.get(87)).setAttribute("height","8" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:88 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(88)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(80)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(89)).setAttribute("nombre","cbCanal" );
      ((Element)v.get(89)).setAttribute("id","datosCampos" );
      ((Element)v.get(89)).setAttribute("size","1" );
      ((Element)v.get(89)).setAttribute("multiple","N" );
      ((Element)v.get(89)).setAttribute("req","S" );
      ((Element)v.get(89)).setAttribute("onchange","onChangeCbCanal();" );
      ((Element)v.get(89)).setAttribute("valorinicial","" );
      ((Element)v.get(89)).setAttribute("textoinicial","" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(89)).appendChild((Element)v.get(90));
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:91 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(80)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(92)).setAttribute("src","b.gif" );
      ((Element)v.get(92)).setAttribute("width","8" );
      ((Element)v.get(92)).setAttribute("height","8" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */

      /* Empieza nodo:93 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(93)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(80)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(94)).setAttribute("nombre","cbPeriodo" );
      ((Element)v.get(94)).setAttribute("id","datosCampos" );
      ((Element)v.get(94)).setAttribute("size","1" );
      ((Element)v.get(94)).setAttribute("multiple","N" );
      ((Element)v.get(94)).setAttribute("req","S" );
      ((Element)v.get(94)).setAttribute("onchange","" );
      ((Element)v.get(94)).setAttribute("valorinicial","" );
      ((Element)v.get(94)).setAttribute("textoinicial","" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:96 / Elemento padre: 80   */
      v.add(doc.createElement("td"));
      ((Element)v.get(96)).setAttribute("width","100%" );
      ((Element)v.get(80)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","8" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */
      /* Termina nodo:80   */

      /* Empieza nodo:98 / Elemento padre: 61   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(61)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("td"));
      ((Element)v.get(99)).setAttribute("colspan","7" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(100)).setAttribute("src","b.gif" );
      ((Element)v.get(100)).setAttribute("width","8" );
      ((Element)v.get(100)).setAttribute("height","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:101 / Elemento padre: 61   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(61)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("td"));
      ((Element)v.get(102)).setAttribute("colspan","7" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","8" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:104 / Elemento padre: 61   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(61)).appendChild((Element)v.get(104));

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
      ((Element)v.get(104)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(108)).setAttribute("nombre","lblSubgerenciaVentas" );
      ((Element)v.get(108)).setAttribute("alto","13" );
      ((Element)v.get(108)).setAttribute("filas","1" );
      ((Element)v.get(108)).setAttribute("valor","" );
      ((Element)v.get(108)).setAttribute("id","datosTitle" );
      ((Element)v.get(108)).setAttribute("cod","124" );
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
      ((Element)v.get(104)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(112)).setAttribute("nombre","lblRegion" );
      ((Element)v.get(112)).setAttribute("alto","13" );
      ((Element)v.get(112)).setAttribute("filas","1" );
      ((Element)v.get(112)).setAttribute("valor","" );
      ((Element)v.get(112)).setAttribute("id","datosTitle" );
      ((Element)v.get(112)).setAttribute("cod","109" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(104)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","8" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:115 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(115)).setAttribute("width","100%" );
      ((Element)v.get(104)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(116)).setAttribute("src","b.gif" );
      ((Element)v.get(116)).setAttribute("width","8" );
      ((Element)v.get(116)).setAttribute("height","8" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:117 / Elemento padre: 104   */
      v.add(doc.createElement("td"));
      ((Element)v.get(117)).setAttribute("width","100%" );
      ((Element)v.get(104)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(118)).setAttribute("src","b.gif" );
      ((Element)v.get(118)).setAttribute("width","8" );
      ((Element)v.get(118)).setAttribute("height","8" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:104   */

      /* Empieza nodo:119 / Elemento padre: 61   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(61)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","8" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(122)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(119)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(123)).setAttribute("nombre","cbSubgerenciaVentas" );
      ((Element)v.get(123)).setAttribute("id","datosCampos" );
      ((Element)v.get(123)).setAttribute("size","1" );
      ((Element)v.get(123)).setAttribute("multiple","N" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(123)).setAttribute("req","S" );
      ((Element)v.get(123)).setAttribute("valorinicial","" );
      ((Element)v.get(123)).setAttribute("textoinicial","" );
      ((Element)v.get(123)).setAttribute("onchange","onChangeCbSVG();" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:125 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","25" );
      ((Element)v.get(126)).setAttribute("height","8" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(127)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(119)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(128)).setAttribute("nombre","cbRegion" );
      ((Element)v.get(128)).setAttribute("id","datosCampos" );
      ((Element)v.get(128)).setAttribute("size","1" );
      ((Element)v.get(128)).setAttribute("multiple","N" );
      ((Element)v.get(128)).setAttribute("req","S" );
      ((Element)v.get(128)).setAttribute("valorinicial","" );
      ((Element)v.get(128)).setAttribute("textoinicial","" );
      ((Element)v.get(128)).setAttribute("onchange","onChangeCbRegion();" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:130 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(119)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(131)).setAttribute("src","b.gif" );
      ((Element)v.get(131)).setAttribute("width","8" );
      ((Element)v.get(131)).setAttribute("height","8" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(132)).setAttribute("width","100%" );
      ((Element)v.get(119)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","8" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 119   */
      v.add(doc.createElement("td"));
      ((Element)v.get(134)).setAttribute("width","100%" );
      ((Element)v.get(119)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","8" );
      ((Element)v.get(135)).setAttribute("height","8" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:119   */

      /* Empieza nodo:136 / Elemento padre: 61   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(61)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("td"));
      ((Element)v.get(137)).setAttribute("colspan","7" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","8" );
      ((Element)v.get(138)).setAttribute("height","8" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:139 / Elemento padre: 61   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(61)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("td"));
      ((Element)v.get(140)).setAttribute("colspan","7" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(141)).setAttribute("src","b.gif" );
      ((Element)v.get(141)).setAttribute("width","8" );
      ((Element)v.get(141)).setAttribute("height","8" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:142 / Elemento padre: 61   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(61)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","8" );
      ((Element)v.get(144)).setAttribute("height","8" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(146)).setAttribute("nombre","lblZona" );
      ((Element)v.get(146)).setAttribute("alto","13" );
      ((Element)v.get(146)).setAttribute("filas","1" );
      ((Element)v.get(146)).setAttribute("valor","" );
      ((Element)v.get(146)).setAttribute("id","datosTitle" );
      ((Element)v.get(146)).setAttribute("cod","143" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */

      /* Empieza nodo:147 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).setAttribute("width","25" );
      ((Element)v.get(148)).setAttribute("height","8" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:149 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(150)).setAttribute("nombre","lblSeccion" );
      ((Element)v.get(150)).setAttribute("alto","13" );
      ((Element)v.get(150)).setAttribute("filas","1" );
      ((Element)v.get(150)).setAttribute("valor","" );
      ((Element)v.get(150)).setAttribute("id","datosTitle" );
      ((Element)v.get(150)).setAttribute("cod","112" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(142)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).setAttribute("width","8" );
      ((Element)v.get(152)).setAttribute("height","8" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:153 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(153)).setAttribute("width","100%" );
      ((Element)v.get(142)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).setAttribute("width","8" );
      ((Element)v.get(154)).setAttribute("height","8" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 142   */
      v.add(doc.createElement("td"));
      ((Element)v.get(155)).setAttribute("width","100%" );
      ((Element)v.get(142)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","8" );
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:142   */

      /* Empieza nodo:157 / Elemento padre: 61   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(61)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","8" );
      ((Element)v.get(159)).setAttribute("height","8" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(160)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(157)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(161)).setAttribute("nombre","cbZona" );
      ((Element)v.get(161)).setAttribute("id","datosCampos" );
      ((Element)v.get(161)).setAttribute("size","1" );
      ((Element)v.get(161)).setAttribute("multiple","N" );
      ((Element)v.get(161)).setAttribute("req","S" );
      ((Element)v.get(161)).setAttribute("valorinicial","" );
      ((Element)v.get(161)).setAttribute("textoinicial","" );
      ((Element)v.get(161)).setAttribute("onchange","onChangeCbZona();" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:163 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(164)).setAttribute("width","25" );
      ((Element)v.get(164)).setAttribute("height","8" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:165 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(165)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(157)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(166)).setAttribute("nombre","cbSeccion" );
      ((Element)v.get(166)).setAttribute("id","datosCampos" );
      ((Element)v.get(166)).setAttribute("size","1" );
      ((Element)v.get(166)).setAttribute("multiple","N" );
      ((Element)v.get(166)).setAttribute("req","S" );
      ((Element)v.get(166)).setAttribute("valorinicial","" );
      ((Element)v.get(166)).setAttribute("textoinicial","" );
      ((Element)v.get(166)).setAttribute("onchange","onChangeCbSeccion();" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:168 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(157)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(169)).setAttribute("src","b.gif" );
      ((Element)v.get(169)).setAttribute("width","8" );
      ((Element)v.get(169)).setAttribute("height","8" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(170)).setAttribute("width","100%" );
      ((Element)v.get(157)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(171)).setAttribute("src","b.gif" );
      ((Element)v.get(171)).setAttribute("width","8" );
      ((Element)v.get(171)).setAttribute("height","8" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:172 / Elemento padre: 157   */
      v.add(doc.createElement("td"));
      ((Element)v.get(172)).setAttribute("width","100%" );
      ((Element)v.get(157)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(173)).setAttribute("src","b.gif" );
      ((Element)v.get(173)).setAttribute("width","8" );
      ((Element)v.get(173)).setAttribute("height","8" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */
      /* Termina nodo:157   */

      /* Empieza nodo:174 / Elemento padre: 61   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(61)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("td"));
      ((Element)v.get(175)).setAttribute("colspan","7" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(176)).setAttribute("src","b.gif" );
      ((Element)v.get(176)).setAttribute("width","8" );
      ((Element)v.get(176)).setAttribute("height","8" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:177 / Elemento padre: 61   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(61)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("td"));
      ((Element)v.get(178)).setAttribute("colspan","7" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).setAttribute("width","8" );
      ((Element)v.get(179)).setAttribute("height","8" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:180 / Elemento padre: 61   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(61)).appendChild((Element)v.get(180));

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
      ((Element)v.get(180)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(184)).setAttribute("nombre","lblTipoOperacion" );
      ((Element)v.get(184)).setAttribute("alto","13" );
      ((Element)v.get(184)).setAttribute("filas","1" );
      ((Element)v.get(184)).setAttribute("valor","" );
      ((Element)v.get(184)).setAttribute("id","datosTitle" );
      ((Element)v.get(184)).setAttribute("cod","3194" );
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
      ((Element)v.get(180)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(188)).setAttribute("nombre","lblTerrPartir" );
      ((Element)v.get(188)).setAttribute("alto","13" );
      ((Element)v.get(188)).setAttribute("filas","1" );
      ((Element)v.get(188)).setAttribute("valor","" );
      ((Element)v.get(188)).setAttribute("id","datosTitle" );
      ((Element)v.get(188)).setAttribute("cod","3195" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","8" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(180)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(192)).setAttribute("nombre","lblTerrOrigTrasv" );
      ((Element)v.get(192)).setAttribute("alto","13" );
      ((Element)v.get(192)).setAttribute("filas","1" );
      ((Element)v.get(192)).setAttribute("valor","" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(192)).setAttribute("id","datosTitle" );
      ((Element)v.get(192)).setAttribute("cod","3196" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:193 / Elemento padre: 180   */
      v.add(doc.createElement("td"));
      ((Element)v.get(193)).setAttribute("width","100%" );
      ((Element)v.get(180)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(194)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).setAttribute("width","8" );
      ((Element)v.get(194)).setAttribute("height","8" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:180   */

      /* Empieza nodo:195 / Elemento padre: 61   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(61)).appendChild((Element)v.get(195));

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
      ((Element)v.get(199)).setAttribute("nombre","cbTipoOperacion" );
      ((Element)v.get(199)).setAttribute("id","datosCampos" );
      ((Element)v.get(199)).setAttribute("size","1" );
      ((Element)v.get(199)).setAttribute("multiple","N" );
      ((Element)v.get(199)).setAttribute("req","S" );
      ((Element)v.get(199)).setAttribute("valorinicial","" );
      ((Element)v.get(199)).setAttribute("textoinicial","" );
      ((Element)v.get(199)).setAttribute("onchange","onChangeCbTipoOperacion();" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:201 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(202)).setAttribute("src","b.gif" );
      ((Element)v.get(202)).setAttribute("width","25" );
      ((Element)v.get(202)).setAttribute("height","8" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:203 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(203)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(195)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(204)).setAttribute("nombre","cbTerrPartir" );
      ((Element)v.get(204)).setAttribute("id","datosCampos" );
      ((Element)v.get(204)).setAttribute("size","1" );
      ((Element)v.get(204)).setAttribute("multiple","N" );
      ((Element)v.get(204)).setAttribute("req","N" );
      ((Element)v.get(204)).setAttribute("valorinicial","" );
      ((Element)v.get(204)).setAttribute("textoinicial","" );
      ((Element)v.get(204)).setAttribute("onchange","" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:206 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(195)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(207)).setAttribute("src","b.gif" );
      ((Element)v.get(207)).setAttribute("width","8" );
      ((Element)v.get(207)).setAttribute("height","8" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:208 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(208)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(195)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(209)).setAttribute("nombre","cbTerrOrigTrasv" );
      ((Element)v.get(209)).setAttribute("id","datosCampos" );
      ((Element)v.get(209)).setAttribute("size","1" );
      ((Element)v.get(209)).setAttribute("multiple","N" );
      ((Element)v.get(209)).setAttribute("req","N" );
      ((Element)v.get(209)).setAttribute("valorinicial","" );
      ((Element)v.get(209)).setAttribute("textoinicial","" );
      ((Element)v.get(209)).setAttribute("onchange","" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:211 / Elemento padre: 195   */
      v.add(doc.createElement("td"));
      ((Element)v.get(211)).setAttribute("width","100%" );
      ((Element)v.get(195)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(212)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).setAttribute("width","8" );
      ((Element)v.get(212)).setAttribute("height","8" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:195   */

      /* Empieza nodo:213 / Elemento padre: 61   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(61)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("td"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(214)).setAttribute("colspan","7" );
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
      /* Termina nodo:61   */
      /* Termina nodo:58   */

      /* Empieza nodo:216 / Elemento padre: 57   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(57)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("table"));
      ((Element)v.get(217)).setAttribute("width","100%" );
      ((Element)v.get(217)).setAttribute("border","0" );
      ((Element)v.get(217)).setAttribute("align","center" );
      ((Element)v.get(217)).setAttribute("cellspacing","0" );
      ((Element)v.get(217)).setAttribute("cellpadding","0" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("td"));
      ((Element)v.get(219)).setAttribute("class","botonera" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(220)).setAttribute("nombre","btnBuscar" );
      ((Element)v.get(220)).setAttribute("ID","botonContenido" );
      ((Element)v.get(220)).setAttribute("tipo","html" );
      ((Element)v.get(220)).setAttribute("accion","onClickBtnBuscar();" );
      ((Element)v.get(220)).setAttribute("estado","false" );
      ((Element)v.get(220)).setAttribute("cod","1" );
      ((Element)v.get(220)).setAttribute("ontab","focalizaBuscarTab();" );
      ((Element)v.get(220)).setAttribute("onshtab","focalizabuscarShTab();" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:217   */
      /* Termina nodo:216   */
      /* Termina nodo:57   */
      /* Termina nodo:54   */
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:221 / Elemento padre: 32   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(221)).setAttribute("nombre","capaParticion" );
      ((Element)v.get(221)).setAttribute("ancho","100%" );
      ((Element)v.get(221)).setAttribute("alto","100%" );
      ((Element)v.get(221)).setAttribute("x","0" );
      ((Element)v.get(221)).setAttribute("y","260" );
      ((Element)v.get(221)).setAttribute("colorf","" );
      ((Element)v.get(221)).setAttribute("borde","0" );
      ((Element)v.get(221)).setAttribute("imagenf","" );
      ((Element)v.get(221)).setAttribute("repeat","" );
      ((Element)v.get(221)).setAttribute("padding","" );
      ((Element)v.get(221)).setAttribute("visibilidad","" );
      ((Element)v.get(221)).setAttribute("contravsb","" );
      ((Element)v.get(221)).setAttribute("zindex","" );
      ((Element)v.get(32)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("table"));
      ((Element)v.get(222)).setAttribute("width","100%" );
      ((Element)v.get(222)).setAttribute("border","0" );
      ((Element)v.get(222)).setAttribute("cellspacing","0" );
      ((Element)v.get(222)).setAttribute("cellpadding","0" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(222)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(224)).setAttribute("width","12" );
      ((Element)v.get(224)).setAttribute("align","center" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(225)).setAttribute("src","b.gif" );
      ((Element)v.get(225)).setAttribute("width","12" );
      ((Element)v.get(225)).setAttribute("height","12" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:226 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(226)).setAttribute("width","750" );
      ((Element)v.get(223)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 223   */
      v.add(doc.createElement("td"));
      ((Element)v.get(228)).setAttribute("width","12" );
      ((Element)v.get(223)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(229)).setAttribute("src","b.gif" );
      ((Element)v.get(229)).setAttribute("width","12" );
      ((Element)v.get(229)).setAttribute("height","1" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */
      /* Termina nodo:223   */

      /* Empieza nodo:230 / Elemento padre: 222   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(222)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("td"));
      ((Element)v.get(230)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(232)).setAttribute("src","b.gif" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */

      /* Empieza nodo:233 / Elemento padre: 230   */
      v.add(doc.createElement("td"));
      ((Element)v.get(230)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(235)).setAttribute("class","legend" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(236)).setAttribute("nombre","lblParticion" );
      ((Element)v.get(236)).setAttribute("alto","13" );
      ((Element)v.get(236)).setAttribute("filas","1" );
      ((Element)v.get(236)).setAttribute("cod","3197" );
      ((Element)v.get(236)).setAttribute("id","legend" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:237 / Elemento padre: 234   */
      v.add(doc.createElement("table"));
      ((Element)v.get(237)).setAttribute("width","100%" );
      ((Element)v.get(237)).setAttribute("border","0" );
      ((Element)v.get(237)).setAttribute("align","center" );
      ((Element)v.get(237)).setAttribute("cellspacing","0" );
      ((Element)v.get(237)).setAttribute("cellpadding","0" );
      ((Element)v.get(234)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(237)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("td"));
      ((Element)v.get(239)).setAttribute("colspan","5" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(240)).setAttribute("src","b.gif" );
      ((Element)v.get(240)).setAttribute("width","8" );
      ((Element)v.get(240)).setAttribute("height","8" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:241 / Elemento padre: 237   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(237)).appendChild((Element)v.get(241));

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
      ((Element)v.get(245)).setAttribute("nombre","lblTerrCrear" );
      ((Element)v.get(245)).setAttribute("alto","13" );
      ((Element)v.get(245)).setAttribute("filas","1" );
      ((Element)v.get(245)).setAttribute("valor","" );
      ((Element)v.get(245)).setAttribute("id","datosTitle" );
      ((Element)v.get(245)).setAttribute("cod","3199" );
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
      ((Element)v.get(249)).setAttribute("nombre","lblConsultoras" );
      ((Element)v.get(249)).setAttribute("alto","13" );
      ((Element)v.get(249)).setAttribute("filas","1" );
      ((Element)v.get(249)).setAttribute("valor","" );
      ((Element)v.get(249)).setAttribute("id","datosTitle" );
      ((Element)v.get(249)).setAttribute("cod","00401" );
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
      ((Element)v.get(251)).setAttribute("width","8" );
      ((Element)v.get(251)).setAttribute("height","8" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */
      /* Termina nodo:241   */

      /* Empieza nodo:252 / Elemento padre: 237   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(237)).appendChild((Element)v.get(252));

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
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(256)).setAttribute("nombre","txtTerrCrear" );
      ((Element)v.get(256)).setAttribute("id","datosCampos" );
      ((Element)v.get(256)).setAttribute("max","6" );
      ((Element)v.get(256)).setAttribute("tipo","" );
      ((Element)v.get(256)).setAttribute("onchange","" );
      ((Element)v.get(256)).setAttribute("req","S" );
      ((Element)v.get(256)).setAttribute("size","10" );
      ((Element)v.get(256)).setAttribute("valor","" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(256)).setAttribute("validacion","" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:257 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(252)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(258)).setAttribute("src","b.gif" );
      ((Element)v.get(258)).setAttribute("width","25" );
      ((Element)v.get(258)).setAttribute("height","8" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:259 / Elemento padre: 252   */
      v.add(doc.createElement("td"));
      ((Element)v.get(259)).setAttribute("rowspan","12" );
      ((Element)v.get(259)).setAttribute("width","100%" );
      ((Element)v.get(252)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(260)).setAttribute("nombre","cbConsultorasPart" );
      ((Element)v.get(260)).setAttribute("id","datosCampos" );
      ((Element)v.get(260)).setAttribute("size","16" );
      ((Element)v.get(260)).setAttribute("multiple","S" );
      ((Element)v.get(260)).setAttribute("req","S" );
      ((Element)v.get(260)).setAttribute("onchange","" );
      ((Element)v.get(260)).setAttribute("valorinicial","" );
      ((Element)v.get(260)).setAttribute("textoinicial","" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */
      /* Termina nodo:259   */

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

      /* Empieza nodo:264 / Elemento padre: 237   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(237)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("td"));
      ((Element)v.get(265)).setAttribute("colspan","5" );
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

      /* Empieza nodo:267 / Elemento padre: 237   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(237)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("td"));
      ((Element)v.get(268)).setAttribute("colspan","5" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(269)).setAttribute("src","b.gif" );
      ((Element)v.get(269)).setAttribute("width","8" );
      ((Element)v.get(269)).setAttribute("height","8" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */
      /* Termina nodo:267   */

      /* Empieza nodo:270 / Elemento padre: 237   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(237)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(270)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(272)).setAttribute("src","b.gif" );
      ((Element)v.get(272)).setAttribute("width","8" );
      ((Element)v.get(272)).setAttribute("height","8" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:271   */

      /* Empieza nodo:273 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(270)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(274)).setAttribute("nombre","lblNSE1" );
      ((Element)v.get(274)).setAttribute("alto","13" );
      ((Element)v.get(274)).setAttribute("filas","1" );
      ((Element)v.get(274)).setAttribute("valor","" );
      ((Element)v.get(274)).setAttribute("id","datosTitle" );
      ((Element)v.get(274)).setAttribute("cod","3200" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */

      /* Empieza nodo:275 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(270)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(276)).setAttribute("src","b.gif" );
      ((Element)v.get(276)).setAttribute("width","25" );
      ((Element)v.get(276)).setAttribute("height","8" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:277 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(277)).setAttribute("width","100%" );
      ((Element)v.get(270)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(278)).setAttribute("src","b.gif" );
      ((Element)v.get(278)).setAttribute("width","8" );
      ((Element)v.get(278)).setAttribute("height","8" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:279 / Elemento padre: 270   */
      v.add(doc.createElement("td"));
      ((Element)v.get(279)).setAttribute("width","100%" );
      ((Element)v.get(270)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
   }

   private void getXML1170(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(280)).setAttribute("src","b.gif" );
      ((Element)v.get(280)).setAttribute("width","8" );
      ((Element)v.get(280)).setAttribute("height","8" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */
      /* Termina nodo:270   */

      /* Empieza nodo:281 / Elemento padre: 237   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(237)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(281)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(283)).setAttribute("src","b.gif" );
      ((Element)v.get(283)).setAttribute("width","8" );
      ((Element)v.get(283)).setAttribute("height","8" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:284 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(284)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(281)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(285)).setAttribute("nombre","cbNSE1" );
      ((Element)v.get(285)).setAttribute("id","datosCampos" );
      ((Element)v.get(285)).setAttribute("size","1" );
      ((Element)v.get(285)).setAttribute("multiple","N" );
      ((Element)v.get(285)).setAttribute("req","S" );
      ((Element)v.get(285)).setAttribute("valorinicial","" );
      ((Element)v.get(285)).setAttribute("textoinicial","" );
      ((Element)v.get(285)).setAttribute("onchange","" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:285   */
      /* Termina nodo:284   */

      /* Empieza nodo:287 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(281)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(288)).setAttribute("src","b.gif" );
      ((Element)v.get(288)).setAttribute("width","25" );
      ((Element)v.get(288)).setAttribute("height","8" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:287   */

      /* Empieza nodo:289 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(289)).setAttribute("width","100%" );
      ((Element)v.get(281)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(290)).setAttribute("src","b.gif" );
      ((Element)v.get(290)).setAttribute("width","8" );
      ((Element)v.get(290)).setAttribute("height","8" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */
      /* Termina nodo:289   */

      /* Empieza nodo:291 / Elemento padre: 281   */
      v.add(doc.createElement("td"));
      ((Element)v.get(291)).setAttribute("width","100%" );
      ((Element)v.get(281)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(292)).setAttribute("src","b.gif" );
      ((Element)v.get(292)).setAttribute("width","8" );
      ((Element)v.get(292)).setAttribute("height","8" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:291   */
      /* Termina nodo:281   */

      /* Empieza nodo:293 / Elemento padre: 237   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(237)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("td"));
      ((Element)v.get(294)).setAttribute("colspan","5" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(295)).setAttribute("src","b.gif" );
      ((Element)v.get(295)).setAttribute("width","8" );
      ((Element)v.get(295)).setAttribute("height","8" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */
      /* Termina nodo:293   */

      /* Empieza nodo:296 / Elemento padre: 237   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(237)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("td"));
      ((Element)v.get(297)).setAttribute("colspan","5" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(298)).setAttribute("src","b.gif" );
      ((Element)v.get(298)).setAttribute("width","8" );
      ((Element)v.get(298)).setAttribute("height","8" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */
      /* Termina nodo:296   */

      /* Empieza nodo:299 / Elemento padre: 237   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(237)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("td"));
      ((Element)v.get(299)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(301)).setAttribute("src","b.gif" );
      ((Element)v.get(301)).setAttribute("width","8" );
      ((Element)v.get(301)).setAttribute("height","8" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:300   */

      /* Empieza nodo:302 / Elemento padre: 299   */
      v.add(doc.createElement("td"));
      ((Element)v.get(299)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(303)).setAttribute("nombre","lblNSE2" );
      ((Element)v.get(303)).setAttribute("alto","13" );
      ((Element)v.get(303)).setAttribute("filas","1" );
      ((Element)v.get(303)).setAttribute("valor","" );
      ((Element)v.get(303)).setAttribute("id","datosTitle" );
      ((Element)v.get(303)).setAttribute("cod","3201" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:302   */

      /* Empieza nodo:304 / Elemento padre: 299   */
      v.add(doc.createElement("td"));
      ((Element)v.get(299)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(305)).setAttribute("src","b.gif" );
      ((Element)v.get(305)).setAttribute("width","25" );
      ((Element)v.get(305)).setAttribute("height","8" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:304   */

      /* Empieza nodo:306 / Elemento padre: 299   */
      v.add(doc.createElement("td"));
      ((Element)v.get(306)).setAttribute("width","100%" );
      ((Element)v.get(299)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(307)).setAttribute("src","b.gif" );
      ((Element)v.get(307)).setAttribute("width","8" );
      ((Element)v.get(307)).setAttribute("height","8" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:306   */

      /* Empieza nodo:308 / Elemento padre: 299   */
      v.add(doc.createElement("td"));
      ((Element)v.get(308)).setAttribute("width","100%" );
      ((Element)v.get(299)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(309)).setAttribute("src","b.gif" );
      ((Element)v.get(309)).setAttribute("width","8" );
      ((Element)v.get(309)).setAttribute("height","8" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */
      /* Termina nodo:299   */

      /* Empieza nodo:310 / Elemento padre: 237   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(237)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(312)).setAttribute("src","b.gif" );
      ((Element)v.get(312)).setAttribute("width","8" );
      ((Element)v.get(312)).setAttribute("height","8" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */

      /* Empieza nodo:313 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(313)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(310)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(314)).setAttribute("nombre","cbNSE2" );
      ((Element)v.get(314)).setAttribute("id","datosCampos" );
      ((Element)v.get(314)).setAttribute("size","1" );
      ((Element)v.get(314)).setAttribute("multiple","N" );
      ((Element)v.get(314)).setAttribute("req","S" );
      ((Element)v.get(314)).setAttribute("valorinicial","" );
      ((Element)v.get(314)).setAttribute("textoinicial","" );
      ((Element)v.get(314)).setAttribute("onchange","" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:314   */
      /* Termina nodo:313   */

      /* Empieza nodo:316 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(310)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(317)).setAttribute("src","b.gif" );
      ((Element)v.get(317)).setAttribute("width","25" );
      ((Element)v.get(317)).setAttribute("height","8" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:316   */

      /* Empieza nodo:318 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(318)).setAttribute("width","100%" );
      ((Element)v.get(310)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(319)).setAttribute("src","b.gif" );
      ((Element)v.get(319)).setAttribute("width","8" );
      ((Element)v.get(319)).setAttribute("height","8" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */
      /* Termina nodo:318   */

      /* Empieza nodo:320 / Elemento padre: 310   */
      v.add(doc.createElement("td"));
      ((Element)v.get(320)).setAttribute("width","100%" );
      ((Element)v.get(310)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(321)).setAttribute("src","b.gif" );
      ((Element)v.get(321)).setAttribute("width","8" );
      ((Element)v.get(321)).setAttribute("height","8" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:320   */
      /* Termina nodo:310   */

      /* Empieza nodo:322 / Elemento padre: 237   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(237)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("td"));
      ((Element)v.get(323)).setAttribute("colspan","5" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(324)).setAttribute("src","b.gif" );
      ((Element)v.get(324)).setAttribute("width","8" );
      ((Element)v.get(324)).setAttribute("height","8" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */
      /* Termina nodo:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:325 / Elemento padre: 237   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(237)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("td"));
      ((Element)v.get(326)).setAttribute("colspan","5" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(327)).setAttribute("src","b.gif" );
      ((Element)v.get(327)).setAttribute("width","8" );
      ((Element)v.get(327)).setAttribute("height","8" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:326   */
      /* Termina nodo:325   */

      /* Empieza nodo:328 / Elemento padre: 237   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(237)).appendChild((Element)v.get(328));

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
      ((Element)v.get(328)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(332)).setAttribute("nombre","btnAniadirPart" );
      ((Element)v.get(332)).setAttribute("ID","botonContenido" );
      ((Element)v.get(332)).setAttribute("tipo","html" );
      ((Element)v.get(332)).setAttribute("accion","onClickBtnAniadirPart();" );
      ((Element)v.get(332)).setAttribute("estado","false" );
      ((Element)v.get(332)).setAttribute("cod","404" );
      ((Element)v.get(332)).setAttribute("ontab","focalizaTab('P');" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:331   */

      /* Empieza nodo:333 / Elemento padre: 328   */
      v.add(doc.createElement("td"));
      ((Element)v.get(328)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(334)).setAttribute("src","b.gif" );
      ((Element)v.get(334)).setAttribute("width","25" );
      ((Element)v.get(334)).setAttribute("height","8" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:335 / Elemento padre: 328   */
      v.add(doc.createElement("td"));
      ((Element)v.get(335)).setAttribute("width","100%" );
      ((Element)v.get(328)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(336)).setAttribute("src","b.gif" );
      ((Element)v.get(336)).setAttribute("width","8" );
      ((Element)v.get(336)).setAttribute("height","8" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 328   */
      v.add(doc.createElement("td"));
      ((Element)v.get(337)).setAttribute("width","100%" );
      ((Element)v.get(328)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(338)).setAttribute("src","b.gif" );
      ((Element)v.get(338)).setAttribute("width","8" );
      ((Element)v.get(338)).setAttribute("height","8" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */
      /* Termina nodo:328   */

      /* Empieza nodo:339 / Elemento padre: 237   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(237)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("td"));
      ((Element)v.get(340)).setAttribute("colspan","5" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(341)).setAttribute("src","b.gif" );
      ((Element)v.get(341)).setAttribute("width","8" );
      ((Element)v.get(341)).setAttribute("height","8" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */
      /* Termina nodo:340   */
      /* Termina nodo:339   */
      /* Termina nodo:237   */
      /* Termina nodo:234   */
      /* Termina nodo:233   */
      /* Termina nodo:230   */
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:342 / Elemento padre: 32   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(342)).setAttribute("nombre","capaLista1" );
      ((Element)v.get(342)).setAttribute("ancho","100%" );
      ((Element)v.get(342)).setAttribute("alto","330" );
      ((Element)v.get(342)).setAttribute("x","7" );
      ((Element)v.get(342)).setAttribute("y","530" );
      ((Element)v.get(342)).setAttribute("colorf","" );
      ((Element)v.get(342)).setAttribute("borde","0" );
      ((Element)v.get(342)).setAttribute("imagenf","" );
      ((Element)v.get(342)).setAttribute("repeat","" );
      ((Element)v.get(342)).setAttribute("padding","" );
      ((Element)v.get(342)).setAttribute("visibilidad","" );
      ((Element)v.get(342)).setAttribute("contravsb","" );
      ((Element)v.get(342)).setAttribute("zindex","" );
      ((Element)v.get(32)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(343)).setAttribute("nombre","listado1" );
      ((Element)v.get(343)).setAttribute("ancho","369" );
      ((Element)v.get(343)).setAttribute("alto","301" );
      ((Element)v.get(343)).setAttribute("x","12" );
      ((Element)v.get(343)).setAttribute("y","0" );
      ((Element)v.get(343)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(343)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(343)).setAttribute("pintadoSimplificado","S" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(344)).setAttribute("precarga","S" );
      ((Element)v.get(344)).setAttribute("conROver","S" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(345)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(345)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(345)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(345)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */

      /* Empieza nodo:346 / Elemento padre: 344   */
      v.add(doc.createElement("BTNMINIMIZAR"));
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(346)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(346)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(346)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(346)).setAttribute("aximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(344)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */

      /* Empieza nodo:347 / Elemento padre: 344   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(347)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(347)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(344)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */
      /* Termina nodo:344   */

      /* Empieza nodo:348 / Elemento padre: 343   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(343)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(349)).setAttribute("borde","1" );
      ((Element)v.get(349)).setAttribute("horizDatos","1" );
      ((Element)v.get(349)).setAttribute("horizCabecera","1" );
      ((Element)v.get(349)).setAttribute("vertical","1" );
      ((Element)v.get(349)).setAttribute("horizTitulo","1" );
      ((Element)v.get(349)).setAttribute("horizBase","1" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */

      /* Empieza nodo:350 / Elemento padre: 348   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(350)).setAttribute("borde","#999999" );
      ((Element)v.get(350)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(350)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(350)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(350)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(350)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(350)).setAttribute("horizBase","#999999" );
      ((Element)v.get(348)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:348   */

      /* Empieza nodo:351 / Elemento padre: 343   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(351)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(351)).setAttribute("alto","22" );
      ((Element)v.get(351)).setAttribute("imgFondo","" );
      ((Element)v.get(351)).setAttribute("cod","0073" );
      ((Element)v.get(351)).setAttribute("ID","datosTitle" );
      ((Element)v.get(343)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */

      /* Empieza nodo:352 / Elemento padre: 343   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(352)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(352)).setAttribute("alto","22" );
      ((Element)v.get(352)).setAttribute("imgFondo","" );
      ((Element)v.get(343)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */

      /* Empieza nodo:353 / Elemento padre: 343   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(353)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(353)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(353)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(353)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(353)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(353)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(343)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(354)).setAttribute("ancho","50" );
      ((Element)v.get(354)).setAttribute("minimizable","S" );
      ((Element)v.get(354)).setAttribute("minimizada","N" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */

      /* Empieza nodo:355 / Elemento padre: 353   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(355)).setAttribute("ancho","50" );
      ((Element)v.get(355)).setAttribute("minimizable","S" );
      ((Element)v.get(355)).setAttribute("minimizada","N" );
      ((Element)v.get(353)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */

      /* Empieza nodo:356 / Elemento padre: 353   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(356)).setAttribute("ancho","50" );
      ((Element)v.get(356)).setAttribute("minimizable","S" );
      ((Element)v.get(356)).setAttribute("minimizada","N" );
      ((Element)v.get(353)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */

      /* Empieza nodo:357 / Elemento padre: 353   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(357)).setAttribute("ancho","50" );
      ((Element)v.get(357)).setAttribute("minimizable","S" );
      ((Element)v.get(357)).setAttribute("minimizada","N" );
      ((Element)v.get(353)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */

      /* Empieza nodo:358 / Elemento padre: 353   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(358)).setAttribute("ancho","50" );
      ((Element)v.get(358)).setAttribute("minimizable","S" );
      ((Element)v.get(358)).setAttribute("minimizada","N" );
      ((Element)v.get(358)).setAttribute("oculta","S" );
      ((Element)v.get(353)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */

      /* Empieza nodo:359 / Elemento padre: 353   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(359)).setAttribute("ancho","50" );
      ((Element)v.get(359)).setAttribute("minimizable","S" );
      ((Element)v.get(359)).setAttribute("minimizada","N" );
      ((Element)v.get(359)).setAttribute("oculta","S" );
      ((Element)v.get(353)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */

      /* Empieza nodo:360 / Elemento padre: 353   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(360)).setAttribute("ancho","50" );
      ((Element)v.get(360)).setAttribute("minimizable","S" );
      ((Element)v.get(360)).setAttribute("minimizada","N" );
      ((Element)v.get(360)).setAttribute("oculta","S" );
      ((Element)v.get(353)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:353   */

      /* Empieza nodo:361 / Elemento padre: 343   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(361)).setAttribute("alto","25" );
      ((Element)v.get(361)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(361)).setAttribute("imgFondo","" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(361)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(343)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(362)).setAttribute("colFondo","" );
      ((Element)v.get(362)).setAttribute("ID","EstCab" );
      ((Element)v.get(362)).setAttribute("cod","3202" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));

      /* Elemento padre:362 / Elemento actual: 363   */
      v.add(doc.createTextNode("Territorio Asignar"));
      ((Element)v.get(362)).appendChild((Text)v.get(363));

      /* Termina nodo Texto:363   */
      /* Termina nodo:362   */

      /* Empieza nodo:364 / Elemento padre: 361   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(364)).setAttribute("colFondo","" );
      ((Element)v.get(364)).setAttribute("ID","EstCab" );
      ((Element)v.get(364)).setAttribute("cod","3200" );
      ((Element)v.get(361)).appendChild((Element)v.get(364));

      /* Elemento padre:364 / Elemento actual: 365   */
      v.add(doc.createTextNode("NSE1"));
      ((Element)v.get(364)).appendChild((Text)v.get(365));

      /* Termina nodo Texto:365   */
      /* Termina nodo:364   */

      /* Empieza nodo:366 / Elemento padre: 361   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(366)).setAttribute("colFondo","" );
      ((Element)v.get(366)).setAttribute("ID","EstCab" );
      ((Element)v.get(366)).setAttribute("cod","3201" );
      ((Element)v.get(361)).appendChild((Element)v.get(366));

      /* Elemento padre:366 / Elemento actual: 367   */
      v.add(doc.createTextNode("NSE2"));
      ((Element)v.get(366)).appendChild((Text)v.get(367));

      /* Termina nodo Texto:367   */
      /* Termina nodo:366   */

      /* Empieza nodo:368 / Elemento padre: 361   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(368)).setAttribute("colFondo","" );
      ((Element)v.get(368)).setAttribute("ID","EstCab" );
      ((Element)v.get(368)).setAttribute("cod","263" );
      ((Element)v.get(361)).appendChild((Element)v.get(368));

      /* Elemento padre:368 / Elemento actual: 369   */
      v.add(doc.createTextNode("Cod cliente"));
      ((Element)v.get(368)).appendChild((Text)v.get(369));

      /* Termina nodo Texto:369   */
      /* Termina nodo:368   */

      /* Empieza nodo:370 / Elemento padre: 361   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(370)).setAttribute("colFondo","" );
      ((Element)v.get(370)).setAttribute("ID","EstCab" );
      ((Element)v.get(370)).setAttribute("cod","263" );
      ((Element)v.get(361)).appendChild((Element)v.get(370));

      /* Elemento padre:370 / Elemento actual: 371   */
      v.add(doc.createTextNode("Oid Cliente"));
      ((Element)v.get(370)).appendChild((Text)v.get(371));

      /* Termina nodo Texto:371   */
      /* Termina nodo:370   */

      /* Empieza nodo:372 / Elemento padre: 361   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(372)).setAttribute("colFondo","" );
      ((Element)v.get(372)).setAttribute("ID","EstCab" );
      ((Element)v.get(372)).setAttribute("cod","263" );
      ((Element)v.get(361)).appendChild((Element)v.get(372));

      /* Elemento padre:372 / Elemento actual: 373   */
      v.add(doc.createTextNode("Cod NSE1"));
      ((Element)v.get(372)).appendChild((Text)v.get(373));

      /* Termina nodo Texto:373   */
      /* Termina nodo:372   */

      /* Empieza nodo:374 / Elemento padre: 361   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(374)).setAttribute("colFondo","" );
      ((Element)v.get(374)).setAttribute("ID","EstCab" );
      ((Element)v.get(374)).setAttribute("cod","263" );
      ((Element)v.get(361)).appendChild((Element)v.get(374));

      /* Elemento padre:374 / Elemento actual: 375   */
      v.add(doc.createTextNode("Cod NSE2"));
      ((Element)v.get(374)).appendChild((Text)v.get(375));

      /* Termina nodo Texto:375   */
      /* Termina nodo:374   */
      /* Termina nodo:361   */

      /* Empieza nodo:376 / Elemento padre: 343   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(376)).setAttribute("alto","22" );
      ((Element)v.get(376)).setAttribute("accion","" );
      ((Element)v.get(376)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(376)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(376)).setAttribute("maxSel","1" );
      ((Element)v.get(376)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(376)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(376)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(376)).setAttribute("onLoad","" );
      ((Element)v.get(376)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(376)).setAttribute("primerRefresco","N" );
      ((Element)v.get(343)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(377)).setAttribute("tipo","texto" );
      ((Element)v.get(377)).setAttribute("ID","EstDat" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */

      /* Empieza nodo:378 / Elemento padre: 376   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(378)).setAttribute("tipo","texto" );
      ((Element)v.get(378)).setAttribute("ID","EstDat" );
      ((Element)v.get(376)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */

      /* Empieza nodo:379 / Elemento padre: 376   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(379)).setAttribute("tipo","texto" );
      ((Element)v.get(379)).setAttribute("ID","EstDat" );
      ((Element)v.get(376)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */

      /* Empieza nodo:380 / Elemento padre: 376   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(380)).setAttribute("tipo","texto" );
      ((Element)v.get(380)).setAttribute("ID","EstDat" );
      ((Element)v.get(376)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */

      /* Empieza nodo:381 / Elemento padre: 376   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(381)).setAttribute("tipo","texto" );
      ((Element)v.get(381)).setAttribute("ID","EstDat" );
      ((Element)v.get(376)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */

      /* Empieza nodo:382 / Elemento padre: 376   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(382)).setAttribute("tipo","texto" );
      ((Element)v.get(382)).setAttribute("ID","EstDat" );
      ((Element)v.get(376)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */

      /* Empieza nodo:383 / Elemento padre: 376   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(383)).setAttribute("tipo","texto" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(383)).setAttribute("ID","EstDat" );
      ((Element)v.get(376)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */
      /* Termina nodo:376   */

      /* Empieza nodo:384 / Elemento padre: 343   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(343)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */

      /* Empieza nodo:385 / Elemento padre: 343   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(385)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(385)).setAttribute("ancho","679" );
      ((Element)v.get(385)).setAttribute("sep","$" );
      ((Element)v.get(385)).setAttribute("x","12" );
      ((Element)v.get(385)).setAttribute("class","botonera" );
      ((Element)v.get(385)).setAttribute("y","294" );
      ((Element)v.get(385)).setAttribute("control","|" );
      ((Element)v.get(385)).setAttribute("conector","ConectorBuscarCargosAbonos" );
      ((Element)v.get(385)).setAttribute("rowset","" );
      ((Element)v.get(385)).setAttribute("cargainicial","N" );
      ((Element)v.get(385)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(343)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(386)).setAttribute("nombre","ret" );
      ((Element)v.get(386)).setAttribute("x","37" );
      ((Element)v.get(386)).setAttribute("y","282" );
      ((Element)v.get(386)).setAttribute("ID","botonContenido" );
      ((Element)v.get(386)).setAttribute("img","retroceder_on" );
      ((Element)v.get(386)).setAttribute("tipo","0" );
      ((Element)v.get(386)).setAttribute("estado","false" );
      ((Element)v.get(386)).setAttribute("alt","" );
      ((Element)v.get(386)).setAttribute("codigo","" );
      ((Element)v.get(386)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));
      /* Termina nodo:386   */

      /* Empieza nodo:387 / Elemento padre: 385   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(387)).setAttribute("nombre","ava" );
      ((Element)v.get(387)).setAttribute("x","52" );
      ((Element)v.get(387)).setAttribute("y","282" );
      ((Element)v.get(387)).setAttribute("ID","botonContenido" );
      ((Element)v.get(387)).setAttribute("img","avanzar_on" );
      ((Element)v.get(387)).setAttribute("tipo","0" );
      ((Element)v.get(387)).setAttribute("estado","false" );
      ((Element)v.get(387)).setAttribute("alt","" );
      ((Element)v.get(387)).setAttribute("codigo","" );
      ((Element)v.get(387)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(385)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */
      /* Termina nodo:385   */
      /* Termina nodo:343   */

      /* Empieza nodo:388 / Elemento padre: 342   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(388)).setAttribute("nombre","primera" );
      ((Element)v.get(388)).setAttribute("x","20" );
      ((Element)v.get(388)).setAttribute("y","282" );
      ((Element)v.get(388)).setAttribute("ID","botonContenido" );
      ((Element)v.get(388)).setAttribute("img","primera_on" );
      ((Element)v.get(388)).setAttribute("tipo","-2" );
      ((Element)v.get(388)).setAttribute("estado","false" );
      ((Element)v.get(388)).setAttribute("alt","" );
      ((Element)v.get(388)).setAttribute("codigo","" );
      ((Element)v.get(388)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(342)).appendChild((Element)v.get(388));
      /* Termina nodo:388   */

      /* Empieza nodo:389 / Elemento padre: 342   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(389)).setAttribute("nombre","separa" );
      ((Element)v.get(389)).setAttribute("x","59" );
      ((Element)v.get(389)).setAttribute("y","278" );
      ((Element)v.get(389)).setAttribute("ID","botonContenido" );
      ((Element)v.get(389)).setAttribute("img","separa_base" );
      ((Element)v.get(389)).setAttribute("tipo","0" );
      ((Element)v.get(389)).setAttribute("estado","false" );
      ((Element)v.get(389)).setAttribute("alt","" );
      ((Element)v.get(389)).setAttribute("codigo","" );
      ((Element)v.get(389)).setAttribute("accion","" );
      ((Element)v.get(342)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */

      /* Empieza nodo:390 / Elemento padre: 342   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(390)).setAttribute("nombre","EliminarPart" );
      ((Element)v.get(390)).setAttribute("x","10" );
      ((Element)v.get(390)).setAttribute("y","279" );
      ((Element)v.get(390)).setAttribute("ID","botonContenido" );
      ((Element)v.get(390)).setAttribute("tipo","html" );
      ((Element)v.get(390)).setAttribute("estado","false" );
      ((Element)v.get(390)).setAttribute("cod","1254" );
      ((Element)v.get(390)).setAttribute("accion","onClickEliminarPart();" );
      ((Element)v.get(390)).setAttribute("onshtab","focalizaEliminarShTab('P');" );
      ((Element)v.get(342)).appendChild((Element)v.get(390));
      /* Termina nodo:390   */

      /* Empieza nodo:391 / Elemento padre: 342   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(391)).setAttribute("nombre","ProcesarPart" );
      ((Element)v.get(391)).setAttribute("x","65" );
      ((Element)v.get(391)).setAttribute("y","279" );
      ((Element)v.get(391)).setAttribute("ID","botonContenido" );
      ((Element)v.get(391)).setAttribute("tipo","html" );
      ((Element)v.get(391)).setAttribute("estado","false" );
      ((Element)v.get(391)).setAttribute("cod","3055" );
      ((Element)v.get(391)).setAttribute("accion","fGuardar();" );
      ((Element)v.get(391)).setAttribute("ontab","focalizaProcesarTab();" );
      ((Element)v.get(342)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */
      /* Termina nodo:342   */

      /* Empieza nodo:392 / Elemento padre: 32   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(392)).setAttribute("nombre","capaTrasvase" );
      ((Element)v.get(392)).setAttribute("ancho","100%" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(392)).setAttribute("alto","100%" );
      ((Element)v.get(392)).setAttribute("x","0" );
      ((Element)v.get(392)).setAttribute("y","260" );
      ((Element)v.get(392)).setAttribute("colorf","" );
      ((Element)v.get(392)).setAttribute("borde","0" );
      ((Element)v.get(392)).setAttribute("imagenf","" );
      ((Element)v.get(392)).setAttribute("repeat","" );
      ((Element)v.get(392)).setAttribute("padding","" );
      ((Element)v.get(392)).setAttribute("visibilidad","" );
      ((Element)v.get(392)).setAttribute("contravsb","" );
      ((Element)v.get(392)).setAttribute("zindex","" );
      ((Element)v.get(32)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("table"));
      ((Element)v.get(393)).setAttribute("width","100%" );
      ((Element)v.get(393)).setAttribute("border","0" );
      ((Element)v.get(393)).setAttribute("cellspacing","0" );
      ((Element)v.get(393)).setAttribute("cellpadding","0" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(393)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("td"));
      ((Element)v.get(395)).setAttribute("width","12" );
      ((Element)v.get(395)).setAttribute("align","center" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(396)).setAttribute("src","b.gif" );
      ((Element)v.get(396)).setAttribute("width","12" );
      ((Element)v.get(396)).setAttribute("height","12" );
      ((Element)v.get(395)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */
      /* Termina nodo:395   */

      /* Empieza nodo:397 / Elemento padre: 394   */
      v.add(doc.createElement("td"));
      ((Element)v.get(397)).setAttribute("width","750" );
      ((Element)v.get(394)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(398)).setAttribute("src","b.gif" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */
      /* Termina nodo:397   */

      /* Empieza nodo:399 / Elemento padre: 394   */
      v.add(doc.createElement("td"));
      ((Element)v.get(399)).setAttribute("width","12" );
      ((Element)v.get(394)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(400)).setAttribute("src","b.gif" );
      ((Element)v.get(400)).setAttribute("width","12" );
      ((Element)v.get(400)).setAttribute("height","1" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));
      /* Termina nodo:400   */
      /* Termina nodo:399   */
      /* Termina nodo:394   */

      /* Empieza nodo:401 / Elemento padre: 393   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(393)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("td"));
      ((Element)v.get(401)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(403)).setAttribute("src","b.gif" );
      ((Element)v.get(402)).appendChild((Element)v.get(403));
      /* Termina nodo:403   */
      /* Termina nodo:402   */

      /* Empieza nodo:404 / Elemento padre: 401   */
      v.add(doc.createElement("td"));
      ((Element)v.get(401)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(404)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(406)).setAttribute("class","legend" );
      ((Element)v.get(405)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(407)).setAttribute("nombre","lblTrasvase" );
      ((Element)v.get(407)).setAttribute("alto","13" );
      ((Element)v.get(407)).setAttribute("filas","1" );
      ((Element)v.get(407)).setAttribute("cod","3198" );
      ((Element)v.get(407)).setAttribute("id","legend" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */
      /* Termina nodo:406   */

      /* Empieza nodo:408 / Elemento padre: 405   */
      v.add(doc.createElement("table"));
      ((Element)v.get(408)).setAttribute("width","100%" );
      ((Element)v.get(408)).setAttribute("border","0" );
      ((Element)v.get(408)).setAttribute("align","center" );
      ((Element)v.get(408)).setAttribute("cellspacing","0" );
      ((Element)v.get(408)).setAttribute("cellpadding","0" );
      ((Element)v.get(405)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(408)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("td"));
      ((Element)v.get(410)).setAttribute("colspan","5" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(411)).setAttribute("src","b.gif" );
      ((Element)v.get(411)).setAttribute("width","8" );
      ((Element)v.get(411)).setAttribute("height","8" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */
      /* Termina nodo:410   */
      /* Termina nodo:409   */

      /* Empieza nodo:412 / Elemento padre: 408   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(408)).appendChild((Element)v.get(412));

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
   }

   private void getXML1800(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(412)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(416)).setAttribute("nombre","lblSubgerenciaVentasTrasv" );
      ((Element)v.get(416)).setAttribute("alto","13" );
      ((Element)v.get(416)).setAttribute("filas","1" );
      ((Element)v.get(416)).setAttribute("valor","" );
      ((Element)v.get(416)).setAttribute("id","datosTitle" );
      ((Element)v.get(416)).setAttribute("cod","124" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */
      /* Termina nodo:415   */

      /* Empieza nodo:417 / Elemento padre: 412   */
      v.add(doc.createElement("td"));
      ((Element)v.get(412)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(418)).setAttribute("src","b.gif" );
      ((Element)v.get(418)).setAttribute("width","25" );
      ((Element)v.get(418)).setAttribute("height","8" );
      ((Element)v.get(417)).appendChild((Element)v.get(418));
      /* Termina nodo:418   */
      /* Termina nodo:417   */

      /* Empieza nodo:419 / Elemento padre: 412   */
      v.add(doc.createElement("td"));
      ((Element)v.get(412)).appendChild((Element)v.get(419));

      /* Empieza nodo:420 / Elemento padre: 419   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(420)).setAttribute("nombre","lblRegionTrasv" );
      ((Element)v.get(420)).setAttribute("alto","13" );
      ((Element)v.get(420)).setAttribute("filas","1" );
      ((Element)v.get(420)).setAttribute("valor","" );
      ((Element)v.get(420)).setAttribute("id","datosTitle" );
      ((Element)v.get(420)).setAttribute("cod","109" );
      ((Element)v.get(419)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */
      /* Termina nodo:419   */

      /* Empieza nodo:421 / Elemento padre: 412   */
      v.add(doc.createElement("td"));
      ((Element)v.get(412)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(422)).setAttribute("src","b.gif" );
      ((Element)v.get(422)).setAttribute("width","8" );
      ((Element)v.get(422)).setAttribute("height","8" );
      ((Element)v.get(421)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */
      /* Termina nodo:421   */
      /* Termina nodo:412   */

      /* Empieza nodo:423 / Elemento padre: 408   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(408)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("td"));
      ((Element)v.get(423)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(425)).setAttribute("src","b.gif" );
      ((Element)v.get(425)).setAttribute("width","8" );
      ((Element)v.get(425)).setAttribute("height","8" );
      ((Element)v.get(424)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */
      /* Termina nodo:424   */

      /* Empieza nodo:426 / Elemento padre: 423   */
      v.add(doc.createElement("td"));
      ((Element)v.get(426)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(423)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(427)).setAttribute("nombre","cbSubgerenciaVentasTrasv" );
      ((Element)v.get(427)).setAttribute("id","datosCampos" );
      ((Element)v.get(427)).setAttribute("size","1" );
      ((Element)v.get(427)).setAttribute("multiple","N" );
      ((Element)v.get(427)).setAttribute("req","S" );
      ((Element)v.get(427)).setAttribute("valorinicial","" );
      ((Element)v.get(427)).setAttribute("textoinicial","" );
      ((Element)v.get(427)).setAttribute("onchange","onChangeCbSVGTrasv();" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(427)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */
      /* Termina nodo:427   */
      /* Termina nodo:426   */

      /* Empieza nodo:429 / Elemento padre: 423   */
      v.add(doc.createElement("td"));
      ((Element)v.get(423)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(430)).setAttribute("src","b.gif" );
      ((Element)v.get(430)).setAttribute("width","25" );
      ((Element)v.get(430)).setAttribute("height","8" );
      ((Element)v.get(429)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */
      /* Termina nodo:429   */

      /* Empieza nodo:431 / Elemento padre: 423   */
      v.add(doc.createElement("td"));
      ((Element)v.get(431)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(423)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(432)).setAttribute("nombre","cbRegionTrasv" );
      ((Element)v.get(432)).setAttribute("id","datosCampos" );
      ((Element)v.get(432)).setAttribute("size","1" );
      ((Element)v.get(432)).setAttribute("multiple","N" );
      ((Element)v.get(432)).setAttribute("req","S" );
      ((Element)v.get(432)).setAttribute("valorinicial","" );
      ((Element)v.get(432)).setAttribute("textoinicial","" );
      ((Element)v.get(432)).setAttribute("onchange","onChangeCbRegionTrasv();" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(432)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */
      /* Termina nodo:432   */
      /* Termina nodo:431   */

      /* Empieza nodo:434 / Elemento padre: 423   */
      v.add(doc.createElement("td"));
      ((Element)v.get(423)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(435)).setAttribute("src","b.gif" );
      ((Element)v.get(435)).setAttribute("width","8" );
      ((Element)v.get(435)).setAttribute("height","8" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */
      /* Termina nodo:434   */
      /* Termina nodo:423   */

      /* Empieza nodo:436 / Elemento padre: 408   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(408)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("td"));
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(437)).setAttribute("colspan","5" );
      ((Element)v.get(436)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(438)).setAttribute("src","b.gif" );
      ((Element)v.get(438)).setAttribute("width","8" );
      ((Element)v.get(438)).setAttribute("height","8" );
      ((Element)v.get(437)).appendChild((Element)v.get(438));
      /* Termina nodo:438   */
      /* Termina nodo:437   */
      /* Termina nodo:436   */

      /* Empieza nodo:439 / Elemento padre: 408   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(408)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("td"));
      ((Element)v.get(440)).setAttribute("colspan","5" );
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

      /* Empieza nodo:442 / Elemento padre: 408   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(408)).appendChild((Element)v.get(442));

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
      ((Element)v.get(446)).setAttribute("nombre","lblZonaTrasv" );
      ((Element)v.get(446)).setAttribute("alto","13" );
      ((Element)v.get(446)).setAttribute("filas","1" );
      ((Element)v.get(446)).setAttribute("valor","" );
      ((Element)v.get(446)).setAttribute("id","datosTitle" );
      ((Element)v.get(446)).setAttribute("cod","143" );
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
      ((Element)v.get(450)).setAttribute("nombre","lblSeccionTrasv" );
      ((Element)v.get(450)).setAttribute("alto","13" );
      ((Element)v.get(450)).setAttribute("filas","1" );
      ((Element)v.get(450)).setAttribute("valor","" );
      ((Element)v.get(450)).setAttribute("id","datosTitle" );
      ((Element)v.get(450)).setAttribute("cod","112" );
      ((Element)v.get(449)).appendChild((Element)v.get(450));
      /* Termina nodo:450   */
      /* Termina nodo:449   */

      /* Empieza nodo:451 / Elemento padre: 442   */
      v.add(doc.createElement("td"));
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

      /* Empieza nodo:453 / Elemento padre: 408   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(408)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("td"));
      ((Element)v.get(453)).appendChild((Element)v.get(454));

      /* Empieza nodo:455 / Elemento padre: 454   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(455)).setAttribute("src","b.gif" );
      ((Element)v.get(455)).setAttribute("width","8" );
      ((Element)v.get(455)).setAttribute("height","8" );
      ((Element)v.get(454)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */
      /* Termina nodo:454   */

      /* Empieza nodo:456 / Elemento padre: 453   */
      v.add(doc.createElement("td"));
      ((Element)v.get(456)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(453)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(457)).setAttribute("nombre","cbZonaTrasv" );
      ((Element)v.get(457)).setAttribute("id","datosCampos" );
      ((Element)v.get(457)).setAttribute("size","1" );
      ((Element)v.get(457)).setAttribute("multiple","N" );
      ((Element)v.get(457)).setAttribute("req","S" );
      ((Element)v.get(457)).setAttribute("valorinicial","" );
      ((Element)v.get(457)).setAttribute("textoinicial","" );
      ((Element)v.get(457)).setAttribute("onchange","onChangeCbZonaTrasv();" );
      ((Element)v.get(456)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(457)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */
      /* Termina nodo:457   */
      /* Termina nodo:456   */

      /* Empieza nodo:459 / Elemento padre: 453   */
      v.add(doc.createElement("td"));
      ((Element)v.get(453)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(460)).setAttribute("src","b.gif" );
      ((Element)v.get(460)).setAttribute("width","25" );
      ((Element)v.get(460)).setAttribute("height","8" );
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(459)).appendChild((Element)v.get(460));
      /* Termina nodo:460   */
      /* Termina nodo:459   */

      /* Empieza nodo:461 / Elemento padre: 453   */
      v.add(doc.createElement("td"));
      ((Element)v.get(461)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(453)).appendChild((Element)v.get(461));

      /* Empieza nodo:462 / Elemento padre: 461   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(462)).setAttribute("nombre","cbSeccionTrasv" );
      ((Element)v.get(462)).setAttribute("id","datosCampos" );
      ((Element)v.get(462)).setAttribute("size","1" );
      ((Element)v.get(462)).setAttribute("multiple","N" );
      ((Element)v.get(462)).setAttribute("req","S" );
      ((Element)v.get(462)).setAttribute("valorinicial","" );
      ((Element)v.get(462)).setAttribute("textoinicial","" );
      ((Element)v.get(462)).setAttribute("onchange","onChangeCbSeccionTrasv();" );
      ((Element)v.get(461)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(462)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */
      /* Termina nodo:462   */
      /* Termina nodo:461   */

      /* Empieza nodo:464 / Elemento padre: 453   */
      v.add(doc.createElement("td"));
      ((Element)v.get(453)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(465)).setAttribute("src","b.gif" );
      ((Element)v.get(465)).setAttribute("width","8" );
      ((Element)v.get(465)).setAttribute("height","8" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));
      /* Termina nodo:465   */
      /* Termina nodo:464   */
      /* Termina nodo:453   */

      /* Empieza nodo:466 / Elemento padre: 408   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(408)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("td"));
      ((Element)v.get(467)).setAttribute("colspan","5" );
      ((Element)v.get(466)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(468)).setAttribute("src","b.gif" );
      ((Element)v.get(468)).setAttribute("width","8" );
      ((Element)v.get(468)).setAttribute("height","8" );
      ((Element)v.get(467)).appendChild((Element)v.get(468));
      /* Termina nodo:468   */
      /* Termina nodo:467   */
      /* Termina nodo:466   */

      /* Empieza nodo:469 / Elemento padre: 408   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(408)).appendChild((Element)v.get(469));

      /* Empieza nodo:470 / Elemento padre: 469   */
      v.add(doc.createElement("td"));
      ((Element)v.get(470)).setAttribute("colspan","5" );
      ((Element)v.get(469)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(471)).setAttribute("src","b.gif" );
      ((Element)v.get(471)).setAttribute("width","8" );
      ((Element)v.get(471)).setAttribute("height","8" );
      ((Element)v.get(470)).appendChild((Element)v.get(471));
      /* Termina nodo:471   */
      /* Termina nodo:470   */
      /* Termina nodo:469   */

      /* Empieza nodo:472 / Elemento padre: 408   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(408)).appendChild((Element)v.get(472));

      /* Empieza nodo:473 / Elemento padre: 472   */
      v.add(doc.createElement("td"));
      ((Element)v.get(472)).appendChild((Element)v.get(473));

      /* Empieza nodo:474 / Elemento padre: 473   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(474)).setAttribute("src","b.gif" );
      ((Element)v.get(474)).setAttribute("width","8" );
      ((Element)v.get(474)).setAttribute("height","8" );
      ((Element)v.get(473)).appendChild((Element)v.get(474));
      /* Termina nodo:474   */
      /* Termina nodo:473   */

      /* Empieza nodo:475 / Elemento padre: 472   */
      v.add(doc.createElement("td"));
      ((Element)v.get(472)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(476)).setAttribute("nombre","lblTerrDest" );
      ((Element)v.get(476)).setAttribute("alto","13" );
      ((Element)v.get(476)).setAttribute("filas","1" );
      ((Element)v.get(476)).setAttribute("valor","" );
      ((Element)v.get(476)).setAttribute("id","datosTitle" );
      ((Element)v.get(476)).setAttribute("cod","3203" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */
      /* Termina nodo:475   */

      /* Empieza nodo:477 / Elemento padre: 472   */
      v.add(doc.createElement("td"));
      ((Element)v.get(472)).appendChild((Element)v.get(477));

      /* Empieza nodo:478 / Elemento padre: 477   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(478)).setAttribute("src","b.gif" );
      ((Element)v.get(478)).setAttribute("width","25" );
      ((Element)v.get(478)).setAttribute("height","8" );
      ((Element)v.get(477)).appendChild((Element)v.get(478));
      /* Termina nodo:478   */
      /* Termina nodo:477   */

      /* Empieza nodo:479 / Elemento padre: 472   */
      v.add(doc.createElement("td"));
      ((Element)v.get(472)).appendChild((Element)v.get(479));

      /* Empieza nodo:480 / Elemento padre: 479   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(480)).setAttribute("nombre","lblConsultoras" );
      ((Element)v.get(480)).setAttribute("alto","13" );
      ((Element)v.get(480)).setAttribute("filas","1" );
      ((Element)v.get(480)).setAttribute("valor","" );
      ((Element)v.get(480)).setAttribute("id","datosTitle" );
      ((Element)v.get(480)).setAttribute("cod","00401" );
      ((Element)v.get(479)).appendChild((Element)v.get(480));
      /* Termina nodo:480   */
      /* Termina nodo:479   */

      /* Empieza nodo:481 / Elemento padre: 472   */
      v.add(doc.createElement("td"));
      ((Element)v.get(481)).setAttribute("width","100%" );
      ((Element)v.get(472)).appendChild((Element)v.get(481));

      /* Empieza nodo:482 / Elemento padre: 481   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(482)).setAttribute("src","b.gif" );
      ((Element)v.get(482)).setAttribute("width","8" );
      ((Element)v.get(482)).setAttribute("height","8" );
      ((Element)v.get(481)).appendChild((Element)v.get(482));
      /* Termina nodo:482   */
      /* Termina nodo:481   */
      /* Termina nodo:472   */

      /* Empieza nodo:483 / Elemento padre: 408   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(408)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("td"));
   }

   private void getXML2070(Document doc) {
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
      ((Element)v.get(486)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(483)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(487)).setAttribute("nombre","cbTerrDest" );
      ((Element)v.get(487)).setAttribute("id","datosCampos" );
      ((Element)v.get(487)).setAttribute("size","1" );
      ((Element)v.get(487)).setAttribute("multiple","N" );
      ((Element)v.get(487)).setAttribute("req","S" );
      ((Element)v.get(487)).setAttribute("valorinicial","" );
      ((Element)v.get(487)).setAttribute("textoinicial","" );
      ((Element)v.get(487)).setAttribute("onchange",";" );
      ((Element)v.get(486)).appendChild((Element)v.get(487));

      /* Empieza nodo:488 / Elemento padre: 487   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(487)).appendChild((Element)v.get(488));
      /* Termina nodo:488   */
      /* Termina nodo:487   */
      /* Termina nodo:486   */

      /* Empieza nodo:489 / Elemento padre: 483   */
      v.add(doc.createElement("td"));
      ((Element)v.get(483)).appendChild((Element)v.get(489));

      /* Empieza nodo:490 / Elemento padre: 489   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(490)).setAttribute("src","b.gif" );
      ((Element)v.get(490)).setAttribute("width","25" );
      ((Element)v.get(490)).setAttribute("height","8" );
      ((Element)v.get(489)).appendChild((Element)v.get(490));
      /* Termina nodo:490   */
      /* Termina nodo:489   */

      /* Empieza nodo:491 / Elemento padre: 483   */
      v.add(doc.createElement("td"));
      ((Element)v.get(491)).setAttribute("rowspan","12" );
      ((Element)v.get(491)).setAttribute("width","100%" );
      ((Element)v.get(483)).appendChild((Element)v.get(491));

      /* Empieza nodo:492 / Elemento padre: 491   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(492)).setAttribute("nombre","cbConsultorasTrasv" );
      ((Element)v.get(492)).setAttribute("id","datosCampos" );
      ((Element)v.get(492)).setAttribute("size","16" );
      ((Element)v.get(492)).setAttribute("multiple","S" );
      ((Element)v.get(492)).setAttribute("req","S" );
      ((Element)v.get(492)).setAttribute("onchange","" );
      ((Element)v.get(492)).setAttribute("valorinicial","" );
      ((Element)v.get(492)).setAttribute("textoinicial","" );
      ((Element)v.get(491)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(492)).appendChild((Element)v.get(493));
      /* Termina nodo:493   */
      /* Termina nodo:492   */
      /* Termina nodo:491   */

      /* Empieza nodo:494 / Elemento padre: 483   */
      v.add(doc.createElement("td"));
      ((Element)v.get(494)).setAttribute("width","100%" );
      ((Element)v.get(483)).appendChild((Element)v.get(494));

      /* Empieza nodo:495 / Elemento padre: 494   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(495)).setAttribute("src","b.gif" );
      ((Element)v.get(495)).setAttribute("width","8" );
      ((Element)v.get(495)).setAttribute("height","8" );
      ((Element)v.get(494)).appendChild((Element)v.get(495));
      /* Termina nodo:495   */
      /* Termina nodo:494   */
      /* Termina nodo:483   */

      /* Empieza nodo:496 / Elemento padre: 408   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(408)).appendChild((Element)v.get(496));

      /* Empieza nodo:497 / Elemento padre: 496   */
      v.add(doc.createElement("td"));
      ((Element)v.get(497)).setAttribute("colspan","5" );
      ((Element)v.get(496)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(498)).setAttribute("src","b.gif" );
      ((Element)v.get(498)).setAttribute("width","8" );
      ((Element)v.get(498)).setAttribute("height","8" );
      ((Element)v.get(497)).appendChild((Element)v.get(498));
      /* Termina nodo:498   */
      /* Termina nodo:497   */
      /* Termina nodo:496   */

      /* Empieza nodo:499 / Elemento padre: 408   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(408)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("td"));
      ((Element)v.get(500)).setAttribute("colspan","5" );
      ((Element)v.get(499)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(501)).setAttribute("src","b.gif" );
      ((Element)v.get(501)).setAttribute("width","8" );
      ((Element)v.get(501)).setAttribute("height","8" );
      ((Element)v.get(500)).appendChild((Element)v.get(501));
      /* Termina nodo:501   */
      /* Termina nodo:500   */
      /* Termina nodo:499   */

      /* Empieza nodo:502 / Elemento padre: 408   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(408)).appendChild((Element)v.get(502));

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
      ((Element)v.get(502)).appendChild((Element)v.get(505));

      /* Empieza nodo:506 / Elemento padre: 505   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(506)).setAttribute("src","b.gif" );
      ((Element)v.get(506)).setAttribute("width","8" );
      ((Element)v.get(506)).setAttribute("height","8" );
      ((Element)v.get(505)).appendChild((Element)v.get(506));
      /* Termina nodo:506   */
      /* Termina nodo:505   */

      /* Empieza nodo:507 / Elemento padre: 502   */
      v.add(doc.createElement("td"));
      ((Element)v.get(502)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
   }

   private void getXML2160(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(508)).setAttribute("src","b.gif" );
      ((Element)v.get(508)).setAttribute("width","25" );
      ((Element)v.get(508)).setAttribute("height","8" );
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

      /* Empieza nodo:511 / Elemento padre: 502   */
      v.add(doc.createElement("td"));
      ((Element)v.get(511)).setAttribute("width","100%" );
      ((Element)v.get(502)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(512)).setAttribute("src","b.gif" );
      ((Element)v.get(512)).setAttribute("width","8" );
      ((Element)v.get(512)).setAttribute("height","8" );
      ((Element)v.get(511)).appendChild((Element)v.get(512));
      /* Termina nodo:512   */
      /* Termina nodo:511   */
      /* Termina nodo:502   */

      /* Empieza nodo:513 / Elemento padre: 408   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(408)).appendChild((Element)v.get(513));

      /* Empieza nodo:514 / Elemento padre: 513   */
      v.add(doc.createElement("td"));
      ((Element)v.get(513)).appendChild((Element)v.get(514));

      /* Empieza nodo:515 / Elemento padre: 514   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(515)).setAttribute("src","b.gif" );
      ((Element)v.get(515)).setAttribute("width","8" );
      ((Element)v.get(515)).setAttribute("height","8" );
      ((Element)v.get(514)).appendChild((Element)v.get(515));
      /* Termina nodo:515   */
      /* Termina nodo:514   */

      /* Empieza nodo:516 / Elemento padre: 513   */
      v.add(doc.createElement("td"));
      ((Element)v.get(513)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(517)).setAttribute("src","b.gif" );
      ((Element)v.get(517)).setAttribute("width","8" );
      ((Element)v.get(517)).setAttribute("height","8" );
      ((Element)v.get(516)).appendChild((Element)v.get(517));
      /* Termina nodo:517   */
      /* Termina nodo:516   */

      /* Empieza nodo:518 / Elemento padre: 513   */
      v.add(doc.createElement("td"));
      ((Element)v.get(513)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(519)).setAttribute("src","b.gif" );
      ((Element)v.get(519)).setAttribute("width","25" );
      ((Element)v.get(519)).setAttribute("height","8" );
      ((Element)v.get(518)).appendChild((Element)v.get(519));
      /* Termina nodo:519   */
      /* Termina nodo:518   */

      /* Empieza nodo:520 / Elemento padre: 513   */
      v.add(doc.createElement("td"));
      ((Element)v.get(520)).setAttribute("width","100%" );
      ((Element)v.get(513)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(521)).setAttribute("src","b.gif" );
      ((Element)v.get(521)).setAttribute("width","8" );
      ((Element)v.get(521)).setAttribute("height","8" );
      ((Element)v.get(520)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */
      /* Termina nodo:520   */

      /* Empieza nodo:522 / Elemento padre: 513   */
      v.add(doc.createElement("td"));
      ((Element)v.get(522)).setAttribute("width","100%" );
      ((Element)v.get(513)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(523)).setAttribute("src","b.gif" );
      ((Element)v.get(523)).setAttribute("width","8" );
      ((Element)v.get(523)).setAttribute("height","8" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */
      /* Termina nodo:522   */
      /* Termina nodo:513   */

      /* Empieza nodo:524 / Elemento padre: 408   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(408)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("td"));
      ((Element)v.get(525)).setAttribute("colspan","5" );
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

      /* Empieza nodo:527 / Elemento padre: 408   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(408)).appendChild((Element)v.get(527));

      /* Empieza nodo:528 / Elemento padre: 527   */
      v.add(doc.createElement("td"));
      ((Element)v.get(528)).setAttribute("colspan","5" );
      ((Element)v.get(527)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(529)).setAttribute("src","b.gif" );
      ((Element)v.get(529)).setAttribute("width","8" );
      ((Element)v.get(529)).setAttribute("height","8" );
      ((Element)v.get(528)).appendChild((Element)v.get(529));
      /* Termina nodo:529   */
      /* Termina nodo:528   */
      /* Termina nodo:527   */

      /* Empieza nodo:530 / Elemento padre: 408   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(408)).appendChild((Element)v.get(530));

      /* Empieza nodo:531 / Elemento padre: 530   */
      v.add(doc.createElement("td"));
      ((Element)v.get(530)).appendChild((Element)v.get(531));

      /* Empieza nodo:532 / Elemento padre: 531   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(532)).setAttribute("src","b.gif" );
      ((Element)v.get(532)).setAttribute("width","8" );
      ((Element)v.get(532)).setAttribute("height","8" );
      ((Element)v.get(531)).appendChild((Element)v.get(532));
      /* Termina nodo:532   */
      /* Termina nodo:531   */

      /* Empieza nodo:533 / Elemento padre: 530   */
      v.add(doc.createElement("td"));
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(530)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(534)).setAttribute("src","b.gif" );
      ((Element)v.get(534)).setAttribute("width","8" );
      ((Element)v.get(534)).setAttribute("height","8" );
      ((Element)v.get(533)).appendChild((Element)v.get(534));
      /* Termina nodo:534   */
      /* Termina nodo:533   */

      /* Empieza nodo:535 / Elemento padre: 530   */
      v.add(doc.createElement("td"));
      ((Element)v.get(530)).appendChild((Element)v.get(535));

      /* Empieza nodo:536 / Elemento padre: 535   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(536)).setAttribute("src","b.gif" );
      ((Element)v.get(536)).setAttribute("width","25" );
      ((Element)v.get(536)).setAttribute("height","8" );
      ((Element)v.get(535)).appendChild((Element)v.get(536));
      /* Termina nodo:536   */
      /* Termina nodo:535   */

      /* Empieza nodo:537 / Elemento padre: 530   */
      v.add(doc.createElement("td"));
      ((Element)v.get(537)).setAttribute("width","100%" );
      ((Element)v.get(530)).appendChild((Element)v.get(537));

      /* Empieza nodo:538 / Elemento padre: 537   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(538)).setAttribute("src","b.gif" );
      ((Element)v.get(538)).setAttribute("width","8" );
      ((Element)v.get(538)).setAttribute("height","8" );
      ((Element)v.get(537)).appendChild((Element)v.get(538));
      /* Termina nodo:538   */
      /* Termina nodo:537   */

      /* Empieza nodo:539 / Elemento padre: 530   */
      v.add(doc.createElement("td"));
      ((Element)v.get(539)).setAttribute("width","100%" );
      ((Element)v.get(530)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(540)).setAttribute("src","b.gif" );
      ((Element)v.get(540)).setAttribute("width","8" );
      ((Element)v.get(540)).setAttribute("height","8" );
      ((Element)v.get(539)).appendChild((Element)v.get(540));
      /* Termina nodo:540   */
      /* Termina nodo:539   */
      /* Termina nodo:530   */

      /* Empieza nodo:541 / Elemento padre: 408   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(408)).appendChild((Element)v.get(541));

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
      v.add(doc.createElement("IMG"));
      ((Element)v.get(545)).setAttribute("src","b.gif" );
      ((Element)v.get(545)).setAttribute("width","8" );
      ((Element)v.get(545)).setAttribute("height","8" );
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
      ((Element)v.get(548)).setAttribute("width","100%" );
      ((Element)v.get(541)).appendChild((Element)v.get(548));

      /* Empieza nodo:549 / Elemento padre: 548   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(549)).setAttribute("src","b.gif" );
      ((Element)v.get(549)).setAttribute("width","8" );
      ((Element)v.get(549)).setAttribute("height","8" );
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

      /* Empieza nodo:552 / Elemento padre: 408   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(408)).appendChild((Element)v.get(552));

      /* Empieza nodo:553 / Elemento padre: 552   */
      v.add(doc.createElement("td"));
      ((Element)v.get(553)).setAttribute("colspan","5" );
      ((Element)v.get(552)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(554)).setAttribute("src","b.gif" );
      ((Element)v.get(554)).setAttribute("width","8" );
      ((Element)v.get(554)).setAttribute("height","8" );
      ((Element)v.get(553)).appendChild((Element)v.get(554));
      /* Termina nodo:554   */
      /* Termina nodo:553   */
      /* Termina nodo:552   */

      /* Empieza nodo:555 / Elemento padre: 408   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(408)).appendChild((Element)v.get(555));

      /* Empieza nodo:556 / Elemento padre: 555   */
      v.add(doc.createElement("td"));
      ((Element)v.get(556)).setAttribute("colspan","5" );
      ((Element)v.get(555)).appendChild((Element)v.get(556));

      /* Empieza nodo:557 / Elemento padre: 556   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(557)).setAttribute("src","b.gif" );
      ((Element)v.get(557)).setAttribute("width","8" );
      ((Element)v.get(557)).setAttribute("height","8" );
      ((Element)v.get(556)).appendChild((Element)v.get(557));
      /* Termina nodo:557   */
      /* Termina nodo:556   */
      /* Termina nodo:555   */

      /* Empieza nodo:558 / Elemento padre: 408   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(408)).appendChild((Element)v.get(558));

      /* Empieza nodo:559 / Elemento padre: 558   */
   }

   private void getXML2340(Document doc) {
      v.add(doc.createElement("td"));
      ((Element)v.get(558)).appendChild((Element)v.get(559));

      /* Empieza nodo:560 / Elemento padre: 559   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(560)).setAttribute("src","b.gif" );
      ((Element)v.get(560)).setAttribute("width","8" );
      ((Element)v.get(560)).setAttribute("height","8" );
      ((Element)v.get(559)).appendChild((Element)v.get(560));
      /* Termina nodo:560   */
      /* Termina nodo:559   */

      /* Empieza nodo:561 / Elemento padre: 558   */
      v.add(doc.createElement("td"));
      ((Element)v.get(558)).appendChild((Element)v.get(561));

      /* Empieza nodo:562 / Elemento padre: 561   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(562)).setAttribute("nombre","btnAniadirTrasv" );
      ((Element)v.get(562)).setAttribute("ID","botonContenido" );
      ((Element)v.get(562)).setAttribute("tipo","html" );
      ((Element)v.get(562)).setAttribute("accion","onClickBtnAniadirTrasv();" );
      ((Element)v.get(562)).setAttribute("estado","false" );
      ((Element)v.get(562)).setAttribute("cod","404" );
      ((Element)v.get(562)).setAttribute("ontab","focalizaTab('T');" );
      ((Element)v.get(561)).appendChild((Element)v.get(562));
      /* Termina nodo:562   */
      /* Termina nodo:561   */

      /* Empieza nodo:563 / Elemento padre: 558   */
      v.add(doc.createElement("td"));
      ((Element)v.get(558)).appendChild((Element)v.get(563));

      /* Empieza nodo:564 / Elemento padre: 563   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(564)).setAttribute("src","b.gif" );
      ((Element)v.get(564)).setAttribute("width","25" );
      ((Element)v.get(564)).setAttribute("height","8" );
      ((Element)v.get(563)).appendChild((Element)v.get(564));
      /* Termina nodo:564   */
      /* Termina nodo:563   */

      /* Empieza nodo:565 / Elemento padre: 558   */
      v.add(doc.createElement("td"));
      ((Element)v.get(565)).setAttribute("width","100%" );
      ((Element)v.get(558)).appendChild((Element)v.get(565));

      /* Empieza nodo:566 / Elemento padre: 565   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(566)).setAttribute("src","b.gif" );
      ((Element)v.get(566)).setAttribute("width","8" );
      ((Element)v.get(566)).setAttribute("height","8" );
      ((Element)v.get(565)).appendChild((Element)v.get(566));
      /* Termina nodo:566   */
      /* Termina nodo:565   */

      /* Empieza nodo:567 / Elemento padre: 558   */
      v.add(doc.createElement("td"));
      ((Element)v.get(567)).setAttribute("width","100%" );
      ((Element)v.get(558)).appendChild((Element)v.get(567));

      /* Empieza nodo:568 / Elemento padre: 567   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(568)).setAttribute("src","b.gif" );
      ((Element)v.get(568)).setAttribute("width","8" );
      ((Element)v.get(568)).setAttribute("height","8" );
      ((Element)v.get(567)).appendChild((Element)v.get(568));
      /* Termina nodo:568   */
      /* Termina nodo:567   */
      /* Termina nodo:558   */

      /* Empieza nodo:569 / Elemento padre: 408   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(408)).appendChild((Element)v.get(569));

      /* Empieza nodo:570 / Elemento padre: 569   */
      v.add(doc.createElement("td"));
      ((Element)v.get(570)).setAttribute("colspan","5" );
      ((Element)v.get(569)).appendChild((Element)v.get(570));

      /* Empieza nodo:571 / Elemento padre: 570   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(571)).setAttribute("src","b.gif" );
      ((Element)v.get(571)).setAttribute("width","8" );
      ((Element)v.get(571)).setAttribute("height","8" );
      ((Element)v.get(570)).appendChild((Element)v.get(571));
      /* Termina nodo:571   */
      /* Termina nodo:570   */
      /* Termina nodo:569   */
      /* Termina nodo:408   */
      /* Termina nodo:405   */
      /* Termina nodo:404   */
      /* Termina nodo:401   */
      /* Termina nodo:393   */
      /* Termina nodo:392   */

      /* Empieza nodo:572 / Elemento padre: 32   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(572)).setAttribute("nombre","capaLista2" );
      ((Element)v.get(572)).setAttribute("ancho","100%" );
      ((Element)v.get(572)).setAttribute("alto","330" );
      ((Element)v.get(572)).setAttribute("x","7" );
      ((Element)v.get(572)).setAttribute("y","630" );
      ((Element)v.get(572)).setAttribute("colorf","" );
      ((Element)v.get(572)).setAttribute("borde","0" );
      ((Element)v.get(572)).setAttribute("imagenf","" );
      ((Element)v.get(572)).setAttribute("repeat","" );
      ((Element)v.get(572)).setAttribute("padding","" );
      ((Element)v.get(572)).setAttribute("visibilidad","" );
      ((Element)v.get(572)).setAttribute("contravsb","" );
      ((Element)v.get(572)).setAttribute("zindex","" );
      ((Element)v.get(32)).appendChild((Element)v.get(572));

      /* Empieza nodo:573 / Elemento padre: 572   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(573)).setAttribute("nombre","listado2" );
      ((Element)v.get(573)).setAttribute("ancho","369" );
      ((Element)v.get(573)).setAttribute("alto","301" );
      ((Element)v.get(573)).setAttribute("x","12" );
      ((Element)v.get(573)).setAttribute("y","0" );
      ((Element)v.get(573)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(573)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(573)).setAttribute("pintadoSimplificado","S" );
      ((Element)v.get(572)).appendChild((Element)v.get(573));

      /* Empieza nodo:574 / Elemento padre: 573   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(574)).setAttribute("precarga","S" );
      ((Element)v.get(574)).setAttribute("conROver","S" );
      ((Element)v.get(573)).appendChild((Element)v.get(574));

      /* Empieza nodo:575 / Elemento padre: 574   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(575)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(575)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(575)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(575)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(574)).appendChild((Element)v.get(575));
      /* Termina nodo:575   */

      /* Empieza nodo:576 / Elemento padre: 574   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(576)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(576)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(576)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(576)).setAttribute("aximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(574)).appendChild((Element)v.get(576));
      /* Termina nodo:576   */

      /* Empieza nodo:577 / Elemento padre: 574   */
      v.add(doc.createElement("BTNORDENAR"));
      ((Element)v.get(577)).setAttribute("ordenar","ascendente_on.gif" );
      ((Element)v.get(577)).setAttribute("ordenarInv","descendente_on.gif" );
      ((Element)v.get(574)).appendChild((Element)v.get(577));
      /* Termina nodo:577   */
      /* Termina nodo:574   */

      /* Empieza nodo:578 / Elemento padre: 573   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(573)).appendChild((Element)v.get(578));

      /* Empieza nodo:579 / Elemento padre: 578   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(579)).setAttribute("borde","1" );
      ((Element)v.get(579)).setAttribute("horizDatos","1" );
      ((Element)v.get(579)).setAttribute("horizCabecera","1" );
      ((Element)v.get(579)).setAttribute("vertical","1" );
      ((Element)v.get(579)).setAttribute("horizTitulo","1" );
      ((Element)v.get(579)).setAttribute("horizBase","1" );
      ((Element)v.get(578)).appendChild((Element)v.get(579));
      /* Termina nodo:579   */

      /* Empieza nodo:580 / Elemento padre: 578   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(580)).setAttribute("borde","#999999" );
      ((Element)v.get(580)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(580)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(580)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(580)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(580)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(580)).setAttribute("horizBase","#999999" );
      ((Element)v.get(578)).appendChild((Element)v.get(580));
      /* Termina nodo:580   */
      /* Termina nodo:578   */

      /* Empieza nodo:581 / Elemento padre: 573   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(581)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(581)).setAttribute("alto","22" );
      ((Element)v.get(581)).setAttribute("imgFondo","" );
      ((Element)v.get(581)).setAttribute("cod","0073" );
      ((Element)v.get(581)).setAttribute("ID","datosTitle" );
      ((Element)v.get(573)).appendChild((Element)v.get(581));
      /* Termina nodo:581   */

      /* Empieza nodo:582 / Elemento padre: 573   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(582)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(582)).setAttribute("alto","22" );
      ((Element)v.get(582)).setAttribute("imgFondo","" );
      ((Element)v.get(573)).appendChild((Element)v.get(582));
      /* Termina nodo:582   */

      /* Empieza nodo:583 / Elemento padre: 573   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(583)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(583)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(583)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(583)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(583)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(583)).setAttribute("botonOrdenar","S" );
      ((Element)v.get(573)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(584)).setAttribute("ancho","50" );
      ((Element)v.get(584)).setAttribute("minimizable","S" );
      ((Element)v.get(584)).setAttribute("minimizada","N" );
      ((Element)v.get(583)).appendChild((Element)v.get(584));
      /* Termina nodo:584   */

      /* Empieza nodo:585 / Elemento padre: 583   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(585)).setAttribute("ancho","50" );
      ((Element)v.get(585)).setAttribute("minimizable","S" );
      ((Element)v.get(585)).setAttribute("minimizada","N" );
      ((Element)v.get(583)).appendChild((Element)v.get(585));
      /* Termina nodo:585   */

      /* Empieza nodo:586 / Elemento padre: 583   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(586)).setAttribute("ancho","50" );
      ((Element)v.get(586)).setAttribute("minimizable","S" );
      ((Element)v.get(586)).setAttribute("minimizada","N" );
      ((Element)v.get(586)).setAttribute("oculta","S" );
      ((Element)v.get(583)).appendChild((Element)v.get(586));
      /* Termina nodo:586   */
      /* Termina nodo:583   */

      /* Empieza nodo:587 / Elemento padre: 573   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(587)).setAttribute("alto","25" );
      ((Element)v.get(587)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(587)).setAttribute("imgFondo","" );
      ((Element)v.get(587)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(573)).appendChild((Element)v.get(587));

      /* Empieza nodo:588 / Elemento padre: 587   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(588)).setAttribute("colFondo","" );
      ((Element)v.get(588)).setAttribute("ID","EstCab" );
      ((Element)v.get(588)).setAttribute("cod","3202" );
      ((Element)v.get(587)).appendChild((Element)v.get(588));

      /* Elemento padre:588 / Elemento actual: 589   */
      v.add(doc.createTextNode("Territorio Asignar"));
      ((Element)v.get(588)).appendChild((Text)v.get(589));

      /* Termina nodo Texto:589   */
      /* Termina nodo:588   */

      /* Empieza nodo:590 / Elemento padre: 587   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(590)).setAttribute("colFondo","" );
      ((Element)v.get(590)).setAttribute("ID","EstCab" );
      ((Element)v.get(590)).setAttribute("cod","263" );
      ((Element)v.get(587)).appendChild((Element)v.get(590));

      /* Elemento padre:590 / Elemento actual: 591   */
      v.add(doc.createTextNode("Cod cliente"));
      ((Element)v.get(590)).appendChild((Text)v.get(591));

      /* Termina nodo Texto:591   */
      /* Termina nodo:590   */

      /* Empieza nodo:592 / Elemento padre: 587   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(592)).setAttribute("colFondo","" );
      ((Element)v.get(592)).setAttribute("ID","EstCab" );
      ((Element)v.get(592)).setAttribute("cod","263" );
      ((Element)v.get(587)).appendChild((Element)v.get(592));

      /* Elemento padre:592 / Elemento actual: 593   */
      v.add(doc.createTextNode("Oid Cliente"));
      ((Element)v.get(592)).appendChild((Text)v.get(593));

      /* Termina nodo Texto:593   */
      /* Termina nodo:592   */
      /* Termina nodo:587   */

      /* Empieza nodo:594 / Elemento padre: 573   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(594)).setAttribute("alto","22" );
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(594)).setAttribute("accion","" );
      ((Element)v.get(594)).setAttribute("tipoEnvio","edicion" );
      ((Element)v.get(594)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(594)).setAttribute("maxSel","1" );
      ((Element)v.get(594)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(594)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(594)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(594)).setAttribute("onLoad","" );
      ((Element)v.get(594)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(594)).setAttribute("primerRefresco","N" );
      ((Element)v.get(573)).appendChild((Element)v.get(594));

      /* Empieza nodo:595 / Elemento padre: 594   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(595)).setAttribute("tipo","texto" );
      ((Element)v.get(595)).setAttribute("ID","EstDat" );
      ((Element)v.get(594)).appendChild((Element)v.get(595));
      /* Termina nodo:595   */

      /* Empieza nodo:596 / Elemento padre: 594   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(596)).setAttribute("tipo","texto" );
      ((Element)v.get(596)).setAttribute("ID","EstDat" );
      ((Element)v.get(594)).appendChild((Element)v.get(596));
      /* Termina nodo:596   */

      /* Empieza nodo:597 / Elemento padre: 594   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(597)).setAttribute("tipo","texto" );
      ((Element)v.get(597)).setAttribute("ID","EstDat" );
      ((Element)v.get(594)).appendChild((Element)v.get(597));
      /* Termina nodo:597   */
      /* Termina nodo:594   */

      /* Empieza nodo:598 / Elemento padre: 573   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(573)).appendChild((Element)v.get(598));
      /* Termina nodo:598   */

      /* Empieza nodo:599 / Elemento padre: 573   */
      v.add(doc.createElement("PAGINADO"));
      ((Element)v.get(599)).setAttribute("nombre","mipgndo" );
      ((Element)v.get(599)).setAttribute("ancho","679" );
      ((Element)v.get(599)).setAttribute("sep","$" );
      ((Element)v.get(599)).setAttribute("x","12" );
      ((Element)v.get(599)).setAttribute("class","botonera" );
      ((Element)v.get(599)).setAttribute("y","294" );
      ((Element)v.get(599)).setAttribute("control","|" );
      ((Element)v.get(599)).setAttribute("conector","ConectorBuscarCargosAbonos" );
      ((Element)v.get(599)).setAttribute("rowset","" );
      ((Element)v.get(599)).setAttribute("cargainicial","N" );
      ((Element)v.get(599)).setAttribute("onload","procesarPaginado(mipgndo,msgError, ultima, rowset, 'muestraLista(ultima, rowset)')" );
      ((Element)v.get(573)).appendChild((Element)v.get(599));

      /* Empieza nodo:600 / Elemento padre: 599   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(600)).setAttribute("nombre","ret" );
      ((Element)v.get(600)).setAttribute("x","37" );
      ((Element)v.get(600)).setAttribute("y","282" );
      ((Element)v.get(600)).setAttribute("ID","botonContenido" );
      ((Element)v.get(600)).setAttribute("img","retroceder_on" );
      ((Element)v.get(600)).setAttribute("tipo","0" );
      ((Element)v.get(600)).setAttribute("estado","false" );
      ((Element)v.get(600)).setAttribute("alt","" );
      ((Element)v.get(600)).setAttribute("codigo","" );
      ((Element)v.get(600)).setAttribute("accion","mipgndo.retroceder();" );
      ((Element)v.get(599)).appendChild((Element)v.get(600));
      /* Termina nodo:600   */

      /* Empieza nodo:601 / Elemento padre: 599   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(601)).setAttribute("nombre","ava" );
      ((Element)v.get(601)).setAttribute("x","52" );
      ((Element)v.get(601)).setAttribute("y","282" );
      ((Element)v.get(601)).setAttribute("ID","botonContenido" );
      ((Element)v.get(601)).setAttribute("img","avanzar_on" );
      ((Element)v.get(601)).setAttribute("tipo","0" );
      ((Element)v.get(601)).setAttribute("estado","false" );
      ((Element)v.get(601)).setAttribute("alt","" );
      ((Element)v.get(601)).setAttribute("codigo","" );
      ((Element)v.get(601)).setAttribute("accion","mipgndo.avanzar();" );
      ((Element)v.get(599)).appendChild((Element)v.get(601));
      /* Termina nodo:601   */
      /* Termina nodo:599   */
      /* Termina nodo:573   */

      /* Empieza nodo:602 / Elemento padre: 572   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(602)).setAttribute("nombre","primera" );
      ((Element)v.get(602)).setAttribute("x","20" );
      ((Element)v.get(602)).setAttribute("y","282" );
      ((Element)v.get(602)).setAttribute("ID","botonContenido" );
      ((Element)v.get(602)).setAttribute("img","primera_on" );
      ((Element)v.get(602)).setAttribute("tipo","-2" );
      ((Element)v.get(602)).setAttribute("estado","false" );
      ((Element)v.get(602)).setAttribute("alt","" );
      ((Element)v.get(602)).setAttribute("codigo","" );
      ((Element)v.get(602)).setAttribute("accion","mipgndo.retrocederPrimeraPagina();" );
      ((Element)v.get(572)).appendChild((Element)v.get(602));
      /* Termina nodo:602   */

      /* Empieza nodo:603 / Elemento padre: 572   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(603)).setAttribute("nombre","separa" );
      ((Element)v.get(603)).setAttribute("x","59" );
      ((Element)v.get(603)).setAttribute("y","278" );
      ((Element)v.get(603)).setAttribute("ID","botonContenido" );
      ((Element)v.get(603)).setAttribute("img","separa_base" );
      ((Element)v.get(603)).setAttribute("tipo","0" );
      ((Element)v.get(603)).setAttribute("estado","false" );
      ((Element)v.get(603)).setAttribute("alt","" );
      ((Element)v.get(603)).setAttribute("codigo","" );
      ((Element)v.get(603)).setAttribute("accion","" );
      ((Element)v.get(572)).appendChild((Element)v.get(603));
      /* Termina nodo:603   */

      /* Empieza nodo:604 / Elemento padre: 572   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(604)).setAttribute("nombre","EliminarTrasv" );
      ((Element)v.get(604)).setAttribute("x","10" );
      ((Element)v.get(604)).setAttribute("y","279" );
   }

   private void getXML2610(Document doc) {
      ((Element)v.get(604)).setAttribute("ID","botonContenido" );
      ((Element)v.get(604)).setAttribute("tipo","html" );
      ((Element)v.get(604)).setAttribute("estado","false" );
      ((Element)v.get(604)).setAttribute("cod","1254" );
      ((Element)v.get(604)).setAttribute("accion","onClickEliminarTrasv();" );
      ((Element)v.get(604)).setAttribute("onshtab","focalizaEliminarShTab('T');" );
      ((Element)v.get(572)).appendChild((Element)v.get(604));
      /* Termina nodo:604   */

      /* Empieza nodo:605 / Elemento padre: 572   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(605)).setAttribute("nombre","ProcesarTrasv" );
      ((Element)v.get(605)).setAttribute("x","65" );
      ((Element)v.get(605)).setAttribute("y","279" );
      ((Element)v.get(605)).setAttribute("ID","botonContenido" );
      ((Element)v.get(605)).setAttribute("tipo","html" );
      ((Element)v.get(605)).setAttribute("estado","false" );
      ((Element)v.get(605)).setAttribute("cod","3055" );
      ((Element)v.get(605)).setAttribute("accion","fGuardar();" );
      ((Element)v.get(605)).setAttribute("ontab","focalizaProcesarTab();" );
      ((Element)v.get(572)).appendChild((Element)v.get(605));
      /* Termina nodo:605   */
      /* Termina nodo:572   */

      /* Empieza nodo:606 / Elemento padre: 32   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(606)).setAttribute("nombre","capaFusion" );
      ((Element)v.get(606)).setAttribute("ancho","100%" );
      ((Element)v.get(606)).setAttribute("alto","100%" );
      ((Element)v.get(606)).setAttribute("x","0" );
      ((Element)v.get(606)).setAttribute("y","260" );
      ((Element)v.get(606)).setAttribute("colorf","" );
      ((Element)v.get(606)).setAttribute("borde","0" );
      ((Element)v.get(606)).setAttribute("imagenf","" );
      ((Element)v.get(606)).setAttribute("repeat","" );
      ((Element)v.get(606)).setAttribute("padding","" );
      ((Element)v.get(606)).setAttribute("visibilidad","" );
      ((Element)v.get(606)).setAttribute("contravsb","" );
      ((Element)v.get(606)).setAttribute("zindex","" );
      ((Element)v.get(32)).appendChild((Element)v.get(606));

      /* Empieza nodo:607 / Elemento padre: 606   */
      v.add(doc.createElement("table"));
      ((Element)v.get(607)).setAttribute("width","100%" );
      ((Element)v.get(607)).setAttribute("border","0" );
      ((Element)v.get(607)).setAttribute("cellspacing","0" );
      ((Element)v.get(607)).setAttribute("cellpadding","0" );
      ((Element)v.get(606)).appendChild((Element)v.get(607));

      /* Empieza nodo:608 / Elemento padre: 607   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(607)).appendChild((Element)v.get(608));

      /* Empieza nodo:609 / Elemento padre: 608   */
      v.add(doc.createElement("td"));
      ((Element)v.get(609)).setAttribute("width","12" );
      ((Element)v.get(609)).setAttribute("align","center" );
      ((Element)v.get(608)).appendChild((Element)v.get(609));

      /* Empieza nodo:610 / Elemento padre: 609   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(610)).setAttribute("src","b.gif" );
      ((Element)v.get(610)).setAttribute("width","12" );
      ((Element)v.get(610)).setAttribute("height","12" );
      ((Element)v.get(609)).appendChild((Element)v.get(610));
      /* Termina nodo:610   */
      /* Termina nodo:609   */

      /* Empieza nodo:611 / Elemento padre: 608   */
      v.add(doc.createElement("td"));
      ((Element)v.get(611)).setAttribute("width","750" );
      ((Element)v.get(608)).appendChild((Element)v.get(611));

      /* Empieza nodo:612 / Elemento padre: 611   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(612)).setAttribute("src","b.gif" );
      ((Element)v.get(611)).appendChild((Element)v.get(612));
      /* Termina nodo:612   */
      /* Termina nodo:611   */

      /* Empieza nodo:613 / Elemento padre: 608   */
      v.add(doc.createElement("td"));
      ((Element)v.get(613)).setAttribute("width","12" );
      ((Element)v.get(608)).appendChild((Element)v.get(613));

      /* Empieza nodo:614 / Elemento padre: 613   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(614)).setAttribute("src","b.gif" );
      ((Element)v.get(614)).setAttribute("width","12" );
      ((Element)v.get(614)).setAttribute("height","1" );
      ((Element)v.get(613)).appendChild((Element)v.get(614));
      /* Termina nodo:614   */
      /* Termina nodo:613   */
      /* Termina nodo:608   */

      /* Empieza nodo:615 / Elemento padre: 607   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(607)).appendChild((Element)v.get(615));

      /* Empieza nodo:616 / Elemento padre: 615   */
      v.add(doc.createElement("td"));
      ((Element)v.get(615)).appendChild((Element)v.get(616));

      /* Empieza nodo:617 / Elemento padre: 616   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(617)).setAttribute("src","b.gif" );
      ((Element)v.get(616)).appendChild((Element)v.get(617));
      /* Termina nodo:617   */
      /* Termina nodo:616   */

      /* Empieza nodo:618 / Elemento padre: 615   */
      v.add(doc.createElement("td"));
      ((Element)v.get(615)).appendChild((Element)v.get(618));

      /* Empieza nodo:619 / Elemento padre: 618   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(618)).appendChild((Element)v.get(619));

      /* Empieza nodo:620 / Elemento padre: 619   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(620)).setAttribute("class","legend" );
      ((Element)v.get(619)).appendChild((Element)v.get(620));

      /* Empieza nodo:621 / Elemento padre: 620   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(621)).setAttribute("nombre","lblFusion" );
      ((Element)v.get(621)).setAttribute("alto","13" );
      ((Element)v.get(621)).setAttribute("filas","1" );
      ((Element)v.get(621)).setAttribute("cod","3222" );
      ((Element)v.get(621)).setAttribute("id","legend" );
      ((Element)v.get(620)).appendChild((Element)v.get(621));
      /* Termina nodo:621   */
      /* Termina nodo:620   */

      /* Empieza nodo:622 / Elemento padre: 619   */
      v.add(doc.createElement("table"));
      ((Element)v.get(622)).setAttribute("width","100%" );
      ((Element)v.get(622)).setAttribute("border","0" );
      ((Element)v.get(622)).setAttribute("align","center" );
      ((Element)v.get(622)).setAttribute("cellspacing","0" );
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(622)).setAttribute("cellpadding","0" );
      ((Element)v.get(619)).appendChild((Element)v.get(622));

      /* Empieza nodo:623 / Elemento padre: 622   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(622)).appendChild((Element)v.get(623));

      /* Empieza nodo:624 / Elemento padre: 623   */
      v.add(doc.createElement("td"));
      ((Element)v.get(624)).setAttribute("colspan","7" );
      ((Element)v.get(623)).appendChild((Element)v.get(624));

      /* Empieza nodo:625 / Elemento padre: 624   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(625)).setAttribute("src","b.gif" );
      ((Element)v.get(625)).setAttribute("width","8" );
      ((Element)v.get(625)).setAttribute("height","8" );
      ((Element)v.get(624)).appendChild((Element)v.get(625));
      /* Termina nodo:625   */
      /* Termina nodo:624   */
      /* Termina nodo:623   */

      /* Empieza nodo:626 / Elemento padre: 622   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(622)).appendChild((Element)v.get(626));

      /* Empieza nodo:627 / Elemento padre: 626   */
      v.add(doc.createElement("td"));
      ((Element)v.get(626)).appendChild((Element)v.get(627));

      /* Empieza nodo:628 / Elemento padre: 627   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(628)).setAttribute("src","b.gif" );
      ((Element)v.get(628)).setAttribute("width","8" );
      ((Element)v.get(628)).setAttribute("height","8" );
      ((Element)v.get(627)).appendChild((Element)v.get(628));
      /* Termina nodo:628   */
      /* Termina nodo:627   */

      /* Empieza nodo:629 / Elemento padre: 626   */
      v.add(doc.createElement("td"));
      ((Element)v.get(626)).appendChild((Element)v.get(629));

      /* Empieza nodo:630 / Elemento padre: 629   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(630)).setAttribute("nombre","lblTerr1Fusionar" );
      ((Element)v.get(630)).setAttribute("alto","13" );
      ((Element)v.get(630)).setAttribute("filas","1" );
      ((Element)v.get(630)).setAttribute("valor","" );
      ((Element)v.get(630)).setAttribute("id","datosTitle" );
      ((Element)v.get(630)).setAttribute("cod","3223" );
      ((Element)v.get(629)).appendChild((Element)v.get(630));
      /* Termina nodo:630   */
      /* Termina nodo:629   */

      /* Empieza nodo:631 / Elemento padre: 626   */
      v.add(doc.createElement("td"));
      ((Element)v.get(626)).appendChild((Element)v.get(631));

      /* Empieza nodo:632 / Elemento padre: 631   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(632)).setAttribute("src","b.gif" );
      ((Element)v.get(632)).setAttribute("width","25" );
      ((Element)v.get(632)).setAttribute("height","8" );
      ((Element)v.get(631)).appendChild((Element)v.get(632));
      /* Termina nodo:632   */
      /* Termina nodo:631   */

      /* Empieza nodo:633 / Elemento padre: 626   */
      v.add(doc.createElement("td"));
      ((Element)v.get(626)).appendChild((Element)v.get(633));

      /* Empieza nodo:634 / Elemento padre: 633   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(634)).setAttribute("nombre","lblTerr2Fusionar" );
      ((Element)v.get(634)).setAttribute("alto","13" );
      ((Element)v.get(634)).setAttribute("filas","1" );
      ((Element)v.get(634)).setAttribute("valor","" );
      ((Element)v.get(634)).setAttribute("id","datosTitle" );
      ((Element)v.get(634)).setAttribute("cod","3224" );
      ((Element)v.get(633)).appendChild((Element)v.get(634));
      /* Termina nodo:634   */
      /* Termina nodo:633   */

      /* Empieza nodo:635 / Elemento padre: 626   */
      v.add(doc.createElement("td"));
      ((Element)v.get(626)).appendChild((Element)v.get(635));

      /* Empieza nodo:636 / Elemento padre: 635   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(636)).setAttribute("src","b.gif" );
      ((Element)v.get(636)).setAttribute("width","8" );
      ((Element)v.get(636)).setAttribute("height","8" );
      ((Element)v.get(635)).appendChild((Element)v.get(636));
      /* Termina nodo:636   */
      /* Termina nodo:635   */

      /* Empieza nodo:637 / Elemento padre: 626   */
      v.add(doc.createElement("td"));
      ((Element)v.get(637)).setAttribute("width","100%" );
      ((Element)v.get(626)).appendChild((Element)v.get(637));

      /* Empieza nodo:638 / Elemento padre: 637   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(638)).setAttribute("src","b.gif" );
      ((Element)v.get(638)).setAttribute("width","8" );
      ((Element)v.get(638)).setAttribute("height","8" );
      ((Element)v.get(637)).appendChild((Element)v.get(638));
      /* Termina nodo:638   */
      /* Termina nodo:637   */

      /* Empieza nodo:639 / Elemento padre: 626   */
      v.add(doc.createElement("td"));
      ((Element)v.get(639)).setAttribute("width","100%" );
      ((Element)v.get(626)).appendChild((Element)v.get(639));

      /* Empieza nodo:640 / Elemento padre: 639   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(640)).setAttribute("src","b.gif" );
      ((Element)v.get(640)).setAttribute("width","8" );
      ((Element)v.get(640)).setAttribute("height","8" );
      ((Element)v.get(639)).appendChild((Element)v.get(640));
      /* Termina nodo:640   */
      /* Termina nodo:639   */
      /* Termina nodo:626   */

      /* Empieza nodo:641 / Elemento padre: 622   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(622)).appendChild((Element)v.get(641));

      /* Empieza nodo:642 / Elemento padre: 641   */
      v.add(doc.createElement("td"));
      ((Element)v.get(641)).appendChild((Element)v.get(642));

      /* Empieza nodo:643 / Elemento padre: 642   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(643)).setAttribute("src","b.gif" );
      ((Element)v.get(643)).setAttribute("width","8" );
      ((Element)v.get(643)).setAttribute("height","8" );
      ((Element)v.get(642)).appendChild((Element)v.get(643));
      /* Termina nodo:643   */
      /* Termina nodo:642   */

      /* Empieza nodo:644 / Elemento padre: 641   */
      v.add(doc.createElement("td"));
      ((Element)v.get(644)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(641)).appendChild((Element)v.get(644));

      /* Empieza nodo:645 / Elemento padre: 644   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(645)).setAttribute("nombre","cbTerr1Fusionar" );
      ((Element)v.get(645)).setAttribute("id","datosCampos" );
      ((Element)v.get(645)).setAttribute("size","1" );
      ((Element)v.get(645)).setAttribute("multiple","N" );
      ((Element)v.get(645)).setAttribute("req","S" );
      ((Element)v.get(645)).setAttribute("onchange","" );
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(645)).setAttribute("valorinicial","" );
      ((Element)v.get(645)).setAttribute("textoinicial","" );
      ((Element)v.get(644)).appendChild((Element)v.get(645));

      /* Empieza nodo:646 / Elemento padre: 645   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(645)).appendChild((Element)v.get(646));
      /* Termina nodo:646   */
      /* Termina nodo:645   */
      /* Termina nodo:644   */

      /* Empieza nodo:647 / Elemento padre: 641   */
      v.add(doc.createElement("td"));
      ((Element)v.get(641)).appendChild((Element)v.get(647));

      /* Empieza nodo:648 / Elemento padre: 647   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(648)).setAttribute("src","b.gif" );
      ((Element)v.get(648)).setAttribute("width","25" );
      ((Element)v.get(648)).setAttribute("height","8" );
      ((Element)v.get(647)).appendChild((Element)v.get(648));
      /* Termina nodo:648   */
      /* Termina nodo:647   */

      /* Empieza nodo:649 / Elemento padre: 641   */
      v.add(doc.createElement("td"));
      ((Element)v.get(649)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(641)).appendChild((Element)v.get(649));

      /* Empieza nodo:650 / Elemento padre: 649   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(650)).setAttribute("nombre","cbTerr2Fusionar" );
      ((Element)v.get(650)).setAttribute("id","datosCampos" );
      ((Element)v.get(650)).setAttribute("size","1" );
      ((Element)v.get(650)).setAttribute("multiple","N" );
      ((Element)v.get(650)).setAttribute("req","S" );
      ((Element)v.get(650)).setAttribute("onchange","" );
      ((Element)v.get(650)).setAttribute("valorinicial","" );
      ((Element)v.get(650)).setAttribute("textoinicial","" );
      ((Element)v.get(649)).appendChild((Element)v.get(650));

      /* Empieza nodo:651 / Elemento padre: 650   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(650)).appendChild((Element)v.get(651));
      /* Termina nodo:651   */
      /* Termina nodo:650   */
      /* Termina nodo:649   */

      /* Empieza nodo:652 / Elemento padre: 641   */
      v.add(doc.createElement("td"));
      ((Element)v.get(641)).appendChild((Element)v.get(652));

      /* Empieza nodo:653 / Elemento padre: 652   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(653)).setAttribute("src","b.gif" );
      ((Element)v.get(653)).setAttribute("width","8" );
      ((Element)v.get(653)).setAttribute("height","8" );
      ((Element)v.get(652)).appendChild((Element)v.get(653));
      /* Termina nodo:653   */
      /* Termina nodo:652   */

      /* Empieza nodo:654 / Elemento padre: 641   */
      v.add(doc.createElement("td"));
      ((Element)v.get(654)).setAttribute("width","100%" );
      ((Element)v.get(641)).appendChild((Element)v.get(654));

      /* Empieza nodo:655 / Elemento padre: 654   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(655)).setAttribute("src","b.gif" );
      ((Element)v.get(655)).setAttribute("width","8" );
      ((Element)v.get(655)).setAttribute("height","8" );
      ((Element)v.get(654)).appendChild((Element)v.get(655));
      /* Termina nodo:655   */
      /* Termina nodo:654   */

      /* Empieza nodo:656 / Elemento padre: 641   */
      v.add(doc.createElement("td"));
      ((Element)v.get(656)).setAttribute("width","100%" );
      ((Element)v.get(641)).appendChild((Element)v.get(656));

      /* Empieza nodo:657 / Elemento padre: 656   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(657)).setAttribute("src","b.gif" );
      ((Element)v.get(657)).setAttribute("width","8" );
      ((Element)v.get(657)).setAttribute("height","8" );
      ((Element)v.get(656)).appendChild((Element)v.get(657));
      /* Termina nodo:657   */
      /* Termina nodo:656   */
      /* Termina nodo:641   */

      /* Empieza nodo:658 / Elemento padre: 622   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(622)).appendChild((Element)v.get(658));

      /* Empieza nodo:659 / Elemento padre: 658   */
      v.add(doc.createElement("td"));
      ((Element)v.get(659)).setAttribute("colspan","7" );
      ((Element)v.get(658)).appendChild((Element)v.get(659));

      /* Empieza nodo:660 / Elemento padre: 659   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(660)).setAttribute("src","b.gif" );
      ((Element)v.get(660)).setAttribute("width","8" );
      ((Element)v.get(660)).setAttribute("height","8" );
      ((Element)v.get(659)).appendChild((Element)v.get(660));
      /* Termina nodo:660   */
      /* Termina nodo:659   */
      /* Termina nodo:658   */

      /* Empieza nodo:661 / Elemento padre: 622   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(622)).appendChild((Element)v.get(661));

      /* Empieza nodo:662 / Elemento padre: 661   */
      v.add(doc.createElement("td"));
      ((Element)v.get(662)).setAttribute("colspan","7" );
      ((Element)v.get(661)).appendChild((Element)v.get(662));

      /* Empieza nodo:663 / Elemento padre: 662   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(663)).setAttribute("src","b.gif" );
      ((Element)v.get(663)).setAttribute("width","8" );
      ((Element)v.get(663)).setAttribute("height","8" );
      ((Element)v.get(662)).appendChild((Element)v.get(663));
      /* Termina nodo:663   */
      /* Termina nodo:662   */
      /* Termina nodo:661   */

      /* Empieza nodo:664 / Elemento padre: 622   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(622)).appendChild((Element)v.get(664));

      /* Empieza nodo:665 / Elemento padre: 664   */
      v.add(doc.createElement("td"));
      ((Element)v.get(664)).appendChild((Element)v.get(665));

      /* Empieza nodo:666 / Elemento padre: 665   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(666)).setAttribute("src","b.gif" );
      ((Element)v.get(666)).setAttribute("width","8" );
      ((Element)v.get(666)).setAttribute("height","8" );
      ((Element)v.get(665)).appendChild((Element)v.get(666));
      /* Termina nodo:666   */
      /* Termina nodo:665   */

      /* Empieza nodo:667 / Elemento padre: 664   */
      v.add(doc.createElement("td"));
      ((Element)v.get(664)).appendChild((Element)v.get(667));

      /* Empieza nodo:668 / Elemento padre: 667   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(668)).setAttribute("nombre","lblTerrCrearF" );
      ((Element)v.get(668)).setAttribute("alto","13" );
      ((Element)v.get(668)).setAttribute("filas","1" );
      ((Element)v.get(668)).setAttribute("valor","" );
      ((Element)v.get(668)).setAttribute("id","datosTitle" );
      ((Element)v.get(668)).setAttribute("cod","3199" );
      ((Element)v.get(667)).appendChild((Element)v.get(668));
      /* Termina nodo:668   */
      /* Termina nodo:667   */

      /* Empieza nodo:669 / Elemento padre: 664   */
      v.add(doc.createElement("td"));
   }

   private void getXML2880(Document doc) {
      ((Element)v.get(664)).appendChild((Element)v.get(669));

      /* Empieza nodo:670 / Elemento padre: 669   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(670)).setAttribute("src","b.gif" );
      ((Element)v.get(670)).setAttribute("width","8" );
      ((Element)v.get(670)).setAttribute("height","8" );
      ((Element)v.get(669)).appendChild((Element)v.get(670));
      /* Termina nodo:670   */
      /* Termina nodo:669   */

      /* Empieza nodo:671 / Elemento padre: 664   */
      v.add(doc.createElement("td"));
      ((Element)v.get(664)).appendChild((Element)v.get(671));

      /* Empieza nodo:672 / Elemento padre: 671   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(672)).setAttribute("nombre","lblNSE1F" );
      ((Element)v.get(672)).setAttribute("alto","13" );
      ((Element)v.get(672)).setAttribute("filas","1" );
      ((Element)v.get(672)).setAttribute("valor","" );
      ((Element)v.get(672)).setAttribute("id","datosTitle" );
      ((Element)v.get(672)).setAttribute("cod","3200" );
      ((Element)v.get(671)).appendChild((Element)v.get(672));
      /* Termina nodo:672   */
      /* Termina nodo:671   */

      /* Empieza nodo:673 / Elemento padre: 664   */
      v.add(doc.createElement("td"));
      ((Element)v.get(664)).appendChild((Element)v.get(673));

      /* Empieza nodo:674 / Elemento padre: 673   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(674)).setAttribute("src","b.gif" );
      ((Element)v.get(674)).setAttribute("width","25" );
      ((Element)v.get(674)).setAttribute("height","8" );
      ((Element)v.get(673)).appendChild((Element)v.get(674));
      /* Termina nodo:674   */
      /* Termina nodo:673   */

      /* Empieza nodo:675 / Elemento padre: 664   */
      v.add(doc.createElement("td"));
      ((Element)v.get(664)).appendChild((Element)v.get(675));

      /* Empieza nodo:676 / Elemento padre: 675   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(676)).setAttribute("nombre","lblNSE2F" );
      ((Element)v.get(676)).setAttribute("alto","13" );
      ((Element)v.get(676)).setAttribute("filas","1" );
      ((Element)v.get(676)).setAttribute("valor","" );
      ((Element)v.get(676)).setAttribute("id","datosTitle" );
      ((Element)v.get(676)).setAttribute("cod","3201" );
      ((Element)v.get(675)).appendChild((Element)v.get(676));
      /* Termina nodo:676   */
      /* Termina nodo:675   */

      /* Empieza nodo:677 / Elemento padre: 664   */
      v.add(doc.createElement("td"));
      ((Element)v.get(677)).setAttribute("width","100%" );
      ((Element)v.get(664)).appendChild((Element)v.get(677));

      /* Empieza nodo:678 / Elemento padre: 677   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(678)).setAttribute("src","b.gif" );
      ((Element)v.get(678)).setAttribute("width","8" );
      ((Element)v.get(678)).setAttribute("height","8" );
      ((Element)v.get(677)).appendChild((Element)v.get(678));
      /* Termina nodo:678   */
      /* Termina nodo:677   */
      /* Termina nodo:664   */

      /* Empieza nodo:679 / Elemento padre: 622   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(622)).appendChild((Element)v.get(679));

      /* Empieza nodo:680 / Elemento padre: 679   */
      v.add(doc.createElement("td"));
      ((Element)v.get(679)).appendChild((Element)v.get(680));

      /* Empieza nodo:681 / Elemento padre: 680   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(681)).setAttribute("src","b.gif" );
      ((Element)v.get(681)).setAttribute("width","8" );
      ((Element)v.get(681)).setAttribute("height","8" );
      ((Element)v.get(680)).appendChild((Element)v.get(681));
      /* Termina nodo:681   */
      /* Termina nodo:680   */

      /* Empieza nodo:682 / Elemento padre: 679   */
      v.add(doc.createElement("td"));
      ((Element)v.get(682)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(679)).appendChild((Element)v.get(682));

      /* Empieza nodo:683 / Elemento padre: 682   */
      v.add(doc.createElement("CTEXTO"));
      ((Element)v.get(683)).setAttribute("nombre","txtTerrCrearFusion" );
      ((Element)v.get(683)).setAttribute("id","datosCampos" );
      ((Element)v.get(683)).setAttribute("max","6" );
      ((Element)v.get(683)).setAttribute("tipo","" );
      ((Element)v.get(683)).setAttribute("onchange","" );
      ((Element)v.get(683)).setAttribute("req","S" );
      ((Element)v.get(683)).setAttribute("size","10" );
      ((Element)v.get(683)).setAttribute("valor","" );
      ((Element)v.get(683)).setAttribute("validacion","" );
      ((Element)v.get(682)).appendChild((Element)v.get(683));
      /* Termina nodo:683   */
      /* Termina nodo:682   */

      /* Empieza nodo:684 / Elemento padre: 679   */
      v.add(doc.createElement("td"));
      ((Element)v.get(679)).appendChild((Element)v.get(684));

      /* Empieza nodo:685 / Elemento padre: 684   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(685)).setAttribute("src","b.gif" );
      ((Element)v.get(685)).setAttribute("width","8" );
      ((Element)v.get(685)).setAttribute("height","8" );
      ((Element)v.get(684)).appendChild((Element)v.get(685));
      /* Termina nodo:685   */
      /* Termina nodo:684   */

      /* Empieza nodo:686 / Elemento padre: 679   */
      v.add(doc.createElement("td"));
      ((Element)v.get(686)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(679)).appendChild((Element)v.get(686));

      /* Empieza nodo:687 / Elemento padre: 686   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(687)).setAttribute("nombre","cbNSE1Fusion" );
      ((Element)v.get(687)).setAttribute("id","datosCampos" );
      ((Element)v.get(687)).setAttribute("size","1" );
      ((Element)v.get(687)).setAttribute("multiple","N" );
      ((Element)v.get(687)).setAttribute("req","S" );
      ((Element)v.get(687)).setAttribute("valorinicial","" );
      ((Element)v.get(687)).setAttribute("textoinicial","" );
      ((Element)v.get(687)).setAttribute("onchange","" );
      ((Element)v.get(686)).appendChild((Element)v.get(687));

      /* Empieza nodo:688 / Elemento padre: 687   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(687)).appendChild((Element)v.get(688));
      /* Termina nodo:688   */
      /* Termina nodo:687   */
      /* Termina nodo:686   */

      /* Empieza nodo:689 / Elemento padre: 679   */
      v.add(doc.createElement("td"));
      ((Element)v.get(679)).appendChild((Element)v.get(689));

      /* Empieza nodo:690 / Elemento padre: 689   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(690)).setAttribute("src","b.gif" );
   }

   private void getXML2970(Document doc) {
      ((Element)v.get(690)).setAttribute("width","25" );
      ((Element)v.get(690)).setAttribute("height","8" );
      ((Element)v.get(689)).appendChild((Element)v.get(690));
      /* Termina nodo:690   */
      /* Termina nodo:689   */

      /* Empieza nodo:691 / Elemento padre: 679   */
      v.add(doc.createElement("td"));
      ((Element)v.get(691)).setAttribute("nowrap","nowrap" );
      ((Element)v.get(679)).appendChild((Element)v.get(691));

      /* Empieza nodo:692 / Elemento padre: 691   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(692)).setAttribute("nombre","cbNSE2Fusion" );
      ((Element)v.get(692)).setAttribute("id","datosCampos" );
      ((Element)v.get(692)).setAttribute("size","1" );
      ((Element)v.get(692)).setAttribute("multiple","N" );
      ((Element)v.get(692)).setAttribute("req","S" );
      ((Element)v.get(692)).setAttribute("valorinicial","" );
      ((Element)v.get(692)).setAttribute("textoinicial","" );
      ((Element)v.get(692)).setAttribute("onchange","" );
      ((Element)v.get(691)).appendChild((Element)v.get(692));

      /* Empieza nodo:693 / Elemento padre: 692   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(692)).appendChild((Element)v.get(693));
      /* Termina nodo:693   */
      /* Termina nodo:692   */
      /* Termina nodo:691   */

      /* Empieza nodo:694 / Elemento padre: 679   */
      v.add(doc.createElement("td"));
      ((Element)v.get(694)).setAttribute("width","100%" );
      ((Element)v.get(679)).appendChild((Element)v.get(694));

      /* Empieza nodo:695 / Elemento padre: 694   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(695)).setAttribute("src","b.gif" );
      ((Element)v.get(695)).setAttribute("width","8" );
      ((Element)v.get(695)).setAttribute("height","8" );
      ((Element)v.get(694)).appendChild((Element)v.get(695));
      /* Termina nodo:695   */
      /* Termina nodo:694   */
      /* Termina nodo:679   */

      /* Empieza nodo:696 / Elemento padre: 622   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(622)).appendChild((Element)v.get(696));

      /* Empieza nodo:697 / Elemento padre: 696   */
      v.add(doc.createElement("td"));
      ((Element)v.get(697)).setAttribute("colspan","7" );
      ((Element)v.get(696)).appendChild((Element)v.get(697));

      /* Empieza nodo:698 / Elemento padre: 697   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(698)).setAttribute("src","b.gif" );
      ((Element)v.get(698)).setAttribute("width","8" );
      ((Element)v.get(698)).setAttribute("height","8" );
      ((Element)v.get(697)).appendChild((Element)v.get(698));
      /* Termina nodo:698   */
      /* Termina nodo:697   */
      /* Termina nodo:696   */
      /* Termina nodo:622   */
      /* Termina nodo:619   */

      /* Empieza nodo:699 / Elemento padre: 618   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(618)).appendChild((Element)v.get(699));

      /* Empieza nodo:700 / Elemento padre: 699   */
      v.add(doc.createElement("table"));
      ((Element)v.get(700)).setAttribute("width","100%" );
      ((Element)v.get(700)).setAttribute("border","0" );
      ((Element)v.get(700)).setAttribute("align","center" );
      ((Element)v.get(700)).setAttribute("cellspacing","0" );
      ((Element)v.get(700)).setAttribute("cellpadding","0" );
      ((Element)v.get(699)).appendChild((Element)v.get(700));

      /* Empieza nodo:701 / Elemento padre: 700   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(700)).appendChild((Element)v.get(701));

      /* Empieza nodo:702 / Elemento padre: 701   */
      v.add(doc.createElement("td"));
      ((Element)v.get(702)).setAttribute("class","botonera" );
      ((Element)v.get(701)).appendChild((Element)v.get(702));

      /* Empieza nodo:703 / Elemento padre: 702   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(703)).setAttribute("nombre","ProcesarFusion" );
      ((Element)v.get(703)).setAttribute("ID","botonContenido" );
      ((Element)v.get(703)).setAttribute("tipo","html" );
      ((Element)v.get(703)).setAttribute("accion","fGuardar();" );
      ((Element)v.get(703)).setAttribute("estado","false" );
      ((Element)v.get(703)).setAttribute("cod","3055" );
      ((Element)v.get(703)).setAttribute("ontab","focalizaProcesarTab();" );
      ((Element)v.get(702)).appendChild((Element)v.get(703));
      /* Termina nodo:703   */
      /* Termina nodo:702   */
      /* Termina nodo:701   */
      /* Termina nodo:700   */
      /* Termina nodo:699   */
      /* Termina nodo:618   */
      /* Termina nodo:615   */
      /* Termina nodo:607   */
      /* Termina nodo:606   */
      /* Termina nodo:32   */


   }

}

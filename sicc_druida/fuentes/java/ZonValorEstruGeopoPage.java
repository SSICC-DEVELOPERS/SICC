
import org.w3c.dom.*;
import java.util.ArrayList;

public class ZonValorEstruGeopoPage  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","ZonValorEstruGeopoPage" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","zonValorEstruGeopoInitComponents()" );
      ((Element)v.get(0)).setAttribute("xml:lang","es" );
      ((Element)v.get(0)).setAttribute("cod","" );
      ((Element)v.get(0)).setAttribute("repeat","N" );

      /* Empieza nodo:1 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(1)).setAttribute("src","sicc_util.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(1));
      /* Termina nodo:1   */

      /* Empieza nodo:2 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(2)).setAttribute("src","mmg.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","zonvalorestrugeopo.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(4)).setAttribute("nombre","zonValorEstruGeopoFrm" );
      ((Element)v.get(4)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(5)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(5)).setAttribute("valor","ZonValorEstruGeopoLPExecution" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","ON" );
      ((Element)v.get(6)).setAttribute("valor","ZonValorEstruGeopoLPExecution" );
      ((Element)v.get(4)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","accion" );
      ((Element)v.get(7)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","origen" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","idSelection" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","idAttributeLovOpener" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","idEntityLovOpener" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","timestamp" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","windowTitleCode" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","userLanguageCode" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","defaultLanguageCode" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","pageLaguage" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","lastQueryToSession" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","previousAction" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","performRequery" );
      ((Element)v.get(19)).setAttribute("valor","false" );
      ((Element)v.get(4)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","applyStructuralEntity" );
      ((Element)v.get(20)).setAttribute("valor","true" );
      ((Element)v.get(4)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(21)).setAttribute("valor","" );
   }

   private void getXML90(Document doc) {
      ((Element)v.get(4)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","errSeverity" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","structuralDefaultPais" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","structuralDefaultSociedad" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","structuralDefaultMarca" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","structuralDefaultCanal" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","structuralDefaultAcceso" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","structuralDefaultSubacceso" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","structuralDefaultSubgerenciaVentas" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","structuralDefaultRegion" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","structuralDefaultZona" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","structuralDefaultSeccion" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","structuralDefaultTerritorio" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","clientCodeSize" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(4)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(36)).setAttribute("nombre","zonValorEstruGeopoFormLayer" );
      ((Element)v.get(36)).setAttribute("alto","" );
      ((Element)v.get(36)).setAttribute("ancho","100%" );
      ((Element)v.get(36)).setAttribute("colorf","" );
      ((Element)v.get(36)).setAttribute("borde","0" );
      ((Element)v.get(36)).setAttribute("imagenf","" );
      ((Element)v.get(36)).setAttribute("repeat","" );
      ((Element)v.get(36)).setAttribute("padding","" );
      ((Element)v.get(36)).setAttribute("visibilidad","visible" );
      ((Element)v.get(36)).setAttribute("contravsb","" );
      ((Element)v.get(36)).setAttribute("x","0" );
      ((Element)v.get(36)).setAttribute("y","0" );
      ((Element)v.get(36)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(37)).setAttribute("width","100%" );
      ((Element)v.get(37)).setAttribute("border","0" );
      ((Element)v.get(37)).setAttribute("cellspacing","0" );
      ((Element)v.get(37)).setAttribute("cellpadding","0" );
      ((Element)v.get(37)).setAttribute("align","left" );
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(39)).setAttribute("align","center" );
      ((Element)v.get(39)).setAttribute("width","12" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(40)).setAttribute("src","b.gif" );
      ((Element)v.get(40)).setAttribute("width","12" );
      ((Element)v.get(40)).setAttribute("height","12" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));
      /* Termina nodo:40   */
      /* Termina nodo:39   */

      /* Empieza nodo:41 / Elemento padre: 38   */
   }

   private void getXML180(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(41)).setAttribute("align","center" );
      ((Element)v.get(41)).setAttribute("width","750" );
      ((Element)v.get(38)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(42)).setAttribute("src","b.gif" );
      ((Element)v.get(42)).setAttribute("width","12" );
      ((Element)v.get(42)).setAttribute("height","12" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:43 / Elemento padre: 38   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(43)).setAttribute("align","center" );
      ((Element)v.get(43)).setAttribute("width","12" );
      ((Element)v.get(38)).appendChild((Element)v.get(43));

      /* Empieza nodo:44 / Elemento padre: 43   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(44)).setAttribute("src","b.gif" );
      ((Element)v.get(44)).setAttribute("width","12" );
      ((Element)v.get(44)).setAttribute("height","12" );
      ((Element)v.get(43)).appendChild((Element)v.get(44));
      /* Termina nodo:44   */
      /* Termina nodo:43   */
      /* Termina nodo:38   */

      /* Empieza nodo:45 / Elemento padre: 37   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(37)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(46)).setAttribute("align","center" );
      ((Element)v.get(46)).setAttribute("width","12" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(47)).setAttribute("src","b.gif" );
      ((Element)v.get(47)).setAttribute("width","12" );
      ((Element)v.get(47)).setAttribute("height","8" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));
      /* Termina nodo:47   */
      /* Termina nodo:46   */

      /* Empieza nodo:48 / Elemento padre: 45   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(48)).setAttribute("width","100%" );
      ((Element)v.get(45)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(50)).setAttribute("class","legend" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(51)).setAttribute("nombre","legendLbl" );
      ((Element)v.get(51)).setAttribute("alto","13" );
      ((Element)v.get(51)).setAttribute("filas","1" );
      ((Element)v.get(51)).setAttribute("id","legend" );
      ((Element)v.get(51)).setAttribute("valor","" );
      ((Element)v.get(51)).setAttribute("cod","ZonValorEstruGeopo.legend.label" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:52 / Elemento padre: 49   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(52)).setAttribute("width","100%" );
      ((Element)v.get(52)).setAttribute("border","0" );
      ((Element)v.get(52)).setAttribute("align","center" );
      ((Element)v.get(52)).setAttribute("cellspacing","0" );
      ((Element)v.get(52)).setAttribute("cellpadding","0" );
      ((Element)v.get(49)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(54)).setAttribute("width","100%" );
      ((Element)v.get(54)).setAttribute("nowrap","true" );
      ((Element)v.get(54)).setAttribute("class","datosCampos" );
      ((Element)v.get(54)).setAttribute("colspan","3" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(55)).setAttribute("src","b.gif" );
      ((Element)v.get(55)).setAttribute("width","8" );
      ((Element)v.get(55)).setAttribute("height","8" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));
      /* Termina nodo:55   */
      /* Termina nodo:54   */
      /* Termina nodo:53   */

      /* Empieza nodo:56 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(56)).setAttribute("nombre","formTr0" );
      ((Element)v.get(52)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(57)).setAttribute("align","center" );
      ((Element)v.get(57)).setAttribute("width","8" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(58)).setAttribute("src","b.gif" );
      ((Element)v.get(58)).setAttribute("width","8" );
      ((Element)v.get(58)).setAttribute("height","12" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));
      /* Termina nodo:58   */
      /* Termina nodo:57   */

      /* Empieza nodo:59 / Elemento padre: 56   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(59)).setAttribute("width","100%" );
      ((Element)v.get(56)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(60)).setAttribute("width","100%" );
      ((Element)v.get(60)).setAttribute("border","0" );
      ((Element)v.get(60)).setAttribute("cellspacing","0" );
      ((Element)v.get(60)).setAttribute("cellpadding","0" );
      ((Element)v.get(60)).setAttribute("align","left" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(61)).setAttribute("align","left" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(62)).setAttribute("nombre","idTdId" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(63)).setAttribute("width","100%" );
      ((Element)v.get(63)).setAttribute("border","0" );
      ((Element)v.get(63)).setAttribute("cellspacing","0" );
      ((Element)v.get(63)).setAttribute("cellpadding","0" );
      ((Element)v.get(63)).setAttribute("align","left" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(65)).setAttribute("valign","top" );
      ((Element)v.get(65)).setAttribute("height","13" );
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(66)).setAttribute("nombre","lblId" );
      ((Element)v.get(66)).setAttribute("alto","13" );
      ((Element)v.get(66)).setAttribute("filas","1" );
      ((Element)v.get(66)).setAttribute("id","datosTitle" );
      ((Element)v.get(66)).setAttribute("cod","ZonValorEstruGeopo.id.label" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:67 / Elemento padre: 63   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(67)).setAttribute("nombre","idWidgetTrId" );
      ((Element)v.get(63)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(68)).setAttribute("align","left" );
      ((Element)v.get(68)).setAttribute("nowrap","true" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(69)).setAttribute("nombre","id" );
      ((Element)v.get(69)).setAttribute("id","datosCampos" );
      ((Element)v.get(69)).setAttribute("trim","S" );
      ((Element)v.get(69)).setAttribute("max","12" );
      ((Element)v.get(69)).setAttribute("onchange","" );
      ((Element)v.get(69)).setAttribute("req","N" );
      ((Element)v.get(69)).setAttribute("size","12" );
      ((Element)v.get(69)).setAttribute("valor","" );
      ((Element)v.get(69)).setAttribute("validacion","" );
      ((Element)v.get(69)).setAttribute("disabled","" );
      ((Element)v.get(69)).setAttribute("onblur","" );
      ((Element)v.get(69)).setAttribute("ontab","ejecutarAccionFoco('zonValorEstruGeopoFrm',0, true)" );
      ((Element)v.get(69)).setAttribute("onshtab","ejecutarAccionFoco('zonValorEstruGeopoFrm', 0, false)" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:70 / Elemento padre: 61   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(70)).setAttribute("nombre","idGapTdId" );
      ((Element)v.get(70)).setAttribute("nowrap","true" );
      ((Element)v.get(70)).setAttribute("class","datosCampos" );
      ((Element)v.get(61)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","25" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */

      /* Empieza nodo:72 / Elemento padre: 61   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(72)).setAttribute("width","100%" );
      ((Element)v.get(61)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(73)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));
      /* Termina nodo:73   */
      /* Termina nodo:72   */
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:56   */

      /* Empieza nodo:74 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(74)).setAttribute("nombre","formGapTr0" );
      ((Element)v.get(52)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(75)).setAttribute("align","center" );
      ((Element)v.get(75)).setAttribute("width","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(76)).setAttribute("src","b.gif" );
      ((Element)v.get(76)).setAttribute("width","12" );
      ((Element)v.get(76)).setAttribute("height","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:77 / Elemento padre: 74   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(74)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(78)).setAttribute("src","b.gif" );
      ((Element)v.get(78)).setAttribute("width","8" );
      ((Element)v.get(78)).setAttribute("height","8" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));
      /* Termina nodo:78   */
      /* Termina nodo:77   */

      /* Empieza nodo:79 / Elemento padre: 74   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(79)).setAttribute("align","center" );
      ((Element)v.get(79)).setAttribute("width","8" );
      ((Element)v.get(74)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(80)).setAttribute("src","b.gif" );
      ((Element)v.get(80)).setAttribute("width","12" );
      ((Element)v.get(80)).setAttribute("height","8" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:74   */

      /* Empieza nodo:81 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(81)).setAttribute("nombre","formTr1" );
      ((Element)v.get(52)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(82)).setAttribute("align","center" );
      ((Element)v.get(82)).setAttribute("width","8" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","8" );
      ((Element)v.get(83)).setAttribute("height","12" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 81   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(84)).setAttribute("width","100%" );
      ((Element)v.get(81)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(85)).setAttribute("width","100%" );
      ((Element)v.get(85)).setAttribute("border","0" );
      ((Element)v.get(85)).setAttribute("cellspacing","0" );
      ((Element)v.get(85)).setAttribute("cellpadding","0" );
      ((Element)v.get(85)).setAttribute("align","left" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(86)).setAttribute("align","left" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(87)).setAttribute("nombre","codUnidGeogTdId" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(88)).setAttribute("width","100%" );
      ((Element)v.get(88)).setAttribute("border","0" );
      ((Element)v.get(88)).setAttribute("cellspacing","0" );
      ((Element)v.get(88)).setAttribute("cellpadding","0" );
      ((Element)v.get(88)).setAttribute("align","left" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(90)).setAttribute("valign","top" );
      ((Element)v.get(90)).setAttribute("height","13" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(91)).setAttribute("nombre","lblCodUnidGeog" );
      ((Element)v.get(91)).setAttribute("alto","13" );
      ((Element)v.get(91)).setAttribute("filas","1" );
      ((Element)v.get(91)).setAttribute("id","datosTitle" );
      ((Element)v.get(91)).setAttribute("cod","ZonValorEstruGeopo.codUnidGeog.label" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:92 / Elemento padre: 88   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(92)).setAttribute("nombre","codUnidGeogWidgetTrId" );
      ((Element)v.get(88)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(93)).setAttribute("align","left" );
      ((Element)v.get(93)).setAttribute("nowrap","true" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(94)).setAttribute("nombre","codUnidGeog" );
      ((Element)v.get(94)).setAttribute("id","datosCampos" );
      ((Element)v.get(94)).setAttribute("trim","S" );
      ((Element)v.get(94)).setAttribute("max","10" );
      ((Element)v.get(94)).setAttribute("onchange","" );
      ((Element)v.get(94)).setAttribute("req","N" );
      ((Element)v.get(94)).setAttribute("size","10" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(94)).setAttribute("validacion","" );
      ((Element)v.get(94)).setAttribute("disabled","" );
      ((Element)v.get(94)).setAttribute("onblur","" );
      ((Element)v.get(94)).setAttribute("ontab","ejecutarAccionFoco('zonValorEstruGeopoFrm',0, true)" );
      ((Element)v.get(94)).setAttribute("onshtab","ejecutarAccionFoco('zonValorEstruGeopoFrm', 0, false)" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:95 / Elemento padre: 86   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(95)).setAttribute("nombre","codUnidGeogGapTdId" );
      ((Element)v.get(95)).setAttribute("nowrap","true" );
      ((Element)v.get(95)).setAttribute("class","datosCampos" );
      ((Element)v.get(86)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(96)).setAttribute("src","b.gif" );
      ((Element)v.get(96)).setAttribute("width","25" );
      ((Element)v.get(96)).setAttribute("height","8" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:97 / Elemento padre: 86   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(97)).setAttribute("width","100%" );
      ((Element)v.get(86)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:81   */

      /* Empieza nodo:99 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(99)).setAttribute("nombre","formGapTr1" );
      ((Element)v.get(52)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(100)).setAttribute("align","center" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(100)).setAttribute("width","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(101)).setAttribute("src","b.gif" );
      ((Element)v.get(101)).setAttribute("width","12" );
      ((Element)v.get(101)).setAttribute("height","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:102 / Elemento padre: 99   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(99)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(103)).setAttribute("src","b.gif" );
      ((Element)v.get(103)).setAttribute("width","8" );
      ((Element)v.get(103)).setAttribute("height","8" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */

      /* Empieza nodo:104 / Elemento padre: 99   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(104)).setAttribute("align","center" );
      ((Element)v.get(104)).setAttribute("width","8" );
      ((Element)v.get(99)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","12" );
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:99   */

      /* Empieza nodo:106 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(106)).setAttribute("nombre","formTr2" );
      ((Element)v.get(52)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(107)).setAttribute("align","center" );
      ((Element)v.get(107)).setAttribute("width","8" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","8" );
      ((Element)v.get(108)).setAttribute("height","12" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 106   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(109)).setAttribute("width","100%" );
      ((Element)v.get(106)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(110)).setAttribute("width","100%" );
      ((Element)v.get(110)).setAttribute("border","0" );
      ((Element)v.get(110)).setAttribute("cellspacing","0" );
      ((Element)v.get(110)).setAttribute("cellpadding","0" );
      ((Element)v.get(110)).setAttribute("align","left" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(111)).setAttribute("align","left" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(112)).setAttribute("nombre","desGeogTdId" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(113)).setAttribute("width","100%" );
      ((Element)v.get(113)).setAttribute("border","0" );
      ((Element)v.get(113)).setAttribute("cellspacing","0" );
      ((Element)v.get(113)).setAttribute("cellpadding","0" );
      ((Element)v.get(113)).setAttribute("align","left" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(115)).setAttribute("valign","top" );
      ((Element)v.get(115)).setAttribute("height","13" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(116)).setAttribute("nombre","lblDesGeog" );
      ((Element)v.get(116)).setAttribute("alto","13" );
      ((Element)v.get(116)).setAttribute("filas","1" );
      ((Element)v.get(116)).setAttribute("id","datosTitle" );
      ((Element)v.get(116)).setAttribute("cod","ZonValorEstruGeopo.desGeog.label" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:117 / Elemento padre: 113   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(117)).setAttribute("nombre","desGeogWidgetTrId" );
      ((Element)v.get(113)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(118)).setAttribute("align","left" );
      ((Element)v.get(118)).setAttribute("nowrap","true" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(119)).setAttribute("nombre","desGeog" );
      ((Element)v.get(119)).setAttribute("id","datosCampos" );
      ((Element)v.get(119)).setAttribute("trim","S" );
      ((Element)v.get(119)).setAttribute("max","40" );
      ((Element)v.get(119)).setAttribute("onchange","" );
      ((Element)v.get(119)).setAttribute("req","N" );
      ((Element)v.get(119)).setAttribute("size","40" );
      ((Element)v.get(119)).setAttribute("valor","" );
      ((Element)v.get(119)).setAttribute("validacion","" );
      ((Element)v.get(119)).setAttribute("disabled","" );
      ((Element)v.get(119)).setAttribute("onblur","" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(119)).setAttribute("ontab","ejecutarAccionFoco('zonValorEstruGeopoFrm',0, true)" );
      ((Element)v.get(119)).setAttribute("onshtab","ejecutarAccionFoco('zonValorEstruGeopoFrm', 0, false)" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:120 / Elemento padre: 111   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(120)).setAttribute("nombre","desGeogGapTdId" );
      ((Element)v.get(120)).setAttribute("nowrap","true" );
      ((Element)v.get(120)).setAttribute("class","datosCampos" );
      ((Element)v.get(111)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(121)).setAttribute("width","25" );
      ((Element)v.get(121)).setAttribute("height","8" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:122 / Elemento padre: 111   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(122)).setAttribute("width","100%" );
      ((Element)v.get(111)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:106   */

      /* Empieza nodo:124 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(124)).setAttribute("nombre","formGapTr2" );
      ((Element)v.get(52)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(125)).setAttribute("align","center" );
      ((Element)v.get(125)).setAttribute("width","8" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","12" );
      ((Element)v.get(126)).setAttribute("height","8" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 124   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(124)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","8" );
      ((Element)v.get(128)).setAttribute("height","8" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 124   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(129)).setAttribute("align","center" );
      ((Element)v.get(129)).setAttribute("width","8" );
      ((Element)v.get(124)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","12" );
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:124   */

      /* Empieza nodo:131 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(131)).setAttribute("nombre","formTr3" );
      ((Element)v.get(52)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(132)).setAttribute("align","center" );
      ((Element)v.get(132)).setAttribute("width","8" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","8" );
      ((Element)v.get(133)).setAttribute("height","12" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 131   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(134)).setAttribute("width","100%" );
      ((Element)v.get(131)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(135)).setAttribute("width","100%" );
      ((Element)v.get(135)).setAttribute("border","0" );
      ((Element)v.get(135)).setAttribute("cellspacing","0" );
      ((Element)v.get(135)).setAttribute("cellpadding","0" );
      ((Element)v.get(135)).setAttribute("align","left" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(136)).setAttribute("align","left" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(137)).setAttribute("nombre","codNse1TdId" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(138)).setAttribute("width","100%" );
      ((Element)v.get(138)).setAttribute("border","0" );
      ((Element)v.get(138)).setAttribute("cellspacing","0" );
      ((Element)v.get(138)).setAttribute("cellpadding","0" );
      ((Element)v.get(138)).setAttribute("align","left" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(140)).setAttribute("valign","top" );
      ((Element)v.get(140)).setAttribute("height","13" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(141)).setAttribute("nombre","lblCodNse1" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(141)).setAttribute("alto","13" );
      ((Element)v.get(141)).setAttribute("filas","1" );
      ((Element)v.get(141)).setAttribute("id","datosTitle" );
      ((Element)v.get(141)).setAttribute("cod","ZonValorEstruGeopo.codNse1.label" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:142 / Elemento padre: 138   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(142)).setAttribute("nombre","codNse1WidgetTrId" );
      ((Element)v.get(138)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(143)).setAttribute("align","left" );
      ((Element)v.get(143)).setAttribute("nowrap","true" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(144)).setAttribute("nombre","codNse1" );
      ((Element)v.get(144)).setAttribute("id","datosCampos" );
      ((Element)v.get(144)).setAttribute("trim","S" );
      ((Element)v.get(144)).setAttribute("max","2" );
      ((Element)v.get(144)).setAttribute("onchange","" );
      ((Element)v.get(144)).setAttribute("req","N" );
      ((Element)v.get(144)).setAttribute("size","2" );
      ((Element)v.get(144)).setAttribute("valor","" );
      ((Element)v.get(144)).setAttribute("validacion","" );
      ((Element)v.get(144)).setAttribute("disabled","" );
      ((Element)v.get(144)).setAttribute("onblur","" );
      ((Element)v.get(144)).setAttribute("ontab","ejecutarAccionFoco('zonValorEstruGeopoFrm',0, true)" );
      ((Element)v.get(144)).setAttribute("onshtab","ejecutarAccionFoco('zonValorEstruGeopoFrm', 0, false)" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:145 / Elemento padre: 136   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(145)).setAttribute("nombre","codNse1GapTdId" );
      ((Element)v.get(145)).setAttribute("nowrap","true" );
      ((Element)v.get(145)).setAttribute("class","datosCampos" );
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
      v.add(doc.createElement("TD"));
      ((Element)v.get(147)).setAttribute("width","100%" );
      ((Element)v.get(136)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(148)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:131   */

      /* Empieza nodo:149 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(149)).setAttribute("nombre","formGapTr3" );
      ((Element)v.get(52)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(150)).setAttribute("align","center" );
      ((Element)v.get(150)).setAttribute("width","8" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).setAttribute("width","12" );
      ((Element)v.get(151)).setAttribute("height","8" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 149   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(149)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","8" );
      ((Element)v.get(153)).setAttribute("height","8" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */

      /* Empieza nodo:154 / Elemento padre: 149   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(154)).setAttribute("align","center" );
      ((Element)v.get(154)).setAttribute("width","8" );
      ((Element)v.get(149)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(155)).setAttribute("src","b.gif" );
      ((Element)v.get(155)).setAttribute("width","12" );
      ((Element)v.get(155)).setAttribute("height","8" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:149   */

      /* Empieza nodo:156 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(156)).setAttribute("nombre","formTr4" );
      ((Element)v.get(52)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(157)).setAttribute("align","center" );
      ((Element)v.get(157)).setAttribute("width","8" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(158)).setAttribute("width","8" );
      ((Element)v.get(158)).setAttribute("height","12" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 156   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(159)).setAttribute("width","100%" );
      ((Element)v.get(156)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(160)).setAttribute("width","100%" );
      ((Element)v.get(160)).setAttribute("border","0" );
      ((Element)v.get(160)).setAttribute("cellspacing","0" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(160)).setAttribute("cellpadding","0" );
      ((Element)v.get(160)).setAttribute("align","left" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(161)).setAttribute("align","left" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(162)).setAttribute("nombre","codNse2TdId" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(163)).setAttribute("width","100%" );
      ((Element)v.get(163)).setAttribute("border","0" );
      ((Element)v.get(163)).setAttribute("cellspacing","0" );
      ((Element)v.get(163)).setAttribute("cellpadding","0" );
      ((Element)v.get(163)).setAttribute("align","left" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(165)).setAttribute("valign","top" );
      ((Element)v.get(165)).setAttribute("height","13" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(166)).setAttribute("nombre","lblCodNse2" );
      ((Element)v.get(166)).setAttribute("alto","13" );
      ((Element)v.get(166)).setAttribute("filas","1" );
      ((Element)v.get(166)).setAttribute("id","datosTitle" );
      ((Element)v.get(166)).setAttribute("cod","ZonValorEstruGeopo.codNse2.label" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:167 / Elemento padre: 163   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(167)).setAttribute("nombre","codNse2WidgetTrId" );
      ((Element)v.get(163)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(168)).setAttribute("align","left" );
      ((Element)v.get(168)).setAttribute("nowrap","true" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(169)).setAttribute("nombre","codNse2" );
      ((Element)v.get(169)).setAttribute("id","datosCampos" );
      ((Element)v.get(169)).setAttribute("trim","S" );
      ((Element)v.get(169)).setAttribute("max","2" );
      ((Element)v.get(169)).setAttribute("onchange","" );
      ((Element)v.get(169)).setAttribute("req","N" );
      ((Element)v.get(169)).setAttribute("size","2" );
      ((Element)v.get(169)).setAttribute("valor","" );
      ((Element)v.get(169)).setAttribute("validacion","" );
      ((Element)v.get(169)).setAttribute("disabled","" );
      ((Element)v.get(169)).setAttribute("onblur","" );
      ((Element)v.get(169)).setAttribute("ontab","ejecutarAccionFoco('zonValorEstruGeopoFrm',0, true)" );
      ((Element)v.get(169)).setAttribute("onshtab","ejecutarAccionFoco('zonValorEstruGeopoFrm', 0, false)" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */
      /* Termina nodo:167   */
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:170 / Elemento padre: 161   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(170)).setAttribute("nombre","codNse2GapTdId" );
      ((Element)v.get(170)).setAttribute("nowrap","true" );
      ((Element)v.get(170)).setAttribute("class","datosCampos" );
      ((Element)v.get(161)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(171)).setAttribute("src","b.gif" );
      ((Element)v.get(171)).setAttribute("width","25" );
      ((Element)v.get(171)).setAttribute("height","8" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:172 / Elemento padre: 161   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(172)).setAttribute("width","100%" );
      ((Element)v.get(161)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(173)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:159   */
      /* Termina nodo:156   */

      /* Empieza nodo:174 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(174)).setAttribute("nombre","formGapTr4" );
      ((Element)v.get(52)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(175)).setAttribute("align","center" );
      ((Element)v.get(175)).setAttribute("width","8" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(176)).setAttribute("src","b.gif" );
      ((Element)v.get(176)).setAttribute("width","12" );
      ((Element)v.get(176)).setAttribute("height","8" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 174   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(174)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(178)).setAttribute("src","b.gif" );
      ((Element)v.get(178)).setAttribute("width","8" );
      ((Element)v.get(178)).setAttribute("height","8" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:179 / Elemento padre: 174   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(179)).setAttribute("align","center" );
      ((Element)v.get(179)).setAttribute("width","8" );
      ((Element)v.get(174)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(180)).setAttribute("src","b.gif" );
      ((Element)v.get(180)).setAttribute("width","12" );
      ((Element)v.get(180)).setAttribute("height","8" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */
      /* Termina nodo:174   */

      /* Empieza nodo:181 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(181)).setAttribute("nombre","formTr5" );
      ((Element)v.get(52)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(182)).setAttribute("align","center" );
      ((Element)v.get(182)).setAttribute("width","8" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(183)).setAttribute("src","b.gif" );
      ((Element)v.get(183)).setAttribute("width","8" );
      ((Element)v.get(183)).setAttribute("height","12" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:184 / Elemento padre: 181   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(184)).setAttribute("width","100%" );
      ((Element)v.get(181)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(185)).setAttribute("width","100%" );
      ((Element)v.get(185)).setAttribute("border","0" );
      ((Element)v.get(185)).setAttribute("cellspacing","0" );
      ((Element)v.get(185)).setAttribute("cellpadding","0" );
      ((Element)v.get(185)).setAttribute("align","left" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(186)).setAttribute("align","left" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(187)).setAttribute("nombre","codNse3TdId" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(188)).setAttribute("width","100%" );
      ((Element)v.get(188)).setAttribute("border","0" );
      ((Element)v.get(188)).setAttribute("cellspacing","0" );
      ((Element)v.get(188)).setAttribute("cellpadding","0" );
      ((Element)v.get(188)).setAttribute("align","left" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(188)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(190)).setAttribute("valign","top" );
      ((Element)v.get(190)).setAttribute("height","13" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(191)).setAttribute("nombre","lblCodNse3" );
      ((Element)v.get(191)).setAttribute("alto","13" );
      ((Element)v.get(191)).setAttribute("filas","1" );
      ((Element)v.get(191)).setAttribute("id","datosTitle" );
      ((Element)v.get(191)).setAttribute("cod","ZonValorEstruGeopo.codNse3.label" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:192 / Elemento padre: 188   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(192)).setAttribute("nombre","codNse3WidgetTrId" );
      ((Element)v.get(188)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(193)).setAttribute("align","left" );
      ((Element)v.get(193)).setAttribute("nowrap","true" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(194)).setAttribute("nombre","codNse3" );
      ((Element)v.get(194)).setAttribute("id","datosCampos" );
      ((Element)v.get(194)).setAttribute("trim","S" );
      ((Element)v.get(194)).setAttribute("max","2" );
      ((Element)v.get(194)).setAttribute("onchange","" );
      ((Element)v.get(194)).setAttribute("req","N" );
      ((Element)v.get(194)).setAttribute("size","2" );
      ((Element)v.get(194)).setAttribute("valor","" );
      ((Element)v.get(194)).setAttribute("validacion","" );
      ((Element)v.get(194)).setAttribute("disabled","" );
      ((Element)v.get(194)).setAttribute("onblur","" );
      ((Element)v.get(194)).setAttribute("ontab","ejecutarAccionFoco('zonValorEstruGeopoFrm',0, true)" );
      ((Element)v.get(194)).setAttribute("onshtab","ejecutarAccionFoco('zonValorEstruGeopoFrm', 0, false)" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:195 / Elemento padre: 186   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(195)).setAttribute("nombre","codNse3GapTdId" );
      ((Element)v.get(195)).setAttribute("nowrap","true" );
      ((Element)v.get(195)).setAttribute("class","datosCampos" );
      ((Element)v.get(186)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(196)).setAttribute("width","25" );
      ((Element)v.get(196)).setAttribute("height","8" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 186   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(197)).setAttribute("width","100%" );
      ((Element)v.get(186)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */
      /* Termina nodo:186   */
      /* Termina nodo:185   */
      /* Termina nodo:184   */
      /* Termina nodo:181   */

      /* Empieza nodo:199 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(199)).setAttribute("nombre","formGapTr5" );
      ((Element)v.get(52)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(200)).setAttribute("align","center" );
      ((Element)v.get(200)).setAttribute("width","8" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).setAttribute("width","12" );
      ((Element)v.get(201)).setAttribute("height","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 199   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(199)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(203)).setAttribute("src","b.gif" );
      ((Element)v.get(203)).setAttribute("width","8" );
      ((Element)v.get(203)).setAttribute("height","8" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 199   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(204)).setAttribute("align","center" );
      ((Element)v.get(204)).setAttribute("width","8" );
      ((Element)v.get(199)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(205)).setAttribute("src","b.gif" );
      ((Element)v.get(205)).setAttribute("width","12" );
      ((Element)v.get(205)).setAttribute("height","8" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */
      /* Termina nodo:199   */

      /* Empieza nodo:206 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(206)).setAttribute("nombre","formTr6" );
      ((Element)v.get(52)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(207)).setAttribute("align","center" );
      ((Element)v.get(207)).setAttribute("width","8" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(208)).setAttribute("width","8" );
      ((Element)v.get(208)).setAttribute("height","12" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:209 / Elemento padre: 206   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(209)).setAttribute("width","100%" );
      ((Element)v.get(206)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(210)).setAttribute("width","100%" );
      ((Element)v.get(210)).setAttribute("border","0" );
      ((Element)v.get(210)).setAttribute("cellspacing","0" );
      ((Element)v.get(210)).setAttribute("cellpadding","0" );
      ((Element)v.get(210)).setAttribute("align","left" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(211)).setAttribute("align","left" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(212)).setAttribute("nombre","codPostTdId" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(213)).setAttribute("width","100%" );
      ((Element)v.get(213)).setAttribute("border","0" );
      ((Element)v.get(213)).setAttribute("cellspacing","0" );
      ((Element)v.get(213)).setAttribute("cellpadding","0" );
      ((Element)v.get(213)).setAttribute("align","left" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(213)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(215)).setAttribute("valign","top" );
      ((Element)v.get(215)).setAttribute("height","13" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(216)).setAttribute("nombre","lblCodPost" );
      ((Element)v.get(216)).setAttribute("alto","13" );
      ((Element)v.get(216)).setAttribute("filas","1" );
      ((Element)v.get(216)).setAttribute("id","datosTitle" );
      ((Element)v.get(216)).setAttribute("cod","ZonValorEstruGeopo.codPost.label" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:217 / Elemento padre: 213   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(217)).setAttribute("nombre","codPostWidgetTrId" );
      ((Element)v.get(213)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(218)).setAttribute("align","left" );
      ((Element)v.get(218)).setAttribute("nowrap","true" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(219)).setAttribute("nombre","codPost" );
      ((Element)v.get(219)).setAttribute("id","datosCampos" );
      ((Element)v.get(219)).setAttribute("trim","S" );
      ((Element)v.get(219)).setAttribute("max","20" );
      ((Element)v.get(219)).setAttribute("onchange","" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(219)).setAttribute("req","N" );
      ((Element)v.get(219)).setAttribute("size","20" );
      ((Element)v.get(219)).setAttribute("valor","" );
      ((Element)v.get(219)).setAttribute("validacion","" );
      ((Element)v.get(219)).setAttribute("disabled","" );
      ((Element)v.get(219)).setAttribute("onblur","" );
      ((Element)v.get(219)).setAttribute("ontab","ejecutarAccionFoco('zonValorEstruGeopoFrm',0, true)" );
      ((Element)v.get(219)).setAttribute("onshtab","ejecutarAccionFoco('zonValorEstruGeopoFrm', 0, false)" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:217   */
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:220 / Elemento padre: 211   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(220)).setAttribute("nombre","codPostGapTdId" );
      ((Element)v.get(220)).setAttribute("nowrap","true" );
      ((Element)v.get(220)).setAttribute("class","datosCampos" );
      ((Element)v.get(211)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(221)).setAttribute("src","b.gif" );
      ((Element)v.get(221)).setAttribute("width","25" );
      ((Element)v.get(221)).setAttribute("height","8" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */

      /* Empieza nodo:222 / Elemento padre: 211   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(222)).setAttribute("width","100%" );
      ((Element)v.get(211)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(223)).setAttribute("src","b.gif" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:209   */
      /* Termina nodo:206   */

      /* Empieza nodo:224 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(224)).setAttribute("nombre","formGapTr6" );
      ((Element)v.get(52)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(225)).setAttribute("align","center" );
      ((Element)v.get(225)).setAttribute("width","8" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(226)).setAttribute("src","b.gif" );
      ((Element)v.get(226)).setAttribute("width","12" );
      ((Element)v.get(226)).setAttribute("height","8" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:227 / Elemento padre: 224   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(224)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(228)).setAttribute("src","b.gif" );
      ((Element)v.get(228)).setAttribute("width","8" );
      ((Element)v.get(228)).setAttribute("height","8" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */

      /* Empieza nodo:229 / Elemento padre: 224   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(229)).setAttribute("align","center" );
      ((Element)v.get(229)).setAttribute("width","8" );
      ((Element)v.get(224)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(230)).setAttribute("width","12" );
      ((Element)v.get(230)).setAttribute("height","8" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */
      /* Termina nodo:224   */

      /* Empieza nodo:231 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(231)).setAttribute("nombre","formTr7" );
      ((Element)v.get(52)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(232)).setAttribute("align","center" );
      ((Element)v.get(232)).setAttribute("width","8" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(233)).setAttribute("src","b.gif" );
      ((Element)v.get(233)).setAttribute("width","8" );
      ((Element)v.get(233)).setAttribute("height","12" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:234 / Elemento padre: 231   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(234)).setAttribute("width","100%" );
      ((Element)v.get(231)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(235)).setAttribute("width","100%" );
      ((Element)v.get(235)).setAttribute("border","0" );
      ((Element)v.get(235)).setAttribute("cellspacing","0" );
      ((Element)v.get(235)).setAttribute("cellpadding","0" );
      ((Element)v.get(235)).setAttribute("align","left" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(236)).setAttribute("align","left" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(237)).setAttribute("nombre","indActiTdId" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(238)).setAttribute("width","100%" );
      ((Element)v.get(238)).setAttribute("border","0" );
      ((Element)v.get(238)).setAttribute("cellspacing","0" );
      ((Element)v.get(238)).setAttribute("cellpadding","0" );
      ((Element)v.get(238)).setAttribute("align","left" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(240)).setAttribute("valign","top" );
      ((Element)v.get(240)).setAttribute("height","13" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(241)).setAttribute("nombre","lblIndActi" );
      ((Element)v.get(241)).setAttribute("alto","13" );
      ((Element)v.get(241)).setAttribute("filas","1" );
      ((Element)v.get(241)).setAttribute("id","datosTitle" );
      ((Element)v.get(241)).setAttribute("cod","ZonValorEstruGeopo.indActi.label" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */
      /* Termina nodo:239   */

      /* Empieza nodo:242 / Elemento padre: 238   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(242)).setAttribute("nombre","indActiWidgetTrId" );
      ((Element)v.get(238)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(243)).setAttribute("align","left" );
      ((Element)v.get(243)).setAttribute("nowrap","true" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(244)).setAttribute("nombre","indActi" );
      ((Element)v.get(244)).setAttribute("id","datosCampos" );
      ((Element)v.get(244)).setAttribute("trim","S" );
      ((Element)v.get(244)).setAttribute("max","1" );
      ((Element)v.get(244)).setAttribute("onchange","" );
      ((Element)v.get(244)).setAttribute("req","N" );
      ((Element)v.get(244)).setAttribute("size","1" );
      ((Element)v.get(244)).setAttribute("valor","" );
      ((Element)v.get(244)).setAttribute("validacion","" );
      ((Element)v.get(244)).setAttribute("disabled","" );
      ((Element)v.get(244)).setAttribute("onblur","" );
      ((Element)v.get(244)).setAttribute("ontab","ejecutarAccionFoco('zonValorEstruGeopoFrm',0, true)" );
      ((Element)v.get(244)).setAttribute("onshtab","ejecutarAccionFoco('zonValorEstruGeopoFrm', 0, false)" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */
      /* Termina nodo:242   */
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:245 / Elemento padre: 236   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(245)).setAttribute("nombre","indActiGapTdId" );
      ((Element)v.get(245)).setAttribute("nowrap","true" );
      ((Element)v.get(245)).setAttribute("class","datosCampos" );
      ((Element)v.get(236)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(246)).setAttribute("src","b.gif" );
      ((Element)v.get(246)).setAttribute("width","25" );
      ((Element)v.get(246)).setAttribute("height","8" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */

      /* Empieza nodo:247 / Elemento padre: 236   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(247)).setAttribute("width","100%" );
      ((Element)v.get(236)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(248)).setAttribute("src","b.gif" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */
      /* Termina nodo:236   */
      /* Termina nodo:235   */
      /* Termina nodo:234   */
      /* Termina nodo:231   */

      /* Empieza nodo:249 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(249)).setAttribute("nombre","formGapTr7" );
      ((Element)v.get(52)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(250)).setAttribute("align","center" );
      ((Element)v.get(250)).setAttribute("width","8" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(251)).setAttribute("src","b.gif" );
      ((Element)v.get(251)).setAttribute("width","12" );
      ((Element)v.get(251)).setAttribute("height","8" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:252 / Elemento padre: 249   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(249)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(253)).setAttribute("src","b.gif" );
      ((Element)v.get(253)).setAttribute("width","8" );
      ((Element)v.get(253)).setAttribute("height","8" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */

      /* Empieza nodo:254 / Elemento padre: 249   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(254)).setAttribute("align","center" );
      ((Element)v.get(254)).setAttribute("width","8" );
      ((Element)v.get(249)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(255)).setAttribute("src","b.gif" );
      ((Element)v.get(255)).setAttribute("width","12" );
      ((Element)v.get(255)).setAttribute("height","8" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */
      /* Termina nodo:249   */

      /* Empieza nodo:256 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(256)).setAttribute("nombre","formTr8" );
      ((Element)v.get(52)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(257)).setAttribute("align","center" );
      ((Element)v.get(257)).setAttribute("width","8" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(258)).setAttribute("src","b.gif" );
      ((Element)v.get(258)).setAttribute("width","8" );
      ((Element)v.get(258)).setAttribute("height","12" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:257   */

      /* Empieza nodo:259 / Elemento padre: 256   */
      v.add(doc.createElement("TD"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(259)).setAttribute("width","100%" );
      ((Element)v.get(256)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(260)).setAttribute("width","100%" );
      ((Element)v.get(260)).setAttribute("border","0" );
      ((Element)v.get(260)).setAttribute("cellspacing","0" );
      ((Element)v.get(260)).setAttribute("cellpadding","0" );
      ((Element)v.get(260)).setAttribute("align","left" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(261)).setAttribute("align","left" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(262)).setAttribute("nombre","indAsigTdId" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(263)).setAttribute("width","100%" );
      ((Element)v.get(263)).setAttribute("border","0" );
      ((Element)v.get(263)).setAttribute("cellspacing","0" );
      ((Element)v.get(263)).setAttribute("cellpadding","0" );
      ((Element)v.get(263)).setAttribute("align","left" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(263)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(265)).setAttribute("valign","top" );
      ((Element)v.get(265)).setAttribute("height","13" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(266)).setAttribute("nombre","lblIndAsig" );
      ((Element)v.get(266)).setAttribute("alto","13" );
      ((Element)v.get(266)).setAttribute("filas","1" );
      ((Element)v.get(266)).setAttribute("id","datosTitle" );
      ((Element)v.get(266)).setAttribute("cod","ZonValorEstruGeopo.indAsig.label" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */
      /* Termina nodo:264   */

      /* Empieza nodo:267 / Elemento padre: 263   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(267)).setAttribute("nombre","indAsigWidgetTrId" );
      ((Element)v.get(263)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(268)).setAttribute("align","left" );
      ((Element)v.get(268)).setAttribute("nowrap","true" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(269)).setAttribute("nombre","indAsig" );
      ((Element)v.get(269)).setAttribute("id","datosCampos" );
      ((Element)v.get(269)).setAttribute("trim","S" );
      ((Element)v.get(269)).setAttribute("max","1" );
      ((Element)v.get(269)).setAttribute("onchange","" );
      ((Element)v.get(269)).setAttribute("req","N" );
      ((Element)v.get(269)).setAttribute("size","1" );
      ((Element)v.get(269)).setAttribute("valor","" );
      ((Element)v.get(269)).setAttribute("validacion","" );
      ((Element)v.get(269)).setAttribute("disabled","" );
      ((Element)v.get(269)).setAttribute("onblur","" );
      ((Element)v.get(269)).setAttribute("ontab","ejecutarAccionFoco('zonValorEstruGeopoFrm',0, true)" );
      ((Element)v.get(269)).setAttribute("onshtab","ejecutarAccionFoco('zonValorEstruGeopoFrm', 0, false)" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */
      /* Termina nodo:267   */
      /* Termina nodo:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:270 / Elemento padre: 261   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(270)).setAttribute("nombre","indAsigGapTdId" );
      ((Element)v.get(270)).setAttribute("nowrap","true" );
      ((Element)v.get(270)).setAttribute("class","datosCampos" );
      ((Element)v.get(261)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(271)).setAttribute("width","25" );
      ((Element)v.get(271)).setAttribute("height","8" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */

      /* Empieza nodo:272 / Elemento padre: 261   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(272)).setAttribute("width","100%" );
      ((Element)v.get(261)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(273)).setAttribute("src","b.gif" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */
      /* Termina nodo:272   */
      /* Termina nodo:261   */
      /* Termina nodo:260   */
      /* Termina nodo:259   */
      /* Termina nodo:256   */

      /* Empieza nodo:274 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(274)).setAttribute("nombre","formGapTr8" );
      ((Element)v.get(52)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(275)).setAttribute("align","center" );
      ((Element)v.get(275)).setAttribute("width","8" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(276)).setAttribute("src","b.gif" );
      ((Element)v.get(276)).setAttribute("width","12" );
      ((Element)v.get(276)).setAttribute("height","8" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:277 / Elemento padre: 274   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(274)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(278)).setAttribute("src","b.gif" );
      ((Element)v.get(278)).setAttribute("width","8" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(278)).setAttribute("height","8" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:279 / Elemento padre: 274   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(279)).setAttribute("align","center" );
      ((Element)v.get(279)).setAttribute("width","8" );
      ((Element)v.get(274)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(280)).setAttribute("src","b.gif" );
      ((Element)v.get(280)).setAttribute("width","12" );
      ((Element)v.get(280)).setAttribute("height","8" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */
      /* Termina nodo:274   */

      /* Empieza nodo:281 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(281)).setAttribute("nombre","formTr9" );
      ((Element)v.get(52)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(282)).setAttribute("align","center" );
      ((Element)v.get(282)).setAttribute("width","8" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(283)).setAttribute("src","b.gif" );
      ((Element)v.get(283)).setAttribute("width","8" );
      ((Element)v.get(283)).setAttribute("height","12" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:284 / Elemento padre: 281   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(284)).setAttribute("width","100%" );
      ((Element)v.get(281)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(285)).setAttribute("width","100%" );
      ((Element)v.get(285)).setAttribute("border","0" );
      ((Element)v.get(285)).setAttribute("cellspacing","0" );
      ((Element)v.get(285)).setAttribute("cellpadding","0" );
      ((Element)v.get(285)).setAttribute("align","left" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(286)).setAttribute("align","left" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(287)).setAttribute("nombre","indBorrTdId" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(288)).setAttribute("width","100%" );
      ((Element)v.get(288)).setAttribute("border","0" );
      ((Element)v.get(288)).setAttribute("cellspacing","0" );
      ((Element)v.get(288)).setAttribute("cellpadding","0" );
      ((Element)v.get(288)).setAttribute("align","left" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(288)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(290)).setAttribute("valign","top" );
      ((Element)v.get(290)).setAttribute("height","13" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(291)).setAttribute("nombre","lblIndBorr" );
      ((Element)v.get(291)).setAttribute("alto","13" );
      ((Element)v.get(291)).setAttribute("filas","1" );
      ((Element)v.get(291)).setAttribute("id","datosTitle" );
      ((Element)v.get(291)).setAttribute("cod","ZonValorEstruGeopo.indBorr.label" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */
      /* Termina nodo:289   */

      /* Empieza nodo:292 / Elemento padre: 288   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(292)).setAttribute("nombre","indBorrWidgetTrId" );
      ((Element)v.get(288)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(293)).setAttribute("align","left" );
      ((Element)v.get(293)).setAttribute("nowrap","true" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(294)).setAttribute("nombre","indBorr" );
      ((Element)v.get(294)).setAttribute("id","datosCampos" );
      ((Element)v.get(294)).setAttribute("trim","S" );
      ((Element)v.get(294)).setAttribute("max","1" );
      ((Element)v.get(294)).setAttribute("onchange","" );
      ((Element)v.get(294)).setAttribute("req","N" );
      ((Element)v.get(294)).setAttribute("size","1" );
      ((Element)v.get(294)).setAttribute("valor","" );
      ((Element)v.get(294)).setAttribute("validacion","" );
      ((Element)v.get(294)).setAttribute("disabled","" );
      ((Element)v.get(294)).setAttribute("onblur","" );
      ((Element)v.get(294)).setAttribute("ontab","ejecutarAccionFoco('zonValorEstruGeopoFrm',0, true)" );
      ((Element)v.get(294)).setAttribute("onshtab","ejecutarAccionFoco('zonValorEstruGeopoFrm', 0, false)" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:293   */
      /* Termina nodo:292   */
      /* Termina nodo:288   */
      /* Termina nodo:287   */

      /* Empieza nodo:295 / Elemento padre: 286   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(295)).setAttribute("nombre","indBorrGapTdId" );
      ((Element)v.get(295)).setAttribute("nowrap","true" );
      ((Element)v.get(295)).setAttribute("class","datosCampos" );
      ((Element)v.get(286)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(296)).setAttribute("src","b.gif" );
      ((Element)v.get(296)).setAttribute("width","25" );
      ((Element)v.get(296)).setAttribute("height","8" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */

      /* Empieza nodo:297 / Elemento padre: 286   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(297)).setAttribute("width","100%" );
      ((Element)v.get(286)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(298)).setAttribute("src","b.gif" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */
      /* Termina nodo:286   */
      /* Termina nodo:285   */
      /* Termina nodo:284   */
      /* Termina nodo:281   */

      /* Empieza nodo:299 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(299)).setAttribute("nombre","formGapTr9" );
      ((Element)v.get(52)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(300)).setAttribute("align","center" );
      ((Element)v.get(300)).setAttribute("width","8" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(301)).setAttribute("src","b.gif" );
      ((Element)v.get(301)).setAttribute("width","12" );
      ((Element)v.get(301)).setAttribute("height","8" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:300   */

      /* Empieza nodo:302 / Elemento padre: 299   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(299)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(303)).setAttribute("src","b.gif" );
      ((Element)v.get(303)).setAttribute("width","8" );
      ((Element)v.get(303)).setAttribute("height","8" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:302   */

      /* Empieza nodo:304 / Elemento padre: 299   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(304)).setAttribute("align","center" );
      ((Element)v.get(304)).setAttribute("width","8" );
      ((Element)v.get(299)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(305)).setAttribute("src","b.gif" );
      ((Element)v.get(305)).setAttribute("width","12" );
      ((Element)v.get(305)).setAttribute("height","8" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:304   */
      /* Termina nodo:299   */

      /* Empieza nodo:306 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(306)).setAttribute("nombre","formTr10" );
      ((Element)v.get(52)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(307)).setAttribute("align","center" );
      ((Element)v.get(307)).setAttribute("width","8" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(308)).setAttribute("src","b.gif" );
      ((Element)v.get(308)).setAttribute("width","8" );
      ((Element)v.get(308)).setAttribute("height","12" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:307   */

      /* Empieza nodo:309 / Elemento padre: 306   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(309)).setAttribute("width","100%" );
      ((Element)v.get(306)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(310)).setAttribute("width","100%" );
      ((Element)v.get(310)).setAttribute("border","0" );
      ((Element)v.get(310)).setAttribute("cellspacing","0" );
      ((Element)v.get(310)).setAttribute("cellpadding","0" );
      ((Element)v.get(310)).setAttribute("align","left" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(311)).setAttribute("align","left" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(312)).setAttribute("nombre","orde1TdId" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(313)).setAttribute("width","100%" );
      ((Element)v.get(313)).setAttribute("border","0" );
      ((Element)v.get(313)).setAttribute("cellspacing","0" );
      ((Element)v.get(313)).setAttribute("cellpadding","0" );
      ((Element)v.get(313)).setAttribute("align","left" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(313)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(315)).setAttribute("valign","top" );
      ((Element)v.get(315)).setAttribute("height","13" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(316)).setAttribute("nombre","lblOrde1" );
      ((Element)v.get(316)).setAttribute("alto","13" );
      ((Element)v.get(316)).setAttribute("filas","1" );
      ((Element)v.get(316)).setAttribute("id","datosTitle" );
      ((Element)v.get(316)).setAttribute("cod","ZonValorEstruGeopo.orde1.label" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */
      /* Termina nodo:314   */

      /* Empieza nodo:317 / Elemento padre: 313   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(317)).setAttribute("nombre","orde1WidgetTrId" );
      ((Element)v.get(313)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(318)).setAttribute("align","left" );
      ((Element)v.get(318)).setAttribute("nowrap","true" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
   }

   private void getXML1440(Document doc) {
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(319)).setAttribute("nombre","orde1" );
      ((Element)v.get(319)).setAttribute("id","datosCampos" );
      ((Element)v.get(319)).setAttribute("trim","S" );
      ((Element)v.get(319)).setAttribute("max","6" );
      ((Element)v.get(319)).setAttribute("onchange","" );
      ((Element)v.get(319)).setAttribute("req","N" );
      ((Element)v.get(319)).setAttribute("size","6" );
      ((Element)v.get(319)).setAttribute("valor","" );
      ((Element)v.get(319)).setAttribute("validacion","" );
      ((Element)v.get(319)).setAttribute("disabled","" );
      ((Element)v.get(319)).setAttribute("onblur","" );
      ((Element)v.get(319)).setAttribute("ontab","ejecutarAccionFoco('zonValorEstruGeopoFrm',0, true)" );
      ((Element)v.get(319)).setAttribute("onshtab","ejecutarAccionFoco('zonValorEstruGeopoFrm', 0, false)" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */
      /* Termina nodo:318   */
      /* Termina nodo:317   */
      /* Termina nodo:313   */
      /* Termina nodo:312   */

      /* Empieza nodo:320 / Elemento padre: 311   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(320)).setAttribute("nombre","orde1GapTdId" );
      ((Element)v.get(320)).setAttribute("nowrap","true" );
      ((Element)v.get(320)).setAttribute("class","datosCampos" );
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
      v.add(doc.createElement("TD"));
      ((Element)v.get(322)).setAttribute("width","100%" );
      ((Element)v.get(311)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(323)).setAttribute("src","b.gif" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */
      /* Termina nodo:311   */
      /* Termina nodo:310   */
      /* Termina nodo:309   */
      /* Termina nodo:306   */

      /* Empieza nodo:324 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(324)).setAttribute("nombre","formGapTr10" );
      ((Element)v.get(52)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(325)).setAttribute("align","center" );
      ((Element)v.get(325)).setAttribute("width","8" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(326)).setAttribute("src","b.gif" );
      ((Element)v.get(326)).setAttribute("width","12" );
      ((Element)v.get(326)).setAttribute("height","8" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:325   */

      /* Empieza nodo:327 / Elemento padre: 324   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(324)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(328)).setAttribute("src","b.gif" );
      ((Element)v.get(328)).setAttribute("width","8" );
      ((Element)v.get(328)).setAttribute("height","8" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:327   */

      /* Empieza nodo:329 / Elemento padre: 324   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(329)).setAttribute("align","center" );
      ((Element)v.get(329)).setAttribute("width","8" );
      ((Element)v.get(324)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(330)).setAttribute("src","b.gif" );
      ((Element)v.get(330)).setAttribute("width","12" );
      ((Element)v.get(330)).setAttribute("height","8" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:329   */
      /* Termina nodo:324   */

      /* Empieza nodo:331 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(331)).setAttribute("nombre","formTr11" );
      ((Element)v.get(52)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(332)).setAttribute("align","center" );
      ((Element)v.get(332)).setAttribute("width","8" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(333)).setAttribute("src","b.gif" );
      ((Element)v.get(333)).setAttribute("width","8" );
      ((Element)v.get(333)).setAttribute("height","12" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */
      /* Termina nodo:332   */

      /* Empieza nodo:334 / Elemento padre: 331   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(334)).setAttribute("width","100%" );
      ((Element)v.get(331)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(335)).setAttribute("width","100%" );
      ((Element)v.get(335)).setAttribute("border","0" );
      ((Element)v.get(335)).setAttribute("cellspacing","0" );
      ((Element)v.get(335)).setAttribute("cellpadding","0" );
      ((Element)v.get(335)).setAttribute("align","left" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(336)).setAttribute("align","left" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(337)).setAttribute("nombre","orde2TdId" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(338)).setAttribute("width","100%" );
      ((Element)v.get(338)).setAttribute("border","0" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(338)).setAttribute("cellspacing","0" );
      ((Element)v.get(338)).setAttribute("cellpadding","0" );
      ((Element)v.get(338)).setAttribute("align","left" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(338)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(340)).setAttribute("valign","top" );
      ((Element)v.get(340)).setAttribute("height","13" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(341)).setAttribute("nombre","lblOrde2" );
      ((Element)v.get(341)).setAttribute("alto","13" );
      ((Element)v.get(341)).setAttribute("filas","1" );
      ((Element)v.get(341)).setAttribute("id","datosTitle" );
      ((Element)v.get(341)).setAttribute("cod","ZonValorEstruGeopo.orde2.label" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */
      /* Termina nodo:340   */
      /* Termina nodo:339   */

      /* Empieza nodo:342 / Elemento padre: 338   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(342)).setAttribute("nombre","orde2WidgetTrId" );
      ((Element)v.get(338)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(343)).setAttribute("align","left" );
      ((Element)v.get(343)).setAttribute("nowrap","true" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(344)).setAttribute("nombre","orde2" );
      ((Element)v.get(344)).setAttribute("id","datosCampos" );
      ((Element)v.get(344)).setAttribute("trim","S" );
      ((Element)v.get(344)).setAttribute("max","6" );
      ((Element)v.get(344)).setAttribute("onchange","" );
      ((Element)v.get(344)).setAttribute("req","N" );
      ((Element)v.get(344)).setAttribute("size","6" );
      ((Element)v.get(344)).setAttribute("valor","" );
      ((Element)v.get(344)).setAttribute("validacion","" );
      ((Element)v.get(344)).setAttribute("disabled","" );
      ((Element)v.get(344)).setAttribute("onblur","" );
      ((Element)v.get(344)).setAttribute("ontab","ejecutarAccionFoco('zonValorEstruGeopoFrm',0, true)" );
      ((Element)v.get(344)).setAttribute("onshtab","ejecutarAccionFoco('zonValorEstruGeopoFrm', 0, false)" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:343   */
      /* Termina nodo:342   */
      /* Termina nodo:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:345 / Elemento padre: 336   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(345)).setAttribute("nombre","orde2GapTdId" );
      ((Element)v.get(345)).setAttribute("nowrap","true" );
      ((Element)v.get(345)).setAttribute("class","datosCampos" );
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
      v.add(doc.createElement("TD"));
      ((Element)v.get(347)).setAttribute("width","100%" );
      ((Element)v.get(336)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(348)).setAttribute("src","b.gif" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:347   */
      /* Termina nodo:336   */
      /* Termina nodo:335   */
      /* Termina nodo:334   */
      /* Termina nodo:331   */

      /* Empieza nodo:349 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(349)).setAttribute("nombre","formGapTr11" );
      ((Element)v.get(52)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(350)).setAttribute("align","center" );
      ((Element)v.get(350)).setAttribute("width","8" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(351)).setAttribute("src","b.gif" );
      ((Element)v.get(351)).setAttribute("width","12" );
      ((Element)v.get(351)).setAttribute("height","8" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */
      /* Termina nodo:350   */

      /* Empieza nodo:352 / Elemento padre: 349   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(349)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(353)).setAttribute("src","b.gif" );
      ((Element)v.get(353)).setAttribute("width","8" );
      ((Element)v.get(353)).setAttribute("height","8" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */
      /* Termina nodo:352   */

      /* Empieza nodo:354 / Elemento padre: 349   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(354)).setAttribute("align","center" );
      ((Element)v.get(354)).setAttribute("width","8" );
      ((Element)v.get(349)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(355)).setAttribute("src","b.gif" );
      ((Element)v.get(355)).setAttribute("width","12" );
      ((Element)v.get(355)).setAttribute("height","8" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */
      /* Termina nodo:354   */
      /* Termina nodo:349   */

      /* Empieza nodo:356 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(356)).setAttribute("nombre","formTr12" );
      ((Element)v.get(52)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(357)).setAttribute("align","center" );
      ((Element)v.get(357)).setAttribute("width","8" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
   }

   private void getXML1620(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(358)).setAttribute("src","b.gif" );
      ((Element)v.get(358)).setAttribute("width","8" );
      ((Element)v.get(358)).setAttribute("height","12" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */
      /* Termina nodo:357   */

      /* Empieza nodo:359 / Elemento padre: 356   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(359)).setAttribute("width","100%" );
      ((Element)v.get(356)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(360)).setAttribute("width","100%" );
      ((Element)v.get(360)).setAttribute("border","0" );
      ((Element)v.get(360)).setAttribute("cellspacing","0" );
      ((Element)v.get(360)).setAttribute("cellpadding","0" );
      ((Element)v.get(360)).setAttribute("align","left" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(361)).setAttribute("align","left" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(362)).setAttribute("nombre","orde3TdId" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(363)).setAttribute("width","100%" );
      ((Element)v.get(363)).setAttribute("border","0" );
      ((Element)v.get(363)).setAttribute("cellspacing","0" );
      ((Element)v.get(363)).setAttribute("cellpadding","0" );
      ((Element)v.get(363)).setAttribute("align","left" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(363)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(365)).setAttribute("valign","top" );
      ((Element)v.get(365)).setAttribute("height","13" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(366)).setAttribute("nombre","lblOrde3" );
      ((Element)v.get(366)).setAttribute("alto","13" );
      ((Element)v.get(366)).setAttribute("filas","1" );
      ((Element)v.get(366)).setAttribute("id","datosTitle" );
      ((Element)v.get(366)).setAttribute("cod","ZonValorEstruGeopo.orde3.label" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */
      /* Termina nodo:365   */
      /* Termina nodo:364   */

      /* Empieza nodo:367 / Elemento padre: 363   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(367)).setAttribute("nombre","orde3WidgetTrId" );
      ((Element)v.get(363)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(368)).setAttribute("align","left" );
      ((Element)v.get(368)).setAttribute("nowrap","true" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(369)).setAttribute("nombre","orde3" );
      ((Element)v.get(369)).setAttribute("id","datosCampos" );
      ((Element)v.get(369)).setAttribute("trim","S" );
      ((Element)v.get(369)).setAttribute("max","6" );
      ((Element)v.get(369)).setAttribute("onchange","" );
      ((Element)v.get(369)).setAttribute("req","N" );
      ((Element)v.get(369)).setAttribute("size","6" );
      ((Element)v.get(369)).setAttribute("valor","" );
      ((Element)v.get(369)).setAttribute("validacion","" );
      ((Element)v.get(369)).setAttribute("disabled","" );
      ((Element)v.get(369)).setAttribute("onblur","" );
      ((Element)v.get(369)).setAttribute("ontab","ejecutarAccionFoco('zonValorEstruGeopoFrm',0, true)" );
      ((Element)v.get(369)).setAttribute("onshtab","ejecutarAccionFoco('zonValorEstruGeopoFrm', 0, false)" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */
      /* Termina nodo:367   */
      /* Termina nodo:363   */
      /* Termina nodo:362   */

      /* Empieza nodo:370 / Elemento padre: 361   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(370)).setAttribute("nombre","orde3GapTdId" );
      ((Element)v.get(370)).setAttribute("nowrap","true" );
      ((Element)v.get(370)).setAttribute("class","datosCampos" );
      ((Element)v.get(361)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(371)).setAttribute("src","b.gif" );
      ((Element)v.get(371)).setAttribute("width","25" );
      ((Element)v.get(371)).setAttribute("height","8" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */
      /* Termina nodo:370   */

      /* Empieza nodo:372 / Elemento padre: 361   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(372)).setAttribute("width","100%" );
      ((Element)v.get(361)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(373)).setAttribute("src","b.gif" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */
      /* Termina nodo:372   */
      /* Termina nodo:361   */
      /* Termina nodo:360   */
      /* Termina nodo:359   */
      /* Termina nodo:356   */

      /* Empieza nodo:374 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(374)).setAttribute("nombre","formGapTr12" );
      ((Element)v.get(52)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(375)).setAttribute("align","center" );
      ((Element)v.get(375)).setAttribute("width","8" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(376)).setAttribute("src","b.gif" );
      ((Element)v.get(376)).setAttribute("width","12" );
      ((Element)v.get(376)).setAttribute("height","8" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(375)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */
      /* Termina nodo:375   */

      /* Empieza nodo:377 / Elemento padre: 374   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(374)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(378)).setAttribute("src","b.gif" );
      ((Element)v.get(378)).setAttribute("width","8" );
      ((Element)v.get(378)).setAttribute("height","8" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:377   */

      /* Empieza nodo:379 / Elemento padre: 374   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(379)).setAttribute("align","center" );
      ((Element)v.get(379)).setAttribute("width","8" );
      ((Element)v.get(374)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(380)).setAttribute("src","b.gif" );
      ((Element)v.get(380)).setAttribute("width","12" );
      ((Element)v.get(380)).setAttribute("height","8" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */
      /* Termina nodo:379   */
      /* Termina nodo:374   */

      /* Empieza nodo:381 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(381)).setAttribute("nombre","formTr13" );
      ((Element)v.get(52)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(382)).setAttribute("align","center" );
      ((Element)v.get(382)).setAttribute("width","8" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(383)).setAttribute("src","b.gif" );
      ((Element)v.get(383)).setAttribute("width","8" );
      ((Element)v.get(383)).setAttribute("height","12" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */
      /* Termina nodo:382   */

      /* Empieza nodo:384 / Elemento padre: 381   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(384)).setAttribute("width","100%" );
      ((Element)v.get(381)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(385)).setAttribute("width","100%" );
      ((Element)v.get(385)).setAttribute("border","0" );
      ((Element)v.get(385)).setAttribute("cellspacing","0" );
      ((Element)v.get(385)).setAttribute("cellpadding","0" );
      ((Element)v.get(385)).setAttribute("align","left" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(386)).setAttribute("align","left" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(387)).setAttribute("nombre","orde4TdId" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(388)).setAttribute("width","100%" );
      ((Element)v.get(388)).setAttribute("border","0" );
      ((Element)v.get(388)).setAttribute("cellspacing","0" );
      ((Element)v.get(388)).setAttribute("cellpadding","0" );
      ((Element)v.get(388)).setAttribute("align","left" );
      ((Element)v.get(387)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(388)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(390)).setAttribute("valign","top" );
      ((Element)v.get(390)).setAttribute("height","13" );
      ((Element)v.get(389)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(391)).setAttribute("nombre","lblOrde4" );
      ((Element)v.get(391)).setAttribute("alto","13" );
      ((Element)v.get(391)).setAttribute("filas","1" );
      ((Element)v.get(391)).setAttribute("id","datosTitle" );
      ((Element)v.get(391)).setAttribute("cod","ZonValorEstruGeopo.orde4.label" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */
      /* Termina nodo:390   */
      /* Termina nodo:389   */

      /* Empieza nodo:392 / Elemento padre: 388   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(392)).setAttribute("nombre","orde4WidgetTrId" );
      ((Element)v.get(388)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(393)).setAttribute("align","left" );
      ((Element)v.get(393)).setAttribute("nowrap","true" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(394)).setAttribute("nombre","orde4" );
      ((Element)v.get(394)).setAttribute("id","datosCampos" );
      ((Element)v.get(394)).setAttribute("trim","S" );
      ((Element)v.get(394)).setAttribute("max","6" );
      ((Element)v.get(394)).setAttribute("onchange","" );
      ((Element)v.get(394)).setAttribute("req","N" );
      ((Element)v.get(394)).setAttribute("size","6" );
      ((Element)v.get(394)).setAttribute("valor","" );
      ((Element)v.get(394)).setAttribute("validacion","" );
      ((Element)v.get(394)).setAttribute("disabled","" );
      ((Element)v.get(394)).setAttribute("onblur","" );
      ((Element)v.get(394)).setAttribute("ontab","ejecutarAccionFoco('zonValorEstruGeopoFrm',0, true)" );
      ((Element)v.get(394)).setAttribute("onshtab","ejecutarAccionFoco('zonValorEstruGeopoFrm', 0, false)" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */
      /* Termina nodo:393   */
      /* Termina nodo:392   */
      /* Termina nodo:388   */
      /* Termina nodo:387   */

      /* Empieza nodo:395 / Elemento padre: 386   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(395)).setAttribute("nombre","orde4GapTdId" );
      ((Element)v.get(395)).setAttribute("nowrap","true" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(395)).setAttribute("class","datosCampos" );
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
      v.add(doc.createElement("TD"));
      ((Element)v.get(397)).setAttribute("width","100%" );
      ((Element)v.get(386)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(398)).setAttribute("src","b.gif" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */
      /* Termina nodo:397   */
      /* Termina nodo:386   */
      /* Termina nodo:385   */
      /* Termina nodo:384   */
      /* Termina nodo:381   */

      /* Empieza nodo:399 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(399)).setAttribute("nombre","formGapTr13" );
      ((Element)v.get(52)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(400)).setAttribute("align","center" );
      ((Element)v.get(400)).setAttribute("width","8" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(401)).setAttribute("src","b.gif" );
      ((Element)v.get(401)).setAttribute("width","12" );
      ((Element)v.get(401)).setAttribute("height","8" );
      ((Element)v.get(400)).appendChild((Element)v.get(401));
      /* Termina nodo:401   */
      /* Termina nodo:400   */

      /* Empieza nodo:402 / Elemento padre: 399   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(399)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(403)).setAttribute("src","b.gif" );
      ((Element)v.get(403)).setAttribute("width","8" );
      ((Element)v.get(403)).setAttribute("height","8" );
      ((Element)v.get(402)).appendChild((Element)v.get(403));
      /* Termina nodo:403   */
      /* Termina nodo:402   */

      /* Empieza nodo:404 / Elemento padre: 399   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(404)).setAttribute("align","center" );
      ((Element)v.get(404)).setAttribute("width","8" );
      ((Element)v.get(399)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(405)).setAttribute("src","b.gif" );
      ((Element)v.get(405)).setAttribute("width","12" );
      ((Element)v.get(405)).setAttribute("height","8" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */
      /* Termina nodo:404   */
      /* Termina nodo:399   */

      /* Empieza nodo:406 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(406)).setAttribute("nombre","formTr14" );
      ((Element)v.get(52)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(407)).setAttribute("align","center" );
      ((Element)v.get(407)).setAttribute("width","8" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(408)).setAttribute("src","b.gif" );
      ((Element)v.get(408)).setAttribute("width","8" );
      ((Element)v.get(408)).setAttribute("height","12" );
      ((Element)v.get(407)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */
      /* Termina nodo:407   */

      /* Empieza nodo:409 / Elemento padre: 406   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(409)).setAttribute("width","100%" );
      ((Element)v.get(406)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(410)).setAttribute("width","100%" );
      ((Element)v.get(410)).setAttribute("border","0" );
      ((Element)v.get(410)).setAttribute("cellspacing","0" );
      ((Element)v.get(410)).setAttribute("cellpadding","0" );
      ((Element)v.get(410)).setAttribute("align","left" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(411)).setAttribute("align","left" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(412)).setAttribute("nombre","orde5TdId" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(413)).setAttribute("width","100%" );
      ((Element)v.get(413)).setAttribute("border","0" );
      ((Element)v.get(413)).setAttribute("cellspacing","0" );
      ((Element)v.get(413)).setAttribute("cellpadding","0" );
      ((Element)v.get(413)).setAttribute("align","left" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(413)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(415)).setAttribute("valign","top" );
      ((Element)v.get(415)).setAttribute("height","13" );
      ((Element)v.get(414)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(416)).setAttribute("nombre","lblOrde5" );
      ((Element)v.get(416)).setAttribute("alto","13" );
      ((Element)v.get(416)).setAttribute("filas","1" );
      ((Element)v.get(416)).setAttribute("id","datosTitle" );
      ((Element)v.get(416)).setAttribute("cod","ZonValorEstruGeopo.orde5.label" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */
      /* Termina nodo:415   */
      /* Termina nodo:414   */

      /* Empieza nodo:417 / Elemento padre: 413   */
      v.add(doc.createElement("TR"));
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(417)).setAttribute("nombre","orde5WidgetTrId" );
      ((Element)v.get(413)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(418)).setAttribute("align","left" );
      ((Element)v.get(418)).setAttribute("nowrap","true" );
      ((Element)v.get(417)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(419)).setAttribute("nombre","orde5" );
      ((Element)v.get(419)).setAttribute("id","datosCampos" );
      ((Element)v.get(419)).setAttribute("trim","S" );
      ((Element)v.get(419)).setAttribute("max","6" );
      ((Element)v.get(419)).setAttribute("onchange","" );
      ((Element)v.get(419)).setAttribute("req","N" );
      ((Element)v.get(419)).setAttribute("size","6" );
      ((Element)v.get(419)).setAttribute("valor","" );
      ((Element)v.get(419)).setAttribute("validacion","" );
      ((Element)v.get(419)).setAttribute("disabled","" );
      ((Element)v.get(419)).setAttribute("onblur","" );
      ((Element)v.get(419)).setAttribute("ontab","ejecutarAccionFoco('zonValorEstruGeopoFrm',0, true)" );
      ((Element)v.get(419)).setAttribute("onshtab","ejecutarAccionFoco('zonValorEstruGeopoFrm', 0, false)" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */
      /* Termina nodo:418   */
      /* Termina nodo:417   */
      /* Termina nodo:413   */
      /* Termina nodo:412   */

      /* Empieza nodo:420 / Elemento padre: 411   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(420)).setAttribute("nombre","orde5GapTdId" );
      ((Element)v.get(420)).setAttribute("nowrap","true" );
      ((Element)v.get(420)).setAttribute("class","datosCampos" );
      ((Element)v.get(411)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(421)).setAttribute("src","b.gif" );
      ((Element)v.get(421)).setAttribute("width","25" );
      ((Element)v.get(421)).setAttribute("height","8" );
      ((Element)v.get(420)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */
      /* Termina nodo:420   */

      /* Empieza nodo:422 / Elemento padre: 411   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(422)).setAttribute("width","100%" );
      ((Element)v.get(411)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(423)).setAttribute("src","b.gif" );
      ((Element)v.get(422)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */
      /* Termina nodo:422   */
      /* Termina nodo:411   */
      /* Termina nodo:410   */
      /* Termina nodo:409   */
      /* Termina nodo:406   */

      /* Empieza nodo:424 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(424)).setAttribute("nombre","formGapTr14" );
      ((Element)v.get(52)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(425)).setAttribute("align","center" );
      ((Element)v.get(425)).setAttribute("width","8" );
      ((Element)v.get(424)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(426)).setAttribute("src","b.gif" );
      ((Element)v.get(426)).setAttribute("width","12" );
      ((Element)v.get(426)).setAttribute("height","8" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));
      /* Termina nodo:426   */
      /* Termina nodo:425   */

      /* Empieza nodo:427 / Elemento padre: 424   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(424)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(428)).setAttribute("src","b.gif" );
      ((Element)v.get(428)).setAttribute("width","8" );
      ((Element)v.get(428)).setAttribute("height","8" );
      ((Element)v.get(427)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */
      /* Termina nodo:427   */

      /* Empieza nodo:429 / Elemento padre: 424   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(429)).setAttribute("align","center" );
      ((Element)v.get(429)).setAttribute("width","8" );
      ((Element)v.get(424)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(430)).setAttribute("src","b.gif" );
      ((Element)v.get(430)).setAttribute("width","12" );
      ((Element)v.get(430)).setAttribute("height","8" );
      ((Element)v.get(429)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */
      /* Termina nodo:429   */
      /* Termina nodo:424   */

      /* Empieza nodo:431 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(431)).setAttribute("nombre","formTr15" );
      ((Element)v.get(52)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(432)).setAttribute("align","center" );
      ((Element)v.get(432)).setAttribute("width","8" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(433)).setAttribute("src","b.gif" );
      ((Element)v.get(433)).setAttribute("width","8" );
      ((Element)v.get(433)).setAttribute("height","12" );
      ((Element)v.get(432)).appendChild((Element)v.get(433));
      /* Termina nodo:433   */
      /* Termina nodo:432   */

      /* Empieza nodo:434 / Elemento padre: 431   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(434)).setAttribute("width","100%" );
      ((Element)v.get(431)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(435)).setAttribute("width","100%" );
      ((Element)v.get(435)).setAttribute("border","0" );
      ((Element)v.get(435)).setAttribute("cellspacing","0" );
      ((Element)v.get(435)).setAttribute("cellpadding","0" );
      ((Element)v.get(435)).setAttribute("align","left" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(436)).setAttribute("align","left" );
      ((Element)v.get(435)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
   }

   private void getXML1980(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(437)).setAttribute("nombre","orde6TdId" );
      ((Element)v.get(436)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(438)).setAttribute("width","100%" );
      ((Element)v.get(438)).setAttribute("border","0" );
      ((Element)v.get(438)).setAttribute("cellspacing","0" );
      ((Element)v.get(438)).setAttribute("cellpadding","0" );
      ((Element)v.get(438)).setAttribute("align","left" );
      ((Element)v.get(437)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(438)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(440)).setAttribute("valign","top" );
      ((Element)v.get(440)).setAttribute("height","13" );
      ((Element)v.get(439)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(441)).setAttribute("nombre","lblOrde6" );
      ((Element)v.get(441)).setAttribute("alto","13" );
      ((Element)v.get(441)).setAttribute("filas","1" );
      ((Element)v.get(441)).setAttribute("id","datosTitle" );
      ((Element)v.get(441)).setAttribute("cod","ZonValorEstruGeopo.orde6.label" );
      ((Element)v.get(440)).appendChild((Element)v.get(441));
      /* Termina nodo:441   */
      /* Termina nodo:440   */
      /* Termina nodo:439   */

      /* Empieza nodo:442 / Elemento padre: 438   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(442)).setAttribute("nombre","orde6WidgetTrId" );
      ((Element)v.get(438)).appendChild((Element)v.get(442));

      /* Empieza nodo:443 / Elemento padre: 442   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(443)).setAttribute("align","left" );
      ((Element)v.get(443)).setAttribute("nowrap","true" );
      ((Element)v.get(442)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(444)).setAttribute("nombre","orde6" );
      ((Element)v.get(444)).setAttribute("id","datosCampos" );
      ((Element)v.get(444)).setAttribute("trim","S" );
      ((Element)v.get(444)).setAttribute("max","6" );
      ((Element)v.get(444)).setAttribute("onchange","" );
      ((Element)v.get(444)).setAttribute("req","N" );
      ((Element)v.get(444)).setAttribute("size","6" );
      ((Element)v.get(444)).setAttribute("valor","" );
      ((Element)v.get(444)).setAttribute("validacion","" );
      ((Element)v.get(444)).setAttribute("disabled","" );
      ((Element)v.get(444)).setAttribute("onblur","" );
      ((Element)v.get(444)).setAttribute("ontab","ejecutarAccionFoco('zonValorEstruGeopoFrm',0, true)" );
      ((Element)v.get(444)).setAttribute("onshtab","ejecutarAccionFoco('zonValorEstruGeopoFrm', 0, false)" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));
      /* Termina nodo:444   */
      /* Termina nodo:443   */
      /* Termina nodo:442   */
      /* Termina nodo:438   */
      /* Termina nodo:437   */

      /* Empieza nodo:445 / Elemento padre: 436   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(445)).setAttribute("nombre","orde6GapTdId" );
      ((Element)v.get(445)).setAttribute("nowrap","true" );
      ((Element)v.get(445)).setAttribute("class","datosCampos" );
      ((Element)v.get(436)).appendChild((Element)v.get(445));

      /* Empieza nodo:446 / Elemento padre: 445   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(446)).setAttribute("src","b.gif" );
      ((Element)v.get(446)).setAttribute("width","25" );
      ((Element)v.get(446)).setAttribute("height","8" );
      ((Element)v.get(445)).appendChild((Element)v.get(446));
      /* Termina nodo:446   */
      /* Termina nodo:445   */

      /* Empieza nodo:447 / Elemento padre: 436   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(447)).setAttribute("width","100%" );
      ((Element)v.get(436)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(448)).setAttribute("src","b.gif" );
      ((Element)v.get(447)).appendChild((Element)v.get(448));
      /* Termina nodo:448   */
      /* Termina nodo:447   */
      /* Termina nodo:436   */
      /* Termina nodo:435   */
      /* Termina nodo:434   */
      /* Termina nodo:431   */

      /* Empieza nodo:449 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(449)).setAttribute("nombre","formGapTr15" );
      ((Element)v.get(52)).appendChild((Element)v.get(449));

      /* Empieza nodo:450 / Elemento padre: 449   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(450)).setAttribute("align","center" );
      ((Element)v.get(450)).setAttribute("width","8" );
      ((Element)v.get(449)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(451)).setAttribute("src","b.gif" );
      ((Element)v.get(451)).setAttribute("width","12" );
      ((Element)v.get(451)).setAttribute("height","8" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));
      /* Termina nodo:451   */
      /* Termina nodo:450   */

      /* Empieza nodo:452 / Elemento padre: 449   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(449)).appendChild((Element)v.get(452));

      /* Empieza nodo:453 / Elemento padre: 452   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(453)).setAttribute("src","b.gif" );
      ((Element)v.get(453)).setAttribute("width","8" );
      ((Element)v.get(453)).setAttribute("height","8" );
      ((Element)v.get(452)).appendChild((Element)v.get(453));
      /* Termina nodo:453   */
      /* Termina nodo:452   */

      /* Empieza nodo:454 / Elemento padre: 449   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(454)).setAttribute("align","center" );
      ((Element)v.get(454)).setAttribute("width","8" );
      ((Element)v.get(449)).appendChild((Element)v.get(454));

      /* Empieza nodo:455 / Elemento padre: 454   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(455)).setAttribute("src","b.gif" );
      ((Element)v.get(455)).setAttribute("width","12" );
      ((Element)v.get(455)).setAttribute("height","8" );
      ((Element)v.get(454)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */
      /* Termina nodo:454   */
      /* Termina nodo:449   */

      /* Empieza nodo:456 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(456)).setAttribute("nombre","formTr16" );
      ((Element)v.get(52)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(457)).setAttribute("align","center" );
      ((Element)v.get(457)).setAttribute("width","8" );
      ((Element)v.get(456)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(458)).setAttribute("src","b.gif" );
      ((Element)v.get(458)).setAttribute("width","8" );
      ((Element)v.get(458)).setAttribute("height","12" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */
      /* Termina nodo:457   */

      /* Empieza nodo:459 / Elemento padre: 456   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(459)).setAttribute("width","100%" );
      ((Element)v.get(456)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(460)).setAttribute("width","100%" );
      ((Element)v.get(460)).setAttribute("border","0" );
      ((Element)v.get(460)).setAttribute("cellspacing","0" );
      ((Element)v.get(460)).setAttribute("cellpadding","0" );
      ((Element)v.get(460)).setAttribute("align","left" );
      ((Element)v.get(459)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(461)).setAttribute("align","left" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));

      /* Empieza nodo:462 / Elemento padre: 461   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(462)).setAttribute("nombre","orde7TdId" );
      ((Element)v.get(461)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(463)).setAttribute("width","100%" );
      ((Element)v.get(463)).setAttribute("border","0" );
      ((Element)v.get(463)).setAttribute("cellspacing","0" );
      ((Element)v.get(463)).setAttribute("cellpadding","0" );
      ((Element)v.get(463)).setAttribute("align","left" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));

      /* Empieza nodo:464 / Elemento padre: 463   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(463)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(465)).setAttribute("valign","top" );
      ((Element)v.get(465)).setAttribute("height","13" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(466)).setAttribute("nombre","lblOrde7" );
      ((Element)v.get(466)).setAttribute("alto","13" );
      ((Element)v.get(466)).setAttribute("filas","1" );
      ((Element)v.get(466)).setAttribute("id","datosTitle" );
      ((Element)v.get(466)).setAttribute("cod","ZonValorEstruGeopo.orde7.label" );
      ((Element)v.get(465)).appendChild((Element)v.get(466));
      /* Termina nodo:466   */
      /* Termina nodo:465   */
      /* Termina nodo:464   */

      /* Empieza nodo:467 / Elemento padre: 463   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(467)).setAttribute("nombre","orde7WidgetTrId" );
      ((Element)v.get(463)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(468)).setAttribute("align","left" );
      ((Element)v.get(468)).setAttribute("nowrap","true" );
      ((Element)v.get(467)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(469)).setAttribute("nombre","orde7" );
      ((Element)v.get(469)).setAttribute("id","datosCampos" );
      ((Element)v.get(469)).setAttribute("trim","S" );
      ((Element)v.get(469)).setAttribute("max","6" );
      ((Element)v.get(469)).setAttribute("onchange","" );
      ((Element)v.get(469)).setAttribute("req","N" );
      ((Element)v.get(469)).setAttribute("size","6" );
      ((Element)v.get(469)).setAttribute("valor","" );
      ((Element)v.get(469)).setAttribute("validacion","" );
      ((Element)v.get(469)).setAttribute("disabled","" );
      ((Element)v.get(469)).setAttribute("onblur","" );
      ((Element)v.get(469)).setAttribute("ontab","ejecutarAccionFoco('zonValorEstruGeopoFrm',0, true)" );
      ((Element)v.get(469)).setAttribute("onshtab","ejecutarAccionFoco('zonValorEstruGeopoFrm', 0, false)" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));
      /* Termina nodo:469   */
      /* Termina nodo:468   */
      /* Termina nodo:467   */
      /* Termina nodo:463   */
      /* Termina nodo:462   */

      /* Empieza nodo:470 / Elemento padre: 461   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(470)).setAttribute("nombre","orde7GapTdId" );
      ((Element)v.get(470)).setAttribute("nowrap","true" );
      ((Element)v.get(470)).setAttribute("class","datosCampos" );
      ((Element)v.get(461)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(471)).setAttribute("src","b.gif" );
      ((Element)v.get(471)).setAttribute("width","25" );
      ((Element)v.get(471)).setAttribute("height","8" );
      ((Element)v.get(470)).appendChild((Element)v.get(471));
      /* Termina nodo:471   */
      /* Termina nodo:470   */

      /* Empieza nodo:472 / Elemento padre: 461   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(472)).setAttribute("width","100%" );
      ((Element)v.get(461)).appendChild((Element)v.get(472));

      /* Empieza nodo:473 / Elemento padre: 472   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(473)).setAttribute("src","b.gif" );
      ((Element)v.get(472)).appendChild((Element)v.get(473));
      /* Termina nodo:473   */
      /* Termina nodo:472   */
      /* Termina nodo:461   */
      /* Termina nodo:460   */
      /* Termina nodo:459   */
      /* Termina nodo:456   */

      /* Empieza nodo:474 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(474)).setAttribute("nombre","formGapTr16" );
      ((Element)v.get(52)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(475)).setAttribute("align","center" );
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(475)).setAttribute("width","8" );
      ((Element)v.get(474)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(476)).setAttribute("src","b.gif" );
      ((Element)v.get(476)).setAttribute("width","12" );
      ((Element)v.get(476)).setAttribute("height","8" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */
      /* Termina nodo:475   */

      /* Empieza nodo:477 / Elemento padre: 474   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(474)).appendChild((Element)v.get(477));

      /* Empieza nodo:478 / Elemento padre: 477   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(478)).setAttribute("src","b.gif" );
      ((Element)v.get(478)).setAttribute("width","8" );
      ((Element)v.get(478)).setAttribute("height","8" );
      ((Element)v.get(477)).appendChild((Element)v.get(478));
      /* Termina nodo:478   */
      /* Termina nodo:477   */

      /* Empieza nodo:479 / Elemento padre: 474   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(479)).setAttribute("align","center" );
      ((Element)v.get(479)).setAttribute("width","8" );
      ((Element)v.get(474)).appendChild((Element)v.get(479));

      /* Empieza nodo:480 / Elemento padre: 479   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(480)).setAttribute("src","b.gif" );
      ((Element)v.get(480)).setAttribute("width","12" );
      ((Element)v.get(480)).setAttribute("height","8" );
      ((Element)v.get(479)).appendChild((Element)v.get(480));
      /* Termina nodo:480   */
      /* Termina nodo:479   */
      /* Termina nodo:474   */

      /* Empieza nodo:481 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(481)).setAttribute("nombre","formTr17" );
      ((Element)v.get(52)).appendChild((Element)v.get(481));

      /* Empieza nodo:482 / Elemento padre: 481   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(482)).setAttribute("align","center" );
      ((Element)v.get(482)).setAttribute("width","8" );
      ((Element)v.get(481)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(483)).setAttribute("src","b.gif" );
      ((Element)v.get(483)).setAttribute("width","8" );
      ((Element)v.get(483)).setAttribute("height","12" );
      ((Element)v.get(482)).appendChild((Element)v.get(483));
      /* Termina nodo:483   */
      /* Termina nodo:482   */

      /* Empieza nodo:484 / Elemento padre: 481   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(484)).setAttribute("width","100%" );
      ((Element)v.get(481)).appendChild((Element)v.get(484));

      /* Empieza nodo:485 / Elemento padre: 484   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(485)).setAttribute("width","100%" );
      ((Element)v.get(485)).setAttribute("border","0" );
      ((Element)v.get(485)).setAttribute("cellspacing","0" );
      ((Element)v.get(485)).setAttribute("cellpadding","0" );
      ((Element)v.get(485)).setAttribute("align","left" );
      ((Element)v.get(484)).appendChild((Element)v.get(485));

      /* Empieza nodo:486 / Elemento padre: 485   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(486)).setAttribute("align","left" );
      ((Element)v.get(485)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(487)).setAttribute("nombre","orde8TdId" );
      ((Element)v.get(486)).appendChild((Element)v.get(487));

      /* Empieza nodo:488 / Elemento padre: 487   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(488)).setAttribute("width","100%" );
      ((Element)v.get(488)).setAttribute("border","0" );
      ((Element)v.get(488)).setAttribute("cellspacing","0" );
      ((Element)v.get(488)).setAttribute("cellpadding","0" );
      ((Element)v.get(488)).setAttribute("align","left" );
      ((Element)v.get(487)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(488)).appendChild((Element)v.get(489));

      /* Empieza nodo:490 / Elemento padre: 489   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(490)).setAttribute("valign","top" );
      ((Element)v.get(490)).setAttribute("height","13" );
      ((Element)v.get(489)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(491)).setAttribute("nombre","lblOrde8" );
      ((Element)v.get(491)).setAttribute("alto","13" );
      ((Element)v.get(491)).setAttribute("filas","1" );
      ((Element)v.get(491)).setAttribute("id","datosTitle" );
      ((Element)v.get(491)).setAttribute("cod","ZonValorEstruGeopo.orde8.label" );
      ((Element)v.get(490)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */
      /* Termina nodo:490   */
      /* Termina nodo:489   */

      /* Empieza nodo:492 / Elemento padre: 488   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(492)).setAttribute("nombre","orde8WidgetTrId" );
      ((Element)v.get(488)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(493)).setAttribute("align","left" );
      ((Element)v.get(493)).setAttribute("nowrap","true" );
      ((Element)v.get(492)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(494)).setAttribute("nombre","orde8" );
      ((Element)v.get(494)).setAttribute("id","datosCampos" );
      ((Element)v.get(494)).setAttribute("trim","S" );
      ((Element)v.get(494)).setAttribute("max","6" );
      ((Element)v.get(494)).setAttribute("onchange","" );
      ((Element)v.get(494)).setAttribute("req","N" );
      ((Element)v.get(494)).setAttribute("size","6" );
      ((Element)v.get(494)).setAttribute("valor","" );
      ((Element)v.get(494)).setAttribute("validacion","" );
      ((Element)v.get(494)).setAttribute("disabled","" );
      ((Element)v.get(494)).setAttribute("onblur","" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(494)).setAttribute("ontab","ejecutarAccionFoco('zonValorEstruGeopoFrm',0, true)" );
      ((Element)v.get(494)).setAttribute("onshtab","ejecutarAccionFoco('zonValorEstruGeopoFrm', 0, false)" );
      ((Element)v.get(493)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */
      /* Termina nodo:493   */
      /* Termina nodo:492   */
      /* Termina nodo:488   */
      /* Termina nodo:487   */

      /* Empieza nodo:495 / Elemento padre: 486   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(495)).setAttribute("nombre","orde8GapTdId" );
      ((Element)v.get(495)).setAttribute("nowrap","true" );
      ((Element)v.get(495)).setAttribute("class","datosCampos" );
      ((Element)v.get(486)).appendChild((Element)v.get(495));

      /* Empieza nodo:496 / Elemento padre: 495   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(496)).setAttribute("src","b.gif" );
      ((Element)v.get(496)).setAttribute("width","25" );
      ((Element)v.get(496)).setAttribute("height","8" );
      ((Element)v.get(495)).appendChild((Element)v.get(496));
      /* Termina nodo:496   */
      /* Termina nodo:495   */

      /* Empieza nodo:497 / Elemento padre: 486   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(497)).setAttribute("width","100%" );
      ((Element)v.get(486)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(498)).setAttribute("src","b.gif" );
      ((Element)v.get(497)).appendChild((Element)v.get(498));
      /* Termina nodo:498   */
      /* Termina nodo:497   */
      /* Termina nodo:486   */
      /* Termina nodo:485   */
      /* Termina nodo:484   */
      /* Termina nodo:481   */

      /* Empieza nodo:499 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(499)).setAttribute("nombre","formGapTr17" );
      ((Element)v.get(52)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(500)).setAttribute("align","center" );
      ((Element)v.get(500)).setAttribute("width","8" );
      ((Element)v.get(499)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(501)).setAttribute("src","b.gif" );
      ((Element)v.get(501)).setAttribute("width","12" );
      ((Element)v.get(501)).setAttribute("height","8" );
      ((Element)v.get(500)).appendChild((Element)v.get(501));
      /* Termina nodo:501   */
      /* Termina nodo:500   */

      /* Empieza nodo:502 / Elemento padre: 499   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(499)).appendChild((Element)v.get(502));

      /* Empieza nodo:503 / Elemento padre: 502   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(503)).setAttribute("src","b.gif" );
      ((Element)v.get(503)).setAttribute("width","8" );
      ((Element)v.get(503)).setAttribute("height","8" );
      ((Element)v.get(502)).appendChild((Element)v.get(503));
      /* Termina nodo:503   */
      /* Termina nodo:502   */

      /* Empieza nodo:504 / Elemento padre: 499   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(504)).setAttribute("align","center" );
      ((Element)v.get(504)).setAttribute("width","8" );
      ((Element)v.get(499)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(505)).setAttribute("src","b.gif" );
      ((Element)v.get(505)).setAttribute("width","12" );
      ((Element)v.get(505)).setAttribute("height","8" );
      ((Element)v.get(504)).appendChild((Element)v.get(505));
      /* Termina nodo:505   */
      /* Termina nodo:504   */
      /* Termina nodo:499   */

      /* Empieza nodo:506 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(506)).setAttribute("nombre","formTr18" );
      ((Element)v.get(52)).appendChild((Element)v.get(506));

      /* Empieza nodo:507 / Elemento padre: 506   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(507)).setAttribute("align","center" );
      ((Element)v.get(507)).setAttribute("width","8" );
      ((Element)v.get(506)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(508)).setAttribute("src","b.gif" );
      ((Element)v.get(508)).setAttribute("width","8" );
      ((Element)v.get(508)).setAttribute("height","12" );
      ((Element)v.get(507)).appendChild((Element)v.get(508));
      /* Termina nodo:508   */
      /* Termina nodo:507   */

      /* Empieza nodo:509 / Elemento padre: 506   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(509)).setAttribute("width","100%" );
      ((Element)v.get(506)).appendChild((Element)v.get(509));

      /* Empieza nodo:510 / Elemento padre: 509   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(510)).setAttribute("width","100%" );
      ((Element)v.get(510)).setAttribute("border","0" );
      ((Element)v.get(510)).setAttribute("cellspacing","0" );
      ((Element)v.get(510)).setAttribute("cellpadding","0" );
      ((Element)v.get(510)).setAttribute("align","left" );
      ((Element)v.get(509)).appendChild((Element)v.get(510));

      /* Empieza nodo:511 / Elemento padre: 510   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(511)).setAttribute("align","left" );
      ((Element)v.get(510)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(512)).setAttribute("nombre","orde9TdId" );
      ((Element)v.get(511)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(513)).setAttribute("width","100%" );
      ((Element)v.get(513)).setAttribute("border","0" );
      ((Element)v.get(513)).setAttribute("cellspacing","0" );
      ((Element)v.get(513)).setAttribute("cellpadding","0" );
      ((Element)v.get(513)).setAttribute("align","left" );
      ((Element)v.get(512)).appendChild((Element)v.get(513));

      /* Empieza nodo:514 / Elemento padre: 513   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(513)).appendChild((Element)v.get(514));

      /* Empieza nodo:515 / Elemento padre: 514   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(515)).setAttribute("valign","top" );
      ((Element)v.get(515)).setAttribute("height","13" );
      ((Element)v.get(514)).appendChild((Element)v.get(515));

      /* Empieza nodo:516 / Elemento padre: 515   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(516)).setAttribute("nombre","lblOrde9" );
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(516)).setAttribute("alto","13" );
      ((Element)v.get(516)).setAttribute("filas","1" );
      ((Element)v.get(516)).setAttribute("id","datosTitle" );
      ((Element)v.get(516)).setAttribute("cod","ZonValorEstruGeopo.orde9.label" );
      ((Element)v.get(515)).appendChild((Element)v.get(516));
      /* Termina nodo:516   */
      /* Termina nodo:515   */
      /* Termina nodo:514   */

      /* Empieza nodo:517 / Elemento padre: 513   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(517)).setAttribute("nombre","orde9WidgetTrId" );
      ((Element)v.get(513)).appendChild((Element)v.get(517));

      /* Empieza nodo:518 / Elemento padre: 517   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(518)).setAttribute("align","left" );
      ((Element)v.get(518)).setAttribute("nowrap","true" );
      ((Element)v.get(517)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(519)).setAttribute("nombre","orde9" );
      ((Element)v.get(519)).setAttribute("id","datosCampos" );
      ((Element)v.get(519)).setAttribute("trim","S" );
      ((Element)v.get(519)).setAttribute("max","6" );
      ((Element)v.get(519)).setAttribute("onchange","" );
      ((Element)v.get(519)).setAttribute("req","N" );
      ((Element)v.get(519)).setAttribute("size","6" );
      ((Element)v.get(519)).setAttribute("valor","" );
      ((Element)v.get(519)).setAttribute("validacion","" );
      ((Element)v.get(519)).setAttribute("disabled","" );
      ((Element)v.get(519)).setAttribute("onblur","" );
      ((Element)v.get(519)).setAttribute("ontab","ejecutarAccionFoco('zonValorEstruGeopoFrm',0, true)" );
      ((Element)v.get(519)).setAttribute("onshtab","ejecutarAccionFoco('zonValorEstruGeopoFrm', 0, false)" );
      ((Element)v.get(518)).appendChild((Element)v.get(519));
      /* Termina nodo:519   */
      /* Termina nodo:518   */
      /* Termina nodo:517   */
      /* Termina nodo:513   */
      /* Termina nodo:512   */

      /* Empieza nodo:520 / Elemento padre: 511   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(520)).setAttribute("nombre","orde9GapTdId" );
      ((Element)v.get(520)).setAttribute("nowrap","true" );
      ((Element)v.get(520)).setAttribute("class","datosCampos" );
      ((Element)v.get(511)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(521)).setAttribute("src","b.gif" );
      ((Element)v.get(521)).setAttribute("width","25" );
      ((Element)v.get(521)).setAttribute("height","8" );
      ((Element)v.get(520)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */
      /* Termina nodo:520   */

      /* Empieza nodo:522 / Elemento padre: 511   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(522)).setAttribute("width","100%" );
      ((Element)v.get(511)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(523)).setAttribute("src","b.gif" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */
      /* Termina nodo:522   */
      /* Termina nodo:511   */
      /* Termina nodo:510   */
      /* Termina nodo:509   */
      /* Termina nodo:506   */

      /* Empieza nodo:524 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(524)).setAttribute("nombre","formGapTr18" );
      ((Element)v.get(52)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(525)).setAttribute("align","center" );
      ((Element)v.get(525)).setAttribute("width","8" );
      ((Element)v.get(524)).appendChild((Element)v.get(525));

      /* Empieza nodo:526 / Elemento padre: 525   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(526)).setAttribute("src","b.gif" );
      ((Element)v.get(526)).setAttribute("width","12" );
      ((Element)v.get(526)).setAttribute("height","8" );
      ((Element)v.get(525)).appendChild((Element)v.get(526));
      /* Termina nodo:526   */
      /* Termina nodo:525   */

      /* Empieza nodo:527 / Elemento padre: 524   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(524)).appendChild((Element)v.get(527));

      /* Empieza nodo:528 / Elemento padre: 527   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(528)).setAttribute("src","b.gif" );
      ((Element)v.get(528)).setAttribute("width","8" );
      ((Element)v.get(528)).setAttribute("height","8" );
      ((Element)v.get(527)).appendChild((Element)v.get(528));
      /* Termina nodo:528   */
      /* Termina nodo:527   */

      /* Empieza nodo:529 / Elemento padre: 524   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(529)).setAttribute("align","center" );
      ((Element)v.get(529)).setAttribute("width","8" );
      ((Element)v.get(524)).appendChild((Element)v.get(529));

      /* Empieza nodo:530 / Elemento padre: 529   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(530)).setAttribute("src","b.gif" );
      ((Element)v.get(530)).setAttribute("width","12" );
      ((Element)v.get(530)).setAttribute("height","8" );
      ((Element)v.get(529)).appendChild((Element)v.get(530));
      /* Termina nodo:530   */
      /* Termina nodo:529   */
      /* Termina nodo:524   */

      /* Empieza nodo:531 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(531)).setAttribute("nombre","formTr19" );
      ((Element)v.get(52)).appendChild((Element)v.get(531));

      /* Empieza nodo:532 / Elemento padre: 531   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(532)).setAttribute("align","center" );
      ((Element)v.get(532)).setAttribute("width","8" );
      ((Element)v.get(531)).appendChild((Element)v.get(532));

      /* Empieza nodo:533 / Elemento padre: 532   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(533)).setAttribute("src","b.gif" );
      ((Element)v.get(533)).setAttribute("width","8" );
      ((Element)v.get(533)).setAttribute("height","12" );
      ((Element)v.get(532)).appendChild((Element)v.get(533));
      /* Termina nodo:533   */
      /* Termina nodo:532   */

      /* Empieza nodo:534 / Elemento padre: 531   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(534)).setAttribute("width","100%" );
      ((Element)v.get(531)).appendChild((Element)v.get(534));

      /* Empieza nodo:535 / Elemento padre: 534   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(535)).setAttribute("width","100%" );
      ((Element)v.get(535)).setAttribute("border","0" );
      ((Element)v.get(535)).setAttribute("cellspacing","0" );
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(535)).setAttribute("cellpadding","0" );
      ((Element)v.get(535)).setAttribute("align","left" );
      ((Element)v.get(534)).appendChild((Element)v.get(535));

      /* Empieza nodo:536 / Elemento padre: 535   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(536)).setAttribute("align","left" );
      ((Element)v.get(535)).appendChild((Element)v.get(536));

      /* Empieza nodo:537 / Elemento padre: 536   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(537)).setAttribute("nombre","egeoOidEstrGeopTdId" );
      ((Element)v.get(536)).appendChild((Element)v.get(537));

      /* Empieza nodo:538 / Elemento padre: 537   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(538)).setAttribute("border","0" );
      ((Element)v.get(538)).setAttribute("cellspacing","0" );
      ((Element)v.get(538)).setAttribute("cellpadding","0" );
      ((Element)v.get(538)).setAttribute("align","left" );
      ((Element)v.get(537)).appendChild((Element)v.get(538));

      /* Empieza nodo:539 / Elemento padre: 538   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(538)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(540)).setAttribute("valign","top" );
      ((Element)v.get(540)).setAttribute("height","13" );
      ((Element)v.get(539)).appendChild((Element)v.get(540));

      /* Empieza nodo:541 / Elemento padre: 540   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(541)).setAttribute("nombre","lblegeoOidEstrGeop" );
      ((Element)v.get(541)).setAttribute("id","datosTitle" );
      ((Element)v.get(541)).setAttribute("ancho","100" );
      ((Element)v.get(541)).setAttribute("alto","13" );
      ((Element)v.get(541)).setAttribute("cod","ZonValorEstruGeopo.egeoOidEstrGeop.label" );
      ((Element)v.get(540)).appendChild((Element)v.get(541));
      /* Termina nodo:541   */
      /* Termina nodo:540   */
      /* Termina nodo:539   */

      /* Empieza nodo:542 / Elemento padre: 538   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(542)).setAttribute("nombre","egeoOidEstrGeopWidgetTrId" );
      ((Element)v.get(538)).appendChild((Element)v.get(542));

      /* Empieza nodo:543 / Elemento padre: 542   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(543)).setAttribute("align","left" );
      ((Element)v.get(543)).setAttribute("nowrap","true" );
      ((Element)v.get(542)).appendChild((Element)v.get(543));

      /* Empieza nodo:544 / Elemento padre: 543   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(544)).setAttribute("nombre","egeoOidEstrGeop" );
      ((Element)v.get(544)).setAttribute("id","datosCampos" );
      ((Element)v.get(544)).setAttribute("multiple","N" );
      ((Element)v.get(544)).setAttribute("req","N" );
      ((Element)v.get(544)).setAttribute("size","1" );
      ((Element)v.get(544)).setAttribute("disabled","" );
      ((Element)v.get(544)).setAttribute("validacion","" );
      ((Element)v.get(544)).setAttribute("onchange","" );
      ((Element)v.get(544)).setAttribute("onfocus","" );
      ((Element)v.get(544)).setAttribute("valorinicial","" );
      ((Element)v.get(544)).setAttribute("textoinicial","" );
      ((Element)v.get(544)).setAttribute("ontab","ejecutarAccionFoco('zonValorEstruGeopoFrm',0, true);" );
      ((Element)v.get(544)).setAttribute("onshtab","ejecutarAccionFoco('zonValorEstruGeopoFrm',0, false);" );
      ((Element)v.get(543)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(544)).appendChild((Element)v.get(545));
      /* Termina nodo:545   */
      /* Termina nodo:544   */
      /* Termina nodo:543   */
      /* Termina nodo:542   */
      /* Termina nodo:538   */
      /* Termina nodo:537   */

      /* Empieza nodo:546 / Elemento padre: 536   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(546)).setAttribute("nombre","egeoOidEstrGeopGapTdId" );
      ((Element)v.get(546)).setAttribute("nowrap","true" );
      ((Element)v.get(546)).setAttribute("class","datosCampos" );
      ((Element)v.get(536)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(547)).setAttribute("src","b.gif" );
      ((Element)v.get(547)).setAttribute("width","25" );
      ((Element)v.get(547)).setAttribute("height","8" );
      ((Element)v.get(546)).appendChild((Element)v.get(547));
      /* Termina nodo:547   */
      /* Termina nodo:546   */

      /* Empieza nodo:548 / Elemento padre: 536   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(548)).setAttribute("width","100%" );
      ((Element)v.get(536)).appendChild((Element)v.get(548));

      /* Empieza nodo:549 / Elemento padre: 548   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(549)).setAttribute("src","b.gif" );
      ((Element)v.get(548)).appendChild((Element)v.get(549));
      /* Termina nodo:549   */
      /* Termina nodo:548   */
      /* Termina nodo:536   */
      /* Termina nodo:535   */
      /* Termina nodo:534   */
      /* Termina nodo:531   */

      /* Empieza nodo:550 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(550)).setAttribute("nombre","formGapTr19" );
      ((Element)v.get(52)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(551)).setAttribute("align","center" );
      ((Element)v.get(551)).setAttribute("width","8" );
      ((Element)v.get(550)).appendChild((Element)v.get(551));

      /* Empieza nodo:552 / Elemento padre: 551   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(552)).setAttribute("src","b.gif" );
      ((Element)v.get(552)).setAttribute("width","12" );
      ((Element)v.get(552)).setAttribute("height","8" );
      ((Element)v.get(551)).appendChild((Element)v.get(552));
      /* Termina nodo:552   */
      /* Termina nodo:551   */

      /* Empieza nodo:553 / Elemento padre: 550   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(550)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(554)).setAttribute("src","b.gif" );
      ((Element)v.get(554)).setAttribute("width","8" );
      ((Element)v.get(554)).setAttribute("height","8" );
      ((Element)v.get(553)).appendChild((Element)v.get(554));
      /* Termina nodo:554   */
      /* Termina nodo:553   */

      /* Empieza nodo:555 / Elemento padre: 550   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(555)).setAttribute("align","center" );
      ((Element)v.get(555)).setAttribute("width","8" );
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(550)).appendChild((Element)v.get(555));

      /* Empieza nodo:556 / Elemento padre: 555   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(556)).setAttribute("src","b.gif" );
      ((Element)v.get(556)).setAttribute("width","12" );
      ((Element)v.get(556)).setAttribute("height","8" );
      ((Element)v.get(555)).appendChild((Element)v.get(556));
      /* Termina nodo:556   */
      /* Termina nodo:555   */
      /* Termina nodo:550   */

      /* Empieza nodo:557 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(557)).setAttribute("nombre","formTr20" );
      ((Element)v.get(52)).appendChild((Element)v.get(557));

      /* Empieza nodo:558 / Elemento padre: 557   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(558)).setAttribute("align","center" );
      ((Element)v.get(558)).setAttribute("width","8" );
      ((Element)v.get(557)).appendChild((Element)v.get(558));

      /* Empieza nodo:559 / Elemento padre: 558   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(559)).setAttribute("src","b.gif" );
      ((Element)v.get(559)).setAttribute("width","8" );
      ((Element)v.get(559)).setAttribute("height","12" );
      ((Element)v.get(558)).appendChild((Element)v.get(559));
      /* Termina nodo:559   */
      /* Termina nodo:558   */

      /* Empieza nodo:560 / Elemento padre: 557   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(560)).setAttribute("width","100%" );
      ((Element)v.get(557)).appendChild((Element)v.get(560));

      /* Empieza nodo:561 / Elemento padre: 560   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(561)).setAttribute("width","100%" );
      ((Element)v.get(561)).setAttribute("border","0" );
      ((Element)v.get(561)).setAttribute("cellspacing","0" );
      ((Element)v.get(561)).setAttribute("cellpadding","0" );
      ((Element)v.get(561)).setAttribute("align","left" );
      ((Element)v.get(560)).appendChild((Element)v.get(561));

      /* Empieza nodo:562 / Elemento padre: 561   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(562)).setAttribute("align","left" );
      ((Element)v.get(561)).appendChild((Element)v.get(562));

      /* Empieza nodo:563 / Elemento padre: 562   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(563)).setAttribute("nombre","paisOidPais_moneOidMoneAltTdId" );
      ((Element)v.get(562)).appendChild((Element)v.get(563));

      /* Empieza nodo:564 / Elemento padre: 563   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(564)).setAttribute("border","0" );
      ((Element)v.get(564)).setAttribute("cellspacing","0" );
      ((Element)v.get(564)).setAttribute("cellpadding","0" );
      ((Element)v.get(564)).setAttribute("align","left" );
      ((Element)v.get(563)).appendChild((Element)v.get(564));

      /* Empieza nodo:565 / Elemento padre: 564   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(564)).appendChild((Element)v.get(565));

      /* Empieza nodo:566 / Elemento padre: 565   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(566)).setAttribute("valign","top" );
      ((Element)v.get(566)).setAttribute("height","13" );
      ((Element)v.get(565)).appendChild((Element)v.get(566));

      /* Empieza nodo:567 / Elemento padre: 566   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(567)).setAttribute("nombre","lblpaisOidPais_moneOidMoneAlt" );
      ((Element)v.get(567)).setAttribute("id","datosTitle" );
      ((Element)v.get(567)).setAttribute("ancho","100" );
      ((Element)v.get(567)).setAttribute("alto","13" );
      ((Element)v.get(567)).setAttribute("cod","SegPais.moneOidMoneAlt.label" );
      ((Element)v.get(566)).appendChild((Element)v.get(567));
      /* Termina nodo:567   */
      /* Termina nodo:566   */
      /* Termina nodo:565   */

      /* Empieza nodo:568 / Elemento padre: 564   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(568)).setAttribute("nombre","paisOidPais_moneOidMoneAltWidgetTrId" );
      ((Element)v.get(564)).appendChild((Element)v.get(568));

      /* Empieza nodo:569 / Elemento padre: 568   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(569)).setAttribute("align","left" );
      ((Element)v.get(569)).setAttribute("nowrap","true" );
      ((Element)v.get(568)).appendChild((Element)v.get(569));

      /* Empieza nodo:570 / Elemento padre: 569   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(570)).setAttribute("nombre","paisOidPais_moneOidMoneAlt" );
      ((Element)v.get(570)).setAttribute("id","datosCampos" );
      ((Element)v.get(570)).setAttribute("multiple","N" );
      ((Element)v.get(570)).setAttribute("req","N" );
      ((Element)v.get(570)).setAttribute("size","1" );
      ((Element)v.get(570)).setAttribute("disabled","" );
      ((Element)v.get(570)).setAttribute("validacion","" );
      ((Element)v.get(570)).setAttribute("onchange","mmgDependeneChange('paisOidPais_moneOidMoneAlt', 'paisOidPais' , 'zonValorEstruGeopo')" );
      ((Element)v.get(570)).setAttribute("onfocus","" );
      ((Element)v.get(570)).setAttribute("valorinicial","" );
      ((Element)v.get(570)).setAttribute("textoinicial","" );
      ((Element)v.get(570)).setAttribute("ontab","focaliza('zonValorEstruGeopoFrm.paisOidPais_fopaOidFormPago');" );
      ((Element)v.get(570)).setAttribute("onshtab","ejecutarAccionFoco('zonValorEstruGeopoFrm',0, false);" );
      ((Element)v.get(569)).appendChild((Element)v.get(570));

      /* Empieza nodo:571 / Elemento padre: 570   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(570)).appendChild((Element)v.get(571));
      /* Termina nodo:571   */
      /* Termina nodo:570   */
      /* Termina nodo:569   */
      /* Termina nodo:568   */
      /* Termina nodo:564   */
      /* Termina nodo:563   */

      /* Empieza nodo:572 / Elemento padre: 562   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(572)).setAttribute("nombre","paisOidPais_moneOidMoneAltGapTdId" );
      ((Element)v.get(572)).setAttribute("nowrap","true" );
      ((Element)v.get(572)).setAttribute("class","datosCampos" );
      ((Element)v.get(562)).appendChild((Element)v.get(572));

      /* Empieza nodo:573 / Elemento padre: 572   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(573)).setAttribute("src","b.gif" );
      ((Element)v.get(573)).setAttribute("width","25" );
      ((Element)v.get(573)).setAttribute("height","8" );
      ((Element)v.get(572)).appendChild((Element)v.get(573));
      /* Termina nodo:573   */
      /* Termina nodo:572   */

      /* Empieza nodo:574 / Elemento padre: 562   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(574)).setAttribute("nombre","paisOidPais_fopaOidFormPagoTdId" );
      ((Element)v.get(562)).appendChild((Element)v.get(574));

      /* Empieza nodo:575 / Elemento padre: 574   */
   }

   private void getXML2610(Document doc) {
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(575)).setAttribute("border","0" );
      ((Element)v.get(575)).setAttribute("cellspacing","0" );
      ((Element)v.get(575)).setAttribute("cellpadding","0" );
      ((Element)v.get(575)).setAttribute("align","left" );
      ((Element)v.get(574)).appendChild((Element)v.get(575));

      /* Empieza nodo:576 / Elemento padre: 575   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(575)).appendChild((Element)v.get(576));

      /* Empieza nodo:577 / Elemento padre: 576   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(577)).setAttribute("valign","top" );
      ((Element)v.get(577)).setAttribute("height","13" );
      ((Element)v.get(576)).appendChild((Element)v.get(577));

      /* Empieza nodo:578 / Elemento padre: 577   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(578)).setAttribute("nombre","lblpaisOidPais_fopaOidFormPago" );
      ((Element)v.get(578)).setAttribute("id","datosTitle" );
      ((Element)v.get(578)).setAttribute("ancho","100" );
      ((Element)v.get(578)).setAttribute("alto","13" );
      ((Element)v.get(578)).setAttribute("cod","SegPais.fopaOidFormPago.label" );
      ((Element)v.get(577)).appendChild((Element)v.get(578));
      /* Termina nodo:578   */
      /* Termina nodo:577   */
      /* Termina nodo:576   */

      /* Empieza nodo:579 / Elemento padre: 575   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(579)).setAttribute("nombre","paisOidPais_fopaOidFormPagoWidgetTrId" );
      ((Element)v.get(575)).appendChild((Element)v.get(579));

      /* Empieza nodo:580 / Elemento padre: 579   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(580)).setAttribute("align","left" );
      ((Element)v.get(580)).setAttribute("nowrap","true" );
      ((Element)v.get(579)).appendChild((Element)v.get(580));

      /* Empieza nodo:581 / Elemento padre: 580   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(581)).setAttribute("nombre","paisOidPais_fopaOidFormPago" );
      ((Element)v.get(581)).setAttribute("id","datosCampos" );
      ((Element)v.get(581)).setAttribute("multiple","N" );
      ((Element)v.get(581)).setAttribute("req","N" );
      ((Element)v.get(581)).setAttribute("size","1" );
      ((Element)v.get(581)).setAttribute("disabled","" );
      ((Element)v.get(581)).setAttribute("validacion","" );
      ((Element)v.get(581)).setAttribute("onchange","mmgDependeneChange('paisOidPais_fopaOidFormPago', 'paisOidPais' , 'zonValorEstruGeopo')" );
      ((Element)v.get(581)).setAttribute("onfocus","" );
      ((Element)v.get(581)).setAttribute("valorinicial","" );
      ((Element)v.get(581)).setAttribute("textoinicial","" );
      ((Element)v.get(581)).setAttribute("ontab","focaliza('zonValorEstruGeopoFrm.paisOidPais_moneOidMone');" );
      ((Element)v.get(581)).setAttribute("onshtab","ejecutarAccionFoco('zonValorEstruGeopoFrm',0, false);" );
      ((Element)v.get(580)).appendChild((Element)v.get(581));

      /* Empieza nodo:582 / Elemento padre: 581   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(581)).appendChild((Element)v.get(582));
      /* Termina nodo:582   */
      /* Termina nodo:581   */
      /* Termina nodo:580   */
      /* Termina nodo:579   */
      /* Termina nodo:575   */
      /* Termina nodo:574   */

      /* Empieza nodo:583 / Elemento padre: 562   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(583)).setAttribute("nombre","paisOidPais_fopaOidFormPagoGapTdId" );
      ((Element)v.get(583)).setAttribute("nowrap","true" );
      ((Element)v.get(583)).setAttribute("class","datosCampos" );
      ((Element)v.get(562)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(584)).setAttribute("src","b.gif" );
      ((Element)v.get(584)).setAttribute("width","25" );
      ((Element)v.get(584)).setAttribute("height","8" );
      ((Element)v.get(583)).appendChild((Element)v.get(584));
      /* Termina nodo:584   */
      /* Termina nodo:583   */

      /* Empieza nodo:585 / Elemento padre: 562   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(585)).setAttribute("nombre","paisOidPais_moneOidMoneTdId" );
      ((Element)v.get(562)).appendChild((Element)v.get(585));

      /* Empieza nodo:586 / Elemento padre: 585   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(586)).setAttribute("border","0" );
      ((Element)v.get(586)).setAttribute("cellspacing","0" );
      ((Element)v.get(586)).setAttribute("cellpadding","0" );
      ((Element)v.get(586)).setAttribute("align","left" );
      ((Element)v.get(585)).appendChild((Element)v.get(586));

      /* Empieza nodo:587 / Elemento padre: 586   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(586)).appendChild((Element)v.get(587));

      /* Empieza nodo:588 / Elemento padre: 587   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(588)).setAttribute("valign","top" );
      ((Element)v.get(588)).setAttribute("height","13" );
      ((Element)v.get(587)).appendChild((Element)v.get(588));

      /* Empieza nodo:589 / Elemento padre: 588   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(589)).setAttribute("nombre","lblpaisOidPais_moneOidMone" );
      ((Element)v.get(589)).setAttribute("id","datosTitle" );
      ((Element)v.get(589)).setAttribute("ancho","100" );
      ((Element)v.get(589)).setAttribute("alto","13" );
      ((Element)v.get(589)).setAttribute("cod","SegPais.moneOidMone.label" );
      ((Element)v.get(588)).appendChild((Element)v.get(589));
      /* Termina nodo:589   */
      /* Termina nodo:588   */
      /* Termina nodo:587   */

      /* Empieza nodo:590 / Elemento padre: 586   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(590)).setAttribute("nombre","paisOidPais_moneOidMoneWidgetTrId" );
      ((Element)v.get(586)).appendChild((Element)v.get(590));

      /* Empieza nodo:591 / Elemento padre: 590   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(591)).setAttribute("align","left" );
      ((Element)v.get(591)).setAttribute("nowrap","true" );
      ((Element)v.get(590)).appendChild((Element)v.get(591));

      /* Empieza nodo:592 / Elemento padre: 591   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(592)).setAttribute("nombre","paisOidPais_moneOidMone" );
      ((Element)v.get(592)).setAttribute("id","datosCampos" );
      ((Element)v.get(592)).setAttribute("multiple","N" );
      ((Element)v.get(592)).setAttribute("req","N" );
      ((Element)v.get(592)).setAttribute("size","1" );
      ((Element)v.get(592)).setAttribute("disabled","" );
      ((Element)v.get(592)).setAttribute("validacion","" );
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(592)).setAttribute("onchange","mmgDependeneChange('paisOidPais_moneOidMone', 'paisOidPais' , 'zonValorEstruGeopo')" );
      ((Element)v.get(592)).setAttribute("onfocus","" );
      ((Element)v.get(592)).setAttribute("valorinicial","" );
      ((Element)v.get(592)).setAttribute("textoinicial","" );
      ((Element)v.get(592)).setAttribute("ontab","focaliza('zonValorEstruGeopoFrm.paisOidPais');" );
      ((Element)v.get(592)).setAttribute("onshtab","ejecutarAccionFoco('zonValorEstruGeopoFrm',0, false);" );
      ((Element)v.get(591)).appendChild((Element)v.get(592));

      /* Empieza nodo:593 / Elemento padre: 592   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(592)).appendChild((Element)v.get(593));
      /* Termina nodo:593   */
      /* Termina nodo:592   */
      /* Termina nodo:591   */
      /* Termina nodo:590   */
      /* Termina nodo:586   */
      /* Termina nodo:585   */

      /* Empieza nodo:594 / Elemento padre: 562   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(594)).setAttribute("nombre","paisOidPais_moneOidMoneGapTdId" );
      ((Element)v.get(594)).setAttribute("nowrap","true" );
      ((Element)v.get(594)).setAttribute("class","datosCampos" );
      ((Element)v.get(562)).appendChild((Element)v.get(594));

      /* Empieza nodo:595 / Elemento padre: 594   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(595)).setAttribute("src","b.gif" );
      ((Element)v.get(595)).setAttribute("width","25" );
      ((Element)v.get(595)).setAttribute("height","8" );
      ((Element)v.get(594)).appendChild((Element)v.get(595));
      /* Termina nodo:595   */
      /* Termina nodo:594   */

      /* Empieza nodo:596 / Elemento padre: 562   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(596)).setAttribute("nombre","paisOidPaisTdId" );
      ((Element)v.get(562)).appendChild((Element)v.get(596));

      /* Empieza nodo:597 / Elemento padre: 596   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(597)).setAttribute("border","0" );
      ((Element)v.get(597)).setAttribute("cellspacing","0" );
      ((Element)v.get(597)).setAttribute("cellpadding","0" );
      ((Element)v.get(597)).setAttribute("align","left" );
      ((Element)v.get(596)).appendChild((Element)v.get(597));

      /* Empieza nodo:598 / Elemento padre: 597   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(597)).appendChild((Element)v.get(598));

      /* Empieza nodo:599 / Elemento padre: 598   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(599)).setAttribute("valign","top" );
      ((Element)v.get(599)).setAttribute("height","13" );
      ((Element)v.get(598)).appendChild((Element)v.get(599));

      /* Empieza nodo:600 / Elemento padre: 599   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(600)).setAttribute("nombre","lblpaisOidPais" );
      ((Element)v.get(600)).setAttribute("id","datosTitle" );
      ((Element)v.get(600)).setAttribute("ancho","100" );
      ((Element)v.get(600)).setAttribute("alto","13" );
      ((Element)v.get(600)).setAttribute("cod","ZonValorEstruGeopo.paisOidPais.label" );
      ((Element)v.get(599)).appendChild((Element)v.get(600));
      /* Termina nodo:600   */
      /* Termina nodo:599   */
      /* Termina nodo:598   */

      /* Empieza nodo:601 / Elemento padre: 597   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(601)).setAttribute("nombre","paisOidPaisWidgetTrId" );
      ((Element)v.get(597)).appendChild((Element)v.get(601));

      /* Empieza nodo:602 / Elemento padre: 601   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(602)).setAttribute("align","left" );
      ((Element)v.get(602)).setAttribute("nowrap","true" );
      ((Element)v.get(601)).appendChild((Element)v.get(602));

      /* Empieza nodo:603 / Elemento padre: 602   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(603)).setAttribute("nombre","paisOidPais" );
      ((Element)v.get(603)).setAttribute("id","datosCampos" );
      ((Element)v.get(603)).setAttribute("multiple","N" );
      ((Element)v.get(603)).setAttribute("req","N" );
      ((Element)v.get(603)).setAttribute("size","1" );
      ((Element)v.get(603)).setAttribute("disabled","" );
      ((Element)v.get(603)).setAttribute("validacion","" );
      ((Element)v.get(603)).setAttribute("onchange","" );
      ((Element)v.get(603)).setAttribute("onfocus","" );
      ((Element)v.get(603)).setAttribute("valorinicial","" );
      ((Element)v.get(603)).setAttribute("textoinicial","" );
      ((Element)v.get(603)).setAttribute("ontab","ejecutarAccionFoco('zonValorEstruGeopoFrm',0, true);" );
      ((Element)v.get(603)).setAttribute("onshtab","focaliza('zonValorEstruGeopoFrm.paisOidPais_moneOidMone');" );
      ((Element)v.get(602)).appendChild((Element)v.get(603));

      /* Empieza nodo:604 / Elemento padre: 603   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(603)).appendChild((Element)v.get(604));
      /* Termina nodo:604   */
      /* Termina nodo:603   */
      /* Termina nodo:602   */
      /* Termina nodo:601   */
      /* Termina nodo:597   */
      /* Termina nodo:596   */

      /* Empieza nodo:605 / Elemento padre: 562   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(605)).setAttribute("nombre","paisOidPaisGapTdId" );
      ((Element)v.get(605)).setAttribute("nowrap","true" );
      ((Element)v.get(605)).setAttribute("class","datosCampos" );
      ((Element)v.get(562)).appendChild((Element)v.get(605));

      /* Empieza nodo:606 / Elemento padre: 605   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(606)).setAttribute("src","b.gif" );
      ((Element)v.get(606)).setAttribute("width","25" );
      ((Element)v.get(606)).setAttribute("height","8" );
      ((Element)v.get(605)).appendChild((Element)v.get(606));
      /* Termina nodo:606   */
      /* Termina nodo:605   */

      /* Empieza nodo:607 / Elemento padre: 562   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(607)).setAttribute("width","100%" );
      ((Element)v.get(562)).appendChild((Element)v.get(607));

      /* Empieza nodo:608 / Elemento padre: 607   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(608)).setAttribute("src","b.gif" );
      ((Element)v.get(607)).appendChild((Element)v.get(608));
      /* Termina nodo:608   */
      /* Termina nodo:607   */
      /* Termina nodo:562   */
      /* Termina nodo:561   */
      /* Termina nodo:560   */
      /* Termina nodo:557   */

      /* Empieza nodo:609 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(609)).setAttribute("nombre","formGapTr20" );
      ((Element)v.get(52)).appendChild((Element)v.get(609));

      /* Empieza nodo:610 / Elemento padre: 609   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(610)).setAttribute("align","center" );
      ((Element)v.get(610)).setAttribute("width","8" );
      ((Element)v.get(609)).appendChild((Element)v.get(610));

      /* Empieza nodo:611 / Elemento padre: 610   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(611)).setAttribute("src","b.gif" );
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(611)).setAttribute("width","12" );
      ((Element)v.get(611)).setAttribute("height","8" );
      ((Element)v.get(610)).appendChild((Element)v.get(611));
      /* Termina nodo:611   */
      /* Termina nodo:610   */

      /* Empieza nodo:612 / Elemento padre: 609   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(609)).appendChild((Element)v.get(612));

      /* Empieza nodo:613 / Elemento padre: 612   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(613)).setAttribute("src","b.gif" );
      ((Element)v.get(613)).setAttribute("width","8" );
      ((Element)v.get(613)).setAttribute("height","8" );
      ((Element)v.get(612)).appendChild((Element)v.get(613));
      /* Termina nodo:613   */
      /* Termina nodo:612   */

      /* Empieza nodo:614 / Elemento padre: 609   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(614)).setAttribute("align","center" );
      ((Element)v.get(614)).setAttribute("width","8" );
      ((Element)v.get(609)).appendChild((Element)v.get(614));

      /* Empieza nodo:615 / Elemento padre: 614   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(615)).setAttribute("src","b.gif" );
      ((Element)v.get(615)).setAttribute("width","12" );
      ((Element)v.get(615)).setAttribute("height","8" );
      ((Element)v.get(614)).appendChild((Element)v.get(615));
      /* Termina nodo:615   */
      /* Termina nodo:614   */
      /* Termina nodo:609   */

      /* Empieza nodo:616 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(616)).setAttribute("nombre","formTr21" );
      ((Element)v.get(52)).appendChild((Element)v.get(616));

      /* Empieza nodo:617 / Elemento padre: 616   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(617)).setAttribute("align","center" );
      ((Element)v.get(617)).setAttribute("width","8" );
      ((Element)v.get(616)).appendChild((Element)v.get(617));

      /* Empieza nodo:618 / Elemento padre: 617   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(618)).setAttribute("src","b.gif" );
      ((Element)v.get(618)).setAttribute("width","8" );
      ((Element)v.get(618)).setAttribute("height","12" );
      ((Element)v.get(617)).appendChild((Element)v.get(618));
      /* Termina nodo:618   */
      /* Termina nodo:617   */

      /* Empieza nodo:619 / Elemento padre: 616   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(619)).setAttribute("width","100%" );
      ((Element)v.get(616)).appendChild((Element)v.get(619));

      /* Empieza nodo:620 / Elemento padre: 619   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(620)).setAttribute("width","100%" );
      ((Element)v.get(620)).setAttribute("border","0" );
      ((Element)v.get(620)).setAttribute("cellspacing","0" );
      ((Element)v.get(620)).setAttribute("cellpadding","0" );
      ((Element)v.get(620)).setAttribute("align","left" );
      ((Element)v.get(619)).appendChild((Element)v.get(620));

      /* Empieza nodo:621 / Elemento padre: 620   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(621)).setAttribute("align","left" );
      ((Element)v.get(620)).appendChild((Element)v.get(621));

      /* Empieza nodo:622 / Elemento padre: 621   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(622)).setAttribute("nombre","fecActuTdId" );
      ((Element)v.get(621)).appendChild((Element)v.get(622));

      /* Empieza nodo:623 / Elemento padre: 622   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(623)).setAttribute("width","100%" );
      ((Element)v.get(623)).setAttribute("border","0" );
      ((Element)v.get(623)).setAttribute("cellspacing","0" );
      ((Element)v.get(623)).setAttribute("cellpadding","0" );
      ((Element)v.get(623)).setAttribute("align","left" );
      ((Element)v.get(622)).appendChild((Element)v.get(623));

      /* Empieza nodo:624 / Elemento padre: 623   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(623)).appendChild((Element)v.get(624));

      /* Empieza nodo:625 / Elemento padre: 624   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(625)).setAttribute("valign","top" );
      ((Element)v.get(625)).setAttribute("height","13" );
      ((Element)v.get(624)).appendChild((Element)v.get(625));

      /* Empieza nodo:626 / Elemento padre: 625   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(626)).setAttribute("nombre","lblFecActu" );
      ((Element)v.get(626)).setAttribute("alto","13" );
      ((Element)v.get(626)).setAttribute("filas","1" );
      ((Element)v.get(626)).setAttribute("id","datosTitle" );
      ((Element)v.get(626)).setAttribute("cod","ZonValorEstruGeopo.fecActu.label" );
      ((Element)v.get(625)).appendChild((Element)v.get(626));
      /* Termina nodo:626   */
      /* Termina nodo:625   */
      /* Termina nodo:624   */

      /* Empieza nodo:627 / Elemento padre: 623   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(627)).setAttribute("nombre","fecActuWidgetTrId" );
      ((Element)v.get(623)).appendChild((Element)v.get(627));

      /* Empieza nodo:628 / Elemento padre: 627   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(628)).setAttribute("align","left" );
      ((Element)v.get(628)).setAttribute("nowrap","true" );
      ((Element)v.get(627)).appendChild((Element)v.get(628));

      /* Empieza nodo:629 / Elemento padre: 628   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(629)).setAttribute("nombre","fecActu" );
      ((Element)v.get(629)).setAttribute("id","datosCampos" );
      ((Element)v.get(629)).setAttribute("trim","S" );
      ((Element)v.get(629)).setAttribute("max","7" );
      ((Element)v.get(629)).setAttribute("onchange","" );
      ((Element)v.get(629)).setAttribute("req","N" );
      ((Element)v.get(629)).setAttribute("size","7" );
      ((Element)v.get(629)).setAttribute("valor","" );
      ((Element)v.get(629)).setAttribute("validacion","" );
      ((Element)v.get(629)).setAttribute("disabled","" );
      ((Element)v.get(629)).setAttribute("onblur","" );
      ((Element)v.get(629)).setAttribute("ontab","ejecutarAccionFoco('zonValorEstruGeopoFrm',0, true)" );
      ((Element)v.get(629)).setAttribute("onshtab","ejecutarAccionFoco('zonValorEstruGeopoFrm', 0, false)" );
      ((Element)v.get(628)).appendChild((Element)v.get(629));
      /* Termina nodo:629   */
      /* Termina nodo:628   */
      /* Termina nodo:627   */
      /* Termina nodo:623   */
      /* Termina nodo:622   */

      /* Empieza nodo:630 / Elemento padre: 621   */
      v.add(doc.createElement("TD"));
   }

   private void getXML2880(Document doc) {
      ((Element)v.get(630)).setAttribute("nombre","fecActuGapTdId" );
      ((Element)v.get(630)).setAttribute("nowrap","true" );
      ((Element)v.get(630)).setAttribute("class","datosCampos" );
      ((Element)v.get(621)).appendChild((Element)v.get(630));

      /* Empieza nodo:631 / Elemento padre: 630   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(631)).setAttribute("src","b.gif" );
      ((Element)v.get(631)).setAttribute("width","25" );
      ((Element)v.get(631)).setAttribute("height","8" );
      ((Element)v.get(630)).appendChild((Element)v.get(631));
      /* Termina nodo:631   */
      /* Termina nodo:630   */

      /* Empieza nodo:632 / Elemento padre: 621   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(632)).setAttribute("width","100%" );
      ((Element)v.get(621)).appendChild((Element)v.get(632));

      /* Empieza nodo:633 / Elemento padre: 632   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(633)).setAttribute("src","b.gif" );
      ((Element)v.get(632)).appendChild((Element)v.get(633));
      /* Termina nodo:633   */
      /* Termina nodo:632   */
      /* Termina nodo:621   */
      /* Termina nodo:620   */
      /* Termina nodo:619   */
      /* Termina nodo:616   */

      /* Empieza nodo:634 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(634)).setAttribute("nombre","formGapTr21" );
      ((Element)v.get(52)).appendChild((Element)v.get(634));

      /* Empieza nodo:635 / Elemento padre: 634   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(635)).setAttribute("align","center" );
      ((Element)v.get(635)).setAttribute("width","8" );
      ((Element)v.get(634)).appendChild((Element)v.get(635));

      /* Empieza nodo:636 / Elemento padre: 635   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(636)).setAttribute("src","b.gif" );
      ((Element)v.get(636)).setAttribute("width","12" );
      ((Element)v.get(636)).setAttribute("height","8" );
      ((Element)v.get(635)).appendChild((Element)v.get(636));
      /* Termina nodo:636   */
      /* Termina nodo:635   */

      /* Empieza nodo:637 / Elemento padre: 634   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(634)).appendChild((Element)v.get(637));

      /* Empieza nodo:638 / Elemento padre: 637   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(638)).setAttribute("src","b.gif" );
      ((Element)v.get(638)).setAttribute("width","8" );
      ((Element)v.get(638)).setAttribute("height","8" );
      ((Element)v.get(637)).appendChild((Element)v.get(638));
      /* Termina nodo:638   */
      /* Termina nodo:637   */

      /* Empieza nodo:639 / Elemento padre: 634   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(639)).setAttribute("align","center" );
      ((Element)v.get(639)).setAttribute("width","8" );
      ((Element)v.get(634)).appendChild((Element)v.get(639));

      /* Empieza nodo:640 / Elemento padre: 639   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(640)).setAttribute("src","b.gif" );
      ((Element)v.get(640)).setAttribute("width","12" );
      ((Element)v.get(640)).setAttribute("height","8" );
      ((Element)v.get(639)).appendChild((Element)v.get(640));
      /* Termina nodo:640   */
      /* Termina nodo:639   */
      /* Termina nodo:634   */

      /* Empieza nodo:641 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(641)).setAttribute("nombre","formTr22" );
      ((Element)v.get(52)).appendChild((Element)v.get(641));

      /* Empieza nodo:642 / Elemento padre: 641   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(642)).setAttribute("align","center" );
      ((Element)v.get(642)).setAttribute("width","8" );
      ((Element)v.get(641)).appendChild((Element)v.get(642));

      /* Empieza nodo:643 / Elemento padre: 642   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(643)).setAttribute("src","b.gif" );
      ((Element)v.get(643)).setAttribute("width","8" );
      ((Element)v.get(643)).setAttribute("height","12" );
      ((Element)v.get(642)).appendChild((Element)v.get(643));
      /* Termina nodo:643   */
      /* Termina nodo:642   */

      /* Empieza nodo:644 / Elemento padre: 641   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(644)).setAttribute("width","100%" );
      ((Element)v.get(641)).appendChild((Element)v.get(644));

      /* Empieza nodo:645 / Elemento padre: 644   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(645)).setAttribute("width","100%" );
      ((Element)v.get(645)).setAttribute("border","0" );
      ((Element)v.get(645)).setAttribute("cellspacing","0" );
      ((Element)v.get(645)).setAttribute("cellpadding","0" );
      ((Element)v.get(645)).setAttribute("align","left" );
      ((Element)v.get(644)).appendChild((Element)v.get(645));

      /* Empieza nodo:646 / Elemento padre: 645   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(646)).setAttribute("align","left" );
      ((Element)v.get(645)).appendChild((Element)v.get(646));

      /* Empieza nodo:647 / Elemento padre: 646   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(647)).setAttribute("nombre","sgeoOidSubeGeop_egeoOidEstrGeopTdId" );
      ((Element)v.get(646)).appendChild((Element)v.get(647));

      /* Empieza nodo:648 / Elemento padre: 647   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(648)).setAttribute("border","0" );
      ((Element)v.get(648)).setAttribute("cellspacing","0" );
      ((Element)v.get(648)).setAttribute("cellpadding","0" );
      ((Element)v.get(648)).setAttribute("align","left" );
      ((Element)v.get(647)).appendChild((Element)v.get(648));

      /* Empieza nodo:649 / Elemento padre: 648   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(648)).appendChild((Element)v.get(649));

      /* Empieza nodo:650 / Elemento padre: 649   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(650)).setAttribute("valign","top" );
      ((Element)v.get(650)).setAttribute("height","13" );
      ((Element)v.get(649)).appendChild((Element)v.get(650));

      /* Empieza nodo:651 / Elemento padre: 650   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(651)).setAttribute("nombre","lblsgeoOidSubeGeop_egeoOidEstrGeop" );
      ((Element)v.get(651)).setAttribute("id","datosTitle" );
      ((Element)v.get(651)).setAttribute("ancho","100" );
      ((Element)v.get(651)).setAttribute("alto","13" );
      ((Element)v.get(651)).setAttribute("cod","ZonSubesGeopo.egeoOidEstrGeop.label" );
      ((Element)v.get(650)).appendChild((Element)v.get(651));
      /* Termina nodo:651   */
      /* Termina nodo:650   */
      /* Termina nodo:649   */

      /* Empieza nodo:652 / Elemento padre: 648   */
   }

   private void getXML2970(Document doc) {
      v.add(doc.createElement("TR"));
      ((Element)v.get(652)).setAttribute("nombre","sgeoOidSubeGeop_egeoOidEstrGeopWidgetTrId" );
      ((Element)v.get(648)).appendChild((Element)v.get(652));

      /* Empieza nodo:653 / Elemento padre: 652   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(653)).setAttribute("align","left" );
      ((Element)v.get(653)).setAttribute("nowrap","true" );
      ((Element)v.get(652)).appendChild((Element)v.get(653));

      /* Empieza nodo:654 / Elemento padre: 653   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(654)).setAttribute("nombre","sgeoOidSubeGeop_egeoOidEstrGeop" );
      ((Element)v.get(654)).setAttribute("id","datosCampos" );
      ((Element)v.get(654)).setAttribute("multiple","N" );
      ((Element)v.get(654)).setAttribute("req","N" );
      ((Element)v.get(654)).setAttribute("size","1" );
      ((Element)v.get(654)).setAttribute("disabled","" );
      ((Element)v.get(654)).setAttribute("validacion","" );
      ((Element)v.get(654)).setAttribute("onchange","mmgDependeneChange('sgeoOidSubeGeop_egeoOidEstrGeop', 'sgeoOidSubeGeop' , 'zonValorEstruGeopo')" );
      ((Element)v.get(654)).setAttribute("onfocus","" );
      ((Element)v.get(654)).setAttribute("valorinicial","" );
      ((Element)v.get(654)).setAttribute("textoinicial","" );
      ((Element)v.get(654)).setAttribute("ontab","focaliza('zonValorEstruGeopoFrm.sgeoOidSubeGeop');" );
      ((Element)v.get(654)).setAttribute("onshtab","ejecutarAccionFoco('zonValorEstruGeopoFrm',0, false);" );
      ((Element)v.get(653)).appendChild((Element)v.get(654));

      /* Empieza nodo:655 / Elemento padre: 654   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(654)).appendChild((Element)v.get(655));
      /* Termina nodo:655   */
      /* Termina nodo:654   */
      /* Termina nodo:653   */
      /* Termina nodo:652   */
      /* Termina nodo:648   */
      /* Termina nodo:647   */

      /* Empieza nodo:656 / Elemento padre: 646   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(656)).setAttribute("nombre","sgeoOidSubeGeop_egeoOidEstrGeopGapTdId" );
      ((Element)v.get(656)).setAttribute("nowrap","true" );
      ((Element)v.get(656)).setAttribute("class","datosCampos" );
      ((Element)v.get(646)).appendChild((Element)v.get(656));

      /* Empieza nodo:657 / Elemento padre: 656   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(657)).setAttribute("src","b.gif" );
      ((Element)v.get(657)).setAttribute("width","25" );
      ((Element)v.get(657)).setAttribute("height","8" );
      ((Element)v.get(656)).appendChild((Element)v.get(657));
      /* Termina nodo:657   */
      /* Termina nodo:656   */

      /* Empieza nodo:658 / Elemento padre: 646   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(658)).setAttribute("nombre","sgeoOidSubeGeopTdId" );
      ((Element)v.get(646)).appendChild((Element)v.get(658));

      /* Empieza nodo:659 / Elemento padre: 658   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(659)).setAttribute("border","0" );
      ((Element)v.get(659)).setAttribute("cellspacing","0" );
      ((Element)v.get(659)).setAttribute("cellpadding","0" );
      ((Element)v.get(659)).setAttribute("align","left" );
      ((Element)v.get(658)).appendChild((Element)v.get(659));

      /* Empieza nodo:660 / Elemento padre: 659   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(659)).appendChild((Element)v.get(660));

      /* Empieza nodo:661 / Elemento padre: 660   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(661)).setAttribute("valign","top" );
      ((Element)v.get(661)).setAttribute("height","13" );
      ((Element)v.get(660)).appendChild((Element)v.get(661));

      /* Empieza nodo:662 / Elemento padre: 661   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(662)).setAttribute("nombre","lblsgeoOidSubeGeop" );
      ((Element)v.get(662)).setAttribute("id","datosTitle" );
      ((Element)v.get(662)).setAttribute("ancho","100" );
      ((Element)v.get(662)).setAttribute("alto","13" );
      ((Element)v.get(662)).setAttribute("cod","ZonValorEstruGeopo.sgeoOidSubeGeop.label" );
      ((Element)v.get(661)).appendChild((Element)v.get(662));
      /* Termina nodo:662   */
      /* Termina nodo:661   */
      /* Termina nodo:660   */

      /* Empieza nodo:663 / Elemento padre: 659   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(663)).setAttribute("nombre","sgeoOidSubeGeopWidgetTrId" );
      ((Element)v.get(659)).appendChild((Element)v.get(663));

      /* Empieza nodo:664 / Elemento padre: 663   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(664)).setAttribute("align","left" );
      ((Element)v.get(664)).setAttribute("nowrap","true" );
      ((Element)v.get(663)).appendChild((Element)v.get(664));

      /* Empieza nodo:665 / Elemento padre: 664   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(665)).setAttribute("nombre","sgeoOidSubeGeop" );
      ((Element)v.get(665)).setAttribute("id","datosCampos" );
      ((Element)v.get(665)).setAttribute("multiple","N" );
      ((Element)v.get(665)).setAttribute("req","N" );
      ((Element)v.get(665)).setAttribute("size","1" );
      ((Element)v.get(665)).setAttribute("disabled","" );
      ((Element)v.get(665)).setAttribute("validacion","" );
      ((Element)v.get(665)).setAttribute("onchange","" );
      ((Element)v.get(665)).setAttribute("onfocus","" );
      ((Element)v.get(665)).setAttribute("valorinicial","" );
      ((Element)v.get(665)).setAttribute("textoinicial","" );
      ((Element)v.get(665)).setAttribute("ontab","ejecutarAccionFoco('zonValorEstruGeopoFrm',0, true);" );
      ((Element)v.get(665)).setAttribute("onshtab","focaliza('zonValorEstruGeopoFrm.sgeoOidSubeGeop_egeoOidEstrGeop');" );
      ((Element)v.get(664)).appendChild((Element)v.get(665));

      /* Empieza nodo:666 / Elemento padre: 665   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(665)).appendChild((Element)v.get(666));
      /* Termina nodo:666   */
      /* Termina nodo:665   */
      /* Termina nodo:664   */
      /* Termina nodo:663   */
      /* Termina nodo:659   */
      /* Termina nodo:658   */

      /* Empieza nodo:667 / Elemento padre: 646   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(667)).setAttribute("nombre","sgeoOidSubeGeopGapTdId" );
      ((Element)v.get(667)).setAttribute("nowrap","true" );
      ((Element)v.get(667)).setAttribute("class","datosCampos" );
      ((Element)v.get(646)).appendChild((Element)v.get(667));

      /* Empieza nodo:668 / Elemento padre: 667   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(668)).setAttribute("src","b.gif" );
      ((Element)v.get(668)).setAttribute("width","25" );
      ((Element)v.get(668)).setAttribute("height","8" );
      ((Element)v.get(667)).appendChild((Element)v.get(668));
      /* Termina nodo:668   */
      /* Termina nodo:667   */

      /* Empieza nodo:669 / Elemento padre: 646   */
   }

   private void getXML3060(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(669)).setAttribute("width","100%" );
      ((Element)v.get(646)).appendChild((Element)v.get(669));

      /* Empieza nodo:670 / Elemento padre: 669   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(670)).setAttribute("src","b.gif" );
      ((Element)v.get(669)).appendChild((Element)v.get(670));
      /* Termina nodo:670   */
      /* Termina nodo:669   */
      /* Termina nodo:646   */
      /* Termina nodo:645   */
      /* Termina nodo:644   */

      /* Empieza nodo:671 / Elemento padre: 641   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(671)).setAttribute("width","100%" );
      ((Element)v.get(641)).appendChild((Element)v.get(671));
      /* Termina nodo:671   */
      /* Termina nodo:641   */

      /* Empieza nodo:672 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(672)).setAttribute("nombre","formGapTr22" );
      ((Element)v.get(52)).appendChild((Element)v.get(672));

      /* Empieza nodo:673 / Elemento padre: 672   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(673)).setAttribute("align","center" );
      ((Element)v.get(673)).setAttribute("width","8" );
      ((Element)v.get(672)).appendChild((Element)v.get(673));

      /* Empieza nodo:674 / Elemento padre: 673   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(674)).setAttribute("src","b.gif" );
      ((Element)v.get(674)).setAttribute("width","8" );
      ((Element)v.get(674)).setAttribute("height","8" );
      ((Element)v.get(673)).appendChild((Element)v.get(674));
      /* Termina nodo:674   */
      /* Termina nodo:673   */

      /* Empieza nodo:675 / Elemento padre: 672   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(672)).appendChild((Element)v.get(675));

      /* Empieza nodo:676 / Elemento padre: 675   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(676)).setAttribute("src","b.gif" );
      ((Element)v.get(676)).setAttribute("width","8" );
      ((Element)v.get(676)).setAttribute("height","8" );
      ((Element)v.get(675)).appendChild((Element)v.get(676));
      /* Termina nodo:676   */
      /* Termina nodo:675   */

      /* Empieza nodo:677 / Elemento padre: 672   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(677)).setAttribute("align","center" );
      ((Element)v.get(677)).setAttribute("width","8" );
      ((Element)v.get(672)).appendChild((Element)v.get(677));

      /* Empieza nodo:678 / Elemento padre: 677   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(678)).setAttribute("src","b.gif" );
      ((Element)v.get(678)).setAttribute("width","8" );
      ((Element)v.get(678)).setAttribute("height","8" );
      ((Element)v.get(677)).appendChild((Element)v.get(678));
      /* Termina nodo:678   */
      /* Termina nodo:677   */
      /* Termina nodo:672   */
      /* Termina nodo:52   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:679 / Elemento padre: 45   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(679)).setAttribute("align","center" );
      ((Element)v.get(679)).setAttribute("width","12" );
      ((Element)v.get(45)).appendChild((Element)v.get(679));

      /* Empieza nodo:680 / Elemento padre: 679   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(680)).setAttribute("src","b.gif" );
      ((Element)v.get(680)).setAttribute("width","12" );
      ((Element)v.get(680)).setAttribute("height","12" );
      ((Element)v.get(679)).appendChild((Element)v.get(680));
      /* Termina nodo:680   */
      /* Termina nodo:679   */
      /* Termina nodo:45   */

      /* Empieza nodo:681 / Elemento padre: 37   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(681)).setAttribute("nombre","zonValorEstruGeopoTrButtons" );
      ((Element)v.get(37)).appendChild((Element)v.get(681));

      /* Empieza nodo:682 / Elemento padre: 681   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(682)).setAttribute("align","center" );
      ((Element)v.get(682)).setAttribute("width","12" );
      ((Element)v.get(681)).appendChild((Element)v.get(682));

      /* Empieza nodo:683 / Elemento padre: 682   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(683)).setAttribute("src","b.gif" );
      ((Element)v.get(683)).setAttribute("width","12" );
      ((Element)v.get(683)).setAttribute("height","12" );
      ((Element)v.get(682)).appendChild((Element)v.get(683));
      /* Termina nodo:683   */
      /* Termina nodo:682   */

      /* Empieza nodo:684 / Elemento padre: 681   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(681)).appendChild((Element)v.get(684));

      /* Empieza nodo:685 / Elemento padre: 684   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(684)).appendChild((Element)v.get(685));

      /* Empieza nodo:686 / Elemento padre: 685   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(686)).setAttribute("width","100%" );
      ((Element)v.get(686)).setAttribute("border","0" );
      ((Element)v.get(686)).setAttribute("align","center" );
      ((Element)v.get(686)).setAttribute("cellspacing","0" );
      ((Element)v.get(686)).setAttribute("cellpadding","0" );
      ((Element)v.get(685)).appendChild((Element)v.get(686));

      /* Empieza nodo:687 / Elemento padre: 686   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(686)).appendChild((Element)v.get(687));

      /* Empieza nodo:688 / Elemento padre: 687   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(688)).setAttribute("class","tablaTitle" );
      ((Element)v.get(688)).setAttribute("nombre","zonValorEstruGeopoTdQueryButton" );
      ((Element)v.get(687)).appendChild((Element)v.get(688));

      /* Empieza nodo:689 / Elemento padre: 688   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(689)).setAttribute("nombre","zonValorEstruGeopoQueryButton" );
      ((Element)v.get(689)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(689)).setAttribute("estado","false" );
      ((Element)v.get(689)).setAttribute("accion","zonValorEstruGeopoFirstPage();" );
      ((Element)v.get(689)).setAttribute("tipo","html" );
      ((Element)v.get(689)).setAttribute("ID","botonContenido" );
      ((Element)v.get(688)).appendChild((Element)v.get(689));
      /* Termina nodo:689   */
      /* Termina nodo:688   */

      /* Empieza nodo:690 / Elemento padre: 687   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(690)).setAttribute("class","tablaTitle" );
      ((Element)v.get(690)).setAttribute("nombre","zonValorEstruGeopoTdLovNullSelectionButton" );
      ((Element)v.get(690)).setAttribute("align","left" );
      ((Element)v.get(690)).setAttribute("width","100%" );
      ((Element)v.get(687)).appendChild((Element)v.get(690));

      /* Empieza nodo:691 / Elemento padre: 690   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML3150(Document doc) {
      ((Element)v.get(691)).setAttribute("src","b.gif" );
      ((Element)v.get(691)).setAttribute("height","8" );
      ((Element)v.get(691)).setAttribute("width","8" );
      ((Element)v.get(690)).appendChild((Element)v.get(691));
      /* Termina nodo:691   */

      /* Empieza nodo:692 / Elemento padre: 690   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(692)).setAttribute("nombre","zonValorEstruGeopoLovNullButton" );
      ((Element)v.get(692)).setAttribute("ID","botonContenido" );
      ((Element)v.get(692)).setAttribute("tipo","html" );
      ((Element)v.get(692)).setAttribute("accion","zonValorEstruGeopoLovNullSelectionAction();" );
      ((Element)v.get(692)).setAttribute("estado","true" );
      ((Element)v.get(692)).setAttribute("cod","MMGGlobal.lovNullButton.label" );
      ((Element)v.get(690)).appendChild((Element)v.get(692));
      /* Termina nodo:692   */
      /* Termina nodo:690   */
      /* Termina nodo:687   */
      /* Termina nodo:686   */
      /* Termina nodo:685   */
      /* Termina nodo:684   */

      /* Empieza nodo:693 / Elemento padre: 681   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(693)).setAttribute("align","center" );
      ((Element)v.get(693)).setAttribute("width","12" );
      ((Element)v.get(681)).appendChild((Element)v.get(693));

      /* Empieza nodo:694 / Elemento padre: 693   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(694)).setAttribute("src","b.gif" );
      ((Element)v.get(694)).setAttribute("width","12" );
      ((Element)v.get(694)).setAttribute("height","12" );
      ((Element)v.get(693)).appendChild((Element)v.get(694));
      /* Termina nodo:694   */
      /* Termina nodo:693   */
      /* Termina nodo:681   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:695 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(695)).setAttribute("nombre","zonValorEstruGeopoListLayer" );
      ((Element)v.get(695)).setAttribute("alto","310" );
      ((Element)v.get(695)).setAttribute("ancho","99%" );
      ((Element)v.get(695)).setAttribute("colorf","" );
      ((Element)v.get(695)).setAttribute("borde","0" );
      ((Element)v.get(695)).setAttribute("imagenf","" );
      ((Element)v.get(695)).setAttribute("repeat","" );
      ((Element)v.get(695)).setAttribute("padding","" );
      ((Element)v.get(695)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(695)).setAttribute("contravsb","" );
      ((Element)v.get(695)).setAttribute("x","3" );
      ((Element)v.get(695)).setAttribute("y","" );
      ((Element)v.get(695)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(695));

      /* Empieza nodo:696 / Elemento padre: 695   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(696)).setAttribute("nombre","zonValorEstruGeopoList" );
      ((Element)v.get(696)).setAttribute("ancho","680" );
      ((Element)v.get(696)).setAttribute("alto","275" );
      ((Element)v.get(696)).setAttribute("x","12" );
      ((Element)v.get(696)).setAttribute("y","0" );
      ((Element)v.get(696)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(696)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(695)).appendChild((Element)v.get(696));

      /* Empieza nodo:697 / Elemento padre: 696   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(697)).setAttribute("precarga","S" );
      ((Element)v.get(697)).setAttribute("conROver","S" );
      ((Element)v.get(696)).appendChild((Element)v.get(697));

      /* Empieza nodo:698 / Elemento padre: 697   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(698)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(698)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(698)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(698)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(697)).appendChild((Element)v.get(698));
      /* Termina nodo:698   */

      /* Empieza nodo:699 / Elemento padre: 697   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(699)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(699)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(699)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(699)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(697)).appendChild((Element)v.get(699));
      /* Termina nodo:699   */
      /* Termina nodo:697   */

      /* Empieza nodo:700 / Elemento padre: 696   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(696)).appendChild((Element)v.get(700));

      /* Empieza nodo:701 / Elemento padre: 700   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(701)).setAttribute("borde","1" );
      ((Element)v.get(701)).setAttribute("horizDatos","1" );
      ((Element)v.get(701)).setAttribute("horizCabecera","1" );
      ((Element)v.get(701)).setAttribute("vertical","1" );
      ((Element)v.get(701)).setAttribute("horizTitulo","1" );
      ((Element)v.get(701)).setAttribute("horizBase","1" );
      ((Element)v.get(700)).appendChild((Element)v.get(701));
      /* Termina nodo:701   */

      /* Empieza nodo:702 / Elemento padre: 700   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(702)).setAttribute("borde","#999999" );
      ((Element)v.get(702)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(702)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(702)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(702)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(702)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(702)).setAttribute("horizBase","#999999" );
      ((Element)v.get(700)).appendChild((Element)v.get(702));
      /* Termina nodo:702   */
      /* Termina nodo:700   */

      /* Empieza nodo:703 / Elemento padre: 696   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(703)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(703)).setAttribute("alto","22" );
      ((Element)v.get(703)).setAttribute("imgFondo","" );
      ((Element)v.get(703)).setAttribute("cod","00135" );
      ((Element)v.get(703)).setAttribute("ID","datosTitle" );
      ((Element)v.get(696)).appendChild((Element)v.get(703));
      /* Termina nodo:703   */

      /* Empieza nodo:704 / Elemento padre: 696   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(704)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(704)).setAttribute("alto","22" );
   }

   private void getXML3240(Document doc) {
      ((Element)v.get(704)).setAttribute("imgFondo","" );
      ((Element)v.get(696)).appendChild((Element)v.get(704));
      /* Termina nodo:704   */

      /* Empieza nodo:705 / Elemento padre: 696   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(705)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(705)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(705)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(705)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(705)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(696)).appendChild((Element)v.get(705));

      /* Empieza nodo:706 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(706)).setAttribute("ancho","100" );
      ((Element)v.get(706)).setAttribute("minimizable","S" );
      ((Element)v.get(706)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(706));
      /* Termina nodo:706   */

      /* Empieza nodo:707 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(707)).setAttribute("ancho","100" );
      ((Element)v.get(707)).setAttribute("minimizable","S" );
      ((Element)v.get(707)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(707));
      /* Termina nodo:707   */

      /* Empieza nodo:708 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(708)).setAttribute("ancho","100" );
      ((Element)v.get(708)).setAttribute("minimizable","S" );
      ((Element)v.get(708)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(708));
      /* Termina nodo:708   */

      /* Empieza nodo:709 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(709)).setAttribute("ancho","100" );
      ((Element)v.get(709)).setAttribute("minimizable","S" );
      ((Element)v.get(709)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(709));
      /* Termina nodo:709   */

      /* Empieza nodo:710 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(710)).setAttribute("ancho","100" );
      ((Element)v.get(710)).setAttribute("minimizable","S" );
      ((Element)v.get(710)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(710));
      /* Termina nodo:710   */

      /* Empieza nodo:711 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(711)).setAttribute("ancho","100" );
      ((Element)v.get(711)).setAttribute("minimizable","S" );
      ((Element)v.get(711)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(711));
      /* Termina nodo:711   */

      /* Empieza nodo:712 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(712)).setAttribute("ancho","100" );
      ((Element)v.get(712)).setAttribute("minimizable","S" );
      ((Element)v.get(712)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(712));
      /* Termina nodo:712   */

      /* Empieza nodo:713 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(713)).setAttribute("ancho","100" );
      ((Element)v.get(713)).setAttribute("minimizable","S" );
      ((Element)v.get(713)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(713));
      /* Termina nodo:713   */

      /* Empieza nodo:714 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(714)).setAttribute("ancho","100" );
      ((Element)v.get(714)).setAttribute("minimizable","S" );
      ((Element)v.get(714)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(714));
      /* Termina nodo:714   */

      /* Empieza nodo:715 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(715)).setAttribute("ancho","100" );
      ((Element)v.get(715)).setAttribute("minimizable","S" );
      ((Element)v.get(715)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(715));
      /* Termina nodo:715   */

      /* Empieza nodo:716 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(716)).setAttribute("ancho","100" );
      ((Element)v.get(716)).setAttribute("minimizable","S" );
      ((Element)v.get(716)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(716));
      /* Termina nodo:716   */

      /* Empieza nodo:717 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(717)).setAttribute("ancho","100" );
      ((Element)v.get(717)).setAttribute("minimizable","S" );
      ((Element)v.get(717)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(717));
      /* Termina nodo:717   */

      /* Empieza nodo:718 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(718)).setAttribute("ancho","100" );
      ((Element)v.get(718)).setAttribute("minimizable","S" );
      ((Element)v.get(718)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(718));
      /* Termina nodo:718   */

      /* Empieza nodo:719 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(719)).setAttribute("ancho","100" );
      ((Element)v.get(719)).setAttribute("minimizable","S" );
      ((Element)v.get(719)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(719));
      /* Termina nodo:719   */

      /* Empieza nodo:720 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(720)).setAttribute("ancho","100" );
      ((Element)v.get(720)).setAttribute("minimizable","S" );
      ((Element)v.get(720)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(720));
      /* Termina nodo:720   */

      /* Empieza nodo:721 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(721)).setAttribute("ancho","100" );
      ((Element)v.get(721)).setAttribute("minimizable","S" );
      ((Element)v.get(721)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(721));
      /* Termina nodo:721   */

      /* Empieza nodo:722 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
   }

   private void getXML3330(Document doc) {
      ((Element)v.get(722)).setAttribute("ancho","100" );
      ((Element)v.get(722)).setAttribute("minimizable","S" );
      ((Element)v.get(722)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(722));
      /* Termina nodo:722   */

      /* Empieza nodo:723 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(723)).setAttribute("ancho","100" );
      ((Element)v.get(723)).setAttribute("minimizable","S" );
      ((Element)v.get(723)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(723));
      /* Termina nodo:723   */

      /* Empieza nodo:724 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(724)).setAttribute("ancho","100" );
      ((Element)v.get(724)).setAttribute("minimizable","S" );
      ((Element)v.get(724)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(724));
      /* Termina nodo:724   */

      /* Empieza nodo:725 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(725)).setAttribute("ancho","100" );
      ((Element)v.get(725)).setAttribute("minimizable","S" );
      ((Element)v.get(725)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(725));
      /* Termina nodo:725   */

      /* Empieza nodo:726 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(726)).setAttribute("ancho","100" );
      ((Element)v.get(726)).setAttribute("minimizable","S" );
      ((Element)v.get(726)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(726));
      /* Termina nodo:726   */

      /* Empieza nodo:727 / Elemento padre: 705   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(727)).setAttribute("ancho","100" );
      ((Element)v.get(727)).setAttribute("minimizable","S" );
      ((Element)v.get(727)).setAttribute("minimizada","N" );
      ((Element)v.get(705)).appendChild((Element)v.get(727));
      /* Termina nodo:727   */
      /* Termina nodo:705   */

      /* Empieza nodo:728 / Elemento padre: 696   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(728)).setAttribute("height","20" );
      ((Element)v.get(728)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(728)).setAttribute("imgFondo","" );
      ((Element)v.get(728)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(696)).appendChild((Element)v.get(728));

      /* Empieza nodo:729 / Elemento padre: 728   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(729)).setAttribute("colFondo","" );
      ((Element)v.get(729)).setAttribute("ID","EstCab" );
      ((Element)v.get(729)).setAttribute("cod","ZonValorEstruGeopo.codUnidGeog.label" );
      ((Element)v.get(728)).appendChild((Element)v.get(729));
      /* Termina nodo:729   */

      /* Empieza nodo:730 / Elemento padre: 728   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(730)).setAttribute("colFondo","" );
      ((Element)v.get(730)).setAttribute("ID","EstCab" );
      ((Element)v.get(730)).setAttribute("cod","ZonValorEstruGeopo.desGeog.label" );
      ((Element)v.get(728)).appendChild((Element)v.get(730));
      /* Termina nodo:730   */

      /* Empieza nodo:731 / Elemento padre: 728   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(731)).setAttribute("colFondo","" );
      ((Element)v.get(731)).setAttribute("ID","EstCab" );
      ((Element)v.get(731)).setAttribute("cod","ZonValorEstruGeopo.codNse1.label" );
      ((Element)v.get(728)).appendChild((Element)v.get(731));
      /* Termina nodo:731   */

      /* Empieza nodo:732 / Elemento padre: 728   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(732)).setAttribute("colFondo","" );
      ((Element)v.get(732)).setAttribute("ID","EstCab" );
      ((Element)v.get(732)).setAttribute("cod","ZonValorEstruGeopo.codNse2.label" );
      ((Element)v.get(728)).appendChild((Element)v.get(732));
      /* Termina nodo:732   */

      /* Empieza nodo:733 / Elemento padre: 728   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(733)).setAttribute("colFondo","" );
      ((Element)v.get(733)).setAttribute("ID","EstCab" );
      ((Element)v.get(733)).setAttribute("cod","ZonValorEstruGeopo.codNse3.label" );
      ((Element)v.get(728)).appendChild((Element)v.get(733));
      /* Termina nodo:733   */

      /* Empieza nodo:734 / Elemento padre: 728   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(734)).setAttribute("colFondo","" );
      ((Element)v.get(734)).setAttribute("ID","EstCab" );
      ((Element)v.get(734)).setAttribute("cod","ZonValorEstruGeopo.codPost.label" );
      ((Element)v.get(728)).appendChild((Element)v.get(734));
      /* Termina nodo:734   */

      /* Empieza nodo:735 / Elemento padre: 728   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(735)).setAttribute("colFondo","" );
      ((Element)v.get(735)).setAttribute("ID","EstCab" );
      ((Element)v.get(735)).setAttribute("cod","ZonValorEstruGeopo.indActi.label" );
      ((Element)v.get(728)).appendChild((Element)v.get(735));
      /* Termina nodo:735   */

      /* Empieza nodo:736 / Elemento padre: 728   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(736)).setAttribute("colFondo","" );
      ((Element)v.get(736)).setAttribute("ID","EstCab" );
      ((Element)v.get(736)).setAttribute("cod","ZonValorEstruGeopo.indAsig.label" );
      ((Element)v.get(728)).appendChild((Element)v.get(736));
      /* Termina nodo:736   */

      /* Empieza nodo:737 / Elemento padre: 728   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(737)).setAttribute("colFondo","" );
      ((Element)v.get(737)).setAttribute("ID","EstCab" );
      ((Element)v.get(737)).setAttribute("cod","ZonValorEstruGeopo.indBorr.label" );
      ((Element)v.get(728)).appendChild((Element)v.get(737));
      /* Termina nodo:737   */

      /* Empieza nodo:738 / Elemento padre: 728   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(738)).setAttribute("colFondo","" );
      ((Element)v.get(738)).setAttribute("ID","EstCab" );
      ((Element)v.get(738)).setAttribute("cod","ZonValorEstruGeopo.orde1.label" );
      ((Element)v.get(728)).appendChild((Element)v.get(738));
      /* Termina nodo:738   */

      /* Empieza nodo:739 / Elemento padre: 728   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(739)).setAttribute("colFondo","" );
      ((Element)v.get(739)).setAttribute("ID","EstCab" );
      ((Element)v.get(739)).setAttribute("cod","ZonValorEstruGeopo.orde2.label" );
      ((Element)v.get(728)).appendChild((Element)v.get(739));
      /* Termina nodo:739   */

      /* Empieza nodo:740 / Elemento padre: 728   */
   }

   private void getXML3420(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(740)).setAttribute("colFondo","" );
      ((Element)v.get(740)).setAttribute("ID","EstCab" );
      ((Element)v.get(740)).setAttribute("cod","ZonValorEstruGeopo.orde3.label" );
      ((Element)v.get(728)).appendChild((Element)v.get(740));
      /* Termina nodo:740   */

      /* Empieza nodo:741 / Elemento padre: 728   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(741)).setAttribute("colFondo","" );
      ((Element)v.get(741)).setAttribute("ID","EstCab" );
      ((Element)v.get(741)).setAttribute("cod","ZonValorEstruGeopo.orde4.label" );
      ((Element)v.get(728)).appendChild((Element)v.get(741));
      /* Termina nodo:741   */

      /* Empieza nodo:742 / Elemento padre: 728   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(742)).setAttribute("colFondo","" );
      ((Element)v.get(742)).setAttribute("ID","EstCab" );
      ((Element)v.get(742)).setAttribute("cod","ZonValorEstruGeopo.orde5.label" );
      ((Element)v.get(728)).appendChild((Element)v.get(742));
      /* Termina nodo:742   */

      /* Empieza nodo:743 / Elemento padre: 728   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(743)).setAttribute("colFondo","" );
      ((Element)v.get(743)).setAttribute("ID","EstCab" );
      ((Element)v.get(743)).setAttribute("cod","ZonValorEstruGeopo.orde6.label" );
      ((Element)v.get(728)).appendChild((Element)v.get(743));
      /* Termina nodo:743   */

      /* Empieza nodo:744 / Elemento padre: 728   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(744)).setAttribute("colFondo","" );
      ((Element)v.get(744)).setAttribute("ID","EstCab" );
      ((Element)v.get(744)).setAttribute("cod","ZonValorEstruGeopo.orde7.label" );
      ((Element)v.get(728)).appendChild((Element)v.get(744));
      /* Termina nodo:744   */

      /* Empieza nodo:745 / Elemento padre: 728   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(745)).setAttribute("colFondo","" );
      ((Element)v.get(745)).setAttribute("ID","EstCab" );
      ((Element)v.get(745)).setAttribute("cod","ZonValorEstruGeopo.orde8.label" );
      ((Element)v.get(728)).appendChild((Element)v.get(745));
      /* Termina nodo:745   */

      /* Empieza nodo:746 / Elemento padre: 728   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(746)).setAttribute("colFondo","" );
      ((Element)v.get(746)).setAttribute("ID","EstCab" );
      ((Element)v.get(746)).setAttribute("cod","ZonValorEstruGeopo.orde9.label" );
      ((Element)v.get(728)).appendChild((Element)v.get(746));
      /* Termina nodo:746   */

      /* Empieza nodo:747 / Elemento padre: 728   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(747)).setAttribute("colFondo","" );
      ((Element)v.get(747)).setAttribute("ID","EstCab" );
      ((Element)v.get(747)).setAttribute("cod","ZonValorEstruGeopo.egeoOidEstrGeop.label" );
      ((Element)v.get(728)).appendChild((Element)v.get(747));
      /* Termina nodo:747   */

      /* Empieza nodo:748 / Elemento padre: 728   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(748)).setAttribute("colFondo","" );
      ((Element)v.get(748)).setAttribute("ID","EstCab" );
      ((Element)v.get(748)).setAttribute("cod","ZonValorEstruGeopo.paisOidPais.label" );
      ((Element)v.get(728)).appendChild((Element)v.get(748));
      /* Termina nodo:748   */

      /* Empieza nodo:749 / Elemento padre: 728   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(749)).setAttribute("colFondo","" );
      ((Element)v.get(749)).setAttribute("ID","EstCab" );
      ((Element)v.get(749)).setAttribute("cod","ZonValorEstruGeopo.fecActu.label" );
      ((Element)v.get(728)).appendChild((Element)v.get(749));
      /* Termina nodo:749   */

      /* Empieza nodo:750 / Elemento padre: 728   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(750)).setAttribute("colFondo","" );
      ((Element)v.get(750)).setAttribute("ID","EstCab" );
      ((Element)v.get(750)).setAttribute("cod","ZonValorEstruGeopo.sgeoOidSubeGeop.label" );
      ((Element)v.get(728)).appendChild((Element)v.get(750));
      /* Termina nodo:750   */
      /* Termina nodo:728   */

      /* Empieza nodo:751 / Elemento padre: 696   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(751)).setAttribute("alto","22" );
      ((Element)v.get(751)).setAttribute("accion","" );
      ((Element)v.get(751)).setAttribute("tipoEnvio","seleccion" );
      ((Element)v.get(751)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(751)).setAttribute("maxSel","1" );
      ((Element)v.get(751)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(751)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(751)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(751)).setAttribute("onLoad","" );
      ((Element)v.get(751)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(696)).appendChild((Element)v.get(751));

      /* Empieza nodo:752 / Elemento padre: 751   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(752)).setAttribute("tipo","texto" );
      ((Element)v.get(752)).setAttribute("ID","EstDat" );
      ((Element)v.get(751)).appendChild((Element)v.get(752));
      /* Termina nodo:752   */

      /* Empieza nodo:753 / Elemento padre: 751   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(753)).setAttribute("tipo","texto" );
      ((Element)v.get(753)).setAttribute("ID","EstDat2" );
      ((Element)v.get(751)).appendChild((Element)v.get(753));
      /* Termina nodo:753   */

      /* Empieza nodo:754 / Elemento padre: 751   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(754)).setAttribute("tipo","texto" );
      ((Element)v.get(754)).setAttribute("ID","EstDat" );
      ((Element)v.get(751)).appendChild((Element)v.get(754));
      /* Termina nodo:754   */

      /* Empieza nodo:755 / Elemento padre: 751   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(755)).setAttribute("tipo","texto" );
      ((Element)v.get(755)).setAttribute("ID","EstDat2" );
      ((Element)v.get(751)).appendChild((Element)v.get(755));
      /* Termina nodo:755   */

      /* Empieza nodo:756 / Elemento padre: 751   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(756)).setAttribute("tipo","texto" );
      ((Element)v.get(756)).setAttribute("ID","EstDat" );
      ((Element)v.get(751)).appendChild((Element)v.get(756));
      /* Termina nodo:756   */

      /* Empieza nodo:757 / Elemento padre: 751   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(757)).setAttribute("tipo","texto" );
      ((Element)v.get(757)).setAttribute("ID","EstDat2" );
   }

   private void getXML3510(Document doc) {
      ((Element)v.get(751)).appendChild((Element)v.get(757));
      /* Termina nodo:757   */

      /* Empieza nodo:758 / Elemento padre: 751   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(758)).setAttribute("tipo","texto" );
      ((Element)v.get(758)).setAttribute("ID","EstDat" );
      ((Element)v.get(751)).appendChild((Element)v.get(758));
      /* Termina nodo:758   */

      /* Empieza nodo:759 / Elemento padre: 751   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(759)).setAttribute("tipo","texto" );
      ((Element)v.get(759)).setAttribute("ID","EstDat2" );
      ((Element)v.get(751)).appendChild((Element)v.get(759));
      /* Termina nodo:759   */

      /* Empieza nodo:760 / Elemento padre: 751   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(760)).setAttribute("tipo","texto" );
      ((Element)v.get(760)).setAttribute("ID","EstDat" );
      ((Element)v.get(751)).appendChild((Element)v.get(760));
      /* Termina nodo:760   */

      /* Empieza nodo:761 / Elemento padre: 751   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(761)).setAttribute("tipo","texto" );
      ((Element)v.get(761)).setAttribute("ID","EstDat2" );
      ((Element)v.get(751)).appendChild((Element)v.get(761));
      /* Termina nodo:761   */

      /* Empieza nodo:762 / Elemento padre: 751   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(762)).setAttribute("tipo","texto" );
      ((Element)v.get(762)).setAttribute("ID","EstDat" );
      ((Element)v.get(751)).appendChild((Element)v.get(762));
      /* Termina nodo:762   */

      /* Empieza nodo:763 / Elemento padre: 751   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(763)).setAttribute("tipo","texto" );
      ((Element)v.get(763)).setAttribute("ID","EstDat2" );
      ((Element)v.get(751)).appendChild((Element)v.get(763));
      /* Termina nodo:763   */

      /* Empieza nodo:764 / Elemento padre: 751   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(764)).setAttribute("tipo","texto" );
      ((Element)v.get(764)).setAttribute("ID","EstDat" );
      ((Element)v.get(751)).appendChild((Element)v.get(764));
      /* Termina nodo:764   */

      /* Empieza nodo:765 / Elemento padre: 751   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(765)).setAttribute("tipo","texto" );
      ((Element)v.get(765)).setAttribute("ID","EstDat2" );
      ((Element)v.get(751)).appendChild((Element)v.get(765));
      /* Termina nodo:765   */

      /* Empieza nodo:766 / Elemento padre: 751   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(766)).setAttribute("tipo","texto" );
      ((Element)v.get(766)).setAttribute("ID","EstDat" );
      ((Element)v.get(751)).appendChild((Element)v.get(766));
      /* Termina nodo:766   */

      /* Empieza nodo:767 / Elemento padre: 751   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(767)).setAttribute("tipo","texto" );
      ((Element)v.get(767)).setAttribute("ID","EstDat2" );
      ((Element)v.get(751)).appendChild((Element)v.get(767));
      /* Termina nodo:767   */

      /* Empieza nodo:768 / Elemento padre: 751   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(768)).setAttribute("tipo","texto" );
      ((Element)v.get(768)).setAttribute("ID","EstDat" );
      ((Element)v.get(751)).appendChild((Element)v.get(768));
      /* Termina nodo:768   */

      /* Empieza nodo:769 / Elemento padre: 751   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(769)).setAttribute("tipo","texto" );
      ((Element)v.get(769)).setAttribute("ID","EstDat2" );
      ((Element)v.get(751)).appendChild((Element)v.get(769));
      /* Termina nodo:769   */

      /* Empieza nodo:770 / Elemento padre: 751   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(770)).setAttribute("tipo","texto" );
      ((Element)v.get(770)).setAttribute("ID","EstDat" );
      ((Element)v.get(751)).appendChild((Element)v.get(770));
      /* Termina nodo:770   */

      /* Empieza nodo:771 / Elemento padre: 751   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(771)).setAttribute("tipo","texto" );
      ((Element)v.get(771)).setAttribute("ID","EstDat2" );
      ((Element)v.get(751)).appendChild((Element)v.get(771));
      /* Termina nodo:771   */

      /* Empieza nodo:772 / Elemento padre: 751   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(772)).setAttribute("tipo","texto" );
      ((Element)v.get(772)).setAttribute("ID","EstDat" );
      ((Element)v.get(751)).appendChild((Element)v.get(772));
      /* Termina nodo:772   */

      /* Empieza nodo:773 / Elemento padre: 751   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(773)).setAttribute("tipo","texto" );
      ((Element)v.get(773)).setAttribute("ID","EstDat2" );
      ((Element)v.get(751)).appendChild((Element)v.get(773));
      /* Termina nodo:773   */
      /* Termina nodo:751   */

      /* Empieza nodo:774 / Elemento padre: 696   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(696)).appendChild((Element)v.get(774));
      /* Termina nodo:774   */
      /* Termina nodo:696   */
      /* Termina nodo:695   */

      /* Empieza nodo:775 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(775)).setAttribute("nombre","zonValorEstruGeopoListButtonsLayer" );
      ((Element)v.get(775)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(775)).setAttribute("alto","30" );
      ((Element)v.get(775)).setAttribute("ancho","98%" );
      ((Element)v.get(775)).setAttribute("borde","n" );
      ((Element)v.get(775)).setAttribute("imagenf","" );
      ((Element)v.get(775)).setAttribute("repeat","" );
      ((Element)v.get(775)).setAttribute("padding","0" );
      ((Element)v.get(775)).setAttribute("contravsb","" );
      ((Element)v.get(775)).setAttribute("x","16" );
      ((Element)v.get(775)).setAttribute("y","" );
      ((Element)v.get(775)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(775));

      /* Empieza nodo:776 / Elemento padre: 775   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(776)).setAttribute("nombre","toolbarSeparatorLayer" );
      ((Element)v.get(776)).setAttribute("visibilidad","inherit" );
      ((Element)v.get(776)).setAttribute("alto","23" );
      ((Element)v.get(776)).setAttribute("ancho","1" );
      ((Element)v.get(776)).setAttribute("borde","1" );
      ((Element)v.get(776)).setAttribute("imagenf","" );
      ((Element)v.get(776)).setAttribute("repeat","" );
      ((Element)v.get(776)).setAttribute("padding","0" );
   }

   private void getXML3600(Document doc) {
      ((Element)v.get(776)).setAttribute("contravsb","" );
      ((Element)v.get(776)).setAttribute("x","56" );
      ((Element)v.get(776)).setAttribute("y","0" );
      ((Element)v.get(776)).setAttribute("zindex","" );
      ((Element)v.get(776)).setAttribute("colborde","#999999" );
      ((Element)v.get(775)).appendChild((Element)v.get(776));
      /* Termina nodo:776   */

      /* Empieza nodo:777 / Elemento padre: 775   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(777)).setAttribute("width","100%" );
      ((Element)v.get(777)).setAttribute("border","0" );
      ((Element)v.get(777)).setAttribute("cellspacing","1" );
      ((Element)v.get(777)).setAttribute("cellpadding","0" );
      ((Element)v.get(775)).appendChild((Element)v.get(777));

      /* Empieza nodo:778 / Elemento padre: 777   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(777)).appendChild((Element)v.get(778));

      /* Empieza nodo:779 / Elemento padre: 778   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(779)).setAttribute("src","b.gif" );
      ((Element)v.get(779)).setAttribute("height","22" );
      ((Element)v.get(779)).setAttribute("width","5" );
      ((Element)v.get(778)).appendChild((Element)v.get(779));
      /* Termina nodo:779   */
      /* Termina nodo:778   */

      /* Empieza nodo:780 / Elemento padre: 777   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(777)).appendChild((Element)v.get(780));

      /* Empieza nodo:781 / Elemento padre: 780   */
      v.add(doc.createElement("BOTONERA"));
      ((Element)v.get(781)).setAttribute("nombre","zonValorEstruGeopoPaginationButtonBar" );
      ((Element)v.get(781)).setAttribute("tipo","H" );
      ((Element)v.get(781)).setAttribute("x","0" );
      ((Element)v.get(781)).setAttribute("y","0" );
      ((Element)v.get(780)).appendChild((Element)v.get(781));

      /* Empieza nodo:782 / Elemento padre: 781   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(782)).setAttribute("nombre","zonValorEstruGeopoFirstPageButton" );
      ((Element)v.get(782)).setAttribute("funcion","zonValorEstruGeopoFirstPage();" );
      ((Element)v.get(782)).setAttribute("off","primera_over0.gif" );
      ((Element)v.get(782)).setAttribute("on","primera_over0.gif" );
      ((Element)v.get(782)).setAttribute("disable","primera_on0.gif" );
      ((Element)v.get(782)).setAttribute("estado","inactivo" );
      ((Element)v.get(781)).appendChild((Element)v.get(782));
      /* Termina nodo:782   */

      /* Empieza nodo:783 / Elemento padre: 781   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(783)).setAttribute("nombre","zonValorEstruGeopoFirstPageButtonGapTd" );
      ((Element)v.get(781)).appendChild((Element)v.get(783));

      /* Empieza nodo:784 / Elemento padre: 783   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(784)).setAttribute("src","b.gif" );
      ((Element)v.get(784)).setAttribute("height","8" );
      ((Element)v.get(784)).setAttribute("width","5" );
      ((Element)v.get(783)).appendChild((Element)v.get(784));
      /* Termina nodo:784   */
      /* Termina nodo:783   */

      /* Empieza nodo:785 / Elemento padre: 781   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(785)).setAttribute("nombre","zonValorEstruGeopoPreviousPageButton" );
      ((Element)v.get(785)).setAttribute("funcion","zonValorEstruGeopoPreviousPage();" );
      ((Element)v.get(785)).setAttribute("off","retroceder_over0.gif" );
      ((Element)v.get(785)).setAttribute("on","retroceder_over0.gif" );
      ((Element)v.get(785)).setAttribute("disable","retroceder_on0.gif" );
      ((Element)v.get(785)).setAttribute("estado","inactivo" );
      ((Element)v.get(781)).appendChild((Element)v.get(785));
      /* Termina nodo:785   */

      /* Empieza nodo:786 / Elemento padre: 781   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(786)).setAttribute("nombre","zonValorEstruGeopoPreviousPageButtonGapTd" );
      ((Element)v.get(781)).appendChild((Element)v.get(786));

      /* Empieza nodo:787 / Elemento padre: 786   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(787)).setAttribute("src","b.gif" );
      ((Element)v.get(787)).setAttribute("height","8" );
      ((Element)v.get(787)).setAttribute("width","8" );
      ((Element)v.get(786)).appendChild((Element)v.get(787));
      /* Termina nodo:787   */
      /* Termina nodo:786   */

      /* Empieza nodo:788 / Elemento padre: 781   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(788)).setAttribute("nombre","zonValorEstruGeopoNextPageButton" );
      ((Element)v.get(788)).setAttribute("funcion","zonValorEstruGeopoNextPage();" );
      ((Element)v.get(788)).setAttribute("off","avanzar_over0.gif" );
      ((Element)v.get(788)).setAttribute("on","avanzar_over0.gif" );
      ((Element)v.get(788)).setAttribute("disable","avanzar_on0.gif" );
      ((Element)v.get(788)).setAttribute("estado","inactivo" );
      ((Element)v.get(781)).appendChild((Element)v.get(788));
      /* Termina nodo:788   */
      /* Termina nodo:781   */
      /* Termina nodo:780   */

      /* Empieza nodo:789 / Elemento padre: 777   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(777)).appendChild((Element)v.get(789));

      /* Empieza nodo:790 / Elemento padre: 789   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(790)).setAttribute("src","b.gif" );
      ((Element)v.get(790)).setAttribute("height","22" );
      ((Element)v.get(790)).setAttribute("width","19" );
      ((Element)v.get(789)).appendChild((Element)v.get(790));
      /* Termina nodo:790   */
      /* Termina nodo:789   */

      /* Empieza nodo:791 / Elemento padre: 777   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(791)).setAttribute("class","tablaTitle" );
      ((Element)v.get(791)).setAttribute("nombre","zonValorEstruGeopoUpdateButtonTd" );
      ((Element)v.get(777)).appendChild((Element)v.get(791));

      /* Empieza nodo:792 / Elemento padre: 791   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(792)).setAttribute("nombre","zonValorEstruGeopoUpdateButton" );
      ((Element)v.get(792)).setAttribute("ID","botonContenido" );
      ((Element)v.get(792)).setAttribute("tipo","html" );
      ((Element)v.get(792)).setAttribute("accion","zonValorEstruGeopoUpdateSelection();" );
      ((Element)v.get(792)).setAttribute("estado","false" );
      ((Element)v.get(792)).setAttribute("cod","MMGGlobal.updateButton.label" );
      ((Element)v.get(791)).appendChild((Element)v.get(792));
      /* Termina nodo:792   */
      /* Termina nodo:791   */

      /* Empieza nodo:793 / Elemento padre: 777   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(793)).setAttribute("nombre","zonValorEstruGeopoUpdateButtonGapTd" );
      ((Element)v.get(777)).appendChild((Element)v.get(793));

      /* Empieza nodo:794 / Elemento padre: 793   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML3690(Document doc) {
      ((Element)v.get(794)).setAttribute("src","b.gif" );
      ((Element)v.get(794)).setAttribute("height","8" );
      ((Element)v.get(794)).setAttribute("width","10" );
      ((Element)v.get(793)).appendChild((Element)v.get(794));
      /* Termina nodo:794   */
      /* Termina nodo:793   */

      /* Empieza nodo:795 / Elemento padre: 777   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(795)).setAttribute("class","tablaTitle" );
      ((Element)v.get(795)).setAttribute("nombre","zonValorEstruGeopoViewForRemoveButtonTd" );
      ((Element)v.get(777)).appendChild((Element)v.get(795));

      /* Empieza nodo:796 / Elemento padre: 795   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(796)).setAttribute("nombre","zonValorEstruGeopoViewForRemoveButton" );
      ((Element)v.get(796)).setAttribute("ID","botonContenido" );
      ((Element)v.get(796)).setAttribute("tipo","html" );
      ((Element)v.get(796)).setAttribute("accion","zonValorEstruGeopoViewSelection();" );
      ((Element)v.get(796)).setAttribute("estado","false" );
      ((Element)v.get(796)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(795)).appendChild((Element)v.get(796));
      /* Termina nodo:796   */
      /* Termina nodo:795   */

      /* Empieza nodo:797 / Elemento padre: 777   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(797)).setAttribute("nombre","zonValorEstruGeopoViewForRemoveButtonGapTd" );
      ((Element)v.get(777)).appendChild((Element)v.get(797));

      /* Empieza nodo:798 / Elemento padre: 797   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(798)).setAttribute("src","b.gif" );
      ((Element)v.get(798)).setAttribute("height","8" );
      ((Element)v.get(798)).setAttribute("width","10" );
      ((Element)v.get(797)).appendChild((Element)v.get(798));
      /* Termina nodo:798   */
      /* Termina nodo:797   */

      /* Empieza nodo:799 / Elemento padre: 777   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(799)).setAttribute("class","tablaTitle" );
      ((Element)v.get(799)).setAttribute("nombre","zonValorEstruGeopoLovSelectButtonTd" );
      ((Element)v.get(777)).appendChild((Element)v.get(799));

      /* Empieza nodo:800 / Elemento padre: 799   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(800)).setAttribute("nombre","zonValorEstruGeopoLovSelectButton" );
      ((Element)v.get(800)).setAttribute("ID","botonContenido" );
      ((Element)v.get(800)).setAttribute("tipo","html" );
      ((Element)v.get(800)).setAttribute("accion","zonValorEstruGeopoLovSelectionAction();" );
      ((Element)v.get(800)).setAttribute("estado","true" );
      ((Element)v.get(800)).setAttribute("cod","MMGGlobal.lovSelectButton.label" );
      ((Element)v.get(799)).appendChild((Element)v.get(800));
      /* Termina nodo:800   */
      /* Termina nodo:799   */

      /* Empieza nodo:801 / Elemento padre: 777   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(801)).setAttribute("nombre","zonValorEstruGeopoLovSelectButtonGapTd" );
      ((Element)v.get(777)).appendChild((Element)v.get(801));

      /* Empieza nodo:802 / Elemento padre: 801   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(802)).setAttribute("src","b.gif" );
      ((Element)v.get(802)).setAttribute("height","8" );
      ((Element)v.get(802)).setAttribute("width","10" );
      ((Element)v.get(801)).appendChild((Element)v.get(802));
      /* Termina nodo:802   */
      /* Termina nodo:801   */

      /* Empieza nodo:803 / Elemento padre: 777   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(803)).setAttribute("class","tablaTitle" );
      ((Element)v.get(803)).setAttribute("nombre","zonValorEstruGeopoViewButtonTd" );
      ((Element)v.get(777)).appendChild((Element)v.get(803));

      /* Empieza nodo:804 / Elemento padre: 803   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(804)).setAttribute("nombre","zonValorEstruGeopoViewButton" );
      ((Element)v.get(804)).setAttribute("ID","botonContenido" );
      ((Element)v.get(804)).setAttribute("tipo","html" );
      ((Element)v.get(804)).setAttribute("accion","zonValorEstruGeopoViewSelection();" );
      ((Element)v.get(804)).setAttribute("estado","false" );
      ((Element)v.get(804)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(803)).appendChild((Element)v.get(804));
      /* Termina nodo:804   */
      /* Termina nodo:803   */

      /* Empieza nodo:805 / Elemento padre: 777   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(805)).setAttribute("nombre","zonValorEstruGeopoViewButtonGapTd" );
      ((Element)v.get(777)).appendChild((Element)v.get(805));

      /* Empieza nodo:806 / Elemento padre: 805   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(806)).setAttribute("src","b.gif" );
      ((Element)v.get(806)).setAttribute("height","8" );
      ((Element)v.get(806)).setAttribute("width","10" );
      ((Element)v.get(805)).appendChild((Element)v.get(806));
      /* Termina nodo:806   */
      /* Termina nodo:805   */

      /* Empieza nodo:807 / Elemento padre: 777   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(807)).setAttribute("width","100%" );
      ((Element)v.get(777)).appendChild((Element)v.get(807));
      /* Termina nodo:807   */
      /* Termina nodo:777   */
      /* Termina nodo:775   */
      /* Termina nodo:4   */


   }

}

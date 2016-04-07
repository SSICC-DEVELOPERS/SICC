
import org.w3c.dom.*;
import java.util.ArrayList;

public class BelParamBelcePage  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML3780(doc);
         

      getXML3870(doc);
         

      getXML3960(doc);
         

      getXML4050(doc);
         

      getXML4140(doc);
         

      getXML4230(doc);
         

      getXML4320(doc);
         

      getXML4410(doc);
         

      getXML4500(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","BelParamBelcePage" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","belParamBelceInitComponents()" );
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
      ((Element)v.get(3)).setAttribute("src","belparambelce.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(4)).setAttribute("nombre","belParamBelceFrm" );
      ((Element)v.get(4)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(5)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(5)).setAttribute("valor","BelParamBelceLPExecution" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","ON" );
      ((Element)v.get(6)).setAttribute("valor","BelParamBelceLPExecution" );
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
      ((Element)v.get(36)).setAttribute("nombre","belParamBelceFormLayer" );
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
      ((Element)v.get(51)).setAttribute("cod","BelParamBelce.legend.label" );
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
      ((Element)v.get(66)).setAttribute("cod","BelParamBelce.id.label" );
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
      ((Element)v.get(69)).setAttribute("ontab","ejecutarAccionFoco('belParamBelceFrm',1, true)" );
      ((Element)v.get(69)).setAttribute("onshtab","ejecutarAccionFoco('belParamBelceFrm', 1, false)" );
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
      ((Element)v.get(87)).setAttribute("nombre","sbacOidSbac_acceOidAcce_canaOidCanaTdId" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("TABLE"));
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
      ((Element)v.get(91)).setAttribute("nombre","lblsbacOidSbac_acceOidAcce_canaOidCana" );
      ((Element)v.get(91)).setAttribute("id","datosTitle" );
      ((Element)v.get(91)).setAttribute("ancho","150" );
      ((Element)v.get(91)).setAttribute("alto","13" );
      ((Element)v.get(91)).setAttribute("cod","SegAcces.canaOidCana.label" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:92 / Elemento padre: 88   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(92)).setAttribute("nombre","sbacOidSbac_acceOidAcce_canaOidCanaWidgetTrId" );
      ((Element)v.get(88)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(93)).setAttribute("align","left" );
      ((Element)v.get(93)).setAttribute("nowrap","true" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(94)).setAttribute("nombre","sbacOidSbac_acceOidAcce_canaOidCana" );
      ((Element)v.get(94)).setAttribute("id","datosCampos" );
      ((Element)v.get(94)).setAttribute("multiple","N" );
      ((Element)v.get(94)).setAttribute("req","N" );
      ((Element)v.get(94)).setAttribute("size","1" );
      ((Element)v.get(94)).setAttribute("disabled","" );
      ((Element)v.get(94)).setAttribute("validacion","" );
      ((Element)v.get(94)).setAttribute("onchange","mmgDependeneChange('sbacOidSbac_acceOidAcce_canaOidCana', 'sbacOidSbac' , 'belParamBelce')" );
      ((Element)v.get(94)).setAttribute("onfocus","" );
      ((Element)v.get(94)).setAttribute("valorinicial","" );
      ((Element)v.get(94)).setAttribute("textoinicial","" );
      ((Element)v.get(94)).setAttribute("ontab","focaliza('belParamBelceFrm.sbacOidSbac_acceOidAcce');" );
      ((Element)v.get(94)).setAttribute("onshtab","ejecutarAccionFoco('belParamBelceFrm',2, false);" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:96 / Elemento padre: 86   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(96)).setAttribute("nombre","sbacOidSbac_acceOidAcce_canaOidCanaGapTdId" );
      ((Element)v.get(96)).setAttribute("nowrap","true" );
      ((Element)v.get(96)).setAttribute("class","datosCampos" );
      ((Element)v.get(86)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","25" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 86   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(98)).setAttribute("nombre","sbacOidSbac_acceOidAcceTdId" );
      ((Element)v.get(86)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(99)).setAttribute("border","0" );
      ((Element)v.get(99)).setAttribute("cellspacing","0" );
      ((Element)v.get(99)).setAttribute("cellpadding","0" );
      ((Element)v.get(99)).setAttribute("align","left" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("TR"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(101)).setAttribute("valign","top" );
      ((Element)v.get(101)).setAttribute("height","13" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(102)).setAttribute("nombre","lblsbacOidSbac_acceOidAcce" );
      ((Element)v.get(102)).setAttribute("id","datosTitle" );
      ((Element)v.get(102)).setAttribute("ancho","150" );
      ((Element)v.get(102)).setAttribute("alto","13" );
      ((Element)v.get(102)).setAttribute("cod","SegSubac.acceOidAcce.label" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */

      /* Empieza nodo:103 / Elemento padre: 99   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(103)).setAttribute("nombre","sbacOidSbac_acceOidAcceWidgetTrId" );
      ((Element)v.get(99)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(104)).setAttribute("align","left" );
      ((Element)v.get(104)).setAttribute("nowrap","true" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(105)).setAttribute("nombre","sbacOidSbac_acceOidAcce" );
      ((Element)v.get(105)).setAttribute("id","datosCampos" );
      ((Element)v.get(105)).setAttribute("multiple","N" );
      ((Element)v.get(105)).setAttribute("req","N" );
      ((Element)v.get(105)).setAttribute("size","1" );
      ((Element)v.get(105)).setAttribute("disabled","" );
      ((Element)v.get(105)).setAttribute("validacion","" );
      ((Element)v.get(105)).setAttribute("onchange","mmgDependeneChange('sbacOidSbac_acceOidAcce', 'sbacOidSbac' , 'belParamBelce')" );
      ((Element)v.get(105)).setAttribute("onfocus","" );
      ((Element)v.get(105)).setAttribute("valorinicial","" );
      ((Element)v.get(105)).setAttribute("textoinicial","" );
      ((Element)v.get(105)).setAttribute("ontab","focaliza('belParamBelceFrm.sbacOidSbac');" );
      ((Element)v.get(105)).setAttribute("onshtab","focaliza('belParamBelceFrm.sbacOidSbac_acceOidAcce_canaOidCana');" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:103   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */

      /* Empieza nodo:107 / Elemento padre: 86   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(107)).setAttribute("nombre","sbacOidSbac_acceOidAcceGapTdId" );
      ((Element)v.get(107)).setAttribute("nowrap","true" );
      ((Element)v.get(107)).setAttribute("class","datosCampos" );
      ((Element)v.get(86)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","25" );
      ((Element)v.get(108)).setAttribute("height","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 86   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(109)).setAttribute("nombre","sbacOidSbacTdId" );
      ((Element)v.get(86)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(110)).setAttribute("border","0" );
      ((Element)v.get(110)).setAttribute("cellspacing","0" );
      ((Element)v.get(110)).setAttribute("cellpadding","0" );
      ((Element)v.get(110)).setAttribute("align","left" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(112)).setAttribute("valign","top" );
      ((Element)v.get(112)).setAttribute("height","13" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(113)).setAttribute("nombre","lblsbacOidSbac" );
      ((Element)v.get(113)).setAttribute("id","datosTitle" );
      ((Element)v.get(113)).setAttribute("ancho","150" );
      ((Element)v.get(113)).setAttribute("alto","13" );
      ((Element)v.get(113)).setAttribute("cod","BelParamBelce.sbacOidSbac.label" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:114 / Elemento padre: 110   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(114)).setAttribute("nombre","sbacOidSbacWidgetTrId" );
      ((Element)v.get(110)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(115)).setAttribute("align","left" );
      ((Element)v.get(115)).setAttribute("nowrap","true" );
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(116)).setAttribute("nombre","sbacOidSbac" );
      ((Element)v.get(116)).setAttribute("id","datosCampos" );
      ((Element)v.get(116)).setAttribute("multiple","N" );
      ((Element)v.get(116)).setAttribute("req","N" );
      ((Element)v.get(116)).setAttribute("size","1" );
      ((Element)v.get(116)).setAttribute("disabled","" );
      ((Element)v.get(116)).setAttribute("validacion","" );
      ((Element)v.get(116)).setAttribute("onchange","" );
      ((Element)v.get(116)).setAttribute("onfocus","" );
      ((Element)v.get(116)).setAttribute("valorinicial","" );
      ((Element)v.get(116)).setAttribute("textoinicial","" );
      ((Element)v.get(116)).setAttribute("ontab","ejecutarAccionFoco('belParamBelceFrm',2, true);" );
      ((Element)v.get(116)).setAttribute("onshtab","focaliza('belParamBelceFrm.sbacOidSbac_acceOidAcce');" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:114   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:118 / Elemento padre: 86   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(118)).setAttribute("nombre","sbacOidSbacGapTdId" );
      ((Element)v.get(118)).setAttribute("nowrap","true" );
      ((Element)v.get(118)).setAttribute("class","datosCampos" );
      ((Element)v.get(86)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).setAttribute("width","25" );
      ((Element)v.get(119)).setAttribute("height","8" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 86   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(120)).setAttribute("width","100%" );
      ((Element)v.get(86)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(121)).setAttribute("src","b.gif" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:81   */

      /* Empieza nodo:122 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(122)).setAttribute("nombre","formGapTr1" );
      ((Element)v.get(52)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(123)).setAttribute("align","center" );
      ((Element)v.get(123)).setAttribute("width","8" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","12" );
      ((Element)v.get(124)).setAttribute("height","8" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 122   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(122)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(126)).setAttribute("src","b.gif" );
      ((Element)v.get(126)).setAttribute("width","8" );
      ((Element)v.get(126)).setAttribute("height","8" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:127 / Elemento padre: 122   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(127)).setAttribute("align","center" );
      ((Element)v.get(127)).setAttribute("width","8" );
      ((Element)v.get(122)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","12" );
      ((Element)v.get(128)).setAttribute("height","8" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:122   */

      /* Empieza nodo:129 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(129)).setAttribute("nombre","formTr2" );
      ((Element)v.get(52)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(130)).setAttribute("align","center" );
      ((Element)v.get(130)).setAttribute("width","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(131)).setAttribute("src","b.gif" );
      ((Element)v.get(131)).setAttribute("width","8" );
      ((Element)v.get(131)).setAttribute("height","12" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 129   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(132)).setAttribute("width","100%" );
      ((Element)v.get(129)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(133)).setAttribute("width","100%" );
      ((Element)v.get(133)).setAttribute("border","0" );
      ((Element)v.get(133)).setAttribute("cellspacing","0" );
      ((Element)v.get(133)).setAttribute("cellpadding","0" );
      ((Element)v.get(133)).setAttribute("align","left" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(134)).setAttribute("align","left" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(135)).setAttribute("nombre","valDireTdId" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(136)).setAttribute("width","100%" );
      ((Element)v.get(136)).setAttribute("border","0" );
      ((Element)v.get(136)).setAttribute("cellspacing","0" );
      ((Element)v.get(136)).setAttribute("cellpadding","0" );
      ((Element)v.get(136)).setAttribute("align","left" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(138)).setAttribute("valign","top" );
      ((Element)v.get(138)).setAttribute("height","13" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(139)).setAttribute("nombre","lblValDire" );
      ((Element)v.get(139)).setAttribute("alto","13" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(139)).setAttribute("filas","1" );
      ((Element)v.get(139)).setAttribute("id","datosTitle" );
      ((Element)v.get(139)).setAttribute("cod","BelParamBelce.valDire.label" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:140 / Elemento padre: 136   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(140)).setAttribute("nombre","valDireWidgetTrId" );
      ((Element)v.get(136)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(141)).setAttribute("align","left" );
      ((Element)v.get(141)).setAttribute("nowrap","true" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(142)).setAttribute("nombre","valDire" );
      ((Element)v.get(142)).setAttribute("id","datosCampos" );
      ((Element)v.get(142)).setAttribute("trim","S" );
      ((Element)v.get(142)).setAttribute("max","50" );
      ((Element)v.get(142)).setAttribute("onchange","" );
      ((Element)v.get(142)).setAttribute("req","N" );
      ((Element)v.get(142)).setAttribute("size","50" );
      ((Element)v.get(142)).setAttribute("valor","" );
      ((Element)v.get(142)).setAttribute("validacion","" );
      ((Element)v.get(142)).setAttribute("disabled","" );
      ((Element)v.get(142)).setAttribute("onblur","" );
      ((Element)v.get(142)).setAttribute("ontab","ejecutarAccionFoco('belParamBelceFrm',3, true)" );
      ((Element)v.get(142)).setAttribute("onshtab","ejecutarAccionFoco('belParamBelceFrm', 3, false)" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:143 / Elemento padre: 134   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(143)).setAttribute("nombre","valDireGapTdId" );
      ((Element)v.get(143)).setAttribute("nowrap","true" );
      ((Element)v.get(143)).setAttribute("class","datosCampos" );
      ((Element)v.get(134)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","25" );
      ((Element)v.get(144)).setAttribute("height","8" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 134   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(145)).setAttribute("width","100%" );
      ((Element)v.get(134)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:129   */

      /* Empieza nodo:147 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(147)).setAttribute("nombre","formGapTr2" );
      ((Element)v.get(52)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(148)).setAttribute("align","center" );
      ((Element)v.get(148)).setAttribute("width","8" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","12" );
      ((Element)v.get(149)).setAttribute("height","8" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 147   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(147)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(151)).setAttribute("width","8" );
      ((Element)v.get(151)).setAttribute("height","8" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:152 / Elemento padre: 147   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(152)).setAttribute("align","center" );
      ((Element)v.get(152)).setAttribute("width","8" );
      ((Element)v.get(147)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(153)).setAttribute("src","b.gif" );
      ((Element)v.get(153)).setAttribute("width","12" );
      ((Element)v.get(153)).setAttribute("height","8" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:147   */

      /* Empieza nodo:154 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(154)).setAttribute("nombre","formTr3" );
      ((Element)v.get(52)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(155)).setAttribute("align","center" );
      ((Element)v.get(155)).setAttribute("width","8" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","8" );
      ((Element)v.get(156)).setAttribute("height","12" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 154   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(157)).setAttribute("width","100%" );
      ((Element)v.get(154)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(158)).setAttribute("width","100%" );
      ((Element)v.get(158)).setAttribute("border","0" );
      ((Element)v.get(158)).setAttribute("cellspacing","0" );
      ((Element)v.get(158)).setAttribute("cellpadding","0" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(158)).setAttribute("align","left" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(159)).setAttribute("align","left" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(160)).setAttribute("nombre","valTfnoTdId" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(161)).setAttribute("width","100%" );
      ((Element)v.get(161)).setAttribute("border","0" );
      ((Element)v.get(161)).setAttribute("cellspacing","0" );
      ((Element)v.get(161)).setAttribute("cellpadding","0" );
      ((Element)v.get(161)).setAttribute("align","left" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(163)).setAttribute("valign","top" );
      ((Element)v.get(163)).setAttribute("height","13" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(164)).setAttribute("nombre","lblValTfno" );
      ((Element)v.get(164)).setAttribute("alto","13" );
      ((Element)v.get(164)).setAttribute("filas","1" );
      ((Element)v.get(164)).setAttribute("id","datosTitle" );
      ((Element)v.get(164)).setAttribute("cod","BelParamBelce.valTfno.label" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:165 / Elemento padre: 161   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(165)).setAttribute("nombre","valTfnoWidgetTrId" );
      ((Element)v.get(161)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(166)).setAttribute("align","left" );
      ((Element)v.get(166)).setAttribute("nowrap","true" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(167)).setAttribute("nombre","valTfno" );
      ((Element)v.get(167)).setAttribute("id","datosCampos" );
      ((Element)v.get(167)).setAttribute("trim","S" );
      ((Element)v.get(167)).setAttribute("max","30" );
      ((Element)v.get(167)).setAttribute("onchange","" );
      ((Element)v.get(167)).setAttribute("req","N" );
      ((Element)v.get(167)).setAttribute("size","30" );
      ((Element)v.get(167)).setAttribute("valor","" );
      ((Element)v.get(167)).setAttribute("validacion","" );
      ((Element)v.get(167)).setAttribute("disabled","" );
      ((Element)v.get(167)).setAttribute("onblur","" );
      ((Element)v.get(167)).setAttribute("ontab","ejecutarAccionFoco('belParamBelceFrm',4, true)" );
      ((Element)v.get(167)).setAttribute("onshtab","ejecutarAccionFoco('belParamBelceFrm', 4, false)" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:165   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:168 / Elemento padre: 159   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(168)).setAttribute("nombre","valTfnoGapTdId" );
      ((Element)v.get(168)).setAttribute("nowrap","true" );
      ((Element)v.get(168)).setAttribute("class","datosCampos" );
      ((Element)v.get(159)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(169)).setAttribute("src","b.gif" );
      ((Element)v.get(169)).setAttribute("width","25" );
      ((Element)v.get(169)).setAttribute("height","8" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 159   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(170)).setAttribute("width","100%" );
      ((Element)v.get(159)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(171)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:154   */

      /* Empieza nodo:172 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(172)).setAttribute("nombre","formGapTr3" );
      ((Element)v.get(52)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(173)).setAttribute("align","center" );
      ((Element)v.get(173)).setAttribute("width","8" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).setAttribute("width","12" );
      ((Element)v.get(174)).setAttribute("height","8" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 172   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(172)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(176)).setAttribute("src","b.gif" );
      ((Element)v.get(176)).setAttribute("width","8" );
      ((Element)v.get(176)).setAttribute("height","8" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 172   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(177)).setAttribute("align","center" );
      ((Element)v.get(177)).setAttribute("width","8" );
      ((Element)v.get(172)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(178)).setAttribute("src","b.gif" );
      ((Element)v.get(178)).setAttribute("width","12" );
      ((Element)v.get(178)).setAttribute("height","8" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:172   */

      /* Empieza nodo:179 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(179)).setAttribute("nombre","formTr4" );
      ((Element)v.get(52)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(180)).setAttribute("align","center" );
      ((Element)v.get(180)).setAttribute("width","8" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).setAttribute("width","8" );
      ((Element)v.get(181)).setAttribute("height","12" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:182 / Elemento padre: 179   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(182)).setAttribute("width","100%" );
      ((Element)v.get(179)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(183)).setAttribute("width","100%" );
      ((Element)v.get(183)).setAttribute("border","0" );
      ((Element)v.get(183)).setAttribute("cellspacing","0" );
      ((Element)v.get(183)).setAttribute("cellpadding","0" );
      ((Element)v.get(183)).setAttribute("align","left" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(184)).setAttribute("align","left" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(185)).setAttribute("nombre","valMontMaxiDifeTdId" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(186)).setAttribute("width","100%" );
      ((Element)v.get(186)).setAttribute("border","0" );
      ((Element)v.get(186)).setAttribute("cellspacing","0" );
      ((Element)v.get(186)).setAttribute("cellpadding","0" );
      ((Element)v.get(186)).setAttribute("align","left" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(186)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(188)).setAttribute("valign","top" );
      ((Element)v.get(188)).setAttribute("height","13" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(189)).setAttribute("nombre","lblValMontMaxiDife" );
      ((Element)v.get(189)).setAttribute("alto","13" );
      ((Element)v.get(189)).setAttribute("filas","1" );
      ((Element)v.get(189)).setAttribute("id","datosTitle" );
      ((Element)v.get(189)).setAttribute("cod","BelParamBelce.valMontMaxiDife.label" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:190 / Elemento padre: 186   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(190)).setAttribute("nombre","valMontMaxiDifeWidgetTrId" );
      ((Element)v.get(186)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(191)).setAttribute("align","left" );
      ((Element)v.get(191)).setAttribute("nowrap","true" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(192)).setAttribute("nombre","valMontMaxiDife" );
      ((Element)v.get(192)).setAttribute("id","datosCampos" );
      ((Element)v.get(192)).setAttribute("trim","S" );
      ((Element)v.get(192)).setAttribute("max","12" );
      ((Element)v.get(192)).setAttribute("onchange","" );
      ((Element)v.get(192)).setAttribute("req","N" );
      ((Element)v.get(192)).setAttribute("size","12" );
      ((Element)v.get(192)).setAttribute("valor","" );
      ((Element)v.get(192)).setAttribute("validacion","" );
      ((Element)v.get(192)).setAttribute("disabled","" );
      ((Element)v.get(192)).setAttribute("onblur","" );
      ((Element)v.get(192)).setAttribute("ontab","ejecutarAccionFoco('belParamBelceFrm',5, true)" );
      ((Element)v.get(192)).setAttribute("onshtab","ejecutarAccionFoco('belParamBelceFrm', 5, false)" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:190   */
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:193 / Elemento padre: 184   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(193)).setAttribute("nombre","valMontMaxiDifeGapTdId" );
      ((Element)v.get(193)).setAttribute("nowrap","true" );
      ((Element)v.get(193)).setAttribute("class","datosCampos" );
      ((Element)v.get(184)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(194)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).setAttribute("width","25" );
      ((Element)v.get(194)).setAttribute("height","8" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));
      /* Termina nodo:194   */
      /* Termina nodo:193   */

      /* Empieza nodo:195 / Elemento padre: 184   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(195)).setAttribute("width","100%" );
      ((Element)v.get(184)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */
      /* Termina nodo:184   */
      /* Termina nodo:183   */
      /* Termina nodo:182   */
      /* Termina nodo:179   */

      /* Empieza nodo:197 / Elemento padre: 52   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("TR"));
      ((Element)v.get(197)).setAttribute("nombre","formGapTr4" );
      ((Element)v.get(52)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(198)).setAttribute("align","center" );
      ((Element)v.get(198)).setAttribute("width","8" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(199)).setAttribute("src","b.gif" );
      ((Element)v.get(199)).setAttribute("width","12" );
      ((Element)v.get(199)).setAttribute("height","8" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:200 / Elemento padre: 197   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(197)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(201)).setAttribute("src","b.gif" );
      ((Element)v.get(201)).setAttribute("width","8" );
      ((Element)v.get(201)).setAttribute("height","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */

      /* Empieza nodo:202 / Elemento padre: 197   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(202)).setAttribute("align","center" );
      ((Element)v.get(202)).setAttribute("width","8" );
      ((Element)v.get(197)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(203)).setAttribute("src","b.gif" );
      ((Element)v.get(203)).setAttribute("width","12" );
      ((Element)v.get(203)).setAttribute("height","8" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */
      /* Termina nodo:197   */

      /* Empieza nodo:204 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(204)).setAttribute("nombre","formTr5" );
      ((Element)v.get(52)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(205)).setAttribute("align","center" );
      ((Element)v.get(205)).setAttribute("width","8" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).setAttribute("width","8" );
      ((Element)v.get(206)).setAttribute("height","12" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:207 / Elemento padre: 204   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(207)).setAttribute("width","100%" );
      ((Element)v.get(204)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(208)).setAttribute("width","100%" );
      ((Element)v.get(208)).setAttribute("border","0" );
      ((Element)v.get(208)).setAttribute("cellspacing","0" );
      ((Element)v.get(208)).setAttribute("cellpadding","0" );
      ((Element)v.get(208)).setAttribute("align","left" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(209)).setAttribute("align","left" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(210)).setAttribute("nombre","valLimiEfecCajaTdId" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(211)).setAttribute("width","100%" );
      ((Element)v.get(211)).setAttribute("border","0" );
      ((Element)v.get(211)).setAttribute("cellspacing","0" );
      ((Element)v.get(211)).setAttribute("cellpadding","0" );
      ((Element)v.get(211)).setAttribute("align","left" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(213)).setAttribute("valign","top" );
      ((Element)v.get(213)).setAttribute("height","13" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(214)).setAttribute("nombre","lblValLimiEfecCaja" );
      ((Element)v.get(214)).setAttribute("alto","13" );
      ((Element)v.get(214)).setAttribute("filas","1" );
      ((Element)v.get(214)).setAttribute("id","datosTitle" );
      ((Element)v.get(214)).setAttribute("cod","BelParamBelce.valLimiEfecCaja.label" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:215 / Elemento padre: 211   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(215)).setAttribute("nombre","valLimiEfecCajaWidgetTrId" );
      ((Element)v.get(211)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(216)).setAttribute("align","left" );
      ((Element)v.get(216)).setAttribute("nowrap","true" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(217)).setAttribute("nombre","valLimiEfecCaja" );
      ((Element)v.get(217)).setAttribute("id","datosCampos" );
      ((Element)v.get(217)).setAttribute("trim","S" );
      ((Element)v.get(217)).setAttribute("max","12" );
      ((Element)v.get(217)).setAttribute("onchange","" );
      ((Element)v.get(217)).setAttribute("req","N" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(217)).setAttribute("size","12" );
      ((Element)v.get(217)).setAttribute("valor","" );
      ((Element)v.get(217)).setAttribute("validacion","" );
      ((Element)v.get(217)).setAttribute("disabled","" );
      ((Element)v.get(217)).setAttribute("onblur","" );
      ((Element)v.get(217)).setAttribute("ontab","ejecutarAccionFoco('belParamBelceFrm',6, true)" );
      ((Element)v.get(217)).setAttribute("onshtab","ejecutarAccionFoco('belParamBelceFrm', 6, false)" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */
      /* Termina nodo:215   */
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:218 / Elemento padre: 209   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(218)).setAttribute("nombre","valLimiEfecCajaGapTdId" );
      ((Element)v.get(218)).setAttribute("nowrap","true" );
      ((Element)v.get(218)).setAttribute("class","datosCampos" );
      ((Element)v.get(209)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("width","25" );
      ((Element)v.get(219)).setAttribute("height","8" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 209   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(220)).setAttribute("width","100%" );
      ((Element)v.get(209)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(221)).setAttribute("src","b.gif" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:204   */

      /* Empieza nodo:222 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(222)).setAttribute("nombre","formGapTr5" );
      ((Element)v.get(52)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(223)).setAttribute("align","center" );
      ((Element)v.get(223)).setAttribute("width","8" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(224)).setAttribute("src","b.gif" );
      ((Element)v.get(224)).setAttribute("width","12" );
      ((Element)v.get(224)).setAttribute("height","8" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:225 / Elemento padre: 222   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(222)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(226)).setAttribute("src","b.gif" );
      ((Element)v.get(226)).setAttribute("width","8" );
      ((Element)v.get(226)).setAttribute("height","8" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:227 / Elemento padre: 222   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(227)).setAttribute("align","center" );
      ((Element)v.get(227)).setAttribute("width","8" );
      ((Element)v.get(222)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(228)).setAttribute("src","b.gif" );
      ((Element)v.get(228)).setAttribute("width","12" );
      ((Element)v.get(228)).setAttribute("height","8" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */
      /* Termina nodo:222   */

      /* Empieza nodo:229 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(229)).setAttribute("nombre","formTr6" );
      ((Element)v.get(52)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(230)).setAttribute("align","center" );
      ((Element)v.get(230)).setAttribute("width","8" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(231)).setAttribute("src","b.gif" );
      ((Element)v.get(231)).setAttribute("width","8" );
      ((Element)v.get(231)).setAttribute("height","12" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:232 / Elemento padre: 229   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(232)).setAttribute("width","100%" );
      ((Element)v.get(229)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(233)).setAttribute("width","100%" );
      ((Element)v.get(233)).setAttribute("border","0" );
      ((Element)v.get(233)).setAttribute("cellspacing","0" );
      ((Element)v.get(233)).setAttribute("cellpadding","0" );
      ((Element)v.get(233)).setAttribute("align","left" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(234)).setAttribute("align","left" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(235)).setAttribute("nombre","numCajaTdId" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(236)).setAttribute("width","100%" );
      ((Element)v.get(236)).setAttribute("border","0" );
      ((Element)v.get(236)).setAttribute("cellspacing","0" );
      ((Element)v.get(236)).setAttribute("cellpadding","0" );
      ((Element)v.get(236)).setAttribute("align","left" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("TD"));
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(238)).setAttribute("valign","top" );
      ((Element)v.get(238)).setAttribute("height","13" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(239)).setAttribute("nombre","lblNumCaja" );
      ((Element)v.get(239)).setAttribute("alto","13" );
      ((Element)v.get(239)).setAttribute("filas","1" );
      ((Element)v.get(239)).setAttribute("id","datosTitle" );
      ((Element)v.get(239)).setAttribute("cod","BelParamBelce.numCaja.label" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:240 / Elemento padre: 236   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(240)).setAttribute("nombre","numCajaWidgetTrId" );
      ((Element)v.get(236)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(241)).setAttribute("align","left" );
      ((Element)v.get(241)).setAttribute("nowrap","true" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(242)).setAttribute("nombre","numCaja" );
      ((Element)v.get(242)).setAttribute("id","datosCampos" );
      ((Element)v.get(242)).setAttribute("trim","S" );
      ((Element)v.get(242)).setAttribute("max","3" );
      ((Element)v.get(242)).setAttribute("onchange","" );
      ((Element)v.get(242)).setAttribute("req","N" );
      ((Element)v.get(242)).setAttribute("size","3" );
      ((Element)v.get(242)).setAttribute("valor","" );
      ((Element)v.get(242)).setAttribute("validacion","" );
      ((Element)v.get(242)).setAttribute("disabled","" );
      ((Element)v.get(242)).setAttribute("onblur","" );
      ((Element)v.get(242)).setAttribute("ontab","ejecutarAccionFoco('belParamBelceFrm',7, true)" );
      ((Element)v.get(242)).setAttribute("onshtab","ejecutarAccionFoco('belParamBelceFrm', 7, false)" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */
      /* Termina nodo:240   */
      /* Termina nodo:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:243 / Elemento padre: 234   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(243)).setAttribute("nombre","numCajaGapTdId" );
      ((Element)v.get(243)).setAttribute("nowrap","true" );
      ((Element)v.get(243)).setAttribute("class","datosCampos" );
      ((Element)v.get(234)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(244)).setAttribute("src","b.gif" );
      ((Element)v.get(244)).setAttribute("width","25" );
      ((Element)v.get(244)).setAttribute("height","8" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:245 / Elemento padre: 234   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(245)).setAttribute("width","100%" );
      ((Element)v.get(234)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(246)).setAttribute("src","b.gif" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */
      /* Termina nodo:234   */
      /* Termina nodo:233   */
      /* Termina nodo:232   */
      /* Termina nodo:229   */

      /* Empieza nodo:247 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(247)).setAttribute("nombre","formGapTr6" );
      ((Element)v.get(52)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(248)).setAttribute("align","center" );
      ((Element)v.get(248)).setAttribute("width","8" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(249)).setAttribute("src","b.gif" );
      ((Element)v.get(249)).setAttribute("width","12" );
      ((Element)v.get(249)).setAttribute("height","8" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:250 / Elemento padre: 247   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(247)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(251)).setAttribute("src","b.gif" );
      ((Element)v.get(251)).setAttribute("width","8" );
      ((Element)v.get(251)).setAttribute("height","8" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:252 / Elemento padre: 247   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(252)).setAttribute("align","center" );
      ((Element)v.get(252)).setAttribute("width","8" );
      ((Element)v.get(247)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(253)).setAttribute("src","b.gif" );
      ((Element)v.get(253)).setAttribute("width","12" );
      ((Element)v.get(253)).setAttribute("height","8" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */
      /* Termina nodo:247   */

      /* Empieza nodo:254 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(254)).setAttribute("nombre","formTr7" );
      ((Element)v.get(52)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(255)).setAttribute("align","center" );
      ((Element)v.get(255)).setAttribute("width","8" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(256)).setAttribute("src","b.gif" );
      ((Element)v.get(256)).setAttribute("width","8" );
      ((Element)v.get(256)).setAttribute("height","12" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:257 / Elemento padre: 254   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(257)).setAttribute("width","100%" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(254)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(258)).setAttribute("width","100%" );
      ((Element)v.get(258)).setAttribute("border","0" );
      ((Element)v.get(258)).setAttribute("cellspacing","0" );
      ((Element)v.get(258)).setAttribute("cellpadding","0" );
      ((Element)v.get(258)).setAttribute("align","left" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(259)).setAttribute("align","left" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(260)).setAttribute("nombre","valNombLocaTdId" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(261)).setAttribute("width","100%" );
      ((Element)v.get(261)).setAttribute("border","0" );
      ((Element)v.get(261)).setAttribute("cellspacing","0" );
      ((Element)v.get(261)).setAttribute("cellpadding","0" );
      ((Element)v.get(261)).setAttribute("align","left" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(261)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(263)).setAttribute("valign","top" );
      ((Element)v.get(263)).setAttribute("height","13" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(264)).setAttribute("nombre","lblValNombLoca" );
      ((Element)v.get(264)).setAttribute("alto","13" );
      ((Element)v.get(264)).setAttribute("filas","1" );
      ((Element)v.get(264)).setAttribute("id","datosTitle" );
      ((Element)v.get(264)).setAttribute("cod","BelParamBelce.valNombLoca.label" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:265 / Elemento padre: 261   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(265)).setAttribute("nombre","valNombLocaWidgetTrId" );
      ((Element)v.get(261)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(266)).setAttribute("align","left" );
      ((Element)v.get(266)).setAttribute("nowrap","true" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(267)).setAttribute("nombre","valNombLoca" );
      ((Element)v.get(267)).setAttribute("id","datosCampos" );
      ((Element)v.get(267)).setAttribute("trim","S" );
      ((Element)v.get(267)).setAttribute("max","40" );
      ((Element)v.get(267)).setAttribute("onchange","" );
      ((Element)v.get(267)).setAttribute("req","N" );
      ((Element)v.get(267)).setAttribute("size","40" );
      ((Element)v.get(267)).setAttribute("valor","" );
      ((Element)v.get(267)).setAttribute("validacion","" );
      ((Element)v.get(267)).setAttribute("disabled","" );
      ((Element)v.get(267)).setAttribute("onblur","" );
      ((Element)v.get(267)).setAttribute("ontab","ejecutarAccionFoco('belParamBelceFrm',8, true)" );
      ((Element)v.get(267)).setAttribute("onshtab","ejecutarAccionFoco('belParamBelceFrm', 8, false)" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */
      /* Termina nodo:265   */
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:268 / Elemento padre: 259   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(268)).setAttribute("nombre","valNombLocaGapTdId" );
      ((Element)v.get(268)).setAttribute("nowrap","true" );
      ((Element)v.get(268)).setAttribute("class","datosCampos" );
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
      v.add(doc.createElement("TD"));
      ((Element)v.get(270)).setAttribute("width","100%" );
      ((Element)v.get(259)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */
      /* Termina nodo:259   */
      /* Termina nodo:258   */
      /* Termina nodo:257   */
      /* Termina nodo:254   */

      /* Empieza nodo:272 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(272)).setAttribute("nombre","formGapTr7" );
      ((Element)v.get(52)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(273)).setAttribute("align","center" );
      ((Element)v.get(273)).setAttribute("width","8" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(274)).setAttribute("src","b.gif" );
      ((Element)v.get(274)).setAttribute("width","12" );
      ((Element)v.get(274)).setAttribute("height","8" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */

      /* Empieza nodo:275 / Elemento padre: 272   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(272)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(276)).setAttribute("src","b.gif" );
      ((Element)v.get(276)).setAttribute("width","8" );
      ((Element)v.get(276)).setAttribute("height","8" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:277 / Elemento padre: 272   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(277)).setAttribute("align","center" );
      ((Element)v.get(277)).setAttribute("width","8" );
      ((Element)v.get(272)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(278)).setAttribute("src","b.gif" );
      ((Element)v.get(278)).setAttribute("width","12" );
      ((Element)v.get(278)).setAttribute("height","8" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */
      /* Termina nodo:272   */

      /* Empieza nodo:279 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(279)).setAttribute("nombre","formTr8" );
      ((Element)v.get(52)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(280)).setAttribute("align","center" );
      ((Element)v.get(280)).setAttribute("width","8" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(281)).setAttribute("src","b.gif" );
      ((Element)v.get(281)).setAttribute("width","8" );
      ((Element)v.get(281)).setAttribute("height","12" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:280   */

      /* Empieza nodo:282 / Elemento padre: 279   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(282)).setAttribute("width","100%" );
      ((Element)v.get(279)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(283)).setAttribute("width","100%" );
      ((Element)v.get(283)).setAttribute("border","0" );
      ((Element)v.get(283)).setAttribute("cellspacing","0" );
      ((Element)v.get(283)).setAttribute("cellpadding","0" );
      ((Element)v.get(283)).setAttribute("align","left" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(284)).setAttribute("align","left" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(285)).setAttribute("nombre","valTiempRepoTdId" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(286)).setAttribute("width","100%" );
      ((Element)v.get(286)).setAttribute("border","0" );
      ((Element)v.get(286)).setAttribute("cellspacing","0" );
      ((Element)v.get(286)).setAttribute("cellpadding","0" );
      ((Element)v.get(286)).setAttribute("align","left" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(286)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(288)).setAttribute("valign","top" );
      ((Element)v.get(288)).setAttribute("height","13" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(289)).setAttribute("nombre","lblValTiempRepo" );
      ((Element)v.get(289)).setAttribute("alto","13" );
      ((Element)v.get(289)).setAttribute("filas","1" );
      ((Element)v.get(289)).setAttribute("id","datosTitle" );
      ((Element)v.get(289)).setAttribute("cod","BelParamBelce.valTiempRepo.label" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:288   */
      /* Termina nodo:287   */

      /* Empieza nodo:290 / Elemento padre: 286   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(290)).setAttribute("nombre","valTiempRepoWidgetTrId" );
      ((Element)v.get(286)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(291)).setAttribute("align","left" );
      ((Element)v.get(291)).setAttribute("nowrap","true" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(292)).setAttribute("nombre","valTiempRepo" );
      ((Element)v.get(292)).setAttribute("id","datosCampos" );
      ((Element)v.get(292)).setAttribute("trim","S" );
      ((Element)v.get(292)).setAttribute("max","2" );
      ((Element)v.get(292)).setAttribute("onchange","" );
      ((Element)v.get(292)).setAttribute("req","N" );
      ((Element)v.get(292)).setAttribute("size","2" );
      ((Element)v.get(292)).setAttribute("valor","" );
      ((Element)v.get(292)).setAttribute("validacion","" );
      ((Element)v.get(292)).setAttribute("disabled","" );
      ((Element)v.get(292)).setAttribute("onblur","" );
      ((Element)v.get(292)).setAttribute("ontab","ejecutarAccionFoco('belParamBelceFrm',9, true)" );
      ((Element)v.get(292)).setAttribute("onshtab","ejecutarAccionFoco('belParamBelceFrm', 9, false)" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:291   */
      /* Termina nodo:290   */
      /* Termina nodo:286   */
      /* Termina nodo:285   */

      /* Empieza nodo:293 / Elemento padre: 284   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(293)).setAttribute("nombre","valTiempRepoGapTdId" );
      ((Element)v.get(293)).setAttribute("nowrap","true" );
      ((Element)v.get(293)).setAttribute("class","datosCampos" );
      ((Element)v.get(284)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(294)).setAttribute("src","b.gif" );
      ((Element)v.get(294)).setAttribute("width","25" );
      ((Element)v.get(294)).setAttribute("height","8" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:293   */

      /* Empieza nodo:295 / Elemento padre: 284   */
   }

   private void getXML1350(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(295)).setAttribute("width","100%" );
      ((Element)v.get(284)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(296)).setAttribute("src","b.gif" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */
      /* Termina nodo:284   */
      /* Termina nodo:283   */
      /* Termina nodo:282   */
      /* Termina nodo:279   */

      /* Empieza nodo:297 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(297)).setAttribute("nombre","formGapTr8" );
      ((Element)v.get(52)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(298)).setAttribute("align","center" );
      ((Element)v.get(298)).setAttribute("width","8" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(299)).setAttribute("src","b.gif" );
      ((Element)v.get(299)).setAttribute("width","12" );
      ((Element)v.get(299)).setAttribute("height","8" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */

      /* Empieza nodo:300 / Elemento padre: 297   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(297)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(301)).setAttribute("src","b.gif" );
      ((Element)v.get(301)).setAttribute("width","8" );
      ((Element)v.get(301)).setAttribute("height","8" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:300   */

      /* Empieza nodo:302 / Elemento padre: 297   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(302)).setAttribute("align","center" );
      ((Element)v.get(302)).setAttribute("width","8" );
      ((Element)v.get(297)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(303)).setAttribute("src","b.gif" );
      ((Element)v.get(303)).setAttribute("width","12" );
      ((Element)v.get(303)).setAttribute("height","8" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:302   */
      /* Termina nodo:297   */

      /* Empieza nodo:304 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(304)).setAttribute("nombre","formTr9" );
      ((Element)v.get(52)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(305)).setAttribute("align","center" );
      ((Element)v.get(305)).setAttribute("width","8" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(306)).setAttribute("src","b.gif" );
      ((Element)v.get(306)).setAttribute("width","8" );
      ((Element)v.get(306)).setAttribute("height","12" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */

      /* Empieza nodo:307 / Elemento padre: 304   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(307)).setAttribute("width","100%" );
      ((Element)v.get(304)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(308)).setAttribute("width","100%" );
      ((Element)v.get(308)).setAttribute("border","0" );
      ((Element)v.get(308)).setAttribute("cellspacing","0" );
      ((Element)v.get(308)).setAttribute("cellpadding","0" );
      ((Element)v.get(308)).setAttribute("align","left" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(309)).setAttribute("align","left" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(310)).setAttribute("nombre","valFactLocaTdId" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(311)).setAttribute("width","100%" );
      ((Element)v.get(311)).setAttribute("border","0" );
      ((Element)v.get(311)).setAttribute("cellspacing","0" );
      ((Element)v.get(311)).setAttribute("cellpadding","0" );
      ((Element)v.get(311)).setAttribute("align","left" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(311)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(313)).setAttribute("valign","top" );
      ((Element)v.get(313)).setAttribute("height","13" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(314)).setAttribute("nombre","lblValFactLoca" );
      ((Element)v.get(314)).setAttribute("alto","13" );
      ((Element)v.get(314)).setAttribute("filas","1" );
      ((Element)v.get(314)).setAttribute("id","datosTitle" );
      ((Element)v.get(314)).setAttribute("cod","BelParamBelce.valFactLoca.label" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */
      /* Termina nodo:312   */

      /* Empieza nodo:315 / Elemento padre: 311   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(315)).setAttribute("nombre","valFactLocaWidgetTrId" );
      ((Element)v.get(311)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(316)).setAttribute("align","left" );
      ((Element)v.get(316)).setAttribute("nowrap","true" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("TEXT"));
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(317)).setAttribute("nombre","valFactLoca" );
      ((Element)v.get(317)).setAttribute("id","datosCampos" );
      ((Element)v.get(317)).setAttribute("trim","S" );
      ((Element)v.get(317)).setAttribute("max","5" );
      ((Element)v.get(317)).setAttribute("onchange","" );
      ((Element)v.get(317)).setAttribute("req","N" );
      ((Element)v.get(317)).setAttribute("size","5" );
      ((Element)v.get(317)).setAttribute("valor","" );
      ((Element)v.get(317)).setAttribute("validacion","" );
      ((Element)v.get(317)).setAttribute("disabled","" );
      ((Element)v.get(317)).setAttribute("onblur","" );
      ((Element)v.get(317)).setAttribute("ontab","ejecutarAccionFoco('belParamBelceFrm',10, true)" );
      ((Element)v.get(317)).setAttribute("onshtab","ejecutarAccionFoco('belParamBelceFrm', 10, false)" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:316   */
      /* Termina nodo:315   */
      /* Termina nodo:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:318 / Elemento padre: 309   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(318)).setAttribute("nombre","valFactLocaGapTdId" );
      ((Element)v.get(318)).setAttribute("nowrap","true" );
      ((Element)v.get(318)).setAttribute("class","datosCampos" );
      ((Element)v.get(309)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(319)).setAttribute("src","b.gif" );
      ((Element)v.get(319)).setAttribute("width","25" );
      ((Element)v.get(319)).setAttribute("height","8" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */
      /* Termina nodo:318   */

      /* Empieza nodo:320 / Elemento padre: 309   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(320)).setAttribute("width","100%" );
      ((Element)v.get(309)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(321)).setAttribute("src","b.gif" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:320   */
      /* Termina nodo:309   */
      /* Termina nodo:308   */
      /* Termina nodo:307   */
      /* Termina nodo:304   */

      /* Empieza nodo:322 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(322)).setAttribute("nombre","formGapTr9" );
      ((Element)v.get(52)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(323)).setAttribute("align","center" );
      ((Element)v.get(323)).setAttribute("width","8" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(324)).setAttribute("src","b.gif" );
      ((Element)v.get(324)).setAttribute("width","12" );
      ((Element)v.get(324)).setAttribute("height","8" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */
      /* Termina nodo:323   */

      /* Empieza nodo:325 / Elemento padre: 322   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(322)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(326)).setAttribute("src","b.gif" );
      ((Element)v.get(326)).setAttribute("width","8" );
      ((Element)v.get(326)).setAttribute("height","8" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:325   */

      /* Empieza nodo:327 / Elemento padre: 322   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(327)).setAttribute("align","center" );
      ((Element)v.get(327)).setAttribute("width","8" );
      ((Element)v.get(322)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(328)).setAttribute("src","b.gif" );
      ((Element)v.get(328)).setAttribute("width","12" );
      ((Element)v.get(328)).setAttribute("height","8" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:327   */
      /* Termina nodo:322   */

      /* Empieza nodo:329 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(329)).setAttribute("nombre","formTr10" );
      ((Element)v.get(52)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(330)).setAttribute("align","center" );
      ((Element)v.get(330)).setAttribute("width","8" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(331)).setAttribute("src","b.gif" );
      ((Element)v.get(331)).setAttribute("width","8" );
      ((Element)v.get(331)).setAttribute("height","12" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */

      /* Empieza nodo:332 / Elemento padre: 329   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(332)).setAttribute("width","100%" );
      ((Element)v.get(329)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(333)).setAttribute("width","100%" );
      ((Element)v.get(333)).setAttribute("border","0" );
      ((Element)v.get(333)).setAttribute("cellspacing","0" );
      ((Element)v.get(333)).setAttribute("cellpadding","0" );
      ((Element)v.get(333)).setAttribute("align","left" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(334)).setAttribute("align","left" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(335)).setAttribute("nombre","numMaxiProdTdId" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(336)).setAttribute("width","100%" );
      ((Element)v.get(336)).setAttribute("border","0" );
      ((Element)v.get(336)).setAttribute("cellspacing","0" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(336)).setAttribute("cellpadding","0" );
      ((Element)v.get(336)).setAttribute("align","left" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(336)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(338)).setAttribute("valign","top" );
      ((Element)v.get(338)).setAttribute("height","13" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(339)).setAttribute("nombre","lblNumMaxiProd" );
      ((Element)v.get(339)).setAttribute("alto","13" );
      ((Element)v.get(339)).setAttribute("filas","1" );
      ((Element)v.get(339)).setAttribute("id","datosTitle" );
      ((Element)v.get(339)).setAttribute("cod","BelParamBelce.numMaxiProd.label" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */
      /* Termina nodo:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:340 / Elemento padre: 336   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(340)).setAttribute("nombre","numMaxiProdWidgetTrId" );
      ((Element)v.get(336)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(341)).setAttribute("align","left" );
      ((Element)v.get(341)).setAttribute("nowrap","true" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(342)).setAttribute("nombre","numMaxiProd" );
      ((Element)v.get(342)).setAttribute("id","datosCampos" );
      ((Element)v.get(342)).setAttribute("trim","S" );
      ((Element)v.get(342)).setAttribute("max","3" );
      ((Element)v.get(342)).setAttribute("onchange","" );
      ((Element)v.get(342)).setAttribute("req","N" );
      ((Element)v.get(342)).setAttribute("size","3" );
      ((Element)v.get(342)).setAttribute("valor","" );
      ((Element)v.get(342)).setAttribute("validacion","" );
      ((Element)v.get(342)).setAttribute("disabled","" );
      ((Element)v.get(342)).setAttribute("onblur","" );
      ((Element)v.get(342)).setAttribute("ontab","ejecutarAccionFoco('belParamBelceFrm',11, true)" );
      ((Element)v.get(342)).setAttribute("onshtab","ejecutarAccionFoco('belParamBelceFrm', 11, false)" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */
      /* Termina nodo:340   */
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:343 / Elemento padre: 334   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(343)).setAttribute("nombre","numMaxiProdGapTdId" );
      ((Element)v.get(343)).setAttribute("nowrap","true" );
      ((Element)v.get(343)).setAttribute("class","datosCampos" );
      ((Element)v.get(334)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(344)).setAttribute("src","b.gif" );
      ((Element)v.get(344)).setAttribute("width","25" );
      ((Element)v.get(344)).setAttribute("height","8" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:343   */

      /* Empieza nodo:345 / Elemento padre: 334   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(345)).setAttribute("width","100%" );
      ((Element)v.get(334)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(346)).setAttribute("src","b.gif" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:345   */
      /* Termina nodo:334   */
      /* Termina nodo:333   */
      /* Termina nodo:332   */
      /* Termina nodo:329   */

      /* Empieza nodo:347 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(347)).setAttribute("nombre","formGapTr10" );
      ((Element)v.get(52)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(348)).setAttribute("align","center" );
      ((Element)v.get(348)).setAttribute("width","8" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(349)).setAttribute("src","b.gif" );
      ((Element)v.get(349)).setAttribute("width","12" );
      ((Element)v.get(349)).setAttribute("height","8" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */
      /* Termina nodo:348   */

      /* Empieza nodo:350 / Elemento padre: 347   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(347)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(351)).setAttribute("src","b.gif" );
      ((Element)v.get(351)).setAttribute("width","8" );
      ((Element)v.get(351)).setAttribute("height","8" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */
      /* Termina nodo:350   */

      /* Empieza nodo:352 / Elemento padre: 347   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(352)).setAttribute("align","center" );
      ((Element)v.get(352)).setAttribute("width","8" );
      ((Element)v.get(347)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(353)).setAttribute("src","b.gif" );
      ((Element)v.get(353)).setAttribute("width","12" );
      ((Element)v.get(353)).setAttribute("height","8" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */
      /* Termina nodo:352   */
      /* Termina nodo:347   */

      /* Empieza nodo:354 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(354)).setAttribute("nombre","formTr11" );
      ((Element)v.get(52)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(355)).setAttribute("align","center" );
      ((Element)v.get(355)).setAttribute("width","8" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(356)).setAttribute("src","b.gif" );
      ((Element)v.get(356)).setAttribute("width","8" );
      ((Element)v.get(356)).setAttribute("height","12" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */
      /* Termina nodo:355   */

      /* Empieza nodo:357 / Elemento padre: 354   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(357)).setAttribute("width","100%" );
      ((Element)v.get(354)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(358)).setAttribute("width","100%" );
      ((Element)v.get(358)).setAttribute("border","0" );
      ((Element)v.get(358)).setAttribute("cellspacing","0" );
      ((Element)v.get(358)).setAttribute("cellpadding","0" );
      ((Element)v.get(358)).setAttribute("align","left" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(359)).setAttribute("align","left" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(360)).setAttribute("nombre","valAlerStocTdId" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(361)).setAttribute("width","100%" );
      ((Element)v.get(361)).setAttribute("border","0" );
      ((Element)v.get(361)).setAttribute("cellspacing","0" );
      ((Element)v.get(361)).setAttribute("cellpadding","0" );
      ((Element)v.get(361)).setAttribute("align","left" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(361)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(363)).setAttribute("valign","top" );
      ((Element)v.get(363)).setAttribute("height","13" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(364)).setAttribute("nombre","lblValAlerStoc" );
      ((Element)v.get(364)).setAttribute("alto","13" );
      ((Element)v.get(364)).setAttribute("filas","1" );
      ((Element)v.get(364)).setAttribute("id","datosTitle" );
      ((Element)v.get(364)).setAttribute("cod","BelParamBelce.valAlerStoc.label" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */
      /* Termina nodo:363   */
      /* Termina nodo:362   */

      /* Empieza nodo:365 / Elemento padre: 361   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(365)).setAttribute("nombre","valAlerStocWidgetTrId" );
      ((Element)v.get(361)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(366)).setAttribute("align","left" );
      ((Element)v.get(366)).setAttribute("nowrap","true" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(367)).setAttribute("nombre","valAlerStoc" );
      ((Element)v.get(367)).setAttribute("id","datosCampos" );
      ((Element)v.get(367)).setAttribute("trim","S" );
      ((Element)v.get(367)).setAttribute("max","10" );
      ((Element)v.get(367)).setAttribute("onchange","" );
      ((Element)v.get(367)).setAttribute("req","N" );
      ((Element)v.get(367)).setAttribute("size","10" );
      ((Element)v.get(367)).setAttribute("valor","" );
      ((Element)v.get(367)).setAttribute("validacion","" );
      ((Element)v.get(367)).setAttribute("disabled","" );
      ((Element)v.get(367)).setAttribute("onblur","" );
      ((Element)v.get(367)).setAttribute("ontab","ejecutarAccionFoco('belParamBelceFrm',12, true)" );
      ((Element)v.get(367)).setAttribute("onshtab","ejecutarAccionFoco('belParamBelceFrm', 12, false)" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */
      /* Termina nodo:366   */
      /* Termina nodo:365   */
      /* Termina nodo:361   */
      /* Termina nodo:360   */

      /* Empieza nodo:368 / Elemento padre: 359   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(368)).setAttribute("nombre","valAlerStocGapTdId" );
      ((Element)v.get(368)).setAttribute("nowrap","true" );
      ((Element)v.get(368)).setAttribute("class","datosCampos" );
      ((Element)v.get(359)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(369)).setAttribute("src","b.gif" );
      ((Element)v.get(369)).setAttribute("width","25" );
      ((Element)v.get(369)).setAttribute("height","8" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */

      /* Empieza nodo:370 / Elemento padre: 359   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(370)).setAttribute("width","100%" );
      ((Element)v.get(359)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(371)).setAttribute("src","b.gif" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */
      /* Termina nodo:370   */
      /* Termina nodo:359   */
      /* Termina nodo:358   */
      /* Termina nodo:357   */
      /* Termina nodo:354   */

      /* Empieza nodo:372 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(372)).setAttribute("nombre","formGapTr11" );
      ((Element)v.get(52)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(373)).setAttribute("align","center" );
      ((Element)v.get(373)).setAttribute("width","8" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(374)).setAttribute("src","b.gif" );
      ((Element)v.get(374)).setAttribute("width","12" );
      ((Element)v.get(374)).setAttribute("height","8" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */
      /* Termina nodo:373   */

      /* Empieza nodo:375 / Elemento padre: 372   */
   }

   private void getXML1710(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(372)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(376)).setAttribute("src","b.gif" );
      ((Element)v.get(376)).setAttribute("width","8" );
      ((Element)v.get(376)).setAttribute("height","8" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */
      /* Termina nodo:375   */

      /* Empieza nodo:377 / Elemento padre: 372   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(377)).setAttribute("align","center" );
      ((Element)v.get(377)).setAttribute("width","8" );
      ((Element)v.get(372)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(378)).setAttribute("src","b.gif" );
      ((Element)v.get(378)).setAttribute("width","12" );
      ((Element)v.get(378)).setAttribute("height","8" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:377   */
      /* Termina nodo:372   */

      /* Empieza nodo:379 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(379)).setAttribute("nombre","formTr12" );
      ((Element)v.get(52)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(380)).setAttribute("align","center" );
      ((Element)v.get(380)).setAttribute("width","8" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(381)).setAttribute("src","b.gif" );
      ((Element)v.get(381)).setAttribute("width","8" );
      ((Element)v.get(381)).setAttribute("height","12" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */
      /* Termina nodo:380   */

      /* Empieza nodo:382 / Elemento padre: 379   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(382)).setAttribute("width","100%" );
      ((Element)v.get(379)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(383)).setAttribute("width","100%" );
      ((Element)v.get(383)).setAttribute("border","0" );
      ((Element)v.get(383)).setAttribute("cellspacing","0" );
      ((Element)v.get(383)).setAttribute("cellpadding","0" );
      ((Element)v.get(383)).setAttribute("align","left" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(384)).setAttribute("align","left" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(385)).setAttribute("nombre","valUsuaTdId" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(386)).setAttribute("width","100%" );
      ((Element)v.get(386)).setAttribute("border","0" );
      ((Element)v.get(386)).setAttribute("cellspacing","0" );
      ((Element)v.get(386)).setAttribute("cellpadding","0" );
      ((Element)v.get(386)).setAttribute("align","left" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(386)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(388)).setAttribute("valign","top" );
      ((Element)v.get(388)).setAttribute("height","13" );
      ((Element)v.get(387)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(389)).setAttribute("nombre","lblValUsua" );
      ((Element)v.get(389)).setAttribute("alto","13" );
      ((Element)v.get(389)).setAttribute("filas","1" );
      ((Element)v.get(389)).setAttribute("id","datosTitle" );
      ((Element)v.get(389)).setAttribute("cod","BelParamBelce.valUsua.label" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:388   */
      /* Termina nodo:387   */

      /* Empieza nodo:390 / Elemento padre: 386   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(390)).setAttribute("nombre","valUsuaWidgetTrId" );
      ((Element)v.get(386)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(391)).setAttribute("align","left" );
      ((Element)v.get(391)).setAttribute("nowrap","true" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(392)).setAttribute("nombre","valUsua" );
      ((Element)v.get(392)).setAttribute("id","datosCampos" );
      ((Element)v.get(392)).setAttribute("trim","S" );
      ((Element)v.get(392)).setAttribute("max","20" );
      ((Element)v.get(392)).setAttribute("onchange","" );
      ((Element)v.get(392)).setAttribute("req","N" );
      ((Element)v.get(392)).setAttribute("size","20" );
      ((Element)v.get(392)).setAttribute("valor","" );
      ((Element)v.get(392)).setAttribute("validacion","" );
      ((Element)v.get(392)).setAttribute("disabled","" );
      ((Element)v.get(392)).setAttribute("onblur","" );
      ((Element)v.get(392)).setAttribute("ontab","ejecutarAccionFoco('belParamBelceFrm',13, true)" );
      ((Element)v.get(392)).setAttribute("onshtab","ejecutarAccionFoco('belParamBelceFrm', 13, false)" );
      ((Element)v.get(391)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */
      /* Termina nodo:391   */
      /* Termina nodo:390   */
      /* Termina nodo:386   */
      /* Termina nodo:385   */

      /* Empieza nodo:393 / Elemento padre: 384   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(393)).setAttribute("nombre","valUsuaGapTdId" );
      ((Element)v.get(393)).setAttribute("nowrap","true" );
      ((Element)v.get(393)).setAttribute("class","datosCampos" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(384)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(394)).setAttribute("src","b.gif" );
      ((Element)v.get(394)).setAttribute("width","25" );
      ((Element)v.get(394)).setAttribute("height","8" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */
      /* Termina nodo:393   */

      /* Empieza nodo:395 / Elemento padre: 384   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(395)).setAttribute("width","100%" );
      ((Element)v.get(384)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(396)).setAttribute("src","b.gif" );
      ((Element)v.get(395)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */
      /* Termina nodo:395   */
      /* Termina nodo:384   */
      /* Termina nodo:383   */
      /* Termina nodo:382   */
      /* Termina nodo:379   */

      /* Empieza nodo:397 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(397)).setAttribute("nombre","formGapTr12" );
      ((Element)v.get(52)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(398)).setAttribute("align","center" );
      ((Element)v.get(398)).setAttribute("width","8" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(399)).setAttribute("src","b.gif" );
      ((Element)v.get(399)).setAttribute("width","12" );
      ((Element)v.get(399)).setAttribute("height","8" );
      ((Element)v.get(398)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */
      /* Termina nodo:398   */

      /* Empieza nodo:400 / Elemento padre: 397   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(397)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(401)).setAttribute("src","b.gif" );
      ((Element)v.get(401)).setAttribute("width","8" );
      ((Element)v.get(401)).setAttribute("height","8" );
      ((Element)v.get(400)).appendChild((Element)v.get(401));
      /* Termina nodo:401   */
      /* Termina nodo:400   */

      /* Empieza nodo:402 / Elemento padre: 397   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(402)).setAttribute("align","center" );
      ((Element)v.get(402)).setAttribute("width","8" );
      ((Element)v.get(397)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(403)).setAttribute("src","b.gif" );
      ((Element)v.get(403)).setAttribute("width","12" );
      ((Element)v.get(403)).setAttribute("height","8" );
      ((Element)v.get(402)).appendChild((Element)v.get(403));
      /* Termina nodo:403   */
      /* Termina nodo:402   */
      /* Termina nodo:397   */

      /* Empieza nodo:404 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(404)).setAttribute("nombre","formTr13" );
      ((Element)v.get(52)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(405)).setAttribute("align","center" );
      ((Element)v.get(405)).setAttribute("width","8" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(406)).setAttribute("src","b.gif" );
      ((Element)v.get(406)).setAttribute("width","8" );
      ((Element)v.get(406)).setAttribute("height","12" );
      ((Element)v.get(405)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */
      /* Termina nodo:405   */

      /* Empieza nodo:407 / Elemento padre: 404   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(407)).setAttribute("width","100%" );
      ((Element)v.get(404)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(408)).setAttribute("width","100%" );
      ((Element)v.get(408)).setAttribute("border","0" );
      ((Element)v.get(408)).setAttribute("cellspacing","0" );
      ((Element)v.get(408)).setAttribute("cellpadding","0" );
      ((Element)v.get(408)).setAttribute("align","left" );
      ((Element)v.get(407)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(409)).setAttribute("align","left" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(410)).setAttribute("nombre","clieOidClieTdId" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(411)).setAttribute("border","0" );
      ((Element)v.get(411)).setAttribute("cellspacing","0" );
      ((Element)v.get(411)).setAttribute("cellpadding","0" );
      ((Element)v.get(411)).setAttribute("align","left" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(411)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(413)).setAttribute("valign","top" );
      ((Element)v.get(413)).setAttribute("height","13" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(414)).setAttribute("nombre","lblclieOidClie" );
      ((Element)v.get(414)).setAttribute("id","datosTitle" );
      ((Element)v.get(414)).setAttribute("ancho","150" );
      ((Element)v.get(414)).setAttribute("alto","13" );
      ((Element)v.get(414)).setAttribute("cod","BelParamBelce.clieOidClie.label" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */
      /* Termina nodo:413   */
      /* Termina nodo:412   */

      /* Empieza nodo:415 / Elemento padre: 411   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(415)).setAttribute("nombre","clieOidClieWidgetTrId" );
      ((Element)v.get(411)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
   }

   private void getXML1890(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(416)).setAttribute("align","left" );
      ((Element)v.get(416)).setAttribute("nowrap","true" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));

      /* Empieza nodo:417 / Elemento padre: 416   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(417)).setAttribute("nombre","clieOidClie" );
      ((Element)v.get(417)).setAttribute("id","datosCampos" );
      ((Element)v.get(417)).setAttribute("multiple","N" );
      ((Element)v.get(417)).setAttribute("req","N" );
      ((Element)v.get(417)).setAttribute("size","1" );
      ((Element)v.get(417)).setAttribute("disabled","" );
      ((Element)v.get(417)).setAttribute("validacion","" );
      ((Element)v.get(417)).setAttribute("onchange","" );
      ((Element)v.get(417)).setAttribute("onfocus","" );
      ((Element)v.get(417)).setAttribute("valorinicial","" );
      ((Element)v.get(417)).setAttribute("textoinicial","" );
      ((Element)v.get(417)).setAttribute("ontab","ejecutarAccionFoco('belParamBelceFrm',14, true);" );
      ((Element)v.get(417)).setAttribute("onshtab","ejecutarAccionFoco('belParamBelceFrm',14, false);" );
      ((Element)v.get(416)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(417)).appendChild((Element)v.get(418));
      /* Termina nodo:418   */
      /* Termina nodo:417   */
      /* Termina nodo:416   */
      /* Termina nodo:415   */
      /* Termina nodo:411   */
      /* Termina nodo:410   */

      /* Empieza nodo:419 / Elemento padre: 409   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(419)).setAttribute("nombre","clieOidClieGapTdId" );
      ((Element)v.get(419)).setAttribute("nowrap","true" );
      ((Element)v.get(419)).setAttribute("class","datosCampos" );
      ((Element)v.get(409)).appendChild((Element)v.get(419));

      /* Empieza nodo:420 / Elemento padre: 419   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(420)).setAttribute("src","b.gif" );
      ((Element)v.get(420)).setAttribute("width","25" );
      ((Element)v.get(420)).setAttribute("height","8" );
      ((Element)v.get(419)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */
      /* Termina nodo:419   */

      /* Empieza nodo:421 / Elemento padre: 409   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(421)).setAttribute("width","100%" );
      ((Element)v.get(409)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(422)).setAttribute("src","b.gif" );
      ((Element)v.get(421)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */
      /* Termina nodo:421   */
      /* Termina nodo:409   */
      /* Termina nodo:408   */
      /* Termina nodo:407   */
      /* Termina nodo:404   */

      /* Empieza nodo:423 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(423)).setAttribute("nombre","formGapTr13" );
      ((Element)v.get(52)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(424)).setAttribute("align","center" );
      ((Element)v.get(424)).setAttribute("width","8" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(425)).setAttribute("src","b.gif" );
      ((Element)v.get(425)).setAttribute("width","12" );
      ((Element)v.get(425)).setAttribute("height","8" );
      ((Element)v.get(424)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */
      /* Termina nodo:424   */

      /* Empieza nodo:426 / Elemento padre: 423   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(423)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(427)).setAttribute("src","b.gif" );
      ((Element)v.get(427)).setAttribute("width","8" );
      ((Element)v.get(427)).setAttribute("height","8" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */
      /* Termina nodo:426   */

      /* Empieza nodo:428 / Elemento padre: 423   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(428)).setAttribute("align","center" );
      ((Element)v.get(428)).setAttribute("width","8" );
      ((Element)v.get(423)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(429)).setAttribute("src","b.gif" );
      ((Element)v.get(429)).setAttribute("width","12" );
      ((Element)v.get(429)).setAttribute("height","8" );
      ((Element)v.get(428)).appendChild((Element)v.get(429));
      /* Termina nodo:429   */
      /* Termina nodo:428   */
      /* Termina nodo:423   */

      /* Empieza nodo:430 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(430)).setAttribute("nombre","formTr14" );
      ((Element)v.get(52)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(431)).setAttribute("align","center" );
      ((Element)v.get(431)).setAttribute("width","8" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(432)).setAttribute("src","b.gif" );
      ((Element)v.get(432)).setAttribute("width","8" );
      ((Element)v.get(432)).setAttribute("height","12" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));
      /* Termina nodo:432   */
      /* Termina nodo:431   */

      /* Empieza nodo:433 / Elemento padre: 430   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(433)).setAttribute("width","100%" );
      ((Element)v.get(430)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(434)).setAttribute("width","100%" );
      ((Element)v.get(434)).setAttribute("border","0" );
      ((Element)v.get(434)).setAttribute("cellspacing","0" );
      ((Element)v.get(434)).setAttribute("cellpadding","0" );
      ((Element)v.get(434)).setAttribute("align","left" );
      ((Element)v.get(433)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(435)).setAttribute("align","left" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
   }

   private void getXML1980(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(436)).setAttribute("nombre","sociOidSociTdId" );
      ((Element)v.get(435)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(437)).setAttribute("border","0" );
      ((Element)v.get(437)).setAttribute("cellspacing","0" );
      ((Element)v.get(437)).setAttribute("cellpadding","0" );
      ((Element)v.get(437)).setAttribute("align","left" );
      ((Element)v.get(436)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(437)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(439)).setAttribute("valign","top" );
      ((Element)v.get(439)).setAttribute("height","13" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(440)).setAttribute("nombre","lblsociOidSoci" );
      ((Element)v.get(440)).setAttribute("id","datosTitle" );
      ((Element)v.get(440)).setAttribute("ancho","150" );
      ((Element)v.get(440)).setAttribute("alto","13" );
      ((Element)v.get(440)).setAttribute("cod","BelParamBelce.sociOidSoci.label" );
      ((Element)v.get(439)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */
      /* Termina nodo:439   */
      /* Termina nodo:438   */

      /* Empieza nodo:441 / Elemento padre: 437   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(441)).setAttribute("nombre","sociOidSociWidgetTrId" );
      ((Element)v.get(437)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(442)).setAttribute("align","left" );
      ((Element)v.get(442)).setAttribute("nowrap","true" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));

      /* Empieza nodo:443 / Elemento padre: 442   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(443)).setAttribute("nombre","sociOidSoci" );
      ((Element)v.get(443)).setAttribute("id","datosCampos" );
      ((Element)v.get(443)).setAttribute("multiple","N" );
      ((Element)v.get(443)).setAttribute("req","N" );
      ((Element)v.get(443)).setAttribute("size","1" );
      ((Element)v.get(443)).setAttribute("disabled","" );
      ((Element)v.get(443)).setAttribute("validacion","" );
      ((Element)v.get(443)).setAttribute("onchange","" );
      ((Element)v.get(443)).setAttribute("onfocus","" );
      ((Element)v.get(443)).setAttribute("valorinicial","" );
      ((Element)v.get(443)).setAttribute("textoinicial","" );
      ((Element)v.get(443)).setAttribute("ontab","ejecutarAccionFoco('belParamBelceFrm',15, true);" );
      ((Element)v.get(443)).setAttribute("onshtab","ejecutarAccionFoco('belParamBelceFrm',15, false);" );
      ((Element)v.get(442)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(443)).appendChild((Element)v.get(444));
      /* Termina nodo:444   */
      /* Termina nodo:443   */
      /* Termina nodo:442   */
      /* Termina nodo:441   */
      /* Termina nodo:437   */
      /* Termina nodo:436   */

      /* Empieza nodo:445 / Elemento padre: 435   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(445)).setAttribute("nombre","sociOidSociGapTdId" );
      ((Element)v.get(445)).setAttribute("nowrap","true" );
      ((Element)v.get(445)).setAttribute("class","datosCampos" );
      ((Element)v.get(435)).appendChild((Element)v.get(445));

      /* Empieza nodo:446 / Elemento padre: 445   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(446)).setAttribute("src","b.gif" );
      ((Element)v.get(446)).setAttribute("width","25" );
      ((Element)v.get(446)).setAttribute("height","8" );
      ((Element)v.get(445)).appendChild((Element)v.get(446));
      /* Termina nodo:446   */
      /* Termina nodo:445   */

      /* Empieza nodo:447 / Elemento padre: 435   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(447)).setAttribute("width","100%" );
      ((Element)v.get(435)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(448)).setAttribute("src","b.gif" );
      ((Element)v.get(447)).appendChild((Element)v.get(448));
      /* Termina nodo:448   */
      /* Termina nodo:447   */
      /* Termina nodo:435   */
      /* Termina nodo:434   */
      /* Termina nodo:433   */
      /* Termina nodo:430   */

      /* Empieza nodo:449 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(449)).setAttribute("nombre","formGapTr14" );
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
   }

   private void getXML2070(Document doc) {
      v.add(doc.createElement("TR"));
      ((Element)v.get(456)).setAttribute("nombre","formTr15" );
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
      ((Element)v.get(462)).setAttribute("nombre","ttraOidTipoTranTdId" );
      ((Element)v.get(461)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("TABLE"));
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
      ((Element)v.get(466)).setAttribute("nombre","lblttraOidTipoTran" );
      ((Element)v.get(466)).setAttribute("id","datosTitle" );
      ((Element)v.get(466)).setAttribute("ancho","150" );
      ((Element)v.get(466)).setAttribute("alto","13" );
      ((Element)v.get(466)).setAttribute("cod","BelParamBelce.ttraOidTipoTran.label" );
      ((Element)v.get(465)).appendChild((Element)v.get(466));
      /* Termina nodo:466   */
      /* Termina nodo:465   */
      /* Termina nodo:464   */

      /* Empieza nodo:467 / Elemento padre: 463   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(467)).setAttribute("nombre","ttraOidTipoTranWidgetTrId" );
      ((Element)v.get(463)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(468)).setAttribute("align","left" );
      ((Element)v.get(468)).setAttribute("nowrap","true" );
      ((Element)v.get(467)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(469)).setAttribute("nombre","ttraOidTipoTran" );
      ((Element)v.get(469)).setAttribute("id","datosCampos" );
      ((Element)v.get(469)).setAttribute("multiple","N" );
      ((Element)v.get(469)).setAttribute("req","N" );
      ((Element)v.get(469)).setAttribute("size","1" );
      ((Element)v.get(469)).setAttribute("disabled","" );
      ((Element)v.get(469)).setAttribute("validacion","" );
      ((Element)v.get(469)).setAttribute("onchange","" );
      ((Element)v.get(469)).setAttribute("onfocus","" );
      ((Element)v.get(469)).setAttribute("valorinicial","" );
      ((Element)v.get(469)).setAttribute("textoinicial","" );
      ((Element)v.get(469)).setAttribute("ontab","ejecutarAccionFoco('belParamBelceFrm',16, true);" );
      ((Element)v.get(469)).setAttribute("onshtab","ejecutarAccionFoco('belParamBelceFrm',16, false);" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));

      /* Empieza nodo:470 / Elemento padre: 469   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(469)).appendChild((Element)v.get(470));
      /* Termina nodo:470   */
      /* Termina nodo:469   */
      /* Termina nodo:468   */
      /* Termina nodo:467   */
      /* Termina nodo:463   */
      /* Termina nodo:462   */

      /* Empieza nodo:471 / Elemento padre: 461   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(471)).setAttribute("nombre","ttraOidTipoTranGapTdId" );
      ((Element)v.get(471)).setAttribute("nowrap","true" );
      ((Element)v.get(471)).setAttribute("class","datosCampos" );
      ((Element)v.get(461)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(472)).setAttribute("src","b.gif" );
      ((Element)v.get(472)).setAttribute("width","25" );
      ((Element)v.get(472)).setAttribute("height","8" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));
      /* Termina nodo:472   */
      /* Termina nodo:471   */

      /* Empieza nodo:473 / Elemento padre: 461   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(473)).setAttribute("width","100%" );
      ((Element)v.get(461)).appendChild((Element)v.get(473));

      /* Empieza nodo:474 / Elemento padre: 473   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(474)).setAttribute("src","b.gif" );
      ((Element)v.get(473)).appendChild((Element)v.get(474));
      /* Termina nodo:474   */
      /* Termina nodo:473   */
      /* Termina nodo:461   */
      /* Termina nodo:460   */
      /* Termina nodo:459   */
      /* Termina nodo:456   */

      /* Empieza nodo:475 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(475)).setAttribute("nombre","formGapTr15" );
      ((Element)v.get(52)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
   }

   private void getXML2160(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(476)).setAttribute("align","center" );
      ((Element)v.get(476)).setAttribute("width","8" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));

      /* Empieza nodo:477 / Elemento padre: 476   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(477)).setAttribute("src","b.gif" );
      ((Element)v.get(477)).setAttribute("width","12" );
      ((Element)v.get(477)).setAttribute("height","8" );
      ((Element)v.get(476)).appendChild((Element)v.get(477));
      /* Termina nodo:477   */
      /* Termina nodo:476   */

      /* Empieza nodo:478 / Elemento padre: 475   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(475)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(479)).setAttribute("src","b.gif" );
      ((Element)v.get(479)).setAttribute("width","8" );
      ((Element)v.get(479)).setAttribute("height","8" );
      ((Element)v.get(478)).appendChild((Element)v.get(479));
      /* Termina nodo:479   */
      /* Termina nodo:478   */

      /* Empieza nodo:480 / Elemento padre: 475   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(480)).setAttribute("align","center" );
      ((Element)v.get(480)).setAttribute("width","8" );
      ((Element)v.get(475)).appendChild((Element)v.get(480));

      /* Empieza nodo:481 / Elemento padre: 480   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(481)).setAttribute("src","b.gif" );
      ((Element)v.get(481)).setAttribute("width","12" );
      ((Element)v.get(481)).setAttribute("height","8" );
      ((Element)v.get(480)).appendChild((Element)v.get(481));
      /* Termina nodo:481   */
      /* Termina nodo:480   */
      /* Termina nodo:475   */

      /* Empieza nodo:482 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(482)).setAttribute("nombre","formTr16" );
      ((Element)v.get(52)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(483)).setAttribute("align","center" );
      ((Element)v.get(483)).setAttribute("width","8" );
      ((Element)v.get(482)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(484)).setAttribute("src","b.gif" );
      ((Element)v.get(484)).setAttribute("width","8" );
      ((Element)v.get(484)).setAttribute("height","12" );
      ((Element)v.get(483)).appendChild((Element)v.get(484));
      /* Termina nodo:484   */
      /* Termina nodo:483   */

      /* Empieza nodo:485 / Elemento padre: 482   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(485)).setAttribute("width","100%" );
      ((Element)v.get(482)).appendChild((Element)v.get(485));

      /* Empieza nodo:486 / Elemento padre: 485   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(486)).setAttribute("width","100%" );
      ((Element)v.get(486)).setAttribute("border","0" );
      ((Element)v.get(486)).setAttribute("cellspacing","0" );
      ((Element)v.get(486)).setAttribute("cellpadding","0" );
      ((Element)v.get(486)).setAttribute("align","left" );
      ((Element)v.get(485)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(487)).setAttribute("align","left" );
      ((Element)v.get(486)).appendChild((Element)v.get(487));

      /* Empieza nodo:488 / Elemento padre: 487   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(488)).setAttribute("nombre","ccbaOidCuenCorrBanc_cucoOidCcPnteTdId" );
      ((Element)v.get(487)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(489)).setAttribute("border","0" );
      ((Element)v.get(489)).setAttribute("cellspacing","0" );
      ((Element)v.get(489)).setAttribute("cellpadding","0" );
      ((Element)v.get(489)).setAttribute("align","left" );
      ((Element)v.get(488)).appendChild((Element)v.get(489));

      /* Empieza nodo:490 / Elemento padre: 489   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(489)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(491)).setAttribute("valign","top" );
      ((Element)v.get(491)).setAttribute("height","13" );
      ((Element)v.get(490)).appendChild((Element)v.get(491));

      /* Empieza nodo:492 / Elemento padre: 491   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(492)).setAttribute("nombre","lblccbaOidCuenCorrBanc_cucoOidCcPnte" );
      ((Element)v.get(492)).setAttribute("id","datosTitle" );
      ((Element)v.get(492)).setAttribute("ancho","150" );
      ((Element)v.get(492)).setAttribute("alto","13" );
      ((Element)v.get(492)).setAttribute("cod","CccCuentCorriBanca.cucoOidCcPnte.label" );
      ((Element)v.get(491)).appendChild((Element)v.get(492));
      /* Termina nodo:492   */
      /* Termina nodo:491   */
      /* Termina nodo:490   */

      /* Empieza nodo:493 / Elemento padre: 489   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(493)).setAttribute("nombre","ccbaOidCuenCorrBanc_cucoOidCcPnteWidgetTrId" );
      ((Element)v.get(489)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(494)).setAttribute("align","left" );
      ((Element)v.get(494)).setAttribute("nowrap","true" );
      ((Element)v.get(493)).appendChild((Element)v.get(494));

      /* Empieza nodo:495 / Elemento padre: 494   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(495)).setAttribute("nombre","ccbaOidCuenCorrBanc_cucoOidCcPnte" );
      ((Element)v.get(495)).setAttribute("id","datosCampos" );
      ((Element)v.get(495)).setAttribute("multiple","N" );
      ((Element)v.get(495)).setAttribute("req","N" );
      ((Element)v.get(495)).setAttribute("size","1" );
      ((Element)v.get(495)).setAttribute("disabled","" );
      ((Element)v.get(495)).setAttribute("validacion","" );
      ((Element)v.get(495)).setAttribute("onchange","mmgDependeneChange('ccbaOidCuenCorrBanc_cucoOidCcPnte', 'ccbaOidCuenCorrBanc' , 'belParamBelce')" );
      ((Element)v.get(495)).setAttribute("onfocus","" );
      ((Element)v.get(495)).setAttribute("valorinicial","" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(495)).setAttribute("textoinicial","" );
      ((Element)v.get(495)).setAttribute("ontab","focaliza('belParamBelceFrm.ccbaOidCuenCorrBanc_sucuOidSucu');" );
      ((Element)v.get(495)).setAttribute("onshtab","ejecutarAccionFoco('belParamBelceFrm',17, false);" );
      ((Element)v.get(494)).appendChild((Element)v.get(495));

      /* Empieza nodo:496 / Elemento padre: 495   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(495)).appendChild((Element)v.get(496));
      /* Termina nodo:496   */
      /* Termina nodo:495   */
      /* Termina nodo:494   */
      /* Termina nodo:493   */
      /* Termina nodo:489   */
      /* Termina nodo:488   */

      /* Empieza nodo:497 / Elemento padre: 487   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(497)).setAttribute("nombre","ccbaOidCuenCorrBanc_cucoOidCcPnteGapTdId" );
      ((Element)v.get(497)).setAttribute("nowrap","true" );
      ((Element)v.get(497)).setAttribute("class","datosCampos" );
      ((Element)v.get(487)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(498)).setAttribute("src","b.gif" );
      ((Element)v.get(498)).setAttribute("width","25" );
      ((Element)v.get(498)).setAttribute("height","8" );
      ((Element)v.get(497)).appendChild((Element)v.get(498));
      /* Termina nodo:498   */
      /* Termina nodo:497   */

      /* Empieza nodo:499 / Elemento padre: 487   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(499)).setAttribute("nombre","ccbaOidCuenCorrBanc_sucuOidSucu_cbanOidBancTdId" );
      ((Element)v.get(487)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(500)).setAttribute("border","0" );
      ((Element)v.get(500)).setAttribute("cellspacing","0" );
      ((Element)v.get(500)).setAttribute("cellpadding","0" );
      ((Element)v.get(500)).setAttribute("align","left" );
      ((Element)v.get(499)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(500)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(502)).setAttribute("valign","top" );
      ((Element)v.get(502)).setAttribute("height","13" );
      ((Element)v.get(501)).appendChild((Element)v.get(502));

      /* Empieza nodo:503 / Elemento padre: 502   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(503)).setAttribute("nombre","lblccbaOidCuenCorrBanc_sucuOidSucu_cbanOidBanc" );
      ((Element)v.get(503)).setAttribute("id","datosTitle" );
      ((Element)v.get(503)).setAttribute("ancho","150" );
      ((Element)v.get(503)).setAttribute("alto","13" );
      ((Element)v.get(503)).setAttribute("cod","CccSucur.cbanOidBanc.label" );
      ((Element)v.get(502)).appendChild((Element)v.get(503));
      /* Termina nodo:503   */
      /* Termina nodo:502   */
      /* Termina nodo:501   */

      /* Empieza nodo:504 / Elemento padre: 500   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(504)).setAttribute("nombre","ccbaOidCuenCorrBanc_sucuOidSucu_cbanOidBancWidgetTrId" );
      ((Element)v.get(500)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(505)).setAttribute("align","left" );
      ((Element)v.get(505)).setAttribute("nowrap","true" );
      ((Element)v.get(504)).appendChild((Element)v.get(505));

      /* Empieza nodo:506 / Elemento padre: 505   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(506)).setAttribute("nombre","ccbaOidCuenCorrBanc_sucuOidSucu_cbanOidBanc" );
      ((Element)v.get(506)).setAttribute("id","datosCampos" );
      ((Element)v.get(506)).setAttribute("multiple","N" );
      ((Element)v.get(506)).setAttribute("req","N" );
      ((Element)v.get(506)).setAttribute("size","1" );
      ((Element)v.get(506)).setAttribute("disabled","" );
      ((Element)v.get(506)).setAttribute("validacion","" );
      ((Element)v.get(506)).setAttribute("onchange","mmgDependeneChange('ccbaOidCuenCorrBanc_sucuOidSucu_cbanOidBanc', 'ccbaOidCuenCorrBanc' , 'belParamBelce')" );
      ((Element)v.get(506)).setAttribute("onfocus","" );
      ((Element)v.get(506)).setAttribute("valorinicial","" );
      ((Element)v.get(506)).setAttribute("textoinicial","" );
      ((Element)v.get(506)).setAttribute("ontab","focaliza('belParamBelceFrm.ccbaOidCuenCorrBanc_sucuOidSucu');" );
      ((Element)v.get(506)).setAttribute("onshtab","ejecutarAccionFoco('belParamBelceFrm',17, false);" );
      ((Element)v.get(505)).appendChild((Element)v.get(506));

      /* Empieza nodo:507 / Elemento padre: 506   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(506)).appendChild((Element)v.get(507));
      /* Termina nodo:507   */
      /* Termina nodo:506   */
      /* Termina nodo:505   */
      /* Termina nodo:504   */
      /* Termina nodo:500   */
      /* Termina nodo:499   */

      /* Empieza nodo:508 / Elemento padre: 487   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(508)).setAttribute("nombre","ccbaOidCuenCorrBanc_sucuOidSucu_cbanOidBancGapTdId" );
      ((Element)v.get(508)).setAttribute("nowrap","true" );
      ((Element)v.get(508)).setAttribute("class","datosCampos" );
      ((Element)v.get(487)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(509)).setAttribute("src","b.gif" );
      ((Element)v.get(509)).setAttribute("width","25" );
      ((Element)v.get(509)).setAttribute("height","8" );
      ((Element)v.get(508)).appendChild((Element)v.get(509));
      /* Termina nodo:509   */
      /* Termina nodo:508   */

      /* Empieza nodo:510 / Elemento padre: 487   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(510)).setAttribute("nombre","ccbaOidCuenCorrBanc_sucuOidSucuTdId" );
      ((Element)v.get(487)).appendChild((Element)v.get(510));

      /* Empieza nodo:511 / Elemento padre: 510   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(511)).setAttribute("border","0" );
      ((Element)v.get(511)).setAttribute("cellspacing","0" );
      ((Element)v.get(511)).setAttribute("cellpadding","0" );
      ((Element)v.get(511)).setAttribute("align","left" );
      ((Element)v.get(510)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(511)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(513)).setAttribute("valign","top" );
      ((Element)v.get(513)).setAttribute("height","13" );
      ((Element)v.get(512)).appendChild((Element)v.get(513));

      /* Empieza nodo:514 / Elemento padre: 513   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(514)).setAttribute("nombre","lblccbaOidCuenCorrBanc_sucuOidSucu" );
      ((Element)v.get(514)).setAttribute("id","datosTitle" );
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(514)).setAttribute("ancho","150" );
      ((Element)v.get(514)).setAttribute("alto","13" );
      ((Element)v.get(514)).setAttribute("cod","CccCuentCorriBanca.sucuOidSucu.label" );
      ((Element)v.get(513)).appendChild((Element)v.get(514));
      /* Termina nodo:514   */
      /* Termina nodo:513   */
      /* Termina nodo:512   */

      /* Empieza nodo:515 / Elemento padre: 511   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(515)).setAttribute("nombre","ccbaOidCuenCorrBanc_sucuOidSucuWidgetTrId" );
      ((Element)v.get(511)).appendChild((Element)v.get(515));

      /* Empieza nodo:516 / Elemento padre: 515   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(516)).setAttribute("align","left" );
      ((Element)v.get(516)).setAttribute("nowrap","true" );
      ((Element)v.get(515)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(517)).setAttribute("nombre","ccbaOidCuenCorrBanc_sucuOidSucu" );
      ((Element)v.get(517)).setAttribute("id","datosCampos" );
      ((Element)v.get(517)).setAttribute("multiple","N" );
      ((Element)v.get(517)).setAttribute("req","N" );
      ((Element)v.get(517)).setAttribute("size","1" );
      ((Element)v.get(517)).setAttribute("disabled","" );
      ((Element)v.get(517)).setAttribute("validacion","" );
      ((Element)v.get(517)).setAttribute("onchange","mmgDependeneChange('ccbaOidCuenCorrBanc_sucuOidSucu', 'ccbaOidCuenCorrBanc' , 'belParamBelce')" );
      ((Element)v.get(517)).setAttribute("onfocus","" );
      ((Element)v.get(517)).setAttribute("valorinicial","" );
      ((Element)v.get(517)).setAttribute("textoinicial","" );
      ((Element)v.get(517)).setAttribute("ontab","focaliza('belParamBelceFrm.ccbaOidCuenCorrBanc_cucoOidCcTeso');" );
      ((Element)v.get(517)).setAttribute("onshtab","focaliza('belParamBelceFrm.ccbaOidCuenCorrBanc_sucuOidSucu_cbanOidBanc');" );
      ((Element)v.get(516)).appendChild((Element)v.get(517));

      /* Empieza nodo:518 / Elemento padre: 517   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(517)).appendChild((Element)v.get(518));
      /* Termina nodo:518   */
      /* Termina nodo:517   */
      /* Termina nodo:516   */
      /* Termina nodo:515   */
      /* Termina nodo:511   */
      /* Termina nodo:510   */

      /* Empieza nodo:519 / Elemento padre: 487   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(519)).setAttribute("nombre","ccbaOidCuenCorrBanc_sucuOidSucuGapTdId" );
      ((Element)v.get(519)).setAttribute("nowrap","true" );
      ((Element)v.get(519)).setAttribute("class","datosCampos" );
      ((Element)v.get(487)).appendChild((Element)v.get(519));

      /* Empieza nodo:520 / Elemento padre: 519   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(520)).setAttribute("src","b.gif" );
      ((Element)v.get(520)).setAttribute("width","25" );
      ((Element)v.get(520)).setAttribute("height","8" );
      ((Element)v.get(519)).appendChild((Element)v.get(520));
      /* Termina nodo:520   */
      /* Termina nodo:519   */

      /* Empieza nodo:521 / Elemento padre: 487   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(521)).setAttribute("nombre","ccbaOidCuenCorrBanc_cucoOidCcTesoTdId" );
      ((Element)v.get(487)).appendChild((Element)v.get(521));

      /* Empieza nodo:522 / Elemento padre: 521   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(522)).setAttribute("border","0" );
      ((Element)v.get(522)).setAttribute("cellspacing","0" );
      ((Element)v.get(522)).setAttribute("cellpadding","0" );
      ((Element)v.get(522)).setAttribute("align","left" );
      ((Element)v.get(521)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(522)).appendChild((Element)v.get(523));

      /* Empieza nodo:524 / Elemento padre: 523   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(524)).setAttribute("valign","top" );
      ((Element)v.get(524)).setAttribute("height","13" );
      ((Element)v.get(523)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(525)).setAttribute("nombre","lblccbaOidCuenCorrBanc_cucoOidCcTeso" );
      ((Element)v.get(525)).setAttribute("id","datosTitle" );
      ((Element)v.get(525)).setAttribute("ancho","150" );
      ((Element)v.get(525)).setAttribute("alto","13" );
      ((Element)v.get(525)).setAttribute("cod","CccCuentCorriBanca.cucoOidCcTeso.label" );
      ((Element)v.get(524)).appendChild((Element)v.get(525));
      /* Termina nodo:525   */
      /* Termina nodo:524   */
      /* Termina nodo:523   */

      /* Empieza nodo:526 / Elemento padre: 522   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(526)).setAttribute("nombre","ccbaOidCuenCorrBanc_cucoOidCcTesoWidgetTrId" );
      ((Element)v.get(522)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(527)).setAttribute("align","left" );
      ((Element)v.get(527)).setAttribute("nowrap","true" );
      ((Element)v.get(526)).appendChild((Element)v.get(527));

      /* Empieza nodo:528 / Elemento padre: 527   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(528)).setAttribute("nombre","ccbaOidCuenCorrBanc_cucoOidCcTeso" );
      ((Element)v.get(528)).setAttribute("id","datosCampos" );
      ((Element)v.get(528)).setAttribute("multiple","N" );
      ((Element)v.get(528)).setAttribute("req","N" );
      ((Element)v.get(528)).setAttribute("size","1" );
      ((Element)v.get(528)).setAttribute("disabled","" );
      ((Element)v.get(528)).setAttribute("validacion","" );
      ((Element)v.get(528)).setAttribute("onchange","mmgDependeneChange('ccbaOidCuenCorrBanc_cucoOidCcTeso', 'ccbaOidCuenCorrBanc' , 'belParamBelce')" );
      ((Element)v.get(528)).setAttribute("onfocus","" );
      ((Element)v.get(528)).setAttribute("valorinicial","" );
      ((Element)v.get(528)).setAttribute("textoinicial","" );
      ((Element)v.get(528)).setAttribute("ontab","focaliza('belParamBelceFrm.ccbaOidCuenCorrBanc_sociOidSoci');" );
      ((Element)v.get(528)).setAttribute("onshtab","ejecutarAccionFoco('belParamBelceFrm',17, false);" );
      ((Element)v.get(527)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(528)).appendChild((Element)v.get(529));
      /* Termina nodo:529   */
      /* Termina nodo:528   */
      /* Termina nodo:527   */
      /* Termina nodo:526   */
      /* Termina nodo:522   */
      /* Termina nodo:521   */

      /* Empieza nodo:530 / Elemento padre: 487   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(530)).setAttribute("nombre","ccbaOidCuenCorrBanc_cucoOidCcTesoGapTdId" );
      ((Element)v.get(530)).setAttribute("nowrap","true" );
      ((Element)v.get(530)).setAttribute("class","datosCampos" );
      ((Element)v.get(487)).appendChild((Element)v.get(530));

      /* Empieza nodo:531 / Elemento padre: 530   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(531)).setAttribute("src","b.gif" );
      ((Element)v.get(531)).setAttribute("width","25" );
      ((Element)v.get(531)).setAttribute("height","8" );
      ((Element)v.get(530)).appendChild((Element)v.get(531));
      /* Termina nodo:531   */
      /* Termina nodo:530   */

      /* Empieza nodo:532 / Elemento padre: 487   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(532)).setAttribute("nombre","ccbaOidCuenCorrBanc_sociOidSociTdId" );
      ((Element)v.get(487)).appendChild((Element)v.get(532));

      /* Empieza nodo:533 / Elemento padre: 532   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(533)).setAttribute("border","0" );
      ((Element)v.get(533)).setAttribute("cellspacing","0" );
      ((Element)v.get(533)).setAttribute("cellpadding","0" );
      ((Element)v.get(533)).setAttribute("align","left" );
      ((Element)v.get(532)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(533)).appendChild((Element)v.get(534));

      /* Empieza nodo:535 / Elemento padre: 534   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(535)).setAttribute("valign","top" );
      ((Element)v.get(535)).setAttribute("height","13" );
      ((Element)v.get(534)).appendChild((Element)v.get(535));

      /* Empieza nodo:536 / Elemento padre: 535   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(536)).setAttribute("nombre","lblccbaOidCuenCorrBanc_sociOidSoci" );
      ((Element)v.get(536)).setAttribute("id","datosTitle" );
      ((Element)v.get(536)).setAttribute("ancho","150" );
      ((Element)v.get(536)).setAttribute("alto","13" );
      ((Element)v.get(536)).setAttribute("cod","CccCuentCorriBanca.sociOidSoci.label" );
      ((Element)v.get(535)).appendChild((Element)v.get(536));
      /* Termina nodo:536   */
      /* Termina nodo:535   */
      /* Termina nodo:534   */

      /* Empieza nodo:537 / Elemento padre: 533   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(537)).setAttribute("nombre","ccbaOidCuenCorrBanc_sociOidSociWidgetTrId" );
      ((Element)v.get(533)).appendChild((Element)v.get(537));

      /* Empieza nodo:538 / Elemento padre: 537   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(538)).setAttribute("align","left" );
      ((Element)v.get(538)).setAttribute("nowrap","true" );
      ((Element)v.get(537)).appendChild((Element)v.get(538));

      /* Empieza nodo:539 / Elemento padre: 538   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(539)).setAttribute("nombre","ccbaOidCuenCorrBanc_sociOidSoci" );
      ((Element)v.get(539)).setAttribute("id","datosCampos" );
      ((Element)v.get(539)).setAttribute("multiple","N" );
      ((Element)v.get(539)).setAttribute("req","N" );
      ((Element)v.get(539)).setAttribute("size","1" );
      ((Element)v.get(539)).setAttribute("disabled","" );
      ((Element)v.get(539)).setAttribute("validacion","" );
      ((Element)v.get(539)).setAttribute("onchange","mmgDependeneChange('ccbaOidCuenCorrBanc_sociOidSoci', 'ccbaOidCuenCorrBanc' , 'belParamBelce')" );
      ((Element)v.get(539)).setAttribute("onfocus","" );
      ((Element)v.get(539)).setAttribute("valorinicial","" );
      ((Element)v.get(539)).setAttribute("textoinicial","" );
      ((Element)v.get(539)).setAttribute("ontab","focaliza('belParamBelceFrm.ccbaOidCuenCorrBanc');" );
      ((Element)v.get(539)).setAttribute("onshtab","ejecutarAccionFoco('belParamBelceFrm',17, false);" );
      ((Element)v.get(538)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(539)).appendChild((Element)v.get(540));
      /* Termina nodo:540   */
      /* Termina nodo:539   */
      /* Termina nodo:538   */
      /* Termina nodo:537   */
      /* Termina nodo:533   */
      /* Termina nodo:532   */

      /* Empieza nodo:541 / Elemento padre: 487   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(541)).setAttribute("nombre","ccbaOidCuenCorrBanc_sociOidSociGapTdId" );
      ((Element)v.get(541)).setAttribute("nowrap","true" );
      ((Element)v.get(541)).setAttribute("class","datosCampos" );
      ((Element)v.get(487)).appendChild((Element)v.get(541));

      /* Empieza nodo:542 / Elemento padre: 541   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(542)).setAttribute("src","b.gif" );
      ((Element)v.get(542)).setAttribute("width","25" );
      ((Element)v.get(542)).setAttribute("height","8" );
      ((Element)v.get(541)).appendChild((Element)v.get(542));
      /* Termina nodo:542   */
      /* Termina nodo:541   */

      /* Empieza nodo:543 / Elemento padre: 487   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(543)).setAttribute("nombre","ccbaOidCuenCorrBancTdId" );
      ((Element)v.get(487)).appendChild((Element)v.get(543));

      /* Empieza nodo:544 / Elemento padre: 543   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(544)).setAttribute("border","0" );
      ((Element)v.get(544)).setAttribute("cellspacing","0" );
      ((Element)v.get(544)).setAttribute("cellpadding","0" );
      ((Element)v.get(544)).setAttribute("align","left" );
      ((Element)v.get(543)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(544)).appendChild((Element)v.get(545));

      /* Empieza nodo:546 / Elemento padre: 545   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(546)).setAttribute("valign","top" );
      ((Element)v.get(546)).setAttribute("height","13" );
      ((Element)v.get(545)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(547)).setAttribute("nombre","lblccbaOidCuenCorrBanc" );
      ((Element)v.get(547)).setAttribute("id","datosTitle" );
      ((Element)v.get(547)).setAttribute("ancho","150" );
      ((Element)v.get(547)).setAttribute("alto","13" );
      ((Element)v.get(547)).setAttribute("cod","BelParamBelce.ccbaOidCuenCorrBanc.label" );
      ((Element)v.get(546)).appendChild((Element)v.get(547));
      /* Termina nodo:547   */
      /* Termina nodo:546   */
      /* Termina nodo:545   */

      /* Empieza nodo:548 / Elemento padre: 544   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(548)).setAttribute("nombre","ccbaOidCuenCorrBancWidgetTrId" );
      ((Element)v.get(544)).appendChild((Element)v.get(548));

      /* Empieza nodo:549 / Elemento padre: 548   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(549)).setAttribute("align","left" );
      ((Element)v.get(549)).setAttribute("nowrap","true" );
      ((Element)v.get(548)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("COMBO"));
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(550)).setAttribute("nombre","ccbaOidCuenCorrBanc" );
      ((Element)v.get(550)).setAttribute("id","datosCampos" );
      ((Element)v.get(550)).setAttribute("multiple","N" );
      ((Element)v.get(550)).setAttribute("req","N" );
      ((Element)v.get(550)).setAttribute("size","1" );
      ((Element)v.get(550)).setAttribute("disabled","" );
      ((Element)v.get(550)).setAttribute("validacion","" );
      ((Element)v.get(550)).setAttribute("onchange","" );
      ((Element)v.get(550)).setAttribute("onfocus","" );
      ((Element)v.get(550)).setAttribute("valorinicial","" );
      ((Element)v.get(550)).setAttribute("textoinicial","" );
      ((Element)v.get(550)).setAttribute("ontab","ejecutarAccionFoco('belParamBelceFrm',17, true);" );
      ((Element)v.get(550)).setAttribute("onshtab","focaliza('belParamBelceFrm.ccbaOidCuenCorrBanc_sociOidSoci');" );
      ((Element)v.get(549)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(550)).appendChild((Element)v.get(551));
      /* Termina nodo:551   */
      /* Termina nodo:550   */
      /* Termina nodo:549   */
      /* Termina nodo:548   */
      /* Termina nodo:544   */
      /* Termina nodo:543   */

      /* Empieza nodo:552 / Elemento padre: 487   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(552)).setAttribute("nombre","ccbaOidCuenCorrBancGapTdId" );
      ((Element)v.get(552)).setAttribute("nowrap","true" );
      ((Element)v.get(552)).setAttribute("class","datosCampos" );
      ((Element)v.get(487)).appendChild((Element)v.get(552));

      /* Empieza nodo:553 / Elemento padre: 552   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(553)).setAttribute("src","b.gif" );
      ((Element)v.get(553)).setAttribute("width","25" );
      ((Element)v.get(553)).setAttribute("height","8" );
      ((Element)v.get(552)).appendChild((Element)v.get(553));
      /* Termina nodo:553   */
      /* Termina nodo:552   */

      /* Empieza nodo:554 / Elemento padre: 487   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(554)).setAttribute("width","100%" );
      ((Element)v.get(487)).appendChild((Element)v.get(554));

      /* Empieza nodo:555 / Elemento padre: 554   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(555)).setAttribute("src","b.gif" );
      ((Element)v.get(554)).appendChild((Element)v.get(555));
      /* Termina nodo:555   */
      /* Termina nodo:554   */
      /* Termina nodo:487   */
      /* Termina nodo:486   */
      /* Termina nodo:485   */
      /* Termina nodo:482   */

      /* Empieza nodo:556 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(556)).setAttribute("nombre","formGapTr16" );
      ((Element)v.get(52)).appendChild((Element)v.get(556));

      /* Empieza nodo:557 / Elemento padre: 556   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(557)).setAttribute("align","center" );
      ((Element)v.get(557)).setAttribute("width","8" );
      ((Element)v.get(556)).appendChild((Element)v.get(557));

      /* Empieza nodo:558 / Elemento padre: 557   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(558)).setAttribute("src","b.gif" );
      ((Element)v.get(558)).setAttribute("width","12" );
      ((Element)v.get(558)).setAttribute("height","8" );
      ((Element)v.get(557)).appendChild((Element)v.get(558));
      /* Termina nodo:558   */
      /* Termina nodo:557   */

      /* Empieza nodo:559 / Elemento padre: 556   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(556)).appendChild((Element)v.get(559));

      /* Empieza nodo:560 / Elemento padre: 559   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(560)).setAttribute("src","b.gif" );
      ((Element)v.get(560)).setAttribute("width","8" );
      ((Element)v.get(560)).setAttribute("height","8" );
      ((Element)v.get(559)).appendChild((Element)v.get(560));
      /* Termina nodo:560   */
      /* Termina nodo:559   */

      /* Empieza nodo:561 / Elemento padre: 556   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(561)).setAttribute("align","center" );
      ((Element)v.get(561)).setAttribute("width","8" );
      ((Element)v.get(556)).appendChild((Element)v.get(561));

      /* Empieza nodo:562 / Elemento padre: 561   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(562)).setAttribute("src","b.gif" );
      ((Element)v.get(562)).setAttribute("width","12" );
      ((Element)v.get(562)).setAttribute("height","8" );
      ((Element)v.get(561)).appendChild((Element)v.get(562));
      /* Termina nodo:562   */
      /* Termina nodo:561   */
      /* Termina nodo:556   */

      /* Empieza nodo:563 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(563)).setAttribute("nombre","formTr17" );
      ((Element)v.get(52)).appendChild((Element)v.get(563));

      /* Empieza nodo:564 / Elemento padre: 563   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(564)).setAttribute("align","center" );
      ((Element)v.get(564)).setAttribute("width","8" );
      ((Element)v.get(563)).appendChild((Element)v.get(564));

      /* Empieza nodo:565 / Elemento padre: 564   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(565)).setAttribute("src","b.gif" );
      ((Element)v.get(565)).setAttribute("width","8" );
      ((Element)v.get(565)).setAttribute("height","12" );
      ((Element)v.get(564)).appendChild((Element)v.get(565));
      /* Termina nodo:565   */
      /* Termina nodo:564   */

      /* Empieza nodo:566 / Elemento padre: 563   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(566)).setAttribute("width","100%" );
      ((Element)v.get(563)).appendChild((Element)v.get(566));

      /* Empieza nodo:567 / Elemento padre: 566   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(567)).setAttribute("width","100%" );
      ((Element)v.get(567)).setAttribute("border","0" );
      ((Element)v.get(567)).setAttribute("cellspacing","0" );
      ((Element)v.get(567)).setAttribute("cellpadding","0" );
      ((Element)v.get(567)).setAttribute("align","left" );
      ((Element)v.get(566)).appendChild((Element)v.get(567));

      /* Empieza nodo:568 / Elemento padre: 567   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(568)).setAttribute("align","left" );
      ((Element)v.get(567)).appendChild((Element)v.get(568));

      /* Empieza nodo:569 / Elemento padre: 568   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(569)).setAttribute("nombre","tmvcOidCobrTdId" );
      ((Element)v.get(568)).appendChild((Element)v.get(569));

      /* Empieza nodo:570 / Elemento padre: 569   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(570)).setAttribute("border","0" );
   }

   private void getXML2610(Document doc) {
      ((Element)v.get(570)).setAttribute("cellspacing","0" );
      ((Element)v.get(570)).setAttribute("cellpadding","0" );
      ((Element)v.get(570)).setAttribute("align","left" );
      ((Element)v.get(569)).appendChild((Element)v.get(570));

      /* Empieza nodo:571 / Elemento padre: 570   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(570)).appendChild((Element)v.get(571));

      /* Empieza nodo:572 / Elemento padre: 571   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(572)).setAttribute("valign","top" );
      ((Element)v.get(572)).setAttribute("height","13" );
      ((Element)v.get(571)).appendChild((Element)v.get(572));

      /* Empieza nodo:573 / Elemento padre: 572   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(573)).setAttribute("nombre","lbltmvcOidCobr" );
      ((Element)v.get(573)).setAttribute("id","datosTitle" );
      ((Element)v.get(573)).setAttribute("ancho","150" );
      ((Element)v.get(573)).setAttribute("alto","13" );
      ((Element)v.get(573)).setAttribute("cod","BelParamBelce.tmvcOidCobr.label" );
      ((Element)v.get(572)).appendChild((Element)v.get(573));
      /* Termina nodo:573   */
      /* Termina nodo:572   */
      /* Termina nodo:571   */

      /* Empieza nodo:574 / Elemento padre: 570   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(574)).setAttribute("nombre","tmvcOidCobrWidgetTrId" );
      ((Element)v.get(570)).appendChild((Element)v.get(574));

      /* Empieza nodo:575 / Elemento padre: 574   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(575)).setAttribute("align","left" );
      ((Element)v.get(575)).setAttribute("nowrap","true" );
      ((Element)v.get(574)).appendChild((Element)v.get(575));

      /* Empieza nodo:576 / Elemento padre: 575   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(576)).setAttribute("nombre","tmvcOidCobr" );
      ((Element)v.get(576)).setAttribute("id","datosCampos" );
      ((Element)v.get(576)).setAttribute("multiple","N" );
      ((Element)v.get(576)).setAttribute("req","N" );
      ((Element)v.get(576)).setAttribute("size","1" );
      ((Element)v.get(576)).setAttribute("disabled","" );
      ((Element)v.get(576)).setAttribute("validacion","" );
      ((Element)v.get(576)).setAttribute("onchange","" );
      ((Element)v.get(576)).setAttribute("onfocus","" );
      ((Element)v.get(576)).setAttribute("valorinicial","" );
      ((Element)v.get(576)).setAttribute("textoinicial","" );
      ((Element)v.get(576)).setAttribute("ontab","ejecutarAccionFoco('belParamBelceFrm',18, true);" );
      ((Element)v.get(576)).setAttribute("onshtab","ejecutarAccionFoco('belParamBelceFrm',18, false);" );
      ((Element)v.get(575)).appendChild((Element)v.get(576));

      /* Empieza nodo:577 / Elemento padre: 576   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(576)).appendChild((Element)v.get(577));
      /* Termina nodo:577   */
      /* Termina nodo:576   */
      /* Termina nodo:575   */
      /* Termina nodo:574   */
      /* Termina nodo:570   */
      /* Termina nodo:569   */

      /* Empieza nodo:578 / Elemento padre: 568   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(578)).setAttribute("nombre","tmvcOidCobrGapTdId" );
      ((Element)v.get(578)).setAttribute("nowrap","true" );
      ((Element)v.get(578)).setAttribute("class","datosCampos" );
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
      v.add(doc.createElement("TD"));
      ((Element)v.get(580)).setAttribute("width","100%" );
      ((Element)v.get(568)).appendChild((Element)v.get(580));

      /* Empieza nodo:581 / Elemento padre: 580   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(581)).setAttribute("src","b.gif" );
      ((Element)v.get(580)).appendChild((Element)v.get(581));
      /* Termina nodo:581   */
      /* Termina nodo:580   */
      /* Termina nodo:568   */
      /* Termina nodo:567   */
      /* Termina nodo:566   */
      /* Termina nodo:563   */

      /* Empieza nodo:582 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(582)).setAttribute("nombre","formGapTr17" );
      ((Element)v.get(52)).appendChild((Element)v.get(582));

      /* Empieza nodo:583 / Elemento padre: 582   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(583)).setAttribute("align","center" );
      ((Element)v.get(583)).setAttribute("width","8" );
      ((Element)v.get(582)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(584)).setAttribute("src","b.gif" );
      ((Element)v.get(584)).setAttribute("width","12" );
      ((Element)v.get(584)).setAttribute("height","8" );
      ((Element)v.get(583)).appendChild((Element)v.get(584));
      /* Termina nodo:584   */
      /* Termina nodo:583   */

      /* Empieza nodo:585 / Elemento padre: 582   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(582)).appendChild((Element)v.get(585));

      /* Empieza nodo:586 / Elemento padre: 585   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(586)).setAttribute("src","b.gif" );
      ((Element)v.get(586)).setAttribute("width","8" );
      ((Element)v.get(586)).setAttribute("height","8" );
      ((Element)v.get(585)).appendChild((Element)v.get(586));
      /* Termina nodo:586   */
      /* Termina nodo:585   */

      /* Empieza nodo:587 / Elemento padre: 582   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(587)).setAttribute("align","center" );
      ((Element)v.get(587)).setAttribute("width","8" );
      ((Element)v.get(582)).appendChild((Element)v.get(587));

      /* Empieza nodo:588 / Elemento padre: 587   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(588)).setAttribute("src","b.gif" );
      ((Element)v.get(588)).setAttribute("width","12" );
      ((Element)v.get(588)).setAttribute("height","8" );
      ((Element)v.get(587)).appendChild((Element)v.get(588));
      /* Termina nodo:588   */
      /* Termina nodo:587   */
      /* Termina nodo:582   */

      /* Empieza nodo:589 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(589)).setAttribute("nombre","formTr18" );
      ((Element)v.get(52)).appendChild((Element)v.get(589));

      /* Empieza nodo:590 / Elemento padre: 589   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(590)).setAttribute("align","center" );
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(590)).setAttribute("width","8" );
      ((Element)v.get(589)).appendChild((Element)v.get(590));

      /* Empieza nodo:591 / Elemento padre: 590   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(591)).setAttribute("src","b.gif" );
      ((Element)v.get(591)).setAttribute("width","8" );
      ((Element)v.get(591)).setAttribute("height","12" );
      ((Element)v.get(590)).appendChild((Element)v.get(591));
      /* Termina nodo:591   */
      /* Termina nodo:590   */

      /* Empieza nodo:592 / Elemento padre: 589   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(592)).setAttribute("width","100%" );
      ((Element)v.get(589)).appendChild((Element)v.get(592));

      /* Empieza nodo:593 / Elemento padre: 592   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(593)).setAttribute("width","100%" );
      ((Element)v.get(593)).setAttribute("border","0" );
      ((Element)v.get(593)).setAttribute("cellspacing","0" );
      ((Element)v.get(593)).setAttribute("cellpadding","0" );
      ((Element)v.get(593)).setAttribute("align","left" );
      ((Element)v.get(592)).appendChild((Element)v.get(593));

      /* Empieza nodo:594 / Elemento padre: 593   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(594)).setAttribute("align","left" );
      ((Element)v.get(593)).appendChild((Element)v.get(594));

      /* Empieza nodo:595 / Elemento padre: 594   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(595)).setAttribute("nombre","tmvcOidCierTdId" );
      ((Element)v.get(594)).appendChild((Element)v.get(595));

      /* Empieza nodo:596 / Elemento padre: 595   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(596)).setAttribute("border","0" );
      ((Element)v.get(596)).setAttribute("cellspacing","0" );
      ((Element)v.get(596)).setAttribute("cellpadding","0" );
      ((Element)v.get(596)).setAttribute("align","left" );
      ((Element)v.get(595)).appendChild((Element)v.get(596));

      /* Empieza nodo:597 / Elemento padre: 596   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(596)).appendChild((Element)v.get(597));

      /* Empieza nodo:598 / Elemento padre: 597   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(598)).setAttribute("valign","top" );
      ((Element)v.get(598)).setAttribute("height","13" );
      ((Element)v.get(597)).appendChild((Element)v.get(598));

      /* Empieza nodo:599 / Elemento padre: 598   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(599)).setAttribute("nombre","lbltmvcOidCier" );
      ((Element)v.get(599)).setAttribute("id","datosTitle" );
      ((Element)v.get(599)).setAttribute("ancho","150" );
      ((Element)v.get(599)).setAttribute("alto","13" );
      ((Element)v.get(599)).setAttribute("cod","BelParamBelce.tmvcOidCier.label" );
      ((Element)v.get(598)).appendChild((Element)v.get(599));
      /* Termina nodo:599   */
      /* Termina nodo:598   */
      /* Termina nodo:597   */

      /* Empieza nodo:600 / Elemento padre: 596   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(600)).setAttribute("nombre","tmvcOidCierWidgetTrId" );
      ((Element)v.get(596)).appendChild((Element)v.get(600));

      /* Empieza nodo:601 / Elemento padre: 600   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(601)).setAttribute("align","left" );
      ((Element)v.get(601)).setAttribute("nowrap","true" );
      ((Element)v.get(600)).appendChild((Element)v.get(601));

      /* Empieza nodo:602 / Elemento padre: 601   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(602)).setAttribute("nombre","tmvcOidCier" );
      ((Element)v.get(602)).setAttribute("id","datosCampos" );
      ((Element)v.get(602)).setAttribute("multiple","N" );
      ((Element)v.get(602)).setAttribute("req","N" );
      ((Element)v.get(602)).setAttribute("size","1" );
      ((Element)v.get(602)).setAttribute("disabled","" );
      ((Element)v.get(602)).setAttribute("validacion","" );
      ((Element)v.get(602)).setAttribute("onchange","" );
      ((Element)v.get(602)).setAttribute("onfocus","" );
      ((Element)v.get(602)).setAttribute("valorinicial","" );
      ((Element)v.get(602)).setAttribute("textoinicial","" );
      ((Element)v.get(602)).setAttribute("ontab","ejecutarAccionFoco('belParamBelceFrm',19, true);" );
      ((Element)v.get(602)).setAttribute("onshtab","ejecutarAccionFoco('belParamBelceFrm',19, false);" );
      ((Element)v.get(601)).appendChild((Element)v.get(602));

      /* Empieza nodo:603 / Elemento padre: 602   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(602)).appendChild((Element)v.get(603));
      /* Termina nodo:603   */
      /* Termina nodo:602   */
      /* Termina nodo:601   */
      /* Termina nodo:600   */
      /* Termina nodo:596   */
      /* Termina nodo:595   */

      /* Empieza nodo:604 / Elemento padre: 594   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(604)).setAttribute("nombre","tmvcOidCierGapTdId" );
      ((Element)v.get(604)).setAttribute("nowrap","true" );
      ((Element)v.get(604)).setAttribute("class","datosCampos" );
      ((Element)v.get(594)).appendChild((Element)v.get(604));

      /* Empieza nodo:605 / Elemento padre: 604   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(605)).setAttribute("src","b.gif" );
      ((Element)v.get(605)).setAttribute("width","25" );
      ((Element)v.get(605)).setAttribute("height","8" );
      ((Element)v.get(604)).appendChild((Element)v.get(605));
      /* Termina nodo:605   */
      /* Termina nodo:604   */

      /* Empieza nodo:606 / Elemento padre: 594   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(606)).setAttribute("width","100%" );
      ((Element)v.get(594)).appendChild((Element)v.get(606));

      /* Empieza nodo:607 / Elemento padre: 606   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(607)).setAttribute("src","b.gif" );
      ((Element)v.get(606)).appendChild((Element)v.get(607));
      /* Termina nodo:607   */
      /* Termina nodo:606   */
      /* Termina nodo:594   */
      /* Termina nodo:593   */
      /* Termina nodo:592   */
      /* Termina nodo:589   */

      /* Empieza nodo:608 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(608)).setAttribute("nombre","formGapTr18" );
      ((Element)v.get(52)).appendChild((Element)v.get(608));

      /* Empieza nodo:609 / Elemento padre: 608   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(609)).setAttribute("align","center" );
      ((Element)v.get(609)).setAttribute("width","8" );
      ((Element)v.get(608)).appendChild((Element)v.get(609));

      /* Empieza nodo:610 / Elemento padre: 609   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(610)).setAttribute("src","b.gif" );
      ((Element)v.get(610)).setAttribute("width","12" );
      ((Element)v.get(610)).setAttribute("height","8" );
      ((Element)v.get(609)).appendChild((Element)v.get(610));
      /* Termina nodo:610   */
      /* Termina nodo:609   */

      /* Empieza nodo:611 / Elemento padre: 608   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(608)).appendChild((Element)v.get(611));

      /* Empieza nodo:612 / Elemento padre: 611   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(612)).setAttribute("src","b.gif" );
      ((Element)v.get(612)).setAttribute("width","8" );
      ((Element)v.get(612)).setAttribute("height","8" );
      ((Element)v.get(611)).appendChild((Element)v.get(612));
      /* Termina nodo:612   */
      /* Termina nodo:611   */

      /* Empieza nodo:613 / Elemento padre: 608   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(613)).setAttribute("align","center" );
      ((Element)v.get(613)).setAttribute("width","8" );
      ((Element)v.get(608)).appendChild((Element)v.get(613));

      /* Empieza nodo:614 / Elemento padre: 613   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(614)).setAttribute("src","b.gif" );
      ((Element)v.get(614)).setAttribute("width","12" );
      ((Element)v.get(614)).setAttribute("height","8" );
      ((Element)v.get(613)).appendChild((Element)v.get(614));
      /* Termina nodo:614   */
      /* Termina nodo:613   */
      /* Termina nodo:608   */

      /* Empieza nodo:615 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(615)).setAttribute("nombre","formTr19" );
      ((Element)v.get(52)).appendChild((Element)v.get(615));

      /* Empieza nodo:616 / Elemento padre: 615   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(616)).setAttribute("align","center" );
      ((Element)v.get(616)).setAttribute("width","8" );
      ((Element)v.get(615)).appendChild((Element)v.get(616));

      /* Empieza nodo:617 / Elemento padre: 616   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(617)).setAttribute("src","b.gif" );
      ((Element)v.get(617)).setAttribute("width","8" );
      ((Element)v.get(617)).setAttribute("height","12" );
      ((Element)v.get(616)).appendChild((Element)v.get(617));
      /* Termina nodo:617   */
      /* Termina nodo:616   */

      /* Empieza nodo:618 / Elemento padre: 615   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(618)).setAttribute("width","100%" );
      ((Element)v.get(615)).appendChild((Element)v.get(618));

      /* Empieza nodo:619 / Elemento padre: 618   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(619)).setAttribute("width","100%" );
      ((Element)v.get(619)).setAttribute("border","0" );
      ((Element)v.get(619)).setAttribute("cellspacing","0" );
      ((Element)v.get(619)).setAttribute("cellpadding","0" );
      ((Element)v.get(619)).setAttribute("align","left" );
      ((Element)v.get(618)).appendChild((Element)v.get(619));

      /* Empieza nodo:620 / Elemento padre: 619   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(620)).setAttribute("align","left" );
      ((Element)v.get(619)).appendChild((Element)v.get(620));

      /* Empieza nodo:621 / Elemento padre: 620   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(621)).setAttribute("nombre","tmalOidConfStocTdId" );
      ((Element)v.get(620)).appendChild((Element)v.get(621));

      /* Empieza nodo:622 / Elemento padre: 621   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(622)).setAttribute("border","0" );
      ((Element)v.get(622)).setAttribute("cellspacing","0" );
      ((Element)v.get(622)).setAttribute("cellpadding","0" );
      ((Element)v.get(622)).setAttribute("align","left" );
      ((Element)v.get(621)).appendChild((Element)v.get(622));

      /* Empieza nodo:623 / Elemento padre: 622   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(622)).appendChild((Element)v.get(623));

      /* Empieza nodo:624 / Elemento padre: 623   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(624)).setAttribute("valign","top" );
      ((Element)v.get(624)).setAttribute("height","13" );
      ((Element)v.get(623)).appendChild((Element)v.get(624));

      /* Empieza nodo:625 / Elemento padre: 624   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(625)).setAttribute("nombre","lbltmalOidConfStoc" );
      ((Element)v.get(625)).setAttribute("id","datosTitle" );
      ((Element)v.get(625)).setAttribute("ancho","150" );
      ((Element)v.get(625)).setAttribute("alto","13" );
      ((Element)v.get(625)).setAttribute("cod","BelParamBelce.tmalOidConfStoc.label" );
      ((Element)v.get(624)).appendChild((Element)v.get(625));
      /* Termina nodo:625   */
      /* Termina nodo:624   */
      /* Termina nodo:623   */

      /* Empieza nodo:626 / Elemento padre: 622   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(626)).setAttribute("nombre","tmalOidConfStocWidgetTrId" );
      ((Element)v.get(622)).appendChild((Element)v.get(626));

      /* Empieza nodo:627 / Elemento padre: 626   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(627)).setAttribute("align","left" );
      ((Element)v.get(627)).setAttribute("nowrap","true" );
      ((Element)v.get(626)).appendChild((Element)v.get(627));

      /* Empieza nodo:628 / Elemento padre: 627   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(628)).setAttribute("nombre","tmalOidConfStoc" );
      ((Element)v.get(628)).setAttribute("id","datosCampos" );
      ((Element)v.get(628)).setAttribute("multiple","N" );
      ((Element)v.get(628)).setAttribute("req","N" );
      ((Element)v.get(628)).setAttribute("size","1" );
      ((Element)v.get(628)).setAttribute("disabled","" );
      ((Element)v.get(628)).setAttribute("validacion","" );
      ((Element)v.get(628)).setAttribute("onchange","" );
      ((Element)v.get(628)).setAttribute("onfocus","" );
      ((Element)v.get(628)).setAttribute("valorinicial","" );
      ((Element)v.get(628)).setAttribute("textoinicial","" );
      ((Element)v.get(628)).setAttribute("ontab","ejecutarAccionFoco('belParamBelceFrm',20, true);" );
      ((Element)v.get(628)).setAttribute("onshtab","ejecutarAccionFoco('belParamBelceFrm',20, false);" );
      ((Element)v.get(627)).appendChild((Element)v.get(628));

      /* Empieza nodo:629 / Elemento padre: 628   */
      v.add(doc.createElement("ROWSET"));
   }

   private void getXML2880(Document doc) {
      ((Element)v.get(628)).appendChild((Element)v.get(629));
      /* Termina nodo:629   */
      /* Termina nodo:628   */
      /* Termina nodo:627   */
      /* Termina nodo:626   */
      /* Termina nodo:622   */
      /* Termina nodo:621   */

      /* Empieza nodo:630 / Elemento padre: 620   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(630)).setAttribute("nombre","tmalOidConfStocGapTdId" );
      ((Element)v.get(630)).setAttribute("nowrap","true" );
      ((Element)v.get(630)).setAttribute("class","datosCampos" );
      ((Element)v.get(620)).appendChild((Element)v.get(630));

      /* Empieza nodo:631 / Elemento padre: 630   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(631)).setAttribute("src","b.gif" );
      ((Element)v.get(631)).setAttribute("width","25" );
      ((Element)v.get(631)).setAttribute("height","8" );
      ((Element)v.get(630)).appendChild((Element)v.get(631));
      /* Termina nodo:631   */
      /* Termina nodo:630   */

      /* Empieza nodo:632 / Elemento padre: 620   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(632)).setAttribute("width","100%" );
      ((Element)v.get(620)).appendChild((Element)v.get(632));

      /* Empieza nodo:633 / Elemento padre: 632   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(633)).setAttribute("src","b.gif" );
      ((Element)v.get(632)).appendChild((Element)v.get(633));
      /* Termina nodo:633   */
      /* Termina nodo:632   */
      /* Termina nodo:620   */
      /* Termina nodo:619   */
      /* Termina nodo:618   */
      /* Termina nodo:615   */

      /* Empieza nodo:634 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(634)).setAttribute("nombre","formGapTr19" );
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
      ((Element)v.get(641)).setAttribute("nombre","formTr20" );
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
      ((Element)v.get(647)).setAttribute("nombre","tmalOidConfStocTranTdId" );
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
      ((Element)v.get(651)).setAttribute("nombre","lbltmalOidConfStocTran" );
      ((Element)v.get(651)).setAttribute("id","datosTitle" );
      ((Element)v.get(651)).setAttribute("ancho","150" );
      ((Element)v.get(651)).setAttribute("alto","13" );
   }

   private void getXML2970(Document doc) {
      ((Element)v.get(651)).setAttribute("cod","BelParamBelce.tmalOidConfStocTran.label" );
      ((Element)v.get(650)).appendChild((Element)v.get(651));
      /* Termina nodo:651   */
      /* Termina nodo:650   */
      /* Termina nodo:649   */

      /* Empieza nodo:652 / Elemento padre: 648   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(652)).setAttribute("nombre","tmalOidConfStocTranWidgetTrId" );
      ((Element)v.get(648)).appendChild((Element)v.get(652));

      /* Empieza nodo:653 / Elemento padre: 652   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(653)).setAttribute("align","left" );
      ((Element)v.get(653)).setAttribute("nowrap","true" );
      ((Element)v.get(652)).appendChild((Element)v.get(653));

      /* Empieza nodo:654 / Elemento padre: 653   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(654)).setAttribute("nombre","tmalOidConfStocTran" );
      ((Element)v.get(654)).setAttribute("id","datosCampos" );
      ((Element)v.get(654)).setAttribute("multiple","N" );
      ((Element)v.get(654)).setAttribute("req","N" );
      ((Element)v.get(654)).setAttribute("size","1" );
      ((Element)v.get(654)).setAttribute("disabled","" );
      ((Element)v.get(654)).setAttribute("validacion","" );
      ((Element)v.get(654)).setAttribute("onchange","" );
      ((Element)v.get(654)).setAttribute("onfocus","" );
      ((Element)v.get(654)).setAttribute("valorinicial","" );
      ((Element)v.get(654)).setAttribute("textoinicial","" );
      ((Element)v.get(654)).setAttribute("ontab","ejecutarAccionFoco('belParamBelceFrm',21, true);" );
      ((Element)v.get(654)).setAttribute("onshtab","ejecutarAccionFoco('belParamBelceFrm',21, false);" );
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
      ((Element)v.get(656)).setAttribute("nombre","tmalOidConfStocTranGapTdId" );
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
      ((Element)v.get(658)).setAttribute("width","100%" );
      ((Element)v.get(646)).appendChild((Element)v.get(658));

      /* Empieza nodo:659 / Elemento padre: 658   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(659)).setAttribute("src","b.gif" );
      ((Element)v.get(658)).appendChild((Element)v.get(659));
      /* Termina nodo:659   */
      /* Termina nodo:658   */
      /* Termina nodo:646   */
      /* Termina nodo:645   */
      /* Termina nodo:644   */
      /* Termina nodo:641   */

      /* Empieza nodo:660 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(660)).setAttribute("nombre","formGapTr20" );
      ((Element)v.get(52)).appendChild((Element)v.get(660));

      /* Empieza nodo:661 / Elemento padre: 660   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(661)).setAttribute("align","center" );
      ((Element)v.get(661)).setAttribute("width","8" );
      ((Element)v.get(660)).appendChild((Element)v.get(661));

      /* Empieza nodo:662 / Elemento padre: 661   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(662)).setAttribute("src","b.gif" );
      ((Element)v.get(662)).setAttribute("width","12" );
      ((Element)v.get(662)).setAttribute("height","8" );
      ((Element)v.get(661)).appendChild((Element)v.get(662));
      /* Termina nodo:662   */
      /* Termina nodo:661   */

      /* Empieza nodo:663 / Elemento padre: 660   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(660)).appendChild((Element)v.get(663));

      /* Empieza nodo:664 / Elemento padre: 663   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(664)).setAttribute("src","b.gif" );
      ((Element)v.get(664)).setAttribute("width","8" );
      ((Element)v.get(664)).setAttribute("height","8" );
      ((Element)v.get(663)).appendChild((Element)v.get(664));
      /* Termina nodo:664   */
      /* Termina nodo:663   */

      /* Empieza nodo:665 / Elemento padre: 660   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(665)).setAttribute("align","center" );
      ((Element)v.get(665)).setAttribute("width","8" );
      ((Element)v.get(660)).appendChild((Element)v.get(665));

      /* Empieza nodo:666 / Elemento padre: 665   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(666)).setAttribute("src","b.gif" );
      ((Element)v.get(666)).setAttribute("width","12" );
      ((Element)v.get(666)).setAttribute("height","8" );
      ((Element)v.get(665)).appendChild((Element)v.get(666));
      /* Termina nodo:666   */
      /* Termina nodo:665   */
      /* Termina nodo:660   */

      /* Empieza nodo:667 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(667)).setAttribute("nombre","formTr21" );
      ((Element)v.get(52)).appendChild((Element)v.get(667));

      /* Empieza nodo:668 / Elemento padre: 667   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(668)).setAttribute("align","center" );
      ((Element)v.get(668)).setAttribute("width","8" );
      ((Element)v.get(667)).appendChild((Element)v.get(668));

      /* Empieza nodo:669 / Elemento padre: 668   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(669)).setAttribute("src","b.gif" );
      ((Element)v.get(669)).setAttribute("width","8" );
      ((Element)v.get(669)).setAttribute("height","12" );
      ((Element)v.get(668)).appendChild((Element)v.get(669));
      /* Termina nodo:669   */
      /* Termina nodo:668   */

      /* Empieza nodo:670 / Elemento padre: 667   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(670)).setAttribute("width","100%" );
      ((Element)v.get(667)).appendChild((Element)v.get(670));

      /* Empieza nodo:671 / Elemento padre: 670   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(671)).setAttribute("width","100%" );
      ((Element)v.get(671)).setAttribute("border","0" );
      ((Element)v.get(671)).setAttribute("cellspacing","0" );
      ((Element)v.get(671)).setAttribute("cellpadding","0" );
   }

   private void getXML3060(Document doc) {
      ((Element)v.get(671)).setAttribute("align","left" );
      ((Element)v.get(670)).appendChild((Element)v.get(671));

      /* Empieza nodo:672 / Elemento padre: 671   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(672)).setAttribute("align","left" );
      ((Element)v.get(671)).appendChild((Element)v.get(672));

      /* Empieza nodo:673 / Elemento padre: 672   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(673)).setAttribute("nombre","tmalOidStocTranTdId" );
      ((Element)v.get(672)).appendChild((Element)v.get(673));

      /* Empieza nodo:674 / Elemento padre: 673   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(674)).setAttribute("border","0" );
      ((Element)v.get(674)).setAttribute("cellspacing","0" );
      ((Element)v.get(674)).setAttribute("cellpadding","0" );
      ((Element)v.get(674)).setAttribute("align","left" );
      ((Element)v.get(673)).appendChild((Element)v.get(674));

      /* Empieza nodo:675 / Elemento padre: 674   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(674)).appendChild((Element)v.get(675));

      /* Empieza nodo:676 / Elemento padre: 675   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(676)).setAttribute("valign","top" );
      ((Element)v.get(676)).setAttribute("height","13" );
      ((Element)v.get(675)).appendChild((Element)v.get(676));

      /* Empieza nodo:677 / Elemento padre: 676   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(677)).setAttribute("nombre","lbltmalOidStocTran" );
      ((Element)v.get(677)).setAttribute("id","datosTitle" );
      ((Element)v.get(677)).setAttribute("ancho","150" );
      ((Element)v.get(677)).setAttribute("alto","13" );
      ((Element)v.get(677)).setAttribute("cod","BelParamBelce.tmalOidStocTran.label" );
      ((Element)v.get(676)).appendChild((Element)v.get(677));
      /* Termina nodo:677   */
      /* Termina nodo:676   */
      /* Termina nodo:675   */

      /* Empieza nodo:678 / Elemento padre: 674   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(678)).setAttribute("nombre","tmalOidStocTranWidgetTrId" );
      ((Element)v.get(674)).appendChild((Element)v.get(678));

      /* Empieza nodo:679 / Elemento padre: 678   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(679)).setAttribute("align","left" );
      ((Element)v.get(679)).setAttribute("nowrap","true" );
      ((Element)v.get(678)).appendChild((Element)v.get(679));

      /* Empieza nodo:680 / Elemento padre: 679   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(680)).setAttribute("nombre","tmalOidStocTran" );
      ((Element)v.get(680)).setAttribute("id","datosCampos" );
      ((Element)v.get(680)).setAttribute("multiple","N" );
      ((Element)v.get(680)).setAttribute("req","N" );
      ((Element)v.get(680)).setAttribute("size","1" );
      ((Element)v.get(680)).setAttribute("disabled","" );
      ((Element)v.get(680)).setAttribute("validacion","" );
      ((Element)v.get(680)).setAttribute("onchange","" );
      ((Element)v.get(680)).setAttribute("onfocus","" );
      ((Element)v.get(680)).setAttribute("valorinicial","" );
      ((Element)v.get(680)).setAttribute("textoinicial","" );
      ((Element)v.get(680)).setAttribute("ontab","ejecutarAccionFoco('belParamBelceFrm',22, true);" );
      ((Element)v.get(680)).setAttribute("onshtab","ejecutarAccionFoco('belParamBelceFrm',22, false);" );
      ((Element)v.get(679)).appendChild((Element)v.get(680));

      /* Empieza nodo:681 / Elemento padre: 680   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(680)).appendChild((Element)v.get(681));
      /* Termina nodo:681   */
      /* Termina nodo:680   */
      /* Termina nodo:679   */
      /* Termina nodo:678   */
      /* Termina nodo:674   */
      /* Termina nodo:673   */

      /* Empieza nodo:682 / Elemento padre: 672   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(682)).setAttribute("nombre","tmalOidStocTranGapTdId" );
      ((Element)v.get(682)).setAttribute("nowrap","true" );
      ((Element)v.get(682)).setAttribute("class","datosCampos" );
      ((Element)v.get(672)).appendChild((Element)v.get(682));

      /* Empieza nodo:683 / Elemento padre: 682   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(683)).setAttribute("src","b.gif" );
      ((Element)v.get(683)).setAttribute("width","25" );
      ((Element)v.get(683)).setAttribute("height","8" );
      ((Element)v.get(682)).appendChild((Element)v.get(683));
      /* Termina nodo:683   */
      /* Termina nodo:682   */

      /* Empieza nodo:684 / Elemento padre: 672   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(684)).setAttribute("width","100%" );
      ((Element)v.get(672)).appendChild((Element)v.get(684));

      /* Empieza nodo:685 / Elemento padre: 684   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(685)).setAttribute("src","b.gif" );
      ((Element)v.get(684)).appendChild((Element)v.get(685));
      /* Termina nodo:685   */
      /* Termina nodo:684   */
      /* Termina nodo:672   */
      /* Termina nodo:671   */
      /* Termina nodo:670   */
      /* Termina nodo:667   */

      /* Empieza nodo:686 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(686)).setAttribute("nombre","formGapTr21" );
      ((Element)v.get(52)).appendChild((Element)v.get(686));

      /* Empieza nodo:687 / Elemento padre: 686   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(687)).setAttribute("align","center" );
      ((Element)v.get(687)).setAttribute("width","8" );
      ((Element)v.get(686)).appendChild((Element)v.get(687));

      /* Empieza nodo:688 / Elemento padre: 687   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(688)).setAttribute("src","b.gif" );
      ((Element)v.get(688)).setAttribute("width","12" );
      ((Element)v.get(688)).setAttribute("height","8" );
      ((Element)v.get(687)).appendChild((Element)v.get(688));
      /* Termina nodo:688   */
      /* Termina nodo:687   */

      /* Empieza nodo:689 / Elemento padre: 686   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(686)).appendChild((Element)v.get(689));

      /* Empieza nodo:690 / Elemento padre: 689   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(690)).setAttribute("src","b.gif" );
      ((Element)v.get(690)).setAttribute("width","8" );
      ((Element)v.get(690)).setAttribute("height","8" );
      ((Element)v.get(689)).appendChild((Element)v.get(690));
      /* Termina nodo:690   */
      /* Termina nodo:689   */

      /* Empieza nodo:691 / Elemento padre: 686   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(691)).setAttribute("align","center" );
      ((Element)v.get(691)).setAttribute("width","8" );
      ((Element)v.get(686)).appendChild((Element)v.get(691));

      /* Empieza nodo:692 / Elemento padre: 691   */
   }

   private void getXML3150(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(692)).setAttribute("src","b.gif" );
      ((Element)v.get(692)).setAttribute("width","12" );
      ((Element)v.get(692)).setAttribute("height","8" );
      ((Element)v.get(691)).appendChild((Element)v.get(692));
      /* Termina nodo:692   */
      /* Termina nodo:691   */
      /* Termina nodo:686   */

      /* Empieza nodo:693 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(693)).setAttribute("nombre","formTr22" );
      ((Element)v.get(52)).appendChild((Element)v.get(693));

      /* Empieza nodo:694 / Elemento padre: 693   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(694)).setAttribute("align","center" );
      ((Element)v.get(694)).setAttribute("width","8" );
      ((Element)v.get(693)).appendChild((Element)v.get(694));

      /* Empieza nodo:695 / Elemento padre: 694   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(695)).setAttribute("src","b.gif" );
      ((Element)v.get(695)).setAttribute("width","8" );
      ((Element)v.get(695)).setAttribute("height","12" );
      ((Element)v.get(694)).appendChild((Element)v.get(695));
      /* Termina nodo:695   */
      /* Termina nodo:694   */

      /* Empieza nodo:696 / Elemento padre: 693   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(696)).setAttribute("width","100%" );
      ((Element)v.get(693)).appendChild((Element)v.get(696));

      /* Empieza nodo:697 / Elemento padre: 696   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(697)).setAttribute("width","100%" );
      ((Element)v.get(697)).setAttribute("border","0" );
      ((Element)v.get(697)).setAttribute("cellspacing","0" );
      ((Element)v.get(697)).setAttribute("cellpadding","0" );
      ((Element)v.get(697)).setAttribute("align","left" );
      ((Element)v.get(696)).appendChild((Element)v.get(697));

      /* Empieza nodo:698 / Elemento padre: 697   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(698)).setAttribute("align","left" );
      ((Element)v.get(697)).appendChild((Element)v.get(698));

      /* Empieza nodo:699 / Elemento padre: 698   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(699)).setAttribute("nombre","tmalOidStocDevoTdId" );
      ((Element)v.get(698)).appendChild((Element)v.get(699));

      /* Empieza nodo:700 / Elemento padre: 699   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(700)).setAttribute("border","0" );
      ((Element)v.get(700)).setAttribute("cellspacing","0" );
      ((Element)v.get(700)).setAttribute("cellpadding","0" );
      ((Element)v.get(700)).setAttribute("align","left" );
      ((Element)v.get(699)).appendChild((Element)v.get(700));

      /* Empieza nodo:701 / Elemento padre: 700   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(700)).appendChild((Element)v.get(701));

      /* Empieza nodo:702 / Elemento padre: 701   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(702)).setAttribute("valign","top" );
      ((Element)v.get(702)).setAttribute("height","13" );
      ((Element)v.get(701)).appendChild((Element)v.get(702));

      /* Empieza nodo:703 / Elemento padre: 702   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(703)).setAttribute("nombre","lbltmalOidStocDevo" );
      ((Element)v.get(703)).setAttribute("id","datosTitle" );
      ((Element)v.get(703)).setAttribute("ancho","150" );
      ((Element)v.get(703)).setAttribute("alto","13" );
      ((Element)v.get(703)).setAttribute("cod","BelParamBelce.tmalOidStocDevo.label" );
      ((Element)v.get(702)).appendChild((Element)v.get(703));
      /* Termina nodo:703   */
      /* Termina nodo:702   */
      /* Termina nodo:701   */

      /* Empieza nodo:704 / Elemento padre: 700   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(704)).setAttribute("nombre","tmalOidStocDevoWidgetTrId" );
      ((Element)v.get(700)).appendChild((Element)v.get(704));

      /* Empieza nodo:705 / Elemento padre: 704   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(705)).setAttribute("align","left" );
      ((Element)v.get(705)).setAttribute("nowrap","true" );
      ((Element)v.get(704)).appendChild((Element)v.get(705));

      /* Empieza nodo:706 / Elemento padre: 705   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(706)).setAttribute("nombre","tmalOidStocDevo" );
      ((Element)v.get(706)).setAttribute("id","datosCampos" );
      ((Element)v.get(706)).setAttribute("multiple","N" );
      ((Element)v.get(706)).setAttribute("req","N" );
      ((Element)v.get(706)).setAttribute("size","1" );
      ((Element)v.get(706)).setAttribute("disabled","" );
      ((Element)v.get(706)).setAttribute("validacion","" );
      ((Element)v.get(706)).setAttribute("onchange","" );
      ((Element)v.get(706)).setAttribute("onfocus","" );
      ((Element)v.get(706)).setAttribute("valorinicial","" );
      ((Element)v.get(706)).setAttribute("textoinicial","" );
      ((Element)v.get(706)).setAttribute("ontab","ejecutarAccionFoco('belParamBelceFrm',23, true);" );
      ((Element)v.get(706)).setAttribute("onshtab","ejecutarAccionFoco('belParamBelceFrm',23, false);" );
      ((Element)v.get(705)).appendChild((Element)v.get(706));

      /* Empieza nodo:707 / Elemento padre: 706   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(706)).appendChild((Element)v.get(707));
      /* Termina nodo:707   */
      /* Termina nodo:706   */
      /* Termina nodo:705   */
      /* Termina nodo:704   */
      /* Termina nodo:700   */
      /* Termina nodo:699   */

      /* Empieza nodo:708 / Elemento padre: 698   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(708)).setAttribute("nombre","tmalOidStocDevoGapTdId" );
      ((Element)v.get(708)).setAttribute("nowrap","true" );
      ((Element)v.get(708)).setAttribute("class","datosCampos" );
      ((Element)v.get(698)).appendChild((Element)v.get(708));

      /* Empieza nodo:709 / Elemento padre: 708   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(709)).setAttribute("src","b.gif" );
      ((Element)v.get(709)).setAttribute("width","25" );
      ((Element)v.get(709)).setAttribute("height","8" );
      ((Element)v.get(708)).appendChild((Element)v.get(709));
      /* Termina nodo:709   */
      /* Termina nodo:708   */

      /* Empieza nodo:710 / Elemento padre: 698   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(710)).setAttribute("width","100%" );
      ((Element)v.get(698)).appendChild((Element)v.get(710));

      /* Empieza nodo:711 / Elemento padre: 710   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML3240(Document doc) {
      ((Element)v.get(711)).setAttribute("src","b.gif" );
      ((Element)v.get(710)).appendChild((Element)v.get(711));
      /* Termina nodo:711   */
      /* Termina nodo:710   */
      /* Termina nodo:698   */
      /* Termina nodo:697   */
      /* Termina nodo:696   */
      /* Termina nodo:693   */

      /* Empieza nodo:712 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(712)).setAttribute("nombre","formGapTr22" );
      ((Element)v.get(52)).appendChild((Element)v.get(712));

      /* Empieza nodo:713 / Elemento padre: 712   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(713)).setAttribute("align","center" );
      ((Element)v.get(713)).setAttribute("width","8" );
      ((Element)v.get(712)).appendChild((Element)v.get(713));

      /* Empieza nodo:714 / Elemento padre: 713   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(714)).setAttribute("src","b.gif" );
      ((Element)v.get(714)).setAttribute("width","12" );
      ((Element)v.get(714)).setAttribute("height","8" );
      ((Element)v.get(713)).appendChild((Element)v.get(714));
      /* Termina nodo:714   */
      /* Termina nodo:713   */

      /* Empieza nodo:715 / Elemento padre: 712   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(712)).appendChild((Element)v.get(715));

      /* Empieza nodo:716 / Elemento padre: 715   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(716)).setAttribute("src","b.gif" );
      ((Element)v.get(716)).setAttribute("width","8" );
      ((Element)v.get(716)).setAttribute("height","8" );
      ((Element)v.get(715)).appendChild((Element)v.get(716));
      /* Termina nodo:716   */
      /* Termina nodo:715   */

      /* Empieza nodo:717 / Elemento padre: 712   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(717)).setAttribute("align","center" );
      ((Element)v.get(717)).setAttribute("width","8" );
      ((Element)v.get(712)).appendChild((Element)v.get(717));

      /* Empieza nodo:718 / Elemento padre: 717   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(718)).setAttribute("src","b.gif" );
      ((Element)v.get(718)).setAttribute("width","12" );
      ((Element)v.get(718)).setAttribute("height","8" );
      ((Element)v.get(717)).appendChild((Element)v.get(718));
      /* Termina nodo:718   */
      /* Termina nodo:717   */
      /* Termina nodo:712   */

      /* Empieza nodo:719 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(719)).setAttribute("nombre","formTr23" );
      ((Element)v.get(52)).appendChild((Element)v.get(719));

      /* Empieza nodo:720 / Elemento padre: 719   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(720)).setAttribute("align","center" );
      ((Element)v.get(720)).setAttribute("width","8" );
      ((Element)v.get(719)).appendChild((Element)v.get(720));

      /* Empieza nodo:721 / Elemento padre: 720   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(721)).setAttribute("src","b.gif" );
      ((Element)v.get(721)).setAttribute("width","8" );
      ((Element)v.get(721)).setAttribute("height","12" );
      ((Element)v.get(720)).appendChild((Element)v.get(721));
      /* Termina nodo:721   */
      /* Termina nodo:720   */

      /* Empieza nodo:722 / Elemento padre: 719   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(722)).setAttribute("width","100%" );
      ((Element)v.get(719)).appendChild((Element)v.get(722));

      /* Empieza nodo:723 / Elemento padre: 722   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(723)).setAttribute("width","100%" );
      ((Element)v.get(723)).setAttribute("border","0" );
      ((Element)v.get(723)).setAttribute("cellspacing","0" );
      ((Element)v.get(723)).setAttribute("cellpadding","0" );
      ((Element)v.get(723)).setAttribute("align","left" );
      ((Element)v.get(722)).appendChild((Element)v.get(723));

      /* Empieza nodo:724 / Elemento padre: 723   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(724)).setAttribute("align","left" );
      ((Element)v.get(723)).appendChild((Element)v.get(724));

      /* Empieza nodo:725 / Elemento padre: 724   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(725)).setAttribute("nombre","tmalOidReguTdId" );
      ((Element)v.get(724)).appendChild((Element)v.get(725));

      /* Empieza nodo:726 / Elemento padre: 725   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(726)).setAttribute("border","0" );
      ((Element)v.get(726)).setAttribute("cellspacing","0" );
      ((Element)v.get(726)).setAttribute("cellpadding","0" );
      ((Element)v.get(726)).setAttribute("align","left" );
      ((Element)v.get(725)).appendChild((Element)v.get(726));

      /* Empieza nodo:727 / Elemento padre: 726   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(726)).appendChild((Element)v.get(727));

      /* Empieza nodo:728 / Elemento padre: 727   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(728)).setAttribute("valign","top" );
      ((Element)v.get(728)).setAttribute("height","13" );
      ((Element)v.get(727)).appendChild((Element)v.get(728));

      /* Empieza nodo:729 / Elemento padre: 728   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(729)).setAttribute("nombre","lbltmalOidRegu" );
      ((Element)v.get(729)).setAttribute("id","datosTitle" );
      ((Element)v.get(729)).setAttribute("ancho","150" );
      ((Element)v.get(729)).setAttribute("alto","13" );
      ((Element)v.get(729)).setAttribute("cod","BelParamBelce.tmalOidRegu.label" );
      ((Element)v.get(728)).appendChild((Element)v.get(729));
      /* Termina nodo:729   */
      /* Termina nodo:728   */
      /* Termina nodo:727   */

      /* Empieza nodo:730 / Elemento padre: 726   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(730)).setAttribute("nombre","tmalOidReguWidgetTrId" );
      ((Element)v.get(726)).appendChild((Element)v.get(730));

      /* Empieza nodo:731 / Elemento padre: 730   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(731)).setAttribute("align","left" );
      ((Element)v.get(731)).setAttribute("nowrap","true" );
      ((Element)v.get(730)).appendChild((Element)v.get(731));

      /* Empieza nodo:732 / Elemento padre: 731   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(732)).setAttribute("nombre","tmalOidRegu" );
      ((Element)v.get(732)).setAttribute("id","datosCampos" );
      ((Element)v.get(732)).setAttribute("multiple","N" );
      ((Element)v.get(732)).setAttribute("req","N" );
      ((Element)v.get(732)).setAttribute("size","1" );
   }

   private void getXML3330(Document doc) {
      ((Element)v.get(732)).setAttribute("disabled","" );
      ((Element)v.get(732)).setAttribute("validacion","" );
      ((Element)v.get(732)).setAttribute("onchange","" );
      ((Element)v.get(732)).setAttribute("onfocus","" );
      ((Element)v.get(732)).setAttribute("valorinicial","" );
      ((Element)v.get(732)).setAttribute("textoinicial","" );
      ((Element)v.get(732)).setAttribute("ontab","ejecutarAccionFoco('belParamBelceFrm',24, true);" );
      ((Element)v.get(732)).setAttribute("onshtab","ejecutarAccionFoco('belParamBelceFrm',24, false);" );
      ((Element)v.get(731)).appendChild((Element)v.get(732));

      /* Empieza nodo:733 / Elemento padre: 732   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(732)).appendChild((Element)v.get(733));
      /* Termina nodo:733   */
      /* Termina nodo:732   */
      /* Termina nodo:731   */
      /* Termina nodo:730   */
      /* Termina nodo:726   */
      /* Termina nodo:725   */

      /* Empieza nodo:734 / Elemento padre: 724   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(734)).setAttribute("nombre","tmalOidReguGapTdId" );
      ((Element)v.get(734)).setAttribute("nowrap","true" );
      ((Element)v.get(734)).setAttribute("class","datosCampos" );
      ((Element)v.get(724)).appendChild((Element)v.get(734));

      /* Empieza nodo:735 / Elemento padre: 734   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(735)).setAttribute("src","b.gif" );
      ((Element)v.get(735)).setAttribute("width","25" );
      ((Element)v.get(735)).setAttribute("height","8" );
      ((Element)v.get(734)).appendChild((Element)v.get(735));
      /* Termina nodo:735   */
      /* Termina nodo:734   */

      /* Empieza nodo:736 / Elemento padre: 724   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(736)).setAttribute("width","100%" );
      ((Element)v.get(724)).appendChild((Element)v.get(736));

      /* Empieza nodo:737 / Elemento padre: 736   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(737)).setAttribute("src","b.gif" );
      ((Element)v.get(736)).appendChild((Element)v.get(737));
      /* Termina nodo:737   */
      /* Termina nodo:736   */
      /* Termina nodo:724   */
      /* Termina nodo:723   */
      /* Termina nodo:722   */
      /* Termina nodo:719   */

      /* Empieza nodo:738 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(738)).setAttribute("nombre","formGapTr23" );
      ((Element)v.get(52)).appendChild((Element)v.get(738));

      /* Empieza nodo:739 / Elemento padre: 738   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(739)).setAttribute("align","center" );
      ((Element)v.get(739)).setAttribute("width","8" );
      ((Element)v.get(738)).appendChild((Element)v.get(739));

      /* Empieza nodo:740 / Elemento padre: 739   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(740)).setAttribute("src","b.gif" );
      ((Element)v.get(740)).setAttribute("width","12" );
      ((Element)v.get(740)).setAttribute("height","8" );
      ((Element)v.get(739)).appendChild((Element)v.get(740));
      /* Termina nodo:740   */
      /* Termina nodo:739   */

      /* Empieza nodo:741 / Elemento padre: 738   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(738)).appendChild((Element)v.get(741));

      /* Empieza nodo:742 / Elemento padre: 741   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(742)).setAttribute("src","b.gif" );
      ((Element)v.get(742)).setAttribute("width","8" );
      ((Element)v.get(742)).setAttribute("height","8" );
      ((Element)v.get(741)).appendChild((Element)v.get(742));
      /* Termina nodo:742   */
      /* Termina nodo:741   */

      /* Empieza nodo:743 / Elemento padre: 738   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(743)).setAttribute("align","center" );
      ((Element)v.get(743)).setAttribute("width","8" );
      ((Element)v.get(738)).appendChild((Element)v.get(743));

      /* Empieza nodo:744 / Elemento padre: 743   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(744)).setAttribute("src","b.gif" );
      ((Element)v.get(744)).setAttribute("width","12" );
      ((Element)v.get(744)).setAttribute("height","8" );
      ((Element)v.get(743)).appendChild((Element)v.get(744));
      /* Termina nodo:744   */
      /* Termina nodo:743   */
      /* Termina nodo:738   */

      /* Empieza nodo:745 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(745)).setAttribute("nombre","formTr24" );
      ((Element)v.get(52)).appendChild((Element)v.get(745));

      /* Empieza nodo:746 / Elemento padre: 745   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(746)).setAttribute("align","center" );
      ((Element)v.get(746)).setAttribute("width","8" );
      ((Element)v.get(745)).appendChild((Element)v.get(746));

      /* Empieza nodo:747 / Elemento padre: 746   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(747)).setAttribute("src","b.gif" );
      ((Element)v.get(747)).setAttribute("width","8" );
      ((Element)v.get(747)).setAttribute("height","12" );
      ((Element)v.get(746)).appendChild((Element)v.get(747));
      /* Termina nodo:747   */
      /* Termina nodo:746   */

      /* Empieza nodo:748 / Elemento padre: 745   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(748)).setAttribute("width","100%" );
      ((Element)v.get(745)).appendChild((Element)v.get(748));

      /* Empieza nodo:749 / Elemento padre: 748   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(749)).setAttribute("width","100%" );
      ((Element)v.get(749)).setAttribute("border","0" );
      ((Element)v.get(749)).setAttribute("cellspacing","0" );
      ((Element)v.get(749)).setAttribute("cellpadding","0" );
      ((Element)v.get(749)).setAttribute("align","left" );
      ((Element)v.get(748)).appendChild((Element)v.get(749));

      /* Empieza nodo:750 / Elemento padre: 749   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(750)).setAttribute("align","left" );
      ((Element)v.get(749)).appendChild((Element)v.get(750));

      /* Empieza nodo:751 / Elemento padre: 750   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(751)).setAttribute("nombre","tmalOidReguSapTdId" );
      ((Element)v.get(750)).appendChild((Element)v.get(751));

      /* Empieza nodo:752 / Elemento padre: 751   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(752)).setAttribute("border","0" );
      ((Element)v.get(752)).setAttribute("cellspacing","0" );
      ((Element)v.get(752)).setAttribute("cellpadding","0" );
      ((Element)v.get(752)).setAttribute("align","left" );
      ((Element)v.get(751)).appendChild((Element)v.get(752));

      /* Empieza nodo:753 / Elemento padre: 752   */
      v.add(doc.createElement("TR"));
   }

   private void getXML3420(Document doc) {
      ((Element)v.get(752)).appendChild((Element)v.get(753));

      /* Empieza nodo:754 / Elemento padre: 753   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(754)).setAttribute("valign","top" );
      ((Element)v.get(754)).setAttribute("height","13" );
      ((Element)v.get(753)).appendChild((Element)v.get(754));

      /* Empieza nodo:755 / Elemento padre: 754   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(755)).setAttribute("nombre","lbltmalOidReguSap" );
      ((Element)v.get(755)).setAttribute("id","datosTitle" );
      ((Element)v.get(755)).setAttribute("ancho","150" );
      ((Element)v.get(755)).setAttribute("alto","13" );
      ((Element)v.get(755)).setAttribute("cod","BelParamBelce.tmalOidReguSap.label" );
      ((Element)v.get(754)).appendChild((Element)v.get(755));
      /* Termina nodo:755   */
      /* Termina nodo:754   */
      /* Termina nodo:753   */

      /* Empieza nodo:756 / Elemento padre: 752   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(756)).setAttribute("nombre","tmalOidReguSapWidgetTrId" );
      ((Element)v.get(752)).appendChild((Element)v.get(756));

      /* Empieza nodo:757 / Elemento padre: 756   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(757)).setAttribute("align","left" );
      ((Element)v.get(757)).setAttribute("nowrap","true" );
      ((Element)v.get(756)).appendChild((Element)v.get(757));

      /* Empieza nodo:758 / Elemento padre: 757   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(758)).setAttribute("nombre","tmalOidReguSap" );
      ((Element)v.get(758)).setAttribute("id","datosCampos" );
      ((Element)v.get(758)).setAttribute("multiple","N" );
      ((Element)v.get(758)).setAttribute("req","N" );
      ((Element)v.get(758)).setAttribute("size","1" );
      ((Element)v.get(758)).setAttribute("disabled","" );
      ((Element)v.get(758)).setAttribute("validacion","" );
      ((Element)v.get(758)).setAttribute("onchange","" );
      ((Element)v.get(758)).setAttribute("onfocus","" );
      ((Element)v.get(758)).setAttribute("valorinicial","" );
      ((Element)v.get(758)).setAttribute("textoinicial","" );
      ((Element)v.get(758)).setAttribute("ontab","ejecutarAccionFoco('belParamBelceFrm',25, true);" );
      ((Element)v.get(758)).setAttribute("onshtab","ejecutarAccionFoco('belParamBelceFrm',25, false);" );
      ((Element)v.get(757)).appendChild((Element)v.get(758));

      /* Empieza nodo:759 / Elemento padre: 758   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(758)).appendChild((Element)v.get(759));
      /* Termina nodo:759   */
      /* Termina nodo:758   */
      /* Termina nodo:757   */
      /* Termina nodo:756   */
      /* Termina nodo:752   */
      /* Termina nodo:751   */

      /* Empieza nodo:760 / Elemento padre: 750   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(760)).setAttribute("nombre","tmalOidReguSapGapTdId" );
      ((Element)v.get(760)).setAttribute("nowrap","true" );
      ((Element)v.get(760)).setAttribute("class","datosCampos" );
      ((Element)v.get(750)).appendChild((Element)v.get(760));

      /* Empieza nodo:761 / Elemento padre: 760   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(761)).setAttribute("src","b.gif" );
      ((Element)v.get(761)).setAttribute("width","25" );
      ((Element)v.get(761)).setAttribute("height","8" );
      ((Element)v.get(760)).appendChild((Element)v.get(761));
      /* Termina nodo:761   */
      /* Termina nodo:760   */

      /* Empieza nodo:762 / Elemento padre: 750   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(762)).setAttribute("width","100%" );
      ((Element)v.get(750)).appendChild((Element)v.get(762));

      /* Empieza nodo:763 / Elemento padre: 762   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(763)).setAttribute("src","b.gif" );
      ((Element)v.get(762)).appendChild((Element)v.get(763));
      /* Termina nodo:763   */
      /* Termina nodo:762   */
      /* Termina nodo:750   */
      /* Termina nodo:749   */
      /* Termina nodo:748   */
      /* Termina nodo:745   */

      /* Empieza nodo:764 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(764)).setAttribute("nombre","formGapTr24" );
      ((Element)v.get(52)).appendChild((Element)v.get(764));

      /* Empieza nodo:765 / Elemento padre: 764   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(765)).setAttribute("align","center" );
      ((Element)v.get(765)).setAttribute("width","8" );
      ((Element)v.get(764)).appendChild((Element)v.get(765));

      /* Empieza nodo:766 / Elemento padre: 765   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(766)).setAttribute("src","b.gif" );
      ((Element)v.get(766)).setAttribute("width","12" );
      ((Element)v.get(766)).setAttribute("height","8" );
      ((Element)v.get(765)).appendChild((Element)v.get(766));
      /* Termina nodo:766   */
      /* Termina nodo:765   */

      /* Empieza nodo:767 / Elemento padre: 764   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(764)).appendChild((Element)v.get(767));

      /* Empieza nodo:768 / Elemento padre: 767   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(768)).setAttribute("src","b.gif" );
      ((Element)v.get(768)).setAttribute("width","8" );
      ((Element)v.get(768)).setAttribute("height","8" );
      ((Element)v.get(767)).appendChild((Element)v.get(768));
      /* Termina nodo:768   */
      /* Termina nodo:767   */

      /* Empieza nodo:769 / Elemento padre: 764   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(769)).setAttribute("align","center" );
      ((Element)v.get(769)).setAttribute("width","8" );
      ((Element)v.get(764)).appendChild((Element)v.get(769));

      /* Empieza nodo:770 / Elemento padre: 769   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(770)).setAttribute("src","b.gif" );
      ((Element)v.get(770)).setAttribute("width","12" );
      ((Element)v.get(770)).setAttribute("height","8" );
      ((Element)v.get(769)).appendChild((Element)v.get(770));
      /* Termina nodo:770   */
      /* Termina nodo:769   */
      /* Termina nodo:764   */

      /* Empieza nodo:771 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(771)).setAttribute("nombre","formTr25" );
      ((Element)v.get(52)).appendChild((Element)v.get(771));

      /* Empieza nodo:772 / Elemento padre: 771   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(772)).setAttribute("align","center" );
      ((Element)v.get(772)).setAttribute("width","8" );
      ((Element)v.get(771)).appendChild((Element)v.get(772));

      /* Empieza nodo:773 / Elemento padre: 772   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(773)).setAttribute("src","b.gif" );
      ((Element)v.get(773)).setAttribute("width","8" );
   }

   private void getXML3510(Document doc) {
      ((Element)v.get(773)).setAttribute("height","12" );
      ((Element)v.get(772)).appendChild((Element)v.get(773));
      /* Termina nodo:773   */
      /* Termina nodo:772   */

      /* Empieza nodo:774 / Elemento padre: 771   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(774)).setAttribute("width","100%" );
      ((Element)v.get(771)).appendChild((Element)v.get(774));

      /* Empieza nodo:775 / Elemento padre: 774   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(775)).setAttribute("width","100%" );
      ((Element)v.get(775)).setAttribute("border","0" );
      ((Element)v.get(775)).setAttribute("cellspacing","0" );
      ((Element)v.get(775)).setAttribute("cellpadding","0" );
      ((Element)v.get(775)).setAttribute("align","left" );
      ((Element)v.get(774)).appendChild((Element)v.get(775));

      /* Empieza nodo:776 / Elemento padre: 775   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(776)).setAttribute("align","left" );
      ((Element)v.get(775)).appendChild((Element)v.get(776));

      /* Empieza nodo:777 / Elemento padre: 776   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(777)).setAttribute("nombre","tmalOidDevoStocTdId" );
      ((Element)v.get(776)).appendChild((Element)v.get(777));

      /* Empieza nodo:778 / Elemento padre: 777   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(778)).setAttribute("border","0" );
      ((Element)v.get(778)).setAttribute("cellspacing","0" );
      ((Element)v.get(778)).setAttribute("cellpadding","0" );
      ((Element)v.get(778)).setAttribute("align","left" );
      ((Element)v.get(777)).appendChild((Element)v.get(778));

      /* Empieza nodo:779 / Elemento padre: 778   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(778)).appendChild((Element)v.get(779));

      /* Empieza nodo:780 / Elemento padre: 779   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(780)).setAttribute("valign","top" );
      ((Element)v.get(780)).setAttribute("height","13" );
      ((Element)v.get(779)).appendChild((Element)v.get(780));

      /* Empieza nodo:781 / Elemento padre: 780   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(781)).setAttribute("nombre","lbltmalOidDevoStoc" );
      ((Element)v.get(781)).setAttribute("id","datosTitle" );
      ((Element)v.get(781)).setAttribute("ancho","150" );
      ((Element)v.get(781)).setAttribute("alto","13" );
      ((Element)v.get(781)).setAttribute("cod","BelParamBelce.tmalOidDevoStoc.label" );
      ((Element)v.get(780)).appendChild((Element)v.get(781));
      /* Termina nodo:781   */
      /* Termina nodo:780   */
      /* Termina nodo:779   */

      /* Empieza nodo:782 / Elemento padre: 778   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(782)).setAttribute("nombre","tmalOidDevoStocWidgetTrId" );
      ((Element)v.get(778)).appendChild((Element)v.get(782));

      /* Empieza nodo:783 / Elemento padre: 782   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(783)).setAttribute("align","left" );
      ((Element)v.get(783)).setAttribute("nowrap","true" );
      ((Element)v.get(782)).appendChild((Element)v.get(783));

      /* Empieza nodo:784 / Elemento padre: 783   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(784)).setAttribute("nombre","tmalOidDevoStoc" );
      ((Element)v.get(784)).setAttribute("id","datosCampos" );
      ((Element)v.get(784)).setAttribute("multiple","N" );
      ((Element)v.get(784)).setAttribute("req","N" );
      ((Element)v.get(784)).setAttribute("size","1" );
      ((Element)v.get(784)).setAttribute("disabled","" );
      ((Element)v.get(784)).setAttribute("validacion","" );
      ((Element)v.get(784)).setAttribute("onchange","" );
      ((Element)v.get(784)).setAttribute("onfocus","" );
      ((Element)v.get(784)).setAttribute("valorinicial","" );
      ((Element)v.get(784)).setAttribute("textoinicial","" );
      ((Element)v.get(784)).setAttribute("ontab","ejecutarAccionFoco('belParamBelceFrm',26, true);" );
      ((Element)v.get(784)).setAttribute("onshtab","ejecutarAccionFoco('belParamBelceFrm',26, false);" );
      ((Element)v.get(783)).appendChild((Element)v.get(784));

      /* Empieza nodo:785 / Elemento padre: 784   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(784)).appendChild((Element)v.get(785));
      /* Termina nodo:785   */
      /* Termina nodo:784   */
      /* Termina nodo:783   */
      /* Termina nodo:782   */
      /* Termina nodo:778   */
      /* Termina nodo:777   */

      /* Empieza nodo:786 / Elemento padre: 776   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(786)).setAttribute("nombre","tmalOidDevoStocGapTdId" );
      ((Element)v.get(786)).setAttribute("nowrap","true" );
      ((Element)v.get(786)).setAttribute("class","datosCampos" );
      ((Element)v.get(776)).appendChild((Element)v.get(786));

      /* Empieza nodo:787 / Elemento padre: 786   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(787)).setAttribute("src","b.gif" );
      ((Element)v.get(787)).setAttribute("width","25" );
      ((Element)v.get(787)).setAttribute("height","8" );
      ((Element)v.get(786)).appendChild((Element)v.get(787));
      /* Termina nodo:787   */
      /* Termina nodo:786   */

      /* Empieza nodo:788 / Elemento padre: 776   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(788)).setAttribute("width","100%" );
      ((Element)v.get(776)).appendChild((Element)v.get(788));

      /* Empieza nodo:789 / Elemento padre: 788   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(789)).setAttribute("src","b.gif" );
      ((Element)v.get(788)).appendChild((Element)v.get(789));
      /* Termina nodo:789   */
      /* Termina nodo:788   */
      /* Termina nodo:776   */
      /* Termina nodo:775   */
      /* Termina nodo:774   */
      /* Termina nodo:771   */

      /* Empieza nodo:790 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(790)).setAttribute("nombre","formGapTr25" );
      ((Element)v.get(52)).appendChild((Element)v.get(790));

      /* Empieza nodo:791 / Elemento padre: 790   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(791)).setAttribute("align","center" );
      ((Element)v.get(791)).setAttribute("width","8" );
      ((Element)v.get(790)).appendChild((Element)v.get(791));

      /* Empieza nodo:792 / Elemento padre: 791   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(792)).setAttribute("src","b.gif" );
      ((Element)v.get(792)).setAttribute("width","12" );
      ((Element)v.get(792)).setAttribute("height","8" );
      ((Element)v.get(791)).appendChild((Element)v.get(792));
      /* Termina nodo:792   */
      /* Termina nodo:791   */

      /* Empieza nodo:793 / Elemento padre: 790   */
      v.add(doc.createElement("TD"));
   }

   private void getXML3600(Document doc) {
      ((Element)v.get(790)).appendChild((Element)v.get(793));

      /* Empieza nodo:794 / Elemento padre: 793   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(794)).setAttribute("src","b.gif" );
      ((Element)v.get(794)).setAttribute("width","8" );
      ((Element)v.get(794)).setAttribute("height","8" );
      ((Element)v.get(793)).appendChild((Element)v.get(794));
      /* Termina nodo:794   */
      /* Termina nodo:793   */

      /* Empieza nodo:795 / Elemento padre: 790   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(795)).setAttribute("align","center" );
      ((Element)v.get(795)).setAttribute("width","8" );
      ((Element)v.get(790)).appendChild((Element)v.get(795));

      /* Empieza nodo:796 / Elemento padre: 795   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(796)).setAttribute("src","b.gif" );
      ((Element)v.get(796)).setAttribute("width","12" );
      ((Element)v.get(796)).setAttribute("height","8" );
      ((Element)v.get(795)).appendChild((Element)v.get(796));
      /* Termina nodo:796   */
      /* Termina nodo:795   */
      /* Termina nodo:790   */

      /* Empieza nodo:797 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(797)).setAttribute("nombre","formTr26" );
      ((Element)v.get(52)).appendChild((Element)v.get(797));

      /* Empieza nodo:798 / Elemento padre: 797   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(798)).setAttribute("align","center" );
      ((Element)v.get(798)).setAttribute("width","8" );
      ((Element)v.get(797)).appendChild((Element)v.get(798));

      /* Empieza nodo:799 / Elemento padre: 798   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(799)).setAttribute("src","b.gif" );
      ((Element)v.get(799)).setAttribute("width","8" );
      ((Element)v.get(799)).setAttribute("height","12" );
      ((Element)v.get(798)).appendChild((Element)v.get(799));
      /* Termina nodo:799   */
      /* Termina nodo:798   */

      /* Empieza nodo:800 / Elemento padre: 797   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(800)).setAttribute("width","100%" );
      ((Element)v.get(797)).appendChild((Element)v.get(800));

      /* Empieza nodo:801 / Elemento padre: 800   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(801)).setAttribute("width","100%" );
      ((Element)v.get(801)).setAttribute("border","0" );
      ((Element)v.get(801)).setAttribute("cellspacing","0" );
      ((Element)v.get(801)).setAttribute("cellpadding","0" );
      ((Element)v.get(801)).setAttribute("align","left" );
      ((Element)v.get(800)).appendChild((Element)v.get(801));

      /* Empieza nodo:802 / Elemento padre: 801   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(802)).setAttribute("align","left" );
      ((Element)v.get(801)).appendChild((Element)v.get(802));

      /* Empieza nodo:803 / Elemento padre: 802   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(803)).setAttribute("nombre","tmalOidPetiExisTdId" );
      ((Element)v.get(802)).appendChild((Element)v.get(803));

      /* Empieza nodo:804 / Elemento padre: 803   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(804)).setAttribute("border","0" );
      ((Element)v.get(804)).setAttribute("cellspacing","0" );
      ((Element)v.get(804)).setAttribute("cellpadding","0" );
      ((Element)v.get(804)).setAttribute("align","left" );
      ((Element)v.get(803)).appendChild((Element)v.get(804));

      /* Empieza nodo:805 / Elemento padre: 804   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(804)).appendChild((Element)v.get(805));

      /* Empieza nodo:806 / Elemento padre: 805   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(806)).setAttribute("valign","top" );
      ((Element)v.get(806)).setAttribute("height","13" );
      ((Element)v.get(805)).appendChild((Element)v.get(806));

      /* Empieza nodo:807 / Elemento padre: 806   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(807)).setAttribute("nombre","lbltmalOidPetiExis" );
      ((Element)v.get(807)).setAttribute("id","datosTitle" );
      ((Element)v.get(807)).setAttribute("ancho","150" );
      ((Element)v.get(807)).setAttribute("alto","13" );
      ((Element)v.get(807)).setAttribute("cod","BelParamBelce.tmalOidPetiExis.label" );
      ((Element)v.get(806)).appendChild((Element)v.get(807));
      /* Termina nodo:807   */
      /* Termina nodo:806   */
      /* Termina nodo:805   */

      /* Empieza nodo:808 / Elemento padre: 804   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(808)).setAttribute("nombre","tmalOidPetiExisWidgetTrId" );
      ((Element)v.get(804)).appendChild((Element)v.get(808));

      /* Empieza nodo:809 / Elemento padre: 808   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(809)).setAttribute("align","left" );
      ((Element)v.get(809)).setAttribute("nowrap","true" );
      ((Element)v.get(808)).appendChild((Element)v.get(809));

      /* Empieza nodo:810 / Elemento padre: 809   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(810)).setAttribute("nombre","tmalOidPetiExis" );
      ((Element)v.get(810)).setAttribute("id","datosCampos" );
      ((Element)v.get(810)).setAttribute("multiple","N" );
      ((Element)v.get(810)).setAttribute("req","N" );
      ((Element)v.get(810)).setAttribute("size","1" );
      ((Element)v.get(810)).setAttribute("disabled","" );
      ((Element)v.get(810)).setAttribute("validacion","" );
      ((Element)v.get(810)).setAttribute("onchange","" );
      ((Element)v.get(810)).setAttribute("onfocus","" );
      ((Element)v.get(810)).setAttribute("valorinicial","" );
      ((Element)v.get(810)).setAttribute("textoinicial","" );
      ((Element)v.get(810)).setAttribute("ontab","ejecutarAccionFoco('belParamBelceFrm',27, true);" );
      ((Element)v.get(810)).setAttribute("onshtab","ejecutarAccionFoco('belParamBelceFrm',27, false);" );
      ((Element)v.get(809)).appendChild((Element)v.get(810));

      /* Empieza nodo:811 / Elemento padre: 810   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(810)).appendChild((Element)v.get(811));
      /* Termina nodo:811   */
      /* Termina nodo:810   */
      /* Termina nodo:809   */
      /* Termina nodo:808   */
      /* Termina nodo:804   */
      /* Termina nodo:803   */

      /* Empieza nodo:812 / Elemento padre: 802   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(812)).setAttribute("nombre","tmalOidPetiExisGapTdId" );
      ((Element)v.get(812)).setAttribute("nowrap","true" );
      ((Element)v.get(812)).setAttribute("class","datosCampos" );
   }

   private void getXML3690(Document doc) {
      ((Element)v.get(802)).appendChild((Element)v.get(812));

      /* Empieza nodo:813 / Elemento padre: 812   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(813)).setAttribute("src","b.gif" );
      ((Element)v.get(813)).setAttribute("width","25" );
      ((Element)v.get(813)).setAttribute("height","8" );
      ((Element)v.get(812)).appendChild((Element)v.get(813));
      /* Termina nodo:813   */
      /* Termina nodo:812   */

      /* Empieza nodo:814 / Elemento padre: 802   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(814)).setAttribute("width","100%" );
      ((Element)v.get(802)).appendChild((Element)v.get(814));

      /* Empieza nodo:815 / Elemento padre: 814   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(815)).setAttribute("src","b.gif" );
      ((Element)v.get(814)).appendChild((Element)v.get(815));
      /* Termina nodo:815   */
      /* Termina nodo:814   */
      /* Termina nodo:802   */
      /* Termina nodo:801   */
      /* Termina nodo:800   */
      /* Termina nodo:797   */

      /* Empieza nodo:816 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(816)).setAttribute("nombre","formGapTr26" );
      ((Element)v.get(52)).appendChild((Element)v.get(816));

      /* Empieza nodo:817 / Elemento padre: 816   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(817)).setAttribute("align","center" );
      ((Element)v.get(817)).setAttribute("width","8" );
      ((Element)v.get(816)).appendChild((Element)v.get(817));

      /* Empieza nodo:818 / Elemento padre: 817   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(818)).setAttribute("src","b.gif" );
      ((Element)v.get(818)).setAttribute("width","12" );
      ((Element)v.get(818)).setAttribute("height","8" );
      ((Element)v.get(817)).appendChild((Element)v.get(818));
      /* Termina nodo:818   */
      /* Termina nodo:817   */

      /* Empieza nodo:819 / Elemento padre: 816   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(816)).appendChild((Element)v.get(819));

      /* Empieza nodo:820 / Elemento padre: 819   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(820)).setAttribute("src","b.gif" );
      ((Element)v.get(820)).setAttribute("width","8" );
      ((Element)v.get(820)).setAttribute("height","8" );
      ((Element)v.get(819)).appendChild((Element)v.get(820));
      /* Termina nodo:820   */
      /* Termina nodo:819   */

      /* Empieza nodo:821 / Elemento padre: 816   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(821)).setAttribute("align","center" );
      ((Element)v.get(821)).setAttribute("width","8" );
      ((Element)v.get(816)).appendChild((Element)v.get(821));

      /* Empieza nodo:822 / Elemento padre: 821   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(822)).setAttribute("src","b.gif" );
      ((Element)v.get(822)).setAttribute("width","12" );
      ((Element)v.get(822)).setAttribute("height","8" );
      ((Element)v.get(821)).appendChild((Element)v.get(822));
      /* Termina nodo:822   */
      /* Termina nodo:821   */
      /* Termina nodo:816   */

      /* Empieza nodo:823 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(823)).setAttribute("nombre","formTr27" );
      ((Element)v.get(52)).appendChild((Element)v.get(823));

      /* Empieza nodo:824 / Elemento padre: 823   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(824)).setAttribute("align","center" );
      ((Element)v.get(824)).setAttribute("width","8" );
      ((Element)v.get(823)).appendChild((Element)v.get(824));

      /* Empieza nodo:825 / Elemento padre: 824   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(825)).setAttribute("src","b.gif" );
      ((Element)v.get(825)).setAttribute("width","8" );
      ((Element)v.get(825)).setAttribute("height","12" );
      ((Element)v.get(824)).appendChild((Element)v.get(825));
      /* Termina nodo:825   */
      /* Termina nodo:824   */

      /* Empieza nodo:826 / Elemento padre: 823   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(826)).setAttribute("width","100%" );
      ((Element)v.get(823)).appendChild((Element)v.get(826));

      /* Empieza nodo:827 / Elemento padre: 826   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(827)).setAttribute("width","100%" );
      ((Element)v.get(827)).setAttribute("border","0" );
      ((Element)v.get(827)).setAttribute("cellspacing","0" );
      ((Element)v.get(827)).setAttribute("cellpadding","0" );
      ((Element)v.get(827)).setAttribute("align","left" );
      ((Element)v.get(826)).appendChild((Element)v.get(827));

      /* Empieza nodo:828 / Elemento padre: 827   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(828)).setAttribute("align","left" );
      ((Element)v.get(827)).appendChild((Element)v.get(828));

      /* Empieza nodo:829 / Elemento padre: 828   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(829)).setAttribute("nombre","paisOidPaisTdId" );
      ((Element)v.get(828)).appendChild((Element)v.get(829));

      /* Empieza nodo:830 / Elemento padre: 829   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(830)).setAttribute("border","0" );
      ((Element)v.get(830)).setAttribute("cellspacing","0" );
      ((Element)v.get(830)).setAttribute("cellpadding","0" );
      ((Element)v.get(830)).setAttribute("align","left" );
      ((Element)v.get(829)).appendChild((Element)v.get(830));

      /* Empieza nodo:831 / Elemento padre: 830   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(830)).appendChild((Element)v.get(831));

      /* Empieza nodo:832 / Elemento padre: 831   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(832)).setAttribute("valign","top" );
      ((Element)v.get(832)).setAttribute("height","13" );
      ((Element)v.get(831)).appendChild((Element)v.get(832));

      /* Empieza nodo:833 / Elemento padre: 832   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(833)).setAttribute("nombre","lblpaisOidPais" );
      ((Element)v.get(833)).setAttribute("id","datosTitle" );
      ((Element)v.get(833)).setAttribute("ancho","150" );
      ((Element)v.get(833)).setAttribute("alto","13" );
      ((Element)v.get(833)).setAttribute("cod","BelParamBelce.paisOidPais.label" );
      ((Element)v.get(832)).appendChild((Element)v.get(833));
      /* Termina nodo:833   */
      /* Termina nodo:832   */
      /* Termina nodo:831   */

      /* Empieza nodo:834 / Elemento padre: 830   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(834)).setAttribute("nombre","paisOidPaisWidgetTrId" );
      ((Element)v.get(830)).appendChild((Element)v.get(834));

      /* Empieza nodo:835 / Elemento padre: 834   */
   }

   private void getXML3780(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(835)).setAttribute("align","left" );
      ((Element)v.get(835)).setAttribute("nowrap","true" );
      ((Element)v.get(834)).appendChild((Element)v.get(835));

      /* Empieza nodo:836 / Elemento padre: 835   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(836)).setAttribute("nombre","paisOidPais" );
      ((Element)v.get(836)).setAttribute("id","datosCampos" );
      ((Element)v.get(836)).setAttribute("multiple","N" );
      ((Element)v.get(836)).setAttribute("req","N" );
      ((Element)v.get(836)).setAttribute("size","1" );
      ((Element)v.get(836)).setAttribute("disabled","" );
      ((Element)v.get(836)).setAttribute("validacion","" );
      ((Element)v.get(836)).setAttribute("onchange","" );
      ((Element)v.get(836)).setAttribute("onfocus","" );
      ((Element)v.get(836)).setAttribute("valorinicial","" );
      ((Element)v.get(836)).setAttribute("textoinicial","" );
      ((Element)v.get(836)).setAttribute("ontab","ejecutarAccionFoco('belParamBelceFrm',28, true);" );
      ((Element)v.get(836)).setAttribute("onshtab","ejecutarAccionFoco('belParamBelceFrm',28, false);" );
      ((Element)v.get(835)).appendChild((Element)v.get(836));

      /* Empieza nodo:837 / Elemento padre: 836   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(836)).appendChild((Element)v.get(837));
      /* Termina nodo:837   */
      /* Termina nodo:836   */
      /* Termina nodo:835   */
      /* Termina nodo:834   */
      /* Termina nodo:830   */
      /* Termina nodo:829   */

      /* Empieza nodo:838 / Elemento padre: 828   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(838)).setAttribute("nombre","paisOidPaisGapTdId" );
      ((Element)v.get(838)).setAttribute("nowrap","true" );
      ((Element)v.get(838)).setAttribute("class","datosCampos" );
      ((Element)v.get(828)).appendChild((Element)v.get(838));

      /* Empieza nodo:839 / Elemento padre: 838   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(839)).setAttribute("src","b.gif" );
      ((Element)v.get(839)).setAttribute("width","25" );
      ((Element)v.get(839)).setAttribute("height","8" );
      ((Element)v.get(838)).appendChild((Element)v.get(839));
      /* Termina nodo:839   */
      /* Termina nodo:838   */

      /* Empieza nodo:840 / Elemento padre: 828   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(840)).setAttribute("width","100%" );
      ((Element)v.get(828)).appendChild((Element)v.get(840));

      /* Empieza nodo:841 / Elemento padre: 840   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(841)).setAttribute("src","b.gif" );
      ((Element)v.get(840)).appendChild((Element)v.get(841));
      /* Termina nodo:841   */
      /* Termina nodo:840   */
      /* Termina nodo:828   */
      /* Termina nodo:827   */
      /* Termina nodo:826   */

      /* Empieza nodo:842 / Elemento padre: 823   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(842)).setAttribute("width","100%" );
      ((Element)v.get(823)).appendChild((Element)v.get(842));
      /* Termina nodo:842   */
      /* Termina nodo:823   */

      /* Empieza nodo:843 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(843)).setAttribute("nombre","formGapTr27" );
      ((Element)v.get(52)).appendChild((Element)v.get(843));

      /* Empieza nodo:844 / Elemento padre: 843   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(844)).setAttribute("align","center" );
      ((Element)v.get(844)).setAttribute("width","8" );
      ((Element)v.get(843)).appendChild((Element)v.get(844));

      /* Empieza nodo:845 / Elemento padre: 844   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(845)).setAttribute("src","b.gif" );
      ((Element)v.get(845)).setAttribute("width","8" );
      ((Element)v.get(845)).setAttribute("height","8" );
      ((Element)v.get(844)).appendChild((Element)v.get(845));
      /* Termina nodo:845   */
      /* Termina nodo:844   */

      /* Empieza nodo:846 / Elemento padre: 843   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(843)).appendChild((Element)v.get(846));

      /* Empieza nodo:847 / Elemento padre: 846   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(847)).setAttribute("src","b.gif" );
      ((Element)v.get(847)).setAttribute("width","8" );
      ((Element)v.get(847)).setAttribute("height","8" );
      ((Element)v.get(846)).appendChild((Element)v.get(847));
      /* Termina nodo:847   */
      /* Termina nodo:846   */

      /* Empieza nodo:848 / Elemento padre: 843   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(848)).setAttribute("align","center" );
      ((Element)v.get(848)).setAttribute("width","8" );
      ((Element)v.get(843)).appendChild((Element)v.get(848));

      /* Empieza nodo:849 / Elemento padre: 848   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(849)).setAttribute("src","b.gif" );
      ((Element)v.get(849)).setAttribute("width","8" );
      ((Element)v.get(849)).setAttribute("height","8" );
      ((Element)v.get(848)).appendChild((Element)v.get(849));
      /* Termina nodo:849   */
      /* Termina nodo:848   */
      /* Termina nodo:843   */
      /* Termina nodo:52   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:850 / Elemento padre: 45   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(850)).setAttribute("align","center" );
      ((Element)v.get(850)).setAttribute("width","12" );
      ((Element)v.get(45)).appendChild((Element)v.get(850));

      /* Empieza nodo:851 / Elemento padre: 850   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(851)).setAttribute("src","b.gif" );
      ((Element)v.get(851)).setAttribute("width","12" );
      ((Element)v.get(851)).setAttribute("height","12" );
      ((Element)v.get(850)).appendChild((Element)v.get(851));
      /* Termina nodo:851   */
      /* Termina nodo:850   */
      /* Termina nodo:45   */

      /* Empieza nodo:852 / Elemento padre: 37   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(852)).setAttribute("nombre","belParamBelceTrButtons" );
      ((Element)v.get(37)).appendChild((Element)v.get(852));

      /* Empieza nodo:853 / Elemento padre: 852   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(853)).setAttribute("align","center" );
      ((Element)v.get(853)).setAttribute("width","12" );
      ((Element)v.get(852)).appendChild((Element)v.get(853));

      /* Empieza nodo:854 / Elemento padre: 853   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(854)).setAttribute("src","b.gif" );
      ((Element)v.get(854)).setAttribute("width","12" );
      ((Element)v.get(854)).setAttribute("height","12" );
      ((Element)v.get(853)).appendChild((Element)v.get(854));
      /* Termina nodo:854   */
      /* Termina nodo:853   */

      /* Empieza nodo:855 / Elemento padre: 852   */
      v.add(doc.createElement("TD"));
   }

   private void getXML3870(Document doc) {
      ((Element)v.get(852)).appendChild((Element)v.get(855));

      /* Empieza nodo:856 / Elemento padre: 855   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(855)).appendChild((Element)v.get(856));

      /* Empieza nodo:857 / Elemento padre: 856   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(857)).setAttribute("width","100%" );
      ((Element)v.get(857)).setAttribute("border","0" );
      ((Element)v.get(857)).setAttribute("align","center" );
      ((Element)v.get(857)).setAttribute("cellspacing","0" );
      ((Element)v.get(857)).setAttribute("cellpadding","0" );
      ((Element)v.get(856)).appendChild((Element)v.get(857));

      /* Empieza nodo:858 / Elemento padre: 857   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(857)).appendChild((Element)v.get(858));

      /* Empieza nodo:859 / Elemento padre: 858   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(859)).setAttribute("class","tablaTitle" );
      ((Element)v.get(859)).setAttribute("nombre","belParamBelceTdQueryButton" );
      ((Element)v.get(858)).appendChild((Element)v.get(859));

      /* Empieza nodo:860 / Elemento padre: 859   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(860)).setAttribute("nombre","belParamBelceQueryButton" );
      ((Element)v.get(860)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(860)).setAttribute("estado","false" );
      ((Element)v.get(860)).setAttribute("accion","belParamBelceFirstPage();" );
      ((Element)v.get(860)).setAttribute("tipo","html" );
      ((Element)v.get(860)).setAttribute("ID","botonContenido" );
      ((Element)v.get(859)).appendChild((Element)v.get(860));
      /* Termina nodo:860   */
      /* Termina nodo:859   */

      /* Empieza nodo:861 / Elemento padre: 858   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(861)).setAttribute("class","tablaTitle" );
      ((Element)v.get(861)).setAttribute("nombre","belParamBelceTdLovNullSelectionButton" );
      ((Element)v.get(861)).setAttribute("align","left" );
      ((Element)v.get(861)).setAttribute("width","100%" );
      ((Element)v.get(858)).appendChild((Element)v.get(861));

      /* Empieza nodo:862 / Elemento padre: 861   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(862)).setAttribute("src","b.gif" );
      ((Element)v.get(862)).setAttribute("height","8" );
      ((Element)v.get(862)).setAttribute("width","8" );
      ((Element)v.get(861)).appendChild((Element)v.get(862));
      /* Termina nodo:862   */

      /* Empieza nodo:863 / Elemento padre: 861   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(863)).setAttribute("nombre","belParamBelceLovNullButton" );
      ((Element)v.get(863)).setAttribute("ID","botonContenido" );
      ((Element)v.get(863)).setAttribute("tipo","html" );
      ((Element)v.get(863)).setAttribute("accion","belParamBelceLovNullSelectionAction();" );
      ((Element)v.get(863)).setAttribute("estado","true" );
      ((Element)v.get(863)).setAttribute("cod","MMGGlobal.lovNullButton.label" );
      ((Element)v.get(861)).appendChild((Element)v.get(863));
      /* Termina nodo:863   */
      /* Termina nodo:861   */
      /* Termina nodo:858   */
      /* Termina nodo:857   */
      /* Termina nodo:856   */
      /* Termina nodo:855   */

      /* Empieza nodo:864 / Elemento padre: 852   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(864)).setAttribute("align","center" );
      ((Element)v.get(864)).setAttribute("width","12" );
      ((Element)v.get(852)).appendChild((Element)v.get(864));

      /* Empieza nodo:865 / Elemento padre: 864   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(865)).setAttribute("src","b.gif" );
      ((Element)v.get(865)).setAttribute("width","12" );
      ((Element)v.get(865)).setAttribute("height","12" );
      ((Element)v.get(864)).appendChild((Element)v.get(865));
      /* Termina nodo:865   */
      /* Termina nodo:864   */
      /* Termina nodo:852   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:866 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(866)).setAttribute("nombre","belParamBelceListLayer" );
      ((Element)v.get(866)).setAttribute("alto","310" );
      ((Element)v.get(866)).setAttribute("ancho","99%" );
      ((Element)v.get(866)).setAttribute("colorf","" );
      ((Element)v.get(866)).setAttribute("borde","0" );
      ((Element)v.get(866)).setAttribute("imagenf","" );
      ((Element)v.get(866)).setAttribute("repeat","" );
      ((Element)v.get(866)).setAttribute("padding","" );
      ((Element)v.get(866)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(866)).setAttribute("contravsb","" );
      ((Element)v.get(866)).setAttribute("x","3" );
      ((Element)v.get(866)).setAttribute("y","" );
      ((Element)v.get(866)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(866));

      /* Empieza nodo:867 / Elemento padre: 866   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(867)).setAttribute("nombre","belParamBelceList" );
      ((Element)v.get(867)).setAttribute("ancho","680" );
      ((Element)v.get(867)).setAttribute("alto","275" );
      ((Element)v.get(867)).setAttribute("x","12" );
      ((Element)v.get(867)).setAttribute("y","0" );
      ((Element)v.get(867)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(867)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(866)).appendChild((Element)v.get(867));

      /* Empieza nodo:868 / Elemento padre: 867   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(868)).setAttribute("precarga","S" );
      ((Element)v.get(868)).setAttribute("conROver","S" );
      ((Element)v.get(867)).appendChild((Element)v.get(868));

      /* Empieza nodo:869 / Elemento padre: 868   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(869)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(869)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(869)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(869)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(868)).appendChild((Element)v.get(869));
      /* Termina nodo:869   */

      /* Empieza nodo:870 / Elemento padre: 868   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(870)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(870)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(870)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
   }

   private void getXML3960(Document doc) {
      ((Element)v.get(870)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(868)).appendChild((Element)v.get(870));
      /* Termina nodo:870   */
      /* Termina nodo:868   */

      /* Empieza nodo:871 / Elemento padre: 867   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(867)).appendChild((Element)v.get(871));

      /* Empieza nodo:872 / Elemento padre: 871   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(872)).setAttribute("borde","1" );
      ((Element)v.get(872)).setAttribute("horizDatos","1" );
      ((Element)v.get(872)).setAttribute("horizCabecera","1" );
      ((Element)v.get(872)).setAttribute("vertical","1" );
      ((Element)v.get(872)).setAttribute("horizTitulo","1" );
      ((Element)v.get(872)).setAttribute("horizBase","1" );
      ((Element)v.get(871)).appendChild((Element)v.get(872));
      /* Termina nodo:872   */

      /* Empieza nodo:873 / Elemento padre: 871   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(873)).setAttribute("borde","#999999" );
      ((Element)v.get(873)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(873)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(873)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(873)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(873)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(873)).setAttribute("horizBase","#999999" );
      ((Element)v.get(871)).appendChild((Element)v.get(873));
      /* Termina nodo:873   */
      /* Termina nodo:871   */

      /* Empieza nodo:874 / Elemento padre: 867   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(874)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(874)).setAttribute("alto","22" );
      ((Element)v.get(874)).setAttribute("imgFondo","" );
      ((Element)v.get(874)).setAttribute("cod","00135" );
      ((Element)v.get(874)).setAttribute("ID","datosTitle" );
      ((Element)v.get(867)).appendChild((Element)v.get(874));
      /* Termina nodo:874   */

      /* Empieza nodo:875 / Elemento padre: 867   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(875)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(875)).setAttribute("alto","22" );
      ((Element)v.get(875)).setAttribute("imgFondo","" );
      ((Element)v.get(867)).appendChild((Element)v.get(875));
      /* Termina nodo:875   */

      /* Empieza nodo:876 / Elemento padre: 867   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(876)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(876)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(876)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(876)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(876)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(867)).appendChild((Element)v.get(876));

      /* Empieza nodo:877 / Elemento padre: 876   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(877)).setAttribute("ancho","100" );
      ((Element)v.get(877)).setAttribute("minimizable","S" );
      ((Element)v.get(877)).setAttribute("minimizada","N" );
      ((Element)v.get(876)).appendChild((Element)v.get(877));
      /* Termina nodo:877   */

      /* Empieza nodo:878 / Elemento padre: 876   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(878)).setAttribute("ancho","100" );
      ((Element)v.get(878)).setAttribute("minimizable","S" );
      ((Element)v.get(878)).setAttribute("minimizada","N" );
      ((Element)v.get(876)).appendChild((Element)v.get(878));
      /* Termina nodo:878   */

      /* Empieza nodo:879 / Elemento padre: 876   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(879)).setAttribute("ancho","100" );
      ((Element)v.get(879)).setAttribute("minimizable","S" );
      ((Element)v.get(879)).setAttribute("minimizada","N" );
      ((Element)v.get(876)).appendChild((Element)v.get(879));
      /* Termina nodo:879   */

      /* Empieza nodo:880 / Elemento padre: 876   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(880)).setAttribute("ancho","100" );
      ((Element)v.get(880)).setAttribute("minimizable","S" );
      ((Element)v.get(880)).setAttribute("minimizada","N" );
      ((Element)v.get(876)).appendChild((Element)v.get(880));
      /* Termina nodo:880   */

      /* Empieza nodo:881 / Elemento padre: 876   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(881)).setAttribute("ancho","100" );
      ((Element)v.get(881)).setAttribute("minimizable","S" );
      ((Element)v.get(881)).setAttribute("minimizada","N" );
      ((Element)v.get(876)).appendChild((Element)v.get(881));
      /* Termina nodo:881   */

      /* Empieza nodo:882 / Elemento padre: 876   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(882)).setAttribute("ancho","100" );
      ((Element)v.get(882)).setAttribute("minimizable","S" );
      ((Element)v.get(882)).setAttribute("minimizada","N" );
      ((Element)v.get(876)).appendChild((Element)v.get(882));
      /* Termina nodo:882   */

      /* Empieza nodo:883 / Elemento padre: 876   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(883)).setAttribute("ancho","100" );
      ((Element)v.get(883)).setAttribute("minimizable","S" );
      ((Element)v.get(883)).setAttribute("minimizada","N" );
      ((Element)v.get(876)).appendChild((Element)v.get(883));
      /* Termina nodo:883   */

      /* Empieza nodo:884 / Elemento padre: 876   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(884)).setAttribute("ancho","100" );
      ((Element)v.get(884)).setAttribute("minimizable","S" );
      ((Element)v.get(884)).setAttribute("minimizada","N" );
      ((Element)v.get(876)).appendChild((Element)v.get(884));
      /* Termina nodo:884   */

      /* Empieza nodo:885 / Elemento padre: 876   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(885)).setAttribute("ancho","100" );
      ((Element)v.get(885)).setAttribute("minimizable","S" );
      ((Element)v.get(885)).setAttribute("minimizada","N" );
      ((Element)v.get(876)).appendChild((Element)v.get(885));
      /* Termina nodo:885   */

      /* Empieza nodo:886 / Elemento padre: 876   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(886)).setAttribute("ancho","100" );
      ((Element)v.get(886)).setAttribute("minimizable","S" );
      ((Element)v.get(886)).setAttribute("minimizada","N" );
      ((Element)v.get(876)).appendChild((Element)v.get(886));
      /* Termina nodo:886   */

      /* Empieza nodo:887 / Elemento padre: 876   */
   }

   private void getXML4050(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(887)).setAttribute("ancho","100" );
      ((Element)v.get(887)).setAttribute("minimizable","S" );
      ((Element)v.get(887)).setAttribute("minimizada","N" );
      ((Element)v.get(876)).appendChild((Element)v.get(887));
      /* Termina nodo:887   */

      /* Empieza nodo:888 / Elemento padre: 876   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(888)).setAttribute("ancho","100" );
      ((Element)v.get(888)).setAttribute("minimizable","S" );
      ((Element)v.get(888)).setAttribute("minimizada","N" );
      ((Element)v.get(876)).appendChild((Element)v.get(888));
      /* Termina nodo:888   */

      /* Empieza nodo:889 / Elemento padre: 876   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(889)).setAttribute("ancho","100" );
      ((Element)v.get(889)).setAttribute("minimizable","S" );
      ((Element)v.get(889)).setAttribute("minimizada","N" );
      ((Element)v.get(876)).appendChild((Element)v.get(889));
      /* Termina nodo:889   */

      /* Empieza nodo:890 / Elemento padre: 876   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(890)).setAttribute("ancho","100" );
      ((Element)v.get(890)).setAttribute("minimizable","S" );
      ((Element)v.get(890)).setAttribute("minimizada","N" );
      ((Element)v.get(876)).appendChild((Element)v.get(890));
      /* Termina nodo:890   */

      /* Empieza nodo:891 / Elemento padre: 876   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(891)).setAttribute("ancho","100" );
      ((Element)v.get(891)).setAttribute("minimizable","S" );
      ((Element)v.get(891)).setAttribute("minimizada","N" );
      ((Element)v.get(876)).appendChild((Element)v.get(891));
      /* Termina nodo:891   */

      /* Empieza nodo:892 / Elemento padre: 876   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(892)).setAttribute("ancho","100" );
      ((Element)v.get(892)).setAttribute("minimizable","S" );
      ((Element)v.get(892)).setAttribute("minimizada","N" );
      ((Element)v.get(876)).appendChild((Element)v.get(892));
      /* Termina nodo:892   */

      /* Empieza nodo:893 / Elemento padre: 876   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(893)).setAttribute("ancho","100" );
      ((Element)v.get(893)).setAttribute("minimizable","S" );
      ((Element)v.get(893)).setAttribute("minimizada","N" );
      ((Element)v.get(876)).appendChild((Element)v.get(893));
      /* Termina nodo:893   */

      /* Empieza nodo:894 / Elemento padre: 876   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(894)).setAttribute("ancho","100" );
      ((Element)v.get(894)).setAttribute("minimizable","S" );
      ((Element)v.get(894)).setAttribute("minimizada","N" );
      ((Element)v.get(876)).appendChild((Element)v.get(894));
      /* Termina nodo:894   */

      /* Empieza nodo:895 / Elemento padre: 876   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(895)).setAttribute("ancho","100" );
      ((Element)v.get(895)).setAttribute("minimizable","S" );
      ((Element)v.get(895)).setAttribute("minimizada","N" );
      ((Element)v.get(876)).appendChild((Element)v.get(895));
      /* Termina nodo:895   */

      /* Empieza nodo:896 / Elemento padre: 876   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(896)).setAttribute("ancho","100" );
      ((Element)v.get(896)).setAttribute("minimizable","S" );
      ((Element)v.get(896)).setAttribute("minimizada","N" );
      ((Element)v.get(876)).appendChild((Element)v.get(896));
      /* Termina nodo:896   */

      /* Empieza nodo:897 / Elemento padre: 876   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(897)).setAttribute("ancho","100" );
      ((Element)v.get(897)).setAttribute("minimizable","S" );
      ((Element)v.get(897)).setAttribute("minimizada","N" );
      ((Element)v.get(876)).appendChild((Element)v.get(897));
      /* Termina nodo:897   */

      /* Empieza nodo:898 / Elemento padre: 876   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(898)).setAttribute("ancho","100" );
      ((Element)v.get(898)).setAttribute("minimizable","S" );
      ((Element)v.get(898)).setAttribute("minimizada","N" );
      ((Element)v.get(876)).appendChild((Element)v.get(898));
      /* Termina nodo:898   */

      /* Empieza nodo:899 / Elemento padre: 876   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(899)).setAttribute("ancho","100" );
      ((Element)v.get(899)).setAttribute("minimizable","S" );
      ((Element)v.get(899)).setAttribute("minimizada","N" );
      ((Element)v.get(876)).appendChild((Element)v.get(899));
      /* Termina nodo:899   */

      /* Empieza nodo:900 / Elemento padre: 876   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(900)).setAttribute("ancho","100" );
      ((Element)v.get(900)).setAttribute("minimizable","S" );
      ((Element)v.get(900)).setAttribute("minimizada","N" );
      ((Element)v.get(876)).appendChild((Element)v.get(900));
      /* Termina nodo:900   */

      /* Empieza nodo:901 / Elemento padre: 876   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(901)).setAttribute("ancho","100" );
      ((Element)v.get(901)).setAttribute("minimizable","S" );
      ((Element)v.get(901)).setAttribute("minimizada","N" );
      ((Element)v.get(876)).appendChild((Element)v.get(901));
      /* Termina nodo:901   */

      /* Empieza nodo:902 / Elemento padre: 876   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(902)).setAttribute("ancho","100" );
      ((Element)v.get(902)).setAttribute("minimizable","S" );
      ((Element)v.get(902)).setAttribute("minimizada","N" );
      ((Element)v.get(876)).appendChild((Element)v.get(902));
      /* Termina nodo:902   */
      /* Termina nodo:876   */

      /* Empieza nodo:903 / Elemento padre: 867   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(903)).setAttribute("height","20" );
      ((Element)v.get(903)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(903)).setAttribute("imgFondo","" );
      ((Element)v.get(903)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(867)).appendChild((Element)v.get(903));

      /* Empieza nodo:904 / Elemento padre: 903   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(904)).setAttribute("colFondo","" );
      ((Element)v.get(904)).setAttribute("ID","EstCab" );
      ((Element)v.get(904)).setAttribute("cod","BelParamBelce.sbacOidSbac.label" );
   }

   private void getXML4140(Document doc) {
      ((Element)v.get(903)).appendChild((Element)v.get(904));
      /* Termina nodo:904   */

      /* Empieza nodo:905 / Elemento padre: 903   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(905)).setAttribute("colFondo","" );
      ((Element)v.get(905)).setAttribute("ID","EstCab" );
      ((Element)v.get(905)).setAttribute("cod","BelParamBelce.valDire.label" );
      ((Element)v.get(903)).appendChild((Element)v.get(905));
      /* Termina nodo:905   */

      /* Empieza nodo:906 / Elemento padre: 903   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(906)).setAttribute("colFondo","" );
      ((Element)v.get(906)).setAttribute("ID","EstCab" );
      ((Element)v.get(906)).setAttribute("cod","BelParamBelce.valTfno.label" );
      ((Element)v.get(903)).appendChild((Element)v.get(906));
      /* Termina nodo:906   */

      /* Empieza nodo:907 / Elemento padre: 903   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(907)).setAttribute("colFondo","" );
      ((Element)v.get(907)).setAttribute("ID","EstCab" );
      ((Element)v.get(907)).setAttribute("cod","BelParamBelce.valMontMaxiDife.label" );
      ((Element)v.get(903)).appendChild((Element)v.get(907));
      /* Termina nodo:907   */

      /* Empieza nodo:908 / Elemento padre: 903   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(908)).setAttribute("colFondo","" );
      ((Element)v.get(908)).setAttribute("ID","EstCab" );
      ((Element)v.get(908)).setAttribute("cod","BelParamBelce.valLimiEfecCaja.label" );
      ((Element)v.get(903)).appendChild((Element)v.get(908));
      /* Termina nodo:908   */

      /* Empieza nodo:909 / Elemento padre: 903   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(909)).setAttribute("colFondo","" );
      ((Element)v.get(909)).setAttribute("ID","EstCab" );
      ((Element)v.get(909)).setAttribute("cod","BelParamBelce.numCaja.label" );
      ((Element)v.get(903)).appendChild((Element)v.get(909));
      /* Termina nodo:909   */

      /* Empieza nodo:910 / Elemento padre: 903   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(910)).setAttribute("colFondo","" );
      ((Element)v.get(910)).setAttribute("ID","EstCab" );
      ((Element)v.get(910)).setAttribute("cod","BelParamBelce.valNombLoca.label" );
      ((Element)v.get(903)).appendChild((Element)v.get(910));
      /* Termina nodo:910   */

      /* Empieza nodo:911 / Elemento padre: 903   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(911)).setAttribute("colFondo","" );
      ((Element)v.get(911)).setAttribute("ID","EstCab" );
      ((Element)v.get(911)).setAttribute("cod","BelParamBelce.valTiempRepo.label" );
      ((Element)v.get(903)).appendChild((Element)v.get(911));
      /* Termina nodo:911   */

      /* Empieza nodo:912 / Elemento padre: 903   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(912)).setAttribute("colFondo","" );
      ((Element)v.get(912)).setAttribute("ID","EstCab" );
      ((Element)v.get(912)).setAttribute("cod","BelParamBelce.valFactLoca.label" );
      ((Element)v.get(903)).appendChild((Element)v.get(912));
      /* Termina nodo:912   */

      /* Empieza nodo:913 / Elemento padre: 903   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(913)).setAttribute("colFondo","" );
      ((Element)v.get(913)).setAttribute("ID","EstCab" );
      ((Element)v.get(913)).setAttribute("cod","BelParamBelce.numMaxiProd.label" );
      ((Element)v.get(903)).appendChild((Element)v.get(913));
      /* Termina nodo:913   */

      /* Empieza nodo:914 / Elemento padre: 903   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(914)).setAttribute("colFondo","" );
      ((Element)v.get(914)).setAttribute("ID","EstCab" );
      ((Element)v.get(914)).setAttribute("cod","BelParamBelce.valAlerStoc.label" );
      ((Element)v.get(903)).appendChild((Element)v.get(914));
      /* Termina nodo:914   */

      /* Empieza nodo:915 / Elemento padre: 903   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(915)).setAttribute("colFondo","" );
      ((Element)v.get(915)).setAttribute("ID","EstCab" );
      ((Element)v.get(915)).setAttribute("cod","BelParamBelce.valUsua.label" );
      ((Element)v.get(903)).appendChild((Element)v.get(915));
      /* Termina nodo:915   */

      /* Empieza nodo:916 / Elemento padre: 903   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(916)).setAttribute("colFondo","" );
      ((Element)v.get(916)).setAttribute("ID","EstCab" );
      ((Element)v.get(916)).setAttribute("cod","BelParamBelce.clieOidClie.label" );
      ((Element)v.get(903)).appendChild((Element)v.get(916));
      /* Termina nodo:916   */

      /* Empieza nodo:917 / Elemento padre: 903   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(917)).setAttribute("colFondo","" );
      ((Element)v.get(917)).setAttribute("ID","EstCab" );
      ((Element)v.get(917)).setAttribute("cod","BelParamBelce.sociOidSoci.label" );
      ((Element)v.get(903)).appendChild((Element)v.get(917));
      /* Termina nodo:917   */

      /* Empieza nodo:918 / Elemento padre: 903   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(918)).setAttribute("colFondo","" );
      ((Element)v.get(918)).setAttribute("ID","EstCab" );
      ((Element)v.get(918)).setAttribute("cod","BelParamBelce.ttraOidTipoTran.label" );
      ((Element)v.get(903)).appendChild((Element)v.get(918));
      /* Termina nodo:918   */

      /* Empieza nodo:919 / Elemento padre: 903   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(919)).setAttribute("colFondo","" );
      ((Element)v.get(919)).setAttribute("ID","EstCab" );
      ((Element)v.get(919)).setAttribute("cod","BelParamBelce.ccbaOidCuenCorrBanc.label" );
      ((Element)v.get(903)).appendChild((Element)v.get(919));
      /* Termina nodo:919   */

      /* Empieza nodo:920 / Elemento padre: 903   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(920)).setAttribute("colFondo","" );
      ((Element)v.get(920)).setAttribute("ID","EstCab" );
      ((Element)v.get(920)).setAttribute("cod","BelParamBelce.tmvcOidCobr.label" );
      ((Element)v.get(903)).appendChild((Element)v.get(920));
      /* Termina nodo:920   */

      /* Empieza nodo:921 / Elemento padre: 903   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(921)).setAttribute("colFondo","" );
      ((Element)v.get(921)).setAttribute("ID","EstCab" );
      ((Element)v.get(921)).setAttribute("cod","BelParamBelce.tmvcOidCier.label" );
      ((Element)v.get(903)).appendChild((Element)v.get(921));
      /* Termina nodo:921   */

      /* Empieza nodo:922 / Elemento padre: 903   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(922)).setAttribute("colFondo","" );
      ((Element)v.get(922)).setAttribute("ID","EstCab" );
      ((Element)v.get(922)).setAttribute("cod","BelParamBelce.tmalOidConfStoc.label" );
   }

   private void getXML4230(Document doc) {
      ((Element)v.get(903)).appendChild((Element)v.get(922));
      /* Termina nodo:922   */

      /* Empieza nodo:923 / Elemento padre: 903   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(923)).setAttribute("colFondo","" );
      ((Element)v.get(923)).setAttribute("ID","EstCab" );
      ((Element)v.get(923)).setAttribute("cod","BelParamBelce.tmalOidConfStocTran.label" );
      ((Element)v.get(903)).appendChild((Element)v.get(923));
      /* Termina nodo:923   */

      /* Empieza nodo:924 / Elemento padre: 903   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(924)).setAttribute("colFondo","" );
      ((Element)v.get(924)).setAttribute("ID","EstCab" );
      ((Element)v.get(924)).setAttribute("cod","BelParamBelce.tmalOidStocTran.label" );
      ((Element)v.get(903)).appendChild((Element)v.get(924));
      /* Termina nodo:924   */

      /* Empieza nodo:925 / Elemento padre: 903   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(925)).setAttribute("colFondo","" );
      ((Element)v.get(925)).setAttribute("ID","EstCab" );
      ((Element)v.get(925)).setAttribute("cod","BelParamBelce.tmalOidStocDevo.label" );
      ((Element)v.get(903)).appendChild((Element)v.get(925));
      /* Termina nodo:925   */

      /* Empieza nodo:926 / Elemento padre: 903   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(926)).setAttribute("colFondo","" );
      ((Element)v.get(926)).setAttribute("ID","EstCab" );
      ((Element)v.get(926)).setAttribute("cod","BelParamBelce.tmalOidRegu.label" );
      ((Element)v.get(903)).appendChild((Element)v.get(926));
      /* Termina nodo:926   */

      /* Empieza nodo:927 / Elemento padre: 903   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(927)).setAttribute("colFondo","" );
      ((Element)v.get(927)).setAttribute("ID","EstCab" );
      ((Element)v.get(927)).setAttribute("cod","BelParamBelce.tmalOidReguSap.label" );
      ((Element)v.get(903)).appendChild((Element)v.get(927));
      /* Termina nodo:927   */

      /* Empieza nodo:928 / Elemento padre: 903   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(928)).setAttribute("colFondo","" );
      ((Element)v.get(928)).setAttribute("ID","EstCab" );
      ((Element)v.get(928)).setAttribute("cod","BelParamBelce.tmalOidDevoStoc.label" );
      ((Element)v.get(903)).appendChild((Element)v.get(928));
      /* Termina nodo:928   */

      /* Empieza nodo:929 / Elemento padre: 903   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(929)).setAttribute("colFondo","" );
      ((Element)v.get(929)).setAttribute("ID","EstCab" );
      ((Element)v.get(929)).setAttribute("cod","BelParamBelce.tmalOidPetiExis.label" );
      ((Element)v.get(903)).appendChild((Element)v.get(929));
      /* Termina nodo:929   */
      /* Termina nodo:903   */

      /* Empieza nodo:930 / Elemento padre: 867   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(930)).setAttribute("alto","22" );
      ((Element)v.get(930)).setAttribute("accion","" );
      ((Element)v.get(930)).setAttribute("tipoEnvio","seleccion" );
      ((Element)v.get(930)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(930)).setAttribute("maxSel","1" );
      ((Element)v.get(930)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(930)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(930)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(930)).setAttribute("onLoad","" );
      ((Element)v.get(930)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(867)).appendChild((Element)v.get(930));

      /* Empieza nodo:931 / Elemento padre: 930   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(931)).setAttribute("tipo","texto" );
      ((Element)v.get(931)).setAttribute("ID","EstDat" );
      ((Element)v.get(930)).appendChild((Element)v.get(931));
      /* Termina nodo:931   */

      /* Empieza nodo:932 / Elemento padre: 930   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(932)).setAttribute("tipo","texto" );
      ((Element)v.get(932)).setAttribute("ID","EstDat2" );
      ((Element)v.get(930)).appendChild((Element)v.get(932));
      /* Termina nodo:932   */

      /* Empieza nodo:933 / Elemento padre: 930   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(933)).setAttribute("tipo","texto" );
      ((Element)v.get(933)).setAttribute("ID","EstDat" );
      ((Element)v.get(930)).appendChild((Element)v.get(933));
      /* Termina nodo:933   */

      /* Empieza nodo:934 / Elemento padre: 930   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(934)).setAttribute("tipo","texto" );
      ((Element)v.get(934)).setAttribute("ID","EstDat2" );
      ((Element)v.get(930)).appendChild((Element)v.get(934));
      /* Termina nodo:934   */

      /* Empieza nodo:935 / Elemento padre: 930   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(935)).setAttribute("tipo","texto" );
      ((Element)v.get(935)).setAttribute("ID","EstDat" );
      ((Element)v.get(930)).appendChild((Element)v.get(935));
      /* Termina nodo:935   */

      /* Empieza nodo:936 / Elemento padre: 930   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(936)).setAttribute("tipo","texto" );
      ((Element)v.get(936)).setAttribute("ID","EstDat2" );
      ((Element)v.get(930)).appendChild((Element)v.get(936));
      /* Termina nodo:936   */

      /* Empieza nodo:937 / Elemento padre: 930   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(937)).setAttribute("tipo","texto" );
      ((Element)v.get(937)).setAttribute("ID","EstDat" );
      ((Element)v.get(930)).appendChild((Element)v.get(937));
      /* Termina nodo:937   */

      /* Empieza nodo:938 / Elemento padre: 930   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(938)).setAttribute("tipo","texto" );
      ((Element)v.get(938)).setAttribute("ID","EstDat2" );
      ((Element)v.get(930)).appendChild((Element)v.get(938));
      /* Termina nodo:938   */

      /* Empieza nodo:939 / Elemento padre: 930   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(939)).setAttribute("tipo","texto" );
      ((Element)v.get(939)).setAttribute("ID","EstDat" );
      ((Element)v.get(930)).appendChild((Element)v.get(939));
      /* Termina nodo:939   */

      /* Empieza nodo:940 / Elemento padre: 930   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(940)).setAttribute("tipo","texto" );
      ((Element)v.get(940)).setAttribute("ID","EstDat2" );
      ((Element)v.get(930)).appendChild((Element)v.get(940));
      /* Termina nodo:940   */

      /* Empieza nodo:941 / Elemento padre: 930   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(941)).setAttribute("tipo","texto" );
   }

   private void getXML4320(Document doc) {
      ((Element)v.get(941)).setAttribute("ID","EstDat" );
      ((Element)v.get(930)).appendChild((Element)v.get(941));
      /* Termina nodo:941   */

      /* Empieza nodo:942 / Elemento padre: 930   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(942)).setAttribute("tipo","texto" );
      ((Element)v.get(942)).setAttribute("ID","EstDat2" );
      ((Element)v.get(930)).appendChild((Element)v.get(942));
      /* Termina nodo:942   */

      /* Empieza nodo:943 / Elemento padre: 930   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(943)).setAttribute("tipo","texto" );
      ((Element)v.get(943)).setAttribute("ID","EstDat" );
      ((Element)v.get(930)).appendChild((Element)v.get(943));
      /* Termina nodo:943   */

      /* Empieza nodo:944 / Elemento padre: 930   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(944)).setAttribute("tipo","texto" );
      ((Element)v.get(944)).setAttribute("ID","EstDat2" );
      ((Element)v.get(930)).appendChild((Element)v.get(944));
      /* Termina nodo:944   */

      /* Empieza nodo:945 / Elemento padre: 930   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(945)).setAttribute("tipo","texto" );
      ((Element)v.get(945)).setAttribute("ID","EstDat" );
      ((Element)v.get(930)).appendChild((Element)v.get(945));
      /* Termina nodo:945   */

      /* Empieza nodo:946 / Elemento padre: 930   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(946)).setAttribute("tipo","texto" );
      ((Element)v.get(946)).setAttribute("ID","EstDat2" );
      ((Element)v.get(930)).appendChild((Element)v.get(946));
      /* Termina nodo:946   */

      /* Empieza nodo:947 / Elemento padre: 930   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(947)).setAttribute("tipo","texto" );
      ((Element)v.get(947)).setAttribute("ID","EstDat" );
      ((Element)v.get(930)).appendChild((Element)v.get(947));
      /* Termina nodo:947   */

      /* Empieza nodo:948 / Elemento padre: 930   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(948)).setAttribute("tipo","texto" );
      ((Element)v.get(948)).setAttribute("ID","EstDat2" );
      ((Element)v.get(930)).appendChild((Element)v.get(948));
      /* Termina nodo:948   */

      /* Empieza nodo:949 / Elemento padre: 930   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(949)).setAttribute("tipo","texto" );
      ((Element)v.get(949)).setAttribute("ID","EstDat" );
      ((Element)v.get(930)).appendChild((Element)v.get(949));
      /* Termina nodo:949   */

      /* Empieza nodo:950 / Elemento padre: 930   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(950)).setAttribute("tipo","texto" );
      ((Element)v.get(950)).setAttribute("ID","EstDat2" );
      ((Element)v.get(930)).appendChild((Element)v.get(950));
      /* Termina nodo:950   */

      /* Empieza nodo:951 / Elemento padre: 930   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(951)).setAttribute("tipo","texto" );
      ((Element)v.get(951)).setAttribute("ID","EstDat" );
      ((Element)v.get(930)).appendChild((Element)v.get(951));
      /* Termina nodo:951   */

      /* Empieza nodo:952 / Elemento padre: 930   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(952)).setAttribute("tipo","texto" );
      ((Element)v.get(952)).setAttribute("ID","EstDat2" );
      ((Element)v.get(930)).appendChild((Element)v.get(952));
      /* Termina nodo:952   */

      /* Empieza nodo:953 / Elemento padre: 930   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(953)).setAttribute("tipo","texto" );
      ((Element)v.get(953)).setAttribute("ID","EstDat" );
      ((Element)v.get(930)).appendChild((Element)v.get(953));
      /* Termina nodo:953   */

      /* Empieza nodo:954 / Elemento padre: 930   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(954)).setAttribute("tipo","texto" );
      ((Element)v.get(954)).setAttribute("ID","EstDat2" );
      ((Element)v.get(930)).appendChild((Element)v.get(954));
      /* Termina nodo:954   */

      /* Empieza nodo:955 / Elemento padre: 930   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(955)).setAttribute("tipo","texto" );
      ((Element)v.get(955)).setAttribute("ID","EstDat" );
      ((Element)v.get(930)).appendChild((Element)v.get(955));
      /* Termina nodo:955   */

      /* Empieza nodo:956 / Elemento padre: 930   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(956)).setAttribute("tipo","texto" );
      ((Element)v.get(956)).setAttribute("ID","EstDat2" );
      ((Element)v.get(930)).appendChild((Element)v.get(956));
      /* Termina nodo:956   */
      /* Termina nodo:930   */

      /* Empieza nodo:957 / Elemento padre: 867   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(867)).appendChild((Element)v.get(957));
      /* Termina nodo:957   */
      /* Termina nodo:867   */
      /* Termina nodo:866   */

      /* Empieza nodo:958 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(958)).setAttribute("nombre","belParamBelceListButtonsLayer" );
      ((Element)v.get(958)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(958)).setAttribute("alto","30" );
      ((Element)v.get(958)).setAttribute("ancho","98%" );
      ((Element)v.get(958)).setAttribute("borde","n" );
      ((Element)v.get(958)).setAttribute("imagenf","" );
      ((Element)v.get(958)).setAttribute("repeat","" );
      ((Element)v.get(958)).setAttribute("padding","0" );
      ((Element)v.get(958)).setAttribute("contravsb","" );
      ((Element)v.get(958)).setAttribute("x","16" );
      ((Element)v.get(958)).setAttribute("y","" );
      ((Element)v.get(958)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(958));

      /* Empieza nodo:959 / Elemento padre: 958   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(959)).setAttribute("nombre","toolbarSeparatorLayer" );
      ((Element)v.get(959)).setAttribute("visibilidad","inherit" );
      ((Element)v.get(959)).setAttribute("alto","23" );
      ((Element)v.get(959)).setAttribute("ancho","1" );
      ((Element)v.get(959)).setAttribute("borde","1" );
      ((Element)v.get(959)).setAttribute("imagenf","" );
      ((Element)v.get(959)).setAttribute("repeat","" );
      ((Element)v.get(959)).setAttribute("padding","0" );
      ((Element)v.get(959)).setAttribute("contravsb","" );
      ((Element)v.get(959)).setAttribute("x","56" );
      ((Element)v.get(959)).setAttribute("y","0" );
   }

   private void getXML4410(Document doc) {
      ((Element)v.get(959)).setAttribute("zindex","" );
      ((Element)v.get(959)).setAttribute("colborde","#999999" );
      ((Element)v.get(958)).appendChild((Element)v.get(959));
      /* Termina nodo:959   */

      /* Empieza nodo:960 / Elemento padre: 958   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(960)).setAttribute("width","100%" );
      ((Element)v.get(960)).setAttribute("border","0" );
      ((Element)v.get(960)).setAttribute("cellspacing","1" );
      ((Element)v.get(960)).setAttribute("cellpadding","0" );
      ((Element)v.get(958)).appendChild((Element)v.get(960));

      /* Empieza nodo:961 / Elemento padre: 960   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(960)).appendChild((Element)v.get(961));

      /* Empieza nodo:962 / Elemento padre: 961   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(962)).setAttribute("src","b.gif" );
      ((Element)v.get(962)).setAttribute("height","22" );
      ((Element)v.get(962)).setAttribute("width","5" );
      ((Element)v.get(961)).appendChild((Element)v.get(962));
      /* Termina nodo:962   */
      /* Termina nodo:961   */

      /* Empieza nodo:963 / Elemento padre: 960   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(960)).appendChild((Element)v.get(963));

      /* Empieza nodo:964 / Elemento padre: 963   */
      v.add(doc.createElement("BOTONERA"));
      ((Element)v.get(964)).setAttribute("nombre","belParamBelcePaginationButtonBar" );
      ((Element)v.get(964)).setAttribute("tipo","H" );
      ((Element)v.get(964)).setAttribute("x","0" );
      ((Element)v.get(964)).setAttribute("y","0" );
      ((Element)v.get(963)).appendChild((Element)v.get(964));

      /* Empieza nodo:965 / Elemento padre: 964   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(965)).setAttribute("nombre","belParamBelceFirstPageButton" );
      ((Element)v.get(965)).setAttribute("funcion","belParamBelceFirstPage();" );
      ((Element)v.get(965)).setAttribute("off","primera_over0.gif" );
      ((Element)v.get(965)).setAttribute("on","primera_over0.gif" );
      ((Element)v.get(965)).setAttribute("disable","primera_on0.gif" );
      ((Element)v.get(965)).setAttribute("estado","inactivo" );
      ((Element)v.get(964)).appendChild((Element)v.get(965));
      /* Termina nodo:965   */

      /* Empieza nodo:966 / Elemento padre: 964   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(966)).setAttribute("nombre","belParamBelceFirstPageButtonGapTd" );
      ((Element)v.get(964)).appendChild((Element)v.get(966));

      /* Empieza nodo:967 / Elemento padre: 966   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(967)).setAttribute("src","b.gif" );
      ((Element)v.get(967)).setAttribute("height","8" );
      ((Element)v.get(967)).setAttribute("width","5" );
      ((Element)v.get(966)).appendChild((Element)v.get(967));
      /* Termina nodo:967   */
      /* Termina nodo:966   */

      /* Empieza nodo:968 / Elemento padre: 964   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(968)).setAttribute("nombre","belParamBelcePreviousPageButton" );
      ((Element)v.get(968)).setAttribute("funcion","belParamBelcePreviousPage();" );
      ((Element)v.get(968)).setAttribute("off","retroceder_over0.gif" );
      ((Element)v.get(968)).setAttribute("on","retroceder_over0.gif" );
      ((Element)v.get(968)).setAttribute("disable","retroceder_on0.gif" );
      ((Element)v.get(968)).setAttribute("estado","inactivo" );
      ((Element)v.get(964)).appendChild((Element)v.get(968));
      /* Termina nodo:968   */

      /* Empieza nodo:969 / Elemento padre: 964   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(969)).setAttribute("nombre","belParamBelcePreviousPageButtonGapTd" );
      ((Element)v.get(964)).appendChild((Element)v.get(969));

      /* Empieza nodo:970 / Elemento padre: 969   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(970)).setAttribute("src","b.gif" );
      ((Element)v.get(970)).setAttribute("height","8" );
      ((Element)v.get(970)).setAttribute("width","8" );
      ((Element)v.get(969)).appendChild((Element)v.get(970));
      /* Termina nodo:970   */
      /* Termina nodo:969   */

      /* Empieza nodo:971 / Elemento padre: 964   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(971)).setAttribute("nombre","belParamBelceNextPageButton" );
      ((Element)v.get(971)).setAttribute("funcion","belParamBelceNextPage();" );
      ((Element)v.get(971)).setAttribute("off","avanzar_over0.gif" );
      ((Element)v.get(971)).setAttribute("on","avanzar_over0.gif" );
      ((Element)v.get(971)).setAttribute("disable","avanzar_on0.gif" );
      ((Element)v.get(971)).setAttribute("estado","inactivo" );
      ((Element)v.get(964)).appendChild((Element)v.get(971));
      /* Termina nodo:971   */
      /* Termina nodo:964   */
      /* Termina nodo:963   */

      /* Empieza nodo:972 / Elemento padre: 960   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(960)).appendChild((Element)v.get(972));

      /* Empieza nodo:973 / Elemento padre: 972   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(973)).setAttribute("src","b.gif" );
      ((Element)v.get(973)).setAttribute("height","22" );
      ((Element)v.get(973)).setAttribute("width","19" );
      ((Element)v.get(972)).appendChild((Element)v.get(973));
      /* Termina nodo:973   */
      /* Termina nodo:972   */

      /* Empieza nodo:974 / Elemento padre: 960   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(974)).setAttribute("class","tablaTitle" );
      ((Element)v.get(974)).setAttribute("nombre","belParamBelceUpdateButtonTd" );
      ((Element)v.get(960)).appendChild((Element)v.get(974));

      /* Empieza nodo:975 / Elemento padre: 974   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(975)).setAttribute("nombre","belParamBelceUpdateButton" );
      ((Element)v.get(975)).setAttribute("ID","botonContenido" );
      ((Element)v.get(975)).setAttribute("tipo","html" );
      ((Element)v.get(975)).setAttribute("accion","belParamBelceUpdateSelection();" );
      ((Element)v.get(975)).setAttribute("estado","false" );
      ((Element)v.get(975)).setAttribute("cod","MMGGlobal.updateButton.label" );
      ((Element)v.get(974)).appendChild((Element)v.get(975));
      /* Termina nodo:975   */
      /* Termina nodo:974   */

      /* Empieza nodo:976 / Elemento padre: 960   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(976)).setAttribute("nombre","belParamBelceUpdateButtonGapTd" );
      ((Element)v.get(960)).appendChild((Element)v.get(976));

      /* Empieza nodo:977 / Elemento padre: 976   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(977)).setAttribute("src","b.gif" );
      ((Element)v.get(977)).setAttribute("height","8" );
      ((Element)v.get(977)).setAttribute("width","10" );
   }

   private void getXML4500(Document doc) {
      ((Element)v.get(976)).appendChild((Element)v.get(977));
      /* Termina nodo:977   */
      /* Termina nodo:976   */

      /* Empieza nodo:978 / Elemento padre: 960   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(978)).setAttribute("class","tablaTitle" );
      ((Element)v.get(978)).setAttribute("nombre","belParamBelceViewForRemoveButtonTd" );
      ((Element)v.get(960)).appendChild((Element)v.get(978));

      /* Empieza nodo:979 / Elemento padre: 978   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(979)).setAttribute("nombre","belParamBelceViewForRemoveButton" );
      ((Element)v.get(979)).setAttribute("ID","botonContenido" );
      ((Element)v.get(979)).setAttribute("tipo","html" );
      ((Element)v.get(979)).setAttribute("accion","belParamBelceViewSelection();" );
      ((Element)v.get(979)).setAttribute("estado","false" );
      ((Element)v.get(979)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(978)).appendChild((Element)v.get(979));
      /* Termina nodo:979   */
      /* Termina nodo:978   */

      /* Empieza nodo:980 / Elemento padre: 960   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(980)).setAttribute("nombre","belParamBelceViewForRemoveButtonGapTd" );
      ((Element)v.get(960)).appendChild((Element)v.get(980));

      /* Empieza nodo:981 / Elemento padre: 980   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(981)).setAttribute("src","b.gif" );
      ((Element)v.get(981)).setAttribute("height","8" );
      ((Element)v.get(981)).setAttribute("width","10" );
      ((Element)v.get(980)).appendChild((Element)v.get(981));
      /* Termina nodo:981   */
      /* Termina nodo:980   */

      /* Empieza nodo:982 / Elemento padre: 960   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(982)).setAttribute("class","tablaTitle" );
      ((Element)v.get(982)).setAttribute("nombre","belParamBelceLovSelectButtonTd" );
      ((Element)v.get(960)).appendChild((Element)v.get(982));

      /* Empieza nodo:983 / Elemento padre: 982   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(983)).setAttribute("nombre","belParamBelceLovSelectButton" );
      ((Element)v.get(983)).setAttribute("ID","botonContenido" );
      ((Element)v.get(983)).setAttribute("tipo","html" );
      ((Element)v.get(983)).setAttribute("accion","belParamBelceLovSelectionAction();" );
      ((Element)v.get(983)).setAttribute("estado","true" );
      ((Element)v.get(983)).setAttribute("cod","MMGGlobal.lovSelectButton.label" );
      ((Element)v.get(982)).appendChild((Element)v.get(983));
      /* Termina nodo:983   */
      /* Termina nodo:982   */

      /* Empieza nodo:984 / Elemento padre: 960   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(984)).setAttribute("nombre","belParamBelceLovSelectButtonGapTd" );
      ((Element)v.get(960)).appendChild((Element)v.get(984));

      /* Empieza nodo:985 / Elemento padre: 984   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(985)).setAttribute("src","b.gif" );
      ((Element)v.get(985)).setAttribute("height","8" );
      ((Element)v.get(985)).setAttribute("width","10" );
      ((Element)v.get(984)).appendChild((Element)v.get(985));
      /* Termina nodo:985   */
      /* Termina nodo:984   */

      /* Empieza nodo:986 / Elemento padre: 960   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(986)).setAttribute("class","tablaTitle" );
      ((Element)v.get(986)).setAttribute("nombre","belParamBelceViewButtonTd" );
      ((Element)v.get(960)).appendChild((Element)v.get(986));

      /* Empieza nodo:987 / Elemento padre: 986   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(987)).setAttribute("nombre","belParamBelceViewButton" );
      ((Element)v.get(987)).setAttribute("ID","botonContenido" );
      ((Element)v.get(987)).setAttribute("tipo","html" );
      ((Element)v.get(987)).setAttribute("accion","belParamBelceViewSelection();" );
      ((Element)v.get(987)).setAttribute("estado","false" );
      ((Element)v.get(987)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(986)).appendChild((Element)v.get(987));
      /* Termina nodo:987   */
      /* Termina nodo:986   */

      /* Empieza nodo:988 / Elemento padre: 960   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(988)).setAttribute("nombre","belParamBelceViewButtonGapTd" );
      ((Element)v.get(960)).appendChild((Element)v.get(988));

      /* Empieza nodo:989 / Elemento padre: 988   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(989)).setAttribute("src","b.gif" );
      ((Element)v.get(989)).setAttribute("height","8" );
      ((Element)v.get(989)).setAttribute("width","10" );
      ((Element)v.get(988)).appendChild((Element)v.get(989));
      /* Termina nodo:989   */
      /* Termina nodo:988   */

      /* Empieza nodo:990 / Elemento padre: 960   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(990)).setAttribute("width","100%" );
      ((Element)v.get(960)).appendChild((Element)v.get(990));
      /* Termina nodo:990   */
      /* Termina nodo:960   */
      /* Termina nodo:958   */
      /* Termina nodo:4   */


   }

}


import org.w3c.dom.*;
import java.util.ArrayList;

public class CarParamCartePage  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","CarParamCartePage" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","carParamCarteInitComponents()" );
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
      ((Element)v.get(3)).setAttribute("src","carparamcarte.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(4)).setAttribute("nombre","carParamCarteFrm" );
      ((Element)v.get(4)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(5)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(5)).setAttribute("valor","CarParamCarteLPExecution" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","ON" );
      ((Element)v.get(6)).setAttribute("valor","CarParamCarteLPExecution" );
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
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(24)).setAttribute("nombre","carParamCarteFormLayer" );
      ((Element)v.get(24)).setAttribute("alto","" );
      ((Element)v.get(24)).setAttribute("ancho","100%" );
      ((Element)v.get(24)).setAttribute("colorf","" );
      ((Element)v.get(24)).setAttribute("borde","0" );
      ((Element)v.get(24)).setAttribute("imagenf","" );
      ((Element)v.get(24)).setAttribute("repeat","" );
      ((Element)v.get(24)).setAttribute("padding","" );
      ((Element)v.get(24)).setAttribute("visibilidad","visible" );
      ((Element)v.get(24)).setAttribute("contravsb","" );
      ((Element)v.get(24)).setAttribute("x","0" );
      ((Element)v.get(24)).setAttribute("y","0" );
      ((Element)v.get(24)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(24));

      /* Empieza nodo:25 / Elemento padre: 24   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(25)).setAttribute("width","100%" );
      ((Element)v.get(25)).setAttribute("border","0" );
      ((Element)v.get(25)).setAttribute("cellspacing","0" );
      ((Element)v.get(25)).setAttribute("cellpadding","0" );
      ((Element)v.get(25)).setAttribute("align","left" );
      ((Element)v.get(24)).appendChild((Element)v.get(25));

      /* Empieza nodo:26 / Elemento padre: 25   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(25)).appendChild((Element)v.get(26));

      /* Empieza nodo:27 / Elemento padre: 26   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(27)).setAttribute("align","center" );
      ((Element)v.get(27)).setAttribute("width","12" );
      ((Element)v.get(26)).appendChild((Element)v.get(27));

      /* Empieza nodo:28 / Elemento padre: 27   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(28)).setAttribute("src","b.gif" );
      ((Element)v.get(28)).setAttribute("width","12" );
      ((Element)v.get(28)).setAttribute("height","12" );
      ((Element)v.get(27)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */
      /* Termina nodo:27   */

      /* Empieza nodo:29 / Elemento padre: 26   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(29)).setAttribute("align","center" );
      ((Element)v.get(29)).setAttribute("width","750" );
      ((Element)v.get(26)).appendChild((Element)v.get(29));

      /* Empieza nodo:30 / Elemento padre: 29   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(30)).setAttribute("src","b.gif" );
      ((Element)v.get(30)).setAttribute("width","12" );
      ((Element)v.get(30)).setAttribute("height","12" );
      ((Element)v.get(29)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */
      /* Termina nodo:29   */

      /* Empieza nodo:31 / Elemento padre: 26   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(31)).setAttribute("align","center" );
      ((Element)v.get(31)).setAttribute("width","12" );
      ((Element)v.get(26)).appendChild((Element)v.get(31));

      /* Empieza nodo:32 / Elemento padre: 31   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(32)).setAttribute("src","b.gif" );
      ((Element)v.get(32)).setAttribute("width","12" );
      ((Element)v.get(32)).setAttribute("height","12" );
      ((Element)v.get(31)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */
      /* Termina nodo:31   */
      /* Termina nodo:26   */

      /* Empieza nodo:33 / Elemento padre: 25   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(25)).appendChild((Element)v.get(33));

      /* Empieza nodo:34 / Elemento padre: 33   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(34)).setAttribute("align","center" );
      ((Element)v.get(34)).setAttribute("width","12" );
      ((Element)v.get(33)).appendChild((Element)v.get(34));

      /* Empieza nodo:35 / Elemento padre: 34   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(35)).setAttribute("src","b.gif" );
      ((Element)v.get(35)).setAttribute("width","12" );
      ((Element)v.get(35)).setAttribute("height","8" );
      ((Element)v.get(34)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */
      /* Termina nodo:34   */

      /* Empieza nodo:36 / Elemento padre: 33   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(33)).appendChild((Element)v.get(36));

      /* Empieza nodo:37 / Elemento padre: 36   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(36)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(38)).setAttribute("class","legend" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(39)).setAttribute("nombre","legendLbl" );
      ((Element)v.get(39)).setAttribute("alto","13" );
      ((Element)v.get(39)).setAttribute("filas","1" );
      ((Element)v.get(39)).setAttribute("id","legend" );
      ((Element)v.get(39)).setAttribute("valor","" );
      ((Element)v.get(39)).setAttribute("cod","CarParamCarte.legend.label" );
      ((Element)v.get(38)).appendChild((Element)v.get(39));
      /* Termina nodo:39   */
      /* Termina nodo:38   */

      /* Empieza nodo:40 / Elemento padre: 37   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(40)).setAttribute("width","100%" );
      ((Element)v.get(40)).setAttribute("border","0" );
      ((Element)v.get(40)).setAttribute("align","center" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(40)).setAttribute("cellspacing","0" );
      ((Element)v.get(40)).setAttribute("cellpadding","0" );
      ((Element)v.get(37)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(40)).appendChild((Element)v.get(41));

      /* Empieza nodo:42 / Elemento padre: 41   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(42)).setAttribute("width","100%" );
      ((Element)v.get(42)).setAttribute("nowrap","true" );
      ((Element)v.get(42)).setAttribute("class","datosCampos" );
      ((Element)v.get(42)).setAttribute("colspan","3" );
      ((Element)v.get(41)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","8" );
      ((Element)v.get(43)).setAttribute("height","8" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */
      /* Termina nodo:41   */

      /* Empieza nodo:44 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(44)).setAttribute("nombre","formTr0" );
      ((Element)v.get(40)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(45)).setAttribute("align","center" );
      ((Element)v.get(45)).setAttribute("width","12" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));

      /* Empieza nodo:46 / Elemento padre: 45   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(46)).setAttribute("src","b.gif" );
      ((Element)v.get(46)).setAttribute("width","12" );
      ((Element)v.get(46)).setAttribute("height","12" );
      ((Element)v.get(45)).appendChild((Element)v.get(46));
      /* Termina nodo:46   */
      /* Termina nodo:45   */

      /* Empieza nodo:47 / Elemento padre: 44   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(47)).setAttribute("width","100%" );
      ((Element)v.get(44)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(48)).setAttribute("width","100%" );
      ((Element)v.get(48)).setAttribute("border","0" );
      ((Element)v.get(48)).setAttribute("cellspacing","0" );
      ((Element)v.get(48)).setAttribute("cellpadding","0" );
      ((Element)v.get(48)).setAttribute("align","left" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));

      /* Empieza nodo:49 / Elemento padre: 48   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(49)).setAttribute("align","left" );
      ((Element)v.get(48)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(50)).setAttribute("nombre","idTdId" );
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(51)).setAttribute("width","100%" );
      ((Element)v.get(51)).setAttribute("border","0" );
      ((Element)v.get(51)).setAttribute("cellspacing","0" );
      ((Element)v.get(51)).setAttribute("cellpadding","0" );
      ((Element)v.get(51)).setAttribute("align","left" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(51)).appendChild((Element)v.get(52));

      /* Empieza nodo:53 / Elemento padre: 52   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(53)).setAttribute("valign","top" );
      ((Element)v.get(53)).setAttribute("height","13" );
      ((Element)v.get(52)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(54)).setAttribute("nombre","lblId" );
      ((Element)v.get(54)).setAttribute("alto","13" );
      ((Element)v.get(54)).setAttribute("filas","1" );
      ((Element)v.get(54)).setAttribute("id","datosTitle" );
      ((Element)v.get(54)).setAttribute("cod","CarParamCarte.id.label" );
      ((Element)v.get(53)).appendChild((Element)v.get(54));
      /* Termina nodo:54   */
      /* Termina nodo:53   */
      /* Termina nodo:52   */

      /* Empieza nodo:55 / Elemento padre: 51   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(55)).setAttribute("nombre","idWidgetTrId" );
      ((Element)v.get(51)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(56)).setAttribute("align","left" );
      ((Element)v.get(56)).setAttribute("nowrap","true" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));

      /* Empieza nodo:57 / Elemento padre: 56   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(57)).setAttribute("nombre","id" );
      ((Element)v.get(57)).setAttribute("id","datosCampos" );
      ((Element)v.get(57)).setAttribute("trim","S" );
      ((Element)v.get(57)).setAttribute("max","12" );
      ((Element)v.get(57)).setAttribute("onchange","" );
      ((Element)v.get(57)).setAttribute("req","N" );
      ((Element)v.get(57)).setAttribute("size","12" );
      ((Element)v.get(57)).setAttribute("valor","" );
      ((Element)v.get(57)).setAttribute("validacion","" );
      ((Element)v.get(57)).setAttribute("onblur","" );
      ((Element)v.get(57)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true)" );
      ((Element)v.get(57)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm', 0, false)" );
      ((Element)v.get(56)).appendChild((Element)v.get(57));
      /* Termina nodo:57   */
      /* Termina nodo:56   */
      /* Termina nodo:55   */

      /* Empieza nodo:58 / Elemento padre: 51   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(58)).setAttribute("nombre","idViewLabelTrId" );
      ((Element)v.get(51)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(59)).setAttribute("valign","top" );
   }

   private void getXML270(Document doc) {
      ((Element)v.get(59)).setAttribute("height","13" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));

      /* Empieza nodo:60 / Elemento padre: 59   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(60)).setAttribute("nombre","lblViewId" );
      ((Element)v.get(60)).setAttribute("alto","13" );
      ((Element)v.get(60)).setAttribute("ancho","100" );
      ((Element)v.get(60)).setAttribute("id","EstDat" );
      ((Element)v.get(60)).setAttribute("valor","" );
      ((Element)v.get(59)).appendChild((Element)v.get(60));
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:58   */
      /* Termina nodo:51   */
      /* Termina nodo:50   */

      /* Empieza nodo:61 / Elemento padre: 49   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(61)).setAttribute("nombre","idGapTdId" );
      ((Element)v.get(61)).setAttribute("nowrap","true" );
      ((Element)v.get(61)).setAttribute("class","datosCampos" );
      ((Element)v.get(49)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(62)).setAttribute("src","b.gif" );
      ((Element)v.get(62)).setAttribute("width","25" );
      ((Element)v.get(62)).setAttribute("height","8" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));
      /* Termina nodo:62   */
      /* Termina nodo:61   */

      /* Empieza nodo:63 / Elemento padre: 49   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(63)).setAttribute("width","100%" );
      ((Element)v.get(49)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(64)).setAttribute("src","b.gif" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));
      /* Termina nodo:64   */
      /* Termina nodo:63   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */
      /* Termina nodo:47   */
      /* Termina nodo:44   */

      /* Empieza nodo:65 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(65)).setAttribute("nombre","formGapTr0" );
      ((Element)v.get(40)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(66)).setAttribute("align","center" );
      ((Element)v.get(66)).setAttribute("width","12" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(67)).setAttribute("src","b.gif" );
      ((Element)v.get(67)).setAttribute("width","12" );
      ((Element)v.get(67)).setAttribute("height","8" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */

      /* Empieza nodo:68 / Elemento padre: 65   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(65)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(69)).setAttribute("src","b.gif" );
      ((Element)v.get(69)).setAttribute("width","8" );
      ((Element)v.get(69)).setAttribute("height","8" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));
      /* Termina nodo:69   */
      /* Termina nodo:68   */

      /* Empieza nodo:70 / Elemento padre: 65   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(70)).setAttribute("align","center" );
      ((Element)v.get(70)).setAttribute("width","12" );
      ((Element)v.get(65)).appendChild((Element)v.get(70));

      /* Empieza nodo:71 / Elemento padre: 70   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(71)).setAttribute("src","b.gif" );
      ((Element)v.get(71)).setAttribute("width","12" );
      ((Element)v.get(71)).setAttribute("height","8" );
      ((Element)v.get(70)).appendChild((Element)v.get(71));
      /* Termina nodo:71   */
      /* Termina nodo:70   */
      /* Termina nodo:65   */

      /* Empieza nodo:72 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(72)).setAttribute("nombre","formTr1" );
      ((Element)v.get(40)).appendChild((Element)v.get(72));

      /* Empieza nodo:73 / Elemento padre: 72   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(73)).setAttribute("align","center" );
      ((Element)v.get(73)).setAttribute("width","12" );
      ((Element)v.get(72)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(74)).setAttribute("width","12" );
      ((Element)v.get(74)).setAttribute("height","12" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:75 / Elemento padre: 72   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(75)).setAttribute("width","100%" );
      ((Element)v.get(72)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(76)).setAttribute("width","100%" );
      ((Element)v.get(76)).setAttribute("border","0" );
      ((Element)v.get(76)).setAttribute("cellspacing","0" );
      ((Element)v.get(76)).setAttribute("cellpadding","0" );
      ((Element)v.get(76)).setAttribute("align","left" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(77)).setAttribute("align","left" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));

      /* Empieza nodo:78 / Elemento padre: 77   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(78)).setAttribute("nombre","paisOidPais_moneOidMoneAltTdId" );
      ((Element)v.get(77)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(79)).setAttribute("border","0" );
      ((Element)v.get(79)).setAttribute("cellspacing","0" );
      ((Element)v.get(79)).setAttribute("cellpadding","0" );
      ((Element)v.get(79)).setAttribute("align","left" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("TD"));
   }

   private void getXML360(Document doc) {
      ((Element)v.get(81)).setAttribute("valign","top" );
      ((Element)v.get(81)).setAttribute("height","13" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));

      /* Empieza nodo:82 / Elemento padre: 81   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(82)).setAttribute("nombre","lblpaisOidPais_moneOidMoneAlt" );
      ((Element)v.get(82)).setAttribute("id","datosTitle" );
      ((Element)v.get(82)).setAttribute("ancho","100" );
      ((Element)v.get(82)).setAttribute("alto","13" );
      ((Element)v.get(82)).setAttribute("cod","SegPais.moneOidMoneAlt.label" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:83 / Elemento padre: 79   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(83)).setAttribute("nombre","paisOidPais_moneOidMoneAltWidgetTrId" );
      ((Element)v.get(79)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(84)).setAttribute("align","left" );
      ((Element)v.get(84)).setAttribute("nowrap","true" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(85)).setAttribute("nombre","paisOidPais_moneOidMoneAlt" );
      ((Element)v.get(85)).setAttribute("id","datosCampos" );
      ((Element)v.get(85)).setAttribute("multiple","N" );
      ((Element)v.get(85)).setAttribute("req","N" );
      ((Element)v.get(85)).setAttribute("size","1" );
      ((Element)v.get(85)).setAttribute("validacion","" );
      ((Element)v.get(85)).setAttribute("onchange","mmgDependeneChange('paisOidPais_moneOidMoneAlt', 'paisOidPais' , 'carParamCarte')" );
      ((Element)v.get(85)).setAttribute("onfocus","" );
      ((Element)v.get(85)).setAttribute("valorinicial","" );
      ((Element)v.get(85)).setAttribute("textoinicial","" );
      ((Element)v.get(85)).setAttribute("ontab","focaliza('carParamCarteFrm.paisOidPais_moneOidMone');" );
      ((Element)v.get(85)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm',0, false);" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(85)).appendChild((Element)v.get(86));
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:87 / Elemento padre: 79   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(87)).setAttribute("nombre","paisOidPais_moneOidMoneAltViewLabelTrId" );
      ((Element)v.get(79)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(88)).setAttribute("valign","top" );
      ((Element)v.get(88)).setAttribute("height","13" );
      ((Element)v.get(88)).setAttribute("width","30" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(89)).setAttribute("nombre","lblViewPaisOidPais_moneOidMoneAlt" );
      ((Element)v.get(89)).setAttribute("alto","13" );
      ((Element)v.get(89)).setAttribute("filas","1" );
      ((Element)v.get(89)).setAttribute("id","EstDat" );
      ((Element)v.get(89)).setAttribute("valor","" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));
      /* Termina nodo:89   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:90 / Elemento padre: 77   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(90)).setAttribute("nombre","paisOidPaisGapTdId" );
      ((Element)v.get(90)).setAttribute("nowrap","true" );
      ((Element)v.get(90)).setAttribute("class","datosCampos" );
      ((Element)v.get(77)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(91)).setAttribute("src","b.gif" );
      ((Element)v.get(91)).setAttribute("width","25" );
      ((Element)v.get(91)).setAttribute("height","8" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:92 / Elemento padre: 77   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(92)).setAttribute("nombre","paisOidPais_moneOidMoneTdId" );
      ((Element)v.get(77)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(93)).setAttribute("border","0" );
      ((Element)v.get(93)).setAttribute("cellspacing","0" );
      ((Element)v.get(93)).setAttribute("cellpadding","0" );
      ((Element)v.get(93)).setAttribute("align","left" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(95)).setAttribute("valign","top" );
      ((Element)v.get(95)).setAttribute("height","13" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(96)).setAttribute("nombre","lblpaisOidPais_moneOidMone" );
      ((Element)v.get(96)).setAttribute("id","datosTitle" );
      ((Element)v.get(96)).setAttribute("ancho","100" );
      ((Element)v.get(96)).setAttribute("alto","13" );
      ((Element)v.get(96)).setAttribute("cod","SegPais.moneOidMone.label" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:97 / Elemento padre: 93   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(97)).setAttribute("nombre","paisOidPais_moneOidMoneWidgetTrId" );
      ((Element)v.get(93)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(98)).setAttribute("align","left" );
      ((Element)v.get(98)).setAttribute("nowrap","true" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(99)).setAttribute("nombre","paisOidPais_moneOidMone" );
      ((Element)v.get(99)).setAttribute("id","datosCampos" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(99)).setAttribute("multiple","N" );
      ((Element)v.get(99)).setAttribute("req","N" );
      ((Element)v.get(99)).setAttribute("size","1" );
      ((Element)v.get(99)).setAttribute("validacion","" );
      ((Element)v.get(99)).setAttribute("onchange","mmgDependeneChange('paisOidPais_moneOidMone', 'paisOidPais' , 'carParamCarte')" );
      ((Element)v.get(99)).setAttribute("onfocus","" );
      ((Element)v.get(99)).setAttribute("valorinicial","" );
      ((Element)v.get(99)).setAttribute("textoinicial","" );
      ((Element)v.get(99)).setAttribute("ontab","focaliza('carParamCarteFrm.paisOidPais_fopaOidFormPago');" );
      ((Element)v.get(99)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm',0, false);" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(99)).appendChild((Element)v.get(100));
      /* Termina nodo:100   */
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:101 / Elemento padre: 93   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(101)).setAttribute("nombre","paisOidPais_moneOidMoneViewLabelTrId" );
      ((Element)v.get(93)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(102)).setAttribute("valign","top" );
      ((Element)v.get(102)).setAttribute("height","13" );
      ((Element)v.get(102)).setAttribute("width","30" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(103)).setAttribute("nombre","lblViewPaisOidPais_moneOidMone" );
      ((Element)v.get(103)).setAttribute("alto","13" );
      ((Element)v.get(103)).setAttribute("filas","1" );
      ((Element)v.get(103)).setAttribute("id","EstDat" );
      ((Element)v.get(103)).setAttribute("valor","" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */

      /* Empieza nodo:104 / Elemento padre: 77   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(104)).setAttribute("nombre","paisOidPaisGapTdId" );
      ((Element)v.get(104)).setAttribute("nowrap","true" );
      ((Element)v.get(104)).setAttribute("class","datosCampos" );
      ((Element)v.get(77)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","25" );
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 77   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(106)).setAttribute("nombre","paisOidPais_fopaOidFormPagoTdId" );
      ((Element)v.get(77)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(107)).setAttribute("border","0" );
      ((Element)v.get(107)).setAttribute("cellspacing","0" );
      ((Element)v.get(107)).setAttribute("cellpadding","0" );
      ((Element)v.get(107)).setAttribute("align","left" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(109)).setAttribute("valign","top" );
      ((Element)v.get(109)).setAttribute("height","13" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(110)).setAttribute("nombre","lblpaisOidPais_fopaOidFormPago" );
      ((Element)v.get(110)).setAttribute("id","datosTitle" );
      ((Element)v.get(110)).setAttribute("ancho","100" );
      ((Element)v.get(110)).setAttribute("alto","13" );
      ((Element)v.get(110)).setAttribute("cod","SegPais.fopaOidFormPago.label" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:111 / Elemento padre: 107   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(111)).setAttribute("nombre","paisOidPais_fopaOidFormPagoWidgetTrId" );
      ((Element)v.get(107)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(112)).setAttribute("align","left" );
      ((Element)v.get(112)).setAttribute("nowrap","true" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(113)).setAttribute("nombre","paisOidPais_fopaOidFormPago" );
      ((Element)v.get(113)).setAttribute("id","datosCampos" );
      ((Element)v.get(113)).setAttribute("multiple","N" );
      ((Element)v.get(113)).setAttribute("req","N" );
      ((Element)v.get(113)).setAttribute("size","1" );
      ((Element)v.get(113)).setAttribute("validacion","" );
      ((Element)v.get(113)).setAttribute("onchange","mmgDependeneChange('paisOidPais_fopaOidFormPago', 'paisOidPais' , 'carParamCarte')" );
      ((Element)v.get(113)).setAttribute("onfocus","" );
      ((Element)v.get(113)).setAttribute("valorinicial","" );
      ((Element)v.get(113)).setAttribute("textoinicial","" );
      ((Element)v.get(113)).setAttribute("ontab","focaliza('carParamCarteFrm.paisOidPais');" );
      ((Element)v.get(113)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm',0, false);" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:115 / Elemento padre: 107   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(115)).setAttribute("nombre","paisOidPais_fopaOidFormPagoViewLabelTrId" );
      ((Element)v.get(107)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(116)).setAttribute("valign","top" );
      ((Element)v.get(116)).setAttribute("height","13" );
      ((Element)v.get(116)).setAttribute("width","30" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(117)).setAttribute("nombre","lblViewPaisOidPais_fopaOidFormPago" );
      ((Element)v.get(117)).setAttribute("alto","13" );
      ((Element)v.get(117)).setAttribute("filas","1" );
      ((Element)v.get(117)).setAttribute("id","EstDat" );
      ((Element)v.get(117)).setAttribute("valor","" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:107   */
      /* Termina nodo:106   */

      /* Empieza nodo:118 / Elemento padre: 77   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(118)).setAttribute("nombre","paisOidPaisGapTdId" );
      ((Element)v.get(118)).setAttribute("nowrap","true" );
      ((Element)v.get(118)).setAttribute("class","datosCampos" );
      ((Element)v.get(77)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).setAttribute("width","25" );
      ((Element)v.get(119)).setAttribute("height","8" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 77   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(120)).setAttribute("nombre","paisOidPaisTdId" );
      ((Element)v.get(77)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(121)).setAttribute("border","0" );
      ((Element)v.get(121)).setAttribute("cellspacing","0" );
      ((Element)v.get(121)).setAttribute("cellpadding","0" );
      ((Element)v.get(121)).setAttribute("align","left" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(123)).setAttribute("valign","top" );
      ((Element)v.get(123)).setAttribute("height","13" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(124)).setAttribute("nombre","lblpaisOidPais" );
      ((Element)v.get(124)).setAttribute("id","datosTitle" );
      ((Element)v.get(124)).setAttribute("ancho","100" );
      ((Element)v.get(124)).setAttribute("alto","13" );
      ((Element)v.get(124)).setAttribute("cod","CarParamCarte.paisOidPais.label" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:125 / Elemento padre: 121   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(125)).setAttribute("nombre","paisOidPaisWidgetTrId" );
      ((Element)v.get(121)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(126)).setAttribute("align","left" );
      ((Element)v.get(126)).setAttribute("nowrap","true" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(127)).setAttribute("nombre","paisOidPais" );
      ((Element)v.get(127)).setAttribute("id","datosCampos" );
      ((Element)v.get(127)).setAttribute("multiple","N" );
      ((Element)v.get(127)).setAttribute("req","N" );
      ((Element)v.get(127)).setAttribute("size","1" );
      ((Element)v.get(127)).setAttribute("validacion","" );
      ((Element)v.get(127)).setAttribute("onchange","" );
      ((Element)v.get(127)).setAttribute("onfocus","" );
      ((Element)v.get(127)).setAttribute("valorinicial","" );
      ((Element)v.get(127)).setAttribute("textoinicial","" );
      ((Element)v.get(127)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true);" );
      ((Element)v.get(127)).setAttribute("onshtab","focaliza('carParamCarteFrm.paisOidPais_fopaOidFormPago');" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:129 / Elemento padre: 121   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(129)).setAttribute("nombre","paisOidPaisViewLabelTrId" );
      ((Element)v.get(121)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(130)).setAttribute("valign","top" );
      ((Element)v.get(130)).setAttribute("height","13" );
      ((Element)v.get(130)).setAttribute("width","30" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(131)).setAttribute("nombre","lblViewPaisOidPais" );
      ((Element)v.get(131)).setAttribute("alto","13" );
      ((Element)v.get(131)).setAttribute("filas","1" );
      ((Element)v.get(131)).setAttribute("id","EstDat" );
      ((Element)v.get(131)).setAttribute("valor","" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:121   */
      /* Termina nodo:120   */

      /* Empieza nodo:132 / Elemento padre: 77   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(132)).setAttribute("nombre","paisOidPaisGapTdId" );
      ((Element)v.get(132)).setAttribute("nowrap","true" );
      ((Element)v.get(132)).setAttribute("class","datosCampos" );
      ((Element)v.get(77)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","25" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 77   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(134)).setAttribute("width","100%" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(77)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */
      /* Termina nodo:72   */

      /* Empieza nodo:136 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(136)).setAttribute("nombre","formGapTr1" );
      ((Element)v.get(40)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(137)).setAttribute("align","center" );
      ((Element)v.get(137)).setAttribute("width","12" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","12" );
      ((Element)v.get(138)).setAttribute("height","8" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 136   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(136)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","8" );
      ((Element)v.get(140)).setAttribute("height","8" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 136   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(141)).setAttribute("align","center" );
      ((Element)v.get(141)).setAttribute("width","12" );
      ((Element)v.get(136)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","12" );
      ((Element)v.get(142)).setAttribute("height","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:136   */

      /* Empieza nodo:143 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(143)).setAttribute("nombre","formTr2" );
      ((Element)v.get(40)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(144)).setAttribute("align","center" );
      ((Element)v.get(144)).setAttribute("width","12" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).setAttribute("width","12" );
      ((Element)v.get(145)).setAttribute("height","12" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:146 / Elemento padre: 143   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(146)).setAttribute("width","100%" );
      ((Element)v.get(143)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(147)).setAttribute("width","100%" );
      ((Element)v.get(147)).setAttribute("border","0" );
      ((Element)v.get(147)).setAttribute("cellspacing","0" );
      ((Element)v.get(147)).setAttribute("cellpadding","0" );
      ((Element)v.get(147)).setAttribute("align","left" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(148)).setAttribute("align","left" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(149)).setAttribute("nombre","grsoOidGrupSoliTdId" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(150)).setAttribute("border","0" );
      ((Element)v.get(150)).setAttribute("cellspacing","0" );
      ((Element)v.get(150)).setAttribute("cellpadding","0" );
      ((Element)v.get(150)).setAttribute("align","left" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(152)).setAttribute("valign","top" );
      ((Element)v.get(152)).setAttribute("height","13" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(153)).setAttribute("nombre","lblgrsoOidGrupSoli" );
      ((Element)v.get(153)).setAttribute("id","datosTitle" );
      ((Element)v.get(153)).setAttribute("ancho","100" );
      ((Element)v.get(153)).setAttribute("alto","13" );
      ((Element)v.get(153)).setAttribute("cod","CarParamCarte.grsoOidGrupSoli.label" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:154 / Elemento padre: 150   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(154)).setAttribute("nombre","grsoOidGrupSoliWidgetTrId" );
      ((Element)v.get(150)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(155)).setAttribute("align","left" );
      ((Element)v.get(155)).setAttribute("nowrap","true" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(156)).setAttribute("nombre","grsoOidGrupSoli" );
      ((Element)v.get(156)).setAttribute("id","datosCampos" );
      ((Element)v.get(156)).setAttribute("multiple","N" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(156)).setAttribute("req","N" );
      ((Element)v.get(156)).setAttribute("size","1" );
      ((Element)v.get(156)).setAttribute("validacion","" );
      ((Element)v.get(156)).setAttribute("onchange","" );
      ((Element)v.get(156)).setAttribute("onfocus","" );
      ((Element)v.get(156)).setAttribute("valorinicial","" );
      ((Element)v.get(156)).setAttribute("textoinicial","" );
      ((Element)v.get(156)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true);" );
      ((Element)v.get(156)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm',0, false);" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:154   */

      /* Empieza nodo:158 / Elemento padre: 150   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(158)).setAttribute("nombre","grsoOidGrupSoliViewLabelTrId" );
      ((Element)v.get(150)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(159)).setAttribute("valign","top" );
      ((Element)v.get(159)).setAttribute("height","13" );
      ((Element)v.get(159)).setAttribute("width","50" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(160)).setAttribute("nombre","lblViewGrsoOidGrupSoli" );
      ((Element)v.get(160)).setAttribute("alto","13" );
      ((Element)v.get(160)).setAttribute("filas","1" );
      ((Element)v.get(160)).setAttribute("id","EstDat" );
      ((Element)v.get(160)).setAttribute("valor","" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */
      /* Termina nodo:158   */
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:161 / Elemento padre: 148   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(161)).setAttribute("nombre","grsoOidGrupSoliGapTdId" );
      ((Element)v.get(161)).setAttribute("nowrap","true" );
      ((Element)v.get(161)).setAttribute("class","datosCampos" );
      ((Element)v.get(148)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(162)).setAttribute("src","b.gif" );
      ((Element)v.get(162)).setAttribute("width","25" );
      ((Element)v.get(162)).setAttribute("height","8" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:163 / Elemento padre: 148   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(163)).setAttribute("width","100%" );
      ((Element)v.get(148)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(164)).setAttribute("src","b.gif" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:143   */

      /* Empieza nodo:165 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(165)).setAttribute("nombre","formGapTr2" );
      ((Element)v.get(40)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(166)).setAttribute("align","center" );
      ((Element)v.get(166)).setAttribute("width","12" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).setAttribute("width","12" );
      ((Element)v.get(167)).setAttribute("height","8" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */

      /* Empieza nodo:168 / Elemento padre: 165   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(165)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(169)).setAttribute("src","b.gif" );
      ((Element)v.get(169)).setAttribute("width","8" );
      ((Element)v.get(169)).setAttribute("height","8" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 165   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(170)).setAttribute("align","center" );
      ((Element)v.get(170)).setAttribute("width","12" );
      ((Element)v.get(165)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(171)).setAttribute("src","b.gif" );
      ((Element)v.get(171)).setAttribute("width","12" );
      ((Element)v.get(171)).setAttribute("height","8" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */
      /* Termina nodo:165   */

      /* Empieza nodo:172 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(172)).setAttribute("nombre","formTr3" );
      ((Element)v.get(40)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(173)).setAttribute("align","center" );
      ((Element)v.get(173)).setAttribute("width","12" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(174)).setAttribute("width","12" );
      ((Element)v.get(174)).setAttribute("height","12" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:175 / Elemento padre: 172   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(175)).setAttribute("width","100%" );
      ((Element)v.get(172)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(176)).setAttribute("width","100%" );
      ((Element)v.get(176)).setAttribute("border","0" );
      ((Element)v.get(176)).setAttribute("cellspacing","0" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(176)).setAttribute("cellpadding","0" );
      ((Element)v.get(176)).setAttribute("align","left" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(177)).setAttribute("align","left" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(178)).setAttribute("nombre","niriOidNiveRiesTdId" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(179)).setAttribute("border","0" );
      ((Element)v.get(179)).setAttribute("cellspacing","0" );
      ((Element)v.get(179)).setAttribute("cellpadding","0" );
      ((Element)v.get(179)).setAttribute("align","left" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(181)).setAttribute("valign","top" );
      ((Element)v.get(181)).setAttribute("height","13" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(182)).setAttribute("nombre","lblniriOidNiveRies" );
      ((Element)v.get(182)).setAttribute("id","datosTitle" );
      ((Element)v.get(182)).setAttribute("ancho","100" );
      ((Element)v.get(182)).setAttribute("alto","13" );
      ((Element)v.get(182)).setAttribute("cod","CarParamCarte.niriOidNiveRies.label" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:183 / Elemento padre: 179   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(183)).setAttribute("nombre","niriOidNiveRiesWidgetTrId" );
      ((Element)v.get(179)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(184)).setAttribute("align","left" );
      ((Element)v.get(184)).setAttribute("nowrap","true" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(185)).setAttribute("nombre","niriOidNiveRies" );
      ((Element)v.get(185)).setAttribute("id","datosCampos" );
      ((Element)v.get(185)).setAttribute("multiple","N" );
      ((Element)v.get(185)).setAttribute("req","N" );
      ((Element)v.get(185)).setAttribute("size","1" );
      ((Element)v.get(185)).setAttribute("validacion","" );
      ((Element)v.get(185)).setAttribute("onchange","" );
      ((Element)v.get(185)).setAttribute("onfocus","" );
      ((Element)v.get(185)).setAttribute("valorinicial","" );
      ((Element)v.get(185)).setAttribute("textoinicial","" );
      ((Element)v.get(185)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true);" );
      ((Element)v.get(185)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm',0, false);" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:187 / Elemento padre: 179   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(187)).setAttribute("nombre","niriOidNiveRiesViewLabelTrId" );
      ((Element)v.get(179)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(188)).setAttribute("valign","top" );
      ((Element)v.get(188)).setAttribute("height","13" );
      ((Element)v.get(188)).setAttribute("width","50" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(189)).setAttribute("nombre","lblViewNiriOidNiveRies" );
      ((Element)v.get(189)).setAttribute("alto","13" );
      ((Element)v.get(189)).setAttribute("filas","1" );
      ((Element)v.get(189)).setAttribute("id","EstDat" );
      ((Element)v.get(189)).setAttribute("valor","" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */
      /* Termina nodo:187   */
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:190 / Elemento padre: 177   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(190)).setAttribute("nombre","niriOidNiveRiesGapTdId" );
      ((Element)v.get(190)).setAttribute("nowrap","true" );
      ((Element)v.get(190)).setAttribute("class","datosCampos" );
      ((Element)v.get(177)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(191)).setAttribute("src","b.gif" );
      ((Element)v.get(191)).setAttribute("width","25" );
      ((Element)v.get(191)).setAttribute("height","8" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 177   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(192)).setAttribute("width","100%" );
      ((Element)v.get(177)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:175   */
      /* Termina nodo:172   */

      /* Empieza nodo:194 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(194)).setAttribute("nombre","formGapTr3" );
      ((Element)v.get(40)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(195)).setAttribute("align","center" );
      ((Element)v.get(195)).setAttribute("width","12" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(196)).setAttribute("src","b.gif" );
      ((Element)v.get(196)).setAttribute("width","12" );
      ((Element)v.get(196)).setAttribute("height","8" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));
      /* Termina nodo:196   */
      /* Termina nodo:195   */

      /* Empieza nodo:197 / Elemento padre: 194   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(194)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).setAttribute("width","8" );
      ((Element)v.get(198)).setAttribute("height","8" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 194   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(199)).setAttribute("align","center" );
      ((Element)v.get(199)).setAttribute("width","12" );
      ((Element)v.get(194)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(200)).setAttribute("src","b.gif" );
      ((Element)v.get(200)).setAttribute("width","12" );
      ((Element)v.get(200)).setAttribute("height","8" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:194   */

      /* Empieza nodo:201 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(201)).setAttribute("nombre","formTr4" );
      ((Element)v.get(40)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(202)).setAttribute("align","center" );
      ((Element)v.get(202)).setAttribute("width","12" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(203)).setAttribute("src","b.gif" );
      ((Element)v.get(203)).setAttribute("width","12" );
      ((Element)v.get(203)).setAttribute("height","12" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 201   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(204)).setAttribute("width","100%" );
      ((Element)v.get(201)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(205)).setAttribute("width","100%" );
      ((Element)v.get(205)).setAttribute("border","0" );
      ((Element)v.get(205)).setAttribute("cellspacing","0" );
      ((Element)v.get(205)).setAttribute("cellpadding","0" );
      ((Element)v.get(205)).setAttribute("align","left" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(206)).setAttribute("align","left" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(207)).setAttribute("nombre","codConfTdId" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));

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
      ((Element)v.get(208)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(210)).setAttribute("valign","top" );
      ((Element)v.get(210)).setAttribute("height","13" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(211)).setAttribute("nombre","lblCodConf" );
      ((Element)v.get(211)).setAttribute("alto","13" );
      ((Element)v.get(211)).setAttribute("filas","1" );
      ((Element)v.get(211)).setAttribute("id","datosTitle" );
      ((Element)v.get(211)).setAttribute("cod","CarParamCarte.codConf.label" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:209   */

      /* Empieza nodo:212 / Elemento padre: 208   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(212)).setAttribute("nombre","codConfWidgetTrId" );
      ((Element)v.get(208)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(213)).setAttribute("align","left" );
      ((Element)v.get(213)).setAttribute("nowrap","true" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(214)).setAttribute("nombre","codConf" );
      ((Element)v.get(214)).setAttribute("id","datosCampos" );
      ((Element)v.get(214)).setAttribute("trim","S" );
      ((Element)v.get(214)).setAttribute("max","3" );
      ((Element)v.get(214)).setAttribute("onchange","" );
      ((Element)v.get(214)).setAttribute("req","N" );
      ((Element)v.get(214)).setAttribute("size","3" );
      ((Element)v.get(214)).setAttribute("valor","" );
      ((Element)v.get(214)).setAttribute("validacion","" );
      ((Element)v.get(214)).setAttribute("onblur","" );
      ((Element)v.get(214)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true)" );
      ((Element)v.get(214)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm', 0, false)" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:215 / Elemento padre: 208   */
      v.add(doc.createElement("TR"));
   }

   private void getXML990(Document doc) {
      ((Element)v.get(215)).setAttribute("nombre","codConfViewLabelTrId" );
      ((Element)v.get(208)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(216)).setAttribute("valign","top" );
      ((Element)v.get(216)).setAttribute("height","13" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(217)).setAttribute("nombre","lblViewCodConf" );
      ((Element)v.get(217)).setAttribute("alto","13" );
      ((Element)v.get(217)).setAttribute("ancho","100" );
      ((Element)v.get(217)).setAttribute("id","EstDat" );
      ((Element)v.get(217)).setAttribute("valor","" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */
      /* Termina nodo:215   */
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:218 / Elemento padre: 206   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(218)).setAttribute("nombre","codConfGapTdId" );
      ((Element)v.get(218)).setAttribute("nowrap","true" );
      ((Element)v.get(218)).setAttribute("class","datosCampos" );
      ((Element)v.get(206)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("width","25" );
      ((Element)v.get(219)).setAttribute("height","8" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 206   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(220)).setAttribute("width","100%" );
      ((Element)v.get(206)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(221)).setAttribute("src","b.gif" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */
      /* Termina nodo:206   */
      /* Termina nodo:205   */
      /* Termina nodo:204   */
      /* Termina nodo:201   */

      /* Empieza nodo:222 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(222)).setAttribute("nombre","formGapTr4" );
      ((Element)v.get(40)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(223)).setAttribute("align","center" );
      ((Element)v.get(223)).setAttribute("width","12" );
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
      ((Element)v.get(227)).setAttribute("width","12" );
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

      /* Empieza nodo:229 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(229)).setAttribute("nombre","formTr5" );
      ((Element)v.get(40)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(230)).setAttribute("align","center" );
      ((Element)v.get(230)).setAttribute("width","12" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(231)).setAttribute("src","b.gif" );
      ((Element)v.get(231)).setAttribute("width","12" );
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
      ((Element)v.get(235)).setAttribute("nombre","indDeudVencTdId" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(236)).setAttribute("width","100%" );
      ((Element)v.get(236)).setAttribute("border","0" );
      ((Element)v.get(236)).setAttribute("cellspacing","0" );
      ((Element)v.get(236)).setAttribute("cellpadding","0" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(236)).setAttribute("align","left" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(238)).setAttribute("valign","top" );
      ((Element)v.get(238)).setAttribute("height","13" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(239)).setAttribute("nombre","lblIndDeudVenc" );
      ((Element)v.get(239)).setAttribute("alto","13" );
      ((Element)v.get(239)).setAttribute("filas","1" );
      ((Element)v.get(239)).setAttribute("id","datosTitle" );
      ((Element)v.get(239)).setAttribute("cod","CarParamCarte.indDeudVenc.label" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:240 / Elemento padre: 236   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(240)).setAttribute("nombre","indDeudVencWidgetTrId" );
      ((Element)v.get(236)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(241)).setAttribute("align","left" );
      ((Element)v.get(241)).setAttribute("nowrap","true" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(242)).setAttribute("nombre","indDeudVenc" );
      ((Element)v.get(242)).setAttribute("id","datosCampos" );
      ((Element)v.get(242)).setAttribute("trim","S" );
      ((Element)v.get(242)).setAttribute("max","1" );
      ((Element)v.get(242)).setAttribute("onchange","" );
      ((Element)v.get(242)).setAttribute("req","N" );
      ((Element)v.get(242)).setAttribute("size","1" );
      ((Element)v.get(242)).setAttribute("valor","" );
      ((Element)v.get(242)).setAttribute("validacion","" );
      ((Element)v.get(242)).setAttribute("onblur","" );
      ((Element)v.get(242)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true)" );
      ((Element)v.get(242)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm', 0, false)" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:243 / Elemento padre: 236   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(243)).setAttribute("nombre","indDeudVencViewLabelTrId" );
      ((Element)v.get(236)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(244)).setAttribute("valign","top" );
      ((Element)v.get(244)).setAttribute("height","13" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(245)).setAttribute("nombre","lblViewIndDeudVenc" );
      ((Element)v.get(245)).setAttribute("alto","13" );
      ((Element)v.get(245)).setAttribute("ancho","100" );
      ((Element)v.get(245)).setAttribute("id","EstDat" );
      ((Element)v.get(245)).setAttribute("valor","" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */
      /* Termina nodo:243   */
      /* Termina nodo:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:246 / Elemento padre: 234   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(246)).setAttribute("nombre","indDeudVencGapTdId" );
      ((Element)v.get(246)).setAttribute("nowrap","true" );
      ((Element)v.get(246)).setAttribute("class","datosCampos" );
      ((Element)v.get(234)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(247)).setAttribute("src","b.gif" );
      ((Element)v.get(247)).setAttribute("width","25" );
      ((Element)v.get(247)).setAttribute("height","8" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:248 / Elemento padre: 234   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(248)).setAttribute("width","100%" );
      ((Element)v.get(234)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(249)).setAttribute("src","b.gif" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */
      /* Termina nodo:234   */
      /* Termina nodo:233   */
      /* Termina nodo:232   */
      /* Termina nodo:229   */

      /* Empieza nodo:250 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(250)).setAttribute("nombre","formGapTr5" );
      ((Element)v.get(40)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(251)).setAttribute("align","center" );
      ((Element)v.get(251)).setAttribute("width","12" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(252)).setAttribute("src","b.gif" );
      ((Element)v.get(252)).setAttribute("width","12" );
      ((Element)v.get(252)).setAttribute("height","8" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */

      /* Empieza nodo:253 / Elemento padre: 250   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(250)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(254)).setAttribute("src","b.gif" );
      ((Element)v.get(254)).setAttribute("width","8" );
      ((Element)v.get(254)).setAttribute("height","8" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));
      /* Termina nodo:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:255 / Elemento padre: 250   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(255)).setAttribute("align","center" );
      ((Element)v.get(255)).setAttribute("width","12" );
      ((Element)v.get(250)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(256)).setAttribute("src","b.gif" );
      ((Element)v.get(256)).setAttribute("width","12" );
      ((Element)v.get(256)).setAttribute("height","8" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */
      /* Termina nodo:250   */

      /* Empieza nodo:257 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(257)).setAttribute("nombre","formTr6" );
      ((Element)v.get(40)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(258)).setAttribute("align","center" );
      ((Element)v.get(258)).setAttribute("width","12" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(259)).setAttribute("src","b.gif" );
      ((Element)v.get(259)).setAttribute("width","12" );
      ((Element)v.get(259)).setAttribute("height","12" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:260 / Elemento padre: 257   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(260)).setAttribute("width","100%" );
      ((Element)v.get(257)).appendChild((Element)v.get(260));

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
      ((Element)v.get(262)).setAttribute("align","left" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(263)).setAttribute("nombre","numDiasDeudVencTdId" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(264)).setAttribute("width","100%" );
      ((Element)v.get(264)).setAttribute("border","0" );
      ((Element)v.get(264)).setAttribute("cellspacing","0" );
      ((Element)v.get(264)).setAttribute("cellpadding","0" );
      ((Element)v.get(264)).setAttribute("align","left" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(264)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(266)).setAttribute("valign","top" );
      ((Element)v.get(266)).setAttribute("height","13" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(267)).setAttribute("nombre","lblNumDiasDeudVenc" );
      ((Element)v.get(267)).setAttribute("alto","13" );
      ((Element)v.get(267)).setAttribute("filas","1" );
      ((Element)v.get(267)).setAttribute("id","datosTitle" );
      ((Element)v.get(267)).setAttribute("cod","CarParamCarte.numDiasDeudVenc.label" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */
      /* Termina nodo:265   */

      /* Empieza nodo:268 / Elemento padre: 264   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(268)).setAttribute("nombre","numDiasDeudVencWidgetTrId" );
      ((Element)v.get(264)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(269)).setAttribute("align","left" );
      ((Element)v.get(269)).setAttribute("nowrap","true" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(270)).setAttribute("nombre","numDiasDeudVenc" );
      ((Element)v.get(270)).setAttribute("id","datosCampos" );
      ((Element)v.get(270)).setAttribute("trim","S" );
      ((Element)v.get(270)).setAttribute("max","3" );
      ((Element)v.get(270)).setAttribute("onchange","" );
      ((Element)v.get(270)).setAttribute("req","N" );
      ((Element)v.get(270)).setAttribute("size","3" );
      ((Element)v.get(270)).setAttribute("valor","" );
      ((Element)v.get(270)).setAttribute("validacion","" );
      ((Element)v.get(270)).setAttribute("onblur","" );
      ((Element)v.get(270)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true)" );
      ((Element)v.get(270)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm', 0, false)" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:269   */
      /* Termina nodo:268   */

      /* Empieza nodo:271 / Elemento padre: 264   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(271)).setAttribute("nombre","numDiasDeudVencViewLabelTrId" );
      ((Element)v.get(264)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(272)).setAttribute("valign","top" );
      ((Element)v.get(272)).setAttribute("height","13" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(273)).setAttribute("nombre","lblViewNumDiasDeudVenc" );
      ((Element)v.get(273)).setAttribute("alto","13" );
      ((Element)v.get(273)).setAttribute("ancho","100" );
      ((Element)v.get(273)).setAttribute("id","EstDat" );
      ((Element)v.get(273)).setAttribute("valor","" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */
      /* Termina nodo:272   */
      /* Termina nodo:271   */
      /* Termina nodo:264   */
      /* Termina nodo:263   */

      /* Empieza nodo:274 / Elemento padre: 262   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(274)).setAttribute("nombre","numDiasDeudVencGapTdId" );
      ((Element)v.get(274)).setAttribute("nowrap","true" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(274)).setAttribute("class","datosCampos" );
      ((Element)v.get(262)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(275)).setAttribute("src","b.gif" );
      ((Element)v.get(275)).setAttribute("width","25" );
      ((Element)v.get(275)).setAttribute("height","8" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */
      /* Termina nodo:274   */

      /* Empieza nodo:276 / Elemento padre: 262   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(276)).setAttribute("width","100%" );
      ((Element)v.get(262)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(277)).setAttribute("src","b.gif" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:276   */
      /* Termina nodo:262   */
      /* Termina nodo:261   */
      /* Termina nodo:260   */
      /* Termina nodo:257   */

      /* Empieza nodo:278 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(278)).setAttribute("nombre","formGapTr6" );
      ((Element)v.get(40)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(279)).setAttribute("align","center" );
      ((Element)v.get(279)).setAttribute("width","12" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(280)).setAttribute("src","b.gif" );
      ((Element)v.get(280)).setAttribute("width","12" );
      ((Element)v.get(280)).setAttribute("height","8" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */

      /* Empieza nodo:281 / Elemento padre: 278   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(278)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(282)).setAttribute("src","b.gif" );
      ((Element)v.get(282)).setAttribute("width","8" );
      ((Element)v.get(282)).setAttribute("height","8" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */

      /* Empieza nodo:283 / Elemento padre: 278   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(283)).setAttribute("align","center" );
      ((Element)v.get(283)).setAttribute("width","12" );
      ((Element)v.get(278)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(284)).setAttribute("src","b.gif" );
      ((Element)v.get(284)).setAttribute("width","12" );
      ((Element)v.get(284)).setAttribute("height","8" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:283   */
      /* Termina nodo:278   */

      /* Empieza nodo:285 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(285)).setAttribute("nombre","formTr7" );
      ((Element)v.get(40)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(286)).setAttribute("align","center" );
      ((Element)v.get(286)).setAttribute("width","12" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(287)).setAttribute("src","b.gif" );
      ((Element)v.get(287)).setAttribute("width","12" );
      ((Element)v.get(287)).setAttribute("height","12" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:286   */

      /* Empieza nodo:288 / Elemento padre: 285   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(288)).setAttribute("width","100%" );
      ((Element)v.get(285)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(289)).setAttribute("width","100%" );
      ((Element)v.get(289)).setAttribute("border","0" );
      ((Element)v.get(289)).setAttribute("cellspacing","0" );
      ((Element)v.get(289)).setAttribute("cellpadding","0" );
      ((Element)v.get(289)).setAttribute("align","left" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(290)).setAttribute("align","left" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(291)).setAttribute("nombre","indLineCredTdId" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(292)).setAttribute("width","100%" );
      ((Element)v.get(292)).setAttribute("border","0" );
      ((Element)v.get(292)).setAttribute("cellspacing","0" );
      ((Element)v.get(292)).setAttribute("cellpadding","0" );
      ((Element)v.get(292)).setAttribute("align","left" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(292)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(294)).setAttribute("valign","top" );
      ((Element)v.get(294)).setAttribute("height","13" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(295)).setAttribute("nombre","lblIndLineCred" );
      ((Element)v.get(295)).setAttribute("alto","13" );
      ((Element)v.get(295)).setAttribute("filas","1" );
      ((Element)v.get(295)).setAttribute("id","datosTitle" );
      ((Element)v.get(295)).setAttribute("cod","CarParamCarte.indLineCred.label" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */
      /* Termina nodo:293   */

      /* Empieza nodo:296 / Elemento padre: 292   */
      v.add(doc.createElement("TR"));
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(296)).setAttribute("nombre","indLineCredWidgetTrId" );
      ((Element)v.get(292)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(297)).setAttribute("align","left" );
      ((Element)v.get(297)).setAttribute("nowrap","true" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(298)).setAttribute("nombre","indLineCred" );
      ((Element)v.get(298)).setAttribute("id","datosCampos" );
      ((Element)v.get(298)).setAttribute("trim","S" );
      ((Element)v.get(298)).setAttribute("max","1" );
      ((Element)v.get(298)).setAttribute("onchange","" );
      ((Element)v.get(298)).setAttribute("req","N" );
      ((Element)v.get(298)).setAttribute("size","1" );
      ((Element)v.get(298)).setAttribute("valor","" );
      ((Element)v.get(298)).setAttribute("validacion","" );
      ((Element)v.get(298)).setAttribute("onblur","" );
      ((Element)v.get(298)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true)" );
      ((Element)v.get(298)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm', 0, false)" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */
      /* Termina nodo:296   */

      /* Empieza nodo:299 / Elemento padre: 292   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(299)).setAttribute("nombre","indLineCredViewLabelTrId" );
      ((Element)v.get(292)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(300)).setAttribute("valign","top" );
      ((Element)v.get(300)).setAttribute("height","13" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(301)).setAttribute("nombre","lblViewIndLineCred" );
      ((Element)v.get(301)).setAttribute("alto","13" );
      ((Element)v.get(301)).setAttribute("ancho","100" );
      ((Element)v.get(301)).setAttribute("id","EstDat" );
      ((Element)v.get(301)).setAttribute("valor","" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:300   */
      /* Termina nodo:299   */
      /* Termina nodo:292   */
      /* Termina nodo:291   */

      /* Empieza nodo:302 / Elemento padre: 290   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(302)).setAttribute("nombre","indLineCredGapTdId" );
      ((Element)v.get(302)).setAttribute("nowrap","true" );
      ((Element)v.get(302)).setAttribute("class","datosCampos" );
      ((Element)v.get(290)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(303)).setAttribute("src","b.gif" );
      ((Element)v.get(303)).setAttribute("width","25" );
      ((Element)v.get(303)).setAttribute("height","8" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:302   */

      /* Empieza nodo:304 / Elemento padre: 290   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(304)).setAttribute("width","100%" );
      ((Element)v.get(290)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(305)).setAttribute("src","b.gif" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:304   */
      /* Termina nodo:290   */
      /* Termina nodo:289   */
      /* Termina nodo:288   */
      /* Termina nodo:285   */

      /* Empieza nodo:306 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(306)).setAttribute("nombre","formGapTr7" );
      ((Element)v.get(40)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(307)).setAttribute("align","center" );
      ((Element)v.get(307)).setAttribute("width","12" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(308)).setAttribute("src","b.gif" );
      ((Element)v.get(308)).setAttribute("width","12" );
      ((Element)v.get(308)).setAttribute("height","8" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:307   */

      /* Empieza nodo:309 / Elemento padre: 306   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(306)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(310)).setAttribute("src","b.gif" );
      ((Element)v.get(310)).setAttribute("width","8" );
      ((Element)v.get(310)).setAttribute("height","8" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */
      /* Termina nodo:309   */

      /* Empieza nodo:311 / Elemento padre: 306   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(311)).setAttribute("align","center" );
      ((Element)v.get(311)).setAttribute("width","12" );
      ((Element)v.get(306)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(312)).setAttribute("src","b.gif" );
      ((Element)v.get(312)).setAttribute("width","12" );
      ((Element)v.get(312)).setAttribute("height","8" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */
      /* Termina nodo:306   */

      /* Empieza nodo:313 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(313)).setAttribute("nombre","formTr8" );
      ((Element)v.get(40)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(314)).setAttribute("align","center" );
      ((Element)v.get(314)).setAttribute("width","12" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(315)).setAttribute("src","b.gif" );
      ((Element)v.get(315)).setAttribute("width","12" );
      ((Element)v.get(315)).setAttribute("height","12" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:314   */

      /* Empieza nodo:316 / Elemento padre: 313   */
   }

   private void getXML1440(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(316)).setAttribute("width","100%" );
      ((Element)v.get(313)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(317)).setAttribute("width","100%" );
      ((Element)v.get(317)).setAttribute("border","0" );
      ((Element)v.get(317)).setAttribute("cellspacing","0" );
      ((Element)v.get(317)).setAttribute("cellpadding","0" );
      ((Element)v.get(317)).setAttribute("align","left" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(318)).setAttribute("align","left" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(319)).setAttribute("nombre","fecVigeDesdTdId" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(320)).setAttribute("width","100%" );
      ((Element)v.get(320)).setAttribute("border","0" );
      ((Element)v.get(320)).setAttribute("cellspacing","0" );
      ((Element)v.get(320)).setAttribute("cellpadding","0" );
      ((Element)v.get(320)).setAttribute("align","left" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(320)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(322)).setAttribute("valign","top" );
      ((Element)v.get(322)).setAttribute("height","13" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(323)).setAttribute("nombre","lblFecVigeDesd" );
      ((Element)v.get(323)).setAttribute("alto","13" );
      ((Element)v.get(323)).setAttribute("filas","1" );
      ((Element)v.get(323)).setAttribute("id","datosTitle" );
      ((Element)v.get(323)).setAttribute("cod","CarParamCarte.fecVigeDesd.label" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */
      /* Termina nodo:321   */

      /* Empieza nodo:324 / Elemento padre: 320   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(324)).setAttribute("nombre","fecVigeDesdWidgetTrId" );
      ((Element)v.get(320)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(325)).setAttribute("align","left" );
      ((Element)v.get(325)).setAttribute("nowrap","true" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(326)).setAttribute("nombre","fecVigeDesd" );
      ((Element)v.get(326)).setAttribute("id","datosCampos" );
      ((Element)v.get(326)).setAttribute("trim","S" );
      ((Element)v.get(326)).setAttribute("max","7" );
      ((Element)v.get(326)).setAttribute("onchange","" );
      ((Element)v.get(326)).setAttribute("req","N" );
      ((Element)v.get(326)).setAttribute("size","7" );
      ((Element)v.get(326)).setAttribute("valor","" );
      ((Element)v.get(326)).setAttribute("validacion","" );
      ((Element)v.get(326)).setAttribute("onblur","" );
      ((Element)v.get(326)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true)" );
      ((Element)v.get(326)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm', 0, false)" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:327 / Elemento padre: 320   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(327)).setAttribute("nombre","fecVigeDesdViewLabelTrId" );
      ((Element)v.get(320)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(328)).setAttribute("valign","top" );
      ((Element)v.get(328)).setAttribute("height","13" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(329)).setAttribute("nombre","lblViewFecVigeDesd" );
      ((Element)v.get(329)).setAttribute("alto","13" );
      ((Element)v.get(329)).setAttribute("ancho","100" );
      ((Element)v.get(329)).setAttribute("id","EstDat" );
      ((Element)v.get(329)).setAttribute("valor","" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:328   */
      /* Termina nodo:327   */
      /* Termina nodo:320   */
      /* Termina nodo:319   */

      /* Empieza nodo:330 / Elemento padre: 318   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(330)).setAttribute("nombre","fecVigeDesdGapTdId" );
      ((Element)v.get(330)).setAttribute("nowrap","true" );
      ((Element)v.get(330)).setAttribute("class","datosCampos" );
      ((Element)v.get(318)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(331)).setAttribute("src","b.gif" );
      ((Element)v.get(331)).setAttribute("width","25" );
      ((Element)v.get(331)).setAttribute("height","8" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */

      /* Empieza nodo:332 / Elemento padre: 318   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(332)).setAttribute("width","100%" );
      ((Element)v.get(318)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(333)).setAttribute("src","b.gif" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */
      /* Termina nodo:332   */
      /* Termina nodo:318   */
      /* Termina nodo:317   */
      /* Termina nodo:316   */
      /* Termina nodo:313   */

      /* Empieza nodo:334 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(334)).setAttribute("nombre","formGapTr8" );
      ((Element)v.get(40)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
   }

   private void getXML1530(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(335)).setAttribute("align","center" );
      ((Element)v.get(335)).setAttribute("width","12" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(336)).setAttribute("src","b.gif" );
      ((Element)v.get(336)).setAttribute("width","12" );
      ((Element)v.get(336)).setAttribute("height","8" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:337 / Elemento padre: 334   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(334)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(338)).setAttribute("src","b.gif" );
      ((Element)v.get(338)).setAttribute("width","8" );
      ((Element)v.get(338)).setAttribute("height","8" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:339 / Elemento padre: 334   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(339)).setAttribute("align","center" );
      ((Element)v.get(339)).setAttribute("width","12" );
      ((Element)v.get(334)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(340)).setAttribute("src","b.gif" );
      ((Element)v.get(340)).setAttribute("width","12" );
      ((Element)v.get(340)).setAttribute("height","8" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */
      /* Termina nodo:334   */

      /* Empieza nodo:341 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(341)).setAttribute("nombre","formTr9" );
      ((Element)v.get(40)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(342)).setAttribute("align","center" );
      ((Element)v.get(342)).setAttribute("width","12" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(343)).setAttribute("src","b.gif" );
      ((Element)v.get(343)).setAttribute("width","12" );
      ((Element)v.get(343)).setAttribute("height","12" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */
      /* Termina nodo:342   */

      /* Empieza nodo:344 / Elemento padre: 341   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(344)).setAttribute("width","100%" );
      ((Element)v.get(341)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(345)).setAttribute("width","100%" );
      ((Element)v.get(345)).setAttribute("border","0" );
      ((Element)v.get(345)).setAttribute("cellspacing","0" );
      ((Element)v.get(345)).setAttribute("cellpadding","0" );
      ((Element)v.get(345)).setAttribute("align","left" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(346)).setAttribute("align","left" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(347)).setAttribute("nombre","fecVigeHastTdId" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(348)).setAttribute("width","100%" );
      ((Element)v.get(348)).setAttribute("border","0" );
      ((Element)v.get(348)).setAttribute("cellspacing","0" );
      ((Element)v.get(348)).setAttribute("cellpadding","0" );
      ((Element)v.get(348)).setAttribute("align","left" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(348)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(350)).setAttribute("valign","top" );
      ((Element)v.get(350)).setAttribute("height","13" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(351)).setAttribute("nombre","lblFecVigeHast" );
      ((Element)v.get(351)).setAttribute("alto","13" );
      ((Element)v.get(351)).setAttribute("filas","1" );
      ((Element)v.get(351)).setAttribute("id","datosTitle" );
      ((Element)v.get(351)).setAttribute("cod","CarParamCarte.fecVigeHast.label" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */
      /* Termina nodo:350   */
      /* Termina nodo:349   */

      /* Empieza nodo:352 / Elemento padre: 348   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(352)).setAttribute("nombre","fecVigeHastWidgetTrId" );
      ((Element)v.get(348)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(353)).setAttribute("align","left" );
      ((Element)v.get(353)).setAttribute("nowrap","true" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(354)).setAttribute("nombre","fecVigeHast" );
      ((Element)v.get(354)).setAttribute("id","datosCampos" );
      ((Element)v.get(354)).setAttribute("trim","S" );
      ((Element)v.get(354)).setAttribute("max","7" );
      ((Element)v.get(354)).setAttribute("onchange","" );
      ((Element)v.get(354)).setAttribute("req","N" );
      ((Element)v.get(354)).setAttribute("size","7" );
      ((Element)v.get(354)).setAttribute("valor","" );
      ((Element)v.get(354)).setAttribute("validacion","" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(354)).setAttribute("onblur","" );
      ((Element)v.get(354)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true)" );
      ((Element)v.get(354)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm', 0, false)" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */
      /* Termina nodo:353   */
      /* Termina nodo:352   */

      /* Empieza nodo:355 / Elemento padre: 348   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(355)).setAttribute("nombre","fecVigeHastViewLabelTrId" );
      ((Element)v.get(348)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(356)).setAttribute("valign","top" );
      ((Element)v.get(356)).setAttribute("height","13" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(357)).setAttribute("nombre","lblViewFecVigeHast" );
      ((Element)v.get(357)).setAttribute("alto","13" );
      ((Element)v.get(357)).setAttribute("ancho","100" );
      ((Element)v.get(357)).setAttribute("id","EstDat" );
      ((Element)v.get(357)).setAttribute("valor","" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */
      /* Termina nodo:355   */
      /* Termina nodo:348   */
      /* Termina nodo:347   */

      /* Empieza nodo:358 / Elemento padre: 346   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(358)).setAttribute("nombre","fecVigeHastGapTdId" );
      ((Element)v.get(358)).setAttribute("nowrap","true" );
      ((Element)v.get(358)).setAttribute("class","datosCampos" );
      ((Element)v.get(346)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(359)).setAttribute("src","b.gif" );
      ((Element)v.get(359)).setAttribute("width","25" );
      ((Element)v.get(359)).setAttribute("height","8" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */
      /* Termina nodo:358   */

      /* Empieza nodo:360 / Elemento padre: 346   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(360)).setAttribute("width","100%" );
      ((Element)v.get(346)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(361)).setAttribute("src","b.gif" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));
      /* Termina nodo:361   */
      /* Termina nodo:360   */
      /* Termina nodo:346   */
      /* Termina nodo:345   */
      /* Termina nodo:344   */
      /* Termina nodo:341   */

      /* Empieza nodo:362 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(362)).setAttribute("nombre","formGapTr9" );
      ((Element)v.get(40)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(363)).setAttribute("align","center" );
      ((Element)v.get(363)).setAttribute("width","12" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(364)).setAttribute("src","b.gif" );
      ((Element)v.get(364)).setAttribute("width","12" );
      ((Element)v.get(364)).setAttribute("height","8" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */
      /* Termina nodo:363   */

      /* Empieza nodo:365 / Elemento padre: 362   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(362)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(366)).setAttribute("src","b.gif" );
      ((Element)v.get(366)).setAttribute("width","8" );
      ((Element)v.get(366)).setAttribute("height","8" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */
      /* Termina nodo:365   */

      /* Empieza nodo:367 / Elemento padre: 362   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(367)).setAttribute("align","center" );
      ((Element)v.get(367)).setAttribute("width","12" );
      ((Element)v.get(362)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(368)).setAttribute("src","b.gif" );
      ((Element)v.get(368)).setAttribute("width","12" );
      ((Element)v.get(368)).setAttribute("height","8" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */
      /* Termina nodo:367   */
      /* Termina nodo:362   */

      /* Empieza nodo:369 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(369)).setAttribute("nombre","formTr10" );
      ((Element)v.get(40)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(370)).setAttribute("align","center" );
      ((Element)v.get(370)).setAttribute("width","12" );
      ((Element)v.get(369)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(371)).setAttribute("src","b.gif" );
      ((Element)v.get(371)).setAttribute("width","12" );
      ((Element)v.get(371)).setAttribute("height","12" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */
      /* Termina nodo:370   */

      /* Empieza nodo:372 / Elemento padre: 369   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(372)).setAttribute("width","100%" );
      ((Element)v.get(369)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(373)).setAttribute("width","100%" );
      ((Element)v.get(373)).setAttribute("border","0" );
      ((Element)v.get(373)).setAttribute("cellspacing","0" );
      ((Element)v.get(373)).setAttribute("cellpadding","0" );
      ((Element)v.get(373)).setAttribute("align","left" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(374)).setAttribute("align","left" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(375)).setAttribute("nombre","valPorcValiTdId" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
   }

   private void getXML1710(Document doc) {
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(376)).setAttribute("width","100%" );
      ((Element)v.get(376)).setAttribute("border","0" );
      ((Element)v.get(376)).setAttribute("cellspacing","0" );
      ((Element)v.get(376)).setAttribute("cellpadding","0" );
      ((Element)v.get(376)).setAttribute("align","left" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(376)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(378)).setAttribute("valign","top" );
      ((Element)v.get(378)).setAttribute("height","13" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(379)).setAttribute("nombre","lblValPorcVali" );
      ((Element)v.get(379)).setAttribute("alto","13" );
      ((Element)v.get(379)).setAttribute("filas","1" );
      ((Element)v.get(379)).setAttribute("id","datosTitle" );
      ((Element)v.get(379)).setAttribute("cod","CarParamCarte.valPorcVali.label" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */
      /* Termina nodo:378   */
      /* Termina nodo:377   */

      /* Empieza nodo:380 / Elemento padre: 376   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(380)).setAttribute("nombre","valPorcValiWidgetTrId" );
      ((Element)v.get(376)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(381)).setAttribute("align","left" );
      ((Element)v.get(381)).setAttribute("nowrap","true" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(382)).setAttribute("nombre","valPorcVali" );
      ((Element)v.get(382)).setAttribute("id","datosCampos" );
      ((Element)v.get(382)).setAttribute("trim","S" );
      ((Element)v.get(382)).setAttribute("max","5" );
      ((Element)v.get(382)).setAttribute("onchange","" );
      ((Element)v.get(382)).setAttribute("req","N" );
      ((Element)v.get(382)).setAttribute("size","5" );
      ((Element)v.get(382)).setAttribute("valor","" );
      ((Element)v.get(382)).setAttribute("validacion","" );
      ((Element)v.get(382)).setAttribute("onblur","" );
      ((Element)v.get(382)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true)" );
      ((Element)v.get(382)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm', 0, false)" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */
      /* Termina nodo:381   */
      /* Termina nodo:380   */

      /* Empieza nodo:383 / Elemento padre: 376   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(383)).setAttribute("nombre","valPorcValiViewLabelTrId" );
      ((Element)v.get(376)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(384)).setAttribute("valign","top" );
      ((Element)v.get(384)).setAttribute("height","13" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(385)).setAttribute("nombre","lblViewValPorcVali" );
      ((Element)v.get(385)).setAttribute("alto","13" );
      ((Element)v.get(385)).setAttribute("ancho","100" );
      ((Element)v.get(385)).setAttribute("id","EstDat" );
      ((Element)v.get(385)).setAttribute("valor","" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */
      /* Termina nodo:384   */
      /* Termina nodo:383   */
      /* Termina nodo:376   */
      /* Termina nodo:375   */

      /* Empieza nodo:386 / Elemento padre: 374   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(386)).setAttribute("nombre","valPorcValiGapTdId" );
      ((Element)v.get(386)).setAttribute("nowrap","true" );
      ((Element)v.get(386)).setAttribute("class","datosCampos" );
      ((Element)v.get(374)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(387)).setAttribute("src","b.gif" );
      ((Element)v.get(387)).setAttribute("width","25" );
      ((Element)v.get(387)).setAttribute("height","8" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */
      /* Termina nodo:386   */

      /* Empieza nodo:388 / Elemento padre: 374   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(388)).setAttribute("width","100%" );
      ((Element)v.get(374)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(389)).setAttribute("src","b.gif" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:388   */
      /* Termina nodo:374   */
      /* Termina nodo:373   */
      /* Termina nodo:372   */
      /* Termina nodo:369   */

      /* Empieza nodo:390 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(390)).setAttribute("nombre","formGapTr10" );
      ((Element)v.get(40)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(391)).setAttribute("align","center" );
      ((Element)v.get(391)).setAttribute("width","12" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(392)).setAttribute("src","b.gif" );
      ((Element)v.get(392)).setAttribute("width","12" );
      ((Element)v.get(392)).setAttribute("height","8" );
      ((Element)v.get(391)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */
      /* Termina nodo:391   */

      /* Empieza nodo:393 / Elemento padre: 390   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(390)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(394)).setAttribute("src","b.gif" );
      ((Element)v.get(394)).setAttribute("width","8" );
      ((Element)v.get(394)).setAttribute("height","8" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */
      /* Termina nodo:393   */

      /* Empieza nodo:395 / Elemento padre: 390   */
   }

   private void getXML1800(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(395)).setAttribute("align","center" );
      ((Element)v.get(395)).setAttribute("width","12" );
      ((Element)v.get(390)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(396)).setAttribute("src","b.gif" );
      ((Element)v.get(396)).setAttribute("width","12" );
      ((Element)v.get(396)).setAttribute("height","8" );
      ((Element)v.get(395)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */
      /* Termina nodo:395   */
      /* Termina nodo:390   */

      /* Empieza nodo:397 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(397)).setAttribute("nombre","formTr11" );
      ((Element)v.get(40)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(398)).setAttribute("align","center" );
      ((Element)v.get(398)).setAttribute("width","12" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(399)).setAttribute("src","b.gif" );
      ((Element)v.get(399)).setAttribute("width","12" );
      ((Element)v.get(399)).setAttribute("height","12" );
      ((Element)v.get(398)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */
      /* Termina nodo:398   */

      /* Empieza nodo:400 / Elemento padre: 397   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(400)).setAttribute("width","100%" );
      ((Element)v.get(397)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(401)).setAttribute("width","100%" );
      ((Element)v.get(401)).setAttribute("border","0" );
      ((Element)v.get(401)).setAttribute("cellspacing","0" );
      ((Element)v.get(401)).setAttribute("cellpadding","0" );
      ((Element)v.get(401)).setAttribute("align","left" );
      ((Element)v.get(400)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(402)).setAttribute("align","left" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(403)).setAttribute("nombre","indMontMaxiTdId" );
      ((Element)v.get(402)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(404)).setAttribute("width","100%" );
      ((Element)v.get(404)).setAttribute("border","0" );
      ((Element)v.get(404)).setAttribute("cellspacing","0" );
      ((Element)v.get(404)).setAttribute("cellpadding","0" );
      ((Element)v.get(404)).setAttribute("align","left" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(404)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(406)).setAttribute("valign","top" );
      ((Element)v.get(406)).setAttribute("height","13" );
      ((Element)v.get(405)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(407)).setAttribute("nombre","lblIndMontMaxi" );
      ((Element)v.get(407)).setAttribute("alto","13" );
      ((Element)v.get(407)).setAttribute("filas","1" );
      ((Element)v.get(407)).setAttribute("id","datosTitle" );
      ((Element)v.get(407)).setAttribute("cod","CarParamCarte.indMontMaxi.label" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */
      /* Termina nodo:406   */
      /* Termina nodo:405   */

      /* Empieza nodo:408 / Elemento padre: 404   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(408)).setAttribute("nombre","indMontMaxiWidgetTrId" );
      ((Element)v.get(404)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(409)).setAttribute("align","left" );
      ((Element)v.get(409)).setAttribute("nowrap","true" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(410)).setAttribute("nombre","indMontMaxi" );
      ((Element)v.get(410)).setAttribute("id","datosCampos" );
      ((Element)v.get(410)).setAttribute("trim","S" );
      ((Element)v.get(410)).setAttribute("max","1" );
      ((Element)v.get(410)).setAttribute("onchange","" );
      ((Element)v.get(410)).setAttribute("req","N" );
      ((Element)v.get(410)).setAttribute("size","1" );
      ((Element)v.get(410)).setAttribute("valor","" );
      ((Element)v.get(410)).setAttribute("validacion","" );
      ((Element)v.get(410)).setAttribute("onblur","" );
      ((Element)v.get(410)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true)" );
      ((Element)v.get(410)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm', 0, false)" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */
      /* Termina nodo:409   */
      /* Termina nodo:408   */

      /* Empieza nodo:411 / Elemento padre: 404   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(411)).setAttribute("nombre","indMontMaxiViewLabelTrId" );
      ((Element)v.get(404)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(412)).setAttribute("valign","top" );
      ((Element)v.get(412)).setAttribute("height","13" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(413)).setAttribute("nombre","lblViewIndMontMaxi" );
      ((Element)v.get(413)).setAttribute("alto","13" );
      ((Element)v.get(413)).setAttribute("ancho","100" );
      ((Element)v.get(413)).setAttribute("id","EstDat" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(413)).setAttribute("valor","" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */
      /* Termina nodo:412   */
      /* Termina nodo:411   */
      /* Termina nodo:404   */
      /* Termina nodo:403   */

      /* Empieza nodo:414 / Elemento padre: 402   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(414)).setAttribute("nombre","indMontMaxiGapTdId" );
      ((Element)v.get(414)).setAttribute("nowrap","true" );
      ((Element)v.get(414)).setAttribute("class","datosCampos" );
      ((Element)v.get(402)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(415)).setAttribute("src","b.gif" );
      ((Element)v.get(415)).setAttribute("width","25" );
      ((Element)v.get(415)).setAttribute("height","8" );
      ((Element)v.get(414)).appendChild((Element)v.get(415));
      /* Termina nodo:415   */
      /* Termina nodo:414   */

      /* Empieza nodo:416 / Elemento padre: 402   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(416)).setAttribute("width","100%" );
      ((Element)v.get(402)).appendChild((Element)v.get(416));

      /* Empieza nodo:417 / Elemento padre: 416   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(417)).setAttribute("src","b.gif" );
      ((Element)v.get(416)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */
      /* Termina nodo:416   */
      /* Termina nodo:402   */
      /* Termina nodo:401   */
      /* Termina nodo:400   */
      /* Termina nodo:397   */

      /* Empieza nodo:418 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(418)).setAttribute("nombre","formGapTr11" );
      ((Element)v.get(40)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(419)).setAttribute("align","center" );
      ((Element)v.get(419)).setAttribute("width","12" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));

      /* Empieza nodo:420 / Elemento padre: 419   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(420)).setAttribute("src","b.gif" );
      ((Element)v.get(420)).setAttribute("width","12" );
      ((Element)v.get(420)).setAttribute("height","8" );
      ((Element)v.get(419)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */
      /* Termina nodo:419   */

      /* Empieza nodo:421 / Elemento padre: 418   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(418)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(422)).setAttribute("src","b.gif" );
      ((Element)v.get(422)).setAttribute("width","8" );
      ((Element)v.get(422)).setAttribute("height","8" );
      ((Element)v.get(421)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */
      /* Termina nodo:421   */

      /* Empieza nodo:423 / Elemento padre: 418   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(423)).setAttribute("align","center" );
      ((Element)v.get(423)).setAttribute("width","12" );
      ((Element)v.get(418)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(424)).setAttribute("src","b.gif" );
      ((Element)v.get(424)).setAttribute("width","12" );
      ((Element)v.get(424)).setAttribute("height","8" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */
      /* Termina nodo:423   */
      /* Termina nodo:418   */

      /* Empieza nodo:425 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(425)).setAttribute("nombre","formTr12" );
      ((Element)v.get(40)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(426)).setAttribute("align","center" );
      ((Element)v.get(426)).setAttribute("width","12" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(427)).setAttribute("src","b.gif" );
      ((Element)v.get(427)).setAttribute("width","12" );
      ((Element)v.get(427)).setAttribute("height","12" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */
      /* Termina nodo:426   */

      /* Empieza nodo:428 / Elemento padre: 425   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(428)).setAttribute("width","100%" );
      ((Element)v.get(425)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(429)).setAttribute("width","100%" );
      ((Element)v.get(429)).setAttribute("border","0" );
      ((Element)v.get(429)).setAttribute("cellspacing","0" );
      ((Element)v.get(429)).setAttribute("cellpadding","0" );
      ((Element)v.get(429)).setAttribute("align","left" );
      ((Element)v.get(428)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(430)).setAttribute("align","left" );
      ((Element)v.get(429)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(431)).setAttribute("nombre","valMontMaxiPermTdId" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(432)).setAttribute("width","100%" );
      ((Element)v.get(432)).setAttribute("border","0" );
      ((Element)v.get(432)).setAttribute("cellspacing","0" );
      ((Element)v.get(432)).setAttribute("cellpadding","0" );
      ((Element)v.get(432)).setAttribute("align","left" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(432)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(434)).setAttribute("valign","top" );
      ((Element)v.get(434)).setAttribute("height","13" );
      ((Element)v.get(433)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(435)).setAttribute("nombre","lblValMontMaxiPerm" );
      ((Element)v.get(435)).setAttribute("alto","13" );
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(435)).setAttribute("filas","1" );
      ((Element)v.get(435)).setAttribute("id","datosTitle" );
      ((Element)v.get(435)).setAttribute("cod","CarParamCarte.valMontMaxiPerm.label" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */
      /* Termina nodo:434   */
      /* Termina nodo:433   */

      /* Empieza nodo:436 / Elemento padre: 432   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(436)).setAttribute("nombre","valMontMaxiPermWidgetTrId" );
      ((Element)v.get(432)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(437)).setAttribute("align","left" );
      ((Element)v.get(437)).setAttribute("nowrap","true" );
      ((Element)v.get(436)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(438)).setAttribute("nombre","valMontMaxiPerm" );
      ((Element)v.get(438)).setAttribute("id","datosCampos" );
      ((Element)v.get(438)).setAttribute("trim","S" );
      ((Element)v.get(438)).setAttribute("max","12" );
      ((Element)v.get(438)).setAttribute("onchange","" );
      ((Element)v.get(438)).setAttribute("req","N" );
      ((Element)v.get(438)).setAttribute("size","12" );
      ((Element)v.get(438)).setAttribute("valor","" );
      ((Element)v.get(438)).setAttribute("validacion","" );
      ((Element)v.get(438)).setAttribute("onblur","" );
      ((Element)v.get(438)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true)" );
      ((Element)v.get(438)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm', 0, false)" );
      ((Element)v.get(437)).appendChild((Element)v.get(438));
      /* Termina nodo:438   */
      /* Termina nodo:437   */
      /* Termina nodo:436   */

      /* Empieza nodo:439 / Elemento padre: 432   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(439)).setAttribute("nombre","valMontMaxiPermViewLabelTrId" );
      ((Element)v.get(432)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(440)).setAttribute("valign","top" );
      ((Element)v.get(440)).setAttribute("height","13" );
      ((Element)v.get(439)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(441)).setAttribute("nombre","lblViewValMontMaxiPerm" );
      ((Element)v.get(441)).setAttribute("alto","13" );
      ((Element)v.get(441)).setAttribute("ancho","100" );
      ((Element)v.get(441)).setAttribute("id","EstDat" );
      ((Element)v.get(441)).setAttribute("valor","" );
      ((Element)v.get(440)).appendChild((Element)v.get(441));
      /* Termina nodo:441   */
      /* Termina nodo:440   */
      /* Termina nodo:439   */
      /* Termina nodo:432   */
      /* Termina nodo:431   */

      /* Empieza nodo:442 / Elemento padre: 430   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(442)).setAttribute("nombre","valMontMaxiPermGapTdId" );
      ((Element)v.get(442)).setAttribute("nowrap","true" );
      ((Element)v.get(442)).setAttribute("class","datosCampos" );
      ((Element)v.get(430)).appendChild((Element)v.get(442));

      /* Empieza nodo:443 / Elemento padre: 442   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(443)).setAttribute("src","b.gif" );
      ((Element)v.get(443)).setAttribute("width","25" );
      ((Element)v.get(443)).setAttribute("height","8" );
      ((Element)v.get(442)).appendChild((Element)v.get(443));
      /* Termina nodo:443   */
      /* Termina nodo:442   */

      /* Empieza nodo:444 / Elemento padre: 430   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(444)).setAttribute("width","100%" );
      ((Element)v.get(430)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(445)).setAttribute("src","b.gif" );
      ((Element)v.get(444)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */
      /* Termina nodo:444   */
      /* Termina nodo:430   */
      /* Termina nodo:429   */
      /* Termina nodo:428   */
      /* Termina nodo:425   */

      /* Empieza nodo:446 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(446)).setAttribute("nombre","formGapTr12" );
      ((Element)v.get(40)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(447)).setAttribute("align","center" );
      ((Element)v.get(447)).setAttribute("width","12" );
      ((Element)v.get(446)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(448)).setAttribute("src","b.gif" );
      ((Element)v.get(448)).setAttribute("width","12" );
      ((Element)v.get(448)).setAttribute("height","8" );
      ((Element)v.get(447)).appendChild((Element)v.get(448));
      /* Termina nodo:448   */
      /* Termina nodo:447   */

      /* Empieza nodo:449 / Elemento padre: 446   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(446)).appendChild((Element)v.get(449));

      /* Empieza nodo:450 / Elemento padre: 449   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(450)).setAttribute("src","b.gif" );
      ((Element)v.get(450)).setAttribute("width","8" );
      ((Element)v.get(450)).setAttribute("height","8" );
      ((Element)v.get(449)).appendChild((Element)v.get(450));
      /* Termina nodo:450   */
      /* Termina nodo:449   */

      /* Empieza nodo:451 / Elemento padre: 446   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(451)).setAttribute("align","center" );
      ((Element)v.get(451)).setAttribute("width","12" );
      ((Element)v.get(446)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(452)).setAttribute("src","b.gif" );
      ((Element)v.get(452)).setAttribute("width","12" );
      ((Element)v.get(452)).setAttribute("height","8" );
      ((Element)v.get(451)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */
      /* Termina nodo:451   */
      /* Termina nodo:446   */

      /* Empieza nodo:453 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(453)).setAttribute("nombre","formTr13" );
      ((Element)v.get(40)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(454)).setAttribute("align","center" );
      ((Element)v.get(454)).setAttribute("width","12" );
      ((Element)v.get(453)).appendChild((Element)v.get(454));

      /* Empieza nodo:455 / Elemento padre: 454   */
   }

   private void getXML2070(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(455)).setAttribute("src","b.gif" );
      ((Element)v.get(455)).setAttribute("width","12" );
      ((Element)v.get(455)).setAttribute("height","12" );
      ((Element)v.get(454)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */
      /* Termina nodo:454   */

      /* Empieza nodo:456 / Elemento padre: 453   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(456)).setAttribute("width","100%" );
      ((Element)v.get(453)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(457)).setAttribute("width","100%" );
      ((Element)v.get(457)).setAttribute("border","0" );
      ((Element)v.get(457)).setAttribute("cellspacing","0" );
      ((Element)v.get(457)).setAttribute("cellpadding","0" );
      ((Element)v.get(457)).setAttribute("align","left" );
      ((Element)v.get(456)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(458)).setAttribute("align","left" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));

      /* Empieza nodo:459 / Elemento padre: 458   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(459)).setAttribute("nombre","indPorcMaxiTdId" );
      ((Element)v.get(458)).appendChild((Element)v.get(459));

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
      ((Element)v.get(460)).appendChild((Element)v.get(461));

      /* Empieza nodo:462 / Elemento padre: 461   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(462)).setAttribute("valign","top" );
      ((Element)v.get(462)).setAttribute("height","13" );
      ((Element)v.get(461)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(463)).setAttribute("nombre","lblIndPorcMaxi" );
      ((Element)v.get(463)).setAttribute("alto","13" );
      ((Element)v.get(463)).setAttribute("filas","1" );
      ((Element)v.get(463)).setAttribute("id","datosTitle" );
      ((Element)v.get(463)).setAttribute("cod","CarParamCarte.indPorcMaxi.label" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */
      /* Termina nodo:462   */
      /* Termina nodo:461   */

      /* Empieza nodo:464 / Elemento padre: 460   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(464)).setAttribute("nombre","indPorcMaxiWidgetTrId" );
      ((Element)v.get(460)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(465)).setAttribute("align","left" );
      ((Element)v.get(465)).setAttribute("nowrap","true" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(466)).setAttribute("nombre","indPorcMaxi" );
      ((Element)v.get(466)).setAttribute("id","datosCampos" );
      ((Element)v.get(466)).setAttribute("trim","S" );
      ((Element)v.get(466)).setAttribute("max","1" );
      ((Element)v.get(466)).setAttribute("onchange","" );
      ((Element)v.get(466)).setAttribute("req","N" );
      ((Element)v.get(466)).setAttribute("size","1" );
      ((Element)v.get(466)).setAttribute("valor","" );
      ((Element)v.get(466)).setAttribute("validacion","" );
      ((Element)v.get(466)).setAttribute("onblur","" );
      ((Element)v.get(466)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true)" );
      ((Element)v.get(466)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm', 0, false)" );
      ((Element)v.get(465)).appendChild((Element)v.get(466));
      /* Termina nodo:466   */
      /* Termina nodo:465   */
      /* Termina nodo:464   */

      /* Empieza nodo:467 / Elemento padre: 460   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(467)).setAttribute("nombre","indPorcMaxiViewLabelTrId" );
      ((Element)v.get(460)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(468)).setAttribute("valign","top" );
      ((Element)v.get(468)).setAttribute("height","13" );
      ((Element)v.get(467)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(469)).setAttribute("nombre","lblViewIndPorcMaxi" );
      ((Element)v.get(469)).setAttribute("alto","13" );
      ((Element)v.get(469)).setAttribute("ancho","100" );
      ((Element)v.get(469)).setAttribute("id","EstDat" );
      ((Element)v.get(469)).setAttribute("valor","" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));
      /* Termina nodo:469   */
      /* Termina nodo:468   */
      /* Termina nodo:467   */
      /* Termina nodo:460   */
      /* Termina nodo:459   */

      /* Empieza nodo:470 / Elemento padre: 458   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(470)).setAttribute("nombre","indPorcMaxiGapTdId" );
      ((Element)v.get(470)).setAttribute("nowrap","true" );
      ((Element)v.get(470)).setAttribute("class","datosCampos" );
      ((Element)v.get(458)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(471)).setAttribute("src","b.gif" );
      ((Element)v.get(471)).setAttribute("width","25" );
      ((Element)v.get(471)).setAttribute("height","8" );
      ((Element)v.get(470)).appendChild((Element)v.get(471));
      /* Termina nodo:471   */
      /* Termina nodo:470   */

      /* Empieza nodo:472 / Elemento padre: 458   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(472)).setAttribute("width","100%" );
      ((Element)v.get(458)).appendChild((Element)v.get(472));

      /* Empieza nodo:473 / Elemento padre: 472   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(473)).setAttribute("src","b.gif" );
      ((Element)v.get(472)).appendChild((Element)v.get(473));
      /* Termina nodo:473   */
      /* Termina nodo:472   */
      /* Termina nodo:458   */
      /* Termina nodo:457   */
      /* Termina nodo:456   */
      /* Termina nodo:453   */

      /* Empieza nodo:474 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(474)).setAttribute("nombre","formGapTr13" );
      ((Element)v.get(40)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(475)).setAttribute("align","center" );
      ((Element)v.get(475)).setAttribute("width","12" );
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
      ((Element)v.get(479)).setAttribute("width","12" );
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

      /* Empieza nodo:481 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(481)).setAttribute("nombre","formTr14" );
      ((Element)v.get(40)).appendChild((Element)v.get(481));

      /* Empieza nodo:482 / Elemento padre: 481   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(482)).setAttribute("align","center" );
      ((Element)v.get(482)).setAttribute("width","12" );
      ((Element)v.get(481)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(483)).setAttribute("src","b.gif" );
      ((Element)v.get(483)).setAttribute("width","12" );
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
      ((Element)v.get(487)).setAttribute("nombre","valPorcTdId" );
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
      ((Element)v.get(491)).setAttribute("nombre","lblValPorc" );
      ((Element)v.get(491)).setAttribute("alto","13" );
      ((Element)v.get(491)).setAttribute("filas","1" );
      ((Element)v.get(491)).setAttribute("id","datosTitle" );
      ((Element)v.get(491)).setAttribute("cod","CarParamCarte.valPorc.label" );
      ((Element)v.get(490)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */
      /* Termina nodo:490   */
      /* Termina nodo:489   */

      /* Empieza nodo:492 / Elemento padre: 488   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(492)).setAttribute("nombre","valPorcWidgetTrId" );
      ((Element)v.get(488)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(493)).setAttribute("align","left" );
      ((Element)v.get(493)).setAttribute("nowrap","true" );
      ((Element)v.get(492)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(494)).setAttribute("nombre","valPorc" );
      ((Element)v.get(494)).setAttribute("id","datosCampos" );
      ((Element)v.get(494)).setAttribute("trim","S" );
      ((Element)v.get(494)).setAttribute("max","5" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(494)).setAttribute("onchange","" );
      ((Element)v.get(494)).setAttribute("req","N" );
      ((Element)v.get(494)).setAttribute("size","5" );
      ((Element)v.get(494)).setAttribute("valor","" );
      ((Element)v.get(494)).setAttribute("validacion","" );
      ((Element)v.get(494)).setAttribute("onblur","" );
      ((Element)v.get(494)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true)" );
      ((Element)v.get(494)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm', 0, false)" );
      ((Element)v.get(493)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */
      /* Termina nodo:493   */
      /* Termina nodo:492   */

      /* Empieza nodo:495 / Elemento padre: 488   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(495)).setAttribute("nombre","valPorcViewLabelTrId" );
      ((Element)v.get(488)).appendChild((Element)v.get(495));

      /* Empieza nodo:496 / Elemento padre: 495   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(496)).setAttribute("valign","top" );
      ((Element)v.get(496)).setAttribute("height","13" );
      ((Element)v.get(495)).appendChild((Element)v.get(496));

      /* Empieza nodo:497 / Elemento padre: 496   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(497)).setAttribute("nombre","lblViewValPorc" );
      ((Element)v.get(497)).setAttribute("alto","13" );
      ((Element)v.get(497)).setAttribute("ancho","100" );
      ((Element)v.get(497)).setAttribute("id","EstDat" );
      ((Element)v.get(497)).setAttribute("valor","" );
      ((Element)v.get(496)).appendChild((Element)v.get(497));
      /* Termina nodo:497   */
      /* Termina nodo:496   */
      /* Termina nodo:495   */
      /* Termina nodo:488   */
      /* Termina nodo:487   */

      /* Empieza nodo:498 / Elemento padre: 486   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(498)).setAttribute("nombre","valPorcGapTdId" );
      ((Element)v.get(498)).setAttribute("nowrap","true" );
      ((Element)v.get(498)).setAttribute("class","datosCampos" );
      ((Element)v.get(486)).appendChild((Element)v.get(498));

      /* Empieza nodo:499 / Elemento padre: 498   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(499)).setAttribute("src","b.gif" );
      ((Element)v.get(499)).setAttribute("width","25" );
      ((Element)v.get(499)).setAttribute("height","8" );
      ((Element)v.get(498)).appendChild((Element)v.get(499));
      /* Termina nodo:499   */
      /* Termina nodo:498   */

      /* Empieza nodo:500 / Elemento padre: 486   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(500)).setAttribute("width","100%" );
      ((Element)v.get(486)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(501)).setAttribute("src","b.gif" );
      ((Element)v.get(500)).appendChild((Element)v.get(501));
      /* Termina nodo:501   */
      /* Termina nodo:500   */
      /* Termina nodo:486   */
      /* Termina nodo:485   */
      /* Termina nodo:484   */
      /* Termina nodo:481   */

      /* Empieza nodo:502 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(502)).setAttribute("nombre","formGapTr14" );
      ((Element)v.get(40)).appendChild((Element)v.get(502));

      /* Empieza nodo:503 / Elemento padre: 502   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(503)).setAttribute("align","center" );
      ((Element)v.get(503)).setAttribute("width","12" );
      ((Element)v.get(502)).appendChild((Element)v.get(503));

      /* Empieza nodo:504 / Elemento padre: 503   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(504)).setAttribute("src","b.gif" );
      ((Element)v.get(504)).setAttribute("width","12" );
      ((Element)v.get(504)).setAttribute("height","8" );
      ((Element)v.get(503)).appendChild((Element)v.get(504));
      /* Termina nodo:504   */
      /* Termina nodo:503   */

      /* Empieza nodo:505 / Elemento padre: 502   */
      v.add(doc.createElement("TD"));
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
      v.add(doc.createElement("TD"));
      ((Element)v.get(507)).setAttribute("align","center" );
      ((Element)v.get(507)).setAttribute("width","12" );
      ((Element)v.get(502)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(508)).setAttribute("src","b.gif" );
      ((Element)v.get(508)).setAttribute("width","12" );
      ((Element)v.get(508)).setAttribute("height","8" );
      ((Element)v.get(507)).appendChild((Element)v.get(508));
      /* Termina nodo:508   */
      /* Termina nodo:507   */
      /* Termina nodo:502   */

      /* Empieza nodo:509 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(509)).setAttribute("nombre","formTr15" );
      ((Element)v.get(40)).appendChild((Element)v.get(509));

      /* Empieza nodo:510 / Elemento padre: 509   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(510)).setAttribute("align","center" );
      ((Element)v.get(510)).setAttribute("width","12" );
      ((Element)v.get(509)).appendChild((Element)v.get(510));

      /* Empieza nodo:511 / Elemento padre: 510   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(511)).setAttribute("src","b.gif" );
      ((Element)v.get(511)).setAttribute("width","12" );
      ((Element)v.get(511)).setAttribute("height","12" );
      ((Element)v.get(510)).appendChild((Element)v.get(511));
      /* Termina nodo:511   */
      /* Termina nodo:510   */

      /* Empieza nodo:512 / Elemento padre: 509   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(512)).setAttribute("width","100%" );
      ((Element)v.get(509)).appendChild((Element)v.get(512));

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
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(514)).setAttribute("align","left" );
      ((Element)v.get(513)).appendChild((Element)v.get(514));

      /* Empieza nodo:515 / Elemento padre: 514   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(515)).setAttribute("nombre","numDiasAdicTdId" );
      ((Element)v.get(514)).appendChild((Element)v.get(515));

      /* Empieza nodo:516 / Elemento padre: 515   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(516)).setAttribute("width","100%" );
      ((Element)v.get(516)).setAttribute("border","0" );
      ((Element)v.get(516)).setAttribute("cellspacing","0" );
      ((Element)v.get(516)).setAttribute("cellpadding","0" );
      ((Element)v.get(516)).setAttribute("align","left" );
      ((Element)v.get(515)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(516)).appendChild((Element)v.get(517));

      /* Empieza nodo:518 / Elemento padre: 517   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(518)).setAttribute("valign","top" );
      ((Element)v.get(518)).setAttribute("height","13" );
      ((Element)v.get(517)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(519)).setAttribute("nombre","lblNumDiasAdic" );
      ((Element)v.get(519)).setAttribute("alto","13" );
      ((Element)v.get(519)).setAttribute("filas","1" );
      ((Element)v.get(519)).setAttribute("id","datosTitle" );
      ((Element)v.get(519)).setAttribute("cod","CarParamCarte.numDiasAdic.label" );
      ((Element)v.get(518)).appendChild((Element)v.get(519));
      /* Termina nodo:519   */
      /* Termina nodo:518   */
      /* Termina nodo:517   */

      /* Empieza nodo:520 / Elemento padre: 516   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(520)).setAttribute("nombre","numDiasAdicWidgetTrId" );
      ((Element)v.get(516)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(521)).setAttribute("align","left" );
      ((Element)v.get(521)).setAttribute("nowrap","true" );
      ((Element)v.get(520)).appendChild((Element)v.get(521));

      /* Empieza nodo:522 / Elemento padre: 521   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(522)).setAttribute("nombre","numDiasAdic" );
      ((Element)v.get(522)).setAttribute("id","datosCampos" );
      ((Element)v.get(522)).setAttribute("trim","S" );
      ((Element)v.get(522)).setAttribute("max","3" );
      ((Element)v.get(522)).setAttribute("onchange","" );
      ((Element)v.get(522)).setAttribute("req","N" );
      ((Element)v.get(522)).setAttribute("size","3" );
      ((Element)v.get(522)).setAttribute("valor","" );
      ((Element)v.get(522)).setAttribute("validacion","" );
      ((Element)v.get(522)).setAttribute("onblur","" );
      ((Element)v.get(522)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true)" );
      ((Element)v.get(522)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm', 0, false)" );
      ((Element)v.get(521)).appendChild((Element)v.get(522));
      /* Termina nodo:522   */
      /* Termina nodo:521   */
      /* Termina nodo:520   */

      /* Empieza nodo:523 / Elemento padre: 516   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(523)).setAttribute("nombre","numDiasAdicViewLabelTrId" );
      ((Element)v.get(516)).appendChild((Element)v.get(523));

      /* Empieza nodo:524 / Elemento padre: 523   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(524)).setAttribute("valign","top" );
      ((Element)v.get(524)).setAttribute("height","13" );
      ((Element)v.get(523)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(525)).setAttribute("nombre","lblViewNumDiasAdic" );
      ((Element)v.get(525)).setAttribute("alto","13" );
      ((Element)v.get(525)).setAttribute("ancho","100" );
      ((Element)v.get(525)).setAttribute("id","EstDat" );
      ((Element)v.get(525)).setAttribute("valor","" );
      ((Element)v.get(524)).appendChild((Element)v.get(525));
      /* Termina nodo:525   */
      /* Termina nodo:524   */
      /* Termina nodo:523   */
      /* Termina nodo:516   */
      /* Termina nodo:515   */

      /* Empieza nodo:526 / Elemento padre: 514   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(526)).setAttribute("nombre","numDiasAdicGapTdId" );
      ((Element)v.get(526)).setAttribute("nowrap","true" );
      ((Element)v.get(526)).setAttribute("class","datosCampos" );
      ((Element)v.get(514)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(527)).setAttribute("src","b.gif" );
      ((Element)v.get(527)).setAttribute("width","25" );
      ((Element)v.get(527)).setAttribute("height","8" );
      ((Element)v.get(526)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */
      /* Termina nodo:526   */

      /* Empieza nodo:528 / Elemento padre: 514   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(528)).setAttribute("width","100%" );
      ((Element)v.get(514)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(529)).setAttribute("src","b.gif" );
      ((Element)v.get(528)).appendChild((Element)v.get(529));
      /* Termina nodo:529   */
      /* Termina nodo:528   */
      /* Termina nodo:514   */
      /* Termina nodo:513   */
      /* Termina nodo:512   */
      /* Termina nodo:509   */

      /* Empieza nodo:530 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(530)).setAttribute("nombre","formGapTr15" );
      ((Element)v.get(40)).appendChild((Element)v.get(530));

      /* Empieza nodo:531 / Elemento padre: 530   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(531)).setAttribute("align","center" );
      ((Element)v.get(531)).setAttribute("width","12" );
      ((Element)v.get(530)).appendChild((Element)v.get(531));

      /* Empieza nodo:532 / Elemento padre: 531   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(532)).setAttribute("src","b.gif" );
      ((Element)v.get(532)).setAttribute("width","12" );
      ((Element)v.get(532)).setAttribute("height","8" );
      ((Element)v.get(531)).appendChild((Element)v.get(532));
      /* Termina nodo:532   */
      /* Termina nodo:531   */

      /* Empieza nodo:533 / Elemento padre: 530   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(530)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
   }

   private void getXML2430(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(534)).setAttribute("src","b.gif" );
      ((Element)v.get(534)).setAttribute("width","8" );
      ((Element)v.get(534)).setAttribute("height","8" );
      ((Element)v.get(533)).appendChild((Element)v.get(534));
      /* Termina nodo:534   */
      /* Termina nodo:533   */

      /* Empieza nodo:535 / Elemento padre: 530   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(535)).setAttribute("align","center" );
      ((Element)v.get(535)).setAttribute("width","12" );
      ((Element)v.get(530)).appendChild((Element)v.get(535));

      /* Empieza nodo:536 / Elemento padre: 535   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(536)).setAttribute("src","b.gif" );
      ((Element)v.get(536)).setAttribute("width","12" );
      ((Element)v.get(536)).setAttribute("height","8" );
      ((Element)v.get(535)).appendChild((Element)v.get(536));
      /* Termina nodo:536   */
      /* Termina nodo:535   */
      /* Termina nodo:530   */

      /* Empieza nodo:537 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(537)).setAttribute("nombre","formTr16" );
      ((Element)v.get(40)).appendChild((Element)v.get(537));

      /* Empieza nodo:538 / Elemento padre: 537   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(538)).setAttribute("align","center" );
      ((Element)v.get(538)).setAttribute("width","12" );
      ((Element)v.get(537)).appendChild((Element)v.get(538));

      /* Empieza nodo:539 / Elemento padre: 538   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(539)).setAttribute("src","b.gif" );
      ((Element)v.get(539)).setAttribute("width","12" );
      ((Element)v.get(539)).setAttribute("height","12" );
      ((Element)v.get(538)).appendChild((Element)v.get(539));
      /* Termina nodo:539   */
      /* Termina nodo:538   */

      /* Empieza nodo:540 / Elemento padre: 537   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(540)).setAttribute("width","100%" );
      ((Element)v.get(537)).appendChild((Element)v.get(540));

      /* Empieza nodo:541 / Elemento padre: 540   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(541)).setAttribute("width","100%" );
      ((Element)v.get(541)).setAttribute("border","0" );
      ((Element)v.get(541)).setAttribute("cellspacing","0" );
      ((Element)v.get(541)).setAttribute("cellpadding","0" );
      ((Element)v.get(541)).setAttribute("align","left" );
      ((Element)v.get(540)).appendChild((Element)v.get(541));

      /* Empieza nodo:542 / Elemento padre: 541   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(542)).setAttribute("align","left" );
      ((Element)v.get(541)).appendChild((Element)v.get(542));

      /* Empieza nodo:543 / Elemento padre: 542   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(543)).setAttribute("nombre","invaOidIndiValiTdId" );
      ((Element)v.get(542)).appendChild((Element)v.get(543));

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
      ((Element)v.get(547)).setAttribute("nombre","lblinvaOidIndiVali" );
      ((Element)v.get(547)).setAttribute("id","datosTitle" );
      ((Element)v.get(547)).setAttribute("ancho","100" );
      ((Element)v.get(547)).setAttribute("alto","13" );
      ((Element)v.get(547)).setAttribute("cod","CarParamCarte.invaOidIndiVali.label" );
      ((Element)v.get(546)).appendChild((Element)v.get(547));
      /* Termina nodo:547   */
      /* Termina nodo:546   */
      /* Termina nodo:545   */

      /* Empieza nodo:548 / Elemento padre: 544   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(548)).setAttribute("nombre","invaOidIndiValiWidgetTrId" );
      ((Element)v.get(544)).appendChild((Element)v.get(548));

      /* Empieza nodo:549 / Elemento padre: 548   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(549)).setAttribute("align","left" );
      ((Element)v.get(549)).setAttribute("nowrap","true" );
      ((Element)v.get(548)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(550)).setAttribute("nombre","invaOidIndiVali" );
      ((Element)v.get(550)).setAttribute("id","datosCampos" );
      ((Element)v.get(550)).setAttribute("multiple","N" );
      ((Element)v.get(550)).setAttribute("req","N" );
      ((Element)v.get(550)).setAttribute("size","1" );
      ((Element)v.get(550)).setAttribute("validacion","" );
      ((Element)v.get(550)).setAttribute("onchange","" );
      ((Element)v.get(550)).setAttribute("onfocus","" );
      ((Element)v.get(550)).setAttribute("valorinicial","" );
      ((Element)v.get(550)).setAttribute("textoinicial","" );
      ((Element)v.get(550)).setAttribute("ontab","ejecutarAccionFoco('carParamCarteFrm',0, true);" );
      ((Element)v.get(550)).setAttribute("onshtab","ejecutarAccionFoco('carParamCarteFrm',0, false);" );
      ((Element)v.get(549)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(550)).appendChild((Element)v.get(551));
      /* Termina nodo:551   */
      /* Termina nodo:550   */
      /* Termina nodo:549   */
      /* Termina nodo:548   */

      /* Empieza nodo:552 / Elemento padre: 544   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(552)).setAttribute("nombre","invaOidIndiValiViewLabelTrId" );
      ((Element)v.get(544)).appendChild((Element)v.get(552));

      /* Empieza nodo:553 / Elemento padre: 552   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(553)).setAttribute("valign","top" );
      ((Element)v.get(553)).setAttribute("height","13" );
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(553)).setAttribute("width","50" );
      ((Element)v.get(552)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(554)).setAttribute("nombre","lblViewInvaOidIndiVali" );
      ((Element)v.get(554)).setAttribute("alto","13" );
      ((Element)v.get(554)).setAttribute("filas","1" );
      ((Element)v.get(554)).setAttribute("id","EstDat" );
      ((Element)v.get(554)).setAttribute("valor","" );
      ((Element)v.get(553)).appendChild((Element)v.get(554));
      /* Termina nodo:554   */
      /* Termina nodo:553   */
      /* Termina nodo:552   */
      /* Termina nodo:544   */
      /* Termina nodo:543   */

      /* Empieza nodo:555 / Elemento padre: 542   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(555)).setAttribute("nombre","invaOidIndiValiGapTdId" );
      ((Element)v.get(555)).setAttribute("nowrap","true" );
      ((Element)v.get(555)).setAttribute("class","datosCampos" );
      ((Element)v.get(542)).appendChild((Element)v.get(555));

      /* Empieza nodo:556 / Elemento padre: 555   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(556)).setAttribute("src","b.gif" );
      ((Element)v.get(556)).setAttribute("width","25" );
      ((Element)v.get(556)).setAttribute("height","8" );
      ((Element)v.get(555)).appendChild((Element)v.get(556));
      /* Termina nodo:556   */
      /* Termina nodo:555   */

      /* Empieza nodo:557 / Elemento padre: 542   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(557)).setAttribute("width","100%" );
      ((Element)v.get(542)).appendChild((Element)v.get(557));

      /* Empieza nodo:558 / Elemento padre: 557   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(558)).setAttribute("src","b.gif" );
      ((Element)v.get(557)).appendChild((Element)v.get(558));
      /* Termina nodo:558   */
      /* Termina nodo:557   */
      /* Termina nodo:542   */
      /* Termina nodo:541   */
      /* Termina nodo:540   */

      /* Empieza nodo:559 / Elemento padre: 537   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(559)).setAttribute("width","100%" );
      ((Element)v.get(537)).appendChild((Element)v.get(559));
      /* Termina nodo:559   */
      /* Termina nodo:537   */

      /* Empieza nodo:560 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(560)).setAttribute("nombre","formGapTr16" );
      ((Element)v.get(40)).appendChild((Element)v.get(560));

      /* Empieza nodo:561 / Elemento padre: 560   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(561)).setAttribute("align","center" );
      ((Element)v.get(561)).setAttribute("width","12" );
      ((Element)v.get(560)).appendChild((Element)v.get(561));

      /* Empieza nodo:562 / Elemento padre: 561   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(562)).setAttribute("src","b.gif" );
      ((Element)v.get(562)).setAttribute("width","12" );
      ((Element)v.get(562)).setAttribute("height","8" );
      ((Element)v.get(561)).appendChild((Element)v.get(562));
      /* Termina nodo:562   */
      /* Termina nodo:561   */

      /* Empieza nodo:563 / Elemento padre: 560   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(560)).appendChild((Element)v.get(563));

      /* Empieza nodo:564 / Elemento padre: 563   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(564)).setAttribute("src","b.gif" );
      ((Element)v.get(564)).setAttribute("width","8" );
      ((Element)v.get(564)).setAttribute("height","8" );
      ((Element)v.get(563)).appendChild((Element)v.get(564));
      /* Termina nodo:564   */
      /* Termina nodo:563   */

      /* Empieza nodo:565 / Elemento padre: 560   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(565)).setAttribute("align","center" );
      ((Element)v.get(565)).setAttribute("width","12" );
      ((Element)v.get(560)).appendChild((Element)v.get(565));

      /* Empieza nodo:566 / Elemento padre: 565   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(566)).setAttribute("src","b.gif" );
      ((Element)v.get(566)).setAttribute("width","12" );
      ((Element)v.get(566)).setAttribute("height","8" );
      ((Element)v.get(565)).appendChild((Element)v.get(566));
      /* Termina nodo:566   */
      /* Termina nodo:565   */
      /* Termina nodo:560   */
      /* Termina nodo:40   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:567 / Elemento padre: 33   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(567)).setAttribute("align","center" );
      ((Element)v.get(567)).setAttribute("width","12" );
      ((Element)v.get(33)).appendChild((Element)v.get(567));

      /* Empieza nodo:568 / Elemento padre: 567   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(568)).setAttribute("src","b.gif" );
      ((Element)v.get(568)).setAttribute("width","12" );
      ((Element)v.get(568)).setAttribute("height","12" );
      ((Element)v.get(567)).appendChild((Element)v.get(568));
      /* Termina nodo:568   */
      /* Termina nodo:567   */
      /* Termina nodo:33   */

      /* Empieza nodo:569 / Elemento padre: 25   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(569)).setAttribute("nombre","carParamCarteTrButtons" );
      ((Element)v.get(25)).appendChild((Element)v.get(569));

      /* Empieza nodo:570 / Elemento padre: 569   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(570)).setAttribute("align","center" );
      ((Element)v.get(570)).setAttribute("width","12" );
      ((Element)v.get(569)).appendChild((Element)v.get(570));

      /* Empieza nodo:571 / Elemento padre: 570   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(571)).setAttribute("src","b.gif" );
      ((Element)v.get(571)).setAttribute("width","12" );
      ((Element)v.get(571)).setAttribute("height","12" );
      ((Element)v.get(570)).appendChild((Element)v.get(571));
      /* Termina nodo:571   */
      /* Termina nodo:570   */

      /* Empieza nodo:572 / Elemento padre: 569   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(569)).appendChild((Element)v.get(572));

      /* Empieza nodo:573 / Elemento padre: 572   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(572)).appendChild((Element)v.get(573));

      /* Empieza nodo:574 / Elemento padre: 573   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(574)).setAttribute("width","100%" );
      ((Element)v.get(574)).setAttribute("border","0" );
      ((Element)v.get(574)).setAttribute("align","center" );
      ((Element)v.get(574)).setAttribute("cellspacing","0" );
      ((Element)v.get(574)).setAttribute("cellpadding","0" );
      ((Element)v.get(573)).appendChild((Element)v.get(574));

      /* Empieza nodo:575 / Elemento padre: 574   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(574)).appendChild((Element)v.get(575));

      /* Empieza nodo:576 / Elemento padre: 575   */
   }

   private void getXML2610(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(576)).setAttribute("class","tablaTitle" );
      ((Element)v.get(576)).setAttribute("nombre","carParamCarteTdQueryButton" );
      ((Element)v.get(575)).appendChild((Element)v.get(576));

      /* Empieza nodo:577 / Elemento padre: 576   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(577)).setAttribute("nombre","carParamCarteQueryButton" );
      ((Element)v.get(577)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(577)).setAttribute("estado","false" );
      ((Element)v.get(577)).setAttribute("accion","carParamCarteFirstPage();" );
      ((Element)v.get(577)).setAttribute("tipo","html" );
      ((Element)v.get(577)).setAttribute("ID","botonContenido" );
      ((Element)v.get(576)).appendChild((Element)v.get(577));
      /* Termina nodo:577   */
      /* Termina nodo:576   */

      /* Empieza nodo:578 / Elemento padre: 575   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(578)).setAttribute("class","tablaTitle" );
      ((Element)v.get(578)).setAttribute("nombre","carParamCarteTdLovNullSelectionButton" );
      ((Element)v.get(578)).setAttribute("align","left" );
      ((Element)v.get(578)).setAttribute("width","100%" );
      ((Element)v.get(575)).appendChild((Element)v.get(578));

      /* Empieza nodo:579 / Elemento padre: 578   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(579)).setAttribute("src","b.gif" );
      ((Element)v.get(579)).setAttribute("height","8" );
      ((Element)v.get(579)).setAttribute("width","8" );
      ((Element)v.get(578)).appendChild((Element)v.get(579));
      /* Termina nodo:579   */

      /* Empieza nodo:580 / Elemento padre: 578   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(580)).setAttribute("nombre","carParamCarteLovNullButton" );
      ((Element)v.get(580)).setAttribute("ID","botonContenido" );
      ((Element)v.get(580)).setAttribute("tipo","html" );
      ((Element)v.get(580)).setAttribute("accion","carParamCarteLovNullSelectionAction();" );
      ((Element)v.get(580)).setAttribute("estado","true" );
      ((Element)v.get(580)).setAttribute("cod","MMGGlobal.lovNullButton.label" );
      ((Element)v.get(578)).appendChild((Element)v.get(580));
      /* Termina nodo:580   */
      /* Termina nodo:578   */
      /* Termina nodo:575   */
      /* Termina nodo:574   */
      /* Termina nodo:573   */
      /* Termina nodo:572   */

      /* Empieza nodo:581 / Elemento padre: 569   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(581)).setAttribute("align","center" );
      ((Element)v.get(581)).setAttribute("width","12" );
      ((Element)v.get(569)).appendChild((Element)v.get(581));

      /* Empieza nodo:582 / Elemento padre: 581   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(582)).setAttribute("src","b.gif" );
      ((Element)v.get(582)).setAttribute("width","12" );
      ((Element)v.get(582)).setAttribute("height","12" );
      ((Element)v.get(581)).appendChild((Element)v.get(582));
      /* Termina nodo:582   */
      /* Termina nodo:581   */
      /* Termina nodo:569   */
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:583 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(583)).setAttribute("nombre","carParamCartePreListLayer" );
      ((Element)v.get(583)).setAttribute("alto","23" );
      ((Element)v.get(583)).setAttribute("ancho","100%" );
      ((Element)v.get(583)).setAttribute("colorf","" );
      ((Element)v.get(583)).setAttribute("borde","0" );
      ((Element)v.get(583)).setAttribute("imagenf","" );
      ((Element)v.get(583)).setAttribute("repeat","" );
      ((Element)v.get(583)).setAttribute("padding","" );
      ((Element)v.get(583)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(583)).setAttribute("contravsb","" );
      ((Element)v.get(583)).setAttribute("x","0" );
      ((Element)v.get(583)).setAttribute("y","0" );
      ((Element)v.get(583)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("table"));
      ((Element)v.get(584)).setAttribute("width","100%" );
      ((Element)v.get(584)).setAttribute("border","0" );
      ((Element)v.get(584)).setAttribute("align","center" );
      ((Element)v.get(584)).setAttribute("cellspacing","0" );
      ((Element)v.get(584)).setAttribute("cellpadding","0" );
      ((Element)v.get(583)).appendChild((Element)v.get(584));

      /* Empieza nodo:585 / Elemento padre: 584   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(584)).appendChild((Element)v.get(585));

      /* Empieza nodo:586 / Elemento padre: 585   */
      v.add(doc.createElement("td"));
      ((Element)v.get(586)).setAttribute("width","12" );
      ((Element)v.get(586)).setAttribute("align","center" );
      ((Element)v.get(585)).appendChild((Element)v.get(586));

      /* Empieza nodo:587 / Elemento padre: 586   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(587)).setAttribute("src","b.gif" );
      ((Element)v.get(587)).setAttribute("width","12" );
      ((Element)v.get(587)).setAttribute("height","1" );
      ((Element)v.get(586)).appendChild((Element)v.get(587));
      /* Termina nodo:587   */
      /* Termina nodo:586   */

      /* Empieza nodo:588 / Elemento padre: 585   */
      v.add(doc.createElement("td"));
      ((Element)v.get(588)).setAttribute("width","750" );
      ((Element)v.get(585)).appendChild((Element)v.get(588));

      /* Empieza nodo:589 / Elemento padre: 588   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(589)).setAttribute("src","b.gif" );
      ((Element)v.get(588)).appendChild((Element)v.get(589));
      /* Termina nodo:589   */
      /* Termina nodo:588   */

      /* Empieza nodo:590 / Elemento padre: 585   */
      v.add(doc.createElement("td"));
      ((Element)v.get(590)).setAttribute("width","12" );
      ((Element)v.get(585)).appendChild((Element)v.get(590));

      /* Empieza nodo:591 / Elemento padre: 590   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(591)).setAttribute("src","b.gif" );
      ((Element)v.get(591)).setAttribute("width","12" );
      ((Element)v.get(591)).setAttribute("height","1" );
      ((Element)v.get(590)).appendChild((Element)v.get(591));
      /* Termina nodo:591   */
      /* Termina nodo:590   */
      /* Termina nodo:585   */

      /* Empieza nodo:592 / Elemento padre: 584   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(584)).appendChild((Element)v.get(592));

      /* Empieza nodo:593 / Elemento padre: 592   */
      v.add(doc.createElement("td"));
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(592)).appendChild((Element)v.get(593));

      /* Empieza nodo:594 / Elemento padre: 593   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(594)).setAttribute("src","b.gif" );
      ((Element)v.get(593)).appendChild((Element)v.get(594));
      /* Termina nodo:594   */
      /* Termina nodo:593   */

      /* Empieza nodo:595 / Elemento padre: 592   */
      v.add(doc.createElement("td"));
      ((Element)v.get(592)).appendChild((Element)v.get(595));

      /* Empieza nodo:596 / Elemento padre: 595   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(595)).appendChild((Element)v.get(596));

      /* Empieza nodo:597 / Elemento padre: 596   */
      v.add(doc.createElement("table"));
      ((Element)v.get(597)).setAttribute("width","100%" );
      ((Element)v.get(597)).setAttribute("border","0" );
      ((Element)v.get(597)).setAttribute("align","center" );
      ((Element)v.get(597)).setAttribute("cellspacing","0" );
      ((Element)v.get(597)).setAttribute("cellpadding","0" );
      ((Element)v.get(596)).appendChild((Element)v.get(597));

      /* Empieza nodo:598 / Elemento padre: 597   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(597)).appendChild((Element)v.get(598));

      /* Empieza nodo:599 / Elemento padre: 598   */
      v.add(doc.createElement("td"));
      ((Element)v.get(599)).setAttribute("bgcolor","#CCCCCC" );
      ((Element)v.get(599)).setAttribute("width","4" );
      ((Element)v.get(598)).appendChild((Element)v.get(599));

      /* Empieza nodo:600 / Elemento padre: 599   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(600)).setAttribute("src","b.gif" );
      ((Element)v.get(600)).setAttribute("width","4" );
      ((Element)v.get(600)).setAttribute("height","4" );
      ((Element)v.get(599)).appendChild((Element)v.get(600));
      /* Termina nodo:600   */
      /* Termina nodo:599   */

      /* Empieza nodo:601 / Elemento padre: 598   */
      v.add(doc.createElement("td"));
      ((Element)v.get(601)).setAttribute("bgcolor","#CCCCCC" );
      ((Element)v.get(601)).setAttribute("valign","middle" );
      ((Element)v.get(598)).appendChild((Element)v.get(601));

      /* Empieza nodo:602 / Elemento padre: 601   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(602)).setAttribute("nombre","lblResultSearch" );
      ((Element)v.get(602)).setAttribute("ancho","108" );
      ((Element)v.get(602)).setAttribute("alto","17" );
      ((Element)v.get(602)).setAttribute("id","EstCab" );
      ((Element)v.get(602)).setAttribute("cod","MMGGlobal.legend.resultlegend.label" );
      ((Element)v.get(601)).appendChild((Element)v.get(602));
      /* Termina nodo:602   */
      /* Termina nodo:601   */
      /* Termina nodo:598   */
      /* Termina nodo:597   */
      /* Termina nodo:596   */
      /* Termina nodo:595   */

      /* Empieza nodo:603 / Elemento padre: 592   */
      v.add(doc.createElement("td"));
      ((Element)v.get(603)).setAttribute("width","12" );
      ((Element)v.get(592)).appendChild((Element)v.get(603));

      /* Empieza nodo:604 / Elemento padre: 603   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(604)).setAttribute("src","b.gif" );
      ((Element)v.get(604)).setAttribute("width","12" );
      ((Element)v.get(604)).setAttribute("height","12" );
      ((Element)v.get(603)).appendChild((Element)v.get(604));
      /* Termina nodo:604   */
      /* Termina nodo:603   */
      /* Termina nodo:592   */

      /* Empieza nodo:605 / Elemento padre: 584   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(584)).appendChild((Element)v.get(605));

      /* Empieza nodo:606 / Elemento padre: 605   */
      v.add(doc.createElement("td"));
      ((Element)v.get(606)).setAttribute("width","12" );
      ((Element)v.get(606)).setAttribute("align","center" );
      ((Element)v.get(605)).appendChild((Element)v.get(606));

      /* Empieza nodo:607 / Elemento padre: 606   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(607)).setAttribute("src","b.gif" );
      ((Element)v.get(607)).setAttribute("width","12" );
      ((Element)v.get(607)).setAttribute("height","1" );
      ((Element)v.get(606)).appendChild((Element)v.get(607));
      /* Termina nodo:607   */
      /* Termina nodo:606   */

      /* Empieza nodo:608 / Elemento padre: 605   */
      v.add(doc.createElement("td"));
      ((Element)v.get(608)).setAttribute("width","750" );
      ((Element)v.get(605)).appendChild((Element)v.get(608));

      /* Empieza nodo:609 / Elemento padre: 608   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(609)).setAttribute("src","b.gif" );
      ((Element)v.get(608)).appendChild((Element)v.get(609));
      /* Termina nodo:609   */
      /* Termina nodo:608   */

      /* Empieza nodo:610 / Elemento padre: 605   */
      v.add(doc.createElement("td"));
      ((Element)v.get(610)).setAttribute("width","12" );
      ((Element)v.get(605)).appendChild((Element)v.get(610));

      /* Empieza nodo:611 / Elemento padre: 610   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(611)).setAttribute("src","b.gif" );
      ((Element)v.get(611)).setAttribute("width","12" );
      ((Element)v.get(611)).setAttribute("height","1" );
      ((Element)v.get(610)).appendChild((Element)v.get(611));
      /* Termina nodo:611   */
      /* Termina nodo:610   */
      /* Termina nodo:605   */
      /* Termina nodo:584   */
      /* Termina nodo:583   */

      /* Empieza nodo:612 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(612)).setAttribute("nombre","carParamCarteListLayer" );
      ((Element)v.get(612)).setAttribute("alto","310" );
      ((Element)v.get(612)).setAttribute("ancho","99%" );
      ((Element)v.get(612)).setAttribute("colorf","" );
      ((Element)v.get(612)).setAttribute("borde","0" );
      ((Element)v.get(612)).setAttribute("imagenf","" );
      ((Element)v.get(612)).setAttribute("repeat","" );
      ((Element)v.get(612)).setAttribute("padding","" );
      ((Element)v.get(612)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(612)).setAttribute("contravsb","" );
      ((Element)v.get(612)).setAttribute("x","3" );
      ((Element)v.get(612)).setAttribute("y","" );
      ((Element)v.get(612)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(612));

      /* Empieza nodo:613 / Elemento padre: 612   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(613)).setAttribute("nombre","carParamCarteList" );
      ((Element)v.get(613)).setAttribute("ancho","680" );
      ((Element)v.get(613)).setAttribute("alto","275" );
      ((Element)v.get(613)).setAttribute("x","12" );
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(613)).setAttribute("y","0" );
      ((Element)v.get(613)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(613)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(612)).appendChild((Element)v.get(613));

      /* Empieza nodo:614 / Elemento padre: 613   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(614)).setAttribute("precarga","S" );
      ((Element)v.get(614)).setAttribute("conROver","S" );
      ((Element)v.get(613)).appendChild((Element)v.get(614));

      /* Empieza nodo:615 / Elemento padre: 614   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(615)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(615)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(615)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(615)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(614)).appendChild((Element)v.get(615));
      /* Termina nodo:615   */

      /* Empieza nodo:616 / Elemento padre: 614   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(616)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(616)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(616)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(616)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(614)).appendChild((Element)v.get(616));
      /* Termina nodo:616   */
      /* Termina nodo:614   */

      /* Empieza nodo:617 / Elemento padre: 613   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(613)).appendChild((Element)v.get(617));

      /* Empieza nodo:618 / Elemento padre: 617   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(618)).setAttribute("borde","1" );
      ((Element)v.get(618)).setAttribute("horizDatos","1" );
      ((Element)v.get(618)).setAttribute("horizCabecera","1" );
      ((Element)v.get(618)).setAttribute("horizTitulo","1" );
      ((Element)v.get(618)).setAttribute("horizBase","1" );
      ((Element)v.get(618)).setAttribute("vertical","0" );
      ((Element)v.get(617)).appendChild((Element)v.get(618));
      /* Termina nodo:618   */

      /* Empieza nodo:619 / Elemento padre: 617   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(619)).setAttribute("borde","#999999" );
      ((Element)v.get(619)).setAttribute("vertCabecera","#999999" );
      ((Element)v.get(619)).setAttribute("vertDatos","#999999" );
      ((Element)v.get(619)).setAttribute("horizDatos","#999999" );
      ((Element)v.get(619)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(619)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(619)).setAttribute("horizBase","#999999" );
      ((Element)v.get(617)).appendChild((Element)v.get(619));
      /* Termina nodo:619   */
      /* Termina nodo:617   */

      /* Empieza nodo:620 / Elemento padre: 613   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(620)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(620)).setAttribute("alto","22" );
      ((Element)v.get(620)).setAttribute("imgFondo","" );
      ((Element)v.get(613)).appendChild((Element)v.get(620));
      /* Termina nodo:620   */

      /* Empieza nodo:621 / Elemento padre: 613   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(621)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(621)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(621)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(621)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(621)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(613)).appendChild((Element)v.get(621));

      /* Empieza nodo:622 / Elemento padre: 621   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(622)).setAttribute("ancho","100" );
      ((Element)v.get(622)).setAttribute("minimizable","S" );
      ((Element)v.get(622)).setAttribute("minimizada","N" );
      ((Element)v.get(621)).appendChild((Element)v.get(622));
      /* Termina nodo:622   */

      /* Empieza nodo:623 / Elemento padre: 621   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(623)).setAttribute("ancho","100" );
      ((Element)v.get(623)).setAttribute("minimizable","S" );
      ((Element)v.get(623)).setAttribute("minimizada","N" );
      ((Element)v.get(621)).appendChild((Element)v.get(623));
      /* Termina nodo:623   */

      /* Empieza nodo:624 / Elemento padre: 621   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(624)).setAttribute("ancho","100" );
      ((Element)v.get(624)).setAttribute("minimizable","S" );
      ((Element)v.get(624)).setAttribute("minimizada","N" );
      ((Element)v.get(621)).appendChild((Element)v.get(624));
      /* Termina nodo:624   */

      /* Empieza nodo:625 / Elemento padre: 621   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(625)).setAttribute("ancho","100" );
      ((Element)v.get(625)).setAttribute("minimizable","S" );
      ((Element)v.get(625)).setAttribute("minimizada","N" );
      ((Element)v.get(621)).appendChild((Element)v.get(625));
      /* Termina nodo:625   */

      /* Empieza nodo:626 / Elemento padre: 621   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(626)).setAttribute("ancho","100" );
      ((Element)v.get(626)).setAttribute("minimizable","S" );
      ((Element)v.get(626)).setAttribute("minimizada","N" );
      ((Element)v.get(621)).appendChild((Element)v.get(626));
      /* Termina nodo:626   */

      /* Empieza nodo:627 / Elemento padre: 621   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(627)).setAttribute("ancho","100" );
      ((Element)v.get(627)).setAttribute("minimizable","S" );
      ((Element)v.get(627)).setAttribute("minimizada","N" );
      ((Element)v.get(621)).appendChild((Element)v.get(627));
      /* Termina nodo:627   */

      /* Empieza nodo:628 / Elemento padre: 621   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(628)).setAttribute("ancho","100" );
      ((Element)v.get(628)).setAttribute("minimizable","S" );
      ((Element)v.get(628)).setAttribute("minimizada","N" );
      ((Element)v.get(621)).appendChild((Element)v.get(628));
      /* Termina nodo:628   */

      /* Empieza nodo:629 / Elemento padre: 621   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(629)).setAttribute("ancho","100" );
      ((Element)v.get(629)).setAttribute("minimizable","S" );
      ((Element)v.get(629)).setAttribute("minimizada","N" );
   }

   private void getXML2880(Document doc) {
      ((Element)v.get(621)).appendChild((Element)v.get(629));
      /* Termina nodo:629   */

      /* Empieza nodo:630 / Elemento padre: 621   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(630)).setAttribute("ancho","100" );
      ((Element)v.get(630)).setAttribute("minimizable","S" );
      ((Element)v.get(630)).setAttribute("minimizada","N" );
      ((Element)v.get(621)).appendChild((Element)v.get(630));
      /* Termina nodo:630   */

      /* Empieza nodo:631 / Elemento padre: 621   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(631)).setAttribute("ancho","100" );
      ((Element)v.get(631)).setAttribute("minimizable","S" );
      ((Element)v.get(631)).setAttribute("minimizada","N" );
      ((Element)v.get(621)).appendChild((Element)v.get(631));
      /* Termina nodo:631   */

      /* Empieza nodo:632 / Elemento padre: 621   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(632)).setAttribute("ancho","100" );
      ((Element)v.get(632)).setAttribute("minimizable","S" );
      ((Element)v.get(632)).setAttribute("minimizada","N" );
      ((Element)v.get(621)).appendChild((Element)v.get(632));
      /* Termina nodo:632   */

      /* Empieza nodo:633 / Elemento padre: 621   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(633)).setAttribute("ancho","100" );
      ((Element)v.get(633)).setAttribute("minimizable","S" );
      ((Element)v.get(633)).setAttribute("minimizada","N" );
      ((Element)v.get(621)).appendChild((Element)v.get(633));
      /* Termina nodo:633   */

      /* Empieza nodo:634 / Elemento padre: 621   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(634)).setAttribute("ancho","100" );
      ((Element)v.get(634)).setAttribute("minimizable","S" );
      ((Element)v.get(634)).setAttribute("minimizada","N" );
      ((Element)v.get(621)).appendChild((Element)v.get(634));
      /* Termina nodo:634   */

      /* Empieza nodo:635 / Elemento padre: 621   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(635)).setAttribute("ancho","100" );
      ((Element)v.get(635)).setAttribute("minimizable","S" );
      ((Element)v.get(635)).setAttribute("minimizada","N" );
      ((Element)v.get(621)).appendChild((Element)v.get(635));
      /* Termina nodo:635   */

      /* Empieza nodo:636 / Elemento padre: 621   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(636)).setAttribute("ancho","100" );
      ((Element)v.get(636)).setAttribute("minimizable","S" );
      ((Element)v.get(636)).setAttribute("minimizada","N" );
      ((Element)v.get(621)).appendChild((Element)v.get(636));
      /* Termina nodo:636   */

      /* Empieza nodo:637 / Elemento padre: 621   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(637)).setAttribute("ancho","100" );
      ((Element)v.get(637)).setAttribute("minimizable","S" );
      ((Element)v.get(637)).setAttribute("minimizada","N" );
      ((Element)v.get(621)).appendChild((Element)v.get(637));
      /* Termina nodo:637   */
      /* Termina nodo:621   */

      /* Empieza nodo:638 / Elemento padre: 613   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(638)).setAttribute("height","20" );
      ((Element)v.get(638)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(638)).setAttribute("imgFondo","" );
      ((Element)v.get(638)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(613)).appendChild((Element)v.get(638));

      /* Empieza nodo:639 / Elemento padre: 638   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(639)).setAttribute("colFondo","" );
      ((Element)v.get(639)).setAttribute("ID","EstCab" );
      ((Element)v.get(639)).setAttribute("cod","CarParamCarte.paisOidPais.label" );
      ((Element)v.get(638)).appendChild((Element)v.get(639));
      /* Termina nodo:639   */

      /* Empieza nodo:640 / Elemento padre: 638   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(640)).setAttribute("colFondo","" );
      ((Element)v.get(640)).setAttribute("ID","EstCab" );
      ((Element)v.get(640)).setAttribute("cod","CarParamCarte.grsoOidGrupSoli.label" );
      ((Element)v.get(638)).appendChild((Element)v.get(640));
      /* Termina nodo:640   */

      /* Empieza nodo:641 / Elemento padre: 638   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(641)).setAttribute("colFondo","" );
      ((Element)v.get(641)).setAttribute("ID","EstCab" );
      ((Element)v.get(641)).setAttribute("cod","CarParamCarte.niriOidNiveRies.label" );
      ((Element)v.get(638)).appendChild((Element)v.get(641));
      /* Termina nodo:641   */

      /* Empieza nodo:642 / Elemento padre: 638   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(642)).setAttribute("colFondo","" );
      ((Element)v.get(642)).setAttribute("ID","EstCab" );
      ((Element)v.get(642)).setAttribute("cod","CarParamCarte.codConf.label" );
      ((Element)v.get(638)).appendChild((Element)v.get(642));
      /* Termina nodo:642   */

      /* Empieza nodo:643 / Elemento padre: 638   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(643)).setAttribute("colFondo","" );
      ((Element)v.get(643)).setAttribute("ID","EstCab" );
      ((Element)v.get(643)).setAttribute("cod","CarParamCarte.indDeudVenc.label" );
      ((Element)v.get(638)).appendChild((Element)v.get(643));
      /* Termina nodo:643   */

      /* Empieza nodo:644 / Elemento padre: 638   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(644)).setAttribute("colFondo","" );
      ((Element)v.get(644)).setAttribute("ID","EstCab" );
      ((Element)v.get(644)).setAttribute("cod","CarParamCarte.numDiasDeudVenc.label" );
      ((Element)v.get(638)).appendChild((Element)v.get(644));
      /* Termina nodo:644   */

      /* Empieza nodo:645 / Elemento padre: 638   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(645)).setAttribute("colFondo","" );
      ((Element)v.get(645)).setAttribute("ID","EstCab" );
      ((Element)v.get(645)).setAttribute("cod","CarParamCarte.indLineCred.label" );
      ((Element)v.get(638)).appendChild((Element)v.get(645));
      /* Termina nodo:645   */

      /* Empieza nodo:646 / Elemento padre: 638   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(646)).setAttribute("colFondo","" );
      ((Element)v.get(646)).setAttribute("ID","EstCab" );
      ((Element)v.get(646)).setAttribute("cod","CarParamCarte.fecVigeDesd.label" );
      ((Element)v.get(638)).appendChild((Element)v.get(646));
      /* Termina nodo:646   */

      /* Empieza nodo:647 / Elemento padre: 638   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(647)).setAttribute("colFondo","" );
      ((Element)v.get(647)).setAttribute("ID","EstCab" );
   }

   private void getXML2970(Document doc) {
      ((Element)v.get(647)).setAttribute("cod","CarParamCarte.fecVigeHast.label" );
      ((Element)v.get(638)).appendChild((Element)v.get(647));
      /* Termina nodo:647   */

      /* Empieza nodo:648 / Elemento padre: 638   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(648)).setAttribute("colFondo","" );
      ((Element)v.get(648)).setAttribute("ID","EstCab" );
      ((Element)v.get(648)).setAttribute("cod","CarParamCarte.valPorcVali.label" );
      ((Element)v.get(638)).appendChild((Element)v.get(648));
      /* Termina nodo:648   */

      /* Empieza nodo:649 / Elemento padre: 638   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(649)).setAttribute("colFondo","" );
      ((Element)v.get(649)).setAttribute("ID","EstCab" );
      ((Element)v.get(649)).setAttribute("cod","CarParamCarte.indMontMaxi.label" );
      ((Element)v.get(638)).appendChild((Element)v.get(649));
      /* Termina nodo:649   */

      /* Empieza nodo:650 / Elemento padre: 638   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(650)).setAttribute("colFondo","" );
      ((Element)v.get(650)).setAttribute("ID","EstCab" );
      ((Element)v.get(650)).setAttribute("cod","CarParamCarte.valMontMaxiPerm.label" );
      ((Element)v.get(638)).appendChild((Element)v.get(650));
      /* Termina nodo:650   */

      /* Empieza nodo:651 / Elemento padre: 638   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(651)).setAttribute("colFondo","" );
      ((Element)v.get(651)).setAttribute("ID","EstCab" );
      ((Element)v.get(651)).setAttribute("cod","CarParamCarte.indPorcMaxi.label" );
      ((Element)v.get(638)).appendChild((Element)v.get(651));
      /* Termina nodo:651   */

      /* Empieza nodo:652 / Elemento padre: 638   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(652)).setAttribute("colFondo","" );
      ((Element)v.get(652)).setAttribute("ID","EstCab" );
      ((Element)v.get(652)).setAttribute("cod","CarParamCarte.valPorc.label" );
      ((Element)v.get(638)).appendChild((Element)v.get(652));
      /* Termina nodo:652   */

      /* Empieza nodo:653 / Elemento padre: 638   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(653)).setAttribute("colFondo","" );
      ((Element)v.get(653)).setAttribute("ID","EstCab" );
      ((Element)v.get(653)).setAttribute("cod","CarParamCarte.numDiasAdic.label" );
      ((Element)v.get(638)).appendChild((Element)v.get(653));
      /* Termina nodo:653   */

      /* Empieza nodo:654 / Elemento padre: 638   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(654)).setAttribute("colFondo","" );
      ((Element)v.get(654)).setAttribute("ID","EstCab" );
      ((Element)v.get(654)).setAttribute("cod","CarParamCarte.invaOidIndiVali.label" );
      ((Element)v.get(638)).appendChild((Element)v.get(654));
      /* Termina nodo:654   */
      /* Termina nodo:638   */

      /* Empieza nodo:655 / Elemento padre: 613   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(655)).setAttribute("alto","22" );
      ((Element)v.get(655)).setAttribute("accion","" );
      ((Element)v.get(655)).setAttribute("tipoEnvio","seleccion" );
      ((Element)v.get(655)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(655)).setAttribute("maxSel","1" );
      ((Element)v.get(655)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(655)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(655)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(655)).setAttribute("onLoad","" );
      ((Element)v.get(655)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(613)).appendChild((Element)v.get(655));

      /* Empieza nodo:656 / Elemento padre: 655   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(656)).setAttribute("tipo","texto" );
      ((Element)v.get(656)).setAttribute("ID","EstDat" );
      ((Element)v.get(655)).appendChild((Element)v.get(656));
      /* Termina nodo:656   */

      /* Empieza nodo:657 / Elemento padre: 655   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(657)).setAttribute("tipo","texto" );
      ((Element)v.get(657)).setAttribute("ID","EstDat2" );
      ((Element)v.get(655)).appendChild((Element)v.get(657));
      /* Termina nodo:657   */

      /* Empieza nodo:658 / Elemento padre: 655   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(658)).setAttribute("tipo","texto" );
      ((Element)v.get(658)).setAttribute("ID","EstDat" );
      ((Element)v.get(655)).appendChild((Element)v.get(658));
      /* Termina nodo:658   */

      /* Empieza nodo:659 / Elemento padre: 655   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(659)).setAttribute("tipo","texto" );
      ((Element)v.get(659)).setAttribute("ID","EstDat2" );
      ((Element)v.get(655)).appendChild((Element)v.get(659));
      /* Termina nodo:659   */

      /* Empieza nodo:660 / Elemento padre: 655   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(660)).setAttribute("tipo","texto" );
      ((Element)v.get(660)).setAttribute("ID","EstDat" );
      ((Element)v.get(655)).appendChild((Element)v.get(660));
      /* Termina nodo:660   */

      /* Empieza nodo:661 / Elemento padre: 655   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(661)).setAttribute("tipo","texto" );
      ((Element)v.get(661)).setAttribute("ID","EstDat2" );
      ((Element)v.get(655)).appendChild((Element)v.get(661));
      /* Termina nodo:661   */

      /* Empieza nodo:662 / Elemento padre: 655   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(662)).setAttribute("tipo","texto" );
      ((Element)v.get(662)).setAttribute("ID","EstDat" );
      ((Element)v.get(655)).appendChild((Element)v.get(662));
      /* Termina nodo:662   */

      /* Empieza nodo:663 / Elemento padre: 655   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(663)).setAttribute("tipo","texto" );
      ((Element)v.get(663)).setAttribute("ID","EstDat2" );
      ((Element)v.get(655)).appendChild((Element)v.get(663));
      /* Termina nodo:663   */

      /* Empieza nodo:664 / Elemento padre: 655   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(664)).setAttribute("tipo","texto" );
      ((Element)v.get(664)).setAttribute("ID","EstDat" );
      ((Element)v.get(655)).appendChild((Element)v.get(664));
      /* Termina nodo:664   */

      /* Empieza nodo:665 / Elemento padre: 655   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(665)).setAttribute("tipo","texto" );
      ((Element)v.get(665)).setAttribute("ID","EstDat2" );
      ((Element)v.get(655)).appendChild((Element)v.get(665));
      /* Termina nodo:665   */

      /* Empieza nodo:666 / Elemento padre: 655   */
      v.add(doc.createElement("COL"));
   }

   private void getXML3060(Document doc) {
      ((Element)v.get(666)).setAttribute("tipo","texto" );
      ((Element)v.get(666)).setAttribute("ID","EstDat" );
      ((Element)v.get(655)).appendChild((Element)v.get(666));
      /* Termina nodo:666   */

      /* Empieza nodo:667 / Elemento padre: 655   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(667)).setAttribute("tipo","texto" );
      ((Element)v.get(667)).setAttribute("ID","EstDat2" );
      ((Element)v.get(655)).appendChild((Element)v.get(667));
      /* Termina nodo:667   */

      /* Empieza nodo:668 / Elemento padre: 655   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(668)).setAttribute("tipo","texto" );
      ((Element)v.get(668)).setAttribute("ID","EstDat" );
      ((Element)v.get(655)).appendChild((Element)v.get(668));
      /* Termina nodo:668   */

      /* Empieza nodo:669 / Elemento padre: 655   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(669)).setAttribute("tipo","texto" );
      ((Element)v.get(669)).setAttribute("ID","EstDat2" );
      ((Element)v.get(655)).appendChild((Element)v.get(669));
      /* Termina nodo:669   */

      /* Empieza nodo:670 / Elemento padre: 655   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(670)).setAttribute("tipo","texto" );
      ((Element)v.get(670)).setAttribute("ID","EstDat" );
      ((Element)v.get(655)).appendChild((Element)v.get(670));
      /* Termina nodo:670   */

      /* Empieza nodo:671 / Elemento padre: 655   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(671)).setAttribute("tipo","texto" );
      ((Element)v.get(671)).setAttribute("ID","EstDat2" );
      ((Element)v.get(655)).appendChild((Element)v.get(671));
      /* Termina nodo:671   */
      /* Termina nodo:655   */

      /* Empieza nodo:672 / Elemento padre: 613   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(613)).appendChild((Element)v.get(672));
      /* Termina nodo:672   */
      /* Termina nodo:613   */
      /* Termina nodo:612   */

      /* Empieza nodo:673 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(673)).setAttribute("nombre","carParamCarteListButtonsLayer" );
      ((Element)v.get(673)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(673)).setAttribute("alto","30" );
      ((Element)v.get(673)).setAttribute("ancho","98%" );
      ((Element)v.get(673)).setAttribute("borde","n" );
      ((Element)v.get(673)).setAttribute("imagenf","" );
      ((Element)v.get(673)).setAttribute("repeat","" );
      ((Element)v.get(673)).setAttribute("padding","0" );
      ((Element)v.get(673)).setAttribute("contravsb","" );
      ((Element)v.get(673)).setAttribute("x","16" );
      ((Element)v.get(673)).setAttribute("y","" );
      ((Element)v.get(673)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(673));

      /* Empieza nodo:674 / Elemento padre: 673   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(674)).setAttribute("width","100%" );
      ((Element)v.get(674)).setAttribute("border","0" );
      ((Element)v.get(674)).setAttribute("cellspacing","1" );
      ((Element)v.get(674)).setAttribute("cellpadding","0" );
      ((Element)v.get(674)).setAttribute("height","22" );
      ((Element)v.get(673)).appendChild((Element)v.get(674));

      /* Empieza nodo:675 / Elemento padre: 674   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(675)).setAttribute("class","tablaTitle" );
      ((Element)v.get(675)).setAttribute("nombre","carParamCarteUpdateButtonTd" );
      ((Element)v.get(674)).appendChild((Element)v.get(675));

      /* Empieza nodo:676 / Elemento padre: 675   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(676)).setAttribute("nombre","carParamCarteUpdateButton" );
      ((Element)v.get(676)).setAttribute("ID","botonContenido" );
      ((Element)v.get(676)).setAttribute("tipo","html" );
      ((Element)v.get(676)).setAttribute("accion","carParamCarteUpdateSelection();" );
      ((Element)v.get(676)).setAttribute("estado","false" );
      ((Element)v.get(676)).setAttribute("cod","MMGGlobal.updateButton.label" );
      ((Element)v.get(675)).appendChild((Element)v.get(676));
      /* Termina nodo:676   */
      /* Termina nodo:675   */

      /* Empieza nodo:677 / Elemento padre: 674   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(677)).setAttribute("nombre","carParamCarteUpdateButtonGapTd" );
      ((Element)v.get(674)).appendChild((Element)v.get(677));

      /* Empieza nodo:678 / Elemento padre: 677   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(678)).setAttribute("src","b.gif" );
      ((Element)v.get(678)).setAttribute("height","8" );
      ((Element)v.get(678)).setAttribute("width","10" );
      ((Element)v.get(677)).appendChild((Element)v.get(678));
      /* Termina nodo:678   */
      /* Termina nodo:677   */

      /* Empieza nodo:679 / Elemento padre: 674   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(679)).setAttribute("class","tablaTitle" );
      ((Element)v.get(679)).setAttribute("nombre","carParamCarteRemoveButtonTd" );
      ((Element)v.get(674)).appendChild((Element)v.get(679));

      /* Empieza nodo:680 / Elemento padre: 679   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(680)).setAttribute("nombre","carParamCarteRemoveButton" );
      ((Element)v.get(680)).setAttribute("ID","botonContenido" );
      ((Element)v.get(680)).setAttribute("tipo","html" );
      ((Element)v.get(680)).setAttribute("accion","carParamCarteRemoveSelection();" );
      ((Element)v.get(680)).setAttribute("estado","false" );
      ((Element)v.get(680)).setAttribute("cod","MMGGlobal.removeButton.label" );
      ((Element)v.get(679)).appendChild((Element)v.get(680));
      /* Termina nodo:680   */
      /* Termina nodo:679   */

      /* Empieza nodo:681 / Elemento padre: 674   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(681)).setAttribute("nombre","carParamCarteRemoveButtonGapTd" );
      ((Element)v.get(674)).appendChild((Element)v.get(681));

      /* Empieza nodo:682 / Elemento padre: 681   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(682)).setAttribute("src","b.gif" );
      ((Element)v.get(682)).setAttribute("height","8" );
      ((Element)v.get(682)).setAttribute("width","10" );
      ((Element)v.get(681)).appendChild((Element)v.get(682));
      /* Termina nodo:682   */
      /* Termina nodo:681   */

      /* Empieza nodo:683 / Elemento padre: 674   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(683)).setAttribute("class","tablaTitle" );
      ((Element)v.get(683)).setAttribute("nombre","carParamCarteViewForRemoveButtonTd" );
      ((Element)v.get(674)).appendChild((Element)v.get(683));

      /* Empieza nodo:684 / Elemento padre: 683   */
   }

   private void getXML3150(Document doc) {
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(684)).setAttribute("nombre","carParamCarteViewForRemoveButton" );
      ((Element)v.get(684)).setAttribute("ID","botonContenido" );
      ((Element)v.get(684)).setAttribute("tipo","html" );
      ((Element)v.get(684)).setAttribute("accion","carParamCarteViewSelection();" );
      ((Element)v.get(684)).setAttribute("estado","false" );
      ((Element)v.get(684)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(683)).appendChild((Element)v.get(684));
      /* Termina nodo:684   */
      /* Termina nodo:683   */

      /* Empieza nodo:685 / Elemento padre: 674   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(685)).setAttribute("nombre","carParamCarteViewForRemoveButtonGapTd" );
      ((Element)v.get(674)).appendChild((Element)v.get(685));

      /* Empieza nodo:686 / Elemento padre: 685   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(686)).setAttribute("src","b.gif" );
      ((Element)v.get(686)).setAttribute("height","8" );
      ((Element)v.get(686)).setAttribute("width","10" );
      ((Element)v.get(685)).appendChild((Element)v.get(686));
      /* Termina nodo:686   */
      /* Termina nodo:685   */

      /* Empieza nodo:687 / Elemento padre: 674   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(687)).setAttribute("class","tablaTitle" );
      ((Element)v.get(687)).setAttribute("nombre","carParamCarteLovSelectButtonTd" );
      ((Element)v.get(674)).appendChild((Element)v.get(687));

      /* Empieza nodo:688 / Elemento padre: 687   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(688)).setAttribute("nombre","carParamCarteLovSelectButton" );
      ((Element)v.get(688)).setAttribute("ID","botonContenido" );
      ((Element)v.get(688)).setAttribute("tipo","html" );
      ((Element)v.get(688)).setAttribute("accion","carParamCarteLovSelectionAction();" );
      ((Element)v.get(688)).setAttribute("estado","true" );
      ((Element)v.get(688)).setAttribute("cod","MMGGlobal.lovSelectButton.label" );
      ((Element)v.get(687)).appendChild((Element)v.get(688));
      /* Termina nodo:688   */
      /* Termina nodo:687   */

      /* Empieza nodo:689 / Elemento padre: 674   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(689)).setAttribute("nombre","carParamCarteLovSelectButtonGapTd" );
      ((Element)v.get(674)).appendChild((Element)v.get(689));

      /* Empieza nodo:690 / Elemento padre: 689   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(690)).setAttribute("src","b.gif" );
      ((Element)v.get(690)).setAttribute("height","8" );
      ((Element)v.get(690)).setAttribute("width","10" );
      ((Element)v.get(689)).appendChild((Element)v.get(690));
      /* Termina nodo:690   */
      /* Termina nodo:689   */

      /* Empieza nodo:691 / Elemento padre: 674   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(691)).setAttribute("class","tablaTitle" );
      ((Element)v.get(691)).setAttribute("nombre","carParamCarteViewButtonTd" );
      ((Element)v.get(674)).appendChild((Element)v.get(691));

      /* Empieza nodo:692 / Elemento padre: 691   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(692)).setAttribute("nombre","carParamCarteViewButton" );
      ((Element)v.get(692)).setAttribute("ID","botonContenido" );
      ((Element)v.get(692)).setAttribute("tipo","html" );
      ((Element)v.get(692)).setAttribute("accion","carParamCarteViewSelection();" );
      ((Element)v.get(692)).setAttribute("estado","false" );
      ((Element)v.get(692)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(691)).appendChild((Element)v.get(692));
      /* Termina nodo:692   */
      /* Termina nodo:691   */

      /* Empieza nodo:693 / Elemento padre: 674   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(693)).setAttribute("nombre","carParamCarteViewButtonGapTd" );
      ((Element)v.get(674)).appendChild((Element)v.get(693));

      /* Empieza nodo:694 / Elemento padre: 693   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(694)).setAttribute("src","b.gif" );
      ((Element)v.get(694)).setAttribute("height","8" );
      ((Element)v.get(694)).setAttribute("width","10" );
      ((Element)v.get(693)).appendChild((Element)v.get(694));
      /* Termina nodo:694   */
      /* Termina nodo:693   */

      /* Empieza nodo:695 / Elemento padre: 674   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(674)).appendChild((Element)v.get(695));

      /* Empieza nodo:696 / Elemento padre: 695   */
      v.add(doc.createElement("BOTONERA"));
      ((Element)v.get(696)).setAttribute("nombre","carParamCartePaginationButtonBar" );
      ((Element)v.get(696)).setAttribute("tipo","H" );
      ((Element)v.get(696)).setAttribute("x","0" );
      ((Element)v.get(696)).setAttribute("y","0" );
      ((Element)v.get(695)).appendChild((Element)v.get(696));

      /* Empieza nodo:697 / Elemento padre: 696   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(697)).setAttribute("nombre","carParamCarteFirstPageButton" );
      ((Element)v.get(697)).setAttribute("funcion","carParamCarteFirstPage();" );
      ((Element)v.get(697)).setAttribute("off","primera_over0.gif" );
      ((Element)v.get(697)).setAttribute("on","primera_over0.gif" );
      ((Element)v.get(697)).setAttribute("disable","primera_on0.gif" );
      ((Element)v.get(697)).setAttribute("estado","inactivo" );
      ((Element)v.get(696)).appendChild((Element)v.get(697));
      /* Termina nodo:697   */

      /* Empieza nodo:698 / Elemento padre: 696   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(698)).setAttribute("nombre","carParamCarteFirstPageButtonGapTd" );
      ((Element)v.get(696)).appendChild((Element)v.get(698));

      /* Empieza nodo:699 / Elemento padre: 698   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(699)).setAttribute("src","b.gif" );
      ((Element)v.get(699)).setAttribute("height","8" );
      ((Element)v.get(699)).setAttribute("width","8" );
      ((Element)v.get(698)).appendChild((Element)v.get(699));
      /* Termina nodo:699   */
      /* Termina nodo:698   */

      /* Empieza nodo:700 / Elemento padre: 696   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(700)).setAttribute("nombre","carParamCartePreviousPageButton" );
      ((Element)v.get(700)).setAttribute("funcion","carParamCartePreviousPage();" );
      ((Element)v.get(700)).setAttribute("off","retroceder_over0.gif" );
      ((Element)v.get(700)).setAttribute("on","retroceder_over0.gif" );
      ((Element)v.get(700)).setAttribute("disable","retroceder_on0.gif" );
      ((Element)v.get(700)).setAttribute("estado","inactivo" );
      ((Element)v.get(696)).appendChild((Element)v.get(700));
      /* Termina nodo:700   */

      /* Empieza nodo:701 / Elemento padre: 696   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(701)).setAttribute("nombre","carParamCartePreviousPageButtonGapTd" );
   }

   private void getXML3240(Document doc) {
      ((Element)v.get(696)).appendChild((Element)v.get(701));

      /* Empieza nodo:702 / Elemento padre: 701   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(702)).setAttribute("src","b.gif" );
      ((Element)v.get(702)).setAttribute("height","8" );
      ((Element)v.get(702)).setAttribute("width","8" );
      ((Element)v.get(701)).appendChild((Element)v.get(702));
      /* Termina nodo:702   */
      /* Termina nodo:701   */

      /* Empieza nodo:703 / Elemento padre: 696   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(703)).setAttribute("nombre","carParamCarteNextPageButton" );
      ((Element)v.get(703)).setAttribute("funcion","carParamCarteNextPage();" );
      ((Element)v.get(703)).setAttribute("off","avanzar_over0.gif" );
      ((Element)v.get(703)).setAttribute("on","avanzar_over0.gif" );
      ((Element)v.get(703)).setAttribute("disable","avanzar_on0.gif" );
      ((Element)v.get(703)).setAttribute("estado","inactivo" );
      ((Element)v.get(696)).appendChild((Element)v.get(703));
      /* Termina nodo:703   */
      /* Termina nodo:696   */
      /* Termina nodo:695   */

      /* Empieza nodo:704 / Elemento padre: 674   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(704)).setAttribute("width","100%" );
      ((Element)v.get(674)).appendChild((Element)v.get(704));
      /* Termina nodo:704   */
      /* Termina nodo:674   */
      /* Termina nodo:673   */
      /* Termina nodo:4   */


   }

}

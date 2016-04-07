
import org.w3c.dom.*;
import java.util.ArrayList;

public class CarSoliEntrBloqPage  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML4590(doc);
         

      getXML4680(doc);
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","CarSoliEntrBloqPage" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","carSoliEntrBloqInitComponents()" );
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
      ((Element)v.get(3)).setAttribute("src","carsolientrbloq.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(4)).setAttribute("nombre","carSoliEntrBloqFrm" );
      ((Element)v.get(4)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(5)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(5)).setAttribute("valor","CarSoliEntrBloqLPExecution" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","ON" );
      ((Element)v.get(6)).setAttribute("valor","CarSoliEntrBloqLPExecution" );
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
      ((Element)v.get(24)).setAttribute("nombre","carSoliEntrBloqFormLayer" );
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
      ((Element)v.get(39)).setAttribute("cod","CarSoliEntrBloq.legend.label" );
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
      ((Element)v.get(54)).setAttribute("cod","CarSoliEntrBloq.id.label" );
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
      ((Element)v.get(57)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true)" );
      ((Element)v.get(57)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm', 0, false)" );
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
      ((Element)v.get(85)).setAttribute("onchange","mmgDependeneChange('paisOidPais_moneOidMoneAlt', 'paisOidPais' , 'carSoliEntrBloq')" );
      ((Element)v.get(85)).setAttribute("onfocus","" );
      ((Element)v.get(85)).setAttribute("valorinicial","" );
      ((Element)v.get(85)).setAttribute("textoinicial","" );
      ((Element)v.get(85)).setAttribute("ontab","focaliza('carSoliEntrBloqFrm.paisOidPais_moneOidMone');" );
      ((Element)v.get(85)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
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
      ((Element)v.get(99)).setAttribute("onchange","mmgDependeneChange('paisOidPais_moneOidMone', 'paisOidPais' , 'carSoliEntrBloq')" );
      ((Element)v.get(99)).setAttribute("onfocus","" );
      ((Element)v.get(99)).setAttribute("valorinicial","" );
      ((Element)v.get(99)).setAttribute("textoinicial","" );
      ((Element)v.get(99)).setAttribute("ontab","focaliza('carSoliEntrBloqFrm.paisOidPais_fopaOidFormPago');" );
      ((Element)v.get(99)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
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
      ((Element)v.get(113)).setAttribute("onchange","mmgDependeneChange('paisOidPais_fopaOidFormPago', 'paisOidPais' , 'carSoliEntrBloq')" );
      ((Element)v.get(113)).setAttribute("onfocus","" );
      ((Element)v.get(113)).setAttribute("valorinicial","" );
      ((Element)v.get(113)).setAttribute("textoinicial","" );
      ((Element)v.get(113)).setAttribute("ontab","focaliza('carSoliEntrBloqFrm.paisOidPais');" );
      ((Element)v.get(113)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
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
      ((Element)v.get(124)).setAttribute("cod","CarSoliEntrBloq.paisOidPais.label" );
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
      ((Element)v.get(127)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true);" );
      ((Element)v.get(127)).setAttribute("onshtab","focaliza('carSoliEntrBloqFrm.paisOidPais_fopaOidFormPago');" );
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
      ((Element)v.get(149)).setAttribute("nombre","sbacOidSbac_acceOidAcce_canaOidCanaTdId" );
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
      ((Element)v.get(153)).setAttribute("nombre","lblsbacOidSbac_acceOidAcce_canaOidCana" );
      ((Element)v.get(153)).setAttribute("id","datosTitle" );
      ((Element)v.get(153)).setAttribute("ancho","100" );
      ((Element)v.get(153)).setAttribute("alto","13" );
      ((Element)v.get(153)).setAttribute("cod","SegAcces.canaOidCana.label" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:154 / Elemento padre: 150   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(154)).setAttribute("nombre","sbacOidSbac_acceOidAcce_canaOidCanaWidgetTrId" );
      ((Element)v.get(150)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(155)).setAttribute("align","left" );
      ((Element)v.get(155)).setAttribute("nowrap","true" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(156)).setAttribute("nombre","sbacOidSbac_acceOidAcce_canaOidCana" );
      ((Element)v.get(156)).setAttribute("id","datosCampos" );
      ((Element)v.get(156)).setAttribute("multiple","N" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(156)).setAttribute("req","N" );
      ((Element)v.get(156)).setAttribute("size","1" );
      ((Element)v.get(156)).setAttribute("validacion","" );
      ((Element)v.get(156)).setAttribute("onchange","mmgDependeneChange('sbacOidSbac_acceOidAcce_canaOidCana', 'sbacOidSbac' , 'carSoliEntrBloq')" );
      ((Element)v.get(156)).setAttribute("onfocus","" );
      ((Element)v.get(156)).setAttribute("valorinicial","" );
      ((Element)v.get(156)).setAttribute("textoinicial","" );
      ((Element)v.get(156)).setAttribute("ontab","focaliza('carSoliEntrBloqFrm.sbacOidSbac_acceOidAcce');" );
      ((Element)v.get(156)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
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
      ((Element)v.get(158)).setAttribute("nombre","sbacOidSbac_acceOidAcce_canaOidCanaViewLabelTrId" );
      ((Element)v.get(150)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(159)).setAttribute("valign","top" );
      ((Element)v.get(159)).setAttribute("height","13" );
      ((Element)v.get(159)).setAttribute("width","30" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(160)).setAttribute("nombre","lblViewSbacOidSbac_acceOidAcce_canaOidCana" );
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
      ((Element)v.get(161)).setAttribute("nombre","sbacOidSbacGapTdId" );
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
      ((Element)v.get(163)).setAttribute("nombre","sbacOidSbac_acceOidAcceTdId" );
      ((Element)v.get(148)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(164)).setAttribute("border","0" );
      ((Element)v.get(164)).setAttribute("cellspacing","0" );
      ((Element)v.get(164)).setAttribute("cellpadding","0" );
      ((Element)v.get(164)).setAttribute("align","left" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(166)).setAttribute("valign","top" );
      ((Element)v.get(166)).setAttribute("height","13" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(167)).setAttribute("nombre","lblsbacOidSbac_acceOidAcce" );
      ((Element)v.get(167)).setAttribute("id","datosTitle" );
      ((Element)v.get(167)).setAttribute("ancho","100" );
      ((Element)v.get(167)).setAttribute("alto","13" );
      ((Element)v.get(167)).setAttribute("cod","SegSubac.acceOidAcce.label" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:168 / Elemento padre: 164   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(168)).setAttribute("nombre","sbacOidSbac_acceOidAcceWidgetTrId" );
      ((Element)v.get(164)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(169)).setAttribute("align","left" );
      ((Element)v.get(169)).setAttribute("nowrap","true" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(170)).setAttribute("nombre","sbacOidSbac_acceOidAcce" );
      ((Element)v.get(170)).setAttribute("id","datosCampos" );
      ((Element)v.get(170)).setAttribute("multiple","N" );
      ((Element)v.get(170)).setAttribute("req","N" );
      ((Element)v.get(170)).setAttribute("size","1" );
      ((Element)v.get(170)).setAttribute("validacion","" );
      ((Element)v.get(170)).setAttribute("onchange","mmgDependeneChange('sbacOidSbac_acceOidAcce', 'sbacOidSbac' , 'carSoliEntrBloq')" );
      ((Element)v.get(170)).setAttribute("onfocus","" );
      ((Element)v.get(170)).setAttribute("valorinicial","" );
      ((Element)v.get(170)).setAttribute("textoinicial","" );
      ((Element)v.get(170)).setAttribute("ontab","focaliza('carSoliEntrBloqFrm.sbacOidSbac');" );
      ((Element)v.get(170)).setAttribute("onshtab","focaliza('carSoliEntrBloqFrm.sbacOidSbac_acceOidAcce_canaOidCana');" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(170)).appendChild((Element)v.get(171));
      /* Termina nodo:171   */
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:172 / Elemento padre: 164   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(172)).setAttribute("nombre","sbacOidSbac_acceOidAcceViewLabelTrId" );
      ((Element)v.get(164)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(173)).setAttribute("valign","top" );
      ((Element)v.get(173)).setAttribute("height","13" );
      ((Element)v.get(173)).setAttribute("width","30" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
   }

   private void getXML810(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(174)).setAttribute("nombre","lblViewSbacOidSbac_acceOidAcce" );
      ((Element)v.get(174)).setAttribute("alto","13" );
      ((Element)v.get(174)).setAttribute("filas","1" );
      ((Element)v.get(174)).setAttribute("id","EstDat" );
      ((Element)v.get(174)).setAttribute("valor","" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */
      /* Termina nodo:172   */
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:175 / Elemento padre: 148   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(175)).setAttribute("nombre","sbacOidSbacGapTdId" );
      ((Element)v.get(175)).setAttribute("nowrap","true" );
      ((Element)v.get(175)).setAttribute("class","datosCampos" );
      ((Element)v.get(148)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(176)).setAttribute("src","b.gif" );
      ((Element)v.get(176)).setAttribute("width","25" );
      ((Element)v.get(176)).setAttribute("height","8" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */

      /* Empieza nodo:177 / Elemento padre: 148   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(177)).setAttribute("nombre","sbacOidSbacTdId" );
      ((Element)v.get(148)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(178)).setAttribute("border","0" );
      ((Element)v.get(178)).setAttribute("cellspacing","0" );
      ((Element)v.get(178)).setAttribute("cellpadding","0" );
      ((Element)v.get(178)).setAttribute("align","left" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(178)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(180)).setAttribute("valign","top" );
      ((Element)v.get(180)).setAttribute("height","13" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(181)).setAttribute("nombre","lblsbacOidSbac" );
      ((Element)v.get(181)).setAttribute("id","datosTitle" );
      ((Element)v.get(181)).setAttribute("ancho","100" );
      ((Element)v.get(181)).setAttribute("alto","13" );
      ((Element)v.get(181)).setAttribute("cod","CarSoliEntrBloq.sbacOidSbac.label" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:182 / Elemento padre: 178   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(182)).setAttribute("nombre","sbacOidSbacWidgetTrId" );
      ((Element)v.get(178)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(183)).setAttribute("align","left" );
      ((Element)v.get(183)).setAttribute("nowrap","true" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(184)).setAttribute("nombre","sbacOidSbac" );
      ((Element)v.get(184)).setAttribute("id","datosCampos" );
      ((Element)v.get(184)).setAttribute("multiple","N" );
      ((Element)v.get(184)).setAttribute("req","N" );
      ((Element)v.get(184)).setAttribute("size","1" );
      ((Element)v.get(184)).setAttribute("validacion","" );
      ((Element)v.get(184)).setAttribute("onchange","" );
      ((Element)v.get(184)).setAttribute("onfocus","" );
      ((Element)v.get(184)).setAttribute("valorinicial","" );
      ((Element)v.get(184)).setAttribute("textoinicial","" );
      ((Element)v.get(184)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true);" );
      ((Element)v.get(184)).setAttribute("onshtab","focaliza('carSoliEntrBloqFrm.sbacOidSbac_acceOidAcce');" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */
      /* Termina nodo:183   */
      /* Termina nodo:182   */

      /* Empieza nodo:186 / Elemento padre: 178   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(186)).setAttribute("nombre","sbacOidSbacViewLabelTrId" );
      ((Element)v.get(178)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(187)).setAttribute("valign","top" );
      ((Element)v.get(187)).setAttribute("height","13" );
      ((Element)v.get(187)).setAttribute("width","30" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(188)).setAttribute("nombre","lblViewSbacOidSbac" );
      ((Element)v.get(188)).setAttribute("alto","13" );
      ((Element)v.get(188)).setAttribute("filas","1" );
      ((Element)v.get(188)).setAttribute("id","EstDat" );
      ((Element)v.get(188)).setAttribute("valor","" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */
      /* Termina nodo:186   */
      /* Termina nodo:178   */
      /* Termina nodo:177   */

      /* Empieza nodo:189 / Elemento padre: 148   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(189)).setAttribute("nombre","sbacOidSbacGapTdId" );
      ((Element)v.get(189)).setAttribute("nowrap","true" );
      ((Element)v.get(189)).setAttribute("class","datosCampos" );
      ((Element)v.get(148)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","25" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 148   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(191)).setAttribute("width","100%" );
      ((Element)v.get(148)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(192)).setAttribute("src","b.gif" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:148   */
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:143   */

      /* Empieza nodo:193 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(193)).setAttribute("nombre","formGapTr2" );
      ((Element)v.get(40)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(194)).setAttribute("align","center" );
      ((Element)v.get(194)).setAttribute("width","12" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(195)).setAttribute("src","b.gif" );
      ((Element)v.get(195)).setAttribute("width","12" );
      ((Element)v.get(195)).setAttribute("height","8" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 193   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(193)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(197)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).setAttribute("width","8" );
      ((Element)v.get(197)).setAttribute("height","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 193   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(198)).setAttribute("align","center" );
      ((Element)v.get(198)).setAttribute("width","12" );
      ((Element)v.get(193)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(199)).setAttribute("src","b.gif" );
      ((Element)v.get(199)).setAttribute("width","12" );
      ((Element)v.get(199)).setAttribute("height","8" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */
      /* Termina nodo:193   */

      /* Empieza nodo:200 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(200)).setAttribute("nombre","formTr3" );
      ((Element)v.get(40)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(201)).setAttribute("align","center" );
      ((Element)v.get(201)).setAttribute("width","12" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(202)).setAttribute("src","b.gif" );
      ((Element)v.get(202)).setAttribute("width","12" );
      ((Element)v.get(202)).setAttribute("height","12" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:203 / Elemento padre: 200   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(203)).setAttribute("width","100%" );
      ((Element)v.get(200)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(204)).setAttribute("width","100%" );
      ((Element)v.get(204)).setAttribute("border","0" );
      ((Element)v.get(204)).setAttribute("cellspacing","0" );
      ((Element)v.get(204)).setAttribute("cellpadding","0" );
      ((Element)v.get(204)).setAttribute("align","left" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(205)).setAttribute("align","left" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(206)).setAttribute("nombre","tsolOidTipoSoliTdId" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(207)).setAttribute("border","0" );
      ((Element)v.get(207)).setAttribute("cellspacing","0" );
      ((Element)v.get(207)).setAttribute("cellpadding","0" );
      ((Element)v.get(207)).setAttribute("align","left" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(209)).setAttribute("valign","top" );
      ((Element)v.get(209)).setAttribute("height","13" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(210)).setAttribute("nombre","lbltsolOidTipoSoli" );
      ((Element)v.get(210)).setAttribute("id","datosTitle" );
      ((Element)v.get(210)).setAttribute("ancho","100" );
      ((Element)v.get(210)).setAttribute("alto","13" );
      ((Element)v.get(210)).setAttribute("cod","CarSoliEntrBloq.tsolOidTipoSoli.label" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:211 / Elemento padre: 207   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(211)).setAttribute("nombre","tsolOidTipoSoliWidgetTrId" );
      ((Element)v.get(207)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(212)).setAttribute("align","left" );
      ((Element)v.get(212)).setAttribute("nowrap","true" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(213)).setAttribute("nombre","tsolOidTipoSoli" );
      ((Element)v.get(213)).setAttribute("id","datosCampos" );
      ((Element)v.get(213)).setAttribute("multiple","N" );
      ((Element)v.get(213)).setAttribute("req","N" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(213)).setAttribute("size","1" );
      ((Element)v.get(213)).setAttribute("validacion","" );
      ((Element)v.get(213)).setAttribute("onchange","" );
      ((Element)v.get(213)).setAttribute("onfocus","" );
      ((Element)v.get(213)).setAttribute("valorinicial","" );
      ((Element)v.get(213)).setAttribute("textoinicial","" );
      ((Element)v.get(213)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true);" );
      ((Element)v.get(213)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */
      /* Termina nodo:212   */
      /* Termina nodo:211   */

      /* Empieza nodo:215 / Elemento padre: 207   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(215)).setAttribute("nombre","tsolOidTipoSoliViewLabelTrId" );
      ((Element)v.get(207)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(216)).setAttribute("valign","top" );
      ((Element)v.get(216)).setAttribute("height","13" );
      ((Element)v.get(216)).setAttribute("width","50" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(217)).setAttribute("nombre","lblViewTsolOidTipoSoli" );
      ((Element)v.get(217)).setAttribute("alto","13" );
      ((Element)v.get(217)).setAttribute("filas","1" );
      ((Element)v.get(217)).setAttribute("id","EstDat" );
      ((Element)v.get(217)).setAttribute("valor","" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */
      /* Termina nodo:215   */
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:218 / Elemento padre: 205   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(218)).setAttribute("nombre","tsolOidTipoSoliGapTdId" );
      ((Element)v.get(218)).setAttribute("nowrap","true" );
      ((Element)v.get(218)).setAttribute("class","datosCampos" );
      ((Element)v.get(205)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("width","25" );
      ((Element)v.get(219)).setAttribute("height","8" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 205   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(220)).setAttribute("width","100%" );
      ((Element)v.get(205)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(221)).setAttribute("src","b.gif" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */
      /* Termina nodo:205   */
      /* Termina nodo:204   */
      /* Termina nodo:203   */
      /* Termina nodo:200   */

      /* Empieza nodo:222 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(222)).setAttribute("nombre","formGapTr3" );
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
      ((Element)v.get(229)).setAttribute("nombre","formTr4" );
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
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(233)).setAttribute("align","left" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(234)).setAttribute("align","left" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(235)).setAttribute("nombre","socaOidSoliCabeTdId" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("TABLE"));
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
      ((Element)v.get(238)).setAttribute("valign","top" );
      ((Element)v.get(238)).setAttribute("height","13" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(239)).setAttribute("nombre","lblsocaOidSoliCabe" );
      ((Element)v.get(239)).setAttribute("id","datosTitle" );
      ((Element)v.get(239)).setAttribute("ancho","100" );
      ((Element)v.get(239)).setAttribute("alto","13" );
      ((Element)v.get(239)).setAttribute("cod","CarSoliEntrBloq.socaOidSoliCabe.label" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:240 / Elemento padre: 236   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(240)).setAttribute("nombre","socaOidSoliCabeWidgetTrId" );
      ((Element)v.get(236)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(241)).setAttribute("align","left" );
      ((Element)v.get(241)).setAttribute("nowrap","true" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(242)).setAttribute("nombre","socaOidSoliCabe" );
      ((Element)v.get(242)).setAttribute("id","datosCampos" );
      ((Element)v.get(242)).setAttribute("multiple","N" );
      ((Element)v.get(242)).setAttribute("req","N" );
      ((Element)v.get(242)).setAttribute("size","1" );
      ((Element)v.get(242)).setAttribute("validacion","" );
      ((Element)v.get(242)).setAttribute("onchange","" );
      ((Element)v.get(242)).setAttribute("onfocus","" );
      ((Element)v.get(242)).setAttribute("valorinicial","" );
      ((Element)v.get(242)).setAttribute("textoinicial","" );
      ((Element)v.get(242)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true);" );
      ((Element)v.get(242)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:244 / Elemento padre: 236   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(244)).setAttribute("nombre","socaOidSoliCabeViewLabelTrId" );
      ((Element)v.get(236)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(245)).setAttribute("valign","top" );
      ((Element)v.get(245)).setAttribute("height","13" );
      ((Element)v.get(245)).setAttribute("width","50" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(246)).setAttribute("nombre","lblViewSocaOidSoliCabe" );
      ((Element)v.get(246)).setAttribute("alto","13" );
      ((Element)v.get(246)).setAttribute("filas","1" );
      ((Element)v.get(246)).setAttribute("id","EstDat" );
      ((Element)v.get(246)).setAttribute("valor","" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */
      /* Termina nodo:244   */
      /* Termina nodo:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:247 / Elemento padre: 234   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(247)).setAttribute("nombre","socaOidSoliCabeGapTdId" );
      ((Element)v.get(247)).setAttribute("nowrap","true" );
      ((Element)v.get(247)).setAttribute("class","datosCampos" );
      ((Element)v.get(234)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(248)).setAttribute("src","b.gif" );
      ((Element)v.get(248)).setAttribute("width","25" );
      ((Element)v.get(248)).setAttribute("height","8" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */

      /* Empieza nodo:249 / Elemento padre: 234   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(249)).setAttribute("width","100%" );
      ((Element)v.get(234)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(250)).setAttribute("src","b.gif" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */
      /* Termina nodo:234   */
      /* Termina nodo:233   */
      /* Termina nodo:232   */
      /* Termina nodo:229   */

      /* Empieza nodo:251 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(251)).setAttribute("nombre","formGapTr4" );
      ((Element)v.get(40)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(252)).setAttribute("align","center" );
      ((Element)v.get(252)).setAttribute("width","12" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(253)).setAttribute("src","b.gif" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(253)).setAttribute("width","12" );
      ((Element)v.get(253)).setAttribute("height","8" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */

      /* Empieza nodo:254 / Elemento padre: 251   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(251)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(255)).setAttribute("src","b.gif" );
      ((Element)v.get(255)).setAttribute("width","8" );
      ((Element)v.get(255)).setAttribute("height","8" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */

      /* Empieza nodo:256 / Elemento padre: 251   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(256)).setAttribute("align","center" );
      ((Element)v.get(256)).setAttribute("width","12" );
      ((Element)v.get(251)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(257)).setAttribute("src","b.gif" );
      ((Element)v.get(257)).setAttribute("width","12" );
      ((Element)v.get(257)).setAttribute("height","8" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:251   */

      /* Empieza nodo:258 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(258)).setAttribute("nombre","formTr5" );
      ((Element)v.get(40)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(259)).setAttribute("align","center" );
      ((Element)v.get(259)).setAttribute("width","12" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(260)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).setAttribute("width","12" );
      ((Element)v.get(260)).setAttribute("height","12" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:261 / Elemento padre: 258   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(261)).setAttribute("width","100%" );
      ((Element)v.get(258)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(262)).setAttribute("width","100%" );
      ((Element)v.get(262)).setAttribute("border","0" );
      ((Element)v.get(262)).setAttribute("cellspacing","0" );
      ((Element)v.get(262)).setAttribute("cellpadding","0" );
      ((Element)v.get(262)).setAttribute("align","left" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(263)).setAttribute("align","left" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(264)).setAttribute("nombre","fecDocuTdId" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(265)).setAttribute("width","100%" );
      ((Element)v.get(265)).setAttribute("border","0" );
      ((Element)v.get(265)).setAttribute("cellspacing","0" );
      ((Element)v.get(265)).setAttribute("cellpadding","0" );
      ((Element)v.get(265)).setAttribute("align","left" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(265)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(267)).setAttribute("valign","top" );
      ((Element)v.get(267)).setAttribute("height","13" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(268)).setAttribute("nombre","lblFecDocu" );
      ((Element)v.get(268)).setAttribute("alto","13" );
      ((Element)v.get(268)).setAttribute("filas","1" );
      ((Element)v.get(268)).setAttribute("id","datosTitle" );
      ((Element)v.get(268)).setAttribute("cod","CarSoliEntrBloq.fecDocu.label" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:269 / Elemento padre: 265   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(269)).setAttribute("nombre","fecDocuWidgetTrId" );
      ((Element)v.get(265)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(270)).setAttribute("align","left" );
      ((Element)v.get(270)).setAttribute("nowrap","true" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(271)).setAttribute("nombre","fecDocu" );
      ((Element)v.get(271)).setAttribute("id","datosCampos" );
      ((Element)v.get(271)).setAttribute("trim","S" );
      ((Element)v.get(271)).setAttribute("max","7" );
      ((Element)v.get(271)).setAttribute("onchange","" );
      ((Element)v.get(271)).setAttribute("req","N" );
      ((Element)v.get(271)).setAttribute("size","7" );
      ((Element)v.get(271)).setAttribute("valor","" );
      ((Element)v.get(271)).setAttribute("validacion","" );
      ((Element)v.get(271)).setAttribute("onblur","" );
      ((Element)v.get(271)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true)" );
      ((Element)v.get(271)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm', 0, false)" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */
      /* Termina nodo:269   */

      /* Empieza nodo:272 / Elemento padre: 265   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(272)).setAttribute("nombre","fecDocuViewLabelTrId" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(265)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(273)).setAttribute("valign","top" );
      ((Element)v.get(273)).setAttribute("height","13" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(274)).setAttribute("nombre","lblViewFecDocu" );
      ((Element)v.get(274)).setAttribute("alto","13" );
      ((Element)v.get(274)).setAttribute("ancho","100" );
      ((Element)v.get(274)).setAttribute("id","EstDat" );
      ((Element)v.get(274)).setAttribute("valor","" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */
      /* Termina nodo:272   */
      /* Termina nodo:265   */
      /* Termina nodo:264   */

      /* Empieza nodo:275 / Elemento padre: 263   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(275)).setAttribute("nombre","fecDocuGapTdId" );
      ((Element)v.get(275)).setAttribute("nowrap","true" );
      ((Element)v.get(275)).setAttribute("class","datosCampos" );
      ((Element)v.get(263)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(276)).setAttribute("src","b.gif" );
      ((Element)v.get(276)).setAttribute("width","25" );
      ((Element)v.get(276)).setAttribute("height","8" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:277 / Elemento padre: 263   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(277)).setAttribute("width","100%" );
      ((Element)v.get(263)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(278)).setAttribute("src","b.gif" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */
      /* Termina nodo:263   */
      /* Termina nodo:262   */
      /* Termina nodo:261   */
      /* Termina nodo:258   */

      /* Empieza nodo:279 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(279)).setAttribute("nombre","formGapTr5" );
      ((Element)v.get(40)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(280)).setAttribute("align","center" );
      ((Element)v.get(280)).setAttribute("width","12" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(281)).setAttribute("src","b.gif" );
      ((Element)v.get(281)).setAttribute("width","12" );
      ((Element)v.get(281)).setAttribute("height","8" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:280   */

      /* Empieza nodo:282 / Elemento padre: 279   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(279)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(283)).setAttribute("src","b.gif" );
      ((Element)v.get(283)).setAttribute("width","8" );
      ((Element)v.get(283)).setAttribute("height","8" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:284 / Elemento padre: 279   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(284)).setAttribute("align","center" );
      ((Element)v.get(284)).setAttribute("width","12" );
      ((Element)v.get(279)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(285)).setAttribute("src","b.gif" );
      ((Element)v.get(285)).setAttribute("width","12" );
      ((Element)v.get(285)).setAttribute("height","8" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */
      /* Termina nodo:279   */

      /* Empieza nodo:286 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(286)).setAttribute("nombre","formTr6" );
      ((Element)v.get(40)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(287)).setAttribute("align","center" );
      ((Element)v.get(287)).setAttribute("width","12" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(288)).setAttribute("src","b.gif" );
      ((Element)v.get(288)).setAttribute("width","12" );
      ((Element)v.get(288)).setAttribute("height","12" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:287   */

      /* Empieza nodo:289 / Elemento padre: 286   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(289)).setAttribute("width","100%" );
      ((Element)v.get(286)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(290)).setAttribute("width","100%" );
      ((Element)v.get(290)).setAttribute("border","0" );
      ((Element)v.get(290)).setAttribute("cellspacing","0" );
      ((Element)v.get(290)).setAttribute("cellpadding","0" );
      ((Element)v.get(290)).setAttribute("align","left" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(291)).setAttribute("align","left" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(292)).setAttribute("nombre","indNotiTdId" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(293)).setAttribute("width","100%" );
      ((Element)v.get(293)).setAttribute("border","0" );
      ((Element)v.get(293)).setAttribute("cellspacing","0" );
      ((Element)v.get(293)).setAttribute("cellpadding","0" );
      ((Element)v.get(293)).setAttribute("align","left" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(292)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(293)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(295)).setAttribute("valign","top" );
      ((Element)v.get(295)).setAttribute("height","13" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(296)).setAttribute("nombre","lblIndNoti" );
      ((Element)v.get(296)).setAttribute("alto","13" );
      ((Element)v.get(296)).setAttribute("filas","1" );
      ((Element)v.get(296)).setAttribute("id","datosTitle" );
      ((Element)v.get(296)).setAttribute("cod","CarSoliEntrBloq.indNoti.label" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */
      /* Termina nodo:294   */

      /* Empieza nodo:297 / Elemento padre: 293   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(297)).setAttribute("nombre","indNotiWidgetTrId" );
      ((Element)v.get(293)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(298)).setAttribute("align","left" );
      ((Element)v.get(298)).setAttribute("nowrap","true" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(299)).setAttribute("nombre","indNoti" );
      ((Element)v.get(299)).setAttribute("id","datosCampos" );
      ((Element)v.get(299)).setAttribute("trim","S" );
      ((Element)v.get(299)).setAttribute("max","1" );
      ((Element)v.get(299)).setAttribute("onchange","" );
      ((Element)v.get(299)).setAttribute("req","N" );
      ((Element)v.get(299)).setAttribute("size","1" );
      ((Element)v.get(299)).setAttribute("valor","" );
      ((Element)v.get(299)).setAttribute("validacion","" );
      ((Element)v.get(299)).setAttribute("onblur","" );
      ((Element)v.get(299)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true)" );
      ((Element)v.get(299)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm', 0, false)" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:300 / Elemento padre: 293   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(300)).setAttribute("nombre","indNotiViewLabelTrId" );
      ((Element)v.get(293)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(301)).setAttribute("valign","top" );
      ((Element)v.get(301)).setAttribute("height","13" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(302)).setAttribute("nombre","lblViewIndNoti" );
      ((Element)v.get(302)).setAttribute("alto","13" );
      ((Element)v.get(302)).setAttribute("ancho","100" );
      ((Element)v.get(302)).setAttribute("id","EstDat" );
      ((Element)v.get(302)).setAttribute("valor","" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */
      /* Termina nodo:300   */
      /* Termina nodo:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:303 / Elemento padre: 291   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(303)).setAttribute("nombre","indNotiGapTdId" );
      ((Element)v.get(303)).setAttribute("nowrap","true" );
      ((Element)v.get(303)).setAttribute("class","datosCampos" );
      ((Element)v.get(291)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(304)).setAttribute("src","b.gif" );
      ((Element)v.get(304)).setAttribute("width","25" );
      ((Element)v.get(304)).setAttribute("height","8" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */

      /* Empieza nodo:305 / Elemento padre: 291   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(305)).setAttribute("width","100%" );
      ((Element)v.get(291)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(306)).setAttribute("src","b.gif" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */
      /* Termina nodo:291   */
      /* Termina nodo:290   */
      /* Termina nodo:289   */
      /* Termina nodo:286   */

      /* Empieza nodo:307 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(307)).setAttribute("nombre","formGapTr6" );
      ((Element)v.get(40)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(308)).setAttribute("align","center" );
      ((Element)v.get(308)).setAttribute("width","12" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(309)).setAttribute("src","b.gif" );
      ((Element)v.get(309)).setAttribute("width","12" );
      ((Element)v.get(309)).setAttribute("height","8" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:310 / Elemento padre: 307   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(307)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(311)).setAttribute("src","b.gif" );
      ((Element)v.get(311)).setAttribute("width","8" );
      ((Element)v.get(311)).setAttribute("height","8" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */

      /* Empieza nodo:312 / Elemento padre: 307   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(312)).setAttribute("align","center" );
      ((Element)v.get(312)).setAttribute("width","12" );
      ((Element)v.get(307)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(313)).setAttribute("src","b.gif" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(313)).setAttribute("width","12" );
      ((Element)v.get(313)).setAttribute("height","8" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:312   */
      /* Termina nodo:307   */

      /* Empieza nodo:314 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(314)).setAttribute("nombre","formTr7" );
      ((Element)v.get(40)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(315)).setAttribute("align","center" );
      ((Element)v.get(315)).setAttribute("width","12" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(316)).setAttribute("src","b.gif" );
      ((Element)v.get(316)).setAttribute("width","12" );
      ((Element)v.get(316)).setAttribute("height","12" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:317 / Elemento padre: 314   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(317)).setAttribute("width","100%" );
      ((Element)v.get(314)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(318)).setAttribute("width","100%" );
      ((Element)v.get(318)).setAttribute("border","0" );
      ((Element)v.get(318)).setAttribute("cellspacing","0" );
      ((Element)v.get(318)).setAttribute("cellpadding","0" );
      ((Element)v.get(318)).setAttribute("align","left" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(319)).setAttribute("align","left" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(320)).setAttribute("nombre","valMontOrdeTdId" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(321)).setAttribute("width","100%" );
      ((Element)v.get(321)).setAttribute("border","0" );
      ((Element)v.get(321)).setAttribute("cellspacing","0" );
      ((Element)v.get(321)).setAttribute("cellpadding","0" );
      ((Element)v.get(321)).setAttribute("align","left" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(321)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(323)).setAttribute("valign","top" );
      ((Element)v.get(323)).setAttribute("height","13" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(324)).setAttribute("nombre","lblValMontOrde" );
      ((Element)v.get(324)).setAttribute("alto","13" );
      ((Element)v.get(324)).setAttribute("filas","1" );
      ((Element)v.get(324)).setAttribute("id","datosTitle" );
      ((Element)v.get(324)).setAttribute("cod","CarSoliEntrBloq.valMontOrde.label" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */
      /* Termina nodo:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:325 / Elemento padre: 321   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(325)).setAttribute("nombre","valMontOrdeWidgetTrId" );
      ((Element)v.get(321)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(326)).setAttribute("align","left" );
      ((Element)v.get(326)).setAttribute("nowrap","true" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(327)).setAttribute("nombre","valMontOrde" );
      ((Element)v.get(327)).setAttribute("id","datosCampos" );
      ((Element)v.get(327)).setAttribute("trim","S" );
      ((Element)v.get(327)).setAttribute("max","12" );
      ((Element)v.get(327)).setAttribute("onchange","" );
      ((Element)v.get(327)).setAttribute("req","N" );
      ((Element)v.get(327)).setAttribute("size","12" );
      ((Element)v.get(327)).setAttribute("valor","" );
      ((Element)v.get(327)).setAttribute("validacion","" );
      ((Element)v.get(327)).setAttribute("onblur","" );
      ((Element)v.get(327)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true)" );
      ((Element)v.get(327)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm', 0, false)" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:326   */
      /* Termina nodo:325   */

      /* Empieza nodo:328 / Elemento padre: 321   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(328)).setAttribute("nombre","valMontOrdeViewLabelTrId" );
      ((Element)v.get(321)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(329)).setAttribute("valign","top" );
      ((Element)v.get(329)).setAttribute("height","13" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(330)).setAttribute("nombre","lblViewValMontOrde" );
      ((Element)v.get(330)).setAttribute("alto","13" );
      ((Element)v.get(330)).setAttribute("ancho","100" );
      ((Element)v.get(330)).setAttribute("id","EstDat" );
      ((Element)v.get(330)).setAttribute("valor","" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:329   */
      /* Termina nodo:328   */
      /* Termina nodo:321   */
      /* Termina nodo:320   */

      /* Empieza nodo:331 / Elemento padre: 319   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(331)).setAttribute("nombre","valMontOrdeGapTdId" );
      ((Element)v.get(331)).setAttribute("nowrap","true" );
      ((Element)v.get(331)).setAttribute("class","datosCampos" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(319)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(332)).setAttribute("src","b.gif" );
      ((Element)v.get(332)).setAttribute("width","25" );
      ((Element)v.get(332)).setAttribute("height","8" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:331   */

      /* Empieza nodo:333 / Elemento padre: 319   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(333)).setAttribute("width","100%" );
      ((Element)v.get(319)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(334)).setAttribute("src","b.gif" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */
      /* Termina nodo:319   */
      /* Termina nodo:318   */
      /* Termina nodo:317   */
      /* Termina nodo:314   */

      /* Empieza nodo:335 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(335)).setAttribute("nombre","formGapTr7" );
      ((Element)v.get(40)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(336)).setAttribute("align","center" );
      ((Element)v.get(336)).setAttribute("width","12" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(337)).setAttribute("src","b.gif" );
      ((Element)v.get(337)).setAttribute("width","12" );
      ((Element)v.get(337)).setAttribute("height","8" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */
      /* Termina nodo:336   */

      /* Empieza nodo:338 / Elemento padre: 335   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(335)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(339)).setAttribute("src","b.gif" );
      ((Element)v.get(339)).setAttribute("width","8" );
      ((Element)v.get(339)).setAttribute("height","8" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */
      /* Termina nodo:338   */

      /* Empieza nodo:340 / Elemento padre: 335   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(340)).setAttribute("align","center" );
      ((Element)v.get(340)).setAttribute("width","12" );
      ((Element)v.get(335)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(341)).setAttribute("src","b.gif" );
      ((Element)v.get(341)).setAttribute("width","12" );
      ((Element)v.get(341)).setAttribute("height","8" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */
      /* Termina nodo:340   */
      /* Termina nodo:335   */

      /* Empieza nodo:342 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(342)).setAttribute("nombre","formTr8" );
      ((Element)v.get(40)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(343)).setAttribute("align","center" );
      ((Element)v.get(343)).setAttribute("width","12" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(344)).setAttribute("src","b.gif" );
      ((Element)v.get(344)).setAttribute("width","12" );
      ((Element)v.get(344)).setAttribute("height","12" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:343   */

      /* Empieza nodo:345 / Elemento padre: 342   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(345)).setAttribute("width","100%" );
      ((Element)v.get(342)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(346)).setAttribute("width","100%" );
      ((Element)v.get(346)).setAttribute("border","0" );
      ((Element)v.get(346)).setAttribute("cellspacing","0" );
      ((Element)v.get(346)).setAttribute("cellpadding","0" );
      ((Element)v.get(346)).setAttribute("align","left" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(347)).setAttribute("align","left" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(348)).setAttribute("nombre","valMontDeudVencTdId" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(349)).setAttribute("width","100%" );
      ((Element)v.get(349)).setAttribute("border","0" );
      ((Element)v.get(349)).setAttribute("cellspacing","0" );
      ((Element)v.get(349)).setAttribute("cellpadding","0" );
      ((Element)v.get(349)).setAttribute("align","left" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(349)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(351)).setAttribute("valign","top" );
      ((Element)v.get(351)).setAttribute("height","13" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(352)).setAttribute("nombre","lblValMontDeudVenc" );
      ((Element)v.get(352)).setAttribute("alto","13" );
      ((Element)v.get(352)).setAttribute("filas","1" );
      ((Element)v.get(352)).setAttribute("id","datosTitle" );
      ((Element)v.get(352)).setAttribute("cod","CarSoliEntrBloq.valMontDeudVenc.label" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */
      /* Termina nodo:351   */
      /* Termina nodo:350   */

      /* Empieza nodo:353 / Elemento padre: 349   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(353)).setAttribute("nombre","valMontDeudVencWidgetTrId" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(349)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(354)).setAttribute("align","left" );
      ((Element)v.get(354)).setAttribute("nowrap","true" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(355)).setAttribute("nombre","valMontDeudVenc" );
      ((Element)v.get(355)).setAttribute("id","datosCampos" );
      ((Element)v.get(355)).setAttribute("trim","S" );
      ((Element)v.get(355)).setAttribute("max","12" );
      ((Element)v.get(355)).setAttribute("onchange","" );
      ((Element)v.get(355)).setAttribute("req","N" );
      ((Element)v.get(355)).setAttribute("size","12" );
      ((Element)v.get(355)).setAttribute("valor","" );
      ((Element)v.get(355)).setAttribute("validacion","" );
      ((Element)v.get(355)).setAttribute("onblur","" );
      ((Element)v.get(355)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true)" );
      ((Element)v.get(355)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm', 0, false)" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */
      /* Termina nodo:354   */
      /* Termina nodo:353   */

      /* Empieza nodo:356 / Elemento padre: 349   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(356)).setAttribute("nombre","valMontDeudVencViewLabelTrId" );
      ((Element)v.get(349)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(357)).setAttribute("valign","top" );
      ((Element)v.get(357)).setAttribute("height","13" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(358)).setAttribute("nombre","lblViewValMontDeudVenc" );
      ((Element)v.get(358)).setAttribute("alto","13" );
      ((Element)v.get(358)).setAttribute("ancho","100" );
      ((Element)v.get(358)).setAttribute("id","EstDat" );
      ((Element)v.get(358)).setAttribute("valor","" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */
      /* Termina nodo:357   */
      /* Termina nodo:356   */
      /* Termina nodo:349   */
      /* Termina nodo:348   */

      /* Empieza nodo:359 / Elemento padre: 347   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(359)).setAttribute("nombre","valMontDeudVencGapTdId" );
      ((Element)v.get(359)).setAttribute("nowrap","true" );
      ((Element)v.get(359)).setAttribute("class","datosCampos" );
      ((Element)v.get(347)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(360)).setAttribute("src","b.gif" );
      ((Element)v.get(360)).setAttribute("width","25" );
      ((Element)v.get(360)).setAttribute("height","8" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:359   */

      /* Empieza nodo:361 / Elemento padre: 347   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(361)).setAttribute("width","100%" );
      ((Element)v.get(347)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(362)).setAttribute("src","b.gif" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:361   */
      /* Termina nodo:347   */
      /* Termina nodo:346   */
      /* Termina nodo:345   */
      /* Termina nodo:342   */

      /* Empieza nodo:363 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(363)).setAttribute("nombre","formGapTr8" );
      ((Element)v.get(40)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(364)).setAttribute("align","center" );
      ((Element)v.get(364)).setAttribute("width","12" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(365)).setAttribute("src","b.gif" );
      ((Element)v.get(365)).setAttribute("width","12" );
      ((Element)v.get(365)).setAttribute("height","8" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */
      /* Termina nodo:364   */

      /* Empieza nodo:366 / Elemento padre: 363   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(363)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(367)).setAttribute("src","b.gif" );
      ((Element)v.get(367)).setAttribute("width","8" );
      ((Element)v.get(367)).setAttribute("height","8" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */
      /* Termina nodo:366   */

      /* Empieza nodo:368 / Elemento padre: 363   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(368)).setAttribute("align","center" );
      ((Element)v.get(368)).setAttribute("width","12" );
      ((Element)v.get(363)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(369)).setAttribute("src","b.gif" );
      ((Element)v.get(369)).setAttribute("width","12" );
      ((Element)v.get(369)).setAttribute("height","8" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */
      /* Termina nodo:363   */

      /* Empieza nodo:370 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(370)).setAttribute("nombre","formTr9" );
      ((Element)v.get(40)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(371)).setAttribute("align","center" );
      ((Element)v.get(371)).setAttribute("width","12" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(372)).setAttribute("src","b.gif" );
      ((Element)v.get(372)).setAttribute("width","12" );
      ((Element)v.get(372)).setAttribute("height","12" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */
      /* Termina nodo:371   */

      /* Empieza nodo:373 / Elemento padre: 370   */
      v.add(doc.createElement("TD"));
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(373)).setAttribute("width","100%" );
      ((Element)v.get(370)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(374)).setAttribute("width","100%" );
      ((Element)v.get(374)).setAttribute("border","0" );
      ((Element)v.get(374)).setAttribute("cellspacing","0" );
      ((Element)v.get(374)).setAttribute("cellpadding","0" );
      ((Element)v.get(374)).setAttribute("align","left" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(375)).setAttribute("align","left" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(376)).setAttribute("nombre","indVali1TdId" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(377)).setAttribute("width","100%" );
      ((Element)v.get(377)).setAttribute("border","0" );
      ((Element)v.get(377)).setAttribute("cellspacing","0" );
      ((Element)v.get(377)).setAttribute("cellpadding","0" );
      ((Element)v.get(377)).setAttribute("align","left" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(377)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(379)).setAttribute("valign","top" );
      ((Element)v.get(379)).setAttribute("height","13" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(380)).setAttribute("nombre","lblIndVali1" );
      ((Element)v.get(380)).setAttribute("alto","13" );
      ((Element)v.get(380)).setAttribute("filas","1" );
      ((Element)v.get(380)).setAttribute("id","datosTitle" );
      ((Element)v.get(380)).setAttribute("cod","CarSoliEntrBloq.indVali1.label" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */
      /* Termina nodo:379   */
      /* Termina nodo:378   */

      /* Empieza nodo:381 / Elemento padre: 377   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(381)).setAttribute("nombre","indVali1WidgetTrId" );
      ((Element)v.get(377)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(382)).setAttribute("align","left" );
      ((Element)v.get(382)).setAttribute("nowrap","true" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(383)).setAttribute("nombre","indVali1" );
      ((Element)v.get(383)).setAttribute("id","datosCampos" );
      ((Element)v.get(383)).setAttribute("trim","S" );
      ((Element)v.get(383)).setAttribute("max","1" );
      ((Element)v.get(383)).setAttribute("onchange","" );
      ((Element)v.get(383)).setAttribute("req","N" );
      ((Element)v.get(383)).setAttribute("size","1" );
      ((Element)v.get(383)).setAttribute("valor","" );
      ((Element)v.get(383)).setAttribute("validacion","" );
      ((Element)v.get(383)).setAttribute("onblur","" );
      ((Element)v.get(383)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true)" );
      ((Element)v.get(383)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm', 0, false)" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */
      /* Termina nodo:382   */
      /* Termina nodo:381   */

      /* Empieza nodo:384 / Elemento padre: 377   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(384)).setAttribute("nombre","indVali1ViewLabelTrId" );
      ((Element)v.get(377)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(385)).setAttribute("valign","top" );
      ((Element)v.get(385)).setAttribute("height","13" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(386)).setAttribute("nombre","lblViewIndVali1" );
      ((Element)v.get(386)).setAttribute("alto","13" );
      ((Element)v.get(386)).setAttribute("ancho","100" );
      ((Element)v.get(386)).setAttribute("id","EstDat" );
      ((Element)v.get(386)).setAttribute("valor","" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));
      /* Termina nodo:386   */
      /* Termina nodo:385   */
      /* Termina nodo:384   */
      /* Termina nodo:377   */
      /* Termina nodo:376   */

      /* Empieza nodo:387 / Elemento padre: 375   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(387)).setAttribute("nombre","indVali1GapTdId" );
      ((Element)v.get(387)).setAttribute("nowrap","true" );
      ((Element)v.get(387)).setAttribute("class","datosCampos" );
      ((Element)v.get(375)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(388)).setAttribute("src","b.gif" );
      ((Element)v.get(388)).setAttribute("width","25" );
      ((Element)v.get(388)).setAttribute("height","8" );
      ((Element)v.get(387)).appendChild((Element)v.get(388));
      /* Termina nodo:388   */
      /* Termina nodo:387   */

      /* Empieza nodo:389 / Elemento padre: 375   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(389)).setAttribute("width","100%" );
      ((Element)v.get(375)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(390)).setAttribute("src","b.gif" );
      ((Element)v.get(389)).appendChild((Element)v.get(390));
      /* Termina nodo:390   */
      /* Termina nodo:389   */
      /* Termina nodo:375   */
      /* Termina nodo:374   */
      /* Termina nodo:373   */
      /* Termina nodo:370   */

      /* Empieza nodo:391 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(391)).setAttribute("nombre","formGapTr9" );
      ((Element)v.get(40)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("TD"));
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(392)).setAttribute("align","center" );
      ((Element)v.get(392)).setAttribute("width","12" );
      ((Element)v.get(391)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(393)).setAttribute("src","b.gif" );
      ((Element)v.get(393)).setAttribute("width","12" );
      ((Element)v.get(393)).setAttribute("height","8" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));
      /* Termina nodo:393   */
      /* Termina nodo:392   */

      /* Empieza nodo:394 / Elemento padre: 391   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(391)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(395)).setAttribute("src","b.gif" );
      ((Element)v.get(395)).setAttribute("width","8" );
      ((Element)v.get(395)).setAttribute("height","8" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */
      /* Termina nodo:394   */

      /* Empieza nodo:396 / Elemento padre: 391   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(396)).setAttribute("align","center" );
      ((Element)v.get(396)).setAttribute("width","12" );
      ((Element)v.get(391)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(397)).setAttribute("src","b.gif" );
      ((Element)v.get(397)).setAttribute("width","12" );
      ((Element)v.get(397)).setAttribute("height","8" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */
      /* Termina nodo:396   */
      /* Termina nodo:391   */

      /* Empieza nodo:398 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(398)).setAttribute("nombre","formTr10" );
      ((Element)v.get(40)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(399)).setAttribute("align","center" );
      ((Element)v.get(399)).setAttribute("width","12" );
      ((Element)v.get(398)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(400)).setAttribute("src","b.gif" );
      ((Element)v.get(400)).setAttribute("width","12" );
      ((Element)v.get(400)).setAttribute("height","12" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));
      /* Termina nodo:400   */
      /* Termina nodo:399   */

      /* Empieza nodo:401 / Elemento padre: 398   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(401)).setAttribute("width","100%" );
      ((Element)v.get(398)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(402)).setAttribute("width","100%" );
      ((Element)v.get(402)).setAttribute("border","0" );
      ((Element)v.get(402)).setAttribute("cellspacing","0" );
      ((Element)v.get(402)).setAttribute("cellpadding","0" );
      ((Element)v.get(402)).setAttribute("align","left" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(403)).setAttribute("align","left" );
      ((Element)v.get(402)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(404)).setAttribute("nombre","indVali2TdId" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(405)).setAttribute("width","100%" );
      ((Element)v.get(405)).setAttribute("border","0" );
      ((Element)v.get(405)).setAttribute("cellspacing","0" );
      ((Element)v.get(405)).setAttribute("cellpadding","0" );
      ((Element)v.get(405)).setAttribute("align","left" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(405)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(407)).setAttribute("valign","top" );
      ((Element)v.get(407)).setAttribute("height","13" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(408)).setAttribute("nombre","lblIndVali2" );
      ((Element)v.get(408)).setAttribute("alto","13" );
      ((Element)v.get(408)).setAttribute("filas","1" );
      ((Element)v.get(408)).setAttribute("id","datosTitle" );
      ((Element)v.get(408)).setAttribute("cod","CarSoliEntrBloq.indVali2.label" );
      ((Element)v.get(407)).appendChild((Element)v.get(408));
      /* Termina nodo:408   */
      /* Termina nodo:407   */
      /* Termina nodo:406   */

      /* Empieza nodo:409 / Elemento padre: 405   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(409)).setAttribute("nombre","indVali2WidgetTrId" );
      ((Element)v.get(405)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(410)).setAttribute("align","left" );
      ((Element)v.get(410)).setAttribute("nowrap","true" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(411)).setAttribute("nombre","indVali2" );
      ((Element)v.get(411)).setAttribute("id","datosCampos" );
      ((Element)v.get(411)).setAttribute("trim","S" );
      ((Element)v.get(411)).setAttribute("max","1" );
      ((Element)v.get(411)).setAttribute("onchange","" );
      ((Element)v.get(411)).setAttribute("req","N" );
      ((Element)v.get(411)).setAttribute("size","1" );
      ((Element)v.get(411)).setAttribute("valor","" );
      ((Element)v.get(411)).setAttribute("validacion","" );
      ((Element)v.get(411)).setAttribute("onblur","" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(411)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true)" );
      ((Element)v.get(411)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm', 0, false)" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */
      /* Termina nodo:410   */
      /* Termina nodo:409   */

      /* Empieza nodo:412 / Elemento padre: 405   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(412)).setAttribute("nombre","indVali2ViewLabelTrId" );
      ((Element)v.get(405)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(413)).setAttribute("valign","top" );
      ((Element)v.get(413)).setAttribute("height","13" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(414)).setAttribute("nombre","lblViewIndVali2" );
      ((Element)v.get(414)).setAttribute("alto","13" );
      ((Element)v.get(414)).setAttribute("ancho","100" );
      ((Element)v.get(414)).setAttribute("id","EstDat" );
      ((Element)v.get(414)).setAttribute("valor","" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */
      /* Termina nodo:413   */
      /* Termina nodo:412   */
      /* Termina nodo:405   */
      /* Termina nodo:404   */

      /* Empieza nodo:415 / Elemento padre: 403   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(415)).setAttribute("nombre","indVali2GapTdId" );
      ((Element)v.get(415)).setAttribute("nowrap","true" );
      ((Element)v.get(415)).setAttribute("class","datosCampos" );
      ((Element)v.get(403)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(416)).setAttribute("src","b.gif" );
      ((Element)v.get(416)).setAttribute("width","25" );
      ((Element)v.get(416)).setAttribute("height","8" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */
      /* Termina nodo:415   */

      /* Empieza nodo:417 / Elemento padre: 403   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(417)).setAttribute("width","100%" );
      ((Element)v.get(403)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(418)).setAttribute("src","b.gif" );
      ((Element)v.get(417)).appendChild((Element)v.get(418));
      /* Termina nodo:418   */
      /* Termina nodo:417   */
      /* Termina nodo:403   */
      /* Termina nodo:402   */
      /* Termina nodo:401   */
      /* Termina nodo:398   */

      /* Empieza nodo:419 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(419)).setAttribute("nombre","formGapTr10" );
      ((Element)v.get(40)).appendChild((Element)v.get(419));

      /* Empieza nodo:420 / Elemento padre: 419   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(420)).setAttribute("align","center" );
      ((Element)v.get(420)).setAttribute("width","12" );
      ((Element)v.get(419)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(421)).setAttribute("src","b.gif" );
      ((Element)v.get(421)).setAttribute("width","12" );
      ((Element)v.get(421)).setAttribute("height","8" );
      ((Element)v.get(420)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */
      /* Termina nodo:420   */

      /* Empieza nodo:422 / Elemento padre: 419   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(419)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(423)).setAttribute("src","b.gif" );
      ((Element)v.get(423)).setAttribute("width","8" );
      ((Element)v.get(423)).setAttribute("height","8" );
      ((Element)v.get(422)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */
      /* Termina nodo:422   */

      /* Empieza nodo:424 / Elemento padre: 419   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(424)).setAttribute("align","center" );
      ((Element)v.get(424)).setAttribute("width","12" );
      ((Element)v.get(419)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(425)).setAttribute("src","b.gif" );
      ((Element)v.get(425)).setAttribute("width","12" );
      ((Element)v.get(425)).setAttribute("height","8" );
      ((Element)v.get(424)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */
      /* Termina nodo:424   */
      /* Termina nodo:419   */

      /* Empieza nodo:426 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(426)).setAttribute("nombre","formTr11" );
      ((Element)v.get(40)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(427)).setAttribute("align","center" );
      ((Element)v.get(427)).setAttribute("width","12" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(428)).setAttribute("src","b.gif" );
      ((Element)v.get(428)).setAttribute("width","12" );
      ((Element)v.get(428)).setAttribute("height","12" );
      ((Element)v.get(427)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */
      /* Termina nodo:427   */

      /* Empieza nodo:429 / Elemento padre: 426   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(429)).setAttribute("width","100%" );
      ((Element)v.get(426)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(430)).setAttribute("width","100%" );
      ((Element)v.get(430)).setAttribute("border","0" );
      ((Element)v.get(430)).setAttribute("cellspacing","0" );
      ((Element)v.get(430)).setAttribute("cellpadding","0" );
      ((Element)v.get(430)).setAttribute("align","left" );
      ((Element)v.get(429)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(431)).setAttribute("align","left" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(432)).setAttribute("nombre","indVali3TdId" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("TABLE"));
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(433)).setAttribute("width","100%" );
      ((Element)v.get(433)).setAttribute("border","0" );
      ((Element)v.get(433)).setAttribute("cellspacing","0" );
      ((Element)v.get(433)).setAttribute("cellpadding","0" );
      ((Element)v.get(433)).setAttribute("align","left" );
      ((Element)v.get(432)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(433)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(435)).setAttribute("valign","top" );
      ((Element)v.get(435)).setAttribute("height","13" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(436)).setAttribute("nombre","lblIndVali3" );
      ((Element)v.get(436)).setAttribute("alto","13" );
      ((Element)v.get(436)).setAttribute("filas","1" );
      ((Element)v.get(436)).setAttribute("id","datosTitle" );
      ((Element)v.get(436)).setAttribute("cod","CarSoliEntrBloq.indVali3.label" );
      ((Element)v.get(435)).appendChild((Element)v.get(436));
      /* Termina nodo:436   */
      /* Termina nodo:435   */
      /* Termina nodo:434   */

      /* Empieza nodo:437 / Elemento padre: 433   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(437)).setAttribute("nombre","indVali3WidgetTrId" );
      ((Element)v.get(433)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(438)).setAttribute("align","left" );
      ((Element)v.get(438)).setAttribute("nowrap","true" );
      ((Element)v.get(437)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(439)).setAttribute("nombre","indVali3" );
      ((Element)v.get(439)).setAttribute("id","datosCampos" );
      ((Element)v.get(439)).setAttribute("trim","S" );
      ((Element)v.get(439)).setAttribute("max","1" );
      ((Element)v.get(439)).setAttribute("onchange","" );
      ((Element)v.get(439)).setAttribute("req","N" );
      ((Element)v.get(439)).setAttribute("size","1" );
      ((Element)v.get(439)).setAttribute("valor","" );
      ((Element)v.get(439)).setAttribute("validacion","" );
      ((Element)v.get(439)).setAttribute("onblur","" );
      ((Element)v.get(439)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true)" );
      ((Element)v.get(439)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm', 0, false)" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */
      /* Termina nodo:438   */
      /* Termina nodo:437   */

      /* Empieza nodo:440 / Elemento padre: 433   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(440)).setAttribute("nombre","indVali3ViewLabelTrId" );
      ((Element)v.get(433)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(441)).setAttribute("valign","top" );
      ((Element)v.get(441)).setAttribute("height","13" );
      ((Element)v.get(440)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(442)).setAttribute("nombre","lblViewIndVali3" );
      ((Element)v.get(442)).setAttribute("alto","13" );
      ((Element)v.get(442)).setAttribute("ancho","100" );
      ((Element)v.get(442)).setAttribute("id","EstDat" );
      ((Element)v.get(442)).setAttribute("valor","" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */
      /* Termina nodo:441   */
      /* Termina nodo:440   */
      /* Termina nodo:433   */
      /* Termina nodo:432   */

      /* Empieza nodo:443 / Elemento padre: 431   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(443)).setAttribute("nombre","indVali3GapTdId" );
      ((Element)v.get(443)).setAttribute("nowrap","true" );
      ((Element)v.get(443)).setAttribute("class","datosCampos" );
      ((Element)v.get(431)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(444)).setAttribute("src","b.gif" );
      ((Element)v.get(444)).setAttribute("width","25" );
      ((Element)v.get(444)).setAttribute("height","8" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));
      /* Termina nodo:444   */
      /* Termina nodo:443   */

      /* Empieza nodo:445 / Elemento padre: 431   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(445)).setAttribute("width","100%" );
      ((Element)v.get(431)).appendChild((Element)v.get(445));

      /* Empieza nodo:446 / Elemento padre: 445   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(446)).setAttribute("src","b.gif" );
      ((Element)v.get(445)).appendChild((Element)v.get(446));
      /* Termina nodo:446   */
      /* Termina nodo:445   */
      /* Termina nodo:431   */
      /* Termina nodo:430   */
      /* Termina nodo:429   */
      /* Termina nodo:426   */

      /* Empieza nodo:447 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(447)).setAttribute("nombre","formGapTr11" );
      ((Element)v.get(40)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(448)).setAttribute("align","center" );
      ((Element)v.get(448)).setAttribute("width","12" );
      ((Element)v.get(447)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(449)).setAttribute("src","b.gif" );
      ((Element)v.get(449)).setAttribute("width","12" );
      ((Element)v.get(449)).setAttribute("height","8" );
      ((Element)v.get(448)).appendChild((Element)v.get(449));
      /* Termina nodo:449   */
      /* Termina nodo:448   */

      /* Empieza nodo:450 / Elemento padre: 447   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(447)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(451)).setAttribute("src","b.gif" );
      ((Element)v.get(451)).setAttribute("width","8" );
      ((Element)v.get(451)).setAttribute("height","8" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));
      /* Termina nodo:451   */
      /* Termina nodo:450   */

      /* Empieza nodo:452 / Elemento padre: 447   */
      v.add(doc.createElement("TD"));
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(452)).setAttribute("align","center" );
      ((Element)v.get(452)).setAttribute("width","12" );
      ((Element)v.get(447)).appendChild((Element)v.get(452));

      /* Empieza nodo:453 / Elemento padre: 452   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(453)).setAttribute("src","b.gif" );
      ((Element)v.get(453)).setAttribute("width","12" );
      ((Element)v.get(453)).setAttribute("height","8" );
      ((Element)v.get(452)).appendChild((Element)v.get(453));
      /* Termina nodo:453   */
      /* Termina nodo:452   */
      /* Termina nodo:447   */

      /* Empieza nodo:454 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(454)).setAttribute("nombre","formTr12" );
      ((Element)v.get(40)).appendChild((Element)v.get(454));

      /* Empieza nodo:455 / Elemento padre: 454   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(455)).setAttribute("align","center" );
      ((Element)v.get(455)).setAttribute("width","12" );
      ((Element)v.get(454)).appendChild((Element)v.get(455));

      /* Empieza nodo:456 / Elemento padre: 455   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(456)).setAttribute("src","b.gif" );
      ((Element)v.get(456)).setAttribute("width","12" );
      ((Element)v.get(456)).setAttribute("height","12" );
      ((Element)v.get(455)).appendChild((Element)v.get(456));
      /* Termina nodo:456   */
      /* Termina nodo:455   */

      /* Empieza nodo:457 / Elemento padre: 454   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(457)).setAttribute("width","100%" );
      ((Element)v.get(454)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(458)).setAttribute("width","100%" );
      ((Element)v.get(458)).setAttribute("border","0" );
      ((Element)v.get(458)).setAttribute("cellspacing","0" );
      ((Element)v.get(458)).setAttribute("cellpadding","0" );
      ((Element)v.get(458)).setAttribute("align","left" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));

      /* Empieza nodo:459 / Elemento padre: 458   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(459)).setAttribute("align","left" );
      ((Element)v.get(458)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(460)).setAttribute("nombre","indVali4TdId" );
      ((Element)v.get(459)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(461)).setAttribute("width","100%" );
      ((Element)v.get(461)).setAttribute("border","0" );
      ((Element)v.get(461)).setAttribute("cellspacing","0" );
      ((Element)v.get(461)).setAttribute("cellpadding","0" );
      ((Element)v.get(461)).setAttribute("align","left" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));

      /* Empieza nodo:462 / Elemento padre: 461   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(461)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(463)).setAttribute("valign","top" );
      ((Element)v.get(463)).setAttribute("height","13" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));

      /* Empieza nodo:464 / Elemento padre: 463   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(464)).setAttribute("nombre","lblIndVali4" );
      ((Element)v.get(464)).setAttribute("alto","13" );
      ((Element)v.get(464)).setAttribute("filas","1" );
      ((Element)v.get(464)).setAttribute("id","datosTitle" );
      ((Element)v.get(464)).setAttribute("cod","CarSoliEntrBloq.indVali4.label" );
      ((Element)v.get(463)).appendChild((Element)v.get(464));
      /* Termina nodo:464   */
      /* Termina nodo:463   */
      /* Termina nodo:462   */

      /* Empieza nodo:465 / Elemento padre: 461   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(465)).setAttribute("nombre","indVali4WidgetTrId" );
      ((Element)v.get(461)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(466)).setAttribute("align","left" );
      ((Element)v.get(466)).setAttribute("nowrap","true" );
      ((Element)v.get(465)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(467)).setAttribute("nombre","indVali4" );
      ((Element)v.get(467)).setAttribute("id","datosCampos" );
      ((Element)v.get(467)).setAttribute("trim","S" );
      ((Element)v.get(467)).setAttribute("max","1" );
      ((Element)v.get(467)).setAttribute("onchange","" );
      ((Element)v.get(467)).setAttribute("req","N" );
      ((Element)v.get(467)).setAttribute("size","1" );
      ((Element)v.get(467)).setAttribute("valor","" );
      ((Element)v.get(467)).setAttribute("validacion","" );
      ((Element)v.get(467)).setAttribute("onblur","" );
      ((Element)v.get(467)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true)" );
      ((Element)v.get(467)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm', 0, false)" );
      ((Element)v.get(466)).appendChild((Element)v.get(467));
      /* Termina nodo:467   */
      /* Termina nodo:466   */
      /* Termina nodo:465   */

      /* Empieza nodo:468 / Elemento padre: 461   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(468)).setAttribute("nombre","indVali4ViewLabelTrId" );
      ((Element)v.get(461)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(469)).setAttribute("valign","top" );
      ((Element)v.get(469)).setAttribute("height","13" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));

      /* Empieza nodo:470 / Elemento padre: 469   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(470)).setAttribute("nombre","lblViewIndVali4" );
      ((Element)v.get(470)).setAttribute("alto","13" );
      ((Element)v.get(470)).setAttribute("ancho","100" );
      ((Element)v.get(470)).setAttribute("id","EstDat" );
      ((Element)v.get(470)).setAttribute("valor","" );
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(469)).appendChild((Element)v.get(470));
      /* Termina nodo:470   */
      /* Termina nodo:469   */
      /* Termina nodo:468   */
      /* Termina nodo:461   */
      /* Termina nodo:460   */

      /* Empieza nodo:471 / Elemento padre: 459   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(471)).setAttribute("nombre","indVali4GapTdId" );
      ((Element)v.get(471)).setAttribute("nowrap","true" );
      ((Element)v.get(471)).setAttribute("class","datosCampos" );
      ((Element)v.get(459)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(472)).setAttribute("src","b.gif" );
      ((Element)v.get(472)).setAttribute("width","25" );
      ((Element)v.get(472)).setAttribute("height","8" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));
      /* Termina nodo:472   */
      /* Termina nodo:471   */

      /* Empieza nodo:473 / Elemento padre: 459   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(473)).setAttribute("width","100%" );
      ((Element)v.get(459)).appendChild((Element)v.get(473));

      /* Empieza nodo:474 / Elemento padre: 473   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(474)).setAttribute("src","b.gif" );
      ((Element)v.get(473)).appendChild((Element)v.get(474));
      /* Termina nodo:474   */
      /* Termina nodo:473   */
      /* Termina nodo:459   */
      /* Termina nodo:458   */
      /* Termina nodo:457   */
      /* Termina nodo:454   */

      /* Empieza nodo:475 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(475)).setAttribute("nombre","formGapTr12" );
      ((Element)v.get(40)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(476)).setAttribute("align","center" );
      ((Element)v.get(476)).setAttribute("width","12" );
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
      ((Element)v.get(480)).setAttribute("width","12" );
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

      /* Empieza nodo:482 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(482)).setAttribute("nombre","formTr13" );
      ((Element)v.get(40)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(483)).setAttribute("align","center" );
      ((Element)v.get(483)).setAttribute("width","12" );
      ((Element)v.get(482)).appendChild((Element)v.get(483));

      /* Empieza nodo:484 / Elemento padre: 483   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(484)).setAttribute("src","b.gif" );
      ((Element)v.get(484)).setAttribute("width","12" );
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
      ((Element)v.get(488)).setAttribute("nombre","fecHoraLibeTdId" );
      ((Element)v.get(487)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(489)).setAttribute("width","100%" );
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
      ((Element)v.get(492)).setAttribute("nombre","lblFecHoraLibe" );
      ((Element)v.get(492)).setAttribute("alto","13" );
      ((Element)v.get(492)).setAttribute("filas","1" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(492)).setAttribute("id","datosTitle" );
      ((Element)v.get(492)).setAttribute("cod","CarSoliEntrBloq.fecHoraLibe.label" );
      ((Element)v.get(491)).appendChild((Element)v.get(492));
      /* Termina nodo:492   */
      /* Termina nodo:491   */
      /* Termina nodo:490   */

      /* Empieza nodo:493 / Elemento padre: 489   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(493)).setAttribute("nombre","fecHoraLibeWidgetTrId" );
      ((Element)v.get(489)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(494)).setAttribute("align","left" );
      ((Element)v.get(494)).setAttribute("nowrap","true" );
      ((Element)v.get(493)).appendChild((Element)v.get(494));

      /* Empieza nodo:495 / Elemento padre: 494   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(495)).setAttribute("nombre","fecHoraLibe" );
      ((Element)v.get(495)).setAttribute("id","datosCampos" );
      ((Element)v.get(495)).setAttribute("trim","S" );
      ((Element)v.get(495)).setAttribute("max","7" );
      ((Element)v.get(495)).setAttribute("onchange","" );
      ((Element)v.get(495)).setAttribute("req","N" );
      ((Element)v.get(495)).setAttribute("size","7" );
      ((Element)v.get(495)).setAttribute("valor","" );
      ((Element)v.get(495)).setAttribute("validacion","" );
      ((Element)v.get(495)).setAttribute("onblur","" );
      ((Element)v.get(495)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true)" );
      ((Element)v.get(495)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm', 0, false)" );
      ((Element)v.get(494)).appendChild((Element)v.get(495));
      /* Termina nodo:495   */
      /* Termina nodo:494   */
      /* Termina nodo:493   */

      /* Empieza nodo:496 / Elemento padre: 489   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(496)).setAttribute("nombre","fecHoraLibeViewLabelTrId" );
      ((Element)v.get(489)).appendChild((Element)v.get(496));

      /* Empieza nodo:497 / Elemento padre: 496   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(497)).setAttribute("valign","top" );
      ((Element)v.get(497)).setAttribute("height","13" );
      ((Element)v.get(496)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(498)).setAttribute("nombre","lblViewFecHoraLibe" );
      ((Element)v.get(498)).setAttribute("alto","13" );
      ((Element)v.get(498)).setAttribute("ancho","100" );
      ((Element)v.get(498)).setAttribute("id","EstDat" );
      ((Element)v.get(498)).setAttribute("valor","" );
      ((Element)v.get(497)).appendChild((Element)v.get(498));
      /* Termina nodo:498   */
      /* Termina nodo:497   */
      /* Termina nodo:496   */
      /* Termina nodo:489   */
      /* Termina nodo:488   */

      /* Empieza nodo:499 / Elemento padre: 487   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(499)).setAttribute("nombre","fecHoraLibeGapTdId" );
      ((Element)v.get(499)).setAttribute("nowrap","true" );
      ((Element)v.get(499)).setAttribute("class","datosCampos" );
      ((Element)v.get(487)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(500)).setAttribute("src","b.gif" );
      ((Element)v.get(500)).setAttribute("width","25" );
      ((Element)v.get(500)).setAttribute("height","8" );
      ((Element)v.get(499)).appendChild((Element)v.get(500));
      /* Termina nodo:500   */
      /* Termina nodo:499   */

      /* Empieza nodo:501 / Elemento padre: 487   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(501)).setAttribute("width","100%" );
      ((Element)v.get(487)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(502)).setAttribute("src","b.gif" );
      ((Element)v.get(501)).appendChild((Element)v.get(502));
      /* Termina nodo:502   */
      /* Termina nodo:501   */
      /* Termina nodo:487   */
      /* Termina nodo:486   */
      /* Termina nodo:485   */
      /* Termina nodo:482   */

      /* Empieza nodo:503 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(503)).setAttribute("nombre","formGapTr13" );
      ((Element)v.get(40)).appendChild((Element)v.get(503));

      /* Empieza nodo:504 / Elemento padre: 503   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(504)).setAttribute("align","center" );
      ((Element)v.get(504)).setAttribute("width","12" );
      ((Element)v.get(503)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(505)).setAttribute("src","b.gif" );
      ((Element)v.get(505)).setAttribute("width","12" );
      ((Element)v.get(505)).setAttribute("height","8" );
      ((Element)v.get(504)).appendChild((Element)v.get(505));
      /* Termina nodo:505   */
      /* Termina nodo:504   */

      /* Empieza nodo:506 / Elemento padre: 503   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(503)).appendChild((Element)v.get(506));

      /* Empieza nodo:507 / Elemento padre: 506   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(507)).setAttribute("src","b.gif" );
      ((Element)v.get(507)).setAttribute("width","8" );
      ((Element)v.get(507)).setAttribute("height","8" );
      ((Element)v.get(506)).appendChild((Element)v.get(507));
      /* Termina nodo:507   */
      /* Termina nodo:506   */

      /* Empieza nodo:508 / Elemento padre: 503   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(508)).setAttribute("align","center" );
      ((Element)v.get(508)).setAttribute("width","12" );
      ((Element)v.get(503)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(509)).setAttribute("src","b.gif" );
      ((Element)v.get(509)).setAttribute("width","12" );
      ((Element)v.get(509)).setAttribute("height","8" );
      ((Element)v.get(508)).appendChild((Element)v.get(509));
      /* Termina nodo:509   */
      /* Termina nodo:508   */
      /* Termina nodo:503   */

      /* Empieza nodo:510 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(510)).setAttribute("nombre","formTr14" );
      ((Element)v.get(40)).appendChild((Element)v.get(510));

      /* Empieza nodo:511 / Elemento padre: 510   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(511)).setAttribute("align","center" );
      ((Element)v.get(511)).setAttribute("width","12" );
      ((Element)v.get(510)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(512)).setAttribute("src","b.gif" );
      ((Element)v.get(512)).setAttribute("width","12" );
      ((Element)v.get(512)).setAttribute("height","12" );
      ((Element)v.get(511)).appendChild((Element)v.get(512));
      /* Termina nodo:512   */
      /* Termina nodo:511   */

      /* Empieza nodo:513 / Elemento padre: 510   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(513)).setAttribute("width","100%" );
      ((Element)v.get(510)).appendChild((Element)v.get(513));

      /* Empieza nodo:514 / Elemento padre: 513   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(514)).setAttribute("width","100%" );
      ((Element)v.get(514)).setAttribute("border","0" );
      ((Element)v.get(514)).setAttribute("cellspacing","0" );
      ((Element)v.get(514)).setAttribute("cellpadding","0" );
      ((Element)v.get(514)).setAttribute("align","left" );
      ((Element)v.get(513)).appendChild((Element)v.get(514));

      /* Empieza nodo:515 / Elemento padre: 514   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(515)).setAttribute("align","left" );
      ((Element)v.get(514)).appendChild((Element)v.get(515));

      /* Empieza nodo:516 / Elemento padre: 515   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(516)).setAttribute("nombre","valObseTdId" );
      ((Element)v.get(515)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(517)).setAttribute("width","100%" );
      ((Element)v.get(517)).setAttribute("border","0" );
      ((Element)v.get(517)).setAttribute("cellspacing","0" );
      ((Element)v.get(517)).setAttribute("cellpadding","0" );
      ((Element)v.get(517)).setAttribute("align","left" );
      ((Element)v.get(516)).appendChild((Element)v.get(517));

      /* Empieza nodo:518 / Elemento padre: 517   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(517)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(519)).setAttribute("valign","top" );
      ((Element)v.get(519)).setAttribute("height","13" );
      ((Element)v.get(518)).appendChild((Element)v.get(519));

      /* Empieza nodo:520 / Elemento padre: 519   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(520)).setAttribute("nombre","lblValObse" );
      ((Element)v.get(520)).setAttribute("alto","13" );
      ((Element)v.get(520)).setAttribute("filas","1" );
      ((Element)v.get(520)).setAttribute("id","datosTitle" );
      ((Element)v.get(520)).setAttribute("cod","CarSoliEntrBloq.valObse.label" );
      ((Element)v.get(519)).appendChild((Element)v.get(520));
      /* Termina nodo:520   */
      /* Termina nodo:519   */
      /* Termina nodo:518   */

      /* Empieza nodo:521 / Elemento padre: 517   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(521)).setAttribute("nombre","valObseWidgetTrId" );
      ((Element)v.get(517)).appendChild((Element)v.get(521));

      /* Empieza nodo:522 / Elemento padre: 521   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(522)).setAttribute("align","left" );
      ((Element)v.get(522)).setAttribute("nowrap","true" );
      ((Element)v.get(521)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(523)).setAttribute("nombre","valObse" );
      ((Element)v.get(523)).setAttribute("id","datosCampos" );
      ((Element)v.get(523)).setAttribute("trim","S" );
      ((Element)v.get(523)).setAttribute("max","100" );
      ((Element)v.get(523)).setAttribute("onchange","" );
      ((Element)v.get(523)).setAttribute("req","N" );
      ((Element)v.get(523)).setAttribute("size","100" );
      ((Element)v.get(523)).setAttribute("valor","" );
      ((Element)v.get(523)).setAttribute("validacion","" );
      ((Element)v.get(523)).setAttribute("onblur","" );
      ((Element)v.get(523)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true)" );
      ((Element)v.get(523)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm', 0, false)" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */
      /* Termina nodo:522   */
      /* Termina nodo:521   */

      /* Empieza nodo:524 / Elemento padre: 517   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(524)).setAttribute("nombre","valObseViewLabelTrId" );
      ((Element)v.get(517)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(525)).setAttribute("valign","top" );
      ((Element)v.get(525)).setAttribute("height","13" );
      ((Element)v.get(524)).appendChild((Element)v.get(525));

      /* Empieza nodo:526 / Elemento padre: 525   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(526)).setAttribute("nombre","lblViewValObse" );
      ((Element)v.get(526)).setAttribute("alto","13" );
      ((Element)v.get(526)).setAttribute("ancho","100" );
      ((Element)v.get(526)).setAttribute("id","EstDat" );
      ((Element)v.get(526)).setAttribute("valor","" );
      ((Element)v.get(525)).appendChild((Element)v.get(526));
      /* Termina nodo:526   */
      /* Termina nodo:525   */
      /* Termina nodo:524   */
      /* Termina nodo:517   */
      /* Termina nodo:516   */

      /* Empieza nodo:527 / Elemento padre: 515   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(527)).setAttribute("nombre","valObseGapTdId" );
      ((Element)v.get(527)).setAttribute("nowrap","true" );
      ((Element)v.get(527)).setAttribute("class","datosCampos" );
      ((Element)v.get(515)).appendChild((Element)v.get(527));

      /* Empieza nodo:528 / Elemento padre: 527   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(528)).setAttribute("src","b.gif" );
      ((Element)v.get(528)).setAttribute("width","25" );
      ((Element)v.get(528)).setAttribute("height","8" );
      ((Element)v.get(527)).appendChild((Element)v.get(528));
      /* Termina nodo:528   */
      /* Termina nodo:527   */

      /* Empieza nodo:529 / Elemento padre: 515   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(529)).setAttribute("width","100%" );
      ((Element)v.get(515)).appendChild((Element)v.get(529));

      /* Empieza nodo:530 / Elemento padre: 529   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(530)).setAttribute("src","b.gif" );
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(529)).appendChild((Element)v.get(530));
      /* Termina nodo:530   */
      /* Termina nodo:529   */
      /* Termina nodo:515   */
      /* Termina nodo:514   */
      /* Termina nodo:513   */
      /* Termina nodo:510   */

      /* Empieza nodo:531 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(531)).setAttribute("nombre","formGapTr14" );
      ((Element)v.get(40)).appendChild((Element)v.get(531));

      /* Empieza nodo:532 / Elemento padre: 531   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(532)).setAttribute("align","center" );
      ((Element)v.get(532)).setAttribute("width","12" );
      ((Element)v.get(531)).appendChild((Element)v.get(532));

      /* Empieza nodo:533 / Elemento padre: 532   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(533)).setAttribute("src","b.gif" );
      ((Element)v.get(533)).setAttribute("width","12" );
      ((Element)v.get(533)).setAttribute("height","8" );
      ((Element)v.get(532)).appendChild((Element)v.get(533));
      /* Termina nodo:533   */
      /* Termina nodo:532   */

      /* Empieza nodo:534 / Elemento padre: 531   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(531)).appendChild((Element)v.get(534));

      /* Empieza nodo:535 / Elemento padre: 534   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(535)).setAttribute("src","b.gif" );
      ((Element)v.get(535)).setAttribute("width","8" );
      ((Element)v.get(535)).setAttribute("height","8" );
      ((Element)v.get(534)).appendChild((Element)v.get(535));
      /* Termina nodo:535   */
      /* Termina nodo:534   */

      /* Empieza nodo:536 / Elemento padre: 531   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(536)).setAttribute("align","center" );
      ((Element)v.get(536)).setAttribute("width","12" );
      ((Element)v.get(531)).appendChild((Element)v.get(536));

      /* Empieza nodo:537 / Elemento padre: 536   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(537)).setAttribute("src","b.gif" );
      ((Element)v.get(537)).setAttribute("width","12" );
      ((Element)v.get(537)).setAttribute("height","8" );
      ((Element)v.get(536)).appendChild((Element)v.get(537));
      /* Termina nodo:537   */
      /* Termina nodo:536   */
      /* Termina nodo:531   */

      /* Empieza nodo:538 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(538)).setAttribute("nombre","formTr15" );
      ((Element)v.get(40)).appendChild((Element)v.get(538));

      /* Empieza nodo:539 / Elemento padre: 538   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(539)).setAttribute("align","center" );
      ((Element)v.get(539)).setAttribute("width","12" );
      ((Element)v.get(538)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(540)).setAttribute("src","b.gif" );
      ((Element)v.get(540)).setAttribute("width","12" );
      ((Element)v.get(540)).setAttribute("height","12" );
      ((Element)v.get(539)).appendChild((Element)v.get(540));
      /* Termina nodo:540   */
      /* Termina nodo:539   */

      /* Empieza nodo:541 / Elemento padre: 538   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(541)).setAttribute("width","100%" );
      ((Element)v.get(538)).appendChild((Element)v.get(541));

      /* Empieza nodo:542 / Elemento padre: 541   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(542)).setAttribute("width","100%" );
      ((Element)v.get(542)).setAttribute("border","0" );
      ((Element)v.get(542)).setAttribute("cellspacing","0" );
      ((Element)v.get(542)).setAttribute("cellpadding","0" );
      ((Element)v.get(542)).setAttribute("align","left" );
      ((Element)v.get(541)).appendChild((Element)v.get(542));

      /* Empieza nodo:543 / Elemento padre: 542   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(543)).setAttribute("align","left" );
      ((Element)v.get(542)).appendChild((Element)v.get(543));

      /* Empieza nodo:544 / Elemento padre: 543   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(544)).setAttribute("nombre","jeraOidJeraTdId" );
      ((Element)v.get(543)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(545)).setAttribute("border","0" );
      ((Element)v.get(545)).setAttribute("cellspacing","0" );
      ((Element)v.get(545)).setAttribute("cellpadding","0" );
      ((Element)v.get(545)).setAttribute("align","left" );
      ((Element)v.get(544)).appendChild((Element)v.get(545));

      /* Empieza nodo:546 / Elemento padre: 545   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(545)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(547)).setAttribute("valign","top" );
      ((Element)v.get(547)).setAttribute("height","13" );
      ((Element)v.get(546)).appendChild((Element)v.get(547));

      /* Empieza nodo:548 / Elemento padre: 547   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(548)).setAttribute("nombre","lbljeraOidJera" );
      ((Element)v.get(548)).setAttribute("id","datosTitle" );
      ((Element)v.get(548)).setAttribute("ancho","100" );
      ((Element)v.get(548)).setAttribute("alto","13" );
      ((Element)v.get(548)).setAttribute("cod","CarSoliEntrBloq.jeraOidJera.label" );
      ((Element)v.get(547)).appendChild((Element)v.get(548));
      /* Termina nodo:548   */
      /* Termina nodo:547   */
      /* Termina nodo:546   */

      /* Empieza nodo:549 / Elemento padre: 545   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(549)).setAttribute("nombre","jeraOidJeraWidgetTrId" );
      ((Element)v.get(545)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(550)).setAttribute("align","left" );
      ((Element)v.get(550)).setAttribute("nowrap","true" );
      ((Element)v.get(549)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(551)).setAttribute("nombre","jeraOidJera" );
      ((Element)v.get(551)).setAttribute("id","datosCampos" );
      ((Element)v.get(551)).setAttribute("multiple","N" );
      ((Element)v.get(551)).setAttribute("req","N" );
      ((Element)v.get(551)).setAttribute("size","1" );
      ((Element)v.get(551)).setAttribute("validacion","" );
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(551)).setAttribute("onchange","" );
      ((Element)v.get(551)).setAttribute("onfocus","" );
      ((Element)v.get(551)).setAttribute("valorinicial","" );
      ((Element)v.get(551)).setAttribute("textoinicial","" );
      ((Element)v.get(551)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true);" );
      ((Element)v.get(551)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
      ((Element)v.get(550)).appendChild((Element)v.get(551));

      /* Empieza nodo:552 / Elemento padre: 551   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(551)).appendChild((Element)v.get(552));
      /* Termina nodo:552   */
      /* Termina nodo:551   */
      /* Termina nodo:550   */
      /* Termina nodo:549   */

      /* Empieza nodo:553 / Elemento padre: 545   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(553)).setAttribute("nombre","jeraOidJeraViewLabelTrId" );
      ((Element)v.get(545)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(554)).setAttribute("valign","top" );
      ((Element)v.get(554)).setAttribute("height","13" );
      ((Element)v.get(554)).setAttribute("width","50" );
      ((Element)v.get(553)).appendChild((Element)v.get(554));

      /* Empieza nodo:555 / Elemento padre: 554   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(555)).setAttribute("nombre","lblViewJeraOidJera" );
      ((Element)v.get(555)).setAttribute("alto","13" );
      ((Element)v.get(555)).setAttribute("filas","1" );
      ((Element)v.get(555)).setAttribute("id","EstDat" );
      ((Element)v.get(555)).setAttribute("valor","" );
      ((Element)v.get(554)).appendChild((Element)v.get(555));
      /* Termina nodo:555   */
      /* Termina nodo:554   */
      /* Termina nodo:553   */
      /* Termina nodo:545   */
      /* Termina nodo:544   */

      /* Empieza nodo:556 / Elemento padre: 543   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(556)).setAttribute("nombre","jeraOidJeraGapTdId" );
      ((Element)v.get(556)).setAttribute("nowrap","true" );
      ((Element)v.get(556)).setAttribute("class","datosCampos" );
      ((Element)v.get(543)).appendChild((Element)v.get(556));

      /* Empieza nodo:557 / Elemento padre: 556   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(557)).setAttribute("src","b.gif" );
      ((Element)v.get(557)).setAttribute("width","25" );
      ((Element)v.get(557)).setAttribute("height","8" );
      ((Element)v.get(556)).appendChild((Element)v.get(557));
      /* Termina nodo:557   */
      /* Termina nodo:556   */

      /* Empieza nodo:558 / Elemento padre: 543   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(558)).setAttribute("width","100%" );
      ((Element)v.get(543)).appendChild((Element)v.get(558));

      /* Empieza nodo:559 / Elemento padre: 558   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(559)).setAttribute("src","b.gif" );
      ((Element)v.get(558)).appendChild((Element)v.get(559));
      /* Termina nodo:559   */
      /* Termina nodo:558   */
      /* Termina nodo:543   */
      /* Termina nodo:542   */
      /* Termina nodo:541   */
      /* Termina nodo:538   */

      /* Empieza nodo:560 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(560)).setAttribute("nombre","formGapTr15" );
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

      /* Empieza nodo:567 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(567)).setAttribute("nombre","formTr16" );
      ((Element)v.get(40)).appendChild((Element)v.get(567));

      /* Empieza nodo:568 / Elemento padre: 567   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(568)).setAttribute("align","center" );
      ((Element)v.get(568)).setAttribute("width","12" );
      ((Element)v.get(567)).appendChild((Element)v.get(568));

      /* Empieza nodo:569 / Elemento padre: 568   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(569)).setAttribute("src","b.gif" );
      ((Element)v.get(569)).setAttribute("width","12" );
      ((Element)v.get(569)).setAttribute("height","12" );
      ((Element)v.get(568)).appendChild((Element)v.get(569));
      /* Termina nodo:569   */
      /* Termina nodo:568   */

      /* Empieza nodo:570 / Elemento padre: 567   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(570)).setAttribute("width","100%" );
      ((Element)v.get(567)).appendChild((Element)v.get(570));

      /* Empieza nodo:571 / Elemento padre: 570   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(571)).setAttribute("width","100%" );
      ((Element)v.get(571)).setAttribute("border","0" );
      ((Element)v.get(571)).setAttribute("cellspacing","0" );
      ((Element)v.get(571)).setAttribute("cellpadding","0" );
      ((Element)v.get(571)).setAttribute("align","left" );
      ((Element)v.get(570)).appendChild((Element)v.get(571));

      /* Empieza nodo:572 / Elemento padre: 571   */
   }

   private void getXML2610(Document doc) {
      v.add(doc.createElement("TR"));
      ((Element)v.get(572)).setAttribute("align","left" );
      ((Element)v.get(571)).appendChild((Element)v.get(572));

      /* Empieza nodo:573 / Elemento padre: 572   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(573)).setAttribute("nombre","espeOidEstaPediTdId" );
      ((Element)v.get(572)).appendChild((Element)v.get(573));

      /* Empieza nodo:574 / Elemento padre: 573   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(574)).setAttribute("border","0" );
      ((Element)v.get(574)).setAttribute("cellspacing","0" );
      ((Element)v.get(574)).setAttribute("cellpadding","0" );
      ((Element)v.get(574)).setAttribute("align","left" );
      ((Element)v.get(573)).appendChild((Element)v.get(574));

      /* Empieza nodo:575 / Elemento padre: 574   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(574)).appendChild((Element)v.get(575));

      /* Empieza nodo:576 / Elemento padre: 575   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(576)).setAttribute("valign","top" );
      ((Element)v.get(576)).setAttribute("height","13" );
      ((Element)v.get(575)).appendChild((Element)v.get(576));

      /* Empieza nodo:577 / Elemento padre: 576   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(577)).setAttribute("nombre","lblespeOidEstaPedi" );
      ((Element)v.get(577)).setAttribute("id","datosTitle" );
      ((Element)v.get(577)).setAttribute("ancho","100" );
      ((Element)v.get(577)).setAttribute("alto","13" );
      ((Element)v.get(577)).setAttribute("cod","CarSoliEntrBloq.espeOidEstaPedi.label" );
      ((Element)v.get(576)).appendChild((Element)v.get(577));
      /* Termina nodo:577   */
      /* Termina nodo:576   */
      /* Termina nodo:575   */

      /* Empieza nodo:578 / Elemento padre: 574   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(578)).setAttribute("nombre","espeOidEstaPediWidgetTrId" );
      ((Element)v.get(574)).appendChild((Element)v.get(578));

      /* Empieza nodo:579 / Elemento padre: 578   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(579)).setAttribute("align","left" );
      ((Element)v.get(579)).setAttribute("nowrap","true" );
      ((Element)v.get(578)).appendChild((Element)v.get(579));

      /* Empieza nodo:580 / Elemento padre: 579   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(580)).setAttribute("nombre","espeOidEstaPedi" );
      ((Element)v.get(580)).setAttribute("id","datosCampos" );
      ((Element)v.get(580)).setAttribute("multiple","N" );
      ((Element)v.get(580)).setAttribute("req","N" );
      ((Element)v.get(580)).setAttribute("size","1" );
      ((Element)v.get(580)).setAttribute("validacion","" );
      ((Element)v.get(580)).setAttribute("onchange","" );
      ((Element)v.get(580)).setAttribute("onfocus","" );
      ((Element)v.get(580)).setAttribute("valorinicial","" );
      ((Element)v.get(580)).setAttribute("textoinicial","" );
      ((Element)v.get(580)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true);" );
      ((Element)v.get(580)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
      ((Element)v.get(579)).appendChild((Element)v.get(580));

      /* Empieza nodo:581 / Elemento padre: 580   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(580)).appendChild((Element)v.get(581));
      /* Termina nodo:581   */
      /* Termina nodo:580   */
      /* Termina nodo:579   */
      /* Termina nodo:578   */

      /* Empieza nodo:582 / Elemento padre: 574   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(582)).setAttribute("nombre","espeOidEstaPediViewLabelTrId" );
      ((Element)v.get(574)).appendChild((Element)v.get(582));

      /* Empieza nodo:583 / Elemento padre: 582   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(583)).setAttribute("valign","top" );
      ((Element)v.get(583)).setAttribute("height","13" );
      ((Element)v.get(583)).setAttribute("width","40" );
      ((Element)v.get(582)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(584)).setAttribute("nombre","lblViewEspeOidEstaPedi" );
      ((Element)v.get(584)).setAttribute("alto","13" );
      ((Element)v.get(584)).setAttribute("filas","1" );
      ((Element)v.get(584)).setAttribute("id","EstDat" );
      ((Element)v.get(584)).setAttribute("valor","" );
      ((Element)v.get(583)).appendChild((Element)v.get(584));
      /* Termina nodo:584   */
      /* Termina nodo:583   */
      /* Termina nodo:582   */
      /* Termina nodo:574   */
      /* Termina nodo:573   */

      /* Empieza nodo:585 / Elemento padre: 572   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(585)).setAttribute("nombre","espeOidEstaPediGapTdId" );
      ((Element)v.get(585)).setAttribute("nowrap","true" );
      ((Element)v.get(585)).setAttribute("class","datosCampos" );
      ((Element)v.get(572)).appendChild((Element)v.get(585));

      /* Empieza nodo:586 / Elemento padre: 585   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(586)).setAttribute("src","b.gif" );
      ((Element)v.get(586)).setAttribute("width","25" );
      ((Element)v.get(586)).setAttribute("height","8" );
      ((Element)v.get(585)).appendChild((Element)v.get(586));
      /* Termina nodo:586   */
      /* Termina nodo:585   */

      /* Empieza nodo:587 / Elemento padre: 572   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(587)).setAttribute("width","100%" );
      ((Element)v.get(572)).appendChild((Element)v.get(587));

      /* Empieza nodo:588 / Elemento padre: 587   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(588)).setAttribute("src","b.gif" );
      ((Element)v.get(587)).appendChild((Element)v.get(588));
      /* Termina nodo:588   */
      /* Termina nodo:587   */
      /* Termina nodo:572   */
      /* Termina nodo:571   */
      /* Termina nodo:570   */
      /* Termina nodo:567   */

      /* Empieza nodo:589 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(589)).setAttribute("nombre","formGapTr16" );
      ((Element)v.get(40)).appendChild((Element)v.get(589));

      /* Empieza nodo:590 / Elemento padre: 589   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(590)).setAttribute("align","center" );
      ((Element)v.get(590)).setAttribute("width","12" );
      ((Element)v.get(589)).appendChild((Element)v.get(590));

      /* Empieza nodo:591 / Elemento padre: 590   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(591)).setAttribute("src","b.gif" );
      ((Element)v.get(591)).setAttribute("width","12" );
      ((Element)v.get(591)).setAttribute("height","8" );
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(590)).appendChild((Element)v.get(591));
      /* Termina nodo:591   */
      /* Termina nodo:590   */

      /* Empieza nodo:592 / Elemento padre: 589   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(589)).appendChild((Element)v.get(592));

      /* Empieza nodo:593 / Elemento padre: 592   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(593)).setAttribute("src","b.gif" );
      ((Element)v.get(593)).setAttribute("width","8" );
      ((Element)v.get(593)).setAttribute("height","8" );
      ((Element)v.get(592)).appendChild((Element)v.get(593));
      /* Termina nodo:593   */
      /* Termina nodo:592   */

      /* Empieza nodo:594 / Elemento padre: 589   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(594)).setAttribute("align","center" );
      ((Element)v.get(594)).setAttribute("width","12" );
      ((Element)v.get(589)).appendChild((Element)v.get(594));

      /* Empieza nodo:595 / Elemento padre: 594   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(595)).setAttribute("src","b.gif" );
      ((Element)v.get(595)).setAttribute("width","12" );
      ((Element)v.get(595)).setAttribute("height","8" );
      ((Element)v.get(594)).appendChild((Element)v.get(595));
      /* Termina nodo:595   */
      /* Termina nodo:594   */
      /* Termina nodo:589   */

      /* Empieza nodo:596 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(596)).setAttribute("nombre","formTr17" );
      ((Element)v.get(40)).appendChild((Element)v.get(596));

      /* Empieza nodo:597 / Elemento padre: 596   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(597)).setAttribute("align","center" );
      ((Element)v.get(597)).setAttribute("width","12" );
      ((Element)v.get(596)).appendChild((Element)v.get(597));

      /* Empieza nodo:598 / Elemento padre: 597   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(598)).setAttribute("src","b.gif" );
      ((Element)v.get(598)).setAttribute("width","12" );
      ((Element)v.get(598)).setAttribute("height","12" );
      ((Element)v.get(597)).appendChild((Element)v.get(598));
      /* Termina nodo:598   */
      /* Termina nodo:597   */

      /* Empieza nodo:599 / Elemento padre: 596   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(599)).setAttribute("width","100%" );
      ((Element)v.get(596)).appendChild((Element)v.get(599));

      /* Empieza nodo:600 / Elemento padre: 599   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(600)).setAttribute("width","100%" );
      ((Element)v.get(600)).setAttribute("border","0" );
      ((Element)v.get(600)).setAttribute("cellspacing","0" );
      ((Element)v.get(600)).setAttribute("cellpadding","0" );
      ((Element)v.get(600)).setAttribute("align","left" );
      ((Element)v.get(599)).appendChild((Element)v.get(600));

      /* Empieza nodo:601 / Elemento padre: 600   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(601)).setAttribute("align","left" );
      ((Element)v.get(600)).appendChild((Element)v.get(601));

      /* Empieza nodo:602 / Elemento padre: 601   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(602)).setAttribute("nombre","perdOidPeriTdId" );
      ((Element)v.get(601)).appendChild((Element)v.get(602));

      /* Empieza nodo:603 / Elemento padre: 602   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(603)).setAttribute("border","0" );
      ((Element)v.get(603)).setAttribute("cellspacing","0" );
      ((Element)v.get(603)).setAttribute("cellpadding","0" );
      ((Element)v.get(603)).setAttribute("align","left" );
      ((Element)v.get(602)).appendChild((Element)v.get(603));

      /* Empieza nodo:604 / Elemento padre: 603   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(603)).appendChild((Element)v.get(604));

      /* Empieza nodo:605 / Elemento padre: 604   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(605)).setAttribute("valign","top" );
      ((Element)v.get(605)).setAttribute("height","13" );
      ((Element)v.get(604)).appendChild((Element)v.get(605));

      /* Empieza nodo:606 / Elemento padre: 605   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(606)).setAttribute("nombre","lblperdOidPeri" );
      ((Element)v.get(606)).setAttribute("id","datosTitle" );
      ((Element)v.get(606)).setAttribute("ancho","100" );
      ((Element)v.get(606)).setAttribute("alto","13" );
      ((Element)v.get(606)).setAttribute("cod","CarSoliEntrBloq.perdOidPeri.label" );
      ((Element)v.get(605)).appendChild((Element)v.get(606));
      /* Termina nodo:606   */
      /* Termina nodo:605   */
      /* Termina nodo:604   */

      /* Empieza nodo:607 / Elemento padre: 603   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(607)).setAttribute("nombre","perdOidPeriWidgetTrId" );
      ((Element)v.get(603)).appendChild((Element)v.get(607));

      /* Empieza nodo:608 / Elemento padre: 607   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(608)).setAttribute("align","left" );
      ((Element)v.get(608)).setAttribute("nowrap","true" );
      ((Element)v.get(607)).appendChild((Element)v.get(608));

      /* Empieza nodo:609 / Elemento padre: 608   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(609)).setAttribute("nombre","perdOidPeri" );
      ((Element)v.get(609)).setAttribute("id","datosCampos" );
      ((Element)v.get(609)).setAttribute("multiple","N" );
      ((Element)v.get(609)).setAttribute("req","N" );
      ((Element)v.get(609)).setAttribute("size","1" );
      ((Element)v.get(609)).setAttribute("validacion","" );
      ((Element)v.get(609)).setAttribute("onchange","" );
      ((Element)v.get(609)).setAttribute("onfocus","" );
      ((Element)v.get(609)).setAttribute("valorinicial","" );
      ((Element)v.get(609)).setAttribute("textoinicial","" );
      ((Element)v.get(609)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true);" );
      ((Element)v.get(609)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
      ((Element)v.get(608)).appendChild((Element)v.get(609));

      /* Empieza nodo:610 / Elemento padre: 609   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(609)).appendChild((Element)v.get(610));
      /* Termina nodo:610   */
      /* Termina nodo:609   */
      /* Termina nodo:608   */
      /* Termina nodo:607   */

      /* Empieza nodo:611 / Elemento padre: 603   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(611)).setAttribute("nombre","perdOidPeriViewLabelTrId" );
      ((Element)v.get(603)).appendChild((Element)v.get(611));

      /* Empieza nodo:612 / Elemento padre: 611   */
   }

   private void getXML2790(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(612)).setAttribute("valign","top" );
      ((Element)v.get(612)).setAttribute("height","13" );
      ((Element)v.get(612)).setAttribute("width","50" );
      ((Element)v.get(611)).appendChild((Element)v.get(612));

      /* Empieza nodo:613 / Elemento padre: 612   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(613)).setAttribute("nombre","lblViewPerdOidPeri" );
      ((Element)v.get(613)).setAttribute("alto","13" );
      ((Element)v.get(613)).setAttribute("filas","1" );
      ((Element)v.get(613)).setAttribute("id","EstDat" );
      ((Element)v.get(613)).setAttribute("valor","" );
      ((Element)v.get(612)).appendChild((Element)v.get(613));
      /* Termina nodo:613   */
      /* Termina nodo:612   */
      /* Termina nodo:611   */
      /* Termina nodo:603   */
      /* Termina nodo:602   */

      /* Empieza nodo:614 / Elemento padre: 601   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(614)).setAttribute("nombre","perdOidPeriGapTdId" );
      ((Element)v.get(614)).setAttribute("nowrap","true" );
      ((Element)v.get(614)).setAttribute("class","datosCampos" );
      ((Element)v.get(601)).appendChild((Element)v.get(614));

      /* Empieza nodo:615 / Elemento padre: 614   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(615)).setAttribute("src","b.gif" );
      ((Element)v.get(615)).setAttribute("width","25" );
      ((Element)v.get(615)).setAttribute("height","8" );
      ((Element)v.get(614)).appendChild((Element)v.get(615));
      /* Termina nodo:615   */
      /* Termina nodo:614   */

      /* Empieza nodo:616 / Elemento padre: 601   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(616)).setAttribute("width","100%" );
      ((Element)v.get(601)).appendChild((Element)v.get(616));

      /* Empieza nodo:617 / Elemento padre: 616   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(617)).setAttribute("src","b.gif" );
      ((Element)v.get(616)).appendChild((Element)v.get(617));
      /* Termina nodo:617   */
      /* Termina nodo:616   */
      /* Termina nodo:601   */
      /* Termina nodo:600   */
      /* Termina nodo:599   */
      /* Termina nodo:596   */

      /* Empieza nodo:618 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(618)).setAttribute("nombre","formGapTr17" );
      ((Element)v.get(40)).appendChild((Element)v.get(618));

      /* Empieza nodo:619 / Elemento padre: 618   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(619)).setAttribute("align","center" );
      ((Element)v.get(619)).setAttribute("width","12" );
      ((Element)v.get(618)).appendChild((Element)v.get(619));

      /* Empieza nodo:620 / Elemento padre: 619   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(620)).setAttribute("src","b.gif" );
      ((Element)v.get(620)).setAttribute("width","12" );
      ((Element)v.get(620)).setAttribute("height","8" );
      ((Element)v.get(619)).appendChild((Element)v.get(620));
      /* Termina nodo:620   */
      /* Termina nodo:619   */

      /* Empieza nodo:621 / Elemento padre: 618   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(618)).appendChild((Element)v.get(621));

      /* Empieza nodo:622 / Elemento padre: 621   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(622)).setAttribute("src","b.gif" );
      ((Element)v.get(622)).setAttribute("width","8" );
      ((Element)v.get(622)).setAttribute("height","8" );
      ((Element)v.get(621)).appendChild((Element)v.get(622));
      /* Termina nodo:622   */
      /* Termina nodo:621   */

      /* Empieza nodo:623 / Elemento padre: 618   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(623)).setAttribute("align","center" );
      ((Element)v.get(623)).setAttribute("width","12" );
      ((Element)v.get(618)).appendChild((Element)v.get(623));

      /* Empieza nodo:624 / Elemento padre: 623   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(624)).setAttribute("src","b.gif" );
      ((Element)v.get(624)).setAttribute("width","12" );
      ((Element)v.get(624)).setAttribute("height","8" );
      ((Element)v.get(623)).appendChild((Element)v.get(624));
      /* Termina nodo:624   */
      /* Termina nodo:623   */
      /* Termina nodo:618   */

      /* Empieza nodo:625 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(625)).setAttribute("nombre","formTr18" );
      ((Element)v.get(40)).appendChild((Element)v.get(625));

      /* Empieza nodo:626 / Elemento padre: 625   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(626)).setAttribute("align","center" );
      ((Element)v.get(626)).setAttribute("width","12" );
      ((Element)v.get(625)).appendChild((Element)v.get(626));

      /* Empieza nodo:627 / Elemento padre: 626   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(627)).setAttribute("src","b.gif" );
      ((Element)v.get(627)).setAttribute("width","12" );
      ((Element)v.get(627)).setAttribute("height","12" );
      ((Element)v.get(626)).appendChild((Element)v.get(627));
      /* Termina nodo:627   */
      /* Termina nodo:626   */

      /* Empieza nodo:628 / Elemento padre: 625   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(628)).setAttribute("width","100%" );
      ((Element)v.get(625)).appendChild((Element)v.get(628));

      /* Empieza nodo:629 / Elemento padre: 628   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(629)).setAttribute("width","100%" );
      ((Element)v.get(629)).setAttribute("border","0" );
      ((Element)v.get(629)).setAttribute("cellspacing","0" );
      ((Element)v.get(629)).setAttribute("cellpadding","0" );
      ((Element)v.get(629)).setAttribute("align","left" );
      ((Element)v.get(628)).appendChild((Element)v.get(629));

      /* Empieza nodo:630 / Elemento padre: 629   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(630)).setAttribute("align","left" );
      ((Element)v.get(629)).appendChild((Element)v.get(630));

      /* Empieza nodo:631 / Elemento padre: 630   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(631)).setAttribute("nombre","clieOidClieTdId" );
      ((Element)v.get(630)).appendChild((Element)v.get(631));

      /* Empieza nodo:632 / Elemento padre: 631   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(632)).setAttribute("border","0" );
      ((Element)v.get(632)).setAttribute("cellspacing","0" );
      ((Element)v.get(632)).setAttribute("cellpadding","0" );
      ((Element)v.get(632)).setAttribute("align","left" );
      ((Element)v.get(631)).appendChild((Element)v.get(632));

      /* Empieza nodo:633 / Elemento padre: 632   */
   }

   private void getXML2880(Document doc) {
      v.add(doc.createElement("TR"));
      ((Element)v.get(632)).appendChild((Element)v.get(633));

      /* Empieza nodo:634 / Elemento padre: 633   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(634)).setAttribute("valign","top" );
      ((Element)v.get(634)).setAttribute("height","13" );
      ((Element)v.get(633)).appendChild((Element)v.get(634));

      /* Empieza nodo:635 / Elemento padre: 634   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(635)).setAttribute("nombre","lblclieOidClie" );
      ((Element)v.get(635)).setAttribute("id","datosTitle" );
      ((Element)v.get(635)).setAttribute("ancho","100" );
      ((Element)v.get(635)).setAttribute("alto","13" );
      ((Element)v.get(635)).setAttribute("cod","CarSoliEntrBloq.clieOidClie.label" );
      ((Element)v.get(634)).appendChild((Element)v.get(635));
      /* Termina nodo:635   */
      /* Termina nodo:634   */
      /* Termina nodo:633   */

      /* Empieza nodo:636 / Elemento padre: 632   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(636)).setAttribute("nombre","clieOidClieWidgetTrId" );
      ((Element)v.get(632)).appendChild((Element)v.get(636));

      /* Empieza nodo:637 / Elemento padre: 636   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(637)).setAttribute("align","left" );
      ((Element)v.get(637)).setAttribute("nowrap","true" );
      ((Element)v.get(636)).appendChild((Element)v.get(637));

      /* Empieza nodo:638 / Elemento padre: 637   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(638)).setAttribute("nombre","clieOidClie" );
      ((Element)v.get(638)).setAttribute("id","datosCampos" );
      ((Element)v.get(638)).setAttribute("multiple","N" );
      ((Element)v.get(638)).setAttribute("req","N" );
      ((Element)v.get(638)).setAttribute("size","1" );
      ((Element)v.get(638)).setAttribute("validacion","" );
      ((Element)v.get(638)).setAttribute("onchange","" );
      ((Element)v.get(638)).setAttribute("onfocus","" );
      ((Element)v.get(638)).setAttribute("valorinicial","" );
      ((Element)v.get(638)).setAttribute("textoinicial","" );
      ((Element)v.get(638)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true);" );
      ((Element)v.get(638)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
      ((Element)v.get(637)).appendChild((Element)v.get(638));

      /* Empieza nodo:639 / Elemento padre: 638   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(638)).appendChild((Element)v.get(639));
      /* Termina nodo:639   */
      /* Termina nodo:638   */
      /* Termina nodo:637   */
      /* Termina nodo:636   */

      /* Empieza nodo:640 / Elemento padre: 632   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(640)).setAttribute("nombre","clieOidClieViewLabelTrId" );
      ((Element)v.get(632)).appendChild((Element)v.get(640));

      /* Empieza nodo:641 / Elemento padre: 640   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(641)).setAttribute("valign","top" );
      ((Element)v.get(641)).setAttribute("height","13" );
      ((Element)v.get(641)).setAttribute("width","15" );
      ((Element)v.get(640)).appendChild((Element)v.get(641));

      /* Empieza nodo:642 / Elemento padre: 641   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(642)).setAttribute("nombre","lblViewClieOidClie" );
      ((Element)v.get(642)).setAttribute("alto","13" );
      ((Element)v.get(642)).setAttribute("filas","1" );
      ((Element)v.get(642)).setAttribute("id","EstDat" );
      ((Element)v.get(642)).setAttribute("valor","" );
      ((Element)v.get(641)).appendChild((Element)v.get(642));
      /* Termina nodo:642   */
      /* Termina nodo:641   */
      /* Termina nodo:640   */
      /* Termina nodo:632   */
      /* Termina nodo:631   */

      /* Empieza nodo:643 / Elemento padre: 630   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(643)).setAttribute("nombre","clieOidClieGapTdId" );
      ((Element)v.get(643)).setAttribute("nowrap","true" );
      ((Element)v.get(643)).setAttribute("class","datosCampos" );
      ((Element)v.get(630)).appendChild((Element)v.get(643));

      /* Empieza nodo:644 / Elemento padre: 643   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(644)).setAttribute("src","b.gif" );
      ((Element)v.get(644)).setAttribute("width","25" );
      ((Element)v.get(644)).setAttribute("height","8" );
      ((Element)v.get(643)).appendChild((Element)v.get(644));
      /* Termina nodo:644   */
      /* Termina nodo:643   */

      /* Empieza nodo:645 / Elemento padre: 630   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(645)).setAttribute("width","100%" );
      ((Element)v.get(630)).appendChild((Element)v.get(645));

      /* Empieza nodo:646 / Elemento padre: 645   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(646)).setAttribute("src","b.gif" );
      ((Element)v.get(645)).appendChild((Element)v.get(646));
      /* Termina nodo:646   */
      /* Termina nodo:645   */
      /* Termina nodo:630   */
      /* Termina nodo:629   */
      /* Termina nodo:628   */
      /* Termina nodo:625   */

      /* Empieza nodo:647 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(647)).setAttribute("nombre","formGapTr18" );
      ((Element)v.get(40)).appendChild((Element)v.get(647));

      /* Empieza nodo:648 / Elemento padre: 647   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(648)).setAttribute("align","center" );
      ((Element)v.get(648)).setAttribute("width","12" );
      ((Element)v.get(647)).appendChild((Element)v.get(648));

      /* Empieza nodo:649 / Elemento padre: 648   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(649)).setAttribute("src","b.gif" );
      ((Element)v.get(649)).setAttribute("width","12" );
      ((Element)v.get(649)).setAttribute("height","8" );
      ((Element)v.get(648)).appendChild((Element)v.get(649));
      /* Termina nodo:649   */
      /* Termina nodo:648   */

      /* Empieza nodo:650 / Elemento padre: 647   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(647)).appendChild((Element)v.get(650));

      /* Empieza nodo:651 / Elemento padre: 650   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(651)).setAttribute("src","b.gif" );
      ((Element)v.get(651)).setAttribute("width","8" );
      ((Element)v.get(651)).setAttribute("height","8" );
      ((Element)v.get(650)).appendChild((Element)v.get(651));
      /* Termina nodo:651   */
      /* Termina nodo:650   */

      /* Empieza nodo:652 / Elemento padre: 647   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(652)).setAttribute("align","center" );
      ((Element)v.get(652)).setAttribute("width","12" );
      ((Element)v.get(647)).appendChild((Element)v.get(652));

      /* Empieza nodo:653 / Elemento padre: 652   */
   }

   private void getXML2970(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(653)).setAttribute("src","b.gif" );
      ((Element)v.get(653)).setAttribute("width","12" );
      ((Element)v.get(653)).setAttribute("height","8" );
      ((Element)v.get(652)).appendChild((Element)v.get(653));
      /* Termina nodo:653   */
      /* Termina nodo:652   */
      /* Termina nodo:647   */

      /* Empieza nodo:654 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(654)).setAttribute("nombre","formTr19" );
      ((Element)v.get(40)).appendChild((Element)v.get(654));

      /* Empieza nodo:655 / Elemento padre: 654   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(655)).setAttribute("align","center" );
      ((Element)v.get(655)).setAttribute("width","12" );
      ((Element)v.get(654)).appendChild((Element)v.get(655));

      /* Empieza nodo:656 / Elemento padre: 655   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(656)).setAttribute("src","b.gif" );
      ((Element)v.get(656)).setAttribute("width","12" );
      ((Element)v.get(656)).setAttribute("height","12" );
      ((Element)v.get(655)).appendChild((Element)v.get(656));
      /* Termina nodo:656   */
      /* Termina nodo:655   */

      /* Empieza nodo:657 / Elemento padre: 654   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(657)).setAttribute("width","100%" );
      ((Element)v.get(654)).appendChild((Element)v.get(657));

      /* Empieza nodo:658 / Elemento padre: 657   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(658)).setAttribute("width","100%" );
      ((Element)v.get(658)).setAttribute("border","0" );
      ((Element)v.get(658)).setAttribute("cellspacing","0" );
      ((Element)v.get(658)).setAttribute("cellpadding","0" );
      ((Element)v.get(658)).setAttribute("align","left" );
      ((Element)v.get(657)).appendChild((Element)v.get(658));

      /* Empieza nodo:659 / Elemento padre: 658   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(659)).setAttribute("align","left" );
      ((Element)v.get(658)).appendChild((Element)v.get(659));

      /* Empieza nodo:660 / Elemento padre: 659   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(660)).setAttribute("nombre","clieOidGereZonaTdId" );
      ((Element)v.get(659)).appendChild((Element)v.get(660));

      /* Empieza nodo:661 / Elemento padre: 660   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(661)).setAttribute("border","0" );
      ((Element)v.get(661)).setAttribute("cellspacing","0" );
      ((Element)v.get(661)).setAttribute("cellpadding","0" );
      ((Element)v.get(661)).setAttribute("align","left" );
      ((Element)v.get(660)).appendChild((Element)v.get(661));

      /* Empieza nodo:662 / Elemento padre: 661   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(661)).appendChild((Element)v.get(662));

      /* Empieza nodo:663 / Elemento padre: 662   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(663)).setAttribute("valign","top" );
      ((Element)v.get(663)).setAttribute("height","13" );
      ((Element)v.get(662)).appendChild((Element)v.get(663));

      /* Empieza nodo:664 / Elemento padre: 663   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(664)).setAttribute("nombre","lblclieOidGereZona" );
      ((Element)v.get(664)).setAttribute("id","datosTitle" );
      ((Element)v.get(664)).setAttribute("ancho","100" );
      ((Element)v.get(664)).setAttribute("alto","13" );
      ((Element)v.get(664)).setAttribute("cod","CarSoliEntrBloq.clieOidGereZona.label" );
      ((Element)v.get(663)).appendChild((Element)v.get(664));
      /* Termina nodo:664   */
      /* Termina nodo:663   */
      /* Termina nodo:662   */

      /* Empieza nodo:665 / Elemento padre: 661   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(665)).setAttribute("nombre","clieOidGereZonaWidgetTrId" );
      ((Element)v.get(661)).appendChild((Element)v.get(665));

      /* Empieza nodo:666 / Elemento padre: 665   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(666)).setAttribute("align","left" );
      ((Element)v.get(666)).setAttribute("nowrap","true" );
      ((Element)v.get(665)).appendChild((Element)v.get(666));

      /* Empieza nodo:667 / Elemento padre: 666   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(667)).setAttribute("nombre","clieOidGereZona" );
      ((Element)v.get(667)).setAttribute("id","datosCampos" );
      ((Element)v.get(667)).setAttribute("multiple","N" );
      ((Element)v.get(667)).setAttribute("req","N" );
      ((Element)v.get(667)).setAttribute("size","1" );
      ((Element)v.get(667)).setAttribute("validacion","" );
      ((Element)v.get(667)).setAttribute("onchange","" );
      ((Element)v.get(667)).setAttribute("onfocus","" );
      ((Element)v.get(667)).setAttribute("valorinicial","" );
      ((Element)v.get(667)).setAttribute("textoinicial","" );
      ((Element)v.get(667)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true);" );
      ((Element)v.get(667)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
      ((Element)v.get(666)).appendChild((Element)v.get(667));

      /* Empieza nodo:668 / Elemento padre: 667   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(667)).appendChild((Element)v.get(668));
      /* Termina nodo:668   */
      /* Termina nodo:667   */
      /* Termina nodo:666   */
      /* Termina nodo:665   */

      /* Empieza nodo:669 / Elemento padre: 661   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(669)).setAttribute("nombre","clieOidGereZonaViewLabelTrId" );
      ((Element)v.get(661)).appendChild((Element)v.get(669));

      /* Empieza nodo:670 / Elemento padre: 669   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(670)).setAttribute("valign","top" );
      ((Element)v.get(670)).setAttribute("height","13" );
      ((Element)v.get(670)).setAttribute("width","15" );
      ((Element)v.get(669)).appendChild((Element)v.get(670));

      /* Empieza nodo:671 / Elemento padre: 670   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(671)).setAttribute("nombre","lblViewClieOidGereZona" );
      ((Element)v.get(671)).setAttribute("alto","13" );
      ((Element)v.get(671)).setAttribute("filas","1" );
      ((Element)v.get(671)).setAttribute("id","EstDat" );
      ((Element)v.get(671)).setAttribute("valor","" );
      ((Element)v.get(670)).appendChild((Element)v.get(671));
      /* Termina nodo:671   */
      /* Termina nodo:670   */
      /* Termina nodo:669   */
      /* Termina nodo:661   */
      /* Termina nodo:660   */

      /* Empieza nodo:672 / Elemento padre: 659   */
   }

   private void getXML3060(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(672)).setAttribute("nombre","clieOidGereZonaGapTdId" );
      ((Element)v.get(672)).setAttribute("nowrap","true" );
      ((Element)v.get(672)).setAttribute("class","datosCampos" );
      ((Element)v.get(659)).appendChild((Element)v.get(672));

      /* Empieza nodo:673 / Elemento padre: 672   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(673)).setAttribute("src","b.gif" );
      ((Element)v.get(673)).setAttribute("width","25" );
      ((Element)v.get(673)).setAttribute("height","8" );
      ((Element)v.get(672)).appendChild((Element)v.get(673));
      /* Termina nodo:673   */
      /* Termina nodo:672   */

      /* Empieza nodo:674 / Elemento padre: 659   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(674)).setAttribute("width","100%" );
      ((Element)v.get(659)).appendChild((Element)v.get(674));

      /* Empieza nodo:675 / Elemento padre: 674   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(675)).setAttribute("src","b.gif" );
      ((Element)v.get(674)).appendChild((Element)v.get(675));
      /* Termina nodo:675   */
      /* Termina nodo:674   */
      /* Termina nodo:659   */
      /* Termina nodo:658   */
      /* Termina nodo:657   */
      /* Termina nodo:654   */

      /* Empieza nodo:676 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(676)).setAttribute("nombre","formGapTr19" );
      ((Element)v.get(40)).appendChild((Element)v.get(676));

      /* Empieza nodo:677 / Elemento padre: 676   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(677)).setAttribute("align","center" );
      ((Element)v.get(677)).setAttribute("width","12" );
      ((Element)v.get(676)).appendChild((Element)v.get(677));

      /* Empieza nodo:678 / Elemento padre: 677   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(678)).setAttribute("src","b.gif" );
      ((Element)v.get(678)).setAttribute("width","12" );
      ((Element)v.get(678)).setAttribute("height","8" );
      ((Element)v.get(677)).appendChild((Element)v.get(678));
      /* Termina nodo:678   */
      /* Termina nodo:677   */

      /* Empieza nodo:679 / Elemento padre: 676   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(676)).appendChild((Element)v.get(679));

      /* Empieza nodo:680 / Elemento padre: 679   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(680)).setAttribute("src","b.gif" );
      ((Element)v.get(680)).setAttribute("width","8" );
      ((Element)v.get(680)).setAttribute("height","8" );
      ((Element)v.get(679)).appendChild((Element)v.get(680));
      /* Termina nodo:680   */
      /* Termina nodo:679   */

      /* Empieza nodo:681 / Elemento padre: 676   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(681)).setAttribute("align","center" );
      ((Element)v.get(681)).setAttribute("width","12" );
      ((Element)v.get(676)).appendChild((Element)v.get(681));

      /* Empieza nodo:682 / Elemento padre: 681   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(682)).setAttribute("src","b.gif" );
      ((Element)v.get(682)).setAttribute("width","12" );
      ((Element)v.get(682)).setAttribute("height","8" );
      ((Element)v.get(681)).appendChild((Element)v.get(682));
      /* Termina nodo:682   */
      /* Termina nodo:681   */
      /* Termina nodo:676   */

      /* Empieza nodo:683 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(683)).setAttribute("nombre","formTr20" );
      ((Element)v.get(40)).appendChild((Element)v.get(683));

      /* Empieza nodo:684 / Elemento padre: 683   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(684)).setAttribute("align","center" );
      ((Element)v.get(684)).setAttribute("width","12" );
      ((Element)v.get(683)).appendChild((Element)v.get(684));

      /* Empieza nodo:685 / Elemento padre: 684   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(685)).setAttribute("src","b.gif" );
      ((Element)v.get(685)).setAttribute("width","12" );
      ((Element)v.get(685)).setAttribute("height","12" );
      ((Element)v.get(684)).appendChild((Element)v.get(685));
      /* Termina nodo:685   */
      /* Termina nodo:684   */

      /* Empieza nodo:686 / Elemento padre: 683   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(686)).setAttribute("width","100%" );
      ((Element)v.get(683)).appendChild((Element)v.get(686));

      /* Empieza nodo:687 / Elemento padre: 686   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(687)).setAttribute("width","100%" );
      ((Element)v.get(687)).setAttribute("border","0" );
      ((Element)v.get(687)).setAttribute("cellspacing","0" );
      ((Element)v.get(687)).setAttribute("cellpadding","0" );
      ((Element)v.get(687)).setAttribute("align","left" );
      ((Element)v.get(686)).appendChild((Element)v.get(687));

      /* Empieza nodo:688 / Elemento padre: 687   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(688)).setAttribute("align","left" );
      ((Element)v.get(687)).appendChild((Element)v.get(688));

      /* Empieza nodo:689 / Elemento padre: 688   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(689)).setAttribute("nombre","cuadOidClieUnidAdmiTdId" );
      ((Element)v.get(688)).appendChild((Element)v.get(689));

      /* Empieza nodo:690 / Elemento padre: 689   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(690)).setAttribute("border","0" );
      ((Element)v.get(690)).setAttribute("cellspacing","0" );
      ((Element)v.get(690)).setAttribute("cellpadding","0" );
      ((Element)v.get(690)).setAttribute("align","left" );
      ((Element)v.get(689)).appendChild((Element)v.get(690));

      /* Empieza nodo:691 / Elemento padre: 690   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(690)).appendChild((Element)v.get(691));

      /* Empieza nodo:692 / Elemento padre: 691   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(692)).setAttribute("valign","top" );
      ((Element)v.get(692)).setAttribute("height","13" );
      ((Element)v.get(691)).appendChild((Element)v.get(692));

      /* Empieza nodo:693 / Elemento padre: 692   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(693)).setAttribute("nombre","lblcuadOidClieUnidAdmi" );
      ((Element)v.get(693)).setAttribute("id","datosTitle" );
      ((Element)v.get(693)).setAttribute("ancho","100" );
      ((Element)v.get(693)).setAttribute("alto","13" );
      ((Element)v.get(693)).setAttribute("cod","CarSoliEntrBloq.cuadOidClieUnidAdmi.label" );
   }

   private void getXML3150(Document doc) {
      ((Element)v.get(692)).appendChild((Element)v.get(693));
      /* Termina nodo:693   */
      /* Termina nodo:692   */
      /* Termina nodo:691   */

      /* Empieza nodo:694 / Elemento padre: 690   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(694)).setAttribute("nombre","cuadOidClieUnidAdmiWidgetTrId" );
      ((Element)v.get(690)).appendChild((Element)v.get(694));

      /* Empieza nodo:695 / Elemento padre: 694   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(695)).setAttribute("align","left" );
      ((Element)v.get(695)).setAttribute("nowrap","true" );
      ((Element)v.get(694)).appendChild((Element)v.get(695));

      /* Empieza nodo:696 / Elemento padre: 695   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(696)).setAttribute("nombre","cuadOidClieUnidAdmi" );
      ((Element)v.get(696)).setAttribute("id","datosCampos" );
      ((Element)v.get(696)).setAttribute("multiple","N" );
      ((Element)v.get(696)).setAttribute("req","N" );
      ((Element)v.get(696)).setAttribute("size","1" );
      ((Element)v.get(696)).setAttribute("validacion","" );
      ((Element)v.get(696)).setAttribute("onchange","" );
      ((Element)v.get(696)).setAttribute("onfocus","" );
      ((Element)v.get(696)).setAttribute("valorinicial","" );
      ((Element)v.get(696)).setAttribute("textoinicial","" );
      ((Element)v.get(696)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true);" );
      ((Element)v.get(696)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
      ((Element)v.get(695)).appendChild((Element)v.get(696));

      /* Empieza nodo:697 / Elemento padre: 696   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(696)).appendChild((Element)v.get(697));
      /* Termina nodo:697   */
      /* Termina nodo:696   */
      /* Termina nodo:695   */
      /* Termina nodo:694   */

      /* Empieza nodo:698 / Elemento padre: 690   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(698)).setAttribute("nombre","cuadOidClieUnidAdmiViewLabelTrId" );
      ((Element)v.get(690)).appendChild((Element)v.get(698));

      /* Empieza nodo:699 / Elemento padre: 698   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(699)).setAttribute("valign","top" );
      ((Element)v.get(699)).setAttribute("height","13" );
      ((Element)v.get(699)).setAttribute("width","50" );
      ((Element)v.get(698)).appendChild((Element)v.get(699));

      /* Empieza nodo:700 / Elemento padre: 699   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(700)).setAttribute("nombre","lblViewCuadOidClieUnidAdmi" );
      ((Element)v.get(700)).setAttribute("alto","13" );
      ((Element)v.get(700)).setAttribute("filas","1" );
      ((Element)v.get(700)).setAttribute("id","EstDat" );
      ((Element)v.get(700)).setAttribute("valor","" );
      ((Element)v.get(699)).appendChild((Element)v.get(700));
      /* Termina nodo:700   */
      /* Termina nodo:699   */
      /* Termina nodo:698   */
      /* Termina nodo:690   */
      /* Termina nodo:689   */

      /* Empieza nodo:701 / Elemento padre: 688   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(701)).setAttribute("nombre","cuadOidClieUnidAdmiGapTdId" );
      ((Element)v.get(701)).setAttribute("nowrap","true" );
      ((Element)v.get(701)).setAttribute("class","datosCampos" );
      ((Element)v.get(688)).appendChild((Element)v.get(701));

      /* Empieza nodo:702 / Elemento padre: 701   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(702)).setAttribute("src","b.gif" );
      ((Element)v.get(702)).setAttribute("width","25" );
      ((Element)v.get(702)).setAttribute("height","8" );
      ((Element)v.get(701)).appendChild((Element)v.get(702));
      /* Termina nodo:702   */
      /* Termina nodo:701   */

      /* Empieza nodo:703 / Elemento padre: 688   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(703)).setAttribute("width","100%" );
      ((Element)v.get(688)).appendChild((Element)v.get(703));

      /* Empieza nodo:704 / Elemento padre: 703   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(704)).setAttribute("src","b.gif" );
      ((Element)v.get(703)).appendChild((Element)v.get(704));
      /* Termina nodo:704   */
      /* Termina nodo:703   */
      /* Termina nodo:688   */
      /* Termina nodo:687   */
      /* Termina nodo:686   */
      /* Termina nodo:683   */

      /* Empieza nodo:705 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(705)).setAttribute("nombre","formGapTr20" );
      ((Element)v.get(40)).appendChild((Element)v.get(705));

      /* Empieza nodo:706 / Elemento padre: 705   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(706)).setAttribute("align","center" );
      ((Element)v.get(706)).setAttribute("width","12" );
      ((Element)v.get(705)).appendChild((Element)v.get(706));

      /* Empieza nodo:707 / Elemento padre: 706   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(707)).setAttribute("src","b.gif" );
      ((Element)v.get(707)).setAttribute("width","12" );
      ((Element)v.get(707)).setAttribute("height","8" );
      ((Element)v.get(706)).appendChild((Element)v.get(707));
      /* Termina nodo:707   */
      /* Termina nodo:706   */

      /* Empieza nodo:708 / Elemento padre: 705   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(705)).appendChild((Element)v.get(708));

      /* Empieza nodo:709 / Elemento padre: 708   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(709)).setAttribute("src","b.gif" );
      ((Element)v.get(709)).setAttribute("width","8" );
      ((Element)v.get(709)).setAttribute("height","8" );
      ((Element)v.get(708)).appendChild((Element)v.get(709));
      /* Termina nodo:709   */
      /* Termina nodo:708   */

      /* Empieza nodo:710 / Elemento padre: 705   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(710)).setAttribute("align","center" );
      ((Element)v.get(710)).setAttribute("width","12" );
      ((Element)v.get(705)).appendChild((Element)v.get(710));

      /* Empieza nodo:711 / Elemento padre: 710   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(711)).setAttribute("src","b.gif" );
      ((Element)v.get(711)).setAttribute("width","12" );
      ((Element)v.get(711)).setAttribute("height","8" );
      ((Element)v.get(710)).appendChild((Element)v.get(711));
      /* Termina nodo:711   */
      /* Termina nodo:710   */
      /* Termina nodo:705   */

      /* Empieza nodo:712 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(712)).setAttribute("nombre","formTr21" );
      ((Element)v.get(40)).appendChild((Element)v.get(712));

      /* Empieza nodo:713 / Elemento padre: 712   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(713)).setAttribute("align","center" );
      ((Element)v.get(713)).setAttribute("width","12" );
      ((Element)v.get(712)).appendChild((Element)v.get(713));

      /* Empieza nodo:714 / Elemento padre: 713   */
   }

   private void getXML3240(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(714)).setAttribute("src","b.gif" );
      ((Element)v.get(714)).setAttribute("width","12" );
      ((Element)v.get(714)).setAttribute("height","12" );
      ((Element)v.get(713)).appendChild((Element)v.get(714));
      /* Termina nodo:714   */
      /* Termina nodo:713   */

      /* Empieza nodo:715 / Elemento padre: 712   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(715)).setAttribute("width","100%" );
      ((Element)v.get(712)).appendChild((Element)v.get(715));

      /* Empieza nodo:716 / Elemento padre: 715   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(716)).setAttribute("width","100%" );
      ((Element)v.get(716)).setAttribute("border","0" );
      ((Element)v.get(716)).setAttribute("cellspacing","0" );
      ((Element)v.get(716)).setAttribute("cellpadding","0" );
      ((Element)v.get(716)).setAttribute("align","left" );
      ((Element)v.get(715)).appendChild((Element)v.get(716));

      /* Empieza nodo:717 / Elemento padre: 716   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(717)).setAttribute("align","left" );
      ((Element)v.get(716)).appendChild((Element)v.get(717));

      /* Empieza nodo:718 / Elemento padre: 717   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(718)).setAttribute("nombre","coapOidCodiAproTdId" );
      ((Element)v.get(717)).appendChild((Element)v.get(718));

      /* Empieza nodo:719 / Elemento padre: 718   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(719)).setAttribute("border","0" );
      ((Element)v.get(719)).setAttribute("cellspacing","0" );
      ((Element)v.get(719)).setAttribute("cellpadding","0" );
      ((Element)v.get(719)).setAttribute("align","left" );
      ((Element)v.get(718)).appendChild((Element)v.get(719));

      /* Empieza nodo:720 / Elemento padre: 719   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(719)).appendChild((Element)v.get(720));

      /* Empieza nodo:721 / Elemento padre: 720   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(721)).setAttribute("valign","top" );
      ((Element)v.get(721)).setAttribute("height","13" );
      ((Element)v.get(720)).appendChild((Element)v.get(721));

      /* Empieza nodo:722 / Elemento padre: 721   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(722)).setAttribute("nombre","lblcoapOidCodiApro" );
      ((Element)v.get(722)).setAttribute("id","datosTitle" );
      ((Element)v.get(722)).setAttribute("ancho","100" );
      ((Element)v.get(722)).setAttribute("alto","13" );
      ((Element)v.get(722)).setAttribute("cod","CarSoliEntrBloq.coapOidCodiApro.label" );
      ((Element)v.get(721)).appendChild((Element)v.get(722));
      /* Termina nodo:722   */
      /* Termina nodo:721   */
      /* Termina nodo:720   */

      /* Empieza nodo:723 / Elemento padre: 719   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(723)).setAttribute("nombre","coapOidCodiAproWidgetTrId" );
      ((Element)v.get(719)).appendChild((Element)v.get(723));

      /* Empieza nodo:724 / Elemento padre: 723   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(724)).setAttribute("align","left" );
      ((Element)v.get(724)).setAttribute("nowrap","true" );
      ((Element)v.get(723)).appendChild((Element)v.get(724));

      /* Empieza nodo:725 / Elemento padre: 724   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(725)).setAttribute("nombre","coapOidCodiApro" );
      ((Element)v.get(725)).setAttribute("id","datosCampos" );
      ((Element)v.get(725)).setAttribute("multiple","N" );
      ((Element)v.get(725)).setAttribute("req","N" );
      ((Element)v.get(725)).setAttribute("size","1" );
      ((Element)v.get(725)).setAttribute("validacion","" );
      ((Element)v.get(725)).setAttribute("onchange","" );
      ((Element)v.get(725)).setAttribute("onfocus","" );
      ((Element)v.get(725)).setAttribute("valorinicial","" );
      ((Element)v.get(725)).setAttribute("textoinicial","" );
      ((Element)v.get(725)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true);" );
      ((Element)v.get(725)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
      ((Element)v.get(724)).appendChild((Element)v.get(725));

      /* Empieza nodo:726 / Elemento padre: 725   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(725)).appendChild((Element)v.get(726));
      /* Termina nodo:726   */
      /* Termina nodo:725   */
      /* Termina nodo:724   */
      /* Termina nodo:723   */

      /* Empieza nodo:727 / Elemento padre: 719   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(727)).setAttribute("nombre","coapOidCodiAproViewLabelTrId" );
      ((Element)v.get(719)).appendChild((Element)v.get(727));

      /* Empieza nodo:728 / Elemento padre: 727   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(728)).setAttribute("valign","top" );
      ((Element)v.get(728)).setAttribute("height","13" );
      ((Element)v.get(728)).setAttribute("width","30" );
      ((Element)v.get(727)).appendChild((Element)v.get(728));

      /* Empieza nodo:729 / Elemento padre: 728   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(729)).setAttribute("nombre","lblViewCoapOidCodiApro" );
      ((Element)v.get(729)).setAttribute("alto","13" );
      ((Element)v.get(729)).setAttribute("filas","1" );
      ((Element)v.get(729)).setAttribute("id","EstDat" );
      ((Element)v.get(729)).setAttribute("valor","" );
      ((Element)v.get(728)).appendChild((Element)v.get(729));
      /* Termina nodo:729   */
      /* Termina nodo:728   */
      /* Termina nodo:727   */
      /* Termina nodo:719   */
      /* Termina nodo:718   */

      /* Empieza nodo:730 / Elemento padre: 717   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(730)).setAttribute("nombre","coapOidCodiAproGapTdId" );
      ((Element)v.get(730)).setAttribute("nowrap","true" );
      ((Element)v.get(730)).setAttribute("class","datosCampos" );
      ((Element)v.get(717)).appendChild((Element)v.get(730));

      /* Empieza nodo:731 / Elemento padre: 730   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(731)).setAttribute("src","b.gif" );
      ((Element)v.get(731)).setAttribute("width","25" );
      ((Element)v.get(731)).setAttribute("height","8" );
      ((Element)v.get(730)).appendChild((Element)v.get(731));
      /* Termina nodo:731   */
      /* Termina nodo:730   */

      /* Empieza nodo:732 / Elemento padre: 717   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(732)).setAttribute("width","100%" );
   }

   private void getXML3330(Document doc) {
      ((Element)v.get(717)).appendChild((Element)v.get(732));

      /* Empieza nodo:733 / Elemento padre: 732   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(733)).setAttribute("src","b.gif" );
      ((Element)v.get(732)).appendChild((Element)v.get(733));
      /* Termina nodo:733   */
      /* Termina nodo:732   */
      /* Termina nodo:717   */
      /* Termina nodo:716   */
      /* Termina nodo:715   */
      /* Termina nodo:712   */

      /* Empieza nodo:734 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(734)).setAttribute("nombre","formGapTr21" );
      ((Element)v.get(40)).appendChild((Element)v.get(734));

      /* Empieza nodo:735 / Elemento padre: 734   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(735)).setAttribute("align","center" );
      ((Element)v.get(735)).setAttribute("width","12" );
      ((Element)v.get(734)).appendChild((Element)v.get(735));

      /* Empieza nodo:736 / Elemento padre: 735   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(736)).setAttribute("src","b.gif" );
      ((Element)v.get(736)).setAttribute("width","12" );
      ((Element)v.get(736)).setAttribute("height","8" );
      ((Element)v.get(735)).appendChild((Element)v.get(736));
      /* Termina nodo:736   */
      /* Termina nodo:735   */

      /* Empieza nodo:737 / Elemento padre: 734   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(734)).appendChild((Element)v.get(737));

      /* Empieza nodo:738 / Elemento padre: 737   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(738)).setAttribute("src","b.gif" );
      ((Element)v.get(738)).setAttribute("width","8" );
      ((Element)v.get(738)).setAttribute("height","8" );
      ((Element)v.get(737)).appendChild((Element)v.get(738));
      /* Termina nodo:738   */
      /* Termina nodo:737   */

      /* Empieza nodo:739 / Elemento padre: 734   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(739)).setAttribute("align","center" );
      ((Element)v.get(739)).setAttribute("width","12" );
      ((Element)v.get(734)).appendChild((Element)v.get(739));

      /* Empieza nodo:740 / Elemento padre: 739   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(740)).setAttribute("src","b.gif" );
      ((Element)v.get(740)).setAttribute("width","12" );
      ((Element)v.get(740)).setAttribute("height","8" );
      ((Element)v.get(739)).appendChild((Element)v.get(740));
      /* Termina nodo:740   */
      /* Termina nodo:739   */
      /* Termina nodo:734   */

      /* Empieza nodo:741 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(741)).setAttribute("nombre","formTr22" );
      ((Element)v.get(40)).appendChild((Element)v.get(741));

      /* Empieza nodo:742 / Elemento padre: 741   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(742)).setAttribute("align","center" );
      ((Element)v.get(742)).setAttribute("width","12" );
      ((Element)v.get(741)).appendChild((Element)v.get(742));

      /* Empieza nodo:743 / Elemento padre: 742   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(743)).setAttribute("src","b.gif" );
      ((Element)v.get(743)).setAttribute("width","12" );
      ((Element)v.get(743)).setAttribute("height","12" );
      ((Element)v.get(742)).appendChild((Element)v.get(743));
      /* Termina nodo:743   */
      /* Termina nodo:742   */

      /* Empieza nodo:744 / Elemento padre: 741   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(744)).setAttribute("width","100%" );
      ((Element)v.get(741)).appendChild((Element)v.get(744));

      /* Empieza nodo:745 / Elemento padre: 744   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(745)).setAttribute("width","100%" );
      ((Element)v.get(745)).setAttribute("border","0" );
      ((Element)v.get(745)).setAttribute("cellspacing","0" );
      ((Element)v.get(745)).setAttribute("cellpadding","0" );
      ((Element)v.get(745)).setAttribute("align","left" );
      ((Element)v.get(744)).appendChild((Element)v.get(745));

      /* Empieza nodo:746 / Elemento padre: 745   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(746)).setAttribute("align","left" );
      ((Element)v.get(745)).appendChild((Element)v.get(746));

      /* Empieza nodo:747 / Elemento padre: 746   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(747)).setAttribute("nombre","ejcuOidEjecCuenTdId" );
      ((Element)v.get(746)).appendChild((Element)v.get(747));

      /* Empieza nodo:748 / Elemento padre: 747   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(748)).setAttribute("border","0" );
      ((Element)v.get(748)).setAttribute("cellspacing","0" );
      ((Element)v.get(748)).setAttribute("cellpadding","0" );
      ((Element)v.get(748)).setAttribute("align","left" );
      ((Element)v.get(747)).appendChild((Element)v.get(748));

      /* Empieza nodo:749 / Elemento padre: 748   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(748)).appendChild((Element)v.get(749));

      /* Empieza nodo:750 / Elemento padre: 749   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(750)).setAttribute("valign","top" );
      ((Element)v.get(750)).setAttribute("height","13" );
      ((Element)v.get(749)).appendChild((Element)v.get(750));

      /* Empieza nodo:751 / Elemento padre: 750   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(751)).setAttribute("nombre","lblejcuOidEjecCuen" );
      ((Element)v.get(751)).setAttribute("id","datosTitle" );
      ((Element)v.get(751)).setAttribute("ancho","100" );
      ((Element)v.get(751)).setAttribute("alto","13" );
      ((Element)v.get(751)).setAttribute("cod","CarSoliEntrBloq.ejcuOidEjecCuen.label" );
      ((Element)v.get(750)).appendChild((Element)v.get(751));
      /* Termina nodo:751   */
      /* Termina nodo:750   */
      /* Termina nodo:749   */

      /* Empieza nodo:752 / Elemento padre: 748   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(752)).setAttribute("nombre","ejcuOidEjecCuenWidgetTrId" );
      ((Element)v.get(748)).appendChild((Element)v.get(752));

      /* Empieza nodo:753 / Elemento padre: 752   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(753)).setAttribute("align","left" );
      ((Element)v.get(753)).setAttribute("nowrap","true" );
      ((Element)v.get(752)).appendChild((Element)v.get(753));

      /* Empieza nodo:754 / Elemento padre: 753   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(754)).setAttribute("nombre","ejcuOidEjecCuen" );
      ((Element)v.get(754)).setAttribute("id","datosCampos" );
      ((Element)v.get(754)).setAttribute("multiple","N" );
   }

   private void getXML3420(Document doc) {
      ((Element)v.get(754)).setAttribute("req","N" );
      ((Element)v.get(754)).setAttribute("size","1" );
      ((Element)v.get(754)).setAttribute("validacion","" );
      ((Element)v.get(754)).setAttribute("onchange","" );
      ((Element)v.get(754)).setAttribute("onfocus","" );
      ((Element)v.get(754)).setAttribute("valorinicial","" );
      ((Element)v.get(754)).setAttribute("textoinicial","" );
      ((Element)v.get(754)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true);" );
      ((Element)v.get(754)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
      ((Element)v.get(753)).appendChild((Element)v.get(754));

      /* Empieza nodo:755 / Elemento padre: 754   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(754)).appendChild((Element)v.get(755));
      /* Termina nodo:755   */
      /* Termina nodo:754   */
      /* Termina nodo:753   */
      /* Termina nodo:752   */

      /* Empieza nodo:756 / Elemento padre: 748   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(756)).setAttribute("nombre","ejcuOidEjecCuenViewLabelTrId" );
      ((Element)v.get(748)).appendChild((Element)v.get(756));

      /* Empieza nodo:757 / Elemento padre: 756   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(757)).setAttribute("valign","top" );
      ((Element)v.get(757)).setAttribute("height","13" );
      ((Element)v.get(757)).setAttribute("width","50" );
      ((Element)v.get(756)).appendChild((Element)v.get(757));

      /* Empieza nodo:758 / Elemento padre: 757   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(758)).setAttribute("nombre","lblViewEjcuOidEjecCuen" );
      ((Element)v.get(758)).setAttribute("alto","13" );
      ((Element)v.get(758)).setAttribute("filas","1" );
      ((Element)v.get(758)).setAttribute("id","EstDat" );
      ((Element)v.get(758)).setAttribute("valor","" );
      ((Element)v.get(757)).appendChild((Element)v.get(758));
      /* Termina nodo:758   */
      /* Termina nodo:757   */
      /* Termina nodo:756   */
      /* Termina nodo:748   */
      /* Termina nodo:747   */

      /* Empieza nodo:759 / Elemento padre: 746   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(759)).setAttribute("nombre","ejcuOidEjecCuenGapTdId" );
      ((Element)v.get(759)).setAttribute("nowrap","true" );
      ((Element)v.get(759)).setAttribute("class","datosCampos" );
      ((Element)v.get(746)).appendChild((Element)v.get(759));

      /* Empieza nodo:760 / Elemento padre: 759   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(760)).setAttribute("src","b.gif" );
      ((Element)v.get(760)).setAttribute("width","25" );
      ((Element)v.get(760)).setAttribute("height","8" );
      ((Element)v.get(759)).appendChild((Element)v.get(760));
      /* Termina nodo:760   */
      /* Termina nodo:759   */

      /* Empieza nodo:761 / Elemento padre: 746   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(761)).setAttribute("width","100%" );
      ((Element)v.get(746)).appendChild((Element)v.get(761));

      /* Empieza nodo:762 / Elemento padre: 761   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(762)).setAttribute("src","b.gif" );
      ((Element)v.get(761)).appendChild((Element)v.get(762));
      /* Termina nodo:762   */
      /* Termina nodo:761   */
      /* Termina nodo:746   */
      /* Termina nodo:745   */
      /* Termina nodo:744   */
      /* Termina nodo:741   */

      /* Empieza nodo:763 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(763)).setAttribute("nombre","formGapTr22" );
      ((Element)v.get(40)).appendChild((Element)v.get(763));

      /* Empieza nodo:764 / Elemento padre: 763   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(764)).setAttribute("align","center" );
      ((Element)v.get(764)).setAttribute("width","12" );
      ((Element)v.get(763)).appendChild((Element)v.get(764));

      /* Empieza nodo:765 / Elemento padre: 764   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(765)).setAttribute("src","b.gif" );
      ((Element)v.get(765)).setAttribute("width","12" );
      ((Element)v.get(765)).setAttribute("height","8" );
      ((Element)v.get(764)).appendChild((Element)v.get(765));
      /* Termina nodo:765   */
      /* Termina nodo:764   */

      /* Empieza nodo:766 / Elemento padre: 763   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(763)).appendChild((Element)v.get(766));

      /* Empieza nodo:767 / Elemento padre: 766   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(767)).setAttribute("src","b.gif" );
      ((Element)v.get(767)).setAttribute("width","8" );
      ((Element)v.get(767)).setAttribute("height","8" );
      ((Element)v.get(766)).appendChild((Element)v.get(767));
      /* Termina nodo:767   */
      /* Termina nodo:766   */

      /* Empieza nodo:768 / Elemento padre: 763   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(768)).setAttribute("align","center" );
      ((Element)v.get(768)).setAttribute("width","12" );
      ((Element)v.get(763)).appendChild((Element)v.get(768));

      /* Empieza nodo:769 / Elemento padre: 768   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(769)).setAttribute("src","b.gif" );
      ((Element)v.get(769)).setAttribute("width","12" );
      ((Element)v.get(769)).setAttribute("height","8" );
      ((Element)v.get(768)).appendChild((Element)v.get(769));
      /* Termina nodo:769   */
      /* Termina nodo:768   */
      /* Termina nodo:763   */

      /* Empieza nodo:770 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(770)).setAttribute("nombre","formTr23" );
      ((Element)v.get(40)).appendChild((Element)v.get(770));

      /* Empieza nodo:771 / Elemento padre: 770   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(771)).setAttribute("align","center" );
      ((Element)v.get(771)).setAttribute("width","12" );
      ((Element)v.get(770)).appendChild((Element)v.get(771));

      /* Empieza nodo:772 / Elemento padre: 771   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(772)).setAttribute("src","b.gif" );
      ((Element)v.get(772)).setAttribute("width","12" );
      ((Element)v.get(772)).setAttribute("height","12" );
      ((Element)v.get(771)).appendChild((Element)v.get(772));
      /* Termina nodo:772   */
      /* Termina nodo:771   */

      /* Empieza nodo:773 / Elemento padre: 770   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(773)).setAttribute("width","100%" );
      ((Element)v.get(770)).appendChild((Element)v.get(773));

      /* Empieza nodo:774 / Elemento padre: 773   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(774)).setAttribute("width","100%" );
      ((Element)v.get(774)).setAttribute("border","0" );
      ((Element)v.get(774)).setAttribute("cellspacing","0" );
   }

   private void getXML3510(Document doc) {
      ((Element)v.get(774)).setAttribute("cellpadding","0" );
      ((Element)v.get(774)).setAttribute("align","left" );
      ((Element)v.get(773)).appendChild((Element)v.get(774));

      /* Empieza nodo:775 / Elemento padre: 774   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(775)).setAttribute("align","left" );
      ((Element)v.get(774)).appendChild((Element)v.get(775));

      /* Empieza nodo:776 / Elemento padre: 775   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(776)).setAttribute("nombre","ejcuOidUsuaLibeTdId" );
      ((Element)v.get(775)).appendChild((Element)v.get(776));

      /* Empieza nodo:777 / Elemento padre: 776   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(777)).setAttribute("border","0" );
      ((Element)v.get(777)).setAttribute("cellspacing","0" );
      ((Element)v.get(777)).setAttribute("cellpadding","0" );
      ((Element)v.get(777)).setAttribute("align","left" );
      ((Element)v.get(776)).appendChild((Element)v.get(777));

      /* Empieza nodo:778 / Elemento padre: 777   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(777)).appendChild((Element)v.get(778));

      /* Empieza nodo:779 / Elemento padre: 778   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(779)).setAttribute("valign","top" );
      ((Element)v.get(779)).setAttribute("height","13" );
      ((Element)v.get(778)).appendChild((Element)v.get(779));

      /* Empieza nodo:780 / Elemento padre: 779   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(780)).setAttribute("nombre","lblejcuOidUsuaLibe" );
      ((Element)v.get(780)).setAttribute("id","datosTitle" );
      ((Element)v.get(780)).setAttribute("ancho","100" );
      ((Element)v.get(780)).setAttribute("alto","13" );
      ((Element)v.get(780)).setAttribute("cod","CarSoliEntrBloq.ejcuOidUsuaLibe.label" );
      ((Element)v.get(779)).appendChild((Element)v.get(780));
      /* Termina nodo:780   */
      /* Termina nodo:779   */
      /* Termina nodo:778   */

      /* Empieza nodo:781 / Elemento padre: 777   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(781)).setAttribute("nombre","ejcuOidUsuaLibeWidgetTrId" );
      ((Element)v.get(777)).appendChild((Element)v.get(781));

      /* Empieza nodo:782 / Elemento padre: 781   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(782)).setAttribute("align","left" );
      ((Element)v.get(782)).setAttribute("nowrap","true" );
      ((Element)v.get(781)).appendChild((Element)v.get(782));

      /* Empieza nodo:783 / Elemento padre: 782   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(783)).setAttribute("nombre","ejcuOidUsuaLibe" );
      ((Element)v.get(783)).setAttribute("id","datosCampos" );
      ((Element)v.get(783)).setAttribute("multiple","N" );
      ((Element)v.get(783)).setAttribute("req","N" );
      ((Element)v.get(783)).setAttribute("size","1" );
      ((Element)v.get(783)).setAttribute("validacion","" );
      ((Element)v.get(783)).setAttribute("onchange","" );
      ((Element)v.get(783)).setAttribute("onfocus","" );
      ((Element)v.get(783)).setAttribute("valorinicial","" );
      ((Element)v.get(783)).setAttribute("textoinicial","" );
      ((Element)v.get(783)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true);" );
      ((Element)v.get(783)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
      ((Element)v.get(782)).appendChild((Element)v.get(783));

      /* Empieza nodo:784 / Elemento padre: 783   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(783)).appendChild((Element)v.get(784));
      /* Termina nodo:784   */
      /* Termina nodo:783   */
      /* Termina nodo:782   */
      /* Termina nodo:781   */

      /* Empieza nodo:785 / Elemento padre: 777   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(785)).setAttribute("nombre","ejcuOidUsuaLibeViewLabelTrId" );
      ((Element)v.get(777)).appendChild((Element)v.get(785));

      /* Empieza nodo:786 / Elemento padre: 785   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(786)).setAttribute("valign","top" );
      ((Element)v.get(786)).setAttribute("height","13" );
      ((Element)v.get(786)).setAttribute("width","50" );
      ((Element)v.get(785)).appendChild((Element)v.get(786));

      /* Empieza nodo:787 / Elemento padre: 786   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(787)).setAttribute("nombre","lblViewEjcuOidUsuaLibe" );
      ((Element)v.get(787)).setAttribute("alto","13" );
      ((Element)v.get(787)).setAttribute("filas","1" );
      ((Element)v.get(787)).setAttribute("id","EstDat" );
      ((Element)v.get(787)).setAttribute("valor","" );
      ((Element)v.get(786)).appendChild((Element)v.get(787));
      /* Termina nodo:787   */
      /* Termina nodo:786   */
      /* Termina nodo:785   */
      /* Termina nodo:777   */
      /* Termina nodo:776   */

      /* Empieza nodo:788 / Elemento padre: 775   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(788)).setAttribute("nombre","ejcuOidUsuaLibeGapTdId" );
      ((Element)v.get(788)).setAttribute("nowrap","true" );
      ((Element)v.get(788)).setAttribute("class","datosCampos" );
      ((Element)v.get(775)).appendChild((Element)v.get(788));

      /* Empieza nodo:789 / Elemento padre: 788   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(789)).setAttribute("src","b.gif" );
      ((Element)v.get(789)).setAttribute("width","25" );
      ((Element)v.get(789)).setAttribute("height","8" );
      ((Element)v.get(788)).appendChild((Element)v.get(789));
      /* Termina nodo:789   */
      /* Termina nodo:788   */

      /* Empieza nodo:790 / Elemento padre: 775   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(790)).setAttribute("width","100%" );
      ((Element)v.get(775)).appendChild((Element)v.get(790));

      /* Empieza nodo:791 / Elemento padre: 790   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(791)).setAttribute("src","b.gif" );
      ((Element)v.get(790)).appendChild((Element)v.get(791));
      /* Termina nodo:791   */
      /* Termina nodo:790   */
      /* Termina nodo:775   */
      /* Termina nodo:774   */
      /* Termina nodo:773   */
      /* Termina nodo:770   */

      /* Empieza nodo:792 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(792)).setAttribute("nombre","formGapTr23" );
      ((Element)v.get(40)).appendChild((Element)v.get(792));

      /* Empieza nodo:793 / Elemento padre: 792   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(793)).setAttribute("align","center" );
      ((Element)v.get(793)).setAttribute("width","12" );
      ((Element)v.get(792)).appendChild((Element)v.get(793));

      /* Empieza nodo:794 / Elemento padre: 793   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML3600(Document doc) {
      ((Element)v.get(794)).setAttribute("src","b.gif" );
      ((Element)v.get(794)).setAttribute("width","12" );
      ((Element)v.get(794)).setAttribute("height","8" );
      ((Element)v.get(793)).appendChild((Element)v.get(794));
      /* Termina nodo:794   */
      /* Termina nodo:793   */

      /* Empieza nodo:795 / Elemento padre: 792   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(792)).appendChild((Element)v.get(795));

      /* Empieza nodo:796 / Elemento padre: 795   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(796)).setAttribute("src","b.gif" );
      ((Element)v.get(796)).setAttribute("width","8" );
      ((Element)v.get(796)).setAttribute("height","8" );
      ((Element)v.get(795)).appendChild((Element)v.get(796));
      /* Termina nodo:796   */
      /* Termina nodo:795   */

      /* Empieza nodo:797 / Elemento padre: 792   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(797)).setAttribute("align","center" );
      ((Element)v.get(797)).setAttribute("width","12" );
      ((Element)v.get(792)).appendChild((Element)v.get(797));

      /* Empieza nodo:798 / Elemento padre: 797   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(798)).setAttribute("src","b.gif" );
      ((Element)v.get(798)).setAttribute("width","12" );
      ((Element)v.get(798)).setAttribute("height","8" );
      ((Element)v.get(797)).appendChild((Element)v.get(798));
      /* Termina nodo:798   */
      /* Termina nodo:797   */
      /* Termina nodo:792   */

      /* Empieza nodo:799 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(799)).setAttribute("nombre","formTr24" );
      ((Element)v.get(40)).appendChild((Element)v.get(799));

      /* Empieza nodo:800 / Elemento padre: 799   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(800)).setAttribute("align","center" );
      ((Element)v.get(800)).setAttribute("width","12" );
      ((Element)v.get(799)).appendChild((Element)v.get(800));

      /* Empieza nodo:801 / Elemento padre: 800   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(801)).setAttribute("src","b.gif" );
      ((Element)v.get(801)).setAttribute("width","12" );
      ((Element)v.get(801)).setAttribute("height","12" );
      ((Element)v.get(800)).appendChild((Element)v.get(801));
      /* Termina nodo:801   */
      /* Termina nodo:800   */

      /* Empieza nodo:802 / Elemento padre: 799   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(802)).setAttribute("width","100%" );
      ((Element)v.get(799)).appendChild((Element)v.get(802));

      /* Empieza nodo:803 / Elemento padre: 802   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(803)).setAttribute("width","100%" );
      ((Element)v.get(803)).setAttribute("border","0" );
      ((Element)v.get(803)).setAttribute("cellspacing","0" );
      ((Element)v.get(803)).setAttribute("cellpadding","0" );
      ((Element)v.get(803)).setAttribute("align","left" );
      ((Element)v.get(802)).appendChild((Element)v.get(803));

      /* Empieza nodo:804 / Elemento padre: 803   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(804)).setAttribute("align","left" );
      ((Element)v.get(803)).appendChild((Element)v.get(804));

      /* Empieza nodo:805 / Elemento padre: 804   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(805)).setAttribute("nombre","niriOidNiveRiesTdId" );
      ((Element)v.get(804)).appendChild((Element)v.get(805));

      /* Empieza nodo:806 / Elemento padre: 805   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(806)).setAttribute("border","0" );
      ((Element)v.get(806)).setAttribute("cellspacing","0" );
      ((Element)v.get(806)).setAttribute("cellpadding","0" );
      ((Element)v.get(806)).setAttribute("align","left" );
      ((Element)v.get(805)).appendChild((Element)v.get(806));

      /* Empieza nodo:807 / Elemento padre: 806   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(806)).appendChild((Element)v.get(807));

      /* Empieza nodo:808 / Elemento padre: 807   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(808)).setAttribute("valign","top" );
      ((Element)v.get(808)).setAttribute("height","13" );
      ((Element)v.get(807)).appendChild((Element)v.get(808));

      /* Empieza nodo:809 / Elemento padre: 808   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(809)).setAttribute("nombre","lblniriOidNiveRies" );
      ((Element)v.get(809)).setAttribute("id","datosTitle" );
      ((Element)v.get(809)).setAttribute("ancho","100" );
      ((Element)v.get(809)).setAttribute("alto","13" );
      ((Element)v.get(809)).setAttribute("cod","CarSoliEntrBloq.niriOidNiveRies.label" );
      ((Element)v.get(808)).appendChild((Element)v.get(809));
      /* Termina nodo:809   */
      /* Termina nodo:808   */
      /* Termina nodo:807   */

      /* Empieza nodo:810 / Elemento padre: 806   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(810)).setAttribute("nombre","niriOidNiveRiesWidgetTrId" );
      ((Element)v.get(806)).appendChild((Element)v.get(810));

      /* Empieza nodo:811 / Elemento padre: 810   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(811)).setAttribute("align","left" );
      ((Element)v.get(811)).setAttribute("nowrap","true" );
      ((Element)v.get(810)).appendChild((Element)v.get(811));

      /* Empieza nodo:812 / Elemento padre: 811   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(812)).setAttribute("nombre","niriOidNiveRies" );
      ((Element)v.get(812)).setAttribute("id","datosCampos" );
      ((Element)v.get(812)).setAttribute("multiple","N" );
      ((Element)v.get(812)).setAttribute("req","N" );
      ((Element)v.get(812)).setAttribute("size","1" );
      ((Element)v.get(812)).setAttribute("validacion","" );
      ((Element)v.get(812)).setAttribute("onchange","" );
      ((Element)v.get(812)).setAttribute("onfocus","" );
      ((Element)v.get(812)).setAttribute("valorinicial","" );
      ((Element)v.get(812)).setAttribute("textoinicial","" );
      ((Element)v.get(812)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true);" );
      ((Element)v.get(812)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
      ((Element)v.get(811)).appendChild((Element)v.get(812));

      /* Empieza nodo:813 / Elemento padre: 812   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(812)).appendChild((Element)v.get(813));
      /* Termina nodo:813   */
      /* Termina nodo:812   */
      /* Termina nodo:811   */
      /* Termina nodo:810   */

      /* Empieza nodo:814 / Elemento padre: 806   */
   }

   private void getXML3690(Document doc) {
      v.add(doc.createElement("TR"));
      ((Element)v.get(814)).setAttribute("nombre","niriOidNiveRiesViewLabelTrId" );
      ((Element)v.get(806)).appendChild((Element)v.get(814));

      /* Empieza nodo:815 / Elemento padre: 814   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(815)).setAttribute("valign","top" );
      ((Element)v.get(815)).setAttribute("height","13" );
      ((Element)v.get(815)).setAttribute("width","50" );
      ((Element)v.get(814)).appendChild((Element)v.get(815));

      /* Empieza nodo:816 / Elemento padre: 815   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(816)).setAttribute("nombre","lblViewNiriOidNiveRies" );
      ((Element)v.get(816)).setAttribute("alto","13" );
      ((Element)v.get(816)).setAttribute("filas","1" );
      ((Element)v.get(816)).setAttribute("id","EstDat" );
      ((Element)v.get(816)).setAttribute("valor","" );
      ((Element)v.get(815)).appendChild((Element)v.get(816));
      /* Termina nodo:816   */
      /* Termina nodo:815   */
      /* Termina nodo:814   */
      /* Termina nodo:806   */
      /* Termina nodo:805   */

      /* Empieza nodo:817 / Elemento padre: 804   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(817)).setAttribute("nombre","niriOidNiveRiesGapTdId" );
      ((Element)v.get(817)).setAttribute("nowrap","true" );
      ((Element)v.get(817)).setAttribute("class","datosCampos" );
      ((Element)v.get(804)).appendChild((Element)v.get(817));

      /* Empieza nodo:818 / Elemento padre: 817   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(818)).setAttribute("src","b.gif" );
      ((Element)v.get(818)).setAttribute("width","25" );
      ((Element)v.get(818)).setAttribute("height","8" );
      ((Element)v.get(817)).appendChild((Element)v.get(818));
      /* Termina nodo:818   */
      /* Termina nodo:817   */

      /* Empieza nodo:819 / Elemento padre: 804   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(819)).setAttribute("width","100%" );
      ((Element)v.get(804)).appendChild((Element)v.get(819));

      /* Empieza nodo:820 / Elemento padre: 819   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(820)).setAttribute("src","b.gif" );
      ((Element)v.get(819)).appendChild((Element)v.get(820));
      /* Termina nodo:820   */
      /* Termina nodo:819   */
      /* Termina nodo:804   */
      /* Termina nodo:803   */
      /* Termina nodo:802   */
      /* Termina nodo:799   */

      /* Empieza nodo:821 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(821)).setAttribute("nombre","formGapTr24" );
      ((Element)v.get(40)).appendChild((Element)v.get(821));

      /* Empieza nodo:822 / Elemento padre: 821   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(822)).setAttribute("align","center" );
      ((Element)v.get(822)).setAttribute("width","12" );
      ((Element)v.get(821)).appendChild((Element)v.get(822));

      /* Empieza nodo:823 / Elemento padre: 822   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(823)).setAttribute("src","b.gif" );
      ((Element)v.get(823)).setAttribute("width","12" );
      ((Element)v.get(823)).setAttribute("height","8" );
      ((Element)v.get(822)).appendChild((Element)v.get(823));
      /* Termina nodo:823   */
      /* Termina nodo:822   */

      /* Empieza nodo:824 / Elemento padre: 821   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(821)).appendChild((Element)v.get(824));

      /* Empieza nodo:825 / Elemento padre: 824   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(825)).setAttribute("src","b.gif" );
      ((Element)v.get(825)).setAttribute("width","8" );
      ((Element)v.get(825)).setAttribute("height","8" );
      ((Element)v.get(824)).appendChild((Element)v.get(825));
      /* Termina nodo:825   */
      /* Termina nodo:824   */

      /* Empieza nodo:826 / Elemento padre: 821   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(826)).setAttribute("align","center" );
      ((Element)v.get(826)).setAttribute("width","12" );
      ((Element)v.get(821)).appendChild((Element)v.get(826));

      /* Empieza nodo:827 / Elemento padre: 826   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(827)).setAttribute("src","b.gif" );
      ((Element)v.get(827)).setAttribute("width","12" );
      ((Element)v.get(827)).setAttribute("height","8" );
      ((Element)v.get(826)).appendChild((Element)v.get(827));
      /* Termina nodo:827   */
      /* Termina nodo:826   */
      /* Termina nodo:821   */

      /* Empieza nodo:828 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(828)).setAttribute("nombre","formTr25" );
      ((Element)v.get(40)).appendChild((Element)v.get(828));

      /* Empieza nodo:829 / Elemento padre: 828   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(829)).setAttribute("align","center" );
      ((Element)v.get(829)).setAttribute("width","12" );
      ((Element)v.get(828)).appendChild((Element)v.get(829));

      /* Empieza nodo:830 / Elemento padre: 829   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(830)).setAttribute("src","b.gif" );
      ((Element)v.get(830)).setAttribute("width","12" );
      ((Element)v.get(830)).setAttribute("height","12" );
      ((Element)v.get(829)).appendChild((Element)v.get(830));
      /* Termina nodo:830   */
      /* Termina nodo:829   */

      /* Empieza nodo:831 / Elemento padre: 828   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(831)).setAttribute("width","100%" );
      ((Element)v.get(828)).appendChild((Element)v.get(831));

      /* Empieza nodo:832 / Elemento padre: 831   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(832)).setAttribute("width","100%" );
      ((Element)v.get(832)).setAttribute("border","0" );
      ((Element)v.get(832)).setAttribute("cellspacing","0" );
      ((Element)v.get(832)).setAttribute("cellpadding","0" );
      ((Element)v.get(832)).setAttribute("align","left" );
      ((Element)v.get(831)).appendChild((Element)v.get(832));

      /* Empieza nodo:833 / Elemento padre: 832   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(833)).setAttribute("align","left" );
      ((Element)v.get(832)).appendChild((Element)v.get(833));

      /* Empieza nodo:834 / Elemento padre: 833   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(834)).setAttribute("nombre","grsoOidGrupSoliTdId" );
      ((Element)v.get(833)).appendChild((Element)v.get(834));

      /* Empieza nodo:835 / Elemento padre: 834   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(835)).setAttribute("border","0" );
      ((Element)v.get(835)).setAttribute("cellspacing","0" );
   }

   private void getXML3780(Document doc) {
      ((Element)v.get(835)).setAttribute("cellpadding","0" );
      ((Element)v.get(835)).setAttribute("align","left" );
      ((Element)v.get(834)).appendChild((Element)v.get(835));

      /* Empieza nodo:836 / Elemento padre: 835   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(835)).appendChild((Element)v.get(836));

      /* Empieza nodo:837 / Elemento padre: 836   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(837)).setAttribute("valign","top" );
      ((Element)v.get(837)).setAttribute("height","13" );
      ((Element)v.get(836)).appendChild((Element)v.get(837));

      /* Empieza nodo:838 / Elemento padre: 837   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(838)).setAttribute("nombre","lblgrsoOidGrupSoli" );
      ((Element)v.get(838)).setAttribute("id","datosTitle" );
      ((Element)v.get(838)).setAttribute("ancho","100" );
      ((Element)v.get(838)).setAttribute("alto","13" );
      ((Element)v.get(838)).setAttribute("cod","CarSoliEntrBloq.grsoOidGrupSoli.label" );
      ((Element)v.get(837)).appendChild((Element)v.get(838));
      /* Termina nodo:838   */
      /* Termina nodo:837   */
      /* Termina nodo:836   */

      /* Empieza nodo:839 / Elemento padre: 835   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(839)).setAttribute("nombre","grsoOidGrupSoliWidgetTrId" );
      ((Element)v.get(835)).appendChild((Element)v.get(839));

      /* Empieza nodo:840 / Elemento padre: 839   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(840)).setAttribute("align","left" );
      ((Element)v.get(840)).setAttribute("nowrap","true" );
      ((Element)v.get(839)).appendChild((Element)v.get(840));

      /* Empieza nodo:841 / Elemento padre: 840   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(841)).setAttribute("nombre","grsoOidGrupSoli" );
      ((Element)v.get(841)).setAttribute("id","datosCampos" );
      ((Element)v.get(841)).setAttribute("multiple","N" );
      ((Element)v.get(841)).setAttribute("req","N" );
      ((Element)v.get(841)).setAttribute("size","1" );
      ((Element)v.get(841)).setAttribute("validacion","" );
      ((Element)v.get(841)).setAttribute("onchange","" );
      ((Element)v.get(841)).setAttribute("onfocus","" );
      ((Element)v.get(841)).setAttribute("valorinicial","" );
      ((Element)v.get(841)).setAttribute("textoinicial","" );
      ((Element)v.get(841)).setAttribute("ontab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, true);" );
      ((Element)v.get(841)).setAttribute("onshtab","ejecutarAccionFoco('carSoliEntrBloqFrm',0, false);" );
      ((Element)v.get(840)).appendChild((Element)v.get(841));

      /* Empieza nodo:842 / Elemento padre: 841   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(841)).appendChild((Element)v.get(842));
      /* Termina nodo:842   */
      /* Termina nodo:841   */
      /* Termina nodo:840   */
      /* Termina nodo:839   */

      /* Empieza nodo:843 / Elemento padre: 835   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(843)).setAttribute("nombre","grsoOidGrupSoliViewLabelTrId" );
      ((Element)v.get(835)).appendChild((Element)v.get(843));

      /* Empieza nodo:844 / Elemento padre: 843   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(844)).setAttribute("valign","top" );
      ((Element)v.get(844)).setAttribute("height","13" );
      ((Element)v.get(844)).setAttribute("width","50" );
      ((Element)v.get(843)).appendChild((Element)v.get(844));

      /* Empieza nodo:845 / Elemento padre: 844   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(845)).setAttribute("nombre","lblViewGrsoOidGrupSoli" );
      ((Element)v.get(845)).setAttribute("alto","13" );
      ((Element)v.get(845)).setAttribute("filas","1" );
      ((Element)v.get(845)).setAttribute("id","EstDat" );
      ((Element)v.get(845)).setAttribute("valor","" );
      ((Element)v.get(844)).appendChild((Element)v.get(845));
      /* Termina nodo:845   */
      /* Termina nodo:844   */
      /* Termina nodo:843   */
      /* Termina nodo:835   */
      /* Termina nodo:834   */

      /* Empieza nodo:846 / Elemento padre: 833   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(846)).setAttribute("nombre","grsoOidGrupSoliGapTdId" );
      ((Element)v.get(846)).setAttribute("nowrap","true" );
      ((Element)v.get(846)).setAttribute("class","datosCampos" );
      ((Element)v.get(833)).appendChild((Element)v.get(846));

      /* Empieza nodo:847 / Elemento padre: 846   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(847)).setAttribute("src","b.gif" );
      ((Element)v.get(847)).setAttribute("width","25" );
      ((Element)v.get(847)).setAttribute("height","8" );
      ((Element)v.get(846)).appendChild((Element)v.get(847));
      /* Termina nodo:847   */
      /* Termina nodo:846   */

      /* Empieza nodo:848 / Elemento padre: 833   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(848)).setAttribute("width","100%" );
      ((Element)v.get(833)).appendChild((Element)v.get(848));

      /* Empieza nodo:849 / Elemento padre: 848   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(849)).setAttribute("src","b.gif" );
      ((Element)v.get(848)).appendChild((Element)v.get(849));
      /* Termina nodo:849   */
      /* Termina nodo:848   */
      /* Termina nodo:833   */
      /* Termina nodo:832   */
      /* Termina nodo:831   */

      /* Empieza nodo:850 / Elemento padre: 828   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(850)).setAttribute("width","100%" );
      ((Element)v.get(828)).appendChild((Element)v.get(850));
      /* Termina nodo:850   */
      /* Termina nodo:828   */

      /* Empieza nodo:851 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(851)).setAttribute("nombre","formGapTr25" );
      ((Element)v.get(40)).appendChild((Element)v.get(851));

      /* Empieza nodo:852 / Elemento padre: 851   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(852)).setAttribute("align","center" );
      ((Element)v.get(852)).setAttribute("width","12" );
      ((Element)v.get(851)).appendChild((Element)v.get(852));

      /* Empieza nodo:853 / Elemento padre: 852   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(853)).setAttribute("src","b.gif" );
      ((Element)v.get(853)).setAttribute("width","12" );
      ((Element)v.get(853)).setAttribute("height","8" );
      ((Element)v.get(852)).appendChild((Element)v.get(853));
      /* Termina nodo:853   */
      /* Termina nodo:852   */

      /* Empieza nodo:854 / Elemento padre: 851   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(851)).appendChild((Element)v.get(854));

      /* Empieza nodo:855 / Elemento padre: 854   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(855)).setAttribute("src","b.gif" );
      ((Element)v.get(855)).setAttribute("width","8" );
   }

   private void getXML3870(Document doc) {
      ((Element)v.get(855)).setAttribute("height","8" );
      ((Element)v.get(854)).appendChild((Element)v.get(855));
      /* Termina nodo:855   */
      /* Termina nodo:854   */

      /* Empieza nodo:856 / Elemento padre: 851   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(856)).setAttribute("align","center" );
      ((Element)v.get(856)).setAttribute("width","12" );
      ((Element)v.get(851)).appendChild((Element)v.get(856));

      /* Empieza nodo:857 / Elemento padre: 856   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(857)).setAttribute("src","b.gif" );
      ((Element)v.get(857)).setAttribute("width","12" );
      ((Element)v.get(857)).setAttribute("height","8" );
      ((Element)v.get(856)).appendChild((Element)v.get(857));
      /* Termina nodo:857   */
      /* Termina nodo:856   */
      /* Termina nodo:851   */
      /* Termina nodo:40   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:858 / Elemento padre: 33   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(858)).setAttribute("align","center" );
      ((Element)v.get(858)).setAttribute("width","12" );
      ((Element)v.get(33)).appendChild((Element)v.get(858));

      /* Empieza nodo:859 / Elemento padre: 858   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(859)).setAttribute("src","b.gif" );
      ((Element)v.get(859)).setAttribute("width","12" );
      ((Element)v.get(859)).setAttribute("height","12" );
      ((Element)v.get(858)).appendChild((Element)v.get(859));
      /* Termina nodo:859   */
      /* Termina nodo:858   */
      /* Termina nodo:33   */

      /* Empieza nodo:860 / Elemento padre: 25   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(860)).setAttribute("nombre","carSoliEntrBloqTrButtons" );
      ((Element)v.get(25)).appendChild((Element)v.get(860));

      /* Empieza nodo:861 / Elemento padre: 860   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(861)).setAttribute("align","center" );
      ((Element)v.get(861)).setAttribute("width","12" );
      ((Element)v.get(860)).appendChild((Element)v.get(861));

      /* Empieza nodo:862 / Elemento padre: 861   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(862)).setAttribute("src","b.gif" );
      ((Element)v.get(862)).setAttribute("width","12" );
      ((Element)v.get(862)).setAttribute("height","12" );
      ((Element)v.get(861)).appendChild((Element)v.get(862));
      /* Termina nodo:862   */
      /* Termina nodo:861   */

      /* Empieza nodo:863 / Elemento padre: 860   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(860)).appendChild((Element)v.get(863));

      /* Empieza nodo:864 / Elemento padre: 863   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(863)).appendChild((Element)v.get(864));

      /* Empieza nodo:865 / Elemento padre: 864   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(865)).setAttribute("width","100%" );
      ((Element)v.get(865)).setAttribute("border","0" );
      ((Element)v.get(865)).setAttribute("align","center" );
      ((Element)v.get(865)).setAttribute("cellspacing","0" );
      ((Element)v.get(865)).setAttribute("cellpadding","0" );
      ((Element)v.get(864)).appendChild((Element)v.get(865));

      /* Empieza nodo:866 / Elemento padre: 865   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(865)).appendChild((Element)v.get(866));

      /* Empieza nodo:867 / Elemento padre: 866   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(867)).setAttribute("class","tablaTitle" );
      ((Element)v.get(867)).setAttribute("nombre","carSoliEntrBloqTdQueryButton" );
      ((Element)v.get(866)).appendChild((Element)v.get(867));

      /* Empieza nodo:868 / Elemento padre: 867   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(868)).setAttribute("nombre","carSoliEntrBloqQueryButton" );
      ((Element)v.get(868)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(868)).setAttribute("estado","false" );
      ((Element)v.get(868)).setAttribute("accion","carSoliEntrBloqFirstPage();" );
      ((Element)v.get(868)).setAttribute("tipo","html" );
      ((Element)v.get(868)).setAttribute("ID","botonContenido" );
      ((Element)v.get(867)).appendChild((Element)v.get(868));
      /* Termina nodo:868   */
      /* Termina nodo:867   */

      /* Empieza nodo:869 / Elemento padre: 866   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(869)).setAttribute("class","tablaTitle" );
      ((Element)v.get(869)).setAttribute("nombre","carSoliEntrBloqTdLovNullSelectionButton" );
      ((Element)v.get(869)).setAttribute("align","left" );
      ((Element)v.get(869)).setAttribute("width","100%" );
      ((Element)v.get(866)).appendChild((Element)v.get(869));

      /* Empieza nodo:870 / Elemento padre: 869   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(870)).setAttribute("src","b.gif" );
      ((Element)v.get(870)).setAttribute("height","8" );
      ((Element)v.get(870)).setAttribute("width","8" );
      ((Element)v.get(869)).appendChild((Element)v.get(870));
      /* Termina nodo:870   */

      /* Empieza nodo:871 / Elemento padre: 869   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(871)).setAttribute("nombre","carSoliEntrBloqLovNullButton" );
      ((Element)v.get(871)).setAttribute("ID","botonContenido" );
      ((Element)v.get(871)).setAttribute("tipo","html" );
      ((Element)v.get(871)).setAttribute("accion","carSoliEntrBloqLovNullSelectionAction();" );
      ((Element)v.get(871)).setAttribute("estado","true" );
      ((Element)v.get(871)).setAttribute("cod","MMGGlobal.lovNullButton.label" );
      ((Element)v.get(869)).appendChild((Element)v.get(871));
      /* Termina nodo:871   */
      /* Termina nodo:869   */
      /* Termina nodo:866   */
      /* Termina nodo:865   */
      /* Termina nodo:864   */
      /* Termina nodo:863   */

      /* Empieza nodo:872 / Elemento padre: 860   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(872)).setAttribute("align","center" );
      ((Element)v.get(872)).setAttribute("width","12" );
      ((Element)v.get(860)).appendChild((Element)v.get(872));

      /* Empieza nodo:873 / Elemento padre: 872   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(873)).setAttribute("src","b.gif" );
      ((Element)v.get(873)).setAttribute("width","12" );
      ((Element)v.get(873)).setAttribute("height","12" );
      ((Element)v.get(872)).appendChild((Element)v.get(873));
      /* Termina nodo:873   */
      /* Termina nodo:872   */
      /* Termina nodo:860   */
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:874 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(874)).setAttribute("nombre","carSoliEntrBloqPreListLayer" );
      ((Element)v.get(874)).setAttribute("alto","23" );
      ((Element)v.get(874)).setAttribute("ancho","100%" );
      ((Element)v.get(874)).setAttribute("colorf","" );
   }

   private void getXML3960(Document doc) {
      ((Element)v.get(874)).setAttribute("borde","0" );
      ((Element)v.get(874)).setAttribute("imagenf","" );
      ((Element)v.get(874)).setAttribute("repeat","" );
      ((Element)v.get(874)).setAttribute("padding","" );
      ((Element)v.get(874)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(874)).setAttribute("contravsb","" );
      ((Element)v.get(874)).setAttribute("x","0" );
      ((Element)v.get(874)).setAttribute("y","0" );
      ((Element)v.get(874)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(874));

      /* Empieza nodo:875 / Elemento padre: 874   */
      v.add(doc.createElement("table"));
      ((Element)v.get(875)).setAttribute("width","100%" );
      ((Element)v.get(875)).setAttribute("border","0" );
      ((Element)v.get(875)).setAttribute("align","center" );
      ((Element)v.get(875)).setAttribute("cellspacing","0" );
      ((Element)v.get(875)).setAttribute("cellpadding","0" );
      ((Element)v.get(874)).appendChild((Element)v.get(875));

      /* Empieza nodo:876 / Elemento padre: 875   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(875)).appendChild((Element)v.get(876));

      /* Empieza nodo:877 / Elemento padre: 876   */
      v.add(doc.createElement("td"));
      ((Element)v.get(877)).setAttribute("width","12" );
      ((Element)v.get(877)).setAttribute("align","center" );
      ((Element)v.get(876)).appendChild((Element)v.get(877));

      /* Empieza nodo:878 / Elemento padre: 877   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(878)).setAttribute("src","b.gif" );
      ((Element)v.get(878)).setAttribute("width","12" );
      ((Element)v.get(878)).setAttribute("height","1" );
      ((Element)v.get(877)).appendChild((Element)v.get(878));
      /* Termina nodo:878   */
      /* Termina nodo:877   */

      /* Empieza nodo:879 / Elemento padre: 876   */
      v.add(doc.createElement("td"));
      ((Element)v.get(879)).setAttribute("width","750" );
      ((Element)v.get(876)).appendChild((Element)v.get(879));

      /* Empieza nodo:880 / Elemento padre: 879   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(880)).setAttribute("src","b.gif" );
      ((Element)v.get(879)).appendChild((Element)v.get(880));
      /* Termina nodo:880   */
      /* Termina nodo:879   */

      /* Empieza nodo:881 / Elemento padre: 876   */
      v.add(doc.createElement("td"));
      ((Element)v.get(881)).setAttribute("width","12" );
      ((Element)v.get(876)).appendChild((Element)v.get(881));

      /* Empieza nodo:882 / Elemento padre: 881   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(882)).setAttribute("src","b.gif" );
      ((Element)v.get(882)).setAttribute("width","12" );
      ((Element)v.get(882)).setAttribute("height","1" );
      ((Element)v.get(881)).appendChild((Element)v.get(882));
      /* Termina nodo:882   */
      /* Termina nodo:881   */
      /* Termina nodo:876   */

      /* Empieza nodo:883 / Elemento padre: 875   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(875)).appendChild((Element)v.get(883));

      /* Empieza nodo:884 / Elemento padre: 883   */
      v.add(doc.createElement("td"));
      ((Element)v.get(883)).appendChild((Element)v.get(884));

      /* Empieza nodo:885 / Elemento padre: 884   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(885)).setAttribute("src","b.gif" );
      ((Element)v.get(884)).appendChild((Element)v.get(885));
      /* Termina nodo:885   */
      /* Termina nodo:884   */

      /* Empieza nodo:886 / Elemento padre: 883   */
      v.add(doc.createElement("td"));
      ((Element)v.get(883)).appendChild((Element)v.get(886));

      /* Empieza nodo:887 / Elemento padre: 886   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(886)).appendChild((Element)v.get(887));

      /* Empieza nodo:888 / Elemento padre: 887   */
      v.add(doc.createElement("table"));
      ((Element)v.get(888)).setAttribute("width","100%" );
      ((Element)v.get(888)).setAttribute("border","0" );
      ((Element)v.get(888)).setAttribute("align","center" );
      ((Element)v.get(888)).setAttribute("cellspacing","0" );
      ((Element)v.get(888)).setAttribute("cellpadding","0" );
      ((Element)v.get(887)).appendChild((Element)v.get(888));

      /* Empieza nodo:889 / Elemento padre: 888   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(888)).appendChild((Element)v.get(889));

      /* Empieza nodo:890 / Elemento padre: 889   */
      v.add(doc.createElement("td"));
      ((Element)v.get(890)).setAttribute("bgcolor","#CCCCCC" );
      ((Element)v.get(890)).setAttribute("width","4" );
      ((Element)v.get(889)).appendChild((Element)v.get(890));

      /* Empieza nodo:891 / Elemento padre: 890   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(891)).setAttribute("src","b.gif" );
      ((Element)v.get(891)).setAttribute("width","4" );
      ((Element)v.get(891)).setAttribute("height","4" );
      ((Element)v.get(890)).appendChild((Element)v.get(891));
      /* Termina nodo:891   */
      /* Termina nodo:890   */

      /* Empieza nodo:892 / Elemento padre: 889   */
      v.add(doc.createElement("td"));
      ((Element)v.get(892)).setAttribute("bgcolor","#CCCCCC" );
      ((Element)v.get(892)).setAttribute("valign","middle" );
      ((Element)v.get(889)).appendChild((Element)v.get(892));

      /* Empieza nodo:893 / Elemento padre: 892   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(893)).setAttribute("nombre","lblResultSearch" );
      ((Element)v.get(893)).setAttribute("ancho","108" );
      ((Element)v.get(893)).setAttribute("alto","17" );
      ((Element)v.get(893)).setAttribute("id","EstCab" );
      ((Element)v.get(893)).setAttribute("cod","MMGGlobal.legend.resultlegend.label" );
      ((Element)v.get(892)).appendChild((Element)v.get(893));
      /* Termina nodo:893   */
      /* Termina nodo:892   */
      /* Termina nodo:889   */
      /* Termina nodo:888   */
      /* Termina nodo:887   */
      /* Termina nodo:886   */

      /* Empieza nodo:894 / Elemento padre: 883   */
      v.add(doc.createElement("td"));
      ((Element)v.get(894)).setAttribute("width","12" );
      ((Element)v.get(883)).appendChild((Element)v.get(894));

      /* Empieza nodo:895 / Elemento padre: 894   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(895)).setAttribute("src","b.gif" );
      ((Element)v.get(895)).setAttribute("width","12" );
      ((Element)v.get(895)).setAttribute("height","12" );
      ((Element)v.get(894)).appendChild((Element)v.get(895));
      /* Termina nodo:895   */
      /* Termina nodo:894   */
      /* Termina nodo:883   */

      /* Empieza nodo:896 / Elemento padre: 875   */
   }

   private void getXML4050(Document doc) {
      v.add(doc.createElement("tr"));
      ((Element)v.get(875)).appendChild((Element)v.get(896));

      /* Empieza nodo:897 / Elemento padre: 896   */
      v.add(doc.createElement("td"));
      ((Element)v.get(897)).setAttribute("width","12" );
      ((Element)v.get(897)).setAttribute("align","center" );
      ((Element)v.get(896)).appendChild((Element)v.get(897));

      /* Empieza nodo:898 / Elemento padre: 897   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(898)).setAttribute("src","b.gif" );
      ((Element)v.get(898)).setAttribute("width","12" );
      ((Element)v.get(898)).setAttribute("height","1" );
      ((Element)v.get(897)).appendChild((Element)v.get(898));
      /* Termina nodo:898   */
      /* Termina nodo:897   */

      /* Empieza nodo:899 / Elemento padre: 896   */
      v.add(doc.createElement("td"));
      ((Element)v.get(899)).setAttribute("width","750" );
      ((Element)v.get(896)).appendChild((Element)v.get(899));

      /* Empieza nodo:900 / Elemento padre: 899   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(900)).setAttribute("src","b.gif" );
      ((Element)v.get(899)).appendChild((Element)v.get(900));
      /* Termina nodo:900   */
      /* Termina nodo:899   */

      /* Empieza nodo:901 / Elemento padre: 896   */
      v.add(doc.createElement("td"));
      ((Element)v.get(901)).setAttribute("width","12" );
      ((Element)v.get(896)).appendChild((Element)v.get(901));

      /* Empieza nodo:902 / Elemento padre: 901   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(902)).setAttribute("src","b.gif" );
      ((Element)v.get(902)).setAttribute("width","12" );
      ((Element)v.get(902)).setAttribute("height","1" );
      ((Element)v.get(901)).appendChild((Element)v.get(902));
      /* Termina nodo:902   */
      /* Termina nodo:901   */
      /* Termina nodo:896   */
      /* Termina nodo:875   */
      /* Termina nodo:874   */

      /* Empieza nodo:903 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(903)).setAttribute("nombre","carSoliEntrBloqListLayer" );
      ((Element)v.get(903)).setAttribute("alto","310" );
      ((Element)v.get(903)).setAttribute("ancho","99%" );
      ((Element)v.get(903)).setAttribute("colorf","" );
      ((Element)v.get(903)).setAttribute("borde","0" );
      ((Element)v.get(903)).setAttribute("imagenf","" );
      ((Element)v.get(903)).setAttribute("repeat","" );
      ((Element)v.get(903)).setAttribute("padding","" );
      ((Element)v.get(903)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(903)).setAttribute("contravsb","" );
      ((Element)v.get(903)).setAttribute("x","3" );
      ((Element)v.get(903)).setAttribute("y","" );
      ((Element)v.get(903)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(903));

      /* Empieza nodo:904 / Elemento padre: 903   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(904)).setAttribute("nombre","carSoliEntrBloqList" );
      ((Element)v.get(904)).setAttribute("ancho","680" );
      ((Element)v.get(904)).setAttribute("alto","275" );
      ((Element)v.get(904)).setAttribute("x","12" );
      ((Element)v.get(904)).setAttribute("y","0" );
      ((Element)v.get(904)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(904)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(903)).appendChild((Element)v.get(904));

      /* Empieza nodo:905 / Elemento padre: 904   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(905)).setAttribute("precarga","S" );
      ((Element)v.get(905)).setAttribute("conROver","S" );
      ((Element)v.get(904)).appendChild((Element)v.get(905));

      /* Empieza nodo:906 / Elemento padre: 905   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(906)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(906)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(906)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(906)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(905)).appendChild((Element)v.get(906));
      /* Termina nodo:906   */

      /* Empieza nodo:907 / Elemento padre: 905   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(907)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(907)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(907)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(907)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(905)).appendChild((Element)v.get(907));
      /* Termina nodo:907   */
      /* Termina nodo:905   */

      /* Empieza nodo:908 / Elemento padre: 904   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(904)).appendChild((Element)v.get(908));

      /* Empieza nodo:909 / Elemento padre: 908   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(909)).setAttribute("borde","1" );
      ((Element)v.get(909)).setAttribute("horizDatos","1" );
      ((Element)v.get(909)).setAttribute("horizCabecera","1" );
      ((Element)v.get(909)).setAttribute("horizTitulo","1" );
      ((Element)v.get(909)).setAttribute("horizBase","1" );
      ((Element)v.get(909)).setAttribute("vertical","0" );
      ((Element)v.get(908)).appendChild((Element)v.get(909));
      /* Termina nodo:909   */

      /* Empieza nodo:910 / Elemento padre: 908   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(910)).setAttribute("borde","#999999" );
      ((Element)v.get(910)).setAttribute("vertCabecera","#999999" );
      ((Element)v.get(910)).setAttribute("vertDatos","#999999" );
      ((Element)v.get(910)).setAttribute("horizDatos","#999999" );
      ((Element)v.get(910)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(910)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(910)).setAttribute("horizBase","#999999" );
      ((Element)v.get(908)).appendChild((Element)v.get(910));
      /* Termina nodo:910   */
      /* Termina nodo:908   */

      /* Empieza nodo:911 / Elemento padre: 904   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(911)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(911)).setAttribute("alto","22" );
      ((Element)v.get(911)).setAttribute("imgFondo","" );
      ((Element)v.get(904)).appendChild((Element)v.get(911));
      /* Termina nodo:911   */

      /* Empieza nodo:912 / Elemento padre: 904   */
      v.add(doc.createElement("COLUMNAS"));
   }

   private void getXML4140(Document doc) {
      ((Element)v.get(912)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(912)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(912)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(912)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(912)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(904)).appendChild((Element)v.get(912));

      /* Empieza nodo:913 / Elemento padre: 912   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(913)).setAttribute("ancho","100" );
      ((Element)v.get(913)).setAttribute("minimizable","S" );
      ((Element)v.get(913)).setAttribute("minimizada","N" );
      ((Element)v.get(912)).appendChild((Element)v.get(913));
      /* Termina nodo:913   */

      /* Empieza nodo:914 / Elemento padre: 912   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(914)).setAttribute("ancho","100" );
      ((Element)v.get(914)).setAttribute("minimizable","S" );
      ((Element)v.get(914)).setAttribute("minimizada","N" );
      ((Element)v.get(912)).appendChild((Element)v.get(914));
      /* Termina nodo:914   */

      /* Empieza nodo:915 / Elemento padre: 912   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(915)).setAttribute("ancho","100" );
      ((Element)v.get(915)).setAttribute("minimizable","S" );
      ((Element)v.get(915)).setAttribute("minimizada","N" );
      ((Element)v.get(912)).appendChild((Element)v.get(915));
      /* Termina nodo:915   */

      /* Empieza nodo:916 / Elemento padre: 912   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(916)).setAttribute("ancho","100" );
      ((Element)v.get(916)).setAttribute("minimizable","S" );
      ((Element)v.get(916)).setAttribute("minimizada","N" );
      ((Element)v.get(912)).appendChild((Element)v.get(916));
      /* Termina nodo:916   */

      /* Empieza nodo:917 / Elemento padre: 912   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(917)).setAttribute("ancho","100" );
      ((Element)v.get(917)).setAttribute("minimizable","S" );
      ((Element)v.get(917)).setAttribute("minimizada","N" );
      ((Element)v.get(912)).appendChild((Element)v.get(917));
      /* Termina nodo:917   */

      /* Empieza nodo:918 / Elemento padre: 912   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(918)).setAttribute("ancho","100" );
      ((Element)v.get(918)).setAttribute("minimizable","S" );
      ((Element)v.get(918)).setAttribute("minimizada","N" );
      ((Element)v.get(912)).appendChild((Element)v.get(918));
      /* Termina nodo:918   */

      /* Empieza nodo:919 / Elemento padre: 912   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(919)).setAttribute("ancho","100" );
      ((Element)v.get(919)).setAttribute("minimizable","S" );
      ((Element)v.get(919)).setAttribute("minimizada","N" );
      ((Element)v.get(912)).appendChild((Element)v.get(919));
      /* Termina nodo:919   */

      /* Empieza nodo:920 / Elemento padre: 912   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(920)).setAttribute("ancho","100" );
      ((Element)v.get(920)).setAttribute("minimizable","S" );
      ((Element)v.get(920)).setAttribute("minimizada","N" );
      ((Element)v.get(912)).appendChild((Element)v.get(920));
      /* Termina nodo:920   */

      /* Empieza nodo:921 / Elemento padre: 912   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(921)).setAttribute("ancho","100" );
      ((Element)v.get(921)).setAttribute("minimizable","S" );
      ((Element)v.get(921)).setAttribute("minimizada","N" );
      ((Element)v.get(912)).appendChild((Element)v.get(921));
      /* Termina nodo:921   */

      /* Empieza nodo:922 / Elemento padre: 912   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(922)).setAttribute("ancho","100" );
      ((Element)v.get(922)).setAttribute("minimizable","S" );
      ((Element)v.get(922)).setAttribute("minimizada","N" );
      ((Element)v.get(912)).appendChild((Element)v.get(922));
      /* Termina nodo:922   */

      /* Empieza nodo:923 / Elemento padre: 912   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(923)).setAttribute("ancho","100" );
      ((Element)v.get(923)).setAttribute("minimizable","S" );
      ((Element)v.get(923)).setAttribute("minimizada","N" );
      ((Element)v.get(912)).appendChild((Element)v.get(923));
      /* Termina nodo:923   */

      /* Empieza nodo:924 / Elemento padre: 912   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(924)).setAttribute("ancho","100" );
      ((Element)v.get(924)).setAttribute("minimizable","S" );
      ((Element)v.get(924)).setAttribute("minimizada","N" );
      ((Element)v.get(912)).appendChild((Element)v.get(924));
      /* Termina nodo:924   */

      /* Empieza nodo:925 / Elemento padre: 912   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(925)).setAttribute("ancho","100" );
      ((Element)v.get(925)).setAttribute("minimizable","S" );
      ((Element)v.get(925)).setAttribute("minimizada","N" );
      ((Element)v.get(912)).appendChild((Element)v.get(925));
      /* Termina nodo:925   */

      /* Empieza nodo:926 / Elemento padre: 912   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(926)).setAttribute("ancho","100" );
      ((Element)v.get(926)).setAttribute("minimizable","S" );
      ((Element)v.get(926)).setAttribute("minimizada","N" );
      ((Element)v.get(912)).appendChild((Element)v.get(926));
      /* Termina nodo:926   */

      /* Empieza nodo:927 / Elemento padre: 912   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(927)).setAttribute("ancho","100" );
      ((Element)v.get(927)).setAttribute("minimizable","S" );
      ((Element)v.get(927)).setAttribute("minimizada","N" );
      ((Element)v.get(912)).appendChild((Element)v.get(927));
      /* Termina nodo:927   */

      /* Empieza nodo:928 / Elemento padre: 912   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(928)).setAttribute("ancho","100" );
      ((Element)v.get(928)).setAttribute("minimizable","S" );
      ((Element)v.get(928)).setAttribute("minimizada","N" );
      ((Element)v.get(912)).appendChild((Element)v.get(928));
      /* Termina nodo:928   */

      /* Empieza nodo:929 / Elemento padre: 912   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(929)).setAttribute("ancho","100" );
      ((Element)v.get(929)).setAttribute("minimizable","S" );
      ((Element)v.get(929)).setAttribute("minimizada","N" );
   }

   private void getXML4230(Document doc) {
      ((Element)v.get(912)).appendChild((Element)v.get(929));
      /* Termina nodo:929   */

      /* Empieza nodo:930 / Elemento padre: 912   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(930)).setAttribute("ancho","100" );
      ((Element)v.get(930)).setAttribute("minimizable","S" );
      ((Element)v.get(930)).setAttribute("minimizada","N" );
      ((Element)v.get(912)).appendChild((Element)v.get(930));
      /* Termina nodo:930   */

      /* Empieza nodo:931 / Elemento padre: 912   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(931)).setAttribute("ancho","100" );
      ((Element)v.get(931)).setAttribute("minimizable","S" );
      ((Element)v.get(931)).setAttribute("minimizada","N" );
      ((Element)v.get(912)).appendChild((Element)v.get(931));
      /* Termina nodo:931   */

      /* Empieza nodo:932 / Elemento padre: 912   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(932)).setAttribute("ancho","100" );
      ((Element)v.get(932)).setAttribute("minimizable","S" );
      ((Element)v.get(932)).setAttribute("minimizada","N" );
      ((Element)v.get(912)).appendChild((Element)v.get(932));
      /* Termina nodo:932   */

      /* Empieza nodo:933 / Elemento padre: 912   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(933)).setAttribute("ancho","100" );
      ((Element)v.get(933)).setAttribute("minimizable","S" );
      ((Element)v.get(933)).setAttribute("minimizada","N" );
      ((Element)v.get(912)).appendChild((Element)v.get(933));
      /* Termina nodo:933   */

      /* Empieza nodo:934 / Elemento padre: 912   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(934)).setAttribute("ancho","100" );
      ((Element)v.get(934)).setAttribute("minimizable","S" );
      ((Element)v.get(934)).setAttribute("minimizada","N" );
      ((Element)v.get(912)).appendChild((Element)v.get(934));
      /* Termina nodo:934   */

      /* Empieza nodo:935 / Elemento padre: 912   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(935)).setAttribute("ancho","100" );
      ((Element)v.get(935)).setAttribute("minimizable","S" );
      ((Element)v.get(935)).setAttribute("minimizada","N" );
      ((Element)v.get(912)).appendChild((Element)v.get(935));
      /* Termina nodo:935   */

      /* Empieza nodo:936 / Elemento padre: 912   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(936)).setAttribute("ancho","100" );
      ((Element)v.get(936)).setAttribute("minimizable","S" );
      ((Element)v.get(936)).setAttribute("minimizada","N" );
      ((Element)v.get(912)).appendChild((Element)v.get(936));
      /* Termina nodo:936   */

      /* Empieza nodo:937 / Elemento padre: 912   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(937)).setAttribute("ancho","100" );
      ((Element)v.get(937)).setAttribute("minimizable","S" );
      ((Element)v.get(937)).setAttribute("minimizada","N" );
      ((Element)v.get(912)).appendChild((Element)v.get(937));
      /* Termina nodo:937   */
      /* Termina nodo:912   */

      /* Empieza nodo:938 / Elemento padre: 904   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(938)).setAttribute("height","20" );
      ((Element)v.get(938)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(938)).setAttribute("imgFondo","" );
      ((Element)v.get(938)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(904)).appendChild((Element)v.get(938));

      /* Empieza nodo:939 / Elemento padre: 938   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(939)).setAttribute("colFondo","" );
      ((Element)v.get(939)).setAttribute("ID","EstCab" );
      ((Element)v.get(939)).setAttribute("cod","CarSoliEntrBloq.paisOidPais.label" );
      ((Element)v.get(938)).appendChild((Element)v.get(939));
      /* Termina nodo:939   */

      /* Empieza nodo:940 / Elemento padre: 938   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(940)).setAttribute("colFondo","" );
      ((Element)v.get(940)).setAttribute("ID","EstCab" );
      ((Element)v.get(940)).setAttribute("cod","CarSoliEntrBloq.sbacOidSbac.label" );
      ((Element)v.get(938)).appendChild((Element)v.get(940));
      /* Termina nodo:940   */

      /* Empieza nodo:941 / Elemento padre: 938   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(941)).setAttribute("colFondo","" );
      ((Element)v.get(941)).setAttribute("ID","EstCab" );
      ((Element)v.get(941)).setAttribute("cod","CarSoliEntrBloq.tsolOidTipoSoli.label" );
      ((Element)v.get(938)).appendChild((Element)v.get(941));
      /* Termina nodo:941   */

      /* Empieza nodo:942 / Elemento padre: 938   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(942)).setAttribute("colFondo","" );
      ((Element)v.get(942)).setAttribute("ID","EstCab" );
      ((Element)v.get(942)).setAttribute("cod","CarSoliEntrBloq.socaOidSoliCabe.label" );
      ((Element)v.get(938)).appendChild((Element)v.get(942));
      /* Termina nodo:942   */

      /* Empieza nodo:943 / Elemento padre: 938   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(943)).setAttribute("colFondo","" );
      ((Element)v.get(943)).setAttribute("ID","EstCab" );
      ((Element)v.get(943)).setAttribute("cod","CarSoliEntrBloq.fecDocu.label" );
      ((Element)v.get(938)).appendChild((Element)v.get(943));
      /* Termina nodo:943   */

      /* Empieza nodo:944 / Elemento padre: 938   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(944)).setAttribute("colFondo","" );
      ((Element)v.get(944)).setAttribute("ID","EstCab" );
      ((Element)v.get(944)).setAttribute("cod","CarSoliEntrBloq.indNoti.label" );
      ((Element)v.get(938)).appendChild((Element)v.get(944));
      /* Termina nodo:944   */

      /* Empieza nodo:945 / Elemento padre: 938   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(945)).setAttribute("colFondo","" );
      ((Element)v.get(945)).setAttribute("ID","EstCab" );
      ((Element)v.get(945)).setAttribute("cod","CarSoliEntrBloq.valMontOrde.label" );
      ((Element)v.get(938)).appendChild((Element)v.get(945));
      /* Termina nodo:945   */

      /* Empieza nodo:946 / Elemento padre: 938   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(946)).setAttribute("colFondo","" );
      ((Element)v.get(946)).setAttribute("ID","EstCab" );
      ((Element)v.get(946)).setAttribute("cod","CarSoliEntrBloq.valMontDeudVenc.label" );
      ((Element)v.get(938)).appendChild((Element)v.get(946));
      /* Termina nodo:946   */

      /* Empieza nodo:947 / Elemento padre: 938   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(947)).setAttribute("colFondo","" );
      ((Element)v.get(947)).setAttribute("ID","EstCab" );
   }

   private void getXML4320(Document doc) {
      ((Element)v.get(947)).setAttribute("cod","CarSoliEntrBloq.indVali1.label" );
      ((Element)v.get(938)).appendChild((Element)v.get(947));
      /* Termina nodo:947   */

      /* Empieza nodo:948 / Elemento padre: 938   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(948)).setAttribute("colFondo","" );
      ((Element)v.get(948)).setAttribute("ID","EstCab" );
      ((Element)v.get(948)).setAttribute("cod","CarSoliEntrBloq.indVali2.label" );
      ((Element)v.get(938)).appendChild((Element)v.get(948));
      /* Termina nodo:948   */

      /* Empieza nodo:949 / Elemento padre: 938   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(949)).setAttribute("colFondo","" );
      ((Element)v.get(949)).setAttribute("ID","EstCab" );
      ((Element)v.get(949)).setAttribute("cod","CarSoliEntrBloq.indVali3.label" );
      ((Element)v.get(938)).appendChild((Element)v.get(949));
      /* Termina nodo:949   */

      /* Empieza nodo:950 / Elemento padre: 938   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(950)).setAttribute("colFondo","" );
      ((Element)v.get(950)).setAttribute("ID","EstCab" );
      ((Element)v.get(950)).setAttribute("cod","CarSoliEntrBloq.indVali4.label" );
      ((Element)v.get(938)).appendChild((Element)v.get(950));
      /* Termina nodo:950   */

      /* Empieza nodo:951 / Elemento padre: 938   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(951)).setAttribute("colFondo","" );
      ((Element)v.get(951)).setAttribute("ID","EstCab" );
      ((Element)v.get(951)).setAttribute("cod","CarSoliEntrBloq.fecHoraLibe.label" );
      ((Element)v.get(938)).appendChild((Element)v.get(951));
      /* Termina nodo:951   */

      /* Empieza nodo:952 / Elemento padre: 938   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(952)).setAttribute("colFondo","" );
      ((Element)v.get(952)).setAttribute("ID","EstCab" );
      ((Element)v.get(952)).setAttribute("cod","CarSoliEntrBloq.valObse.label" );
      ((Element)v.get(938)).appendChild((Element)v.get(952));
      /* Termina nodo:952   */

      /* Empieza nodo:953 / Elemento padre: 938   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(953)).setAttribute("colFondo","" );
      ((Element)v.get(953)).setAttribute("ID","EstCab" );
      ((Element)v.get(953)).setAttribute("cod","CarSoliEntrBloq.jeraOidJera.label" );
      ((Element)v.get(938)).appendChild((Element)v.get(953));
      /* Termina nodo:953   */

      /* Empieza nodo:954 / Elemento padre: 938   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(954)).setAttribute("colFondo","" );
      ((Element)v.get(954)).setAttribute("ID","EstCab" );
      ((Element)v.get(954)).setAttribute("cod","CarSoliEntrBloq.espeOidEstaPedi.label" );
      ((Element)v.get(938)).appendChild((Element)v.get(954));
      /* Termina nodo:954   */

      /* Empieza nodo:955 / Elemento padre: 938   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(955)).setAttribute("colFondo","" );
      ((Element)v.get(955)).setAttribute("ID","EstCab" );
      ((Element)v.get(955)).setAttribute("cod","CarSoliEntrBloq.perdOidPeri.label" );
      ((Element)v.get(938)).appendChild((Element)v.get(955));
      /* Termina nodo:955   */

      /* Empieza nodo:956 / Elemento padre: 938   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(956)).setAttribute("colFondo","" );
      ((Element)v.get(956)).setAttribute("ID","EstCab" );
      ((Element)v.get(956)).setAttribute("cod","CarSoliEntrBloq.clieOidClie.label" );
      ((Element)v.get(938)).appendChild((Element)v.get(956));
      /* Termina nodo:956   */

      /* Empieza nodo:957 / Elemento padre: 938   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(957)).setAttribute("colFondo","" );
      ((Element)v.get(957)).setAttribute("ID","EstCab" );
      ((Element)v.get(957)).setAttribute("cod","CarSoliEntrBloq.clieOidGereZona.label" );
      ((Element)v.get(938)).appendChild((Element)v.get(957));
      /* Termina nodo:957   */

      /* Empieza nodo:958 / Elemento padre: 938   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(958)).setAttribute("colFondo","" );
      ((Element)v.get(958)).setAttribute("ID","EstCab" );
      ((Element)v.get(958)).setAttribute("cod","CarSoliEntrBloq.cuadOidClieUnidAdmi.label" );
      ((Element)v.get(938)).appendChild((Element)v.get(958));
      /* Termina nodo:958   */

      /* Empieza nodo:959 / Elemento padre: 938   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(959)).setAttribute("colFondo","" );
      ((Element)v.get(959)).setAttribute("ID","EstCab" );
      ((Element)v.get(959)).setAttribute("cod","CarSoliEntrBloq.coapOidCodiApro.label" );
      ((Element)v.get(938)).appendChild((Element)v.get(959));
      /* Termina nodo:959   */

      /* Empieza nodo:960 / Elemento padre: 938   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(960)).setAttribute("colFondo","" );
      ((Element)v.get(960)).setAttribute("ID","EstCab" );
      ((Element)v.get(960)).setAttribute("cod","CarSoliEntrBloq.ejcuOidEjecCuen.label" );
      ((Element)v.get(938)).appendChild((Element)v.get(960));
      /* Termina nodo:960   */

      /* Empieza nodo:961 / Elemento padre: 938   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(961)).setAttribute("colFondo","" );
      ((Element)v.get(961)).setAttribute("ID","EstCab" );
      ((Element)v.get(961)).setAttribute("cod","CarSoliEntrBloq.ejcuOidUsuaLibe.label" );
      ((Element)v.get(938)).appendChild((Element)v.get(961));
      /* Termina nodo:961   */

      /* Empieza nodo:962 / Elemento padre: 938   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(962)).setAttribute("colFondo","" );
      ((Element)v.get(962)).setAttribute("ID","EstCab" );
      ((Element)v.get(962)).setAttribute("cod","CarSoliEntrBloq.niriOidNiveRies.label" );
      ((Element)v.get(938)).appendChild((Element)v.get(962));
      /* Termina nodo:962   */

      /* Empieza nodo:963 / Elemento padre: 938   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(963)).setAttribute("colFondo","" );
      ((Element)v.get(963)).setAttribute("ID","EstCab" );
      ((Element)v.get(963)).setAttribute("cod","CarSoliEntrBloq.grsoOidGrupSoli.label" );
      ((Element)v.get(938)).appendChild((Element)v.get(963));
      /* Termina nodo:963   */
      /* Termina nodo:938   */

      /* Empieza nodo:964 / Elemento padre: 904   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(964)).setAttribute("alto","22" );
      ((Element)v.get(964)).setAttribute("accion","" );
      ((Element)v.get(964)).setAttribute("tipoEnvio","seleccion" );
      ((Element)v.get(964)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(964)).setAttribute("maxSel","1" );
      ((Element)v.get(964)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(964)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
   }

   private void getXML4410(Document doc) {
      ((Element)v.get(964)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(964)).setAttribute("onLoad","" );
      ((Element)v.get(964)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(904)).appendChild((Element)v.get(964));

      /* Empieza nodo:965 / Elemento padre: 964   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(965)).setAttribute("tipo","texto" );
      ((Element)v.get(965)).setAttribute("ID","EstDat" );
      ((Element)v.get(964)).appendChild((Element)v.get(965));
      /* Termina nodo:965   */

      /* Empieza nodo:966 / Elemento padre: 964   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(966)).setAttribute("tipo","texto" );
      ((Element)v.get(966)).setAttribute("ID","EstDat2" );
      ((Element)v.get(964)).appendChild((Element)v.get(966));
      /* Termina nodo:966   */

      /* Empieza nodo:967 / Elemento padre: 964   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(967)).setAttribute("tipo","texto" );
      ((Element)v.get(967)).setAttribute("ID","EstDat" );
      ((Element)v.get(964)).appendChild((Element)v.get(967));
      /* Termina nodo:967   */

      /* Empieza nodo:968 / Elemento padre: 964   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(968)).setAttribute("tipo","texto" );
      ((Element)v.get(968)).setAttribute("ID","EstDat2" );
      ((Element)v.get(964)).appendChild((Element)v.get(968));
      /* Termina nodo:968   */

      /* Empieza nodo:969 / Elemento padre: 964   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(969)).setAttribute("tipo","texto" );
      ((Element)v.get(969)).setAttribute("ID","EstDat" );
      ((Element)v.get(964)).appendChild((Element)v.get(969));
      /* Termina nodo:969   */

      /* Empieza nodo:970 / Elemento padre: 964   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(970)).setAttribute("tipo","texto" );
      ((Element)v.get(970)).setAttribute("ID","EstDat2" );
      ((Element)v.get(964)).appendChild((Element)v.get(970));
      /* Termina nodo:970   */

      /* Empieza nodo:971 / Elemento padre: 964   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(971)).setAttribute("tipo","texto" );
      ((Element)v.get(971)).setAttribute("ID","EstDat" );
      ((Element)v.get(964)).appendChild((Element)v.get(971));
      /* Termina nodo:971   */

      /* Empieza nodo:972 / Elemento padre: 964   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(972)).setAttribute("tipo","texto" );
      ((Element)v.get(972)).setAttribute("ID","EstDat2" );
      ((Element)v.get(964)).appendChild((Element)v.get(972));
      /* Termina nodo:972   */

      /* Empieza nodo:973 / Elemento padre: 964   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(973)).setAttribute("tipo","texto" );
      ((Element)v.get(973)).setAttribute("ID","EstDat" );
      ((Element)v.get(964)).appendChild((Element)v.get(973));
      /* Termina nodo:973   */

      /* Empieza nodo:974 / Elemento padre: 964   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(974)).setAttribute("tipo","texto" );
      ((Element)v.get(974)).setAttribute("ID","EstDat2" );
      ((Element)v.get(964)).appendChild((Element)v.get(974));
      /* Termina nodo:974   */

      /* Empieza nodo:975 / Elemento padre: 964   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(975)).setAttribute("tipo","texto" );
      ((Element)v.get(975)).setAttribute("ID","EstDat" );
      ((Element)v.get(964)).appendChild((Element)v.get(975));
      /* Termina nodo:975   */

      /* Empieza nodo:976 / Elemento padre: 964   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(976)).setAttribute("tipo","texto" );
      ((Element)v.get(976)).setAttribute("ID","EstDat2" );
      ((Element)v.get(964)).appendChild((Element)v.get(976));
      /* Termina nodo:976   */

      /* Empieza nodo:977 / Elemento padre: 964   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(977)).setAttribute("tipo","texto" );
      ((Element)v.get(977)).setAttribute("ID","EstDat" );
      ((Element)v.get(964)).appendChild((Element)v.get(977));
      /* Termina nodo:977   */

      /* Empieza nodo:978 / Elemento padre: 964   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(978)).setAttribute("tipo","texto" );
      ((Element)v.get(978)).setAttribute("ID","EstDat2" );
      ((Element)v.get(964)).appendChild((Element)v.get(978));
      /* Termina nodo:978   */

      /* Empieza nodo:979 / Elemento padre: 964   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(979)).setAttribute("tipo","texto" );
      ((Element)v.get(979)).setAttribute("ID","EstDat" );
      ((Element)v.get(964)).appendChild((Element)v.get(979));
      /* Termina nodo:979   */

      /* Empieza nodo:980 / Elemento padre: 964   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(980)).setAttribute("tipo","texto" );
      ((Element)v.get(980)).setAttribute("ID","EstDat2" );
      ((Element)v.get(964)).appendChild((Element)v.get(980));
      /* Termina nodo:980   */

      /* Empieza nodo:981 / Elemento padre: 964   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(981)).setAttribute("tipo","texto" );
      ((Element)v.get(981)).setAttribute("ID","EstDat" );
      ((Element)v.get(964)).appendChild((Element)v.get(981));
      /* Termina nodo:981   */

      /* Empieza nodo:982 / Elemento padre: 964   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(982)).setAttribute("tipo","texto" );
      ((Element)v.get(982)).setAttribute("ID","EstDat2" );
      ((Element)v.get(964)).appendChild((Element)v.get(982));
      /* Termina nodo:982   */

      /* Empieza nodo:983 / Elemento padre: 964   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(983)).setAttribute("tipo","texto" );
      ((Element)v.get(983)).setAttribute("ID","EstDat" );
      ((Element)v.get(964)).appendChild((Element)v.get(983));
      /* Termina nodo:983   */

      /* Empieza nodo:984 / Elemento padre: 964   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(984)).setAttribute("tipo","texto" );
      ((Element)v.get(984)).setAttribute("ID","EstDat2" );
      ((Element)v.get(964)).appendChild((Element)v.get(984));
      /* Termina nodo:984   */

      /* Empieza nodo:985 / Elemento padre: 964   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(985)).setAttribute("tipo","texto" );
      ((Element)v.get(985)).setAttribute("ID","EstDat" );
      ((Element)v.get(964)).appendChild((Element)v.get(985));
      /* Termina nodo:985   */

      /* Empieza nodo:986 / Elemento padre: 964   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(986)).setAttribute("tipo","texto" );
   }

   private void getXML4500(Document doc) {
      ((Element)v.get(986)).setAttribute("ID","EstDat2" );
      ((Element)v.get(964)).appendChild((Element)v.get(986));
      /* Termina nodo:986   */

      /* Empieza nodo:987 / Elemento padre: 964   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(987)).setAttribute("tipo","texto" );
      ((Element)v.get(987)).setAttribute("ID","EstDat" );
      ((Element)v.get(964)).appendChild((Element)v.get(987));
      /* Termina nodo:987   */

      /* Empieza nodo:988 / Elemento padre: 964   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(988)).setAttribute("tipo","texto" );
      ((Element)v.get(988)).setAttribute("ID","EstDat2" );
      ((Element)v.get(964)).appendChild((Element)v.get(988));
      /* Termina nodo:988   */

      /* Empieza nodo:989 / Elemento padre: 964   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(989)).setAttribute("tipo","texto" );
      ((Element)v.get(989)).setAttribute("ID","EstDat" );
      ((Element)v.get(964)).appendChild((Element)v.get(989));
      /* Termina nodo:989   */
      /* Termina nodo:964   */

      /* Empieza nodo:990 / Elemento padre: 904   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(904)).appendChild((Element)v.get(990));
      /* Termina nodo:990   */
      /* Termina nodo:904   */
      /* Termina nodo:903   */

      /* Empieza nodo:991 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(991)).setAttribute("nombre","carSoliEntrBloqListButtonsLayer" );
      ((Element)v.get(991)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(991)).setAttribute("alto","30" );
      ((Element)v.get(991)).setAttribute("ancho","98%" );
      ((Element)v.get(991)).setAttribute("borde","n" );
      ((Element)v.get(991)).setAttribute("imagenf","" );
      ((Element)v.get(991)).setAttribute("repeat","" );
      ((Element)v.get(991)).setAttribute("padding","0" );
      ((Element)v.get(991)).setAttribute("contravsb","" );
      ((Element)v.get(991)).setAttribute("x","16" );
      ((Element)v.get(991)).setAttribute("y","" );
      ((Element)v.get(991)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(991));

      /* Empieza nodo:992 / Elemento padre: 991   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(992)).setAttribute("width","100%" );
      ((Element)v.get(992)).setAttribute("border","0" );
      ((Element)v.get(992)).setAttribute("cellspacing","1" );
      ((Element)v.get(992)).setAttribute("cellpadding","0" );
      ((Element)v.get(992)).setAttribute("height","22" );
      ((Element)v.get(991)).appendChild((Element)v.get(992));

      /* Empieza nodo:993 / Elemento padre: 992   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(993)).setAttribute("class","tablaTitle" );
      ((Element)v.get(993)).setAttribute("nombre","carSoliEntrBloqUpdateButtonTd" );
      ((Element)v.get(992)).appendChild((Element)v.get(993));

      /* Empieza nodo:994 / Elemento padre: 993   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(994)).setAttribute("nombre","carSoliEntrBloqUpdateButton" );
      ((Element)v.get(994)).setAttribute("ID","botonContenido" );
      ((Element)v.get(994)).setAttribute("tipo","html" );
      ((Element)v.get(994)).setAttribute("accion","carSoliEntrBloqUpdateSelection();" );
      ((Element)v.get(994)).setAttribute("estado","false" );
      ((Element)v.get(994)).setAttribute("cod","MMGGlobal.updateButton.label" );
      ((Element)v.get(993)).appendChild((Element)v.get(994));
      /* Termina nodo:994   */
      /* Termina nodo:993   */

      /* Empieza nodo:995 / Elemento padre: 992   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(995)).setAttribute("nombre","carSoliEntrBloqUpdateButtonGapTd" );
      ((Element)v.get(992)).appendChild((Element)v.get(995));

      /* Empieza nodo:996 / Elemento padre: 995   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(996)).setAttribute("src","b.gif" );
      ((Element)v.get(996)).setAttribute("height","8" );
      ((Element)v.get(996)).setAttribute("width","10" );
      ((Element)v.get(995)).appendChild((Element)v.get(996));
      /* Termina nodo:996   */
      /* Termina nodo:995   */

      /* Empieza nodo:997 / Elemento padre: 992   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(997)).setAttribute("class","tablaTitle" );
      ((Element)v.get(997)).setAttribute("nombre","carSoliEntrBloqRemoveButtonTd" );
      ((Element)v.get(992)).appendChild((Element)v.get(997));

      /* Empieza nodo:998 / Elemento padre: 997   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(998)).setAttribute("nombre","carSoliEntrBloqRemoveButton" );
      ((Element)v.get(998)).setAttribute("ID","botonContenido" );
      ((Element)v.get(998)).setAttribute("tipo","html" );
      ((Element)v.get(998)).setAttribute("accion","carSoliEntrBloqRemoveSelection();" );
      ((Element)v.get(998)).setAttribute("estado","false" );
      ((Element)v.get(998)).setAttribute("cod","MMGGlobal.removeButton.label" );
      ((Element)v.get(997)).appendChild((Element)v.get(998));
      /* Termina nodo:998   */
      /* Termina nodo:997   */

      /* Empieza nodo:999 / Elemento padre: 992   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(999)).setAttribute("nombre","carSoliEntrBloqRemoveButtonGapTd" );
      ((Element)v.get(992)).appendChild((Element)v.get(999));

      /* Empieza nodo:1000 / Elemento padre: 999   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1000)).setAttribute("src","b.gif" );
      ((Element)v.get(1000)).setAttribute("height","8" );
      ((Element)v.get(1000)).setAttribute("width","10" );
      ((Element)v.get(999)).appendChild((Element)v.get(1000));
      /* Termina nodo:1000   */
      /* Termina nodo:999   */

      /* Empieza nodo:1001 / Elemento padre: 992   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1001)).setAttribute("class","tablaTitle" );
      ((Element)v.get(1001)).setAttribute("nombre","carSoliEntrBloqViewForRemoveButtonTd" );
      ((Element)v.get(992)).appendChild((Element)v.get(1001));

      /* Empieza nodo:1002 / Elemento padre: 1001   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1002)).setAttribute("nombre","carSoliEntrBloqViewForRemoveButton" );
      ((Element)v.get(1002)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1002)).setAttribute("tipo","html" );
      ((Element)v.get(1002)).setAttribute("accion","carSoliEntrBloqViewSelection();" );
      ((Element)v.get(1002)).setAttribute("estado","false" );
      ((Element)v.get(1002)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(1001)).appendChild((Element)v.get(1002));
      /* Termina nodo:1002   */
      /* Termina nodo:1001   */

      /* Empieza nodo:1003 / Elemento padre: 992   */
      v.add(doc.createElement("TD"));
   }

   private void getXML4590(Document doc) {
      ((Element)v.get(1003)).setAttribute("nombre","carSoliEntrBloqViewForRemoveButtonGapTd" );
      ((Element)v.get(992)).appendChild((Element)v.get(1003));

      /* Empieza nodo:1004 / Elemento padre: 1003   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1004)).setAttribute("src","b.gif" );
      ((Element)v.get(1004)).setAttribute("height","8" );
      ((Element)v.get(1004)).setAttribute("width","10" );
      ((Element)v.get(1003)).appendChild((Element)v.get(1004));
      /* Termina nodo:1004   */
      /* Termina nodo:1003   */

      /* Empieza nodo:1005 / Elemento padre: 992   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1005)).setAttribute("class","tablaTitle" );
      ((Element)v.get(1005)).setAttribute("nombre","carSoliEntrBloqLovSelectButtonTd" );
      ((Element)v.get(992)).appendChild((Element)v.get(1005));

      /* Empieza nodo:1006 / Elemento padre: 1005   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1006)).setAttribute("nombre","carSoliEntrBloqLovSelectButton" );
      ((Element)v.get(1006)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1006)).setAttribute("tipo","html" );
      ((Element)v.get(1006)).setAttribute("accion","carSoliEntrBloqLovSelectionAction();" );
      ((Element)v.get(1006)).setAttribute("estado","true" );
      ((Element)v.get(1006)).setAttribute("cod","MMGGlobal.lovSelectButton.label" );
      ((Element)v.get(1005)).appendChild((Element)v.get(1006));
      /* Termina nodo:1006   */
      /* Termina nodo:1005   */

      /* Empieza nodo:1007 / Elemento padre: 992   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1007)).setAttribute("nombre","carSoliEntrBloqLovSelectButtonGapTd" );
      ((Element)v.get(992)).appendChild((Element)v.get(1007));

      /* Empieza nodo:1008 / Elemento padre: 1007   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1008)).setAttribute("src","b.gif" );
      ((Element)v.get(1008)).setAttribute("height","8" );
      ((Element)v.get(1008)).setAttribute("width","10" );
      ((Element)v.get(1007)).appendChild((Element)v.get(1008));
      /* Termina nodo:1008   */
      /* Termina nodo:1007   */

      /* Empieza nodo:1009 / Elemento padre: 992   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1009)).setAttribute("class","tablaTitle" );
      ((Element)v.get(1009)).setAttribute("nombre","carSoliEntrBloqViewButtonTd" );
      ((Element)v.get(992)).appendChild((Element)v.get(1009));

      /* Empieza nodo:1010 / Elemento padre: 1009   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1010)).setAttribute("nombre","carSoliEntrBloqViewButton" );
      ((Element)v.get(1010)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1010)).setAttribute("tipo","html" );
      ((Element)v.get(1010)).setAttribute("accion","carSoliEntrBloqViewSelection();" );
      ((Element)v.get(1010)).setAttribute("estado","false" );
      ((Element)v.get(1010)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(1009)).appendChild((Element)v.get(1010));
      /* Termina nodo:1010   */
      /* Termina nodo:1009   */

      /* Empieza nodo:1011 / Elemento padre: 992   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1011)).setAttribute("nombre","carSoliEntrBloqViewButtonGapTd" );
      ((Element)v.get(992)).appendChild((Element)v.get(1011));

      /* Empieza nodo:1012 / Elemento padre: 1011   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1012)).setAttribute("src","b.gif" );
      ((Element)v.get(1012)).setAttribute("height","8" );
      ((Element)v.get(1012)).setAttribute("width","10" );
      ((Element)v.get(1011)).appendChild((Element)v.get(1012));
      /* Termina nodo:1012   */
      /* Termina nodo:1011   */

      /* Empieza nodo:1013 / Elemento padre: 992   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(992)).appendChild((Element)v.get(1013));

      /* Empieza nodo:1014 / Elemento padre: 1013   */
      v.add(doc.createElement("BOTONERA"));
      ((Element)v.get(1014)).setAttribute("nombre","carSoliEntrBloqPaginationButtonBar" );
      ((Element)v.get(1014)).setAttribute("tipo","H" );
      ((Element)v.get(1014)).setAttribute("x","0" );
      ((Element)v.get(1014)).setAttribute("y","0" );
      ((Element)v.get(1013)).appendChild((Element)v.get(1014));

      /* Empieza nodo:1015 / Elemento padre: 1014   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(1015)).setAttribute("nombre","carSoliEntrBloqFirstPageButton" );
      ((Element)v.get(1015)).setAttribute("funcion","carSoliEntrBloqFirstPage();" );
      ((Element)v.get(1015)).setAttribute("off","primera_over0.gif" );
      ((Element)v.get(1015)).setAttribute("on","primera_over0.gif" );
      ((Element)v.get(1015)).setAttribute("disable","primera_on0.gif" );
      ((Element)v.get(1015)).setAttribute("estado","inactivo" );
      ((Element)v.get(1014)).appendChild((Element)v.get(1015));
      /* Termina nodo:1015   */

      /* Empieza nodo:1016 / Elemento padre: 1014   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1016)).setAttribute("nombre","carSoliEntrBloqFirstPageButtonGapTd" );
      ((Element)v.get(1014)).appendChild((Element)v.get(1016));

      /* Empieza nodo:1017 / Elemento padre: 1016   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1017)).setAttribute("src","b.gif" );
      ((Element)v.get(1017)).setAttribute("height","8" );
      ((Element)v.get(1017)).setAttribute("width","8" );
      ((Element)v.get(1016)).appendChild((Element)v.get(1017));
      /* Termina nodo:1017   */
      /* Termina nodo:1016   */

      /* Empieza nodo:1018 / Elemento padre: 1014   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(1018)).setAttribute("nombre","carSoliEntrBloqPreviousPageButton" );
      ((Element)v.get(1018)).setAttribute("funcion","carSoliEntrBloqPreviousPage();" );
      ((Element)v.get(1018)).setAttribute("off","retroceder_over0.gif" );
      ((Element)v.get(1018)).setAttribute("on","retroceder_over0.gif" );
      ((Element)v.get(1018)).setAttribute("disable","retroceder_on0.gif" );
      ((Element)v.get(1018)).setAttribute("estado","inactivo" );
      ((Element)v.get(1014)).appendChild((Element)v.get(1018));
      /* Termina nodo:1018   */

      /* Empieza nodo:1019 / Elemento padre: 1014   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1019)).setAttribute("nombre","carSoliEntrBloqPreviousPageButtonGapTd" );
      ((Element)v.get(1014)).appendChild((Element)v.get(1019));

      /* Empieza nodo:1020 / Elemento padre: 1019   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1020)).setAttribute("src","b.gif" );
      ((Element)v.get(1020)).setAttribute("height","8" );
      ((Element)v.get(1020)).setAttribute("width","8" );
      ((Element)v.get(1019)).appendChild((Element)v.get(1020));
      /* Termina nodo:1020   */
      /* Termina nodo:1019   */

      /* Empieza nodo:1021 / Elemento padre: 1014   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(1021)).setAttribute("nombre","carSoliEntrBloqNextPageButton" );
      ((Element)v.get(1021)).setAttribute("funcion","carSoliEntrBloqNextPage();" );
   }

   private void getXML4680(Document doc) {
      ((Element)v.get(1021)).setAttribute("off","avanzar_over0.gif" );
      ((Element)v.get(1021)).setAttribute("on","avanzar_over0.gif" );
      ((Element)v.get(1021)).setAttribute("disable","avanzar_on0.gif" );
      ((Element)v.get(1021)).setAttribute("estado","inactivo" );
      ((Element)v.get(1014)).appendChild((Element)v.get(1021));
      /* Termina nodo:1021   */
      /* Termina nodo:1014   */
      /* Termina nodo:1013   */

      /* Empieza nodo:1022 / Elemento padre: 992   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1022)).setAttribute("width","100%" );
      ((Element)v.get(992)).appendChild((Element)v.get(1022));
      /* Termina nodo:1022   */
      /* Termina nodo:992   */
      /* Termina nodo:991   */
      /* Termina nodo:4   */


   }

}


import org.w3c.dom.*;
import java.util.ArrayList;

public class EduMatriCursoPage  implements es.indra.druida.base.ObjetoXML {
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
         

      getXML4770(doc);
         

      getXML4860(doc);
         

      getXML4950(doc);
         

      getXML5040(doc);
         

      getXML5130(doc);
         

      getXML5220(doc);
         

      getXML5310(doc);
         
      MgetXML0 (doc);
            
            return (Element)v.get(0);
            
}
   private void MgetXML0 (Document doc) {
            

      getXML5400(doc);
         

      getXML5490(doc);
         

      getXML5580(doc);
         

      getXML5670(doc);
         

      getXML5760(doc);
         

      getXML5850(doc);
         

      getXML5940(doc);
         

      getXML6030(doc);
         

      getXML6120(doc);
         

      getXML6210(doc);
         

      getXML6300(doc);
         

      getXML6390(doc);
         

      getXML6480(doc);
         

      getXML6570(doc);
         

      getXML6660(doc);
         

      getXML6750(doc);
         

      getXML6840(doc);
         

      getXML6930(doc);
         

      getXML7020(doc);
         

      getXML7110(doc);
         

      getXML7200(doc);
         

      getXML7290(doc);
         

      getXML7380(doc);
         
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","EduMatriCursoPage" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","eduMatriCursoInitComponents()" );
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
      ((Element)v.get(3)).setAttribute("src","edumatricurso.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(4)).setAttribute("nombre","eduMatriCursoFrm" );
      ((Element)v.get(4)).setAttribute("oculto","S" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(5)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(5)).setAttribute("valor","EduMatriCursoLPExecution" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","ON" );
      ((Element)v.get(6)).setAttribute("valor","EduMatriCursoLPExecution" );
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
      ((Element)v.get(24)).setAttribute("nombre","eduMatriCursoFormLayer" );
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
      ((Element)v.get(39)).setAttribute("cod","EduMatriCurso.legend.label" );
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
      ((Element)v.get(54)).setAttribute("cod","EduMatriCurso.id.label" );
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
      ((Element)v.get(57)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true)" );
      ((Element)v.get(57)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm', 0, false)" );
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
      ((Element)v.get(78)).setAttribute("nombre","paisOidPais_fopaOidFormPagoTdId" );
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
      ((Element)v.get(82)).setAttribute("nombre","lblpaisOidPais_fopaOidFormPago" );
      ((Element)v.get(82)).setAttribute("id","datosTitle" );
      ((Element)v.get(82)).setAttribute("ancho","100" );
      ((Element)v.get(82)).setAttribute("alto","13" );
      ((Element)v.get(82)).setAttribute("cod","SegPais.fopaOidFormPago.label" );
      ((Element)v.get(81)).appendChild((Element)v.get(82));
      /* Termina nodo:82   */
      /* Termina nodo:81   */
      /* Termina nodo:80   */

      /* Empieza nodo:83 / Elemento padre: 79   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(83)).setAttribute("nombre","paisOidPais_fopaOidFormPagoWidgetTrId" );
      ((Element)v.get(79)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(84)).setAttribute("align","left" );
      ((Element)v.get(84)).setAttribute("nowrap","true" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(85)).setAttribute("nombre","paisOidPais_fopaOidFormPago" );
      ((Element)v.get(85)).setAttribute("id","datosCampos" );
      ((Element)v.get(85)).setAttribute("multiple","N" );
      ((Element)v.get(85)).setAttribute("req","N" );
      ((Element)v.get(85)).setAttribute("size","1" );
      ((Element)v.get(85)).setAttribute("validacion","" );
      ((Element)v.get(85)).setAttribute("onchange","mmgDependeneChange('paisOidPais_fopaOidFormPago', 'paisOidPais' , 'eduMatriCurso')" );
      ((Element)v.get(85)).setAttribute("onfocus","" );
      ((Element)v.get(85)).setAttribute("valorinicial","" );
      ((Element)v.get(85)).setAttribute("textoinicial","" );
      ((Element)v.get(85)).setAttribute("ontab","focaliza('eduMatriCursoFrm.paisOidPais_moneOidMoneAlt');" );
      ((Element)v.get(85)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm',0, false);" );
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
      ((Element)v.get(87)).setAttribute("nombre","paisOidPais_fopaOidFormPagoViewLabelTrId" );
      ((Element)v.get(79)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(88)).setAttribute("valign","top" );
      ((Element)v.get(88)).setAttribute("height","13" );
      ((Element)v.get(88)).setAttribute("width","30" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(89)).setAttribute("nombre","lblViewPaisOidPais_fopaOidFormPago" );
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
      ((Element)v.get(92)).setAttribute("nombre","paisOidPais_moneOidMoneAltTdId" );
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
      ((Element)v.get(96)).setAttribute("nombre","lblpaisOidPais_moneOidMoneAlt" );
      ((Element)v.get(96)).setAttribute("id","datosTitle" );
      ((Element)v.get(96)).setAttribute("ancho","100" );
      ((Element)v.get(96)).setAttribute("alto","13" );
      ((Element)v.get(96)).setAttribute("cod","SegPais.moneOidMoneAlt.label" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */

      /* Empieza nodo:97 / Elemento padre: 93   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(97)).setAttribute("nombre","paisOidPais_moneOidMoneAltWidgetTrId" );
      ((Element)v.get(93)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(98)).setAttribute("align","left" );
      ((Element)v.get(98)).setAttribute("nowrap","true" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(99)).setAttribute("nombre","paisOidPais_moneOidMoneAlt" );
      ((Element)v.get(99)).setAttribute("id","datosCampos" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(99)).setAttribute("multiple","N" );
      ((Element)v.get(99)).setAttribute("req","N" );
      ((Element)v.get(99)).setAttribute("size","1" );
      ((Element)v.get(99)).setAttribute("validacion","" );
      ((Element)v.get(99)).setAttribute("onchange","mmgDependeneChange('paisOidPais_moneOidMoneAlt', 'paisOidPais' , 'eduMatriCurso')" );
      ((Element)v.get(99)).setAttribute("onfocus","" );
      ((Element)v.get(99)).setAttribute("valorinicial","" );
      ((Element)v.get(99)).setAttribute("textoinicial","" );
      ((Element)v.get(99)).setAttribute("ontab","focaliza('eduMatriCursoFrm.paisOidPais_moneOidMone');" );
      ((Element)v.get(99)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm',0, false);" );
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
      ((Element)v.get(101)).setAttribute("nombre","paisOidPais_moneOidMoneAltViewLabelTrId" );
      ((Element)v.get(93)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(102)).setAttribute("valign","top" );
      ((Element)v.get(102)).setAttribute("height","13" );
      ((Element)v.get(102)).setAttribute("width","30" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(103)).setAttribute("nombre","lblViewPaisOidPais_moneOidMoneAlt" );
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
      ((Element)v.get(106)).setAttribute("nombre","paisOidPais_moneOidMoneTdId" );
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
      ((Element)v.get(110)).setAttribute("nombre","lblpaisOidPais_moneOidMone" );
      ((Element)v.get(110)).setAttribute("id","datosTitle" );
      ((Element)v.get(110)).setAttribute("ancho","100" );
      ((Element)v.get(110)).setAttribute("alto","13" );
      ((Element)v.get(110)).setAttribute("cod","SegPais.moneOidMone.label" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:111 / Elemento padre: 107   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(111)).setAttribute("nombre","paisOidPais_moneOidMoneWidgetTrId" );
      ((Element)v.get(107)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(112)).setAttribute("align","left" );
      ((Element)v.get(112)).setAttribute("nowrap","true" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(113)).setAttribute("nombre","paisOidPais_moneOidMone" );
      ((Element)v.get(113)).setAttribute("id","datosCampos" );
      ((Element)v.get(113)).setAttribute("multiple","N" );
      ((Element)v.get(113)).setAttribute("req","N" );
      ((Element)v.get(113)).setAttribute("size","1" );
      ((Element)v.get(113)).setAttribute("validacion","" );
      ((Element)v.get(113)).setAttribute("onchange","mmgDependeneChange('paisOidPais_moneOidMone', 'paisOidPais' , 'eduMatriCurso')" );
      ((Element)v.get(113)).setAttribute("onfocus","" );
      ((Element)v.get(113)).setAttribute("valorinicial","" );
      ((Element)v.get(113)).setAttribute("textoinicial","" );
      ((Element)v.get(113)).setAttribute("ontab","focaliza('eduMatriCursoFrm.paisOidPais');" );
      ((Element)v.get(113)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm',0, false);" );
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
      ((Element)v.get(115)).setAttribute("nombre","paisOidPais_moneOidMoneViewLabelTrId" );
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
      ((Element)v.get(117)).setAttribute("nombre","lblViewPaisOidPais_moneOidMone" );
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
      ((Element)v.get(124)).setAttribute("cod","EduMatriCurso.paisOidPais.label" );
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
      ((Element)v.get(127)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true);" );
      ((Element)v.get(127)).setAttribute("onshtab","focaliza('eduMatriCursoFrm.paisOidPais_moneOidMone');" );
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
      ((Element)v.get(149)).setAttribute("nombre","cplcOidCabePlanCursTdId" );
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
      ((Element)v.get(153)).setAttribute("nombre","lblcplcOidCabePlanCurs" );
      ((Element)v.get(153)).setAttribute("id","datosTitle" );
      ((Element)v.get(153)).setAttribute("ancho","100" );
      ((Element)v.get(153)).setAttribute("alto","13" );
      ((Element)v.get(153)).setAttribute("cod","EduMatriCurso.cplcOidCabePlanCurs.label" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:154 / Elemento padre: 150   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(154)).setAttribute("nombre","cplcOidCabePlanCursWidgetTrId" );
      ((Element)v.get(150)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(155)).setAttribute("align","left" );
      ((Element)v.get(155)).setAttribute("nowrap","true" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(156)).setAttribute("nombre","cplcOidCabePlanCurs" );
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
      ((Element)v.get(156)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true);" );
      ((Element)v.get(156)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm',0, false);" );
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
      ((Element)v.get(158)).setAttribute("nombre","cplcOidCabePlanCursViewLabelTrId" );
      ((Element)v.get(150)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(159)).setAttribute("valign","top" );
      ((Element)v.get(159)).setAttribute("height","13" );
      ((Element)v.get(159)).setAttribute("width","50" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(160)).setAttribute("nombre","lblViewCplcOidCabePlanCurs" );
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
      ((Element)v.get(161)).setAttribute("nombre","cplcOidCabePlanCursGapTdId" );
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
      ((Element)v.get(178)).setAttribute("nombre","codCursTdId" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(179)).setAttribute("width","100%" );
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
      ((Element)v.get(182)).setAttribute("nombre","lblCodCurs" );
      ((Element)v.get(182)).setAttribute("alto","13" );
      ((Element)v.get(182)).setAttribute("filas","1" );
      ((Element)v.get(182)).setAttribute("id","datosTitle" );
      ((Element)v.get(182)).setAttribute("cod","EduMatriCurso.codCurs.label" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */
      /* Termina nodo:180   */

      /* Empieza nodo:183 / Elemento padre: 179   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(183)).setAttribute("nombre","codCursWidgetTrId" );
      ((Element)v.get(179)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(184)).setAttribute("align","left" );
      ((Element)v.get(184)).setAttribute("nowrap","true" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(185)).setAttribute("nombre","codCurs" );
      ((Element)v.get(185)).setAttribute("id","datosCampos" );
      ((Element)v.get(185)).setAttribute("trim","S" );
      ((Element)v.get(185)).setAttribute("max","3" );
      ((Element)v.get(185)).setAttribute("onchange","" );
      ((Element)v.get(185)).setAttribute("req","N" );
      ((Element)v.get(185)).setAttribute("size","3" );
      ((Element)v.get(185)).setAttribute("valor","" );
      ((Element)v.get(185)).setAttribute("validacion","" );
      ((Element)v.get(185)).setAttribute("onblur","" );
      ((Element)v.get(185)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true)" );
      ((Element)v.get(185)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm', 0, false)" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:186 / Elemento padre: 179   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(186)).setAttribute("nombre","codCursViewLabelTrId" );
      ((Element)v.get(179)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(187)).setAttribute("valign","top" );
      ((Element)v.get(187)).setAttribute("height","13" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(188)).setAttribute("nombre","lblViewCodCurs" );
      ((Element)v.get(188)).setAttribute("alto","13" );
      ((Element)v.get(188)).setAttribute("ancho","100" );
      ((Element)v.get(188)).setAttribute("id","EstDat" );
      ((Element)v.get(188)).setAttribute("valor","" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */
      /* Termina nodo:186   */
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:189 / Elemento padre: 177   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(189)).setAttribute("nombre","codCursGapTdId" );
      ((Element)v.get(189)).setAttribute("nowrap","true" );
      ((Element)v.get(189)).setAttribute("class","datosCampos" );
      ((Element)v.get(177)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","25" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */

      /* Empieza nodo:191 / Elemento padre: 177   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(191)).setAttribute("width","100%" );
      ((Element)v.get(177)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(192)).setAttribute("src","b.gif" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:175   */
      /* Termina nodo:172   */

      /* Empieza nodo:193 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(193)).setAttribute("nombre","formGapTr3" );
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
   }

   private void getXML900(Document doc) {
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
      ((Element)v.get(200)).setAttribute("nombre","formTr4" );
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
      ((Element)v.get(206)).setAttribute("nombre","terrOidTerrTdId" );
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
      ((Element)v.get(210)).setAttribute("nombre","lblterrOidTerr" );
      ((Element)v.get(210)).setAttribute("id","datosTitle" );
      ((Element)v.get(210)).setAttribute("ancho","100" );
      ((Element)v.get(210)).setAttribute("alto","13" );
      ((Element)v.get(210)).setAttribute("cod","EduMatriCurso.terrOidTerr.label" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:211 / Elemento padre: 207   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(211)).setAttribute("nombre","terrOidTerrWidgetTrId" );
      ((Element)v.get(207)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(212)).setAttribute("align","left" );
      ((Element)v.get(212)).setAttribute("nowrap","true" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(213)).setAttribute("nombre","terrOidTerr" );
      ((Element)v.get(213)).setAttribute("id","datosCampos" );
      ((Element)v.get(213)).setAttribute("multiple","N" );
      ((Element)v.get(213)).setAttribute("req","N" );
      ((Element)v.get(213)).setAttribute("size","1" );
      ((Element)v.get(213)).setAttribute("validacion","" );
      ((Element)v.get(213)).setAttribute("onchange","" );
      ((Element)v.get(213)).setAttribute("onfocus","" );
      ((Element)v.get(213)).setAttribute("valorinicial","" );
      ((Element)v.get(213)).setAttribute("textoinicial","" );
      ((Element)v.get(213)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true);" );
      ((Element)v.get(213)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm',0, false);" );
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
      ((Element)v.get(215)).setAttribute("nombre","terrOidTerrViewLabelTrId" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(207)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(216)).setAttribute("valign","top" );
      ((Element)v.get(216)).setAttribute("height","13" );
      ((Element)v.get(216)).setAttribute("width","50" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(217)).setAttribute("nombre","lblViewTerrOidTerr" );
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
      ((Element)v.get(218)).setAttribute("nombre","terrOidTerrGapTdId" );
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
      ((Element)v.get(235)).setAttribute("nombre","clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClieTdId" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(236)).setAttribute("border","0" );
      ((Element)v.get(236)).setAttribute("cellspacing","0" );
      ((Element)v.get(236)).setAttribute("cellpadding","0" );
      ((Element)v.get(236)).setAttribute("align","left" );
   }

   private void getXML1080(Document doc) {
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
      ((Element)v.get(239)).setAttribute("nombre","lblclasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie" );
      ((Element)v.get(239)).setAttribute("id","datosTitle" );
      ((Element)v.get(239)).setAttribute("ancho","100" );
      ((Element)v.get(239)).setAttribute("alto","13" );
      ((Element)v.get(239)).setAttribute("cod","MaeSubtiClien.ticlOidTipoClie.label" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:240 / Elemento padre: 236   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(240)).setAttribute("nombre","clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClieWidgetTrId" );
      ((Element)v.get(236)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(241)).setAttribute("align","left" );
      ((Element)v.get(241)).setAttribute("nowrap","true" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(242)).setAttribute("nombre","clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie" );
      ((Element)v.get(242)).setAttribute("id","datosCampos" );
      ((Element)v.get(242)).setAttribute("multiple","N" );
      ((Element)v.get(242)).setAttribute("req","N" );
      ((Element)v.get(242)).setAttribute("size","1" );
      ((Element)v.get(242)).setAttribute("validacion","" );
      ((Element)v.get(242)).setAttribute("onchange","mmgDependeneChange('clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie', 'clasOidClas' , 'eduMatriCurso')" );
      ((Element)v.get(242)).setAttribute("onfocus","" );
      ((Element)v.get(242)).setAttribute("valorinicial","" );
      ((Element)v.get(242)).setAttribute("textoinicial","" );
      ((Element)v.get(242)).setAttribute("ontab","focaliza('eduMatriCursoFrm.clasOidClas_tcclOidTipoClas_sbtiOidSubtClie');" );
      ((Element)v.get(242)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm',0, false);" );
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
      ((Element)v.get(244)).setAttribute("nombre","clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClieViewLabelTrId" );
      ((Element)v.get(236)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(245)).setAttribute("valign","top" );
      ((Element)v.get(245)).setAttribute("height","13" );
      ((Element)v.get(245)).setAttribute("width","40" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(246)).setAttribute("nombre","lblViewClasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie" );
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
      ((Element)v.get(247)).setAttribute("nombre","clasOidClasGapTdId" );
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
      ((Element)v.get(249)).setAttribute("nombre","clasOidClas_tcclOidTipoClas_sbtiOidSubtClieTdId" );
      ((Element)v.get(234)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(250)).setAttribute("border","0" );
      ((Element)v.get(250)).setAttribute("cellspacing","0" );
      ((Element)v.get(250)).setAttribute("cellpadding","0" );
      ((Element)v.get(250)).setAttribute("align","left" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(250)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(252)).setAttribute("valign","top" );
      ((Element)v.get(252)).setAttribute("height","13" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(253)).setAttribute("nombre","lblclasOidClas_tcclOidTipoClas_sbtiOidSubtClie" );
      ((Element)v.get(253)).setAttribute("id","datosTitle" );
      ((Element)v.get(253)).setAttribute("ancho","100" );
      ((Element)v.get(253)).setAttribute("alto","13" );
      ((Element)v.get(253)).setAttribute("cod","MaeTipoClasiClien.sbtiOidSubtClie.label" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */
      /* Termina nodo:251   */

      /* Empieza nodo:254 / Elemento padre: 250   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(254)).setAttribute("nombre","clasOidClas_tcclOidTipoClas_sbtiOidSubtClieWidgetTrId" );
      ((Element)v.get(250)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(255)).setAttribute("align","left" );
      ((Element)v.get(255)).setAttribute("nowrap","true" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(254)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(256)).setAttribute("nombre","clasOidClas_tcclOidTipoClas_sbtiOidSubtClie" );
      ((Element)v.get(256)).setAttribute("id","datosCampos" );
      ((Element)v.get(256)).setAttribute("multiple","N" );
      ((Element)v.get(256)).setAttribute("req","N" );
      ((Element)v.get(256)).setAttribute("size","1" );
      ((Element)v.get(256)).setAttribute("validacion","" );
      ((Element)v.get(256)).setAttribute("onchange","mmgDependeneChange('clasOidClas_tcclOidTipoClas_sbtiOidSubtClie', 'clasOidClas' , 'eduMatriCurso')" );
      ((Element)v.get(256)).setAttribute("onfocus","" );
      ((Element)v.get(256)).setAttribute("valorinicial","" );
      ((Element)v.get(256)).setAttribute("textoinicial","" );
      ((Element)v.get(256)).setAttribute("ontab","focaliza('eduMatriCursoFrm.clasOidClas_tcclOidTipoClas');" );
      ((Element)v.get(256)).setAttribute("onshtab","focaliza('eduMatriCursoFrm.clasOidClas_tcclOidTipoClas_sbtiOidSubtClie_ticlOidTipoClie');" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:255   */
      /* Termina nodo:254   */

      /* Empieza nodo:258 / Elemento padre: 250   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(258)).setAttribute("nombre","clasOidClas_tcclOidTipoClas_sbtiOidSubtClieViewLabelTrId" );
      ((Element)v.get(250)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(259)).setAttribute("valign","top" );
      ((Element)v.get(259)).setAttribute("height","13" );
      ((Element)v.get(259)).setAttribute("width","40" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(260)).setAttribute("nombre","lblViewClasOidClas_tcclOidTipoClas_sbtiOidSubtClie" );
      ((Element)v.get(260)).setAttribute("alto","13" );
      ((Element)v.get(260)).setAttribute("filas","1" );
      ((Element)v.get(260)).setAttribute("id","EstDat" );
      ((Element)v.get(260)).setAttribute("valor","" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */
      /* Termina nodo:258   */
      /* Termina nodo:250   */
      /* Termina nodo:249   */

      /* Empieza nodo:261 / Elemento padre: 234   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(261)).setAttribute("nombre","clasOidClasGapTdId" );
      ((Element)v.get(261)).setAttribute("nowrap","true" );
      ((Element)v.get(261)).setAttribute("class","datosCampos" );
      ((Element)v.get(234)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(262)).setAttribute("src","b.gif" );
      ((Element)v.get(262)).setAttribute("width","25" );
      ((Element)v.get(262)).setAttribute("height","8" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */

      /* Empieza nodo:263 / Elemento padre: 234   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(263)).setAttribute("nombre","clasOidClas_tcclOidTipoClasTdId" );
      ((Element)v.get(234)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("TABLE"));
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
      ((Element)v.get(267)).setAttribute("nombre","lblclasOidClas_tcclOidTipoClas" );
      ((Element)v.get(267)).setAttribute("id","datosTitle" );
      ((Element)v.get(267)).setAttribute("ancho","100" );
      ((Element)v.get(267)).setAttribute("alto","13" );
      ((Element)v.get(267)).setAttribute("cod","MaeClasi.tcclOidTipoClas.label" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */
      /* Termina nodo:265   */

      /* Empieza nodo:268 / Elemento padre: 264   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(268)).setAttribute("nombre","clasOidClas_tcclOidTipoClasWidgetTrId" );
      ((Element)v.get(264)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(269)).setAttribute("align","left" );
      ((Element)v.get(269)).setAttribute("nowrap","true" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(270)).setAttribute("nombre","clasOidClas_tcclOidTipoClas" );
      ((Element)v.get(270)).setAttribute("id","datosCampos" );
      ((Element)v.get(270)).setAttribute("multiple","N" );
      ((Element)v.get(270)).setAttribute("req","N" );
      ((Element)v.get(270)).setAttribute("size","1" );
      ((Element)v.get(270)).setAttribute("validacion","" );
      ((Element)v.get(270)).setAttribute("onchange","mmgDependeneChange('clasOidClas_tcclOidTipoClas', 'clasOidClas' , 'eduMatriCurso')" );
      ((Element)v.get(270)).setAttribute("onfocus","" );
      ((Element)v.get(270)).setAttribute("valorinicial","" );
      ((Element)v.get(270)).setAttribute("textoinicial","" );
      ((Element)v.get(270)).setAttribute("ontab","focaliza('eduMatriCursoFrm.clasOidClas');" );
      ((Element)v.get(270)).setAttribute("onshtab","focaliza('eduMatriCursoFrm.clasOidClas_tcclOidTipoClas_sbtiOidSubtClie');" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */
      /* Termina nodo:269   */
      /* Termina nodo:268   */

      /* Empieza nodo:272 / Elemento padre: 264   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(272)).setAttribute("nombre","clasOidClas_tcclOidTipoClasViewLabelTrId" );
      ((Element)v.get(264)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
   }

   private void getXML1260(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(273)).setAttribute("valign","top" );
      ((Element)v.get(273)).setAttribute("height","13" );
      ((Element)v.get(273)).setAttribute("width","40" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(274)).setAttribute("nombre","lblViewClasOidClas_tcclOidTipoClas" );
      ((Element)v.get(274)).setAttribute("alto","13" );
      ((Element)v.get(274)).setAttribute("filas","1" );
      ((Element)v.get(274)).setAttribute("id","EstDat" );
      ((Element)v.get(274)).setAttribute("valor","" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */
      /* Termina nodo:272   */
      /* Termina nodo:264   */
      /* Termina nodo:263   */

      /* Empieza nodo:275 / Elemento padre: 234   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(275)).setAttribute("nombre","clasOidClasGapTdId" );
      ((Element)v.get(275)).setAttribute("nowrap","true" );
      ((Element)v.get(275)).setAttribute("class","datosCampos" );
      ((Element)v.get(234)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(276)).setAttribute("src","b.gif" );
      ((Element)v.get(276)).setAttribute("width","25" );
      ((Element)v.get(276)).setAttribute("height","8" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));
      /* Termina nodo:276   */
      /* Termina nodo:275   */

      /* Empieza nodo:277 / Elemento padre: 234   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(277)).setAttribute("nombre","clasOidClasTdId" );
      ((Element)v.get(234)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(278)).setAttribute("border","0" );
      ((Element)v.get(278)).setAttribute("cellspacing","0" );
      ((Element)v.get(278)).setAttribute("cellpadding","0" );
      ((Element)v.get(278)).setAttribute("align","left" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(278)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(280)).setAttribute("valign","top" );
      ((Element)v.get(280)).setAttribute("height","13" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(281)).setAttribute("nombre","lblclasOidClas" );
      ((Element)v.get(281)).setAttribute("id","datosTitle" );
      ((Element)v.get(281)).setAttribute("ancho","100" );
      ((Element)v.get(281)).setAttribute("alto","13" );
      ((Element)v.get(281)).setAttribute("cod","EduMatriCurso.clasOidClas.label" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:280   */
      /* Termina nodo:279   */

      /* Empieza nodo:282 / Elemento padre: 278   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(282)).setAttribute("nombre","clasOidClasWidgetTrId" );
      ((Element)v.get(278)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(283)).setAttribute("align","left" );
      ((Element)v.get(283)).setAttribute("nowrap","true" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(284)).setAttribute("nombre","clasOidClas" );
      ((Element)v.get(284)).setAttribute("id","datosCampos" );
      ((Element)v.get(284)).setAttribute("multiple","N" );
      ((Element)v.get(284)).setAttribute("req","N" );
      ((Element)v.get(284)).setAttribute("size","1" );
      ((Element)v.get(284)).setAttribute("validacion","" );
      ((Element)v.get(284)).setAttribute("onchange","" );
      ((Element)v.get(284)).setAttribute("onfocus","" );
      ((Element)v.get(284)).setAttribute("valorinicial","" );
      ((Element)v.get(284)).setAttribute("textoinicial","" );
      ((Element)v.get(284)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true);" );
      ((Element)v.get(284)).setAttribute("onshtab","focaliza('eduMatriCursoFrm.clasOidClas_tcclOidTipoClas');" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */
      /* Termina nodo:283   */
      /* Termina nodo:282   */

      /* Empieza nodo:286 / Elemento padre: 278   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(286)).setAttribute("nombre","clasOidClasViewLabelTrId" );
      ((Element)v.get(278)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(287)).setAttribute("valign","top" );
      ((Element)v.get(287)).setAttribute("height","13" );
      ((Element)v.get(287)).setAttribute("width","40" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(288)).setAttribute("nombre","lblViewClasOidClas" );
      ((Element)v.get(288)).setAttribute("alto","13" );
      ((Element)v.get(288)).setAttribute("filas","1" );
      ((Element)v.get(288)).setAttribute("id","EstDat" );
      ((Element)v.get(288)).setAttribute("valor","" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:287   */
      /* Termina nodo:286   */
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:289 / Elemento padre: 234   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(289)).setAttribute("nombre","clasOidClasGapTdId" );
      ((Element)v.get(289)).setAttribute("nowrap","true" );
      ((Element)v.get(289)).setAttribute("class","datosCampos" );
      ((Element)v.get(234)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(290)).setAttribute("src","b.gif" );
      ((Element)v.get(290)).setAttribute("width","25" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(290)).setAttribute("height","8" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */
      /* Termina nodo:289   */

      /* Empieza nodo:291 / Elemento padre: 234   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(291)).setAttribute("width","100%" );
      ((Element)v.get(234)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(292)).setAttribute("src","b.gif" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:291   */
      /* Termina nodo:234   */
      /* Termina nodo:233   */
      /* Termina nodo:232   */
      /* Termina nodo:229   */

      /* Empieza nodo:293 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(293)).setAttribute("nombre","formGapTr5" );
      ((Element)v.get(40)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(294)).setAttribute("align","center" );
      ((Element)v.get(294)).setAttribute("width","12" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(295)).setAttribute("src","b.gif" );
      ((Element)v.get(295)).setAttribute("width","12" );
      ((Element)v.get(295)).setAttribute("height","8" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */

      /* Empieza nodo:296 / Elemento padre: 293   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(293)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(297)).setAttribute("src","b.gif" );
      ((Element)v.get(297)).setAttribute("width","8" );
      ((Element)v.get(297)).setAttribute("height","8" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:296   */

      /* Empieza nodo:298 / Elemento padre: 293   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(298)).setAttribute("align","center" );
      ((Element)v.get(298)).setAttribute("width","12" );
      ((Element)v.get(293)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(299)).setAttribute("src","b.gif" );
      ((Element)v.get(299)).setAttribute("width","12" );
      ((Element)v.get(299)).setAttribute("height","8" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */
      /* Termina nodo:293   */

      /* Empieza nodo:300 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(300)).setAttribute("nombre","formTr6" );
      ((Element)v.get(40)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(301)).setAttribute("align","center" );
      ((Element)v.get(301)).setAttribute("width","12" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(302)).setAttribute("src","b.gif" );
      ((Element)v.get(302)).setAttribute("width","12" );
      ((Element)v.get(302)).setAttribute("height","12" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:303 / Elemento padre: 300   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(303)).setAttribute("width","100%" );
      ((Element)v.get(300)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(304)).setAttribute("width","100%" );
      ((Element)v.get(304)).setAttribute("border","0" );
      ((Element)v.get(304)).setAttribute("cellspacing","0" );
      ((Element)v.get(304)).setAttribute("cellpadding","0" );
      ((Element)v.get(304)).setAttribute("align","left" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(305)).setAttribute("align","left" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(306)).setAttribute("nombre","frcuOidFrecTdId" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(307)).setAttribute("border","0" );
      ((Element)v.get(307)).setAttribute("cellspacing","0" );
      ((Element)v.get(307)).setAttribute("cellpadding","0" );
      ((Element)v.get(307)).setAttribute("align","left" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(307)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(309)).setAttribute("valign","top" );
      ((Element)v.get(309)).setAttribute("height","13" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(310)).setAttribute("nombre","lblfrcuOidFrec" );
      ((Element)v.get(310)).setAttribute("id","datosTitle" );
      ((Element)v.get(310)).setAttribute("ancho","100" );
      ((Element)v.get(310)).setAttribute("alto","13" );
      ((Element)v.get(310)).setAttribute("cod","EduMatriCurso.frcuOidFrec.label" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */
      /* Termina nodo:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:311 / Elemento padre: 307   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(311)).setAttribute("nombre","frcuOidFrecWidgetTrId" );
      ((Element)v.get(307)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(312)).setAttribute("align","left" );
      ((Element)v.get(312)).setAttribute("nowrap","true" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
   }

   private void getXML1440(Document doc) {
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(313)).setAttribute("nombre","frcuOidFrec" );
      ((Element)v.get(313)).setAttribute("id","datosCampos" );
      ((Element)v.get(313)).setAttribute("multiple","N" );
      ((Element)v.get(313)).setAttribute("req","N" );
      ((Element)v.get(313)).setAttribute("size","1" );
      ((Element)v.get(313)).setAttribute("validacion","" );
      ((Element)v.get(313)).setAttribute("onchange","" );
      ((Element)v.get(313)).setAttribute("onfocus","" );
      ((Element)v.get(313)).setAttribute("valorinicial","" );
      ((Element)v.get(313)).setAttribute("textoinicial","" );
      ((Element)v.get(313)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true);" );
      ((Element)v.get(313)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm',0, false);" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */
      /* Termina nodo:312   */
      /* Termina nodo:311   */

      /* Empieza nodo:315 / Elemento padre: 307   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(315)).setAttribute("nombre","frcuOidFrecViewLabelTrId" );
      ((Element)v.get(307)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(316)).setAttribute("valign","top" );
      ((Element)v.get(316)).setAttribute("height","13" );
      ((Element)v.get(316)).setAttribute("width","50" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(317)).setAttribute("nombre","lblViewFrcuOidFrec" );
      ((Element)v.get(317)).setAttribute("alto","13" );
      ((Element)v.get(317)).setAttribute("filas","1" );
      ((Element)v.get(317)).setAttribute("id","EstDat" );
      ((Element)v.get(317)).setAttribute("valor","" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:316   */
      /* Termina nodo:315   */
      /* Termina nodo:307   */
      /* Termina nodo:306   */

      /* Empieza nodo:318 / Elemento padre: 305   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(318)).setAttribute("nombre","frcuOidFrecGapTdId" );
      ((Element)v.get(318)).setAttribute("nowrap","true" );
      ((Element)v.get(318)).setAttribute("class","datosCampos" );
      ((Element)v.get(305)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(319)).setAttribute("src","b.gif" );
      ((Element)v.get(319)).setAttribute("width","25" );
      ((Element)v.get(319)).setAttribute("height","8" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */
      /* Termina nodo:318   */

      /* Empieza nodo:320 / Elemento padre: 305   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(320)).setAttribute("width","100%" );
      ((Element)v.get(305)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(321)).setAttribute("src","b.gif" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */
      /* Termina nodo:320   */
      /* Termina nodo:305   */
      /* Termina nodo:304   */
      /* Termina nodo:303   */
      /* Termina nodo:300   */

      /* Empieza nodo:322 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(322)).setAttribute("nombre","formGapTr6" );
      ((Element)v.get(40)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(323)).setAttribute("align","center" );
      ((Element)v.get(323)).setAttribute("width","12" );
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
      ((Element)v.get(327)).setAttribute("width","12" );
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

      /* Empieza nodo:329 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(329)).setAttribute("nombre","formTr7" );
      ((Element)v.get(40)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(330)).setAttribute("align","center" );
      ((Element)v.get(330)).setAttribute("width","12" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(331)).setAttribute("src","b.gif" );
      ((Element)v.get(331)).setAttribute("width","12" );
      ((Element)v.get(331)).setAttribute("height","12" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */

      /* Empieza nodo:332 / Elemento padre: 329   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(332)).setAttribute("width","100%" );
      ((Element)v.get(329)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
   }

   private void getXML1530(Document doc) {
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
      ((Element)v.get(335)).setAttribute("nombre","regaOidRega_prodOidProdTdId" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(336)).setAttribute("border","0" );
      ((Element)v.get(336)).setAttribute("cellspacing","0" );
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
      ((Element)v.get(339)).setAttribute("nombre","lblregaOidRega_prodOidProd" );
      ((Element)v.get(339)).setAttribute("id","datosTitle" );
      ((Element)v.get(339)).setAttribute("ancho","100" );
      ((Element)v.get(339)).setAttribute("alto","13" );
      ((Element)v.get(339)).setAttribute("cod","EduRegal.prodOidProd.label" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */
      /* Termina nodo:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:340 / Elemento padre: 336   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(340)).setAttribute("nombre","regaOidRega_prodOidProdWidgetTrId" );
      ((Element)v.get(336)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(341)).setAttribute("align","left" );
      ((Element)v.get(341)).setAttribute("nowrap","true" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(342)).setAttribute("nombre","regaOidRega_prodOidProd" );
      ((Element)v.get(342)).setAttribute("id","datosCampos" );
      ((Element)v.get(342)).setAttribute("multiple","N" );
      ((Element)v.get(342)).setAttribute("req","N" );
      ((Element)v.get(342)).setAttribute("size","1" );
      ((Element)v.get(342)).setAttribute("validacion","" );
      ((Element)v.get(342)).setAttribute("onchange","mmgDependeneChange('regaOidRega_prodOidProd', 'regaOidRega' , 'eduMatriCurso')" );
      ((Element)v.get(342)).setAttribute("onfocus","" );
      ((Element)v.get(342)).setAttribute("valorinicial","" );
      ((Element)v.get(342)).setAttribute("textoinicial","" );
      ((Element)v.get(342)).setAttribute("ontab","focaliza('eduMatriCursoFrm.regaOidRega');" );
      ((Element)v.get(342)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm',0, false);" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */
      /* Termina nodo:342   */
      /* Termina nodo:341   */
      /* Termina nodo:340   */

      /* Empieza nodo:344 / Elemento padre: 336   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(344)).setAttribute("nombre","regaOidRega_prodOidProdViewLabelTrId" );
      ((Element)v.get(336)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(345)).setAttribute("valign","top" );
      ((Element)v.get(345)).setAttribute("height","13" );
      ((Element)v.get(345)).setAttribute("width","40" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(346)).setAttribute("nombre","lblViewRegaOidRega_prodOidProd" );
      ((Element)v.get(346)).setAttribute("alto","13" );
      ((Element)v.get(346)).setAttribute("filas","1" );
      ((Element)v.get(346)).setAttribute("id","EstDat" );
      ((Element)v.get(346)).setAttribute("valor","" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:345   */
      /* Termina nodo:344   */
      /* Termina nodo:336   */
      /* Termina nodo:335   */

      /* Empieza nodo:347 / Elemento padre: 334   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(347)).setAttribute("nombre","regaOidRegaGapTdId" );
      ((Element)v.get(347)).setAttribute("nowrap","true" );
      ((Element)v.get(347)).setAttribute("class","datosCampos" );
      ((Element)v.get(334)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(348)).setAttribute("src","b.gif" );
      ((Element)v.get(348)).setAttribute("width","25" );
      ((Element)v.get(348)).setAttribute("height","8" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:347   */

      /* Empieza nodo:349 / Elemento padre: 334   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(349)).setAttribute("nombre","regaOidRegaTdId" );
      ((Element)v.get(334)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(350)).setAttribute("border","0" );
      ((Element)v.get(350)).setAttribute("cellspacing","0" );
      ((Element)v.get(350)).setAttribute("cellpadding","0" );
      ((Element)v.get(350)).setAttribute("align","left" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("TR"));
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(350)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(352)).setAttribute("valign","top" );
      ((Element)v.get(352)).setAttribute("height","13" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(353)).setAttribute("nombre","lblregaOidRega" );
      ((Element)v.get(353)).setAttribute("id","datosTitle" );
      ((Element)v.get(353)).setAttribute("ancho","100" );
      ((Element)v.get(353)).setAttribute("alto","13" );
      ((Element)v.get(353)).setAttribute("cod","EduMatriCurso.regaOidRega.label" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */
      /* Termina nodo:352   */
      /* Termina nodo:351   */

      /* Empieza nodo:354 / Elemento padre: 350   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(354)).setAttribute("nombre","regaOidRegaWidgetTrId" );
      ((Element)v.get(350)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(355)).setAttribute("align","left" );
      ((Element)v.get(355)).setAttribute("nowrap","true" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(356)).setAttribute("nombre","regaOidRega" );
      ((Element)v.get(356)).setAttribute("id","datosCampos" );
      ((Element)v.get(356)).setAttribute("multiple","N" );
      ((Element)v.get(356)).setAttribute("req","N" );
      ((Element)v.get(356)).setAttribute("size","1" );
      ((Element)v.get(356)).setAttribute("validacion","" );
      ((Element)v.get(356)).setAttribute("onchange","" );
      ((Element)v.get(356)).setAttribute("onfocus","" );
      ((Element)v.get(356)).setAttribute("valorinicial","" );
      ((Element)v.get(356)).setAttribute("textoinicial","" );
      ((Element)v.get(356)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true);" );
      ((Element)v.get(356)).setAttribute("onshtab","focaliza('eduMatriCursoFrm.regaOidRega_prodOidProd');" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */
      /* Termina nodo:355   */
      /* Termina nodo:354   */

      /* Empieza nodo:358 / Elemento padre: 350   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(358)).setAttribute("nombre","regaOidRegaViewLabelTrId" );
      ((Element)v.get(350)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(359)).setAttribute("valign","top" );
      ((Element)v.get(359)).setAttribute("height","13" );
      ((Element)v.get(359)).setAttribute("width","40" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(360)).setAttribute("nombre","lblViewRegaOidRega" );
      ((Element)v.get(360)).setAttribute("alto","13" );
      ((Element)v.get(360)).setAttribute("filas","1" );
      ((Element)v.get(360)).setAttribute("id","EstDat" );
      ((Element)v.get(360)).setAttribute("valor","" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:359   */
      /* Termina nodo:358   */
      /* Termina nodo:350   */
      /* Termina nodo:349   */

      /* Empieza nodo:361 / Elemento padre: 334   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(361)).setAttribute("nombre","regaOidRegaGapTdId" );
      ((Element)v.get(361)).setAttribute("nowrap","true" );
      ((Element)v.get(361)).setAttribute("class","datosCampos" );
      ((Element)v.get(334)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(362)).setAttribute("src","b.gif" );
      ((Element)v.get(362)).setAttribute("width","25" );
      ((Element)v.get(362)).setAttribute("height","8" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:361   */

      /* Empieza nodo:363 / Elemento padre: 334   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(363)).setAttribute("width","100%" );
      ((Element)v.get(334)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(364)).setAttribute("src","b.gif" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */
      /* Termina nodo:363   */
      /* Termina nodo:334   */
      /* Termina nodo:333   */
      /* Termina nodo:332   */
      /* Termina nodo:329   */

      /* Empieza nodo:365 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(365)).setAttribute("nombre","formGapTr7" );
      ((Element)v.get(40)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(366)).setAttribute("align","center" );
      ((Element)v.get(366)).setAttribute("width","12" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(367)).setAttribute("src","b.gif" );
      ((Element)v.get(367)).setAttribute("width","12" );
      ((Element)v.get(367)).setAttribute("height","8" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */
      /* Termina nodo:366   */

      /* Empieza nodo:368 / Elemento padre: 365   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(365)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(369)).setAttribute("src","b.gif" );
      ((Element)v.get(369)).setAttribute("width","8" );
      ((Element)v.get(369)).setAttribute("height","8" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */

      /* Empieza nodo:370 / Elemento padre: 365   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(370)).setAttribute("align","center" );
      ((Element)v.get(370)).setAttribute("width","12" );
      ((Element)v.get(365)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(371)).setAttribute("src","b.gif" );
      ((Element)v.get(371)).setAttribute("width","12" );
      ((Element)v.get(371)).setAttribute("height","8" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));
      /* Termina nodo:371   */
      /* Termina nodo:370   */
      /* Termina nodo:365   */

      /* Empieza nodo:372 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(372)).setAttribute("nombre","formTr8" );
      ((Element)v.get(40)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(373)).setAttribute("align","center" );
      ((Element)v.get(373)).setAttribute("width","12" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(374)).setAttribute("src","b.gif" );
      ((Element)v.get(374)).setAttribute("width","12" );
      ((Element)v.get(374)).setAttribute("height","12" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */
      /* Termina nodo:373   */

      /* Empieza nodo:375 / Elemento padre: 372   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(375)).setAttribute("width","100%" );
      ((Element)v.get(372)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(376)).setAttribute("width","100%" );
      ((Element)v.get(376)).setAttribute("border","0" );
      ((Element)v.get(376)).setAttribute("cellspacing","0" );
      ((Element)v.get(376)).setAttribute("cellpadding","0" );
      ((Element)v.get(376)).setAttribute("align","left" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(377)).setAttribute("align","left" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(378)).setAttribute("nombre","zsgvOidSubgVentTdId" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(379)).setAttribute("border","0" );
      ((Element)v.get(379)).setAttribute("cellspacing","0" );
      ((Element)v.get(379)).setAttribute("cellpadding","0" );
      ((Element)v.get(379)).setAttribute("align","left" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(379)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(381)).setAttribute("valign","top" );
      ((Element)v.get(381)).setAttribute("height","13" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(382)).setAttribute("nombre","lblzsgvOidSubgVent" );
      ((Element)v.get(382)).setAttribute("id","datosTitle" );
      ((Element)v.get(382)).setAttribute("ancho","100" );
      ((Element)v.get(382)).setAttribute("alto","13" );
      ((Element)v.get(382)).setAttribute("cod","EduMatriCurso.zsgvOidSubgVent.label" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */
      /* Termina nodo:381   */
      /* Termina nodo:380   */

      /* Empieza nodo:383 / Elemento padre: 379   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(383)).setAttribute("nombre","zsgvOidSubgVentWidgetTrId" );
      ((Element)v.get(379)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(384)).setAttribute("align","left" );
      ((Element)v.get(384)).setAttribute("nowrap","true" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(385)).setAttribute("nombre","zsgvOidSubgVent" );
      ((Element)v.get(385)).setAttribute("id","datosCampos" );
      ((Element)v.get(385)).setAttribute("multiple","N" );
      ((Element)v.get(385)).setAttribute("req","N" );
      ((Element)v.get(385)).setAttribute("size","1" );
      ((Element)v.get(385)).setAttribute("validacion","" );
      ((Element)v.get(385)).setAttribute("onchange","" );
      ((Element)v.get(385)).setAttribute("onfocus","" );
      ((Element)v.get(385)).setAttribute("valorinicial","" );
      ((Element)v.get(385)).setAttribute("textoinicial","" );
      ((Element)v.get(385)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true);" );
      ((Element)v.get(385)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm',0, false);" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(385)).appendChild((Element)v.get(386));
      /* Termina nodo:386   */
      /* Termina nodo:385   */
      /* Termina nodo:384   */
      /* Termina nodo:383   */

      /* Empieza nodo:387 / Elemento padre: 379   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(387)).setAttribute("nombre","zsgvOidSubgVentViewLabelTrId" );
      ((Element)v.get(379)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(388)).setAttribute("valign","top" );
      ((Element)v.get(388)).setAttribute("height","13" );
      ((Element)v.get(388)).setAttribute("width","50" );
      ((Element)v.get(387)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(389)).setAttribute("nombre","lblViewZsgvOidSubgVent" );
      ((Element)v.get(389)).setAttribute("alto","13" );
      ((Element)v.get(389)).setAttribute("filas","1" );
      ((Element)v.get(389)).setAttribute("id","EstDat" );
      ((Element)v.get(389)).setAttribute("valor","" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:388   */
      /* Termina nodo:387   */
      /* Termina nodo:379   */
      /* Termina nodo:378   */

      /* Empieza nodo:390 / Elemento padre: 377   */
      v.add(doc.createElement("TD"));
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(390)).setAttribute("nombre","zsgvOidSubgVentGapTdId" );
      ((Element)v.get(390)).setAttribute("nowrap","true" );
      ((Element)v.get(390)).setAttribute("class","datosCampos" );
      ((Element)v.get(377)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(391)).setAttribute("src","b.gif" );
      ((Element)v.get(391)).setAttribute("width","25" );
      ((Element)v.get(391)).setAttribute("height","8" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */
      /* Termina nodo:390   */

      /* Empieza nodo:392 / Elemento padre: 377   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(392)).setAttribute("width","100%" );
      ((Element)v.get(377)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(393)).setAttribute("src","b.gif" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));
      /* Termina nodo:393   */
      /* Termina nodo:392   */
      /* Termina nodo:377   */
      /* Termina nodo:376   */
      /* Termina nodo:375   */
      /* Termina nodo:372   */

      /* Empieza nodo:394 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(394)).setAttribute("nombre","formGapTr8" );
      ((Element)v.get(40)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(395)).setAttribute("align","center" );
      ((Element)v.get(395)).setAttribute("width","12" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(396)).setAttribute("src","b.gif" );
      ((Element)v.get(396)).setAttribute("width","12" );
      ((Element)v.get(396)).setAttribute("height","8" );
      ((Element)v.get(395)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */
      /* Termina nodo:395   */

      /* Empieza nodo:397 / Elemento padre: 394   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(394)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(398)).setAttribute("src","b.gif" );
      ((Element)v.get(398)).setAttribute("width","8" );
      ((Element)v.get(398)).setAttribute("height","8" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */
      /* Termina nodo:397   */

      /* Empieza nodo:399 / Elemento padre: 394   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(399)).setAttribute("align","center" );
      ((Element)v.get(399)).setAttribute("width","12" );
      ((Element)v.get(394)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(400)).setAttribute("src","b.gif" );
      ((Element)v.get(400)).setAttribute("width","12" );
      ((Element)v.get(400)).setAttribute("height","8" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));
      /* Termina nodo:400   */
      /* Termina nodo:399   */
      /* Termina nodo:394   */

      /* Empieza nodo:401 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(401)).setAttribute("nombre","formTr9" );
      ((Element)v.get(40)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(402)).setAttribute("align","center" );
      ((Element)v.get(402)).setAttribute("width","12" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(403)).setAttribute("src","b.gif" );
      ((Element)v.get(403)).setAttribute("width","12" );
      ((Element)v.get(403)).setAttribute("height","12" );
      ((Element)v.get(402)).appendChild((Element)v.get(403));
      /* Termina nodo:403   */
      /* Termina nodo:402   */

      /* Empieza nodo:404 / Elemento padre: 401   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(404)).setAttribute("width","100%" );
      ((Element)v.get(401)).appendChild((Element)v.get(404));

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
      ((Element)v.get(406)).setAttribute("align","left" );
      ((Element)v.get(405)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(407)).setAttribute("nombre","zorgOidRegiTdId" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(408)).setAttribute("border","0" );
      ((Element)v.get(408)).setAttribute("cellspacing","0" );
      ((Element)v.get(408)).setAttribute("cellpadding","0" );
      ((Element)v.get(408)).setAttribute("align","left" );
      ((Element)v.get(407)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(408)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(410)).setAttribute("valign","top" );
      ((Element)v.get(410)).setAttribute("height","13" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(411)).setAttribute("nombre","lblzorgOidRegi" );
      ((Element)v.get(411)).setAttribute("id","datosTitle" );
      ((Element)v.get(411)).setAttribute("ancho","100" );
      ((Element)v.get(411)).setAttribute("alto","13" );
      ((Element)v.get(411)).setAttribute("cod","EduMatriCurso.zorgOidRegi.label" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */
      /* Termina nodo:410   */
      /* Termina nodo:409   */

      /* Empieza nodo:412 / Elemento padre: 408   */
   }

   private void getXML1890(Document doc) {
      v.add(doc.createElement("TR"));
      ((Element)v.get(412)).setAttribute("nombre","zorgOidRegiWidgetTrId" );
      ((Element)v.get(408)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(413)).setAttribute("align","left" );
      ((Element)v.get(413)).setAttribute("nowrap","true" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(414)).setAttribute("nombre","zorgOidRegi" );
      ((Element)v.get(414)).setAttribute("id","datosCampos" );
      ((Element)v.get(414)).setAttribute("multiple","N" );
      ((Element)v.get(414)).setAttribute("req","N" );
      ((Element)v.get(414)).setAttribute("size","1" );
      ((Element)v.get(414)).setAttribute("validacion","" );
      ((Element)v.get(414)).setAttribute("onchange","" );
      ((Element)v.get(414)).setAttribute("onfocus","" );
      ((Element)v.get(414)).setAttribute("valorinicial","" );
      ((Element)v.get(414)).setAttribute("textoinicial","" );
      ((Element)v.get(414)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true);" );
      ((Element)v.get(414)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm',0, false);" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(414)).appendChild((Element)v.get(415));
      /* Termina nodo:415   */
      /* Termina nodo:414   */
      /* Termina nodo:413   */
      /* Termina nodo:412   */

      /* Empieza nodo:416 / Elemento padre: 408   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(416)).setAttribute("nombre","zorgOidRegiViewLabelTrId" );
      ((Element)v.get(408)).appendChild((Element)v.get(416));

      /* Empieza nodo:417 / Elemento padre: 416   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(417)).setAttribute("valign","top" );
      ((Element)v.get(417)).setAttribute("height","13" );
      ((Element)v.get(417)).setAttribute("width","50" );
      ((Element)v.get(416)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(418)).setAttribute("nombre","lblViewZorgOidRegi" );
      ((Element)v.get(418)).setAttribute("alto","13" );
      ((Element)v.get(418)).setAttribute("filas","1" );
      ((Element)v.get(418)).setAttribute("id","EstDat" );
      ((Element)v.get(418)).setAttribute("valor","" );
      ((Element)v.get(417)).appendChild((Element)v.get(418));
      /* Termina nodo:418   */
      /* Termina nodo:417   */
      /* Termina nodo:416   */
      /* Termina nodo:408   */
      /* Termina nodo:407   */

      /* Empieza nodo:419 / Elemento padre: 406   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(419)).setAttribute("nombre","zorgOidRegiGapTdId" );
      ((Element)v.get(419)).setAttribute("nowrap","true" );
      ((Element)v.get(419)).setAttribute("class","datosCampos" );
      ((Element)v.get(406)).appendChild((Element)v.get(419));

      /* Empieza nodo:420 / Elemento padre: 419   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(420)).setAttribute("src","b.gif" );
      ((Element)v.get(420)).setAttribute("width","25" );
      ((Element)v.get(420)).setAttribute("height","8" );
      ((Element)v.get(419)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */
      /* Termina nodo:419   */

      /* Empieza nodo:421 / Elemento padre: 406   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(421)).setAttribute("width","100%" );
      ((Element)v.get(406)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(422)).setAttribute("src","b.gif" );
      ((Element)v.get(421)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */
      /* Termina nodo:421   */
      /* Termina nodo:406   */
      /* Termina nodo:405   */
      /* Termina nodo:404   */
      /* Termina nodo:401   */

      /* Empieza nodo:423 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(423)).setAttribute("nombre","formGapTr9" );
      ((Element)v.get(40)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(424)).setAttribute("align","center" );
      ((Element)v.get(424)).setAttribute("width","12" );
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
      ((Element)v.get(428)).setAttribute("width","12" );
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

      /* Empieza nodo:430 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(430)).setAttribute("nombre","formTr10" );
      ((Element)v.get(40)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(431)).setAttribute("align","center" );
      ((Element)v.get(431)).setAttribute("width","12" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(432)).setAttribute("src","b.gif" );
      ((Element)v.get(432)).setAttribute("width","12" );
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
      v.add(doc.createElement("TD"));
      ((Element)v.get(436)).setAttribute("nombre","zzonOidZonaTdId" );
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
      ((Element)v.get(440)).setAttribute("nombre","lblzzonOidZona" );
      ((Element)v.get(440)).setAttribute("id","datosTitle" );
      ((Element)v.get(440)).setAttribute("ancho","100" );
      ((Element)v.get(440)).setAttribute("alto","13" );
      ((Element)v.get(440)).setAttribute("cod","EduMatriCurso.zzonOidZona.label" );
      ((Element)v.get(439)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */
      /* Termina nodo:439   */
      /* Termina nodo:438   */

      /* Empieza nodo:441 / Elemento padre: 437   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(441)).setAttribute("nombre","zzonOidZonaWidgetTrId" );
      ((Element)v.get(437)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(442)).setAttribute("align","left" );
      ((Element)v.get(442)).setAttribute("nowrap","true" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));

      /* Empieza nodo:443 / Elemento padre: 442   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(443)).setAttribute("nombre","zzonOidZona" );
      ((Element)v.get(443)).setAttribute("id","datosCampos" );
      ((Element)v.get(443)).setAttribute("multiple","N" );
      ((Element)v.get(443)).setAttribute("req","N" );
      ((Element)v.get(443)).setAttribute("size","1" );
      ((Element)v.get(443)).setAttribute("validacion","" );
      ((Element)v.get(443)).setAttribute("onchange","" );
      ((Element)v.get(443)).setAttribute("onfocus","" );
      ((Element)v.get(443)).setAttribute("valorinicial","" );
      ((Element)v.get(443)).setAttribute("textoinicial","" );
      ((Element)v.get(443)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true);" );
      ((Element)v.get(443)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm',0, false);" );
      ((Element)v.get(442)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(443)).appendChild((Element)v.get(444));
      /* Termina nodo:444   */
      /* Termina nodo:443   */
      /* Termina nodo:442   */
      /* Termina nodo:441   */

      /* Empieza nodo:445 / Elemento padre: 437   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(445)).setAttribute("nombre","zzonOidZonaViewLabelTrId" );
      ((Element)v.get(437)).appendChild((Element)v.get(445));

      /* Empieza nodo:446 / Elemento padre: 445   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(446)).setAttribute("valign","top" );
      ((Element)v.get(446)).setAttribute("height","13" );
      ((Element)v.get(446)).setAttribute("width","50" );
      ((Element)v.get(445)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(447)).setAttribute("nombre","lblViewZzonOidZona" );
      ((Element)v.get(447)).setAttribute("alto","13" );
      ((Element)v.get(447)).setAttribute("filas","1" );
      ((Element)v.get(447)).setAttribute("id","EstDat" );
      ((Element)v.get(447)).setAttribute("valor","" );
      ((Element)v.get(446)).appendChild((Element)v.get(447));
      /* Termina nodo:447   */
      /* Termina nodo:446   */
      /* Termina nodo:445   */
      /* Termina nodo:437   */
      /* Termina nodo:436   */

      /* Empieza nodo:448 / Elemento padre: 435   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(448)).setAttribute("nombre","zzonOidZonaGapTdId" );
      ((Element)v.get(448)).setAttribute("nowrap","true" );
      ((Element)v.get(448)).setAttribute("class","datosCampos" );
      ((Element)v.get(435)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(449)).setAttribute("src","b.gif" );
      ((Element)v.get(449)).setAttribute("width","25" );
      ((Element)v.get(449)).setAttribute("height","8" );
      ((Element)v.get(448)).appendChild((Element)v.get(449));
      /* Termina nodo:449   */
      /* Termina nodo:448   */

      /* Empieza nodo:450 / Elemento padre: 435   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(450)).setAttribute("width","100%" );
      ((Element)v.get(435)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
   }

   private void getXML2070(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(451)).setAttribute("src","b.gif" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));
      /* Termina nodo:451   */
      /* Termina nodo:450   */
      /* Termina nodo:435   */
      /* Termina nodo:434   */
      /* Termina nodo:433   */
      /* Termina nodo:430   */

      /* Empieza nodo:452 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(452)).setAttribute("nombre","formGapTr10" );
      ((Element)v.get(40)).appendChild((Element)v.get(452));

      /* Empieza nodo:453 / Elemento padre: 452   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(453)).setAttribute("align","center" );
      ((Element)v.get(453)).setAttribute("width","12" );
      ((Element)v.get(452)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(454)).setAttribute("src","b.gif" );
      ((Element)v.get(454)).setAttribute("width","12" );
      ((Element)v.get(454)).setAttribute("height","8" );
      ((Element)v.get(453)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */
      /* Termina nodo:453   */

      /* Empieza nodo:455 / Elemento padre: 452   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(452)).appendChild((Element)v.get(455));

      /* Empieza nodo:456 / Elemento padre: 455   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(456)).setAttribute("src","b.gif" );
      ((Element)v.get(456)).setAttribute("width","8" );
      ((Element)v.get(456)).setAttribute("height","8" );
      ((Element)v.get(455)).appendChild((Element)v.get(456));
      /* Termina nodo:456   */
      /* Termina nodo:455   */

      /* Empieza nodo:457 / Elemento padre: 452   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(457)).setAttribute("align","center" );
      ((Element)v.get(457)).setAttribute("width","12" );
      ((Element)v.get(452)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(458)).setAttribute("src","b.gif" );
      ((Element)v.get(458)).setAttribute("width","12" );
      ((Element)v.get(458)).setAttribute("height","8" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */
      /* Termina nodo:457   */
      /* Termina nodo:452   */

      /* Empieza nodo:459 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(459)).setAttribute("nombre","formTr11" );
      ((Element)v.get(40)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(460)).setAttribute("align","center" );
      ((Element)v.get(460)).setAttribute("width","12" );
      ((Element)v.get(459)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(461)).setAttribute("src","b.gif" );
      ((Element)v.get(461)).setAttribute("width","12" );
      ((Element)v.get(461)).setAttribute("height","12" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));
      /* Termina nodo:461   */
      /* Termina nodo:460   */

      /* Empieza nodo:462 / Elemento padre: 459   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(462)).setAttribute("width","100%" );
      ((Element)v.get(459)).appendChild((Element)v.get(462));

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
      ((Element)v.get(464)).setAttribute("align","left" );
      ((Element)v.get(463)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(465)).setAttribute("nombre","zsccOidSeccTdId" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(466)).setAttribute("border","0" );
      ((Element)v.get(466)).setAttribute("cellspacing","0" );
      ((Element)v.get(466)).setAttribute("cellpadding","0" );
      ((Element)v.get(466)).setAttribute("align","left" );
      ((Element)v.get(465)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(466)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(468)).setAttribute("valign","top" );
      ((Element)v.get(468)).setAttribute("height","13" );
      ((Element)v.get(467)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(469)).setAttribute("nombre","lblzsccOidSecc" );
      ((Element)v.get(469)).setAttribute("id","datosTitle" );
      ((Element)v.get(469)).setAttribute("ancho","100" );
      ((Element)v.get(469)).setAttribute("alto","13" );
      ((Element)v.get(469)).setAttribute("cod","EduMatriCurso.zsccOidSecc.label" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));
      /* Termina nodo:469   */
      /* Termina nodo:468   */
      /* Termina nodo:467   */

      /* Empieza nodo:470 / Elemento padre: 466   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(470)).setAttribute("nombre","zsccOidSeccWidgetTrId" );
      ((Element)v.get(466)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(471)).setAttribute("align","left" );
      ((Element)v.get(471)).setAttribute("nowrap","true" );
      ((Element)v.get(470)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(472)).setAttribute("nombre","zsccOidSecc" );
      ((Element)v.get(472)).setAttribute("id","datosCampos" );
      ((Element)v.get(472)).setAttribute("multiple","N" );
      ((Element)v.get(472)).setAttribute("req","N" );
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(472)).setAttribute("size","1" );
      ((Element)v.get(472)).setAttribute("validacion","" );
      ((Element)v.get(472)).setAttribute("onchange","" );
      ((Element)v.get(472)).setAttribute("onfocus","" );
      ((Element)v.get(472)).setAttribute("valorinicial","" );
      ((Element)v.get(472)).setAttribute("textoinicial","" );
      ((Element)v.get(472)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true);" );
      ((Element)v.get(472)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm',0, false);" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));

      /* Empieza nodo:473 / Elemento padre: 472   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(472)).appendChild((Element)v.get(473));
      /* Termina nodo:473   */
      /* Termina nodo:472   */
      /* Termina nodo:471   */
      /* Termina nodo:470   */

      /* Empieza nodo:474 / Elemento padre: 466   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(474)).setAttribute("nombre","zsccOidSeccViewLabelTrId" );
      ((Element)v.get(466)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(475)).setAttribute("valign","top" );
      ((Element)v.get(475)).setAttribute("height","13" );
      ((Element)v.get(475)).setAttribute("width","50" );
      ((Element)v.get(474)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(476)).setAttribute("nombre","lblViewZsccOidSecc" );
      ((Element)v.get(476)).setAttribute("alto","13" );
      ((Element)v.get(476)).setAttribute("filas","1" );
      ((Element)v.get(476)).setAttribute("id","EstDat" );
      ((Element)v.get(476)).setAttribute("valor","" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */
      /* Termina nodo:475   */
      /* Termina nodo:474   */
      /* Termina nodo:466   */
      /* Termina nodo:465   */

      /* Empieza nodo:477 / Elemento padre: 464   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(477)).setAttribute("nombre","zsccOidSeccGapTdId" );
      ((Element)v.get(477)).setAttribute("nowrap","true" );
      ((Element)v.get(477)).setAttribute("class","datosCampos" );
      ((Element)v.get(464)).appendChild((Element)v.get(477));

      /* Empieza nodo:478 / Elemento padre: 477   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(478)).setAttribute("src","b.gif" );
      ((Element)v.get(478)).setAttribute("width","25" );
      ((Element)v.get(478)).setAttribute("height","8" );
      ((Element)v.get(477)).appendChild((Element)v.get(478));
      /* Termina nodo:478   */
      /* Termina nodo:477   */

      /* Empieza nodo:479 / Elemento padre: 464   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(479)).setAttribute("width","100%" );
      ((Element)v.get(464)).appendChild((Element)v.get(479));

      /* Empieza nodo:480 / Elemento padre: 479   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(480)).setAttribute("src","b.gif" );
      ((Element)v.get(479)).appendChild((Element)v.get(480));
      /* Termina nodo:480   */
      /* Termina nodo:479   */
      /* Termina nodo:464   */
      /* Termina nodo:463   */
      /* Termina nodo:462   */
      /* Termina nodo:459   */

      /* Empieza nodo:481 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(481)).setAttribute("nombre","formGapTr11" );
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
      ((Element)v.get(483)).setAttribute("height","8" );
      ((Element)v.get(482)).appendChild((Element)v.get(483));
      /* Termina nodo:483   */
      /* Termina nodo:482   */

      /* Empieza nodo:484 / Elemento padre: 481   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(481)).appendChild((Element)v.get(484));

      /* Empieza nodo:485 / Elemento padre: 484   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(485)).setAttribute("src","b.gif" );
      ((Element)v.get(485)).setAttribute("width","8" );
      ((Element)v.get(485)).setAttribute("height","8" );
      ((Element)v.get(484)).appendChild((Element)v.get(485));
      /* Termina nodo:485   */
      /* Termina nodo:484   */

      /* Empieza nodo:486 / Elemento padre: 481   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(486)).setAttribute("align","center" );
      ((Element)v.get(486)).setAttribute("width","12" );
      ((Element)v.get(481)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(487)).setAttribute("src","b.gif" );
      ((Element)v.get(487)).setAttribute("width","12" );
      ((Element)v.get(487)).setAttribute("height","8" );
      ((Element)v.get(486)).appendChild((Element)v.get(487));
      /* Termina nodo:487   */
      /* Termina nodo:486   */
      /* Termina nodo:481   */

      /* Empieza nodo:488 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(488)).setAttribute("nombre","formTr12" );
      ((Element)v.get(40)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(489)).setAttribute("align","center" );
      ((Element)v.get(489)).setAttribute("width","12" );
      ((Element)v.get(488)).appendChild((Element)v.get(489));

      /* Empieza nodo:490 / Elemento padre: 489   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(490)).setAttribute("src","b.gif" );
      ((Element)v.get(490)).setAttribute("width","12" );
      ((Element)v.get(490)).setAttribute("height","12" );
      ((Element)v.get(489)).appendChild((Element)v.get(490));
      /* Termina nodo:490   */
      /* Termina nodo:489   */

      /* Empieza nodo:491 / Elemento padre: 488   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(491)).setAttribute("width","100%" );
      ((Element)v.get(488)).appendChild((Element)v.get(491));

      /* Empieza nodo:492 / Elemento padre: 491   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(492)).setAttribute("width","100%" );
      ((Element)v.get(492)).setAttribute("border","0" );
      ((Element)v.get(492)).setAttribute("cellspacing","0" );
      ((Element)v.get(492)).setAttribute("cellpadding","0" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(492)).setAttribute("align","left" );
      ((Element)v.get(491)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(493)).setAttribute("align","left" );
      ((Element)v.get(492)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(494)).setAttribute("nombre","ztadOidTerrAdmiTdId" );
      ((Element)v.get(493)).appendChild((Element)v.get(494));

      /* Empieza nodo:495 / Elemento padre: 494   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(495)).setAttribute("border","0" );
      ((Element)v.get(495)).setAttribute("cellspacing","0" );
      ((Element)v.get(495)).setAttribute("cellpadding","0" );
      ((Element)v.get(495)).setAttribute("align","left" );
      ((Element)v.get(494)).appendChild((Element)v.get(495));

      /* Empieza nodo:496 / Elemento padre: 495   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(495)).appendChild((Element)v.get(496));

      /* Empieza nodo:497 / Elemento padre: 496   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(497)).setAttribute("valign","top" );
      ((Element)v.get(497)).setAttribute("height","13" );
      ((Element)v.get(496)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(498)).setAttribute("nombre","lblztadOidTerrAdmi" );
      ((Element)v.get(498)).setAttribute("id","datosTitle" );
      ((Element)v.get(498)).setAttribute("ancho","100" );
      ((Element)v.get(498)).setAttribute("alto","13" );
      ((Element)v.get(498)).setAttribute("cod","EduMatriCurso.ztadOidTerrAdmi.label" );
      ((Element)v.get(497)).appendChild((Element)v.get(498));
      /* Termina nodo:498   */
      /* Termina nodo:497   */
      /* Termina nodo:496   */

      /* Empieza nodo:499 / Elemento padre: 495   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(499)).setAttribute("nombre","ztadOidTerrAdmiWidgetTrId" );
      ((Element)v.get(495)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(500)).setAttribute("align","left" );
      ((Element)v.get(500)).setAttribute("nowrap","true" );
      ((Element)v.get(499)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(501)).setAttribute("nombre","ztadOidTerrAdmi" );
      ((Element)v.get(501)).setAttribute("id","datosCampos" );
      ((Element)v.get(501)).setAttribute("multiple","N" );
      ((Element)v.get(501)).setAttribute("req","N" );
      ((Element)v.get(501)).setAttribute("size","1" );
      ((Element)v.get(501)).setAttribute("validacion","" );
      ((Element)v.get(501)).setAttribute("onchange","" );
      ((Element)v.get(501)).setAttribute("onfocus","" );
      ((Element)v.get(501)).setAttribute("valorinicial","" );
      ((Element)v.get(501)).setAttribute("textoinicial","" );
      ((Element)v.get(501)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true);" );
      ((Element)v.get(501)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm',0, false);" );
      ((Element)v.get(500)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(501)).appendChild((Element)v.get(502));
      /* Termina nodo:502   */
      /* Termina nodo:501   */
      /* Termina nodo:500   */
      /* Termina nodo:499   */

      /* Empieza nodo:503 / Elemento padre: 495   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(503)).setAttribute("nombre","ztadOidTerrAdmiViewLabelTrId" );
      ((Element)v.get(495)).appendChild((Element)v.get(503));

      /* Empieza nodo:504 / Elemento padre: 503   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(504)).setAttribute("valign","top" );
      ((Element)v.get(504)).setAttribute("height","13" );
      ((Element)v.get(504)).setAttribute("width","50" );
      ((Element)v.get(503)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(505)).setAttribute("nombre","lblViewZtadOidTerrAdmi" );
      ((Element)v.get(505)).setAttribute("alto","13" );
      ((Element)v.get(505)).setAttribute("filas","1" );
      ((Element)v.get(505)).setAttribute("id","EstDat" );
      ((Element)v.get(505)).setAttribute("valor","" );
      ((Element)v.get(504)).appendChild((Element)v.get(505));
      /* Termina nodo:505   */
      /* Termina nodo:504   */
      /* Termina nodo:503   */
      /* Termina nodo:495   */
      /* Termina nodo:494   */

      /* Empieza nodo:506 / Elemento padre: 493   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(506)).setAttribute("nombre","ztadOidTerrAdmiGapTdId" );
      ((Element)v.get(506)).setAttribute("nowrap","true" );
      ((Element)v.get(506)).setAttribute("class","datosCampos" );
      ((Element)v.get(493)).appendChild((Element)v.get(506));

      /* Empieza nodo:507 / Elemento padre: 506   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(507)).setAttribute("src","b.gif" );
      ((Element)v.get(507)).setAttribute("width","25" );
      ((Element)v.get(507)).setAttribute("height","8" );
      ((Element)v.get(506)).appendChild((Element)v.get(507));
      /* Termina nodo:507   */
      /* Termina nodo:506   */

      /* Empieza nodo:508 / Elemento padre: 493   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(508)).setAttribute("width","100%" );
      ((Element)v.get(493)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(509)).setAttribute("src","b.gif" );
      ((Element)v.get(508)).appendChild((Element)v.get(509));
      /* Termina nodo:509   */
      /* Termina nodo:508   */
      /* Termina nodo:493   */
      /* Termina nodo:492   */
      /* Termina nodo:491   */
      /* Termina nodo:488   */

      /* Empieza nodo:510 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(510)).setAttribute("nombre","formGapTr12" );
      ((Element)v.get(40)).appendChild((Element)v.get(510));

      /* Empieza nodo:511 / Elemento padre: 510   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(511)).setAttribute("align","center" );
      ((Element)v.get(511)).setAttribute("width","12" );
      ((Element)v.get(510)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(512)).setAttribute("src","b.gif" );
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(512)).setAttribute("width","12" );
      ((Element)v.get(512)).setAttribute("height","8" );
      ((Element)v.get(511)).appendChild((Element)v.get(512));
      /* Termina nodo:512   */
      /* Termina nodo:511   */

      /* Empieza nodo:513 / Elemento padre: 510   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(510)).appendChild((Element)v.get(513));

      /* Empieza nodo:514 / Elemento padre: 513   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(514)).setAttribute("src","b.gif" );
      ((Element)v.get(514)).setAttribute("width","8" );
      ((Element)v.get(514)).setAttribute("height","8" );
      ((Element)v.get(513)).appendChild((Element)v.get(514));
      /* Termina nodo:514   */
      /* Termina nodo:513   */

      /* Empieza nodo:515 / Elemento padre: 510   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(515)).setAttribute("align","center" );
      ((Element)v.get(515)).setAttribute("width","12" );
      ((Element)v.get(510)).appendChild((Element)v.get(515));

      /* Empieza nodo:516 / Elemento padre: 515   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(516)).setAttribute("src","b.gif" );
      ((Element)v.get(516)).setAttribute("width","12" );
      ((Element)v.get(516)).setAttribute("height","8" );
      ((Element)v.get(515)).appendChild((Element)v.get(516));
      /* Termina nodo:516   */
      /* Termina nodo:515   */
      /* Termina nodo:510   */

      /* Empieza nodo:517 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(517)).setAttribute("nombre","formTr13" );
      ((Element)v.get(40)).appendChild((Element)v.get(517));

      /* Empieza nodo:518 / Elemento padre: 517   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(518)).setAttribute("align","center" );
      ((Element)v.get(518)).setAttribute("width","12" );
      ((Element)v.get(517)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(519)).setAttribute("src","b.gif" );
      ((Element)v.get(519)).setAttribute("width","12" );
      ((Element)v.get(519)).setAttribute("height","12" );
      ((Element)v.get(518)).appendChild((Element)v.get(519));
      /* Termina nodo:519   */
      /* Termina nodo:518   */

      /* Empieza nodo:520 / Elemento padre: 517   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(520)).setAttribute("width","100%" );
      ((Element)v.get(517)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(521)).setAttribute("width","100%" );
      ((Element)v.get(521)).setAttribute("border","0" );
      ((Element)v.get(521)).setAttribute("cellspacing","0" );
      ((Element)v.get(521)).setAttribute("cellpadding","0" );
      ((Element)v.get(521)).setAttribute("align","left" );
      ((Element)v.get(520)).appendChild((Element)v.get(521));

      /* Empieza nodo:522 / Elemento padre: 521   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(522)).setAttribute("align","left" );
      ((Element)v.get(521)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(523)).setAttribute("nombre","perdOidPeriInicCompTdId" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));

      /* Empieza nodo:524 / Elemento padre: 523   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(524)).setAttribute("border","0" );
      ((Element)v.get(524)).setAttribute("cellspacing","0" );
      ((Element)v.get(524)).setAttribute("cellpadding","0" );
      ((Element)v.get(524)).setAttribute("align","left" );
      ((Element)v.get(523)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(524)).appendChild((Element)v.get(525));

      /* Empieza nodo:526 / Elemento padre: 525   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(526)).setAttribute("valign","top" );
      ((Element)v.get(526)).setAttribute("height","13" );
      ((Element)v.get(525)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(527)).setAttribute("nombre","lblperdOidPeriInicComp" );
      ((Element)v.get(527)).setAttribute("id","datosTitle" );
      ((Element)v.get(527)).setAttribute("ancho","100" );
      ((Element)v.get(527)).setAttribute("alto","13" );
      ((Element)v.get(527)).setAttribute("cod","EduMatriCurso.perdOidPeriInicComp.label" );
      ((Element)v.get(526)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */
      /* Termina nodo:526   */
      /* Termina nodo:525   */

      /* Empieza nodo:528 / Elemento padre: 524   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(528)).setAttribute("nombre","perdOidPeriInicCompWidgetTrId" );
      ((Element)v.get(524)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(529)).setAttribute("align","left" );
      ((Element)v.get(529)).setAttribute("nowrap","true" );
      ((Element)v.get(528)).appendChild((Element)v.get(529));

      /* Empieza nodo:530 / Elemento padre: 529   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(530)).setAttribute("nombre","perdOidPeriInicComp" );
      ((Element)v.get(530)).setAttribute("id","datosCampos" );
      ((Element)v.get(530)).setAttribute("multiple","N" );
      ((Element)v.get(530)).setAttribute("req","N" );
      ((Element)v.get(530)).setAttribute("size","1" );
      ((Element)v.get(530)).setAttribute("validacion","" );
      ((Element)v.get(530)).setAttribute("onchange","" );
      ((Element)v.get(530)).setAttribute("onfocus","" );
      ((Element)v.get(530)).setAttribute("valorinicial","" );
      ((Element)v.get(530)).setAttribute("textoinicial","" );
      ((Element)v.get(530)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true);" );
      ((Element)v.get(530)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm',0, false);" );
      ((Element)v.get(529)).appendChild((Element)v.get(530));

      /* Empieza nodo:531 / Elemento padre: 530   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(530)).appendChild((Element)v.get(531));
      /* Termina nodo:531   */
      /* Termina nodo:530   */
      /* Termina nodo:529   */
      /* Termina nodo:528   */

      /* Empieza nodo:532 / Elemento padre: 524   */
      v.add(doc.createElement("TR"));
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(532)).setAttribute("nombre","perdOidPeriInicCompViewLabelTrId" );
      ((Element)v.get(524)).appendChild((Element)v.get(532));

      /* Empieza nodo:533 / Elemento padre: 532   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(533)).setAttribute("valign","top" );
      ((Element)v.get(533)).setAttribute("height","13" );
      ((Element)v.get(533)).setAttribute("width","50" );
      ((Element)v.get(532)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(534)).setAttribute("nombre","lblViewPerdOidPeriInicComp" );
      ((Element)v.get(534)).setAttribute("alto","13" );
      ((Element)v.get(534)).setAttribute("filas","1" );
      ((Element)v.get(534)).setAttribute("id","EstDat" );
      ((Element)v.get(534)).setAttribute("valor","" );
      ((Element)v.get(533)).appendChild((Element)v.get(534));
      /* Termina nodo:534   */
      /* Termina nodo:533   */
      /* Termina nodo:532   */
      /* Termina nodo:524   */
      /* Termina nodo:523   */

      /* Empieza nodo:535 / Elemento padre: 522   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(535)).setAttribute("nombre","perdOidPeriInicCompGapTdId" );
      ((Element)v.get(535)).setAttribute("nowrap","true" );
      ((Element)v.get(535)).setAttribute("class","datosCampos" );
      ((Element)v.get(522)).appendChild((Element)v.get(535));

      /* Empieza nodo:536 / Elemento padre: 535   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(536)).setAttribute("src","b.gif" );
      ((Element)v.get(536)).setAttribute("width","25" );
      ((Element)v.get(536)).setAttribute("height","8" );
      ((Element)v.get(535)).appendChild((Element)v.get(536));
      /* Termina nodo:536   */
      /* Termina nodo:535   */

      /* Empieza nodo:537 / Elemento padre: 522   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(537)).setAttribute("width","100%" );
      ((Element)v.get(522)).appendChild((Element)v.get(537));

      /* Empieza nodo:538 / Elemento padre: 537   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(538)).setAttribute("src","b.gif" );
      ((Element)v.get(537)).appendChild((Element)v.get(538));
      /* Termina nodo:538   */
      /* Termina nodo:537   */
      /* Termina nodo:522   */
      /* Termina nodo:521   */
      /* Termina nodo:520   */
      /* Termina nodo:517   */

      /* Empieza nodo:539 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(539)).setAttribute("nombre","formGapTr13" );
      ((Element)v.get(40)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(540)).setAttribute("align","center" );
      ((Element)v.get(540)).setAttribute("width","12" );
      ((Element)v.get(539)).appendChild((Element)v.get(540));

      /* Empieza nodo:541 / Elemento padre: 540   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(541)).setAttribute("src","b.gif" );
      ((Element)v.get(541)).setAttribute("width","12" );
      ((Element)v.get(541)).setAttribute("height","8" );
      ((Element)v.get(540)).appendChild((Element)v.get(541));
      /* Termina nodo:541   */
      /* Termina nodo:540   */

      /* Empieza nodo:542 / Elemento padre: 539   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(539)).appendChild((Element)v.get(542));

      /* Empieza nodo:543 / Elemento padre: 542   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(543)).setAttribute("src","b.gif" );
      ((Element)v.get(543)).setAttribute("width","8" );
      ((Element)v.get(543)).setAttribute("height","8" );
      ((Element)v.get(542)).appendChild((Element)v.get(543));
      /* Termina nodo:543   */
      /* Termina nodo:542   */

      /* Empieza nodo:544 / Elemento padre: 539   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(544)).setAttribute("align","center" );
      ((Element)v.get(544)).setAttribute("width","12" );
      ((Element)v.get(539)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(545)).setAttribute("src","b.gif" );
      ((Element)v.get(545)).setAttribute("width","12" );
      ((Element)v.get(545)).setAttribute("height","8" );
      ((Element)v.get(544)).appendChild((Element)v.get(545));
      /* Termina nodo:545   */
      /* Termina nodo:544   */
      /* Termina nodo:539   */

      /* Empieza nodo:546 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(546)).setAttribute("nombre","formTr14" );
      ((Element)v.get(40)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(547)).setAttribute("align","center" );
      ((Element)v.get(547)).setAttribute("width","12" );
      ((Element)v.get(546)).appendChild((Element)v.get(547));

      /* Empieza nodo:548 / Elemento padre: 547   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(548)).setAttribute("src","b.gif" );
      ((Element)v.get(548)).setAttribute("width","12" );
      ((Element)v.get(548)).setAttribute("height","12" );
      ((Element)v.get(547)).appendChild((Element)v.get(548));
      /* Termina nodo:548   */
      /* Termina nodo:547   */

      /* Empieza nodo:549 / Elemento padre: 546   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(549)).setAttribute("width","100%" );
      ((Element)v.get(546)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(550)).setAttribute("width","100%" );
      ((Element)v.get(550)).setAttribute("border","0" );
      ((Element)v.get(550)).setAttribute("cellspacing","0" );
      ((Element)v.get(550)).setAttribute("cellpadding","0" );
      ((Element)v.get(550)).setAttribute("align","left" );
      ((Element)v.get(549)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(551)).setAttribute("align","left" );
      ((Element)v.get(550)).appendChild((Element)v.get(551));

      /* Empieza nodo:552 / Elemento padre: 551   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(552)).setAttribute("nombre","perdOidPeriFinaCompTdId" );
      ((Element)v.get(551)).appendChild((Element)v.get(552));

      /* Empieza nodo:553 / Elemento padre: 552   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(553)).setAttribute("border","0" );
      ((Element)v.get(553)).setAttribute("cellspacing","0" );
      ((Element)v.get(553)).setAttribute("cellpadding","0" );
   }

   private void getXML2520(Document doc) {
      ((Element)v.get(553)).setAttribute("align","left" );
      ((Element)v.get(552)).appendChild((Element)v.get(553));

      /* Empieza nodo:554 / Elemento padre: 553   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(553)).appendChild((Element)v.get(554));

      /* Empieza nodo:555 / Elemento padre: 554   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(555)).setAttribute("valign","top" );
      ((Element)v.get(555)).setAttribute("height","13" );
      ((Element)v.get(554)).appendChild((Element)v.get(555));

      /* Empieza nodo:556 / Elemento padre: 555   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(556)).setAttribute("nombre","lblperdOidPeriFinaComp" );
      ((Element)v.get(556)).setAttribute("id","datosTitle" );
      ((Element)v.get(556)).setAttribute("ancho","100" );
      ((Element)v.get(556)).setAttribute("alto","13" );
      ((Element)v.get(556)).setAttribute("cod","EduMatriCurso.perdOidPeriFinaComp.label" );
      ((Element)v.get(555)).appendChild((Element)v.get(556));
      /* Termina nodo:556   */
      /* Termina nodo:555   */
      /* Termina nodo:554   */

      /* Empieza nodo:557 / Elemento padre: 553   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(557)).setAttribute("nombre","perdOidPeriFinaCompWidgetTrId" );
      ((Element)v.get(553)).appendChild((Element)v.get(557));

      /* Empieza nodo:558 / Elemento padre: 557   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(558)).setAttribute("align","left" );
      ((Element)v.get(558)).setAttribute("nowrap","true" );
      ((Element)v.get(557)).appendChild((Element)v.get(558));

      /* Empieza nodo:559 / Elemento padre: 558   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(559)).setAttribute("nombre","perdOidPeriFinaComp" );
      ((Element)v.get(559)).setAttribute("id","datosCampos" );
      ((Element)v.get(559)).setAttribute("multiple","N" );
      ((Element)v.get(559)).setAttribute("req","N" );
      ((Element)v.get(559)).setAttribute("size","1" );
      ((Element)v.get(559)).setAttribute("validacion","" );
      ((Element)v.get(559)).setAttribute("onchange","" );
      ((Element)v.get(559)).setAttribute("onfocus","" );
      ((Element)v.get(559)).setAttribute("valorinicial","" );
      ((Element)v.get(559)).setAttribute("textoinicial","" );
      ((Element)v.get(559)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true);" );
      ((Element)v.get(559)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm',0, false);" );
      ((Element)v.get(558)).appendChild((Element)v.get(559));

      /* Empieza nodo:560 / Elemento padre: 559   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(559)).appendChild((Element)v.get(560));
      /* Termina nodo:560   */
      /* Termina nodo:559   */
      /* Termina nodo:558   */
      /* Termina nodo:557   */

      /* Empieza nodo:561 / Elemento padre: 553   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(561)).setAttribute("nombre","perdOidPeriFinaCompViewLabelTrId" );
      ((Element)v.get(553)).appendChild((Element)v.get(561));

      /* Empieza nodo:562 / Elemento padre: 561   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(562)).setAttribute("valign","top" );
      ((Element)v.get(562)).setAttribute("height","13" );
      ((Element)v.get(562)).setAttribute("width","50" );
      ((Element)v.get(561)).appendChild((Element)v.get(562));

      /* Empieza nodo:563 / Elemento padre: 562   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(563)).setAttribute("nombre","lblViewPerdOidPeriFinaComp" );
      ((Element)v.get(563)).setAttribute("alto","13" );
      ((Element)v.get(563)).setAttribute("filas","1" );
      ((Element)v.get(563)).setAttribute("id","EstDat" );
      ((Element)v.get(563)).setAttribute("valor","" );
      ((Element)v.get(562)).appendChild((Element)v.get(563));
      /* Termina nodo:563   */
      /* Termina nodo:562   */
      /* Termina nodo:561   */
      /* Termina nodo:553   */
      /* Termina nodo:552   */

      /* Empieza nodo:564 / Elemento padre: 551   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(564)).setAttribute("nombre","perdOidPeriFinaCompGapTdId" );
      ((Element)v.get(564)).setAttribute("nowrap","true" );
      ((Element)v.get(564)).setAttribute("class","datosCampos" );
      ((Element)v.get(551)).appendChild((Element)v.get(564));

      /* Empieza nodo:565 / Elemento padre: 564   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(565)).setAttribute("src","b.gif" );
      ((Element)v.get(565)).setAttribute("width","25" );
      ((Element)v.get(565)).setAttribute("height","8" );
      ((Element)v.get(564)).appendChild((Element)v.get(565));
      /* Termina nodo:565   */
      /* Termina nodo:564   */

      /* Empieza nodo:566 / Elemento padre: 551   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(566)).setAttribute("width","100%" );
      ((Element)v.get(551)).appendChild((Element)v.get(566));

      /* Empieza nodo:567 / Elemento padre: 566   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(567)).setAttribute("src","b.gif" );
      ((Element)v.get(566)).appendChild((Element)v.get(567));
      /* Termina nodo:567   */
      /* Termina nodo:566   */
      /* Termina nodo:551   */
      /* Termina nodo:550   */
      /* Termina nodo:549   */
      /* Termina nodo:546   */

      /* Empieza nodo:568 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(568)).setAttribute("nombre","formGapTr14" );
      ((Element)v.get(40)).appendChild((Element)v.get(568));

      /* Empieza nodo:569 / Elemento padre: 568   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(569)).setAttribute("align","center" );
      ((Element)v.get(569)).setAttribute("width","12" );
      ((Element)v.get(568)).appendChild((Element)v.get(569));

      /* Empieza nodo:570 / Elemento padre: 569   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(570)).setAttribute("src","b.gif" );
      ((Element)v.get(570)).setAttribute("width","12" );
      ((Element)v.get(570)).setAttribute("height","8" );
      ((Element)v.get(569)).appendChild((Element)v.get(570));
      /* Termina nodo:570   */
      /* Termina nodo:569   */

      /* Empieza nodo:571 / Elemento padre: 568   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(568)).appendChild((Element)v.get(571));

      /* Empieza nodo:572 / Elemento padre: 571   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(572)).setAttribute("src","b.gif" );
      ((Element)v.get(572)).setAttribute("width","8" );
      ((Element)v.get(572)).setAttribute("height","8" );
      ((Element)v.get(571)).appendChild((Element)v.get(572));
      /* Termina nodo:572   */
      /* Termina nodo:571   */

      /* Empieza nodo:573 / Elemento padre: 568   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(573)).setAttribute("align","center" );
   }

   private void getXML2610(Document doc) {
      ((Element)v.get(573)).setAttribute("width","12" );
      ((Element)v.get(568)).appendChild((Element)v.get(573));

      /* Empieza nodo:574 / Elemento padre: 573   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(574)).setAttribute("src","b.gif" );
      ((Element)v.get(574)).setAttribute("width","12" );
      ((Element)v.get(574)).setAttribute("height","8" );
      ((Element)v.get(573)).appendChild((Element)v.get(574));
      /* Termina nodo:574   */
      /* Termina nodo:573   */
      /* Termina nodo:568   */

      /* Empieza nodo:575 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(575)).setAttribute("nombre","formTr15" );
      ((Element)v.get(40)).appendChild((Element)v.get(575));

      /* Empieza nodo:576 / Elemento padre: 575   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(576)).setAttribute("align","center" );
      ((Element)v.get(576)).setAttribute("width","12" );
      ((Element)v.get(575)).appendChild((Element)v.get(576));

      /* Empieza nodo:577 / Elemento padre: 576   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(577)).setAttribute("src","b.gif" );
      ((Element)v.get(577)).setAttribute("width","12" );
      ((Element)v.get(577)).setAttribute("height","12" );
      ((Element)v.get(576)).appendChild((Element)v.get(577));
      /* Termina nodo:577   */
      /* Termina nodo:576   */

      /* Empieza nodo:578 / Elemento padre: 575   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(578)).setAttribute("width","100%" );
      ((Element)v.get(575)).appendChild((Element)v.get(578));

      /* Empieza nodo:579 / Elemento padre: 578   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(579)).setAttribute("width","100%" );
      ((Element)v.get(579)).setAttribute("border","0" );
      ((Element)v.get(579)).setAttribute("cellspacing","0" );
      ((Element)v.get(579)).setAttribute("cellpadding","0" );
      ((Element)v.get(579)).setAttribute("align","left" );
      ((Element)v.get(578)).appendChild((Element)v.get(579));

      /* Empieza nodo:580 / Elemento padre: 579   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(580)).setAttribute("align","left" );
      ((Element)v.get(579)).appendChild((Element)v.get(580));

      /* Empieza nodo:581 / Elemento padre: 580   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(581)).setAttribute("nombre","perdOidPeriInicConsTdId" );
      ((Element)v.get(580)).appendChild((Element)v.get(581));

      /* Empieza nodo:582 / Elemento padre: 581   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(582)).setAttribute("border","0" );
      ((Element)v.get(582)).setAttribute("cellspacing","0" );
      ((Element)v.get(582)).setAttribute("cellpadding","0" );
      ((Element)v.get(582)).setAttribute("align","left" );
      ((Element)v.get(581)).appendChild((Element)v.get(582));

      /* Empieza nodo:583 / Elemento padre: 582   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(582)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(584)).setAttribute("valign","top" );
      ((Element)v.get(584)).setAttribute("height","13" );
      ((Element)v.get(583)).appendChild((Element)v.get(584));

      /* Empieza nodo:585 / Elemento padre: 584   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(585)).setAttribute("nombre","lblperdOidPeriInicCons" );
      ((Element)v.get(585)).setAttribute("id","datosTitle" );
      ((Element)v.get(585)).setAttribute("ancho","100" );
      ((Element)v.get(585)).setAttribute("alto","13" );
      ((Element)v.get(585)).setAttribute("cod","EduMatriCurso.perdOidPeriInicCons.label" );
      ((Element)v.get(584)).appendChild((Element)v.get(585));
      /* Termina nodo:585   */
      /* Termina nodo:584   */
      /* Termina nodo:583   */

      /* Empieza nodo:586 / Elemento padre: 582   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(586)).setAttribute("nombre","perdOidPeriInicConsWidgetTrId" );
      ((Element)v.get(582)).appendChild((Element)v.get(586));

      /* Empieza nodo:587 / Elemento padre: 586   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(587)).setAttribute("align","left" );
      ((Element)v.get(587)).setAttribute("nowrap","true" );
      ((Element)v.get(586)).appendChild((Element)v.get(587));

      /* Empieza nodo:588 / Elemento padre: 587   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(588)).setAttribute("nombre","perdOidPeriInicCons" );
      ((Element)v.get(588)).setAttribute("id","datosCampos" );
      ((Element)v.get(588)).setAttribute("multiple","N" );
      ((Element)v.get(588)).setAttribute("req","N" );
      ((Element)v.get(588)).setAttribute("size","1" );
      ((Element)v.get(588)).setAttribute("validacion","" );
      ((Element)v.get(588)).setAttribute("onchange","" );
      ((Element)v.get(588)).setAttribute("onfocus","" );
      ((Element)v.get(588)).setAttribute("valorinicial","" );
      ((Element)v.get(588)).setAttribute("textoinicial","" );
      ((Element)v.get(588)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true);" );
      ((Element)v.get(588)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm',0, false);" );
      ((Element)v.get(587)).appendChild((Element)v.get(588));

      /* Empieza nodo:589 / Elemento padre: 588   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(588)).appendChild((Element)v.get(589));
      /* Termina nodo:589   */
      /* Termina nodo:588   */
      /* Termina nodo:587   */
      /* Termina nodo:586   */

      /* Empieza nodo:590 / Elemento padre: 582   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(590)).setAttribute("nombre","perdOidPeriInicConsViewLabelTrId" );
      ((Element)v.get(582)).appendChild((Element)v.get(590));

      /* Empieza nodo:591 / Elemento padre: 590   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(591)).setAttribute("valign","top" );
      ((Element)v.get(591)).setAttribute("height","13" );
      ((Element)v.get(591)).setAttribute("width","50" );
      ((Element)v.get(590)).appendChild((Element)v.get(591));

      /* Empieza nodo:592 / Elemento padre: 591   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(592)).setAttribute("nombre","lblViewPerdOidPeriInicCons" );
      ((Element)v.get(592)).setAttribute("alto","13" );
      ((Element)v.get(592)).setAttribute("filas","1" );
      ((Element)v.get(592)).setAttribute("id","EstDat" );
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(592)).setAttribute("valor","" );
      ((Element)v.get(591)).appendChild((Element)v.get(592));
      /* Termina nodo:592   */
      /* Termina nodo:591   */
      /* Termina nodo:590   */
      /* Termina nodo:582   */
      /* Termina nodo:581   */

      /* Empieza nodo:593 / Elemento padre: 580   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(593)).setAttribute("nombre","perdOidPeriInicConsGapTdId" );
      ((Element)v.get(593)).setAttribute("nowrap","true" );
      ((Element)v.get(593)).setAttribute("class","datosCampos" );
      ((Element)v.get(580)).appendChild((Element)v.get(593));

      /* Empieza nodo:594 / Elemento padre: 593   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(594)).setAttribute("src","b.gif" );
      ((Element)v.get(594)).setAttribute("width","25" );
      ((Element)v.get(594)).setAttribute("height","8" );
      ((Element)v.get(593)).appendChild((Element)v.get(594));
      /* Termina nodo:594   */
      /* Termina nodo:593   */

      /* Empieza nodo:595 / Elemento padre: 580   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(595)).setAttribute("width","100%" );
      ((Element)v.get(580)).appendChild((Element)v.get(595));

      /* Empieza nodo:596 / Elemento padre: 595   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(596)).setAttribute("src","b.gif" );
      ((Element)v.get(595)).appendChild((Element)v.get(596));
      /* Termina nodo:596   */
      /* Termina nodo:595   */
      /* Termina nodo:580   */
      /* Termina nodo:579   */
      /* Termina nodo:578   */
      /* Termina nodo:575   */

      /* Empieza nodo:597 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(597)).setAttribute("nombre","formGapTr15" );
      ((Element)v.get(40)).appendChild((Element)v.get(597));

      /* Empieza nodo:598 / Elemento padre: 597   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(598)).setAttribute("align","center" );
      ((Element)v.get(598)).setAttribute("width","12" );
      ((Element)v.get(597)).appendChild((Element)v.get(598));

      /* Empieza nodo:599 / Elemento padre: 598   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(599)).setAttribute("src","b.gif" );
      ((Element)v.get(599)).setAttribute("width","12" );
      ((Element)v.get(599)).setAttribute("height","8" );
      ((Element)v.get(598)).appendChild((Element)v.get(599));
      /* Termina nodo:599   */
      /* Termina nodo:598   */

      /* Empieza nodo:600 / Elemento padre: 597   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(597)).appendChild((Element)v.get(600));

      /* Empieza nodo:601 / Elemento padre: 600   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(601)).setAttribute("src","b.gif" );
      ((Element)v.get(601)).setAttribute("width","8" );
      ((Element)v.get(601)).setAttribute("height","8" );
      ((Element)v.get(600)).appendChild((Element)v.get(601));
      /* Termina nodo:601   */
      /* Termina nodo:600   */

      /* Empieza nodo:602 / Elemento padre: 597   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(602)).setAttribute("align","center" );
      ((Element)v.get(602)).setAttribute("width","12" );
      ((Element)v.get(597)).appendChild((Element)v.get(602));

      /* Empieza nodo:603 / Elemento padre: 602   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(603)).setAttribute("src","b.gif" );
      ((Element)v.get(603)).setAttribute("width","12" );
      ((Element)v.get(603)).setAttribute("height","8" );
      ((Element)v.get(602)).appendChild((Element)v.get(603));
      /* Termina nodo:603   */
      /* Termina nodo:602   */
      /* Termina nodo:597   */

      /* Empieza nodo:604 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(604)).setAttribute("nombre","formTr16" );
      ((Element)v.get(40)).appendChild((Element)v.get(604));

      /* Empieza nodo:605 / Elemento padre: 604   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(605)).setAttribute("align","center" );
      ((Element)v.get(605)).setAttribute("width","12" );
      ((Element)v.get(604)).appendChild((Element)v.get(605));

      /* Empieza nodo:606 / Elemento padre: 605   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(606)).setAttribute("src","b.gif" );
      ((Element)v.get(606)).setAttribute("width","12" );
      ((Element)v.get(606)).setAttribute("height","12" );
      ((Element)v.get(605)).appendChild((Element)v.get(606));
      /* Termina nodo:606   */
      /* Termina nodo:605   */

      /* Empieza nodo:607 / Elemento padre: 604   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(607)).setAttribute("width","100%" );
      ((Element)v.get(604)).appendChild((Element)v.get(607));

      /* Empieza nodo:608 / Elemento padre: 607   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(608)).setAttribute("width","100%" );
      ((Element)v.get(608)).setAttribute("border","0" );
      ((Element)v.get(608)).setAttribute("cellspacing","0" );
      ((Element)v.get(608)).setAttribute("cellpadding","0" );
      ((Element)v.get(608)).setAttribute("align","left" );
      ((Element)v.get(607)).appendChild((Element)v.get(608));

      /* Empieza nodo:609 / Elemento padre: 608   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(609)).setAttribute("align","left" );
      ((Element)v.get(608)).appendChild((Element)v.get(609));

      /* Empieza nodo:610 / Elemento padre: 609   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(610)).setAttribute("nombre","perdOidPeriFinaConsTdId" );
      ((Element)v.get(609)).appendChild((Element)v.get(610));

      /* Empieza nodo:611 / Elemento padre: 610   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(611)).setAttribute("border","0" );
      ((Element)v.get(611)).setAttribute("cellspacing","0" );
      ((Element)v.get(611)).setAttribute("cellpadding","0" );
      ((Element)v.get(611)).setAttribute("align","left" );
      ((Element)v.get(610)).appendChild((Element)v.get(611));

      /* Empieza nodo:612 / Elemento padre: 611   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(611)).appendChild((Element)v.get(612));

      /* Empieza nodo:613 / Elemento padre: 612   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(613)).setAttribute("valign","top" );
      ((Element)v.get(613)).setAttribute("height","13" );
      ((Element)v.get(612)).appendChild((Element)v.get(613));

      /* Empieza nodo:614 / Elemento padre: 613   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(614)).setAttribute("nombre","lblperdOidPeriFinaCons" );
      ((Element)v.get(614)).setAttribute("id","datosTitle" );
      ((Element)v.get(614)).setAttribute("ancho","100" );
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(614)).setAttribute("alto","13" );
      ((Element)v.get(614)).setAttribute("cod","EduMatriCurso.perdOidPeriFinaCons.label" );
      ((Element)v.get(613)).appendChild((Element)v.get(614));
      /* Termina nodo:614   */
      /* Termina nodo:613   */
      /* Termina nodo:612   */

      /* Empieza nodo:615 / Elemento padre: 611   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(615)).setAttribute("nombre","perdOidPeriFinaConsWidgetTrId" );
      ((Element)v.get(611)).appendChild((Element)v.get(615));

      /* Empieza nodo:616 / Elemento padre: 615   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(616)).setAttribute("align","left" );
      ((Element)v.get(616)).setAttribute("nowrap","true" );
      ((Element)v.get(615)).appendChild((Element)v.get(616));

      /* Empieza nodo:617 / Elemento padre: 616   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(617)).setAttribute("nombre","perdOidPeriFinaCons" );
      ((Element)v.get(617)).setAttribute("id","datosCampos" );
      ((Element)v.get(617)).setAttribute("multiple","N" );
      ((Element)v.get(617)).setAttribute("req","N" );
      ((Element)v.get(617)).setAttribute("size","1" );
      ((Element)v.get(617)).setAttribute("validacion","" );
      ((Element)v.get(617)).setAttribute("onchange","" );
      ((Element)v.get(617)).setAttribute("onfocus","" );
      ((Element)v.get(617)).setAttribute("valorinicial","" );
      ((Element)v.get(617)).setAttribute("textoinicial","" );
      ((Element)v.get(617)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true);" );
      ((Element)v.get(617)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm',0, false);" );
      ((Element)v.get(616)).appendChild((Element)v.get(617));

      /* Empieza nodo:618 / Elemento padre: 617   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(617)).appendChild((Element)v.get(618));
      /* Termina nodo:618   */
      /* Termina nodo:617   */
      /* Termina nodo:616   */
      /* Termina nodo:615   */

      /* Empieza nodo:619 / Elemento padre: 611   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(619)).setAttribute("nombre","perdOidPeriFinaConsViewLabelTrId" );
      ((Element)v.get(611)).appendChild((Element)v.get(619));

      /* Empieza nodo:620 / Elemento padre: 619   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(620)).setAttribute("valign","top" );
      ((Element)v.get(620)).setAttribute("height","13" );
      ((Element)v.get(620)).setAttribute("width","50" );
      ((Element)v.get(619)).appendChild((Element)v.get(620));

      /* Empieza nodo:621 / Elemento padre: 620   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(621)).setAttribute("nombre","lblViewPerdOidPeriFinaCons" );
      ((Element)v.get(621)).setAttribute("alto","13" );
      ((Element)v.get(621)).setAttribute("filas","1" );
      ((Element)v.get(621)).setAttribute("id","EstDat" );
      ((Element)v.get(621)).setAttribute("valor","" );
      ((Element)v.get(620)).appendChild((Element)v.get(621));
      /* Termina nodo:621   */
      /* Termina nodo:620   */
      /* Termina nodo:619   */
      /* Termina nodo:611   */
      /* Termina nodo:610   */

      /* Empieza nodo:622 / Elemento padre: 609   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(622)).setAttribute("nombre","perdOidPeriFinaConsGapTdId" );
      ((Element)v.get(622)).setAttribute("nowrap","true" );
      ((Element)v.get(622)).setAttribute("class","datosCampos" );
      ((Element)v.get(609)).appendChild((Element)v.get(622));

      /* Empieza nodo:623 / Elemento padre: 622   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(623)).setAttribute("src","b.gif" );
      ((Element)v.get(623)).setAttribute("width","25" );
      ((Element)v.get(623)).setAttribute("height","8" );
      ((Element)v.get(622)).appendChild((Element)v.get(623));
      /* Termina nodo:623   */
      /* Termina nodo:622   */

      /* Empieza nodo:624 / Elemento padre: 609   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(624)).setAttribute("width","100%" );
      ((Element)v.get(609)).appendChild((Element)v.get(624));

      /* Empieza nodo:625 / Elemento padre: 624   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(625)).setAttribute("src","b.gif" );
      ((Element)v.get(624)).appendChild((Element)v.get(625));
      /* Termina nodo:625   */
      /* Termina nodo:624   */
      /* Termina nodo:609   */
      /* Termina nodo:608   */
      /* Termina nodo:607   */
      /* Termina nodo:604   */

      /* Empieza nodo:626 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(626)).setAttribute("nombre","formGapTr16" );
      ((Element)v.get(40)).appendChild((Element)v.get(626));

      /* Empieza nodo:627 / Elemento padre: 626   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(627)).setAttribute("align","center" );
      ((Element)v.get(627)).setAttribute("width","12" );
      ((Element)v.get(626)).appendChild((Element)v.get(627));

      /* Empieza nodo:628 / Elemento padre: 627   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(628)).setAttribute("src","b.gif" );
      ((Element)v.get(628)).setAttribute("width","12" );
      ((Element)v.get(628)).setAttribute("height","8" );
      ((Element)v.get(627)).appendChild((Element)v.get(628));
      /* Termina nodo:628   */
      /* Termina nodo:627   */

      /* Empieza nodo:629 / Elemento padre: 626   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(626)).appendChild((Element)v.get(629));

      /* Empieza nodo:630 / Elemento padre: 629   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(630)).setAttribute("src","b.gif" );
      ((Element)v.get(630)).setAttribute("width","8" );
      ((Element)v.get(630)).setAttribute("height","8" );
      ((Element)v.get(629)).appendChild((Element)v.get(630));
      /* Termina nodo:630   */
      /* Termina nodo:629   */

      /* Empieza nodo:631 / Elemento padre: 626   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(631)).setAttribute("align","center" );
      ((Element)v.get(631)).setAttribute("width","12" );
      ((Element)v.get(626)).appendChild((Element)v.get(631));

      /* Empieza nodo:632 / Elemento padre: 631   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(632)).setAttribute("src","b.gif" );
      ((Element)v.get(632)).setAttribute("width","12" );
      ((Element)v.get(632)).setAttribute("height","8" );
      ((Element)v.get(631)).appendChild((Element)v.get(632));
      /* Termina nodo:632   */
      /* Termina nodo:631   */
      /* Termina nodo:626   */

      /* Empieza nodo:633 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(633)).setAttribute("nombre","formTr17" );
      ((Element)v.get(40)).appendChild((Element)v.get(633));

      /* Empieza nodo:634 / Elemento padre: 633   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(634)).setAttribute("align","center" );
   }

   private void getXML2880(Document doc) {
      ((Element)v.get(634)).setAttribute("width","12" );
      ((Element)v.get(633)).appendChild((Element)v.get(634));

      /* Empieza nodo:635 / Elemento padre: 634   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(635)).setAttribute("src","b.gif" );
      ((Element)v.get(635)).setAttribute("width","12" );
      ((Element)v.get(635)).setAttribute("height","12" );
      ((Element)v.get(634)).appendChild((Element)v.get(635));
      /* Termina nodo:635   */
      /* Termina nodo:634   */

      /* Empieza nodo:636 / Elemento padre: 633   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(636)).setAttribute("width","100%" );
      ((Element)v.get(633)).appendChild((Element)v.get(636));

      /* Empieza nodo:637 / Elemento padre: 636   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(637)).setAttribute("width","100%" );
      ((Element)v.get(637)).setAttribute("border","0" );
      ((Element)v.get(637)).setAttribute("cellspacing","0" );
      ((Element)v.get(637)).setAttribute("cellpadding","0" );
      ((Element)v.get(637)).setAttribute("align","left" );
      ((Element)v.get(636)).appendChild((Element)v.get(637));

      /* Empieza nodo:638 / Elemento padre: 637   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(638)).setAttribute("align","left" );
      ((Element)v.get(637)).appendChild((Element)v.get(638));

      /* Empieza nodo:639 / Elemento padre: 638   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(639)).setAttribute("nombre","perdOidPeriIngrTdId" );
      ((Element)v.get(638)).appendChild((Element)v.get(639));

      /* Empieza nodo:640 / Elemento padre: 639   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(640)).setAttribute("border","0" );
      ((Element)v.get(640)).setAttribute("cellspacing","0" );
      ((Element)v.get(640)).setAttribute("cellpadding","0" );
      ((Element)v.get(640)).setAttribute("align","left" );
      ((Element)v.get(639)).appendChild((Element)v.get(640));

      /* Empieza nodo:641 / Elemento padre: 640   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(640)).appendChild((Element)v.get(641));

      /* Empieza nodo:642 / Elemento padre: 641   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(642)).setAttribute("valign","top" );
      ((Element)v.get(642)).setAttribute("height","13" );
      ((Element)v.get(641)).appendChild((Element)v.get(642));

      /* Empieza nodo:643 / Elemento padre: 642   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(643)).setAttribute("nombre","lblperdOidPeriIngr" );
      ((Element)v.get(643)).setAttribute("id","datosTitle" );
      ((Element)v.get(643)).setAttribute("ancho","100" );
      ((Element)v.get(643)).setAttribute("alto","13" );
      ((Element)v.get(643)).setAttribute("cod","EduMatriCurso.perdOidPeriIngr.label" );
      ((Element)v.get(642)).appendChild((Element)v.get(643));
      /* Termina nodo:643   */
      /* Termina nodo:642   */
      /* Termina nodo:641   */

      /* Empieza nodo:644 / Elemento padre: 640   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(644)).setAttribute("nombre","perdOidPeriIngrWidgetTrId" );
      ((Element)v.get(640)).appendChild((Element)v.get(644));

      /* Empieza nodo:645 / Elemento padre: 644   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(645)).setAttribute("align","left" );
      ((Element)v.get(645)).setAttribute("nowrap","true" );
      ((Element)v.get(644)).appendChild((Element)v.get(645));

      /* Empieza nodo:646 / Elemento padre: 645   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(646)).setAttribute("nombre","perdOidPeriIngr" );
      ((Element)v.get(646)).setAttribute("id","datosCampos" );
      ((Element)v.get(646)).setAttribute("multiple","N" );
      ((Element)v.get(646)).setAttribute("req","N" );
      ((Element)v.get(646)).setAttribute("size","1" );
      ((Element)v.get(646)).setAttribute("validacion","" );
      ((Element)v.get(646)).setAttribute("onchange","" );
      ((Element)v.get(646)).setAttribute("onfocus","" );
      ((Element)v.get(646)).setAttribute("valorinicial","" );
      ((Element)v.get(646)).setAttribute("textoinicial","" );
      ((Element)v.get(646)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true);" );
      ((Element)v.get(646)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm',0, false);" );
      ((Element)v.get(645)).appendChild((Element)v.get(646));

      /* Empieza nodo:647 / Elemento padre: 646   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(646)).appendChild((Element)v.get(647));
      /* Termina nodo:647   */
      /* Termina nodo:646   */
      /* Termina nodo:645   */
      /* Termina nodo:644   */

      /* Empieza nodo:648 / Elemento padre: 640   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(648)).setAttribute("nombre","perdOidPeriIngrViewLabelTrId" );
      ((Element)v.get(640)).appendChild((Element)v.get(648));

      /* Empieza nodo:649 / Elemento padre: 648   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(649)).setAttribute("valign","top" );
      ((Element)v.get(649)).setAttribute("height","13" );
      ((Element)v.get(649)).setAttribute("width","50" );
      ((Element)v.get(648)).appendChild((Element)v.get(649));

      /* Empieza nodo:650 / Elemento padre: 649   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(650)).setAttribute("nombre","lblViewPerdOidPeriIngr" );
      ((Element)v.get(650)).setAttribute("alto","13" );
      ((Element)v.get(650)).setAttribute("filas","1" );
      ((Element)v.get(650)).setAttribute("id","EstDat" );
      ((Element)v.get(650)).setAttribute("valor","" );
      ((Element)v.get(649)).appendChild((Element)v.get(650));
      /* Termina nodo:650   */
      /* Termina nodo:649   */
      /* Termina nodo:648   */
      /* Termina nodo:640   */
      /* Termina nodo:639   */

      /* Empieza nodo:651 / Elemento padre: 638   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(651)).setAttribute("nombre","perdOidPeriIngrGapTdId" );
      ((Element)v.get(651)).setAttribute("nowrap","true" );
      ((Element)v.get(651)).setAttribute("class","datosCampos" );
      ((Element)v.get(638)).appendChild((Element)v.get(651));

      /* Empieza nodo:652 / Elemento padre: 651   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(652)).setAttribute("src","b.gif" );
      ((Element)v.get(652)).setAttribute("width","25" );
      ((Element)v.get(652)).setAttribute("height","8" );
      ((Element)v.get(651)).appendChild((Element)v.get(652));
      /* Termina nodo:652   */
      /* Termina nodo:651   */

      /* Empieza nodo:653 / Elemento padre: 638   */
   }

   private void getXML2970(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(653)).setAttribute("width","100%" );
      ((Element)v.get(638)).appendChild((Element)v.get(653));

      /* Empieza nodo:654 / Elemento padre: 653   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(654)).setAttribute("src","b.gif" );
      ((Element)v.get(653)).appendChild((Element)v.get(654));
      /* Termina nodo:654   */
      /* Termina nodo:653   */
      /* Termina nodo:638   */
      /* Termina nodo:637   */
      /* Termina nodo:636   */
      /* Termina nodo:633   */

      /* Empieza nodo:655 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(655)).setAttribute("nombre","formGapTr17" );
      ((Element)v.get(40)).appendChild((Element)v.get(655));

      /* Empieza nodo:656 / Elemento padre: 655   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(656)).setAttribute("align","center" );
      ((Element)v.get(656)).setAttribute("width","12" );
      ((Element)v.get(655)).appendChild((Element)v.get(656));

      /* Empieza nodo:657 / Elemento padre: 656   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(657)).setAttribute("src","b.gif" );
      ((Element)v.get(657)).setAttribute("width","12" );
      ((Element)v.get(657)).setAttribute("height","8" );
      ((Element)v.get(656)).appendChild((Element)v.get(657));
      /* Termina nodo:657   */
      /* Termina nodo:656   */

      /* Empieza nodo:658 / Elemento padre: 655   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(655)).appendChild((Element)v.get(658));

      /* Empieza nodo:659 / Elemento padre: 658   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(659)).setAttribute("src","b.gif" );
      ((Element)v.get(659)).setAttribute("width","8" );
      ((Element)v.get(659)).setAttribute("height","8" );
      ((Element)v.get(658)).appendChild((Element)v.get(659));
      /* Termina nodo:659   */
      /* Termina nodo:658   */

      /* Empieza nodo:660 / Elemento padre: 655   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(660)).setAttribute("align","center" );
      ((Element)v.get(660)).setAttribute("width","12" );
      ((Element)v.get(655)).appendChild((Element)v.get(660));

      /* Empieza nodo:661 / Elemento padre: 660   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(661)).setAttribute("src","b.gif" );
      ((Element)v.get(661)).setAttribute("width","12" );
      ((Element)v.get(661)).setAttribute("height","8" );
      ((Element)v.get(660)).appendChild((Element)v.get(661));
      /* Termina nodo:661   */
      /* Termina nodo:660   */
      /* Termina nodo:655   */

      /* Empieza nodo:662 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(662)).setAttribute("nombre","formTr18" );
      ((Element)v.get(40)).appendChild((Element)v.get(662));

      /* Empieza nodo:663 / Elemento padre: 662   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(663)).setAttribute("align","center" );
      ((Element)v.get(663)).setAttribute("width","12" );
      ((Element)v.get(662)).appendChild((Element)v.get(663));

      /* Empieza nodo:664 / Elemento padre: 663   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(664)).setAttribute("src","b.gif" );
      ((Element)v.get(664)).setAttribute("width","12" );
      ((Element)v.get(664)).setAttribute("height","12" );
      ((Element)v.get(663)).appendChild((Element)v.get(664));
      /* Termina nodo:664   */
      /* Termina nodo:663   */

      /* Empieza nodo:665 / Elemento padre: 662   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(665)).setAttribute("width","100%" );
      ((Element)v.get(662)).appendChild((Element)v.get(665));

      /* Empieza nodo:666 / Elemento padre: 665   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(666)).setAttribute("width","100%" );
      ((Element)v.get(666)).setAttribute("border","0" );
      ((Element)v.get(666)).setAttribute("cellspacing","0" );
      ((Element)v.get(666)).setAttribute("cellpadding","0" );
      ((Element)v.get(666)).setAttribute("align","left" );
      ((Element)v.get(665)).appendChild((Element)v.get(666));

      /* Empieza nodo:667 / Elemento padre: 666   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(667)).setAttribute("align","left" );
      ((Element)v.get(666)).appendChild((Element)v.get(667));

      /* Empieza nodo:668 / Elemento padre: 667   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(668)).setAttribute("nombre","ticuOidTipoCurs_marcOidMarcTdId" );
      ((Element)v.get(667)).appendChild((Element)v.get(668));

      /* Empieza nodo:669 / Elemento padre: 668   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(669)).setAttribute("border","0" );
      ((Element)v.get(669)).setAttribute("cellspacing","0" );
      ((Element)v.get(669)).setAttribute("cellpadding","0" );
      ((Element)v.get(669)).setAttribute("align","left" );
      ((Element)v.get(668)).appendChild((Element)v.get(669));

      /* Empieza nodo:670 / Elemento padre: 669   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(669)).appendChild((Element)v.get(670));

      /* Empieza nodo:671 / Elemento padre: 670   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(671)).setAttribute("valign","top" );
      ((Element)v.get(671)).setAttribute("height","13" );
      ((Element)v.get(670)).appendChild((Element)v.get(671));

      /* Empieza nodo:672 / Elemento padre: 671   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(672)).setAttribute("nombre","lblticuOidTipoCurs_marcOidMarc" );
      ((Element)v.get(672)).setAttribute("id","datosTitle" );
      ((Element)v.get(672)).setAttribute("ancho","100" );
      ((Element)v.get(672)).setAttribute("alto","13" );
      ((Element)v.get(672)).setAttribute("cod","EduTipoCurso.marcOidMarc.label" );
      ((Element)v.get(671)).appendChild((Element)v.get(672));
      /* Termina nodo:672   */
      /* Termina nodo:671   */
      /* Termina nodo:670   */

      /* Empieza nodo:673 / Elemento padre: 669   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(673)).setAttribute("nombre","ticuOidTipoCurs_marcOidMarcWidgetTrId" );
      ((Element)v.get(669)).appendChild((Element)v.get(673));

      /* Empieza nodo:674 / Elemento padre: 673   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(674)).setAttribute("align","left" );
      ((Element)v.get(674)).setAttribute("nowrap","true" );
      ((Element)v.get(673)).appendChild((Element)v.get(674));

      /* Empieza nodo:675 / Elemento padre: 674   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(675)).setAttribute("nombre","ticuOidTipoCurs_marcOidMarc" );
   }

   private void getXML3060(Document doc) {
      ((Element)v.get(675)).setAttribute("id","datosCampos" );
      ((Element)v.get(675)).setAttribute("multiple","N" );
      ((Element)v.get(675)).setAttribute("req","N" );
      ((Element)v.get(675)).setAttribute("size","1" );
      ((Element)v.get(675)).setAttribute("validacion","" );
      ((Element)v.get(675)).setAttribute("onchange","mmgDependeneChange('ticuOidTipoCurs_marcOidMarc', 'ticuOidTipoCurs' , 'eduMatriCurso')" );
      ((Element)v.get(675)).setAttribute("onfocus","" );
      ((Element)v.get(675)).setAttribute("valorinicial","" );
      ((Element)v.get(675)).setAttribute("textoinicial","" );
      ((Element)v.get(675)).setAttribute("ontab","focaliza('eduMatriCursoFrm.ticuOidTipoCurs');" );
      ((Element)v.get(675)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm',0, false);" );
      ((Element)v.get(674)).appendChild((Element)v.get(675));

      /* Empieza nodo:676 / Elemento padre: 675   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(675)).appendChild((Element)v.get(676));
      /* Termina nodo:676   */
      /* Termina nodo:675   */
      /* Termina nodo:674   */
      /* Termina nodo:673   */

      /* Empieza nodo:677 / Elemento padre: 669   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(677)).setAttribute("nombre","ticuOidTipoCurs_marcOidMarcViewLabelTrId" );
      ((Element)v.get(669)).appendChild((Element)v.get(677));

      /* Empieza nodo:678 / Elemento padre: 677   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(678)).setAttribute("valign","top" );
      ((Element)v.get(678)).setAttribute("height","13" );
      ((Element)v.get(678)).setAttribute("width","40" );
      ((Element)v.get(677)).appendChild((Element)v.get(678));

      /* Empieza nodo:679 / Elemento padre: 678   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(679)).setAttribute("nombre","lblViewTicuOidTipoCurs_marcOidMarc" );
      ((Element)v.get(679)).setAttribute("alto","13" );
      ((Element)v.get(679)).setAttribute("filas","1" );
      ((Element)v.get(679)).setAttribute("id","EstDat" );
      ((Element)v.get(679)).setAttribute("valor","" );
      ((Element)v.get(678)).appendChild((Element)v.get(679));
      /* Termina nodo:679   */
      /* Termina nodo:678   */
      /* Termina nodo:677   */
      /* Termina nodo:669   */
      /* Termina nodo:668   */

      /* Empieza nodo:680 / Elemento padre: 667   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(680)).setAttribute("nombre","ticuOidTipoCursGapTdId" );
      ((Element)v.get(680)).setAttribute("nowrap","true" );
      ((Element)v.get(680)).setAttribute("class","datosCampos" );
      ((Element)v.get(667)).appendChild((Element)v.get(680));

      /* Empieza nodo:681 / Elemento padre: 680   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(681)).setAttribute("src","b.gif" );
      ((Element)v.get(681)).setAttribute("width","25" );
      ((Element)v.get(681)).setAttribute("height","8" );
      ((Element)v.get(680)).appendChild((Element)v.get(681));
      /* Termina nodo:681   */
      /* Termina nodo:680   */

      /* Empieza nodo:682 / Elemento padre: 667   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(682)).setAttribute("nombre","ticuOidTipoCursTdId" );
      ((Element)v.get(667)).appendChild((Element)v.get(682));

      /* Empieza nodo:683 / Elemento padre: 682   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(683)).setAttribute("border","0" );
      ((Element)v.get(683)).setAttribute("cellspacing","0" );
      ((Element)v.get(683)).setAttribute("cellpadding","0" );
      ((Element)v.get(683)).setAttribute("align","left" );
      ((Element)v.get(682)).appendChild((Element)v.get(683));

      /* Empieza nodo:684 / Elemento padre: 683   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(683)).appendChild((Element)v.get(684));

      /* Empieza nodo:685 / Elemento padre: 684   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(685)).setAttribute("valign","top" );
      ((Element)v.get(685)).setAttribute("height","13" );
      ((Element)v.get(684)).appendChild((Element)v.get(685));

      /* Empieza nodo:686 / Elemento padre: 685   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(686)).setAttribute("nombre","lblticuOidTipoCurs" );
      ((Element)v.get(686)).setAttribute("id","datosTitle" );
      ((Element)v.get(686)).setAttribute("ancho","100" );
      ((Element)v.get(686)).setAttribute("alto","13" );
      ((Element)v.get(686)).setAttribute("cod","EduMatriCurso.ticuOidTipoCurs.label" );
      ((Element)v.get(685)).appendChild((Element)v.get(686));
      /* Termina nodo:686   */
      /* Termina nodo:685   */
      /* Termina nodo:684   */

      /* Empieza nodo:687 / Elemento padre: 683   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(687)).setAttribute("nombre","ticuOidTipoCursWidgetTrId" );
      ((Element)v.get(683)).appendChild((Element)v.get(687));

      /* Empieza nodo:688 / Elemento padre: 687   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(688)).setAttribute("align","left" );
      ((Element)v.get(688)).setAttribute("nowrap","true" );
      ((Element)v.get(687)).appendChild((Element)v.get(688));

      /* Empieza nodo:689 / Elemento padre: 688   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(689)).setAttribute("nombre","ticuOidTipoCurs" );
      ((Element)v.get(689)).setAttribute("id","datosCampos" );
      ((Element)v.get(689)).setAttribute("multiple","N" );
      ((Element)v.get(689)).setAttribute("req","N" );
      ((Element)v.get(689)).setAttribute("size","1" );
      ((Element)v.get(689)).setAttribute("validacion","" );
      ((Element)v.get(689)).setAttribute("onchange","" );
      ((Element)v.get(689)).setAttribute("onfocus","" );
      ((Element)v.get(689)).setAttribute("valorinicial","" );
      ((Element)v.get(689)).setAttribute("textoinicial","" );
      ((Element)v.get(689)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true);" );
      ((Element)v.get(689)).setAttribute("onshtab","focaliza('eduMatriCursoFrm.ticuOidTipoCurs_marcOidMarc');" );
      ((Element)v.get(688)).appendChild((Element)v.get(689));

      /* Empieza nodo:690 / Elemento padre: 689   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(689)).appendChild((Element)v.get(690));
      /* Termina nodo:690   */
      /* Termina nodo:689   */
      /* Termina nodo:688   */
      /* Termina nodo:687   */

      /* Empieza nodo:691 / Elemento padre: 683   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(691)).setAttribute("nombre","ticuOidTipoCursViewLabelTrId" );
      ((Element)v.get(683)).appendChild((Element)v.get(691));

      /* Empieza nodo:692 / Elemento padre: 691   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(692)).setAttribute("valign","top" );
      ((Element)v.get(692)).setAttribute("height","13" );
   }

   private void getXML3150(Document doc) {
      ((Element)v.get(692)).setAttribute("width","40" );
      ((Element)v.get(691)).appendChild((Element)v.get(692));

      /* Empieza nodo:693 / Elemento padre: 692   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(693)).setAttribute("nombre","lblViewTicuOidTipoCurs" );
      ((Element)v.get(693)).setAttribute("alto","13" );
      ((Element)v.get(693)).setAttribute("filas","1" );
      ((Element)v.get(693)).setAttribute("id","EstDat" );
      ((Element)v.get(693)).setAttribute("valor","" );
      ((Element)v.get(692)).appendChild((Element)v.get(693));
      /* Termina nodo:693   */
      /* Termina nodo:692   */
      /* Termina nodo:691   */
      /* Termina nodo:683   */
      /* Termina nodo:682   */

      /* Empieza nodo:694 / Elemento padre: 667   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(694)).setAttribute("nombre","ticuOidTipoCursGapTdId" );
      ((Element)v.get(694)).setAttribute("nowrap","true" );
      ((Element)v.get(694)).setAttribute("class","datosCampos" );
      ((Element)v.get(667)).appendChild((Element)v.get(694));

      /* Empieza nodo:695 / Elemento padre: 694   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(695)).setAttribute("src","b.gif" );
      ((Element)v.get(695)).setAttribute("width","25" );
      ((Element)v.get(695)).setAttribute("height","8" );
      ((Element)v.get(694)).appendChild((Element)v.get(695));
      /* Termina nodo:695   */
      /* Termina nodo:694   */

      /* Empieza nodo:696 / Elemento padre: 667   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(696)).setAttribute("width","100%" );
      ((Element)v.get(667)).appendChild((Element)v.get(696));

      /* Empieza nodo:697 / Elemento padre: 696   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(697)).setAttribute("src","b.gif" );
      ((Element)v.get(696)).appendChild((Element)v.get(697));
      /* Termina nodo:697   */
      /* Termina nodo:696   */
      /* Termina nodo:667   */
      /* Termina nodo:666   */
      /* Termina nodo:665   */
      /* Termina nodo:662   */

      /* Empieza nodo:698 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(698)).setAttribute("nombre","formGapTr18" );
      ((Element)v.get(40)).appendChild((Element)v.get(698));

      /* Empieza nodo:699 / Elemento padre: 698   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(699)).setAttribute("align","center" );
      ((Element)v.get(699)).setAttribute("width","12" );
      ((Element)v.get(698)).appendChild((Element)v.get(699));

      /* Empieza nodo:700 / Elemento padre: 699   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(700)).setAttribute("src","b.gif" );
      ((Element)v.get(700)).setAttribute("width","12" );
      ((Element)v.get(700)).setAttribute("height","8" );
      ((Element)v.get(699)).appendChild((Element)v.get(700));
      /* Termina nodo:700   */
      /* Termina nodo:699   */

      /* Empieza nodo:701 / Elemento padre: 698   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(698)).appendChild((Element)v.get(701));

      /* Empieza nodo:702 / Elemento padre: 701   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(702)).setAttribute("src","b.gif" );
      ((Element)v.get(702)).setAttribute("width","8" );
      ((Element)v.get(702)).setAttribute("height","8" );
      ((Element)v.get(701)).appendChild((Element)v.get(702));
      /* Termina nodo:702   */
      /* Termina nodo:701   */

      /* Empieza nodo:703 / Elemento padre: 698   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(703)).setAttribute("align","center" );
      ((Element)v.get(703)).setAttribute("width","12" );
      ((Element)v.get(698)).appendChild((Element)v.get(703));

      /* Empieza nodo:704 / Elemento padre: 703   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(704)).setAttribute("src","b.gif" );
      ((Element)v.get(704)).setAttribute("width","12" );
      ((Element)v.get(704)).setAttribute("height","8" );
      ((Element)v.get(703)).appendChild((Element)v.get(704));
      /* Termina nodo:704   */
      /* Termina nodo:703   */
      /* Termina nodo:698   */

      /* Empieza nodo:705 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(705)).setAttribute("nombre","formTr19" );
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
      ((Element)v.get(707)).setAttribute("height","12" );
      ((Element)v.get(706)).appendChild((Element)v.get(707));
      /* Termina nodo:707   */
      /* Termina nodo:706   */

      /* Empieza nodo:708 / Elemento padre: 705   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(708)).setAttribute("width","100%" );
      ((Element)v.get(705)).appendChild((Element)v.get(708));

      /* Empieza nodo:709 / Elemento padre: 708   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(709)).setAttribute("width","100%" );
      ((Element)v.get(709)).setAttribute("border","0" );
      ((Element)v.get(709)).setAttribute("cellspacing","0" );
      ((Element)v.get(709)).setAttribute("cellpadding","0" );
      ((Element)v.get(709)).setAttribute("align","left" );
      ((Element)v.get(708)).appendChild((Element)v.get(709));

      /* Empieza nodo:710 / Elemento padre: 709   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(710)).setAttribute("align","left" );
      ((Element)v.get(709)).appendChild((Element)v.get(710));

      /* Empieza nodo:711 / Elemento padre: 710   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(711)).setAttribute("nombre","valPathFichTdId" );
      ((Element)v.get(710)).appendChild((Element)v.get(711));

      /* Empieza nodo:712 / Elemento padre: 711   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(712)).setAttribute("width","100%" );
      ((Element)v.get(712)).setAttribute("border","0" );
      ((Element)v.get(712)).setAttribute("cellspacing","0" );
      ((Element)v.get(712)).setAttribute("cellpadding","0" );
      ((Element)v.get(712)).setAttribute("align","left" );
      ((Element)v.get(711)).appendChild((Element)v.get(712));

      /* Empieza nodo:713 / Elemento padre: 712   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(712)).appendChild((Element)v.get(713));

      /* Empieza nodo:714 / Elemento padre: 713   */
   }

   private void getXML3240(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(714)).setAttribute("valign","top" );
      ((Element)v.get(714)).setAttribute("height","13" );
      ((Element)v.get(713)).appendChild((Element)v.get(714));

      /* Empieza nodo:715 / Elemento padre: 714   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(715)).setAttribute("nombre","lblValPathFich" );
      ((Element)v.get(715)).setAttribute("alto","13" );
      ((Element)v.get(715)).setAttribute("filas","1" );
      ((Element)v.get(715)).setAttribute("id","datosTitle" );
      ((Element)v.get(715)).setAttribute("cod","EduMatriCurso.valPathFich.label" );
      ((Element)v.get(714)).appendChild((Element)v.get(715));
      /* Termina nodo:715   */
      /* Termina nodo:714   */
      /* Termina nodo:713   */

      /* Empieza nodo:716 / Elemento padre: 712   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(716)).setAttribute("nombre","valPathFichWidgetTrId" );
      ((Element)v.get(712)).appendChild((Element)v.get(716));

      /* Empieza nodo:717 / Elemento padre: 716   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(717)).setAttribute("align","left" );
      ((Element)v.get(717)).setAttribute("nowrap","true" );
      ((Element)v.get(716)).appendChild((Element)v.get(717));

      /* Empieza nodo:718 / Elemento padre: 717   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(718)).setAttribute("nombre","valPathFich" );
      ((Element)v.get(718)).setAttribute("id","datosCampos" );
      ((Element)v.get(718)).setAttribute("trim","S" );
      ((Element)v.get(718)).setAttribute("max","240" );
      ((Element)v.get(718)).setAttribute("onchange","" );
      ((Element)v.get(718)).setAttribute("req","N" );
      ((Element)v.get(718)).setAttribute("size","240" );
      ((Element)v.get(718)).setAttribute("valor","" );
      ((Element)v.get(718)).setAttribute("validacion","" );
      ((Element)v.get(718)).setAttribute("onblur","" );
      ((Element)v.get(718)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true)" );
      ((Element)v.get(718)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm', 0, false)" );
      ((Element)v.get(717)).appendChild((Element)v.get(718));
      /* Termina nodo:718   */
      /* Termina nodo:717   */
      /* Termina nodo:716   */

      /* Empieza nodo:719 / Elemento padre: 712   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(719)).setAttribute("nombre","valPathFichViewLabelTrId" );
      ((Element)v.get(712)).appendChild((Element)v.get(719));

      /* Empieza nodo:720 / Elemento padre: 719   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(720)).setAttribute("valign","top" );
      ((Element)v.get(720)).setAttribute("height","13" );
      ((Element)v.get(719)).appendChild((Element)v.get(720));

      /* Empieza nodo:721 / Elemento padre: 720   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(721)).setAttribute("nombre","lblViewValPathFich" );
      ((Element)v.get(721)).setAttribute("alto","13" );
      ((Element)v.get(721)).setAttribute("ancho","100" );
      ((Element)v.get(721)).setAttribute("id","EstDat" );
      ((Element)v.get(721)).setAttribute("valor","" );
      ((Element)v.get(720)).appendChild((Element)v.get(721));
      /* Termina nodo:721   */
      /* Termina nodo:720   */
      /* Termina nodo:719   */
      /* Termina nodo:712   */
      /* Termina nodo:711   */

      /* Empieza nodo:722 / Elemento padre: 710   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(722)).setAttribute("nombre","valPathFichGapTdId" );
      ((Element)v.get(722)).setAttribute("nowrap","true" );
      ((Element)v.get(722)).setAttribute("class","datosCampos" );
      ((Element)v.get(710)).appendChild((Element)v.get(722));

      /* Empieza nodo:723 / Elemento padre: 722   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(723)).setAttribute("src","b.gif" );
      ((Element)v.get(723)).setAttribute("width","25" );
      ((Element)v.get(723)).setAttribute("height","8" );
      ((Element)v.get(722)).appendChild((Element)v.get(723));
      /* Termina nodo:723   */
      /* Termina nodo:722   */

      /* Empieza nodo:724 / Elemento padre: 710   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(724)).setAttribute("width","100%" );
      ((Element)v.get(710)).appendChild((Element)v.get(724));

      /* Empieza nodo:725 / Elemento padre: 724   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(725)).setAttribute("src","b.gif" );
      ((Element)v.get(724)).appendChild((Element)v.get(725));
      /* Termina nodo:725   */
      /* Termina nodo:724   */
      /* Termina nodo:710   */
      /* Termina nodo:709   */
      /* Termina nodo:708   */
      /* Termina nodo:705   */

      /* Empieza nodo:726 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(726)).setAttribute("nombre","formGapTr19" );
      ((Element)v.get(40)).appendChild((Element)v.get(726));

      /* Empieza nodo:727 / Elemento padre: 726   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(727)).setAttribute("align","center" );
      ((Element)v.get(727)).setAttribute("width","12" );
      ((Element)v.get(726)).appendChild((Element)v.get(727));

      /* Empieza nodo:728 / Elemento padre: 727   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(728)).setAttribute("src","b.gif" );
      ((Element)v.get(728)).setAttribute("width","12" );
      ((Element)v.get(728)).setAttribute("height","8" );
      ((Element)v.get(727)).appendChild((Element)v.get(728));
      /* Termina nodo:728   */
      /* Termina nodo:727   */

      /* Empieza nodo:729 / Elemento padre: 726   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(726)).appendChild((Element)v.get(729));

      /* Empieza nodo:730 / Elemento padre: 729   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(730)).setAttribute("src","b.gif" );
      ((Element)v.get(730)).setAttribute("width","8" );
      ((Element)v.get(730)).setAttribute("height","8" );
      ((Element)v.get(729)).appendChild((Element)v.get(730));
      /* Termina nodo:730   */
      /* Termina nodo:729   */

      /* Empieza nodo:731 / Elemento padre: 726   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(731)).setAttribute("align","center" );
      ((Element)v.get(731)).setAttribute("width","12" );
      ((Element)v.get(726)).appendChild((Element)v.get(731));

      /* Empieza nodo:732 / Elemento padre: 731   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(732)).setAttribute("src","b.gif" );
      ((Element)v.get(732)).setAttribute("width","12" );
      ((Element)v.get(732)).setAttribute("height","8" );
      ((Element)v.get(731)).appendChild((Element)v.get(732));
      /* Termina nodo:732   */
      /* Termina nodo:731   */
      /* Termina nodo:726   */

      /* Empieza nodo:733 / Elemento padre: 40   */
   }

   private void getXML3330(Document doc) {
      v.add(doc.createElement("TR"));
      ((Element)v.get(733)).setAttribute("nombre","formTr20" );
      ((Element)v.get(40)).appendChild((Element)v.get(733));

      /* Empieza nodo:734 / Elemento padre: 733   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(734)).setAttribute("align","center" );
      ((Element)v.get(734)).setAttribute("width","12" );
      ((Element)v.get(733)).appendChild((Element)v.get(734));

      /* Empieza nodo:735 / Elemento padre: 734   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(735)).setAttribute("src","b.gif" );
      ((Element)v.get(735)).setAttribute("width","12" );
      ((Element)v.get(735)).setAttribute("height","12" );
      ((Element)v.get(734)).appendChild((Element)v.get(735));
      /* Termina nodo:735   */
      /* Termina nodo:734   */

      /* Empieza nodo:736 / Elemento padre: 733   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(736)).setAttribute("width","100%" );
      ((Element)v.get(733)).appendChild((Element)v.get(736));

      /* Empieza nodo:737 / Elemento padre: 736   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(737)).setAttribute("width","100%" );
      ((Element)v.get(737)).setAttribute("border","0" );
      ((Element)v.get(737)).setAttribute("cellspacing","0" );
      ((Element)v.get(737)).setAttribute("cellpadding","0" );
      ((Element)v.get(737)).setAttribute("align","left" );
      ((Element)v.get(736)).appendChild((Element)v.get(737));

      /* Empieza nodo:738 / Elemento padre: 737   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(738)).setAttribute("align","left" );
      ((Element)v.get(737)).appendChild((Element)v.get(738));

      /* Empieza nodo:739 / Elemento padre: 738   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(739)).setAttribute("nombre","valObjeCursTdId" );
      ((Element)v.get(738)).appendChild((Element)v.get(739));

      /* Empieza nodo:740 / Elemento padre: 739   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(740)).setAttribute("width","100%" );
      ((Element)v.get(740)).setAttribute("border","0" );
      ((Element)v.get(740)).setAttribute("cellspacing","0" );
      ((Element)v.get(740)).setAttribute("cellpadding","0" );
      ((Element)v.get(740)).setAttribute("align","left" );
      ((Element)v.get(739)).appendChild((Element)v.get(740));

      /* Empieza nodo:741 / Elemento padre: 740   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(740)).appendChild((Element)v.get(741));

      /* Empieza nodo:742 / Elemento padre: 741   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(742)).setAttribute("valign","top" );
      ((Element)v.get(742)).setAttribute("height","13" );
      ((Element)v.get(741)).appendChild((Element)v.get(742));

      /* Empieza nodo:743 / Elemento padre: 742   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(743)).setAttribute("nombre","lblValObjeCurs" );
      ((Element)v.get(743)).setAttribute("alto","13" );
      ((Element)v.get(743)).setAttribute("filas","1" );
      ((Element)v.get(743)).setAttribute("id","datosTitle" );
      ((Element)v.get(743)).setAttribute("cod","EduMatriCurso.valObjeCurs.label" );
      ((Element)v.get(742)).appendChild((Element)v.get(743));
      /* Termina nodo:743   */
      /* Termina nodo:742   */
      /* Termina nodo:741   */

      /* Empieza nodo:744 / Elemento padre: 740   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(744)).setAttribute("nombre","valObjeCursWidgetTrId" );
      ((Element)v.get(740)).appendChild((Element)v.get(744));

      /* Empieza nodo:745 / Elemento padre: 744   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(745)).setAttribute("align","left" );
      ((Element)v.get(745)).setAttribute("nowrap","true" );
      ((Element)v.get(744)).appendChild((Element)v.get(745));

      /* Empieza nodo:746 / Elemento padre: 745   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(746)).setAttribute("nombre","valObjeCurs" );
      ((Element)v.get(746)).setAttribute("id","datosCampos" );
      ((Element)v.get(746)).setAttribute("trim","S" );
      ((Element)v.get(746)).setAttribute("max","30" );
      ((Element)v.get(746)).setAttribute("onchange","" );
      ((Element)v.get(746)).setAttribute("req","N" );
      ((Element)v.get(746)).setAttribute("size","30" );
      ((Element)v.get(746)).setAttribute("valor","" );
      ((Element)v.get(746)).setAttribute("validacion","" );
      ((Element)v.get(746)).setAttribute("onblur","" );
      ((Element)v.get(746)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true)" );
      ((Element)v.get(746)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm', 0, false)" );
      ((Element)v.get(745)).appendChild((Element)v.get(746));
      /* Termina nodo:746   */
      /* Termina nodo:745   */
      /* Termina nodo:744   */

      /* Empieza nodo:747 / Elemento padre: 740   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(747)).setAttribute("nombre","valObjeCursViewLabelTrId" );
      ((Element)v.get(740)).appendChild((Element)v.get(747));

      /* Empieza nodo:748 / Elemento padre: 747   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(748)).setAttribute("valign","top" );
      ((Element)v.get(748)).setAttribute("height","13" );
      ((Element)v.get(747)).appendChild((Element)v.get(748));

      /* Empieza nodo:749 / Elemento padre: 748   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(749)).setAttribute("nombre","lblViewValObjeCurs" );
      ((Element)v.get(749)).setAttribute("alto","13" );
      ((Element)v.get(749)).setAttribute("ancho","100" );
      ((Element)v.get(749)).setAttribute("id","EstDat" );
      ((Element)v.get(749)).setAttribute("valor","" );
      ((Element)v.get(748)).appendChild((Element)v.get(749));
      /* Termina nodo:749   */
      /* Termina nodo:748   */
      /* Termina nodo:747   */
      /* Termina nodo:740   */
      /* Termina nodo:739   */

      /* Empieza nodo:750 / Elemento padre: 738   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(750)).setAttribute("nombre","valObjeCursGapTdId" );
      ((Element)v.get(750)).setAttribute("nowrap","true" );
      ((Element)v.get(750)).setAttribute("class","datosCampos" );
      ((Element)v.get(738)).appendChild((Element)v.get(750));

      /* Empieza nodo:751 / Elemento padre: 750   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(751)).setAttribute("src","b.gif" );
   }

   private void getXML3420(Document doc) {
      ((Element)v.get(751)).setAttribute("width","25" );
      ((Element)v.get(751)).setAttribute("height","8" );
      ((Element)v.get(750)).appendChild((Element)v.get(751));
      /* Termina nodo:751   */
      /* Termina nodo:750   */

      /* Empieza nodo:752 / Elemento padre: 738   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(752)).setAttribute("width","100%" );
      ((Element)v.get(738)).appendChild((Element)v.get(752));

      /* Empieza nodo:753 / Elemento padre: 752   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(753)).setAttribute("src","b.gif" );
      ((Element)v.get(752)).appendChild((Element)v.get(753));
      /* Termina nodo:753   */
      /* Termina nodo:752   */
      /* Termina nodo:738   */
      /* Termina nodo:737   */
      /* Termina nodo:736   */
      /* Termina nodo:733   */

      /* Empieza nodo:754 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(754)).setAttribute("nombre","formGapTr20" );
      ((Element)v.get(40)).appendChild((Element)v.get(754));

      /* Empieza nodo:755 / Elemento padre: 754   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(755)).setAttribute("align","center" );
      ((Element)v.get(755)).setAttribute("width","12" );
      ((Element)v.get(754)).appendChild((Element)v.get(755));

      /* Empieza nodo:756 / Elemento padre: 755   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(756)).setAttribute("src","b.gif" );
      ((Element)v.get(756)).setAttribute("width","12" );
      ((Element)v.get(756)).setAttribute("height","8" );
      ((Element)v.get(755)).appendChild((Element)v.get(756));
      /* Termina nodo:756   */
      /* Termina nodo:755   */

      /* Empieza nodo:757 / Elemento padre: 754   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(754)).appendChild((Element)v.get(757));

      /* Empieza nodo:758 / Elemento padre: 757   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(758)).setAttribute("src","b.gif" );
      ((Element)v.get(758)).setAttribute("width","8" );
      ((Element)v.get(758)).setAttribute("height","8" );
      ((Element)v.get(757)).appendChild((Element)v.get(758));
      /* Termina nodo:758   */
      /* Termina nodo:757   */

      /* Empieza nodo:759 / Elemento padre: 754   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(759)).setAttribute("align","center" );
      ((Element)v.get(759)).setAttribute("width","12" );
      ((Element)v.get(754)).appendChild((Element)v.get(759));

      /* Empieza nodo:760 / Elemento padre: 759   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(760)).setAttribute("src","b.gif" );
      ((Element)v.get(760)).setAttribute("width","12" );
      ((Element)v.get(760)).setAttribute("height","8" );
      ((Element)v.get(759)).appendChild((Element)v.get(760));
      /* Termina nodo:760   */
      /* Termina nodo:759   */
      /* Termina nodo:754   */

      /* Empieza nodo:761 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(761)).setAttribute("nombre","formTr21" );
      ((Element)v.get(40)).appendChild((Element)v.get(761));

      /* Empieza nodo:762 / Elemento padre: 761   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(762)).setAttribute("align","center" );
      ((Element)v.get(762)).setAttribute("width","12" );
      ((Element)v.get(761)).appendChild((Element)v.get(762));

      /* Empieza nodo:763 / Elemento padre: 762   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(763)).setAttribute("src","b.gif" );
      ((Element)v.get(763)).setAttribute("width","12" );
      ((Element)v.get(763)).setAttribute("height","12" );
      ((Element)v.get(762)).appendChild((Element)v.get(763));
      /* Termina nodo:763   */
      /* Termina nodo:762   */

      /* Empieza nodo:764 / Elemento padre: 761   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(764)).setAttribute("width","100%" );
      ((Element)v.get(761)).appendChild((Element)v.get(764));

      /* Empieza nodo:765 / Elemento padre: 764   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(765)).setAttribute("width","100%" );
      ((Element)v.get(765)).setAttribute("border","0" );
      ((Element)v.get(765)).setAttribute("cellspacing","0" );
      ((Element)v.get(765)).setAttribute("cellpadding","0" );
      ((Element)v.get(765)).setAttribute("align","left" );
      ((Element)v.get(764)).appendChild((Element)v.get(765));

      /* Empieza nodo:766 / Elemento padre: 765   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(766)).setAttribute("align","left" );
      ((Element)v.get(765)).appendChild((Element)v.get(766));

      /* Empieza nodo:767 / Elemento padre: 766   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(767)).setAttribute("nombre","valContCursTdId" );
      ((Element)v.get(766)).appendChild((Element)v.get(767));

      /* Empieza nodo:768 / Elemento padre: 767   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(768)).setAttribute("width","100%" );
      ((Element)v.get(768)).setAttribute("border","0" );
      ((Element)v.get(768)).setAttribute("cellspacing","0" );
      ((Element)v.get(768)).setAttribute("cellpadding","0" );
      ((Element)v.get(768)).setAttribute("align","left" );
      ((Element)v.get(767)).appendChild((Element)v.get(768));

      /* Empieza nodo:769 / Elemento padre: 768   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(768)).appendChild((Element)v.get(769));

      /* Empieza nodo:770 / Elemento padre: 769   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(770)).setAttribute("valign","top" );
      ((Element)v.get(770)).setAttribute("height","13" );
      ((Element)v.get(769)).appendChild((Element)v.get(770));

      /* Empieza nodo:771 / Elemento padre: 770   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(771)).setAttribute("nombre","lblValContCurs" );
      ((Element)v.get(771)).setAttribute("alto","13" );
      ((Element)v.get(771)).setAttribute("filas","1" );
      ((Element)v.get(771)).setAttribute("id","datosTitle" );
      ((Element)v.get(771)).setAttribute("cod","EduMatriCurso.valContCurs.label" );
      ((Element)v.get(770)).appendChild((Element)v.get(771));
      /* Termina nodo:771   */
      /* Termina nodo:770   */
      /* Termina nodo:769   */

      /* Empieza nodo:772 / Elemento padre: 768   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(772)).setAttribute("nombre","valContCursWidgetTrId" );
      ((Element)v.get(768)).appendChild((Element)v.get(772));

      /* Empieza nodo:773 / Elemento padre: 772   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(773)).setAttribute("align","left" );
   }

   private void getXML3510(Document doc) {
      ((Element)v.get(773)).setAttribute("nowrap","true" );
      ((Element)v.get(772)).appendChild((Element)v.get(773));

      /* Empieza nodo:774 / Elemento padre: 773   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(774)).setAttribute("nombre","valContCurs" );
      ((Element)v.get(774)).setAttribute("id","datosCampos" );
      ((Element)v.get(774)).setAttribute("trim","S" );
      ((Element)v.get(774)).setAttribute("max","30" );
      ((Element)v.get(774)).setAttribute("onchange","" );
      ((Element)v.get(774)).setAttribute("req","N" );
      ((Element)v.get(774)).setAttribute("size","30" );
      ((Element)v.get(774)).setAttribute("valor","" );
      ((Element)v.get(774)).setAttribute("validacion","" );
      ((Element)v.get(774)).setAttribute("onblur","" );
      ((Element)v.get(774)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true)" );
      ((Element)v.get(774)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm', 0, false)" );
      ((Element)v.get(773)).appendChild((Element)v.get(774));
      /* Termina nodo:774   */
      /* Termina nodo:773   */
      /* Termina nodo:772   */

      /* Empieza nodo:775 / Elemento padre: 768   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(775)).setAttribute("nombre","valContCursViewLabelTrId" );
      ((Element)v.get(768)).appendChild((Element)v.get(775));

      /* Empieza nodo:776 / Elemento padre: 775   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(776)).setAttribute("valign","top" );
      ((Element)v.get(776)).setAttribute("height","13" );
      ((Element)v.get(775)).appendChild((Element)v.get(776));

      /* Empieza nodo:777 / Elemento padre: 776   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(777)).setAttribute("nombre","lblViewValContCurs" );
      ((Element)v.get(777)).setAttribute("alto","13" );
      ((Element)v.get(777)).setAttribute("ancho","100" );
      ((Element)v.get(777)).setAttribute("id","EstDat" );
      ((Element)v.get(777)).setAttribute("valor","" );
      ((Element)v.get(776)).appendChild((Element)v.get(777));
      /* Termina nodo:777   */
      /* Termina nodo:776   */
      /* Termina nodo:775   */
      /* Termina nodo:768   */
      /* Termina nodo:767   */

      /* Empieza nodo:778 / Elemento padre: 766   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(778)).setAttribute("nombre","valContCursGapTdId" );
      ((Element)v.get(778)).setAttribute("nowrap","true" );
      ((Element)v.get(778)).setAttribute("class","datosCampos" );
      ((Element)v.get(766)).appendChild((Element)v.get(778));

      /* Empieza nodo:779 / Elemento padre: 778   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(779)).setAttribute("src","b.gif" );
      ((Element)v.get(779)).setAttribute("width","25" );
      ((Element)v.get(779)).setAttribute("height","8" );
      ((Element)v.get(778)).appendChild((Element)v.get(779));
      /* Termina nodo:779   */
      /* Termina nodo:778   */

      /* Empieza nodo:780 / Elemento padre: 766   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(780)).setAttribute("width","100%" );
      ((Element)v.get(766)).appendChild((Element)v.get(780));

      /* Empieza nodo:781 / Elemento padre: 780   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(781)).setAttribute("src","b.gif" );
      ((Element)v.get(780)).appendChild((Element)v.get(781));
      /* Termina nodo:781   */
      /* Termina nodo:780   */
      /* Termina nodo:766   */
      /* Termina nodo:765   */
      /* Termina nodo:764   */
      /* Termina nodo:761   */

      /* Empieza nodo:782 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(782)).setAttribute("nombre","formGapTr21" );
      ((Element)v.get(40)).appendChild((Element)v.get(782));

      /* Empieza nodo:783 / Elemento padre: 782   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(783)).setAttribute("align","center" );
      ((Element)v.get(783)).setAttribute("width","12" );
      ((Element)v.get(782)).appendChild((Element)v.get(783));

      /* Empieza nodo:784 / Elemento padre: 783   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(784)).setAttribute("src","b.gif" );
      ((Element)v.get(784)).setAttribute("width","12" );
      ((Element)v.get(784)).setAttribute("height","8" );
      ((Element)v.get(783)).appendChild((Element)v.get(784));
      /* Termina nodo:784   */
      /* Termina nodo:783   */

      /* Empieza nodo:785 / Elemento padre: 782   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(782)).appendChild((Element)v.get(785));

      /* Empieza nodo:786 / Elemento padre: 785   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(786)).setAttribute("src","b.gif" );
      ((Element)v.get(786)).setAttribute("width","8" );
      ((Element)v.get(786)).setAttribute("height","8" );
      ((Element)v.get(785)).appendChild((Element)v.get(786));
      /* Termina nodo:786   */
      /* Termina nodo:785   */

      /* Empieza nodo:787 / Elemento padre: 782   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(787)).setAttribute("align","center" );
      ((Element)v.get(787)).setAttribute("width","12" );
      ((Element)v.get(782)).appendChild((Element)v.get(787));

      /* Empieza nodo:788 / Elemento padre: 787   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(788)).setAttribute("src","b.gif" );
      ((Element)v.get(788)).setAttribute("width","12" );
      ((Element)v.get(788)).setAttribute("height","8" );
      ((Element)v.get(787)).appendChild((Element)v.get(788));
      /* Termina nodo:788   */
      /* Termina nodo:787   */
      /* Termina nodo:782   */

      /* Empieza nodo:789 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(789)).setAttribute("nombre","formTr22" );
      ((Element)v.get(40)).appendChild((Element)v.get(789));

      /* Empieza nodo:790 / Elemento padre: 789   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(790)).setAttribute("align","center" );
      ((Element)v.get(790)).setAttribute("width","12" );
      ((Element)v.get(789)).appendChild((Element)v.get(790));

      /* Empieza nodo:791 / Elemento padre: 790   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(791)).setAttribute("src","b.gif" );
      ((Element)v.get(791)).setAttribute("width","12" );
      ((Element)v.get(791)).setAttribute("height","12" );
      ((Element)v.get(790)).appendChild((Element)v.get(791));
      /* Termina nodo:791   */
      /* Termina nodo:790   */

      /* Empieza nodo:792 / Elemento padre: 789   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(792)).setAttribute("width","100%" );
      ((Element)v.get(789)).appendChild((Element)v.get(792));

      /* Empieza nodo:793 / Elemento padre: 792   */
      v.add(doc.createElement("TABLE"));
   }

   private void getXML3600(Document doc) {
      ((Element)v.get(793)).setAttribute("width","100%" );
      ((Element)v.get(793)).setAttribute("border","0" );
      ((Element)v.get(793)).setAttribute("cellspacing","0" );
      ((Element)v.get(793)).setAttribute("cellpadding","0" );
      ((Element)v.get(793)).setAttribute("align","left" );
      ((Element)v.get(792)).appendChild((Element)v.get(793));

      /* Empieza nodo:794 / Elemento padre: 793   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(794)).setAttribute("align","left" );
      ((Element)v.get(793)).appendChild((Element)v.get(794));

      /* Empieza nodo:795 / Elemento padre: 794   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(795)).setAttribute("nombre","valRelaMateCursTdId" );
      ((Element)v.get(794)).appendChild((Element)v.get(795));

      /* Empieza nodo:796 / Elemento padre: 795   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(796)).setAttribute("width","100%" );
      ((Element)v.get(796)).setAttribute("border","0" );
      ((Element)v.get(796)).setAttribute("cellspacing","0" );
      ((Element)v.get(796)).setAttribute("cellpadding","0" );
      ((Element)v.get(796)).setAttribute("align","left" );
      ((Element)v.get(795)).appendChild((Element)v.get(796));

      /* Empieza nodo:797 / Elemento padre: 796   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(796)).appendChild((Element)v.get(797));

      /* Empieza nodo:798 / Elemento padre: 797   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(798)).setAttribute("valign","top" );
      ((Element)v.get(798)).setAttribute("height","13" );
      ((Element)v.get(797)).appendChild((Element)v.get(798));

      /* Empieza nodo:799 / Elemento padre: 798   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(799)).setAttribute("nombre","lblValRelaMateCurs" );
      ((Element)v.get(799)).setAttribute("alto","13" );
      ((Element)v.get(799)).setAttribute("filas","1" );
      ((Element)v.get(799)).setAttribute("id","datosTitle" );
      ((Element)v.get(799)).setAttribute("cod","EduMatriCurso.valRelaMateCurs.label" );
      ((Element)v.get(798)).appendChild((Element)v.get(799));
      /* Termina nodo:799   */
      /* Termina nodo:798   */
      /* Termina nodo:797   */

      /* Empieza nodo:800 / Elemento padre: 796   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(800)).setAttribute("nombre","valRelaMateCursWidgetTrId" );
      ((Element)v.get(796)).appendChild((Element)v.get(800));

      /* Empieza nodo:801 / Elemento padre: 800   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(801)).setAttribute("align","left" );
      ((Element)v.get(801)).setAttribute("nowrap","true" );
      ((Element)v.get(800)).appendChild((Element)v.get(801));

      /* Empieza nodo:802 / Elemento padre: 801   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(802)).setAttribute("nombre","valRelaMateCurs" );
      ((Element)v.get(802)).setAttribute("id","datosCampos" );
      ((Element)v.get(802)).setAttribute("trim","S" );
      ((Element)v.get(802)).setAttribute("max","30" );
      ((Element)v.get(802)).setAttribute("onchange","" );
      ((Element)v.get(802)).setAttribute("req","N" );
      ((Element)v.get(802)).setAttribute("size","30" );
      ((Element)v.get(802)).setAttribute("valor","" );
      ((Element)v.get(802)).setAttribute("validacion","" );
      ((Element)v.get(802)).setAttribute("onblur","" );
      ((Element)v.get(802)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true)" );
      ((Element)v.get(802)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm', 0, false)" );
      ((Element)v.get(801)).appendChild((Element)v.get(802));
      /* Termina nodo:802   */
      /* Termina nodo:801   */
      /* Termina nodo:800   */

      /* Empieza nodo:803 / Elemento padre: 796   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(803)).setAttribute("nombre","valRelaMateCursViewLabelTrId" );
      ((Element)v.get(796)).appendChild((Element)v.get(803));

      /* Empieza nodo:804 / Elemento padre: 803   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(804)).setAttribute("valign","top" );
      ((Element)v.get(804)).setAttribute("height","13" );
      ((Element)v.get(803)).appendChild((Element)v.get(804));

      /* Empieza nodo:805 / Elemento padre: 804   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(805)).setAttribute("nombre","lblViewValRelaMateCurs" );
      ((Element)v.get(805)).setAttribute("alto","13" );
      ((Element)v.get(805)).setAttribute("ancho","100" );
      ((Element)v.get(805)).setAttribute("id","EstDat" );
      ((Element)v.get(805)).setAttribute("valor","" );
      ((Element)v.get(804)).appendChild((Element)v.get(805));
      /* Termina nodo:805   */
      /* Termina nodo:804   */
      /* Termina nodo:803   */
      /* Termina nodo:796   */
      /* Termina nodo:795   */

      /* Empieza nodo:806 / Elemento padre: 794   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(806)).setAttribute("nombre","valRelaMateCursGapTdId" );
      ((Element)v.get(806)).setAttribute("nowrap","true" );
      ((Element)v.get(806)).setAttribute("class","datosCampos" );
      ((Element)v.get(794)).appendChild((Element)v.get(806));

      /* Empieza nodo:807 / Elemento padre: 806   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(807)).setAttribute("src","b.gif" );
      ((Element)v.get(807)).setAttribute("width","25" );
      ((Element)v.get(807)).setAttribute("height","8" );
      ((Element)v.get(806)).appendChild((Element)v.get(807));
      /* Termina nodo:807   */
      /* Termina nodo:806   */

      /* Empieza nodo:808 / Elemento padre: 794   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(808)).setAttribute("width","100%" );
      ((Element)v.get(794)).appendChild((Element)v.get(808));

      /* Empieza nodo:809 / Elemento padre: 808   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(809)).setAttribute("src","b.gif" );
      ((Element)v.get(808)).appendChild((Element)v.get(809));
      /* Termina nodo:809   */
      /* Termina nodo:808   */
      /* Termina nodo:794   */
      /* Termina nodo:793   */
      /* Termina nodo:792   */
      /* Termina nodo:789   */

      /* Empieza nodo:810 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(810)).setAttribute("nombre","formGapTr22" );
      ((Element)v.get(40)).appendChild((Element)v.get(810));

      /* Empieza nodo:811 / Elemento padre: 810   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(811)).setAttribute("align","center" );
      ((Element)v.get(811)).setAttribute("width","12" );
      ((Element)v.get(810)).appendChild((Element)v.get(811));

      /* Empieza nodo:812 / Elemento padre: 811   */
   }

   private void getXML3690(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(812)).setAttribute("src","b.gif" );
      ((Element)v.get(812)).setAttribute("width","12" );
      ((Element)v.get(812)).setAttribute("height","8" );
      ((Element)v.get(811)).appendChild((Element)v.get(812));
      /* Termina nodo:812   */
      /* Termina nodo:811   */

      /* Empieza nodo:813 / Elemento padre: 810   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(810)).appendChild((Element)v.get(813));

      /* Empieza nodo:814 / Elemento padre: 813   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(814)).setAttribute("src","b.gif" );
      ((Element)v.get(814)).setAttribute("width","8" );
      ((Element)v.get(814)).setAttribute("height","8" );
      ((Element)v.get(813)).appendChild((Element)v.get(814));
      /* Termina nodo:814   */
      /* Termina nodo:813   */

      /* Empieza nodo:815 / Elemento padre: 810   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(815)).setAttribute("align","center" );
      ((Element)v.get(815)).setAttribute("width","12" );
      ((Element)v.get(810)).appendChild((Element)v.get(815));

      /* Empieza nodo:816 / Elemento padre: 815   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(816)).setAttribute("src","b.gif" );
      ((Element)v.get(816)).setAttribute("width","12" );
      ((Element)v.get(816)).setAttribute("height","8" );
      ((Element)v.get(815)).appendChild((Element)v.get(816));
      /* Termina nodo:816   */
      /* Termina nodo:815   */
      /* Termina nodo:810   */

      /* Empieza nodo:817 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(817)).setAttribute("nombre","formTr23" );
      ((Element)v.get(40)).appendChild((Element)v.get(817));

      /* Empieza nodo:818 / Elemento padre: 817   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(818)).setAttribute("align","center" );
      ((Element)v.get(818)).setAttribute("width","12" );
      ((Element)v.get(817)).appendChild((Element)v.get(818));

      /* Empieza nodo:819 / Elemento padre: 818   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(819)).setAttribute("src","b.gif" );
      ((Element)v.get(819)).setAttribute("width","12" );
      ((Element)v.get(819)).setAttribute("height","12" );
      ((Element)v.get(818)).appendChild((Element)v.get(819));
      /* Termina nodo:819   */
      /* Termina nodo:818   */

      /* Empieza nodo:820 / Elemento padre: 817   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(820)).setAttribute("width","100%" );
      ((Element)v.get(817)).appendChild((Element)v.get(820));

      /* Empieza nodo:821 / Elemento padre: 820   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(821)).setAttribute("width","100%" );
      ((Element)v.get(821)).setAttribute("border","0" );
      ((Element)v.get(821)).setAttribute("cellspacing","0" );
      ((Element)v.get(821)).setAttribute("cellpadding","0" );
      ((Element)v.get(821)).setAttribute("align","left" );
      ((Element)v.get(820)).appendChild((Element)v.get(821));

      /* Empieza nodo:822 / Elemento padre: 821   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(822)).setAttribute("align","left" );
      ((Element)v.get(821)).appendChild((Element)v.get(822));

      /* Empieza nodo:823 / Elemento padre: 822   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(823)).setAttribute("nombre","valMontVentTdId" );
      ((Element)v.get(822)).appendChild((Element)v.get(823));

      /* Empieza nodo:824 / Elemento padre: 823   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(824)).setAttribute("width","100%" );
      ((Element)v.get(824)).setAttribute("border","0" );
      ((Element)v.get(824)).setAttribute("cellspacing","0" );
      ((Element)v.get(824)).setAttribute("cellpadding","0" );
      ((Element)v.get(824)).setAttribute("align","left" );
      ((Element)v.get(823)).appendChild((Element)v.get(824));

      /* Empieza nodo:825 / Elemento padre: 824   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(824)).appendChild((Element)v.get(825));

      /* Empieza nodo:826 / Elemento padre: 825   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(826)).setAttribute("valign","top" );
      ((Element)v.get(826)).setAttribute("height","13" );
      ((Element)v.get(825)).appendChild((Element)v.get(826));

      /* Empieza nodo:827 / Elemento padre: 826   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(827)).setAttribute("nombre","lblValMontVent" );
      ((Element)v.get(827)).setAttribute("alto","13" );
      ((Element)v.get(827)).setAttribute("filas","1" );
      ((Element)v.get(827)).setAttribute("id","datosTitle" );
      ((Element)v.get(827)).setAttribute("cod","EduMatriCurso.valMontVent.label" );
      ((Element)v.get(826)).appendChild((Element)v.get(827));
      /* Termina nodo:827   */
      /* Termina nodo:826   */
      /* Termina nodo:825   */

      /* Empieza nodo:828 / Elemento padre: 824   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(828)).setAttribute("nombre","valMontVentWidgetTrId" );
      ((Element)v.get(824)).appendChild((Element)v.get(828));

      /* Empieza nodo:829 / Elemento padre: 828   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(829)).setAttribute("align","left" );
      ((Element)v.get(829)).setAttribute("nowrap","true" );
      ((Element)v.get(828)).appendChild((Element)v.get(829));

      /* Empieza nodo:830 / Elemento padre: 829   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(830)).setAttribute("nombre","valMontVent" );
      ((Element)v.get(830)).setAttribute("id","datosCampos" );
      ((Element)v.get(830)).setAttribute("trim","S" );
      ((Element)v.get(830)).setAttribute("max","6" );
      ((Element)v.get(830)).setAttribute("onchange","" );
      ((Element)v.get(830)).setAttribute("req","N" );
      ((Element)v.get(830)).setAttribute("size","6" );
      ((Element)v.get(830)).setAttribute("valor","" );
      ((Element)v.get(830)).setAttribute("validacion","" );
      ((Element)v.get(830)).setAttribute("onblur","" );
      ((Element)v.get(830)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true)" );
      ((Element)v.get(830)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm', 0, false)" );
      ((Element)v.get(829)).appendChild((Element)v.get(830));
      /* Termina nodo:830   */
      /* Termina nodo:829   */
      /* Termina nodo:828   */

      /* Empieza nodo:831 / Elemento padre: 824   */
   }

   private void getXML3780(Document doc) {
      v.add(doc.createElement("TR"));
      ((Element)v.get(831)).setAttribute("nombre","valMontVentViewLabelTrId" );
      ((Element)v.get(824)).appendChild((Element)v.get(831));

      /* Empieza nodo:832 / Elemento padre: 831   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(832)).setAttribute("valign","top" );
      ((Element)v.get(832)).setAttribute("height","13" );
      ((Element)v.get(831)).appendChild((Element)v.get(832));

      /* Empieza nodo:833 / Elemento padre: 832   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(833)).setAttribute("nombre","lblViewValMontVent" );
      ((Element)v.get(833)).setAttribute("alto","13" );
      ((Element)v.get(833)).setAttribute("ancho","100" );
      ((Element)v.get(833)).setAttribute("id","EstDat" );
      ((Element)v.get(833)).setAttribute("valor","" );
      ((Element)v.get(832)).appendChild((Element)v.get(833));
      /* Termina nodo:833   */
      /* Termina nodo:832   */
      /* Termina nodo:831   */
      /* Termina nodo:824   */
      /* Termina nodo:823   */

      /* Empieza nodo:834 / Elemento padre: 822   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(834)).setAttribute("nombre","valMontVentGapTdId" );
      ((Element)v.get(834)).setAttribute("nowrap","true" );
      ((Element)v.get(834)).setAttribute("class","datosCampos" );
      ((Element)v.get(822)).appendChild((Element)v.get(834));

      /* Empieza nodo:835 / Elemento padre: 834   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(835)).setAttribute("src","b.gif" );
      ((Element)v.get(835)).setAttribute("width","25" );
      ((Element)v.get(835)).setAttribute("height","8" );
      ((Element)v.get(834)).appendChild((Element)v.get(835));
      /* Termina nodo:835   */
      /* Termina nodo:834   */

      /* Empieza nodo:836 / Elemento padre: 822   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(836)).setAttribute("width","100%" );
      ((Element)v.get(822)).appendChild((Element)v.get(836));

      /* Empieza nodo:837 / Elemento padre: 836   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(837)).setAttribute("src","b.gif" );
      ((Element)v.get(836)).appendChild((Element)v.get(837));
      /* Termina nodo:837   */
      /* Termina nodo:836   */
      /* Termina nodo:822   */
      /* Termina nodo:821   */
      /* Termina nodo:820   */
      /* Termina nodo:817   */

      /* Empieza nodo:838 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(838)).setAttribute("nombre","formGapTr23" );
      ((Element)v.get(40)).appendChild((Element)v.get(838));

      /* Empieza nodo:839 / Elemento padre: 838   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(839)).setAttribute("align","center" );
      ((Element)v.get(839)).setAttribute("width","12" );
      ((Element)v.get(838)).appendChild((Element)v.get(839));

      /* Empieza nodo:840 / Elemento padre: 839   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(840)).setAttribute("src","b.gif" );
      ((Element)v.get(840)).setAttribute("width","12" );
      ((Element)v.get(840)).setAttribute("height","8" );
      ((Element)v.get(839)).appendChild((Element)v.get(840));
      /* Termina nodo:840   */
      /* Termina nodo:839   */

      /* Empieza nodo:841 / Elemento padre: 838   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(838)).appendChild((Element)v.get(841));

      /* Empieza nodo:842 / Elemento padre: 841   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(842)).setAttribute("src","b.gif" );
      ((Element)v.get(842)).setAttribute("width","8" );
      ((Element)v.get(842)).setAttribute("height","8" );
      ((Element)v.get(841)).appendChild((Element)v.get(842));
      /* Termina nodo:842   */
      /* Termina nodo:841   */

      /* Empieza nodo:843 / Elemento padre: 838   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(843)).setAttribute("align","center" );
      ((Element)v.get(843)).setAttribute("width","12" );
      ((Element)v.get(838)).appendChild((Element)v.get(843));

      /* Empieza nodo:844 / Elemento padre: 843   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(844)).setAttribute("src","b.gif" );
      ((Element)v.get(844)).setAttribute("width","12" );
      ((Element)v.get(844)).setAttribute("height","8" );
      ((Element)v.get(843)).appendChild((Element)v.get(844));
      /* Termina nodo:844   */
      /* Termina nodo:843   */
      /* Termina nodo:838   */

      /* Empieza nodo:845 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(845)).setAttribute("nombre","formTr24" );
      ((Element)v.get(40)).appendChild((Element)v.get(845));

      /* Empieza nodo:846 / Elemento padre: 845   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(846)).setAttribute("align","center" );
      ((Element)v.get(846)).setAttribute("width","12" );
      ((Element)v.get(845)).appendChild((Element)v.get(846));

      /* Empieza nodo:847 / Elemento padre: 846   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(847)).setAttribute("src","b.gif" );
      ((Element)v.get(847)).setAttribute("width","12" );
      ((Element)v.get(847)).setAttribute("height","12" );
      ((Element)v.get(846)).appendChild((Element)v.get(847));
      /* Termina nodo:847   */
      /* Termina nodo:846   */

      /* Empieza nodo:848 / Elemento padre: 845   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(848)).setAttribute("width","100%" );
      ((Element)v.get(845)).appendChild((Element)v.get(848));

      /* Empieza nodo:849 / Elemento padre: 848   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(849)).setAttribute("width","100%" );
      ((Element)v.get(849)).setAttribute("border","0" );
      ((Element)v.get(849)).setAttribute("cellspacing","0" );
      ((Element)v.get(849)).setAttribute("cellpadding","0" );
      ((Element)v.get(849)).setAttribute("align","left" );
      ((Element)v.get(848)).appendChild((Element)v.get(849));

      /* Empieza nodo:850 / Elemento padre: 849   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(850)).setAttribute("align","left" );
      ((Element)v.get(849)).appendChild((Element)v.get(850));

      /* Empieza nodo:851 / Elemento padre: 850   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(851)).setAttribute("nombre","fecDispCursTdId" );
      ((Element)v.get(850)).appendChild((Element)v.get(851));

      /* Empieza nodo:852 / Elemento padre: 851   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(852)).setAttribute("width","100%" );
      ((Element)v.get(852)).setAttribute("border","0" );
      ((Element)v.get(852)).setAttribute("cellspacing","0" );
   }

   private void getXML3870(Document doc) {
      ((Element)v.get(852)).setAttribute("cellpadding","0" );
      ((Element)v.get(852)).setAttribute("align","left" );
      ((Element)v.get(851)).appendChild((Element)v.get(852));

      /* Empieza nodo:853 / Elemento padre: 852   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(852)).appendChild((Element)v.get(853));

      /* Empieza nodo:854 / Elemento padre: 853   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(854)).setAttribute("valign","top" );
      ((Element)v.get(854)).setAttribute("height","13" );
      ((Element)v.get(853)).appendChild((Element)v.get(854));

      /* Empieza nodo:855 / Elemento padre: 854   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(855)).setAttribute("nombre","lblFecDispCurs" );
      ((Element)v.get(855)).setAttribute("alto","13" );
      ((Element)v.get(855)).setAttribute("filas","1" );
      ((Element)v.get(855)).setAttribute("id","datosTitle" );
      ((Element)v.get(855)).setAttribute("cod","EduMatriCurso.fecDispCurs.label" );
      ((Element)v.get(854)).appendChild((Element)v.get(855));
      /* Termina nodo:855   */
      /* Termina nodo:854   */
      /* Termina nodo:853   */

      /* Empieza nodo:856 / Elemento padre: 852   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(856)).setAttribute("nombre","fecDispCursWidgetTrId" );
      ((Element)v.get(852)).appendChild((Element)v.get(856));

      /* Empieza nodo:857 / Elemento padre: 856   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(857)).setAttribute("align","left" );
      ((Element)v.get(857)).setAttribute("nowrap","true" );
      ((Element)v.get(856)).appendChild((Element)v.get(857));

      /* Empieza nodo:858 / Elemento padre: 857   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(858)).setAttribute("nombre","fecDispCurs" );
      ((Element)v.get(858)).setAttribute("id","datosCampos" );
      ((Element)v.get(858)).setAttribute("trim","S" );
      ((Element)v.get(858)).setAttribute("max","7" );
      ((Element)v.get(858)).setAttribute("onchange","" );
      ((Element)v.get(858)).setAttribute("req","N" );
      ((Element)v.get(858)).setAttribute("size","7" );
      ((Element)v.get(858)).setAttribute("valor","" );
      ((Element)v.get(858)).setAttribute("validacion","" );
      ((Element)v.get(858)).setAttribute("onblur","" );
      ((Element)v.get(858)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true)" );
      ((Element)v.get(858)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm', 0, false)" );
      ((Element)v.get(857)).appendChild((Element)v.get(858));
      /* Termina nodo:858   */
      /* Termina nodo:857   */
      /* Termina nodo:856   */

      /* Empieza nodo:859 / Elemento padre: 852   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(859)).setAttribute("nombre","fecDispCursViewLabelTrId" );
      ((Element)v.get(852)).appendChild((Element)v.get(859));

      /* Empieza nodo:860 / Elemento padre: 859   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(860)).setAttribute("valign","top" );
      ((Element)v.get(860)).setAttribute("height","13" );
      ((Element)v.get(859)).appendChild((Element)v.get(860));

      /* Empieza nodo:861 / Elemento padre: 860   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(861)).setAttribute("nombre","lblViewFecDispCurs" );
      ((Element)v.get(861)).setAttribute("alto","13" );
      ((Element)v.get(861)).setAttribute("ancho","100" );
      ((Element)v.get(861)).setAttribute("id","EstDat" );
      ((Element)v.get(861)).setAttribute("valor","" );
      ((Element)v.get(860)).appendChild((Element)v.get(861));
      /* Termina nodo:861   */
      /* Termina nodo:860   */
      /* Termina nodo:859   */
      /* Termina nodo:852   */
      /* Termina nodo:851   */

      /* Empieza nodo:862 / Elemento padre: 850   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(862)).setAttribute("nombre","fecDispCursGapTdId" );
      ((Element)v.get(862)).setAttribute("nowrap","true" );
      ((Element)v.get(862)).setAttribute("class","datosCampos" );
      ((Element)v.get(850)).appendChild((Element)v.get(862));

      /* Empieza nodo:863 / Elemento padre: 862   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(863)).setAttribute("src","b.gif" );
      ((Element)v.get(863)).setAttribute("width","25" );
      ((Element)v.get(863)).setAttribute("height","8" );
      ((Element)v.get(862)).appendChild((Element)v.get(863));
      /* Termina nodo:863   */
      /* Termina nodo:862   */

      /* Empieza nodo:864 / Elemento padre: 850   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(864)).setAttribute("width","100%" );
      ((Element)v.get(850)).appendChild((Element)v.get(864));

      /* Empieza nodo:865 / Elemento padre: 864   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(865)).setAttribute("src","b.gif" );
      ((Element)v.get(864)).appendChild((Element)v.get(865));
      /* Termina nodo:865   */
      /* Termina nodo:864   */
      /* Termina nodo:850   */
      /* Termina nodo:849   */
      /* Termina nodo:848   */
      /* Termina nodo:845   */

      /* Empieza nodo:866 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(866)).setAttribute("nombre","formGapTr24" );
      ((Element)v.get(40)).appendChild((Element)v.get(866));

      /* Empieza nodo:867 / Elemento padre: 866   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(867)).setAttribute("align","center" );
      ((Element)v.get(867)).setAttribute("width","12" );
      ((Element)v.get(866)).appendChild((Element)v.get(867));

      /* Empieza nodo:868 / Elemento padre: 867   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(868)).setAttribute("src","b.gif" );
      ((Element)v.get(868)).setAttribute("width","12" );
      ((Element)v.get(868)).setAttribute("height","8" );
      ((Element)v.get(867)).appendChild((Element)v.get(868));
      /* Termina nodo:868   */
      /* Termina nodo:867   */

      /* Empieza nodo:869 / Elemento padre: 866   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(866)).appendChild((Element)v.get(869));

      /* Empieza nodo:870 / Elemento padre: 869   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(870)).setAttribute("src","b.gif" );
      ((Element)v.get(870)).setAttribute("width","8" );
      ((Element)v.get(870)).setAttribute("height","8" );
      ((Element)v.get(869)).appendChild((Element)v.get(870));
      /* Termina nodo:870   */
      /* Termina nodo:869   */

      /* Empieza nodo:871 / Elemento padre: 866   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(871)).setAttribute("align","center" );
      ((Element)v.get(871)).setAttribute("width","12" );
      ((Element)v.get(866)).appendChild((Element)v.get(871));

      /* Empieza nodo:872 / Elemento padre: 871   */
   }

   private void getXML3960(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(872)).setAttribute("src","b.gif" );
      ((Element)v.get(872)).setAttribute("width","12" );
      ((Element)v.get(872)).setAttribute("height","8" );
      ((Element)v.get(871)).appendChild((Element)v.get(872));
      /* Termina nodo:872   */
      /* Termina nodo:871   */
      /* Termina nodo:866   */

      /* Empieza nodo:873 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(873)).setAttribute("nombre","formTr25" );
      ((Element)v.get(40)).appendChild((Element)v.get(873));

      /* Empieza nodo:874 / Elemento padre: 873   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(874)).setAttribute("align","center" );
      ((Element)v.get(874)).setAttribute("width","12" );
      ((Element)v.get(873)).appendChild((Element)v.get(874));

      /* Empieza nodo:875 / Elemento padre: 874   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(875)).setAttribute("src","b.gif" );
      ((Element)v.get(875)).setAttribute("width","12" );
      ((Element)v.get(875)).setAttribute("height","12" );
      ((Element)v.get(874)).appendChild((Element)v.get(875));
      /* Termina nodo:875   */
      /* Termina nodo:874   */

      /* Empieza nodo:876 / Elemento padre: 873   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(876)).setAttribute("width","100%" );
      ((Element)v.get(873)).appendChild((Element)v.get(876));

      /* Empieza nodo:877 / Elemento padre: 876   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(877)).setAttribute("width","100%" );
      ((Element)v.get(877)).setAttribute("border","0" );
      ((Element)v.get(877)).setAttribute("cellspacing","0" );
      ((Element)v.get(877)).setAttribute("cellpadding","0" );
      ((Element)v.get(877)).setAttribute("align","left" );
      ((Element)v.get(876)).appendChild((Element)v.get(877));

      /* Empieza nodo:878 / Elemento padre: 877   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(878)).setAttribute("align","left" );
      ((Element)v.get(877)).appendChild((Element)v.get(878));

      /* Empieza nodo:879 / Elemento padre: 878   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(879)).setAttribute("nombre","fecLanzTdId" );
      ((Element)v.get(878)).appendChild((Element)v.get(879));

      /* Empieza nodo:880 / Elemento padre: 879   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(880)).setAttribute("width","100%" );
      ((Element)v.get(880)).setAttribute("border","0" );
      ((Element)v.get(880)).setAttribute("cellspacing","0" );
      ((Element)v.get(880)).setAttribute("cellpadding","0" );
      ((Element)v.get(880)).setAttribute("align","left" );
      ((Element)v.get(879)).appendChild((Element)v.get(880));

      /* Empieza nodo:881 / Elemento padre: 880   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(880)).appendChild((Element)v.get(881));

      /* Empieza nodo:882 / Elemento padre: 881   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(882)).setAttribute("valign","top" );
      ((Element)v.get(882)).setAttribute("height","13" );
      ((Element)v.get(881)).appendChild((Element)v.get(882));

      /* Empieza nodo:883 / Elemento padre: 882   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(883)).setAttribute("nombre","lblFecLanz" );
      ((Element)v.get(883)).setAttribute("alto","13" );
      ((Element)v.get(883)).setAttribute("filas","1" );
      ((Element)v.get(883)).setAttribute("id","datosTitle" );
      ((Element)v.get(883)).setAttribute("cod","EduMatriCurso.fecLanz.label" );
      ((Element)v.get(882)).appendChild((Element)v.get(883));
      /* Termina nodo:883   */
      /* Termina nodo:882   */
      /* Termina nodo:881   */

      /* Empieza nodo:884 / Elemento padre: 880   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(884)).setAttribute("nombre","fecLanzWidgetTrId" );
      ((Element)v.get(880)).appendChild((Element)v.get(884));

      /* Empieza nodo:885 / Elemento padre: 884   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(885)).setAttribute("align","left" );
      ((Element)v.get(885)).setAttribute("nowrap","true" );
      ((Element)v.get(884)).appendChild((Element)v.get(885));

      /* Empieza nodo:886 / Elemento padre: 885   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(886)).setAttribute("nombre","fecLanz" );
      ((Element)v.get(886)).setAttribute("id","datosCampos" );
      ((Element)v.get(886)).setAttribute("trim","S" );
      ((Element)v.get(886)).setAttribute("max","7" );
      ((Element)v.get(886)).setAttribute("onchange","" );
      ((Element)v.get(886)).setAttribute("req","N" );
      ((Element)v.get(886)).setAttribute("size","7" );
      ((Element)v.get(886)).setAttribute("valor","" );
      ((Element)v.get(886)).setAttribute("validacion","" );
      ((Element)v.get(886)).setAttribute("onblur","" );
      ((Element)v.get(886)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true)" );
      ((Element)v.get(886)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm', 0, false)" );
      ((Element)v.get(885)).appendChild((Element)v.get(886));
      /* Termina nodo:886   */
      /* Termina nodo:885   */
      /* Termina nodo:884   */

      /* Empieza nodo:887 / Elemento padre: 880   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(887)).setAttribute("nombre","fecLanzViewLabelTrId" );
      ((Element)v.get(880)).appendChild((Element)v.get(887));

      /* Empieza nodo:888 / Elemento padre: 887   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(888)).setAttribute("valign","top" );
      ((Element)v.get(888)).setAttribute("height","13" );
      ((Element)v.get(887)).appendChild((Element)v.get(888));

      /* Empieza nodo:889 / Elemento padre: 888   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(889)).setAttribute("nombre","lblViewFecLanz" );
      ((Element)v.get(889)).setAttribute("alto","13" );
      ((Element)v.get(889)).setAttribute("ancho","100" );
      ((Element)v.get(889)).setAttribute("id","EstDat" );
      ((Element)v.get(889)).setAttribute("valor","" );
      ((Element)v.get(888)).appendChild((Element)v.get(889));
      /* Termina nodo:889   */
      /* Termina nodo:888   */
      /* Termina nodo:887   */
      /* Termina nodo:880   */
      /* Termina nodo:879   */

      /* Empieza nodo:890 / Elemento padre: 878   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(890)).setAttribute("nombre","fecLanzGapTdId" );
   }

   private void getXML4050(Document doc) {
      ((Element)v.get(890)).setAttribute("nowrap","true" );
      ((Element)v.get(890)).setAttribute("class","datosCampos" );
      ((Element)v.get(878)).appendChild((Element)v.get(890));

      /* Empieza nodo:891 / Elemento padre: 890   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(891)).setAttribute("src","b.gif" );
      ((Element)v.get(891)).setAttribute("width","25" );
      ((Element)v.get(891)).setAttribute("height","8" );
      ((Element)v.get(890)).appendChild((Element)v.get(891));
      /* Termina nodo:891   */
      /* Termina nodo:890   */

      /* Empieza nodo:892 / Elemento padre: 878   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(892)).setAttribute("width","100%" );
      ((Element)v.get(878)).appendChild((Element)v.get(892));

      /* Empieza nodo:893 / Elemento padre: 892   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(893)).setAttribute("src","b.gif" );
      ((Element)v.get(892)).appendChild((Element)v.get(893));
      /* Termina nodo:893   */
      /* Termina nodo:892   */
      /* Termina nodo:878   */
      /* Termina nodo:877   */
      /* Termina nodo:876   */
      /* Termina nodo:873   */

      /* Empieza nodo:894 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(894)).setAttribute("nombre","formGapTr25" );
      ((Element)v.get(40)).appendChild((Element)v.get(894));

      /* Empieza nodo:895 / Elemento padre: 894   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(895)).setAttribute("align","center" );
      ((Element)v.get(895)).setAttribute("width","12" );
      ((Element)v.get(894)).appendChild((Element)v.get(895));

      /* Empieza nodo:896 / Elemento padre: 895   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(896)).setAttribute("src","b.gif" );
      ((Element)v.get(896)).setAttribute("width","12" );
      ((Element)v.get(896)).setAttribute("height","8" );
      ((Element)v.get(895)).appendChild((Element)v.get(896));
      /* Termina nodo:896   */
      /* Termina nodo:895   */

      /* Empieza nodo:897 / Elemento padre: 894   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(894)).appendChild((Element)v.get(897));

      /* Empieza nodo:898 / Elemento padre: 897   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(898)).setAttribute("src","b.gif" );
      ((Element)v.get(898)).setAttribute("width","8" );
      ((Element)v.get(898)).setAttribute("height","8" );
      ((Element)v.get(897)).appendChild((Element)v.get(898));
      /* Termina nodo:898   */
      /* Termina nodo:897   */

      /* Empieza nodo:899 / Elemento padre: 894   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(899)).setAttribute("align","center" );
      ((Element)v.get(899)).setAttribute("width","12" );
      ((Element)v.get(894)).appendChild((Element)v.get(899));

      /* Empieza nodo:900 / Elemento padre: 899   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(900)).setAttribute("src","b.gif" );
      ((Element)v.get(900)).setAttribute("width","12" );
      ((Element)v.get(900)).setAttribute("height","8" );
      ((Element)v.get(899)).appendChild((Element)v.get(900));
      /* Termina nodo:900   */
      /* Termina nodo:899   */
      /* Termina nodo:894   */

      /* Empieza nodo:901 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(901)).setAttribute("nombre","formTr26" );
      ((Element)v.get(40)).appendChild((Element)v.get(901));

      /* Empieza nodo:902 / Elemento padre: 901   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(902)).setAttribute("align","center" );
      ((Element)v.get(902)).setAttribute("width","12" );
      ((Element)v.get(901)).appendChild((Element)v.get(902));

      /* Empieza nodo:903 / Elemento padre: 902   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(903)).setAttribute("src","b.gif" );
      ((Element)v.get(903)).setAttribute("width","12" );
      ((Element)v.get(903)).setAttribute("height","12" );
      ((Element)v.get(902)).appendChild((Element)v.get(903));
      /* Termina nodo:903   */
      /* Termina nodo:902   */

      /* Empieza nodo:904 / Elemento padre: 901   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(904)).setAttribute("width","100%" );
      ((Element)v.get(901)).appendChild((Element)v.get(904));

      /* Empieza nodo:905 / Elemento padre: 904   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(905)).setAttribute("width","100%" );
      ((Element)v.get(905)).setAttribute("border","0" );
      ((Element)v.get(905)).setAttribute("cellspacing","0" );
      ((Element)v.get(905)).setAttribute("cellpadding","0" );
      ((Element)v.get(905)).setAttribute("align","left" );
      ((Element)v.get(904)).appendChild((Element)v.get(905));

      /* Empieza nodo:906 / Elemento padre: 905   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(906)).setAttribute("align","left" );
      ((Element)v.get(905)).appendChild((Element)v.get(906));

      /* Empieza nodo:907 / Elemento padre: 906   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(907)).setAttribute("nombre","fecFinCursTdId" );
      ((Element)v.get(906)).appendChild((Element)v.get(907));

      /* Empieza nodo:908 / Elemento padre: 907   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(908)).setAttribute("width","100%" );
      ((Element)v.get(908)).setAttribute("border","0" );
      ((Element)v.get(908)).setAttribute("cellspacing","0" );
      ((Element)v.get(908)).setAttribute("cellpadding","0" );
      ((Element)v.get(908)).setAttribute("align","left" );
      ((Element)v.get(907)).appendChild((Element)v.get(908));

      /* Empieza nodo:909 / Elemento padre: 908   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(908)).appendChild((Element)v.get(909));

      /* Empieza nodo:910 / Elemento padre: 909   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(910)).setAttribute("valign","top" );
      ((Element)v.get(910)).setAttribute("height","13" );
      ((Element)v.get(909)).appendChild((Element)v.get(910));

      /* Empieza nodo:911 / Elemento padre: 910   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(911)).setAttribute("nombre","lblFecFinCurs" );
      ((Element)v.get(911)).setAttribute("alto","13" );
      ((Element)v.get(911)).setAttribute("filas","1" );
      ((Element)v.get(911)).setAttribute("id","datosTitle" );
      ((Element)v.get(911)).setAttribute("cod","EduMatriCurso.fecFinCurs.label" );
      ((Element)v.get(910)).appendChild((Element)v.get(911));
      /* Termina nodo:911   */
      /* Termina nodo:910   */
      /* Termina nodo:909   */

      /* Empieza nodo:912 / Elemento padre: 908   */
   }

   private void getXML4140(Document doc) {
      v.add(doc.createElement("TR"));
      ((Element)v.get(912)).setAttribute("nombre","fecFinCursWidgetTrId" );
      ((Element)v.get(908)).appendChild((Element)v.get(912));

      /* Empieza nodo:913 / Elemento padre: 912   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(913)).setAttribute("align","left" );
      ((Element)v.get(913)).setAttribute("nowrap","true" );
      ((Element)v.get(912)).appendChild((Element)v.get(913));

      /* Empieza nodo:914 / Elemento padre: 913   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(914)).setAttribute("nombre","fecFinCurs" );
      ((Element)v.get(914)).setAttribute("id","datosCampos" );
      ((Element)v.get(914)).setAttribute("trim","S" );
      ((Element)v.get(914)).setAttribute("max","7" );
      ((Element)v.get(914)).setAttribute("onchange","" );
      ((Element)v.get(914)).setAttribute("req","N" );
      ((Element)v.get(914)).setAttribute("size","7" );
      ((Element)v.get(914)).setAttribute("valor","" );
      ((Element)v.get(914)).setAttribute("validacion","" );
      ((Element)v.get(914)).setAttribute("onblur","" );
      ((Element)v.get(914)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true)" );
      ((Element)v.get(914)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm', 0, false)" );
      ((Element)v.get(913)).appendChild((Element)v.get(914));
      /* Termina nodo:914   */
      /* Termina nodo:913   */
      /* Termina nodo:912   */

      /* Empieza nodo:915 / Elemento padre: 908   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(915)).setAttribute("nombre","fecFinCursViewLabelTrId" );
      ((Element)v.get(908)).appendChild((Element)v.get(915));

      /* Empieza nodo:916 / Elemento padre: 915   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(916)).setAttribute("valign","top" );
      ((Element)v.get(916)).setAttribute("height","13" );
      ((Element)v.get(915)).appendChild((Element)v.get(916));

      /* Empieza nodo:917 / Elemento padre: 916   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(917)).setAttribute("nombre","lblViewFecFinCurs" );
      ((Element)v.get(917)).setAttribute("alto","13" );
      ((Element)v.get(917)).setAttribute("ancho","100" );
      ((Element)v.get(917)).setAttribute("id","EstDat" );
      ((Element)v.get(917)).setAttribute("valor","" );
      ((Element)v.get(916)).appendChild((Element)v.get(917));
      /* Termina nodo:917   */
      /* Termina nodo:916   */
      /* Termina nodo:915   */
      /* Termina nodo:908   */
      /* Termina nodo:907   */

      /* Empieza nodo:918 / Elemento padre: 906   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(918)).setAttribute("nombre","fecFinCursGapTdId" );
      ((Element)v.get(918)).setAttribute("nowrap","true" );
      ((Element)v.get(918)).setAttribute("class","datosCampos" );
      ((Element)v.get(906)).appendChild((Element)v.get(918));

      /* Empieza nodo:919 / Elemento padre: 918   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(919)).setAttribute("src","b.gif" );
      ((Element)v.get(919)).setAttribute("width","25" );
      ((Element)v.get(919)).setAttribute("height","8" );
      ((Element)v.get(918)).appendChild((Element)v.get(919));
      /* Termina nodo:919   */
      /* Termina nodo:918   */

      /* Empieza nodo:920 / Elemento padre: 906   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(920)).setAttribute("width","100%" );
      ((Element)v.get(906)).appendChild((Element)v.get(920));

      /* Empieza nodo:921 / Elemento padre: 920   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(921)).setAttribute("src","b.gif" );
      ((Element)v.get(920)).appendChild((Element)v.get(921));
      /* Termina nodo:921   */
      /* Termina nodo:920   */
      /* Termina nodo:906   */
      /* Termina nodo:905   */
      /* Termina nodo:904   */
      /* Termina nodo:901   */

      /* Empieza nodo:922 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(922)).setAttribute("nombre","formGapTr26" );
      ((Element)v.get(40)).appendChild((Element)v.get(922));

      /* Empieza nodo:923 / Elemento padre: 922   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(923)).setAttribute("align","center" );
      ((Element)v.get(923)).setAttribute("width","12" );
      ((Element)v.get(922)).appendChild((Element)v.get(923));

      /* Empieza nodo:924 / Elemento padre: 923   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(924)).setAttribute("src","b.gif" );
      ((Element)v.get(924)).setAttribute("width","12" );
      ((Element)v.get(924)).setAttribute("height","8" );
      ((Element)v.get(923)).appendChild((Element)v.get(924));
      /* Termina nodo:924   */
      /* Termina nodo:923   */

      /* Empieza nodo:925 / Elemento padre: 922   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(922)).appendChild((Element)v.get(925));

      /* Empieza nodo:926 / Elemento padre: 925   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(926)).setAttribute("src","b.gif" );
      ((Element)v.get(926)).setAttribute("width","8" );
      ((Element)v.get(926)).setAttribute("height","8" );
      ((Element)v.get(925)).appendChild((Element)v.get(926));
      /* Termina nodo:926   */
      /* Termina nodo:925   */

      /* Empieza nodo:927 / Elemento padre: 922   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(927)).setAttribute("align","center" );
      ((Element)v.get(927)).setAttribute("width","12" );
      ((Element)v.get(922)).appendChild((Element)v.get(927));

      /* Empieza nodo:928 / Elemento padre: 927   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(928)).setAttribute("src","b.gif" );
      ((Element)v.get(928)).setAttribute("width","12" );
      ((Element)v.get(928)).setAttribute("height","8" );
      ((Element)v.get(927)).appendChild((Element)v.get(928));
      /* Termina nodo:928   */
      /* Termina nodo:927   */
      /* Termina nodo:922   */

      /* Empieza nodo:929 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(929)).setAttribute("nombre","formTr27" );
      ((Element)v.get(40)).appendChild((Element)v.get(929));

      /* Empieza nodo:930 / Elemento padre: 929   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(930)).setAttribute("align","center" );
      ((Element)v.get(930)).setAttribute("width","12" );
      ((Element)v.get(929)).appendChild((Element)v.get(930));

      /* Empieza nodo:931 / Elemento padre: 930   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(931)).setAttribute("src","b.gif" );
      ((Element)v.get(931)).setAttribute("width","12" );
      ((Element)v.get(931)).setAttribute("height","12" );
   }

   private void getXML4230(Document doc) {
      ((Element)v.get(930)).appendChild((Element)v.get(931));
      /* Termina nodo:931   */
      /* Termina nodo:930   */

      /* Empieza nodo:932 / Elemento padre: 929   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(932)).setAttribute("width","100%" );
      ((Element)v.get(929)).appendChild((Element)v.get(932));

      /* Empieza nodo:933 / Elemento padre: 932   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(933)).setAttribute("width","100%" );
      ((Element)v.get(933)).setAttribute("border","0" );
      ((Element)v.get(933)).setAttribute("cellspacing","0" );
      ((Element)v.get(933)).setAttribute("cellpadding","0" );
      ((Element)v.get(933)).setAttribute("align","left" );
      ((Element)v.get(932)).appendChild((Element)v.get(933));

      /* Empieza nodo:934 / Elemento padre: 933   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(934)).setAttribute("align","left" );
      ((Element)v.get(933)).appendChild((Element)v.get(934));

      /* Empieza nodo:935 / Elemento padre: 934   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(935)).setAttribute("nombre","fecUltiCursTdId" );
      ((Element)v.get(934)).appendChild((Element)v.get(935));

      /* Empieza nodo:936 / Elemento padre: 935   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(936)).setAttribute("width","100%" );
      ((Element)v.get(936)).setAttribute("border","0" );
      ((Element)v.get(936)).setAttribute("cellspacing","0" );
      ((Element)v.get(936)).setAttribute("cellpadding","0" );
      ((Element)v.get(936)).setAttribute("align","left" );
      ((Element)v.get(935)).appendChild((Element)v.get(936));

      /* Empieza nodo:937 / Elemento padre: 936   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(936)).appendChild((Element)v.get(937));

      /* Empieza nodo:938 / Elemento padre: 937   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(938)).setAttribute("valign","top" );
      ((Element)v.get(938)).setAttribute("height","13" );
      ((Element)v.get(937)).appendChild((Element)v.get(938));

      /* Empieza nodo:939 / Elemento padre: 938   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(939)).setAttribute("nombre","lblFecUltiCurs" );
      ((Element)v.get(939)).setAttribute("alto","13" );
      ((Element)v.get(939)).setAttribute("filas","1" );
      ((Element)v.get(939)).setAttribute("id","datosTitle" );
      ((Element)v.get(939)).setAttribute("cod","EduMatriCurso.fecUltiCurs.label" );
      ((Element)v.get(938)).appendChild((Element)v.get(939));
      /* Termina nodo:939   */
      /* Termina nodo:938   */
      /* Termina nodo:937   */

      /* Empieza nodo:940 / Elemento padre: 936   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(940)).setAttribute("nombre","fecUltiCursWidgetTrId" );
      ((Element)v.get(936)).appendChild((Element)v.get(940));

      /* Empieza nodo:941 / Elemento padre: 940   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(941)).setAttribute("align","left" );
      ((Element)v.get(941)).setAttribute("nowrap","true" );
      ((Element)v.get(940)).appendChild((Element)v.get(941));

      /* Empieza nodo:942 / Elemento padre: 941   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(942)).setAttribute("nombre","fecUltiCurs" );
      ((Element)v.get(942)).setAttribute("id","datosCampos" );
      ((Element)v.get(942)).setAttribute("trim","S" );
      ((Element)v.get(942)).setAttribute("max","7" );
      ((Element)v.get(942)).setAttribute("onchange","" );
      ((Element)v.get(942)).setAttribute("req","N" );
      ((Element)v.get(942)).setAttribute("size","7" );
      ((Element)v.get(942)).setAttribute("valor","" );
      ((Element)v.get(942)).setAttribute("validacion","" );
      ((Element)v.get(942)).setAttribute("onblur","" );
      ((Element)v.get(942)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true)" );
      ((Element)v.get(942)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm', 0, false)" );
      ((Element)v.get(941)).appendChild((Element)v.get(942));
      /* Termina nodo:942   */
      /* Termina nodo:941   */
      /* Termina nodo:940   */

      /* Empieza nodo:943 / Elemento padre: 936   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(943)).setAttribute("nombre","fecUltiCursViewLabelTrId" );
      ((Element)v.get(936)).appendChild((Element)v.get(943));

      /* Empieza nodo:944 / Elemento padre: 943   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(944)).setAttribute("valign","top" );
      ((Element)v.get(944)).setAttribute("height","13" );
      ((Element)v.get(943)).appendChild((Element)v.get(944));

      /* Empieza nodo:945 / Elemento padre: 944   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(945)).setAttribute("nombre","lblViewFecUltiCurs" );
      ((Element)v.get(945)).setAttribute("alto","13" );
      ((Element)v.get(945)).setAttribute("ancho","100" );
      ((Element)v.get(945)).setAttribute("id","EstDat" );
      ((Element)v.get(945)).setAttribute("valor","" );
      ((Element)v.get(944)).appendChild((Element)v.get(945));
      /* Termina nodo:945   */
      /* Termina nodo:944   */
      /* Termina nodo:943   */
      /* Termina nodo:936   */
      /* Termina nodo:935   */

      /* Empieza nodo:946 / Elemento padre: 934   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(946)).setAttribute("nombre","fecUltiCursGapTdId" );
      ((Element)v.get(946)).setAttribute("nowrap","true" );
      ((Element)v.get(946)).setAttribute("class","datosCampos" );
      ((Element)v.get(934)).appendChild((Element)v.get(946));

      /* Empieza nodo:947 / Elemento padre: 946   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(947)).setAttribute("src","b.gif" );
      ((Element)v.get(947)).setAttribute("width","25" );
      ((Element)v.get(947)).setAttribute("height","8" );
      ((Element)v.get(946)).appendChild((Element)v.get(947));
      /* Termina nodo:947   */
      /* Termina nodo:946   */

      /* Empieza nodo:948 / Elemento padre: 934   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(948)).setAttribute("width","100%" );
      ((Element)v.get(934)).appendChild((Element)v.get(948));

      /* Empieza nodo:949 / Elemento padre: 948   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(949)).setAttribute("src","b.gif" );
      ((Element)v.get(948)).appendChild((Element)v.get(949));
      /* Termina nodo:949   */
      /* Termina nodo:948   */
      /* Termina nodo:934   */
      /* Termina nodo:933   */
      /* Termina nodo:932   */
      /* Termina nodo:929   */

      /* Empieza nodo:950 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(950)).setAttribute("nombre","formGapTr27" );
   }

   private void getXML4320(Document doc) {
      ((Element)v.get(40)).appendChild((Element)v.get(950));

      /* Empieza nodo:951 / Elemento padre: 950   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(951)).setAttribute("align","center" );
      ((Element)v.get(951)).setAttribute("width","12" );
      ((Element)v.get(950)).appendChild((Element)v.get(951));

      /* Empieza nodo:952 / Elemento padre: 951   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(952)).setAttribute("src","b.gif" );
      ((Element)v.get(952)).setAttribute("width","12" );
      ((Element)v.get(952)).setAttribute("height","8" );
      ((Element)v.get(951)).appendChild((Element)v.get(952));
      /* Termina nodo:952   */
      /* Termina nodo:951   */

      /* Empieza nodo:953 / Elemento padre: 950   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(950)).appendChild((Element)v.get(953));

      /* Empieza nodo:954 / Elemento padre: 953   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(954)).setAttribute("src","b.gif" );
      ((Element)v.get(954)).setAttribute("width","8" );
      ((Element)v.get(954)).setAttribute("height","8" );
      ((Element)v.get(953)).appendChild((Element)v.get(954));
      /* Termina nodo:954   */
      /* Termina nodo:953   */

      /* Empieza nodo:955 / Elemento padre: 950   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(955)).setAttribute("align","center" );
      ((Element)v.get(955)).setAttribute("width","12" );
      ((Element)v.get(950)).appendChild((Element)v.get(955));

      /* Empieza nodo:956 / Elemento padre: 955   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(956)).setAttribute("src","b.gif" );
      ((Element)v.get(956)).setAttribute("width","12" );
      ((Element)v.get(956)).setAttribute("height","8" );
      ((Element)v.get(955)).appendChild((Element)v.get(956));
      /* Termina nodo:956   */
      /* Termina nodo:955   */
      /* Termina nodo:950   */

      /* Empieza nodo:957 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(957)).setAttribute("nombre","formTr28" );
      ((Element)v.get(40)).appendChild((Element)v.get(957));

      /* Empieza nodo:958 / Elemento padre: 957   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(958)).setAttribute("align","center" );
      ((Element)v.get(958)).setAttribute("width","12" );
      ((Element)v.get(957)).appendChild((Element)v.get(958));

      /* Empieza nodo:959 / Elemento padre: 958   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(959)).setAttribute("src","b.gif" );
      ((Element)v.get(959)).setAttribute("width","12" );
      ((Element)v.get(959)).setAttribute("height","12" );
      ((Element)v.get(958)).appendChild((Element)v.get(959));
      /* Termina nodo:959   */
      /* Termina nodo:958   */

      /* Empieza nodo:960 / Elemento padre: 957   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(960)).setAttribute("width","100%" );
      ((Element)v.get(957)).appendChild((Element)v.get(960));

      /* Empieza nodo:961 / Elemento padre: 960   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(961)).setAttribute("width","100%" );
      ((Element)v.get(961)).setAttribute("border","0" );
      ((Element)v.get(961)).setAttribute("cellspacing","0" );
      ((Element)v.get(961)).setAttribute("cellpadding","0" );
      ((Element)v.get(961)).setAttribute("align","left" );
      ((Element)v.get(960)).appendChild((Element)v.get(961));

      /* Empieza nodo:962 / Elemento padre: 961   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(962)).setAttribute("align","left" );
      ((Element)v.get(961)).appendChild((Element)v.get(962));

      /* Empieza nodo:963 / Elemento padre: 962   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(963)).setAttribute("nombre","fecConcCursTdId" );
      ((Element)v.get(962)).appendChild((Element)v.get(963));

      /* Empieza nodo:964 / Elemento padre: 963   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(964)).setAttribute("width","100%" );
      ((Element)v.get(964)).setAttribute("border","0" );
      ((Element)v.get(964)).setAttribute("cellspacing","0" );
      ((Element)v.get(964)).setAttribute("cellpadding","0" );
      ((Element)v.get(964)).setAttribute("align","left" );
      ((Element)v.get(963)).appendChild((Element)v.get(964));

      /* Empieza nodo:965 / Elemento padre: 964   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(964)).appendChild((Element)v.get(965));

      /* Empieza nodo:966 / Elemento padre: 965   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(966)).setAttribute("valign","top" );
      ((Element)v.get(966)).setAttribute("height","13" );
      ((Element)v.get(965)).appendChild((Element)v.get(966));

      /* Empieza nodo:967 / Elemento padre: 966   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(967)).setAttribute("nombre","lblFecConcCurs" );
      ((Element)v.get(967)).setAttribute("alto","13" );
      ((Element)v.get(967)).setAttribute("filas","1" );
      ((Element)v.get(967)).setAttribute("id","datosTitle" );
      ((Element)v.get(967)).setAttribute("cod","EduMatriCurso.fecConcCurs.label" );
      ((Element)v.get(966)).appendChild((Element)v.get(967));
      /* Termina nodo:967   */
      /* Termina nodo:966   */
      /* Termina nodo:965   */

      /* Empieza nodo:968 / Elemento padre: 964   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(968)).setAttribute("nombre","fecConcCursWidgetTrId" );
      ((Element)v.get(964)).appendChild((Element)v.get(968));

      /* Empieza nodo:969 / Elemento padre: 968   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(969)).setAttribute("align","left" );
      ((Element)v.get(969)).setAttribute("nowrap","true" );
      ((Element)v.get(968)).appendChild((Element)v.get(969));

      /* Empieza nodo:970 / Elemento padre: 969   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(970)).setAttribute("nombre","fecConcCurs" );
      ((Element)v.get(970)).setAttribute("id","datosCampos" );
      ((Element)v.get(970)).setAttribute("trim","S" );
      ((Element)v.get(970)).setAttribute("max","7" );
      ((Element)v.get(970)).setAttribute("onchange","" );
      ((Element)v.get(970)).setAttribute("req","N" );
      ((Element)v.get(970)).setAttribute("size","7" );
      ((Element)v.get(970)).setAttribute("valor","" );
   }

   private void getXML4410(Document doc) {
      ((Element)v.get(970)).setAttribute("validacion","" );
      ((Element)v.get(970)).setAttribute("onblur","" );
      ((Element)v.get(970)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true)" );
      ((Element)v.get(970)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm', 0, false)" );
      ((Element)v.get(969)).appendChild((Element)v.get(970));
      /* Termina nodo:970   */
      /* Termina nodo:969   */
      /* Termina nodo:968   */

      /* Empieza nodo:971 / Elemento padre: 964   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(971)).setAttribute("nombre","fecConcCursViewLabelTrId" );
      ((Element)v.get(964)).appendChild((Element)v.get(971));

      /* Empieza nodo:972 / Elemento padre: 971   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(972)).setAttribute("valign","top" );
      ((Element)v.get(972)).setAttribute("height","13" );
      ((Element)v.get(971)).appendChild((Element)v.get(972));

      /* Empieza nodo:973 / Elemento padre: 972   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(973)).setAttribute("nombre","lblViewFecConcCurs" );
      ((Element)v.get(973)).setAttribute("alto","13" );
      ((Element)v.get(973)).setAttribute("ancho","100" );
      ((Element)v.get(973)).setAttribute("id","EstDat" );
      ((Element)v.get(973)).setAttribute("valor","" );
      ((Element)v.get(972)).appendChild((Element)v.get(973));
      /* Termina nodo:973   */
      /* Termina nodo:972   */
      /* Termina nodo:971   */
      /* Termina nodo:964   */
      /* Termina nodo:963   */

      /* Empieza nodo:974 / Elemento padre: 962   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(974)).setAttribute("nombre","fecConcCursGapTdId" );
      ((Element)v.get(974)).setAttribute("nowrap","true" );
      ((Element)v.get(974)).setAttribute("class","datosCampos" );
      ((Element)v.get(962)).appendChild((Element)v.get(974));

      /* Empieza nodo:975 / Elemento padre: 974   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(975)).setAttribute("src","b.gif" );
      ((Element)v.get(975)).setAttribute("width","25" );
      ((Element)v.get(975)).setAttribute("height","8" );
      ((Element)v.get(974)).appendChild((Element)v.get(975));
      /* Termina nodo:975   */
      /* Termina nodo:974   */

      /* Empieza nodo:976 / Elemento padre: 962   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(976)).setAttribute("width","100%" );
      ((Element)v.get(962)).appendChild((Element)v.get(976));

      /* Empieza nodo:977 / Elemento padre: 976   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(977)).setAttribute("src","b.gif" );
      ((Element)v.get(976)).appendChild((Element)v.get(977));
      /* Termina nodo:977   */
      /* Termina nodo:976   */
      /* Termina nodo:962   */
      /* Termina nodo:961   */
      /* Termina nodo:960   */
      /* Termina nodo:957   */

      /* Empieza nodo:978 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(978)).setAttribute("nombre","formGapTr28" );
      ((Element)v.get(40)).appendChild((Element)v.get(978));

      /* Empieza nodo:979 / Elemento padre: 978   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(979)).setAttribute("align","center" );
      ((Element)v.get(979)).setAttribute("width","12" );
      ((Element)v.get(978)).appendChild((Element)v.get(979));

      /* Empieza nodo:980 / Elemento padre: 979   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(980)).setAttribute("src","b.gif" );
      ((Element)v.get(980)).setAttribute("width","12" );
      ((Element)v.get(980)).setAttribute("height","8" );
      ((Element)v.get(979)).appendChild((Element)v.get(980));
      /* Termina nodo:980   */
      /* Termina nodo:979   */

      /* Empieza nodo:981 / Elemento padre: 978   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(978)).appendChild((Element)v.get(981));

      /* Empieza nodo:982 / Elemento padre: 981   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(982)).setAttribute("src","b.gif" );
      ((Element)v.get(982)).setAttribute("width","8" );
      ((Element)v.get(982)).setAttribute("height","8" );
      ((Element)v.get(981)).appendChild((Element)v.get(982));
      /* Termina nodo:982   */
      /* Termina nodo:981   */

      /* Empieza nodo:983 / Elemento padre: 978   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(983)).setAttribute("align","center" );
      ((Element)v.get(983)).setAttribute("width","12" );
      ((Element)v.get(978)).appendChild((Element)v.get(983));

      /* Empieza nodo:984 / Elemento padre: 983   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(984)).setAttribute("src","b.gif" );
      ((Element)v.get(984)).setAttribute("width","12" );
      ((Element)v.get(984)).setAttribute("height","8" );
      ((Element)v.get(983)).appendChild((Element)v.get(984));
      /* Termina nodo:984   */
      /* Termina nodo:983   */
      /* Termina nodo:978   */

      /* Empieza nodo:985 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(985)).setAttribute("nombre","formTr29" );
      ((Element)v.get(40)).appendChild((Element)v.get(985));

      /* Empieza nodo:986 / Elemento padre: 985   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(986)).setAttribute("align","center" );
      ((Element)v.get(986)).setAttribute("width","12" );
      ((Element)v.get(985)).appendChild((Element)v.get(986));

      /* Empieza nodo:987 / Elemento padre: 986   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(987)).setAttribute("src","b.gif" );
      ((Element)v.get(987)).setAttribute("width","12" );
      ((Element)v.get(987)).setAttribute("height","12" );
      ((Element)v.get(986)).appendChild((Element)v.get(987));
      /* Termina nodo:987   */
      /* Termina nodo:986   */

      /* Empieza nodo:988 / Elemento padre: 985   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(988)).setAttribute("width","100%" );
      ((Element)v.get(985)).appendChild((Element)v.get(988));

      /* Empieza nodo:989 / Elemento padre: 988   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(989)).setAttribute("width","100%" );
      ((Element)v.get(989)).setAttribute("border","0" );
      ((Element)v.get(989)).setAttribute("cellspacing","0" );
      ((Element)v.get(989)).setAttribute("cellpadding","0" );
      ((Element)v.get(989)).setAttribute("align","left" );
      ((Element)v.get(988)).appendChild((Element)v.get(989));

      /* Empieza nodo:990 / Elemento padre: 989   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(990)).setAttribute("align","left" );
      ((Element)v.get(989)).appendChild((Element)v.get(990));

      /* Empieza nodo:991 / Elemento padre: 990   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(991)).setAttribute("nombre","fecIngrTdId" );
   }

   private void getXML4500(Document doc) {
      ((Element)v.get(990)).appendChild((Element)v.get(991));

      /* Empieza nodo:992 / Elemento padre: 991   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(992)).setAttribute("width","100%" );
      ((Element)v.get(992)).setAttribute("border","0" );
      ((Element)v.get(992)).setAttribute("cellspacing","0" );
      ((Element)v.get(992)).setAttribute("cellpadding","0" );
      ((Element)v.get(992)).setAttribute("align","left" );
      ((Element)v.get(991)).appendChild((Element)v.get(992));

      /* Empieza nodo:993 / Elemento padre: 992   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(992)).appendChild((Element)v.get(993));

      /* Empieza nodo:994 / Elemento padre: 993   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(994)).setAttribute("valign","top" );
      ((Element)v.get(994)).setAttribute("height","13" );
      ((Element)v.get(993)).appendChild((Element)v.get(994));

      /* Empieza nodo:995 / Elemento padre: 994   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(995)).setAttribute("nombre","lblFecIngr" );
      ((Element)v.get(995)).setAttribute("alto","13" );
      ((Element)v.get(995)).setAttribute("filas","1" );
      ((Element)v.get(995)).setAttribute("id","datosTitle" );
      ((Element)v.get(995)).setAttribute("cod","EduMatriCurso.fecIngr.label" );
      ((Element)v.get(994)).appendChild((Element)v.get(995));
      /* Termina nodo:995   */
      /* Termina nodo:994   */
      /* Termina nodo:993   */

      /* Empieza nodo:996 / Elemento padre: 992   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(996)).setAttribute("nombre","fecIngrWidgetTrId" );
      ((Element)v.get(992)).appendChild((Element)v.get(996));

      /* Empieza nodo:997 / Elemento padre: 996   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(997)).setAttribute("align","left" );
      ((Element)v.get(997)).setAttribute("nowrap","true" );
      ((Element)v.get(996)).appendChild((Element)v.get(997));

      /* Empieza nodo:998 / Elemento padre: 997   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(998)).setAttribute("nombre","fecIngr" );
      ((Element)v.get(998)).setAttribute("id","datosCampos" );
      ((Element)v.get(998)).setAttribute("trim","S" );
      ((Element)v.get(998)).setAttribute("max","7" );
      ((Element)v.get(998)).setAttribute("onchange","" );
      ((Element)v.get(998)).setAttribute("req","N" );
      ((Element)v.get(998)).setAttribute("size","7" );
      ((Element)v.get(998)).setAttribute("valor","" );
      ((Element)v.get(998)).setAttribute("validacion","" );
      ((Element)v.get(998)).setAttribute("onblur","" );
      ((Element)v.get(998)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true)" );
      ((Element)v.get(998)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm', 0, false)" );
      ((Element)v.get(997)).appendChild((Element)v.get(998));
      /* Termina nodo:998   */
      /* Termina nodo:997   */
      /* Termina nodo:996   */

      /* Empieza nodo:999 / Elemento padre: 992   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(999)).setAttribute("nombre","fecIngrViewLabelTrId" );
      ((Element)v.get(992)).appendChild((Element)v.get(999));

      /* Empieza nodo:1000 / Elemento padre: 999   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1000)).setAttribute("valign","top" );
      ((Element)v.get(1000)).setAttribute("height","13" );
      ((Element)v.get(999)).appendChild((Element)v.get(1000));

      /* Empieza nodo:1001 / Elemento padre: 1000   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1001)).setAttribute("nombre","lblViewFecIngr" );
      ((Element)v.get(1001)).setAttribute("alto","13" );
      ((Element)v.get(1001)).setAttribute("ancho","100" );
      ((Element)v.get(1001)).setAttribute("id","EstDat" );
      ((Element)v.get(1001)).setAttribute("valor","" );
      ((Element)v.get(1000)).appendChild((Element)v.get(1001));
      /* Termina nodo:1001   */
      /* Termina nodo:1000   */
      /* Termina nodo:999   */
      /* Termina nodo:992   */
      /* Termina nodo:991   */

      /* Empieza nodo:1002 / Elemento padre: 990   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1002)).setAttribute("nombre","fecIngrGapTdId" );
      ((Element)v.get(1002)).setAttribute("nowrap","true" );
      ((Element)v.get(1002)).setAttribute("class","datosCampos" );
      ((Element)v.get(990)).appendChild((Element)v.get(1002));

      /* Empieza nodo:1003 / Elemento padre: 1002   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1003)).setAttribute("src","b.gif" );
      ((Element)v.get(1003)).setAttribute("width","25" );
      ((Element)v.get(1003)).setAttribute("height","8" );
      ((Element)v.get(1002)).appendChild((Element)v.get(1003));
      /* Termina nodo:1003   */
      /* Termina nodo:1002   */

      /* Empieza nodo:1004 / Elemento padre: 990   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1004)).setAttribute("width","100%" );
      ((Element)v.get(990)).appendChild((Element)v.get(1004));

      /* Empieza nodo:1005 / Elemento padre: 1004   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1005)).setAttribute("src","b.gif" );
      ((Element)v.get(1004)).appendChild((Element)v.get(1005));
      /* Termina nodo:1005   */
      /* Termina nodo:1004   */
      /* Termina nodo:990   */
      /* Termina nodo:989   */
      /* Termina nodo:988   */
      /* Termina nodo:985   */

      /* Empieza nodo:1006 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1006)).setAttribute("nombre","formGapTr29" );
      ((Element)v.get(40)).appendChild((Element)v.get(1006));

      /* Empieza nodo:1007 / Elemento padre: 1006   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1007)).setAttribute("align","center" );
      ((Element)v.get(1007)).setAttribute("width","12" );
      ((Element)v.get(1006)).appendChild((Element)v.get(1007));

      /* Empieza nodo:1008 / Elemento padre: 1007   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1008)).setAttribute("src","b.gif" );
      ((Element)v.get(1008)).setAttribute("width","12" );
      ((Element)v.get(1008)).setAttribute("height","8" );
      ((Element)v.get(1007)).appendChild((Element)v.get(1008));
      /* Termina nodo:1008   */
      /* Termina nodo:1007   */

      /* Empieza nodo:1009 / Elemento padre: 1006   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1006)).appendChild((Element)v.get(1009));

      /* Empieza nodo:1010 / Elemento padre: 1009   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1010)).setAttribute("src","b.gif" );
      ((Element)v.get(1010)).setAttribute("width","8" );
      ((Element)v.get(1010)).setAttribute("height","8" );
   }

   private void getXML4590(Document doc) {
      ((Element)v.get(1009)).appendChild((Element)v.get(1010));
      /* Termina nodo:1010   */
      /* Termina nodo:1009   */

      /* Empieza nodo:1011 / Elemento padre: 1006   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1011)).setAttribute("align","center" );
      ((Element)v.get(1011)).setAttribute("width","12" );
      ((Element)v.get(1006)).appendChild((Element)v.get(1011));

      /* Empieza nodo:1012 / Elemento padre: 1011   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1012)).setAttribute("src","b.gif" );
      ((Element)v.get(1012)).setAttribute("width","12" );
      ((Element)v.get(1012)).setAttribute("height","8" );
      ((Element)v.get(1011)).appendChild((Element)v.get(1012));
      /* Termina nodo:1012   */
      /* Termina nodo:1011   */
      /* Termina nodo:1006   */

      /* Empieza nodo:1013 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1013)).setAttribute("nombre","formTr30" );
      ((Element)v.get(40)).appendChild((Element)v.get(1013));

      /* Empieza nodo:1014 / Elemento padre: 1013   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1014)).setAttribute("align","center" );
      ((Element)v.get(1014)).setAttribute("width","12" );
      ((Element)v.get(1013)).appendChild((Element)v.get(1014));

      /* Empieza nodo:1015 / Elemento padre: 1014   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1015)).setAttribute("src","b.gif" );
      ((Element)v.get(1015)).setAttribute("width","12" );
      ((Element)v.get(1015)).setAttribute("height","12" );
      ((Element)v.get(1014)).appendChild((Element)v.get(1015));
      /* Termina nodo:1015   */
      /* Termina nodo:1014   */

      /* Empieza nodo:1016 / Elemento padre: 1013   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1016)).setAttribute("width","100%" );
      ((Element)v.get(1013)).appendChild((Element)v.get(1016));

      /* Empieza nodo:1017 / Elemento padre: 1016   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1017)).setAttribute("width","100%" );
      ((Element)v.get(1017)).setAttribute("border","0" );
      ((Element)v.get(1017)).setAttribute("cellspacing","0" );
      ((Element)v.get(1017)).setAttribute("cellpadding","0" );
      ((Element)v.get(1017)).setAttribute("align","left" );
      ((Element)v.get(1016)).appendChild((Element)v.get(1017));

      /* Empieza nodo:1018 / Elemento padre: 1017   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1018)).setAttribute("align","left" );
      ((Element)v.get(1017)).appendChild((Element)v.get(1018));

      /* Empieza nodo:1019 / Elemento padre: 1018   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1019)).setAttribute("nombre","numPartTdId" );
      ((Element)v.get(1018)).appendChild((Element)v.get(1019));

      /* Empieza nodo:1020 / Elemento padre: 1019   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1020)).setAttribute("width","100%" );
      ((Element)v.get(1020)).setAttribute("border","0" );
      ((Element)v.get(1020)).setAttribute("cellspacing","0" );
      ((Element)v.get(1020)).setAttribute("cellpadding","0" );
      ((Element)v.get(1020)).setAttribute("align","left" );
      ((Element)v.get(1019)).appendChild((Element)v.get(1020));

      /* Empieza nodo:1021 / Elemento padre: 1020   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1020)).appendChild((Element)v.get(1021));

      /* Empieza nodo:1022 / Elemento padre: 1021   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1022)).setAttribute("valign","top" );
      ((Element)v.get(1022)).setAttribute("height","13" );
      ((Element)v.get(1021)).appendChild((Element)v.get(1022));

      /* Empieza nodo:1023 / Elemento padre: 1022   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1023)).setAttribute("nombre","lblNumPart" );
      ((Element)v.get(1023)).setAttribute("alto","13" );
      ((Element)v.get(1023)).setAttribute("filas","1" );
      ((Element)v.get(1023)).setAttribute("id","datosTitle" );
      ((Element)v.get(1023)).setAttribute("cod","EduMatriCurso.numPart.label" );
      ((Element)v.get(1022)).appendChild((Element)v.get(1023));
      /* Termina nodo:1023   */
      /* Termina nodo:1022   */
      /* Termina nodo:1021   */

      /* Empieza nodo:1024 / Elemento padre: 1020   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1024)).setAttribute("nombre","numPartWidgetTrId" );
      ((Element)v.get(1020)).appendChild((Element)v.get(1024));

      /* Empieza nodo:1025 / Elemento padre: 1024   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1025)).setAttribute("align","left" );
      ((Element)v.get(1025)).setAttribute("nowrap","true" );
      ((Element)v.get(1024)).appendChild((Element)v.get(1025));

      /* Empieza nodo:1026 / Elemento padre: 1025   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(1026)).setAttribute("nombre","numPart" );
      ((Element)v.get(1026)).setAttribute("id","datosCampos" );
      ((Element)v.get(1026)).setAttribute("trim","S" );
      ((Element)v.get(1026)).setAttribute("max","2" );
      ((Element)v.get(1026)).setAttribute("onchange","" );
      ((Element)v.get(1026)).setAttribute("req","N" );
      ((Element)v.get(1026)).setAttribute("size","2" );
      ((Element)v.get(1026)).setAttribute("valor","" );
      ((Element)v.get(1026)).setAttribute("validacion","" );
      ((Element)v.get(1026)).setAttribute("onblur","" );
      ((Element)v.get(1026)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true)" );
      ((Element)v.get(1026)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm', 0, false)" );
      ((Element)v.get(1025)).appendChild((Element)v.get(1026));
      /* Termina nodo:1026   */
      /* Termina nodo:1025   */
      /* Termina nodo:1024   */

      /* Empieza nodo:1027 / Elemento padre: 1020   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1027)).setAttribute("nombre","numPartViewLabelTrId" );
      ((Element)v.get(1020)).appendChild((Element)v.get(1027));

      /* Empieza nodo:1028 / Elemento padre: 1027   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1028)).setAttribute("valign","top" );
      ((Element)v.get(1028)).setAttribute("height","13" );
      ((Element)v.get(1027)).appendChild((Element)v.get(1028));

      /* Empieza nodo:1029 / Elemento padre: 1028   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1029)).setAttribute("nombre","lblViewNumPart" );
      ((Element)v.get(1029)).setAttribute("alto","13" );
      ((Element)v.get(1029)).setAttribute("ancho","100" );
   }

   private void getXML4680(Document doc) {
      ((Element)v.get(1029)).setAttribute("id","EstDat" );
      ((Element)v.get(1029)).setAttribute("valor","" );
      ((Element)v.get(1028)).appendChild((Element)v.get(1029));
      /* Termina nodo:1029   */
      /* Termina nodo:1028   */
      /* Termina nodo:1027   */
      /* Termina nodo:1020   */
      /* Termina nodo:1019   */

      /* Empieza nodo:1030 / Elemento padre: 1018   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1030)).setAttribute("nombre","numPartGapTdId" );
      ((Element)v.get(1030)).setAttribute("nowrap","true" );
      ((Element)v.get(1030)).setAttribute("class","datosCampos" );
      ((Element)v.get(1018)).appendChild((Element)v.get(1030));

      /* Empieza nodo:1031 / Elemento padre: 1030   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1031)).setAttribute("src","b.gif" );
      ((Element)v.get(1031)).setAttribute("width","25" );
      ((Element)v.get(1031)).setAttribute("height","8" );
      ((Element)v.get(1030)).appendChild((Element)v.get(1031));
      /* Termina nodo:1031   */
      /* Termina nodo:1030   */

      /* Empieza nodo:1032 / Elemento padre: 1018   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1032)).setAttribute("width","100%" );
      ((Element)v.get(1018)).appendChild((Element)v.get(1032));

      /* Empieza nodo:1033 / Elemento padre: 1032   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1033)).setAttribute("src","b.gif" );
      ((Element)v.get(1032)).appendChild((Element)v.get(1033));
      /* Termina nodo:1033   */
      /* Termina nodo:1032   */
      /* Termina nodo:1018   */
      /* Termina nodo:1017   */
      /* Termina nodo:1016   */
      /* Termina nodo:1013   */

      /* Empieza nodo:1034 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1034)).setAttribute("nombre","formGapTr30" );
      ((Element)v.get(40)).appendChild((Element)v.get(1034));

      /* Empieza nodo:1035 / Elemento padre: 1034   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1035)).setAttribute("align","center" );
      ((Element)v.get(1035)).setAttribute("width","12" );
      ((Element)v.get(1034)).appendChild((Element)v.get(1035));

      /* Empieza nodo:1036 / Elemento padre: 1035   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1036)).setAttribute("src","b.gif" );
      ((Element)v.get(1036)).setAttribute("width","12" );
      ((Element)v.get(1036)).setAttribute("height","8" );
      ((Element)v.get(1035)).appendChild((Element)v.get(1036));
      /* Termina nodo:1036   */
      /* Termina nodo:1035   */

      /* Empieza nodo:1037 / Elemento padre: 1034   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1034)).appendChild((Element)v.get(1037));

      /* Empieza nodo:1038 / Elemento padre: 1037   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1038)).setAttribute("src","b.gif" );
      ((Element)v.get(1038)).setAttribute("width","8" );
      ((Element)v.get(1038)).setAttribute("height","8" );
      ((Element)v.get(1037)).appendChild((Element)v.get(1038));
      /* Termina nodo:1038   */
      /* Termina nodo:1037   */

      /* Empieza nodo:1039 / Elemento padre: 1034   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1039)).setAttribute("align","center" );
      ((Element)v.get(1039)).setAttribute("width","12" );
      ((Element)v.get(1034)).appendChild((Element)v.get(1039));

      /* Empieza nodo:1040 / Elemento padre: 1039   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1040)).setAttribute("src","b.gif" );
      ((Element)v.get(1040)).setAttribute("width","12" );
      ((Element)v.get(1040)).setAttribute("height","8" );
      ((Element)v.get(1039)).appendChild((Element)v.get(1040));
      /* Termina nodo:1040   */
      /* Termina nodo:1039   */
      /* Termina nodo:1034   */

      /* Empieza nodo:1041 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1041)).setAttribute("nombre","formTr31" );
      ((Element)v.get(40)).appendChild((Element)v.get(1041));

      /* Empieza nodo:1042 / Elemento padre: 1041   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1042)).setAttribute("align","center" );
      ((Element)v.get(1042)).setAttribute("width","12" );
      ((Element)v.get(1041)).appendChild((Element)v.get(1042));

      /* Empieza nodo:1043 / Elemento padre: 1042   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1043)).setAttribute("src","b.gif" );
      ((Element)v.get(1043)).setAttribute("width","12" );
      ((Element)v.get(1043)).setAttribute("height","12" );
      ((Element)v.get(1042)).appendChild((Element)v.get(1043));
      /* Termina nodo:1043   */
      /* Termina nodo:1042   */

      /* Empieza nodo:1044 / Elemento padre: 1041   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1044)).setAttribute("width","100%" );
      ((Element)v.get(1041)).appendChild((Element)v.get(1044));

      /* Empieza nodo:1045 / Elemento padre: 1044   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1045)).setAttribute("width","100%" );
      ((Element)v.get(1045)).setAttribute("border","0" );
      ((Element)v.get(1045)).setAttribute("cellspacing","0" );
      ((Element)v.get(1045)).setAttribute("cellpadding","0" );
      ((Element)v.get(1045)).setAttribute("align","left" );
      ((Element)v.get(1044)).appendChild((Element)v.get(1045));

      /* Empieza nodo:1046 / Elemento padre: 1045   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1046)).setAttribute("align","left" );
      ((Element)v.get(1045)).appendChild((Element)v.get(1046));

      /* Empieza nodo:1047 / Elemento padre: 1046   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1047)).setAttribute("nombre","numOrdeTdId" );
      ((Element)v.get(1046)).appendChild((Element)v.get(1047));

      /* Empieza nodo:1048 / Elemento padre: 1047   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1048)).setAttribute("width","100%" );
      ((Element)v.get(1048)).setAttribute("border","0" );
      ((Element)v.get(1048)).setAttribute("cellspacing","0" );
      ((Element)v.get(1048)).setAttribute("cellpadding","0" );
      ((Element)v.get(1048)).setAttribute("align","left" );
      ((Element)v.get(1047)).appendChild((Element)v.get(1048));

      /* Empieza nodo:1049 / Elemento padre: 1048   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1048)).appendChild((Element)v.get(1049));

      /* Empieza nodo:1050 / Elemento padre: 1049   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1050)).setAttribute("valign","top" );
      ((Element)v.get(1050)).setAttribute("height","13" );
      ((Element)v.get(1049)).appendChild((Element)v.get(1050));

      /* Empieza nodo:1051 / Elemento padre: 1050   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1051)).setAttribute("nombre","lblNumOrde" );
   }

   private void getXML4770(Document doc) {
      ((Element)v.get(1051)).setAttribute("alto","13" );
      ((Element)v.get(1051)).setAttribute("filas","1" );
      ((Element)v.get(1051)).setAttribute("id","datosTitle" );
      ((Element)v.get(1051)).setAttribute("cod","EduMatriCurso.numOrde.label" );
      ((Element)v.get(1050)).appendChild((Element)v.get(1051));
      /* Termina nodo:1051   */
      /* Termina nodo:1050   */
      /* Termina nodo:1049   */

      /* Empieza nodo:1052 / Elemento padre: 1048   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1052)).setAttribute("nombre","numOrdeWidgetTrId" );
      ((Element)v.get(1048)).appendChild((Element)v.get(1052));

      /* Empieza nodo:1053 / Elemento padre: 1052   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1053)).setAttribute("align","left" );
      ((Element)v.get(1053)).setAttribute("nowrap","true" );
      ((Element)v.get(1052)).appendChild((Element)v.get(1053));

      /* Empieza nodo:1054 / Elemento padre: 1053   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(1054)).setAttribute("nombre","numOrde" );
      ((Element)v.get(1054)).setAttribute("id","datosCampos" );
      ((Element)v.get(1054)).setAttribute("trim","S" );
      ((Element)v.get(1054)).setAttribute("max","2" );
      ((Element)v.get(1054)).setAttribute("onchange","" );
      ((Element)v.get(1054)).setAttribute("req","N" );
      ((Element)v.get(1054)).setAttribute("size","2" );
      ((Element)v.get(1054)).setAttribute("valor","" );
      ((Element)v.get(1054)).setAttribute("validacion","" );
      ((Element)v.get(1054)).setAttribute("onblur","" );
      ((Element)v.get(1054)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true)" );
      ((Element)v.get(1054)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm', 0, false)" );
      ((Element)v.get(1053)).appendChild((Element)v.get(1054));
      /* Termina nodo:1054   */
      /* Termina nodo:1053   */
      /* Termina nodo:1052   */

      /* Empieza nodo:1055 / Elemento padre: 1048   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1055)).setAttribute("nombre","numOrdeViewLabelTrId" );
      ((Element)v.get(1048)).appendChild((Element)v.get(1055));

      /* Empieza nodo:1056 / Elemento padre: 1055   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1056)).setAttribute("valign","top" );
      ((Element)v.get(1056)).setAttribute("height","13" );
      ((Element)v.get(1055)).appendChild((Element)v.get(1056));

      /* Empieza nodo:1057 / Elemento padre: 1056   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1057)).setAttribute("nombre","lblViewNumOrde" );
      ((Element)v.get(1057)).setAttribute("alto","13" );
      ((Element)v.get(1057)).setAttribute("ancho","100" );
      ((Element)v.get(1057)).setAttribute("id","EstDat" );
      ((Element)v.get(1057)).setAttribute("valor","" );
      ((Element)v.get(1056)).appendChild((Element)v.get(1057));
      /* Termina nodo:1057   */
      /* Termina nodo:1056   */
      /* Termina nodo:1055   */
      /* Termina nodo:1048   */
      /* Termina nodo:1047   */

      /* Empieza nodo:1058 / Elemento padre: 1046   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1058)).setAttribute("nombre","numOrdeGapTdId" );
      ((Element)v.get(1058)).setAttribute("nowrap","true" );
      ((Element)v.get(1058)).setAttribute("class","datosCampos" );
      ((Element)v.get(1046)).appendChild((Element)v.get(1058));

      /* Empieza nodo:1059 / Elemento padre: 1058   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1059)).setAttribute("src","b.gif" );
      ((Element)v.get(1059)).setAttribute("width","25" );
      ((Element)v.get(1059)).setAttribute("height","8" );
      ((Element)v.get(1058)).appendChild((Element)v.get(1059));
      /* Termina nodo:1059   */
      /* Termina nodo:1058   */

      /* Empieza nodo:1060 / Elemento padre: 1046   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1060)).setAttribute("width","100%" );
      ((Element)v.get(1046)).appendChild((Element)v.get(1060));

      /* Empieza nodo:1061 / Elemento padre: 1060   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1061)).setAttribute("src","b.gif" );
      ((Element)v.get(1060)).appendChild((Element)v.get(1061));
      /* Termina nodo:1061   */
      /* Termina nodo:1060   */
      /* Termina nodo:1046   */
      /* Termina nodo:1045   */
      /* Termina nodo:1044   */
      /* Termina nodo:1041   */

      /* Empieza nodo:1062 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1062)).setAttribute("nombre","formGapTr31" );
      ((Element)v.get(40)).appendChild((Element)v.get(1062));

      /* Empieza nodo:1063 / Elemento padre: 1062   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1063)).setAttribute("align","center" );
      ((Element)v.get(1063)).setAttribute("width","12" );
      ((Element)v.get(1062)).appendChild((Element)v.get(1063));

      /* Empieza nodo:1064 / Elemento padre: 1063   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1064)).setAttribute("src","b.gif" );
      ((Element)v.get(1064)).setAttribute("width","12" );
      ((Element)v.get(1064)).setAttribute("height","8" );
      ((Element)v.get(1063)).appendChild((Element)v.get(1064));
      /* Termina nodo:1064   */
      /* Termina nodo:1063   */

      /* Empieza nodo:1065 / Elemento padre: 1062   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1062)).appendChild((Element)v.get(1065));

      /* Empieza nodo:1066 / Elemento padre: 1065   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1066)).setAttribute("src","b.gif" );
      ((Element)v.get(1066)).setAttribute("width","8" );
      ((Element)v.get(1066)).setAttribute("height","8" );
      ((Element)v.get(1065)).appendChild((Element)v.get(1066));
      /* Termina nodo:1066   */
      /* Termina nodo:1065   */

      /* Empieza nodo:1067 / Elemento padre: 1062   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1067)).setAttribute("align","center" );
      ((Element)v.get(1067)).setAttribute("width","12" );
      ((Element)v.get(1062)).appendChild((Element)v.get(1067));

      /* Empieza nodo:1068 / Elemento padre: 1067   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1068)).setAttribute("src","b.gif" );
      ((Element)v.get(1068)).setAttribute("width","12" );
      ((Element)v.get(1068)).setAttribute("height","8" );
      ((Element)v.get(1067)).appendChild((Element)v.get(1068));
      /* Termina nodo:1068   */
      /* Termina nodo:1067   */
      /* Termina nodo:1062   */

      /* Empieza nodo:1069 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1069)).setAttribute("nombre","formTr32" );
      ((Element)v.get(40)).appendChild((Element)v.get(1069));

      /* Empieza nodo:1070 / Elemento padre: 1069   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1070)).setAttribute("align","center" );
      ((Element)v.get(1070)).setAttribute("width","12" );
   }

   private void getXML4860(Document doc) {
      ((Element)v.get(1069)).appendChild((Element)v.get(1070));

      /* Empieza nodo:1071 / Elemento padre: 1070   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1071)).setAttribute("src","b.gif" );
      ((Element)v.get(1071)).setAttribute("width","12" );
      ((Element)v.get(1071)).setAttribute("height","12" );
      ((Element)v.get(1070)).appendChild((Element)v.get(1071));
      /* Termina nodo:1071   */
      /* Termina nodo:1070   */

      /* Empieza nodo:1072 / Elemento padre: 1069   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1072)).setAttribute("width","100%" );
      ((Element)v.get(1069)).appendChild((Element)v.get(1072));

      /* Empieza nodo:1073 / Elemento padre: 1072   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1073)).setAttribute("width","100%" );
      ((Element)v.get(1073)).setAttribute("border","0" );
      ((Element)v.get(1073)).setAttribute("cellspacing","0" );
      ((Element)v.get(1073)).setAttribute("cellpadding","0" );
      ((Element)v.get(1073)).setAttribute("align","left" );
      ((Element)v.get(1072)).appendChild((Element)v.get(1073));

      /* Empieza nodo:1074 / Elemento padre: 1073   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1074)).setAttribute("align","left" );
      ((Element)v.get(1073)).appendChild((Element)v.get(1074));

      /* Empieza nodo:1075 / Elemento padre: 1074   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1075)).setAttribute("nombre","numCampaTdId" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1075));

      /* Empieza nodo:1076 / Elemento padre: 1075   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1076)).setAttribute("width","100%" );
      ((Element)v.get(1076)).setAttribute("border","0" );
      ((Element)v.get(1076)).setAttribute("cellspacing","0" );
      ((Element)v.get(1076)).setAttribute("cellpadding","0" );
      ((Element)v.get(1076)).setAttribute("align","left" );
      ((Element)v.get(1075)).appendChild((Element)v.get(1076));

      /* Empieza nodo:1077 / Elemento padre: 1076   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1076)).appendChild((Element)v.get(1077));

      /* Empieza nodo:1078 / Elemento padre: 1077   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1078)).setAttribute("valign","top" );
      ((Element)v.get(1078)).setAttribute("height","13" );
      ((Element)v.get(1077)).appendChild((Element)v.get(1078));

      /* Empieza nodo:1079 / Elemento padre: 1078   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1079)).setAttribute("nombre","lblNumCampa" );
      ((Element)v.get(1079)).setAttribute("alto","13" );
      ((Element)v.get(1079)).setAttribute("filas","1" );
      ((Element)v.get(1079)).setAttribute("id","datosTitle" );
      ((Element)v.get(1079)).setAttribute("cod","EduMatriCurso.numCampa.label" );
      ((Element)v.get(1078)).appendChild((Element)v.get(1079));
      /* Termina nodo:1079   */
      /* Termina nodo:1078   */
      /* Termina nodo:1077   */

      /* Empieza nodo:1080 / Elemento padre: 1076   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1080)).setAttribute("nombre","numCampaWidgetTrId" );
      ((Element)v.get(1076)).appendChild((Element)v.get(1080));

      /* Empieza nodo:1081 / Elemento padre: 1080   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1081)).setAttribute("align","left" );
      ((Element)v.get(1081)).setAttribute("nowrap","true" );
      ((Element)v.get(1080)).appendChild((Element)v.get(1081));

      /* Empieza nodo:1082 / Elemento padre: 1081   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(1082)).setAttribute("nombre","numCampa" );
      ((Element)v.get(1082)).setAttribute("id","datosCampos" );
      ((Element)v.get(1082)).setAttribute("trim","S" );
      ((Element)v.get(1082)).setAttribute("max","2" );
      ((Element)v.get(1082)).setAttribute("onchange","" );
      ((Element)v.get(1082)).setAttribute("req","N" );
      ((Element)v.get(1082)).setAttribute("size","2" );
      ((Element)v.get(1082)).setAttribute("valor","" );
      ((Element)v.get(1082)).setAttribute("validacion","" );
      ((Element)v.get(1082)).setAttribute("onblur","" );
      ((Element)v.get(1082)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true)" );
      ((Element)v.get(1082)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm', 0, false)" );
      ((Element)v.get(1081)).appendChild((Element)v.get(1082));
      /* Termina nodo:1082   */
      /* Termina nodo:1081   */
      /* Termina nodo:1080   */

      /* Empieza nodo:1083 / Elemento padre: 1076   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1083)).setAttribute("nombre","numCampaViewLabelTrId" );
      ((Element)v.get(1076)).appendChild((Element)v.get(1083));

      /* Empieza nodo:1084 / Elemento padre: 1083   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1084)).setAttribute("valign","top" );
      ((Element)v.get(1084)).setAttribute("height","13" );
      ((Element)v.get(1083)).appendChild((Element)v.get(1084));

      /* Empieza nodo:1085 / Elemento padre: 1084   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1085)).setAttribute("nombre","lblViewNumCampa" );
      ((Element)v.get(1085)).setAttribute("alto","13" );
      ((Element)v.get(1085)).setAttribute("ancho","100" );
      ((Element)v.get(1085)).setAttribute("id","EstDat" );
      ((Element)v.get(1085)).setAttribute("valor","" );
      ((Element)v.get(1084)).appendChild((Element)v.get(1085));
      /* Termina nodo:1085   */
      /* Termina nodo:1084   */
      /* Termina nodo:1083   */
      /* Termina nodo:1076   */
      /* Termina nodo:1075   */

      /* Empieza nodo:1086 / Elemento padre: 1074   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1086)).setAttribute("nombre","numCampaGapTdId" );
      ((Element)v.get(1086)).setAttribute("nowrap","true" );
      ((Element)v.get(1086)).setAttribute("class","datosCampos" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1086));

      /* Empieza nodo:1087 / Elemento padre: 1086   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1087)).setAttribute("src","b.gif" );
      ((Element)v.get(1087)).setAttribute("width","25" );
      ((Element)v.get(1087)).setAttribute("height","8" );
      ((Element)v.get(1086)).appendChild((Element)v.get(1087));
      /* Termina nodo:1087   */
      /* Termina nodo:1086   */

      /* Empieza nodo:1088 / Elemento padre: 1074   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1088)).setAttribute("width","100%" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1088));

      /* Empieza nodo:1089 / Elemento padre: 1088   */
   }

   private void getXML4950(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1089)).setAttribute("src","b.gif" );
      ((Element)v.get(1088)).appendChild((Element)v.get(1089));
      /* Termina nodo:1089   */
      /* Termina nodo:1088   */
      /* Termina nodo:1074   */
      /* Termina nodo:1073   */
      /* Termina nodo:1072   */
      /* Termina nodo:1069   */

      /* Empieza nodo:1090 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1090)).setAttribute("nombre","formGapTr32" );
      ((Element)v.get(40)).appendChild((Element)v.get(1090));

      /* Empieza nodo:1091 / Elemento padre: 1090   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1091)).setAttribute("align","center" );
      ((Element)v.get(1091)).setAttribute("width","12" );
      ((Element)v.get(1090)).appendChild((Element)v.get(1091));

      /* Empieza nodo:1092 / Elemento padre: 1091   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1092)).setAttribute("src","b.gif" );
      ((Element)v.get(1092)).setAttribute("width","12" );
      ((Element)v.get(1092)).setAttribute("height","8" );
      ((Element)v.get(1091)).appendChild((Element)v.get(1092));
      /* Termina nodo:1092   */
      /* Termina nodo:1091   */

      /* Empieza nodo:1093 / Elemento padre: 1090   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1090)).appendChild((Element)v.get(1093));

      /* Empieza nodo:1094 / Elemento padre: 1093   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1094)).setAttribute("src","b.gif" );
      ((Element)v.get(1094)).setAttribute("width","8" );
      ((Element)v.get(1094)).setAttribute("height","8" );
      ((Element)v.get(1093)).appendChild((Element)v.get(1094));
      /* Termina nodo:1094   */
      /* Termina nodo:1093   */

      /* Empieza nodo:1095 / Elemento padre: 1090   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1095)).setAttribute("align","center" );
      ((Element)v.get(1095)).setAttribute("width","12" );
      ((Element)v.get(1090)).appendChild((Element)v.get(1095));

      /* Empieza nodo:1096 / Elemento padre: 1095   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1096)).setAttribute("src","b.gif" );
      ((Element)v.get(1096)).setAttribute("width","12" );
      ((Element)v.get(1096)).setAttribute("height","8" );
      ((Element)v.get(1095)).appendChild((Element)v.get(1096));
      /* Termina nodo:1096   */
      /* Termina nodo:1095   */
      /* Termina nodo:1090   */

      /* Empieza nodo:1097 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1097)).setAttribute("nombre","formTr33" );
      ((Element)v.get(40)).appendChild((Element)v.get(1097));

      /* Empieza nodo:1098 / Elemento padre: 1097   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1098)).setAttribute("align","center" );
      ((Element)v.get(1098)).setAttribute("width","12" );
      ((Element)v.get(1097)).appendChild((Element)v.get(1098));

      /* Empieza nodo:1099 / Elemento padre: 1098   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1099)).setAttribute("src","b.gif" );
      ((Element)v.get(1099)).setAttribute("width","12" );
      ((Element)v.get(1099)).setAttribute("height","12" );
      ((Element)v.get(1098)).appendChild((Element)v.get(1099));
      /* Termina nodo:1099   */
      /* Termina nodo:1098   */

      /* Empieza nodo:1100 / Elemento padre: 1097   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1100)).setAttribute("width","100%" );
      ((Element)v.get(1097)).appendChild((Element)v.get(1100));

      /* Empieza nodo:1101 / Elemento padre: 1100   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1101)).setAttribute("width","100%" );
      ((Element)v.get(1101)).setAttribute("border","0" );
      ((Element)v.get(1101)).setAttribute("cellspacing","0" );
      ((Element)v.get(1101)).setAttribute("cellpadding","0" );
      ((Element)v.get(1101)).setAttribute("align","left" );
      ((Element)v.get(1100)).appendChild((Element)v.get(1101));

      /* Empieza nodo:1102 / Elemento padre: 1101   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1102)).setAttribute("align","left" );
      ((Element)v.get(1101)).appendChild((Element)v.get(1102));

      /* Empieza nodo:1103 / Elemento padre: 1102   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1103)).setAttribute("nombre","numUnidTdId" );
      ((Element)v.get(1102)).appendChild((Element)v.get(1103));

      /* Empieza nodo:1104 / Elemento padre: 1103   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1104)).setAttribute("width","100%" );
      ((Element)v.get(1104)).setAttribute("border","0" );
      ((Element)v.get(1104)).setAttribute("cellspacing","0" );
      ((Element)v.get(1104)).setAttribute("cellpadding","0" );
      ((Element)v.get(1104)).setAttribute("align","left" );
      ((Element)v.get(1103)).appendChild((Element)v.get(1104));

      /* Empieza nodo:1105 / Elemento padre: 1104   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1104)).appendChild((Element)v.get(1105));

      /* Empieza nodo:1106 / Elemento padre: 1105   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1106)).setAttribute("valign","top" );
      ((Element)v.get(1106)).setAttribute("height","13" );
      ((Element)v.get(1105)).appendChild((Element)v.get(1106));

      /* Empieza nodo:1107 / Elemento padre: 1106   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1107)).setAttribute("nombre","lblNumUnid" );
      ((Element)v.get(1107)).setAttribute("alto","13" );
      ((Element)v.get(1107)).setAttribute("filas","1" );
      ((Element)v.get(1107)).setAttribute("id","datosTitle" );
      ((Element)v.get(1107)).setAttribute("cod","EduMatriCurso.numUnid.label" );
      ((Element)v.get(1106)).appendChild((Element)v.get(1107));
      /* Termina nodo:1107   */
      /* Termina nodo:1106   */
      /* Termina nodo:1105   */

      /* Empieza nodo:1108 / Elemento padre: 1104   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1108)).setAttribute("nombre","numUnidWidgetTrId" );
      ((Element)v.get(1104)).appendChild((Element)v.get(1108));

      /* Empieza nodo:1109 / Elemento padre: 1108   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1109)).setAttribute("align","left" );
      ((Element)v.get(1109)).setAttribute("nowrap","true" );
      ((Element)v.get(1108)).appendChild((Element)v.get(1109));

      /* Empieza nodo:1110 / Elemento padre: 1109   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(1110)).setAttribute("nombre","numUnid" );
      ((Element)v.get(1110)).setAttribute("id","datosCampos" );
      ((Element)v.get(1110)).setAttribute("trim","S" );
   }

   private void getXML5040(Document doc) {
      ((Element)v.get(1110)).setAttribute("max","2" );
      ((Element)v.get(1110)).setAttribute("onchange","" );
      ((Element)v.get(1110)).setAttribute("req","N" );
      ((Element)v.get(1110)).setAttribute("size","2" );
      ((Element)v.get(1110)).setAttribute("valor","" );
      ((Element)v.get(1110)).setAttribute("validacion","" );
      ((Element)v.get(1110)).setAttribute("onblur","" );
      ((Element)v.get(1110)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true)" );
      ((Element)v.get(1110)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm', 0, false)" );
      ((Element)v.get(1109)).appendChild((Element)v.get(1110));
      /* Termina nodo:1110   */
      /* Termina nodo:1109   */
      /* Termina nodo:1108   */

      /* Empieza nodo:1111 / Elemento padre: 1104   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1111)).setAttribute("nombre","numUnidViewLabelTrId" );
      ((Element)v.get(1104)).appendChild((Element)v.get(1111));

      /* Empieza nodo:1112 / Elemento padre: 1111   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1112)).setAttribute("valign","top" );
      ((Element)v.get(1112)).setAttribute("height","13" );
      ((Element)v.get(1111)).appendChild((Element)v.get(1112));

      /* Empieza nodo:1113 / Elemento padre: 1112   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1113)).setAttribute("nombre","lblViewNumUnid" );
      ((Element)v.get(1113)).setAttribute("alto","13" );
      ((Element)v.get(1113)).setAttribute("ancho","100" );
      ((Element)v.get(1113)).setAttribute("id","EstDat" );
      ((Element)v.get(1113)).setAttribute("valor","" );
      ((Element)v.get(1112)).appendChild((Element)v.get(1113));
      /* Termina nodo:1113   */
      /* Termina nodo:1112   */
      /* Termina nodo:1111   */
      /* Termina nodo:1104   */
      /* Termina nodo:1103   */

      /* Empieza nodo:1114 / Elemento padre: 1102   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1114)).setAttribute("nombre","numUnidGapTdId" );
      ((Element)v.get(1114)).setAttribute("nowrap","true" );
      ((Element)v.get(1114)).setAttribute("class","datosCampos" );
      ((Element)v.get(1102)).appendChild((Element)v.get(1114));

      /* Empieza nodo:1115 / Elemento padre: 1114   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1115)).setAttribute("src","b.gif" );
      ((Element)v.get(1115)).setAttribute("width","25" );
      ((Element)v.get(1115)).setAttribute("height","8" );
      ((Element)v.get(1114)).appendChild((Element)v.get(1115));
      /* Termina nodo:1115   */
      /* Termina nodo:1114   */

      /* Empieza nodo:1116 / Elemento padre: 1102   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1116)).setAttribute("width","100%" );
      ((Element)v.get(1102)).appendChild((Element)v.get(1116));

      /* Empieza nodo:1117 / Elemento padre: 1116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1117)).setAttribute("src","b.gif" );
      ((Element)v.get(1116)).appendChild((Element)v.get(1117));
      /* Termina nodo:1117   */
      /* Termina nodo:1116   */
      /* Termina nodo:1102   */
      /* Termina nodo:1101   */
      /* Termina nodo:1100   */
      /* Termina nodo:1097   */

      /* Empieza nodo:1118 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1118)).setAttribute("nombre","formGapTr33" );
      ((Element)v.get(40)).appendChild((Element)v.get(1118));

      /* Empieza nodo:1119 / Elemento padre: 1118   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1119)).setAttribute("align","center" );
      ((Element)v.get(1119)).setAttribute("width","12" );
      ((Element)v.get(1118)).appendChild((Element)v.get(1119));

      /* Empieza nodo:1120 / Elemento padre: 1119   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1120)).setAttribute("src","b.gif" );
      ((Element)v.get(1120)).setAttribute("width","12" );
      ((Element)v.get(1120)).setAttribute("height","8" );
      ((Element)v.get(1119)).appendChild((Element)v.get(1120));
      /* Termina nodo:1120   */
      /* Termina nodo:1119   */

      /* Empieza nodo:1121 / Elemento padre: 1118   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1118)).appendChild((Element)v.get(1121));

      /* Empieza nodo:1122 / Elemento padre: 1121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1122)).setAttribute("src","b.gif" );
      ((Element)v.get(1122)).setAttribute("width","8" );
      ((Element)v.get(1122)).setAttribute("height","8" );
      ((Element)v.get(1121)).appendChild((Element)v.get(1122));
      /* Termina nodo:1122   */
      /* Termina nodo:1121   */

      /* Empieza nodo:1123 / Elemento padre: 1118   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1123)).setAttribute("align","center" );
      ((Element)v.get(1123)).setAttribute("width","12" );
      ((Element)v.get(1118)).appendChild((Element)v.get(1123));

      /* Empieza nodo:1124 / Elemento padre: 1123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1124)).setAttribute("src","b.gif" );
      ((Element)v.get(1124)).setAttribute("width","12" );
      ((Element)v.get(1124)).setAttribute("height","8" );
      ((Element)v.get(1123)).appendChild((Element)v.get(1124));
      /* Termina nodo:1124   */
      /* Termina nodo:1123   */
      /* Termina nodo:1118   */

      /* Empieza nodo:1125 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1125)).setAttribute("nombre","formTr34" );
      ((Element)v.get(40)).appendChild((Element)v.get(1125));

      /* Empieza nodo:1126 / Elemento padre: 1125   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1126)).setAttribute("align","center" );
      ((Element)v.get(1126)).setAttribute("width","12" );
      ((Element)v.get(1125)).appendChild((Element)v.get(1126));

      /* Empieza nodo:1127 / Elemento padre: 1126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1127)).setAttribute("src","b.gif" );
      ((Element)v.get(1127)).setAttribute("width","12" );
      ((Element)v.get(1127)).setAttribute("height","12" );
      ((Element)v.get(1126)).appendChild((Element)v.get(1127));
      /* Termina nodo:1127   */
      /* Termina nodo:1126   */

      /* Empieza nodo:1128 / Elemento padre: 1125   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1128)).setAttribute("width","100%" );
      ((Element)v.get(1125)).appendChild((Element)v.get(1128));

      /* Empieza nodo:1129 / Elemento padre: 1128   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1129)).setAttribute("width","100%" );
      ((Element)v.get(1129)).setAttribute("border","0" );
      ((Element)v.get(1129)).setAttribute("cellspacing","0" );
      ((Element)v.get(1129)).setAttribute("cellpadding","0" );
      ((Element)v.get(1129)).setAttribute("align","left" );
      ((Element)v.get(1128)).appendChild((Element)v.get(1129));

      /* Empieza nodo:1130 / Elemento padre: 1129   */
   }

   private void getXML5130(Document doc) {
      v.add(doc.createElement("TR"));
      ((Element)v.get(1130)).setAttribute("align","left" );
      ((Element)v.get(1129)).appendChild((Element)v.get(1130));

      /* Empieza nodo:1131 / Elemento padre: 1130   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1131)).setAttribute("nombre","desCursTdId" );
      ((Element)v.get(1130)).appendChild((Element)v.get(1131));

      /* Empieza nodo:1132 / Elemento padre: 1131   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1132)).setAttribute("width","100%" );
      ((Element)v.get(1132)).setAttribute("border","0" );
      ((Element)v.get(1132)).setAttribute("cellspacing","0" );
      ((Element)v.get(1132)).setAttribute("cellpadding","0" );
      ((Element)v.get(1132)).setAttribute("align","left" );
      ((Element)v.get(1131)).appendChild((Element)v.get(1132));

      /* Empieza nodo:1133 / Elemento padre: 1132   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1132)).appendChild((Element)v.get(1133));

      /* Empieza nodo:1134 / Elemento padre: 1133   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1134)).setAttribute("valign","top" );
      ((Element)v.get(1134)).setAttribute("height","13" );
      ((Element)v.get(1133)).appendChild((Element)v.get(1134));

      /* Empieza nodo:1135 / Elemento padre: 1134   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1135)).setAttribute("nombre","lblDesCurs" );
      ((Element)v.get(1135)).setAttribute("alto","13" );
      ((Element)v.get(1135)).setAttribute("filas","1" );
      ((Element)v.get(1135)).setAttribute("id","datosTitle" );
      ((Element)v.get(1135)).setAttribute("cod","EduMatriCurso.desCurs.label" );
      ((Element)v.get(1134)).appendChild((Element)v.get(1135));
      /* Termina nodo:1135   */
      /* Termina nodo:1134   */
      /* Termina nodo:1133   */

      /* Empieza nodo:1136 / Elemento padre: 1132   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1136)).setAttribute("nombre","desCursWidgetTrId" );
      ((Element)v.get(1132)).appendChild((Element)v.get(1136));

      /* Empieza nodo:1137 / Elemento padre: 1136   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1137)).setAttribute("align","left" );
      ((Element)v.get(1137)).setAttribute("nowrap","true" );
      ((Element)v.get(1136)).appendChild((Element)v.get(1137));

      /* Empieza nodo:1138 / Elemento padre: 1137   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(1138)).setAttribute("nombre","desCurs" );
      ((Element)v.get(1138)).setAttribute("id","datosCampos" );
      ((Element)v.get(1138)).setAttribute("trim","S" );
      ((Element)v.get(1138)).setAttribute("max","100" );
      ((Element)v.get(1138)).setAttribute("onchange","" );
      ((Element)v.get(1138)).setAttribute("req","N" );
      ((Element)v.get(1138)).setAttribute("size","100" );
      ((Element)v.get(1138)).setAttribute("valor","" );
      ((Element)v.get(1138)).setAttribute("validacion","" );
      ((Element)v.get(1138)).setAttribute("onblur","" );
      ((Element)v.get(1138)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true)" );
      ((Element)v.get(1138)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm', 0, false)" );
      ((Element)v.get(1137)).appendChild((Element)v.get(1138));
      /* Termina nodo:1138   */
      /* Termina nodo:1137   */
      /* Termina nodo:1136   */

      /* Empieza nodo:1139 / Elemento padre: 1132   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1139)).setAttribute("nombre","desCursViewLabelTrId" );
      ((Element)v.get(1132)).appendChild((Element)v.get(1139));

      /* Empieza nodo:1140 / Elemento padre: 1139   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1140)).setAttribute("valign","top" );
      ((Element)v.get(1140)).setAttribute("height","13" );
      ((Element)v.get(1139)).appendChild((Element)v.get(1140));

      /* Empieza nodo:1141 / Elemento padre: 1140   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1141)).setAttribute("nombre","lblViewDesCurs" );
      ((Element)v.get(1141)).setAttribute("alto","13" );
      ((Element)v.get(1141)).setAttribute("ancho","100" );
      ((Element)v.get(1141)).setAttribute("id","EstDat" );
      ((Element)v.get(1141)).setAttribute("valor","" );
      ((Element)v.get(1140)).appendChild((Element)v.get(1141));
      /* Termina nodo:1141   */
      /* Termina nodo:1140   */
      /* Termina nodo:1139   */
      /* Termina nodo:1132   */
      /* Termina nodo:1131   */

      /* Empieza nodo:1142 / Elemento padre: 1130   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1142)).setAttribute("nombre","desCursGapTdId" );
      ((Element)v.get(1142)).setAttribute("nowrap","true" );
      ((Element)v.get(1142)).setAttribute("class","datosCampos" );
      ((Element)v.get(1130)).appendChild((Element)v.get(1142));

      /* Empieza nodo:1143 / Elemento padre: 1142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1143)).setAttribute("src","b.gif" );
      ((Element)v.get(1143)).setAttribute("width","25" );
      ((Element)v.get(1143)).setAttribute("height","8" );
      ((Element)v.get(1142)).appendChild((Element)v.get(1143));
      /* Termina nodo:1143   */
      /* Termina nodo:1142   */

      /* Empieza nodo:1144 / Elemento padre: 1130   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1144)).setAttribute("width","100%" );
      ((Element)v.get(1130)).appendChild((Element)v.get(1144));

      /* Empieza nodo:1145 / Elemento padre: 1144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1145)).setAttribute("src","b.gif" );
      ((Element)v.get(1144)).appendChild((Element)v.get(1145));
      /* Termina nodo:1145   */
      /* Termina nodo:1144   */
      /* Termina nodo:1130   */
      /* Termina nodo:1129   */
      /* Termina nodo:1128   */
      /* Termina nodo:1125   */

      /* Empieza nodo:1146 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1146)).setAttribute("nombre","formGapTr34" );
      ((Element)v.get(40)).appendChild((Element)v.get(1146));

      /* Empieza nodo:1147 / Elemento padre: 1146   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1147)).setAttribute("align","center" );
      ((Element)v.get(1147)).setAttribute("width","12" );
      ((Element)v.get(1146)).appendChild((Element)v.get(1147));

      /* Empieza nodo:1148 / Elemento padre: 1147   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1148)).setAttribute("src","b.gif" );
      ((Element)v.get(1148)).setAttribute("width","12" );
      ((Element)v.get(1148)).setAttribute("height","8" );
      ((Element)v.get(1147)).appendChild((Element)v.get(1148));
      /* Termina nodo:1148   */
      /* Termina nodo:1147   */

      /* Empieza nodo:1149 / Elemento padre: 1146   */
      v.add(doc.createElement("TD"));
   }

   private void getXML5220(Document doc) {
      ((Element)v.get(1146)).appendChild((Element)v.get(1149));

      /* Empieza nodo:1150 / Elemento padre: 1149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1150)).setAttribute("src","b.gif" );
      ((Element)v.get(1150)).setAttribute("width","8" );
      ((Element)v.get(1150)).setAttribute("height","8" );
      ((Element)v.get(1149)).appendChild((Element)v.get(1150));
      /* Termina nodo:1150   */
      /* Termina nodo:1149   */

      /* Empieza nodo:1151 / Elemento padre: 1146   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1151)).setAttribute("align","center" );
      ((Element)v.get(1151)).setAttribute("width","12" );
      ((Element)v.get(1146)).appendChild((Element)v.get(1151));

      /* Empieza nodo:1152 / Elemento padre: 1151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1152)).setAttribute("src","b.gif" );
      ((Element)v.get(1152)).setAttribute("width","12" );
      ((Element)v.get(1152)).setAttribute("height","8" );
      ((Element)v.get(1151)).appendChild((Element)v.get(1152));
      /* Termina nodo:1152   */
      /* Termina nodo:1151   */
      /* Termina nodo:1146   */

      /* Empieza nodo:1153 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1153)).setAttribute("nombre","formTr35" );
      ((Element)v.get(40)).appendChild((Element)v.get(1153));

      /* Empieza nodo:1154 / Elemento padre: 1153   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1154)).setAttribute("align","center" );
      ((Element)v.get(1154)).setAttribute("width","12" );
      ((Element)v.get(1153)).appendChild((Element)v.get(1154));

      /* Empieza nodo:1155 / Elemento padre: 1154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1155)).setAttribute("src","b.gif" );
      ((Element)v.get(1155)).setAttribute("width","12" );
      ((Element)v.get(1155)).setAttribute("height","12" );
      ((Element)v.get(1154)).appendChild((Element)v.get(1155));
      /* Termina nodo:1155   */
      /* Termina nodo:1154   */

      /* Empieza nodo:1156 / Elemento padre: 1153   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1156)).setAttribute("width","100%" );
      ((Element)v.get(1153)).appendChild((Element)v.get(1156));

      /* Empieza nodo:1157 / Elemento padre: 1156   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1157)).setAttribute("width","100%" );
      ((Element)v.get(1157)).setAttribute("border","0" );
      ((Element)v.get(1157)).setAttribute("cellspacing","0" );
      ((Element)v.get(1157)).setAttribute("cellpadding","0" );
      ((Element)v.get(1157)).setAttribute("align","left" );
      ((Element)v.get(1156)).appendChild((Element)v.get(1157));

      /* Empieza nodo:1158 / Elemento padre: 1157   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1158)).setAttribute("align","left" );
      ((Element)v.get(1157)).appendChild((Element)v.get(1158));

      /* Empieza nodo:1159 / Elemento padre: 1158   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1159)).setAttribute("nombre","indAcceDmrtTdId" );
      ((Element)v.get(1158)).appendChild((Element)v.get(1159));

      /* Empieza nodo:1160 / Elemento padre: 1159   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1160)).setAttribute("width","100%" );
      ((Element)v.get(1160)).setAttribute("border","0" );
      ((Element)v.get(1160)).setAttribute("cellspacing","0" );
      ((Element)v.get(1160)).setAttribute("cellpadding","0" );
      ((Element)v.get(1160)).setAttribute("align","left" );
      ((Element)v.get(1159)).appendChild((Element)v.get(1160));

      /* Empieza nodo:1161 / Elemento padre: 1160   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1160)).appendChild((Element)v.get(1161));

      /* Empieza nodo:1162 / Elemento padre: 1161   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1162)).setAttribute("valign","top" );
      ((Element)v.get(1162)).setAttribute("height","13" );
      ((Element)v.get(1161)).appendChild((Element)v.get(1162));

      /* Empieza nodo:1163 / Elemento padre: 1162   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1163)).setAttribute("nombre","lblIndAcceDmrt" );
      ((Element)v.get(1163)).setAttribute("alto","13" );
      ((Element)v.get(1163)).setAttribute("filas","1" );
      ((Element)v.get(1163)).setAttribute("id","datosTitle" );
      ((Element)v.get(1163)).setAttribute("cod","EduMatriCurso.indAcceDmrt.label" );
      ((Element)v.get(1162)).appendChild((Element)v.get(1163));
      /* Termina nodo:1163   */
      /* Termina nodo:1162   */
      /* Termina nodo:1161   */

      /* Empieza nodo:1164 / Elemento padre: 1160   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1164)).setAttribute("nombre","indAcceDmrtWidgetTrId" );
      ((Element)v.get(1160)).appendChild((Element)v.get(1164));

      /* Empieza nodo:1165 / Elemento padre: 1164   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1165)).setAttribute("align","left" );
      ((Element)v.get(1165)).setAttribute("nowrap","true" );
      ((Element)v.get(1164)).appendChild((Element)v.get(1165));

      /* Empieza nodo:1166 / Elemento padre: 1165   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(1166)).setAttribute("nombre","indAcceDmrt" );
      ((Element)v.get(1166)).setAttribute("id","datosCampos" );
      ((Element)v.get(1166)).setAttribute("trim","S" );
      ((Element)v.get(1166)).setAttribute("max","1" );
      ((Element)v.get(1166)).setAttribute("onchange","" );
      ((Element)v.get(1166)).setAttribute("req","N" );
      ((Element)v.get(1166)).setAttribute("size","1" );
      ((Element)v.get(1166)).setAttribute("valor","" );
      ((Element)v.get(1166)).setAttribute("validacion","" );
      ((Element)v.get(1166)).setAttribute("onblur","" );
      ((Element)v.get(1166)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true)" );
      ((Element)v.get(1166)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm', 0, false)" );
      ((Element)v.get(1165)).appendChild((Element)v.get(1166));
      /* Termina nodo:1166   */
      /* Termina nodo:1165   */
      /* Termina nodo:1164   */

      /* Empieza nodo:1167 / Elemento padre: 1160   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1167)).setAttribute("nombre","indAcceDmrtViewLabelTrId" );
      ((Element)v.get(1160)).appendChild((Element)v.get(1167));

      /* Empieza nodo:1168 / Elemento padre: 1167   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1168)).setAttribute("valign","top" );
      ((Element)v.get(1168)).setAttribute("height","13" );
   }

   private void getXML5310(Document doc) {
      ((Element)v.get(1167)).appendChild((Element)v.get(1168));

      /* Empieza nodo:1169 / Elemento padre: 1168   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1169)).setAttribute("nombre","lblViewIndAcceDmrt" );
      ((Element)v.get(1169)).setAttribute("alto","13" );
      ((Element)v.get(1169)).setAttribute("ancho","100" );
      ((Element)v.get(1169)).setAttribute("id","EstDat" );
      ((Element)v.get(1169)).setAttribute("valor","" );
      ((Element)v.get(1168)).appendChild((Element)v.get(1169));
      /* Termina nodo:1169   */
      /* Termina nodo:1168   */
      /* Termina nodo:1167   */
      /* Termina nodo:1160   */
      /* Termina nodo:1159   */

      /* Empieza nodo:1170 / Elemento padre: 1158   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1170)).setAttribute("nombre","indAcceDmrtGapTdId" );
      ((Element)v.get(1170)).setAttribute("nowrap","true" );
      ((Element)v.get(1170)).setAttribute("class","datosCampos" );
      ((Element)v.get(1158)).appendChild((Element)v.get(1170));

      /* Empieza nodo:1171 / Elemento padre: 1170   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1171)).setAttribute("src","b.gif" );
      ((Element)v.get(1171)).setAttribute("width","25" );
      ((Element)v.get(1171)).setAttribute("height","8" );
      ((Element)v.get(1170)).appendChild((Element)v.get(1171));
      /* Termina nodo:1171   */
      /* Termina nodo:1170   */

      /* Empieza nodo:1172 / Elemento padre: 1158   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1172)).setAttribute("width","100%" );
      ((Element)v.get(1158)).appendChild((Element)v.get(1172));

      /* Empieza nodo:1173 / Elemento padre: 1172   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1173)).setAttribute("src","b.gif" );
      ((Element)v.get(1172)).appendChild((Element)v.get(1173));
      /* Termina nodo:1173   */
      /* Termina nodo:1172   */
      /* Termina nodo:1158   */
      /* Termina nodo:1157   */
      /* Termina nodo:1156   */
      /* Termina nodo:1153   */

      /* Empieza nodo:1174 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1174)).setAttribute("nombre","formGapTr35" );
      ((Element)v.get(40)).appendChild((Element)v.get(1174));

      /* Empieza nodo:1175 / Elemento padre: 1174   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1175)).setAttribute("align","center" );
      ((Element)v.get(1175)).setAttribute("width","12" );
      ((Element)v.get(1174)).appendChild((Element)v.get(1175));

      /* Empieza nodo:1176 / Elemento padre: 1175   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1176)).setAttribute("src","b.gif" );
      ((Element)v.get(1176)).setAttribute("width","12" );
      ((Element)v.get(1176)).setAttribute("height","8" );
      ((Element)v.get(1175)).appendChild((Element)v.get(1176));
      /* Termina nodo:1176   */
      /* Termina nodo:1175   */

      /* Empieza nodo:1177 / Elemento padre: 1174   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1174)).appendChild((Element)v.get(1177));

      /* Empieza nodo:1178 / Elemento padre: 1177   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1178)).setAttribute("src","b.gif" );
      ((Element)v.get(1178)).setAttribute("width","8" );
      ((Element)v.get(1178)).setAttribute("height","8" );
      ((Element)v.get(1177)).appendChild((Element)v.get(1178));
      /* Termina nodo:1178   */
      /* Termina nodo:1177   */

      /* Empieza nodo:1179 / Elemento padre: 1174   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1179)).setAttribute("align","center" );
      ((Element)v.get(1179)).setAttribute("width","12" );
      ((Element)v.get(1174)).appendChild((Element)v.get(1179));

      /* Empieza nodo:1180 / Elemento padre: 1179   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1180)).setAttribute("src","b.gif" );
      ((Element)v.get(1180)).setAttribute("width","12" );
      ((Element)v.get(1180)).setAttribute("height","8" );
      ((Element)v.get(1179)).appendChild((Element)v.get(1180));
      /* Termina nodo:1180   */
      /* Termina nodo:1179   */
      /* Termina nodo:1174   */

      /* Empieza nodo:1181 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1181)).setAttribute("nombre","formTr36" );
      ((Element)v.get(40)).appendChild((Element)v.get(1181));

      /* Empieza nodo:1182 / Elemento padre: 1181   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1182)).setAttribute("align","center" );
      ((Element)v.get(1182)).setAttribute("width","12" );
      ((Element)v.get(1181)).appendChild((Element)v.get(1182));

      /* Empieza nodo:1183 / Elemento padre: 1182   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1183)).setAttribute("src","b.gif" );
      ((Element)v.get(1183)).setAttribute("width","12" );
      ((Element)v.get(1183)).setAttribute("height","12" );
      ((Element)v.get(1182)).appendChild((Element)v.get(1183));
      /* Termina nodo:1183   */
      /* Termina nodo:1182   */

      /* Empieza nodo:1184 / Elemento padre: 1181   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1184)).setAttribute("width","100%" );
      ((Element)v.get(1181)).appendChild((Element)v.get(1184));

      /* Empieza nodo:1185 / Elemento padre: 1184   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1185)).setAttribute("width","100%" );
      ((Element)v.get(1185)).setAttribute("border","0" );
      ((Element)v.get(1185)).setAttribute("cellspacing","0" );
      ((Element)v.get(1185)).setAttribute("cellpadding","0" );
      ((Element)v.get(1185)).setAttribute("align","left" );
      ((Element)v.get(1184)).appendChild((Element)v.get(1185));

      /* Empieza nodo:1186 / Elemento padre: 1185   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1186)).setAttribute("align","left" );
      ((Element)v.get(1185)).appendChild((Element)v.get(1186));

      /* Empieza nodo:1187 / Elemento padre: 1186   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1187)).setAttribute("nombre","indAcceInfoTdId" );
      ((Element)v.get(1186)).appendChild((Element)v.get(1187));

      /* Empieza nodo:1188 / Elemento padre: 1187   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1188)).setAttribute("width","100%" );
      ((Element)v.get(1188)).setAttribute("border","0" );
      ((Element)v.get(1188)).setAttribute("cellspacing","0" );
      ((Element)v.get(1188)).setAttribute("cellpadding","0" );
      ((Element)v.get(1188)).setAttribute("align","left" );
      ((Element)v.get(1187)).appendChild((Element)v.get(1188));

      /* Empieza nodo:1189 / Elemento padre: 1188   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1188)).appendChild((Element)v.get(1189));

      /* Empieza nodo:1190 / Elemento padre: 1189   */
      v.add(doc.createElement("TD"));
   }

   private void getXML5400(Document doc) {
      ((Element)v.get(1190)).setAttribute("valign","top" );
      ((Element)v.get(1190)).setAttribute("height","13" );
      ((Element)v.get(1189)).appendChild((Element)v.get(1190));

      /* Empieza nodo:1191 / Elemento padre: 1190   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1191)).setAttribute("nombre","lblIndAcceInfo" );
      ((Element)v.get(1191)).setAttribute("alto","13" );
      ((Element)v.get(1191)).setAttribute("filas","1" );
      ((Element)v.get(1191)).setAttribute("id","datosTitle" );
      ((Element)v.get(1191)).setAttribute("cod","EduMatriCurso.indAcceInfo.label" );
      ((Element)v.get(1190)).appendChild((Element)v.get(1191));
      /* Termina nodo:1191   */
      /* Termina nodo:1190   */
      /* Termina nodo:1189   */

      /* Empieza nodo:1192 / Elemento padre: 1188   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1192)).setAttribute("nombre","indAcceInfoWidgetTrId" );
      ((Element)v.get(1188)).appendChild((Element)v.get(1192));

      /* Empieza nodo:1193 / Elemento padre: 1192   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1193)).setAttribute("align","left" );
      ((Element)v.get(1193)).setAttribute("nowrap","true" );
      ((Element)v.get(1192)).appendChild((Element)v.get(1193));

      /* Empieza nodo:1194 / Elemento padre: 1193   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(1194)).setAttribute("nombre","indAcceInfo" );
      ((Element)v.get(1194)).setAttribute("id","datosCampos" );
      ((Element)v.get(1194)).setAttribute("trim","S" );
      ((Element)v.get(1194)).setAttribute("max","1" );
      ((Element)v.get(1194)).setAttribute("onchange","" );
      ((Element)v.get(1194)).setAttribute("req","N" );
      ((Element)v.get(1194)).setAttribute("size","1" );
      ((Element)v.get(1194)).setAttribute("valor","" );
      ((Element)v.get(1194)).setAttribute("validacion","" );
      ((Element)v.get(1194)).setAttribute("onblur","" );
      ((Element)v.get(1194)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true)" );
      ((Element)v.get(1194)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm', 0, false)" );
      ((Element)v.get(1193)).appendChild((Element)v.get(1194));
      /* Termina nodo:1194   */
      /* Termina nodo:1193   */
      /* Termina nodo:1192   */

      /* Empieza nodo:1195 / Elemento padre: 1188   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1195)).setAttribute("nombre","indAcceInfoViewLabelTrId" );
      ((Element)v.get(1188)).appendChild((Element)v.get(1195));

      /* Empieza nodo:1196 / Elemento padre: 1195   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1196)).setAttribute("valign","top" );
      ((Element)v.get(1196)).setAttribute("height","13" );
      ((Element)v.get(1195)).appendChild((Element)v.get(1196));

      /* Empieza nodo:1197 / Elemento padre: 1196   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1197)).setAttribute("nombre","lblViewIndAcceInfo" );
      ((Element)v.get(1197)).setAttribute("alto","13" );
      ((Element)v.get(1197)).setAttribute("ancho","100" );
      ((Element)v.get(1197)).setAttribute("id","EstDat" );
      ((Element)v.get(1197)).setAttribute("valor","" );
      ((Element)v.get(1196)).appendChild((Element)v.get(1197));
      /* Termina nodo:1197   */
      /* Termina nodo:1196   */
      /* Termina nodo:1195   */
      /* Termina nodo:1188   */
      /* Termina nodo:1187   */

      /* Empieza nodo:1198 / Elemento padre: 1186   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1198)).setAttribute("nombre","indAcceInfoGapTdId" );
      ((Element)v.get(1198)).setAttribute("nowrap","true" );
      ((Element)v.get(1198)).setAttribute("class","datosCampos" );
      ((Element)v.get(1186)).appendChild((Element)v.get(1198));

      /* Empieza nodo:1199 / Elemento padre: 1198   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1199)).setAttribute("src","b.gif" );
      ((Element)v.get(1199)).setAttribute("width","25" );
      ((Element)v.get(1199)).setAttribute("height","8" );
      ((Element)v.get(1198)).appendChild((Element)v.get(1199));
      /* Termina nodo:1199   */
      /* Termina nodo:1198   */

      /* Empieza nodo:1200 / Elemento padre: 1186   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1200)).setAttribute("width","100%" );
      ((Element)v.get(1186)).appendChild((Element)v.get(1200));

      /* Empieza nodo:1201 / Elemento padre: 1200   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1201)).setAttribute("src","b.gif" );
      ((Element)v.get(1200)).appendChild((Element)v.get(1201));
      /* Termina nodo:1201   */
      /* Termina nodo:1200   */
      /* Termina nodo:1186   */
      /* Termina nodo:1185   */
      /* Termina nodo:1184   */
      /* Termina nodo:1181   */

      /* Empieza nodo:1202 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1202)).setAttribute("nombre","formGapTr36" );
      ((Element)v.get(40)).appendChild((Element)v.get(1202));

      /* Empieza nodo:1203 / Elemento padre: 1202   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1203)).setAttribute("align","center" );
      ((Element)v.get(1203)).setAttribute("width","12" );
      ((Element)v.get(1202)).appendChild((Element)v.get(1203));

      /* Empieza nodo:1204 / Elemento padre: 1203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1204)).setAttribute("src","b.gif" );
      ((Element)v.get(1204)).setAttribute("width","12" );
      ((Element)v.get(1204)).setAttribute("height","8" );
      ((Element)v.get(1203)).appendChild((Element)v.get(1204));
      /* Termina nodo:1204   */
      /* Termina nodo:1203   */

      /* Empieza nodo:1205 / Elemento padre: 1202   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1202)).appendChild((Element)v.get(1205));

      /* Empieza nodo:1206 / Elemento padre: 1205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1206)).setAttribute("src","b.gif" );
      ((Element)v.get(1206)).setAttribute("width","8" );
      ((Element)v.get(1206)).setAttribute("height","8" );
      ((Element)v.get(1205)).appendChild((Element)v.get(1206));
      /* Termina nodo:1206   */
      /* Termina nodo:1205   */

      /* Empieza nodo:1207 / Elemento padre: 1202   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1207)).setAttribute("align","center" );
      ((Element)v.get(1207)).setAttribute("width","12" );
      ((Element)v.get(1202)).appendChild((Element)v.get(1207));

      /* Empieza nodo:1208 / Elemento padre: 1207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1208)).setAttribute("src","b.gif" );
      ((Element)v.get(1208)).setAttribute("width","12" );
      ((Element)v.get(1208)).setAttribute("height","8" );
      ((Element)v.get(1207)).appendChild((Element)v.get(1208));
      /* Termina nodo:1208   */
      /* Termina nodo:1207   */
      /* Termina nodo:1202   */

      /* Empieza nodo:1209 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
   }

   private void getXML5490(Document doc) {
      ((Element)v.get(1209)).setAttribute("nombre","formTr37" );
      ((Element)v.get(40)).appendChild((Element)v.get(1209));

      /* Empieza nodo:1210 / Elemento padre: 1209   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1210)).setAttribute("align","center" );
      ((Element)v.get(1210)).setAttribute("width","12" );
      ((Element)v.get(1209)).appendChild((Element)v.get(1210));

      /* Empieza nodo:1211 / Elemento padre: 1210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1211)).setAttribute("src","b.gif" );
      ((Element)v.get(1211)).setAttribute("width","12" );
      ((Element)v.get(1211)).setAttribute("height","12" );
      ((Element)v.get(1210)).appendChild((Element)v.get(1211));
      /* Termina nodo:1211   */
      /* Termina nodo:1210   */

      /* Empieza nodo:1212 / Elemento padre: 1209   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1212)).setAttribute("width","100%" );
      ((Element)v.get(1209)).appendChild((Element)v.get(1212));

      /* Empieza nodo:1213 / Elemento padre: 1212   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1213)).setAttribute("width","100%" );
      ((Element)v.get(1213)).setAttribute("border","0" );
      ((Element)v.get(1213)).setAttribute("cellspacing","0" );
      ((Element)v.get(1213)).setAttribute("cellpadding","0" );
      ((Element)v.get(1213)).setAttribute("align","left" );
      ((Element)v.get(1212)).appendChild((Element)v.get(1213));

      /* Empieza nodo:1214 / Elemento padre: 1213   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1214)).setAttribute("align","left" );
      ((Element)v.get(1213)).appendChild((Element)v.get(1214));

      /* Empieza nodo:1215 / Elemento padre: 1214   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1215)).setAttribute("nombre","indAlcaGeogTdId" );
      ((Element)v.get(1214)).appendChild((Element)v.get(1215));

      /* Empieza nodo:1216 / Elemento padre: 1215   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1216)).setAttribute("width","100%" );
      ((Element)v.get(1216)).setAttribute("border","0" );
      ((Element)v.get(1216)).setAttribute("cellspacing","0" );
      ((Element)v.get(1216)).setAttribute("cellpadding","0" );
      ((Element)v.get(1216)).setAttribute("align","left" );
      ((Element)v.get(1215)).appendChild((Element)v.get(1216));

      /* Empieza nodo:1217 / Elemento padre: 1216   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1216)).appendChild((Element)v.get(1217));

      /* Empieza nodo:1218 / Elemento padre: 1217   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1218)).setAttribute("valign","top" );
      ((Element)v.get(1218)).setAttribute("height","13" );
      ((Element)v.get(1217)).appendChild((Element)v.get(1218));

      /* Empieza nodo:1219 / Elemento padre: 1218   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1219)).setAttribute("nombre","lblIndAlcaGeog" );
      ((Element)v.get(1219)).setAttribute("alto","13" );
      ((Element)v.get(1219)).setAttribute("filas","1" );
      ((Element)v.get(1219)).setAttribute("id","datosTitle" );
      ((Element)v.get(1219)).setAttribute("cod","EduMatriCurso.indAlcaGeog.label" );
      ((Element)v.get(1218)).appendChild((Element)v.get(1219));
      /* Termina nodo:1219   */
      /* Termina nodo:1218   */
      /* Termina nodo:1217   */

      /* Empieza nodo:1220 / Elemento padre: 1216   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1220)).setAttribute("nombre","indAlcaGeogWidgetTrId" );
      ((Element)v.get(1216)).appendChild((Element)v.get(1220));

      /* Empieza nodo:1221 / Elemento padre: 1220   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1221)).setAttribute("align","left" );
      ((Element)v.get(1221)).setAttribute("nowrap","true" );
      ((Element)v.get(1220)).appendChild((Element)v.get(1221));

      /* Empieza nodo:1222 / Elemento padre: 1221   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(1222)).setAttribute("nombre","indAlcaGeog" );
      ((Element)v.get(1222)).setAttribute("id","datosCampos" );
      ((Element)v.get(1222)).setAttribute("trim","S" );
      ((Element)v.get(1222)).setAttribute("max","1" );
      ((Element)v.get(1222)).setAttribute("onchange","" );
      ((Element)v.get(1222)).setAttribute("req","N" );
      ((Element)v.get(1222)).setAttribute("size","1" );
      ((Element)v.get(1222)).setAttribute("valor","" );
      ((Element)v.get(1222)).setAttribute("validacion","" );
      ((Element)v.get(1222)).setAttribute("onblur","" );
      ((Element)v.get(1222)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true)" );
      ((Element)v.get(1222)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm', 0, false)" );
      ((Element)v.get(1221)).appendChild((Element)v.get(1222));
      /* Termina nodo:1222   */
      /* Termina nodo:1221   */
      /* Termina nodo:1220   */

      /* Empieza nodo:1223 / Elemento padre: 1216   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1223)).setAttribute("nombre","indAlcaGeogViewLabelTrId" );
      ((Element)v.get(1216)).appendChild((Element)v.get(1223));

      /* Empieza nodo:1224 / Elemento padre: 1223   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1224)).setAttribute("valign","top" );
      ((Element)v.get(1224)).setAttribute("height","13" );
      ((Element)v.get(1223)).appendChild((Element)v.get(1224));

      /* Empieza nodo:1225 / Elemento padre: 1224   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1225)).setAttribute("nombre","lblViewIndAlcaGeog" );
      ((Element)v.get(1225)).setAttribute("alto","13" );
      ((Element)v.get(1225)).setAttribute("ancho","100" );
      ((Element)v.get(1225)).setAttribute("id","EstDat" );
      ((Element)v.get(1225)).setAttribute("valor","" );
      ((Element)v.get(1224)).appendChild((Element)v.get(1225));
      /* Termina nodo:1225   */
      /* Termina nodo:1224   */
      /* Termina nodo:1223   */
      /* Termina nodo:1216   */
      /* Termina nodo:1215   */

      /* Empieza nodo:1226 / Elemento padre: 1214   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1226)).setAttribute("nombre","indAlcaGeogGapTdId" );
      ((Element)v.get(1226)).setAttribute("nowrap","true" );
      ((Element)v.get(1226)).setAttribute("class","datosCampos" );
      ((Element)v.get(1214)).appendChild((Element)v.get(1226));

      /* Empieza nodo:1227 / Elemento padre: 1226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1227)).setAttribute("src","b.gif" );
      ((Element)v.get(1227)).setAttribute("width","25" );
   }

   private void getXML5580(Document doc) {
      ((Element)v.get(1227)).setAttribute("height","8" );
      ((Element)v.get(1226)).appendChild((Element)v.get(1227));
      /* Termina nodo:1227   */
      /* Termina nodo:1226   */

      /* Empieza nodo:1228 / Elemento padre: 1214   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1228)).setAttribute("width","100%" );
      ((Element)v.get(1214)).appendChild((Element)v.get(1228));

      /* Empieza nodo:1229 / Elemento padre: 1228   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1229)).setAttribute("src","b.gif" );
      ((Element)v.get(1228)).appendChild((Element)v.get(1229));
      /* Termina nodo:1229   */
      /* Termina nodo:1228   */
      /* Termina nodo:1214   */
      /* Termina nodo:1213   */
      /* Termina nodo:1212   */
      /* Termina nodo:1209   */

      /* Empieza nodo:1230 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1230)).setAttribute("nombre","formGapTr37" );
      ((Element)v.get(40)).appendChild((Element)v.get(1230));

      /* Empieza nodo:1231 / Elemento padre: 1230   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1231)).setAttribute("align","center" );
      ((Element)v.get(1231)).setAttribute("width","12" );
      ((Element)v.get(1230)).appendChild((Element)v.get(1231));

      /* Empieza nodo:1232 / Elemento padre: 1231   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1232)).setAttribute("src","b.gif" );
      ((Element)v.get(1232)).setAttribute("width","12" );
      ((Element)v.get(1232)).setAttribute("height","8" );
      ((Element)v.get(1231)).appendChild((Element)v.get(1232));
      /* Termina nodo:1232   */
      /* Termina nodo:1231   */

      /* Empieza nodo:1233 / Elemento padre: 1230   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1230)).appendChild((Element)v.get(1233));

      /* Empieza nodo:1234 / Elemento padre: 1233   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1234)).setAttribute("src","b.gif" );
      ((Element)v.get(1234)).setAttribute("width","8" );
      ((Element)v.get(1234)).setAttribute("height","8" );
      ((Element)v.get(1233)).appendChild((Element)v.get(1234));
      /* Termina nodo:1234   */
      /* Termina nodo:1233   */

      /* Empieza nodo:1235 / Elemento padre: 1230   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1235)).setAttribute("align","center" );
      ((Element)v.get(1235)).setAttribute("width","12" );
      ((Element)v.get(1230)).appendChild((Element)v.get(1235));

      /* Empieza nodo:1236 / Elemento padre: 1235   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1236)).setAttribute("src","b.gif" );
      ((Element)v.get(1236)).setAttribute("width","12" );
      ((Element)v.get(1236)).setAttribute("height","8" );
      ((Element)v.get(1235)).appendChild((Element)v.get(1236));
      /* Termina nodo:1236   */
      /* Termina nodo:1235   */
      /* Termina nodo:1230   */

      /* Empieza nodo:1237 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1237)).setAttribute("nombre","formTr38" );
      ((Element)v.get(40)).appendChild((Element)v.get(1237));

      /* Empieza nodo:1238 / Elemento padre: 1237   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1238)).setAttribute("align","center" );
      ((Element)v.get(1238)).setAttribute("width","12" );
      ((Element)v.get(1237)).appendChild((Element)v.get(1238));

      /* Empieza nodo:1239 / Elemento padre: 1238   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1239)).setAttribute("src","b.gif" );
      ((Element)v.get(1239)).setAttribute("width","12" );
      ((Element)v.get(1239)).setAttribute("height","12" );
      ((Element)v.get(1238)).appendChild((Element)v.get(1239));
      /* Termina nodo:1239   */
      /* Termina nodo:1238   */

      /* Empieza nodo:1240 / Elemento padre: 1237   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1240)).setAttribute("width","100%" );
      ((Element)v.get(1237)).appendChild((Element)v.get(1240));

      /* Empieza nodo:1241 / Elemento padre: 1240   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1241)).setAttribute("width","100%" );
      ((Element)v.get(1241)).setAttribute("border","0" );
      ((Element)v.get(1241)).setAttribute("cellspacing","0" );
      ((Element)v.get(1241)).setAttribute("cellpadding","0" );
      ((Element)v.get(1241)).setAttribute("align","left" );
      ((Element)v.get(1240)).appendChild((Element)v.get(1241));

      /* Empieza nodo:1242 / Elemento padre: 1241   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1242)).setAttribute("align","left" );
      ((Element)v.get(1241)).appendChild((Element)v.get(1242));

      /* Empieza nodo:1243 / Elemento padre: 1242   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1243)).setAttribute("nombre","indBloqExteTdId" );
      ((Element)v.get(1242)).appendChild((Element)v.get(1243));

      /* Empieza nodo:1244 / Elemento padre: 1243   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1244)).setAttribute("width","100%" );
      ((Element)v.get(1244)).setAttribute("border","0" );
      ((Element)v.get(1244)).setAttribute("cellspacing","0" );
      ((Element)v.get(1244)).setAttribute("cellpadding","0" );
      ((Element)v.get(1244)).setAttribute("align","left" );
      ((Element)v.get(1243)).appendChild((Element)v.get(1244));

      /* Empieza nodo:1245 / Elemento padre: 1244   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1244)).appendChild((Element)v.get(1245));

      /* Empieza nodo:1246 / Elemento padre: 1245   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1246)).setAttribute("valign","top" );
      ((Element)v.get(1246)).setAttribute("height","13" );
      ((Element)v.get(1245)).appendChild((Element)v.get(1246));

      /* Empieza nodo:1247 / Elemento padre: 1246   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1247)).setAttribute("nombre","lblIndBloqExte" );
      ((Element)v.get(1247)).setAttribute("alto","13" );
      ((Element)v.get(1247)).setAttribute("filas","1" );
      ((Element)v.get(1247)).setAttribute("id","datosTitle" );
      ((Element)v.get(1247)).setAttribute("cod","EduMatriCurso.indBloqExte.label" );
      ((Element)v.get(1246)).appendChild((Element)v.get(1247));
      /* Termina nodo:1247   */
      /* Termina nodo:1246   */
      /* Termina nodo:1245   */

      /* Empieza nodo:1248 / Elemento padre: 1244   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1248)).setAttribute("nombre","indBloqExteWidgetTrId" );
      ((Element)v.get(1244)).appendChild((Element)v.get(1248));

      /* Empieza nodo:1249 / Elemento padre: 1248   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1249)).setAttribute("align","left" );
      ((Element)v.get(1249)).setAttribute("nowrap","true" );
   }

   private void getXML5670(Document doc) {
      ((Element)v.get(1248)).appendChild((Element)v.get(1249));

      /* Empieza nodo:1250 / Elemento padre: 1249   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(1250)).setAttribute("nombre","indBloqExte" );
      ((Element)v.get(1250)).setAttribute("id","datosCampos" );
      ((Element)v.get(1250)).setAttribute("trim","S" );
      ((Element)v.get(1250)).setAttribute("max","1" );
      ((Element)v.get(1250)).setAttribute("onchange","" );
      ((Element)v.get(1250)).setAttribute("req","N" );
      ((Element)v.get(1250)).setAttribute("size","1" );
      ((Element)v.get(1250)).setAttribute("valor","" );
      ((Element)v.get(1250)).setAttribute("validacion","" );
      ((Element)v.get(1250)).setAttribute("onblur","" );
      ((Element)v.get(1250)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true)" );
      ((Element)v.get(1250)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm', 0, false)" );
      ((Element)v.get(1249)).appendChild((Element)v.get(1250));
      /* Termina nodo:1250   */
      /* Termina nodo:1249   */
      /* Termina nodo:1248   */

      /* Empieza nodo:1251 / Elemento padre: 1244   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1251)).setAttribute("nombre","indBloqExteViewLabelTrId" );
      ((Element)v.get(1244)).appendChild((Element)v.get(1251));

      /* Empieza nodo:1252 / Elemento padre: 1251   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1252)).setAttribute("valign","top" );
      ((Element)v.get(1252)).setAttribute("height","13" );
      ((Element)v.get(1251)).appendChild((Element)v.get(1252));

      /* Empieza nodo:1253 / Elemento padre: 1252   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1253)).setAttribute("nombre","lblViewIndBloqExte" );
      ((Element)v.get(1253)).setAttribute("alto","13" );
      ((Element)v.get(1253)).setAttribute("ancho","100" );
      ((Element)v.get(1253)).setAttribute("id","EstDat" );
      ((Element)v.get(1253)).setAttribute("valor","" );
      ((Element)v.get(1252)).appendChild((Element)v.get(1253));
      /* Termina nodo:1253   */
      /* Termina nodo:1252   */
      /* Termina nodo:1251   */
      /* Termina nodo:1244   */
      /* Termina nodo:1243   */

      /* Empieza nodo:1254 / Elemento padre: 1242   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1254)).setAttribute("nombre","indBloqExteGapTdId" );
      ((Element)v.get(1254)).setAttribute("nowrap","true" );
      ((Element)v.get(1254)).setAttribute("class","datosCampos" );
      ((Element)v.get(1242)).appendChild((Element)v.get(1254));

      /* Empieza nodo:1255 / Elemento padre: 1254   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1255)).setAttribute("src","b.gif" );
      ((Element)v.get(1255)).setAttribute("width","25" );
      ((Element)v.get(1255)).setAttribute("height","8" );
      ((Element)v.get(1254)).appendChild((Element)v.get(1255));
      /* Termina nodo:1255   */
      /* Termina nodo:1254   */

      /* Empieza nodo:1256 / Elemento padre: 1242   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1256)).setAttribute("width","100%" );
      ((Element)v.get(1242)).appendChild((Element)v.get(1256));

      /* Empieza nodo:1257 / Elemento padre: 1256   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1257)).setAttribute("src","b.gif" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1257));
      /* Termina nodo:1257   */
      /* Termina nodo:1256   */
      /* Termina nodo:1242   */
      /* Termina nodo:1241   */
      /* Termina nodo:1240   */
      /* Termina nodo:1237   */

      /* Empieza nodo:1258 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1258)).setAttribute("nombre","formGapTr38" );
      ((Element)v.get(40)).appendChild((Element)v.get(1258));

      /* Empieza nodo:1259 / Elemento padre: 1258   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1259)).setAttribute("align","center" );
      ((Element)v.get(1259)).setAttribute("width","12" );
      ((Element)v.get(1258)).appendChild((Element)v.get(1259));

      /* Empieza nodo:1260 / Elemento padre: 1259   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1260)).setAttribute("src","b.gif" );
      ((Element)v.get(1260)).setAttribute("width","12" );
      ((Element)v.get(1260)).setAttribute("height","8" );
      ((Element)v.get(1259)).appendChild((Element)v.get(1260));
      /* Termina nodo:1260   */
      /* Termina nodo:1259   */

      /* Empieza nodo:1261 / Elemento padre: 1258   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1258)).appendChild((Element)v.get(1261));

      /* Empieza nodo:1262 / Elemento padre: 1261   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1262)).setAttribute("src","b.gif" );
      ((Element)v.get(1262)).setAttribute("width","8" );
      ((Element)v.get(1262)).setAttribute("height","8" );
      ((Element)v.get(1261)).appendChild((Element)v.get(1262));
      /* Termina nodo:1262   */
      /* Termina nodo:1261   */

      /* Empieza nodo:1263 / Elemento padre: 1258   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1263)).setAttribute("align","center" );
      ((Element)v.get(1263)).setAttribute("width","12" );
      ((Element)v.get(1258)).appendChild((Element)v.get(1263));

      /* Empieza nodo:1264 / Elemento padre: 1263   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1264)).setAttribute("src","b.gif" );
      ((Element)v.get(1264)).setAttribute("width","12" );
      ((Element)v.get(1264)).setAttribute("height","8" );
      ((Element)v.get(1263)).appendChild((Element)v.get(1264));
      /* Termina nodo:1264   */
      /* Termina nodo:1263   */
      /* Termina nodo:1258   */

      /* Empieza nodo:1265 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1265)).setAttribute("nombre","formTr39" );
      ((Element)v.get(40)).appendChild((Element)v.get(1265));

      /* Empieza nodo:1266 / Elemento padre: 1265   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1266)).setAttribute("align","center" );
      ((Element)v.get(1266)).setAttribute("width","12" );
      ((Element)v.get(1265)).appendChild((Element)v.get(1266));

      /* Empieza nodo:1267 / Elemento padre: 1266   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1267)).setAttribute("src","b.gif" );
      ((Element)v.get(1267)).setAttribute("width","12" );
      ((Element)v.get(1267)).setAttribute("height","12" );
      ((Element)v.get(1266)).appendChild((Element)v.get(1267));
      /* Termina nodo:1267   */
      /* Termina nodo:1266   */

      /* Empieza nodo:1268 / Elemento padre: 1265   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1268)).setAttribute("width","100%" );
      ((Element)v.get(1265)).appendChild((Element)v.get(1268));

      /* Empieza nodo:1269 / Elemento padre: 1268   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1269)).setAttribute("width","100%" );
   }

   private void getXML5760(Document doc) {
      ((Element)v.get(1269)).setAttribute("border","0" );
      ((Element)v.get(1269)).setAttribute("cellspacing","0" );
      ((Element)v.get(1269)).setAttribute("cellpadding","0" );
      ((Element)v.get(1269)).setAttribute("align","left" );
      ((Element)v.get(1268)).appendChild((Element)v.get(1269));

      /* Empieza nodo:1270 / Elemento padre: 1269   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1270)).setAttribute("align","left" );
      ((Element)v.get(1269)).appendChild((Element)v.get(1270));

      /* Empieza nodo:1271 / Elemento padre: 1270   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1271)).setAttribute("nombre","indMomeEntrTdId" );
      ((Element)v.get(1270)).appendChild((Element)v.get(1271));

      /* Empieza nodo:1272 / Elemento padre: 1271   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1272)).setAttribute("width","100%" );
      ((Element)v.get(1272)).setAttribute("border","0" );
      ((Element)v.get(1272)).setAttribute("cellspacing","0" );
      ((Element)v.get(1272)).setAttribute("cellpadding","0" );
      ((Element)v.get(1272)).setAttribute("align","left" );
      ((Element)v.get(1271)).appendChild((Element)v.get(1272));

      /* Empieza nodo:1273 / Elemento padre: 1272   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1272)).appendChild((Element)v.get(1273));

      /* Empieza nodo:1274 / Elemento padre: 1273   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1274)).setAttribute("valign","top" );
      ((Element)v.get(1274)).setAttribute("height","13" );
      ((Element)v.get(1273)).appendChild((Element)v.get(1274));

      /* Empieza nodo:1275 / Elemento padre: 1274   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1275)).setAttribute("nombre","lblIndMomeEntr" );
      ((Element)v.get(1275)).setAttribute("alto","13" );
      ((Element)v.get(1275)).setAttribute("filas","1" );
      ((Element)v.get(1275)).setAttribute("id","datosTitle" );
      ((Element)v.get(1275)).setAttribute("cod","EduMatriCurso.indMomeEntr.label" );
      ((Element)v.get(1274)).appendChild((Element)v.get(1275));
      /* Termina nodo:1275   */
      /* Termina nodo:1274   */
      /* Termina nodo:1273   */

      /* Empieza nodo:1276 / Elemento padre: 1272   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1276)).setAttribute("nombre","indMomeEntrWidgetTrId" );
      ((Element)v.get(1272)).appendChild((Element)v.get(1276));

      /* Empieza nodo:1277 / Elemento padre: 1276   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1277)).setAttribute("align","left" );
      ((Element)v.get(1277)).setAttribute("nowrap","true" );
      ((Element)v.get(1276)).appendChild((Element)v.get(1277));

      /* Empieza nodo:1278 / Elemento padre: 1277   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(1278)).setAttribute("nombre","indMomeEntr" );
      ((Element)v.get(1278)).setAttribute("id","datosCampos" );
      ((Element)v.get(1278)).setAttribute("trim","S" );
      ((Element)v.get(1278)).setAttribute("max","1" );
      ((Element)v.get(1278)).setAttribute("onchange","" );
      ((Element)v.get(1278)).setAttribute("req","N" );
      ((Element)v.get(1278)).setAttribute("size","1" );
      ((Element)v.get(1278)).setAttribute("valor","" );
      ((Element)v.get(1278)).setAttribute("validacion","" );
      ((Element)v.get(1278)).setAttribute("onblur","" );
      ((Element)v.get(1278)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true)" );
      ((Element)v.get(1278)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm', 0, false)" );
      ((Element)v.get(1277)).appendChild((Element)v.get(1278));
      /* Termina nodo:1278   */
      /* Termina nodo:1277   */
      /* Termina nodo:1276   */

      /* Empieza nodo:1279 / Elemento padre: 1272   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1279)).setAttribute("nombre","indMomeEntrViewLabelTrId" );
      ((Element)v.get(1272)).appendChild((Element)v.get(1279));

      /* Empieza nodo:1280 / Elemento padre: 1279   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1280)).setAttribute("valign","top" );
      ((Element)v.get(1280)).setAttribute("height","13" );
      ((Element)v.get(1279)).appendChild((Element)v.get(1280));

      /* Empieza nodo:1281 / Elemento padre: 1280   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1281)).setAttribute("nombre","lblViewIndMomeEntr" );
      ((Element)v.get(1281)).setAttribute("alto","13" );
      ((Element)v.get(1281)).setAttribute("ancho","100" );
      ((Element)v.get(1281)).setAttribute("id","EstDat" );
      ((Element)v.get(1281)).setAttribute("valor","" );
      ((Element)v.get(1280)).appendChild((Element)v.get(1281));
      /* Termina nodo:1281   */
      /* Termina nodo:1280   */
      /* Termina nodo:1279   */
      /* Termina nodo:1272   */
      /* Termina nodo:1271   */

      /* Empieza nodo:1282 / Elemento padre: 1270   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1282)).setAttribute("nombre","indMomeEntrGapTdId" );
      ((Element)v.get(1282)).setAttribute("nowrap","true" );
      ((Element)v.get(1282)).setAttribute("class","datosCampos" );
      ((Element)v.get(1270)).appendChild((Element)v.get(1282));

      /* Empieza nodo:1283 / Elemento padre: 1282   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1283)).setAttribute("src","b.gif" );
      ((Element)v.get(1283)).setAttribute("width","25" );
      ((Element)v.get(1283)).setAttribute("height","8" );
      ((Element)v.get(1282)).appendChild((Element)v.get(1283));
      /* Termina nodo:1283   */
      /* Termina nodo:1282   */

      /* Empieza nodo:1284 / Elemento padre: 1270   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1284)).setAttribute("width","100%" );
      ((Element)v.get(1270)).appendChild((Element)v.get(1284));

      /* Empieza nodo:1285 / Elemento padre: 1284   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1285)).setAttribute("src","b.gif" );
      ((Element)v.get(1284)).appendChild((Element)v.get(1285));
      /* Termina nodo:1285   */
      /* Termina nodo:1284   */
      /* Termina nodo:1270   */
      /* Termina nodo:1269   */
      /* Termina nodo:1268   */
      /* Termina nodo:1265   */

      /* Empieza nodo:1286 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1286)).setAttribute("nombre","formGapTr39" );
      ((Element)v.get(40)).appendChild((Element)v.get(1286));

      /* Empieza nodo:1287 / Elemento padre: 1286   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1287)).setAttribute("align","center" );
      ((Element)v.get(1287)).setAttribute("width","12" );
      ((Element)v.get(1286)).appendChild((Element)v.get(1287));

      /* Empieza nodo:1288 / Elemento padre: 1287   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML5850(Document doc) {
      ((Element)v.get(1288)).setAttribute("src","b.gif" );
      ((Element)v.get(1288)).setAttribute("width","12" );
      ((Element)v.get(1288)).setAttribute("height","8" );
      ((Element)v.get(1287)).appendChild((Element)v.get(1288));
      /* Termina nodo:1288   */
      /* Termina nodo:1287   */

      /* Empieza nodo:1289 / Elemento padre: 1286   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1286)).appendChild((Element)v.get(1289));

      /* Empieza nodo:1290 / Elemento padre: 1289   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1290)).setAttribute("src","b.gif" );
      ((Element)v.get(1290)).setAttribute("width","8" );
      ((Element)v.get(1290)).setAttribute("height","8" );
      ((Element)v.get(1289)).appendChild((Element)v.get(1290));
      /* Termina nodo:1290   */
      /* Termina nodo:1289   */

      /* Empieza nodo:1291 / Elemento padre: 1286   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1291)).setAttribute("align","center" );
      ((Element)v.get(1291)).setAttribute("width","12" );
      ((Element)v.get(1286)).appendChild((Element)v.get(1291));

      /* Empieza nodo:1292 / Elemento padre: 1291   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1292)).setAttribute("src","b.gif" );
      ((Element)v.get(1292)).setAttribute("width","12" );
      ((Element)v.get(1292)).setAttribute("height","8" );
      ((Element)v.get(1291)).appendChild((Element)v.get(1292));
      /* Termina nodo:1292   */
      /* Termina nodo:1291   */
      /* Termina nodo:1286   */

      /* Empieza nodo:1293 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1293)).setAttribute("nombre","formTr40" );
      ((Element)v.get(40)).appendChild((Element)v.get(1293));

      /* Empieza nodo:1294 / Elemento padre: 1293   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1294)).setAttribute("align","center" );
      ((Element)v.get(1294)).setAttribute("width","12" );
      ((Element)v.get(1293)).appendChild((Element)v.get(1294));

      /* Empieza nodo:1295 / Elemento padre: 1294   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1295)).setAttribute("src","b.gif" );
      ((Element)v.get(1295)).setAttribute("width","12" );
      ((Element)v.get(1295)).setAttribute("height","12" );
      ((Element)v.get(1294)).appendChild((Element)v.get(1295));
      /* Termina nodo:1295   */
      /* Termina nodo:1294   */

      /* Empieza nodo:1296 / Elemento padre: 1293   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1296)).setAttribute("width","100%" );
      ((Element)v.get(1293)).appendChild((Element)v.get(1296));

      /* Empieza nodo:1297 / Elemento padre: 1296   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1297)).setAttribute("width","100%" );
      ((Element)v.get(1297)).setAttribute("border","0" );
      ((Element)v.get(1297)).setAttribute("cellspacing","0" );
      ((Element)v.get(1297)).setAttribute("cellpadding","0" );
      ((Element)v.get(1297)).setAttribute("align","left" );
      ((Element)v.get(1296)).appendChild((Element)v.get(1297));

      /* Empieza nodo:1298 / Elemento padre: 1297   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1298)).setAttribute("align","left" );
      ((Element)v.get(1297)).appendChild((Element)v.get(1298));

      /* Empieza nodo:1299 / Elemento padre: 1298   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1299)).setAttribute("nombre","indCondPediTdId" );
      ((Element)v.get(1298)).appendChild((Element)v.get(1299));

      /* Empieza nodo:1300 / Elemento padre: 1299   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1300)).setAttribute("width","100%" );
      ((Element)v.get(1300)).setAttribute("border","0" );
      ((Element)v.get(1300)).setAttribute("cellspacing","0" );
      ((Element)v.get(1300)).setAttribute("cellpadding","0" );
      ((Element)v.get(1300)).setAttribute("align","left" );
      ((Element)v.get(1299)).appendChild((Element)v.get(1300));

      /* Empieza nodo:1301 / Elemento padre: 1300   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1300)).appendChild((Element)v.get(1301));

      /* Empieza nodo:1302 / Elemento padre: 1301   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1302)).setAttribute("valign","top" );
      ((Element)v.get(1302)).setAttribute("height","13" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1302));

      /* Empieza nodo:1303 / Elemento padre: 1302   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1303)).setAttribute("nombre","lblIndCondPedi" );
      ((Element)v.get(1303)).setAttribute("alto","13" );
      ((Element)v.get(1303)).setAttribute("filas","1" );
      ((Element)v.get(1303)).setAttribute("id","datosTitle" );
      ((Element)v.get(1303)).setAttribute("cod","EduMatriCurso.indCondPedi.label" );
      ((Element)v.get(1302)).appendChild((Element)v.get(1303));
      /* Termina nodo:1303   */
      /* Termina nodo:1302   */
      /* Termina nodo:1301   */

      /* Empieza nodo:1304 / Elemento padre: 1300   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1304)).setAttribute("nombre","indCondPediWidgetTrId" );
      ((Element)v.get(1300)).appendChild((Element)v.get(1304));

      /* Empieza nodo:1305 / Elemento padre: 1304   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1305)).setAttribute("align","left" );
      ((Element)v.get(1305)).setAttribute("nowrap","true" );
      ((Element)v.get(1304)).appendChild((Element)v.get(1305));

      /* Empieza nodo:1306 / Elemento padre: 1305   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(1306)).setAttribute("nombre","indCondPedi" );
      ((Element)v.get(1306)).setAttribute("id","datosCampos" );
      ((Element)v.get(1306)).setAttribute("trim","S" );
      ((Element)v.get(1306)).setAttribute("max","1" );
      ((Element)v.get(1306)).setAttribute("onchange","" );
      ((Element)v.get(1306)).setAttribute("req","N" );
      ((Element)v.get(1306)).setAttribute("size","1" );
      ((Element)v.get(1306)).setAttribute("valor","" );
      ((Element)v.get(1306)).setAttribute("validacion","" );
      ((Element)v.get(1306)).setAttribute("onblur","" );
      ((Element)v.get(1306)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true)" );
      ((Element)v.get(1306)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm', 0, false)" );
      ((Element)v.get(1305)).appendChild((Element)v.get(1306));
      /* Termina nodo:1306   */
      /* Termina nodo:1305   */
      /* Termina nodo:1304   */

      /* Empieza nodo:1307 / Elemento padre: 1300   */
      v.add(doc.createElement("TR"));
   }

   private void getXML5940(Document doc) {
      ((Element)v.get(1307)).setAttribute("nombre","indCondPediViewLabelTrId" );
      ((Element)v.get(1300)).appendChild((Element)v.get(1307));

      /* Empieza nodo:1308 / Elemento padre: 1307   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1308)).setAttribute("valign","top" );
      ((Element)v.get(1308)).setAttribute("height","13" );
      ((Element)v.get(1307)).appendChild((Element)v.get(1308));

      /* Empieza nodo:1309 / Elemento padre: 1308   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1309)).setAttribute("nombre","lblViewIndCondPedi" );
      ((Element)v.get(1309)).setAttribute("alto","13" );
      ((Element)v.get(1309)).setAttribute("ancho","100" );
      ((Element)v.get(1309)).setAttribute("id","EstDat" );
      ((Element)v.get(1309)).setAttribute("valor","" );
      ((Element)v.get(1308)).appendChild((Element)v.get(1309));
      /* Termina nodo:1309   */
      /* Termina nodo:1308   */
      /* Termina nodo:1307   */
      /* Termina nodo:1300   */
      /* Termina nodo:1299   */

      /* Empieza nodo:1310 / Elemento padre: 1298   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1310)).setAttribute("nombre","indCondPediGapTdId" );
      ((Element)v.get(1310)).setAttribute("nowrap","true" );
      ((Element)v.get(1310)).setAttribute("class","datosCampos" );
      ((Element)v.get(1298)).appendChild((Element)v.get(1310));

      /* Empieza nodo:1311 / Elemento padre: 1310   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1311)).setAttribute("src","b.gif" );
      ((Element)v.get(1311)).setAttribute("width","25" );
      ((Element)v.get(1311)).setAttribute("height","8" );
      ((Element)v.get(1310)).appendChild((Element)v.get(1311));
      /* Termina nodo:1311   */
      /* Termina nodo:1310   */

      /* Empieza nodo:1312 / Elemento padre: 1298   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1312)).setAttribute("width","100%" );
      ((Element)v.get(1298)).appendChild((Element)v.get(1312));

      /* Empieza nodo:1313 / Elemento padre: 1312   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1313)).setAttribute("src","b.gif" );
      ((Element)v.get(1312)).appendChild((Element)v.get(1313));
      /* Termina nodo:1313   */
      /* Termina nodo:1312   */
      /* Termina nodo:1298   */
      /* Termina nodo:1297   */
      /* Termina nodo:1296   */
      /* Termina nodo:1293   */

      /* Empieza nodo:1314 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1314)).setAttribute("nombre","formGapTr40" );
      ((Element)v.get(40)).appendChild((Element)v.get(1314));

      /* Empieza nodo:1315 / Elemento padre: 1314   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1315)).setAttribute("align","center" );
      ((Element)v.get(1315)).setAttribute("width","12" );
      ((Element)v.get(1314)).appendChild((Element)v.get(1315));

      /* Empieza nodo:1316 / Elemento padre: 1315   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1316)).setAttribute("src","b.gif" );
      ((Element)v.get(1316)).setAttribute("width","12" );
      ((Element)v.get(1316)).setAttribute("height","8" );
      ((Element)v.get(1315)).appendChild((Element)v.get(1316));
      /* Termina nodo:1316   */
      /* Termina nodo:1315   */

      /* Empieza nodo:1317 / Elemento padre: 1314   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1314)).appendChild((Element)v.get(1317));

      /* Empieza nodo:1318 / Elemento padre: 1317   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1318)).setAttribute("src","b.gif" );
      ((Element)v.get(1318)).setAttribute("width","8" );
      ((Element)v.get(1318)).setAttribute("height","8" );
      ((Element)v.get(1317)).appendChild((Element)v.get(1318));
      /* Termina nodo:1318   */
      /* Termina nodo:1317   */

      /* Empieza nodo:1319 / Elemento padre: 1314   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1319)).setAttribute("align","center" );
      ((Element)v.get(1319)).setAttribute("width","12" );
      ((Element)v.get(1314)).appendChild((Element)v.get(1319));

      /* Empieza nodo:1320 / Elemento padre: 1319   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1320)).setAttribute("src","b.gif" );
      ((Element)v.get(1320)).setAttribute("width","12" );
      ((Element)v.get(1320)).setAttribute("height","8" );
      ((Element)v.get(1319)).appendChild((Element)v.get(1320));
      /* Termina nodo:1320   */
      /* Termina nodo:1319   */
      /* Termina nodo:1314   */

      /* Empieza nodo:1321 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1321)).setAttribute("nombre","formTr41" );
      ((Element)v.get(40)).appendChild((Element)v.get(1321));

      /* Empieza nodo:1322 / Elemento padre: 1321   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1322)).setAttribute("align","center" );
      ((Element)v.get(1322)).setAttribute("width","12" );
      ((Element)v.get(1321)).appendChild((Element)v.get(1322));

      /* Empieza nodo:1323 / Elemento padre: 1322   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1323)).setAttribute("src","b.gif" );
      ((Element)v.get(1323)).setAttribute("width","12" );
      ((Element)v.get(1323)).setAttribute("height","12" );
      ((Element)v.get(1322)).appendChild((Element)v.get(1323));
      /* Termina nodo:1323   */
      /* Termina nodo:1322   */

      /* Empieza nodo:1324 / Elemento padre: 1321   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1324)).setAttribute("width","100%" );
      ((Element)v.get(1321)).appendChild((Element)v.get(1324));

      /* Empieza nodo:1325 / Elemento padre: 1324   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1325)).setAttribute("width","100%" );
      ((Element)v.get(1325)).setAttribute("border","0" );
      ((Element)v.get(1325)).setAttribute("cellspacing","0" );
      ((Element)v.get(1325)).setAttribute("cellpadding","0" );
      ((Element)v.get(1325)).setAttribute("align","left" );
      ((Element)v.get(1324)).appendChild((Element)v.get(1325));

      /* Empieza nodo:1326 / Elemento padre: 1325   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1326)).setAttribute("align","left" );
      ((Element)v.get(1325)).appendChild((Element)v.get(1326));

      /* Empieza nodo:1327 / Elemento padre: 1326   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1327)).setAttribute("nombre","indCtrlMoroTdId" );
      ((Element)v.get(1326)).appendChild((Element)v.get(1327));

      /* Empieza nodo:1328 / Elemento padre: 1327   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1328)).setAttribute("width","100%" );
      ((Element)v.get(1328)).setAttribute("border","0" );
      ((Element)v.get(1328)).setAttribute("cellspacing","0" );
      ((Element)v.get(1328)).setAttribute("cellpadding","0" );
   }

   private void getXML6030(Document doc) {
      ((Element)v.get(1328)).setAttribute("align","left" );
      ((Element)v.get(1327)).appendChild((Element)v.get(1328));

      /* Empieza nodo:1329 / Elemento padre: 1328   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1328)).appendChild((Element)v.get(1329));

      /* Empieza nodo:1330 / Elemento padre: 1329   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1330)).setAttribute("valign","top" );
      ((Element)v.get(1330)).setAttribute("height","13" );
      ((Element)v.get(1329)).appendChild((Element)v.get(1330));

      /* Empieza nodo:1331 / Elemento padre: 1330   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1331)).setAttribute("nombre","lblIndCtrlMoro" );
      ((Element)v.get(1331)).setAttribute("alto","13" );
      ((Element)v.get(1331)).setAttribute("filas","1" );
      ((Element)v.get(1331)).setAttribute("id","datosTitle" );
      ((Element)v.get(1331)).setAttribute("cod","EduMatriCurso.indCtrlMoro.label" );
      ((Element)v.get(1330)).appendChild((Element)v.get(1331));
      /* Termina nodo:1331   */
      /* Termina nodo:1330   */
      /* Termina nodo:1329   */

      /* Empieza nodo:1332 / Elemento padre: 1328   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1332)).setAttribute("nombre","indCtrlMoroWidgetTrId" );
      ((Element)v.get(1328)).appendChild((Element)v.get(1332));

      /* Empieza nodo:1333 / Elemento padre: 1332   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1333)).setAttribute("align","left" );
      ((Element)v.get(1333)).setAttribute("nowrap","true" );
      ((Element)v.get(1332)).appendChild((Element)v.get(1333));

      /* Empieza nodo:1334 / Elemento padre: 1333   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(1334)).setAttribute("nombre","indCtrlMoro" );
      ((Element)v.get(1334)).setAttribute("id","datosCampos" );
      ((Element)v.get(1334)).setAttribute("trim","S" );
      ((Element)v.get(1334)).setAttribute("max","1" );
      ((Element)v.get(1334)).setAttribute("onchange","" );
      ((Element)v.get(1334)).setAttribute("req","N" );
      ((Element)v.get(1334)).setAttribute("size","1" );
      ((Element)v.get(1334)).setAttribute("valor","" );
      ((Element)v.get(1334)).setAttribute("validacion","" );
      ((Element)v.get(1334)).setAttribute("onblur","" );
      ((Element)v.get(1334)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true)" );
      ((Element)v.get(1334)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm', 0, false)" );
      ((Element)v.get(1333)).appendChild((Element)v.get(1334));
      /* Termina nodo:1334   */
      /* Termina nodo:1333   */
      /* Termina nodo:1332   */

      /* Empieza nodo:1335 / Elemento padre: 1328   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1335)).setAttribute("nombre","indCtrlMoroViewLabelTrId" );
      ((Element)v.get(1328)).appendChild((Element)v.get(1335));

      /* Empieza nodo:1336 / Elemento padre: 1335   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1336)).setAttribute("valign","top" );
      ((Element)v.get(1336)).setAttribute("height","13" );
      ((Element)v.get(1335)).appendChild((Element)v.get(1336));

      /* Empieza nodo:1337 / Elemento padre: 1336   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1337)).setAttribute("nombre","lblViewIndCtrlMoro" );
      ((Element)v.get(1337)).setAttribute("alto","13" );
      ((Element)v.get(1337)).setAttribute("ancho","100" );
      ((Element)v.get(1337)).setAttribute("id","EstDat" );
      ((Element)v.get(1337)).setAttribute("valor","" );
      ((Element)v.get(1336)).appendChild((Element)v.get(1337));
      /* Termina nodo:1337   */
      /* Termina nodo:1336   */
      /* Termina nodo:1335   */
      /* Termina nodo:1328   */
      /* Termina nodo:1327   */

      /* Empieza nodo:1338 / Elemento padre: 1326   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1338)).setAttribute("nombre","indCtrlMoroGapTdId" );
      ((Element)v.get(1338)).setAttribute("nowrap","true" );
      ((Element)v.get(1338)).setAttribute("class","datosCampos" );
      ((Element)v.get(1326)).appendChild((Element)v.get(1338));

      /* Empieza nodo:1339 / Elemento padre: 1338   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1339)).setAttribute("src","b.gif" );
      ((Element)v.get(1339)).setAttribute("width","25" );
      ((Element)v.get(1339)).setAttribute("height","8" );
      ((Element)v.get(1338)).appendChild((Element)v.get(1339));
      /* Termina nodo:1339   */
      /* Termina nodo:1338   */

      /* Empieza nodo:1340 / Elemento padre: 1326   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1340)).setAttribute("width","100%" );
      ((Element)v.get(1326)).appendChild((Element)v.get(1340));

      /* Empieza nodo:1341 / Elemento padre: 1340   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1341)).setAttribute("src","b.gif" );
      ((Element)v.get(1340)).appendChild((Element)v.get(1341));
      /* Termina nodo:1341   */
      /* Termina nodo:1340   */
      /* Termina nodo:1326   */
      /* Termina nodo:1325   */
      /* Termina nodo:1324   */
      /* Termina nodo:1321   */

      /* Empieza nodo:1342 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1342)).setAttribute("nombre","formGapTr41" );
      ((Element)v.get(40)).appendChild((Element)v.get(1342));

      /* Empieza nodo:1343 / Elemento padre: 1342   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1343)).setAttribute("align","center" );
      ((Element)v.get(1343)).setAttribute("width","12" );
      ((Element)v.get(1342)).appendChild((Element)v.get(1343));

      /* Empieza nodo:1344 / Elemento padre: 1343   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1344)).setAttribute("src","b.gif" );
      ((Element)v.get(1344)).setAttribute("width","12" );
      ((Element)v.get(1344)).setAttribute("height","8" );
      ((Element)v.get(1343)).appendChild((Element)v.get(1344));
      /* Termina nodo:1344   */
      /* Termina nodo:1343   */

      /* Empieza nodo:1345 / Elemento padre: 1342   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1342)).appendChild((Element)v.get(1345));

      /* Empieza nodo:1346 / Elemento padre: 1345   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1346)).setAttribute("src","b.gif" );
      ((Element)v.get(1346)).setAttribute("width","8" );
      ((Element)v.get(1346)).setAttribute("height","8" );
      ((Element)v.get(1345)).appendChild((Element)v.get(1346));
      /* Termina nodo:1346   */
      /* Termina nodo:1345   */

      /* Empieza nodo:1347 / Elemento padre: 1342   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1347)).setAttribute("align","center" );
      ((Element)v.get(1347)).setAttribute("width","12" );
      ((Element)v.get(1342)).appendChild((Element)v.get(1347));

      /* Empieza nodo:1348 / Elemento padre: 1347   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML6120(Document doc) {
      ((Element)v.get(1348)).setAttribute("src","b.gif" );
      ((Element)v.get(1348)).setAttribute("width","12" );
      ((Element)v.get(1348)).setAttribute("height","8" );
      ((Element)v.get(1347)).appendChild((Element)v.get(1348));
      /* Termina nodo:1348   */
      /* Termina nodo:1347   */
      /* Termina nodo:1342   */

      /* Empieza nodo:1349 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1349)).setAttribute("nombre","formTr42" );
      ((Element)v.get(40)).appendChild((Element)v.get(1349));

      /* Empieza nodo:1350 / Elemento padre: 1349   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1350)).setAttribute("align","center" );
      ((Element)v.get(1350)).setAttribute("width","12" );
      ((Element)v.get(1349)).appendChild((Element)v.get(1350));

      /* Empieza nodo:1351 / Elemento padre: 1350   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1351)).setAttribute("src","b.gif" );
      ((Element)v.get(1351)).setAttribute("width","12" );
      ((Element)v.get(1351)).setAttribute("height","12" );
      ((Element)v.get(1350)).appendChild((Element)v.get(1351));
      /* Termina nodo:1351   */
      /* Termina nodo:1350   */

      /* Empieza nodo:1352 / Elemento padre: 1349   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1352)).setAttribute("width","100%" );
      ((Element)v.get(1349)).appendChild((Element)v.get(1352));

      /* Empieza nodo:1353 / Elemento padre: 1352   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1353)).setAttribute("width","100%" );
      ((Element)v.get(1353)).setAttribute("border","0" );
      ((Element)v.get(1353)).setAttribute("cellspacing","0" );
      ((Element)v.get(1353)).setAttribute("cellpadding","0" );
      ((Element)v.get(1353)).setAttribute("align","left" );
      ((Element)v.get(1352)).appendChild((Element)v.get(1353));

      /* Empieza nodo:1354 / Elemento padre: 1353   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1354)).setAttribute("align","left" );
      ((Element)v.get(1353)).appendChild((Element)v.get(1354));

      /* Empieza nodo:1355 / Elemento padre: 1354   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1355)).setAttribute("nombre","indCtrlFuncTdId" );
      ((Element)v.get(1354)).appendChild((Element)v.get(1355));

      /* Empieza nodo:1356 / Elemento padre: 1355   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1356)).setAttribute("width","100%" );
      ((Element)v.get(1356)).setAttribute("border","0" );
      ((Element)v.get(1356)).setAttribute("cellspacing","0" );
      ((Element)v.get(1356)).setAttribute("cellpadding","0" );
      ((Element)v.get(1356)).setAttribute("align","left" );
      ((Element)v.get(1355)).appendChild((Element)v.get(1356));

      /* Empieza nodo:1357 / Elemento padre: 1356   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1356)).appendChild((Element)v.get(1357));

      /* Empieza nodo:1358 / Elemento padre: 1357   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1358)).setAttribute("valign","top" );
      ((Element)v.get(1358)).setAttribute("height","13" );
      ((Element)v.get(1357)).appendChild((Element)v.get(1358));

      /* Empieza nodo:1359 / Elemento padre: 1358   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1359)).setAttribute("nombre","lblIndCtrlFunc" );
      ((Element)v.get(1359)).setAttribute("alto","13" );
      ((Element)v.get(1359)).setAttribute("filas","1" );
      ((Element)v.get(1359)).setAttribute("id","datosTitle" );
      ((Element)v.get(1359)).setAttribute("cod","EduMatriCurso.indCtrlFunc.label" );
      ((Element)v.get(1358)).appendChild((Element)v.get(1359));
      /* Termina nodo:1359   */
      /* Termina nodo:1358   */
      /* Termina nodo:1357   */

      /* Empieza nodo:1360 / Elemento padre: 1356   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1360)).setAttribute("nombre","indCtrlFuncWidgetTrId" );
      ((Element)v.get(1356)).appendChild((Element)v.get(1360));

      /* Empieza nodo:1361 / Elemento padre: 1360   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1361)).setAttribute("align","left" );
      ((Element)v.get(1361)).setAttribute("nowrap","true" );
      ((Element)v.get(1360)).appendChild((Element)v.get(1361));

      /* Empieza nodo:1362 / Elemento padre: 1361   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(1362)).setAttribute("nombre","indCtrlFunc" );
      ((Element)v.get(1362)).setAttribute("id","datosCampos" );
      ((Element)v.get(1362)).setAttribute("trim","S" );
      ((Element)v.get(1362)).setAttribute("max","1" );
      ((Element)v.get(1362)).setAttribute("onchange","" );
      ((Element)v.get(1362)).setAttribute("req","N" );
      ((Element)v.get(1362)).setAttribute("size","1" );
      ((Element)v.get(1362)).setAttribute("valor","" );
      ((Element)v.get(1362)).setAttribute("validacion","" );
      ((Element)v.get(1362)).setAttribute("onblur","" );
      ((Element)v.get(1362)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true)" );
      ((Element)v.get(1362)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm', 0, false)" );
      ((Element)v.get(1361)).appendChild((Element)v.get(1362));
      /* Termina nodo:1362   */
      /* Termina nodo:1361   */
      /* Termina nodo:1360   */

      /* Empieza nodo:1363 / Elemento padre: 1356   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1363)).setAttribute("nombre","indCtrlFuncViewLabelTrId" );
      ((Element)v.get(1356)).appendChild((Element)v.get(1363));

      /* Empieza nodo:1364 / Elemento padre: 1363   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1364)).setAttribute("valign","top" );
      ((Element)v.get(1364)).setAttribute("height","13" );
      ((Element)v.get(1363)).appendChild((Element)v.get(1364));

      /* Empieza nodo:1365 / Elemento padre: 1364   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1365)).setAttribute("nombre","lblViewIndCtrlFunc" );
      ((Element)v.get(1365)).setAttribute("alto","13" );
      ((Element)v.get(1365)).setAttribute("ancho","100" );
      ((Element)v.get(1365)).setAttribute("id","EstDat" );
      ((Element)v.get(1365)).setAttribute("valor","" );
      ((Element)v.get(1364)).appendChild((Element)v.get(1365));
      /* Termina nodo:1365   */
      /* Termina nodo:1364   */
      /* Termina nodo:1363   */
      /* Termina nodo:1356   */
      /* Termina nodo:1355   */

      /* Empieza nodo:1366 / Elemento padre: 1354   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1366)).setAttribute("nombre","indCtrlFuncGapTdId" );
      ((Element)v.get(1366)).setAttribute("nowrap","true" );
   }

   private void getXML6210(Document doc) {
      ((Element)v.get(1366)).setAttribute("class","datosCampos" );
      ((Element)v.get(1354)).appendChild((Element)v.get(1366));

      /* Empieza nodo:1367 / Elemento padre: 1366   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1367)).setAttribute("src","b.gif" );
      ((Element)v.get(1367)).setAttribute("width","25" );
      ((Element)v.get(1367)).setAttribute("height","8" );
      ((Element)v.get(1366)).appendChild((Element)v.get(1367));
      /* Termina nodo:1367   */
      /* Termina nodo:1366   */

      /* Empieza nodo:1368 / Elemento padre: 1354   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1368)).setAttribute("width","100%" );
      ((Element)v.get(1354)).appendChild((Element)v.get(1368));

      /* Empieza nodo:1369 / Elemento padre: 1368   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1369)).setAttribute("src","b.gif" );
      ((Element)v.get(1368)).appendChild((Element)v.get(1369));
      /* Termina nodo:1369   */
      /* Termina nodo:1368   */
      /* Termina nodo:1354   */
      /* Termina nodo:1353   */
      /* Termina nodo:1352   */
      /* Termina nodo:1349   */

      /* Empieza nodo:1370 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1370)).setAttribute("nombre","formGapTr42" );
      ((Element)v.get(40)).appendChild((Element)v.get(1370));

      /* Empieza nodo:1371 / Elemento padre: 1370   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1371)).setAttribute("align","center" );
      ((Element)v.get(1371)).setAttribute("width","12" );
      ((Element)v.get(1370)).appendChild((Element)v.get(1371));

      /* Empieza nodo:1372 / Elemento padre: 1371   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1372)).setAttribute("src","b.gif" );
      ((Element)v.get(1372)).setAttribute("width","12" );
      ((Element)v.get(1372)).setAttribute("height","8" );
      ((Element)v.get(1371)).appendChild((Element)v.get(1372));
      /* Termina nodo:1372   */
      /* Termina nodo:1371   */

      /* Empieza nodo:1373 / Elemento padre: 1370   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1370)).appendChild((Element)v.get(1373));

      /* Empieza nodo:1374 / Elemento padre: 1373   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1374)).setAttribute("src","b.gif" );
      ((Element)v.get(1374)).setAttribute("width","8" );
      ((Element)v.get(1374)).setAttribute("height","8" );
      ((Element)v.get(1373)).appendChild((Element)v.get(1374));
      /* Termina nodo:1374   */
      /* Termina nodo:1373   */

      /* Empieza nodo:1375 / Elemento padre: 1370   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1375)).setAttribute("align","center" );
      ((Element)v.get(1375)).setAttribute("width","12" );
      ((Element)v.get(1370)).appendChild((Element)v.get(1375));

      /* Empieza nodo:1376 / Elemento padre: 1375   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1376)).setAttribute("src","b.gif" );
      ((Element)v.get(1376)).setAttribute("width","12" );
      ((Element)v.get(1376)).setAttribute("height","8" );
      ((Element)v.get(1375)).appendChild((Element)v.get(1376));
      /* Termina nodo:1376   */
      /* Termina nodo:1375   */
      /* Termina nodo:1370   */

      /* Empieza nodo:1377 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1377)).setAttribute("nombre","formTr43" );
      ((Element)v.get(40)).appendChild((Element)v.get(1377));

      /* Empieza nodo:1378 / Elemento padre: 1377   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1378)).setAttribute("align","center" );
      ((Element)v.get(1378)).setAttribute("width","12" );
      ((Element)v.get(1377)).appendChild((Element)v.get(1378));

      /* Empieza nodo:1379 / Elemento padre: 1378   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1379)).setAttribute("src","b.gif" );
      ((Element)v.get(1379)).setAttribute("width","12" );
      ((Element)v.get(1379)).setAttribute("height","12" );
      ((Element)v.get(1378)).appendChild((Element)v.get(1379));
      /* Termina nodo:1379   */
      /* Termina nodo:1378   */

      /* Empieza nodo:1380 / Elemento padre: 1377   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1380)).setAttribute("width","100%" );
      ((Element)v.get(1377)).appendChild((Element)v.get(1380));

      /* Empieza nodo:1381 / Elemento padre: 1380   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1381)).setAttribute("width","100%" );
      ((Element)v.get(1381)).setAttribute("border","0" );
      ((Element)v.get(1381)).setAttribute("cellspacing","0" );
      ((Element)v.get(1381)).setAttribute("cellpadding","0" );
      ((Element)v.get(1381)).setAttribute("align","left" );
      ((Element)v.get(1380)).appendChild((Element)v.get(1381));

      /* Empieza nodo:1382 / Elemento padre: 1381   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1382)).setAttribute("align","left" );
      ((Element)v.get(1381)).appendChild((Element)v.get(1382));

      /* Empieza nodo:1383 / Elemento padre: 1382   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1383)).setAttribute("nombre","clclOidClieClasCapaTdId" );
      ((Element)v.get(1382)).appendChild((Element)v.get(1383));

      /* Empieza nodo:1384 / Elemento padre: 1383   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1384)).setAttribute("border","0" );
      ((Element)v.get(1384)).setAttribute("cellspacing","0" );
      ((Element)v.get(1384)).setAttribute("cellpadding","0" );
      ((Element)v.get(1384)).setAttribute("align","left" );
      ((Element)v.get(1383)).appendChild((Element)v.get(1384));

      /* Empieza nodo:1385 / Elemento padre: 1384   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1384)).appendChild((Element)v.get(1385));

      /* Empieza nodo:1386 / Elemento padre: 1385   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1386)).setAttribute("valign","top" );
      ((Element)v.get(1386)).setAttribute("height","13" );
      ((Element)v.get(1385)).appendChild((Element)v.get(1386));

      /* Empieza nodo:1387 / Elemento padre: 1386   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1387)).setAttribute("nombre","lblclclOidClieClasCapa" );
      ((Element)v.get(1387)).setAttribute("id","datosTitle" );
      ((Element)v.get(1387)).setAttribute("ancho","100" );
      ((Element)v.get(1387)).setAttribute("alto","13" );
      ((Element)v.get(1387)).setAttribute("cod","EduMatriCurso.clclOidClieClasCapa.label" );
      ((Element)v.get(1386)).appendChild((Element)v.get(1387));
      /* Termina nodo:1387   */
      /* Termina nodo:1386   */
      /* Termina nodo:1385   */

      /* Empieza nodo:1388 / Elemento padre: 1384   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1388)).setAttribute("nombre","clclOidClieClasCapaWidgetTrId" );
   }

   private void getXML6300(Document doc) {
      ((Element)v.get(1384)).appendChild((Element)v.get(1388));

      /* Empieza nodo:1389 / Elemento padre: 1388   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1389)).setAttribute("align","left" );
      ((Element)v.get(1389)).setAttribute("nowrap","true" );
      ((Element)v.get(1388)).appendChild((Element)v.get(1389));

      /* Empieza nodo:1390 / Elemento padre: 1389   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(1390)).setAttribute("nombre","clclOidClieClasCapa" );
      ((Element)v.get(1390)).setAttribute("id","datosCampos" );
      ((Element)v.get(1390)).setAttribute("multiple","N" );
      ((Element)v.get(1390)).setAttribute("req","N" );
      ((Element)v.get(1390)).setAttribute("size","1" );
      ((Element)v.get(1390)).setAttribute("validacion","" );
      ((Element)v.get(1390)).setAttribute("onchange","" );
      ((Element)v.get(1390)).setAttribute("onfocus","" );
      ((Element)v.get(1390)).setAttribute("valorinicial","" );
      ((Element)v.get(1390)).setAttribute("textoinicial","" );
      ((Element)v.get(1390)).setAttribute("ontab","ejecutarAccionFoco('eduMatriCursoFrm',0, true);" );
      ((Element)v.get(1390)).setAttribute("onshtab","ejecutarAccionFoco('eduMatriCursoFrm',0, false);" );
      ((Element)v.get(1389)).appendChild((Element)v.get(1390));

      /* Empieza nodo:1391 / Elemento padre: 1390   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(1390)).appendChild((Element)v.get(1391));
      /* Termina nodo:1391   */
      /* Termina nodo:1390   */
      /* Termina nodo:1389   */
      /* Termina nodo:1388   */

      /* Empieza nodo:1392 / Elemento padre: 1384   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1392)).setAttribute("nombre","clclOidClieClasCapaViewLabelTrId" );
      ((Element)v.get(1384)).appendChild((Element)v.get(1392));

      /* Empieza nodo:1393 / Elemento padre: 1392   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1393)).setAttribute("valign","top" );
      ((Element)v.get(1393)).setAttribute("height","13" );
      ((Element)v.get(1393)).setAttribute("width","50" );
      ((Element)v.get(1392)).appendChild((Element)v.get(1393));

      /* Empieza nodo:1394 / Elemento padre: 1393   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1394)).setAttribute("nombre","lblViewClclOidClieClasCapa" );
      ((Element)v.get(1394)).setAttribute("alto","13" );
      ((Element)v.get(1394)).setAttribute("filas","1" );
      ((Element)v.get(1394)).setAttribute("id","EstDat" );
      ((Element)v.get(1394)).setAttribute("valor","" );
      ((Element)v.get(1393)).appendChild((Element)v.get(1394));
      /* Termina nodo:1394   */
      /* Termina nodo:1393   */
      /* Termina nodo:1392   */
      /* Termina nodo:1384   */
      /* Termina nodo:1383   */

      /* Empieza nodo:1395 / Elemento padre: 1382   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1395)).setAttribute("nombre","clclOidClieClasCapaGapTdId" );
      ((Element)v.get(1395)).setAttribute("nowrap","true" );
      ((Element)v.get(1395)).setAttribute("class","datosCampos" );
      ((Element)v.get(1382)).appendChild((Element)v.get(1395));

      /* Empieza nodo:1396 / Elemento padre: 1395   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1396)).setAttribute("src","b.gif" );
      ((Element)v.get(1396)).setAttribute("width","25" );
      ((Element)v.get(1396)).setAttribute("height","8" );
      ((Element)v.get(1395)).appendChild((Element)v.get(1396));
      /* Termina nodo:1396   */
      /* Termina nodo:1395   */

      /* Empieza nodo:1397 / Elemento padre: 1382   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1397)).setAttribute("width","100%" );
      ((Element)v.get(1382)).appendChild((Element)v.get(1397));

      /* Empieza nodo:1398 / Elemento padre: 1397   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1398)).setAttribute("src","b.gif" );
      ((Element)v.get(1397)).appendChild((Element)v.get(1398));
      /* Termina nodo:1398   */
      /* Termina nodo:1397   */
      /* Termina nodo:1382   */
      /* Termina nodo:1381   */
      /* Termina nodo:1380   */

      /* Empieza nodo:1399 / Elemento padre: 1377   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1399)).setAttribute("width","100%" );
      ((Element)v.get(1377)).appendChild((Element)v.get(1399));
      /* Termina nodo:1399   */
      /* Termina nodo:1377   */

      /* Empieza nodo:1400 / Elemento padre: 40   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1400)).setAttribute("nombre","formGapTr43" );
      ((Element)v.get(40)).appendChild((Element)v.get(1400));

      /* Empieza nodo:1401 / Elemento padre: 1400   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1401)).setAttribute("align","center" );
      ((Element)v.get(1401)).setAttribute("width","12" );
      ((Element)v.get(1400)).appendChild((Element)v.get(1401));

      /* Empieza nodo:1402 / Elemento padre: 1401   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1402)).setAttribute("src","b.gif" );
      ((Element)v.get(1402)).setAttribute("width","12" );
      ((Element)v.get(1402)).setAttribute("height","8" );
      ((Element)v.get(1401)).appendChild((Element)v.get(1402));
      /* Termina nodo:1402   */
      /* Termina nodo:1401   */

      /* Empieza nodo:1403 / Elemento padre: 1400   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1400)).appendChild((Element)v.get(1403));

      /* Empieza nodo:1404 / Elemento padre: 1403   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1404)).setAttribute("src","b.gif" );
      ((Element)v.get(1404)).setAttribute("width","8" );
      ((Element)v.get(1404)).setAttribute("height","8" );
      ((Element)v.get(1403)).appendChild((Element)v.get(1404));
      /* Termina nodo:1404   */
      /* Termina nodo:1403   */

      /* Empieza nodo:1405 / Elemento padre: 1400   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1405)).setAttribute("align","center" );
      ((Element)v.get(1405)).setAttribute("width","12" );
      ((Element)v.get(1400)).appendChild((Element)v.get(1405));

      /* Empieza nodo:1406 / Elemento padre: 1405   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1406)).setAttribute("src","b.gif" );
      ((Element)v.get(1406)).setAttribute("width","12" );
      ((Element)v.get(1406)).setAttribute("height","8" );
      ((Element)v.get(1405)).appendChild((Element)v.get(1406));
      /* Termina nodo:1406   */
      /* Termina nodo:1405   */
      /* Termina nodo:1400   */
      /* Termina nodo:40   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:1407 / Elemento padre: 33   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1407)).setAttribute("align","center" );
      ((Element)v.get(1407)).setAttribute("width","12" );
      ((Element)v.get(33)).appendChild((Element)v.get(1407));

      /* Empieza nodo:1408 / Elemento padre: 1407   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1408)).setAttribute("src","b.gif" );
      ((Element)v.get(1408)).setAttribute("width","12" );
   }

   private void getXML6390(Document doc) {
      ((Element)v.get(1408)).setAttribute("height","12" );
      ((Element)v.get(1407)).appendChild((Element)v.get(1408));
      /* Termina nodo:1408   */
      /* Termina nodo:1407   */
      /* Termina nodo:33   */

      /* Empieza nodo:1409 / Elemento padre: 25   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1409)).setAttribute("nombre","eduMatriCursoTrButtons" );
      ((Element)v.get(25)).appendChild((Element)v.get(1409));

      /* Empieza nodo:1410 / Elemento padre: 1409   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1410)).setAttribute("align","center" );
      ((Element)v.get(1410)).setAttribute("width","12" );
      ((Element)v.get(1409)).appendChild((Element)v.get(1410));

      /* Empieza nodo:1411 / Elemento padre: 1410   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1411)).setAttribute("src","b.gif" );
      ((Element)v.get(1411)).setAttribute("width","12" );
      ((Element)v.get(1411)).setAttribute("height","12" );
      ((Element)v.get(1410)).appendChild((Element)v.get(1411));
      /* Termina nodo:1411   */
      /* Termina nodo:1410   */

      /* Empieza nodo:1412 / Elemento padre: 1409   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1409)).appendChild((Element)v.get(1412));

      /* Empieza nodo:1413 / Elemento padre: 1412   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(1412)).appendChild((Element)v.get(1413));

      /* Empieza nodo:1414 / Elemento padre: 1413   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1414)).setAttribute("width","100%" );
      ((Element)v.get(1414)).setAttribute("border","0" );
      ((Element)v.get(1414)).setAttribute("align","center" );
      ((Element)v.get(1414)).setAttribute("cellspacing","0" );
      ((Element)v.get(1414)).setAttribute("cellpadding","0" );
      ((Element)v.get(1413)).appendChild((Element)v.get(1414));

      /* Empieza nodo:1415 / Elemento padre: 1414   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1414)).appendChild((Element)v.get(1415));

      /* Empieza nodo:1416 / Elemento padre: 1415   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1416)).setAttribute("class","tablaTitle" );
      ((Element)v.get(1416)).setAttribute("nombre","eduMatriCursoTdQueryButton" );
      ((Element)v.get(1415)).appendChild((Element)v.get(1416));

      /* Empieza nodo:1417 / Elemento padre: 1416   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1417)).setAttribute("nombre","eduMatriCursoQueryButton" );
      ((Element)v.get(1417)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(1417)).setAttribute("estado","false" );
      ((Element)v.get(1417)).setAttribute("accion","eduMatriCursoFirstPage();" );
      ((Element)v.get(1417)).setAttribute("tipo","html" );
      ((Element)v.get(1417)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1416)).appendChild((Element)v.get(1417));
      /* Termina nodo:1417   */
      /* Termina nodo:1416   */

      /* Empieza nodo:1418 / Elemento padre: 1415   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1418)).setAttribute("class","tablaTitle" );
      ((Element)v.get(1418)).setAttribute("nombre","eduMatriCursoTdLovNullSelectionButton" );
      ((Element)v.get(1418)).setAttribute("align","left" );
      ((Element)v.get(1418)).setAttribute("width","100%" );
      ((Element)v.get(1415)).appendChild((Element)v.get(1418));

      /* Empieza nodo:1419 / Elemento padre: 1418   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1419)).setAttribute("src","b.gif" );
      ((Element)v.get(1419)).setAttribute("height","8" );
      ((Element)v.get(1419)).setAttribute("width","8" );
      ((Element)v.get(1418)).appendChild((Element)v.get(1419));
      /* Termina nodo:1419   */

      /* Empieza nodo:1420 / Elemento padre: 1418   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1420)).setAttribute("nombre","eduMatriCursoLovNullButton" );
      ((Element)v.get(1420)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1420)).setAttribute("tipo","html" );
      ((Element)v.get(1420)).setAttribute("accion","eduMatriCursoLovNullSelectionAction();" );
      ((Element)v.get(1420)).setAttribute("estado","true" );
      ((Element)v.get(1420)).setAttribute("cod","MMGGlobal.lovNullButton.label" );
      ((Element)v.get(1418)).appendChild((Element)v.get(1420));
      /* Termina nodo:1420   */
      /* Termina nodo:1418   */
      /* Termina nodo:1415   */
      /* Termina nodo:1414   */
      /* Termina nodo:1413   */
      /* Termina nodo:1412   */

      /* Empieza nodo:1421 / Elemento padre: 1409   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1421)).setAttribute("align","center" );
      ((Element)v.get(1421)).setAttribute("width","12" );
      ((Element)v.get(1409)).appendChild((Element)v.get(1421));

      /* Empieza nodo:1422 / Elemento padre: 1421   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1422)).setAttribute("src","b.gif" );
      ((Element)v.get(1422)).setAttribute("width","12" );
      ((Element)v.get(1422)).setAttribute("height","12" );
      ((Element)v.get(1421)).appendChild((Element)v.get(1422));
      /* Termina nodo:1422   */
      /* Termina nodo:1421   */
      /* Termina nodo:1409   */
      /* Termina nodo:25   */
      /* Termina nodo:24   */

      /* Empieza nodo:1423 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(1423)).setAttribute("nombre","eduMatriCursoPreListLayer" );
      ((Element)v.get(1423)).setAttribute("alto","23" );
      ((Element)v.get(1423)).setAttribute("ancho","100%" );
      ((Element)v.get(1423)).setAttribute("colorf","" );
      ((Element)v.get(1423)).setAttribute("borde","0" );
      ((Element)v.get(1423)).setAttribute("imagenf","" );
      ((Element)v.get(1423)).setAttribute("repeat","" );
      ((Element)v.get(1423)).setAttribute("padding","" );
      ((Element)v.get(1423)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(1423)).setAttribute("contravsb","" );
      ((Element)v.get(1423)).setAttribute("x","0" );
      ((Element)v.get(1423)).setAttribute("y","0" );
      ((Element)v.get(1423)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(1423));

      /* Empieza nodo:1424 / Elemento padre: 1423   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1424)).setAttribute("width","100%" );
      ((Element)v.get(1424)).setAttribute("border","0" );
      ((Element)v.get(1424)).setAttribute("align","center" );
      ((Element)v.get(1424)).setAttribute("cellspacing","0" );
      ((Element)v.get(1424)).setAttribute("cellpadding","0" );
      ((Element)v.get(1423)).appendChild((Element)v.get(1424));

      /* Empieza nodo:1425 / Elemento padre: 1424   */
      v.add(doc.createElement("tr"));
   }

   private void getXML6480(Document doc) {
      ((Element)v.get(1424)).appendChild((Element)v.get(1425));

      /* Empieza nodo:1426 / Elemento padre: 1425   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1426)).setAttribute("width","12" );
      ((Element)v.get(1426)).setAttribute("align","center" );
      ((Element)v.get(1425)).appendChild((Element)v.get(1426));

      /* Empieza nodo:1427 / Elemento padre: 1426   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1427)).setAttribute("src","b.gif" );
      ((Element)v.get(1427)).setAttribute("width","12" );
      ((Element)v.get(1427)).setAttribute("height","1" );
      ((Element)v.get(1426)).appendChild((Element)v.get(1427));
      /* Termina nodo:1427   */
      /* Termina nodo:1426   */

      /* Empieza nodo:1428 / Elemento padre: 1425   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1428)).setAttribute("width","750" );
      ((Element)v.get(1425)).appendChild((Element)v.get(1428));

      /* Empieza nodo:1429 / Elemento padre: 1428   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1429)).setAttribute("src","b.gif" );
      ((Element)v.get(1428)).appendChild((Element)v.get(1429));
      /* Termina nodo:1429   */
      /* Termina nodo:1428   */

      /* Empieza nodo:1430 / Elemento padre: 1425   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1430)).setAttribute("width","12" );
      ((Element)v.get(1425)).appendChild((Element)v.get(1430));

      /* Empieza nodo:1431 / Elemento padre: 1430   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1431)).setAttribute("src","b.gif" );
      ((Element)v.get(1431)).setAttribute("width","12" );
      ((Element)v.get(1431)).setAttribute("height","1" );
      ((Element)v.get(1430)).appendChild((Element)v.get(1431));
      /* Termina nodo:1431   */
      /* Termina nodo:1430   */
      /* Termina nodo:1425   */

      /* Empieza nodo:1432 / Elemento padre: 1424   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1424)).appendChild((Element)v.get(1432));

      /* Empieza nodo:1433 / Elemento padre: 1432   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1432)).appendChild((Element)v.get(1433));

      /* Empieza nodo:1434 / Elemento padre: 1433   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1434)).setAttribute("src","b.gif" );
      ((Element)v.get(1433)).appendChild((Element)v.get(1434));
      /* Termina nodo:1434   */
      /* Termina nodo:1433   */

      /* Empieza nodo:1435 / Elemento padre: 1432   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1432)).appendChild((Element)v.get(1435));

      /* Empieza nodo:1436 / Elemento padre: 1435   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(1435)).appendChild((Element)v.get(1436));

      /* Empieza nodo:1437 / Elemento padre: 1436   */
      v.add(doc.createElement("table"));
      ((Element)v.get(1437)).setAttribute("width","100%" );
      ((Element)v.get(1437)).setAttribute("border","0" );
      ((Element)v.get(1437)).setAttribute("align","center" );
      ((Element)v.get(1437)).setAttribute("cellspacing","0" );
      ((Element)v.get(1437)).setAttribute("cellpadding","0" );
      ((Element)v.get(1436)).appendChild((Element)v.get(1437));

      /* Empieza nodo:1438 / Elemento padre: 1437   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1437)).appendChild((Element)v.get(1438));

      /* Empieza nodo:1439 / Elemento padre: 1438   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1439)).setAttribute("bgcolor","#CCCCCC" );
      ((Element)v.get(1439)).setAttribute("width","4" );
      ((Element)v.get(1438)).appendChild((Element)v.get(1439));

      /* Empieza nodo:1440 / Elemento padre: 1439   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1440)).setAttribute("src","b.gif" );
      ((Element)v.get(1440)).setAttribute("width","4" );
      ((Element)v.get(1440)).setAttribute("height","4" );
      ((Element)v.get(1439)).appendChild((Element)v.get(1440));
      /* Termina nodo:1440   */
      /* Termina nodo:1439   */

      /* Empieza nodo:1441 / Elemento padre: 1438   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1441)).setAttribute("bgcolor","#CCCCCC" );
      ((Element)v.get(1441)).setAttribute("valign","middle" );
      ((Element)v.get(1438)).appendChild((Element)v.get(1441));

      /* Empieza nodo:1442 / Elemento padre: 1441   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1442)).setAttribute("nombre","lblResultSearch" );
      ((Element)v.get(1442)).setAttribute("ancho","108" );
      ((Element)v.get(1442)).setAttribute("alto","17" );
      ((Element)v.get(1442)).setAttribute("id","EstCab" );
      ((Element)v.get(1442)).setAttribute("cod","MMGGlobal.legend.resultlegend.label" );
      ((Element)v.get(1441)).appendChild((Element)v.get(1442));
      /* Termina nodo:1442   */
      /* Termina nodo:1441   */
      /* Termina nodo:1438   */
      /* Termina nodo:1437   */
      /* Termina nodo:1436   */
      /* Termina nodo:1435   */

      /* Empieza nodo:1443 / Elemento padre: 1432   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1443)).setAttribute("width","12" );
      ((Element)v.get(1432)).appendChild((Element)v.get(1443));

      /* Empieza nodo:1444 / Elemento padre: 1443   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1444)).setAttribute("src","b.gif" );
      ((Element)v.get(1444)).setAttribute("width","12" );
      ((Element)v.get(1444)).setAttribute("height","12" );
      ((Element)v.get(1443)).appendChild((Element)v.get(1444));
      /* Termina nodo:1444   */
      /* Termina nodo:1443   */
      /* Termina nodo:1432   */

      /* Empieza nodo:1445 / Elemento padre: 1424   */
      v.add(doc.createElement("tr"));
      ((Element)v.get(1424)).appendChild((Element)v.get(1445));

      /* Empieza nodo:1446 / Elemento padre: 1445   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1446)).setAttribute("width","12" );
      ((Element)v.get(1446)).setAttribute("align","center" );
      ((Element)v.get(1445)).appendChild((Element)v.get(1446));

      /* Empieza nodo:1447 / Elemento padre: 1446   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1447)).setAttribute("src","b.gif" );
      ((Element)v.get(1447)).setAttribute("width","12" );
      ((Element)v.get(1447)).setAttribute("height","1" );
      ((Element)v.get(1446)).appendChild((Element)v.get(1447));
      /* Termina nodo:1447   */
      /* Termina nodo:1446   */

      /* Empieza nodo:1448 / Elemento padre: 1445   */
      v.add(doc.createElement("td"));
      ((Element)v.get(1448)).setAttribute("width","750" );
      ((Element)v.get(1445)).appendChild((Element)v.get(1448));

      /* Empieza nodo:1449 / Elemento padre: 1448   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1449)).setAttribute("src","b.gif" );
      ((Element)v.get(1448)).appendChild((Element)v.get(1449));
      /* Termina nodo:1449   */
      /* Termina nodo:1448   */

      /* Empieza nodo:1450 / Elemento padre: 1445   */
      v.add(doc.createElement("td"));
   }

   private void getXML6570(Document doc) {
      ((Element)v.get(1450)).setAttribute("width","12" );
      ((Element)v.get(1445)).appendChild((Element)v.get(1450));

      /* Empieza nodo:1451 / Elemento padre: 1450   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1451)).setAttribute("src","b.gif" );
      ((Element)v.get(1451)).setAttribute("width","12" );
      ((Element)v.get(1451)).setAttribute("height","1" );
      ((Element)v.get(1450)).appendChild((Element)v.get(1451));
      /* Termina nodo:1451   */
      /* Termina nodo:1450   */
      /* Termina nodo:1445   */
      /* Termina nodo:1424   */
      /* Termina nodo:1423   */

      /* Empieza nodo:1452 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(1452)).setAttribute("nombre","eduMatriCursoListLayer" );
      ((Element)v.get(1452)).setAttribute("alto","310" );
      ((Element)v.get(1452)).setAttribute("ancho","99%" );
      ((Element)v.get(1452)).setAttribute("colorf","" );
      ((Element)v.get(1452)).setAttribute("borde","0" );
      ((Element)v.get(1452)).setAttribute("imagenf","" );
      ((Element)v.get(1452)).setAttribute("repeat","" );
      ((Element)v.get(1452)).setAttribute("padding","" );
      ((Element)v.get(1452)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(1452)).setAttribute("contravsb","" );
      ((Element)v.get(1452)).setAttribute("x","3" );
      ((Element)v.get(1452)).setAttribute("y","" );
      ((Element)v.get(1452)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(1452));

      /* Empieza nodo:1453 / Elemento padre: 1452   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(1453)).setAttribute("nombre","eduMatriCursoList" );
      ((Element)v.get(1453)).setAttribute("ancho","680" );
      ((Element)v.get(1453)).setAttribute("alto","275" );
      ((Element)v.get(1453)).setAttribute("x","12" );
      ((Element)v.get(1453)).setAttribute("y","0" );
      ((Element)v.get(1453)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(1453)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(1452)).appendChild((Element)v.get(1453));

      /* Empieza nodo:1454 / Elemento padre: 1453   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(1454)).setAttribute("precarga","S" );
      ((Element)v.get(1454)).setAttribute("conROver","S" );
      ((Element)v.get(1453)).appendChild((Element)v.get(1454));

      /* Empieza nodo:1455 / Elemento padre: 1454   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(1455)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(1455)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(1455)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(1455)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(1454)).appendChild((Element)v.get(1455));
      /* Termina nodo:1455   */

      /* Empieza nodo:1456 / Elemento padre: 1454   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(1456)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(1456)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(1456)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(1456)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(1454)).appendChild((Element)v.get(1456));
      /* Termina nodo:1456   */
      /* Termina nodo:1454   */

      /* Empieza nodo:1457 / Elemento padre: 1453   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(1453)).appendChild((Element)v.get(1457));

      /* Empieza nodo:1458 / Elemento padre: 1457   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(1458)).setAttribute("borde","1" );
      ((Element)v.get(1458)).setAttribute("horizDatos","1" );
      ((Element)v.get(1458)).setAttribute("horizCabecera","1" );
      ((Element)v.get(1458)).setAttribute("horizTitulo","1" );
      ((Element)v.get(1458)).setAttribute("horizBase","1" );
      ((Element)v.get(1458)).setAttribute("vertical","0" );
      ((Element)v.get(1457)).appendChild((Element)v.get(1458));
      /* Termina nodo:1458   */

      /* Empieza nodo:1459 / Elemento padre: 1457   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(1459)).setAttribute("borde","#999999" );
      ((Element)v.get(1459)).setAttribute("vertCabecera","#999999" );
      ((Element)v.get(1459)).setAttribute("vertDatos","#999999" );
      ((Element)v.get(1459)).setAttribute("horizDatos","#999999" );
      ((Element)v.get(1459)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(1459)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(1459)).setAttribute("horizBase","#999999" );
      ((Element)v.get(1457)).appendChild((Element)v.get(1459));
      /* Termina nodo:1459   */
      /* Termina nodo:1457   */

      /* Empieza nodo:1460 / Elemento padre: 1453   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(1460)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(1460)).setAttribute("alto","22" );
      ((Element)v.get(1460)).setAttribute("imgFondo","" );
      ((Element)v.get(1453)).appendChild((Element)v.get(1460));
      /* Termina nodo:1460   */

      /* Empieza nodo:1461 / Elemento padre: 1453   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(1461)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(1461)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(1461)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(1461)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(1461)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(1453)).appendChild((Element)v.get(1461));

      /* Empieza nodo:1462 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1462)).setAttribute("ancho","100" );
      ((Element)v.get(1462)).setAttribute("minimizable","S" );
      ((Element)v.get(1462)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1462));
      /* Termina nodo:1462   */

      /* Empieza nodo:1463 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1463)).setAttribute("ancho","100" );
      ((Element)v.get(1463)).setAttribute("minimizable","S" );
      ((Element)v.get(1463)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1463));
      /* Termina nodo:1463   */

      /* Empieza nodo:1464 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1464)).setAttribute("ancho","100" );
   }

   private void getXML6660(Document doc) {
      ((Element)v.get(1464)).setAttribute("minimizable","S" );
      ((Element)v.get(1464)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1464));
      /* Termina nodo:1464   */

      /* Empieza nodo:1465 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1465)).setAttribute("ancho","100" );
      ((Element)v.get(1465)).setAttribute("minimizable","S" );
      ((Element)v.get(1465)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1465));
      /* Termina nodo:1465   */

      /* Empieza nodo:1466 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1466)).setAttribute("ancho","100" );
      ((Element)v.get(1466)).setAttribute("minimizable","S" );
      ((Element)v.get(1466)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1466));
      /* Termina nodo:1466   */

      /* Empieza nodo:1467 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1467)).setAttribute("ancho","100" );
      ((Element)v.get(1467)).setAttribute("minimizable","S" );
      ((Element)v.get(1467)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1467));
      /* Termina nodo:1467   */

      /* Empieza nodo:1468 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1468)).setAttribute("ancho","100" );
      ((Element)v.get(1468)).setAttribute("minimizable","S" );
      ((Element)v.get(1468)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1468));
      /* Termina nodo:1468   */

      /* Empieza nodo:1469 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1469)).setAttribute("ancho","100" );
      ((Element)v.get(1469)).setAttribute("minimizable","S" );
      ((Element)v.get(1469)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1469));
      /* Termina nodo:1469   */

      /* Empieza nodo:1470 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1470)).setAttribute("ancho","100" );
      ((Element)v.get(1470)).setAttribute("minimizable","S" );
      ((Element)v.get(1470)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1470));
      /* Termina nodo:1470   */

      /* Empieza nodo:1471 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1471)).setAttribute("ancho","100" );
      ((Element)v.get(1471)).setAttribute("minimizable","S" );
      ((Element)v.get(1471)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1471));
      /* Termina nodo:1471   */

      /* Empieza nodo:1472 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1472)).setAttribute("ancho","100" );
      ((Element)v.get(1472)).setAttribute("minimizable","S" );
      ((Element)v.get(1472)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1472));
      /* Termina nodo:1472   */

      /* Empieza nodo:1473 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1473)).setAttribute("ancho","100" );
      ((Element)v.get(1473)).setAttribute("minimizable","S" );
      ((Element)v.get(1473)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1473));
      /* Termina nodo:1473   */

      /* Empieza nodo:1474 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1474)).setAttribute("ancho","100" );
      ((Element)v.get(1474)).setAttribute("minimizable","S" );
      ((Element)v.get(1474)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1474));
      /* Termina nodo:1474   */

      /* Empieza nodo:1475 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1475)).setAttribute("ancho","100" );
      ((Element)v.get(1475)).setAttribute("minimizable","S" );
      ((Element)v.get(1475)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1475));
      /* Termina nodo:1475   */

      /* Empieza nodo:1476 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1476)).setAttribute("ancho","100" );
      ((Element)v.get(1476)).setAttribute("minimizable","S" );
      ((Element)v.get(1476)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1476));
      /* Termina nodo:1476   */

      /* Empieza nodo:1477 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1477)).setAttribute("ancho","100" );
      ((Element)v.get(1477)).setAttribute("minimizable","S" );
      ((Element)v.get(1477)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1477));
      /* Termina nodo:1477   */

      /* Empieza nodo:1478 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1478)).setAttribute("ancho","100" );
      ((Element)v.get(1478)).setAttribute("minimizable","S" );
      ((Element)v.get(1478)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1478));
      /* Termina nodo:1478   */

      /* Empieza nodo:1479 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1479)).setAttribute("ancho","100" );
      ((Element)v.get(1479)).setAttribute("minimizable","S" );
      ((Element)v.get(1479)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1479));
      /* Termina nodo:1479   */

      /* Empieza nodo:1480 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1480)).setAttribute("ancho","100" );
      ((Element)v.get(1480)).setAttribute("minimizable","S" );
      ((Element)v.get(1480)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1480));
      /* Termina nodo:1480   */

      /* Empieza nodo:1481 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1481)).setAttribute("ancho","100" );
      ((Element)v.get(1481)).setAttribute("minimizable","S" );
      ((Element)v.get(1481)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1481));
      /* Termina nodo:1481   */

      /* Empieza nodo:1482 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1482)).setAttribute("ancho","100" );
   }

   private void getXML6750(Document doc) {
      ((Element)v.get(1482)).setAttribute("minimizable","S" );
      ((Element)v.get(1482)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1482));
      /* Termina nodo:1482   */

      /* Empieza nodo:1483 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1483)).setAttribute("ancho","100" );
      ((Element)v.get(1483)).setAttribute("minimizable","S" );
      ((Element)v.get(1483)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1483));
      /* Termina nodo:1483   */

      /* Empieza nodo:1484 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1484)).setAttribute("ancho","100" );
      ((Element)v.get(1484)).setAttribute("minimizable","S" );
      ((Element)v.get(1484)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1484));
      /* Termina nodo:1484   */

      /* Empieza nodo:1485 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1485)).setAttribute("ancho","100" );
      ((Element)v.get(1485)).setAttribute("minimizable","S" );
      ((Element)v.get(1485)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1485));
      /* Termina nodo:1485   */

      /* Empieza nodo:1486 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1486)).setAttribute("ancho","100" );
      ((Element)v.get(1486)).setAttribute("minimizable","S" );
      ((Element)v.get(1486)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1486));
      /* Termina nodo:1486   */

      /* Empieza nodo:1487 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1487)).setAttribute("ancho","100" );
      ((Element)v.get(1487)).setAttribute("minimizable","S" );
      ((Element)v.get(1487)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1487));
      /* Termina nodo:1487   */

      /* Empieza nodo:1488 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1488)).setAttribute("ancho","100" );
      ((Element)v.get(1488)).setAttribute("minimizable","S" );
      ((Element)v.get(1488)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1488));
      /* Termina nodo:1488   */

      /* Empieza nodo:1489 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1489)).setAttribute("ancho","100" );
      ((Element)v.get(1489)).setAttribute("minimizable","S" );
      ((Element)v.get(1489)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1489));
      /* Termina nodo:1489   */

      /* Empieza nodo:1490 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1490)).setAttribute("ancho","100" );
      ((Element)v.get(1490)).setAttribute("minimizable","S" );
      ((Element)v.get(1490)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1490));
      /* Termina nodo:1490   */

      /* Empieza nodo:1491 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1491)).setAttribute("ancho","100" );
      ((Element)v.get(1491)).setAttribute("minimizable","S" );
      ((Element)v.get(1491)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1491));
      /* Termina nodo:1491   */

      /* Empieza nodo:1492 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1492)).setAttribute("ancho","100" );
      ((Element)v.get(1492)).setAttribute("minimizable","S" );
      ((Element)v.get(1492)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1492));
      /* Termina nodo:1492   */

      /* Empieza nodo:1493 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1493)).setAttribute("ancho","100" );
      ((Element)v.get(1493)).setAttribute("minimizable","S" );
      ((Element)v.get(1493)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1493));
      /* Termina nodo:1493   */

      /* Empieza nodo:1494 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1494)).setAttribute("ancho","100" );
      ((Element)v.get(1494)).setAttribute("minimizable","S" );
      ((Element)v.get(1494)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1494));
      /* Termina nodo:1494   */

      /* Empieza nodo:1495 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1495)).setAttribute("ancho","100" );
      ((Element)v.get(1495)).setAttribute("minimizable","S" );
      ((Element)v.get(1495)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1495));
      /* Termina nodo:1495   */

      /* Empieza nodo:1496 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1496)).setAttribute("ancho","100" );
      ((Element)v.get(1496)).setAttribute("minimizable","S" );
      ((Element)v.get(1496)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1496));
      /* Termina nodo:1496   */

      /* Empieza nodo:1497 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1497)).setAttribute("ancho","100" );
      ((Element)v.get(1497)).setAttribute("minimizable","S" );
      ((Element)v.get(1497)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1497));
      /* Termina nodo:1497   */

      /* Empieza nodo:1498 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1498)).setAttribute("ancho","100" );
      ((Element)v.get(1498)).setAttribute("minimizable","S" );
      ((Element)v.get(1498)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1498));
      /* Termina nodo:1498   */

      /* Empieza nodo:1499 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1499)).setAttribute("ancho","100" );
      ((Element)v.get(1499)).setAttribute("minimizable","S" );
      ((Element)v.get(1499)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1499));
      /* Termina nodo:1499   */

      /* Empieza nodo:1500 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1500)).setAttribute("ancho","100" );
   }

   private void getXML6840(Document doc) {
      ((Element)v.get(1500)).setAttribute("minimizable","S" );
      ((Element)v.get(1500)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1500));
      /* Termina nodo:1500   */

      /* Empieza nodo:1501 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1501)).setAttribute("ancho","100" );
      ((Element)v.get(1501)).setAttribute("minimizable","S" );
      ((Element)v.get(1501)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1501));
      /* Termina nodo:1501   */

      /* Empieza nodo:1502 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1502)).setAttribute("ancho","100" );
      ((Element)v.get(1502)).setAttribute("minimizable","S" );
      ((Element)v.get(1502)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1502));
      /* Termina nodo:1502   */

      /* Empieza nodo:1503 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1503)).setAttribute("ancho","100" );
      ((Element)v.get(1503)).setAttribute("minimizable","S" );
      ((Element)v.get(1503)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1503));
      /* Termina nodo:1503   */

      /* Empieza nodo:1504 / Elemento padre: 1461   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1504)).setAttribute("ancho","100" );
      ((Element)v.get(1504)).setAttribute("minimizable","S" );
      ((Element)v.get(1504)).setAttribute("minimizada","N" );
      ((Element)v.get(1461)).appendChild((Element)v.get(1504));
      /* Termina nodo:1504   */
      /* Termina nodo:1461   */

      /* Empieza nodo:1505 / Elemento padre: 1453   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(1505)).setAttribute("height","20" );
      ((Element)v.get(1505)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(1505)).setAttribute("imgFondo","" );
      ((Element)v.get(1505)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(1453)).appendChild((Element)v.get(1505));

      /* Empieza nodo:1506 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1506)).setAttribute("colFondo","" );
      ((Element)v.get(1506)).setAttribute("ID","EstCab" );
      ((Element)v.get(1506)).setAttribute("cod","EduMatriCurso.paisOidPais.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1506));
      /* Termina nodo:1506   */

      /* Empieza nodo:1507 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1507)).setAttribute("colFondo","" );
      ((Element)v.get(1507)).setAttribute("ID","EstCab" );
      ((Element)v.get(1507)).setAttribute("cod","EduMatriCurso.cplcOidCabePlanCurs.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1507));
      /* Termina nodo:1507   */

      /* Empieza nodo:1508 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1508)).setAttribute("colFondo","" );
      ((Element)v.get(1508)).setAttribute("ID","EstCab" );
      ((Element)v.get(1508)).setAttribute("cod","EduMatriCurso.codCurs.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1508));
      /* Termina nodo:1508   */

      /* Empieza nodo:1509 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1509)).setAttribute("colFondo","" );
      ((Element)v.get(1509)).setAttribute("ID","EstCab" );
      ((Element)v.get(1509)).setAttribute("cod","EduMatriCurso.terrOidTerr.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1509));
      /* Termina nodo:1509   */

      /* Empieza nodo:1510 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1510)).setAttribute("colFondo","" );
      ((Element)v.get(1510)).setAttribute("ID","EstCab" );
      ((Element)v.get(1510)).setAttribute("cod","EduMatriCurso.clasOidClas.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1510));
      /* Termina nodo:1510   */

      /* Empieza nodo:1511 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1511)).setAttribute("colFondo","" );
      ((Element)v.get(1511)).setAttribute("ID","EstCab" );
      ((Element)v.get(1511)).setAttribute("cod","EduMatriCurso.frcuOidFrec.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1511));
      /* Termina nodo:1511   */

      /* Empieza nodo:1512 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1512)).setAttribute("colFondo","" );
      ((Element)v.get(1512)).setAttribute("ID","EstCab" );
      ((Element)v.get(1512)).setAttribute("cod","EduMatriCurso.regaOidRega.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1512));
      /* Termina nodo:1512   */

      /* Empieza nodo:1513 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1513)).setAttribute("colFondo","" );
      ((Element)v.get(1513)).setAttribute("ID","EstCab" );
      ((Element)v.get(1513)).setAttribute("cod","EduMatriCurso.zsgvOidSubgVent.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1513));
      /* Termina nodo:1513   */

      /* Empieza nodo:1514 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1514)).setAttribute("colFondo","" );
      ((Element)v.get(1514)).setAttribute("ID","EstCab" );
      ((Element)v.get(1514)).setAttribute("cod","EduMatriCurso.zorgOidRegi.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1514));
      /* Termina nodo:1514   */

      /* Empieza nodo:1515 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1515)).setAttribute("colFondo","" );
      ((Element)v.get(1515)).setAttribute("ID","EstCab" );
      ((Element)v.get(1515)).setAttribute("cod","EduMatriCurso.zzonOidZona.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1515));
      /* Termina nodo:1515   */

      /* Empieza nodo:1516 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1516)).setAttribute("colFondo","" );
      ((Element)v.get(1516)).setAttribute("ID","EstCab" );
      ((Element)v.get(1516)).setAttribute("cod","EduMatriCurso.zsccOidSecc.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1516));
      /* Termina nodo:1516   */

      /* Empieza nodo:1517 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1517)).setAttribute("colFondo","" );
      ((Element)v.get(1517)).setAttribute("ID","EstCab" );
      ((Element)v.get(1517)).setAttribute("cod","EduMatriCurso.ztadOidTerrAdmi.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1517));
      /* Termina nodo:1517   */

      /* Empieza nodo:1518 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
   }

   private void getXML6930(Document doc) {
      ((Element)v.get(1518)).setAttribute("colFondo","" );
      ((Element)v.get(1518)).setAttribute("ID","EstCab" );
      ((Element)v.get(1518)).setAttribute("cod","EduMatriCurso.perdOidPeriInicComp.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1518));
      /* Termina nodo:1518   */

      /* Empieza nodo:1519 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1519)).setAttribute("colFondo","" );
      ((Element)v.get(1519)).setAttribute("ID","EstCab" );
      ((Element)v.get(1519)).setAttribute("cod","EduMatriCurso.perdOidPeriFinaComp.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1519));
      /* Termina nodo:1519   */

      /* Empieza nodo:1520 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1520)).setAttribute("colFondo","" );
      ((Element)v.get(1520)).setAttribute("ID","EstCab" );
      ((Element)v.get(1520)).setAttribute("cod","EduMatriCurso.perdOidPeriInicCons.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1520));
      /* Termina nodo:1520   */

      /* Empieza nodo:1521 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1521)).setAttribute("colFondo","" );
      ((Element)v.get(1521)).setAttribute("ID","EstCab" );
      ((Element)v.get(1521)).setAttribute("cod","EduMatriCurso.perdOidPeriFinaCons.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1521));
      /* Termina nodo:1521   */

      /* Empieza nodo:1522 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1522)).setAttribute("colFondo","" );
      ((Element)v.get(1522)).setAttribute("ID","EstCab" );
      ((Element)v.get(1522)).setAttribute("cod","EduMatriCurso.perdOidPeriIngr.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1522));
      /* Termina nodo:1522   */

      /* Empieza nodo:1523 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1523)).setAttribute("colFondo","" );
      ((Element)v.get(1523)).setAttribute("ID","EstCab" );
      ((Element)v.get(1523)).setAttribute("cod","EduMatriCurso.ticuOidTipoCurs.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1523));
      /* Termina nodo:1523   */

      /* Empieza nodo:1524 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1524)).setAttribute("colFondo","" );
      ((Element)v.get(1524)).setAttribute("ID","EstCab" );
      ((Element)v.get(1524)).setAttribute("cod","EduMatriCurso.valPathFich.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1524));
      /* Termina nodo:1524   */

      /* Empieza nodo:1525 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1525)).setAttribute("colFondo","" );
      ((Element)v.get(1525)).setAttribute("ID","EstCab" );
      ((Element)v.get(1525)).setAttribute("cod","EduMatriCurso.valObjeCurs.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1525));
      /* Termina nodo:1525   */

      /* Empieza nodo:1526 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1526)).setAttribute("colFondo","" );
      ((Element)v.get(1526)).setAttribute("ID","EstCab" );
      ((Element)v.get(1526)).setAttribute("cod","EduMatriCurso.valContCurs.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1526));
      /* Termina nodo:1526   */

      /* Empieza nodo:1527 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1527)).setAttribute("colFondo","" );
      ((Element)v.get(1527)).setAttribute("ID","EstCab" );
      ((Element)v.get(1527)).setAttribute("cod","EduMatriCurso.valRelaMateCurs.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1527));
      /* Termina nodo:1527   */

      /* Empieza nodo:1528 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1528)).setAttribute("colFondo","" );
      ((Element)v.get(1528)).setAttribute("ID","EstCab" );
      ((Element)v.get(1528)).setAttribute("cod","EduMatriCurso.valMontVent.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1528));
      /* Termina nodo:1528   */

      /* Empieza nodo:1529 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1529)).setAttribute("colFondo","" );
      ((Element)v.get(1529)).setAttribute("ID","EstCab" );
      ((Element)v.get(1529)).setAttribute("cod","EduMatriCurso.fecDispCurs.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1529));
      /* Termina nodo:1529   */

      /* Empieza nodo:1530 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1530)).setAttribute("colFondo","" );
      ((Element)v.get(1530)).setAttribute("ID","EstCab" );
      ((Element)v.get(1530)).setAttribute("cod","EduMatriCurso.fecLanz.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1530));
      /* Termina nodo:1530   */

      /* Empieza nodo:1531 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1531)).setAttribute("colFondo","" );
      ((Element)v.get(1531)).setAttribute("ID","EstCab" );
      ((Element)v.get(1531)).setAttribute("cod","EduMatriCurso.fecFinCurs.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1531));
      /* Termina nodo:1531   */

      /* Empieza nodo:1532 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1532)).setAttribute("colFondo","" );
      ((Element)v.get(1532)).setAttribute("ID","EstCab" );
      ((Element)v.get(1532)).setAttribute("cod","EduMatriCurso.fecUltiCurs.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1532));
      /* Termina nodo:1532   */

      /* Empieza nodo:1533 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1533)).setAttribute("colFondo","" );
      ((Element)v.get(1533)).setAttribute("ID","EstCab" );
      ((Element)v.get(1533)).setAttribute("cod","EduMatriCurso.fecConcCurs.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1533));
      /* Termina nodo:1533   */

      /* Empieza nodo:1534 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1534)).setAttribute("colFondo","" );
      ((Element)v.get(1534)).setAttribute("ID","EstCab" );
      ((Element)v.get(1534)).setAttribute("cod","EduMatriCurso.fecIngr.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1534));
      /* Termina nodo:1534   */

      /* Empieza nodo:1535 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1535)).setAttribute("colFondo","" );
      ((Element)v.get(1535)).setAttribute("ID","EstCab" );
      ((Element)v.get(1535)).setAttribute("cod","EduMatriCurso.numPart.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1535));
      /* Termina nodo:1535   */

      /* Empieza nodo:1536 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
   }

   private void getXML7020(Document doc) {
      ((Element)v.get(1536)).setAttribute("colFondo","" );
      ((Element)v.get(1536)).setAttribute("ID","EstCab" );
      ((Element)v.get(1536)).setAttribute("cod","EduMatriCurso.numOrde.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1536));
      /* Termina nodo:1536   */

      /* Empieza nodo:1537 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1537)).setAttribute("colFondo","" );
      ((Element)v.get(1537)).setAttribute("ID","EstCab" );
      ((Element)v.get(1537)).setAttribute("cod","EduMatriCurso.numCampa.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1537));
      /* Termina nodo:1537   */

      /* Empieza nodo:1538 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1538)).setAttribute("colFondo","" );
      ((Element)v.get(1538)).setAttribute("ID","EstCab" );
      ((Element)v.get(1538)).setAttribute("cod","EduMatriCurso.numUnid.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1538));
      /* Termina nodo:1538   */

      /* Empieza nodo:1539 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1539)).setAttribute("colFondo","" );
      ((Element)v.get(1539)).setAttribute("ID","EstCab" );
      ((Element)v.get(1539)).setAttribute("cod","EduMatriCurso.desCurs.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1539));
      /* Termina nodo:1539   */

      /* Empieza nodo:1540 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1540)).setAttribute("colFondo","" );
      ((Element)v.get(1540)).setAttribute("ID","EstCab" );
      ((Element)v.get(1540)).setAttribute("cod","EduMatriCurso.indAcceDmrt.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1540));
      /* Termina nodo:1540   */

      /* Empieza nodo:1541 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1541)).setAttribute("colFondo","" );
      ((Element)v.get(1541)).setAttribute("ID","EstCab" );
      ((Element)v.get(1541)).setAttribute("cod","EduMatriCurso.indAcceInfo.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1541));
      /* Termina nodo:1541   */

      /* Empieza nodo:1542 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1542)).setAttribute("colFondo","" );
      ((Element)v.get(1542)).setAttribute("ID","EstCab" );
      ((Element)v.get(1542)).setAttribute("cod","EduMatriCurso.indAlcaGeog.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1542));
      /* Termina nodo:1542   */

      /* Empieza nodo:1543 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1543)).setAttribute("colFondo","" );
      ((Element)v.get(1543)).setAttribute("ID","EstCab" );
      ((Element)v.get(1543)).setAttribute("cod","EduMatriCurso.indBloqExte.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1543));
      /* Termina nodo:1543   */

      /* Empieza nodo:1544 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1544)).setAttribute("colFondo","" );
      ((Element)v.get(1544)).setAttribute("ID","EstCab" );
      ((Element)v.get(1544)).setAttribute("cod","EduMatriCurso.indMomeEntr.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1544));
      /* Termina nodo:1544   */

      /* Empieza nodo:1545 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1545)).setAttribute("colFondo","" );
      ((Element)v.get(1545)).setAttribute("ID","EstCab" );
      ((Element)v.get(1545)).setAttribute("cod","EduMatriCurso.indCondPedi.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1545));
      /* Termina nodo:1545   */

      /* Empieza nodo:1546 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1546)).setAttribute("colFondo","" );
      ((Element)v.get(1546)).setAttribute("ID","EstCab" );
      ((Element)v.get(1546)).setAttribute("cod","EduMatriCurso.indCtrlMoro.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1546));
      /* Termina nodo:1546   */

      /* Empieza nodo:1547 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1547)).setAttribute("colFondo","" );
      ((Element)v.get(1547)).setAttribute("ID","EstCab" );
      ((Element)v.get(1547)).setAttribute("cod","EduMatriCurso.indCtrlFunc.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1547));
      /* Termina nodo:1547   */

      /* Empieza nodo:1548 / Elemento padre: 1505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1548)).setAttribute("colFondo","" );
      ((Element)v.get(1548)).setAttribute("ID","EstCab" );
      ((Element)v.get(1548)).setAttribute("cod","EduMatriCurso.clclOidClieClasCapa.label" );
      ((Element)v.get(1505)).appendChild((Element)v.get(1548));
      /* Termina nodo:1548   */
      /* Termina nodo:1505   */

      /* Empieza nodo:1549 / Elemento padre: 1453   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(1549)).setAttribute("alto","22" );
      ((Element)v.get(1549)).setAttribute("accion","" );
      ((Element)v.get(1549)).setAttribute("tipoEnvio","seleccion" );
      ((Element)v.get(1549)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(1549)).setAttribute("maxSel","1" );
      ((Element)v.get(1549)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(1549)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(1549)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(1549)).setAttribute("onLoad","" );
      ((Element)v.get(1549)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(1453)).appendChild((Element)v.get(1549));

      /* Empieza nodo:1550 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1550)).setAttribute("tipo","texto" );
      ((Element)v.get(1550)).setAttribute("ID","EstDat" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1550));
      /* Termina nodo:1550   */

      /* Empieza nodo:1551 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1551)).setAttribute("tipo","texto" );
      ((Element)v.get(1551)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1551));
      /* Termina nodo:1551   */

      /* Empieza nodo:1552 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1552)).setAttribute("tipo","texto" );
      ((Element)v.get(1552)).setAttribute("ID","EstDat" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1552));
      /* Termina nodo:1552   */

      /* Empieza nodo:1553 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1553)).setAttribute("tipo","texto" );
   }

   private void getXML7110(Document doc) {
      ((Element)v.get(1553)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1553));
      /* Termina nodo:1553   */

      /* Empieza nodo:1554 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1554)).setAttribute("tipo","texto" );
      ((Element)v.get(1554)).setAttribute("ID","EstDat" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1554));
      /* Termina nodo:1554   */

      /* Empieza nodo:1555 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1555)).setAttribute("tipo","texto" );
      ((Element)v.get(1555)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1555));
      /* Termina nodo:1555   */

      /* Empieza nodo:1556 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1556)).setAttribute("tipo","texto" );
      ((Element)v.get(1556)).setAttribute("ID","EstDat" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1556));
      /* Termina nodo:1556   */

      /* Empieza nodo:1557 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1557)).setAttribute("tipo","texto" );
      ((Element)v.get(1557)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1557));
      /* Termina nodo:1557   */

      /* Empieza nodo:1558 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1558)).setAttribute("tipo","texto" );
      ((Element)v.get(1558)).setAttribute("ID","EstDat" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1558));
      /* Termina nodo:1558   */

      /* Empieza nodo:1559 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1559)).setAttribute("tipo","texto" );
      ((Element)v.get(1559)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1559));
      /* Termina nodo:1559   */

      /* Empieza nodo:1560 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1560)).setAttribute("tipo","texto" );
      ((Element)v.get(1560)).setAttribute("ID","EstDat" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1560));
      /* Termina nodo:1560   */

      /* Empieza nodo:1561 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1561)).setAttribute("tipo","texto" );
      ((Element)v.get(1561)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1561));
      /* Termina nodo:1561   */

      /* Empieza nodo:1562 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1562)).setAttribute("tipo","texto" );
      ((Element)v.get(1562)).setAttribute("ID","EstDat" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1562));
      /* Termina nodo:1562   */

      /* Empieza nodo:1563 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1563)).setAttribute("tipo","texto" );
      ((Element)v.get(1563)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1563));
      /* Termina nodo:1563   */

      /* Empieza nodo:1564 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1564)).setAttribute("tipo","texto" );
      ((Element)v.get(1564)).setAttribute("ID","EstDat" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1564));
      /* Termina nodo:1564   */

      /* Empieza nodo:1565 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1565)).setAttribute("tipo","texto" );
      ((Element)v.get(1565)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1565));
      /* Termina nodo:1565   */

      /* Empieza nodo:1566 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1566)).setAttribute("tipo","texto" );
      ((Element)v.get(1566)).setAttribute("ID","EstDat" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1566));
      /* Termina nodo:1566   */

      /* Empieza nodo:1567 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1567)).setAttribute("tipo","texto" );
      ((Element)v.get(1567)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1567));
      /* Termina nodo:1567   */

      /* Empieza nodo:1568 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1568)).setAttribute("tipo","texto" );
      ((Element)v.get(1568)).setAttribute("ID","EstDat" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1568));
      /* Termina nodo:1568   */

      /* Empieza nodo:1569 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1569)).setAttribute("tipo","texto" );
      ((Element)v.get(1569)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1569));
      /* Termina nodo:1569   */

      /* Empieza nodo:1570 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1570)).setAttribute("tipo","texto" );
      ((Element)v.get(1570)).setAttribute("ID","EstDat" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1570));
      /* Termina nodo:1570   */

      /* Empieza nodo:1571 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1571)).setAttribute("tipo","texto" );
      ((Element)v.get(1571)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1571));
      /* Termina nodo:1571   */

      /* Empieza nodo:1572 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1572)).setAttribute("tipo","texto" );
      ((Element)v.get(1572)).setAttribute("ID","EstDat" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1572));
      /* Termina nodo:1572   */

      /* Empieza nodo:1573 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1573)).setAttribute("tipo","texto" );
      ((Element)v.get(1573)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1573));
      /* Termina nodo:1573   */

      /* Empieza nodo:1574 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1574)).setAttribute("tipo","texto" );
      ((Element)v.get(1574)).setAttribute("ID","EstDat" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1574));
      /* Termina nodo:1574   */

      /* Empieza nodo:1575 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1575)).setAttribute("tipo","texto" );
      ((Element)v.get(1575)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1575));
      /* Termina nodo:1575   */

      /* Empieza nodo:1576 / Elemento padre: 1549   */
   }

   private void getXML7200(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(1576)).setAttribute("tipo","texto" );
      ((Element)v.get(1576)).setAttribute("ID","EstDat" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1576));
      /* Termina nodo:1576   */

      /* Empieza nodo:1577 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1577)).setAttribute("tipo","texto" );
      ((Element)v.get(1577)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1577));
      /* Termina nodo:1577   */

      /* Empieza nodo:1578 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1578)).setAttribute("tipo","texto" );
      ((Element)v.get(1578)).setAttribute("ID","EstDat" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1578));
      /* Termina nodo:1578   */

      /* Empieza nodo:1579 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1579)).setAttribute("tipo","texto" );
      ((Element)v.get(1579)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1579));
      /* Termina nodo:1579   */

      /* Empieza nodo:1580 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1580)).setAttribute("tipo","texto" );
      ((Element)v.get(1580)).setAttribute("ID","EstDat" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1580));
      /* Termina nodo:1580   */

      /* Empieza nodo:1581 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1581)).setAttribute("tipo","texto" );
      ((Element)v.get(1581)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1581));
      /* Termina nodo:1581   */

      /* Empieza nodo:1582 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1582)).setAttribute("tipo","texto" );
      ((Element)v.get(1582)).setAttribute("ID","EstDat" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1582));
      /* Termina nodo:1582   */

      /* Empieza nodo:1583 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1583)).setAttribute("tipo","texto" );
      ((Element)v.get(1583)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1583));
      /* Termina nodo:1583   */

      /* Empieza nodo:1584 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1584)).setAttribute("tipo","texto" );
      ((Element)v.get(1584)).setAttribute("ID","EstDat" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1584));
      /* Termina nodo:1584   */

      /* Empieza nodo:1585 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1585)).setAttribute("tipo","texto" );
      ((Element)v.get(1585)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1585));
      /* Termina nodo:1585   */

      /* Empieza nodo:1586 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1586)).setAttribute("tipo","texto" );
      ((Element)v.get(1586)).setAttribute("ID","EstDat" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1586));
      /* Termina nodo:1586   */

      /* Empieza nodo:1587 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1587)).setAttribute("tipo","texto" );
      ((Element)v.get(1587)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1587));
      /* Termina nodo:1587   */

      /* Empieza nodo:1588 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1588)).setAttribute("tipo","texto" );
      ((Element)v.get(1588)).setAttribute("ID","EstDat" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1588));
      /* Termina nodo:1588   */

      /* Empieza nodo:1589 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1589)).setAttribute("tipo","texto" );
      ((Element)v.get(1589)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1589));
      /* Termina nodo:1589   */

      /* Empieza nodo:1590 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1590)).setAttribute("tipo","texto" );
      ((Element)v.get(1590)).setAttribute("ID","EstDat" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1590));
      /* Termina nodo:1590   */

      /* Empieza nodo:1591 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1591)).setAttribute("tipo","texto" );
      ((Element)v.get(1591)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1591));
      /* Termina nodo:1591   */

      /* Empieza nodo:1592 / Elemento padre: 1549   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1592)).setAttribute("tipo","texto" );
      ((Element)v.get(1592)).setAttribute("ID","EstDat" );
      ((Element)v.get(1549)).appendChild((Element)v.get(1592));
      /* Termina nodo:1592   */
      /* Termina nodo:1549   */

      /* Empieza nodo:1593 / Elemento padre: 1453   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(1453)).appendChild((Element)v.get(1593));
      /* Termina nodo:1593   */
      /* Termina nodo:1453   */
      /* Termina nodo:1452   */

      /* Empieza nodo:1594 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(1594)).setAttribute("nombre","eduMatriCursoListButtonsLayer" );
      ((Element)v.get(1594)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(1594)).setAttribute("alto","30" );
      ((Element)v.get(1594)).setAttribute("ancho","98%" );
      ((Element)v.get(1594)).setAttribute("borde","n" );
      ((Element)v.get(1594)).setAttribute("imagenf","" );
      ((Element)v.get(1594)).setAttribute("repeat","" );
      ((Element)v.get(1594)).setAttribute("padding","0" );
      ((Element)v.get(1594)).setAttribute("contravsb","" );
      ((Element)v.get(1594)).setAttribute("x","16" );
      ((Element)v.get(1594)).setAttribute("y","" );
      ((Element)v.get(1594)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(1594));

      /* Empieza nodo:1595 / Elemento padre: 1594   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1595)).setAttribute("width","100%" );
      ((Element)v.get(1595)).setAttribute("border","0" );
      ((Element)v.get(1595)).setAttribute("cellspacing","1" );
      ((Element)v.get(1595)).setAttribute("cellpadding","0" );
      ((Element)v.get(1595)).setAttribute("height","22" );
   }

   private void getXML7290(Document doc) {
      ((Element)v.get(1594)).appendChild((Element)v.get(1595));

      /* Empieza nodo:1596 / Elemento padre: 1595   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1596)).setAttribute("class","tablaTitle" );
      ((Element)v.get(1596)).setAttribute("nombre","eduMatriCursoUpdateButtonTd" );
      ((Element)v.get(1595)).appendChild((Element)v.get(1596));

      /* Empieza nodo:1597 / Elemento padre: 1596   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1597)).setAttribute("nombre","eduMatriCursoUpdateButton" );
      ((Element)v.get(1597)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1597)).setAttribute("tipo","html" );
      ((Element)v.get(1597)).setAttribute("accion","eduMatriCursoUpdateSelection();" );
      ((Element)v.get(1597)).setAttribute("estado","false" );
      ((Element)v.get(1597)).setAttribute("cod","MMGGlobal.updateButton.label" );
      ((Element)v.get(1596)).appendChild((Element)v.get(1597));
      /* Termina nodo:1597   */
      /* Termina nodo:1596   */

      /* Empieza nodo:1598 / Elemento padre: 1595   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1598)).setAttribute("nombre","eduMatriCursoUpdateButtonGapTd" );
      ((Element)v.get(1595)).appendChild((Element)v.get(1598));

      /* Empieza nodo:1599 / Elemento padre: 1598   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1599)).setAttribute("src","b.gif" );
      ((Element)v.get(1599)).setAttribute("height","8" );
      ((Element)v.get(1599)).setAttribute("width","10" );
      ((Element)v.get(1598)).appendChild((Element)v.get(1599));
      /* Termina nodo:1599   */
      /* Termina nodo:1598   */

      /* Empieza nodo:1600 / Elemento padre: 1595   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1600)).setAttribute("class","tablaTitle" );
      ((Element)v.get(1600)).setAttribute("nombre","eduMatriCursoRemoveButtonTd" );
      ((Element)v.get(1595)).appendChild((Element)v.get(1600));

      /* Empieza nodo:1601 / Elemento padre: 1600   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1601)).setAttribute("nombre","eduMatriCursoRemoveButton" );
      ((Element)v.get(1601)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1601)).setAttribute("tipo","html" );
      ((Element)v.get(1601)).setAttribute("accion","eduMatriCursoRemoveSelection();" );
      ((Element)v.get(1601)).setAttribute("estado","false" );
      ((Element)v.get(1601)).setAttribute("cod","MMGGlobal.removeButton.label" );
      ((Element)v.get(1600)).appendChild((Element)v.get(1601));
      /* Termina nodo:1601   */
      /* Termina nodo:1600   */

      /* Empieza nodo:1602 / Elemento padre: 1595   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1602)).setAttribute("nombre","eduMatriCursoRemoveButtonGapTd" );
      ((Element)v.get(1595)).appendChild((Element)v.get(1602));

      /* Empieza nodo:1603 / Elemento padre: 1602   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1603)).setAttribute("src","b.gif" );
      ((Element)v.get(1603)).setAttribute("height","8" );
      ((Element)v.get(1603)).setAttribute("width","10" );
      ((Element)v.get(1602)).appendChild((Element)v.get(1603));
      /* Termina nodo:1603   */
      /* Termina nodo:1602   */

      /* Empieza nodo:1604 / Elemento padre: 1595   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1604)).setAttribute("class","tablaTitle" );
      ((Element)v.get(1604)).setAttribute("nombre","eduMatriCursoViewForRemoveButtonTd" );
      ((Element)v.get(1595)).appendChild((Element)v.get(1604));

      /* Empieza nodo:1605 / Elemento padre: 1604   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1605)).setAttribute("nombre","eduMatriCursoViewForRemoveButton" );
      ((Element)v.get(1605)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1605)).setAttribute("tipo","html" );
      ((Element)v.get(1605)).setAttribute("accion","eduMatriCursoViewSelection();" );
      ((Element)v.get(1605)).setAttribute("estado","false" );
      ((Element)v.get(1605)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(1604)).appendChild((Element)v.get(1605));
      /* Termina nodo:1605   */
      /* Termina nodo:1604   */

      /* Empieza nodo:1606 / Elemento padre: 1595   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1606)).setAttribute("nombre","eduMatriCursoViewForRemoveButtonGapTd" );
      ((Element)v.get(1595)).appendChild((Element)v.get(1606));

      /* Empieza nodo:1607 / Elemento padre: 1606   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1607)).setAttribute("src","b.gif" );
      ((Element)v.get(1607)).setAttribute("height","8" );
      ((Element)v.get(1607)).setAttribute("width","10" );
      ((Element)v.get(1606)).appendChild((Element)v.get(1607));
      /* Termina nodo:1607   */
      /* Termina nodo:1606   */

      /* Empieza nodo:1608 / Elemento padre: 1595   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1608)).setAttribute("class","tablaTitle" );
      ((Element)v.get(1608)).setAttribute("nombre","eduMatriCursoLovSelectButtonTd" );
      ((Element)v.get(1595)).appendChild((Element)v.get(1608));

      /* Empieza nodo:1609 / Elemento padre: 1608   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1609)).setAttribute("nombre","eduMatriCursoLovSelectButton" );
      ((Element)v.get(1609)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1609)).setAttribute("tipo","html" );
      ((Element)v.get(1609)).setAttribute("accion","eduMatriCursoLovSelectionAction();" );
      ((Element)v.get(1609)).setAttribute("estado","true" );
      ((Element)v.get(1609)).setAttribute("cod","MMGGlobal.lovSelectButton.label" );
      ((Element)v.get(1608)).appendChild((Element)v.get(1609));
      /* Termina nodo:1609   */
      /* Termina nodo:1608   */

      /* Empieza nodo:1610 / Elemento padre: 1595   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1610)).setAttribute("nombre","eduMatriCursoLovSelectButtonGapTd" );
      ((Element)v.get(1595)).appendChild((Element)v.get(1610));

      /* Empieza nodo:1611 / Elemento padre: 1610   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1611)).setAttribute("src","b.gif" );
      ((Element)v.get(1611)).setAttribute("height","8" );
      ((Element)v.get(1611)).setAttribute("width","10" );
      ((Element)v.get(1610)).appendChild((Element)v.get(1611));
      /* Termina nodo:1611   */
      /* Termina nodo:1610   */

      /* Empieza nodo:1612 / Elemento padre: 1595   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1612)).setAttribute("class","tablaTitle" );
      ((Element)v.get(1612)).setAttribute("nombre","eduMatriCursoViewButtonTd" );
      ((Element)v.get(1595)).appendChild((Element)v.get(1612));

      /* Empieza nodo:1613 / Elemento padre: 1612   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1613)).setAttribute("nombre","eduMatriCursoViewButton" );
      ((Element)v.get(1613)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1613)).setAttribute("tipo","html" );
      ((Element)v.get(1613)).setAttribute("accion","eduMatriCursoViewSelection();" );
   }

   private void getXML7380(Document doc) {
      ((Element)v.get(1613)).setAttribute("estado","false" );
      ((Element)v.get(1613)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(1612)).appendChild((Element)v.get(1613));
      /* Termina nodo:1613   */
      /* Termina nodo:1612   */

      /* Empieza nodo:1614 / Elemento padre: 1595   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1614)).setAttribute("nombre","eduMatriCursoViewButtonGapTd" );
      ((Element)v.get(1595)).appendChild((Element)v.get(1614));

      /* Empieza nodo:1615 / Elemento padre: 1614   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1615)).setAttribute("src","b.gif" );
      ((Element)v.get(1615)).setAttribute("height","8" );
      ((Element)v.get(1615)).setAttribute("width","10" );
      ((Element)v.get(1614)).appendChild((Element)v.get(1615));
      /* Termina nodo:1615   */
      /* Termina nodo:1614   */

      /* Empieza nodo:1616 / Elemento padre: 1595   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1595)).appendChild((Element)v.get(1616));

      /* Empieza nodo:1617 / Elemento padre: 1616   */
      v.add(doc.createElement("BOTONERA"));
      ((Element)v.get(1617)).setAttribute("nombre","eduMatriCursoPaginationButtonBar" );
      ((Element)v.get(1617)).setAttribute("tipo","H" );
      ((Element)v.get(1617)).setAttribute("x","0" );
      ((Element)v.get(1617)).setAttribute("y","0" );
      ((Element)v.get(1616)).appendChild((Element)v.get(1617));

      /* Empieza nodo:1618 / Elemento padre: 1617   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(1618)).setAttribute("nombre","eduMatriCursoFirstPageButton" );
      ((Element)v.get(1618)).setAttribute("funcion","eduMatriCursoFirstPage();" );
      ((Element)v.get(1618)).setAttribute("off","primera_over0.gif" );
      ((Element)v.get(1618)).setAttribute("on","primera_over0.gif" );
      ((Element)v.get(1618)).setAttribute("disable","primera_on0.gif" );
      ((Element)v.get(1618)).setAttribute("estado","inactivo" );
      ((Element)v.get(1617)).appendChild((Element)v.get(1618));
      /* Termina nodo:1618   */

      /* Empieza nodo:1619 / Elemento padre: 1617   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1619)).setAttribute("nombre","eduMatriCursoFirstPageButtonGapTd" );
      ((Element)v.get(1617)).appendChild((Element)v.get(1619));

      /* Empieza nodo:1620 / Elemento padre: 1619   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1620)).setAttribute("src","b.gif" );
      ((Element)v.get(1620)).setAttribute("height","8" );
      ((Element)v.get(1620)).setAttribute("width","8" );
      ((Element)v.get(1619)).appendChild((Element)v.get(1620));
      /* Termina nodo:1620   */
      /* Termina nodo:1619   */

      /* Empieza nodo:1621 / Elemento padre: 1617   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(1621)).setAttribute("nombre","eduMatriCursoPreviousPageButton" );
      ((Element)v.get(1621)).setAttribute("funcion","eduMatriCursoPreviousPage();" );
      ((Element)v.get(1621)).setAttribute("off","retroceder_over0.gif" );
      ((Element)v.get(1621)).setAttribute("on","retroceder_over0.gif" );
      ((Element)v.get(1621)).setAttribute("disable","retroceder_on0.gif" );
      ((Element)v.get(1621)).setAttribute("estado","inactivo" );
      ((Element)v.get(1617)).appendChild((Element)v.get(1621));
      /* Termina nodo:1621   */

      /* Empieza nodo:1622 / Elemento padre: 1617   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1622)).setAttribute("nombre","eduMatriCursoPreviousPageButtonGapTd" );
      ((Element)v.get(1617)).appendChild((Element)v.get(1622));

      /* Empieza nodo:1623 / Elemento padre: 1622   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1623)).setAttribute("src","b.gif" );
      ((Element)v.get(1623)).setAttribute("height","8" );
      ((Element)v.get(1623)).setAttribute("width","8" );
      ((Element)v.get(1622)).appendChild((Element)v.get(1623));
      /* Termina nodo:1623   */
      /* Termina nodo:1622   */

      /* Empieza nodo:1624 / Elemento padre: 1617   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(1624)).setAttribute("nombre","eduMatriCursoNextPageButton" );
      ((Element)v.get(1624)).setAttribute("funcion","eduMatriCursoNextPage();" );
      ((Element)v.get(1624)).setAttribute("off","avanzar_over0.gif" );
      ((Element)v.get(1624)).setAttribute("on","avanzar_over0.gif" );
      ((Element)v.get(1624)).setAttribute("disable","avanzar_on0.gif" );
      ((Element)v.get(1624)).setAttribute("estado","inactivo" );
      ((Element)v.get(1617)).appendChild((Element)v.get(1624));
      /* Termina nodo:1624   */
      /* Termina nodo:1617   */
      /* Termina nodo:1616   */

      /* Empieza nodo:1625 / Elemento padre: 1595   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1625)).setAttribute("width","100%" );
      ((Element)v.get(1595)).appendChild((Element)v.get(1625));
      /* Termina nodo:1625   */
      /* Termina nodo:1595   */
      /* Termina nodo:1594   */
      /* Termina nodo:4   */


   }

}

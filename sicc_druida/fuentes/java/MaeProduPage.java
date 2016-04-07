
import org.w3c.dom.*;
import java.util.ArrayList;

public class MaeProduPage  implements es.indra.druida.base.ObjetoXML {
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
         
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","MaeProduPage" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","maeProduInitComponents()" );
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
      ((Element)v.get(3)).setAttribute("src","maeprodu.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(4)).setAttribute("nombre","maeProduFrm" );
      ((Element)v.get(4)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(5)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(5)).setAttribute("valor","MaeProduLPExecution" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","ON" );
      ((Element)v.get(6)).setAttribute("valor","MaeProduLPExecution" );
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
      ((Element)v.get(36)).setAttribute("nombre","maeProduFormLayer" );
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
      ((Element)v.get(51)).setAttribute("cod","MaeProdu.legend.label" );
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
      ((Element)v.get(66)).setAttribute("cod","MaeProdu.id.label" );
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
      ((Element)v.get(69)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true)" );
      ((Element)v.get(69)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm', 0, false)" );
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
      ((Element)v.get(87)).setAttribute("nombre","paisOidPaisTdId" );
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
      ((Element)v.get(91)).setAttribute("nombre","lblpaisOidPais" );
      ((Element)v.get(91)).setAttribute("id","datosTitle" );
      ((Element)v.get(91)).setAttribute("ancho","150" );
      ((Element)v.get(91)).setAttribute("alto","13" );
      ((Element)v.get(91)).setAttribute("cod","MaeProdu.paisOidPais.label" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:92 / Elemento padre: 88   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(92)).setAttribute("nombre","paisOidPaisWidgetTrId" );
      ((Element)v.get(88)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(93)).setAttribute("align","left" );
      ((Element)v.get(93)).setAttribute("nowrap","true" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(94)).setAttribute("nombre","paisOidPais" );
      ((Element)v.get(94)).setAttribute("id","datosCampos" );
      ((Element)v.get(94)).setAttribute("multiple","N" );
      ((Element)v.get(94)).setAttribute("req","N" );
      ((Element)v.get(94)).setAttribute("size","1" );
      ((Element)v.get(94)).setAttribute("disabled","" );
      ((Element)v.get(94)).setAttribute("validacion","" );
      ((Element)v.get(94)).setAttribute("onchange","" );
      ((Element)v.get(94)).setAttribute("onfocus","" );
      ((Element)v.get(94)).setAttribute("valorinicial","" );
      ((Element)v.get(94)).setAttribute("textoinicial","" );
      ((Element)v.get(94)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true);" );
      ((Element)v.get(94)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm',0, false);" );
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
      ((Element)v.get(96)).setAttribute("nombre","paisOidPaisGapTdId" );
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
      ((Element)v.get(98)).setAttribute("width","100%" );
      ((Element)v.get(86)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */
      /* Termina nodo:81   */

      /* Empieza nodo:100 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(100)).setAttribute("nombre","formGapTr1" );
      ((Element)v.get(52)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("TD"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(101)).setAttribute("align","center" );
      ((Element)v.get(101)).setAttribute("width","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(102)).setAttribute("src","b.gif" );
      ((Element)v.get(102)).setAttribute("width","12" );
      ((Element)v.get(102)).setAttribute("height","8" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:103 / Elemento padre: 100   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(100)).appendChild((Element)v.get(103));

      /* Empieza nodo:104 / Elemento padre: 103   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(104)).setAttribute("src","b.gif" );
      ((Element)v.get(104)).setAttribute("width","8" );
      ((Element)v.get(104)).setAttribute("height","8" );
      ((Element)v.get(103)).appendChild((Element)v.get(104));
      /* Termina nodo:104   */
      /* Termina nodo:103   */

      /* Empieza nodo:105 / Elemento padre: 100   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(105)).setAttribute("align","center" );
      ((Element)v.get(105)).setAttribute("width","8" );
      ((Element)v.get(100)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(106)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).setAttribute("width","12" );
      ((Element)v.get(106)).setAttribute("height","8" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:100   */

      /* Empieza nodo:107 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(107)).setAttribute("nombre","formTr2" );
      ((Element)v.get(52)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(108)).setAttribute("align","center" );
      ((Element)v.get(108)).setAttribute("width","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(109)).setAttribute("src","b.gif" );
      ((Element)v.get(109)).setAttribute("width","8" );
      ((Element)v.get(109)).setAttribute("height","12" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));
      /* Termina nodo:109   */
      /* Termina nodo:108   */

      /* Empieza nodo:110 / Elemento padre: 107   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(110)).setAttribute("width","100%" );
      ((Element)v.get(107)).appendChild((Element)v.get(110));

      /* Empieza nodo:111 / Elemento padre: 110   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(111)).setAttribute("width","100%" );
      ((Element)v.get(111)).setAttribute("border","0" );
      ((Element)v.get(111)).setAttribute("cellspacing","0" );
      ((Element)v.get(111)).setAttribute("cellpadding","0" );
      ((Element)v.get(111)).setAttribute("align","left" );
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(112)).setAttribute("align","left" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(113)).setAttribute("nombre","codSapTdId" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(114)).setAttribute("width","100%" );
      ((Element)v.get(114)).setAttribute("border","0" );
      ((Element)v.get(114)).setAttribute("cellspacing","0" );
      ((Element)v.get(114)).setAttribute("cellpadding","0" );
      ((Element)v.get(114)).setAttribute("align","left" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));

      /* Empieza nodo:115 / Elemento padre: 114   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(114)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(116)).setAttribute("valign","top" );
      ((Element)v.get(116)).setAttribute("height","13" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(117)).setAttribute("nombre","lblCodSap" );
      ((Element)v.get(117)).setAttribute("alto","13" );
      ((Element)v.get(117)).setAttribute("filas","1" );
      ((Element)v.get(117)).setAttribute("id","datosTitle" );
      ((Element)v.get(117)).setAttribute("cod","MaeProdu.codSap.label" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:118 / Elemento padre: 114   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(118)).setAttribute("nombre","codSapWidgetTrId" );
      ((Element)v.get(114)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(119)).setAttribute("align","left" );
      ((Element)v.get(119)).setAttribute("nowrap","true" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(120)).setAttribute("nombre","codSap" );
      ((Element)v.get(120)).setAttribute("id","datosCampos" );
      ((Element)v.get(120)).setAttribute("trim","S" );
      ((Element)v.get(120)).setAttribute("max","20" );
      ((Element)v.get(120)).setAttribute("onchange","" );
      ((Element)v.get(120)).setAttribute("req","N" );
      ((Element)v.get(120)).setAttribute("size","20" );
      ((Element)v.get(120)).setAttribute("valor","" );
      ((Element)v.get(120)).setAttribute("validacion","" );
      ((Element)v.get(120)).setAttribute("disabled","" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(120)).setAttribute("onblur","" );
      ((Element)v.get(120)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true)" );
      ((Element)v.get(120)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm', 0, false)" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:121 / Elemento padre: 112   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(121)).setAttribute("nombre","codSapGapTdId" );
      ((Element)v.get(121)).setAttribute("nowrap","true" );
      ((Element)v.get(121)).setAttribute("class","datosCampos" );
      ((Element)v.get(112)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","25" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 112   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(123)).setAttribute("width","100%" );
      ((Element)v.get(112)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:107   */

      /* Empieza nodo:125 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(125)).setAttribute("nombre","formGapTr2" );
      ((Element)v.get(52)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(126)).setAttribute("align","center" );
      ((Element)v.get(126)).setAttribute("width","8" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(127)).setAttribute("src","b.gif" );
      ((Element)v.get(127)).setAttribute("width","12" );
      ((Element)v.get(127)).setAttribute("height","8" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */

      /* Empieza nodo:128 / Elemento padre: 125   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(125)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(129)).setAttribute("src","b.gif" );
      ((Element)v.get(129)).setAttribute("width","8" );
      ((Element)v.get(129)).setAttribute("height","8" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */

      /* Empieza nodo:130 / Elemento padre: 125   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(130)).setAttribute("align","center" );
      ((Element)v.get(130)).setAttribute("width","8" );
      ((Element)v.get(125)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(131)).setAttribute("src","b.gif" );
      ((Element)v.get(131)).setAttribute("width","12" );
      ((Element)v.get(131)).setAttribute("height","8" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:125   */

      /* Empieza nodo:132 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(132)).setAttribute("nombre","formTr3" );
      ((Element)v.get(52)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(133)).setAttribute("align","center" );
      ((Element)v.get(133)).setAttribute("width","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(134)).setAttribute("src","b.gif" );
      ((Element)v.get(134)).setAttribute("width","8" );
      ((Element)v.get(134)).setAttribute("height","12" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));
      /* Termina nodo:134   */
      /* Termina nodo:133   */

      /* Empieza nodo:135 / Elemento padre: 132   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(135)).setAttribute("width","100%" );
      ((Element)v.get(132)).appendChild((Element)v.get(135));

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
      ((Element)v.get(137)).setAttribute("align","left" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(138)).setAttribute("nombre","codiAntiTdId" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(139)).setAttribute("width","100%" );
      ((Element)v.get(139)).setAttribute("border","0" );
      ((Element)v.get(139)).setAttribute("cellspacing","0" );
      ((Element)v.get(139)).setAttribute("cellpadding","0" );
      ((Element)v.get(139)).setAttribute("align","left" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(141)).setAttribute("valign","top" );
      ((Element)v.get(141)).setAttribute("height","13" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(142)).setAttribute("nombre","lblCodiAnti" );
      ((Element)v.get(142)).setAttribute("alto","13" );
      ((Element)v.get(142)).setAttribute("filas","1" );
      ((Element)v.get(142)).setAttribute("id","datosTitle" );
      ((Element)v.get(142)).setAttribute("cod","MaeProdu.codiAnti.label" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */

      /* Empieza nodo:143 / Elemento padre: 139   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(143)).setAttribute("nombre","codiAntiWidgetTrId" );
      ((Element)v.get(139)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(144)).setAttribute("align","left" );
      ((Element)v.get(144)).setAttribute("nowrap","true" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(145)).setAttribute("nombre","codiAnti" );
      ((Element)v.get(145)).setAttribute("id","datosCampos" );
      ((Element)v.get(145)).setAttribute("trim","S" );
      ((Element)v.get(145)).setAttribute("max","18" );
      ((Element)v.get(145)).setAttribute("onchange","" );
      ((Element)v.get(145)).setAttribute("req","N" );
      ((Element)v.get(145)).setAttribute("size","18" );
      ((Element)v.get(145)).setAttribute("valor","" );
      ((Element)v.get(145)).setAttribute("validacion","" );
      ((Element)v.get(145)).setAttribute("disabled","" );
      ((Element)v.get(145)).setAttribute("onblur","" );
      ((Element)v.get(145)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true)" );
      ((Element)v.get(145)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm', 0, false)" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:139   */
      /* Termina nodo:138   */

      /* Empieza nodo:146 / Elemento padre: 137   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(146)).setAttribute("nombre","codiAntiGapTdId" );
      ((Element)v.get(146)).setAttribute("nowrap","true" );
      ((Element)v.get(146)).setAttribute("class","datosCampos" );
      ((Element)v.get(137)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).setAttribute("width","25" );
      ((Element)v.get(147)).setAttribute("height","8" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:148 / Elemento padre: 137   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(148)).setAttribute("width","100%" );
      ((Element)v.get(137)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:132   */

      /* Empieza nodo:150 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(150)).setAttribute("nombre","formGapTr3" );
      ((Element)v.get(52)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(151)).setAttribute("align","center" );
      ((Element)v.get(151)).setAttribute("width","8" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).setAttribute("width","12" );
      ((Element)v.get(152)).setAttribute("height","8" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:153 / Elemento padre: 150   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(150)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).setAttribute("width","8" );
      ((Element)v.get(154)).setAttribute("height","8" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 150   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(155)).setAttribute("align","center" );
      ((Element)v.get(155)).setAttribute("width","8" );
      ((Element)v.get(150)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","12" );
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:150   */

      /* Empieza nodo:157 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(157)).setAttribute("nombre","formTr4" );
      ((Element)v.get(52)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(158)).setAttribute("align","center" );
      ((Element)v.get(158)).setAttribute("width","8" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","8" );
      ((Element)v.get(159)).setAttribute("height","12" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 157   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(160)).setAttribute("width","100%" );
      ((Element)v.get(157)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(161)).setAttribute("width","100%" );
      ((Element)v.get(161)).setAttribute("border","0" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(161)).setAttribute("cellspacing","0" );
      ((Element)v.get(161)).setAttribute("cellpadding","0" );
      ((Element)v.get(161)).setAttribute("align","left" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(162)).setAttribute("align","left" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(163)).setAttribute("nombre","desCortTdId" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(164)).setAttribute("width","100%" );
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
      ((Element)v.get(167)).setAttribute("nombre","lblDesCort" );
      ((Element)v.get(167)).setAttribute("alto","13" );
      ((Element)v.get(167)).setAttribute("filas","1" );
      ((Element)v.get(167)).setAttribute("id","datosTitle" );
      ((Element)v.get(167)).setAttribute("cod","MaeProdu.desCort.label" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:168 / Elemento padre: 164   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(168)).setAttribute("nombre","desCortWidgetTrId" );
      ((Element)v.get(164)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(169)).setAttribute("align","left" );
      ((Element)v.get(169)).setAttribute("nowrap","true" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(170)).setAttribute("nombre","desCort" );
      ((Element)v.get(170)).setAttribute("id","datosCampos" );
      ((Element)v.get(170)).setAttribute("trim","S" );
      ((Element)v.get(170)).setAttribute("max","40" );
      ((Element)v.get(170)).setAttribute("onchange","" );
      ((Element)v.get(170)).setAttribute("req","N" );
      ((Element)v.get(170)).setAttribute("size","40" );
      ((Element)v.get(170)).setAttribute("valor","" );
      ((Element)v.get(170)).setAttribute("validacion","" );
      ((Element)v.get(170)).setAttribute("disabled","" );
      ((Element)v.get(170)).setAttribute("onblur","" );
      ((Element)v.get(170)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true)" );
      ((Element)v.get(170)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm', 0, false)" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:168   */
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:171 / Elemento padre: 162   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(171)).setAttribute("nombre","desCortGapTdId" );
      ((Element)v.get(171)).setAttribute("nowrap","true" );
      ((Element)v.get(171)).setAttribute("class","datosCampos" );
      ((Element)v.get(162)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(172)).setAttribute("src","b.gif" );
      ((Element)v.get(172)).setAttribute("width","25" );
      ((Element)v.get(172)).setAttribute("height","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:173 / Elemento padre: 162   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(173)).setAttribute("width","100%" );
      ((Element)v.get(162)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(174)).setAttribute("src","b.gif" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */
      /* Termina nodo:157   */

      /* Empieza nodo:175 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(175)).setAttribute("nombre","formGapTr4" );
      ((Element)v.get(52)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(176)).setAttribute("align","center" );
      ((Element)v.get(176)).setAttribute("width","8" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","12" );
      ((Element)v.get(177)).setAttribute("height","8" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:178 / Elemento padre: 175   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(175)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(179)).setAttribute("src","b.gif" );
      ((Element)v.get(179)).setAttribute("width","8" );
      ((Element)v.get(179)).setAttribute("height","8" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:180 / Elemento padre: 175   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(180)).setAttribute("align","center" );
      ((Element)v.get(180)).setAttribute("width","8" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(175)).appendChild((Element)v.get(180));

      /* Empieza nodo:181 / Elemento padre: 180   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(181)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).setAttribute("width","12" );
      ((Element)v.get(181)).setAttribute("height","8" );
      ((Element)v.get(180)).appendChild((Element)v.get(181));
      /* Termina nodo:181   */
      /* Termina nodo:180   */
      /* Termina nodo:175   */

      /* Empieza nodo:182 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(182)).setAttribute("nombre","formTr5" );
      ((Element)v.get(52)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(183)).setAttribute("align","center" );
      ((Element)v.get(183)).setAttribute("width","8" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(184)).setAttribute("src","b.gif" );
      ((Element)v.get(184)).setAttribute("width","8" );
      ((Element)v.get(184)).setAttribute("height","12" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */

      /* Empieza nodo:185 / Elemento padre: 182   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(185)).setAttribute("width","100%" );
      ((Element)v.get(182)).appendChild((Element)v.get(185));

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
      ((Element)v.get(187)).setAttribute("align","left" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(188)).setAttribute("nombre","valJera1TdId" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(189)).setAttribute("width","100%" );
      ((Element)v.get(189)).setAttribute("border","0" );
      ((Element)v.get(189)).setAttribute("cellspacing","0" );
      ((Element)v.get(189)).setAttribute("cellpadding","0" );
      ((Element)v.get(189)).setAttribute("align","left" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(191)).setAttribute("valign","top" );
      ((Element)v.get(191)).setAttribute("height","13" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(192)).setAttribute("nombre","lblValJera1" );
      ((Element)v.get(192)).setAttribute("alto","13" );
      ((Element)v.get(192)).setAttribute("filas","1" );
      ((Element)v.get(192)).setAttribute("id","datosTitle" );
      ((Element)v.get(192)).setAttribute("cod","MaeProdu.valJera1.label" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:193 / Elemento padre: 189   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(193)).setAttribute("nombre","valJera1WidgetTrId" );
      ((Element)v.get(189)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(194)).setAttribute("align","left" );
      ((Element)v.get(194)).setAttribute("nowrap","true" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(195)).setAttribute("nombre","valJera1" );
      ((Element)v.get(195)).setAttribute("id","datosCampos" );
      ((Element)v.get(195)).setAttribute("trim","S" );
      ((Element)v.get(195)).setAttribute("max","3" );
      ((Element)v.get(195)).setAttribute("onchange","" );
      ((Element)v.get(195)).setAttribute("req","N" );
      ((Element)v.get(195)).setAttribute("size","3" );
      ((Element)v.get(195)).setAttribute("valor","" );
      ((Element)v.get(195)).setAttribute("validacion","" );
      ((Element)v.get(195)).setAttribute("disabled","" );
      ((Element)v.get(195)).setAttribute("onblur","" );
      ((Element)v.get(195)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true)" );
      ((Element)v.get(195)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm', 0, false)" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:189   */
      /* Termina nodo:188   */

      /* Empieza nodo:196 / Elemento padre: 187   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(196)).setAttribute("nombre","valJera1GapTdId" );
      ((Element)v.get(196)).setAttribute("nowrap","true" );
      ((Element)v.get(196)).setAttribute("class","datosCampos" );
      ((Element)v.get(187)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(197)).setAttribute("src","b.gif" );
      ((Element)v.get(197)).setAttribute("width","25" );
      ((Element)v.get(197)).setAttribute("height","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:198 / Elemento padre: 187   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(198)).setAttribute("width","100%" );
      ((Element)v.get(187)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(199)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));
      /* Termina nodo:199   */
      /* Termina nodo:198   */
      /* Termina nodo:187   */
      /* Termina nodo:186   */
      /* Termina nodo:185   */
      /* Termina nodo:182   */

      /* Empieza nodo:200 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(200)).setAttribute("nombre","formGapTr5" );
      ((Element)v.get(52)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(201)).setAttribute("align","center" );
      ((Element)v.get(201)).setAttribute("width","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(202)).setAttribute("src","b.gif" );
      ((Element)v.get(202)).setAttribute("width","12" );
      ((Element)v.get(202)).setAttribute("height","8" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */

      /* Empieza nodo:203 / Elemento padre: 200   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(200)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(204)).setAttribute("src","b.gif" );
      ((Element)v.get(204)).setAttribute("width","8" );
      ((Element)v.get(204)).setAttribute("height","8" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */

      /* Empieza nodo:205 / Elemento padre: 200   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(205)).setAttribute("align","center" );
      ((Element)v.get(205)).setAttribute("width","8" );
      ((Element)v.get(200)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).setAttribute("width","12" );
      ((Element)v.get(206)).setAttribute("height","8" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */
      /* Termina nodo:200   */

      /* Empieza nodo:207 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(207)).setAttribute("nombre","formTr6" );
      ((Element)v.get(52)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(208)).setAttribute("align","center" );
      ((Element)v.get(208)).setAttribute("width","8" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(209)).setAttribute("src","b.gif" );
      ((Element)v.get(209)).setAttribute("width","8" );
      ((Element)v.get(209)).setAttribute("height","12" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:210 / Elemento padre: 207   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(210)).setAttribute("width","100%" );
      ((Element)v.get(207)).appendChild((Element)v.get(210));

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
      ((Element)v.get(212)).setAttribute("align","left" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(213)).setAttribute("nombre","valJera2TdId" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(214)).setAttribute("width","100%" );
      ((Element)v.get(214)).setAttribute("border","0" );
      ((Element)v.get(214)).setAttribute("cellspacing","0" );
      ((Element)v.get(214)).setAttribute("cellpadding","0" );
      ((Element)v.get(214)).setAttribute("align","left" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(214)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(216)).setAttribute("valign","top" );
      ((Element)v.get(216)).setAttribute("height","13" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(217)).setAttribute("nombre","lblValJera2" );
      ((Element)v.get(217)).setAttribute("alto","13" );
      ((Element)v.get(217)).setAttribute("filas","1" );
      ((Element)v.get(217)).setAttribute("id","datosTitle" );
      ((Element)v.get(217)).setAttribute("cod","MaeProdu.valJera2.label" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:218 / Elemento padre: 214   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(218)).setAttribute("nombre","valJera2WidgetTrId" );
      ((Element)v.get(214)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(219)).setAttribute("align","left" );
      ((Element)v.get(219)).setAttribute("nowrap","true" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(220)).setAttribute("nombre","valJera2" );
      ((Element)v.get(220)).setAttribute("id","datosCampos" );
      ((Element)v.get(220)).setAttribute("trim","S" );
      ((Element)v.get(220)).setAttribute("max","3" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(220)).setAttribute("onchange","" );
      ((Element)v.get(220)).setAttribute("req","N" );
      ((Element)v.get(220)).setAttribute("size","3" );
      ((Element)v.get(220)).setAttribute("valor","" );
      ((Element)v.get(220)).setAttribute("validacion","" );
      ((Element)v.get(220)).setAttribute("disabled","" );
      ((Element)v.get(220)).setAttribute("onblur","" );
      ((Element)v.get(220)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true)" );
      ((Element)v.get(220)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm', 0, false)" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:221 / Elemento padre: 212   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(221)).setAttribute("nombre","valJera2GapTdId" );
      ((Element)v.get(221)).setAttribute("nowrap","true" );
      ((Element)v.get(221)).setAttribute("class","datosCampos" );
      ((Element)v.get(212)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(222)).setAttribute("width","25" );
      ((Element)v.get(222)).setAttribute("height","8" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:223 / Elemento padre: 212   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(223)).setAttribute("width","100%" );
      ((Element)v.get(212)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(224)).setAttribute("src","b.gif" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:210   */
      /* Termina nodo:207   */

      /* Empieza nodo:225 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(225)).setAttribute("nombre","formGapTr6" );
      ((Element)v.get(52)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(226)).setAttribute("align","center" );
      ((Element)v.get(226)).setAttribute("width","8" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).setAttribute("width","12" );
      ((Element)v.get(227)).setAttribute("height","8" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */

      /* Empieza nodo:228 / Elemento padre: 225   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(225)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(229)).setAttribute("src","b.gif" );
      ((Element)v.get(229)).setAttribute("width","8" );
      ((Element)v.get(229)).setAttribute("height","8" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:230 / Elemento padre: 225   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(230)).setAttribute("align","center" );
      ((Element)v.get(230)).setAttribute("width","8" );
      ((Element)v.get(225)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(231)).setAttribute("src","b.gif" );
      ((Element)v.get(231)).setAttribute("width","12" );
      ((Element)v.get(231)).setAttribute("height","8" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */
      /* Termina nodo:225   */

      /* Empieza nodo:232 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(232)).setAttribute("nombre","formTr7" );
      ((Element)v.get(52)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(233)).setAttribute("align","center" );
      ((Element)v.get(233)).setAttribute("width","8" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(234)).setAttribute("src","b.gif" );
      ((Element)v.get(234)).setAttribute("width","8" );
      ((Element)v.get(234)).setAttribute("height","12" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));
      /* Termina nodo:234   */
      /* Termina nodo:233   */

      /* Empieza nodo:235 / Elemento padre: 232   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(235)).setAttribute("width","100%" );
      ((Element)v.get(232)).appendChild((Element)v.get(235));

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
      ((Element)v.get(237)).setAttribute("align","left" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(238)).setAttribute("nombre","valJera3TdId" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(239)).setAttribute("width","100%" );
      ((Element)v.get(239)).setAttribute("border","0" );
      ((Element)v.get(239)).setAttribute("cellspacing","0" );
      ((Element)v.get(239)).setAttribute("cellpadding","0" );
      ((Element)v.get(239)).setAttribute("align","left" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("TR"));
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(239)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(241)).setAttribute("valign","top" );
      ((Element)v.get(241)).setAttribute("height","13" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(242)).setAttribute("nombre","lblValJera3" );
      ((Element)v.get(242)).setAttribute("alto","13" );
      ((Element)v.get(242)).setAttribute("filas","1" );
      ((Element)v.get(242)).setAttribute("id","datosTitle" );
      ((Element)v.get(242)).setAttribute("cod","MaeProdu.valJera3.label" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */
      /* Termina nodo:240   */

      /* Empieza nodo:243 / Elemento padre: 239   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(243)).setAttribute("nombre","valJera3WidgetTrId" );
      ((Element)v.get(239)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(244)).setAttribute("align","left" );
      ((Element)v.get(244)).setAttribute("nowrap","true" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(245)).setAttribute("nombre","valJera3" );
      ((Element)v.get(245)).setAttribute("id","datosCampos" );
      ((Element)v.get(245)).setAttribute("trim","S" );
      ((Element)v.get(245)).setAttribute("max","3" );
      ((Element)v.get(245)).setAttribute("onchange","" );
      ((Element)v.get(245)).setAttribute("req","N" );
      ((Element)v.get(245)).setAttribute("size","3" );
      ((Element)v.get(245)).setAttribute("valor","" );
      ((Element)v.get(245)).setAttribute("validacion","" );
      ((Element)v.get(245)).setAttribute("disabled","" );
      ((Element)v.get(245)).setAttribute("onblur","" );
      ((Element)v.get(245)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true)" );
      ((Element)v.get(245)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm', 0, false)" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */
      /* Termina nodo:243   */
      /* Termina nodo:239   */
      /* Termina nodo:238   */

      /* Empieza nodo:246 / Elemento padre: 237   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(246)).setAttribute("nombre","valJera3GapTdId" );
      ((Element)v.get(246)).setAttribute("nowrap","true" );
      ((Element)v.get(246)).setAttribute("class","datosCampos" );
      ((Element)v.get(237)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(247)).setAttribute("src","b.gif" );
      ((Element)v.get(247)).setAttribute("width","25" );
      ((Element)v.get(247)).setAttribute("height","8" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:248 / Elemento padre: 237   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(248)).setAttribute("width","100%" );
      ((Element)v.get(237)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(249)).setAttribute("src","b.gif" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */
      /* Termina nodo:237   */
      /* Termina nodo:236   */
      /* Termina nodo:235   */
      /* Termina nodo:232   */

      /* Empieza nodo:250 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(250)).setAttribute("nombre","formGapTr7" );
      ((Element)v.get(52)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(251)).setAttribute("align","center" );
      ((Element)v.get(251)).setAttribute("width","8" );
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
      ((Element)v.get(255)).setAttribute("width","8" );
      ((Element)v.get(250)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(256)).setAttribute("src","b.gif" );
      ((Element)v.get(256)).setAttribute("width","12" );
      ((Element)v.get(256)).setAttribute("height","8" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */
      /* Termina nodo:250   */

      /* Empieza nodo:257 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(257)).setAttribute("nombre","formTr8" );
      ((Element)v.get(52)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(258)).setAttribute("align","center" );
      ((Element)v.get(258)).setAttribute("width","8" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(259)).setAttribute("src","b.gif" );
      ((Element)v.get(259)).setAttribute("width","8" );
      ((Element)v.get(259)).setAttribute("height","12" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */

      /* Empieza nodo:260 / Elemento padre: 257   */
   }

   private void getXML1170(Document doc) {
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
      ((Element)v.get(263)).setAttribute("nombre","valAtri1TdId" );
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
      ((Element)v.get(267)).setAttribute("nombre","lblValAtri1" );
      ((Element)v.get(267)).setAttribute("alto","13" );
      ((Element)v.get(267)).setAttribute("filas","1" );
      ((Element)v.get(267)).setAttribute("id","datosTitle" );
      ((Element)v.get(267)).setAttribute("cod","MaeProdu.valAtri1.label" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */
      /* Termina nodo:265   */

      /* Empieza nodo:268 / Elemento padre: 264   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(268)).setAttribute("nombre","valAtri1WidgetTrId" );
      ((Element)v.get(264)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(269)).setAttribute("align","left" );
      ((Element)v.get(269)).setAttribute("nowrap","true" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(270)).setAttribute("nombre","valAtri1" );
      ((Element)v.get(270)).setAttribute("id","datosCampos" );
      ((Element)v.get(270)).setAttribute("trim","S" );
      ((Element)v.get(270)).setAttribute("max","3" );
      ((Element)v.get(270)).setAttribute("onchange","" );
      ((Element)v.get(270)).setAttribute("req","N" );
      ((Element)v.get(270)).setAttribute("size","3" );
      ((Element)v.get(270)).setAttribute("valor","" );
      ((Element)v.get(270)).setAttribute("validacion","" );
      ((Element)v.get(270)).setAttribute("disabled","" );
      ((Element)v.get(270)).setAttribute("onblur","" );
      ((Element)v.get(270)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true)" );
      ((Element)v.get(270)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm', 0, false)" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:269   */
      /* Termina nodo:268   */
      /* Termina nodo:264   */
      /* Termina nodo:263   */

      /* Empieza nodo:271 / Elemento padre: 262   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(271)).setAttribute("nombre","valAtri1GapTdId" );
      ((Element)v.get(271)).setAttribute("nowrap","true" );
      ((Element)v.get(271)).setAttribute("class","datosCampos" );
      ((Element)v.get(262)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(272)).setAttribute("src","b.gif" );
      ((Element)v.get(272)).setAttribute("width","25" );
      ((Element)v.get(272)).setAttribute("height","8" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));
      /* Termina nodo:272   */
      /* Termina nodo:271   */

      /* Empieza nodo:273 / Elemento padre: 262   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(273)).setAttribute("width","100%" );
      ((Element)v.get(262)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(274)).setAttribute("src","b.gif" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */
      /* Termina nodo:262   */
      /* Termina nodo:261   */
      /* Termina nodo:260   */
      /* Termina nodo:257   */

      /* Empieza nodo:275 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(275)).setAttribute("nombre","formGapTr8" );
      ((Element)v.get(52)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(276)).setAttribute("align","center" );
      ((Element)v.get(276)).setAttribute("width","8" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(277)).setAttribute("src","b.gif" );
      ((Element)v.get(277)).setAttribute("width","12" );
      ((Element)v.get(277)).setAttribute("height","8" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:276   */

      /* Empieza nodo:278 / Elemento padre: 275   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(275)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(279)).setAttribute("src","b.gif" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(279)).setAttribute("width","8" );
      ((Element)v.get(279)).setAttribute("height","8" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));
      /* Termina nodo:279   */
      /* Termina nodo:278   */

      /* Empieza nodo:280 / Elemento padre: 275   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(280)).setAttribute("align","center" );
      ((Element)v.get(280)).setAttribute("width","8" );
      ((Element)v.get(275)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(281)).setAttribute("src","b.gif" );
      ((Element)v.get(281)).setAttribute("width","12" );
      ((Element)v.get(281)).setAttribute("height","8" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));
      /* Termina nodo:281   */
      /* Termina nodo:280   */
      /* Termina nodo:275   */

      /* Empieza nodo:282 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(282)).setAttribute("nombre","formTr9" );
      ((Element)v.get(52)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(283)).setAttribute("align","center" );
      ((Element)v.get(283)).setAttribute("width","8" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(284)).setAttribute("src","b.gif" );
      ((Element)v.get(284)).setAttribute("width","8" );
      ((Element)v.get(284)).setAttribute("height","12" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:285 / Elemento padre: 282   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(285)).setAttribute("width","100%" );
      ((Element)v.get(282)).appendChild((Element)v.get(285));

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
      ((Element)v.get(287)).setAttribute("align","left" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(288)).setAttribute("nombre","valAtri2TdId" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));

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
      ((Element)v.get(289)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(291)).setAttribute("valign","top" );
      ((Element)v.get(291)).setAttribute("height","13" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(292)).setAttribute("nombre","lblValAtri2" );
      ((Element)v.get(292)).setAttribute("alto","13" );
      ((Element)v.get(292)).setAttribute("filas","1" );
      ((Element)v.get(292)).setAttribute("id","datosTitle" );
      ((Element)v.get(292)).setAttribute("cod","MaeProdu.valAtri2.label" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:291   */
      /* Termina nodo:290   */

      /* Empieza nodo:293 / Elemento padre: 289   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(293)).setAttribute("nombre","valAtri2WidgetTrId" );
      ((Element)v.get(289)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(294)).setAttribute("align","left" );
      ((Element)v.get(294)).setAttribute("nowrap","true" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(295)).setAttribute("nombre","valAtri2" );
      ((Element)v.get(295)).setAttribute("id","datosCampos" );
      ((Element)v.get(295)).setAttribute("trim","S" );
      ((Element)v.get(295)).setAttribute("max","4" );
      ((Element)v.get(295)).setAttribute("onchange","" );
      ((Element)v.get(295)).setAttribute("req","N" );
      ((Element)v.get(295)).setAttribute("size","4" );
      ((Element)v.get(295)).setAttribute("valor","" );
      ((Element)v.get(295)).setAttribute("validacion","" );
      ((Element)v.get(295)).setAttribute("disabled","" );
      ((Element)v.get(295)).setAttribute("onblur","" );
      ((Element)v.get(295)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true)" );
      ((Element)v.get(295)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm', 0, false)" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */
      /* Termina nodo:293   */
      /* Termina nodo:289   */
      /* Termina nodo:288   */

      /* Empieza nodo:296 / Elemento padre: 287   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(296)).setAttribute("nombre","valAtri2GapTdId" );
      ((Element)v.get(296)).setAttribute("nowrap","true" );
      ((Element)v.get(296)).setAttribute("class","datosCampos" );
      ((Element)v.get(287)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(297)).setAttribute("src","b.gif" );
      ((Element)v.get(297)).setAttribute("width","25" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(297)).setAttribute("height","8" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:296   */

      /* Empieza nodo:298 / Elemento padre: 287   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(298)).setAttribute("width","100%" );
      ((Element)v.get(287)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(299)).setAttribute("src","b.gif" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */
      /* Termina nodo:298   */
      /* Termina nodo:287   */
      /* Termina nodo:286   */
      /* Termina nodo:285   */
      /* Termina nodo:282   */

      /* Empieza nodo:300 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(300)).setAttribute("nombre","formGapTr9" );
      ((Element)v.get(52)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(301)).setAttribute("align","center" );
      ((Element)v.get(301)).setAttribute("width","8" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(302)).setAttribute("src","b.gif" );
      ((Element)v.get(302)).setAttribute("width","12" );
      ((Element)v.get(302)).setAttribute("height","8" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */

      /* Empieza nodo:303 / Elemento padre: 300   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(300)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(304)).setAttribute("src","b.gif" );
      ((Element)v.get(304)).setAttribute("width","8" );
      ((Element)v.get(304)).setAttribute("height","8" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */

      /* Empieza nodo:305 / Elemento padre: 300   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(305)).setAttribute("align","center" );
      ((Element)v.get(305)).setAttribute("width","8" );
      ((Element)v.get(300)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(306)).setAttribute("src","b.gif" );
      ((Element)v.get(306)).setAttribute("width","12" );
      ((Element)v.get(306)).setAttribute("height","8" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */
      /* Termina nodo:300   */

      /* Empieza nodo:307 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(307)).setAttribute("nombre","formTr10" );
      ((Element)v.get(52)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(308)).setAttribute("align","center" );
      ((Element)v.get(308)).setAttribute("width","8" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(309)).setAttribute("src","b.gif" );
      ((Element)v.get(309)).setAttribute("width","8" );
      ((Element)v.get(309)).setAttribute("height","12" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */
      /* Termina nodo:308   */

      /* Empieza nodo:310 / Elemento padre: 307   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(310)).setAttribute("width","100%" );
      ((Element)v.get(307)).appendChild((Element)v.get(310));

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
      ((Element)v.get(312)).setAttribute("align","left" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(313)).setAttribute("nombre","valAtri3TdId" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(314)).setAttribute("width","100%" );
      ((Element)v.get(314)).setAttribute("border","0" );
      ((Element)v.get(314)).setAttribute("cellspacing","0" );
      ((Element)v.get(314)).setAttribute("cellpadding","0" );
      ((Element)v.get(314)).setAttribute("align","left" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(314)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(316)).setAttribute("valign","top" );
      ((Element)v.get(316)).setAttribute("height","13" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(317)).setAttribute("nombre","lblValAtri3" );
      ((Element)v.get(317)).setAttribute("alto","13" );
      ((Element)v.get(317)).setAttribute("filas","1" );
      ((Element)v.get(317)).setAttribute("id","datosTitle" );
      ((Element)v.get(317)).setAttribute("cod","MaeProdu.valAtri3.label" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:318 / Elemento padre: 314   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(318)).setAttribute("nombre","valAtri3WidgetTrId" );
      ((Element)v.get(314)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(319)).setAttribute("align","left" );
      ((Element)v.get(319)).setAttribute("nowrap","true" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(318)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(320)).setAttribute("nombre","valAtri3" );
      ((Element)v.get(320)).setAttribute("id","datosCampos" );
      ((Element)v.get(320)).setAttribute("trim","S" );
      ((Element)v.get(320)).setAttribute("max","10" );
      ((Element)v.get(320)).setAttribute("onchange","" );
      ((Element)v.get(320)).setAttribute("req","N" );
      ((Element)v.get(320)).setAttribute("size","10" );
      ((Element)v.get(320)).setAttribute("valor","" );
      ((Element)v.get(320)).setAttribute("validacion","" );
      ((Element)v.get(320)).setAttribute("disabled","" );
      ((Element)v.get(320)).setAttribute("onblur","" );
      ((Element)v.get(320)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true)" );
      ((Element)v.get(320)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm', 0, false)" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */
      /* Termina nodo:318   */
      /* Termina nodo:314   */
      /* Termina nodo:313   */

      /* Empieza nodo:321 / Elemento padre: 312   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(321)).setAttribute("nombre","valAtri3GapTdId" );
      ((Element)v.get(321)).setAttribute("nowrap","true" );
      ((Element)v.get(321)).setAttribute("class","datosCampos" );
      ((Element)v.get(312)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(322)).setAttribute("src","b.gif" );
      ((Element)v.get(322)).setAttribute("width","25" );
      ((Element)v.get(322)).setAttribute("height","8" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */
      /* Termina nodo:321   */

      /* Empieza nodo:323 / Elemento padre: 312   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(323)).setAttribute("width","100%" );
      ((Element)v.get(312)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(324)).setAttribute("src","b.gif" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */
      /* Termina nodo:323   */
      /* Termina nodo:312   */
      /* Termina nodo:311   */
      /* Termina nodo:310   */
      /* Termina nodo:307   */

      /* Empieza nodo:325 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(325)).setAttribute("nombre","formGapTr10" );
      ((Element)v.get(52)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(326)).setAttribute("align","center" );
      ((Element)v.get(326)).setAttribute("width","8" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(327)).setAttribute("src","b.gif" );
      ((Element)v.get(327)).setAttribute("width","12" );
      ((Element)v.get(327)).setAttribute("height","8" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:326   */

      /* Empieza nodo:328 / Elemento padre: 325   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(325)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(329)).setAttribute("src","b.gif" );
      ((Element)v.get(329)).setAttribute("width","8" );
      ((Element)v.get(329)).setAttribute("height","8" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:328   */

      /* Empieza nodo:330 / Elemento padre: 325   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(330)).setAttribute("align","center" );
      ((Element)v.get(330)).setAttribute("width","8" );
      ((Element)v.get(325)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(331)).setAttribute("src","b.gif" );
      ((Element)v.get(331)).setAttribute("width","12" );
      ((Element)v.get(331)).setAttribute("height","8" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));
      /* Termina nodo:331   */
      /* Termina nodo:330   */
      /* Termina nodo:325   */

      /* Empieza nodo:332 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(332)).setAttribute("nombre","formTr11" );
      ((Element)v.get(52)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(333)).setAttribute("align","center" );
      ((Element)v.get(333)).setAttribute("width","8" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(334)).setAttribute("src","b.gif" );
      ((Element)v.get(334)).setAttribute("width","8" );
      ((Element)v.get(334)).setAttribute("height","12" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:335 / Elemento padre: 332   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(335)).setAttribute("width","100%" );
      ((Element)v.get(332)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(336)).setAttribute("width","100%" );
      ((Element)v.get(336)).setAttribute("border","0" );
      ((Element)v.get(336)).setAttribute("cellspacing","0" );
      ((Element)v.get(336)).setAttribute("cellpadding","0" );
      ((Element)v.get(336)).setAttribute("align","left" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(337)).setAttribute("align","left" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(338)).setAttribute("nombre","valDimeAltoTdId" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(339)).setAttribute("width","100%" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(339)).setAttribute("border","0" );
      ((Element)v.get(339)).setAttribute("cellspacing","0" );
      ((Element)v.get(339)).setAttribute("cellpadding","0" );
      ((Element)v.get(339)).setAttribute("align","left" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(339)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(341)).setAttribute("valign","top" );
      ((Element)v.get(341)).setAttribute("height","13" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(342)).setAttribute("nombre","lblValDimeAlto" );
      ((Element)v.get(342)).setAttribute("alto","13" );
      ((Element)v.get(342)).setAttribute("filas","1" );
      ((Element)v.get(342)).setAttribute("id","datosTitle" );
      ((Element)v.get(342)).setAttribute("cod","MaeProdu.valDimeAlto.label" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */
      /* Termina nodo:340   */

      /* Empieza nodo:343 / Elemento padre: 339   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(343)).setAttribute("nombre","valDimeAltoWidgetTrId" );
      ((Element)v.get(339)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(344)).setAttribute("align","left" );
      ((Element)v.get(344)).setAttribute("nowrap","true" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(345)).setAttribute("nombre","valDimeAlto" );
      ((Element)v.get(345)).setAttribute("id","datosCampos" );
      ((Element)v.get(345)).setAttribute("trim","S" );
      ((Element)v.get(345)).setAttribute("max","6" );
      ((Element)v.get(345)).setAttribute("onchange","" );
      ((Element)v.get(345)).setAttribute("req","N" );
      ((Element)v.get(345)).setAttribute("size","6" );
      ((Element)v.get(345)).setAttribute("valor","" );
      ((Element)v.get(345)).setAttribute("validacion","" );
      ((Element)v.get(345)).setAttribute("disabled","" );
      ((Element)v.get(345)).setAttribute("onblur","" );
      ((Element)v.get(345)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true)" );
      ((Element)v.get(345)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm', 0, false)" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */
      /* Termina nodo:344   */
      /* Termina nodo:343   */
      /* Termina nodo:339   */
      /* Termina nodo:338   */

      /* Empieza nodo:346 / Elemento padre: 337   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(346)).setAttribute("nombre","valDimeAltoGapTdId" );
      ((Element)v.get(346)).setAttribute("nowrap","true" );
      ((Element)v.get(346)).setAttribute("class","datosCampos" );
      ((Element)v.get(337)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(347)).setAttribute("src","b.gif" );
      ((Element)v.get(347)).setAttribute("width","25" );
      ((Element)v.get(347)).setAttribute("height","8" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */
      /* Termina nodo:346   */

      /* Empieza nodo:348 / Elemento padre: 337   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(348)).setAttribute("width","100%" );
      ((Element)v.get(337)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(349)).setAttribute("src","b.gif" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));
      /* Termina nodo:349   */
      /* Termina nodo:348   */
      /* Termina nodo:337   */
      /* Termina nodo:336   */
      /* Termina nodo:335   */
      /* Termina nodo:332   */

      /* Empieza nodo:350 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(350)).setAttribute("nombre","formGapTr11" );
      ((Element)v.get(52)).appendChild((Element)v.get(350));

      /* Empieza nodo:351 / Elemento padre: 350   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(351)).setAttribute("align","center" );
      ((Element)v.get(351)).setAttribute("width","8" );
      ((Element)v.get(350)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(352)).setAttribute("src","b.gif" );
      ((Element)v.get(352)).setAttribute("width","12" );
      ((Element)v.get(352)).setAttribute("height","8" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */
      /* Termina nodo:351   */

      /* Empieza nodo:353 / Elemento padre: 350   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(350)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(354)).setAttribute("src","b.gif" );
      ((Element)v.get(354)).setAttribute("width","8" );
      ((Element)v.get(354)).setAttribute("height","8" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */
      /* Termina nodo:353   */

      /* Empieza nodo:355 / Elemento padre: 350   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(355)).setAttribute("align","center" );
      ((Element)v.get(355)).setAttribute("width","8" );
      ((Element)v.get(350)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(356)).setAttribute("src","b.gif" );
      ((Element)v.get(356)).setAttribute("width","12" );
      ((Element)v.get(356)).setAttribute("height","8" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */
      /* Termina nodo:355   */
      /* Termina nodo:350   */

      /* Empieza nodo:357 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(357)).setAttribute("nombre","formTr12" );
      ((Element)v.get(52)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(358)).setAttribute("align","center" );
      ((Element)v.get(358)).setAttribute("width","8" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(357)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(359)).setAttribute("src","b.gif" );
      ((Element)v.get(359)).setAttribute("width","8" );
      ((Element)v.get(359)).setAttribute("height","12" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */
      /* Termina nodo:358   */

      /* Empieza nodo:360 / Elemento padre: 357   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(360)).setAttribute("width","100%" );
      ((Element)v.get(357)).appendChild((Element)v.get(360));

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
      ((Element)v.get(362)).setAttribute("align","left" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(363)).setAttribute("nombre","valDimeLargTdId" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(364)).setAttribute("width","100%" );
      ((Element)v.get(364)).setAttribute("border","0" );
      ((Element)v.get(364)).setAttribute("cellspacing","0" );
      ((Element)v.get(364)).setAttribute("cellpadding","0" );
      ((Element)v.get(364)).setAttribute("align","left" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(364)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(366)).setAttribute("valign","top" );
      ((Element)v.get(366)).setAttribute("height","13" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(367)).setAttribute("nombre","lblValDimeLarg" );
      ((Element)v.get(367)).setAttribute("alto","13" );
      ((Element)v.get(367)).setAttribute("filas","1" );
      ((Element)v.get(367)).setAttribute("id","datosTitle" );
      ((Element)v.get(367)).setAttribute("cod","MaeProdu.valDimeLarg.label" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */
      /* Termina nodo:366   */
      /* Termina nodo:365   */

      /* Empieza nodo:368 / Elemento padre: 364   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(368)).setAttribute("nombre","valDimeLargWidgetTrId" );
      ((Element)v.get(364)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(369)).setAttribute("align","left" );
      ((Element)v.get(369)).setAttribute("nowrap","true" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(370)).setAttribute("nombre","valDimeLarg" );
      ((Element)v.get(370)).setAttribute("id","datosCampos" );
      ((Element)v.get(370)).setAttribute("trim","S" );
      ((Element)v.get(370)).setAttribute("max","6" );
      ((Element)v.get(370)).setAttribute("onchange","" );
      ((Element)v.get(370)).setAttribute("req","N" );
      ((Element)v.get(370)).setAttribute("size","6" );
      ((Element)v.get(370)).setAttribute("valor","" );
      ((Element)v.get(370)).setAttribute("validacion","" );
      ((Element)v.get(370)).setAttribute("disabled","" );
      ((Element)v.get(370)).setAttribute("onblur","" );
      ((Element)v.get(370)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true)" );
      ((Element)v.get(370)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm', 0, false)" );
      ((Element)v.get(369)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */
      /* Termina nodo:369   */
      /* Termina nodo:368   */
      /* Termina nodo:364   */
      /* Termina nodo:363   */

      /* Empieza nodo:371 / Elemento padre: 362   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(371)).setAttribute("nombre","valDimeLargGapTdId" );
      ((Element)v.get(371)).setAttribute("nowrap","true" );
      ((Element)v.get(371)).setAttribute("class","datosCampos" );
      ((Element)v.get(362)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(372)).setAttribute("src","b.gif" );
      ((Element)v.get(372)).setAttribute("width","25" );
      ((Element)v.get(372)).setAttribute("height","8" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));
      /* Termina nodo:372   */
      /* Termina nodo:371   */

      /* Empieza nodo:373 / Elemento padre: 362   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(373)).setAttribute("width","100%" );
      ((Element)v.get(362)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(374)).setAttribute("src","b.gif" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));
      /* Termina nodo:374   */
      /* Termina nodo:373   */
      /* Termina nodo:362   */
      /* Termina nodo:361   */
      /* Termina nodo:360   */
      /* Termina nodo:357   */

      /* Empieza nodo:375 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(375)).setAttribute("nombre","formGapTr12" );
      ((Element)v.get(52)).appendChild((Element)v.get(375));

      /* Empieza nodo:376 / Elemento padre: 375   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(376)).setAttribute("align","center" );
      ((Element)v.get(376)).setAttribute("width","8" );
      ((Element)v.get(375)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(377)).setAttribute("src","b.gif" );
      ((Element)v.get(377)).setAttribute("width","12" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(377)).setAttribute("height","8" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */
      /* Termina nodo:376   */

      /* Empieza nodo:378 / Elemento padre: 375   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(375)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(379)).setAttribute("src","b.gif" );
      ((Element)v.get(379)).setAttribute("width","8" );
      ((Element)v.get(379)).setAttribute("height","8" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */
      /* Termina nodo:378   */

      /* Empieza nodo:380 / Elemento padre: 375   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(380)).setAttribute("align","center" );
      ((Element)v.get(380)).setAttribute("width","8" );
      ((Element)v.get(375)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(381)).setAttribute("src","b.gif" );
      ((Element)v.get(381)).setAttribute("width","12" );
      ((Element)v.get(381)).setAttribute("height","8" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */
      /* Termina nodo:380   */
      /* Termina nodo:375   */

      /* Empieza nodo:382 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(382)).setAttribute("nombre","formTr13" );
      ((Element)v.get(52)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(383)).setAttribute("align","center" );
      ((Element)v.get(383)).setAttribute("width","8" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(384)).setAttribute("src","b.gif" );
      ((Element)v.get(384)).setAttribute("width","8" );
      ((Element)v.get(384)).setAttribute("height","12" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */
      /* Termina nodo:383   */

      /* Empieza nodo:385 / Elemento padre: 382   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(385)).setAttribute("width","100%" );
      ((Element)v.get(382)).appendChild((Element)v.get(385));

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
      ((Element)v.get(387)).setAttribute("align","left" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(388)).setAttribute("nombre","valDimeAnchTdId" );
      ((Element)v.get(387)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(389)).setAttribute("width","100%" );
      ((Element)v.get(389)).setAttribute("border","0" );
      ((Element)v.get(389)).setAttribute("cellspacing","0" );
      ((Element)v.get(389)).setAttribute("cellpadding","0" );
      ((Element)v.get(389)).setAttribute("align","left" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(389)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(391)).setAttribute("valign","top" );
      ((Element)v.get(391)).setAttribute("height","13" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(392)).setAttribute("nombre","lblValDimeAnch" );
      ((Element)v.get(392)).setAttribute("alto","13" );
      ((Element)v.get(392)).setAttribute("filas","1" );
      ((Element)v.get(392)).setAttribute("id","datosTitle" );
      ((Element)v.get(392)).setAttribute("cod","MaeProdu.valDimeAnch.label" );
      ((Element)v.get(391)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */
      /* Termina nodo:391   */
      /* Termina nodo:390   */

      /* Empieza nodo:393 / Elemento padre: 389   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(393)).setAttribute("nombre","valDimeAnchWidgetTrId" );
      ((Element)v.get(389)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(394)).setAttribute("align","left" );
      ((Element)v.get(394)).setAttribute("nowrap","true" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(395)).setAttribute("nombre","valDimeAnch" );
      ((Element)v.get(395)).setAttribute("id","datosCampos" );
      ((Element)v.get(395)).setAttribute("trim","S" );
      ((Element)v.get(395)).setAttribute("max","6" );
      ((Element)v.get(395)).setAttribute("onchange","" );
      ((Element)v.get(395)).setAttribute("req","N" );
      ((Element)v.get(395)).setAttribute("size","6" );
      ((Element)v.get(395)).setAttribute("valor","" );
      ((Element)v.get(395)).setAttribute("validacion","" );
      ((Element)v.get(395)).setAttribute("disabled","" );
      ((Element)v.get(395)).setAttribute("onblur","" );
      ((Element)v.get(395)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true)" );
      ((Element)v.get(395)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm', 0, false)" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */
      /* Termina nodo:394   */
      /* Termina nodo:393   */
      /* Termina nodo:389   */
      /* Termina nodo:388   */

      /* Empieza nodo:396 / Elemento padre: 387   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(396)).setAttribute("nombre","valDimeAnchGapTdId" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(396)).setAttribute("nowrap","true" );
      ((Element)v.get(396)).setAttribute("class","datosCampos" );
      ((Element)v.get(387)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(397)).setAttribute("src","b.gif" );
      ((Element)v.get(397)).setAttribute("width","25" );
      ((Element)v.get(397)).setAttribute("height","8" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */
      /* Termina nodo:396   */

      /* Empieza nodo:398 / Elemento padre: 387   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(398)).setAttribute("width","100%" );
      ((Element)v.get(387)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(399)).setAttribute("src","b.gif" );
      ((Element)v.get(398)).appendChild((Element)v.get(399));
      /* Termina nodo:399   */
      /* Termina nodo:398   */
      /* Termina nodo:387   */
      /* Termina nodo:386   */
      /* Termina nodo:385   */
      /* Termina nodo:382   */

      /* Empieza nodo:400 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(400)).setAttribute("nombre","formGapTr13" );
      ((Element)v.get(52)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(401)).setAttribute("align","center" );
      ((Element)v.get(401)).setAttribute("width","8" );
      ((Element)v.get(400)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(402)).setAttribute("src","b.gif" );
      ((Element)v.get(402)).setAttribute("width","12" );
      ((Element)v.get(402)).setAttribute("height","8" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));
      /* Termina nodo:402   */
      /* Termina nodo:401   */

      /* Empieza nodo:403 / Elemento padre: 400   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(400)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(404)).setAttribute("src","b.gif" );
      ((Element)v.get(404)).setAttribute("width","8" );
      ((Element)v.get(404)).setAttribute("height","8" );
      ((Element)v.get(403)).appendChild((Element)v.get(404));
      /* Termina nodo:404   */
      /* Termina nodo:403   */

      /* Empieza nodo:405 / Elemento padre: 400   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(405)).setAttribute("align","center" );
      ((Element)v.get(405)).setAttribute("width","8" );
      ((Element)v.get(400)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(406)).setAttribute("src","b.gif" );
      ((Element)v.get(406)).setAttribute("width","12" );
      ((Element)v.get(406)).setAttribute("height","8" );
      ((Element)v.get(405)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */
      /* Termina nodo:405   */
      /* Termina nodo:400   */

      /* Empieza nodo:407 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(407)).setAttribute("nombre","formTr14" );
      ((Element)v.get(52)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(408)).setAttribute("align","center" );
      ((Element)v.get(408)).setAttribute("width","8" );
      ((Element)v.get(407)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(409)).setAttribute("src","b.gif" );
      ((Element)v.get(409)).setAttribute("width","8" );
      ((Element)v.get(409)).setAttribute("height","12" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));
      /* Termina nodo:409   */
      /* Termina nodo:408   */

      /* Empieza nodo:410 / Elemento padre: 407   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(410)).setAttribute("width","100%" );
      ((Element)v.get(407)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(411)).setAttribute("width","100%" );
      ((Element)v.get(411)).setAttribute("border","0" );
      ((Element)v.get(411)).setAttribute("cellspacing","0" );
      ((Element)v.get(411)).setAttribute("cellpadding","0" );
      ((Element)v.get(411)).setAttribute("align","left" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(412)).setAttribute("align","left" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(413)).setAttribute("nombre","valPesoTdId" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(414)).setAttribute("width","100%" );
      ((Element)v.get(414)).setAttribute("border","0" );
      ((Element)v.get(414)).setAttribute("cellspacing","0" );
      ((Element)v.get(414)).setAttribute("cellpadding","0" );
      ((Element)v.get(414)).setAttribute("align","left" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(414)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(416)).setAttribute("valign","top" );
      ((Element)v.get(416)).setAttribute("height","13" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));

      /* Empieza nodo:417 / Elemento padre: 416   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(417)).setAttribute("nombre","lblValPeso" );
      ((Element)v.get(417)).setAttribute("alto","13" );
      ((Element)v.get(417)).setAttribute("filas","1" );
      ((Element)v.get(417)).setAttribute("id","datosTitle" );
      ((Element)v.get(417)).setAttribute("cod","MaeProdu.valPeso.label" );
      ((Element)v.get(416)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */
      /* Termina nodo:416   */
      /* Termina nodo:415   */

      /* Empieza nodo:418 / Elemento padre: 414   */
   }

   private void getXML1890(Document doc) {
      v.add(doc.createElement("TR"));
      ((Element)v.get(418)).setAttribute("nombre","valPesoWidgetTrId" );
      ((Element)v.get(414)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(419)).setAttribute("align","left" );
      ((Element)v.get(419)).setAttribute("nowrap","true" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));

      /* Empieza nodo:420 / Elemento padre: 419   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(420)).setAttribute("nombre","valPeso" );
      ((Element)v.get(420)).setAttribute("id","datosCampos" );
      ((Element)v.get(420)).setAttribute("trim","S" );
      ((Element)v.get(420)).setAttribute("max","6" );
      ((Element)v.get(420)).setAttribute("onchange","" );
      ((Element)v.get(420)).setAttribute("req","N" );
      ((Element)v.get(420)).setAttribute("size","6" );
      ((Element)v.get(420)).setAttribute("valor","" );
      ((Element)v.get(420)).setAttribute("validacion","" );
      ((Element)v.get(420)).setAttribute("disabled","" );
      ((Element)v.get(420)).setAttribute("onblur","" );
      ((Element)v.get(420)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true)" );
      ((Element)v.get(420)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm', 0, false)" );
      ((Element)v.get(419)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */
      /* Termina nodo:419   */
      /* Termina nodo:418   */
      /* Termina nodo:414   */
      /* Termina nodo:413   */

      /* Empieza nodo:421 / Elemento padre: 412   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(421)).setAttribute("nombre","valPesoGapTdId" );
      ((Element)v.get(421)).setAttribute("nowrap","true" );
      ((Element)v.get(421)).setAttribute("class","datosCampos" );
      ((Element)v.get(412)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(422)).setAttribute("src","b.gif" );
      ((Element)v.get(422)).setAttribute("width","25" );
      ((Element)v.get(422)).setAttribute("height","8" );
      ((Element)v.get(421)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */
      /* Termina nodo:421   */

      /* Empieza nodo:423 / Elemento padre: 412   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(423)).setAttribute("width","100%" );
      ((Element)v.get(412)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(424)).setAttribute("src","b.gif" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));
      /* Termina nodo:424   */
      /* Termina nodo:423   */
      /* Termina nodo:412   */
      /* Termina nodo:411   */
      /* Termina nodo:410   */
      /* Termina nodo:407   */

      /* Empieza nodo:425 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(425)).setAttribute("nombre","formGapTr14" );
      ((Element)v.get(52)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(426)).setAttribute("align","center" );
      ((Element)v.get(426)).setAttribute("width","8" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(427)).setAttribute("src","b.gif" );
      ((Element)v.get(427)).setAttribute("width","12" );
      ((Element)v.get(427)).setAttribute("height","8" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));
      /* Termina nodo:427   */
      /* Termina nodo:426   */

      /* Empieza nodo:428 / Elemento padre: 425   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(425)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(429)).setAttribute("src","b.gif" );
      ((Element)v.get(429)).setAttribute("width","8" );
      ((Element)v.get(429)).setAttribute("height","8" );
      ((Element)v.get(428)).appendChild((Element)v.get(429));
      /* Termina nodo:429   */
      /* Termina nodo:428   */

      /* Empieza nodo:430 / Elemento padre: 425   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(430)).setAttribute("align","center" );
      ((Element)v.get(430)).setAttribute("width","8" );
      ((Element)v.get(425)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(431)).setAttribute("src","b.gif" );
      ((Element)v.get(431)).setAttribute("width","12" );
      ((Element)v.get(431)).setAttribute("height","8" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */
      /* Termina nodo:430   */
      /* Termina nodo:425   */

      /* Empieza nodo:432 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(432)).setAttribute("nombre","formTr15" );
      ((Element)v.get(52)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(433)).setAttribute("align","center" );
      ((Element)v.get(433)).setAttribute("width","8" );
      ((Element)v.get(432)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(434)).setAttribute("src","b.gif" );
      ((Element)v.get(434)).setAttribute("width","8" );
      ((Element)v.get(434)).setAttribute("height","12" );
      ((Element)v.get(433)).appendChild((Element)v.get(434));
      /* Termina nodo:434   */
      /* Termina nodo:433   */

      /* Empieza nodo:435 / Elemento padre: 432   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(435)).setAttribute("width","100%" );
      ((Element)v.get(432)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(436)).setAttribute("width","100%" );
      ((Element)v.get(436)).setAttribute("border","0" );
      ((Element)v.get(436)).setAttribute("cellspacing","0" );
      ((Element)v.get(436)).setAttribute("cellpadding","0" );
      ((Element)v.get(436)).setAttribute("align","left" );
      ((Element)v.get(435)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(437)).setAttribute("align","left" );
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(436)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(438)).setAttribute("nombre","valVoluTdId" );
      ((Element)v.get(437)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(439)).setAttribute("width","100%" );
      ((Element)v.get(439)).setAttribute("border","0" );
      ((Element)v.get(439)).setAttribute("cellspacing","0" );
      ((Element)v.get(439)).setAttribute("cellpadding","0" );
      ((Element)v.get(439)).setAttribute("align","left" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(439)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(441)).setAttribute("valign","top" );
      ((Element)v.get(441)).setAttribute("height","13" );
      ((Element)v.get(440)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(442)).setAttribute("nombre","lblValVolu" );
      ((Element)v.get(442)).setAttribute("alto","13" );
      ((Element)v.get(442)).setAttribute("filas","1" );
      ((Element)v.get(442)).setAttribute("id","datosTitle" );
      ((Element)v.get(442)).setAttribute("cod","MaeProdu.valVolu.label" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */
      /* Termina nodo:441   */
      /* Termina nodo:440   */

      /* Empieza nodo:443 / Elemento padre: 439   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(443)).setAttribute("nombre","valVoluWidgetTrId" );
      ((Element)v.get(439)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(444)).setAttribute("align","left" );
      ((Element)v.get(444)).setAttribute("nowrap","true" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(445)).setAttribute("nombre","valVolu" );
      ((Element)v.get(445)).setAttribute("id","datosCampos" );
      ((Element)v.get(445)).setAttribute("trim","S" );
      ((Element)v.get(445)).setAttribute("max","6" );
      ((Element)v.get(445)).setAttribute("onchange","" );
      ((Element)v.get(445)).setAttribute("req","N" );
      ((Element)v.get(445)).setAttribute("size","6" );
      ((Element)v.get(445)).setAttribute("valor","" );
      ((Element)v.get(445)).setAttribute("validacion","" );
      ((Element)v.get(445)).setAttribute("disabled","" );
      ((Element)v.get(445)).setAttribute("onblur","" );
      ((Element)v.get(445)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true)" );
      ((Element)v.get(445)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm', 0, false)" );
      ((Element)v.get(444)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */
      /* Termina nodo:444   */
      /* Termina nodo:443   */
      /* Termina nodo:439   */
      /* Termina nodo:438   */

      /* Empieza nodo:446 / Elemento padre: 437   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(446)).setAttribute("nombre","valVoluGapTdId" );
      ((Element)v.get(446)).setAttribute("nowrap","true" );
      ((Element)v.get(446)).setAttribute("class","datosCampos" );
      ((Element)v.get(437)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(447)).setAttribute("src","b.gif" );
      ((Element)v.get(447)).setAttribute("width","25" );
      ((Element)v.get(447)).setAttribute("height","8" );
      ((Element)v.get(446)).appendChild((Element)v.get(447));
      /* Termina nodo:447   */
      /* Termina nodo:446   */

      /* Empieza nodo:448 / Elemento padre: 437   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(448)).setAttribute("width","100%" );
      ((Element)v.get(437)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(449)).setAttribute("src","b.gif" );
      ((Element)v.get(448)).appendChild((Element)v.get(449));
      /* Termina nodo:449   */
      /* Termina nodo:448   */
      /* Termina nodo:437   */
      /* Termina nodo:436   */
      /* Termina nodo:435   */
      /* Termina nodo:432   */

      /* Empieza nodo:450 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(450)).setAttribute("nombre","formGapTr15" );
      ((Element)v.get(52)).appendChild((Element)v.get(450));

      /* Empieza nodo:451 / Elemento padre: 450   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(451)).setAttribute("align","center" );
      ((Element)v.get(451)).setAttribute("width","8" );
      ((Element)v.get(450)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(452)).setAttribute("src","b.gif" );
      ((Element)v.get(452)).setAttribute("width","12" );
      ((Element)v.get(452)).setAttribute("height","8" );
      ((Element)v.get(451)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */
      /* Termina nodo:451   */

      /* Empieza nodo:453 / Elemento padre: 450   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(450)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(454)).setAttribute("src","b.gif" );
      ((Element)v.get(454)).setAttribute("width","8" );
      ((Element)v.get(454)).setAttribute("height","8" );
      ((Element)v.get(453)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */
      /* Termina nodo:453   */

      /* Empieza nodo:455 / Elemento padre: 450   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(455)).setAttribute("align","center" );
      ((Element)v.get(455)).setAttribute("width","8" );
      ((Element)v.get(450)).appendChild((Element)v.get(455));

      /* Empieza nodo:456 / Elemento padre: 455   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(456)).setAttribute("src","b.gif" );
      ((Element)v.get(456)).setAttribute("width","12" );
      ((Element)v.get(456)).setAttribute("height","8" );
      ((Element)v.get(455)).appendChild((Element)v.get(456));
      /* Termina nodo:456   */
      /* Termina nodo:455   */
      /* Termina nodo:450   */

      /* Empieza nodo:457 / Elemento padre: 52   */
   }

   private void getXML2070(Document doc) {
      v.add(doc.createElement("TR"));
      ((Element)v.get(457)).setAttribute("nombre","formTr16" );
      ((Element)v.get(52)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(458)).setAttribute("align","center" );
      ((Element)v.get(458)).setAttribute("width","8" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));

      /* Empieza nodo:459 / Elemento padre: 458   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(459)).setAttribute("src","b.gif" );
      ((Element)v.get(459)).setAttribute("width","8" );
      ((Element)v.get(459)).setAttribute("height","12" );
      ((Element)v.get(458)).appendChild((Element)v.get(459));
      /* Termina nodo:459   */
      /* Termina nodo:458   */

      /* Empieza nodo:460 / Elemento padre: 457   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(460)).setAttribute("width","100%" );
      ((Element)v.get(457)).appendChild((Element)v.get(460));

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
      ((Element)v.get(462)).setAttribute("align","left" );
      ((Element)v.get(461)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(463)).setAttribute("nombre","valCostEstdTdId" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));

      /* Empieza nodo:464 / Elemento padre: 463   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(464)).setAttribute("width","100%" );
      ((Element)v.get(464)).setAttribute("border","0" );
      ((Element)v.get(464)).setAttribute("cellspacing","0" );
      ((Element)v.get(464)).setAttribute("cellpadding","0" );
      ((Element)v.get(464)).setAttribute("align","left" );
      ((Element)v.get(463)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(464)).appendChild((Element)v.get(465));

      /* Empieza nodo:466 / Elemento padre: 465   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(466)).setAttribute("valign","top" );
      ((Element)v.get(466)).setAttribute("height","13" );
      ((Element)v.get(465)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(467)).setAttribute("nombre","lblValCostEstd" );
      ((Element)v.get(467)).setAttribute("alto","13" );
      ((Element)v.get(467)).setAttribute("filas","1" );
      ((Element)v.get(467)).setAttribute("id","datosTitle" );
      ((Element)v.get(467)).setAttribute("cod","MaeProdu.valCostEstd.label" );
      ((Element)v.get(466)).appendChild((Element)v.get(467));
      /* Termina nodo:467   */
      /* Termina nodo:466   */
      /* Termina nodo:465   */

      /* Empieza nodo:468 / Elemento padre: 464   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(468)).setAttribute("nombre","valCostEstdWidgetTrId" );
      ((Element)v.get(464)).appendChild((Element)v.get(468));

      /* Empieza nodo:469 / Elemento padre: 468   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(469)).setAttribute("align","left" );
      ((Element)v.get(469)).setAttribute("nowrap","true" );
      ((Element)v.get(468)).appendChild((Element)v.get(469));

      /* Empieza nodo:470 / Elemento padre: 469   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(470)).setAttribute("nombre","valCostEstd" );
      ((Element)v.get(470)).setAttribute("id","datosCampos" );
      ((Element)v.get(470)).setAttribute("trim","S" );
      ((Element)v.get(470)).setAttribute("max","12" );
      ((Element)v.get(470)).setAttribute("onchange","" );
      ((Element)v.get(470)).setAttribute("req","N" );
      ((Element)v.get(470)).setAttribute("size","12" );
      ((Element)v.get(470)).setAttribute("valor","" );
      ((Element)v.get(470)).setAttribute("validacion","" );
      ((Element)v.get(470)).setAttribute("disabled","" );
      ((Element)v.get(470)).setAttribute("onblur","" );
      ((Element)v.get(470)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true)" );
      ((Element)v.get(470)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm', 0, false)" );
      ((Element)v.get(469)).appendChild((Element)v.get(470));
      /* Termina nodo:470   */
      /* Termina nodo:469   */
      /* Termina nodo:468   */
      /* Termina nodo:464   */
      /* Termina nodo:463   */

      /* Empieza nodo:471 / Elemento padre: 462   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(471)).setAttribute("nombre","valCostEstdGapTdId" );
      ((Element)v.get(471)).setAttribute("nowrap","true" );
      ((Element)v.get(471)).setAttribute("class","datosCampos" );
      ((Element)v.get(462)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(472)).setAttribute("src","b.gif" );
      ((Element)v.get(472)).setAttribute("width","25" );
      ((Element)v.get(472)).setAttribute("height","8" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));
      /* Termina nodo:472   */
      /* Termina nodo:471   */

      /* Empieza nodo:473 / Elemento padre: 462   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(473)).setAttribute("width","100%" );
      ((Element)v.get(462)).appendChild((Element)v.get(473));

      /* Empieza nodo:474 / Elemento padre: 473   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(474)).setAttribute("src","b.gif" );
      ((Element)v.get(473)).appendChild((Element)v.get(474));
      /* Termina nodo:474   */
      /* Termina nodo:473   */
      /* Termina nodo:462   */
      /* Termina nodo:461   */
      /* Termina nodo:460   */
      /* Termina nodo:457   */

      /* Empieza nodo:475 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(475)).setAttribute("nombre","formGapTr16" );
      ((Element)v.get(52)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("TD"));
   }

   private void getXML2160(Document doc) {
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
      ((Element)v.get(482)).setAttribute("nombre","formTr17" );
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
      ((Element)v.get(488)).setAttribute("nombre","valPrecPosiTdId" );
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
      ((Element)v.get(492)).setAttribute("nombre","lblValPrecPosi" );
      ((Element)v.get(492)).setAttribute("alto","13" );
      ((Element)v.get(492)).setAttribute("filas","1" );
      ((Element)v.get(492)).setAttribute("id","datosTitle" );
      ((Element)v.get(492)).setAttribute("cod","MaeProdu.valPrecPosi.label" );
      ((Element)v.get(491)).appendChild((Element)v.get(492));
      /* Termina nodo:492   */
      /* Termina nodo:491   */
      /* Termina nodo:490   */

      /* Empieza nodo:493 / Elemento padre: 489   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(493)).setAttribute("nombre","valPrecPosiWidgetTrId" );
      ((Element)v.get(489)).appendChild((Element)v.get(493));

      /* Empieza nodo:494 / Elemento padre: 493   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(494)).setAttribute("align","left" );
      ((Element)v.get(494)).setAttribute("nowrap","true" );
      ((Element)v.get(493)).appendChild((Element)v.get(494));

      /* Empieza nodo:495 / Elemento padre: 494   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(495)).setAttribute("nombre","valPrecPosi" );
      ((Element)v.get(495)).setAttribute("id","datosCampos" );
      ((Element)v.get(495)).setAttribute("trim","S" );
      ((Element)v.get(495)).setAttribute("max","12" );
      ((Element)v.get(495)).setAttribute("onchange","" );
      ((Element)v.get(495)).setAttribute("req","N" );
      ((Element)v.get(495)).setAttribute("size","12" );
      ((Element)v.get(495)).setAttribute("valor","" );
      ((Element)v.get(495)).setAttribute("validacion","" );
      ((Element)v.get(495)).setAttribute("disabled","" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(495)).setAttribute("onblur","" );
      ((Element)v.get(495)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true)" );
      ((Element)v.get(495)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm', 0, false)" );
      ((Element)v.get(494)).appendChild((Element)v.get(495));
      /* Termina nodo:495   */
      /* Termina nodo:494   */
      /* Termina nodo:493   */
      /* Termina nodo:489   */
      /* Termina nodo:488   */

      /* Empieza nodo:496 / Elemento padre: 487   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(496)).setAttribute("nombre","valPrecPosiGapTdId" );
      ((Element)v.get(496)).setAttribute("nowrap","true" );
      ((Element)v.get(496)).setAttribute("class","datosCampos" );
      ((Element)v.get(487)).appendChild((Element)v.get(496));

      /* Empieza nodo:497 / Elemento padre: 496   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(497)).setAttribute("src","b.gif" );
      ((Element)v.get(497)).setAttribute("width","25" );
      ((Element)v.get(497)).setAttribute("height","8" );
      ((Element)v.get(496)).appendChild((Element)v.get(497));
      /* Termina nodo:497   */
      /* Termina nodo:496   */

      /* Empieza nodo:498 / Elemento padre: 487   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(498)).setAttribute("width","100%" );
      ((Element)v.get(487)).appendChild((Element)v.get(498));

      /* Empieza nodo:499 / Elemento padre: 498   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(499)).setAttribute("src","b.gif" );
      ((Element)v.get(498)).appendChild((Element)v.get(499));
      /* Termina nodo:499   */
      /* Termina nodo:498   */
      /* Termina nodo:487   */
      /* Termina nodo:486   */
      /* Termina nodo:485   */
      /* Termina nodo:482   */

      /* Empieza nodo:500 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(500)).setAttribute("nombre","formGapTr17" );
      ((Element)v.get(52)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(501)).setAttribute("align","center" );
      ((Element)v.get(501)).setAttribute("width","8" );
      ((Element)v.get(500)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(502)).setAttribute("src","b.gif" );
      ((Element)v.get(502)).setAttribute("width","12" );
      ((Element)v.get(502)).setAttribute("height","8" );
      ((Element)v.get(501)).appendChild((Element)v.get(502));
      /* Termina nodo:502   */
      /* Termina nodo:501   */

      /* Empieza nodo:503 / Elemento padre: 500   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(500)).appendChild((Element)v.get(503));

      /* Empieza nodo:504 / Elemento padre: 503   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(504)).setAttribute("src","b.gif" );
      ((Element)v.get(504)).setAttribute("width","8" );
      ((Element)v.get(504)).setAttribute("height","8" );
      ((Element)v.get(503)).appendChild((Element)v.get(504));
      /* Termina nodo:504   */
      /* Termina nodo:503   */

      /* Empieza nodo:505 / Elemento padre: 500   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(505)).setAttribute("align","center" );
      ((Element)v.get(505)).setAttribute("width","8" );
      ((Element)v.get(500)).appendChild((Element)v.get(505));

      /* Empieza nodo:506 / Elemento padre: 505   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(506)).setAttribute("src","b.gif" );
      ((Element)v.get(506)).setAttribute("width","12" );
      ((Element)v.get(506)).setAttribute("height","8" );
      ((Element)v.get(505)).appendChild((Element)v.get(506));
      /* Termina nodo:506   */
      /* Termina nodo:505   */
      /* Termina nodo:500   */

      /* Empieza nodo:507 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(507)).setAttribute("nombre","formTr18" );
      ((Element)v.get(52)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(508)).setAttribute("align","center" );
      ((Element)v.get(508)).setAttribute("width","8" );
      ((Element)v.get(507)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(509)).setAttribute("src","b.gif" );
      ((Element)v.get(509)).setAttribute("width","8" );
      ((Element)v.get(509)).setAttribute("height","12" );
      ((Element)v.get(508)).appendChild((Element)v.get(509));
      /* Termina nodo:509   */
      /* Termina nodo:508   */

      /* Empieza nodo:510 / Elemento padre: 507   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(510)).setAttribute("width","100%" );
      ((Element)v.get(507)).appendChild((Element)v.get(510));

      /* Empieza nodo:511 / Elemento padre: 510   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(511)).setAttribute("width","100%" );
      ((Element)v.get(511)).setAttribute("border","0" );
      ((Element)v.get(511)).setAttribute("cellspacing","0" );
      ((Element)v.get(511)).setAttribute("cellpadding","0" );
      ((Element)v.get(511)).setAttribute("align","left" );
      ((Element)v.get(510)).appendChild((Element)v.get(511));

      /* Empieza nodo:512 / Elemento padre: 511   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(512)).setAttribute("align","left" );
      ((Element)v.get(511)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(513)).setAttribute("nombre","valPrecCataTdId" );
      ((Element)v.get(512)).appendChild((Element)v.get(513));

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
      ((Element)v.get(514)).appendChild((Element)v.get(515));

      /* Empieza nodo:516 / Elemento padre: 515   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(516)).setAttribute("valign","top" );
      ((Element)v.get(516)).setAttribute("height","13" );
      ((Element)v.get(515)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(517)).setAttribute("nombre","lblValPrecCata" );
      ((Element)v.get(517)).setAttribute("alto","13" );
      ((Element)v.get(517)).setAttribute("filas","1" );
      ((Element)v.get(517)).setAttribute("id","datosTitle" );
      ((Element)v.get(517)).setAttribute("cod","MaeProdu.valPrecCata.label" );
      ((Element)v.get(516)).appendChild((Element)v.get(517));
      /* Termina nodo:517   */
      /* Termina nodo:516   */
      /* Termina nodo:515   */

      /* Empieza nodo:518 / Elemento padre: 514   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(518)).setAttribute("nombre","valPrecCataWidgetTrId" );
      ((Element)v.get(514)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(519)).setAttribute("align","left" );
      ((Element)v.get(519)).setAttribute("nowrap","true" );
      ((Element)v.get(518)).appendChild((Element)v.get(519));

      /* Empieza nodo:520 / Elemento padre: 519   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(520)).setAttribute("nombre","valPrecCata" );
      ((Element)v.get(520)).setAttribute("id","datosCampos" );
      ((Element)v.get(520)).setAttribute("trim","S" );
      ((Element)v.get(520)).setAttribute("max","12" );
      ((Element)v.get(520)).setAttribute("onchange","" );
      ((Element)v.get(520)).setAttribute("req","N" );
      ((Element)v.get(520)).setAttribute("size","12" );
      ((Element)v.get(520)).setAttribute("valor","" );
      ((Element)v.get(520)).setAttribute("validacion","" );
      ((Element)v.get(520)).setAttribute("disabled","" );
      ((Element)v.get(520)).setAttribute("onblur","" );
      ((Element)v.get(520)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true)" );
      ((Element)v.get(520)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm', 0, false)" );
      ((Element)v.get(519)).appendChild((Element)v.get(520));
      /* Termina nodo:520   */
      /* Termina nodo:519   */
      /* Termina nodo:518   */
      /* Termina nodo:514   */
      /* Termina nodo:513   */

      /* Empieza nodo:521 / Elemento padre: 512   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(521)).setAttribute("nombre","valPrecCataGapTdId" );
      ((Element)v.get(521)).setAttribute("nowrap","true" );
      ((Element)v.get(521)).setAttribute("class","datosCampos" );
      ((Element)v.get(512)).appendChild((Element)v.get(521));

      /* Empieza nodo:522 / Elemento padre: 521   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(522)).setAttribute("src","b.gif" );
      ((Element)v.get(522)).setAttribute("width","25" );
      ((Element)v.get(522)).setAttribute("height","8" );
      ((Element)v.get(521)).appendChild((Element)v.get(522));
      /* Termina nodo:522   */
      /* Termina nodo:521   */

      /* Empieza nodo:523 / Elemento padre: 512   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(523)).setAttribute("width","100%" );
      ((Element)v.get(512)).appendChild((Element)v.get(523));

      /* Empieza nodo:524 / Elemento padre: 523   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(524)).setAttribute("src","b.gif" );
      ((Element)v.get(523)).appendChild((Element)v.get(524));
      /* Termina nodo:524   */
      /* Termina nodo:523   */
      /* Termina nodo:512   */
      /* Termina nodo:511   */
      /* Termina nodo:510   */
      /* Termina nodo:507   */

      /* Empieza nodo:525 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(525)).setAttribute("nombre","formGapTr18" );
      ((Element)v.get(52)).appendChild((Element)v.get(525));

      /* Empieza nodo:526 / Elemento padre: 525   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(526)).setAttribute("align","center" );
      ((Element)v.get(526)).setAttribute("width","8" );
      ((Element)v.get(525)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(527)).setAttribute("src","b.gif" );
      ((Element)v.get(527)).setAttribute("width","12" );
      ((Element)v.get(527)).setAttribute("height","8" );
      ((Element)v.get(526)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */
      /* Termina nodo:526   */

      /* Empieza nodo:528 / Elemento padre: 525   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(525)).appendChild((Element)v.get(528));

      /* Empieza nodo:529 / Elemento padre: 528   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(529)).setAttribute("src","b.gif" );
      ((Element)v.get(529)).setAttribute("width","8" );
      ((Element)v.get(529)).setAttribute("height","8" );
      ((Element)v.get(528)).appendChild((Element)v.get(529));
      /* Termina nodo:529   */
      /* Termina nodo:528   */

      /* Empieza nodo:530 / Elemento padre: 525   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(530)).setAttribute("align","center" );
      ((Element)v.get(530)).setAttribute("width","8" );
      ((Element)v.get(525)).appendChild((Element)v.get(530));

      /* Empieza nodo:531 / Elemento padre: 530   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(531)).setAttribute("src","b.gif" );
      ((Element)v.get(531)).setAttribute("width","12" );
      ((Element)v.get(531)).setAttribute("height","8" );
      ((Element)v.get(530)).appendChild((Element)v.get(531));
      /* Termina nodo:531   */
      /* Termina nodo:530   */
      /* Termina nodo:525   */

      /* Empieza nodo:532 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(532)).setAttribute("nombre","formTr19" );
      ((Element)v.get(52)).appendChild((Element)v.get(532));

      /* Empieza nodo:533 / Elemento padre: 532   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(533)).setAttribute("align","center" );
      ((Element)v.get(533)).setAttribute("width","8" );
      ((Element)v.get(532)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(534)).setAttribute("src","b.gif" );
      ((Element)v.get(534)).setAttribute("width","8" );
      ((Element)v.get(534)).setAttribute("height","12" );
      ((Element)v.get(533)).appendChild((Element)v.get(534));
      /* Termina nodo:534   */
      /* Termina nodo:533   */

      /* Empieza nodo:535 / Elemento padre: 532   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(535)).setAttribute("width","100%" );
      ((Element)v.get(532)).appendChild((Element)v.get(535));

      /* Empieza nodo:536 / Elemento padre: 535   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(536)).setAttribute("width","100%" );
      ((Element)v.get(536)).setAttribute("border","0" );
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(536)).setAttribute("cellspacing","0" );
      ((Element)v.get(536)).setAttribute("cellpadding","0" );
      ((Element)v.get(536)).setAttribute("align","left" );
      ((Element)v.get(535)).appendChild((Element)v.get(536));

      /* Empieza nodo:537 / Elemento padre: 536   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(537)).setAttribute("align","left" );
      ((Element)v.get(536)).appendChild((Element)v.get(537));

      /* Empieza nodo:538 / Elemento padre: 537   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(538)).setAttribute("nombre","valPrecContTdId" );
      ((Element)v.get(537)).appendChild((Element)v.get(538));

      /* Empieza nodo:539 / Elemento padre: 538   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(539)).setAttribute("width","100%" );
      ((Element)v.get(539)).setAttribute("border","0" );
      ((Element)v.get(539)).setAttribute("cellspacing","0" );
      ((Element)v.get(539)).setAttribute("cellpadding","0" );
      ((Element)v.get(539)).setAttribute("align","left" );
      ((Element)v.get(538)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(539)).appendChild((Element)v.get(540));

      /* Empieza nodo:541 / Elemento padre: 540   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(541)).setAttribute("valign","top" );
      ((Element)v.get(541)).setAttribute("height","13" );
      ((Element)v.get(540)).appendChild((Element)v.get(541));

      /* Empieza nodo:542 / Elemento padre: 541   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(542)).setAttribute("nombre","lblValPrecCont" );
      ((Element)v.get(542)).setAttribute("alto","13" );
      ((Element)v.get(542)).setAttribute("filas","1" );
      ((Element)v.get(542)).setAttribute("id","datosTitle" );
      ((Element)v.get(542)).setAttribute("cod","MaeProdu.valPrecCont.label" );
      ((Element)v.get(541)).appendChild((Element)v.get(542));
      /* Termina nodo:542   */
      /* Termina nodo:541   */
      /* Termina nodo:540   */

      /* Empieza nodo:543 / Elemento padre: 539   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(543)).setAttribute("nombre","valPrecContWidgetTrId" );
      ((Element)v.get(539)).appendChild((Element)v.get(543));

      /* Empieza nodo:544 / Elemento padre: 543   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(544)).setAttribute("align","left" );
      ((Element)v.get(544)).setAttribute("nowrap","true" );
      ((Element)v.get(543)).appendChild((Element)v.get(544));

      /* Empieza nodo:545 / Elemento padre: 544   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(545)).setAttribute("nombre","valPrecCont" );
      ((Element)v.get(545)).setAttribute("id","datosCampos" );
      ((Element)v.get(545)).setAttribute("trim","S" );
      ((Element)v.get(545)).setAttribute("max","12" );
      ((Element)v.get(545)).setAttribute("onchange","" );
      ((Element)v.get(545)).setAttribute("req","N" );
      ((Element)v.get(545)).setAttribute("size","12" );
      ((Element)v.get(545)).setAttribute("valor","" );
      ((Element)v.get(545)).setAttribute("validacion","" );
      ((Element)v.get(545)).setAttribute("disabled","" );
      ((Element)v.get(545)).setAttribute("onblur","" );
      ((Element)v.get(545)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true)" );
      ((Element)v.get(545)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm', 0, false)" );
      ((Element)v.get(544)).appendChild((Element)v.get(545));
      /* Termina nodo:545   */
      /* Termina nodo:544   */
      /* Termina nodo:543   */
      /* Termina nodo:539   */
      /* Termina nodo:538   */

      /* Empieza nodo:546 / Elemento padre: 537   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(546)).setAttribute("nombre","valPrecContGapTdId" );
      ((Element)v.get(546)).setAttribute("nowrap","true" );
      ((Element)v.get(546)).setAttribute("class","datosCampos" );
      ((Element)v.get(537)).appendChild((Element)v.get(546));

      /* Empieza nodo:547 / Elemento padre: 546   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(547)).setAttribute("src","b.gif" );
      ((Element)v.get(547)).setAttribute("width","25" );
      ((Element)v.get(547)).setAttribute("height","8" );
      ((Element)v.get(546)).appendChild((Element)v.get(547));
      /* Termina nodo:547   */
      /* Termina nodo:546   */

      /* Empieza nodo:548 / Elemento padre: 537   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(548)).setAttribute("width","100%" );
      ((Element)v.get(537)).appendChild((Element)v.get(548));

      /* Empieza nodo:549 / Elemento padre: 548   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(549)).setAttribute("src","b.gif" );
      ((Element)v.get(548)).appendChild((Element)v.get(549));
      /* Termina nodo:549   */
      /* Termina nodo:548   */
      /* Termina nodo:537   */
      /* Termina nodo:536   */
      /* Termina nodo:535   */
      /* Termina nodo:532   */

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
      ((Element)v.get(563)).setAttribute("nombre","numUnidDentPediTdId" );
      ((Element)v.get(562)).appendChild((Element)v.get(563));

      /* Empieza nodo:564 / Elemento padre: 563   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(564)).setAttribute("width","100%" );
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
      ((Element)v.get(567)).setAttribute("nombre","lblNumUnidDentPedi" );
      ((Element)v.get(567)).setAttribute("alto","13" );
      ((Element)v.get(567)).setAttribute("filas","1" );
      ((Element)v.get(567)).setAttribute("id","datosTitle" );
      ((Element)v.get(567)).setAttribute("cod","MaeProdu.numUnidDentPedi.label" );
      ((Element)v.get(566)).appendChild((Element)v.get(567));
      /* Termina nodo:567   */
      /* Termina nodo:566   */
      /* Termina nodo:565   */

      /* Empieza nodo:568 / Elemento padre: 564   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(568)).setAttribute("nombre","numUnidDentPediWidgetTrId" );
      ((Element)v.get(564)).appendChild((Element)v.get(568));

      /* Empieza nodo:569 / Elemento padre: 568   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(569)).setAttribute("align","left" );
      ((Element)v.get(569)).setAttribute("nowrap","true" );
      ((Element)v.get(568)).appendChild((Element)v.get(569));

      /* Empieza nodo:570 / Elemento padre: 569   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(570)).setAttribute("nombre","numUnidDentPedi" );
      ((Element)v.get(570)).setAttribute("id","datosCampos" );
      ((Element)v.get(570)).setAttribute("trim","S" );
      ((Element)v.get(570)).setAttribute("max","5" );
      ((Element)v.get(570)).setAttribute("onchange","" );
      ((Element)v.get(570)).setAttribute("req","N" );
      ((Element)v.get(570)).setAttribute("size","5" );
      ((Element)v.get(570)).setAttribute("valor","" );
      ((Element)v.get(570)).setAttribute("validacion","" );
      ((Element)v.get(570)).setAttribute("disabled","" );
      ((Element)v.get(570)).setAttribute("onblur","" );
      ((Element)v.get(570)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true)" );
      ((Element)v.get(570)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm', 0, false)" );
      ((Element)v.get(569)).appendChild((Element)v.get(570));
      /* Termina nodo:570   */
      /* Termina nodo:569   */
      /* Termina nodo:568   */
      /* Termina nodo:564   */
      /* Termina nodo:563   */

      /* Empieza nodo:571 / Elemento padre: 562   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(571)).setAttribute("nombre","numUnidDentPediGapTdId" );
      ((Element)v.get(571)).setAttribute("nowrap","true" );
      ((Element)v.get(571)).setAttribute("class","datosCampos" );
      ((Element)v.get(562)).appendChild((Element)v.get(571));

      /* Empieza nodo:572 / Elemento padre: 571   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(572)).setAttribute("src","b.gif" );
      ((Element)v.get(572)).setAttribute("width","25" );
      ((Element)v.get(572)).setAttribute("height","8" );
      ((Element)v.get(571)).appendChild((Element)v.get(572));
      /* Termina nodo:572   */
      /* Termina nodo:571   */

      /* Empieza nodo:573 / Elemento padre: 562   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(573)).setAttribute("width","100%" );
      ((Element)v.get(562)).appendChild((Element)v.get(573));

      /* Empieza nodo:574 / Elemento padre: 573   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML2610(Document doc) {
      ((Element)v.get(574)).setAttribute("src","b.gif" );
      ((Element)v.get(573)).appendChild((Element)v.get(574));
      /* Termina nodo:574   */
      /* Termina nodo:573   */
      /* Termina nodo:562   */
      /* Termina nodo:561   */
      /* Termina nodo:560   */
      /* Termina nodo:557   */

      /* Empieza nodo:575 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(575)).setAttribute("nombre","formGapTr20" );
      ((Element)v.get(52)).appendChild((Element)v.get(575));

      /* Empieza nodo:576 / Elemento padre: 575   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(576)).setAttribute("align","center" );
      ((Element)v.get(576)).setAttribute("width","8" );
      ((Element)v.get(575)).appendChild((Element)v.get(576));

      /* Empieza nodo:577 / Elemento padre: 576   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(577)).setAttribute("src","b.gif" );
      ((Element)v.get(577)).setAttribute("width","12" );
      ((Element)v.get(577)).setAttribute("height","8" );
      ((Element)v.get(576)).appendChild((Element)v.get(577));
      /* Termina nodo:577   */
      /* Termina nodo:576   */

      /* Empieza nodo:578 / Elemento padre: 575   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(575)).appendChild((Element)v.get(578));

      /* Empieza nodo:579 / Elemento padre: 578   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(579)).setAttribute("src","b.gif" );
      ((Element)v.get(579)).setAttribute("width","8" );
      ((Element)v.get(579)).setAttribute("height","8" );
      ((Element)v.get(578)).appendChild((Element)v.get(579));
      /* Termina nodo:579   */
      /* Termina nodo:578   */

      /* Empieza nodo:580 / Elemento padre: 575   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(580)).setAttribute("align","center" );
      ((Element)v.get(580)).setAttribute("width","8" );
      ((Element)v.get(575)).appendChild((Element)v.get(580));

      /* Empieza nodo:581 / Elemento padre: 580   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(581)).setAttribute("src","b.gif" );
      ((Element)v.get(581)).setAttribute("width","12" );
      ((Element)v.get(581)).setAttribute("height","8" );
      ((Element)v.get(580)).appendChild((Element)v.get(581));
      /* Termina nodo:581   */
      /* Termina nodo:580   */
      /* Termina nodo:575   */

      /* Empieza nodo:582 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(582)).setAttribute("nombre","formTr21" );
      ((Element)v.get(52)).appendChild((Element)v.get(582));

      /* Empieza nodo:583 / Elemento padre: 582   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(583)).setAttribute("align","center" );
      ((Element)v.get(583)).setAttribute("width","8" );
      ((Element)v.get(582)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(584)).setAttribute("src","b.gif" );
      ((Element)v.get(584)).setAttribute("width","8" );
      ((Element)v.get(584)).setAttribute("height","12" );
      ((Element)v.get(583)).appendChild((Element)v.get(584));
      /* Termina nodo:584   */
      /* Termina nodo:583   */

      /* Empieza nodo:585 / Elemento padre: 582   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(585)).setAttribute("width","100%" );
      ((Element)v.get(582)).appendChild((Element)v.get(585));

      /* Empieza nodo:586 / Elemento padre: 585   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(586)).setAttribute("width","100%" );
      ((Element)v.get(586)).setAttribute("border","0" );
      ((Element)v.get(586)).setAttribute("cellspacing","0" );
      ((Element)v.get(586)).setAttribute("cellpadding","0" );
      ((Element)v.get(586)).setAttribute("align","left" );
      ((Element)v.get(585)).appendChild((Element)v.get(586));

      /* Empieza nodo:587 / Elemento padre: 586   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(587)).setAttribute("align","left" );
      ((Element)v.get(586)).appendChild((Element)v.get(587));

      /* Empieza nodo:588 / Elemento padre: 587   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(588)).setAttribute("nombre","numUnidCajaTdId" );
      ((Element)v.get(587)).appendChild((Element)v.get(588));

      /* Empieza nodo:589 / Elemento padre: 588   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(589)).setAttribute("width","100%" );
      ((Element)v.get(589)).setAttribute("border","0" );
      ((Element)v.get(589)).setAttribute("cellspacing","0" );
      ((Element)v.get(589)).setAttribute("cellpadding","0" );
      ((Element)v.get(589)).setAttribute("align","left" );
      ((Element)v.get(588)).appendChild((Element)v.get(589));

      /* Empieza nodo:590 / Elemento padre: 589   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(589)).appendChild((Element)v.get(590));

      /* Empieza nodo:591 / Elemento padre: 590   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(591)).setAttribute("valign","top" );
      ((Element)v.get(591)).setAttribute("height","13" );
      ((Element)v.get(590)).appendChild((Element)v.get(591));

      /* Empieza nodo:592 / Elemento padre: 591   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(592)).setAttribute("nombre","lblNumUnidCaja" );
      ((Element)v.get(592)).setAttribute("alto","13" );
      ((Element)v.get(592)).setAttribute("filas","1" );
      ((Element)v.get(592)).setAttribute("id","datosTitle" );
      ((Element)v.get(592)).setAttribute("cod","MaeProdu.numUnidCaja.label" );
      ((Element)v.get(591)).appendChild((Element)v.get(592));
      /* Termina nodo:592   */
      /* Termina nodo:591   */
      /* Termina nodo:590   */

      /* Empieza nodo:593 / Elemento padre: 589   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(593)).setAttribute("nombre","numUnidCajaWidgetTrId" );
      ((Element)v.get(589)).appendChild((Element)v.get(593));

      /* Empieza nodo:594 / Elemento padre: 593   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(594)).setAttribute("align","left" );
      ((Element)v.get(594)).setAttribute("nowrap","true" );
      ((Element)v.get(593)).appendChild((Element)v.get(594));

      /* Empieza nodo:595 / Elemento padre: 594   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(595)).setAttribute("nombre","numUnidCaja" );
      ((Element)v.get(595)).setAttribute("id","datosCampos" );
      ((Element)v.get(595)).setAttribute("trim","S" );
      ((Element)v.get(595)).setAttribute("max","5" );
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(595)).setAttribute("onchange","" );
      ((Element)v.get(595)).setAttribute("req","N" );
      ((Element)v.get(595)).setAttribute("size","5" );
      ((Element)v.get(595)).setAttribute("valor","" );
      ((Element)v.get(595)).setAttribute("validacion","" );
      ((Element)v.get(595)).setAttribute("disabled","" );
      ((Element)v.get(595)).setAttribute("onblur","" );
      ((Element)v.get(595)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true)" );
      ((Element)v.get(595)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm', 0, false)" );
      ((Element)v.get(594)).appendChild((Element)v.get(595));
      /* Termina nodo:595   */
      /* Termina nodo:594   */
      /* Termina nodo:593   */
      /* Termina nodo:589   */
      /* Termina nodo:588   */

      /* Empieza nodo:596 / Elemento padre: 587   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(596)).setAttribute("nombre","numUnidCajaGapTdId" );
      ((Element)v.get(596)).setAttribute("nowrap","true" );
      ((Element)v.get(596)).setAttribute("class","datosCampos" );
      ((Element)v.get(587)).appendChild((Element)v.get(596));

      /* Empieza nodo:597 / Elemento padre: 596   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(597)).setAttribute("src","b.gif" );
      ((Element)v.get(597)).setAttribute("width","25" );
      ((Element)v.get(597)).setAttribute("height","8" );
      ((Element)v.get(596)).appendChild((Element)v.get(597));
      /* Termina nodo:597   */
      /* Termina nodo:596   */

      /* Empieza nodo:598 / Elemento padre: 587   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(598)).setAttribute("width","100%" );
      ((Element)v.get(587)).appendChild((Element)v.get(598));

      /* Empieza nodo:599 / Elemento padre: 598   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(599)).setAttribute("src","b.gif" );
      ((Element)v.get(598)).appendChild((Element)v.get(599));
      /* Termina nodo:599   */
      /* Termina nodo:598   */
      /* Termina nodo:587   */
      /* Termina nodo:586   */
      /* Termina nodo:585   */
      /* Termina nodo:582   */

      /* Empieza nodo:600 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(600)).setAttribute("nombre","formGapTr21" );
      ((Element)v.get(52)).appendChild((Element)v.get(600));

      /* Empieza nodo:601 / Elemento padre: 600   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(601)).setAttribute("align","center" );
      ((Element)v.get(601)).setAttribute("width","8" );
      ((Element)v.get(600)).appendChild((Element)v.get(601));

      /* Empieza nodo:602 / Elemento padre: 601   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(602)).setAttribute("src","b.gif" );
      ((Element)v.get(602)).setAttribute("width","12" );
      ((Element)v.get(602)).setAttribute("height","8" );
      ((Element)v.get(601)).appendChild((Element)v.get(602));
      /* Termina nodo:602   */
      /* Termina nodo:601   */

      /* Empieza nodo:603 / Elemento padre: 600   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(600)).appendChild((Element)v.get(603));

      /* Empieza nodo:604 / Elemento padre: 603   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(604)).setAttribute("src","b.gif" );
      ((Element)v.get(604)).setAttribute("width","8" );
      ((Element)v.get(604)).setAttribute("height","8" );
      ((Element)v.get(603)).appendChild((Element)v.get(604));
      /* Termina nodo:604   */
      /* Termina nodo:603   */

      /* Empieza nodo:605 / Elemento padre: 600   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(605)).setAttribute("align","center" );
      ((Element)v.get(605)).setAttribute("width","8" );
      ((Element)v.get(600)).appendChild((Element)v.get(605));

      /* Empieza nodo:606 / Elemento padre: 605   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(606)).setAttribute("src","b.gif" );
      ((Element)v.get(606)).setAttribute("width","12" );
      ((Element)v.get(606)).setAttribute("height","8" );
      ((Element)v.get(605)).appendChild((Element)v.get(606));
      /* Termina nodo:606   */
      /* Termina nodo:605   */
      /* Termina nodo:600   */

      /* Empieza nodo:607 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(607)).setAttribute("nombre","formTr22" );
      ((Element)v.get(52)).appendChild((Element)v.get(607));

      /* Empieza nodo:608 / Elemento padre: 607   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(608)).setAttribute("align","center" );
      ((Element)v.get(608)).setAttribute("width","8" );
      ((Element)v.get(607)).appendChild((Element)v.get(608));

      /* Empieza nodo:609 / Elemento padre: 608   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(609)).setAttribute("src","b.gif" );
      ((Element)v.get(609)).setAttribute("width","8" );
      ((Element)v.get(609)).setAttribute("height","12" );
      ((Element)v.get(608)).appendChild((Element)v.get(609));
      /* Termina nodo:609   */
      /* Termina nodo:608   */

      /* Empieza nodo:610 / Elemento padre: 607   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(610)).setAttribute("width","100%" );
      ((Element)v.get(607)).appendChild((Element)v.get(610));

      /* Empieza nodo:611 / Elemento padre: 610   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(611)).setAttribute("width","100%" );
      ((Element)v.get(611)).setAttribute("border","0" );
      ((Element)v.get(611)).setAttribute("cellspacing","0" );
      ((Element)v.get(611)).setAttribute("cellpadding","0" );
      ((Element)v.get(611)).setAttribute("align","left" );
      ((Element)v.get(610)).appendChild((Element)v.get(611));

      /* Empieza nodo:612 / Elemento padre: 611   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(612)).setAttribute("align","left" );
      ((Element)v.get(611)).appendChild((Element)v.get(612));

      /* Empieza nodo:613 / Elemento padre: 612   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(613)).setAttribute("nombre","codImpuTdId" );
      ((Element)v.get(612)).appendChild((Element)v.get(613));

      /* Empieza nodo:614 / Elemento padre: 613   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(614)).setAttribute("width","100%" );
      ((Element)v.get(614)).setAttribute("border","0" );
      ((Element)v.get(614)).setAttribute("cellspacing","0" );
      ((Element)v.get(614)).setAttribute("cellpadding","0" );
      ((Element)v.get(614)).setAttribute("align","left" );
      ((Element)v.get(613)).appendChild((Element)v.get(614));

      /* Empieza nodo:615 / Elemento padre: 614   */
      v.add(doc.createElement("TR"));
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(614)).appendChild((Element)v.get(615));

      /* Empieza nodo:616 / Elemento padre: 615   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(616)).setAttribute("valign","top" );
      ((Element)v.get(616)).setAttribute("height","13" );
      ((Element)v.get(615)).appendChild((Element)v.get(616));

      /* Empieza nodo:617 / Elemento padre: 616   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(617)).setAttribute("nombre","lblCodImpu" );
      ((Element)v.get(617)).setAttribute("alto","13" );
      ((Element)v.get(617)).setAttribute("filas","1" );
      ((Element)v.get(617)).setAttribute("id","datosTitle" );
      ((Element)v.get(617)).setAttribute("cod","MaeProdu.codImpu.label" );
      ((Element)v.get(616)).appendChild((Element)v.get(617));
      /* Termina nodo:617   */
      /* Termina nodo:616   */
      /* Termina nodo:615   */

      /* Empieza nodo:618 / Elemento padre: 614   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(618)).setAttribute("nombre","codImpuWidgetTrId" );
      ((Element)v.get(614)).appendChild((Element)v.get(618));

      /* Empieza nodo:619 / Elemento padre: 618   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(619)).setAttribute("align","left" );
      ((Element)v.get(619)).setAttribute("nowrap","true" );
      ((Element)v.get(618)).appendChild((Element)v.get(619));

      /* Empieza nodo:620 / Elemento padre: 619   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(620)).setAttribute("nombre","codImpu" );
      ((Element)v.get(620)).setAttribute("id","datosCampos" );
      ((Element)v.get(620)).setAttribute("trim","S" );
      ((Element)v.get(620)).setAttribute("max","2" );
      ((Element)v.get(620)).setAttribute("onchange","" );
      ((Element)v.get(620)).setAttribute("req","N" );
      ((Element)v.get(620)).setAttribute("size","2" );
      ((Element)v.get(620)).setAttribute("valor","" );
      ((Element)v.get(620)).setAttribute("validacion","" );
      ((Element)v.get(620)).setAttribute("disabled","" );
      ((Element)v.get(620)).setAttribute("onblur","" );
      ((Element)v.get(620)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true)" );
      ((Element)v.get(620)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm', 0, false)" );
      ((Element)v.get(619)).appendChild((Element)v.get(620));
      /* Termina nodo:620   */
      /* Termina nodo:619   */
      /* Termina nodo:618   */
      /* Termina nodo:614   */
      /* Termina nodo:613   */

      /* Empieza nodo:621 / Elemento padre: 612   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(621)).setAttribute("nombre","codImpuGapTdId" );
      ((Element)v.get(621)).setAttribute("nowrap","true" );
      ((Element)v.get(621)).setAttribute("class","datosCampos" );
      ((Element)v.get(612)).appendChild((Element)v.get(621));

      /* Empieza nodo:622 / Elemento padre: 621   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(622)).setAttribute("src","b.gif" );
      ((Element)v.get(622)).setAttribute("width","25" );
      ((Element)v.get(622)).setAttribute("height","8" );
      ((Element)v.get(621)).appendChild((Element)v.get(622));
      /* Termina nodo:622   */
      /* Termina nodo:621   */

      /* Empieza nodo:623 / Elemento padre: 612   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(623)).setAttribute("width","100%" );
      ((Element)v.get(612)).appendChild((Element)v.get(623));

      /* Empieza nodo:624 / Elemento padre: 623   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(624)).setAttribute("src","b.gif" );
      ((Element)v.get(623)).appendChild((Element)v.get(624));
      /* Termina nodo:624   */
      /* Termina nodo:623   */
      /* Termina nodo:612   */
      /* Termina nodo:611   */
      /* Termina nodo:610   */
      /* Termina nodo:607   */

      /* Empieza nodo:625 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(625)).setAttribute("nombre","formGapTr22" );
      ((Element)v.get(52)).appendChild((Element)v.get(625));

      /* Empieza nodo:626 / Elemento padre: 625   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(626)).setAttribute("align","center" );
      ((Element)v.get(626)).setAttribute("width","8" );
      ((Element)v.get(625)).appendChild((Element)v.get(626));

      /* Empieza nodo:627 / Elemento padre: 626   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(627)).setAttribute("src","b.gif" );
      ((Element)v.get(627)).setAttribute("width","12" );
      ((Element)v.get(627)).setAttribute("height","8" );
      ((Element)v.get(626)).appendChild((Element)v.get(627));
      /* Termina nodo:627   */
      /* Termina nodo:626   */

      /* Empieza nodo:628 / Elemento padre: 625   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(625)).appendChild((Element)v.get(628));

      /* Empieza nodo:629 / Elemento padre: 628   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(629)).setAttribute("src","b.gif" );
      ((Element)v.get(629)).setAttribute("width","8" );
      ((Element)v.get(629)).setAttribute("height","8" );
      ((Element)v.get(628)).appendChild((Element)v.get(629));
      /* Termina nodo:629   */
      /* Termina nodo:628   */

      /* Empieza nodo:630 / Elemento padre: 625   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(630)).setAttribute("align","center" );
      ((Element)v.get(630)).setAttribute("width","8" );
      ((Element)v.get(625)).appendChild((Element)v.get(630));

      /* Empieza nodo:631 / Elemento padre: 630   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(631)).setAttribute("src","b.gif" );
      ((Element)v.get(631)).setAttribute("width","12" );
      ((Element)v.get(631)).setAttribute("height","8" );
      ((Element)v.get(630)).appendChild((Element)v.get(631));
      /* Termina nodo:631   */
      /* Termina nodo:630   */
      /* Termina nodo:625   */

      /* Empieza nodo:632 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(632)).setAttribute("nombre","formTr23" );
      ((Element)v.get(52)).appendChild((Element)v.get(632));

      /* Empieza nodo:633 / Elemento padre: 632   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(633)).setAttribute("align","center" );
      ((Element)v.get(633)).setAttribute("width","8" );
      ((Element)v.get(632)).appendChild((Element)v.get(633));

      /* Empieza nodo:634 / Elemento padre: 633   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(634)).setAttribute("src","b.gif" );
      ((Element)v.get(634)).setAttribute("width","8" );
      ((Element)v.get(634)).setAttribute("height","12" );
      ((Element)v.get(633)).appendChild((Element)v.get(634));
      /* Termina nodo:634   */
      /* Termina nodo:633   */

      /* Empieza nodo:635 / Elemento padre: 632   */
   }

   private void getXML2880(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(635)).setAttribute("width","100%" );
      ((Element)v.get(632)).appendChild((Element)v.get(635));

      /* Empieza nodo:636 / Elemento padre: 635   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(636)).setAttribute("width","100%" );
      ((Element)v.get(636)).setAttribute("border","0" );
      ((Element)v.get(636)).setAttribute("cellspacing","0" );
      ((Element)v.get(636)).setAttribute("cellpadding","0" );
      ((Element)v.get(636)).setAttribute("align","left" );
      ((Element)v.get(635)).appendChild((Element)v.get(636));

      /* Empieza nodo:637 / Elemento padre: 636   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(637)).setAttribute("align","left" );
      ((Element)v.get(636)).appendChild((Element)v.get(637));

      /* Empieza nodo:638 / Elemento padre: 637   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(638)).setAttribute("nombre","pctUnidTdId" );
      ((Element)v.get(637)).appendChild((Element)v.get(638));

      /* Empieza nodo:639 / Elemento padre: 638   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(639)).setAttribute("width","100%" );
      ((Element)v.get(639)).setAttribute("border","0" );
      ((Element)v.get(639)).setAttribute("cellspacing","0" );
      ((Element)v.get(639)).setAttribute("cellpadding","0" );
      ((Element)v.get(639)).setAttribute("align","left" );
      ((Element)v.get(638)).appendChild((Element)v.get(639));

      /* Empieza nodo:640 / Elemento padre: 639   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(639)).appendChild((Element)v.get(640));

      /* Empieza nodo:641 / Elemento padre: 640   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(641)).setAttribute("valign","top" );
      ((Element)v.get(641)).setAttribute("height","13" );
      ((Element)v.get(640)).appendChild((Element)v.get(641));

      /* Empieza nodo:642 / Elemento padre: 641   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(642)).setAttribute("nombre","lblPctUnid" );
      ((Element)v.get(642)).setAttribute("alto","13" );
      ((Element)v.get(642)).setAttribute("filas","1" );
      ((Element)v.get(642)).setAttribute("id","datosTitle" );
      ((Element)v.get(642)).setAttribute("cod","MaeProdu.pctUnid.label" );
      ((Element)v.get(641)).appendChild((Element)v.get(642));
      /* Termina nodo:642   */
      /* Termina nodo:641   */
      /* Termina nodo:640   */

      /* Empieza nodo:643 / Elemento padre: 639   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(643)).setAttribute("nombre","pctUnidWidgetTrId" );
      ((Element)v.get(639)).appendChild((Element)v.get(643));

      /* Empieza nodo:644 / Elemento padre: 643   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(644)).setAttribute("align","left" );
      ((Element)v.get(644)).setAttribute("nowrap","true" );
      ((Element)v.get(643)).appendChild((Element)v.get(644));

      /* Empieza nodo:645 / Elemento padre: 644   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(645)).setAttribute("nombre","pctUnid" );
      ((Element)v.get(645)).setAttribute("id","datosCampos" );
      ((Element)v.get(645)).setAttribute("trim","S" );
      ((Element)v.get(645)).setAttribute("max","3" );
      ((Element)v.get(645)).setAttribute("onchange","" );
      ((Element)v.get(645)).setAttribute("req","N" );
      ((Element)v.get(645)).setAttribute("size","3" );
      ((Element)v.get(645)).setAttribute("valor","" );
      ((Element)v.get(645)).setAttribute("validacion","" );
      ((Element)v.get(645)).setAttribute("disabled","" );
      ((Element)v.get(645)).setAttribute("onblur","" );
      ((Element)v.get(645)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true)" );
      ((Element)v.get(645)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm', 0, false)" );
      ((Element)v.get(644)).appendChild((Element)v.get(645));
      /* Termina nodo:645   */
      /* Termina nodo:644   */
      /* Termina nodo:643   */
      /* Termina nodo:639   */
      /* Termina nodo:638   */

      /* Empieza nodo:646 / Elemento padre: 637   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(646)).setAttribute("nombre","pctUnidGapTdId" );
      ((Element)v.get(646)).setAttribute("nowrap","true" );
      ((Element)v.get(646)).setAttribute("class","datosCampos" );
      ((Element)v.get(637)).appendChild((Element)v.get(646));

      /* Empieza nodo:647 / Elemento padre: 646   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(647)).setAttribute("src","b.gif" );
      ((Element)v.get(647)).setAttribute("width","25" );
      ((Element)v.get(647)).setAttribute("height","8" );
      ((Element)v.get(646)).appendChild((Element)v.get(647));
      /* Termina nodo:647   */
      /* Termina nodo:646   */

      /* Empieza nodo:648 / Elemento padre: 637   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(648)).setAttribute("width","100%" );
      ((Element)v.get(637)).appendChild((Element)v.get(648));

      /* Empieza nodo:649 / Elemento padre: 648   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(649)).setAttribute("src","b.gif" );
      ((Element)v.get(648)).appendChild((Element)v.get(649));
      /* Termina nodo:649   */
      /* Termina nodo:648   */
      /* Termina nodo:637   */
      /* Termina nodo:636   */
      /* Termina nodo:635   */
      /* Termina nodo:632   */

      /* Empieza nodo:650 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(650)).setAttribute("nombre","formGapTr23" );
      ((Element)v.get(52)).appendChild((Element)v.get(650));

      /* Empieza nodo:651 / Elemento padre: 650   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(651)).setAttribute("align","center" );
      ((Element)v.get(651)).setAttribute("width","8" );
      ((Element)v.get(650)).appendChild((Element)v.get(651));

      /* Empieza nodo:652 / Elemento padre: 651   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(652)).setAttribute("src","b.gif" );
      ((Element)v.get(652)).setAttribute("width","12" );
      ((Element)v.get(652)).setAttribute("height","8" );
      ((Element)v.get(651)).appendChild((Element)v.get(652));
      /* Termina nodo:652   */
      /* Termina nodo:651   */

      /* Empieza nodo:653 / Elemento padre: 650   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(650)).appendChild((Element)v.get(653));

      /* Empieza nodo:654 / Elemento padre: 653   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(654)).setAttribute("src","b.gif" );
   }

   private void getXML2970(Document doc) {
      ((Element)v.get(654)).setAttribute("width","8" );
      ((Element)v.get(654)).setAttribute("height","8" );
      ((Element)v.get(653)).appendChild((Element)v.get(654));
      /* Termina nodo:654   */
      /* Termina nodo:653   */

      /* Empieza nodo:655 / Elemento padre: 650   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(655)).setAttribute("align","center" );
      ((Element)v.get(655)).setAttribute("width","8" );
      ((Element)v.get(650)).appendChild((Element)v.get(655));

      /* Empieza nodo:656 / Elemento padre: 655   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(656)).setAttribute("src","b.gif" );
      ((Element)v.get(656)).setAttribute("width","12" );
      ((Element)v.get(656)).setAttribute("height","8" );
      ((Element)v.get(655)).appendChild((Element)v.get(656));
      /* Termina nodo:656   */
      /* Termina nodo:655   */
      /* Termina nodo:650   */

      /* Empieza nodo:657 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(657)).setAttribute("nombre","formTr24" );
      ((Element)v.get(52)).appendChild((Element)v.get(657));

      /* Empieza nodo:658 / Elemento padre: 657   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(658)).setAttribute("align","center" );
      ((Element)v.get(658)).setAttribute("width","8" );
      ((Element)v.get(657)).appendChild((Element)v.get(658));

      /* Empieza nodo:659 / Elemento padre: 658   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(659)).setAttribute("src","b.gif" );
      ((Element)v.get(659)).setAttribute("width","8" );
      ((Element)v.get(659)).setAttribute("height","12" );
      ((Element)v.get(658)).appendChild((Element)v.get(659));
      /* Termina nodo:659   */
      /* Termina nodo:658   */

      /* Empieza nodo:660 / Elemento padre: 657   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(660)).setAttribute("width","100%" );
      ((Element)v.get(657)).appendChild((Element)v.get(660));

      /* Empieza nodo:661 / Elemento padre: 660   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(661)).setAttribute("width","100%" );
      ((Element)v.get(661)).setAttribute("border","0" );
      ((Element)v.get(661)).setAttribute("cellspacing","0" );
      ((Element)v.get(661)).setAttribute("cellpadding","0" );
      ((Element)v.get(661)).setAttribute("align","left" );
      ((Element)v.get(660)).appendChild((Element)v.get(661));

      /* Empieza nodo:662 / Elemento padre: 661   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(662)).setAttribute("align","left" );
      ((Element)v.get(661)).appendChild((Element)v.get(662));

      /* Empieza nodo:663 / Elemento padre: 662   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(663)).setAttribute("nombre","geneOidGeneTdId" );
      ((Element)v.get(662)).appendChild((Element)v.get(663));

      /* Empieza nodo:664 / Elemento padre: 663   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(664)).setAttribute("border","0" );
      ((Element)v.get(664)).setAttribute("cellspacing","0" );
      ((Element)v.get(664)).setAttribute("cellpadding","0" );
      ((Element)v.get(664)).setAttribute("align","left" );
      ((Element)v.get(663)).appendChild((Element)v.get(664));

      /* Empieza nodo:665 / Elemento padre: 664   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(664)).appendChild((Element)v.get(665));

      /* Empieza nodo:666 / Elemento padre: 665   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(666)).setAttribute("valign","top" );
      ((Element)v.get(666)).setAttribute("height","13" );
      ((Element)v.get(665)).appendChild((Element)v.get(666));

      /* Empieza nodo:667 / Elemento padre: 666   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(667)).setAttribute("nombre","lblgeneOidGene" );
      ((Element)v.get(667)).setAttribute("id","datosTitle" );
      ((Element)v.get(667)).setAttribute("ancho","150" );
      ((Element)v.get(667)).setAttribute("alto","13" );
      ((Element)v.get(667)).setAttribute("cod","MaeProdu.geneOidGene.label" );
      ((Element)v.get(666)).appendChild((Element)v.get(667));
      /* Termina nodo:667   */
      /* Termina nodo:666   */
      /* Termina nodo:665   */

      /* Empieza nodo:668 / Elemento padre: 664   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(668)).setAttribute("nombre","geneOidGeneWidgetTrId" );
      ((Element)v.get(664)).appendChild((Element)v.get(668));

      /* Empieza nodo:669 / Elemento padre: 668   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(669)).setAttribute("align","left" );
      ((Element)v.get(669)).setAttribute("nowrap","true" );
      ((Element)v.get(668)).appendChild((Element)v.get(669));

      /* Empieza nodo:670 / Elemento padre: 669   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(670)).setAttribute("nombre","geneOidGene" );
      ((Element)v.get(670)).setAttribute("id","datosCampos" );
      ((Element)v.get(670)).setAttribute("multiple","N" );
      ((Element)v.get(670)).setAttribute("req","N" );
      ((Element)v.get(670)).setAttribute("size","1" );
      ((Element)v.get(670)).setAttribute("disabled","" );
      ((Element)v.get(670)).setAttribute("validacion","" );
      ((Element)v.get(670)).setAttribute("onchange","" );
      ((Element)v.get(670)).setAttribute("onfocus","" );
      ((Element)v.get(670)).setAttribute("valorinicial","" );
      ((Element)v.get(670)).setAttribute("textoinicial","" );
      ((Element)v.get(670)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true);" );
      ((Element)v.get(670)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm',0, false);" );
      ((Element)v.get(669)).appendChild((Element)v.get(670));

      /* Empieza nodo:671 / Elemento padre: 670   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(670)).appendChild((Element)v.get(671));
      /* Termina nodo:671   */
      /* Termina nodo:670   */
      /* Termina nodo:669   */
      /* Termina nodo:668   */
      /* Termina nodo:664   */
      /* Termina nodo:663   */

      /* Empieza nodo:672 / Elemento padre: 662   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(672)).setAttribute("nombre","geneOidGeneGapTdId" );
      ((Element)v.get(672)).setAttribute("nowrap","true" );
      ((Element)v.get(672)).setAttribute("class","datosCampos" );
      ((Element)v.get(662)).appendChild((Element)v.get(672));

      /* Empieza nodo:673 / Elemento padre: 672   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(673)).setAttribute("src","b.gif" );
   }

   private void getXML3060(Document doc) {
      ((Element)v.get(673)).setAttribute("width","25" );
      ((Element)v.get(673)).setAttribute("height","8" );
      ((Element)v.get(672)).appendChild((Element)v.get(673));
      /* Termina nodo:673   */
      /* Termina nodo:672   */

      /* Empieza nodo:674 / Elemento padre: 662   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(674)).setAttribute("width","100%" );
      ((Element)v.get(662)).appendChild((Element)v.get(674));

      /* Empieza nodo:675 / Elemento padre: 674   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(675)).setAttribute("src","b.gif" );
      ((Element)v.get(674)).appendChild((Element)v.get(675));
      /* Termina nodo:675   */
      /* Termina nodo:674   */
      /* Termina nodo:662   */
      /* Termina nodo:661   */
      /* Termina nodo:660   */
      /* Termina nodo:657   */

      /* Empieza nodo:676 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(676)).setAttribute("nombre","formGapTr24" );
      ((Element)v.get(52)).appendChild((Element)v.get(676));

      /* Empieza nodo:677 / Elemento padre: 676   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(677)).setAttribute("align","center" );
      ((Element)v.get(677)).setAttribute("width","8" );
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
      ((Element)v.get(681)).setAttribute("width","8" );
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

      /* Empieza nodo:683 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(683)).setAttribute("nombre","formTr25" );
      ((Element)v.get(52)).appendChild((Element)v.get(683));

      /* Empieza nodo:684 / Elemento padre: 683   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(684)).setAttribute("align","center" );
      ((Element)v.get(684)).setAttribute("width","8" );
      ((Element)v.get(683)).appendChild((Element)v.get(684));

      /* Empieza nodo:685 / Elemento padre: 684   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(685)).setAttribute("src","b.gif" );
      ((Element)v.get(685)).setAttribute("width","8" );
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
      ((Element)v.get(689)).setAttribute("nombre","sgenOidSupeGeneTdId" );
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
      ((Element)v.get(693)).setAttribute("nombre","lblsgenOidSupeGene" );
      ((Element)v.get(693)).setAttribute("id","datosTitle" );
      ((Element)v.get(693)).setAttribute("ancho","150" );
      ((Element)v.get(693)).setAttribute("alto","13" );
      ((Element)v.get(693)).setAttribute("cod","MaeProdu.sgenOidSupeGene.label" );
      ((Element)v.get(692)).appendChild((Element)v.get(693));
      /* Termina nodo:693   */
      /* Termina nodo:692   */
      /* Termina nodo:691   */

      /* Empieza nodo:694 / Elemento padre: 690   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(694)).setAttribute("nombre","sgenOidSupeGeneWidgetTrId" );
      ((Element)v.get(690)).appendChild((Element)v.get(694));

      /* Empieza nodo:695 / Elemento padre: 694   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(695)).setAttribute("align","left" );
      ((Element)v.get(695)).setAttribute("nowrap","true" );
   }

   private void getXML3150(Document doc) {
      ((Element)v.get(694)).appendChild((Element)v.get(695));

      /* Empieza nodo:696 / Elemento padre: 695   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(696)).setAttribute("nombre","sgenOidSupeGene" );
      ((Element)v.get(696)).setAttribute("id","datosCampos" );
      ((Element)v.get(696)).setAttribute("multiple","N" );
      ((Element)v.get(696)).setAttribute("req","N" );
      ((Element)v.get(696)).setAttribute("size","1" );
      ((Element)v.get(696)).setAttribute("disabled","" );
      ((Element)v.get(696)).setAttribute("validacion","" );
      ((Element)v.get(696)).setAttribute("onchange","" );
      ((Element)v.get(696)).setAttribute("onfocus","" );
      ((Element)v.get(696)).setAttribute("valorinicial","" );
      ((Element)v.get(696)).setAttribute("textoinicial","" );
      ((Element)v.get(696)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true);" );
      ((Element)v.get(696)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm',0, false);" );
      ((Element)v.get(695)).appendChild((Element)v.get(696));

      /* Empieza nodo:697 / Elemento padre: 696   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(696)).appendChild((Element)v.get(697));
      /* Termina nodo:697   */
      /* Termina nodo:696   */
      /* Termina nodo:695   */
      /* Termina nodo:694   */
      /* Termina nodo:690   */
      /* Termina nodo:689   */

      /* Empieza nodo:698 / Elemento padre: 688   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(698)).setAttribute("nombre","sgenOidSupeGeneGapTdId" );
      ((Element)v.get(698)).setAttribute("nowrap","true" );
      ((Element)v.get(698)).setAttribute("class","datosCampos" );
      ((Element)v.get(688)).appendChild((Element)v.get(698));

      /* Empieza nodo:699 / Elemento padre: 698   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(699)).setAttribute("src","b.gif" );
      ((Element)v.get(699)).setAttribute("width","25" );
      ((Element)v.get(699)).setAttribute("height","8" );
      ((Element)v.get(698)).appendChild((Element)v.get(699));
      /* Termina nodo:699   */
      /* Termina nodo:698   */

      /* Empieza nodo:700 / Elemento padre: 688   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(700)).setAttribute("width","100%" );
      ((Element)v.get(688)).appendChild((Element)v.get(700));

      /* Empieza nodo:701 / Elemento padre: 700   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(701)).setAttribute("src","b.gif" );
      ((Element)v.get(700)).appendChild((Element)v.get(701));
      /* Termina nodo:701   */
      /* Termina nodo:700   */
      /* Termina nodo:688   */
      /* Termina nodo:687   */
      /* Termina nodo:686   */
      /* Termina nodo:683   */

      /* Empieza nodo:702 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(702)).setAttribute("nombre","formGapTr25" );
      ((Element)v.get(52)).appendChild((Element)v.get(702));

      /* Empieza nodo:703 / Elemento padre: 702   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(703)).setAttribute("align","center" );
      ((Element)v.get(703)).setAttribute("width","8" );
      ((Element)v.get(702)).appendChild((Element)v.get(703));

      /* Empieza nodo:704 / Elemento padre: 703   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(704)).setAttribute("src","b.gif" );
      ((Element)v.get(704)).setAttribute("width","12" );
      ((Element)v.get(704)).setAttribute("height","8" );
      ((Element)v.get(703)).appendChild((Element)v.get(704));
      /* Termina nodo:704   */
      /* Termina nodo:703   */

      /* Empieza nodo:705 / Elemento padre: 702   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(702)).appendChild((Element)v.get(705));

      /* Empieza nodo:706 / Elemento padre: 705   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(706)).setAttribute("src","b.gif" );
      ((Element)v.get(706)).setAttribute("width","8" );
      ((Element)v.get(706)).setAttribute("height","8" );
      ((Element)v.get(705)).appendChild((Element)v.get(706));
      /* Termina nodo:706   */
      /* Termina nodo:705   */

      /* Empieza nodo:707 / Elemento padre: 702   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(707)).setAttribute("align","center" );
      ((Element)v.get(707)).setAttribute("width","8" );
      ((Element)v.get(702)).appendChild((Element)v.get(707));

      /* Empieza nodo:708 / Elemento padre: 707   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(708)).setAttribute("src","b.gif" );
      ((Element)v.get(708)).setAttribute("width","12" );
      ((Element)v.get(708)).setAttribute("height","8" );
      ((Element)v.get(707)).appendChild((Element)v.get(708));
      /* Termina nodo:708   */
      /* Termina nodo:707   */
      /* Termina nodo:702   */

      /* Empieza nodo:709 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(709)).setAttribute("nombre","formTr26" );
      ((Element)v.get(52)).appendChild((Element)v.get(709));

      /* Empieza nodo:710 / Elemento padre: 709   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(710)).setAttribute("align","center" );
      ((Element)v.get(710)).setAttribute("width","8" );
      ((Element)v.get(709)).appendChild((Element)v.get(710));

      /* Empieza nodo:711 / Elemento padre: 710   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(711)).setAttribute("src","b.gif" );
      ((Element)v.get(711)).setAttribute("width","8" );
      ((Element)v.get(711)).setAttribute("height","12" );
      ((Element)v.get(710)).appendChild((Element)v.get(711));
      /* Termina nodo:711   */
      /* Termina nodo:710   */

      /* Empieza nodo:712 / Elemento padre: 709   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(712)).setAttribute("width","100%" );
      ((Element)v.get(709)).appendChild((Element)v.get(712));

      /* Empieza nodo:713 / Elemento padre: 712   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(713)).setAttribute("width","100%" );
      ((Element)v.get(713)).setAttribute("border","0" );
      ((Element)v.get(713)).setAttribute("cellspacing","0" );
      ((Element)v.get(713)).setAttribute("cellpadding","0" );
      ((Element)v.get(713)).setAttribute("align","left" );
      ((Element)v.get(712)).appendChild((Element)v.get(713));

      /* Empieza nodo:714 / Elemento padre: 713   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(714)).setAttribute("align","left" );
      ((Element)v.get(713)).appendChild((Element)v.get(714));

      /* Empieza nodo:715 / Elemento padre: 714   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(715)).setAttribute("nombre","unmdOidUnidMedi_magnOidMagnTdId" );
      ((Element)v.get(714)).appendChild((Element)v.get(715));

      /* Empieza nodo:716 / Elemento padre: 715   */
   }

   private void getXML3240(Document doc) {
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(716)).setAttribute("border","0" );
      ((Element)v.get(716)).setAttribute("cellspacing","0" );
      ((Element)v.get(716)).setAttribute("cellpadding","0" );
      ((Element)v.get(716)).setAttribute("align","left" );
      ((Element)v.get(715)).appendChild((Element)v.get(716));

      /* Empieza nodo:717 / Elemento padre: 716   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(716)).appendChild((Element)v.get(717));

      /* Empieza nodo:718 / Elemento padre: 717   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(718)).setAttribute("valign","top" );
      ((Element)v.get(718)).setAttribute("height","13" );
      ((Element)v.get(717)).appendChild((Element)v.get(718));

      /* Empieza nodo:719 / Elemento padre: 718   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(719)).setAttribute("nombre","lblunmdOidUnidMedi_magnOidMagn" );
      ((Element)v.get(719)).setAttribute("id","datosTitle" );
      ((Element)v.get(719)).setAttribute("ancho","150" );
      ((Element)v.get(719)).setAttribute("alto","13" );
      ((Element)v.get(719)).setAttribute("cod","MaeUnidaMedid.magnOidMagn.label" );
      ((Element)v.get(718)).appendChild((Element)v.get(719));
      /* Termina nodo:719   */
      /* Termina nodo:718   */
      /* Termina nodo:717   */

      /* Empieza nodo:720 / Elemento padre: 716   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(720)).setAttribute("nombre","unmdOidUnidMedi_magnOidMagnWidgetTrId" );
      ((Element)v.get(716)).appendChild((Element)v.get(720));

      /* Empieza nodo:721 / Elemento padre: 720   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(721)).setAttribute("align","left" );
      ((Element)v.get(721)).setAttribute("nowrap","true" );
      ((Element)v.get(720)).appendChild((Element)v.get(721));

      /* Empieza nodo:722 / Elemento padre: 721   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(722)).setAttribute("nombre","unmdOidUnidMedi_magnOidMagn" );
      ((Element)v.get(722)).setAttribute("id","datosCampos" );
      ((Element)v.get(722)).setAttribute("multiple","N" );
      ((Element)v.get(722)).setAttribute("req","N" );
      ((Element)v.get(722)).setAttribute("size","1" );
      ((Element)v.get(722)).setAttribute("disabled","" );
      ((Element)v.get(722)).setAttribute("validacion","" );
      ((Element)v.get(722)).setAttribute("onchange","mmgDependeneChange('unmdOidUnidMedi_magnOidMagn', 'unmdOidUnidMedi' , 'maeProdu')" );
      ((Element)v.get(722)).setAttribute("onfocus","" );
      ((Element)v.get(722)).setAttribute("valorinicial","" );
      ((Element)v.get(722)).setAttribute("textoinicial","" );
      ((Element)v.get(722)).setAttribute("ontab","focaliza('maeProduFrm.unmdOidUnidMedi');" );
      ((Element)v.get(722)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm',0, false);" );
      ((Element)v.get(721)).appendChild((Element)v.get(722));

      /* Empieza nodo:723 / Elemento padre: 722   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(722)).appendChild((Element)v.get(723));
      /* Termina nodo:723   */
      /* Termina nodo:722   */
      /* Termina nodo:721   */
      /* Termina nodo:720   */
      /* Termina nodo:716   */
      /* Termina nodo:715   */

      /* Empieza nodo:724 / Elemento padre: 714   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(724)).setAttribute("nombre","unmdOidUnidMedi_magnOidMagnGapTdId" );
      ((Element)v.get(724)).setAttribute("nowrap","true" );
      ((Element)v.get(724)).setAttribute("class","datosCampos" );
      ((Element)v.get(714)).appendChild((Element)v.get(724));

      /* Empieza nodo:725 / Elemento padre: 724   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(725)).setAttribute("src","b.gif" );
      ((Element)v.get(725)).setAttribute("width","25" );
      ((Element)v.get(725)).setAttribute("height","8" );
      ((Element)v.get(724)).appendChild((Element)v.get(725));
      /* Termina nodo:725   */
      /* Termina nodo:724   */

      /* Empieza nodo:726 / Elemento padre: 714   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(726)).setAttribute("nombre","unmdOidUnidMediTdId" );
      ((Element)v.get(714)).appendChild((Element)v.get(726));

      /* Empieza nodo:727 / Elemento padre: 726   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(727)).setAttribute("border","0" );
      ((Element)v.get(727)).setAttribute("cellspacing","0" );
      ((Element)v.get(727)).setAttribute("cellpadding","0" );
      ((Element)v.get(727)).setAttribute("align","left" );
      ((Element)v.get(726)).appendChild((Element)v.get(727));

      /* Empieza nodo:728 / Elemento padre: 727   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(727)).appendChild((Element)v.get(728));

      /* Empieza nodo:729 / Elemento padre: 728   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(729)).setAttribute("valign","top" );
      ((Element)v.get(729)).setAttribute("height","13" );
      ((Element)v.get(728)).appendChild((Element)v.get(729));

      /* Empieza nodo:730 / Elemento padre: 729   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(730)).setAttribute("nombre","lblunmdOidUnidMedi" );
      ((Element)v.get(730)).setAttribute("id","datosTitle" );
      ((Element)v.get(730)).setAttribute("ancho","150" );
      ((Element)v.get(730)).setAttribute("alto","13" );
      ((Element)v.get(730)).setAttribute("cod","MaeProdu.unmdOidUnidMedi.label" );
      ((Element)v.get(729)).appendChild((Element)v.get(730));
      /* Termina nodo:730   */
      /* Termina nodo:729   */
      /* Termina nodo:728   */

      /* Empieza nodo:731 / Elemento padre: 727   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(731)).setAttribute("nombre","unmdOidUnidMediWidgetTrId" );
      ((Element)v.get(727)).appendChild((Element)v.get(731));

      /* Empieza nodo:732 / Elemento padre: 731   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(732)).setAttribute("align","left" );
      ((Element)v.get(732)).setAttribute("nowrap","true" );
      ((Element)v.get(731)).appendChild((Element)v.get(732));

      /* Empieza nodo:733 / Elemento padre: 732   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(733)).setAttribute("nombre","unmdOidUnidMedi" );
      ((Element)v.get(733)).setAttribute("id","datosCampos" );
      ((Element)v.get(733)).setAttribute("multiple","N" );
      ((Element)v.get(733)).setAttribute("req","N" );
      ((Element)v.get(733)).setAttribute("size","1" );
      ((Element)v.get(733)).setAttribute("disabled","" );
      ((Element)v.get(733)).setAttribute("validacion","" );
   }

   private void getXML3330(Document doc) {
      ((Element)v.get(733)).setAttribute("onchange","" );
      ((Element)v.get(733)).setAttribute("onfocus","" );
      ((Element)v.get(733)).setAttribute("valorinicial","" );
      ((Element)v.get(733)).setAttribute("textoinicial","" );
      ((Element)v.get(733)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true);" );
      ((Element)v.get(733)).setAttribute("onshtab","focaliza('maeProduFrm.unmdOidUnidMedi_magnOidMagn');" );
      ((Element)v.get(732)).appendChild((Element)v.get(733));

      /* Empieza nodo:734 / Elemento padre: 733   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(733)).appendChild((Element)v.get(734));
      /* Termina nodo:734   */
      /* Termina nodo:733   */
      /* Termina nodo:732   */
      /* Termina nodo:731   */
      /* Termina nodo:727   */
      /* Termina nodo:726   */

      /* Empieza nodo:735 / Elemento padre: 714   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(735)).setAttribute("nombre","unmdOidUnidMediGapTdId" );
      ((Element)v.get(735)).setAttribute("nowrap","true" );
      ((Element)v.get(735)).setAttribute("class","datosCampos" );
      ((Element)v.get(714)).appendChild((Element)v.get(735));

      /* Empieza nodo:736 / Elemento padre: 735   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(736)).setAttribute("src","b.gif" );
      ((Element)v.get(736)).setAttribute("width","25" );
      ((Element)v.get(736)).setAttribute("height","8" );
      ((Element)v.get(735)).appendChild((Element)v.get(736));
      /* Termina nodo:736   */
      /* Termina nodo:735   */

      /* Empieza nodo:737 / Elemento padre: 714   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(737)).setAttribute("width","100%" );
      ((Element)v.get(714)).appendChild((Element)v.get(737));

      /* Empieza nodo:738 / Elemento padre: 737   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(738)).setAttribute("src","b.gif" );
      ((Element)v.get(737)).appendChild((Element)v.get(738));
      /* Termina nodo:738   */
      /* Termina nodo:737   */
      /* Termina nodo:714   */
      /* Termina nodo:713   */
      /* Termina nodo:712   */
      /* Termina nodo:709   */

      /* Empieza nodo:739 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(739)).setAttribute("nombre","formGapTr26" );
      ((Element)v.get(52)).appendChild((Element)v.get(739));

      /* Empieza nodo:740 / Elemento padre: 739   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(740)).setAttribute("align","center" );
      ((Element)v.get(740)).setAttribute("width","8" );
      ((Element)v.get(739)).appendChild((Element)v.get(740));

      /* Empieza nodo:741 / Elemento padre: 740   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(741)).setAttribute("src","b.gif" );
      ((Element)v.get(741)).setAttribute("width","12" );
      ((Element)v.get(741)).setAttribute("height","8" );
      ((Element)v.get(740)).appendChild((Element)v.get(741));
      /* Termina nodo:741   */
      /* Termina nodo:740   */

      /* Empieza nodo:742 / Elemento padre: 739   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(739)).appendChild((Element)v.get(742));

      /* Empieza nodo:743 / Elemento padre: 742   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(743)).setAttribute("src","b.gif" );
      ((Element)v.get(743)).setAttribute("width","8" );
      ((Element)v.get(743)).setAttribute("height","8" );
      ((Element)v.get(742)).appendChild((Element)v.get(743));
      /* Termina nodo:743   */
      /* Termina nodo:742   */

      /* Empieza nodo:744 / Elemento padre: 739   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(744)).setAttribute("align","center" );
      ((Element)v.get(744)).setAttribute("width","8" );
      ((Element)v.get(739)).appendChild((Element)v.get(744));

      /* Empieza nodo:745 / Elemento padre: 744   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(745)).setAttribute("src","b.gif" );
      ((Element)v.get(745)).setAttribute("width","12" );
      ((Element)v.get(745)).setAttribute("height","8" );
      ((Element)v.get(744)).appendChild((Element)v.get(745));
      /* Termina nodo:745   */
      /* Termina nodo:744   */
      /* Termina nodo:739   */

      /* Empieza nodo:746 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(746)).setAttribute("nombre","formTr27" );
      ((Element)v.get(52)).appendChild((Element)v.get(746));

      /* Empieza nodo:747 / Elemento padre: 746   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(747)).setAttribute("align","center" );
      ((Element)v.get(747)).setAttribute("width","8" );
      ((Element)v.get(746)).appendChild((Element)v.get(747));

      /* Empieza nodo:748 / Elemento padre: 747   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(748)).setAttribute("src","b.gif" );
      ((Element)v.get(748)).setAttribute("width","8" );
      ((Element)v.get(748)).setAttribute("height","12" );
      ((Element)v.get(747)).appendChild((Element)v.get(748));
      /* Termina nodo:748   */
      /* Termina nodo:747   */

      /* Empieza nodo:749 / Elemento padre: 746   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(749)).setAttribute("width","100%" );
      ((Element)v.get(746)).appendChild((Element)v.get(749));

      /* Empieza nodo:750 / Elemento padre: 749   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(750)).setAttribute("width","100%" );
      ((Element)v.get(750)).setAttribute("border","0" );
      ((Element)v.get(750)).setAttribute("cellspacing","0" );
      ((Element)v.get(750)).setAttribute("cellpadding","0" );
      ((Element)v.get(750)).setAttribute("align","left" );
      ((Element)v.get(749)).appendChild((Element)v.get(750));

      /* Empieza nodo:751 / Elemento padre: 750   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(751)).setAttribute("align","left" );
      ((Element)v.get(750)).appendChild((Element)v.get(751));

      /* Empieza nodo:752 / Elemento padre: 751   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(752)).setAttribute("nombre","unmdOidUnidMediPeso_magnOidMagnTdId" );
      ((Element)v.get(751)).appendChild((Element)v.get(752));

      /* Empieza nodo:753 / Elemento padre: 752   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(753)).setAttribute("border","0" );
      ((Element)v.get(753)).setAttribute("cellspacing","0" );
      ((Element)v.get(753)).setAttribute("cellpadding","0" );
      ((Element)v.get(753)).setAttribute("align","left" );
      ((Element)v.get(752)).appendChild((Element)v.get(753));

      /* Empieza nodo:754 / Elemento padre: 753   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(753)).appendChild((Element)v.get(754));

      /* Empieza nodo:755 / Elemento padre: 754   */
      v.add(doc.createElement("TD"));
   }

   private void getXML3420(Document doc) {
      ((Element)v.get(755)).setAttribute("valign","top" );
      ((Element)v.get(755)).setAttribute("height","13" );
      ((Element)v.get(754)).appendChild((Element)v.get(755));

      /* Empieza nodo:756 / Elemento padre: 755   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(756)).setAttribute("nombre","lblunmdOidUnidMediPeso_magnOidMagn" );
      ((Element)v.get(756)).setAttribute("id","datosTitle" );
      ((Element)v.get(756)).setAttribute("ancho","150" );
      ((Element)v.get(756)).setAttribute("alto","13" );
      ((Element)v.get(756)).setAttribute("cod","MaeUnidaMedid.magnOidMagn.label" );
      ((Element)v.get(755)).appendChild((Element)v.get(756));
      /* Termina nodo:756   */
      /* Termina nodo:755   */
      /* Termina nodo:754   */

      /* Empieza nodo:757 / Elemento padre: 753   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(757)).setAttribute("nombre","unmdOidUnidMediPeso_magnOidMagnWidgetTrId" );
      ((Element)v.get(753)).appendChild((Element)v.get(757));

      /* Empieza nodo:758 / Elemento padre: 757   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(758)).setAttribute("align","left" );
      ((Element)v.get(758)).setAttribute("nowrap","true" );
      ((Element)v.get(757)).appendChild((Element)v.get(758));

      /* Empieza nodo:759 / Elemento padre: 758   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(759)).setAttribute("nombre","unmdOidUnidMediPeso_magnOidMagn" );
      ((Element)v.get(759)).setAttribute("id","datosCampos" );
      ((Element)v.get(759)).setAttribute("multiple","N" );
      ((Element)v.get(759)).setAttribute("req","N" );
      ((Element)v.get(759)).setAttribute("size","1" );
      ((Element)v.get(759)).setAttribute("disabled","" );
      ((Element)v.get(759)).setAttribute("validacion","" );
      ((Element)v.get(759)).setAttribute("onchange","mmgDependeneChange('unmdOidUnidMediPeso_magnOidMagn', 'unmdOidUnidMediPeso' , 'maeProdu')" );
      ((Element)v.get(759)).setAttribute("onfocus","" );
      ((Element)v.get(759)).setAttribute("valorinicial","" );
      ((Element)v.get(759)).setAttribute("textoinicial","" );
      ((Element)v.get(759)).setAttribute("ontab","focaliza('maeProduFrm.unmdOidUnidMediPeso');" );
      ((Element)v.get(759)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm',0, false);" );
      ((Element)v.get(758)).appendChild((Element)v.get(759));

      /* Empieza nodo:760 / Elemento padre: 759   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(759)).appendChild((Element)v.get(760));
      /* Termina nodo:760   */
      /* Termina nodo:759   */
      /* Termina nodo:758   */
      /* Termina nodo:757   */
      /* Termina nodo:753   */
      /* Termina nodo:752   */

      /* Empieza nodo:761 / Elemento padre: 751   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(761)).setAttribute("nombre","unmdOidUnidMediPeso_magnOidMagnGapTdId" );
      ((Element)v.get(761)).setAttribute("nowrap","true" );
      ((Element)v.get(761)).setAttribute("class","datosCampos" );
      ((Element)v.get(751)).appendChild((Element)v.get(761));

      /* Empieza nodo:762 / Elemento padre: 761   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(762)).setAttribute("src","b.gif" );
      ((Element)v.get(762)).setAttribute("width","25" );
      ((Element)v.get(762)).setAttribute("height","8" );
      ((Element)v.get(761)).appendChild((Element)v.get(762));
      /* Termina nodo:762   */
      /* Termina nodo:761   */

      /* Empieza nodo:763 / Elemento padre: 751   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(763)).setAttribute("nombre","unmdOidUnidMediPesoTdId" );
      ((Element)v.get(751)).appendChild((Element)v.get(763));

      /* Empieza nodo:764 / Elemento padre: 763   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(764)).setAttribute("border","0" );
      ((Element)v.get(764)).setAttribute("cellspacing","0" );
      ((Element)v.get(764)).setAttribute("cellpadding","0" );
      ((Element)v.get(764)).setAttribute("align","left" );
      ((Element)v.get(763)).appendChild((Element)v.get(764));

      /* Empieza nodo:765 / Elemento padre: 764   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(764)).appendChild((Element)v.get(765));

      /* Empieza nodo:766 / Elemento padre: 765   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(766)).setAttribute("valign","top" );
      ((Element)v.get(766)).setAttribute("height","13" );
      ((Element)v.get(765)).appendChild((Element)v.get(766));

      /* Empieza nodo:767 / Elemento padre: 766   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(767)).setAttribute("nombre","lblunmdOidUnidMediPeso" );
      ((Element)v.get(767)).setAttribute("id","datosTitle" );
      ((Element)v.get(767)).setAttribute("ancho","150" );
      ((Element)v.get(767)).setAttribute("alto","13" );
      ((Element)v.get(767)).setAttribute("cod","MaeProdu.unmdOidUnidMediPeso.label" );
      ((Element)v.get(766)).appendChild((Element)v.get(767));
      /* Termina nodo:767   */
      /* Termina nodo:766   */
      /* Termina nodo:765   */

      /* Empieza nodo:768 / Elemento padre: 764   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(768)).setAttribute("nombre","unmdOidUnidMediPesoWidgetTrId" );
      ((Element)v.get(764)).appendChild((Element)v.get(768));

      /* Empieza nodo:769 / Elemento padre: 768   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(769)).setAttribute("align","left" );
      ((Element)v.get(769)).setAttribute("nowrap","true" );
      ((Element)v.get(768)).appendChild((Element)v.get(769));

      /* Empieza nodo:770 / Elemento padre: 769   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(770)).setAttribute("nombre","unmdOidUnidMediPeso" );
      ((Element)v.get(770)).setAttribute("id","datosCampos" );
      ((Element)v.get(770)).setAttribute("multiple","N" );
      ((Element)v.get(770)).setAttribute("req","N" );
      ((Element)v.get(770)).setAttribute("size","1" );
      ((Element)v.get(770)).setAttribute("disabled","" );
      ((Element)v.get(770)).setAttribute("validacion","" );
      ((Element)v.get(770)).setAttribute("onchange","" );
      ((Element)v.get(770)).setAttribute("onfocus","" );
      ((Element)v.get(770)).setAttribute("valorinicial","" );
      ((Element)v.get(770)).setAttribute("textoinicial","" );
      ((Element)v.get(770)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true);" );
      ((Element)v.get(770)).setAttribute("onshtab","focaliza('maeProduFrm.unmdOidUnidMediPeso_magnOidMagn');" );
      ((Element)v.get(769)).appendChild((Element)v.get(770));

      /* Empieza nodo:771 / Elemento padre: 770   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(770)).appendChild((Element)v.get(771));
      /* Termina nodo:771   */
      /* Termina nodo:770   */
      /* Termina nodo:769   */
      /* Termina nodo:768   */
      /* Termina nodo:764   */
      /* Termina nodo:763   */

      /* Empieza nodo:772 / Elemento padre: 751   */
   }

   private void getXML3510(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(772)).setAttribute("nombre","unmdOidUnidMediPesoGapTdId" );
      ((Element)v.get(772)).setAttribute("nowrap","true" );
      ((Element)v.get(772)).setAttribute("class","datosCampos" );
      ((Element)v.get(751)).appendChild((Element)v.get(772));

      /* Empieza nodo:773 / Elemento padre: 772   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(773)).setAttribute("src","b.gif" );
      ((Element)v.get(773)).setAttribute("width","25" );
      ((Element)v.get(773)).setAttribute("height","8" );
      ((Element)v.get(772)).appendChild((Element)v.get(773));
      /* Termina nodo:773   */
      /* Termina nodo:772   */

      /* Empieza nodo:774 / Elemento padre: 751   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(774)).setAttribute("width","100%" );
      ((Element)v.get(751)).appendChild((Element)v.get(774));

      /* Empieza nodo:775 / Elemento padre: 774   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(775)).setAttribute("src","b.gif" );
      ((Element)v.get(774)).appendChild((Element)v.get(775));
      /* Termina nodo:775   */
      /* Termina nodo:774   */
      /* Termina nodo:751   */
      /* Termina nodo:750   */
      /* Termina nodo:749   */
      /* Termina nodo:746   */

      /* Empieza nodo:776 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(776)).setAttribute("nombre","formGapTr27" );
      ((Element)v.get(52)).appendChild((Element)v.get(776));

      /* Empieza nodo:777 / Elemento padre: 776   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(777)).setAttribute("align","center" );
      ((Element)v.get(777)).setAttribute("width","8" );
      ((Element)v.get(776)).appendChild((Element)v.get(777));

      /* Empieza nodo:778 / Elemento padre: 777   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(778)).setAttribute("src","b.gif" );
      ((Element)v.get(778)).setAttribute("width","12" );
      ((Element)v.get(778)).setAttribute("height","8" );
      ((Element)v.get(777)).appendChild((Element)v.get(778));
      /* Termina nodo:778   */
      /* Termina nodo:777   */

      /* Empieza nodo:779 / Elemento padre: 776   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(776)).appendChild((Element)v.get(779));

      /* Empieza nodo:780 / Elemento padre: 779   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(780)).setAttribute("src","b.gif" );
      ((Element)v.get(780)).setAttribute("width","8" );
      ((Element)v.get(780)).setAttribute("height","8" );
      ((Element)v.get(779)).appendChild((Element)v.get(780));
      /* Termina nodo:780   */
      /* Termina nodo:779   */

      /* Empieza nodo:781 / Elemento padre: 776   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(781)).setAttribute("align","center" );
      ((Element)v.get(781)).setAttribute("width","8" );
      ((Element)v.get(776)).appendChild((Element)v.get(781));

      /* Empieza nodo:782 / Elemento padre: 781   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(782)).setAttribute("src","b.gif" );
      ((Element)v.get(782)).setAttribute("width","12" );
      ((Element)v.get(782)).setAttribute("height","8" );
      ((Element)v.get(781)).appendChild((Element)v.get(782));
      /* Termina nodo:782   */
      /* Termina nodo:781   */
      /* Termina nodo:776   */

      /* Empieza nodo:783 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(783)).setAttribute("nombre","formTr28" );
      ((Element)v.get(52)).appendChild((Element)v.get(783));

      /* Empieza nodo:784 / Elemento padre: 783   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(784)).setAttribute("align","center" );
      ((Element)v.get(784)).setAttribute("width","8" );
      ((Element)v.get(783)).appendChild((Element)v.get(784));

      /* Empieza nodo:785 / Elemento padre: 784   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(785)).setAttribute("src","b.gif" );
      ((Element)v.get(785)).setAttribute("width","8" );
      ((Element)v.get(785)).setAttribute("height","12" );
      ((Element)v.get(784)).appendChild((Element)v.get(785));
      /* Termina nodo:785   */
      /* Termina nodo:784   */

      /* Empieza nodo:786 / Elemento padre: 783   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(786)).setAttribute("width","100%" );
      ((Element)v.get(783)).appendChild((Element)v.get(786));

      /* Empieza nodo:787 / Elemento padre: 786   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(787)).setAttribute("width","100%" );
      ((Element)v.get(787)).setAttribute("border","0" );
      ((Element)v.get(787)).setAttribute("cellspacing","0" );
      ((Element)v.get(787)).setAttribute("cellpadding","0" );
      ((Element)v.get(787)).setAttribute("align","left" );
      ((Element)v.get(786)).appendChild((Element)v.get(787));

      /* Empieza nodo:788 / Elemento padre: 787   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(788)).setAttribute("align","left" );
      ((Element)v.get(787)).appendChild((Element)v.get(788));

      /* Empieza nodo:789 / Elemento padre: 788   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(789)).setAttribute("nombre","unmdOidUnidMediDime_magnOidMagnTdId" );
      ((Element)v.get(788)).appendChild((Element)v.get(789));

      /* Empieza nodo:790 / Elemento padre: 789   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(790)).setAttribute("border","0" );
      ((Element)v.get(790)).setAttribute("cellspacing","0" );
      ((Element)v.get(790)).setAttribute("cellpadding","0" );
      ((Element)v.get(790)).setAttribute("align","left" );
      ((Element)v.get(789)).appendChild((Element)v.get(790));

      /* Empieza nodo:791 / Elemento padre: 790   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(790)).appendChild((Element)v.get(791));

      /* Empieza nodo:792 / Elemento padre: 791   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(792)).setAttribute("valign","top" );
      ((Element)v.get(792)).setAttribute("height","13" );
      ((Element)v.get(791)).appendChild((Element)v.get(792));

      /* Empieza nodo:793 / Elemento padre: 792   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(793)).setAttribute("nombre","lblunmdOidUnidMediDime_magnOidMagn" );
      ((Element)v.get(793)).setAttribute("id","datosTitle" );
      ((Element)v.get(793)).setAttribute("ancho","150" );
      ((Element)v.get(793)).setAttribute("alto","13" );
      ((Element)v.get(793)).setAttribute("cod","MaeUnidaMedid.magnOidMagn.label" );
   }

   private void getXML3600(Document doc) {
      ((Element)v.get(792)).appendChild((Element)v.get(793));
      /* Termina nodo:793   */
      /* Termina nodo:792   */
      /* Termina nodo:791   */

      /* Empieza nodo:794 / Elemento padre: 790   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(794)).setAttribute("nombre","unmdOidUnidMediDime_magnOidMagnWidgetTrId" );
      ((Element)v.get(790)).appendChild((Element)v.get(794));

      /* Empieza nodo:795 / Elemento padre: 794   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(795)).setAttribute("align","left" );
      ((Element)v.get(795)).setAttribute("nowrap","true" );
      ((Element)v.get(794)).appendChild((Element)v.get(795));

      /* Empieza nodo:796 / Elemento padre: 795   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(796)).setAttribute("nombre","unmdOidUnidMediDime_magnOidMagn" );
      ((Element)v.get(796)).setAttribute("id","datosCampos" );
      ((Element)v.get(796)).setAttribute("multiple","N" );
      ((Element)v.get(796)).setAttribute("req","N" );
      ((Element)v.get(796)).setAttribute("size","1" );
      ((Element)v.get(796)).setAttribute("disabled","" );
      ((Element)v.get(796)).setAttribute("validacion","" );
      ((Element)v.get(796)).setAttribute("onchange","mmgDependeneChange('unmdOidUnidMediDime_magnOidMagn', 'unmdOidUnidMediDime' , 'maeProdu')" );
      ((Element)v.get(796)).setAttribute("onfocus","" );
      ((Element)v.get(796)).setAttribute("valorinicial","" );
      ((Element)v.get(796)).setAttribute("textoinicial","" );
      ((Element)v.get(796)).setAttribute("ontab","focaliza('maeProduFrm.unmdOidUnidMediDime');" );
      ((Element)v.get(796)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm',0, false);" );
      ((Element)v.get(795)).appendChild((Element)v.get(796));

      /* Empieza nodo:797 / Elemento padre: 796   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(796)).appendChild((Element)v.get(797));
      /* Termina nodo:797   */
      /* Termina nodo:796   */
      /* Termina nodo:795   */
      /* Termina nodo:794   */
      /* Termina nodo:790   */
      /* Termina nodo:789   */

      /* Empieza nodo:798 / Elemento padre: 788   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(798)).setAttribute("nombre","unmdOidUnidMediDime_magnOidMagnGapTdId" );
      ((Element)v.get(798)).setAttribute("nowrap","true" );
      ((Element)v.get(798)).setAttribute("class","datosCampos" );
      ((Element)v.get(788)).appendChild((Element)v.get(798));

      /* Empieza nodo:799 / Elemento padre: 798   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(799)).setAttribute("src","b.gif" );
      ((Element)v.get(799)).setAttribute("width","25" );
      ((Element)v.get(799)).setAttribute("height","8" );
      ((Element)v.get(798)).appendChild((Element)v.get(799));
      /* Termina nodo:799   */
      /* Termina nodo:798   */

      /* Empieza nodo:800 / Elemento padre: 788   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(800)).setAttribute("nombre","unmdOidUnidMediDimeTdId" );
      ((Element)v.get(788)).appendChild((Element)v.get(800));

      /* Empieza nodo:801 / Elemento padre: 800   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(801)).setAttribute("border","0" );
      ((Element)v.get(801)).setAttribute("cellspacing","0" );
      ((Element)v.get(801)).setAttribute("cellpadding","0" );
      ((Element)v.get(801)).setAttribute("align","left" );
      ((Element)v.get(800)).appendChild((Element)v.get(801));

      /* Empieza nodo:802 / Elemento padre: 801   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(801)).appendChild((Element)v.get(802));

      /* Empieza nodo:803 / Elemento padre: 802   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(803)).setAttribute("valign","top" );
      ((Element)v.get(803)).setAttribute("height","13" );
      ((Element)v.get(802)).appendChild((Element)v.get(803));

      /* Empieza nodo:804 / Elemento padre: 803   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(804)).setAttribute("nombre","lblunmdOidUnidMediDime" );
      ((Element)v.get(804)).setAttribute("id","datosTitle" );
      ((Element)v.get(804)).setAttribute("ancho","150" );
      ((Element)v.get(804)).setAttribute("alto","13" );
      ((Element)v.get(804)).setAttribute("cod","MaeProdu.unmdOidUnidMediDime.label" );
      ((Element)v.get(803)).appendChild((Element)v.get(804));
      /* Termina nodo:804   */
      /* Termina nodo:803   */
      /* Termina nodo:802   */

      /* Empieza nodo:805 / Elemento padre: 801   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(805)).setAttribute("nombre","unmdOidUnidMediDimeWidgetTrId" );
      ((Element)v.get(801)).appendChild((Element)v.get(805));

      /* Empieza nodo:806 / Elemento padre: 805   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(806)).setAttribute("align","left" );
      ((Element)v.get(806)).setAttribute("nowrap","true" );
      ((Element)v.get(805)).appendChild((Element)v.get(806));

      /* Empieza nodo:807 / Elemento padre: 806   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(807)).setAttribute("nombre","unmdOidUnidMediDime" );
      ((Element)v.get(807)).setAttribute("id","datosCampos" );
      ((Element)v.get(807)).setAttribute("multiple","N" );
      ((Element)v.get(807)).setAttribute("req","N" );
      ((Element)v.get(807)).setAttribute("size","1" );
      ((Element)v.get(807)).setAttribute("disabled","" );
      ((Element)v.get(807)).setAttribute("validacion","" );
      ((Element)v.get(807)).setAttribute("onchange","" );
      ((Element)v.get(807)).setAttribute("onfocus","" );
      ((Element)v.get(807)).setAttribute("valorinicial","" );
      ((Element)v.get(807)).setAttribute("textoinicial","" );
      ((Element)v.get(807)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true);" );
      ((Element)v.get(807)).setAttribute("onshtab","focaliza('maeProduFrm.unmdOidUnidMediDime_magnOidMagn');" );
      ((Element)v.get(806)).appendChild((Element)v.get(807));

      /* Empieza nodo:808 / Elemento padre: 807   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(807)).appendChild((Element)v.get(808));
      /* Termina nodo:808   */
      /* Termina nodo:807   */
      /* Termina nodo:806   */
      /* Termina nodo:805   */
      /* Termina nodo:801   */
      /* Termina nodo:800   */

      /* Empieza nodo:809 / Elemento padre: 788   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(809)).setAttribute("nombre","unmdOidUnidMediDimeGapTdId" );
      ((Element)v.get(809)).setAttribute("nowrap","true" );
      ((Element)v.get(809)).setAttribute("class","datosCampos" );
      ((Element)v.get(788)).appendChild((Element)v.get(809));

      /* Empieza nodo:810 / Elemento padre: 809   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(810)).setAttribute("src","b.gif" );
      ((Element)v.get(810)).setAttribute("width","25" );
      ((Element)v.get(810)).setAttribute("height","8" );
   }

   private void getXML3690(Document doc) {
      ((Element)v.get(809)).appendChild((Element)v.get(810));
      /* Termina nodo:810   */
      /* Termina nodo:809   */

      /* Empieza nodo:811 / Elemento padre: 788   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(811)).setAttribute("width","100%" );
      ((Element)v.get(788)).appendChild((Element)v.get(811));

      /* Empieza nodo:812 / Elemento padre: 811   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(812)).setAttribute("src","b.gif" );
      ((Element)v.get(811)).appendChild((Element)v.get(812));
      /* Termina nodo:812   */
      /* Termina nodo:811   */
      /* Termina nodo:788   */
      /* Termina nodo:787   */
      /* Termina nodo:786   */
      /* Termina nodo:783   */

      /* Empieza nodo:813 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(813)).setAttribute("nombre","formGapTr28" );
      ((Element)v.get(52)).appendChild((Element)v.get(813));

      /* Empieza nodo:814 / Elemento padre: 813   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(814)).setAttribute("align","center" );
      ((Element)v.get(814)).setAttribute("width","8" );
      ((Element)v.get(813)).appendChild((Element)v.get(814));

      /* Empieza nodo:815 / Elemento padre: 814   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(815)).setAttribute("src","b.gif" );
      ((Element)v.get(815)).setAttribute("width","12" );
      ((Element)v.get(815)).setAttribute("height","8" );
      ((Element)v.get(814)).appendChild((Element)v.get(815));
      /* Termina nodo:815   */
      /* Termina nodo:814   */

      /* Empieza nodo:816 / Elemento padre: 813   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(813)).appendChild((Element)v.get(816));

      /* Empieza nodo:817 / Elemento padre: 816   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(817)).setAttribute("src","b.gif" );
      ((Element)v.get(817)).setAttribute("width","8" );
      ((Element)v.get(817)).setAttribute("height","8" );
      ((Element)v.get(816)).appendChild((Element)v.get(817));
      /* Termina nodo:817   */
      /* Termina nodo:816   */

      /* Empieza nodo:818 / Elemento padre: 813   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(818)).setAttribute("align","center" );
      ((Element)v.get(818)).setAttribute("width","8" );
      ((Element)v.get(813)).appendChild((Element)v.get(818));

      /* Empieza nodo:819 / Elemento padre: 818   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(819)).setAttribute("src","b.gif" );
      ((Element)v.get(819)).setAttribute("width","12" );
      ((Element)v.get(819)).setAttribute("height","8" );
      ((Element)v.get(818)).appendChild((Element)v.get(819));
      /* Termina nodo:819   */
      /* Termina nodo:818   */
      /* Termina nodo:813   */

      /* Empieza nodo:820 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(820)).setAttribute("nombre","formTr29" );
      ((Element)v.get(52)).appendChild((Element)v.get(820));

      /* Empieza nodo:821 / Elemento padre: 820   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(821)).setAttribute("align","center" );
      ((Element)v.get(821)).setAttribute("width","8" );
      ((Element)v.get(820)).appendChild((Element)v.get(821));

      /* Empieza nodo:822 / Elemento padre: 821   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(822)).setAttribute("src","b.gif" );
      ((Element)v.get(822)).setAttribute("width","8" );
      ((Element)v.get(822)).setAttribute("height","12" );
      ((Element)v.get(821)).appendChild((Element)v.get(822));
      /* Termina nodo:822   */
      /* Termina nodo:821   */

      /* Empieza nodo:823 / Elemento padre: 820   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(823)).setAttribute("width","100%" );
      ((Element)v.get(820)).appendChild((Element)v.get(823));

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
      ((Element)v.get(825)).setAttribute("align","left" );
      ((Element)v.get(824)).appendChild((Element)v.get(825));

      /* Empieza nodo:826 / Elemento padre: 825   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(826)).setAttribute("nombre","negoOidNegoTdId" );
      ((Element)v.get(825)).appendChild((Element)v.get(826));

      /* Empieza nodo:827 / Elemento padre: 826   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(827)).setAttribute("border","0" );
      ((Element)v.get(827)).setAttribute("cellspacing","0" );
      ((Element)v.get(827)).setAttribute("cellpadding","0" );
      ((Element)v.get(827)).setAttribute("align","left" );
      ((Element)v.get(826)).appendChild((Element)v.get(827));

      /* Empieza nodo:828 / Elemento padre: 827   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(827)).appendChild((Element)v.get(828));

      /* Empieza nodo:829 / Elemento padre: 828   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(829)).setAttribute("valign","top" );
      ((Element)v.get(829)).setAttribute("height","13" );
      ((Element)v.get(828)).appendChild((Element)v.get(829));

      /* Empieza nodo:830 / Elemento padre: 829   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(830)).setAttribute("nombre","lblnegoOidNego" );
      ((Element)v.get(830)).setAttribute("id","datosTitle" );
      ((Element)v.get(830)).setAttribute("ancho","150" );
      ((Element)v.get(830)).setAttribute("alto","13" );
      ((Element)v.get(830)).setAttribute("cod","MaeProdu.negoOidNego.label" );
      ((Element)v.get(829)).appendChild((Element)v.get(830));
      /* Termina nodo:830   */
      /* Termina nodo:829   */
      /* Termina nodo:828   */

      /* Empieza nodo:831 / Elemento padre: 827   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(831)).setAttribute("nombre","negoOidNegoWidgetTrId" );
      ((Element)v.get(827)).appendChild((Element)v.get(831));

      /* Empieza nodo:832 / Elemento padre: 831   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(832)).setAttribute("align","left" );
      ((Element)v.get(832)).setAttribute("nowrap","true" );
      ((Element)v.get(831)).appendChild((Element)v.get(832));

      /* Empieza nodo:833 / Elemento padre: 832   */
      v.add(doc.createElement("COMBO"));
   }

   private void getXML3780(Document doc) {
      ((Element)v.get(833)).setAttribute("nombre","negoOidNego" );
      ((Element)v.get(833)).setAttribute("id","datosCampos" );
      ((Element)v.get(833)).setAttribute("multiple","N" );
      ((Element)v.get(833)).setAttribute("req","N" );
      ((Element)v.get(833)).setAttribute("size","1" );
      ((Element)v.get(833)).setAttribute("disabled","" );
      ((Element)v.get(833)).setAttribute("validacion","" );
      ((Element)v.get(833)).setAttribute("onchange","" );
      ((Element)v.get(833)).setAttribute("onfocus","" );
      ((Element)v.get(833)).setAttribute("valorinicial","" );
      ((Element)v.get(833)).setAttribute("textoinicial","" );
      ((Element)v.get(833)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true);" );
      ((Element)v.get(833)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm',0, false);" );
      ((Element)v.get(832)).appendChild((Element)v.get(833));

      /* Empieza nodo:834 / Elemento padre: 833   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(833)).appendChild((Element)v.get(834));
      /* Termina nodo:834   */
      /* Termina nodo:833   */
      /* Termina nodo:832   */
      /* Termina nodo:831   */
      /* Termina nodo:827   */
      /* Termina nodo:826   */

      /* Empieza nodo:835 / Elemento padre: 825   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(835)).setAttribute("nombre","negoOidNegoGapTdId" );
      ((Element)v.get(835)).setAttribute("nowrap","true" );
      ((Element)v.get(835)).setAttribute("class","datosCampos" );
      ((Element)v.get(825)).appendChild((Element)v.get(835));

      /* Empieza nodo:836 / Elemento padre: 835   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(836)).setAttribute("src","b.gif" );
      ((Element)v.get(836)).setAttribute("width","25" );
      ((Element)v.get(836)).setAttribute("height","8" );
      ((Element)v.get(835)).appendChild((Element)v.get(836));
      /* Termina nodo:836   */
      /* Termina nodo:835   */

      /* Empieza nodo:837 / Elemento padre: 825   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(837)).setAttribute("width","100%" );
      ((Element)v.get(825)).appendChild((Element)v.get(837));

      /* Empieza nodo:838 / Elemento padre: 837   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(838)).setAttribute("src","b.gif" );
      ((Element)v.get(837)).appendChild((Element)v.get(838));
      /* Termina nodo:838   */
      /* Termina nodo:837   */
      /* Termina nodo:825   */
      /* Termina nodo:824   */
      /* Termina nodo:823   */
      /* Termina nodo:820   */

      /* Empieza nodo:839 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(839)).setAttribute("nombre","formGapTr29" );
      ((Element)v.get(52)).appendChild((Element)v.get(839));

      /* Empieza nodo:840 / Elemento padre: 839   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(840)).setAttribute("align","center" );
      ((Element)v.get(840)).setAttribute("width","8" );
      ((Element)v.get(839)).appendChild((Element)v.get(840));

      /* Empieza nodo:841 / Elemento padre: 840   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(841)).setAttribute("src","b.gif" );
      ((Element)v.get(841)).setAttribute("width","12" );
      ((Element)v.get(841)).setAttribute("height","8" );
      ((Element)v.get(840)).appendChild((Element)v.get(841));
      /* Termina nodo:841   */
      /* Termina nodo:840   */

      /* Empieza nodo:842 / Elemento padre: 839   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(839)).appendChild((Element)v.get(842));

      /* Empieza nodo:843 / Elemento padre: 842   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(843)).setAttribute("src","b.gif" );
      ((Element)v.get(843)).setAttribute("width","8" );
      ((Element)v.get(843)).setAttribute("height","8" );
      ((Element)v.get(842)).appendChild((Element)v.get(843));
      /* Termina nodo:843   */
      /* Termina nodo:842   */

      /* Empieza nodo:844 / Elemento padre: 839   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(844)).setAttribute("align","center" );
      ((Element)v.get(844)).setAttribute("width","8" );
      ((Element)v.get(839)).appendChild((Element)v.get(844));

      /* Empieza nodo:845 / Elemento padre: 844   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(845)).setAttribute("src","b.gif" );
      ((Element)v.get(845)).setAttribute("width","12" );
      ((Element)v.get(845)).setAttribute("height","8" );
      ((Element)v.get(844)).appendChild((Element)v.get(845));
      /* Termina nodo:845   */
      /* Termina nodo:844   */
      /* Termina nodo:839   */

      /* Empieza nodo:846 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(846)).setAttribute("nombre","formTr30" );
      ((Element)v.get(52)).appendChild((Element)v.get(846));

      /* Empieza nodo:847 / Elemento padre: 846   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(847)).setAttribute("align","center" );
      ((Element)v.get(847)).setAttribute("width","8" );
      ((Element)v.get(846)).appendChild((Element)v.get(847));

      /* Empieza nodo:848 / Elemento padre: 847   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(848)).setAttribute("src","b.gif" );
      ((Element)v.get(848)).setAttribute("width","8" );
      ((Element)v.get(848)).setAttribute("height","12" );
      ((Element)v.get(847)).appendChild((Element)v.get(848));
      /* Termina nodo:848   */
      /* Termina nodo:847   */

      /* Empieza nodo:849 / Elemento padre: 846   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(849)).setAttribute("width","100%" );
      ((Element)v.get(846)).appendChild((Element)v.get(849));

      /* Empieza nodo:850 / Elemento padre: 849   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(850)).setAttribute("width","100%" );
      ((Element)v.get(850)).setAttribute("border","0" );
      ((Element)v.get(850)).setAttribute("cellspacing","0" );
      ((Element)v.get(850)).setAttribute("cellpadding","0" );
      ((Element)v.get(850)).setAttribute("align","left" );
      ((Element)v.get(849)).appendChild((Element)v.get(850));

      /* Empieza nodo:851 / Elemento padre: 850   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(851)).setAttribute("align","left" );
      ((Element)v.get(850)).appendChild((Element)v.get(851));

      /* Empieza nodo:852 / Elemento padre: 851   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(852)).setAttribute("nombre","meudOidEstaProdTdId" );
      ((Element)v.get(851)).appendChild((Element)v.get(852));

      /* Empieza nodo:853 / Elemento padre: 852   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(853)).setAttribute("border","0" );
   }

   private void getXML3870(Document doc) {
      ((Element)v.get(853)).setAttribute("cellspacing","0" );
      ((Element)v.get(853)).setAttribute("cellpadding","0" );
      ((Element)v.get(853)).setAttribute("align","left" );
      ((Element)v.get(852)).appendChild((Element)v.get(853));

      /* Empieza nodo:854 / Elemento padre: 853   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(853)).appendChild((Element)v.get(854));

      /* Empieza nodo:855 / Elemento padre: 854   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(855)).setAttribute("valign","top" );
      ((Element)v.get(855)).setAttribute("height","13" );
      ((Element)v.get(854)).appendChild((Element)v.get(855));

      /* Empieza nodo:856 / Elemento padre: 855   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(856)).setAttribute("nombre","lblmeudOidEstaProd" );
      ((Element)v.get(856)).setAttribute("id","datosTitle" );
      ((Element)v.get(856)).setAttribute("ancho","150" );
      ((Element)v.get(856)).setAttribute("alto","13" );
      ((Element)v.get(856)).setAttribute("cod","MaeProdu.meudOidEstaProd.label" );
      ((Element)v.get(855)).appendChild((Element)v.get(856));
      /* Termina nodo:856   */
      /* Termina nodo:855   */
      /* Termina nodo:854   */

      /* Empieza nodo:857 / Elemento padre: 853   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(857)).setAttribute("nombre","meudOidEstaProdWidgetTrId" );
      ((Element)v.get(853)).appendChild((Element)v.get(857));

      /* Empieza nodo:858 / Elemento padre: 857   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(858)).setAttribute("align","left" );
      ((Element)v.get(858)).setAttribute("nowrap","true" );
      ((Element)v.get(857)).appendChild((Element)v.get(858));

      /* Empieza nodo:859 / Elemento padre: 858   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(859)).setAttribute("nombre","meudOidEstaProd" );
      ((Element)v.get(859)).setAttribute("id","datosCampos" );
      ((Element)v.get(859)).setAttribute("multiple","N" );
      ((Element)v.get(859)).setAttribute("req","N" );
      ((Element)v.get(859)).setAttribute("size","1" );
      ((Element)v.get(859)).setAttribute("disabled","" );
      ((Element)v.get(859)).setAttribute("validacion","" );
      ((Element)v.get(859)).setAttribute("onchange","" );
      ((Element)v.get(859)).setAttribute("onfocus","" );
      ((Element)v.get(859)).setAttribute("valorinicial","" );
      ((Element)v.get(859)).setAttribute("textoinicial","" );
      ((Element)v.get(859)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true);" );
      ((Element)v.get(859)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm',0, false);" );
      ((Element)v.get(858)).appendChild((Element)v.get(859));

      /* Empieza nodo:860 / Elemento padre: 859   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(859)).appendChild((Element)v.get(860));
      /* Termina nodo:860   */
      /* Termina nodo:859   */
      /* Termina nodo:858   */
      /* Termina nodo:857   */
      /* Termina nodo:853   */
      /* Termina nodo:852   */

      /* Empieza nodo:861 / Elemento padre: 851   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(861)).setAttribute("nombre","meudOidEstaProdGapTdId" );
      ((Element)v.get(861)).setAttribute("nowrap","true" );
      ((Element)v.get(861)).setAttribute("class","datosCampos" );
      ((Element)v.get(851)).appendChild((Element)v.get(861));

      /* Empieza nodo:862 / Elemento padre: 861   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(862)).setAttribute("src","b.gif" );
      ((Element)v.get(862)).setAttribute("width","25" );
      ((Element)v.get(862)).setAttribute("height","8" );
      ((Element)v.get(861)).appendChild((Element)v.get(862));
      /* Termina nodo:862   */
      /* Termina nodo:861   */

      /* Empieza nodo:863 / Elemento padre: 851   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(863)).setAttribute("width","100%" );
      ((Element)v.get(851)).appendChild((Element)v.get(863));

      /* Empieza nodo:864 / Elemento padre: 863   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(864)).setAttribute("src","b.gif" );
      ((Element)v.get(863)).appendChild((Element)v.get(864));
      /* Termina nodo:864   */
      /* Termina nodo:863   */
      /* Termina nodo:851   */
      /* Termina nodo:850   */
      /* Termina nodo:849   */
      /* Termina nodo:846   */

      /* Empieza nodo:865 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(865)).setAttribute("nombre","formGapTr30" );
      ((Element)v.get(52)).appendChild((Element)v.get(865));

      /* Empieza nodo:866 / Elemento padre: 865   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(866)).setAttribute("align","center" );
      ((Element)v.get(866)).setAttribute("width","8" );
      ((Element)v.get(865)).appendChild((Element)v.get(866));

      /* Empieza nodo:867 / Elemento padre: 866   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(867)).setAttribute("src","b.gif" );
      ((Element)v.get(867)).setAttribute("width","12" );
      ((Element)v.get(867)).setAttribute("height","8" );
      ((Element)v.get(866)).appendChild((Element)v.get(867));
      /* Termina nodo:867   */
      /* Termina nodo:866   */

      /* Empieza nodo:868 / Elemento padre: 865   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(865)).appendChild((Element)v.get(868));

      /* Empieza nodo:869 / Elemento padre: 868   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(869)).setAttribute("src","b.gif" );
      ((Element)v.get(869)).setAttribute("width","8" );
      ((Element)v.get(869)).setAttribute("height","8" );
      ((Element)v.get(868)).appendChild((Element)v.get(869));
      /* Termina nodo:869   */
      /* Termina nodo:868   */

      /* Empieza nodo:870 / Elemento padre: 865   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(870)).setAttribute("align","center" );
      ((Element)v.get(870)).setAttribute("width","8" );
      ((Element)v.get(865)).appendChild((Element)v.get(870));

      /* Empieza nodo:871 / Elemento padre: 870   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(871)).setAttribute("src","b.gif" );
      ((Element)v.get(871)).setAttribute("width","12" );
      ((Element)v.get(871)).setAttribute("height","8" );
      ((Element)v.get(870)).appendChild((Element)v.get(871));
      /* Termina nodo:871   */
      /* Termina nodo:870   */
      /* Termina nodo:865   */

      /* Empieza nodo:872 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(872)).setAttribute("nombre","formTr31" );
      ((Element)v.get(52)).appendChild((Element)v.get(872));

      /* Empieza nodo:873 / Elemento padre: 872   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(873)).setAttribute("align","center" );
   }

   private void getXML3960(Document doc) {
      ((Element)v.get(873)).setAttribute("width","8" );
      ((Element)v.get(872)).appendChild((Element)v.get(873));

      /* Empieza nodo:874 / Elemento padre: 873   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(874)).setAttribute("src","b.gif" );
      ((Element)v.get(874)).setAttribute("width","8" );
      ((Element)v.get(874)).setAttribute("height","12" );
      ((Element)v.get(873)).appendChild((Element)v.get(874));
      /* Termina nodo:874   */
      /* Termina nodo:873   */

      /* Empieza nodo:875 / Elemento padre: 872   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(875)).setAttribute("width","100%" );
      ((Element)v.get(872)).appendChild((Element)v.get(875));

      /* Empieza nodo:876 / Elemento padre: 875   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(876)).setAttribute("width","100%" );
      ((Element)v.get(876)).setAttribute("border","0" );
      ((Element)v.get(876)).setAttribute("cellspacing","0" );
      ((Element)v.get(876)).setAttribute("cellpadding","0" );
      ((Element)v.get(876)).setAttribute("align","left" );
      ((Element)v.get(875)).appendChild((Element)v.get(876));

      /* Empieza nodo:877 / Elemento padre: 876   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(877)).setAttribute("align","left" );
      ((Element)v.get(876)).appendChild((Element)v.get(877));

      /* Empieza nodo:878 / Elemento padre: 877   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(878)).setAttribute("nombre","liprOidLineProdTdId" );
      ((Element)v.get(877)).appendChild((Element)v.get(878));

      /* Empieza nodo:879 / Elemento padre: 878   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(879)).setAttribute("border","0" );
      ((Element)v.get(879)).setAttribute("cellspacing","0" );
      ((Element)v.get(879)).setAttribute("cellpadding","0" );
      ((Element)v.get(879)).setAttribute("align","left" );
      ((Element)v.get(878)).appendChild((Element)v.get(879));

      /* Empieza nodo:880 / Elemento padre: 879   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(879)).appendChild((Element)v.get(880));

      /* Empieza nodo:881 / Elemento padre: 880   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(881)).setAttribute("valign","top" );
      ((Element)v.get(881)).setAttribute("height","13" );
      ((Element)v.get(880)).appendChild((Element)v.get(881));

      /* Empieza nodo:882 / Elemento padre: 881   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(882)).setAttribute("nombre","lblliprOidLineProd" );
      ((Element)v.get(882)).setAttribute("id","datosTitle" );
      ((Element)v.get(882)).setAttribute("ancho","150" );
      ((Element)v.get(882)).setAttribute("alto","13" );
      ((Element)v.get(882)).setAttribute("cod","MaeProdu.liprOidLineProd.label" );
      ((Element)v.get(881)).appendChild((Element)v.get(882));
      /* Termina nodo:882   */
      /* Termina nodo:881   */
      /* Termina nodo:880   */

      /* Empieza nodo:883 / Elemento padre: 879   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(883)).setAttribute("nombre","liprOidLineProdWidgetTrId" );
      ((Element)v.get(879)).appendChild((Element)v.get(883));

      /* Empieza nodo:884 / Elemento padre: 883   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(884)).setAttribute("align","left" );
      ((Element)v.get(884)).setAttribute("nowrap","true" );
      ((Element)v.get(883)).appendChild((Element)v.get(884));

      /* Empieza nodo:885 / Elemento padre: 884   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(885)).setAttribute("nombre","liprOidLineProd" );
      ((Element)v.get(885)).setAttribute("id","datosCampos" );
      ((Element)v.get(885)).setAttribute("multiple","N" );
      ((Element)v.get(885)).setAttribute("req","N" );
      ((Element)v.get(885)).setAttribute("size","1" );
      ((Element)v.get(885)).setAttribute("disabled","" );
      ((Element)v.get(885)).setAttribute("validacion","" );
      ((Element)v.get(885)).setAttribute("onchange","" );
      ((Element)v.get(885)).setAttribute("onfocus","" );
      ((Element)v.get(885)).setAttribute("valorinicial","" );
      ((Element)v.get(885)).setAttribute("textoinicial","" );
      ((Element)v.get(885)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true);" );
      ((Element)v.get(885)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm',0, false);" );
      ((Element)v.get(884)).appendChild((Element)v.get(885));

      /* Empieza nodo:886 / Elemento padre: 885   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(885)).appendChild((Element)v.get(886));
      /* Termina nodo:886   */
      /* Termina nodo:885   */
      /* Termina nodo:884   */
      /* Termina nodo:883   */
      /* Termina nodo:879   */
      /* Termina nodo:878   */

      /* Empieza nodo:887 / Elemento padre: 877   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(887)).setAttribute("nombre","liprOidLineProdGapTdId" );
      ((Element)v.get(887)).setAttribute("nowrap","true" );
      ((Element)v.get(887)).setAttribute("class","datosCampos" );
      ((Element)v.get(877)).appendChild((Element)v.get(887));

      /* Empieza nodo:888 / Elemento padre: 887   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(888)).setAttribute("src","b.gif" );
      ((Element)v.get(888)).setAttribute("width","25" );
      ((Element)v.get(888)).setAttribute("height","8" );
      ((Element)v.get(887)).appendChild((Element)v.get(888));
      /* Termina nodo:888   */
      /* Termina nodo:887   */

      /* Empieza nodo:889 / Elemento padre: 877   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(889)).setAttribute("width","100%" );
      ((Element)v.get(877)).appendChild((Element)v.get(889));

      /* Empieza nodo:890 / Elemento padre: 889   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(890)).setAttribute("src","b.gif" );
      ((Element)v.get(889)).appendChild((Element)v.get(890));
      /* Termina nodo:890   */
      /* Termina nodo:889   */
      /* Termina nodo:877   */
      /* Termina nodo:876   */
      /* Termina nodo:875   */
      /* Termina nodo:872   */

      /* Empieza nodo:891 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(891)).setAttribute("nombre","formGapTr31" );
      ((Element)v.get(52)).appendChild((Element)v.get(891));

      /* Empieza nodo:892 / Elemento padre: 891   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(892)).setAttribute("align","center" );
      ((Element)v.get(892)).setAttribute("width","8" );
      ((Element)v.get(891)).appendChild((Element)v.get(892));

      /* Empieza nodo:893 / Elemento padre: 892   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML4050(Document doc) {
      ((Element)v.get(893)).setAttribute("src","b.gif" );
      ((Element)v.get(893)).setAttribute("width","12" );
      ((Element)v.get(893)).setAttribute("height","8" );
      ((Element)v.get(892)).appendChild((Element)v.get(893));
      /* Termina nodo:893   */
      /* Termina nodo:892   */

      /* Empieza nodo:894 / Elemento padre: 891   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(891)).appendChild((Element)v.get(894));

      /* Empieza nodo:895 / Elemento padre: 894   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(895)).setAttribute("src","b.gif" );
      ((Element)v.get(895)).setAttribute("width","8" );
      ((Element)v.get(895)).setAttribute("height","8" );
      ((Element)v.get(894)).appendChild((Element)v.get(895));
      /* Termina nodo:895   */
      /* Termina nodo:894   */

      /* Empieza nodo:896 / Elemento padre: 891   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(896)).setAttribute("align","center" );
      ((Element)v.get(896)).setAttribute("width","8" );
      ((Element)v.get(891)).appendChild((Element)v.get(896));

      /* Empieza nodo:897 / Elemento padre: 896   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(897)).setAttribute("src","b.gif" );
      ((Element)v.get(897)).setAttribute("width","12" );
      ((Element)v.get(897)).setAttribute("height","8" );
      ((Element)v.get(896)).appendChild((Element)v.get(897));
      /* Termina nodo:897   */
      /* Termina nodo:896   */
      /* Termina nodo:891   */

      /* Empieza nodo:898 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(898)).setAttribute("nombre","formTr32" );
      ((Element)v.get(52)).appendChild((Element)v.get(898));

      /* Empieza nodo:899 / Elemento padre: 898   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(899)).setAttribute("align","center" );
      ((Element)v.get(899)).setAttribute("width","8" );
      ((Element)v.get(898)).appendChild((Element)v.get(899));

      /* Empieza nodo:900 / Elemento padre: 899   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(900)).setAttribute("src","b.gif" );
      ((Element)v.get(900)).setAttribute("width","8" );
      ((Element)v.get(900)).setAttribute("height","12" );
      ((Element)v.get(899)).appendChild((Element)v.get(900));
      /* Termina nodo:900   */
      /* Termina nodo:899   */

      /* Empieza nodo:901 / Elemento padre: 898   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(901)).setAttribute("width","100%" );
      ((Element)v.get(898)).appendChild((Element)v.get(901));

      /* Empieza nodo:902 / Elemento padre: 901   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(902)).setAttribute("width","100%" );
      ((Element)v.get(902)).setAttribute("border","0" );
      ((Element)v.get(902)).setAttribute("cellspacing","0" );
      ((Element)v.get(902)).setAttribute("cellpadding","0" );
      ((Element)v.get(902)).setAttribute("align","left" );
      ((Element)v.get(901)).appendChild((Element)v.get(902));

      /* Empieza nodo:903 / Elemento padre: 902   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(903)).setAttribute("align","left" );
      ((Element)v.get(902)).appendChild((Element)v.get(903));

      /* Empieza nodo:904 / Elemento padre: 903   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(904)).setAttribute("nombre","unegOidUnidNegoTdId" );
      ((Element)v.get(903)).appendChild((Element)v.get(904));

      /* Empieza nodo:905 / Elemento padre: 904   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(905)).setAttribute("border","0" );
      ((Element)v.get(905)).setAttribute("cellspacing","0" );
      ((Element)v.get(905)).setAttribute("cellpadding","0" );
      ((Element)v.get(905)).setAttribute("align","left" );
      ((Element)v.get(904)).appendChild((Element)v.get(905));

      /* Empieza nodo:906 / Elemento padre: 905   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(905)).appendChild((Element)v.get(906));

      /* Empieza nodo:907 / Elemento padre: 906   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(907)).setAttribute("valign","top" );
      ((Element)v.get(907)).setAttribute("height","13" );
      ((Element)v.get(906)).appendChild((Element)v.get(907));

      /* Empieza nodo:908 / Elemento padre: 907   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(908)).setAttribute("nombre","lblunegOidUnidNego" );
      ((Element)v.get(908)).setAttribute("id","datosTitle" );
      ((Element)v.get(908)).setAttribute("ancho","150" );
      ((Element)v.get(908)).setAttribute("alto","13" );
      ((Element)v.get(908)).setAttribute("cod","MaeProdu.unegOidUnidNego.label" );
      ((Element)v.get(907)).appendChild((Element)v.get(908));
      /* Termina nodo:908   */
      /* Termina nodo:907   */
      /* Termina nodo:906   */

      /* Empieza nodo:909 / Elemento padre: 905   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(909)).setAttribute("nombre","unegOidUnidNegoWidgetTrId" );
      ((Element)v.get(905)).appendChild((Element)v.get(909));

      /* Empieza nodo:910 / Elemento padre: 909   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(910)).setAttribute("align","left" );
      ((Element)v.get(910)).setAttribute("nowrap","true" );
      ((Element)v.get(909)).appendChild((Element)v.get(910));

      /* Empieza nodo:911 / Elemento padre: 910   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(911)).setAttribute("nombre","unegOidUnidNego" );
      ((Element)v.get(911)).setAttribute("id","datosCampos" );
      ((Element)v.get(911)).setAttribute("multiple","N" );
      ((Element)v.get(911)).setAttribute("req","N" );
      ((Element)v.get(911)).setAttribute("size","1" );
      ((Element)v.get(911)).setAttribute("disabled","" );
      ((Element)v.get(911)).setAttribute("validacion","" );
      ((Element)v.get(911)).setAttribute("onchange","" );
      ((Element)v.get(911)).setAttribute("onfocus","" );
      ((Element)v.get(911)).setAttribute("valorinicial","" );
      ((Element)v.get(911)).setAttribute("textoinicial","" );
      ((Element)v.get(911)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true);" );
      ((Element)v.get(911)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm',0, false);" );
      ((Element)v.get(910)).appendChild((Element)v.get(911));

      /* Empieza nodo:912 / Elemento padre: 911   */
      v.add(doc.createElement("ROWSET"));
   }

   private void getXML4140(Document doc) {
      ((Element)v.get(911)).appendChild((Element)v.get(912));
      /* Termina nodo:912   */
      /* Termina nodo:911   */
      /* Termina nodo:910   */
      /* Termina nodo:909   */
      /* Termina nodo:905   */
      /* Termina nodo:904   */

      /* Empieza nodo:913 / Elemento padre: 903   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(913)).setAttribute("nombre","unegOidUnidNegoGapTdId" );
      ((Element)v.get(913)).setAttribute("nowrap","true" );
      ((Element)v.get(913)).setAttribute("class","datosCampos" );
      ((Element)v.get(903)).appendChild((Element)v.get(913));

      /* Empieza nodo:914 / Elemento padre: 913   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(914)).setAttribute("src","b.gif" );
      ((Element)v.get(914)).setAttribute("width","25" );
      ((Element)v.get(914)).setAttribute("height","8" );
      ((Element)v.get(913)).appendChild((Element)v.get(914));
      /* Termina nodo:914   */
      /* Termina nodo:913   */

      /* Empieza nodo:915 / Elemento padre: 903   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(915)).setAttribute("width","100%" );
      ((Element)v.get(903)).appendChild((Element)v.get(915));

      /* Empieza nodo:916 / Elemento padre: 915   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(916)).setAttribute("src","b.gif" );
      ((Element)v.get(915)).appendChild((Element)v.get(916));
      /* Termina nodo:916   */
      /* Termina nodo:915   */
      /* Termina nodo:903   */
      /* Termina nodo:902   */
      /* Termina nodo:901   */
      /* Termina nodo:898   */

      /* Empieza nodo:917 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(917)).setAttribute("nombre","formGapTr32" );
      ((Element)v.get(52)).appendChild((Element)v.get(917));

      /* Empieza nodo:918 / Elemento padre: 917   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(918)).setAttribute("align","center" );
      ((Element)v.get(918)).setAttribute("width","8" );
      ((Element)v.get(917)).appendChild((Element)v.get(918));

      /* Empieza nodo:919 / Elemento padre: 918   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(919)).setAttribute("src","b.gif" );
      ((Element)v.get(919)).setAttribute("width","12" );
      ((Element)v.get(919)).setAttribute("height","8" );
      ((Element)v.get(918)).appendChild((Element)v.get(919));
      /* Termina nodo:919   */
      /* Termina nodo:918   */

      /* Empieza nodo:920 / Elemento padre: 917   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(917)).appendChild((Element)v.get(920));

      /* Empieza nodo:921 / Elemento padre: 920   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(921)).setAttribute("src","b.gif" );
      ((Element)v.get(921)).setAttribute("width","8" );
      ((Element)v.get(921)).setAttribute("height","8" );
      ((Element)v.get(920)).appendChild((Element)v.get(921));
      /* Termina nodo:921   */
      /* Termina nodo:920   */

      /* Empieza nodo:922 / Elemento padre: 917   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(922)).setAttribute("align","center" );
      ((Element)v.get(922)).setAttribute("width","8" );
      ((Element)v.get(917)).appendChild((Element)v.get(922));

      /* Empieza nodo:923 / Elemento padre: 922   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(923)).setAttribute("src","b.gif" );
      ((Element)v.get(923)).setAttribute("width","12" );
      ((Element)v.get(923)).setAttribute("height","8" );
      ((Element)v.get(922)).appendChild((Element)v.get(923));
      /* Termina nodo:923   */
      /* Termina nodo:922   */
      /* Termina nodo:917   */

      /* Empieza nodo:924 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(924)).setAttribute("nombre","formTr33" );
      ((Element)v.get(52)).appendChild((Element)v.get(924));

      /* Empieza nodo:925 / Elemento padre: 924   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(925)).setAttribute("align","center" );
      ((Element)v.get(925)).setAttribute("width","8" );
      ((Element)v.get(924)).appendChild((Element)v.get(925));

      /* Empieza nodo:926 / Elemento padre: 925   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(926)).setAttribute("src","b.gif" );
      ((Element)v.get(926)).setAttribute("width","8" );
      ((Element)v.get(926)).setAttribute("height","12" );
      ((Element)v.get(925)).appendChild((Element)v.get(926));
      /* Termina nodo:926   */
      /* Termina nodo:925   */

      /* Empieza nodo:927 / Elemento padre: 924   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(927)).setAttribute("width","100%" );
      ((Element)v.get(924)).appendChild((Element)v.get(927));

      /* Empieza nodo:928 / Elemento padre: 927   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(928)).setAttribute("width","100%" );
      ((Element)v.get(928)).setAttribute("border","0" );
      ((Element)v.get(928)).setAttribute("cellspacing","0" );
      ((Element)v.get(928)).setAttribute("cellpadding","0" );
      ((Element)v.get(928)).setAttribute("align","left" );
      ((Element)v.get(927)).appendChild((Element)v.get(928));

      /* Empieza nodo:929 / Elemento padre: 928   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(929)).setAttribute("align","left" );
      ((Element)v.get(928)).appendChild((Element)v.get(929));

      /* Empieza nodo:930 / Elemento padre: 929   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(930)).setAttribute("nombre","perdOidPeriInicTdId" );
      ((Element)v.get(929)).appendChild((Element)v.get(930));

      /* Empieza nodo:931 / Elemento padre: 930   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(931)).setAttribute("border","0" );
      ((Element)v.get(931)).setAttribute("cellspacing","0" );
      ((Element)v.get(931)).setAttribute("cellpadding","0" );
      ((Element)v.get(931)).setAttribute("align","left" );
      ((Element)v.get(930)).appendChild((Element)v.get(931));

      /* Empieza nodo:932 / Elemento padre: 931   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(931)).appendChild((Element)v.get(932));

      /* Empieza nodo:933 / Elemento padre: 932   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(933)).setAttribute("valign","top" );
      ((Element)v.get(933)).setAttribute("height","13" );
      ((Element)v.get(932)).appendChild((Element)v.get(933));

      /* Empieza nodo:934 / Elemento padre: 933   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(934)).setAttribute("nombre","lblperdOidPeriInic" );
      ((Element)v.get(934)).setAttribute("id","datosTitle" );
      ((Element)v.get(934)).setAttribute("ancho","150" );
      ((Element)v.get(934)).setAttribute("alto","13" );
   }

   private void getXML4230(Document doc) {
      ((Element)v.get(934)).setAttribute("cod","MaeProdu.perdOidPeriInic.label" );
      ((Element)v.get(933)).appendChild((Element)v.get(934));
      /* Termina nodo:934   */
      /* Termina nodo:933   */
      /* Termina nodo:932   */

      /* Empieza nodo:935 / Elemento padre: 931   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(935)).setAttribute("nombre","perdOidPeriInicWidgetTrId" );
      ((Element)v.get(931)).appendChild((Element)v.get(935));

      /* Empieza nodo:936 / Elemento padre: 935   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(936)).setAttribute("align","left" );
      ((Element)v.get(936)).setAttribute("nowrap","true" );
      ((Element)v.get(935)).appendChild((Element)v.get(936));

      /* Empieza nodo:937 / Elemento padre: 936   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(937)).setAttribute("nombre","perdOidPeriInic" );
      ((Element)v.get(937)).setAttribute("id","datosCampos" );
      ((Element)v.get(937)).setAttribute("multiple","N" );
      ((Element)v.get(937)).setAttribute("req","N" );
      ((Element)v.get(937)).setAttribute("size","1" );
      ((Element)v.get(937)).setAttribute("disabled","" );
      ((Element)v.get(937)).setAttribute("validacion","" );
      ((Element)v.get(937)).setAttribute("onchange","" );
      ((Element)v.get(937)).setAttribute("onfocus","" );
      ((Element)v.get(937)).setAttribute("valorinicial","" );
      ((Element)v.get(937)).setAttribute("textoinicial","" );
      ((Element)v.get(937)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true);" );
      ((Element)v.get(937)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm',0, false);" );
      ((Element)v.get(936)).appendChild((Element)v.get(937));

      /* Empieza nodo:938 / Elemento padre: 937   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(937)).appendChild((Element)v.get(938));
      /* Termina nodo:938   */
      /* Termina nodo:937   */
      /* Termina nodo:936   */
      /* Termina nodo:935   */
      /* Termina nodo:931   */
      /* Termina nodo:930   */

      /* Empieza nodo:939 / Elemento padre: 929   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(939)).setAttribute("nombre","perdOidPeriInicGapTdId" );
      ((Element)v.get(939)).setAttribute("nowrap","true" );
      ((Element)v.get(939)).setAttribute("class","datosCampos" );
      ((Element)v.get(929)).appendChild((Element)v.get(939));

      /* Empieza nodo:940 / Elemento padre: 939   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(940)).setAttribute("src","b.gif" );
      ((Element)v.get(940)).setAttribute("width","25" );
      ((Element)v.get(940)).setAttribute("height","8" );
      ((Element)v.get(939)).appendChild((Element)v.get(940));
      /* Termina nodo:940   */
      /* Termina nodo:939   */

      /* Empieza nodo:941 / Elemento padre: 929   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(941)).setAttribute("width","100%" );
      ((Element)v.get(929)).appendChild((Element)v.get(941));

      /* Empieza nodo:942 / Elemento padre: 941   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(942)).setAttribute("src","b.gif" );
      ((Element)v.get(941)).appendChild((Element)v.get(942));
      /* Termina nodo:942   */
      /* Termina nodo:941   */
      /* Termina nodo:929   */
      /* Termina nodo:928   */
      /* Termina nodo:927   */
      /* Termina nodo:924   */

      /* Empieza nodo:943 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(943)).setAttribute("nombre","formGapTr33" );
      ((Element)v.get(52)).appendChild((Element)v.get(943));

      /* Empieza nodo:944 / Elemento padre: 943   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(944)).setAttribute("align","center" );
      ((Element)v.get(944)).setAttribute("width","8" );
      ((Element)v.get(943)).appendChild((Element)v.get(944));

      /* Empieza nodo:945 / Elemento padre: 944   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(945)).setAttribute("src","b.gif" );
      ((Element)v.get(945)).setAttribute("width","12" );
      ((Element)v.get(945)).setAttribute("height","8" );
      ((Element)v.get(944)).appendChild((Element)v.get(945));
      /* Termina nodo:945   */
      /* Termina nodo:944   */

      /* Empieza nodo:946 / Elemento padre: 943   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(943)).appendChild((Element)v.get(946));

      /* Empieza nodo:947 / Elemento padre: 946   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(947)).setAttribute("src","b.gif" );
      ((Element)v.get(947)).setAttribute("width","8" );
      ((Element)v.get(947)).setAttribute("height","8" );
      ((Element)v.get(946)).appendChild((Element)v.get(947));
      /* Termina nodo:947   */
      /* Termina nodo:946   */

      /* Empieza nodo:948 / Elemento padre: 943   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(948)).setAttribute("align","center" );
      ((Element)v.get(948)).setAttribute("width","8" );
      ((Element)v.get(943)).appendChild((Element)v.get(948));

      /* Empieza nodo:949 / Elemento padre: 948   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(949)).setAttribute("src","b.gif" );
      ((Element)v.get(949)).setAttribute("width","12" );
      ((Element)v.get(949)).setAttribute("height","8" );
      ((Element)v.get(948)).appendChild((Element)v.get(949));
      /* Termina nodo:949   */
      /* Termina nodo:948   */
      /* Termina nodo:943   */

      /* Empieza nodo:950 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(950)).setAttribute("nombre","formTr34" );
      ((Element)v.get(52)).appendChild((Element)v.get(950));

      /* Empieza nodo:951 / Elemento padre: 950   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(951)).setAttribute("align","center" );
      ((Element)v.get(951)).setAttribute("width","8" );
      ((Element)v.get(950)).appendChild((Element)v.get(951));

      /* Empieza nodo:952 / Elemento padre: 951   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(952)).setAttribute("src","b.gif" );
      ((Element)v.get(952)).setAttribute("width","8" );
      ((Element)v.get(952)).setAttribute("height","12" );
      ((Element)v.get(951)).appendChild((Element)v.get(952));
      /* Termina nodo:952   */
      /* Termina nodo:951   */

      /* Empieza nodo:953 / Elemento padre: 950   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(953)).setAttribute("width","100%" );
      ((Element)v.get(950)).appendChild((Element)v.get(953));

      /* Empieza nodo:954 / Elemento padre: 953   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(954)).setAttribute("width","100%" );
      ((Element)v.get(954)).setAttribute("border","0" );
      ((Element)v.get(954)).setAttribute("cellspacing","0" );
      ((Element)v.get(954)).setAttribute("cellpadding","0" );
   }

   private void getXML4320(Document doc) {
      ((Element)v.get(954)).setAttribute("align","left" );
      ((Element)v.get(953)).appendChild((Element)v.get(954));

      /* Empieza nodo:955 / Elemento padre: 954   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(955)).setAttribute("align","left" );
      ((Element)v.get(954)).appendChild((Element)v.get(955));

      /* Empieza nodo:956 / Elemento padre: 955   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(956)).setAttribute("nombre","perdOidPeriFinTdId" );
      ((Element)v.get(955)).appendChild((Element)v.get(956));

      /* Empieza nodo:957 / Elemento padre: 956   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(957)).setAttribute("border","0" );
      ((Element)v.get(957)).setAttribute("cellspacing","0" );
      ((Element)v.get(957)).setAttribute("cellpadding","0" );
      ((Element)v.get(957)).setAttribute("align","left" );
      ((Element)v.get(956)).appendChild((Element)v.get(957));

      /* Empieza nodo:958 / Elemento padre: 957   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(957)).appendChild((Element)v.get(958));

      /* Empieza nodo:959 / Elemento padre: 958   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(959)).setAttribute("valign","top" );
      ((Element)v.get(959)).setAttribute("height","13" );
      ((Element)v.get(958)).appendChild((Element)v.get(959));

      /* Empieza nodo:960 / Elemento padre: 959   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(960)).setAttribute("nombre","lblperdOidPeriFin" );
      ((Element)v.get(960)).setAttribute("id","datosTitle" );
      ((Element)v.get(960)).setAttribute("ancho","150" );
      ((Element)v.get(960)).setAttribute("alto","13" );
      ((Element)v.get(960)).setAttribute("cod","MaeProdu.perdOidPeriFin.label" );
      ((Element)v.get(959)).appendChild((Element)v.get(960));
      /* Termina nodo:960   */
      /* Termina nodo:959   */
      /* Termina nodo:958   */

      /* Empieza nodo:961 / Elemento padre: 957   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(961)).setAttribute("nombre","perdOidPeriFinWidgetTrId" );
      ((Element)v.get(957)).appendChild((Element)v.get(961));

      /* Empieza nodo:962 / Elemento padre: 961   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(962)).setAttribute("align","left" );
      ((Element)v.get(962)).setAttribute("nowrap","true" );
      ((Element)v.get(961)).appendChild((Element)v.get(962));

      /* Empieza nodo:963 / Elemento padre: 962   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(963)).setAttribute("nombre","perdOidPeriFin" );
      ((Element)v.get(963)).setAttribute("id","datosCampos" );
      ((Element)v.get(963)).setAttribute("multiple","N" );
      ((Element)v.get(963)).setAttribute("req","N" );
      ((Element)v.get(963)).setAttribute("size","1" );
      ((Element)v.get(963)).setAttribute("disabled","" );
      ((Element)v.get(963)).setAttribute("validacion","" );
      ((Element)v.get(963)).setAttribute("onchange","" );
      ((Element)v.get(963)).setAttribute("onfocus","" );
      ((Element)v.get(963)).setAttribute("valorinicial","" );
      ((Element)v.get(963)).setAttribute("textoinicial","" );
      ((Element)v.get(963)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true);" );
      ((Element)v.get(963)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm',0, false);" );
      ((Element)v.get(962)).appendChild((Element)v.get(963));

      /* Empieza nodo:964 / Elemento padre: 963   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(963)).appendChild((Element)v.get(964));
      /* Termina nodo:964   */
      /* Termina nodo:963   */
      /* Termina nodo:962   */
      /* Termina nodo:961   */
      /* Termina nodo:957   */
      /* Termina nodo:956   */

      /* Empieza nodo:965 / Elemento padre: 955   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(965)).setAttribute("nombre","perdOidPeriFinGapTdId" );
      ((Element)v.get(965)).setAttribute("nowrap","true" );
      ((Element)v.get(965)).setAttribute("class","datosCampos" );
      ((Element)v.get(955)).appendChild((Element)v.get(965));

      /* Empieza nodo:966 / Elemento padre: 965   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(966)).setAttribute("src","b.gif" );
      ((Element)v.get(966)).setAttribute("width","25" );
      ((Element)v.get(966)).setAttribute("height","8" );
      ((Element)v.get(965)).appendChild((Element)v.get(966));
      /* Termina nodo:966   */
      /* Termina nodo:965   */

      /* Empieza nodo:967 / Elemento padre: 955   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(967)).setAttribute("width","100%" );
      ((Element)v.get(955)).appendChild((Element)v.get(967));

      /* Empieza nodo:968 / Elemento padre: 967   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(968)).setAttribute("src","b.gif" );
      ((Element)v.get(967)).appendChild((Element)v.get(968));
      /* Termina nodo:968   */
      /* Termina nodo:967   */
      /* Termina nodo:955   */
      /* Termina nodo:954   */
      /* Termina nodo:953   */
      /* Termina nodo:950   */

      /* Empieza nodo:969 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(969)).setAttribute("nombre","formGapTr34" );
      ((Element)v.get(52)).appendChild((Element)v.get(969));

      /* Empieza nodo:970 / Elemento padre: 969   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(970)).setAttribute("align","center" );
      ((Element)v.get(970)).setAttribute("width","8" );
      ((Element)v.get(969)).appendChild((Element)v.get(970));

      /* Empieza nodo:971 / Elemento padre: 970   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(971)).setAttribute("src","b.gif" );
      ((Element)v.get(971)).setAttribute("width","12" );
      ((Element)v.get(971)).setAttribute("height","8" );
      ((Element)v.get(970)).appendChild((Element)v.get(971));
      /* Termina nodo:971   */
      /* Termina nodo:970   */

      /* Empieza nodo:972 / Elemento padre: 969   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(969)).appendChild((Element)v.get(972));

      /* Empieza nodo:973 / Elemento padre: 972   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(973)).setAttribute("src","b.gif" );
      ((Element)v.get(973)).setAttribute("width","8" );
      ((Element)v.get(973)).setAttribute("height","8" );
      ((Element)v.get(972)).appendChild((Element)v.get(973));
      /* Termina nodo:973   */
      /* Termina nodo:972   */

      /* Empieza nodo:974 / Elemento padre: 969   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(974)).setAttribute("align","center" );
      ((Element)v.get(974)).setAttribute("width","8" );
      ((Element)v.get(969)).appendChild((Element)v.get(974));

      /* Empieza nodo:975 / Elemento padre: 974   */
   }

   private void getXML4410(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(975)).setAttribute("src","b.gif" );
      ((Element)v.get(975)).setAttribute("width","12" );
      ((Element)v.get(975)).setAttribute("height","8" );
      ((Element)v.get(974)).appendChild((Element)v.get(975));
      /* Termina nodo:975   */
      /* Termina nodo:974   */
      /* Termina nodo:969   */

      /* Empieza nodo:976 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(976)).setAttribute("nombre","formTr35" );
      ((Element)v.get(52)).appendChild((Element)v.get(976));

      /* Empieza nodo:977 / Elemento padre: 976   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(977)).setAttribute("align","center" );
      ((Element)v.get(977)).setAttribute("width","8" );
      ((Element)v.get(976)).appendChild((Element)v.get(977));

      /* Empieza nodo:978 / Elemento padre: 977   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(978)).setAttribute("src","b.gif" );
      ((Element)v.get(978)).setAttribute("width","8" );
      ((Element)v.get(978)).setAttribute("height","12" );
      ((Element)v.get(977)).appendChild((Element)v.get(978));
      /* Termina nodo:978   */
      /* Termina nodo:977   */

      /* Empieza nodo:979 / Elemento padre: 976   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(979)).setAttribute("width","100%" );
      ((Element)v.get(976)).appendChild((Element)v.get(979));

      /* Empieza nodo:980 / Elemento padre: 979   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(980)).setAttribute("width","100%" );
      ((Element)v.get(980)).setAttribute("border","0" );
      ((Element)v.get(980)).setAttribute("cellspacing","0" );
      ((Element)v.get(980)).setAttribute("cellpadding","0" );
      ((Element)v.get(980)).setAttribute("align","left" );
      ((Element)v.get(979)).appendChild((Element)v.get(980));

      /* Empieza nodo:981 / Elemento padre: 980   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(981)).setAttribute("align","left" );
      ((Element)v.get(980)).appendChild((Element)v.get(981));

      /* Empieza nodo:982 / Elemento padre: 981   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(982)).setAttribute("nombre","indLoteTdId" );
      ((Element)v.get(981)).appendChild((Element)v.get(982));

      /* Empieza nodo:983 / Elemento padre: 982   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(983)).setAttribute("width","100%" );
      ((Element)v.get(983)).setAttribute("border","0" );
      ((Element)v.get(983)).setAttribute("cellspacing","0" );
      ((Element)v.get(983)).setAttribute("cellpadding","0" );
      ((Element)v.get(983)).setAttribute("align","left" );
      ((Element)v.get(982)).appendChild((Element)v.get(983));

      /* Empieza nodo:984 / Elemento padre: 983   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(983)).appendChild((Element)v.get(984));

      /* Empieza nodo:985 / Elemento padre: 984   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(985)).setAttribute("valign","top" );
      ((Element)v.get(985)).setAttribute("height","13" );
      ((Element)v.get(984)).appendChild((Element)v.get(985));

      /* Empieza nodo:986 / Elemento padre: 985   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(986)).setAttribute("nombre","lblIndLote" );
      ((Element)v.get(986)).setAttribute("alto","13" );
      ((Element)v.get(986)).setAttribute("filas","1" );
      ((Element)v.get(986)).setAttribute("id","datosTitle" );
      ((Element)v.get(986)).setAttribute("cod","MaeProdu.indLote.label" );
      ((Element)v.get(985)).appendChild((Element)v.get(986));
      /* Termina nodo:986   */
      /* Termina nodo:985   */
      /* Termina nodo:984   */

      /* Empieza nodo:987 / Elemento padre: 983   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(987)).setAttribute("nombre","indLoteWidgetTrId" );
      ((Element)v.get(983)).appendChild((Element)v.get(987));

      /* Empieza nodo:988 / Elemento padre: 987   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(988)).setAttribute("align","left" );
      ((Element)v.get(988)).setAttribute("nowrap","true" );
      ((Element)v.get(987)).appendChild((Element)v.get(988));

      /* Empieza nodo:989 / Elemento padre: 988   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(989)).setAttribute("nombre","indLote" );
      ((Element)v.get(989)).setAttribute("id","datosCampos" );
      ((Element)v.get(989)).setAttribute("trim","S" );
      ((Element)v.get(989)).setAttribute("max","1" );
      ((Element)v.get(989)).setAttribute("onchange","" );
      ((Element)v.get(989)).setAttribute("req","N" );
      ((Element)v.get(989)).setAttribute("size","1" );
      ((Element)v.get(989)).setAttribute("valor","" );
      ((Element)v.get(989)).setAttribute("validacion","" );
      ((Element)v.get(989)).setAttribute("disabled","" );
      ((Element)v.get(989)).setAttribute("onblur","" );
      ((Element)v.get(989)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true)" );
      ((Element)v.get(989)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm', 0, false)" );
      ((Element)v.get(988)).appendChild((Element)v.get(989));
      /* Termina nodo:989   */
      /* Termina nodo:988   */
      /* Termina nodo:987   */
      /* Termina nodo:983   */
      /* Termina nodo:982   */

      /* Empieza nodo:990 / Elemento padre: 981   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(990)).setAttribute("nombre","indLoteGapTdId" );
      ((Element)v.get(990)).setAttribute("nowrap","true" );
      ((Element)v.get(990)).setAttribute("class","datosCampos" );
      ((Element)v.get(981)).appendChild((Element)v.get(990));

      /* Empieza nodo:991 / Elemento padre: 990   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(991)).setAttribute("src","b.gif" );
      ((Element)v.get(991)).setAttribute("width","25" );
      ((Element)v.get(991)).setAttribute("height","8" );
      ((Element)v.get(990)).appendChild((Element)v.get(991));
      /* Termina nodo:991   */
      /* Termina nodo:990   */

      /* Empieza nodo:992 / Elemento padre: 981   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(992)).setAttribute("width","100%" );
      ((Element)v.get(981)).appendChild((Element)v.get(992));

      /* Empieza nodo:993 / Elemento padre: 992   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(993)).setAttribute("src","b.gif" );
   }

   private void getXML4500(Document doc) {
      ((Element)v.get(992)).appendChild((Element)v.get(993));
      /* Termina nodo:993   */
      /* Termina nodo:992   */
      /* Termina nodo:981   */
      /* Termina nodo:980   */
      /* Termina nodo:979   */
      /* Termina nodo:976   */

      /* Empieza nodo:994 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(994)).setAttribute("nombre","formGapTr35" );
      ((Element)v.get(52)).appendChild((Element)v.get(994));

      /* Empieza nodo:995 / Elemento padre: 994   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(995)).setAttribute("align","center" );
      ((Element)v.get(995)).setAttribute("width","8" );
      ((Element)v.get(994)).appendChild((Element)v.get(995));

      /* Empieza nodo:996 / Elemento padre: 995   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(996)).setAttribute("src","b.gif" );
      ((Element)v.get(996)).setAttribute("width","12" );
      ((Element)v.get(996)).setAttribute("height","8" );
      ((Element)v.get(995)).appendChild((Element)v.get(996));
      /* Termina nodo:996   */
      /* Termina nodo:995   */

      /* Empieza nodo:997 / Elemento padre: 994   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(994)).appendChild((Element)v.get(997));

      /* Empieza nodo:998 / Elemento padre: 997   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(998)).setAttribute("src","b.gif" );
      ((Element)v.get(998)).setAttribute("width","8" );
      ((Element)v.get(998)).setAttribute("height","8" );
      ((Element)v.get(997)).appendChild((Element)v.get(998));
      /* Termina nodo:998   */
      /* Termina nodo:997   */

      /* Empieza nodo:999 / Elemento padre: 994   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(999)).setAttribute("align","center" );
      ((Element)v.get(999)).setAttribute("width","8" );
      ((Element)v.get(994)).appendChild((Element)v.get(999));

      /* Empieza nodo:1000 / Elemento padre: 999   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1000)).setAttribute("src","b.gif" );
      ((Element)v.get(1000)).setAttribute("width","12" );
      ((Element)v.get(1000)).setAttribute("height","8" );
      ((Element)v.get(999)).appendChild((Element)v.get(1000));
      /* Termina nodo:1000   */
      /* Termina nodo:999   */
      /* Termina nodo:994   */

      /* Empieza nodo:1001 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1001)).setAttribute("nombre","formTr36" );
      ((Element)v.get(52)).appendChild((Element)v.get(1001));

      /* Empieza nodo:1002 / Elemento padre: 1001   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1002)).setAttribute("align","center" );
      ((Element)v.get(1002)).setAttribute("width","8" );
      ((Element)v.get(1001)).appendChild((Element)v.get(1002));

      /* Empieza nodo:1003 / Elemento padre: 1002   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1003)).setAttribute("src","b.gif" );
      ((Element)v.get(1003)).setAttribute("width","8" );
      ((Element)v.get(1003)).setAttribute("height","12" );
      ((Element)v.get(1002)).appendChild((Element)v.get(1003));
      /* Termina nodo:1003   */
      /* Termina nodo:1002   */

      /* Empieza nodo:1004 / Elemento padre: 1001   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1004)).setAttribute("width","100%" );
      ((Element)v.get(1001)).appendChild((Element)v.get(1004));

      /* Empieza nodo:1005 / Elemento padre: 1004   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1005)).setAttribute("width","100%" );
      ((Element)v.get(1005)).setAttribute("border","0" );
      ((Element)v.get(1005)).setAttribute("cellspacing","0" );
      ((Element)v.get(1005)).setAttribute("cellpadding","0" );
      ((Element)v.get(1005)).setAttribute("align","left" );
      ((Element)v.get(1004)).appendChild((Element)v.get(1005));

      /* Empieza nodo:1006 / Elemento padre: 1005   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1006)).setAttribute("align","left" );
      ((Element)v.get(1005)).appendChild((Element)v.get(1006));

      /* Empieza nodo:1007 / Elemento padre: 1006   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1007)).setAttribute("nombre","indProdServTdId" );
      ((Element)v.get(1006)).appendChild((Element)v.get(1007));

      /* Empieza nodo:1008 / Elemento padre: 1007   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1008)).setAttribute("width","100%" );
      ((Element)v.get(1008)).setAttribute("border","0" );
      ((Element)v.get(1008)).setAttribute("cellspacing","0" );
      ((Element)v.get(1008)).setAttribute("cellpadding","0" );
      ((Element)v.get(1008)).setAttribute("align","left" );
      ((Element)v.get(1007)).appendChild((Element)v.get(1008));

      /* Empieza nodo:1009 / Elemento padre: 1008   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1008)).appendChild((Element)v.get(1009));

      /* Empieza nodo:1010 / Elemento padre: 1009   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1010)).setAttribute("valign","top" );
      ((Element)v.get(1010)).setAttribute("height","13" );
      ((Element)v.get(1009)).appendChild((Element)v.get(1010));

      /* Empieza nodo:1011 / Elemento padre: 1010   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1011)).setAttribute("nombre","lblIndProdServ" );
      ((Element)v.get(1011)).setAttribute("alto","13" );
      ((Element)v.get(1011)).setAttribute("filas","1" );
      ((Element)v.get(1011)).setAttribute("id","datosTitle" );
      ((Element)v.get(1011)).setAttribute("cod","MaeProdu.indProdServ.label" );
      ((Element)v.get(1010)).appendChild((Element)v.get(1011));
      /* Termina nodo:1011   */
      /* Termina nodo:1010   */
      /* Termina nodo:1009   */

      /* Empieza nodo:1012 / Elemento padre: 1008   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1012)).setAttribute("nombre","indProdServWidgetTrId" );
      ((Element)v.get(1008)).appendChild((Element)v.get(1012));

      /* Empieza nodo:1013 / Elemento padre: 1012   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1013)).setAttribute("align","left" );
      ((Element)v.get(1013)).setAttribute("nowrap","true" );
      ((Element)v.get(1012)).appendChild((Element)v.get(1013));

      /* Empieza nodo:1014 / Elemento padre: 1013   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(1014)).setAttribute("nombre","indProdServ" );
      ((Element)v.get(1014)).setAttribute("id","datosCampos" );
      ((Element)v.get(1014)).setAttribute("trim","S" );
      ((Element)v.get(1014)).setAttribute("max","1" );
      ((Element)v.get(1014)).setAttribute("onchange","" );
   }

   private void getXML4590(Document doc) {
      ((Element)v.get(1014)).setAttribute("req","N" );
      ((Element)v.get(1014)).setAttribute("size","1" );
      ((Element)v.get(1014)).setAttribute("valor","" );
      ((Element)v.get(1014)).setAttribute("validacion","" );
      ((Element)v.get(1014)).setAttribute("disabled","" );
      ((Element)v.get(1014)).setAttribute("onblur","" );
      ((Element)v.get(1014)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true)" );
      ((Element)v.get(1014)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm', 0, false)" );
      ((Element)v.get(1013)).appendChild((Element)v.get(1014));
      /* Termina nodo:1014   */
      /* Termina nodo:1013   */
      /* Termina nodo:1012   */
      /* Termina nodo:1008   */
      /* Termina nodo:1007   */

      /* Empieza nodo:1015 / Elemento padre: 1006   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1015)).setAttribute("nombre","indProdServGapTdId" );
      ((Element)v.get(1015)).setAttribute("nowrap","true" );
      ((Element)v.get(1015)).setAttribute("class","datosCampos" );
      ((Element)v.get(1006)).appendChild((Element)v.get(1015));

      /* Empieza nodo:1016 / Elemento padre: 1015   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1016)).setAttribute("src","b.gif" );
      ((Element)v.get(1016)).setAttribute("width","25" );
      ((Element)v.get(1016)).setAttribute("height","8" );
      ((Element)v.get(1015)).appendChild((Element)v.get(1016));
      /* Termina nodo:1016   */
      /* Termina nodo:1015   */

      /* Empieza nodo:1017 / Elemento padre: 1006   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1017)).setAttribute("width","100%" );
      ((Element)v.get(1006)).appendChild((Element)v.get(1017));

      /* Empieza nodo:1018 / Elemento padre: 1017   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1018)).setAttribute("src","b.gif" );
      ((Element)v.get(1017)).appendChild((Element)v.get(1018));
      /* Termina nodo:1018   */
      /* Termina nodo:1017   */
      /* Termina nodo:1006   */
      /* Termina nodo:1005   */
      /* Termina nodo:1004   */
      /* Termina nodo:1001   */

      /* Empieza nodo:1019 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1019)).setAttribute("nombre","formGapTr36" );
      ((Element)v.get(52)).appendChild((Element)v.get(1019));

      /* Empieza nodo:1020 / Elemento padre: 1019   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1020)).setAttribute("align","center" );
      ((Element)v.get(1020)).setAttribute("width","8" );
      ((Element)v.get(1019)).appendChild((Element)v.get(1020));

      /* Empieza nodo:1021 / Elemento padre: 1020   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1021)).setAttribute("src","b.gif" );
      ((Element)v.get(1021)).setAttribute("width","12" );
      ((Element)v.get(1021)).setAttribute("height","8" );
      ((Element)v.get(1020)).appendChild((Element)v.get(1021));
      /* Termina nodo:1021   */
      /* Termina nodo:1020   */

      /* Empieza nodo:1022 / Elemento padre: 1019   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1019)).appendChild((Element)v.get(1022));

      /* Empieza nodo:1023 / Elemento padre: 1022   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1023)).setAttribute("src","b.gif" );
      ((Element)v.get(1023)).setAttribute("width","8" );
      ((Element)v.get(1023)).setAttribute("height","8" );
      ((Element)v.get(1022)).appendChild((Element)v.get(1023));
      /* Termina nodo:1023   */
      /* Termina nodo:1022   */

      /* Empieza nodo:1024 / Elemento padre: 1019   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1024)).setAttribute("align","center" );
      ((Element)v.get(1024)).setAttribute("width","8" );
      ((Element)v.get(1019)).appendChild((Element)v.get(1024));

      /* Empieza nodo:1025 / Elemento padre: 1024   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1025)).setAttribute("src","b.gif" );
      ((Element)v.get(1025)).setAttribute("width","12" );
      ((Element)v.get(1025)).setAttribute("height","8" );
      ((Element)v.get(1024)).appendChild((Element)v.get(1025));
      /* Termina nodo:1025   */
      /* Termina nodo:1024   */
      /* Termina nodo:1019   */

      /* Empieza nodo:1026 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1026)).setAttribute("nombre","formTr37" );
      ((Element)v.get(52)).appendChild((Element)v.get(1026));

      /* Empieza nodo:1027 / Elemento padre: 1026   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1027)).setAttribute("align","center" );
      ((Element)v.get(1027)).setAttribute("width","8" );
      ((Element)v.get(1026)).appendChild((Element)v.get(1027));

      /* Empieza nodo:1028 / Elemento padre: 1027   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1028)).setAttribute("src","b.gif" );
      ((Element)v.get(1028)).setAttribute("width","8" );
      ((Element)v.get(1028)).setAttribute("height","12" );
      ((Element)v.get(1027)).appendChild((Element)v.get(1028));
      /* Termina nodo:1028   */
      /* Termina nodo:1027   */

      /* Empieza nodo:1029 / Elemento padre: 1026   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1029)).setAttribute("width","100%" );
      ((Element)v.get(1026)).appendChild((Element)v.get(1029));

      /* Empieza nodo:1030 / Elemento padre: 1029   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1030)).setAttribute("width","100%" );
      ((Element)v.get(1030)).setAttribute("border","0" );
      ((Element)v.get(1030)).setAttribute("cellspacing","0" );
      ((Element)v.get(1030)).setAttribute("cellpadding","0" );
      ((Element)v.get(1030)).setAttribute("align","left" );
      ((Element)v.get(1029)).appendChild((Element)v.get(1030));

      /* Empieza nodo:1031 / Elemento padre: 1030   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1031)).setAttribute("align","left" );
      ((Element)v.get(1030)).appendChild((Element)v.get(1031));

      /* Empieza nodo:1032 / Elemento padre: 1031   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1032)).setAttribute("nombre","codIndSituTdId" );
      ((Element)v.get(1031)).appendChild((Element)v.get(1032));

      /* Empieza nodo:1033 / Elemento padre: 1032   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1033)).setAttribute("width","100%" );
      ((Element)v.get(1033)).setAttribute("border","0" );
      ((Element)v.get(1033)).setAttribute("cellspacing","0" );
      ((Element)v.get(1033)).setAttribute("cellpadding","0" );
      ((Element)v.get(1033)).setAttribute("align","left" );
      ((Element)v.get(1032)).appendChild((Element)v.get(1033));

      /* Empieza nodo:1034 / Elemento padre: 1033   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1033)).appendChild((Element)v.get(1034));

      /* Empieza nodo:1035 / Elemento padre: 1034   */
   }

   private void getXML4680(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(1035)).setAttribute("valign","top" );
      ((Element)v.get(1035)).setAttribute("height","13" );
      ((Element)v.get(1034)).appendChild((Element)v.get(1035));

      /* Empieza nodo:1036 / Elemento padre: 1035   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1036)).setAttribute("nombre","lblCodIndSitu" );
      ((Element)v.get(1036)).setAttribute("alto","13" );
      ((Element)v.get(1036)).setAttribute("filas","1" );
      ((Element)v.get(1036)).setAttribute("id","datosTitle" );
      ((Element)v.get(1036)).setAttribute("cod","MaeProdu.codIndSitu.label" );
      ((Element)v.get(1035)).appendChild((Element)v.get(1036));
      /* Termina nodo:1036   */
      /* Termina nodo:1035   */
      /* Termina nodo:1034   */

      /* Empieza nodo:1037 / Elemento padre: 1033   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1037)).setAttribute("nombre","codIndSituWidgetTrId" );
      ((Element)v.get(1033)).appendChild((Element)v.get(1037));

      /* Empieza nodo:1038 / Elemento padre: 1037   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1038)).setAttribute("align","left" );
      ((Element)v.get(1038)).setAttribute("nowrap","true" );
      ((Element)v.get(1037)).appendChild((Element)v.get(1038));

      /* Empieza nodo:1039 / Elemento padre: 1038   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(1039)).setAttribute("nombre","codIndSitu" );
      ((Element)v.get(1039)).setAttribute("id","datosCampos" );
      ((Element)v.get(1039)).setAttribute("trim","S" );
      ((Element)v.get(1039)).setAttribute("max","1" );
      ((Element)v.get(1039)).setAttribute("onchange","" );
      ((Element)v.get(1039)).setAttribute("req","N" );
      ((Element)v.get(1039)).setAttribute("size","1" );
      ((Element)v.get(1039)).setAttribute("valor","" );
      ((Element)v.get(1039)).setAttribute("validacion","" );
      ((Element)v.get(1039)).setAttribute("disabled","" );
      ((Element)v.get(1039)).setAttribute("onblur","" );
      ((Element)v.get(1039)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true)" );
      ((Element)v.get(1039)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm', 0, false)" );
      ((Element)v.get(1038)).appendChild((Element)v.get(1039));
      /* Termina nodo:1039   */
      /* Termina nodo:1038   */
      /* Termina nodo:1037   */
      /* Termina nodo:1033   */
      /* Termina nodo:1032   */

      /* Empieza nodo:1040 / Elemento padre: 1031   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1040)).setAttribute("nombre","codIndSituGapTdId" );
      ((Element)v.get(1040)).setAttribute("nowrap","true" );
      ((Element)v.get(1040)).setAttribute("class","datosCampos" );
      ((Element)v.get(1031)).appendChild((Element)v.get(1040));

      /* Empieza nodo:1041 / Elemento padre: 1040   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1041)).setAttribute("src","b.gif" );
      ((Element)v.get(1041)).setAttribute("width","25" );
      ((Element)v.get(1041)).setAttribute("height","8" );
      ((Element)v.get(1040)).appendChild((Element)v.get(1041));
      /* Termina nodo:1041   */
      /* Termina nodo:1040   */

      /* Empieza nodo:1042 / Elemento padre: 1031   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1042)).setAttribute("width","100%" );
      ((Element)v.get(1031)).appendChild((Element)v.get(1042));

      /* Empieza nodo:1043 / Elemento padre: 1042   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1043)).setAttribute("src","b.gif" );
      ((Element)v.get(1042)).appendChild((Element)v.get(1043));
      /* Termina nodo:1043   */
      /* Termina nodo:1042   */
      /* Termina nodo:1031   */
      /* Termina nodo:1030   */
      /* Termina nodo:1029   */
      /* Termina nodo:1026   */

      /* Empieza nodo:1044 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1044)).setAttribute("nombre","formGapTr37" );
      ((Element)v.get(52)).appendChild((Element)v.get(1044));

      /* Empieza nodo:1045 / Elemento padre: 1044   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1045)).setAttribute("align","center" );
      ((Element)v.get(1045)).setAttribute("width","8" );
      ((Element)v.get(1044)).appendChild((Element)v.get(1045));

      /* Empieza nodo:1046 / Elemento padre: 1045   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1046)).setAttribute("src","b.gif" );
      ((Element)v.get(1046)).setAttribute("width","12" );
      ((Element)v.get(1046)).setAttribute("height","8" );
      ((Element)v.get(1045)).appendChild((Element)v.get(1046));
      /* Termina nodo:1046   */
      /* Termina nodo:1045   */

      /* Empieza nodo:1047 / Elemento padre: 1044   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1044)).appendChild((Element)v.get(1047));

      /* Empieza nodo:1048 / Elemento padre: 1047   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1048)).setAttribute("src","b.gif" );
      ((Element)v.get(1048)).setAttribute("width","8" );
      ((Element)v.get(1048)).setAttribute("height","8" );
      ((Element)v.get(1047)).appendChild((Element)v.get(1048));
      /* Termina nodo:1048   */
      /* Termina nodo:1047   */

      /* Empieza nodo:1049 / Elemento padre: 1044   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1049)).setAttribute("align","center" );
      ((Element)v.get(1049)).setAttribute("width","8" );
      ((Element)v.get(1044)).appendChild((Element)v.get(1049));

      /* Empieza nodo:1050 / Elemento padre: 1049   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1050)).setAttribute("src","b.gif" );
      ((Element)v.get(1050)).setAttribute("width","12" );
      ((Element)v.get(1050)).setAttribute("height","8" );
      ((Element)v.get(1049)).appendChild((Element)v.get(1050));
      /* Termina nodo:1050   */
      /* Termina nodo:1049   */
      /* Termina nodo:1044   */

      /* Empieza nodo:1051 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1051)).setAttribute("nombre","formTr38" );
      ((Element)v.get(52)).appendChild((Element)v.get(1051));

      /* Empieza nodo:1052 / Elemento padre: 1051   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1052)).setAttribute("align","center" );
      ((Element)v.get(1052)).setAttribute("width","8" );
      ((Element)v.get(1051)).appendChild((Element)v.get(1052));

      /* Empieza nodo:1053 / Elemento padre: 1052   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1053)).setAttribute("src","b.gif" );
      ((Element)v.get(1053)).setAttribute("width","8" );
      ((Element)v.get(1053)).setAttribute("height","12" );
      ((Element)v.get(1052)).appendChild((Element)v.get(1053));
      /* Termina nodo:1053   */
      /* Termina nodo:1052   */

      /* Empieza nodo:1054 / Elemento padre: 1051   */
      v.add(doc.createElement("TD"));
   }

   private void getXML4770(Document doc) {
      ((Element)v.get(1054)).setAttribute("width","100%" );
      ((Element)v.get(1051)).appendChild((Element)v.get(1054));

      /* Empieza nodo:1055 / Elemento padre: 1054   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1055)).setAttribute("width","100%" );
      ((Element)v.get(1055)).setAttribute("border","0" );
      ((Element)v.get(1055)).setAttribute("cellspacing","0" );
      ((Element)v.get(1055)).setAttribute("cellpadding","0" );
      ((Element)v.get(1055)).setAttribute("align","left" );
      ((Element)v.get(1054)).appendChild((Element)v.get(1055));

      /* Empieza nodo:1056 / Elemento padre: 1055   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1056)).setAttribute("align","left" );
      ((Element)v.get(1055)).appendChild((Element)v.get(1056));

      /* Empieza nodo:1057 / Elemento padre: 1056   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1057)).setAttribute("nombre","codIndDentCajaTdId" );
      ((Element)v.get(1056)).appendChild((Element)v.get(1057));

      /* Empieza nodo:1058 / Elemento padre: 1057   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1058)).setAttribute("width","100%" );
      ((Element)v.get(1058)).setAttribute("border","0" );
      ((Element)v.get(1058)).setAttribute("cellspacing","0" );
      ((Element)v.get(1058)).setAttribute("cellpadding","0" );
      ((Element)v.get(1058)).setAttribute("align","left" );
      ((Element)v.get(1057)).appendChild((Element)v.get(1058));

      /* Empieza nodo:1059 / Elemento padre: 1058   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1058)).appendChild((Element)v.get(1059));

      /* Empieza nodo:1060 / Elemento padre: 1059   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1060)).setAttribute("valign","top" );
      ((Element)v.get(1060)).setAttribute("height","13" );
      ((Element)v.get(1059)).appendChild((Element)v.get(1060));

      /* Empieza nodo:1061 / Elemento padre: 1060   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1061)).setAttribute("nombre","lblCodIndDentCaja" );
      ((Element)v.get(1061)).setAttribute("alto","13" );
      ((Element)v.get(1061)).setAttribute("filas","1" );
      ((Element)v.get(1061)).setAttribute("id","datosTitle" );
      ((Element)v.get(1061)).setAttribute("cod","MaeProdu.codIndDentCaja.label" );
      ((Element)v.get(1060)).appendChild((Element)v.get(1061));
      /* Termina nodo:1061   */
      /* Termina nodo:1060   */
      /* Termina nodo:1059   */

      /* Empieza nodo:1062 / Elemento padre: 1058   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1062)).setAttribute("nombre","codIndDentCajaWidgetTrId" );
      ((Element)v.get(1058)).appendChild((Element)v.get(1062));

      /* Empieza nodo:1063 / Elemento padre: 1062   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1063)).setAttribute("align","left" );
      ((Element)v.get(1063)).setAttribute("nowrap","true" );
      ((Element)v.get(1062)).appendChild((Element)v.get(1063));

      /* Empieza nodo:1064 / Elemento padre: 1063   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(1064)).setAttribute("nombre","codIndDentCaja" );
      ((Element)v.get(1064)).setAttribute("id","datosCampos" );
      ((Element)v.get(1064)).setAttribute("trim","S" );
      ((Element)v.get(1064)).setAttribute("max","1" );
      ((Element)v.get(1064)).setAttribute("onchange","" );
      ((Element)v.get(1064)).setAttribute("req","N" );
      ((Element)v.get(1064)).setAttribute("size","1" );
      ((Element)v.get(1064)).setAttribute("valor","" );
      ((Element)v.get(1064)).setAttribute("validacion","" );
      ((Element)v.get(1064)).setAttribute("disabled","" );
      ((Element)v.get(1064)).setAttribute("onblur","" );
      ((Element)v.get(1064)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true)" );
      ((Element)v.get(1064)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm', 0, false)" );
      ((Element)v.get(1063)).appendChild((Element)v.get(1064));
      /* Termina nodo:1064   */
      /* Termina nodo:1063   */
      /* Termina nodo:1062   */
      /* Termina nodo:1058   */
      /* Termina nodo:1057   */

      /* Empieza nodo:1065 / Elemento padre: 1056   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1065)).setAttribute("nombre","codIndDentCajaGapTdId" );
      ((Element)v.get(1065)).setAttribute("nowrap","true" );
      ((Element)v.get(1065)).setAttribute("class","datosCampos" );
      ((Element)v.get(1056)).appendChild((Element)v.get(1065));

      /* Empieza nodo:1066 / Elemento padre: 1065   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1066)).setAttribute("src","b.gif" );
      ((Element)v.get(1066)).setAttribute("width","25" );
      ((Element)v.get(1066)).setAttribute("height","8" );
      ((Element)v.get(1065)).appendChild((Element)v.get(1066));
      /* Termina nodo:1066   */
      /* Termina nodo:1065   */

      /* Empieza nodo:1067 / Elemento padre: 1056   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1067)).setAttribute("width","100%" );
      ((Element)v.get(1056)).appendChild((Element)v.get(1067));

      /* Empieza nodo:1068 / Elemento padre: 1067   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1068)).setAttribute("src","b.gif" );
      ((Element)v.get(1067)).appendChild((Element)v.get(1068));
      /* Termina nodo:1068   */
      /* Termina nodo:1067   */
      /* Termina nodo:1056   */
      /* Termina nodo:1055   */
      /* Termina nodo:1054   */
      /* Termina nodo:1051   */

      /* Empieza nodo:1069 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1069)).setAttribute("nombre","formGapTr38" );
      ((Element)v.get(52)).appendChild((Element)v.get(1069));

      /* Empieza nodo:1070 / Elemento padre: 1069   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1070)).setAttribute("align","center" );
      ((Element)v.get(1070)).setAttribute("width","8" );
      ((Element)v.get(1069)).appendChild((Element)v.get(1070));

      /* Empieza nodo:1071 / Elemento padre: 1070   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1071)).setAttribute("src","b.gif" );
      ((Element)v.get(1071)).setAttribute("width","12" );
      ((Element)v.get(1071)).setAttribute("height","8" );
      ((Element)v.get(1070)).appendChild((Element)v.get(1071));
      /* Termina nodo:1071   */
      /* Termina nodo:1070   */

      /* Empieza nodo:1072 / Elemento padre: 1069   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1069)).appendChild((Element)v.get(1072));

      /* Empieza nodo:1073 / Elemento padre: 1072   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1073)).setAttribute("src","b.gif" );
      ((Element)v.get(1073)).setAttribute("width","8" );
   }

   private void getXML4860(Document doc) {
      ((Element)v.get(1073)).setAttribute("height","8" );
      ((Element)v.get(1072)).appendChild((Element)v.get(1073));
      /* Termina nodo:1073   */
      /* Termina nodo:1072   */

      /* Empieza nodo:1074 / Elemento padre: 1069   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1074)).setAttribute("align","center" );
      ((Element)v.get(1074)).setAttribute("width","8" );
      ((Element)v.get(1069)).appendChild((Element)v.get(1074));

      /* Empieza nodo:1075 / Elemento padre: 1074   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1075)).setAttribute("src","b.gif" );
      ((Element)v.get(1075)).setAttribute("width","12" );
      ((Element)v.get(1075)).setAttribute("height","8" );
      ((Element)v.get(1074)).appendChild((Element)v.get(1075));
      /* Termina nodo:1075   */
      /* Termina nodo:1074   */
      /* Termina nodo:1069   */

      /* Empieza nodo:1076 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1076)).setAttribute("nombre","formTr39" );
      ((Element)v.get(52)).appendChild((Element)v.get(1076));

      /* Empieza nodo:1077 / Elemento padre: 1076   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1077)).setAttribute("align","center" );
      ((Element)v.get(1077)).setAttribute("width","8" );
      ((Element)v.get(1076)).appendChild((Element)v.get(1077));

      /* Empieza nodo:1078 / Elemento padre: 1077   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1078)).setAttribute("src","b.gif" );
      ((Element)v.get(1078)).setAttribute("width","8" );
      ((Element)v.get(1078)).setAttribute("height","12" );
      ((Element)v.get(1077)).appendChild((Element)v.get(1078));
      /* Termina nodo:1078   */
      /* Termina nodo:1077   */

      /* Empieza nodo:1079 / Elemento padre: 1076   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1079)).setAttribute("width","100%" );
      ((Element)v.get(1076)).appendChild((Element)v.get(1079));

      /* Empieza nodo:1080 / Elemento padre: 1079   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1080)).setAttribute("width","100%" );
      ((Element)v.get(1080)).setAttribute("border","0" );
      ((Element)v.get(1080)).setAttribute("cellspacing","0" );
      ((Element)v.get(1080)).setAttribute("cellpadding","0" );
      ((Element)v.get(1080)).setAttribute("align","left" );
      ((Element)v.get(1079)).appendChild((Element)v.get(1080));

      /* Empieza nodo:1081 / Elemento padre: 1080   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1081)).setAttribute("align","left" );
      ((Element)v.get(1080)).appendChild((Element)v.get(1081));

      /* Empieza nodo:1082 / Elemento padre: 1081   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1082)).setAttribute("nombre","indKitTdId" );
      ((Element)v.get(1081)).appendChild((Element)v.get(1082));

      /* Empieza nodo:1083 / Elemento padre: 1082   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1083)).setAttribute("width","100%" );
      ((Element)v.get(1083)).setAttribute("border","0" );
      ((Element)v.get(1083)).setAttribute("cellspacing","0" );
      ((Element)v.get(1083)).setAttribute("cellpadding","0" );
      ((Element)v.get(1083)).setAttribute("align","left" );
      ((Element)v.get(1082)).appendChild((Element)v.get(1083));

      /* Empieza nodo:1084 / Elemento padre: 1083   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1083)).appendChild((Element)v.get(1084));

      /* Empieza nodo:1085 / Elemento padre: 1084   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1085)).setAttribute("valign","top" );
      ((Element)v.get(1085)).setAttribute("height","13" );
      ((Element)v.get(1084)).appendChild((Element)v.get(1085));

      /* Empieza nodo:1086 / Elemento padre: 1085   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1086)).setAttribute("nombre","lblIndKit" );
      ((Element)v.get(1086)).setAttribute("alto","13" );
      ((Element)v.get(1086)).setAttribute("filas","1" );
      ((Element)v.get(1086)).setAttribute("id","datosTitle" );
      ((Element)v.get(1086)).setAttribute("cod","MaeProdu.indKit.label" );
      ((Element)v.get(1085)).appendChild((Element)v.get(1086));
      /* Termina nodo:1086   */
      /* Termina nodo:1085   */
      /* Termina nodo:1084   */

      /* Empieza nodo:1087 / Elemento padre: 1083   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1087)).setAttribute("nombre","indKitWidgetTrId" );
      ((Element)v.get(1083)).appendChild((Element)v.get(1087));

      /* Empieza nodo:1088 / Elemento padre: 1087   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1088)).setAttribute("align","left" );
      ((Element)v.get(1088)).setAttribute("nowrap","true" );
      ((Element)v.get(1087)).appendChild((Element)v.get(1088));

      /* Empieza nodo:1089 / Elemento padre: 1088   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(1089)).setAttribute("nombre","indKit" );
      ((Element)v.get(1089)).setAttribute("id","datosCampos" );
      ((Element)v.get(1089)).setAttribute("trim","S" );
      ((Element)v.get(1089)).setAttribute("max","1" );
      ((Element)v.get(1089)).setAttribute("onchange","" );
      ((Element)v.get(1089)).setAttribute("req","N" );
      ((Element)v.get(1089)).setAttribute("size","1" );
      ((Element)v.get(1089)).setAttribute("valor","" );
      ((Element)v.get(1089)).setAttribute("validacion","" );
      ((Element)v.get(1089)).setAttribute("disabled","" );
      ((Element)v.get(1089)).setAttribute("onblur","" );
      ((Element)v.get(1089)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true)" );
      ((Element)v.get(1089)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm', 0, false)" );
      ((Element)v.get(1088)).appendChild((Element)v.get(1089));
      /* Termina nodo:1089   */
      /* Termina nodo:1088   */
      /* Termina nodo:1087   */
      /* Termina nodo:1083   */
      /* Termina nodo:1082   */

      /* Empieza nodo:1090 / Elemento padre: 1081   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1090)).setAttribute("nombre","indKitGapTdId" );
      ((Element)v.get(1090)).setAttribute("nowrap","true" );
      ((Element)v.get(1090)).setAttribute("class","datosCampos" );
      ((Element)v.get(1081)).appendChild((Element)v.get(1090));

      /* Empieza nodo:1091 / Elemento padre: 1090   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1091)).setAttribute("src","b.gif" );
      ((Element)v.get(1091)).setAttribute("width","25" );
      ((Element)v.get(1091)).setAttribute("height","8" );
   }

   private void getXML4950(Document doc) {
      ((Element)v.get(1090)).appendChild((Element)v.get(1091));
      /* Termina nodo:1091   */
      /* Termina nodo:1090   */

      /* Empieza nodo:1092 / Elemento padre: 1081   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1092)).setAttribute("width","100%" );
      ((Element)v.get(1081)).appendChild((Element)v.get(1092));

      /* Empieza nodo:1093 / Elemento padre: 1092   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1093)).setAttribute("src","b.gif" );
      ((Element)v.get(1092)).appendChild((Element)v.get(1093));
      /* Termina nodo:1093   */
      /* Termina nodo:1092   */
      /* Termina nodo:1081   */
      /* Termina nodo:1080   */
      /* Termina nodo:1079   */
      /* Termina nodo:1076   */

      /* Empieza nodo:1094 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1094)).setAttribute("nombre","formGapTr39" );
      ((Element)v.get(52)).appendChild((Element)v.get(1094));

      /* Empieza nodo:1095 / Elemento padre: 1094   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1095)).setAttribute("align","center" );
      ((Element)v.get(1095)).setAttribute("width","8" );
      ((Element)v.get(1094)).appendChild((Element)v.get(1095));

      /* Empieza nodo:1096 / Elemento padre: 1095   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1096)).setAttribute("src","b.gif" );
      ((Element)v.get(1096)).setAttribute("width","12" );
      ((Element)v.get(1096)).setAttribute("height","8" );
      ((Element)v.get(1095)).appendChild((Element)v.get(1096));
      /* Termina nodo:1096   */
      /* Termina nodo:1095   */

      /* Empieza nodo:1097 / Elemento padre: 1094   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1094)).appendChild((Element)v.get(1097));

      /* Empieza nodo:1098 / Elemento padre: 1097   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1098)).setAttribute("src","b.gif" );
      ((Element)v.get(1098)).setAttribute("width","8" );
      ((Element)v.get(1098)).setAttribute("height","8" );
      ((Element)v.get(1097)).appendChild((Element)v.get(1098));
      /* Termina nodo:1098   */
      /* Termina nodo:1097   */

      /* Empieza nodo:1099 / Elemento padre: 1094   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1099)).setAttribute("align","center" );
      ((Element)v.get(1099)).setAttribute("width","8" );
      ((Element)v.get(1094)).appendChild((Element)v.get(1099));

      /* Empieza nodo:1100 / Elemento padre: 1099   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1100)).setAttribute("src","b.gif" );
      ((Element)v.get(1100)).setAttribute("width","12" );
      ((Element)v.get(1100)).setAttribute("height","8" );
      ((Element)v.get(1099)).appendChild((Element)v.get(1100));
      /* Termina nodo:1100   */
      /* Termina nodo:1099   */
      /* Termina nodo:1094   */

      /* Empieza nodo:1101 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1101)).setAttribute("nombre","formTr40" );
      ((Element)v.get(52)).appendChild((Element)v.get(1101));

      /* Empieza nodo:1102 / Elemento padre: 1101   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1102)).setAttribute("align","center" );
      ((Element)v.get(1102)).setAttribute("width","8" );
      ((Element)v.get(1101)).appendChild((Element)v.get(1102));

      /* Empieza nodo:1103 / Elemento padre: 1102   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1103)).setAttribute("src","b.gif" );
      ((Element)v.get(1103)).setAttribute("width","8" );
      ((Element)v.get(1103)).setAttribute("height","12" );
      ((Element)v.get(1102)).appendChild((Element)v.get(1103));
      /* Termina nodo:1103   */
      /* Termina nodo:1102   */

      /* Empieza nodo:1104 / Elemento padre: 1101   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1104)).setAttribute("width","100%" );
      ((Element)v.get(1101)).appendChild((Element)v.get(1104));

      /* Empieza nodo:1105 / Elemento padre: 1104   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1105)).setAttribute("width","100%" );
      ((Element)v.get(1105)).setAttribute("border","0" );
      ((Element)v.get(1105)).setAttribute("cellspacing","0" );
      ((Element)v.get(1105)).setAttribute("cellpadding","0" );
      ((Element)v.get(1105)).setAttribute("align","left" );
      ((Element)v.get(1104)).appendChild((Element)v.get(1105));

      /* Empieza nodo:1106 / Elemento padre: 1105   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1106)).setAttribute("align","left" );
      ((Element)v.get(1105)).appendChild((Element)v.get(1106));

      /* Empieza nodo:1107 / Elemento padre: 1106   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1107)).setAttribute("nombre","fopaOidFormPagoTdId" );
      ((Element)v.get(1106)).appendChild((Element)v.get(1107));

      /* Empieza nodo:1108 / Elemento padre: 1107   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1108)).setAttribute("border","0" );
      ((Element)v.get(1108)).setAttribute("cellspacing","0" );
      ((Element)v.get(1108)).setAttribute("cellpadding","0" );
      ((Element)v.get(1108)).setAttribute("align","left" );
      ((Element)v.get(1107)).appendChild((Element)v.get(1108));

      /* Empieza nodo:1109 / Elemento padre: 1108   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1108)).appendChild((Element)v.get(1109));

      /* Empieza nodo:1110 / Elemento padre: 1109   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1110)).setAttribute("valign","top" );
      ((Element)v.get(1110)).setAttribute("height","13" );
      ((Element)v.get(1109)).appendChild((Element)v.get(1110));

      /* Empieza nodo:1111 / Elemento padre: 1110   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1111)).setAttribute("nombre","lblfopaOidFormPago" );
      ((Element)v.get(1111)).setAttribute("id","datosTitle" );
      ((Element)v.get(1111)).setAttribute("ancho","150" );
      ((Element)v.get(1111)).setAttribute("alto","13" );
      ((Element)v.get(1111)).setAttribute("cod","MaeProdu.fopaOidFormPago.label" );
      ((Element)v.get(1110)).appendChild((Element)v.get(1111));
      /* Termina nodo:1111   */
      /* Termina nodo:1110   */
      /* Termina nodo:1109   */

      /* Empieza nodo:1112 / Elemento padre: 1108   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1112)).setAttribute("nombre","fopaOidFormPagoWidgetTrId" );
      ((Element)v.get(1108)).appendChild((Element)v.get(1112));

      /* Empieza nodo:1113 / Elemento padre: 1112   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1113)).setAttribute("align","left" );
      ((Element)v.get(1113)).setAttribute("nowrap","true" );
      ((Element)v.get(1112)).appendChild((Element)v.get(1113));

      /* Empieza nodo:1114 / Elemento padre: 1113   */
      v.add(doc.createElement("COMBO"));
   }

   private void getXML5040(Document doc) {
      ((Element)v.get(1114)).setAttribute("nombre","fopaOidFormPago" );
      ((Element)v.get(1114)).setAttribute("id","datosCampos" );
      ((Element)v.get(1114)).setAttribute("multiple","N" );
      ((Element)v.get(1114)).setAttribute("req","N" );
      ((Element)v.get(1114)).setAttribute("size","1" );
      ((Element)v.get(1114)).setAttribute("disabled","" );
      ((Element)v.get(1114)).setAttribute("validacion","" );
      ((Element)v.get(1114)).setAttribute("onchange","" );
      ((Element)v.get(1114)).setAttribute("onfocus","" );
      ((Element)v.get(1114)).setAttribute("valorinicial","" );
      ((Element)v.get(1114)).setAttribute("textoinicial","" );
      ((Element)v.get(1114)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true);" );
      ((Element)v.get(1114)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm',0, false);" );
      ((Element)v.get(1113)).appendChild((Element)v.get(1114));

      /* Empieza nodo:1115 / Elemento padre: 1114   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(1114)).appendChild((Element)v.get(1115));
      /* Termina nodo:1115   */
      /* Termina nodo:1114   */
      /* Termina nodo:1113   */
      /* Termina nodo:1112   */
      /* Termina nodo:1108   */
      /* Termina nodo:1107   */

      /* Empieza nodo:1116 / Elemento padre: 1106   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1116)).setAttribute("nombre","fopaOidFormPagoGapTdId" );
      ((Element)v.get(1116)).setAttribute("nowrap","true" );
      ((Element)v.get(1116)).setAttribute("class","datosCampos" );
      ((Element)v.get(1106)).appendChild((Element)v.get(1116));

      /* Empieza nodo:1117 / Elemento padre: 1116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1117)).setAttribute("src","b.gif" );
      ((Element)v.get(1117)).setAttribute("width","25" );
      ((Element)v.get(1117)).setAttribute("height","8" );
      ((Element)v.get(1116)).appendChild((Element)v.get(1117));
      /* Termina nodo:1117   */
      /* Termina nodo:1116   */

      /* Empieza nodo:1118 / Elemento padre: 1106   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1118)).setAttribute("width","100%" );
      ((Element)v.get(1106)).appendChild((Element)v.get(1118));

      /* Empieza nodo:1119 / Elemento padre: 1118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1119)).setAttribute("src","b.gif" );
      ((Element)v.get(1118)).appendChild((Element)v.get(1119));
      /* Termina nodo:1119   */
      /* Termina nodo:1118   */
      /* Termina nodo:1106   */
      /* Termina nodo:1105   */
      /* Termina nodo:1104   */
      /* Termina nodo:1101   */

      /* Empieza nodo:1120 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1120)).setAttribute("nombre","formGapTr40" );
      ((Element)v.get(52)).appendChild((Element)v.get(1120));

      /* Empieza nodo:1121 / Elemento padre: 1120   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1121)).setAttribute("align","center" );
      ((Element)v.get(1121)).setAttribute("width","8" );
      ((Element)v.get(1120)).appendChild((Element)v.get(1121));

      /* Empieza nodo:1122 / Elemento padre: 1121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1122)).setAttribute("src","b.gif" );
      ((Element)v.get(1122)).setAttribute("width","12" );
      ((Element)v.get(1122)).setAttribute("height","8" );
      ((Element)v.get(1121)).appendChild((Element)v.get(1122));
      /* Termina nodo:1122   */
      /* Termina nodo:1121   */

      /* Empieza nodo:1123 / Elemento padre: 1120   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1120)).appendChild((Element)v.get(1123));

      /* Empieza nodo:1124 / Elemento padre: 1123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1124)).setAttribute("src","b.gif" );
      ((Element)v.get(1124)).setAttribute("width","8" );
      ((Element)v.get(1124)).setAttribute("height","8" );
      ((Element)v.get(1123)).appendChild((Element)v.get(1124));
      /* Termina nodo:1124   */
      /* Termina nodo:1123   */

      /* Empieza nodo:1125 / Elemento padre: 1120   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1125)).setAttribute("align","center" );
      ((Element)v.get(1125)).setAttribute("width","8" );
      ((Element)v.get(1120)).appendChild((Element)v.get(1125));

      /* Empieza nodo:1126 / Elemento padre: 1125   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1126)).setAttribute("src","b.gif" );
      ((Element)v.get(1126)).setAttribute("width","12" );
      ((Element)v.get(1126)).setAttribute("height","8" );
      ((Element)v.get(1125)).appendChild((Element)v.get(1126));
      /* Termina nodo:1126   */
      /* Termina nodo:1125   */
      /* Termina nodo:1120   */

      /* Empieza nodo:1127 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1127)).setAttribute("nombre","formTr41" );
      ((Element)v.get(52)).appendChild((Element)v.get(1127));

      /* Empieza nodo:1128 / Elemento padre: 1127   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1128)).setAttribute("align","center" );
      ((Element)v.get(1128)).setAttribute("width","8" );
      ((Element)v.get(1127)).appendChild((Element)v.get(1128));

      /* Empieza nodo:1129 / Elemento padre: 1128   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1129)).setAttribute("src","b.gif" );
      ((Element)v.get(1129)).setAttribute("width","8" );
      ((Element)v.get(1129)).setAttribute("height","12" );
      ((Element)v.get(1128)).appendChild((Element)v.get(1129));
      /* Termina nodo:1129   */
      /* Termina nodo:1128   */

      /* Empieza nodo:1130 / Elemento padre: 1127   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1130)).setAttribute("width","100%" );
      ((Element)v.get(1127)).appendChild((Element)v.get(1130));

      /* Empieza nodo:1131 / Elemento padre: 1130   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1131)).setAttribute("width","100%" );
      ((Element)v.get(1131)).setAttribute("border","0" );
      ((Element)v.get(1131)).setAttribute("cellspacing","0" );
      ((Element)v.get(1131)).setAttribute("cellpadding","0" );
      ((Element)v.get(1131)).setAttribute("align","left" );
      ((Element)v.get(1130)).appendChild((Element)v.get(1131));

      /* Empieza nodo:1132 / Elemento padre: 1131   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1132)).setAttribute("align","left" );
      ((Element)v.get(1131)).appendChild((Element)v.get(1132));

      /* Empieza nodo:1133 / Elemento padre: 1132   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1133)).setAttribute("nombre","maprOidMarcProdTdId" );
      ((Element)v.get(1132)).appendChild((Element)v.get(1133));

      /* Empieza nodo:1134 / Elemento padre: 1133   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1134)).setAttribute("border","0" );
   }

   private void getXML5130(Document doc) {
      ((Element)v.get(1134)).setAttribute("cellspacing","0" );
      ((Element)v.get(1134)).setAttribute("cellpadding","0" );
      ((Element)v.get(1134)).setAttribute("align","left" );
      ((Element)v.get(1133)).appendChild((Element)v.get(1134));

      /* Empieza nodo:1135 / Elemento padre: 1134   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1134)).appendChild((Element)v.get(1135));

      /* Empieza nodo:1136 / Elemento padre: 1135   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1136)).setAttribute("valign","top" );
      ((Element)v.get(1136)).setAttribute("height","13" );
      ((Element)v.get(1135)).appendChild((Element)v.get(1136));

      /* Empieza nodo:1137 / Elemento padre: 1136   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1137)).setAttribute("nombre","lblmaprOidMarcProd" );
      ((Element)v.get(1137)).setAttribute("id","datosTitle" );
      ((Element)v.get(1137)).setAttribute("ancho","150" );
      ((Element)v.get(1137)).setAttribute("alto","13" );
      ((Element)v.get(1137)).setAttribute("cod","MaeProdu.maprOidMarcProd.label" );
      ((Element)v.get(1136)).appendChild((Element)v.get(1137));
      /* Termina nodo:1137   */
      /* Termina nodo:1136   */
      /* Termina nodo:1135   */

      /* Empieza nodo:1138 / Elemento padre: 1134   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1138)).setAttribute("nombre","maprOidMarcProdWidgetTrId" );
      ((Element)v.get(1134)).appendChild((Element)v.get(1138));

      /* Empieza nodo:1139 / Elemento padre: 1138   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1139)).setAttribute("align","left" );
      ((Element)v.get(1139)).setAttribute("nowrap","true" );
      ((Element)v.get(1138)).appendChild((Element)v.get(1139));

      /* Empieza nodo:1140 / Elemento padre: 1139   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(1140)).setAttribute("nombre","maprOidMarcProd" );
      ((Element)v.get(1140)).setAttribute("id","datosCampos" );
      ((Element)v.get(1140)).setAttribute("multiple","N" );
      ((Element)v.get(1140)).setAttribute("req","N" );
      ((Element)v.get(1140)).setAttribute("size","1" );
      ((Element)v.get(1140)).setAttribute("disabled","" );
      ((Element)v.get(1140)).setAttribute("validacion","" );
      ((Element)v.get(1140)).setAttribute("onchange","" );
      ((Element)v.get(1140)).setAttribute("onfocus","" );
      ((Element)v.get(1140)).setAttribute("valorinicial","" );
      ((Element)v.get(1140)).setAttribute("textoinicial","" );
      ((Element)v.get(1140)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true);" );
      ((Element)v.get(1140)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm',0, false);" );
      ((Element)v.get(1139)).appendChild((Element)v.get(1140));

      /* Empieza nodo:1141 / Elemento padre: 1140   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(1140)).appendChild((Element)v.get(1141));
      /* Termina nodo:1141   */
      /* Termina nodo:1140   */
      /* Termina nodo:1139   */
      /* Termina nodo:1138   */
      /* Termina nodo:1134   */
      /* Termina nodo:1133   */

      /* Empieza nodo:1142 / Elemento padre: 1132   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1142)).setAttribute("nombre","maprOidMarcProdGapTdId" );
      ((Element)v.get(1142)).setAttribute("nowrap","true" );
      ((Element)v.get(1142)).setAttribute("class","datosCampos" );
      ((Element)v.get(1132)).appendChild((Element)v.get(1142));

      /* Empieza nodo:1143 / Elemento padre: 1142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1143)).setAttribute("src","b.gif" );
      ((Element)v.get(1143)).setAttribute("width","25" );
      ((Element)v.get(1143)).setAttribute("height","8" );
      ((Element)v.get(1142)).appendChild((Element)v.get(1143));
      /* Termina nodo:1143   */
      /* Termina nodo:1142   */

      /* Empieza nodo:1144 / Elemento padre: 1132   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1144)).setAttribute("width","100%" );
      ((Element)v.get(1132)).appendChild((Element)v.get(1144));

      /* Empieza nodo:1145 / Elemento padre: 1144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1145)).setAttribute("src","b.gif" );
      ((Element)v.get(1144)).appendChild((Element)v.get(1145));
      /* Termina nodo:1145   */
      /* Termina nodo:1144   */
      /* Termina nodo:1132   */
      /* Termina nodo:1131   */
      /* Termina nodo:1130   */
      /* Termina nodo:1127   */

      /* Empieza nodo:1146 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1146)).setAttribute("nombre","formGapTr41" );
      ((Element)v.get(52)).appendChild((Element)v.get(1146));

      /* Empieza nodo:1147 / Elemento padre: 1146   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1147)).setAttribute("align","center" );
      ((Element)v.get(1147)).setAttribute("width","8" );
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
      ((Element)v.get(1151)).setAttribute("width","8" );
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

      /* Empieza nodo:1153 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1153)).setAttribute("nombre","formTr42" );
      ((Element)v.get(52)).appendChild((Element)v.get(1153));

      /* Empieza nodo:1154 / Elemento padre: 1153   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1154)).setAttribute("align","center" );
   }

   private void getXML5220(Document doc) {
      ((Element)v.get(1154)).setAttribute("width","8" );
      ((Element)v.get(1153)).appendChild((Element)v.get(1154));

      /* Empieza nodo:1155 / Elemento padre: 1154   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1155)).setAttribute("src","b.gif" );
      ((Element)v.get(1155)).setAttribute("width","8" );
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
      ((Element)v.get(1159)).setAttribute("nombre","valGrupArtiTdId" );
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
      ((Element)v.get(1163)).setAttribute("nombre","lblValGrupArti" );
      ((Element)v.get(1163)).setAttribute("alto","13" );
      ((Element)v.get(1163)).setAttribute("filas","1" );
      ((Element)v.get(1163)).setAttribute("id","datosTitle" );
      ((Element)v.get(1163)).setAttribute("cod","MaeProdu.valGrupArti.label" );
      ((Element)v.get(1162)).appendChild((Element)v.get(1163));
      /* Termina nodo:1163   */
      /* Termina nodo:1162   */
      /* Termina nodo:1161   */

      /* Empieza nodo:1164 / Elemento padre: 1160   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1164)).setAttribute("nombre","valGrupArtiWidgetTrId" );
      ((Element)v.get(1160)).appendChild((Element)v.get(1164));

      /* Empieza nodo:1165 / Elemento padre: 1164   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1165)).setAttribute("align","left" );
      ((Element)v.get(1165)).setAttribute("nowrap","true" );
      ((Element)v.get(1164)).appendChild((Element)v.get(1165));

      /* Empieza nodo:1166 / Elemento padre: 1165   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(1166)).setAttribute("nombre","valGrupArti" );
      ((Element)v.get(1166)).setAttribute("id","datosCampos" );
      ((Element)v.get(1166)).setAttribute("trim","S" );
      ((Element)v.get(1166)).setAttribute("max","9" );
      ((Element)v.get(1166)).setAttribute("onchange","" );
      ((Element)v.get(1166)).setAttribute("req","N" );
      ((Element)v.get(1166)).setAttribute("size","9" );
      ((Element)v.get(1166)).setAttribute("valor","" );
      ((Element)v.get(1166)).setAttribute("validacion","" );
      ((Element)v.get(1166)).setAttribute("disabled","" );
      ((Element)v.get(1166)).setAttribute("onblur","" );
      ((Element)v.get(1166)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true)" );
      ((Element)v.get(1166)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm', 0, false)" );
      ((Element)v.get(1165)).appendChild((Element)v.get(1166));
      /* Termina nodo:1166   */
      /* Termina nodo:1165   */
      /* Termina nodo:1164   */
      /* Termina nodo:1160   */
      /* Termina nodo:1159   */

      /* Empieza nodo:1167 / Elemento padre: 1158   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1167)).setAttribute("nombre","valGrupArtiGapTdId" );
      ((Element)v.get(1167)).setAttribute("nowrap","true" );
      ((Element)v.get(1167)).setAttribute("class","datosCampos" );
      ((Element)v.get(1158)).appendChild((Element)v.get(1167));

      /* Empieza nodo:1168 / Elemento padre: 1167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1168)).setAttribute("src","b.gif" );
      ((Element)v.get(1168)).setAttribute("width","25" );
      ((Element)v.get(1168)).setAttribute("height","8" );
      ((Element)v.get(1167)).appendChild((Element)v.get(1168));
      /* Termina nodo:1168   */
      /* Termina nodo:1167   */

      /* Empieza nodo:1169 / Elemento padre: 1158   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1169)).setAttribute("width","100%" );
      ((Element)v.get(1158)).appendChild((Element)v.get(1169));

      /* Empieza nodo:1170 / Elemento padre: 1169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1170)).setAttribute("src","b.gif" );
      ((Element)v.get(1169)).appendChild((Element)v.get(1170));
      /* Termina nodo:1170   */
      /* Termina nodo:1169   */
      /* Termina nodo:1158   */
      /* Termina nodo:1157   */
      /* Termina nodo:1156   */
      /* Termina nodo:1153   */

      /* Empieza nodo:1171 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1171)).setAttribute("nombre","formGapTr42" );
      ((Element)v.get(52)).appendChild((Element)v.get(1171));

      /* Empieza nodo:1172 / Elemento padre: 1171   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1172)).setAttribute("align","center" );
      ((Element)v.get(1172)).setAttribute("width","8" );
      ((Element)v.get(1171)).appendChild((Element)v.get(1172));

      /* Empieza nodo:1173 / Elemento padre: 1172   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1173)).setAttribute("src","b.gif" );
   }

   private void getXML5310(Document doc) {
      ((Element)v.get(1173)).setAttribute("width","12" );
      ((Element)v.get(1173)).setAttribute("height","8" );
      ((Element)v.get(1172)).appendChild((Element)v.get(1173));
      /* Termina nodo:1173   */
      /* Termina nodo:1172   */

      /* Empieza nodo:1174 / Elemento padre: 1171   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1171)).appendChild((Element)v.get(1174));

      /* Empieza nodo:1175 / Elemento padre: 1174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1175)).setAttribute("src","b.gif" );
      ((Element)v.get(1175)).setAttribute("width","8" );
      ((Element)v.get(1175)).setAttribute("height","8" );
      ((Element)v.get(1174)).appendChild((Element)v.get(1175));
      /* Termina nodo:1175   */
      /* Termina nodo:1174   */

      /* Empieza nodo:1176 / Elemento padre: 1171   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1176)).setAttribute("align","center" );
      ((Element)v.get(1176)).setAttribute("width","8" );
      ((Element)v.get(1171)).appendChild((Element)v.get(1176));

      /* Empieza nodo:1177 / Elemento padre: 1176   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1177)).setAttribute("src","b.gif" );
      ((Element)v.get(1177)).setAttribute("width","12" );
      ((Element)v.get(1177)).setAttribute("height","8" );
      ((Element)v.get(1176)).appendChild((Element)v.get(1177));
      /* Termina nodo:1177   */
      /* Termina nodo:1176   */
      /* Termina nodo:1171   */

      /* Empieza nodo:1178 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1178)).setAttribute("nombre","formTr43" );
      ((Element)v.get(52)).appendChild((Element)v.get(1178));

      /* Empieza nodo:1179 / Elemento padre: 1178   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1179)).setAttribute("align","center" );
      ((Element)v.get(1179)).setAttribute("width","8" );
      ((Element)v.get(1178)).appendChild((Element)v.get(1179));

      /* Empieza nodo:1180 / Elemento padre: 1179   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1180)).setAttribute("src","b.gif" );
      ((Element)v.get(1180)).setAttribute("width","8" );
      ((Element)v.get(1180)).setAttribute("height","12" );
      ((Element)v.get(1179)).appendChild((Element)v.get(1180));
      /* Termina nodo:1180   */
      /* Termina nodo:1179   */

      /* Empieza nodo:1181 / Elemento padre: 1178   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1181)).setAttribute("width","100%" );
      ((Element)v.get(1178)).appendChild((Element)v.get(1181));

      /* Empieza nodo:1182 / Elemento padre: 1181   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1182)).setAttribute("width","100%" );
      ((Element)v.get(1182)).setAttribute("border","0" );
      ((Element)v.get(1182)).setAttribute("cellspacing","0" );
      ((Element)v.get(1182)).setAttribute("cellpadding","0" );
      ((Element)v.get(1182)).setAttribute("align","left" );
      ((Element)v.get(1181)).appendChild((Element)v.get(1182));

      /* Empieza nodo:1183 / Elemento padre: 1182   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1183)).setAttribute("align","left" );
      ((Element)v.get(1182)).appendChild((Element)v.get(1183));

      /* Empieza nodo:1184 / Elemento padre: 1183   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1184)).setAttribute("nombre","codUnicVentTdId" );
      ((Element)v.get(1183)).appendChild((Element)v.get(1184));

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
      ((Element)v.get(1185)).appendChild((Element)v.get(1186));

      /* Empieza nodo:1187 / Elemento padre: 1186   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1187)).setAttribute("valign","top" );
      ((Element)v.get(1187)).setAttribute("height","13" );
      ((Element)v.get(1186)).appendChild((Element)v.get(1187));

      /* Empieza nodo:1188 / Elemento padre: 1187   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1188)).setAttribute("nombre","lblCodUnicVent" );
      ((Element)v.get(1188)).setAttribute("alto","13" );
      ((Element)v.get(1188)).setAttribute("filas","1" );
      ((Element)v.get(1188)).setAttribute("id","datosTitle" );
      ((Element)v.get(1188)).setAttribute("cod","MaeProdu.codUnicVent.label" );
      ((Element)v.get(1187)).appendChild((Element)v.get(1188));
      /* Termina nodo:1188   */
      /* Termina nodo:1187   */
      /* Termina nodo:1186   */

      /* Empieza nodo:1189 / Elemento padre: 1185   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1189)).setAttribute("nombre","codUnicVentWidgetTrId" );
      ((Element)v.get(1185)).appendChild((Element)v.get(1189));

      /* Empieza nodo:1190 / Elemento padre: 1189   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1190)).setAttribute("align","left" );
      ((Element)v.get(1190)).setAttribute("nowrap","true" );
      ((Element)v.get(1189)).appendChild((Element)v.get(1190));

      /* Empieza nodo:1191 / Elemento padre: 1190   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(1191)).setAttribute("nombre","codUnicVent" );
      ((Element)v.get(1191)).setAttribute("id","datosCampos" );
      ((Element)v.get(1191)).setAttribute("trim","S" );
      ((Element)v.get(1191)).setAttribute("max","6" );
      ((Element)v.get(1191)).setAttribute("onchange","" );
      ((Element)v.get(1191)).setAttribute("req","N" );
      ((Element)v.get(1191)).setAttribute("size","6" );
      ((Element)v.get(1191)).setAttribute("valor","" );
      ((Element)v.get(1191)).setAttribute("validacion","" );
      ((Element)v.get(1191)).setAttribute("disabled","" );
      ((Element)v.get(1191)).setAttribute("onblur","" );
      ((Element)v.get(1191)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true)" );
      ((Element)v.get(1191)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm', 0, false)" );
      ((Element)v.get(1190)).appendChild((Element)v.get(1191));
      /* Termina nodo:1191   */
      /* Termina nodo:1190   */
      /* Termina nodo:1189   */
      /* Termina nodo:1185   */
      /* Termina nodo:1184   */

      /* Empieza nodo:1192 / Elemento padre: 1183   */
      v.add(doc.createElement("TD"));
   }

   private void getXML5400(Document doc) {
      ((Element)v.get(1192)).setAttribute("nombre","codUnicVentGapTdId" );
      ((Element)v.get(1192)).setAttribute("nowrap","true" );
      ((Element)v.get(1192)).setAttribute("class","datosCampos" );
      ((Element)v.get(1183)).appendChild((Element)v.get(1192));

      /* Empieza nodo:1193 / Elemento padre: 1192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1193)).setAttribute("src","b.gif" );
      ((Element)v.get(1193)).setAttribute("width","25" );
      ((Element)v.get(1193)).setAttribute("height","8" );
      ((Element)v.get(1192)).appendChild((Element)v.get(1193));
      /* Termina nodo:1193   */
      /* Termina nodo:1192   */

      /* Empieza nodo:1194 / Elemento padre: 1183   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1194)).setAttribute("width","100%" );
      ((Element)v.get(1183)).appendChild((Element)v.get(1194));

      /* Empieza nodo:1195 / Elemento padre: 1194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1195)).setAttribute("src","b.gif" );
      ((Element)v.get(1194)).appendChild((Element)v.get(1195));
      /* Termina nodo:1195   */
      /* Termina nodo:1194   */
      /* Termina nodo:1183   */
      /* Termina nodo:1182   */
      /* Termina nodo:1181   */
      /* Termina nodo:1178   */

      /* Empieza nodo:1196 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1196)).setAttribute("nombre","formGapTr43" );
      ((Element)v.get(52)).appendChild((Element)v.get(1196));

      /* Empieza nodo:1197 / Elemento padre: 1196   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1197)).setAttribute("align","center" );
      ((Element)v.get(1197)).setAttribute("width","8" );
      ((Element)v.get(1196)).appendChild((Element)v.get(1197));

      /* Empieza nodo:1198 / Elemento padre: 1197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1198)).setAttribute("src","b.gif" );
      ((Element)v.get(1198)).setAttribute("width","12" );
      ((Element)v.get(1198)).setAttribute("height","8" );
      ((Element)v.get(1197)).appendChild((Element)v.get(1198));
      /* Termina nodo:1198   */
      /* Termina nodo:1197   */

      /* Empieza nodo:1199 / Elemento padre: 1196   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1196)).appendChild((Element)v.get(1199));

      /* Empieza nodo:1200 / Elemento padre: 1199   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1200)).setAttribute("src","b.gif" );
      ((Element)v.get(1200)).setAttribute("width","8" );
      ((Element)v.get(1200)).setAttribute("height","8" );
      ((Element)v.get(1199)).appendChild((Element)v.get(1200));
      /* Termina nodo:1200   */
      /* Termina nodo:1199   */

      /* Empieza nodo:1201 / Elemento padre: 1196   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1201)).setAttribute("align","center" );
      ((Element)v.get(1201)).setAttribute("width","8" );
      ((Element)v.get(1196)).appendChild((Element)v.get(1201));

      /* Empieza nodo:1202 / Elemento padre: 1201   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1202)).setAttribute("src","b.gif" );
      ((Element)v.get(1202)).setAttribute("width","12" );
      ((Element)v.get(1202)).setAttribute("height","8" );
      ((Element)v.get(1201)).appendChild((Element)v.get(1202));
      /* Termina nodo:1202   */
      /* Termina nodo:1201   */
      /* Termina nodo:1196   */

      /* Empieza nodo:1203 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1203)).setAttribute("nombre","formTr44" );
      ((Element)v.get(52)).appendChild((Element)v.get(1203));

      /* Empieza nodo:1204 / Elemento padre: 1203   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1204)).setAttribute("align","center" );
      ((Element)v.get(1204)).setAttribute("width","8" );
      ((Element)v.get(1203)).appendChild((Element)v.get(1204));

      /* Empieza nodo:1205 / Elemento padre: 1204   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1205)).setAttribute("src","b.gif" );
      ((Element)v.get(1205)).setAttribute("width","8" );
      ((Element)v.get(1205)).setAttribute("height","12" );
      ((Element)v.get(1204)).appendChild((Element)v.get(1205));
      /* Termina nodo:1205   */
      /* Termina nodo:1204   */

      /* Empieza nodo:1206 / Elemento padre: 1203   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1206)).setAttribute("width","100%" );
      ((Element)v.get(1203)).appendChild((Element)v.get(1206));

      /* Empieza nodo:1207 / Elemento padre: 1206   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1207)).setAttribute("width","100%" );
      ((Element)v.get(1207)).setAttribute("border","0" );
      ((Element)v.get(1207)).setAttribute("cellspacing","0" );
      ((Element)v.get(1207)).setAttribute("cellpadding","0" );
      ((Element)v.get(1207)).setAttribute("align","left" );
      ((Element)v.get(1206)).appendChild((Element)v.get(1207));

      /* Empieza nodo:1208 / Elemento padre: 1207   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1208)).setAttribute("align","left" );
      ((Element)v.get(1207)).appendChild((Element)v.get(1208));

      /* Empieza nodo:1209 / Elemento padre: 1208   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1209)).setAttribute("nombre","prfiOidProgFideTdId" );
      ((Element)v.get(1208)).appendChild((Element)v.get(1209));

      /* Empieza nodo:1210 / Elemento padre: 1209   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1210)).setAttribute("border","0" );
      ((Element)v.get(1210)).setAttribute("cellspacing","0" );
      ((Element)v.get(1210)).setAttribute("cellpadding","0" );
      ((Element)v.get(1210)).setAttribute("align","left" );
      ((Element)v.get(1209)).appendChild((Element)v.get(1210));

      /* Empieza nodo:1211 / Elemento padre: 1210   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1210)).appendChild((Element)v.get(1211));

      /* Empieza nodo:1212 / Elemento padre: 1211   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1212)).setAttribute("valign","top" );
      ((Element)v.get(1212)).setAttribute("height","13" );
      ((Element)v.get(1211)).appendChild((Element)v.get(1212));

      /* Empieza nodo:1213 / Elemento padre: 1212   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(1213)).setAttribute("nombre","lblprfiOidProgFide" );
      ((Element)v.get(1213)).setAttribute("id","datosTitle" );
      ((Element)v.get(1213)).setAttribute("ancho","150" );
      ((Element)v.get(1213)).setAttribute("alto","13" );
      ((Element)v.get(1213)).setAttribute("cod","MaeProdu.prfiOidProgFide.label" );
      ((Element)v.get(1212)).appendChild((Element)v.get(1213));
      /* Termina nodo:1213   */
      /* Termina nodo:1212   */
      /* Termina nodo:1211   */

      /* Empieza nodo:1214 / Elemento padre: 1210   */
   }

   private void getXML5490(Document doc) {
      v.add(doc.createElement("TR"));
      ((Element)v.get(1214)).setAttribute("nombre","prfiOidProgFideWidgetTrId" );
      ((Element)v.get(1210)).appendChild((Element)v.get(1214));

      /* Empieza nodo:1215 / Elemento padre: 1214   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1215)).setAttribute("align","left" );
      ((Element)v.get(1215)).setAttribute("nowrap","true" );
      ((Element)v.get(1214)).appendChild((Element)v.get(1215));

      /* Empieza nodo:1216 / Elemento padre: 1215   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(1216)).setAttribute("nombre","prfiOidProgFide" );
      ((Element)v.get(1216)).setAttribute("id","datosCampos" );
      ((Element)v.get(1216)).setAttribute("multiple","N" );
      ((Element)v.get(1216)).setAttribute("req","N" );
      ((Element)v.get(1216)).setAttribute("size","1" );
      ((Element)v.get(1216)).setAttribute("disabled","" );
      ((Element)v.get(1216)).setAttribute("validacion","" );
      ((Element)v.get(1216)).setAttribute("onchange","" );
      ((Element)v.get(1216)).setAttribute("onfocus","" );
      ((Element)v.get(1216)).setAttribute("valorinicial","" );
      ((Element)v.get(1216)).setAttribute("textoinicial","" );
      ((Element)v.get(1216)).setAttribute("ontab","ejecutarAccionFoco('maeProduFrm',0, true);" );
      ((Element)v.get(1216)).setAttribute("onshtab","ejecutarAccionFoco('maeProduFrm',0, false);" );
      ((Element)v.get(1215)).appendChild((Element)v.get(1216));

      /* Empieza nodo:1217 / Elemento padre: 1216   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(1216)).appendChild((Element)v.get(1217));
      /* Termina nodo:1217   */
      /* Termina nodo:1216   */
      /* Termina nodo:1215   */
      /* Termina nodo:1214   */
      /* Termina nodo:1210   */
      /* Termina nodo:1209   */

      /* Empieza nodo:1218 / Elemento padre: 1208   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1218)).setAttribute("nombre","prfiOidProgFideGapTdId" );
      ((Element)v.get(1218)).setAttribute("nowrap","true" );
      ((Element)v.get(1218)).setAttribute("class","datosCampos" );
      ((Element)v.get(1208)).appendChild((Element)v.get(1218));

      /* Empieza nodo:1219 / Elemento padre: 1218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1219)).setAttribute("src","b.gif" );
      ((Element)v.get(1219)).setAttribute("width","25" );
      ((Element)v.get(1219)).setAttribute("height","8" );
      ((Element)v.get(1218)).appendChild((Element)v.get(1219));
      /* Termina nodo:1219   */
      /* Termina nodo:1218   */

      /* Empieza nodo:1220 / Elemento padre: 1208   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1220)).setAttribute("width","100%" );
      ((Element)v.get(1208)).appendChild((Element)v.get(1220));

      /* Empieza nodo:1221 / Elemento padre: 1220   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1221)).setAttribute("src","b.gif" );
      ((Element)v.get(1220)).appendChild((Element)v.get(1221));
      /* Termina nodo:1221   */
      /* Termina nodo:1220   */
      /* Termina nodo:1208   */
      /* Termina nodo:1207   */
      /* Termina nodo:1206   */

      /* Empieza nodo:1222 / Elemento padre: 1203   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1222)).setAttribute("width","100%" );
      ((Element)v.get(1203)).appendChild((Element)v.get(1222));
      /* Termina nodo:1222   */
      /* Termina nodo:1203   */

      /* Empieza nodo:1223 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1223)).setAttribute("nombre","formGapTr44" );
      ((Element)v.get(52)).appendChild((Element)v.get(1223));

      /* Empieza nodo:1224 / Elemento padre: 1223   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1224)).setAttribute("align","center" );
      ((Element)v.get(1224)).setAttribute("width","8" );
      ((Element)v.get(1223)).appendChild((Element)v.get(1224));

      /* Empieza nodo:1225 / Elemento padre: 1224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1225)).setAttribute("src","b.gif" );
      ((Element)v.get(1225)).setAttribute("width","8" );
      ((Element)v.get(1225)).setAttribute("height","8" );
      ((Element)v.get(1224)).appendChild((Element)v.get(1225));
      /* Termina nodo:1225   */
      /* Termina nodo:1224   */

      /* Empieza nodo:1226 / Elemento padre: 1223   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1223)).appendChild((Element)v.get(1226));

      /* Empieza nodo:1227 / Elemento padre: 1226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1227)).setAttribute("src","b.gif" );
      ((Element)v.get(1227)).setAttribute("width","8" );
      ((Element)v.get(1227)).setAttribute("height","8" );
      ((Element)v.get(1226)).appendChild((Element)v.get(1227));
      /* Termina nodo:1227   */
      /* Termina nodo:1226   */

      /* Empieza nodo:1228 / Elemento padre: 1223   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1228)).setAttribute("align","center" );
      ((Element)v.get(1228)).setAttribute("width","8" );
      ((Element)v.get(1223)).appendChild((Element)v.get(1228));

      /* Empieza nodo:1229 / Elemento padre: 1228   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1229)).setAttribute("src","b.gif" );
      ((Element)v.get(1229)).setAttribute("width","8" );
      ((Element)v.get(1229)).setAttribute("height","8" );
      ((Element)v.get(1228)).appendChild((Element)v.get(1229));
      /* Termina nodo:1229   */
      /* Termina nodo:1228   */
      /* Termina nodo:1223   */
      /* Termina nodo:52   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:1230 / Elemento padre: 45   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1230)).setAttribute("align","center" );
      ((Element)v.get(1230)).setAttribute("width","12" );
      ((Element)v.get(45)).appendChild((Element)v.get(1230));

      /* Empieza nodo:1231 / Elemento padre: 1230   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1231)).setAttribute("src","b.gif" );
      ((Element)v.get(1231)).setAttribute("width","12" );
      ((Element)v.get(1231)).setAttribute("height","12" );
      ((Element)v.get(1230)).appendChild((Element)v.get(1231));
      /* Termina nodo:1231   */
      /* Termina nodo:1230   */
      /* Termina nodo:45   */

      /* Empieza nodo:1232 / Elemento padre: 37   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1232)).setAttribute("nombre","maeProduTrButtons" );
      ((Element)v.get(37)).appendChild((Element)v.get(1232));

      /* Empieza nodo:1233 / Elemento padre: 1232   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1233)).setAttribute("align","center" );
      ((Element)v.get(1233)).setAttribute("width","12" );
      ((Element)v.get(1232)).appendChild((Element)v.get(1233));

      /* Empieza nodo:1234 / Elemento padre: 1233   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1234)).setAttribute("src","b.gif" );
      ((Element)v.get(1234)).setAttribute("width","12" );
   }

   private void getXML5580(Document doc) {
      ((Element)v.get(1234)).setAttribute("height","12" );
      ((Element)v.get(1233)).appendChild((Element)v.get(1234));
      /* Termina nodo:1234   */
      /* Termina nodo:1233   */

      /* Empieza nodo:1235 / Elemento padre: 1232   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1232)).appendChild((Element)v.get(1235));

      /* Empieza nodo:1236 / Elemento padre: 1235   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(1235)).appendChild((Element)v.get(1236));

      /* Empieza nodo:1237 / Elemento padre: 1236   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1237)).setAttribute("width","100%" );
      ((Element)v.get(1237)).setAttribute("border","0" );
      ((Element)v.get(1237)).setAttribute("align","center" );
      ((Element)v.get(1237)).setAttribute("cellspacing","0" );
      ((Element)v.get(1237)).setAttribute("cellpadding","0" );
      ((Element)v.get(1236)).appendChild((Element)v.get(1237));

      /* Empieza nodo:1238 / Elemento padre: 1237   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(1237)).appendChild((Element)v.get(1238));

      /* Empieza nodo:1239 / Elemento padre: 1238   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1239)).setAttribute("class","tablaTitle" );
      ((Element)v.get(1239)).setAttribute("nombre","maeProduTdQueryButton" );
      ((Element)v.get(1238)).appendChild((Element)v.get(1239));

      /* Empieza nodo:1240 / Elemento padre: 1239   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1240)).setAttribute("nombre","maeProduQueryButton" );
      ((Element)v.get(1240)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(1240)).setAttribute("estado","false" );
      ((Element)v.get(1240)).setAttribute("accion","maeProduFirstPage();" );
      ((Element)v.get(1240)).setAttribute("tipo","html" );
      ((Element)v.get(1240)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1239)).appendChild((Element)v.get(1240));
      /* Termina nodo:1240   */
      /* Termina nodo:1239   */

      /* Empieza nodo:1241 / Elemento padre: 1238   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1241)).setAttribute("class","tablaTitle" );
      ((Element)v.get(1241)).setAttribute("nombre","maeProduTdLovNullSelectionButton" );
      ((Element)v.get(1241)).setAttribute("align","left" );
      ((Element)v.get(1241)).setAttribute("width","100%" );
      ((Element)v.get(1238)).appendChild((Element)v.get(1241));

      /* Empieza nodo:1242 / Elemento padre: 1241   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1242)).setAttribute("src","b.gif" );
      ((Element)v.get(1242)).setAttribute("height","8" );
      ((Element)v.get(1242)).setAttribute("width","8" );
      ((Element)v.get(1241)).appendChild((Element)v.get(1242));
      /* Termina nodo:1242   */

      /* Empieza nodo:1243 / Elemento padre: 1241   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1243)).setAttribute("nombre","maeProduLovNullButton" );
      ((Element)v.get(1243)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1243)).setAttribute("tipo","html" );
      ((Element)v.get(1243)).setAttribute("accion","maeProduLovNullSelectionAction();" );
      ((Element)v.get(1243)).setAttribute("estado","true" );
      ((Element)v.get(1243)).setAttribute("cod","MMGGlobal.lovNullButton.label" );
      ((Element)v.get(1241)).appendChild((Element)v.get(1243));
      /* Termina nodo:1243   */
      /* Termina nodo:1241   */
      /* Termina nodo:1238   */
      /* Termina nodo:1237   */
      /* Termina nodo:1236   */
      /* Termina nodo:1235   */

      /* Empieza nodo:1244 / Elemento padre: 1232   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1244)).setAttribute("align","center" );
      ((Element)v.get(1244)).setAttribute("width","12" );
      ((Element)v.get(1232)).appendChild((Element)v.get(1244));

      /* Empieza nodo:1245 / Elemento padre: 1244   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1245)).setAttribute("src","b.gif" );
      ((Element)v.get(1245)).setAttribute("width","12" );
      ((Element)v.get(1245)).setAttribute("height","12" );
      ((Element)v.get(1244)).appendChild((Element)v.get(1245));
      /* Termina nodo:1245   */
      /* Termina nodo:1244   */
      /* Termina nodo:1232   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:1246 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(1246)).setAttribute("nombre","maeProduListLayer" );
      ((Element)v.get(1246)).setAttribute("alto","310" );
      ((Element)v.get(1246)).setAttribute("ancho","99%" );
      ((Element)v.get(1246)).setAttribute("colorf","" );
      ((Element)v.get(1246)).setAttribute("borde","0" );
      ((Element)v.get(1246)).setAttribute("imagenf","" );
      ((Element)v.get(1246)).setAttribute("repeat","" );
      ((Element)v.get(1246)).setAttribute("padding","" );
      ((Element)v.get(1246)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(1246)).setAttribute("contravsb","" );
      ((Element)v.get(1246)).setAttribute("x","3" );
      ((Element)v.get(1246)).setAttribute("y","" );
      ((Element)v.get(1246)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(1246));

      /* Empieza nodo:1247 / Elemento padre: 1246   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(1247)).setAttribute("nombre","maeProduList" );
      ((Element)v.get(1247)).setAttribute("ancho","680" );
      ((Element)v.get(1247)).setAttribute("alto","275" );
      ((Element)v.get(1247)).setAttribute("x","12" );
      ((Element)v.get(1247)).setAttribute("y","0" );
      ((Element)v.get(1247)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(1247)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(1246)).appendChild((Element)v.get(1247));

      /* Empieza nodo:1248 / Elemento padre: 1247   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(1248)).setAttribute("precarga","S" );
      ((Element)v.get(1248)).setAttribute("conROver","S" );
      ((Element)v.get(1247)).appendChild((Element)v.get(1248));

      /* Empieza nodo:1249 / Elemento padre: 1248   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(1249)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(1249)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(1249)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(1249)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(1248)).appendChild((Element)v.get(1249));
      /* Termina nodo:1249   */

      /* Empieza nodo:1250 / Elemento padre: 1248   */
      v.add(doc.createElement("BTNMINIMIZAR"));
   }

   private void getXML5670(Document doc) {
      ((Element)v.get(1250)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(1250)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(1250)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(1250)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(1248)).appendChild((Element)v.get(1250));
      /* Termina nodo:1250   */
      /* Termina nodo:1248   */

      /* Empieza nodo:1251 / Elemento padre: 1247   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(1247)).appendChild((Element)v.get(1251));

      /* Empieza nodo:1252 / Elemento padre: 1251   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(1252)).setAttribute("borde","1" );
      ((Element)v.get(1252)).setAttribute("horizDatos","1" );
      ((Element)v.get(1252)).setAttribute("horizCabecera","1" );
      ((Element)v.get(1252)).setAttribute("vertical","1" );
      ((Element)v.get(1252)).setAttribute("horizTitulo","1" );
      ((Element)v.get(1252)).setAttribute("horizBase","1" );
      ((Element)v.get(1251)).appendChild((Element)v.get(1252));
      /* Termina nodo:1252   */

      /* Empieza nodo:1253 / Elemento padre: 1251   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(1253)).setAttribute("borde","#999999" );
      ((Element)v.get(1253)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(1253)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(1253)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(1253)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(1253)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(1253)).setAttribute("horizBase","#999999" );
      ((Element)v.get(1251)).appendChild((Element)v.get(1253));
      /* Termina nodo:1253   */
      /* Termina nodo:1251   */

      /* Empieza nodo:1254 / Elemento padre: 1247   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(1254)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(1254)).setAttribute("alto","22" );
      ((Element)v.get(1254)).setAttribute("imgFondo","" );
      ((Element)v.get(1254)).setAttribute("cod","00135" );
      ((Element)v.get(1254)).setAttribute("ID","datosTitle" );
      ((Element)v.get(1247)).appendChild((Element)v.get(1254));
      /* Termina nodo:1254   */

      /* Empieza nodo:1255 / Elemento padre: 1247   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(1255)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(1255)).setAttribute("alto","22" );
      ((Element)v.get(1255)).setAttribute("imgFondo","" );
      ((Element)v.get(1247)).appendChild((Element)v.get(1255));
      /* Termina nodo:1255   */

      /* Empieza nodo:1256 / Elemento padre: 1247   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(1256)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(1256)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(1256)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(1256)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(1256)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(1247)).appendChild((Element)v.get(1256));

      /* Empieza nodo:1257 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1257)).setAttribute("ancho","100" );
      ((Element)v.get(1257)).setAttribute("minimizable","S" );
      ((Element)v.get(1257)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1257));
      /* Termina nodo:1257   */

      /* Empieza nodo:1258 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1258)).setAttribute("ancho","100" );
      ((Element)v.get(1258)).setAttribute("minimizable","S" );
      ((Element)v.get(1258)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1258));
      /* Termina nodo:1258   */

      /* Empieza nodo:1259 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1259)).setAttribute("ancho","100" );
      ((Element)v.get(1259)).setAttribute("minimizable","S" );
      ((Element)v.get(1259)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1259));
      /* Termina nodo:1259   */

      /* Empieza nodo:1260 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1260)).setAttribute("ancho","100" );
      ((Element)v.get(1260)).setAttribute("minimizable","S" );
      ((Element)v.get(1260)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1260));
      /* Termina nodo:1260   */

      /* Empieza nodo:1261 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1261)).setAttribute("ancho","100" );
      ((Element)v.get(1261)).setAttribute("minimizable","S" );
      ((Element)v.get(1261)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1261));
      /* Termina nodo:1261   */

      /* Empieza nodo:1262 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1262)).setAttribute("ancho","100" );
      ((Element)v.get(1262)).setAttribute("minimizable","S" );
      ((Element)v.get(1262)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1262));
      /* Termina nodo:1262   */

      /* Empieza nodo:1263 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1263)).setAttribute("ancho","100" );
      ((Element)v.get(1263)).setAttribute("minimizable","S" );
      ((Element)v.get(1263)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1263));
      /* Termina nodo:1263   */

      /* Empieza nodo:1264 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1264)).setAttribute("ancho","100" );
      ((Element)v.get(1264)).setAttribute("minimizable","S" );
      ((Element)v.get(1264)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1264));
      /* Termina nodo:1264   */

      /* Empieza nodo:1265 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1265)).setAttribute("ancho","100" );
      ((Element)v.get(1265)).setAttribute("minimizable","S" );
      ((Element)v.get(1265)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1265));
      /* Termina nodo:1265   */

      /* Empieza nodo:1266 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1266)).setAttribute("ancho","100" );
   }

   private void getXML5760(Document doc) {
      ((Element)v.get(1266)).setAttribute("minimizable","S" );
      ((Element)v.get(1266)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1266));
      /* Termina nodo:1266   */

      /* Empieza nodo:1267 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1267)).setAttribute("ancho","100" );
      ((Element)v.get(1267)).setAttribute("minimizable","S" );
      ((Element)v.get(1267)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1267));
      /* Termina nodo:1267   */

      /* Empieza nodo:1268 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1268)).setAttribute("ancho","100" );
      ((Element)v.get(1268)).setAttribute("minimizable","S" );
      ((Element)v.get(1268)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1268));
      /* Termina nodo:1268   */

      /* Empieza nodo:1269 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1269)).setAttribute("ancho","100" );
      ((Element)v.get(1269)).setAttribute("minimizable","S" );
      ((Element)v.get(1269)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1269));
      /* Termina nodo:1269   */

      /* Empieza nodo:1270 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1270)).setAttribute("ancho","100" );
      ((Element)v.get(1270)).setAttribute("minimizable","S" );
      ((Element)v.get(1270)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1270));
      /* Termina nodo:1270   */

      /* Empieza nodo:1271 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1271)).setAttribute("ancho","100" );
      ((Element)v.get(1271)).setAttribute("minimizable","S" );
      ((Element)v.get(1271)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1271));
      /* Termina nodo:1271   */

      /* Empieza nodo:1272 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1272)).setAttribute("ancho","100" );
      ((Element)v.get(1272)).setAttribute("minimizable","S" );
      ((Element)v.get(1272)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1272));
      /* Termina nodo:1272   */

      /* Empieza nodo:1273 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1273)).setAttribute("ancho","100" );
      ((Element)v.get(1273)).setAttribute("minimizable","S" );
      ((Element)v.get(1273)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1273));
      /* Termina nodo:1273   */

      /* Empieza nodo:1274 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1274)).setAttribute("ancho","100" );
      ((Element)v.get(1274)).setAttribute("minimizable","S" );
      ((Element)v.get(1274)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1274));
      /* Termina nodo:1274   */

      /* Empieza nodo:1275 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1275)).setAttribute("ancho","100" );
      ((Element)v.get(1275)).setAttribute("minimizable","S" );
      ((Element)v.get(1275)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1275));
      /* Termina nodo:1275   */

      /* Empieza nodo:1276 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1276)).setAttribute("ancho","100" );
      ((Element)v.get(1276)).setAttribute("minimizable","S" );
      ((Element)v.get(1276)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1276));
      /* Termina nodo:1276   */

      /* Empieza nodo:1277 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1277)).setAttribute("ancho","100" );
      ((Element)v.get(1277)).setAttribute("minimizable","S" );
      ((Element)v.get(1277)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1277));
      /* Termina nodo:1277   */

      /* Empieza nodo:1278 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1278)).setAttribute("ancho","100" );
      ((Element)v.get(1278)).setAttribute("minimizable","S" );
      ((Element)v.get(1278)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1278));
      /* Termina nodo:1278   */

      /* Empieza nodo:1279 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1279)).setAttribute("ancho","100" );
      ((Element)v.get(1279)).setAttribute("minimizable","S" );
      ((Element)v.get(1279)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1279));
      /* Termina nodo:1279   */

      /* Empieza nodo:1280 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1280)).setAttribute("ancho","100" );
      ((Element)v.get(1280)).setAttribute("minimizable","S" );
      ((Element)v.get(1280)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1280));
      /* Termina nodo:1280   */

      /* Empieza nodo:1281 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1281)).setAttribute("ancho","100" );
      ((Element)v.get(1281)).setAttribute("minimizable","S" );
      ((Element)v.get(1281)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1281));
      /* Termina nodo:1281   */

      /* Empieza nodo:1282 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1282)).setAttribute("ancho","100" );
      ((Element)v.get(1282)).setAttribute("minimizable","S" );
      ((Element)v.get(1282)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1282));
      /* Termina nodo:1282   */

      /* Empieza nodo:1283 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1283)).setAttribute("ancho","100" );
      ((Element)v.get(1283)).setAttribute("minimizable","S" );
      ((Element)v.get(1283)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1283));
      /* Termina nodo:1283   */

      /* Empieza nodo:1284 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1284)).setAttribute("ancho","100" );
   }

   private void getXML5850(Document doc) {
      ((Element)v.get(1284)).setAttribute("minimizable","S" );
      ((Element)v.get(1284)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1284));
      /* Termina nodo:1284   */

      /* Empieza nodo:1285 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1285)).setAttribute("ancho","100" );
      ((Element)v.get(1285)).setAttribute("minimizable","S" );
      ((Element)v.get(1285)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1285));
      /* Termina nodo:1285   */

      /* Empieza nodo:1286 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1286)).setAttribute("ancho","100" );
      ((Element)v.get(1286)).setAttribute("minimizable","S" );
      ((Element)v.get(1286)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1286));
      /* Termina nodo:1286   */

      /* Empieza nodo:1287 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1287)).setAttribute("ancho","100" );
      ((Element)v.get(1287)).setAttribute("minimizable","S" );
      ((Element)v.get(1287)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1287));
      /* Termina nodo:1287   */

      /* Empieza nodo:1288 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1288)).setAttribute("ancho","100" );
      ((Element)v.get(1288)).setAttribute("minimizable","S" );
      ((Element)v.get(1288)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1288));
      /* Termina nodo:1288   */

      /* Empieza nodo:1289 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1289)).setAttribute("ancho","100" );
      ((Element)v.get(1289)).setAttribute("minimizable","S" );
      ((Element)v.get(1289)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1289));
      /* Termina nodo:1289   */

      /* Empieza nodo:1290 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1290)).setAttribute("ancho","100" );
      ((Element)v.get(1290)).setAttribute("minimizable","S" );
      ((Element)v.get(1290)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1290));
      /* Termina nodo:1290   */

      /* Empieza nodo:1291 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1291)).setAttribute("ancho","100" );
      ((Element)v.get(1291)).setAttribute("minimizable","S" );
      ((Element)v.get(1291)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1291));
      /* Termina nodo:1291   */

      /* Empieza nodo:1292 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1292)).setAttribute("ancho","100" );
      ((Element)v.get(1292)).setAttribute("minimizable","S" );
      ((Element)v.get(1292)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1292));
      /* Termina nodo:1292   */

      /* Empieza nodo:1293 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1293)).setAttribute("ancho","100" );
      ((Element)v.get(1293)).setAttribute("minimizable","S" );
      ((Element)v.get(1293)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1293));
      /* Termina nodo:1293   */

      /* Empieza nodo:1294 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1294)).setAttribute("ancho","100" );
      ((Element)v.get(1294)).setAttribute("minimizable","S" );
      ((Element)v.get(1294)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1294));
      /* Termina nodo:1294   */

      /* Empieza nodo:1295 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1295)).setAttribute("ancho","100" );
      ((Element)v.get(1295)).setAttribute("minimizable","S" );
      ((Element)v.get(1295)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1295));
      /* Termina nodo:1295   */

      /* Empieza nodo:1296 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1296)).setAttribute("ancho","100" );
      ((Element)v.get(1296)).setAttribute("minimizable","S" );
      ((Element)v.get(1296)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1296));
      /* Termina nodo:1296   */

      /* Empieza nodo:1297 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1297)).setAttribute("ancho","100" );
      ((Element)v.get(1297)).setAttribute("minimizable","S" );
      ((Element)v.get(1297)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1297));
      /* Termina nodo:1297   */

      /* Empieza nodo:1298 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1298)).setAttribute("ancho","100" );
      ((Element)v.get(1298)).setAttribute("minimizable","S" );
      ((Element)v.get(1298)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1298));
      /* Termina nodo:1298   */

      /* Empieza nodo:1299 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1299)).setAttribute("ancho","100" );
      ((Element)v.get(1299)).setAttribute("minimizable","S" );
      ((Element)v.get(1299)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1299));
      /* Termina nodo:1299   */

      /* Empieza nodo:1300 / Elemento padre: 1256   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1300)).setAttribute("ancho","100" );
      ((Element)v.get(1300)).setAttribute("minimizable","S" );
      ((Element)v.get(1300)).setAttribute("minimizada","N" );
      ((Element)v.get(1256)).appendChild((Element)v.get(1300));
      /* Termina nodo:1300   */
      /* Termina nodo:1256   */

      /* Empieza nodo:1301 / Elemento padre: 1247   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(1301)).setAttribute("height","20" );
      ((Element)v.get(1301)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(1301)).setAttribute("imgFondo","" );
      ((Element)v.get(1301)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(1247)).appendChild((Element)v.get(1301));

      /* Empieza nodo:1302 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
   }

   private void getXML5940(Document doc) {
      ((Element)v.get(1302)).setAttribute("colFondo","" );
      ((Element)v.get(1302)).setAttribute("ID","EstCab" );
      ((Element)v.get(1302)).setAttribute("cod","MaeProdu.paisOidPais.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1302));
      /* Termina nodo:1302   */

      /* Empieza nodo:1303 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1303)).setAttribute("colFondo","" );
      ((Element)v.get(1303)).setAttribute("ID","EstCab" );
      ((Element)v.get(1303)).setAttribute("cod","MaeProdu.codSap.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1303));
      /* Termina nodo:1303   */

      /* Empieza nodo:1304 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1304)).setAttribute("colFondo","" );
      ((Element)v.get(1304)).setAttribute("ID","EstCab" );
      ((Element)v.get(1304)).setAttribute("cod","MaeProdu.codiAnti.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1304));
      /* Termina nodo:1304   */

      /* Empieza nodo:1305 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1305)).setAttribute("colFondo","" );
      ((Element)v.get(1305)).setAttribute("ID","EstCab" );
      ((Element)v.get(1305)).setAttribute("cod","MaeProdu.desCort.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1305));
      /* Termina nodo:1305   */

      /* Empieza nodo:1306 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1306)).setAttribute("colFondo","" );
      ((Element)v.get(1306)).setAttribute("ID","EstCab" );
      ((Element)v.get(1306)).setAttribute("cod","MaeProdu.valJera1.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1306));
      /* Termina nodo:1306   */

      /* Empieza nodo:1307 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1307)).setAttribute("colFondo","" );
      ((Element)v.get(1307)).setAttribute("ID","EstCab" );
      ((Element)v.get(1307)).setAttribute("cod","MaeProdu.valJera2.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1307));
      /* Termina nodo:1307   */

      /* Empieza nodo:1308 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1308)).setAttribute("colFondo","" );
      ((Element)v.get(1308)).setAttribute("ID","EstCab" );
      ((Element)v.get(1308)).setAttribute("cod","MaeProdu.valJera3.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1308));
      /* Termina nodo:1308   */

      /* Empieza nodo:1309 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1309)).setAttribute("colFondo","" );
      ((Element)v.get(1309)).setAttribute("ID","EstCab" );
      ((Element)v.get(1309)).setAttribute("cod","MaeProdu.valAtri1.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1309));
      /* Termina nodo:1309   */

      /* Empieza nodo:1310 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1310)).setAttribute("colFondo","" );
      ((Element)v.get(1310)).setAttribute("ID","EstCab" );
      ((Element)v.get(1310)).setAttribute("cod","MaeProdu.valAtri2.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1310));
      /* Termina nodo:1310   */

      /* Empieza nodo:1311 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1311)).setAttribute("colFondo","" );
      ((Element)v.get(1311)).setAttribute("ID","EstCab" );
      ((Element)v.get(1311)).setAttribute("cod","MaeProdu.valAtri3.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1311));
      /* Termina nodo:1311   */

      /* Empieza nodo:1312 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1312)).setAttribute("colFondo","" );
      ((Element)v.get(1312)).setAttribute("ID","EstCab" );
      ((Element)v.get(1312)).setAttribute("cod","MaeProdu.valDimeAlto.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1312));
      /* Termina nodo:1312   */

      /* Empieza nodo:1313 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1313)).setAttribute("colFondo","" );
      ((Element)v.get(1313)).setAttribute("ID","EstCab" );
      ((Element)v.get(1313)).setAttribute("cod","MaeProdu.valDimeLarg.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1313));
      /* Termina nodo:1313   */

      /* Empieza nodo:1314 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1314)).setAttribute("colFondo","" );
      ((Element)v.get(1314)).setAttribute("ID","EstCab" );
      ((Element)v.get(1314)).setAttribute("cod","MaeProdu.valDimeAnch.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1314));
      /* Termina nodo:1314   */

      /* Empieza nodo:1315 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1315)).setAttribute("colFondo","" );
      ((Element)v.get(1315)).setAttribute("ID","EstCab" );
      ((Element)v.get(1315)).setAttribute("cod","MaeProdu.valPeso.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1315));
      /* Termina nodo:1315   */

      /* Empieza nodo:1316 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1316)).setAttribute("colFondo","" );
      ((Element)v.get(1316)).setAttribute("ID","EstCab" );
      ((Element)v.get(1316)).setAttribute("cod","MaeProdu.valVolu.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1316));
      /* Termina nodo:1316   */

      /* Empieza nodo:1317 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1317)).setAttribute("colFondo","" );
      ((Element)v.get(1317)).setAttribute("ID","EstCab" );
      ((Element)v.get(1317)).setAttribute("cod","MaeProdu.valCostEstd.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1317));
      /* Termina nodo:1317   */

      /* Empieza nodo:1318 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1318)).setAttribute("colFondo","" );
      ((Element)v.get(1318)).setAttribute("ID","EstCab" );
      ((Element)v.get(1318)).setAttribute("cod","MaeProdu.valPrecPosi.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1318));
      /* Termina nodo:1318   */

      /* Empieza nodo:1319 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1319)).setAttribute("colFondo","" );
      ((Element)v.get(1319)).setAttribute("ID","EstCab" );
      ((Element)v.get(1319)).setAttribute("cod","MaeProdu.valPrecCata.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1319));
      /* Termina nodo:1319   */

      /* Empieza nodo:1320 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
   }

   private void getXML6030(Document doc) {
      ((Element)v.get(1320)).setAttribute("colFondo","" );
      ((Element)v.get(1320)).setAttribute("ID","EstCab" );
      ((Element)v.get(1320)).setAttribute("cod","MaeProdu.valPrecCont.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1320));
      /* Termina nodo:1320   */

      /* Empieza nodo:1321 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1321)).setAttribute("colFondo","" );
      ((Element)v.get(1321)).setAttribute("ID","EstCab" );
      ((Element)v.get(1321)).setAttribute("cod","MaeProdu.numUnidDentPedi.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1321));
      /* Termina nodo:1321   */

      /* Empieza nodo:1322 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1322)).setAttribute("colFondo","" );
      ((Element)v.get(1322)).setAttribute("ID","EstCab" );
      ((Element)v.get(1322)).setAttribute("cod","MaeProdu.numUnidCaja.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1322));
      /* Termina nodo:1322   */

      /* Empieza nodo:1323 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1323)).setAttribute("colFondo","" );
      ((Element)v.get(1323)).setAttribute("ID","EstCab" );
      ((Element)v.get(1323)).setAttribute("cod","MaeProdu.codImpu.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1323));
      /* Termina nodo:1323   */

      /* Empieza nodo:1324 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1324)).setAttribute("colFondo","" );
      ((Element)v.get(1324)).setAttribute("ID","EstCab" );
      ((Element)v.get(1324)).setAttribute("cod","MaeProdu.pctUnid.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1324));
      /* Termina nodo:1324   */

      /* Empieza nodo:1325 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1325)).setAttribute("colFondo","" );
      ((Element)v.get(1325)).setAttribute("ID","EstCab" );
      ((Element)v.get(1325)).setAttribute("cod","MaeProdu.geneOidGene.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1325));
      /* Termina nodo:1325   */

      /* Empieza nodo:1326 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1326)).setAttribute("colFondo","" );
      ((Element)v.get(1326)).setAttribute("ID","EstCab" );
      ((Element)v.get(1326)).setAttribute("cod","MaeProdu.sgenOidSupeGene.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1326));
      /* Termina nodo:1326   */

      /* Empieza nodo:1327 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1327)).setAttribute("colFondo","" );
      ((Element)v.get(1327)).setAttribute("ID","EstCab" );
      ((Element)v.get(1327)).setAttribute("cod","MaeProdu.unmdOidUnidMedi.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1327));
      /* Termina nodo:1327   */

      /* Empieza nodo:1328 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1328)).setAttribute("colFondo","" );
      ((Element)v.get(1328)).setAttribute("ID","EstCab" );
      ((Element)v.get(1328)).setAttribute("cod","MaeProdu.unmdOidUnidMediPeso.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1328));
      /* Termina nodo:1328   */

      /* Empieza nodo:1329 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1329)).setAttribute("colFondo","" );
      ((Element)v.get(1329)).setAttribute("ID","EstCab" );
      ((Element)v.get(1329)).setAttribute("cod","MaeProdu.unmdOidUnidMediDime.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1329));
      /* Termina nodo:1329   */

      /* Empieza nodo:1330 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1330)).setAttribute("colFondo","" );
      ((Element)v.get(1330)).setAttribute("ID","EstCab" );
      ((Element)v.get(1330)).setAttribute("cod","MaeProdu.negoOidNego.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1330));
      /* Termina nodo:1330   */

      /* Empieza nodo:1331 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1331)).setAttribute("colFondo","" );
      ((Element)v.get(1331)).setAttribute("ID","EstCab" );
      ((Element)v.get(1331)).setAttribute("cod","MaeProdu.meudOidEstaProd.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1331));
      /* Termina nodo:1331   */

      /* Empieza nodo:1332 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1332)).setAttribute("colFondo","" );
      ((Element)v.get(1332)).setAttribute("ID","EstCab" );
      ((Element)v.get(1332)).setAttribute("cod","MaeProdu.liprOidLineProd.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1332));
      /* Termina nodo:1332   */

      /* Empieza nodo:1333 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1333)).setAttribute("colFondo","" );
      ((Element)v.get(1333)).setAttribute("ID","EstCab" );
      ((Element)v.get(1333)).setAttribute("cod","MaeProdu.unegOidUnidNego.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1333));
      /* Termina nodo:1333   */

      /* Empieza nodo:1334 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1334)).setAttribute("colFondo","" );
      ((Element)v.get(1334)).setAttribute("ID","EstCab" );
      ((Element)v.get(1334)).setAttribute("cod","MaeProdu.perdOidPeriInic.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1334));
      /* Termina nodo:1334   */

      /* Empieza nodo:1335 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1335)).setAttribute("colFondo","" );
      ((Element)v.get(1335)).setAttribute("ID","EstCab" );
      ((Element)v.get(1335)).setAttribute("cod","MaeProdu.perdOidPeriFin.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1335));
      /* Termina nodo:1335   */

      /* Empieza nodo:1336 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1336)).setAttribute("colFondo","" );
      ((Element)v.get(1336)).setAttribute("ID","EstCab" );
      ((Element)v.get(1336)).setAttribute("cod","MaeProdu.indLote.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1336));
      /* Termina nodo:1336   */

      /* Empieza nodo:1337 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1337)).setAttribute("colFondo","" );
      ((Element)v.get(1337)).setAttribute("ID","EstCab" );
      ((Element)v.get(1337)).setAttribute("cod","MaeProdu.indProdServ.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1337));
      /* Termina nodo:1337   */

      /* Empieza nodo:1338 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
   }

   private void getXML6120(Document doc) {
      ((Element)v.get(1338)).setAttribute("colFondo","" );
      ((Element)v.get(1338)).setAttribute("ID","EstCab" );
      ((Element)v.get(1338)).setAttribute("cod","MaeProdu.codIndSitu.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1338));
      /* Termina nodo:1338   */

      /* Empieza nodo:1339 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1339)).setAttribute("colFondo","" );
      ((Element)v.get(1339)).setAttribute("ID","EstCab" );
      ((Element)v.get(1339)).setAttribute("cod","MaeProdu.codIndDentCaja.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1339));
      /* Termina nodo:1339   */

      /* Empieza nodo:1340 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1340)).setAttribute("colFondo","" );
      ((Element)v.get(1340)).setAttribute("ID","EstCab" );
      ((Element)v.get(1340)).setAttribute("cod","MaeProdu.indKit.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1340));
      /* Termina nodo:1340   */

      /* Empieza nodo:1341 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1341)).setAttribute("colFondo","" );
      ((Element)v.get(1341)).setAttribute("ID","EstCab" );
      ((Element)v.get(1341)).setAttribute("cod","MaeProdu.fopaOidFormPago.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1341));
      /* Termina nodo:1341   */

      /* Empieza nodo:1342 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1342)).setAttribute("colFondo","" );
      ((Element)v.get(1342)).setAttribute("ID","EstCab" );
      ((Element)v.get(1342)).setAttribute("cod","MaeProdu.maprOidMarcProd.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1342));
      /* Termina nodo:1342   */

      /* Empieza nodo:1343 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1343)).setAttribute("colFondo","" );
      ((Element)v.get(1343)).setAttribute("ID","EstCab" );
      ((Element)v.get(1343)).setAttribute("cod","MaeProdu.valGrupArti.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1343));
      /* Termina nodo:1343   */

      /* Empieza nodo:1344 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1344)).setAttribute("colFondo","" );
      ((Element)v.get(1344)).setAttribute("ID","EstCab" );
      ((Element)v.get(1344)).setAttribute("cod","MaeProdu.codUnicVent.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1344));
      /* Termina nodo:1344   */

      /* Empieza nodo:1345 / Elemento padre: 1301   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1345)).setAttribute("colFondo","" );
      ((Element)v.get(1345)).setAttribute("ID","EstCab" );
      ((Element)v.get(1345)).setAttribute("cod","MaeProdu.prfiOidProgFide.label" );
      ((Element)v.get(1301)).appendChild((Element)v.get(1345));
      /* Termina nodo:1345   */
      /* Termina nodo:1301   */

      /* Empieza nodo:1346 / Elemento padre: 1247   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(1346)).setAttribute("alto","22" );
      ((Element)v.get(1346)).setAttribute("accion","" );
      ((Element)v.get(1346)).setAttribute("tipoEnvio","seleccion" );
      ((Element)v.get(1346)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(1346)).setAttribute("maxSel","1" );
      ((Element)v.get(1346)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(1346)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(1346)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(1346)).setAttribute("onLoad","" );
      ((Element)v.get(1346)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(1247)).appendChild((Element)v.get(1346));

      /* Empieza nodo:1347 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1347)).setAttribute("tipo","texto" );
      ((Element)v.get(1347)).setAttribute("ID","EstDat" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1347));
      /* Termina nodo:1347   */

      /* Empieza nodo:1348 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1348)).setAttribute("tipo","texto" );
      ((Element)v.get(1348)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1348));
      /* Termina nodo:1348   */

      /* Empieza nodo:1349 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1349)).setAttribute("tipo","texto" );
      ((Element)v.get(1349)).setAttribute("ID","EstDat" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1349));
      /* Termina nodo:1349   */

      /* Empieza nodo:1350 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1350)).setAttribute("tipo","texto" );
      ((Element)v.get(1350)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1350));
      /* Termina nodo:1350   */

      /* Empieza nodo:1351 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1351)).setAttribute("tipo","texto" );
      ((Element)v.get(1351)).setAttribute("ID","EstDat" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1351));
      /* Termina nodo:1351   */

      /* Empieza nodo:1352 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1352)).setAttribute("tipo","texto" );
      ((Element)v.get(1352)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1352));
      /* Termina nodo:1352   */

      /* Empieza nodo:1353 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1353)).setAttribute("tipo","texto" );
      ((Element)v.get(1353)).setAttribute("ID","EstDat" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1353));
      /* Termina nodo:1353   */

      /* Empieza nodo:1354 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1354)).setAttribute("tipo","texto" );
      ((Element)v.get(1354)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1354));
      /* Termina nodo:1354   */

      /* Empieza nodo:1355 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1355)).setAttribute("tipo","texto" );
      ((Element)v.get(1355)).setAttribute("ID","EstDat" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1355));
      /* Termina nodo:1355   */

      /* Empieza nodo:1356 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1356)).setAttribute("tipo","texto" );
      ((Element)v.get(1356)).setAttribute("ID","EstDat2" );
   }

   private void getXML6210(Document doc) {
      ((Element)v.get(1346)).appendChild((Element)v.get(1356));
      /* Termina nodo:1356   */

      /* Empieza nodo:1357 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1357)).setAttribute("tipo","texto" );
      ((Element)v.get(1357)).setAttribute("ID","EstDat" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1357));
      /* Termina nodo:1357   */

      /* Empieza nodo:1358 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1358)).setAttribute("tipo","texto" );
      ((Element)v.get(1358)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1358));
      /* Termina nodo:1358   */

      /* Empieza nodo:1359 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1359)).setAttribute("tipo","texto" );
      ((Element)v.get(1359)).setAttribute("ID","EstDat" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1359));
      /* Termina nodo:1359   */

      /* Empieza nodo:1360 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1360)).setAttribute("tipo","texto" );
      ((Element)v.get(1360)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1360));
      /* Termina nodo:1360   */

      /* Empieza nodo:1361 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1361)).setAttribute("tipo","texto" );
      ((Element)v.get(1361)).setAttribute("ID","EstDat" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1361));
      /* Termina nodo:1361   */

      /* Empieza nodo:1362 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1362)).setAttribute("tipo","texto" );
      ((Element)v.get(1362)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1362));
      /* Termina nodo:1362   */

      /* Empieza nodo:1363 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1363)).setAttribute("tipo","texto" );
      ((Element)v.get(1363)).setAttribute("ID","EstDat" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1363));
      /* Termina nodo:1363   */

      /* Empieza nodo:1364 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1364)).setAttribute("tipo","texto" );
      ((Element)v.get(1364)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1364));
      /* Termina nodo:1364   */

      /* Empieza nodo:1365 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1365)).setAttribute("tipo","texto" );
      ((Element)v.get(1365)).setAttribute("ID","EstDat" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1365));
      /* Termina nodo:1365   */

      /* Empieza nodo:1366 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1366)).setAttribute("tipo","texto" );
      ((Element)v.get(1366)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1366));
      /* Termina nodo:1366   */

      /* Empieza nodo:1367 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1367)).setAttribute("tipo","texto" );
      ((Element)v.get(1367)).setAttribute("ID","EstDat" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1367));
      /* Termina nodo:1367   */

      /* Empieza nodo:1368 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1368)).setAttribute("tipo","texto" );
      ((Element)v.get(1368)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1368));
      /* Termina nodo:1368   */

      /* Empieza nodo:1369 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1369)).setAttribute("tipo","texto" );
      ((Element)v.get(1369)).setAttribute("ID","EstDat" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1369));
      /* Termina nodo:1369   */

      /* Empieza nodo:1370 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1370)).setAttribute("tipo","texto" );
      ((Element)v.get(1370)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1370));
      /* Termina nodo:1370   */

      /* Empieza nodo:1371 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1371)).setAttribute("tipo","texto" );
      ((Element)v.get(1371)).setAttribute("ID","EstDat" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1371));
      /* Termina nodo:1371   */

      /* Empieza nodo:1372 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1372)).setAttribute("tipo","texto" );
      ((Element)v.get(1372)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1372));
      /* Termina nodo:1372   */

      /* Empieza nodo:1373 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1373)).setAttribute("tipo","texto" );
      ((Element)v.get(1373)).setAttribute("ID","EstDat" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1373));
      /* Termina nodo:1373   */

      /* Empieza nodo:1374 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1374)).setAttribute("tipo","texto" );
      ((Element)v.get(1374)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1374));
      /* Termina nodo:1374   */

      /* Empieza nodo:1375 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1375)).setAttribute("tipo","texto" );
      ((Element)v.get(1375)).setAttribute("ID","EstDat" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1375));
      /* Termina nodo:1375   */

      /* Empieza nodo:1376 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1376)).setAttribute("tipo","texto" );
      ((Element)v.get(1376)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1376));
      /* Termina nodo:1376   */

      /* Empieza nodo:1377 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1377)).setAttribute("tipo","texto" );
      ((Element)v.get(1377)).setAttribute("ID","EstDat" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1377));
      /* Termina nodo:1377   */

      /* Empieza nodo:1378 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1378)).setAttribute("tipo","texto" );
      ((Element)v.get(1378)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1378));
      /* Termina nodo:1378   */

      /* Empieza nodo:1379 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
   }

   private void getXML6300(Document doc) {
      ((Element)v.get(1379)).setAttribute("tipo","texto" );
      ((Element)v.get(1379)).setAttribute("ID","EstDat" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1379));
      /* Termina nodo:1379   */

      /* Empieza nodo:1380 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1380)).setAttribute("tipo","texto" );
      ((Element)v.get(1380)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1380));
      /* Termina nodo:1380   */

      /* Empieza nodo:1381 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1381)).setAttribute("tipo","texto" );
      ((Element)v.get(1381)).setAttribute("ID","EstDat" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1381));
      /* Termina nodo:1381   */

      /* Empieza nodo:1382 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1382)).setAttribute("tipo","texto" );
      ((Element)v.get(1382)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1382));
      /* Termina nodo:1382   */

      /* Empieza nodo:1383 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1383)).setAttribute("tipo","texto" );
      ((Element)v.get(1383)).setAttribute("ID","EstDat" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1383));
      /* Termina nodo:1383   */

      /* Empieza nodo:1384 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1384)).setAttribute("tipo","texto" );
      ((Element)v.get(1384)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1384));
      /* Termina nodo:1384   */

      /* Empieza nodo:1385 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1385)).setAttribute("tipo","texto" );
      ((Element)v.get(1385)).setAttribute("ID","EstDat" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1385));
      /* Termina nodo:1385   */

      /* Empieza nodo:1386 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1386)).setAttribute("tipo","texto" );
      ((Element)v.get(1386)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1386));
      /* Termina nodo:1386   */

      /* Empieza nodo:1387 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1387)).setAttribute("tipo","texto" );
      ((Element)v.get(1387)).setAttribute("ID","EstDat" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1387));
      /* Termina nodo:1387   */

      /* Empieza nodo:1388 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1388)).setAttribute("tipo","texto" );
      ((Element)v.get(1388)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1388));
      /* Termina nodo:1388   */

      /* Empieza nodo:1389 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1389)).setAttribute("tipo","texto" );
      ((Element)v.get(1389)).setAttribute("ID","EstDat" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1389));
      /* Termina nodo:1389   */

      /* Empieza nodo:1390 / Elemento padre: 1346   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(1390)).setAttribute("tipo","texto" );
      ((Element)v.get(1390)).setAttribute("ID","EstDat2" );
      ((Element)v.get(1346)).appendChild((Element)v.get(1390));
      /* Termina nodo:1390   */
      /* Termina nodo:1346   */

      /* Empieza nodo:1391 / Elemento padre: 1247   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(1247)).appendChild((Element)v.get(1391));
      /* Termina nodo:1391   */
      /* Termina nodo:1247   */
      /* Termina nodo:1246   */

      /* Empieza nodo:1392 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(1392)).setAttribute("nombre","maeProduListButtonsLayer" );
      ((Element)v.get(1392)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(1392)).setAttribute("alto","30" );
      ((Element)v.get(1392)).setAttribute("ancho","98%" );
      ((Element)v.get(1392)).setAttribute("borde","n" );
      ((Element)v.get(1392)).setAttribute("imagenf","" );
      ((Element)v.get(1392)).setAttribute("repeat","" );
      ((Element)v.get(1392)).setAttribute("padding","0" );
      ((Element)v.get(1392)).setAttribute("contravsb","" );
      ((Element)v.get(1392)).setAttribute("x","16" );
      ((Element)v.get(1392)).setAttribute("y","" );
      ((Element)v.get(1392)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(1392));

      /* Empieza nodo:1393 / Elemento padre: 1392   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(1393)).setAttribute("nombre","toolbarSeparatorLayer" );
      ((Element)v.get(1393)).setAttribute("visibilidad","inherit" );
      ((Element)v.get(1393)).setAttribute("alto","23" );
      ((Element)v.get(1393)).setAttribute("ancho","1" );
      ((Element)v.get(1393)).setAttribute("borde","1" );
      ((Element)v.get(1393)).setAttribute("imagenf","" );
      ((Element)v.get(1393)).setAttribute("repeat","" );
      ((Element)v.get(1393)).setAttribute("padding","0" );
      ((Element)v.get(1393)).setAttribute("contravsb","" );
      ((Element)v.get(1393)).setAttribute("x","56" );
      ((Element)v.get(1393)).setAttribute("y","0" );
      ((Element)v.get(1393)).setAttribute("zindex","" );
      ((Element)v.get(1393)).setAttribute("colborde","#999999" );
      ((Element)v.get(1392)).appendChild((Element)v.get(1393));
      /* Termina nodo:1393   */

      /* Empieza nodo:1394 / Elemento padre: 1392   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(1394)).setAttribute("width","100%" );
      ((Element)v.get(1394)).setAttribute("border","0" );
      ((Element)v.get(1394)).setAttribute("cellspacing","1" );
      ((Element)v.get(1394)).setAttribute("cellpadding","0" );
      ((Element)v.get(1392)).appendChild((Element)v.get(1394));

      /* Empieza nodo:1395 / Elemento padre: 1394   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1394)).appendChild((Element)v.get(1395));

      /* Empieza nodo:1396 / Elemento padre: 1395   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1396)).setAttribute("src","b.gif" );
      ((Element)v.get(1396)).setAttribute("height","22" );
      ((Element)v.get(1396)).setAttribute("width","5" );
   }

   private void getXML6390(Document doc) {
      ((Element)v.get(1395)).appendChild((Element)v.get(1396));
      /* Termina nodo:1396   */
      /* Termina nodo:1395   */

      /* Empieza nodo:1397 / Elemento padre: 1394   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1394)).appendChild((Element)v.get(1397));

      /* Empieza nodo:1398 / Elemento padre: 1397   */
      v.add(doc.createElement("BOTONERA"));
      ((Element)v.get(1398)).setAttribute("nombre","maeProduPaginationButtonBar" );
      ((Element)v.get(1398)).setAttribute("tipo","H" );
      ((Element)v.get(1398)).setAttribute("x","0" );
      ((Element)v.get(1398)).setAttribute("y","0" );
      ((Element)v.get(1397)).appendChild((Element)v.get(1398));

      /* Empieza nodo:1399 / Elemento padre: 1398   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(1399)).setAttribute("nombre","maeProduFirstPageButton" );
      ((Element)v.get(1399)).setAttribute("funcion","maeProduFirstPage();" );
      ((Element)v.get(1399)).setAttribute("off","primera_over0.gif" );
      ((Element)v.get(1399)).setAttribute("on","primera_over0.gif" );
      ((Element)v.get(1399)).setAttribute("disable","primera_on0.gif" );
      ((Element)v.get(1399)).setAttribute("estado","inactivo" );
      ((Element)v.get(1398)).appendChild((Element)v.get(1399));
      /* Termina nodo:1399   */

      /* Empieza nodo:1400 / Elemento padre: 1398   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1400)).setAttribute("nombre","maeProduFirstPageButtonGapTd" );
      ((Element)v.get(1398)).appendChild((Element)v.get(1400));

      /* Empieza nodo:1401 / Elemento padre: 1400   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1401)).setAttribute("src","b.gif" );
      ((Element)v.get(1401)).setAttribute("height","8" );
      ((Element)v.get(1401)).setAttribute("width","5" );
      ((Element)v.get(1400)).appendChild((Element)v.get(1401));
      /* Termina nodo:1401   */
      /* Termina nodo:1400   */

      /* Empieza nodo:1402 / Elemento padre: 1398   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(1402)).setAttribute("nombre","maeProduPreviousPageButton" );
      ((Element)v.get(1402)).setAttribute("funcion","maeProduPreviousPage();" );
      ((Element)v.get(1402)).setAttribute("off","retroceder_over0.gif" );
      ((Element)v.get(1402)).setAttribute("on","retroceder_over0.gif" );
      ((Element)v.get(1402)).setAttribute("disable","retroceder_on0.gif" );
      ((Element)v.get(1402)).setAttribute("estado","inactivo" );
      ((Element)v.get(1398)).appendChild((Element)v.get(1402));
      /* Termina nodo:1402   */

      /* Empieza nodo:1403 / Elemento padre: 1398   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1403)).setAttribute("nombre","maeProduPreviousPageButtonGapTd" );
      ((Element)v.get(1398)).appendChild((Element)v.get(1403));

      /* Empieza nodo:1404 / Elemento padre: 1403   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1404)).setAttribute("src","b.gif" );
      ((Element)v.get(1404)).setAttribute("height","8" );
      ((Element)v.get(1404)).setAttribute("width","8" );
      ((Element)v.get(1403)).appendChild((Element)v.get(1404));
      /* Termina nodo:1404   */
      /* Termina nodo:1403   */

      /* Empieza nodo:1405 / Elemento padre: 1398   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(1405)).setAttribute("nombre","maeProduNextPageButton" );
      ((Element)v.get(1405)).setAttribute("funcion","maeProduNextPage();" );
      ((Element)v.get(1405)).setAttribute("off","avanzar_over0.gif" );
      ((Element)v.get(1405)).setAttribute("on","avanzar_over0.gif" );
      ((Element)v.get(1405)).setAttribute("disable","avanzar_on0.gif" );
      ((Element)v.get(1405)).setAttribute("estado","inactivo" );
      ((Element)v.get(1398)).appendChild((Element)v.get(1405));
      /* Termina nodo:1405   */
      /* Termina nodo:1398   */
      /* Termina nodo:1397   */

      /* Empieza nodo:1406 / Elemento padre: 1394   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1394)).appendChild((Element)v.get(1406));

      /* Empieza nodo:1407 / Elemento padre: 1406   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1407)).setAttribute("src","b.gif" );
      ((Element)v.get(1407)).setAttribute("height","22" );
      ((Element)v.get(1407)).setAttribute("width","19" );
      ((Element)v.get(1406)).appendChild((Element)v.get(1407));
      /* Termina nodo:1407   */
      /* Termina nodo:1406   */

      /* Empieza nodo:1408 / Elemento padre: 1394   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1408)).setAttribute("class","tablaTitle" );
      ((Element)v.get(1408)).setAttribute("nombre","maeProduUpdateButtonTd" );
      ((Element)v.get(1394)).appendChild((Element)v.get(1408));

      /* Empieza nodo:1409 / Elemento padre: 1408   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1409)).setAttribute("nombre","maeProduUpdateButton" );
      ((Element)v.get(1409)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1409)).setAttribute("tipo","html" );
      ((Element)v.get(1409)).setAttribute("accion","maeProduUpdateSelection();" );
      ((Element)v.get(1409)).setAttribute("estado","false" );
      ((Element)v.get(1409)).setAttribute("cod","MMGGlobal.updateButton.label" );
      ((Element)v.get(1408)).appendChild((Element)v.get(1409));
      /* Termina nodo:1409   */
      /* Termina nodo:1408   */

      /* Empieza nodo:1410 / Elemento padre: 1394   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1410)).setAttribute("nombre","maeProduUpdateButtonGapTd" );
      ((Element)v.get(1394)).appendChild((Element)v.get(1410));

      /* Empieza nodo:1411 / Elemento padre: 1410   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1411)).setAttribute("src","b.gif" );
      ((Element)v.get(1411)).setAttribute("height","8" );
      ((Element)v.get(1411)).setAttribute("width","10" );
      ((Element)v.get(1410)).appendChild((Element)v.get(1411));
      /* Termina nodo:1411   */
      /* Termina nodo:1410   */

      /* Empieza nodo:1412 / Elemento padre: 1394   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1412)).setAttribute("class","tablaTitle" );
      ((Element)v.get(1412)).setAttribute("nombre","maeProduViewForRemoveButtonTd" );
      ((Element)v.get(1394)).appendChild((Element)v.get(1412));

      /* Empieza nodo:1413 / Elemento padre: 1412   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1413)).setAttribute("nombre","maeProduViewForRemoveButton" );
      ((Element)v.get(1413)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1413)).setAttribute("tipo","html" );
      ((Element)v.get(1413)).setAttribute("accion","maeProduViewSelection();" );
      ((Element)v.get(1413)).setAttribute("estado","false" );
      ((Element)v.get(1413)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(1412)).appendChild((Element)v.get(1413));
      /* Termina nodo:1413   */
      /* Termina nodo:1412   */

      /* Empieza nodo:1414 / Elemento padre: 1394   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1414)).setAttribute("nombre","maeProduViewForRemoveButtonGapTd" );
   }

   private void getXML6480(Document doc) {
      ((Element)v.get(1394)).appendChild((Element)v.get(1414));

      /* Empieza nodo:1415 / Elemento padre: 1414   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1415)).setAttribute("src","b.gif" );
      ((Element)v.get(1415)).setAttribute("height","8" );
      ((Element)v.get(1415)).setAttribute("width","10" );
      ((Element)v.get(1414)).appendChild((Element)v.get(1415));
      /* Termina nodo:1415   */
      /* Termina nodo:1414   */

      /* Empieza nodo:1416 / Elemento padre: 1394   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1416)).setAttribute("class","tablaTitle" );
      ((Element)v.get(1416)).setAttribute("nombre","maeProduLovSelectButtonTd" );
      ((Element)v.get(1394)).appendChild((Element)v.get(1416));

      /* Empieza nodo:1417 / Elemento padre: 1416   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1417)).setAttribute("nombre","maeProduLovSelectButton" );
      ((Element)v.get(1417)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1417)).setAttribute("tipo","html" );
      ((Element)v.get(1417)).setAttribute("accion","maeProduLovSelectionAction();" );
      ((Element)v.get(1417)).setAttribute("estado","true" );
      ((Element)v.get(1417)).setAttribute("cod","MMGGlobal.lovSelectButton.label" );
      ((Element)v.get(1416)).appendChild((Element)v.get(1417));
      /* Termina nodo:1417   */
      /* Termina nodo:1416   */

      /* Empieza nodo:1418 / Elemento padre: 1394   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1418)).setAttribute("nombre","maeProduLovSelectButtonGapTd" );
      ((Element)v.get(1394)).appendChild((Element)v.get(1418));

      /* Empieza nodo:1419 / Elemento padre: 1418   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1419)).setAttribute("src","b.gif" );
      ((Element)v.get(1419)).setAttribute("height","8" );
      ((Element)v.get(1419)).setAttribute("width","10" );
      ((Element)v.get(1418)).appendChild((Element)v.get(1419));
      /* Termina nodo:1419   */
      /* Termina nodo:1418   */

      /* Empieza nodo:1420 / Elemento padre: 1394   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1420)).setAttribute("class","tablaTitle" );
      ((Element)v.get(1420)).setAttribute("nombre","maeProduViewButtonTd" );
      ((Element)v.get(1394)).appendChild((Element)v.get(1420));

      /* Empieza nodo:1421 / Elemento padre: 1420   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(1421)).setAttribute("nombre","maeProduViewButton" );
      ((Element)v.get(1421)).setAttribute("ID","botonContenido" );
      ((Element)v.get(1421)).setAttribute("tipo","html" );
      ((Element)v.get(1421)).setAttribute("accion","maeProduViewSelection();" );
      ((Element)v.get(1421)).setAttribute("estado","false" );
      ((Element)v.get(1421)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(1420)).appendChild((Element)v.get(1421));
      /* Termina nodo:1421   */
      /* Termina nodo:1420   */

      /* Empieza nodo:1422 / Elemento padre: 1394   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1422)).setAttribute("nombre","maeProduViewButtonGapTd" );
      ((Element)v.get(1394)).appendChild((Element)v.get(1422));

      /* Empieza nodo:1423 / Elemento padre: 1422   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(1423)).setAttribute("src","b.gif" );
      ((Element)v.get(1423)).setAttribute("height","8" );
      ((Element)v.get(1423)).setAttribute("width","10" );
      ((Element)v.get(1422)).appendChild((Element)v.get(1423));
      /* Termina nodo:1423   */
      /* Termina nodo:1422   */

      /* Empieza nodo:1424 / Elemento padre: 1394   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(1424)).setAttribute("width","100%" );
      ((Element)v.get(1394)).appendChild((Element)v.get(1424));
      /* Termina nodo:1424   */
      /* Termina nodo:1394   */
      /* Termina nodo:1392   */
      /* Termina nodo:4   */


   }

}

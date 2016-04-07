
import org.w3c.dom.*;
import java.util.ArrayList;

public class MaeClienPage  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","MaeClienPage" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","maeClienInitComponents()" );
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
      ((Element)v.get(3)).setAttribute("src","maeclien.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(4)).setAttribute("nombre","maeClienFrm" );
      ((Element)v.get(4)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(5)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(5)).setAttribute("valor","MaeClienLPExecution" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","ON" );
      ((Element)v.get(6)).setAttribute("valor","MaeClienLPExecution" );
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
      ((Element)v.get(36)).setAttribute("nombre","maeClienFormLayer" );
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
      ((Element)v.get(51)).setAttribute("cod","MaeClien.legend.label" );
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
      ((Element)v.get(66)).setAttribute("cod","MaeClien.id.label" );
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
      ((Element)v.get(69)).setAttribute("ontab","ejecutarAccionFoco('maeClienFrm',0, true)" );
      ((Element)v.get(69)).setAttribute("onshtab","ejecutarAccionFoco('maeClienFrm', 0, false)" );
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
      ((Element)v.get(87)).setAttribute("nombre","codClieTdId" );
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
      ((Element)v.get(91)).setAttribute("nombre","lblCodClie" );
      ((Element)v.get(91)).setAttribute("alto","13" );
      ((Element)v.get(91)).setAttribute("filas","1" );
      ((Element)v.get(91)).setAttribute("id","datosTitle" );
      ((Element)v.get(91)).setAttribute("cod","MaeClien.codClie.label" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:92 / Elemento padre: 88   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(92)).setAttribute("nombre","codClieWidgetTrId" );
      ((Element)v.get(88)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(93)).setAttribute("align","left" );
      ((Element)v.get(93)).setAttribute("nowrap","true" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(94)).setAttribute("nombre","codClie" );
      ((Element)v.get(94)).setAttribute("id","datosCampos" );
      ((Element)v.get(94)).setAttribute("trim","S" );
      ((Element)v.get(94)).setAttribute("max","15" );
      ((Element)v.get(94)).setAttribute("onchange","" );
      ((Element)v.get(94)).setAttribute("req","N" );
      ((Element)v.get(94)).setAttribute("size","15" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(94)).setAttribute("validacion","" );
      ((Element)v.get(94)).setAttribute("disabled","" );
      ((Element)v.get(94)).setAttribute("onblur","" );
      ((Element)v.get(94)).setAttribute("ontab","ejecutarAccionFoco('maeClienFrm',0, true)" );
      ((Element)v.get(94)).setAttribute("onshtab","ejecutarAccionFoco('maeClienFrm', 0, false)" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:95 / Elemento padre: 86   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(95)).setAttribute("nombre","codClieGapTdId" );
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
      ((Element)v.get(112)).setAttribute("nombre","indFichInscTdId" );
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
      ((Element)v.get(116)).setAttribute("nombre","lblIndFichInsc" );
      ((Element)v.get(116)).setAttribute("alto","13" );
      ((Element)v.get(116)).setAttribute("filas","1" );
      ((Element)v.get(116)).setAttribute("id","datosTitle" );
      ((Element)v.get(116)).setAttribute("cod","MaeClien.indFichInsc.label" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:117 / Elemento padre: 113   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(117)).setAttribute("nombre","indFichInscWidgetTrId" );
      ((Element)v.get(113)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(118)).setAttribute("align","left" );
      ((Element)v.get(118)).setAttribute("nowrap","true" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(119)).setAttribute("nombre","indFichInsc" );
      ((Element)v.get(119)).setAttribute("id","datosCampos" );
      ((Element)v.get(119)).setAttribute("trim","S" );
      ((Element)v.get(119)).setAttribute("max","1" );
      ((Element)v.get(119)).setAttribute("onchange","" );
      ((Element)v.get(119)).setAttribute("req","N" );
      ((Element)v.get(119)).setAttribute("size","1" );
      ((Element)v.get(119)).setAttribute("valor","" );
      ((Element)v.get(119)).setAttribute("validacion","" );
      ((Element)v.get(119)).setAttribute("disabled","" );
      ((Element)v.get(119)).setAttribute("onblur","" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(119)).setAttribute("ontab","ejecutarAccionFoco('maeClienFrm',0, true)" );
      ((Element)v.get(119)).setAttribute("onshtab","ejecutarAccionFoco('maeClienFrm', 0, false)" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:120 / Elemento padre: 111   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(120)).setAttribute("nombre","indFichInscGapTdId" );
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
      ((Element)v.get(137)).setAttribute("nombre","paisOidPais_fopaOidFormPagoTdId" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("TABLE"));
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
      ((Element)v.get(141)).setAttribute("nombre","lblpaisOidPais_fopaOidFormPago" );
      ((Element)v.get(141)).setAttribute("id","datosTitle" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(141)).setAttribute("ancho","150" );
      ((Element)v.get(141)).setAttribute("alto","13" );
      ((Element)v.get(141)).setAttribute("cod","SegPais.fopaOidFormPago.label" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:142 / Elemento padre: 138   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(142)).setAttribute("nombre","paisOidPais_fopaOidFormPagoWidgetTrId" );
      ((Element)v.get(138)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(143)).setAttribute("align","left" );
      ((Element)v.get(143)).setAttribute("nowrap","true" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(144)).setAttribute("nombre","paisOidPais_fopaOidFormPago" );
      ((Element)v.get(144)).setAttribute("id","datosCampos" );
      ((Element)v.get(144)).setAttribute("multiple","N" );
      ((Element)v.get(144)).setAttribute("req","N" );
      ((Element)v.get(144)).setAttribute("size","1" );
      ((Element)v.get(144)).setAttribute("disabled","" );
      ((Element)v.get(144)).setAttribute("validacion","" );
      ((Element)v.get(144)).setAttribute("onchange","mmgDependeneChange('paisOidPais_fopaOidFormPago', 'paisOidPais' , 'maeClien')" );
      ((Element)v.get(144)).setAttribute("onfocus","" );
      ((Element)v.get(144)).setAttribute("valorinicial","" );
      ((Element)v.get(144)).setAttribute("textoinicial","" );
      ((Element)v.get(144)).setAttribute("ontab","focaliza('maeClienFrm.paisOidPais_moneOidMoneAlt');" );
      ((Element)v.get(144)).setAttribute("onshtab","ejecutarAccionFoco('maeClienFrm',0, false);" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:146 / Elemento padre: 136   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(146)).setAttribute("nombre","paisOidPais_fopaOidFormPagoGapTdId" );
      ((Element)v.get(146)).setAttribute("nowrap","true" );
      ((Element)v.get(146)).setAttribute("class","datosCampos" );
      ((Element)v.get(136)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).setAttribute("width","25" );
      ((Element)v.get(147)).setAttribute("height","8" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:148 / Elemento padre: 136   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(148)).setAttribute("nombre","paisOidPais_moneOidMoneAltTdId" );
      ((Element)v.get(136)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(149)).setAttribute("border","0" );
      ((Element)v.get(149)).setAttribute("cellspacing","0" );
      ((Element)v.get(149)).setAttribute("cellpadding","0" );
      ((Element)v.get(149)).setAttribute("align","left" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(151)).setAttribute("valign","top" );
      ((Element)v.get(151)).setAttribute("height","13" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(152)).setAttribute("nombre","lblpaisOidPais_moneOidMoneAlt" );
      ((Element)v.get(152)).setAttribute("id","datosTitle" );
      ((Element)v.get(152)).setAttribute("ancho","150" );
      ((Element)v.get(152)).setAttribute("alto","13" );
      ((Element)v.get(152)).setAttribute("cod","SegPais.moneOidMoneAlt.label" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:150   */

      /* Empieza nodo:153 / Elemento padre: 149   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(153)).setAttribute("nombre","paisOidPais_moneOidMoneAltWidgetTrId" );
      ((Element)v.get(149)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(154)).setAttribute("align","left" );
      ((Element)v.get(154)).setAttribute("nowrap","true" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(155)).setAttribute("nombre","paisOidPais_moneOidMoneAlt" );
      ((Element)v.get(155)).setAttribute("id","datosCampos" );
      ((Element)v.get(155)).setAttribute("multiple","N" );
      ((Element)v.get(155)).setAttribute("req","N" );
      ((Element)v.get(155)).setAttribute("size","1" );
      ((Element)v.get(155)).setAttribute("disabled","" );
      ((Element)v.get(155)).setAttribute("validacion","" );
      ((Element)v.get(155)).setAttribute("onchange","mmgDependeneChange('paisOidPais_moneOidMoneAlt', 'paisOidPais' , 'maeClien')" );
      ((Element)v.get(155)).setAttribute("onfocus","" );
      ((Element)v.get(155)).setAttribute("valorinicial","" );
      ((Element)v.get(155)).setAttribute("textoinicial","" );
      ((Element)v.get(155)).setAttribute("ontab","focaliza('maeClienFrm.paisOidPais_moneOidMone');" );
      ((Element)v.get(155)).setAttribute("onshtab","ejecutarAccionFoco('maeClienFrm',0, false);" );
      ((Element)v.get(154)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:157 / Elemento padre: 136   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(157)).setAttribute("nombre","paisOidPais_moneOidMoneAltGapTdId" );
      ((Element)v.get(157)).setAttribute("nowrap","true" );
      ((Element)v.get(157)).setAttribute("class","datosCampos" );
      ((Element)v.get(136)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(158)).setAttribute("width","25" );
      ((Element)v.get(158)).setAttribute("height","8" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */

      /* Empieza nodo:159 / Elemento padre: 136   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(159)).setAttribute("nombre","paisOidPais_moneOidMoneTdId" );
      ((Element)v.get(136)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(160)).setAttribute("border","0" );
      ((Element)v.get(160)).setAttribute("cellspacing","0" );
      ((Element)v.get(160)).setAttribute("cellpadding","0" );
      ((Element)v.get(160)).setAttribute("align","left" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(162)).setAttribute("valign","top" );
      ((Element)v.get(162)).setAttribute("height","13" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(163)).setAttribute("nombre","lblpaisOidPais_moneOidMone" );
      ((Element)v.get(163)).setAttribute("id","datosTitle" );
      ((Element)v.get(163)).setAttribute("ancho","150" );
      ((Element)v.get(163)).setAttribute("alto","13" );
      ((Element)v.get(163)).setAttribute("cod","SegPais.moneOidMone.label" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:164 / Elemento padre: 160   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(164)).setAttribute("nombre","paisOidPais_moneOidMoneWidgetTrId" );
      ((Element)v.get(160)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(165)).setAttribute("align","left" );
      ((Element)v.get(165)).setAttribute("nowrap","true" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(166)).setAttribute("nombre","paisOidPais_moneOidMone" );
      ((Element)v.get(166)).setAttribute("id","datosCampos" );
      ((Element)v.get(166)).setAttribute("multiple","N" );
      ((Element)v.get(166)).setAttribute("req","N" );
      ((Element)v.get(166)).setAttribute("size","1" );
      ((Element)v.get(166)).setAttribute("disabled","" );
      ((Element)v.get(166)).setAttribute("validacion","" );
      ((Element)v.get(166)).setAttribute("onchange","mmgDependeneChange('paisOidPais_moneOidMone', 'paisOidPais' , 'maeClien')" );
      ((Element)v.get(166)).setAttribute("onfocus","" );
      ((Element)v.get(166)).setAttribute("valorinicial","" );
      ((Element)v.get(166)).setAttribute("textoinicial","" );
      ((Element)v.get(166)).setAttribute("ontab","focaliza('maeClienFrm.paisOidPais');" );
      ((Element)v.get(166)).setAttribute("onshtab","ejecutarAccionFoco('maeClienFrm',0, false);" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:165   */
      /* Termina nodo:164   */
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:168 / Elemento padre: 136   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(168)).setAttribute("nombre","paisOidPais_moneOidMoneGapTdId" );
      ((Element)v.get(168)).setAttribute("nowrap","true" );
      ((Element)v.get(168)).setAttribute("class","datosCampos" );
      ((Element)v.get(136)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(169)).setAttribute("src","b.gif" );
      ((Element)v.get(169)).setAttribute("width","25" );
      ((Element)v.get(169)).setAttribute("height","8" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */

      /* Empieza nodo:170 / Elemento padre: 136   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(170)).setAttribute("nombre","paisOidPaisTdId" );
      ((Element)v.get(136)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(171)).setAttribute("border","0" );
      ((Element)v.get(171)).setAttribute("cellspacing","0" );
      ((Element)v.get(171)).setAttribute("cellpadding","0" );
      ((Element)v.get(171)).setAttribute("align","left" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(173)).setAttribute("valign","top" );
      ((Element)v.get(173)).setAttribute("height","13" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(174)).setAttribute("nombre","lblpaisOidPais" );
      ((Element)v.get(174)).setAttribute("id","datosTitle" );
      ((Element)v.get(174)).setAttribute("ancho","150" );
      ((Element)v.get(174)).setAttribute("alto","13" );
      ((Element)v.get(174)).setAttribute("cod","MaeClien.paisOidPais.label" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:175 / Elemento padre: 171   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(175)).setAttribute("nombre","paisOidPaisWidgetTrId" );
      ((Element)v.get(171)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(176)).setAttribute("align","left" );
      ((Element)v.get(176)).setAttribute("nowrap","true" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("COMBO"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(177)).setAttribute("nombre","paisOidPais" );
      ((Element)v.get(177)).setAttribute("id","datosCampos" );
      ((Element)v.get(177)).setAttribute("multiple","N" );
      ((Element)v.get(177)).setAttribute("req","N" );
      ((Element)v.get(177)).setAttribute("size","1" );
      ((Element)v.get(177)).setAttribute("disabled","" );
      ((Element)v.get(177)).setAttribute("validacion","" );
      ((Element)v.get(177)).setAttribute("onchange","" );
      ((Element)v.get(177)).setAttribute("onfocus","" );
      ((Element)v.get(177)).setAttribute("valorinicial","" );
      ((Element)v.get(177)).setAttribute("textoinicial","" );
      ((Element)v.get(177)).setAttribute("ontab","ejecutarAccionFoco('maeClienFrm',0, true);" );
      ((Element)v.get(177)).setAttribute("onshtab","focaliza('maeClienFrm.paisOidPais_moneOidMone');" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:175   */
      /* Termina nodo:171   */
      /* Termina nodo:170   */

      /* Empieza nodo:179 / Elemento padre: 136   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(179)).setAttribute("nombre","paisOidPaisGapTdId" );
      ((Element)v.get(179)).setAttribute("nowrap","true" );
      ((Element)v.get(179)).setAttribute("class","datosCampos" );
      ((Element)v.get(136)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(180)).setAttribute("src","b.gif" );
      ((Element)v.get(180)).setAttribute("width","25" );
      ((Element)v.get(180)).setAttribute("height","8" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 136   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(181)).setAttribute("width","100%" );
      ((Element)v.get(136)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(182)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */
      /* Termina nodo:136   */
      /* Termina nodo:135   */
      /* Termina nodo:134   */
      /* Termina nodo:131   */

      /* Empieza nodo:183 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(183)).setAttribute("nombre","formGapTr3" );
      ((Element)v.get(52)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(184)).setAttribute("align","center" );
      ((Element)v.get(184)).setAttribute("width","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(185)).setAttribute("src","b.gif" );
      ((Element)v.get(185)).setAttribute("width","12" );
      ((Element)v.get(185)).setAttribute("height","8" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:186 / Elemento padre: 183   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(183)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(187)).setAttribute("src","b.gif" );
      ((Element)v.get(187)).setAttribute("width","8" );
      ((Element)v.get(187)).setAttribute("height","8" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:188 / Elemento padre: 183   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(188)).setAttribute("align","center" );
      ((Element)v.get(188)).setAttribute("width","8" );
      ((Element)v.get(183)).appendChild((Element)v.get(188));

      /* Empieza nodo:189 / Elemento padre: 188   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(189)).setAttribute("src","b.gif" );
      ((Element)v.get(189)).setAttribute("width","12" );
      ((Element)v.get(189)).setAttribute("height","8" );
      ((Element)v.get(188)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:188   */
      /* Termina nodo:183   */

      /* Empieza nodo:190 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(190)).setAttribute("nombre","formTr4" );
      ((Element)v.get(52)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(191)).setAttribute("align","center" );
      ((Element)v.get(191)).setAttribute("width","8" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(192)).setAttribute("src","b.gif" );
      ((Element)v.get(192)).setAttribute("width","8" );
      ((Element)v.get(192)).setAttribute("height","12" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */
      /* Termina nodo:191   */

      /* Empieza nodo:193 / Elemento padre: 190   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(193)).setAttribute("width","100%" );
      ((Element)v.get(190)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(194)).setAttribute("width","100%" );
      ((Element)v.get(194)).setAttribute("border","0" );
      ((Element)v.get(194)).setAttribute("cellspacing","0" );
      ((Element)v.get(194)).setAttribute("cellpadding","0" );
      ((Element)v.get(194)).setAttribute("align","left" );
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(195)).setAttribute("align","left" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(196)).setAttribute("nombre","codDigiCtrlTdId" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(197)).setAttribute("width","100%" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(197)).setAttribute("border","0" );
      ((Element)v.get(197)).setAttribute("cellspacing","0" );
      ((Element)v.get(197)).setAttribute("cellpadding","0" );
      ((Element)v.get(197)).setAttribute("align","left" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(199)).setAttribute("valign","top" );
      ((Element)v.get(199)).setAttribute("height","13" );
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(200)).setAttribute("nombre","lblCodDigiCtrl" );
      ((Element)v.get(200)).setAttribute("alto","13" );
      ((Element)v.get(200)).setAttribute("filas","1" );
      ((Element)v.get(200)).setAttribute("id","datosTitle" );
      ((Element)v.get(200)).setAttribute("cod","MaeClien.codDigiCtrl.label" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:201 / Elemento padre: 197   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(201)).setAttribute("nombre","codDigiCtrlWidgetTrId" );
      ((Element)v.get(197)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(202)).setAttribute("align","left" );
      ((Element)v.get(202)).setAttribute("nowrap","true" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(203)).setAttribute("nombre","codDigiCtrl" );
      ((Element)v.get(203)).setAttribute("id","datosCampos" );
      ((Element)v.get(203)).setAttribute("trim","S" );
      ((Element)v.get(203)).setAttribute("max","1" );
      ((Element)v.get(203)).setAttribute("onchange","" );
      ((Element)v.get(203)).setAttribute("req","N" );
      ((Element)v.get(203)).setAttribute("size","1" );
      ((Element)v.get(203)).setAttribute("valor","" );
      ((Element)v.get(203)).setAttribute("validacion","" );
      ((Element)v.get(203)).setAttribute("disabled","" );
      ((Element)v.get(203)).setAttribute("onblur","" );
      ((Element)v.get(203)).setAttribute("ontab","ejecutarAccionFoco('maeClienFrm',0, true)" );
      ((Element)v.get(203)).setAttribute("onshtab","ejecutarAccionFoco('maeClienFrm', 0, false)" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */
      /* Termina nodo:201   */
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:204 / Elemento padre: 195   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(204)).setAttribute("nombre","codDigiCtrlGapTdId" );
      ((Element)v.get(204)).setAttribute("nowrap","true" );
      ((Element)v.get(204)).setAttribute("class","datosCampos" );
      ((Element)v.get(195)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(205)).setAttribute("src","b.gif" );
      ((Element)v.get(205)).setAttribute("width","25" );
      ((Element)v.get(205)).setAttribute("height","8" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 195   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(206)).setAttribute("width","100%" );
      ((Element)v.get(195)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(207)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).appendChild((Element)v.get(207));
      /* Termina nodo:207   */
      /* Termina nodo:206   */
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:190   */

      /* Empieza nodo:208 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(208)).setAttribute("nombre","formGapTr4" );
      ((Element)v.get(52)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(209)).setAttribute("align","center" );
      ((Element)v.get(209)).setAttribute("width","8" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(210)).setAttribute("src","b.gif" );
      ((Element)v.get(210)).setAttribute("width","12" );
      ((Element)v.get(210)).setAttribute("height","8" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */

      /* Empieza nodo:211 / Elemento padre: 208   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(208)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(212)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).setAttribute("width","8" );
      ((Element)v.get(212)).setAttribute("height","8" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */

      /* Empieza nodo:213 / Elemento padre: 208   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(213)).setAttribute("align","center" );
      ((Element)v.get(213)).setAttribute("width","8" );
      ((Element)v.get(208)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(214)).setAttribute("src","b.gif" );
      ((Element)v.get(214)).setAttribute("width","12" );
      ((Element)v.get(214)).setAttribute("height","8" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */
      /* Termina nodo:208   */

      /* Empieza nodo:215 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(215)).setAttribute("nombre","formTr5" );
      ((Element)v.get(52)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(216)).setAttribute("align","center" );
      ((Element)v.get(216)).setAttribute("width","8" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(217)).setAttribute("src","b.gif" );
      ((Element)v.get(217)).setAttribute("width","8" );
      ((Element)v.get(217)).setAttribute("height","12" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:218 / Elemento padre: 215   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(218)).setAttribute("width","100%" );
      ((Element)v.get(215)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(219)).setAttribute("width","100%" );
      ((Element)v.get(219)).setAttribute("border","0" );
      ((Element)v.get(219)).setAttribute("cellspacing","0" );
      ((Element)v.get(219)).setAttribute("cellpadding","0" );
      ((Element)v.get(219)).setAttribute("align","left" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(220)).setAttribute("align","left" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(221)).setAttribute("nombre","valApe1TdId" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(222)).setAttribute("width","100%" );
      ((Element)v.get(222)).setAttribute("border","0" );
      ((Element)v.get(222)).setAttribute("cellspacing","0" );
      ((Element)v.get(222)).setAttribute("cellpadding","0" );
      ((Element)v.get(222)).setAttribute("align","left" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(222)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(224)).setAttribute("valign","top" );
      ((Element)v.get(224)).setAttribute("height","13" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(225)).setAttribute("nombre","lblValApe1" );
      ((Element)v.get(225)).setAttribute("alto","13" );
      ((Element)v.get(225)).setAttribute("filas","1" );
      ((Element)v.get(225)).setAttribute("id","datosTitle" );
      ((Element)v.get(225)).setAttribute("cod","MaeClien.valApe1.label" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:226 / Elemento padre: 222   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(226)).setAttribute("nombre","valApe1WidgetTrId" );
      ((Element)v.get(222)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(227)).setAttribute("align","left" );
      ((Element)v.get(227)).setAttribute("nowrap","true" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(228)).setAttribute("nombre","valApe1" );
      ((Element)v.get(228)).setAttribute("id","datosCampos" );
      ((Element)v.get(228)).setAttribute("trim","S" );
      ((Element)v.get(228)).setAttribute("max","25" );
      ((Element)v.get(228)).setAttribute("onchange","" );
      ((Element)v.get(228)).setAttribute("req","N" );
      ((Element)v.get(228)).setAttribute("size","25" );
      ((Element)v.get(228)).setAttribute("valor","" );
      ((Element)v.get(228)).setAttribute("validacion","" );
      ((Element)v.get(228)).setAttribute("disabled","" );
      ((Element)v.get(228)).setAttribute("onblur","" );
      ((Element)v.get(228)).setAttribute("ontab","ejecutarAccionFoco('maeClienFrm',0, true)" );
      ((Element)v.get(228)).setAttribute("onshtab","ejecutarAccionFoco('maeClienFrm', 0, false)" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */
      /* Termina nodo:226   */
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:229 / Elemento padre: 220   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(229)).setAttribute("nombre","valApe1GapTdId" );
      ((Element)v.get(229)).setAttribute("nowrap","true" );
      ((Element)v.get(229)).setAttribute("class","datosCampos" );
      ((Element)v.get(220)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(230)).setAttribute("width","25" );
      ((Element)v.get(230)).setAttribute("height","8" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 220   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(231)).setAttribute("width","100%" );
      ((Element)v.get(220)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(232)).setAttribute("src","b.gif" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */
      /* Termina nodo:220   */
      /* Termina nodo:219   */
      /* Termina nodo:218   */
      /* Termina nodo:215   */

      /* Empieza nodo:233 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(233)).setAttribute("nombre","formGapTr5" );
      ((Element)v.get(52)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(234)).setAttribute("align","center" );
      ((Element)v.get(234)).setAttribute("width","8" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(235)).setAttribute("src","b.gif" );
      ((Element)v.get(235)).setAttribute("width","12" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(235)).setAttribute("height","8" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:236 / Elemento padre: 233   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(233)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(237)).setAttribute("src","b.gif" );
      ((Element)v.get(237)).setAttribute("width","8" );
      ((Element)v.get(237)).setAttribute("height","8" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:238 / Elemento padre: 233   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(238)).setAttribute("align","center" );
      ((Element)v.get(238)).setAttribute("width","8" );
      ((Element)v.get(233)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(239)).setAttribute("src","b.gif" );
      ((Element)v.get(239)).setAttribute("width","12" );
      ((Element)v.get(239)).setAttribute("height","8" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */
      /* Termina nodo:233   */

      /* Empieza nodo:240 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(240)).setAttribute("nombre","formTr6" );
      ((Element)v.get(52)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(241)).setAttribute("align","center" );
      ((Element)v.get(241)).setAttribute("width","8" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(242)).setAttribute("src","b.gif" );
      ((Element)v.get(242)).setAttribute("width","8" );
      ((Element)v.get(242)).setAttribute("height","12" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:243 / Elemento padre: 240   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(243)).setAttribute("width","100%" );
      ((Element)v.get(240)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(244)).setAttribute("width","100%" );
      ((Element)v.get(244)).setAttribute("border","0" );
      ((Element)v.get(244)).setAttribute("cellspacing","0" );
      ((Element)v.get(244)).setAttribute("cellpadding","0" );
      ((Element)v.get(244)).setAttribute("align","left" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(245)).setAttribute("align","left" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(246)).setAttribute("nombre","valApe2TdId" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(247)).setAttribute("width","100%" );
      ((Element)v.get(247)).setAttribute("border","0" );
      ((Element)v.get(247)).setAttribute("cellspacing","0" );
      ((Element)v.get(247)).setAttribute("cellpadding","0" );
      ((Element)v.get(247)).setAttribute("align","left" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(247)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(249)).setAttribute("valign","top" );
      ((Element)v.get(249)).setAttribute("height","13" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(250)).setAttribute("nombre","lblValApe2" );
      ((Element)v.get(250)).setAttribute("alto","13" );
      ((Element)v.get(250)).setAttribute("filas","1" );
      ((Element)v.get(250)).setAttribute("id","datosTitle" );
      ((Element)v.get(250)).setAttribute("cod","MaeClien.valApe2.label" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:251 / Elemento padre: 247   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(251)).setAttribute("nombre","valApe2WidgetTrId" );
      ((Element)v.get(247)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(252)).setAttribute("align","left" );
      ((Element)v.get(252)).setAttribute("nowrap","true" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(253)).setAttribute("nombre","valApe2" );
      ((Element)v.get(253)).setAttribute("id","datosCampos" );
      ((Element)v.get(253)).setAttribute("trim","S" );
      ((Element)v.get(253)).setAttribute("max","25" );
      ((Element)v.get(253)).setAttribute("onchange","" );
      ((Element)v.get(253)).setAttribute("req","N" );
      ((Element)v.get(253)).setAttribute("size","25" );
      ((Element)v.get(253)).setAttribute("valor","" );
      ((Element)v.get(253)).setAttribute("validacion","" );
      ((Element)v.get(253)).setAttribute("disabled","" );
      ((Element)v.get(253)).setAttribute("onblur","" );
      ((Element)v.get(253)).setAttribute("ontab","ejecutarAccionFoco('maeClienFrm',0, true)" );
      ((Element)v.get(253)).setAttribute("onshtab","ejecutarAccionFoco('maeClienFrm', 0, false)" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));
      /* Termina nodo:253   */
      /* Termina nodo:252   */
      /* Termina nodo:251   */
      /* Termina nodo:247   */
      /* Termina nodo:246   */

      /* Empieza nodo:254 / Elemento padre: 245   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(254)).setAttribute("nombre","valApe2GapTdId" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(254)).setAttribute("nowrap","true" );
      ((Element)v.get(254)).setAttribute("class","datosCampos" );
      ((Element)v.get(245)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(255)).setAttribute("src","b.gif" );
      ((Element)v.get(255)).setAttribute("width","25" );
      ((Element)v.get(255)).setAttribute("height","8" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */

      /* Empieza nodo:256 / Elemento padre: 245   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(256)).setAttribute("width","100%" );
      ((Element)v.get(245)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(257)).setAttribute("src","b.gif" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:245   */
      /* Termina nodo:244   */
      /* Termina nodo:243   */
      /* Termina nodo:240   */

      /* Empieza nodo:258 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(258)).setAttribute("nombre","formGapTr6" );
      ((Element)v.get(52)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(259)).setAttribute("align","center" );
      ((Element)v.get(259)).setAttribute("width","8" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(260)).setAttribute("src","b.gif" );
      ((Element)v.get(260)).setAttribute("width","12" );
      ((Element)v.get(260)).setAttribute("height","8" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:261 / Elemento padre: 258   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(258)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(262)).setAttribute("src","b.gif" );
      ((Element)v.get(262)).setAttribute("width","8" );
      ((Element)v.get(262)).setAttribute("height","8" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */

      /* Empieza nodo:263 / Elemento padre: 258   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(263)).setAttribute("align","center" );
      ((Element)v.get(263)).setAttribute("width","8" );
      ((Element)v.get(258)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(264)).setAttribute("src","b.gif" );
      ((Element)v.get(264)).setAttribute("width","12" );
      ((Element)v.get(264)).setAttribute("height","8" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */
      /* Termina nodo:258   */

      /* Empieza nodo:265 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(265)).setAttribute("nombre","formTr7" );
      ((Element)v.get(52)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(266)).setAttribute("align","center" );
      ((Element)v.get(266)).setAttribute("width","8" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(267)).setAttribute("src","b.gif" );
      ((Element)v.get(267)).setAttribute("width","8" );
      ((Element)v.get(267)).setAttribute("height","12" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:268 / Elemento padre: 265   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(268)).setAttribute("width","100%" );
      ((Element)v.get(265)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(269)).setAttribute("width","100%" );
      ((Element)v.get(269)).setAttribute("border","0" );
      ((Element)v.get(269)).setAttribute("cellspacing","0" );
      ((Element)v.get(269)).setAttribute("cellpadding","0" );
      ((Element)v.get(269)).setAttribute("align","left" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(270)).setAttribute("align","left" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(271)).setAttribute("nombre","valNom1TdId" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(272)).setAttribute("width","100%" );
      ((Element)v.get(272)).setAttribute("border","0" );
      ((Element)v.get(272)).setAttribute("cellspacing","0" );
      ((Element)v.get(272)).setAttribute("cellpadding","0" );
      ((Element)v.get(272)).setAttribute("align","left" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(274)).setAttribute("valign","top" );
      ((Element)v.get(274)).setAttribute("height","13" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(275)).setAttribute("nombre","lblValNom1" );
      ((Element)v.get(275)).setAttribute("alto","13" );
      ((Element)v.get(275)).setAttribute("filas","1" );
      ((Element)v.get(275)).setAttribute("id","datosTitle" );
      ((Element)v.get(275)).setAttribute("cod","MaeClien.valNom1.label" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */
      /* Termina nodo:274   */
      /* Termina nodo:273   */

      /* Empieza nodo:276 / Elemento padre: 272   */
   }

   private void getXML1260(Document doc) {
      v.add(doc.createElement("TR"));
      ((Element)v.get(276)).setAttribute("nombre","valNom1WidgetTrId" );
      ((Element)v.get(272)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(277)).setAttribute("align","left" );
      ((Element)v.get(277)).setAttribute("nowrap","true" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(278)).setAttribute("nombre","valNom1" );
      ((Element)v.get(278)).setAttribute("id","datosCampos" );
      ((Element)v.get(278)).setAttribute("trim","S" );
      ((Element)v.get(278)).setAttribute("max","25" );
      ((Element)v.get(278)).setAttribute("onchange","" );
      ((Element)v.get(278)).setAttribute("req","N" );
      ((Element)v.get(278)).setAttribute("size","25" );
      ((Element)v.get(278)).setAttribute("valor","" );
      ((Element)v.get(278)).setAttribute("validacion","" );
      ((Element)v.get(278)).setAttribute("disabled","" );
      ((Element)v.get(278)).setAttribute("onblur","" );
      ((Element)v.get(278)).setAttribute("ontab","ejecutarAccionFoco('maeClienFrm',0, true)" );
      ((Element)v.get(278)).setAttribute("onshtab","ejecutarAccionFoco('maeClienFrm', 0, false)" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */
      /* Termina nodo:276   */
      /* Termina nodo:272   */
      /* Termina nodo:271   */

      /* Empieza nodo:279 / Elemento padre: 270   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(279)).setAttribute("nombre","valNom1GapTdId" );
      ((Element)v.get(279)).setAttribute("nowrap","true" );
      ((Element)v.get(279)).setAttribute("class","datosCampos" );
      ((Element)v.get(270)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(280)).setAttribute("src","b.gif" );
      ((Element)v.get(280)).setAttribute("width","25" );
      ((Element)v.get(280)).setAttribute("height","8" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */

      /* Empieza nodo:281 / Elemento padre: 270   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(281)).setAttribute("width","100%" );
      ((Element)v.get(270)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(282)).setAttribute("src","b.gif" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */
      /* Termina nodo:270   */
      /* Termina nodo:269   */
      /* Termina nodo:268   */
      /* Termina nodo:265   */

      /* Empieza nodo:283 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(283)).setAttribute("nombre","formGapTr7" );
      ((Element)v.get(52)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(284)).setAttribute("align","center" );
      ((Element)v.get(284)).setAttribute("width","8" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(285)).setAttribute("src","b.gif" );
      ((Element)v.get(285)).setAttribute("width","12" );
      ((Element)v.get(285)).setAttribute("height","8" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));
      /* Termina nodo:285   */
      /* Termina nodo:284   */

      /* Empieza nodo:286 / Elemento padre: 283   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(283)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(287)).setAttribute("src","b.gif" );
      ((Element)v.get(287)).setAttribute("width","8" );
      ((Element)v.get(287)).setAttribute("height","8" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:286   */

      /* Empieza nodo:288 / Elemento padre: 283   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(288)).setAttribute("align","center" );
      ((Element)v.get(288)).setAttribute("width","8" );
      ((Element)v.get(283)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(289)).setAttribute("src","b.gif" );
      ((Element)v.get(289)).setAttribute("width","12" );
      ((Element)v.get(289)).setAttribute("height","8" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:288   */
      /* Termina nodo:283   */

      /* Empieza nodo:290 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(290)).setAttribute("nombre","formTr8" );
      ((Element)v.get(52)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(291)).setAttribute("align","center" );
      ((Element)v.get(291)).setAttribute("width","8" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(292)).setAttribute("src","b.gif" );
      ((Element)v.get(292)).setAttribute("width","8" );
      ((Element)v.get(292)).setAttribute("height","12" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));
      /* Termina nodo:292   */
      /* Termina nodo:291   */

      /* Empieza nodo:293 / Elemento padre: 290   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(293)).setAttribute("width","100%" );
      ((Element)v.get(290)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(294)).setAttribute("width","100%" );
      ((Element)v.get(294)).setAttribute("border","0" );
      ((Element)v.get(294)).setAttribute("cellspacing","0" );
      ((Element)v.get(294)).setAttribute("cellpadding","0" );
      ((Element)v.get(294)).setAttribute("align","left" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(295)).setAttribute("align","left" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(294)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(296)).setAttribute("nombre","valNom2TdId" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(297)).setAttribute("width","100%" );
      ((Element)v.get(297)).setAttribute("border","0" );
      ((Element)v.get(297)).setAttribute("cellspacing","0" );
      ((Element)v.get(297)).setAttribute("cellpadding","0" );
      ((Element)v.get(297)).setAttribute("align","left" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(297)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(299)).setAttribute("valign","top" );
      ((Element)v.get(299)).setAttribute("height","13" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(300)).setAttribute("nombre","lblValNom2" );
      ((Element)v.get(300)).setAttribute("alto","13" );
      ((Element)v.get(300)).setAttribute("filas","1" );
      ((Element)v.get(300)).setAttribute("id","datosTitle" );
      ((Element)v.get(300)).setAttribute("cod","MaeClien.valNom2.label" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */
      /* Termina nodo:299   */
      /* Termina nodo:298   */

      /* Empieza nodo:301 / Elemento padre: 297   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(301)).setAttribute("nombre","valNom2WidgetTrId" );
      ((Element)v.get(297)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(302)).setAttribute("align","left" );
      ((Element)v.get(302)).setAttribute("nowrap","true" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(303)).setAttribute("nombre","valNom2" );
      ((Element)v.get(303)).setAttribute("id","datosCampos" );
      ((Element)v.get(303)).setAttribute("trim","S" );
      ((Element)v.get(303)).setAttribute("max","25" );
      ((Element)v.get(303)).setAttribute("onchange","" );
      ((Element)v.get(303)).setAttribute("req","N" );
      ((Element)v.get(303)).setAttribute("size","25" );
      ((Element)v.get(303)).setAttribute("valor","" );
      ((Element)v.get(303)).setAttribute("validacion","" );
      ((Element)v.get(303)).setAttribute("disabled","" );
      ((Element)v.get(303)).setAttribute("onblur","" );
      ((Element)v.get(303)).setAttribute("ontab","ejecutarAccionFoco('maeClienFrm',0, true)" );
      ((Element)v.get(303)).setAttribute("onshtab","ejecutarAccionFoco('maeClienFrm', 0, false)" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */
      /* Termina nodo:302   */
      /* Termina nodo:301   */
      /* Termina nodo:297   */
      /* Termina nodo:296   */

      /* Empieza nodo:304 / Elemento padre: 295   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(304)).setAttribute("nombre","valNom2GapTdId" );
      ((Element)v.get(304)).setAttribute("nowrap","true" );
      ((Element)v.get(304)).setAttribute("class","datosCampos" );
      ((Element)v.get(295)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(305)).setAttribute("src","b.gif" );
      ((Element)v.get(305)).setAttribute("width","25" );
      ((Element)v.get(305)).setAttribute("height","8" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:304   */

      /* Empieza nodo:306 / Elemento padre: 295   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(306)).setAttribute("width","100%" );
      ((Element)v.get(295)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(307)).setAttribute("src","b.gif" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:306   */
      /* Termina nodo:295   */
      /* Termina nodo:294   */
      /* Termina nodo:293   */
      /* Termina nodo:290   */

      /* Empieza nodo:308 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(308)).setAttribute("nombre","formGapTr8" );
      ((Element)v.get(52)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(309)).setAttribute("align","center" );
      ((Element)v.get(309)).setAttribute("width","8" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(310)).setAttribute("src","b.gif" );
      ((Element)v.get(310)).setAttribute("width","12" );
      ((Element)v.get(310)).setAttribute("height","8" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */
      /* Termina nodo:309   */

      /* Empieza nodo:311 / Elemento padre: 308   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(308)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(312)).setAttribute("src","b.gif" );
      ((Element)v.get(312)).setAttribute("width","8" );
      ((Element)v.get(312)).setAttribute("height","8" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */
      /* Termina nodo:311   */

      /* Empieza nodo:313 / Elemento padre: 308   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(313)).setAttribute("align","center" );
      ((Element)v.get(313)).setAttribute("width","8" );
      ((Element)v.get(308)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(314)).setAttribute("src","b.gif" );
      ((Element)v.get(314)).setAttribute("width","12" );
      ((Element)v.get(314)).setAttribute("height","8" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */
      /* Termina nodo:308   */

      /* Empieza nodo:315 / Elemento padre: 52   */
   }

   private void getXML1440(Document doc) {
      v.add(doc.createElement("TR"));
      ((Element)v.get(315)).setAttribute("nombre","formTr9" );
      ((Element)v.get(52)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(316)).setAttribute("align","center" );
      ((Element)v.get(316)).setAttribute("width","8" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(317)).setAttribute("src","b.gif" );
      ((Element)v.get(317)).setAttribute("width","8" );
      ((Element)v.get(317)).setAttribute("height","12" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */
      /* Termina nodo:316   */

      /* Empieza nodo:318 / Elemento padre: 315   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(318)).setAttribute("width","100%" );
      ((Element)v.get(315)).appendChild((Element)v.get(318));

      /* Empieza nodo:319 / Elemento padre: 318   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(319)).setAttribute("width","100%" );
      ((Element)v.get(319)).setAttribute("border","0" );
      ((Element)v.get(319)).setAttribute("cellspacing","0" );
      ((Element)v.get(319)).setAttribute("cellpadding","0" );
      ((Element)v.get(319)).setAttribute("align","left" );
      ((Element)v.get(318)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(320)).setAttribute("align","left" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(321)).setAttribute("nombre","valTratTdId" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(322)).setAttribute("width","100%" );
      ((Element)v.get(322)).setAttribute("border","0" );
      ((Element)v.get(322)).setAttribute("cellspacing","0" );
      ((Element)v.get(322)).setAttribute("cellpadding","0" );
      ((Element)v.get(322)).setAttribute("align","left" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(322)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(324)).setAttribute("valign","top" );
      ((Element)v.get(324)).setAttribute("height","13" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(325)).setAttribute("nombre","lblValTrat" );
      ((Element)v.get(325)).setAttribute("alto","13" );
      ((Element)v.get(325)).setAttribute("filas","1" );
      ((Element)v.get(325)).setAttribute("id","datosTitle" );
      ((Element)v.get(325)).setAttribute("cod","MaeClien.valTrat.label" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */
      /* Termina nodo:323   */

      /* Empieza nodo:326 / Elemento padre: 322   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(326)).setAttribute("nombre","valTratWidgetTrId" );
      ((Element)v.get(322)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(327)).setAttribute("align","left" );
      ((Element)v.get(327)).setAttribute("nowrap","true" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(328)).setAttribute("nombre","valTrat" );
      ((Element)v.get(328)).setAttribute("id","datosCampos" );
      ((Element)v.get(328)).setAttribute("trim","S" );
      ((Element)v.get(328)).setAttribute("max","1" );
      ((Element)v.get(328)).setAttribute("onchange","" );
      ((Element)v.get(328)).setAttribute("req","N" );
      ((Element)v.get(328)).setAttribute("size","1" );
      ((Element)v.get(328)).setAttribute("valor","" );
      ((Element)v.get(328)).setAttribute("validacion","" );
      ((Element)v.get(328)).setAttribute("disabled","" );
      ((Element)v.get(328)).setAttribute("onblur","" );
      ((Element)v.get(328)).setAttribute("ontab","ejecutarAccionFoco('maeClienFrm',0, true)" );
      ((Element)v.get(328)).setAttribute("onshtab","ejecutarAccionFoco('maeClienFrm', 0, false)" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:327   */
      /* Termina nodo:326   */
      /* Termina nodo:322   */
      /* Termina nodo:321   */

      /* Empieza nodo:329 / Elemento padre: 320   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(329)).setAttribute("nombre","valTratGapTdId" );
      ((Element)v.get(329)).setAttribute("nowrap","true" );
      ((Element)v.get(329)).setAttribute("class","datosCampos" );
      ((Element)v.get(320)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(330)).setAttribute("src","b.gif" );
      ((Element)v.get(330)).setAttribute("width","25" );
      ((Element)v.get(330)).setAttribute("height","8" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:331 / Elemento padre: 320   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(331)).setAttribute("width","100%" );
      ((Element)v.get(320)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(332)).setAttribute("src","b.gif" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */
      /* Termina nodo:331   */
      /* Termina nodo:320   */
      /* Termina nodo:319   */
      /* Termina nodo:318   */
      /* Termina nodo:315   */

      /* Empieza nodo:333 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(333)).setAttribute("nombre","formGapTr9" );
      ((Element)v.get(52)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("TD"));
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(334)).setAttribute("align","center" );
      ((Element)v.get(334)).setAttribute("width","8" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(335)).setAttribute("src","b.gif" );
      ((Element)v.get(335)).setAttribute("width","12" );
      ((Element)v.get(335)).setAttribute("height","8" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */
      /* Termina nodo:334   */

      /* Empieza nodo:336 / Elemento padre: 333   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(333)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(337)).setAttribute("src","b.gif" );
      ((Element)v.get(337)).setAttribute("width","8" );
      ((Element)v.get(337)).setAttribute("height","8" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */
      /* Termina nodo:336   */

      /* Empieza nodo:338 / Elemento padre: 333   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(338)).setAttribute("align","center" );
      ((Element)v.get(338)).setAttribute("width","8" );
      ((Element)v.get(333)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(339)).setAttribute("src","b.gif" );
      ((Element)v.get(339)).setAttribute("width","12" );
      ((Element)v.get(339)).setAttribute("height","8" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */
      /* Termina nodo:338   */
      /* Termina nodo:333   */

      /* Empieza nodo:340 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(340)).setAttribute("nombre","formTr10" );
      ((Element)v.get(52)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(341)).setAttribute("align","center" );
      ((Element)v.get(341)).setAttribute("width","8" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(342)).setAttribute("src","b.gif" );
      ((Element)v.get(342)).setAttribute("width","8" );
      ((Element)v.get(342)).setAttribute("height","12" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */

      /* Empieza nodo:343 / Elemento padre: 340   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(343)).setAttribute("width","100%" );
      ((Element)v.get(340)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(344)).setAttribute("width","100%" );
      ((Element)v.get(344)).setAttribute("border","0" );
      ((Element)v.get(344)).setAttribute("cellspacing","0" );
      ((Element)v.get(344)).setAttribute("cellpadding","0" );
      ((Element)v.get(344)).setAttribute("align","left" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(345)).setAttribute("align","left" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(346)).setAttribute("nombre","valCritBus1TdId" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(347)).setAttribute("width","100%" );
      ((Element)v.get(347)).setAttribute("border","0" );
      ((Element)v.get(347)).setAttribute("cellspacing","0" );
      ((Element)v.get(347)).setAttribute("cellpadding","0" );
      ((Element)v.get(347)).setAttribute("align","left" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(347)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(349)).setAttribute("valign","top" );
      ((Element)v.get(349)).setAttribute("height","13" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(350)).setAttribute("nombre","lblValCritBus1" );
      ((Element)v.get(350)).setAttribute("alto","13" );
      ((Element)v.get(350)).setAttribute("filas","1" );
      ((Element)v.get(350)).setAttribute("id","datosTitle" );
      ((Element)v.get(350)).setAttribute("cod","MaeClien.valCritBus1.label" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:349   */
      /* Termina nodo:348   */

      /* Empieza nodo:351 / Elemento padre: 347   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(351)).setAttribute("nombre","valCritBus1WidgetTrId" );
      ((Element)v.get(347)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(352)).setAttribute("align","left" );
      ((Element)v.get(352)).setAttribute("nowrap","true" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(353)).setAttribute("nombre","valCritBus1" );
      ((Element)v.get(353)).setAttribute("id","datosCampos" );
      ((Element)v.get(353)).setAttribute("trim","S" );
      ((Element)v.get(353)).setAttribute("max","50" );
      ((Element)v.get(353)).setAttribute("onchange","" );
      ((Element)v.get(353)).setAttribute("req","N" );
      ((Element)v.get(353)).setAttribute("size","50" );
      ((Element)v.get(353)).setAttribute("valor","" );
      ((Element)v.get(353)).setAttribute("validacion","" );
      ((Element)v.get(353)).setAttribute("disabled","" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(353)).setAttribute("onblur","" );
      ((Element)v.get(353)).setAttribute("ontab","ejecutarAccionFoco('maeClienFrm',0, true)" );
      ((Element)v.get(353)).setAttribute("onshtab","ejecutarAccionFoco('maeClienFrm', 0, false)" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));
      /* Termina nodo:353   */
      /* Termina nodo:352   */
      /* Termina nodo:351   */
      /* Termina nodo:347   */
      /* Termina nodo:346   */

      /* Empieza nodo:354 / Elemento padre: 345   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(354)).setAttribute("nombre","valCritBus1GapTdId" );
      ((Element)v.get(354)).setAttribute("nowrap","true" );
      ((Element)v.get(354)).setAttribute("class","datosCampos" );
      ((Element)v.get(345)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(355)).setAttribute("src","b.gif" );
      ((Element)v.get(355)).setAttribute("width","25" );
      ((Element)v.get(355)).setAttribute("height","8" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */
      /* Termina nodo:354   */

      /* Empieza nodo:356 / Elemento padre: 345   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(356)).setAttribute("width","100%" );
      ((Element)v.get(345)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(357)).setAttribute("src","b.gif" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:356   */
      /* Termina nodo:345   */
      /* Termina nodo:344   */
      /* Termina nodo:343   */
      /* Termina nodo:340   */

      /* Empieza nodo:358 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(358)).setAttribute("nombre","formGapTr10" );
      ((Element)v.get(52)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(359)).setAttribute("align","center" );
      ((Element)v.get(359)).setAttribute("width","8" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(360)).setAttribute("src","b.gif" );
      ((Element)v.get(360)).setAttribute("width","12" );
      ((Element)v.get(360)).setAttribute("height","8" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:359   */

      /* Empieza nodo:361 / Elemento padre: 358   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(358)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(362)).setAttribute("src","b.gif" );
      ((Element)v.get(362)).setAttribute("width","8" );
      ((Element)v.get(362)).setAttribute("height","8" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:361   */

      /* Empieza nodo:363 / Elemento padre: 358   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(363)).setAttribute("align","center" );
      ((Element)v.get(363)).setAttribute("width","8" );
      ((Element)v.get(358)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(364)).setAttribute("src","b.gif" );
      ((Element)v.get(364)).setAttribute("width","12" );
      ((Element)v.get(364)).setAttribute("height","8" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */
      /* Termina nodo:363   */
      /* Termina nodo:358   */

      /* Empieza nodo:365 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(365)).setAttribute("nombre","formTr11" );
      ((Element)v.get(52)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(366)).setAttribute("align","center" );
      ((Element)v.get(366)).setAttribute("width","8" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(367)).setAttribute("src","b.gif" );
      ((Element)v.get(367)).setAttribute("width","8" );
      ((Element)v.get(367)).setAttribute("height","12" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */
      /* Termina nodo:366   */

      /* Empieza nodo:368 / Elemento padre: 365   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(368)).setAttribute("width","100%" );
      ((Element)v.get(365)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(369)).setAttribute("width","100%" );
      ((Element)v.get(369)).setAttribute("border","0" );
      ((Element)v.get(369)).setAttribute("cellspacing","0" );
      ((Element)v.get(369)).setAttribute("cellpadding","0" );
      ((Element)v.get(369)).setAttribute("align","left" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(370)).setAttribute("align","left" );
      ((Element)v.get(369)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(371)).setAttribute("nombre","valCritBus2TdId" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(372)).setAttribute("width","100%" );
      ((Element)v.get(372)).setAttribute("border","0" );
      ((Element)v.get(372)).setAttribute("cellspacing","0" );
      ((Element)v.get(372)).setAttribute("cellpadding","0" );
      ((Element)v.get(372)).setAttribute("align","left" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(372)).appendChild((Element)v.get(373));

      /* Empieza nodo:374 / Elemento padre: 373   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(374)).setAttribute("valign","top" );
      ((Element)v.get(374)).setAttribute("height","13" );
      ((Element)v.get(373)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("LABELC"));
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(375)).setAttribute("nombre","lblValCritBus2" );
      ((Element)v.get(375)).setAttribute("alto","13" );
      ((Element)v.get(375)).setAttribute("filas","1" );
      ((Element)v.get(375)).setAttribute("id","datosTitle" );
      ((Element)v.get(375)).setAttribute("cod","MaeClien.valCritBus2.label" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */
      /* Termina nodo:374   */
      /* Termina nodo:373   */

      /* Empieza nodo:376 / Elemento padre: 372   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(376)).setAttribute("nombre","valCritBus2WidgetTrId" );
      ((Element)v.get(372)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(377)).setAttribute("align","left" );
      ((Element)v.get(377)).setAttribute("nowrap","true" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(378)).setAttribute("nombre","valCritBus2" );
      ((Element)v.get(378)).setAttribute("id","datosCampos" );
      ((Element)v.get(378)).setAttribute("trim","S" );
      ((Element)v.get(378)).setAttribute("max","50" );
      ((Element)v.get(378)).setAttribute("onchange","" );
      ((Element)v.get(378)).setAttribute("req","N" );
      ((Element)v.get(378)).setAttribute("size","50" );
      ((Element)v.get(378)).setAttribute("valor","" );
      ((Element)v.get(378)).setAttribute("validacion","" );
      ((Element)v.get(378)).setAttribute("disabled","" );
      ((Element)v.get(378)).setAttribute("onblur","" );
      ((Element)v.get(378)).setAttribute("ontab","ejecutarAccionFoco('maeClienFrm',0, true)" );
      ((Element)v.get(378)).setAttribute("onshtab","ejecutarAccionFoco('maeClienFrm', 0, false)" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:377   */
      /* Termina nodo:376   */
      /* Termina nodo:372   */
      /* Termina nodo:371   */

      /* Empieza nodo:379 / Elemento padre: 370   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(379)).setAttribute("nombre","valCritBus2GapTdId" );
      ((Element)v.get(379)).setAttribute("nowrap","true" );
      ((Element)v.get(379)).setAttribute("class","datosCampos" );
      ((Element)v.get(370)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(380)).setAttribute("src","b.gif" );
      ((Element)v.get(380)).setAttribute("width","25" );
      ((Element)v.get(380)).setAttribute("height","8" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */
      /* Termina nodo:379   */

      /* Empieza nodo:381 / Elemento padre: 370   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(381)).setAttribute("width","100%" );
      ((Element)v.get(370)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(382)).setAttribute("src","b.gif" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));
      /* Termina nodo:382   */
      /* Termina nodo:381   */
      /* Termina nodo:370   */
      /* Termina nodo:369   */
      /* Termina nodo:368   */
      /* Termina nodo:365   */

      /* Empieza nodo:383 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(383)).setAttribute("nombre","formGapTr11" );
      ((Element)v.get(52)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(384)).setAttribute("align","center" );
      ((Element)v.get(384)).setAttribute("width","8" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(385)).setAttribute("src","b.gif" );
      ((Element)v.get(385)).setAttribute("width","12" );
      ((Element)v.get(385)).setAttribute("height","8" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */
      /* Termina nodo:384   */

      /* Empieza nodo:386 / Elemento padre: 383   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(383)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(387)).setAttribute("src","b.gif" );
      ((Element)v.get(387)).setAttribute("width","8" );
      ((Element)v.get(387)).setAttribute("height","8" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */
      /* Termina nodo:386   */

      /* Empieza nodo:388 / Elemento padre: 383   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(388)).setAttribute("align","center" );
      ((Element)v.get(388)).setAttribute("width","8" );
      ((Element)v.get(383)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(389)).setAttribute("src","b.gif" );
      ((Element)v.get(389)).setAttribute("width","12" );
      ((Element)v.get(389)).setAttribute("height","8" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:388   */
      /* Termina nodo:383   */

      /* Empieza nodo:390 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(390)).setAttribute("nombre","formTr12" );
      ((Element)v.get(52)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(391)).setAttribute("align","center" );
      ((Element)v.get(391)).setAttribute("width","8" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(392)).setAttribute("src","b.gif" );
      ((Element)v.get(392)).setAttribute("width","8" );
      ((Element)v.get(392)).setAttribute("height","12" );
      ((Element)v.get(391)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */
      /* Termina nodo:391   */

      /* Empieza nodo:393 / Elemento padre: 390   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(393)).setAttribute("width","100%" );
      ((Element)v.get(390)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(394)).setAttribute("width","100%" );
      ((Element)v.get(394)).setAttribute("border","0" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(394)).setAttribute("cellspacing","0" );
      ((Element)v.get(394)).setAttribute("cellpadding","0" );
      ((Element)v.get(394)).setAttribute("align","left" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(395)).setAttribute("align","left" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(396)).setAttribute("nombre","codSexoTdId" );
      ((Element)v.get(395)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(397)).setAttribute("width","100%" );
      ((Element)v.get(397)).setAttribute("border","0" );
      ((Element)v.get(397)).setAttribute("cellspacing","0" );
      ((Element)v.get(397)).setAttribute("cellpadding","0" );
      ((Element)v.get(397)).setAttribute("align","left" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(397)).appendChild((Element)v.get(398));

      /* Empieza nodo:399 / Elemento padre: 398   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(399)).setAttribute("valign","top" );
      ((Element)v.get(399)).setAttribute("height","13" );
      ((Element)v.get(398)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(400)).setAttribute("nombre","lblCodSexo" );
      ((Element)v.get(400)).setAttribute("alto","13" );
      ((Element)v.get(400)).setAttribute("filas","1" );
      ((Element)v.get(400)).setAttribute("id","datosTitle" );
      ((Element)v.get(400)).setAttribute("cod","MaeClien.codSexo.label" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));
      /* Termina nodo:400   */
      /* Termina nodo:399   */
      /* Termina nodo:398   */

      /* Empieza nodo:401 / Elemento padre: 397   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(401)).setAttribute("nombre","codSexoWidgetTrId" );
      ((Element)v.get(397)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(402)).setAttribute("align","left" );
      ((Element)v.get(402)).setAttribute("nowrap","true" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(403)).setAttribute("nombre","codSexo" );
      ((Element)v.get(403)).setAttribute("id","datosCampos" );
      ((Element)v.get(403)).setAttribute("trim","S" );
      ((Element)v.get(403)).setAttribute("max","1" );
      ((Element)v.get(403)).setAttribute("onchange","" );
      ((Element)v.get(403)).setAttribute("req","N" );
      ((Element)v.get(403)).setAttribute("size","1" );
      ((Element)v.get(403)).setAttribute("valor","" );
      ((Element)v.get(403)).setAttribute("validacion","" );
      ((Element)v.get(403)).setAttribute("disabled","" );
      ((Element)v.get(403)).setAttribute("onblur","" );
      ((Element)v.get(403)).setAttribute("ontab","ejecutarAccionFoco('maeClienFrm',0, true)" );
      ((Element)v.get(403)).setAttribute("onshtab","ejecutarAccionFoco('maeClienFrm', 0, false)" );
      ((Element)v.get(402)).appendChild((Element)v.get(403));
      /* Termina nodo:403   */
      /* Termina nodo:402   */
      /* Termina nodo:401   */
      /* Termina nodo:397   */
      /* Termina nodo:396   */

      /* Empieza nodo:404 / Elemento padre: 395   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(404)).setAttribute("nombre","codSexoGapTdId" );
      ((Element)v.get(404)).setAttribute("nowrap","true" );
      ((Element)v.get(404)).setAttribute("class","datosCampos" );
      ((Element)v.get(395)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(405)).setAttribute("src","b.gif" );
      ((Element)v.get(405)).setAttribute("width","25" );
      ((Element)v.get(405)).setAttribute("height","8" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));
      /* Termina nodo:405   */
      /* Termina nodo:404   */

      /* Empieza nodo:406 / Elemento padre: 395   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(406)).setAttribute("width","100%" );
      ((Element)v.get(395)).appendChild((Element)v.get(406));

      /* Empieza nodo:407 / Elemento padre: 406   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(407)).setAttribute("src","b.gif" );
      ((Element)v.get(406)).appendChild((Element)v.get(407));
      /* Termina nodo:407   */
      /* Termina nodo:406   */
      /* Termina nodo:395   */
      /* Termina nodo:394   */
      /* Termina nodo:393   */
      /* Termina nodo:390   */

      /* Empieza nodo:408 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(408)).setAttribute("nombre","formGapTr12" );
      ((Element)v.get(52)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(409)).setAttribute("align","center" );
      ((Element)v.get(409)).setAttribute("width","8" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));

      /* Empieza nodo:410 / Elemento padre: 409   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(410)).setAttribute("src","b.gif" );
      ((Element)v.get(410)).setAttribute("width","12" );
      ((Element)v.get(410)).setAttribute("height","8" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));
      /* Termina nodo:410   */
      /* Termina nodo:409   */

      /* Empieza nodo:411 / Elemento padre: 408   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(408)).appendChild((Element)v.get(411));

      /* Empieza nodo:412 / Elemento padre: 411   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(412)).setAttribute("src","b.gif" );
      ((Element)v.get(412)).setAttribute("width","8" );
      ((Element)v.get(412)).setAttribute("height","8" );
      ((Element)v.get(411)).appendChild((Element)v.get(412));
      /* Termina nodo:412   */
      /* Termina nodo:411   */

      /* Empieza nodo:413 / Elemento padre: 408   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(413)).setAttribute("align","center" );
      ((Element)v.get(413)).setAttribute("width","8" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(408)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(414)).setAttribute("src","b.gif" );
      ((Element)v.get(414)).setAttribute("width","12" );
      ((Element)v.get(414)).setAttribute("height","8" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */
      /* Termina nodo:413   */
      /* Termina nodo:408   */

      /* Empieza nodo:415 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(415)).setAttribute("nombre","formTr13" );
      ((Element)v.get(52)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(416)).setAttribute("align","center" );
      ((Element)v.get(416)).setAttribute("width","8" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));

      /* Empieza nodo:417 / Elemento padre: 416   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(417)).setAttribute("src","b.gif" );
      ((Element)v.get(417)).setAttribute("width","8" );
      ((Element)v.get(417)).setAttribute("height","12" );
      ((Element)v.get(416)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */
      /* Termina nodo:416   */

      /* Empieza nodo:418 / Elemento padre: 415   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(418)).setAttribute("width","100%" );
      ((Element)v.get(415)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(419)).setAttribute("width","100%" );
      ((Element)v.get(419)).setAttribute("border","0" );
      ((Element)v.get(419)).setAttribute("cellspacing","0" );
      ((Element)v.get(419)).setAttribute("cellpadding","0" );
      ((Element)v.get(419)).setAttribute("align","left" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));

      /* Empieza nodo:420 / Elemento padre: 419   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(420)).setAttribute("align","left" );
      ((Element)v.get(419)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(421)).setAttribute("nombre","fecIngrTdId" );
      ((Element)v.get(420)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(422)).setAttribute("width","100%" );
      ((Element)v.get(422)).setAttribute("border","0" );
      ((Element)v.get(422)).setAttribute("cellspacing","0" );
      ((Element)v.get(422)).setAttribute("cellpadding","0" );
      ((Element)v.get(422)).setAttribute("align","left" );
      ((Element)v.get(421)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(422)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(424)).setAttribute("valign","top" );
      ((Element)v.get(424)).setAttribute("height","13" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(425)).setAttribute("nombre","lblFecIngr" );
      ((Element)v.get(425)).setAttribute("alto","13" );
      ((Element)v.get(425)).setAttribute("filas","1" );
      ((Element)v.get(425)).setAttribute("id","datosTitle" );
      ((Element)v.get(425)).setAttribute("cod","MaeClien.fecIngr.label" );
      ((Element)v.get(424)).appendChild((Element)v.get(425));
      /* Termina nodo:425   */
      /* Termina nodo:424   */
      /* Termina nodo:423   */

      /* Empieza nodo:426 / Elemento padre: 422   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(426)).setAttribute("nombre","fecIngrWidgetTrId" );
      ((Element)v.get(422)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(427)).setAttribute("align","left" );
      ((Element)v.get(427)).setAttribute("nowrap","true" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(428)).setAttribute("nombre","fecIngr" );
      ((Element)v.get(428)).setAttribute("id","datosCampos" );
      ((Element)v.get(428)).setAttribute("trim","S" );
      ((Element)v.get(428)).setAttribute("max","7" );
      ((Element)v.get(428)).setAttribute("onchange","" );
      ((Element)v.get(428)).setAttribute("req","N" );
      ((Element)v.get(428)).setAttribute("size","7" );
      ((Element)v.get(428)).setAttribute("valor","" );
      ((Element)v.get(428)).setAttribute("validacion","" );
      ((Element)v.get(428)).setAttribute("disabled","" );
      ((Element)v.get(428)).setAttribute("onblur","" );
      ((Element)v.get(428)).setAttribute("ontab","ejecutarAccionFoco('maeClienFrm',0, true)" );
      ((Element)v.get(428)).setAttribute("onshtab","ejecutarAccionFoco('maeClienFrm', 0, false)" );
      ((Element)v.get(427)).appendChild((Element)v.get(428));
      /* Termina nodo:428   */
      /* Termina nodo:427   */
      /* Termina nodo:426   */
      /* Termina nodo:422   */
      /* Termina nodo:421   */

      /* Empieza nodo:429 / Elemento padre: 420   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(429)).setAttribute("nombre","fecIngrGapTdId" );
      ((Element)v.get(429)).setAttribute("nowrap","true" );
      ((Element)v.get(429)).setAttribute("class","datosCampos" );
      ((Element)v.get(420)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(430)).setAttribute("src","b.gif" );
      ((Element)v.get(430)).setAttribute("width","25" );
      ((Element)v.get(430)).setAttribute("height","8" );
      ((Element)v.get(429)).appendChild((Element)v.get(430));
      /* Termina nodo:430   */
      /* Termina nodo:429   */

      /* Empieza nodo:431 / Elemento padre: 420   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(431)).setAttribute("width","100%" );
      ((Element)v.get(420)).appendChild((Element)v.get(431));

      /* Empieza nodo:432 / Elemento padre: 431   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(432)).setAttribute("src","b.gif" );
      ((Element)v.get(431)).appendChild((Element)v.get(432));
      /* Termina nodo:432   */
      /* Termina nodo:431   */
      /* Termina nodo:420   */
      /* Termina nodo:419   */
      /* Termina nodo:418   */
      /* Termina nodo:415   */

      /* Empieza nodo:433 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(433)).setAttribute("nombre","formGapTr13" );
      ((Element)v.get(52)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(434)).setAttribute("align","center" );
      ((Element)v.get(434)).setAttribute("width","8" );
      ((Element)v.get(433)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(435)).setAttribute("src","b.gif" );
      ((Element)v.get(435)).setAttribute("width","12" );
      ((Element)v.get(435)).setAttribute("height","8" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */
      /* Termina nodo:434   */

      /* Empieza nodo:436 / Elemento padre: 433   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(433)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(437)).setAttribute("src","b.gif" );
      ((Element)v.get(437)).setAttribute("width","8" );
      ((Element)v.get(437)).setAttribute("height","8" );
      ((Element)v.get(436)).appendChild((Element)v.get(437));
      /* Termina nodo:437   */
      /* Termina nodo:436   */

      /* Empieza nodo:438 / Elemento padre: 433   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(438)).setAttribute("align","center" );
      ((Element)v.get(438)).setAttribute("width","8" );
      ((Element)v.get(433)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(439)).setAttribute("src","b.gif" );
      ((Element)v.get(439)).setAttribute("width","12" );
      ((Element)v.get(439)).setAttribute("height","8" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));
      /* Termina nodo:439   */
      /* Termina nodo:438   */
      /* Termina nodo:433   */

      /* Empieza nodo:440 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(440)).setAttribute("nombre","formTr14" );
      ((Element)v.get(52)).appendChild((Element)v.get(440));

      /* Empieza nodo:441 / Elemento padre: 440   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(441)).setAttribute("align","center" );
      ((Element)v.get(441)).setAttribute("width","8" );
      ((Element)v.get(440)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(442)).setAttribute("src","b.gif" );
      ((Element)v.get(442)).setAttribute("width","8" );
      ((Element)v.get(442)).setAttribute("height","12" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */
      /* Termina nodo:441   */

      /* Empieza nodo:443 / Elemento padre: 440   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(443)).setAttribute("width","100%" );
      ((Element)v.get(440)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(444)).setAttribute("width","100%" );
      ((Element)v.get(444)).setAttribute("border","0" );
      ((Element)v.get(444)).setAttribute("cellspacing","0" );
      ((Element)v.get(444)).setAttribute("cellpadding","0" );
      ((Element)v.get(444)).setAttribute("align","left" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(445)).setAttribute("align","left" );
      ((Element)v.get(444)).appendChild((Element)v.get(445));

      /* Empieza nodo:446 / Elemento padre: 445   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(446)).setAttribute("nombre","fopaOidFormPagoTdId" );
      ((Element)v.get(445)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(447)).setAttribute("border","0" );
      ((Element)v.get(447)).setAttribute("cellspacing","0" );
      ((Element)v.get(447)).setAttribute("cellpadding","0" );
      ((Element)v.get(447)).setAttribute("align","left" );
      ((Element)v.get(446)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(447)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(449)).setAttribute("valign","top" );
      ((Element)v.get(449)).setAttribute("height","13" );
      ((Element)v.get(448)).appendChild((Element)v.get(449));

      /* Empieza nodo:450 / Elemento padre: 449   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(450)).setAttribute("nombre","lblfopaOidFormPago" );
      ((Element)v.get(450)).setAttribute("id","datosTitle" );
      ((Element)v.get(450)).setAttribute("ancho","150" );
      ((Element)v.get(450)).setAttribute("alto","13" );
      ((Element)v.get(450)).setAttribute("cod","MaeClien.fopaOidFormPago.label" );
      ((Element)v.get(449)).appendChild((Element)v.get(450));
      /* Termina nodo:450   */
      /* Termina nodo:449   */
      /* Termina nodo:448   */

      /* Empieza nodo:451 / Elemento padre: 447   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(451)).setAttribute("nombre","fopaOidFormPagoWidgetTrId" );
      ((Element)v.get(447)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(452)).setAttribute("align","left" );
      ((Element)v.get(452)).setAttribute("nowrap","true" );
      ((Element)v.get(451)).appendChild((Element)v.get(452));

      /* Empieza nodo:453 / Elemento padre: 452   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(453)).setAttribute("nombre","fopaOidFormPago" );
      ((Element)v.get(453)).setAttribute("id","datosCampos" );
      ((Element)v.get(453)).setAttribute("multiple","N" );
      ((Element)v.get(453)).setAttribute("req","N" );
      ((Element)v.get(453)).setAttribute("size","1" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(453)).setAttribute("disabled","" );
      ((Element)v.get(453)).setAttribute("validacion","" );
      ((Element)v.get(453)).setAttribute("onchange","" );
      ((Element)v.get(453)).setAttribute("onfocus","" );
      ((Element)v.get(453)).setAttribute("valorinicial","" );
      ((Element)v.get(453)).setAttribute("textoinicial","" );
      ((Element)v.get(453)).setAttribute("ontab","ejecutarAccionFoco('maeClienFrm',0, true);" );
      ((Element)v.get(453)).setAttribute("onshtab","ejecutarAccionFoco('maeClienFrm',0, false);" );
      ((Element)v.get(452)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(453)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */
      /* Termina nodo:453   */
      /* Termina nodo:452   */
      /* Termina nodo:451   */
      /* Termina nodo:447   */
      /* Termina nodo:446   */

      /* Empieza nodo:455 / Elemento padre: 445   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(455)).setAttribute("nombre","fopaOidFormPagoGapTdId" );
      ((Element)v.get(455)).setAttribute("nowrap","true" );
      ((Element)v.get(455)).setAttribute("class","datosCampos" );
      ((Element)v.get(445)).appendChild((Element)v.get(455));

      /* Empieza nodo:456 / Elemento padre: 455   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(456)).setAttribute("src","b.gif" );
      ((Element)v.get(456)).setAttribute("width","25" );
      ((Element)v.get(456)).setAttribute("height","8" );
      ((Element)v.get(455)).appendChild((Element)v.get(456));
      /* Termina nodo:456   */
      /* Termina nodo:455   */

      /* Empieza nodo:457 / Elemento padre: 445   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(457)).setAttribute("width","100%" );
      ((Element)v.get(445)).appendChild((Element)v.get(457));

      /* Empieza nodo:458 / Elemento padre: 457   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(458)).setAttribute("src","b.gif" );
      ((Element)v.get(457)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */
      /* Termina nodo:457   */
      /* Termina nodo:445   */
      /* Termina nodo:444   */
      /* Termina nodo:443   */
      /* Termina nodo:440   */

      /* Empieza nodo:459 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(459)).setAttribute("nombre","formGapTr14" );
      ((Element)v.get(52)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(460)).setAttribute("align","center" );
      ((Element)v.get(460)).setAttribute("width","8" );
      ((Element)v.get(459)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(461)).setAttribute("src","b.gif" );
      ((Element)v.get(461)).setAttribute("width","12" );
      ((Element)v.get(461)).setAttribute("height","8" );
      ((Element)v.get(460)).appendChild((Element)v.get(461));
      /* Termina nodo:461   */
      /* Termina nodo:460   */

      /* Empieza nodo:462 / Elemento padre: 459   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(459)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(463)).setAttribute("src","b.gif" );
      ((Element)v.get(463)).setAttribute("width","8" );
      ((Element)v.get(463)).setAttribute("height","8" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */
      /* Termina nodo:462   */

      /* Empieza nodo:464 / Elemento padre: 459   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(464)).setAttribute("align","center" );
      ((Element)v.get(464)).setAttribute("width","8" );
      ((Element)v.get(459)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(465)).setAttribute("src","b.gif" );
      ((Element)v.get(465)).setAttribute("width","12" );
      ((Element)v.get(465)).setAttribute("height","8" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));
      /* Termina nodo:465   */
      /* Termina nodo:464   */
      /* Termina nodo:459   */

      /* Empieza nodo:466 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(466)).setAttribute("nombre","formTr15" );
      ((Element)v.get(52)).appendChild((Element)v.get(466));

      /* Empieza nodo:467 / Elemento padre: 466   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(467)).setAttribute("align","center" );
      ((Element)v.get(467)).setAttribute("width","8" );
      ((Element)v.get(466)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(468)).setAttribute("src","b.gif" );
      ((Element)v.get(468)).setAttribute("width","8" );
      ((Element)v.get(468)).setAttribute("height","12" );
      ((Element)v.get(467)).appendChild((Element)v.get(468));
      /* Termina nodo:468   */
      /* Termina nodo:467   */

      /* Empieza nodo:469 / Elemento padre: 466   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(469)).setAttribute("width","100%" );
      ((Element)v.get(466)).appendChild((Element)v.get(469));

      /* Empieza nodo:470 / Elemento padre: 469   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(470)).setAttribute("width","100%" );
      ((Element)v.get(470)).setAttribute("border","0" );
      ((Element)v.get(470)).setAttribute("cellspacing","0" );
      ((Element)v.get(470)).setAttribute("cellpadding","0" );
      ((Element)v.get(470)).setAttribute("align","left" );
      ((Element)v.get(469)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(471)).setAttribute("align","left" );
      ((Element)v.get(470)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(472)).setAttribute("nombre","valApelCasaTdId" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));

      /* Empieza nodo:473 / Elemento padre: 472   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(473)).setAttribute("width","100%" );
      ((Element)v.get(473)).setAttribute("border","0" );
      ((Element)v.get(473)).setAttribute("cellspacing","0" );
      ((Element)v.get(473)).setAttribute("cellpadding","0" );
      ((Element)v.get(473)).setAttribute("align","left" );
      ((Element)v.get(472)).appendChild((Element)v.get(473));

      /* Empieza nodo:474 / Elemento padre: 473   */
   }

   private void getXML2160(Document doc) {
      v.add(doc.createElement("TR"));
      ((Element)v.get(473)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(475)).setAttribute("valign","top" );
      ((Element)v.get(475)).setAttribute("height","13" );
      ((Element)v.get(474)).appendChild((Element)v.get(475));

      /* Empieza nodo:476 / Elemento padre: 475   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(476)).setAttribute("nombre","lblValApelCasa" );
      ((Element)v.get(476)).setAttribute("alto","13" );
      ((Element)v.get(476)).setAttribute("filas","1" );
      ((Element)v.get(476)).setAttribute("id","datosTitle" );
      ((Element)v.get(476)).setAttribute("cod","MaeClien.valApelCasa.label" );
      ((Element)v.get(475)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */
      /* Termina nodo:475   */
      /* Termina nodo:474   */

      /* Empieza nodo:477 / Elemento padre: 473   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(477)).setAttribute("nombre","valApelCasaWidgetTrId" );
      ((Element)v.get(473)).appendChild((Element)v.get(477));

      /* Empieza nodo:478 / Elemento padre: 477   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(478)).setAttribute("align","left" );
      ((Element)v.get(478)).setAttribute("nowrap","true" );
      ((Element)v.get(477)).appendChild((Element)v.get(478));

      /* Empieza nodo:479 / Elemento padre: 478   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(479)).setAttribute("nombre","valApelCasa" );
      ((Element)v.get(479)).setAttribute("id","datosCampos" );
      ((Element)v.get(479)).setAttribute("trim","S" );
      ((Element)v.get(479)).setAttribute("max","25" );
      ((Element)v.get(479)).setAttribute("onchange","" );
      ((Element)v.get(479)).setAttribute("req","N" );
      ((Element)v.get(479)).setAttribute("size","25" );
      ((Element)v.get(479)).setAttribute("valor","" );
      ((Element)v.get(479)).setAttribute("validacion","" );
      ((Element)v.get(479)).setAttribute("disabled","" );
      ((Element)v.get(479)).setAttribute("onblur","" );
      ((Element)v.get(479)).setAttribute("ontab","ejecutarAccionFoco('maeClienFrm',0, true)" );
      ((Element)v.get(479)).setAttribute("onshtab","ejecutarAccionFoco('maeClienFrm', 0, false)" );
      ((Element)v.get(478)).appendChild((Element)v.get(479));
      /* Termina nodo:479   */
      /* Termina nodo:478   */
      /* Termina nodo:477   */
      /* Termina nodo:473   */
      /* Termina nodo:472   */

      /* Empieza nodo:480 / Elemento padre: 471   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(480)).setAttribute("nombre","valApelCasaGapTdId" );
      ((Element)v.get(480)).setAttribute("nowrap","true" );
      ((Element)v.get(480)).setAttribute("class","datosCampos" );
      ((Element)v.get(471)).appendChild((Element)v.get(480));

      /* Empieza nodo:481 / Elemento padre: 480   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(481)).setAttribute("src","b.gif" );
      ((Element)v.get(481)).setAttribute("width","25" );
      ((Element)v.get(481)).setAttribute("height","8" );
      ((Element)v.get(480)).appendChild((Element)v.get(481));
      /* Termina nodo:481   */
      /* Termina nodo:480   */

      /* Empieza nodo:482 / Elemento padre: 471   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(482)).setAttribute("width","100%" );
      ((Element)v.get(471)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(483)).setAttribute("src","b.gif" );
      ((Element)v.get(482)).appendChild((Element)v.get(483));
      /* Termina nodo:483   */
      /* Termina nodo:482   */
      /* Termina nodo:471   */
      /* Termina nodo:470   */
      /* Termina nodo:469   */

      /* Empieza nodo:484 / Elemento padre: 466   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(484)).setAttribute("width","100%" );
      ((Element)v.get(466)).appendChild((Element)v.get(484));
      /* Termina nodo:484   */
      /* Termina nodo:466   */

      /* Empieza nodo:485 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(485)).setAttribute("nombre","formGapTr15" );
      ((Element)v.get(52)).appendChild((Element)v.get(485));

      /* Empieza nodo:486 / Elemento padre: 485   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(486)).setAttribute("align","center" );
      ((Element)v.get(486)).setAttribute("width","8" );
      ((Element)v.get(485)).appendChild((Element)v.get(486));

      /* Empieza nodo:487 / Elemento padre: 486   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(487)).setAttribute("src","b.gif" );
      ((Element)v.get(487)).setAttribute("width","8" );
      ((Element)v.get(487)).setAttribute("height","8" );
      ((Element)v.get(486)).appendChild((Element)v.get(487));
      /* Termina nodo:487   */
      /* Termina nodo:486   */

      /* Empieza nodo:488 / Elemento padre: 485   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(485)).appendChild((Element)v.get(488));

      /* Empieza nodo:489 / Elemento padre: 488   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(489)).setAttribute("src","b.gif" );
      ((Element)v.get(489)).setAttribute("width","8" );
      ((Element)v.get(489)).setAttribute("height","8" );
      ((Element)v.get(488)).appendChild((Element)v.get(489));
      /* Termina nodo:489   */
      /* Termina nodo:488   */

      /* Empieza nodo:490 / Elemento padre: 485   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(490)).setAttribute("align","center" );
      ((Element)v.get(490)).setAttribute("width","8" );
      ((Element)v.get(485)).appendChild((Element)v.get(490));

      /* Empieza nodo:491 / Elemento padre: 490   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(491)).setAttribute("src","b.gif" );
      ((Element)v.get(491)).setAttribute("width","8" );
      ((Element)v.get(491)).setAttribute("height","8" );
      ((Element)v.get(490)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */
      /* Termina nodo:490   */
      /* Termina nodo:485   */
      /* Termina nodo:52   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:492 / Elemento padre: 45   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(492)).setAttribute("align","center" );
      ((Element)v.get(492)).setAttribute("width","12" );
      ((Element)v.get(45)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(493)).setAttribute("src","b.gif" );
      ((Element)v.get(493)).setAttribute("width","12" );
      ((Element)v.get(493)).setAttribute("height","12" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(492)).appendChild((Element)v.get(493));
      /* Termina nodo:493   */
      /* Termina nodo:492   */
      /* Termina nodo:45   */

      /* Empieza nodo:494 / Elemento padre: 37   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(494)).setAttribute("nombre","maeClienTrButtons" );
      ((Element)v.get(37)).appendChild((Element)v.get(494));

      /* Empieza nodo:495 / Elemento padre: 494   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(495)).setAttribute("align","center" );
      ((Element)v.get(495)).setAttribute("width","12" );
      ((Element)v.get(494)).appendChild((Element)v.get(495));

      /* Empieza nodo:496 / Elemento padre: 495   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(496)).setAttribute("src","b.gif" );
      ((Element)v.get(496)).setAttribute("width","12" );
      ((Element)v.get(496)).setAttribute("height","12" );
      ((Element)v.get(495)).appendChild((Element)v.get(496));
      /* Termina nodo:496   */
      /* Termina nodo:495   */

      /* Empieza nodo:497 / Elemento padre: 494   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(494)).appendChild((Element)v.get(497));

      /* Empieza nodo:498 / Elemento padre: 497   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(497)).appendChild((Element)v.get(498));

      /* Empieza nodo:499 / Elemento padre: 498   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(499)).setAttribute("width","100%" );
      ((Element)v.get(499)).setAttribute("border","0" );
      ((Element)v.get(499)).setAttribute("align","center" );
      ((Element)v.get(499)).setAttribute("cellspacing","0" );
      ((Element)v.get(499)).setAttribute("cellpadding","0" );
      ((Element)v.get(498)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(499)).appendChild((Element)v.get(500));

      /* Empieza nodo:501 / Elemento padre: 500   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(501)).setAttribute("class","tablaTitle" );
      ((Element)v.get(501)).setAttribute("nombre","maeClienTdQueryButton" );
      ((Element)v.get(500)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(502)).setAttribute("nombre","maeClienQueryButton" );
      ((Element)v.get(502)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(502)).setAttribute("estado","false" );
      ((Element)v.get(502)).setAttribute("accion","maeClienFirstPage();" );
      ((Element)v.get(502)).setAttribute("tipo","html" );
      ((Element)v.get(502)).setAttribute("ID","botonContenido" );
      ((Element)v.get(501)).appendChild((Element)v.get(502));
      /* Termina nodo:502   */
      /* Termina nodo:501   */

      /* Empieza nodo:503 / Elemento padre: 500   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(503)).setAttribute("class","tablaTitle" );
      ((Element)v.get(503)).setAttribute("nombre","maeClienTdLovNullSelectionButton" );
      ((Element)v.get(503)).setAttribute("align","left" );
      ((Element)v.get(503)).setAttribute("width","100%" );
      ((Element)v.get(500)).appendChild((Element)v.get(503));

      /* Empieza nodo:504 / Elemento padre: 503   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(504)).setAttribute("src","b.gif" );
      ((Element)v.get(504)).setAttribute("height","8" );
      ((Element)v.get(504)).setAttribute("width","8" );
      ((Element)v.get(503)).appendChild((Element)v.get(504));
      /* Termina nodo:504   */

      /* Empieza nodo:505 / Elemento padre: 503   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(505)).setAttribute("nombre","maeClienLovNullButton" );
      ((Element)v.get(505)).setAttribute("ID","botonContenido" );
      ((Element)v.get(505)).setAttribute("tipo","html" );
      ((Element)v.get(505)).setAttribute("accion","maeClienLovNullSelectionAction();" );
      ((Element)v.get(505)).setAttribute("estado","true" );
      ((Element)v.get(505)).setAttribute("cod","MMGGlobal.lovNullButton.label" );
      ((Element)v.get(503)).appendChild((Element)v.get(505));
      /* Termina nodo:505   */
      /* Termina nodo:503   */
      /* Termina nodo:500   */
      /* Termina nodo:499   */
      /* Termina nodo:498   */
      /* Termina nodo:497   */

      /* Empieza nodo:506 / Elemento padre: 494   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(506)).setAttribute("align","center" );
      ((Element)v.get(506)).setAttribute("width","12" );
      ((Element)v.get(494)).appendChild((Element)v.get(506));

      /* Empieza nodo:507 / Elemento padre: 506   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(507)).setAttribute("src","b.gif" );
      ((Element)v.get(507)).setAttribute("width","12" );
      ((Element)v.get(507)).setAttribute("height","12" );
      ((Element)v.get(506)).appendChild((Element)v.get(507));
      /* Termina nodo:507   */
      /* Termina nodo:506   */
      /* Termina nodo:494   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:508 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(508)).setAttribute("nombre","maeClienListLayer" );
      ((Element)v.get(508)).setAttribute("alto","310" );
      ((Element)v.get(508)).setAttribute("ancho","99%" );
      ((Element)v.get(508)).setAttribute("colorf","" );
      ((Element)v.get(508)).setAttribute("borde","0" );
      ((Element)v.get(508)).setAttribute("imagenf","" );
      ((Element)v.get(508)).setAttribute("repeat","" );
      ((Element)v.get(508)).setAttribute("padding","" );
      ((Element)v.get(508)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(508)).setAttribute("contravsb","" );
      ((Element)v.get(508)).setAttribute("x","3" );
      ((Element)v.get(508)).setAttribute("y","" );
      ((Element)v.get(508)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(508));

      /* Empieza nodo:509 / Elemento padre: 508   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(509)).setAttribute("nombre","maeClienList" );
      ((Element)v.get(509)).setAttribute("ancho","680" );
      ((Element)v.get(509)).setAttribute("alto","275" );
      ((Element)v.get(509)).setAttribute("x","12" );
      ((Element)v.get(509)).setAttribute("y","0" );
      ((Element)v.get(509)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(509)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(508)).appendChild((Element)v.get(509));

      /* Empieza nodo:510 / Elemento padre: 509   */
   }

   private void getXML2340(Document doc) {
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(510)).setAttribute("precarga","S" );
      ((Element)v.get(510)).setAttribute("conROver","S" );
      ((Element)v.get(509)).appendChild((Element)v.get(510));

      /* Empieza nodo:511 / Elemento padre: 510   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(511)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(511)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(511)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(511)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(510)).appendChild((Element)v.get(511));
      /* Termina nodo:511   */

      /* Empieza nodo:512 / Elemento padre: 510   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(512)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(512)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(512)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(512)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(510)).appendChild((Element)v.get(512));
      /* Termina nodo:512   */
      /* Termina nodo:510   */

      /* Empieza nodo:513 / Elemento padre: 509   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(509)).appendChild((Element)v.get(513));

      /* Empieza nodo:514 / Elemento padre: 513   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(514)).setAttribute("borde","1" );
      ((Element)v.get(514)).setAttribute("horizDatos","1" );
      ((Element)v.get(514)).setAttribute("horizCabecera","1" );
      ((Element)v.get(514)).setAttribute("vertical","1" );
      ((Element)v.get(514)).setAttribute("horizTitulo","1" );
      ((Element)v.get(514)).setAttribute("horizBase","1" );
      ((Element)v.get(513)).appendChild((Element)v.get(514));
      /* Termina nodo:514   */

      /* Empieza nodo:515 / Elemento padre: 513   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(515)).setAttribute("borde","#999999" );
      ((Element)v.get(515)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(515)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(515)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(515)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(515)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(515)).setAttribute("horizBase","#999999" );
      ((Element)v.get(513)).appendChild((Element)v.get(515));
      /* Termina nodo:515   */
      /* Termina nodo:513   */

      /* Empieza nodo:516 / Elemento padre: 509   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(516)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(516)).setAttribute("alto","22" );
      ((Element)v.get(516)).setAttribute("imgFondo","" );
      ((Element)v.get(516)).setAttribute("cod","00135" );
      ((Element)v.get(516)).setAttribute("ID","datosTitle" );
      ((Element)v.get(509)).appendChild((Element)v.get(516));
      /* Termina nodo:516   */

      /* Empieza nodo:517 / Elemento padre: 509   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(517)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(517)).setAttribute("alto","22" );
      ((Element)v.get(517)).setAttribute("imgFondo","" );
      ((Element)v.get(509)).appendChild((Element)v.get(517));
      /* Termina nodo:517   */

      /* Empieza nodo:518 / Elemento padre: 509   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(518)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(518)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(518)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(518)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(518)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(509)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(519)).setAttribute("ancho","100" );
      ((Element)v.get(519)).setAttribute("minimizable","S" );
      ((Element)v.get(519)).setAttribute("minimizada","N" );
      ((Element)v.get(518)).appendChild((Element)v.get(519));
      /* Termina nodo:519   */

      /* Empieza nodo:520 / Elemento padre: 518   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(520)).setAttribute("ancho","100" );
      ((Element)v.get(520)).setAttribute("minimizable","S" );
      ((Element)v.get(520)).setAttribute("minimizada","N" );
      ((Element)v.get(518)).appendChild((Element)v.get(520));
      /* Termina nodo:520   */

      /* Empieza nodo:521 / Elemento padre: 518   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(521)).setAttribute("ancho","100" );
      ((Element)v.get(521)).setAttribute("minimizable","S" );
      ((Element)v.get(521)).setAttribute("minimizada","N" );
      ((Element)v.get(518)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */

      /* Empieza nodo:522 / Elemento padre: 518   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(522)).setAttribute("ancho","100" );
      ((Element)v.get(522)).setAttribute("minimizable","S" );
      ((Element)v.get(522)).setAttribute("minimizada","N" );
      ((Element)v.get(518)).appendChild((Element)v.get(522));
      /* Termina nodo:522   */

      /* Empieza nodo:523 / Elemento padre: 518   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(523)).setAttribute("ancho","100" );
      ((Element)v.get(523)).setAttribute("minimizable","S" );
      ((Element)v.get(523)).setAttribute("minimizada","N" );
      ((Element)v.get(518)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */

      /* Empieza nodo:524 / Elemento padre: 518   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(524)).setAttribute("ancho","100" );
      ((Element)v.get(524)).setAttribute("minimizable","S" );
      ((Element)v.get(524)).setAttribute("minimizada","N" );
      ((Element)v.get(518)).appendChild((Element)v.get(524));
      /* Termina nodo:524   */

      /* Empieza nodo:525 / Elemento padre: 518   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(525)).setAttribute("ancho","100" );
      ((Element)v.get(525)).setAttribute("minimizable","S" );
      ((Element)v.get(525)).setAttribute("minimizada","N" );
      ((Element)v.get(518)).appendChild((Element)v.get(525));
      /* Termina nodo:525   */

      /* Empieza nodo:526 / Elemento padre: 518   */
      v.add(doc.createElement("COL"));
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(526)).setAttribute("ancho","100" );
      ((Element)v.get(526)).setAttribute("minimizable","S" );
      ((Element)v.get(526)).setAttribute("minimizada","N" );
      ((Element)v.get(518)).appendChild((Element)v.get(526));
      /* Termina nodo:526   */

      /* Empieza nodo:527 / Elemento padre: 518   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(527)).setAttribute("ancho","100" );
      ((Element)v.get(527)).setAttribute("minimizable","S" );
      ((Element)v.get(527)).setAttribute("minimizada","N" );
      ((Element)v.get(518)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */

      /* Empieza nodo:528 / Elemento padre: 518   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(528)).setAttribute("ancho","100" );
      ((Element)v.get(528)).setAttribute("minimizable","S" );
      ((Element)v.get(528)).setAttribute("minimizada","N" );
      ((Element)v.get(518)).appendChild((Element)v.get(528));
      /* Termina nodo:528   */

      /* Empieza nodo:529 / Elemento padre: 518   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(529)).setAttribute("ancho","100" );
      ((Element)v.get(529)).setAttribute("minimizable","S" );
      ((Element)v.get(529)).setAttribute("minimizada","N" );
      ((Element)v.get(518)).appendChild((Element)v.get(529));
      /* Termina nodo:529   */

      /* Empieza nodo:530 / Elemento padre: 518   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(530)).setAttribute("ancho","100" );
      ((Element)v.get(530)).setAttribute("minimizable","S" );
      ((Element)v.get(530)).setAttribute("minimizada","N" );
      ((Element)v.get(518)).appendChild((Element)v.get(530));
      /* Termina nodo:530   */

      /* Empieza nodo:531 / Elemento padre: 518   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(531)).setAttribute("ancho","100" );
      ((Element)v.get(531)).setAttribute("minimizable","S" );
      ((Element)v.get(531)).setAttribute("minimizada","N" );
      ((Element)v.get(518)).appendChild((Element)v.get(531));
      /* Termina nodo:531   */

      /* Empieza nodo:532 / Elemento padre: 518   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(532)).setAttribute("ancho","100" );
      ((Element)v.get(532)).setAttribute("minimizable","S" );
      ((Element)v.get(532)).setAttribute("minimizada","N" );
      ((Element)v.get(518)).appendChild((Element)v.get(532));
      /* Termina nodo:532   */

      /* Empieza nodo:533 / Elemento padre: 518   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(533)).setAttribute("ancho","100" );
      ((Element)v.get(533)).setAttribute("minimizable","S" );
      ((Element)v.get(533)).setAttribute("minimizada","N" );
      ((Element)v.get(518)).appendChild((Element)v.get(533));
      /* Termina nodo:533   */
      /* Termina nodo:518   */

      /* Empieza nodo:534 / Elemento padre: 509   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(534)).setAttribute("height","20" );
      ((Element)v.get(534)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(534)).setAttribute("imgFondo","" );
      ((Element)v.get(534)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(509)).appendChild((Element)v.get(534));

      /* Empieza nodo:535 / Elemento padre: 534   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(535)).setAttribute("colFondo","" );
      ((Element)v.get(535)).setAttribute("ID","EstCab" );
      ((Element)v.get(535)).setAttribute("cod","MaeClien.codClie.label" );
      ((Element)v.get(534)).appendChild((Element)v.get(535));
      /* Termina nodo:535   */

      /* Empieza nodo:536 / Elemento padre: 534   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(536)).setAttribute("colFondo","" );
      ((Element)v.get(536)).setAttribute("ID","EstCab" );
      ((Element)v.get(536)).setAttribute("cod","MaeClien.indFichInsc.label" );
      ((Element)v.get(534)).appendChild((Element)v.get(536));
      /* Termina nodo:536   */

      /* Empieza nodo:537 / Elemento padre: 534   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(537)).setAttribute("colFondo","" );
      ((Element)v.get(537)).setAttribute("ID","EstCab" );
      ((Element)v.get(537)).setAttribute("cod","MaeClien.paisOidPais.label" );
      ((Element)v.get(534)).appendChild((Element)v.get(537));
      /* Termina nodo:537   */

      /* Empieza nodo:538 / Elemento padre: 534   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(538)).setAttribute("colFondo","" );
      ((Element)v.get(538)).setAttribute("ID","EstCab" );
      ((Element)v.get(538)).setAttribute("cod","MaeClien.codDigiCtrl.label" );
      ((Element)v.get(534)).appendChild((Element)v.get(538));
      /* Termina nodo:538   */

      /* Empieza nodo:539 / Elemento padre: 534   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(539)).setAttribute("colFondo","" );
      ((Element)v.get(539)).setAttribute("ID","EstCab" );
      ((Element)v.get(539)).setAttribute("cod","MaeClien.valApe1.label" );
      ((Element)v.get(534)).appendChild((Element)v.get(539));
      /* Termina nodo:539   */

      /* Empieza nodo:540 / Elemento padre: 534   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(540)).setAttribute("colFondo","" );
      ((Element)v.get(540)).setAttribute("ID","EstCab" );
      ((Element)v.get(540)).setAttribute("cod","MaeClien.valApe2.label" );
      ((Element)v.get(534)).appendChild((Element)v.get(540));
      /* Termina nodo:540   */

      /* Empieza nodo:541 / Elemento padre: 534   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(541)).setAttribute("colFondo","" );
      ((Element)v.get(541)).setAttribute("ID","EstCab" );
      ((Element)v.get(541)).setAttribute("cod","MaeClien.valNom1.label" );
      ((Element)v.get(534)).appendChild((Element)v.get(541));
      /* Termina nodo:541   */

      /* Empieza nodo:542 / Elemento padre: 534   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(542)).setAttribute("colFondo","" );
      ((Element)v.get(542)).setAttribute("ID","EstCab" );
      ((Element)v.get(542)).setAttribute("cod","MaeClien.valNom2.label" );
      ((Element)v.get(534)).appendChild((Element)v.get(542));
      /* Termina nodo:542   */

      /* Empieza nodo:543 / Elemento padre: 534   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(543)).setAttribute("colFondo","" );
      ((Element)v.get(543)).setAttribute("ID","EstCab" );
      ((Element)v.get(543)).setAttribute("cod","MaeClien.valTrat.label" );
      ((Element)v.get(534)).appendChild((Element)v.get(543));
      /* Termina nodo:543   */

      /* Empieza nodo:544 / Elemento padre: 534   */
   }

   private void getXML2520(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(544)).setAttribute("colFondo","" );
      ((Element)v.get(544)).setAttribute("ID","EstCab" );
      ((Element)v.get(544)).setAttribute("cod","MaeClien.valCritBus1.label" );
      ((Element)v.get(534)).appendChild((Element)v.get(544));
      /* Termina nodo:544   */

      /* Empieza nodo:545 / Elemento padre: 534   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(545)).setAttribute("colFondo","" );
      ((Element)v.get(545)).setAttribute("ID","EstCab" );
      ((Element)v.get(545)).setAttribute("cod","MaeClien.valCritBus2.label" );
      ((Element)v.get(534)).appendChild((Element)v.get(545));
      /* Termina nodo:545   */

      /* Empieza nodo:546 / Elemento padre: 534   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(546)).setAttribute("colFondo","" );
      ((Element)v.get(546)).setAttribute("ID","EstCab" );
      ((Element)v.get(546)).setAttribute("cod","MaeClien.codSexo.label" );
      ((Element)v.get(534)).appendChild((Element)v.get(546));
      /* Termina nodo:546   */

      /* Empieza nodo:547 / Elemento padre: 534   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(547)).setAttribute("colFondo","" );
      ((Element)v.get(547)).setAttribute("ID","EstCab" );
      ((Element)v.get(547)).setAttribute("cod","MaeClien.fecIngr.label" );
      ((Element)v.get(534)).appendChild((Element)v.get(547));
      /* Termina nodo:547   */

      /* Empieza nodo:548 / Elemento padre: 534   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(548)).setAttribute("colFondo","" );
      ((Element)v.get(548)).setAttribute("ID","EstCab" );
      ((Element)v.get(548)).setAttribute("cod","MaeClien.fopaOidFormPago.label" );
      ((Element)v.get(534)).appendChild((Element)v.get(548));
      /* Termina nodo:548   */

      /* Empieza nodo:549 / Elemento padre: 534   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(549)).setAttribute("colFondo","" );
      ((Element)v.get(549)).setAttribute("ID","EstCab" );
      ((Element)v.get(549)).setAttribute("cod","MaeClien.valApelCasa.label" );
      ((Element)v.get(534)).appendChild((Element)v.get(549));
      /* Termina nodo:549   */
      /* Termina nodo:534   */

      /* Empieza nodo:550 / Elemento padre: 509   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(550)).setAttribute("alto","22" );
      ((Element)v.get(550)).setAttribute("accion","" );
      ((Element)v.get(550)).setAttribute("tipoEnvio","seleccion" );
      ((Element)v.get(550)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(550)).setAttribute("maxSel","1" );
      ((Element)v.get(550)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(550)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(550)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(550)).setAttribute("onLoad","" );
      ((Element)v.get(550)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(509)).appendChild((Element)v.get(550));

      /* Empieza nodo:551 / Elemento padre: 550   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(551)).setAttribute("tipo","texto" );
      ((Element)v.get(551)).setAttribute("ID","EstDat" );
      ((Element)v.get(550)).appendChild((Element)v.get(551));
      /* Termina nodo:551   */

      /* Empieza nodo:552 / Elemento padre: 550   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(552)).setAttribute("tipo","texto" );
      ((Element)v.get(552)).setAttribute("ID","EstDat2" );
      ((Element)v.get(550)).appendChild((Element)v.get(552));
      /* Termina nodo:552   */

      /* Empieza nodo:553 / Elemento padre: 550   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(553)).setAttribute("tipo","texto" );
      ((Element)v.get(553)).setAttribute("ID","EstDat" );
      ((Element)v.get(550)).appendChild((Element)v.get(553));
      /* Termina nodo:553   */

      /* Empieza nodo:554 / Elemento padre: 550   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(554)).setAttribute("tipo","texto" );
      ((Element)v.get(554)).setAttribute("ID","EstDat2" );
      ((Element)v.get(550)).appendChild((Element)v.get(554));
      /* Termina nodo:554   */

      /* Empieza nodo:555 / Elemento padre: 550   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(555)).setAttribute("tipo","texto" );
      ((Element)v.get(555)).setAttribute("ID","EstDat" );
      ((Element)v.get(550)).appendChild((Element)v.get(555));
      /* Termina nodo:555   */

      /* Empieza nodo:556 / Elemento padre: 550   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(556)).setAttribute("tipo","texto" );
      ((Element)v.get(556)).setAttribute("ID","EstDat2" );
      ((Element)v.get(550)).appendChild((Element)v.get(556));
      /* Termina nodo:556   */

      /* Empieza nodo:557 / Elemento padre: 550   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(557)).setAttribute("tipo","texto" );
      ((Element)v.get(557)).setAttribute("ID","EstDat" );
      ((Element)v.get(550)).appendChild((Element)v.get(557));
      /* Termina nodo:557   */

      /* Empieza nodo:558 / Elemento padre: 550   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(558)).setAttribute("tipo","texto" );
      ((Element)v.get(558)).setAttribute("ID","EstDat2" );
      ((Element)v.get(550)).appendChild((Element)v.get(558));
      /* Termina nodo:558   */

      /* Empieza nodo:559 / Elemento padre: 550   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(559)).setAttribute("tipo","texto" );
      ((Element)v.get(559)).setAttribute("ID","EstDat" );
      ((Element)v.get(550)).appendChild((Element)v.get(559));
      /* Termina nodo:559   */

      /* Empieza nodo:560 / Elemento padre: 550   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(560)).setAttribute("tipo","texto" );
      ((Element)v.get(560)).setAttribute("ID","EstDat2" );
      ((Element)v.get(550)).appendChild((Element)v.get(560));
      /* Termina nodo:560   */

      /* Empieza nodo:561 / Elemento padre: 550   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(561)).setAttribute("tipo","texto" );
      ((Element)v.get(561)).setAttribute("ID","EstDat" );
      ((Element)v.get(550)).appendChild((Element)v.get(561));
      /* Termina nodo:561   */

      /* Empieza nodo:562 / Elemento padre: 550   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(562)).setAttribute("tipo","texto" );
      ((Element)v.get(562)).setAttribute("ID","EstDat2" );
      ((Element)v.get(550)).appendChild((Element)v.get(562));
      /* Termina nodo:562   */

      /* Empieza nodo:563 / Elemento padre: 550   */
   }

   private void getXML2610(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(563)).setAttribute("tipo","texto" );
      ((Element)v.get(563)).setAttribute("ID","EstDat" );
      ((Element)v.get(550)).appendChild((Element)v.get(563));
      /* Termina nodo:563   */

      /* Empieza nodo:564 / Elemento padre: 550   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(564)).setAttribute("tipo","texto" );
      ((Element)v.get(564)).setAttribute("ID","EstDat2" );
      ((Element)v.get(550)).appendChild((Element)v.get(564));
      /* Termina nodo:564   */

      /* Empieza nodo:565 / Elemento padre: 550   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(565)).setAttribute("tipo","texto" );
      ((Element)v.get(565)).setAttribute("ID","EstDat" );
      ((Element)v.get(550)).appendChild((Element)v.get(565));
      /* Termina nodo:565   */
      /* Termina nodo:550   */

      /* Empieza nodo:566 / Elemento padre: 509   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(509)).appendChild((Element)v.get(566));
      /* Termina nodo:566   */
      /* Termina nodo:509   */
      /* Termina nodo:508   */

      /* Empieza nodo:567 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(567)).setAttribute("nombre","maeClienListButtonsLayer" );
      ((Element)v.get(567)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(567)).setAttribute("alto","30" );
      ((Element)v.get(567)).setAttribute("ancho","98%" );
      ((Element)v.get(567)).setAttribute("borde","n" );
      ((Element)v.get(567)).setAttribute("imagenf","" );
      ((Element)v.get(567)).setAttribute("repeat","" );
      ((Element)v.get(567)).setAttribute("padding","0" );
      ((Element)v.get(567)).setAttribute("contravsb","" );
      ((Element)v.get(567)).setAttribute("x","16" );
      ((Element)v.get(567)).setAttribute("y","" );
      ((Element)v.get(567)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(567));

      /* Empieza nodo:568 / Elemento padre: 567   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(568)).setAttribute("nombre","toolbarSeparatorLayer" );
      ((Element)v.get(568)).setAttribute("visibilidad","inherit" );
      ((Element)v.get(568)).setAttribute("alto","23" );
      ((Element)v.get(568)).setAttribute("ancho","1" );
      ((Element)v.get(568)).setAttribute("borde","1" );
      ((Element)v.get(568)).setAttribute("imagenf","" );
      ((Element)v.get(568)).setAttribute("repeat","" );
      ((Element)v.get(568)).setAttribute("padding","0" );
      ((Element)v.get(568)).setAttribute("contravsb","" );
      ((Element)v.get(568)).setAttribute("x","56" );
      ((Element)v.get(568)).setAttribute("y","0" );
      ((Element)v.get(568)).setAttribute("zindex","" );
      ((Element)v.get(568)).setAttribute("colborde","#999999" );
      ((Element)v.get(567)).appendChild((Element)v.get(568));
      /* Termina nodo:568   */

      /* Empieza nodo:569 / Elemento padre: 567   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(569)).setAttribute("width","100%" );
      ((Element)v.get(569)).setAttribute("border","0" );
      ((Element)v.get(569)).setAttribute("cellspacing","1" );
      ((Element)v.get(569)).setAttribute("cellpadding","0" );
      ((Element)v.get(567)).appendChild((Element)v.get(569));

      /* Empieza nodo:570 / Elemento padre: 569   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(569)).appendChild((Element)v.get(570));

      /* Empieza nodo:571 / Elemento padre: 570   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(571)).setAttribute("src","b.gif" );
      ((Element)v.get(571)).setAttribute("height","22" );
      ((Element)v.get(571)).setAttribute("width","5" );
      ((Element)v.get(570)).appendChild((Element)v.get(571));
      /* Termina nodo:571   */
      /* Termina nodo:570   */

      /* Empieza nodo:572 / Elemento padre: 569   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(569)).appendChild((Element)v.get(572));

      /* Empieza nodo:573 / Elemento padre: 572   */
      v.add(doc.createElement("BOTONERA"));
      ((Element)v.get(573)).setAttribute("nombre","maeClienPaginationButtonBar" );
      ((Element)v.get(573)).setAttribute("tipo","H" );
      ((Element)v.get(573)).setAttribute("x","0" );
      ((Element)v.get(573)).setAttribute("y","0" );
      ((Element)v.get(572)).appendChild((Element)v.get(573));

      /* Empieza nodo:574 / Elemento padre: 573   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(574)).setAttribute("nombre","maeClienFirstPageButton" );
      ((Element)v.get(574)).setAttribute("funcion","maeClienFirstPage();" );
      ((Element)v.get(574)).setAttribute("off","primera_over0.gif" );
      ((Element)v.get(574)).setAttribute("on","primera_over0.gif" );
      ((Element)v.get(574)).setAttribute("disable","primera_on0.gif" );
      ((Element)v.get(574)).setAttribute("estado","inactivo" );
      ((Element)v.get(573)).appendChild((Element)v.get(574));
      /* Termina nodo:574   */

      /* Empieza nodo:575 / Elemento padre: 573   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(575)).setAttribute("nombre","maeClienFirstPageButtonGapTd" );
      ((Element)v.get(573)).appendChild((Element)v.get(575));

      /* Empieza nodo:576 / Elemento padre: 575   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(576)).setAttribute("src","b.gif" );
      ((Element)v.get(576)).setAttribute("height","8" );
      ((Element)v.get(576)).setAttribute("width","5" );
      ((Element)v.get(575)).appendChild((Element)v.get(576));
      /* Termina nodo:576   */
      /* Termina nodo:575   */

      /* Empieza nodo:577 / Elemento padre: 573   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(577)).setAttribute("nombre","maeClienPreviousPageButton" );
      ((Element)v.get(577)).setAttribute("funcion","maeClienPreviousPage();" );
      ((Element)v.get(577)).setAttribute("off","retroceder_over0.gif" );
      ((Element)v.get(577)).setAttribute("on","retroceder_over0.gif" );
      ((Element)v.get(577)).setAttribute("disable","retroceder_on0.gif" );
      ((Element)v.get(577)).setAttribute("estado","inactivo" );
      ((Element)v.get(573)).appendChild((Element)v.get(577));
      /* Termina nodo:577   */

      /* Empieza nodo:578 / Elemento padre: 573   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(578)).setAttribute("nombre","maeClienPreviousPageButtonGapTd" );
   }

   private void getXML2700(Document doc) {
      ((Element)v.get(573)).appendChild((Element)v.get(578));

      /* Empieza nodo:579 / Elemento padre: 578   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(579)).setAttribute("src","b.gif" );
      ((Element)v.get(579)).setAttribute("height","8" );
      ((Element)v.get(579)).setAttribute("width","8" );
      ((Element)v.get(578)).appendChild((Element)v.get(579));
      /* Termina nodo:579   */
      /* Termina nodo:578   */

      /* Empieza nodo:580 / Elemento padre: 573   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(580)).setAttribute("nombre","maeClienNextPageButton" );
      ((Element)v.get(580)).setAttribute("funcion","maeClienNextPage();" );
      ((Element)v.get(580)).setAttribute("off","avanzar_over0.gif" );
      ((Element)v.get(580)).setAttribute("on","avanzar_over0.gif" );
      ((Element)v.get(580)).setAttribute("disable","avanzar_on0.gif" );
      ((Element)v.get(580)).setAttribute("estado","inactivo" );
      ((Element)v.get(573)).appendChild((Element)v.get(580));
      /* Termina nodo:580   */
      /* Termina nodo:573   */
      /* Termina nodo:572   */

      /* Empieza nodo:581 / Elemento padre: 569   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(569)).appendChild((Element)v.get(581));

      /* Empieza nodo:582 / Elemento padre: 581   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(582)).setAttribute("src","b.gif" );
      ((Element)v.get(582)).setAttribute("height","22" );
      ((Element)v.get(582)).setAttribute("width","19" );
      ((Element)v.get(581)).appendChild((Element)v.get(582));
      /* Termina nodo:582   */
      /* Termina nodo:581   */

      /* Empieza nodo:583 / Elemento padre: 569   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(583)).setAttribute("class","tablaTitle" );
      ((Element)v.get(583)).setAttribute("nombre","maeClienUpdateButtonTd" );
      ((Element)v.get(569)).appendChild((Element)v.get(583));

      /* Empieza nodo:584 / Elemento padre: 583   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(584)).setAttribute("nombre","maeClienUpdateButton" );
      ((Element)v.get(584)).setAttribute("ID","botonContenido" );
      ((Element)v.get(584)).setAttribute("tipo","html" );
      ((Element)v.get(584)).setAttribute("accion","maeClienUpdateSelection();" );
      ((Element)v.get(584)).setAttribute("estado","false" );
      ((Element)v.get(584)).setAttribute("cod","MMGGlobal.updateButton.label" );
      ((Element)v.get(583)).appendChild((Element)v.get(584));
      /* Termina nodo:584   */
      /* Termina nodo:583   */

      /* Empieza nodo:585 / Elemento padre: 569   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(585)).setAttribute("nombre","maeClienUpdateButtonGapTd" );
      ((Element)v.get(569)).appendChild((Element)v.get(585));

      /* Empieza nodo:586 / Elemento padre: 585   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(586)).setAttribute("src","b.gif" );
      ((Element)v.get(586)).setAttribute("height","8" );
      ((Element)v.get(586)).setAttribute("width","10" );
      ((Element)v.get(585)).appendChild((Element)v.get(586));
      /* Termina nodo:586   */
      /* Termina nodo:585   */

      /* Empieza nodo:587 / Elemento padre: 569   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(587)).setAttribute("class","tablaTitle" );
      ((Element)v.get(587)).setAttribute("nombre","maeClienViewForRemoveButtonTd" );
      ((Element)v.get(569)).appendChild((Element)v.get(587));

      /* Empieza nodo:588 / Elemento padre: 587   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(588)).setAttribute("nombre","maeClienViewForRemoveButton" );
      ((Element)v.get(588)).setAttribute("ID","botonContenido" );
      ((Element)v.get(588)).setAttribute("tipo","html" );
      ((Element)v.get(588)).setAttribute("accion","maeClienViewSelection();" );
      ((Element)v.get(588)).setAttribute("estado","false" );
      ((Element)v.get(588)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(587)).appendChild((Element)v.get(588));
      /* Termina nodo:588   */
      /* Termina nodo:587   */

      /* Empieza nodo:589 / Elemento padre: 569   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(589)).setAttribute("nombre","maeClienViewForRemoveButtonGapTd" );
      ((Element)v.get(569)).appendChild((Element)v.get(589));

      /* Empieza nodo:590 / Elemento padre: 589   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(590)).setAttribute("src","b.gif" );
      ((Element)v.get(590)).setAttribute("height","8" );
      ((Element)v.get(590)).setAttribute("width","10" );
      ((Element)v.get(589)).appendChild((Element)v.get(590));
      /* Termina nodo:590   */
      /* Termina nodo:589   */

      /* Empieza nodo:591 / Elemento padre: 569   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(591)).setAttribute("class","tablaTitle" );
      ((Element)v.get(591)).setAttribute("nombre","maeClienLovSelectButtonTd" );
      ((Element)v.get(569)).appendChild((Element)v.get(591));

      /* Empieza nodo:592 / Elemento padre: 591   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(592)).setAttribute("nombre","maeClienLovSelectButton" );
      ((Element)v.get(592)).setAttribute("ID","botonContenido" );
      ((Element)v.get(592)).setAttribute("tipo","html" );
      ((Element)v.get(592)).setAttribute("accion","maeClienLovSelectionAction();" );
      ((Element)v.get(592)).setAttribute("estado","true" );
      ((Element)v.get(592)).setAttribute("cod","MMGGlobal.lovSelectButton.label" );
      ((Element)v.get(591)).appendChild((Element)v.get(592));
      /* Termina nodo:592   */
      /* Termina nodo:591   */

      /* Empieza nodo:593 / Elemento padre: 569   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(593)).setAttribute("nombre","maeClienLovSelectButtonGapTd" );
      ((Element)v.get(569)).appendChild((Element)v.get(593));

      /* Empieza nodo:594 / Elemento padre: 593   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(594)).setAttribute("src","b.gif" );
      ((Element)v.get(594)).setAttribute("height","8" );
      ((Element)v.get(594)).setAttribute("width","10" );
      ((Element)v.get(593)).appendChild((Element)v.get(594));
      /* Termina nodo:594   */
      /* Termina nodo:593   */

      /* Empieza nodo:595 / Elemento padre: 569   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(595)).setAttribute("class","tablaTitle" );
      ((Element)v.get(595)).setAttribute("nombre","maeClienViewButtonTd" );
      ((Element)v.get(569)).appendChild((Element)v.get(595));

      /* Empieza nodo:596 / Elemento padre: 595   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(596)).setAttribute("nombre","maeClienViewButton" );
      ((Element)v.get(596)).setAttribute("ID","botonContenido" );
      ((Element)v.get(596)).setAttribute("tipo","html" );
      ((Element)v.get(596)).setAttribute("accion","maeClienViewSelection();" );
   }

   private void getXML2790(Document doc) {
      ((Element)v.get(596)).setAttribute("estado","false" );
      ((Element)v.get(596)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(595)).appendChild((Element)v.get(596));
      /* Termina nodo:596   */
      /* Termina nodo:595   */

      /* Empieza nodo:597 / Elemento padre: 569   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(597)).setAttribute("nombre","maeClienViewButtonGapTd" );
      ((Element)v.get(569)).appendChild((Element)v.get(597));

      /* Empieza nodo:598 / Elemento padre: 597   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(598)).setAttribute("src","b.gif" );
      ((Element)v.get(598)).setAttribute("height","8" );
      ((Element)v.get(598)).setAttribute("width","10" );
      ((Element)v.get(597)).appendChild((Element)v.get(598));
      /* Termina nodo:598   */
      /* Termina nodo:597   */

      /* Empieza nodo:599 / Elemento padre: 569   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(599)).setAttribute("width","100%" );
      ((Element)v.get(569)).appendChild((Element)v.get(599));
      /* Termina nodo:599   */
      /* Termina nodo:569   */
      /* Termina nodo:567   */
      /* Termina nodo:4   */


   }

}

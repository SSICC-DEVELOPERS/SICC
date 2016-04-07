
import org.w3c.dom.*;
import java.util.ArrayList;

public class BelContrAlmacPage  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","BelContrAlmacPage" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","belContrAlmacInitComponents()" );
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
      ((Element)v.get(3)).setAttribute("src","belcontralmac.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(4)).setAttribute("nombre","belContrAlmacFrm" );
      ((Element)v.get(4)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(5)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(5)).setAttribute("valor","BelContrAlmacLPExecution" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","ON" );
      ((Element)v.get(6)).setAttribute("valor","BelContrAlmacLPExecution" );
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
      ((Element)v.get(36)).setAttribute("nombre","belContrAlmacFormLayer" );
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
      ((Element)v.get(51)).setAttribute("cod","BelContrAlmac.legend.label" );
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
      ((Element)v.get(66)).setAttribute("cod","BelContrAlmac.id.label" );
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
      ((Element)v.get(69)).setAttribute("ontab","ejecutarAccionFoco('belContrAlmacFrm',1, true)" );
      ((Element)v.get(69)).setAttribute("onshtab","ejecutarAccionFoco('belContrAlmacFrm', 1, false)" );
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
      ((Element)v.get(94)).setAttribute("onchange","mmgDependeneChange('sbacOidSbac_acceOidAcce_canaOidCana', 'sbacOidSbac' , 'belContrAlmac')" );
      ((Element)v.get(94)).setAttribute("onfocus","" );
      ((Element)v.get(94)).setAttribute("valorinicial","" );
      ((Element)v.get(94)).setAttribute("textoinicial","" );
      ((Element)v.get(94)).setAttribute("ontab","focaliza('belContrAlmacFrm.sbacOidSbac_acceOidAcce');" );
      ((Element)v.get(94)).setAttribute("onshtab","ejecutarAccionFoco('belContrAlmacFrm',2, false);" );
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
      ((Element)v.get(105)).setAttribute("onchange","mmgDependeneChange('sbacOidSbac_acceOidAcce', 'sbacOidSbac' , 'belContrAlmac')" );
      ((Element)v.get(105)).setAttribute("onfocus","" );
      ((Element)v.get(105)).setAttribute("valorinicial","" );
      ((Element)v.get(105)).setAttribute("textoinicial","" );
      ((Element)v.get(105)).setAttribute("ontab","focaliza('belContrAlmacFrm.sbacOidSbac');" );
      ((Element)v.get(105)).setAttribute("onshtab","focaliza('belContrAlmacFrm.sbacOidSbac_acceOidAcce_canaOidCana');" );
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
      ((Element)v.get(113)).setAttribute("cod","BelContrAlmac.sbacOidSbac.label" );
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
      ((Element)v.get(116)).setAttribute("ontab","ejecutarAccionFoco('belContrAlmacFrm',2, true);" );
      ((Element)v.get(116)).setAttribute("onshtab","focaliza('belContrAlmacFrm.sbacOidSbac_acceOidAcce');" );
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
      ((Element)v.get(135)).setAttribute("nombre","prodOidProdTdId" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("TABLE"));
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
      ((Element)v.get(139)).setAttribute("nombre","lblprodOidProd" );
      ((Element)v.get(139)).setAttribute("id","datosTitle" );
      ((Element)v.get(139)).setAttribute("ancho","150" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(139)).setAttribute("alto","13" );
      ((Element)v.get(139)).setAttribute("cod","BelContrAlmac.prodOidProd.label" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));
      /* Termina nodo:139   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:140 / Elemento padre: 136   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(140)).setAttribute("nombre","prodOidProdWidgetTrId" );
      ((Element)v.get(136)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(141)).setAttribute("align","left" );
      ((Element)v.get(141)).setAttribute("nowrap","true" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(142)).setAttribute("nombre","prodOidProd" );
      ((Element)v.get(142)).setAttribute("id","datosCampos" );
      ((Element)v.get(142)).setAttribute("multiple","N" );
      ((Element)v.get(142)).setAttribute("req","N" );
      ((Element)v.get(142)).setAttribute("size","1" );
      ((Element)v.get(142)).setAttribute("disabled","" );
      ((Element)v.get(142)).setAttribute("validacion","" );
      ((Element)v.get(142)).setAttribute("onchange","" );
      ((Element)v.get(142)).setAttribute("onfocus","" );
      ((Element)v.get(142)).setAttribute("valorinicial","" );
      ((Element)v.get(142)).setAttribute("textoinicial","" );
      ((Element)v.get(142)).setAttribute("ontab","ejecutarAccionFoco('belContrAlmacFrm',3, true);" );
      ((Element)v.get(142)).setAttribute("onshtab","ejecutarAccionFoco('belContrAlmacFrm',3, false);" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:144 / Elemento padre: 134   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(144)).setAttribute("nombre","prodOidProdGapTdId" );
      ((Element)v.get(144)).setAttribute("nowrap","true" );
      ((Element)v.get(144)).setAttribute("class","datosCampos" );
      ((Element)v.get(134)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(145)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).setAttribute("width","25" );
      ((Element)v.get(145)).setAttribute("height","8" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));
      /* Termina nodo:145   */
      /* Termina nodo:144   */

      /* Empieza nodo:146 / Elemento padre: 134   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(146)).setAttribute("nombre","almcOidAlmaTdId" );
      ((Element)v.get(134)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(147)).setAttribute("border","0" );
      ((Element)v.get(147)).setAttribute("cellspacing","0" );
      ((Element)v.get(147)).setAttribute("cellpadding","0" );
      ((Element)v.get(147)).setAttribute("align","left" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(149)).setAttribute("valign","top" );
      ((Element)v.get(149)).setAttribute("height","13" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(150)).setAttribute("nombre","lblalmcOidAlma" );
      ((Element)v.get(150)).setAttribute("id","datosTitle" );
      ((Element)v.get(150)).setAttribute("ancho","150" );
      ((Element)v.get(150)).setAttribute("alto","13" );
      ((Element)v.get(150)).setAttribute("cod","BelContrAlmac.almcOidAlma.label" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:151 / Elemento padre: 147   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(151)).setAttribute("nombre","almcOidAlmaWidgetTrId" );
      ((Element)v.get(147)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(152)).setAttribute("align","left" );
      ((Element)v.get(152)).setAttribute("nowrap","true" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(153)).setAttribute("nombre","almcOidAlma" );
      ((Element)v.get(153)).setAttribute("id","datosCampos" );
      ((Element)v.get(153)).setAttribute("multiple","N" );
      ((Element)v.get(153)).setAttribute("req","N" );
      ((Element)v.get(153)).setAttribute("size","1" );
      ((Element)v.get(153)).setAttribute("disabled","" );
      ((Element)v.get(153)).setAttribute("validacion","" );
      ((Element)v.get(153)).setAttribute("onchange","" );
      ((Element)v.get(153)).setAttribute("onfocus","" );
      ((Element)v.get(153)).setAttribute("valorinicial","" );
      ((Element)v.get(153)).setAttribute("textoinicial","" );
      ((Element)v.get(153)).setAttribute("ontab","ejecutarAccionFoco('belContrAlmacFrm',4, true);" );
      ((Element)v.get(153)).setAttribute("onshtab","ejecutarAccionFoco('belContrAlmacFrm',4, false);" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:155 / Elemento padre: 134   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(155)).setAttribute("nombre","almcOidAlmaGapTdId" );
      ((Element)v.get(155)).setAttribute("nowrap","true" );
      ((Element)v.get(155)).setAttribute("class","datosCampos" );
      ((Element)v.get(134)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(156)).setAttribute("width","25" );
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 134   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(157)).setAttribute("width","100%" );
      ((Element)v.get(134)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:134   */
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:129   */

      /* Empieza nodo:159 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(159)).setAttribute("nombre","formGapTr2" );
      ((Element)v.get(52)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(160)).setAttribute("align","center" );
      ((Element)v.get(160)).setAttribute("width","8" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).setAttribute("width","12" );
      ((Element)v.get(161)).setAttribute("height","8" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 159   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(159)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(163)).setAttribute("src","b.gif" );
      ((Element)v.get(163)).setAttribute("width","8" );
      ((Element)v.get(163)).setAttribute("height","8" );
      ((Element)v.get(162)).appendChild((Element)v.get(163));
      /* Termina nodo:163   */
      /* Termina nodo:162   */

      /* Empieza nodo:164 / Elemento padre: 159   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(164)).setAttribute("align","center" );
      ((Element)v.get(164)).setAttribute("width","8" );
      ((Element)v.get(159)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(165)).setAttribute("src","b.gif" );
      ((Element)v.get(165)).setAttribute("width","12" );
      ((Element)v.get(165)).setAttribute("height","8" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */
      /* Termina nodo:159   */

      /* Empieza nodo:166 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(166)).setAttribute("nombre","formTr3" );
      ((Element)v.get(52)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(167)).setAttribute("align","center" );
      ((Element)v.get(167)).setAttribute("width","8" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","8" );
      ((Element)v.get(168)).setAttribute("height","12" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 166   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(169)).setAttribute("width","100%" );
      ((Element)v.get(166)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(170)).setAttribute("width","100%" );
      ((Element)v.get(170)).setAttribute("border","0" );
      ((Element)v.get(170)).setAttribute("cellspacing","0" );
      ((Element)v.get(170)).setAttribute("cellpadding","0" );
      ((Element)v.get(170)).setAttribute("align","left" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(171)).setAttribute("align","left" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(172)).setAttribute("nombre","valStocMiniTdId" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(173)).setAttribute("width","100%" );
      ((Element)v.get(173)).setAttribute("border","0" );
      ((Element)v.get(173)).setAttribute("cellspacing","0" );
      ((Element)v.get(173)).setAttribute("cellpadding","0" );
      ((Element)v.get(173)).setAttribute("align","left" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(175)).setAttribute("valign","top" );
      ((Element)v.get(175)).setAttribute("height","13" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));

      /* Empieza nodo:176 / Elemento padre: 175   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(176)).setAttribute("nombre","lblValStocMini" );
      ((Element)v.get(176)).setAttribute("alto","13" );
      ((Element)v.get(176)).setAttribute("filas","1" );
      ((Element)v.get(176)).setAttribute("id","datosTitle" );
      ((Element)v.get(176)).setAttribute("cod","BelContrAlmac.valStocMini.label" );
      ((Element)v.get(175)).appendChild((Element)v.get(176));
      /* Termina nodo:176   */
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:177 / Elemento padre: 173   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(177)).setAttribute("nombre","valStocMiniWidgetTrId" );
      ((Element)v.get(173)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(178)).setAttribute("align","left" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(178)).setAttribute("nowrap","true" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(179)).setAttribute("nombre","valStocMini" );
      ((Element)v.get(179)).setAttribute("id","datosCampos" );
      ((Element)v.get(179)).setAttribute("trim","S" );
      ((Element)v.get(179)).setAttribute("max","10" );
      ((Element)v.get(179)).setAttribute("onchange","" );
      ((Element)v.get(179)).setAttribute("req","N" );
      ((Element)v.get(179)).setAttribute("size","10" );
      ((Element)v.get(179)).setAttribute("valor","" );
      ((Element)v.get(179)).setAttribute("validacion","" );
      ((Element)v.get(179)).setAttribute("disabled","" );
      ((Element)v.get(179)).setAttribute("onblur","" );
      ((Element)v.get(179)).setAttribute("ontab","ejecutarAccionFoco('belContrAlmacFrm',5, true)" );
      ((Element)v.get(179)).setAttribute("onshtab","ejecutarAccionFoco('belContrAlmacFrm', 5, false)" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:180 / Elemento padre: 171   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(180)).setAttribute("nombre","valStocMiniGapTdId" );
      ((Element)v.get(180)).setAttribute("nowrap","true" );
      ((Element)v.get(180)).setAttribute("class","datosCampos" );
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
      v.add(doc.createElement("TD"));
      ((Element)v.get(182)).setAttribute("width","100%" );
      ((Element)v.get(171)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(183)).setAttribute("src","b.gif" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:182   */
      /* Termina nodo:171   */
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:166   */

      /* Empieza nodo:184 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(184)).setAttribute("nombre","formGapTr3" );
      ((Element)v.get(52)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(185)).setAttribute("align","center" );
      ((Element)v.get(185)).setAttribute("width","8" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).setAttribute("width","12" );
      ((Element)v.get(186)).setAttribute("height","8" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 184   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(184)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
      ((Element)v.get(188)).setAttribute("width","8" );
      ((Element)v.get(188)).setAttribute("height","8" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */

      /* Empieza nodo:189 / Elemento padre: 184   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(189)).setAttribute("align","center" );
      ((Element)v.get(189)).setAttribute("width","8" );
      ((Element)v.get(184)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(190)).setAttribute("src","b.gif" );
      ((Element)v.get(190)).setAttribute("width","12" );
      ((Element)v.get(190)).setAttribute("height","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:189   */
      /* Termina nodo:184   */

      /* Empieza nodo:191 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(191)).setAttribute("nombre","formTr4" );
      ((Element)v.get(52)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(192)).setAttribute("align","center" );
      ((Element)v.get(192)).setAttribute("width","8" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","8" );
      ((Element)v.get(193)).setAttribute("height","12" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:194 / Elemento padre: 191   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(194)).setAttribute("width","100%" );
      ((Element)v.get(191)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(195)).setAttribute("width","100%" );
      ((Element)v.get(195)).setAttribute("border","0" );
      ((Element)v.get(195)).setAttribute("cellspacing","0" );
      ((Element)v.get(195)).setAttribute("cellpadding","0" );
      ((Element)v.get(195)).setAttribute("align","left" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));

      /* Empieza nodo:196 / Elemento padre: 195   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(196)).setAttribute("align","left" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(197)).setAttribute("nombre","valStocMaxiTdId" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("TABLE"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(198)).setAttribute("width","100%" );
      ((Element)v.get(198)).setAttribute("border","0" );
      ((Element)v.get(198)).setAttribute("cellspacing","0" );
      ((Element)v.get(198)).setAttribute("cellpadding","0" );
      ((Element)v.get(198)).setAttribute("align","left" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));

      /* Empieza nodo:199 / Elemento padre: 198   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(198)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(200)).setAttribute("valign","top" );
      ((Element)v.get(200)).setAttribute("height","13" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(201)).setAttribute("nombre","lblValStocMaxi" );
      ((Element)v.get(201)).setAttribute("alto","13" );
      ((Element)v.get(201)).setAttribute("filas","1" );
      ((Element)v.get(201)).setAttribute("id","datosTitle" );
      ((Element)v.get(201)).setAttribute("cod","BelContrAlmac.valStocMaxi.label" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:202 / Elemento padre: 198   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(202)).setAttribute("nombre","valStocMaxiWidgetTrId" );
      ((Element)v.get(198)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(203)).setAttribute("align","left" );
      ((Element)v.get(203)).setAttribute("nowrap","true" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(204)).setAttribute("nombre","valStocMaxi" );
      ((Element)v.get(204)).setAttribute("id","datosCampos" );
      ((Element)v.get(204)).setAttribute("trim","S" );
      ((Element)v.get(204)).setAttribute("max","10" );
      ((Element)v.get(204)).setAttribute("onchange","" );
      ((Element)v.get(204)).setAttribute("req","N" );
      ((Element)v.get(204)).setAttribute("size","10" );
      ((Element)v.get(204)).setAttribute("valor","" );
      ((Element)v.get(204)).setAttribute("validacion","" );
      ((Element)v.get(204)).setAttribute("disabled","" );
      ((Element)v.get(204)).setAttribute("onblur","" );
      ((Element)v.get(204)).setAttribute("ontab","ejecutarAccionFoco('belContrAlmacFrm',6, true)" );
      ((Element)v.get(204)).setAttribute("onshtab","ejecutarAccionFoco('belContrAlmacFrm', 6, false)" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:203   */
      /* Termina nodo:202   */
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:205 / Elemento padre: 196   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(205)).setAttribute("nombre","valStocMaxiGapTdId" );
      ((Element)v.get(205)).setAttribute("nowrap","true" );
      ((Element)v.get(205)).setAttribute("class","datosCampos" );
      ((Element)v.get(196)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).setAttribute("width","25" );
      ((Element)v.get(206)).setAttribute("height","8" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:207 / Elemento padre: 196   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(207)).setAttribute("width","100%" );
      ((Element)v.get(196)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(208)).setAttribute("src","b.gif" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:196   */
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:191   */

      /* Empieza nodo:209 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(209)).setAttribute("nombre","formGapTr4" );
      ((Element)v.get(52)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(210)).setAttribute("align","center" );
      ((Element)v.get(210)).setAttribute("width","8" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(211)).setAttribute("src","b.gif" );
      ((Element)v.get(211)).setAttribute("width","12" );
      ((Element)v.get(211)).setAttribute("height","8" );
      ((Element)v.get(210)).appendChild((Element)v.get(211));
      /* Termina nodo:211   */
      /* Termina nodo:210   */

      /* Empieza nodo:212 / Elemento padre: 209   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(209)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(213)).setAttribute("src","b.gif" );
      ((Element)v.get(213)).setAttribute("width","8" );
      ((Element)v.get(213)).setAttribute("height","8" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */

      /* Empieza nodo:214 / Elemento padre: 209   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(214)).setAttribute("align","center" );
      ((Element)v.get(214)).setAttribute("width","8" );
      ((Element)v.get(209)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(215)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).setAttribute("width","12" );
      ((Element)v.get(215)).setAttribute("height","8" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */
      /* Termina nodo:209   */

      /* Empieza nodo:216 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(216)).setAttribute("nombre","formTr5" );
      ((Element)v.get(52)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(217)).setAttribute("align","center" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(217)).setAttribute("width","8" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(218)).setAttribute("src","b.gif" );
      ((Element)v.get(218)).setAttribute("width","8" );
      ((Element)v.get(218)).setAttribute("height","12" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:219 / Elemento padre: 216   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(219)).setAttribute("width","100%" );
      ((Element)v.get(216)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(220)).setAttribute("width","100%" );
      ((Element)v.get(220)).setAttribute("border","0" );
      ((Element)v.get(220)).setAttribute("cellspacing","0" );
      ((Element)v.get(220)).setAttribute("cellpadding","0" );
      ((Element)v.get(220)).setAttribute("align","left" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(221)).setAttribute("align","left" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(222)).setAttribute("nombre","valStocRepoTdId" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(223)).setAttribute("width","100%" );
      ((Element)v.get(223)).setAttribute("border","0" );
      ((Element)v.get(223)).setAttribute("cellspacing","0" );
      ((Element)v.get(223)).setAttribute("cellpadding","0" );
      ((Element)v.get(223)).setAttribute("align","left" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(223)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(225)).setAttribute("valign","top" );
      ((Element)v.get(225)).setAttribute("height","13" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(226)).setAttribute("nombre","lblValStocRepo" );
      ((Element)v.get(226)).setAttribute("alto","13" );
      ((Element)v.get(226)).setAttribute("filas","1" );
      ((Element)v.get(226)).setAttribute("id","datosTitle" );
      ((Element)v.get(226)).setAttribute("cod","BelContrAlmac.valStocRepo.label" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:227 / Elemento padre: 223   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(227)).setAttribute("nombre","valStocRepoWidgetTrId" );
      ((Element)v.get(223)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(228)).setAttribute("align","left" );
      ((Element)v.get(228)).setAttribute("nowrap","true" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(229)).setAttribute("nombre","valStocRepo" );
      ((Element)v.get(229)).setAttribute("id","datosCampos" );
      ((Element)v.get(229)).setAttribute("trim","S" );
      ((Element)v.get(229)).setAttribute("max","10" );
      ((Element)v.get(229)).setAttribute("onchange","" );
      ((Element)v.get(229)).setAttribute("req","N" );
      ((Element)v.get(229)).setAttribute("size","10" );
      ((Element)v.get(229)).setAttribute("valor","" );
      ((Element)v.get(229)).setAttribute("validacion","" );
      ((Element)v.get(229)).setAttribute("disabled","" );
      ((Element)v.get(229)).setAttribute("onblur","" );
      ((Element)v.get(229)).setAttribute("ontab","ejecutarAccionFoco('belContrAlmacFrm',7, true)" );
      ((Element)v.get(229)).setAttribute("onshtab","ejecutarAccionFoco('belContrAlmacFrm', 7, false)" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));
      /* Termina nodo:229   */
      /* Termina nodo:228   */
      /* Termina nodo:227   */
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:230 / Elemento padre: 221   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(230)).setAttribute("nombre","valStocRepoGapTdId" );
      ((Element)v.get(230)).setAttribute("nowrap","true" );
      ((Element)v.get(230)).setAttribute("class","datosCampos" );
      ((Element)v.get(221)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(231)).setAttribute("src","b.gif" );
      ((Element)v.get(231)).setAttribute("width","25" );
      ((Element)v.get(231)).setAttribute("height","8" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:232 / Elemento padre: 221   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(232)).setAttribute("width","100%" );
      ((Element)v.get(221)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(233)).setAttribute("src","b.gif" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */
      /* Termina nodo:221   */
      /* Termina nodo:220   */
      /* Termina nodo:219   */
      /* Termina nodo:216   */

      /* Empieza nodo:234 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(234)).setAttribute("nombre","formGapTr5" );
      ((Element)v.get(52)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(235)).setAttribute("align","center" );
      ((Element)v.get(235)).setAttribute("width","8" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(236)).setAttribute("src","b.gif" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(236)).setAttribute("width","12" );
      ((Element)v.get(236)).setAttribute("height","8" );
      ((Element)v.get(235)).appendChild((Element)v.get(236));
      /* Termina nodo:236   */
      /* Termina nodo:235   */

      /* Empieza nodo:237 / Elemento padre: 234   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(234)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(238)).setAttribute("src","b.gif" );
      ((Element)v.get(238)).setAttribute("width","8" );
      ((Element)v.get(238)).setAttribute("height","8" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 234   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(239)).setAttribute("align","center" );
      ((Element)v.get(239)).setAttribute("width","8" );
      ((Element)v.get(234)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(240)).setAttribute("src","b.gif" );
      ((Element)v.get(240)).setAttribute("width","12" );
      ((Element)v.get(240)).setAttribute("height","8" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));
      /* Termina nodo:240   */
      /* Termina nodo:239   */
      /* Termina nodo:234   */

      /* Empieza nodo:241 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(241)).setAttribute("nombre","formTr6" );
      ((Element)v.get(52)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(242)).setAttribute("align","center" );
      ((Element)v.get(242)).setAttribute("width","8" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(243)).setAttribute("src","b.gif" );
      ((Element)v.get(243)).setAttribute("width","8" );
      ((Element)v.get(243)).setAttribute("height","12" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:244 / Elemento padre: 241   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(244)).setAttribute("width","100%" );
      ((Element)v.get(241)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(245)).setAttribute("width","100%" );
      ((Element)v.get(245)).setAttribute("border","0" );
      ((Element)v.get(245)).setAttribute("cellspacing","0" );
      ((Element)v.get(245)).setAttribute("cellpadding","0" );
      ((Element)v.get(245)).setAttribute("align","left" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(246)).setAttribute("align","left" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(247)).setAttribute("nombre","indActiTdId" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(248)).setAttribute("width","100%" );
      ((Element)v.get(248)).setAttribute("border","0" );
      ((Element)v.get(248)).setAttribute("cellspacing","0" );
      ((Element)v.get(248)).setAttribute("cellpadding","0" );
      ((Element)v.get(248)).setAttribute("align","left" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(248)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(250)).setAttribute("valign","top" );
      ((Element)v.get(250)).setAttribute("height","13" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(251)).setAttribute("nombre","lblIndActi" );
      ((Element)v.get(251)).setAttribute("ancho","150" );
      ((Element)v.get(251)).setAttribute("alto","13" );
      ((Element)v.get(251)).setAttribute("filas","1" );
      ((Element)v.get(251)).setAttribute("id","datosTitle" );
      ((Element)v.get(251)).setAttribute("cod","BelContrAlmac.indActi.label" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */
      /* Termina nodo:249   */

      /* Empieza nodo:252 / Elemento padre: 248   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(252)).setAttribute("nombre","indActiWidgetTrId" );
      ((Element)v.get(248)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(253)).setAttribute("align","left" );
      ((Element)v.get(253)).setAttribute("nowrap","true" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(254)).setAttribute("nombre","indActi" );
      ((Element)v.get(254)).setAttribute("id","datosCampos" );
      ((Element)v.get(254)).setAttribute("multiple","N" );
      ((Element)v.get(254)).setAttribute("req","N" );
      ((Element)v.get(254)).setAttribute("size","1" );
      ((Element)v.get(254)).setAttribute("validacion","" );
      ((Element)v.get(254)).setAttribute("onchange","" );
      ((Element)v.get(254)).setAttribute("onfocus","" );
      ((Element)v.get(254)).setAttribute("valorinicial","" );
      ((Element)v.get(254)).setAttribute("textoinicial","" );
      ((Element)v.get(254)).setAttribute("disabled","" );
      ((Element)v.get(254)).setAttribute("ontab","ejecutarAccionFoco('belContrAlmacFrm',8, true)" );
      ((Element)v.get(254)).setAttribute("onshtab","ejecutarAccionFoco('belContrAlmacFrm',8, false)" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
   }

   private void getXML1170(Document doc) {
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(254)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(256)).setAttribute("ID","A" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(257)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(257)).setAttribute("TIPO","STRING" );
      ((Element)v.get(257)).setAttribute("VALOR","A" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */

      /* Empieza nodo:258 / Elemento padre: 256   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(258)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(258)).setAttribute("TIPO","STRING" );
      ((Element)v.get(258)).setAttribute("VALOR","Activo" );
      ((Element)v.get(256)).appendChild((Element)v.get(258));
      /* Termina nodo:258   */
      /* Termina nodo:256   */

      /* Empieza nodo:259 / Elemento padre: 255   */
      v.add(doc.createElement("ROW"));
      ((Element)v.get(259)).setAttribute("ID","I" );
      ((Element)v.get(255)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(260)).setAttribute("NOMBRE","CODIGO" );
      ((Element)v.get(260)).setAttribute("TIPO","STRING" );
      ((Element)v.get(260)).setAttribute("VALOR","I" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */

      /* Empieza nodo:261 / Elemento padre: 259   */
      v.add(doc.createElement("CAMPO"));
      ((Element)v.get(261)).setAttribute("NOMBRE","DESCRIPCION" );
      ((Element)v.get(261)).setAttribute("TIPO","STRING" );
      ((Element)v.get(261)).setAttribute("VALOR","Inactivo" );
      ((Element)v.get(259)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:259   */
      /* Termina nodo:255   */
      /* Termina nodo:254   */
      /* Termina nodo:253   */
      /* Termina nodo:252   */
      /* Termina nodo:248   */
      /* Termina nodo:247   */

      /* Empieza nodo:262 / Elemento padre: 246   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(262)).setAttribute("nombre","indActiGapTdId" );
      ((Element)v.get(262)).setAttribute("nowrap","true" );
      ((Element)v.get(262)).setAttribute("class","datosCampos" );
      ((Element)v.get(246)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(263)).setAttribute("src","b.gif" );
      ((Element)v.get(263)).setAttribute("width","25" );
      ((Element)v.get(263)).setAttribute("height","8" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:264 / Elemento padre: 246   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(264)).setAttribute("width","100%" );
      ((Element)v.get(246)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(265)).setAttribute("src","b.gif" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));
      /* Termina nodo:265   */
      /* Termina nodo:264   */
      /* Termina nodo:246   */
      /* Termina nodo:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:266 / Elemento padre: 241   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(266)).setAttribute("width","100%" );
      ((Element)v.get(241)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:241   */

      /* Empieza nodo:267 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(267)).setAttribute("nombre","formGapTr6" );
      ((Element)v.get(52)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(268)).setAttribute("align","center" );
      ((Element)v.get(268)).setAttribute("width","8" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(269)).setAttribute("src","b.gif" );
      ((Element)v.get(269)).setAttribute("width","8" );
      ((Element)v.get(269)).setAttribute("height","8" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */

      /* Empieza nodo:270 / Elemento padre: 267   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(267)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(271)).setAttribute("width","8" );
      ((Element)v.get(271)).setAttribute("height","8" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */

      /* Empieza nodo:272 / Elemento padre: 267   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(272)).setAttribute("align","center" );
      ((Element)v.get(272)).setAttribute("width","8" );
      ((Element)v.get(267)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(273)).setAttribute("src","b.gif" );
      ((Element)v.get(273)).setAttribute("width","8" );
      ((Element)v.get(273)).setAttribute("height","8" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */
      /* Termina nodo:272   */
      /* Termina nodo:267   */
      /* Termina nodo:52   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:274 / Elemento padre: 45   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(274)).setAttribute("align","center" );
      ((Element)v.get(274)).setAttribute("width","12" );
      ((Element)v.get(45)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(275)).setAttribute("src","b.gif" );
      ((Element)v.get(275)).setAttribute("width","12" );
      ((Element)v.get(275)).setAttribute("height","12" );
      ((Element)v.get(274)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */
      /* Termina nodo:274   */
      /* Termina nodo:45   */

      /* Empieza nodo:276 / Elemento padre: 37   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(276)).setAttribute("nombre","belContrAlmacTrButtons" );
      ((Element)v.get(37)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(277)).setAttribute("align","center" );
      ((Element)v.get(277)).setAttribute("width","12" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(276)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(278)).setAttribute("src","b.gif" );
      ((Element)v.get(278)).setAttribute("width","12" );
      ((Element)v.get(278)).setAttribute("height","12" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));
      /* Termina nodo:278   */
      /* Termina nodo:277   */

      /* Empieza nodo:279 / Elemento padre: 276   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(276)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(279)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(281)).setAttribute("width","100%" );
      ((Element)v.get(281)).setAttribute("border","0" );
      ((Element)v.get(281)).setAttribute("align","center" );
      ((Element)v.get(281)).setAttribute("cellspacing","0" );
      ((Element)v.get(281)).setAttribute("cellpadding","0" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(281)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(283)).setAttribute("class","tablaTitle" );
      ((Element)v.get(283)).setAttribute("nombre","belContrAlmacTdQueryButton" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(284)).setAttribute("nombre","belContrAlmacQueryButton" );
      ((Element)v.get(284)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(284)).setAttribute("estado","false" );
      ((Element)v.get(284)).setAttribute("accion","belContrAlmacFirstPage();" );
      ((Element)v.get(284)).setAttribute("tipo","html" );
      ((Element)v.get(284)).setAttribute("ID","botonContenido" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));
      /* Termina nodo:284   */
      /* Termina nodo:283   */

      /* Empieza nodo:285 / Elemento padre: 282   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(285)).setAttribute("class","tablaTitle" );
      ((Element)v.get(285)).setAttribute("nombre","belContrAlmacTdLovNullSelectionButton" );
      ((Element)v.get(285)).setAttribute("align","left" );
      ((Element)v.get(285)).setAttribute("width","100%" );
      ((Element)v.get(282)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(286)).setAttribute("src","b.gif" );
      ((Element)v.get(286)).setAttribute("height","8" );
      ((Element)v.get(286)).setAttribute("width","8" );
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */

      /* Empieza nodo:287 / Elemento padre: 285   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(287)).setAttribute("nombre","belContrAlmacLovNullButton" );
      ((Element)v.get(287)).setAttribute("ID","botonContenido" );
      ((Element)v.get(287)).setAttribute("tipo","html" );
      ((Element)v.get(287)).setAttribute("accion","belContrAlmacLovNullSelectionAction();" );
      ((Element)v.get(287)).setAttribute("estado","true" );
      ((Element)v.get(287)).setAttribute("cod","MMGGlobal.lovNullButton.label" );
      ((Element)v.get(285)).appendChild((Element)v.get(287));
      /* Termina nodo:287   */
      /* Termina nodo:285   */
      /* Termina nodo:282   */
      /* Termina nodo:281   */
      /* Termina nodo:280   */
      /* Termina nodo:279   */

      /* Empieza nodo:288 / Elemento padre: 276   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(288)).setAttribute("align","center" );
      ((Element)v.get(288)).setAttribute("width","12" );
      ((Element)v.get(276)).appendChild((Element)v.get(288));

      /* Empieza nodo:289 / Elemento padre: 288   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(289)).setAttribute("src","b.gif" );
      ((Element)v.get(289)).setAttribute("width","12" );
      ((Element)v.get(289)).setAttribute("height","12" );
      ((Element)v.get(288)).appendChild((Element)v.get(289));
      /* Termina nodo:289   */
      /* Termina nodo:288   */
      /* Termina nodo:276   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:290 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(290)).setAttribute("nombre","belContrAlmacListLayer" );
      ((Element)v.get(290)).setAttribute("alto","310" );
      ((Element)v.get(290)).setAttribute("ancho","99%" );
      ((Element)v.get(290)).setAttribute("colorf","" );
      ((Element)v.get(290)).setAttribute("borde","0" );
      ((Element)v.get(290)).setAttribute("imagenf","" );
      ((Element)v.get(290)).setAttribute("repeat","" );
      ((Element)v.get(290)).setAttribute("padding","" );
      ((Element)v.get(290)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(290)).setAttribute("contravsb","" );
      ((Element)v.get(290)).setAttribute("x","3" );
      ((Element)v.get(290)).setAttribute("y","" );
      ((Element)v.get(290)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(291)).setAttribute("nombre","belContrAlmacList" );
      ((Element)v.get(291)).setAttribute("ancho","680" );
      ((Element)v.get(291)).setAttribute("alto","275" );
      ((Element)v.get(291)).setAttribute("x","12" );
      ((Element)v.get(291)).setAttribute("y","0" );
      ((Element)v.get(291)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(291)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(292)).setAttribute("precarga","S" );
      ((Element)v.get(292)).setAttribute("conROver","S" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(293)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(293)).setAttribute("rollOver","btnLista2S.gif" );
   }

   private void getXML1350(Document doc) {
      ((Element)v.get(293)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(293)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */

      /* Empieza nodo:294 / Elemento padre: 292   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(294)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(294)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(294)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(294)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(292)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:292   */

      /* Empieza nodo:295 / Elemento padre: 291   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(291)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(296)).setAttribute("borde","1" );
      ((Element)v.get(296)).setAttribute("horizDatos","1" );
      ((Element)v.get(296)).setAttribute("horizCabecera","1" );
      ((Element)v.get(296)).setAttribute("vertical","1" );
      ((Element)v.get(296)).setAttribute("horizTitulo","1" );
      ((Element)v.get(296)).setAttribute("horizBase","1" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */

      /* Empieza nodo:297 / Elemento padre: 295   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(297)).setAttribute("borde","#999999" );
      ((Element)v.get(297)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(297)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(297)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(297)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(297)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(297)).setAttribute("horizBase","#999999" );
      ((Element)v.get(295)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:295   */

      /* Empieza nodo:298 / Elemento padre: 291   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(298)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(298)).setAttribute("alto","22" );
      ((Element)v.get(298)).setAttribute("imgFondo","" );
      ((Element)v.get(298)).setAttribute("cod","00135" );
      ((Element)v.get(298)).setAttribute("ID","datosTitle" );
      ((Element)v.get(291)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */

      /* Empieza nodo:299 / Elemento padre: 291   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(299)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(299)).setAttribute("alto","22" );
      ((Element)v.get(299)).setAttribute("imgFondo","" );
      ((Element)v.get(291)).appendChild((Element)v.get(299));
      /* Termina nodo:299   */

      /* Empieza nodo:300 / Elemento padre: 291   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(300)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(300)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(300)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(300)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(300)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(291)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(301)).setAttribute("ancho","100" );
      ((Element)v.get(301)).setAttribute("minimizable","S" );
      ((Element)v.get(301)).setAttribute("minimizada","N" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */

      /* Empieza nodo:302 / Elemento padre: 300   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(302)).setAttribute("ancho","100" );
      ((Element)v.get(302)).setAttribute("minimizable","S" );
      ((Element)v.get(302)).setAttribute("minimizada","N" );
      ((Element)v.get(300)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */

      /* Empieza nodo:303 / Elemento padre: 300   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(303)).setAttribute("ancho","100" );
      ((Element)v.get(303)).setAttribute("minimizable","S" );
      ((Element)v.get(303)).setAttribute("minimizada","N" );
      ((Element)v.get(300)).appendChild((Element)v.get(303));
      /* Termina nodo:303   */

      /* Empieza nodo:304 / Elemento padre: 300   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(304)).setAttribute("ancho","100" );
      ((Element)v.get(304)).setAttribute("minimizable","S" );
      ((Element)v.get(304)).setAttribute("minimizada","N" );
      ((Element)v.get(300)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */

      /* Empieza nodo:305 / Elemento padre: 300   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(305)).setAttribute("ancho","100" );
      ((Element)v.get(305)).setAttribute("minimizable","S" );
      ((Element)v.get(305)).setAttribute("minimizada","N" );
      ((Element)v.get(300)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */

      /* Empieza nodo:306 / Elemento padre: 300   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(306)).setAttribute("ancho","100" );
      ((Element)v.get(306)).setAttribute("minimizable","S" );
      ((Element)v.get(306)).setAttribute("minimizada","N" );
      ((Element)v.get(300)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */

      /* Empieza nodo:307 / Elemento padre: 300   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(307)).setAttribute("ancho","100" );
      ((Element)v.get(307)).setAttribute("minimizable","S" );
      ((Element)v.get(307)).setAttribute("minimizada","N" );
      ((Element)v.get(300)).appendChild((Element)v.get(307));
      /* Termina nodo:307   */
      /* Termina nodo:300   */

      /* Empieza nodo:308 / Elemento padre: 291   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(308)).setAttribute("height","20" );
      ((Element)v.get(308)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(308)).setAttribute("imgFondo","" );
      ((Element)v.get(308)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(291)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(309)).setAttribute("colFondo","" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(309)).setAttribute("ID","EstCab" );
      ((Element)v.get(309)).setAttribute("cod","BelContrAlmac.sbacOidSbac.label" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));
      /* Termina nodo:309   */

      /* Empieza nodo:310 / Elemento padre: 308   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(310)).setAttribute("colFondo","" );
      ((Element)v.get(310)).setAttribute("ID","EstCab" );
      ((Element)v.get(310)).setAttribute("cod","BelContrAlmac.prodOidProd.label" );
      ((Element)v.get(308)).appendChild((Element)v.get(310));
      /* Termina nodo:310   */

      /* Empieza nodo:311 / Elemento padre: 308   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(311)).setAttribute("colFondo","" );
      ((Element)v.get(311)).setAttribute("ID","EstCab" );
      ((Element)v.get(311)).setAttribute("cod","BelContrAlmac.almcOidAlma.label" );
      ((Element)v.get(308)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */

      /* Empieza nodo:312 / Elemento padre: 308   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(312)).setAttribute("colFondo","" );
      ((Element)v.get(312)).setAttribute("ID","EstCab" );
      ((Element)v.get(312)).setAttribute("cod","BelContrAlmac.valStocMini.label" );
      ((Element)v.get(308)).appendChild((Element)v.get(312));
      /* Termina nodo:312   */

      /* Empieza nodo:313 / Elemento padre: 308   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(313)).setAttribute("colFondo","" );
      ((Element)v.get(313)).setAttribute("ID","EstCab" );
      ((Element)v.get(313)).setAttribute("cod","BelContrAlmac.valStocMaxi.label" );
      ((Element)v.get(308)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */

      /* Empieza nodo:314 / Elemento padre: 308   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(314)).setAttribute("colFondo","" );
      ((Element)v.get(314)).setAttribute("ID","EstCab" );
      ((Element)v.get(314)).setAttribute("cod","BelContrAlmac.valStocRepo.label" );
      ((Element)v.get(308)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */

      /* Empieza nodo:315 / Elemento padre: 308   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(315)).setAttribute("colFondo","" );
      ((Element)v.get(315)).setAttribute("ID","EstCab" );
      ((Element)v.get(315)).setAttribute("cod","BelContrAlmac.indActi.label" );
      ((Element)v.get(308)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:308   */

      /* Empieza nodo:316 / Elemento padre: 291   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(316)).setAttribute("alto","22" );
      ((Element)v.get(316)).setAttribute("accion","" );
      ((Element)v.get(316)).setAttribute("tipoEnvio","seleccion" );
      ((Element)v.get(316)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(316)).setAttribute("maxSel","1" );
      ((Element)v.get(316)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(316)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(316)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(316)).setAttribute("onLoad","" );
      ((Element)v.get(316)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(291)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(317)).setAttribute("tipo","texto" );
      ((Element)v.get(317)).setAttribute("ID","EstDat" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));
      /* Termina nodo:317   */

      /* Empieza nodo:318 / Elemento padre: 316   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(318)).setAttribute("tipo","texto" );
      ((Element)v.get(318)).setAttribute("ID","EstDat2" );
      ((Element)v.get(316)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */

      /* Empieza nodo:319 / Elemento padre: 316   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(319)).setAttribute("tipo","texto" );
      ((Element)v.get(319)).setAttribute("ID","EstDat" );
      ((Element)v.get(316)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */

      /* Empieza nodo:320 / Elemento padre: 316   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(320)).setAttribute("tipo","texto" );
      ((Element)v.get(320)).setAttribute("ID","EstDat2" );
      ((Element)v.get(316)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */

      /* Empieza nodo:321 / Elemento padre: 316   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(321)).setAttribute("tipo","texto" );
      ((Element)v.get(321)).setAttribute("ID","EstDat" );
      ((Element)v.get(316)).appendChild((Element)v.get(321));
      /* Termina nodo:321   */

      /* Empieza nodo:322 / Elemento padre: 316   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(322)).setAttribute("tipo","texto" );
      ((Element)v.get(322)).setAttribute("ID","EstDat2" );
      ((Element)v.get(316)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */

      /* Empieza nodo:323 / Elemento padre: 316   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(323)).setAttribute("tipo","texto" );
      ((Element)v.get(323)).setAttribute("ID","EstDat" );
      ((Element)v.get(316)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:316   */

      /* Empieza nodo:324 / Elemento padre: 291   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(291)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */
      /* Termina nodo:291   */
      /* Termina nodo:290   */

      /* Empieza nodo:325 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(325)).setAttribute("nombre","belContrAlmacListButtonsLayer" );
      ((Element)v.get(325)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(325)).setAttribute("alto","30" );
      ((Element)v.get(325)).setAttribute("ancho","98%" );
      ((Element)v.get(325)).setAttribute("borde","n" );
      ((Element)v.get(325)).setAttribute("imagenf","" );
      ((Element)v.get(325)).setAttribute("repeat","" );
      ((Element)v.get(325)).setAttribute("padding","0" );
      ((Element)v.get(325)).setAttribute("contravsb","" );
      ((Element)v.get(325)).setAttribute("x","16" );
      ((Element)v.get(325)).setAttribute("y","" );
      ((Element)v.get(325)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("CAPA"));
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(326)).setAttribute("nombre","toolbarSeparatorLayer" );
      ((Element)v.get(326)).setAttribute("visibilidad","inherit" );
      ((Element)v.get(326)).setAttribute("alto","23" );
      ((Element)v.get(326)).setAttribute("ancho","1" );
      ((Element)v.get(326)).setAttribute("borde","1" );
      ((Element)v.get(326)).setAttribute("imagenf","" );
      ((Element)v.get(326)).setAttribute("repeat","" );
      ((Element)v.get(326)).setAttribute("padding","0" );
      ((Element)v.get(326)).setAttribute("contravsb","" );
      ((Element)v.get(326)).setAttribute("x","56" );
      ((Element)v.get(326)).setAttribute("y","0" );
      ((Element)v.get(326)).setAttribute("zindex","" );
      ((Element)v.get(326)).setAttribute("colborde","#999999" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */

      /* Empieza nodo:327 / Elemento padre: 325   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(327)).setAttribute("width","100%" );
      ((Element)v.get(327)).setAttribute("border","0" );
      ((Element)v.get(327)).setAttribute("cellspacing","1" );
      ((Element)v.get(327)).setAttribute("cellpadding","0" );
      ((Element)v.get(325)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(327)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(329)).setAttribute("src","b.gif" );
      ((Element)v.get(329)).setAttribute("height","22" );
      ((Element)v.get(329)).setAttribute("width","5" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));
      /* Termina nodo:329   */
      /* Termina nodo:328   */

      /* Empieza nodo:330 / Elemento padre: 327   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(327)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("BOTONERA"));
      ((Element)v.get(331)).setAttribute("nombre","belContrAlmacPaginationButtonBar" );
      ((Element)v.get(331)).setAttribute("tipo","H" );
      ((Element)v.get(331)).setAttribute("x","0" );
      ((Element)v.get(331)).setAttribute("y","0" );
      ((Element)v.get(330)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(332)).setAttribute("nombre","belContrAlmacFirstPageButton" );
      ((Element)v.get(332)).setAttribute("funcion","belContrAlmacFirstPage();" );
      ((Element)v.get(332)).setAttribute("off","primera_over0.gif" );
      ((Element)v.get(332)).setAttribute("on","primera_over0.gif" );
      ((Element)v.get(332)).setAttribute("disable","primera_on0.gif" );
      ((Element)v.get(332)).setAttribute("estado","inactivo" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));
      /* Termina nodo:332   */

      /* Empieza nodo:333 / Elemento padre: 331   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(333)).setAttribute("nombre","belContrAlmacFirstPageButtonGapTd" );
      ((Element)v.get(331)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(334)).setAttribute("src","b.gif" );
      ((Element)v.get(334)).setAttribute("height","8" );
      ((Element)v.get(334)).setAttribute("width","5" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));
      /* Termina nodo:334   */
      /* Termina nodo:333   */

      /* Empieza nodo:335 / Elemento padre: 331   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(335)).setAttribute("nombre","belContrAlmacPreviousPageButton" );
      ((Element)v.get(335)).setAttribute("funcion","belContrAlmacPreviousPage();" );
      ((Element)v.get(335)).setAttribute("off","retroceder_over0.gif" );
      ((Element)v.get(335)).setAttribute("on","retroceder_over0.gif" );
      ((Element)v.get(335)).setAttribute("disable","retroceder_on0.gif" );
      ((Element)v.get(335)).setAttribute("estado","inactivo" );
      ((Element)v.get(331)).appendChild((Element)v.get(335));
      /* Termina nodo:335   */

      /* Empieza nodo:336 / Elemento padre: 331   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(336)).setAttribute("nombre","belContrAlmacPreviousPageButtonGapTd" );
      ((Element)v.get(331)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(337)).setAttribute("src","b.gif" );
      ((Element)v.get(337)).setAttribute("height","8" );
      ((Element)v.get(337)).setAttribute("width","8" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */
      /* Termina nodo:336   */

      /* Empieza nodo:338 / Elemento padre: 331   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(338)).setAttribute("nombre","belContrAlmacNextPageButton" );
      ((Element)v.get(338)).setAttribute("funcion","belContrAlmacNextPage();" );
      ((Element)v.get(338)).setAttribute("off","avanzar_over0.gif" );
      ((Element)v.get(338)).setAttribute("on","avanzar_over0.gif" );
      ((Element)v.get(338)).setAttribute("disable","avanzar_on0.gif" );
      ((Element)v.get(338)).setAttribute("estado","inactivo" );
      ((Element)v.get(331)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:331   */
      /* Termina nodo:330   */

      /* Empieza nodo:339 / Elemento padre: 327   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(327)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(340)).setAttribute("src","b.gif" );
      ((Element)v.get(340)).setAttribute("height","22" );
      ((Element)v.get(340)).setAttribute("width","19" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */

      /* Empieza nodo:341 / Elemento padre: 327   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(341)).setAttribute("class","tablaTitle" );
      ((Element)v.get(341)).setAttribute("nombre","belContrAlmacUpdateButtonTd" );
      ((Element)v.get(327)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(342)).setAttribute("nombre","belContrAlmacUpdateButton" );
      ((Element)v.get(342)).setAttribute("ID","botonContenido" );
      ((Element)v.get(342)).setAttribute("tipo","html" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(342)).setAttribute("accion","belContrAlmacUpdateSelection();" );
      ((Element)v.get(342)).setAttribute("estado","false" );
      ((Element)v.get(342)).setAttribute("cod","MMGGlobal.updateButton.label" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */

      /* Empieza nodo:343 / Elemento padre: 327   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(343)).setAttribute("nombre","belContrAlmacUpdateButtonGapTd" );
      ((Element)v.get(327)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(344)).setAttribute("src","b.gif" );
      ((Element)v.get(344)).setAttribute("height","8" );
      ((Element)v.get(344)).setAttribute("width","10" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));
      /* Termina nodo:344   */
      /* Termina nodo:343   */

      /* Empieza nodo:345 / Elemento padre: 327   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(345)).setAttribute("class","tablaTitle" );
      ((Element)v.get(345)).setAttribute("nombre","belContrAlmacViewForRemoveButtonTd" );
      ((Element)v.get(327)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(346)).setAttribute("nombre","belContrAlmacViewForRemoveButton" );
      ((Element)v.get(346)).setAttribute("ID","botonContenido" );
      ((Element)v.get(346)).setAttribute("tipo","html" );
      ((Element)v.get(346)).setAttribute("accion","belContrAlmacViewSelection();" );
      ((Element)v.get(346)).setAttribute("estado","false" );
      ((Element)v.get(346)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */
      /* Termina nodo:345   */

      /* Empieza nodo:347 / Elemento padre: 327   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(347)).setAttribute("nombre","belContrAlmacViewForRemoveButtonGapTd" );
      ((Element)v.get(327)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(348)).setAttribute("src","b.gif" );
      ((Element)v.get(348)).setAttribute("height","8" );
      ((Element)v.get(348)).setAttribute("width","10" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:347   */

      /* Empieza nodo:349 / Elemento padre: 327   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(349)).setAttribute("class","tablaTitle" );
      ((Element)v.get(349)).setAttribute("nombre","belContrAlmacLovSelectButtonTd" );
      ((Element)v.get(327)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(350)).setAttribute("nombre","belContrAlmacLovSelectButton" );
      ((Element)v.get(350)).setAttribute("ID","botonContenido" );
      ((Element)v.get(350)).setAttribute("tipo","html" );
      ((Element)v.get(350)).setAttribute("accion","belContrAlmacLovSelectionAction();" );
      ((Element)v.get(350)).setAttribute("estado","true" );
      ((Element)v.get(350)).setAttribute("cod","MMGGlobal.lovSelectButton.label" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:349   */

      /* Empieza nodo:351 / Elemento padre: 327   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(351)).setAttribute("nombre","belContrAlmacLovSelectButtonGapTd" );
      ((Element)v.get(327)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(352)).setAttribute("src","b.gif" );
      ((Element)v.get(352)).setAttribute("height","8" );
      ((Element)v.get(352)).setAttribute("width","10" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */
      /* Termina nodo:351   */

      /* Empieza nodo:353 / Elemento padre: 327   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(353)).setAttribute("class","tablaTitle" );
      ((Element)v.get(353)).setAttribute("nombre","belContrAlmacViewButtonTd" );
      ((Element)v.get(327)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(354)).setAttribute("nombre","belContrAlmacViewButton" );
      ((Element)v.get(354)).setAttribute("ID","botonContenido" );
      ((Element)v.get(354)).setAttribute("tipo","html" );
      ((Element)v.get(354)).setAttribute("accion","belContrAlmacViewSelection();" );
      ((Element)v.get(354)).setAttribute("estado","false" );
      ((Element)v.get(354)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */
      /* Termina nodo:353   */

      /* Empieza nodo:355 / Elemento padre: 327   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(355)).setAttribute("nombre","belContrAlmacViewButtonGapTd" );
      ((Element)v.get(327)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(356)).setAttribute("src","b.gif" );
      ((Element)v.get(356)).setAttribute("height","8" );
      ((Element)v.get(356)).setAttribute("width","10" );
      ((Element)v.get(355)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */
      /* Termina nodo:355   */

      /* Empieza nodo:357 / Elemento padre: 327   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(357)).setAttribute("width","100%" );
      ((Element)v.get(327)).appendChild((Element)v.get(357));
      /* Termina nodo:357   */
      /* Termina nodo:327   */
      /* Termina nodo:325   */
      /* Termina nodo:4   */


   }

}


import org.w3c.dom.*;
import java.util.ArrayList;

public class IntAccesBuzonIvrznPage  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","IntAccesBuzonIvrznPage" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","intAccesBuzonIvrznInitComponents()" );
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
      ((Element)v.get(3)).setAttribute("src","intaccesbuzonivrzn.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(4)).setAttribute("nombre","intAccesBuzonIvrznFrm" );
      ((Element)v.get(4)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(5)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(5)).setAttribute("valor","IntAccesBuzonIvrznLPExecution" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","ON" );
      ((Element)v.get(6)).setAttribute("valor","IntAccesBuzonIvrznLPExecution" );
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
      ((Element)v.get(36)).setAttribute("nombre","intAccesBuzonIvrznFormLayer" );
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
      ((Element)v.get(51)).setAttribute("cod","IntAccesBuzonIvrzn.legend.label" );
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
      ((Element)v.get(66)).setAttribute("cod","IntAccesBuzonIvrzn.id.label" );
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
      ((Element)v.get(69)).setAttribute("ontab","ejecutarAccionFoco('intAccesBuzonIvrznFrm',1, true)" );
      ((Element)v.get(69)).setAttribute("onshtab","ejecutarAccionFoco('intAccesBuzonIvrznFrm', 1, false)" );
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
      ((Element)v.get(87)).setAttribute("nombre","codAcceBuzoIvrzTdId" );
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
      ((Element)v.get(91)).setAttribute("nombre","lblCodAcceBuzoIvrz" );
      ((Element)v.get(91)).setAttribute("alto","13" );
      ((Element)v.get(91)).setAttribute("filas","1" );
      ((Element)v.get(91)).setAttribute("id","datosTitle" );
      ((Element)v.get(91)).setAttribute("cod","IntAccesBuzonIvrzn.codAcceBuzoIvrz.label" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */

      /* Empieza nodo:92 / Elemento padre: 88   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(92)).setAttribute("nombre","codAcceBuzoIvrzWidgetTrId" );
      ((Element)v.get(88)).appendChild((Element)v.get(92));

      /* Empieza nodo:93 / Elemento padre: 92   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(93)).setAttribute("align","left" );
      ((Element)v.get(93)).setAttribute("nowrap","true" );
      ((Element)v.get(92)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(94)).setAttribute("nombre","codAcceBuzoIvrz" );
      ((Element)v.get(94)).setAttribute("id","datosCampos" );
      ((Element)v.get(94)).setAttribute("trim","S" );
      ((Element)v.get(94)).setAttribute("max","4" );
      ((Element)v.get(94)).setAttribute("onchange","" );
      ((Element)v.get(94)).setAttribute("req","N" );
      ((Element)v.get(94)).setAttribute("size","4" );
      ((Element)v.get(94)).setAttribute("valor","" );
      ((Element)v.get(94)).setAttribute("validacion","" );
      ((Element)v.get(94)).setAttribute("disabled","" );
      ((Element)v.get(94)).setAttribute("onblur","" );
      ((Element)v.get(94)).setAttribute("ontab","focaliza('intAccesBuzonIvrznFrm.zzonOidZona_marcOidMarc');" );
      ((Element)v.get(94)).setAttribute("onshtab","ejecutarAccionFoco('intAccesBuzonIvrznFrm', 2, false)" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:92   */
      /* Termina nodo:88   */
      /* Termina nodo:87   */

      /* Empieza nodo:95 / Elemento padre: 86   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(95)).setAttribute("nombre","codAcceBuzoIvrzGapTdId" );
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
      ((Element)v.get(112)).setAttribute("nombre","zzonOidZona_marcOidMarcTdId" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("TABLE"));
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
      ((Element)v.get(116)).setAttribute("nombre","lblzzonOidZona_marcOidMarc" );
      ((Element)v.get(116)).setAttribute("id","datosTitle" );
      ((Element)v.get(116)).setAttribute("ancho","150" );
      ((Element)v.get(116)).setAttribute("alto","13" );
      ((Element)v.get(116)).setAttribute("cod","ZonZonaView2.marcOidMarc.label" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));
      /* Termina nodo:116   */
      /* Termina nodo:115   */
      /* Termina nodo:114   */

      /* Empieza nodo:117 / Elemento padre: 113   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(117)).setAttribute("nombre","zzonOidZona_marcOidMarcWidgetTrId" );
      ((Element)v.get(113)).appendChild((Element)v.get(117));

      /* Empieza nodo:118 / Elemento padre: 117   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(118)).setAttribute("align","left" );
      ((Element)v.get(118)).setAttribute("nowrap","true" );
      ((Element)v.get(117)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(119)).setAttribute("nombre","zzonOidZona_marcOidMarc" );
      ((Element)v.get(119)).setAttribute("id","datosCampos" );
      ((Element)v.get(119)).setAttribute("multiple","N" );
      ((Element)v.get(119)).setAttribute("req","N" );
      ((Element)v.get(119)).setAttribute("size","1" );
      ((Element)v.get(119)).setAttribute("disabled","" );
      ((Element)v.get(119)).setAttribute("validacion","" );
      ((Element)v.get(119)).setAttribute("onchange","mmgDependeneChange('zzonOidZona_marcOidMarc', 'zzonOidZona' , 'intAccesBuzonIvrzn')" );
      ((Element)v.get(119)).setAttribute("onfocus","" );
      ((Element)v.get(119)).setAttribute("valorinicial","" );
      ((Element)v.get(119)).setAttribute("textoinicial","" );
      ((Element)v.get(119)).setAttribute("ontab","focaliza('intAccesBuzonIvrznFrm.zzonOidZona_canaOidCana');" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(119)).setAttribute("onshtab","ejecutarAccionFoco('intAccesBuzonIvrznFrm',3, false);" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(119)).appendChild((Element)v.get(120));
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:117   */
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:121 / Elemento padre: 111   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(121)).setAttribute("nombre","zzonOidZona_marcOidMarcGapTdId" );
      ((Element)v.get(121)).setAttribute("nowrap","true" );
      ((Element)v.get(121)).setAttribute("class","datosCampos" );
      ((Element)v.get(111)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("src","b.gif" );
      ((Element)v.get(122)).setAttribute("width","25" );
      ((Element)v.get(122)).setAttribute("height","8" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:123 / Elemento padre: 111   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(123)).setAttribute("nombre","zzonOidZona_canaOidCanaTdId" );
      ((Element)v.get(111)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(124)).setAttribute("border","0" );
      ((Element)v.get(124)).setAttribute("cellspacing","0" );
      ((Element)v.get(124)).setAttribute("cellpadding","0" );
      ((Element)v.get(124)).setAttribute("align","left" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(124)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(126)).setAttribute("valign","top" );
      ((Element)v.get(126)).setAttribute("height","13" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(127)).setAttribute("nombre","lblzzonOidZona_canaOidCana" );
      ((Element)v.get(127)).setAttribute("id","datosTitle" );
      ((Element)v.get(127)).setAttribute("ancho","150" );
      ((Element)v.get(127)).setAttribute("alto","13" );
      ((Element)v.get(127)).setAttribute("cod","ZonZonaView2.canaOidCana.label" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:128 / Elemento padre: 124   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(128)).setAttribute("nombre","zzonOidZona_canaOidCanaWidgetTrId" );
      ((Element)v.get(124)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(129)).setAttribute("align","left" );
      ((Element)v.get(129)).setAttribute("nowrap","true" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(130)).setAttribute("nombre","zzonOidZona_canaOidCana" );
      ((Element)v.get(130)).setAttribute("id","datosCampos" );
      ((Element)v.get(130)).setAttribute("multiple","N" );
      ((Element)v.get(130)).setAttribute("req","N" );
      ((Element)v.get(130)).setAttribute("size","1" );
      ((Element)v.get(130)).setAttribute("disabled","" );
      ((Element)v.get(130)).setAttribute("validacion","" );
      ((Element)v.get(130)).setAttribute("onchange","mmgDependeneChange('zzonOidZona_canaOidCana', 'zzonOidZona' , 'intAccesBuzonIvrzn')" );
      ((Element)v.get(130)).setAttribute("onfocus","" );
      ((Element)v.get(130)).setAttribute("valorinicial","" );
      ((Element)v.get(130)).setAttribute("textoinicial","" );
      ((Element)v.get(130)).setAttribute("ontab","focaliza('intAccesBuzonIvrznFrm.zzonOidZona');" );
      ((Element)v.get(130)).setAttribute("onshtab","focaliza('intAccesBuzonIvrznFrm.zzonOidZona_marcOidMarc');" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:132 / Elemento padre: 111   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(132)).setAttribute("nombre","zzonOidZona_canaOidCanaGapTdId" );
      ((Element)v.get(132)).setAttribute("nowrap","true" );
      ((Element)v.get(132)).setAttribute("class","datosCampos" );
      ((Element)v.get(111)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(133)).setAttribute("width","25" );
      ((Element)v.get(133)).setAttribute("height","8" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */

      /* Empieza nodo:134 / Elemento padre: 111   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(134)).setAttribute("nombre","zzonOidZonaTdId" );
      ((Element)v.get(111)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(135)).setAttribute("border","0" );
      ((Element)v.get(135)).setAttribute("cellspacing","0" );
      ((Element)v.get(135)).setAttribute("cellpadding","0" );
      ((Element)v.get(135)).setAttribute("align","left" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(135)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(137)).setAttribute("valign","top" );
      ((Element)v.get(137)).setAttribute("height","13" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(138)).setAttribute("nombre","lblzzonOidZona" );
      ((Element)v.get(138)).setAttribute("id","datosTitle" );
      ((Element)v.get(138)).setAttribute("ancho","150" );
      ((Element)v.get(138)).setAttribute("alto","13" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(138)).setAttribute("cod","IntAccesBuzonIvrzn.zzonOidZona.label" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:136   */

      /* Empieza nodo:139 / Elemento padre: 135   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(139)).setAttribute("nombre","zzonOidZonaWidgetTrId" );
      ((Element)v.get(135)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(140)).setAttribute("align","left" );
      ((Element)v.get(140)).setAttribute("nowrap","true" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(141)).setAttribute("nombre","zzonOidZona" );
      ((Element)v.get(141)).setAttribute("id","datosCampos" );
      ((Element)v.get(141)).setAttribute("multiple","N" );
      ((Element)v.get(141)).setAttribute("req","N" );
      ((Element)v.get(141)).setAttribute("size","1" );
      ((Element)v.get(141)).setAttribute("disabled","" );
      ((Element)v.get(141)).setAttribute("validacion","" );
      ((Element)v.get(141)).setAttribute("onchange","" );
      ((Element)v.get(141)).setAttribute("onfocus","" );
      ((Element)v.get(141)).setAttribute("valorinicial","" );
      ((Element)v.get(141)).setAttribute("textoinicial","" );
      ((Element)v.get(141)).setAttribute("ontab","ejecutarAccionFoco('intAccesBuzonIvrznFrm',3, true);" );
      ((Element)v.get(141)).setAttribute("onshtab","focaliza('intAccesBuzonIvrznFrm.zzonOidZona_canaOidCana');" );
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:143 / Elemento padre: 111   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(143)).setAttribute("nombre","zzonOidZonaGapTdId" );
      ((Element)v.get(143)).setAttribute("nowrap","true" );
      ((Element)v.get(143)).setAttribute("class","datosCampos" );
      ((Element)v.get(111)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","25" );
      ((Element)v.get(144)).setAttribute("height","8" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */

      /* Empieza nodo:145 / Elemento padre: 111   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(145)).setAttribute("width","100%" );
      ((Element)v.get(111)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(146)).setAttribute("src","b.gif" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:147 / Elemento padre: 106   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(147)).setAttribute("width","100%" );
      ((Element)v.get(106)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:106   */

      /* Empieza nodo:148 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(148)).setAttribute("nombre","formGapTr2" );
      ((Element)v.get(52)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(149)).setAttribute("align","center" );
      ((Element)v.get(149)).setAttribute("width","8" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(150)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).setAttribute("width","8" );
      ((Element)v.get(150)).setAttribute("height","8" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:151 / Elemento padre: 148   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(148)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(152)).setAttribute("src","b.gif" );
      ((Element)v.get(152)).setAttribute("width","8" );
      ((Element)v.get(152)).setAttribute("height","8" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:153 / Elemento padre: 148   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(153)).setAttribute("align","center" );
      ((Element)v.get(153)).setAttribute("width","8" );
      ((Element)v.get(148)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).setAttribute("width","8" );
      ((Element)v.get(154)).setAttribute("height","8" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:148   */
      /* Termina nodo:52   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:155 / Elemento padre: 45   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(155)).setAttribute("align","center" );
      ((Element)v.get(155)).setAttribute("width","12" );
      ((Element)v.get(45)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","12" );
      ((Element)v.get(156)).setAttribute("height","12" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */
      /* Termina nodo:45   */

      /* Empieza nodo:157 / Elemento padre: 37   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(157)).setAttribute("nombre","intAccesBuzonIvrznTrButtons" );
      ((Element)v.get(37)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(158)).setAttribute("align","center" );
      ((Element)v.get(158)).setAttribute("width","12" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(159)).setAttribute("src","b.gif" );
      ((Element)v.get(159)).setAttribute("width","12" );
      ((Element)v.get(159)).setAttribute("height","12" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:160 / Elemento padre: 157   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(157)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(162)).setAttribute("width","100%" );
      ((Element)v.get(162)).setAttribute("border","0" );
      ((Element)v.get(162)).setAttribute("align","center" );
      ((Element)v.get(162)).setAttribute("cellspacing","0" );
      ((Element)v.get(162)).setAttribute("cellpadding","0" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(164)).setAttribute("class","tablaTitle" );
      ((Element)v.get(164)).setAttribute("nombre","intAccesBuzonIvrznTdQueryButton" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(165)).setAttribute("nombre","intAccesBuzonIvrznQueryButton" );
      ((Element)v.get(165)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(165)).setAttribute("estado","false" );
      ((Element)v.get(165)).setAttribute("accion","intAccesBuzonIvrznFirstPage();" );
      ((Element)v.get(165)).setAttribute("tipo","html" );
      ((Element)v.get(165)).setAttribute("ID","botonContenido" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */

      /* Empieza nodo:166 / Elemento padre: 163   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(166)).setAttribute("class","tablaTitle" );
      ((Element)v.get(166)).setAttribute("nombre","intAccesBuzonIvrznTdLovNullSelectionButton" );
      ((Element)v.get(166)).setAttribute("align","left" );
      ((Element)v.get(166)).setAttribute("width","100%" );
      ((Element)v.get(163)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(167)).setAttribute("src","b.gif" );
      ((Element)v.get(167)).setAttribute("height","8" );
      ((Element)v.get(167)).setAttribute("width","8" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));
      /* Termina nodo:167   */

      /* Empieza nodo:168 / Elemento padre: 166   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(168)).setAttribute("nombre","intAccesBuzonIvrznLovNullButton" );
      ((Element)v.get(168)).setAttribute("ID","botonContenido" );
      ((Element)v.get(168)).setAttribute("tipo","html" );
      ((Element)v.get(168)).setAttribute("accion","intAccesBuzonIvrznLovNullSelectionAction();" );
      ((Element)v.get(168)).setAttribute("estado","true" );
      ((Element)v.get(168)).setAttribute("cod","MMGGlobal.lovNullButton.label" );
      ((Element)v.get(166)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:166   */
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:169 / Elemento padre: 157   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(169)).setAttribute("align","center" );
      ((Element)v.get(169)).setAttribute("width","12" );
      ((Element)v.get(157)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).setAttribute("width","12" );
      ((Element)v.get(170)).setAttribute("height","12" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:157   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:171 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(171)).setAttribute("nombre","intAccesBuzonIvrznListLayer" );
      ((Element)v.get(171)).setAttribute("alto","310" );
      ((Element)v.get(171)).setAttribute("ancho","99%" );
      ((Element)v.get(171)).setAttribute("colorf","" );
      ((Element)v.get(171)).setAttribute("borde","0" );
      ((Element)v.get(171)).setAttribute("imagenf","" );
      ((Element)v.get(171)).setAttribute("repeat","" );
      ((Element)v.get(171)).setAttribute("padding","" );
      ((Element)v.get(171)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(171)).setAttribute("contravsb","" );
      ((Element)v.get(171)).setAttribute("x","3" );
      ((Element)v.get(171)).setAttribute("y","" );
      ((Element)v.get(171)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(172)).setAttribute("nombre","intAccesBuzonIvrznList" );
      ((Element)v.get(172)).setAttribute("ancho","680" );
      ((Element)v.get(172)).setAttribute("alto","275" );
      ((Element)v.get(172)).setAttribute("x","12" );
      ((Element)v.get(172)).setAttribute("y","0" );
      ((Element)v.get(172)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(172)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(173)).setAttribute("precarga","S" );
      ((Element)v.get(173)).setAttribute("conROver","S" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(174)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(174)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(174)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(174)).setAttribute("desactivado","btnLista2D.gif" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(173)).appendChild((Element)v.get(174));
      /* Termina nodo:174   */

      /* Empieza nodo:175 / Elemento padre: 173   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(175)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(175)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(175)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(175)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(173)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:173   */

      /* Empieza nodo:176 / Elemento padre: 172   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(172)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(177)).setAttribute("borde","1" );
      ((Element)v.get(177)).setAttribute("horizDatos","1" );
      ((Element)v.get(177)).setAttribute("horizCabecera","1" );
      ((Element)v.get(177)).setAttribute("vertical","1" );
      ((Element)v.get(177)).setAttribute("horizTitulo","1" );
      ((Element)v.get(177)).setAttribute("horizBase","1" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */

      /* Empieza nodo:178 / Elemento padre: 176   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(178)).setAttribute("borde","#999999" );
      ((Element)v.get(178)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(178)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(178)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(178)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(178)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(178)).setAttribute("horizBase","#999999" );
      ((Element)v.get(176)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:176   */

      /* Empieza nodo:179 / Elemento padre: 172   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(179)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(179)).setAttribute("alto","22" );
      ((Element)v.get(179)).setAttribute("imgFondo","" );
      ((Element)v.get(179)).setAttribute("cod","00135" );
      ((Element)v.get(179)).setAttribute("ID","datosTitle" );
      ((Element)v.get(172)).appendChild((Element)v.get(179));
      /* Termina nodo:179   */

      /* Empieza nodo:180 / Elemento padre: 172   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(180)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(180)).setAttribute("alto","22" );
      ((Element)v.get(180)).setAttribute("imgFondo","" );
      ((Element)v.get(172)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */

      /* Empieza nodo:181 / Elemento padre: 172   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(181)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(181)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(181)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(181)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(181)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(172)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(182)).setAttribute("ancho","100" );
      ((Element)v.get(182)).setAttribute("minimizable","S" );
      ((Element)v.get(182)).setAttribute("minimizada","N" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */

      /* Empieza nodo:183 / Elemento padre: 181   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(183)).setAttribute("ancho","100" );
      ((Element)v.get(183)).setAttribute("minimizable","S" );
      ((Element)v.get(183)).setAttribute("minimizada","N" );
      ((Element)v.get(181)).appendChild((Element)v.get(183));
      /* Termina nodo:183   */
      /* Termina nodo:181   */

      /* Empieza nodo:184 / Elemento padre: 172   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(184)).setAttribute("height","20" );
      ((Element)v.get(184)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(184)).setAttribute("imgFondo","" );
      ((Element)v.get(184)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(172)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(185)).setAttribute("colFondo","" );
      ((Element)v.get(185)).setAttribute("ID","EstCab" );
      ((Element)v.get(185)).setAttribute("cod","IntAccesBuzonIvrzn.codAcceBuzoIvrz.label" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));
      /* Termina nodo:185   */

      /* Empieza nodo:186 / Elemento padre: 184   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(186)).setAttribute("colFondo","" );
      ((Element)v.get(186)).setAttribute("ID","EstCab" );
      ((Element)v.get(186)).setAttribute("cod","IntAccesBuzonIvrzn.zzonOidZona.label" );
      ((Element)v.get(184)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:184   */

      /* Empieza nodo:187 / Elemento padre: 172   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(187)).setAttribute("alto","22" );
      ((Element)v.get(187)).setAttribute("accion","" );
      ((Element)v.get(187)).setAttribute("tipoEnvio","seleccion" );
      ((Element)v.get(187)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(187)).setAttribute("maxSel","1" );
      ((Element)v.get(187)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(187)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(187)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(187)).setAttribute("onLoad","" );
      ((Element)v.get(187)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(172)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(188)).setAttribute("tipo","texto" );
      ((Element)v.get(188)).setAttribute("ID","EstDat" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */

      /* Empieza nodo:189 / Elemento padre: 187   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(189)).setAttribute("tipo","texto" );
      ((Element)v.get(189)).setAttribute("ID","EstDat2" );
   }

   private void getXML900(Document doc) {
      ((Element)v.get(187)).appendChild((Element)v.get(189));
      /* Termina nodo:189   */
      /* Termina nodo:187   */

      /* Empieza nodo:190 / Elemento padre: 172   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(172)).appendChild((Element)v.get(190));
      /* Termina nodo:190   */
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:191 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(191)).setAttribute("nombre","intAccesBuzonIvrznListButtonsLayer" );
      ((Element)v.get(191)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(191)).setAttribute("alto","30" );
      ((Element)v.get(191)).setAttribute("ancho","98%" );
      ((Element)v.get(191)).setAttribute("borde","n" );
      ((Element)v.get(191)).setAttribute("imagenf","" );
      ((Element)v.get(191)).setAttribute("repeat","" );
      ((Element)v.get(191)).setAttribute("padding","0" );
      ((Element)v.get(191)).setAttribute("contravsb","" );
      ((Element)v.get(191)).setAttribute("x","16" );
      ((Element)v.get(191)).setAttribute("y","" );
      ((Element)v.get(191)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(191));

      /* Empieza nodo:192 / Elemento padre: 191   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(192)).setAttribute("nombre","toolbarSeparatorLayer" );
      ((Element)v.get(192)).setAttribute("visibilidad","inherit" );
      ((Element)v.get(192)).setAttribute("alto","23" );
      ((Element)v.get(192)).setAttribute("ancho","1" );
      ((Element)v.get(192)).setAttribute("borde","1" );
      ((Element)v.get(192)).setAttribute("imagenf","" );
      ((Element)v.get(192)).setAttribute("repeat","" );
      ((Element)v.get(192)).setAttribute("padding","0" );
      ((Element)v.get(192)).setAttribute("contravsb","" );
      ((Element)v.get(192)).setAttribute("x","56" );
      ((Element)v.get(192)).setAttribute("y","0" );
      ((Element)v.get(192)).setAttribute("zindex","" );
      ((Element)v.get(192)).setAttribute("colborde","#999999" );
      ((Element)v.get(191)).appendChild((Element)v.get(192));
      /* Termina nodo:192   */

      /* Empieza nodo:193 / Elemento padre: 191   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(193)).setAttribute("width","100%" );
      ((Element)v.get(193)).setAttribute("border","0" );
      ((Element)v.get(193)).setAttribute("cellspacing","1" );
      ((Element)v.get(193)).setAttribute("cellpadding","0" );
      ((Element)v.get(191)).appendChild((Element)v.get(193));

      /* Empieza nodo:194 / Elemento padre: 193   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(193)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(195)).setAttribute("src","b.gif" );
      ((Element)v.get(195)).setAttribute("height","22" );
      ((Element)v.get(195)).setAttribute("width","5" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */

      /* Empieza nodo:196 / Elemento padre: 193   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(193)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("BOTONERA"));
      ((Element)v.get(197)).setAttribute("nombre","intAccesBuzonIvrznPaginationButtonBar" );
      ((Element)v.get(197)).setAttribute("tipo","H" );
      ((Element)v.get(197)).setAttribute("x","0" );
      ((Element)v.get(197)).setAttribute("y","0" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(198)).setAttribute("nombre","intAccesBuzonIvrznFirstPageButton" );
      ((Element)v.get(198)).setAttribute("funcion","intAccesBuzonIvrznFirstPage();" );
      ((Element)v.get(198)).setAttribute("off","primera_over0.gif" );
      ((Element)v.get(198)).setAttribute("on","primera_over0.gif" );
      ((Element)v.get(198)).setAttribute("disable","primera_on0.gif" );
      ((Element)v.get(198)).setAttribute("estado","inactivo" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */

      /* Empieza nodo:199 / Elemento padre: 197   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(199)).setAttribute("nombre","intAccesBuzonIvrznFirstPageButtonGapTd" );
      ((Element)v.get(197)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(200)).setAttribute("src","b.gif" );
      ((Element)v.get(200)).setAttribute("height","8" );
      ((Element)v.get(200)).setAttribute("width","5" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:201 / Elemento padre: 197   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(201)).setAttribute("nombre","intAccesBuzonIvrznPreviousPageButton" );
      ((Element)v.get(201)).setAttribute("funcion","intAccesBuzonIvrznPreviousPage();" );
      ((Element)v.get(201)).setAttribute("off","retroceder_over0.gif" );
      ((Element)v.get(201)).setAttribute("on","retroceder_over0.gif" );
      ((Element)v.get(201)).setAttribute("disable","retroceder_on0.gif" );
      ((Element)v.get(201)).setAttribute("estado","inactivo" );
      ((Element)v.get(197)).appendChild((Element)v.get(201));
      /* Termina nodo:201   */

      /* Empieza nodo:202 / Elemento padre: 197   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(202)).setAttribute("nombre","intAccesBuzonIvrznPreviousPageButtonGapTd" );
      ((Element)v.get(197)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(203)).setAttribute("src","b.gif" );
      ((Element)v.get(203)).setAttribute("height","8" );
      ((Element)v.get(203)).setAttribute("width","8" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:204 / Elemento padre: 197   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(204)).setAttribute("nombre","intAccesBuzonIvrznNextPageButton" );
      ((Element)v.get(204)).setAttribute("funcion","intAccesBuzonIvrznNextPage();" );
      ((Element)v.get(204)).setAttribute("off","avanzar_over0.gif" );
      ((Element)v.get(204)).setAttribute("on","avanzar_over0.gif" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(204)).setAttribute("disable","avanzar_on0.gif" );
      ((Element)v.get(204)).setAttribute("estado","inactivo" );
      ((Element)v.get(197)).appendChild((Element)v.get(204));
      /* Termina nodo:204   */
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:205 / Elemento padre: 193   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(193)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(206)).setAttribute("src","b.gif" );
      ((Element)v.get(206)).setAttribute("height","22" );
      ((Element)v.get(206)).setAttribute("width","19" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */

      /* Empieza nodo:207 / Elemento padre: 193   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(207)).setAttribute("class","tablaTitle" );
      ((Element)v.get(207)).setAttribute("nombre","intAccesBuzonIvrznUpdateButtonTd" );
      ((Element)v.get(193)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(208)).setAttribute("nombre","intAccesBuzonIvrznUpdateButton" );
      ((Element)v.get(208)).setAttribute("ID","botonContenido" );
      ((Element)v.get(208)).setAttribute("tipo","html" );
      ((Element)v.get(208)).setAttribute("accion","intAccesBuzonIvrznUpdateSelection();" );
      ((Element)v.get(208)).setAttribute("estado","false" );
      ((Element)v.get(208)).setAttribute("cod","MMGGlobal.updateButton.label" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));
      /* Termina nodo:208   */
      /* Termina nodo:207   */

      /* Empieza nodo:209 / Elemento padre: 193   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(209)).setAttribute("nombre","intAccesBuzonIvrznUpdateButtonGapTd" );
      ((Element)v.get(193)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(210)).setAttribute("src","b.gif" );
      ((Element)v.get(210)).setAttribute("height","8" );
      ((Element)v.get(210)).setAttribute("width","10" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */

      /* Empieza nodo:211 / Elemento padre: 193   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(211)).setAttribute("class","tablaTitle" );
      ((Element)v.get(211)).setAttribute("nombre","intAccesBuzonIvrznViewForRemoveButtonTd" );
      ((Element)v.get(193)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(212)).setAttribute("nombre","intAccesBuzonIvrznViewForRemoveButton" );
      ((Element)v.get(212)).setAttribute("ID","botonContenido" );
      ((Element)v.get(212)).setAttribute("tipo","html" );
      ((Element)v.get(212)).setAttribute("accion","intAccesBuzonIvrznViewSelection();" );
      ((Element)v.get(212)).setAttribute("estado","false" );
      ((Element)v.get(212)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */

      /* Empieza nodo:213 / Elemento padre: 193   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(213)).setAttribute("nombre","intAccesBuzonIvrznViewForRemoveButtonGapTd" );
      ((Element)v.get(193)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(214)).setAttribute("src","b.gif" );
      ((Element)v.get(214)).setAttribute("height","8" );
      ((Element)v.get(214)).setAttribute("width","10" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */

      /* Empieza nodo:215 / Elemento padre: 193   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(215)).setAttribute("class","tablaTitle" );
      ((Element)v.get(215)).setAttribute("nombre","intAccesBuzonIvrznLovSelectButtonTd" );
      ((Element)v.get(193)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(216)).setAttribute("nombre","intAccesBuzonIvrznLovSelectButton" );
      ((Element)v.get(216)).setAttribute("ID","botonContenido" );
      ((Element)v.get(216)).setAttribute("tipo","html" );
      ((Element)v.get(216)).setAttribute("accion","intAccesBuzonIvrznLovSelectionAction();" );
      ((Element)v.get(216)).setAttribute("estado","true" );
      ((Element)v.get(216)).setAttribute("cod","MMGGlobal.lovSelectButton.label" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */

      /* Empieza nodo:217 / Elemento padre: 193   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(217)).setAttribute("nombre","intAccesBuzonIvrznLovSelectButtonGapTd" );
      ((Element)v.get(193)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(218)).setAttribute("src","b.gif" );
      ((Element)v.get(218)).setAttribute("height","8" );
      ((Element)v.get(218)).setAttribute("width","10" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:219 / Elemento padre: 193   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(219)).setAttribute("class","tablaTitle" );
      ((Element)v.get(219)).setAttribute("nombre","intAccesBuzonIvrznViewButtonTd" );
      ((Element)v.get(193)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(220)).setAttribute("nombre","intAccesBuzonIvrznViewButton" );
      ((Element)v.get(220)).setAttribute("ID","botonContenido" );
      ((Element)v.get(220)).setAttribute("tipo","html" );
      ((Element)v.get(220)).setAttribute("accion","intAccesBuzonIvrznViewSelection();" );
      ((Element)v.get(220)).setAttribute("estado","false" );
      ((Element)v.get(220)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */

      /* Empieza nodo:221 / Elemento padre: 193   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(221)).setAttribute("nombre","intAccesBuzonIvrznViewButtonGapTd" );
      ((Element)v.get(193)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(222)).setAttribute("src","b.gif" );
      ((Element)v.get(222)).setAttribute("height","8" );
      ((Element)v.get(222)).setAttribute("width","10" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));
      /* Termina nodo:222   */
      /* Termina nodo:221   */

      /* Empieza nodo:223 / Elemento padre: 193   */
   }

   private void getXML1080(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(223)).setAttribute("width","100%" );
      ((Element)v.get(193)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:193   */
      /* Termina nodo:191   */
      /* Termina nodo:4   */


   }

}

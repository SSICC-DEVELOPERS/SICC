
import org.w3c.dom.*;
import java.util.ArrayList;

public class PreEstraPage  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","PreEstraPage" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","preEstraInitComponents()" );
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
      ((Element)v.get(2)).setAttribute("src","i18NJS.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(2));
      /* Termina nodo:2   */

      /* Empieza nodo:3 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(3)).setAttribute("src","mmg.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("JS"));
      ((Element)v.get(4)).setAttribute("src","preestra.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(5)).setAttribute("nombre","preEstraFrm" );
      ((Element)v.get(5)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(6)).setAttribute("valor","PreEstraLPExecution" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","ON" );
      ((Element)v.get(7)).setAttribute("valor","PreEstraLPExecution" );
      ((Element)v.get(5)).appendChild((Element)v.get(7));
      /* Termina nodo:7   */

      /* Empieza nodo:8 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(8)).setAttribute("nombre","accion" );
      ((Element)v.get(8)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(8));
      /* Termina nodo:8   */

      /* Empieza nodo:9 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(9)).setAttribute("nombre","origen" );
      ((Element)v.get(9)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(9));
      /* Termina nodo:9   */

      /* Empieza nodo:10 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(10)).setAttribute("nombre","idSelection" );
      ((Element)v.get(10)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(10));
      /* Termina nodo:10   */

      /* Empieza nodo:11 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(11)).setAttribute("nombre","idAttributeLovOpener" );
      ((Element)v.get(11)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(11));
      /* Termina nodo:11   */

      /* Empieza nodo:12 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(12)).setAttribute("nombre","idEntityLovOpener" );
      ((Element)v.get(12)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(12));
      /* Termina nodo:12   */

      /* Empieza nodo:13 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(13)).setAttribute("nombre","timestamp" );
      ((Element)v.get(13)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(13));
      /* Termina nodo:13   */

      /* Empieza nodo:14 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(14)).setAttribute("nombre","windowTitleCode" );
      ((Element)v.get(14)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(14));
      /* Termina nodo:14   */

      /* Empieza nodo:15 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(15)).setAttribute("nombre","userLanguageCode" );
      ((Element)v.get(15)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(15));
      /* Termina nodo:15   */

      /* Empieza nodo:16 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(16)).setAttribute("nombre","defaultLanguageCode" );
      ((Element)v.get(16)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(16));
      /* Termina nodo:16   */

      /* Empieza nodo:17 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(17)).setAttribute("nombre","pageLaguage" );
      ((Element)v.get(17)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(17));
      /* Termina nodo:17   */

      /* Empieza nodo:18 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(18)).setAttribute("nombre","lastQueryToSession" );
      ((Element)v.get(18)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(18));
      /* Termina nodo:18   */

      /* Empieza nodo:19 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(19)).setAttribute("nombre","previousAction" );
      ((Element)v.get(19)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(19));
      /* Termina nodo:19   */

      /* Empieza nodo:20 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(20)).setAttribute("nombre","performRequery" );
      ((Element)v.get(20)).setAttribute("valor","false" );
      ((Element)v.get(5)).appendChild((Element)v.get(20));
      /* Termina nodo:20   */

      /* Empieza nodo:21 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(21)).setAttribute("nombre","applyStructuralEntity" );
      ((Element)v.get(21)).setAttribute("valor","true" );
      ((Element)v.get(5)).appendChild((Element)v.get(21));
      /* Termina nodo:21   */

      /* Empieza nodo:22 / Elemento padre: 5   */
   }

   private void getXML90(Document doc) {
      v.add(doc.createElement("VAR"));
      ((Element)v.get(22)).setAttribute("nombre","errCodigo" );
      ((Element)v.get(22)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(22));
      /* Termina nodo:22   */

      /* Empieza nodo:23 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(23)).setAttribute("nombre","errDescripcion" );
      ((Element)v.get(23)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(23));
      /* Termina nodo:23   */

      /* Empieza nodo:24 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(24)).setAttribute("nombre","errSeverity" );
      ((Element)v.get(24)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(24));
      /* Termina nodo:24   */

      /* Empieza nodo:25 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(25)).setAttribute("nombre","structuralDefaultPais" );
      ((Element)v.get(25)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(25));
      /* Termina nodo:25   */

      /* Empieza nodo:26 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(26)).setAttribute("nombre","structuralDefaultSociedad" );
      ((Element)v.get(26)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(26));
      /* Termina nodo:26   */

      /* Empieza nodo:27 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(27)).setAttribute("nombre","structuralDefaultMarca" );
      ((Element)v.get(27)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(27));
      /* Termina nodo:27   */

      /* Empieza nodo:28 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(28)).setAttribute("nombre","structuralDefaultCanal" );
      ((Element)v.get(28)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(28));
      /* Termina nodo:28   */

      /* Empieza nodo:29 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(29)).setAttribute("nombre","structuralDefaultAcceso" );
      ((Element)v.get(29)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(29));
      /* Termina nodo:29   */

      /* Empieza nodo:30 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(30)).setAttribute("nombre","structuralDefaultSubacceso" );
      ((Element)v.get(30)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(30));
      /* Termina nodo:30   */

      /* Empieza nodo:31 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(31)).setAttribute("nombre","structuralDefaultSubgerenciaVentas" );
      ((Element)v.get(31)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(31));
      /* Termina nodo:31   */

      /* Empieza nodo:32 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(32)).setAttribute("nombre","structuralDefaultRegion" );
      ((Element)v.get(32)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(32));
      /* Termina nodo:32   */

      /* Empieza nodo:33 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(33)).setAttribute("nombre","structuralDefaultZona" );
      ((Element)v.get(33)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(33));
      /* Termina nodo:33   */

      /* Empieza nodo:34 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(34)).setAttribute("nombre","structuralDefaultSeccion" );
      ((Element)v.get(34)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(34));
      /* Termina nodo:34   */

      /* Empieza nodo:35 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(35)).setAttribute("nombre","structuralDefaultTerritorio" );
      ((Element)v.get(35)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(35));
      /* Termina nodo:35   */

      /* Empieza nodo:36 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(36)).setAttribute("nombre","clientCodeSize" );
      ((Element)v.get(36)).setAttribute("valor","" );
      ((Element)v.get(5)).appendChild((Element)v.get(36));
      /* Termina nodo:36   */

      /* Empieza nodo:37 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(37)).setAttribute("nombre","preEstraFormLayer" );
      ((Element)v.get(37)).setAttribute("alto","" );
      ((Element)v.get(37)).setAttribute("ancho","100%" );
      ((Element)v.get(37)).setAttribute("colorf","" );
      ((Element)v.get(37)).setAttribute("borde","0" );
      ((Element)v.get(37)).setAttribute("imagenf","" );
      ((Element)v.get(37)).setAttribute("repeat","" );
      ((Element)v.get(37)).setAttribute("padding","" );
      ((Element)v.get(37)).setAttribute("visibilidad","visible" );
      ((Element)v.get(37)).setAttribute("contravsb","" );
      ((Element)v.get(37)).setAttribute("x","0" );
      ((Element)v.get(37)).setAttribute("y","0" );
      ((Element)v.get(37)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(37));

      /* Empieza nodo:38 / Elemento padre: 37   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(38)).setAttribute("width","100%" );
      ((Element)v.get(38)).setAttribute("border","0" );
      ((Element)v.get(38)).setAttribute("cellspacing","0" );
      ((Element)v.get(38)).setAttribute("cellpadding","0" );
      ((Element)v.get(38)).setAttribute("align","left" );
      ((Element)v.get(37)).appendChild((Element)v.get(38));

      /* Empieza nodo:39 / Elemento padre: 38   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(38)).appendChild((Element)v.get(39));

      /* Empieza nodo:40 / Elemento padre: 39   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(40)).setAttribute("align","center" );
      ((Element)v.get(40)).setAttribute("width","12" );
      ((Element)v.get(39)).appendChild((Element)v.get(40));

      /* Empieza nodo:41 / Elemento padre: 40   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(41)).setAttribute("src","b.gif" );
   }

   private void getXML180(Document doc) {
      ((Element)v.get(41)).setAttribute("width","12" );
      ((Element)v.get(41)).setAttribute("height","12" );
      ((Element)v.get(40)).appendChild((Element)v.get(41));
      /* Termina nodo:41   */
      /* Termina nodo:40   */

      /* Empieza nodo:42 / Elemento padre: 39   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(42)).setAttribute("align","center" );
      ((Element)v.get(42)).setAttribute("width","750" );
      ((Element)v.get(39)).appendChild((Element)v.get(42));

      /* Empieza nodo:43 / Elemento padre: 42   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(43)).setAttribute("src","b.gif" );
      ((Element)v.get(43)).setAttribute("width","12" );
      ((Element)v.get(43)).setAttribute("height","12" );
      ((Element)v.get(42)).appendChild((Element)v.get(43));
      /* Termina nodo:43   */
      /* Termina nodo:42   */

      /* Empieza nodo:44 / Elemento padre: 39   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(44)).setAttribute("align","center" );
      ((Element)v.get(44)).setAttribute("width","12" );
      ((Element)v.get(39)).appendChild((Element)v.get(44));

      /* Empieza nodo:45 / Elemento padre: 44   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(45)).setAttribute("src","b.gif" );
      ((Element)v.get(45)).setAttribute("width","12" );
      ((Element)v.get(45)).setAttribute("height","12" );
      ((Element)v.get(44)).appendChild((Element)v.get(45));
      /* Termina nodo:45   */
      /* Termina nodo:44   */
      /* Termina nodo:39   */

      /* Empieza nodo:46 / Elemento padre: 38   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(38)).appendChild((Element)v.get(46));

      /* Empieza nodo:47 / Elemento padre: 46   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(47)).setAttribute("align","center" );
      ((Element)v.get(47)).setAttribute("width","12" );
      ((Element)v.get(46)).appendChild((Element)v.get(47));

      /* Empieza nodo:48 / Elemento padre: 47   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(48)).setAttribute("src","b.gif" );
      ((Element)v.get(48)).setAttribute("width","12" );
      ((Element)v.get(48)).setAttribute("height","8" );
      ((Element)v.get(47)).appendChild((Element)v.get(48));
      /* Termina nodo:48   */
      /* Termina nodo:47   */

      /* Empieza nodo:49 / Elemento padre: 46   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(49)).setAttribute("width","100%" );
      ((Element)v.get(46)).appendChild((Element)v.get(49));

      /* Empieza nodo:50 / Elemento padre: 49   */
      v.add(doc.createElement("fieldset"));
      ((Element)v.get(49)).appendChild((Element)v.get(50));

      /* Empieza nodo:51 / Elemento padre: 50   */
      v.add(doc.createElement("legend"));
      ((Element)v.get(51)).setAttribute("class","legend" );
      ((Element)v.get(50)).appendChild((Element)v.get(51));

      /* Empieza nodo:52 / Elemento padre: 51   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(52)).setAttribute("nombre","legendLbl" );
      ((Element)v.get(52)).setAttribute("alto","13" );
      ((Element)v.get(52)).setAttribute("filas","1" );
      ((Element)v.get(52)).setAttribute("id","legend" );
      ((Element)v.get(52)).setAttribute("valor","" );
      ((Element)v.get(52)).setAttribute("cod","PreEstra.legend.label" );
      ((Element)v.get(51)).appendChild((Element)v.get(52));
      /* Termina nodo:52   */
      /* Termina nodo:51   */

      /* Empieza nodo:53 / Elemento padre: 50   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(53)).setAttribute("width","100%" );
      ((Element)v.get(53)).setAttribute("border","0" );
      ((Element)v.get(53)).setAttribute("align","center" );
      ((Element)v.get(53)).setAttribute("cellspacing","0" );
      ((Element)v.get(53)).setAttribute("cellpadding","0" );
      ((Element)v.get(50)).appendChild((Element)v.get(53));

      /* Empieza nodo:54 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(53)).appendChild((Element)v.get(54));

      /* Empieza nodo:55 / Elemento padre: 54   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(55)).setAttribute("width","100%" );
      ((Element)v.get(55)).setAttribute("nowrap","true" );
      ((Element)v.get(55)).setAttribute("class","datosCampos" );
      ((Element)v.get(55)).setAttribute("colspan","3" );
      ((Element)v.get(54)).appendChild((Element)v.get(55));

      /* Empieza nodo:56 / Elemento padre: 55   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(56)).setAttribute("src","b.gif" );
      ((Element)v.get(56)).setAttribute("width","8" );
      ((Element)v.get(56)).setAttribute("height","8" );
      ((Element)v.get(55)).appendChild((Element)v.get(56));
      /* Termina nodo:56   */
      /* Termina nodo:55   */
      /* Termina nodo:54   */

      /* Empieza nodo:57 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(57)).setAttribute("nombre","formTr0" );
      ((Element)v.get(53)).appendChild((Element)v.get(57));

      /* Empieza nodo:58 / Elemento padre: 57   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(58)).setAttribute("align","center" );
      ((Element)v.get(58)).setAttribute("width","8" );
      ((Element)v.get(57)).appendChild((Element)v.get(58));

      /* Empieza nodo:59 / Elemento padre: 58   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(59)).setAttribute("src","b.gif" );
      ((Element)v.get(59)).setAttribute("width","8" );
      ((Element)v.get(59)).setAttribute("height","12" );
      ((Element)v.get(58)).appendChild((Element)v.get(59));
      /* Termina nodo:59   */
      /* Termina nodo:58   */

      /* Empieza nodo:60 / Elemento padre: 57   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(60)).setAttribute("width","100%" );
      ((Element)v.get(57)).appendChild((Element)v.get(60));

      /* Empieza nodo:61 / Elemento padre: 60   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(61)).setAttribute("width","100%" );
      ((Element)v.get(61)).setAttribute("border","0" );
      ((Element)v.get(61)).setAttribute("cellspacing","0" );
      ((Element)v.get(61)).setAttribute("cellpadding","0" );
      ((Element)v.get(61)).setAttribute("align","left" );
      ((Element)v.get(60)).appendChild((Element)v.get(61));

      /* Empieza nodo:62 / Elemento padre: 61   */
   }

   private void getXML270(Document doc) {
      v.add(doc.createElement("TR"));
      ((Element)v.get(62)).setAttribute("align","left" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(63)).setAttribute("nombre","idTdId" );
      ((Element)v.get(62)).appendChild((Element)v.get(63));

      /* Empieza nodo:64 / Elemento padre: 63   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(64)).setAttribute("width","100%" );
      ((Element)v.get(64)).setAttribute("border","0" );
      ((Element)v.get(64)).setAttribute("cellspacing","0" );
      ((Element)v.get(64)).setAttribute("cellpadding","0" );
      ((Element)v.get(64)).setAttribute("align","left" );
      ((Element)v.get(63)).appendChild((Element)v.get(64));

      /* Empieza nodo:65 / Elemento padre: 64   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(64)).appendChild((Element)v.get(65));

      /* Empieza nodo:66 / Elemento padre: 65   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(66)).setAttribute("valign","top" );
      ((Element)v.get(66)).setAttribute("height","13" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));

      /* Empieza nodo:67 / Elemento padre: 66   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(67)).setAttribute("nombre","lblId" );
      ((Element)v.get(67)).setAttribute("alto","13" );
      ((Element)v.get(67)).setAttribute("filas","1" );
      ((Element)v.get(67)).setAttribute("id","datosTitle" );
      ((Element)v.get(67)).setAttribute("cod","PreEstra.id.label" );
      ((Element)v.get(66)).appendChild((Element)v.get(67));
      /* Termina nodo:67   */
      /* Termina nodo:66   */
      /* Termina nodo:65   */

      /* Empieza nodo:68 / Elemento padre: 64   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(68)).setAttribute("nombre","idWidgetTrId" );
      ((Element)v.get(64)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(69)).setAttribute("align","left" );
      ((Element)v.get(69)).setAttribute("nowrap","true" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(70)).setAttribute("nombre","id" );
      ((Element)v.get(70)).setAttribute("id","datosCampos" );
      ((Element)v.get(70)).setAttribute("trim","S" );
      ((Element)v.get(70)).setAttribute("max","12" );
      ((Element)v.get(70)).setAttribute("onchange","" );
      ((Element)v.get(70)).setAttribute("req","N" );
      ((Element)v.get(70)).setAttribute("size","12" );
      ((Element)v.get(70)).setAttribute("valor","" );
      ((Element)v.get(70)).setAttribute("validacion","" );
      ((Element)v.get(70)).setAttribute("disabled","" );
      ((Element)v.get(70)).setAttribute("onblur","" );
      ((Element)v.get(70)).setAttribute("ontab","ejecutarAccionFoco('preEstraFrm',1, true)" );
      ((Element)v.get(70)).setAttribute("onshtab","ejecutarAccionFoco('preEstraFrm', 1, false)" );
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:64   */
      /* Termina nodo:63   */

      /* Empieza nodo:71 / Elemento padre: 62   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(71)).setAttribute("nombre","idGapTdId" );
      ((Element)v.get(71)).setAttribute("nowrap","true" );
      ((Element)v.get(71)).setAttribute("class","datosCampos" );
      ((Element)v.get(62)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","25" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 62   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(73)).setAttribute("width","100%" );
      ((Element)v.get(62)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(74)).setAttribute("src","b.gif" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));
      /* Termina nodo:74   */
      /* Termina nodo:73   */
      /* Termina nodo:62   */
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:57   */

      /* Empieza nodo:75 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(75)).setAttribute("nombre","formGapTr0" );
      ((Element)v.get(53)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(76)).setAttribute("align","center" );
      ((Element)v.get(76)).setAttribute("width","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(77)).setAttribute("src","b.gif" );
      ((Element)v.get(77)).setAttribute("width","12" );
      ((Element)v.get(77)).setAttribute("height","8" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */

      /* Empieza nodo:78 / Elemento padre: 75   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(75)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(79)).setAttribute("src","b.gif" );
      ((Element)v.get(79)).setAttribute("width","8" );
      ((Element)v.get(79)).setAttribute("height","8" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));
      /* Termina nodo:79   */
      /* Termina nodo:78   */

      /* Empieza nodo:80 / Elemento padre: 75   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(80)).setAttribute("align","center" );
      ((Element)v.get(80)).setAttribute("width","8" );
      ((Element)v.get(75)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(81)).setAttribute("src","b.gif" );
      ((Element)v.get(81)).setAttribute("width","12" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(81)).setAttribute("height","8" );
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:75   */

      /* Empieza nodo:82 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(82)).setAttribute("nombre","formTr1" );
      ((Element)v.get(53)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(83)).setAttribute("align","center" );
      ((Element)v.get(83)).setAttribute("width","8" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));

      /* Empieza nodo:84 / Elemento padre: 83   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(84)).setAttribute("src","b.gif" );
      ((Element)v.get(84)).setAttribute("width","8" );
      ((Element)v.get(84)).setAttribute("height","12" );
      ((Element)v.get(83)).appendChild((Element)v.get(84));
      /* Termina nodo:84   */
      /* Termina nodo:83   */

      /* Empieza nodo:85 / Elemento padre: 82   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(85)).setAttribute("width","100%" );
      ((Element)v.get(82)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(86)).setAttribute("width","100%" );
      ((Element)v.get(86)).setAttribute("border","0" );
      ((Element)v.get(86)).setAttribute("cellspacing","0" );
      ((Element)v.get(86)).setAttribute("cellpadding","0" );
      ((Element)v.get(86)).setAttribute("align","left" );
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(87)).setAttribute("align","left" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(88)).setAttribute("nombre","paisOidPaisTdId" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(89)).setAttribute("border","0" );
      ((Element)v.get(89)).setAttribute("cellspacing","0" );
      ((Element)v.get(89)).setAttribute("cellpadding","0" );
      ((Element)v.get(89)).setAttribute("align","left" );
      ((Element)v.get(88)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(91)).setAttribute("valign","top" );
      ((Element)v.get(91)).setAttribute("height","13" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(92)).setAttribute("nombre","lblpaisOidPais" );
      ((Element)v.get(92)).setAttribute("id","datosTitle" );
      ((Element)v.get(92)).setAttribute("ancho","100" );
      ((Element)v.get(92)).setAttribute("alto","13" );
      ((Element)v.get(92)).setAttribute("cod","PreEstra.paisOidPais.label" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:93 / Elemento padre: 89   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(93)).setAttribute("nombre","paisOidPaisWidgetTrId" );
      ((Element)v.get(89)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(94)).setAttribute("align","left" );
      ((Element)v.get(94)).setAttribute("nowrap","true" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(95)).setAttribute("nombre","paisOidPais" );
      ((Element)v.get(95)).setAttribute("id","datosCampos" );
      ((Element)v.get(95)).setAttribute("multiple","N" );
      ((Element)v.get(95)).setAttribute("req","N" );
      ((Element)v.get(95)).setAttribute("size","1" );
      ((Element)v.get(95)).setAttribute("disabled","" );
      ((Element)v.get(95)).setAttribute("validacion","" );
      ((Element)v.get(95)).setAttribute("onchange","" );
      ((Element)v.get(95)).setAttribute("onfocus","" );
      ((Element)v.get(95)).setAttribute("valorinicial","" );
      ((Element)v.get(95)).setAttribute("textoinicial","" );
      ((Element)v.get(95)).setAttribute("ontab","ejecutarAccionFoco('preEstraFrm',2, true);" );
      ((Element)v.get(95)).setAttribute("onshtab","ejecutarAccionFoco('preEstraFrm',2, false);" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(95)).appendChild((Element)v.get(96));
      /* Termina nodo:96   */
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:97 / Elemento padre: 87   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(97)).setAttribute("nombre","paisOidPaisGapTdId" );
      ((Element)v.get(97)).setAttribute("nowrap","true" );
      ((Element)v.get(97)).setAttribute("class","datosCampos" );
      ((Element)v.get(87)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(98)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).setAttribute("width","25" );
      ((Element)v.get(98)).setAttribute("height","8" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:99 / Elemento padre: 87   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(99)).setAttribute("nombre","codEstrTdId" );
      ((Element)v.get(87)).appendChild((Element)v.get(99));

      /* Empieza nodo:100 / Elemento padre: 99   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(100)).setAttribute("width","100%" );
      ((Element)v.get(100)).setAttribute("border","0" );
      ((Element)v.get(100)).setAttribute("cellspacing","0" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(100)).setAttribute("cellpadding","0" );
      ((Element)v.get(100)).setAttribute("align","left" );
      ((Element)v.get(99)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(102)).setAttribute("valign","top" );
      ((Element)v.get(102)).setAttribute("height","13" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(103)).setAttribute("nombre","lblCodEstr" );
      ((Element)v.get(103)).setAttribute("alto","13" );
      ((Element)v.get(103)).setAttribute("filas","1" );
      ((Element)v.get(103)).setAttribute("id","datosTitle" );
      ((Element)v.get(103)).setAttribute("cod","PreEstra.codEstr.label" );
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */

      /* Empieza nodo:104 / Elemento padre: 100   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(104)).setAttribute("nombre","codEstrWidgetTrId" );
      ((Element)v.get(100)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(105)).setAttribute("align","left" );
      ((Element)v.get(105)).setAttribute("nowrap","true" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));

      /* Empieza nodo:106 / Elemento padre: 105   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(106)).setAttribute("nombre","codEstr" );
      ((Element)v.get(106)).setAttribute("id","datosCampos" );
      ((Element)v.get(106)).setAttribute("trim","S" );
      ((Element)v.get(106)).setAttribute("max","3" );
      ((Element)v.get(106)).setAttribute("onchange","" );
      ((Element)v.get(106)).setAttribute("req","N" );
      ((Element)v.get(106)).setAttribute("size","3" );
      ((Element)v.get(106)).setAttribute("valor","" );
      ((Element)v.get(106)).setAttribute("validacion","" );
      ((Element)v.get(106)).setAttribute("disabled","" );
      ((Element)v.get(106)).setAttribute("onblur","" );
      ((Element)v.get(106)).setAttribute("ontab","ejecutarAccionFoco('preEstraFrm',3, true)" );
      ((Element)v.get(106)).setAttribute("onshtab","ejecutarAccionFoco('preEstraFrm', 3, false)" );
      ((Element)v.get(105)).appendChild((Element)v.get(106));
      /* Termina nodo:106   */
      /* Termina nodo:105   */
      /* Termina nodo:104   */
      /* Termina nodo:100   */
      /* Termina nodo:99   */

      /* Empieza nodo:107 / Elemento padre: 87   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(107)).setAttribute("nombre","codEstrGapTdId" );
      ((Element)v.get(107)).setAttribute("nowrap","true" );
      ((Element)v.get(107)).setAttribute("class","datosCampos" );
      ((Element)v.get(87)).appendChild((Element)v.get(107));

      /* Empieza nodo:108 / Elemento padre: 107   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(108)).setAttribute("src","b.gif" );
      ((Element)v.get(108)).setAttribute("width","25" );
      ((Element)v.get(108)).setAttribute("height","8" );
      ((Element)v.get(107)).appendChild((Element)v.get(108));
      /* Termina nodo:108   */
      /* Termina nodo:107   */

      /* Empieza nodo:109 / Elemento padre: 87   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(109)).setAttribute("nombre","DescripcionTdId" );
      ((Element)v.get(87)).appendChild((Element)v.get(109));

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
      ((Element)v.get(110)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(112)).setAttribute("valign","top" );
      ((Element)v.get(112)).setAttribute("height","13" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));

      /* Empieza nodo:113 / Elemento padre: 112   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(113)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(113)).setAttribute("alto","13" );
      ((Element)v.get(113)).setAttribute("filas","1" );
      ((Element)v.get(113)).setAttribute("id","datosTitle" );
      ((Element)v.get(113)).setAttribute("cod","PreEstra.Descripcion.label" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));
      /* Termina nodo:113   */
      /* Termina nodo:112   */

      /* Empieza nodo:114 / Elemento padre: 111   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(114)).setAttribute("nombre","DescripcionTdLocalizationButtonGapHeader" );
      ((Element)v.get(114)).setAttribute("colspan","2" );
      ((Element)v.get(111)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:111   */

      /* Empieza nodo:115 / Elemento padre: 110   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(115)).setAttribute("nombre","DescripcionWidgetTrId" );
      ((Element)v.get(110)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(116)).setAttribute("align","left" );
      ((Element)v.get(116)).setAttribute("nowrap","true" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(117)).setAttribute("nombre","Descripcion" );
      ((Element)v.get(117)).setAttribute("id","datosCampos" );
      ((Element)v.get(117)).setAttribute("trim","S" );
      ((Element)v.get(117)).setAttribute("max","30" );
      ((Element)v.get(117)).setAttribute("onchange","" );
      ((Element)v.get(117)).setAttribute("req","N" );
      ((Element)v.get(117)).setAttribute("size","30" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(117)).setAttribute("valor","" );
      ((Element)v.get(117)).setAttribute("validacion","" );
      ((Element)v.get(117)).setAttribute("disabled","" );
      ((Element)v.get(117)).setAttribute("onblur","" );
      ((Element)v.get(117)).setAttribute("ontab","ejecutarAccionFoco('preEstraFrm',4, true)" );
      ((Element)v.get(117)).setAttribute("onshtab","ejecutarAccionFoco('preEstraFrm', 4, false)" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 115   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(115)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(119)).setAttribute("src","b.gif" );
      ((Element)v.get(119)).setAttribute("width","8" );
      ((Element)v.get(119)).setAttribute("height","8" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));
      /* Termina nodo:119   */
      /* Termina nodo:118   */

      /* Empieza nodo:120 / Elemento padre: 115   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(120)).setAttribute("nombre","DescripcionTdLocalizationButton" );
      ((Element)v.get(120)).setAttribute("align","left" );
      ((Element)v.get(120)).setAttribute("nowrap","true" );
      ((Element)v.get(120)).setAttribute("valign","bottom" );
      ((Element)v.get(115)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("A"));
      ((Element)v.get(121)).setAttribute("id","DescripcionLocalizationButton" );
      ((Element)v.get(121)).setAttribute("href","javascript:openLocalizationDialog('preEstraFrm', 'Descripcion', 1);" );
      ((Element)v.get(121)).setAttribute("onKeyDown","javascript:mmgImgEventDispatcherForFocus(event, 'ejecutarAccionFoco(\"preEstraFrm\",4, true)', 'ejecutarAccionFoco(\"preEstraFrm\",4, false)')" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(122)).setAttribute("nombre","DescripcionLocalizationButton" );
      ((Element)v.get(122)).setAttribute("src","iconmultidioma.gif" );
      ((Element)v.get(122)).setAttribute("border","0" );
      ((Element)v.get(122)).setAttribute("width","21" );
      ((Element)v.get(122)).setAttribute("height","15" );
      ((Element)v.get(122)).setAttribute("class","main" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));
      /* Termina nodo:122   */
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:115   */
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:123 / Elemento padre: 87   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(123)).setAttribute("nombre","DescripcionGapTdId" );
      ((Element)v.get(123)).setAttribute("nowrap","true" );
      ((Element)v.get(123)).setAttribute("class","datosCampos" );
      ((Element)v.get(87)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(124)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).setAttribute("width","25" );
      ((Element)v.get(124)).setAttribute("height","8" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:125 / Elemento padre: 87   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(125)).setAttribute("nombre","tiesOidTipoEstrTdId" );
      ((Element)v.get(87)).appendChild((Element)v.get(125));

      /* Empieza nodo:126 / Elemento padre: 125   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(126)).setAttribute("border","0" );
      ((Element)v.get(126)).setAttribute("cellspacing","0" );
      ((Element)v.get(126)).setAttribute("cellpadding","0" );
      ((Element)v.get(126)).setAttribute("align","left" );
      ((Element)v.get(125)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(128)).setAttribute("valign","top" );
      ((Element)v.get(128)).setAttribute("height","13" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(129)).setAttribute("nombre","lbltiesOidTipoEstr" );
      ((Element)v.get(129)).setAttribute("id","datosTitle" );
      ((Element)v.get(129)).setAttribute("ancho","100" );
      ((Element)v.get(129)).setAttribute("alto","13" );
      ((Element)v.get(129)).setAttribute("cod","PreEstra.tiesOidTipoEstr.label" );
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:130 / Elemento padre: 126   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(130)).setAttribute("nombre","tiesOidTipoEstrWidgetTrId" );
      ((Element)v.get(126)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(131)).setAttribute("align","left" );
      ((Element)v.get(131)).setAttribute("nowrap","true" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(132)).setAttribute("nombre","tiesOidTipoEstr" );
      ((Element)v.get(132)).setAttribute("id","datosCampos" );
      ((Element)v.get(132)).setAttribute("multiple","N" );
      ((Element)v.get(132)).setAttribute("req","N" );
      ((Element)v.get(132)).setAttribute("size","1" );
      ((Element)v.get(132)).setAttribute("disabled","" );
      ((Element)v.get(132)).setAttribute("validacion","" );
      ((Element)v.get(132)).setAttribute("onchange","" );
      ((Element)v.get(132)).setAttribute("onfocus","" );
      ((Element)v.get(132)).setAttribute("valorinicial","" );
      ((Element)v.get(132)).setAttribute("textoinicial","" );
      ((Element)v.get(132)).setAttribute("ontab","ejecutarAccionFoco('preEstraFrm',5, true);" );
      ((Element)v.get(132)).setAttribute("onshtab","ejecutarAccionFoco('preEstraFrm',5, false);" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:130   */
      /* Termina nodo:126   */
      /* Termina nodo:125   */

      /* Empieza nodo:134 / Elemento padre: 87   */
      v.add(doc.createElement("TD"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(134)).setAttribute("nombre","tiesOidTipoEstrGapTdId" );
      ((Element)v.get(134)).setAttribute("nowrap","true" );
      ((Element)v.get(134)).setAttribute("class","datosCampos" );
      ((Element)v.get(87)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","25" );
      ((Element)v.get(135)).setAttribute("height","8" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 87   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(136)).setAttribute("width","100%" );
      ((Element)v.get(87)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(137)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:82   */

      /* Empieza nodo:138 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(138)).setAttribute("nombre","formGapTr1" );
      ((Element)v.get(53)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(139)).setAttribute("align","center" );
      ((Element)v.get(139)).setAttribute("width","8" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","12" );
      ((Element)v.get(140)).setAttribute("height","8" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:141 / Elemento padre: 138   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(138)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(142)).setAttribute("src","b.gif" );
      ((Element)v.get(142)).setAttribute("width","8" );
      ((Element)v.get(142)).setAttribute("height","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:143 / Elemento padre: 138   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(143)).setAttribute("align","center" );
      ((Element)v.get(143)).setAttribute("width","8" );
      ((Element)v.get(138)).appendChild((Element)v.get(143));

      /* Empieza nodo:144 / Elemento padre: 143   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(144)).setAttribute("src","b.gif" );
      ((Element)v.get(144)).setAttribute("width","12" );
      ((Element)v.get(144)).setAttribute("height","8" );
      ((Element)v.get(143)).appendChild((Element)v.get(144));
      /* Termina nodo:144   */
      /* Termina nodo:143   */
      /* Termina nodo:138   */

      /* Empieza nodo:145 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(145)).setAttribute("nombre","formTr2" );
      ((Element)v.get(53)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(146)).setAttribute("align","center" );
      ((Element)v.get(146)).setAttribute("width","8" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(147)).setAttribute("src","b.gif" );
      ((Element)v.get(147)).setAttribute("width","8" );
      ((Element)v.get(147)).setAttribute("height","12" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */

      /* Empieza nodo:148 / Elemento padre: 145   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(148)).setAttribute("width","100%" );
      ((Element)v.get(145)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(149)).setAttribute("width","100%" );
      ((Element)v.get(149)).setAttribute("border","0" );
      ((Element)v.get(149)).setAttribute("cellspacing","0" );
      ((Element)v.get(149)).setAttribute("cellpadding","0" );
      ((Element)v.get(149)).setAttribute("align","left" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(150)).setAttribute("align","left" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(151)).setAttribute("nombre","numMaxiGrupTdId" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));

      /* Empieza nodo:152 / Elemento padre: 151   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(152)).setAttribute("width","100%" );
      ((Element)v.get(152)).setAttribute("border","0" );
      ((Element)v.get(152)).setAttribute("cellspacing","0" );
      ((Element)v.get(152)).setAttribute("cellpadding","0" );
      ((Element)v.get(152)).setAttribute("align","left" );
      ((Element)v.get(151)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(154)).setAttribute("valign","top" );
      ((Element)v.get(154)).setAttribute("height","13" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(155)).setAttribute("nombre","lblNumMaxiGrup" );
      ((Element)v.get(155)).setAttribute("alto","13" );
      ((Element)v.get(155)).setAttribute("filas","1" );
      ((Element)v.get(155)).setAttribute("id","datosTitle" );
      ((Element)v.get(155)).setAttribute("cod","PreEstra.numMaxiGrup.label" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:156 / Elemento padre: 152   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(156)).setAttribute("nombre","numMaxiGrupWidgetTrId" );
      ((Element)v.get(152)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(157)).setAttribute("align","left" );
      ((Element)v.get(157)).setAttribute("nowrap","true" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(158)).setAttribute("nombre","numMaxiGrup" );
      ((Element)v.get(158)).setAttribute("id","datosCampos" );
      ((Element)v.get(158)).setAttribute("trim","S" );
      ((Element)v.get(158)).setAttribute("max","2" );
      ((Element)v.get(158)).setAttribute("onchange","" );
      ((Element)v.get(158)).setAttribute("req","N" );
      ((Element)v.get(158)).setAttribute("size","2" );
      ((Element)v.get(158)).setAttribute("valor","" );
      ((Element)v.get(158)).setAttribute("validacion","" );
      ((Element)v.get(158)).setAttribute("disabled","" );
      ((Element)v.get(158)).setAttribute("onblur","" );
      ((Element)v.get(158)).setAttribute("ontab","ejecutarAccionFoco('preEstraFrm',6, true)" );
      ((Element)v.get(158)).setAttribute("onshtab","ejecutarAccionFoco('preEstraFrm', 6, false)" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:156   */
      /* Termina nodo:152   */
      /* Termina nodo:151   */

      /* Empieza nodo:159 / Elemento padre: 150   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(159)).setAttribute("nombre","numMaxiGrupGapTdId" );
      ((Element)v.get(159)).setAttribute("nowrap","true" );
      ((Element)v.get(159)).setAttribute("class","datosCampos" );
      ((Element)v.get(150)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(160)).setAttribute("src","b.gif" );
      ((Element)v.get(160)).setAttribute("width","25" );
      ((Element)v.get(160)).setAttribute("height","8" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));
      /* Termina nodo:160   */
      /* Termina nodo:159   */

      /* Empieza nodo:161 / Elemento padre: 150   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(161)).setAttribute("nombre","numMaxiGrupCndtTdId" );
      ((Element)v.get(150)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(162)).setAttribute("width","100%" );
      ((Element)v.get(162)).setAttribute("border","0" );
      ((Element)v.get(162)).setAttribute("cellspacing","0" );
      ((Element)v.get(162)).setAttribute("cellpadding","0" );
      ((Element)v.get(162)).setAttribute("align","left" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));

      /* Empieza nodo:163 / Elemento padre: 162   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(162)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(164)).setAttribute("valign","top" );
      ((Element)v.get(164)).setAttribute("height","13" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(165)).setAttribute("nombre","lblNumMaxiGrupCndt" );
      ((Element)v.get(165)).setAttribute("alto","13" );
      ((Element)v.get(165)).setAttribute("filas","1" );
      ((Element)v.get(165)).setAttribute("id","datosTitle" );
      ((Element)v.get(165)).setAttribute("cod","PreEstra.numMaxiGrupCndt.label" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));
      /* Termina nodo:165   */
      /* Termina nodo:164   */
      /* Termina nodo:163   */

      /* Empieza nodo:166 / Elemento padre: 162   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(166)).setAttribute("nombre","numMaxiGrupCndtWidgetTrId" );
      ((Element)v.get(162)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(167)).setAttribute("align","left" );
      ((Element)v.get(167)).setAttribute("nowrap","true" );
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(168)).setAttribute("nombre","numMaxiGrupCndt" );
      ((Element)v.get(168)).setAttribute("id","datosCampos" );
      ((Element)v.get(168)).setAttribute("trim","S" );
      ((Element)v.get(168)).setAttribute("max","2" );
      ((Element)v.get(168)).setAttribute("onchange","" );
      ((Element)v.get(168)).setAttribute("req","N" );
      ((Element)v.get(168)).setAttribute("size","2" );
      ((Element)v.get(168)).setAttribute("valor","" );
      ((Element)v.get(168)).setAttribute("validacion","" );
      ((Element)v.get(168)).setAttribute("disabled","" );
      ((Element)v.get(168)).setAttribute("onblur","" );
      ((Element)v.get(168)).setAttribute("ontab","ejecutarAccionFoco('preEstraFrm',7, true)" );
      ((Element)v.get(168)).setAttribute("onshtab","ejecutarAccionFoco('preEstraFrm', 7, false)" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */
      /* Termina nodo:166   */
      /* Termina nodo:162   */
      /* Termina nodo:161   */

      /* Empieza nodo:169 / Elemento padre: 150   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(169)).setAttribute("nombre","numMaxiGrupCndtGapTdId" );
      ((Element)v.get(169)).setAttribute("nowrap","true" );
      ((Element)v.get(169)).setAttribute("class","datosCampos" );
      ((Element)v.get(150)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(170)).setAttribute("width","25" );
      ((Element)v.get(170)).setAttribute("height","8" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */

      /* Empieza nodo:171 / Elemento padre: 150   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(171)).setAttribute("nombre","numMaxiGrupCndoTdId" );
   }

   private void getXML810(Document doc) {
      ((Element)v.get(150)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(172)).setAttribute("width","100%" );
      ((Element)v.get(172)).setAttribute("border","0" );
      ((Element)v.get(172)).setAttribute("cellspacing","0" );
      ((Element)v.get(172)).setAttribute("cellpadding","0" );
      ((Element)v.get(172)).setAttribute("align","left" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(172)).appendChild((Element)v.get(173));

      /* Empieza nodo:174 / Elemento padre: 173   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(174)).setAttribute("valign","top" );
      ((Element)v.get(174)).setAttribute("height","13" );
      ((Element)v.get(173)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(175)).setAttribute("nombre","lblNumMaxiGrupCndo" );
      ((Element)v.get(175)).setAttribute("alto","13" );
      ((Element)v.get(175)).setAttribute("filas","1" );
      ((Element)v.get(175)).setAttribute("id","datosTitle" );
      ((Element)v.get(175)).setAttribute("cod","PreEstra.numMaxiGrupCndo.label" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */
      /* Termina nodo:173   */

      /* Empieza nodo:176 / Elemento padre: 172   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(176)).setAttribute("nombre","numMaxiGrupCndoWidgetTrId" );
      ((Element)v.get(172)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(177)).setAttribute("align","left" );
      ((Element)v.get(177)).setAttribute("nowrap","true" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(178)).setAttribute("nombre","numMaxiGrupCndo" );
      ((Element)v.get(178)).setAttribute("id","datosCampos" );
      ((Element)v.get(178)).setAttribute("trim","S" );
      ((Element)v.get(178)).setAttribute("max","2" );
      ((Element)v.get(178)).setAttribute("onchange","" );
      ((Element)v.get(178)).setAttribute("req","N" );
      ((Element)v.get(178)).setAttribute("size","2" );
      ((Element)v.get(178)).setAttribute("valor","" );
      ((Element)v.get(178)).setAttribute("validacion","" );
      ((Element)v.get(178)).setAttribute("disabled","" );
      ((Element)v.get(178)).setAttribute("onblur","" );
      ((Element)v.get(178)).setAttribute("ontab","ejecutarAccionFoco('preEstraFrm',8, true)" );
      ((Element)v.get(178)).setAttribute("onshtab","ejecutarAccionFoco('preEstraFrm', 8, false)" );
      ((Element)v.get(177)).appendChild((Element)v.get(178));
      /* Termina nodo:178   */
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:172   */
      /* Termina nodo:171   */

      /* Empieza nodo:179 / Elemento padre: 150   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(179)).setAttribute("nombre","numMaxiGrupCndoGapTdId" );
      ((Element)v.get(179)).setAttribute("nowrap","true" );
      ((Element)v.get(179)).setAttribute("class","datosCampos" );
      ((Element)v.get(150)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(180)).setAttribute("src","b.gif" );
      ((Element)v.get(180)).setAttribute("width","25" );
      ((Element)v.get(180)).setAttribute("height","8" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 150   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(181)).setAttribute("width","100%" );
      ((Element)v.get(150)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(182)).setAttribute("src","b.gif" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));
      /* Termina nodo:182   */
      /* Termina nodo:181   */
      /* Termina nodo:150   */
      /* Termina nodo:149   */
      /* Termina nodo:148   */
      /* Termina nodo:145   */

      /* Empieza nodo:183 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(183)).setAttribute("nombre","formGapTr2" );
      ((Element)v.get(53)).appendChild((Element)v.get(183));

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

      /* Empieza nodo:190 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(190)).setAttribute("nombre","formTr3" );
      ((Element)v.get(53)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
   }

   private void getXML900(Document doc) {
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
      ((Element)v.get(196)).setAttribute("nombre","indListRankTdId" );
      ((Element)v.get(195)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(197)).setAttribute("width","100%" );
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
      ((Element)v.get(200)).setAttribute("nombre","lblIndListRank" );
      ((Element)v.get(200)).setAttribute("alto","13" );
      ((Element)v.get(200)).setAttribute("filas","1" );
      ((Element)v.get(200)).setAttribute("id","datosTitle" );
      ((Element)v.get(200)).setAttribute("cod","PreEstra.indListRank.label" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:198   */

      /* Empieza nodo:201 / Elemento padre: 197   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(201)).setAttribute("nombre","indListRankWidgetTrId" );
      ((Element)v.get(197)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(202)).setAttribute("align","left" );
      ((Element)v.get(202)).setAttribute("nowrap","true" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(203)).setAttribute("nombre","indListRank" );
      ((Element)v.get(203)).setAttribute("check","N" );
      ((Element)v.get(203)).setAttribute("id","datosCampos" );
      ((Element)v.get(203)).setAttribute("onclick","" );
      ((Element)v.get(203)).setAttribute("onfocus","" );
      ((Element)v.get(203)).setAttribute("disabled","" );
      ((Element)v.get(203)).setAttribute("ontab","ejecutarAccionFoco('preEstraFrm',9, true)" );
      ((Element)v.get(203)).setAttribute("onshtab","ejecutarAccionFoco('preEstraFrm',9, false)" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));
      /* Termina nodo:203   */
      /* Termina nodo:202   */
      /* Termina nodo:201   */
      /* Termina nodo:197   */
      /* Termina nodo:196   */

      /* Empieza nodo:204 / Elemento padre: 195   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(204)).setAttribute("nombre","indListRankGapTdId" );
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
      ((Element)v.get(206)).setAttribute("nombre","indCuadGrupTdId" );
      ((Element)v.get(195)).appendChild((Element)v.get(206));

      /* Empieza nodo:207 / Elemento padre: 206   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(207)).setAttribute("width","100%" );
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
      ((Element)v.get(210)).setAttribute("nombre","lblIndCuadGrup" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(210)).setAttribute("alto","13" );
      ((Element)v.get(210)).setAttribute("filas","1" );
      ((Element)v.get(210)).setAttribute("id","datosTitle" );
      ((Element)v.get(210)).setAttribute("cod","PreEstra.indCuadGrup.label" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */
      /* Termina nodo:208   */

      /* Empieza nodo:211 / Elemento padre: 207   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(211)).setAttribute("nombre","indCuadGrupWidgetTrId" );
      ((Element)v.get(207)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(212)).setAttribute("align","left" );
      ((Element)v.get(212)).setAttribute("nowrap","true" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(213)).setAttribute("nombre","indCuadGrup" );
      ((Element)v.get(213)).setAttribute("check","N" );
      ((Element)v.get(213)).setAttribute("id","datosCampos" );
      ((Element)v.get(213)).setAttribute("onclick","" );
      ((Element)v.get(213)).setAttribute("onfocus","" );
      ((Element)v.get(213)).setAttribute("disabled","" );
      ((Element)v.get(213)).setAttribute("ontab","ejecutarAccionFoco('preEstraFrm',10, true)" );
      ((Element)v.get(213)).setAttribute("onshtab","ejecutarAccionFoco('preEstraFrm',10, false)" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */
      /* Termina nodo:211   */
      /* Termina nodo:207   */
      /* Termina nodo:206   */

      /* Empieza nodo:214 / Elemento padre: 195   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(214)).setAttribute("nombre","indCuadGrupGapTdId" );
      ((Element)v.get(214)).setAttribute("nowrap","true" );
      ((Element)v.get(214)).setAttribute("class","datosCampos" );
      ((Element)v.get(195)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(215)).setAttribute("src","b.gif" );
      ((Element)v.get(215)).setAttribute("width","25" );
      ((Element)v.get(215)).setAttribute("height","8" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));
      /* Termina nodo:215   */
      /* Termina nodo:214   */

      /* Empieza nodo:216 / Elemento padre: 195   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(216)).setAttribute("nombre","tiprOidTipoProdTdId" );
      ((Element)v.get(195)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(217)).setAttribute("border","0" );
      ((Element)v.get(217)).setAttribute("cellspacing","0" );
      ((Element)v.get(217)).setAttribute("cellpadding","0" );
      ((Element)v.get(217)).setAttribute("align","left" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(217)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(219)).setAttribute("valign","top" );
      ((Element)v.get(219)).setAttribute("height","13" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(220)).setAttribute("nombre","lbltiprOidTipoProd" );
      ((Element)v.get(220)).setAttribute("id","datosTitle" );
      ((Element)v.get(220)).setAttribute("ancho","100" );
      ((Element)v.get(220)).setAttribute("alto","13" );
      ((Element)v.get(220)).setAttribute("cod","PreEstra.tiprOidTipoProd.label" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:221 / Elemento padre: 217   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(221)).setAttribute("nombre","tiprOidTipoProdWidgetTrId" );
      ((Element)v.get(217)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(222)).setAttribute("align","left" );
      ((Element)v.get(222)).setAttribute("nowrap","true" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(223)).setAttribute("nombre","tiprOidTipoProd" );
      ((Element)v.get(223)).setAttribute("id","datosCampos" );
      ((Element)v.get(223)).setAttribute("multiple","N" );
      ((Element)v.get(223)).setAttribute("req","N" );
      ((Element)v.get(223)).setAttribute("size","1" );
      ((Element)v.get(223)).setAttribute("disabled","" );
      ((Element)v.get(223)).setAttribute("validacion","" );
      ((Element)v.get(223)).setAttribute("onchange","" );
      ((Element)v.get(223)).setAttribute("onfocus","" );
      ((Element)v.get(223)).setAttribute("valorinicial","" );
      ((Element)v.get(223)).setAttribute("textoinicial","" );
      ((Element)v.get(223)).setAttribute("ontab","ejecutarAccionFoco('preEstraFrm',11, true);" );
      ((Element)v.get(223)).setAttribute("onshtab","ejecutarAccionFoco('preEstraFrm',11, false);" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */
      /* Termina nodo:222   */
      /* Termina nodo:221   */
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:225 / Elemento padre: 195   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(225)).setAttribute("nombre","tiprOidTipoProdGapTdId" );
      ((Element)v.get(225)).setAttribute("nowrap","true" );
      ((Element)v.get(225)).setAttribute("class","datosCampos" );
      ((Element)v.get(195)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(226)).setAttribute("src","b.gif" );
      ((Element)v.get(226)).setAttribute("width","25" );
      ((Element)v.get(226)).setAttribute("height","8" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));
      /* Termina nodo:226   */
      /* Termina nodo:225   */

      /* Empieza nodo:227 / Elemento padre: 195   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(227)).setAttribute("width","100%" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(195)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(228)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));
      /* Termina nodo:228   */
      /* Termina nodo:227   */
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:193   */
      /* Termina nodo:190   */

      /* Empieza nodo:229 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(229)).setAttribute("nombre","formGapTr3" );
      ((Element)v.get(53)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(230)).setAttribute("align","center" );
      ((Element)v.get(230)).setAttribute("width","8" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(231)).setAttribute("src","b.gif" );
      ((Element)v.get(231)).setAttribute("width","12" );
      ((Element)v.get(231)).setAttribute("height","8" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));
      /* Termina nodo:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:232 / Elemento padre: 229   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(229)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(233)).setAttribute("src","b.gif" );
      ((Element)v.get(233)).setAttribute("width","8" );
      ((Element)v.get(233)).setAttribute("height","8" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));
      /* Termina nodo:233   */
      /* Termina nodo:232   */

      /* Empieza nodo:234 / Elemento padre: 229   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(234)).setAttribute("align","center" );
      ((Element)v.get(234)).setAttribute("width","8" );
      ((Element)v.get(229)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(235)).setAttribute("src","b.gif" );
      ((Element)v.get(235)).setAttribute("width","12" );
      ((Element)v.get(235)).setAttribute("height","8" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */
      /* Termina nodo:229   */

      /* Empieza nodo:236 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(236)).setAttribute("nombre","formTr4" );
      ((Element)v.get(53)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(237)).setAttribute("align","center" );
      ((Element)v.get(237)).setAttribute("width","8" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(238)).setAttribute("src","b.gif" );
      ((Element)v.get(238)).setAttribute("width","8" );
      ((Element)v.get(238)).setAttribute("height","12" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */

      /* Empieza nodo:239 / Elemento padre: 236   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(239)).setAttribute("width","100%" );
      ((Element)v.get(236)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(240)).setAttribute("width","100%" );
      ((Element)v.get(240)).setAttribute("border","0" );
      ((Element)v.get(240)).setAttribute("cellspacing","0" );
      ((Element)v.get(240)).setAttribute("cellpadding","0" );
      ((Element)v.get(240)).setAttribute("align","left" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(241)).setAttribute("align","left" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(242)).setAttribute("nombre","indCvImprTdId" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(243)).setAttribute("width","100%" );
      ((Element)v.get(243)).setAttribute("border","0" );
      ((Element)v.get(243)).setAttribute("cellspacing","0" );
      ((Element)v.get(243)).setAttribute("cellpadding","0" );
      ((Element)v.get(243)).setAttribute("align","left" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(243)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(245)).setAttribute("valign","top" );
      ((Element)v.get(245)).setAttribute("height","13" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(246)).setAttribute("nombre","lblIndCvImpr" );
      ((Element)v.get(246)).setAttribute("alto","13" );
      ((Element)v.get(246)).setAttribute("filas","1" );
      ((Element)v.get(246)).setAttribute("id","datosTitle" );
      ((Element)v.get(246)).setAttribute("cod","PreEstra.indCvImpr.label" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */
      /* Termina nodo:244   */

      /* Empieza nodo:247 / Elemento padre: 243   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(247)).setAttribute("nombre","indCvImprWidgetTrId" );
      ((Element)v.get(243)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(248)).setAttribute("align","left" );
      ((Element)v.get(248)).setAttribute("nowrap","true" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(249)).setAttribute("nombre","indCvImpr" );
      ((Element)v.get(249)).setAttribute("check","N" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(249)).setAttribute("id","datosCampos" );
      ((Element)v.get(249)).setAttribute("onclick","" );
      ((Element)v.get(249)).setAttribute("onfocus","" );
      ((Element)v.get(249)).setAttribute("disabled","" );
      ((Element)v.get(249)).setAttribute("ontab","ejecutarAccionFoco('preEstraFrm',12, true)" );
      ((Element)v.get(249)).setAttribute("onshtab","ejecutarAccionFoco('preEstraFrm',12, false)" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */
      /* Termina nodo:247   */
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:250 / Elemento padre: 241   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(250)).setAttribute("nombre","indCvImprGapTdId" );
      ((Element)v.get(250)).setAttribute("nowrap","true" );
      ((Element)v.get(250)).setAttribute("class","datosCampos" );
      ((Element)v.get(241)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(251)).setAttribute("src","b.gif" );
      ((Element)v.get(251)).setAttribute("width","25" );
      ((Element)v.get(251)).setAttribute("height","8" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));
      /* Termina nodo:251   */
      /* Termina nodo:250   */

      /* Empieza nodo:252 / Elemento padre: 241   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(252)).setAttribute("nombre","indModiImprTdId" );
      ((Element)v.get(241)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(253)).setAttribute("width","100%" );
      ((Element)v.get(253)).setAttribute("border","0" );
      ((Element)v.get(253)).setAttribute("cellspacing","0" );
      ((Element)v.get(253)).setAttribute("cellpadding","0" );
      ((Element)v.get(253)).setAttribute("align","left" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(253)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(255)).setAttribute("valign","top" );
      ((Element)v.get(255)).setAttribute("height","13" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(256)).setAttribute("nombre","lblIndModiImpr" );
      ((Element)v.get(256)).setAttribute("alto","13" );
      ((Element)v.get(256)).setAttribute("filas","1" );
      ((Element)v.get(256)).setAttribute("id","datosTitle" );
      ((Element)v.get(256)).setAttribute("cod","PreEstra.indModiImpr.label" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));
      /* Termina nodo:256   */
      /* Termina nodo:255   */
      /* Termina nodo:254   */

      /* Empieza nodo:257 / Elemento padre: 253   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(257)).setAttribute("nombre","indModiImprWidgetTrId" );
      ((Element)v.get(253)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(258)).setAttribute("align","left" );
      ((Element)v.get(258)).setAttribute("nowrap","true" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(259)).setAttribute("nombre","indModiImpr" );
      ((Element)v.get(259)).setAttribute("check","N" );
      ((Element)v.get(259)).setAttribute("id","datosCampos" );
      ((Element)v.get(259)).setAttribute("onclick","" );
      ((Element)v.get(259)).setAttribute("onfocus","" );
      ((Element)v.get(259)).setAttribute("disabled","" );
      ((Element)v.get(259)).setAttribute("ontab","ejecutarAccionFoco('preEstraFrm',13, true)" );
      ((Element)v.get(259)).setAttribute("onshtab","ejecutarAccionFoco('preEstraFrm',13, false)" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));
      /* Termina nodo:259   */
      /* Termina nodo:258   */
      /* Termina nodo:257   */
      /* Termina nodo:253   */
      /* Termina nodo:252   */

      /* Empieza nodo:260 / Elemento padre: 241   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(260)).setAttribute("nombre","indModiImprGapTdId" );
      ((Element)v.get(260)).setAttribute("nowrap","true" );
      ((Element)v.get(260)).setAttribute("class","datosCampos" );
      ((Element)v.get(241)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(261)).setAttribute("src","b.gif" );
      ((Element)v.get(261)).setAttribute("width","25" );
      ((Element)v.get(261)).setAttribute("height","8" );
      ((Element)v.get(260)).appendChild((Element)v.get(261));
      /* Termina nodo:261   */
      /* Termina nodo:260   */

      /* Empieza nodo:262 / Elemento padre: 241   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(262)).setAttribute("nombre","indCvDespAutoTdId" );
      ((Element)v.get(241)).appendChild((Element)v.get(262));

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
      ((Element)v.get(266)).setAttribute("nombre","lblIndCvDespAuto" );
      ((Element)v.get(266)).setAttribute("alto","13" );
      ((Element)v.get(266)).setAttribute("filas","1" );
      ((Element)v.get(266)).setAttribute("id","datosTitle" );
      ((Element)v.get(266)).setAttribute("cod","PreEstra.indCvDespAuto.label" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */
      /* Termina nodo:264   */

      /* Empieza nodo:267 / Elemento padre: 263   */
   }

   private void getXML1260(Document doc) {
      v.add(doc.createElement("TR"));
      ((Element)v.get(267)).setAttribute("nombre","indCvDespAutoWidgetTrId" );
      ((Element)v.get(263)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(268)).setAttribute("align","left" );
      ((Element)v.get(268)).setAttribute("nowrap","true" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(269)).setAttribute("nombre","indCvDespAuto" );
      ((Element)v.get(269)).setAttribute("check","N" );
      ((Element)v.get(269)).setAttribute("id","datosCampos" );
      ((Element)v.get(269)).setAttribute("onclick","" );
      ((Element)v.get(269)).setAttribute("onfocus","" );
      ((Element)v.get(269)).setAttribute("disabled","" );
      ((Element)v.get(269)).setAttribute("ontab","ejecutarAccionFoco('preEstraFrm',14, true)" );
      ((Element)v.get(269)).setAttribute("onshtab","ejecutarAccionFoco('preEstraFrm',14, false)" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */
      /* Termina nodo:267   */
      /* Termina nodo:263   */
      /* Termina nodo:262   */

      /* Empieza nodo:270 / Elemento padre: 241   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(270)).setAttribute("nombre","indCvDespAutoGapTdId" );
      ((Element)v.get(270)).setAttribute("nowrap","true" );
      ((Element)v.get(270)).setAttribute("class","datosCampos" );
      ((Element)v.get(241)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(271)).setAttribute("width","25" );
      ((Element)v.get(271)).setAttribute("height","8" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */

      /* Empieza nodo:272 / Elemento padre: 241   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(272)).setAttribute("width","100%" );
      ((Element)v.get(241)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(273)).setAttribute("src","b.gif" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */
      /* Termina nodo:272   */
      /* Termina nodo:241   */
      /* Termina nodo:240   */
      /* Termina nodo:239   */
      /* Termina nodo:236   */

      /* Empieza nodo:274 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(274)).setAttribute("nombre","formGapTr4" );
      ((Element)v.get(53)).appendChild((Element)v.get(274));

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

      /* Empieza nodo:281 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(281)).setAttribute("nombre","formTr5" );
      ((Element)v.get(53)).appendChild((Element)v.get(281));

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
      ((Element)v.get(287)).setAttribute("nombre","indModiDespTdId" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("TABLE"));
   }

   private void getXML1350(Document doc) {
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
      ((Element)v.get(291)).setAttribute("nombre","lblIndModiDesp" );
      ((Element)v.get(291)).setAttribute("alto","13" );
      ((Element)v.get(291)).setAttribute("filas","1" );
      ((Element)v.get(291)).setAttribute("id","datosTitle" );
      ((Element)v.get(291)).setAttribute("cod","PreEstra.indModiDesp.label" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */
      /* Termina nodo:289   */

      /* Empieza nodo:292 / Elemento padre: 288   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(292)).setAttribute("nombre","indModiDespWidgetTrId" );
      ((Element)v.get(288)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(293)).setAttribute("align","left" );
      ((Element)v.get(293)).setAttribute("nowrap","true" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));

      /* Empieza nodo:294 / Elemento padre: 293   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(294)).setAttribute("nombre","indModiDesp" );
      ((Element)v.get(294)).setAttribute("check","N" );
      ((Element)v.get(294)).setAttribute("id","datosCampos" );
      ((Element)v.get(294)).setAttribute("onclick","" );
      ((Element)v.get(294)).setAttribute("onfocus","" );
      ((Element)v.get(294)).setAttribute("disabled","" );
      ((Element)v.get(294)).setAttribute("ontab","ejecutarAccionFoco('preEstraFrm',15, true)" );
      ((Element)v.get(294)).setAttribute("onshtab","ejecutarAccionFoco('preEstraFrm',15, false)" );
      ((Element)v.get(293)).appendChild((Element)v.get(294));
      /* Termina nodo:294   */
      /* Termina nodo:293   */
      /* Termina nodo:292   */
      /* Termina nodo:288   */
      /* Termina nodo:287   */

      /* Empieza nodo:295 / Elemento padre: 286   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(295)).setAttribute("nombre","indModiDespGapTdId" );
      ((Element)v.get(295)).setAttribute("nowrap","true" );
      ((Element)v.get(295)).setAttribute("class","datosCampos" );
      ((Element)v.get(286)).appendChild((Element)v.get(295));

      /* Empieza nodo:296 / Elemento padre: 295   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(296)).setAttribute("src","b.gif" );
      ((Element)v.get(296)).setAttribute("width","25" );
      ((Element)v.get(296)).setAttribute("height","8" );
      ((Element)v.get(295)).appendChild((Element)v.get(296));
      /* Termina nodo:296   */
      /* Termina nodo:295   */

      /* Empieza nodo:297 / Elemento padre: 286   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(297)).setAttribute("nombre","indCvDigiTdId" );
      ((Element)v.get(286)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(298)).setAttribute("width","100%" );
      ((Element)v.get(298)).setAttribute("border","0" );
      ((Element)v.get(298)).setAttribute("cellspacing","0" );
      ((Element)v.get(298)).setAttribute("cellpadding","0" );
      ((Element)v.get(298)).setAttribute("align","left" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(298)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(300)).setAttribute("valign","top" );
      ((Element)v.get(300)).setAttribute("height","13" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));

      /* Empieza nodo:301 / Elemento padre: 300   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(301)).setAttribute("nombre","lblIndCvDigi" );
      ((Element)v.get(301)).setAttribute("alto","13" );
      ((Element)v.get(301)).setAttribute("filas","1" );
      ((Element)v.get(301)).setAttribute("id","datosTitle" );
      ((Element)v.get(301)).setAttribute("cod","PreEstra.indCvDigi.label" );
      ((Element)v.get(300)).appendChild((Element)v.get(301));
      /* Termina nodo:301   */
      /* Termina nodo:300   */
      /* Termina nodo:299   */

      /* Empieza nodo:302 / Elemento padre: 298   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(302)).setAttribute("nombre","indCvDigiWidgetTrId" );
      ((Element)v.get(298)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(303)).setAttribute("align","left" );
      ((Element)v.get(303)).setAttribute("nowrap","true" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(304)).setAttribute("nombre","indCvDigi" );
      ((Element)v.get(304)).setAttribute("check","N" );
      ((Element)v.get(304)).setAttribute("id","datosCampos" );
      ((Element)v.get(304)).setAttribute("onclick","" );
      ((Element)v.get(304)).setAttribute("onfocus","" );
      ((Element)v.get(304)).setAttribute("disabled","" );
      ((Element)v.get(304)).setAttribute("ontab","ejecutarAccionFoco('preEstraFrm',16, true)" );
      ((Element)v.get(304)).setAttribute("onshtab","ejecutarAccionFoco('preEstraFrm',16, false)" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));
      /* Termina nodo:304   */
      /* Termina nodo:303   */
      /* Termina nodo:302   */
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:305 / Elemento padre: 286   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(305)).setAttribute("nombre","indCvDigiGapTdId" );
      ((Element)v.get(305)).setAttribute("nowrap","true" );
      ((Element)v.get(305)).setAttribute("class","datosCampos" );
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(286)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(306)).setAttribute("src","b.gif" );
      ((Element)v.get(306)).setAttribute("width","25" );
      ((Element)v.get(306)).setAttribute("height","8" );
      ((Element)v.get(305)).appendChild((Element)v.get(306));
      /* Termina nodo:306   */
      /* Termina nodo:305   */

      /* Empieza nodo:307 / Elemento padre: 286   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(307)).setAttribute("nombre","indModiDigiTdId" );
      ((Element)v.get(286)).appendChild((Element)v.get(307));

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
      ((Element)v.get(308)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(310)).setAttribute("valign","top" );
      ((Element)v.get(310)).setAttribute("height","13" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(311)).setAttribute("nombre","lblIndModiDigi" );
      ((Element)v.get(311)).setAttribute("alto","13" );
      ((Element)v.get(311)).setAttribute("filas","1" );
      ((Element)v.get(311)).setAttribute("id","datosTitle" );
      ((Element)v.get(311)).setAttribute("cod","PreEstra.indModiDigi.label" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */
      /* Termina nodo:309   */

      /* Empieza nodo:312 / Elemento padre: 308   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(312)).setAttribute("nombre","indModiDigiWidgetTrId" );
      ((Element)v.get(308)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(313)).setAttribute("align","left" );
      ((Element)v.get(313)).setAttribute("nowrap","true" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));

      /* Empieza nodo:314 / Elemento padre: 313   */
      v.add(doc.createElement("CHECKBOX"));
      ((Element)v.get(314)).setAttribute("nombre","indModiDigi" );
      ((Element)v.get(314)).setAttribute("check","N" );
      ((Element)v.get(314)).setAttribute("id","datosCampos" );
      ((Element)v.get(314)).setAttribute("onclick","" );
      ((Element)v.get(314)).setAttribute("onfocus","" );
      ((Element)v.get(314)).setAttribute("disabled","" );
      ((Element)v.get(314)).setAttribute("ontab","ejecutarAccionFoco('preEstraFrm',17, true)" );
      ((Element)v.get(314)).setAttribute("onshtab","ejecutarAccionFoco('preEstraFrm',17, false)" );
      ((Element)v.get(313)).appendChild((Element)v.get(314));
      /* Termina nodo:314   */
      /* Termina nodo:313   */
      /* Termina nodo:312   */
      /* Termina nodo:308   */
      /* Termina nodo:307   */

      /* Empieza nodo:315 / Elemento padre: 286   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(315)).setAttribute("nombre","indModiDigiGapTdId" );
      ((Element)v.get(315)).setAttribute("nowrap","true" );
      ((Element)v.get(315)).setAttribute("class","datosCampos" );
      ((Element)v.get(286)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(316)).setAttribute("src","b.gif" );
      ((Element)v.get(316)).setAttribute("width","25" );
      ((Element)v.get(316)).setAttribute("height","8" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */

      /* Empieza nodo:317 / Elemento padre: 286   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(317)).setAttribute("width","100%" );
      ((Element)v.get(286)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(318)).setAttribute("src","b.gif" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:317   */
      /* Termina nodo:286   */
      /* Termina nodo:285   */
      /* Termina nodo:284   */

      /* Empieza nodo:319 / Elemento padre: 281   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(319)).setAttribute("width","100%" );
      ((Element)v.get(281)).appendChild((Element)v.get(319));
      /* Termina nodo:319   */
      /* Termina nodo:281   */

      /* Empieza nodo:320 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(320)).setAttribute("nombre","formGapTr5" );
      ((Element)v.get(53)).appendChild((Element)v.get(320));

      /* Empieza nodo:321 / Elemento padre: 320   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(321)).setAttribute("align","center" );
      ((Element)v.get(321)).setAttribute("width","8" );
      ((Element)v.get(320)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(322)).setAttribute("src","b.gif" );
      ((Element)v.get(322)).setAttribute("width","8" );
      ((Element)v.get(322)).setAttribute("height","8" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */
      /* Termina nodo:321   */

      /* Empieza nodo:323 / Elemento padre: 320   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(320)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(324)).setAttribute("src","b.gif" );
      ((Element)v.get(324)).setAttribute("width","8" );
      ((Element)v.get(324)).setAttribute("height","8" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));
      /* Termina nodo:324   */
      /* Termina nodo:323   */

      /* Empieza nodo:325 / Elemento padre: 320   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(325)).setAttribute("align","center" );
      ((Element)v.get(325)).setAttribute("width","8" );
      ((Element)v.get(320)).appendChild((Element)v.get(325));

      /* Empieza nodo:326 / Elemento padre: 325   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(326)).setAttribute("src","b.gif" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(326)).setAttribute("width","8" );
      ((Element)v.get(326)).setAttribute("height","8" );
      ((Element)v.get(325)).appendChild((Element)v.get(326));
      /* Termina nodo:326   */
      /* Termina nodo:325   */
      /* Termina nodo:320   */
      /* Termina nodo:53   */
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:327 / Elemento padre: 46   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(327)).setAttribute("align","center" );
      ((Element)v.get(327)).setAttribute("width","12" );
      ((Element)v.get(46)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(328)).setAttribute("src","b.gif" );
      ((Element)v.get(328)).setAttribute("width","12" );
      ((Element)v.get(328)).setAttribute("height","12" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));
      /* Termina nodo:328   */
      /* Termina nodo:327   */
      /* Termina nodo:46   */

      /* Empieza nodo:329 / Elemento padre: 38   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(329)).setAttribute("nombre","preEstraTrButtons" );
      ((Element)v.get(38)).appendChild((Element)v.get(329));

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
      ((Element)v.get(329)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(332)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(334)).setAttribute("width","100%" );
      ((Element)v.get(334)).setAttribute("border","0" );
      ((Element)v.get(334)).setAttribute("align","center" );
      ((Element)v.get(334)).setAttribute("cellspacing","0" );
      ((Element)v.get(334)).setAttribute("cellpadding","0" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(334)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(336)).setAttribute("class","tablaTitle" );
      ((Element)v.get(336)).setAttribute("nombre","preEstraTdQueryButton" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(337)).setAttribute("nombre","preEstraQueryButton" );
      ((Element)v.get(337)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(337)).setAttribute("estado","false" );
      ((Element)v.get(337)).setAttribute("accion","preEstraFirstPage();" );
      ((Element)v.get(337)).setAttribute("tipo","html" );
      ((Element)v.get(337)).setAttribute("ID","botonContenido" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));
      /* Termina nodo:337   */
      /* Termina nodo:336   */

      /* Empieza nodo:338 / Elemento padre: 335   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(338)).setAttribute("class","tablaTitle" );
      ((Element)v.get(338)).setAttribute("nombre","preEstraTdLovNullSelectionButton" );
      ((Element)v.get(338)).setAttribute("align","left" );
      ((Element)v.get(338)).setAttribute("width","100%" );
      ((Element)v.get(335)).appendChild((Element)v.get(338));

      /* Empieza nodo:339 / Elemento padre: 338   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(339)).setAttribute("src","b.gif" );
      ((Element)v.get(339)).setAttribute("height","8" );
      ((Element)v.get(339)).setAttribute("width","8" );
      ((Element)v.get(338)).appendChild((Element)v.get(339));
      /* Termina nodo:339   */

      /* Empieza nodo:340 / Elemento padre: 338   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(340)).setAttribute("nombre","preEstraLovNullButton" );
      ((Element)v.get(340)).setAttribute("ID","botonContenido" );
      ((Element)v.get(340)).setAttribute("tipo","html" );
      ((Element)v.get(340)).setAttribute("accion","preEstraLovNullSelectionAction();" );
      ((Element)v.get(340)).setAttribute("estado","true" );
      ((Element)v.get(340)).setAttribute("cod","MMGGlobal.lovNullButton.label" );
      ((Element)v.get(338)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:338   */
      /* Termina nodo:335   */
      /* Termina nodo:334   */
      /* Termina nodo:333   */
      /* Termina nodo:332   */

      /* Empieza nodo:341 / Elemento padre: 329   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(341)).setAttribute("align","center" );
      ((Element)v.get(341)).setAttribute("width","12" );
      ((Element)v.get(329)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(342)).setAttribute("src","b.gif" );
      ((Element)v.get(342)).setAttribute("width","12" );
      ((Element)v.get(342)).setAttribute("height","12" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));
      /* Termina nodo:342   */
      /* Termina nodo:341   */
      /* Termina nodo:329   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:343 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(343)).setAttribute("nombre","preEstraListLayer" );
      ((Element)v.get(343)).setAttribute("alto","310" );
      ((Element)v.get(343)).setAttribute("ancho","99%" );
      ((Element)v.get(343)).setAttribute("colorf","" );
      ((Element)v.get(343)).setAttribute("borde","0" );
      ((Element)v.get(343)).setAttribute("imagenf","" );
      ((Element)v.get(343)).setAttribute("repeat","" );
      ((Element)v.get(343)).setAttribute("padding","" );
      ((Element)v.get(343)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(343)).setAttribute("contravsb","" );
      ((Element)v.get(343)).setAttribute("x","3" );
      ((Element)v.get(343)).setAttribute("y","" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(343)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(343));

      /* Empieza nodo:344 / Elemento padre: 343   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(344)).setAttribute("nombre","preEstraList" );
      ((Element)v.get(344)).setAttribute("ancho","680" );
      ((Element)v.get(344)).setAttribute("alto","275" );
      ((Element)v.get(344)).setAttribute("x","12" );
      ((Element)v.get(344)).setAttribute("y","0" );
      ((Element)v.get(344)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(344)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(343)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(345)).setAttribute("precarga","S" );
      ((Element)v.get(345)).setAttribute("conROver","S" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));

      /* Empieza nodo:346 / Elemento padre: 345   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(346)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(346)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(346)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(346)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(345)).appendChild((Element)v.get(346));
      /* Termina nodo:346   */

      /* Empieza nodo:347 / Elemento padre: 345   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(347)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(347)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(347)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(347)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(345)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */
      /* Termina nodo:345   */

      /* Empieza nodo:348 / Elemento padre: 344   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(344)).appendChild((Element)v.get(348));

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

      /* Empieza nodo:351 / Elemento padre: 344   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(351)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(351)).setAttribute("alto","22" );
      ((Element)v.get(351)).setAttribute("imgFondo","" );
      ((Element)v.get(351)).setAttribute("cod","00135" );
      ((Element)v.get(351)).setAttribute("ID","datosTitle" );
      ((Element)v.get(344)).appendChild((Element)v.get(351));
      /* Termina nodo:351   */

      /* Empieza nodo:352 / Elemento padre: 344   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(352)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(352)).setAttribute("alto","22" );
      ((Element)v.get(352)).setAttribute("imgFondo","" );
      ((Element)v.get(344)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */

      /* Empieza nodo:353 / Elemento padre: 344   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(353)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(353)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(353)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(353)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(353)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(344)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(354)).setAttribute("ancho","100" );
      ((Element)v.get(354)).setAttribute("minimizable","S" );
      ((Element)v.get(354)).setAttribute("minimizada","N" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));
      /* Termina nodo:354   */

      /* Empieza nodo:355 / Elemento padre: 353   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(355)).setAttribute("ancho","100" );
      ((Element)v.get(355)).setAttribute("minimizable","S" );
      ((Element)v.get(355)).setAttribute("minimizada","N" );
      ((Element)v.get(353)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */

      /* Empieza nodo:356 / Elemento padre: 353   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(356)).setAttribute("ancho","100" );
      ((Element)v.get(356)).setAttribute("minimizable","S" );
      ((Element)v.get(356)).setAttribute("minimizada","N" );
      ((Element)v.get(353)).appendChild((Element)v.get(356));
      /* Termina nodo:356   */
      /* Termina nodo:353   */

      /* Empieza nodo:357 / Elemento padre: 344   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(357)).setAttribute("height","20" );
      ((Element)v.get(357)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(357)).setAttribute("imgFondo","" );
      ((Element)v.get(357)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(344)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(358)).setAttribute("colFondo","" );
      ((Element)v.get(358)).setAttribute("ID","EstCab" );
      ((Element)v.get(358)).setAttribute("cod","PreEstra.codEstr.label" );
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */

      /* Empieza nodo:359 / Elemento padre: 357   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(359)).setAttribute("colFondo","" );
      ((Element)v.get(359)).setAttribute("ID","EstCab" );
      ((Element)v.get(359)).setAttribute("cod","PreEstra.Descripcion.label" );
      ((Element)v.get(357)).appendChild((Element)v.get(359));
      /* Termina nodo:359   */

      /* Empieza nodo:360 / Elemento padre: 357   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(360)).setAttribute("colFondo","" );
      ((Element)v.get(360)).setAttribute("ID","EstCab" );
      ((Element)v.get(360)).setAttribute("cod","PreEstra.tiesOidTipoEstr.label" );
      ((Element)v.get(357)).appendChild((Element)v.get(360));
      /* Termina nodo:360   */
      /* Termina nodo:357   */

      /* Empieza nodo:361 / Elemento padre: 344   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(361)).setAttribute("alto","22" );
      ((Element)v.get(361)).setAttribute("accion","" );
      ((Element)v.get(361)).setAttribute("tipoEnvio","seleccion" );
      ((Element)v.get(361)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(361)).setAttribute("maxSel","1" );
      ((Element)v.get(361)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(361)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(361)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(361)).setAttribute("onLoad","" );
      ((Element)v.get(361)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(344)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(362)).setAttribute("tipo","texto" );
      ((Element)v.get(362)).setAttribute("ID","EstDat" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */

      /* Empieza nodo:363 / Elemento padre: 361   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(363)).setAttribute("tipo","texto" );
      ((Element)v.get(363)).setAttribute("ID","EstDat2" );
      ((Element)v.get(361)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */

      /* Empieza nodo:364 / Elemento padre: 361   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(364)).setAttribute("tipo","texto" );
      ((Element)v.get(364)).setAttribute("ID","EstDat" );
      ((Element)v.get(361)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */
      /* Termina nodo:361   */

      /* Empieza nodo:365 / Elemento padre: 344   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(344)).appendChild((Element)v.get(365));
      /* Termina nodo:365   */
      /* Termina nodo:344   */
      /* Termina nodo:343   */

      /* Empieza nodo:366 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(366)).setAttribute("nombre","preEstraListButtonsLayer" );
      ((Element)v.get(366)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(366)).setAttribute("alto","30" );
      ((Element)v.get(366)).setAttribute("ancho","98%" );
      ((Element)v.get(366)).setAttribute("borde","n" );
      ((Element)v.get(366)).setAttribute("imagenf","" );
      ((Element)v.get(366)).setAttribute("repeat","" );
      ((Element)v.get(366)).setAttribute("padding","0" );
      ((Element)v.get(366)).setAttribute("contravsb","" );
      ((Element)v.get(366)).setAttribute("x","16" );
      ((Element)v.get(366)).setAttribute("y","" );
      ((Element)v.get(366)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(367)).setAttribute("nombre","toolbarSeparatorLayer" );
      ((Element)v.get(367)).setAttribute("visibilidad","inherit" );
      ((Element)v.get(367)).setAttribute("alto","23" );
      ((Element)v.get(367)).setAttribute("ancho","1" );
      ((Element)v.get(367)).setAttribute("borde","1" );
      ((Element)v.get(367)).setAttribute("imagenf","" );
      ((Element)v.get(367)).setAttribute("repeat","" );
      ((Element)v.get(367)).setAttribute("padding","0" );
      ((Element)v.get(367)).setAttribute("contravsb","" );
      ((Element)v.get(367)).setAttribute("x","56" );
      ((Element)v.get(367)).setAttribute("y","0" );
      ((Element)v.get(367)).setAttribute("zindex","" );
      ((Element)v.get(367)).setAttribute("colborde","#999999" );
      ((Element)v.get(366)).appendChild((Element)v.get(367));
      /* Termina nodo:367   */

      /* Empieza nodo:368 / Elemento padre: 366   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(368)).setAttribute("width","100%" );
      ((Element)v.get(368)).setAttribute("border","0" );
      ((Element)v.get(368)).setAttribute("cellspacing","1" );
      ((Element)v.get(368)).setAttribute("cellpadding","0" );
      ((Element)v.get(366)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(368)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(370)).setAttribute("src","b.gif" );
      ((Element)v.get(370)).setAttribute("height","22" );
      ((Element)v.get(370)).setAttribute("width","5" );
      ((Element)v.get(369)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */
      /* Termina nodo:369   */

      /* Empieza nodo:371 / Elemento padre: 368   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(368)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("BOTONERA"));
      ((Element)v.get(372)).setAttribute("nombre","preEstraPaginationButtonBar" );
      ((Element)v.get(372)).setAttribute("tipo","H" );
      ((Element)v.get(372)).setAttribute("x","0" );
      ((Element)v.get(372)).setAttribute("y","0" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(373)).setAttribute("nombre","preEstraFirstPageButton" );
      ((Element)v.get(373)).setAttribute("funcion","preEstraFirstPage();" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(373)).setAttribute("off","primera_over0.gif" );
      ((Element)v.get(373)).setAttribute("on","primera_over0.gif" );
      ((Element)v.get(373)).setAttribute("disable","primera_on0.gif" );
      ((Element)v.get(373)).setAttribute("estado","inactivo" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */

      /* Empieza nodo:374 / Elemento padre: 372   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(374)).setAttribute("nombre","preEstraFirstPageButtonGapTd" );
      ((Element)v.get(372)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(375)).setAttribute("src","b.gif" );
      ((Element)v.get(375)).setAttribute("height","8" );
      ((Element)v.get(375)).setAttribute("width","5" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */
      /* Termina nodo:374   */

      /* Empieza nodo:376 / Elemento padre: 372   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(376)).setAttribute("nombre","preEstraPreviousPageButton" );
      ((Element)v.get(376)).setAttribute("funcion","preEstraPreviousPage();" );
      ((Element)v.get(376)).setAttribute("off","retroceder_over0.gif" );
      ((Element)v.get(376)).setAttribute("on","retroceder_over0.gif" );
      ((Element)v.get(376)).setAttribute("disable","retroceder_on0.gif" );
      ((Element)v.get(376)).setAttribute("estado","inactivo" );
      ((Element)v.get(372)).appendChild((Element)v.get(376));
      /* Termina nodo:376   */

      /* Empieza nodo:377 / Elemento padre: 372   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(377)).setAttribute("nombre","preEstraPreviousPageButtonGapTd" );
      ((Element)v.get(372)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(378)).setAttribute("src","b.gif" );
      ((Element)v.get(378)).setAttribute("height","8" );
      ((Element)v.get(378)).setAttribute("width","8" );
      ((Element)v.get(377)).appendChild((Element)v.get(378));
      /* Termina nodo:378   */
      /* Termina nodo:377   */

      /* Empieza nodo:379 / Elemento padre: 372   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(379)).setAttribute("nombre","preEstraNextPageButton" );
      ((Element)v.get(379)).setAttribute("funcion","preEstraNextPage();" );
      ((Element)v.get(379)).setAttribute("off","avanzar_over0.gif" );
      ((Element)v.get(379)).setAttribute("on","avanzar_over0.gif" );
      ((Element)v.get(379)).setAttribute("disable","avanzar_on0.gif" );
      ((Element)v.get(379)).setAttribute("estado","inactivo" );
      ((Element)v.get(372)).appendChild((Element)v.get(379));
      /* Termina nodo:379   */
      /* Termina nodo:372   */
      /* Termina nodo:371   */

      /* Empieza nodo:380 / Elemento padre: 368   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(368)).appendChild((Element)v.get(380));

      /* Empieza nodo:381 / Elemento padre: 380   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(381)).setAttribute("src","b.gif" );
      ((Element)v.get(381)).setAttribute("height","22" );
      ((Element)v.get(381)).setAttribute("width","19" );
      ((Element)v.get(380)).appendChild((Element)v.get(381));
      /* Termina nodo:381   */
      /* Termina nodo:380   */

      /* Empieza nodo:382 / Elemento padre: 368   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(382)).setAttribute("class","tablaTitle" );
      ((Element)v.get(382)).setAttribute("nombre","preEstraUpdateButtonTd" );
      ((Element)v.get(368)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(383)).setAttribute("nombre","preEstraUpdateButton" );
      ((Element)v.get(383)).setAttribute("ID","botonContenido" );
      ((Element)v.get(383)).setAttribute("tipo","html" );
      ((Element)v.get(383)).setAttribute("accion","preEstraUpdateSelection();" );
      ((Element)v.get(383)).setAttribute("estado","false" );
      ((Element)v.get(383)).setAttribute("cod","MMGGlobal.updateButton.label" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));
      /* Termina nodo:383   */
      /* Termina nodo:382   */

      /* Empieza nodo:384 / Elemento padre: 368   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(384)).setAttribute("nombre","preEstraUpdateButtonGapTd" );
      ((Element)v.get(368)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(385)).setAttribute("src","b.gif" );
      ((Element)v.get(385)).setAttribute("height","8" );
      ((Element)v.get(385)).setAttribute("width","10" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));
      /* Termina nodo:385   */
      /* Termina nodo:384   */

      /* Empieza nodo:386 / Elemento padre: 368   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(386)).setAttribute("class","tablaTitle" );
      ((Element)v.get(386)).setAttribute("nombre","preEstraViewForRemoveButtonTd" );
      ((Element)v.get(368)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(387)).setAttribute("nombre","preEstraViewForRemoveButton" );
      ((Element)v.get(387)).setAttribute("ID","botonContenido" );
      ((Element)v.get(387)).setAttribute("tipo","html" );
      ((Element)v.get(387)).setAttribute("accion","preEstraViewSelection();" );
      ((Element)v.get(387)).setAttribute("estado","false" );
      ((Element)v.get(387)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));
      /* Termina nodo:387   */
      /* Termina nodo:386   */

      /* Empieza nodo:388 / Elemento padre: 368   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(388)).setAttribute("nombre","preEstraViewForRemoveButtonGapTd" );
      ((Element)v.get(368)).appendChild((Element)v.get(388));

      /* Empieza nodo:389 / Elemento padre: 388   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(389)).setAttribute("src","b.gif" );
      ((Element)v.get(389)).setAttribute("height","8" );
      ((Element)v.get(389)).setAttribute("width","10" );
      ((Element)v.get(388)).appendChild((Element)v.get(389));
      /* Termina nodo:389   */
      /* Termina nodo:388   */

      /* Empieza nodo:390 / Elemento padre: 368   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(390)).setAttribute("class","tablaTitle" );
      ((Element)v.get(390)).setAttribute("nombre","preEstraLovSelectButtonTd" );
      ((Element)v.get(368)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(391)).setAttribute("nombre","preEstraLovSelectButton" );
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(391)).setAttribute("ID","botonContenido" );
      ((Element)v.get(391)).setAttribute("tipo","html" );
      ((Element)v.get(391)).setAttribute("accion","preEstraLovSelectionAction();" );
      ((Element)v.get(391)).setAttribute("estado","true" );
      ((Element)v.get(391)).setAttribute("cod","MMGGlobal.lovSelectButton.label" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */
      /* Termina nodo:390   */

      /* Empieza nodo:392 / Elemento padre: 368   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(392)).setAttribute("nombre","preEstraLovSelectButtonGapTd" );
      ((Element)v.get(368)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(393)).setAttribute("src","b.gif" );
      ((Element)v.get(393)).setAttribute("height","8" );
      ((Element)v.get(393)).setAttribute("width","10" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));
      /* Termina nodo:393   */
      /* Termina nodo:392   */

      /* Empieza nodo:394 / Elemento padre: 368   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(394)).setAttribute("class","tablaTitle" );
      ((Element)v.get(394)).setAttribute("nombre","preEstraViewButtonTd" );
      ((Element)v.get(368)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(395)).setAttribute("nombre","preEstraViewButton" );
      ((Element)v.get(395)).setAttribute("ID","botonContenido" );
      ((Element)v.get(395)).setAttribute("tipo","html" );
      ((Element)v.get(395)).setAttribute("accion","preEstraViewSelection();" );
      ((Element)v.get(395)).setAttribute("estado","false" );
      ((Element)v.get(395)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */
      /* Termina nodo:394   */

      /* Empieza nodo:396 / Elemento padre: 368   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(396)).setAttribute("nombre","preEstraViewButtonGapTd" );
      ((Element)v.get(368)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(397)).setAttribute("src","b.gif" );
      ((Element)v.get(397)).setAttribute("height","8" );
      ((Element)v.get(397)).setAttribute("width","10" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));
      /* Termina nodo:397   */
      /* Termina nodo:396   */

      /* Empieza nodo:398 / Elemento padre: 368   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(398)).setAttribute("width","100%" );
      ((Element)v.get(368)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */
      /* Termina nodo:368   */
      /* Termina nodo:366   */
      /* Termina nodo:5   */


   }

}

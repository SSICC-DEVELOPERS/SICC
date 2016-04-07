
import org.w3c.dom.*;
import java.util.ArrayList;

public class PedTipoSolicPage  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","PedTipoSolicPage" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","pedTipoSolicInitComponents()" );
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
      ((Element)v.get(4)).setAttribute("src","pedtiposolic.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));
      /* Termina nodo:4   */

      /* Empieza nodo:5 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(5)).setAttribute("nombre","pedTipoSolicFrm" );
      ((Element)v.get(5)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(5));

      /* Empieza nodo:6 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(6)).setAttribute("valor","PedTipoSolicLPExecution" );
      ((Element)v.get(5)).appendChild((Element)v.get(6));
      /* Termina nodo:6   */

      /* Empieza nodo:7 / Elemento padre: 5   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(7)).setAttribute("nombre","ON" );
      ((Element)v.get(7)).setAttribute("valor","PedTipoSolicLPExecution" );
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
      ((Element)v.get(37)).setAttribute("nombre","pedTipoSolicFormLayer" );
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
      ((Element)v.get(52)).setAttribute("cod","PedTipoSolic.legend.label" );
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
      ((Element)v.get(67)).setAttribute("cod","PedTipoSolic.id.label" );
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
      ((Element)v.get(70)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicFrm',1, true)" );
      ((Element)v.get(70)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicFrm', 1, false)" );
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
      ((Element)v.get(88)).setAttribute("nombre","codTipoSoliTdId" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));

      /* Empieza nodo:89 / Elemento padre: 88   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(89)).setAttribute("width","100%" );
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
      ((Element)v.get(92)).setAttribute("nombre","lblCodTipoSoli" );
      ((Element)v.get(92)).setAttribute("alto","13" );
      ((Element)v.get(92)).setAttribute("filas","1" );
      ((Element)v.get(92)).setAttribute("id","datosTitle" );
      ((Element)v.get(92)).setAttribute("cod","PedTipoSolic.codTipoSoli.label" );
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:90   */

      /* Empieza nodo:93 / Elemento padre: 89   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(93)).setAttribute("nombre","codTipoSoliWidgetTrId" );
      ((Element)v.get(89)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(94)).setAttribute("align","left" );
      ((Element)v.get(94)).setAttribute("nowrap","true" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));

      /* Empieza nodo:95 / Elemento padre: 94   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(95)).setAttribute("nombre","codTipoSoli" );
      ((Element)v.get(95)).setAttribute("id","datosCampos" );
      ((Element)v.get(95)).setAttribute("trim","S" );
      ((Element)v.get(95)).setAttribute("max","4" );
      ((Element)v.get(95)).setAttribute("onchange","" );
      ((Element)v.get(95)).setAttribute("req","N" );
      ((Element)v.get(95)).setAttribute("size","4" );
      ((Element)v.get(95)).setAttribute("valor","" );
      ((Element)v.get(95)).setAttribute("validacion","" );
      ((Element)v.get(95)).setAttribute("disabled","" );
      ((Element)v.get(95)).setAttribute("onblur","" );
      ((Element)v.get(95)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicFrm',2, true)" );
      ((Element)v.get(95)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicFrm', 2, false)" );
      ((Element)v.get(94)).appendChild((Element)v.get(95));
      /* Termina nodo:95   */
      /* Termina nodo:94   */
      /* Termina nodo:93   */
      /* Termina nodo:89   */
      /* Termina nodo:88   */

      /* Empieza nodo:96 / Elemento padre: 87   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(96)).setAttribute("nombre","codTipoSoliGapTdId" );
      ((Element)v.get(96)).setAttribute("nowrap","true" );
      ((Element)v.get(96)).setAttribute("class","datosCampos" );
      ((Element)v.get(87)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(97)).setAttribute("src","b.gif" );
      ((Element)v.get(97)).setAttribute("width","25" );
      ((Element)v.get(97)).setAttribute("height","8" );
      ((Element)v.get(96)).appendChild((Element)v.get(97));
      /* Termina nodo:97   */
      /* Termina nodo:96   */

      /* Empieza nodo:98 / Elemento padre: 87   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(98)).setAttribute("width","100%" );
      ((Element)v.get(87)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(99)).setAttribute("src","b.gif" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */
      /* Termina nodo:85   */
      /* Termina nodo:82   */

      /* Empieza nodo:100 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(100)).setAttribute("nombre","formGapTr1" );
   }

   private void getXML450(Document doc) {
      ((Element)v.get(53)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("TD"));
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

      /* Empieza nodo:107 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(107)).setAttribute("nombre","formTr2" );
      ((Element)v.get(53)).appendChild((Element)v.get(107));

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
      ((Element)v.get(113)).setAttribute("nombre","ticlOidTipoClieTdId" );
      ((Element)v.get(112)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("TABLE"));
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
      ((Element)v.get(117)).setAttribute("nombre","lblticlOidTipoClie" );
      ((Element)v.get(117)).setAttribute("id","datosTitle" );
      ((Element)v.get(117)).setAttribute("ancho","150" );
      ((Element)v.get(117)).setAttribute("alto","13" );
      ((Element)v.get(117)).setAttribute("cod","PedTipoSolic.ticlOidTipoClie.label" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */
      /* Termina nodo:115   */

      /* Empieza nodo:118 / Elemento padre: 114   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(118)).setAttribute("nombre","ticlOidTipoClieWidgetTrId" );
      ((Element)v.get(114)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(119)).setAttribute("align","left" );
      ((Element)v.get(119)).setAttribute("nowrap","true" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(120)).setAttribute("nombre","ticlOidTipoClie" );
      ((Element)v.get(120)).setAttribute("id","datosCampos" );
      ((Element)v.get(120)).setAttribute("multiple","N" );
      ((Element)v.get(120)).setAttribute("req","N" );
      ((Element)v.get(120)).setAttribute("size","1" );
      ((Element)v.get(120)).setAttribute("disabled","" );
      ((Element)v.get(120)).setAttribute("validacion","" );
      ((Element)v.get(120)).setAttribute("onchange","" );
      ((Element)v.get(120)).setAttribute("onfocus","" );
   }

   private void getXML540(Document doc) {
      ((Element)v.get(120)).setAttribute("valorinicial","" );
      ((Element)v.get(120)).setAttribute("textoinicial","" );
      ((Element)v.get(120)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicFrm',3, true);" );
      ((Element)v.get(120)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicFrm',3, false);" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(120)).appendChild((Element)v.get(121));
      /* Termina nodo:121   */
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:114   */
      /* Termina nodo:113   */

      /* Empieza nodo:122 / Elemento padre: 112   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(122)).setAttribute("nombre","ticlOidTipoClieGapTdId" );
      ((Element)v.get(122)).setAttribute("nowrap","true" );
      ((Element)v.get(122)).setAttribute("class","datosCampos" );
      ((Element)v.get(112)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(123)).setAttribute("src","b.gif" );
      ((Element)v.get(123)).setAttribute("width","25" );
      ((Element)v.get(123)).setAttribute("height","8" );
      ((Element)v.get(122)).appendChild((Element)v.get(123));
      /* Termina nodo:123   */
      /* Termina nodo:122   */

      /* Empieza nodo:124 / Elemento padre: 112   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(124)).setAttribute("width","100%" );
      ((Element)v.get(112)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(125)).setAttribute("src","b.gif" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:112   */
      /* Termina nodo:111   */
      /* Termina nodo:110   */
      /* Termina nodo:107   */

      /* Empieza nodo:126 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(126)).setAttribute("nombre","formGapTr2" );
      ((Element)v.get(53)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(127)).setAttribute("align","center" );
      ((Element)v.get(127)).setAttribute("width","8" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(128)).setAttribute("src","b.gif" );
      ((Element)v.get(128)).setAttribute("width","12" );
      ((Element)v.get(128)).setAttribute("height","8" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));
      /* Termina nodo:128   */
      /* Termina nodo:127   */

      /* Empieza nodo:129 / Elemento padre: 126   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(126)).appendChild((Element)v.get(129));

      /* Empieza nodo:130 / Elemento padre: 129   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(130)).setAttribute("src","b.gif" );
      ((Element)v.get(130)).setAttribute("width","8" );
      ((Element)v.get(130)).setAttribute("height","8" );
      ((Element)v.get(129)).appendChild((Element)v.get(130));
      /* Termina nodo:130   */
      /* Termina nodo:129   */

      /* Empieza nodo:131 / Elemento padre: 126   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(131)).setAttribute("align","center" );
      ((Element)v.get(131)).setAttribute("width","8" );
      ((Element)v.get(126)).appendChild((Element)v.get(131));

      /* Empieza nodo:132 / Elemento padre: 131   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(132)).setAttribute("src","b.gif" );
      ((Element)v.get(132)).setAttribute("width","12" );
      ((Element)v.get(132)).setAttribute("height","8" );
      ((Element)v.get(131)).appendChild((Element)v.get(132));
      /* Termina nodo:132   */
      /* Termina nodo:131   */
      /* Termina nodo:126   */

      /* Empieza nodo:133 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(133)).setAttribute("nombre","formTr3" );
      ((Element)v.get(53)).appendChild((Element)v.get(133));

      /* Empieza nodo:134 / Elemento padre: 133   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(134)).setAttribute("align","center" );
      ((Element)v.get(134)).setAttribute("width","8" );
      ((Element)v.get(133)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(135)).setAttribute("src","b.gif" );
      ((Element)v.get(135)).setAttribute("width","8" );
      ((Element)v.get(135)).setAttribute("height","12" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));
      /* Termina nodo:135   */
      /* Termina nodo:134   */

      /* Empieza nodo:136 / Elemento padre: 133   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(136)).setAttribute("width","100%" );
      ((Element)v.get(133)).appendChild((Element)v.get(136));

      /* Empieza nodo:137 / Elemento padre: 136   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(137)).setAttribute("width","100%" );
      ((Element)v.get(137)).setAttribute("border","0" );
      ((Element)v.get(137)).setAttribute("cellspacing","0" );
      ((Element)v.get(137)).setAttribute("cellpadding","0" );
      ((Element)v.get(137)).setAttribute("align","left" );
      ((Element)v.get(136)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(138)).setAttribute("align","left" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));

      /* Empieza nodo:139 / Elemento padre: 138   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(139)).setAttribute("nombre","marcOidMarcTdId" );
      ((Element)v.get(138)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(140)).setAttribute("border","0" );
      ((Element)v.get(140)).setAttribute("cellspacing","0" );
      ((Element)v.get(140)).setAttribute("cellpadding","0" );
      ((Element)v.get(140)).setAttribute("align","left" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));

      /* Empieza nodo:141 / Elemento padre: 140   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(140)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(142)).setAttribute("valign","top" );
      ((Element)v.get(142)).setAttribute("height","13" );
   }

   private void getXML630(Document doc) {
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(143)).setAttribute("nombre","lblmarcOidMarc" );
      ((Element)v.get(143)).setAttribute("id","datosTitle" );
      ((Element)v.get(143)).setAttribute("ancho","150" );
      ((Element)v.get(143)).setAttribute("alto","13" );
      ((Element)v.get(143)).setAttribute("cod","PedTipoSolic.marcOidMarc.label" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */
      /* Termina nodo:141   */

      /* Empieza nodo:144 / Elemento padre: 140   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(144)).setAttribute("nombre","marcOidMarcWidgetTrId" );
      ((Element)v.get(140)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(145)).setAttribute("align","left" );
      ((Element)v.get(145)).setAttribute("nowrap","true" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(146)).setAttribute("nombre","marcOidMarc" );
      ((Element)v.get(146)).setAttribute("id","datosCampos" );
      ((Element)v.get(146)).setAttribute("multiple","N" );
      ((Element)v.get(146)).setAttribute("req","N" );
      ((Element)v.get(146)).setAttribute("size","1" );
      ((Element)v.get(146)).setAttribute("disabled","" );
      ((Element)v.get(146)).setAttribute("validacion","" );
      ((Element)v.get(146)).setAttribute("onchange","" );
      ((Element)v.get(146)).setAttribute("onfocus","" );
      ((Element)v.get(146)).setAttribute("valorinicial","" );
      ((Element)v.get(146)).setAttribute("textoinicial","" );
      ((Element)v.get(146)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicFrm',4, true);" );
      ((Element)v.get(146)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicFrm',4, false);" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(146)).appendChild((Element)v.get(147));
      /* Termina nodo:147   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:140   */
      /* Termina nodo:139   */

      /* Empieza nodo:148 / Elemento padre: 138   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(148)).setAttribute("nombre","marcOidMarcGapTdId" );
      ((Element)v.get(148)).setAttribute("nowrap","true" );
      ((Element)v.get(148)).setAttribute("class","datosCampos" );
      ((Element)v.get(138)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(149)).setAttribute("src","b.gif" );
      ((Element)v.get(149)).setAttribute("width","25" );
      ((Element)v.get(149)).setAttribute("height","8" );
      ((Element)v.get(148)).appendChild((Element)v.get(149));
      /* Termina nodo:149   */
      /* Termina nodo:148   */

      /* Empieza nodo:150 / Elemento padre: 138   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(150)).setAttribute("width","100%" );
      ((Element)v.get(138)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(151)).setAttribute("src","b.gif" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */
      /* Termina nodo:138   */
      /* Termina nodo:137   */
      /* Termina nodo:136   */
      /* Termina nodo:133   */

      /* Empieza nodo:152 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(152)).setAttribute("nombre","formGapTr3" );
      ((Element)v.get(53)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(153)).setAttribute("align","center" );
      ((Element)v.get(153)).setAttribute("width","8" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(154)).setAttribute("src","b.gif" );
      ((Element)v.get(154)).setAttribute("width","12" );
      ((Element)v.get(154)).setAttribute("height","8" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));
      /* Termina nodo:154   */
      /* Termina nodo:153   */

      /* Empieza nodo:155 / Elemento padre: 152   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(152)).appendChild((Element)v.get(155));

      /* Empieza nodo:156 / Elemento padre: 155   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(156)).setAttribute("src","b.gif" );
      ((Element)v.get(156)).setAttribute("width","8" );
      ((Element)v.get(156)).setAttribute("height","8" );
      ((Element)v.get(155)).appendChild((Element)v.get(156));
      /* Termina nodo:156   */
      /* Termina nodo:155   */

      /* Empieza nodo:157 / Elemento padre: 152   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(157)).setAttribute("align","center" );
      ((Element)v.get(157)).setAttribute("width","8" );
      ((Element)v.get(152)).appendChild((Element)v.get(157));

      /* Empieza nodo:158 / Elemento padre: 157   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(158)).setAttribute("src","b.gif" );
      ((Element)v.get(158)).setAttribute("width","12" );
      ((Element)v.get(158)).setAttribute("height","8" );
      ((Element)v.get(157)).appendChild((Element)v.get(158));
      /* Termina nodo:158   */
      /* Termina nodo:157   */
      /* Termina nodo:152   */

      /* Empieza nodo:159 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(159)).setAttribute("nombre","formTr4" );
      ((Element)v.get(53)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(160)).setAttribute("align","center" );
      ((Element)v.get(160)).setAttribute("width","8" );
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(161)).setAttribute("src","b.gif" );
      ((Element)v.get(161)).setAttribute("width","8" );
      ((Element)v.get(161)).setAttribute("height","12" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:162 / Elemento padre: 159   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(162)).setAttribute("width","100%" );
   }

   private void getXML720(Document doc) {
      ((Element)v.get(159)).appendChild((Element)v.get(162));

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
      ((Element)v.get(164)).setAttribute("align","left" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(165)).setAttribute("nombre","acceOidAcce_canaOidCanaTdId" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(166)).setAttribute("border","0" );
      ((Element)v.get(166)).setAttribute("cellspacing","0" );
      ((Element)v.get(166)).setAttribute("cellpadding","0" );
      ((Element)v.get(166)).setAttribute("align","left" );
      ((Element)v.get(165)).appendChild((Element)v.get(166));

      /* Empieza nodo:167 / Elemento padre: 166   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(166)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(168)).setAttribute("valign","top" );
      ((Element)v.get(168)).setAttribute("height","13" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));

      /* Empieza nodo:169 / Elemento padre: 168   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(169)).setAttribute("nombre","lblacceOidAcce_canaOidCana" );
      ((Element)v.get(169)).setAttribute("id","datosTitle" );
      ((Element)v.get(169)).setAttribute("ancho","150" );
      ((Element)v.get(169)).setAttribute("alto","13" );
      ((Element)v.get(169)).setAttribute("cod","SegAcces.canaOidCana.label" );
      ((Element)v.get(168)).appendChild((Element)v.get(169));
      /* Termina nodo:169   */
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:170 / Elemento padre: 166   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(170)).setAttribute("nombre","acceOidAcce_canaOidCanaWidgetTrId" );
      ((Element)v.get(166)).appendChild((Element)v.get(170));

      /* Empieza nodo:171 / Elemento padre: 170   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(171)).setAttribute("align","left" );
      ((Element)v.get(171)).setAttribute("nowrap","true" );
      ((Element)v.get(170)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(172)).setAttribute("nombre","acceOidAcce_canaOidCana" );
      ((Element)v.get(172)).setAttribute("id","datosCampos" );
      ((Element)v.get(172)).setAttribute("multiple","N" );
      ((Element)v.get(172)).setAttribute("req","N" );
      ((Element)v.get(172)).setAttribute("size","1" );
      ((Element)v.get(172)).setAttribute("disabled","" );
      ((Element)v.get(172)).setAttribute("validacion","" );
      ((Element)v.get(172)).setAttribute("onchange","mmgDependeneChange('acceOidAcce_canaOidCana', 'acceOidAcce' , 'pedTipoSolic')" );
      ((Element)v.get(172)).setAttribute("onfocus","" );
      ((Element)v.get(172)).setAttribute("valorinicial","" );
      ((Element)v.get(172)).setAttribute("textoinicial","" );
      ((Element)v.get(172)).setAttribute("ontab","focaliza('pedTipoSolicFrm.acceOidAcce');" );
      ((Element)v.get(172)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicFrm',5, false);" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */
      /* Termina nodo:171   */
      /* Termina nodo:170   */
      /* Termina nodo:166   */
      /* Termina nodo:165   */

      /* Empieza nodo:174 / Elemento padre: 164   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(174)).setAttribute("nombre","acceOidAcce_canaOidCanaGapTdId" );
      ((Element)v.get(174)).setAttribute("nowrap","true" );
      ((Element)v.get(174)).setAttribute("class","datosCampos" );
      ((Element)v.get(164)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(175)).setAttribute("src","b.gif" );
      ((Element)v.get(175)).setAttribute("width","25" );
      ((Element)v.get(175)).setAttribute("height","8" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 164   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(176)).setAttribute("nombre","acceOidAcceTdId" );
      ((Element)v.get(164)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(177)).setAttribute("border","0" );
      ((Element)v.get(177)).setAttribute("cellspacing","0" );
      ((Element)v.get(177)).setAttribute("cellpadding","0" );
      ((Element)v.get(177)).setAttribute("align","left" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));

      /* Empieza nodo:178 / Elemento padre: 177   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(177)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(179)).setAttribute("valign","top" );
      ((Element)v.get(179)).setAttribute("height","13" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(180)).setAttribute("nombre","lblacceOidAcce" );
      ((Element)v.get(180)).setAttribute("id","datosTitle" );
      ((Element)v.get(180)).setAttribute("ancho","150" );
      ((Element)v.get(180)).setAttribute("alto","13" );
      ((Element)v.get(180)).setAttribute("cod","PedTipoSolic.acceOidAcce.label" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */
      /* Termina nodo:178   */

      /* Empieza nodo:181 / Elemento padre: 177   */
      v.add(doc.createElement("TR"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(181)).setAttribute("nombre","acceOidAcceWidgetTrId" );
      ((Element)v.get(177)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(182)).setAttribute("align","left" );
      ((Element)v.get(182)).setAttribute("nowrap","true" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(183)).setAttribute("nombre","acceOidAcce" );
      ((Element)v.get(183)).setAttribute("id","datosCampos" );
      ((Element)v.get(183)).setAttribute("multiple","N" );
      ((Element)v.get(183)).setAttribute("req","N" );
      ((Element)v.get(183)).setAttribute("size","1" );
      ((Element)v.get(183)).setAttribute("disabled","" );
      ((Element)v.get(183)).setAttribute("validacion","" );
      ((Element)v.get(183)).setAttribute("onchange","" );
      ((Element)v.get(183)).setAttribute("onfocus","" );
      ((Element)v.get(183)).setAttribute("valorinicial","" );
      ((Element)v.get(183)).setAttribute("textoinicial","" );
      ((Element)v.get(183)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicFrm',5, true);" );
      ((Element)v.get(183)).setAttribute("onshtab","focaliza('pedTipoSolicFrm.acceOidAcce_canaOidCana');" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(183)).appendChild((Element)v.get(184));
      /* Termina nodo:184   */
      /* Termina nodo:183   */
      /* Termina nodo:182   */
      /* Termina nodo:181   */
      /* Termina nodo:177   */
      /* Termina nodo:176   */

      /* Empieza nodo:185 / Elemento padre: 164   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(185)).setAttribute("nombre","acceOidAcceGapTdId" );
      ((Element)v.get(185)).setAttribute("nowrap","true" );
      ((Element)v.get(185)).setAttribute("class","datosCampos" );
      ((Element)v.get(164)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(186)).setAttribute("src","b.gif" );
      ((Element)v.get(186)).setAttribute("width","25" );
      ((Element)v.get(186)).setAttribute("height","8" );
      ((Element)v.get(185)).appendChild((Element)v.get(186));
      /* Termina nodo:186   */
      /* Termina nodo:185   */

      /* Empieza nodo:187 / Elemento padre: 164   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(187)).setAttribute("width","100%" );
      ((Element)v.get(164)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(188)).setAttribute("src","b.gif" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:162   */
      /* Termina nodo:159   */

      /* Empieza nodo:189 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(189)).setAttribute("nombre","formGapTr4" );
      ((Element)v.get(53)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(190)).setAttribute("align","center" );
      ((Element)v.get(190)).setAttribute("width","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(191)).setAttribute("src","b.gif" );
      ((Element)v.get(191)).setAttribute("width","12" );
      ((Element)v.get(191)).setAttribute("height","8" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */

      /* Empieza nodo:192 / Elemento padre: 189   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(189)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","8" );
      ((Element)v.get(193)).setAttribute("height","8" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:194 / Elemento padre: 189   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(194)).setAttribute("align","center" );
      ((Element)v.get(194)).setAttribute("width","8" );
      ((Element)v.get(189)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(195)).setAttribute("src","b.gif" );
      ((Element)v.get(195)).setAttribute("width","12" );
      ((Element)v.get(195)).setAttribute("height","8" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:189   */

      /* Empieza nodo:196 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(196)).setAttribute("nombre","formTr5" );
      ((Element)v.get(53)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(197)).setAttribute("align","center" );
      ((Element)v.get(197)).setAttribute("width","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).setAttribute("width","8" );
      ((Element)v.get(198)).setAttribute("height","12" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 196   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(199)).setAttribute("width","100%" );
      ((Element)v.get(196)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(200)).setAttribute("width","100%" );
      ((Element)v.get(200)).setAttribute("border","0" );
      ((Element)v.get(200)).setAttribute("cellspacing","0" );
      ((Element)v.get(200)).setAttribute("cellpadding","0" );
      ((Element)v.get(200)).setAttribute("align","left" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));

      /* Empieza nodo:201 / Elemento padre: 200   */
      v.add(doc.createElement("TR"));
   }

   private void getXML900(Document doc) {
      ((Element)v.get(201)).setAttribute("align","left" );
      ((Element)v.get(200)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(202)).setAttribute("nombre","clsoOidClasSoliTdId" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));

      /* Empieza nodo:203 / Elemento padre: 202   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(203)).setAttribute("border","0" );
      ((Element)v.get(203)).setAttribute("cellspacing","0" );
      ((Element)v.get(203)).setAttribute("cellpadding","0" );
      ((Element)v.get(203)).setAttribute("align","left" );
      ((Element)v.get(202)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(203)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(205)).setAttribute("valign","top" );
      ((Element)v.get(205)).setAttribute("height","13" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));

      /* Empieza nodo:206 / Elemento padre: 205   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(206)).setAttribute("nombre","lblclsoOidClasSoli" );
      ((Element)v.get(206)).setAttribute("id","datosTitle" );
      ((Element)v.get(206)).setAttribute("ancho","150" );
      ((Element)v.get(206)).setAttribute("alto","13" );
      ((Element)v.get(206)).setAttribute("cod","PedTipoSolic.clsoOidClasSoli.label" );
      ((Element)v.get(205)).appendChild((Element)v.get(206));
      /* Termina nodo:206   */
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:207 / Elemento padre: 203   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(207)).setAttribute("nombre","clsoOidClasSoliWidgetTrId" );
      ((Element)v.get(203)).appendChild((Element)v.get(207));

      /* Empieza nodo:208 / Elemento padre: 207   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(208)).setAttribute("align","left" );
      ((Element)v.get(208)).setAttribute("nowrap","true" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(209)).setAttribute("nombre","clsoOidClasSoli" );
      ((Element)v.get(209)).setAttribute("id","datosCampos" );
      ((Element)v.get(209)).setAttribute("multiple","N" );
      ((Element)v.get(209)).setAttribute("req","N" );
      ((Element)v.get(209)).setAttribute("size","1" );
      ((Element)v.get(209)).setAttribute("disabled","" );
      ((Element)v.get(209)).setAttribute("validacion","" );
      ((Element)v.get(209)).setAttribute("onchange","" );
      ((Element)v.get(209)).setAttribute("onfocus","" );
      ((Element)v.get(209)).setAttribute("valorinicial","" );
      ((Element)v.get(209)).setAttribute("textoinicial","" );
      ((Element)v.get(209)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicFrm',6, true);" );
      ((Element)v.get(209)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicFrm',6, false);" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(209)).appendChild((Element)v.get(210));
      /* Termina nodo:210   */
      /* Termina nodo:209   */
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:203   */
      /* Termina nodo:202   */

      /* Empieza nodo:211 / Elemento padre: 201   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(211)).setAttribute("nombre","clsoOidClasSoliGapTdId" );
      ((Element)v.get(211)).setAttribute("nowrap","true" );
      ((Element)v.get(211)).setAttribute("class","datosCampos" );
      ((Element)v.get(201)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(212)).setAttribute("src","b.gif" );
      ((Element)v.get(212)).setAttribute("width","25" );
      ((Element)v.get(212)).setAttribute("height","8" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));
      /* Termina nodo:212   */
      /* Termina nodo:211   */

      /* Empieza nodo:213 / Elemento padre: 201   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(213)).setAttribute("width","100%" );
      ((Element)v.get(201)).appendChild((Element)v.get(213));

      /* Empieza nodo:214 / Elemento padre: 213   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(214)).setAttribute("src","b.gif" );
      ((Element)v.get(213)).appendChild((Element)v.get(214));
      /* Termina nodo:214   */
      /* Termina nodo:213   */
      /* Termina nodo:201   */
      /* Termina nodo:200   */
      /* Termina nodo:199   */
      /* Termina nodo:196   */

      /* Empieza nodo:215 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(215)).setAttribute("nombre","formGapTr5" );
      ((Element)v.get(53)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(216)).setAttribute("align","center" );
      ((Element)v.get(216)).setAttribute("width","8" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));

      /* Empieza nodo:217 / Elemento padre: 216   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(217)).setAttribute("src","b.gif" );
      ((Element)v.get(217)).setAttribute("width","12" );
      ((Element)v.get(217)).setAttribute("height","8" );
      ((Element)v.get(216)).appendChild((Element)v.get(217));
      /* Termina nodo:217   */
      /* Termina nodo:216   */

      /* Empieza nodo:218 / Elemento padre: 215   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(215)).appendChild((Element)v.get(218));

      /* Empieza nodo:219 / Elemento padre: 218   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(219)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).setAttribute("width","8" );
      ((Element)v.get(219)).setAttribute("height","8" );
      ((Element)v.get(218)).appendChild((Element)v.get(219));
      /* Termina nodo:219   */
      /* Termina nodo:218   */

      /* Empieza nodo:220 / Elemento padre: 215   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(220)).setAttribute("align","center" );
      ((Element)v.get(220)).setAttribute("width","8" );
      ((Element)v.get(215)).appendChild((Element)v.get(220));

      /* Empieza nodo:221 / Elemento padre: 220   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(221)).setAttribute("src","b.gif" );
      ((Element)v.get(221)).setAttribute("width","12" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(221)).setAttribute("height","8" );
      ((Element)v.get(220)).appendChild((Element)v.get(221));
      /* Termina nodo:221   */
      /* Termina nodo:220   */
      /* Termina nodo:215   */

      /* Empieza nodo:222 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(222)).setAttribute("nombre","formTr6" );
      ((Element)v.get(53)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(223)).setAttribute("align","center" );
      ((Element)v.get(223)).setAttribute("width","8" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));

      /* Empieza nodo:224 / Elemento padre: 223   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(224)).setAttribute("src","b.gif" );
      ((Element)v.get(224)).setAttribute("width","8" );
      ((Element)v.get(224)).setAttribute("height","12" );
      ((Element)v.get(223)).appendChild((Element)v.get(224));
      /* Termina nodo:224   */
      /* Termina nodo:223   */

      /* Empieza nodo:225 / Elemento padre: 222   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(225)).setAttribute("width","100%" );
      ((Element)v.get(222)).appendChild((Element)v.get(225));

      /* Empieza nodo:226 / Elemento padre: 225   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(226)).setAttribute("width","100%" );
      ((Element)v.get(226)).setAttribute("border","0" );
      ((Element)v.get(226)).setAttribute("cellspacing","0" );
      ((Element)v.get(226)).setAttribute("cellpadding","0" );
      ((Element)v.get(226)).setAttribute("align","left" );
      ((Element)v.get(225)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(227)).setAttribute("align","left" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));

      /* Empieza nodo:228 / Elemento padre: 227   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(228)).setAttribute("nombre","indConsTdId" );
      ((Element)v.get(227)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(229)).setAttribute("width","100%" );
      ((Element)v.get(229)).setAttribute("border","0" );
      ((Element)v.get(229)).setAttribute("cellspacing","0" );
      ((Element)v.get(229)).setAttribute("cellpadding","0" );
      ((Element)v.get(229)).setAttribute("align","left" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(229)).appendChild((Element)v.get(230));

      /* Empieza nodo:231 / Elemento padre: 230   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(231)).setAttribute("valign","top" );
      ((Element)v.get(231)).setAttribute("height","13" );
      ((Element)v.get(230)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(232)).setAttribute("nombre","lblIndCons" );
      ((Element)v.get(232)).setAttribute("alto","13" );
      ((Element)v.get(232)).setAttribute("filas","1" );
      ((Element)v.get(232)).setAttribute("id","datosTitle" );
      ((Element)v.get(232)).setAttribute("cod","PedTipoSolic.indCons.label" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));
      /* Termina nodo:232   */
      /* Termina nodo:231   */
      /* Termina nodo:230   */

      /* Empieza nodo:233 / Elemento padre: 229   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(233)).setAttribute("nombre","indConsWidgetTrId" );
      ((Element)v.get(229)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(234)).setAttribute("align","left" );
      ((Element)v.get(234)).setAttribute("nowrap","true" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(235)).setAttribute("nombre","indCons" );
      ((Element)v.get(235)).setAttribute("id","datosCampos" );
      ((Element)v.get(235)).setAttribute("trim","S" );
      ((Element)v.get(235)).setAttribute("max","1" );
      ((Element)v.get(235)).setAttribute("onchange","" );
      ((Element)v.get(235)).setAttribute("req","N" );
      ((Element)v.get(235)).setAttribute("size","1" );
      ((Element)v.get(235)).setAttribute("valor","" );
      ((Element)v.get(235)).setAttribute("validacion","" );
      ((Element)v.get(235)).setAttribute("disabled","" );
      ((Element)v.get(235)).setAttribute("onblur","" );
      ((Element)v.get(235)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicFrm',7, true)" );
      ((Element)v.get(235)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicFrm', 7, false)" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));
      /* Termina nodo:235   */
      /* Termina nodo:234   */
      /* Termina nodo:233   */
      /* Termina nodo:229   */
      /* Termina nodo:228   */

      /* Empieza nodo:236 / Elemento padre: 227   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(236)).setAttribute("nombre","indConsGapTdId" );
      ((Element)v.get(236)).setAttribute("nowrap","true" );
      ((Element)v.get(236)).setAttribute("class","datosCampos" );
      ((Element)v.get(227)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(237)).setAttribute("src","b.gif" );
      ((Element)v.get(237)).setAttribute("width","25" );
      ((Element)v.get(237)).setAttribute("height","8" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));
      /* Termina nodo:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:238 / Elemento padre: 227   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(238)).setAttribute("width","100%" );
      ((Element)v.get(227)).appendChild((Element)v.get(238));

      /* Empieza nodo:239 / Elemento padre: 238   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(239)).setAttribute("src","b.gif" );
      ((Element)v.get(238)).appendChild((Element)v.get(239));
      /* Termina nodo:239   */
      /* Termina nodo:238   */
      /* Termina nodo:227   */
      /* Termina nodo:226   */
      /* Termina nodo:225   */
      /* Termina nodo:222   */

      /* Empieza nodo:240 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(240)).setAttribute("nombre","formGapTr6" );
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(53)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(241)).setAttribute("align","center" );
      ((Element)v.get(241)).setAttribute("width","8" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));

      /* Empieza nodo:242 / Elemento padre: 241   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(242)).setAttribute("src","b.gif" );
      ((Element)v.get(242)).setAttribute("width","12" );
      ((Element)v.get(242)).setAttribute("height","8" );
      ((Element)v.get(241)).appendChild((Element)v.get(242));
      /* Termina nodo:242   */
      /* Termina nodo:241   */

      /* Empieza nodo:243 / Elemento padre: 240   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(240)).appendChild((Element)v.get(243));

      /* Empieza nodo:244 / Elemento padre: 243   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(244)).setAttribute("src","b.gif" );
      ((Element)v.get(244)).setAttribute("width","8" );
      ((Element)v.get(244)).setAttribute("height","8" );
      ((Element)v.get(243)).appendChild((Element)v.get(244));
      /* Termina nodo:244   */
      /* Termina nodo:243   */

      /* Empieza nodo:245 / Elemento padre: 240   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(245)).setAttribute("align","center" );
      ((Element)v.get(245)).setAttribute("width","8" );
      ((Element)v.get(240)).appendChild((Element)v.get(245));

      /* Empieza nodo:246 / Elemento padre: 245   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(246)).setAttribute("src","b.gif" );
      ((Element)v.get(246)).setAttribute("width","12" );
      ((Element)v.get(246)).setAttribute("height","8" );
      ((Element)v.get(245)).appendChild((Element)v.get(246));
      /* Termina nodo:246   */
      /* Termina nodo:245   */
      /* Termina nodo:240   */

      /* Empieza nodo:247 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(247)).setAttribute("nombre","formTr7" );
      ((Element)v.get(53)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(248)).setAttribute("align","center" );
      ((Element)v.get(248)).setAttribute("width","8" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));

      /* Empieza nodo:249 / Elemento padre: 248   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(249)).setAttribute("src","b.gif" );
      ((Element)v.get(249)).setAttribute("width","8" );
      ((Element)v.get(249)).setAttribute("height","12" );
      ((Element)v.get(248)).appendChild((Element)v.get(249));
      /* Termina nodo:249   */
      /* Termina nodo:248   */

      /* Empieza nodo:250 / Elemento padre: 247   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(250)).setAttribute("width","100%" );
      ((Element)v.get(247)).appendChild((Element)v.get(250));

      /* Empieza nodo:251 / Elemento padre: 250   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(251)).setAttribute("width","100%" );
      ((Element)v.get(251)).setAttribute("border","0" );
      ((Element)v.get(251)).setAttribute("cellspacing","0" );
      ((Element)v.get(251)).setAttribute("cellpadding","0" );
      ((Element)v.get(251)).setAttribute("align","left" );
      ((Element)v.get(250)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(252)).setAttribute("align","left" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));

      /* Empieza nodo:253 / Elemento padre: 252   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(253)).setAttribute("nombre","indSoliNegaTdId" );
      ((Element)v.get(252)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(254)).setAttribute("width","100%" );
      ((Element)v.get(254)).setAttribute("border","0" );
      ((Element)v.get(254)).setAttribute("cellspacing","0" );
      ((Element)v.get(254)).setAttribute("cellpadding","0" );
      ((Element)v.get(254)).setAttribute("align","left" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(254)).appendChild((Element)v.get(255));

      /* Empieza nodo:256 / Elemento padre: 255   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(256)).setAttribute("valign","top" );
      ((Element)v.get(256)).setAttribute("height","13" );
      ((Element)v.get(255)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(257)).setAttribute("nombre","lblIndSoliNega" );
      ((Element)v.get(257)).setAttribute("alto","13" );
      ((Element)v.get(257)).setAttribute("filas","1" );
      ((Element)v.get(257)).setAttribute("id","datosTitle" );
      ((Element)v.get(257)).setAttribute("cod","PedTipoSolic.indSoliNega.label" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:255   */

      /* Empieza nodo:258 / Elemento padre: 254   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(258)).setAttribute("nombre","indSoliNegaWidgetTrId" );
      ((Element)v.get(254)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(259)).setAttribute("align","left" );
      ((Element)v.get(259)).setAttribute("nowrap","true" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(260)).setAttribute("nombre","indSoliNega" );
      ((Element)v.get(260)).setAttribute("id","datosCampos" );
      ((Element)v.get(260)).setAttribute("trim","S" );
      ((Element)v.get(260)).setAttribute("max","1" );
      ((Element)v.get(260)).setAttribute("onchange","" );
      ((Element)v.get(260)).setAttribute("req","N" );
      ((Element)v.get(260)).setAttribute("size","1" );
      ((Element)v.get(260)).setAttribute("valor","" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(260)).setAttribute("validacion","" );
      ((Element)v.get(260)).setAttribute("disabled","" );
      ((Element)v.get(260)).setAttribute("onblur","" );
      ((Element)v.get(260)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicFrm',8, true)" );
      ((Element)v.get(260)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicFrm', 8, false)" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));
      /* Termina nodo:260   */
      /* Termina nodo:259   */
      /* Termina nodo:258   */
      /* Termina nodo:254   */
      /* Termina nodo:253   */

      /* Empieza nodo:261 / Elemento padre: 252   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(261)).setAttribute("nombre","indSoliNegaGapTdId" );
      ((Element)v.get(261)).setAttribute("nowrap","true" );
      ((Element)v.get(261)).setAttribute("class","datosCampos" );
      ((Element)v.get(252)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(262)).setAttribute("src","b.gif" );
      ((Element)v.get(262)).setAttribute("width","25" );
      ((Element)v.get(262)).setAttribute("height","8" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));
      /* Termina nodo:262   */
      /* Termina nodo:261   */

      /* Empieza nodo:263 / Elemento padre: 252   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(263)).setAttribute("width","100%" );
      ((Element)v.get(252)).appendChild((Element)v.get(263));

      /* Empieza nodo:264 / Elemento padre: 263   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(264)).setAttribute("src","b.gif" );
      ((Element)v.get(263)).appendChild((Element)v.get(264));
      /* Termina nodo:264   */
      /* Termina nodo:263   */
      /* Termina nodo:252   */
      /* Termina nodo:251   */
      /* Termina nodo:250   */
      /* Termina nodo:247   */

      /* Empieza nodo:265 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(265)).setAttribute("nombre","formGapTr7" );
      ((Element)v.get(53)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(266)).setAttribute("align","center" );
      ((Element)v.get(266)).setAttribute("width","8" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));

      /* Empieza nodo:267 / Elemento padre: 266   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(267)).setAttribute("src","b.gif" );
      ((Element)v.get(267)).setAttribute("width","12" );
      ((Element)v.get(267)).setAttribute("height","8" );
      ((Element)v.get(266)).appendChild((Element)v.get(267));
      /* Termina nodo:267   */
      /* Termina nodo:266   */

      /* Empieza nodo:268 / Elemento padre: 265   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(265)).appendChild((Element)v.get(268));

      /* Empieza nodo:269 / Elemento padre: 268   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(269)).setAttribute("src","b.gif" );
      ((Element)v.get(269)).setAttribute("width","8" );
      ((Element)v.get(269)).setAttribute("height","8" );
      ((Element)v.get(268)).appendChild((Element)v.get(269));
      /* Termina nodo:269   */
      /* Termina nodo:268   */

      /* Empieza nodo:270 / Elemento padre: 265   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(270)).setAttribute("align","center" );
      ((Element)v.get(270)).setAttribute("width","8" );
      ((Element)v.get(265)).appendChild((Element)v.get(270));

      /* Empieza nodo:271 / Elemento padre: 270   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(271)).setAttribute("src","b.gif" );
      ((Element)v.get(271)).setAttribute("width","12" );
      ((Element)v.get(271)).setAttribute("height","8" );
      ((Element)v.get(270)).appendChild((Element)v.get(271));
      /* Termina nodo:271   */
      /* Termina nodo:270   */
      /* Termina nodo:265   */

      /* Empieza nodo:272 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(272)).setAttribute("nombre","formTr8" );
      ((Element)v.get(53)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(273)).setAttribute("align","center" );
      ((Element)v.get(273)).setAttribute("width","8" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));

      /* Empieza nodo:274 / Elemento padre: 273   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(274)).setAttribute("src","b.gif" );
      ((Element)v.get(274)).setAttribute("width","8" );
      ((Element)v.get(274)).setAttribute("height","12" );
      ((Element)v.get(273)).appendChild((Element)v.get(274));
      /* Termina nodo:274   */
      /* Termina nodo:273   */

      /* Empieza nodo:275 / Elemento padre: 272   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(275)).setAttribute("width","100%" );
      ((Element)v.get(272)).appendChild((Element)v.get(275));

      /* Empieza nodo:276 / Elemento padre: 275   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(276)).setAttribute("width","100%" );
      ((Element)v.get(276)).setAttribute("border","0" );
      ((Element)v.get(276)).setAttribute("cellspacing","0" );
      ((Element)v.get(276)).setAttribute("cellpadding","0" );
      ((Element)v.get(276)).setAttribute("align","left" );
      ((Element)v.get(275)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(277)).setAttribute("align","left" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));

      /* Empieza nodo:278 / Elemento padre: 277   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(278)).setAttribute("nombre","grsoOidGrupSoliTdId" );
      ((Element)v.get(277)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(279)).setAttribute("border","0" );
      ((Element)v.get(279)).setAttribute("cellspacing","0" );
      ((Element)v.get(279)).setAttribute("cellpadding","0" );
      ((Element)v.get(279)).setAttribute("align","left" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(279)).appendChild((Element)v.get(280));

      /* Empieza nodo:281 / Elemento padre: 280   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(281)).setAttribute("valign","top" );
      ((Element)v.get(281)).setAttribute("height","13" );
      ((Element)v.get(280)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
   }

   private void getXML1260(Document doc) {
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(282)).setAttribute("nombre","lblgrsoOidGrupSoli" );
      ((Element)v.get(282)).setAttribute("id","datosTitle" );
      ((Element)v.get(282)).setAttribute("ancho","150" );
      ((Element)v.get(282)).setAttribute("alto","13" );
      ((Element)v.get(282)).setAttribute("cod","PedTipoSolic.grsoOidGrupSoli.label" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));
      /* Termina nodo:282   */
      /* Termina nodo:281   */
      /* Termina nodo:280   */

      /* Empieza nodo:283 / Elemento padre: 279   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(283)).setAttribute("nombre","grsoOidGrupSoliWidgetTrId" );
      ((Element)v.get(279)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(284)).setAttribute("align","left" );
      ((Element)v.get(284)).setAttribute("nowrap","true" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));

      /* Empieza nodo:285 / Elemento padre: 284   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(285)).setAttribute("nombre","grsoOidGrupSoli" );
      ((Element)v.get(285)).setAttribute("id","datosCampos" );
      ((Element)v.get(285)).setAttribute("multiple","N" );
      ((Element)v.get(285)).setAttribute("req","N" );
      ((Element)v.get(285)).setAttribute("size","1" );
      ((Element)v.get(285)).setAttribute("disabled","" );
      ((Element)v.get(285)).setAttribute("validacion","" );
      ((Element)v.get(285)).setAttribute("onchange","" );
      ((Element)v.get(285)).setAttribute("onfocus","" );
      ((Element)v.get(285)).setAttribute("valorinicial","" );
      ((Element)v.get(285)).setAttribute("textoinicial","" );
      ((Element)v.get(285)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicFrm',9, true);" );
      ((Element)v.get(285)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicFrm',9, false);" );
      ((Element)v.get(284)).appendChild((Element)v.get(285));

      /* Empieza nodo:286 / Elemento padre: 285   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(285)).appendChild((Element)v.get(286));
      /* Termina nodo:286   */
      /* Termina nodo:285   */
      /* Termina nodo:284   */
      /* Termina nodo:283   */
      /* Termina nodo:279   */
      /* Termina nodo:278   */

      /* Empieza nodo:287 / Elemento padre: 277   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(287)).setAttribute("nombre","grsoOidGrupSoliGapTdId" );
      ((Element)v.get(287)).setAttribute("nowrap","true" );
      ((Element)v.get(287)).setAttribute("class","datosCampos" );
      ((Element)v.get(277)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(288)).setAttribute("src","b.gif" );
      ((Element)v.get(288)).setAttribute("width","25" );
      ((Element)v.get(288)).setAttribute("height","8" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:287   */

      /* Empieza nodo:289 / Elemento padre: 277   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(289)).setAttribute("width","100%" );
      ((Element)v.get(277)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(290)).setAttribute("src","b.gif" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));
      /* Termina nodo:290   */
      /* Termina nodo:289   */
      /* Termina nodo:277   */
      /* Termina nodo:276   */
      /* Termina nodo:275   */
      /* Termina nodo:272   */

      /* Empieza nodo:291 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(291)).setAttribute("nombre","formGapTr8" );
      ((Element)v.get(53)).appendChild((Element)v.get(291));

      /* Empieza nodo:292 / Elemento padre: 291   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(292)).setAttribute("align","center" );
      ((Element)v.get(292)).setAttribute("width","8" );
      ((Element)v.get(291)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(293)).setAttribute("src","b.gif" );
      ((Element)v.get(293)).setAttribute("width","12" );
      ((Element)v.get(293)).setAttribute("height","8" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:294 / Elemento padre: 291   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(291)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(295)).setAttribute("src","b.gif" );
      ((Element)v.get(295)).setAttribute("width","8" );
      ((Element)v.get(295)).setAttribute("height","8" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */

      /* Empieza nodo:296 / Elemento padre: 291   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(296)).setAttribute("align","center" );
      ((Element)v.get(296)).setAttribute("width","8" );
      ((Element)v.get(291)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(297)).setAttribute("src","b.gif" );
      ((Element)v.get(297)).setAttribute("width","12" );
      ((Element)v.get(297)).setAttribute("height","8" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));
      /* Termina nodo:297   */
      /* Termina nodo:296   */
      /* Termina nodo:291   */

      /* Empieza nodo:298 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(298)).setAttribute("nombre","formTr9" );
      ((Element)v.get(53)).appendChild((Element)v.get(298));

      /* Empieza nodo:299 / Elemento padre: 298   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(299)).setAttribute("align","center" );
      ((Element)v.get(299)).setAttribute("width","8" );
      ((Element)v.get(298)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(300)).setAttribute("src","b.gif" );
      ((Element)v.get(300)).setAttribute("width","8" );
      ((Element)v.get(300)).setAttribute("height","12" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */
      /* Termina nodo:299   */

      /* Empieza nodo:301 / Elemento padre: 298   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(301)).setAttribute("width","100%" );
      ((Element)v.get(298)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
   }

   private void getXML1350(Document doc) {
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(302)).setAttribute("width","100%" );
      ((Element)v.get(302)).setAttribute("border","0" );
      ((Element)v.get(302)).setAttribute("cellspacing","0" );
      ((Element)v.get(302)).setAttribute("cellpadding","0" );
      ((Element)v.get(302)).setAttribute("align","left" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));

      /* Empieza nodo:303 / Elemento padre: 302   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(303)).setAttribute("align","left" );
      ((Element)v.get(302)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(304)).setAttribute("nombre","indDevoTdId" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(305)).setAttribute("width","100%" );
      ((Element)v.get(305)).setAttribute("border","0" );
      ((Element)v.get(305)).setAttribute("cellspacing","0" );
      ((Element)v.get(305)).setAttribute("cellpadding","0" );
      ((Element)v.get(305)).setAttribute("align","left" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));

      /* Empieza nodo:306 / Elemento padre: 305   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(305)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(307)).setAttribute("valign","top" );
      ((Element)v.get(307)).setAttribute("height","13" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(308)).setAttribute("nombre","lblIndDevo" );
      ((Element)v.get(308)).setAttribute("alto","13" );
      ((Element)v.get(308)).setAttribute("filas","1" );
      ((Element)v.get(308)).setAttribute("id","datosTitle" );
      ((Element)v.get(308)).setAttribute("cod","PedTipoSolic.indDevo.label" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));
      /* Termina nodo:308   */
      /* Termina nodo:307   */
      /* Termina nodo:306   */

      /* Empieza nodo:309 / Elemento padre: 305   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(309)).setAttribute("nombre","indDevoWidgetTrId" );
      ((Element)v.get(305)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(310)).setAttribute("align","left" );
      ((Element)v.get(310)).setAttribute("nowrap","true" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(311)).setAttribute("nombre","indDevo" );
      ((Element)v.get(311)).setAttribute("id","datosCampos" );
      ((Element)v.get(311)).setAttribute("trim","S" );
      ((Element)v.get(311)).setAttribute("max","1" );
      ((Element)v.get(311)).setAttribute("onchange","" );
      ((Element)v.get(311)).setAttribute("req","N" );
      ((Element)v.get(311)).setAttribute("size","1" );
      ((Element)v.get(311)).setAttribute("valor","" );
      ((Element)v.get(311)).setAttribute("validacion","" );
      ((Element)v.get(311)).setAttribute("disabled","" );
      ((Element)v.get(311)).setAttribute("onblur","" );
      ((Element)v.get(311)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicFrm',10, true)" );
      ((Element)v.get(311)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicFrm', 10, false)" );
      ((Element)v.get(310)).appendChild((Element)v.get(311));
      /* Termina nodo:311   */
      /* Termina nodo:310   */
      /* Termina nodo:309   */
      /* Termina nodo:305   */
      /* Termina nodo:304   */

      /* Empieza nodo:312 / Elemento padre: 303   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(312)).setAttribute("nombre","indDevoGapTdId" );
      ((Element)v.get(312)).setAttribute("nowrap","true" );
      ((Element)v.get(312)).setAttribute("class","datosCampos" );
      ((Element)v.get(303)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(313)).setAttribute("src","b.gif" );
      ((Element)v.get(313)).setAttribute("width","25" );
      ((Element)v.get(313)).setAttribute("height","8" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:312   */

      /* Empieza nodo:314 / Elemento padre: 303   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(314)).setAttribute("width","100%" );
      ((Element)v.get(303)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(315)).setAttribute("src","b.gif" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));
      /* Termina nodo:315   */
      /* Termina nodo:314   */
      /* Termina nodo:303   */
      /* Termina nodo:302   */
      /* Termina nodo:301   */
      /* Termina nodo:298   */

      /* Empieza nodo:316 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(316)).setAttribute("nombre","formGapTr9" );
      ((Element)v.get(53)).appendChild((Element)v.get(316));

      /* Empieza nodo:317 / Elemento padre: 316   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(317)).setAttribute("align","center" );
      ((Element)v.get(317)).setAttribute("width","8" );
      ((Element)v.get(316)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(318)).setAttribute("src","b.gif" );
      ((Element)v.get(318)).setAttribute("width","12" );
      ((Element)v.get(318)).setAttribute("height","8" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:317   */

      /* Empieza nodo:319 / Elemento padre: 316   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(316)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(320)).setAttribute("src","b.gif" );
      ((Element)v.get(320)).setAttribute("width","8" );
      ((Element)v.get(320)).setAttribute("height","8" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */

      /* Empieza nodo:321 / Elemento padre: 316   */
   }

   private void getXML1440(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(321)).setAttribute("align","center" );
      ((Element)v.get(321)).setAttribute("width","8" );
      ((Element)v.get(316)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(322)).setAttribute("src","b.gif" );
      ((Element)v.get(322)).setAttribute("width","12" );
      ((Element)v.get(322)).setAttribute("height","8" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));
      /* Termina nodo:322   */
      /* Termina nodo:321   */
      /* Termina nodo:316   */

      /* Empieza nodo:323 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(323)).setAttribute("nombre","formTr10" );
      ((Element)v.get(53)).appendChild((Element)v.get(323));

      /* Empieza nodo:324 / Elemento padre: 323   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(324)).setAttribute("align","center" );
      ((Element)v.get(324)).setAttribute("width","8" );
      ((Element)v.get(323)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(325)).setAttribute("src","b.gif" );
      ((Element)v.get(325)).setAttribute("width","8" );
      ((Element)v.get(325)).setAttribute("height","12" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:326 / Elemento padre: 323   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(326)).setAttribute("width","100%" );
      ((Element)v.get(323)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(327)).setAttribute("width","100%" );
      ((Element)v.get(327)).setAttribute("border","0" );
      ((Element)v.get(327)).setAttribute("cellspacing","0" );
      ((Element)v.get(327)).setAttribute("cellpadding","0" );
      ((Element)v.get(327)).setAttribute("align","left" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));

      /* Empieza nodo:328 / Elemento padre: 327   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(328)).setAttribute("align","left" );
      ((Element)v.get(327)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(329)).setAttribute("nombre","indAnulTdId" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(330)).setAttribute("width","100%" );
      ((Element)v.get(330)).setAttribute("border","0" );
      ((Element)v.get(330)).setAttribute("cellspacing","0" );
      ((Element)v.get(330)).setAttribute("cellpadding","0" );
      ((Element)v.get(330)).setAttribute("align","left" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));

      /* Empieza nodo:331 / Elemento padre: 330   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(330)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(332)).setAttribute("valign","top" );
      ((Element)v.get(332)).setAttribute("height","13" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(333)).setAttribute("nombre","lblIndAnul" );
      ((Element)v.get(333)).setAttribute("alto","13" );
      ((Element)v.get(333)).setAttribute("filas","1" );
      ((Element)v.get(333)).setAttribute("id","datosTitle" );
      ((Element)v.get(333)).setAttribute("cod","PedTipoSolic.indAnul.label" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));
      /* Termina nodo:333   */
      /* Termina nodo:332   */
      /* Termina nodo:331   */

      /* Empieza nodo:334 / Elemento padre: 330   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(334)).setAttribute("nombre","indAnulWidgetTrId" );
      ((Element)v.get(330)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(335)).setAttribute("align","left" );
      ((Element)v.get(335)).setAttribute("nowrap","true" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(336)).setAttribute("nombre","indAnul" );
      ((Element)v.get(336)).setAttribute("id","datosCampos" );
      ((Element)v.get(336)).setAttribute("trim","S" );
      ((Element)v.get(336)).setAttribute("max","1" );
      ((Element)v.get(336)).setAttribute("onchange","" );
      ((Element)v.get(336)).setAttribute("req","N" );
      ((Element)v.get(336)).setAttribute("size","1" );
      ((Element)v.get(336)).setAttribute("valor","" );
      ((Element)v.get(336)).setAttribute("validacion","" );
      ((Element)v.get(336)).setAttribute("disabled","" );
      ((Element)v.get(336)).setAttribute("onblur","" );
      ((Element)v.get(336)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicFrm',11, true)" );
      ((Element)v.get(336)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicFrm', 11, false)" );
      ((Element)v.get(335)).appendChild((Element)v.get(336));
      /* Termina nodo:336   */
      /* Termina nodo:335   */
      /* Termina nodo:334   */
      /* Termina nodo:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:337 / Elemento padre: 328   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(337)).setAttribute("nombre","indAnulGapTdId" );
      ((Element)v.get(337)).setAttribute("nowrap","true" );
      ((Element)v.get(337)).setAttribute("class","datosCampos" );
      ((Element)v.get(328)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(338)).setAttribute("src","b.gif" );
      ((Element)v.get(338)).setAttribute("width","25" );
      ((Element)v.get(338)).setAttribute("height","8" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */

      /* Empieza nodo:339 / Elemento padre: 328   */
      v.add(doc.createElement("TD"));
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(339)).setAttribute("width","100%" );
      ((Element)v.get(328)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(340)).setAttribute("src","b.gif" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));
      /* Termina nodo:340   */
      /* Termina nodo:339   */
      /* Termina nodo:328   */
      /* Termina nodo:327   */
      /* Termina nodo:326   */
      /* Termina nodo:323   */

      /* Empieza nodo:341 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(341)).setAttribute("nombre","formGapTr10" );
      ((Element)v.get(53)).appendChild((Element)v.get(341));

      /* Empieza nodo:342 / Elemento padre: 341   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(342)).setAttribute("align","center" );
      ((Element)v.get(342)).setAttribute("width","8" );
      ((Element)v.get(341)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(343)).setAttribute("src","b.gif" );
      ((Element)v.get(343)).setAttribute("width","12" );
      ((Element)v.get(343)).setAttribute("height","8" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */
      /* Termina nodo:342   */

      /* Empieza nodo:344 / Elemento padre: 341   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(341)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(345)).setAttribute("src","b.gif" );
      ((Element)v.get(345)).setAttribute("width","8" );
      ((Element)v.get(345)).setAttribute("height","8" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */
      /* Termina nodo:344   */

      /* Empieza nodo:346 / Elemento padre: 341   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(346)).setAttribute("align","center" );
      ((Element)v.get(346)).setAttribute("width","8" );
      ((Element)v.get(341)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(347)).setAttribute("src","b.gif" );
      ((Element)v.get(347)).setAttribute("width","12" );
      ((Element)v.get(347)).setAttribute("height","8" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));
      /* Termina nodo:347   */
      /* Termina nodo:346   */
      /* Termina nodo:341   */

      /* Empieza nodo:348 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(348)).setAttribute("nombre","formTr11" );
      ((Element)v.get(53)).appendChild((Element)v.get(348));

      /* Empieza nodo:349 / Elemento padre: 348   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(349)).setAttribute("align","center" );
      ((Element)v.get(349)).setAttribute("width","8" );
      ((Element)v.get(348)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(350)).setAttribute("src","b.gif" );
      ((Element)v.get(350)).setAttribute("width","8" );
      ((Element)v.get(350)).setAttribute("height","12" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:349   */

      /* Empieza nodo:351 / Elemento padre: 348   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(351)).setAttribute("width","100%" );
      ((Element)v.get(348)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(352)).setAttribute("width","100%" );
      ((Element)v.get(352)).setAttribute("border","0" );
      ((Element)v.get(352)).setAttribute("cellspacing","0" );
      ((Element)v.get(352)).setAttribute("cellpadding","0" );
      ((Element)v.get(352)).setAttribute("align","left" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));

      /* Empieza nodo:353 / Elemento padre: 352   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(353)).setAttribute("align","left" );
      ((Element)v.get(352)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(354)).setAttribute("nombre","sbacOidSbac_acceOidAcce_canaOidCanaTdId" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(355)).setAttribute("border","0" );
      ((Element)v.get(355)).setAttribute("cellspacing","0" );
      ((Element)v.get(355)).setAttribute("cellpadding","0" );
      ((Element)v.get(355)).setAttribute("align","left" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));

      /* Empieza nodo:356 / Elemento padre: 355   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(355)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(357)).setAttribute("valign","top" );
      ((Element)v.get(357)).setAttribute("height","13" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(358)).setAttribute("nombre","lblsbacOidSbac_acceOidAcce_canaOidCana" );
      ((Element)v.get(358)).setAttribute("id","datosTitle" );
      ((Element)v.get(358)).setAttribute("ancho","150" );
      ((Element)v.get(358)).setAttribute("alto","13" );
      ((Element)v.get(358)).setAttribute("cod","SegAcces.canaOidCana.label" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));
      /* Termina nodo:358   */
      /* Termina nodo:357   */
      /* Termina nodo:356   */

      /* Empieza nodo:359 / Elemento padre: 355   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(359)).setAttribute("nombre","sbacOidSbac_acceOidAcce_canaOidCanaWidgetTrId" );
      ((Element)v.get(355)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(360)).setAttribute("align","left" );
      ((Element)v.get(360)).setAttribute("nowrap","true" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(361)).setAttribute("nombre","sbacOidSbac_acceOidAcce_canaOidCana" );
      ((Element)v.get(361)).setAttribute("id","datosCampos" );
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(361)).setAttribute("multiple","N" );
      ((Element)v.get(361)).setAttribute("req","N" );
      ((Element)v.get(361)).setAttribute("size","1" );
      ((Element)v.get(361)).setAttribute("disabled","" );
      ((Element)v.get(361)).setAttribute("validacion","" );
      ((Element)v.get(361)).setAttribute("onchange","mmgDependeneChange('sbacOidSbac_acceOidAcce_canaOidCana', 'sbacOidSbac' , 'pedTipoSolic')" );
      ((Element)v.get(361)).setAttribute("onfocus","" );
      ((Element)v.get(361)).setAttribute("valorinicial","" );
      ((Element)v.get(361)).setAttribute("textoinicial","" );
      ((Element)v.get(361)).setAttribute("ontab","focaliza('pedTipoSolicFrm.sbacOidSbac_acceOidAcce');" );
      ((Element)v.get(361)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicFrm',12, false);" );
      ((Element)v.get(360)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(361)).appendChild((Element)v.get(362));
      /* Termina nodo:362   */
      /* Termina nodo:361   */
      /* Termina nodo:360   */
      /* Termina nodo:359   */
      /* Termina nodo:355   */
      /* Termina nodo:354   */

      /* Empieza nodo:363 / Elemento padre: 353   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(363)).setAttribute("nombre","sbacOidSbac_acceOidAcce_canaOidCanaGapTdId" );
      ((Element)v.get(363)).setAttribute("nowrap","true" );
      ((Element)v.get(363)).setAttribute("class","datosCampos" );
      ((Element)v.get(353)).appendChild((Element)v.get(363));

      /* Empieza nodo:364 / Elemento padre: 363   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(364)).setAttribute("src","b.gif" );
      ((Element)v.get(364)).setAttribute("width","25" );
      ((Element)v.get(364)).setAttribute("height","8" );
      ((Element)v.get(363)).appendChild((Element)v.get(364));
      /* Termina nodo:364   */
      /* Termina nodo:363   */

      /* Empieza nodo:365 / Elemento padre: 353   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(365)).setAttribute("nombre","sbacOidSbac_acceOidAcceTdId" );
      ((Element)v.get(353)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(366)).setAttribute("border","0" );
      ((Element)v.get(366)).setAttribute("cellspacing","0" );
      ((Element)v.get(366)).setAttribute("cellpadding","0" );
      ((Element)v.get(366)).setAttribute("align","left" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));

      /* Empieza nodo:367 / Elemento padre: 366   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(366)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(368)).setAttribute("valign","top" );
      ((Element)v.get(368)).setAttribute("height","13" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));

      /* Empieza nodo:369 / Elemento padre: 368   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(369)).setAttribute("nombre","lblsbacOidSbac_acceOidAcce" );
      ((Element)v.get(369)).setAttribute("id","datosTitle" );
      ((Element)v.get(369)).setAttribute("ancho","150" );
      ((Element)v.get(369)).setAttribute("alto","13" );
      ((Element)v.get(369)).setAttribute("cod","SegSubac.acceOidAcce.label" );
      ((Element)v.get(368)).appendChild((Element)v.get(369));
      /* Termina nodo:369   */
      /* Termina nodo:368   */
      /* Termina nodo:367   */

      /* Empieza nodo:370 / Elemento padre: 366   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(370)).setAttribute("nombre","sbacOidSbac_acceOidAcceWidgetTrId" );
      ((Element)v.get(366)).appendChild((Element)v.get(370));

      /* Empieza nodo:371 / Elemento padre: 370   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(371)).setAttribute("align","left" );
      ((Element)v.get(371)).setAttribute("nowrap","true" );
      ((Element)v.get(370)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(372)).setAttribute("nombre","sbacOidSbac_acceOidAcce" );
      ((Element)v.get(372)).setAttribute("id","datosCampos" );
      ((Element)v.get(372)).setAttribute("multiple","N" );
      ((Element)v.get(372)).setAttribute("req","N" );
      ((Element)v.get(372)).setAttribute("size","1" );
      ((Element)v.get(372)).setAttribute("disabled","" );
      ((Element)v.get(372)).setAttribute("validacion","" );
      ((Element)v.get(372)).setAttribute("onchange","mmgDependeneChange('sbacOidSbac_acceOidAcce', 'sbacOidSbac' , 'pedTipoSolic')" );
      ((Element)v.get(372)).setAttribute("onfocus","" );
      ((Element)v.get(372)).setAttribute("valorinicial","" );
      ((Element)v.get(372)).setAttribute("textoinicial","" );
      ((Element)v.get(372)).setAttribute("ontab","focaliza('pedTipoSolicFrm.sbacOidSbac');" );
      ((Element)v.get(372)).setAttribute("onshtab","focaliza('pedTipoSolicFrm.sbacOidSbac_acceOidAcce_canaOidCana');" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(372)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */
      /* Termina nodo:372   */
      /* Termina nodo:371   */
      /* Termina nodo:370   */
      /* Termina nodo:366   */
      /* Termina nodo:365   */

      /* Empieza nodo:374 / Elemento padre: 353   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(374)).setAttribute("nombre","sbacOidSbac_acceOidAcceGapTdId" );
      ((Element)v.get(374)).setAttribute("nowrap","true" );
      ((Element)v.get(374)).setAttribute("class","datosCampos" );
      ((Element)v.get(353)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(375)).setAttribute("src","b.gif" );
      ((Element)v.get(375)).setAttribute("width","25" );
      ((Element)v.get(375)).setAttribute("height","8" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */
      /* Termina nodo:374   */

      /* Empieza nodo:376 / Elemento padre: 353   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(376)).setAttribute("nombre","sbacOidSbacTdId" );
      ((Element)v.get(353)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(377)).setAttribute("border","0" );
      ((Element)v.get(377)).setAttribute("cellspacing","0" );
      ((Element)v.get(377)).setAttribute("cellpadding","0" );
      ((Element)v.get(377)).setAttribute("align","left" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));

      /* Empieza nodo:378 / Elemento padre: 377   */
      v.add(doc.createElement("TR"));
   }

   private void getXML1710(Document doc) {
      ((Element)v.get(377)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(379)).setAttribute("valign","top" );
      ((Element)v.get(379)).setAttribute("height","13" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(380)).setAttribute("nombre","lblsbacOidSbac" );
      ((Element)v.get(380)).setAttribute("id","datosTitle" );
      ((Element)v.get(380)).setAttribute("ancho","150" );
      ((Element)v.get(380)).setAttribute("alto","13" );
      ((Element)v.get(380)).setAttribute("cod","PedTipoSolic.sbacOidSbac.label" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */
      /* Termina nodo:379   */
      /* Termina nodo:378   */

      /* Empieza nodo:381 / Elemento padre: 377   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(381)).setAttribute("nombre","sbacOidSbacWidgetTrId" );
      ((Element)v.get(377)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(382)).setAttribute("align","left" );
      ((Element)v.get(382)).setAttribute("nowrap","true" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(383)).setAttribute("nombre","sbacOidSbac" );
      ((Element)v.get(383)).setAttribute("id","datosCampos" );
      ((Element)v.get(383)).setAttribute("multiple","N" );
      ((Element)v.get(383)).setAttribute("req","N" );
      ((Element)v.get(383)).setAttribute("size","1" );
      ((Element)v.get(383)).setAttribute("disabled","" );
      ((Element)v.get(383)).setAttribute("validacion","" );
      ((Element)v.get(383)).setAttribute("onchange","" );
      ((Element)v.get(383)).setAttribute("onfocus","" );
      ((Element)v.get(383)).setAttribute("valorinicial","" );
      ((Element)v.get(383)).setAttribute("textoinicial","" );
      ((Element)v.get(383)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicFrm',12, true);" );
      ((Element)v.get(383)).setAttribute("onshtab","focaliza('pedTipoSolicFrm.sbacOidSbac_acceOidAcce');" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(383)).appendChild((Element)v.get(384));
      /* Termina nodo:384   */
      /* Termina nodo:383   */
      /* Termina nodo:382   */
      /* Termina nodo:381   */
      /* Termina nodo:377   */
      /* Termina nodo:376   */

      /* Empieza nodo:385 / Elemento padre: 353   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(385)).setAttribute("nombre","sbacOidSbacGapTdId" );
      ((Element)v.get(385)).setAttribute("nowrap","true" );
      ((Element)v.get(385)).setAttribute("class","datosCampos" );
      ((Element)v.get(353)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(386)).setAttribute("src","b.gif" );
      ((Element)v.get(386)).setAttribute("width","25" );
      ((Element)v.get(386)).setAttribute("height","8" );
      ((Element)v.get(385)).appendChild((Element)v.get(386));
      /* Termina nodo:386   */
      /* Termina nodo:385   */

      /* Empieza nodo:387 / Elemento padre: 353   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(387)).setAttribute("width","100%" );
      ((Element)v.get(353)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(388)).setAttribute("src","b.gif" );
      ((Element)v.get(387)).appendChild((Element)v.get(388));
      /* Termina nodo:388   */
      /* Termina nodo:387   */
      /* Termina nodo:353   */
      /* Termina nodo:352   */
      /* Termina nodo:351   */
      /* Termina nodo:348   */

      /* Empieza nodo:389 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(389)).setAttribute("nombre","formGapTr11" );
      ((Element)v.get(53)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(390)).setAttribute("align","center" );
      ((Element)v.get(390)).setAttribute("width","8" );
      ((Element)v.get(389)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(391)).setAttribute("src","b.gif" );
      ((Element)v.get(391)).setAttribute("width","12" );
      ((Element)v.get(391)).setAttribute("height","8" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));
      /* Termina nodo:391   */
      /* Termina nodo:390   */

      /* Empieza nodo:392 / Elemento padre: 389   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(389)).appendChild((Element)v.get(392));

      /* Empieza nodo:393 / Elemento padre: 392   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(393)).setAttribute("src","b.gif" );
      ((Element)v.get(393)).setAttribute("width","8" );
      ((Element)v.get(393)).setAttribute("height","8" );
      ((Element)v.get(392)).appendChild((Element)v.get(393));
      /* Termina nodo:393   */
      /* Termina nodo:392   */

      /* Empieza nodo:394 / Elemento padre: 389   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(394)).setAttribute("align","center" );
      ((Element)v.get(394)).setAttribute("width","8" );
      ((Element)v.get(389)).appendChild((Element)v.get(394));

      /* Empieza nodo:395 / Elemento padre: 394   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(395)).setAttribute("src","b.gif" );
      ((Element)v.get(395)).setAttribute("width","12" );
      ((Element)v.get(395)).setAttribute("height","8" );
      ((Element)v.get(394)).appendChild((Element)v.get(395));
      /* Termina nodo:395   */
      /* Termina nodo:394   */
      /* Termina nodo:389   */

      /* Empieza nodo:396 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(396)).setAttribute("nombre","formTr12" );
      ((Element)v.get(53)).appendChild((Element)v.get(396));

      /* Empieza nodo:397 / Elemento padre: 396   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(397)).setAttribute("align","center" );
      ((Element)v.get(397)).setAttribute("width","8" );
      ((Element)v.get(396)).appendChild((Element)v.get(397));

      /* Empieza nodo:398 / Elemento padre: 397   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(398)).setAttribute("src","b.gif" );
      ((Element)v.get(398)).setAttribute("width","8" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(398)).setAttribute("height","12" );
      ((Element)v.get(397)).appendChild((Element)v.get(398));
      /* Termina nodo:398   */
      /* Termina nodo:397   */

      /* Empieza nodo:399 / Elemento padre: 396   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(399)).setAttribute("width","100%" );
      ((Element)v.get(396)).appendChild((Element)v.get(399));

      /* Empieza nodo:400 / Elemento padre: 399   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(400)).setAttribute("width","100%" );
      ((Element)v.get(400)).setAttribute("border","0" );
      ((Element)v.get(400)).setAttribute("cellspacing","0" );
      ((Element)v.get(400)).setAttribute("cellpadding","0" );
      ((Element)v.get(400)).setAttribute("align","left" );
      ((Element)v.get(399)).appendChild((Element)v.get(400));

      /* Empieza nodo:401 / Elemento padre: 400   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(401)).setAttribute("align","left" );
      ((Element)v.get(400)).appendChild((Element)v.get(401));

      /* Empieza nodo:402 / Elemento padre: 401   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(402)).setAttribute("nombre","codGrupSoliTdId" );
      ((Element)v.get(401)).appendChild((Element)v.get(402));

      /* Empieza nodo:403 / Elemento padre: 402   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(403)).setAttribute("width","100%" );
      ((Element)v.get(403)).setAttribute("border","0" );
      ((Element)v.get(403)).setAttribute("cellspacing","0" );
      ((Element)v.get(403)).setAttribute("cellpadding","0" );
      ((Element)v.get(403)).setAttribute("align","left" );
      ((Element)v.get(402)).appendChild((Element)v.get(403));

      /* Empieza nodo:404 / Elemento padre: 403   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(403)).appendChild((Element)v.get(404));

      /* Empieza nodo:405 / Elemento padre: 404   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(405)).setAttribute("valign","top" );
      ((Element)v.get(405)).setAttribute("height","13" );
      ((Element)v.get(404)).appendChild((Element)v.get(405));

      /* Empieza nodo:406 / Elemento padre: 405   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(406)).setAttribute("nombre","lblCodGrupSoli" );
      ((Element)v.get(406)).setAttribute("alto","13" );
      ((Element)v.get(406)).setAttribute("filas","1" );
      ((Element)v.get(406)).setAttribute("id","datosTitle" );
      ((Element)v.get(406)).setAttribute("cod","PedTipoSolic.codGrupSoli.label" );
      ((Element)v.get(405)).appendChild((Element)v.get(406));
      /* Termina nodo:406   */
      /* Termina nodo:405   */
      /* Termina nodo:404   */

      /* Empieza nodo:407 / Elemento padre: 403   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(407)).setAttribute("nombre","codGrupSoliWidgetTrId" );
      ((Element)v.get(403)).appendChild((Element)v.get(407));

      /* Empieza nodo:408 / Elemento padre: 407   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(408)).setAttribute("align","left" );
      ((Element)v.get(408)).setAttribute("nowrap","true" );
      ((Element)v.get(407)).appendChild((Element)v.get(408));

      /* Empieza nodo:409 / Elemento padre: 408   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(409)).setAttribute("nombre","codGrupSoli" );
      ((Element)v.get(409)).setAttribute("id","datosCampos" );
      ((Element)v.get(409)).setAttribute("trim","S" );
      ((Element)v.get(409)).setAttribute("max","2" );
      ((Element)v.get(409)).setAttribute("onchange","" );
      ((Element)v.get(409)).setAttribute("req","N" );
      ((Element)v.get(409)).setAttribute("size","2" );
      ((Element)v.get(409)).setAttribute("valor","" );
      ((Element)v.get(409)).setAttribute("validacion","" );
      ((Element)v.get(409)).setAttribute("disabled","" );
      ((Element)v.get(409)).setAttribute("onblur","" );
      ((Element)v.get(409)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicFrm',13, true)" );
      ((Element)v.get(409)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicFrm', 13, false)" );
      ((Element)v.get(408)).appendChild((Element)v.get(409));
      /* Termina nodo:409   */
      /* Termina nodo:408   */
      /* Termina nodo:407   */
      /* Termina nodo:403   */
      /* Termina nodo:402   */

      /* Empieza nodo:410 / Elemento padre: 401   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(410)).setAttribute("nombre","codGrupSoliGapTdId" );
      ((Element)v.get(410)).setAttribute("nowrap","true" );
      ((Element)v.get(410)).setAttribute("class","datosCampos" );
      ((Element)v.get(401)).appendChild((Element)v.get(410));

      /* Empieza nodo:411 / Elemento padre: 410   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(411)).setAttribute("src","b.gif" );
      ((Element)v.get(411)).setAttribute("width","25" );
      ((Element)v.get(411)).setAttribute("height","8" );
      ((Element)v.get(410)).appendChild((Element)v.get(411));
      /* Termina nodo:411   */
      /* Termina nodo:410   */

      /* Empieza nodo:412 / Elemento padre: 401   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(412)).setAttribute("width","100%" );
      ((Element)v.get(401)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(413)).setAttribute("src","b.gif" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));
      /* Termina nodo:413   */
      /* Termina nodo:412   */
      /* Termina nodo:401   */
      /* Termina nodo:400   */
      /* Termina nodo:399   */
      /* Termina nodo:396   */

      /* Empieza nodo:414 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(414)).setAttribute("nombre","formGapTr12" );
      ((Element)v.get(53)).appendChild((Element)v.get(414));

      /* Empieza nodo:415 / Elemento padre: 414   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(415)).setAttribute("align","center" );
      ((Element)v.get(415)).setAttribute("width","8" );
      ((Element)v.get(414)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(416)).setAttribute("src","b.gif" );
      ((Element)v.get(416)).setAttribute("width","12" );
      ((Element)v.get(416)).setAttribute("height","8" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));
      /* Termina nodo:416   */
      /* Termina nodo:415   */

      /* Empieza nodo:417 / Elemento padre: 414   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(414)).appendChild((Element)v.get(417));

      /* Empieza nodo:418 / Elemento padre: 417   */
   }

   private void getXML1890(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(418)).setAttribute("src","b.gif" );
      ((Element)v.get(418)).setAttribute("width","8" );
      ((Element)v.get(418)).setAttribute("height","8" );
      ((Element)v.get(417)).appendChild((Element)v.get(418));
      /* Termina nodo:418   */
      /* Termina nodo:417   */

      /* Empieza nodo:419 / Elemento padre: 414   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(419)).setAttribute("align","center" );
      ((Element)v.get(419)).setAttribute("width","8" );
      ((Element)v.get(414)).appendChild((Element)v.get(419));

      /* Empieza nodo:420 / Elemento padre: 419   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(420)).setAttribute("src","b.gif" );
      ((Element)v.get(420)).setAttribute("width","12" );
      ((Element)v.get(420)).setAttribute("height","8" );
      ((Element)v.get(419)).appendChild((Element)v.get(420));
      /* Termina nodo:420   */
      /* Termina nodo:419   */
      /* Termina nodo:414   */

      /* Empieza nodo:421 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(421)).setAttribute("nombre","formTr13" );
      ((Element)v.get(53)).appendChild((Element)v.get(421));

      /* Empieza nodo:422 / Elemento padre: 421   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(422)).setAttribute("align","center" );
      ((Element)v.get(422)).setAttribute("width","8" );
      ((Element)v.get(421)).appendChild((Element)v.get(422));

      /* Empieza nodo:423 / Elemento padre: 422   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(423)).setAttribute("src","b.gif" );
      ((Element)v.get(423)).setAttribute("width","8" );
      ((Element)v.get(423)).setAttribute("height","12" );
      ((Element)v.get(422)).appendChild((Element)v.get(423));
      /* Termina nodo:423   */
      /* Termina nodo:422   */

      /* Empieza nodo:424 / Elemento padre: 421   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(424)).setAttribute("width","100%" );
      ((Element)v.get(421)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(425)).setAttribute("width","100%" );
      ((Element)v.get(425)).setAttribute("border","0" );
      ((Element)v.get(425)).setAttribute("cellspacing","0" );
      ((Element)v.get(425)).setAttribute("cellpadding","0" );
      ((Element)v.get(425)).setAttribute("align","left" );
      ((Element)v.get(424)).appendChild((Element)v.get(425));

      /* Empieza nodo:426 / Elemento padre: 425   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(426)).setAttribute("align","left" );
      ((Element)v.get(425)).appendChild((Element)v.get(426));

      /* Empieza nodo:427 / Elemento padre: 426   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(427)).setAttribute("nombre","DescripcionTdId" );
      ((Element)v.get(426)).appendChild((Element)v.get(427));

      /* Empieza nodo:428 / Elemento padre: 427   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(428)).setAttribute("width","100%" );
      ((Element)v.get(428)).setAttribute("border","0" );
      ((Element)v.get(428)).setAttribute("cellspacing","0" );
      ((Element)v.get(428)).setAttribute("cellpadding","0" );
      ((Element)v.get(428)).setAttribute("align","left" );
      ((Element)v.get(427)).appendChild((Element)v.get(428));

      /* Empieza nodo:429 / Elemento padre: 428   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(428)).appendChild((Element)v.get(429));

      /* Empieza nodo:430 / Elemento padre: 429   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(430)).setAttribute("valign","top" );
      ((Element)v.get(430)).setAttribute("height","13" );
      ((Element)v.get(429)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(431)).setAttribute("nombre","lblDescripcion" );
      ((Element)v.get(431)).setAttribute("alto","13" );
      ((Element)v.get(431)).setAttribute("filas","1" );
      ((Element)v.get(431)).setAttribute("id","datosTitle" );
      ((Element)v.get(431)).setAttribute("cod","PedTipoSolic.Descripcion.label" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */
      /* Termina nodo:430   */

      /* Empieza nodo:432 / Elemento padre: 429   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(432)).setAttribute("nombre","DescripcionTdLocalizationButtonGapHeader" );
      ((Element)v.get(432)).setAttribute("colspan","2" );
      ((Element)v.get(429)).appendChild((Element)v.get(432));
      /* Termina nodo:432   */
      /* Termina nodo:429   */

      /* Empieza nodo:433 / Elemento padre: 428   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(433)).setAttribute("nombre","DescripcionWidgetTrId" );
      ((Element)v.get(428)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(434)).setAttribute("align","left" );
      ((Element)v.get(434)).setAttribute("nowrap","true" );
      ((Element)v.get(433)).appendChild((Element)v.get(434));

      /* Empieza nodo:435 / Elemento padre: 434   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(435)).setAttribute("nombre","Descripcion" );
      ((Element)v.get(435)).setAttribute("id","datosCampos" );
      ((Element)v.get(435)).setAttribute("trim","S" );
      ((Element)v.get(435)).setAttribute("max","50" );
      ((Element)v.get(435)).setAttribute("onchange","" );
      ((Element)v.get(435)).setAttribute("req","N" );
      ((Element)v.get(435)).setAttribute("size","50" );
      ((Element)v.get(435)).setAttribute("valor","" );
      ((Element)v.get(435)).setAttribute("validacion","" );
      ((Element)v.get(435)).setAttribute("disabled","" );
      ((Element)v.get(435)).setAttribute("onblur","" );
      ((Element)v.get(435)).setAttribute("ontab","ejecutarAccionFoco('pedTipoSolicFrm',14, true)" );
      ((Element)v.get(435)).setAttribute("onshtab","ejecutarAccionFoco('pedTipoSolicFrm', 14, false)" );
      ((Element)v.get(434)).appendChild((Element)v.get(435));
      /* Termina nodo:435   */
      /* Termina nodo:434   */

      /* Empieza nodo:436 / Elemento padre: 433   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(433)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
   }

   private void getXML1980(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(437)).setAttribute("src","b.gif" );
      ((Element)v.get(437)).setAttribute("width","8" );
      ((Element)v.get(437)).setAttribute("height","8" );
      ((Element)v.get(436)).appendChild((Element)v.get(437));
      /* Termina nodo:437   */
      /* Termina nodo:436   */

      /* Empieza nodo:438 / Elemento padre: 433   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(438)).setAttribute("nombre","DescripcionTdLocalizationButton" );
      ((Element)v.get(438)).setAttribute("align","left" );
      ((Element)v.get(438)).setAttribute("nowrap","true" );
      ((Element)v.get(438)).setAttribute("valign","bottom" );
      ((Element)v.get(433)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("A"));
      ((Element)v.get(439)).setAttribute("id","DescripcionLocalizationButton" );
      ((Element)v.get(439)).setAttribute("href","javascript:openLocalizationDialog('pedTipoSolicFrm', 'Descripcion', 1);" );
      ((Element)v.get(439)).setAttribute("onKeyDown","javascript:mmgImgEventDispatcherForFocus(event, 'ejecutarAccionFoco(\"pedTipoSolicFrm\",14, true)', 'ejecutarAccionFoco(\"pedTipoSolicFrm\",14, false)')" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(440)).setAttribute("nombre","DescripcionLocalizationButton" );
      ((Element)v.get(440)).setAttribute("src","iconmultidioma.gif" );
      ((Element)v.get(440)).setAttribute("border","0" );
      ((Element)v.get(440)).setAttribute("width","21" );
      ((Element)v.get(440)).setAttribute("height","15" );
      ((Element)v.get(440)).setAttribute("class","main" );
      ((Element)v.get(439)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */
      /* Termina nodo:439   */
      /* Termina nodo:438   */
      /* Termina nodo:433   */
      /* Termina nodo:428   */
      /* Termina nodo:427   */

      /* Empieza nodo:441 / Elemento padre: 426   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(441)).setAttribute("nombre","DescripcionGapTdId" );
      ((Element)v.get(441)).setAttribute("nowrap","true" );
      ((Element)v.get(441)).setAttribute("class","datosCampos" );
      ((Element)v.get(426)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(442)).setAttribute("src","b.gif" );
      ((Element)v.get(442)).setAttribute("width","25" );
      ((Element)v.get(442)).setAttribute("height","8" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */
      /* Termina nodo:441   */

      /* Empieza nodo:443 / Elemento padre: 426   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(443)).setAttribute("width","100%" );
      ((Element)v.get(426)).appendChild((Element)v.get(443));

      /* Empieza nodo:444 / Elemento padre: 443   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(444)).setAttribute("src","b.gif" );
      ((Element)v.get(443)).appendChild((Element)v.get(444));
      /* Termina nodo:444   */
      /* Termina nodo:443   */
      /* Termina nodo:426   */
      /* Termina nodo:425   */
      /* Termina nodo:424   */

      /* Empieza nodo:445 / Elemento padre: 421   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(445)).setAttribute("width","100%" );
      ((Element)v.get(421)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */
      /* Termina nodo:421   */

      /* Empieza nodo:446 / Elemento padre: 53   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(446)).setAttribute("nombre","formGapTr13" );
      ((Element)v.get(53)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(447)).setAttribute("align","center" );
      ((Element)v.get(447)).setAttribute("width","8" );
      ((Element)v.get(446)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(448)).setAttribute("src","b.gif" );
      ((Element)v.get(448)).setAttribute("width","8" );
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
      ((Element)v.get(451)).setAttribute("width","8" );
      ((Element)v.get(446)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(452)).setAttribute("src","b.gif" );
      ((Element)v.get(452)).setAttribute("width","8" );
      ((Element)v.get(452)).setAttribute("height","8" );
      ((Element)v.get(451)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */
      /* Termina nodo:451   */
      /* Termina nodo:446   */
      /* Termina nodo:53   */
      /* Termina nodo:50   */
      /* Termina nodo:49   */

      /* Empieza nodo:453 / Elemento padre: 46   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(453)).setAttribute("align","center" );
      ((Element)v.get(453)).setAttribute("width","12" );
      ((Element)v.get(46)).appendChild((Element)v.get(453));

      /* Empieza nodo:454 / Elemento padre: 453   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(454)).setAttribute("src","b.gif" );
      ((Element)v.get(454)).setAttribute("width","12" );
      ((Element)v.get(454)).setAttribute("height","12" );
      ((Element)v.get(453)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */
      /* Termina nodo:453   */
      /* Termina nodo:46   */

      /* Empieza nodo:455 / Elemento padre: 38   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(455)).setAttribute("nombre","pedTipoSolicTrButtons" );
      ((Element)v.get(38)).appendChild((Element)v.get(455));

      /* Empieza nodo:456 / Elemento padre: 455   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(456)).setAttribute("align","center" );
      ((Element)v.get(456)).setAttribute("width","12" );
      ((Element)v.get(455)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(457)).setAttribute("src","b.gif" );
      ((Element)v.get(457)).setAttribute("width","12" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(457)).setAttribute("height","12" );
      ((Element)v.get(456)).appendChild((Element)v.get(457));
      /* Termina nodo:457   */
      /* Termina nodo:456   */

      /* Empieza nodo:458 / Elemento padre: 455   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(455)).appendChild((Element)v.get(458));

      /* Empieza nodo:459 / Elemento padre: 458   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(458)).appendChild((Element)v.get(459));

      /* Empieza nodo:460 / Elemento padre: 459   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(460)).setAttribute("width","100%" );
      ((Element)v.get(460)).setAttribute("border","0" );
      ((Element)v.get(460)).setAttribute("align","center" );
      ((Element)v.get(460)).setAttribute("cellspacing","0" );
      ((Element)v.get(460)).setAttribute("cellpadding","0" );
      ((Element)v.get(459)).appendChild((Element)v.get(460));

      /* Empieza nodo:461 / Elemento padre: 460   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(460)).appendChild((Element)v.get(461));

      /* Empieza nodo:462 / Elemento padre: 461   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(462)).setAttribute("class","tablaTitle" );
      ((Element)v.get(462)).setAttribute("nombre","pedTipoSolicTdQueryButton" );
      ((Element)v.get(461)).appendChild((Element)v.get(462));

      /* Empieza nodo:463 / Elemento padre: 462   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(463)).setAttribute("nombre","pedTipoSolicQueryButton" );
      ((Element)v.get(463)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(463)).setAttribute("estado","false" );
      ((Element)v.get(463)).setAttribute("accion","pedTipoSolicFirstPage();" );
      ((Element)v.get(463)).setAttribute("tipo","html" );
      ((Element)v.get(463)).setAttribute("ID","botonContenido" );
      ((Element)v.get(462)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */
      /* Termina nodo:462   */

      /* Empieza nodo:464 / Elemento padre: 461   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(464)).setAttribute("class","tablaTitle" );
      ((Element)v.get(464)).setAttribute("nombre","pedTipoSolicTdLovNullSelectionButton" );
      ((Element)v.get(464)).setAttribute("align","left" );
      ((Element)v.get(464)).setAttribute("width","100%" );
      ((Element)v.get(461)).appendChild((Element)v.get(464));

      /* Empieza nodo:465 / Elemento padre: 464   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(465)).setAttribute("src","b.gif" );
      ((Element)v.get(465)).setAttribute("height","8" );
      ((Element)v.get(465)).setAttribute("width","8" );
      ((Element)v.get(464)).appendChild((Element)v.get(465));
      /* Termina nodo:465   */

      /* Empieza nodo:466 / Elemento padre: 464   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(466)).setAttribute("nombre","pedTipoSolicLovNullButton" );
      ((Element)v.get(466)).setAttribute("ID","botonContenido" );
      ((Element)v.get(466)).setAttribute("tipo","html" );
      ((Element)v.get(466)).setAttribute("accion","pedTipoSolicLovNullSelectionAction();" );
      ((Element)v.get(466)).setAttribute("estado","true" );
      ((Element)v.get(466)).setAttribute("cod","MMGGlobal.lovNullButton.label" );
      ((Element)v.get(464)).appendChild((Element)v.get(466));
      /* Termina nodo:466   */
      /* Termina nodo:464   */
      /* Termina nodo:461   */
      /* Termina nodo:460   */
      /* Termina nodo:459   */
      /* Termina nodo:458   */

      /* Empieza nodo:467 / Elemento padre: 455   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(467)).setAttribute("align","center" );
      ((Element)v.get(467)).setAttribute("width","12" );
      ((Element)v.get(455)).appendChild((Element)v.get(467));

      /* Empieza nodo:468 / Elemento padre: 467   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(468)).setAttribute("src","b.gif" );
      ((Element)v.get(468)).setAttribute("width","12" );
      ((Element)v.get(468)).setAttribute("height","12" );
      ((Element)v.get(467)).appendChild((Element)v.get(468));
      /* Termina nodo:468   */
      /* Termina nodo:467   */
      /* Termina nodo:455   */
      /* Termina nodo:38   */
      /* Termina nodo:37   */

      /* Empieza nodo:469 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(469)).setAttribute("nombre","pedTipoSolicListLayer" );
      ((Element)v.get(469)).setAttribute("alto","310" );
      ((Element)v.get(469)).setAttribute("ancho","99%" );
      ((Element)v.get(469)).setAttribute("colorf","" );
      ((Element)v.get(469)).setAttribute("borde","0" );
      ((Element)v.get(469)).setAttribute("imagenf","" );
      ((Element)v.get(469)).setAttribute("repeat","" );
      ((Element)v.get(469)).setAttribute("padding","" );
      ((Element)v.get(469)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(469)).setAttribute("contravsb","" );
      ((Element)v.get(469)).setAttribute("x","3" );
      ((Element)v.get(469)).setAttribute("y","" );
      ((Element)v.get(469)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(469));

      /* Empieza nodo:470 / Elemento padre: 469   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(470)).setAttribute("nombre","pedTipoSolicList" );
      ((Element)v.get(470)).setAttribute("ancho","680" );
      ((Element)v.get(470)).setAttribute("alto","275" );
      ((Element)v.get(470)).setAttribute("x","12" );
      ((Element)v.get(470)).setAttribute("y","0" );
      ((Element)v.get(470)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(470)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(469)).appendChild((Element)v.get(470));

      /* Empieza nodo:471 / Elemento padre: 470   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(471)).setAttribute("precarga","S" );
      ((Element)v.get(471)).setAttribute("conROver","S" );
      ((Element)v.get(470)).appendChild((Element)v.get(471));

      /* Empieza nodo:472 / Elemento padre: 471   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(472)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(472)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(472)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(472)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(471)).appendChild((Element)v.get(472));
      /* Termina nodo:472   */

      /* Empieza nodo:473 / Elemento padre: 471   */
      v.add(doc.createElement("BTNMINIMIZAR"));
   }

   private void getXML2160(Document doc) {
      ((Element)v.get(473)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(473)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(473)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
      ((Element)v.get(473)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(471)).appendChild((Element)v.get(473));
      /* Termina nodo:473   */
      /* Termina nodo:471   */

      /* Empieza nodo:474 / Elemento padre: 470   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(470)).appendChild((Element)v.get(474));

      /* Empieza nodo:475 / Elemento padre: 474   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(475)).setAttribute("borde","1" );
      ((Element)v.get(475)).setAttribute("horizDatos","1" );
      ((Element)v.get(475)).setAttribute("horizCabecera","1" );
      ((Element)v.get(475)).setAttribute("vertical","1" );
      ((Element)v.get(475)).setAttribute("horizTitulo","1" );
      ((Element)v.get(475)).setAttribute("horizBase","1" );
      ((Element)v.get(474)).appendChild((Element)v.get(475));
      /* Termina nodo:475   */

      /* Empieza nodo:476 / Elemento padre: 474   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(476)).setAttribute("borde","#999999" );
      ((Element)v.get(476)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(476)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(476)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(476)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(476)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(476)).setAttribute("horizBase","#999999" );
      ((Element)v.get(474)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */
      /* Termina nodo:474   */

      /* Empieza nodo:477 / Elemento padre: 470   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(477)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(477)).setAttribute("alto","22" );
      ((Element)v.get(477)).setAttribute("imgFondo","" );
      ((Element)v.get(477)).setAttribute("cod","00135" );
      ((Element)v.get(477)).setAttribute("ID","datosTitle" );
      ((Element)v.get(470)).appendChild((Element)v.get(477));
      /* Termina nodo:477   */

      /* Empieza nodo:478 / Elemento padre: 470   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(478)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(478)).setAttribute("alto","22" );
      ((Element)v.get(478)).setAttribute("imgFondo","" );
      ((Element)v.get(470)).appendChild((Element)v.get(478));
      /* Termina nodo:478   */

      /* Empieza nodo:479 / Elemento padre: 470   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(479)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(479)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(479)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(479)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(479)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(470)).appendChild((Element)v.get(479));

      /* Empieza nodo:480 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(480)).setAttribute("ancho","100" );
      ((Element)v.get(480)).setAttribute("minimizable","S" );
      ((Element)v.get(480)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(480));
      /* Termina nodo:480   */

      /* Empieza nodo:481 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(481)).setAttribute("ancho","100" );
      ((Element)v.get(481)).setAttribute("minimizable","S" );
      ((Element)v.get(481)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(481));
      /* Termina nodo:481   */

      /* Empieza nodo:482 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(482)).setAttribute("ancho","100" );
      ((Element)v.get(482)).setAttribute("minimizable","S" );
      ((Element)v.get(482)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(482));
      /* Termina nodo:482   */

      /* Empieza nodo:483 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(483)).setAttribute("ancho","100" );
      ((Element)v.get(483)).setAttribute("minimizable","S" );
      ((Element)v.get(483)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(483));
      /* Termina nodo:483   */

      /* Empieza nodo:484 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(484)).setAttribute("ancho","100" );
      ((Element)v.get(484)).setAttribute("minimizable","S" );
      ((Element)v.get(484)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(484));
      /* Termina nodo:484   */

      /* Empieza nodo:485 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(485)).setAttribute("ancho","100" );
      ((Element)v.get(485)).setAttribute("minimizable","S" );
      ((Element)v.get(485)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(485));
      /* Termina nodo:485   */

      /* Empieza nodo:486 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(486)).setAttribute("ancho","100" );
      ((Element)v.get(486)).setAttribute("minimizable","S" );
      ((Element)v.get(486)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(486));
      /* Termina nodo:486   */

      /* Empieza nodo:487 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(487)).setAttribute("ancho","100" );
      ((Element)v.get(487)).setAttribute("minimizable","S" );
      ((Element)v.get(487)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(487));
      /* Termina nodo:487   */

      /* Empieza nodo:488 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(488)).setAttribute("ancho","100" );
      ((Element)v.get(488)).setAttribute("minimizable","S" );
      ((Element)v.get(488)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(488));
      /* Termina nodo:488   */

      /* Empieza nodo:489 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(489)).setAttribute("ancho","100" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(489)).setAttribute("minimizable","S" );
      ((Element)v.get(489)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(489));
      /* Termina nodo:489   */

      /* Empieza nodo:490 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(490)).setAttribute("ancho","100" );
      ((Element)v.get(490)).setAttribute("minimizable","S" );
      ((Element)v.get(490)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(490));
      /* Termina nodo:490   */

      /* Empieza nodo:491 / Elemento padre: 479   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(491)).setAttribute("ancho","100" );
      ((Element)v.get(491)).setAttribute("minimizable","S" );
      ((Element)v.get(491)).setAttribute("minimizada","N" );
      ((Element)v.get(479)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */
      /* Termina nodo:479   */

      /* Empieza nodo:492 / Elemento padre: 470   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(492)).setAttribute("height","20" );
      ((Element)v.get(492)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(492)).setAttribute("imgFondo","" );
      ((Element)v.get(492)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(470)).appendChild((Element)v.get(492));

      /* Empieza nodo:493 / Elemento padre: 492   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(493)).setAttribute("colFondo","" );
      ((Element)v.get(493)).setAttribute("ID","EstCab" );
      ((Element)v.get(493)).setAttribute("cod","PedTipoSolic.codTipoSoli.label" );
      ((Element)v.get(492)).appendChild((Element)v.get(493));
      /* Termina nodo:493   */

      /* Empieza nodo:494 / Elemento padre: 492   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(494)).setAttribute("colFondo","" );
      ((Element)v.get(494)).setAttribute("ID","EstCab" );
      ((Element)v.get(494)).setAttribute("cod","PedTipoSolic.ticlOidTipoClie.label" );
      ((Element)v.get(492)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */

      /* Empieza nodo:495 / Elemento padre: 492   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(495)).setAttribute("colFondo","" );
      ((Element)v.get(495)).setAttribute("ID","EstCab" );
      ((Element)v.get(495)).setAttribute("cod","PedTipoSolic.marcOidMarc.label" );
      ((Element)v.get(492)).appendChild((Element)v.get(495));
      /* Termina nodo:495   */

      /* Empieza nodo:496 / Elemento padre: 492   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(496)).setAttribute("colFondo","" );
      ((Element)v.get(496)).setAttribute("ID","EstCab" );
      ((Element)v.get(496)).setAttribute("cod","PedTipoSolic.acceOidAcce.label" );
      ((Element)v.get(492)).appendChild((Element)v.get(496));
      /* Termina nodo:496   */

      /* Empieza nodo:497 / Elemento padre: 492   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(497)).setAttribute("colFondo","" );
      ((Element)v.get(497)).setAttribute("ID","EstCab" );
      ((Element)v.get(497)).setAttribute("cod","PedTipoSolic.clsoOidClasSoli.label" );
      ((Element)v.get(492)).appendChild((Element)v.get(497));
      /* Termina nodo:497   */

      /* Empieza nodo:498 / Elemento padre: 492   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(498)).setAttribute("colFondo","" );
      ((Element)v.get(498)).setAttribute("ID","EstCab" );
      ((Element)v.get(498)).setAttribute("cod","PedTipoSolic.indCons.label" );
      ((Element)v.get(492)).appendChild((Element)v.get(498));
      /* Termina nodo:498   */

      /* Empieza nodo:499 / Elemento padre: 492   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(499)).setAttribute("colFondo","" );
      ((Element)v.get(499)).setAttribute("ID","EstCab" );
      ((Element)v.get(499)).setAttribute("cod","PedTipoSolic.indSoliNega.label" );
      ((Element)v.get(492)).appendChild((Element)v.get(499));
      /* Termina nodo:499   */

      /* Empieza nodo:500 / Elemento padre: 492   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(500)).setAttribute("colFondo","" );
      ((Element)v.get(500)).setAttribute("ID","EstCab" );
      ((Element)v.get(500)).setAttribute("cod","PedTipoSolic.grsoOidGrupSoli.label" );
      ((Element)v.get(492)).appendChild((Element)v.get(500));
      /* Termina nodo:500   */

      /* Empieza nodo:501 / Elemento padre: 492   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(501)).setAttribute("colFondo","" );
      ((Element)v.get(501)).setAttribute("ID","EstCab" );
      ((Element)v.get(501)).setAttribute("cod","PedTipoSolic.indDevo.label" );
      ((Element)v.get(492)).appendChild((Element)v.get(501));
      /* Termina nodo:501   */

      /* Empieza nodo:502 / Elemento padre: 492   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(502)).setAttribute("colFondo","" );
      ((Element)v.get(502)).setAttribute("ID","EstCab" );
      ((Element)v.get(502)).setAttribute("cod","PedTipoSolic.indAnul.label" );
      ((Element)v.get(492)).appendChild((Element)v.get(502));
      /* Termina nodo:502   */

      /* Empieza nodo:503 / Elemento padre: 492   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(503)).setAttribute("colFondo","" );
      ((Element)v.get(503)).setAttribute("ID","EstCab" );
      ((Element)v.get(503)).setAttribute("cod","PedTipoSolic.sbacOidSbac.label" );
      ((Element)v.get(492)).appendChild((Element)v.get(503));
      /* Termina nodo:503   */

      /* Empieza nodo:504 / Elemento padre: 492   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(504)).setAttribute("colFondo","" );
      ((Element)v.get(504)).setAttribute("ID","EstCab" );
      ((Element)v.get(504)).setAttribute("cod","PedTipoSolic.codGrupSoli.label" );
      ((Element)v.get(492)).appendChild((Element)v.get(504));
      /* Termina nodo:504   */
      /* Termina nodo:492   */

      /* Empieza nodo:505 / Elemento padre: 470   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(505)).setAttribute("alto","22" );
      ((Element)v.get(505)).setAttribute("accion","" );
      ((Element)v.get(505)).setAttribute("tipoEnvio","seleccion" );
      ((Element)v.get(505)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(505)).setAttribute("maxSel","1" );
      ((Element)v.get(505)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(505)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(505)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(505)).setAttribute("onLoad","" );
      ((Element)v.get(505)).setAttribute("colorSelecc","#D0D9E8" );
   }

   private void getXML2340(Document doc) {
      ((Element)v.get(470)).appendChild((Element)v.get(505));

      /* Empieza nodo:506 / Elemento padre: 505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(506)).setAttribute("tipo","texto" );
      ((Element)v.get(506)).setAttribute("ID","EstDat" );
      ((Element)v.get(505)).appendChild((Element)v.get(506));
      /* Termina nodo:506   */

      /* Empieza nodo:507 / Elemento padre: 505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(507)).setAttribute("tipo","texto" );
      ((Element)v.get(507)).setAttribute("ID","EstDat2" );
      ((Element)v.get(505)).appendChild((Element)v.get(507));
      /* Termina nodo:507   */

      /* Empieza nodo:508 / Elemento padre: 505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(508)).setAttribute("tipo","texto" );
      ((Element)v.get(508)).setAttribute("ID","EstDat" );
      ((Element)v.get(505)).appendChild((Element)v.get(508));
      /* Termina nodo:508   */

      /* Empieza nodo:509 / Elemento padre: 505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(509)).setAttribute("tipo","texto" );
      ((Element)v.get(509)).setAttribute("ID","EstDat2" );
      ((Element)v.get(505)).appendChild((Element)v.get(509));
      /* Termina nodo:509   */

      /* Empieza nodo:510 / Elemento padre: 505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(510)).setAttribute("tipo","texto" );
      ((Element)v.get(510)).setAttribute("ID","EstDat" );
      ((Element)v.get(505)).appendChild((Element)v.get(510));
      /* Termina nodo:510   */

      /* Empieza nodo:511 / Elemento padre: 505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(511)).setAttribute("tipo","texto" );
      ((Element)v.get(511)).setAttribute("ID","EstDat2" );
      ((Element)v.get(505)).appendChild((Element)v.get(511));
      /* Termina nodo:511   */

      /* Empieza nodo:512 / Elemento padre: 505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(512)).setAttribute("tipo","texto" );
      ((Element)v.get(512)).setAttribute("ID","EstDat" );
      ((Element)v.get(505)).appendChild((Element)v.get(512));
      /* Termina nodo:512   */

      /* Empieza nodo:513 / Elemento padre: 505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(513)).setAttribute("tipo","texto" );
      ((Element)v.get(513)).setAttribute("ID","EstDat2" );
      ((Element)v.get(505)).appendChild((Element)v.get(513));
      /* Termina nodo:513   */

      /* Empieza nodo:514 / Elemento padre: 505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(514)).setAttribute("tipo","texto" );
      ((Element)v.get(514)).setAttribute("ID","EstDat" );
      ((Element)v.get(505)).appendChild((Element)v.get(514));
      /* Termina nodo:514   */

      /* Empieza nodo:515 / Elemento padre: 505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(515)).setAttribute("tipo","texto" );
      ((Element)v.get(515)).setAttribute("ID","EstDat2" );
      ((Element)v.get(505)).appendChild((Element)v.get(515));
      /* Termina nodo:515   */

      /* Empieza nodo:516 / Elemento padre: 505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(516)).setAttribute("tipo","texto" );
      ((Element)v.get(516)).setAttribute("ID","EstDat" );
      ((Element)v.get(505)).appendChild((Element)v.get(516));
      /* Termina nodo:516   */

      /* Empieza nodo:517 / Elemento padre: 505   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(517)).setAttribute("tipo","texto" );
      ((Element)v.get(517)).setAttribute("ID","EstDat2" );
      ((Element)v.get(505)).appendChild((Element)v.get(517));
      /* Termina nodo:517   */
      /* Termina nodo:505   */

      /* Empieza nodo:518 / Elemento padre: 470   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(470)).appendChild((Element)v.get(518));
      /* Termina nodo:518   */
      /* Termina nodo:470   */
      /* Termina nodo:469   */

      /* Empieza nodo:519 / Elemento padre: 5   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(519)).setAttribute("nombre","pedTipoSolicListButtonsLayer" );
      ((Element)v.get(519)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(519)).setAttribute("alto","30" );
      ((Element)v.get(519)).setAttribute("ancho","98%" );
      ((Element)v.get(519)).setAttribute("borde","n" );
      ((Element)v.get(519)).setAttribute("imagenf","" );
      ((Element)v.get(519)).setAttribute("repeat","" );
      ((Element)v.get(519)).setAttribute("padding","0" );
      ((Element)v.get(519)).setAttribute("contravsb","" );
      ((Element)v.get(519)).setAttribute("x","16" );
      ((Element)v.get(519)).setAttribute("y","" );
      ((Element)v.get(519)).setAttribute("zindex","" );
      ((Element)v.get(5)).appendChild((Element)v.get(519));

      /* Empieza nodo:520 / Elemento padre: 519   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(520)).setAttribute("nombre","toolbarSeparatorLayer" );
      ((Element)v.get(520)).setAttribute("visibilidad","inherit" );
      ((Element)v.get(520)).setAttribute("alto","23" );
      ((Element)v.get(520)).setAttribute("ancho","1" );
      ((Element)v.get(520)).setAttribute("borde","1" );
      ((Element)v.get(520)).setAttribute("imagenf","" );
      ((Element)v.get(520)).setAttribute("repeat","" );
      ((Element)v.get(520)).setAttribute("padding","0" );
      ((Element)v.get(520)).setAttribute("contravsb","" );
      ((Element)v.get(520)).setAttribute("x","56" );
      ((Element)v.get(520)).setAttribute("y","0" );
      ((Element)v.get(520)).setAttribute("zindex","" );
      ((Element)v.get(520)).setAttribute("colborde","#999999" );
      ((Element)v.get(519)).appendChild((Element)v.get(520));
      /* Termina nodo:520   */

      /* Empieza nodo:521 / Elemento padre: 519   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(521)).setAttribute("width","100%" );
      ((Element)v.get(521)).setAttribute("border","0" );
      ((Element)v.get(521)).setAttribute("cellspacing","1" );
      ((Element)v.get(521)).setAttribute("cellpadding","0" );
      ((Element)v.get(519)).appendChild((Element)v.get(521));

      /* Empieza nodo:522 / Elemento padre: 521   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(521)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(523)).setAttribute("src","b.gif" );
   }

   private void getXML2430(Document doc) {
      ((Element)v.get(523)).setAttribute("height","22" );
      ((Element)v.get(523)).setAttribute("width","5" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */
      /* Termina nodo:522   */

      /* Empieza nodo:524 / Elemento padre: 521   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(521)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("BOTONERA"));
      ((Element)v.get(525)).setAttribute("nombre","pedTipoSolicPaginationButtonBar" );
      ((Element)v.get(525)).setAttribute("tipo","H" );
      ((Element)v.get(525)).setAttribute("x","0" );
      ((Element)v.get(525)).setAttribute("y","0" );
      ((Element)v.get(524)).appendChild((Element)v.get(525));

      /* Empieza nodo:526 / Elemento padre: 525   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(526)).setAttribute("nombre","pedTipoSolicFirstPageButton" );
      ((Element)v.get(526)).setAttribute("funcion","pedTipoSolicFirstPage();" );
      ((Element)v.get(526)).setAttribute("off","primera_over0.gif" );
      ((Element)v.get(526)).setAttribute("on","primera_over0.gif" );
      ((Element)v.get(526)).setAttribute("disable","primera_on0.gif" );
      ((Element)v.get(526)).setAttribute("estado","inactivo" );
      ((Element)v.get(525)).appendChild((Element)v.get(526));
      /* Termina nodo:526   */

      /* Empieza nodo:527 / Elemento padre: 525   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(527)).setAttribute("nombre","pedTipoSolicFirstPageButtonGapTd" );
      ((Element)v.get(525)).appendChild((Element)v.get(527));

      /* Empieza nodo:528 / Elemento padre: 527   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(528)).setAttribute("src","b.gif" );
      ((Element)v.get(528)).setAttribute("height","8" );
      ((Element)v.get(528)).setAttribute("width","5" );
      ((Element)v.get(527)).appendChild((Element)v.get(528));
      /* Termina nodo:528   */
      /* Termina nodo:527   */

      /* Empieza nodo:529 / Elemento padre: 525   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(529)).setAttribute("nombre","pedTipoSolicPreviousPageButton" );
      ((Element)v.get(529)).setAttribute("funcion","pedTipoSolicPreviousPage();" );
      ((Element)v.get(529)).setAttribute("off","retroceder_over0.gif" );
      ((Element)v.get(529)).setAttribute("on","retroceder_over0.gif" );
      ((Element)v.get(529)).setAttribute("disable","retroceder_on0.gif" );
      ((Element)v.get(529)).setAttribute("estado","inactivo" );
      ((Element)v.get(525)).appendChild((Element)v.get(529));
      /* Termina nodo:529   */

      /* Empieza nodo:530 / Elemento padre: 525   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(530)).setAttribute("nombre","pedTipoSolicPreviousPageButtonGapTd" );
      ((Element)v.get(525)).appendChild((Element)v.get(530));

      /* Empieza nodo:531 / Elemento padre: 530   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(531)).setAttribute("src","b.gif" );
      ((Element)v.get(531)).setAttribute("height","8" );
      ((Element)v.get(531)).setAttribute("width","8" );
      ((Element)v.get(530)).appendChild((Element)v.get(531));
      /* Termina nodo:531   */
      /* Termina nodo:530   */

      /* Empieza nodo:532 / Elemento padre: 525   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(532)).setAttribute("nombre","pedTipoSolicNextPageButton" );
      ((Element)v.get(532)).setAttribute("funcion","pedTipoSolicNextPage();" );
      ((Element)v.get(532)).setAttribute("off","avanzar_over0.gif" );
      ((Element)v.get(532)).setAttribute("on","avanzar_over0.gif" );
      ((Element)v.get(532)).setAttribute("disable","avanzar_on0.gif" );
      ((Element)v.get(532)).setAttribute("estado","inactivo" );
      ((Element)v.get(525)).appendChild((Element)v.get(532));
      /* Termina nodo:532   */
      /* Termina nodo:525   */
      /* Termina nodo:524   */

      /* Empieza nodo:533 / Elemento padre: 521   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(521)).appendChild((Element)v.get(533));

      /* Empieza nodo:534 / Elemento padre: 533   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(534)).setAttribute("src","b.gif" );
      ((Element)v.get(534)).setAttribute("height","22" );
      ((Element)v.get(534)).setAttribute("width","19" );
      ((Element)v.get(533)).appendChild((Element)v.get(534));
      /* Termina nodo:534   */
      /* Termina nodo:533   */

      /* Empieza nodo:535 / Elemento padre: 521   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(535)).setAttribute("class","tablaTitle" );
      ((Element)v.get(535)).setAttribute("nombre","pedTipoSolicUpdateButtonTd" );
      ((Element)v.get(521)).appendChild((Element)v.get(535));

      /* Empieza nodo:536 / Elemento padre: 535   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(536)).setAttribute("nombre","pedTipoSolicUpdateButton" );
      ((Element)v.get(536)).setAttribute("ID","botonContenido" );
      ((Element)v.get(536)).setAttribute("tipo","html" );
      ((Element)v.get(536)).setAttribute("accion","pedTipoSolicUpdateSelection();" );
      ((Element)v.get(536)).setAttribute("estado","false" );
      ((Element)v.get(536)).setAttribute("cod","MMGGlobal.updateButton.label" );
      ((Element)v.get(535)).appendChild((Element)v.get(536));
      /* Termina nodo:536   */
      /* Termina nodo:535   */

      /* Empieza nodo:537 / Elemento padre: 521   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(537)).setAttribute("nombre","pedTipoSolicUpdateButtonGapTd" );
      ((Element)v.get(521)).appendChild((Element)v.get(537));

      /* Empieza nodo:538 / Elemento padre: 537   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(538)).setAttribute("src","b.gif" );
      ((Element)v.get(538)).setAttribute("height","8" );
      ((Element)v.get(538)).setAttribute("width","10" );
      ((Element)v.get(537)).appendChild((Element)v.get(538));
      /* Termina nodo:538   */
      /* Termina nodo:537   */

      /* Empieza nodo:539 / Elemento padre: 521   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(539)).setAttribute("class","tablaTitle" );
      ((Element)v.get(539)).setAttribute("nombre","pedTipoSolicViewForRemoveButtonTd" );
      ((Element)v.get(521)).appendChild((Element)v.get(539));

      /* Empieza nodo:540 / Elemento padre: 539   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(540)).setAttribute("nombre","pedTipoSolicViewForRemoveButton" );
      ((Element)v.get(540)).setAttribute("ID","botonContenido" );
      ((Element)v.get(540)).setAttribute("tipo","html" );
      ((Element)v.get(540)).setAttribute("accion","pedTipoSolicViewSelection();" );
      ((Element)v.get(540)).setAttribute("estado","false" );
      ((Element)v.get(540)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(539)).appendChild((Element)v.get(540));
      /* Termina nodo:540   */
      /* Termina nodo:539   */

      /* Empieza nodo:541 / Elemento padre: 521   */
   }

   private void getXML2520(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(541)).setAttribute("nombre","pedTipoSolicViewForRemoveButtonGapTd" );
      ((Element)v.get(521)).appendChild((Element)v.get(541));

      /* Empieza nodo:542 / Elemento padre: 541   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(542)).setAttribute("src","b.gif" );
      ((Element)v.get(542)).setAttribute("height","8" );
      ((Element)v.get(542)).setAttribute("width","10" );
      ((Element)v.get(541)).appendChild((Element)v.get(542));
      /* Termina nodo:542   */
      /* Termina nodo:541   */

      /* Empieza nodo:543 / Elemento padre: 521   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(543)).setAttribute("class","tablaTitle" );
      ((Element)v.get(543)).setAttribute("nombre","pedTipoSolicLovSelectButtonTd" );
      ((Element)v.get(521)).appendChild((Element)v.get(543));

      /* Empieza nodo:544 / Elemento padre: 543   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(544)).setAttribute("nombre","pedTipoSolicLovSelectButton" );
      ((Element)v.get(544)).setAttribute("ID","botonContenido" );
      ((Element)v.get(544)).setAttribute("tipo","html" );
      ((Element)v.get(544)).setAttribute("accion","pedTipoSolicLovSelectionAction();" );
      ((Element)v.get(544)).setAttribute("estado","true" );
      ((Element)v.get(544)).setAttribute("cod","MMGGlobal.lovSelectButton.label" );
      ((Element)v.get(543)).appendChild((Element)v.get(544));
      /* Termina nodo:544   */
      /* Termina nodo:543   */

      /* Empieza nodo:545 / Elemento padre: 521   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(545)).setAttribute("nombre","pedTipoSolicLovSelectButtonGapTd" );
      ((Element)v.get(521)).appendChild((Element)v.get(545));

      /* Empieza nodo:546 / Elemento padre: 545   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(546)).setAttribute("src","b.gif" );
      ((Element)v.get(546)).setAttribute("height","8" );
      ((Element)v.get(546)).setAttribute("width","10" );
      ((Element)v.get(545)).appendChild((Element)v.get(546));
      /* Termina nodo:546   */
      /* Termina nodo:545   */

      /* Empieza nodo:547 / Elemento padre: 521   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(547)).setAttribute("class","tablaTitle" );
      ((Element)v.get(547)).setAttribute("nombre","pedTipoSolicViewButtonTd" );
      ((Element)v.get(521)).appendChild((Element)v.get(547));

      /* Empieza nodo:548 / Elemento padre: 547   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(548)).setAttribute("nombre","pedTipoSolicViewButton" );
      ((Element)v.get(548)).setAttribute("ID","botonContenido" );
      ((Element)v.get(548)).setAttribute("tipo","html" );
      ((Element)v.get(548)).setAttribute("accion","pedTipoSolicViewSelection();" );
      ((Element)v.get(548)).setAttribute("estado","false" );
      ((Element)v.get(548)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(547)).appendChild((Element)v.get(548));
      /* Termina nodo:548   */
      /* Termina nodo:547   */

      /* Empieza nodo:549 / Elemento padre: 521   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(549)).setAttribute("nombre","pedTipoSolicViewButtonGapTd" );
      ((Element)v.get(521)).appendChild((Element)v.get(549));

      /* Empieza nodo:550 / Elemento padre: 549   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(550)).setAttribute("src","b.gif" );
      ((Element)v.get(550)).setAttribute("height","8" );
      ((Element)v.get(550)).setAttribute("width","10" );
      ((Element)v.get(549)).appendChild((Element)v.get(550));
      /* Termina nodo:550   */
      /* Termina nodo:549   */

      /* Empieza nodo:551 / Elemento padre: 521   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(551)).setAttribute("width","100%" );
      ((Element)v.get(521)).appendChild((Element)v.get(551));
      /* Termina nodo:551   */
      /* Termina nodo:521   */
      /* Termina nodo:519   */
      /* Termina nodo:5   */


   }

}

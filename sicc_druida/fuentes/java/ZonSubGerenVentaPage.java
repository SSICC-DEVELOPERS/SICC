
import org.w3c.dom.*;
import java.util.ArrayList;

public class ZonSubGerenVentaPage  implements es.indra.druida.base.ObjetoXML {
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
         
      return (Element)v.get(0);
      
   }

   
/* Primer nodo */
   

   private void getXML0(Document doc) {
      v.add(doc.createElement("PAGINA"));
      ((Element)v.get(0)).setAttribute("nombre","ZonSubGerenVentaPage" );
      ((Element)v.get(0)).setAttribute("titulo","" );
      ((Element)v.get(0)).setAttribute("estilos","estilosB3.css" );
      ((Element)v.get(0)).setAttribute("colorf","#F0F0F0" );
      ((Element)v.get(0)).setAttribute("msgle","" );
      ((Element)v.get(0)).setAttribute("onload","zonSubGerenVentaInitComponents()" );
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
      ((Element)v.get(3)).setAttribute("src","zonsubgerenventa.js" );
      ((Element)v.get(0)).appendChild((Element)v.get(3));
      /* Termina nodo:3   */

      /* Empieza nodo:4 / Elemento padre: 0   */
      v.add(doc.createElement("FORMULARIO"));
      ((Element)v.get(4)).setAttribute("nombre","zonSubGerenVentaFrm" );
      ((Element)v.get(4)).setAttribute("oculto","N" );
      ((Element)v.get(0)).appendChild((Element)v.get(4));

      /* Empieza nodo:5 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(5)).setAttribute("nombre","conectorAction" );
      ((Element)v.get(5)).setAttribute("valor","ZonSubGerenVentaLPExecution" );
      ((Element)v.get(4)).appendChild((Element)v.get(5));
      /* Termina nodo:5   */

      /* Empieza nodo:6 / Elemento padre: 4   */
      v.add(doc.createElement("VAR"));
      ((Element)v.get(6)).setAttribute("nombre","ON" );
      ((Element)v.get(6)).setAttribute("valor","ZonSubGerenVentaLPExecution" );
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
      ((Element)v.get(36)).setAttribute("nombre","zonSubGerenVentaFormLayer" );
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
      ((Element)v.get(51)).setAttribute("cod","ZonSubGerenVenta.legend.label" );
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
      ((Element)v.get(62)).setAttribute("nombre","paisOidPais_moneOidMoneTdId" );
      ((Element)v.get(61)).appendChild((Element)v.get(62));

      /* Empieza nodo:63 / Elemento padre: 62   */
      v.add(doc.createElement("TABLE"));
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
      ((Element)v.get(66)).setAttribute("nombre","lblpaisOidPais_moneOidMone" );
      ((Element)v.get(66)).setAttribute("id","datosTitle" );
      ((Element)v.get(66)).setAttribute("ancho","100" );
      ((Element)v.get(66)).setAttribute("alto","13" );
      ((Element)v.get(66)).setAttribute("cod","SegPais.moneOidMone.label" );
      ((Element)v.get(65)).appendChild((Element)v.get(66));
      /* Termina nodo:66   */
      /* Termina nodo:65   */
      /* Termina nodo:64   */

      /* Empieza nodo:67 / Elemento padre: 63   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(67)).setAttribute("nombre","paisOidPais_moneOidMoneWidgetTrId" );
      ((Element)v.get(63)).appendChild((Element)v.get(67));

      /* Empieza nodo:68 / Elemento padre: 67   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(68)).setAttribute("align","left" );
      ((Element)v.get(68)).setAttribute("nowrap","true" );
      ((Element)v.get(67)).appendChild((Element)v.get(68));

      /* Empieza nodo:69 / Elemento padre: 68   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(69)).setAttribute("nombre","paisOidPais_moneOidMone" );
      ((Element)v.get(69)).setAttribute("id","datosCampos" );
      ((Element)v.get(69)).setAttribute("multiple","N" );
      ((Element)v.get(69)).setAttribute("req","N" );
      ((Element)v.get(69)).setAttribute("size","1" );
      ((Element)v.get(69)).setAttribute("disabled","" );
      ((Element)v.get(69)).setAttribute("validacion","" );
      ((Element)v.get(69)).setAttribute("onchange","mmgDependeneChange('paisOidPais_moneOidMone', 'paisOidPais' , 'zonSubGerenVenta')" );
      ((Element)v.get(69)).setAttribute("onfocus","" );
      ((Element)v.get(69)).setAttribute("valorinicial","" );
      ((Element)v.get(69)).setAttribute("textoinicial","" );
      ((Element)v.get(69)).setAttribute("ontab","focaliza('zonSubGerenVentaFrm.paisOidPais_fopaOidFormPago');" );
      ((Element)v.get(69)).setAttribute("onshtab","ejecutarAccionFoco('zonSubGerenVentaFrm',0, false);" );
      ((Element)v.get(68)).appendChild((Element)v.get(69));

      /* Empieza nodo:70 / Elemento padre: 69   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(69)).appendChild((Element)v.get(70));
      /* Termina nodo:70   */
      /* Termina nodo:69   */
      /* Termina nodo:68   */
      /* Termina nodo:67   */
      /* Termina nodo:63   */
      /* Termina nodo:62   */

      /* Empieza nodo:71 / Elemento padre: 61   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(71)).setAttribute("nombre","paisOidPais_moneOidMoneGapTdId" );
      ((Element)v.get(71)).setAttribute("nowrap","true" );
      ((Element)v.get(71)).setAttribute("class","datosCampos" );
      ((Element)v.get(61)).appendChild((Element)v.get(71));

      /* Empieza nodo:72 / Elemento padre: 71   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(72)).setAttribute("src","b.gif" );
      ((Element)v.get(72)).setAttribute("width","25" );
      ((Element)v.get(72)).setAttribute("height","8" );
      ((Element)v.get(71)).appendChild((Element)v.get(72));
      /* Termina nodo:72   */
      /* Termina nodo:71   */

      /* Empieza nodo:73 / Elemento padre: 61   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(73)).setAttribute("nombre","paisOidPais_fopaOidFormPagoTdId" );
      ((Element)v.get(61)).appendChild((Element)v.get(73));

      /* Empieza nodo:74 / Elemento padre: 73   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(74)).setAttribute("border","0" );
      ((Element)v.get(74)).setAttribute("cellspacing","0" );
      ((Element)v.get(74)).setAttribute("cellpadding","0" );
      ((Element)v.get(74)).setAttribute("align","left" );
      ((Element)v.get(73)).appendChild((Element)v.get(74));

      /* Empieza nodo:75 / Elemento padre: 74   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(74)).appendChild((Element)v.get(75));

      /* Empieza nodo:76 / Elemento padre: 75   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(76)).setAttribute("valign","top" );
      ((Element)v.get(76)).setAttribute("height","13" );
      ((Element)v.get(75)).appendChild((Element)v.get(76));

      /* Empieza nodo:77 / Elemento padre: 76   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(77)).setAttribute("nombre","lblpaisOidPais_fopaOidFormPago" );
      ((Element)v.get(77)).setAttribute("id","datosTitle" );
      ((Element)v.get(77)).setAttribute("ancho","100" );
      ((Element)v.get(77)).setAttribute("alto","13" );
      ((Element)v.get(77)).setAttribute("cod","SegPais.fopaOidFormPago.label" );
      ((Element)v.get(76)).appendChild((Element)v.get(77));
      /* Termina nodo:77   */
      /* Termina nodo:76   */
      /* Termina nodo:75   */

      /* Empieza nodo:78 / Elemento padre: 74   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(78)).setAttribute("nombre","paisOidPais_fopaOidFormPagoWidgetTrId" );
      ((Element)v.get(74)).appendChild((Element)v.get(78));

      /* Empieza nodo:79 / Elemento padre: 78   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(79)).setAttribute("align","left" );
      ((Element)v.get(79)).setAttribute("nowrap","true" );
      ((Element)v.get(78)).appendChild((Element)v.get(79));

      /* Empieza nodo:80 / Elemento padre: 79   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(80)).setAttribute("nombre","paisOidPais_fopaOidFormPago" );
      ((Element)v.get(80)).setAttribute("id","datosCampos" );
      ((Element)v.get(80)).setAttribute("multiple","N" );
      ((Element)v.get(80)).setAttribute("req","N" );
   }

   private void getXML360(Document doc) {
      ((Element)v.get(80)).setAttribute("size","1" );
      ((Element)v.get(80)).setAttribute("disabled","" );
      ((Element)v.get(80)).setAttribute("validacion","" );
      ((Element)v.get(80)).setAttribute("onchange","mmgDependeneChange('paisOidPais_fopaOidFormPago', 'paisOidPais' , 'zonSubGerenVenta')" );
      ((Element)v.get(80)).setAttribute("onfocus","" );
      ((Element)v.get(80)).setAttribute("valorinicial","" );
      ((Element)v.get(80)).setAttribute("textoinicial","" );
      ((Element)v.get(80)).setAttribute("ontab","focaliza('zonSubGerenVentaFrm.paisOidPais_moneOidMoneAlt');" );
      ((Element)v.get(80)).setAttribute("onshtab","ejecutarAccionFoco('zonSubGerenVentaFrm',0, false);" );
      ((Element)v.get(79)).appendChild((Element)v.get(80));

      /* Empieza nodo:81 / Elemento padre: 80   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(80)).appendChild((Element)v.get(81));
      /* Termina nodo:81   */
      /* Termina nodo:80   */
      /* Termina nodo:79   */
      /* Termina nodo:78   */
      /* Termina nodo:74   */
      /* Termina nodo:73   */

      /* Empieza nodo:82 / Elemento padre: 61   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(82)).setAttribute("nombre","paisOidPais_fopaOidFormPagoGapTdId" );
      ((Element)v.get(82)).setAttribute("nowrap","true" );
      ((Element)v.get(82)).setAttribute("class","datosCampos" );
      ((Element)v.get(61)).appendChild((Element)v.get(82));

      /* Empieza nodo:83 / Elemento padre: 82   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(83)).setAttribute("src","b.gif" );
      ((Element)v.get(83)).setAttribute("width","25" );
      ((Element)v.get(83)).setAttribute("height","8" );
      ((Element)v.get(82)).appendChild((Element)v.get(83));
      /* Termina nodo:83   */
      /* Termina nodo:82   */

      /* Empieza nodo:84 / Elemento padre: 61   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(84)).setAttribute("nombre","paisOidPais_moneOidMoneAltTdId" );
      ((Element)v.get(61)).appendChild((Element)v.get(84));

      /* Empieza nodo:85 / Elemento padre: 84   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(85)).setAttribute("border","0" );
      ((Element)v.get(85)).setAttribute("cellspacing","0" );
      ((Element)v.get(85)).setAttribute("cellpadding","0" );
      ((Element)v.get(85)).setAttribute("align","left" );
      ((Element)v.get(84)).appendChild((Element)v.get(85));

      /* Empieza nodo:86 / Elemento padre: 85   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(85)).appendChild((Element)v.get(86));

      /* Empieza nodo:87 / Elemento padre: 86   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(87)).setAttribute("valign","top" );
      ((Element)v.get(87)).setAttribute("height","13" );
      ((Element)v.get(86)).appendChild((Element)v.get(87));

      /* Empieza nodo:88 / Elemento padre: 87   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(88)).setAttribute("nombre","lblpaisOidPais_moneOidMoneAlt" );
      ((Element)v.get(88)).setAttribute("id","datosTitle" );
      ((Element)v.get(88)).setAttribute("ancho","100" );
      ((Element)v.get(88)).setAttribute("alto","13" );
      ((Element)v.get(88)).setAttribute("cod","SegPais.moneOidMoneAlt.label" );
      ((Element)v.get(87)).appendChild((Element)v.get(88));
      /* Termina nodo:88   */
      /* Termina nodo:87   */
      /* Termina nodo:86   */

      /* Empieza nodo:89 / Elemento padre: 85   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(89)).setAttribute("nombre","paisOidPais_moneOidMoneAltWidgetTrId" );
      ((Element)v.get(85)).appendChild((Element)v.get(89));

      /* Empieza nodo:90 / Elemento padre: 89   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(90)).setAttribute("align","left" );
      ((Element)v.get(90)).setAttribute("nowrap","true" );
      ((Element)v.get(89)).appendChild((Element)v.get(90));

      /* Empieza nodo:91 / Elemento padre: 90   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(91)).setAttribute("nombre","paisOidPais_moneOidMoneAlt" );
      ((Element)v.get(91)).setAttribute("id","datosCampos" );
      ((Element)v.get(91)).setAttribute("multiple","N" );
      ((Element)v.get(91)).setAttribute("req","N" );
      ((Element)v.get(91)).setAttribute("size","1" );
      ((Element)v.get(91)).setAttribute("disabled","" );
      ((Element)v.get(91)).setAttribute("validacion","" );
      ((Element)v.get(91)).setAttribute("onchange","mmgDependeneChange('paisOidPais_moneOidMoneAlt', 'paisOidPais' , 'zonSubGerenVenta')" );
      ((Element)v.get(91)).setAttribute("onfocus","" );
      ((Element)v.get(91)).setAttribute("valorinicial","" );
      ((Element)v.get(91)).setAttribute("textoinicial","" );
      ((Element)v.get(91)).setAttribute("ontab","focaliza('zonSubGerenVentaFrm.paisOidPais');" );
      ((Element)v.get(91)).setAttribute("onshtab","ejecutarAccionFoco('zonSubGerenVentaFrm',0, false);" );
      ((Element)v.get(90)).appendChild((Element)v.get(91));

      /* Empieza nodo:92 / Elemento padre: 91   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(91)).appendChild((Element)v.get(92));
      /* Termina nodo:92   */
      /* Termina nodo:91   */
      /* Termina nodo:90   */
      /* Termina nodo:89   */
      /* Termina nodo:85   */
      /* Termina nodo:84   */

      /* Empieza nodo:93 / Elemento padre: 61   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(93)).setAttribute("nombre","paisOidPais_moneOidMoneAltGapTdId" );
      ((Element)v.get(93)).setAttribute("nowrap","true" );
      ((Element)v.get(93)).setAttribute("class","datosCampos" );
      ((Element)v.get(61)).appendChild((Element)v.get(93));

      /* Empieza nodo:94 / Elemento padre: 93   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(94)).setAttribute("src","b.gif" );
      ((Element)v.get(94)).setAttribute("width","25" );
      ((Element)v.get(94)).setAttribute("height","8" );
      ((Element)v.get(93)).appendChild((Element)v.get(94));
      /* Termina nodo:94   */
      /* Termina nodo:93   */

      /* Empieza nodo:95 / Elemento padre: 61   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(95)).setAttribute("nombre","paisOidPaisTdId" );
      ((Element)v.get(61)).appendChild((Element)v.get(95));

      /* Empieza nodo:96 / Elemento padre: 95   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(96)).setAttribute("border","0" );
      ((Element)v.get(96)).setAttribute("cellspacing","0" );
      ((Element)v.get(96)).setAttribute("cellpadding","0" );
      ((Element)v.get(96)).setAttribute("align","left" );
      ((Element)v.get(95)).appendChild((Element)v.get(96));

      /* Empieza nodo:97 / Elemento padre: 96   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(96)).appendChild((Element)v.get(97));

      /* Empieza nodo:98 / Elemento padre: 97   */
      v.add(doc.createElement("TD"));
   }

   private void getXML450(Document doc) {
      ((Element)v.get(98)).setAttribute("valign","top" );
      ((Element)v.get(98)).setAttribute("height","13" );
      ((Element)v.get(97)).appendChild((Element)v.get(98));

      /* Empieza nodo:99 / Elemento padre: 98   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(99)).setAttribute("nombre","lblpaisOidPais" );
      ((Element)v.get(99)).setAttribute("id","datosTitle" );
      ((Element)v.get(99)).setAttribute("ancho","100" );
      ((Element)v.get(99)).setAttribute("alto","13" );
      ((Element)v.get(99)).setAttribute("cod","ZonSubGerenVenta.paisOidPais.label" );
      ((Element)v.get(98)).appendChild((Element)v.get(99));
      /* Termina nodo:99   */
      /* Termina nodo:98   */
      /* Termina nodo:97   */

      /* Empieza nodo:100 / Elemento padre: 96   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(100)).setAttribute("nombre","paisOidPaisWidgetTrId" );
      ((Element)v.get(96)).appendChild((Element)v.get(100));

      /* Empieza nodo:101 / Elemento padre: 100   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(101)).setAttribute("align","left" );
      ((Element)v.get(101)).setAttribute("nowrap","true" );
      ((Element)v.get(100)).appendChild((Element)v.get(101));

      /* Empieza nodo:102 / Elemento padre: 101   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(102)).setAttribute("nombre","paisOidPais" );
      ((Element)v.get(102)).setAttribute("id","datosCampos" );
      ((Element)v.get(102)).setAttribute("multiple","N" );
      ((Element)v.get(102)).setAttribute("req","N" );
      ((Element)v.get(102)).setAttribute("size","1" );
      ((Element)v.get(102)).setAttribute("disabled","" );
      ((Element)v.get(102)).setAttribute("validacion","" );
      ((Element)v.get(102)).setAttribute("onchange","" );
      ((Element)v.get(102)).setAttribute("onfocus","" );
      ((Element)v.get(102)).setAttribute("valorinicial","" );
      ((Element)v.get(102)).setAttribute("textoinicial","" );
      ((Element)v.get(102)).setAttribute("ontab","ejecutarAccionFoco('zonSubGerenVentaFrm',0, true);" );
      ((Element)v.get(102)).setAttribute("onshtab","focaliza('zonSubGerenVentaFrm.paisOidPais_moneOidMoneAlt');" );
      ((Element)v.get(101)).appendChild((Element)v.get(102));

      /* Empieza nodo:103 / Elemento padre: 102   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(102)).appendChild((Element)v.get(103));
      /* Termina nodo:103   */
      /* Termina nodo:102   */
      /* Termina nodo:101   */
      /* Termina nodo:100   */
      /* Termina nodo:96   */
      /* Termina nodo:95   */

      /* Empieza nodo:104 / Elemento padre: 61   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(104)).setAttribute("nombre","paisOidPaisGapTdId" );
      ((Element)v.get(104)).setAttribute("nowrap","true" );
      ((Element)v.get(104)).setAttribute("class","datosCampos" );
      ((Element)v.get(61)).appendChild((Element)v.get(104));

      /* Empieza nodo:105 / Elemento padre: 104   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(105)).setAttribute("src","b.gif" );
      ((Element)v.get(105)).setAttribute("width","25" );
      ((Element)v.get(105)).setAttribute("height","8" );
      ((Element)v.get(104)).appendChild((Element)v.get(105));
      /* Termina nodo:105   */
      /* Termina nodo:104   */

      /* Empieza nodo:106 / Elemento padre: 61   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(106)).setAttribute("width","100%" );
      ((Element)v.get(61)).appendChild((Element)v.get(106));

      /* Empieza nodo:107 / Elemento padre: 106   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(107)).setAttribute("src","b.gif" );
      ((Element)v.get(106)).appendChild((Element)v.get(107));
      /* Termina nodo:107   */
      /* Termina nodo:106   */
      /* Termina nodo:61   */
      /* Termina nodo:60   */
      /* Termina nodo:59   */
      /* Termina nodo:56   */

      /* Empieza nodo:108 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(108)).setAttribute("nombre","formGapTr0" );
      ((Element)v.get(52)).appendChild((Element)v.get(108));

      /* Empieza nodo:109 / Elemento padre: 108   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(109)).setAttribute("align","center" );
      ((Element)v.get(109)).setAttribute("width","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(109));

      /* Empieza nodo:110 / Elemento padre: 109   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(110)).setAttribute("src","b.gif" );
      ((Element)v.get(110)).setAttribute("width","12" );
      ((Element)v.get(110)).setAttribute("height","8" );
      ((Element)v.get(109)).appendChild((Element)v.get(110));
      /* Termina nodo:110   */
      /* Termina nodo:109   */

      /* Empieza nodo:111 / Elemento padre: 108   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(108)).appendChild((Element)v.get(111));

      /* Empieza nodo:112 / Elemento padre: 111   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(112)).setAttribute("src","b.gif" );
      ((Element)v.get(112)).setAttribute("width","8" );
      ((Element)v.get(112)).setAttribute("height","8" );
      ((Element)v.get(111)).appendChild((Element)v.get(112));
      /* Termina nodo:112   */
      /* Termina nodo:111   */

      /* Empieza nodo:113 / Elemento padre: 108   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(113)).setAttribute("align","center" );
      ((Element)v.get(113)).setAttribute("width","8" );
      ((Element)v.get(108)).appendChild((Element)v.get(113));

      /* Empieza nodo:114 / Elemento padre: 113   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(114)).setAttribute("src","b.gif" );
      ((Element)v.get(114)).setAttribute("width","12" );
      ((Element)v.get(114)).setAttribute("height","8" );
      ((Element)v.get(113)).appendChild((Element)v.get(114));
      /* Termina nodo:114   */
      /* Termina nodo:113   */
      /* Termina nodo:108   */

      /* Empieza nodo:115 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(115)).setAttribute("nombre","formTr1" );
      ((Element)v.get(52)).appendChild((Element)v.get(115));

      /* Empieza nodo:116 / Elemento padre: 115   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(116)).setAttribute("align","center" );
      ((Element)v.get(116)).setAttribute("width","8" );
      ((Element)v.get(115)).appendChild((Element)v.get(116));

      /* Empieza nodo:117 / Elemento padre: 116   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(117)).setAttribute("src","b.gif" );
      ((Element)v.get(117)).setAttribute("width","8" );
      ((Element)v.get(117)).setAttribute("height","12" );
      ((Element)v.get(116)).appendChild((Element)v.get(117));
      /* Termina nodo:117   */
      /* Termina nodo:116   */

      /* Empieza nodo:118 / Elemento padre: 115   */
   }

   private void getXML540(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(118)).setAttribute("width","100%" );
      ((Element)v.get(115)).appendChild((Element)v.get(118));

      /* Empieza nodo:119 / Elemento padre: 118   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(119)).setAttribute("width","100%" );
      ((Element)v.get(119)).setAttribute("border","0" );
      ((Element)v.get(119)).setAttribute("cellspacing","0" );
      ((Element)v.get(119)).setAttribute("cellpadding","0" );
      ((Element)v.get(119)).setAttribute("align","left" );
      ((Element)v.get(118)).appendChild((Element)v.get(119));

      /* Empieza nodo:120 / Elemento padre: 119   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(120)).setAttribute("align","left" );
      ((Element)v.get(119)).appendChild((Element)v.get(120));

      /* Empieza nodo:121 / Elemento padre: 120   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(121)).setAttribute("nombre","marcOidMarcTdId" );
      ((Element)v.get(120)).appendChild((Element)v.get(121));

      /* Empieza nodo:122 / Elemento padre: 121   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(122)).setAttribute("border","0" );
      ((Element)v.get(122)).setAttribute("cellspacing","0" );
      ((Element)v.get(122)).setAttribute("cellpadding","0" );
      ((Element)v.get(122)).setAttribute("align","left" );
      ((Element)v.get(121)).appendChild((Element)v.get(122));

      /* Empieza nodo:123 / Elemento padre: 122   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(122)).appendChild((Element)v.get(123));

      /* Empieza nodo:124 / Elemento padre: 123   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(124)).setAttribute("valign","top" );
      ((Element)v.get(124)).setAttribute("height","13" );
      ((Element)v.get(123)).appendChild((Element)v.get(124));

      /* Empieza nodo:125 / Elemento padre: 124   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(125)).setAttribute("nombre","lblmarcOidMarc" );
      ((Element)v.get(125)).setAttribute("id","datosTitle" );
      ((Element)v.get(125)).setAttribute("ancho","100" );
      ((Element)v.get(125)).setAttribute("alto","13" );
      ((Element)v.get(125)).setAttribute("cod","ZonSubGerenVenta.marcOidMarc.label" );
      ((Element)v.get(124)).appendChild((Element)v.get(125));
      /* Termina nodo:125   */
      /* Termina nodo:124   */
      /* Termina nodo:123   */

      /* Empieza nodo:126 / Elemento padre: 122   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(126)).setAttribute("nombre","marcOidMarcWidgetTrId" );
      ((Element)v.get(122)).appendChild((Element)v.get(126));

      /* Empieza nodo:127 / Elemento padre: 126   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(127)).setAttribute("align","left" );
      ((Element)v.get(127)).setAttribute("nowrap","true" );
      ((Element)v.get(126)).appendChild((Element)v.get(127));

      /* Empieza nodo:128 / Elemento padre: 127   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(128)).setAttribute("nombre","marcOidMarc" );
      ((Element)v.get(128)).setAttribute("id","datosCampos" );
      ((Element)v.get(128)).setAttribute("multiple","N" );
      ((Element)v.get(128)).setAttribute("req","N" );
      ((Element)v.get(128)).setAttribute("size","1" );
      ((Element)v.get(128)).setAttribute("disabled","" );
      ((Element)v.get(128)).setAttribute("validacion","" );
      ((Element)v.get(128)).setAttribute("onchange","" );
      ((Element)v.get(128)).setAttribute("onfocus","" );
      ((Element)v.get(128)).setAttribute("valorinicial","" );
      ((Element)v.get(128)).setAttribute("textoinicial","" );
      ((Element)v.get(128)).setAttribute("ontab","ejecutarAccionFoco('zonSubGerenVentaFrm',0, true);" );
      ((Element)v.get(128)).setAttribute("onshtab","ejecutarAccionFoco('zonSubGerenVentaFrm',0, false);" );
      ((Element)v.get(127)).appendChild((Element)v.get(128));

      /* Empieza nodo:129 / Elemento padre: 128   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(128)).appendChild((Element)v.get(129));
      /* Termina nodo:129   */
      /* Termina nodo:128   */
      /* Termina nodo:127   */
      /* Termina nodo:126   */
      /* Termina nodo:122   */
      /* Termina nodo:121   */

      /* Empieza nodo:130 / Elemento padre: 120   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(130)).setAttribute("nombre","marcOidMarcGapTdId" );
      ((Element)v.get(130)).setAttribute("nowrap","true" );
      ((Element)v.get(130)).setAttribute("class","datosCampos" );
      ((Element)v.get(120)).appendChild((Element)v.get(130));

      /* Empieza nodo:131 / Elemento padre: 130   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(131)).setAttribute("src","b.gif" );
      ((Element)v.get(131)).setAttribute("width","25" );
      ((Element)v.get(131)).setAttribute("height","8" );
      ((Element)v.get(130)).appendChild((Element)v.get(131));
      /* Termina nodo:131   */
      /* Termina nodo:130   */

      /* Empieza nodo:132 / Elemento padre: 120   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(132)).setAttribute("width","100%" );
      ((Element)v.get(120)).appendChild((Element)v.get(132));

      /* Empieza nodo:133 / Elemento padre: 132   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(133)).setAttribute("src","b.gif" );
      ((Element)v.get(132)).appendChild((Element)v.get(133));
      /* Termina nodo:133   */
      /* Termina nodo:132   */
      /* Termina nodo:120   */
      /* Termina nodo:119   */
      /* Termina nodo:118   */
      /* Termina nodo:115   */

      /* Empieza nodo:134 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(134)).setAttribute("nombre","formGapTr1" );
      ((Element)v.get(52)).appendChild((Element)v.get(134));

      /* Empieza nodo:135 / Elemento padre: 134   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(135)).setAttribute("align","center" );
      ((Element)v.get(135)).setAttribute("width","8" );
      ((Element)v.get(134)).appendChild((Element)v.get(135));

      /* Empieza nodo:136 / Elemento padre: 135   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(136)).setAttribute("src","b.gif" );
      ((Element)v.get(136)).setAttribute("width","12" );
      ((Element)v.get(136)).setAttribute("height","8" );
      ((Element)v.get(135)).appendChild((Element)v.get(136));
      /* Termina nodo:136   */
      /* Termina nodo:135   */

      /* Empieza nodo:137 / Elemento padre: 134   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(134)).appendChild((Element)v.get(137));

      /* Empieza nodo:138 / Elemento padre: 137   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML630(Document doc) {
      ((Element)v.get(138)).setAttribute("src","b.gif" );
      ((Element)v.get(138)).setAttribute("width","8" );
      ((Element)v.get(138)).setAttribute("height","8" );
      ((Element)v.get(137)).appendChild((Element)v.get(138));
      /* Termina nodo:138   */
      /* Termina nodo:137   */

      /* Empieza nodo:139 / Elemento padre: 134   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(139)).setAttribute("align","center" );
      ((Element)v.get(139)).setAttribute("width","8" );
      ((Element)v.get(134)).appendChild((Element)v.get(139));

      /* Empieza nodo:140 / Elemento padre: 139   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(140)).setAttribute("src","b.gif" );
      ((Element)v.get(140)).setAttribute("width","12" );
      ((Element)v.get(140)).setAttribute("height","8" );
      ((Element)v.get(139)).appendChild((Element)v.get(140));
      /* Termina nodo:140   */
      /* Termina nodo:139   */
      /* Termina nodo:134   */

      /* Empieza nodo:141 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(141)).setAttribute("nombre","formTr2" );
      ((Element)v.get(52)).appendChild((Element)v.get(141));

      /* Empieza nodo:142 / Elemento padre: 141   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(142)).setAttribute("align","center" );
      ((Element)v.get(142)).setAttribute("width","8" );
      ((Element)v.get(141)).appendChild((Element)v.get(142));

      /* Empieza nodo:143 / Elemento padre: 142   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(143)).setAttribute("src","b.gif" );
      ((Element)v.get(143)).setAttribute("width","8" );
      ((Element)v.get(143)).setAttribute("height","12" );
      ((Element)v.get(142)).appendChild((Element)v.get(143));
      /* Termina nodo:143   */
      /* Termina nodo:142   */

      /* Empieza nodo:144 / Elemento padre: 141   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(144)).setAttribute("width","100%" );
      ((Element)v.get(141)).appendChild((Element)v.get(144));

      /* Empieza nodo:145 / Elemento padre: 144   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(145)).setAttribute("width","100%" );
      ((Element)v.get(145)).setAttribute("border","0" );
      ((Element)v.get(145)).setAttribute("cellspacing","0" );
      ((Element)v.get(145)).setAttribute("cellpadding","0" );
      ((Element)v.get(145)).setAttribute("align","left" );
      ((Element)v.get(144)).appendChild((Element)v.get(145));

      /* Empieza nodo:146 / Elemento padre: 145   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(146)).setAttribute("align","left" );
      ((Element)v.get(145)).appendChild((Element)v.get(146));

      /* Empieza nodo:147 / Elemento padre: 146   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(147)).setAttribute("nombre","canaOidCana_tipeOidTipoPeriTdId" );
      ((Element)v.get(146)).appendChild((Element)v.get(147));

      /* Empieza nodo:148 / Elemento padre: 147   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(148)).setAttribute("border","0" );
      ((Element)v.get(148)).setAttribute("cellspacing","0" );
      ((Element)v.get(148)).setAttribute("cellpadding","0" );
      ((Element)v.get(148)).setAttribute("align","left" );
      ((Element)v.get(147)).appendChild((Element)v.get(148));

      /* Empieza nodo:149 / Elemento padre: 148   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(148)).appendChild((Element)v.get(149));

      /* Empieza nodo:150 / Elemento padre: 149   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(150)).setAttribute("valign","top" );
      ((Element)v.get(150)).setAttribute("height","13" );
      ((Element)v.get(149)).appendChild((Element)v.get(150));

      /* Empieza nodo:151 / Elemento padre: 150   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(151)).setAttribute("nombre","lblcanaOidCana_tipeOidTipoPeri" );
      ((Element)v.get(151)).setAttribute("id","datosTitle" );
      ((Element)v.get(151)).setAttribute("ancho","100" );
      ((Element)v.get(151)).setAttribute("alto","13" );
      ((Element)v.get(151)).setAttribute("cod","SegCanal.tipeOidTipoPeri.label" );
      ((Element)v.get(150)).appendChild((Element)v.get(151));
      /* Termina nodo:151   */
      /* Termina nodo:150   */
      /* Termina nodo:149   */

      /* Empieza nodo:152 / Elemento padre: 148   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(152)).setAttribute("nombre","canaOidCana_tipeOidTipoPeriWidgetTrId" );
      ((Element)v.get(148)).appendChild((Element)v.get(152));

      /* Empieza nodo:153 / Elemento padre: 152   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(153)).setAttribute("align","left" );
      ((Element)v.get(153)).setAttribute("nowrap","true" );
      ((Element)v.get(152)).appendChild((Element)v.get(153));

      /* Empieza nodo:154 / Elemento padre: 153   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(154)).setAttribute("nombre","canaOidCana_tipeOidTipoPeri" );
      ((Element)v.get(154)).setAttribute("id","datosCampos" );
      ((Element)v.get(154)).setAttribute("multiple","N" );
      ((Element)v.get(154)).setAttribute("req","N" );
      ((Element)v.get(154)).setAttribute("size","1" );
      ((Element)v.get(154)).setAttribute("disabled","" );
      ((Element)v.get(154)).setAttribute("validacion","" );
      ((Element)v.get(154)).setAttribute("onchange","mmgDependeneChange('canaOidCana_tipeOidTipoPeri', 'canaOidCana' , 'zonSubGerenVenta')" );
      ((Element)v.get(154)).setAttribute("onfocus","" );
      ((Element)v.get(154)).setAttribute("valorinicial","" );
      ((Element)v.get(154)).setAttribute("textoinicial","" );
      ((Element)v.get(154)).setAttribute("ontab","focaliza('zonSubGerenVentaFrm.canaOidCana');" );
      ((Element)v.get(154)).setAttribute("onshtab","ejecutarAccionFoco('zonSubGerenVentaFrm',0, false);" );
      ((Element)v.get(153)).appendChild((Element)v.get(154));

      /* Empieza nodo:155 / Elemento padre: 154   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(154)).appendChild((Element)v.get(155));
      /* Termina nodo:155   */
      /* Termina nodo:154   */
      /* Termina nodo:153   */
      /* Termina nodo:152   */
      /* Termina nodo:148   */
      /* Termina nodo:147   */

      /* Empieza nodo:156 / Elemento padre: 146   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(156)).setAttribute("nombre","canaOidCana_tipeOidTipoPeriGapTdId" );
      ((Element)v.get(156)).setAttribute("nowrap","true" );
      ((Element)v.get(156)).setAttribute("class","datosCampos" );
      ((Element)v.get(146)).appendChild((Element)v.get(156));

      /* Empieza nodo:157 / Elemento padre: 156   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML720(Document doc) {
      ((Element)v.get(157)).setAttribute("src","b.gif" );
      ((Element)v.get(157)).setAttribute("width","25" );
      ((Element)v.get(157)).setAttribute("height","8" );
      ((Element)v.get(156)).appendChild((Element)v.get(157));
      /* Termina nodo:157   */
      /* Termina nodo:156   */

      /* Empieza nodo:158 / Elemento padre: 146   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(158)).setAttribute("nombre","canaOidCanaTdId" );
      ((Element)v.get(146)).appendChild((Element)v.get(158));

      /* Empieza nodo:159 / Elemento padre: 158   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(159)).setAttribute("border","0" );
      ((Element)v.get(159)).setAttribute("cellspacing","0" );
      ((Element)v.get(159)).setAttribute("cellpadding","0" );
      ((Element)v.get(159)).setAttribute("align","left" );
      ((Element)v.get(158)).appendChild((Element)v.get(159));

      /* Empieza nodo:160 / Elemento padre: 159   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(159)).appendChild((Element)v.get(160));

      /* Empieza nodo:161 / Elemento padre: 160   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(161)).setAttribute("valign","top" );
      ((Element)v.get(161)).setAttribute("height","13" );
      ((Element)v.get(160)).appendChild((Element)v.get(161));

      /* Empieza nodo:162 / Elemento padre: 161   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(162)).setAttribute("nombre","lblcanaOidCana" );
      ((Element)v.get(162)).setAttribute("id","datosTitle" );
      ((Element)v.get(162)).setAttribute("ancho","100" );
      ((Element)v.get(162)).setAttribute("alto","13" );
      ((Element)v.get(162)).setAttribute("cod","ZonSubGerenVenta.canaOidCana.label" );
      ((Element)v.get(161)).appendChild((Element)v.get(162));
      /* Termina nodo:162   */
      /* Termina nodo:161   */
      /* Termina nodo:160   */

      /* Empieza nodo:163 / Elemento padre: 159   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(163)).setAttribute("nombre","canaOidCanaWidgetTrId" );
      ((Element)v.get(159)).appendChild((Element)v.get(163));

      /* Empieza nodo:164 / Elemento padre: 163   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(164)).setAttribute("align","left" );
      ((Element)v.get(164)).setAttribute("nowrap","true" );
      ((Element)v.get(163)).appendChild((Element)v.get(164));

      /* Empieza nodo:165 / Elemento padre: 164   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(165)).setAttribute("nombre","canaOidCana" );
      ((Element)v.get(165)).setAttribute("id","datosCampos" );
      ((Element)v.get(165)).setAttribute("multiple","N" );
      ((Element)v.get(165)).setAttribute("req","N" );
      ((Element)v.get(165)).setAttribute("size","1" );
      ((Element)v.get(165)).setAttribute("disabled","" );
      ((Element)v.get(165)).setAttribute("validacion","" );
      ((Element)v.get(165)).setAttribute("onchange","" );
      ((Element)v.get(165)).setAttribute("onfocus","" );
      ((Element)v.get(165)).setAttribute("valorinicial","" );
      ((Element)v.get(165)).setAttribute("textoinicial","" );
      ((Element)v.get(165)).setAttribute("ontab","ejecutarAccionFoco('zonSubGerenVentaFrm',0, true);" );
      ((Element)v.get(165)).setAttribute("onshtab","focaliza('zonSubGerenVentaFrm.canaOidCana_tipeOidTipoPeri');" );
      ((Element)v.get(164)).appendChild((Element)v.get(165));

      /* Empieza nodo:166 / Elemento padre: 165   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(165)).appendChild((Element)v.get(166));
      /* Termina nodo:166   */
      /* Termina nodo:165   */
      /* Termina nodo:164   */
      /* Termina nodo:163   */
      /* Termina nodo:159   */
      /* Termina nodo:158   */

      /* Empieza nodo:167 / Elemento padre: 146   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(167)).setAttribute("nombre","canaOidCanaGapTdId" );
      ((Element)v.get(167)).setAttribute("nowrap","true" );
      ((Element)v.get(167)).setAttribute("class","datosCampos" );
      ((Element)v.get(146)).appendChild((Element)v.get(167));

      /* Empieza nodo:168 / Elemento padre: 167   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(168)).setAttribute("src","b.gif" );
      ((Element)v.get(168)).setAttribute("width","25" );
      ((Element)v.get(168)).setAttribute("height","8" );
      ((Element)v.get(167)).appendChild((Element)v.get(168));
      /* Termina nodo:168   */
      /* Termina nodo:167   */

      /* Empieza nodo:169 / Elemento padre: 146   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(169)).setAttribute("width","100%" );
      ((Element)v.get(146)).appendChild((Element)v.get(169));

      /* Empieza nodo:170 / Elemento padre: 169   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(170)).setAttribute("src","b.gif" );
      ((Element)v.get(169)).appendChild((Element)v.get(170));
      /* Termina nodo:170   */
      /* Termina nodo:169   */
      /* Termina nodo:146   */
      /* Termina nodo:145   */
      /* Termina nodo:144   */
      /* Termina nodo:141   */

      /* Empieza nodo:171 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(171)).setAttribute("nombre","formGapTr2" );
      ((Element)v.get(52)).appendChild((Element)v.get(171));

      /* Empieza nodo:172 / Elemento padre: 171   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(172)).setAttribute("align","center" );
      ((Element)v.get(172)).setAttribute("width","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(172));

      /* Empieza nodo:173 / Elemento padre: 172   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(173)).setAttribute("src","b.gif" );
      ((Element)v.get(173)).setAttribute("width","12" );
      ((Element)v.get(173)).setAttribute("height","8" );
      ((Element)v.get(172)).appendChild((Element)v.get(173));
      /* Termina nodo:173   */
      /* Termina nodo:172   */

      /* Empieza nodo:174 / Elemento padre: 171   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(171)).appendChild((Element)v.get(174));

      /* Empieza nodo:175 / Elemento padre: 174   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(175)).setAttribute("src","b.gif" );
      ((Element)v.get(175)).setAttribute("width","8" );
      ((Element)v.get(175)).setAttribute("height","8" );
      ((Element)v.get(174)).appendChild((Element)v.get(175));
      /* Termina nodo:175   */
      /* Termina nodo:174   */

      /* Empieza nodo:176 / Elemento padre: 171   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(176)).setAttribute("align","center" );
      ((Element)v.get(176)).setAttribute("width","8" );
      ((Element)v.get(171)).appendChild((Element)v.get(176));

      /* Empieza nodo:177 / Elemento padre: 176   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML810(Document doc) {
      ((Element)v.get(177)).setAttribute("src","b.gif" );
      ((Element)v.get(177)).setAttribute("width","12" );
      ((Element)v.get(177)).setAttribute("height","8" );
      ((Element)v.get(176)).appendChild((Element)v.get(177));
      /* Termina nodo:177   */
      /* Termina nodo:176   */
      /* Termina nodo:171   */

      /* Empieza nodo:178 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(178)).setAttribute("nombre","formTr3" );
      ((Element)v.get(52)).appendChild((Element)v.get(178));

      /* Empieza nodo:179 / Elemento padre: 178   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(179)).setAttribute("align","center" );
      ((Element)v.get(179)).setAttribute("width","8" );
      ((Element)v.get(178)).appendChild((Element)v.get(179));

      /* Empieza nodo:180 / Elemento padre: 179   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(180)).setAttribute("src","b.gif" );
      ((Element)v.get(180)).setAttribute("width","8" );
      ((Element)v.get(180)).setAttribute("height","12" );
      ((Element)v.get(179)).appendChild((Element)v.get(180));
      /* Termina nodo:180   */
      /* Termina nodo:179   */

      /* Empieza nodo:181 / Elemento padre: 178   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(181)).setAttribute("width","100%" );
      ((Element)v.get(178)).appendChild((Element)v.get(181));

      /* Empieza nodo:182 / Elemento padre: 181   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(182)).setAttribute("width","100%" );
      ((Element)v.get(182)).setAttribute("border","0" );
      ((Element)v.get(182)).setAttribute("cellspacing","0" );
      ((Element)v.get(182)).setAttribute("cellpadding","0" );
      ((Element)v.get(182)).setAttribute("align","left" );
      ((Element)v.get(181)).appendChild((Element)v.get(182));

      /* Empieza nodo:183 / Elemento padre: 182   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(183)).setAttribute("align","left" );
      ((Element)v.get(182)).appendChild((Element)v.get(183));

      /* Empieza nodo:184 / Elemento padre: 183   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(184)).setAttribute("nombre","idTdId" );
      ((Element)v.get(183)).appendChild((Element)v.get(184));

      /* Empieza nodo:185 / Elemento padre: 184   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(185)).setAttribute("width","100%" );
      ((Element)v.get(185)).setAttribute("border","0" );
      ((Element)v.get(185)).setAttribute("cellspacing","0" );
      ((Element)v.get(185)).setAttribute("cellpadding","0" );
      ((Element)v.get(185)).setAttribute("align","left" );
      ((Element)v.get(184)).appendChild((Element)v.get(185));

      /* Empieza nodo:186 / Elemento padre: 185   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(185)).appendChild((Element)v.get(186));

      /* Empieza nodo:187 / Elemento padre: 186   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(187)).setAttribute("valign","top" );
      ((Element)v.get(187)).setAttribute("height","13" );
      ((Element)v.get(186)).appendChild((Element)v.get(187));

      /* Empieza nodo:188 / Elemento padre: 187   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(188)).setAttribute("nombre","lblId" );
      ((Element)v.get(188)).setAttribute("alto","13" );
      ((Element)v.get(188)).setAttribute("filas","1" );
      ((Element)v.get(188)).setAttribute("id","datosTitle" );
      ((Element)v.get(188)).setAttribute("cod","ZonSubGerenVenta.id.label" );
      ((Element)v.get(187)).appendChild((Element)v.get(188));
      /* Termina nodo:188   */
      /* Termina nodo:187   */
      /* Termina nodo:186   */

      /* Empieza nodo:189 / Elemento padre: 185   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(189)).setAttribute("nombre","idWidgetTrId" );
      ((Element)v.get(185)).appendChild((Element)v.get(189));

      /* Empieza nodo:190 / Elemento padre: 189   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(190)).setAttribute("align","left" );
      ((Element)v.get(190)).setAttribute("nowrap","true" );
      ((Element)v.get(189)).appendChild((Element)v.get(190));

      /* Empieza nodo:191 / Elemento padre: 190   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(191)).setAttribute("nombre","id" );
      ((Element)v.get(191)).setAttribute("id","datosCampos" );
      ((Element)v.get(191)).setAttribute("trim","S" );
      ((Element)v.get(191)).setAttribute("max","12" );
      ((Element)v.get(191)).setAttribute("onchange","" );
      ((Element)v.get(191)).setAttribute("req","N" );
      ((Element)v.get(191)).setAttribute("size","12" );
      ((Element)v.get(191)).setAttribute("valor","" );
      ((Element)v.get(191)).setAttribute("validacion","" );
      ((Element)v.get(191)).setAttribute("disabled","" );
      ((Element)v.get(191)).setAttribute("onblur","" );
      ((Element)v.get(191)).setAttribute("ontab","ejecutarAccionFoco('zonSubGerenVentaFrm',0, true)" );
      ((Element)v.get(191)).setAttribute("onshtab","ejecutarAccionFoco('zonSubGerenVentaFrm', 0, false)" );
      ((Element)v.get(190)).appendChild((Element)v.get(191));
      /* Termina nodo:191   */
      /* Termina nodo:190   */
      /* Termina nodo:189   */
      /* Termina nodo:185   */
      /* Termina nodo:184   */

      /* Empieza nodo:192 / Elemento padre: 183   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(192)).setAttribute("nombre","idGapTdId" );
      ((Element)v.get(192)).setAttribute("nowrap","true" );
      ((Element)v.get(192)).setAttribute("class","datosCampos" );
      ((Element)v.get(183)).appendChild((Element)v.get(192));

      /* Empieza nodo:193 / Elemento padre: 192   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(193)).setAttribute("src","b.gif" );
      ((Element)v.get(193)).setAttribute("width","25" );
      ((Element)v.get(193)).setAttribute("height","8" );
      ((Element)v.get(192)).appendChild((Element)v.get(193));
      /* Termina nodo:193   */
      /* Termina nodo:192   */

      /* Empieza nodo:194 / Elemento padre: 183   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(194)).setAttribute("width","100%" );
      ((Element)v.get(183)).appendChild((Element)v.get(194));

      /* Empieza nodo:195 / Elemento padre: 194   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(195)).setAttribute("src","b.gif" );
      ((Element)v.get(194)).appendChild((Element)v.get(195));
      /* Termina nodo:195   */
      /* Termina nodo:194   */
      /* Termina nodo:183   */
      /* Termina nodo:182   */
      /* Termina nodo:181   */
      /* Termina nodo:178   */

      /* Empieza nodo:196 / Elemento padre: 52   */
   }

   private void getXML900(Document doc) {
      v.add(doc.createElement("TR"));
      ((Element)v.get(196)).setAttribute("nombre","formGapTr3" );
      ((Element)v.get(52)).appendChild((Element)v.get(196));

      /* Empieza nodo:197 / Elemento padre: 196   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(197)).setAttribute("align","center" );
      ((Element)v.get(197)).setAttribute("width","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(197));

      /* Empieza nodo:198 / Elemento padre: 197   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(198)).setAttribute("src","b.gif" );
      ((Element)v.get(198)).setAttribute("width","12" );
      ((Element)v.get(198)).setAttribute("height","8" );
      ((Element)v.get(197)).appendChild((Element)v.get(198));
      /* Termina nodo:198   */
      /* Termina nodo:197   */

      /* Empieza nodo:199 / Elemento padre: 196   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(196)).appendChild((Element)v.get(199));

      /* Empieza nodo:200 / Elemento padre: 199   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(200)).setAttribute("src","b.gif" );
      ((Element)v.get(200)).setAttribute("width","8" );
      ((Element)v.get(200)).setAttribute("height","8" );
      ((Element)v.get(199)).appendChild((Element)v.get(200));
      /* Termina nodo:200   */
      /* Termina nodo:199   */

      /* Empieza nodo:201 / Elemento padre: 196   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(201)).setAttribute("align","center" );
      ((Element)v.get(201)).setAttribute("width","8" );
      ((Element)v.get(196)).appendChild((Element)v.get(201));

      /* Empieza nodo:202 / Elemento padre: 201   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(202)).setAttribute("src","b.gif" );
      ((Element)v.get(202)).setAttribute("width","12" );
      ((Element)v.get(202)).setAttribute("height","8" );
      ((Element)v.get(201)).appendChild((Element)v.get(202));
      /* Termina nodo:202   */
      /* Termina nodo:201   */
      /* Termina nodo:196   */

      /* Empieza nodo:203 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(203)).setAttribute("nombre","formTr4" );
      ((Element)v.get(52)).appendChild((Element)v.get(203));

      /* Empieza nodo:204 / Elemento padre: 203   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(204)).setAttribute("align","center" );
      ((Element)v.get(204)).setAttribute("width","8" );
      ((Element)v.get(203)).appendChild((Element)v.get(204));

      /* Empieza nodo:205 / Elemento padre: 204   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(205)).setAttribute("src","b.gif" );
      ((Element)v.get(205)).setAttribute("width","8" );
      ((Element)v.get(205)).setAttribute("height","12" );
      ((Element)v.get(204)).appendChild((Element)v.get(205));
      /* Termina nodo:205   */
      /* Termina nodo:204   */

      /* Empieza nodo:206 / Elemento padre: 203   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(206)).setAttribute("width","100%" );
      ((Element)v.get(203)).appendChild((Element)v.get(206));

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
      ((Element)v.get(208)).setAttribute("align","left" );
      ((Element)v.get(207)).appendChild((Element)v.get(208));

      /* Empieza nodo:209 / Elemento padre: 208   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(209)).setAttribute("nombre","codSubgVentTdId" );
      ((Element)v.get(208)).appendChild((Element)v.get(209));

      /* Empieza nodo:210 / Elemento padre: 209   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(210)).setAttribute("width","100%" );
      ((Element)v.get(210)).setAttribute("border","0" );
      ((Element)v.get(210)).setAttribute("cellspacing","0" );
      ((Element)v.get(210)).setAttribute("cellpadding","0" );
      ((Element)v.get(210)).setAttribute("align","left" );
      ((Element)v.get(209)).appendChild((Element)v.get(210));

      /* Empieza nodo:211 / Elemento padre: 210   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(210)).appendChild((Element)v.get(211));

      /* Empieza nodo:212 / Elemento padre: 211   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(212)).setAttribute("valign","top" );
      ((Element)v.get(212)).setAttribute("height","13" );
      ((Element)v.get(211)).appendChild((Element)v.get(212));

      /* Empieza nodo:213 / Elemento padre: 212   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(213)).setAttribute("nombre","lblCodSubgVent" );
      ((Element)v.get(213)).setAttribute("alto","13" );
      ((Element)v.get(213)).setAttribute("filas","1" );
      ((Element)v.get(213)).setAttribute("id","datosTitle" );
      ((Element)v.get(213)).setAttribute("cod","ZonSubGerenVenta.codSubgVent.label" );
      ((Element)v.get(212)).appendChild((Element)v.get(213));
      /* Termina nodo:213   */
      /* Termina nodo:212   */
      /* Termina nodo:211   */

      /* Empieza nodo:214 / Elemento padre: 210   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(214)).setAttribute("nombre","codSubgVentWidgetTrId" );
      ((Element)v.get(210)).appendChild((Element)v.get(214));

      /* Empieza nodo:215 / Elemento padre: 214   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(215)).setAttribute("align","left" );
      ((Element)v.get(215)).setAttribute("nowrap","true" );
      ((Element)v.get(214)).appendChild((Element)v.get(215));

      /* Empieza nodo:216 / Elemento padre: 215   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(216)).setAttribute("nombre","codSubgVent" );
      ((Element)v.get(216)).setAttribute("id","datosCampos" );
      ((Element)v.get(216)).setAttribute("trim","S" );
      ((Element)v.get(216)).setAttribute("max","2" );
      ((Element)v.get(216)).setAttribute("onchange","" );
      ((Element)v.get(216)).setAttribute("req","N" );
   }

   private void getXML990(Document doc) {
      ((Element)v.get(216)).setAttribute("size","2" );
      ((Element)v.get(216)).setAttribute("valor","" );
      ((Element)v.get(216)).setAttribute("validacion","" );
      ((Element)v.get(216)).setAttribute("disabled","" );
      ((Element)v.get(216)).setAttribute("onblur","" );
      ((Element)v.get(216)).setAttribute("ontab","ejecutarAccionFoco('zonSubGerenVentaFrm',0, true)" );
      ((Element)v.get(216)).setAttribute("onshtab","ejecutarAccionFoco('zonSubGerenVentaFrm', 0, false)" );
      ((Element)v.get(215)).appendChild((Element)v.get(216));
      /* Termina nodo:216   */
      /* Termina nodo:215   */
      /* Termina nodo:214   */
      /* Termina nodo:210   */
      /* Termina nodo:209   */

      /* Empieza nodo:217 / Elemento padre: 208   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(217)).setAttribute("nombre","codSubgVentGapTdId" );
      ((Element)v.get(217)).setAttribute("nowrap","true" );
      ((Element)v.get(217)).setAttribute("class","datosCampos" );
      ((Element)v.get(208)).appendChild((Element)v.get(217));

      /* Empieza nodo:218 / Elemento padre: 217   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(218)).setAttribute("src","b.gif" );
      ((Element)v.get(218)).setAttribute("width","25" );
      ((Element)v.get(218)).setAttribute("height","8" );
      ((Element)v.get(217)).appendChild((Element)v.get(218));
      /* Termina nodo:218   */
      /* Termina nodo:217   */

      /* Empieza nodo:219 / Elemento padre: 208   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(219)).setAttribute("width","100%" );
      ((Element)v.get(208)).appendChild((Element)v.get(219));

      /* Empieza nodo:220 / Elemento padre: 219   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(220)).setAttribute("src","b.gif" );
      ((Element)v.get(219)).appendChild((Element)v.get(220));
      /* Termina nodo:220   */
      /* Termina nodo:219   */
      /* Termina nodo:208   */
      /* Termina nodo:207   */
      /* Termina nodo:206   */
      /* Termina nodo:203   */

      /* Empieza nodo:221 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(221)).setAttribute("nombre","formGapTr4" );
      ((Element)v.get(52)).appendChild((Element)v.get(221));

      /* Empieza nodo:222 / Elemento padre: 221   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(222)).setAttribute("align","center" );
      ((Element)v.get(222)).setAttribute("width","8" );
      ((Element)v.get(221)).appendChild((Element)v.get(222));

      /* Empieza nodo:223 / Elemento padre: 222   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(223)).setAttribute("src","b.gif" );
      ((Element)v.get(223)).setAttribute("width","12" );
      ((Element)v.get(223)).setAttribute("height","8" );
      ((Element)v.get(222)).appendChild((Element)v.get(223));
      /* Termina nodo:223   */
      /* Termina nodo:222   */

      /* Empieza nodo:224 / Elemento padre: 221   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(221)).appendChild((Element)v.get(224));

      /* Empieza nodo:225 / Elemento padre: 224   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(225)).setAttribute("src","b.gif" );
      ((Element)v.get(225)).setAttribute("width","8" );
      ((Element)v.get(225)).setAttribute("height","8" );
      ((Element)v.get(224)).appendChild((Element)v.get(225));
      /* Termina nodo:225   */
      /* Termina nodo:224   */

      /* Empieza nodo:226 / Elemento padre: 221   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(226)).setAttribute("align","center" );
      ((Element)v.get(226)).setAttribute("width","8" );
      ((Element)v.get(221)).appendChild((Element)v.get(226));

      /* Empieza nodo:227 / Elemento padre: 226   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(227)).setAttribute("src","b.gif" );
      ((Element)v.get(227)).setAttribute("width","12" );
      ((Element)v.get(227)).setAttribute("height","8" );
      ((Element)v.get(226)).appendChild((Element)v.get(227));
      /* Termina nodo:227   */
      /* Termina nodo:226   */
      /* Termina nodo:221   */

      /* Empieza nodo:228 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(228)).setAttribute("nombre","formTr5" );
      ((Element)v.get(52)).appendChild((Element)v.get(228));

      /* Empieza nodo:229 / Elemento padre: 228   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(229)).setAttribute("align","center" );
      ((Element)v.get(229)).setAttribute("width","8" );
      ((Element)v.get(228)).appendChild((Element)v.get(229));

      /* Empieza nodo:230 / Elemento padre: 229   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(230)).setAttribute("src","b.gif" );
      ((Element)v.get(230)).setAttribute("width","8" );
      ((Element)v.get(230)).setAttribute("height","12" );
      ((Element)v.get(229)).appendChild((Element)v.get(230));
      /* Termina nodo:230   */
      /* Termina nodo:229   */

      /* Empieza nodo:231 / Elemento padre: 228   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(231)).setAttribute("width","100%" );
      ((Element)v.get(228)).appendChild((Element)v.get(231));

      /* Empieza nodo:232 / Elemento padre: 231   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(232)).setAttribute("width","100%" );
      ((Element)v.get(232)).setAttribute("border","0" );
      ((Element)v.get(232)).setAttribute("cellspacing","0" );
      ((Element)v.get(232)).setAttribute("cellpadding","0" );
      ((Element)v.get(232)).setAttribute("align","left" );
      ((Element)v.get(231)).appendChild((Element)v.get(232));

      /* Empieza nodo:233 / Elemento padre: 232   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(233)).setAttribute("align","left" );
      ((Element)v.get(232)).appendChild((Element)v.get(233));

      /* Empieza nodo:234 / Elemento padre: 233   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(234)).setAttribute("nombre","indBorrTdId" );
      ((Element)v.get(233)).appendChild((Element)v.get(234));

      /* Empieza nodo:235 / Elemento padre: 234   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(235)).setAttribute("width","100%" );
      ((Element)v.get(235)).setAttribute("border","0" );
      ((Element)v.get(235)).setAttribute("cellspacing","0" );
      ((Element)v.get(235)).setAttribute("cellpadding","0" );
      ((Element)v.get(235)).setAttribute("align","left" );
      ((Element)v.get(234)).appendChild((Element)v.get(235));

      /* Empieza nodo:236 / Elemento padre: 235   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(235)).appendChild((Element)v.get(236));

      /* Empieza nodo:237 / Elemento padre: 236   */
      v.add(doc.createElement("TD"));
   }

   private void getXML1080(Document doc) {
      ((Element)v.get(237)).setAttribute("valign","top" );
      ((Element)v.get(237)).setAttribute("height","13" );
      ((Element)v.get(236)).appendChild((Element)v.get(237));

      /* Empieza nodo:238 / Elemento padre: 237   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(238)).setAttribute("nombre","lblIndBorr" );
      ((Element)v.get(238)).setAttribute("alto","13" );
      ((Element)v.get(238)).setAttribute("filas","1" );
      ((Element)v.get(238)).setAttribute("id","datosTitle" );
      ((Element)v.get(238)).setAttribute("cod","ZonSubGerenVenta.indBorr.label" );
      ((Element)v.get(237)).appendChild((Element)v.get(238));
      /* Termina nodo:238   */
      /* Termina nodo:237   */
      /* Termina nodo:236   */

      /* Empieza nodo:239 / Elemento padre: 235   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(239)).setAttribute("nombre","indBorrWidgetTrId" );
      ((Element)v.get(235)).appendChild((Element)v.get(239));

      /* Empieza nodo:240 / Elemento padre: 239   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(240)).setAttribute("align","left" );
      ((Element)v.get(240)).setAttribute("nowrap","true" );
      ((Element)v.get(239)).appendChild((Element)v.get(240));

      /* Empieza nodo:241 / Elemento padre: 240   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(241)).setAttribute("nombre","indBorr" );
      ((Element)v.get(241)).setAttribute("id","datosCampos" );
      ((Element)v.get(241)).setAttribute("trim","S" );
      ((Element)v.get(241)).setAttribute("max","1" );
      ((Element)v.get(241)).setAttribute("onchange","" );
      ((Element)v.get(241)).setAttribute("req","N" );
      ((Element)v.get(241)).setAttribute("size","1" );
      ((Element)v.get(241)).setAttribute("valor","" );
      ((Element)v.get(241)).setAttribute("validacion","" );
      ((Element)v.get(241)).setAttribute("disabled","" );
      ((Element)v.get(241)).setAttribute("onblur","" );
      ((Element)v.get(241)).setAttribute("ontab","ejecutarAccionFoco('zonSubGerenVentaFrm',0, true)" );
      ((Element)v.get(241)).setAttribute("onshtab","ejecutarAccionFoco('zonSubGerenVentaFrm', 0, false)" );
      ((Element)v.get(240)).appendChild((Element)v.get(241));
      /* Termina nodo:241   */
      /* Termina nodo:240   */
      /* Termina nodo:239   */
      /* Termina nodo:235   */
      /* Termina nodo:234   */

      /* Empieza nodo:242 / Elemento padre: 233   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(242)).setAttribute("nombre","indBorrGapTdId" );
      ((Element)v.get(242)).setAttribute("nowrap","true" );
      ((Element)v.get(242)).setAttribute("class","datosCampos" );
      ((Element)v.get(233)).appendChild((Element)v.get(242));

      /* Empieza nodo:243 / Elemento padre: 242   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(243)).setAttribute("src","b.gif" );
      ((Element)v.get(243)).setAttribute("width","25" );
      ((Element)v.get(243)).setAttribute("height","8" );
      ((Element)v.get(242)).appendChild((Element)v.get(243));
      /* Termina nodo:243   */
      /* Termina nodo:242   */

      /* Empieza nodo:244 / Elemento padre: 233   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(244)).setAttribute("width","100%" );
      ((Element)v.get(233)).appendChild((Element)v.get(244));

      /* Empieza nodo:245 / Elemento padre: 244   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(245)).setAttribute("src","b.gif" );
      ((Element)v.get(244)).appendChild((Element)v.get(245));
      /* Termina nodo:245   */
      /* Termina nodo:244   */
      /* Termina nodo:233   */
      /* Termina nodo:232   */
      /* Termina nodo:231   */
      /* Termina nodo:228   */

      /* Empieza nodo:246 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(246)).setAttribute("nombre","formGapTr5" );
      ((Element)v.get(52)).appendChild((Element)v.get(246));

      /* Empieza nodo:247 / Elemento padre: 246   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(247)).setAttribute("align","center" );
      ((Element)v.get(247)).setAttribute("width","8" );
      ((Element)v.get(246)).appendChild((Element)v.get(247));

      /* Empieza nodo:248 / Elemento padre: 247   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(248)).setAttribute("src","b.gif" );
      ((Element)v.get(248)).setAttribute("width","12" );
      ((Element)v.get(248)).setAttribute("height","8" );
      ((Element)v.get(247)).appendChild((Element)v.get(248));
      /* Termina nodo:248   */
      /* Termina nodo:247   */

      /* Empieza nodo:249 / Elemento padre: 246   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(246)).appendChild((Element)v.get(249));

      /* Empieza nodo:250 / Elemento padre: 249   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(250)).setAttribute("src","b.gif" );
      ((Element)v.get(250)).setAttribute("width","8" );
      ((Element)v.get(250)).setAttribute("height","8" );
      ((Element)v.get(249)).appendChild((Element)v.get(250));
      /* Termina nodo:250   */
      /* Termina nodo:249   */

      /* Empieza nodo:251 / Elemento padre: 246   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(251)).setAttribute("align","center" );
      ((Element)v.get(251)).setAttribute("width","8" );
      ((Element)v.get(246)).appendChild((Element)v.get(251));

      /* Empieza nodo:252 / Elemento padre: 251   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(252)).setAttribute("src","b.gif" );
      ((Element)v.get(252)).setAttribute("width","12" );
      ((Element)v.get(252)).setAttribute("height","8" );
      ((Element)v.get(251)).appendChild((Element)v.get(252));
      /* Termina nodo:252   */
      /* Termina nodo:251   */
      /* Termina nodo:246   */

      /* Empieza nodo:253 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(253)).setAttribute("nombre","formTr6" );
      ((Element)v.get(52)).appendChild((Element)v.get(253));

      /* Empieza nodo:254 / Elemento padre: 253   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(254)).setAttribute("align","center" );
      ((Element)v.get(254)).setAttribute("width","8" );
      ((Element)v.get(253)).appendChild((Element)v.get(254));

      /* Empieza nodo:255 / Elemento padre: 254   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(255)).setAttribute("src","b.gif" );
      ((Element)v.get(255)).setAttribute("width","8" );
      ((Element)v.get(255)).setAttribute("height","12" );
      ((Element)v.get(254)).appendChild((Element)v.get(255));
      /* Termina nodo:255   */
      /* Termina nodo:254   */

      /* Empieza nodo:256 / Elemento padre: 253   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(256)).setAttribute("width","100%" );
   }

   private void getXML1170(Document doc) {
      ((Element)v.get(253)).appendChild((Element)v.get(256));

      /* Empieza nodo:257 / Elemento padre: 256   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(257)).setAttribute("width","100%" );
      ((Element)v.get(257)).setAttribute("border","0" );
      ((Element)v.get(257)).setAttribute("cellspacing","0" );
      ((Element)v.get(257)).setAttribute("cellpadding","0" );
      ((Element)v.get(257)).setAttribute("align","left" );
      ((Element)v.get(256)).appendChild((Element)v.get(257));

      /* Empieza nodo:258 / Elemento padre: 257   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(258)).setAttribute("align","left" );
      ((Element)v.get(257)).appendChild((Element)v.get(258));

      /* Empieza nodo:259 / Elemento padre: 258   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(259)).setAttribute("nombre","indActiTdId" );
      ((Element)v.get(258)).appendChild((Element)v.get(259));

      /* Empieza nodo:260 / Elemento padre: 259   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(260)).setAttribute("width","100%" );
      ((Element)v.get(260)).setAttribute("border","0" );
      ((Element)v.get(260)).setAttribute("cellspacing","0" );
      ((Element)v.get(260)).setAttribute("cellpadding","0" );
      ((Element)v.get(260)).setAttribute("align","left" );
      ((Element)v.get(259)).appendChild((Element)v.get(260));

      /* Empieza nodo:261 / Elemento padre: 260   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(260)).appendChild((Element)v.get(261));

      /* Empieza nodo:262 / Elemento padre: 261   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(262)).setAttribute("valign","top" );
      ((Element)v.get(262)).setAttribute("height","13" );
      ((Element)v.get(261)).appendChild((Element)v.get(262));

      /* Empieza nodo:263 / Elemento padre: 262   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(263)).setAttribute("nombre","lblIndActi" );
      ((Element)v.get(263)).setAttribute("alto","13" );
      ((Element)v.get(263)).setAttribute("filas","1" );
      ((Element)v.get(263)).setAttribute("id","datosTitle" );
      ((Element)v.get(263)).setAttribute("cod","ZonSubGerenVenta.indActi.label" );
      ((Element)v.get(262)).appendChild((Element)v.get(263));
      /* Termina nodo:263   */
      /* Termina nodo:262   */
      /* Termina nodo:261   */

      /* Empieza nodo:264 / Elemento padre: 260   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(264)).setAttribute("nombre","indActiWidgetTrId" );
      ((Element)v.get(260)).appendChild((Element)v.get(264));

      /* Empieza nodo:265 / Elemento padre: 264   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(265)).setAttribute("align","left" );
      ((Element)v.get(265)).setAttribute("nowrap","true" );
      ((Element)v.get(264)).appendChild((Element)v.get(265));

      /* Empieza nodo:266 / Elemento padre: 265   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(266)).setAttribute("nombre","indActi" );
      ((Element)v.get(266)).setAttribute("id","datosCampos" );
      ((Element)v.get(266)).setAttribute("trim","S" );
      ((Element)v.get(266)).setAttribute("max","1" );
      ((Element)v.get(266)).setAttribute("onchange","" );
      ((Element)v.get(266)).setAttribute("req","N" );
      ((Element)v.get(266)).setAttribute("size","1" );
      ((Element)v.get(266)).setAttribute("valor","" );
      ((Element)v.get(266)).setAttribute("validacion","" );
      ((Element)v.get(266)).setAttribute("disabled","" );
      ((Element)v.get(266)).setAttribute("onblur","" );
      ((Element)v.get(266)).setAttribute("ontab","ejecutarAccionFoco('zonSubGerenVentaFrm',0, true)" );
      ((Element)v.get(266)).setAttribute("onshtab","ejecutarAccionFoco('zonSubGerenVentaFrm', 0, false)" );
      ((Element)v.get(265)).appendChild((Element)v.get(266));
      /* Termina nodo:266   */
      /* Termina nodo:265   */
      /* Termina nodo:264   */
      /* Termina nodo:260   */
      /* Termina nodo:259   */

      /* Empieza nodo:267 / Elemento padre: 258   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(267)).setAttribute("nombre","indActiGapTdId" );
      ((Element)v.get(267)).setAttribute("nowrap","true" );
      ((Element)v.get(267)).setAttribute("class","datosCampos" );
      ((Element)v.get(258)).appendChild((Element)v.get(267));

      /* Empieza nodo:268 / Elemento padre: 267   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(268)).setAttribute("src","b.gif" );
      ((Element)v.get(268)).setAttribute("width","25" );
      ((Element)v.get(268)).setAttribute("height","8" );
      ((Element)v.get(267)).appendChild((Element)v.get(268));
      /* Termina nodo:268   */
      /* Termina nodo:267   */

      /* Empieza nodo:269 / Elemento padre: 258   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(269)).setAttribute("width","100%" );
      ((Element)v.get(258)).appendChild((Element)v.get(269));

      /* Empieza nodo:270 / Elemento padre: 269   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(270)).setAttribute("src","b.gif" );
      ((Element)v.get(269)).appendChild((Element)v.get(270));
      /* Termina nodo:270   */
      /* Termina nodo:269   */
      /* Termina nodo:258   */
      /* Termina nodo:257   */
      /* Termina nodo:256   */
      /* Termina nodo:253   */

      /* Empieza nodo:271 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(271)).setAttribute("nombre","formGapTr6" );
      ((Element)v.get(52)).appendChild((Element)v.get(271));

      /* Empieza nodo:272 / Elemento padre: 271   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(272)).setAttribute("align","center" );
      ((Element)v.get(272)).setAttribute("width","8" );
      ((Element)v.get(271)).appendChild((Element)v.get(272));

      /* Empieza nodo:273 / Elemento padre: 272   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(273)).setAttribute("src","b.gif" );
      ((Element)v.get(273)).setAttribute("width","12" );
      ((Element)v.get(273)).setAttribute("height","8" );
      ((Element)v.get(272)).appendChild((Element)v.get(273));
      /* Termina nodo:273   */
      /* Termina nodo:272   */

      /* Empieza nodo:274 / Elemento padre: 271   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(271)).appendChild((Element)v.get(274));

      /* Empieza nodo:275 / Elemento padre: 274   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(275)).setAttribute("src","b.gif" );
      ((Element)v.get(275)).setAttribute("width","8" );
      ((Element)v.get(275)).setAttribute("height","8" );
   }

   private void getXML1260(Document doc) {
      ((Element)v.get(274)).appendChild((Element)v.get(275));
      /* Termina nodo:275   */
      /* Termina nodo:274   */

      /* Empieza nodo:276 / Elemento padre: 271   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(276)).setAttribute("align","center" );
      ((Element)v.get(276)).setAttribute("width","8" );
      ((Element)v.get(271)).appendChild((Element)v.get(276));

      /* Empieza nodo:277 / Elemento padre: 276   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(277)).setAttribute("src","b.gif" );
      ((Element)v.get(277)).setAttribute("width","12" );
      ((Element)v.get(277)).setAttribute("height","8" );
      ((Element)v.get(276)).appendChild((Element)v.get(277));
      /* Termina nodo:277   */
      /* Termina nodo:276   */
      /* Termina nodo:271   */

      /* Empieza nodo:278 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(278)).setAttribute("nombre","formTr7" );
      ((Element)v.get(52)).appendChild((Element)v.get(278));

      /* Empieza nodo:279 / Elemento padre: 278   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(279)).setAttribute("align","center" );
      ((Element)v.get(279)).setAttribute("width","8" );
      ((Element)v.get(278)).appendChild((Element)v.get(279));

      /* Empieza nodo:280 / Elemento padre: 279   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(280)).setAttribute("src","b.gif" );
      ((Element)v.get(280)).setAttribute("width","8" );
      ((Element)v.get(280)).setAttribute("height","12" );
      ((Element)v.get(279)).appendChild((Element)v.get(280));
      /* Termina nodo:280   */
      /* Termina nodo:279   */

      /* Empieza nodo:281 / Elemento padre: 278   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(281)).setAttribute("width","100%" );
      ((Element)v.get(278)).appendChild((Element)v.get(281));

      /* Empieza nodo:282 / Elemento padre: 281   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(282)).setAttribute("width","100%" );
      ((Element)v.get(282)).setAttribute("border","0" );
      ((Element)v.get(282)).setAttribute("cellspacing","0" );
      ((Element)v.get(282)).setAttribute("cellpadding","0" );
      ((Element)v.get(282)).setAttribute("align","left" );
      ((Element)v.get(281)).appendChild((Element)v.get(282));

      /* Empieza nodo:283 / Elemento padre: 282   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(283)).setAttribute("align","left" );
      ((Element)v.get(282)).appendChild((Element)v.get(283));

      /* Empieza nodo:284 / Elemento padre: 283   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(284)).setAttribute("nombre","codNse1TdId" );
      ((Element)v.get(283)).appendChild((Element)v.get(284));

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
      ((Element)v.get(285)).appendChild((Element)v.get(286));

      /* Empieza nodo:287 / Elemento padre: 286   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(287)).setAttribute("valign","top" );
      ((Element)v.get(287)).setAttribute("height","13" );
      ((Element)v.get(286)).appendChild((Element)v.get(287));

      /* Empieza nodo:288 / Elemento padre: 287   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(288)).setAttribute("nombre","lblCodNse1" );
      ((Element)v.get(288)).setAttribute("alto","13" );
      ((Element)v.get(288)).setAttribute("filas","1" );
      ((Element)v.get(288)).setAttribute("id","datosTitle" );
      ((Element)v.get(288)).setAttribute("cod","ZonSubGerenVenta.codNse1.label" );
      ((Element)v.get(287)).appendChild((Element)v.get(288));
      /* Termina nodo:288   */
      /* Termina nodo:287   */
      /* Termina nodo:286   */

      /* Empieza nodo:289 / Elemento padre: 285   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(289)).setAttribute("nombre","codNse1WidgetTrId" );
      ((Element)v.get(285)).appendChild((Element)v.get(289));

      /* Empieza nodo:290 / Elemento padre: 289   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(290)).setAttribute("align","left" );
      ((Element)v.get(290)).setAttribute("nowrap","true" );
      ((Element)v.get(289)).appendChild((Element)v.get(290));

      /* Empieza nodo:291 / Elemento padre: 290   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(291)).setAttribute("nombre","codNse1" );
      ((Element)v.get(291)).setAttribute("id","datosCampos" );
      ((Element)v.get(291)).setAttribute("trim","S" );
      ((Element)v.get(291)).setAttribute("max","2" );
      ((Element)v.get(291)).setAttribute("onchange","" );
      ((Element)v.get(291)).setAttribute("req","N" );
      ((Element)v.get(291)).setAttribute("size","2" );
      ((Element)v.get(291)).setAttribute("valor","" );
      ((Element)v.get(291)).setAttribute("validacion","" );
      ((Element)v.get(291)).setAttribute("disabled","" );
      ((Element)v.get(291)).setAttribute("onblur","" );
      ((Element)v.get(291)).setAttribute("ontab","ejecutarAccionFoco('zonSubGerenVentaFrm',0, true)" );
      ((Element)v.get(291)).setAttribute("onshtab","ejecutarAccionFoco('zonSubGerenVentaFrm', 0, false)" );
      ((Element)v.get(290)).appendChild((Element)v.get(291));
      /* Termina nodo:291   */
      /* Termina nodo:290   */
      /* Termina nodo:289   */
      /* Termina nodo:285   */
      /* Termina nodo:284   */

      /* Empieza nodo:292 / Elemento padre: 283   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(292)).setAttribute("nombre","codNse1GapTdId" );
      ((Element)v.get(292)).setAttribute("nowrap","true" );
      ((Element)v.get(292)).setAttribute("class","datosCampos" );
      ((Element)v.get(283)).appendChild((Element)v.get(292));

      /* Empieza nodo:293 / Elemento padre: 292   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(293)).setAttribute("src","b.gif" );
      ((Element)v.get(293)).setAttribute("width","25" );
      ((Element)v.get(293)).setAttribute("height","8" );
      ((Element)v.get(292)).appendChild((Element)v.get(293));
      /* Termina nodo:293   */
      /* Termina nodo:292   */

      /* Empieza nodo:294 / Elemento padre: 283   */
   }

   private void getXML1350(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(294)).setAttribute("width","100%" );
      ((Element)v.get(283)).appendChild((Element)v.get(294));

      /* Empieza nodo:295 / Elemento padre: 294   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(295)).setAttribute("src","b.gif" );
      ((Element)v.get(294)).appendChild((Element)v.get(295));
      /* Termina nodo:295   */
      /* Termina nodo:294   */
      /* Termina nodo:283   */
      /* Termina nodo:282   */
      /* Termina nodo:281   */
      /* Termina nodo:278   */

      /* Empieza nodo:296 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(296)).setAttribute("nombre","formGapTr7" );
      ((Element)v.get(52)).appendChild((Element)v.get(296));

      /* Empieza nodo:297 / Elemento padre: 296   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(297)).setAttribute("align","center" );
      ((Element)v.get(297)).setAttribute("width","8" );
      ((Element)v.get(296)).appendChild((Element)v.get(297));

      /* Empieza nodo:298 / Elemento padre: 297   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(298)).setAttribute("src","b.gif" );
      ((Element)v.get(298)).setAttribute("width","12" );
      ((Element)v.get(298)).setAttribute("height","8" );
      ((Element)v.get(297)).appendChild((Element)v.get(298));
      /* Termina nodo:298   */
      /* Termina nodo:297   */

      /* Empieza nodo:299 / Elemento padre: 296   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(296)).appendChild((Element)v.get(299));

      /* Empieza nodo:300 / Elemento padre: 299   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(300)).setAttribute("src","b.gif" );
      ((Element)v.get(300)).setAttribute("width","8" );
      ((Element)v.get(300)).setAttribute("height","8" );
      ((Element)v.get(299)).appendChild((Element)v.get(300));
      /* Termina nodo:300   */
      /* Termina nodo:299   */

      /* Empieza nodo:301 / Elemento padre: 296   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(301)).setAttribute("align","center" );
      ((Element)v.get(301)).setAttribute("width","8" );
      ((Element)v.get(296)).appendChild((Element)v.get(301));

      /* Empieza nodo:302 / Elemento padre: 301   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(302)).setAttribute("src","b.gif" );
      ((Element)v.get(302)).setAttribute("width","12" );
      ((Element)v.get(302)).setAttribute("height","8" );
      ((Element)v.get(301)).appendChild((Element)v.get(302));
      /* Termina nodo:302   */
      /* Termina nodo:301   */
      /* Termina nodo:296   */

      /* Empieza nodo:303 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(303)).setAttribute("nombre","formTr8" );
      ((Element)v.get(52)).appendChild((Element)v.get(303));

      /* Empieza nodo:304 / Elemento padre: 303   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(304)).setAttribute("align","center" );
      ((Element)v.get(304)).setAttribute("width","8" );
      ((Element)v.get(303)).appendChild((Element)v.get(304));

      /* Empieza nodo:305 / Elemento padre: 304   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(305)).setAttribute("src","b.gif" );
      ((Element)v.get(305)).setAttribute("width","8" );
      ((Element)v.get(305)).setAttribute("height","12" );
      ((Element)v.get(304)).appendChild((Element)v.get(305));
      /* Termina nodo:305   */
      /* Termina nodo:304   */

      /* Empieza nodo:306 / Elemento padre: 303   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(306)).setAttribute("width","100%" );
      ((Element)v.get(303)).appendChild((Element)v.get(306));

      /* Empieza nodo:307 / Elemento padre: 306   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(307)).setAttribute("width","100%" );
      ((Element)v.get(307)).setAttribute("border","0" );
      ((Element)v.get(307)).setAttribute("cellspacing","0" );
      ((Element)v.get(307)).setAttribute("cellpadding","0" );
      ((Element)v.get(307)).setAttribute("align","left" );
      ((Element)v.get(306)).appendChild((Element)v.get(307));

      /* Empieza nodo:308 / Elemento padre: 307   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(308)).setAttribute("align","left" );
      ((Element)v.get(307)).appendChild((Element)v.get(308));

      /* Empieza nodo:309 / Elemento padre: 308   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(309)).setAttribute("nombre","codNse2TdId" );
      ((Element)v.get(308)).appendChild((Element)v.get(309));

      /* Empieza nodo:310 / Elemento padre: 309   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(310)).setAttribute("width","100%" );
      ((Element)v.get(310)).setAttribute("border","0" );
      ((Element)v.get(310)).setAttribute("cellspacing","0" );
      ((Element)v.get(310)).setAttribute("cellpadding","0" );
      ((Element)v.get(310)).setAttribute("align","left" );
      ((Element)v.get(309)).appendChild((Element)v.get(310));

      /* Empieza nodo:311 / Elemento padre: 310   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(310)).appendChild((Element)v.get(311));

      /* Empieza nodo:312 / Elemento padre: 311   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(312)).setAttribute("valign","top" );
      ((Element)v.get(312)).setAttribute("height","13" );
      ((Element)v.get(311)).appendChild((Element)v.get(312));

      /* Empieza nodo:313 / Elemento padre: 312   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(313)).setAttribute("nombre","lblCodNse2" );
      ((Element)v.get(313)).setAttribute("alto","13" );
      ((Element)v.get(313)).setAttribute("filas","1" );
      ((Element)v.get(313)).setAttribute("id","datosTitle" );
      ((Element)v.get(313)).setAttribute("cod","ZonSubGerenVenta.codNse2.label" );
      ((Element)v.get(312)).appendChild((Element)v.get(313));
      /* Termina nodo:313   */
      /* Termina nodo:312   */
      /* Termina nodo:311   */

      /* Empieza nodo:314 / Elemento padre: 310   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(314)).setAttribute("nombre","codNse2WidgetTrId" );
      ((Element)v.get(310)).appendChild((Element)v.get(314));

      /* Empieza nodo:315 / Elemento padre: 314   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(315)).setAttribute("align","left" );
      ((Element)v.get(315)).setAttribute("nowrap","true" );
      ((Element)v.get(314)).appendChild((Element)v.get(315));

      /* Empieza nodo:316 / Elemento padre: 315   */
      v.add(doc.createElement("TEXT"));
   }

   private void getXML1440(Document doc) {
      ((Element)v.get(316)).setAttribute("nombre","codNse2" );
      ((Element)v.get(316)).setAttribute("id","datosCampos" );
      ((Element)v.get(316)).setAttribute("trim","S" );
      ((Element)v.get(316)).setAttribute("max","2" );
      ((Element)v.get(316)).setAttribute("onchange","" );
      ((Element)v.get(316)).setAttribute("req","N" );
      ((Element)v.get(316)).setAttribute("size","2" );
      ((Element)v.get(316)).setAttribute("valor","" );
      ((Element)v.get(316)).setAttribute("validacion","" );
      ((Element)v.get(316)).setAttribute("disabled","" );
      ((Element)v.get(316)).setAttribute("onblur","" );
      ((Element)v.get(316)).setAttribute("ontab","ejecutarAccionFoco('zonSubGerenVentaFrm',0, true)" );
      ((Element)v.get(316)).setAttribute("onshtab","ejecutarAccionFoco('zonSubGerenVentaFrm', 0, false)" );
      ((Element)v.get(315)).appendChild((Element)v.get(316));
      /* Termina nodo:316   */
      /* Termina nodo:315   */
      /* Termina nodo:314   */
      /* Termina nodo:310   */
      /* Termina nodo:309   */

      /* Empieza nodo:317 / Elemento padre: 308   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(317)).setAttribute("nombre","codNse2GapTdId" );
      ((Element)v.get(317)).setAttribute("nowrap","true" );
      ((Element)v.get(317)).setAttribute("class","datosCampos" );
      ((Element)v.get(308)).appendChild((Element)v.get(317));

      /* Empieza nodo:318 / Elemento padre: 317   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(318)).setAttribute("src","b.gif" );
      ((Element)v.get(318)).setAttribute("width","25" );
      ((Element)v.get(318)).setAttribute("height","8" );
      ((Element)v.get(317)).appendChild((Element)v.get(318));
      /* Termina nodo:318   */
      /* Termina nodo:317   */

      /* Empieza nodo:319 / Elemento padre: 308   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(319)).setAttribute("width","100%" );
      ((Element)v.get(308)).appendChild((Element)v.get(319));

      /* Empieza nodo:320 / Elemento padre: 319   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(320)).setAttribute("src","b.gif" );
      ((Element)v.get(319)).appendChild((Element)v.get(320));
      /* Termina nodo:320   */
      /* Termina nodo:319   */
      /* Termina nodo:308   */
      /* Termina nodo:307   */
      /* Termina nodo:306   */
      /* Termina nodo:303   */

      /* Empieza nodo:321 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(321)).setAttribute("nombre","formGapTr8" );
      ((Element)v.get(52)).appendChild((Element)v.get(321));

      /* Empieza nodo:322 / Elemento padre: 321   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(322)).setAttribute("align","center" );
      ((Element)v.get(322)).setAttribute("width","8" );
      ((Element)v.get(321)).appendChild((Element)v.get(322));

      /* Empieza nodo:323 / Elemento padre: 322   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(323)).setAttribute("src","b.gif" );
      ((Element)v.get(323)).setAttribute("width","12" );
      ((Element)v.get(323)).setAttribute("height","8" );
      ((Element)v.get(322)).appendChild((Element)v.get(323));
      /* Termina nodo:323   */
      /* Termina nodo:322   */

      /* Empieza nodo:324 / Elemento padre: 321   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(321)).appendChild((Element)v.get(324));

      /* Empieza nodo:325 / Elemento padre: 324   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(325)).setAttribute("src","b.gif" );
      ((Element)v.get(325)).setAttribute("width","8" );
      ((Element)v.get(325)).setAttribute("height","8" );
      ((Element)v.get(324)).appendChild((Element)v.get(325));
      /* Termina nodo:325   */
      /* Termina nodo:324   */

      /* Empieza nodo:326 / Elemento padre: 321   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(326)).setAttribute("align","center" );
      ((Element)v.get(326)).setAttribute("width","8" );
      ((Element)v.get(321)).appendChild((Element)v.get(326));

      /* Empieza nodo:327 / Elemento padre: 326   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(327)).setAttribute("src","b.gif" );
      ((Element)v.get(327)).setAttribute("width","12" );
      ((Element)v.get(327)).setAttribute("height","8" );
      ((Element)v.get(326)).appendChild((Element)v.get(327));
      /* Termina nodo:327   */
      /* Termina nodo:326   */
      /* Termina nodo:321   */

      /* Empieza nodo:328 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(328)).setAttribute("nombre","formTr9" );
      ((Element)v.get(52)).appendChild((Element)v.get(328));

      /* Empieza nodo:329 / Elemento padre: 328   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(329)).setAttribute("align","center" );
      ((Element)v.get(329)).setAttribute("width","8" );
      ((Element)v.get(328)).appendChild((Element)v.get(329));

      /* Empieza nodo:330 / Elemento padre: 329   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(330)).setAttribute("src","b.gif" );
      ((Element)v.get(330)).setAttribute("width","8" );
      ((Element)v.get(330)).setAttribute("height","12" );
      ((Element)v.get(329)).appendChild((Element)v.get(330));
      /* Termina nodo:330   */
      /* Termina nodo:329   */

      /* Empieza nodo:331 / Elemento padre: 328   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(331)).setAttribute("width","100%" );
      ((Element)v.get(328)).appendChild((Element)v.get(331));

      /* Empieza nodo:332 / Elemento padre: 331   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(332)).setAttribute("width","100%" );
      ((Element)v.get(332)).setAttribute("border","0" );
      ((Element)v.get(332)).setAttribute("cellspacing","0" );
      ((Element)v.get(332)).setAttribute("cellpadding","0" );
      ((Element)v.get(332)).setAttribute("align","left" );
      ((Element)v.get(331)).appendChild((Element)v.get(332));

      /* Empieza nodo:333 / Elemento padre: 332   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(333)).setAttribute("align","left" );
      ((Element)v.get(332)).appendChild((Element)v.get(333));

      /* Empieza nodo:334 / Elemento padre: 333   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(334)).setAttribute("nombre","codNse3TdId" );
      ((Element)v.get(333)).appendChild((Element)v.get(334));

      /* Empieza nodo:335 / Elemento padre: 334   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(335)).setAttribute("width","100%" );
      ((Element)v.get(335)).setAttribute("border","0" );
      ((Element)v.get(335)).setAttribute("cellspacing","0" );
   }

   private void getXML1530(Document doc) {
      ((Element)v.get(335)).setAttribute("cellpadding","0" );
      ((Element)v.get(335)).setAttribute("align","left" );
      ((Element)v.get(334)).appendChild((Element)v.get(335));

      /* Empieza nodo:336 / Elemento padre: 335   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(335)).appendChild((Element)v.get(336));

      /* Empieza nodo:337 / Elemento padre: 336   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(337)).setAttribute("valign","top" );
      ((Element)v.get(337)).setAttribute("height","13" );
      ((Element)v.get(336)).appendChild((Element)v.get(337));

      /* Empieza nodo:338 / Elemento padre: 337   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(338)).setAttribute("nombre","lblCodNse3" );
      ((Element)v.get(338)).setAttribute("alto","13" );
      ((Element)v.get(338)).setAttribute("filas","1" );
      ((Element)v.get(338)).setAttribute("id","datosTitle" );
      ((Element)v.get(338)).setAttribute("cod","ZonSubGerenVenta.codNse3.label" );
      ((Element)v.get(337)).appendChild((Element)v.get(338));
      /* Termina nodo:338   */
      /* Termina nodo:337   */
      /* Termina nodo:336   */

      /* Empieza nodo:339 / Elemento padre: 335   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(339)).setAttribute("nombre","codNse3WidgetTrId" );
      ((Element)v.get(335)).appendChild((Element)v.get(339));

      /* Empieza nodo:340 / Elemento padre: 339   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(340)).setAttribute("align","left" );
      ((Element)v.get(340)).setAttribute("nowrap","true" );
      ((Element)v.get(339)).appendChild((Element)v.get(340));

      /* Empieza nodo:341 / Elemento padre: 340   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(341)).setAttribute("nombre","codNse3" );
      ((Element)v.get(341)).setAttribute("id","datosCampos" );
      ((Element)v.get(341)).setAttribute("trim","S" );
      ((Element)v.get(341)).setAttribute("max","2" );
      ((Element)v.get(341)).setAttribute("onchange","" );
      ((Element)v.get(341)).setAttribute("req","N" );
      ((Element)v.get(341)).setAttribute("size","2" );
      ((Element)v.get(341)).setAttribute("valor","" );
      ((Element)v.get(341)).setAttribute("validacion","" );
      ((Element)v.get(341)).setAttribute("disabled","" );
      ((Element)v.get(341)).setAttribute("onblur","" );
      ((Element)v.get(341)).setAttribute("ontab","ejecutarAccionFoco('zonSubGerenVentaFrm',0, true)" );
      ((Element)v.get(341)).setAttribute("onshtab","ejecutarAccionFoco('zonSubGerenVentaFrm', 0, false)" );
      ((Element)v.get(340)).appendChild((Element)v.get(341));
      /* Termina nodo:341   */
      /* Termina nodo:340   */
      /* Termina nodo:339   */
      /* Termina nodo:335   */
      /* Termina nodo:334   */

      /* Empieza nodo:342 / Elemento padre: 333   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(342)).setAttribute("nombre","codNse3GapTdId" );
      ((Element)v.get(342)).setAttribute("nowrap","true" );
      ((Element)v.get(342)).setAttribute("class","datosCampos" );
      ((Element)v.get(333)).appendChild((Element)v.get(342));

      /* Empieza nodo:343 / Elemento padre: 342   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(343)).setAttribute("src","b.gif" );
      ((Element)v.get(343)).setAttribute("width","25" );
      ((Element)v.get(343)).setAttribute("height","8" );
      ((Element)v.get(342)).appendChild((Element)v.get(343));
      /* Termina nodo:343   */
      /* Termina nodo:342   */

      /* Empieza nodo:344 / Elemento padre: 333   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(344)).setAttribute("width","100%" );
      ((Element)v.get(333)).appendChild((Element)v.get(344));

      /* Empieza nodo:345 / Elemento padre: 344   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(345)).setAttribute("src","b.gif" );
      ((Element)v.get(344)).appendChild((Element)v.get(345));
      /* Termina nodo:345   */
      /* Termina nodo:344   */
      /* Termina nodo:333   */
      /* Termina nodo:332   */
      /* Termina nodo:331   */
      /* Termina nodo:328   */

      /* Empieza nodo:346 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(346)).setAttribute("nombre","formGapTr9" );
      ((Element)v.get(52)).appendChild((Element)v.get(346));

      /* Empieza nodo:347 / Elemento padre: 346   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(347)).setAttribute("align","center" );
      ((Element)v.get(347)).setAttribute("width","8" );
      ((Element)v.get(346)).appendChild((Element)v.get(347));

      /* Empieza nodo:348 / Elemento padre: 347   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(348)).setAttribute("src","b.gif" );
      ((Element)v.get(348)).setAttribute("width","12" );
      ((Element)v.get(348)).setAttribute("height","8" );
      ((Element)v.get(347)).appendChild((Element)v.get(348));
      /* Termina nodo:348   */
      /* Termina nodo:347   */

      /* Empieza nodo:349 / Elemento padre: 346   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(346)).appendChild((Element)v.get(349));

      /* Empieza nodo:350 / Elemento padre: 349   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(350)).setAttribute("src","b.gif" );
      ((Element)v.get(350)).setAttribute("width","8" );
      ((Element)v.get(350)).setAttribute("height","8" );
      ((Element)v.get(349)).appendChild((Element)v.get(350));
      /* Termina nodo:350   */
      /* Termina nodo:349   */

      /* Empieza nodo:351 / Elemento padre: 346   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(351)).setAttribute("align","center" );
      ((Element)v.get(351)).setAttribute("width","8" );
      ((Element)v.get(346)).appendChild((Element)v.get(351));

      /* Empieza nodo:352 / Elemento padre: 351   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(352)).setAttribute("src","b.gif" );
      ((Element)v.get(352)).setAttribute("width","12" );
      ((Element)v.get(352)).setAttribute("height","8" );
      ((Element)v.get(351)).appendChild((Element)v.get(352));
      /* Termina nodo:352   */
      /* Termina nodo:351   */
      /* Termina nodo:346   */

      /* Empieza nodo:353 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(353)).setAttribute("nombre","formTr10" );
      ((Element)v.get(52)).appendChild((Element)v.get(353));

      /* Empieza nodo:354 / Elemento padre: 353   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(354)).setAttribute("align","center" );
      ((Element)v.get(354)).setAttribute("width","8" );
      ((Element)v.get(353)).appendChild((Element)v.get(354));

      /* Empieza nodo:355 / Elemento padre: 354   */
      v.add(doc.createElement("IMG"));
   }

   private void getXML1620(Document doc) {
      ((Element)v.get(355)).setAttribute("src","b.gif" );
      ((Element)v.get(355)).setAttribute("width","8" );
      ((Element)v.get(355)).setAttribute("height","12" );
      ((Element)v.get(354)).appendChild((Element)v.get(355));
      /* Termina nodo:355   */
      /* Termina nodo:354   */

      /* Empieza nodo:356 / Elemento padre: 353   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(356)).setAttribute("width","100%" );
      ((Element)v.get(353)).appendChild((Element)v.get(356));

      /* Empieza nodo:357 / Elemento padre: 356   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(357)).setAttribute("width","100%" );
      ((Element)v.get(357)).setAttribute("border","0" );
      ((Element)v.get(357)).setAttribute("cellspacing","0" );
      ((Element)v.get(357)).setAttribute("cellpadding","0" );
      ((Element)v.get(357)).setAttribute("align","left" );
      ((Element)v.get(356)).appendChild((Element)v.get(357));

      /* Empieza nodo:358 / Elemento padre: 357   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(358)).setAttribute("align","left" );
      ((Element)v.get(357)).appendChild((Element)v.get(358));

      /* Empieza nodo:359 / Elemento padre: 358   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(359)).setAttribute("nombre","desSubgVentTdId" );
      ((Element)v.get(358)).appendChild((Element)v.get(359));

      /* Empieza nodo:360 / Elemento padre: 359   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(360)).setAttribute("width","100%" );
      ((Element)v.get(360)).setAttribute("border","0" );
      ((Element)v.get(360)).setAttribute("cellspacing","0" );
      ((Element)v.get(360)).setAttribute("cellpadding","0" );
      ((Element)v.get(360)).setAttribute("align","left" );
      ((Element)v.get(359)).appendChild((Element)v.get(360));

      /* Empieza nodo:361 / Elemento padre: 360   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(360)).appendChild((Element)v.get(361));

      /* Empieza nodo:362 / Elemento padre: 361   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(362)).setAttribute("valign","top" );
      ((Element)v.get(362)).setAttribute("height","13" );
      ((Element)v.get(361)).appendChild((Element)v.get(362));

      /* Empieza nodo:363 / Elemento padre: 362   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(363)).setAttribute("nombre","lblDesSubgVent" );
      ((Element)v.get(363)).setAttribute("alto","13" );
      ((Element)v.get(363)).setAttribute("filas","1" );
      ((Element)v.get(363)).setAttribute("id","datosTitle" );
      ((Element)v.get(363)).setAttribute("cod","ZonSubGerenVenta.desSubgVent.label" );
      ((Element)v.get(362)).appendChild((Element)v.get(363));
      /* Termina nodo:363   */
      /* Termina nodo:362   */
      /* Termina nodo:361   */

      /* Empieza nodo:364 / Elemento padre: 360   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(364)).setAttribute("nombre","desSubgVentWidgetTrId" );
      ((Element)v.get(360)).appendChild((Element)v.get(364));

      /* Empieza nodo:365 / Elemento padre: 364   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(365)).setAttribute("align","left" );
      ((Element)v.get(365)).setAttribute("nowrap","true" );
      ((Element)v.get(364)).appendChild((Element)v.get(365));

      /* Empieza nodo:366 / Elemento padre: 365   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(366)).setAttribute("nombre","desSubgVent" );
      ((Element)v.get(366)).setAttribute("id","datosCampos" );
      ((Element)v.get(366)).setAttribute("trim","S" );
      ((Element)v.get(366)).setAttribute("max","40" );
      ((Element)v.get(366)).setAttribute("onchange","" );
      ((Element)v.get(366)).setAttribute("req","N" );
      ((Element)v.get(366)).setAttribute("size","40" );
      ((Element)v.get(366)).setAttribute("valor","" );
      ((Element)v.get(366)).setAttribute("validacion","" );
      ((Element)v.get(366)).setAttribute("disabled","" );
      ((Element)v.get(366)).setAttribute("onblur","" );
      ((Element)v.get(366)).setAttribute("ontab","ejecutarAccionFoco('zonSubGerenVentaFrm',0, true)" );
      ((Element)v.get(366)).setAttribute("onshtab","ejecutarAccionFoco('zonSubGerenVentaFrm', 0, false)" );
      ((Element)v.get(365)).appendChild((Element)v.get(366));
      /* Termina nodo:366   */
      /* Termina nodo:365   */
      /* Termina nodo:364   */
      /* Termina nodo:360   */
      /* Termina nodo:359   */

      /* Empieza nodo:367 / Elemento padre: 358   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(367)).setAttribute("nombre","desSubgVentGapTdId" );
      ((Element)v.get(367)).setAttribute("nowrap","true" );
      ((Element)v.get(367)).setAttribute("class","datosCampos" );
      ((Element)v.get(358)).appendChild((Element)v.get(367));

      /* Empieza nodo:368 / Elemento padre: 367   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(368)).setAttribute("src","b.gif" );
      ((Element)v.get(368)).setAttribute("width","25" );
      ((Element)v.get(368)).setAttribute("height","8" );
      ((Element)v.get(367)).appendChild((Element)v.get(368));
      /* Termina nodo:368   */
      /* Termina nodo:367   */

      /* Empieza nodo:369 / Elemento padre: 358   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(369)).setAttribute("width","100%" );
      ((Element)v.get(358)).appendChild((Element)v.get(369));

      /* Empieza nodo:370 / Elemento padre: 369   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(370)).setAttribute("src","b.gif" );
      ((Element)v.get(369)).appendChild((Element)v.get(370));
      /* Termina nodo:370   */
      /* Termina nodo:369   */
      /* Termina nodo:358   */
      /* Termina nodo:357   */
      /* Termina nodo:356   */
      /* Termina nodo:353   */

      /* Empieza nodo:371 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(371)).setAttribute("nombre","formGapTr10" );
      ((Element)v.get(52)).appendChild((Element)v.get(371));

      /* Empieza nodo:372 / Elemento padre: 371   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(372)).setAttribute("align","center" );
      ((Element)v.get(372)).setAttribute("width","8" );
      ((Element)v.get(371)).appendChild((Element)v.get(372));

      /* Empieza nodo:373 / Elemento padre: 372   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(373)).setAttribute("src","b.gif" );
      ((Element)v.get(373)).setAttribute("width","12" );
      ((Element)v.get(373)).setAttribute("height","8" );
      ((Element)v.get(372)).appendChild((Element)v.get(373));
      /* Termina nodo:373   */
      /* Termina nodo:372   */

      /* Empieza nodo:374 / Elemento padre: 371   */
   }

   private void getXML1710(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(371)).appendChild((Element)v.get(374));

      /* Empieza nodo:375 / Elemento padre: 374   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(375)).setAttribute("src","b.gif" );
      ((Element)v.get(375)).setAttribute("width","8" );
      ((Element)v.get(375)).setAttribute("height","8" );
      ((Element)v.get(374)).appendChild((Element)v.get(375));
      /* Termina nodo:375   */
      /* Termina nodo:374   */

      /* Empieza nodo:376 / Elemento padre: 371   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(376)).setAttribute("align","center" );
      ((Element)v.get(376)).setAttribute("width","8" );
      ((Element)v.get(371)).appendChild((Element)v.get(376));

      /* Empieza nodo:377 / Elemento padre: 376   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(377)).setAttribute("src","b.gif" );
      ((Element)v.get(377)).setAttribute("width","12" );
      ((Element)v.get(377)).setAttribute("height","8" );
      ((Element)v.get(376)).appendChild((Element)v.get(377));
      /* Termina nodo:377   */
      /* Termina nodo:376   */
      /* Termina nodo:371   */

      /* Empieza nodo:378 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(378)).setAttribute("nombre","formTr11" );
      ((Element)v.get(52)).appendChild((Element)v.get(378));

      /* Empieza nodo:379 / Elemento padre: 378   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(379)).setAttribute("align","center" );
      ((Element)v.get(379)).setAttribute("width","8" );
      ((Element)v.get(378)).appendChild((Element)v.get(379));

      /* Empieza nodo:380 / Elemento padre: 379   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(380)).setAttribute("src","b.gif" );
      ((Element)v.get(380)).setAttribute("width","8" );
      ((Element)v.get(380)).setAttribute("height","12" );
      ((Element)v.get(379)).appendChild((Element)v.get(380));
      /* Termina nodo:380   */
      /* Termina nodo:379   */

      /* Empieza nodo:381 / Elemento padre: 378   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(381)).setAttribute("width","100%" );
      ((Element)v.get(378)).appendChild((Element)v.get(381));

      /* Empieza nodo:382 / Elemento padre: 381   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(382)).setAttribute("width","100%" );
      ((Element)v.get(382)).setAttribute("border","0" );
      ((Element)v.get(382)).setAttribute("cellspacing","0" );
      ((Element)v.get(382)).setAttribute("cellpadding","0" );
      ((Element)v.get(382)).setAttribute("align","left" );
      ((Element)v.get(381)).appendChild((Element)v.get(382));

      /* Empieza nodo:383 / Elemento padre: 382   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(383)).setAttribute("align","left" );
      ((Element)v.get(382)).appendChild((Element)v.get(383));

      /* Empieza nodo:384 / Elemento padre: 383   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(384)).setAttribute("nombre","clieOidClieTdId" );
      ((Element)v.get(383)).appendChild((Element)v.get(384));

      /* Empieza nodo:385 / Elemento padre: 384   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(385)).setAttribute("border","0" );
      ((Element)v.get(385)).setAttribute("cellspacing","0" );
      ((Element)v.get(385)).setAttribute("cellpadding","0" );
      ((Element)v.get(385)).setAttribute("align","left" );
      ((Element)v.get(384)).appendChild((Element)v.get(385));

      /* Empieza nodo:386 / Elemento padre: 385   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(385)).appendChild((Element)v.get(386));

      /* Empieza nodo:387 / Elemento padre: 386   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(387)).setAttribute("valign","top" );
      ((Element)v.get(387)).setAttribute("height","13" );
      ((Element)v.get(386)).appendChild((Element)v.get(387));

      /* Empieza nodo:388 / Elemento padre: 387   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(388)).setAttribute("nombre","lblclieOidClie" );
      ((Element)v.get(388)).setAttribute("id","datosTitle" );
      ((Element)v.get(388)).setAttribute("ancho","100" );
      ((Element)v.get(388)).setAttribute("alto","13" );
      ((Element)v.get(388)).setAttribute("cod","ZonSubGerenVenta.clieOidClie.label" );
      ((Element)v.get(387)).appendChild((Element)v.get(388));
      /* Termina nodo:388   */
      /* Termina nodo:387   */
      /* Termina nodo:386   */

      /* Empieza nodo:389 / Elemento padre: 385   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(389)).setAttribute("nombre","clieOidClieWidgetTrId" );
      ((Element)v.get(385)).appendChild((Element)v.get(389));

      /* Empieza nodo:390 / Elemento padre: 389   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(390)).setAttribute("align","left" );
      ((Element)v.get(390)).setAttribute("nowrap","true" );
      ((Element)v.get(389)).appendChild((Element)v.get(390));

      /* Empieza nodo:391 / Elemento padre: 390   */
      v.add(doc.createElement("COMBO"));
      ((Element)v.get(391)).setAttribute("nombre","clieOidClie" );
      ((Element)v.get(391)).setAttribute("id","datosCampos" );
      ((Element)v.get(391)).setAttribute("multiple","N" );
      ((Element)v.get(391)).setAttribute("req","N" );
      ((Element)v.get(391)).setAttribute("size","1" );
      ((Element)v.get(391)).setAttribute("disabled","" );
      ((Element)v.get(391)).setAttribute("validacion","" );
      ((Element)v.get(391)).setAttribute("onchange","" );
      ((Element)v.get(391)).setAttribute("onfocus","" );
      ((Element)v.get(391)).setAttribute("valorinicial","" );
      ((Element)v.get(391)).setAttribute("textoinicial","" );
      ((Element)v.get(391)).setAttribute("ontab","ejecutarAccionFoco('zonSubGerenVentaFrm',0, true);" );
      ((Element)v.get(391)).setAttribute("onshtab","ejecutarAccionFoco('zonSubGerenVentaFrm',0, false);" );
      ((Element)v.get(390)).appendChild((Element)v.get(391));

      /* Empieza nodo:392 / Elemento padre: 391   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(391)).appendChild((Element)v.get(392));
      /* Termina nodo:392   */
      /* Termina nodo:391   */
      /* Termina nodo:390   */
      /* Termina nodo:389   */
      /* Termina nodo:385   */
      /* Termina nodo:384   */

      /* Empieza nodo:393 / Elemento padre: 383   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(393)).setAttribute("nombre","clieOidClieGapTdId" );
      ((Element)v.get(393)).setAttribute("nowrap","true" );
   }

   private void getXML1800(Document doc) {
      ((Element)v.get(393)).setAttribute("class","datosCampos" );
      ((Element)v.get(383)).appendChild((Element)v.get(393));

      /* Empieza nodo:394 / Elemento padre: 393   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(394)).setAttribute("src","b.gif" );
      ((Element)v.get(394)).setAttribute("width","25" );
      ((Element)v.get(394)).setAttribute("height","8" );
      ((Element)v.get(393)).appendChild((Element)v.get(394));
      /* Termina nodo:394   */
      /* Termina nodo:393   */

      /* Empieza nodo:395 / Elemento padre: 383   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(395)).setAttribute("width","100%" );
      ((Element)v.get(383)).appendChild((Element)v.get(395));

      /* Empieza nodo:396 / Elemento padre: 395   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(396)).setAttribute("src","b.gif" );
      ((Element)v.get(395)).appendChild((Element)v.get(396));
      /* Termina nodo:396   */
      /* Termina nodo:395   */
      /* Termina nodo:383   */
      /* Termina nodo:382   */
      /* Termina nodo:381   */
      /* Termina nodo:378   */

      /* Empieza nodo:397 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(397)).setAttribute("nombre","formGapTr11" );
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
      ((Element)v.get(404)).setAttribute("nombre","formTr12" );
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
      ((Element)v.get(410)).setAttribute("nombre","fecRezoTdId" );
      ((Element)v.get(409)).appendChild((Element)v.get(410));

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
      ((Element)v.get(411)).appendChild((Element)v.get(412));

      /* Empieza nodo:413 / Elemento padre: 412   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(413)).setAttribute("valign","top" );
      ((Element)v.get(413)).setAttribute("height","13" );
      ((Element)v.get(412)).appendChild((Element)v.get(413));

      /* Empieza nodo:414 / Elemento padre: 413   */
      v.add(doc.createElement("LABELC"));
      ((Element)v.get(414)).setAttribute("nombre","lblFecRezo" );
      ((Element)v.get(414)).setAttribute("alto","13" );
      ((Element)v.get(414)).setAttribute("filas","1" );
      ((Element)v.get(414)).setAttribute("id","datosTitle" );
      ((Element)v.get(414)).setAttribute("cod","ZonSubGerenVenta.fecRezo.label" );
      ((Element)v.get(413)).appendChild((Element)v.get(414));
      /* Termina nodo:414   */
      /* Termina nodo:413   */
      /* Termina nodo:412   */

      /* Empieza nodo:415 / Elemento padre: 411   */
      v.add(doc.createElement("TR"));
   }

   private void getXML1890(Document doc) {
      ((Element)v.get(415)).setAttribute("nombre","fecRezoWidgetTrId" );
      ((Element)v.get(411)).appendChild((Element)v.get(415));

      /* Empieza nodo:416 / Elemento padre: 415   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(416)).setAttribute("align","left" );
      ((Element)v.get(416)).setAttribute("nowrap","true" );
      ((Element)v.get(415)).appendChild((Element)v.get(416));

      /* Empieza nodo:417 / Elemento padre: 416   */
      v.add(doc.createElement("TEXT"));
      ((Element)v.get(417)).setAttribute("nombre","fecRezo" );
      ((Element)v.get(417)).setAttribute("id","datosCampos" );
      ((Element)v.get(417)).setAttribute("trim","S" );
      ((Element)v.get(417)).setAttribute("max","7" );
      ((Element)v.get(417)).setAttribute("onchange","" );
      ((Element)v.get(417)).setAttribute("req","N" );
      ((Element)v.get(417)).setAttribute("size","7" );
      ((Element)v.get(417)).setAttribute("valor","" );
      ((Element)v.get(417)).setAttribute("validacion","" );
      ((Element)v.get(417)).setAttribute("disabled","" );
      ((Element)v.get(417)).setAttribute("onblur","" );
      ((Element)v.get(417)).setAttribute("ontab","ejecutarAccionFoco('zonSubGerenVentaFrm',0, true)" );
      ((Element)v.get(417)).setAttribute("onshtab","ejecutarAccionFoco('zonSubGerenVentaFrm', 0, false)" );
      ((Element)v.get(416)).appendChild((Element)v.get(417));
      /* Termina nodo:417   */
      /* Termina nodo:416   */
      /* Termina nodo:415   */
      /* Termina nodo:411   */
      /* Termina nodo:410   */

      /* Empieza nodo:418 / Elemento padre: 409   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(418)).setAttribute("nombre","fecRezoGapTdId" );
      ((Element)v.get(418)).setAttribute("nowrap","true" );
      ((Element)v.get(418)).setAttribute("class","datosCampos" );
      ((Element)v.get(409)).appendChild((Element)v.get(418));

      /* Empieza nodo:419 / Elemento padre: 418   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(419)).setAttribute("src","b.gif" );
      ((Element)v.get(419)).setAttribute("width","25" );
      ((Element)v.get(419)).setAttribute("height","8" );
      ((Element)v.get(418)).appendChild((Element)v.get(419));
      /* Termina nodo:419   */
      /* Termina nodo:418   */

      /* Empieza nodo:420 / Elemento padre: 409   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(420)).setAttribute("width","100%" );
      ((Element)v.get(409)).appendChild((Element)v.get(420));

      /* Empieza nodo:421 / Elemento padre: 420   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(421)).setAttribute("src","b.gif" );
      ((Element)v.get(420)).appendChild((Element)v.get(421));
      /* Termina nodo:421   */
      /* Termina nodo:420   */
      /* Termina nodo:409   */
      /* Termina nodo:408   */
      /* Termina nodo:407   */

      /* Empieza nodo:422 / Elemento padre: 404   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(422)).setAttribute("width","100%" );
      ((Element)v.get(404)).appendChild((Element)v.get(422));
      /* Termina nodo:422   */
      /* Termina nodo:404   */

      /* Empieza nodo:423 / Elemento padre: 52   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(423)).setAttribute("nombre","formGapTr12" );
      ((Element)v.get(52)).appendChild((Element)v.get(423));

      /* Empieza nodo:424 / Elemento padre: 423   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(424)).setAttribute("align","center" );
      ((Element)v.get(424)).setAttribute("width","8" );
      ((Element)v.get(423)).appendChild((Element)v.get(424));

      /* Empieza nodo:425 / Elemento padre: 424   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(425)).setAttribute("src","b.gif" );
      ((Element)v.get(425)).setAttribute("width","8" );
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
      ((Element)v.get(429)).setAttribute("width","8" );
      ((Element)v.get(429)).setAttribute("height","8" );
      ((Element)v.get(428)).appendChild((Element)v.get(429));
      /* Termina nodo:429   */
      /* Termina nodo:428   */
      /* Termina nodo:423   */
      /* Termina nodo:52   */
      /* Termina nodo:49   */
      /* Termina nodo:48   */

      /* Empieza nodo:430 / Elemento padre: 45   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(430)).setAttribute("align","center" );
      ((Element)v.get(430)).setAttribute("width","12" );
      ((Element)v.get(45)).appendChild((Element)v.get(430));

      /* Empieza nodo:431 / Elemento padre: 430   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(431)).setAttribute("src","b.gif" );
      ((Element)v.get(431)).setAttribute("width","12" );
      ((Element)v.get(431)).setAttribute("height","12" );
      ((Element)v.get(430)).appendChild((Element)v.get(431));
      /* Termina nodo:431   */
      /* Termina nodo:430   */
      /* Termina nodo:45   */

      /* Empieza nodo:432 / Elemento padre: 37   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(432)).setAttribute("nombre","zonSubGerenVentaTrButtons" );
      ((Element)v.get(37)).appendChild((Element)v.get(432));

      /* Empieza nodo:433 / Elemento padre: 432   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(433)).setAttribute("align","center" );
      ((Element)v.get(433)).setAttribute("width","12" );
      ((Element)v.get(432)).appendChild((Element)v.get(433));

      /* Empieza nodo:434 / Elemento padre: 433   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(434)).setAttribute("src","b.gif" );
      ((Element)v.get(434)).setAttribute("width","12" );
      ((Element)v.get(434)).setAttribute("height","12" );
      ((Element)v.get(433)).appendChild((Element)v.get(434));
      /* Termina nodo:434   */
      /* Termina nodo:433   */

      /* Empieza nodo:435 / Elemento padre: 432   */
      v.add(doc.createElement("TD"));
   }

   private void getXML1980(Document doc) {
      ((Element)v.get(432)).appendChild((Element)v.get(435));

      /* Empieza nodo:436 / Elemento padre: 435   */
      v.add(doc.createElement("FIELDSET"));
      ((Element)v.get(435)).appendChild((Element)v.get(436));

      /* Empieza nodo:437 / Elemento padre: 436   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(437)).setAttribute("width","100%" );
      ((Element)v.get(437)).setAttribute("border","0" );
      ((Element)v.get(437)).setAttribute("align","center" );
      ((Element)v.get(437)).setAttribute("cellspacing","0" );
      ((Element)v.get(437)).setAttribute("cellpadding","0" );
      ((Element)v.get(436)).appendChild((Element)v.get(437));

      /* Empieza nodo:438 / Elemento padre: 437   */
      v.add(doc.createElement("TR"));
      ((Element)v.get(437)).appendChild((Element)v.get(438));

      /* Empieza nodo:439 / Elemento padre: 438   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(439)).setAttribute("class","tablaTitle" );
      ((Element)v.get(439)).setAttribute("nombre","zonSubGerenVentaTdQueryButton" );
      ((Element)v.get(438)).appendChild((Element)v.get(439));

      /* Empieza nodo:440 / Elemento padre: 439   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(440)).setAttribute("nombre","zonSubGerenVentaQueryButton" );
      ((Element)v.get(440)).setAttribute("cod","MMGGlobal.queryButton.label" );
      ((Element)v.get(440)).setAttribute("estado","false" );
      ((Element)v.get(440)).setAttribute("accion","zonSubGerenVentaFirstPage();" );
      ((Element)v.get(440)).setAttribute("tipo","html" );
      ((Element)v.get(440)).setAttribute("ID","botonContenido" );
      ((Element)v.get(439)).appendChild((Element)v.get(440));
      /* Termina nodo:440   */
      /* Termina nodo:439   */

      /* Empieza nodo:441 / Elemento padre: 438   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(441)).setAttribute("class","tablaTitle" );
      ((Element)v.get(441)).setAttribute("nombre","zonSubGerenVentaTdLovNullSelectionButton" );
      ((Element)v.get(441)).setAttribute("align","left" );
      ((Element)v.get(441)).setAttribute("width","100%" );
      ((Element)v.get(438)).appendChild((Element)v.get(441));

      /* Empieza nodo:442 / Elemento padre: 441   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(442)).setAttribute("src","b.gif" );
      ((Element)v.get(442)).setAttribute("height","8" );
      ((Element)v.get(442)).setAttribute("width","8" );
      ((Element)v.get(441)).appendChild((Element)v.get(442));
      /* Termina nodo:442   */

      /* Empieza nodo:443 / Elemento padre: 441   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(443)).setAttribute("nombre","zonSubGerenVentaLovNullButton" );
      ((Element)v.get(443)).setAttribute("ID","botonContenido" );
      ((Element)v.get(443)).setAttribute("tipo","html" );
      ((Element)v.get(443)).setAttribute("accion","zonSubGerenVentaLovNullSelectionAction();" );
      ((Element)v.get(443)).setAttribute("estado","true" );
      ((Element)v.get(443)).setAttribute("cod","MMGGlobal.lovNullButton.label" );
      ((Element)v.get(441)).appendChild((Element)v.get(443));
      /* Termina nodo:443   */
      /* Termina nodo:441   */
      /* Termina nodo:438   */
      /* Termina nodo:437   */
      /* Termina nodo:436   */
      /* Termina nodo:435   */

      /* Empieza nodo:444 / Elemento padre: 432   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(444)).setAttribute("align","center" );
      ((Element)v.get(444)).setAttribute("width","12" );
      ((Element)v.get(432)).appendChild((Element)v.get(444));

      /* Empieza nodo:445 / Elemento padre: 444   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(445)).setAttribute("src","b.gif" );
      ((Element)v.get(445)).setAttribute("width","12" );
      ((Element)v.get(445)).setAttribute("height","12" );
      ((Element)v.get(444)).appendChild((Element)v.get(445));
      /* Termina nodo:445   */
      /* Termina nodo:444   */
      /* Termina nodo:432   */
      /* Termina nodo:37   */
      /* Termina nodo:36   */

      /* Empieza nodo:446 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(446)).setAttribute("nombre","zonSubGerenVentaListLayer" );
      ((Element)v.get(446)).setAttribute("alto","310" );
      ((Element)v.get(446)).setAttribute("ancho","99%" );
      ((Element)v.get(446)).setAttribute("colorf","" );
      ((Element)v.get(446)).setAttribute("borde","0" );
      ((Element)v.get(446)).setAttribute("imagenf","" );
      ((Element)v.get(446)).setAttribute("repeat","" );
      ((Element)v.get(446)).setAttribute("padding","" );
      ((Element)v.get(446)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(446)).setAttribute("contravsb","" );
      ((Element)v.get(446)).setAttribute("x","3" );
      ((Element)v.get(446)).setAttribute("y","" );
      ((Element)v.get(446)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(446));

      /* Empieza nodo:447 / Elemento padre: 446   */
      v.add(doc.createElement("LISTAEDITABLE"));
      ((Element)v.get(447)).setAttribute("nombre","zonSubGerenVentaList" );
      ((Element)v.get(447)).setAttribute("ancho","680" );
      ((Element)v.get(447)).setAttribute("alto","275" );
      ((Element)v.get(447)).setAttribute("x","12" );
      ((Element)v.get(447)).setAttribute("y","0" );
      ((Element)v.get(447)).setAttribute("colorFondo","#CECFCE" );
      ((Element)v.get(447)).setAttribute("msgDebugJS","S" );
      ((Element)v.get(446)).appendChild((Element)v.get(447));

      /* Empieza nodo:448 / Elemento padre: 447   */
      v.add(doc.createElement("IMGBOTONES"));
      ((Element)v.get(448)).setAttribute("precarga","S" );
      ((Element)v.get(448)).setAttribute("conROver","S" );
      ((Element)v.get(447)).appendChild((Element)v.get(448));

      /* Empieza nodo:449 / Elemento padre: 448   */
      v.add(doc.createElement("BTNSELECCION"));
      ((Element)v.get(449)).setAttribute("normal","btnLista2N.gif" );
      ((Element)v.get(449)).setAttribute("rollOver","btnLista2S.gif" );
      ((Element)v.get(449)).setAttribute("seleccionado","btnLista2M.gif" );
      ((Element)v.get(449)).setAttribute("desactivado","btnLista2D.gif" );
      ((Element)v.get(448)).appendChild((Element)v.get(449));
      /* Termina nodo:449   */

      /* Empieza nodo:450 / Elemento padre: 448   */
      v.add(doc.createElement("BTNMINIMIZAR"));
      ((Element)v.get(450)).setAttribute("minimizar","bot_pliega_columna_on.gif" );
      ((Element)v.get(450)).setAttribute("minimROver","bot_pliega_columna_over.gif" );
      ((Element)v.get(450)).setAttribute("maximizar","bot_despliega_columna_on.gif" );
   }

   private void getXML2070(Document doc) {
      ((Element)v.get(450)).setAttribute("maximROver","bot_despliega_columna_over.gif" );
      ((Element)v.get(448)).appendChild((Element)v.get(450));
      /* Termina nodo:450   */
      /* Termina nodo:448   */

      /* Empieza nodo:451 / Elemento padre: 447   */
      v.add(doc.createElement("LINEAS"));
      ((Element)v.get(447)).appendChild((Element)v.get(451));

      /* Empieza nodo:452 / Elemento padre: 451   */
      v.add(doc.createElement("GROSOR"));
      ((Element)v.get(452)).setAttribute("borde","1" );
      ((Element)v.get(452)).setAttribute("horizDatos","1" );
      ((Element)v.get(452)).setAttribute("horizCabecera","1" );
      ((Element)v.get(452)).setAttribute("vertical","1" );
      ((Element)v.get(452)).setAttribute("horizTitulo","1" );
      ((Element)v.get(452)).setAttribute("horizBase","1" );
      ((Element)v.get(451)).appendChild((Element)v.get(452));
      /* Termina nodo:452   */

      /* Empieza nodo:453 / Elemento padre: 451   */
      v.add(doc.createElement("COLOR"));
      ((Element)v.get(453)).setAttribute("borde","#999999" );
      ((Element)v.get(453)).setAttribute("vertCabecera","#E0E0E0" );
      ((Element)v.get(453)).setAttribute("vertDatos","#FFFFFF" );
      ((Element)v.get(453)).setAttribute("horizDatos","#FFFFFF" );
      ((Element)v.get(453)).setAttribute("horizCabecera","#999999" );
      ((Element)v.get(453)).setAttribute("horizTitulo","#999999" );
      ((Element)v.get(453)).setAttribute("horizBase","#999999" );
      ((Element)v.get(451)).appendChild((Element)v.get(453));
      /* Termina nodo:453   */
      /* Termina nodo:451   */

      /* Empieza nodo:454 / Elemento padre: 447   */
      v.add(doc.createElement("TITULO"));
      ((Element)v.get(454)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(454)).setAttribute("alto","22" );
      ((Element)v.get(454)).setAttribute("imgFondo","" );
      ((Element)v.get(454)).setAttribute("cod","00135" );
      ((Element)v.get(454)).setAttribute("ID","datosTitle" );
      ((Element)v.get(447)).appendChild((Element)v.get(454));
      /* Termina nodo:454   */

      /* Empieza nodo:455 / Elemento padre: 447   */
      v.add(doc.createElement("BASE"));
      ((Element)v.get(455)).setAttribute("colFondo","#CECFCE" );
      ((Element)v.get(455)).setAttribute("alto","22" );
      ((Element)v.get(455)).setAttribute("imgFondo","" );
      ((Element)v.get(447)).appendChild((Element)v.get(455));
      /* Termina nodo:455   */

      /* Empieza nodo:456 / Elemento padre: 447   */
      v.add(doc.createElement("COLUMNAS"));
      ((Element)v.get(456)).setAttribute("ajustarMinimo","S" );
      ((Element)v.get(456)).setAttribute("permiteOrdenar","S" );
      ((Element)v.get(456)).setAttribute("blancosAInsertar","1" );
      ((Element)v.get(456)).setAttribute("sinSaltoLinea","S" );
      ((Element)v.get(456)).setAttribute("AnchoMinimizadas","20" );
      ((Element)v.get(447)).appendChild((Element)v.get(456));

      /* Empieza nodo:457 / Elemento padre: 456   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(457)).setAttribute("ancho","100" );
      ((Element)v.get(457)).setAttribute("minimizable","S" );
      ((Element)v.get(457)).setAttribute("minimizada","N" );
      ((Element)v.get(456)).appendChild((Element)v.get(457));
      /* Termina nodo:457   */

      /* Empieza nodo:458 / Elemento padre: 456   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(458)).setAttribute("ancho","100" );
      ((Element)v.get(458)).setAttribute("minimizable","S" );
      ((Element)v.get(458)).setAttribute("minimizada","N" );
      ((Element)v.get(456)).appendChild((Element)v.get(458));
      /* Termina nodo:458   */

      /* Empieza nodo:459 / Elemento padre: 456   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(459)).setAttribute("ancho","100" );
      ((Element)v.get(459)).setAttribute("minimizable","S" );
      ((Element)v.get(459)).setAttribute("minimizada","N" );
      ((Element)v.get(456)).appendChild((Element)v.get(459));
      /* Termina nodo:459   */

      /* Empieza nodo:460 / Elemento padre: 456   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(460)).setAttribute("ancho","100" );
      ((Element)v.get(460)).setAttribute("minimizable","S" );
      ((Element)v.get(460)).setAttribute("minimizada","N" );
      ((Element)v.get(456)).appendChild((Element)v.get(460));
      /* Termina nodo:460   */

      /* Empieza nodo:461 / Elemento padre: 456   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(461)).setAttribute("ancho","100" );
      ((Element)v.get(461)).setAttribute("minimizable","S" );
      ((Element)v.get(461)).setAttribute("minimizada","N" );
      ((Element)v.get(456)).appendChild((Element)v.get(461));
      /* Termina nodo:461   */

      /* Empieza nodo:462 / Elemento padre: 456   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(462)).setAttribute("ancho","100" );
      ((Element)v.get(462)).setAttribute("minimizable","S" );
      ((Element)v.get(462)).setAttribute("minimizada","N" );
      ((Element)v.get(456)).appendChild((Element)v.get(462));
      /* Termina nodo:462   */

      /* Empieza nodo:463 / Elemento padre: 456   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(463)).setAttribute("ancho","100" );
      ((Element)v.get(463)).setAttribute("minimizable","S" );
      ((Element)v.get(463)).setAttribute("minimizada","N" );
      ((Element)v.get(456)).appendChild((Element)v.get(463));
      /* Termina nodo:463   */

      /* Empieza nodo:464 / Elemento padre: 456   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(464)).setAttribute("ancho","100" );
      ((Element)v.get(464)).setAttribute("minimizable","S" );
      ((Element)v.get(464)).setAttribute("minimizada","N" );
      ((Element)v.get(456)).appendChild((Element)v.get(464));
      /* Termina nodo:464   */

      /* Empieza nodo:465 / Elemento padre: 456   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(465)).setAttribute("ancho","100" );
      ((Element)v.get(465)).setAttribute("minimizable","S" );
      ((Element)v.get(465)).setAttribute("minimizada","N" );
      ((Element)v.get(456)).appendChild((Element)v.get(465));
      /* Termina nodo:465   */

      /* Empieza nodo:466 / Elemento padre: 456   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(466)).setAttribute("ancho","100" );
      ((Element)v.get(466)).setAttribute("minimizable","S" );
      ((Element)v.get(466)).setAttribute("minimizada","N" );
      ((Element)v.get(456)).appendChild((Element)v.get(466));
      /* Termina nodo:466   */

      /* Empieza nodo:467 / Elemento padre: 456   */
   }

   private void getXML2160(Document doc) {
      v.add(doc.createElement("COL"));
      ((Element)v.get(467)).setAttribute("ancho","100" );
      ((Element)v.get(467)).setAttribute("minimizable","S" );
      ((Element)v.get(467)).setAttribute("minimizada","N" );
      ((Element)v.get(456)).appendChild((Element)v.get(467));
      /* Termina nodo:467   */

      /* Empieza nodo:468 / Elemento padre: 456   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(468)).setAttribute("ancho","100" );
      ((Element)v.get(468)).setAttribute("minimizable","S" );
      ((Element)v.get(468)).setAttribute("minimizada","N" );
      ((Element)v.get(456)).appendChild((Element)v.get(468));
      /* Termina nodo:468   */
      /* Termina nodo:456   */

      /* Empieza nodo:469 / Elemento padre: 447   */
      v.add(doc.createElement("CABECERA"));
      ((Element)v.get(469)).setAttribute("height","20" );
      ((Element)v.get(469)).setAttribute("IDScroll","EstCab" );
      ((Element)v.get(469)).setAttribute("imgFondo","" );
      ((Element)v.get(469)).setAttribute("colFondo","#CCCCCC" );
      ((Element)v.get(447)).appendChild((Element)v.get(469));

      /* Empieza nodo:470 / Elemento padre: 469   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(470)).setAttribute("colFondo","" );
      ((Element)v.get(470)).setAttribute("ID","EstCab" );
      ((Element)v.get(470)).setAttribute("cod","ZonSubGerenVenta.paisOidPais.label" );
      ((Element)v.get(469)).appendChild((Element)v.get(470));
      /* Termina nodo:470   */

      /* Empieza nodo:471 / Elemento padre: 469   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(471)).setAttribute("colFondo","" );
      ((Element)v.get(471)).setAttribute("ID","EstCab" );
      ((Element)v.get(471)).setAttribute("cod","ZonSubGerenVenta.marcOidMarc.label" );
      ((Element)v.get(469)).appendChild((Element)v.get(471));
      /* Termina nodo:471   */

      /* Empieza nodo:472 / Elemento padre: 469   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(472)).setAttribute("colFondo","" );
      ((Element)v.get(472)).setAttribute("ID","EstCab" );
      ((Element)v.get(472)).setAttribute("cod","ZonSubGerenVenta.canaOidCana.label" );
      ((Element)v.get(469)).appendChild((Element)v.get(472));
      /* Termina nodo:472   */

      /* Empieza nodo:473 / Elemento padre: 469   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(473)).setAttribute("colFondo","" );
      ((Element)v.get(473)).setAttribute("ID","EstCab" );
      ((Element)v.get(473)).setAttribute("cod","ZonSubGerenVenta.codSubgVent.label" );
      ((Element)v.get(469)).appendChild((Element)v.get(473));
      /* Termina nodo:473   */

      /* Empieza nodo:474 / Elemento padre: 469   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(474)).setAttribute("colFondo","" );
      ((Element)v.get(474)).setAttribute("ID","EstCab" );
      ((Element)v.get(474)).setAttribute("cod","ZonSubGerenVenta.indBorr.label" );
      ((Element)v.get(469)).appendChild((Element)v.get(474));
      /* Termina nodo:474   */

      /* Empieza nodo:475 / Elemento padre: 469   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(475)).setAttribute("colFondo","" );
      ((Element)v.get(475)).setAttribute("ID","EstCab" );
      ((Element)v.get(475)).setAttribute("cod","ZonSubGerenVenta.indActi.label" );
      ((Element)v.get(469)).appendChild((Element)v.get(475));
      /* Termina nodo:475   */

      /* Empieza nodo:476 / Elemento padre: 469   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(476)).setAttribute("colFondo","" );
      ((Element)v.get(476)).setAttribute("ID","EstCab" );
      ((Element)v.get(476)).setAttribute("cod","ZonSubGerenVenta.codNse1.label" );
      ((Element)v.get(469)).appendChild((Element)v.get(476));
      /* Termina nodo:476   */

      /* Empieza nodo:477 / Elemento padre: 469   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(477)).setAttribute("colFondo","" );
      ((Element)v.get(477)).setAttribute("ID","EstCab" );
      ((Element)v.get(477)).setAttribute("cod","ZonSubGerenVenta.codNse2.label" );
      ((Element)v.get(469)).appendChild((Element)v.get(477));
      /* Termina nodo:477   */

      /* Empieza nodo:478 / Elemento padre: 469   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(478)).setAttribute("colFondo","" );
      ((Element)v.get(478)).setAttribute("ID","EstCab" );
      ((Element)v.get(478)).setAttribute("cod","ZonSubGerenVenta.codNse3.label" );
      ((Element)v.get(469)).appendChild((Element)v.get(478));
      /* Termina nodo:478   */

      /* Empieza nodo:479 / Elemento padre: 469   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(479)).setAttribute("colFondo","" );
      ((Element)v.get(479)).setAttribute("ID","EstCab" );
      ((Element)v.get(479)).setAttribute("cod","ZonSubGerenVenta.desSubgVent.label" );
      ((Element)v.get(469)).appendChild((Element)v.get(479));
      /* Termina nodo:479   */

      /* Empieza nodo:480 / Elemento padre: 469   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(480)).setAttribute("colFondo","" );
      ((Element)v.get(480)).setAttribute("ID","EstCab" );
      ((Element)v.get(480)).setAttribute("cod","ZonSubGerenVenta.clieOidClie.label" );
      ((Element)v.get(469)).appendChild((Element)v.get(480));
      /* Termina nodo:480   */

      /* Empieza nodo:481 / Elemento padre: 469   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(481)).setAttribute("colFondo","" );
      ((Element)v.get(481)).setAttribute("ID","EstCab" );
      ((Element)v.get(481)).setAttribute("cod","ZonSubGerenVenta.fecRezo.label" );
      ((Element)v.get(469)).appendChild((Element)v.get(481));
      /* Termina nodo:481   */
      /* Termina nodo:469   */

      /* Empieza nodo:482 / Elemento padre: 447   */
      v.add(doc.createElement("DATOS"));
      ((Element)v.get(482)).setAttribute("alto","22" );
      ((Element)v.get(482)).setAttribute("accion","" );
      ((Element)v.get(482)).setAttribute("tipoEnvio","seleccion" );
      ((Element)v.get(482)).setAttribute("formaEnvio","xml" );
      ((Element)v.get(482)).setAttribute("maxSel","1" );
      ((Element)v.get(482)).setAttribute("msgErrMaxSel","" );
      ((Element)v.get(482)).setAttribute("coloresScrollNativo","#D4D0C8,black,white,#D4D0C8,#D4D0C8,#ECE9E4,black" );
      ((Element)v.get(482)).setAttribute("colorROver","#D0D9E8" );
      ((Element)v.get(482)).setAttribute("onLoad","" );
      ((Element)v.get(482)).setAttribute("colorSelecc","#D0D9E8" );
      ((Element)v.get(447)).appendChild((Element)v.get(482));

      /* Empieza nodo:483 / Elemento padre: 482   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(483)).setAttribute("tipo","texto" );
   }

   private void getXML2250(Document doc) {
      ((Element)v.get(483)).setAttribute("ID","EstDat" );
      ((Element)v.get(482)).appendChild((Element)v.get(483));
      /* Termina nodo:483   */

      /* Empieza nodo:484 / Elemento padre: 482   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(484)).setAttribute("tipo","texto" );
      ((Element)v.get(484)).setAttribute("ID","EstDat2" );
      ((Element)v.get(482)).appendChild((Element)v.get(484));
      /* Termina nodo:484   */

      /* Empieza nodo:485 / Elemento padre: 482   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(485)).setAttribute("tipo","texto" );
      ((Element)v.get(485)).setAttribute("ID","EstDat" );
      ((Element)v.get(482)).appendChild((Element)v.get(485));
      /* Termina nodo:485   */

      /* Empieza nodo:486 / Elemento padre: 482   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(486)).setAttribute("tipo","texto" );
      ((Element)v.get(486)).setAttribute("ID","EstDat2" );
      ((Element)v.get(482)).appendChild((Element)v.get(486));
      /* Termina nodo:486   */

      /* Empieza nodo:487 / Elemento padre: 482   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(487)).setAttribute("tipo","texto" );
      ((Element)v.get(487)).setAttribute("ID","EstDat" );
      ((Element)v.get(482)).appendChild((Element)v.get(487));
      /* Termina nodo:487   */

      /* Empieza nodo:488 / Elemento padre: 482   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(488)).setAttribute("tipo","texto" );
      ((Element)v.get(488)).setAttribute("ID","EstDat2" );
      ((Element)v.get(482)).appendChild((Element)v.get(488));
      /* Termina nodo:488   */

      /* Empieza nodo:489 / Elemento padre: 482   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(489)).setAttribute("tipo","texto" );
      ((Element)v.get(489)).setAttribute("ID","EstDat" );
      ((Element)v.get(482)).appendChild((Element)v.get(489));
      /* Termina nodo:489   */

      /* Empieza nodo:490 / Elemento padre: 482   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(490)).setAttribute("tipo","texto" );
      ((Element)v.get(490)).setAttribute("ID","EstDat2" );
      ((Element)v.get(482)).appendChild((Element)v.get(490));
      /* Termina nodo:490   */

      /* Empieza nodo:491 / Elemento padre: 482   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(491)).setAttribute("tipo","texto" );
      ((Element)v.get(491)).setAttribute("ID","EstDat" );
      ((Element)v.get(482)).appendChild((Element)v.get(491));
      /* Termina nodo:491   */

      /* Empieza nodo:492 / Elemento padre: 482   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(492)).setAttribute("tipo","texto" );
      ((Element)v.get(492)).setAttribute("ID","EstDat2" );
      ((Element)v.get(482)).appendChild((Element)v.get(492));
      /* Termina nodo:492   */

      /* Empieza nodo:493 / Elemento padre: 482   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(493)).setAttribute("tipo","texto" );
      ((Element)v.get(493)).setAttribute("ID","EstDat" );
      ((Element)v.get(482)).appendChild((Element)v.get(493));
      /* Termina nodo:493   */

      /* Empieza nodo:494 / Elemento padre: 482   */
      v.add(doc.createElement("COL"));
      ((Element)v.get(494)).setAttribute("tipo","texto" );
      ((Element)v.get(494)).setAttribute("ID","EstDat2" );
      ((Element)v.get(482)).appendChild((Element)v.get(494));
      /* Termina nodo:494   */
      /* Termina nodo:482   */

      /* Empieza nodo:495 / Elemento padre: 447   */
      v.add(doc.createElement("ROWSET"));
      ((Element)v.get(447)).appendChild((Element)v.get(495));
      /* Termina nodo:495   */
      /* Termina nodo:447   */
      /* Termina nodo:446   */

      /* Empieza nodo:496 / Elemento padre: 4   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(496)).setAttribute("nombre","zonSubGerenVentaListButtonsLayer" );
      ((Element)v.get(496)).setAttribute("visibilidad","hidden" );
      ((Element)v.get(496)).setAttribute("alto","30" );
      ((Element)v.get(496)).setAttribute("ancho","98%" );
      ((Element)v.get(496)).setAttribute("borde","n" );
      ((Element)v.get(496)).setAttribute("imagenf","" );
      ((Element)v.get(496)).setAttribute("repeat","" );
      ((Element)v.get(496)).setAttribute("padding","0" );
      ((Element)v.get(496)).setAttribute("contravsb","" );
      ((Element)v.get(496)).setAttribute("x","16" );
      ((Element)v.get(496)).setAttribute("y","" );
      ((Element)v.get(496)).setAttribute("zindex","" );
      ((Element)v.get(4)).appendChild((Element)v.get(496));

      /* Empieza nodo:497 / Elemento padre: 496   */
      v.add(doc.createElement("CAPA"));
      ((Element)v.get(497)).setAttribute("nombre","toolbarSeparatorLayer" );
      ((Element)v.get(497)).setAttribute("visibilidad","inherit" );
      ((Element)v.get(497)).setAttribute("alto","23" );
      ((Element)v.get(497)).setAttribute("ancho","1" );
      ((Element)v.get(497)).setAttribute("borde","1" );
      ((Element)v.get(497)).setAttribute("imagenf","" );
      ((Element)v.get(497)).setAttribute("repeat","" );
      ((Element)v.get(497)).setAttribute("padding","0" );
      ((Element)v.get(497)).setAttribute("contravsb","" );
      ((Element)v.get(497)).setAttribute("x","56" );
      ((Element)v.get(497)).setAttribute("y","0" );
      ((Element)v.get(497)).setAttribute("zindex","" );
      ((Element)v.get(497)).setAttribute("colborde","#999999" );
      ((Element)v.get(496)).appendChild((Element)v.get(497));
      /* Termina nodo:497   */

      /* Empieza nodo:498 / Elemento padre: 496   */
      v.add(doc.createElement("TABLE"));
      ((Element)v.get(498)).setAttribute("width","100%" );
      ((Element)v.get(498)).setAttribute("border","0" );
      ((Element)v.get(498)).setAttribute("cellspacing","1" );
      ((Element)v.get(498)).setAttribute("cellpadding","0" );
      ((Element)v.get(496)).appendChild((Element)v.get(498));

      /* Empieza nodo:499 / Elemento padre: 498   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(498)).appendChild((Element)v.get(499));

      /* Empieza nodo:500 / Elemento padre: 499   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(500)).setAttribute("src","b.gif" );
      ((Element)v.get(500)).setAttribute("height","22" );
      ((Element)v.get(500)).setAttribute("width","5" );
      ((Element)v.get(499)).appendChild((Element)v.get(500));
      /* Termina nodo:500   */
      /* Termina nodo:499   */

      /* Empieza nodo:501 / Elemento padre: 498   */
   }

   private void getXML2340(Document doc) {
      v.add(doc.createElement("TD"));
      ((Element)v.get(498)).appendChild((Element)v.get(501));

      /* Empieza nodo:502 / Elemento padre: 501   */
      v.add(doc.createElement("BOTONERA"));
      ((Element)v.get(502)).setAttribute("nombre","zonSubGerenVentaPaginationButtonBar" );
      ((Element)v.get(502)).setAttribute("tipo","H" );
      ((Element)v.get(502)).setAttribute("x","0" );
      ((Element)v.get(502)).setAttribute("y","0" );
      ((Element)v.get(501)).appendChild((Element)v.get(502));

      /* Empieza nodo:503 / Elemento padre: 502   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(503)).setAttribute("nombre","zonSubGerenVentaFirstPageButton" );
      ((Element)v.get(503)).setAttribute("funcion","zonSubGerenVentaFirstPage();" );
      ((Element)v.get(503)).setAttribute("off","primera_over0.gif" );
      ((Element)v.get(503)).setAttribute("on","primera_over0.gif" );
      ((Element)v.get(503)).setAttribute("disable","primera_on0.gif" );
      ((Element)v.get(503)).setAttribute("estado","inactivo" );
      ((Element)v.get(502)).appendChild((Element)v.get(503));
      /* Termina nodo:503   */

      /* Empieza nodo:504 / Elemento padre: 502   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(504)).setAttribute("nombre","zonSubGerenVentaFirstPageButtonGapTd" );
      ((Element)v.get(502)).appendChild((Element)v.get(504));

      /* Empieza nodo:505 / Elemento padre: 504   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(505)).setAttribute("src","b.gif" );
      ((Element)v.get(505)).setAttribute("height","8" );
      ((Element)v.get(505)).setAttribute("width","5" );
      ((Element)v.get(504)).appendChild((Element)v.get(505));
      /* Termina nodo:505   */
      /* Termina nodo:504   */

      /* Empieza nodo:506 / Elemento padre: 502   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(506)).setAttribute("nombre","zonSubGerenVentaPreviousPageButton" );
      ((Element)v.get(506)).setAttribute("funcion","zonSubGerenVentaPreviousPage();" );
      ((Element)v.get(506)).setAttribute("off","retroceder_over0.gif" );
      ((Element)v.get(506)).setAttribute("on","retroceder_over0.gif" );
      ((Element)v.get(506)).setAttribute("disable","retroceder_on0.gif" );
      ((Element)v.get(506)).setAttribute("estado","inactivo" );
      ((Element)v.get(502)).appendChild((Element)v.get(506));
      /* Termina nodo:506   */

      /* Empieza nodo:507 / Elemento padre: 502   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(507)).setAttribute("nombre","zonSubGerenVentaPreviousPageButtonGapTd" );
      ((Element)v.get(502)).appendChild((Element)v.get(507));

      /* Empieza nodo:508 / Elemento padre: 507   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(508)).setAttribute("src","b.gif" );
      ((Element)v.get(508)).setAttribute("height","8" );
      ((Element)v.get(508)).setAttribute("width","8" );
      ((Element)v.get(507)).appendChild((Element)v.get(508));
      /* Termina nodo:508   */
      /* Termina nodo:507   */

      /* Empieza nodo:509 / Elemento padre: 502   */
      v.add(doc.createElement("BTN"));
      ((Element)v.get(509)).setAttribute("nombre","zonSubGerenVentaNextPageButton" );
      ((Element)v.get(509)).setAttribute("funcion","zonSubGerenVentaNextPage();" );
      ((Element)v.get(509)).setAttribute("off","avanzar_over0.gif" );
      ((Element)v.get(509)).setAttribute("on","avanzar_over0.gif" );
      ((Element)v.get(509)).setAttribute("disable","avanzar_on0.gif" );
      ((Element)v.get(509)).setAttribute("estado","inactivo" );
      ((Element)v.get(502)).appendChild((Element)v.get(509));
      /* Termina nodo:509   */
      /* Termina nodo:502   */
      /* Termina nodo:501   */

      /* Empieza nodo:510 / Elemento padre: 498   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(498)).appendChild((Element)v.get(510));

      /* Empieza nodo:511 / Elemento padre: 510   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(511)).setAttribute("src","b.gif" );
      ((Element)v.get(511)).setAttribute("height","22" );
      ((Element)v.get(511)).setAttribute("width","19" );
      ((Element)v.get(510)).appendChild((Element)v.get(511));
      /* Termina nodo:511   */
      /* Termina nodo:510   */

      /* Empieza nodo:512 / Elemento padre: 498   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(512)).setAttribute("class","tablaTitle" );
      ((Element)v.get(512)).setAttribute("nombre","zonSubGerenVentaUpdateButtonTd" );
      ((Element)v.get(498)).appendChild((Element)v.get(512));

      /* Empieza nodo:513 / Elemento padre: 512   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(513)).setAttribute("nombre","zonSubGerenVentaUpdateButton" );
      ((Element)v.get(513)).setAttribute("ID","botonContenido" );
      ((Element)v.get(513)).setAttribute("tipo","html" );
      ((Element)v.get(513)).setAttribute("accion","zonSubGerenVentaUpdateSelection();" );
      ((Element)v.get(513)).setAttribute("estado","false" );
      ((Element)v.get(513)).setAttribute("cod","MMGGlobal.updateButton.label" );
      ((Element)v.get(512)).appendChild((Element)v.get(513));
      /* Termina nodo:513   */
      /* Termina nodo:512   */

      /* Empieza nodo:514 / Elemento padre: 498   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(514)).setAttribute("nombre","zonSubGerenVentaUpdateButtonGapTd" );
      ((Element)v.get(498)).appendChild((Element)v.get(514));

      /* Empieza nodo:515 / Elemento padre: 514   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(515)).setAttribute("src","b.gif" );
      ((Element)v.get(515)).setAttribute("height","8" );
      ((Element)v.get(515)).setAttribute("width","10" );
      ((Element)v.get(514)).appendChild((Element)v.get(515));
      /* Termina nodo:515   */
      /* Termina nodo:514   */

      /* Empieza nodo:516 / Elemento padre: 498   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(516)).setAttribute("class","tablaTitle" );
      ((Element)v.get(516)).setAttribute("nombre","zonSubGerenVentaViewForRemoveButtonTd" );
      ((Element)v.get(498)).appendChild((Element)v.get(516));

      /* Empieza nodo:517 / Elemento padre: 516   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(517)).setAttribute("nombre","zonSubGerenVentaViewForRemoveButton" );
      ((Element)v.get(517)).setAttribute("ID","botonContenido" );
      ((Element)v.get(517)).setAttribute("tipo","html" );
      ((Element)v.get(517)).setAttribute("accion","zonSubGerenVentaViewSelection();" );
      ((Element)v.get(517)).setAttribute("estado","false" );
      ((Element)v.get(517)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(516)).appendChild((Element)v.get(517));
      /* Termina nodo:517   */
      /* Termina nodo:516   */

      /* Empieza nodo:518 / Elemento padre: 498   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(518)).setAttribute("nombre","zonSubGerenVentaViewForRemoveButtonGapTd" );
      ((Element)v.get(498)).appendChild((Element)v.get(518));

      /* Empieza nodo:519 / Elemento padre: 518   */
   }

   private void getXML2430(Document doc) {
      v.add(doc.createElement("IMG"));
      ((Element)v.get(519)).setAttribute("src","b.gif" );
      ((Element)v.get(519)).setAttribute("height","8" );
      ((Element)v.get(519)).setAttribute("width","10" );
      ((Element)v.get(518)).appendChild((Element)v.get(519));
      /* Termina nodo:519   */
      /* Termina nodo:518   */

      /* Empieza nodo:520 / Elemento padre: 498   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(520)).setAttribute("class","tablaTitle" );
      ((Element)v.get(520)).setAttribute("nombre","zonSubGerenVentaLovSelectButtonTd" );
      ((Element)v.get(498)).appendChild((Element)v.get(520));

      /* Empieza nodo:521 / Elemento padre: 520   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(521)).setAttribute("nombre","zonSubGerenVentaLovSelectButton" );
      ((Element)v.get(521)).setAttribute("ID","botonContenido" );
      ((Element)v.get(521)).setAttribute("tipo","html" );
      ((Element)v.get(521)).setAttribute("accion","zonSubGerenVentaLovSelectionAction();" );
      ((Element)v.get(521)).setAttribute("estado","true" );
      ((Element)v.get(521)).setAttribute("cod","MMGGlobal.lovSelectButton.label" );
      ((Element)v.get(520)).appendChild((Element)v.get(521));
      /* Termina nodo:521   */
      /* Termina nodo:520   */

      /* Empieza nodo:522 / Elemento padre: 498   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(522)).setAttribute("nombre","zonSubGerenVentaLovSelectButtonGapTd" );
      ((Element)v.get(498)).appendChild((Element)v.get(522));

      /* Empieza nodo:523 / Elemento padre: 522   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(523)).setAttribute("src","b.gif" );
      ((Element)v.get(523)).setAttribute("height","8" );
      ((Element)v.get(523)).setAttribute("width","10" );
      ((Element)v.get(522)).appendChild((Element)v.get(523));
      /* Termina nodo:523   */
      /* Termina nodo:522   */

      /* Empieza nodo:524 / Elemento padre: 498   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(524)).setAttribute("class","tablaTitle" );
      ((Element)v.get(524)).setAttribute("nombre","zonSubGerenVentaViewButtonTd" );
      ((Element)v.get(498)).appendChild((Element)v.get(524));

      /* Empieza nodo:525 / Elemento padre: 524   */
      v.add(doc.createElement("BOTON"));
      ((Element)v.get(525)).setAttribute("nombre","zonSubGerenVentaViewButton" );
      ((Element)v.get(525)).setAttribute("ID","botonContenido" );
      ((Element)v.get(525)).setAttribute("tipo","html" );
      ((Element)v.get(525)).setAttribute("accion","zonSubGerenVentaViewSelection();" );
      ((Element)v.get(525)).setAttribute("estado","false" );
      ((Element)v.get(525)).setAttribute("cod","MMGGlobal.viewButton.label" );
      ((Element)v.get(524)).appendChild((Element)v.get(525));
      /* Termina nodo:525   */
      /* Termina nodo:524   */

      /* Empieza nodo:526 / Elemento padre: 498   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(526)).setAttribute("nombre","zonSubGerenVentaViewButtonGapTd" );
      ((Element)v.get(498)).appendChild((Element)v.get(526));

      /* Empieza nodo:527 / Elemento padre: 526   */
      v.add(doc.createElement("IMG"));
      ((Element)v.get(527)).setAttribute("src","b.gif" );
      ((Element)v.get(527)).setAttribute("height","8" );
      ((Element)v.get(527)).setAttribute("width","10" );
      ((Element)v.get(526)).appendChild((Element)v.get(527));
      /* Termina nodo:527   */
      /* Termina nodo:526   */

      /* Empieza nodo:528 / Elemento padre: 498   */
      v.add(doc.createElement("TD"));
      ((Element)v.get(528)).setAttribute("width","100%" );
      ((Element)v.get(498)).appendChild((Element)v.get(528));
      /* Termina nodo:528   */
      /* Termina nodo:498   */
      /* Termina nodo:496   */
      /* Termina nodo:4   */


   }

}
